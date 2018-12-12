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
public class User_price_change_requests {

    public static class to_user_price_change_requests {

        public final int id;
        public final String user_id;
        public final String user_name;
        public final String created_at;
        public final String updated_at;
        public final String item_code;
        public final String description;
        public final String unit;
        public final double selling_price;
        public final int status;

        public to_user_price_change_requests(int id, String user_id, String user_name, String created_at, String updated_at, String item_code, String description, String unit, double selling_price, int status) {
            this.id = id;
            this.user_id = user_id;
            this.user_name = user_name;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.item_code = item_code;
            this.description = description;
            this.unit = unit;
            this.selling_price = selling_price;
            this.status = status;
        }
    }

    public static void add_data(to_user_price_change_requests to_user_price_change_requests) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into user_price_change_requests("
                    + "user_id"
                    + ",user_name"
                    + ",created_at"
                    + ",updated_at"
                    + ",item_code"
                    + ",description"
                    + ",unit"
                    + ",selling_price"
                    + ",status"
                    + ")values("
                    + ":user_id"
                    + ",:user_name"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:item_code"
                    + ",:description"
                    + ",:unit"
                    + ",:selling_price"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_user_price_change_requests.user_id)
                    .setString("user_name", to_user_price_change_requests.user_name)
                    .setString("created_at", to_user_price_change_requests.created_at)
                    .setString("updated_at", to_user_price_change_requests.updated_at)
                    .setString("item_code", to_user_price_change_requests.item_code)
                    .setString("description", to_user_price_change_requests.description)
                    .setString("unit", to_user_price_change_requests.unit)
                    .setNumber("selling_price", to_user_price_change_requests.selling_price)
                    .setNumber("status", to_user_price_change_requests.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_price_change_requests.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_user_price_change_requests to_user_price_change_requests) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update user_price_change_requests set "
                    + "user_id= :user_id "
                    + ",user_name= :user_name "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",item_code= :item_code "
                    + ",description= :description "
                    + ",unit= :unit "
                    + ",selling_price= :selling_price "
                    + ",status= :status "
                    + " where id='" + to_user_price_change_requests.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_user_price_change_requests.user_id)
                    .setString("user_name", to_user_price_change_requests.user_name)
                    .setString("created_at", to_user_price_change_requests.created_at)
                    .setString("updated_at", to_user_price_change_requests.updated_at)
                    .setString("item_code", to_user_price_change_requests.item_code)
                    .setString("description", to_user_price_change_requests.description)
                    .setString("unit", to_user_price_change_requests.unit)
                    .setNumber("selling_price", to_user_price_change_requests.selling_price)
                    .setNumber("status", to_user_price_change_requests.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_price_change_requests.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_user_price_change_requests to_user_price_change_requests) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from user_price_change_requests  "
                    + " where id='" + to_user_price_change_requests.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_price_change_requests.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_user_price_change_requests> ret_data(String where) {
        List<to_user_price_change_requests> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_name"
                    + ",created_at"
                    + ",updated_at"
                    + ",item_code"
                    + ",description"
                    + ",unit"
                    + ",selling_price"
                    + ",status"
                    + " from user_price_change_requests"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_name = rs.getString(3);
                String created_at = rs.getString(4);
                String updated_at = rs.getString(5);
                String item_code = rs.getString(6);
                String description = rs.getString(7);
                String unit = rs.getString(8);
                double selling_price = rs.getDouble(9);
                int status = rs.getInt(10);

                to_user_price_change_requests to = new to_user_price_change_requests(id, user_id, user_name, created_at, updated_at, item_code, description, unit, selling_price, status);
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
