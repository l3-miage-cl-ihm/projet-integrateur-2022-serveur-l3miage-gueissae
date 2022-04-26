package dataBase.repository;

import dataBase.repository.api.*;
import dataBase.repository.impl.*;

import javax.persistence.EntityManager;

public class RepositoryFactory {

    public DefisRepository newDefisRepository(EntityManager entityManager) {
        return new DefisRepositoryImpl(entityManager);
    }

    public ChamisRepository newChamisRepository(EntityManager entityManager) {
        return new ChamisRepositoryImpl(entityManager);
    }

}