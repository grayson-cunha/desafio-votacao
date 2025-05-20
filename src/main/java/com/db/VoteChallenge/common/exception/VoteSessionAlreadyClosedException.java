package com.db.VoteChallenge.common.exception;

public class VoteSessionAlreadyClosedException extends RuntimeException {

    public VoteSessionAlreadyClosedException(String message) {
        super(message);
    }
}
