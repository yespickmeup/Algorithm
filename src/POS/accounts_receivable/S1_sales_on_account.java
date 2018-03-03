/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_sales_on_account {

    public static class to_sales_on_account {

        public final int id;
        public final String soa_type;
        public final String soa_type_id;
        public final String soa_date;
        public final String date_added;
        public final String added_by;
        public final String reference_no;
        public final String client_name;
        public final String client_id;
        public final double amount;

        public to_sales_on_account(int id, String soa_type, String soa_type_id, String soa_date, String date_added, String added_by, String reference_no, String client_name, String client_id, double amount) {
            this.id = id;
            this.soa_type = soa_type;
            this.soa_type_id = soa_type_id;
            this.soa_date = soa_date;
            this.date_added = date_added;
            this.added_by = added_by;
            this.reference_no = reference_no;
            this.client_name = client_name;
            this.client_id = client_id;
            this.amount = amount;
        }
    }

    public static void add_sales_on_account(to_sales_on_account to_sales_on_account) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sales_on_account("
                    + "soa_type"
                    + ",soa_type_id"
                    + ",soa_date"
                    + ",date_added"
                    + ",added_by"
                    + ",reference_no"
                    + ",client_name"
                    + ",client_id"
                    + ",amount"
                    + ")values("
                    + ":soa_type"
                    + ",:soa_type_id"
                    + ",:soa_date"
                    + ",:date_added"
                    + ",:added_by"
                    + ",:reference_no"
                    + ",:client_name"
                    + ",:client_id"
                    + ",:amount"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("soa_type", to_sales_on_account.soa_type)
                    .setString("soa_type_id", to_sales_on_account.soa_type_id)
                    .setString("soa_date", to_sales_on_account.soa_date)
                    .setString("date_added", to_sales_on_account.date_added)
                    .setString("added_by", to_sales_on_account.added_by)
                    .setString("reference_no", to_sales_on_account.reference_no)
                    .setString("client_name", to_sales_on_account.client_name)
                    .setString("client_id", to_sales_on_account.client_id)
                    .setNumber("amount", to_sales_on_account.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_on_account.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sales_on_account(to_sales_on_account to_sales_on_account) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales_on_account set "
                    + "soa_type= :soa_type"
                    + ",soa_type_id= :soa_type_id"
                    + ",soa_date= :soa_date"
                    + ",date_added= :date_added"
                    + ",added_by= :added_by"
                    + ",reference_no= :reference_no"
                    + ",client_name= :client_name"
                    + ",client_id= :client_id"
                    + ",amount= :amount"
                    + " where "
                    + " id ='" + to_sales_on_account.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("soa_type", to_sales_on_account.soa_type)
                    .setString("soa_type_id", to_sales_on_account.soa_type_id)
                    .setString("soa_date", to_sales_on_account.soa_date)
                    .setString("date_added", to_sales_on_account.date_added)
                    .setString("added_by", to_sales_on_account.added_by)
                    .setString("reference_no", to_sales_on_account.reference_no)
                    .setString("client_name", to_sales_on_account.client_name)
                    .setString("client_id", to_sales_on_account.client_id)
                    .setNumber("amount", to_sales_on_account.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_on_account.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales_on_account(to_sales_on_account to_sales_on_account) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sales_on_account where "
                    + " id ='" + to_sales_on_account.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_on_account.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_on_account> ret_data(String where) {
        List<to_sales_on_account> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",soa_date"
                    + ",date_added"
                    + ",added_by"
                    + ",reference_no"
                    + ",client_name"
                    + ",client_id"
                    + ",amount"
                    + " from sales_on_account  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String soa_type = rs.getString(2);
                String soa_type_id = rs.getString(3);
                String soa_date = rs.getString(4);
                String date_added = rs.getString(5);
                String added_by = rs.getString(6);
                String reference_no = rs.getString(7);
                String client_name = rs.getString(8);
                String client_id = rs.getString(9);
                double amount = rs.getDouble(10);

                to_sales_on_account to = new to_sales_on_account(id, soa_type, soa_type_id, soa_date, date_added, added_by, reference_no, client_name, client_id, amount);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_sales_on_account ret_data2(String where) {

        to_sales_on_account to = null;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",soa_date"
                    + ",date_added"
                    + ",added_by"
                    + ",reference_no"
                    + ",client_name"
                    + ",client_id"
                    + ",amount"
                    + " from sales_on_account  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String soa_type = rs.getString(2);
                String soa_type_id = rs.getString(3);
                String soa_date = rs.getString(4);
                String date_added = rs.getString(5);
                String added_by = rs.getString(6);
                String reference_no = rs.getString(7);
                String client_name = rs.getString(8);
                String client_id = rs.getString(9);
                double amount = rs.getDouble(10);

                to = new to_sales_on_account(id, soa_type, soa_type_id, soa_date, date_added, added_by, reference_no, client_name, client_id, amount);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from sales_on_account";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id_conn( Connection conn) {
        String id = "";
        try {
            String s0 = "select max(id) from sales_on_account";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }
    }

    public static String increment_id2(String where) {
        String id = "0000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from sales_on_account " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select reference_no from sales_on_account  where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "0000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
