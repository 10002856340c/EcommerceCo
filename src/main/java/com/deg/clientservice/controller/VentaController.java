
package com.deg.clientservice.controller;


import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.VentaModelo;
import com.deg.clientservice.service.VentaService;
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




@RequestMapping(path = "api/venta")
@RestController
public class VentaController {
    
    @Autowired
   private VentaService ventaservice;

 @PostMapping("/")
    public ResponseEntity<VentaModelo> create(@RequestBody VentaModelo client){
        return new ResponseEntity<>(this.ventaservice.create(client), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VentaModelo>> findAll(){
        return new ResponseEntity<>(this.ventaservice.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaModelo> update(@RequestBody VentaModelo clientUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ventaservice.update(clientUpdate, id), HttpStatus.OK);
    }
}
