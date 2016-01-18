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
public class CashDrawer_credit_cards {

    public static class to_cash_drawer_credit_cards {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String credit_card_type;
        public final double credit_card_rate;
        public final double credit_card_amount;
        public final String credit_card_no;
        public final String credit_card_holder;
        public final String credit_card_approval_code;

        public to_cash_drawer_credit_cards(int id, String user_id, String user_screen_name, String date_added, String credit_card_type, double credit_card_rate, double credit_card_amount, String credit_card_no, String credit_card_holder, String credit_card_approval_code) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.credit_card_type = credit_card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_approval_code = credit_card_approval_code;
        }
    }

    public static void add_data(to_cash_drawer_credit_cards to_cash_drawer_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_credit_cards("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",credit_card_type"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:credit_card_type"
                    + ",:credit_card_rate"
                    + ",:credit_card_amount"
                    + ",:credit_card_no"
                    + ",:credit_card_holder"
                    + ",:credit_card_approval_code"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_credit_cards.user_id)
                    .setString("user_screen_name", to_cash_drawer_credit_cards.user_screen_name)
                    .setString("date_added", to_cash_drawer_credit_cards.date_added)
                    .setString("credit_card_type", to_cash_drawer_credit_cards.credit_card_type)
                    .setNumber("credit_card_rate", to_cash_drawer_credit_cards.credit_card_rate)
                    .setNumber("credit_card_amount", to_cash_drawer_credit_cards.credit_card_amount)
                    .setString("credit_card_no", to_cash_drawer_credit_cards.credit_card_no)
                    .setString("credit_card_holder", to_cash_drawer_credit_cards.credit_card_holder)
                    .setString("credit_card_approval_code", to_cash_drawer_credit_cards.credit_card_approval_code)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_credit_cards.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_credit_cards to_cash_drawer_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_credit_cards set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",credit_card_type= :credit_card_type "
                    + ",credit_card_rate= :credit_card_rate "
                    + ",credit_card_amount= :credit_card_amount "
                    + ",credit_card_no= :credit_card_no "
                    + ",credit_card_holder= :credit_card_holder "
                    + ",credit_card_approval_code= :credit_card_approval_code "
                    + " where id='" + to_cash_drawer_credit_cards.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_credit_cards.user_id)
                    .setString("user_screen_name", to_cash_drawer_credit_cards.user_screen_name)
                    .setString("date_added", to_cash_drawer_credit_cards.date_added)
                    .setString("credit_card_type", to_cash_drawer_credit_cards.credit_card_type)
                    .setNumber("credit_card_rate", to_cash_drawer_credit_cards.credit_card_rate)
                    .setNumber("credit_card_amount", to_cash_drawer_credit_cards.credit_card_amount)
                    .setString("credit_card_no", to_cash_drawer_credit_cards.credit_card_no)
                    .setString("credit_card_holder", to_cash_drawer_credit_cards.credit_card_holder)
                    .setString("credit_card_approval_code", to_cash_drawer_credit_cards.credit_card_approval_code)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_credit_cards.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_credit_cards to_cash_drawer_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_credit_cards  "
                    + " where id='" + to_cash_drawer_credit_cards.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_credit_cards.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_credit_cards> ret_data(String where) {
        List<to_cash_drawer_credit_cards> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",credit_card_type"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + " from cash_drawer_credit_cards"
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String credit_card_type = rs.getString(5);
                double credit_card_rate = rs.getDouble(6);
                double credit_card_amount = rs.getDouble(7);
                String credit_card_no = rs.getString(8);
                String credit_card_holder = rs.getString(9);
                String credit_card_approval_code = rs.getString(10);
                to_cash_drawer_credit_cards to = new to_cash_drawer_credit_cards(id, user_id, user_screen_name, date_added, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code);
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
