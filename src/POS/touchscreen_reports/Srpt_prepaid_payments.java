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
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Srpt_prepaid_payments {

    public final List<Srpt_prepaid_payments.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;

    public Srpt_prepaid_payments(String business_name, String address, String contact_no, String date, String branch, String location) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch = branch;
        this.location = location;
    }

    public static class field {

        String id;
        String customer;
        String date;
        String user;
        double cash_amount;
        double check_amount;

        public field() {
        }

        public field(String id, String customer, String date, String user, double cash_amount, double check_amount) {
            this.id = id;
            this.customer = customer;
            this.date = date;
            this.user = user;
            this.cash_amount = cash_amount;
            this.check_amount = check_amount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public double getCash_amount() {
            return cash_amount;
        }

        public void setCash_amount(double cash_amount) {
            this.cash_amount = cash_amount;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }
    }

    public static void main(String[] args) {

        List<Srpt_prepaid_payments.field> fields = Srpt_prepaid_payments.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        String branch = "";
        String location = "";
        Srpt_prepaid_payments rpt = new Srpt_prepaid_payments(business_name, address, contact_no, date, branch, location);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_prepaid_payments.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_prepaid_payments.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_prepaid_payments to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_prepaid_payments.field> ret_data(String where) {
        List<Srpt_prepaid_payments.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",cash"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",added_by"
                    + ",date_added"
                    + ",customer_name"
                    + ",customer_id"
                    + ",status"
                    + ",cheque_holder"
                    + ",cheque_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from prepaid_payments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                double cash = rs.getDouble(2);
                String check_bank = rs.getString(3);
                String check_no = rs.getString(4);
                double check_amount = rs.getDouble(5);
                String added_by = rs.getString(6);
                String date_added = rs.getString(7);
                String customer_name = rs.getString(8);
                String customer_id = rs.getString(9);
                int status = rs.getInt(10);
                String cheque_holder = rs.getString(11);
                String cheque_date = rs.getString(12);
                String user_id = rs.getString(13);
                String user_screen_name = rs.getString(14);
                String branch = rs.getString(15);
                String branch_id = rs.getString(16);
                String location = rs.getString(17);
                String location_id = rs.getString(18);

                String ids = "" + id;
                String customer = customer_name;
                String date = DateType.convert_slash_datetime(date_added);
                String user = user_screen_name;
                double cash_amount = cash;

                Srpt_prepaid_payments.field field = new field(ids, customer, date, user, cash_amount, check_amount);
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
