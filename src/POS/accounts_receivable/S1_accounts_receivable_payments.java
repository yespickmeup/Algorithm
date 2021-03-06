/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.accounts_receivable.S1_accounts_receivable.to_accounts_receivable;
import POS.customers.Customers;
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
 * @author i1
 */
public class S1_accounts_receivable_payments {

    public static class to_accounts_receivable_payments {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String ar_no;
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
        public final double check_amount;
        public final String check_holder;
        public final String check_bank;
        public final String check_no;
        public final String ci_no;
        public final String trust_receipt;
        public final String or_payment_no;
        public final String soa_id;
        public final String soa_type;
        public final String soa_type_id;
        public final String reference_no;
        public boolean selected;
        public final String check_date;
        public final String user_id;
        public final String user_screen_name;
        public final double tax_rate;
        public final double tax_amount;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_accounts_receivable_payments(int id, String customer_id, String customer_name, String ar_no, String date_added, String user_name, double amount, double discount_amount, double discount_rate, String discount, int status, double term, String date_applied, double paid, String date_paid, String remarks, String type, String or_no, double prev_balance, double check_amount, String check_holder, String check_bank, String check_no, String ci_no, String trust_receipt, String or_payment_no, String soa_id, String soa_type, String soa_type_id, String reference_no, boolean selected, String check_date, String user_id, String user_screen_name, double tax_rate, double tax_amount, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.ar_no = ar_no;
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
            this.check_amount = check_amount;
            this.check_holder = check_holder;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.ci_no = ci_no;
            this.trust_receipt = trust_receipt;
            this.or_payment_no = or_payment_no;
            this.soa_id = soa_id;
            this.soa_type = soa_type;
            this.soa_type_id = soa_type_id;
            this.reference_no = reference_no;
            this.selected = selected;
            this.check_date = check_date;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.tax_rate = tax_rate;
            this.tax_amount = tax_amount;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_accounts_receivable_payments(to_accounts_receivable_payments to_accounts_receivable_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  accounts_receivable_payments("
                    + "customer_id"
                    + ",customer_name"
                    + ",ar_no"
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
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",or_payment_no"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:ar_no"
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
                    + ",:check_amount"
                    + ",:check_holder"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:ci_no"
                    + ",:trust_receipt"
                    + ",:or_payment_no"
                    + ",:soa_id"
                    + ",:soa_type"
                    + ",:soa_type_id"
                    + ",:reference_no"
                    + ",:check_date"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:tax_rate"
                    + ",:tax_amount"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_id", to_accounts_receivable_payments.customer_id).
                    setString("customer_name", to_accounts_receivable_payments.customer_name).
                    setString("ar_no", to_accounts_receivable_payments.ar_no).
                    setString("date_added", to_accounts_receivable_payments.date_added).
                    setString("user_name", to_accounts_receivable_payments.user_name).
                    setNumber("amount", to_accounts_receivable_payments.amount).
                    setNumber("discount_amount", to_accounts_receivable_payments.discount_amount).
                    setNumber("discount_rate", to_accounts_receivable_payments.discount_rate).
                    setString("discount", to_accounts_receivable_payments.discount).
                    setNumber("status", to_accounts_receivable_payments.status).
                    setNumber("term", to_accounts_receivable_payments.term).
                    setString("date_applied", to_accounts_receivable_payments.date_applied).
                    setNumber("paid", to_accounts_receivable_payments.paid).
                    setString("date_paid", to_accounts_receivable_payments.date_paid).
                    setString("remarks", to_accounts_receivable_payments.remarks).
                    setString("type", to_accounts_receivable_payments.type).
                    setString("or_no", to_accounts_receivable_payments.or_no).
                    setNumber("prev_balance", to_accounts_receivable_payments.prev_balance).
                    setNumber("check_amount", to_accounts_receivable_payments.check_amount).
                    setString("check_holder", to_accounts_receivable_payments.check_holder).
                    setString("check_bank", to_accounts_receivable_payments.check_bank).
                    setString("check_no", to_accounts_receivable_payments.check_no).
                    setString("ci_no", to_accounts_receivable_payments.ci_no).
                    setString("trust_receipt", to_accounts_receivable_payments.trust_receipt).
                    setString("or_payment_no", to_accounts_receivable_payments.or_payment_no).
                    setString("soa_id", to_accounts_receivable_payments.soa_id).
                    setString("soa_type", to_accounts_receivable_payments.soa_type).
                    setString("soa_type_id", to_accounts_receivable_payments.soa_type_id).
                    setString("reference_no", to_accounts_receivable_payments.reference_no).
                    setString("check_date", to_accounts_receivable_payments.check_date).
                    setString("user_id", to_accounts_receivable_payments.user_id).
                    setString("user_screen_name", to_accounts_receivable_payments.user_screen_name).
                    setNumber("tax_rate", to_accounts_receivable_payments.tax_rate).
                    setNumber("tax_amount", to_accounts_receivable_payments.tax_amount).
                    setString("branch", to_accounts_receivable_payments.branch).
                    setString("branch_id", to_accounts_receivable_payments.branch_id).
                    setString("location", to_accounts_receivable_payments.location).
                    setString("location_id", to_accounts_receivable_payments.location_id).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            //update customers balance
            Lg.s(S1_accounts_receivable_payments.class, "Successfully Added");
            Customers.to_customers cus = ret_customer_balance(to_accounts_receivable_payments.customer_id);
            double new_balance = cus.balance - (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount);
            String s2 = "update  customers set "
                    + "balance= :balance"
                    + " where "
                    + " customer_no ='" + to_accounts_receivable_payments.customer_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2).
                    setNumber("balance", new_balance).
                    ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            //update customers paid
            to_accounts_receivable tar = ret_ar_details(to_accounts_receivable_payments.ar_no);
            double new_paid = tar.paid + (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount);
            String s3 = "update  accounts_receivable set "
                    + "paid= :paid"
                    + " where "
                    + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3).
                    setNumber("paid", new_paid).
                    ok();

            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_accounts_receivable_payments2(to_accounts_receivable_payments to_accounts_receivable_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  accounts_receivable_payments("
                    + "customer_id"
                    + ",customer_name"
                    + ",ar_no"
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
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",or_payment_no"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:ar_no"
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
                    + ",:check_amount"
                    + ",:check_holder"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:ci_no"
                    + ",:trust_receipt"
                    + ",:or_payment_no"
                    + ",:soa_id"
                    + ",:soa_type"
                    + ",:soa_type_id"
                    + ",:reference_no"
                    + ",:check_date"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:tax_rate"
                    + ",:tax_amount"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_id", to_accounts_receivable_payments.customer_id).
                    setString("customer_name", to_accounts_receivable_payments.customer_name).
                    setString("ar_no", to_accounts_receivable_payments.ar_no).
                    setString("date_added", to_accounts_receivable_payments.date_added).
                    setString("user_name", to_accounts_receivable_payments.user_name).
                    setNumber("amount", to_accounts_receivable_payments.amount).
                    setNumber("discount_amount", to_accounts_receivable_payments.discount_amount).
                    setNumber("discount_rate", to_accounts_receivable_payments.discount_rate).
                    setString("discount", to_accounts_receivable_payments.discount).
                    setNumber("status", 1).
                    setNumber("term", to_accounts_receivable_payments.term).
                    setString("date_applied", to_accounts_receivable_payments.date_applied).
                    setNumber("paid", to_accounts_receivable_payments.paid).
                    setString("date_paid", to_accounts_receivable_payments.date_paid).
                    setString("remarks", to_accounts_receivable_payments.remarks).
                    setString("type", to_accounts_receivable_payments.type).
                    setString("or_no", to_accounts_receivable_payments.or_no).
                    setNumber("prev_balance", to_accounts_receivable_payments.prev_balance).
                    setNumber("check_amount", to_accounts_receivable_payments.check_amount).
                    setString("check_holder", to_accounts_receivable_payments.check_holder).
                    setString("check_bank", to_accounts_receivable_payments.check_bank).
                    setString("check_no", to_accounts_receivable_payments.check_no).
                    setString("ci_no", to_accounts_receivable_payments.ci_no).
                    setString("trust_receipt", to_accounts_receivable_payments.trust_receipt).
                    setString("or_payment_no", to_accounts_receivable_payments.or_payment_no).
                    setString("soa_id", to_accounts_receivable_payments.soa_id).
                    setString("soa_type", to_accounts_receivable_payments.soa_type).
                    setString("soa_type_id", to_accounts_receivable_payments.soa_type_id).
                    setString("reference_no", to_accounts_receivable_payments.reference_no).
                    setString("check_date", to_accounts_receivable_payments.check_date).
                    setString("user_id", to_accounts_receivable_payments.user_id).
                    setString("user_screen_name", to_accounts_receivable_payments.user_screen_name).
                    setNumber("tax_rate", to_accounts_receivable_payments.tax_rate).
                    setNumber("tax_amount", to_accounts_receivable_payments.tax_amount).
                    setString("branch", to_accounts_receivable_payments.branch).
                    setString("branch_id", to_accounts_receivable_payments.branch_id).
                    setString("location", to_accounts_receivable_payments.location).
                    setString("location_id", to_accounts_receivable_payments.location_id).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_accounts_receivable_payments3(to_accounts_receivable_payments to_accounts_receivable_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update accounts_receivable_payments set "
                    + "amount= :amount"
                    + ",date_applied= :date_applied"
                    + ",check_amount= :check_amount"
                    + ",check_holder= :check_holder"
                    + ",check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",ci_no= :ci_no"
                    + ",soa_type= :soa_type"
                    + ",soa_type_id= :soa_type_id"
                    + ",reference_no= :reference_no"
                    + ",or_no= :or_no"
                    + ",check_date= :check_date"
                    + " where "
                    + " id ='" + to_accounts_receivable_payments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("amount", to_accounts_receivable_payments.amount)
                    .setString("date_applied", to_accounts_receivable_payments.date_applied)
                    .setNumber("check_amount", to_accounts_receivable_payments.check_amount)
                    .setString("check_holder", to_accounts_receivable_payments.check_holder)
                    .setString("check_bank", to_accounts_receivable_payments.check_bank)
                    .setString("check_no", to_accounts_receivable_payments.check_no)
                    .setString("ci_no", to_accounts_receivable_payments.ci_no)
                    .setString("soa_type", to_accounts_receivable_payments.soa_type)
                    .setString("soa_type_id", to_accounts_receivable_payments.soa_type_id)
                    .setString("reference_no", to_accounts_receivable_payments.reference_no)
                    .setString("or_no", to_accounts_receivable_payments.or_no)
                    .setString("check_date", to_accounts_receivable_payments.check_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_receivable_payments.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_accounts_receivable ret_ar_details(String ar_no1) {
        to_accounts_receivable to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
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
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  accounts_receivable where "
                    + " ar_no ='" + ar_no1 + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
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
                String ci_no = rs.getString(19);
                String trust_receipt = rs.getString(20);
                String soa_id = rs.getString(21);
                String soa_type = rs.getString(22);
                String soa_type_id = rs.getString(22);
                String reference_no = rs.getString(22);
                String user_id = rs.getString(23);
                String user_screen_name = rs.getString(24);
                String branch = rs.getString(25);
                String branch_id = rs.getString(26);
                String location = rs.getString(27);
                String location_id = rs.getString(28);
                to1 = new to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static Customers.to_customers ret_customer_balance(String account_id) {
        Customers.to_customers to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",prepaid"
                    + ",branch"
                    + ",branch_id"
                    + ",location_id"
                    + " from  customers where "
                    + " customer_no ='" + account_id + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                double prepaid = rs.getDouble(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location_id = rs.getString(14);

                to1 = new Customers.to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, prepaid, branch, branch_id, location_id);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static Customers.to_customers ret_customer_balance2(String account_id) {
        Customers.to_customers to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",prepaid"
                    + ",branch"
                    + ",branch_id"
                    + ",location_id"
                    + " from  customers where "
                    + " id ='" + account_id + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                double prepaid = rs.getDouble(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location_id = rs.getString(14);

                to1 = new Customers.to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, prepaid, branch, branch_id, location_id);

            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static Customers.to_customers ret_customer_balance3(String account_id) {
        Customers.to_customers to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",prepaid"
                    + ",branch"
                    + ",branch_id"
                    + ",location_id"
                    + " from  customers where "
                    + " customer_no ='" + account_id + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                double prepaid = rs.getDouble(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location_id = rs.getString(14);

                to1 = new Customers.to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, prepaid, branch, branch_id, location_id);

            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_accounts_receivable_payments(to_accounts_receivable_payments to_accounts_receivable_payments, double previous_cash, double previous_check) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  accounts_receivable_payments set "
                    + "customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",ar_no= :ar_no"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",amount= :amount"
                    + ",discount_amount= :discount_amount"
                    + ",discount_rate= :discount_rate"
                    + ",discount= :discount"
                    + ",status= :status"
                    + ",term= :term"
                    + ",date_applied= :date_applied"
                    + ",paid= :paid"
                    + ",date_paid= :date_paid"
                    + ",remarks= :remarks"
                    + ",type= :type"
                    + ",or_no= :or_no"
                    + ",prev_balance= :prev_balance"
                    + ",check_amount= :check_amount"
                    + ",check_holder= :check_holder"
                    + ",check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",or_payment_no= :or_payment_no"
                    + ",soa_id= :soa_id"
                    + ",tax_rate= :tax_rate"
                    + ",tax_amount= :tax_amount"
                    + " where "
                    + " id ='" + to_accounts_receivable_payments.id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0).
                    setString("customer_id", to_accounts_receivable_payments.customer_id).
                    setString("customer_name", to_accounts_receivable_payments.customer_name).
                    setString("ar_no", to_accounts_receivable_payments.ar_no).
                    setString("date_added", to_accounts_receivable_payments.date_added).
                    setString("user_name", to_accounts_receivable_payments.user_name).
                    setNumber("amount", to_accounts_receivable_payments.amount).
                    setNumber("discount_amount", to_accounts_receivable_payments.discount_amount).
                    setNumber("discount_rate", to_accounts_receivable_payments.discount_rate).
                    setString("discount", to_accounts_receivable_payments.discount).
                    setNumber("status", to_accounts_receivable_payments.status).
                    setNumber("term", to_accounts_receivable_payments.term).
                    setString("date_applied", to_accounts_receivable_payments.date_applied).
                    setNumber("paid", to_accounts_receivable_payments.paid).
                    setString("date_paid", to_accounts_receivable_payments.date_paid).
                    setString("remarks", to_accounts_receivable_payments.remarks).
                    setString("type", to_accounts_receivable_payments.type).
                    setString("or_no", to_accounts_receivable_payments.or_no).
                    setNumber("prev_balance", to_accounts_receivable_payments.prev_balance).
                    setNumber("check_amount", to_accounts_receivable_payments.check_amount).
                    setString("check_holder", to_accounts_receivable_payments.check_holder).
                    setString("check_bank", to_accounts_receivable_payments.check_bank).
                    setString("check_no", to_accounts_receivable_payments.check_no).
                    setString("or_payment_no", to_accounts_receivable_payments.or_payment_no).
                    setString("soa_id", to_accounts_receivable_payments.soa_id).
                    setNumber("tax_rate", to_accounts_receivable_payments.tax_rate).
                    setNumber("tax_amount", to_accounts_receivable_payments.tax_amount).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_receivable_payments.class, "Successfully Updated");

            Customers.to_customers cus = ret_customer_balance(to_accounts_receivable_payments.customer_id);

            double new_balance = (cus.balance + previous_cash + previous_check) - (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount);

            String s2 = "update  customers set "
                    + "balance= :balance"
                    + " where "
                    + " customer_no ='" + to_accounts_receivable_payments.customer_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2).
                    setNumber("balance", new_balance).
                    ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            to_accounts_receivable tar = ret_ar_details(to_accounts_receivable_payments.ar_no);
            double new_paid = (tar.paid + to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount)
                    - (previous_cash + previous_check);

            String s3 = "update  accounts_receivable set "
                    + "paid= :paid"
                    + " where "
                    + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                    + " ";
            s3 = SqlStringUtil.parse(s3).
                    setNumber("paid", new_paid).
                    ok();
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_accounts_receivable_payments(to_accounts_receivable_payments to_accounts_receivable_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  accounts_receivable_payments where "
                    + " id ='" + to_accounts_receivable_payments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_receivable_payments.class, "Successfully Deleted");

            Customers.to_customers cus = ret_customer_balance(to_accounts_receivable_payments.customer_id);
            double new_balance = cus.balance + (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount);
            String s2 = "update  customers set "
                    + "balance= :balance"
                    + " where "
                    + " customer_no ='" + to_accounts_receivable_payments.customer_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2).
                    setNumber("balance", new_balance).
                    ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            to_accounts_receivable tar = ret_ar_details(to_accounts_receivable_payments.ar_no);
            double new_paid = tar.paid - (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount);
            String s3 = "update  accounts_receivable set "
                    + "paid= :paid"
                    + " where "
                    + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                    + " ";
            s3 = SqlStringUtil.parse(s3).
                    setNumber("paid", new_paid).
                    ok();
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_accounts_receivable_payments2(List<to_accounts_receivable_payments> to_accounts_receivable_payments1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_accounts_receivable_payments to_accounts_receivable_payments : to_accounts_receivable_payments1) {
                String s0 = "delete from  accounts_receivable_payments where "
                        + " id ='" + to_accounts_receivable_payments.id + "' "
                        + " ";

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_accounts_receivable_payments.class, "Successfully Deleted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main2(String[] args) {
        String where = " where customer_id='" + "0001" + "'";
        List<to_accounts_receivable_payments> datas = ret_data2(where);
        for (to_accounts_receivable_payments to : datas) {
            System.out.println(to.amount + " = " + to.paid);
        }
    }

    public static List<to_accounts_receivable_payments> ret_data(String search) {
        List<to_accounts_receivable_payments> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
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
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",or_payment_no"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  accounts_receivable_payments where "
                    + " ar_no ='" + search + "' order by Date(date_applied) asc"
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
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
                double check_amount = rs.getDouble(20);
                String check_holder = rs.getString(21);
                String check_bank = rs.getString(22);
                String check_no = rs.getString(23);
                String ci_no = rs.getString(24);
                String trust_receipt = rs.getString(25);
                String or_payment_no = rs.getString(26);
                String soa_id = rs.getString(27);
                String soa_type = rs.getString(28);
                String soa_type_id = rs.getString(29);
                String reference_no = rs.getString(30);
                String check_date = rs.getString(31);
                String user_id = rs.getString(32);
                String user_screen_name = rs.getString(33);
                double tax_rate = rs.getDouble(34);
                double tax_amount = rs.getDouble(35);
                String branch = rs.getString(36);
                String branch_id = rs.getString(37);
                String location = rs.getString(38);
                String location_id = rs.getString(39);
                to_accounts_receivable_payments to = new to_accounts_receivable_payments(id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id, soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static List<to_accounts_receivable_payments> ret_data2(String where) {
        List<to_accounts_receivable_payments> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
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
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",or_payment_no"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  accounts_receivable_payments  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
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
                double check_amount = rs.getDouble(20);
                String check_holder = rs.getString(21);
                String check_bank = rs.getString(22);
                String check_no = rs.getString(23);
                String ci_no = rs.getString(24);
                String trust_receipt = rs.getString(25);
                String or_payment_no = rs.getString(26);
                String soa_id = rs.getString(27);
                String soa_type = rs.getString(28);
                String soa_type_id = rs.getString(29);
                String reference_no = rs.getString(30);
                String check_date = rs.getString(31);
                String user_id = rs.getString(32);
                String user_screen_name = rs.getString(33);
                double tax_rate = rs.getDouble(34);
                double tax_amount = rs.getDouble(35);
                String branch = rs.getString(36);
                String branch_id = rs.getString(37);
                String location = rs.getString(38);
                String location_id = rs.getString(39);
                to_accounts_receivable_payments to = new to_accounts_receivable_payments(id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id, soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_accounts_receivable_payments(List<to_accounts_receivable_payments> to_accounts_receivable_payments1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_accounts_receivable_payments to_accounts_receivable_payments : to_accounts_receivable_payments1) {
                String s0 = "update accounts_receivable_payments set "
                        + "status= :status"
                        + " where "
                        + " id ='" + to_accounts_receivable_payments.id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setNumber("status", 0)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_accounts_receivable_payments.class, "Successfully Updated");

                //update customers balance
                Lg.s(S1_accounts_receivable_payments.class, "Successfully Added");
                Customers.to_customers cus = ret_customer_balance(to_accounts_receivable_payments.customer_id);
                double new_balance = cus.balance - (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount);
                String s2 = "update  customers set "
                        + "balance= :balance"
                        + " where "
                        + " customer_no ='" + to_accounts_receivable_payments.customer_id + "' "
                        + " ";
                s2 = SqlStringUtil.parse(s2).
                        setNumber("balance", new_balance).
                        ok();
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

                //update customers paid
                to_accounts_receivable tar = ret_ar_details(to_accounts_receivable_payments.ar_no);
                double new_paid = tar.paid + (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount);
                String s3 = "update  accounts_receivable set "
                        + "paid= :paid"
                        + " where "
                        + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                        + " ";

                s3 = SqlStringUtil.parse(s3).
                        setNumber("paid", new_paid).
                        ok();

                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();
                System.out.println("Info: " + to_accounts_receivable_payments.customer_id + "," + to_accounts_receivable_payments.ar_no);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
