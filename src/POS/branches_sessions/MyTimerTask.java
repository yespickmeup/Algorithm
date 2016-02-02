/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;

import POS.util.DateType;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class MyTimerTask extends Thread {

    private void set() {
        System.out.println("Countdown Starts.....");

        MyTimerTask t = new MyTimerTask();
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(timelapse);
        } catch (InterruptedException x) {
            throw new RuntimeException(x);
        } finally {

        }

        System.out.println("End of Countdown.....");
        System.out.println("");
        set();
    }
    static String is_main_server = "false";

    public static void main(String[] args) {
        is_main_server = System.getProperty("is_main_server", "false");

        MyTimerTask ti = new MyTimerTask();
        ti.set();
    }
    static int timelapse = 11000;
    int count = 1;

    //
    @Override
    public void run() {

        while (true) {
            try {
                int hour = FitIn.toInt(DateType.hour.format(new Date()));
                int minutes = FitIn.toInt(DateType.minute.format(new Date()));
                int seconds = FitIn.toInt(DateType.seconds.format(new Date()));

                if (hour >= 20 && hour <= 21) {
                    System.out.println("Time to Synch Data!");
                    if (is_main_server.equalsIgnoreCase("true")) {
                        //Do Download Updates from All Branches
                        //Do upload updates from MainServer to All Branches via Cloud
                    } else {
                        //Do Branch upload to Cloud
                        //Do Branch download updates from MainServer via Cloud

                    }
                }

                if (count == 11) {
                    this.stop();
                }
                Thread.sleep(1000);

                System.out.println("Time: " + hour + ":" + minutes + ":" + seconds);

                count++;
            } catch (InterruptedException ex) {
                Logger.getLogger(MyTimerTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
