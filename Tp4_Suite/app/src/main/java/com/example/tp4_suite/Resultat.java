package com.example.tp4_suite;

public class Resultat {
    String nom, prenom;
    float moyenne;
    int image;

    public Resultat(String nom, String prenom, float moyenne, int image) {
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
        this.image = image;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public float getMoyenne() { return moyenne; }
    public int getImage() { return image; }
}