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
public class tax {

    public static void main2(String[] args) {
        double rate = 6;
        rate = rate / 100;
        System.out.println(rate);
        double a = 1;
        a = a - rate;
        System.out.println(a);
        double my_wtax = 150 / a;
        System.out.println(my_wtax);

    }

    public static void main(String[] args) {
        String or = "14|0000000000001212";
        int index = or.indexOf("|");
        or = or.substring(index + 1, or.length());
        System.out.println("or: " + or);
    }
}
