/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import POS.inventory.Inventory_barcodes;
import POS.inventory.S2_inventory_barcodes;
import POS.unit_of_measure.S1_unit_of_measure;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Test_items {

    public static void main(String[] args) {

        String search = "";
        String where = " where main_barcode='" + search + "' and location_id='" + "14" + "' "
                + " or barcode='" + search + "' and location_id='" + "14" + "' ";
        List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = S2_inventory_barcodes.ret_data(where);
        Object[][] obj = new Object[inventory_barcoders_list.size()][6];
        int it = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
            obj[it][0] = " " + FitIn.fmt_woc(to.product_qty);
            obj[it][1] = " " + to.main_barcode;
            obj[it][2] = " " + to.description;
            obj[it][3] = to.unit;
            List<S1_unit_of_measure.to_uom> uoms = new ArrayList();
            String[] list = to.unit.split(",");
            int def = 0;
            int o = 0;
            System.out.println("Barcode: " + to.main_barcode + " Unit: " + to.unit);
            for (String s : list) {
                int i = s.indexOf(":");
                int ii = s.indexOf("/");
                int iii = s.indexOf("^");
                String uom1 = "";
                if (i > 0) {
                    uom1 = s.substring(1, i);
                }
                System.out.println(" UOM: "+uom1);
//                double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
//                System.out.println(" UOM: "+ );
//                double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
//                int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
//                S1_unit_of_measure.to_uom to1 = new S1_unit_of_measure.to_uom(uom1, selling_price, conversion, is_default);
//                uoms.add(to1);
//                if (to1.is_default == 1) {
//                    def = o;
//                    break;
//                }
//                o++;
            }

//            S1_unit_of_measure.to_uom t = (S1_unit_of_measure.to_uom) uoms.get(o);
//            obj[it][3] = " " + t.unit;
//            obj[it][4] = " " + FitIn.fmt_wc_0(to.cost);
//            obj[it][5] = " " + FitIn.fmt_wc_0(t.price);
            it++;
        }
    }
}
