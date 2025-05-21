package com.db.VoteChallenge.documentation;

import com.db.VoteChallenge.dto.VotingSessionDTO;
import com.db.VoteChallenge.entity.VotingSession;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Voting Session")
public interface VotingSessionControllerDocumentation {

    @Operation(summary = "Open voting session to vote")
    ResponseEntity<VotingSession> openVoteSession(@RequestBody VotingSessionDTO votingSessionDTO);

    @Operation(summary = "Find all voting session for a given voting topic")
    ResponseEntity<List<VotingSession>> findByVotingTopicId(@PathVariable("votingTopicId") Long votingTopicId);
}
