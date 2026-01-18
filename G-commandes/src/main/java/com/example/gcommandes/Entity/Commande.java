package com.example.gcommandes.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private LocalDate dateCommande;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Commande() {
    }

    public Commande(String nom, LocalDate dateCommande, Client client) {
        this.nom = nom;
        this.dateCommande = dateCommande;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
