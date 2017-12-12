/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

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
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Srpt_disbursements_category {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String printed_by;
    public final String branch;
    public final String location;
    public final List<field> fields;

    public Srpt_disbursements_category(String business_name, String address, String contact_no, String date, String printed_by, String branch, String location) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.printed_by = printed_by;
        this.branch = branch;
        this.location = location;
        this.fields = new ArrayList();
    }

    public static class field {

        String date;
        String added_by;
        String purpose;
        String category_id;
        String category_name;
        double amount;
        int is_vat;
        String disbursement_date;

        public field() {
        }

        public field(String date, String added_by, String purpose, String category_id, String category_name, double amount, int is_vat, String disbursement_date) {
            this.date = date;
            this.added_by = added_by;
            this.purpose = purpose;
            this.category_id = category_id;
            this.category_name = category_name;
            this.amount = amount;
            this.is_vat = is_vat;
            this.disbursement_date = disbursement_date;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAdded_by() {
            return added_by;
        }

        public void setAdded_by(String added_by) {
            this.added_by = added_by;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
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

        public int getIs_vat() {
            return is_vat;
        }

        public void setIs_vat(int is_vat) {
            this.is_vat = is_vat;
        }

        public String getDisbursement_date() {
            return disbursement_date;
        }

        public void setDisbursement_date(String disbursement_date) {
            this.disbursement_date = disbursement_date;
        }
    }

    public static void main(String[] args) {

        System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");
        
        String where = " where YEAR(disbursement_date)='2017' and MONTH(disbursement_date)='11' group by category_name order by category_name asc ";
        List<Srpt_disbursements_category.field> datas = Srpt_disbursements_category.ret_data(where);

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro Highway, Dumaguete City");
        String contact_no = System.getProperty("contact_no", "225-1235");
        String date = "January 24, 2016";
        String printed_by = "Administrator";
        String branch = "";
        String location = "";
        Srpt_disbursements_category rpt = new Srpt_disbursements_category(business_name, address, contact_no, date, printed_by, branch, location);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_disbursement_category.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_disbursements_category.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_disbursements_category to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_disbursements_category.field> ret_data(String where) {
        List<Srpt_disbursements_category.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",purpose"
                    + ",ifnull(category_id,0)"
                    + ",category_name"
                    + ",sum(amount)"
                    + ",is_vat"
                    + ",disbursement_date"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
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
                String branch = rs.getString(11);
                String branch_id = rs.getString(12);
                String location = rs.getString(13);
                String location_id = rs.getString(14);

                String date = date_added;
                String added_by = user_screen_name;

                disbursement_date = DateType.convert_slash_datetime2(disbursement_date);

                Srpt_disbursements_category.field f = new field(date, added_by, purpose, category_id, category_name, amount, is_vat, disbursement_date);
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
