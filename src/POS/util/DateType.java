/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Dummy
 */
public class DateType {

    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sf2 = new SimpleDateFormat("MM-dd-yyyy");
    public static SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss aa");
    public static SimpleDateFormat time2 = new SimpleDateFormat("HH:mm aa");
    public static SimpleDateFormat time4 = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat time5 = new SimpleDateFormat("hh:mm aa");
    public static SimpleDateFormat sf1 = new SimpleDateFormat("EEE, MMM dd,yyyy");
    public static SimpleDateFormat d = new SimpleDateFormat("dd");
    public static SimpleDateFormat m = new SimpleDateFormat("MMMMMMMMMMM");
    public static SimpleDateFormat m1 = new SimpleDateFormat("MM");
    public static SimpleDateFormat y = new SimpleDateFormat("yyyy");
    public static SimpleDateFormat liquid = new SimpleDateFormat("EEEEEEEEEEE dd MMMMMMMMMMM yyyy");
    public static SimpleDateFormat day = new SimpleDateFormat("EEEEEEEEEEE");
    public static SimpleDateFormat day_1 = new SimpleDateFormat("EEEEEEEEEEE dd");
    public static SimpleDateFormat month_year = new SimpleDateFormat("MMMMMMMMMMM yyyy");
    public static SimpleDateFormat month_date = new SimpleDateFormat("MMMMMMMMMM dd, yyyy");
    public static SimpleDateFormat day_and_time = new SimpleDateFormat("MMMMMMMMMM dd, yyyy HH:mm aa");
    public static SimpleDateFormat slash = new SimpleDateFormat("MM/dd/yyyy");
    public static SimpleDateFormat slash_w_time = new SimpleDateFormat("MM/dd/yyyy HH:mm aa");
    public static SimpleDateFormat time3 = new SimpleDateFormat("HH:mm:ss aa");
    public static SimpleDateFormat backup = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

    public static SimpleDateFormat hour = new SimpleDateFormat("HH");
    public static SimpleDateFormat minute = new SimpleDateFormat("mm");
    public static SimpleDateFormat seconds = new SimpleDateFormat("ss");

    public static void main2(String[] args) {
        System.out.println(sf1.format(new Date()));
    }

    public static String convert_jan_1_2013_datetime(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.day_and_time.format(d);
        return date;
    }

    public static String convert_jan_1_2013_datetime2(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.month_date.format(d);
        return date;
    }

    public static String convert_jan_1_2013_sf(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.sf.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.month_date.format(d);
        return date;
    }

    public static String convert_slash_datetime(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.slash.format(d);
        return date;
    }

    public static String convert_slash_datetime3(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.slash_w_time.format(d);
        return date;
    }

    public static String convert_slash_datetime4(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.sf.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.slash_w_time.format(d);
        return date;
    }

    public static String convert_slash_datetime2(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.sf.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.slash.format(d);
        return date;
    }

    public static String convert_slash_datetime_sf(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.slash.format(new Date());
        }
        try {
            d = DateType.slash.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.sf.format(d);
        return date;
    }

    public static String convert_dash_date(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.sf.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.month_date.format(d);
        return date;
    }

    public static String convert_dash_date4(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.sf.format(d);
        return date;
    }

    public static String convert_dash_date5(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.time4.parse(datetime);

        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.time4.format(d);
        return date;
    }

    public static String convert_monthDate_sf(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.month_date.format(new Date());
        }
        try {
            d = DateType.month_date.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.sf.format(d);
        return date;
    }

    public static String convert_dash_date2(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.sf.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.slash.format(d);
        return date;
    }

    public static String convert_datetime_to_month(String datetime) {
        String date = "";

        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.m.format(d);
        return date;
    }

    public static List<String> listMonths() {
        List<String> datas = new ArrayList();
        datas.add("January");
        datas.add("February");
        datas.add("March");
        datas.add("April");
        datas.add("May");
        datas.add("June");
        datas.add("July");
        datas.add("August");
        datas.add("September");
        datas.add("October");
        datas.add("November");
        datas.add("December");
        return datas;
    }

