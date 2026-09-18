package com.example.designpattern.SplitWise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.designpattern.SplitWise.Models.Expense;
import com.example.designpattern.SplitWise.Models.Group;
import com.example.designpattern.SplitWise.Models.Transaction;
import com.example.designpattern.SplitWise.Models.User;
import com.example.designpattern.SplitWise.Stratergy.CustomSplitStratergy;
import com.example.designpattern.SplitWise.Stratergy.EqualSplitStratergy;
import com.example.designpattern.SplitWise.Stratergy.PercentageSplitStratergy;

public class SplitWiseDemo {
    public static void main(String[] args) {
         // 1. Setup the service
        SplitWiseService service = SplitWiseService.getInstance();

        // 2. Create users and groups
        User alice = service.addUser("Alice");
        User bob = service.addUser( "Bob");
        User charlie = service.addUser("Charlie");
        User david = service.addUser("David");

        Group friendsGroup = service.addGroup("Friends Trip", new HashSet<>(Set.of(alice, bob, charlie, david)));

         System.out.println("--- System Setup Complete ---\n");

        // 3. Use Case 1: Equal Split
        System.out.println("--- Use Case 1: Equal Split ---");
        service.addToBalanceSheets(new Expense.ExpenseBuilder()
                .setDescription("Dinner")
                .setAmount(1000)
                .setPaidBy(alice)
                .setParticipants(Arrays.asList(alice, bob, charlie, david))
                .setSplitStrategy(new EqualSplitStratergy()).build());

        service.showBalanceSheet(alice.getId());
        service.showBalanceSheet(bob.getId());
        System.out.println();
        
         // 4. Use Case 2: Exact Split
        System.out.println("--- Use Case 2: Exact Split ---");
        service.addToBalanceSheets(new Expense.ExpenseBuilder()
                .setDescription("Movie Tickets")
                .setAmount(370)
                .setPaidBy(alice)
                .setParticipants(Arrays.asList(bob, charlie))
                .setSplitStrategy(new CustomSplitStratergy())
                .setSplitsValue(Arrays.asList(120.0, 250.0)).build()
        );

        service.showBalanceSheet(alice.getId());
        service.showBalanceSheet(bob.getId());
        System.out.println();

        // 5. Use Case 3: Percentage Split
        System.out.println("--- Use Case 3: Percentage Split ---");
        service.addToBalanceSheets(new Expense.ExpenseBuilder()
                .setDescription("Groceries")
                .setAmount(500)
                .setPaidBy(david)
                .setParticipants(Arrays.asList(alice, bob, charlie))
                .setSplitStrategy(new PercentageSplitStratergy())
                .setSplitsValue(Arrays.asList(40.0, 30.0, 30.0)).build() // 40%, 30%, 30%
        );
              System.out.println("--- Balances After All Expenses ---");
        service.showBalanceSheet(alice.getId());
        service.showBalanceSheet(bob.getId());

        service.showBalanceSheet(charlie.getId());
        service.showBalanceSheet(david.getId());

        System.out.println();

        // 6. Use Case 4: Simplify Group Debts
        System.out.println("--- Use Case 4: Simplify Group Debts for 'Friends Trip' ---");
        List<Transaction> simplifiedDebts = service.simplyGroupBalances(friendsGroup.getId());
        if (simplifiedDebts.isEmpty()) {
            System.out.println("All debts are settled within the group!");
        } else {
            simplifiedDebts.forEach(System.out::println);
        }
        System.out.println();

        service.showBalanceSheet(bob.getId());
         // 7. Use Case 5: Partial Settlement
        System.out.println("--- Use Case 5: Partial Settlement ---");
        // From the simplified debts, we see Bob should pay Alice. Let's say Bob pays 100.
        service.settleUp(bob.getId(), alice.getId(), 100);

        System.out.println("--- Balances After Partial Settlement ---");
        service.showBalanceSheet(alice.getId());
        service.showBalanceSheet(bob.getId());
    }
}
