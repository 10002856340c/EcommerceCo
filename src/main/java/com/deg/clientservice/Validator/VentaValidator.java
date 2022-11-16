
package com.deg.clientservice.Validator;
import com.deg.clientservice.model.VentaModelo;
import org.springframework.stereotype.Component;



@Component
public class VentaValidator {
    
     public void validateVenta(VentaModelo newProduct){
   
        if(newProduct==null){
          throw new IllegalArgumentException("La Venta  que intentas ingresar esta vacio o es nulo , por favor verificar nuevamente");
         }

     
        if(newProduct.getTotal()<=0.0){
        throw new IllegalArgumentException("El Total ingresado no es valido, debe ser un valor diferente a 0.0");
        }
         

        //Básicamente StringUtils. isBlank() evalúa si un String es un espacio en blanco (whitespace), es nulo o está vacío ("").

    
 
        if(newProduct.getFechaalta()==null){
        throw new IllegalArgumentException("La fecha  del producto esta vacio o nula , por favor verificar ");
        }

    }

  

}


