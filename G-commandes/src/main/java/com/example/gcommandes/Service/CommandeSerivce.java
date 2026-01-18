package com.example.gcommandes.Service;

import com.example.gcommandes.Dto.CommandeRequest;
import com.example.gcommandes.Entity.Client;
import com.example.gcommandes.Entity.Commande;
import com.example.gcommandes.Respository.ClientRepository;
import com.example.gcommandes.Respository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeSerivce {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;

    public CommandeSerivce(CommandeRepository commandeRepository, ClientRepository clientRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
    }

    public void create(CommandeRequest commande) {
        Client client = clientRepository.findById(commande.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
        Commande commandeEntity = new Commande(commande.getNom(), LocalDate.now(), client);
        commandeRepository.save(commandeEntity);
    }

    public List<Commande> getAllCommandesByClient(Long idClient) {
        return commandeRepository.findAllByClient_Id(idClient);
    }
}
