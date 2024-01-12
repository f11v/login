package com.example.CheckUsuario.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
@RestControllerAdvice
public class ValidationControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        return handleException(HttpStatus.NOT_FOUND, exception, request);
    }

    //Base de datos
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> handleDataAccessException(DataAccessException exception, HttpServletRequest request) {
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, exception, request);
    }

    //Validacion
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        String errorMessage = "Validation error";
        if (exception.getBindingResult().getFieldError() != null) {
            errorMessage += ": " + exception.getBindingResult().getFieldError().getDefaultMessage();
        }
        return handleException(HttpStatus.BAD_REQUEST, new Exception(errorMessage), request);
    }

    // Método privado para manejar todas las excepciones
    private ResponseEntity<ErrorResponse> handleException(HttpStatus status, Exception exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(status);
        errorResponse.setError(status.getReasonPhrase());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setPath(request.getRequestURI());

        return new ResponseEntity<>(errorResponse, status);
    }
}


