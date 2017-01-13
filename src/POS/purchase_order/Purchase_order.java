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

    public static void add_data(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
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
            stmt.execute();
            Lg.s(Purchase_order.class, "Successfully Added");
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

}
