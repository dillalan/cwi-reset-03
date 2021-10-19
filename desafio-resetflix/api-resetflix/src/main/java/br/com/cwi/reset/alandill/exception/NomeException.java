package br.com.cwi.reset.alandill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeException extends Exception{
    public NomeException(String message) {
        super(message);
    }
}
