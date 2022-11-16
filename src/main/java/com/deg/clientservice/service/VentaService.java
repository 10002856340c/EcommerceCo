
package com.deg.clientservice.service;

import com.deg.clientservice.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.VentaModelo;
import com.deg.clientservice.repository.VentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    

private VentaRepository ventaRepository;

 public  VentaModelo create (VentaModelo newClient){
        return this.ventaRepository.save(newClient);
    }

    public List<VentaModelo> findAll(){
        return this.ventaRepository.findAll();
    }

    public  VentaModelo update(VentaModelo client, Long id) throws ResourceNotFoundException {
        Optional<VentaModelo> clientBD = this.ventaRepository.findById(id);
        if (clientBD.isPresent()){
            VentaModelo c = clientBD.get();
             c.setFechaalta(client.getFechaalta());
             c.setTotal(client.getTotal());
            
            return this.ventaRepository.save(c);
        }else{
            throw new ResourceNotFoundException("La venta no existe  no existe");
        }
    }

    public void delete(Long id){
        this.ventaRepository.deleteById(id);
    }


}
