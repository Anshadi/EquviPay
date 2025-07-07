package com.example.expenseshare.controllers;

import com.example.expenseshare.dto.ExpenseRequestDTO;
import com.example.expenseshare.models.Expense;
import com.example.expenseshare.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public Expense addExpense(@RequestBody ExpenseRequestDTO request) {
        return expenseService.addExpenseWithStrategy(
                request.getExpense(),
                request.getPaidMap(),
                request.getPercentageMap()
        );
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getUserExpenses(@PathVariable Long userId) {
        return expenseService.getUserExpenses(userId);
    }
}