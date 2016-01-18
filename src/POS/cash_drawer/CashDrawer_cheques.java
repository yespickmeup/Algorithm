/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.util.DateType;
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
public class CashDrawer_cheques {

    public static class to_cash_drawer_cheques {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String cheque_holder;
        public final String cheque_bank;
        public final String cheque_no;
        public final double cheque_amount;
        public final String cheque_date;

        public to_cash_drawer_cheques(int id, String user_id, String user_screen_name, String date_added, String cheque_holder, String cheque_bank, String cheque_no, double cheque_amount, String cheque_date) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.cheque_holder = cheque_holder;
            this.cheque_bank = cheque_bank;
            this.cheque_no = cheque_no;
            this.cheque_amount = cheque_amount;
            this.cheque_date = cheque_date;
        }
    }

    public static void add_data(to_cash_drawer_cheques to_cash_drawer_cheques) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_cheques("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_amount"
                    + ",cheque_date"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:cheque_holder"
                    + ",:cheque_bank"
                    + ",:cheque_no"
                    + ",:cheque_amount"
                    + ",:cheque_date"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_cheques.user_id)
                    .setString("user_screen_name", to_cash_drawer_cheques.user_screen_name)
                    .setString("date_added", to_cash_drawer_cheques.date_added)
                    .setString("cheque_holder", to_cash_drawer_cheques.cheque_holder)
                    .setString("cheque_bank", to_cash_drawer_cheques.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_cheques.cheque_no)
                    .setNumber("cheque_amount", to_cash_drawer_cheques.cheque_amount)
                    .setString("cheque_date", to_cash_drawer_cheques.cheque_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_cheques.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_cheques to_cash_drawer_cheques) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_cheques set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",cheque_holder= :cheque_holder "
                    + ",cheque_bank= :cheque_bank "
                    + ",cheque_no= :cheque_no "
                    + ",cheque_amount= :cheque_amount "
                    + ",cheque_date= :cheque_date "
                    + " where id='" + to_cash_drawer_cheques.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_cheques.user_id)
                    .setString("user_screen_name", to_cash_drawer_cheques.user_screen_name)
                    .setString("date_added", to_cash_drawer_cheques.date_added)
                    .setString("cheque_holder", to_cash_drawer_cheques.cheque_holder)
                    .setString("cheque_bank", to_cash_drawer_cheques.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_cheques.cheque_no)
                    .setNumber("cheque_amount", to_cash_drawer_cheques.cheque_amount)
                    .setString("cheque_date", to_cash_drawer_cheques.cheque_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_cheques.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_cheques to_cash_drawer_cheques) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_cheques  "
                    + " where id='" + to_cash_drawer_cheques.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_cheques.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_cheques> ret_data(String where) {
        List<to_cash_drawer_cheques> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_amount"
                    + ",cheque_date"
                    + " from cash_drawer_cheques"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = DateType.convert_slash_datetime3(rs.getString(4));
                String cheque_holder = rs.getString(5);
                String cheque_bank = rs.getString(6);
                String cheque_no = rs.getString(7);
                double cheque_amount = rs.getDouble(8);
                String cheque_date = rs.getString(9);

                to_cash_drawer_cheques to = new to_cash_drawer_cheques(id, user_id, user_screen_name, date_added, cheque_holder, cheque_bank, cheque_no, cheque_amount, cheque_date);
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
