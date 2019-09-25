/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

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
 * @author Ronescape
 */
public class Inventory_location_privileges {

    public static class to_inventory_location_privileges {

        public final int id;
        public final String user_id;
        public final String user_name;
        public final String created_at;
        public final String created_by;
        public final String updated_at;
        public final String updated_by;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final int status;

        public to_inventory_location_privileges(int id, String user_id, String user_name, String created_at, String created_by, String updated_at, String updated_by, String branch, String branch_id, String location, String location_id, int status) {
            this.id = id;
            this.user_id = user_id;
            this.user_name = user_name;
            this.created_at = created_at;
            this.created_by = created_by;
            this.updated_at = updated_at;
            this.updated_by = updated_by;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.status = status;
        }
    }

    public static void add_data(to_inventory_location_privileges to_inventory_location_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_location_privileges("
                    + "user_id"
                    + ",user_name"
                    + ",created_at"
                    + ",created_by"
                    + ",updated_at"
                    + ",updated_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",status"
                    + ")values("
                    + ":user_id"
                    + ",:user_name"
                    + ",:created_at"
                    + ",:created_by"
                    + ",:updated_at"
                    + ",:updated_by"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_inventory_location_privileges.user_id)
                    .setString("user_name", to_inventory_location_privileges.user_name)
                    .setString("created_at", to_inventory_location_privileges.created_at)
                    .setString("created_by", to_inventory_location_privileges.created_by)
                    .setString("updated_at", to_inventory_location_privileges.updated_at)
                    .setString("updated_by", to_inventory_location_privileges.updated_by)
                    .setString("branch", to_inventory_location_privileges.branch)
                    .setString("branch_id", to_inventory_location_privileges.branch_id)
                    .setString("location", to_inventory_location_privileges.location)
                    .setString("location_id", to_inventory_location_privileges.location_id)
                    .setNumber("status", to_inventory_location_privileges.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_location_privileges.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_inventory_location_privileges to_inventory_location_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_location_privileges set "
                    + "user_id= :user_id "
                    + ",user_name= :user_name "
                    + ",created_at= :created_at "
                    + ",created_by= :created_by "
                    + ",updated_at= :updated_at "
                    + ",updated_by= :updated_by "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",status= :status "
                    + " where id='" + to_inventory_location_privileges.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_inventory_location_privileges.user_id)
                    .setString("user_name", to_inventory_location_privileges.user_name)
                    .setString("created_at", to_inventory_location_privileges.created_at)
                    .setString("created_by", to_inventory_location_privileges.created_by)
                    .setString("updated_at", to_inventory_location_privileges.updated_at)
                    .setString("updated_by", to_inventory_location_privileges.updated_by)
                    .setString("branch", to_inventory_location_privileges.branch)
                    .setString("branch_id", to_inventory_location_privileges.branch_id)
                    .setString("location", to_inventory_location_privileges.location)
                    .setString("location_id", to_inventory_location_privileges.location_id)
                    .setNumber("status", to_inventory_location_privileges.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_location_privileges.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_inventory_location_privileges to_inventory_location_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_location_privileges  "
                    + " where id='" + to_inventory_location_privileges.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_location_privileges.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_location_privileges> ret_data(String where) {
        List<to_inventory_location_privileges> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_name"
                    + ",created_at"
                    + ",created_by"
                    + ",updated_at"
                    + ",updated_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",status"
                    + " from inventory_location_privileges"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_name = rs.getString(3);
                String created_at = rs.getString(4);
                String created_by = rs.getString(5);
                String updated_at = rs.getString(6);
                String updated_by = rs.getString(7);
                String branch = rs.getString(8);
                String branch_id = rs.getString(9);
                String location = rs.getString(10);
                String location_id = rs.getString(11);
                int status = rs.getInt(12);

                to_inventory_location_privileges to = new to_inventory_location_privileges(id, user_id, user_name, created_at, created_by, updated_at, updated_by, branch, branch_id, location, location_id, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_location_privileges> ret_data2(String user_id1) {
        List<to_inventory_location_privileges> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s2 = " select id,branch,branch_id,location  from branch_locations order by branch,location asc ";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                String branch = rs2.getString(2);
                String branch_id = rs2.getString(3);
                String location = rs2.getString(4);

                String s0 = "select "
                        + "id"
                        + ",user_id"
                        + ",user_name"
                        + ",created_at"
                        + ",created_by"
                        + ",updated_at"
                        + ",updated_by"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",status"
                        + " from inventory_location_privileges"
                        + " where location_id='" + id + "' and user_id='" + user_id1 + "' ";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                String user_id = "";
                String user_name = "";
                String created_at = "";
                String created_by = "";
                String updated_at = "";
                String updated_by = "";
                int id3 = 0;
                if (rs.next()) {
                    id3 = rs.getInt(1);
                    user_id = rs.getString(2);
                    user_name = rs.getString(3);
                    created_at = rs.getString(4);
                    created_by = rs.getString(5);
                    updated_at = rs.getString(6);
                    updated_by = rs.getString(7);

                    String location_id = rs.getString(11);
                    int status = rs.getInt(12);

                }
                to_inventory_location_privileges to = new to_inventory_location_privileges(id3, user_id, user_name, created_at, created_by, updated_at, updated_by, branch, branch_id, location, "" + id, 1);
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
