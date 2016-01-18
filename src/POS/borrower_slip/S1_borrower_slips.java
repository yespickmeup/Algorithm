/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.borrower_slip;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_borrower_slips {

    public static class to_borrower_slips {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String bs_no;
        public final String reference_no;
        public final double items_borrowed;
        public final double items_returned;
        public final String borrowed_by;
        public final String borrowed_by_id;
        public final String borrowed_by_department;
        public final String borrowed_by_department_id;
        public final int status;
        public final String from_branch;
        public final String from_branch_id;
        public final String from_location;
        public final String from_location_id;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public final String remarks;

        public to_borrower_slips(int id, String user_id, String user_screen_name, String date_added, String bs_no, String reference_no, double items_borrowed, double items_returned, String borrowed_by, String borrowed_by_id, String borrowed_by_department, String borrowed_by_department_id, int status, String from_branch, String from_branch_id, String from_location, String from_location_id, String to_branch, String to_branch_id, String to_location, String to_location_id, String remarks) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.bs_no = bs_no;
            this.reference_no = reference_no;
            this.items_borrowed = items_borrowed;
            this.items_returned = items_returned;
            this.borrowed_by = borrowed_by;
            this.borrowed_by_id = borrowed_by_id;
            this.borrowed_by_department = borrowed_by_department;
            this.borrowed_by_department_id = borrowed_by_department_id;
            this.status = status;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.remarks = remarks;
        }
    }

    public static void add_data(to_borrower_slips to_borrower_slips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into borrower_slips("
                    + "user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",bs_no"
                    + ",reference_no"
                    + ",items_borrowed"
                    + ",items_returned"
                    + ",borrowed_by"
                    + ",borrowed_by_id"
                    + ",borrowed_by_department"
                    + ",borrowed_by_department_id"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",remarks"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:bs_no"
                    + ",:reference_no"
                    + ",:items_borrowed"
                    + ",:items_returned"
                    + ",:borrowed_by"
                    + ",:borrowed_by_id"
                    + ",:borrowed_by_department"
                    + ",:borrowed_by_department_id"
                    + ",:status"
                    + ",:from_branch"
                    + ",:from_branch_id"
                    + ",:from_location"
                    + ",:from_location_id"
                    + ",:to_branch"
                    + ",:to_branch_id"
                    + ",:to_location"
                    + ",:to_location_id"
                    + ",:remarks"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_borrower_slips.user_id)
                    .setString("user_screen_name", to_borrower_slips.user_screen_name)
                    .setString("date_added", to_borrower_slips.date_added)
                    .setString("bs_no", to_borrower_slips.bs_no)
                    .setString("reference_no", to_borrower_slips.reference_no)
                    .setNumber("items_borrowed", to_borrower_slips.items_borrowed)
                    .setNumber("items_returned", to_borrower_slips.items_returned)
                    .setString("borrowed_by", to_borrower_slips.borrowed_by)
                    .setString("borrowed_by_id", to_borrower_slips.borrowed_by_id)
                    .setString("borrowed_by_department", to_borrower_slips.borrowed_by_department)
                    .setString("borrowed_by_department_id", to_borrower_slips.borrowed_by_department_id)
                    .setNumber("status", to_borrower_slips.status)
                    .setString("from_branch", to_borrower_slips.from_branch)
                    .setString("from_branch_id", to_borrower_slips.from_branch_id)
                    .setString("from_location", to_borrower_slips.from_location)
                    .setString("from_location_id", to_borrower_slips.from_location_id)
                    .setString("to_branch", to_borrower_slips.to_branch)
                    .setString("to_branch_id", to_borrower_slips.to_branch_id)
                    .setString("to_location", to_borrower_slips.to_location)
                    .setString("to_location_id", to_borrower_slips.to_location_id)
                    .setString("remarks", to_borrower_slips.remarks)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_borrower_slips.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_borrower_slips to_borrower_slips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update borrower_slips set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",date_added= :date_added "
                    + ",bs_no= :bs_no "
                    + ",reference_no= :reference_no "
                    + ",items_borrowed= :items_borrowed "
                    + ",items_returned= :items_returned "
                    + ",borrowed_by= :borrowed_by "
                    + ",borrowed_by_id= :borrowed_by_id "
                    + ",borrowed_by_department= :borrowed_by_department "
                    + ",borrowed_by_department_id= :borrowed_by_department_id "
                    + ",status= :status "
                    + ",from_branch= :from_branch "
                    + ",from_branch_id= :from_branch_id "
                    + ",from_location= :from_location "
                    + ",from_location_id= :from_location_id "
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + ",remarks= :remarks "
                    + " where id='" + to_borrower_slips.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_borrower_slips.user_id)
                    .setString("user_screen_name", to_borrower_slips.user_screen_name)
                    .setString("date_added", to_borrower_slips.date_added)
                    .setString("bs_no", to_borrower_slips.bs_no)
                    .setString("reference_no", to_borrower_slips.reference_no)
                    .setNumber("items_borrowed", to_borrower_slips.items_borrowed)
                    .setNumber("items_returned", to_borrower_slips.items_returned)
                    .setString("borrowed_by", to_borrower_slips.borrowed_by)
                    .setString("borrowed_by_id", to_borrower_slips.borrowed_by_id)
                    .setString("borrowed_by_department", to_borrower_slips.borrowed_by_department)
                    .setString("borrowed_by_department_id", to_borrower_slips.borrowed_by_department_id)
                    .setNumber("status", to_borrower_slips.status)
                    .setString("from_branch", to_borrower_slips.from_branch)
                    .setString("from_branch_id", to_borrower_slips.from_branch_id)
                    .setString("from_location", to_borrower_slips.from_location)
                    .setString("from_location_id", to_borrower_slips.from_location_id)
                    .setString("to_branch", to_borrower_slips.to_branch)
                    .setString("to_branch_id", to_borrower_slips.to_branch_id)
                    .setString("to_location", to_borrower_slips.to_location)
                    .setString("to_location_id", to_borrower_slips.to_location_id)
                    .setString("remarks", to_borrower_slips.remarks)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_borrower_slips.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_borrower_slips to_borrower_slips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from borrower_slips  "
                    + " where id='" + to_borrower_slips.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_borrower_slips.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_borrower_slips> ret_data(String where) {
        List<to_borrower_slips> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",bs_no"
                    + ",reference_no"
                    + ",items_borrowed"
                    + ",items_returned"
                    + ",borrowed_by"
                    + ",borrowed_by_id"
                    + ",borrowed_by_department"
                    + ",borrowed_by_department_id"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",remarks"
                    + " from borrower_slips"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String bs_no = rs.getString(5);
                String reference_no = rs.getString(6);
                double items_borrowed = rs.getDouble(7);
                double items_returned = rs.getDouble(8);
                String borrowed_by = rs.getString(9);
                String borrowed_by_id = rs.getString(10);
                String borrowed_by_department = rs.getString(11);
                String borrowed_by_department_id = rs.getString(12);
                int status = rs.getInt(13);
                String from_branch = rs.getString(14);
                String from_branch_id = rs.getString(15);
                String from_location = rs.getString(16);
                String from_location_id = rs.getString(17);
                String to_branch = rs.getString(18);
                String to_branch_id = rs.getString(19);
                String to_location = rs.getString(20);
                String to_location_id = rs.getString(21);
                String remarks = rs.getString(22);

                to_borrower_slips to = new to_borrower_slips(id, user_id, user_screen_name, date_added, bs_no, reference_no, items_borrowed, items_returned, borrowed_by, borrowed_by_id, borrowed_by_department, borrowed_by_department_id, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, remarks);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from borrower_slips";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select bs_no from borrower_slips where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
