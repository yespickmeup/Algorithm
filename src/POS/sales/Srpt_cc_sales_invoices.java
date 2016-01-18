/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

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
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_cc_sales_invoices {

    public final List<Srpt_cc_sales_invoices.field> fields;

    public Srpt_cc_sales_invoices() {
        this.fields = new ArrayList();
    }

    public static class field {

        String or_no;
        String reference_no;
        String customer_name;
        double amount_due;
        double discount;
        double net_due;
        String cash;
        String prepaid;
        String credit_card;
        String cheque;
        String charge;

        public field() {
        }

        public field(String or_no, String reference_no, String customer_name, double amount_due, double discount, double net_due, String cash, String prepaid, String credit_card, String cheque, String charge) {
            this.or_no = or_no;
            this.reference_no = reference_no;
            this.customer_name = customer_name;
            this.amount_due = amount_due;
            this.discount = discount;
            this.net_due = net_due;
            this.cash = cash;
            this.prepaid = prepaid;
            this.credit_card = credit_card;
            this.cheque = cheque;
            this.charge = charge;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
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

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getNet_due() {
            return net_due;
        }

        public void setNet_due(double net_due) {
            this.net_due = net_due;
        }

        public String getCash() {
            return cash;
        }

        public void setCash(String cash) {
            this.cash = cash;
        }

        public String getPrepaid() {
            return prepaid;
        }

        public void setPrepaid(String prepaid) {
            this.prepaid = prepaid;
        }

        public String getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(String credit_card) {
            this.credit_card = credit_card;
        }

        public String getCheque() {
            return cheque;
        }

        public void setCheque(String cheque) {
            this.cheque = cheque;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }
    }

    public static List<Srpt_cc_sales_invoices.field> ret_data(String where) {
        List<Srpt_cc_sales_invoices.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",charge_account_name"
                    + ",charge_amount"
                    + ",charge_account_id"
                    + ",credit_card"
                    + ",credit_card_name"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",sales_type"
                    + ",prepaid_amount"
                    + ",prepaid_customer_id"
                    + ",prepaid_customer_name"
                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String charge_account_name = rs.getString(23);
                double charge_amount = rs.getDouble(24);
                String charge_account_id = rs.getString(25);
                double credit_card = rs.getDouble(26);
                String credit_card_name = rs.getString(27);
                double credit_card_rate = rs.getDouble(28);
                double credit_card_amount = rs.getDouble(29);
                int sales_type = rs.getInt(30);
                double prepaid_amount = rs.getDouble(31);
                String prepaid_customer_id = rs.getString(32);
                String prepaid_customer_name = rs.getString(33);
                double amount_due1 = amount_due;
                double discount1 = discount_amount;
                double net_due1 = amount_due1 - discount1;
                String cash = FitIn.fmt_wc_0(net_due1 - (prepaid_amount + credit_card_amount + check_amount));
                String prepaid = FitIn.fmt_wc_0(prepaid_amount);
                String credit_card1 = FitIn.fmt_wc_0(credit_card_amount);
                String cheque = FitIn.fmt_wc_0(check_amount);
                String charge = FitIn.fmt_wc_0(charge_amount);
                if (charge_amount > 0) {
                    cash = "";
                    prepaid = "";
                    credit_card1 = "";
                    cheque = "";
                }
                Srpt_cc_sales_invoices.field to = new Srpt_cc_sales_invoices.field(or_no, session_no, customer_name, amount_due1
                        , discount1, net_due1, cash, prepaid, credit_card1, cheque, charge);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<Srpt_cc_sales_invoices.field> datas = Srpt_cc_sales_invoices.ret_data("");
        Srpt_cc_sales_invoices rpt = new Srpt_cc_sales_invoices();
        rpt.fields.addAll(datas);

        JRViewer viewer = Srpt_cc_sales_invoices.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static JRViewer get_viewer(Srpt_cc_sales_invoices to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_cc_sales_invoices.jrxml";
            InputStream is = Srpt_cc_sales_invoices.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
