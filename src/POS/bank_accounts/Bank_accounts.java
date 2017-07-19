/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bank_accounts;

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
public class Bank_accounts {

    public static class to_bank_accounts {

        public final int id;
        public final String bank_account_no;
        public final String bank_holder;
        public final String bank_name;
        public final String remarks;
        public final double outstanding_balance;
        public final double withdrawable_balance;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_bank_accounts(int id, String bank_account_no, String bank_holder, String bank_name, String remarks, double outstanding_balance, double withdrawable_balance, String created_at, String updated_at, String created_by, String updated_by, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.bank_account_no = bank_account_no;
            this.bank_holder = bank_holder;
            this.bank_name = bank_name;
            this.remarks = remarks;
            this.outstanding_balance = outstanding_balance;
            this.withdrawable_balance = withdrawable_balance;
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

    public static void add_data(to_bank_accounts to_bank_accounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into bank_accounts("
                    + "bank_account_no"
                    + ",bank_holder"
                    + ",bank_name"
                    + ",remarks"
                    + ",outstanding_balance"
                    + ",withdrawable_balance"
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
                    + ":bank_account_no"
                    + ",:bank_holder"
                    + ",:bank_name"
                    + ",:remarks"
                    + ",:outstanding_balance"
                    + ",:withdrawable_balance"
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
                    .setString("bank_account_no", to_bank_accounts.bank_account_no)
                    .setString("bank_holder", to_bank_accounts.bank_holder)
                    .setString("bank_name", to_bank_accounts.bank_name)
                    .setString("remarks", to_bank_accounts.remarks)
                    .setNumber("outstanding_balance", to_bank_accounts.outstanding_balance)
                    .setNumber("withdrawable_balance", to_bank_accounts.withdrawable_balance)
                    .setString("created_at", to_bank_accounts.created_at)
                    .setString("updated_at", to_bank_accounts.updated_at)
                    .setString("created_by", to_bank_accounts.created_by)
                    .setString("updated_by", to_bank_accounts.updated_by)
                    .setNumber("status", to_bank_accounts.status)
                    .setString("branch", to_bank_accounts.branch)
                    .setString("branch_id", to_bank_accounts.branch_id)
                    .setString("location", to_bank_accounts.location)
                    .setString("location_id", to_bank_accounts.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Bank_accounts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_bank_accounts to_bank_accounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update bank_accounts set "
                    + "bank_account_no= :bank_account_no "
                    + ",bank_holder= :bank_holder "
                    + ",bank_name= :bank_name "
                    + ",remarks= :remarks "
                    + ",outstanding_balance= :outstanding_balance "
                    + ",withdrawable_balance= :withdrawable_balance "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_bank_accounts.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("bank_account_no", to_bank_accounts.bank_account_no)
                    .setString("bank_holder", to_bank_accounts.bank_holder)
                    .setString("bank_name", to_bank_accounts.bank_name)
                    .setString("remarks", to_bank_accounts.remarks)
                    .setNumber("outstanding_balance", to_bank_accounts.outstanding_balance)
                    .setNumber("withdrawable_balance", to_bank_accounts.withdrawable_balance)
                    .setString("created_at", to_bank_accounts.created_at)
                    .setString("updated_at", to_bank_accounts.updated_at)
                    .setString("created_by", to_bank_accounts.created_by)
                    .setString("updated_by", to_bank_accounts.updated_by)
                    .setNumber("status", to_bank_accounts.status)
                    .setString("branch", to_bank_accounts.branch)
                    .setString("branch_id", to_bank_accounts.branch_id)
                    .setString("location", to_bank_accounts.location)
                    .setString("location_id", to_bank_accounts.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Bank_accounts.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_bank_accounts to_bank_accounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from bank_accounts  "
                    + " where id='" + to_bank_accounts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Bank_accounts.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_bank_accounts> ret_data(String where) {
        
        List<to_bank_accounts> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " id"
                    + ",bank_account_no"
                    + ",bank_holder"
                    + ",bank_name"
                    + ",remarks"
                    + ",outstanding_balance"
                    + ",withdrawable_balance"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from bank_accounts"
                    + " " + where;
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String bank_account_no = rs.getString(2);
                String bank_holder = rs.getString(3);
                String bank_name = rs.getString(4);
                String remarks = rs.getString(5);
                double outstanding_balance = rs.getDouble(6);
                double withdrawable_balance = rs.getDouble(7);
                String created_at = rs.getString(8);
                String updated_at = rs.getString(9);
                String created_by = rs.getString(10);
                String updated_by = rs.getString(11);
                int status = rs.getInt(12);
                String branch = rs.getString(13);
                String branch_id = rs.getString(14);
                String location = rs.getString(15);
                String location_id = rs.getString(16);
                to_bank_accounts to = new to_bank_accounts(id, bank_account_no, bank_holder, bank_name, remarks, outstanding_balance, withdrawable_balance, created_at, updated_at, created_by, updated_by, status, branch, branch_id, location, location_id);
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
