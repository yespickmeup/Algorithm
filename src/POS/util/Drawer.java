/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import POS.test2.test_drawer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guinness
 */
public class Drawer {
    
    public static void open(String file) {
        try {
            String home = System.getProperty("user.home", "");
            String path = "cmd /c start " + home + file;
            System.out.println(path);
            Runtime rn = Runtime.getRuntime();
            Process pr = rn.exec(path);
            pr.destroy();
        } catch (IOException ex) {
            Logger.getLogger(test_drawer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
