/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.cash_drawer.CashDrawer_gift_certificates;
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
public class Srpt_cc_gc {

    public final List<Srpt_cc_gc.field> fields;

    public Srpt_cc_gc() {
        this.fields = new ArrayList();
    }

    public static class field {

        String from;
        String description;
        String gc_no;
        double amount;

        public field() {
        }

        public field(String from, String description, String gc_no, double amount) {
            this.from = from;
            this.description = description;
            this.gc_no = gc_no;
            this.amount = amount;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getGc_no() {
            return gc_no;
        }

        public void setGc_no(String gc_no) {
            this.gc_no = gc_no;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {
        List<Srpt_cc_gc.field> fields = Srpt_cc_gc.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cc_gc rpt = new Srpt_cc_gc();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cc_gc.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cc_gc.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc_gc to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_gc.field> ret_data(String where) {
        List<Srpt_cc_gc.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",gc_from"
                    + ",gc_description"
                    + ",gc_no"
                    + ",amount"
                    + " from cash_drawer_gift_certificates"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String gc_from = rs.getString(5);
                String gc_description = rs.getString(6);
                String gc_no = rs.getString(7);
                double amount = rs.getDouble(8);

                String from = gc_from;
                String description = gc_description;
                String gc_no1 = gc_no;
                double amount1 = amount;

                Srpt_cc_gc.field field = new field(from, description, gc_no1, amount1);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_cc_gc.field> ret_data(List<CashDrawer_gift_certificates.to_cash_drawer_gift_certificates> fields) {
        List<Srpt_cc_gc.field> datas = new ArrayList();
        for (CashDrawer_gift_certificates.to_cash_drawer_gift_certificates to : fields) {
            Srpt_cc_gc.field field = new field(to.gc_from, to.gc_description, to.gc_no, to.amount);
            datas.add(field);
        }
        return datas;

    }
}
