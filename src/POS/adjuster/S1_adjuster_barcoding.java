/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.inventory.S1_inventory;
import POS.inventory.Inventory_barcodes;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_adjuster_barcoding {

    public static void edit_inventory(List<inv> inventory, List<Inventory_barcodes.to_inventory_barcodes> barcodes) {
        try {
            Connection conn = MyConnection.connect();
//            System.out.println("1.) Starting Updates on inventory ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//            for (inv in : inventory) {
//                String s0 = "update inventory set "
//                        + " barcodes= :barcodes"
//                        + " where "
//                        + " barcode ='" + in.main_barcode + "' "
//                        + " ";
//                s0 = SqlStringUtil.parse(s0).
//                        setString("barcodes", in.barcodes).
//                        ok();
//
//                PreparedStatement stmt = conn.prepareStatement(s0);
//                stmt.execute();
//                Lg.s(S1_inventory.class, "Successfully Updated");
//                System.out.println("1.) Main barcode: " + in.main_barcode + " New Barcode: " + in.barcodes);
//            }
            System.out.println("2.) Starting updates on inventory barcodes------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes : barcodes) {
                System.out.println("Qty: " + to_inventory_barcodes.product_qty + " Item Code: " + to_inventory_barcodes.main_barcode + " Barcode: " + to_inventory_barcodes.barcode + " Descripion:" + to_inventory_barcodes.description + " Location: " + to_inventory_barcodes.location);
                String s0 = "insert into inventory_barcodes("
                        + " id"
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
                        + ")values("
                        + ":id"
                        + ",:barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:cost"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:markup"
                        + ",:main_barcode"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:serial_no"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setNumber("id", to_inventory_barcodes.id).
                        setString("barcode", to_inventory_barcodes.barcode).
                        setString("description", to_inventory_barcodes.description).
                        setString("generic_name", to_inventory_barcodes.generic_name).
                        setString("category", to_inventory_barcodes.category).
                        setString("category_id", to_inventory_barcodes.category_id).
                        setString("classification", to_inventory_barcodes.classification).
                        setString("classification_id", to_inventory_barcodes.classification_id).
                        setString("sub_classification", to_inventory_barcodes.sub_classification).
                        setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                        setNumber("product_qty", to_inventory_barcodes.product_qty).
                        setString("unit", to_inventory_barcodes.unit).
                        setNumber("conversion", to_inventory_barcodes.conversion).
                        setNumber("selling_price", to_inventory_barcodes.selling_price).
                        setString("date_added", DateType.datetime.format(new Date())).
                        setString("user_name", to_inventory_barcodes.user_name).
                        setString("item_type", to_inventory_barcodes.item_type).
                        setNumber("status", 1).
                        setString("supplier", to_inventory_barcodes.supplier).
                        setNumber("fixed_price", to_inventory_barcodes.fixed_price).
                        setNumber("cost", to_inventory_barcodes.cost).
                        setString("supplier_id", to_inventory_barcodes.supplier_id).
                        setNumber("multi_level_pricing", to_inventory_barcodes.multi_level_pricing).
                        setNumber("vatable", to_inventory_barcodes.vatable).
                        setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                        setNumber("markup", to_inventory_barcodes.markup).
                        setString("main_barcode", to_inventory_barcodes.main_barcode).
                        setString("brand", to_inventory_barcodes.brand).
                        setString("brand_id", to_inventory_barcodes.brand_id).
                        setString("model", to_inventory_barcodes.model).
                        setString("model_id", to_inventory_barcodes.model_id).
                        setNumber("selling_type", to_inventory_barcodes.selling_type).
                        setString("branch", to_inventory_barcodes.branch).
                        setString("branch_code", to_inventory_barcodes.branch_code).
                        setString("location", to_inventory_barcodes.location).
                        setString("location_id", "" + to_inventory_barcodes.location_id).
                        setString("serial_no", to_inventory_barcodes.serial_no).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

//                System.out.println("Main barcode: " + to_inventory_barcodes.main_barcode + " Barcode: " + to_inventory_barcodes.barcode + " Qty: " + to_inventory_barcodes.product_qty + " " + to_inventory_barcodes.location);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class inv {

        public final String main_barcode;
        public final String barcodes;

        public inv(String main_barcode, String barcodes) {
            this.main_barcode = main_barcode;
            this.barcodes = barcodes;
        }

    }

    public static void delete_inventory() {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_barcodes  "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory.class, "Successfully Deleted");
            System.out.println("Deleting inventory_barcodes....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static List<Inventory_barcodes.to_inventory_barcodes> ret_where(String where) {
        List<Inventory_barcodes.to_inventory_barcodes> datas = new ArrayList();

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
                    + ",count(*) as c"
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
}
