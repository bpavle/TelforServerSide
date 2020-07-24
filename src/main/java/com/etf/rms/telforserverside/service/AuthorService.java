/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside.service;

import com.etf.rms.telforserverside.dao.AuthorDao;
import com.etf.rms.telforserverside.dao.AuthorPaperDao;
import com.etf.rms.telforserverside.dao.PaperDao;
import com.etf.rms.telforserverside.dao.ResourcesManager;
import com.etf.rms.telforserverside.data.Author;
import com.etf.rms.telforserverside.data.AuthorPaper;
import com.etf.rms.telforserverside.data.Paper;
import com.etf.rms.telforserverside.exception.TelforException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pikacu
 */
public class AuthorService {
    
        private static final AuthorService instance = new AuthorService();

    private AuthorService() {
    }

    public static AuthorService getInstance() {
        return instance;
    }
    
    
    
    
       public Author findAuthor(int authorId) throws SQLException, TelforException{
       Connection con = ResourcesManager.getConnection();
       Author author = AuthorDao.getInstance().find(authorId, con);
       ResourcesManager.closeConnection(con);
       return author;
   }
   
   public ArrayList<Author> findAllAuthors() throws SQLException,TelforException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Author> list = new ArrayList<Author>();
       list = AuthorDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
       public Paper findPaper(int paperId) throws SQLException, TelforException{
       Connection con = ResourcesManager.getConnection();
       Paper paper = PaperDao.getInstance().find(paperId, con);
       ResourcesManager.closeConnection(con);
       return paper;
   }
   
   public ArrayList<Paper> findAllPapers() throws SQLException,TelforException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Paper> list = new ArrayList<Paper>();
       list = PaperDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   
   public ArrayList<Paper> findPapersByAuthor(int authorId)  throws SQLException, TelforException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Paper> list = new ArrayList<Paper>();
       list = PaperDao.getInstance().findByAuthor(authorId,con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   
    public ArrayList<Author> findAuthorsByPaper(int paperId)  throws SQLException, TelforException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<Author> list = new ArrayList<Author>();
       list = AuthorDao.getInstance().findByPaper(paperId,con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   
          public AuthorPaper findAuthorPaper(int authorPaperId) throws SQLException, TelforException{
       Connection con = ResourcesManager.getConnection();
       AuthorPaper authorPaper = AuthorPaperDao.getInstance().find(authorPaperId, con);
       ResourcesManager.closeConnection(con);
       return authorPaper;
   }
   
   public ArrayList<AuthorPaper> findAllAuthorPapers() throws SQLException,TelforException{
       Connection con = ResourcesManager.getConnection();
       ArrayList<AuthorPaper> list = new ArrayList<AuthorPaper>();
       list = AuthorPaperDao.getInstance().findAll(con);
       ResourcesManager.closeConnection(con);
       return list;
   }
   
   
   
      
   
}
