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
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_account_receivable_types {

    public static class to_accounts_receivable_types {

        public final int id;
        public final String type_name;

        public to_accounts_receivable_types(int id, String type_name) {
            this.id = id;
            this.type_name = type_name;
        }
    }

    public static void main2(String[] args) {
        to_accounts_receivable_types to1 = new to_accounts_receivable_types(1, "CHARGE INVOICE");
        to_accounts_receivable_types to2 = new to_accounts_receivable_types(2, "TRUST RECEIPT AGREEMENT");
        to_accounts_receivable_types to3 = new to_accounts_receivable_types(3, "DES - TR DGTE");
        to_accounts_receivable_types to4 = new to_accounts_receivable_types(4, "DES - TR KAB");
        to_accounts_receivable_types to5 = new to_accounts_receivable_types(5, "DES - TR CBU");
        add_accounts_receivable_types(to1);
        add_accounts_receivable_types(to2);
        add_accounts_receivable_types(to3);
        add_accounts_receivable_types(to4);
        add_accounts_receivable_types(to5);
    }

    public static void add_accounts_receivable_types(to_accounts_receivable_types to_accounts_receivable_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into accounts_receivable_types("
                    + "type_name"
                    + ")values("
                    + ":type_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("type_name", to_accounts_receivable_types.type_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_account_receivable_types.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_accounts_receivable_types(to_accounts_receivable_types to_accounts_receivable_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update accounts_receivable_types set "
                    + "type_name= :type_name"
                    + " where "
                    + " id ='" + to_accounts_receivable_types.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("type_name", to_accounts_receivable_types.type_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_account_receivable_types.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_accounts_receivable_types(to_accounts_receivable_types to_accounts_receivable_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from accounts_receivable_types where "
                    + " id ='" + to_accounts_receivable_types.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_account_receivable_types.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_accounts_receivable_types> ret_data(String where) {
        List<to_accounts_receivable_types> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",type_name"
                    + " from accounts_receivable_types  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String type_name = rs.getString(2);

                to_accounts_receivable_types to = new to_accounts_receivable_types(id, type_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_accounts_receivable_types> ret_data2(String where) {
        List<to_accounts_receivable_types> datas = new ArrayList();

       
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",type_name"
                    + " from accounts_receivable_types  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String type_name = rs.getString(2);

                to_accounts_receivable_types to = new to_accounts_receivable_types(id, type_name);
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
