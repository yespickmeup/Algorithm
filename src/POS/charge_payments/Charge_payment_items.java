/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.charge_payments;

import POS.inventory.S1_inventory;
import POS.inventory.Inventory_barcodes;
import POS.util.MyConnection;
import POS.util.Segregator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Charge_payment_items {

    public static class to_charge_payment_items {

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
        public final String location;
        public final String location_id;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String added_by;
        public final String or_no;
        public final String serial_no;

        public to_charge_payment_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String main_barcode, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String discount_name, double discount_rate, double discount_amount, String added_by, String or_no, String serial_no) {
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
            this.location = location;
            this.location_id = location_id;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.added_by = added_by;
            this.or_no = or_no;
            this.serial_no = serial_no;
        }
    }

    public static void add_charge_payment_items(List<to_charge_payment_items> to_charge_payment_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_charge_payment_items to_charge_payment_items : to_charge_payment_items1) {
                String s0 = "insert into charge_payment_items("
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
                        + ",location"
                        + ",location_id"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",added_by"
                        + ",or_no"
                        + ",serial_no"
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
                        + ",:location"
                        + ",:location_id"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:added_by"
                        + ",:or_no"
                        + ",:serial_no"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("barcode", to_charge_payment_items.barcode)
                        .setString("description", to_charge_payment_items.description)
                        .setString("generic_name", to_charge_payment_items.generic_name)
                        .setString("category", to_charge_payment_items.category)
                        .setString("category_id", to_charge_payment_items.category_id)
                        .setString("classification", to_charge_payment_items.classification)
                        .setString("classification_id", to_charge_payment_items.classification_id)
                        .setString("sub_classification", to_charge_payment_items.sub_classification)
                        .setString("sub_classification_id", to_charge_payment_items.sub_classification_id)
                        .setNumber("product_qty", to_charge_payment_items.product_qty)
                        .setString("unit", to_charge_payment_items.unit)
                        .setNumber("conversion", to_charge_payment_items.conversion)
                        .setNumber("selling_price", to_charge_payment_items.selling_price)
                        .setString("date_added", to_charge_payment_items.date_added)
                        .setString("user_name", to_charge_payment_items.user_name)
                        .setString("item_type", to_charge_payment_items.item_type)
                        .setNumber("status", to_charge_payment_items.status)
                        .setString("supplier", to_charge_payment_items.supplier)
                        .setNumber("fixed_price", to_charge_payment_items.fixed_price)
                        .setNumber("cost", to_charge_payment_items.cost)
                        .setString("supplier_id", to_charge_payment_items.supplier_id)
                        .setNumber("multi_level_pricing", to_charge_payment_items.multi_level_pricing)
                        .setNumber("vatable", to_charge_payment_items.vatable)
                        .setNumber("reorder_level", to_charge_payment_items.reorder_level)
                        .setNumber("markup", to_charge_payment_items.markup)
                        .setString("main_barcode", to_charge_payment_items.main_barcode)
                        .setString("brand", to_charge_payment_items.brand)
                        .setString("brand_id", to_charge_payment_items.brand_id)
                        .setString("model", to_charge_payment_items.model)
                        .setString("model_id", to_charge_payment_items.model_id)
                        .setNumber("selling_type", to_charge_payment_items.selling_type)
                        .setString("branch", to_charge_payment_items.branch)
                        .setString("branch_code", to_charge_payment_items.branch_code)
                        .setString("location", to_charge_payment_items.location)
                        .setString("location_id", to_charge_payment_items.location_id)
                        .setString("discount_name", to_charge_payment_items.discount_name)
                        .setNumber("discount_rate", to_charge_payment_items.discount_rate)
                        .setNumber("discount_amount", to_charge_payment_items.discount_amount)
                        .setString("added_by", to_charge_payment_items.added_by)
                        .setString("or_no", to_charge_payment_items.or_no)
                        .setString("serial_no", to_charge_payment_items.serial_no)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Charge_payment_items.class, "Successfully Added");

                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_charge_payment_items.main_barcode, to_charge_payment_items.barcode, to_charge_payment_items.location_id);
                double new_qty = tt.product_qty - (to_charge_payment_items.conversion * to_charge_payment_items.product_qty);
                String serial_no = Segregator.this_shit(tt.serial_no, to_charge_payment_items.serial_no);

                String s4 = "update inventory_barcodes set "
                        + "product_qty='" + new_qty + "'"
                        + ",cost='" + to_charge_payment_items.cost + "' "
                        + ",serial_no='" + serial_no + "' "
                        + " where barcode = '" + to_charge_payment_items.barcode + "' and main_barcode= '" + to_charge_payment_items.main_barcode + "' and location_id='" + to_charge_payment_items.location_id + "' "
                        + "";
                PreparedStatement stmt4 = conn.prepareStatement(s4);
                stmt4.execute();
                Lg.s(S1_inventory.class, "Successfully Updated");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
