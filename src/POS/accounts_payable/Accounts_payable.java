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
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Accounts_payable {

    public static class to_accounts_payable {

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
        public final String reference_no;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_accounts_payable(int id, String customer_id, String customer_name, String ap_no, String date_added, String user_name, double amount, double discount_amount, double discount_rate, String discount, int status, double term, String date_applied, double paid, String date_paid, String remarks, String type, String reference_no, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id) {
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
            this.reference_no = reference_no;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_accounts_payable to_accounts_payable) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into accounts_payable("
                    + " customer_id"
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
                    + ",reference_no"
                    + ",user_id"
                    + ",user_screen_name"
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
                    + ",:reference_no"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_accounts_payable.customer_id)
                    .setString("customer_name", to_accounts_payable.customer_name)
                    .setString("ap_no", to_accounts_payable.ap_no)
                    .setString("date_added", to_accounts_payable.date_added)
                    .setString("user_name", to_accounts_payable.user_name)
                    .setNumber("amount", to_accounts_payable.amount)
                    .setNumber("discount_amount", to_accounts_payable.discount_amount)
                    .setNumber("discount_rate", to_accounts_payable.discount_rate)
                    .setString("discount", to_accounts_payable.discount)
                    .setNumber("status", to_accounts_payable.status)
                    .setNumber("term", to_accounts_payable.term)
                    .setString("date_applied", to_accounts_payable.date_applied)
                    .setNumber("paid", to_accounts_payable.paid)
                    .setString("date_paid", to_accounts_payable.date_paid)
                    .setString("remarks", to_accounts_payable.remarks)
                    .setString("type", to_accounts_payable.type)
                    .setString("reference_no", to_accounts_payable.reference_no)
                    .setString("user_id", to_accounts_payable.user_id)
                    .setString("user_screen_name", to_accounts_payable.user_screen_name)
                    .setString("branch", to_accounts_payable.branch)
                    .setString("branch_id", to_accounts_payable.branch_id)
                    .setString("location", to_accounts_payable.location)
                    .setString("location_id", to_accounts_payable.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "select "
                    + " balance"
                    + " from  suppliers  "
                    + " where customer_no='" + to_accounts_payable.customer_id + "' ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            double balance = 0;
            if (rs.next()) {
                balance = rs.getDouble(1);
            }

            double new_balance = (to_accounts_payable.amount - to_accounts_payable.discount_amount) + balance;

            String s3 = "update  suppliers set "
                    + "balance= :balance"
                    + " where "
                    + " customer_no='" + to_accounts_payable.customer_id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3).
                    setNumber("balance", new_balance).ok();

            stmt.addBatch(s3);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Accounts_payable.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_accounts_payable to_accounts_payable) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update accounts_payable set "
                    + " customer_id= :customer_id "
                    + ",customer_name= :customer_name "
                    + ",ap_no= :ap_no "
                    + ",date_added= :date_added "
                    + ",user_name= :user_name "
                    + ",amount= :amount "
                    + ",discount_amount= :discount_amount "
                    + ",discount_rate= :discount_rate "
                    + ",discount= :discount "
                    + ",status= :status "
                    + ",term= :term "
                    + ",date_applied= :date_applied "
                    + ",paid= :paid "
                    + ",date_paid= :date_paid "
                    + ",remarks= :remarks "
                    + ",type= :type "
                    + ",reference_no= :reference_no "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_accounts_payable.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_accounts_payable.customer_id)
                    .setString("customer_name", to_accounts_payable.customer_name)
                    .setString("ap_no", to_accounts_payable.ap_no)
                    .setString("date_added", to_accounts_payable.date_added)
                    .setString("user_name", to_accounts_payable.user_name)
                    .setNumber("amount", to_accounts_payable.amount)
                    .setNumber("discount_amount", to_accounts_payable.discount_amount)
                    .setNumber("discount_rate", to_accounts_payable.discount_rate)
                    .setString("discount", to_accounts_payable.discount)
                    .setNumber("status", to_accounts_payable.status)
                    .setNumber("term", to_accounts_payable.term)
                    .setString("date_applied", to_accounts_payable.date_applied)
                    .setNumber("paid", to_accounts_payable.paid)
                    .setString("date_paid", to_accounts_payable.date_paid)
                    .setString("remarks", to_accounts_payable.remarks)
                    .setString("type", to_accounts_payable.type)
                    .setString("reference_no", to_accounts_payable.reference_no)
                    .setString("user_id", to_accounts_payable.user_id)
                    .setString("user_screen_name", to_accounts_payable.user_screen_name)
                    .setString("branch", to_accounts_payable.branch)
                    .setString("branch_id", to_accounts_payable.branch_id)
                    .setString("location", to_accounts_payable.location)
                    .setString("location_id", to_accounts_payable.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Accounts_payable.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data2(to_accounts_payable to_accounts_payable, double new_amount, double new_discount, double term, String date, String remarks, String reference_no) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update accounts_payable set "
                    + " amount= :amount "
                    + ",discount_amount= :discount_amount "
                    + ",term= :term "
                    + ",date_applied= :date_applied "
                    + ",remarks= :remarks "
                    + ",reference_no= :reference_no "
                    + " where id='" + to_accounts_payable.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("amount", new_amount)
                    .setNumber("discount_amount", new_discount)
                    .setNumber("term", term)
                    .setString("date_applied", date)
                    .setString("remarks", remarks)
                    .setString("reference_no", reference_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "select "
                    + " balance"
                    + " from  suppliers  "
                    + " where customer_no='" + to_accounts_payable.customer_id + "' ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            double balance = 0;
            if (rs.next()) {
                balance = rs.getDouble(1);
            }

            balance = balance - (to_accounts_payable.amount - to_accounts_payable.discount_amount);

            double new_balance = (new_amount - new_discount) + balance;

            String s3 = "update  suppliers set "
                    + " balance= :balance"
                    + " where "
                    + " customer_no='" + to_accounts_payable.customer_id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3).
                    setNumber("balance", new_balance).ok();

            stmt.addBatch(s3);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Accounts_payable.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_accounts_payable to_accounts_payable) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = " update  accounts_payable  set status=1 "
                    + " where id='" + to_accounts_payable.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);
            String s5 = " update  accounts_payable_payments  set status=1 "
                    + " where ap_no='" + to_accounts_payable.ap_no + "' "
                    + " ";

            stmt.addBatch(s5);

            String s2 = "select "
                    + " balance"
                    + " from  suppliers  "
                    + " where customer_no='" + to_accounts_payable.customer_id + "' ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            double balance = 0;
            if (rs.next()) {
                balance = rs.getDouble(1);
            }

            if (to_accounts_payable.paid > 0) {
                double paid = (to_accounts_payable.amount - to_accounts_payable.discount_amount) - to_accounts_payable.paid;
                balance = balance - paid;
            } else {
                balance = balance - (to_accounts_payable.amount - to_accounts_payable.discount_amount);
            }
            String s3 = "update  suppliers set "
                    + " balance= :balance"
                    + " where "
                    + " customer_no='" + to_accounts_payable.customer_id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3).
                    setNumber("balance", balance).ok();

            stmt.addBatch(s3);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Accounts_payable.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
