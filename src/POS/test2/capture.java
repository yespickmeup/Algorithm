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
public class capture {

    public static void main(String[] args) {
        String unit = "[sack:690.0/25.0^0],[kilo:31.0/1.0^1]";
        double cost=690;
        String uom = unit;
        String[] list = uom.split(",");
        double conv = 1;
        for (String s : list) {
            int i = s.indexOf(":");
            int ii = s.indexOf("/");
            double conv1 = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
            double sell = FitIn.toDouble(s.substring(i + 1, ii));
            if (conv1 >conv) {
                conv = conv1;
                
            }
        }

    }
}
