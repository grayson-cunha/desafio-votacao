package com.db.VoteChallenge.common.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorMessage {
    private Integer statusCode;
    private String message;
}
