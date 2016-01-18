/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.synch_locations;

import POS.encoding_inventory.Encoding_inventory;
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
        String where = " where YEAR(date_added) = '" + "2016" + "' ";
        String stmt = Parse_inventory_counts.compress(where);
        List<Parse_inventory_counts.field> datas = Parse_inventory_counts.decompress(stmt);
        System.out.println("Size: " + datas.size());
        for (Parse_inventory_counts.field field : datas) {
            System.out.println(field.item_code + " = " + field.qty);
        }
    }

    public static List<Parse_inventory_counts.field> decompress(String stmts) {
        List<Parse_inventory_counts.field> datas = new ArrayList();

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
        return datas;

    }

    public static String compress(String where) {
        List<Encoding_inventory.to_encoding_inventory> datas = Encoding_inventory.ret_data_encoding2(where);

        String stmt = "\"items\":\"";
        for (Encoding_inventory.to_encoding_inventory to : datas) {
            stmt = stmt + "℮{";
            stmt = stmt + "\"item_code\":\"" + to.item_code + "\"";
            stmt = stmt + "%\"barcode\":\"" + to.barcode + "\"";
            stmt = stmt + "%\"branch\":\"" + to.branch + "\"";
            stmt = stmt + "%\"branch_id\":\"" + to.branch_id + "\"";
            stmt = stmt + "%\"location\":\"" + to.location + "\"";
            stmt = stmt + "%\"location_id\":\"" + to.location_id + "\"";
            stmt = stmt + "%\"qty\":\"" + to.qty + "\"";
            stmt = stmt + "%\"date_added\":\"" + to.date_added + "\"";
            stmt = stmt + "%\"user_name\":\"" + to.user_name + "\"";
            stmt = stmt + "%\"screen_name\":\"" + to.screen_name + "\"";
            stmt = stmt + "%\"sheet_no\":\"" + to.sheet_no + "\"";
            stmt = stmt + "%\"status\":\"" + to.status + "\"";
            stmt = stmt + "%\"counted_by\":\"" + to.counted_by + "\"";
            stmt = stmt + "%\"checked_by\":\"" + to.checked_by + "\"";
            stmt = stmt + "%\"cost\":\"" + to.cost + "\"";
            stmt = stmt + "%\"selling_price\":\"" + to.selling_price + "\"";
            stmt = stmt + "%\"user_id\":\"" + to.user_id + "\"";
            stmt = stmt + "%\"user_screen_name\":\"" + to.user_screen_name + "\"";
            stmt = stmt + "}";
        }
        return stmt;
    }

}
