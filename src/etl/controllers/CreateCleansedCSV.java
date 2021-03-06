/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.controllers;

import etl.constants.NumberConstants;
import etl.constants.StringConstants;
import etl.db.DBAccess;
import etl.readers.ReadCSV;
import etl.views.DefineRules;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suren
 */
public class CreateCleansedCSV implements Runnable{

    public static String filePath;
    public static CreatingDBDialog dbDialog;
    //predict or train data table
    public static int selectedDBTable;
    //Private variables
    private Thread thread;
    
    @Override
    public void run() {
        executePythonFile();        
        insertData();
        //Set Label text with finish messages
        dbDialog.setButtonVisible();
        dbDialog.setLabelText();
    }
    
    /*
    * @Method executePythonFile
    * Execute Python file
    */
    public void executePythonFile(){  
        try {
            Process p;
            if(selectedDBTable == NumberConstants.TRAIN_DATA){            
                p = Runtime.getRuntime().
                        exec(StringConstants.CLEANSED_DATA_PYTHON_PATH_TRAIN);
            }else{
                p = Runtime.getRuntime().
                        exec(StringConstants.CLEANSED_DATA_PYTHON_PATH_PREDICT);
            }
            
            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
            
 
            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));
 
            String s = null;
            
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
             
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(DefineRules.class.getName()).log(Level.SEVERE, null, ex);
        }               
    }
    
    /*
    * @Method insertData
    * Insert cleansed data into database
    */
    private void insertData(){
        DBAccess dbAccess = new DBAccess();
        //Insert unique reasons
        ReadCSV.selectedFilePath = StringConstants.UNIQUE_REASONS_TO_LEAVE;
        ReadCSV readerInsertUniqueReasons = new ReadCSV();
        List<String[]> uniqueReasons = readerInsertUniqueReasons.readCSVFile();
        for(int i = NumberConstants.ZERO; i < uniqueReasons.size();i++){
            if(dbAccess.isReasonInserted(Integer.parseInt(uniqueReasons.get(i)[0]))){
                dbAccess.insertUniqueReasons(
                        StringConstants.UNIQUE_REASON_DATATABLE,uniqueReasons.get(i));
            }
        }
        
        //To insert original values
        ReadCSV.selectedFilePath = StringConstants.CLEANSED_DATA_PATH;
        ReadCSV csvReaderForInsert = new ReadCSV();
        List<String[]> csvData = csvReaderForInsert.readCSVFile();
        
        //To insert raw values
        ReadCSV.selectedFilePath = StringConstants.CLEANSED_RAW_DATA_PATH;
        csvReaderForInsert = new ReadCSV();
        List<String[]> csvRawData = csvReaderForInsert.readCSVFile();
        int size = csvData.size();
        
        if(selectedDBTable == NumberConstants.TRAIN_DATA){
            for(int i = NumberConstants.ONE;i<size;i++){
                dbAccess.insertDataToTrainTable(StringConstants.TRAIN_DATATABLE,csvData.get(i));
                dbAccess.insertRawDataToTrainTable(StringConstants.TRAIN_RAW_DATATABLE,csvRawData.get(i));
                dbDialog.setInsertProgress(size, i);
            }
        } else {
            for(int i = NumberConstants.ONE;i<size;i++){
                dbAccess.insertDataToPredictTable(StringConstants.PREDICT_DATATABLE,csvData.get(i));
                dbAccess.insertRawDataToPredictTable(
                        StringConstants.PREDICT_RAW_DATATABLE,csvRawData.get(i));
                /*int arrContributionSize = 2*(csvData.get(i).length - 2) + 2;
                String[] arrFeatureTableRow = new String[arrContributionSize];
                arrFeatureTableRow[0] = csvData.get(i)[0];
                arrFeatureTableRow[1] = csvData.get(i)[1];
                for(int k=2;k<arrContributionSize;k++){
                    arrFeatureTableRow[k] = "0.0";
                }
                dbAccess.insertDataToPredictFeatureContTable(
                        StringConstants.PREDICT_FEATURE_DATATABLE, arrFeatureTableRow);*/
                dbDialog.setInsertProgress(size, i);
            }
        }
    }
    
    /*
    * @Method start 
    * Initialize thread if not initialized and start it
    */ 
    public void start(){
        if (thread == null)
        {
            thread = new Thread(this);
            thread.start();
        }
    }
    
}