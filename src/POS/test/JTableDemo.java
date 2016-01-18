/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

/**
 *
 * @author Guinness
 */
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JTableDemo extends JFrame {

    JTable table;
    DefaultTableModel tableModel;

    public JTableDemo() {
        table = new JTable(10, 5);
        tableModel = (DefaultTableModel) table.getModel();
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane spane = new JScrollPane(table);
        getContentPane().add(spane);

        JButton button = new JButton("Click Button");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                System.out.println(row + " : " + column);
                table.requestFocus();
            }
        });

        final JButton jbutton = new JButton("De-select");
        jbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.isEditing()) {
                    table.editingStopped(new ChangeEvent(jbutton));
                }
                tableModel.fireTableDataChanged();
                table.requestFocus();
            }
        });

        JPanel btnPanel = new JPanel(new GridLayout(2, 1));
        btnPanel.add(button);
        btnPanel.add(jbutton);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JTableDemo frame = new JTableDemo();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setVisible(true);
    }
}
