/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import week6.entities.Car;
import week6.entities.Car_;
import week6.persist.MyPersister;

/**
 *
 * @author sejawal
 */
public class Week6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyPersister myPersister = new MyPersister("week6PU");
//        Car car = myPersister.get(Car.class, 2);
//        System.out.println("car = " + car);

        EntityManager em = myPersister.getEM();
        
        //using JPQL
        System.out.println("===================JPQL");
        Query query = em.createQuery("SELECT c FROM Car c WHERE c.year > :year");
        int year = 2009;
        query.setParameter("year", year);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("car = " + car);
        }
        
        
        //using TypedQuery
        System.out.println("============================= All");
        TypedQuery<Car> typedQuery = em.createNamedQuery("Car.findAll", Car.class);
        List<Car> allCars = typedQuery.getResultList();
        for(Car car : allCars)
            System.out.println("car = " + car);
        
        System.out.println("============================= Make");
        TypedQuery<Car> typedQuery2 = em.createNamedQuery("Car.findByMake", Car.class);
        typedQuery2.setParameter("make", "toyota");
        List<Car> toyotaCars = typedQuery2.getResultList();
        for(Car car : toyotaCars)
            System.out.println("toyotaCars = " + car);
        
        System.out.println("===================== Criteria");
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);
        Root<Car> root = criteriaQuery.from(Car.class);
        criteriaQuery.select(root).where(builder.equal(root.get(Car_.make), "toyota")); //Car_.make is a meta model
        TypedQuery<Car> myQuery = em.createQuery(criteriaQuery);
        for(Car car : myQuery.getResultList())
            System.out.println("car = " + car);

//        createCars();
    }

    private static void createCars() {
        Car camry = new Car("Toyota", "camry", 2010);
        Car prize = new Car("Toyota", "prize", 2012);
        Car acura = new Car("Honda", "acura", 2009);
        MyPersister myPersister = new MyPersister("week6PU");
        myPersister.persist(camry);
        myPersister.persist(prize);
        myPersister.persist(acura);

    }

}
