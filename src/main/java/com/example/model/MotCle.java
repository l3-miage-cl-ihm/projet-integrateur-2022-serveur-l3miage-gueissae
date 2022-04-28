package com.example.model;

import javax.persistence.*;

@Entity
@Table(
    name = "LesMotsCles"
)
public class MotCle {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(
        // columnDefinition = "id du mot clé,\n" + 
        //                    "\tname: id,\n" +
        //                    "\tinsertable: true,\n" +
        //                    "\tnullable: false,\n" +
        //                    "\ttable: \"LesMotsCles,\"\n" +
        //                    "\tunique: true,\n" +
        //                    "\tupdatable: false\n",
        name="id",
        insertable = true,
        nullable = false,
// table = "LesMotsCles",
        unique=true,
        updatable = false
    )
    private int id;

    @Column(
        // columnDefinition = "Mot clé,\n" + 
        //                    "\tname: mot,\n" +
        //                    "\tinsertable: true,\n" +
        //                    "\tlength: 20,\n" +
        //                    "\tnullable: false,\n" +
        //                    "\ttable: \"LesMotsCles,\"\n" +
        //                    "\tunique: false,\n" +
        //                    "\tupdatable: false\n",
        name="mot",
        insertable = true,
        length = 20,
        nullable = false,
        // table = "LesMotsCles",
        unique=false,
        updatable = false
    )
    private String mot;

    public MotCle(String mot) {
        this.setMot(mot);
    }

    public int getId() {
        return id;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }   
}
