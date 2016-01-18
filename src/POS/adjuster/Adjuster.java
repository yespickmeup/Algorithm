/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.adjuster.S1_adjustments.to_adjustments;
import POS.inventory.Inventory_barcodes.to_inventory_barcodes;
import POS.users.MyUser;
import POS.util.DateType;
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
public class Adjuster {

    public static void update_data(to_inventory_barcodes to_inventory_barcodes, double new_qty, int is_add,String remarks) {
        try {
            Connection conn = MyConnection.connect();
            String transaction_no="";
            double my_qty = 0;
            if (is_add == 1) {
                my_qty = to_inventory_barcodes.product_qty + new_qty;
            } else {
                my_qty = to_inventory_barcodes.product_qty - new_qty;
            }

            String s2 = "insert into adjustments("
                    + "item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",new_qty"
                    + ",is_add"
                    + ",date_added"
                    + ",status"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",remarks"
                    + ",transaction_no"
                    + ")values("
                    + ":item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:qty"
                    + ",:new_qty"
                    + ",:is_add"
                    + ",:date_added"
                    + ",:status"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:remarks"
                    + ",transaction_no"
                    + ")";

            s2 = SqlStringUtil.parse(s2)
                    .setString("item_code", to_inventory_barcodes.main_barcode)
                    .setString("barcode", to_inventory_barcodes.barcode)
                    .setString("description", to_inventory_barcodes.description)
                    .setNumber("qty", to_inventory_barcodes.product_qty)
                    .setNumber("new_qty", new_qty)
                    .setNumber("is_add", is_add)
                    .setString("date_added", DateType.now())
                    .setNumber("status", 1)
                    .setString("user_id", MyUser.getUser_id())
                    .setString("user_screen_name", MyUser.getUser_screen_name())
                    .setString("branch", to_inventory_barcodes.branch)
                    .setString("branch_id", to_inventory_barcodes.branch_code)
                    .setString("location", to_inventory_barcodes.location)
                    .setString("location_id", to_inventory_barcodes.location_id)
                    .setString("remarks", remarks)
                    .setString("transaction_no", transaction_no)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_adjustments.class, "Successfully Added");

            String s0 = "update inventory_barcodes set "
                    + " product_qty= :product_qty "
                    + " where id='" + to_inventory_barcodes.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("product_qty", my_qty)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Adjuster.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_inventory_barcodes to_inventory_barcodes) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_barcodes  "
                    + " where id='" + to_inventory_barcodes.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Adjuster.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_barcode(String item_code, String old_barcode, String new_barcode) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  inventory_barcodes  set "
                    + " barcode= :barcode"
                    + " where main_barcode='" + item_code + "' "
                    + " and barcode='" + old_barcode + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("barcode", new_barcode)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Adjuster.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_description(String item_code, String description) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  inventory_barcodes  set "
                    + " description= :description"
                    + " where main_barcode='" + item_code + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("description", description)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update  inventory  set "
                    + " description= :description"
                    + " where barcode='" + item_code + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .setString("description", description)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(Adjuster.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
