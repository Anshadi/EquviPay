package com.example.expenseshare.services.strategies.split;

import com.example.expenseshare.models.Expense;
import com.example.expenseshare.models.Split;
import com.example.expenseshare.models.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    List<Split> calculateSplits(Expense expense, List<User> users, Map<Long, Double> paidMap, Map<Long, Double> percentageMap);
}
