package com.example.model;

import javax.persistence.*;

@NamedQuery(name = "getAllDefis", query = "SELECT d" + 
                                          " FROM Defis d")

@Entity
@Table(
    name = "LesDefis"
)
public class Defis{

    private static Integer identifiant = 1;

    @Id 
    private String id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column
    private String description;

    public Defis(){
        this.setId();   
    }

    public String getId() {
        return id;
    }

    private void setId() {
        this.id = "" + getIdentifiant();
        setIdentifiant(identifiant + 1);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    private static Integer getIdentifiant() {
        return identifiant;
    }

    private static void setIdentifiant(Integer identifiant) {
        Defis.identifiant = identifiant;
    }    
    
}