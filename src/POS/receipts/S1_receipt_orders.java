/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

/**
 *
 * @author Maytopacka
 */
public class S1_receipt_orders {

    public static class to_receipt_items {

        public final int id;
        public final String receipt_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String barcode;
        public final String description;
        public double qty;
        public double cost;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        public double total;
        public final double conversion;
        public final String unit;
        public final String barcodes;
        public String serial_nos;
        public final String batch_no;
        public final String main_barcode;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final double previous_cost;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_receipt_items(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, double total, double conversion, String unit, String barcodes, String serial_nos, String batch_no, String main_barcode, String brand, String brand_id, String model, String model_id, double previous_cost, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.receipt_no = receipt_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
            this.total = total;
            this.conversion = conversion;
            this.unit = unit;
            this.barcodes = barcodes;
            this.serial_nos = serial_nos;
            this.batch_no = batch_no;
            this.main_barcode = main_barcode;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.previous_cost = previous_cost;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }

        public String getSerial_nos() {
            return serial_nos;
        }

        public void setSerial_nos(String serial_nos) {
            this.serial_nos = serial_nos;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }
}
