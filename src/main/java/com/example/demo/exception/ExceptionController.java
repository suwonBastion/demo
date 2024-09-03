package com.example.demo.exception;

import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.PrintWriter;
import java.io.StringWriter;


@RequiredArgsConstructor
@Slf4j
public class ExceptionController {
    private final TestService testService;

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(Exception e) {
      log.error("익셉션에러 : ",convertExceptionStackTraceToString(e));
      return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(RuntimeException e) {
        log.error("런타임에러 : ",convertExceptionStackTraceToString(e));
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(BaseException e) {
        log.error("ERROR : ",e.getErrorMessage());
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new ErrorResponse(e.getHttpStatus(),e.getErrorMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(WebClientResponseException e) {
        log.error(e.getMessage());
        log.error(e.getResponseBodyAsString());
        return ResponseEntity
                .status(e.getStatusCode())
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getResponseBodyAsString()));
    }

    private static String convertExceptionStackTraceToString(Exception ex) {
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        return String.valueOf(stringWriter);
    }
}
