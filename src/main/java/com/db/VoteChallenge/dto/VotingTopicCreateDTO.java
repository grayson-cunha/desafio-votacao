package com.db.VoteChallenge.dto;

import com.db.VoteChallenge.documentation.VotingTopicCreateDocumentation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotingTopicCreateDTO implements VotingTopicCreateDocumentation {
    private String name;
    private String description;
    private Boolean isActive;

    public VotingTopicCreateDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
