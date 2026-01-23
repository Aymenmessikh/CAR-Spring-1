package com.example.gcommandes.Service;

import com.example.gcommandes.Dto.CommandeRequest;
import com.example.gcommandes.Entity.Client;
import com.example.gcommandes.Entity.Commande;
import com.example.gcommandes.Entity.LigneCommande;
import com.example.gcommandes.Respository.ClientRepository;
import com.example.gcommandes.Respository.CommandeRepository;
import com.example.gcommandes.Respository.LigneCommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeSerivce {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    public CommandeSerivce(CommandeRepository commandeRepository, ClientRepository clientRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
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
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElseThrow();
    }
    public Commande addLigneCommandeToCommande(LigneCommande ligneCommande, Long commandeId) {
        Commande commande = commandeRepository.findById(commandeId).orElseThrow();
        commande.getLigneCommandes().add(ligneCommande);
        return commandeRepository.save(commande);
    }
    public Commande removeLigneCommandeFromCommande(Long ligneCommandeId, Long commandeId) {
        Commande commande = commandeRepository.findById(commandeId).orElseThrow();
        LigneCommande ligneCommande = ligneCommandeRepository.findById(ligneCommandeId).orElseThrow();
        commande.getLigneCommandes().remove(ligneCommande);
        return commandeRepository.save(commande);
    }
}
