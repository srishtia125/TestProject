package com.digital.and.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Srishti Agrawal
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class PhoneAlreadyActivatedException extends RuntimeException {

    public PhoneAlreadyActivatedException(String message) {
        super(message);
    }
}
