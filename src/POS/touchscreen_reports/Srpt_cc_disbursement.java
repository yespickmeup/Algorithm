/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.disbursements.S1_disbursements.to_disbursements;
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
public class Srpt_cc_disbursement {

    public final List<Srpt_cc_disbursement.field> fields;

    public Srpt_cc_disbursement() {
        this.fields = new ArrayList();
    }

    public static class field {

        String disbursement_date;
        String purpose;
        String category_name;
        double amount;
        String is_vat;

        public field() {
        }

        public field(String disbursement_date, String purpose, String category_name, double amount, String is_vat) {
            this.disbursement_date = disbursement_date;
            this.purpose = purpose;
            this.category_name = category_name;
            this.amount = amount;
            this.is_vat = is_vat;
        }

        public String getDisbursement_date() {
            return disbursement_date;
        }

        public void setDisbursement_date(String disbursement_date) {
            this.disbursement_date = disbursement_date;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getIs_vat() {
            return is_vat;
        }

        public void setIs_vat(String is_vat) {
            this.is_vat = is_vat;
        }
    }

    public static void main(String[] args) {
        List<Srpt_cc_disbursement.field> fields = Srpt_cc_disbursement.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cc_disbursement rpt = new Srpt_cc_disbursement();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cc_disbursement.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cc_disbursement.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc_disbursement to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_disbursement.field> ret_data(String where) {
        List<Srpt_cc_disbursement.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",purpose"
                    + ",category_id"
                    + ",category_name"
                    + ",amount"
                    + ",is_vat"
                    + ",disbursement_date"
                    + " from disbursements"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String purpose = rs.getString(5);
                String category_id = rs.getString(6);
                String category_name = rs.getString(7);
                double amount = rs.getDouble(8);
                int is_vat = rs.getInt(9);
                String disbursement_date = rs.getString(10);

                String disbursement_date1 = DateType.convert_slash_datetime2(disbursement_date);
                String purpose1 = purpose;
                String category_name1 = category_name;
                double amount1 = amount;
                String is_vat1 = "No";
                if (is_vat == 1) {
                    is_vat1 = "Yes";
                }
                Srpt_cc_disbursement.field field = new field(disbursement_date1, purpose1, category_name1, amount1, is_vat1);
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
