package com.spotter.thespotter.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
@EqualsAndHashCode
@Slf4j
public class BusineessException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private HttpStatus httpStatus;

  public BusineessException(String message) {
    super(message);
  }

  public BusineessException(String message, HttpStatus httpStatus) {
    super(message);
    log.error("Exception was thrown! message = {}, httpStatus={}", message, httpStatus);
    this.httpStatus = httpStatus;
  }



}
