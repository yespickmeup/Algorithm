/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

/**
 *
 * @author Ronescape
 */
public class Test_Percent {

    public static void main(String[] args) {

        double dec = (95 * 100) / 100;
        dec = dec / 100;
        System.out.println("Decimal: " + dec);

        double color = 255 * dec;
        System.out.println("Color: " + color);
//        for (int i = 1024; i >= 0; i--) {
//            double percent = (i * 100) / 1024;
//            System.out.println("Total: " + i + " | " + percent);
//
//        }
    }
}
