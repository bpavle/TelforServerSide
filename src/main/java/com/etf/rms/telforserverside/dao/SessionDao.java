/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.dao;


import com.etf.rms.telforserverside.data.Paper;
import com.etf.rms.telforserverside.data.Chairperson;
import com.etf.rms.telforserverside.data.Session;

import com.etf.rms.telforserverside.data.Section;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class SessionDao {
    
    private static final SessionDao instance = new SessionDao();
    
    private SessionDao(){};
    /**
     * @return the SessionDao instance 
     */
    public static SessionDao getInstance(){
        return instance;
    }
    
    
    public Session find(int sessionId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        Session session = null;
      try {
            ps = con.prepareStatement("SELECT * FROM session where session_id=?");
            ps.setInt(1, sessionId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Paper paper = PaperDao.getInstance().find(rs.getInt("paper_id"), con);
                Section section = SectionDao.getInstance().find(rs.getInt("section_id"), con);
                Chairperson chairperson = ChairpersonDao.getInstance().find(rs.getInt("chairperson_id"), con);
                
                
                session = new Session(sessionId, rs.getString("room"),rs.getString("dateTime"),section,chairperson,paper);
            
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return session;
    } 
    
    public ArrayList<Session> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
      
       ArrayList<Session> list;
       
       list = new ArrayList<Session>();
       String sql="SELECT * FROM session";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
         Paper paper = PaperDao.getInstance().find(rs.getInt("paper_id"), con);
         Section section = SectionDao.getInstance().find(rs.getInt("section_id"), con);
         Chairperson chairperson = ChairpersonDao.getInstance().find(rs.getInt("chairperson_id"), con);
                
                
         Session session = new Session(rs.getInt("session_id"), rs.getString("room"),rs.getString("dateTime"),section,chairperson,paper);
         list.add(session);
       }
       
       
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
    
}
