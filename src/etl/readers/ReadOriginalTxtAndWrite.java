/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.readers;

import com.opencsv.CSVWriter;
import etl.constants.StringConstants;
import static etl.readers.ReadOriginalXMLAndWriteCSV.extractView;
import etl.views.DataView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Chinthaka Suren
 */
public class ReadOriginalTxtAndWrite implements Runnable{
    //Public variables
    public static String selectedFilePath;
    public static JFrame extractView;
    //Private variables
    private Thread thread;
    private CSVWriter writer;   
    
    private void readAndWriteTextFile(){
        try {
            //To write to file
            writer = new CSVWriter(new FileWriter(StringConstants.ORIGINAL_CSV_PATH));
            for (String line : Files.readAllLines(Paths.get(selectedFilePath))) {
                writer.writeNext(line.split(","));   
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    @Override
    public void run() {
        readAndWriteTextFile();
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
