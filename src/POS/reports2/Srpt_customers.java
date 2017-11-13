/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

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
 * @author Ronald
 */
public class Srpt_customers {

    public final List<Srpt_customers.field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;

    public Srpt_customers(String business_name, String date, String printed_by) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
    }

    public static class field {

        String customer_id;
        String customer_name;
        double balance;
        String contact_no;

        public field() {
        }

        public field(String customer_id, String customer_name, double balance, String contact_no) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.balance = balance;
            this.contact_no = contact_no;
        }

        public String getContact_no() {
            return contact_no;
        }

        public void setContact_no(String contact_no) {
            this.contact_no = contact_no;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {

        List<Srpt_customers.field> datas = Srpt_customers.ret_data("");
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        Srpt_customers rpt = new Srpt_customers(business_name, date, printed_by);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_customers.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_customers.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_customers to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_customers.field> ret_data(String where) {
        List<Srpt_customers.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + " from customers "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);

                Srpt_customers.field to = new field(customer_no, customer_name, balance, contact_no);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_customers.field> ret_data_paid(String where, String where2) {
        List<Srpt_customers.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + " from customers  "
                    + " " + where + " order by customer_name asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);

            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                double paid = 0;

                String s2 = "select "
                        + "id"
                        + ",amount"
                        + ",discount_amount"
                        + ",date_paid"
                        + ",check_amount"
                        + " from accounts_receivable_payments"
                            + " where customer_id='" + customer_no + "' and status=0 "
                        + " " + where2;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
//                System.out.println("s2: " + s2);
                while (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    double amount = rs2.getDouble(2);
                    double discount_amount = rs2.getDouble(3);
                    String date_paid = rs2.getString(4);
                    double check_amount = rs2.getDouble(5);

                    double total = (amount + check_amount) + discount;
//                    System.out.println("    date_paid: " + date_paid + " = " + total);
                    paid += total;
                }
//                System.out.println("paid: "+paid);
                Srpt_customers.field to = new field(customer_no, customer_name, paid, contact_no);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
