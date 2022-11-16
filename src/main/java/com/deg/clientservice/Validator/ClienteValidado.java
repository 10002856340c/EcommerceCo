
package com.deg.clientservice.Validator;

import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.ClienteModel;
import org.springframework.stereotype.Component;
import com.deg.clientservice.Exceptions.IllegalArgumentException;

@Component
public class ClienteValidado {

    public void validatecliente(ClienteModel newProduct) throws ResourceNotFoundException,IllegalArgumentException{
   
        if(newProduct==null){
          throw new IllegalArgumentException("El Cliente que intentas ingresar esta vacio o es nulo , por favor verificar nuevamente");
         }

           if(newProduct.getDni().trim().isEmpty()){
        throw new IllegalArgumentException("El Dni esta vacio o nulo, por favor verifivcar");
        }
        
        //Básicamente StringUtils. isBlank() evalúa si un String es un espacio en blanco (whitespace), es nulo o está vacío ("").

         if(newProduct.getNombre().trim().isEmpty()){
        throw new IllegalArgumentException("El nombre del cliente esta vacio o nula , por favor verificar ");
        }
        
         if(newProduct.getApellido().trim().isEmpty()){
        throw new IllegalArgumentException("El apellido del cliente esta vacio o nula , por favor verificar ");
        }
        
        if(newProduct.getFechaNacimiento()==null){
        throw new IllegalArgumentException("La fecha de nacimiento  del cliente esta vacio o nula , por favor verificar ");
        }

       
        if(newProduct==null){
          throw new ResourceNotFoundException("El Cliente que intentas ingresar esta vacio o es nulo , por favor verificar nuevamente");
         }

           if(newProduct.getDni().trim().isEmpty()){
        throw new ResourceNotFoundException("El Dni esta vacio o nulo, por favor verifivcar");
        }
        
        //Básicamente StringUtils. isBlank() evalúa si un String es un espacio en blanco (whitespace), es nulo o está vacío ("").

         if(newProduct.getNombre().trim().isEmpty()){
        throw new ResourceNotFoundException("El nombre del cliente esta vacio o nula , por favor verificar ");
        }
        
         if(newProduct.getApellido().trim().isEmpty()){
        throw new ResourceNotFoundException("El apellido del cliente esta vacio o nula , por favor verificar ");
        }
        
        if(newProduct.getFechaNacimiento()==null){
        throw new ResourceNotFoundException("La fecha de nacimiento  del cliente esta vacio o nula , por favor verificar ");
        }

    }
}
