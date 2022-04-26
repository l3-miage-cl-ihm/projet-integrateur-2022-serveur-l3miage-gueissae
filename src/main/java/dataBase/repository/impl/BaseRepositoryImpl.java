package dataBase.repository.impl;

import javax.persistence.EntityManager;

public abstract class BaseRepositoryImpl {

    protected final EntityManager entityManager;

    protected BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}