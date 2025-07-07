package com.example.expenseshare.seeders;

import com.example.expenseshare.models.User;
import com.example.expenseshare.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            Date date = Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant());

            User u1 = User.builder().name("John Doe").phone("+1234567890").password("john123").build();
            User u2 = User.builder().name("Jane Smith").phone("+1234567891").password("jane123").build();
            User u3 = User.builder().name("Bob Johnson").phone("+1234567892").password("bob123").build();
            User u4 = User.builder().name("Alice Brown").phone("+1234567893").password("alice123").build();
            User u5 = User.builder().name("Charlie Wilson").phone("+1234567894").password("charlie123").build();
            User u6 = User.builder().name("Emma Davis").phone("+1234567895").password("emma123").build();

            u1.setCreatedAt(date);
            u1.setUpdatedAt(date);
            u2.setCreatedAt(date);
            u2.setUpdatedAt(date);
            u3.setCreatedAt(date);
            u3.setUpdatedAt(date);
            u4.setCreatedAt(date);
            u4.setUpdatedAt(date);
            u5.setCreatedAt(date);
            u5.setUpdatedAt(date);
            u6.setCreatedAt(date);
            u6.setUpdatedAt(date);

            List<User> users = List.of(
                    u1, u2, u3, u4, u5, u6
            );

            userRepository.saveAll(users);
            System.out.println("✅ Seeded test users");
        } else {
            System.out.println("ℹ️ Users already seeded");
        }
    }
}
