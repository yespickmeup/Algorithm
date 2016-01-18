/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.patch;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ObjectSerPersister;

/**
 *
 * @author Guinness
 */
public class SaveToUsb implements Serializable {

    public stock_transfer stock_transfer;
    public List<stock_transfer_items> stock_transfer_items;

    public SaveToUsb() {
    }

    public SaveToUsb(stock_transfer stock_transfer, List<stock_transfer_items> stock_transfer_items) {
        this.stock_transfer = stock_transfer;
        this.stock_transfer_items = stock_transfer_items;
    }

    public stock_transfer getStock_transfer() {
        return stock_transfer;
    }

    public void setStock_transfer(stock_transfer stock_transfer) {
        this.stock_transfer = stock_transfer;
    }

    //<editor-fold defaultstate="collapsed" desc=" Stock Transfer ">
    public static class stock_transfer implements Serializable {

        public int id;
        public String transaction_no;
        public String user_name;
        public String date_added;
        public String remarks;
        public String to_branch;
        public String to_branch_id;
        public String to_location;
        public String to_location_id;
        public String from_branch;
        public String from_branch_id;
        public String from_location;
        public String from_location_id;
        public int status;

        public stock_transfer(int id, String transaction_no, String user_name, String date_added, String remarks, String to_branch, String to_branch_id, String to_location, String to_location_id, String from_branch, String from_branch_id, String from_location, String from_location_id, int status) {
            this.id = id;
            this.transaction_no = transaction_no;
            this.user_name = user_name;
            this.date_added = date_added;
            this.remarks = remarks;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.status = status;
        }
    }

    public static class stock_transfer_items implements Serializable {

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
        public final String barcodes;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int selling_type;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public final String stock_transfer_id;
        public String serial_no;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;

        public stock_transfer_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String barcodes, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String stock_transfer_id, String serial_no, String to_branch, String to_branch_id, String to_location, String to_location_id) {
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
            this.barcodes = barcodes;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.selling_type = selling_type;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
            this.stock_transfer_id = stock_transfer_id;
            this.serial_no = serial_no;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;

        }

    }
//</editor-fold>

    public static void save(File file, Object o) {

        try {
            // save the file here
            String filename = file.getAbsoluteFile() + ".secret";
            Lg.$.info(filename);
            ObjectSerPersister osp = new ObjectSerPersister(filename);
            osp.openSerFile();
            osp.persist(o);
        } catch (Exception e) {
            Lg.$.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Object get(File file) {
        try {

            String filename = file.getAbsolutePath();
            Lg.$.info(filename);
            ObjectSerPersister osp = new ObjectSerPersister(filename);
            osp.openSerFile();
            Lg.$.info(Boolean.toString(osp.hasLeftOver()));
            return osp.loadLeftOver();

        } catch (Exception e) {
            Lg.$.severe("Invalid format");
            throw new RuntimeException(e);
        }
    }
}
