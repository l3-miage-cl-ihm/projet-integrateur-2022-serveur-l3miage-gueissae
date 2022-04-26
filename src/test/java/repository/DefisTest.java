package repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataBase.model.Defis;
import dataBase.repository.api.DefisRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class DefisTest extends Base {

    DefisRepository defisRepository;

    @BeforeEach
    void before() {
        defisRepository = daoFactory.newDefisRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * Test des méthodes save() et fondById()
     */
    @Test
    void shouldSaveAndFindById() {
    
        final Defis defis = new Defis();

        entityManager.getTransaction().begin();
        defisRepository.save(defis);
        entityManager.getTransaction().commit();
        entityManager.detach(defis);

        assertThat(defisRepository.findById(defis.getId())).isNotNull();
        assertThat(defisRepository.findById(defis.getId())).isNotEqualTo(defis);

    }

    @Test
    void souldDelete(){
        final Defis defis = new Defis();

        entityManager.getTransaction().begin();
        defisRepository.save(defis);
        entityManager.getTransaction().commit();

        assertThat(defisRepository.findById(defis.getId())).isNotNull();

        entityManager.getTransaction().begin();
        defisRepository.delete(defis);
        entityManager.getTransaction().commit();
        entityManager.detach(defis);

        assertThat(defisRepository.findById(defis.getId())).isNull();
    }

    @Test
    void shouldGetAll() {
        final Defis defi1 = new Defis();
        System.out.println("AAAAAAAAAAAAAAAAAAA : " + defi1.getId());

        final Defis defi2 = new Defis();
        System.out.println("AAAAAAAAAAAAAAAAAAA : " + defi2.getId());

        entityManager.getTransaction().begin();
        defisRepository.save(defi1);
        defisRepository.save(defi2);
        entityManager.getTransaction().commit();
        entityManager.detach(defi1);
        entityManager.detach(defi2);

        assertThat(defisRepository.getAll().get(0).getId()).isEqualTo(defi1.getId());
        assertThat(defisRepository.getAll().get(1).getId()).isEqualTo(defi2.getId());
    }
}