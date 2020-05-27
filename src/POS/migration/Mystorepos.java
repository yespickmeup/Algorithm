/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.migration;

import POS.encoding_inventory.Encoding_inventory;
import POS.inventory.Inventory;
import POS.inventory_replenishment.Inventory_replenishment_items;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronescape
 */
public class Mystorepos {

    public static void main(String[] args) {
        System.setProperty("pool_db", "mystorepos");
        List<to_mystorepos_products> products = Mystorepos.ret_products(" order by gen_name asc ");
        
        System.setProperty("pool_db", "db_smis_santillan");
        List<Inventory.to_inventory> tos = new ArrayList();
        int with_qty = 0;
        for (to_mystorepos_products prod : products) {
            if (prod.qty > 0) {
                with_qty++;
            }
            int id = prod.product_id;
            String barcode = "" + prod.product_id;
            String description = prod.gen_name;
            String generic_name = "";
            String category = prod.product_name;
            String classification = "";
            String classification_id = "";
            String sub_classification = "";
            String sub_classification_id = "";
            double product_qty = prod.qty;
            double conversion = 1;
            double selling_price = prod.price;
            String date_added = DateType.now();
            String user_name = "";
            String item_type = "Regular";
            int status = 1;

            String supplier = "";
            int fixed_price = 0;
            double cost = prod.o_price;
            String supplier_id = "";
            int multi_level_pricing = 0;
            int vatable = 0;
            double reorder_level = 0;
            double markup = 0;
            String barcodes = prod.product_code;
            String brand = "";
            String brand_id = "";
            String model = "";
            String model_id = "";
            int selling_type = 1;

            String branch = "Dumaguete City";
            String branch_code = "1";
            String location = "Selling Area";
            String location_id = "1";
            String unit = "[" + "pc" + ":" + prod.price + "/1.0^1]";
//            System.out.println("Unit: "+unit);
            int is_uploaded = 0;

            int allow_negative_inventory = 1;
            int auto_order = 0;
            int show_to_sales = 1;
            String category_id = "";
            Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
            tos.add(to);

            String item_code = barcode;
            String barcode1 = barcodes;

            String branch_id = "1";

            double qty = product_qty;
            String date_added1 = "2020-03-12 14:00:00";

            String screen_name = user_name;
            String sheet_no = "1";
            int status1 = 1;
            String counted_by = screen_name;
            String checked_by = screen_name;
            double cost1 = prod.o_price;
            double selling_price1 = prod.price;
            String user_id = "1";
            String user_screen_name = "";
            String remarks = "";
            Encoding_inventory.to_encoding_inventory encode = new Encoding_inventory.to_encoding_inventory(id, item_code, barcode1, description, branch, branch_id, location, location_id, qty, date_added1, user_name, screen_name, sheet_no, status1, counted_by, checked_by, cost, selling_price, user_id, user_screen_name, remarks);
            Encoding_inventory.add_encoding_inventory(encode);

            //reflenishment
            String inventory_replenishment_no = "0000001";
           
            String date_added2 = "2020-03-12 13:00:00";
            Inventory_replenishment_items.to_inventory_replenishment_items ref=new Inventory_replenishment_items.to_inventory_replenishment_items(id, inventory_replenishment_no, item_code, barcode, description, product_qty, unit, conversion, selling_price, date_added2, user_id, user_screen_name, status, branch, branch_id, location, location_id);
            Inventory_replenishment_items.add_data(ref);

        }

//        List<String> query = Inventory.add_inventory_list(tos);
//        System.out.println("Count: " + tos.size());
    }

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    public static class to_mystorepos_products {

        public final int product_id;
        public final String product_code;
        public final String gen_name;
        public final String product_name;
        public final double cost;
        public final double o_price;
        public final double price;
        public final double profit;
        public final String supplier;
        public final double onhand_qty;
        public final double qty;
        public final double qty_sold;

        public to_mystorepos_products(int product_id, String product_code, String gen_name, String product_name, double cost, double o_price, double price, double profit, String supplier, double onhand_qty, double qty, double qty_sold) {
            this.product_id = product_id;
            this.product_code = product_code;
            this.gen_name = gen_name;
            this.product_name = product_name;
            this.cost = cost;
            this.o_price = o_price;
            this.price = price;
            this.profit = profit;
            this.supplier = supplier;
            this.onhand_qty = onhand_qty;
            this.qty = qty;
            this.qty_sold = qty_sold;
        }

    }

    public static List<to_mystorepos_products> ret_products(String where) {
        List<to_mystorepos_products> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " product_id"
                    + ",product_code"
                    + ",gen_name"
                    + ",product_name"
                    + ",cost"
                    + ",o_price"
                    + ",price"
                    + ",profit"
                    + ",supplier"
                    + ",onhand_qty"
                    + ",qty"
                    + ",qty_sold"
                    + ",product_name"
                    + " from  products  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int product_id = rs.getInt(1);
                String product_code = rs.getString(2);
                String gen_name = rs.getString(3);
                String product_name = rs.getString(4);
                double cost = rs.getDouble(5);
                double o_price = rs.getDouble(6);
                double price = rs.getDouble(7);
                double profit = rs.getDouble(8);
                String supplier = rs.getString(9);
                double onhand_qty = rs.getDouble(10);
                double qty = rs.getDouble(11);
                double qty_sold = rs.getDouble(12);

                to_mystorepos_products to = new to_mystorepos_products(product_id, product_code, gen_name, product_name, cost, o_price, price, profit, supplier, onhand_qty, qty, qty_sold);
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
}
