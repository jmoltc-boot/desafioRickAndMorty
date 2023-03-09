package com.molt.desafiorickandmorty.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = CharacterNotFoundException.class)
    public ResponseEntity<ErrorInfo> characterNotFoundException() {

        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), "No se encontraron personajes con el id indicado");
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

    }

}