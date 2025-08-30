package com.example.demo.exception;

import com.example.demo.port.in.TestInResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

@ControllerAdvice
public
class MyGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected
    ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
                                                              HttpHeaders headers,
                                                              HttpStatus status,
                                                              WebRequest request) {

        return new ResponseEntity<Object>(TestInResponse.builder()
                                                  .strings(new TreeSet())
                                                  .build(), status);
    }

    @Override
    protected
    ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                        HttpHeaders headers,
                                                        HttpStatus status,
                                                        WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", status.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<Object>(body, status);
    }

}
