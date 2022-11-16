package com.deg.clientservice.repository;

import com.deg.clientservice.model.ClienteModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClienteModel,Long> {

    Optional<ClienteModel>findByDni(String Dni);

}
