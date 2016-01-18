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
public class CashDrawer_remittances {

    public static class to_cash_drawer_remittances {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final double cash_amount;
        public final double cheque_amount;
        public final String cheque_holder;
        public final String cheque_bank;
        public final String cheque_no;
        public final String cheque_date;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_cash_drawer_remittances(int id, String user_id, String user_screen_name, String date_added, double cash_amount, double cheque_amount, String cheque_holder, String cheque_bank, String cheque_no, String cheque_date, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.cash_amount = cash_amount;
            this.cheque_amount = cheque_amount;
            this.cheque_holder = cheque_holder;
            this.cheque_bank = cheque_bank;
            this.cheque_no = cheque_no;
            this.cheque_date = cheque_date;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_cash_drawer_remittances to_cash_drawer_remittances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_remittances("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:cash_amount"
                    + ",:cheque_amount"
                    + ",:cheque_holder"
                    + ",:cheque_bank"
                    + ",:cheque_no"
                    + ",:cheque_date"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_remittances.user_id)
                    .setString("user_screen_name", to_cash_drawer_remittances.user_screen_name)
                    .setString("date_added", to_cash_drawer_remittances.date_added)
                    .setNumber("cash_amount", to_cash_drawer_remittances.cash_amount)
                    .setNumber("cheque_amount", to_cash_drawer_remittances.cheque_amount)
                    .setString("cheque_holder", to_cash_drawer_remittances.cheque_holder)
                    .setString("cheque_bank", to_cash_drawer_remittances.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_remittances.cheque_no)
                    .setString("cheque_date", to_cash_drawer_remittances.cheque_date)
                    .setNumber("status", to_cash_drawer_remittances.status)
                    .setString("branch", to_cash_drawer_remittances.branch)
                    .setString("branch_id", to_cash_drawer_remittances.branch_id)
                    .setString("location", to_cash_drawer_remittances.location)
                    .setString("location_id", to_cash_drawer_remittances.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_remittances.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_remittances to_cash_drawer_remittances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_remittances set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",cash_amount= :cash_amount "
                    + ",cheque_amount= :cheque_amount "
                    + ",cheque_holder= :cheque_holder "
                    + ",cheque_bank= :cheque_bank "
                    + ",cheque_no= :cheque_no "
                    + ",cheque_date= :cheque_date "
                    + ",status= :status "
                    + " where id='" + to_cash_drawer_remittances.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_remittances.user_id)
                    .setString("user_screen_name", to_cash_drawer_remittances.user_screen_name)
                    .setString("date_added", to_cash_drawer_remittances.date_added)
                    .setNumber("cash_amount", to_cash_drawer_remittances.cash_amount)
                    .setNumber("cheque_amount", to_cash_drawer_remittances.cheque_amount)
                    .setString("cheque_holder", to_cash_drawer_remittances.cheque_holder)
                    .setString("cheque_bank", to_cash_drawer_remittances.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_remittances.cheque_no)
                    .setString("cheque_date", to_cash_drawer_remittances.cheque_date)
                    .setNumber("status", to_cash_drawer_remittances.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_remittances.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_remittances to_cash_drawer_remittances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_remittances  "
                    + " where id='" + to_cash_drawer_remittances.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_remittances.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_remittances> ret_data(String where) {
        List<to_cash_drawer_remittances> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from cash_drawer_remittances"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                double cash_amount = rs.getDouble(5);
                double cheque_amount = rs.getDouble(6);
                String cheque_holder = rs.getString(7);
                String cheque_bank = rs.getString(8);
                String cheque_no = rs.getString(9);
                String cheque_date = rs.getString(10);
                int status = rs.getInt(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location = rs.getString(14);
                String location_id = rs.getString(15);
                to_cash_drawer_remittances to = new to_cash_drawer_remittances(id, user_id, user_screen_name, date_added, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, status, branch, branch_id, location, location_id);
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
