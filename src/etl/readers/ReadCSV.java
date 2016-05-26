/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import etl.constants.NumberConstants;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suren
 */
public class ReadCSV {
    public DefaultTableModel readCSVFrom(String filePath){
        FileReader selectedFile = null;
        DefaultTableModel model = null;
        try {
            //Create the file
            selectedFile = new FileReader(filePath);
            au.com.bytecode.opencsv.CSVReader reader = 
                    new au.com.bytecode.opencsv.CSVReader(selectedFile);
            //List<String[]> myEntries = reader.readAll();
            //String[][] rowData = myEntries.toArray(new String[0][]);
            // if the first line is the header
            String[] header = reader.readNext();
            //JTable table = new JTable(rowData,header);
            //this.add(table);
            List<String[]> myEntries = reader.readAll();
            model = new DefaultTableModel(header,NumberConstants.ZERO);
            for(int i = NumberConstants.ZERO; i < myEntries.size(); i++){
                model.addRow(myEntries.get(i));
            }   
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                selectedFile.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        return model;
    }
    
}
