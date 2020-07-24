/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.dao;

import com.etf.rms.telforserverside.data.Paper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Pikacu
 */
public class PaperDao {
    private static final PaperDao instance = new PaperDao();
    
    private PaperDao(){};
    /**
     * @return the PaperDao instance 
     */
    public static PaperDao getInstance(){
        return instance;
    }
    
    
    public Paper find(int paperId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        Paper paper = null;
      try {
            ps = con.prepareStatement("SELECT * FROM paper where paper_id=?");
            ps.setInt(1, paperId);
            rs = ps.executeQuery();
            if (rs.next()) {
            paper = new Paper(paperId, rs.getString("title"), rs.getString("abstract"), rs.getString("keywords"),rs.getString("index"));
            
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return paper;
    } 
    
    public ArrayList<Paper> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
      
       ArrayList<Paper> list;
       
       list = new ArrayList<Paper>();
       String sql="SELECT * FROM Paper";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
          Paper  paper = new Paper(rs.getInt("paper_id"), rs.getString("title"), rs.getString("abstract"),rs.getString("keywords"),rs.getString("index"));
           list.add(paper);
       }
       
       
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
    
        public ArrayList<Paper> findByAuthor(int authorId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        Paper paper = null;
        ArrayList<Paper> list;
      try {
            ps = con.prepareStatement("SELECT paper.paper_id,paper.abstract,paper.index,keywords ,title from paper, author_paper WHERE paper.paper_id=author_paper.paper_id AND author_id=?");
            ps.setInt(1, authorId);
            rs = ps.executeQuery();
            list= new ArrayList<>();
            while (rs.next()) {
            paper = new Paper(rs.getInt("paper_id"), rs.getString("title"), rs.getString("abstract"),rs.getString("keywords"),rs.getString("index"));
            list.add(paper);
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        
        return list;
    } 
}
