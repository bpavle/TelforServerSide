/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.dao;

import com.etf.rms.telforserverside.data.Chairperson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @Author Pikacu
 */
public class ChairpersonDao {
     private static final ChairpersonDao instance = new ChairpersonDao();
    
    private ChairpersonDao(){};
    /**
     * @return the ChairpersonDao instance 
     */
    public static ChairpersonDao getInstance(){
        return instance;
    }
    
    
    public Chairperson find(int chairpersonId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        Chairperson chairperson = null;
      try {
            ps = con.prepareStatement("SELECT * FROM chairperson where chairperson_id=?");
            ps.setInt(1, chairpersonId);
            rs = ps.executeQuery();
            if (rs.next()) {
            chairperson = new Chairperson(chairpersonId, rs.getString("firstName"), rs.getString("lastName"));
            
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return chairperson;
    } 
    
    public ArrayList<Chairperson> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
      
       ArrayList<Chairperson> list;
       
       list = new ArrayList<Chairperson>();
       String sql="SELECT * FROM Chairperson";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
          Chairperson  chairperson = new Chairperson(rs.getInt("chairperson_id"), rs.getString("firstName"), rs.getString("lastName"));
           list.add(chairperson);
       }
       
       
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
    
}
