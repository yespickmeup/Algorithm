/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.barcodes;

import POS.inventory.Inventory_barcodes;
import POS.inventory.Inventory_barcodes.to_inventory_barcodes;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_barcodes {

    public static void edit_inventory_barcodes(String new_barcode, String barcode, String item_code) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_barcodes set "
                    + "barcode= :barcode"
                    + " where "
                    + " barcode ='" + barcode + "' "
                    + " and main_barcode ='" + item_code + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("barcode", new_barcode)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_barcodes(to_inventory_barcodes to_inventory_barcodes) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_barcodes where "
                    + " barcode ='" + to_inventory_barcodes.barcode + "' "
                    + " and main_barcode ='" + to_inventory_barcodes.main_barcode + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
