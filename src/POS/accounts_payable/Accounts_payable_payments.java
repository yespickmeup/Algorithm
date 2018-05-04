/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_payable;

import POS.util.MyConnection;
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
public class Accounts_payable_payments {

    public static class to_accounts_payable_payments {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String ap_no;
        public final String date_added;
        public final String user_name;
        public final double amount;
        public final double discount_amount;
        public final double discount_rate;
        public final String discount;
        public final int status;
        public final double term;
        public final String date_applied;
        public final double paid;
        public final String date_paid;
        public final String remarks;
        public final String type;
        public final String or_no;
        public final double prev_balance;
        public final String reference_no;
        public final double check_amount;
        public final String check_holder;
        public final String check_bank;
        public final String check_no;
        public final String check_date;
        public final String user_id;
        public final String user_screen_name;
        public final double wtax;
        public final double tax_rate;
        public final double tax_amount;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_accounts_payable_payments(int id, String customer_id, String customer_name, String ap_no, String date_added, String user_name, double amount, double discount_amount, double discount_rate, String discount, int status, double term, String date_applied, double paid, String date_paid, String remarks, String type, String or_no, double prev_balance, String reference_no, double check_amount, String check_holder, String check_bank, String check_no, String check_date, String user_id, String user_screen_name, double wtax, double tax_rate, double tax_amount, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.ap_no = ap_no;
            this.date_added = date_added;
            this.user_name = user_name;
            this.amount = amount;
            this.discount_amount = discount_amount;
            this.discount_rate = discount_rate;
            this.discount = discount;
            this.status = status;
            this.term = term;
            this.date_applied = date_applied;
            this.paid = paid;
            this.date_paid = date_paid;
            this.remarks = remarks;
            this.type = type;
            this.or_no = or_no;
            this.prev_balance = prev_balance;
            this.reference_no = reference_no;
            this.check_amount = check_amount;
            this.check_holder = check_holder;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_date = check_date;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.wtax = wtax;
            this.tax_rate = tax_rate;
            this.tax_amount = tax_amount;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_accounts_payable_payments to_accounts_payable_payments, Accounts_payable.to_accounts_payable to) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into accounts_payable_payments("
                    + "customer_id"
                    + ",customer_name"
                    + ",ap_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",prev_balance"
                    + ",reference_no"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",wtax"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:ap_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:amount"
                    + ",:discount_amount"
                    + ",:discount_rate"
                    + ",:discount"
                    + ",:status"
                    + ",:term"
                    + ",:date_applied"
                    + ",:paid"
                    + ",:date_paid"
                    + ",:remarks"
                    + ",:type"
                    + ",:or_no"
                    + ",:prev_balance"
                    + ",:reference_no"
                    + ",:check_amount"
                    + ",:check_holder"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_date"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:wtax"
                    + ",:tax_rate"
                    + ",:tax_amount"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_accounts_payable_payments.customer_id)
                    .setString("customer_name", to_accounts_payable_payments.customer_name)
                    .setString("ap_no", to_accounts_payable_payments.ap_no)
                    .setString("date_added", to_accounts_payable_payments.date_added)
                    .setString("user_name", to_accounts_payable_payments.user_name)
                    .setNumber("amount", to_accounts_payable_payments.amount)
                    .setNumber("discount_amount", to_accounts_payable_payments.discount_amount)
                    .setNumber("discount_rate", to_accounts_payable_payments.discount_rate)
                    .setString("discount", to_accounts_payable_payments.discount)
                    .setNumber("status", to_accounts_payable_payments.status)
                    .setNumber("term", to_accounts_payable_payments.term)
                    .setString("date_applied", to_accounts_payable_payments.date_applied)
                    .setNumber("paid", to_accounts_payable_payments.paid)
                    .setString("date_paid", to_accounts_payable_payments.date_paid)
                    .setString("remarks", to_accounts_payable_payments.remarks)
                    .setString("type", to_accounts_payable_payments.type)
                    .setString("or_no", to_accounts_payable_payments.or_no)
                    .setNumber("prev_balance", to_accounts_payable_payments.prev_balance)
                    .setString("reference_no", to_accounts_payable_payments.reference_no)
                    .setNumber("check_amount", to_accounts_payable_payments.check_amount)
                    .setString("check_holder", to_accounts_payable_payments.check_holder)
                    .setString("check_bank", to_accounts_payable_payments.check_bank)
                    .setString("check_no", to_accounts_payable_payments.check_no)
                    .setString("check_date", to_accounts_payable_payments.check_date)
                    .setString("user_id", to_accounts_payable_payments.user_id)
                    .setString("user_screen_name", to_accounts_payable_payments.user_screen_name)
                    .setNumber("wtax", to_accounts_payable_payments.wtax)
                    .setNumber("tax_rate", to_accounts_payable_payments.tax_rate)
                    .setNumber("tax_amount", to_accounts_payable_payments.tax_amount)
                    .setString("branch", to_accounts_payable_payments.branch)
                    .setString("branch_id", to_accounts_payable_payments.branch_id)
                    .setString("location", to_accounts_payable_payments.location)
                    .setString("location_id", to_accounts_payable_payments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "select "
                    + " balance"
                    + " from  suppliers  "
                    + " where customer_no='" + to_accounts_payable_payments.customer_id + "' ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            double balance = 0;
            if (rs.next()) {
                balance = rs.getDouble(1);
            }

            double new_balance = balance - ((to_accounts_payable_payments.amount + to_accounts_payable_payments.discount_amount) + to_accounts_payable_payments.discount_amount);

            String s3 = "update  suppliers set "
                    + " balance= :balance"
                    + " where "
                    + " customer_no='" + to_accounts_payable_payments.customer_id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3).
                    setNumber("balance", new_balance).ok();

