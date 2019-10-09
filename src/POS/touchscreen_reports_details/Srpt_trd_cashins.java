/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports_details;

import POS.cash_drawer.S1_cash_drawer.to_cash_drawer;
import POS.touchscreen_reports.Srpt_cc_remit;
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
import synsoftech.util.DateType;

/**
 *
 * @author Ronescape
 */
public class Srpt_trd_cashins {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String cashier;
    public final String time;
    public final List<field> fields;

    public Srpt_trd_cashins(String business_name, String address, String contact_no, String date, String cashier, String time) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.cashier = cashier;
        this.time = time;
    }

    public static class field {

        String screen_name;
        String time_in;
        String time_out;
        double amount;

        public field() {
        }

        public field(String screen_name, String time_in, String time_out, double amount) {
            this.screen_name = screen_name;
            this.time_in = time_in;
            this.time_out = time_out;
            this.amount = amount;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public String getTime_in() {
            return time_in;
        }

        public void setTime_in(String time_in) {
            this.time_in = time_in;
        }

        public String getTime_out() {
            return time_out;
        }

        public void setTime_out(String time_out) {
            this.time_out = time_out;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static List<field> ret_data(String where) {
        List<field> datas = new ArrayList();

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
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",is_uploaded"
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
                if (time_in == null) {
                    time_in = "";
                } else {
                    time_in = DateType.convert_slash_datetime3(time_in);
                }

                String time_out = rs.getString(6);
                if (time_out == null) {
                    time_out = "";
                } else {
                    time_out = DateType.convert_slash_datetime3(time_out);
                }

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
                String branch = rs.getString(24);
                String branch_id = rs.getString(25);
                String location = rs.getString(26);
                String location_id = rs.getString(27);
                String user_id = rs.getString(28);
                String user_screen_name = rs.getString(29);
                int is_uploaded = rs.getInt(30);

                field f = new field(screen_name, time_in, time_out, amount);
                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");
        String where = " where Date(time_in) between '2019-04-01' and '2019-04-10' ";
        List<field> fields = Srpt_trd_cashins.ret_data(where);
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Dumaguete City");
        String contact_no = System.getProperty("contact_no", "0000000");
        String date = "All";
        String cashier = "All";
        String time = "All";
        Srpt_trd_cashins rpt = new Srpt_trd_cashins(business_name, address, contact_no, date, cashier, time);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_trd_cashins.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_trd_cashins.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_trd_cashins to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}
