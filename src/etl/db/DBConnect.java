/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.db;

import etl.constants.StringConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suren
 */
public class DBConnect {

    private Connection connection;
    public DBConnect() {
        try {
            // MySQL database connection
            Class.forName(StringConstants.DB_CLASS);
            /*String connectionPath = StringConstants.DB_CONNECTION_PATH + 
                            StringConstants.DB_NAME + 
                            StringConstants.QUESTION_MARK +
                            StringConstants.DB_USER_TEXT +
                            StringConstants.EQUAL_SIGN + 
                            StringConstants.DB_USERNAME + 
                            StringConstants.AND_SIGN + 
                            StringConstants.DB_USER_PASSWORD_TEXT + 
                            StringConstants.EQUAL_SIGN +
                            StringConstants.DB_USER_PASSWORD;*/
            
            //System.out.println(connectionPath);
            //connection = DriverManager
            //        .getConnection(connectionPath);
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/empsense?" + "user=root&password=");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
