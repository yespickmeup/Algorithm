/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.notifications;

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
public class Notifications {

    public static class to_notifications {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String created_at;
        public final int status;
        public final String remarks;
        public final String module;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_notifications(int id, String user_id, String user_screen_name, String created_at, int status, String remarks, String module, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.created_at = created_at;
            this.status = status;
            this.remarks = remarks;
            this.module = module;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_notifications to_notifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into notifications("
                    + "user_id"
                    + ",user_screen_name"
                    + ",created_at"
                    + ",status"
                    + ",remarks"
                    + ",module"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:created_at"
                    + ",:status"
                    + ",:remarks"
                    + ",:module"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_notifications.user_id)
                    .setString("user_screen_name", to_notifications.user_screen_name)
                    .setString("created_at", to_notifications.created_at)
                    .setNumber("status", to_notifications.status)
                    .setString("remarks", to_notifications.remarks)
                    .setString("module", to_notifications.module)
                    .setString("branch", to_notifications.branch)
                    .setString("branch_id", to_notifications.branch_id)
                    .setString("location", to_notifications.location)
                    .setString("location_id", to_notifications.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Notifications.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_notifications to_notifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update notifications set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",created_at= :created_at "
                    + ",status= :status "
                    + ",remarks= :remarks "
                    + ",module= :module "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_notifications.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_notifications.user_id)
                    .setString("user_screen_name", to_notifications.user_screen_name)
                    .setString("created_at", to_notifications.created_at)
                    .setNumber("status", to_notifications.status)
                    .setString("remarks", to_notifications.remarks)
                    .setString("module", to_notifications.module)
                    .setString("branch", to_notifications.branch)
                    .setString("branch_id", to_notifications.branch_id)
                    .setString("location", to_notifications.location)
                    .setString("location_id", to_notifications.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Notifications.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_notifications to_notifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from notifications  "
                    + " where id='" + to_notifications.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Notifications.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_notifications> ret_data(String where) {
        List<to_notifications> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",created_at"
                    + ",status"
                    + ",remarks"
                    + ",module"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from notifications"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String created_at = rs.getString(4);
                int status = rs.getInt(5);
                String remarks = rs.getString(6);
                String module = rs.getString(7);
                String branch = rs.getString(8);
                String branch_id = rs.getString(9);
                String location = rs.getString(10);
                String location_id = rs.getString(11);

                to_notifications to = new to_notifications(id, user_id, user_screen_name, created_at, status, remarks, module, branch, branch_id, location, location_id);
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
