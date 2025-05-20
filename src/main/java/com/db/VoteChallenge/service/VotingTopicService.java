package com.db.VoteChallenge.service;

import com.db.VoteChallenge.common.exception.VotingTopicAlreadyExistException;
import com.db.VoteChallenge.common.exception.VotingTopicNotFoundException;
import com.db.VoteChallenge.dto.VotingTopicDTO;
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

    public VotingTopic create(VotingTopicDTO votingTopicDTO) {
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

    public VotingTopic update(Long id, VotingTopicDTO votingTopicData) {
        Optional<VotingTopic> existingVotingTopicOptional = votingTopicRepository.findById(id);

        if (existingVotingTopicOptional.isEmpty()) {
            throw new VotingTopicNotFoundException(
                    MessageFormat.format("VotingTopic with id {0} not found", id)
            );
        }

        VotingTopic existingVotingTopic = existingVotingTopicOptional.get();

        existingVotingTopic.setName(votingTopicData.getName());
        existingVotingTopic.setDescription(votingTopicData.getDescription());
        existingVotingTopic.setIsActive(votingTopicData.getIsActive());
        return votingTopicRepository.save(existingVotingTopic);
    }
}
