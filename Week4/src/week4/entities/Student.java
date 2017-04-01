/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author sejawal
 */

@Entity
@DiscriminatorValue("S")
public class Student extends Person {
    
    
    private Float gpa;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<NoteBook> noteBooks = new ArrayList<>();
    
    public Student() {
    }

    public Student(String name, Float gpa) {
        super(name);
        this.gpa = gpa;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public List<NoteBook> getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(List<NoteBook> noteBooks) {
        this.noteBooks = noteBooks;
    }
    
    public void addNoteBook(NoteBook noteBook){
        noteBooks.add(noteBook);
    }

    @Override
    public String toString() {
        return "Student{ id= "+super.getId()+", name="+super.getName() + ", gpa=" + gpa + ", noteBooks=" + noteBooks + "}";
    }
    
    
    
    
}
