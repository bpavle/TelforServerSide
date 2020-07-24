/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.dao;

import com.etf.rms.telforserverside.data.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class AuthorDao {
    private static final AuthorDao instance = new AuthorDao();
    
    private AuthorDao(){};
    /**
     * @return the AuthorDao instance 
     */
    public static AuthorDao getInstance(){
        return instance;
    }
    
    
    public Author find(int authorId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        Author author = null;
      try {
            ps = con.prepareStatement("SELECT * FROM author where author_id=?");
            ps.setInt(1, authorId);
            rs = ps.executeQuery();
            if (rs.next()) {
            author = new Author(authorId, rs.getString("firstName"), rs.getString("lastName"), rs.getString("username"),rs.getString("institution"),rs.getString("country"));
            
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return author;
    } 
    
    public ArrayList<Author> findAll(Connection con) throws SQLException{
       PreparedStatement ps=null;
       ResultSet rs = null;
      
       ArrayList<Author> list;
       
       list = new ArrayList<Author>();
       String sql="SELECT * FROM Author";
       
       try{
       ps = con.prepareStatement(sql);
       
       rs = ps.executeQuery();
       
       while(rs.next()){
          Author  author = new Author(rs.getInt("author_id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("username"),rs.getString("institution"),rs.getString("country"));
           list.add(author);
       }
       
       
       }
       finally{
           ResourcesManager.closeResources(rs,ps);
       }
       return list;
       
       
   }
    public ArrayList<Author> findByPaper(int paperId,Connection con) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs = null;
        Author author = null;
        ArrayList<Author> list;
      try {
            ps = con.prepareStatement("SELECT author.author_id,Country,firstName,lastName,institution,username from author,author_paper WHERE author_paper.author_id=author.author_id AND author_paper.paper_id=?");
            ps.setInt(1, paperId);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
            author = new Author(rs.getInt("author_id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("username"),rs.getString("institution"),rs.getString("country"));
            list.add(author);
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return list;
    }     
    
}
