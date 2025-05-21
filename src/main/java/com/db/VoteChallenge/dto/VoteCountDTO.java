package com.db.VoteChallenge.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteCountDTO {

    private Long approvedCount;

    private Long notApprovedCount;

    public VoteCountDTO(Long approvedCount, Long notApprovedCount) {
        this.approvedCount = approvedCount;
        this.notApprovedCount = notApprovedCount;
    }
}
