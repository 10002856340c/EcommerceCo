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


    public ProductosModel update(ProductosModel client, Long id) throws IllegalArgumentException {
        if (id <=0){
        throw new IllegalArgumentException("El producto con el id  no fue encontrado por favor verificar");
            } 
        ProductosModel productosModel=this.productosRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El producto con el id  "+id+"  brindado no existe en la base de datos"));
        
        productosModel.setDescripcion(client.getDescripcion());
        productosModel.setFecha_alta(client.getFecha_alta());
        productosModel.setPrecioCompra(client.getPrecioCompra());
         productosModel.setPrecioVenta(client.getPrecioVenta());
         productosModel.setSku(client.getSku());
        productosModel.setStock(client.getStock());

         return this.productosRepository.save(productosModel);
    }


    public void delete(Long id){
        this.productosRepository.deleteById(id);
    }
}
