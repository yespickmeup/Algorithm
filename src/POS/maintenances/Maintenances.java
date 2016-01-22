/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.maintenances;

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
public class Maintenances {

    public static class to_maintenances {

        public final int id;
        public final String stmts;
        public final int status;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_maintenances(int id, String stmts, int status, String date_added, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.stmts = stmts;
            this.status = status;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_maintenances to_maintenances) {
        try {
            Connection conn = MyConnection.connect();
            
            String s0 = "insert into maintenances("
                    + "stmts"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":stmts"
                    + ",:status"
                    + ",:date_added"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("stmts", to_maintenances.stmts)
                    .setNumber("status", to_maintenances.status)
                    .setString("date_added", to_maintenances.date_added)
                    .setString("user_id", to_maintenances.user_id)
                    .setString("user_screen_name", to_maintenances.user_screen_name)
                    .setString("branch", to_maintenances.branch)
                    .setString("branch_id", to_maintenances.branch_id)
                    .setString("location", to_maintenances.location)
                    .setString("location_id", to_maintenances.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Maintenances.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_maintenances to_maintenances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update maintenances set "
                    + "stmts= :stmts "
                    + ",status= :status "
                    + ",date_added= :date_added "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_maintenances.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("stmts", to_maintenances.stmts)
                    .setNumber("status", to_maintenances.status)
                    .setString("date_added", to_maintenances.date_added)
                    .setString("user_id", to_maintenances.user_id)
                    .setString("user_screen_name", to_maintenances.user_screen_name)
                    .setString("branch", to_maintenances.branch)
                    .setString("branch_id", to_maintenances.branch_id)
                    .setString("location", to_maintenances.location)
                    .setString("location_id", to_maintenances.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Maintenances.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_maintenances to_maintenances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from maintenances  "
                    + " where id='" + to_maintenances.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Maintenances.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_maintenances> ret_data(String where) {
        List<to_maintenances> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " id"
                    + ",stmts"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from maintenances"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String stmts = rs.getString(2);
                int status = rs.getInt(3);
                String date_added = rs.getString(4);
                String user_id = rs.getString(5);
                String user_screen_name = rs.getString(6);
                String branch = rs.getString(7);
                String branch_id = rs.getString(8);
                String location = rs.getString(9);
                String location_id = rs.getString(10);

                to_maintenances to = new to_maintenances(id, stmts, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
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
