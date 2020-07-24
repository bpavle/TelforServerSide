/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.rest;

import com.etf.rms.telforserverside.data.Chairperson;
import com.etf.rms.telforserverside.data.Section;
import com.etf.rms.telforserverside.data.Session;
import com.etf.rms.telforserverside.exception.TelforException;

import com.etf.rms.telforserverside.service.SessionService;
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
@Path("session")
public class SessionRest {
    
    private final SessionService sessionService = SessionService.getInstance();

    @GET
    @Path("/{sessionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Session getSessionById(@PathParam("sessionId") int sessionId) throws TelforException, SQLException {
        return sessionService.findSession(sessionId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Session> getAllSessions() throws SQLException, TelforException {
        return sessionService.findAllSessions();
    }

    
    

    @GET
    @Path("chairperson/{chairpersonId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chairperson getChairpersonById(@PathParam("chairpersonId") int chairpersonId) throws TelforException, SQLException {
        return sessionService.findChairperson(chairpersonId);
    }

    @GET
    @Path("/chairperson")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Chairperson> getAllChairpersons() throws SQLException, TelforException {
        return sessionService.findAllChairpersons();
    }
    
    
    @GET
    @Path("section/{sectionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Section getSectionById(@PathParam("sectionId") int sectionId) throws TelforException, SQLException {
        return sessionService.findSection(sectionId);
    }

    @GET
    @Path("/section")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Section> getAllSections() throws SQLException, TelforException {
        return sessionService.findAllSections();
    }
}
