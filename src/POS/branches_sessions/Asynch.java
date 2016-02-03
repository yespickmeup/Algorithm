/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;

import POS.util.DateType;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Asynch {

    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
    }

    public static void main2(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.gc();
        Asynch s = new Asynch();
        s.start();
    }

    int count = 1;
    Timer timer = new Timer();

    private void start() {

        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (count == 11) {
                    try {

                        timer.cancel();
                        if (timer != null) {
                            timer = null;
                            System.gc();
                        }
                        count = 1;
                        Thread.sleep(5000);
                        start();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asynch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                int hour = FitIn.toInt(DateType.hour.format(new Date()));
                int minutes = FitIn.toInt(DateType.minute.format(new Date()));
                int seconds = FitIn.toInt(DateType.seconds.format(new Date()));
                System.out.println("Time: " + hour + ":" + minutes + ":" + seconds + " Count: " + count);
                count++;
            }
        }, 1000, 1000);
    }
}
