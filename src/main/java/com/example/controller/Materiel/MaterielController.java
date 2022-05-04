package com.example.controller.Materiel;

import java.util.List;

import com.example.model.Materiel;

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
@RequestMapping("/api/Materiel")
public class MaterielController {

    private final MaterielService materielService;

    @Autowired
    public MaterielController(MaterielService materielService){
        this.materielService = materielService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Materiel>> getAllMateriels(){
        return new ResponseEntity<List<Materiel>>(materielService.getAllMateriels(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Materiel> getMaterielByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Materiel materiel = materielService.findByIdentifiant(id);
            if(materiel != null)
                return new ResponseEntity<Materiel>(materiel, HttpStatus.OK);
            else
                return new ResponseEntity<Materiel>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Materiel>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Materiel> addNewEtape(@RequestBody Materiel materiel) {
        try {
            materielService.addNewMateriel(materiel);
            return new ResponseEntity<>(materiel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
