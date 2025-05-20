package com.db.VoteChallenge.repository;

import com.db.VoteChallenge.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Vote findByVoteSessionIdAndAssociateId(Long voteSessionId, Long associateId);
}
