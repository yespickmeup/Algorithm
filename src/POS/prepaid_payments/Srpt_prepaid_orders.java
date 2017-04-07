/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_payments;

import POS.reports3.Srpt_services;
import POS.util.DateType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Maytopacka
 */
public class Srpt_prepaid_orders {

    public final String branch;
    public final String location;
    public final String business_name;
    public final String address;
    public final String date;
    public final String printed_by;
    public final List<field> fields;
    public final String customer_name;
    public final double prepaid;
    public Srpt_prepaid_orders( String branch, String location, String business_name, String address, String date, String printed_by,String customer_name,double prepaid) {
        this.fields = new ArrayList();
        this.branch = branch;
        this.location = location;
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.printed_by = printed_by;
        this.customer_name=customer_name;
        this.prepaid=prepaid;
    }

    public static class field {

        String sales_no;
        String date;
        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double conversion;
        double selling_price;
        double discount;
        double amount;

        public field() {
        }

        public field(String sales_no, String date, String item_code, String barcode, String description, String unit, double qty, double conversion, double selling_price, double discount, double amount) {
            this.sales_no = sales_no;
            this.date = date;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.discount = discount;
            this.amount = amount;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {

        List<Srpt_prepaid_orders.field> datas = new ArrayList();
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String branch = "Dumaguete City";
        String location = "Selling Area";
        String address = "Dumaguete City";
        List<field> fields=new ArrayList();
        Srpt_prepaid_orders rpt = new Srpt_prepaid_orders( branch, location, business_name, address, date, printed_by,"",0);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_prepaid_orders.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_prepaid_orders.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_prepaid_orders to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
    
    
}
