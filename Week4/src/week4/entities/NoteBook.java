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
public class NoteBook {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int page;

    public NoteBook() {
    }
    
    public NoteBook(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "NoteBook{" + "id=" + id + ", page=" + page + '}';
    }
}
