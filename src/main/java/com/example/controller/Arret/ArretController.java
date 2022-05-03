package com.example.controller.Arret;

import java.util.List;

import com.example.model.Arret;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin
@RequestMapping("/api/arret")
public class ArretController {
    
    private final ArretService arretService; 

    @Autowired
    public ArretController(ArretService arretService){
        this.arretService = arretService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Arret>> getAllArrets(){
        return new ResponseEntity<List<Arret>>(arretService.getAllArrets(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Arret> getArretByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Arret arret = arretService.findByIdentifiant(id);
            if(arret != null)
                return new ResponseEntity<Arret>(arret, HttpStatus.OK);
            else
                return new ResponseEntity<Arret>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Arret>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Arret> addNewArret(@RequestBody Arret arret) {
        try {
            arretService.addNewArret(arret);
            return new ResponseEntity<Arret>(arret, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Arret>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TO DO REMOVE
}
