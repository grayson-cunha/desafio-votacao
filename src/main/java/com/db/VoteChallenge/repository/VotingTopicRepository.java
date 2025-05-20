package com.db.VoteChallenge.repository;

import com.db.VoteChallenge.entity.VotingTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotingTopicRepository extends JpaRepository<VotingTopic, Long> {

    VotingTopic findByName(String name);

    List<VotingTopic> findByIsActiveTrue();
}
