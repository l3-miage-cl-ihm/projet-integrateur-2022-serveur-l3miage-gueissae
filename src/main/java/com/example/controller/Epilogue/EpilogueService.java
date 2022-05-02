package com.example.controller.Epilogue;

import java.util.List;

import com.example.model.Epilogue;
import com.example.repository.EpilogueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EpilogueService {
    
    private final EpilogueRepository epilogueRepository;

    @Autowired
    public EpilogueService(EpilogueRepository epilogueRepository){
        this.epilogueRepository = epilogueRepository;
    }

    public List<Epilogue> getAllEpilogues() {
        return epilogueRepository.findAll();
    }

    public void addNewEpilogue(Epilogue epilogue){
        epilogueRepository.save(epilogue);
    }

    public Epilogue findByIdentifiant(Integer id){
        return epilogueRepository.findByIdentifiant(id);
    }
}
