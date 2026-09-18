package com.example.designpattern.SplitWise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.example.designpattern.SplitWise.Models.Expense;
import com.example.designpattern.SplitWise.Models.Group;
import com.example.designpattern.SplitWise.Models.Split;
import com.example.designpattern.SplitWise.Models.Transaction;
import com.example.designpattern.SplitWise.Models.User;

public class SplitWiseService {
    private static SplitWiseService instance;
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();

    private SplitWiseService() {}

    public static synchronized SplitWiseService getInstance() {
        if (instance == null) {
            instance = new SplitWiseService();
        }
        return instance;
    }
    public User addUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }
    public Group addGroup(String name, HashSet<User> members) {
        Group group = new Group(name, members);
        groups.put(group.getId(), group);
        return group;
    }
    public User getUser(String id) { return users.get(id); }
    public Group getGroup(String id) { return groups.get(id); }

    public synchronized void addToBalanceSheets(Expense expense){
        User paidBy = expense.getPaidBy();
        for(Split split:expense.getSplits()){
            User participant = split.getUser();
            double amount = split.getAmount();

            if (!paidBy.equals(participant)) {
                paidBy.getBalanceSheet().adjustBalance(participant, amount);
                participant.getBalanceSheet().adjustBalance(paidBy, -amount);
            }
        }
        System.out.println("Expense '" + expense.getDescription() + "' of amount " + expense.getAmount() + " created.");
    }

    public synchronized void settleUp(String payerId, String payeeId, double amount) {
        User payer = users.get(payerId);
        User payee = users.get(payeeId);
        System.out.println(payer.getName() + " is settling up " + amount + " with " + payee.getName());
        // Settlement is like a reverse expense. payer owes less to payee.

        payee.getBalanceSheet().adjustBalance(payer, -amount);
        payer.getBalanceSheet().adjustBalance(payee, amount);
    }

    public void showBalanceSheet(String userId) {
        User user = users.get(userId);
        user.getBalanceSheet().showBalances();
    }

    public List<Transaction> simplyGroupBalances(String groupId){
        if(!groups.containsKey(groupId)) throw new IllegalArgumentException("Group not found");
        Group group = groups.get(groupId);
        HashMap<User, Double> netBalances = new HashMap<>();
        List<User> creditors = new ArrayList<>();
        List<User> debitors = new ArrayList<>();
        for(User user:group.getMembers()){
            double balance = 0;
            for(User balanceUser: user.getBalanceSheet().getBalance().keySet()){
                if(group.getMembers().contains(balanceUser)){
                    balance += user.getBalanceSheet().getBalance().get(balanceUser);
                }
            }
            netBalances.put(user, balance);
            if(balance>0) creditors.add(user);
            else debitors.add(user);
        }
        
        creditors.sort((a, b) -> Double.compare(netBalances.get(b), netBalances.get(a)));
        debitors.sort((a, b) -> Double.compare(netBalances.get(a), netBalances.get(b)));

        List<Transaction> transactions = new ArrayList<>();
        int i = 0, j = 0;
        while (i < creditors.size() && j < debitors.size()) {
            User creditor = creditors.get(i);
            User debitor = debitors.get(j);

            double creditVal = netBalances.get(creditor);
            double debitVal  = netBalances.get(debitor);
            double amountToSettle = Math.min(creditVal, -debitVal);
            transactions.add(new Transaction(debitor, creditor, amountToSettle));

            netBalances.put(creditor, creditVal - amountToSettle);
            netBalances.put(debitor, debitVal + amountToSettle);

            if (Math.abs(netBalances.get(creditor)) < 0.01) i++;
            if (Math.abs(netBalances.get(debitor)) < 0.01) j++;
        }
        return transactions;
    }

}
