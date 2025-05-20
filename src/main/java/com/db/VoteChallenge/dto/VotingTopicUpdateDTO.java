package com.db.VoteChallenge.dto;

import lombok.Getter;

@Getter
public class VotingTopicUpdateDTO {
    private String name;
    private String description;
    private Boolean isActive;
}
