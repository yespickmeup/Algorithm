/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Parse_cash_drawers {

    String session_no;
    String user_name;
    String screen_name;
    String time_in;
    String time_out;
    double amount;
    double cash_out;
    double thousand;
    double five_hundred;
    double two_hundred;
    double fifty;
    double twenty;
    double coins;
    double one_hundred;
    double expenses;
    double ten;
    double five;
    double one;
    double point_five;
    double point_two_five;
    double point_ten;
    double point_zero_five;
    String branch;
    String branch_id;
    String location;
    String location_id;
    String user_id;
    String user_screen_name;

    public Parse_cash_drawers(String session_no, String user_name, String screen_name, String time_in, String time_out, double amount, double cash_out, double thousand, double five_hundred, double two_hundred, double fifty, double twenty, double coins, double one_hundred, double expenses, double ten, double five, double one, double point_five, double point_two_five, double point_ten, double point_zero_five, String branch, String branch_id, String location, String location_id, String user_id, String user_screen_name) {
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

    public static void main(String[] args) {
        String where = " order by id desc limit 3";
        String stmts = compress(where);
        List<Parse_cash_drawers> datas = decompress(stmts);
        for (Parse_cash_drawers to : datas) {
            System.out.println(to.time_in);
        }
        System.out.println(datas.size());
    }

    public static List<Parse_cash_drawers> decompress(String stmts) {
        if (stmts.isEmpty()) {
            return new ArrayList();
        }
        List<Parse_cash_drawers> datas = new ArrayList();
        int total_transactions = 0;
        int total_items = 0;
        String[] list = stmts.split("℮");
        int i = 0;
        for (String s : list) {
            if (i > 0) {

                String session_no = "";
                String user_name = "";
                String screen_name = "";
                String time_in = "";
                String time_out = "";
                double amount = 0;
                double cash_out = 0;
                double thousand = 0;
                double five_hundred = 0;
                double two_hundred = 0;
                double fifty = 0;
                double twenty = 0;
                double coins = 0;
                double one_hundred = 0;
                double expenses = 0;
                double ten = 0;
                double five = 0;
                double one = 0;
                double point_five = 0;
                double point_two_five = 0;
                double point_ten = 0;
                double point_zero_five = 0;
                String branch = "";
                String branch_id = "";
                String location = "";
                String location_id = "";
                String user_id = "";
                String user_screen_name = "";

                String[] cols = s.split("%");
                int x = 0;

                for (String c : cols) {

                    if (x == 0) {
                        total_transactions++;
                        session_no = c.substring(16, c.length() - 1);
                    }
                    if (x == 1) {
                        user_name = c.substring(13, c.length() - 1);
                    }
                    if (x == 2) {
                        screen_name = c.substring(15, c.length() - 1);
                    }
                    if (x == 3) {
                        time_in = c.substring(11, c.length() - 1);
                    }
                    if (x == 4) {
                        time_out = c.substring(12, c.length() - 1);
                    }
                    if (x == 5) {
                        amount = FitIn.toDouble(c.substring(10, c.length() - 1));
                    }
                    if (x == 6) {
                        cash_out = FitIn.toDouble(c.substring(12, c.length() - 1));
                    }
                    if (x == 7) {
                        thousand = FitIn.toDouble(c.substring(12, c.length() - 1));
                    }
                    if (x == 8) {
                        five_hundred = FitIn.toDouble(c.substring(16, c.length() - 1));
                    }
                    if (x == 9) {
                        two_hundred = FitIn.toDouble(c.substring(15, c.length() - 1));
                    }
                    if (x == 10) {
                        fifty = FitIn.toDouble(c.substring(9, c.length() - 1));
                    }
                    if (x == 11) {
                        twenty = FitIn.toDouble(c.substring(10, c.length() - 1));
                    }
                    if (x == 12) {
                        coins = FitIn.toDouble(c.substring(9, c.length() - 1));
                    }
                    if (x == 13) {
                        one_hundred = FitIn.toDouble(c.substring(15, c.length() - 1));
                    }
                    if (x == 14) {
                        expenses = FitIn.toDouble(c.substring(12, c.length() - 1));
                    }
                    if (x == 15) {
                        ten = FitIn.toDouble(c.substring(7, c.length() - 1));
                    }
                    if (x == 16) {
                        five = FitIn.toDouble(c.substring(8, c.length() - 1));
                    }
                    if (x == 17) {
                        one = FitIn.toDouble(c.substring(7, c.length() - 1));
                    }
                    if (x == 18) {
                        point_five = FitIn.toDouble(c.substring(14, c.length() - 1));
                    }
                    if (x == 19) {
                        point_two_five = FitIn.toDouble(c.substring(18, c.length() - 1));
                    }
                    if (x == 20) {
                        point_ten = FitIn.toDouble(c.substring(13, c.length() - 1));
                    }
                    if (x == 21) {
                        point_zero_five = FitIn.toDouble(c.substring(19, c.length() - 1));
                    }
                    if (x == 22) {
                        branch = c.substring(10, c.length() - 1);
                    }
                    if (x == 23) {
                        branch_id = c.substring(13, c.length() - 1);
                    }
                    if (x == 24) {
                        location = c.substring(12, c.length() - 1);
                    }
                    if (x == 25) {
                        location_id = c.substring(15, c.length() - 1);
                    }
                    if (x == 26) {
                        user_id = c.substring(11, c.length() - 1);
                    }
                    if (x == 27) {

                        user_screen_name = c.substring(20, c.length() - 1);

                    }
                    x++;
                }

                //add records
                Parse_cash_drawers pcd = new Parse_cash_drawers(session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name);
                datas.add(pcd);
            }
            i++;
        }
        System.out.println("Cash Drawers: " + " Transactions: " + total_transactions + " , Items: " + total_items);
        return datas;
    }

    public static String compress(String where) {
        String stmts = "\"items\":\"";
        int total_transactions = 0;
        int total_items = 0;
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
                total_transactions++;
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

                stmts = stmts + "℮{";
                stmts = stmts + "\"session_no;\":\"" + session_no + "\"";
                stmts = stmts + "%\"user_name;\":\"" + user_name + "\"";
                stmts = stmts + "%\"screen_name\":\"" + screen_name + "\"";
                stmts = stmts + "%\"time_in\":\"" + time_in + "\"";
                stmts = stmts + "%\"time_out\":\"" + time_out + "\"";
                stmts = stmts + "%\"amount\":\"" + amount + "\"";
                stmts = stmts + "%\"cash_out\":\"" + cash_out + "\"";
                stmts = stmts + "%\"thousand\":\"" + thousand + "\"";
                stmts = stmts + "%\"five_hundred\":\"" + five_hundred + "\"";
                stmts = stmts + "%\"two_hundred\":\"" + two_hundred + "\"";
                stmts = stmts + "%\"fifty\":\"" + fifty + "\"";
                stmts = stmts + "%\"twenty\":\"" + twenty + "\"";
                stmts = stmts + "%\"coins\":\"" + coins + "\"";
                stmts = stmts + "%\"one_hundred\":\"" + one_hundred + "\"";
                stmts = stmts + "%\"expenses\":\"" + expenses + "\"";
                stmts = stmts + "%\"ten\":\"" + ten + "\"";
                stmts = stmts + "%\"five\":\"" + five + "\"";
                stmts = stmts + "%\"one\":\"" + one + "\"";
                stmts = stmts + "%\"point_five\":\"" + point_five + "\"";
                stmts = stmts + "%\"point_two_five\":\"" + point_two_five + "\"";
                stmts = stmts + "%\"point_ten\":\"" + point_ten + "\"";
                stmts = stmts + "%\"point_zero_five\":\"" + point_zero_five + "\"";
                stmts = stmts + "%\"branch\":\"" + branch + "\"";
                stmts = stmts + "%\"branch_id\":\"" + branch_id + "\"";
                stmts = stmts + "%\"location\":\"" + location + "\"";
                stmts = stmts + "%\"location_id\":\"" + location_id + "\"";
                stmts = stmts + "%\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "%\"user_screen_name\":\"" + user_screen_name + "\"";

                stmts = stmts + "}";
            }
            System.out.println("Cash Drawers: " + " Transactions: " + total_transactions + " Items: " + total_items);
            return stmts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
