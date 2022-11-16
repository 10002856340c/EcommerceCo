
package com.deg.clientservice.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptioHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error>illegalArgumentException(Exception msg){
   Error error=new Error();
   error.setMsg(msg.getMessage());
   error.setStatus("ERROR");
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }   


      @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error>resourceNotFoundException(Exception msg){
    Error error=new Error();
     error.setMsg(msg.getMessage());
      error.setStatus("ERROR");
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }   

     @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Error>resourceAlreadyExistsException(Exception msg){
    Error error=new Error();
  error.setMsg(msg.getMessage());
   error.setStatus("ERROR");
    return new ResponseEntity<>(error,HttpStatus.CONFLICT);

    }   
}
