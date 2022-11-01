package com.deg.clientservice.service;

import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.Client;
import com.deg.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client create (Client newClient){
        return this.clientRepository.save(newClient);
    }

    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }

    public Client update(Client client, Long id) throws ResourceNotFoundException {
        Optional<Client> clientBD = this.clientRepository.findById(id);
        if (clientBD.isPresent()){
            Client c = clientBD.get();
             c.setApellido(client.getApellido());
            c.setNombre(client.getNombre());
            c.setDni(client.getDni()); 
            c.setFechaNacimiento(client.getFechaNacimiento());
            return this.clientRepository.save(c);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }

    public void delete(Long id){
        this.clientRepository.deleteById(id);
    }
}
