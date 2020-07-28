package com.example.petfinder.error.handler;

import com.example.petfinder.error.CustomErrorResponse;
import com.example.petfinder.error.exception.conflict.EmailConflictException;
import com.example.petfinder.error.exception.conflict.UsernameConflictException;
import com.example.petfinder.error.exception.notFound.*;
import com.example.petfinder.error.exception.unauthorized.InvalidPasswordException;
import com.example.petfinder.error.exception.validation.EmailValidationException;
import com.example.petfinder.error.exception.validation.FirstNameValidationException;
import com.example.petfinder.error.exception.validation.LastNameValidationException;
import com.example.petfinder.error.exception.validation.PasswordIValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PetFinderExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ActionNotFoundException.class, ActionTypeNotFoundException.class, AdminNotFoundException.class,
            AnimalNotFoundException.class, AnimalImageNotFoundException.class, AnimalTypeNotFoundException.class,
            ArticleNotFoundException.class, CommentNotFoundException.class, RequestNotFoundException.class,
            RequestTypeNotFoundException.class, ShelterNotFoundException.class, UsernameNotFoundException.class,
            VolunteerNotFoundException.class, EmailNotFoundException.class})
    public ResponseEntity<CustomErrorResponse> handleNotFoundException(Exception exception, WebRequest request) {
        return handleException(exception, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public  ResponseEntity<CustomErrorResponse> handleUnauthorizedException(Exception exception, WebRequest request) {
        return handleException(exception, request, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({EmailConflictException.class, UsernameConflictException.class})
    public ResponseEntity<CustomErrorResponse> handleConflictException(Exception exception, WebRequest request) {
        return handleException(exception, request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({EmailValidationException.class, FirstNameValidationException.class,
            LastNameValidationException.class, PasswordIValidationException.class})
    public ResponseEntity<CustomErrorResponse> handleValidationException(Exception exception, WebRequest request){
        return handleException(exception, request, HttpStatus.FORBIDDEN);
    }

    private ResponseEntity<CustomErrorResponse> handleException(Exception ex, WebRequest request, HttpStatus status) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(ex, status);
        return new ResponseEntity<>(customErrorResponse, status);
    }
}
