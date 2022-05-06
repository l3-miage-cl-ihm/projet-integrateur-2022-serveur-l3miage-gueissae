package com.example.ControllerEtService.Ville;

import java.util.List;

import com.example.model.Ville;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/ville")
public class VilleController {

    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService){
        this.villeService = villeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Ville>> getAllVille(){
        return new ResponseEntity<List<Ville>>(villeService.getAllVilles(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Ville> getVilleByIdentifiant(@PathVariable("identifiant") Integer id){
        try {
            Ville ville = villeService.findByIdentifiant(id);
            if(ville != null)
                return new ResponseEntity<Ville>(ville, HttpStatus.OK);
            else
                return new ResponseEntity<Ville>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Ville>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Ville> addNewReponse(@RequestBody Ville ville) {
        try {
            villeService.addNewVille(ville);
            return new ResponseEntity<>(ville, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
