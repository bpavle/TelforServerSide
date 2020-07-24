/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.data;

import java.io.Serializable;

/**
 *
 * @author Pikacu
 */
public class Author implements Serializable {
    private int authorId = -1;
    private String firstName;
    private String lastName;
    private String username;
    private String country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    private String institution;

    public Author() {
    }

    public Author(String firstName, String lastName, String username, String institution,String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.institution = institution;
        this.country =country;
    }
     public Author(int authorId,String firstName, String lastName, String username, String institution,String country) {
        this.authorId = authorId;
         this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.institution = institution;
    this.country =country;
     }

    public Author(int authorId, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + getAuthorId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", username=" + getUsername() + ", institution=" + getInstitution() + '}';
    }
    
    
    
    
}
