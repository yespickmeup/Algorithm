/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_payments;

import POS.accounts_receivable.S1_accounts_receivable_payments;
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
 * @author Guinness
 */
public class Prepaid_payments {

    public static class to_prepaid_payments {

        public final int id;
        public final double cash;
        public final String check_bank;
        public final String check_no;
        public final double check_amount;
        public final String added_by;
        public final String date_added;
        public final String customer_name;
        public final String customer_id;
        public final int status;
        public boolean selected;
        public final String cheque_holder;
        public final String cheque_date;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String remarks;
        public final int refund;
        public final String credit_card_type;
        public final double credit_card_rate;
        public final String credit_card_no;
        public final String credit_card_holder;
        public final double credit_card_amount;
        public final String gift_certificate_from;
        public final String gift_certificate_description;
        public final String gift_certificate_no;
        public final double gift_certificate_amount;
        public final String online_bank;
        public final String online_reference_no;
        public final String online_holder;
        public final String online_date;
        public final double online_amount;

        public to_prepaid_payments(int id, double cash, String check_bank, String check_no, double check_amount, String added_by, String date_added, String customer_name, String customer_id, int status, boolean selected, String cheque_holder, String cheque_date, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id,
                String remarks, int refund, String credit_card_type, double credit_card_rate, String credit_card_no, String credit_card_holder, double credit_card_amount, String gift_certificate_from, String gift_certificate_description, String gift_certificate_no, double gift_certificate_amount, String online_bank, String online_reference_no, String online_holder, String online_date, double online_amount) {
            this.id = id;
            this.cash = cash;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.added_by = added_by;
            this.date_added = date_added;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.status = status;
            this.selected = selected;
            this.cheque_holder = cheque_holder;
            this.cheque_date = cheque_date;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.remarks = remarks;
            this.refund = refund;
            this.credit_card_type = credit_card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_amount = credit_card_amount;
            this.gift_certificate_from = gift_certificate_from;
            this.gift_certificate_description = gift_certificate_description;
            this.gift_certificate_no = gift_certificate_no;
            this.gift_certificate_amount = gift_certificate_amount;
            this.online_bank = online_bank;
            this.online_reference_no = online_reference_no;
            this.online_holder = online_holder;
            this.online_date = online_date;
            this.online_amount = online_amount;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_prepaid_payments(to_prepaid_payments to_prepaid_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into prepaid_payments("
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

            s0 = SqlStringUtil.parse(s0)
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

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Prepaid_payments.class, "Successfully Added");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_prepaid_payments_cloud(to_prepaid_payments to_prepaid_payments) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into prepaid_payments("
                    + "cash"
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

            s0 = SqlStringUtil.parse(s0)
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

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update prepaid_payments set is_uploaded=1 where id='" + to_prepaid_payments.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Prepaid_payments.class, "Successfully Added: " + to_prepaid_payments.id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_prepaid_payments(to_prepaid_payments to_prepaid_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update prepaid_payments set "
                    + "cash= :cash "
                    + ",check_bank= :check_bank "
                    + ",check_no= :check_no "
                    + ",check_amount= :check_amount "
                    //                    + ",added_by= :added_by "
                    //                    + ",date_added= :date_added "
                    //                    + ",customer_name= :customer_name "
                    //                    + ",customer_id= :customer_id "
                    //                    + ",status= :status "
                    + ",cheque_holder= :cheque_holder "
                    + ",cheque_date= :cheque_date "
                    + ",remarks= :remarks "
                    + ",credit_card_type= :credit_card_type "
                    + ",credit_card_rate= :credit_card_rate "
                    + ",credit_card_no= :credit_card_no "
                    + ",credit_card_holder= :credit_card_holder "
                    + ",credit_card_amount= :credit_card_amount "
                    + ",gift_certificate_from= :gift_certificate_from "
                    + ",gift_certificate_description= :gift_certificate_description "
                    + ",gift_certificate_no= :gift_certificate_no "
                    + ",gift_certificate_amount= :gift_certificate_amount "
                    + ",online_bank= :online_bank "
                    + ",online_reference_no= :online_reference_no "
                    + ",online_holder= :online_holder "
                    + ",online_date= :online_date "
                    + ",online_amount= :online_amount "
                    //                    + ",user_id= :user_id "
                    //                    + ",user_screen_name= :user_screen_name "
                    //                    + ",branch= :branch "
                    //                    + ",branch_id= :branch_id "
                    //                    + ",location= :location "
                    //                    + ",location_id= :location_id "
                    + " where id='" + to_prepaid_payments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("cash", to_prepaid_payments.cash)
                    .setString("check_bank", to_prepaid_payments.check_bank)
                    .setString("check_no", to_prepaid_payments.check_no)
                    .setNumber("check_amount", to_prepaid_payments.check_amount)
                    //                    .setString("added_by", to_prepaid_payments.added_by)
                    //                    .setString("date_added", to_prepaid_payments.date_added)
                    //                    .setString("customer_name", to_prepaid_payments.customer_name)
                    //                    .setString("customer_id", to_prepaid_payments.customer_id)
                    //                    .setNumber("status", to_prepaid_payments.status)
                    .setString("cheque_holder", to_prepaid_payments.cheque_holder)
                    .setString("cheque_date", to_prepaid_payments.cheque_date)
                    .setString("remarks", to_prepaid_payments.remarks)
                    //                    .setString("user_id", to_prepaid_payments.user_id)
                    //                    .setString("user_screen_name", to_prepaid_payments.user_screen_name)
                    //                    .setString("branch", to_prepaid_payments.branch)
                    //                    .setString("branch_id", to_prepaid_payments.branch_id)
                    //                    .setString("location", to_prepaid_payments.location)
                    //                    .setString("location_id", to_prepaid_payments.location_id)
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

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Prepaid_payments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize(List<to_prepaid_payments> to_prepaid_payments1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_prepaid_payments to_prepaid_payments : to_prepaid_payments1) {
                if (to_prepaid_payments.status == 0) {
                    String s0 = "update prepaid_payments set "
                            + " status= :status"
                            + " where "
                            + " id= '" + to_prepaid_payments.id + "'";
                    s0 = SqlStringUtil.parse(s0)
                            .setNumber("status", 1)
                            .ok();
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(Prepaid_payments.class, "Successfully Updated");

                    Customers.to_customers cus = S1_accounts_receivable_payments.ret_customer_balance2(to_prepaid_payments.customer_id);
                    double new_balance = cus.prepaid + (to_prepaid_payments.cash + to_prepaid_payments.check_amount+to_prepaid_payments.credit_card_amount+to_prepaid_payments.gift_certificate_amount+to_prepaid_payments.online_amount);
                    String s2 = "update  customers set "
                            + " prepaid= :prepaid"
                            + " where "
                            + " id ='" + to_prepaid_payments.customer_id + "' "
                            + " ";
                    s2 = SqlStringUtil.parse(s2).
                            setNumber("prepaid", new_balance).
                            ok();
                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_prepaid_payments(to_prepaid_payments to_prepaid_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from prepaid_payments where "
                    + " id ='" + to_prepaid_payments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Prepaid_payments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_prepaid_payments_finalized(to_prepaid_payments to_prepaid_payments) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
            String s0 = "update prepaid_payments set status=2 where "
                    + " id ='" + to_prepaid_payments.id + "' "
                    + " ";

            stmt.addBatch(s0);

            Customers.to_customers cus = S1_accounts_receivable_payments.ret_customer_balance2(to_prepaid_payments.customer_id);
            double new_balance = cus.prepaid - (to_prepaid_payments.cash + to_prepaid_payments.check_amount);
            String s2 = "update  customers set "
                    + " prepaid= :prepaid"
                    + " where "
                    + " id ='" + to_prepaid_payments.customer_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2).
                    setNumber("prepaid", new_balance).
                    ok();

            stmt.addBatch(s2);
            stmt.executeBatch();
            conn.commit();
            Lg.s(Prepaid_payments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_prepaid_payments> ret_data(String where) {
        List<to_prepaid_payments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",cash"
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
                    + " from prepaid_payments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                double cash = rs.getDouble(2);
                String check_bank = rs.getString(3);
                String check_no = rs.getString(4);
                double check_amount = rs.getDouble(5);
                String added_by = rs.getString(6);
                String date_added = rs.getString(7);
                String customer_name = rs.getString(8);
                String customer_id = rs.getString(9);
                int status = rs.getInt(10);
                String cheque_holder = rs.getString(11);
                String cheque_date = rs.getString(12);
                String user_id = rs.getString(13);
                String user_screen_name = rs.getString(14);
                String branch = rs.getString(15);
                String branch_id = rs.getString(16);
                String location = rs.getString(17);
                String location_id = rs.getString(18);
                String remarks = rs.getString(19);
                int refund = rs.getInt(20);
                String credit_card_type = rs.getString(21);
                double credit_card_rate = rs.getDouble(22);
                String credit_card_no = rs.getString(23);
                String credit_card_holder = rs.getString(24);
                double credit_card_amount = rs.getDouble(25);
                String gift_certificate_from = rs.getString(26);
                String gift_certificate_description = rs.getString(27);
                String gift_certificate_no = rs.getString(28);
                double gift_certificate_amount = rs.getDouble(29);
                String online_bank = rs.getString(30);
                String online_reference_no = rs.getString(31);
                String online_holder = rs.getString(32);
                String online_date = rs.getString(32);
                double online_amount = rs.getDouble(34);
                to_prepaid_payments to = new to_prepaid_payments(id, cash, check_bank, check_no, check_amount, added_by, date_added,
                                                                 customer_name, customer_id, status, false, cheque_holder, cheque_date, user_id,
                                                                 user_screen_name, branch, branch_id, location, location_id, remarks
                        , refund, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder, online_date, online_amount);
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
