/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sejawal
 */
public class MyPersister {

    EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("Week4PU");
    EntityManager em;  //= emf.createEntityManager();

    public MyPersister(String puName) {
        init(puName);
    }

    public <T> void persist(T t) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(t);
        et.commit();
    }

    public <T> void delete(T t) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(t);
        et.commit();
    }

    public <T> T get(Class<T> t, int id) {
        return em.find(t, id);
    }

    private void init(String puName) {
        emf = Persistence.createEntityManagerFactory(puName);
        em = emf.createEntityManager();

    }

    public void start(String puName) {
        if (emf == null) {
            init(puName);
        }
    }

    public EntityManager getEM() {
        return em;
    }

    public void close() {
        emf = null;
        em.close();
        emf.close();
    }
}
