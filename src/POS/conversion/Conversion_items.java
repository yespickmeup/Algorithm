/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.conversion;

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
public class Conversion_items {

    public static class to_conversion_items {

        public final int id;
        public final String conversion_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String reference_no;
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
        public double conversion;
        public String unit;
        public final String barcodes;
        public final String batch_no;
        public final String serial_no;
        public final String main_barcode;
        public double qty;
        public double cost;
        public final int status;
        public final String from_branch;
        public final String from_branch_id;
        public final String from_location;
        public final String from_location_id;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public int is_converted_from;

        public to_conversion_items(int id, String conversion_no, String user_name, String session_no, String date_added, String reference_no, String remarks, String barcode, String description, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, String brand, String brand_id, String model, String model_id, double conversion, String unit, String barcodes, String batch_no, String serial_no, String main_barcode, double qty, double cost, int status, String from_branch, String from_branch_id, String from_location, String from_location_id, String to_branch, String to_branch_id, String to_location, String to_location_id, int is_converted_from) {
            this.id = id;
            this.conversion_no = conversion_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.reference_no = reference_no;
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
            this.batch_no = batch_no;
            this.serial_no = serial_no;
            this.main_barcode = main_barcode;
            this.qty = qty;
            this.cost = cost;
            this.status = status;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.is_converted_from = is_converted_from;
        }

        public int getIs_converted_from() {
            return is_converted_from;
        }

        public void setIs_converted_from(int is_converted_from) {
            this.is_converted_from = is_converted_from;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

    }

