/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6.entities;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sejawal
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
    , @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id")
    , @NamedQuery(name = "Car.findByMake", query = "SELECT c FROM Car c WHERE c.make = :make")
    , @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model")
    , @NamedQuery(name = "Car.findByYear", query = "SELECT c FROM Car c WHERE c.year = :year")
    , @NamedQuery(name = "Car.findByPlate", query = "SELECT c FROM Car c WHERE c.plate = :plate")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "[year]")
    private Integer year;
    @Column(name = "plate")
    private String plate;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Car(String make, String model, Integer year, String plate) {
        this(make, model, year);
        this.plate = plate;
    }

    public Car(String make, String model, Integer year) {
        Random random = new Random(System.nanoTime());
        StringBuilder newPlate = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            newPlate.append(random.nextInt(10));
        }

        this.make = make;
        this.model = model;
        this.year = year;
        this.plate = newPlate.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", plate=" + plate + '}';
    }

   

}
