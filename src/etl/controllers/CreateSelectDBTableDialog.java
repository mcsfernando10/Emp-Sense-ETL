/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.controllers;

import etl.constants.StringConstants;
import etl.views.AttributeMapper_Predict;
import etl.views.AttributeMapper_Train;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Suren
 */
public class CreateSelectDBTableDialog extends JDialog{
    //private variable
    private final JFrame defineRulesFrame;
    private final JButton doneBtn;
    private JLabel progressLabel;
    private final ButtonGroup radioBtnGroup;
    private final JRadioButton trainDataRadioBtn;
    private final JRadioButton predictDataRadioBtn;
    
    private final String[] headers;
    public CreateSelectDBTableDialog(JFrame parent,String[] headers) {
        super(parent, StringConstants.DATATYPE_SELECT_DIALOG_TITLE);
        this.headers = headers;
        //Disable the parent window
        parent.setEnabled(false);
        this.defineRulesFrame = parent;
        setLocationRelativeTo(parent);
        
        //Main outer panel
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(000066));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        
        progressLabel = new JLabel(StringConstants.DATATYPE_SELECT_DIALOG_LABEL_TEXT);
        progressLabel.setForeground(Color.WHITE);
        JPanel labelPane = new JPanel();
        labelPane.setBackground(new Color(000066));
        labelPane.add(progressLabel);
        outerPanel.add(labelPane);
        getContentPane().add(outerPanel,BorderLayout.PAGE_START);
        
        // Create radio buttons
        JPanel radioBtnPane = new JPanel();
        radioBtnGroup = new ButtonGroup();
        trainDataRadioBtn = new JRadioButton(StringConstants.TRAIN_DATASET);
        trainDataRadioBtn.setSelected(true);
        trainDataRadioBtn.setForeground(Color.WHITE);
        predictDataRadioBtn = new JRadioButton(StringConstants.PREDICT_DATASET);
        predictDataRadioBtn.setForeground(Color.WHITE);
        radioBtnGroup.add(trainDataRadioBtn);
        radioBtnGroup.add(predictDataRadioBtn);
        
        radioBtnPane.add(trainDataRadioBtn);
        radioBtnPane.add(predictDataRadioBtn);
        radioBtnPane.setBackground(new Color(000066));
        // Get content pane, which is usually the
        // Container of all the dialog's components.
        outerPanel.add(radioBtnPane);
        getContentPane().add(outerPanel);

        // Create a button
        JPanel buttonPane = new JPanel();
        doneBtn = new JButton(StringConstants.DONE_TXT);
        buttonPane.add(doneBtn);
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        doneBtn.setVisible(true);
        doneBtn.setForeground(new Color(0,51,255));
        doneBtn.setBackground(Color.WHITE);
        // Set action listener on the button
        doneBtn.addActionListener(new DoneBtnClickListener());
        
        // Handle Close event of JDialog
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                parent.setEnabled(true);
            }
        });
        // Remove minimize icon
        setResizable(false);
        setVisible(true);
    }
    /* an action listener to be used when an action is performed when the 
       button is pressed */
    class DoneBtnClickListener implements ActionListener {
        //close and dispose of the window.
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            defineRulesFrame.dispose();
            if(trainDataRadioBtn.isSelected())
                new AttributeMapper_Train(StringConstants.ORIGINAL_CSV_PATH, 
                        headers).setVisible(true);
            else
                new AttributeMapper_Predict(StringConstants.ORIGINAL_CSV_PATH, 
                        headers).setVisible(true);
        }
    }
}
