/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class Srpt_transferred_items {

    public final List<field> fields;
    public final String business_name;
    public final String address;
    public final String date;
    public final String from_branch;
    public final String from_location;
    public final String to_branch;
    public final String to_location;

    public Srpt_transferred_items(String business_name, String address, String date, String from_branch, String from_location, String to_branch, String to_location) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.from_branch = from_branch;
        this.from_location = from_location;
        this.to_branch = to_branch;
        this.to_location = to_location;
    }
    
    public static class field {

        String transaction_no;
        String date;
        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double selling_price;
        double cost;
        String f_branch;
        String f_branch_id;
        String f_location;
        String f_location_id;
        String t_branch;
        String t_branch_id;
        String t_location;
        String t_location_id;
        double amount;

        public field() {
        }

        public field(String transaction_no, String date, String item_code, String barcode, String description, String unit, double qty, double selling_price, double cost, String f_branch, String f_branch_id, String f_location, String f_location_id, String t_branch, String t_branch_id, String t_location, String t_location_id, double amount) {
            this.transaction_no = transaction_no;
            this.date = date;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.selling_price = selling_price;
            this.cost = cost;
            this.f_branch = f_branch;
            this.f_branch_id = f_branch_id;
            this.f_location = f_location;
            this.f_location_id = f_location_id;
            this.t_branch = t_branch;
            this.t_branch_id = t_branch_id;
            this.t_location = t_location;
            this.t_location_id = t_location_id;
            this.amount = amount;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public String getF_branch() {
            return f_branch;
        }

        public void setF_branch(String f_branch) {
            this.f_branch = f_branch;
        }

        public String getF_branch_id() {
            return f_branch_id;
        }

        public void setF_branch_id(String f_branch_id) {
            this.f_branch_id = f_branch_id;
        }

        public String getF_location() {
            return f_location;
        }

        public void setF_location(String f_location) {
            this.f_location = f_location;
        }

        public String getF_location_id() {
            return f_location_id;
        }

        public void setF_location_id(String f_location_id) {
            this.f_location_id = f_location_id;
        }

        public String getT_branch() {
            return t_branch;
        }

        public void setT_branch(String t_branch) {
            this.t_branch = t_branch;
        }

        public String getT_branch_id() {
            return t_branch_id;
        }

        public void setT_branch_id(String t_branch_id) {
            this.t_branch_id = t_branch_id;
        }

        public String getT_location() {
            return t_location;
        }

        public void setT_location(String t_location) {
            this.t_location = t_location;
        }

        public String getT_location_id() {
            return t_location_id;
        }

        public void setT_location_id(String t_location_id) {
            this.t_location_id = t_location_id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }
}
