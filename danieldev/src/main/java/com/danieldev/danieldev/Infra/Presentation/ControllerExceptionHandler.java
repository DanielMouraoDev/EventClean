package com.danieldev.danieldev.Infra.Presentation;

import com.danieldev.danieldev.Infra.Exception.EventDuplicateException;
import com.danieldev.danieldev.Infra.Exception.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handNotFoundException(EventNotFoundException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Mensagem:", "Evento nao encontrado, cheque o identificador.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handDuplicateEventExceptions(EventDuplicateException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Mensagem:", "Por favor, insira um hashId valido e tente novamente!");
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}