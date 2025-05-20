package com.db.VoteChallenge.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotingTopicDTO {
    private String name;
    private String description;
    private Boolean isActive;

    public VotingTopicDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
