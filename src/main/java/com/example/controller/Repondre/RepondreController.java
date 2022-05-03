package com.example.controller.Repondre;

import java.util.List;

import com.example.model.Repondre;

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
@RequestMapping("/api/repondre")
public class RepondreController {
    
    private final RepondreService repondreService; 

    @Autowired
    public RepondreController(RepondreService repondreService){
        this.repondreService = repondreService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Repondre>> getAllRepondres(){
        return new ResponseEntity<List<Repondre>>(repondreService.getAllRepondres(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Repondre> getRepondreByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Repondre repondre = repondreService.findByIdentifiant(id);
            if(repondre != null)
                return new ResponseEntity<Repondre>(repondre, HttpStatus.OK);
            else
                return new ResponseEntity<Repondre>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Repondre>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Repondre> addNewRepondre(@RequestBody Repondre repondre) {
        try {
            repondreService.addNewRepondre(repondre);
            return new ResponseEntity<Repondre>(repondre, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Repondre>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TO DO REMOVE
}
