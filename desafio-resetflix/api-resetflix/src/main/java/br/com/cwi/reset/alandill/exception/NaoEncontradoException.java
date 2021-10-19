package br.com.cwi.reset.alandill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NaoEncontradoException extends Exception{
    public NaoEncontradoException(String message) {
        super(message);
    }
}
