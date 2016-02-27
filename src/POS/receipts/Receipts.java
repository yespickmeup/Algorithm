/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.branch_locations.S1_branch_locations;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.scripts.Local_branch_query_uploads;
import POS.scripts.Main_branch_query_uploads;
import POS.users.MyUser;
import POS.util.DateType;
import POS.util.MyConnection;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class Receipts {

    public static class to_receipts {

        public final int id;
        public final String receipt_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String date_delivered;
        public final String date_received;
        public final String receipt_type;
        public final String reference_no;
        public final String branch;
        public final String branch_id;
        public final double gross_total;
        public final double net_total;
        public final String batch_no;
        public final double discount;
        public final String receipt_type_id;
        public final int status;

        public to_receipts(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String date_delivered, String date_received, String receipt_type, String reference_no, String branch, String branch_id, double gross_total, double net_total, String batch_no, double discount, String receipt_type_id, int status) {
            this.id = id;
            this.receipt_no = receipt_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.date_delivered = date_delivered;
            this.date_received = date_received;
            this.receipt_type = receipt_type;
            this.reference_no = reference_no;
            this.branch = branch;
            this.branch_id = branch_id;
            this.gross_total = gross_total;
            this.net_total = net_total;
            this.batch_no = batch_no;
            this.discount = discount;
            this.receipt_type_id = receipt_type_id;
            this.status = status;
        }
    }

    public static void add_receipts(to_receipts to_receipts, List<S1_receipt_items.to_receipt_items> to_receipt_items1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "insert into receipts("
                    + "receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",receipt_type_id"
                    + ",status"
                    + ")values("
                    + ":receipt_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supllier_id"
                    + ",:remarks"
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:receipt_type"
                    + ",:reference_no"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:gross_total"
                    + ",:net_total"
                    + ",:batch_no"
                    + ",:discount"
                    + ",:receipt_type_id"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("receipt_no", to_receipts.receipt_no).
                    setString("user_name", to_receipts.user_name).
                    setString("session_no", to_receipts.session_no).
                    setString("date_added", to_receipts.date_added).
                    setString("supplier", to_receipts.supplier).
                    setString("supllier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    setString("date_delivered", to_receipts.date_delivered).
                    setString("date_received", to_receipts.date_received).
                    setString("receipt_type", to_receipts.receipt_type).
                    setString("reference_no", to_receipts.reference_no).
                    setString("branch", to_receipts.branch).
                    setString("branch_id", to_receipts.branch_id).
                    setNumber("gross_total", to_receipts.gross_total).
                    setNumber("net_total", to_receipts.net_total).
                    setString("batch_no", to_receipts.batch_no).
                    setNumber("discount", to_receipts.discount).
                    setString("receipt_type_id", to_receipts.receipt_type_id).
                    setNumber("status", to_receipts.status).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (S1_receipt_items.to_receipt_items to_receipt_items : to_receipt_items1) {
                String s2 = "insert into  receipt_items("
                        + "receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supllier_id"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ",conversion"
                        + ",unit"
                        + ",date_delivered"
                        + ",date_received"
                        + ",barcodes"
                        + ",serial_no"
                        + ",batch_no"
                        + ",main_barcode"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",status"
                        + ",previous_cost"
                        + ",receipt_type_id"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":receipt_no"
                        + ",:user_name"
                        + ",:session_no"
                        + ",:date_added"
                        + ",:supplier"
                        + ",:supllier_id"
                        + ",:remarks"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:cost"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ",:conversion"
                        + ",:unit"
                        + ",:date_delivered"
                        + ",:date_received"
                        + ",:barcodes"
                        + ",:serial_no"
                        + ",:batch_no"
                        + ",:main_barcode"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:status"
                        + ",:previous_cost"
                        + ",:receipt_type_id"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s2 = SqlStringUtil.parse(s2).
                        setString("receipt_no", to_receipts.receipt_no).
                        setString("user_name", to_receipt_items.user_name).
                        setString("session_no", to_receipt_items.session_no).
                        setString("date_added", to_receipt_items.date_added).
                        setString("supplier", to_receipt_items.supplier).
                        setString("supllier_id", to_receipt_items.supllier_id).
                        setString("remarks", to_receipt_items.remarks).
                        setString("barcode", to_receipt_items.barcode).
                        setString("description", to_receipt_items.description).
                        setNumber("qty", to_receipt_items.qty).
                        setNumber("cost", to_receipt_items.cost).
                        setString("category", to_receipt_items.category).
                        setString("category_id", to_receipt_items.category_id).
                        setString("classification", to_receipt_items.classification).
                        setString("classification_id", to_receipt_items.classification_id).
                        setString("sub_class", to_receipt_items.sub_class).
                        setString("sub_class_id", to_receipt_items.sub_class_id).
                        setNumber("conversion", to_receipt_items.conversion).
                        setString("unit", to_receipt_items.unit).
                        setString("date_delivered", to_receipt_items.date_delivered).
                        setString("date_received", to_receipt_items.date_received).
                        setString("barcodes", to_receipt_items.barcodes).
                        setString("serial_no", to_receipt_items.serial_no).
                        setString("batch_no", to_receipt_items.batch_no).
                        setString("main_barcode", to_receipt_items.main_barcode).
                        setString("brand", to_receipt_items.brand).
                        setString("brand_id", to_receipt_items.brand_id).
                        setString("model", to_receipt_items.model).
                        setString("model_id", to_receipt_items.model_id).
                        setNumber("status", to_receipt_items.status).
                        setNumber("previous_cost", to_receipt_items.previous_cost).
                        setString("receipt_type_id", to_receipt_items.receipt_type_id).
                        setString("branch", to_receipt_items.branch).
                        setString("branch_id", to_receipt_items.branch_id).
                        setString("location", to_receipt_items.location).
                        setString("location_id", to_receipt_items.location_id).
                        ok();

                stmt.addBatch(s2);

            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Receipts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipts set "
                    + "receipt_no= :receipt_no"
                    + ",user_name= :user_name"
                    + ",session_no= :session_no"
                    + ",date_added= :date_added"
                    + ",supplier= :supplier"
                    + ",supllier_id= :supllier_id"
                    + ",remarks= :remarks"
                    + ",date_delivered= :date_delivered"
                    + ",date_received= :date_received"
                    + ",receipt_type= :receipt_type"
                    + ",reference_no= :reference_no"
                    + ",branch= :branch"
                    + ",branch_id= :branch_id"
                    + ",gross_total= :gross_total"
                    + ",net_total= :net_total"
                    + ",batch_no= :batch_no"
                    + ",discount= :discount"
                    + ",receipt_type_id= :receipt_type_id"
                    + ",status= :status"
                    + " where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("receipt_no", to_receipts.receipt_no).
                    setString("user_name", to_receipts.user_name).
                    setString("session_no", to_receipts.session_no).
                    setString("date_added", to_receipts.date_added).
                    setString("supplier", to_receipts.supplier).
                    setString("supllier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    setString("date_delivered", to_receipts.date_delivered).
                    setString("date_received", to_receipts.date_received).
                    setString("receipt_type", to_receipts.receipt_type).
                    setString("reference_no", to_receipts.reference_no).
                    setString("branch", to_receipts.branch).
                    setString("branch_id", to_receipts.branch_id).
                    setNumber("gross_total", to_receipts.gross_total).
                    setNumber("net_total", to_receipts.net_total).
                    setString("batch_no", to_receipts.batch_no).
                    setNumber("discount", to_receipts.discount).
                    setString("receipt_type_id", to_receipts.receipt_type_id).
                    setNumber("status", to_receipts.status).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipts.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipts3(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipts set "
                    + "supplier= :supplier"
                    + ",supllier_id= :supllier_id"
                    + ",remarks= :remarks"
                    + ",date_delivered= :date_delivered"
                    + ",date_received= :date_received"
                    + ",receipt_type= :receipt_type"
                    + ",reference_no= :reference_no"
                    + ",branch= :branch"
                    + ",branch_id= :branch_id"
                    + ",gross_total= :gross_total"
                    + ",net_total= :net_total"
                    + ",batch_no= :batch_no"
                    + ",discount= :discount"
                    + ",receipt_type_id= :receipt_type_id"
                    + ",status= :status"
                    + " where id= '" + to_receipts.id + "'"
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("supplier", to_receipts.supplier)
                    .setString("supllier_id", to_receipts.supllier_id)
                    .setString("remarks", to_receipts.remarks)
                    .setString("date_delivered", to_receipts.date_delivered)
                    .setString("date_received", to_receipts.date_received)
                    .setString("receipt_type", to_receipts.receipt_type)
                    .setString("reference_no", to_receipts.reference_no)
                    .setString("branch", to_receipts.branch)
                    .setString("branch_id", to_receipts.branch_id)
                    .setNumber("gross_total", to_receipts.gross_total)
                    .setNumber("net_total", to_receipts.net_total)
                    .setString("batch_no", to_receipts.batch_no)
                    .setNumber("discount", to_receipts.discount)
                    .setString("receipt_type_id", to_receipts.receipt_type_id)
                    .setNumber("status", to_receipts.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipts.class, "Successfully Updated");

            String s2 = "update receipt_items set "
                    + "supplier= :supplier"
                    + ",supllier_id= :supllier_id"
                    + ",remarks= :remarks"
                    + ",date_delivered= :date_delivered"
                    + ",date_received= :date_received"
                    + ",batch_no= :batch_no"
                    + ",branch= :branch"
                    + ",branch_id= :branch_id"
                    + " where "
                    + " receipt_no ='" + to_receipts.receipt_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("supplier", to_receipts.supplier)
                    .setString("supllier_id", to_receipts.supllier_id)
                    .setString("remarks", to_receipts.remarks)
                    .setString("date_delivered", to_receipts.date_delivered)
                    .setString("date_received", to_receipts.date_received)
                    .setString("batch_no", to_receipts.batch_no)
                    .setString("branch", to_receipts.branch)
                    .setString("branch_id", to_receipts.branch_id)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipts2(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipts set "
                    + "supplier= :supplier"
                    + ",supllier_id= :supllier_id"
                    + ",remarks= :remarks"
                    + ",date_delivered= :date_delivered"
                    + ",date_received= :date_received"
                    + ",receipt_type= :receipt_type"
                    + ",reference_no= :reference_no"
                    + ",branch= :branch"
                    + ",branch_id= :branch_id"
                    + ",gross_total= :gross_total"
                    + ",net_total= :net_total"
                    + ",batch_no= :batch_no"
                    + ",discount= :discount"
                    + ",receipt_type_id= :receipt_type_id"
                    + ",status= :status"
                    + " where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("supplier", to_receipts.supplier).
                    setString("supllier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    setString("date_delivered", to_receipts.date_delivered).
                    setString("date_received", to_receipts.date_received).
                    setString("receipt_type", to_receipts.receipt_type).
                    setString("reference_no", to_receipts.reference_no).
                    setString("branch", to_receipts.branch).
                    setString("branch_id", to_receipts.branch_id).
                    setNumber("gross_total", to_receipts.gross_total).
                    setNumber("net_total", to_receipts.net_total).
                    setString("batch_no", to_receipts.batch_no).
                    setNumber("discount", to_receipts.discount).
                    setString("receipt_type_id", to_receipts.receipt_type_id).
                    setNumber("status", to_receipts.status).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipts.class, "Successfully Updated");

            String s2 = "update receipt_items set "
                    + "supplier= :supplier"
                    + ",supllier_id= :supllier_id"
                    + ",remarks= :remarks"
                    + ",date_delivered= :date_delivered"
                    + ",date_received= :date_received"
                    + ",batch_no= :batch_no"
                    + ",branch= :branch"
                    + ",branch_id= :branch_id"
                    + " where "
                    + " receipt_no ='" + to_receipts.receipt_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("supplier", to_receipts.supplier)
                    .setString("supllier_id", to_receipts.supllier_id)
                    .setString("remarks", to_receipts.remarks)
                    .setString("date_delivered", to_receipts.date_delivered)
                    .setString("date_received", to_receipts.date_received)
                    .setString("batch_no", to_receipts.batch_no)
                    .setString("branch", to_receipts.branch)
                    .setString("branch_id", to_receipts.branch_id)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  receipts where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipts.class, "Successfully Deleted");

            String s2 = "delete from receipt_items where "
                    + " receipt_no='" + to_receipts.receipt_no + "'";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data(String search) {
        List<to_receipts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",receipt_type_id"
                    + ",status"
                    + " from receipts where "
                    + " receipt_no like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                String receipt_type = rs.getString(11);
                String reference_no = rs.getString(12);
                String branch = rs.getString(13);
                String branch_id = rs.getString(14);
                double gross_total = rs.getDouble(15);
                double net_total = rs.getDouble(16);
                String batch_no = rs.getString(17);
                double discount = rs.getDouble(18);
                String receipt_type_id = rs.getString(19);
                int status = rs.getInt(20);
                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data3(String where) {
        List<to_receipts> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",receipt_type_id"
                    + ",status"
                    + " from receipts  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                String receipt_type = rs.getString(11);
                String reference_no = rs.getString(12);
                String branch = rs.getString(13);
                String branch_id = rs.getString(14);
                double gross_total = rs.getDouble(15);
                double net_total = rs.getDouble(16);
                String batch_no = rs.getString(17);
                double discount = rs.getDouble(18);
                String receipt_type_id = rs.getString(19);
                int status = rs.getInt(20);
                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data4(String where) {
        List<to_receipts> datas = new ArrayList();
        List<S1_branch_locations.to_branch_locations> locations = S1_branch_locations.ret_where("");

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",receipt_type_id"
                    + ",status"
                    + " from receipts  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                String receipt_type = rs.getString(11);
                String reference_no = rs.getString(12);
                String branch = rs.getString(13);

                String branch_id = rs.getString(14);
                for (S1_branch_locations.to_branch_locations loc : locations) {
                    if (branch_id.equalsIgnoreCase("" + loc.id)) {
                        branch = loc.location + " - " + loc.branch;
                        break;
                    }
                }
                double gross_total = rs.getDouble(15);
                double net_total = rs.getDouble(16);
                String batch_no = rs.getString(17);
                double discount = rs.getDouble(18);
                String receipt_type_id = rs.getString(19);
                int status = rs.getInt(20);
                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data2(String search, String date_from, String date_to) {
        List<to_receipts> datas = new ArrayList();

        try {

            Connection conn = MyConnection.
                    connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",receipt_type_id"
                    + ",status"
                    + " from receipts where "
                    + " date(date_received) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                String receipt_type = rs.getString(11);
                String reference_no = rs.getString(12);
                String branch = rs.getString(13);
                String branch_id = rs.getString(14);
                double gross_total = rs.getDouble(15);
                double net_total = rs.getDouble(16);
                String batch_no = rs.getString(17);
                double discount = rs.getDouble(18);
                String receipt_type_id = rs.getString(19);
                int status = rs.getInt(20);
                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, status);
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
        System.out.println(increment_id("25"));
    }

    public static String increment_id(String location_id) {

        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from receipts where branch_id='" + location_id + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);

                String s2 = "select receipt_no,id from receipts where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }

            }

            if (id == null) {
                id = location_id + "|0000000000";
            }

            id = ReceiptIncrementor.increment(id);

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize(to_receipts to_receipts, List<S1_receipt_items.to_receipt_items> to_receipt_items1, String branch, String branch_id) {
        try {
            Connection conn = MyConnection.connect();

            conn.setAutoCommit(false);
            List<String> query = new ArrayList();
            Gson gson = new Gson();
            System.out.println("adding record....");

            String s0 = "update receipts set "
                    + " status= :status"
                    + " where "
                    + " receipt_no='" + to_receipts.receipt_no + "'";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            //<editor-fold defaultstate="collapsed" desc=" insert query1 ">
            String query1 = "insert into receipts("
                    + "receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",receipt_type_id"
                    + ",status"
                    + ")values("
                    + ":receipt_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supllier_id"
                    + ",:remarks"
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:receipt_type"
                    + ",:reference_no"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:gross_total"
                    + ",:net_total"
                    + ",:batch_no"
                    + ",:discount"
                    + ",:receipt_type_id"
                    + ",:status"
                    + ")";

            query1 = SqlStringUtil.parse(query1).
                    setString("receipt_no", to_receipts.receipt_no).
                    setString("user_name", to_receipts.user_name).
                    setString("session_no", to_receipts.session_no).
                    setString("date_added", to_receipts.date_added).
                    setString("supplier", to_receipts.supplier).
                    setString("supllier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    setString("date_delivered", to_receipts.date_delivered).
                    setString("date_received", to_receipts.date_received).
                    setString("receipt_type", to_receipts.receipt_type).
                    setString("reference_no", to_receipts.reference_no).
                    setString("branch", to_receipts.branch).
                    setString("branch_id", to_receipts.branch_id).
                    setNumber("gross_total", to_receipts.gross_total).
                    setNumber("net_total", to_receipts.net_total).
                    setString("batch_no", to_receipts.batch_no).
                    setNumber("discount", to_receipts.discount).
                    setString("receipt_type_id", to_receipts.receipt_type_id).
                    setNumber("status", to_receipts.status).
                    ok();
            query.add(query1);
            //</editor-fold>

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update receipt_items set "
                    + " status= :status"
                    + " where "
                    + " receipt_no='" + to_receipts.receipt_no + "'";
            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 1)
                    .ok();

            stmt.addBatch(s2);

            for (S1_receipt_items.to_receipt_items to_receipt_items : to_receipt_items1) {
                if (to_receipt_items.status == 0) {
                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_receipt_items.main_barcode, to_receipt_items.barcode, to_receipt_items.branch_id);
                    double new_qty = tt.product_qty + (to_receipt_items.conversion * to_receipt_items.qty);
                    String new_serial = tt.serial_no + "\n" + to_receipt_items.serial_no;
                    if (tt.serial_no.isEmpty()) {
                        new_serial = to_receipt_items.serial_no;
                    }
                    String s4 = "update inventory_barcodes set "
                            + " product_qty='" + new_qty + "'"
                            + ",cost='" + to_receipt_items.cost + "' "
                            + ",serial_no='" + new_serial + "' "
                            + " where  main_barcode= '" + to_receipt_items.main_barcode + "' and location_id='" + to_receipt_items.branch_id + "' "
                            + "";

                    stmt.addBatch(s4);
                    String s5 = "update inventory set "
                            + " cost= :cost"
                            + " where "
                            + " barcode ='" + to_receipt_items.main_barcode + "' "
                            + " ";
                    s5 = SqlStringUtil.parse(s5).
                            setNumber("cost", to_receipt_items.cost).
                            ok();
                    
                    stmt.addBatch(s5);

                    //<editor-fold defaultstate="collapsed" desc=" insert query 2 ">
                    String query2 = "insert into  receipt_items("
                            + "receipt_no"
                            + ",user_name"
                            + ",session_no"
                            + ",date_added"
                            + ",supplier"
                            + ",supllier_id"
                            + ",remarks"
                            + ",barcode"
                            + ",description"
                            + ",qty"
                            + ",cost"
                            + ",category"
                            + ",category_id"
                            + ",classification"
                            + ",classification_id"
                            + ",sub_class"
                            + ",sub_class_id"
                            + ",conversion"
                            + ",unit"
                            + ",date_delivered"
                            + ",date_received"
                            + ",barcodes"
                            + ",serial_no"
                            + ",batch_no"
                            + ",main_barcode"
                            + ",brand"
                            + ",brand_id"
                            + ",model"
                            + ",model_id"
                            + ",status"
                            + ",previous_cost"
                            + ",receipt_type_id"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + ")values("
                            + ":receipt_no"
                            + ",:user_name"
                            + ",:session_no"
                            + ",:date_added"
                            + ",:supplier"
                            + ",:supllier_id"
                            + ",:remarks"
                            + ",:barcode"
                            + ",:description"
                            + ",:qty"
                            + ",:cost"
                            + ",:category"
                            + ",:category_id"
                            + ",:classification"
                            + ",:classification_id"
                            + ",:sub_class"
                            + ",:sub_class_id"
                            + ",:conversion"
                            + ",:unit"
                            + ",:date_delivered"
                            + ",:date_received"
                            + ",:barcodes"
                            + ",:serial_no"
                            + ",:batch_no"
                            + ",:main_barcode"
                            + ",:brand"
                            + ",:brand_id"
                            + ",:model"
                            + ",:model_id"
                            + ",:status"
                            + ",:previous_cost"
                            + ",:receipt_type_id"
                            + ",:branch"
                            + ",:branch_id"
                            + ",:location"
                            + ",:location_id"
                            + ")";

                    query2 = SqlStringUtil.parse(query2).
                            setString("receipt_no", to_receipts.receipt_no).
                            setString("user_name", to_receipt_items.user_name).
                            setString("session_no", to_receipt_items.session_no).
                            setString("date_added", to_receipt_items.date_added).
                            setString("supplier", to_receipt_items.supplier).
                            setString("supllier_id", to_receipt_items.supllier_id).
                            setString("remarks", to_receipt_items.remarks).
                            setString("barcode", to_receipt_items.barcode).
                            setString("description", to_receipt_items.description).
                            setNumber("qty", to_receipt_items.qty).
                            setNumber("cost", to_receipt_items.cost).
                            setString("category", to_receipt_items.category).
                            setString("category_id", to_receipt_items.category_id).
                            setString("classification", to_receipt_items.classification).
                            setString("classification_id", to_receipt_items.classification_id).
                            setString("sub_class", to_receipt_items.sub_class).
                            setString("sub_class_id", to_receipt_items.sub_class_id).
                            setNumber("conversion", to_receipt_items.conversion).
                            setString("unit", to_receipt_items.unit).
                            setString("date_delivered", to_receipts.date_delivered).
                            setString("date_received", to_receipts.date_received).
                            setString("barcodes", to_receipt_items.barcodes).
                            setString("serial_no", to_receipt_items.serial_no).
                            setString("batch_no", to_receipt_items.batch_no).
                            setString("main_barcode", to_receipt_items.main_barcode).
                            setString("brand", to_receipt_items.brand).
                            setString("brand_id", to_receipt_items.brand_id).
                            setString("model", to_receipt_items.model).
                            setString("model_id", to_receipt_items.model_id).
                            setNumber("status", to_receipt_items.status).
                            setNumber("previous_cost", to_receipt_items.previous_cost).
                            setString("receipt_type_id", to_receipt_items.receipt_type_id).
                            setString("branch", to_receipt_items.branch).
                            setString("branch_id", to_receipt_items.branch_id).
                            setString("location", to_receipt_items.location).
                            setString("location_id", to_receipt_items.location_id).
                            ok();
                    query.add(query2);
                    //</editor-fold>

                }
            }

            String json = gson.toJson(query);
            String my_branch_id = MyUser.getBranch_id();
            if (!my_branch_id.equalsIgnoreCase(branch_id)) {
                String is_server = System.getProperty("is_server", "false");
                String location = System.getProperty("location", "main_branch");
                if (location.equalsIgnoreCase("main_branch")) {
                    Main_branch_query_uploads.add_data2(new Main_branch_query_uploads.to_main_branch_query_uploads(0, json, "", "", "Receipts", MyUser.getBranch(), MyUser.getBranch_id(), MyUser.getLocation(), MyUser.getLocation_id(), DateType.datetime.format(new Date()), 0), branch, branch_id);
                    System.out.println("Record added....");
                }
                if (location.equalsIgnoreCase("local_branch")) {
                    Local_branch_query_uploads.add_data2(new Local_branch_query_uploads.to_main_branch_query_uploads(0, json, "", "", "Receipts", MyUser.getBranch(), MyUser.getBranch_id(), MyUser.getLocation(), MyUser.getLocation_id(), DateType.datetime.format(new Date()), 0), branch, branch_id);
                    System.out.println("Record added....");
                }

            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Inventory.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_gross(String receipt_no, double gross_amount) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipts set "
                    + " gross_total= :gross_total "
                    + " where receipt_no='" + receipt_no + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("gross_total", gross_amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipts.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_receipts to(String where) {
        to_receipts to = null;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",receipt_type_id"
                    + ",status"
                    + " from receipts  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                String receipt_type = rs.getString(11);
                String reference_no = rs.getString(12);
                String branch = rs.getString(13);
                String branch_id = rs.getString(14);
                double gross_total = rs.getDouble(15);
                double net_total = rs.getDouble(16);
                String batch_no = rs.getString(17);
                double discount = rs.getDouble(18);
                String receipt_type_id = rs.getString(19);
                int status = rs.getInt(20);
                to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, status);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
