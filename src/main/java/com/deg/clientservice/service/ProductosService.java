/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deg.clientservice.service;

import com.deg.clientservice.Exceptions.ResourceAlreadyExistsException;
import com.deg.clientservice.Exceptions.ResourceNotFoundException;

import com.deg.clientservice.Validator.ClienteValidado;
import com.deg.clientservice.Validator.ProductoValidado;

import com.deg.clientservice.model.ProductosModel;

import com.deg.clientservice.repository.ProductosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {
     @Autowired
    private ProductosRepository productosRepository;
   @Autowired
    private ProductoValidado productoValidado;

  
    public ProductosModel create (ProductosModel newProduct) throws ResourceAlreadyExistsException {

         this.productoValidado.validate(newProduct);

        Optional<ProductosModel>ProductoBD=this.productosRepository.findBySku(newProduct.getSku());

        if(ProductoBD.isPresent()){
          throw new ResourceAlreadyExistsException("Ya existe un producto con el sku brindado");

         }else{

         return this.productosRepository.save(newProduct);
       } 
    }

    public List<ProductosModel> findAll(){
        return this.productosRepository.findAll();
    }

    public ProductosModel update(ProductosModel client, Long id) throws ResourceNotFoundException {
        Optional<ProductosModel> clientBD = this.productosRepository.findById(id);
        if (clientBD.isPresent()){
            ProductosModel c = clientBD.get();
            c.setSku(client.getSku());
            c.setDescripcion(client.getDescripcion());
            c.setPrecioCompra(client.getPrecioCompra());
            c.setPrecioVenta(c.getPrecioVenta());
           c.setFecha_alta(client.getFecha_alta());
            return this.productosRepository.save(c);
        }else{
            throw new ResourceNotFoundException("el producto no existe");
        }
    }

    public void delete(Long id){
        this.productosRepository.deleteById(id);
    }
}
