package nl.remco.novi.backend.eindopdracht.into_art.controller;

import nl.remco.novi.backend.eindopdracht.into_art.exception.RecordNotFoundException;
import nl.remco.novi.backend.eindopdracht.into_art.exception.UsernameExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvise extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<Object> handleUsernameExistsException(Exception ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordNotFoundException(Exception ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