    public static String now() {
        Date d = new Date();
        String s = DateType.datetime.format(d);
        return s;
    }

    public static String mDate_to_Date(String m) {
        Date d = new Date();
        try {
            d = DateType.month_date.parse(m);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        String s = DateType.sf.format(d);
        return s;
    }

    public static String noMonth(String month) {
        String ret = "";
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            String mon = months[i];
            if (mon.equalsIgnoreCase(month)) {
                String s = "" + mon;
                if (s.length() == 1) {
                    s = "0" + mon;
                }
                ret = s;
                break;
            }
        }
        return ret;
    }

    public static List<String> listDays() {
        List<String> datas = new ArrayList();
        for (int i = 1; i < 32; i++) {
            String s = "" + i;
            if (s.length() == 1) {
                s = "0" + s;
            }
            datas.add(s);
        }
        return datas;
    }

    public static List<String> listYear() {
        List<String> datas = new ArrayList();
        int year = FitIn.toInt(DateType.y.format(new Date()));
        for (int i = 1993; i <= year; i++) {
            String s = "" + i;
            if (s.length() == 1) {
                s = "0" + s;
            }
            datas.add(s);
        }
        return datas;
    }

    public static String add_zero(String day) {

        if (day.length() == 1) {
            day = "0" + day;
        }
        return day;
    }

    public static List<String> time() {
        List<String> time_list = new ArrayList();
        String[] list = {"12:00am",
            "12:30am",
            "1:00am",
            "1:30am",
            "2:00am",
            "2:30am",
            "3:00am",
            "3:30am",
            "4:00am",
            "4:30am",
            "5:00am",
            "5:30am",
            "6:00am",
            "6:30am",
            "7:00am",
            "7:30am",
            "8:00am",
            "8:30am",
            "9:00am",
            "9:30am",
            "10:00am",
            "10:30am",
            "11:00am",
            "11:30am",
            "12:00pm",
            "12:30pm",
            "1:00pm",
            "1:30pm",
            "2:00pm",
            "2:30pm",
            "3:00pm",
            "3:30pm",
            "4:00pm",
            "4:30pm",
            "5:00pm",
            "5:30pm",
            "6:00pm",
            "6:30pm",
            "7:00pm",
            "7:30pm",
            "8:00pm",
            "8:30pm",
            "9:00pm",
            "9:30pm",
            "10:00pm",
            "10:30pm",
            "11:00pm",
            "11:30pm",
            "11:59pm"
        };
        for (String s : list) {
            time_list.add(s);
        }
        return time_list;
    }

    public static void main(String[] args) {
        System.out.println(convert_am_pm_to_stamp("11:30pm", "from"));
    }

    public static String convert_am_pm_to_stamp(String time, String from_to) {
        String[] t = time.split(":");
        String t1 = t[0];
        String t2 = t[1];
        String hours = t1;
        if (hours.length() == 1) {
            hours = "0" + hours;
        }
        String minutes = t2.substring(0, 2);
        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        }
        String am_pm = t2.substring(2, 4);
        if (am_pm.equals("pm")) {
            int h = FitIn.toInt(hours);
            if (h != 12) {
                h = h + 12;
                hours = "" + h;
            }
        } else {
            int h = FitIn.toInt(hours);
            if (h == 12) {
                hours = "00";
            }
        }
//        System.out.println("hours: " + hours);
//        System.out.println("minutes: " + minutes);
//        System.out.println("am_pm: " + am_pm);
        time = hours + ":" + minutes + ":00";
        if (from_to.equalsIgnoreCase("to")) {
            time = hours + ":" + minutes + ":59";
        }
        return time;
    }

    public static String ampm_to_timestamp(String time) {
        String[] ret_time = new String[2];

        time = time.replace("am", "");
        time = time.replace("pm", "");
        
        ret_time[0] = time+":00";
        return "";
    }
}
