/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.sales.Sales_item.to_sales_item;
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
public class Srpt_sales_ledger {

    public final List<Srpt_sales_ledger.field> fields;
    public final String sales_date;

    public Srpt_sales_ledger(String sales_date) {
        this.fields = new ArrayList();
        this.sales_date = sales_date;
    }

    public static class field {

        String or_no;
        String date;
        String customer_name;
        double amount_due;
        double discount;
        double cash;
        double credit_card;
        double check;
        double net_due;

        public field() {
        }

        public field(String or_no, String date, String customer_name, double amount_due, double discount, double cash, double credit_card, double check, double net_due) {
            this.or_no = or_no;
            this.date = date;
            this.customer_name = customer_name;
            this.amount_due = amount_due;
            this.discount = discount;
            this.cash = cash;
            this.credit_card = credit_card;
            this.check = check;
            this.net_due = net_due;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

        public double getCheck() {
            return check;
        }

        public void setCheck(double check) {
            this.check = check;
        }

        public double getNet_due() {
            return net_due;
        }

        public void setNet_due(double net_due) {
            this.net_due = net_due;
        }

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_ledger.jrxml";
            InputStream is = Srpt_sales_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String sales_date = "Sales Ledger Report as of [08/09/2014] - [08/09/2014]";
        Srpt_sales_ledger rpt = new Srpt_sales_ledger(sales_date);
        List<Srpt_sales_ledger.field> fields = ret_data("");
        rpt.fields.addAll(fields);
        JRViewer viewer = Srpt_sales_ledger.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_sales_ledger to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_sales_ledger.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_sales_ledger to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static List<Srpt_sales_ledger.field> ret_data(String where) {
        List<Srpt_sales_ledger.field> datas = new ArrayList();

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
                int sales_type=rs.getInt(30);
                
                
                String date = DateType.convert_slash_datetime(date_added);
                double cash = (amount_due - discount_amount) - (check_amount + credit_card);
                double credit_card1 = credit_card;
                double check = check_amount;
                double net_due = amount_due - discount_amount;
                Srpt_sales_ledger.field field = new field(or_no, date, discount_customer_name, amount_due, discount_amount, cash, credit_card1, check, net_due);
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
