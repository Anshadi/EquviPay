package com.example.expenseshare.repositories;

import com.example.expenseshare.models.Split;
import com.example.expenseshare.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SplitRepository extends JpaRepository<Split, Long> {
}