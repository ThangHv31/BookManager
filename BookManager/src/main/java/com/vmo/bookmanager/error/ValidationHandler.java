package com.vmo.bookmanager.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorManager errorManager = new ErrorManager();
        List<Error> errorList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((errors) -> {
            Error error = new Error();
            error.setCode(errors.getCode());
            error.setMessange(errors.getDefaultMessage());
            errorList.add(error);
        });
        errorManager.setStatus(false);
        errorManager.setErrors(errorList);
        return new ResponseEntity<Object>(errorManager, HttpStatus.BAD_REQUEST);
    }
}
