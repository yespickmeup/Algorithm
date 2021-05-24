/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.receipts.Warranty_items.to_warranty_items;
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
public class Warranties {

    public static class to_warranties {

        public final int id;
        public final String transaction_no;
        public final String slip_no;
        public final String remarks;
        public final String supplier;
        public final String supplier_id;
        public final int status;
        public final String created_at;
        public final String created_by;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_warranties(int id, String transaction_no, String slip_no, String remarks, String supplier, String supplier_id, int status, String created_at, String created_by, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.transaction_no = transaction_no;
            this.slip_no = slip_no;
            this.remarks = remarks;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.status = status;
            this.created_at = created_at;
            this.created_by = created_by;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_warranties to_warranties, List<Warranty_items.to_warranty_items> to_warranty_items1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into warranties("
                    + "transaction_no"
                    + ",slip_no"
                    + ",remarks"
                    + ",supplier"
                    + ",supplier_id"
                    + ",status"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":transaction_no"
                    + ",:slip_no"
                    + ",:remarks"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:status"
                    + ",:created_at"
                    + ",:created_by"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_warranties.transaction_no)
                    .setString("slip_no", to_warranties.slip_no)
                    .setString("remarks", to_warranties.remarks)
                    .setString("supplier", to_warranties.supplier)
                    .setString("supplier_id", to_warranties.supplier_id)
                    .setNumber("status", to_warranties.status)
                    .setString("created_at", to_warranties.created_at)
                    .setString("created_by", to_warranties.created_by)
                    .setString("branch", to_warranties.branch)
                    .setString("branch_id", to_warranties.branch_id)
                    .setString("location", to_warranties.location)
                    .setString("location_id", to_warranties.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (to_warranty_items to_warranty_items : to_warranty_items1) {
                String s2 = "insert into warranty_items("
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
                        + ",slip_no"
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
                        + ",:slip_no"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("transaction_no", to_warranties.transaction_no)
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
                        .setString("slip_no", to_warranty_items.slip_no)
                        .ok();
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Warranties.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_warranties to_warranties) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update warranties set "
                    + "transaction_no= :transaction_no "
                    + ",slip_no= :slip_no "
                    + ",remarks= :remarks "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",status= :status "
                    + ",created_at= :created_at "
                    + ",created_by= :created_by "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_warranties.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_warranties.transaction_no)
                    .setString("slip_no", to_warranties.slip_no)
                    .setString("remarks", to_warranties.remarks)
                    .setString("supplier", to_warranties.supplier)
                    .setString("supplier_id", to_warranties.supplier_id)
                    .setNumber("status", to_warranties.status)
                    .setString("created_at", to_warranties.created_at)
                    .setString("created_by", to_warranties.created_by)
                    .setString("branch", to_warranties.branch)
                    .setString("branch_id", to_warranties.branch_id)
                    .setString("location", to_warranties.location)
                    .setString("location_id", to_warranties.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Warranties.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finali_data(to_warranties to_warranties, List<to_warranty_items> to_warranty_items1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update warranties set "
                    + " status= :status "
                    + " where id='" + to_warranties.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (to_warranty_items to_warranty_items : to_warranty_items1) {
                String s2 = "update warranty_items set "
                        + " status= :status "
                        + " where id='" + to_warranty_items.id + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setNumber("status", 1)
                        .ok();
                stmt.addBatch(s2);

                String s10 = "select "
                        + " product_qty"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + to_warranty_items.main_barcode + "' and location_id='" + to_warranty_items.location_id + "'"
                        + " ";
                Statement stmt10 = conn.createStatement();
                ResultSet rs10 = stmt10.executeQuery(s10);
                double product_qty = 0;

                while (rs10.next()) {
                    product_qty = rs10.getDouble(1);

                }

                double new_qty = product_qty - (to_warranty_items.conversion * to_warranty_items.qty);

                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "'"
                        + " where  main_barcode= '" + to_warranty_items.main_barcode + "' and location_id='" + to_warranty_items.location_id + "' "
                        + "";

                PreparedStatement stmt2 = conn.prepareStatement(s4);
                stmt2.execute();
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Warranties.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_warranties to_warranties) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from warranties  "
                    + " where id='" + to_warranties.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = "delete from warranty_items  "
                    + " where transaction_no='" + to_warranties.transaction_no + "' "
                    + " ";

            stmt.executeBatch();
            conn.commit();

            Lg.s(Warranties.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_warranties> ret_data(String where) {
        List<to_warranties> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",slip_no"
                    + ",remarks"
                    + ",supplier"
                    + ",supplier_id"
                    + ",status"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from warranties"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String slip_no = rs.getString(3);
                String remarks = rs.getString(4);
                String supplier = rs.getString(5);
                String supplier_id = rs.getString(6);
                int status = rs.getInt(7);
                String created_at = rs.getString(8);
                String created_by = rs.getString(9);
                String branch = rs.getString(10);
                String branch_id = rs.getString(11);
                String location = rs.getString(12);
                String location_id = rs.getString(13);

                to_warranties to = new to_warranties(id, transaction_no, slip_no, remarks, supplier, supplier_id, status, created_at, created_by, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static List<to_warranties> ret_data_with_items(String where) {
        List<to_warranties> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",slip_no"
                    + ",remarks"
                    + ",supplier"
                    + ",supplier_id"
                    + ",status"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from warranties"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String slip_no = rs.getString(3);
                String remarks = rs.getString(4);
                String supplier = rs.getString(5);
                String supplier_id = rs.getString(6);
                int status = rs.getInt(7);
                String created_at = rs.getString(8);
                String created_by2 = rs.getString(9);
                String branch = rs.getString(10);
                String branch_id = rs.getString(11);
                String location = rs.getString(12);
                String location_id = rs.getString(13);

                String s2 = "select "
                        + "count(id)"
                        + " from warranty_items"
                        + " where transaction_no like '" + transaction_no + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                int count = 0;
                while (rs2.next()) {
                    count = rs2.getInt(1);

                }
                created_by2 = "" + count;
                to_warranties to = new to_warranties(id, transaction_no, slip_no, remarks, supplier, supplier_id, status, created_at, created_by2, branch, branch_id, location, location_id);
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
            String s0 = "select max(id) from warranties";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select transaction_no from warranties where id='" + id + "'";
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
