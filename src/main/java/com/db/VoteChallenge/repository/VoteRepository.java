package com.db.VoteChallenge.repository;

import com.db.VoteChallenge.dto.VoteCountDTO;
import com.db.VoteChallenge.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Vote findByVoteSessionIdAndAssociateId(Long voteSessionId, Long associateId);

    @Query("SELECT NEW com.db.VoteChallenge.dto.VoteCountDTO(" +
            "COUNT(CASE WHEN v.isApproved = TRUE THEN 1 END), " +
            "COUNT(CASE WHEN v.isApproved = FALSE THEN 1 END)) " +
            "FROM Vote v WHERE v.voteSessionId = :voteSessionId"
    )
    VoteCountDTO countVotesBySessionId(@Param("voteSessionId") Long voteSessionId);
}
