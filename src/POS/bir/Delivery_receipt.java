/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir;

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
public class Delivery_receipt {

    public final List<Delivery_receipt.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String transaction_no;
    public final String date;
    public final String remarks;
    public final String prepared_by;
    public final String approved_by;
    public final double sale_discount;
    public final double net_total;
    public final String customer_name;
    public final String customer_address;

    public Delivery_receipt(String business_name, String address, String contact_no, String transaction_no, String date, String remarks, String prepared_by, String approved_by, double sale_discount, double net_total, String customer_name, String customer_address) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.transaction_no = transaction_no;
        this.date = date;
        this.remarks = remarks;
        this.prepared_by = prepared_by;
        this.approved_by = approved_by;
        this.sale_discount = sale_discount;
        this.net_total = net_total;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
    }

    public static class field {

        double qty;
        String item_code;
        String barcode;
        String description;
        String unit;
        double price;
        double line_discount;
        double addtl_amount;
        double wtax;
        double gross_total;
        double net_total;
        String serial_nos;
        public field() {
        }

        public field(double qty, String item_code, String barcode, String description, String unit, double price, double line_discount
                , double addtl_amount, double wtax, double gross_total, double net_total,String serial_nos) {
            this.qty = qty;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.price = price;
            this.line_discount = line_discount;
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
            this.gross_total = gross_total;
            this.net_total = net_total;
            this.serial_nos=serial_nos;
        }

        
        public String getSerial_nos() {
            return serial_nos;
        }

        public void setSerial_nos(String serial_nos) {
            this.serial_nos = serial_nos;
        }
        
        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

        public double getAddtl_amount() {
            return addtl_amount;
        }

        public void setAddtl_amount(double addtl_amount) {
            this.addtl_amount = addtl_amount;
        }

        public double getWtax() {
            return wtax;
        }

        public void setWtax(double wtax) {
            this.wtax = wtax;
        }

        public double getGross_total() {
            return gross_total;
        }

        public void setGross_total(double gross_total) {
            this.gross_total = gross_total;
        }

        public double getNet_total() {
            return net_total;
        }

        public void setNet_total(double net_total) {
            this.net_total = net_total;
        }

    }

    public static void main(String[] args) {

        List<Delivery_receipt.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            double qty = i;
            String item_code = "11111" + i;
            String barcode = "00000000000" + i;
            String description = "Description " + i;
            String unit = "pc";
            double price = 101000 + i;
            double line_discount = 100;
            double addtl_amount = 10;
            double wtax = 20;
            double gross_total = 1000;
            double net_total = 301000;
            String serial_nos="";
            Delivery_receipt.field field = new field(qty, item_code, barcode, description, unit, price, line_discount, addtl_amount, wtax, gross_total, net_total,serial_nos);
            fields.add(field);
        }

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, national Highway, Dumaguete City");
        String contact_no = "035 22556926 / 422-9026"
                + "\n035 4221953"
                + "\n903-215-145V\n";
        String transaction_no = "133298";
        String date = "01/13/2105";
        String remarks = "SPUD / JOANNA ROSE DECIAR";
        String prepared_by = "";
        String approved_by = "";
        double sale_discount = 1000;
        double net_total = 1000;
        String customer_name = "";
        String customer_address = "";
        Delivery_receipt rpt = new Delivery_receipt(business_name, address, contact_no, transaction_no, date, remarks, prepared_by, approved_by, sale_discount, net_total, customer_name, customer_address);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_delivery_receipt.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Delivery_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Delivery_receipt to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}
