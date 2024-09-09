package com.example.demo.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(Exception e) {
        log.error("익셉션에러 : {}", convertExceptionStackTraceToString(e));
        return ResponseEntity
                .status(500)
                .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(RuntimeException e) {
        log.error("런타임에러 : {}", convertExceptionStackTraceToString(e));
        return ResponseEntity
                .status(500)
                .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(BaseException e) {
        log.error("에러 : {}", e.getErrorMessage());
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new ErrorResponse(e.getHttpStatus(), e.getErrorMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(WebClientResponseException e) {
        log.error("API 통신 에러 : {}", e.getMessage());
        log.error(e.getResponseBodyAsString());
        return ResponseEntity
                .status(e.getStatusCode())
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getResponseBodyAsString()));
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getBindingResult().getFieldError().getDefaultMessage());

        return ResponseEntity
                .status(400)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getBindingResult().getFieldError().getDefaultMessage()));
    }

    private static String convertExceptionStackTraceToString(Exception ex) {
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        return String.valueOf(stringWriter);
    }
}
