/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronescape
 */
public class Srpt_sales_ledger_wtax {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;
    public final List<field> fields;

    public Srpt_sales_ledger_wtax(String business_name, String address, String contact_no, String date, String branch, String location) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.fields = new ArrayList();
    }

    public static class field {

        String sales_no;
        String or_no;
        String si_no;
        String cr_no;
        String date;
        String user;
        String customer_name;
        String charge_reference_no;
        double gross_amount;
        double amount_due;
        double wtax;
        double charge_amount;
        double check_amount;

        public field() {
        }

        public field(String sales_no, String or_no, String si_no, String cr_no, String date, String user, String customer_name, String charge_reference_no, double gross_amount, double amount_due, double wtax, double charge_amount, double check_amount) {
            this.sales_no = sales_no;
            this.or_no = or_no;
            this.si_no = si_no;
            this.cr_no = cr_no;
            this.date = date;
            this.user = user;
            this.customer_name = customer_name;
            this.charge_reference_no = charge_reference_no;
            this.gross_amount = gross_amount;
            this.amount_due = amount_due;
            this.wtax = wtax;
            this.charge_amount = charge_amount;
            this.check_amount = check_amount;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getSi_no() {
            return si_no;
        }

        public void setSi_no(String si_no) {
            this.si_no = si_no;
        }

        public String getCr_no() {
            return cr_no;
        }

        public void setCr_no(String cr_no) {
            this.cr_no = cr_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getCharge_reference_no() {
            return charge_reference_no;
        }

        public void setCharge_reference_no(String charge_reference_no) {
            this.charge_reference_no = charge_reference_no;
        }

        public double getGross_amount() {
            return gross_amount;
        }

        public void setGross_amount(double gross_amount) {
            this.gross_amount = gross_amount;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getWtax() {
            return wtax;
        }

        public void setWtax(double wtax) {
            this.wtax = wtax;
        }

        public double getCharge_amount() {
            return charge_amount;
        }

        public void setCharge_amount(double charge_amount) {
            this.charge_amount = charge_amount;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

    }
}
