/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.borrower_slip;

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
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_borrower_slip_items {

    public static class to_borrower_slip_items {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String bs_no;
        public final String reference_no;
        public final String borrowed_by;
        public final String borrowed_by_id;
        public final String borrowed_by_department;
        public final String borrowed_by_department_id;
        public final int status;
        public final String from_branch;
        public final String from_branch_id;
        public final String from_location;
        public final String from_location_id;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public final String remarks;
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
        public final String item_type;
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
        public final String selling_type;
        public final String serial_no;
        public final double qty_borrowed;
        public final double qty_returned;

        public to_borrower_slip_items(int id, String user_id, String user_screen_name, String date_added, String bs_no, String reference_no, String borrowed_by, String borrowed_by_id, String borrowed_by_department, String borrowed_by_department_id, int status, String from_branch, String from_branch_id, String from_location, String from_location_id, String to_branch, String to_branch_id, String to_location, String to_location_id, String remarks, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String item_type, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String main_barcode, String brand, String brand_id, String model, String model_id, String selling_type, String serial_no, double qty_borrowed, double qty_returned) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.bs_no = bs_no;
            this.reference_no = reference_no;
            this.borrowed_by = borrowed_by;
            this.borrowed_by_id = borrowed_by_id;
            this.borrowed_by_department = borrowed_by_department;
            this.borrowed_by_department_id = borrowed_by_department_id;
            this.status = status;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.remarks = remarks;
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
            this.item_type = item_type;
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
            this.serial_no = serial_no;
            this.qty_borrowed = qty_borrowed;
            this.qty_returned = qty_returned;
        }
    }

    public static void add_data(List<to_borrower_slip_items> to_borrower_slip_items1, S1_borrower_slips.to_borrower_slips to_borrower_slips) {
        try {
            Connection conn = MyConnection.connect();
            for (to_borrower_slip_items to_borrower_slip_items : to_borrower_slip_items1) {
                String s0 = "insert into borrower_slip_items("
                        + "user_id"
                        + ",user_screen_name"
                        + ",date_added"
                        + ",bs_no"
                        + ",reference_no"
                        + ",borrowed_by"
                        + ",borrowed_by_id"
                        + ",borrowed_by_department"
                        + ",borrowed_by_department_id"
                        + ",status"
                        + ",from_branch"
                        + ",from_branch_id"
                        + ",from_location"
                        + ",from_location_id"
                        + ",to_branch"
                        + ",to_branch_id"
                        + ",to_location"
                        + ",to_location_id"
                        + ",remarks"
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
                        + ",item_type"
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
                        + ",serial_no"
                        + ",qty_borrowed"
                        + ",qty_returned"
                        + ")values("
                        + ":user_id"
                        + ",:user_screen_name"
                        + ",:date_added"
                        + ",:bs_no"
                        + ",:reference_no"
                        + ",:borrowed_by"
                        + ",:borrowed_by_id"
                        + ",:borrowed_by_department"
                        + ",:borrowed_by_department_id"
                        + ",:status"
                        + ",:from_branch"
                        + ",:from_branch_id"
                        + ",:from_location"
                        + ",:from_location_id"
                        + ",:to_branch"
                        + ",:to_branch_id"
                        + ",:to_location"
                        + ",:to_location_id"
                        + ",:remarks"
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
                        + ",:item_type"
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
                        + ",:serial_no"
                        + ",:qty_borrowed"
                        + ",:qty_returned"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("user_id", to_borrower_slips.user_id)
                        .setString("user_screen_name", to_borrower_slips.user_screen_name)
                        .setString("date_added", to_borrower_slips.date_added)
                        .setString("bs_no", to_borrower_slips.bs_no)
                        .setString("reference_no", to_borrower_slips.reference_no)
                        .setString("borrowed_by", to_borrower_slips.borrowed_by)
                        .setString("borrowed_by_id", to_borrower_slips.borrowed_by_id)
                        .setString("borrowed_by_department", to_borrower_slips.borrowed_by_department)
                        .setString("borrowed_by_department_id", to_borrower_slips.borrowed_by_department_id)
                        .setNumber("status", to_borrower_slips.status)
                        .setString("from_branch", to_borrower_slips.from_branch)
                        .setString("from_branch_id", to_borrower_slips.from_branch_id)
                        .setString("from_location", to_borrower_slips.from_location)
                        .setString("from_location_id", to_borrower_slips.from_location_id)
                        .setString("to_branch", to_borrower_slips.to_branch)
                        .setString("to_branch_id", to_borrower_slips.to_branch_id)
                        .setString("to_location", to_borrower_slips.to_location)
                        .setString("to_location_id", to_borrower_slips.to_location_id)
                        .setString("remarks", to_borrower_slips.remarks)
                        .setString("barcode", to_borrower_slip_items.barcode)
                        .setString("description", to_borrower_slip_items.description)
                        .setString("generic_name", to_borrower_slip_items.generic_name)
                        .setString("category", to_borrower_slip_items.category)
                        .setString("category_id", to_borrower_slip_items.category_id)
                        .setString("classification", to_borrower_slip_items.classification)
                        .setString("classification_id", to_borrower_slip_items.classification_id)
                        .setString("sub_classification", to_borrower_slip_items.sub_classification)
                        .setString("sub_classification_id", to_borrower_slip_items.sub_classification_id)
                        .setNumber("product_qty", to_borrower_slip_items.product_qty)
                        .setString("unit", to_borrower_slip_items.unit)
                        .setNumber("conversion", to_borrower_slip_items.conversion)
                        .setNumber("selling_price", to_borrower_slip_items.selling_price)
                        .setString("item_type", to_borrower_slip_items.item_type)
                        .setString("supplier", to_borrower_slip_items.supplier)
                        .setNumber("fixed_price", to_borrower_slip_items.fixed_price)
                        .setNumber("cost", to_borrower_slip_items.cost)
                        .setString("supplier_id", to_borrower_slip_items.supplier_id)
                        .setNumber("multi_level_pricing", to_borrower_slip_items.multi_level_pricing)
                        .setNumber("vatable", to_borrower_slip_items.vatable)
                        .setNumber("reorder_level", to_borrower_slip_items.reorder_level)
                        .setNumber("markup", to_borrower_slip_items.markup)
                        .setString("main_barcode", to_borrower_slip_items.main_barcode)
                        .setString("brand", to_borrower_slip_items.brand)
                        .setString("brand_id", to_borrower_slip_items.brand_id)
                        .setString("model", to_borrower_slip_items.model)
                        .setString("model_id", to_borrower_slip_items.model_id)
                        .setString("selling_type", to_borrower_slip_items.selling_type)
                        .setString("serial_no", to_borrower_slip_items.serial_no)
                        .setNumber("qty_borrowed", to_borrower_slip_items.qty_borrowed)
                        .setNumber("qty_returned", to_borrower_slip_items.qty_returned)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_borrower_slip_items.class, "Successfully Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_borrower_slip_items to_borrower_slip_items) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);

            String s0 = "insert into borrower_slip_items("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",bs_no"
                    + ",reference_no"
                    + ",borrowed_by"
                    + ",borrowed_by_id"
                    + ",borrowed_by_department"
                    + ",borrowed_by_department_id"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",remarks"
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
                    + ",item_type"
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
                    + ",serial_no"
                    + ",qty_borrowed"
                    + ",qty_returned"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:bs_no"
                    + ",:reference_no"
                    + ",:borrowed_by"
                    + ",:borrowed_by_id"
                    + ",:borrowed_by_department"
                    + ",:borrowed_by_department_id"
                    + ",:status"
                    + ",:from_branch"
                    + ",:from_branch_id"
                    + ",:from_location"
                    + ",:from_location_id"
                    + ",:to_branch"
                    + ",:to_branch_id"
                    + ",:to_location"
                    + ",:to_location_id"
                    + ",:remarks"
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
                    + ",:item_type"
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
                    + ",:serial_no"
                    + ",:qty_borrowed"
                    + ",:qty_returned"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_borrower_slip_items.user_id)
                    .setString("user_screen_name", to_borrower_slip_items.user_screen_name)
                    .setString("date_added", to_borrower_slip_items.date_added)
                    .setString("bs_no", to_borrower_slip_items.bs_no)
                    .setString("reference_no", to_borrower_slip_items.reference_no)
                    .setString("borrowed_by", to_borrower_slip_items.borrowed_by)
                    .setString("borrowed_by_id", to_borrower_slip_items.borrowed_by_id)
                    .setString("borrowed_by_department", to_borrower_slip_items.borrowed_by_department)
                    .setString("borrowed_by_department_id", to_borrower_slip_items.borrowed_by_department_id)
                    .setNumber("status", to_borrower_slip_items.status)
                    .setString("from_branch", to_borrower_slip_items.from_branch)
                    .setString("from_branch_id", to_borrower_slip_items.from_branch_id)
                    .setString("from_location", to_borrower_slip_items.from_location)
                    .setString("from_location_id", to_borrower_slip_items.from_location_id)
                    .setString("to_branch", to_borrower_slip_items.to_branch)
                    .setString("to_branch_id", to_borrower_slip_items.to_branch_id)
                    .setString("to_location", to_borrower_slip_items.to_location)
                    .setString("to_location_id", to_borrower_slip_items.to_location_id)
                    .setString("remarks", to_borrower_slip_items.remarks)
                    .setString("barcode", to_borrower_slip_items.barcode)
                    .setString("description", to_borrower_slip_items.description)
                    .setString("generic_name", to_borrower_slip_items.generic_name)
                    .setString("category", to_borrower_slip_items.category)
                    .setString("category_id", to_borrower_slip_items.category_id)
                    .setString("classification", to_borrower_slip_items.classification)
                    .setString("classification_id", to_borrower_slip_items.classification_id)
                    .setString("sub_classification", to_borrower_slip_items.sub_classification)
                    .setString("sub_classification_id", to_borrower_slip_items.sub_classification_id)
                    .setNumber("product_qty", to_borrower_slip_items.product_qty)
                    .setString("unit", to_borrower_slip_items.unit)
                    .setNumber("conversion", to_borrower_slip_items.conversion)
                    .setNumber("selling_price", to_borrower_slip_items.selling_price)
                    .setString("item_type", to_borrower_slip_items.item_type)
                    .setString("supplier", to_borrower_slip_items.supplier)
                    .setNumber("fixed_price", to_borrower_slip_items.fixed_price)
                    .setNumber("cost", to_borrower_slip_items.cost)
                    .setString("supplier_id", to_borrower_slip_items.supplier_id)
                    .setNumber("multi_level_pricing", to_borrower_slip_items.multi_level_pricing)
                    .setNumber("vatable", to_borrower_slip_items.vatable)
                    .setNumber("reorder_level", to_borrower_slip_items.reorder_level)
                    .setNumber("markup", to_borrower_slip_items.markup)
                    .setString("main_barcode", to_borrower_slip_items.main_barcode)
                    .setString("brand", to_borrower_slip_items.brand)
                    .setString("brand_id", to_borrower_slip_items.brand_id)
                    .setString("model", to_borrower_slip_items.model)
                    .setString("model_id", to_borrower_slip_items.model_id)
                    .setString("selling_type", to_borrower_slip_items.selling_type)
                    .setString("serial_no", to_borrower_slip_items.serial_no)
                    .setNumber("qty_borrowed", to_borrower_slip_items.qty_borrowed)
                    .setNumber("qty_returned", to_borrower_slip_items.qty_returned)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update borrower_slip_items set is_uploaded=1 where id='" + to_borrower_slip_items.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(S1_borrower_slip_items.class, "Successfully Added: "+to_borrower_slip_items.bs_no+ " : "+to_borrower_slip_items.description);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_borrower_slip_items to_borrower_slip_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update borrower_slip_items set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",bs_no= :bs_no "
                    + ",reference_no= :reference_no "
                    + ",borrowed_by= :borrowed_by "
                    + ",borrowed_by_id= :borrowed_by_id "
                    + ",borrowed_by_department= :borrowed_by_department "
                    + ",borrowed_by_department_id= :borrowed_by_department_id "
                    + ",status= :status "
                    + ",from_branch= :from_branch "
                    + ",from_branch_id= :from_branch_id "
                    + ",from_location= :from_location "
                    + ",from_location_id= :from_location_id "
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + ",remarks= :remarks "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",generic_name= :generic_name "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",item_type= :item_type "
                    + ",supplier= :supplier "
                    + ",fixed_price= :fixed_price "
                    + ",cost= :cost "
                    + ",supplier_id= :supplier_id "
                    + ",multi_level_pricing= :multi_level_pricing "
                    + ",vatable= :vatable "
                    + ",reorder_level= :reorder_level "
                    + ",markup= :markup "
                    + ",main_barcode= :main_barcode "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",selling_type= :selling_type "
                    + ",serial_no= :serial_no "
                    + ",qty_borrowed= :qty_borrowed "
                    + ",qty_returned= :qty_returned "
                    + " where id='" + to_borrower_slip_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_borrower_slip_items.user_id)
                    .setString("user_screen_name", to_borrower_slip_items.user_screen_name)
                    .setString("date_added", to_borrower_slip_items.date_added)
                    .setString("bs_no", to_borrower_slip_items.bs_no)
                    .setString("reference_no", to_borrower_slip_items.reference_no)
                    .setString("borrowed_by", to_borrower_slip_items.borrowed_by)
                    .setString("borrowed_by_id", to_borrower_slip_items.borrowed_by_id)
                    .setString("borrowed_by_department", to_borrower_slip_items.borrowed_by_department)
                    .setString("borrowed_by_department_id", to_borrower_slip_items.borrowed_by_department_id)
                    .setNumber("status", to_borrower_slip_items.status)
                    .setString("from_branch", to_borrower_slip_items.from_branch)
                    .setString("from_branch_id", to_borrower_slip_items.from_branch_id)
                    .setString("from_location", to_borrower_slip_items.from_location)
                    .setString("from_location_id", to_borrower_slip_items.from_location_id)
                    .setString("to_branch", to_borrower_slip_items.to_branch)
                    .setString("to_branch_id", to_borrower_slip_items.to_branch_id)
                    .setString("to_location", to_borrower_slip_items.to_location)
                    .setString("to_location_id", to_borrower_slip_items.to_location_id)
                    .setString("remarks", to_borrower_slip_items.remarks)
                    .setString("barcode", to_borrower_slip_items.barcode)
                    .setString("description", to_borrower_slip_items.description)
                    .setString("generic_name", to_borrower_slip_items.generic_name)
                    .setString("category", to_borrower_slip_items.category)
                    .setString("category_id", to_borrower_slip_items.category_id)
                    .setString("classification", to_borrower_slip_items.classification)
                    .setString("classification_id", to_borrower_slip_items.classification_id)
                    .setString("sub_classification", to_borrower_slip_items.sub_classification)
                    .setString("sub_classification_id", to_borrower_slip_items.sub_classification_id)
                    .setNumber("product_qty", to_borrower_slip_items.product_qty)
                    .setString("unit", to_borrower_slip_items.unit)
                    .setNumber("conversion", to_borrower_slip_items.conversion)
                    .setNumber("selling_price", to_borrower_slip_items.selling_price)
                    .setString("item_type", to_borrower_slip_items.item_type)
                    .setString("supplier", to_borrower_slip_items.supplier)
                    .setNumber("fixed_price", to_borrower_slip_items.fixed_price)
                    .setNumber("cost", to_borrower_slip_items.cost)
                    .setString("supplier_id", to_borrower_slip_items.supplier_id)
                    .setNumber("multi_level_pricing", to_borrower_slip_items.multi_level_pricing)
                    .setNumber("vatable", to_borrower_slip_items.vatable)
                    .setNumber("reorder_level", to_borrower_slip_items.reorder_level)
                    .setNumber("markup", to_borrower_slip_items.markup)
                    .setString("main_barcode", to_borrower_slip_items.main_barcode)
                    .setString("brand", to_borrower_slip_items.brand)
                    .setString("brand_id", to_borrower_slip_items.brand_id)
                    .setString("model", to_borrower_slip_items.model)
                    .setString("model_id", to_borrower_slip_items.model_id)
                    .setString("selling_type", to_borrower_slip_items.selling_type)
                    .setString("serial_no", to_borrower_slip_items.serial_no)
                    .setNumber("qty_borrowed", to_borrower_slip_items.qty_borrowed)
                    .setNumber("qty_returned", to_borrower_slip_items.qty_returned)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_borrower_slip_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_borrower_slip_items to_borrower_slip_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from borrower_slip_items  "
                    + " where id='" + to_borrower_slip_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_borrower_slip_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_borrower_slip_items> ret_data(String where) {
        List<to_borrower_slip_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",bs_no"
                    + ",reference_no"
                    + ",borrowed_by"
                    + ",borrowed_by_id"
                    + ",borrowed_by_department"
                    + ",borrowed_by_department_id"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",remarks"
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
                    + ",item_type"
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
                    + ",serial_no"
                    + ",qty_borrowed"
                    + ",qty_returned"
                    + " from borrower_slip_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String bs_no = rs.getString(5);
                String reference_no = rs.getString(6);
                String borrowed_by = rs.getString(7);
                String borrowed_by_id = rs.getString(8);
                String borrowed_by_department = rs.getString(9);
                String borrowed_by_department_id = rs.getString(10);
                int status = rs.getInt(11);
                String from_branch = rs.getString(12);
                String from_branch_id = rs.getString(13);
                String from_location = rs.getString(14);
                String from_location_id = rs.getString(15);
                String to_branch = rs.getString(16);
                String to_branch_id = rs.getString(17);
                String to_location = rs.getString(18);
                String to_location_id = rs.getString(19);
                String remarks = rs.getString(20);
                String barcode = rs.getString(21);
                String description = rs.getString(22);
                String generic_name = rs.getString(23);
                String category = rs.getString(24);
                String category_id = rs.getString(25);
                String classification = rs.getString(26);
                String classification_id = rs.getString(27);
                String sub_classification = rs.getString(28);
                String sub_classification_id = rs.getString(29);
                double product_qty = rs.getDouble(30);
                String unit = rs.getString(31);
                double conversion = rs.getDouble(32);
                double selling_price = rs.getDouble(33);
                String item_type = rs.getString(34);
                String supplier = rs.getString(35);
                int fixed_price = rs.getInt(36);
                double cost = rs.getDouble(37);
                String supplier_id = rs.getString(38);
                int multi_level_pricing = rs.getInt(39);
                int vatable = rs.getInt(40);
                double reorder_level = rs.getDouble(41);
                double markup = rs.getDouble(42);
                String main_barcode = rs.getString(43);
                String brand = rs.getString(44);
                String brand_id = rs.getString(45);
                String model = rs.getString(46);
                String model_id = rs.getString(47);
                String selling_type = rs.getString(48);
                String serial_no = rs.getString(49);
                double qty_borrowed = rs.getDouble(50);
                double qty_returned = rs.getDouble(51);

                to_borrower_slip_items to = new to_borrower_slip_items(id, user_id, user_screen_name, date_added, bs_no, reference_no, borrowed_by, borrowed_by_id, borrowed_by_department, borrowed_by_department_id, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, remarks, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, item_type, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, serial_no, qty_borrowed, qty_returned);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_borrower_slip_items convert_inv_to_slip_items(Inventory_barcodes.to_inventory_barcodes items, double qty) {
        int id = 0;
        String user_id = "";
        String user_screen_name = "";
        String date_added = "";
        String bs_no = "";
        String reference_no = "";
        String borrowed_by = "";
        String borrowed_by_id = "";
        String borrowed_by_department = "";
        String borrowed_by_department_id = "";
        int status = 0;
        String from_branch = "";
        String from_branch_id = "";
        String from_location = "";
        String from_location_id = "";
        String to_branch = "";
        String to_branch_id = "";
        String to_location = "";
        String to_location_id = "";
        String remarks = "";
        String barcode = items.barcode;
        String description = items.description;
        String generic_name = items.generic_name;
        String category = items.category;
        String category_id = items.category_id;
        String classification = items.classification;
        String classification_id = items.classification_id;
        String sub_classification = items.sub_classification;
        String sub_classification_id = items.sub_classification_id;
        double product_qty = qty;
        String unit = items.unit;
        double conversion = items.conversion;
        double selling_price = items.selling_price;
        String item_type = items.item_type;
        String supplier = items.supplier;
        int fixed_price = items.fixed_price;
        double cost = items.cost;
        String supplier_id = items.supplier_id;
        int multi_level_pricing = items.multi_level_pricing;
        int vatable = items.vatable;
        double reorder_level = items.reorder_level;
        double markup = items.markup;
        String main_barcode = items.main_barcode;
        String brand = items.brand;
        String brand_id = items.brand_id;
        String model = items.model;
        String model_id = items.model_id;
        String selling_type = "" + items.selling_type;
        String serial_no = items.serial_no;
        double qty_borrowed = qty;
        double qty_returned = 0;

        to_borrower_slip_items to = new to_borrower_slip_items(id, user_id, user_screen_name, date_added, bs_no, reference_no, borrowed_by, borrowed_by_id, borrowed_by_department, borrowed_by_department_id, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, remarks, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, item_type, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, serial_no, qty_borrowed, qty_returned);
        return to;
    }
}
