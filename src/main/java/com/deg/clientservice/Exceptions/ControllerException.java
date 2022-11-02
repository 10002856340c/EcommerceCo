package com.deg.clientservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> resourceNotFoundException(Exception ex){
        return new ResponseEntity<>("EL CLIENTE NO EXISTE", HttpStatus.NOT_FOUND);
    }

   /* @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String>  illegalArgumentException(Exception ex){
        return new ResponseEntity<>("El precio de Compra o venta no es el adecuado, por favor verificar", HttpStatus.BAD_REQUEST);
    }*/

     @ExceptionHandler(DuplicateSku.class)
    public ResponseEntity<String> exception(Exception ex){
        return new ResponseEntity<>("El Stock esta duplicado, por favor verificar", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({PrecioCompramenor.class})
    public ResponseEntity<String> precioCompramenor(Exception ex){
        return new ResponseEntity<>("El precio de Compra o venta no es el adecuado, por favor verificar", HttpStatus.BAD_REQUEST);
    }




}
