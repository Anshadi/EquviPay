package com.example.expenseshare.dto;

import com.example.expenseshare.models.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDTO {
    private User from;
    private User to;
    private Double amount;
}