package com.example.texassolutions.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
      log.debug("Trigger the not found error");
    }
}
