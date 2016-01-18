/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

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
public class S1_disbursements {

    public static class to_disbursements {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String purpose;
        public final String category_id;
        public final String category_name;
        public final double amount;
        public final int is_vat;
        public final String disbursement_date;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_disbursements(int id, String user_id, String user_screen_name, String date_added, String purpose, String category_id, String category_name, double amount, int is_vat, String disbursement_date, String branch, String branch_id, String location, String location_id
        ) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.purpose = purpose;
            this.category_id = category_id;
            this.category_name = category_name;
            this.amount = amount;
            this.is_vat = is_vat;
            this.disbursement_date = disbursement_date;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_disbursements to_disbursements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into disbursements("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",purpose"
                    + ",category_id"
                    + ",category_name"
                    + ",amount"
                    + ",is_vat"
                    + ",disbursement_date"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:purpose"
                    + ",:category_id"
                    + ",:category_name"
                    + ",:amount"
                    + ",:is_vat"
                    + ",:disbursement_date"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_disbursements.user_id)
                    .setString("user_screen_name", to_disbursements.user_screen_name)
                    .setString("date_added", to_disbursements.date_added)
                    .setString("purpose", to_disbursements.purpose)
                    .setString("category_id", to_disbursements.category_id)
                    .setString("category_name", to_disbursements.category_name)
                    .setNumber("amount", to_disbursements.amount)
                    .setNumber("is_vat", to_disbursements.is_vat)
                    .setString("disbursement_date", to_disbursements.disbursement_date)
                    .setString("branch", to_disbursements.branch)
                    .setString("branch_id", to_disbursements.branch_id)
                    .setString("location", to_disbursements.location)
                    .setString("location_id", to_disbursements.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_disbursements.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_disbursements to_disbursements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update disbursements set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",purpose= :purpose "
                    + ",category_id= :category_id "
                    + ",category_name= :category_name "
                    + ",amount= :amount "
                    + ",is_vat= :is_vat "
                    + ",disbursement_date= :disbursement_date "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_disbursements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_disbursements.user_id)
                    .setString("user_screen_name", to_disbursements.user_screen_name)
                    .setString("date_added", to_disbursements.date_added)
                    .setString("purpose", to_disbursements.purpose)
                    .setString("category_id", to_disbursements.category_id)
                    .setString("category_name", to_disbursements.category_name)
                    .setNumber("amount", to_disbursements.amount)
                    .setNumber("is_vat", to_disbursements.is_vat)
                    .setString("disbursement_date", to_disbursements.disbursement_date)
                    .setString("branch", to_disbursements.branch)
                    .setString("branch_id", to_disbursements.branch_id)
                    .setString("location", to_disbursements.location)
                    .setString("location_id", to_disbursements.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_disbursements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_disbursements to_disbursements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from disbursements  "
                    + " where id='" + to_disbursements.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_disbursements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_disbursements> ret_data(String where) {
        List<to_disbursements> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",purpose"
                    + ",category_id"
                    + ",category_name"
                    + ",amount"
                    + ",is_vat"
                    + ",disbursement_date"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from disbursements"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String purpose = rs.getString(5);
                String category_id = rs.getString(6);
                String category_name = rs.getString(7);
                double amount = rs.getDouble(8);
                int is_vat = rs.getInt(9);
                String disbursement_date = rs.getString(10);
                String branch=rs.getString(11);
                String branch_id=rs.getString(12);
                String location=rs.getString(13);
                String location_id=rs.getString(14);
                to_disbursements to = new to_disbursements(id, user_id, user_screen_name, date_added, purpose, category_id
                        , category_name, amount, is_vat, disbursement_date,branch,branch_id,location,location_id);
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
