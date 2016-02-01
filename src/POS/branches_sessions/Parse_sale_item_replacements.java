/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;

import POS.branches_sessions.Branch_local_uploads.to_upload_count;
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
public class Parse_sale_item_replacements {

    public String sales_no;
    public String item_code;
    public String barcode;
    public String serial_no;
    public double product_qty;
    public String unit;
    public double conversion;
    public double selling_price;
    public String date_added;
    public String user_id;
    public String user_screen_name;
    public int status;
    public String discount_name;
    public double discount_rate;
    public double discount_amount;
    public String discount_customer_name;
    public String discount_customer_id;
    public String branch;
    public String branch_code;
    public String location;
    public String location_id;
    public int is_replacement;
    public String reason;

    public Parse_sale_item_replacements(String sales_no, String item_code, String barcode, String serial_no, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_id, String user_screen_name, int status, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String branch, String branch_code, String location, String location_id, int is_replacement, String reason) {
        this.sales_no = sales_no;
        this.item_code = item_code;
        this.barcode = barcode;
        this.serial_no = serial_no;
        this.product_qty = product_qty;
        this.unit = unit;
        this.conversion = conversion;
        this.selling_price = selling_price;
        this.date_added = date_added;
        this.user_id = user_id;
        this.user_screen_name = user_screen_name;
        this.status = status;
        this.discount_name = discount_name;
        this.discount_rate = discount_rate;
        this.discount_amount = discount_amount;
        this.discount_customer_name = discount_customer_name;
        this.discount_customer_id = discount_customer_id;
        this.branch = branch;
        this.branch_code = branch_code;
        this.location = location;
        this.location_id = location_id;
        this.is_replacement = is_replacement;
        this.reason = reason;

    }

    public static void main(String[] args) {
        String where = " order by id desc limit 3";
        to_upload_count stmts = compress(where);
        List<Parse_sale_item_replacements> datas = decompress(stmts.stmt);
        for (Parse_sale_item_replacements to : datas) {
            System.out.println(to.sales_no);
        }
        System.out.println(datas.size());
    }

    public static List<Parse_sale_item_replacements> decompress(String stmts) {
        if (stmts.isEmpty()) {
            return new ArrayList();
        }
        List<Parse_sale_item_replacements> datas = new ArrayList();
        String[] list = stmts.split("℮");
        int total_transactions = 0;
        int total_items = 0;
        int i = 0;
        for (String s : list) {
            if (i > 0) {

                String sales_no = "";
                String item_code = "";
                String barcode = "";
                String serial_no = "";
                double product_qty = 0;
                String unit = "";
                double conversion = 0;
                double selling_price = 0;
                String date_added = "";
                String user_id = "";
                String user_screen_name = "";
                int status = 0;
                String discount_name = "";
                double discount_rate = 0;
                double discount_amount = 0;
                String discount_customer_name = "";
                String discount_customer_id = "";
                String branch = "";
                String branch_code = "";
                String location = "";
                String location_id = "";
                int is_replacement = 0;
                String reason = "";

                String[] cols = s.split("%");
                int x = 0;
                for (String c : cols) {
                    if (x == 0) {
                        total_transactions++;
                        sales_no = c.substring(14, c.length() - 1);
                    }
                    if (x == 1) {
                        item_code = c.substring(13, c.length() - 1);
                    }
                    if (x == 2) {
                        barcode = c.substring(11, c.length() - 1);
                    }
                    if (x == 3) {
                        serial_no = c.substring(13, c.length() - 1);
                    }
                    if (x == 4) {
                        product_qty = FitIn.toDouble(c.substring(15, c.length() - 1));
                    }
                    if (x == 5) {
                        unit = c.substring(8, c.length() - 1);
                    }
                    if (x == 6) {
                        conversion = FitIn.toDouble(c.substring(14, c.length() - 1));
                    }
                    if (x == 7) {
                        selling_price = FitIn.toDouble(c.substring(17, c.length() - 1));
                    }
                    if (x == 8) {
                        date_added = c.substring(14, c.length() - 1);
                    }
                    if (x == 9) {
                        user_id = c.substring(11, c.length() - 1);
                    }
                    if (x == 10) {
                        user_screen_name = c.substring(20, c.length() - 1);
                    }
                    if (x == 11) {
                        status = FitIn.toInt(c.substring(10, c.length() - 1));
                    }
                    if (x == 12) {
                        discount_name = c.substring(17, c.length() - 1);
                    }
                    if (x == 13) {
                        discount_rate = FitIn.toInt(c.substring(17, c.length() - 1));
                    }
                    if (x == 14) {
                        discount_amount = FitIn.toInt(c.substring(19, c.length() - 1));
                    }
                    if (x == 15) {
                        discount_customer_name = c.substring(26, c.length() - 1);
                    }
                    if (x == 16) {
                        discount_customer_id = c.substring(24, c.length() - 1);
                    }
                    if (x == 17) {
                        branch = c.substring(10, c.length() - 1);
                    }
                    if (x == 18) {
                        branch_code = c.substring(15, c.length() - 1);
                    }
                    if (x == 19) {
                        location = c.substring(12, c.length() - 1);
                    }
                    if (x == 20) {
                        location_id = c.substring(15, c.length() - 1);
                    }
                    if (x == 21) {
                        is_replacement = FitIn.toInt(c.substring(18, c.length() - 1));
                    }
                    if (x == 21) {
                        reason = c.substring(10, c.length() - 1);
                    }

                    x++;
                }

                Parse_sale_item_replacements psir = new Parse_sale_item_replacements(sales_no, item_code, barcode, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, is_replacement, reason);
                datas.add(psir);
            }

            i++;
        }
        System.out.println("Returned Items: " + " Transactions: " + total_transactions + " , Items: " + total_items);
        return datas;
    }

