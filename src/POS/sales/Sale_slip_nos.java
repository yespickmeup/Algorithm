/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

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
 * @author User
 */
public class Sale_slip_nos {

    public static class to_sale_slip_nos {

        public final int id;
        public final String sales_no;
        public final String transaction_no;
        public final String slip_no;
        public final int no_of_items;
        public final String created_at;
        public final String created_by;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String department;
        public final int department_id;

        public to_sale_slip_nos(int id, String sales_no, String transaction_no, String slip_no, int no_of_items, String created_at, String created_by, String branch, String branch_id, String location, String location_id, String department, int department_id) {
            this.id = id;
            this.sales_no = sales_no;
            this.transaction_no = transaction_no;
            this.slip_no = slip_no;
            this.no_of_items = no_of_items;
            this.created_at = created_at;
            this.created_by = created_by;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.department = department;
            this.department_id = department_id;
        }
    }

    public static void add_data(to_sale_slip_nos to_sale_slip_nos) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sale_slip_nos("
                    + "sales_no"
                    + ",transaction_no"
                    + ",slip_no"
                    + ",no_of_items"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",department"
                    + ",department_id"
                    + ")values("
                    + ":sales_no"
                    + ",:transaction_no"
                    + ",:slip_no"
                    + ",:no_of_items"
                    + ",:created_at"
                    + ",:created_by"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:department"
                    + ",:department_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sale_slip_nos.sales_no)
                    .setString("transaction_no", to_sale_slip_nos.transaction_no)
                    .setString("slip_no", to_sale_slip_nos.slip_no)
                    .setNumber("no_of_items", to_sale_slip_nos.no_of_items)
                    .setString("created_at", to_sale_slip_nos.created_at)
                    .setString("created_by", to_sale_slip_nos.created_by)
                    .setString("branch", to_sale_slip_nos.branch)
                    .setString("branch_id", to_sale_slip_nos.branch_id)
                    .setString("location", to_sale_slip_nos.location)
                    .setString("location_id", to_sale_slip_nos.location_id)
                    .setString("department", to_sale_slip_nos.department)
                    .setNumber("department_id", to_sale_slip_nos.department_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_slip_nos.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_sale_slip_nos to_sale_slip_nos) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sale_slip_nos set "
                    + "sales_no= :sales_no "
                    + ",transaction_no= :transaction_no "
                    + ",slip_no= :slip_no "
                    + ",no_of_items= :no_of_items "
                    + ",created_at= :created_at "
                    + ",created_by= :created_by "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",department= :department "
                    + ",department_id= :department_id "
                    + " where id='" + to_sale_slip_nos.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sale_slip_nos.sales_no)
                    .setString("transaction_no", to_sale_slip_nos.transaction_no)
                    .setString("slip_no", to_sale_slip_nos.slip_no)
                    .setNumber("no_of_items", to_sale_slip_nos.no_of_items)
                    .setString("created_at", to_sale_slip_nos.created_at)
                    .setString("created_by", to_sale_slip_nos.created_by)
                    .setString("branch", to_sale_slip_nos.branch)
                    .setString("branch_id", to_sale_slip_nos.branch_id)
                    .setString("location", to_sale_slip_nos.location)
                    .setString("location_id", to_sale_slip_nos.location_id)
                    .setString("department", to_sale_slip_nos.department)
                    .setNumber("department_id", to_sale_slip_nos.department_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_slip_nos.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_sale_slip_nos to_sale_slip_nos) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sale_slip_nos  "
                    + " where id='" + to_sale_slip_nos.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_slip_nos.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sale_slip_nos> ret_data(String where) {
        List<to_sale_slip_nos> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",transaction_no"
                    + ",slip_no"
                    + ",no_of_items"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",department"
                    + ",department_id"
                    + " from sale_slip_nos"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String transaction_no = rs.getString(3);
                String slip_no = rs.getString(4);
                int no_of_items = rs.getInt(5);
                String created_at = rs.getString(6);
                String created_by = rs.getString(7);
                String branch = rs.getString(8);
                String branch_id = rs.getString(9);
                String location = rs.getString(10);
                String location_id = rs.getString(11);
                String department = rs.getString(12);
                int department_id = rs.getInt(13);
                to_sale_slip_nos to = new to_sale_slip_nos(id, sales_no, transaction_no, slip_no, no_of_items, created_at, created_by, branch, branch_id, location, location_id, department, department_id);
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
