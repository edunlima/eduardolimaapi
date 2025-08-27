package br.edu.infnet.eduardolimaapi.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.infnet.eduardolimaapi.model.exceptions.BebidaInvalidaException;
import br.edu.infnet.eduardolimaapi.model.exceptions.BebidaNaoEncontradaException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
}
	
	@ExceptionHandler(BebidaInvalidaException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(BebidaInvalidaException ex) {
        Map<String, String> errors = new HashMap<>();

       errors.put("Data/hora", LocalDateTime.now().toString());
       errors.put("Status", HttpStatus.BAD_REQUEST.toString());
       errors.put("Mensagem", ex.getMessage());
	
        

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        
	}
	
	@ExceptionHandler(BebidaNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(BebidaNaoEncontradaException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.NOT_FOUND.toString());
        errors.put("Mensagem", ex.getMessage());
        
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
        
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.BAD_REQUEST.toString());
        errors.put("Mensagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("Data/hora", LocalDateTime.now().toString());
        errors.put("Status", HttpStatus.BAD_REQUEST.toString());
        errors.put("Mensagem", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        
	}
	
	
}

