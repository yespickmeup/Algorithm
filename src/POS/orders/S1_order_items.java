/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.orders;

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
public class S1_order_items {

    public static class to_order_items {

        public final int id;
        public final String sales_no;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String item_type;
        public final String supplier_name;
        public final String supplier_id;
        public final String serial_no;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final int status;
        public final int is_vatable;
        public final int selling_type;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
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
        public final double addtl_amount;
        public final double wtax;

        public to_order_items(int id, String sales_no, String item_code, String barcode, String description, String generic_name, String item_type, String supplier_name, String supplier_id, String serial_no, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_id, String user_screen_name, int status, int is_vatable, int selling_type, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String branch, String branch_code, String location, String location_id, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, String brand, String brand_id, String model, String model_id, double addtl_amount, double wtax) {
            this.id = id;
            this.sales_no = sales_no;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.item_type = item_type;
            this.supplier_name = supplier_name;
            this.supplier_id = supplier_id;
            this.serial_no = serial_no;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.status = status;
            this.is_vatable = is_vatable;
            this.selling_type = selling_type;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
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
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
        }
    }

    public static void add_data(List<to_order_items> to_order_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_order_items to_order_items : to_order_items1) {
                String s0 = "insert into order_items("
                        + "sales_no"
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
                        + ",addtl_amount"
                        + ",wtax"
                        + ")values("
                        + ":sales_no"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:item_type"
                        + ",:supplier_name"
                        + ",:supplier_id"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:status"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:addtl_amount"
                        + ",:wtax"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("sales_no", to_order_items.sales_no)
                        .setString("item_code", to_order_items.item_code)
                        .setString("barcode", to_order_items.barcode)
                        .setString("description", to_order_items.description)
                        .setString("generic_name", to_order_items.generic_name)
                        .setString("item_type", to_order_items.item_type)
                        .setString("supplier_name", to_order_items.supplier_name)
                        .setString("supplier_id", to_order_items.supplier_id)
                        .setString("serial_no", to_order_items.serial_no)
                        .setNumber("product_qty", to_order_items.product_qty)
                        .setString("unit", to_order_items.unit)
                        .setNumber("conversion", to_order_items.conversion)
                        .setNumber("selling_price", to_order_items.selling_price)
                        .setString("date_added", to_order_items.date_added)
                        .setString("user_id", to_order_items.user_id)
                        .setString("user_screen_name", to_order_items.user_screen_name)
                        .setNumber("status", to_order_items.status)
                        .setNumber("is_vatable", to_order_items.is_vatable)
                        .setNumber("selling_type", to_order_items.selling_type)
                        .setString("discount_name", to_order_items.discount_name)
                        .setNumber("discount_rate", to_order_items.discount_rate)
                        .setNumber("discount_amount", to_order_items.discount_amount)
                        .setString("discount_customer_name", to_order_items.discount_customer_name)
                        .setString("discount_customer_id", to_order_items.discount_customer_id)
                        .setString("branch", to_order_items.branch)
                        .setString("branch_code", to_order_items.branch_code)
                        .setString("location", to_order_items.location)
                        .setString("location_id", to_order_items.location_id)
                        .setString("category", to_order_items.category)
                        .setString("category_id", to_order_items.category_id)
                        .setString("classification", to_order_items.classification)
                        .setString("classification_id", to_order_items.classification_id)
                        .setString("sub_classification", to_order_items.sub_classification)
                        .setString("sub_classification_id", to_order_items.sub_classification_id)
                        .setString("brand", to_order_items.brand)
                        .setString("brand_id", to_order_items.brand_id)
                        .setString("model", to_order_items.model)
                        .setString("model_id", to_order_items.model_id)
                        .setNumber("addtl_amount", to_order_items.addtl_amount)
                        .setNumber("wtax", to_order_items.wtax)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_order_items.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_order_items to_order_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update order_items set "
                    + "sales_no= :sales_no "
                    + ",item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",generic_name= :generic_name "
                    + ",item_type= :item_type "
                    + ",supplier_name= :supplier_name "
                    + ",supplier_id= :supplier_id "
                    + ",serial_no= :serial_no "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",date_added= :date_added "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",status= :status "
                    + ",is_vatable= :is_vatable "
                    + ",selling_type= :selling_type "
                    + ",discount_name= :discount_name "
                    + ",discount_rate= :discount_rate "
                    + ",discount_amount= :discount_amount "
                    + ",discount_customer_name= :discount_customer_name "
                    + ",discount_customer_id= :discount_customer_id "
                    + ",branch= :branch "
                    + ",branch_code= :branch_code "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",addtl_amount= :addtl_amount "
                    + ",wtax= :wtax "
                    + " where id='" + to_order_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_order_items.sales_no)
                    .setString("item_code", to_order_items.item_code)
                    .setString("barcode", to_order_items.barcode)
                    .setString("description", to_order_items.description)
                    .setString("generic_name", to_order_items.generic_name)
                    .setString("item_type", to_order_items.item_type)
                    .setString("supplier_name", to_order_items.supplier_name)
                    .setString("supplier_id", to_order_items.supplier_id)
                    .setString("serial_no", to_order_items.serial_no)
                    .setNumber("product_qty", to_order_items.product_qty)
                    .setString("unit", to_order_items.unit)
                    .setNumber("conversion", to_order_items.conversion)
                    .setNumber("selling_price", to_order_items.selling_price)
                    .setString("date_added", to_order_items.date_added)
                    .setString("user_id", to_order_items.user_id)
                    .setString("user_screen_name", to_order_items.user_screen_name)
                    .setNumber("status", to_order_items.status)
                    .setNumber("is_vatable", to_order_items.is_vatable)
                    .setNumber("selling_type", to_order_items.selling_type)
                    .setString("discount_name", to_order_items.discount_name)
                    .setNumber("discount_rate", to_order_items.discount_rate)
                    .setNumber("discount_amount", to_order_items.discount_amount)
                    .setString("discount_customer_name", to_order_items.discount_customer_name)
                    .setString("discount_customer_id", to_order_items.discount_customer_id)
                    .setString("branch", to_order_items.branch)
                    .setString("branch_code", to_order_items.branch_code)
                    .setString("location", to_order_items.location)
                    .setString("location_id", to_order_items.location_id)
                    .setString("category", to_order_items.category)
                    .setString("category_id", to_order_items.category_id)
                    .setString("classification", to_order_items.classification)
                    .setString("classification_id", to_order_items.classification_id)
                    .setString("sub_classification", to_order_items.sub_classification)
                    .setString("sub_classification_id", to_order_items.sub_classification_id)
                    .setString("brand", to_order_items.brand)
                    .setString("brand_id", to_order_items.brand_id)
                    .setString("model", to_order_items.model)
                    .setString("model_id", to_order_items.model_id)
                    .setNumber("addtl_amount", to_order_items.addtl_amount)
                    .setNumber("wtax", to_order_items.wtax)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_order_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(String where) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from order_items  "
                    + " " + where;

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_order_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_order_items> ret_data(String where) {
        List<to_order_items> datas = new ArrayList();

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
                    + ",addtl_amount"
                    + ",wtax"
                    + " from order_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
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
                double addtl_amount = rs.getDouble(40);
                double wtax = rs.getDouble(41);

                to_order_items to = new to_order_items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, addtl_amount, wtax);
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
