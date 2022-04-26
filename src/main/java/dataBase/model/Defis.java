package dataBase.model;

import javax.persistence.*;

@NamedQuery(name = "getAllDefis", query = "SELECT d" + 
                                          " FROM Defis d")

/*@NamedQuery(name = "getCreatedDefis", query = "SELECT count(d)" +
                                              "FROM Defis d" +
                                              "WHERE d.name = :name") */

@Entity
public class Defis{

    private static Integer identifiant = 1;

    @Id //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column 
    private String titre;

    @Column
    private String  description;


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