    public static to_upload_count compress(String where) {
        String stmts = "\"items\":\"";
        int total_transactions = 0;
        int total_items = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",is_replacement"
                    + ",reason"
                    + " from sale_item_replacements"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                total_transactions++;
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                int is_replacement = rs.getInt(40);
                String reason = rs.getString(41);

                stmts = stmts + "℮{";
                stmts = stmts + "\"sales_no;\":\"" + sales_no + "\"";
                stmts = stmts + "%\"item_code;\":\"" + item_code + "\"";
                stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                stmts = stmts + "%\"serial_no\":\"" + serial_no + "\"";
                stmts = stmts + "%\"product_qty\":\"" + product_qty + "\"";
                stmts = stmts + "%\"unit\":\"" + unit + "\"";
                stmts = stmts + "%\"conversion\":\"" + conversion + "\"";
                stmts = stmts + "%\"selling_price\":\"" + selling_price + "\"";
                stmts = stmts + "%\"date_added\":\"" + date_added + "\"";
                stmts = stmts + "%\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "%\"user_screen_name\":\"" + user_screen_name + "\"";
                stmts = stmts + "%\"status\":\"" + status + "\"";
                stmts = stmts + "%\"discount_name\":\"" + discount_name + "\"";
                stmts = stmts + "%\"discount_rate\":\"" + discount_rate + "\"";
                stmts = stmts + "%\"discount_amount\":\"" + discount_amount + "\"";
                stmts = stmts + "%\"discount_customer_name\":\"" + discount_customer_name + "\"";
                stmts = stmts + "%\"discount_customer_id\":\"" + discount_customer_id + "\"";
                stmts = stmts + "%\"branch\":\"" + branch + "\"";
                stmts = stmts + "%\"branch_code\":\"" + branch_code + "\"";
                stmts = stmts + "%\"location\":\"" + location + "\"";
                stmts = stmts + "%\"location_id\":\"" + location_id + "\"";
                stmts = stmts + "%\"is_replacement\":\"" + is_replacement + "\"";
                stmts = stmts + "%\"reason\":\"" + reason + "\"";

                stmts = stmts + "}";
            }
            to_upload_count count = new to_upload_count(stmts, total_transactions, total_items);
            System.out.println("Replacements: " + " Transactions: " + total_transactions + " Items: " + total_items);
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

}
