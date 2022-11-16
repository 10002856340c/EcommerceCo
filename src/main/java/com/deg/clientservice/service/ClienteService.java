package com.deg.clientservice.service;

import com.deg.clientservice.Exceptions.ResourceAlreadyExistsException;
import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.Validator.ClienteValidado;
import com.deg.clientservice.model.ClienteModel;
import com.deg.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClientRepository clientRepository;

   @Autowired
    private ClienteValidado ClienteValidado;

    public ClienteModel create (ClienteModel newClient) throws ResourceAlreadyExistsException, ResourceNotFoundException{
        
    this.ClienteValidado.validatecliente(newClient);

    Optional<ClienteModel>ClienteBD=this.clientRepository.findByDni(newClient.getDni());

        if(ClienteBD.isPresent()){

            throw new ResourceAlreadyExistsException("Ya existe un Cliente con el Dni brindado, por favor verificar nuevamente  ");
         }else{
    
         return this.clientRepository.save(newClient);

       } 

    }

    public List<ClienteModel> findAll(){
        return this.clientRepository.findAll();
    }

    public ClienteModel update(ClienteModel client, Long id) throws ResourceNotFoundException,ResourceAlreadyExistsException,IllegalArgumentException{
         if (id <=0){
        throw new IllegalArgumentException("El Cliente  con el id  no fue encontrado por favor verificar");
            } 
        
         ClienteModel ClientModel=this.clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Cliente con el id  "+id+"  brindado no existe en la base de datos"));
        
         ClientModel.setDni(client.getDni());
         ClientModel.setNombre(client.getNombre());
         ClientModel.setApellido(client.getApellido());
         ClientModel.setFechaNacimiento(client.getFechaNacimiento());

       return this.clientRepository.save(ClientModel);


    
    }

    public void delete(Long id){
        this.clientRepository.deleteById(id);
    }
}
