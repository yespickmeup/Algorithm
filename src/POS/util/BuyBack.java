/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import POS.category.S1_inventory_category;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Guinness
 */
public class BuyBack {
    
    // categories popup
    public static void categories(List<S1_inventory_category.to_inventory_category> categories ,final JTextField tf) {
        Object[][] obj = new Object[categories.size()][2];
        int i = 0;
        for (S1_inventory_category.to_inventory_category to : categories) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, tf.getWidth()};
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
    }
    
    
}
