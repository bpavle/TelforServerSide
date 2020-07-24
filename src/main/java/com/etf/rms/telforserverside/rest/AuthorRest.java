/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.rest;

import com.etf.rms.telforserverside.data.Author;
import com.etf.rms.telforserverside.data.AuthorPaper;
import com.etf.rms.telforserverside.data.Paper;
import com.etf.rms.telforserverside.exception.TelforException;
import com.etf.rms.telforserverside.service.AuthorService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Pikacu
 */
@Path("author")
public class AuthorRest {

    private final AuthorService authorService = AuthorService.getInstance();

    @GET
    @Path("/{authorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorById(@PathParam("authorId") int authorId) throws TelforException, SQLException {
        return authorService.findAuthor(authorId);
    }

    @GET
    @Path("/forPaper/{paperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Author> getAuthorsByPaper(@PathParam("paperId") int paperId) throws SQLException, TelforException{
        
        return authorService.findAuthorsByPaper(paperId);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Author> getAllAuthors() throws SQLException, TelforException {
        return authorService.findAllAuthors();
    }

    @GET
    @Path("paper/{paperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paper getPaperById(@PathParam("paperId") int paperId) throws TelforException, SQLException {
        return authorService.findPaper(paperId);
    }

    @GET
    @Path("/paper")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Paper> getAllPapers() throws SQLException, TelforException {
        return authorService.findAllPapers();
    }
    @GET
    @Path("/paper/forAuthor/{authorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Paper> getPapersByAuthor(@PathParam("authorId") int authorId) throws SQLException, TelforException {
        return authorService.findPapersByAuthor(authorId);
    }

    @GET
    @Path("authorPapers/{authorPaperId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorPaper getAuthorPaperById(@PathParam("authorPaperId") int authorPaperId) throws TelforException, SQLException {
        return authorService.findAuthorPaper(authorPaperId);
    }

    @GET
    @Path("/authorPapers")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AuthorPaper> getAllAuthorPapers() throws SQLException, TelforException {
        return authorService.findAllAuthorPapers();
    }
}
