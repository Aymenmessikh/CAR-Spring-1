package com.example.gcommandes.Respository;

import com.example.gcommandes.Entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    List<Commande> findAllByClient_Id(Long id);
}
