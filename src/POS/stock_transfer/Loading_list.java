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
public class Loading_list {

    public static class to_loading_list {

        public final int id;
        public final String loading_list_no;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String stock_transfer_nos;
        public final String remarks;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String vehicle;
        public final String driver;

        public to_loading_list(int id, String loading_list_no, String user_id, String user_screen_name, String date_added, String stock_transfer_nos, String remarks, int status, String branch, String branch_id, String location, String location_id, String vehicle, String driver) {
            this.id = id;
            this.loading_list_no = loading_list_no;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.stock_transfer_nos = stock_transfer_nos;
            this.remarks = remarks;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.vehicle = vehicle;
            this.driver = driver;
        }
    }

    public static void add_data(to_loading_list to_loading_list) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into loading_list("
                    + "loading_list_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",stock_transfer_nos"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",vehicle"
                    + ",driver"
                    + ")values("
                    + ":loading_list_no"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:stock_transfer_nos"
                    + ",:remarks"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:vehicle"
                    + ",:driver"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("loading_list_no", to_loading_list.loading_list_no)
                    .setString("user_id", to_loading_list.user_id)
                    .setString("user_screen_name", to_loading_list.user_screen_name)
                    .setString("date_added", to_loading_list.date_added)
                    .setString("stock_transfer_nos", to_loading_list.stock_transfer_nos)
                    .setString("remarks", to_loading_list.remarks)
                    .setNumber("status", to_loading_list.status)
                    .setString("branch", to_loading_list.branch)
                    .setString("branch_id", to_loading_list.branch_id)
                    .setString("location", to_loading_list.location)
                    .setString("location_id", to_loading_list.location_id)
                    .setString("vehicle", to_loading_list.vehicle)
                    .setString("driver", to_loading_list.driver)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Loading_list.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_loading_list to_loading_list) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update loading_list set "
                    + "loading_list_no= :loading_list_no "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",stock_transfer_nos= :stock_transfer_nos "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",vehicle= :vehicle "
                    + ",driver= :driver "
                    + " where id='" + to_loading_list.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("loading_list_no", to_loading_list.loading_list_no)
                    .setString("user_id", to_loading_list.user_id)
                    .setString("user_screen_name", to_loading_list.user_screen_name)
                    .setString("date_added", to_loading_list.date_added)
                    .setString("stock_transfer_nos", to_loading_list.stock_transfer_nos)
                    .setString("remarks", to_loading_list.remarks)
                    .setNumber("status", to_loading_list.status)
                    .setString("branch", to_loading_list.branch)
                    .setString("branch_id", to_loading_list.branch_id)
                    .setString("location", to_loading_list.location)
                    .setString("location_id", to_loading_list.location_id)
                    .setString("vehicle", to_loading_list.vehicle)
                    .setString("driver", to_loading_list.driver)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Loading_list.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_loading_list to_loading_list) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from loading_list  "
                    + " where id='" + to_loading_list.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Loading_list.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_loading_list> ret_data(String where) {
        List<to_loading_list> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",loading_list_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",stock_transfer_nos"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",vehicle"
                    + ",driver"
                    + " from loading_list"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String loading_list_no = rs.getString(2);
                String user_id = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String date_added = rs.getString(5);
                String stock_transfer_nos = rs.getString(6);
                String remarks = rs.getString(7);
                int status = rs.getInt(8);
                String branch = rs.getString(9);
                String branch_id = rs.getString(10);
                String location = rs.getString(11);
                String location_id = rs.getString(12);
                String vehicle = rs.getString(13);
                String driver = rs.getString(14);

                to_loading_list to = new to_loading_list(id, loading_list_no, user_id, user_screen_name, date_added, stock_transfer_nos, remarks, status, branch, branch_id, location, location_id, vehicle, driver);
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
