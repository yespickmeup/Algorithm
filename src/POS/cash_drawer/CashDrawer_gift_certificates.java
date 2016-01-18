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
public class CashDrawer_gift_certificates {

    public static class to_cash_drawer_gift_certificates {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String gc_from;
        public final String gc_description;
        public final String gc_no;
        public final double amount;

        public to_cash_drawer_gift_certificates(int id, String user_id, String user_screen_name, String date_added, String gc_from, String gc_description, String gc_no, double amount) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.gc_from = gc_from;
            this.gc_description = gc_description;
            this.gc_no = gc_no;
            this.amount = amount;
        }
    }

    public static void add_data(to_cash_drawer_gift_certificates to_cash_drawer_gift_certificates) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_gift_certificates("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",gc_from"
                    + ",gc_description"
                    + ",gc_no"
                    + ",amount"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:gc_from"
                    + ",:gc_description"
                    + ",:gc_no"
                    + ",:amount"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_gift_certificates.user_id)
                    .setString("user_screen_name", to_cash_drawer_gift_certificates.user_screen_name)
                    .setString("date_added", to_cash_drawer_gift_certificates.date_added)
                    .setString("gc_from", to_cash_drawer_gift_certificates.gc_from)
                    .setString("gc_description", to_cash_drawer_gift_certificates.gc_description)
                    .setString("gc_no", to_cash_drawer_gift_certificates.gc_no)
                    .setNumber("amount", to_cash_drawer_gift_certificates.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_gift_certificates.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_gift_certificates to_cash_drawer_gift_certificates) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_gift_certificates set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",gc_from= :gc_from "
                    + ",gc_description= :gc_description "
                    + ",gc_no= :gc_no "
                    + ",amount= :amount "
                    + " where id='" + to_cash_drawer_gift_certificates.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_gift_certificates.user_id)
                    .setString("user_screen_name", to_cash_drawer_gift_certificates.user_screen_name)
                    .setString("date_added", to_cash_drawer_gift_certificates.date_added)
                    .setString("gc_from", to_cash_drawer_gift_certificates.gc_from)
                    .setString("gc_description", to_cash_drawer_gift_certificates.gc_description)
                    .setString("gc_no", to_cash_drawer_gift_certificates.gc_no)
                    .setNumber("amount", to_cash_drawer_gift_certificates.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_gift_certificates.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_gift_certificates to_cash_drawer_gift_certificates) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_gift_certificates  "
                    + " where id='" + to_cash_drawer_gift_certificates.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_gift_certificates.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_gift_certificates> ret_data(String where) {
        List<to_cash_drawer_gift_certificates> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",gc_from"
                    + ",gc_description"
                    + ",gc_no"
                    + ",amount"
                    + " from cash_drawer_gift_certificates"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String gc_from = rs.getString(5);
                String gc_description = rs.getString(6);
                String gc_no = rs.getString(7);
                double amount = rs.getDouble(8);

                to_cash_drawer_gift_certificates to = new to_cash_drawer_gift_certificates(id, user_id, user_screen_name, date_added, gc_from, gc_description, gc_no, amount);
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
