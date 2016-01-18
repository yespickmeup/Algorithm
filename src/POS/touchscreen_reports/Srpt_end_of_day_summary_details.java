/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

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
public class Srpt_end_of_day_summary_details {

    public final List<Srpt_end_of_day_summary_details.field> fields;

    public Srpt_end_of_day_summary_details() {
        this.fields = new ArrayList();
    }

    public static class field {

        String category;
        String name;
        String credit;
        String debit;

        public field() {
        }

        public field(String category, String name, String credit, String debit) {
            this.category = category;
            this.name = name;
            this.credit = credit;
            this.debit = debit;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        public String getDebit() {
            return debit;
        }

        public void setDebit(String debit) {
            this.debit = debit;
        }

    }

    public static void main(String[] args) {
        List<Srpt_end_of_day_summary_details.field> fields = new ArrayList();
        Srpt_end_of_day_summary_details.field check = new field("Checks", "BPI 000234", "", "1,000.00");
        Srpt_end_of_day_summary_details.field credit_card = new field("Credit Card", "", "", "1,000.00");
        Srpt_end_of_day_summary_details.field gc = new field("Gift Certificate", "", "", "0.00");
        Srpt_end_of_day_summary_details.field remit1 = new field("Remitted", "", "5,000.00", "");
        Srpt_end_of_day_summary_details.field remit2 = new field("Remitted", "", "4,000.00", "");
        Srpt_end_of_day_summary_details.field remit3 = new field("Remitted", "", "4,200.00", "");

        fields.add(check);
        fields.add(credit_card);
        fields.add(gc);
        fields.add(remit1);
        fields.add(remit2);
        fields.add(remit3);

        Srpt_end_of_day_summary_details rpt = new Srpt_end_of_day_summary_details();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_end_of_day_summary_details.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_end_of_day_summary_details.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_end_of_day_summary_details to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
