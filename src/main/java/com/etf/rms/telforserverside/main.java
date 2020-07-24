/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etf.rms.telforserverside;

import com.etf.rms.telforserverside.dao.ResourcesManager;
import java.sql.SQLException;

/**
 *
 * @author Pikacu
 */
public class main {
    
    public static void main() throws SQLException{
        ResourcesManager.getConnection();
                
    }
}
