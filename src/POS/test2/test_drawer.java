/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guinness
 */
public class test_drawer {

    public static void main(String[] args) {
        String path=System.getProperty("user.home","" );
        System.out.println(path);       
    }
    public static void main2(String[] args) {

        try {
            String path = "cmd /c start C:\\Users\\Guinness\\drawer\\serial1.bat";
            Runtime rn = Runtime.getRuntime();
            Process pr = rn.exec(path);
            pr.destroy();
        } catch (IOException ex) {
            Logger.getLogger(test_drawer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
