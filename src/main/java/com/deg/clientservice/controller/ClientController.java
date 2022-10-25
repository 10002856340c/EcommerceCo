package com.deg.clientservice.controller;

import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.Client;
import com.deg.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/cliente")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/")
    public ResponseEntity<Client> create(@RequestBody Client client){
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody Client clientUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clientService.update(clientUpdate, id), HttpStatus.OK);
    }
}
