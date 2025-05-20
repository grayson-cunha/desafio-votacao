package com.db.VoteChallenge.controller;

import com.db.VoteChallenge.documentation.VotingTopicControllerDocumentation;
import com.db.VoteChallenge.dto.VotingTopicCreateDTO;
import com.db.VoteChallenge.dto.VotingTopicUpdateDTO;
import com.db.VoteChallenge.entity.VotingTopic;
import com.db.VoteChallenge.service.VotingTopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voting-topics")
public class VotingTopicController implements VotingTopicControllerDocumentation {

    private final VotingTopicService votingTopicService;

    public VotingTopicController(VotingTopicService votingTopicService) {
        this.votingTopicService = votingTopicService;
    }

    @PostMapping
    public ResponseEntity<VotingTopic> create(@RequestBody VotingTopicCreateDTO votingTopicDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(votingTopicService.create(votingTopicDTO));
    }

    @GetMapping
    public ResponseEntity<List<VotingTopic>> findAllActive() {
        return ResponseEntity.status(HttpStatus.OK).body(votingTopicService.findAllIsActive());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VotingTopic> update(@PathVariable Long id, @RequestBody VotingTopicUpdateDTO votingTopicDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(votingTopicService.update(id, votingTopicDTO));
    }
}
