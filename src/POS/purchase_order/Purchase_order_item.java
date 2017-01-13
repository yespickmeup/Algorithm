/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

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
public class Purchase_order_item {

    public static class to_purchase_order_items {

        public final int id;
        public final String po_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supplier_id;
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
        public final String batch_no;
        public final String serial_no;
        public final String main_barcode;
        public final double qty_ordered;
        public final double qty_received;
        public final double previous_cost;
        public final double new_cost;
        public final int status;
        public final String date_delivered;
        public final String date_received;
        public final String reference_no;
        public final String receipt_type;
        public final String receipt_type_id;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_purchase_order_items(int id, String po_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String remarks, String barcode, String description, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, String brand, String brand_id, String model, String model_id, double conversion, String unit, String barcodes, String batch_no, String serial_no, String main_barcode, double qty_ordered, double qty_received, double previous_cost, double new_cost, int status, String date_delivered, String date_received, String reference_no, String receipt_type, String receipt_type_id, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.po_no = po_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
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
            this.qty_ordered = qty_ordered;
            this.qty_received = qty_received;
            this.previous_cost = previous_cost;
            this.new_cost = new_cost;
            this.status = status;
            this.date_delivered = date_delivered;
            this.date_received = date_received;
            this.reference_no = reference_no;
            this.receipt_type = receipt_type;
            this.receipt_type_id = receipt_type_id;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_purchase_order_items to_purchase_order_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into purchase_order_items("
                    + "po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",qty_ordered"
                    + ",qty_received"
                    + ",previous_cost"
                    + ",new_cost"
                    + ",status"
                    + ",date_delivered"
                    + ",date_received"
                    + ",reference_no"
                    + ",receipt_type"
                    + ",receipt_type_id"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":po_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
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
                    + ",:qty_ordered"
                    + ",:qty_received"
                    + ",:previous_cost"
                    + ",:new_cost"
                    + ",:status"
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:reference_no"
                    + ",:receipt_type"
                    + ",:receipt_type_id"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("po_no", to_purchase_order_items.po_no)
                    .setString("user_name", to_purchase_order_items.user_name)
                    .setString("session_no", to_purchase_order_items.session_no)
                    .setString("date_added", to_purchase_order_items.date_added)
                    .setString("supplier", to_purchase_order_items.supplier)
                    .setString("supplier_id", to_purchase_order_items.supplier_id)
                    .setString("remarks", to_purchase_order_items.remarks)
                    .setString("barcode", to_purchase_order_items.barcode)
                    .setString("description", to_purchase_order_items.description)
                    .setString("category", to_purchase_order_items.category)
                    .setString("category_id", to_purchase_order_items.category_id)
                    .setString("classification", to_purchase_order_items.classification)
                    .setString("classification_id", to_purchase_order_items.classification_id)
                    .setString("sub_class", to_purchase_order_items.sub_class)
                    .setString("sub_class_id", to_purchase_order_items.sub_class_id)
                    .setString("brand", to_purchase_order_items.brand)
                    .setString("brand_id", to_purchase_order_items.brand_id)
                    .setString("model", to_purchase_order_items.model)
                    .setString("model_id", to_purchase_order_items.model_id)
                    .setNumber("conversion", to_purchase_order_items.conversion)
                    .setString("unit", to_purchase_order_items.unit)
                    .setString("barcodes", to_purchase_order_items.barcodes)
                    .setString("batch_no", to_purchase_order_items.batch_no)
                    .setString("serial_no", to_purchase_order_items.serial_no)
                    .setString("main_barcode", to_purchase_order_items.main_barcode)
                    .setNumber("qty_ordered", to_purchase_order_items.qty_ordered)
                    .setNumber("qty_received", to_purchase_order_items.qty_received)
                    .setNumber("previous_cost", to_purchase_order_items.previous_cost)
                    .setNumber("new_cost", to_purchase_order_items.new_cost)
                    .setNumber("status", to_purchase_order_items.status)
                    .setString("date_delivered", to_purchase_order_items.date_delivered)
                    .setString("date_received", to_purchase_order_items.date_received)
                    .setString("reference_no", to_purchase_order_items.reference_no)
                    .setString("receipt_type", to_purchase_order_items.receipt_type)
                    .setString("receipt_type_id", to_purchase_order_items.receipt_type_id)
                    .setString("branch", to_purchase_order_items.branch)
                    .setString("branch_id", to_purchase_order_items.branch_id)
                    .setString("location", to_purchase_order_items.location)
                    .setString("location_id", to_purchase_order_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Purchase_order_item.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_purchase_order_items to_purchase_order_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update purchase_order_items set "
                    + "po_no= :po_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
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
                    + ",qty_ordered= :qty_ordered "
                    + ",qty_received= :qty_received "
                    + ",previous_cost= :previous_cost "
                    + ",new_cost= :new_cost "
                    + ",status= :status "
                    + ",date_delivered= :date_delivered "
                    + ",date_received= :date_received "
                    + ",reference_no= :reference_no "
                    + ",receipt_type= :receipt_type "
                    + ",receipt_type_id= :receipt_type_id "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_purchase_order_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("po_no", to_purchase_order_items.po_no)
                    .setString("user_name", to_purchase_order_items.user_name)
                    .setString("session_no", to_purchase_order_items.session_no)
                    .setString("date_added", to_purchase_order_items.date_added)
                    .setString("supplier", to_purchase_order_items.supplier)
                    .setString("supplier_id", to_purchase_order_items.supplier_id)
                    .setString("remarks", to_purchase_order_items.remarks)
                    .setString("barcode", to_purchase_order_items.barcode)
                    .setString("description", to_purchase_order_items.description)
                    .setString("category", to_purchase_order_items.category)
                    .setString("category_id", to_purchase_order_items.category_id)
                    .setString("classification", to_purchase_order_items.classification)
                    .setString("classification_id", to_purchase_order_items.classification_id)
                    .setString("sub_class", to_purchase_order_items.sub_class)
                    .setString("sub_class_id", to_purchase_order_items.sub_class_id)
                    .setString("brand", to_purchase_order_items.brand)
                    .setString("brand_id", to_purchase_order_items.brand_id)
                    .setString("model", to_purchase_order_items.model)
                    .setString("model_id", to_purchase_order_items.model_id)
                    .setNumber("conversion", to_purchase_order_items.conversion)
                    .setString("unit", to_purchase_order_items.unit)
                    .setString("barcodes", to_purchase_order_items.barcodes)
                    .setString("batch_no", to_purchase_order_items.batch_no)
                    .setString("serial_no", to_purchase_order_items.serial_no)
                    .setString("main_barcode", to_purchase_order_items.main_barcode)
                    .setNumber("qty_ordered", to_purchase_order_items.qty_ordered)
                    .setNumber("qty_received", to_purchase_order_items.qty_received)
                    .setNumber("previous_cost", to_purchase_order_items.previous_cost)
                    .setNumber("new_cost", to_purchase_order_items.new_cost)
                    .setNumber("status", to_purchase_order_items.status)
                    .setString("date_delivered", to_purchase_order_items.date_delivered)
                    .setString("date_received", to_purchase_order_items.date_received)
                    .setString("reference_no", to_purchase_order_items.reference_no)
                    .setString("receipt_type", to_purchase_order_items.receipt_type)
                    .setString("receipt_type_id", to_purchase_order_items.receipt_type_id)
                    .setString("branch", to_purchase_order_items.branch)
                    .setString("branch_id", to_purchase_order_items.branch_id)
                    .setString("location", to_purchase_order_items.location)
                    .setString("location_id", to_purchase_order_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Purchase_order_item.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_purchase_order_items to_purchase_order_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from purchase_order_items  "
                    + " where id='" + to_purchase_order_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Purchase_order_item.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_purchase_order_items> ret_data(String where) {
        List<to_purchase_order_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",qty_ordered"
                    + ",qty_received"
                    + ",previous_cost"
                    + ",new_cost"
                    + ",status"
                    + ",date_delivered"
                    + ",date_received"
                    + ",reference_no"
                    + ",receipt_type"
                    + ",receipt_type_id"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from purchase_order_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String po_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supplier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                String category = rs.getString(11);
                String category_id = rs.getString(12);
                String classification = rs.getString(13);
                String classification_id = rs.getString(14);
                String sub_class = rs.getString(15);
                String sub_class_id = rs.getString(16);
                String brand = rs.getString(17);
                String brand_id = rs.getString(18);
                String model = rs.getString(19);
                String model_id = rs.getString(20);
                double conversion = rs.getDouble(21);
                String unit = rs.getString(22);
                String barcodes = rs.getString(23);
                String batch_no = rs.getString(24);
                String serial_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                double qty_ordered = rs.getDouble(27);
                double qty_received = rs.getDouble(28);
                double previous_cost = rs.getDouble(29);
                double new_cost = rs.getDouble(30);
                int status = rs.getInt(31);
                String date_delivered = rs.getString(32);
                String date_received = rs.getString(33);
                String reference_no = rs.getString(34);
                String receipt_type = rs.getString(35);
                String receipt_type_id = rs.getString(36);
                String branch = rs.getString(37);
                String branch_id = rs.getString(38);
                String location = rs.getString(39);
                String location_id = rs.getString(40);

                to_purchase_order_items to = new to_purchase_order_items(id, po_no, user_name, session_no, date_added, supplier, supplier_id, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty_ordered, qty_received, previous_cost, new_cost, status, date_delivered, date_received, reference_no, receipt_type, receipt_type_id, branch, branch_id, location, location_id);
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
