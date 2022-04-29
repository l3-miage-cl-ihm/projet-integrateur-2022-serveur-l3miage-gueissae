package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.enumeration.Type;

@Entity
@Table(
    name = "LesQuestions"
)
public class Question extends Etape{


    // // // // // // // //
    //      COLONNE      //
    // // // // // // // //

    @Column(
        name="label",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String label;

    @Column(
        name="description",
        insertable = true,
        nullable = true,
        unique=false,
        updatable = true
    )
    private String description;

    @Column(
        name="secret",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String secret;

    @Column(
        name="points",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private int points;

    @Column(
        name="typeDeReponse",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private Type typeDeReponse;

    @OneToMany
    private List<Reponse> reponses;

    @OneToMany
    private List<Indice> indices;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //
    
    public Question(){}

    public Question(int numero, String label, String description, String secret, int points, Type typeDeReponse,
            List<Reponse> reponses, List<Indice> indices) {
        super(numero);
        this.label = label;
        this.description = description;
        this.secret = secret;
        this.points = points;
        this.typeDeReponse = typeDeReponse;
        this.reponses = reponses;
        this.indices = indices;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //
    
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public Type getTypeDeReponse() {
        return typeDeReponse;
    }
    public void setTypeDeReponse(Type typeDeReponse) {
        this.typeDeReponse = typeDeReponse;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public List<Indice> getIndices() {
        return indices;
    }

    public void setIndices(List<Indice> indices) {
        this.indices = indices;
    }

    
    
}
