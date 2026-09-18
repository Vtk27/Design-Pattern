package com.example.designpattern.SplitWise.Stratergy;

import java.util.ArrayList;
import java.util.List;

import com.example.designpattern.SplitWise.Models.Split;
import com.example.designpattern.SplitWise.Models.User;

public class EqualSplitStratergy implements SplitStratergy {

    @Override
    public List<Split> calculateSplits(double totalAmount, List<User> participants, List<Double> splitValues) {
        List<Split> splits = new ArrayList<>();
        double amountPerPerson = totalAmount / participants.size();
        for (User participant : participants) {
            splits.add(new Split(participant, amountPerPerson));
        }
        return splits;
    }
    
}
