/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_payments;

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
 * @author Guinness
 */
public class Srpt_prepaid_payments {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String status;
    public final String customer;
    public final String branch;
    public final String location;
    public final List<field> fields;

    public Srpt_prepaid_payments(String business_name, String address, String contact_no, String date, String status, String customer, String branch, String location) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.status = status;
        this.customer = customer;
        this.fields = new ArrayList();
        this.branch = branch;
        this.location = location;
    }

    public static class field {

        String customer_no;
        String customer_name;
        double cash;
        String check_bank;
        String check_no;
        String check_date;
        double check_amount;
        String date_added;
        String added_by;
        String branch;
        String location;
        String status;
        String remarks;

        public field() {
        }

        public field(String customer_no, String customer_name, double cash, String check_bank, String check_no, String check_date, double check_amount, String date_added, String added_by, String branch, String location, String status, String remarks) {
            this.customer_no = customer_no;
            this.customer_name = customer_name;
            this.cash = cash;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_date = check_date;
            this.check_amount = check_amount;
            this.date_added = date_added;
            this.added_by = added_by;
            this.branch = branch;
            this.location = location;
            this.status = status;
            this.remarks = remarks;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCustomer_no() {
            return customer_no;
        }

        public void setCustomer_no(String customer_no) {
            this.customer_no = customer_no;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public String getCheck_bank() {
            return check_bank;
        }

        public void setCheck_bank(String check_bank) {
            this.check_bank = check_bank;
        }

        public String getCheck_no() {
            return check_no;
        }

        public void setCheck_no(String check_no) {
            this.check_no = check_no;
        }

        public String getCheck_date() {
            return check_date;
        }

        public void setCheck_date(String check_date) {
            this.check_date = check_date;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getAdded_by() {
            return added_by;
        }

        public void setAdded_by(String added_by) {
            this.added_by = added_by;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_algorithm");

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String contact_no = System.getProperty("contact_no", "12345676");
        String address = System.getProperty("address", "Daro, Dumaguete City");
        String date = DateType.month_date.format(new Date());
        String status = "All";
        String customer = "All";
        String branch = "Dumaguete City";
        String location = "Selling Area";

        List<Srpt_prepaid_payments.field> datas = Srpt_prepaid_payments.ret_data(" ");

        Srpt_prepaid_payments rpt = new Srpt_prepaid_payments(business_name, address, contact_no, date, status, customer, branch, location);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_customer_prepaid_payments.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_prepaid_payments.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_prepaid_payments to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_prepaid_payments.field> ret_data(String where) {
        List<Srpt_prepaid_payments.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",cash"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",added_by"
                    + ",date_added"
                    + ",customer_name"
                    + ",customer_id"
                    + ",status"
                    + ",cheque_holder"
                    + ",cheque_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",remarks"
                    + " from prepaid_payments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                double cash = rs.getDouble(2);
                String check_bank = rs.getString(3);
                String check_no = rs.getString(4);
                double check_amount = rs.getDouble(5);
                String added_by = rs.getString(6);
                String date_added = rs.getString(7);
                date_added = DateType.convert_slash_datetime(date_added);
                String customer_name = rs.getString(8);
                String customer_id = rs.getString(9);
                int status = rs.getInt(10);
                String cheque_holder = rs.getString(11);
                String cheque_date = rs.getString(12);
                String user_id = rs.getString(13);
                String user_screen_name = rs.getString(14);
                String branch = rs.getString(15);
                String branch_id = rs.getString(16);
                String location = rs.getString(17);
                String location_id = rs.getString(18);
                String remarks = rs.getString(19);
                String status1 = "Posted";
                if (status == 1) {
                    status1 = "Finalized";
                }
                if (status == 2) {
                    status1 = "Void";
                }
                if (cash > 0) {
                    if (remarks.contains("Prepaid Payment")) {
                        cash = cash * -1;
                    }
                } else {
                    if (remarks.contains("Prepaid Payment")) {
                        check_amount = check_amount * -1;
                    }
                }
                Srpt_prepaid_payments.field to = new field(customer_id, customer_name, cash, check_bank, check_no, cheque_date, check_amount,
                                                           date_added, added_by, branch, location, status1, remarks);

                if (status != 2) {
                    datas.add(to);
                }

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
