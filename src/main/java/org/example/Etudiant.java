package org.example;

import java.sql.Date;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String numeroClasse;
    private Date dateDiplome;

    public Etudiant(int id, String nom, String prenom, String numeroClasse, Date dateDiplome) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroClasse = numeroClasse;
        this.dateDiplome = dateDiplome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNumeroClasse() {
        return numeroClasse;
    }

    public void setNumeroClasse(String numeroClasse) {
        this.numeroClasse = numeroClasse;
    }

    public Date getDateDiplome() {
        return dateDiplome;
    }

    public void setDateDiplome(String dateDiplome) {
        this.dateDiplome = Date.valueOf(dateDiplome);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroClasse='" + numeroClasse + '\'' +
                ", dateDiplome=" + dateDiplome +
                '}';
    }
}