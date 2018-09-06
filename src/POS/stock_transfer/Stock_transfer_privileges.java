/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

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
public class Stock_transfer_privileges {

    public static class to_stock_transfer_privileges {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final int add_transfer;
        public final int edit_transfer;
        public final int delete_transfer;
        public final int finalize_transfer;

        public to_stock_transfer_privileges(int id, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id, int add_transfer, int edit_transfer, int delete_transfer, int finalize_transfer) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.add_transfer = add_transfer;
            this.edit_transfer = edit_transfer;
            this.delete_transfer = delete_transfer;
            this.finalize_transfer = finalize_transfer;
        }
    }

    public static void add_data(to_stock_transfer_privileges to_stock_transfer_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into stock_transfer_privileges("
                    + "user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",add_transfer"
                    + ",edit_transfer"
                    + ",delete_transfer"
                    + ",finalize_transfer"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:add_transfer"
                    + ",:edit_transfer"
                    + ",:delete_transfer"
                    + ",:finalize_transfer"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_stock_transfer_privileges.user_id)
                    .setString("user_screen_name", to_stock_transfer_privileges.user_screen_name)
                    .setString("branch", to_stock_transfer_privileges.branch)
                    .setString("branch_id", to_stock_transfer_privileges.branch_id)
                    .setString("location", to_stock_transfer_privileges.location)
                    .setString("location_id", to_stock_transfer_privileges.location_id)
                    .setNumber("add_transfer", to_stock_transfer_privileges.add_transfer)
                    .setNumber("edit_transfer", to_stock_transfer_privileges.edit_transfer)
                    .setNumber("delete_transfer", to_stock_transfer_privileges.delete_transfer)
                    .setNumber("finalize_transfer", to_stock_transfer_privileges.finalize_transfer)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_privileges.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_stock_transfer_privileges to_stock_transfer_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_transfer_privileges set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",add_transfer= :add_transfer "
                    + ",edit_transfer= :edit_transfer "
                    + ",delete_transfer= :delete_transfer "
                    + ",finalize_transfer= :finalize_transfer "
                    + " where id='" + to_stock_transfer_privileges.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_stock_transfer_privileges.user_id)
                    .setString("user_screen_name", to_stock_transfer_privileges.user_screen_name)
                    .setString("branch", to_stock_transfer_privileges.branch)
                    .setString("branch_id", to_stock_transfer_privileges.branch_id)
                    .setString("location", to_stock_transfer_privileges.location)
                    .setString("location_id", to_stock_transfer_privileges.location_id)
                    .setNumber("add_transfer", to_stock_transfer_privileges.add_transfer)
                    .setNumber("edit_transfer", to_stock_transfer_privileges.edit_transfer)
                    .setNumber("delete_transfer", to_stock_transfer_privileges.delete_transfer)
                    .setNumber("finalize_transfer", to_stock_transfer_privileges.finalize_transfer)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_privileges.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_stock_transfer_privileges to_stock_transfer_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_transfer_privileges  "
                    + " where id='" + to_stock_transfer_privileges.id + "' "
                    + " ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_privileges.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static List<to_stock_transfer_privileges> ret_data(String where) {
        List<to_stock_transfer_privileges> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",add_transfer"
                    + ",edit_transfer"
                    + ",delete_transfer"
                    + ",finalize_transfer"
                    + " from stock_transfer_privileges"
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String branch = rs.getString(4);
                String branch_id = rs.getString(5);
                String location = rs.getString(6);
                String location_id = rs.getString(7);
                int add_transfer = rs.getInt(8);
                int edit_transfer = rs.getInt(9);
                int delete_transfer = rs.getInt(10);
                int finalize_transfer = rs.getInt(11);
                to_stock_transfer_privileges to = new to_stock_transfer_privileges(id, user_id, user_screen_name, branch, branch_id, location, location_id, add_transfer, edit_transfer, delete_transfer, finalize_transfer);
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
