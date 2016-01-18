/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.charge_payments;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Charge_payments {

    public static class to_charge_payments {

        public final int id;
        public final String sales_no;
        public final String date_added;
        public final String user_name;
        public final String session_no;
        public final double gross_amount;
        public final double amount_paid;
        public final double amount_due;
        public final String discount_name;
        public final double discount;
        public final double discount_amount;
        public final String customer_name;
        public final String check_bank;
        public final String check_no;
        public final double check_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final int status;
        public final String or_no;
        public final String check_holder;
        public final String services;
        public final double service_amount;
        public final String charge_account_name;
        public final double charge_amount;
        public final String charge_account_id;
        public final double credit_card;
        public final String credit_card_name;
        public final double credit_card_rate;
        public final double credit_card_amount;
        public final int sales_type;

        public to_charge_payments(int id, String sales_no, String date_added, String user_name, String session_no, double gross_amount, double amount_paid, double amount_due, String discount_name, double discount, double discount_amount, String customer_name, String check_bank, String check_no, double check_amount, String discount_customer_name, String discount_customer_id, int status, String or_no, String check_holder, String services, double service_amount, String charge_account_name, double charge_amount, String charge_account_id, double credit_card, String credit_card_name, double credit_card_rate, double credit_card_amount, int sales_type) {
            this.id = id;
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_name = user_name;
            this.session_no = session_no;
            this.gross_amount = gross_amount;
            this.amount_paid = amount_paid;
            this.amount_due = amount_due;
            this.discount_name = discount_name;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.customer_name = customer_name;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.status = status;
            this.or_no = or_no;
            this.check_holder = check_holder;
            this.services = services;
            this.service_amount = service_amount;
            this.charge_account_name = charge_account_name;
            this.charge_amount = charge_amount;
            this.charge_account_id = charge_account_id;
            this.credit_card = credit_card;
            this.credit_card_name = credit_card_name;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.sales_type = sales_type;
        }
    }

    public static void add_charge_payments(to_charge_payments to_charge_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into charge_payments("
                    + "sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",charge_account_name"
                    + ",charge_amount"
                    + ",charge_account_id"
                    + ",credit_card"
                    + ",credit_card_name"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",sales_type"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:gross_amount"
                    + ",:amount_paid"
                    + ",:amount_due"
                    + ",:discount_name"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:customer_name"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:status"
                    + ",:or_no"
                    + ",:check_holder"
                    + ",:services"
                    + ",:service_amount"
                    + ",:charge_account_name"
                    + ",:charge_amount"
                    + ",:charge_account_id"
                    + ",:credit_card"
                    + ",:credit_card_name"
                    + ",:credit_card_rate"
                    + ",:credit_card_amount"
                    + ",:sales_type"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_charge_payments.sales_no)
                    .setString("date_added", to_charge_payments.date_added)
                    .setString("user_name", to_charge_payments.user_name)
                    .setString("session_no", to_charge_payments.session_no)
                    .setNumber("gross_amount", to_charge_payments.gross_amount)
                    .setNumber("amount_paid", to_charge_payments.amount_paid)
                    .setNumber("amount_due", to_charge_payments.amount_due)
                    .setString("discount_name", to_charge_payments.discount_name)
                    .setNumber("discount", to_charge_payments.discount)
                    .setNumber("discount_amount", to_charge_payments.discount_amount)
                    .setString("customer_name", to_charge_payments.customer_name)
                    .setString("check_bank", to_charge_payments.check_bank)
                    .setString("check_no", to_charge_payments.check_no)
                    .setNumber("check_amount", to_charge_payments.check_amount)
                    .setString("discount_customer_name", to_charge_payments.discount_customer_name)
                    .setString("discount_customer_id", to_charge_payments.discount_customer_id)
                    .setNumber("status", to_charge_payments.status)
                    .setString("or_no", to_charge_payments.or_no)
                    .setString("check_holder", to_charge_payments.check_holder)
                    .setString("services", to_charge_payments.services)
                    .setNumber("service_amount", to_charge_payments.service_amount)
                    .setString("charge_account_name", to_charge_payments.charge_account_name)
                    .setNumber("charge_amount", to_charge_payments.charge_amount)
                    .setString("charge_account_id", to_charge_payments.charge_account_id)
                    .setNumber("credit_card", to_charge_payments.credit_card)
                    .setString("credit_card_name", to_charge_payments.credit_card_name)
                    .setNumber("credit_card_rate", to_charge_payments.credit_card_rate)
                    .setNumber("credit_card_amount", to_charge_payments.credit_card_amount)
                    .setNumber("sales_type", to_charge_payments.sales_type)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Charge_payments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_charge_payments> ret_data(String where) {
        List<to_charge_payments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",charge_account_name"
                    + ",charge_amount"
                    + ",charge_account_id"
                    + ",credit_card"
                    + ",credit_card_name"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",sales_type"
                    + " from charge_payments  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String charge_account_name = rs.getString(23);
                double charge_amount = rs.getDouble(24);
                String charge_account_id = rs.getString(25);
                double credit_card = rs.getDouble(26);
                String credit_card_name = rs.getString(27);
                double credit_card_rate = rs.getDouble(28);
                double credit_card_amount = rs.getDouble(29);
                int sales_type = rs.getInt(30);

                to_charge_payments to = new to_charge_payments(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, charge_account_name, charge_amount, charge_account_id, credit_card, credit_card_name, credit_card_rate, credit_card_amount, sales_type);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "TR-0000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from charge_payments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select sales_no from charge_payments where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "TR-0000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
