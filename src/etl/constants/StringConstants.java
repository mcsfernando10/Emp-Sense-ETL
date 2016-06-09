/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.constants;

/**
 *
 * @author suren
 */
public class StringConstants {
    public static final String CSV_CAPITAL = "CSV";
    public static final String CSV_EXTENSION = "csv";
    
    public static final String XML_CAPITAL = "XML";
    public static final String XML_EXTENSION = "xml";
    
    public static final String EXCEL_NORMAL = "Excel";
    public static final String EXCEL_EXTENSION = "xlsx";
    
    public static final String JSON_CAPITAL = "JSON";
    public static final String JSON_EXTENSION = "json";
    
    public static final String SQL_CAPITAL = "SQL";
    public static final String SQL_EXTENSION = "sql";
    
    public static final String EMPTY_STRING = "";
    public static final String QUESTION_MARK = "?";
    public static final String AND_SIGN = "&";
    public static final String EQUAL_SIGN = "=";
    
    public static final String ICON_FILE_PATH = "src/etl/images/icon.gif";
    //Login View
    public static final String ERROR = "Error";
    public static final String EMPTY_FIELD = "Empty fields detected! Please fill up all fields";
    public static final String MD5_ENCRYPTION = "MD5";
    public static final String NO_ENCRYPTION_ALGO = "No Encryting algorithm";
    public static final String INCORRECT_CREDENTIALS = "Incorrect Login Credentials";
    public static final String IT = "IT";   
    
    //Extract View
    public static final String PLEASE_SELECT_FILE = "Please select a source file";
    public static final String PLEASE_ENTER_TABLENAME = "Please please enter a name for table";
    
    public static final String REMOVE_FILE = "Would You Like to remove the selected file?";
    public static final String WARNING = "Warning";
    
    //Attribute Mapper View
    //*To add new attribute
    public static final String[] ATTRIBUTES = new String[]{
        "Employee ID", "Employee Name", "Age", "Gender", "Marital Status", 
        "Having Degree", "Job Role", "Tenure",
        "Salary", "No of Leaves", "Distance", "No of Dependents"
    };
    
    //Define Rules View
    public static final String RULE_ERROR = "This Rule is already exists";
    public static final String INVALID_RULE = "Please select a Rule";
    public static final String REMOVE_RULE = "Would You Like to remove this rule?";
    //ReadJSON 
    public static final String EMPLOYEES_TEXT = "Employees";
    
    //Database
    public static final String DB_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "empsense";
    public static final String DB_USER_TEXT = "user";
    public static final String DB_USERNAME = "root";
    public static final String DB_USER_PASSWORD_TEXT = "password";
    public static final String DB_USER_PASSWORD = "root123";
    
}
