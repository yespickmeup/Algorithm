/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import POS.receipts.S1_receipt_items;
import POS.receipts.S1_receipts;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class Match_receipts {

    public static void main(String[] args) {
        List<S1_receipts.to_receipts> receipts = S1_receipts.ret_data3(" order by id desc limit 50");
        int total = 0;
        for (S1_receipts.to_receipts to : receipts) {
            String where = " where receipt_no='" + to.receipt_no + "'";
            List<S1_receipt_items.to_receipt_items> items = S1_receipt_items.ret_data5(where);
            int diff = 0;
            for (S1_receipt_items.to_receipt_items item : items) {
                if (!to.branch_id.equalsIgnoreCase(item.location_id)) {
                    diff++;
                }
            }
            
            if (diff > 0) {
                total++;
            }
            if (diff > 0) {
                System.out.println(to.receipt_no + " Total: " + items.size() + " Diff: " + diff);
            }
        }
        System.out.println("Total: " + total);
    }

}
