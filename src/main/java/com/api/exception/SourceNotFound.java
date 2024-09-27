package com.api.exception;

public class SourceNotFound extends RuntimeException {
    public SourceNotFound(String msg) {
        super(msg);
    }
}
