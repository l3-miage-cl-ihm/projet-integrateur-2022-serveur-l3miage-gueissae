package repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataBase.model.Chamis;
import dataBase.model.Defis;
import dataBase.repository.api.ChamisRepository;
import dataBase.repository.api.DefisRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class ChamisTest extends Base {

    ChamisRepository chamisRepository;
    DefisRepository defisRepository;

    @BeforeEach
    void before() {
        chamisRepository = daoFactory.newChamisRepository(entityManager);
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
    
        final Chamis chamis = new Chamis();
        chamis.setLogin("loginChamis1");

        entityManager.getTransaction().begin();
        chamisRepository.save(chamis);
        entityManager.getTransaction().commit();
        entityManager.detach(chamis);

        assertThat(chamisRepository.findById(chamis.getLogin())).isNotNull();
        assertThat(chamisRepository.findById(chamis.getLogin())).isNotEqualTo("loginChamis1");

    }

    @Test
    void souldDelete(){
        final Chamis chamis = new Chamis();
        chamis.setLogin("loginChamis");

        entityManager.getTransaction().begin();
        chamisRepository.save(chamis);
        entityManager.getTransaction().commit();

        assertThat(chamisRepository.findById(chamis.getLogin())).isNotNull();

        entityManager.getTransaction().begin();
        chamisRepository.delete(chamis);
        entityManager.getTransaction().commit();
        entityManager.detach(chamis);

        assertThat(chamisRepository.findById(chamis.getLogin())).isNull();
    }

    @Test
    void shouldGetAll() {
        final Chamis chamis1 = new Chamis();
        chamis1.setLogin("loginChamis1");

        final Chamis chamis2 = new Chamis();
        chamis2.setLogin("loginChamis2");

        entityManager.getTransaction().begin();
        chamisRepository.save(chamis1);
        chamisRepository.save(chamis2);
        entityManager.getTransaction().commit();
        entityManager.detach(chamis1);
        entityManager.detach(chamis2);

        assertThat(chamisRepository.getAll().get(0).getLogin()).isEqualTo(chamis1.getLogin());
        assertThat(chamisRepository.getAll().get(1).getLogin()).isEqualTo(chamis2.getLogin());
    }

    @Test
    void shouldGetAndSet() {

        final Chamis chamis = new Chamis();
        final List<Defis> defis = new ArrayList<Defis>(); 
        final Defis defi1 = new Defis();
        final Defis defi2 = new Defis();

        defi1.setTitre("coucou");
        defi2.setDescription("description");

        defis.add(defi1);
        defis.add(defi2);

        chamis.setLogin("loginChamis1");
        chamis.setAge(14);
        chamis.setDefis(defis);

        entityManager.getTransaction().begin();
        chamisRepository.save(chamis);
        defisRepository.save(defi1);
        defisRepository.save(defi2);
        entityManager.getTransaction().commit();
        entityManager.detach(chamis);

        assertThat(chamisRepository.findById(chamis.getLogin()).getAge()).isEqualTo(14);
        assertThat(chamisRepository.findById(chamis.getLogin()).getDefis().get(0).getTitre()).isEqualTo("coucou");
        assertThat(chamisRepository.findById(chamis.getLogin()).getDefis().get(1).getDescription()).isEqualTo("description");
    }
}