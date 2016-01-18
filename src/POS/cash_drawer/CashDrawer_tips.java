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
public class CashDrawer_tips {

    public static class to_cash_drawer_tips {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final double cash_amount;

        public to_cash_drawer_tips(int id, String user_id, String user_screen_name, String date_added, double cash_amount) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.cash_amount = cash_amount;
        }
    }

    public static void add_data(to_cash_drawer_tips to_cash_drawer_tips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_tips("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cash_amount"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:cash_amount"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_tips.user_id)
                    .setString("user_screen_name", to_cash_drawer_tips.user_screen_name)
                    .setString("date_added", to_cash_drawer_tips.date_added)
                    .setNumber("cash_amount", to_cash_drawer_tips.cash_amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_tips.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_tips to_cash_drawer_tips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_tips set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",cash_amount= :cash_amount "
                    + " where id='" + to_cash_drawer_tips.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_tips.user_id)
                    .setString("user_screen_name", to_cash_drawer_tips.user_screen_name)
                    .setString("date_added", to_cash_drawer_tips.date_added)
                    .setNumber("cash_amount", to_cash_drawer_tips.cash_amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_tips.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_tips to_cash_drawer_tips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_tips  "
                    + " where id='" + to_cash_drawer_tips.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_tips.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_tips> ret_data(String where) {
        List<to_cash_drawer_tips> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cash_amount"
                    + " from cash_drawer_tips"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                double cash_amount = rs.getDouble(5);

                to_cash_drawer_tips to = new to_cash_drawer_tips(id, user_id, user_screen_name, date_added, cash_amount);
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
