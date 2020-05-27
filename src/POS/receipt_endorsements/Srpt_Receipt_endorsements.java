/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipt_endorsements;

import POS.receipts.S1_receipt_items;
import POS.reports.Srpt_stock_ledger;
import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author User
 */
public class Srpt_Receipt_endorsements {

    public final String business_name;
    public final String date;
    public final String printed_by;
    public final List<field> fields;
    public final String range;
    public final String type;

    public Srpt_Receipt_endorsements(String business_name, String date, String printed_by, String range, String type) {
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.fields = new ArrayList();
        this.range = range;
        this.type = type;
    }

    public static class field {

        String reference_no;
        String sales_no;
        String sales_date;
        String sales_user;
        String receipt_type;
        String receipt_endorsed_to;
        double sales_amount;

        public field() {
        }

        public field(String reference_no, String sales_no, String sales_date, String sales_user, String receipt_type, String receipt_endorsed_to, double sales_amount) {
            this.reference_no = reference_no;
            this.sales_no = sales_no;
            this.sales_date = sales_date;
            this.sales_user = sales_user;
            this.receipt_type = receipt_type;
            this.receipt_endorsed_to = receipt_endorsed_to;
            this.sales_amount = sales_amount;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public String getSales_date() {
            return sales_date;
        }

        public void setSales_date(String sales_date) {
            this.sales_date = sales_date;
        }

        public String getSales_user() {
            return sales_user;
        }

        public void setSales_user(String sales_user) {
            this.sales_user = sales_user;
        }

        public String getReceipt_type() {
            return receipt_type;
        }

        public void setReceipt_type(String receipt_type) {
            this.receipt_type = receipt_type;
        }

        public String getReceipt_endorsed_to() {
            return receipt_endorsed_to;
        }

        public void setReceipt_endorsed_to(String receipt_endorsed_to) {
            this.receipt_endorsed_to = receipt_endorsed_to;
        }

        public double getSales_amount() {
            return sales_amount;
        }

        public void setSales_amount(double sales_amount) {
            this.sales_amount = sales_amount;
        }
    }

    public static void main(String[] args) {
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
        String where = "";
        List<Srpt_Receipt_endorsements.field> fields = Srpt_Receipt_endorsements.ret_data(where);

        String business_name = System.
                getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String range = "";
        String type = "";
        Srpt_Receipt_endorsements rpt = new Srpt_Receipt_endorsements(business_name, date, printed_by, range, type);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_receipt_endorsements.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_Receipt_endorsements.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_Receipt_endorsements to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_Receipt_endorsements.field> ret_data(String where) {
        List<Srpt_Receipt_endorsements.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_endorsement_id"
                    + ",endorsement_type"
                    + ",receipt_no"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + " from receipt_endorsement_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int receipt_endorsement_id = rs.getInt(2);
                String endorsement_type = rs.getString(3);
                String receipt_no = rs.getString(4);
                String created_at = rs.getString(5);
                String updated_at = rs.getString(6);
                String created_by = rs.getString(7);
                String updated_by = rs.getString(8);
                int status = rs.getInt(9);

                String reference_no = receipt_no;
                String sales_no = "";
                String sales_date = "";
                String sales_user = "";
                String receipt_type = endorsement_type;
                String receipt_endorsed_to = "";
                double sales_amount = 0;

                String where2 = " where ref_or_no like '" + reference_no + "' ";
                if (receipt_type.equalsIgnoreCase("Sales Invoice")) {
                    where2 = " where ref_si_no like '" + reference_no + "' ";
                }
                if (receipt_type.equalsIgnoreCase("Charge Receipt")) {
                    where2 = " where ref_cr_no like '" + reference_no + "' ";
                }
                String s2 = "select "
                        + "id"
                        + ",sales_no"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",amount_due"
                        + " from sales"
                        + " " + where2;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    sales_no = rs2.getString(2);
                    sales_date = DateType.convert_slash_datetime(rs2.getString(3));
                    sales_user = rs2.getString(4);

                    sales_amount = rs2.getDouble(5);

                }

                Srpt_Receipt_endorsements.field field = new field(reference_no, sales_no, sales_date, sales_user, receipt_type, receipt_endorsed_to, sales_amount);
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
