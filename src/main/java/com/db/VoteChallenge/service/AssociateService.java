package com.db.VoteChallenge.service;

import com.db.VoteChallenge.dto.AssociateDTO;
import com.db.VoteChallenge.entity.Associate;
import com.db.VoteChallenge.repository.AssociateRepository;
import org.springframework.stereotype.Service;

@Service
public class AssociateService {

    private final AssociateRepository associateRepository;

    public AssociateService(AssociateRepository associateRepository) {
        this.associateRepository = associateRepository;
    }

    public Associate create(AssociateDTO associateDTO) {
        Associate associate = new Associate(associateDTO.getName());

        return associateRepository.save(associate);
    }
}
