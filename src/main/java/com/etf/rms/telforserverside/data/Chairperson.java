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
public class Chairperson implements Serializable {
    private int chairpersonId=-1;
    private String firstName;
    private String lastName;

    public Chairperson() {
    }

    public Chairperson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Chairperson(int chairpersonId,String firstName, String lastName) {
     this.chairpersonId=chairpersonId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the chairpersonId
     */
    public int getChairpersonId() {
        return chairpersonId;
    }

    /**
     * @param chairpersonId the chairpersonId to set
     */
    public void setChairpersonId(int chairpersonId) {
        this.chairpersonId = chairpersonId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Chairperson{" + "chairpersonId=" + chairpersonId + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

   
    
    
}
