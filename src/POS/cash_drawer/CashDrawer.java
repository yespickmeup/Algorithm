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
public class CashDrawer {

    public static class to_cash_drawer {

        public final int id;
        public final String session_no;
        public final String user_name;
        public final String screen_name;
        public final String time_in;
        public final String time_out;
        public final double amount;
        public final double cash_out;
        public final double thousand;
        public final double five_hundred;
        public final double two_hundred;
        public final double fifty;
        public final double twenty;
        public final double coins;
        public final double one_hundred;
        public final double expenses;
        public final double ten;
        public final double five;
        public final double one;
        public final double point_five;
        public final double point_two_five;
        public final double point_ten;
        public final double point_zero_five;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String user_id;
        public final String user_screen_name;

        public to_cash_drawer(int id, String session_no, String user_name, String screen_name, String time_in, String time_out, double amount, double cash_out, double thousand, double five_hundred, double two_hundred, double fifty, double twenty, double coins, double one_hundred, double expenses, double ten, double five, double one, double point_five, double point_two_five, double point_ten, double point_zero_five, String branch, String branch_id, String location, String location_id, String user_id, String user_screen_name) {
            this.id = id;
            this.session_no = session_no;
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.time_in = time_in;
            this.time_out = time_out;
            this.amount = amount;
            this.cash_out = cash_out;
            this.thousand = thousand;
            this.five_hundred = five_hundred;
            this.two_hundred = two_hundred;
            this.fifty = fifty;
            this.twenty = twenty;
            this.coins = coins;
            this.one_hundred = one_hundred;
            this.expenses = expenses;
            this.ten = ten;
            this.five = five;
            this.one = one;
            this.point_five = point_five;
            this.point_two_five = point_two_five;
            this.point_ten = point_ten;
            this.point_zero_five = point_zero_five;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
        }
    }

    public static List<to_cash_drawer> ret_data(String where) {
        List<to_cash_drawer> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + ",ten"
                    + ",five"
                    + ",one"
                    + ",point_five"
                    + ",point_two_five"
                    + ",point_ten"
                    + ",point_zero_five"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + " from cash_drawer"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);
                double ten = rs.getDouble(17);
                double five = rs.getDouble(18);
                double one = rs.getDouble(19);
                double point_five = rs.getDouble(20);
                double point_two_five = rs.getDouble(21);
                double point_ten = rs.getDouble(22);
                double point_zero_five = rs.getDouble(23);

