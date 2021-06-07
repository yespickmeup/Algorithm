/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rma;

import POS.requisition_slips.Srpt_requisition_slip;
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
 * @author User
 */
public class Srpt_rma_serials {

    public final String business_name;
    public final String address;
    public final String category;
    public final String classification;
    public final String sub_classification;
    public final String brand;
    public final String model;
    public final String date;
    public final List<field> fields;

    public Srpt_rma_serials(String business_name, String address, String category, String classification, String sub_classification, String brand, String model
    ,String date) {
        this.business_name = business_name;
        this.address = address;
        this.category = category;
        this.classification = classification;
        this.sub_classification = sub_classification;
        this.brand = brand;
        this.model = model;
        this.date=date;
        this.fields = new ArrayList();
    }

    public static class field {

        String transaction_no;
        String type;
        String item_code;
        String description;
        double qty;
        String serials;
        String customer_name;
        String date;
        public field() {
        }

        public field(String transaction_no, String type, String item_code, String description, double qty, String serials,String customer_name,String date) {
            this.transaction_no = transaction_no;
            this.type = type;
            this.item_code = item_code;
            this.description = description;
            this.qty = qty;
            this.serials = serials;
            this.customer_name=customer_name;
            this.date=date;
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

        
        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getSerials() {
            return serials;
        }

        public void setSerials(String serials) {
            this.serials = serials;
        }

    }

    public static void main(String[] args) {

        List<Srpt_rma_serials.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String item_code = "0000";
            String description = "description";

            double qty = 100;
            String serials = "11232398829323,23230121213223,2323230";
            String customer_name="";
            Srpt_rma_serials.field field = new field("000001", "Sales", item_code, description, qty, serials,customer_name,"");
            fields.add(field);

        }

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Dumaguete City");
        String category = "All";
        String classification = "All";
        String sub_classification = "All";
        String brand = "All";
        String model = "All";
        String date="";
        Srpt_rma_serials rpt = new Srpt_rma_serials(business_name, address, category, classification, sub_classification, brand, model,date);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_rma_serials.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_rma_serials.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_rma_serials to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
