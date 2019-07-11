/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_sales;

import POS.accounts_receivable.S1_accounts_receivable_payments;
import static POS.accounts_receivable.S1_accounts_receivable_payments.ret_customer_balance;
import POS.customers.Customers;
import POS.prepaid_payments.Prepaid_payments;
import POS.users.MyUser;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronescape
 */
public class MySale_tips {

    public static class to_sale_tips {

        public final int id;
        public final String sales_no;
        public final String date_added;
        public final String user_screen_name;
        public final String user_id;
        public final double tip;
        public final String prepaid_customer_name;
        public final String prepaid_customer_id;
        public final double prepaid_amount;
        public final String charge_reference_no;
        public final String charge_ar_no;
        public final String charge_type;
        public final String charge_customer_name;
        public final String charge_customer_id;
        public final double charge_amount;
        public final int charge_days;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_sale_tips(int id, String sales_no, String date_added, String user_screen_name, String user_id, double tip, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String charge_reference_no, String charge_ar_no, String charge_type, String charge_customer_name, String charge_customer_id, double charge_amount, int charge_days, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_screen_name = user_screen_name;
            this.user_id = user_id;
            this.tip = tip;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.charge_reference_no = charge_reference_no;
            this.charge_ar_no = charge_ar_no;
            this.charge_type = charge_type;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.charge_days = charge_days;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_sale_tips to_sale_tips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sale_tips("
                    + "sales_no"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",tip"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_screen_name"
                    + ",:user_id"
                    + ",:tip"
                    + ",:prepaid_customer_name"
                    + ",:prepaid_customer_id"
                    + ",:prepaid_amount"
                    + ",:charge_reference_no"
                    + ",:charge_ar_no"
                    + ",:charge_type"
                    + ",:charge_customer_name"
                    + ",:charge_customer_id"
                    + ",:charge_amount"
                    + ",:charge_days"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sale_tips.sales_no)
                    .setString("date_added", to_sale_tips.date_added)
                    .setString("user_screen_name", to_sale_tips.user_screen_name)
                    .setString("user_id", to_sale_tips.user_id)
                    .setNumber("tip", to_sale_tips.tip)
                    .setString("prepaid_customer_name", to_sale_tips.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_sale_tips.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_sale_tips.prepaid_amount)
                    .setString("charge_reference_no", to_sale_tips.charge_reference_no)
                    .setString("charge_ar_no", to_sale_tips.charge_ar_no)
                    .setString("charge_type", to_sale_tips.charge_type)
                    .setString("charge_customer_name", to_sale_tips.charge_customer_name)
                    .setString("charge_customer_id", to_sale_tips.charge_customer_id)
                    .setNumber("charge_amount", to_sale_tips.charge_amount)
                    .setNumber("charge_days", to_sale_tips.charge_days)
                    .setString("branch", to_sale_tips.branch)
                    .setString("branch_id", to_sale_tips.branch_id)
                    .setString("location", to_sale_tips.location)
                    .setString("location_id", to_sale_tips.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(MySale_tips.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_tip(to_sale_tips to_sale_tips) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into sale_tips("
                    + "sales_no"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",tip"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_screen_name"
                    + ",:user_id"
                    + ",:tip"
                    + ",:prepaid_customer_name"
                    + ",:prepaid_customer_id"
                    + ",:prepaid_amount"
                    + ",:charge_reference_no"
                    + ",:charge_ar_no"
                    + ",:charge_type"
                    + ",:charge_customer_name"
                    + ",:charge_customer_id"
                    + ",:charge_amount"
                    + ",:charge_days"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sale_tips.sales_no)
                    .setString("date_added", to_sale_tips.date_added)
                    .setString("user_screen_name", to_sale_tips.user_screen_name)
                    .setString("user_id", to_sale_tips.user_id)
                    .setNumber("tip", to_sale_tips.tip)
                    .setString("prepaid_customer_name", to_sale_tips.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_sale_tips.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_sale_tips.prepaid_amount)
                    .setString("charge_reference_no", to_sale_tips.charge_reference_no)
                    .setString("charge_ar_no", to_sale_tips.charge_ar_no)
                    .setString("charge_type", to_sale_tips.charge_type)
                    .setString("charge_customer_name", to_sale_tips.charge_customer_name)
                    .setString("charge_customer_id", to_sale_tips.charge_customer_id)
                    .setNumber("charge_amount", to_sale_tips.charge_amount)
                    .setNumber("charge_days", to_sale_tips.charge_days)
                    .setString("branch", to_sale_tips.branch)
                    .setString("branch_id", to_sale_tips.branch_id)
                    .setString("location", to_sale_tips.location)
                    .setString("location_id", to_sale_tips.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            if (to_sale_tips.prepaid_amount > 0) {

                int id = -1;
                double cash = to_sale_tips.prepaid_amount;
                double check_amount = 0;

                String check_bank = "";
                String check_no = "";
                String added_by = MyUser.getUser_id();
                String date_added = DateType.now();
                String customer_name = to_sale_tips.prepaid_customer_name;
                String customer_id = "" + to_sale_tips.prepaid_customer_id;
                String cheque_holder = "";
                String cheque_date = DateType.sf.format(new Date());
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                String branch = to_sale_tips.branch;
                String branch_id = to_sale_tips.branch_id;
                String location = to_sale_tips.location;
                String location_id = to_sale_tips.location_id;
                String remarks = "Tip: ";

                String credit_card_type = "";
                double credit_card_rate = 0;
                String credit_card_no = "";
                String credit_card_holder = "";
                double credit_card_amount = 0;
                String gift_certificate_from = "";
                String gift_certificate_description = "";
                String gift_certificate_no = "";
                double gift_certificate_amount = 0;
                String online_bank = "";
                String online_reference_no = "";
                String online_holder = "";
                String online_date = DateType.sf.format(new Date());
                double online_amount = 0;

                Prepaid_payments.to_prepaid_payments to_prepaid_payments = new Prepaid_payments.to_prepaid_payments(id, cash, check_bank, check_no, check_amount, added_by, date_added, customer_name, customer_id, 1, true, cheque_holder, cheque_date, user_id, user_screen_name, branch, branch_id, location, location_id, remarks, id, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder, online_date, online_amount);
                //<editor-fold defaultstate="collapsed" desc=" prepaid ">
                String s8 = "insert into prepaid_payments("
                        + " cash"
                        + ",check_bank"
                        + ",check_no"
                        + ",check_amount"
                        + ",added_by"
                        + ",date_added"
                        + ",customer_name"
                        + ",customer_id"
                        + ",status"
                        + ",cheque_holder"
                        + ",cheque_date"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",remarks"
                        + ",refund"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_amount"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",gift_certificate_amount"
                        + ",online_bank"
                        + ",online_reference_no"
                        + ",online_holder"
                        + ",online_date"
                        + ",online_amount"
                        + ")values("
                        + ":cash"
                        + ",:check_bank"
                        + ",:check_no"
                        + ",:check_amount"
                        + ",:added_by"
                        + ",:date_added"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:status"
                        + ",:cheque_holder"
                        + ",:cheque_date"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:remarks"
                        + ",:refund"
                        + ",:credit_card_type"
                        + ",:credit_card_rate"
                        + ",:credit_card_no"
                        + ",:credit_card_holder"
                        + ",:credit_card_amount"
                        + ",:gift_certificate_from"
                        + ",:gift_certificate_description"
                        + ",:gift_certificate_no"
                        + ",:gift_certificate_amount"
                        + ",:online_bank"
                        + ",:online_reference_no"
                        + ",:online_holder"
                        + ",:online_date"
                        + ",:online_amount"
                        + ")";

                s8 = SqlStringUtil.parse(s8)
                        .setNumber("cash", to_prepaid_payments.cash)
                        .setString("check_bank", to_prepaid_payments.check_bank)
                        .setString("check_no", to_prepaid_payments.check_no)
                        .setNumber("check_amount", to_prepaid_payments.check_amount)
                        .setString("added_by", to_prepaid_payments.added_by)
                        .setString("date_added", to_prepaid_payments.date_added)
                        .setString("customer_name", to_prepaid_payments.customer_name)
                        .setString("customer_id", to_prepaid_payments.customer_id)
                        .setNumber("status", to_prepaid_payments.status)
                        .setString("cheque_holder", to_prepaid_payments.cheque_holder)
                        .setString("cheque_date", to_prepaid_payments.cheque_date)
                        .setString("user_id", to_prepaid_payments.user_id)
                        .setString("user_screen_name", to_prepaid_payments.user_screen_name)
                        .setString("branch", to_prepaid_payments.branch)
                        .setString("branch_id", to_prepaid_payments.branch_id)
                        .setString("location", to_prepaid_payments.location)
                        .setString("location_id", to_prepaid_payments.location_id)
                        .setString("remarks", to_prepaid_payments.remarks)
                        .setNumber("refund", to_prepaid_payments.refund)
                        .setString("credit_card_type", to_prepaid_payments.credit_card_type)
                        .setNumber("credit_card_rate", to_prepaid_payments.credit_card_rate)
                        .setString("credit_card_no", to_prepaid_payments.credit_card_no)
                        .setString("credit_card_holder", to_prepaid_payments.credit_card_holder)
                        .setNumber("credit_card_amount", to_prepaid_payments.credit_card_amount)
                        .setString("gift_certificate_from", to_prepaid_payments.gift_certificate_from)
                        .setString("gift_certificate_description", to_prepaid_payments.gift_certificate_description)
                        .setString("gift_certificate_no", to_prepaid_payments.gift_certificate_no)
                        .setNumber("gift_certificate_amount", to_prepaid_payments.gift_certificate_amount)
                        .setString("online_bank", to_prepaid_payments.online_bank)
                        .setString("online_reference_no", to_prepaid_payments.online_reference_no)
                        .setString("online_holder", to_prepaid_payments.online_holder)
                        .setString("online_date", to_prepaid_payments.online_date)
                        .setNumber("online_amount", to_prepaid_payments.online_amount)
                        .ok();
                stmt.addBatch(s8);

                Customers.to_customers cus = S1_accounts_receivable_payments.ret_customer_balance2(to_sale_tips.prepaid_customer_id);
                double new_balance = cus.prepaid + (to_prepaid_payments.cash + to_prepaid_payments.check_amount + to_prepaid_payments.credit_card_amount + to_prepaid_payments.gift_certificate_amount + to_prepaid_payments.online_amount);
                String s9 = "update  customers set "
                        + " prepaid= :prepaid"
                        + " where "
                        + " id ='" + to_prepaid_payments.customer_id + "' "
                        + " ";
                s9 = SqlStringUtil.parse(s9).
                        setNumber("prepaid", new_balance).
                        ok();
                stmt.addBatch(s9);

                //</editor-fold>
            }
            if (to_sale_tips.charge_amount > 0) {
                String customer_id = to_sale_tips.charge_customer_id;
                String customer_name = to_sale_tips.charge_customer_name;
                String ar_no = to_sale_tips.charge_ar_no;
                String date_added = DateType.datetime.format(new Date());
                String user_name = Users.user_name;
                double amount = to_sale_tips.charge_amount;
                double discount_amount = 0;
                double discount_rate = 0;
                String discount = "";
                int status = 0;
                double term = 0;
                String date_applied = DateType.sf.format(new Date());
                double paid = 0;
                String date_paid = DateType.sf.format(new Date());
                String remarks = "";
                String type = "CASH";
                String or_no = "";
                double prev_balance = 0;
                double check_amount = 0;
                String check_holder = "";
                String check_bank = "";
                String check_no = "";
                String ci_no = "";//tf_or_no.getText();
                String trust_receipt = to_sale_tips.charge_reference_no;//tf_or_no.getText();
                String or_payment_no = "";
                String soa_id = "1";
                String soa_type = to_sale_tips.charge_type;
                String soa_type_id = "1";
                String reference_no = to_sale_tips.charge_reference_no;
                String check_date = DateType.sf.format(new Date());
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                double tax_rate = 0;
                double tax_amount = 0;

                String branch = to_sale_tips.branch;
                String branch_id = to_sale_tips.branch_id;
                String location = to_sale_tips.location;
                String location_id = to_sale_tips.location_id;

                String prepaid_customer_name = "";
                String prepaid_customer_id = "";
                double prepaid_amount = 0;
                String credit_card_type = "";
                double credit_card_rate = 0;
                String credit_card_no = "";
                String credit_card_holder = "";
                double credit_card_amount = 0;
                String gift_certificate_from = "";
                String gift_certificate_description = "";
                String gift_certificate_no = "";
                double gift_certificate_amount = 0;
                String online_bank = "";
                String online_reference_no = "";
                String online_holder = "";
                String online_date = DateType.now();
                double online_amount = 0;
                double actual_amount = (amount + check_amount) - discount_amount;
                double retention = 0;
                double business_tax = 0;
                double salary_deduction = 0;
                final S1_accounts_receivable_payments.to_accounts_receivable_payments to_accounts_receivable_payments = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                        status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid,
                        date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id,
                        soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location,
                        location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no,
                        credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount,
                        online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount, retention, business_tax, salary_deduction);

                //<editor-fold defaultstate="collapsed" desc=" Add AR Payment ">
                String s13 = "insert into  accounts_receivable_payments("
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
                        + ",prepaid_customer_name"
                        + ",prepaid_customer_id"
                        + ",prepaid_amount"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_amount"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",gift_certificate_amount"
                        + ",online_bank"
                        + ",online_reference_no"
                        + ",online_holder"
                        + ",online_date"
                        + ",online_amount"
                        + ",actual_amount"
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
                        + ",:prepaid_customer_name"
                        + ",:prepaid_customer_id"
                        + ",:prepaid_amount"
                        + ",:credit_card_type"
                        + ",:credit_card_rate"
                        + ",:credit_card_no"
                        + ",:credit_card_holder"
                        + ",:credit_card_amount"
                        + ",:gift_certificate_from"
                        + ",:gift_certificate_description"
                        + ",:gift_certificate_no"
                        + ",:gift_certificate_amount"
                        + ",:online_bank"
                        + ",:online_reference_no"
                        + ",:online_holder"
                        + ",:online_date"
                        + ",:online_amount"
                        + ",:actual_amount"
                        + ")";

                s13 = SqlStringUtil.parse(s13).
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
                        setString("location_id", to_accounts_receivable_payments.location_id)
                        .setString("prepaid_customer_name", to_accounts_receivable_payments.prepaid_customer_name)
                        .setString("prepaid_customer_id", to_accounts_receivable_payments.prepaid_customer_id)
                        .setNumber("prepaid_amount", to_accounts_receivable_payments.prepaid_amount)
                        .setString("credit_card_type", to_accounts_receivable_payments.credit_card_type)
                        .setNumber("credit_card_rate", to_accounts_receivable_payments.credit_card_rate)
                        .setString("credit_card_no", to_accounts_receivable_payments.credit_card_no)
                        .setString("credit_card_holder", to_accounts_receivable_payments.credit_card_holder)
                        .setNumber("credit_card_amount", to_accounts_receivable_payments.credit_card_amount)
                        .setString("gift_certificate_from", to_accounts_receivable_payments.gift_certificate_from)
                        .setString("gift_certificate_description", to_accounts_receivable_payments.gift_certificate_description)
                        .setString("gift_certificate_no", to_accounts_receivable_payments.gift_certificate_no)
                        .setNumber("gift_certificate_amount", to_accounts_receivable_payments.gift_certificate_amount)
                        .setString("online_bank", to_accounts_receivable_payments.online_bank)
                        .setString("online_reference_no", to_accounts_receivable_payments.online_reference_no)
                        .setString("online_holder", to_accounts_receivable_payments.online_holder)
                        .setString("online_date", to_accounts_receivable_payments.online_date)
                        .setNumber("online_amount", to_accounts_receivable_payments.online_amount)
                        .setNumber("actual_amount", to_accounts_receivable_payments.actual_amount)
                        .ok();

                stmt.addBatch(s13);

                Customers.to_customers cus = ret_customer_balance(to_accounts_receivable_payments.customer_id);
                double tendered = to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount + to_accounts_receivable_payments.prepaid_amount + to_accounts_receivable_payments.credit_card_amount + to_accounts_receivable_payments.gift_certificate_amount + to_accounts_receivable_payments.online_amount;
                double new_balance = cus.balance - (tendered + to_accounts_receivable_payments.discount_amount);
                double actual_amount2 = to_accounts_receivable_payments.actual_amount;

                String s14 = "update  customers set "
                        + " balance= :balance"
                        + " where "
                        + " customer_no ='" + to_accounts_receivable_payments.customer_id + "' "
                        + " ";
                s14 = SqlStringUtil.parse(s14).
                        setNumber("balance", new_balance).
                        ok();
                stmt.addBatch(s14);

                String s15 = "select "
                        + " paid"
                        + " from  accounts_receivable where "
                        + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                        + " ";
                double paid2 = 0;
                Statement stmt15 = conn.createStatement();
                ResultSet rs15 = stmt15.executeQuery(s15);
                while (rs15.next()) {
                    paid2 = rs15.getDouble(1);
                }

                double new_paid = paid2 + (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount + to_accounts_receivable_payments.discount_amount);
                String s16 = "update  accounts_receivable set "
                        + "paid= :paid"
                        + " where "
                        + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                        + " ";

                s16 = SqlStringUtil.parse(s16).
                        setNumber("paid", new_paid).
                        ok();

                stmt.addBatch(s16);

                //</editor-fold>
            }
            stmt.executeBatch();
            conn.commit();

            Lg.s(MySale_tips.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_sale_tips to_sale_tips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sale_tips set "
                    + "sales_no= :sales_no "
                    + ",date_added= :date_added "
                    + ",user_screen_name= :user_screen_name "
                    + ",user_id= :user_id "
                    + ",tip= :tip "
                    + ",prepaid_customer_name= :prepaid_customer_name "
                    + ",prepaid_customer_id= :prepaid_customer_id "
                    + ",prepaid_amount= :prepaid_amount "
                    + ",charge_reference_no= :charge_reference_no "
                    + ",charge_ar_no= :charge_ar_no "
                    + ",charge_type= :charge_type "
                    + ",charge_customer_name= :charge_customer_name "
                    + ",charge_customer_id= :charge_customer_id "
                    + ",charge_amount= :charge_amount "
                    + ",charge_days= :charge_days "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_sale_tips.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sale_tips.sales_no)
                    .setString("date_added", to_sale_tips.date_added)
                    .setString("user_screen_name", to_sale_tips.user_screen_name)
                    .setString("user_id", to_sale_tips.user_id)
                    .setNumber("tip", to_sale_tips.tip)
                    .setString("prepaid_customer_name", to_sale_tips.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_sale_tips.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_sale_tips.prepaid_amount)
                    .setString("charge_reference_no", to_sale_tips.charge_reference_no)
                    .setString("charge_ar_no", to_sale_tips.charge_ar_no)
                    .setString("charge_type", to_sale_tips.charge_type)
                    .setString("charge_customer_name", to_sale_tips.charge_customer_name)
                    .setString("charge_customer_id", to_sale_tips.charge_customer_id)
                    .setNumber("charge_amount", to_sale_tips.charge_amount)
                    .setNumber("charge_days", to_sale_tips.charge_days)
                    .setString("branch", to_sale_tips.branch)
                    .setString("branch_id", to_sale_tips.branch_id)
                    .setString("location", to_sale_tips.location)
                    .setString("location_id", to_sale_tips.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(MySale_tips.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_sale_tips to_sale_tips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sale_tips  "
                    + " where id='" + to_sale_tips.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(MySale_tips.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sale_tips> ret_data(String where) {
        List<to_sale_tips> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",tip"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from sale_tips"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String user_id = rs.getString(5);
                double tip = rs.getDouble(6);
                String prepaid_customer_name = rs.getString(7);
                String prepaid_customer_id = rs.getString(8);
                double prepaid_amount = rs.getDouble(9);
                String charge_reference_no = rs.getString(10);
                String charge_ar_no = rs.getString(11);
                String charge_type = rs.getString(12);
                String charge_customer_name = rs.getString(13);
                String charge_customer_id = rs.getString(14);
                double charge_amount = rs.getDouble(15);
                int charge_days = rs.getInt(16);
                String branch = rs.getString(17);
                String branch_id = rs.getString(18);
                String location = rs.getString(19);
                String location_id = rs.getString(20);

                to_sale_tips to = new to_sale_tips(id, sales_no, date_added, user_screen_name, user_id, tip, prepaid_customer_name, prepaid_customer_id, prepaid_amount, charge_reference_no, charge_ar_no, charge_type, charge_customer_name, charge_customer_id, charge_amount, charge_days, branch, branch_id, location, location_id);
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
