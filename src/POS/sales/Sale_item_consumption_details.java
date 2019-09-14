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
 * @author Ronescape
 */
public class Sale_item_consumption_details {

    public static class to_sale_item_consumption_details {

        public final int id;
        public final String consumption_id;
        public final String sales_item_id;
        public final String sales_no;
        public final String ar_no;
        public final String ar_reference_no;
        public final String ar_customer_id;
        public final String ar_customer_name;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final double consumed;
        public final int status;

        public to_sale_item_consumption_details(int id, String consumption_id, String sales_item_id, String sales_no, String ar_no, String ar_reference_no, String ar_customer_id, String ar_customer_name, String created_at, String updated_at, String created_by, String updated_by, String item_code, String barcode, String description, double product_qty, String unit, double conversion, double selling_price, String branch, String branch_id, String location, String location_id, double consumed, int status) {
            this.id = id;
            this.consumption_id = consumption_id;
            this.sales_item_id = sales_item_id;
            this.sales_no = sales_no;
            this.ar_no = ar_no;
            this.ar_reference_no = ar_reference_no;
            this.ar_customer_id = ar_customer_id;
            this.ar_customer_name = ar_customer_name;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.consumed = consumed;
            this.status = status;
        }
    }

    public static void add_data(to_sale_item_consumption_details to_sale_item_consumption_details) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sale_item_consumption_details("
                    + "consumption_id"
                    + ",sales_item_id"
                    + ",sales_no"
                    + ",ar_no"
                    + ",ar_reference_no"
                    + ",ar_customer_id"
                    + ",ar_customer_name"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",consumed"
                    + ",status"
                    + ")values("
                    + ":consumption_id"
                    + ",:sales_item_id"
                    + ",:sales_no"
                    + ",:ar_no"
                    + ",:ar_reference_no"
                    + ",:ar_customer_id"
                    + ",:ar_customer_name"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:product_qty"
                    + ",:unit"
                    + ",:conversion"
                    + ",:selling_price"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:consumed"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("consumption_id", to_sale_item_consumption_details.consumption_id)
                    .setString("sales_item_id", to_sale_item_consumption_details.sales_item_id)
                    .setString("sales_no", to_sale_item_consumption_details.sales_no)
                    .setString("ar_no", to_sale_item_consumption_details.ar_no)
                    .setString("ar_reference_no", to_sale_item_consumption_details.ar_reference_no)
                    .setString("ar_customer_id", to_sale_item_consumption_details.ar_customer_id)
                    .setString("ar_customer_name", to_sale_item_consumption_details.ar_customer_name)
                    .setString("created_at", to_sale_item_consumption_details.created_at)
                    .setString("updated_at", to_sale_item_consumption_details.updated_at)
                    .setString("created_by", to_sale_item_consumption_details.created_by)
                    .setString("updated_by", to_sale_item_consumption_details.updated_by)
                    .setString("item_code", to_sale_item_consumption_details.item_code)
                    .setString("barcode", to_sale_item_consumption_details.barcode)
                    .setString("description", to_sale_item_consumption_details.description)
                    .setNumber("product_qty", to_sale_item_consumption_details.product_qty)
                    .setString("unit", to_sale_item_consumption_details.unit)
                    .setNumber("conversion", to_sale_item_consumption_details.conversion)
                    .setNumber("selling_price", to_sale_item_consumption_details.selling_price)
                    .setString("branch", to_sale_item_consumption_details.branch)
                    .setString("branch_id", to_sale_item_consumption_details.branch_id)
                    .setString("location", to_sale_item_consumption_details.location)
                    .setString("location_id", to_sale_item_consumption_details.location_id)
                    .setNumber("consumed", to_sale_item_consumption_details.consumed)
                    .setNumber("status", to_sale_item_consumption_details.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_item_consumption_details.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_sale_item_consumption_details to_sale_item_consumption_details) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sale_item_consumption_details set "
                    + "consumption_id= :consumption_id "
                    + ",sales_item_id= :sales_item_id "
                    + ",sales_no= :sales_no "
                    + ",ar_no= :ar_no "
                    + ",ar_reference_no= :ar_reference_no "
                    + ",ar_customer_id= :ar_customer_id "
                    + ",ar_customer_name= :ar_customer_name "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",consumed= :consumed "
                    + ",status= :status "
                    + " where id='" + to_sale_item_consumption_details.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("consumption_id", to_sale_item_consumption_details.consumption_id)
                    .setString("sales_item_id", to_sale_item_consumption_details.sales_item_id)
                    .setString("sales_no", to_sale_item_consumption_details.sales_no)
                    .setString("ar_no", to_sale_item_consumption_details.ar_no)
                    .setString("ar_reference_no", to_sale_item_consumption_details.ar_reference_no)
                    .setString("ar_customer_id", to_sale_item_consumption_details.ar_customer_id)
                    .setString("ar_customer_name", to_sale_item_consumption_details.ar_customer_name)
                    .setString("created_at", to_sale_item_consumption_details.created_at)
                    .setString("updated_at", to_sale_item_consumption_details.updated_at)
                    .setString("created_by", to_sale_item_consumption_details.created_by)
                    .setString("updated_by", to_sale_item_consumption_details.updated_by)
                    .setString("item_code", to_sale_item_consumption_details.item_code)
                    .setString("barcode", to_sale_item_consumption_details.barcode)
                    .setString("description", to_sale_item_consumption_details.description)
                    .setNumber("product_qty", to_sale_item_consumption_details.product_qty)
                    .setString("unit", to_sale_item_consumption_details.unit)
                    .setNumber("conversion", to_sale_item_consumption_details.conversion)
                    .setNumber("selling_price", to_sale_item_consumption_details.selling_price)
                    .setString("branch", to_sale_item_consumption_details.branch)
                    .setString("branch_id", to_sale_item_consumption_details.branch_id)
                    .setString("location", to_sale_item_consumption_details.location)
                    .setString("location_id", to_sale_item_consumption_details.location_id)
                    .setNumber("consumed", to_sale_item_consumption_details.consumed)
                    .setNumber("status", to_sale_item_consumption_details.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_item_consumption_details.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_sale_item_consumption_details to_sale_item_consumption_details) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sale_item_consumption_details  "
                    + " where id='" + to_sale_item_consumption_details.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_item_consumption_details.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sale_item_consumption_details> ret_data(String where) {
        List<to_sale_item_consumption_details> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",consumption_id"
                    + ",sales_item_id"
                    + ",sales_no"
                    + ",ar_no"
                    + ",ar_reference_no"
                    + ",ar_customer_id"
                    + ",ar_customer_name"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",consumed"
                    + ",status"
                    + " from sale_item_consumption_details"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String consumption_id = rs.getString(2);
                String sales_item_id = rs.getString(3);
                String sales_no = rs.getString(4);
                String ar_no = rs.getString(5);
                String ar_reference_no = rs.getString(6);
                String ar_customer_id = rs.getString(7);
                String ar_customer_name = rs.getString(8);
                String created_at = rs.getString(9);
                String updated_at = rs.getString(10);
                String created_by = rs.getString(11);
                String updated_by = rs.getString(12);
                String item_code = rs.getString(13);
                String barcode = rs.getString(14);
                String description = rs.getString(15);
                double product_qty = rs.getDouble(16);
                String unit = rs.getString(17);
                double conversion = rs.getDouble(18);
                double selling_price = rs.getDouble(19);
                String branch = rs.getString(20);
                String branch_id = rs.getString(21);
                String location = rs.getString(22);
                String location_id = rs.getString(23);
                double consumed = rs.getDouble(24);
                int status = rs.getInt(25);

                to_sale_item_consumption_details to = new to_sale_item_consumption_details(id, consumption_id, sales_item_id, sales_no, ar_no, ar_reference_no, ar_customer_id, ar_customer_name, created_at, updated_at, created_by, updated_by, item_code, barcode, description, product_qty, unit, conversion, selling_price, branch, branch_id, location, location_id, consumed, status);
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
