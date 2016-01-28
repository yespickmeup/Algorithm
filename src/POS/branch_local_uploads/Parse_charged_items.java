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
 * @author Guinness
 */
public class Parse_charged_items {

    public String customer_id;
    public String customer_name;
    public String ar_id;
    public String ar_no;
    public String date_applied;
    public String reference_no;
    public String soa_type;
    public String soa_type_id;
    public String user_screen_name;
    public String user_id;
    public String remarks;
    public String item_code;
    public String barcode;
    public String item_type;
    public String serial_no;
    public double product_qty;
    public String unit;
    public double conversion;
    public double selling_price;
    public String date_added;
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
    public double addtl_amount;
    public double wtax;
    public int is_cancelled;

    public Parse_charged_items(String customer_id, String customer_name, String ar_id, String ar_no, String date_applied, String reference_no, String soa_type, String soa_type_id, String user_screen_name, String user_id, String remarks, String item_code, String barcode, String item_type, String serial_no, double product_qty, String unit, double conversion, double selling_price, String date_added, int status, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String branch, String branch_code, String location, String location_id, double addtl_amount, double wtax, int is_cancelled) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.ar_id = ar_id;
        this.ar_no = ar_no;
        this.date_applied = date_applied;
        this.reference_no = reference_no;
        this.soa_type = soa_type;
        this.soa_type_id = soa_type_id;
        this.user_screen_name = user_screen_name;
        this.user_id = user_id;
        this.remarks = remarks;
        this.item_code = item_code;
        this.barcode = barcode;
        this.item_type = item_type;
        this.serial_no = serial_no;
        this.product_qty = product_qty;
        this.unit = unit;
        this.conversion = conversion;
        this.selling_price = selling_price;
        this.date_added = date_added;
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
        this.addtl_amount = addtl_amount;
        this.wtax = wtax;
        this.is_cancelled = is_cancelled;
    }

    public static void main(String[] args) {
        String where = " order by id desc limit 3";
        String stmts = compress(where);
        List<Parse_charged_items> datas = decompress(stmts);
        for (Parse_charged_items to : datas) {

            System.out.println(to.customer_id);
        }
        System.out.println(datas.size());
    }

    public static List<Parse_charged_items> decompress(String stmts) {
        if (stmts.isEmpty()) {
            return new ArrayList();
        }
        List<Parse_charged_items> datas = new ArrayList();
        String[] list = stmts.split("℮");
        int i = 0;
        for (String s : list) {
            if (i > 0) {
                String customer_id = "";
                String customer_name = "";
                String ar_id = "";
                String ar_no = "";
                String date_applied = "";
                String reference_no = "";
                String soa_type = "";
                String soa_type_id = "";
                String user_screen_name = "";
                String user_id = "";
                String remarks = "";
                String item_code = "";
                String barcode = "";
                String item_type = "";
                String serial_no = "";
                double product_qty = 0;
                String unit = "";
                double conversion = 0;
                double selling_price = 0;
                String date_added = "";
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
                double addtl_amount = 0;
                double wtax = 0;
                int is_cancelled = 0;

                String[] cols = s.split("%");
                int x = 0;
                for (String c : cols) {

                    if (x == 0) {
                        customer_id = c.substring(17, c.length() - 1);
                    }
                    if (x == 1) {
                        customer_name = c.substring(17, c.length() - 1);
                    }
                    if (x == 2) {
                        ar_id = c.substring(9, c.length() - 1);
                    }
                    if (x == 3) {
                        ar_no = c.substring(9, c.length() - 1);
                    }
                    if (x == 4) {
                        date_applied = c.substring(16, c.length() - 1);
                    }
                    if (x == 5) {
                        reference_no = c.substring(16, c.length() - 1);
                    }
                    if (x == 6) {
                        soa_type = c.substring(12, c.length() - 1);
                    }
                    if (x == 7) {
                        soa_type_id = c.substring(15, c.length() - 1);
                    }
                    if (x == 8) {
                        user_screen_name = c.substring(20, c.length() - 1);
                    }
                    if (x == 9) {
                        user_id = c.substring(11, c.length() - 1);
                    }
                    if (x == 10) {
                        remarks = c.substring(11, c.length() - 1);
                    }
                    if (x == 11) {
                        item_code = c.substring(13, c.length() - 1);
                    }
                    if (x == 12) {
                        barcode = c.substring(11, c.length() - 1);
                    }
                    if (x == 13) {
                        item_type = c.substring(13, c.length() - 1);
                    }
                    if (x == 14) {
                        serial_no = c.substring(13, c.length() - 1);
                    }
                    if (x == 15) {
                        product_qty = FitIn.toDouble(c.substring(15, c.length() - 1));
                    }
                    if (x == 16) {
                        unit = c.substring(8, c.length() - 1);
                    }
                    if (x == 17) {
                        conversion = FitIn.toDouble(c.substring(14, c.length() - 1));
                    }
                    if (x == 18) {
                        selling_price = FitIn.toDouble(c.substring(17, c.length() - 1));
                    }

                    if (x == 19) {
                        date_added = c.substring(14, c.length() - 1);
                    }
                    if (x == 20) {
                        status = FitIn.toInt(c.substring(10, c.length() - 1));
                    }
                    if (x == 21) {
                        discount_name = c.substring(17, c.length() - 1);
                    }
                    if (x == 22) {
                        discount_rate = FitIn.toDouble(c.substring(17, c.length() - 1));
                    }
                    if (x == 23) {
                        discount_amount = FitIn.toDouble(c.substring(19, c.length() - 1));
                    }
                    if (x == 24) {
                        discount_customer_name = c.substring(26, c.length() - 1);
                    }
                    if (x == 25) {
                        discount_customer_id = c.substring(24, c.length() - 1);
                    }
                    if (x == 26) {
                        branch = c.substring(10, c.length() - 1);
                    }
                    if (x == 27) {
                        branch_code = c.substring(15, c.length() - 1);
                    }
                    if (x == 28) {
                        location = c.substring(12, c.length() - 1);
                    }
                    if (x == 29) {
                        location_id = c.substring(15, c.length() - 1);
                    }
                    if (x == 30) {
                        addtl_amount = FitIn.toDouble(c.substring(16, c.length() - 1));
                    }
                    if (x == 31) {
                        wtax = FitIn.toDouble(c.substring(8, c.length() - 1));
                    }
                    if (x == 32) {
                        is_cancelled = FitIn.toInt(c.substring(16, c.length() - 1));
                    }
                    x++;
                }

                Parse_charged_items pci = new Parse_charged_items(customer_id, customer_name, ar_id, ar_no, date_applied, reference_no, soa_type, soa_type_id, user_screen_name, user_id, remarks, item_code, barcode, item_type, serial_no, product_qty, unit, conversion, selling_price, date_added, status, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, addtl_amount, wtax, is_cancelled);
                datas.add(pci);
            }
            i++;
        }

        return datas;
    }

    public static String compress(String where) {
        String stmts = "\"items\":\"";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_id"
                    + ",ar_no"
                    + ",date_applied"
                    + ",reference_no"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",remarks"
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
                    + ",addtl_amount"
                    + ",wtax"
                    + " from charge_in_advance_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_id = rs.getString(4);
                String ar_no = rs.getString(5);
                String date_applied = rs.getString(6);
                String reference_no = rs.getString(7);
                String soa_type = rs.getString(8);
                String soa_type_id = rs.getString(9);
                String user_screen_name = rs.getString(10);
                String user_id = rs.getString(11);
                String remarks = rs.getString(12);
                String item_code = rs.getString(13);
                String barcode = rs.getString(14);
                String description = rs.getString(15);
                String generic_name = rs.getString(16);
                String item_type = rs.getString(17);
                String supplier_name = rs.getString(18);
                String supplier_id = rs.getString(19);
                String serial_no = rs.getString(20);
                double product_qty = rs.getDouble(21);
                String unit = rs.getString(22);
                double conversion = rs.getDouble(23);
                double selling_price = rs.getDouble(24);
                String date_added = rs.getString(25);
                int status = rs.getInt(26);
                int is_vatable = rs.getInt(27);
                int selling_type = rs.getInt(28);
                String discount_name = rs.getString(29);
                double discount_rate = rs.getDouble(30);
                double discount_amount = rs.getDouble(31);
                String discount_customer_name = rs.getString(32);
                String discount_customer_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_code = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);
                String category = rs.getString(38);
                String category_id = rs.getString(39);
                String classification = rs.getString(40);
                String classification_id = rs.getString(41);
                String sub_classification = rs.getString(42);
                String sub_classification_id = rs.getString(43);
                String brand = rs.getString(44);
                String brand_id = rs.getString(45);
                String model = rs.getString(46);
                String model_id = rs.getString(47);
                double addtl_amount = rs.getDouble(48);
                double wtax = rs.getDouble(49);

                stmts = stmts + "℮{";
                stmts = stmts + "\"customer_id;\":\"" + customer_id + "\"";
                stmts = stmts + "%\"customer_name;\":\"" + customer_name + "\"";
                stmts = stmts + "%\"ar_id\":\"" + ar_id + "\"";
                stmts = stmts + "%\"ar_no\":\"" + ar_no + "\"";
                stmts = stmts + "%\"date_applied\":\"" + date_applied + "\"";
                stmts = stmts + "%\"reference_no\":\"" + reference_no + "\"";
                stmts = stmts + "%\"soa_type\":\"" + soa_type + "\"";
                stmts = stmts + "%\"soa_type_id\":\"" + soa_type_id + "\"";
                stmts = stmts + "%\"user_screen_name\":\"" + user_screen_name + "\"";
                stmts = stmts + "%\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "%\"remarks\":\"" + remarks + "\"";
                stmts = stmts + "%\"item_code\":\"" + item_code + "\"";
                stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                stmts = stmts + "%\"item_type\":\"" + item_type + "\"";
                stmts = stmts + "%\"serial_no\":\"" + serial_no + "\"";
                stmts = stmts + "%\"product_qty\":\"" + product_qty + "\"";
                stmts = stmts + "%\"unit\":\"" + unit + "\"";
                stmts = stmts + "%\"conversion\":\"" + conversion + "\"";
                stmts = stmts + "%\"selling_price\":\"" + selling_price + "\"";
                stmts = stmts + "%\"date_added\":\"" + date_added + "\"";
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
                stmts = stmts + "%\"addtl_amount\":\"" + addtl_amount + "\"";
                stmts = stmts + "%\"wtax\":\"" + wtax + "\"";
                stmts = stmts + "}";

            }

            String s2 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_id"
                    + ",ar_no"
                    + ",date_applied"
                    + ",reference_no"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",remarks"
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
                    + ",addtl_amount"
                    + ",wtax"
                    + " from charge_in_advance_items"
                    + " " + where;

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                String customer_id = rs2.getString(2);
                String customer_name = rs2.getString(3);
                String ar_id = rs2.getString(4);
                String ar_no = rs2.getString(5);
                String date_applied = rs2.getString(6);
                String reference_no = rs2.getString(7);
                String soa_type = rs2.getString(8);
                String soa_type_id = rs2.getString(9);
                String user_screen_name = rs2.getString(10);
                String user_id = rs2.getString(11);
                String remarks = rs2.getString(12);
                String item_code = rs2.getString(13);
                String barcode = rs2.getString(14);
                String description = rs2.getString(15);
                String generic_name = rs2.getString(16);
                String item_type = rs2.getString(17);
                String supplier_name = rs2.getString(18);
                String supplier_id = rs2.getString(19);
                String serial_no = rs2.getString(20);
                double product_qty = rs2.getDouble(21);
                String unit = rs2.getString(22);
                double conversion = rs2.getDouble(23);
                double selling_price = rs2.getDouble(24);
                String date_added = rs2.getString(25);
                int status = rs2.getInt(26);
                int is_vatable = rs2.getInt(27);
                int selling_type = rs2.getInt(28);
                String discount_name = rs2.getString(29);
                double discount_rate = rs2.getDouble(30);
                double discount_amount = rs2.getDouble(31);
                String discount_customer_name = rs2.getString(32);
                String discount_customer_id = rs2.getString(33);
                String branch = rs2.getString(34);
                String branch_code = rs2.getString(35);
                String location = rs2.getString(36);
                String location_id = rs2.getString(37);
                String category = rs2.getString(38);
                String category_id = rs2.getString(39);
                String classification = rs2.getString(40);
                String classification_id = rs2.getString(41);
                String sub_classification = rs2.getString(42);
                String sub_classification_id = rs2.getString(43);
                String brand = rs2.getString(44);
                String brand_id = rs2.getString(45);
                String model = rs2.getString(46);
                String model_id = rs2.getString(47);
                double addtl_amount = rs2.getDouble(48);
                double wtax = rs2.getDouble(49);

                stmts = stmts + "℮{";
                stmts = stmts + "\"customer_id;\":\"" + customer_id + "\"";
                stmts = stmts + "%\"customer_name;\":\"" + customer_name + "\"";
                stmts = stmts + "%\"ar_id\":\"" + ar_id + "\"";
                stmts = stmts + "%\"ar_no\":\"" + ar_no + "\"";
                stmts = stmts + "%\"date_applied\":\"" + date_applied + "\"";
                stmts = stmts + "%\"reference_no\":\"" + reference_no + "\"";
                stmts = stmts + "%\"soa_type\":\"" + soa_type + "\"";
                stmts = stmts + "%\"soa_type_id\":\"" + soa_type_id + "\"";
                stmts = stmts + "%\"user_screen_name\":\"" + user_screen_name + "\"";
                stmts = stmts + "%\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "%\"remarks\":\"" + remarks + "\"";
                stmts = stmts + "%\"item_code\":\"" + item_code + "\"";
                stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                stmts = stmts + "%\"item_type\":\"" + item_type + "\"";
                stmts = stmts + "%\"serial_no\":\"" + serial_no + "\"";
                stmts = stmts + "%\"product_qty\":\"" + product_qty + "\"";
                stmts = stmts + "%\"unit\":\"" + unit + "\"";
                stmts = stmts + "%\"conversion\":\"" + conversion + "\"";
                stmts = stmts + "%\"selling_price\":\"" + selling_price + "\"";
                stmts = stmts + "%\"date_added\":\"" + date_added + "\"";
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
                stmts = stmts + "%\"addtl_amount\":\"" + addtl_amount + "\"";
                stmts = stmts + "%\"wtax\":\"" + wtax + "\"";
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
