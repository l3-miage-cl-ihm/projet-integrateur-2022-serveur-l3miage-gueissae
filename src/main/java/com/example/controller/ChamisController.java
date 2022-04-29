package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.model.Chamis;
import com.example.repository.ChamisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
@RequestMapping("/api/chamis")
public class ChamisController {

	@Autowired
	ChamisRepository repositoryChamis;

	@GetMapping("/")
    public ResponseEntity<List<Chamis>> allChamis(@RequestParam(required = false) String login) {
        System.out.println("est-ce qu'on rentre dedans");
        try {
            System.out.println("est-ce qu'on rentre dedans 2 ??");
            ArrayList<Chamis> L = new ArrayList<Chamis>();
            System.out.println("est-ce qu'on rentre dedans 3??");
            if (login == null) {
                System.out.println("est-ce qu'on rentre dedans 4 ??");
                repositoryChamis.findAll().forEach(L::add);
                System.out.println("est-ce qu'on rentre dedans 5 ??");
            } /*
               * else {
               * L.add(repositoryChamis.findById(login));
               * }
               */
              
            if (L.isEmpty()) {
                
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                
            }
            
            return new ResponseEntity<>(L, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("ERROR :: "+e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 
     * !!! FONCTION A CHANGER !!!! NOUS ALLONS TOUT FAIRE AVEC JPA.
     * ELLE PRENDS EN PARAMETRES UNE REQUETE HTTP, ET UN ID D'UTILISATEUR.
     * Return l'utilisateur associé à l'id, null s'il nexiste pas.
     * Renvoie null si on arrive pas à se connecter à la base.
     * Set le status à 404 si l'utilisateur n'existe pas.
     * Set le status à 500 si la connexion ne s'est pas faite.
     * Le status est à 200 de base si tout se passe bien.
     * 
     */

    @GetMapping("/{chamisId}")
    public ResponseEntity<Chamis> getChamisById(@PathVariable(value = "chamisId") String id) {
        Optional<Chamis> chamisData = repositoryChamis.findById(id);
        if (chamisData.isPresent()) {
            return new ResponseEntity<>(chamisData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login/{chamisId}")
    public ResponseEntity<Chamis> getChamisByIdBool(@PathVariable(value = "chamisId") String login) {

        Chamis chamisData = repositoryChamis.findByLogin(login);
        if (chamisData == null) {
            return new ResponseEntity<>(chamisData,HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(chamisData,HttpStatus.OK);
        }
    }

    /**
     * 
     * !!! FONCTION A CHANGER !!!! NOUS ALLONS TOUT FAIRE AVEC JPA.
     * ELLE PRENDS EN PARAMETRES UNE REQUETE HTTP, ET UN ID D'UTILISATEUR.
     * Return l'utilisateur associé à l'id, null s'il nexiste pas.
     * Renvoie null si on arrive pas à se connecter à la base.
     * Set le status à 404 si l'utilisateur n'existe pas.
     * Set le status à 500 si la connexion ne s'est pas faite.
     * Le status est à 200 de base si tout se passe bien.
     * 
     */
    
    @PostMapping("/{chamisId}")
    public ResponseEntity<Chamis> createChamis(@RequestBody Chamis chami) { // verifier si la ville existe et renvoyer une erreur sinon
      try {
        Chamis _chamis = repositoryChamis.save(new Chamis(chami.getEmail(),chami.getLogin(), chami.getAge(), chami.getDescription(),chami.getVille(),chami.getDefis(), chami.getVisites()));
        return new ResponseEntity<>(_chamis, HttpStatus.CREATED);
      } catch (Exception e) {
        System.out.println("ERROR : "+e);
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    
}
