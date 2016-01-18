/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

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
public class Inventory {

    public static void update_item(S1_inventory.to_inventory to_inventory, String unit, double conversion, double selling_price, int update_all_branches, String where) {
        try {
            Connection conn = MyConnection.connect();

            if (update_all_branches == 1) {
                String s0 = "update inventory set "
                        + " unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where "
                        + " id ='" + to_inventory.id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0).
                        setString("unit", unit).
                        setNumber("conversion", conversion).
                        setNumber("selling_price", selling_price).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }

            Lg.s(S1_inventory.class, "Successfully Updated");

            String s2 = "update inventory_barcodes set "
                    + " unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + " " + where;
            s2 = SqlStringUtil.parse(s2).
                    setString("unit", unit).
                    setNumber("conversion", conversion).
                    setNumber("selling_price", selling_price).
                    ok();

            System.out.println(s2);
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
