
package com.deg.clientservice.repository;

import com.deg.clientservice.model.VentaModelo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VentaRepository extends JpaRepository<VentaModelo,Long>  {
    
}
