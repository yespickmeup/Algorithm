/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports3;

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
public class Stock_take_items {

    public static class to_stock_take_items {

        public final int id;
        public final String stock_take_no;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String remarks;
        public final String barcode;
        public final String description;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final double conversion;
        public final String unit;
        public final String barcodes;
        public final String main_barcode;
        public final double qty;
        public final double cost;
        public final double selling_price;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_stock_take_items(int id, String stock_take_no, String user_id, String user_screen_name, String date_added, String remarks, String barcode, String description, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, String brand, String brand_id, String model, String model_id, double conversion, String unit, String barcodes, String main_barcode, double qty, double cost, double selling_price, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.stock_take_no = stock_take_no;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.remarks = remarks;
            this.barcode = barcode;
            this.description = description;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.conversion = conversion;
            this.unit = unit;
            this.barcodes = barcodes;
            this.main_barcode = main_barcode;
            this.qty = qty;
            this.cost = cost;
            this.selling_price = selling_price;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_stock_take_items to_stock_take_items) {
        try {
            Connection conn = MyConnection.connect();
            
            String s0 = "insert into stock_take_items("
                    + "stock_take_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",conversion"
                    + ",unit"
                    + ",barcodes"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":stock_take_no"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:remarks"
                    + ",:barcode"
                    + ",:description"
                    + ",:category"
                    + ",:category_id"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:sub_class"
                    + ",:sub_class_id"
                    + ",:brand"
                    + ",:brand_id"
                    + ",:model"
                    + ",:model_id"
                    + ",:conversion"
                    + ",:unit"
                    + ",:barcodes"
                    + ",:main_barcode"
                    + ",:qty"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("stock_take_no", to_stock_take_items.stock_take_no)
                    .setString("user_id", to_stock_take_items.user_id)
                    .setString("user_screen_name", to_stock_take_items.user_screen_name)
                    .setString("date_added", to_stock_take_items.date_added)
                    .setString("remarks", to_stock_take_items.remarks)
                    .setString("barcode", to_stock_take_items.barcode)
                    .setString("description", to_stock_take_items.description)
                    .setString("category", to_stock_take_items.category)
                    .setString("category_id", to_stock_take_items.category_id)
                    .setString("classification", to_stock_take_items.classification)
                    .setString("classification_id", to_stock_take_items.classification_id)
                    .setString("sub_class", to_stock_take_items.sub_class)
                    .setString("sub_class_id", to_stock_take_items.sub_class_id)
                    .setString("brand", to_stock_take_items.brand)
                    .setString("brand_id", to_stock_take_items.brand_id)
                    .setString("model", to_stock_take_items.model)
                    .setString("model_id", to_stock_take_items.model_id)
                    .setNumber("conversion", to_stock_take_items.conversion)
                    .setString("unit", to_stock_take_items.unit)
                    .setString("barcodes", to_stock_take_items.barcodes)
                    .setString("main_barcode", to_stock_take_items.main_barcode)
                    .setNumber("qty", to_stock_take_items.qty)
                    .setNumber("cost", to_stock_take_items.cost)
                    .setNumber("selling_price", to_stock_take_items.selling_price)
                    .setString("branch", to_stock_take_items.branch)
                    .setString("branch_id", to_stock_take_items.branch_id)
                    .setString("location", to_stock_take_items.location)
                    .setString("location_id", to_stock_take_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_take_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_stock_take_items to_stock_take_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_take_items set "
                    + "stock_take_no= :stock_take_no "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",remarks= :remarks "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_class= :sub_class "
                    + ",sub_class_id= :sub_class_id "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",conversion= :conversion "
                    + ",unit= :unit "
                    + ",barcodes= :barcodes "
                    + ",main_barcode= :main_barcode "
                    + ",qty= :qty "
                    + ",cost= :cost "
                    + ",selling_price= :selling_price "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_stock_take_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("stock_take_no", to_stock_take_items.stock_take_no)
                    .setString("user_id", to_stock_take_items.user_id)
                    .setString("user_screen_name", to_stock_take_items.user_screen_name)
                    .setString("date_added", to_stock_take_items.date_added)
                    .setString("remarks", to_stock_take_items.remarks)
                    .setString("barcode", to_stock_take_items.barcode)
                    .setString("description", to_stock_take_items.description)
                    .setString("category", to_stock_take_items.category)
                    .setString("category_id", to_stock_take_items.category_id)
                    .setString("classification", to_stock_take_items.classification)
                    .setString("classification_id", to_stock_take_items.classification_id)
                    .setString("sub_class", to_stock_take_items.sub_class)
                    .setString("sub_class_id", to_stock_take_items.sub_class_id)
                    .setString("brand", to_stock_take_items.brand)
                    .setString("brand_id", to_stock_take_items.brand_id)
                    .setString("model", to_stock_take_items.model)
                    .setString("model_id", to_stock_take_items.model_id)
                    .setNumber("conversion", to_stock_take_items.conversion)
                    .setString("unit", to_stock_take_items.unit)
                    .setString("barcodes", to_stock_take_items.barcodes)
                    .setString("main_barcode", to_stock_take_items.main_barcode)
                    .setNumber("qty", to_stock_take_items.qty)
                    .setNumber("cost", to_stock_take_items.cost)
                    .setNumber("selling_price", to_stock_take_items.selling_price)
                    .setString("branch", to_stock_take_items.branch)
                    .setString("branch_id", to_stock_take_items.branch_id)
                    .setString("location", to_stock_take_items.location)
                    .setString("location_id", to_stock_take_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_take_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_stock_take_items to_stock_take_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_take_items  "
                    + " where id='" + to_stock_take_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_take_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_take_items> ret_data(String where) {
        List<to_stock_take_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",stock_take_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",conversion"
                    + ",unit"
                    + ",barcodes"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from stock_take_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String stock_take_no = rs.getString(2);
                String user_id = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String date_added = rs.getString(5);
                String remarks = rs.getString(6);
                String barcode = rs.getString(7);
                String description = rs.getString(8);
                String category = rs.getString(9);
                String category_id = rs.getString(10);
                String classification = rs.getString(11);
                String classification_id = rs.getString(12);
                String sub_class = rs.getString(13);
                String sub_class_id = rs.getString(14);
                String brand = rs.getString(15);
                String brand_id = rs.getString(16);
                String model = rs.getString(17);
                String model_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String barcodes = rs.getString(21);
                String main_barcode = rs.getString(22);
                double qty = rs.getDouble(23);
                double cost = rs.getDouble(24);
                double selling_price = rs.getDouble(25);
                String branch = rs.getString(26);
                String branch_id = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);

                to_stock_take_items to = new to_stock_take_items(id, stock_take_no, user_id, user_screen_name, date_added, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, main_barcode, qty, cost, selling_price, branch, branch_id, location, location_id);
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
