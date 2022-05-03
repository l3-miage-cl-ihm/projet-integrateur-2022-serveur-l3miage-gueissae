package com.example.datas;

import java.util.List;

import com.example.enumeration.*;
import com.example.model.*;
import com.example.repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private ChamisRepository chamisRepository;
    private VilleRepository villeRepository;
    private DefisRepository defisRepository;
    private VisiteRepository visiteRepository;

    @Autowired
    public DataLoader(ChamisRepository chamisRepository, VilleRepository villeRepository, DefisRepository defisRepository, VisiteRepository visiteRepository) {
        this.chamisRepository = chamisRepository;
        this.villeRepository = villeRepository;
        this.defisRepository = defisRepository;
        this.visiteRepository = visiteRepository;
        LoadVille();
        //LoadVisites();
        LoadDefis();
        LoadChamis();
    }

    private void LoadVille(){
        Ville grenoble = new Ville("grenoble");
        villeRepository.save(grenoble);
    }

    // private void LoadVisites(){
    //     Visite visite1 = new Visite();
    //     visiteRepository.save(visite1);
    // }

    private void LoadDefis(){
        Type typeDefi = Type.CHALLENGE;
        Mode modeDefi = Mode.PRESENTIEL;
        List<Visite> visitesVoulues = null; 
        List<Etape> etapesVoulues = null;
        Prologue prologue = null;
        Epilogue epilogue = null;
        List<MotCle> motsClesDefis = null;
        Defis defi = new Defis("bonjour","premier défi !!", typeDefi,modeDefi,5,900,"aucuns.","02/05/2022","02/05/2022",visitesVoulues,prologue,epilogue,etapesVoulues,motsClesDefis);
        defisRepository.save(defi);
    }

    private void LoadChamis() {
        Ville villeVoulue = villeRepository.getById(1);
        List<Defis> defisVoulus = null;
        List<Visite> visitesVoulues = null;
        chamisRepository.save(new Chamis("justin.goudon@outlook.fr", "goudonju", 21,"a",villeVoulue,defisVoulus,visitesVoulues));
    }
}