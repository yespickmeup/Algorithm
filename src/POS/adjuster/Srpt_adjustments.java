/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Srpt_adjustments {

    public final String business_name;
    public final String address;
    public final String date;
    public final String branch;
    public final String location;
    public final List<field> fields;

    public Srpt_adjustments(String business_name, String address, String date, String branch, String location) {
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.fields = new ArrayList();
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String unit;
        double previous_qty;
        double new_qty;
        String is_add;
        double total_qty;
        String date_added;
        String branch;
        String branch_id;
        String location;
        String location_id;
        String remarks;

        public field() {
        }

        public field(String item_code, String barcode, String description, String unit, double previous_qty, double new_qty, String is_add, double total_qty, String date_added, String branch, String branch_id, String location, String location_id, String remarks) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.previous_qty = previous_qty;
            this.new_qty = new_qty;
            this.is_add = is_add;
            this.total_qty = total_qty;
            this.date_added = date_added;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.remarks = remarks;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getPrevious_qty() {
            return previous_qty;
        }

        public void setPrevious_qty(double previous_qty) {
            this.previous_qty = previous_qty;
        }

        public double getNew_qty() {
            return new_qty;
        }

        public void setNew_qty(double new_qty) {
            this.new_qty = new_qty;
        }

        public String getIs_add() {
            return is_add;
        }

        public void setIs_add(String is_add) {
            this.is_add = is_add;
        }

        public double getTotal_qty() {
            return total_qty;
        }

        public void setTotal_qty(double total_qty) {
            this.total_qty = total_qty;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(String branch_id) {
            this.branch_id = branch_id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static List<Srpt_adjustments.field> ret_data(String where) {
        List<Srpt_adjustments.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",new_qty"
                    + ",is_add"
                    + ",date_added"
                    + ",status"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",remarks"
                    + ",transaction_no"
                    + " from adjustments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                double qty = rs.getDouble(5);
                double new_qty = rs.getDouble(6);
                int is_add = rs.getInt(7);
                String date_added = rs.getString(8);
                int status = rs.getInt(9);
                String user_id = rs.getString(10);
                String user_screen_name = rs.getString(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location = rs.getString(14);
                String location_id = rs.getString(15);
                String remarks = rs.getString(16);
                String transaction_no = rs.getString(17);

                String unit = "";
                double previous_qty = qty;

                String is_add1 = "+ " + FitIn.fmt_wc(new_qty);

                double total_qty = previous_qty + new_qty;
                if (is_add == 0) {
                    is_add1 = "- " + FitIn.fmt_wc(new_qty);
                    total_qty = previous_qty - new_qty;
                }
                date_added = DateType.convert_jan_1_2013_sf(date_added);

                Srpt_adjustments.field field = new field(item_code, barcode, description, unit, previous_qty, new_qty, is_add1, total_qty, date_added, branch, branch_id, location, location_id, remarks);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
