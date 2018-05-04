/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.conversion;

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
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Conversions {

    public static class to_conversions {

        public final int id;
        public final String conversion_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String reference_no;
        public final String remarks;
        public final int status;
        public final String from_branch;
        public final String from_branch_id;
        public final String from_location;
        public final String from_location_id;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;

        public to_conversions(int id, String conversion_no, String user_name, String session_no, String date_added, String reference_no, String remarks, int status, String from_branch, String from_branch_id, String from_location, String from_location_id, String to_branch, String to_branch_id, String to_location, String to_location_id) {
            this.id = id;
            this.conversion_no = conversion_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.reference_no = reference_no;
            this.remarks = remarks;
            this.status = status;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
        }
    }

    public static void add_data(to_conversions to_conversions, List<Conversion_items.to_conversion_items> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into conversions("
                    + "conversion_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",reference_no"
                    + ",remarks"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ")values("
                    + ":conversion_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:reference_no"
                    + ",:remarks"
                    + ",:status"
                    + ",:from_branch"
                    + ",:from_branch_id"
                    + ",:from_location"
                    + ",:from_location_id"
                    + ",:to_branch"
                    + ",:to_branch_id"
                    + ",:to_location"
                    + ",:to_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("conversion_no", to_conversions.conversion_no)
                    .setString("user_name", to_conversions.user_name)
                    .setString("session_no", to_conversions.session_no)
                    .setString("date_added", to_conversions.date_added)
                    .setString("reference_no", to_conversions.reference_no)
                    .setString("remarks", to_conversions.remarks)
                    .setNumber("status", to_conversions.status)
                    .setString("from_branch", to_conversions.from_branch)
                    .setString("from_branch_id", to_conversions.from_branch_id)
                    .setString("from_location", to_conversions.from_location)
                    .setString("from_location_id", to_conversions.from_location_id)
                    .setString("to_branch", to_conversions.to_branch)
                    .setString("to_branch_id", to_conversions.to_branch_id)
                    .setString("to_location", to_conversions.to_location)
                    .setString("to_location_id", to_conversions.to_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Conversion_items.to_conversion_items to_conversion_items : items) {
                String s2 = "insert into conversion_items("
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

                s2 = SqlStringUtil.parse(s2)
                        .setString("conversion_no", to_conversions.conversion_no)
                        .setString("user_name", to_conversion_items.user_name)
                        .setString("session_no", to_conversion_items.session_no)
                        .setString("date_added", to_conversion_items.date_added)
                        .setString("reference_no", to_conversion_items.reference_no)
                        .setString("remarks", to_conversions.remarks)
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
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Conversions.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_conversions to_conversions) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into conversions("
                    + "conversion_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",reference_no"
                    + ",remarks"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ")values("
                    + ":conversion_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:reference_no"
                    + ",:remarks"
                    + ",:status"
                    + ",:from_branch"
                    + ",:from_branch_id"
                    + ",:from_location"
                    + ",:from_location_id"
                    + ",:to_branch"
                    + ",:to_branch_id"
                    + ",:to_location"
                    + ",:to_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("conversion_no", to_conversions.conversion_no)
                    .setString("user_name", to_conversions.user_name)
                    .setString("session_no", to_conversions.session_no)
                    .setString("date_added", to_conversions.date_added)
                    .setString("reference_no", to_conversions.reference_no)
                    .setString("remarks", to_conversions.remarks)
                    .setNumber("status", to_conversions.status)
                    .setString("from_branch", to_conversions.from_branch)
                    .setString("from_branch_id", to_conversions.from_branch_id)
                    .setString("from_location", to_conversions.from_location)
                    .setString("from_location_id", to_conversions.from_location_id)
                    .setString("to_branch", to_conversions.to_branch)
                    .setString("to_branch_id", to_conversions.to_branch_id)
                    .setString("to_location", to_conversions.to_location)
                    .setString("to_location_id", to_conversions.to_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update conversions set is_uploaded=1 where id='" + to_conversions.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();

            Lg.s(Conversions.class, "Successfully Added: " + to_conversions.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_data(to_conversions to_conversions) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update conversions set "
                    + "conversion_no= :conversion_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",reference_no= :reference_no "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",from_branch= :from_branch "
                    + ",from_branch_id= :from_branch_id "
                    + ",from_location= :from_location "
                    + ",from_location_id= :from_location_id "
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + " where id='" + to_conversions.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("conversion_no", to_conversions.conversion_no)
                    .setString("user_name", to_conversions.user_name)
                    .setString("session_no", to_conversions.session_no)
                    .setString("date_added", to_conversions.date_added)
                    .setString("reference_no", to_conversions.reference_no)
                    .setString("remarks", to_conversions.remarks)
                    .setNumber("status", to_conversions.status)
                    .setString("from_branch", to_conversions.from_branch)
                    .setString("from_branch_id", to_conversions.from_branch_id)
                    .setString("from_location", to_conversions.from_location)
                    .setString("from_location_id", to_conversions.from_location_id)
                    .setString("to_branch", to_conversions.to_branch)
                    .setString("to_branch_id", to_conversions.to_branch_id)
                    .setString("to_location", to_conversions.to_location)
                    .setString("to_location_id", to_conversions.to_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Conversions.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_conversion(to_conversions to_conversions, String remarks) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update conversions set "
                    + " remarks= :remarks "
                    + " where id='" + to_conversions.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("remarks", remarks)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update conversion_items set "
                    + " remarks= :remarks "
                    + " where conversion_no='" + remarks + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("remarks", to_conversions.remarks)
                    .ok();

            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            Lg.s(Conversions.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize(to_conversions to_conversions, List<Conversion_items.to_conversion_items> from_items, List<Conversion_items.to_conversion_items> to_items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update conversions set "
                    + " status= :status "
                    + " where id='" + to_conversions.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update conversion_items set "
                    + " status= :status "
                    + " where conversion_no='" + to_conversions.conversion_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 1)
                    .ok();

            stmt.addBatch(s2);

            for (Conversion_items.to_conversion_items item : from_items) {
                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(item.main_barcode, item.barcodes, item.from_location_id);
                double new_qty = tt.product_qty - (item.conversion * item.qty);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + item.main_barcode + "' and location_id='" + item.from_location_id + "' "
                        + "";

                stmt.addBatch(s4);
            }
            for (Conversion_items.to_conversion_items item : to_items) {
                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(item.main_barcode, item.barcodes, item.from_location_id);
                double new_qty = tt.product_qty + (item.conversion * item.qty);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + item.main_barcode + "' and location_id='" + item.to_location_id + "' "
                        + "";

                stmt.addBatch(s4);
            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Conversions.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_conversions to_conversions) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from conversions  "
                    + " where id='" + to_conversions.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "delete from conversion_items  "
                    + " where conversion_no='" + to_conversions.conversion_no + "' "
                    + " ";

            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Conversions.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_conversions> ret_data(String where) {
        List<to_conversions> datas = new ArrayList();
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
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + " from conversions"
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
                int status = rs.getInt(8);
                String from_branch = rs.getString(9);
                String from_branch_id = rs.getString(10);
                String from_location = rs.getString(11);
                String from_location_id = rs.getString(12);
                String to_branch = rs.getString(13);
                String to_branch_id = rs.getString(14);
                String to_location = rs.getString(15);
                String to_location_id = rs.getString(16);

                to_conversions to = new to_conversions(id, conversion_no, user_name, session_no, date_added, reference_no, remarks, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id);
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
        String id = "000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from conversions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select conversion_no from conversions where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000000000";
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
