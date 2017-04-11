/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class Srpt_sales_summary_per_cashier {

    public final List<field> fields;
    String business_name;
    String address;
    String date;
    String branch;
    String location;
    String printed_by;

    public Srpt_sales_summary_per_cashier(String business_name, String address, String date, String branch, String location, String printed_by) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.printed_by = printed_by;
    }

    public static class field {

        String date;
        String branch;
        String location;
        String user_id;
        String user_screen_name;
        double amount_due;
        double line_discount;
        double sale_discount;
        double cash;
        double charge;
        double cheque;
        double credit_card;
        double gift_certificate;
        double prepaid;
        double balance_due;

        public field() {
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_screen_name() {
            return user_screen_name;
        }

        public void setUser_screen_name(String user_screen_name) {
            this.user_screen_name = user_screen_name;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

        public double getSale_discount() {
            return sale_discount;
        }

        public void setSale_discount(double sale_discount) {
            this.sale_discount = sale_discount;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getCharge() {
            return charge;
        }

        public void setCharge(double charge) {
            this.charge = charge;
        }

        public double getCheque() {
            return cheque;
        }

        public void setCheque(double cheque) {
            this.cheque = cheque;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

        public double getGift_certificate() {
            return gift_certificate;
        }

        public void setGift_certificate(double gift_certificate) {
            this.gift_certificate = gift_certificate;
        }

        public double getPrepaid() {
            return prepaid;
        }

        public void setPrepaid(double prepaid) {
            this.prepaid = prepaid;
        }

        public double getBalance_due() {
            return balance_due;
        }

        public void setBalance_due(double balance_due) {
            this.balance_due = balance_due;
        }
    }

    public static List<Srpt_sales_ledger.field> ret_data(String where) {
        List<Srpt_sales_ledger.field> fields = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",session_no"
                    + ",remarks"
                    + ",gross_amount"
                    + ",amount_due"
                    + ",status"
                    + ",sales_type"
                    + ",line_discount"
                    + ",customer_id"
                    + ",customer_name"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",charge_type"
                    + ",charge_type_id"
                    + ",charge_reference_no"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",credit_card_type"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + ",gift_certificate_from"
                    + ",gift_certificate_description"
                    + ",gift_certificate_no"
                    + ",gift_certificate_amount"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String user_id = rs.getString(5);
                String session_no = rs.getString(6);
                String remarks = rs.getString(7);
                double gross_amount = rs.getDouble(8);
                double amount_due = rs.getDouble(9);
                int status = rs.getInt(10);
                int sales_type = rs.getInt(11);
                double line_discount = rs.getDouble(12);
                String customer_id = rs.getString(13);
                String customer_name = rs.getString(14);
                String discount_name = rs.getString(15);
                double discount_rate = rs.getDouble(16);
                double discount_amount = rs.getDouble(17);
                String discount_customer_name = rs.getString(18);
                String discount_customer_id = rs.getString(19);
                String charge_type = rs.getString(20);
                String charge_type_id = rs.getString(21);
                String charge_reference_no = rs.getString(22);
                String charge_customer_name = rs.getString(23);
                String charge_customer_id = rs.getString(24);
                double charge_amount = rs.getDouble(25);
                String check_bank = rs.getString(26);
                String check_no = rs.getString(27);
                double check_amount = rs.getDouble(28);
                String credit_card_type = rs.getString(29);
                double credit_card_rate = rs.getDouble(30);
                double credit_card_amount = rs.getDouble(31);
                String credit_card_no = rs.getString(32);
                String credit_card_holder = rs.getString(33);
                String credit_card_approval_code = rs.getString(34);
                String gift_certificate_from = rs.getString(35);
                String gift_certificate_description = rs.getString(36);
                String gift_certificate_no = rs.getString(37);
                double gift_certificate_amount = rs.getDouble(38);
                String prepaid_customer_name = rs.getString(39);
                String prepaid_customer_id = rs.getString(40);
                double prepaid_amount = rs.getDouble(41);

                double sales_discount = discount_amount;
                double cash = amount_due - (charge_amount + check_amount + credit_card_amount + gift_certificate_amount + prepaid_amount);
                double cheque_amount = check_amount;
                double gc_amount = gift_certificate_amount;
                double balance_due = amount_due;

            }
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
