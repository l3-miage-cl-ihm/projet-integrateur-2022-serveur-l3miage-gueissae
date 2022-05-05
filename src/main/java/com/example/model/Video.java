package com.example.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(
    name = "LesVideos"
)
@PrimaryKeyJoinColumn(name = "videoIdentifiant")
public class Video extends Materiel {

    // // // // // // // //
    //     COLONNES      //
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
        name="lien",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String lien;


    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Video() {}

    public Video(int numero, String label, String lien) {
        super(numero);
        this.label = label;
        this.lien = lien;
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

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
    
}
