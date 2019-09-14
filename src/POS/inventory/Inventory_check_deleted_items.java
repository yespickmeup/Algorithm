/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.util.Alert;
import POS.util.DateType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronescape
 */
public class Inventory_check_deleted_items {

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("pool_host", "192.168.1.51");

        List<String> to_add = new ArrayList();
        for (int i = 1140; i < 8866; i++) {
            String bar = "" + i;
            List<Inventory.to_inventory> items = Inventory.ret_data22(" where barcode='" + bar + "' ");
            if (items.isEmpty()) {
                System.out.println("item code: " + bar);
                to_add.add(bar);
            }
        }

        System.out.println("--------------------------");
        System.out.println("To Add: " + to_add.size());
        for (String s : to_add) {

            int id = -1;
            String barcode = s;
            String description = s;
            String generic_name = s;
            String category = "";
            String category_id = "";
            String classification = "";
            String classification_id = "";
            String sub_classification = "";
            String sub_classification_id = "";

            double product_qty = 0;
            double conversion = 1;
            double selling_price = 0;
            String date_added = DateType.now();
            String user_name = "";
            String item_type = "";
            int status = 1;
            String supplier = "";
            int fixed_price = 0;
            double cost = 0;
            String supplier_id = "";
            int multi_level_pricing = 0;
            int vatable = 0;
            double reorder_level = 0;
            double markup = 0;
            String barcodes = "";
            String brand = "";
            String brand_id = "";
            String model = "";
            String model_id = "";
            int selling_type = 1;
            String branch = "";
            String branch_code = "";
            String location = "";
            String location_id = "";
            String unit = uom.convert_to_string("pc", 1, selling_price, 1);

            int is_uploaded = 0;
            int allow_negative_inventory = 1;
            int auto_order = 0;
            int show_to_sales=0;
            final Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order,show_to_sales);
            Inventory.add_inventory(to);
        }
        
        Alert.set(1, "");
        System.out.println("--------------------------");
    }
}
