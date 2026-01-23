package com.example.gcommandes.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCmnd;
    private String libelle;
    private int quantite;
    private int prixUnitaire;

    public LigneCommande() {
    }
    public LigneCommande(String libelle, int quantite, int prixUnitaire) {
        this.libelle = libelle;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }
    public Long getIdLigneCmnd() {
        return idLigneCmnd;
    }
    public void setIdLigneCmnd(Long idLigneCmnd) {
        this.idLigneCmnd = idLigneCmnd;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public int getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
