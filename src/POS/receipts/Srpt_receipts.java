/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

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
public class Srpt_receipts {

    public final List<Srpt_receipts.field> fields;
    public final String transaction_no;
    public final String transaction_type;
    public final String supplier;
    public final String receiving_location;
    public final String reference_no;
    public final String date_of_delivery;
    public final String date_received;
    public final double gross;
    public final double discount;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public Srpt_receipts(String transaction_no, String transaction_type, String supplier, String receiving_location, String reference_no
            , String date_of_delivery, String date_received,double gross,double discount,String business_name,String address,String contact_no) {
        this.fields = new ArrayList();
        this.transaction_no = transaction_no;
        this.transaction_type = transaction_type;
        this.supplier = supplier;
        this.receiving_location = receiving_location;
        this.reference_no = reference_no;
        this.date_of_delivery = date_of_delivery;
        this.date_received = date_received;
        this.gross=gross;
        this.discount=discount;
        this.business_name=business_name;
        this.address=address;
        this.contact_no=contact_no;
        
    }

    public static class field {

        double qty;
        String item_code;
        String barcode;
        String description;
        String serial_code;
        double cost;
        double price;

        public field() {
        }

        public field(double qty, String item_code, String barcode, String description, String serial_code, double cost, double price) {
            this.qty = qty;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.serial_code = serial_code;
            this.cost = cost;
            this.price = price;
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

        public String getSerial_code() {
            return serial_code;
        }

        public void setSerial_code(String serial_code) {
            this.serial_code = serial_code;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static void main(String[] args) {

        List<Srpt_receipts.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Srpt_receipts.field f = new field(i, "0001", "00000000001212", "descr", "serail" + i, i, i);
            fields.add(f);
        }
        String transaction_no = "0001";
        String transaction_type = "Transaction Type";
        String supplier = "Supplier";
        String receiving_location = "Location";
        String reference_no = "Reference No";
        String date_of_delivery = "Date of Delivery";
        String date_received = "Date Received";
        double gross=0;
        double discount=0;
        String business_name=System.getProperty("business_name","Algorithm Computer Services");
        String address=System.getProperty("address","Daro, Dumaguete City");
        String contact_no=System.getProperty("contact_no","422-1234");
        Srpt_receipts rpt = new Srpt_receipts(transaction_no, transaction_type, supplier, receiving_location, reference_no
                , date_of_delivery, date_received,gross,discount,business_name,address,contact_no);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_receipts.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_receipts.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_receipts to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}
