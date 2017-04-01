/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import week4.entities.Laptop;
import week4.entities.NoteBook;
import week4.entities.Person;
import week4.entities.Student;
import week4.entities.Teacher;
import week4.persist.MyCrud;

/**
 *
 * @author sejawal
 */
public class Week4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MyCrud myCrud = new MyCrud("Week4PU");
        myCrud.jpqlTest();
//        NoteBook nb1 = new NoteBook(100);
//        NoteBook nb2 = new NoteBook(120);
//        NoteBook nb3 = new NoteBook(60);
//        NoteBook nb4 = new NoteBook(200);
//        NoteBook nb5 = new NoteBook(50);
//        NoteBook nb6 = new NoteBook(300);
//
//        Laptop dell = new Laptop("Dell");
//        Laptop mac = new Laptop("Mac");
//
//        Student jack = new Student("Jack", 3.25f);
//        Student jpql = new Student("Jack", 3.25f);
//        
//
//        myCrud.<NoteBook>persist(nb1);
//        myCrud.<NoteBook>persist(nb2);
//        myCrud.<NoteBook>persist(nb3);
//        jack.addNoteBook(nb1);
//        jack.addNoteBook(nb2);
//        jack.addNoteBook(nb3);
//        myCrud.<Person>persist(jack);
//
//        Student john = new Student("John", 3.2f);
//        myCrud.<NoteBook>persist(nb4);
//        myCrud.<NoteBook>persist(nb5);
//        john.addNoteBook(nb4);
//        john.addNoteBook(nb5);
//        myCrud.<Person>persist(john);
//
//        Student jill = new Student("Jill", 3.6f);
//        myCrud.<NoteBook>persist(nb6);
//        jill.addNoteBook(nb6);
//        myCrud.<Person>persist(jill);
//
//        Teacher jim = new Teacher("Jim", 45000);
//        myCrud.<Laptop>persist(dell);
//        jim.setLaptop(dell);
//        myCrud.<Person>persist(jim);
//
//        Teacher jasmin = new Teacher("Jasmin", 46000);
//        myCrud.<Laptop>persist(mac);
//        jasmin.setLaptop(mac);
//        myCrud.<Person>persist(jasmin);
//
////TO DELETE UNCOMMENT THE BELOW CODE
////        System.out.println(myCrud.deleteStudent(3));
////        System.out.println(myCrud.deleteStudent(3));
////        System.out.println(myCrud.deleteStudent(3));
    }

}
