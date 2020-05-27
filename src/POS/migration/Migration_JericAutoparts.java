/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.migration;

import POS.inventory.Inventory;
import POS.util.Alert;
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
 * @author User
 */
public class Migration_JericAutoparts {

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_smis_jeric_autoparts");
        List<Inventory.to_inventory> tos = new ArrayList();
        List<to_migration_inventory> items = ret_data("");
        for (to_migration_inventory to : items) {
            System.out.println("barcode: " + to.description + " cost= " + to.cost + " price= " + to.price);
            int id = -1;
            String barcode = "" + to.id;

            String description = to.description;
            String generic_name = "";
            String category = "";
            String category_id = "";
            String classification = "";
            String classification_id = "";
            String sub_classification = "";
            String sub_classification_id = "";
            double product_qty = 0;
            double conversion = 1;
            double selling_price = to.price;
            String date_added = DateType.now();
            String user_name = "";
            String item_type = "Regular";
            int status = 1;
            String supplier = "";
            int fixed_price = 0;
            double cost = to.cost;
            String supplier_id = "";
            int multi_level_pricing = 0;
            int vatable = 0;
            double reorder_level = 0;
            double markup = 0;
            String barcodes = to.barcode;
            String brand = "";
            String brand_id = "";
            String model = "";
            String model_id = "";
            int selling_type = 1;
            String branch = "Dumaguete City";
            String branch_code = "1";
            String location = "Selling Area";
            String location_id = "1";
            String unit = "[" + "pc" + ":" + to.price + "/1.0^1]";
            int is_uploaded = 0;
            int allow_negative_inventory = 1;
            int auto_order = 0;
            int show_to_sales = 1;
            Inventory.to_inventory to2 = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
            tos.add(to2);
        }
        List<String> query = Inventory.add_inventory_list(tos);
        System.out.println("Count: " + tos.size());
        Alert.set(1, "");
    }

    public static class to_migration_inventory {

        public final int id;
        public final String barcode;
        public final String inv_no;
        public final String description;
        public final double cost;
        public final double price;

        public to_migration_inventory(int id, String barcode, String inv_no, String description, double cost, double price) {
            this.id = id;
            this.barcode = barcode;
            this.inv_no = inv_no;
            this.description = description;
            this.cost = cost;
            this.price = price;
        }
    }

    public static List<to_migration_inventory> ret_data(String where) {
        List<to_migration_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",inv_no"
                    + ",description"
                    + " from migration_inventory"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String inv_no = rs.getString(3);
                String description = rs.getString(4);

                String s2 = "select "
                        + "id"
                        + ",invoice_no"
                        + ",description"
                        + ",price"
                        + ",cose"
                        + " from migration_invoices"
                        + " where invoice_no like '" + inv_no + "' order by id desc limit 1";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                double cost = 0;
                double price = 0;
                if (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    String invoice_no = rs2.getString(2);
                    cost = rs2.getDouble(5);
                    price = rs2.getDouble(4);

                }

                to_migration_inventory to = new to_migration_inventory(id, barcode, inv_no, description, cost, price);
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
