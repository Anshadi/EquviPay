package com.example.expenseshare.services;

import com.example.expenseshare.models.User;
import com.example.expenseshare.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public User createUser(User user) {
        user.setCreatedAt(Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant()));
        user.setUpdatedAt(Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant()));
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        User user = getUserById(userId);
        user.setName(userDetails.getName());
        user.setPhone(userDetails.getPhone());
        if (userDetails.getPassword() != null) {
            user.setPassword(userDetails.getPassword());
        }
        user.setUpdatedAt(Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant()));
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }
}
