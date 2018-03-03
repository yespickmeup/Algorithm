/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.item_replacements;

import POS.my_sales.MySales_Items;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Item_replacements {

    public static class to_item_replacements {

        public final int id;
        public final String item_replacement_no;
        public final String sales_no;
        public final String customer_name;
        public final String customer_id;
        public final String date_added;
        public final String user_screen_name;
        public final String user_id;
        public final String reason;
        public final double amount_due;
        public final double replacement_amount;
        public final double discount;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_item_replacements(int id, String item_replacement_no, String sales_no, String customer_name, String customer_id, String date_added, String user_screen_name, String user_id, String reason, double amount_due, double replacement_amount, double discount, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.item_replacement_no = item_replacement_no;
            this.sales_no = sales_no;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.date_added = date_added;
            this.user_screen_name = user_screen_name;
            this.user_id = user_id;
            this.reason = reason;
            this.amount_due = amount_due;
            this.replacement_amount = replacement_amount;
            this.discount = discount;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_item_replacements to_item_replacements, List<MySales_Items.items> selected, List<MySales_Items.items> replacements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into item_replacements("
                    + "item_replacement_no"
                    + ",sales_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",reason"
                    + ",amount_due"
                    + ",replacement_amount"
                    + ",discount"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":item_replacement_no"
                    + ",:sales_no"
                    + ",:customer_name"
                    + ",:customer_id"
                    + ",:date_added"
                    + ",:user_screen_name"
                    + ",:user_id"
                    + ",:reason"
                    + ",:amount_due"
                    + ",:replacement_amount"
                    + ",:discount"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                    .setString("sales_no", to_item_replacements.sales_no)
                    .setString("customer_name", to_item_replacements.customer_name)
                    .setString("customer_id", to_item_replacements.customer_id)
                    .setString("date_added", to_item_replacements.date_added)
                    .setString("user_screen_name", to_item_replacements.user_screen_name)
                    .setString("user_id", to_item_replacements.user_id)
                    .setString("reason", to_item_replacements.reason)
                    .setNumber("amount_due", to_item_replacements.amount_due)
                    .setNumber("replacement_amount", to_item_replacements.replacement_amount)
                    .setNumber("discount", to_item_replacements.discount)
                    .setNumber("status", to_item_replacements.status)
                    .setString("branch", to_item_replacements.branch)
                    .setString("branch_id", to_item_replacements.branch_id)
                    .setString("location", to_item_replacements.location)
                    .setString("location_id", to_item_replacements.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (MySales_Items.items to_item_replacement_details : selected) {
                String s2 = "insert into item_replacement_details("
                        + "item_replacement_no"
                        + ",sales_no"
                        + ",customer_name"
                        + ",customer_id"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",item_code"
                        + ",barcode"
                        + ",generic_name"
                        + ",description"
                        + ",item_type"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",is_replacement"
                        + ",reason"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":item_replacement_no"
                        + ",:sales_no"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:date_added"
                        + ",:user_screen_name"
                        + ",:user_id"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:generic_name"
                        + ",:description"
                        + ",:item_type"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:is_replacement"
                        + ",:reason"
                        + ",:status"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                        .setString("sales_no", to_item_replacements.sales_no)
                        .setString("customer_name", to_item_replacements.customer_name)
                        .setString("customer_id", to_item_replacements.customer_id)
                        .setString("date_added", to_item_replacements.date_added)
                        .setString("user_screen_name", to_item_replacements.user_screen_name)
                        .setString("user_id", to_item_replacements.user_id)
                        .setString("item_code", to_item_replacement_details.item_code)
                        .setString("barcode", to_item_replacement_details.barcode)
                        .setString("generic_name", to_item_replacement_details.generic_name)
                        .setString("description", to_item_replacement_details.description)
                        .setString("item_type", to_item_replacement_details.item_type)
                        .setString("serial_no", to_item_replacement_details.serial_no)
                        .setNumber("product_qty", to_item_replacement_details.product_qty)
                        .setString("unit", to_item_replacement_details.unit)
                        .setNumber("conversion", to_item_replacement_details.conversion)
                        .setNumber("selling_price", to_item_replacement_details.selling_price)
                        .setNumber("is_vatable", to_item_replacement_details.is_vatable)
                        .setNumber("selling_type", to_item_replacement_details.selling_type)
                        .setString("discount_name", to_item_replacement_details.discount_name)
                        .setNumber("discount_amount", to_item_replacement_details.discount_amount)
                        .setString("discount_customer_name", to_item_replacement_details.discount_customer_name)
                        .setString("discount_customer_id", to_item_replacement_details.discount_customer_id)
                        .setString("category", to_item_replacement_details.category)
                        .setString("category_id", to_item_replacement_details.category_id)
                        .setString("classification", to_item_replacement_details.classification)
                        .setString("sub_classification", to_item_replacement_details.sub_classification)
                        .setString("sub_classification_id", to_item_replacement_details.sub_classification_id)
                        .setString("brand", to_item_replacement_details.brand)
                        .setString("brand_id", to_item_replacement_details.brand_id)
                        .setString("model", to_item_replacement_details.model)
                        .setString("model_id", to_item_replacement_details.model_id)
                        .setNumber("is_replacement", 0)
                        .setString("reason", to_item_replacements.reason)
                        .setNumber("status", to_item_replacements.status)
                        .setString("branch", to_item_replacements.branch)
                        .setString("branch_id", to_item_replacements.branch_id)
                        .setString("location", to_item_replacements.location)
                        .setString("location_id", to_item_replacements.location_id)
                        .ok();
                stmt.addBatch(s2);
            }
            for (MySales_Items.items to_item_replacement_details : replacements) {
                String s2 = "insert into item_replacement_details("
                        + "item_replacement_no"
                        + ",sales_no"
                        + ",customer_name"
                        + ",customer_id"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",item_code"
                        + ",barcode"
                        + ",generic_name"
                        + ",description"
                        + ",item_type"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",is_replacement"
                        + ",reason"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":item_replacement_no"
                        + ",:sales_no"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:date_added"
                        + ",:user_screen_name"
                        + ",:user_id"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:generic_name"
                        + ",:description"
                        + ",:item_type"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:is_replacement"
                        + ",:reason"
                        + ",:status"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                        .setString("sales_no", to_item_replacements.sales_no)
                        .setString("customer_name", to_item_replacements.customer_name)
                        .setString("customer_id", to_item_replacements.customer_id)
                        .setString("date_added", to_item_replacements.date_added)
                        .setString("user_screen_name", to_item_replacements.user_screen_name)
                        .setString("user_id", to_item_replacements.user_id)
                        .setString("item_code", to_item_replacement_details.item_code)
                        .setString("barcode", to_item_replacement_details.barcode)
                        .setString("generic_name", to_item_replacement_details.generic_name)
                        .setString("description", to_item_replacement_details.description)
                        .setString("item_type", to_item_replacement_details.item_type)
                        .setString("serial_no", to_item_replacement_details.serial_no)
                        .setNumber("product_qty", to_item_replacement_details.product_qty)
                        .setString("unit", to_item_replacement_details.unit)
                        .setNumber("conversion", to_item_replacement_details.conversion)
                        .setNumber("selling_price", to_item_replacement_details.selling_price)
                        .setNumber("is_vatable", to_item_replacement_details.is_vatable)
                        .setNumber("selling_type", to_item_replacement_details.selling_type)
                        .setString("discount_name", to_item_replacement_details.discount_name)
                        .setNumber("discount_amount", to_item_replacement_details.discount_amount)
                        .setString("discount_customer_name", to_item_replacement_details.discount_customer_name)
                        .setString("discount_customer_id", to_item_replacement_details.discount_customer_id)
                        .setString("category", to_item_replacement_details.category)
                        .setString("category_id", to_item_replacement_details.category_id)
                        .setString("classification", to_item_replacement_details.classification)
                        .setString("sub_classification", to_item_replacement_details.sub_classification)
                        .setString("sub_classification_id", to_item_replacement_details.sub_classification_id)
                        .setString("brand", to_item_replacement_details.brand)
                        .setString("brand_id", to_item_replacement_details.brand_id)
                        .setString("model", to_item_replacement_details.model)
                        .setString("model_id", to_item_replacement_details.model_id)
                        .setNumber("is_replacement", 1)
                        .setString("reason", to_item_replacements.reason)
                        .setNumber("status", to_item_replacements.status)
                        .setString("branch", to_item_replacements.branch)
                        .setString("branch_id", to_item_replacements.branch_id)
                        .setString("location", to_item_replacements.location)
                        .setString("location_id", to_item_replacements.location_id)
                        .ok();
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Item_replacements.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_item_replacements to_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update item_replacements set "
                    + "item_replacement_no= :item_replacement_no "
                    + ",sales_no= :sales_no "
                    + ",customer_name= :customer_name "
                    + ",customer_id= :customer_id "
                    + ",date_added= :date_added "
                    + ",user_screen_name= :user_screen_name "
                    + ",user_id= :user_id "
                    + ",reason= :reason "
                    + ",amount_due= :amount_due "
                    + ",replacement_amount= :replacement_amount "
                    + ",discount= :discount "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                    .setString("sales_no", to_item_replacements.sales_no)
                    .setString("customer_name", to_item_replacements.customer_name)
                    .setString("customer_id", to_item_replacements.customer_id)
                    .setString("date_added", to_item_replacements.date_added)
                    .setString("user_screen_name", to_item_replacements.user_screen_name)
                    .setString("user_id", to_item_replacements.user_id)
                    .setString("reason", to_item_replacements.reason)
                    .setNumber("amount_due", to_item_replacements.amount_due)
                    .setNumber("replacement_amount", to_item_replacements.replacement_amount)
                    .setNumber("discount", to_item_replacements.discount)
                    .setNumber("status", to_item_replacements.status)
                    .setString("branch", to_item_replacements.branch)
                    .setString("branch_id", to_item_replacements.branch_id)
                    .setString("location", to_item_replacements.location)
                    .setString("location_id", to_item_replacements.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_discount(to_item_replacements to_item_replacements, double new_discount) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update item_replacements set "
                    + " discount= :discount "
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("discount", new_discount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_item_replacements to_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from item_replacements  "
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "delete from item_replacement_details  "
                    + " where item_replacement_no='" + to_item_replacements.item_replacement_no + "' "
                    + " ";
            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            Lg.s(Item_replacements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_transaction(to_item_replacements to_item_replacements, List<Item_replacement_details.to_item_replacement_details> selected, List<Item_replacement_details.to_item_replacement_details> replacements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "update item_replacements  "
                    + " set status = 1"
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update item_replacement_details  "
                    + " set status = 1"
                    + " where item_replacement_no='" + to_item_replacements.item_replacement_no + "' "
                    + " ";
            stmt.addBatch(s2);

            for (Item_replacement_details.to_item_replacement_details item : selected) {
                String s11 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + item.item_code + "' and location_id='" + item.location_id + "'"
                        + " ";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                double product_qty2 = 0;
                while (rs11.next()) {
                    product_qty2 = rs11.getDouble(1);
                }

                double new_qty = product_qty2 + (item.conversion * item.product_qty);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + item.item_code + "' and location_id='" + item.location_id + "' "
                        + "";
                stmt.addBatch(s4);

            }

            for (Item_replacement_details.to_item_replacement_details item : replacements) {
                String s11 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + item.item_code + "' and location_id='" + item.location_id + "'"
                        + " ";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                double product_qty2 = 0;
                while (rs11.next()) {
                    product_qty2 = rs11.getDouble(1);
                }

                double new_qty = product_qty2 - (item.conversion * item.product_qty);
                String s5 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + item.item_code + "' and location_id='" + item.location_id + "' "
                        + "";
                stmt.addBatch(s5);

            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Item_replacements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_item_replacements> ret_data(String where) {
        List<to_item_replacements> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_replacement_no"
                    + ",sales_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",reason"
                    + ",amount_due"
                    + ",replacement_amount"
                    + ",discount"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from item_replacements"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_replacement_no = rs.getString(2);
                String sales_no = rs.getString(3);
                String customer_name = rs.getString(4);
                String customer_id = rs.getString(5);
                String date_added = rs.getString(6);
                String user_screen_name = rs.getString(7);
                String user_id = rs.getString(8);
                String reason = rs.getString(9);
                double amount_due = rs.getDouble(10);
                double replacement_amount = rs.getDouble(11);
                double discount = rs.getDouble(12);
                int status = rs.getInt(13);
                String branch = rs.getString(14);
                String branch_id = rs.getString(15);
                String location = rs.getString(16);
                String location_id = rs.getString(17);

                to_item_replacements to = new to_item_replacements(id, item_replacement_no, sales_no, customer_name, customer_id, date_added, user_screen_name, user_id, reason, amount_due, replacement_amount, discount, status, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id(String location_id) {

        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from item_replacements where location_id='" + location_id + "'  ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
//            System.out.println(s0);
            if (rs.next()) {
                id = rs.getString(1);

                String s2 = "select item_replacement_no,id from item_replacements where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }

            if (id == null) {
                id = location_id + "|" + "0000000000";
            }

            id = ReceiptIncrementor.increment(id);

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
