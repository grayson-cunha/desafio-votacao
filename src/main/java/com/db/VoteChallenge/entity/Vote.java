package com.db.VoteChallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isApproved;

    private Long voteSessionId;

    private Long associateId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Vote() {}

    public Vote(Boolean isApproved, Long voteSessionId, Long associateId) {
        this.isApproved = isApproved;
        this.voteSessionId = voteSessionId;
        this.associateId = associateId;
    }
}
