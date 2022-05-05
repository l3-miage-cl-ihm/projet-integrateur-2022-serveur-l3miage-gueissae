package com.example.ControllerEtService.Reponse;

import java.util.List;

import com.example.model.Reponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Reponse")
public class ReponseController {
    
    private final ReponseService reponseService;

    @Autowired
    public ReponseController(ReponseService reponseService){
        this.reponseService = reponseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Reponse>> getAllReponse(){
        return new ResponseEntity<List<Reponse>>(reponseService.getAllReponses(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Reponse> getReponseByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Reponse reponse = reponseService.findByIdentifiant(id);
            if(reponse != null)
                return new ResponseEntity<Reponse>(reponse, HttpStatus.OK);
            else
                return new ResponseEntity<Reponse>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Reponse>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Reponse> addNewReponse(@RequestBody Reponse reponse) {
        try {
            reponseService.addNewReponse(reponse);
            return new ResponseEntity<>(reponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Reponse> deleteReponse(@RequestBody Integer id ) {
        try {
            reponseService.deleteReponseById(id);
            return new ResponseEntity<Reponse>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Reponse>(HttpStatus.BAD_REQUEST);
        }
    }
}
