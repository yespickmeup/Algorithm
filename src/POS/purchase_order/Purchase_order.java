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
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Purchase_order {

    public static class to_purchase_orders {

        public final int id;
        public final String puchase_order_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supplier_id;
        public final String remarks;
        public final int status;
        public final String date_delivered;
        public final String date_received;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String reference_no;
        public final double gross_total;
        public final String discount;
        public final double discount_amount;
        public final double discount_rate;
        public final String receipt_no;
        public final String receipt_type;
        public final String receipt_type_id;
        public final double total_qty_ordered;
        public final double total_qty_received;

        public to_purchase_orders(int id, String puchase_order_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String remarks, int status, String date_delivered, String date_received, String branch, String branch_id, String location, String location_id, String reference_no, double gross_total, String discount, double discount_amount, double discount_rate, String receipt_no, String receipt_type, String receipt_type_id, double total_qty_ordered, double total_qty_received) {
            this.id = id;
            this.puchase_order_no = puchase_order_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.remarks = remarks;
            this.status = status;
            this.date_delivered = date_delivered;
            this.date_received = date_received;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.reference_no = reference_no;
            this.gross_total = gross_total;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.discount_rate = discount_rate;
            this.receipt_no = receipt_no;
            this.receipt_type = receipt_type;
            this.receipt_type_id = receipt_type_id;
            this.total_qty_ordered = total_qty_ordered;
            this.total_qty_received = total_qty_received;
        }
    }

    public static void add_data(to_purchase_orders to_purchase_orders, List<Purchase_order_item.to_purchase_order_items> orders) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into purchase_orders("
                    + "puchase_order_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",remarks"
                    + ",status"
                    + ",date_delivered"
                    + ",date_received"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",reference_no"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",receipt_no"
                    + ",receipt_type"
                    + ",receipt_type_id"
                    + ",total_qty_ordered"
                    + ",total_qty_received"
                    + ")values("
                    + ":puchase_order_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:remarks"
                    + ",:status"
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:reference_no"
                    + ",:gross_total"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:discount_rate"
                    + ",:receipt_no"
                    + ",:receipt_type"
                    + ",:receipt_type_id"
                    + ",:total_qty_ordered"
                    + ",:total_qty_received"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("puchase_order_no", to_purchase_orders.puchase_order_no)
                    .setString("user_name", to_purchase_orders.user_name)
                    .setString("session_no", to_purchase_orders.session_no)
                    .setString("date_added", to_purchase_orders.date_added)
                    .setString("supplier", to_purchase_orders.supplier)
                    .setString("supplier_id", to_purchase_orders.supplier_id)
                    .setString("remarks", to_purchase_orders.remarks)
                    .setNumber("status", to_purchase_orders.status)
                    .setString("date_delivered", to_purchase_orders.date_delivered)
                    .setString("date_received", to_purchase_orders.date_received)
                    .setString("branch", to_purchase_orders.branch)
                    .setString("branch_id", to_purchase_orders.branch_id)
                    .setString("location", to_purchase_orders.location)
                    .setString("location_id", to_purchase_orders.location_id)
                    .setString("reference_no", to_purchase_orders.reference_no)
                    .setNumber("gross_total", to_purchase_orders.gross_total)
                    .setString("discount", to_purchase_orders.discount)
                    .setNumber("discount_amount", to_purchase_orders.discount_amount)
                    .setNumber("discount_rate", to_purchase_orders.discount_rate)
                    .setString("receipt_no", to_purchase_orders.receipt_no)
                    .setString("receipt_type", to_purchase_orders.receipt_type)
                    .setString("receipt_type_id", to_purchase_orders.receipt_type_id)
                    .setNumber("total_qty_ordered", to_purchase_orders.total_qty_ordered)
                    .setNumber("total_qty_received", to_purchase_orders.total_qty_received)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Purchase_order_item.to_purchase_order_items to_purchase_order_items : orders) {
                String s2 = "insert into purchase_order_items("
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

                s2 = SqlStringUtil.parse(s2)
                        .setString("po_no", to_purchase_orders.puchase_order_no)
                        .setString("user_name", to_purchase_orders.user_name)
                        .setString("session_no", to_purchase_orders.session_no)
                        .setString("date_added", to_purchase_orders.date_added)
                        .setString("supplier", to_purchase_orders.supplier)
                        .setString("supplier_id", to_purchase_orders.supplier_id)
                        .setString("remarks", to_purchase_orders.remarks)
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
                        .setNumber("status", to_purchase_orders.status)
                        .setString("date_delivered", to_purchase_orders.date_delivered)
                        .setString("date_received", to_purchase_orders.date_received)
                        .setString("reference_no", to_purchase_orders.reference_no)
                        .setString("receipt_type", to_purchase_orders.receipt_type)
                        .setString("receipt_type_id", to_purchase_orders.receipt_type_id)
                        .setString("branch", to_purchase_orders.branch)
                        .setString("branch_id", to_purchase_orders.branch_id)
                        .setString("location", to_purchase_orders.location)
                        .setString("location_id", to_purchase_orders.location_id)
                        .ok();
                stmt.addBatch(s2);
            }
            stmt.executeBatch();
            conn.commit();
            Lg.s(Purchase_order.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into purchase_orders("
                    + "puchase_order_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",remarks"
                    + ",status"
                    + ",date_delivered"
                    + ",date_received"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",reference_no"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",receipt_no"
                    + ",receipt_type"
                    + ",receipt_type_id"
                    + ",total_qty_ordered"
                    + ",total_qty_received"
                    + ")values("
                    + ":puchase_order_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:remarks"
                    + ",:status"
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:reference_no"
                    + ",:gross_total"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:discount_rate"
                    + ",:receipt_no"
                    + ",:receipt_type"
                    + ",:receipt_type_id"
                    + ",:total_qty_ordered"
                    + ",:total_qty_received"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("puchase_order_no", to_purchase_orders.puchase_order_no)
                    .setString("user_name", to_purchase_orders.user_name)
                    .setString("session_no", to_purchase_orders.session_no)
                    .setString("date_added", to_purchase_orders.date_added)
                    .setString("supplier", to_purchase_orders.supplier)
                    .setString("supplier_id", to_purchase_orders.supplier_id)
                    .setString("remarks", to_purchase_orders.remarks)
                    .setNumber("status", to_purchase_orders.status)
                    .setString("date_delivered", to_purchase_orders.date_delivered)
                    .setString("date_received", to_purchase_orders.date_received)
                    .setString("branch", to_purchase_orders.branch)
                    .setString("branch_id", to_purchase_orders.branch_id)
                    .setString("location", to_purchase_orders.location)
                    .setString("location_id", to_purchase_orders.location_id)
                    .setString("reference_no", to_purchase_orders.reference_no)
                    .setNumber("gross_total", to_purchase_orders.gross_total)
                    .setString("discount", to_purchase_orders.discount)
                    .setNumber("discount_amount", to_purchase_orders.discount_amount)
                    .setNumber("discount_rate", to_purchase_orders.discount_rate)
                    .setString("receipt_no", to_purchase_orders.receipt_no)
                    .setString("receipt_type", to_purchase_orders.receipt_type)
                    .setString("receipt_type_id", to_purchase_orders.receipt_type_id)
                    .setNumber("total_qty_ordered", to_purchase_orders.total_qty_ordered)
                    .setNumber("total_qty_received", to_purchase_orders.total_qty_received)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update purchase_orders set is_uploaded=1 where id='" + to_purchase_orders.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Purchase_order.class, "Successfully Added: " + to_purchase_orders.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update purchase_orders set "
                    + "puchase_order_no= :puchase_order_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",date_delivered= :date_delivered "
                    + ",date_received= :date_received "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",reference_no= :reference_no "
                    + ",gross_total= :gross_total "
                    + ",discount= :discount "
                    + ",discount_amount= :discount_amount "
                    + ",discount_rate= :discount_rate "
                    + ",receipt_no= :receipt_no "
                    + ",receipt_type= :receipt_type "
                    + ",receipt_type_id= :receipt_type_id "
                    + ",total_qty_ordered= :total_qty_ordered "
                    + ",total_qty_received= :total_qty_received "
                    + " where id='" + to_purchase_orders.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("puchase_order_no", to_purchase_orders.puchase_order_no)
                    .setString("user_name", to_purchase_orders.user_name)
                    .setString("session_no", to_purchase_orders.session_no)
                    .setString("date_added", to_purchase_orders.date_added)
                    .setString("supplier", to_purchase_orders.supplier)
                    .setString("supplier_id", to_purchase_orders.supplier_id)
                    .setString("remarks", to_purchase_orders.remarks)
                    .setNumber("status", to_purchase_orders.status)
                    .setString("date_delivered", to_purchase_orders.date_delivered)
                    .setString("date_received", to_purchase_orders.date_received)
                    .setString("branch", to_purchase_orders.branch)
                    .setString("branch_id", to_purchase_orders.branch_id)
                    .setString("location", to_purchase_orders.location)
                    .setString("location_id", to_purchase_orders.location_id)
                    .setString("reference_no", to_purchase_orders.reference_no)
                    .setNumber("gross_total", to_purchase_orders.gross_total)
                    .setString("discount", to_purchase_orders.discount)
                    .setNumber("discount_amount", to_purchase_orders.discount_amount)
                    .setNumber("discount_rate", to_purchase_orders.discount_rate)
                    .setString("receipt_no", to_purchase_orders.receipt_no)
                    .setString("receipt_type", to_purchase_orders.receipt_type)
                    .setString("receipt_type_id", to_purchase_orders.receipt_type_id)
                    .setNumber("total_qty_ordered", to_purchase_orders.total_qty_ordered)
                    .setNumber("total_qty_received", to_purchase_orders.total_qty_received)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Purchase_order.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_po(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update purchase_orders set "
                    + "supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",remarks= :remarks "
                    + ",date_delivered= :date_delivered "
                    + ",date_received= :date_received "
                    + ",reference_no= :reference_no "
                    + ",discount= :discount "
                    + ",discount_amount= :discount_amount "
                    + ",discount_rate= :discount_rate "
                    + " where id='" + to_purchase_orders.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("supplier", to_purchase_orders.supplier)
                    .setString("supplier_id", to_purchase_orders.supplier_id)
                    .setString("remarks", to_purchase_orders.remarks)
                    .setNumber("status", to_purchase_orders.status)
                    .setString("date_delivered", to_purchase_orders.date_delivered)
                    .setString("date_received", to_purchase_orders.date_received)
                    .setString("reference_no", to_purchase_orders.reference_no)
                    .setString("discount", to_purchase_orders.discount)
                    .setNumber("discount_amount", to_purchase_orders.discount_amount)
                    .setNumber("discount_rate", to_purchase_orders.discount_rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update purchase_order_items set "
                    + " supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",remarks= :remarks "
                    + ",date_delivered= :date_delivered "
                    + ",date_received= :date_received "
                    + ",reference_no= :reference_no "
                    + " where id='" + to_purchase_orders.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("supplier", to_purchase_orders.supplier)
                    .setString("supplier_id", to_purchase_orders.supplier_id)
                    .setString("remarks", to_purchase_orders.remarks)
                    .setNumber("status", to_purchase_orders.status)
                    .setString("date_delivered", to_purchase_orders.date_delivered)
                    .setString("date_received", to_purchase_orders.date_received)
                    .setString("reference_no", to_purchase_orders.reference_no)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Lg.s(Purchase_order.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_order(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update purchase_orders set "
                    + " status= :status "
                    + " where id='" + to_purchase_orders.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update purchase_order_items set "
                    + " status= :status "
                    + " where po_no='" + to_purchase_orders.puchase_order_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Lg.s(Purchase_order.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void returnorder(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update purchase_orders set "
                    + " status= :status "
                    + " where id='" + to_purchase_orders.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 2)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update purchase_order_items set "
                    + " status= :status "
                    + " where po_no='" + to_purchase_orders.puchase_order_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 2)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Lg.s(Purchase_order.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_order(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from purchase_orders  "
                    + " where id='" + to_purchase_orders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "delete from purchase_order_items  "
                    + " where po_no='" + to_purchase_orders.puchase_order_no + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Lg.s(Purchase_order.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from purchase_orders  "
                    + " where id='" + to_purchase_orders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Purchase_order.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_purchase_orders> ret_data(String where) {
        List<to_purchase_orders> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",puchase_order_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",remarks"
                    + ",status"
                    + ",date_delivered"
                    + ",date_received"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",reference_no"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",receipt_no"
                    + ",receipt_type"
                    + ",receipt_type_id"
                    + ",total_qty_ordered"
                    + ",total_qty_received"
                    + " from purchase_orders"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String puchase_order_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supplier_id = rs.getString(7);
                String remarks = rs.getString(8);
                int status = rs.getInt(9);
                String date_delivered = rs.getString(10);
                String date_received = rs.getString(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location = rs.getString(14);
                String location_id = rs.getString(15);
                String reference_no = rs.getString(16);
                double gross_total = rs.getDouble(17);
                String discount = rs.getString(18);
                double discount_amount = rs.getDouble(19);
                double discount_rate = rs.getDouble(20);
                String receipt_no = rs.getString(21);
                String receipt_type = rs.getString(22);
                String receipt_type_id = rs.getString(23);
                double total_qty_ordered = rs.getDouble(24);
                double total_qty_received = rs.getDouble(25);

                to_purchase_orders to = new to_purchase_orders(id, puchase_order_no, user_name, session_no, date_added, supplier, supplier_id, remarks, status, date_delivered, date_received, branch, branch_id, location, location_id, reference_no, gross_total, discount, discount_amount, discount_rate, receipt_no, receipt_type, receipt_type_id, total_qty_ordered, total_qty_received);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {

    }

    public static String increment_id(String location_id) {

        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from purchase_orders where location_id='" + location_id + "'  ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);

            if (rs.next()) {
                id = rs.getString(1);

                String s2 = "select puchase_order_no,id from purchase_orders where id='" + id + "'";
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
