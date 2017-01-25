/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

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
public class Return_to_supplier {

    public static class to_return_to_suppliers {

        public final int id;
        public final String return_to_supplier_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supplier_id;
        public final String reference_no;
        public final String remarks;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final double gross_total;
        public final String discount;
        public final double discount_amount;
        public final double discount_rate;

        public to_return_to_suppliers(int id, String return_to_supplier_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String reference_no, String remarks, int status, String branch, String branch_id, String location, String location_id, double gross_total, String discount, double discount_amount, double discount_rate) {
            this.id = id;
            this.return_to_supplier_no = return_to_supplier_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.reference_no = reference_no;
            this.remarks = remarks;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.gross_total = gross_total;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.discount_rate = discount_rate;
        }
    }

    public static void add_data(to_return_to_suppliers to_return_to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into return_to_suppliers("
                    + "return_to_supplier_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",reference_no"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ")values("
                    + ":return_to_supplier_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:reference_no"
                    + ",:remarks"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:gross_total"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:discount_rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("return_to_supplier_no", to_return_to_suppliers.return_to_supplier_no)
                    .setString("user_name", to_return_to_suppliers.user_name)
                    .setString("session_no", to_return_to_suppliers.session_no)
                    .setString("date_added", to_return_to_suppliers.date_added)
                    .setString("supplier", to_return_to_suppliers.supplier)
                    .setString("supplier_id", to_return_to_suppliers.supplier_id)
                    .setString("reference_no", to_return_to_suppliers.reference_no)
                    .setString("remarks", to_return_to_suppliers.remarks)
                    .setNumber("status", to_return_to_suppliers.status)
                    .setString("branch", to_return_to_suppliers.branch)
                    .setString("branch_id", to_return_to_suppliers.branch_id)
                    .setString("location", to_return_to_suppliers.location)
                    .setString("location_id", to_return_to_suppliers.location_id)
                    .setNumber("gross_total", to_return_to_suppliers.gross_total)
                    .setString("discount", to_return_to_suppliers.discount)
                    .setNumber("discount_amount", to_return_to_suppliers.discount_amount)
                    .setNumber("discount_rate", to_return_to_suppliers.discount_rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Return_to_supplier.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_return_to_suppliers to_return_to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update return_to_suppliers set "
                    + "return_to_supplier_no= :return_to_supplier_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",reference_no= :reference_no "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",gross_total= :gross_total "
                    + ",discount= :discount "
                    + ",discount_amount= :discount_amount "
                    + ",discount_rate= :discount_rate "
                    + " where id='" + to_return_to_suppliers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("return_to_supplier_no", to_return_to_suppliers.return_to_supplier_no)
                    .setString("user_name", to_return_to_suppliers.user_name)
                    .setString("session_no", to_return_to_suppliers.session_no)
                    .setString("date_added", to_return_to_suppliers.date_added)
                    .setString("supplier", to_return_to_suppliers.supplier)
                    .setString("supplier_id", to_return_to_suppliers.supplier_id)
                    .setString("reference_no", to_return_to_suppliers.reference_no)
                    .setString("remarks", to_return_to_suppliers.remarks)
                    .setNumber("status", to_return_to_suppliers.status)
                    .setString("branch", to_return_to_suppliers.branch)
                    .setString("branch_id", to_return_to_suppliers.branch_id)
                    .setString("location", to_return_to_suppliers.location)
                    .setString("location_id", to_return_to_suppliers.location_id)
                    .setNumber("gross_total", to_return_to_suppliers.gross_total)
                    .setString("discount", to_return_to_suppliers.discount)
                    .setNumber("discount_amount", to_return_to_suppliers.discount_amount)
                    .setNumber("discount_rate", to_return_to_suppliers.discount_rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Return_to_supplier.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_return_to_suppliers to_return_to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from return_to_suppliers  "
                    + " where id='" + to_return_to_suppliers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Return_to_supplier.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_return_to_suppliers> ret_data(String where) {
        List<to_return_to_suppliers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",return_to_supplier_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",reference_no"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",gross_total"
                    + ",discount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + " from return_to_suppliers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String return_to_supplier_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supplier_id = rs.getString(7);
                String reference_no = rs.getString(8);
                String remarks = rs.getString(9);
                int status = rs.getInt(10);
                String branch = rs.getString(11);
                String branch_id = rs.getString(12);
                String location = rs.getString(13);
                String location_id = rs.getString(14);
                double gross_total = rs.getDouble(15);
                String discount = rs.getString(16);
                double discount_amount = rs.getDouble(17);
                double discount_rate = rs.getDouble(18);

                to_return_to_suppliers to = new to_return_to_suppliers(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, status, branch, branch_id, location, location_id, gross_total, discount, discount_amount, discount_rate);
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
