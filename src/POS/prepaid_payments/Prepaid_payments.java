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

        public to_prepaid_payments(int id, double cash, String check_bank, String check_no, double check_amount, String added_by, String date_added, String customer_name, String customer_id, int status, boolean selected, String cheque_holder, String cheque_date, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id) {
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
//                    .setString("user_id", to_prepaid_payments.user_id)
//                    .setString("user_screen_name", to_prepaid_payments.user_screen_name)
//                    .setString("branch", to_prepaid_payments.branch)
//                    .setString("branch_id", to_prepaid_payments.branch_id)
//                    .setString("location", to_prepaid_payments.location)
//                    .setString("location_id", to_prepaid_payments.location_id)
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
                double new_balance = cus.prepaid + (to_prepaid_payments.cash + to_prepaid_payments.check_amount);
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
                String branch=rs.getString(15);
                String branch_id=rs.getString(16);
                String location=rs.getString(17);
                String location_id=rs.getString(18);
                to_prepaid_payments to = new to_prepaid_payments(id, cash, check_bank, check_no, check_amount, added_by, date_added
                        , customer_name, customer_id, status, false, cheque_holder, cheque_date, user_id
                        , user_screen_name,branch,branch_id,location,location_id);
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
