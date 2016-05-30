/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author suren
 */
public class ReadJSON {
    public DefaultTableModel readJSONFrom(String filePath){
        FileReader fileReader = null;
        DefaultTableModel model = null;
        JSONParser parser = new JSONParser();
        try {                  
            fileReader = new FileReader(filePath);  
            Object obj = parser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            //Retrieve employee list
            JSONArray employeeList = 
                    (JSONArray) jsonObject.get(StringConstants.EMPLOYEES_TEXT);
            //Create header of table
            JSONObject firstEmployee = 
                    (JSONObject) employeeList.get(NumberConstants.ZERO);
            Set<String> objectKeys = firstEmployee.keySet();
            String[] header = objectKeys.toArray(new String[objectKeys.size()]); 
            model = new DefaultTableModel(header,NumberConstants.ZERO);
            
            //populate data table rows
            for(int i = NumberConstants.ZERO; i < employeeList.size(); i++){
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return model;
    }
}
