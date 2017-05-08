/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.encoding_inventory;

import POS.encoding_inventory.Encoding_inventory.to_encoding_inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.Inventory_barcodes.to_inventory_barcodes;
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
 * @author Ronald
 */
public class S1_finalize_encoding {

    public static List<to_encoding_inventory> ret_data(String where) {
        List<to_encoding_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",qty"
                    + ",date_added"
                    + ",user_name"
                    + ",screen_name"
                    + ",sheet_no"
                    + ",status"
                    + ",counted_by"
                    + ",checked_by"
                    + ",status"
                    + ",cost"
                    + ",selling_price"
                    + ",user_id"
                    + ",user_screen_name"
                    + " from encoding_inventory  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = rs.getString(7);
                String location_id = rs.getString(8);
                double qty = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_name = rs.getString(11);
                String screen_name = rs.getString(12);
                String sheet_no = rs.getString(13);
                int status = rs.getInt(14);
                String counted_by = rs.getString(15);
                String checked_by = rs.getString(16);
                double cost = rs.getDouble(18);
                double selling_price = rs.getDouble(19);
                String user_id = rs.getString(20);
                String user_screen_name = rs.getString(21);

                to_encoding_inventory to = new to_encoding_inventory(id, item_code, barcode, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, status, counted_by, checked_by, cost, selling_price, user_id, user_screen_name);

                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_encoding_inventory(List<to_encoding_inventory> to_encoding_inventory1, int update_pricing) {
        try {
            System.out.println("Finalizing...");
            Connection conn = MyConnection.connect();
            for (to_encoding_inventory to_encoding_inventory : to_encoding_inventory1) {
                if (to_encoding_inventory.status == 0) {

                    String s0 = "update encoding_inventory set "
                            + " status= :status"
                            + " where "
                            + " id ='" + to_encoding_inventory.id + "' "
                            + " ";

                    s0 = SqlStringUtil.parse(s0)
                            .setNumber("status", 1)
                            .ok();
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(Encoding_inventory.class, "Successfully Updated");

                    double my_qty = 0;
                    String unit = "";
                    double conversion = 0;
                    String s3 = "select"
                            + " product_qty"
                            + " ,unit"
                            + " ,conversion"
                            + " from inventory_barcodes where "
                            + " barcode ='" + to_encoding_inventory.barcode + "' "
                            + " and main_barcode ='" + to_encoding_inventory.item_code + "' "
                            + " and location_id ='" + to_encoding_inventory.location_id + "' "
                            + " ";
                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery(s3);
                    if (rs3.next()) {
                        my_qty = rs3.getDouble(1);
                        unit = rs3.getString(2);
                        conversion = rs3.getDouble(3);
                    }

                    double new_qty = my_qty + to_encoding_inventory.qty;
                    String s2 = " update inventory_barcodes set "
                            + " product_qty= :product_qty"
                            + " where "
                            + " main_barcode ='" + to_encoding_inventory.item_code + "' "
                            + " and location_id='" + to_encoding_inventory.location_id + "'"
                            + " ";
                    s2 = SqlStringUtil.parse(s2)
                            .setNumber("product_qty", new_qty)
                            .ok();
                    if (update_pricing == 1) {
                        s2 = " update inventory_barcodes set "
                                + " unit= :unit"
                                + " ,conversion= :conversion"
                                + " ,selling_price= :selling_price"
                                + " ,cost= :cost"
                                + " where "
                                + "  main_barcode ='" + to_encoding_inventory.item_code + "' "
                                + " and branch_code='" + to_encoding_inventory.branch_id + "'"
                                + " ";
                        String units = "[" + "pc" + ":" + to_encoding_inventory.selling_price + "/" + conversion + "^1" + "]";
                        s2 = SqlStringUtil.parse(s2)
                                .setString("unit", units)
                                .setNumber("conversion", conversion)
                                .setNumber("selling_price", to_encoding_inventory.selling_price)
                                .setNumber("cost", to_encoding_inventory.cost)
                                .ok();
                    }

                    System.out.println(s2);
                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();
                    Lg.s(Inventory_barcodes.class, "Successfully Updated" + " : " + to_encoding_inventory.barcode + " : " + to_encoding_inventory.item_code + " : " + to_encoding_inventory.location_id);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void rollback_encoding(List<to_encoding_inventory> to_encoding_inventory1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_encoding_inventory to_encoding_inventory : to_encoding_inventory1) {
                if (to_encoding_inventory.status == 1) {
                    String s0 = "update encoding_inventory set "
                            + " status= :status"
                            + " where "
                            + " id ='" + to_encoding_inventory.id + "' "
                            + " ";

                    s0 = SqlStringUtil.parse(s0)
                            .setNumber("status", 1)
                            .ok();
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(Encoding_inventory.class, "Successfully Updated");

                    double my_qty = 0;
                    String s3 = "select product_qty"
                            + " from inventory_barcodes where "
                            + " barcode ='" + to_encoding_inventory.barcode + "' "
                            + " and main_barcode ='" + to_encoding_inventory.item_code + "' "
                            + " and location_id ='" + to_encoding_inventory.location_id + "' "
                            + " ";
                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt.executeQuery(s3);
                    if (rs3.next()) {
                        my_qty = rs3.getDouble(1);
                    }
                    double new_qty = my_qty - to_encoding_inventory.qty;
                    String s2 = "update inventory_barcodes set "
                            + " product_qty= :product_qty"
                            + " where "
                            + " main_barcode ='" + to_encoding_inventory.item_code + "' and location_id='" + to_encoding_inventory.location_id + "'"
                            + " ";
                    s2 = SqlStringUtil.parse(s2)
                            .setNumber("product_qty", new_qty)
                            .ok();

                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();
                    Lg.s(Inventory_barcodes.class, "Successfully Updated" + " : " + to_encoding_inventory.barcode + " : " + to_encoding_inventory.item_code + " : " + to_encoding_inventory.location);

                    String s4 = " delete from encoding_inventory where id='" + to_encoding_inventory.id + "' ";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_inventory_barcodes ret_qty(String barcodes, String item_codes, String location_ids) {
        to_inventory_barcodes to1 = null;

        try {
            Connection conn = MyConnection.connect();
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
                    + " from inventory_barcodes where "
                    + " barcode ='" + barcodes + "' "
                    + " and main_barcode ='" + item_codes + "' "
                    + " and location_id ='" + location_ids + "' "
                    + " ";

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
                to1 = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
