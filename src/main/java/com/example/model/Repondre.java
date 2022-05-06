// package com.example.model;

// import javax.persistence.*;

// @Entity
// @Table(
//     name = "LesRepondres"
// )
// public class Repondre {
    
//     // // // // // // // //
//     //     COLONNES      //
//     // // // // // // // //

//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     @Column
//     (
//         name= "identifiant",
//         insertable = true,
//         nullable = false,
//         unique = true,
//         updatable = false
//     )
//     private int identifiant;

//     @Column
//     (
//         name= "point",
//         insertable = true,
//         nullable = true,
//         unique = false,
//         updatable = false
//     )
//     private int point;


//     // // // // // // // // 
//     //   CONSTRUCTEURS   //
//     // // // // // // // //

//     public Repondre() {
//     }

//     public Repondre(int point) {
//         this.point = point;
//     }

//     // // // // // // // // 
//     //     GET & SET     //
//     // // // // // // // //

//     public int getIdentifiant() {
//         return identifiant;
//     }

//     public int getPoint() {
//         return point;
//     }

//     public void setPoint(int point) {
//         this.point = point;
//     }

    

    

    
// }