//        System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");

        String where = " where id>84 ";
        List<to_accounts_payable> datas = ret_data(where);
        for (to_accounts_payable to : datas) {

            try {
                String am = FitIn.fmt_woc(to.paid);
                Connection conn = MyConnection.connect();
                String s2 = "select "
                        + " amount"
                        + ", id"
                        + " from accounts_payable_payments"
                        + "  where customer_id='" + to.customer_id + "' and Date(date_applied) = '" + to.date_applied + "' and amount between '" + am + "' and '" + ((to.paid) + 10) + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                double amount = 0;
                int id = 0;
                while (rs2.next()) {
                    amount += rs2.getDouble(1);
                    id = rs2.getInt(2);
                }

                if (to.paid > 0) {
                    if (amount != to.paid) {
                        System.out.println("id: " + to.id + " | " + to.ap_no + " . Paid: " + to.paid + " = Paid: " + amount);
                    } else {
                        System.out.println("id: " + to.id + " | " + to.ap_no + " . Paid: " + to.paid + " = Paid: " + amount);
                    }
                    String s3 = "update accounts_payable_payments set "
                            + " ap_no=:ap_no "
                            + " where id='" + id + "' "
                            + " ";

                    s3 = SqlStringUtil.parse(s3)
                            .setString("ap_no", to.ap_no)
                            .ok();

                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt3.execute();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                MyConnection.close();
            }
        }
    }

    public static List<to_accounts_payable> ret_data(String where) {
        List<to_accounts_payable> datas = new ArrayList();

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
                    + ",reference_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from accounts_payable"
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
                String reference_no = rs.getString(18);
                String user_id = rs.getString(19);
                String user_screen_name = rs.getString(20);
                String branch = rs.getString(21);
                String branch_id = rs.getString(22);
                String location = rs.getString(23);
                String location_id = rs.getString(24);

                to_accounts_payable to = new to_accounts_payable(id, customer_id, customer_name, ap_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_accounts_payable> ret_data_conn(String where, Connection conn) {
        List<to_accounts_payable> datas = new ArrayList();

        try {

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
                    + ",reference_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from accounts_payable"
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
                String reference_no = rs.getString(18);
                String user_id = rs.getString(19);
                String user_screen_name = rs.getString(20);
                String branch = rs.getString(21);
                String branch_id = rs.getString(22);
                String location = rs.getString(23);
                String location_id = rs.getString(24);

                to_accounts_payable to = new to_accounts_payable(id, customer_id, customer_name, ap_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }
    }

    public static String increment_id(String branch_id) {
        String id = "000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from accounts_payable where branch_id='" + branch_id + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select ap_no from accounts_payable where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }

            }
            if (id == null) {
                id = branch_id + "|" + "000000000000";
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
