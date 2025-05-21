package com.db.VoteChallenge.service;

import com.db.VoteChallenge.dto.VotingSessionDTO;
import com.db.VoteChallenge.entity.VotingSession;
import com.db.VoteChallenge.repository.VotingSessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VotingSessionService {

    private final VotingSessionRepository votingSessionRepository;

    public VotingSessionService(VotingSessionRepository votingSessionRepository) {
        this.votingSessionRepository = votingSessionRepository;
    }

    public VotingSession openVotingSession(VotingSessionDTO votingSessionDTO) {
        VotingSession newVotingSession =
                new VotingSession(
                        votingSessionDTO.getDuration(),
                        votingSessionDTO.getDescription(),
                        votingSessionDTO.getVotingTopicId()
                );

        return votingSessionRepository.save(newVotingSession);
    }

    public Boolean isVoteSessionReceivingVotes(Long votingSessionId) {
        VotingSession votingSession = votingSessionRepository.findById(votingSessionId).get();

        LocalDateTime currentDateTime = LocalDateTime.now();

        return currentDateTime.isBefore(votingSession.getDuration());
    }

    public List<VotingSession> findByVotingTopicId(Long votingTopicId) {
        return votingSessionRepository.findByVotingTopicId(votingTopicId);
    }
}
