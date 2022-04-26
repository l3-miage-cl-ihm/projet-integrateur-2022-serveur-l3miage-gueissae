package dataBase.repository.impl;

import dataBase.model.Defis;
import dataBase.repository.api.DefisRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class DefisRepositoryImpl extends BaseRepositoryImpl implements DefisRepository {

    public DefisRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Defis entity) {
        entityManager.persist(entity);
        
    }

    @Override
    public void delete(Defis entity) {
        entityManager.remove(entity);
        
    }

    @Override
    public Defis findById(String id) {
        return entityManager.find(Defis.class, id);
    }

    @Override
    public List<Defis> getAll() {
        return entityManager.createNamedQuery("getAllDefis", Defis.class).getResultList();
    }}