/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_sales;

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
public class MySales2 {

    public static class sales {

        public final int id;
        public String sales_no;
        public final String date_added;
        public final String user_screen_name;
        public final String user_id;
        public final String session_no;
        public final String remarks;
        public double gross_amount;
        public double amount_due;
        public final int status;
        public final int sales_type;
        public double line_discount;
        public final String customer_id;
        public final String customer_name;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final String charge_type;
        public final String charge_type_id;
        public final String charge_reference_no;
        public final String charge_customer_name;
        public final String charge_customer_id;
        public final double charge_amount;
        public final String check_bank;
        public final String check_no;
        public final double check_amount;
        public final String check_holder;
        public final String check_date;
        public final String credit_card_type;
        public final double credit_card_rate;
        public final double credit_card_amount;
        public final String credit_card_no;
        public final String credit_card_holder;
        public final String credit_card_approval_code;
        public final String gift_certificate_from;
        public final String gift_certificate_description;
        public final String gift_certificate_no;
        public final double gift_certificate_amount;
        public final String prepaid_customer_name;
        public final String prepaid_customer_id;
        public final double prepaid_amount;
        public final double addtl_amount;
        public final double wtax;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final List<MySales_Items.items> items;
        public boolean is_selected;
        public final String ref_or_no;
        public final String ref_si_no;
        public final String ref_cr_no;

        public sales(int id, String sales_no, String date_added, String user_screen_name, String user_id, String session_no, String remarks, double gross_amount, double amount_due, int status, int sales_type, double line_discount, String customer_id, String customer_name, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String charge_type, String charge_type_id, String charge_reference_no, String charge_customer_name, String charge_customer_id, double charge_amount, String check_bank, String check_no, double check_amount, String check_holder, String check_date, String credit_card_type, double credit_card_rate, double credit_card_amount, String credit_card_no, String credit_card_holder, String credit_card_approval_code, String gift_certificate_from, String gift_certificate_description, String gift_certificate_no, double gift_certificate_amount, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, double addtl_amount, double wtax, String branch, String branch_id, String location, String location_id, List<MySales_Items.items> items
                , boolean is_selected,String ref_or_no,String ref_si_no,String ref_cr_no) {
            this.id = id;
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_screen_name = user_screen_name;
            this.user_id = user_id;
            this.session_no = session_no;
            this.remarks = remarks;
            this.gross_amount = gross_amount;
            this.amount_due = amount_due;
            this.status = status;
            this.sales_type = sales_type;
            this.line_discount = line_discount;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.charge_type = charge_type;
            this.charge_type_id = charge_type_id;
            this.charge_reference_no = charge_reference_no;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.check_holder = check_holder;
            this.check_date = check_date;
            this.credit_card_type = credit_card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_approval_code = credit_card_approval_code;
            this.gift_certificate_from = gift_certificate_from;
            this.gift_certificate_description = gift_certificate_description;
            this.gift_certificate_no = gift_certificate_no;
            this.gift_certificate_amount = gift_certificate_amount;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.items = items;
            this.is_selected = is_selected;
            this.ref_or_no=ref_or_no;
            this.ref_si_no=ref_si_no;
            this.ref_cr_no=ref_cr_no;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
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

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

    }

    public static List<MySales2.sales> ret_data(String where) {
        List<MySales2.sales> datas = new ArrayList();
        List<MySales_Items.items> items = new ArrayList();
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
                    + ",check_holder"
                    + ",check_date"
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
                    + ",addtl_amount"
                    + ",wtax"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",ref_or_no"
                    + ",ref_si_no"
                    + ",ref_cr_no"
                    + " from sales"
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
                String check_holder = rs.getString(29);
                String check_date = rs.getString(30);
                String credit_card_type = rs.getString(31);
                double credit_card_rate = rs.getDouble(32);
                double credit_card_amount = rs.getDouble(33);
                String credit_card_no = rs.getString(34);
                String credit_card_holder = rs.getString(35);
                String credit_card_approval_code = rs.getString(36);
                String gift_certificate_from = rs.getString(37);
                String gift_certificate_description = rs.getString(38);
                String gift_certificate_no = rs.getString(39);
                double gift_certificate_amount = rs.getDouble(40);
                String prepaid_customer_name = rs.getString(41);
                String prepaid_customer_id = rs.getString(42);
                double prepaid_amount = rs.getDouble(43);
                double addtl_amount = rs.getDouble(44);
                double wtax = rs.getDouble(45);
                String branch = rs.getString(46);
                String branch_id = rs.getString(47);
                String location = rs.getString(48);
                String location_id = rs.getString(49);
                String ref_or_no=rs.getString(50);
                String ref_si_no=rs.getString(51);
                String ref_cr_no=rs.getString(52);
                MySales2.sales to = new MySales2.sales(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status
                        , sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount, wtax, branch, branch_id, location, location_id, items, true,ref_or_no,ref_si_no,ref_cr_no);
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
