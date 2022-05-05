package com.example.ControllerEtService.Indice;

import java.util.List;

import com.example.model.Indice;

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
@RequestMapping("/api/Indice")
public class IndiceController {

    private final IndiceService indiceService;

    @Autowired
    public IndiceController(IndiceService indiceService){
        this.indiceService=indiceService;
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Indice>> getAllIndices(){
        return new ResponseEntity<List<Indice>>(indiceService.getAllIndices(),HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Indice> getIndiceByIdentifiant(@PathVariable(value="identifiant") Integer id){
        try {
            Indice indice = indiceService.findByIdentifiant(id);
            if(indice != null)
                return new ResponseEntity<Indice>(indice, HttpStatus.OK);
            else
                return new ResponseEntity<Indice>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Indice>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Indice> addNewEpilogue(@RequestBody Indice indice) {
        try {
            indiceService.addNewIndice(indice);
            return new ResponseEntity<>(indice, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
