package com.example.expenseshare.controllers;

import com.example.expenseshare.dto.BalanceDTO;
import com.example.expenseshare.services.SettleUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settleup")
@RequiredArgsConstructor
public class SettleUpController {

    private final SettleUpService settleUpService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BalanceDTO>> settleUser(@PathVariable Long userId) {
        return ResponseEntity.ok(settleUpService.settleUpUser(userId));
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<BalanceDTO>> settleGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(settleUpService.settleUpGroup(groupId));
    }
}
