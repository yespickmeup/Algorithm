/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

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
public class Cashier_shifts {

    public static class to_cashier_shifts {

        public final int id;
        public final String created_at;
        public final String created_by;
        public final String updated_at;
        public final String updated_by;
        public final String description;
        public final String shift;
        public final int status;
        public final int is_uploaded;

        public to_cashier_shifts(int id, String created_at, String created_by, String updated_at, String updated_by, String description, String shift, int status, int is_uploaded) {
            this.id = id;
            this.created_at = created_at;
            this.created_by = created_by;
            this.updated_at = updated_at;
            this.updated_by = updated_by;
            this.description = description;
            this.shift = shift;
            this.status = status;
            this.is_uploaded = is_uploaded;
        }
    }

    public static void add_data(to_cashier_shifts to_cashier_shifts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cashier_shifts("
                    + "created_at"
                    + ",created_by"
                    + ",updated_at"
                    + ",updated_by"
                    + ",description"
                    + ",shift"
                    + ",status"
                    + ",is_uploaded"
                    + ")values("
                    + ":created_at"
                    + ",:created_by"
                    + ",:updated_at"
                    + ",:updated_by"
                    + ",:description"
                    + ",:shift"
                    + ",:status"
                    + ",:is_uploaded"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("created_at", to_cashier_shifts.created_at)
                    .setString("created_by", to_cashier_shifts.created_by)
                    .setString("updated_at", to_cashier_shifts.updated_at)
                    .setString("updated_by", to_cashier_shifts.updated_by)
                    .setString("description", to_cashier_shifts.description)
                    .setString("shift", to_cashier_shifts.shift)
                    .setNumber("status", to_cashier_shifts.status)
                    .setNumber("is_uploaded", to_cashier_shifts.is_uploaded)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Cashier_shifts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cashier_shifts to_cashier_shifts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cashier_shifts set "
                    + "created_at= :created_at "
                    + ",created_by= :created_by "
                    + ",updated_at= :updated_at "
                    + ",updated_by= :updated_by "
                    + ",description= :description "
                    + ",shift= :shift "
                    + ",status= :status "
                    + ",is_uploaded= :is_uploaded "
                    + " where id='" + to_cashier_shifts.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("created_at", to_cashier_shifts.created_at)
                    .setString("created_by", to_cashier_shifts.created_by)
                    .setString("updated_at", to_cashier_shifts.updated_at)
                    .setString("updated_by", to_cashier_shifts.updated_by)
                    .setString("description", to_cashier_shifts.description)
                    .setString("shift", to_cashier_shifts.shift)
                    .setNumber("status", to_cashier_shifts.status)
                    .setNumber("is_uploaded", to_cashier_shifts.is_uploaded)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Cashier_shifts.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cashier_shifts to_cashier_shifts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cashier_shifts  "
                    + " where id='" + to_cashier_shifts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Cashier_shifts.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cashier_shifts> ret_data(String where) {
        List<to_cashier_shifts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",created_at"
                    + ",created_by"
                    + ",updated_at"
                    + ",updated_by"
                    + ",description"
                    + ",shift"
                    + ",status"
                    + ",is_uploaded"
                    + " from cashier_shifts"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String created_at = rs.getString(2);
                String created_by = rs.getString(3);
                String updated_at = rs.getString(4);
                String updated_by = rs.getString(5);
                String description = rs.getString(6);
                String shift = rs.getString(7);
                int status = rs.getInt(8);
                int is_uploaded = rs.getInt(9);

                to_cashier_shifts to = new to_cashier_shifts(id, created_at, created_by, updated_at, updated_by, description, shift, status, is_uploaded);
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
