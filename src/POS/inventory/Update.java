/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.inventory.Inventory.to_inventory;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Update {

    public static void update_item_model(String item_code, String model, String model_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory set "
                    + "model= :model"
                    + ",model_id= :model_id"
                    + " where "
                    + " barcode ='" + item_code + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("model", model)
                    .setString("model_id", model_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory.class, "Successfully Updated");

            String s2 = "update inventory_barcodes set "
                    + "model= :model"
                    + ",model_id= :model_id"
                    + " where "
                    + " main_barcode ='" + item_code + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .setString("model", model)
                    .setString("model_id", model_id)
                    .ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
