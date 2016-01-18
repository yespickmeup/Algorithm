/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.inventory.S1_inventory;
import POS.inventory.Inventory_barcodes;
import POS.util.MyConnection;
import POS.util.Segregator;
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
public class Sales_item {

    public static class to_sales_item {

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
        public boolean selected;
        public to_sales_item(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String main_barcode, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String discount_name, double discount_rate, double discount_amount, String added_by, String or_no, String serial_no,boolean selected) {
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
            this.selected=selected;
            
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    public static class to_order {

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
        public double product_qty;
        public String unit;
        public double conversion;
        public double selling_price;
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
        public String discount_name;
        public double discount_rate;
        public double discount_amount;
        public final String added_by;
        public final String or_no;
        public String serial_no;
        public String selected_serials;

        public to_order(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String main_barcode, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String discount_name, double discount_rate, double discount_amount, String added_by, String or_no, String serial_no, String selected_serials) {
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
            this.selected_serials = selected_serials;
        }

        public String getSelected_serials() {
            return selected_serials;
        }

        public void setSelected_serials(String selected_serials) {
            this.selected_serials = selected_serials;
        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public String getDiscount_name() {
            return discount_name;
        }

        public void setDiscount_name(String discount_name) {
            this.discount_name = discount_name;
        }

        public double getDiscount_rate() {
            return discount_rate;
        }

        public void setDiscount_rate(double discount_rate) {
            this.discount_rate = discount_rate;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(String serial_no) {
            this.serial_no = serial_no;
        }

    }

    public static void add_sales_item(List<to_sales_item> to_sales_item1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_sales_item to_sales_item : to_sales_item1) {
                String s0 = "insert into sales_item("
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
                        .setString("barcode", to_sales_item.barcode)
                        .setString("description", to_sales_item.description)
                        .setString("generic_name", to_sales_item.generic_name)
                        .setString("category", to_sales_item.category)
                        .setString("category_id", to_sales_item.category_id)
                        .setString("classification", to_sales_item.classification)
                        .setString("classification_id", to_sales_item.classification_id)
                        .setString("sub_classification", to_sales_item.sub_classification)
                        .setString("sub_classification_id", to_sales_item.sub_classification_id)
                        .setNumber("product_qty", to_sales_item.product_qty)
                        .setString("unit", to_sales_item.unit)
                        .setNumber("conversion", to_sales_item.conversion)
                        .setNumber("selling_price", to_sales_item.selling_price)
                        .setString("date_added", to_sales_item.date_added)
                        .setString("user_name", to_sales_item.user_name)
                        .setString("item_type", to_sales_item.item_type)
                        .setNumber("status", to_sales_item.status)
                        .setString("supplier", to_sales_item.supplier)
                        .setNumber("fixed_price", to_sales_item.fixed_price)
                        .setNumber("cost", to_sales_item.cost)
                        .setString("supplier_id", to_sales_item.supplier_id)
                        .setNumber("multi_level_pricing", to_sales_item.multi_level_pricing)
                        .setNumber("vatable", to_sales_item.vatable)
                        .setNumber("reorder_level", to_sales_item.reorder_level)
                        .setNumber("markup", to_sales_item.markup)
                        .setString("main_barcode", to_sales_item.main_barcode)
                        .setString("brand", to_sales_item.brand)
                        .setString("brand_id", to_sales_item.brand_id)
                        .setString("model", to_sales_item.model)
                        .setString("model_id", to_sales_item.model_id)
                        .setNumber("selling_type", to_sales_item.selling_type)
                        .setString("branch", to_sales_item.branch)
                        .setString("branch_code", to_sales_item.branch_code)
                        .setString("location", to_sales_item.location)
                        .setString("location_id", to_sales_item.location_id)
                        .setString("discount_name", to_sales_item.discount_name)
                        .setNumber("discount_rate", to_sales_item.discount_rate)
                        .setNumber("discount_amount", to_sales_item.discount_amount)
                        .setString("added_by", to_sales_item.added_by)
                        .setString("or_no", to_sales_item.or_no)
                        .setString("serial_no", to_sales_item.serial_no)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Sales_item.class, "Successfully Added");
                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_sales_item.main_barcode, to_sales_item.barcode, to_sales_item.location_id);
                double new_qty = tt.product_qty - (to_sales_item.conversion * to_sales_item.product_qty);
                String serial_no = Segregator.this_shit(tt.serial_no, to_sales_item.serial_no);
                String s4 = "update inventory_barcodes set "
                        + "product_qty='" + new_qty + "'"
                        + ",cost='" + to_sales_item.cost + "' "
                        + ",serial_no='" + serial_no + "' "
                        + " where barcode = '" + to_sales_item.barcode + "' and main_barcode= '" + to_sales_item.main_barcode + "' and location_id='" + to_sales_item.location_id + "' "
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

    public static List<to_sales_item> ret_data(String where) {
        List<to_sales_item> datas = new ArrayList();

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
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",added_by"
                    + ",or_no"
                    + ",serial_no"
                    + " from sales_item  "
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
                String discount_name = rs.getString(37);
                double discount_rate = rs.getDouble(38);
                double discount_amount = rs.getDouble(39);
                String added_by = rs.getString(40);
                String or_no = rs.getString(41);
                String serial_no = rs.getString(42);

                to_sales_item to = new to_sales_item(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, discount_name, discount_rate, discount_amount, added_by, or_no, serial_no,false);
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
