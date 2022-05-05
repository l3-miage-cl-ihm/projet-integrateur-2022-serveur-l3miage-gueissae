package com.example.ControllerEtService.Information;

import java.util.List;

import com.example.model.Information;

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
@RequestMapping("/api/information")
public class InformationController {

    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Information>> getAllInformations(){
        return new ResponseEntity<List<Information>>(informationService.getAllInformations(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Information> getInformationByIdentifiant(@PathVariable(value = "identifiant") Integer id){
        try{
            Information information = informationService.findByIdentifiant(id);
            if(information != null )
                return new ResponseEntity<Information>(information, HttpStatus.OK);
            else 
                return new ResponseEntity<Information>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<Information>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Information> addNewInformation(@RequestBody Information information){
        try{
            informationService.addNewInformation(information);
            return new ResponseEntity<Information>(information, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Information>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
