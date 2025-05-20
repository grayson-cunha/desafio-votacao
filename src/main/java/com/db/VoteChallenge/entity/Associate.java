package com.db.VoteChallenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Associate {
    private Long id;

    private String name;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Associate(String name) {
        this.name = name;
    }
}
