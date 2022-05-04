package com.example.controller.Image;

import java.util.List;

import com.example.model.Image;

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
@RequestMapping("/api/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public  ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Image>> getAllImages() {
        return new ResponseEntity<List<Image>>(imageService.getAllImages(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Image> getImageByIdentifiant(@PathVariable("identifiant") Integer id) {
        try{
            Image image = imageService.findByIdentifiant(id);
            if(image!=null)
                return new ResponseEntity<Image>(image, HttpStatus.OK);
            else 
                return new ResponseEntity<Image>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<Image>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Image> addNewImage(@RequestBody Image image){
        try {
            imageService.addNewImage(image);
            return new ResponseEntity<>(image, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
