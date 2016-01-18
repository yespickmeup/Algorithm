/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_inventory_assembly {

    public static class to_inventory_assembly {

        public final int id;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String supplier;
        public final int fixed_price;
        public final double cost;
        public final String supplier_id;
        public final int multi_level_pricing;
        public final int vatable;
        public final double reorder_level;
        public final double markup;
        public final String main_barcode;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int selling_type;
        public final String branch;
        public final String branch_code;

        public to_inventory_assembly(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String main_barcode, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.supplier = supplier;
            this.fixed_price = fixed_price;
            this.cost = cost;
            this.supplier_id = supplier_id;
            this.multi_level_pricing = multi_level_pricing;
            this.vatable = vatable;
            this.reorder_level = reorder_level;
            this.markup = markup;
            this.main_barcode = main_barcode;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.selling_type = selling_type;
            this.branch = branch;
            this.branch_code = branch_code;
        }
    }

    public static void add_inventory_assembly(to_inventory_assembly to_inventory_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_assembly("
                    + "barcode"
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
                    + ")values("
                    + ":barcode"
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
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory_assembly.barcode).
                    setString("description", to_inventory_assembly.description).
                    setString("generic_name", to_inventory_assembly.generic_name).
                    setString("category", to_inventory_assembly.category).
                    setString("category_id", to_inventory_assembly.category_id).
                    setString("classification", to_inventory_assembly.classification).
                    setString("classification_id", to_inventory_assembly.classification_id).
                    setString("sub_classification", to_inventory_assembly.sub_classification).
                    setString("sub_classification_id", to_inventory_assembly.sub_classification_id).
                    setNumber("product_qty", to_inventory_assembly.product_qty).
                    setString("unit", to_inventory_assembly.unit).
                    setNumber("conversion", to_inventory_assembly.conversion).
                    setNumber("selling_price", to_inventory_assembly.selling_price).
                    setString("date_added", to_inventory_assembly.date_added).
                    setString("user_name", to_inventory_assembly.user_name).
                    setString("item_type", to_inventory_assembly.item_type).
                    setNumber("status", to_inventory_assembly.status).
                    setString("supplier", to_inventory_assembly.supplier).
                    setNumber("fixed_price", to_inventory_assembly.fixed_price).
                    setNumber("cost", to_inventory_assembly.cost).
                    setString("supplier_id", to_inventory_assembly.supplier_id).
                    setNumber("multi_level_pricing", to_inventory_assembly.multi_level_pricing).
                    setNumber("vatable", to_inventory_assembly.vatable).
                    setNumber("reorder_level", to_inventory_assembly.reorder_level).
                    setNumber("markup", to_inventory_assembly.markup).
                    setString("main_barcode", to_inventory_assembly.main_barcode).
                    setString("brand", to_inventory_assembly.brand).
                    setString("brand_id", to_inventory_assembly.brand_id).
                    setString("model", to_inventory_assembly.model).
                    setString("model_id", to_inventory_assembly.model_id).
                    setNumber("selling_type", to_inventory_assembly.selling_type).
                    setString("branch", to_inventory_assembly.branch).
                    setString("branch_code", to_inventory_assembly.branch_code).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_assembly.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_assembly(to_inventory_assembly to_inventory_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_assembly set "
                    + "barcode= :barcode"
                    + ",description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",product_qty= :product_qty"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",cost= :cost"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",main_barcode= :main_barcode"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",branch= :branch"
                    + ",branch_code= :branch_code"
                    + " where "
                    + " id ='" + to_inventory_assembly.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory_assembly.barcode).
                    setString("description", to_inventory_assembly.description).
                    setString("generic_name", to_inventory_assembly.generic_name).
                    setString("category", to_inventory_assembly.category).
                    setString("category_id", to_inventory_assembly.category_id).
                    setString("classification", to_inventory_assembly.classification).
                    setString("classification_id", to_inventory_assembly.classification_id).
                    setString("sub_classification", to_inventory_assembly.sub_classification).
                    setString("sub_classification_id", to_inventory_assembly.sub_classification_id).
                    setNumber("product_qty", to_inventory_assembly.product_qty).
                    setString("unit", to_inventory_assembly.unit).
                    setNumber("conversion", to_inventory_assembly.conversion).
                    setNumber("selling_price", to_inventory_assembly.selling_price).
                    setString("date_added", to_inventory_assembly.date_added).
                    setString("user_name", to_inventory_assembly.user_name).
                    setString("item_type", to_inventory_assembly.item_type).
                    setNumber("status", to_inventory_assembly.status).
                    setString("supplier", to_inventory_assembly.supplier).
                    setNumber("fixed_price", to_inventory_assembly.fixed_price).
                    setNumber("cost", to_inventory_assembly.cost).
                    setString("supplier_id", to_inventory_assembly.supplier_id).
                    setNumber("multi_level_pricing", to_inventory_assembly.multi_level_pricing).
                    setNumber("vatable", to_inventory_assembly.vatable).
                    setNumber("reorder_level", to_inventory_assembly.reorder_level).
                    setNumber("markup", to_inventory_assembly.markup).
                    setString("main_barcode", to_inventory_assembly.main_barcode).
                    setString("brand", to_inventory_assembly.brand).
                    setString("brand_id", to_inventory_assembly.brand_id).
                    setString("model", to_inventory_assembly.model).
                    setString("model_id", to_inventory_assembly.model_id).
                    setNumber("selling_type", to_inventory_assembly.selling_type).
                    setString("branch", to_inventory_assembly.branch).
                    setString("branch_code", to_inventory_assembly.branch_code).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_assembly.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_assembly(to_inventory_assembly to_inventory_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_assembly where "
                    + " id ='" + to_inventory_assembly.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_assembly.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_assembly> ret_data(String search) {
        List<to_inventory_assembly> datas = new ArrayList();

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
                    + " from inventory_assembly where "
                    + " main_barcode='"+search+"'";

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

                to_inventory_assembly to = new to_inventory_assembly(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
