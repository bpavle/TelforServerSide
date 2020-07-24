/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.dao;

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
public class SectionDao {
     private static final SectionDao instance = new SectionDao();
    
    private SectionDao(){};
    /**
     * @return the SectionDao instance 
     */
    public static SectionDao getInstance(){
        return instance;
    }
    
    
    public Section find(int sectionId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        Section section = null;
      try {
            ps = con.prepareStatement("SELECT * FROM section where section_id=?");
            ps.setInt(1, sectionId);
            rs = ps.executeQuery();
            if (rs.next()) {
            section = new Section(sectionId, rs.getString("title"));
            
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return section;
    } 
    
    public ArrayList<Section> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
      
       ArrayList<Section> list;
       
       list = new ArrayList<Section>();
       String sql="SELECT * FROM Section";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
          Section  section = new Section(rs.getInt("section_id"), rs.getString("title"));
           list.add(section);
       }
       
       
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
    
    public ArrayList<Section> findByChairperson(int chairpersonId,Connection con) throws SQLException{
         PreparedStatement ps=null;
        ResultSet rs = null;
        Section section = null;
        ArrayList<Section> list = new ArrayList<>();
      try {
            ps = con.prepareStatement("SELECT section.section_id,section.title from section,session WHERE section.section_id=session.section_id AND session.chairperson_id=?");
            ps.setInt(1, chairpersonId);
            rs = ps.executeQuery();
            while (rs.next()) {
            section = new Section(chairpersonId, rs.getString("title"));
            list.add(section);
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return list;
    }
}
