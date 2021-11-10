package com.suhmoraes.projectmongodbandspringboot.controllers.exception;

import com.suhmoraes.projectmongodbandspringboot.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice // Indica que essa classe é responsável por tratar possíveis erros nas requisições
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // Essa annotation identifica quando ocorre a exceção e o tratar o erro.
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado!", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
