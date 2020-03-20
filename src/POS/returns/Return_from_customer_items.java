/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

import POS.accounts_receivable.S1_accounts_receivable_payments;
import POS.users.MyUser;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
        public final double cash;
        public final String prepaid_customer_name;
        public final String prepaid_customer_id;
        public final double prepaid_amount;
        public final String charge_reference_no;
        public final String charge_ar_no;
        public final String charge_type;
        public final String charge_customer_name;
        public final String charge_customer_id;
        public final double charge_amount;
        public final int charge_days;
        public final double selling_price;
        public to_return_from_customer_items(int id, String return_from_customer_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String reference_no, String remarks, String barcode, String description, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, String brand, String brand_id, String model, String model_id, double conversion, String unit, String barcodes, String batch_no, String serial_no, String main_barcode, double qty, double cost, int status, String branch, String branch_id, String location, String location_id, double cash, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String charge_reference_no, String charge_ar_no, String charge_type, String charge_customer_name, String charge_customer_id, double charge_amount, int charge_days,double selling_price) {
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
            this.cash = cash;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.charge_reference_no = charge_reference_no;
            this.charge_ar_no = charge_ar_no;
            this.charge_type = charge_type;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.charge_days = charge_days;
            this.selling_price=selling_price;
        }
    }

    public static void add_data(to_return_from_customer_items to_return_from_customer_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into return_from_customer_items("
                    + "return_from_customer_no"
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
                    + ",cash"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
                    + ",selling_price"
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
                    + ",:cash"
                    + ",:prepaid_customer_name"
                    + ",:prepaid_customer_id"
                    + ",:prepaid_amount"
                    + ",:charge_reference_no"
                    + ",:charge_ar_no"
                    + ",:charge_type"
                    + ",:charge_customer_name"
                    + ",:charge_customer_id"
                    + ",:charge_amount"
                    + ",:charge_days"
                    + ",:selling_price"
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
                    .setNumber("cash", to_return_from_customer_items.cash)
                    .setString("prepaid_customer_name", to_return_from_customer_items.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_return_from_customer_items.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_return_from_customer_items.prepaid_amount)
                    .setString("charge_reference_no", to_return_from_customer_items.charge_reference_no)
                    .setString("charge_ar_no", to_return_from_customer_items.charge_ar_no)
                    .setString("charge_type", to_return_from_customer_items.charge_type)
                    .setString("charge_customer_name", to_return_from_customer_items.charge_customer_name)
                    .setString("charge_customer_id", to_return_from_customer_items.charge_customer_id)
                    .setNumber("charge_amount", to_return_from_customer_items.charge_amount)
                    .setNumber("charge_days", to_return_from_customer_items.charge_days)
                    .setNumber("selling_price",to_return_from_customer_items.selling_price)
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
                    + "return_from_customer_no"
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
                    + ",cash"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
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
                    + ",:cash"
                    + ",:prepaid_customer_name"
                    + ",:prepaid_customer_id"
                    + ",:prepaid_amount"
                    + ",:charge_reference_no"
                    + ",:charge_ar_no"
                    + ",:charge_type"
                    + ",:charge_customer_name"
                    + ",:charge_customer_id"
                    + ",:charge_amount"
                    + ",:charge_days"
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
                    .setNumber("cash", to_return_from_customer_items.cash)
                    .setString("prepaid_customer_name", to_return_from_customer_items.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_return_from_customer_items.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_return_from_customer_items.prepaid_amount)
                    .setString("charge_reference_no", to_return_from_customer_items.charge_reference_no)
                    .setString("charge_ar_no", to_return_from_customer_items.charge_ar_no)
                    .setString("charge_type", to_return_from_customer_items.charge_type)
                    .setString("charge_customer_name", to_return_from_customer_items.charge_customer_name)
                    .setString("charge_customer_id", to_return_from_customer_items.charge_customer_id)
                    .setNumber("charge_amount", to_return_from_customer_items.charge_amount)
                    .setNumber("charge_days", to_return_from_customer_items.charge_days)
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
                    + ",selling_price= :selling_price"
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
                    .setNumber("selling_price",to_return_from_customer_items.selling_price)
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

            if (to_return_from_customer_items.prepaid_amount > 0) {
                String prep = "select "
                        + "id"
                        + ",customer_name"
                        + ",customer_no"
                        + ",contact_no"
                        + ",credit_limit"
                        + ",address"
                        + ",term"
                        + ",location"
                        + ",balance"
                        + ",discount"
                        + ",prepaid"
                        + " from customers "
                        + " where id='" + to_return_from_customer_items.prepaid_customer_id + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs = stmt2.executeQuery(prep);
                double prepaid = 0;
                if (rs.next()) {
                    prepaid = rs.getDouble(11);
                }
                prepaid = prepaid + to_return_from_customer_items.prepaid_amount;
                String s3 = " update customers set prepaid='" + prepaid + "' "
                        + " where id='" + to_return_from_customer_items.prepaid_customer_id + "' "
                        + " ";

                s3 = SqlStringUtil.parse(s3)
                        .ok();
                stmt.addBatch(s3);
            }

            if (to_return_from_customer_items.charge_amount > 0) {
                String customer_id = to_return_from_customer_items.charge_customer_id;
                String customer_name = to_return_from_customer_items.charge_customer_name;
                String ar_no = to_return_from_customer_items.charge_ar_no;
                String date_added = DateType.datetime.format(new Date());
                String user_name = MyUser.getUser_id();
                double amount = to_return_from_customer_items.cash;
                double discount_amount = 0;
                double discount_rate = 0;
                String discount = "";
                int status = 1;
                double term = to_return_from_customer_items.charge_days;
                String date_applied = DateType.datetime.format(new Date());
                double paid = 0;
                String date_paid = DateType.sf.format(new Date());
                String remarks = to_return_from_customer_items.remarks;
                String type = "";
                String or_no = "";
                double prev_balance = 0;
                double check_amount = 0;
                String check_holder = "";
                String check_bank = "";
                String check_no = "";
                String ci_no = "";
                String trust_receipt = "";
                String or_payment_no = "";
                String soa_id = "";
                String soa_type = to_return_from_customer_items.charge_type;
                String soa_type_id = "";
                String reference_no = to_return_from_customer_items.charge_reference_no;
                String check_date = date_paid;
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                double tax_rate = 0;
                double tax_amount = 0;

                String branch = to_return_from_customer_items.branch;
                String branch_id = to_return_from_customer_items.branch_id;
                String location = to_return_from_customer_items.location;
                String location_id = to_return_from_customer_items.location_id;

                double total_amount = to_return_from_customer_items.qty * to_return_from_customer_items.cost;

                String prepaid_customer_name = to_return_from_customer_items.prepaid_customer_name;
                String prepaid_customer_id = to_return_from_customer_items.prepaid_customer_id;
                double prepaid_amount = to_return_from_customer_items.prepaid_amount;
                String credit_card_type = "";
                double credit_card_rate = 0;
                String credit_card_no = "";
                String credit_card_holder = "";
                double credit_card_amount = 0;
                String gift_certificate_from = "";
                String gift_certificate_description = "";
                String gift_certificate_no = "";
                double gift_certificate_amount = 0;
                String online_bank = "";
                String online_reference_no = "";
                String online_holder = "";
                String online_date = DateType.now();
                double online_amount = 0;
                double actual_amount = (amount + check_amount) - discount_amount;
                double retention = 0;
                double business_tax = 0;
                double salary_deduction = 0;
                S1_accounts_receivable_payments.to_accounts_receivable_payments to_accounts_receivable_payments = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                        status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid,
                        date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id,
                        soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location,
                        location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no,
                        credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount,
                        online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount, retention, business_tax, salary_deduction);
                //<editor-fold defaultstate="collapsed" desc=" insert ar payment ">
                String s5 = "insert into  accounts_receivable_payments("
                        + "customer_id"
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
                        + ",prev_balance"
                        + ",check_amount"
                        + ",check_holder"
                        + ",check_bank"
                        + ",check_no"
                        + ",ci_no"
                        + ",trust_receipt"
                        + ",or_payment_no"
                        + ",soa_id"
                        + ",soa_type"
                        + ",soa_type_id"
                        + ",reference_no"
                        + ",check_date"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",tax_rate"
                        + ",tax_amount"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",prepaid_customer_name"
                        + ",prepaid_customer_id"
                        + ",prepaid_amount"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_amount"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",gift_certificate_amount"
                        + ",online_bank"
                        + ",online_reference_no"
                        + ",online_holder"
                        + ",online_date"
                        + ",online_amount"
                        + ",actual_amount"
                        + ",salary_deduction"
                        + ")values("
                        + ":customer_id"
                        + ",:customer_name"
                        + ",:ar_no"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:amount"
                        + ",:discount_amount"
                        + ",:discount_rate"
                        + ",:discount"
                        + ",:status"
                        + ",:term"
                        + ",:date_applied"
                        + ",:paid"
                        + ",:date_paid"
                        + ",:remarks"
                        + ",:type"
                        + ",:or_no"
                        + ",:prev_balance"
                        + ",:check_amount"
                        + ",:check_holder"
                        + ",:check_bank"
                        + ",:check_no"
                        + ",:ci_no"
                        + ",:trust_receipt"
                        + ",:or_payment_no"
                        + ",:soa_id"
                        + ",:soa_type"
                        + ",:soa_type_id"
                        + ",:reference_no"
                        + ",:check_date"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:tax_rate"
                        + ",:tax_amount"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:prepaid_customer_name"
                        + ",:prepaid_customer_id"
                        + ",:prepaid_amount"
                        + ",:credit_card_type"
                        + ",:credit_card_rate"
                        + ",:credit_card_no"
                        + ",:credit_card_holder"
                        + ",:credit_card_amount"
                        + ",:gift_certificate_from"
                        + ",:gift_certificate_description"
                        + ",:gift_certificate_no"
                        + ",:gift_certificate_amount"
                        + ",:online_bank"
                        + ",:online_reference_no"
                        + ",:online_holder"
                        + ",:online_date"
                        + ",:online_amount"
                        + ",:actual_amount"
                        + ",:salary_deduction"
                        + ")";

                s5 = SqlStringUtil.parse(s5).
                        setString("customer_id", to_accounts_receivable_payments.customer_id).
                        setString("customer_name", to_accounts_receivable_payments.customer_name).
                        setString("ar_no", to_accounts_receivable_payments.ar_no).
                        setString("date_added", to_accounts_receivable_payments.date_added).
                        setString("user_name", to_accounts_receivable_payments.user_name).
                        setNumber("amount", to_accounts_receivable_payments.amount).
                        setNumber("discount_amount", to_accounts_receivable_payments.discount_amount).
                        setNumber("discount_rate", to_accounts_receivable_payments.discount_rate).
                        setString("discount", to_accounts_receivable_payments.discount).
                        setNumber("status", to_accounts_receivable_payments.status).
                        setNumber("term", to_accounts_receivable_payments.term).
                        setString("date_applied", to_accounts_receivable_payments.date_applied).
                        setNumber("paid", to_accounts_receivable_payments.paid).
                        setString("date_paid", to_accounts_receivable_payments.date_paid).
                        setString("remarks", to_accounts_receivable_payments.remarks).
                        setString("type", to_accounts_receivable_payments.type).
                        setString("or_no", to_accounts_receivable_payments.or_no).
                        setNumber("prev_balance", to_accounts_receivable_payments.prev_balance).
                        setNumber("check_amount", to_accounts_receivable_payments.check_amount).
                        setString("check_holder", to_accounts_receivable_payments.check_holder).
                        setString("check_bank", to_accounts_receivable_payments.check_bank).
                        setString("check_no", to_accounts_receivable_payments.check_no).
                        setString("ci_no", to_accounts_receivable_payments.ci_no).
                        setString("trust_receipt", to_accounts_receivable_payments.trust_receipt).
                        setString("or_payment_no", to_accounts_receivable_payments.or_payment_no).
                        setString("soa_id", to_accounts_receivable_payments.soa_id).
                        setString("soa_type", to_accounts_receivable_payments.soa_type).
                        setString("soa_type_id", to_accounts_receivable_payments.soa_type_id).
                        setString("reference_no", to_accounts_receivable_payments.reference_no).
                        setString("check_date", to_accounts_receivable_payments.check_date).
                        setString("user_id", to_accounts_receivable_payments.user_id).
                        setString("user_screen_name", to_accounts_receivable_payments.user_screen_name).
                        setNumber("tax_rate", to_accounts_receivable_payments.tax_rate).
                        setNumber("tax_amount", to_accounts_receivable_payments.tax_amount).
                        setString("branch", to_accounts_receivable_payments.branch).
                        setString("branch_id", to_accounts_receivable_payments.branch_id).
                        setString("location", to_accounts_receivable_payments.location).
                        setString("location_id", to_accounts_receivable_payments.location_id)
                        .setString("prepaid_customer_name", to_accounts_receivable_payments.prepaid_customer_name)
                        .setString("prepaid_customer_id", to_accounts_receivable_payments.prepaid_customer_id)
                        .setNumber("prepaid_amount", to_accounts_receivable_payments.prepaid_amount)
                        .setString("credit_card_type", to_accounts_receivable_payments.credit_card_type)
                        .setNumber("credit_card_rate", to_accounts_receivable_payments.credit_card_rate)
                        .setString("credit_card_no", to_accounts_receivable_payments.credit_card_no)
                        .setString("credit_card_holder", to_accounts_receivable_payments.credit_card_holder)
                        .setNumber("credit_card_amount", to_accounts_receivable_payments.credit_card_amount)
                        .setString("gift_certificate_from", to_accounts_receivable_payments.gift_certificate_from)
                        .setString("gift_certificate_description", to_accounts_receivable_payments.gift_certificate_description)
                        .setString("gift_certificate_no", to_accounts_receivable_payments.gift_certificate_no)
                        .setNumber("gift_certificate_amount", to_accounts_receivable_payments.gift_certificate_amount)
                        .setString("online_bank", to_accounts_receivable_payments.online_bank)
                        .setString("online_reference_no", to_accounts_receivable_payments.online_reference_no)
                        .setString("online_holder", to_accounts_receivable_payments.online_holder)
                        .setString("online_date", to_accounts_receivable_payments.online_date)
                        .setNumber("online_amount", to_accounts_receivable_payments.online_amount)
                        .setNumber("actual_amount", to_accounts_receivable_payments.actual_amount)
                        .setNumber("salary_deduction", to_accounts_receivable_payments.salary_deduction)
                        .ok();
                stmt.addBatch(s5);

                String s6 = "select "
                        + " balance"
                        + " from  customers where "
                        + " customer_no ='" + to_return_from_customer_items.charge_customer_id + "' "
                        + " ";

                Statement stmt6 = conn.createStatement();
                ResultSet rs6 = stmt6.executeQuery(s6);
                double balance = 0;
                if (rs6.next()) {
                    balance = rs6.getDouble(1);
                }
                double tendered = to_return_from_customer_items.charge_amount;
                double new_balance = balance - (tendered);
                double actual_amount2 = to_accounts_receivable_payments.actual_amount;
                String s2 = "update  customers set "
                        + " balance= :balance"
                        + " where "
                        + " customer_no ='" + to_return_from_customer_items.charge_customer_id + "' "
                        + " ";
                s2 = SqlStringUtil.parse(s2).
                        setNumber("balance", new_balance).
                        ok();

                stmt.addBatch(s2);

                //update customers paid
//            to_accounts_receivable tar = ret_ar_details(to_accounts_receivable_payments.ar_no);
                String s11 = "select "
                        + " paid"
                        + " from  accounts_receivable where "
                        + " ar_no ='" + to_return_from_customer_items.charge_ar_no + "' "
                        + " ";
                double paid2 = 0;
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                while (rs11.next()) {
                    paid2 = rs11.getDouble(1);
                }

                double new_paid = paid2 + tendered;
                String s3 = "update  accounts_receivable set "
                        + " paid= :paid"
                        + " where "
                        + " ar_no ='" + to_return_from_customer_items.charge_ar_no + "' "
                        + " ";

                s3 = SqlStringUtil.parse(s3).
                        setNumber("paid", new_paid).
                        ok();
                System.out.println("s3: " + s3);
                stmt.addBatch(s3);

                //</editor-fold>
            }
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
                    + ",cash"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
                    + ",selling_price"
                    + " from return_from_customer_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String return_from_customer_no = rs.getString(2);
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
                double cash = rs.getDouble(35);
                String prepaid_customer_name = rs.getString(36);
                String prepaid_customer_id = rs.getString(37);
                double prepaid_amount = rs.getDouble(38);
                String charge_reference_no = rs.getString(39);
                String charge_ar_no = rs.getString(40);
                String charge_type = rs.getString(41);
                String charge_customer_name = rs.getString(42);
                String charge_customer_id = rs.getString(43);
                double charge_amount = rs.getDouble(44);
                int charge_days = rs.getInt(45);
                double selling_price=rs.getDouble(46);
                to_return_from_customer_items to = new to_return_from_customer_items(id, return_from_customer_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, branch, branch_id, location, location_id, cash, prepaid_customer_name, prepaid_customer_id, prepaid_amount, charge_reference_no, charge_ar_no, charge_type, charge_customer_name, charge_customer_id, charge_amount, charge_days,selling_price);
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
