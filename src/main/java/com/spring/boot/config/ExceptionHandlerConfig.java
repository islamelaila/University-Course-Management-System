package com.spring.boot.config;

import com.spring.boot.helper.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageResponse>> ExceptionHandlerVaildation (MethodArgumentNotValidException exception){

        List<MessageResponse> messageRespons = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.stream().forEach(fieldError -> {
            String message = fieldError.getDefaultMessage();
            messageRespons.add(new MessageResponse(message));
        });

        return ResponseEntity.badRequest().body(messageRespons);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> ExceptionHandler (Exception exception){
        String message = exception.getMessage();
        return ResponseEntity.badRequest().body(new MessageResponse(message));
    }

}
