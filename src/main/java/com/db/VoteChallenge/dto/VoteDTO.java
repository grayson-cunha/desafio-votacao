package com.db.VoteChallenge.dto;

import lombok.Getter;

@Getter
public class VoteDTO {

    private Boolean isApproved;

    private Long voteSessionId;

    private Long associateId;

    public VoteDTO(Boolean isApproved, Long voteSessionId, Long associateId) {
        this.isApproved = isApproved;
        this.voteSessionId = voteSessionId;
        this.associateId = associateId;
    }
}
