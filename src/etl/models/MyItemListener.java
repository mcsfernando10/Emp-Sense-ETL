package etl.models;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractButton;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suren
 */
public class MyItemListener implements ItemListener
{
    public static JTable table;
    public void itemStateChanged(ItemEvent e) {
        /*Object source = e.getSource();
        if (source instanceof AbstractButton == false) return;
        boolean checked = e.getStateChange() == ItemEvent.SELECTED;
        for(int x = 0, y = table.getRowCount(); x < y; x++)
        {
            table.setValueAt(new Boolean(checked),x,0);
        }*/
    }
}
