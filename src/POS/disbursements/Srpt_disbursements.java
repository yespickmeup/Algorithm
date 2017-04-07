/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

import POS.reports2.Srpt_customers;
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
public class Srpt_disbursements {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String printed_by;
    public final List<Srpt_disbursements.field> fields;
    public final String branch;
    public final String location;
    public final String user;
    public Srpt_disbursements(String business_name, String address, String contact_no, String date, String printed_by,String branch,String location,String user) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.printed_by = printed_by;
        this.fields = new ArrayList();
        this.branch=branch;
        this.location=location;
        this.user=user;
    }

    public static class field {

        String screen_name;
        String date_added;
        String purpose;
        String category;
        double amount;
        String vat;
        String location;
        public field() {
        }

        public field(String screen_name, String date_added, String purpose, String category, double amount, String vat,String location) {
            this.screen_name = screen_name;
            this.date_added = date_added;
            this.purpose = purpose;
            this.category = category;
            this.amount = amount;
            this.vat = vat;
            this.location=location;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
        
        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getVat() {
            return vat;
        }

        public void setVat(String vat) {
            this.vat = vat;
        }

    }

    public static void main(String[] args) {
        String where = "";
        List<S1_disbursements.to_disbursements> datas = S1_disbursements.ret_data(where);
        List<Srpt_disbursements.field> list = new ArrayList();
        for (S1_disbursements.to_disbursements dis : datas) {
            String screen_name = dis.user_screen_name;
            String date_added = DateType.convert_slash_datetime2(dis.disbursement_date);
            String purpose = dis.purpose;
            String category = dis.category_name;
            double amount = dis.amount;
            String vat = "Yes";
            String location="";
            if (dis.is_vat == 0) {
                vat = "No";
            }
            Srpt_disbursements.field field = new field(screen_name, date_added, purpose, category, amount, vat,location);
            list.add(field);
        }

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro Highway, Dumaguete City");
        String contact_no = System.getProperty("contact_no", "225-1235");
        String date = "January 24, 2016";
        String printed_by = "Administrator";
        String branch="";
        String location="";
        Srpt_disbursements rpt = new Srpt_disbursements(business_name, address, contact_no, date, printed_by,branch,location,"");
        rpt.fields.addAll(list);
        String jrxml = "rpt_disbursement.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_disbursements.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_disbursements to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}
