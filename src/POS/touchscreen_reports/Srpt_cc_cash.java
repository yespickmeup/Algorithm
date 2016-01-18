/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

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
public class Srpt_cc_cash {

    public final List<Srpt_cc_cash.field> fields;

    public Srpt_cc_cash() {
        this.fields = new ArrayList();
    }

    public static class field {

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

        public field(double cashin, double one_thousand, double five_hundred, double two_hundred, double one_hundred, double fifty, double twenty, double ten, double five, double one, double point_fifty, double point_twenty_five, double point_ten, double point_five, double amount) {
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

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Srpt_cc_cash.field> fields =Srpt_cc_cash.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cc_cash rpt = new Srpt_cc_cash();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cc_cash.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cc_cash.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc_cash to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_cash.field> ret_data(String where) {
        List<Srpt_cc_cash.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + ",ten"
                    + ",five"
                    + ",one"
                    + ",point_five"
                    + ",point_two_five"
                    + ",point_ten"
                    + ",point_zero_five"
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
                double total
                        = (amount)
                        + (thousand * 1000)
                        + (five_hundred * 500)
                        + (two_hundred * 200)
                        + (one_hundred * 100)
                        + (fifty * 50)
                        + (twenty * 50)
                        + (ten * 10)
                        + (five * 5)
                        + (one * 1)
                        + (point_five * .50)
                        + (point_two_five * .25)
                        + (point_ten * .10)
                        + (point_zero_five * .05);
                Srpt_cc_cash.field field = new Srpt_cc_cash.field(amount, thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, ten, five, one, point_five, point_two_five, point_ten, point_five, total);
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