            stmt.addBatch(s3);

            double ap_paid = to.paid + ((to_accounts_payable_payments.amount + to_accounts_payable_payments.check_amount) + to_accounts_payable_payments.discount_amount);

            String s4 = "update accounts_payable set "
                    + " paid= :paid "
                    + " where id='" + to.id + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setNumber("paid", ap_paid)
                    .ok();

            stmt.addBatch(s4);

            stmt.executeBatch();
            conn.commit();

            Lg.s(Accounts_payable_payments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_accounts_payable_payments to_accounts_payable_payments) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into accounts_payable_payments("
                    + "customer_id"
                    + ",customer_name"
                    + ",ap_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",prev_balance"
                    + ",reference_no"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",wtax"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:ap_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:amount"
                    + ",:discount_amount"
                    + ",:discount_rate"
                    + ",:discount"
                    + ",:status"
                    + ",:term"
                    + ",:date_applied"
                    + ",:paid"
                    + ",:date_paid"
                    + ",:remarks"
                    + ",:type"
                    + ",:or_no"
                    + ",:prev_balance"
                    + ",:reference_no"
                    + ",:check_amount"
                    + ",:check_holder"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_date"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:wtax"
                    + ",:tax_rate"
                    + ",:tax_amount"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_accounts_payable_payments.customer_id)
                    .setString("customer_name", to_accounts_payable_payments.customer_name)
                    .setString("ap_no", to_accounts_payable_payments.ap_no)
                    .setString("date_added", to_accounts_payable_payments.date_added)
                    .setString("user_name", to_accounts_payable_payments.user_name)
                    .setNumber("amount", to_accounts_payable_payments.amount)
                    .setNumber("discount_amount", to_accounts_payable_payments.discount_amount)
                    .setNumber("discount_rate", to_accounts_payable_payments.discount_rate)
                    .setString("discount", to_accounts_payable_payments.discount)
                    .setNumber("status", to_accounts_payable_payments.status)
                    .setNumber("term", to_accounts_payable_payments.term)
                    .setString("date_applied", to_accounts_payable_payments.date_applied)
                    .setNumber("paid", to_accounts_payable_payments.paid)
                    .setString("date_paid", to_accounts_payable_payments.date_paid)
                    .setString("remarks", to_accounts_payable_payments.remarks)
                    .setString("type", to_accounts_payable_payments.type)
                    .setString("or_no", to_accounts_payable_payments.or_no)
                    .setNumber("prev_balance", to_accounts_payable_payments.prev_balance)
                    .setString("reference_no", to_accounts_payable_payments.reference_no)
                    .setNumber("check_amount", to_accounts_payable_payments.check_amount)
                    .setString("check_holder", to_accounts_payable_payments.check_holder)
                    .setString("check_bank", to_accounts_payable_payments.check_bank)
                    .setString("check_no", to_accounts_payable_payments.check_no)
                    .setString("check_date", to_accounts_payable_payments.check_date)
                    .setString("user_id", to_accounts_payable_payments.user_id)
                    .setString("user_screen_name", to_accounts_payable_payments.user_screen_name)
                    .setNumber("wtax", to_accounts_payable_payments.wtax)
                    .setNumber("tax_rate", to_accounts_payable_payments.tax_rate)
                    .setNumber("tax_amount", to_accounts_payable_payments.tax_amount)
                    .setString("branch", to_accounts_payable_payments.branch)
                    .setString("branch_id", to_accounts_payable_payments.branch_id)
                    .setString("location", to_accounts_payable_payments.location)
                    .setString("location_id", to_accounts_payable_payments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = " update accounts_payable_payments set is_uploaded=1 where id='" + to_accounts_payable_payments.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Accounts_payable_payments.class, "Accounts Payable Payment: " + to_accounts_payable_payments.ap_no + " " + to_accounts_payable_payments.amount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_data(to_accounts_payable_payments payment_previous, to_accounts_payable_payments payment_new, Accounts_payable.to_accounts_payable to) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update accounts_payable_payments set "
                    + " amount= :amount "
                    + ",discount_amount= :discount_amount "
                    + ",discount_rate= :discount_rate "
                    + ",discount= :discount "
                    + ",date_paid= :date_paid "
                    + ",remarks= :remarks "
                    + ",reference_no= :reference_no "
                    + ",check_amount= :check_amount "
                    + ",check_holder= :check_holder "
                    + ",check_bank= :check_bank "
                    + ",check_no= :check_no "
                    + ",check_date= :check_date "
                    + " where id='" + payment_new.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("amount", payment_new.amount)
                    .setNumber("discount_amount", payment_new.discount_amount)
                    .setNumber("discount_rate", payment_new.discount_rate)
                    .setString("discount", payment_new.discount)
                    .setString("date_paid", payment_new.date_paid)
                    .setString("remarks", payment_new.remarks)
                    .setString("reference_no", payment_new.reference_no)
                    .setNumber("check_amount", payment_new.check_amount)
                    .setString("check_holder", payment_new.check_holder)
                    .setString("check_bank", payment_new.check_bank)
                    .setString("check_no", payment_new.check_no)
                    .setString("check_date", payment_new.check_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            double ap_new_balance = payment_previous.amount + payment_previous.check_amount + payment_previous.discount_amount;

            ap_new_balance = (to.paid - ap_new_balance) + (payment_new.amount + payment_new.check_amount + payment_new.discount_amount);

            String s4 = "update accounts_payable set "
                    + " paid= :paid "
                    + " where id='" + to.id + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setNumber("paid", ap_new_balance)
                    .ok();
            stmt.addBatch(s4);

            String s2 = "select "
                    + " balance"
                    + " from  suppliers  "
                    + " where customer_no='" + to.customer_id + "' ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            double balance = 0;
            if (rs.next()) {
                balance = rs.getDouble(1);
            }

            double new_balance = (balance + (payment_previous.amount + payment_previous.check_amount + payment_previous.discount_amount)) - (payment_new.amount + payment_new.check_amount + payment_new.discount_amount);

            String s3 = "update  suppliers set "
                    + " balance= :balance"
                    + " where "
                    + " customer_no='" + to.customer_id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3).
                    setNumber("balance", new_balance).ok();

            stmt.addBatch(s3);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Accounts_payable_payments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_accounts_payable_payments to_accounts_payable_payments, Accounts_payable.to_accounts_payable to) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from accounts_payable_payments  "
                    + " where id='" + to_accounts_payable_payments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            double ap_new_balance = to_accounts_payable_payments.amount + to_accounts_payable_payments.check_amount + to_accounts_payable_payments.discount_amount;

