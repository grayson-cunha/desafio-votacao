package com.db.VoteChallenge.common.exception;

public class VotedForSessionDuplicatedException extends RuntimeException{

    public VotedForSessionDuplicatedException(String message) {
        super(message);
    }
}
