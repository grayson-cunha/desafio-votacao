package com.db.VoteChallenge.service;

import com.db.VoteChallenge.common.exception.VotingTopicAlreadyExistException;
import com.db.VoteChallenge.dto.VotingTopicDTO;
import com.db.VoteChallenge.entity.VotingTopic;
import com.db.VoteChallenge.repository.VotingTopicRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

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

}
