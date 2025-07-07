package com.example.expenseshare.dto;

import com.example.expenseshare.models.Expense;
import lombok.Data;

import java.util.Map;

@Data
public class ExpenseRequestDTO {
    private Expense expense;
    private Map<Long, Double> paidMap;       // userId -> amount paid
    private Map<Long, Double> percentageMap; // userId -> percentage (only if PERCENTAGE split)
}