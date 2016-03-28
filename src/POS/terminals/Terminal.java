/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.terminals;

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
public class Terminal {

    public static class to_terminals {

        public final int id;
        public final String terminal;
        public final String ip_address;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;

        public to_terminals(int id, String terminal, String ip_address, String branch, String branch_id, String location, String location_id, String created_at, String updated_at, String created_by, String updated_by, int status) {
            this.id = id;
            this.terminal = terminal;
            this.ip_address = ip_address;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.status = status;
        }
    }

    public static void add_data(to_terminals to_terminals) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into terminals("
                    + "terminal"
                    + ",ip_address"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ")values("
                    + ":terminal"
                    + ",:ip_address"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("terminal", to_terminals.terminal)
                    .setString("ip_address", to_terminals.ip_address)
                    .setString("branch", to_terminals.branch)
                    .setString("branch_id", to_terminals.branch_id)
                    .setString("location", to_terminals.location)
                    .setString("location_id", to_terminals.location_id)
                    .setString("created_at", to_terminals.created_at)
                    .setString("updated_at", to_terminals.updated_at)
                    .setString("created_by", to_terminals.created_by)
                    .setString("updated_by", to_terminals.updated_by)
                    .setNumber("status", to_terminals.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Terminal.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_terminals to_terminals) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update terminals set "
                    + "terminal= :terminal "
                    + ",ip_address= :ip_address "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + " where id='" + to_terminals.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("terminal", to_terminals.terminal)
                    .setString("ip_address", to_terminals.ip_address)
                    .setString("branch", to_terminals.branch)
                    .setString("branch_id", to_terminals.branch_id)
                    .setString("location", to_terminals.location)
                    .setString("location_id", to_terminals.location_id)
                    .setString("created_at", to_terminals.created_at)
                    .setString("updated_at", to_terminals.updated_at)
                    .setString("created_by", to_terminals.created_by)
                    .setString("updated_by", to_terminals.updated_by)
                    .setNumber("status", to_terminals.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Terminal.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_terminals to_terminals) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from terminals  "
                    + " where id='" + to_terminals.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Terminal.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_terminals> ret_data(String where) {
        List<to_terminals> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",terminal"
                    + ",ip_address"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + " from terminals"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String terminal = rs.getString(2);
                String ip_address = rs.getString(3);
                String branch = rs.getString(4);
                String branch_id = rs.getString(5);
                String location = rs.getString(6);
                String location_id = rs.getString(7);
                String created_at = rs.getString(8);
                String updated_at = rs.getString(9);
                String created_by = rs.getString(10);
                String updated_by = rs.getString(11);
                int status = rs.getInt(12);

                to_terminals to = new to_terminals(id, terminal, ip_address, branch, branch_id, location, location_id, created_at, updated_at, created_by, updated_by, status);
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
