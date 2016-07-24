/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 *
 * @author aden4
 */
public class CustomConfirmDialog extends JDialog{
    
    private static final long serialVersionUID = 1L;
    private JFrame parent;
    private JFrame child;
    
    public CustomConfirmDialog(JFrame parent, JFrame child, String title, String message){
        super(parent, title);
        this.parent = parent;
        this.child = child;
        // set the position of the window
        Point p = new Point(520, 250);
        setLocation(p.x, p.y);
        // Create a message
        JPanel messagePane = new JPanel();
        messagePane.setBackground(new Color(000066));
        messagePane.setLayout(new GridBagLayout());
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon("src/etl/images/question_mark.png"));
        JLabel msgLabel = new JLabel(message);
        msgLabel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        msgLabel.setForeground(Color.WHITE);
        messagePane.add(imgLabel);
        messagePane.add(msgLabel);
        // get content pane, which is usually the
        // Container of all the dialog's components.
        getContentPane().add(messagePane);
        // Create a button
        JPanel buttonPane = new JPanel();
        JButton YesButton = new JButton("Yes");
        YesButton.setBackground(Color.WHITE);
        YesButton.setForeground(new Color(0,51,255));
        JButton NoButton = new JButton("No");
        NoButton.setBackground(Color.WHITE);
        NoButton.setForeground(new Color(0,51,255));
        buttonPane.add(YesButton);
        buttonPane.add(NoButton);
        // set action listener on the button
        YesButton.addActionListener(new YesActionListener());
        NoButton.addActionListener(new NoActionListener());
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    // override the createRootPane inherited by the JDialog, to create the rootPane.
    // create functionality to close the window when "Escape" button is pressed
    public JRootPane createRootPane() {
        JRootPane rootPane = new JRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
        Action action = new AbstractAction() {
            private static final long serialVersionUID = 1L;
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        };
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, "ESCAPE");
        rootPane.getActionMap().put("ESCAPE", action);
        return rootPane;
    }
    
    // an action listener to be used when an action is performed
    // (e.g. button is pressed)
    class YesActionListener implements ActionListener {
        //close and dispose of the window.
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            parent.dispose();
            dispose();
            child.setVisible(true);
        }
    }
    class NoActionListener implements ActionListener {
        //close and dispose of the window.
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
    /*public static void main(String[] a) {
        CustomConfirmDialog dialog = new CustomConfirmDialog(new JFrame(), "hello JCGs", "This is a JDialog example");
        // set the size of the window
        dialog.setSize(300, 150);
    }*/
}
