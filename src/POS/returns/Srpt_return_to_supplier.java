/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class Srpt_return_to_supplier {

    public final String business_name;
    public final String address;
    public final String return_to_supplier_no;
    public final String date_returned;
    public final String date;
    public final String supplier;
    public final String supplier_id;
    public final String reference_no;
    public final String remarks;
    public final String branch;
    public final String location;
    public final List<field> fields;
    public final String contact_no;

    public Srpt_return_to_supplier(String business_name, String address, String return_to_supplier_no, String date_returned, String date, String supplier, String supplier_id, String reference_no, String remarks, String branch, String location, String contact_no) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.return_to_supplier_no = return_to_supplier_no;
        this.date_returned = date_returned;
        this.date = date;
        this.supplier = supplier;
        this.supplier_id = supplier_id;
        this.reference_no = reference_no;
        this.remarks = remarks;
        this.branch = branch;
        this.location = location;
        this.contact_no = contact_no;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double conversion;
        double cost;
        double amount;
        String remarks;
        String serials;

        public field() {
        }

        public field(String item_code, String barcode, String description, String unit, double qty, double conversion, double cost, double amount, String remarks, String serials) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.conversion = conversion;
            this.cost = cost;
            this.amount = amount;
            this.remarks = remarks;
            this.serials = serials;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getSerials() {
            return serials;
        }

        public void setSerials(String serials) {
            this.serials = serials;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }
}
