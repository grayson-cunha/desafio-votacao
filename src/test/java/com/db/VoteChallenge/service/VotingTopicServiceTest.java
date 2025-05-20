package com.db.VoteChallenge.service;

import com.db.VoteChallenge.common.exception.VotingTopicAlreadyExistException;
import com.db.VoteChallenge.dto.VotingTopicCreateDTO;
import com.db.VoteChallenge.entity.VotingTopic;
import com.db.VoteChallenge.repository.VotingTopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VotingTopicServiceTest {

    @Mock
    private VotingTopicRepository votingTopicRepository;

    @InjectMocks
    private VotingTopicService votingTopicService;

    private VotingTopicCreateDTO votingTopicDTO;

    @BeforeEach
    public void setUp() {
        votingTopicDTO = new VotingTopicCreateDTO("Test Topic", "Test Description");
    }

    @Test
    public void givenVotingTopic_WhenNotExists_ReturnNewVotingTopic() {
        when(votingTopicRepository.findByName(votingTopicDTO.getName())).thenReturn(null);
        VotingTopic newVotingTopic = new VotingTopic(votingTopicDTO.getName(), votingTopicDTO.getDescription());
        when(votingTopicRepository.save(any(VotingTopic.class))).thenReturn(newVotingTopic);

        VotingTopic createdTopic = votingTopicService.create(votingTopicDTO);

        assertNotNull(createdTopic);
        assertEquals(votingTopicDTO.getName(), createdTopic.getName());
        assertEquals(votingTopicDTO.getDescription(), createdTopic.getDescription());
        verify(votingTopicRepository).findByName(votingTopicDTO.getName());
        verify(votingTopicRepository).save(any(VotingTopic.class));
    }

    @Test
    public void givenVotingTopic_WhenNotExists_ThrowVotingTopicAlreadyExistException() {
        VotingTopic existingTopic = new VotingTopic(votingTopicDTO.getName(), votingTopicDTO.getDescription());
        when(votingTopicRepository.findByName(votingTopicDTO.getName())).thenReturn(existingTopic);

        VotingTopicAlreadyExistException exception = assertThrows(VotingTopicAlreadyExistException.class, () -> {
            votingTopicService.create(votingTopicDTO);
        });

        assertEquals("Voting topic Test Topic already exists", exception.getMessage());
        verify(votingTopicRepository).findByName(votingTopicDTO.getName());
        verify(votingTopicRepository, never()).save(any(VotingTopic.class));
    }

}
