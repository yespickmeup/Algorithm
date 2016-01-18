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
public class CashDrawer_account_receivables {

    public static class to_cash_drawer_accounts_receivables {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String charge_type_id;
        public final String charge_type;
        public final String reference_no;
        public final String customer_id;
        public final String customer_name;
        public final double cash_amount;
        public final double cheque_amount;
        public final String check_holder;
        public final String cheque_bank;
        public final String cheque_no;
        public final String cheque_date;

        public to_cash_drawer_accounts_receivables(int id, String user_id, String user_screen_name, String date_added, String charge_type_id, String charge_type, String reference_no, String customer_id, String customer_name, double cash_amount, double cheque_amount, String check_holder, String cheque_bank, String cheque_no, String cheque_date) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.charge_type_id = charge_type_id;
            this.charge_type = charge_type;
            this.reference_no = reference_no;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.cash_amount = cash_amount;
            this.cheque_amount = cheque_amount;
            this.check_holder = check_holder;
            this.cheque_bank = cheque_bank;
            this.cheque_no = cheque_no;
            this.cheque_date = cheque_date;
        }
    }

    public static void add_data(to_cash_drawer_accounts_receivables to_cash_drawer_accounts_receivables) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_accounts_receivables("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",charge_type_id"
                    + ",charge_type"
                    + ",reference_no"
                    + ",customer_id"
                    + ",customer_name"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",check_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:charge_type_id"
                    + ",:charge_type"
                    + ",:reference_no"
                    + ",:customer_id"
                    + ",:customer_name"
                    + ",:cash_amount"
                    + ",:cheque_amount"
                    + ",:check_holder"
                    + ",:cheque_bank"
                    + ",:cheque_no"
                    + ",:cheque_date"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_accounts_receivables.user_id)
                    .setString("user_screen_name", to_cash_drawer_accounts_receivables.user_screen_name)
                    .setString("date_added", to_cash_drawer_accounts_receivables.date_added)
                    .setString("charge_type_id", to_cash_drawer_accounts_receivables.charge_type_id)
                    .setString("charge_type", to_cash_drawer_accounts_receivables.charge_type)
                    .setString("reference_no", to_cash_drawer_accounts_receivables.reference_no)
                    .setString("customer_id", to_cash_drawer_accounts_receivables.customer_id)
                    .setString("customer_name", to_cash_drawer_accounts_receivables.customer_name)
                    .setNumber("cash_amount", to_cash_drawer_accounts_receivables.cash_amount)
                    .setNumber("cheque_amount", to_cash_drawer_accounts_receivables.cheque_amount)
                    .setString("check_holder", to_cash_drawer_accounts_receivables.check_holder)
                    .setString("cheque_bank", to_cash_drawer_accounts_receivables.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_accounts_receivables.cheque_no)
                    .setString("cheque_date", to_cash_drawer_accounts_receivables.cheque_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_account_receivables.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cash_drawer_accounts_receivables to_cash_drawer_accounts_receivables) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_accounts_receivables set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",charge_type_id= :charge_type_id "
                    + ",charge_type= :charge_type "
                    + ",reference_no= :reference_no "
                    + ",customer_id= :customer_id "
                    + ",customer_name= :customer_name "
                    + ",cash_amount= :cash_amount "
                    + ",cheque_amount= :cheque_amount "
                    + ",check_holder= :check_holder "
                    + ",cheque_bank= :cheque_bank "
                    + ",cheque_no= :cheque_no "
                    + ",cheque_date= :cheque_date "
                    + " where id='" + to_cash_drawer_accounts_receivables.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_cash_drawer_accounts_receivables.user_id)
                    .setString("user_screen_name", to_cash_drawer_accounts_receivables.user_screen_name)
                    .setString("date_added", to_cash_drawer_accounts_receivables.date_added)
                    .setString("charge_type_id", to_cash_drawer_accounts_receivables.charge_type_id)
                    .setString("charge_type", to_cash_drawer_accounts_receivables.charge_type)
                    .setString("reference_no", to_cash_drawer_accounts_receivables.reference_no)
                    .setString("customer_id", to_cash_drawer_accounts_receivables.customer_id)
                    .setString("customer_name", to_cash_drawer_accounts_receivables.customer_name)
                    .setNumber("cash_amount", to_cash_drawer_accounts_receivables.cash_amount)
                    .setNumber("cheque_amount", to_cash_drawer_accounts_receivables.cheque_amount)
                    .setString("check_holder", to_cash_drawer_accounts_receivables.check_holder)
                    .setString("cheque_bank", to_cash_drawer_accounts_receivables.cheque_bank)
                    .setString("cheque_no", to_cash_drawer_accounts_receivables.cheque_no)
                    .setString("cheque_date", to_cash_drawer_accounts_receivables.cheque_date)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_account_receivables.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cash_drawer_accounts_receivables to_cash_drawer_accounts_receivables) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_accounts_receivables  "
                    + " where id='" + to_cash_drawer_accounts_receivables.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(CashDrawer_account_receivables.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_accounts_receivables> ret_data(String where) {
        List<to_cash_drawer_accounts_receivables> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",charge_type_id"
                    + ",charge_type"
                    + ",reference_no"
                    + ",customer_id"
                    + ",customer_name"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",check_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + " from cash_drawer_accounts_receivables"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String charge_type_id = rs.getString(5);
                String charge_type = rs.getString(6);
                String reference_no = rs.getString(7);
                String customer_id = rs.getString(8);
                String customer_name = rs.getString(9);
                double cash_amount = rs.getDouble(10);
                double cheque_amount = rs.getDouble(11);
                String check_holder = rs.getString(12);
                String cheque_bank = rs.getString(13);
                String cheque_no = rs.getString(14);
                String cheque_date = rs.getString(15);

                to_cash_drawer_accounts_receivables to = new to_cash_drawer_accounts_receivables(id, user_id, user_screen_name, date_added, charge_type_id, charge_type, reference_no, customer_id, customer_name, cash_amount, cheque_amount, check_holder, cheque_bank, cheque_no, cheque_date);
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
