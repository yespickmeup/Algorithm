/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

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
 * @author User
 */
public class Warranty_items {

    public static class to_warranty_items {

        public final int id;
        public final String transaction_no;
        public final String remarks;
        public final String trans_type;
        public final String supplier;
        public final String supplier_id;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double cost;
        public final double selling_price;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        public final double conversion;
        public final String unit;
        public final String warranty_date;
        public final String serial_no;
        public final String main_barcode;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int status;
        public final String created_at;
        public final String created_by;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_warranty_items(int id, String transaction_no, String remarks, String trans_type, String supplier, String supplier_id, String barcode, String description, double qty, double cost, double selling_price, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, double conversion, String unit, String warranty_date, String serial_no, String main_barcode, String brand, String brand_id, String model, String model_id, int status, String created_at, String created_by, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.transaction_no = transaction_no;
            this.remarks = remarks;
            this.trans_type = trans_type;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.selling_price = selling_price;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
            this.conversion = conversion;
            this.unit = unit;
            this.warranty_date = warranty_date;
            this.serial_no = serial_no;
            this.main_barcode = main_barcode;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.status = status;
            this.created_at = created_at;
            this.created_by = created_by;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_warranty_items to_warranty_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into warranty_items("
                    + "transaction_no"
                    + ",remarks"
                    + ",trans_type"
                    + ",supplier"
                    + ",supplier_id"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",warranty_date"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",status"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":transaction_no"
                    + ",:remarks"
                    + ",:trans_type"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:barcode"
                    + ",:description"
                    + ",:qty"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:category"
                    + ",:category_id"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:sub_class"
                    + ",:sub_class_id"
                    + ",:conversion"
                    + ",:unit"
                    + ",:warranty_date"
                    + ",:serial_no"
                    + ",:main_barcode"
                    + ",:brand"
                    + ",:brand_id"
                    + ",:model"
                    + ",:model_id"
                    + ",:status"
                    + ",:created_at"
                    + ",:created_by"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_warranty_items.transaction_no)
                    .setString("remarks", to_warranty_items.remarks)
                    .setString("trans_type", to_warranty_items.trans_type)
                    .setString("supplier", to_warranty_items.supplier)
                    .setString("supplier_id", to_warranty_items.supplier_id)
                    .setString("barcode", to_warranty_items.barcode)
                    .setString("description", to_warranty_items.description)
                    .setNumber("qty", to_warranty_items.qty)
                    .setNumber("cost", to_warranty_items.cost)
                    .setNumber("selling_price", to_warranty_items.selling_price)
                    .setString("category", to_warranty_items.category)
                    .setString("category_id", to_warranty_items.category_id)
                    .setString("classification", to_warranty_items.classification)
                    .setString("classification_id", to_warranty_items.classification_id)
                    .setString("sub_class", to_warranty_items.sub_class)
                    .setString("sub_class_id", to_warranty_items.sub_class_id)
                    .setNumber("conversion", to_warranty_items.conversion)
                    .setString("unit", to_warranty_items.unit)
                    .setString("warranty_date", to_warranty_items.warranty_date)
                    .setString("serial_no", to_warranty_items.serial_no)
                    .setString("main_barcode", to_warranty_items.main_barcode)
                    .setString("brand", to_warranty_items.brand)
                    .setString("brand_id", to_warranty_items.brand_id)
                    .setString("model", to_warranty_items.model)
                    .setString("model_id", to_warranty_items.model_id)
                    .setNumber("status", to_warranty_items.status)
                    .setString("created_at", to_warranty_items.created_at)
                    .setString("created_by", to_warranty_items.created_by)
                    .setString("branch", to_warranty_items.branch)
                    .setString("branch_id", to_warranty_items.branch_id)
                    .setString("location", to_warranty_items.location)
                    .setString("location_id", to_warranty_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Warranty_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_warranty_items to_warranty_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update warranty_items set "
                    + "transaction_no= :transaction_no "
                    + ",remarks= :remarks "
                    + ",trans_type= :trans_type "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",qty= :qty "
                    + ",cost= :cost "
                    + ",selling_price= :selling_price "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_class= :sub_class "
                    + ",sub_class_id= :sub_class_id "
                    + ",conversion= :conversion "
                    + ",unit= :unit "
                    + ",warranty_date= :warranty_date "
                    + ",serial_no= :serial_no "
                    + ",main_barcode= :main_barcode "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",status= :status "
                    + ",created_at= :created_at "
                    + ",created_by= :created_by "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_warranty_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_warranty_items.transaction_no)
                    .setString("remarks", to_warranty_items.remarks)
                    .setString("trans_type", to_warranty_items.trans_type)
                    .setString("supplier", to_warranty_items.supplier)
                    .setString("supplier_id", to_warranty_items.supplier_id)
                    .setString("barcode", to_warranty_items.barcode)
                    .setString("description", to_warranty_items.description)
                    .setNumber("qty", to_warranty_items.qty)
                    .setNumber("cost", to_warranty_items.cost)
                    .setNumber("selling_price", to_warranty_items.selling_price)
                    .setString("category", to_warranty_items.category)
                    .setString("category_id", to_warranty_items.category_id)
                    .setString("classification", to_warranty_items.classification)
                    .setString("classification_id", to_warranty_items.classification_id)
                    .setString("sub_class", to_warranty_items.sub_class)
                    .setString("sub_class_id", to_warranty_items.sub_class_id)
                    .setNumber("conversion", to_warranty_items.conversion)
                    .setString("unit", to_warranty_items.unit)
                    .setString("warranty_date", to_warranty_items.warranty_date)
                    .setString("serial_no", to_warranty_items.serial_no)
                    .setString("main_barcode", to_warranty_items.main_barcode)
                    .setString("brand", to_warranty_items.brand)
                    .setString("brand_id", to_warranty_items.brand_id)
                    .setString("model", to_warranty_items.model)
                    .setString("model_id", to_warranty_items.model_id)
                    .setNumber("status", to_warranty_items.status)
                    .setString("created_at", to_warranty_items.created_at)
                    .setString("created_by", to_warranty_items.created_by)
                    .setString("branch", to_warranty_items.branch)
                    .setString("branch_id", to_warranty_items.branch_id)
                    .setString("location", to_warranty_items.location)
                    .setString("location_id", to_warranty_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Warranty_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_status(to_warranty_items to_warranty_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update warranty_items set "
                    + " status= :status "
                    + " where id='" + to_warranty_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Warranty_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_warranty_items to_warranty_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from warranty_items  "
                    + " where id='" + to_warranty_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Warranty_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_warranty_items> ret_data(String where) {
        List<to_warranty_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",remarks"
                    + ",trans_type"
                    + ",supplier"
                    + ",supplier_id"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",warranty_date"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",status"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from warranty_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String remarks = rs.getString(3);
                String trans_type = rs.getString(4);
                String supplier = rs.getString(5);
                String supplier_id = rs.getString(6);
                String barcode = rs.getString(7);
                String description = rs.getString(8);
                double qty = rs.getDouble(9);
                double cost = rs.getDouble(10);
                double selling_price = rs.getDouble(11);
                String category = rs.getString(12);
                String category_id = rs.getString(13);
                String classification = rs.getString(14);
                String classification_id = rs.getString(15);
                String sub_class = rs.getString(16);
                String sub_class_id = rs.getString(17);
                double conversion = rs.getDouble(18);
                String unit = rs.getString(19);
                String warranty_date = rs.getString(20);
                String serial_no = rs.getString(21);
                String main_barcode = rs.getString(22);
                String brand = rs.getString(23);
                String brand_id = rs.getString(24);
                String model = rs.getString(25);
                String model_id = rs.getString(26);
                int status = rs.getInt(27);
                String created_at = rs.getString(28);
                String created_by = rs.getString(29);
                String branch = rs.getString(30);
                String branch_id = rs.getString(31);
                String location = rs.getString(32);
                String location_id = rs.getString(33);

                to_warranty_items to = new to_warranty_items(id, transaction_no, remarks, trans_type, supplier, supplier_id, barcode, description, qty, cost, selling_price, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, warranty_date, serial_no, main_barcode, brand, brand_id, model, model_id, status, created_at, created_by, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from warranty_items";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select transaction_no from warranty_items where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000";
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
