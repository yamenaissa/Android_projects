package com.example.databasetp;

public class Offre {
    int id;
    String poste,description;

    public Offre( int id,String description, String poste) {
        super();
        this.id=id;
        this.description = description;
        this.poste=poste;
    }

    public Offre(String description, String poste){
        this.poste=poste;
        this.description=description;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
