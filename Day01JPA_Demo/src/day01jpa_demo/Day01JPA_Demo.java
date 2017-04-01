/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01jpa_demo;

import day01jpa_demo.entities.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sejawal
 */
public class Day01JPA_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student jack = new Student("Jack", 33);
        Student john = new Student("John", 33);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Day01JPA_DemoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(jack);
        em.persist(john);
        et.commit();
        em.close();
        emf.close();
        
        // TODO code application logic here
    }
    
}
