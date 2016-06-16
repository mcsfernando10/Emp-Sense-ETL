/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import com.opencsv.CSVWriter;
import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.views.DataView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author suren
 */
public class ReadOriginalJSONandWrite implements Runnable{
    //Public variables
    public static String selectedFilePath;
    public static JFrame extractView;
    //Private variables
    private Thread thread;
    private FileReader selectedFile;
    private CSVWriter writer;
    private JSONArray employeeList;
    private String[] header;
    private List<String[]> data;
    
    public void createTableModel(){
        JSONParser parser = new JSONParser();
        data = new ArrayList<>();
        try {        
            //To write to file
            writer = new CSVWriter(new FileWriter(StringConstants.ORIGINAL_CSV_PATH)); 
            
            selectedFile = new FileReader(selectedFilePath);  
            Object obj = parser.parse(selectedFile);
            selectedFile.close();
            JSONObject jsonObject = (JSONObject) obj;
            //Retrieve employee list
            employeeList = 
                    (JSONArray) jsonObject.get(StringConstants.EMPLOYEES_TEXT);
            //Create header of table
            JSONObject firstEmployee = 
                    (JSONObject) employeeList.get(NumberConstants.ZERO);
            Set<String> objectKeys = firstEmployee.keySet();
            header = objectKeys.toArray(new String[objectKeys.size()]); 
            
            //Write header columns to csv
            data.add(header);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadOriginalJSONandWrite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ReadOriginalJSONandWrite.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /*
    * @Method fillTable 
    * Fill Table with Reading line by line of the CSV File
    */   
    public void fillTable(){
        try {
            int size = employeeList.size();
            //populate data table rows
            for(int i = NumberConstants.ZERO; i < size; i++){
                JSONObject employeeObject = (JSONObject) employeeList.get(i);
                Set<String> currentObjKeys = employeeObject.keySet();
                String[] keys =
                        currentObjKeys.toArray(new String[currentObjKeys.size()]);
                String[] values = new String[keys.length];
                for(int j = NumberConstants.ZERO; j < keys.length; j++){
                    values[j] = (String) employeeObject.get(keys[j]);
                }
                data.add(values);
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadOriginalJSONandWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {   
        createTableModel();
        fillTable();
        extractView.dispose();
        new DataView(StringConstants.ORIGINAL_CSV_PATH).setVisible(true);
    }
    
    /*
    * @Method start 
    * Initialize thread if not initialized and start it
    */ 
    public void start(){
        if (thread == null)
        {
           thread = new Thread (this);
           thread.start ();
        }
    }
}
