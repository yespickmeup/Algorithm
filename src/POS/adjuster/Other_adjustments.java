/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

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
public class Other_adjustments {

    public static class to_other_adjustments {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String adjustment_date;
        public final int adjustment_type;
        public final String remarks;
        public final int status;
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
        public final String main_barcode;
        public final double previous_qty;
        public final double qty;
        public final double cost;
        public final double selling_price;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_other_adjustments(int id, String user_id, String user_screen_name, String date_added, String adjustment_date, int adjustment_type, String remarks, int status, String barcode, String description, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, String brand, String brand_id, String model, String model_id, double conversion, String unit, String barcodes, String main_barcode, double previous_qty, double qty, double cost, double selling_price, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.adjustment_date = adjustment_date;
            this.adjustment_type = adjustment_type;
            this.remarks = remarks;
            this.status = status;
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
            this.main_barcode = main_barcode;
            this.previous_qty = previous_qty;
            this.qty = qty;
            this.cost = cost;
            this.selling_price = selling_price;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_other_adjustments to_other_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into other_adjustments("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",adjustment_date"
                    + ",adjustment_type"
                    + ",remarks"
                    + ",status"
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
                    + ",main_barcode"
                    + ",previous_qty"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:adjustment_date"
                    + ",:adjustment_type"
                    + ",:remarks"
                    + ",:status"
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
                    + ",:main_barcode"
                    + ",:previous_qty"
                    + ",:qty"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_other_adjustments.user_id)
                    .setString("user_screen_name", to_other_adjustments.user_screen_name)
                    .setString("date_added", to_other_adjustments.date_added)
                    .setString("adjustment_date", to_other_adjustments.adjustment_date)
                    .setNumber("adjustment_type", to_other_adjustments.adjustment_type)
                    .setString("remarks", to_other_adjustments.remarks)
                    .setNumber("status", to_other_adjustments.status)
                    .setString("barcode", to_other_adjustments.barcode)
                    .setString("description", to_other_adjustments.description)
                    .setString("category", to_other_adjustments.category)
                    .setString("category_id", to_other_adjustments.category_id)
                    .setString("classification", to_other_adjustments.classification)
                    .setString("classification_id", to_other_adjustments.classification_id)
                    .setString("sub_class", to_other_adjustments.sub_class)
                    .setString("sub_class_id", to_other_adjustments.sub_class_id)
                    .setString("brand", to_other_adjustments.brand)
                    .setString("brand_id", to_other_adjustments.brand_id)
                    .setString("model", to_other_adjustments.model)
                    .setString("model_id", to_other_adjustments.model_id)
                    .setNumber("conversion", to_other_adjustments.conversion)
                    .setString("unit", to_other_adjustments.unit)
                    .setString("barcodes", to_other_adjustments.barcodes)
                    .setString("main_barcode", to_other_adjustments.main_barcode)
                    .setNumber("previous_qty", to_other_adjustments.previous_qty)
                    .setNumber("qty", to_other_adjustments.qty)
                    .setNumber("cost", to_other_adjustments.cost)
                    .setNumber("selling_price", to_other_adjustments.selling_price)
                    .setString("branch", to_other_adjustments.branch)
                    .setString("branch_id", to_other_adjustments.branch_id)
                    .setString("location", to_other_adjustments.location)
                    .setString("location_id", to_other_adjustments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Other_adjustments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_other_adjustments to_other_adjustments) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into other_adjustments("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",adjustment_date"
                    + ",adjustment_type"
                    + ",remarks"
                    + ",status"
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
                    + ",main_barcode"
                    + ",previous_qty"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:adjustment_date"
                    + ",:adjustment_type"
                    + ",:remarks"
                    + ",:status"
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
                    + ",:main_barcode"
                    + ",:previous_qty"
                    + ",:qty"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_other_adjustments.user_id)
                    .setString("user_screen_name", to_other_adjustments.user_screen_name)
                    .setString("date_added", to_other_adjustments.date_added)
                    .setString("adjustment_date", to_other_adjustments.adjustment_date)
                    .setNumber("adjustment_type", to_other_adjustments.adjustment_type)
                    .setString("remarks", to_other_adjustments.remarks)
                    .setNumber("status", to_other_adjustments.status)
                    .setString("barcode", to_other_adjustments.barcode)
                    .setString("description", to_other_adjustments.description)
                    .setString("category", to_other_adjustments.category)
                    .setString("category_id", to_other_adjustments.category_id)
                    .setString("classification", to_other_adjustments.classification)
                    .setString("classification_id", to_other_adjustments.classification_id)
                    .setString("sub_class", to_other_adjustments.sub_class)
                    .setString("sub_class_id", to_other_adjustments.sub_class_id)
                    .setString("brand", to_other_adjustments.brand)
                    .setString("brand_id", to_other_adjustments.brand_id)
                    .setString("model", to_other_adjustments.model)
                    .setString("model_id", to_other_adjustments.model_id)
                    .setNumber("conversion", to_other_adjustments.conversion)
                    .setString("unit", to_other_adjustments.unit)
                    .setString("barcodes", to_other_adjustments.barcodes)
                    .setString("main_barcode", to_other_adjustments.main_barcode)
                    .setNumber("previous_qty", to_other_adjustments.previous_qty)
                    .setNumber("qty", to_other_adjustments.qty)
                    .setNumber("cost", to_other_adjustments.cost)
                    .setNumber("selling_price", to_other_adjustments.selling_price)
                    .setString("branch", to_other_adjustments.branch)
                    .setString("branch_id", to_other_adjustments.branch_id)
                    .setString("location", to_other_adjustments.location)
                    .setString("location_id", to_other_adjustments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update other_adjustments set is_uploaded=1 where id='" + to_other_adjustments.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Other_adjustments.class, "Successfully Added: " + to_other_adjustments.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_other_adjustments to_other_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update other_adjustments set "
                    + " adjustment_date= :adjustment_date "
                    + ",adjustment_type= :adjustment_type "
                    + ",remarks= :remarks "
                    + ",qty= :qty "
                    + " where id='" + to_other_adjustments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("adjustment_date", to_other_adjustments.adjustment_date)
                    .setNumber("adjustment_type", to_other_adjustments.adjustment_type)
                    .setString("remarks", to_other_adjustments.remarks)
                    .setNumber("qty", to_other_adjustments.qty)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Other_adjustments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_other_adjustments to_other_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update other_adjustments  set status=2 "
                    + " where id='" + to_other_adjustments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            if (to_other_adjustments.status == 1) {
                String s11 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + to_other_adjustments.main_barcode + "' and location_id='" + to_other_adjustments.location_id + "'"
                        + " ";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                double product_qty2 = 0;
                double conversion2 = 0;
                String serial_no2 = "";
                while (rs11.next()) {
                    product_qty2 = rs11.getDouble(1);
                    conversion2 = rs11.getDouble(2);
                    serial_no2 = rs11.getString(3);
                }

                double new_qty = product_qty2 + (to_other_adjustments.conversion * to_other_adjustments.qty);
                if (to_other_adjustments.adjustment_type == 4) {
                    new_qty = product_qty2 - (to_other_adjustments.conversion * to_other_adjustments.qty);
                }
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + to_other_adjustments.main_barcode + "' and location_id='" + to_other_adjustments.location_id + "' "
                        + "";

                stmt.addBatch(s4);
            }

            Lg.s(Other_adjustments.class, "Successfully Deleted");

            stmt.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_data(to_other_adjustments to_other_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update other_adjustments  set status=1 "
                    + " where id='" + to_other_adjustments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s11 = "select "
                    + " product_qty"
                    + ",conversion"
                    + ",serial_no"
                    + " from inventory_barcodes where "
                    + " main_barcode='" + to_other_adjustments.main_barcode + "' and location_id='" + to_other_adjustments.location_id + "'"
                    + " ";
            Statement stmt11 = conn.createStatement();
            ResultSet rs11 = stmt11.executeQuery(s11);
            double product_qty2 = 0;
            double conversion2 = 0;
            String serial_no2 = "";
            while (rs11.next()) {
                product_qty2 = rs11.getDouble(1);
                conversion2 = rs11.getDouble(2);
                serial_no2 = rs11.getString(3);
            }

            double new_qty = product_qty2 - (to_other_adjustments.conversion * to_other_adjustments.qty);
            if (to_other_adjustments.adjustment_type == 4) {
                new_qty = product_qty2 + (to_other_adjustments.conversion * to_other_adjustments.qty);
            }
            String s4 = "update inventory_barcodes set "
                    + " product_qty='" + new_qty + "' "
                    + " where main_barcode= '" + to_other_adjustments.main_barcode + "' and location_id='" + to_other_adjustments.location_id + "' "
                    + "";

            stmt.addBatch(s4);

            Lg.s(Other_adjustments.class, "Successfully Deleted");

            stmt.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_other_adjustments> ret_data(String where) {
        List<to_other_adjustments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",adjustment_date"
                    + ",adjustment_type"
                    + ",remarks"
                    + ",status"
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
                    + ",main_barcode"
                    + ",previous_qty"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from other_adjustments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String adjustment_date = rs.getString(5);
                int adjustment_type = rs.getInt(6);
                String remarks = rs.getString(7);
                int status = rs.getInt(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                String category = rs.getString(11);
                String category_id = rs.getString(12);
                String classification = rs.getString(13);
                String classification_id = rs.getString(14);
                String sub_class = rs.getString(15);
                String sub_class_id = rs.getString(16);
                String brand = rs.getString(17);
                String brand_id = rs.getString(18);
                String model = rs.getString(19);
                String model_id = rs.getString(20);
                double conversion = rs.getDouble(21);
                String unit = rs.getString(22);
                String barcodes = rs.getString(23);
                String main_barcode = rs.getString(24);
                double previous_qty = rs.getDouble(25);
                double qty = rs.getDouble(26);
                double cost = rs.getDouble(27);
                double selling_price = rs.getDouble(28);
                String branch = rs.getString(29);
                String branch_id = rs.getString(30);
                String location = rs.getString(31);
                String location_id = rs.getString(32);

                to_other_adjustments to = new to_other_adjustments(id, user_id, user_screen_name, date_added, adjustment_date, adjustment_type, remarks, status, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, main_barcode, previous_qty, qty, cost, selling_price, branch, branch_id, location, location_id);
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
