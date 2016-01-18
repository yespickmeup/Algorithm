/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.synch_locations;

import POS.util.DateType;
import POS.util.DateUtils1;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guinness
 */
public class Local_uploads {

    public static void main(String[] args) {
        List<String> days = getDates("2016-01-01");
        for (String s : days) {
            System.out.println(s);
        }
    }

    public static List<String> getDates(String from) {
        List<String> days = new ArrayList();
        try {
            Date from2 = DateType.sf.parse(from);
            Date to = new Date();
            int count = DateUtils1.count_days(from2, to);

            for (int i = 1; i < count + 1; i++) {
                Date from1 = DateType.sf.parse(from);
                Date inc = DateUtils1.add_day(from1, i);
                String date = DateType.sf.format(inc);
                days.add(date);
            }

        } catch (ParseException ex) {
            Logger.getLogger(Local_uploads.class.getName()).log(Level.SEVERE, null, ex);
        }
        return days;

    }
}