    public static void add_data(to_conversion_items to_conversion_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into conversion_items("
                    + "conversion_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",reference_no"
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
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",is_converted_from"
                    + ")values("
                    + ":conversion_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:reference_no"
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
                    + ",:batch_no"
                    + ",:serial_no"
                    + ",:main_barcode"
                    + ",:qty"
                    + ",:cost"
                    + ",:status"
                    + ",:from_branch"
                    + ",:from_branch_id"
                    + ",:from_location"
                    + ",:from_location_id"
                    + ",:to_branch"
                    + ",:to_branch_id"
                    + ",:to_location"
                    + ",:to_location_id"
                    + ",:is_converted_from"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("conversion_no", to_conversion_items.conversion_no)
                    .setString("user_name", to_conversion_items.user_name)
                    .setString("session_no", to_conversion_items.session_no)
                    .setString("date_added", to_conversion_items.date_added)
                    .setString("reference_no", to_conversion_items.reference_no)
                    .setString("remarks", to_conversion_items.remarks)
                    .setString("barcode", to_conversion_items.barcode)
                    .setString("description", to_conversion_items.description)
                    .setString("category", to_conversion_items.category)
                    .setString("category_id", to_conversion_items.category_id)
                    .setString("classification", to_conversion_items.classification)
                    .setString("classification_id", to_conversion_items.classification_id)
                    .setString("sub_class", to_conversion_items.sub_class)
                    .setString("sub_class_id", to_conversion_items.sub_class_id)
                    .setString("brand", to_conversion_items.brand)
                    .setString("brand_id", to_conversion_items.brand_id)
                    .setString("model", to_conversion_items.model)
                    .setString("model_id", to_conversion_items.model_id)
                    .setNumber("conversion", to_conversion_items.conversion)
                    .setString("unit", to_conversion_items.unit)
                    .setString("barcodes", to_conversion_items.barcodes)
                    .setString("batch_no", to_conversion_items.batch_no)
                    .setString("serial_no", to_conversion_items.serial_no)
                    .setString("main_barcode", to_conversion_items.main_barcode)
                    .setNumber("qty", to_conversion_items.qty)
                    .setNumber("cost", to_conversion_items.cost)
                    .setNumber("status", to_conversion_items.status)
                    .setString("from_branch", to_conversion_items.from_branch)
                    .setString("from_branch_id", to_conversion_items.from_branch_id)
                    .setString("from_location", to_conversion_items.from_location)
                    .setString("from_location_id", to_conversion_items.from_location_id)
                    .setString("to_branch", to_conversion_items.to_branch)
                    .setString("to_branch_id", to_conversion_items.to_branch_id)
                    .setString("to_location", to_conversion_items.to_location)
                    .setString("to_location_id", to_conversion_items.to_location_id)
                    .setNumber("is_converted_from", to_conversion_items.is_converted_from)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Conversion_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_conversion_items to_conversion_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update conversion_items set "
                    + "conversion_no= :conversion_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",reference_no= :reference_no "
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
                    + ",batch_no= :batch_no "
                    + ",serial_no= :serial_no "
                    + ",main_barcode= :main_barcode "
                    + ",qty= :qty "
                    + ",cost= :cost "
                    + ",status= :status "
                    + ",from_branch= :from_branch "
                    + ",from_branch_id= :from_branch_id "
                    + ",from_location= :from_location "
                    + ",from_location_id= :from_location_id "
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + ",is_converted_from= :is_converted_from"
                    + " where id='" + to_conversion_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("conversion_no", to_conversion_items.conversion_no)
                    .setString("user_name", to_conversion_items.user_name)
                    .setString("session_no", to_conversion_items.session_no)
                    .setString("date_added", to_conversion_items.date_added)
                    .setString("reference_no", to_conversion_items.reference_no)
                    .setString("remarks", to_conversion_items.remarks)
                    .setString("barcode", to_conversion_items.barcode)
                    .setString("description", to_conversion_items.description)
                    .setString("category", to_conversion_items.category)
                    .setString("category_id", to_conversion_items.category_id)
                    .setString("classification", to_conversion_items.classification)
                    .setString("classification_id", to_conversion_items.classification_id)
                    .setString("sub_class", to_conversion_items.sub_class)
                    .setString("sub_class_id", to_conversion_items.sub_class_id)
                    .setString("brand", to_conversion_items.brand)
                    .setString("brand_id", to_conversion_items.brand_id)
                    .setString("model", to_conversion_items.model)
                    .setString("model_id", to_conversion_items.model_id)
                    .setNumber("conversion", to_conversion_items.conversion)
                    .setString("unit", to_conversion_items.unit)
                    .setString("barcodes", to_conversion_items.barcodes)
                    .setString("batch_no", to_conversion_items.batch_no)
                    .setString("serial_no", to_conversion_items.serial_no)
                    .setString("main_barcode", to_conversion_items.main_barcode)
                    .setNumber("qty", to_conversion_items.qty)
                    .setNumber("cost", to_conversion_items.cost)
                    .setNumber("status", to_conversion_items.status)
                    .setString("from_branch", to_conversion_items.from_branch)
                    .setString("from_branch_id", to_conversion_items.from_branch_id)
                    .setString("from_location", to_conversion_items.from_location)
                    .setString("from_location_id", to_conversion_items.from_location_id)
                    .setString("to_branch", to_conversion_items.to_branch)
                    .setString("to_branch_id", to_conversion_items.to_branch_id)
                    .setString("to_location", to_conversion_items.to_location)
                    .setString("to_location_id", to_conversion_items.to_location_id)
                    .setNumber("is_converted_from", to_conversion_items.is_converted_from)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Conversion_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_unit(to_conversion_items to_conversion_items,double conversion, String unit,double qty,double cost) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update conversion_items set "
                    + " conversion= :conversion "
                    + ",unit= :unit "
                    + ",qty= :qty "
                    + ",cost= :cost "
                    + " where id='" + to_conversion_items.id + "' "
                    + " ";
            
            s0 = SqlStringUtil.parse(s0)
                    .setNumber("conversion", conversion)
                    .setString("unit", unit)
                    .setNumber("qty", qty)
                    .setNumber("cost", cost)
                    .ok();
           
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Conversion_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_conversion_items to_conversion_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from conversion_items  "
                    + " where id='" + to_conversion_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Conversion_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_conversion_items> ret_data(String where) {
        List<to_conversion_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",conversion_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",reference_no"
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
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",is_converted_from"
                    + " from conversion_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String conversion_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String reference_no = rs.getString(6);
                String remarks = rs.getString(7);
                String barcode = rs.getString(8);
                String description = rs.getString(9);
                String category = rs.getString(10);
                String category_id = rs.getString(11);
                String classification = rs.getString(12);
                String classification_id = rs.getString(13);
                String sub_class = rs.getString(14);
                String sub_class_id = rs.getString(15);
                String brand = rs.getString(16);
                String brand_id = rs.getString(17);
                String model = rs.getString(18);
                String model_id = rs.getString(19);
                double conversion = rs.getDouble(20);
                String unit = rs.getString(21);
                String barcodes = rs.getString(22);
                String batch_no = rs.getString(23);
                String serial_no = rs.getString(24);
                String main_barcode = rs.getString(25);
                double qty = rs.getDouble(26);
                double cost = rs.getDouble(27);
                int status = rs.getInt(28);
                String from_branch = rs.getString(29);
                String from_branch_id = rs.getString(30);
                String from_location = rs.getString(31);
                String from_location_id = rs.getString(32);
                String to_branch = rs.getString(33);
                String to_branch_id = rs.getString(34);
                String to_location = rs.getString(35);
                String to_location_id = rs.getString(36);
                int is_converted_from = rs.getInt(37);
                to_conversion_items to = new to_conversion_items(id, conversion_no, user_name, session_no, date_added, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, is_converted_from);
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
