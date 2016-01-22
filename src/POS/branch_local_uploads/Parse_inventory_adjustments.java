/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Maytopacka
 */
public class Parse_inventory_adjustments {

    public static class field {

        String item_code;
        String barcode;
        double qty;
        double new_qty;
        int is_add;
        String date_added;
        int status;
        String user_id;
        String user_screen_name;
        String branch;
        String branch_id;
        String location;
        String location_id;
        String remarks;
        String transaction_no;

        public field(String item_code, String barcode, double qty, double new_qty, int is_add, String date_added, int status, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id, String remarks, String transaction_no) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.qty = qty;
            this.new_qty = new_qty;
            this.is_add = is_add;
            this.date_added = date_added;
            this.status = status;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.remarks = remarks;
            this.transaction_no = transaction_no;
        }

    }

    public static void main(String[] args) {
        String where = " where qty>0 limit 1";
        String stmt = Parse_inventory_adjustments.compress(where);
        List<Parse_inventory_adjustments.field> datas = Parse_inventory_adjustments.decompress(stmt);

    }

    public static List<Parse_inventory_adjustments.field> decompress(String stmt) {
        List<Parse_inventory_adjustments.field> datas = new ArrayList();
        String[] adjustments = stmt.split("℮");

        for (String adjustment : adjustments) {
            String[] adj = adjustment.split("%");
            int i = 0;
            for (String ad : adj) {
                String item_code = "";
                String barcode = "";
                double qty = 0;
                double new_qty = 0;
                int is_add = 0;
                String date_added = "";
                int status = 0;
                String user_id = "";
                String user_screen_name = "";
                String branch = "";
                String branch_id = "";
                String location = "";
                String location_id = "";
                String remarks = "";
                String transaction_no = "";
                if (i == 1) {
                    item_code = ad.substring(13, ad.length() - 1);
                }
                if (i == 2) {
                    barcode = ad.substring(11, ad.length() - 1);
                }
                if (i == 3) {
                    qty = FitIn.toDouble(ad.substring(0, ad.length() - 1));
                }
                if (i == 4) {
                    new_qty = FitIn.toDouble(ad.substring(11, ad.length() - 1));
                }
                if (i == 5) {
                    is_add = FitIn.toInt(ad.substring(10, ad.length() - 1));
                }
                if (i == 6) {
                    date_added = ad.substring(14, ad.length() - 1);
                }
                if (i == 7) {
                    status = FitIn.toInt(ad.substring(10, ad.length() - 1));
                }
                if (i == 8) {
                    user_id = ad.substring(11, ad.length() - 1);
                }
                if (i == 9) {
                    user_screen_name = ad.substring(20, ad.length() - 1);
                }
                if (i == 10) {
                    branch = ad.substring(10, ad.length() - 1);
                }
                if (i == 11) {
                    branch_id = ad.substring(13, ad.length() - 1);
                }
                if (i == 12) {
                    location = ad.substring(12, ad.length() - 1);
                }
                if (i == 13) {
                    location_id = ad.substring(15, ad.length() - 1);
                }
                if (i == 14) {
                    remarks = ad.substring(11, ad.length() - 1);
                }
                if (i == 15) {
                    transaction_no = ad.substring(18, ad.length() - 2);
                }

                i++;
            }
            System.out.println("--------------");
        }
        return datas;
    }

    public static String compress(String where) {
        String stmts = "";

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
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
                    + " from adjustments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            int t = 0;

            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                double qty = rs.getDouble(5);
                double new_qty = rs.getDouble(6);
                int is_add = rs.getInt(7);
                String date_added = rs.getString(8);
                int status = rs.getInt(9);
                String user_id = rs.getString(10);
                String user_screen_name = rs.getString(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location = rs.getString(14);
                String location_id = rs.getString(15);
                String remarks = rs.getString(16);
                String transaction_no = rs.getString(17);

                stmts = stmts + "℮{";
                stmts = stmts + "%\"item_code\":\"" + item_code + "\"";
                stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                stmts = stmts + "%\"qty\":\"" + qty + "\"";
                stmts = stmts + "%\"new_qty\":\"" + new_qty + "\"";
                stmts = stmts + "%\"is_add\":\"" + is_add + "\"";
                stmts = stmts + "%\"date_added\":\"" + date_added + "\"";
                stmts = stmts + "%\"status\":\"" + status + "\"";
                stmts = stmts + "%\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "%\"user_screen_name\":\"" + user_screen_name + "\"";
                stmts = stmts + "%\"branch\":\"" + branch + "\"";
                stmts = stmts + "%\"branch_id\":\"" + branch_id + "\"";
                stmts = stmts + "%\"location\":\"" + location + "\"";
                stmts = stmts + "%\"location_id\":\"" + location_id + "\"";
                stmts = stmts + "%\"remarks\":\"" + remarks + "\"";
                stmts = stmts + "%\"transaction_no\":\"" + transaction_no + "\"";
                stmts = stmts + "}";
            }
            return stmts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
