/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.item_replacements;

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
public class Item_replacement_details {

    public static class to_item_replacement_details {

        public final int id;
        public final String item_replacement_no;
        public final String sales_no;
        public final String customer_name;
        public final String customer_id;
        public final String date_added;
        public final String user_screen_name;
        public final String user_id;
        public final String item_code;
        public final String barcode;
        public final String generic_name;
        public final String description;
        public final String item_type;
        public final String serial_no;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final int is_vatable;
        public final int selling_type;
        public final String discount_name;
        public final double discount_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int is_replacement;
        public final String reason;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final double addtl_amount;
        public final double wtax;
        public to_item_replacement_details(int id, String item_replacement_no, String sales_no, String customer_name, String customer_id, String date_added, String user_screen_name, String user_id, String item_code, String barcode, String generic_name, String description, String item_type, String serial_no, double product_qty, String unit, double conversion, double selling_price, int is_vatable, int selling_type, String discount_name, double discount_amount, String discount_customer_name, String discount_customer_id, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, String brand, String brand_id, String model, String model_id, int is_replacement, String reason, int status, String branch, String branch_id, String location, String location_id,double addtl_amount,double wtax) {
            this.id = id;
            this.item_replacement_no = item_replacement_no;
            this.sales_no = sales_no;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.date_added = date_added;
            this.user_screen_name = user_screen_name;
            this.user_id = user_id;
            this.item_code = item_code;
            this.barcode = barcode;
            this.generic_name = generic_name;
            this.description = description;
            this.item_type = item_type;
            this.serial_no = serial_no;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.is_vatable = is_vatable;
            this.selling_type = selling_type;
            this.discount_name = discount_name;
            this.discount_amount = discount_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.is_replacement = is_replacement;
            this.reason = reason;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.addtl_amount=addtl_amount;
            this.wtax=wtax;
        }
    }

