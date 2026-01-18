package com.example.gcommandes.Respository;

import com.example.gcommandes.Entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client getClientByEmail(String email);
}
