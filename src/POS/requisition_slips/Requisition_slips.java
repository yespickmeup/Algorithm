/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.requisition_slips;

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
public class Requisition_slips {

    public static class to_requisition_slips {

        public final int id;
        public final String requisition_slip_no;
        public final String requisition_date;
        public final String requisition_type;
        public final String requisition_department;
        public final String requisition_department_id;
        public final String requested_by;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String date_added;
        public final int status;
        
        public to_requisition_slips(int id, String requisition_slip_no, String requisition_date, String requisition_type, String requisition_department, String requisition_department_id, String requested_by, String branch, String branch_id, String location, String location_id, String date_added, int status) {
            this.id = id;
            this.requisition_slip_no = requisition_slip_no;
            this.requisition_date = requisition_date;
            this.requisition_type = requisition_type;
            this.requisition_department = requisition_department;
            this.requisition_department_id = requisition_department_id;
            this.requested_by = requested_by;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.date_added = date_added;
            this.status = status;
        }
    }

    public static void add_data(to_requisition_slips to_requisition_slips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into requisition_slips("
                    + "requisition_slip_no"
                    + ",requisition_date"
                    + ",requisition_type"
                    + ",requisition_department"
                    + ",requisition_department_id"
                    + ",requested_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",date_added"
                    + ",status"
                    + ")values("
                    + ":requisition_slip_no"
                    + ",:requisition_date"
                    + ",:requisition_type"
                    + ",:requisition_department"
                    + ",:requisition_department_id"
                    + ",:requested_by"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:date_added"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("requisition_slip_no", to_requisition_slips.requisition_slip_no)
                    .setString("requisition_date", to_requisition_slips.requisition_date)
                    .setString("requisition_type", to_requisition_slips.requisition_type)
                    .setString("requisition_department", to_requisition_slips.requisition_department)
                    .setString("requisition_department_id", to_requisition_slips.requisition_department_id)
                    .setString("requested_by", to_requisition_slips.requested_by)
                    .setString("branch", to_requisition_slips.branch)
                    .setString("branch_id", to_requisition_slips.branch_id)
                    .setString("location", to_requisition_slips.location)
                    .setString("location_id", to_requisition_slips.location_id)
                    .setString("date_added", to_requisition_slips.date_added)
                    .setNumber("status", to_requisition_slips.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Requisition_slips.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_requisition_slips to_requisition_slips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update requisition_slips set "
                    + "requisition_slip_no= :requisition_slip_no "
                    + ",requisition_date= :requisition_date "
                    + ",requisition_type= :requisition_type "
                    + ",requisition_department= :requisition_department "
                    + ",requisition_department_id= :requisition_department_id "
                    + ",requested_by= :requested_by "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",date_added= :date_added "
                    + ",status= :status "
                    + " where id='" + to_requisition_slips.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("requisition_slip_no", to_requisition_slips.requisition_slip_no)
                    .setString("requisition_date", to_requisition_slips.requisition_date)
                    .setString("requisition_type", to_requisition_slips.requisition_type)
                    .setString("requisition_department", to_requisition_slips.requisition_department)
                    .setString("requisition_department_id", to_requisition_slips.requisition_department_id)
                    .setString("requested_by", to_requisition_slips.requested_by)
                    .setString("branch", to_requisition_slips.branch)
                    .setString("branch_id", to_requisition_slips.branch_id)
                    .setString("location", to_requisition_slips.location)
                    .setString("location_id", to_requisition_slips.location_id)
                    .setString("date_added", to_requisition_slips.date_added)
                    .setNumber("status", to_requisition_slips.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Requisition_slips.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_requisition_slips to_requisition_slips) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from requisition_slips  "
                    + " where id='" + to_requisition_slips.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Requisition_slips.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_requisition_slips> ret_data(String where) {
        List<to_requisition_slips> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",requisition_slip_no"
                    + ",requisition_date"
                    + ",requisition_type"
                    + ",requisition_department"
                    + ",requisition_department_id"
                    + ",requested_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",date_added"
                    + ",status"
                    + " from requisition_slips"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String requisition_slip_no = rs.getString(2);
                String requisition_date = rs.getString(3);
                String requisition_type = rs.getString(4);
                String requisition_department = rs.getString(5);
                String requisition_department_id = rs.getString(6);
                String requested_by = rs.getString(7);
                String branch = rs.getString(8);
                String branch_id = rs.getString(9);
                String location = rs.getString(10);
                String location_id = rs.getString(11);
                String date_added = rs.getString(12);
                int status = rs.getInt(13);

                to_requisition_slips to = new to_requisition_slips(id, requisition_slip_no, requisition_date, requisition_type, requisition_department, requisition_department_id, requested_by, branch, branch_id, location, location_id, date_added, status);
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
