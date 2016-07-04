/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    
    public static final String TEXTFILE_CAPITAL = "Text File";
    public static final String TEXTFILE_EXTENSION = "txt";
    
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
    
    //Home View
    public static final String DASHBOARD_URL = "http://localhost/Emp-Sense-Dashboard/index.php";
    public static final String DASHBOARD_NOT_AVAIL = "Sorry, Dashboard is not available.";
    public static final String DASHBOARD_ERROR = "Dashboard Error";
    
    //Extract View
    public static final String PLEASE_SELECT_FILE = "Please select a source file";
    public static final String PLEASE_ENTER_TABLENAME = "Please please enter a name for table";
    
    public static final String REMOVE_FILE = "Would You Like to remove the selected file?";
    public static final String WARNING = "Warning";
    
    public static final String CLOSE_WINDOW_QUESTION = "Are you sure to close this window?";
    public static final String CLOSE_WINDOW = "Closing Window";   
    
    //Data View
    public static final String ORIGINAL_CSV_PATH = "src/etl/outputs/originalData.csv";
    
    //Attribute Mapper View
    //Attributes
    public static final String EMPLOYEE_ID = "Employee ID";
    public static final String EMPLOYEE_NAME = "Employee Name";
    public static final String AGE = "Age";
    public static final String GENDER = "Gender";
    public static final String MARITAL_STAT = "Marital Status";
    public static final String HAVING_DEGREE = "Having Degree";
    public static final String JOB_ROLE = "Job Role";
    public static final String TENURE = "Tenure";
    public static final String SALARY = "Salary";
    public static final String NO_OF_LEAVES = "No of Leaves";
    public static final String DISTANCE = "Distance";
    public static final String NO_OF_DEPENDENTS = "No of Dependents";
    public static final String CHURN = "Churn";
    
    //Rules
    public static final String SELECT_A_RULE = "Select a Rule";
    public static final String REMOVE_NULL_ROWS = "Remove Null Value Rows";
    public static final String REMOVE_DUPLICATES = "Remove Duplicates";
    public static final String SORT = "Sort";
    public static final String FILL_MISSING_VALUES = "Fill Missing Values";
    public static final String NUMBER_VALIDATION = "Number Validation";
    //*To add new attribute
    
    public static final String[] ATTRIBUTES = new String[]{
        EMPLOYEE_ID, EMPLOYEE_NAME, AGE , GENDER, MARITAL_STAT, 
        HAVING_DEGREE, JOB_ROLE, TENURE,
        SALARY, NO_OF_LEAVES, DISTANCE, NO_OF_DEPENDENTS, CHURN
    };
    public static final Map<String, List<String>> RULES_LIST = 
            new HashMap<String, List<String>>(){
        {
            put(EMPLOYEE_ID, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(REMOVE_DUPLICATES);
                            add(SORT);                            
                        };
                    }
            );
            
            put(EMPLOYEE_NAME, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(REMOVE_DUPLICATES);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(AGE, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(NUMBER_VALIDATION);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(GENDER, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(MARITAL_STAT, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(HAVING_DEGREE, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(JOB_ROLE, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(TENURE, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(NUMBER_VALIDATION);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(SALARY, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(NUMBER_VALIDATION);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(NO_OF_LEAVES, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(NUMBER_VALIDATION);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(DISTANCE, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(NUMBER_VALIDATION);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(NO_OF_DEPENDENTS, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(NUMBER_VALIDATION);
                            add(FILL_MISSING_VALUES);
                            add(SORT);
                        };
                    }
            );
            
            put(CHURN, 
                    new ArrayList<String>()
                    {
                        { 
                            add(SELECT_A_RULE);
                            add(REMOVE_NULL_ROWS);
                            add(SORT);                            
                        };
                    }
            );
        }
    };
    
    
    
    //Define Rules View
    public static final String RULE_ERROR = "This Rule is already exists";
    public static final String INVALID_RULE = "Please select a Rule";
    public static final String REMOVE_RULE = "Would You Like to remove this rule?";
    public static final String CREATING_DB = "Creating Database....";
    public static final String PLEASE_WAIT = "Please Wait.....";
    public static final String ATTRIBUTES_TXT = "attibutes";
    public static final String FILE_PATH_TXT = "filePath";
    public static final String ATTR_JSON_PATH = "src/etl/outputs/attributes.json";
    
    //Controllers
    //CreateCleanCSV
    public static final String CLEANSED_DATA_PYTHON_PATH = "python src/etl/pythonCodes/cleanData.py";
    public static final String CLEANSED_DATA_PATH = "src/etl/outputs/cleansed.csv";
    public static final String CLEANSED_RAW_DATA_PATH = "src/etl/outputs/rawData.csv";
    public static final String TRAIN_DATATABLE = "employeesIT";
    public static final String TRAIN_RAW_DATATABLE = "employeesIT_raw";
    public static final String PREDICT_DATATABLE = "employeesIT";
    public static final String PREDICT_RAW_DATATABLE = "employeesIT_raw";
    
    //CreateCleanCSV
    public static final String DATATYPE_SELECT_DIALOG_TITLE = "Select Dataset Type";
    public static final String DATATYPE_SELECT_DIALOG_LABEL_TEXT = "Please Select what type of database you selected";
    public static final String TRAIN_DATASET = "Train Dataset";
    public static final String PREDICT_DATASET = "Preciction Dataset";
    public static final String DONE_TXT = "Done";
    
    //CreatingDBDialog
    public static final String WAITING_IMG_PATH = "src/etl/images/please_wait.gif";
    public static final String DB_INSERT_MSG = " Inserted into Database";
    public static final String DB_UPDATE_SUCCESS_MSG = "Successfully Updated the Database";
    public static final String SUCCESS_IMG_PATH = "src/etl/images/success_db.png";
    public static final String DB_CREATION_MSG = "Database Creation Done";
    
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
