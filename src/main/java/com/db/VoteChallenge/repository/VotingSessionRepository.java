package com.db.VoteChallenge.repository;

import com.db.VoteChallenge.entity.VotingSession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingSessionRepository extends JpaRepository<VotingSession, Long> {}
