/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.persist;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import week4.entities.Student;

/**
 *
 * @author sejawal
 */
public class MyCrud {

    EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("Week4PU");
    EntityManager em;  //= emf.createEntityManager();

    public MyCrud(String puName) {
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

    public boolean deleteStudent(int id) {
        boolean flag = true;
        try {
            delete(get(Student.class, id));
        } catch (IllegalArgumentException ex) {
            System.out.println("error message : "+ ex.getMessage());
            flag = false;
        }
        return flag;
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

    public void close() {
        emf = null;
        em.close();
        emf.close();
    }
    
    public void jpqlTest(){
        String s = "SELECT s from Student s";
        
        TypedQuery<Student> query =
      em.createQuery(s, Student.class);
        List<Student> results = query.getResultList();
    }
}
