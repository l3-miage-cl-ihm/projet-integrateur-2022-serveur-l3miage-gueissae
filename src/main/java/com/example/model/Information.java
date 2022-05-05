package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(
    name = "LesInforamtions"
)
public class Information extends Etape {

    // // // // // // // //
    //     COLONNES      //
    // // // // // // // //

    @Column(
        name="texte",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String texte;

    @OneToMany
    private List<Indice> indices;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //

    public Information(){}
    
    public Information(int numero, String texte, List<Indice> indices) {
        super(numero);
        this.texte = texte;
        this.indices = indices;
    }

    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //
    
    public String getTexte() {
        return texte;
    }
    public void setTexte(String texte) {
        this.texte = texte;
    }

    public List<Indice> getIndices() {
        return indices;
    }

    public void setIndices(List<Indice> indices) {
        this.indices = indices;
    }

}
