/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

/**
 *
 * @author Guinness
 */
public class convert_to_negative {

    public static void main(String[] args) {
        double qty = -150;
        if (qty == 0) {
            qty = 0;
        } else if (qty > 0) {
            qty = qty * -1;
        } else {
            qty = qty * -1;
        }
        System.out.println(qty);
    }
}
