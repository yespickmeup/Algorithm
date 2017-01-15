/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_purchase_order {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String printed_by;
    public final String date;
    public final String purchase_order_no;
    public final String supplier;
    public final String remarks;
    public final String location;
    public final double gross_amount;
    public final double discount;
    public final List<Srpt_purchase_order.field> fields;

    public Srpt_purchase_order(String business_name, String address, String contact_no, String printed_by, String date, String purchase_order_no, String supplier, String remarks, String location, double gross_amount, double discount) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.printed_by = printed_by;
        this.date = date;
        this.purchase_order_no = purchase_order_no;
        this.supplier = supplier;
        this.remarks = remarks;
        this.location = location;
        this.gross_amount = gross_amount;
        this.discount = discount;
        this.fields = new ArrayList();
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String unit;
        double cost;
        double qty_ordered;

        public field() {
        }

        public field(String item_code, String barcode, String description, String unit, double cost, double qty_ordered) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.cost = cost;
            this.qty_ordered = qty_ordered;
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

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getQty_ordered() {
            return qty_ordered;
        }

        public void setQty_ordered(double qty_ordered) {
            this.qty_ordered = qty_ordered;
        }

    }

    public static void main(String[] args) {

        List<Srpt_purchase_order.field> fields = new ArrayList();
        for (int i = 0; i < 30; i++) {
            String item_code = "0000" + i;
            String barcode = "Code" + i;
            String description = "Item Number " + i;
            String unit = "pc";
            double cost = 100 * i;
            double qty_ordered = 1000 * i;
            Srpt_purchase_order.field to = new Srpt_purchase_order.field(item_code, barcode, description, unit, cost, qty_ordered);
            fields.add(to);
        }

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = "Daro, Dumaguete City, Negros Oriental";
        String contact_no = "422-12345/422-5678";
        String printed_by = "Administrator";
        String date = "January 13, 2016";
        String purchase_order_no = "1|0000000001";
        String supplier = "Supplier";
        String remarks = "";
        String location = "Dumaguete City";
        double gross_amount = 100;
        double discount = 50;
        Srpt_purchase_order rpt = new Srpt_purchase_order(business_name, address, contact_no, printed_by, date, purchase_order_no, supplier, remarks, location, gross_amount, discount);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_purchase_order.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_purchase_order.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_purchase_order to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
