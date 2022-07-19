package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Wrong password")
public class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String message)
    {
        super(message);
    }
}
