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
public class multiply {

    public static void main(String[] args) {
        String stmt = "40.9*10000";

        boolean exists = stmt.contains("*");
        System.out.println("exists: " + exists);
        double qty = 1;
        if (exists) {
            String[] list = stmt.split("\\*");
            qty = FitIn.toDouble(list[0]);
        }
        System.out.println("qty: " + qty);
    }
}
