/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.cash_drawer.S1_cash_drawer;
import java.util.List;

/**
 *
 * @author Ronescape
 */
public class Adjust_null_logout {

    public static void adjust() {
        List<S1_cash_drawer.to_cash_drawer> drawers = S1_cash_drawer.ret_where(" where time_out is null");
        for (S1_cash_drawer.to_cash_drawer draw : drawers) {
            System.out.println("id: " + draw.id + " user: " + draw.user_name + " date: " + draw.time_in);
            List<S1_cash_drawer.to_cash_drawer> drawers2 = S1_cash_drawer.ret_where(" where id> '" + draw.id + "' ");
            if (!drawers2.isEmpty()) {
                S1_cash_drawer.to_cash_drawer to = (S1_cash_drawer.to_cash_drawer) drawers2.get(0);
                if (to.time_out != null) {
                    S1_cash_drawer.update_cash_drawer(draw.id, to.time_out);
                }
                System.out.println("        Id: " + to.id + "   Time out: " + to.time_out);
            } else {
                System.out.println("        Time out: null");
            }
        }
        System.out.println("size: " + drawers.size());
    }

    public static void main(String[] args) {
//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments");

    }
}
