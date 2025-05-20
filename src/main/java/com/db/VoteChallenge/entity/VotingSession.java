package com.db.VoteChallenge.entity;

import com.db.VoteChallenge.common.constants.VotingConstants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class VotingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime duration;

    private Boolean isOpen;

    private String description;

    private Long votingTopicId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created_at;

    public VotingSession() {}

    public VotingSession(LocalDateTime duration, String description, Long votingTopicId) {
        this.duration = duration != null ? duration : VotingConstants.DURATION_DEFAULT_ONE_MINUTE;
        this.description = description;
        this.votingTopicId = votingTopicId;
        this.isOpen = Boolean.TRUE;
    }
}
