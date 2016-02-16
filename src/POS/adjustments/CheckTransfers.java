/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.receipts.Stock_transfers_items.to_stock_transfers_items;
import POS.stock_transfer.Stock_transfer_items;
import POS.stock_transfer.Stock_transfers.to_stock_transfers;
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
public class CheckTransfers {

    public static void main(String[] args) {
//        String where = " group by st.transaction_no having count(*) > 1  ";
//        ret_data2(where);

        String where = " where stock_transfer_id='9|1345' ";
        ret_data3(where);
    }

    public static List<to_stock_transfers_items> ret_data3(String where) {
        List<to_stock_transfers_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.development();
            Connection conn2 = MyConnection.production();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",barcodes"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",stock_transfer_id"
                    + ",serial_no"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + " from stock_transfers_items "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                String barcodes = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String stock_transfer_id = rs.getString(37);
                String serial_no = rs.getString(38);
                String to_branch = rs.getString(39);
                String to_branch_id = rs.getString(40);
                String to_location = rs.getString(41);
                String to_location_id = rs.getString(42);
                String at_branch = rs.getString(43);
                String at_branch_id = rs.getString(44);
                String at_location = rs.getString(45);
                String at_location_id = rs.getString(46);

                String s2 = "insert into stock_transfers_items("
                        + "barcode"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",item_type"
                        + ",status"
                        + ",supplier"
                        + ",fixed_price"
                        + ",cost"
                        + ",supplier_id"
                        + ",multi_level_pricing"
                        + ",vatable"
                        + ",reorder_level"
                        + ",markup"
                        + ",barcodes"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",selling_type"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",stock_transfer_id"
                        + ",serial_no"
                        + ",to_branch"
                        + ",to_branch_id"
                        + ",to_location"
                        + ",to_location_id"
                        + ",at_branch"
                        + ",at_branch_id"
                        + ",at_location"
                        + ",at_location_id"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:cost"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:markup"
                        + ",:barcodes"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:stock_transfer_id"
                        + ",:serial_no"
                        + ",:to_branch"
                        + ",:to_branch_id"
                        + ",:to_location"
                        + ",:to_location_id"
                        + ",:at_branch"
                        + ",:at_branch_id"
                        + ",:at_location"
                        + ",:at_location_id"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("barcode", barcode)
                        .setString("description", description)
                        .setString("generic_name", generic_name)
                        .setString("category", category)
                        .setString("category_id", category_id)
                        .setString("classification", classification)
                        .setString("classification_id", classification_id)
                        .setString("sub_classification", sub_classification)
                        .setString("sub_classification_id", sub_classification_id)
                        .setNumber("product_qty", product_qty)
                        .setString("unit", unit)
                        .setNumber("conversion", conversion)
                        .setNumber("selling_price", selling_price)
                        .setString("date_added", date_added)
                        .setString("user_name", user_name)
                        .setString("item_type", item_type)
                        .setNumber("status", status)
                        .setString("supplier", supplier)
                        .setNumber("fixed_price", fixed_price)
                        .setNumber("cost", cost)
                        .setString("supplier_id", supplier_id)
                        .setNumber("multi_level_pricing", multi_level_pricing)
                        .setNumber("vatable", vatable)
                        .setNumber("reorder_level", reorder_level)
                        .setNumber("markup", markup)
                        .setString("barcodes", barcodes)
                        .setString("brand", brand)
                        .setString("brand_id", brand_id)
                        .setString("model", model)
                        .setString("model_id", model_id)
                        .setNumber("selling_type", selling_type)
                        .setString("branch", branch)
                        .setString("branch_code", branch_code)
                        .setString("location", location)
                        .setString("location_id", location_id)
                        .setString("stock_transfer_id", stock_transfer_id)
                        .setString("serial_no", serial_no)
                        .setString("to_branch", to_branch)
                        .setString("to_branch_id", to_branch_id)
                        .setString("to_location", to_location)
                        .setString("to_location_id", to_location_id)
                        .setString("at_branch", at_branch)
                        .setString("at_branch_id", at_branch_id)
                        .setString("at_location", at_location)
                        .setString("at_location_id", at_location_id)
                        .ok();

                PreparedStatement stmt2 = conn2.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Stock_transfer_items.class, "Successfully Added");

                System.out.println(barcode);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers> ret_data2(String where) {
        List<to_stock_transfers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.production();
            Connection conn2 = MyConnection.development();
            String s0 = "select "
                    + " st.id"
                    + ",st.transaction_no"
                    + ",count(*)"
                    + " from stock_transfers st "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);

            System.out.println("Fetching.....");
            int i = 0;
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                int count = rs.getInt(3);

                System.out.println("ID: " + id + " | Trans: " + transaction_no + " = " + " | Count Items: " + count + " ");
                i++;
            }
            System.out.println("Done!");
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers> ret_data(String where) {
        List<to_stock_transfers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            Connection conn2 = MyConnection.development();
            String s0 = "select "
                    + "st.id"
                    + ",st.transaction_no"
                    + ",(select count(id) from stock_transfers_items sti where sti.stock_transfer_id=st.transaction_no)  as count"
                    + " from stock_transfers st "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);

            System.out.println("Fetching.....");
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                int count = rs.getInt(3);

                String s2 = "select "
                        + "st.id"
                        + ",st.transaction_no"
                        + ",(select count(id) from stock_transfers_items sti where sti.stock_transfer_id=st.transaction_no)  as count"
                        + " from stock_transfers st "
                        + " where st.transaction_no='" + transaction_no + "' ";

                Statement stmt2 = conn2.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    String transaction_no2 = rs2.getString(2);
                    int count2 = rs2.getInt(3);
                    if (count != count2) {
                        System.out.println("ID: " + id + " = " + id2 + " | Trans: " + transaction_no + " = " + transaction_no2 + " | Count Items: " + count + " = " + count2);
                    }
                }
            }
            System.out.println("Done!");
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
