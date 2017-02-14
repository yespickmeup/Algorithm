/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_sales;

import POS.inventory.Inventory_barcodes;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class MySales_Items {

    public static class items {

        public final int id;
        public final String sales_no;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String item_type;
        public final String supplier_name;
        public final String supplier_id;
        public final String serial_no;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final int status;
        public final int is_vatable;
        public final int selling_type;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public boolean selected;
        public double addtl_amount;
        public double wtax;

        public items(int id, String sales_no, String item_code, String barcode, String description, String generic_name, String item_type, String supplier_name, String supplier_id, String serial_no, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_id, String user_screen_name, int status, int is_vatable, int selling_type, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String branch, String branch_code, String location, String location_id, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, String brand, String brand_id, String model, String model_id, boolean selected, double addtl_amount, double wtax) {
            this.id = id;
            this.sales_no = sales_no;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.item_type = item_type;
            this.supplier_name = supplier_name;
            this.supplier_id = supplier_id;
            this.serial_no = serial_no;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.status = status;
            this.is_vatable = is_vatable;
            this.selling_type = selling_type;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.selected = selected;
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static List<MySales_Items.items> convert_order(List<Inventory_barcodes.to_inventory_barcodes> orders) {
        List<MySales_Items.items> datas = new ArrayList();
        for (Inventory_barcodes.to_inventory_barcodes to : orders) {
            int id = to.id;
            String sales_no = "";
            String item_code = to.main_barcode;
            String barcode = to.barcode;
            String description = to.description;
            String generic_name = to.generic_name;
            String item_type = to.item_type;
            String supplier_name = to.supplier;
            String supplier_id = to.supplier_id;
            String serial_no = to.serial_no;
            double product_qty = to.product_qty;
            String unit = to.unit;
            double conversion = to.conversion;
            double selling_price = to.selling_price;
            String date_added = to.date_added;
            String user_id = "";
            String user_screen_name = "";
            int status = to.status;
            int is_vatable = to.vatable;
            int selling_type = to.selling_type;
            String discount_name = to.discount_name;
            double discount_rate = to.discount;
            double discount_amount = to.discount_amount;
            String discount_customer_name = to.discount_customer_name;
            String discount_customer_id = to.discount_customer_id;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            double addtl_amount = to.addtl_amount;
            double wtax = to.wtax;
            MySales_Items.items order = new items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, false, addtl_amount, wtax);
            datas.add(order);
        }

        return datas;
    }
    public static List<Inventory_barcodes.to_inventory_barcodes> convert_order2(List<MySales_Items.items> orders) {
        List<Inventory_barcodes.to_inventory_barcodes> datas = new ArrayList();
        for (MySales_Items.items to : orders) {
            int id = to.id;
            String sales_no = to.sales_no;
            String item_code = to.item_code;
            String barcode = to.barcode;
            String description = to.description;
            String generic_name = to.generic_name;
            String item_type = to.item_type;
            String supplier_name = to.supplier_name;
            String supplier_id = to.supplier_id;
            String serial_no = to.serial_no;
            double product_qty = to.product_qty;
            String unit = to.unit;
            double conversion = to.conversion;
            double selling_price = to.selling_price;
            String date_added = to.date_added;
            String user_id = "";
            String user_screen_name = "";
            int status = to.status;
            int is_vatable = to.is_vatable;
            int selling_type = to.selling_type;
            String discount_name = to.discount_name;
            double discount_rate = to.discount_rate;
            double discount_amount = to.discount_amount;
            String discount_customer_name = to.discount_customer_name;
            String discount_customer_id = to.discount_customer_id;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            double addtl_amount = to.addtl_amount;
            double wtax = to.wtax;
            Inventory_barcodes.to_inventory_barcodes order = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_id, item_type, status, supplier_id, is_vatable, wtax, supplier_id, selling_type, is_vatable, conversion, wtax, barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, serial_no, discount_rate, discount_amount, discount_name, discount_customer_name, discount_customer_id, addtl_amount, wtax);
            datas.add(order);
        }

        return datas;
    }

    public static List<MySales_Items.items> ret_data(String where) {
        List<MySales_Items.items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from sale_items  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                double addtl_amount = rs.getDouble(40);
                double wtax = rs.getDouble(41);
                MySales_Items.items to = new MySales_Items.items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, true, addtl_amount, wtax);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<MySales_Items.items> ret_data2(String where) {
        List<MySales_Items.items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from sale_items  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                double addtl_amount = rs.getDouble(40);
                double wtax = rs.getDouble(41);
                MySales_Items.items to = new MySales_Items.items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, false, addtl_amount, wtax);
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
