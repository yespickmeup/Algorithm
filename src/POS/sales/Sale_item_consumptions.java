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
public class Sale_item_consumptions {

    public static class to_sale_item_consumptions {

        public final int id;
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

        public to_sale_item_consumptions(int id, String sales_item_id, String sales_no, String ar_no, String ar_reference_no, String ar_customer_id, String ar_customer_name, String created_at, String updated_at, String created_by, String updated_by, String item_code, String barcode, String description, double product_qty, String unit, double conversion, double selling_price, String branch, String branch_id, String location, String location_id, double consumed, int status) {
            this.id = id;
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

    public static void add_data(to_sale_item_consumptions to_sale_item_consumptions) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sale_item_consumptions("
                    + "sales_item_id"
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
                    + ":sales_item_id"
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
                    .setString("sales_item_id", to_sale_item_consumptions.sales_item_id)
                    .setString("sales_no", to_sale_item_consumptions.sales_no)
                    .setString("ar_no", to_sale_item_consumptions.ar_no)
                    .setString("ar_reference_no", to_sale_item_consumptions.ar_reference_no)
                    .setString("ar_customer_id", to_sale_item_consumptions.ar_customer_id)
                    .setString("ar_customer_name", to_sale_item_consumptions.ar_customer_name)
                    .setString("created_at", to_sale_item_consumptions.created_at)
                    .setString("updated_at", to_sale_item_consumptions.updated_at)
                    .setString("created_by", to_sale_item_consumptions.created_by)
                    .setString("updated_by", to_sale_item_consumptions.updated_by)
                    .setString("item_code", to_sale_item_consumptions.item_code)
                    .setString("barcode", to_sale_item_consumptions.barcode)
                    .setString("description", to_sale_item_consumptions.description)
                    .setNumber("product_qty", to_sale_item_consumptions.product_qty)
                    .setString("unit", to_sale_item_consumptions.unit)
                    .setNumber("conversion", to_sale_item_consumptions.conversion)
                    .setNumber("selling_price", to_sale_item_consumptions.selling_price)
                    .setString("branch", to_sale_item_consumptions.branch)
                    .setString("branch_id", to_sale_item_consumptions.branch_id)
                    .setString("location", to_sale_item_consumptions.location)
                    .setString("location_id", to_sale_item_consumptions.location_id)
                    .setNumber("consumed", to_sale_item_consumptions.consumed)
                    .setNumber("status", to_sale_item_consumptions.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_item_consumptions.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_sale_item_consumptions to_sale_item_consumptions) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sale_item_consumptions set "
                    + "sales_item_id= :sales_item_id "
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
                    + " where id='" + to_sale_item_consumptions.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_item_id", to_sale_item_consumptions.sales_item_id)
                    .setString("sales_no", to_sale_item_consumptions.sales_no)
                    .setString("ar_no", to_sale_item_consumptions.ar_no)
                    .setString("ar_reference_no", to_sale_item_consumptions.ar_reference_no)
                    .setString("ar_customer_id", to_sale_item_consumptions.ar_customer_id)
                    .setString("ar_customer_name", to_sale_item_consumptions.ar_customer_name)
                    .setString("created_at", to_sale_item_consumptions.created_at)
                    .setString("updated_at", to_sale_item_consumptions.updated_at)
                    .setString("created_by", to_sale_item_consumptions.created_by)
                    .setString("updated_by", to_sale_item_consumptions.updated_by)
                    .setString("item_code", to_sale_item_consumptions.item_code)
                    .setString("barcode", to_sale_item_consumptions.barcode)
                    .setString("description", to_sale_item_consumptions.description)
                    .setNumber("product_qty", to_sale_item_consumptions.product_qty)
                    .setString("unit", to_sale_item_consumptions.unit)
                    .setNumber("conversion", to_sale_item_consumptions.conversion)
                    .setNumber("selling_price", to_sale_item_consumptions.selling_price)
                    .setString("branch", to_sale_item_consumptions.branch)
                    .setString("branch_id", to_sale_item_consumptions.branch_id)
                    .setString("location", to_sale_item_consumptions.location)
                    .setString("location_id", to_sale_item_consumptions.location_id)
                    .setNumber("consumed", to_sale_item_consumptions.consumed)
                    .setNumber("status", to_sale_item_consumptions.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_item_consumptions.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_sale_item_consumptions to_sale_item_consumptions) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sale_item_consumptions  "
                    + " where id='" + to_sale_item_consumptions.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sale_item_consumptions.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sale_item_consumptions> ret_data(String where) {
        List<to_sale_item_consumptions> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
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
                    + " from sale_item_consumptions"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_item_id = rs.getString(2);
                String sales_no = rs.getString(3);
                String ar_no = rs.getString(4);
                String ar_reference_no = rs.getString(5);
                String ar_customer_id = rs.getString(6);
                String ar_customer_name = rs.getString(7);
                String created_at = rs.getString(8);
                String updated_at = rs.getString(9);
                String created_by = rs.getString(10);
                String updated_by = rs.getString(11);
                String item_code = rs.getString(12);
                String barcode = rs.getString(13);
                String description = rs.getString(14);
                double product_qty = rs.getDouble(15);
                String unit = rs.getString(16);
                double conversion = rs.getDouble(17);
                double selling_price = rs.getDouble(18);
                String branch = rs.getString(19);
                String branch_id = rs.getString(20);
                String location = rs.getString(21);
                String location_id = rs.getString(22);
                double consumed = rs.getDouble(23);
                int status = rs.getInt(24);

                to_sale_item_consumptions to = new to_sale_item_consumptions(id, sales_item_id, sales_no, ar_no, ar_reference_no, ar_customer_id, ar_customer_name, created_at, updated_at, created_by, updated_by, item_code, barcode, description, product_qty, unit, conversion, selling_price, branch, branch_id, location, location_id, consumed, status);
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
