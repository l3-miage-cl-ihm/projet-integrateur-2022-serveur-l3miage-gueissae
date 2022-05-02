package com.example.controller.Prologue;

import java.util.List;

import com.example.model.Prologue;

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
@RequestMapping("/api/Prologue")
public class PrologueController {

    private final PrologueService prologueService;

    @Autowired
    public PrologueController(PrologueService prologueService){
        this.prologueService = prologueService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Prologue>> getAllPrologues(){
        return new ResponseEntity<List<Prologue>>(prologueService.getAllPrologues(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Prologue> getPrologueByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Prologue prologue = prologueService.findByIdentifiant(id);
            if(prologue != null)
                return new ResponseEntity<Prologue>(prologue, HttpStatus.OK);
            else
                return new ResponseEntity<Prologue>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Prologue>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Prologue> addNewEtape(@RequestBody Prologue prologue) {
        try {
            prologueService.addNewPrologue(prologue);
            return new ResponseEntity<>(prologue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
