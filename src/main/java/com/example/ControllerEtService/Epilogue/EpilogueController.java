package com.example.ControllerEtService.Epilogue;

import java.util.List;

import com.example.model.Epilogue;

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
@CrossOrigin
@RequestMapping("/api/epilogue")
public class EpilogueController {

    private final EpilogueService epilogueService;

    @Autowired
    public EpilogueController(EpilogueService epilogueService){
        this.epilogueService = epilogueService;
    }

    // TODO: unused
    @GetMapping("/")
    public ResponseEntity<List<Epilogue>> getAllEpilogues(){
        return new ResponseEntity<List<Epilogue>>(epilogueService.getAllEpilogues(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Epilogue> getEpilogueByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Epilogue epilogue = epilogueService.findByIdentifiant(id);
            if(epilogue != null)
                return new ResponseEntity<Epilogue>(epilogue, HttpStatus.OK);
            else
                return new ResponseEntity<Epilogue>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Epilogue>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Epilogue> addNewEpilogue(@RequestBody Epilogue epilogue) {
        try {
            epilogueService.addNewEpilogue(epilogue);
            return new ResponseEntity<>(epilogue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/")
    public ResponseEntity<Epilogue> updateEpilogue(@RequestBody Epilogue epilogue) {
        try{
            Epilogue e =epilogueService.updateEpilogue(epilogue);
            System.out.println(e.getIdentifiant());
            return  new ResponseEntity<Epilogue>(e, HttpStatus.OK);
        }   catch(IllegalStateException e){
            return   new ResponseEntity<Epilogue>(HttpStatus.BAD_REQUEST);
        }
        
    }
    @DeleteMapping("/")
    public ResponseEntity<Epilogue> deleteEpilogue(@RequestBody Integer identifiant){
        try{
            epilogueService.deleteEpilogue(identifiant);
            return new ResponseEntity<Epilogue>(HttpStatus.OK);
        }
        catch(IllegalStateException e){
            return new ResponseEntity<Epilogue>(HttpStatus.BAD_REQUEST);
        }
    }
}
