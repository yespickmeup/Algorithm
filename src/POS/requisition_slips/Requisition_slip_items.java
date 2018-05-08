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
public class Requisition_slip_items {

    public static class to_requisition_slip_items {

        public final int id;
        public final String requisition_slip_no;
        public final String requisition_date;
        public final String requisition_type;
        public final String requisition_department;
        public final String requisition_department_id;
        public final String requested_by;
        public final String item_code;
        public final String barcode;
        public final String description;
        public double product_qty;
        public final String unit;
        public final double cost;
        public final double selling_price;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String date_added;
        public final int status;

        public to_requisition_slip_items(int id, String requisition_slip_no, String requisition_date, String requisition_type, String requisition_department, String requisition_department_id, String requested_by, String item_code, String barcode, String description, double product_qty, String unit, double cost, double selling_price, String branch, String branch_id, String location, String location_id, String date_added, int status) {
            this.id = id;
            this.requisition_slip_no = requisition_slip_no;
            this.requisition_date = requisition_date;
            this.requisition_type = requisition_type;
            this.requisition_department = requisition_department;
            this.requisition_department_id = requisition_department_id;
            this.requested_by = requested_by;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.product_qty = product_qty;
            this.unit = unit;
            this.cost = cost;
            this.selling_price = selling_price;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.date_added = date_added;
            this.status = status;
        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

    }

