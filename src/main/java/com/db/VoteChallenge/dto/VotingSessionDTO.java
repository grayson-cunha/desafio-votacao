package com.db.VoteChallenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VotingSessionDTO {
    private LocalDateTime duration;
    private String description;
    private Long votingTopicId;
}
