package com.example.gcommandes.Respository;

import com.example.gcommandes.Entity.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeRepository extends CrudRepository<Commande, Long> {

    List<Commande> findAllByClient_Id(Long id);
}
