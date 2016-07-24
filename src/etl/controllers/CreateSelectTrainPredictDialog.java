/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.controllers;

import etl.constants.StringConstants;
import etl.views.Extract;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import model.view.ModelMethodSelection;

/**
 *
 * @author Suren
 */
public class CreateSelectTrainPredictDialog extends JDialog{
    //private variable
    private final JFrame defineRulesFrame;
    private final JButton doneBtn;
    private JLabel progressLabel;
    private final ButtonGroup radioBtnGroup;
    private final JRadioButton selectDatasetRadioBtn;
    private final JRadioButton predictFromModelRadioBtn;
    
    public CreateSelectTrainPredictDialog(JFrame parent) {
        super(parent, StringConstants.PREDICT_TRAIN_SELECT_DIALOG_TITLE);
        
        //Disable the parent window
        parent.setEnabled(false);
        this.defineRulesFrame = parent;
        setLocationRelativeTo(parent);
        
        //JPanel labelOuterPanel = new JPanel();
        //labelOuterPanel.setBackground(new Color(000066));
        //labelOuterPanel.setBorder(BorderFactory.createEmptyBorder(5,0,5,10));
        
        progressLabel = new JLabel(StringConstants.PREDICT_TRAIN_SELECT_LABEL_TEXT);
        progressLabel.setForeground(Color.WHITE);
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelPane.setBorder(BorderFactory.createEmptyBorder(5,30,0,0));
        labelPane.setBackground(new Color(000066));
        labelPane.add(progressLabel);
        //labelOuterPanel.add(labelPane);
        getContentPane().add(labelPane,BorderLayout.PAGE_START);
        
        //Main outer panel
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(000066));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
        
        // Create radio buttons
        JPanel radioBtnPane = new JPanel();
        radioBtnPane.setPreferredSize(new Dimension(350,30));
        //radioBtnPane.setBorder(BorderFactory.createEmptyBorder(7,7,7,7));
        
        radioBtnGroup = new ButtonGroup();
        selectDatasetRadioBtn = new JRadioButton(StringConstants.SELECT_PREDICT_DATASET);
        selectDatasetRadioBtn.setSelected(true);
        selectDatasetRadioBtn.setForeground(Color.WHITE);
        //selectDatasetRadioBtn.setLocation(30, 10);
        
        predictFromModelRadioBtn = new JRadioButton(StringConstants.SELECT_PREDICT_MODEL);
        predictFromModelRadioBtn.setForeground(Color.WHITE);
        //predictFromModelRadioBtn.setLocation(150, 10);
        
        radioBtnGroup.add(selectDatasetRadioBtn);
        radioBtnGroup.add(predictFromModelRadioBtn);
        
        radioBtnPane.add(selectDatasetRadioBtn);
        radioBtnPane.add(predictFromModelRadioBtn);
        radioBtnPane.setBackground(new Color(000066));
        //radioBtnPane.setBackground(new Color(51,102,255));
        
        // Get content pane, which is usually the
        // Container of all the dialog's components.
        outerPanel.add(radioBtnPane);
        getContentPane().add(outerPanel);
        
        // Create a button
        //JPanel buttonOuterPanel = new JPanel();
        //buttonOuterPanel.setBackground(new Color(000066));
        //buttonOuterPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        
        JPanel buttonPane = new JPanel();
        //buttonPane.setBackground(new Color(51,102,255));
        //buttonPane.setPreferredSize(new Dimension(350,42));
        //buttonPane.setBorder(BorderFactory.createEmptyBorder(2,7,2,7));
        
        doneBtn = new JButton(StringConstants.DONE_TXT);
        doneBtn.setBackground(Color.WHITE);
        doneBtn.setForeground(new Color(0,51,255));
        doneBtn.setBackground(Color.WHITE);
        buttonPane.add(doneBtn);
        //buttonOuterPanel.add(buttonPane);
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        doneBtn.setVisible(true);
        
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
            if(selectDatasetRadioBtn.isSelected())
            {
                new Extract().setVisible(true);
                dispose();
            }
            else
            {
                new ModelMethodSelection().setVisible(true);
                dispose();
            }
        }
    }
}
