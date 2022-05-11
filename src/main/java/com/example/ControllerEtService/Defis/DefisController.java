package com.example.ControllerEtService.Defis;

import java.util.List;

import com.example.model.Defis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/api/defis") // TODO: supprimer le s
public class DefisController {

    private final DefisService defisService;

    
    @Autowired
    public DefisController(DefisService defisService) {
        this.defisService = defisService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Defis>> getAllDefis() {
        return new ResponseEntity<List<Defis>>(defisService.getAllDefis(), HttpStatus.OK);
    }

    @PostMapping("/{email}")
    public ResponseEntity<Defis> registerNewDefis(@RequestBody Defis defis, @PathVariable(value = "email") String email) {
        try {
            Defis d = defisService.addNewDefis(email, defis);
            System.out.println(d.getIdentifiant());
            return new ResponseEntity<Defis>(d, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<Defis>( HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/")
    public ResponseEntity<Defis> updateDefis(@RequestBody Defis defis) {
        try {
            Defis d = defisService.updateDefis(defis);
            System.out.println(d.getIdentifiant());
            return new ResponseEntity<Defis>(d, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return new ResponseEntity<Defis>(HttpStatus.BAD_REQUEST );
        }
    }
    @DeleteMapping("/motcle/{defi}/{mot}")
    public ResponseEntity<Defis> deleteMotCleDefis(@PathVariable(value="mot") String mot,@PathVariable(value="defi")Integer defi){
        try{
            Defis d = defisService.removeMotCleDefis(mot, defi);
            System.out.println(d.getIdentifiant());
            return new  ResponseEntity<Defis>(d,HttpStatus.OK);
        }   catch (IllegalArgumentException e){
            return new ResponseEntity<Defis>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/motcle/{defi}/{mot}")
    public ResponseEntity<Defis> addMotCleDefis(@PathVariable(value="mot")String mot,@PathVariable(value="defi")Integer defi){
        try{
            Defis d = defisService.addMotCleDefis(mot, defi);
            System.out.println(d.getIdentifiant());
            return new  ResponseEntity<Defis>(d,HttpStatus.OK);
        }   catch (IllegalArgumentException e){
            return new ResponseEntity<Defis>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Defis> deleteDefis(@PathVariable(value="id") Integer identifiant) {
        System.out.println("Défis 1 Controller");
        try{
            System.out.println("Défis 2 Controller");
            defisService.deleteDefis(identifiant);
            System.out.println("Défis 3 Controller");
            return new ResponseEntity<Defis>(HttpStatus.OK);
        } catch(IllegalArgumentException e ){
            System.out.println("Défis 4 Controller");
            return new ResponseEntity<Defis>(HttpStatus.BAD_REQUEST);
        }
    }

}
