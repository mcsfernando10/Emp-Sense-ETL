package etl.models;


import java.awt.Component;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suren
 */
public class CheckBoxHeader extends JCheckBox
    implements TableCellRenderer, MouseListener {
    protected CheckBoxHeader rendererComponent;
    protected int column;
    protected boolean mousePressed = false;
    public  String columnName;
    public CheckBoxHeader(ItemListener itemListener, String columnName) {
        rendererComponent = this;
        rendererComponent.addItemListener(itemListener);
        this.columnName = columnName;
    }
    
    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        if (table != null) {
            JTableHeader header = table.getTableHeader();
            if (header != null) {
                rendererComponent.setForeground(header.getForeground());
                rendererComponent.setBackground(header.getBackground());
                rendererComponent.setFont(header.getFont());
                header.addMouseListener(rendererComponent);
            }
        }
        setColumn(column);
        rendererComponent.setText(this.columnName);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        return rendererComponent;
    }
    
    protected void setColumn(int column) {
        this.column = column;
    }
    public int getColumn() {
        return column;
    }
    protected void handleClickEvent(MouseEvent e) {
        if (mousePressed) {
            mousePressed=false;
            JTableHeader header = (JTableHeader)(e.getSource());
            JTable tableView = header.getTable();
            TableColumnModel columnModel = tableView.getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX());
            int column = tableView.convertColumnIndexToModel(viewColumn);

            if (viewColumn == this.column && e.getClickCount() == 1 && column != -1) {
                doClick();
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        handleClickEvent(e);
        //((JTableHeader)e.getSource()).repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
