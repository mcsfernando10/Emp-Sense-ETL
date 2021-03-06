/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.controllers;

import etl.constants.StringConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.view.ModelMethodSelection;

/**
 *
 * @author suren
 */
public class CreatingDBDialog extends JDialog {
    //private variable
    private final JFrame defineRulesFrame;
    private JButton button;
    private JLabel progressLabel;
    public CreatingDBDialog(JFrame parent, String title, String message) {
        super(parent, title);
        //Disable the parent window
        parent.setEnabled(false);
        defineRulesFrame = parent;
        //Set the location of JDialog
        //Point p = new Point(400, 400);
        //setLocation(p.x, p.y);
        setLocationRelativeTo(parent);
        // Create a message
        JPanel messagePane = new JPanel();
        progressLabel = new JLabel(message);
        progressLabel.setIcon(new ImageIcon(StringConstants.WAITING_IMG_PATH));
        progressLabel.setVerticalTextPosition(JLabel.BOTTOM);
        progressLabel.setHorizontalTextPosition(JLabel.CENTER);
        messagePane.add(progressLabel);
        // Get content pane, which is usually the
        // Container of all the dialog's components.
        getContentPane().add(messagePane);

        // Create a button
        JPanel buttonPane = new JPanel();
        button = new JButton(StringConstants.DONE_TXT);
        buttonPane.add(button);
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        button.setVisible(false);
        // Set action listener on the button
        button.addActionListener(new DoneBtnClickListener());
        // Disable the close button
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        // Remove minimize icon
        setResizable(false);
        //pack();
        setVisible(true);
    }

    public void setInsertProgress(int size,int row){
        progressLabel.setText(row + " of " + (size-1) + StringConstants.DB_INSERT_MSG);
    }
    
    public void setButtonVisible(){
        button.setVisible(true);
    }

    public void setLabelText(){
        this.setSize(300, 200);
        progressLabel.setText(StringConstants.DB_UPDATE_SUCCESS_MSG);
        progressLabel.setIcon(new ImageIcon(StringConstants.SUCCESS_IMG_PATH));
        this.setTitle(StringConstants.DB_CREATION_MSG);        
    }
    /* an action listener to be used when an action is performed when the 
       button is pressed */
    class DoneBtnClickListener implements ActionListener {
        //close and dispose of the window.
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            //Close this JDialog
            dispose();
            //Close Define Rule Window
            defineRulesFrame.dispose();
            new ModelMethodSelection().setVisible(true);
        }
    }
}

