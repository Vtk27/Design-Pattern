package com.example.designpattern.SplitWise.Stratergy;

import java.util.ArrayList;
import java.util.List;

import com.example.designpattern.SplitWise.Models.Split;
import com.example.designpattern.SplitWise.Models.User;

public class CustomSplitStratergy implements SplitStratergy {

    @Override
    public List<Split> calculateSplits(double totalAmount, List<User> participants, List<Double> splitValues) {
        if(participants.size() != splitValues.size()){
            throw new IllegalArgumentException("Number of participants and split values must match.");
        }
        double sumOfAmount = splitValues.stream().mapToDouble(Double::doubleValue).sum();
        // System.out.println(sumOfAmount);
        if((sumOfAmount-totalAmount)>0.01 || (sumOfAmount-totalAmount)<-0.01){
            throw new IllegalArgumentException("Sum of exact amounts must equal the total expense amount.");
        }
        List<Split> splitList = new ArrayList<>();
        for(int i=0; i<participants.size(); i++){
            Split newSplit = new Split(participants.get(i), splitValues.get(i));
            splitList.add(newSplit);
        }
        return splitList;
    }
    
}
