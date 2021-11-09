package br.com.school.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> handleNotFoundException(NotFoundException notFoundException){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(HttpStatus.NOT_FOUND.toString(), notFoundException.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> handleBadRequestException(BadRequestException badRequestException){
        return ResponseEntity.badRequest().body(new Error(HttpStatus.BAD_REQUEST.toString(), badRequestException.getMessage()));
    }


}
