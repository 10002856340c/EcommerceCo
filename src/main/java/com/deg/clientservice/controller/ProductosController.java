
package com.deg.clientservice.controller;

import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.Client;
import com.deg.clientservice.model.ProductosModel;
import com.deg.clientservice.service.ClientService;
import com.deg.clientservice.service.ProductosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/productos")
@RestController
public class ProductosController {
   
   @Autowired
    private ProductosService productosService;


    @PostMapping("/")
    public ResponseEntity<ProductosModel> create(@RequestBody ProductosModel client){
        return new ResponseEntity<>(this.productosService.create(client), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductosModel>> findAll(){
        return new ResponseEntity<>(this.productosService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosModel> update(@RequestBody ProductosModel clientUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.productosService.update(clientUpdate, id), HttpStatus.OK);
    }
    
}
