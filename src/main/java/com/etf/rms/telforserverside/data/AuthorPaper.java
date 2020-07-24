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
public class AuthorPaper implements Serializable {
    private int authorPaperId=-1;
    private Author author;
    private Paper paper;
    

    public AuthorPaper() {
    }

    public AuthorPaper(Author author, Paper paper) {
        this.author = author;
        this.paper = paper;
        
    }

    public AuthorPaper(int authorPaperId, Author author, Paper paper) {
        this.authorPaperId = authorPaperId;
        this.author = author;
        this.paper = paper;
        
    }

    
    
    /**
     * @return the authorPaperId
     */
    public int getAuthorPaperId() {
        return authorPaperId;
    }

    /**
     * @param authorPaperId the authorPaperId to set
     */
    public void setAuthorPaperId(int authorPaperId) {
        this.authorPaperId = authorPaperId;
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return the paper
     */
    public Paper getPaper() {
        return paper;
    }

    /**
     * @param paper the paper to set
     */
    public void setPaper(Paper paper) {
        this.paper = paper;
    }

  
    @Override
    public String toString() {
        return "AuthorPaper{" + "authorPaperId=" + authorPaperId + ", author=" + author + ", paper=" + paper + '}';
    }
    
}
