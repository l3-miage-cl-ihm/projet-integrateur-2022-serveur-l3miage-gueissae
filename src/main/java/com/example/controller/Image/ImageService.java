package com.example.controller.Image;

import java.util.List;

import com.example.model.Image;
import com.example.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    
    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public void addNewImage(Image image) {
        imageRepository.save(image);
    }

    public Image findByIdentifiant(Integer id) {
        return imageRepository.findByIdentifiant(id);
    }
    public Image updateImage(Image image) {
        Image updatedImage = imageRepository.findByIdentifiant(image.getId());
        if (updatedImage == null) {
            throw new IllegalArgumentException("image doesn't exist");
        }
        updatedImage.setChemin(image.getChemin());
        updatedImage.setLabel(image.getLabel());
        updatedImage.setNumero(image.getNumero());
        imageRepository.save(updatedImage);
        return updatedImage;
    }
}
