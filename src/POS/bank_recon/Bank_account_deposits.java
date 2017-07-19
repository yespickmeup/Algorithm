/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bank_recon;

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
public class Bank_account_deposits {

    public static class to_bank_account_deposits {

        public final int id;
        public final String reference_no;
        public final String bank_account_no;
        public final String bank_holder;
        public final String bank_name;
        public final String remarks;
        public final double cash;
        public final double check_amount;
        public final String check_holder;
        public final String check_no;
        public final String check_date;
        public final int check_is_cleared;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_bank_account_deposits(int id, String reference_no, String bank_account_no, String bank_holder, String bank_name, String remarks, double cash, double check_amount, String check_holder, String check_no, String check_date, int check_is_cleared, String created_at, String updated_at, String created_by, String updated_by, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.reference_no = reference_no;
            this.bank_account_no = bank_account_no;
            this.bank_holder = bank_holder;
            this.bank_name = bank_name;
            this.remarks = remarks;
            this.cash = cash;
            this.check_amount = check_amount;
            this.check_holder = check_holder;
            this.check_no = check_no;
            this.check_date = check_date;
            this.check_is_cleared = check_is_cleared;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_bank_account_deposits to_bank_account_deposits) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into bank_account_deposits("
                    + "reference_no"
                    + ",bank_account_no"
                    + ",bank_holder"
                    + ",bank_name"
                    + ",remarks"
                    + ",cash"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_no"
                    + ",check_date"
                    + ",check_is_cleared"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":reference_no"
                    + ",:bank_account_no"
                    + ",:bank_holder"
                    + ",:bank_name"
                    + ",:remarks"
                    + ",:cash"
                    + ",:check_amount"
                    + ",:check_holder"
                    + ",:check_no"
                    + ",:check_date"
                    + ",:check_is_cleared"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("reference_no", to_bank_account_deposits.reference_no)
                    .setString("bank_account_no", to_bank_account_deposits.bank_account_no)
                    .setString("bank_holder", to_bank_account_deposits.bank_holder)
                    .setString("bank_name", to_bank_account_deposits.bank_name)
                    .setString("remarks", to_bank_account_deposits.remarks)
                    .setNumber("cash", to_bank_account_deposits.cash)
                    .setNumber("check_amount", to_bank_account_deposits.check_amount)
                    .setString("check_holder", to_bank_account_deposits.check_holder)
                    .setString("check_no", to_bank_account_deposits.check_no)
                    .setString("check_date", to_bank_account_deposits.check_date)
                    .setNumber("check_is_cleared", to_bank_account_deposits.check_is_cleared)
                    .setString("created_at", to_bank_account_deposits.created_at)
                    .setString("updated_at", to_bank_account_deposits.updated_at)
                    .setString("created_by", to_bank_account_deposits.created_by)
                    .setString("updated_by", to_bank_account_deposits.updated_by)
                    .setNumber("status", to_bank_account_deposits.status)
                    .setString("branch", to_bank_account_deposits.branch)
                    .setString("branch_id", to_bank_account_deposits.branch_id)
                    .setString("location", to_bank_account_deposits.location)
                    .setString("location_id", to_bank_account_deposits.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Bank_account_deposits.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_bank_account_deposits to_bank_account_deposits) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update bank_account_deposits set "
                    + "reference_no= :reference_no"
                    + ",bank_account_no= :bank_account_no "
                    + ",bank_holder= :bank_holder "
                    + ",bank_name= :bank_name "
                    + ",remarks= :remarks "
                    + ",cash= :cash "
                    + ",check_amount= :check_amount "
                    + ",check_holder= :check_holder "
                    + ",check_no= :check_no "
                    + ",check_date= :check_date "
                    + ",check_is_cleared= :check_is_cleared "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_bank_account_deposits.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("reference_no", to_bank_account_deposits.reference_no)
                    .setString("bank_account_no", to_bank_account_deposits.bank_account_no)
                    .setString("bank_holder", to_bank_account_deposits.bank_holder)
                    .setString("bank_name", to_bank_account_deposits.bank_name)
                    .setString("remarks", to_bank_account_deposits.remarks)
                    .setNumber("cash", to_bank_account_deposits.cash)
                    .setNumber("check_amount", to_bank_account_deposits.check_amount)
                    .setString("check_holder", to_bank_account_deposits.check_holder)
                    .setString("check_no", to_bank_account_deposits.check_no)
                    .setString("check_date", to_bank_account_deposits.check_date)
                    .setNumber("check_is_cleared", to_bank_account_deposits.check_is_cleared)
                    .setString("created_at", to_bank_account_deposits.created_at)
                    .setString("updated_at", to_bank_account_deposits.updated_at)
                    .setString("created_by", to_bank_account_deposits.created_by)
                    .setString("updated_by", to_bank_account_deposits.updated_by)
                    .setNumber("status", to_bank_account_deposits.status)
                    .setString("branch", to_bank_account_deposits.branch)
                    .setString("branch_id", to_bank_account_deposits.branch_id)
                    .setString("location", to_bank_account_deposits.location)
                    .setString("location_id", to_bank_account_deposits.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Bank_account_deposits.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_bank_account_deposits to_bank_account_deposits) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from bank_account_deposits  "
                    + " where id='" + to_bank_account_deposits.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Bank_account_deposits.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_bank_account_deposits> ret_data(String where) {
        List<to_bank_account_deposits> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",bank_account_no"
                    + ",bank_holder"
                    + ",bank_name"
                    + ",remarks"
                    + ",cash"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_no"
                    + ",check_date"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",reference_no"
                    + ",check_is_cleared"
                    + " from bank_account_deposits"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String bank_account_no = rs.getString(2);
                String bank_holder = rs.getString(3);
                String bank_name = rs.getString(4);
                String remarks = rs.getString(5);
                double cash = rs.getDouble(6);
                double check_amount = rs.getDouble(7);
                String check_holder = rs.getString(8);
                String check_no = rs.getString(9);
                String check_date = rs.getString(10);
                String created_at = rs.getString(11);
                String updated_at = rs.getString(12);
                String created_by = rs.getString(13);
                String updated_by = rs.getString(14);
                int status = rs.getInt(15);
                String branch = rs.getString(16);
                String branch_id = rs.getString(17);
                String location = rs.getString(18);
                String location_id = rs.getString(19);
                String reference_no = rs.getString(20);
                int check_is_cleared = rs.getInt(21);
                to_bank_account_deposits to = new to_bank_account_deposits(id, reference_no, bank_account_no, bank_holder, bank_name, remarks, cash, check_amount, check_holder, check_no, check_date, check_is_cleared, created_at, updated_at, created_by, updated_by, status, branch, branch_id, location, location_id);
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
