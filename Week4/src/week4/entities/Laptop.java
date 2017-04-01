/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sejawal
 */

@Entity
public class Laptop {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String model;

    public Laptop() {
    }
    
    public Laptop(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" + "id=" + id + ", model=" + model + '}';
    }
    
    
    
    
    
    
    
    
}
