/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import java.io.InputStream;
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
public class Srpt_sales_invoice {

    public final List<Srpt_sales_invoice.field> fields;
    public final String sold_to;
    public final String date;
    public final String address;
    public final String tin;
    public final String business_style;
    public final String terms;
    public final String id_no;
    public final String pwd_sig;
    public final double total_sales;
    public final double discount;
    public final double vatable_sales;
    public final double vatable_amount;
    public final double total_amount_due;

    public Srpt_sales_invoice(String sold_to, String date, String address, String tin, String business_style, String terms, String id_no, String pwd_sig, double total_sales, double discount, double vatable_sales, double vatable_amount, double total_amount_due) {
        this.fields = new ArrayList();
        this.sold_to = sold_to;
        this.date = date;
        this.address = address;
        this.tin = tin;
        this.business_style = business_style;
        this.terms = terms;
        this.id_no = id_no;
        this.pwd_sig = pwd_sig;
        this.total_sales = total_sales;
        this.discount = discount;
        this.vatable_sales = vatable_sales;
        this.vatable_amount = vatable_amount;
        this.total_amount_due = total_amount_due;
    }

    public static class field {

        String qty;
        String unit;
        String articles;
        String unit_price;
        String discount;
        String amount;

        public field() {
        }

        public field(String qty, String unit, String articles, String unit_price, String discount, String amount) {
            this.qty = qty;
            this.unit = unit;
            this.articles = articles;
            this.unit_price = unit_price;
            this.discount = discount;
            this.amount = amount;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getArticles() {
            return articles;
        }

        public void setArticles(String articles) {
            this.articles = articles;
        }

        public String getUnit_price() {
            return unit_price;
        }

        public void setUnit_price(String unit_price) {
            this.unit_price = unit_price;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {

        List<Srpt_sales_invoice.field> fields = new ArrayList();

        String sold_to = "J12";
        String date = "10/06/2014";
        String address = "";
        String tin = "";
        String business_style = "";
        String terms = "";
        String id_no = "";
        String pwd_sig = "";
        double total_sales = 2200;
        double discount = 0;
        double vatable_sales = 1964;
        double vatable_amount = 235.71;
        double total_amount_due = 2200;
        for (int i = 0; i < 10; i++) {
            String qty = "" + i;
            String unit = "PC";
            String articles = " (6833) KVR 1333/4GB";
            String unit_price = "";
            String discount1 = "";
            String amount = "2200.00";
            Srpt_sales_invoice.field to = new field(qty, unit, articles, unit_price, discount1, amount);
            fields.add(to);

        }
        Srpt_sales_invoice rpt = new Srpt_sales_invoice(sold_to, date, address, tin, business_style, terms, id_no, pwd_sig, total_sales, discount, vatable_sales, vatable_amount, total_amount_due);
        rpt.fields.addAll(fields);
        JRViewer viewer = Srpt_sales_invoice.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_sales_invoice to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_sales_invoice.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_sales_invoice to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_invoice.jrxml";
            InputStream is = Srpt_sales_invoice.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
