/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

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
public class Srpt_ar_payment_ledger {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String status;
    public final List<field> fields;

    public Srpt_ar_payment_ledger(String business_name, String address, String contact_no, String date, String status) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.fields = new ArrayList();
        this.date = date;
        this.status = status;
    }

    public static class field {

        String customer_id;
        String customer_name;
        String ar_no;
        String date_added;
        String date_applied;
        double amount;
        double discount_amount;
        double check_amount;
        String check_date;
        String soa_type;
        String reference_no;
        String added_by;
        String status;
        double prepaid;
        double credit_card;
        double gc;
        double online;
        double retention;
        double business_tax;

        public field() {
        }

        public field(String customer_id, String customer_name, String ar_no, String date_added, String date_applied, double amount, double discount_amount, double check_amount, String check_date, String soa_type, String reference_no, String added_by, String status, double prepaid, double credit_card, double gc, double online, double retention, double business_tax) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.ar_no = ar_no;
            this.date_added = date_added;
            this.date_applied = date_applied;
            this.amount = amount;
            this.discount_amount = discount_amount;
            this.check_amount = check_amount;
            this.check_date = check_date;
            this.soa_type = soa_type;
            this.reference_no = reference_no;
            this.added_by = added_by;
            this.status = status;
            this.prepaid = prepaid;
            this.credit_card = credit_card;
            this.gc = gc;
            this.online = online;
            this.retention = retention;
            this.business_tax = business_tax;
        }

        public double getPrepaid() {
            return prepaid;
        }

        public void setPrepaid(double prepaid) {
            this.prepaid = prepaid;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

        public double getGc() {
            return gc;
        }

        public void setGc(double gc) {
            this.gc = gc;
        }

        public double getOnline() {
            return online;
        }

        public void setOnline(double online) {
            this.online = online;
        }

        public double getRetention() {
            return retention;
        }

        public void setRetention(double retention) {
            this.retention = retention;
        }

        public double getBusiness_tax() {
            return business_tax;
        }

        public void setBusiness_tax(double business_tax) {
            this.business_tax = business_tax;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getAr_no() {
            return ar_no;
        }

        public void setAr_no(String ar_no) {
            this.ar_no = ar_no;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getDate_applied() {
            return date_applied;
        }

        public void setDate_applied(String date_applied) {
            this.date_applied = date_applied;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

        public String getCheck_date() {
            return check_date;
        }

        public void setCheck_date(String check_date) {
            this.check_date = check_date;
        }

        public String getSoa_type() {
            return soa_type;
        }

        public void setSoa_type(String soa_type) {
            this.soa_type = soa_type;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
        }

        public String getAdded_by() {
            return added_by;
        }

        public void setAdded_by(String added_by) {
            this.added_by = added_by;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

    public static void main(String[] args) {

        System.setProperty("pool_db", "db_algorithm");

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City");
        String contact_no = System.getProperty("contact_no", "1234-567-8910");
        String date = "02/13/2018";
        String status = "All";

        String where = " where p.status=1 ";
        List<Srpt_ar_payment_ledger.field> datas = Srpt_ar_payment_ledger.ret_data(where);

        Srpt_ar_payment_ledger rpt = new Srpt_ar_payment_ledger(business_name, address, contact_no, date, status);

        rpt.fields.addAll(datas);
        String jrxml = "rpt_ar_payment_ledger.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_ar_payment_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_ar_payment_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_ar_payment_ledger.field> ret_data(String where) {
        List<Srpt_ar_payment_ledger.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " p.id"
                    + ",p.customer_id"
                    + ",p.customer_name"
                    + ",p.ar_no"
                    + ",p.date_added"
                    + ",p.user_name"
                    + ",p.amount"
                    + ",p.discount_amount"
                    + ",p.discount_rate"
                    + ",p.discount"
                    + ",p.status"
                    + ",p.term"
                    + ",p.date_applied"
                    + ",p.paid"
                    + ",p.date_paid"
                    + ",p.remarks"
                    + ",p.type"
                    + ",p.or_no"
                    + ",p.prev_balance"
                    + ",p.check_amount"
                    + ",p.check_holder"
                    + ",p.check_bank"
                    + ",p.check_no"
                    + ",p.ci_no"
                    + ",p.trust_receipt"
                    + ",p.or_payment_no"
                    + ",p.soa_id"
                    + ",p.soa_type"
                    + ",p.soa_type_id"
                    + ",p.reference_no"
                    + ",p.check_date"
                    + ",p.user_id"
                    + ",p.user_screen_name"
                    + ",p.wtax"
                    + ",p.tax_rate"
                    + ",p.tax_amount"
                    + ",p.branch"
                    + ",p.branch_id"
                    + ",p.location"
                    + ",p.location_id"
                    + ",ar.term"
                    + ",p.prepaid_amount"
                    + ",p.credit_card_amount"
                    + ",p.gift_certificate_amount"
                    + ",p.online_amount"
                    + " from accounts_receivable_payments p "
                    + " join accounts_receivable ar "
                    + " on ar.ar_no=p.ar_no "
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
                String term2 = rs.getString(41);
                String added_by = user_screen_name;
                int days = 0;

                date_applied = DateType.convert_slash_datetime2(date_applied);

                String status1 = "Posted";
                if (status == 0) {
                    status1 = "Finalized";
                }
                double prepaid = rs.getDouble(42);
                double credit_card = rs.getDouble(43);
                double gc = rs.getDouble(44);
                double online = rs.getDouble(45);
                double retention = 0;
                double business_tax = 0;

                Srpt_ar_payment_ledger.field field = new field(customer_id, customer_name, ar_no, date_added, date_applied, amount, discount_amount, check_amount,
                                                               check_date, soa_type, reference_no, added_by, status1, prepaid, credit_card, gc, online, retention, business_tax);
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
