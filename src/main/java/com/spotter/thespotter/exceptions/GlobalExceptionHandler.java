package com.spotter.thespotter.exceptions;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleError(Exception ex, WebRequest request) {
    ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    log.error("Exception: ", ex);
    ex.printStackTrace();

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BusineessException.class)
  public ResponseEntity<ErrorDetails> handleBusinessError(BusineessException ex, WebRequest request) {
    ErrorDetails response = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    log.error("Exception: ", ex);
    ex.printStackTrace();

    return new ResponseEntity<>(response, ex.getHttpStatus());
  }
}
