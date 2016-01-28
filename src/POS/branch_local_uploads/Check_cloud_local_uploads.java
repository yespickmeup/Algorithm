/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guinness
 */
public class Check_cloud_local_uploads {

    public static void main(String[] args) {
        String where = " where status=0 ";
        List<Branch_local_uploads.to_branch_local_uploads> datas = Branch_local_uploads.ret_data(where);
        System.out.println(datas.size());

        List<Parse_inventory_replenishments> l_replenishments = new ArrayList();
        List<Parse_inventory_counts.field> l_inventory_counts = new ArrayList();
        List<Parse_inventory_adjustments.field> l_adjustments = new ArrayList();
        List<Parse_stock_transfers> l_stock_transfers = new ArrayList();
        List<Parse_receipts> l_receipts = new ArrayList();
        List<Parse_sales.field> l_sales = new ArrayList();
        List<Parse_sale_item_replacements> l_returned_items = new ArrayList();
        List<Parse_charged_items> l_charged_items = new ArrayList();
        List<String> l_rmas = new ArrayList();
        List<String> l_item_maintenances = new ArrayList();
        List<Parse_cash_drawers> l_cash_drawers = new ArrayList();

        for (Branch_local_uploads.to_branch_local_uploads to : datas) {
            String replenishments = FileToString(to.replenishments);
            String inventory_counts = FileToString(to.inventory_counts);
            String adjustments = FileToString(to.adjustments);
            String stock_transfers = FileToString(to.stock_transfers);
            String receipts = FileToString(to.receipts);
            String sales = FileToString(to.sales);
            String returned_items = FileToString(to.returned_items);
            String charged_items = FileToString(to.charged_items);
            String rmas = FileToString(to.rmas);
            String item_maintenances = FileToString(to.item_maintenances);
            String cash_drawers = FileToString(to.cash_drawers);

            
            l_replenishments.addAll(Parse_inventory_replenishments.decompress(replenishments));
            l_inventory_counts.addAll(Parse_inventory_counts.decompress(inventory_counts));
            l_adjustments.addAll(Parse_inventory_adjustments.decompress(adjustments));
            l_stock_transfers.addAll(Parse_stock_transfers.decompress(stock_transfers));
            l_receipts.addAll(Parse_receipts.decompress(receipts));
            l_sales.addAll(Parse_sales.decompress(sales));
            l_returned_items.addAll(Parse_sale_item_replacements.decompress(returned_items));
            l_charged_items.addAll(Parse_charged_items.decompress(charged_items));
            l_rmas.addAll(new ArrayList());
            l_item_maintenances.addAll(new ArrayList());
            l_cash_drawers.addAll(Parse_cash_drawers.decompress(cash_drawers));
                       
            
            System.out.println("replenishments: " + replenishments);
            System.out.println("inventory_counts: " + inventory_counts);
            System.out.println("adjustments: " + adjustments);
            System.out.println("stock_transfers: " + stock_transfers);
            System.out.println("receipts: " + receipts);
            System.out.println("sales: " + sales);
            System.out.println("returned_items: " + returned_items);
            System.out.println("charged_items: " + charged_items);
            System.out.println("rmas: " + rmas);
            System.out.println("item_maintenances: " + item_maintenances);
            System.out.println("cash_drawers: " + cash_drawers);
            System.out.println("------------------------------------------------------------------------------------------");
        }
        
        
        

    }

    public static String FileToString(File file) {

        String content = null;

        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Check_cloud_local_uploads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return content;

    }
}
