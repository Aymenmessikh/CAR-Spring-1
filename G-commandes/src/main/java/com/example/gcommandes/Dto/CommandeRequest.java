package com.example.gcommandes.Dto;

public class CommandeRequest {
    private Long clientId;
    private String nom;

    public CommandeRequest(Long clientId, String nom) {
        this.clientId = clientId;
        this.nom = nom;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
