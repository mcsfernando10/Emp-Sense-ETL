/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.db;

import etl.constants.StringConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            String query = "Select * "
                    + "from login "
                    + "where username=? and password=?";
            PreparedStatement pst = 
                    (PreparedStatement) connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    
    
    public void insertDataToTrainTable(String tableName,String[] employeeRow) {
        try {            
            int stringArrSize = employeeRow.length;
            String query = "Insert into " + tableName + " values (";
            for(int i=0;i<stringArrSize;i++){
                //Insert churn probability initially - 0.0
                if(i==stringArrSize-1)
                    query += "'" + employeeRow[i] + "','0.0'";
                else
                    query += "'" + employeeRow[i] + "',";
            }
            query += ")";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertRawDataToTrainTable(String tableName,String[] employeeRow) {
        try {            
            int stringArrSize = employeeRow.length;
            String query = "Insert into " + tableName + " values (";
            for(int i=0;i<stringArrSize;i++){
                if(i==stringArrSize-1)
                    query += "'" + employeeRow[i] + "'";
                else
                    query += "'" + employeeRow[i] + "',";
            }
            query += ")";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Float> getAccuracy(){
        List<Float> accuracyList = new ArrayList<Float>();
        try {
            String query = "Select * "
                    + "from accuracy_confusion_mse";
            PreparedStatement pst = 
                    (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                accuracyList.add(rs.getFloat("confusion_accuracy"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accuracyList;
    }
    
    public void insertTuningData(boolean value) {
        try {
            String query = "Insert into tune_user_selection values (" + value + ")";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteTuningData() {
        try {
            String query = "Delete from tune_user_selection";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertDataToPredictTable(String tableName,String[] employeeRow) {
        try {            
            int stringArrSize = employeeRow.length;
            String query = "Insert into " + tableName + " values (";
            for(int i=0;i<stringArrSize;i++){
                //Insert churn probability(0.0) and churn - false(0)
                if(i==stringArrSize-1)
                    query += "'" + employeeRow[i] + "', '0.0'";
                else
                    query += "'" + employeeRow[i] + "',";
            }
            query += ")";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertRawDataToPredictTable(String tableName,String[] employeeRow) {
        try {            
            int stringArrSize = employeeRow.length;
            String query = "Insert into " + tableName + " values (";
            for(int i=0;i<stringArrSize;i++){
                //Insert churn - false(0)
                if(i==stringArrSize-2)
                    query += "'" + employeeRow[i] + "'";
                else if(i==stringArrSize-1)
                    break;
                else
                    query += "'" + employeeRow[i] + "',";
            }
            query += ")";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
