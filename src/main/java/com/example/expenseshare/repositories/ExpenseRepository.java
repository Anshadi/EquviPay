package com.example.expenseshare.repositories;

import com.example.expenseshare.models.Expense;
import com.example.expenseshare.models.Split;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}