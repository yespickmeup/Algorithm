/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.last_remittance;

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
public class S1_cash_drawer_last_remittances {

    public static class to_cash_drawer_last_remittances {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final int status;
        public final double amount;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_cash_drawer_last_remittances(int id, String user_id, String user_screen_name, String date_added, int status, double amount, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.status = status;
            this.amount = amount;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_cash_drawer_last_remittances to_cash_drawer_last_remittances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_last_remittances("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",status"
                    + ",amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:status"
                    + ",:amount"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_last_remittances.user_id)
                    .setString("user_screen_name", to_cash_drawer_last_remittances.user_screen_name)
                    .setString("date_added", to_cash_drawer_last_remittances.date_added)
                    .setNumber("status", to_cash_drawer_last_remittances.status)
                    .setNumber("amount", to_cash_drawer_last_remittances.amount)
                    .setString("branch", to_cash_drawer_last_remittances.branch)
                    .setString("branch_id", to_cash_drawer_last_remittances.branch_id)
                    .setString("location", to_cash_drawer_last_remittances.location)
                    .setString("location_id", to_cash_drawer_last_remittances.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_last_remittances.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_last_remittances to_cash_drawer_last_remittances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_last_remittances set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",status= :status "
                    + ",amount= :amount "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_cash_drawer_last_remittances.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_last_remittances.user_id)
                    .setString("user_screen_name", to_cash_drawer_last_remittances.user_screen_name)
                    .setString("date_added", to_cash_drawer_last_remittances.date_added)
                    .setNumber("status", to_cash_drawer_last_remittances.status)
                    .setNumber("amount", to_cash_drawer_last_remittances.amount)
                    .setString("branch", to_cash_drawer_last_remittances.branch)
                    .setString("branch_id", to_cash_drawer_last_remittances.branch_id)
                    .setString("location", to_cash_drawer_last_remittances.location)
                    .setString("location_id", to_cash_drawer_last_remittances.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_last_remittances.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_last_remittances to_cash_drawer_last_remittances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_last_remittances  "
                    + " where id='" + to_cash_drawer_last_remittances.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_last_remittances.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_last_remittances> ret_data(String where) {
        List<to_cash_drawer_last_remittances> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",status"
                    + ",amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from cash_drawer_last_remittances"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                int status = rs.getInt(5);
                double amount = rs.getDouble(6);
                String branch = rs.getString(7);
                String branch_id = rs.getString(8);
                String location = rs.getString(9);
                String location_id = rs.getString(10);

                to_cash_drawer_last_remittances to = new to_cash_drawer_last_remittances(id, user_id, user_screen_name, date_added, status, amount, branch, branch_id, location, location_id);
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
