/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suren
 */
public class DBAccess {
    private Connection connection;

    public DBAccess() {
        DBConnect dbConnection = new DBConnect();
        connection = dbConnection.getConnection();
    }
    
    /*
    * @Method isLoginValid 
    * @Return boolean : user exists or not
    * Check the user availability with sql database
    * @param  Username and Password
    */
    public boolean isLoginValid(String username,String password) {
        try {
            DBConnect dbConnection = new DBConnect();
            Connection conn = dbConnection.getConnection();
            String query = "Select * "
                    + "from login "
                    + "where username=? and password=?";
            PreparedStatement pst = 
                    (PreparedStatement) conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    
    
}
