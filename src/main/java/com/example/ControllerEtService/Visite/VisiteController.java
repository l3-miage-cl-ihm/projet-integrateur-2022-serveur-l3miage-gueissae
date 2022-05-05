package com.example.ControllerEtService.Visite;

import java.util.List;

import com.example.model.Visite;

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
@RequestMapping("/api/Visite")
public class VisiteController {

    private final VisiteService visiteService;

    @Autowired
    public VisiteController(VisiteService visiteService){
        this.visiteService = visiteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Visite>> getAllVisite(){
        return new ResponseEntity<List<Visite>>(visiteService.getAllVisites(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Visite> getVisiteByIdentifiant(@PathVariable("identifiant") Integer id){
        try {
            Visite visite = visiteService.findByIdentifiant(id);
            if(visite != null)
                return new ResponseEntity<Visite>(visite, HttpStatus.OK);
            else
                return new ResponseEntity<Visite>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Visite>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Visite> addNewReponse(@RequestBody Visite visite) {
        try {
            visiteService.addNewVisite(visite);
            return new ResponseEntity<>(visite, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
