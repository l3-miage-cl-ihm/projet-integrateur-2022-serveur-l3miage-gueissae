package com.example.ControllerEtService.Texte;

import java.util.List;

import com.example.model.Texte;

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
@RequestMapping("/api/texte")
public class TexteController {
    
    private final TexteService texteService; 

    @Autowired
    public TexteController(TexteService texteService){
        this.texteService = texteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Texte>> getAllTextes(){
        return new ResponseEntity<List<Texte>>(texteService.getAllTextes(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Texte> getTexteByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Texte texte = texteService.findByIdentifiant(id);
            if(texte != null)
                return new ResponseEntity<Texte>(texte, HttpStatus.OK);
            else
                return new ResponseEntity<Texte>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Texte>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Texte> addNewTexte(@RequestBody Texte texte) {
        try {
            texteService.addNewTexte(texte);
            return new ResponseEntity<Texte>(texte, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Texte>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TO DO REMOVE
}
