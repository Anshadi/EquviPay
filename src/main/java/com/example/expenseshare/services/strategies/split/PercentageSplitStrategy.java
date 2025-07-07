package com.example.expenseshare.services.strategies.split;

import com.example.expenseshare.models.Expense;
import com.example.expenseshare.models.Split;
import com.example.expenseshare.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("PERCENTAGE")
public class PercentageSplitStrategy implements SplitStrategy {
    
    @Override
    public List<Split> calculateSplits(Expense expense, List<User> users, Map<Long, Double> paidMap, Map<Long, Double> percentageMap) {
        // Validate that percentages add up to 100
        double totalPercentage = percentageMap.values().stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalPercentage - 100.0) > 0.01) {
            throw new IllegalArgumentException("Percentages must add up to 100%. Current total: " + totalPercentage);
        }
        
        return users.stream()
                .map(user -> {
                    double percentage = percentageMap.getOrDefault(user.getId(), 0.0);
                    double owedAmount = (expense.getTotalAmount() * percentage) / 100.0;
                    double paidAmount = paidMap.getOrDefault(user.getId(), 0.0);
                    
                    return Split.builder()
                            .expense(expense)
                            .user(user)
                            .paid(paidAmount)
                            .owed(owedAmount)
                            .build();
                })
                .collect(Collectors.toList());
    }
}
