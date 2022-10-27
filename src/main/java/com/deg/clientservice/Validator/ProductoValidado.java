
package com.deg.clientservice.Validator;


import com.deg.clientservice.model.ProductosModel;
import java.util.Optional;
import org.springframework.stereotype.Component;



@Component
public class ProductoValidado {

public void validate(ProductosModel newProduct){
   
        if(newProduct==null){
          throw new IllegalArgumentException("El producto que intentas ingresar esta vacio o es nulo , por favor verificar nuevamente");
         }

        if(newProduct.getStock()<0){
         throw new IllegalArgumentException("El stock que estas ingresando no es valido , debe ser un valor diferente a 0");
        }

        if(newProduct.getPrecioCompra()<=0.0){
        throw new IllegalArgumentException("El precio de compra ingresado no es valido, debe ser un valor diferente a 0.0");
        }
         
        if(newProduct.getPrecioVenta()<=0.0){
        throw new IllegalArgumentException("El precio de venta ingresado no es valido, debe ser un valor diferente a 0.0");
        }

        //Básicamente StringUtils. isBlank() evalúa si un String es un espacio en blanco (whitespace), es nulo o está vacío ("").

         if(newProduct.getDescripcion().trim().isEmpty()){
        throw new IllegalArgumentException("La descripcion del producto esta vacio o nula , por favor verificar ");
        }
        
         if(newProduct.getSku().trim().isEmpty()){
        throw new IllegalArgumentException("El sku del producto esta vacio o nula , por favor verificar ");
        }
        
        if(newProduct.getFecha_alta()==null){
        throw new IllegalArgumentException("La fecha  del producto esta vacio o nula , por favor verificar ");
        }

    }

  

}
