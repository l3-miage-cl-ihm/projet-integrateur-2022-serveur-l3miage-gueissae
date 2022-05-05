package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="LesQuestions")
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
        unique=true,
        updatable = false
    )
    private String label;

    @Column(
        name="description",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String description;

    @OneToMany
    private List<Reponse> reponses;

    @OneToMany
    private List<Indice> indices;

    @OneToMany
    private List<Repondre> repondres;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //
    
    public Question(){}

    public Question(int numero, String label, String description, 
            List<Reponse> reponses, List<Indice> indices) {
        super(numero);
        this.label = label;
        this.description = description;
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

    public List<Repondre> getRepondres() {
        return repondres;
    }

    public void setRepondres(List<Repondre> repondres) {
        this.repondres = repondres;
    }

    
    
}
