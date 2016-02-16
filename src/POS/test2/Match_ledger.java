/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import POS.inventory.Inventory_barcodes;
import POS.inventory.Inventory_barcodes.to_inventory_barcodes;
import POS.suppliers.S1_suppliers;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextArea;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Match_ledger {

    public static void match_ledger(String location_id, JTextArea tx) {
        String where = " where  location_id='" + location_id + "' order by main_barcode asc ";
        List<to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);
        System.out.println("Location: " + location_id);
        System.out.println("Total Items: " + datas.size());

        int match = 0;
        int diff = 0;
        for (to_inventory_barcodes to : datas) {
            String where2 = " where main_barcode='" + to.main_barcode + "' and location_id='" + to.location_id + "' ";
            List<to_inventory_barcodes> datas2 = Inventory_barcodes.ret_where_barcode(where2, to.location_id);
            double qty = 0;
            for (to_inventory_barcodes t : datas2) {
                qty += t.product_qty;
            }

            if (qty != to.product_qty) {
                System.out.println(to.main_barcode + " : " + FitIn.fmt_woc(to.product_qty) + " <> " + qty);
                update_qty(to.main_barcode, qty, location_id);
                diff++;
            } else {
                System.out.println(to.main_barcode + " = " + qty + " | " + to.product_qty + " ok!");
                match++;
            }
        }

        System.out.println("Match: " + match);
        System.out.println("Difference: " + diff);
    }

    public static void main(String[] args) {

    }

    public static void main2(String[] args) {
//        update_qty("5942", 16);
    }

    public static void update_qty(String item_code, double qty, String location_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  inventory_barcodes set "
                    + " product_qty= :product_qty"
                    + " where "
                    + " main_barcode ='" + item_code + "' "
                    + " and location_id='" + location_id + "' ";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("product_qty", qty).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
