/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.sales.Sales.to_sales;
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
public class Srpt_sales_ledger {

    public final List<Srpt_sales_ledger.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;

    public Srpt_sales_ledger(String business_name, String address, String contact_no, String date, String branch, String location) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch = branch;
        this.location = location;
    }

    public static class field {

        String sales_no;
        String customer_id;
        String customer_name;
        double amount_due;
        double line_discount;
        double sales_discount;
        double cash;
        double charge_amount;
        double cheque_amount;
        double credit_card_amount;
        double gc_amount;
        double prepaid_amount;
        double balance_due;
        String user_screen_name;
        public field() {
        }

        public field(String sales_no, String customer_id, String customer_name, double amount_due
                , double line_discount, double sales_discount, double cash, double charge_amount
                , double cheque_amount, double credit_card_amount, double gc_amount
                , double prepaid_amount, double balance_due,String user_screen_name) {
            this.sales_no = sales_no;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.amount_due = amount_due;
            this.line_discount = line_discount;
            this.sales_discount = sales_discount;
            this.cash = cash;
            this.charge_amount = charge_amount;
            this.cheque_amount = cheque_amount;
            this.credit_card_amount = credit_card_amount;
            this.gc_amount = gc_amount;
            this.prepaid_amount = prepaid_amount;
            this.balance_due = balance_due;
            this.user_screen_name=user_screen_name;
        }

        public String getUser_screen_name() {
            return user_screen_name;
        }

        public void setUser_screen_name(String user_screen_name) {
            this.user_screen_name = user_screen_name;
        }

        
        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
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

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

        public double getSales_discount() {
            return sales_discount;
        }

        public void setSales_discount(double sales_discount) {
            this.sales_discount = sales_discount;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getCharge_amount() {
            return charge_amount;
        }

        public void setCharge_amount(double charge_amount) {
            this.charge_amount = charge_amount;
        }

        public double getCheque_amount() {
            return cheque_amount;
        }

        public void setCheque_amount(double cheque_amount) {
            this.cheque_amount = cheque_amount;
        }

        public double getCredit_card_amount() {
            return credit_card_amount;
        }

        public void setCredit_card_amount(double credit_card_amount) {
            this.credit_card_amount = credit_card_amount;
        }

        public double getGc_amount() {
            return gc_amount;
        }

        public void setGc_amount(double gc_amount) {
            this.gc_amount = gc_amount;
        }

        public double getPrepaid_amount() {
            return prepaid_amount;
        }

        public void setPrepaid_amount(double prepaid_amount) {
            this.prepaid_amount = prepaid_amount;
        }

        public double getBalance_due() {
            return balance_due;
        }

        public void setBalance_due(double balance_due) {
            this.balance_due = balance_due;
        }

    }

    public static void main(String[] args) {

        List<Srpt_sales_ledger.field> fields = Srpt_sales_ledger.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        String branch = "";
        String location = "";
        Srpt_sales_ledger rpt = new Srpt_sales_ledger(business_name, address, contact_no, date, branch, location);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_sales_ledger.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_sales_ledger.field> ret_data(String where) {
        List<Srpt_sales_ledger.field> fields = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",session_no"
                    + ",remarks"
                    + ",gross_amount"
                    + ",amount_due"
                    + ",status"
                    + ",sales_type"
                    + ",line_discount"
                    + ",customer_id"
                    + ",customer_name"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",charge_type"
                    + ",charge_type_id"
                    + ",charge_reference_no"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",credit_card_type"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + ",gift_certificate_from"
                    + ",gift_certificate_description"
                    + ",gift_certificate_no"
                    + ",gift_certificate_amount"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String user_id = rs.getString(5);
                String session_no = rs.getString(6);
                String remarks = rs.getString(7);
                double gross_amount = rs.getDouble(8);
                double amount_due = rs.getDouble(9);
                int status = rs.getInt(10);
                int sales_type = rs.getInt(11);
                double line_discount = rs.getDouble(12);
                String customer_id = rs.getString(13);
                String customer_name = rs.getString(14);
                String discount_name = rs.getString(15);
                double discount_rate = rs.getDouble(16);
                double discount_amount = rs.getDouble(17);
                String discount_customer_name = rs.getString(18);
                String discount_customer_id = rs.getString(19);
                String charge_type = rs.getString(20);
                String charge_type_id = rs.getString(21);
                String charge_reference_no = rs.getString(22);
                String charge_customer_name = rs.getString(23);
                String charge_customer_id = rs.getString(24);
                double charge_amount = rs.getDouble(25);
                String check_bank = rs.getString(26);
                String check_no = rs.getString(27);
                double check_amount = rs.getDouble(28);
                String credit_card_type = rs.getString(29);
                double credit_card_rate = rs.getDouble(30);
                double credit_card_amount = rs.getDouble(31);
                String credit_card_no = rs.getString(32);
                String credit_card_holder = rs.getString(33);
                String credit_card_approval_code = rs.getString(34);
                String gift_certificate_from = rs.getString(35);
                String gift_certificate_description = rs.getString(36);
                String gift_certificate_no = rs.getString(37);
                double gift_certificate_amount = rs.getDouble(38);
                String prepaid_customer_name = rs.getString(39);
                String prepaid_customer_id = rs.getString(40);
                double prepaid_amount = rs.getDouble(41);

                double sales_discount = discount_amount;
                double cash = amount_due - (charge_amount + check_amount + credit_card_amount + gift_certificate_amount + prepaid_amount);
                double cheque_amount = check_amount;
                double gc_amount = gift_certificate_amount;
                double balance_due = amount_due;

                Srpt_sales_ledger.field field = new field(sales_no, customer_id, customer_name, gross_amount, line_discount, sales_discount, cash, charge_amount, cheque_amount, credit_card_amount, gc_amount, prepaid_amount, balance_due,user_screen_name);
                fields.add(field);
            }
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    
}
