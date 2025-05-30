package com.db.VoteChallenge.service;

import com.db.VoteChallenge.common.exception.VotingTopicAlreadyExistException;
import com.db.VoteChallenge.common.exception.VotingTopicNotFoundException;
import com.db.VoteChallenge.dto.VotingTopicCreateDTO;
import com.db.VoteChallenge.dto.VotingTopicUpdateDTO;
import com.db.VoteChallenge.entity.VotingTopic;
import com.db.VoteChallenge.repository.VotingTopicRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class VotingTopicService {

    private final VotingTopicRepository votingTopicRepository;

    public VotingTopicService(VotingTopicRepository votingTopicRepository) {
        this.votingTopicRepository = votingTopicRepository;
    }

    public VotingTopic create(VotingTopicCreateDTO votingTopicDTO) {
        var votingTopic = votingTopicRepository.findByName(votingTopicDTO.getName());

        if (votingTopic != null) {
            throw new VotingTopicAlreadyExistException(
                    MessageFormat.format("Voting topic {0} already exists", votingTopicDTO.getName())
            );
        }

        VotingTopic newVotingTopic =
                new VotingTopic(votingTopicDTO.getName(), votingTopicDTO.getDescription());

        return votingTopicRepository.save(newVotingTopic);
    }

    public List<VotingTopic> findAllIsActive() {
        return votingTopicRepository.findByIsActiveTrue();
    }

    public VotingTopic update(Long id, VotingTopicUpdateDTO votingTopicData) {
        Optional<VotingTopic> existingVotingTopicOptional = votingTopicRepository.findById(id);

        if (existingVotingTopicOptional.isEmpty()) {
            throw new VotingTopicNotFoundException(
                    MessageFormat.format("VotingTopic with id {0} not found", id)
            );
        }

        VotingTopic existingVotingTopic = existingVotingTopicOptional.get();

        if(votingTopicData.getName() != null) existingVotingTopic.setName(votingTopicData.getName());
        if(votingTopicData.getDescription() != null) existingVotingTopic.setDescription(votingTopicData.getDescription());
        if(votingTopicData.getIsActive() != null) existingVotingTopic.setIsActive(votingTopicData.getIsActive());
        return votingTopicRepository.save(existingVotingTopic);
    }
}
