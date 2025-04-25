package com.aytsnw.exceptions;

public class BadArgumentException extends RuntimeException {
    public BadArgumentException() {
    super();
  }
    public BadArgumentException(String message) {
        super(message);
    }
}
