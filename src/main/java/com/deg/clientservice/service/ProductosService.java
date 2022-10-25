/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deg.clientservice.service;

import com.deg.clientservice.Exceptions.ResourceNotFoundException;

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

    public ProductosModel create (ProductosModel newClient){
        return this.productosRepository.save(newClient);
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
            c.setPrecio_compra(client.getPrecio_compra());
            c.setPrecio_venta(c.getPrecio_compra());
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
