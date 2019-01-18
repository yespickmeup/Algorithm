/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cloud;

import POS.inventory.Inventory;
import POS.inventory.Inventory.to_inventory;
import POS.receipts.Stock_transfers_items.to_stock_transfers_items;
import POS.stock_transfer.Stock_transfers.to_stock_transfers;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class Cloud {

    public static class table {

        public String transaction_no;
        public String date;
        public int item_count;
        public int total_qty;
        public boolean selected;

        public table(String transaction_no, String date, int item_count, int total_qty, boolean selected) {
            this.transaction_no = transaction_no;
            this.date = date;
            this.item_count = item_count;
            this.total_qty = total_qty;
            this.selected = selected;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getItem_count() {
            return item_count;
        }

        public void setItem_count(int item_count) {
            this.item_count = item_count;
        }

        public int getTotal_qty() {
            return total_qty;
        }

        public void setTotal_qty(int total_qty) {
            this.total_qty = total_qty;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void main(String[] args) {
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");

        List<to_inventory> inventory_cloud = ret_inventory("");
        List<to_inventory> inventory_local = Inventory.ret_data6("");
        System.out.println("Retrieving record/s...");

        int new_items = 0;
        int items_do_not_match = 0;
        List<String> codes = new ArrayList();
        for (to_inventory to : inventory_local) {
            int exists = 0;
            System.out.println("Item: " + to.barcode + " = " + to.description);
            for (to_inventory to2 : inventory_cloud) {
                if (to.barcode.equals(to2.barcode)) {
                    exists = 1;
                    if (!to.description.equalsIgnoreCase(to2.description)) {
                        items_do_not_match++;
                    }
                    break;
                }
            }
            if (exists == 0) {
                codes.add("" + to.barcode);
                System.out.println("Item not found!" + to.barcode + " | " + to.description);
                new_items++;
            }
        }
        System.out.println("Cloud Size: " + inventory_cloud.size());
        System.out.println("Local Size: " + inventory_local.size());
        System.out.println("New Item/s: " + new_items + " = " + Arrays.asList(codes));
        System.out.println("Does not match: " + items_do_not_match);
    }

    //<editor-fold defaultstate="collapsed" desc=" inventory ">
    public static List<to_inventory> ret_inventory(String where) {
        List<to_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + " from inventory"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int barcode = rs.getInt(2);
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
                int is_uploaded = rs.getInt(37);

                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                to_inventory to = new to_inventory(id, "" + barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, true, is_uploaded,allow_negative_inventory,auto_order);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" stock transfer ">
    public static List<to_stock_transfers> ret_cloud_stock_transfer(String where) {
        List<to_stock_transfers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",user_name"
                    + ",date_added"
                    + ",remarks"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",status"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + ",finalized_by_id"
                    + ",finalized_by"
                    + " from stock_transfers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String user_name = rs.getString(3);
                String date_added = rs.getString(4);
                String remarks = rs.getString(5);
                String to_branch = rs.getString(6);
                String to_branch_id = rs.getString(7);
                String to_location = rs.getString(8);
                String to_location_id = rs.getString(9);
                String from_branch = rs.getString(10);
                String from_branch_id = rs.getString(11);
                String from_location = rs.getString(12);
                String from_location_id = rs.getString(13);
                int status = rs.getInt(14);
                String at_branch = rs.getString(15);
                String at_branch_id = rs.getString(16);
                String at_location = rs.getString(17);
                String at_location_id = rs.getString(18);
                String finalized_by_id = rs.getString(19);
                String finalized_by = rs.getString(20);
                to_stock_transfers to = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, status, false, at_branch, at_branch_id, at_location, at_location_id, 0, finalized_by_id, finalized_by);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers_items> ret_cloud_stock_transfer_items(String where) {
        List<to_stock_transfers_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
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
                    + " from stock_transfers_items"
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

                to_stock_transfers_items to = new to_stock_transfers_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, stock_transfer_id, serial_no, to_branch, to_branch_id, to_location, to_location_id, at_branch, at_branch_id, at_location, at_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    //</editor-fold>
    public static void main2(String[] args) {

    }
}
