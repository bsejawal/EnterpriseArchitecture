/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author sejawal
 */
@Entity
@DiscriminatorValue("T")
public class Teacher extends Person {

    private double salary;

    private Laptop laptop;

    public Teacher() {
    }

    public Teacher(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    } 

    @Override
    public String toString() {
        return "Teacher{id="+super.getId()+", name="+super.getName() + ", salary=" + salary + ", laptop=" + laptop + '}';
    }
    
    
    
}
