package com.db.VoteChallenge.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.db.VoteChallenge.common.exception.VoteSessionAlreadyClosedException;
import com.db.VoteChallenge.common.exception.VotedForSessionDuplicatedException;
import com.db.VoteChallenge.dto.VoteDTO;
import com.db.VoteChallenge.entity.Vote;
import com.db.VoteChallenge.repository.VoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VoteServiceTest {

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private VotingSessionService votingSessionService;

    @InjectMocks
    private VoteService voteService; // Assuming your service class is named VoteService

    private VoteDTO voteDTO;

    @BeforeEach
    public void setUp() {
        voteDTO = new VoteDTO(true, 1L, 1L); // Example values for isApproved, voteSessionId, and associateId
    }

    @Test
    public void givenVoteSessionIsOpen_WhenCreatingVote_ReturnsNewVote() {
        when(votingSessionService.isVoteSessionReceivingVotes(voteDTO.getVoteSessionId())).thenReturn(true);
        when(voteRepository.findByVoteSessionIdAndAssociateId(voteDTO.getVoteSessionId(), voteDTO.getAssociateId())).thenReturn(null);
        Vote newVote = new Vote(voteDTO.getIsApproved(), voteDTO.getVoteSessionId(), voteDTO.getAssociateId());
        when(voteRepository.save(any(Vote.class))).thenReturn(newVote);

        Vote createdVote = voteService.create(voteDTO);

        assertNotNull(createdVote);
        assertEquals(voteDTO.getIsApproved(), createdVote.getIsApproved());
        assertEquals(voteDTO.getVoteSessionId(), createdVote.getVoteSessionId());
        assertEquals(voteDTO.getAssociateId(), createdVote.getAssociateId());
        verify(votingSessionService).isVoteSessionReceivingVotes(voteDTO.getVoteSessionId());
        verify(voteRepository).findByVoteSessionIdAndAssociateId(voteDTO.getVoteSessionId(), voteDTO.getAssociateId());
        verify(voteRepository).save(any(Vote.class));
    }

    @Test
    public void givenVoteSessionIsClosed_ThrowVoteSessionAlreadyClosedException() {
        when(votingSessionService.isVoteSessionReceivingVotes(voteDTO.getVoteSessionId())).thenReturn(false);

        VoteSessionAlreadyClosedException exception = assertThrows(VoteSessionAlreadyClosedException.class, () -> {
            voteService.create(voteDTO);
        });

        assertEquals("VoteSession with id 1 already closed", exception.getMessage());
        verify(votingSessionService).isVoteSessionReceivingVotes(voteDTO.getVoteSessionId());
        verify(voteRepository, never()).findByVoteSessionIdAndAssociateId(anyLong(), anyLong());
        verify(voteRepository, never()).save(any(Vote.class));
    }

    @Test
    public void givenAssociateAlreadyVoted_ThrowVotedForSessionDuplicatedException() {
        Vote existingVote = new Vote(voteDTO.getIsApproved(), voteDTO.getVoteSessionId(), voteDTO.getAssociateId());
        when(votingSessionService.isVoteSessionReceivingVotes(voteDTO.getVoteSessionId())).thenReturn(true);
        when(voteRepository.findByVoteSessionIdAndAssociateId(voteDTO.getVoteSessionId(), voteDTO.getAssociateId())).thenReturn(existingVote);

        VotedForSessionDuplicatedException exception = assertThrows(VotedForSessionDuplicatedException.class, () -> {
            voteService.create(voteDTO);
        });

        assertEquals("Associate id 1 already voted in session with id 1", exception.getMessage());
        verify(votingSessionService).isVoteSessionReceivingVotes(voteDTO.getVoteSessionId());
        verify(voteRepository).findByVoteSessionIdAndAssociateId(voteDTO.getVoteSessionId(), voteDTO.getAssociateId());
        verify(voteRepository, never()).save(any(Vote.class));
    }
}
