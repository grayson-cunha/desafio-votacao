package com.db.VoteChallenge.documentation;

import com.db.VoteChallenge.dto.VoteCountDTO;
import com.db.VoteChallenge.dto.VoteDTO;
import com.db.VoteChallenge.entity.Vote;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Vote")
public interface VoteControllerDocumentation {

    @Operation(summary = "Create a vote")
    ResponseEntity<Vote> create(@RequestBody VoteDTO voteDTO);

    @Operation(summary = "Count votes for a session")
    ResponseEntity<VoteCountDTO> countVotes(@PathVariable Long voteSessionId);
}
