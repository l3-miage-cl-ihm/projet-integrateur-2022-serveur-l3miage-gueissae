package repository;

import org.junit.jupiter.api.BeforeEach;

import dataBase.repository.RepositoryFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class Base {

    protected EntityManager entityManager;
    protected RepositoryFactory daoFactory = new RepositoryFactory();

    /**
     * Creates fresh thus empty database for each test method.
     */
    @BeforeEach
    public final void setup() {
        entityManager = Persistence.createEntityManagerFactory("TEST")
                .createEntityManager();
    }
}