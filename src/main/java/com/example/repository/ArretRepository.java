package com.example.repository;

import com.example.model.Arret;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArretRepository extends JpaRepository<Arret, Integer> {
    public Arret findByIdentifiant(Integer identifiant);
    @Query(nativeQuery = true, value = "DELETE FROM  les_arrets_defis WHERE arret_identifiant =?1 AND defis_identifiant=?2 ")
    @Modifying
    int deletedefisarrets(Integer identifiantArret,Integer identifiantDefis);
}