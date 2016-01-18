/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

/**
 *
 * @author Guinness
 */
public class serial {

    public static void main(String[] args) {
        String new_serial = "";
        String serial1
                = "1111\n"
                + "2222\n"
                + "3333\n";
        String serial2
                = "3333\n1111";

        String[] l_serial2 = serial2.split("\n");

        for (String s1 : l_serial2) {
            if (serial1.contains(s1)) {
                serial1 = serial1.replaceAll(s1, "");
            }
        }
        String[] l_serial = serial1.split("\n");
        int i = 0;
        for (String s2 : l_serial) {
            if (!s2.equals("\n")) {
                if (i == 0) {
                    if (!s2.isEmpty()) {
                        new_serial = s2;
                    }
                } else {
                    if (!s2.isEmpty()) {
                        new_serial = new_serial + "\n" + s2;
                    }
                }
                i++;
            }
        }
        System.out.println("Serial: " + new_serial);

    }
}
