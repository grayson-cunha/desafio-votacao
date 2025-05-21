package com.db.VoteChallenge.documentation;

import com.db.VoteChallenge.dto.VotingTopicCreateDTO;
import com.db.VoteChallenge.dto.VotingTopicUpdateDTO;
import com.db.VoteChallenge.entity.VotingTopic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Voting Topic")
public interface VotingTopicControllerDocumentation {

    @Operation(summary = "Create a voting topic")
    ResponseEntity<VotingTopic> create(@RequestBody VotingTopicCreateDTO votingTopicDTO);

    @Operation(summary = "Find All voting topic that is active true")
    ResponseEntity<List<VotingTopic>> findAllActive();

    @Operation(summary = "Update a voting topic")
    ResponseEntity<VotingTopic> update(@PathVariable Long id, @RequestBody VotingTopicUpdateDTO votingTopicDTO);
}
