package com.example.expenseshare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Split extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    @JsonBackReference // to avoid infinite recursion
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "paid", nullable = false)
    private Double paid;

    @Column(name = "owed", nullable = false)
    private Double owed;
}
