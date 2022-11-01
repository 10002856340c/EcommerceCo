package com.deg.clientservice.repository;

import com.deg.clientservice.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client>findByDni(String Dni);

}