    public static void add_data(to_requisition_slip_items to_requisition_slip_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into requisition_slip_items("
                    + "requisition_slip_no"
                    + ",requisition_date"
                    + ",requisition_type"
                    + ",requisition_department"
                    + ",requisition_department_id"
                    + ",requested_by"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",product_qty"
                    + ",unit"
                    + ",cost"
                    + ",selling_price"
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
                    + ",:item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:product_qty"
                    + ",:unit"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:date_added"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("requisition_slip_no", to_requisition_slip_items.requisition_slip_no)
                    .setString("requisition_date", to_requisition_slip_items.requisition_date)
                    .setString("requisition_type", to_requisition_slip_items.requisition_type)
                    .setString("requisition_department", to_requisition_slip_items.requisition_department)
                    .setString("requisition_department_id", to_requisition_slip_items.requisition_department_id)
                    .setString("requested_by", to_requisition_slip_items.requested_by)
                    .setString("item_code", to_requisition_slip_items.item_code)
                    .setString("barcode", to_requisition_slip_items.barcode)
                    .setString("description", to_requisition_slip_items.description)
                    .setNumber("product_qty", to_requisition_slip_items.product_qty)
                    .setString("unit", to_requisition_slip_items.unit)
                    .setNumber("cost", to_requisition_slip_items.cost)
                    .setNumber("selling_price", to_requisition_slip_items.selling_price)
                    .setString("branch", to_requisition_slip_items.branch)
                    .setString("branch_id", to_requisition_slip_items.branch_id)
                    .setString("location", to_requisition_slip_items.location)
                    .setString("location_id", to_requisition_slip_items.location_id)
                    .setString("date_added", to_requisition_slip_items.date_added)
                    .setNumber("status", to_requisition_slip_items.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Requisition_slip_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_requisition_slip_items to_requisition_slip_items) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into requisition_slip_items("
                    + "requisition_slip_no"
                    + ",requisition_date"
                    + ",requisition_type"
                    + ",requisition_department"
                    + ",requisition_department_id"
                    + ",requested_by"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",product_qty"
                    + ",unit"
                    + ",cost"
                    + ",selling_price"
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
                    + ",:item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:product_qty"
                    + ",:unit"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:date_added"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("requisition_slip_no", to_requisition_slip_items.requisition_slip_no)
                    .setString("requisition_date", to_requisition_slip_items.requisition_date)
                    .setString("requisition_type", to_requisition_slip_items.requisition_type)
                    .setString("requisition_department", to_requisition_slip_items.requisition_department)
                    .setString("requisition_department_id", to_requisition_slip_items.requisition_department_id)
                    .setString("requested_by", to_requisition_slip_items.requested_by)
                    .setString("item_code", to_requisition_slip_items.item_code)
                    .setString("barcode", to_requisition_slip_items.barcode)
                    .setString("description", to_requisition_slip_items.description)
                    .setNumber("product_qty", to_requisition_slip_items.product_qty)
                    .setString("unit", to_requisition_slip_items.unit)
                    .setNumber("cost", to_requisition_slip_items.cost)
                    .setNumber("selling_price", to_requisition_slip_items.selling_price)
                    .setString("branch", to_requisition_slip_items.branch)
                    .setString("branch_id", to_requisition_slip_items.branch_id)
                    .setString("location", to_requisition_slip_items.location)
                    .setString("location_id", to_requisition_slip_items.location_id)
                    .setString("date_added", to_requisition_slip_items.date_added)
                    .setNumber("status", to_requisition_slip_items.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update requisition_slip_items set is_uploaded=1 where id='" + to_requisition_slip_items.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Requisition_slip_items.class, "Successfully Added: " + to_requisition_slip_items.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_requisition_slip_items to_requisition_slip_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update requisition_slip_items set "
                    + "requisition_slip_no= :requisition_slip_no "
                    + ",requisition_date= :requisition_date "
                    + ",requisition_type= :requisition_type "
                    + ",requisition_department= :requisition_department "
                    + ",requisition_department_id= :requisition_department_id "
                    + ",requested_by= :requested_by "
                    + ",item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",cost= :cost "
                    + ",selling_price= :selling_price "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",date_added= :date_added "
                    + ",status= :status "
                    + " where id='" + to_requisition_slip_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("requisition_slip_no", to_requisition_slip_items.requisition_slip_no)
                    .setString("requisition_date", to_requisition_slip_items.requisition_date)
                    .setString("requisition_type", to_requisition_slip_items.requisition_type)
                    .setString("requisition_department", to_requisition_slip_items.requisition_department)
                    .setString("requisition_department_id", to_requisition_slip_items.requisition_department_id)
                    .setString("requested_by", to_requisition_slip_items.requested_by)
                    .setString("item_code", to_requisition_slip_items.item_code)
                    .setString("barcode", to_requisition_slip_items.barcode)
                    .setString("description", to_requisition_slip_items.description)
                    .setNumber("product_qty", to_requisition_slip_items.product_qty)
                    .setString("unit", to_requisition_slip_items.unit)
                    .setNumber("cost", to_requisition_slip_items.cost)
                    .setNumber("selling_price", to_requisition_slip_items.selling_price)
                    .setString("branch", to_requisition_slip_items.branch)
                    .setString("branch_id", to_requisition_slip_items.branch_id)
                    .setString("location", to_requisition_slip_items.location)
                    .setString("location_id", to_requisition_slip_items.location_id)
                    .setString("date_added", to_requisition_slip_items.date_added)
                    .setNumber("status", to_requisition_slip_items.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Requisition_slip_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_requisition_slip_items to_requisition_slip_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from requisition_slip_items  "
                    + " where id='" + to_requisition_slip_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg
                    .s(Requisition_slip_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_requisition_slip_items> ret_data(String where) {
        List<to_requisition_slip_items> datas = new ArrayList();

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
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",product_qty"
                    + ",unit"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",date_added"
                    + ",status"
                    + " from requisition_slip_items"
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
                String item_code = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double cost = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String branch = rs.getString(15);
                String branch_id = rs.getString(16);
                String location = rs.getString(17);
                String location_id = rs.getString(18);
                String date_added = rs.getString(19);
                int status = rs.getInt(20);

                to_requisition_slip_items to = new to_requisition_slip_items(id, requisition_slip_no, requisition_date, requisition_type, requisition_department, requisition_department_id, requested_by, item_code, barcode, description, product_qty, unit, cost, selling_price, branch, branch_id, location, location_id, date_added, status);
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
