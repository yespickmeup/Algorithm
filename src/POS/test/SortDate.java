/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

import POS.util.DateUtils1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.DateTime;

/**
 *
 * @author i1
 */
public class SortDate {

    public static void main(String[] args) {
        List<MyObject> datas = new ArrayList();

        MyObject t1 = new MyObject("t1", DateUtils1.add_day(new Date(), 1));
        MyObject t2 = new MyObject("t2", DateUtils1.add_day(new Date(), 2));
        MyObject t3 = new MyObject("t3", DateUtils1.add_day(new Date(), 4));
        MyObject t4 = new MyObject("t4", DateUtils1.add_day(new Date(), 5));
        MyObject t5 = new MyObject("t5", DateUtils1.add_day(new Date(), 3));
        MyObject t13 = new MyObject("t13", DateUtils1.add_day(new Date(), 6));
        MyObject t6 = new MyObject("t6", DateUtils1.add_day(new Date(), 7));
        MyObject t7 = new MyObject("t7", DateUtils1.add_day(new Date(), 9));
        MyObject t8 = new MyObject("t8", DateUtils1.add_day(new Date(), 8));
        MyObject t9 = new MyObject("t9", DateUtils1.add_day(new Date(), 10));
        MyObject t10 = new MyObject("t10", DateUtils1.add_day(new Date(), 13));
        MyObject t11 = new MyObject("t11", DateUtils1.add_day(new Date(), 11));
        MyObject t12 = new MyObject("t12", DateUtils1.add_day(new Date(), 12));


        datas.add(t1);
        datas.add(t2);
        datas.add(t3);
        datas.add(t4);
        datas.add(t5);

        datas.add(t6);
        datas.add(t7);
        datas.add(t8);
        datas.add(t9);
        datas.add(t10);
        datas.add(t11);
        datas.add(t12);
        datas.add(t13);


        Collections.sort(datas, new Comparator<MyObject>() {

            public int compare(MyObject o1, MyObject o2) {
                return o1.getDateTime(). compareTo(o2.getDateTime());
            }
        });


        for (MyObject to : datas) {
            System.out.println(to.name + " : "+to.dateTime);
        }

    }

    public static class MyObject implements Comparable<MyObject> {

        private String name;
        private Date dateTime;

        public MyObject(String name, Date dateTime) {
            this.name = name;
            this.dateTime = dateTime;
        }

        public String getName() {
            return name;
        }

        public Date getDateTime() {
            return dateTime;
        }

        @Override
        public int compareTo(MyObject o) {
            if (getDateTime() == null || o.getDateTime() == null) {
                return 0;
            }
            return getDateTime().
                    compareTo(o.getDateTime());
        }
    }
}
