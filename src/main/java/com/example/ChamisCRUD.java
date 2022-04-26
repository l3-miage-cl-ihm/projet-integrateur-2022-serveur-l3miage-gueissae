package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import dataBase.model.Chamis;
import dataBase.repository.api.ChamisRepository;
import dataBase.repository.impl.BaseRepositoryImpl;
import dataBase.repository.impl.ChamisRepositoryImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/chamis")
@Repository
@NoRepositoryBean
public class ChamisCRUD extends BaseRepositoryImpl {

    @Autowired
    private DataSource dataSource;

    /*
     * @PersistenceUnit(unitName = "readwrite.config")
     * private EntityManagerFactory entityManagerFactory;
     */

    private ChamisRepository repositoryChamis;

    protected ChamisCRUD(EntityManager entityManager) {
        super(entityManager);
        // this.entityManager = entityManager;
        repositoryChamis = new ChamisRepositoryImpl(entityManager);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * !!! FONCTION A CHANGER !!!! NOUS ALLONS TOUT FAIRE AVEC JPA.
     * ELLE PRENDS EN PARAMETRES UNE REQUETE HTTP, ET RENVOIE UNE REPONSE.
     * Cette réponse est la liste de tous les utilisateurs.
     * Renvoie null si on arrive pas à se connecter à la base.
     * 
     */
    @GetMapping("/")
    ArrayList<Chamis> allChamis(HttpServletResponse response) {
        try {
            ArrayList<Chamis> L = new ArrayList<Chamis>(repositoryChamis.getAll());
            response.setStatus(200);
            return L;
        } catch (Exception e) {
            response.setStatus(500);
            try {
                response.getOutputStream().print(e.getMessage());
            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * !!! FONCTION A CHANGER !!!! NOUS ALLONS TOUT FAIRE AVEC JPA.
     * ELLE PRENDS EN PARAMETRES UNE REQUETE HTTP, ET UN ID D'UTILISATEUR.
     * Return l'utilisateur associé à l'id, null s'il nexiste pas.
     * Renvoie null si on arrive pas à se connecter à la base.
     * Set le status à 404 si l'utilisateur n'existe pas.
     * Set le status à 500 si la connexion ne s'est pas faite.
     * Le status est à 200 de base si tout se passe bien.
     * 
     */

    @GetMapping("/{chamisId}")
    Chamis read(@PathVariable(value = "chamisId") String id, HttpServletResponse response) {
        try {
            Chamis myChamis = new Chamis();
            myChamis = repositoryChamis.findById(id);
            // String login = myChamis.getLogin();
            if (myChamis == null) {
                response.setStatus(404);
                return null;
            } else {
                return myChamis;
            }
        } catch (Exception e3) {
            // si on arrive pas à se connecter
            response.setStatus(500);
            try {
                response.getOutputStream().print(e3.getMessage());
            } catch (Exception e4) {
                System.err.println(e4.getMessage());
            }
            System.err.println(e3.getMessage());
            return null;
        }
    }

    /**
     * 
     * !!! FONCTION A CHANGER !!!! NOUS ALLONS TOUT FAIRE AVEC JPA.
     * ELLE PRENDS EN PARAMETRES UNE REQUETE HTTP, ET UN ID D'UTILISATEUR.
     * Return l'utilisateur associé à l'id, null s'il nexiste pas.
     * Renvoie null si on arrive pas à se connecter à la base.
     * Set le status à 404 si l'utilisateur n'existe pas.
     * Set le status à 500 si la connexion ne s'est pas faite.
     * Le status est à 200 de base si tout se passe bien.
     * 
     */
    @Transactional(propagation = Propagation.MANDATORY)
    @PostMapping("/test")
    Chamis create2(){
        try {
            Chamis myChamis = new Chamis();

        myChamis.setLogin("test");
        myChamis.setAge(19);
        //entityManager.getTransaction().begin();
        repositoryChamis.save(myChamis);
        //entityManager.getTransaction().commit();

        return myChamis;
        }
        catch (Exception eeeeeee ){
            System.out.println("OUI OUI LA BAGUETTE LA OUI "+eeeeeee);
            return null;
        }
    }
    
    @Transactional
    @PostMapping("/{chamisId}")
    Chamis create(@PathVariable(value = "chamisId") String id, @RequestBody Chamis chamis,
            HttpServletResponse response) {
        try {

            if (id.compareTo(chamis.getLogin()) != 0) {
                response.setStatus(412);
                return null;
            }

            Chamis myChamis = new Chamis();

            myChamis.setLogin(chamis.getLogin());
            System.out.println(chamis.getLogin());
            myChamis.setDefis(chamis.getDefis());
            myChamis.setAge(chamis.getAge());

            // EntityManager entityManager = entityManagerFactory.createEntityManager();

            // entityManager.getTransaction().begin();

            /*
             * if (!ObjectUtils.isEmpty(myChamis) && !entityManager.contains(myChamis)) {
             * entityManager.persist(myChamis);
             * entityManager.flush();
             * }
             * entityManager.getTransaction().commit();
             * return myChamis;
             */

            try {
                if (!entityManager.contains(myChamis)) {
                    repositoryChamis.save(myChamis);

                } else {
                    response.setStatus(403);
                    System.err.println("ERREUR 403 : Le chamis existe déjà. ");
                    return null;
                }

                // entityManager.getTransaction().commit();
                // entityManager.detach(myChamis);
                return myChamis;
            } catch (Exception e) {
                System.err.println("ERREUR 501 :: " + e.getMessage());
                response.setStatus(501);
                return null;
            }
        } catch (Exception e3) {
            // si on arrive pas à se connecter
            response.setStatus(500);
            try {
                response.getOutputStream().print(e3.getMessage());
            } catch (Exception e4) {
                System.err.println(e4.getMessage());
            }
            System.err.println(e3.getMessage());
            return null;
        }
    }
}