/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

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
public class Srpt_sales_on_account {

    public final List<field> fields;
    public final String date;

    public Srpt_sales_on_account(String date) {
        this.fields = new ArrayList();
        this.date = date;
    }

    public static class field {

        String type;
        String date;
        String reference_no;
        String client;
        double amount;

        public field() {
        }

        public field(String type, String date, String reference_no, String client, double amount) {
            this.type = type;
            this.date = date;
            this.reference_no = reference_no;
            this.client = client;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
        }

        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {
        List<field> fields = Srpt_sales_on_account.ret_data("");
        String date = "";
        Srpt_sales_on_account rpt = new Srpt_sales_on_account(date);
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_ar_aging2 to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_ar_aging2.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_sales_on_account to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_on_account_report.jrxml";
            InputStream is = Srpt_sales_on_account.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_sales_on_account.field> ret_data(String where) {
        List<Srpt_sales_on_account.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",soa_date"
                    + ",date_added"
                    + ",added_by"
                    + ",reference_no"
                    + ",client_name"
                    + ",client_id"
                    + ",amount"
                    + " from sales_on_account  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String soa_type = rs.getString(2);
                String soa_type_id = rs.getString(3);
                String soa_date = DateType.convert_slash_datetime2(rs.getString(4));
                String date_added = rs.getString(5);
                String added_by = rs.getString(6);
                String reference_no = rs.getString(7);
                String client_name = rs.getString(8);
                String client_id = rs.getString(9);
                double amount = rs.getDouble(10);
                Srpt_sales_on_account.field f = new Srpt_sales_on_account.field(soa_type, soa_date, reference_no, client_name, amount);
                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
