package com.db.VoteChallenge.repository;

import com.db.VoteChallenge.entity.VotingSession;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotingSessionRepository extends JpaRepository<VotingSession, Long> {
    List<VotingSession> findByVotingTopicId(Long votingTopicId);
}
