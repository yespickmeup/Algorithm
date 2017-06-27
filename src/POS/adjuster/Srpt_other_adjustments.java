/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class Srpt_other_adjustments {

    public final String business_name;
    public final String address;
    public final String date;
    public final String branch;
    public final String location;
    public final List<field> fields;

    public Srpt_other_adjustments(String business_name, String address, String date, String branch, String location) {
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.fields = new ArrayList();
    }

    public static class field {

        String item_code;
        String description;
        String unit;
        double qty;
        double previous_qty;
        double price;
        double amount;
        String adjustment_type;
        String status;
        String adjustment_date;
        String branch;
        String location;
        String location_id;

        public field() {
        }

        public field(String item_code, String description, String unit, double qty, double previous_qty, double price, double amount, String adjustment_type, String status, String adjustment_date, String branch, String location, String location_id) {
            this.item_code = item_code;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.previous_qty = previous_qty;
            this.price = price;
            this.amount = amount;
            this.adjustment_type = adjustment_type;
            this.status = status;
            this.adjustment_date = adjustment_date;
            this.branch = branch;
            this.location = location;
            this.location_id = location_id;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
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

        public double getPrevious_qty() {
            return previous_qty;
        }

        public void setPrevious_qty(double previous_qty) {
            this.previous_qty = previous_qty;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getAdjustment_type() {
            return adjustment_type;
        }

        public void setAdjustment_type(String adjustment_type) {
            this.adjustment_type = adjustment_type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAdjustment_date() {
            return adjustment_date;
        }

        public void setAdjustment_date(String adjustment_date) {
            this.adjustment_date = adjustment_date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }
    
    
    
}
