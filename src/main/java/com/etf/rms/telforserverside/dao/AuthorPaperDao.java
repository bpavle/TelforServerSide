/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.dao;

import com.etf.rms.telforserverside.data.Author;
import com.etf.rms.telforserverside.data.AuthorPaper;
import com.etf.rms.telforserverside.data.Paper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class AuthorPaperDao {
    private static final AuthorPaperDao instance = new AuthorPaperDao();
    
    private AuthorPaperDao(){};
    /**
     * @return the AuthorPaperDao instance 
     */
    public static AuthorPaperDao getInstance(){
        return instance;
    }
    
    
    public AuthorPaper find(int authorPaperId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        AuthorPaper authorPaper = null;
      try {
            ps = con.prepareStatement("SELECT * FROM author_paper where author_paper_id=?");
            ps.setInt(1, authorPaperId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Author author = AuthorDao.getInstance().find(rs.getInt("author_id"), con);
                Paper paper = PaperDao.getInstance().find(rs.getInt("paper_id"), con);
                authorPaper = new AuthorPaper(authorPaperId, author,paper);
            
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return authorPaper;
    } 
    
    public ArrayList<AuthorPaper> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
      
       ArrayList<AuthorPaper> list;
       
       list = new ArrayList<AuthorPaper>();
       String sql="SELECT * FROM author_paper";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
         Author author = AuthorDao.getInstance().find(rs.getInt("author_id"), con);
                Paper paper = PaperDao.getInstance().find(rs.getInt("paper_id"), con);
                AuthorPaper authorPaper = new AuthorPaper(rs.getInt("author_paper_id"), author,paper);
           list.add(authorPaper);
       }
       
       
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
    
        
}
