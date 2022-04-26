package dataBase.repository.impl;

import dataBase.model.Chamis;
import dataBase.repository.api.ChamisRepository;

import javax.persistence.EntityManager;
import java.util.List;


public class ChamisRepositoryImpl extends BaseRepositoryImpl implements ChamisRepository {

    public ChamisRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Chamis entity) {
        entityManager.persist(entity);
        
    }

    @Override
    public void delete(Chamis entity) {
        entityManager.remove(entity);
        
    }

    @Override
    public Chamis findById(String id) {
        return entityManager.find(Chamis.class, id);
    }

    @Override
    public List<Chamis> getAll() {
        return entityManager.createNamedQuery("getAllChamis", Chamis.class).getResultList();
    }
}