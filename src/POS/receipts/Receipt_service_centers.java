/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.accounts_payable.Accounts_payable;
import POS.branch_locations.S1_branch_locations;
import POS.inventory.Inventory;
import POS.users.MyUser;
import POS.util.DateType;
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
public class Receipt_service_centers {

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

    public static void add_receipts(to_receipts to_receipts, List<Receipts_service_center_items.to_receipt_items> to_receipt_items1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "insert into receipt_service_centers("
                    + "receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",:supplier_id"
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
                    setString("supplier_id", to_receipts.supllier_id).
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

            for (Receipts_service_center_items.to_receipt_items to_receipt_items : to_receipt_items1) {
                String s2 = "insert into  receipts_service_center_items("
                        + "receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supplier_id"
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
                        + ",:supplier_id"
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
                        setString("user_name", to_receipts.user_name).
                        setString("session_no", to_receipts.session_no).
                        setString("date_added", to_receipts.date_added).
                        setString("supplier", to_receipts.supplier).
                        setString("supplier_id", to_receipts.supllier_id).
                        setString("remarks", to_receipts.remarks).
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

    public static void add_receipts_cloud(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);

            String s0 = "insert into receipt_service_centers("
                    + "receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",:supplier_id"
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
                    setString("supplier_id", to_receipts.supllier_id).
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
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update receipt_service_centers set is_uploaded=1 where id='" + to_receipts.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Receipts.class, "Successfully Added: " + to_receipts.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipt_service_centers set "
                    + "receipt_no= :receipt_no"
                    + ",user_name= :user_name"
                    + ",session_no= :session_no"
                    + ",date_added= :date_added"
                    + ",supplier= :supplier"
                    + ",supplier_id= :supplier_id"
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
                    setString("supplier_id", to_receipts.supllier_id).
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
            String s0 = "update receipt_service_centers set "
                    + "supplier= :supplier"
                    + ",supplier_id= :supplier_id"
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
                    .setString("supplier_id", to_receipts.supllier_id)
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

            String s2 = "update receipts_service_center_items set "
                    + "supplier= :supplier"
                    + ",supplier_id= :supplier_id"
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
                    .setString("supplier_id", to_receipts.supllier_id)
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
            String s0 = "update receipt_service_centers set "
                    + " supplier= :supplier"
                    + ",supplier_id= :supplier_id"
                    + ",remarks= :remarks"
                    + ",date_delivered= :date_delivered"
                    + ",date_received= :date_received"
                    + ",receipt_type= :receipt_type"
                    + ",reference_no= :reference_no"
                    //                    + ",branch= :branch"
                    //                    + ",branch_id= :branch_id"
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
                    setString("supplier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    setString("date_delivered", to_receipts.date_delivered).
                    setString("date_received", to_receipts.date_received).
                    setString("receipt_type", to_receipts.receipt_type).
                    setString("reference_no", to_receipts.reference_no).
                    //                    setString("branch", to_receipts.branch).
                    //                    setString("branch_id", to_receipts.branch_id).
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

            String s2 = "update receipts_service_center_items set "
                    + "supplier= :supplier"
                    + ",supplier_id= :supplier_id"
                    + ",remarks= :remarks"
                    + ",date_delivered= :date_delivered"
                    + ",date_received= :date_received"
                    + ",batch_no= :batch_no"
                    //                    + ",branch= :branch"
                    //                    + ",branch_id= :branch_id"
                    + " where "
                    + " receipt_no ='" + to_receipts.receipt_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("supplier", to_receipts.supplier)
                    .setString("supplier_id", to_receipts.supllier_id)
                    .setString("remarks", to_receipts.remarks)
                    .setString("date_delivered", to_receipts.date_delivered)
                    .setString("date_received", to_receipts.date_received)
                    .setString("batch_no", to_receipts.batch_no)
                    //                    .setString("branch", to_receipts.branch)
                    //                    .setString("branch_id", to_receipts.branch_id)
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
            String s0 = "update  receipt_service_centers set status=2 where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipts.class, "Successfully Deleted");

            String s2 = "update receipt_items set status=2 where "
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

    public static void delete_receipts2(to_receipts to_receipts, List<S1_receipt_orders.to_receipt_items> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update  receipt_service_centers set status=2 where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update receipts_service_center_items set status=2 where "
                    + " receipt_no='" + to_receipts.receipt_no + "'";

            stmt.addBatch(s2);

            for (S1_receipt_orders.to_receipt_items to_receipt_items : items) {
                String s10 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + to_receipt_items.main_barcode + "' and location_id='" + to_receipt_items.location_id + "'"
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

                double new_qty = product_qty - (to_receipt_items.conversion * to_receipt_items.qty);

                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "'"
                        + " where  main_barcode= '" + to_receipt_items.main_barcode + "' and location_id='" + to_receipt_items.branch_id + "' "
                        + "";
                stmt.addBatch(s4);

            }

            stmt.executeBatch();
            conn.commit();

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
                    + ",supplier_id"
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
                    + " from receipt_service_centers where "
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
                    + ",supplier_id"
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
                    + " from receipt_service_centers  "
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

    public static List<to_receipts> ret_data5(String where) {
        List<to_receipts> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s2 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
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
                    + ",batch_no"
                    + ",serial_no"
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
                    + " from receipts_service_center_items"
                    + " " + where;

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                String receipt_no = rs2.getString(2);

                String s0 = "select "
                        + "id"
                        + ",receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supplier_id"
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
                        + " from receipt_service_centers  "
                        + " where receipt_no like '" + receipt_no + "' group by receipt_no ";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                while (rs.next()) {
                    int id2 = rs.getInt(1);
                    String receipt_no2 = rs.getString(2);
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
                    to_receipts to = new to_receipts(id2, receipt_no2, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, status);
                    datas.add(to);
                }
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
                    + ",supplier_id"
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
                    + " from receipt_service_centers  "
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
                    + ",supplier_id"
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
                    + " from receipt_service_centers where "
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

    public static void main2(String[] args) {
//        System.out.println(increment_id("16"));
    }

    public static String increment_id(String location_id) {

        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from receipt_service_centers where branch_id='" + location_id + "'  ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
//            System.out.println(s0);
            if (rs.next()) {
                id = rs.getString(1);

                String s2 = "select receipt_no,id from receipt_service_centers where id='" + id + "'";
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

    public static void finalize(Receipt_service_centers.to_receipts to_receipts, List<Receipts_service_center_items.to_receipt_items> to_receipt_items1, String branch, String branch_id, int is_invoice, int is_payable, String ap_date) {
        try {
            Connection conn = MyConnection.connect();

            conn.setAutoCommit(false);
//            List<String> query = new ArrayList();
//            Gson gson = new Gson();
            System.out.println("Adding record....");
            String s0 = " update receipt_service_centers set "
                    + " status= :status"
                    + " ,batch_no= :batch_no"
                    + " where "
                    + " receipt_no='" + to_receipts.receipt_no + "'";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .setNumber("batch_no", is_invoice)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update receipts_service_center_items set "
                    + " status= :status"
                    + " ,batch_no= :batch_no"
                    + " where "
                    + " receipt_no='" + to_receipts.receipt_no + "'";
            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 1)
                    .setNumber("batch_no", is_invoice)
                    .ok();

            stmt.addBatch(s2);
            for (Receipts_service_center_items.to_receipt_items to_receipt_items : to_receipt_items1) {
                if (to_receipt_items.status == 0) {
//                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_receipt_items.main_barcode, to_receipt_items.barcode, to_receipt_items.location_id);
                    String s10 = "select "
                            + " product_qty"
                            + ",conversion"
                            + ",serial_no"
                            + " from inventory_barcodes where "
                            + " main_barcode='" + to_receipt_items.main_barcode + "' and location_id='" + to_receipt_items.location_id + "'"
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
                    double cost = to_receipt_items.cost / to_receipt_items.conversion;
                    double new_qty = product_qty + (to_receipt_items.conversion * to_receipt_items.qty);
                    String new_serial = serial_no + "\n" + to_receipt_items.serial_no;
                    if (serial_no.isEmpty()) {
                        new_serial = to_receipt_items.serial_no;
                    }
                    String s4 = "update inventory_barcodes set "
                            + " product_qty='" + new_qty + "'"
                            + ",cost='" + cost + "' "
                            + ",serial_no='" + new_serial + "' "
                            + " where  main_barcode= '" + to_receipt_items.main_barcode + "' and location_id='" + to_receipt_items.branch_id + "' "
                            + "";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();

                    String s5 = "update inventory set "
                            + " cost= :cost"
                            + " where "
                            + " barcode ='" + to_receipt_items.main_barcode + "' "
                            + " ";
                    s5 = SqlStringUtil.parse(s5).
                            setNumber("cost", cost).
                            ok();

                    stmt.addBatch(s5);

                }
            }

            if (is_payable == 1) {
                String customer_id = to_receipts.supllier_id;
                String customer_name = to_receipts.supplier;
                String ap_no = Accounts_payable.increment_id(branch_id);
                String date_added = DateType.now();
                String user_name = MyUser.getUser_name();
                double amount = to_receipts.gross_total;
                double discount_amount = to_receipts.discount;
                double discount_rate = 0;
                String discount = "";
                int status = 0;
                double term = 0;
                String date_applied = ap_date;
                double paid = 0;
                String date_paid = ap_date;
                String remarks = "";
                String type = "";
                String reference_no = to_receipts.receipt_no;
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();

                String location_id = "";
                String s3 = "select "
                        + "id"
                        + ",branch"
                        + ",branch_id"
                        + ",code"
                        + ",location"
                        + ",type"
                        + ",status"
                        + " from branch_locations  "
                        + " where id='" + to_receipts.branch_id + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s3);
                String branch1 = "";
                String branch_id1 = "";
                String location1 = "";
                if (rs2.next()) {
                    int id = rs2.getInt(1);
                    location_id = "" + id;
                    branch1 = rs2.getString(2);
                    branch_id1 = rs2.getString(3);

                    location1 = rs2.getString(5);

                }

                Accounts_payable.to_accounts_payable to_accounts_payable = new Accounts_payable.to_accounts_payable(0, customer_id, customer_name, ap_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, reference_no, user_id, user_screen_name, branch1, branch_id1, location1, location_id);
                String s4 = "insert into accounts_payable("
                        + " customer_id"
                        + ",customer_name"
                        + ",ap_no"
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
                        + ",reference_no"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":customer_id"
                        + ",:customer_name"
                        + ",:ap_no"
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
                        + ",:reference_no"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s4 = SqlStringUtil.parse(s4)
                        .setString("customer_id", to_accounts_payable.customer_id)
                        .setString("customer_name", to_accounts_payable.customer_name)
                        .setString("ap_no", to_accounts_payable.ap_no)
                        .setString("date_added", to_accounts_payable.date_added)
                        .setString("user_name", to_accounts_payable.user_name)
                        .setNumber("amount", to_accounts_payable.amount)
                        .setNumber("discount_amount", to_accounts_payable.discount_amount)
                        .setNumber("discount_rate", to_accounts_payable.discount_rate)
                        .setString("discount", to_accounts_payable.discount)
                        .setNumber("status", to_accounts_payable.status)
                        .setNumber("term", to_accounts_payable.term)
                        .setString("date_applied", to_accounts_payable.date_applied)
                        .setNumber("paid", to_accounts_payable.paid)
                        .setString("date_paid", to_accounts_payable.date_paid)
                        .setString("remarks", to_accounts_payable.remarks)
                        .setString("type", to_accounts_payable.type)
                        .setString("reference_no", to_accounts_payable.reference_no)
                        .setString("user_id", to_accounts_payable.user_id)
                        .setString("user_screen_name", to_accounts_payable.user_screen_name)
                        .setString("branch", to_accounts_payable.branch)
                        .setString("branch_id", to_accounts_payable.branch_id)
                        .setString("location", to_accounts_payable.location)
                        .setString("location_id", to_accounts_payable.location_id)
                        .ok();

                stmt.addBatch(s4);

                String s5 = "select "
                        + " balance"
                        + " from  suppliers  "
                        + " where customer_no='" + to_accounts_payable.customer_id + "' ";

                Statement stmt5 = conn.createStatement();
                ResultSet rs5 = stmt5.executeQuery(s5);
                double balance = 0;
                if (rs5.next()) {
                    balance = rs5.getDouble(1);
                }

                double new_balance = (to_accounts_payable.amount - to_accounts_payable.discount_amount) + balance;

                String s6 = "update  suppliers set "
                        + "balance= :balance"
                        + " where "
                        + " customer_no='" + to_accounts_payable.customer_id + "' "
                        + " ";

                s6 = SqlStringUtil.parse(s6).
                        setNumber("balance", new_balance).ok();

                stmt.addBatch(s6);

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
            String s0 = "update receipt_service_centers set "
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
                    + ",supplier_id"
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
                    + " from receipt_service_centers  "
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