                String branch = rs.getString(24);
                String branch_id = rs.getString(25);
                String location = rs.getString(26);
                String location_id = rs.getString(27);
                String user_id = rs.getString(28);
                String user_screen_name = rs.getString(29);
                to_cash_drawer to = new to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer to_cash_drawer, String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer  set "
                    + " time_out= :time_out "
                    + ",thousand= :thousand "
                    + ",five_hundred= :five_hundred "
                    + ",two_hundred= :two_hundred "
                    + ",fifty= :fifty "
                    + ",twenty= :twenty "
                    + ",coins= :coins "
                    + ",one_hundred= :one_hundred "
                    + ",expenses= :expenses "
                    + ",ten= :ten "
                    + ",five= :five "
                    + ",one= :one "
                    + ",point_five= :point_five "
                    + ",point_two_five= :point_two_five "
                    + ",point_ten= :point_ten "
                    + ",point_zero_five= :point_zero_five "
                    + ",amount = :amount"
                    + " where id='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("time_out", to_cash_drawer.time_out)
                    .setNumber("thousand", to_cash_drawer.thousand)
                    .setNumber("five_hundred", to_cash_drawer.five_hundred)
                    .setNumber("two_hundred", to_cash_drawer.two_hundred)
                    .setNumber("fifty", to_cash_drawer.fifty)
                    .setNumber("twenty", to_cash_drawer.twenty)
                    .setNumber("coins", to_cash_drawer.coins)
                    .setNumber("one_hundred", to_cash_drawer.one_hundred)
                    .setNumber("expenses", to_cash_drawer.expenses)
                    .setNumber("ten", to_cash_drawer.ten)
                    .setNumber("five", to_cash_drawer.five)
                    .setNumber("one", to_cash_drawer.one)
                    .setNumber("point_five", to_cash_drawer.point_five)
                    .setNumber("point_two_five", to_cash_drawer.point_two_five)
                    .setNumber("point_ten", to_cash_drawer.point_ten)
                    .setNumber("point_zero_five", to_cash_drawer.point_zero_five)
                    .setNumber("amount", to_cash_drawer.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void insert_data(to_cash_drawer to_cash_drawer) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer("
                    + "session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + ",ten"
                    + ",five"
                    + ",one"
                    + ",point_five"
                    + ",point_two_five"
                    + ",point_ten"
                    + ",point_zero_five"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ")values("
                    + ":session_no"
                    + ",:user_name"
                    + ",:screen_name"
                    + ",:time_in"
                    + ",:time_out"
                    + ",:amount"
                    + ",:cash_out"
                    + ",:thousand"
                    + ",:five_hundred"
                    + ",:two_hundred"
                    + ",:fifty"
                    + ",:twenty"
                    + ",:coins"
                    + ",:one_hundred"
                    + ",:expenses"
                    + ",:ten"
                    + ",:five"
                    + ",:one"
                    + ",:point_five"
                    + ",:point_two_five"
                    + ",:point_ten"
                    + ",:point_zero_five"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("session_no", to_cash_drawer.session_no)
                    .setString("user_name", to_cash_drawer.user_name)
                    .setString("screen_name", to_cash_drawer.screen_name)
                    .setString("time_in", to_cash_drawer.time_in)
                    .setString("time_out", to_cash_drawer.time_out)
                    .setNumber("amount", to_cash_drawer.amount)
                    .setNumber("cash_out", to_cash_drawer.cash_out)
                    .setNumber("thousand", to_cash_drawer.thousand)
                    .setNumber("five_hundred", to_cash_drawer.five_hundred)
                    .setNumber("two_hundred", to_cash_drawer.two_hundred)
                    .setNumber("fifty", to_cash_drawer.fifty)
                    .setNumber("twenty", to_cash_drawer.twenty)
                    .setNumber("coins", to_cash_drawer.coins)
                    .setNumber("one_hundred", to_cash_drawer.one_hundred)
                    .setNumber("expenses", to_cash_drawer.expenses)
                    .setNumber("ten", to_cash_drawer.ten)
                    .setNumber("five", to_cash_drawer.five)
                    .setNumber("one", to_cash_drawer.one)
                    .setNumber("point_five", to_cash_drawer.point_five)
                    .setNumber("point_two_five", to_cash_drawer.point_two_five)
                    .setNumber("point_ten", to_cash_drawer.point_ten)
                    .setNumber("point_zero_five", to_cash_drawer.point_zero_five)
                    .setString("branch", to_cash_drawer.branch)
                    .setString("branch_id", to_cash_drawer.branch_id)
                    .setString("location", to_cash_drawer.location)
                    .setString("location_id", to_cash_drawer.location_id)
                    .setString("user_id", to_cash_drawer.user_id)
                    .setString("user_screen_name", to_cash_drawer.user_screen_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_cash_drawer to_cash_drawer) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into cash_drawer("
                    + "session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + ",ten"
                    + ",five"
                    + ",one"
                    + ",point_five"
                    + ",point_two_five"
                    + ",point_ten"
                    + ",point_zero_five"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ")values("
                    + ":session_no"
                    + ",:user_name"
                    + ",:screen_name"
                    + ",:time_in"
                    + ",:time_out"
                    + ",:amount"
                    + ",:cash_out"
                    + ",:thousand"
                    + ",:five_hundred"
                    + ",:two_hundred"
                    + ",:fifty"
                    + ",:twenty"
                    + ",:coins"
                    + ",:one_hundred"
                    + ",:expenses"
                    + ",:ten"
                    + ",:five"
                    + ",:one"
                    + ",:point_five"
                    + ",:point_two_five"
                    + ",:point_ten"
                    + ",:point_zero_five"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("session_no", to_cash_drawer.session_no)
                    .setString("user_name", to_cash_drawer.user_name)
                    .setString("screen_name", to_cash_drawer.screen_name)
                    .setString("time_in", to_cash_drawer.time_in)
                    .setString("time_out", to_cash_drawer.time_out)
                    .setNumber("amount", to_cash_drawer.amount)
                    .setNumber("cash_out", to_cash_drawer.cash_out)
                    .setNumber("thousand", to_cash_drawer.thousand)
                    .setNumber("five_hundred", to_cash_drawer.five_hundred)
                    .setNumber("two_hundred", to_cash_drawer.two_hundred)
                    .setNumber("fifty", to_cash_drawer.fifty)
                    .setNumber("twenty", to_cash_drawer.twenty)
                    .setNumber("coins", to_cash_drawer.coins)
                    .setNumber("one_hundred", to_cash_drawer.one_hundred)
                    .setNumber("expenses", to_cash_drawer.expenses)
                    .setNumber("ten", to_cash_drawer.ten)
                    .setNumber("five", to_cash_drawer.five)
                    .setNumber("one", to_cash_drawer.one)
                    .setNumber("point_five", to_cash_drawer.point_five)
                    .setNumber("point_two_five", to_cash_drawer.point_two_five)
                    .setNumber("point_ten", to_cash_drawer.point_ten)
                    .setNumber("point_zero_five", to_cash_drawer.point_zero_five)
                    .setString("branch", to_cash_drawer.branch)
                    .setString("branch_id", to_cash_drawer.branch_id)
                    .setString("location", to_cash_drawer.location)
                    .setString("location_id", to_cash_drawer.location_id)
                    .setString("user_id", to_cash_drawer.user_id)
                    .setString("user_screen_name", to_cash_drawer.user_screen_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update cash_drawer set is_uploaded=1 where id='" + to_cash_drawer.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(CashDrawer.class, "Successfully Added: " + to_cash_drawer.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_drawer(to_cash_drawer to_cash_drawer, String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer set "
                    + "amount= :amount "
                    + ",thousand= :thousand "
                    + ",five_hundred= :five_hundred "
                    + ",two_hundred= :two_hundred "
                    + ",fifty= :fifty "
                    + ",twenty= :twenty "
                    + ",coins= :coins "
                    + ",one_hundred= :one_hundred "
                    + ",expenses= :expenses "
                    + ",ten= :ten "
                    + ",five= :five "
                    + ",one= :one "
                    + ",point_five= :point_five "
                    + ",point_two_five= :point_two_five "
                    + ",point_ten= :point_ten "
                    + ",point_zero_five= :point_zero_five "
                    + " where id='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("amount", to_cash_drawer.amount)
                    .setNumber("thousand", to_cash_drawer.thousand)
                    .setNumber("five_hundred", to_cash_drawer.five_hundred)
                    .setNumber("two_hundred", to_cash_drawer.two_hundred)
                    .setNumber("fifty", to_cash_drawer.fifty)
                    .setNumber("twenty", to_cash_drawer.twenty)
                    .setNumber("coins", to_cash_drawer.coins)
                    .setNumber("one_hundred", to_cash_drawer.one_hundred)
                    .setNumber("expenses", to_cash_drawer.expenses)
                    .setNumber("ten", to_cash_drawer.ten)
                    .setNumber("five", to_cash_drawer.five)
                    .setNumber("one", to_cash_drawer.one)
                    .setNumber("point_five", to_cash_drawer.point_five)
                    .setNumber("point_two_five", to_cash_drawer.point_two_five)
                    .setNumber("point_ten", to_cash_drawer.point_ten)
                    .setNumber("point_zero_five", to_cash_drawer.point_zero_five)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_drawer2(to_cash_drawer to_cash_drawer, String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer set "
                    + "amount= :amount "
                    + " where id='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("amount", to_cash_drawer.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_cash_drawer ret_to(String where) {
        to_cash_drawer to = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",sum(amount)"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + ",ten"
                    + ",five"
                    + ",one"
                    + ",point_five"
                    + ",point_two_five"
                    + ",point_ten"
                    + ",point_zero_five"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + " from cash_drawer "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);
                double ten = rs.getDouble(17);
                double five = rs.getDouble(18);
                double one = rs.getDouble(19);
                double point_five = rs.getDouble(20);
                double point_two_five = rs.getDouble(21);
                double point_ten = rs.getDouble(22);
                double point_zero_five = rs.getDouble(23);
                String branch = rs.getString(24);
                String branch_id = rs.getString(25);
                String location = rs.getString(26);
                String location_id = rs.getString(27);
                String user_id = rs.getString(28);
                String user_screen_name = rs.getString(29);
                to = new to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer> ret_where(String where) {
        List<to_cash_drawer> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + ",ten"
                    + ",five"
                    + ",one"
                    + ",point_five"
                    + ",point_two_five"
                    + ",point_ten"
                    + ",point_zero_five"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + " from cash_drawer"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);
                double ten = rs.getDouble(17);
                double five = rs.getDouble(18);
                double one = rs.getDouble(19);
                double point_five = rs.getDouble(20);
                double point_two_five = rs.getDouble(21);
                double point_ten = rs.getDouble(22);
                double point_zero_five = rs.getDouble(23);
                String branch = rs.getString(24);
                String branch_id = rs.getString(25);
                String location = rs.getString(26);
                String location_id = rs.getString(27);
                String user_id = rs.getString(28);
                String user_screen_name = rs.getString(29);

                to_cash_drawer to = new to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name);
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
