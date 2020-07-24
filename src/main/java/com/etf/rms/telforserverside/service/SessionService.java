/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.service;

import com.etf.rms.telforserverside.dao.ChairpersonDao;
import com.etf.rms.telforserverside.dao.SectionDao;
import com.etf.rms.telforserverside.dao.SessionDao;
import com.etf.rms.telforserverside.dao.ResourcesManager;
import com.etf.rms.telforserverside.data.Chairperson;
import com.etf.rms.telforserverside.data.Section;
import com.etf.rms.telforserverside.data.Session;
import com.etf.rms.telforserverside.exception.TelforException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class SessionService {

    
    
        private static final SessionService instance = new SessionService();

    private SessionService() {
    }

    public static SessionService getInstance() {
        return instance;
    }
    
    public Session findSession(int sessionId) throws SQLException, TelforException {
        Connection con = ResourcesManager.getConnection();
        Session session = SessionDao.getInstance().find(sessionId, con);
        ResourcesManager.closeConnection(con);
        return session;
    }

    public ArrayList<Session> findAllSessions() throws SQLException, TelforException {
        Connection con = ResourcesManager.getConnection();
        ArrayList<Session> list = new ArrayList<Session>();
        list = SessionDao.getInstance().findAll(con);
        ResourcesManager.closeConnection(con);
        return list;
    }
       public Section findSection(int sectionId) throws SQLException, TelforException{
       Connection con = ResourcesManager.getConnection();
       Section section = SectionDao.getInstance().find(sectionId, con);
       ResourcesManager.closeConnection(con);
       return section;
   }
   
   public ArrayList<Section> findAllSections() throws SQLException,TelforException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Section> list = new ArrayList<Section>();
       list = SectionDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   
          public Chairperson findChairperson(int chairpersonId) throws SQLException, TelforException{
       Connection con = ResourcesManager.getConnection();
       Chairperson chairperson = ChairpersonDao.getInstance().find(chairpersonId, con);
       ResourcesManager.closeConnection(con);
       return chairperson;
   }
   
   public ArrayList<Chairperson> findAllChairpersons() throws SQLException,TelforException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Chairperson> list = new ArrayList<Chairperson>();
       list = ChairpersonDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   
   
   
}
