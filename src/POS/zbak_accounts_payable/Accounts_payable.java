/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.zbak_accounts_payable;

import POS.main.Main;
import POS.main.Main.MyDB;
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
 * @author i1
 */
public class Accounts_payable {

    public static class to_accounts_payable {

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
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_accounts_payable(int id, String customer_id, String customer_name, String ar_no, String date_added, String user_name, double amount, double discount_amount, double discount_rate, String discount, int status, double term, String date_applied, double paid, String date_paid, String remarks, String type, String or_no, String branch, String branch_id, String location, String location_id) {
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
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_accounts_payable to_accounts_payable) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into accounts_payable("
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
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_accounts_payable.customer_id)
                    .setString("customer_name", to_accounts_payable.customer_name)
                    .setString("ar_no", to_accounts_payable.ar_no)
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
                    .setString("or_no", to_accounts_payable.or_no)
                    .setString("branch", to_accounts_payable.branch)
                    .setString("branch_id", to_accounts_payable.branch_id)
                    .setString("location", to_accounts_payable.location)
                    .setString("location_id", to_accounts_payable.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
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
                    + "customer_id= :customer_id "
                    + ",customer_name= :customer_name "
                    + ",ar_no= :ar_no "
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
                    + ",or_no= :or_no "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_accounts_payable.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_accounts_payable.customer_id)
                    .setString("customer_name", to_accounts_payable.customer_name)
                    .setString("ar_no", to_accounts_payable.ar_no)
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
                    .setString("or_no", to_accounts_payable.or_no)
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

    public static void delete_data(to_accounts_payable to_accounts_payable) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from accounts_payable  "
                    + " where id='" + to_accounts_payable.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Accounts_payable.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
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
                String branch = rs.getString(19);
                String branch_id = rs.getString(20);
                String location = rs.getString(21);
                String location_id = rs.getString(22);

                to_accounts_payable to = new to_accounts_payable(id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, branch, branch_id, location, location_id);
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
        String ids = "AR-00000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from  accounts_payable";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "AR-00000001";
            } else {
                String s2 = "select ar_no from  accounts_payable where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }

            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
