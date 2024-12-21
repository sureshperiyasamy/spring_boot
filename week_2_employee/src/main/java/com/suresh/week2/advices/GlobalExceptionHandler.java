package com.suresh.week2.advices;


import com.suresh.week2.exceptions.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGenericException(Exception exception) {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
        return buildErrorApiResponseEntity(apiError) ;
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception) {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
        return buildErrorApiResponseEntity(apiError) ;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotFound(MethodArgumentNotValidException exception) {
        List<String> subErrors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).subErrors(subErrors).build();
        return buildErrorApiResponseEntity(apiError) ;
    }



    private ResponseEntity<ApiResponse<?>> buildErrorApiResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }

}
