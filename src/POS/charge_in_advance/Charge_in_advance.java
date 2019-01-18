/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.charge_in_advance;

import POS.accounts_receivable.S1_accounts_receivable.to_accounts_receivable;
import POS.inventory.Inventory_barcodes;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Charge_in_advance {

    public static class to_charge_in_advance {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String ar_id;
        public final String ar_no;
        public final String date_applied;
        public final String reference_no;
        public final String soa_type;
        public final String soa_type_id;
        public final String remarks;
        public final int status;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_charge_in_advance(int id, String customer_id, String customer_name, String ar_id, String ar_no, String date_applied, String reference_no, String soa_type, String soa_type_id, String remarks, int status, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.ar_id = ar_id;
            this.ar_no = ar_no;
            this.date_applied = date_applied;
            this.reference_no = reference_no;
            this.soa_type = soa_type;
            this.soa_type_id = soa_type_id;
            this.remarks = remarks;
            this.status = status;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_charge_in_advance to_charge_in_advance) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into charge_in_advance("
                    + "customer_id"
                    + ",customer_name"
                    + ",ar_id"
                    + ",ar_no"
                    + ",date_applied"
                    + ",reference_no"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",remarks"
                    + ",status"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:ar_id"
                    + ",:ar_no"
                    + ",:date_applied"
                    + ",:reference_no"
                    + ",:soa_type"
                    + ",:soa_type_id"
                    + ",:remarks"
                    + ",:status"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_charge_in_advance.customer_id)
                    .setString("customer_name", to_charge_in_advance.customer_name)
                    .setString("ar_id", to_charge_in_advance.ar_id)
                    .setString("ar_no", to_charge_in_advance.ar_no)
                    .setString("date_applied", to_charge_in_advance.date_applied)
                    .setString("reference_no", to_charge_in_advance.reference_no)
                    .setString("soa_type", to_charge_in_advance.soa_type)
                    .setString("soa_type_id", to_charge_in_advance.soa_type_id)
                    .setString("remarks", to_charge_in_advance.remarks)
                    .setNumber("status", to_charge_in_advance.status)
                    .setString("user_id", to_charge_in_advance.user_id)
                    .setString("user_screen_name", to_charge_in_advance.user_screen_name)
                    .setString("branch", to_charge_in_advance.branch)
                    .setString("branch_id", to_charge_in_advance.branch_id)
                    .setString("location", to_charge_in_advance.location)
                    .setString("location_id", to_charge_in_advance.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Charge_in_advance.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_charge_in_advance to_charge_in_advance) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into charge_in_advance("
                    + "customer_id"
                    + ",customer_name"
                    + ",ar_id"
                    + ",ar_no"
                    + ",date_applied"
                    + ",reference_no"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",remarks"
                    + ",status"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:ar_id"
                    + ",:ar_no"
                    + ",:date_applied"
                    + ",:reference_no"
                    + ",:soa_type"
                    + ",:soa_type_id"
                    + ",:remarks"
                    + ",:status"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_charge_in_advance.customer_id)
                    .setString("customer_name", to_charge_in_advance.customer_name)
                    .setString("ar_id", to_charge_in_advance.ar_id)
                    .setString("ar_no", to_charge_in_advance.ar_no)
                    .setString("date_applied", to_charge_in_advance.date_applied)
                    .setString("reference_no", to_charge_in_advance.reference_no)
                    .setString("soa_type", to_charge_in_advance.soa_type)
                    .setString("soa_type_id", to_charge_in_advance.soa_type_id)
                    .setString("remarks", to_charge_in_advance.remarks)
                    .setNumber("status", to_charge_in_advance.status)
                    .setString("user_id", to_charge_in_advance.user_id)
                    .setString("user_screen_name", to_charge_in_advance.user_screen_name)
                    .setString("branch", to_charge_in_advance.branch)
                    .setString("branch_id", to_charge_in_advance.branch_id)
                    .setString("location", to_charge_in_advance.location)
                    .setString("location_id", to_charge_in_advance.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update charge_in_advance set is_uploaded=1 where id='" + to_charge_in_advance.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Charge_in_advance.class, "Successfully Added: " + to_charge_in_advance.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_data(to_charge_in_advance to_charge_in_advance) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update charge_in_advance set "
                    + "customer_id= :customer_id "
                    + ",customer_name= :customer_name "
                    + ",ar_id= :ar_id "
                    + ",ar_no= :ar_no "
                    + ",date_applied= :date_applied "
                    + ",reference_no= :reference_no "
                    + ",soa_type= :soa_type "
                    + ",soa_type_id= :soa_type_id "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_charge_in_advance.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_charge_in_advance.customer_id)
                    .setString("customer_name", to_charge_in_advance.customer_name)
                    .setString("ar_id", to_charge_in_advance.ar_id)
                    .setString("ar_no", to_charge_in_advance.ar_no)
                    .setString("date_applied", to_charge_in_advance.date_applied)
                    .setString("reference_no", to_charge_in_advance.reference_no)
                    .setString("soa_type", to_charge_in_advance.soa_type)
                    .setString("soa_type_id", to_charge_in_advance.soa_type_id)
                    .setString("remarks", to_charge_in_advance.remarks)
                    .setNumber("status", to_charge_in_advance.status)
                    .setString("user_id", to_charge_in_advance.user_id)
                    .setString("user_screen_name", to_charge_in_advance.user_screen_name)
                    .setString("branch", to_charge_in_advance.branch)
                    .setString("branch_id", to_charge_in_advance.branch_id)
                    .setString("location", to_charge_in_advance.location)
                    .setString("location_id", to_charge_in_advance.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Charge_in_advance.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_charge_in_advance to_charge_in_advance) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from charge_in_advance  "
                    + " where id='" + to_charge_in_advance.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Charge_in_advance.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_charge_in_advance> ret_charge(String where) {
        List<to_charge_in_advance> datas = new ArrayList();

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
                    + ",remarks"
                    + ",status"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from charge_in_advance"
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
                String remarks = rs.getString(10);
                int status = rs.getInt(11);
                String user_id = rs.getString(12);
                String user_screen_name = rs.getString(13);
                String branch = rs.getString(14);
                String branch_id = rs.getString(15);
                String location = rs.getString(16);
                String location_id = rs.getString(17);

                to_charge_in_advance to = new to_charge_in_advance(id, customer_id, customer_name, ar_id, ar_no, date_applied, reference_no, soa_type, soa_type_id, remarks, status, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_accounts_receivable> ret_data(String where) {
        List<to_accounts_receivable> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from accounts_receivable"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                double amount = rs.getDouble(7);
                double discount_amount = rs.getDouble(8);
                double discount_rate = rs.getDouble(9);
                String discount = rs.getString(10);
                int status = rs.getInt(11);
                double term = rs.getDouble(12);
                String date_applied = rs.getString(13);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                String ci_no = rs.getString(19);
                String trust_receipt = rs.getString(20);
                String soa_id = rs.getString(21);
                String soa_type = rs.getString(22);
                String soa_type_id = rs.getString(23);
                String reference_no = rs.getString(24);
                String user_id = rs.getString(25);
                String user_screen_name = rs.getString(26);
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);

                to_accounts_receivable to = new to_accounts_receivable(false, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Inventory_barcodes.to_inventory_barcodes> ret_items(String where) {
        List<Inventory_barcodes.to_inventory_barcodes> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",serial_no"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + " from inventory_barcodes "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                String main_barcode = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);

                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String serial_no = rs.getString(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                Inventory_barcodes.to_inventory_barcodes to = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0,allow_negative_inventory,auto_order);
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
