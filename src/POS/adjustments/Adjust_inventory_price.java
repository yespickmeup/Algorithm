/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.inventory.Inventory_barcodes;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Adjust_inventory_price {

    public static List<Inventory_barcodes.to_inventory_barcodes> ret_where(String where, String db_name) throws ClassNotFoundException {
        List<Inventory_barcodes.to_inventory_barcodes> datas = new ArrayList();
        try {

            String host = System.getProperty("pool_host", "localhost");
            String port = System.getProperty("pool_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(url);
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",serial_no"
                    + " from inventory_barcodes "
                    + " " + where;
            System.out.println(where);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                String main_barcode = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);

                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String serial_no = rs.getString(37);
                Inventory_barcodes.to_inventory_barcodes to = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_item(List<Inventory_barcodes.to_inventory_barcodes> items) {
        try {
            Connection conn = MyConnection.connect();

            for (Inventory_barcodes.to_inventory_barcodes to : items) {

                String s2 = "update inventory_barcodes set "
                        + " unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where main_barcode='" + to.main_barcode + "' and location_id='" + to.location_id + "' ";
                s2 = SqlStringUtil.parse(s2).
                        setString("unit", to.unit).
                        setNumber("conversion", to.conversion).
                        setNumber("selling_price", to.selling_price).
                        ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Inventory_barcodes.class, "Item Code: " + to.main_barcode + " | " + to.description + " - Successfully Updated!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_item_cloud(List<Dlg_match_branch_prices.field> items) {
        try {
            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);
            for (Dlg_match_branch_prices.field to : items) {

                String s2 = "update inventory_barcodes set "
                        + " unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where main_barcode='" + to.item_code + "' and branch_code='" + to.branch_id + "' ";
                s2 = SqlStringUtil.parse(s2).
                        setString("unit", to.local_uom).
                        setNumber("conversion", to.local_conversion).
                        setNumber("selling_price", to.local_price).
                        ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.addBatch(s2);

                String s3 = "update inventory set "
                        + " unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where barcode='" + to.item_code + "' ";
                s3 = SqlStringUtil.parse(s3).
                        setString("unit", to.local_uom).
                        setNumber("conversion", to.local_conversion).
                        setNumber("selling_price", to.local_price).
                        ok();

                stmt2.addBatch(s3);

                stmt2.executeBatch();
                conn.commit();
                Lg.s(Inventory_barcodes.class, "Item Code: " + to.item_code + " | " + to.description + " - Successfully Updated!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_item_local(List<Dlg_match_branch_prices.field> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            for (Dlg_match_branch_prices.field to : items) {

                String s2 = "update inventory_barcodes set "
                        + " unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where main_barcode='" + to.item_code + "' and branch_code='" + to.local_branch_id + "' ";
                s2 = SqlStringUtil.parse(s2).
                        setString("unit", to.cloud_uom).
                        setNumber("conversion", to.cloud_conversion).
                        setNumber("selling_price", to.cloud_price).
                        ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.addBatch(s2);

                String s3 = "update inventory set "
                        + " unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where barcode='" + to.item_code + "' ";
                s3 = SqlStringUtil.parse(s3).
                        setString("unit", to.cloud_uom).
                        setNumber("conversion", to.cloud_conversion).
                        setNumber("selling_price", to.cloud_price).
                        ok();

                stmt2.addBatch(s3);

                stmt2.executeBatch();
                
                conn.commit();
                System.out.println(s2);
                System.out.println(s3);
                System.out.println("--------------------------");
//                Lg.s(Inventory_barcodes.class, "Item Code: " + to.item_code + " | " + to.description + " - Successfully Updated!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
