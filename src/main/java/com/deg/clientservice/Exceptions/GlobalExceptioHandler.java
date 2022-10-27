
package com.deg.clientservice.Exceptions;

import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptioHandler {

    @ExceptionHandler(IllegalAnnotationException.class)
    public ResponseEntity<Error>ilegalArgumentException(String msg){
    Error error=new Error();
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }   

      @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error>resourceNotFoundException(String msg){
    Error error=new Error();
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }   

     @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Error>resourceAlreadyExistsException(String msg){
    Error error=new Error();
    return new ResponseEntity<>(error,HttpStatus.CONFLICT);

    }   
}
