/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

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
public class Return_from_customer_items {

    public static class to_return_from_customer_items {

        public final int id;
        public final String return_from_customer_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supplier_id;
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
        public final double conversion;
        public final String unit;
        public final String barcodes;
        public final String batch_no;
        public final String serial_no;
        public final String main_barcode;
        public final double qty;
        public final double cost;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_return_from_customer_items(int id, String return_from_customer_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String reference_no, String remarks, String barcode, String description, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, String brand, String brand_id, String model, String model_id, double conversion, String unit, String barcodes, String batch_no, String serial_no, String main_barcode, double qty, double cost, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.return_from_customer_no = return_from_customer_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
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
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_return_from_customer_items to_return_from_customer_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into return_from_customer_items("
                    + " return_from_customer_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":return_from_customer_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
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
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("return_from_customer_no", to_return_from_customer_items.return_from_customer_no)
                    .setString("user_name", to_return_from_customer_items.user_name)
                    .setString("session_no", to_return_from_customer_items.session_no)
                    .setString("date_added", to_return_from_customer_items.date_added)
                    .setString("supplier", to_return_from_customer_items.supplier)
                    .setString("supplier_id", to_return_from_customer_items.supplier_id)
                    .setString("reference_no", to_return_from_customer_items.reference_no)
                    .setString("remarks", to_return_from_customer_items.remarks)
                    .setString("barcode", to_return_from_customer_items.barcode)
                    .setString("description", to_return_from_customer_items.description)
                    .setString("category", to_return_from_customer_items.category)
                    .setString("category_id", to_return_from_customer_items.category_id)
                    .setString("classification", to_return_from_customer_items.classification)
                    .setString("classification_id", to_return_from_customer_items.classification_id)
                    .setString("sub_class", to_return_from_customer_items.sub_class)
                    .setString("sub_class_id", to_return_from_customer_items.sub_class_id)
                    .setString("brand", to_return_from_customer_items.brand)
                    .setString("brand_id", to_return_from_customer_items.brand_id)
                    .setString("model", to_return_from_customer_items.model)
                    .setString("model_id", to_return_from_customer_items.model_id)
                    .setNumber("conversion", to_return_from_customer_items.conversion)
                    .setString("unit", to_return_from_customer_items.unit)
                    .setString("barcodes", to_return_from_customer_items.barcodes)
                    .setString("batch_no", to_return_from_customer_items.batch_no)
                    .setString("serial_no", to_return_from_customer_items.serial_no)
                    .setString("main_barcode", to_return_from_customer_items.main_barcode)
                    .setNumber("qty", to_return_from_customer_items.qty)
                    .setNumber("cost", to_return_from_customer_items.cost)
                    .setNumber("status", to_return_from_customer_items.status)
                    .setString("branch", to_return_from_customer_items.branch)
                    .setString("branch_id", to_return_from_customer_items.branch_id)
                    .setString("location", to_return_from_customer_items.location)
                    .setString("location_id", to_return_from_customer_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Return_from_customer_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_return_from_customer_items to_return_from_customer_items) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into return_from_customer_items("
                    + " return_from_customer_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":return_from_customer_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
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
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("return_from_customer_no", to_return_from_customer_items.return_from_customer_no)
                    .setString("user_name", to_return_from_customer_items.user_name)
                    .setString("session_no", to_return_from_customer_items.session_no)
                    .setString("date_added", to_return_from_customer_items.date_added)
                    .setString("supplier", to_return_from_customer_items.supplier)
                    .setString("supplier_id", to_return_from_customer_items.supplier_id)
                    .setString("reference_no", to_return_from_customer_items.reference_no)
                    .setString("remarks", to_return_from_customer_items.remarks)
                    .setString("barcode", to_return_from_customer_items.barcode)
                    .setString("description", to_return_from_customer_items.description)
                    .setString("category", to_return_from_customer_items.category)
                    .setString("category_id", to_return_from_customer_items.category_id)
                    .setString("classification", to_return_from_customer_items.classification)
                    .setString("classification_id", to_return_from_customer_items.classification_id)
                    .setString("sub_class", to_return_from_customer_items.sub_class)
                    .setString("sub_class_id", to_return_from_customer_items.sub_class_id)
                    .setString("brand", to_return_from_customer_items.brand)
                    .setString("brand_id", to_return_from_customer_items.brand_id)
                    .setString("model", to_return_from_customer_items.model)
                    .setString("model_id", to_return_from_customer_items.model_id)
                    .setNumber("conversion", to_return_from_customer_items.conversion)
                    .setString("unit", to_return_from_customer_items.unit)
                    .setString("barcodes", to_return_from_customer_items.barcodes)
                    .setString("batch_no", to_return_from_customer_items.batch_no)
                    .setString("serial_no", to_return_from_customer_items.serial_no)
                    .setString("main_barcode", to_return_from_customer_items.main_barcode)
                    .setNumber("qty", to_return_from_customer_items.qty)
                    .setNumber("cost", to_return_from_customer_items.cost)
                    .setNumber("status", to_return_from_customer_items.status)
                    .setString("branch", to_return_from_customer_items.branch)
                    .setString("branch_id", to_return_from_customer_items.branch_id)
                    .setString("location", to_return_from_customer_items.location)
                    .setString("location_id", to_return_from_customer_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update return_from_customer_items set is_uploaded=1 where id='" + to_return_from_customer_items.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Return_from_customer_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_return_from_customer_items to_return_from_customer_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update return_from_customer_items set "
                    + " return_from_customer_no= :return_from_customer_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
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
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_return_from_customer_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("return_from_customer_no", to_return_from_customer_items.return_from_customer_no)
                    .setString("user_name", to_return_from_customer_items.user_name)
                    .setString("session_no", to_return_from_customer_items.session_no)
                    .setString("date_added", to_return_from_customer_items.date_added)
                    .setString("supplier", to_return_from_customer_items.supplier)
                    .setString("supplier_id", to_return_from_customer_items.supplier_id)
                    .setString("reference_no", to_return_from_customer_items.reference_no)
                    .setString("remarks", to_return_from_customer_items.remarks)
                    .setString("barcode", to_return_from_customer_items.barcode)
                    .setString("description", to_return_from_customer_items.description)
                    .setString("category", to_return_from_customer_items.category)
                    .setString("category_id", to_return_from_customer_items.category_id)
                    .setString("classification", to_return_from_customer_items.classification)
                    .setString("classification_id", to_return_from_customer_items.classification_id)
                    .setString("sub_class", to_return_from_customer_items.sub_class)
                    .setString("sub_class_id", to_return_from_customer_items.sub_class_id)
                    .setString("brand", to_return_from_customer_items.brand)
                    .setString("brand_id", to_return_from_customer_items.brand_id)
                    .setString("model", to_return_from_customer_items.model)
                    .setString("model_id", to_return_from_customer_items.model_id)
                    .setNumber("conversion", to_return_from_customer_items.conversion)
                    .setString("unit", to_return_from_customer_items.unit)
                    .setString("barcodes", to_return_from_customer_items.barcodes)
                    .setString("batch_no", to_return_from_customer_items.batch_no)
                    .setString("serial_no", to_return_from_customer_items.serial_no)
                    .setString("main_barcode", to_return_from_customer_items.main_barcode)
                    .setNumber("qty", to_return_from_customer_items.qty)
                    .setNumber("cost", to_return_from_customer_items.cost)
                    .setNumber("status", to_return_from_customer_items.status)
                    .setString("branch", to_return_from_customer_items.branch)
                    .setString("branch_id", to_return_from_customer_items.branch_id)
                    .setString("location", to_return_from_customer_items.location)
                    .setString("location_id", to_return_from_customer_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Return_from_customer_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize(to_return_from_customer_items to_return_from_customer_items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update return_from_customer_items set "
                    + "status= :status "
                    + " where id='" + to_return_from_customer_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

//            Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_return_from_customer_items.main_barcode, to_return_from_customer_items.barcode, to_return_from_customer_items.location_id);
            String s10 = "select "
                    + " product_qty"
                    + ",conversion"
                    + ",serial_no"
                    + " from inventory_barcodes where "
                    + " main_barcode='" + to_return_from_customer_items.main_barcode + "' and location_id='" + to_return_from_customer_items.location_id + "'"
                    + " ";
            Statement stmt10 = conn.createStatement();
            ResultSet rs10 = stmt10.executeQuery(s10);
            double product_qty = 0;
            double conversion = 0;
            String serial_no = "";
            while (rs10.next()) {
                product_qty = rs10.getDouble(1);
                conversion = rs10.getDouble(2);
                serial_no = rs10.getString(3);
            }

            double new_qty = product_qty + (to_return_from_customer_items.conversion * to_return_from_customer_items.qty);

            String s4 = "update inventory_barcodes set "
                    + " product_qty='" + new_qty + "'"
                    + " where  main_barcode= '" + to_return_from_customer_items.main_barcode + "' and location_id='" + to_return_from_customer_items.location_id + "' "
                    + "";
            stmt.addBatch(s4);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Return_from_customer_items.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_return_from_customer_items to_return_from_customer_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from return_from_customer_items  "
                    + " where id='" + to_return_from_customer_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Return_from_customer_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_return_from_customer_items> ret_data(String where) {
        List<to_return_from_customer_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",return_from_customer_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from return_from_customer_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String return_to_supplier_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supplier_id = rs.getString(7);
                String reference_no = rs.getString(8);
                String remarks = rs.getString(9);
                String barcode = rs.getString(10);
                String description = rs.getString(11);
                String category = rs.getString(12);
                String category_id = rs.getString(13);
                String classification = rs.getString(14);
                String classification_id = rs.getString(15);
                String sub_class = rs.getString(16);
                String sub_class_id = rs.getString(17);
                String brand = rs.getString(18);
                String brand_id = rs.getString(19);
                String model = rs.getString(20);
                String model_id = rs.getString(21);
                double conversion = rs.getDouble(22);
                String unit = rs.getString(23);
                String barcodes = rs.getString(24);
                String batch_no = rs.getString(25);
                String serial_no = rs.getString(26);
                String main_barcode = rs.getString(27);
                double qty = rs.getDouble(28);
                double cost = rs.getDouble(29);
                int status = rs.getInt(30);
                String branch = rs.getString(31);
                String branch_id = rs.getString(32);
                String location = rs.getString(33);
                String location_id = rs.getString(34);

                to_return_from_customer_items to = new to_return_from_customer_items(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, branch, branch_id, location, location_id);
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