            ap_new_balance = (to.paid - ap_new_balance);

            String s4 = "update accounts_payable set "
                    + " paid= :paid "
                    + " where id='" + to.id + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setNumber("paid", ap_new_balance)
                    .ok();
            stmt.addBatch(s4);

            String s2 = "select "
                    + " balance"
                    + " from  suppliers  "
                    + " where customer_no='" + to.customer_id + "' ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            double balance = 0;
            if (rs.next()) {
                balance = rs.getDouble(1);
            }

            double new_balance = (balance + (to_accounts_payable_payments.amount + to_accounts_payable_payments.check_amount + to_accounts_payable_payments.discount_amount));

            String s3 = "update  suppliers set "
                    + " balance= :balance"
                    + " where "
                    + " customer_no='" + to.customer_id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3).
                    setNumber("balance", new_balance).ok();

            stmt.addBatch(s3);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Accounts_payable_payments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_accounts_payable_payments> ret_data(String where) {
        List<to_accounts_payable_payments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ap_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",prev_balance"
                    + ",reference_no"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",wtax"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from accounts_payable_payments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ap_no = rs.getString(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                double amount = rs.getDouble(7);
                double discount_amount = rs.getDouble(8);
                double discount_rate = rs.getDouble(9);
                String discount = rs.getString(10);
                int status = rs.getInt(11);
                double term = rs.getDouble(12);
                String date_applied = rs.getString(13);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                double prev_balance = rs.getDouble(19);
                String reference_no = rs.getString(20);
                double check_amount = rs.getDouble(21);
                String check_holder = rs.getString(22);
                String check_bank = rs.getString(23);
                String check_no = rs.getString(24);
                String check_date = rs.getString(25);
                String user_id = rs.getString(26);
                String user_screen_name = rs.getString(27);
                double wtax = rs.getDouble(28);
                double tax_rate = rs.getDouble(29);
                double tax_amount = rs.getDouble(30);
                String branch = rs.getString(31);
                String branch_id = rs.getString(32);
                String location = rs.getString(33);
                String location_id = rs.getString(34);

                to_accounts_payable_payments to = new to_accounts_payable_payments(id, customer_id, customer_name, ap_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, reference_no, check_amount, check_holder, check_bank, check_no, check_date, user_id, user_screen_name, wtax, tax_rate, tax_amount, branch, branch_id, location, location_id);
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
