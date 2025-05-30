package com.db.VoteChallenge.controller;

import com.db.VoteChallenge.documentation.VotingSessionControllerDocumentation;
import com.db.VoteChallenge.dto.VotingSessionDTO;
import com.db.VoteChallenge.entity.VotingSession;
import com.db.VoteChallenge.service.VotingSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voting-sessions")
public class VotingSessionController implements VotingSessionControllerDocumentation {

    private final VotingSessionService votingSessionService;

    public VotingSessionController(VotingSessionService votingSessionService) {
        this.votingSessionService = votingSessionService;
    }

    @PostMapping
    public ResponseEntity<VotingSession> openVoteSession(@RequestBody VotingSessionDTO votingSessionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(votingSessionService.openVotingSession(votingSessionDTO));
    }

    @GetMapping("/topic/{votingTopicId}")
    public ResponseEntity<List<VotingSession>> findByVotingTopicId(@PathVariable("votingTopicId") Long votingTopicId) {
        return ResponseEntity.status(HttpStatus.OK).body(votingSessionService.findByVotingTopicId(votingTopicId));
    }
}
