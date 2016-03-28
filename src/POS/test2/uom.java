/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class uom {

    public static void main(String[] args) {
        String or = "14S000000014954";
        or = or.replace("|", "S");
        String[] split = or.split("S");
        for (String s : split) {
            System.out.println(s);
        }
//        System.out.println(split[2]);
    }

    public static void main2(String[] args) {

        String uoms = "";
        double new_price = 5000.0;
        String unit = "[pc:3400.0/1.0^1],[:100.0/1.0^0],[:200.0/1.0^0]";
        String[] list = unit.split(",");
        int index = 0;
        for (String s : list) {
            int i = s.indexOf(":");
            int ii = s.indexOf("/");
            int iii = s.indexOf("^");
            String uom = s.substring(1, i);
            double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
            double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
            int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
            System.out.println(s);
            System.out.println(" " + uom + " : " + selling_price + " : " + conversion + " : " + is_default);

            if (index == 0) {
                uoms = "[" + uom + ":" + new_price + "/" + conversion + "^" + is_default + "]";
            } else {
                uoms = uoms + ",[" + uom + ":" + selling_price + "/" + conversion + "^" + is_default + "]";
            }
            index++;
        }
        System.out.println(uoms);
    }

}
