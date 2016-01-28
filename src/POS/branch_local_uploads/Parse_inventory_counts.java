/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

import POS.branch_local_uploads.Branch_local_uploads.to_upload_count;
import POS.encoding_inventory.Encoding_inventory;
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
 * @author Guinness
 */
public class Parse_inventory_counts {

    public static class field {

        String item_code;
        String barcode;
        String branch;
        String branch_id;
        String location;
        String location_id;
        double qty;
        String date_added;
        String user_name;
        String screen_name;
        String sheet_no;
        int status;
        String counted_by;
        String checked_by;
        double cost;
        double selling_price;
        String user_id;
        String user_screen_name;

        public field(String item_code, String barcode, String branch, String branch_id, String location, String location_id, double qty, String date_added, String user_name, String screen_name, String sheet_no, int status, String counted_by, String checked_by, double cost, double selling_price, String user_id, String user_screen_name) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.qty = qty;
            this.date_added = date_added;
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.sheet_no = sheet_no;
            this.status = status;
            this.counted_by = counted_by;
            this.checked_by = checked_by;
            this.cost = cost;
            this.selling_price = selling_price;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
        }

    }

    public static void main2(String[] args) {

    }

    public static void main(String[] args) {
        String where = " order by id desc limit 2 ";
        to_upload_count stmt = Parse_inventory_counts.compress(where);
        List<Parse_inventory_counts.field> datas = Parse_inventory_counts.decompress(stmt.stmt);
        System.out.println("Size: " + datas.size());
        for (Parse_inventory_counts.field field : datas) {
            System.out.println(field.item_code + " = " + field.qty);
        }
    }

    public static List<Parse_inventory_counts.field> decompress(String stmts) {
        if (stmts.isEmpty()) {
            return new ArrayList();
        }
        List<Parse_inventory_counts.field> datas = new ArrayList();
        int total_transactions = 0;
        int total_items = 0;
        String[] list = stmts.split("℮");
        int i = 0;
        for (String s : list) {
            if (i > 0) {
                String item_code = "";
                String barcode = "";
                String branch = "";
                String branch_id = "";
                String location = "";
                String location_id = "";
                double qty = 0;
                String date_added = "";
                String user_name = "";
                String screen_name = "";
                String sheet_no = "";
                int status = 0;
                String counted_by = "";
                String checked_by = "";
                double cost = 0;
                double selling_price = 0;
                String user_id = "";
                String user_screen_name = "";

                String[] cols = s.split("%");
                int x = 0;
                for (String c : cols) {
                    if (x == 0) {
                        total_transactions++;
                        item_code = c.substring(14, c.length() - 1);
                    }
                    if (x == 1) {
                        barcode = c.substring(11, c.length() - 1);
                    }
                    if (x == 2) {
                        branch = c.substring(10, c.length() - 1);
                    }
                    if (x == 3) {
                        branch_id = c.substring(13, c.length() - 1);
                    }
                    if (x == 4) {
                        location = c.substring(12, c.length() - 1);
                    }
                    if (x == 5) {
                        location_id = c.substring(15, c.length() - 1);
                    }

                    if (x == 6) {
                        qty = FitIn.toDouble(c.substring(7, c.length() - 1));

                    }
                    if (x == 7) {
                        date_added = c.substring(14, c.length() - 1);
                    }
                    if (x == 8) {
                        user_name = c.substring(13, c.length() - 1);
                    }
                    if (x == 9) {
                        screen_name = c.substring(15, c.length() - 1);
                    }
                    if (x == 10) {
                        sheet_no = c.substring(12, c.length() - 1);
                    }
                    if (x == 11) {
                        status = FitIn.toInt(c.substring(10, c.length() - 1));
                    }
                    if (x == 12) {
                        counted_by = c.substring(14, c.length() - 1);
                    }
                    if (x == 13) {
                        checked_by = c.substring(14, c.length() - 1);
                    }
                    if (x == 14) {
                        cost = FitIn.toDouble(c.substring(8, c.length() - 1));
                    }
                    if (x == 15) {
                        selling_price = FitIn.toDouble(c.substring(17, c.length() - 1));
                    }
                    if (x == 16) {
                        user_id = c.substring(11, c.length() - 1);
                    }
                    if (x == 17) {
                        user_screen_name = c.substring(20, c.length() - 1);
                    }

                    x++;
                }
                Parse_inventory_counts.field item = new field(item_code, barcode, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, status, counted_by, checked_by, cost, selling_price, user_id, user_screen_name);
                datas.add(item);
            }
            i++;
        }

        System.out.println("Inventory Count: " + " Transactions: " + total_transactions + " , Items: " + total_items);
        return datas;

    }

    public static to_upload_count compress(String where) {
        List<Encoding_inventory.to_encoding_inventory> datas = new ArrayList();
        String stmts = "\"items\":\"";
        int total_transactions = 0;
        int total_items = 0;
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
                    + " from encoding_inventory"
                    + " " + where;

            int t = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                total_transactions++;
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

                stmts = stmts + "℮{";
                stmts = stmts + "\"item_code\":\"" + item_code + "\"";
                stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                stmts = stmts + "%\"branch\":\"" + branch + "\"";
                stmts = stmts + "%\"branch_id\":\"" + branch_id + "\"";
                stmts = stmts + "%\"location\":\"" + location + "\"";
                stmts = stmts + "%\"location_id\":\"" + location_id + "\"";
                stmts = stmts + "%\"qty\":\"" + qty + "\"";
                stmts = stmts + "%\"date_added\":\"" + date_added + "\"";
                stmts = stmts + "%\"user_name\":\"" + user_name + "\"";
                stmts = stmts + "%\"screen_name\":\"" + screen_name + "\"";
                stmts = stmts + "%\"sheet_no\":\"" + sheet_no + "\"";
                stmts = stmts + "%\"status\":\"" + status + "\"";
                stmts = stmts + "%\"counted_by\":\"" + counted_by + "\"";
                stmts = stmts + "%\"checked_by\":\"" + checked_by + "\"";
                stmts = stmts + "%\"cost\":\"" + cost + "\"";
                stmts = stmts + "%\"selling_price\":\"" + selling_price + "\"";
                stmts = stmts + "%\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "%\"user_screen_name\":\"" + user_screen_name + "\"";
                stmts = stmts + "}";

            }

            to_upload_count count = new to_upload_count(stmts, total_transactions, total_items);
            System.out.println("Inventory Count: " + " Transactions: " + total_transactions + " Items: " + total_items);
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

}
