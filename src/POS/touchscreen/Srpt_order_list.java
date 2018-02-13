/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

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
 * @author Guinness
 */
public class Srpt_order_list {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String customer_name;
    public final List<field> fields;
    public final double amount_due;
    public final double discount;
    public final double net_due;
    public final double line_discount;
    public Srpt_order_list(String business_name, String address, String contact_no, String date, String customer_name,double amount_due,double discount,double net_due,double line_discount) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.customer_name = customer_name;
        this.fields = new ArrayList();
        this.amount_due=amount_due;
        this.discount=discount;
        this.net_due=net_due;
        this.line_discount=line_discount;
    }

    public static class field {

        String item_code;
        String description;
        String unit;
        double qty;
        double selling_price;
        double discount;
        double amount;

        public field() {
        }

        public field(String item_code, String description, String unit, double qty, double selling_price, double discount, double amount) {
            this.item_code = item_code;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.selling_price = selling_price;
            this.discount = discount;
            this.amount = amount;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
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

        List<Srpt_order_list.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String item_code = "000" + i;

            String description = "Nature Spring Mineral Walter - Green " + i;
            String unit = "pc";
            double qty = i;
            double selling_price = 10 * i;
            double discount = 0;
            double amount = (qty * selling_price) - discount;
            Srpt_order_list.field field = new field(item_code, description, unit, qty, selling_price, discount, amount);
            fields.add(field);
        }
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");

        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        String contact_no = System.getProperty("contact_no", "7871-78774/4544-989745");
        String date = DateType.slash_w_time.format(new Date());
        String customer_name = "Juan Dela Cruz";
        double amount_due=100;
        double discount=50;
        double net_due=50;
        double line_discount=0;
        Srpt_order_list rpt = new Srpt_order_list(business_name, address, contact_no, date, customer_name,amount_due,discount,net_due,line_discount);
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_order_list.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_order_list to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_receipt.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_order_list to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_order_list_amount.jrxml";
            InputStream is = Srpt_order_list.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
