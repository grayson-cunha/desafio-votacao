package com.db.VoteChallenge.service;

import com.db.VoteChallenge.common.exception.VoteSessionAlreadyClosedException;
import com.db.VoteChallenge.common.exception.VotedForSessionDuplicatedException;
import com.db.VoteChallenge.dto.VoteDTO;
import com.db.VoteChallenge.entity.Vote;
import com.db.VoteChallenge.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    private final VotingSessionService votingSessionService;

    public VoteService(VoteRepository voteRepository, VotingSessionService votingSessionService) {
        this.voteRepository = voteRepository;
        this.votingSessionService = votingSessionService;
    }

    public Vote create(VoteDTO voteDTO) {
        Boolean isVoteSessionReceivingVotes = votingSessionService.isVoteSessionReceivingVotes(voteDTO.getVoteSessionId());

        if(!isVoteSessionReceivingVotes) {
            throw new VoteSessionAlreadyClosedException(
                    MessageFormat.format("VoteSession with id {0} already closed", voteDTO.getVoteSessionId())
            );
        }

        var existentVote = voteRepository.findByVoteSessionIdAndAssociateId(voteDTO.getVoteSessionId(), voteDTO.getAssociateId());

        if(existentVote != null) {
            throw new VotedForSessionDuplicatedException(
                    MessageFormat.format(
                            "Associate id {0} already voted in session with id {1}",
                            voteDTO.getAssociateId(),
                            voteDTO.getVoteSessionId()
                    )
            );
        }

        Vote vote = new Vote(voteDTO.getIsApproved(), voteDTO.getVoteSessionId(), voteDTO.getAssociateId());

        return voteRepository.save(vote);
    }
}
