package com.db.VoteChallenge.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    ResponseEntity<Exception> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(VotingTopicAlreadyExistException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleVotingTopicAlreadyExistException(VotingTopicAlreadyExistException ex) {
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VotingTopicNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleVotingTopicNotFoundException(VotingTopicAlreadyExistException ex) {
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
