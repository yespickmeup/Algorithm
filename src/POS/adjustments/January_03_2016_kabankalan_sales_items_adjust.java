/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.my_sales.MySales_Items;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Guinness
 */
public class January_03_2016_kabankalan_sales_items_adjust {

    public static void main(String[] args) {

//        System.setProperty("pool_db", "db_smis_kabankalan_12_27_2016");
        String where = "where Date(date_added) = '" + "2017-01-03" + "' order by sales_no,id asc";
        List<MySales_Items.items> items = MySales_Items.ret_data(where);

        try {
            Connection conn = MyConnection.connect();

            for (MySales_Items.items item : items) {

                System.out.println("" + item.sales_no + " | " + item.item_code + " | " + item.description + " | " + item.product_qty);
                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(item.item_code, item.barcode, item.location_id);
                double new_qty = tt.product_qty - (item.conversion * item.product_qty);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "'"
                        + " where  main_barcode= '" + item.item_code + "' and location_id='" + item.location_id + "' "
                        + "";
                PreparedStatement stmt = conn.prepareStatement(s4);
//                stmt.execute();
            }
            Lg.s(Inventory.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }
}
