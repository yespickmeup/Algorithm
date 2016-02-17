/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.inventory.Inventory_barcodes;
import POS.inventory_replenishment.Inventory_replenishments;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Adjustments_inventory_replenishments {

    public static void main(String[] args) {
//        Inventory_replenishments.to_inventory_replenishments to = new Inventory_replenishments.to_inventory_replenishments(0, "15|000000000001", "2015-08-04 14:21:24", "1", "administrator", "adjustments", 1, "Algorithm - Dgte", "9", "Stock Room (Back Old)", "15");
//        Inventory_replenishments.to_inventory_replenishments to = new Inventory_replenishments.to_inventory_replenishments(0, "16|000000000002", "2015-08-06 10:55:56", "1", "administrator", "adjustments", 1, "Algorithm - Dgte", "9", "Stock Room (Back New)", "16");
//        Inventory_replenishments.to_inventory_replenishments to = new Inventory_replenishments.to_inventory_replenishments(0, "20|000000000003", "2015-08-06 11:56:45", "1", "administrator", "adjustments", 1, "Algorithm - Dgte", "9", "Stock Room (Upstairs)", "20");
//        Inventory_replenishments.to_inventory_replenishments to = new Inventory_replenishments.to_inventory_replenishments(0, "14|000000000004", "2015-08-16 11:19:34", "1", "administrator", "adjustments", 1, "Algorithm - Dgte", "9", "Selling Area", "14");
//        Inventory_replenishments.to_inventory_replenishments to = new Inventory_replenishments.to_inventory_replenishments(0, "23|000000000006", "2015-08-16 19:58:56", "1", "administrator", "adjustments", 1, "Algorithm - Dgte", "9", "Stock Room (Front)", "23");
//        Inventory_replenishments.to_inventory_replenishments to = new Inventory_replenishments.to_inventory_replenishments(0, "22|000000000007", "2015-12-26 11:57:53", "1", "administrator", "adjustments", 1, "Algorithm - Dgte", "9", "Stock Room (Front)", "22");

//        String where = " where location_id='" + to.location_id + "'";
//        List<Inventory_barcodes.to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);
//        adjust_replenishment(to, datas);
    }

    
    public static void adjust_replenishment(Inventory_replenishments.to_inventory_replenishments to_inventory_replenishments, List<Inventory_barcodes.to_inventory_barcodes> datas) {
        try {
            Connection conn = MyConnection.connect();
            System.out.println("Adding records....");
            for (Inventory_barcodes.to_inventory_barcodes to_inventory_replenishment_items : datas) {
                String s2 = "insert into inventory_replenishment_items("
                        + " inventory_replenishment_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":inventory_replenishment_no"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:status"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("inventory_replenishment_no", to_inventory_replenishments.inventory_replenishment_no)
                        .setString("item_code", to_inventory_replenishment_items.main_barcode)
                        .setString("barcode", to_inventory_replenishment_items.barcode)
                        .setString("description", to_inventory_replenishment_items.description)
                        .setNumber("product_qty", to_inventory_replenishment_items.product_qty)
                        .setString("unit", to_inventory_replenishment_items.unit)
                        .setNumber("conversion", to_inventory_replenishment_items.conversion)
                        .setNumber("selling_price", to_inventory_replenishment_items.selling_price)
                        .setString("date_added", to_inventory_replenishments.date_added)
                        .setString("user_id", to_inventory_replenishments.user_id)
                        .setString("user_screen_name", to_inventory_replenishments.user_screen_name)
                        .setNumber("status", 1)
                        .setString("branch", to_inventory_replenishment_items.branch)
                        .setString("branch_id", to_inventory_replenishment_items.branch_code)
                        .setString("location", to_inventory_replenishment_items.location)
                        .setString("location_id", to_inventory_replenishment_items.location_id)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s2);
                stmt.execute();
                System.out.println("Item Code: " + to_inventory_replenishment_items.main_barcode);
            }
            System.out.println("Successfully Added....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
