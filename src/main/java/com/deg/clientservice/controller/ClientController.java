package com.deg.clientservice.controller;

import com.deg.clientservice.Exceptions.ResourceAlreadyExistsException;
import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.ClienteModel;
import com.deg.clientservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/cliente")
@RestController
public class ClientController {

    @Autowired
    private ClienteService clientService;


    @PostMapping("/")
    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel client) throws ResourceAlreadyExistsException, ResourceNotFoundException,IllegalArgumentException{
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteModel>> findAll(){
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> update(@RequestBody ClienteModel clientUpdate, @PathVariable Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException ,IllegalArgumentException{
        return new ResponseEntity<>(this.clientService.update(clientUpdate, id), HttpStatus.OK);
    }
}