    public static void add_data(to_item_replacement_details to_item_replacement_details) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into item_replacement_details("
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
                    + ",addtl_amount"
                    + ",wtax"
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
                    + ",:addtl_amount"
                    + ",:wtax"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_replacement_no", to_item_replacement_details.item_replacement_no)
                    .setString("sales_no", to_item_replacement_details.sales_no)
                    .setString("customer_name", to_item_replacement_details.customer_name)
                    .setString("customer_id", to_item_replacement_details.customer_id)
                    .setString("date_added", to_item_replacement_details.date_added)
                    .setString("user_screen_name", to_item_replacement_details.user_screen_name)
                    .setString("user_id", to_item_replacement_details.user_id)
                    .setString("item_code", to_item_replacement_details.item_code)
                    .setString("barcode", to_item_replacement_details.barcode)
                    .setString("generic_name", to_item_replacement_details.generic_name)
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
                    .setNumber("is_replacement", to_item_replacement_details.is_replacement)
                    .setString("reason", to_item_replacement_details.reason)
                    .setNumber("status", to_item_replacement_details.status)
                    .setString("branch", to_item_replacement_details.branch)
                    .setString("branch_id", to_item_replacement_details.branch_id)
                    .setString("location", to_item_replacement_details.location)
                    .setString("location_id", to_item_replacement_details.location_id)
                    .setNumber("addtl_amount", to_item_replacement_details.addtl_amount)
                    .setNumber("wtax", to_item_replacement_details.wtax)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacement_details.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_item_replacement_details to_item_replacement_details) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update item_replacement_details set "
                    + "item_replacement_no= :item_replacement_no "
                    + ",sales_no= :sales_no "
                    + ",customer_name= :customer_name "
                    + ",customer_id= :customer_id "
                    + ",date_added= :date_added "
                    + ",user_screen_name= :user_screen_name "
                    + ",user_id= :user_id "
                    + ",item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",generic_name= :generic_name "
                    + ",item_type= :item_type "
                    + ",serial_no= :serial_no "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",is_vatable= :is_vatable "
                    + ",selling_type= :selling_type "
                    + ",discount_name= :discount_name "
                    + ",discount_amount= :discount_amount "
                    + ",discount_customer_name= :discount_customer_name "
                    + ",discount_customer_id= :discount_customer_id "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",is_replacement= :is_replacement "
                    + ",reason= :reason "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",addtl_amount= :addtl_amount"
                    + ",wtax= :wtax"
                    + " where id='" + to_item_replacement_details.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_replacement_no", to_item_replacement_details.item_replacement_no)
                    .setString("sales_no", to_item_replacement_details.sales_no)
                    .setString("customer_name", to_item_replacement_details.customer_name)
                    .setString("customer_id", to_item_replacement_details.customer_id)
                    .setString("date_added", to_item_replacement_details.date_added)
                    .setString("user_screen_name", to_item_replacement_details.user_screen_name)
                    .setString("user_id", to_item_replacement_details.user_id)
                    .setString("item_code", to_item_replacement_details.item_code)
                    .setString("barcode", to_item_replacement_details.barcode)
                    .setString("generic_name", to_item_replacement_details.generic_name)
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
                    .setNumber("is_replacement", to_item_replacement_details.is_replacement)
                    .setString("reason", to_item_replacement_details.reason)
                    .setNumber("status", to_item_replacement_details.status)
                    .setString("branch", to_item_replacement_details.branch)
                    .setString("branch_id", to_item_replacement_details.branch_id)
                    .setString("location", to_item_replacement_details.location)
                    .setString("location_id", to_item_replacement_details.location_id)
                    .setNumber("addtl_amount", to_item_replacement_details.addtl_amount)
                    .setNumber("wtax", to_item_replacement_details.wtax)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacement_details.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_serial(to_item_replacement_details to_item_replacement_details, String serial) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update item_replacement_details set "
                    + " serial_no= :serial_no "
                    + " where id='" + to_item_replacement_details.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("serial_no", serial)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacement_details.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_item_replacement_details to_item_replacement_details) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from item_replacement_details  "
                    + " where id='" + to_item_replacement_details.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacement_details.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_item_replacement_details> ret_data(String where) {
        List<to_item_replacement_details> datas = new ArrayList();

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
                    + ",classification_id"
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
                    + ",addtl_amount"
                    + ",wtax"
                    + " from item_replacement_details"
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
                String item_code = rs.getString(9);
                String barcode = rs.getString(10);
                String generic_name = rs.getString(11);
                String description = rs.getString(12);
                String item_type = rs.getString(13);
                String serial_no = rs.getString(14);
                double product_qty = rs.getDouble(15);
                String unit = rs.getString(16);
                double conversion = rs.getDouble(17);
                double selling_price = rs.getDouble(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_amount = rs.getDouble(22);
                String discount_customer_name = rs.getString(23);
                String discount_customer_id = rs.getString(24);
                String category = rs.getString(25);
                String category_id = rs.getString(26);
                String classification = rs.getString(27);
                String classification_id = rs.getString(28);
                String sub_classification = rs.getString(29);
                String sub_classification_id = rs.getString(30);
                String brand = rs.getString(31);
                String brand_id = rs.getString(32);
                String model = rs.getString(33);
                String model_id = rs.getString(34);
                int is_replacement = rs.getInt(35);
                String reason = rs.getString(36);
                int status = rs.getInt(37);
                String branch = rs.getString(38);
                String branch_id = rs.getString(39);
                String location = rs.getString(40);
                String location_id = rs.getString(41);
                double addtl_amount=rs.getDouble(42);
                double wtax=rs.getDouble(43);
                to_item_replacement_details to = new to_item_replacement_details(id, item_replacement_no, sales_no, customer_name, customer_id, date_added, user_screen_name, user_id, item_code, barcode, generic_name, description, item_type, serial_no, product_qty, unit, conversion, selling_price, is_vatable, selling_type, discount_name, discount_amount, discount_customer_name, discount_customer_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, is_replacement, reason, status, branch, branch_id, location, location_id,addtl_amount,wtax);
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
