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
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
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

    public static void add_data(to_requisition_slips to_requisition_slips, List<Requisition_slip_items.to_requisition_slip_items> to_requisition_slip_items1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

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

            stmt.addBatch(s0);

            for (Requisition_slip_items.to_requisition_slip_items to_requisition_slip_items : to_requisition_slip_items1) {
                String s2 = "insert into requisition_slip_items("
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

                s2 = SqlStringUtil.parse(s2)
                        .setString("requisition_slip_no", to_requisition_slips.requisition_slip_no)
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
                stmt.addBatch(s2);
            }
            stmt.executeBatch();
            conn.commit();
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
                    + "requisition_date= :requisition_date "
                    + ",requisition_type= :requisition_type "
                    + ",requisition_department= :requisition_department "
                    + ",requisition_department_id= :requisition_department_id "
                    + ",requested_by= :requested_by "
                    + " where id='" + to_requisition_slips.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("requisition_date", to_requisition_slips.requisition_date)
                    .setString("requisition_type", to_requisition_slips.requisition_type)
                    .setString("requisition_department", to_requisition_slips.requisition_department)
                    .setString("requisition_department_id", to_requisition_slips.requisition_department_id)
                    .setString("requested_by", to_requisition_slips.requested_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update requisition_slip_items set "
                    + "requisition_date= :requisition_date "
                    + ",requisition_type= :requisition_type "
                    + ",requisition_department= :requisition_department "
                    + ",requisition_department_id= :requisition_department_id "
                    + ",requested_by= :requested_by "
                    + " where requisition_slip_no='" + to_requisition_slips.requisition_slip_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("requisition_date", to_requisition_slips.requisition_date)
                    .setString("requisition_type", to_requisition_slips.requisition_type)
                    .setString("requisition_department", to_requisition_slips.requisition_department)
                    .setString("requisition_department_id", to_requisition_slips.requisition_department_id)
                    .setString("requested_by", to_requisition_slips.requested_by)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Lg.s(Requisition_slips.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_data(to_requisition_slips to_requisition_slips, List<Requisition_slip_items.to_requisition_slip_items> datas) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "update requisition_slips set "
                    + "status= :status "
                    + " where id='" + to_requisition_slips.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("status", "1")
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Requisition_slip_items.to_requisition_slip_items to_requisition_slip_items : datas) {
                String s2 = "update requisition_slip_items set "
                        + " status= :status "
                        + " where requisition_slip_no='" + to_requisition_slips.requisition_slip_no + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setString("status", "1")
                        .ok();

                stmt.addBatch(s2);

                //<editor-fold defaultstate="collapsed" desc=" select item ">
                double my_qty = 0;
                String unit = "";
                double conversion = 0;
                String description = "";
                String generic_name = "";
                String category = "";
                String category_id = "";
                String classification = "";
                String classification_id = "";
                String sub_classification = "";
                String sub_classification_id = "";
                String item_type = "";
                String supplier = "";
                int fixed_price = 0;
                String supplier_id = "";
                int multi_level_pricing = 0;
                int vatable = 0;
                double reorder_level = 0;
                double markup = 0;
                String barcode = "";
                String brand = "";
                String brand_id = "";
                String model = "";
                String model_id = "";
                int selling_type = 0;

                String s3 = "select"
                        + " product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",item_type"
                        + ",supplier"
                        + ",fixed_price"
                        + ",supplier_id"
                        + ",multi_level_pricing"
                        + ",vatable"
                        + ",reorder_level"
                        + ",markup"
                        + ",barcode"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",selling_type"
                        + " from inventory_barcodes "
                        + " where "
                        + " main_barcode ='" + to_requisition_slip_items.item_code + "' "
                        + " and location_id ='" + to_requisition_slip_items.location_id + "' "
                        + " ";
                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                if (rs3.next()) {
                    my_qty = rs3.getDouble(1);
                    unit = rs3.getString(2);
                    conversion = rs3.getDouble(3);
                    description = rs3.getString(4);
                    generic_name = rs3.getString(5);
                    category = rs3.getString(6);
                    category_id = rs3.getString(7);
                    classification = rs3.getString(8);
                    classification_id = rs3.getString(9);
                    sub_classification = rs3.getString(10);
                    sub_classification_id = rs3.getString(11);
                    item_type = rs3.getString(12);
                    supplier = rs3.getString(13);
                    fixed_price = rs3.getInt(14);
                    supplier_id = rs3.getString(15);
                    multi_level_pricing = rs3.getInt(16);
                    vatable = rs3.getInt(17);
                    reorder_level = rs3.getInt(18);
                    markup = rs3.getInt(19);
                    barcode = rs3.getString(20);
                    brand = rs3.getString(21);
                    brand_id = rs3.getString(22);
                    model = rs3.getString(23);
                    model_id = rs3.getString(24);
                    selling_type = rs3.getInt(25);

                }

                //</editor-fold>
                
                my_qty = my_qty - to_requisition_slip_items.product_qty;
                String s4 = "update inventory_barcodes set "
                        + " product_qty= :product_qty "
                        + " where "
                        + " main_barcode ='" + to_requisition_slip_items.item_code + "' "
                        + " and location_id ='" + to_requisition_slip_items.location_id + "' "
                        + " ";

                s4 = SqlStringUtil.parse(s4)
                        .setNumber("product_qty", my_qty)
                        .ok();

                stmt.addBatch(s4);

            }
            stmt.executeBatch();
            conn.commit();
            Lg.s(Requisition_slips.class, "Transaction Finalized!");
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

            String s2 = "delete from requisition_slip_items  "
                    + " where requisition_slip_no='" + to_requisition_slips.requisition_slip_no + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

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

    public static void main(String[] args) {
        System.out.println(increment_id("14"));
    }

    public static String increment_id(String location_id) {
        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from requisition_slips where location_id='" + location_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select requisition_slip_no from requisition_slips where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = location_id + "|00000";
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
