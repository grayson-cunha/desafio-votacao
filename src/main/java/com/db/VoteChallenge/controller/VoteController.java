package com.db.VoteChallenge.controller;

import com.db.VoteChallenge.dto.VoteCountDTO;
import com.db.VoteChallenge.dto.VoteDTO;
import com.db.VoteChallenge.entity.Vote;
import com.db.VoteChallenge.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Vote> create(@RequestBody VoteDTO voteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(voteService.create(voteDTO));
    }

    @GetMapping("/session/{voteSessionId}")
    public ResponseEntity<VoteCountDTO> countVotes(@PathVariable Long voteSessionId) {
        return ResponseEntity.status(HttpStatus.OK).body(voteService.countVotes(voteSessionId));
    }
}
