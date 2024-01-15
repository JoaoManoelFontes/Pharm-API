package com.pharm.domain.infra;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> Handle404(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OPS, HÁ ALGO DE ERRADO! " +
                "404 NOT FOUND");
    }
}
