/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.migrate;

import POS.category.S1_inventory_sub_classification;
import POS.inventory.Inventory;
import POS.inventory.S1_inventory_categories;
import POS.inventory.S1_inventory_classification;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronescape
 */
public class IB_categories {

    public static void set() {
        System.setProperty("pool_db", "db_smis_bayawan_store");
        System.setProperty("pool_password", "password");

        String where = " group by category order by category asc ";
        List<Inventory.to_inventory> items = Inventory.ret_data22(where);
        List<S1_inventory_categories.to_inventory_category> categories = new ArrayList();
        for (Inventory.to_inventory to : items) {
            System.out.println("" + to.category);
            S1_inventory_categories.to_inventory_category ca = new S1_inventory_categories.to_inventory_category(0, to.category, "");
            categories.add(ca);
        }

        S1_inventory_categories.add_inventory_category2(categories);

    }

    public static void main4(String[] args) {

        System.setProperty("pool_db", "db_smis_bayawan_store");
        System.setProperty("pool_password", "password");
        String where = " group by category order by category asc ";
        List<Inventory.to_inventory> items = Inventory.ret_data22(where);
        List<S1_inventory_categories.to_inventory_category> categories = new ArrayList();
        for (Inventory.to_inventory to : items) {
            System.out.println("" + to.category);
            S1_inventory_categories.to_inventory_category ca = new S1_inventory_categories.to_inventory_category(0, to.category, "");
            categories.add(ca);
        }

        S1_inventory_categories.add_inventory_category2(categories);

    }

    public static void main2(String[] args) {

        System.setProperty("pool_db", "db_smis_bayawan_store");
        System.setProperty("pool_password", "password");
        String where = " group by classification order by classification asc ";
        List<Inventory.to_inventory> items = Inventory.ret_data22(where);
        List<S1_inventory_classification.to_inventory_classification> categories = new ArrayList();
        for (Inventory.to_inventory to : items) {
            System.out.println("" + to.category);
            S1_inventory_classification.to_inventory_classification cl = new S1_inventory_classification.to_inventory_classification(0, "" + to.category_id, to.category, "", to.classification, 0);
            categories.add(cl);
        }

        S1_inventory_classification.add_inventory_classification2(categories);

    }

    public static void main(String[] args) {

        System.setProperty("pool_db", "db_smis_bayawan_store");
        System.setProperty("pool_password", "password");
        String where = " group by sub_classification order by sub_classification asc ";
        List<Inventory.to_inventory> items = Inventory.ret_data22(where);
        List<S1_inventory_sub_classification.to_inventory_sub_classification> categories = new ArrayList();
        for (Inventory.to_inventory to : items) {
            System.out.println("" + to.category);
            S1_inventory_sub_classification.to_inventory_sub_classification cl = new S1_inventory_sub_classification.to_inventory_sub_classification(0, to.category_id, to.category, to.classification_id, to.classification, "", to.sub_classification, 0);
            categories.add(cl);
        }

        S1_inventory_sub_classification.add_inventory_sub_classification2(categories);

    }
}
