/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

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
public class Return_to_supplier {

    public static class to_return_to_suppliers {

        public final int id;
        public final String return_to_supplier_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supplier_id;
        public final String reference_no;
        public final String remarks;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final double gross_total;
        public final String discount;
        public final double discount_amount;
        public final double discount_rate;

        public to_return_to_suppliers(int id, String return_to_supplier_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String reference_no, String remarks, int status, String branch, String branch_id, String location, String location_id, double gross_total, String discount, double discount_amount, double discount_rate) {
            this.id = id;
            this.return_to_supplier_no = return_to_supplier_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.reference_no = reference_no;
            this.remarks = remarks;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.gross_total = gross_total;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.discount_rate = discount_rate;
        }
    }

    public static void add_data(to_return_to_suppliers to_return_to_suppliers, List<Return_to_supplier_items.to_return_to_supplier_items> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into return_to_suppliers("
                    + "return_to_supplier_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",reference_no"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ")values("
                    + ":return_to_supplier_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:reference_no"
                    + ",:remarks"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:gross_total"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:discount_rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("return_to_supplier_no", to_return_to_suppliers.return_to_supplier_no)
                    .setString("user_name", to_return_to_suppliers.user_name)
                    .setString("session_no", to_return_to_suppliers.session_no)
                    .setString("date_added", to_return_to_suppliers.date_added)
                    .setString("supplier", to_return_to_suppliers.supplier)
                    .setString("supplier_id", to_return_to_suppliers.supplier_id)
                    .setString("reference_no", to_return_to_suppliers.reference_no)
                    .setString("remarks", to_return_to_suppliers.remarks)
                    .setNumber("status", to_return_to_suppliers.status)
                    .setString("branch", to_return_to_suppliers.branch)
                    .setString("branch_id", to_return_to_suppliers.branch_id)
                    .setString("location", to_return_to_suppliers.location)
                    .setString("location_id", to_return_to_suppliers.location_id)
                    .setNumber("gross_total", to_return_to_suppliers.gross_total)
                    .setString("discount", to_return_to_suppliers.discount)
                    .setNumber("discount_amount", to_return_to_suppliers.discount_amount)
                    .setNumber("discount_rate", to_return_to_suppliers.discount_rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Return_to_supplier_items.to_return_to_supplier_items to_return_to_supplier_items : items) {
                String s2 = "insert into return_to_supplier_items("
                        + "return_to_supplier_no"
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
                        + ":return_to_supplier_no"
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

                s2 = SqlStringUtil.parse(s2)
                        .setString("return_to_supplier_no", to_return_to_suppliers.return_to_supplier_no)
                        .setString("user_name", to_return_to_suppliers.user_name)
                        .setString("session_no", to_return_to_suppliers.session_no)
                        .setString("date_added", to_return_to_suppliers.date_added)
                        .setString("supplier", to_return_to_suppliers.supplier)
                        .setString("supplier_id", to_return_to_suppliers.supplier_id)
                        .setString("reference_no", to_return_to_suppliers.reference_no)
                        .setString("remarks", to_return_to_supplier_items.remarks)
                        .setString("barcode", to_return_to_supplier_items.barcode)
                        .setString("description", to_return_to_supplier_items.description)
                        .setString("category", to_return_to_supplier_items.category)
                        .setString("category_id", to_return_to_supplier_items.category_id)
                        .setString("classification", to_return_to_supplier_items.classification)
                        .setString("classification_id", to_return_to_supplier_items.classification_id)
                        .setString("sub_class", to_return_to_supplier_items.sub_class)
                        .setString("sub_class_id", to_return_to_supplier_items.sub_class_id)
                        .setString("brand", to_return_to_supplier_items.brand)
                        .setString("brand_id", to_return_to_supplier_items.brand_id)
                        .setString("model", to_return_to_supplier_items.model)
                        .setString("model_id", to_return_to_supplier_items.model_id)
                        .setNumber("conversion", to_return_to_supplier_items.conversion)
                        .setString("unit", to_return_to_supplier_items.unit)
                        .setString("barcodes", to_return_to_supplier_items.barcodes)
                        .setString("batch_no", to_return_to_supplier_items.batch_no)
                        .setString("serial_no", to_return_to_supplier_items.serial_no)
                        .setString("main_barcode", to_return_to_supplier_items.main_barcode)
                        .setNumber("qty", to_return_to_supplier_items.qty)
                        .setNumber("cost", to_return_to_supplier_items.cost)
                        .setNumber("status", to_return_to_suppliers.status)
                        .setString("branch", to_return_to_suppliers.branch)
                        .setString("branch_id", to_return_to_suppliers.branch_id)
                        .setString("location", to_return_to_suppliers.location)
                        .setString("location_id", to_return_to_suppliers.location_id)
                        .ok();
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Return_to_supplier.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_return_to_suppliers to_return_to_suppliers) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into return_to_suppliers("
                    + "return_to_supplier_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",reference_no"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ")values("
                    + ":return_to_supplier_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:reference_no"
                    + ",:remarks"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:gross_total"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:discount_rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("return_to_supplier_no", to_return_to_suppliers.return_to_supplier_no)
                    .setString("user_name", to_return_to_suppliers.user_name)
                    .setString("session_no", to_return_to_suppliers.session_no)
                    .setString("date_added", to_return_to_suppliers.date_added)
                    .setString("supplier", to_return_to_suppliers.supplier)
                    .setString("supplier_id", to_return_to_suppliers.supplier_id)
                    .setString("reference_no", to_return_to_suppliers.reference_no)
                    .setString("remarks", to_return_to_suppliers.remarks)
                    .setNumber("status", to_return_to_suppliers.status)
                    .setString("branch", to_return_to_suppliers.branch)
                    .setString("branch_id", to_return_to_suppliers.branch_id)
                    .setString("location", to_return_to_suppliers.location)
                    .setString("location_id", to_return_to_suppliers.location_id)
                    .setNumber("gross_total", to_return_to_suppliers.gross_total)
                    .setString("discount", to_return_to_suppliers.discount)
                    .setNumber("discount_amount", to_return_to_suppliers.discount_amount)
                    .setNumber("discount_rate", to_return_to_suppliers.discount_rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update return_to_suppliers set is_uploaded=1 where id='" + to_return_to_suppliers.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Return_to_supplier.class, "Successfully Added: " + to_return_to_suppliers.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_return_to_suppliers to_return_to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update return_to_suppliers set "
                    + " date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",reference_no= :reference_no "
                    + ",remarks= :remarks "
                    + ",gross_total= :gross_total "
                    + ",discount= :discount "
                    + ",discount_amount= :discount_amount "
                    + ",discount_rate= :discount_rate "
                    + " where id='" + to_return_to_suppliers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("date_added", to_return_to_suppliers.date_added)
                    .setString("supplier", to_return_to_suppliers.supplier)
                    .setString("supplier_id", to_return_to_suppliers.supplier_id)
                    .setString("reference_no", to_return_to_suppliers.reference_no)
                    .setString("remarks", to_return_to_suppliers.remarks)
                    .setNumber("gross_total", to_return_to_suppliers.gross_total)
                    .setString("discount", to_return_to_suppliers.discount)
                    .setNumber("discount_amount", to_return_to_suppliers.discount_amount)
                    .setNumber("discount_rate", to_return_to_suppliers.discount_rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update return_to_supplier_items set "
                    + " date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",reference_no= :reference_no "
                    + ",remarks= :remarks "
                    + " where return_to_supplier_no='" + to_return_to_suppliers.return_to_supplier_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("date_added", to_return_to_suppliers.date_added)
                    .setString("supplier", to_return_to_suppliers.supplier)
                    .setString("supplier_id", to_return_to_suppliers.supplier_id)
                    .setString("reference_no", to_return_to_suppliers.reference_no)
                    .setString("remarks", to_return_to_suppliers.remarks)
                    .ok();

            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            Lg.s(Return_to_supplier.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize(to_return_to_suppliers to_return_to_suppliers, List<Return_to_supplier_items.to_return_to_supplier_items> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update return_to_suppliers set "
                    + " status= :status "
                    + " where id='" + to_return_to_suppliers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update return_to_supplier_items set "
                    + " status= :status "
                    + " where return_to_supplier_no='" + to_return_to_suppliers.return_to_supplier_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 1)
                    .ok();
            stmt.addBatch(s2);

            for (Return_to_supplier_items.to_return_to_supplier_items item : items) {

                String s10 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + item.main_barcode + "' and location_id='" + item.location_id + "'"
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

                double new_qty = product_qty - (item.conversion * item.qty);

                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "'"
                        + " where  main_barcode= '" + item.main_barcode + "' and location_id='" + item.location_id + "' "
                        + "";
//                System.out.println(s4);
                stmt.addBatch(s4);

            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Return_to_supplier.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_return_to_suppliers to_return_to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from return_to_suppliers  "
                    + " where id='" + to_return_to_suppliers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "delete from return_to_supplier_items  "
                    + " where return_to_supplier_no='" + to_return_to_suppliers.return_to_supplier_no + "' "
                    + " ";

            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Return_to_supplier.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_return_to_suppliers> ret_data(String where) {
        List<to_return_to_suppliers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",return_to_supplier_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",reference_no"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + " from return_to_suppliers"
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
                int status = rs.getInt(10);
                String branch = rs.getString(11);
                String branch_id = rs.getString(12);
                String location = rs.getString(13);
                String location_id = rs.getString(14);
                double gross_total = rs.getDouble(15);
                String discount = rs.getString(16);
                double discount_amount = rs.getDouble(17);
                double discount_rate = rs.getDouble(18);

                to_return_to_suppliers to = new to_return_to_suppliers(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, status, branch, branch_id, location, location_id, gross_total, discount, discount_amount, discount_rate);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id(String branch_id) {
        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from return_to_suppliers where branch_id='" + branch_id + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select return_to_supplier_no from return_to_suppliers where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = branch_id + "|" + "000000000000";
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
