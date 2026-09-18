package com.example.designpattern.SplitWise.Stratergy;

import java.util.List;

import com.example.designpattern.SplitWise.Models.Split;
import com.example.designpattern.SplitWise.Models.User;

public interface SplitStratergy {
    List<Split> calculateSplits(double totalAmount, List<User> participants, List<Double> splitValues);
}
