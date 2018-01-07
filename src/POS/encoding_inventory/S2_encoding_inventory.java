/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.encoding_inventory;

import POS.encoding_inventory.Encoding_inventory.to_encoding_inventory;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class S2_encoding_inventory {

    public static List<to_encoding_inventory> ret_data(String where) {
        List<to_encoding_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",qty"
                    + ",date_added"
                    + ",user_name"
                    + ",screen_name"
                    + ",sheet_no"
                    + ",status"
                    + ",counted_by"
                    + ",checked_by"
                    + ",cost"
                    + ",selling_price"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",remarks"
                    + " from encoding_inventory  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = rs.getString(7);
                String location_id = rs.getString(8);
                double qty = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_name = rs.getString(11);
                String screen_name = rs.getString(12);
                String sheet_no = rs.getString(13);
                int status = rs.getInt(14);
                String counted_by = rs.getString(15);
                String checked_by = rs.getString(16);
                double cost = rs.getDouble(17);
                double selling_price = rs.getDouble(18);
                String user_id = rs.getString(19);
                String user_screen_name = rs.getString(20);
                String remarks=rs.getString(21);
                to_encoding_inventory to = new to_encoding_inventory(id, item_code, barcode, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, status, counted_by, checked_by, cost, selling_price, user_id, user_screen_name,remarks);

                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
