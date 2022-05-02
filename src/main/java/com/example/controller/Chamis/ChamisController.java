package com.example.controller.Chamis;

import java.util.List;

import com.example.model.Chamis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/chamis")
public class ChamisController {
    
    private final ChamisService chamisService;

    @Autowired
    public ChamisController(ChamisService chamisService) {
        this.chamisService = chamisService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Chamis>> getAllChamis() {
        return new ResponseEntity<List<Chamis>>(chamisService.getAllChamis(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Chamis> getChamisByEmail(@PathVariable(value = "email") String email) {
        try {
            Chamis chami = chamisService.findByEmail(email);
            if(chami != null)
                return new ResponseEntity<Chamis>(chami, HttpStatus.OK);
            else
                return new ResponseEntity<Chamis>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Chamis>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Chamis> addNewChamis(@RequestBody Chamis chami) {
        try {
            chamisService.addNewChamis(chami);
            return new ResponseEntity<>(chami, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
