package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "no user found for given id")
public class NoSuchUserException extends Exception{
    public NoSuchUserException(String message)
    {
        super(message);
    }
}
