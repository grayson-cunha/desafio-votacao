package com.db.VoteChallenge.controller;

import com.db.VoteChallenge.documentation.AssociateDocumentation;
import com.db.VoteChallenge.dto.AssociateDTO;
import com.db.VoteChallenge.entity.Associate;
import com.db.VoteChallenge.service.AssociateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associates")
public class AssociateController implements AssociateDocumentation {

    private final AssociateService associateService;

    public AssociateController(AssociateService associateService) {
        this.associateService = associateService;
    }

    @PostMapping
    public ResponseEntity<Associate> create(@RequestBody AssociateDTO associateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(associateService.create(associateDTO));
    }
}
