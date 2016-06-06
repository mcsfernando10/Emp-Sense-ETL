/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import static etl.readers.ReadCSV.jLableProgress;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author suren
 */
public class ReadJSON implements Runnable{
    //Public variables
    public static String selectedFilePath;
    public static JTable tableView;
    public static JLabel jLableProgress;
    public static JButton extractBtn;
    //Private variables
    private Thread thread;
    private FileReader selectedFile;
    private DefaultTableModel model;
    private JSONArray employeeList;
    private String[] header;
    
    public DefaultTableModel createTableModel(){
        JSONParser parser = new JSONParser();
        try {                  
            selectedFile = new FileReader(selectedFilePath);  
            Object obj = parser.parse(selectedFile);
            JSONObject jsonObject = (JSONObject) obj;
            //Retrieve employee list
            employeeList = 
                    (JSONArray) jsonObject.get(StringConstants.EMPLOYEES_TEXT);
            //Create header of table
            JSONObject firstEmployee = 
                    (JSONObject) employeeList.get(NumberConstants.ZERO);
            Set<String> objectKeys = firstEmployee.keySet();
            header = objectKeys.toArray(new String[objectKeys.size()]); 
            model = new DefaultTableModel(header,NumberConstants.ZERO);            
            return model;                            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                selectedFile.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return model;
    }
    
    /*
    * @Method fillTable 
    * Fill Table with Reading line by line of the CSV File
    */   
    public void fillTable(){
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
            model.addRow(values);
        }
        //JOptionPane.showMessageDialog(null, "Data Loading Successful");
        jLableProgress.setVisible(false);
        extractBtn.setEnabled(true);
        extractBtn.setEnabled(true);
    }

    @Override
    public void run() {
        extractBtn.setEnabled(false);
        DefaultTableModel jsonModel = createTableModel();
        tableView.setModel(jsonModel);    
        fillTable();
    }
    
    /*
    * @Method start 
    * Initialize thread if not initialized and start it
    */ 
    public void start(){
        extractBtn.setEnabled(false);
        if (thread == null)
        {
           thread = new Thread (this);
           thread.start ();
        }
    }
    
    public String[] getHeaders(){
        return header;
    }
}
