package com.example.designpattern.SplitWise.Stratergy;

import java.util.ArrayList;
import java.util.List;

import com.example.designpattern.SplitWise.Models.Split;
import com.example.designpattern.SplitWise.Models.User;

public class PercentageSplitStratergy implements SplitStratergy {

    @Override
    public List<Split> calculateSplits(double totalAmount, List<User> participants, List<Double> splitValues) {
        if (participants.size() != splitValues.size()) {
            throw new IllegalArgumentException("Number of participants and split values must match.");
        }
        double totalPercentage = splitValues.stream().mapToDouble(Double::doubleValue).sum();
        if( (totalPercentage - 100.0 > 0.01) || (totalPercentage - 100.0) < -0.01) {
            throw new IllegalArgumentException("Sum of percentages must be 100.");
        }
        List<Split> splitList = new ArrayList<>();
        for(int i=0; i<participants.size(); i++){
            Split newSplit = new Split(participants.get(i), totalAmount * splitValues.get(i) / 100.0);
            splitList.add(newSplit);
        }
        return splitList;
    }
    
}
