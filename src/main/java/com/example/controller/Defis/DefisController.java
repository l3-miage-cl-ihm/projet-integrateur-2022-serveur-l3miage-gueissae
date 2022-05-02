package com.example.controller.Defis;

import java.util.List;

import com.example.model.Defis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<org.springframework.http.HttpStatus> registerNewMotCle(@RequestBody Defis defis) {
        try {
            defisService.addNewDefis(defis);
            return new ResponseEntity<org.springframework.http.HttpStatus>(HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<org.springframework.http.HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }

}
