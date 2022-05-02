package com.example.controller.Etape;

import java.util.List;

import com.example.model.Etape;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Etape")
public class EtapeController {

    private final EtapeService etapeService;

    @Autowired
    public EtapeController(EtapeService etapeService){
        this.etapeService = etapeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Etape>> getAllEtapes(){
        return new ResponseEntity<List<Etape>>(etapeService.getAllEtapes(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Etape> getEtapeByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Etape etape = etapeService.findByIdentifiant(id);
            if(etape != null)
                return new ResponseEntity<Etape>(etape, HttpStatus.OK);
            else
                return new ResponseEntity<Etape>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Etape>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Etape> addNewEtape(@RequestBody Etape etape) {
        try {
            etapeService.addNewEtape(etape);
            return new ResponseEntity<>(etape, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
