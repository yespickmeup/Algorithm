/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Guinness
 */
public class Compare {

    public static void main(String[] args) {

        final ArrayList students = new ArrayList();
        students.add("1000");
        students.add("1001");
        students.add("1002");
        students.add("1003");
        students.add("1001");
        students.add("1004");

        /**
         * Printing original list *
         */
        System.out.println(students);

        Set set = new TreeSet(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1.toString().equalsIgnoreCase(o2.toString())) {
                    return 0;
                }
                return 1;
            }
        });
        set.addAll(students);

        System.out.println("\n***** After removing duplicates *******\n");

        final ArrayList newList = new ArrayList(set);

        /**
         * Printing original list *
         */
        System.out.println(newList);
    }

}
