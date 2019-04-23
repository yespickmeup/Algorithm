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
public class Cashier_shift_schedules {

    public static class shift_cashiers {

        public final int id;
        public final String cashier_id;
        public final String cashier_user_name;
        public final String cashier_screen_name;
        public boolean selected;
        public final String shift;
        public shift_cashiers(int id, String cashier_id, String cashier_user_name, String cashier_screen_name, boolean selected,String shift) {
            this.id = id;
            this.cashier_id = cashier_id;
            this.cashier_user_name = cashier_user_name;
            this.cashier_screen_name = cashier_screen_name;
            this.selected = selected;
            this.shift=shift;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static class to_cashier_shift_schedules {

        public final int id;
        public final String created_at;
        public final String created_by;
        public final String updated_at;
        public final String updated_by;
        public final String cashier_id;
        public final String cashier_name;
        public final int cashier_shift_id;
        public final String cashier_shift;
        public final int status;
        public final int is_uploaded;

        public to_cashier_shift_schedules(int id, String created_at, String created_by, String updated_at, String updated_by, String cashier_id, String cashier_name, int cashier_shift_id, String cashier_shift, int status, int is_uploaded) {
            this.id = id;
            this.created_at = created_at;
            this.created_by = created_by;
            this.updated_at = updated_at;
            this.updated_by = updated_by;
            this.cashier_id = cashier_id;
            this.cashier_name = cashier_name;
            this.cashier_shift_id = cashier_shift_id;
            this.cashier_shift = cashier_shift;
            this.status = status;
            this.is_uploaded = is_uploaded;
        }
    }

    public static void add_data(to_cashier_shift_schedules to_cashier_shift_schedules) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement("");
            String s2 = " update cashier_shift_schedules set status=0 where cashier_id='" + to_cashier_shift_schedules.cashier_id + "' ";
            stmt.addBatch(s2);

            String s0 = "insert into cashier_shift_schedules("
                    + "created_at"
                    + ",created_by"
                    + ",updated_at"
                    + ",updated_by"
                    + ",cashier_id"
                    + ",cashier_name"
                    + ",cashier_shift_id"
                    + ",cashier_shift"
                    + ",status"
                    + ",is_uploaded"
                    + ")values("
                    + ":created_at"
                    + ",:created_by"
                    + ",:updated_at"
                    + ",:updated_by"
                    + ",:cashier_id"
                    + ",:cashier_name"
                    + ",:cashier_shift_id"
                    + ",:cashier_shift"
                    + ",:status"
                    + ",:is_uploaded"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("created_at", to_cashier_shift_schedules.created_at)
                    .setString("created_by", to_cashier_shift_schedules.created_by)
                    .setString("updated_at", to_cashier_shift_schedules.updated_at)
                    .setString("updated_by", to_cashier_shift_schedules.updated_by)
                    .setString("cashier_id", to_cashier_shift_schedules.cashier_id)
                    .setString("cashier_name", to_cashier_shift_schedules.cashier_name)
                    .setNumber("cashier_shift_id", to_cashier_shift_schedules.cashier_shift_id)
                    .setString("cashier_shift", to_cashier_shift_schedules.cashier_shift)
                    .setNumber("status", to_cashier_shift_schedules.status)
                    .setNumber("is_uploaded", to_cashier_shift_schedules.is_uploaded)
                    .ok();

            stmt.addBatch(s0);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Cashier_shift_schedules.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_cashier_shift_schedules to_cashier_shift_schedules) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cashier_shift_schedules set "
                    + "created_at= :created_at "
                    + ",created_by= :created_by "
                    + ",updated_at= :updated_at "
                    + ",updated_by= :updated_by "
                    + ",cashier_id= :cashier_id "
                    + ",cashier_name= :cashier_name "
                    + ",cashier_shift_id= :cashier_shift_id "
                    + ",cashier_shift= :cashier_shift "
                    + ",status= :status "
                    + ",is_uploaded= :is_uploaded "
                    + " where id='" + to_cashier_shift_schedules.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("created_at", to_cashier_shift_schedules.created_at)
                    .setString("created_by", to_cashier_shift_schedules.created_by)
                    .setString("updated_at", to_cashier_shift_schedules.updated_at)
                    .setString("updated_by", to_cashier_shift_schedules.updated_by)
                    .setString("cashier_id", to_cashier_shift_schedules.cashier_id)
                    .setString("cashier_name", to_cashier_shift_schedules.cashier_name)
                    .setNumber("cashier_shift_id", to_cashier_shift_schedules.cashier_shift_id)
                    .setString("cashier_shift", to_cashier_shift_schedules.cashier_shift)
                    .setNumber("status", to_cashier_shift_schedules.status)
                    .setNumber("is_uploaded", to_cashier_shift_schedules.is_uploaded)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Cashier_shift_schedules.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_status(Cashier_shift_schedules.shift_cashiers to_cashier_shift_schedules) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cashier_shift_schedules set "
                    + "status= :status "
                    + " where id='" + to_cashier_shift_schedules.id + "' "
                    + " ";
          
            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 0)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Cashier_shift_schedules.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cashier_shift_schedules to_cashier_shift_schedules) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cashier_shift_schedules  "
                    + " where id='" + to_cashier_shift_schedules.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Cashier_shift_schedules.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cashier_shift_schedules> ret_data(String where) {
        List<to_cashier_shift_schedules> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",created_at"
                    + ",created_by"
                    + ",updated_at"
                    + ",updated_by"
                    + ",cashier_id"
                    + ",cashier_name"
                    + ",cashier_shift_id"
                    + ",cashier_shift"
                    + ",status"
                    + ",is_uploaded"
                    + " from cashier_shift_schedules"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String created_at = rs.getString(2);
                String created_by = rs.getString(3);
                String updated_at = rs.getString(4);
                String updated_by = rs.getString(5);
                String cashier_id = rs.getString(6);
                String cashier_name = rs.getString(7);
                int cashier_shift_id = rs.getInt(8);
                String cashier_shift = rs.getString(9);
                int status = rs.getInt(10);
                int is_uploaded = rs.getInt(11);

                to_cashier_shift_schedules to = new to_cashier_shift_schedules(id, created_at, created_by, updated_at, updated_by, cashier_id, cashier_name, cashier_shift_id, cashier_shift, status, is_uploaded);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<shift_cashiers> ret_shift_schedules(String where) {
        List<shift_cashiers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "u.id"
                    + ",u.screen_name"
                    + ",u.user_name"
                    + ",u.password"
                    + ",u.user_level"
                    + ",u.date_added"
                    + ",u.is_active"
                    + " from users u "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id2 = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);

                String s2 = "select "
                        + "id"
                        + ",created_at"
                        + ",created_by"
                        + ",updated_at"
                        + ",updated_by"
                        + ",cashier_id"
                        + ",cashier_name"
                        + ",cashier_shift_id"
                        + ",cashier_shift"
                        + ",status"
                        + ",is_uploaded"
                        + " from cashier_shift_schedules"
                        + " where cashier_id='" + id2 + "' and status=1 ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                int id = 0;
                boolean selected = false;
                String shift="";
                if (rs2.next()) {
                    id = rs2.getInt(1);
                    String created_at = rs2.getString(2);
                    String created_by = rs2.getString(3);
                    String updated_at = rs2.getString(4);
                    String updated_by = rs2.getString(5);
                    String cashier_id = rs2.getString(6);
                    String cashier_name = rs2.getString(7);
                    int cashier_shift_id = rs2.getInt(8);
                    String cashier_shift = rs2.getString(9);
                    shift=cashier_shift;
                    int status = rs2.getInt(10);
                    int is_uploaded = rs2.getInt(11);
                    selected = true;
                }

                String cashier_id = "" + id2;
                String cashier_user_name = user_name;
                String cashier_screen_name = screen_name;
                shift_cashiers s = new shift_cashiers(id, cashier_id, cashier_user_name, cashier_screen_name, selected,shift);
                datas.add(s);
            }

            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
