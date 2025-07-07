package com.example.expenseshare.controllers;

import com.example.expenseshare.models.ExpenseGroup;
import com.example.expenseshare.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseGroup> createGroup(@RequestParam String name,
                                                    @RequestParam Long creatorId,
                                                    @RequestBody List<Long> memberIds) {
        return ResponseEntity.ok(groupService.createGroup(name, creatorId, memberIds));
    }

    @PostMapping("/{groupId}/add")
    public ResponseEntity<ExpenseGroup> addMember(@PathVariable Long groupId,
                                                  @RequestParam Long creatorId,
                                                  @RequestParam Long userId) {
        return ResponseEntity.ok(groupService.addMember(groupId, creatorId, userId));
    }

    @DeleteMapping("/{groupId}/remove")
    public ResponseEntity<ExpenseGroup> removeMember(@PathVariable Long groupId,
                                                     @RequestParam Long creatorId,
                                                     @RequestParam Long userId) {
        return ResponseEntity.ok(groupService.removeMember(groupId, creatorId, userId));
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<ExpenseGroup> getGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroup(groupId));
    }
}
