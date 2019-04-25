package com.digital.and.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Srishti Agrawal
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND )
public class PhoneNumberNotFoundException extends RuntimeException{

    public PhoneNumberNotFoundException(String message) {
        super(message);
    }
}
