package com.example.ControllerEtService.Chamis;

import java.util.List;

import com.example.model.Chamis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
            if (chami != null)
                return new ResponseEntity<Chamis>(chami, HttpStatus.OK);
            else
                return new ResponseEntity<Chamis>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Chamis>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login/{chamisId}")
    public ResponseEntity<Boolean> checkIfLoginExist(@PathVariable(value = "chamisId") String login) {

        Chamis chamisData = chamisService.findByLogin(login);
        if (chamisData == null) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Chamis> addNewChamis(@RequestBody Chamis chami) {
        try {
            chamisService.addNewChamis(chami);
            return new ResponseEntity<Chamis>(chami, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Chamis>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Chamis> updateChamis(@RequestBody Chamis chamis) {
        try {
            Chamis c = chamisService.updateChamis(chamis);
            System.out.println(c.getEmail());
            return new ResponseEntity<Chamis>(c, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<Chamis>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Chamis> deleteChamis(@RequestBody String mail) {
        try {
            chamisService.deleteChamisByEmail(mail);
            return new ResponseEntity<Chamis>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Chamis>(HttpStatus.BAD_REQUEST);
        }
    }
}
