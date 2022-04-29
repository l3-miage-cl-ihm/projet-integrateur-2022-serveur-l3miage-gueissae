package com.example.repositoryImpl;

import javax.persistence.EntityManager;

/**
 * Base class to derive when implementing a repository
 */
public abstract class BaseRepositoryImpl {

    protected final EntityManager entityManager;

    /**
     * Build a base repository
     * @param entityManager the entity manager
     */
    protected BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}