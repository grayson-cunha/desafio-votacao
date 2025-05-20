package com.db.VoteChallenge.controller;

import com.db.VoteChallenge.dto.VotingTopicDTO;
import com.db.VoteChallenge.entity.VotingTopic;
import com.db.VoteChallenge.service.VotingTopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting-topics")
public class VotingTopicController {

    private final VotingTopicService votingTopicService;

    public VotingTopicController(VotingTopicService votingTopicService) {
        this.votingTopicService = votingTopicService;
    }

    @PostMapping
    public ResponseEntity<VotingTopic> create(@RequestBody VotingTopicDTO votingTopicDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(votingTopicService.create(votingTopicDTO));
    }
}
