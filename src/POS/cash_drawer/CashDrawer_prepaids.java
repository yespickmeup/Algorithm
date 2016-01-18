/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

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
public class CashDrawer_prepaids {

    public static class to_cash_drawer_prepaids {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String customer_name;
        public final String customer_id;
        public final double cash_amount;
        public final double cheque_amount;
        public final String cheque_holder;
        public final String cheque_bank;
        public final String cheque_no;
        public final String cheque_date;

        public to_cash_drawer_prepaids(int id, String user_id, String user_screen_name, String date_added, String customer_name, String customer_id, double cash_amount, double cheque_amount, String cheque_holder, String cheque_bank, String cheque_no, String cheque_date) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.cash_amount = cash_amount;
            this.cheque_amount = cheque_amount;
            this.cheque_holder = cheque_holder;
            this.cheque_bank = cheque_bank;
            this.cheque_no = cheque_no;
            this.cheque_date = cheque_date;
        }
    }

    public static void add_data(to_cash_drawer_prepaids to_cash_drawer_prepaids) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_prepaids("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",customer_name"
                    + ",customer_id"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:customer_name"
                    + ",:customer_id"
                    + ",:cash_amount"
                    + ",:cheque_amount"
                    + ",:cheque_holder"
                    + ",:cheque_bank"
                    + ",:cheque_no"
                    + ",:cheque_date"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_prepaids.user_id)
                    .setString("user_screen_name", to_cash_drawer_prepaids.user_screen_name)
                    .setString("date_added", to_cash_drawer_prepaids.date_added)
                    .setString("customer_name", to_cash_drawer_prepaids.customer_name)
                    .setString("customer_id", to_cash_drawer_prepaids.customer_id)
                    .setNumber("cash_amount", to_cash_drawer_prepaids.cash_amount)
                    .setNumber("cheque_amount", to_cash_drawer_prepaids.cheque_amount)
                    .setString("cheque_holder", to_cash_drawer_prepaids.cheque_holder)
                    .setString("cheque_bank", to_cash_drawer_prepaids.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_prepaids.cheque_no)
                    .setString("cheque_date", to_cash_drawer_prepaids.cheque_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_prepaids.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_prepaids to_cash_drawer_prepaids) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_prepaids set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",customer_name= :customer_name "
                    + ",customer_id= :customer_id "
                    + ",cash_amount= :cash_amount "
                    + ",cheque_amount= :cheque_amount "
                    + ",cheque_holder= :cheque_holder "
                    + ",cheque_bank= :cheque_bank "
                    + ",cheque_no= :cheque_no "
                    + ",cheque_date= :cheque_date "
                    + " where id='" + to_cash_drawer_prepaids.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_prepaids.user_id)
                    .setString("user_screen_name", to_cash_drawer_prepaids.user_screen_name)
                    .setString("date_added", to_cash_drawer_prepaids.date_added)
                    .setString("customer_name", to_cash_drawer_prepaids.customer_name)
                    .setString("customer_id", to_cash_drawer_prepaids.customer_id)
                    .setNumber("cash_amount", to_cash_drawer_prepaids.cash_amount)
                    .setNumber("cheque_amount", to_cash_drawer_prepaids.cheque_amount)
                    .setString("cheque_holder", to_cash_drawer_prepaids.cheque_holder)
                    .setString("cheque_bank", to_cash_drawer_prepaids.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_prepaids.cheque_no)
                    .setString("cheque_date", to_cash_drawer_prepaids.cheque_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_prepaids.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_prepaids to_cash_drawer_prepaids) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_prepaids  "
                    + " where id='" + to_cash_drawer_prepaids.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_prepaids.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_prepaids> ret_data(String where) {
        List<to_cash_drawer_prepaids> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",customer_name"
                    + ",customer_id"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + " from cash_drawer_prepaids"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String customer_name = rs.getString(5);
                String customer_id = rs.getString(6);
                double cash_amount = rs.getDouble(7);
                double cheque_amount = rs.getDouble(8);
                String cheque_holder = rs.getString(9);
                String cheque_bank = rs.getString(10);
                String cheque_no = rs.getString(11);
                String cheque_date = rs.getString(12);

                to_cash_drawer_prepaids to = new to_cash_drawer_prepaids(id, user_id, user_screen_name, date_added, customer_name, customer_id, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date);
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
