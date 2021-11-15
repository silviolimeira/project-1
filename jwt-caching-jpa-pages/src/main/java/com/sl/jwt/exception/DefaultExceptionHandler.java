package com.sl.jwt.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class ExceptionResponseProvider extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultMessageError> exceptionInfo(Exception e) {
        DefaultMessageError error = new DefaultMessageError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e);

        return new ResponseEntity<DefaultMessageError>(error,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
