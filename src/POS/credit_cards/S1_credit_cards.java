/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.credit_cards;

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
public class S1_credit_cards {

    public static class to_credit_cards {

        public final int id;
        public final String name;
        public final double rate;

        public to_credit_cards(int id, String name, double rate) {
            this.id = id;
            this.name = name;
            this.rate = rate;
        }
    }

    public static void add_credit_cards(to_credit_cards to_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into credit_cards("
                    + "name"
                    + ",rate"
                    + ")values("
                    + ":name"
                    + ",:rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_credit_cards.name)
                    .setNumber("rate", to_credit_cards.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_cards.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_credit_cards(to_credit_cards to_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update credit_cards set "
                    + "name= :name"
                    + ",rate= :rate"
                    + " where "
                    + " id ='" + to_credit_cards.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_credit_cards.name)
                    .setNumber("rate", to_credit_cards.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_cards.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_credit_cards(to_credit_cards to_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from credit_cards where "
                    + " id ='" + to_credit_cards.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_cards.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_credit_cards> ret_data(String where) {
        List<to_credit_cards> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",rate"
                    + " from credit_cards  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);

                to_credit_cards to = new to_credit_cards(id, name, rate);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_credit_cards> ret_data2(String where) {
        List<to_credit_cards> datas = new ArrayList();

        to_credit_cards to2 = new to_credit_cards(0, "", 0);
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",rate"
                    + " from credit_cards  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);

                to_credit_cards to = new to_credit_cards(id, name, rate);
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
