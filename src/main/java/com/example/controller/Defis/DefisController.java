package com.example.controller.Defis;

import java.util.List;

import com.example.model.Defis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
@RequestMapping("/api/defis")
public class DefisController {

    private final DefisService defisService;

    
    @Autowired
    public DefisController(DefisService defisService) {
        this.defisService = defisService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Defis>> getAllMotsCles() {
        return new ResponseEntity<List<Defis>>(defisService.getAllDefis(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Defis> registerNewMotCle(@RequestBody Defis defis) {
        try {
            Defis d = defisService.addNewDefis(defis);
            System.out.println(d.getIdentifiant());
            return new ResponseEntity<Defis>(d, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<Defis>( HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/")
    public ResponseEntity<Defis> updateDefis(@RequestBody Defis defis) {
        try {
            Defis d = defisService.updateDefis(defis);
            System.out.println(d.getIdentifiant());
            return new ResponseEntity<Defis>(d, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<Defis>( HttpStatus.BAD_REQUEST);
        }
    }

}
