package com.sl.jwt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultMessageError {

    int erro;
    String message;
    Exception e;

}
