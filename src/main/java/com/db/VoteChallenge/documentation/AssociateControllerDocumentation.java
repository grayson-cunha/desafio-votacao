package com.db.VoteChallenge.documentation;

import com.db.VoteChallenge.dto.AssociateDTO;
import com.db.VoteChallenge.entity.Associate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Associate")
public interface AssociateControllerDocumentation {

    @Operation(summary = "Create an associate")
    ResponseEntity<Associate> create(@RequestBody AssociateDTO associateDTO);
}
