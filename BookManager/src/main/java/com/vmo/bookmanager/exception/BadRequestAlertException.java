package com.vmo.bookmanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
@ControllerAdvice
public class BadRequestAlertException implements ProblemHandling {
    @ExceptionHandler(value = {ManagementException.class})
    public ResponseEntity<Problem> handleRateCardReportNotFoundException(ManagementException ex, NativeWebRequest request) {
        Problem problem = Problem.builder()
                .withStatus(Status.BAD_REQUEST)
                .withTitle(ex.getMessage())
                .with("MESSAGE_KEY", ex.getErrorKey())
                .with("DETAILS_KEY", ex.getDetail())
                .build();
        return create(ex, problem, request);
    }
}
