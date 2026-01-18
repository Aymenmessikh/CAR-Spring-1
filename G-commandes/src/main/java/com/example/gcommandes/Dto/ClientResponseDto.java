package com.example.gcommandes.Dto;

public class ClientResponseDto {
    private Long id;
    private String email;
    private String nom;
    private String prenom;

    public ClientResponseDto() {
    }

    public ClientResponseDto(Long id, String email, String nom, String prenom) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
