package com.example.datas;

import com.example.model.Chamis;
import com.example.model.Ville;
import com.example.repository.ChamisRepository;
import com.example.repository.VilleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private ChamisRepository chamisRepository;
    private VilleRepository villeRepository;

    @Autowired
    public DataLoader(ChamisRepository chamisRepository, VilleRepository villeRepository) {
        this.chamisRepository = chamisRepository;
        this.villeRepository = villeRepository;
        LoadChamis();
    }

    private void LoadChamis() {
        Ville grenoble = new Ville("grenoble");
        villeRepository.save(grenoble);
        chamisRepository.save(new Chamis("justin.goudon@outlook.fr", "goudonju", 21,"a",grenoble,null,null));
    }
}