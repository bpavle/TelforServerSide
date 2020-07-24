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
public class Section implements Serializable{
    private int sectionId = -1;
    private String title;

    public Section() {
    }

    public Section(String title) {
        this.title = title;
    }
    
    public Section(int sectionId,String title) {
        this.sectionId = sectionId;
        this.title = title;
    }

   

    
    /**
     * @return the sectionId
     */
    public int getSectionId() {
        return sectionId;
    }

    /**
     * @param sectionId the sectionId to set
     */
    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    
     @Override
    public String toString() {
        return "Section{" + "sectionId=" + sectionId + ", title=" + title + '}';
    }
    
    
}
