/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.accounts_receivable.S1_accounts_receivable_payments.to_accounts_receivable_payments;
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
public class Srpt_ar_payments {

    public final List<Srpt_ar_payments.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;

    public Srpt_ar_payments(String business_name, String address, String contact_no, String date, String branch, String location) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch = branch;
        this.location = location;
    }

    public static class field {

        String ar_no;
        String reference_no;
        String customer;
        String user;
        String date;
        String ar_type;
        double cash_amount;
        double check_amount;

        public field() {
        }

        public field(String ar_no, String reference_no, String customer, String user, String date, String ar_type, double cash_amount, double check_amount) {
            this.ar_no = ar_no;
            this.reference_no = reference_no;
            this.customer = customer;
            this.user = user;
            this.date = date;
            this.ar_type = ar_type;
            this.cash_amount = cash_amount;
            this.check_amount = check_amount;
        }

        public String getAr_no() {
            return ar_no;
        }

        public void setAr_no(String ar_no) {
            this.ar_no = ar_no;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAr_type() {
            return ar_type;
        }

        public void setAr_type(String ar_type) {
            this.ar_type = ar_type;
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

        List<Srpt_ar_payments.field> fields = Srpt_ar_payments.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        String branch = "";
        String location = "";
        Srpt_ar_payments rpt = new Srpt_ar_payments(business_name, address, contact_no, date, branch, location);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_ar_payments.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_ar_payments.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_ar_payments to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_ar_payments.field> ret_data(String where) {
        List<Srpt_ar_payments.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",prev_balance"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",or_payment_no"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",wtax"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from accounts_receivable_payments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                double amount = rs.getDouble(7);
                double discount_amount = rs.getDouble(8);
                double discount_rate = rs.getDouble(9);
                String discount = rs.getString(10);
                int status = rs.getInt(11);
                double term = rs.getDouble(12);
                String date_applied = rs.getString(13);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                double prev_balance = rs.getDouble(19);
                double check_amount = rs.getDouble(20);
                String check_holder = rs.getString(21);
                String check_bank = rs.getString(22);
                String check_no = rs.getString(23);
                String ci_no = rs.getString(24);
                String trust_receipt = rs.getString(25);
                String or_payment_no = rs.getString(26);
                String soa_id = rs.getString(27);
                String soa_type = rs.getString(28);
                String soa_type_id = rs.getString(29);
                String reference_no = rs.getString(30);
                String check_date = rs.getString(31);
                String user_id = rs.getString(32);
                String user_screen_name = rs.getString(33);
                double wtax = rs.getDouble(34);
                double tax_rate = rs.getDouble(35);
                double tax_amount = rs.getDouble(36);
                String branch = rs.getString(37);
                String branch_id = rs.getString(38);
                String location = rs.getString(39);
                String location_id = rs.getString(40);

                String customer = customer_name;
                String user = user_screen_name;
                String date = DateType.convert_slash_datetime(date_added);
                String ar_type = soa_type;
                double cash_amounta = amount;
                if (reference_no.isEmpty()) {
                    reference_no = ci_no + trust_receipt;
                }
                Srpt_ar_payments.field field = new field(ar_no, reference_no, customer, user, date, ar_type, cash_amounta, check_amount);
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
