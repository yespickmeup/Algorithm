/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_cashcount {

    public final List<Srpt_cashcount.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;

    public Srpt_cashcount(String business_name, String address, String contact_no, String date) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
    }

    public static class field {

        String date;
        String user_id;
        String user_screen_name;
        double cashin;
        double one_thousand;
        double five_hundred;
        double two_hundred;
        double one_hundred;
        double fifty;
        double twenty;
        double ten;
        double five;
        double one;
        double point_fifty;
        double point_twenty_five;
        double point_ten;
        double point_five;
        double amount;

        public field() {

        }

        public field(String date, String user_id, String user_screen_name, double cashin, double one_thousand, double five_hundred, double two_hundred, double one_hundred, double fifty, double twenty, double ten, double five, double one, double point_fifty, double point_twenty_five, double point_ten, double point_five, double amount) {
            this.date = date;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.cashin = cashin;
            this.one_thousand = one_thousand;
            this.five_hundred = five_hundred;
            this.two_hundred = two_hundred;
            this.one_hundred = one_hundred;
            this.fifty = fifty;
            this.twenty = twenty;
            this.ten = ten;
            this.five = five;
            this.one = one;
            this.point_fifty = point_fifty;
            this.point_twenty_five = point_twenty_five;
            this.point_ten = point_ten;
            this.point_five = point_five;
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_screen_name() {
            return user_screen_name;
        }

        public void setUser_screen_name(String user_screen_name) {
            this.user_screen_name = user_screen_name;
        }

        public double getCashin() {
            return cashin;
        }

        public void setCashin(double cashin) {
            this.cashin = cashin;
        }

        public double getOne_thousand() {
            return one_thousand;
        }

        public void setOne_thousand(double one_thousand) {
            this.one_thousand = one_thousand;
        }

        public double getFive_hundred() {
            return five_hundred;
        }

        public void setFive_hundred(double five_hundred) {
            this.five_hundred = five_hundred;
        }

        public double getTwo_hundred() {
            return two_hundred;
        }

        public void setTwo_hundred(double two_hundred) {
            this.two_hundred = two_hundred;
        }

        public double getOne_hundred() {
            return one_hundred;
        }

        public void setOne_hundred(double one_hundred) {
            this.one_hundred = one_hundred;
        }

        public double getFifty() {
            return fifty;
        }

        public void setFifty(double fifty) {
            this.fifty = fifty;
        }

        public double getTwenty() {
            return twenty;
        }

        public void setTwenty(double twenty) {
            this.twenty = twenty;
        }

        public double getTen() {
            return ten;
        }

        public void setTen(double ten) {
            this.ten = ten;
        }

        public double getFive() {
            return five;
        }

        public void setFive(double five) {
            this.five = five;
        }

        public double getOne() {
            return one;
        }

        public void setOne(double one) {
            this.one = one;
        }

        public double getPoint_fifty() {
            return point_fifty;
        }

        public void setPoint_fifty(double point_fifty) {
            this.point_fifty = point_fifty;
        }

        public double getPoint_twenty_five() {
            return point_twenty_five;
        }

        public void setPoint_twenty_five(double point_twenty_five) {
            this.point_twenty_five = point_twenty_five;
        }

        public double getPoint_ten() {
            return point_ten;
        }

        public void setPoint_ten(double point_ten) {
            this.point_ten = point_ten;
        }

        public double getPoint_five() {
            return point_five;
        }

        public void setPoint_five(double point_five) {
            this.point_five = point_five;
        }
    }

    public static void main(String[] args) {

        List<Srpt_cashcount.field> fields = new ArrayList();
        for (int i = 1; i < 10; i++) {
            String date = "November 11, 2014";
            String user_id = "1";
            if (i == 6) {
                user_id = "2";
            }
            String user_screen_name = "Ronald Pascua " + i;
            double cashin = 1000;
            double one_thousand = 2;
            double five_hundred = 3;
            double two_hundred = 1;
            double one_hundred = 10;
            double fifty = 0;
            double twenty = 10;
            double ten = 20;
            double five = 0;
            double one = 1;
            double point_fifty = 50;
            double point_twenty_five = 0;
            double point_ten = 0;
            double point_five = 0;
            double amount = 5000;
            Srpt_cashcount.field field = new field(date, user_id, user_screen_name, cashin, one_thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, ten, five, one, point_fifty, point_twenty_five, point_ten, point_five, amount);
            fields.add(field);

        }
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cashcount rpt = new Srpt_cashcount(business_name, address, contact_no, date);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cashcount.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cashcount.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cashcount to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cashcount.field> cashcount(String where) {
        List<Srpt_cashcount.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",ifnull(sum(amount),0)"
                    + ",ifnull(sum(cash_out),0)"
                    + ",ifnull(sum(thousand),0)"
                    + ",ifnull(sum(five_hundred),0)"
                    + ",ifnull(sum(two_hundred),0)"
                    + ",ifnull(sum(fifty),0)"
                    + ",ifnull(sum(twenty),0)"
                    + ",ifnull(sum(coins),0)"
                    + ",ifnull(sum(one_hundred),0)"
                    + ",ifnull(sum(expenses),0)"
                    + ",ifnull(sum(ten),0)"
                    + ",ifnull(sum(five),0)"
                    + ",ifnull(sum(one),0)"
                    + ",ifnull(sum(point_five),0)"
                    + ",ifnull(sum(point_two_five),0)"
                    + ",ifnull(sum(point_ten),0)"
                    + ",ifnull(sum(point_zero_five),0)"
                    + " from cash_drawer"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);
                double ten = rs.getDouble(17);
                double five = rs.getDouble(18);
                double one = rs.getDouble(19);
                double point_five = rs.getDouble(20);
                double point_two_five = rs.getDouble(21);
                double point_ten = rs.getDouble(22);
                double point_zero_five = rs.getDouble(23);

                String date = "";
                if (time_in != null) {
                    date = DateType.convert_jan_1_2013_datetime2(time_in);
                }

                String user_id = user_name;

                String user_screen_name = screen_name;
                double cashin1 = amount;
                double one_thousand1 = thousand;
                double five_hundred1 = five_hundred;
                double two_hundred1 = two_hundred;
                double one_hundred1 = one_hundred;
                double fifty1 = fifty;
                double twenty1 = twenty;
                double ten1 = ten;
                double five1 = five;
                double one1 = one;
                double point_fifty1 = point_five;
                double point_twenty_five1 = point_two_five;
                double point_ten1 = point_ten;
                double point_five1 = point_zero_five;

                double amount1 = (one_thousand1 * 1000)
                        + (five_hundred1 * 500)
                        + (two_hundred1 * 200)
                        + (one_hundred1 * 100)
                        + (fifty1 * 50)
                        + (twenty1 * 20)
                        + (ten1 * 10)
                        + (five1 * 5)
                        + (one1 * 1)
                        + (point_fifty1 * .50)
                        + (point_twenty_five1 * .25)
                        + (point_ten1 * .10)
                        + (point_five1 * .05) + amount;

                Srpt_cashcount.field field = new field(date, user_id, user_screen_name, cashin1, one_thousand1, five_hundred1, two_hundred1, one_hundred1, fifty1, twenty1, ten1, five1, one1, point_fifty1, point_twenty_five1, point_ten1, point_five1, amount1);
                datas.add(field);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
