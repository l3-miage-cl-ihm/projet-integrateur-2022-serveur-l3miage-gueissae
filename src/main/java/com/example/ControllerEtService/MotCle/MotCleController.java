package com.example.ControllerEtService.MotCle;

import java.util.List;

import com.example.model.MotCle;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
@RequestMapping("/api/motcle")
public class MotCleController {

    private final MotCleService motCleService;

    @Autowired
    public MotCleController(MotCleService motCleService) {
        this.motCleService = motCleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MotCle>> getAllMotsCles() {
        return new ResponseEntity<List<MotCle>>(motCleService.getAllMotsCles(), HttpStatus.OK);
    }

    @PostMapping("/{mot}")
    public ResponseEntity<org.springframework.http.HttpStatus> registerNewMotCle(@PathVariable("mot") String mot) {
        try {
            motCleService.addNewMotCle(mot);
            return new ResponseEntity<org.springframework.http.HttpStatus>(HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<org.springframework.http.HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/word/{prefix}")
    public ResponseEntity<List<MotCle>> getWordByPrefix(@PathVariable("prefix") String prefix) {
        if (prefix != "")
            return new ResponseEntity<List<MotCle>>(motCleService.findWordByPrefix(prefix), HttpStatus.OK);
        else
            return getAllMotsCles();
    }

}