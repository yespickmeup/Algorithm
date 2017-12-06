/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

import POS.util.DateUtils1;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Srpt_check_payments {

    public final String business_name;
    public final String date;
    public final String printed_by;
    public final List<field> fields;
    public final double total_check_payments;
    public final double post_dated_checks;
    public final double on_dated_checks;
    public final String check_type;
    public final String customer;

    public Srpt_check_payments(String business_name, String date, String printed_by, double total_check_payments, double post_dated_checks, double on_dated_checks, String check_type, String customer) {
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.fields = new ArrayList();
        this.total_check_payments = total_check_payments;
        this.post_dated_checks = post_dated_checks;
        this.on_dated_checks = on_dated_checks;
        this.check_type = check_type;
        this.customer = customer;
    }

    public static class field {

        String customer_id;
        String customer_name;
        String ar_no;
        String date_added;
        String added_by;
        String date_applied;
        String date_paid;
        double check_amount;
        String check_holder;
        String check_bank;
        String check_no;
        String check_date;
        double tax_rate;
        double tax_amount;
        String reference_no;
        String soa_type;
        String branch;
        String branch_id;
        String location;
        String location_id;
        int days;
        String term;

        public field() {
        }

        public field(String customer_id, String customer_name, String ar_no, String date_added, String added_by, String date_applied, String date_paid, double check_amount, String check_holder, String check_bank, String check_no, String check_date, double tax_rate, double tax_amount, String reference_no, String soa_type, String branch, String branch_id, String location, String location_id, int days, String term) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.ar_no = ar_no;
            this.date_added = date_added;
            this.added_by = added_by;
            this.date_applied = date_applied;
            this.date_paid = date_paid;
            this.check_amount = check_amount;
            this.check_holder = check_holder;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_date = check_date;
            this.tax_rate = tax_rate;
            this.tax_amount = tax_amount;
            this.reference_no = reference_no;
            this.soa_type = soa_type;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.days = days;
            this.term = term;
        }

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
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

        public String getAr_no() {
            return ar_no;
        }

        public void setAr_no(String ar_no) {
            this.ar_no = ar_no;
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

        public String getDate_applied() {
            return date_applied;
        }

        public void setDate_applied(String date_applied) {
            this.date_applied = date_applied;
        }

        public String getDate_paid() {
            return date_paid;
        }

        public void setDate_paid(String date_paid) {
            this.date_paid = date_paid;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

        public String getCheck_holder() {
            return check_holder;
        }

        public void setCheck_holder(String check_holder) {
            this.check_holder = check_holder;
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

        public double getTax_rate() {
            return tax_rate;
        }

        public void setTax_rate(double tax_rate) {
            this.tax_rate = tax_rate;
        }

        public double getTax_amount() {
            return tax_amount;
        }

        public void setTax_amount(double tax_amount) {
            this.tax_amount = tax_amount;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
        }

        public String getSoa_type() {
            return soa_type;
        }

        public void setSoa_type(String soa_type) {
            this.soa_type = soa_type;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(String branch_id) {
            this.branch_id = branch_id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }
    }

    public static void main(String[] args) {
//        System.setProperty("pool_db", "db_algorithm");
        List<Srpt_check_payments.field> datas = Srpt_check_payments.ret_data(" where check_amount>0 ");// Srpt_customers.ret_data("");
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = POS.util.DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String customer_id = "";
        String customer_name = "";
        double balance = 0;
        double total_check_payments = 0;
        double post_dated_checks = 0;
        double on_dated_checks = 0;
        String check_type = "All";
        String customer = "";
        Srpt_check_payments rpt = new Srpt_check_payments(business_name, date, printed_by, total_check_payments, post_dated_checks, on_dated_checks, check_type, customer);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_check_payments.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_check_payments.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_check_payments to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<field> ret_data(String where) {
        List<field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " p.id"
                    + ",p.customer_id"
                    + ",p.customer_name"
                    + ",p.ar_no"
                    + ",p.date_added"
                    + ",p.user_name"
                    + ",p.amount"
                    + ",p.discount_amount"
                    + ",p.discount_rate"
                    + ",p.discount"
                    + ",p.status"
                    + ",p.term"
                    + ",p.date_applied"
                    + ",p.paid"
                    + ",p.date_paid"
                    + ",p.remarks"
                    + ",p.type"
                    + ",p.or_no"
                    + ",p.prev_balance"
                    + ",p.check_amount"
                    + ",p.check_holder"
                    + ",p.check_bank"
                    + ",p.check_no"
                    + ",p.ci_no"
                    + ",p.trust_receipt"
                    + ",p.or_payment_no"
                    + ",p.soa_id"
                    + ",p.soa_type"
                    + ",p.soa_type_id"
                    + ",p.reference_no"
                    + ",p.check_date"
                    + ",p.user_id"
                    + ",p.user_screen_name"
                    + ",p.wtax"
                    + ",p.tax_rate"
                    + ",p.tax_amount"
                    + ",p.branch"
                    + ",p.branch_id"
                    + ",p.location"
                    + ",p.location_id"
                    + ",ar.term"
                    + " from accounts_receivable_payments p "
                    + " join accounts_receivable ar "
                    + " on ar.ar_no=p.ar_no "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                double amount = rs.getDouble(7);
                double discount_amount = rs.getDouble(8);
                double discount_rate = rs.getDouble(9);
                String discount = rs.getString(10);
                int status = rs.getInt(11);
                double term = rs.getDouble(12);
                String date_applied = rs.getString(13);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                double prev_balance = rs.getDouble(19);
                double check_amount = rs.getDouble(20);
                String check_holder = rs.getString(21);
                String check_bank = rs.getString(22);
                String check_no = rs.getString(23);
                String ci_no = rs.getString(24);
                String trust_receipt = rs.getString(25);
                String or_payment_no = rs.getString(26);
                String soa_id = rs.getString(27);
                String soa_type = rs.getString(28);
                String soa_type_id = rs.getString(29);
                String reference_no = rs.getString(30);
                String check_date = rs.getString(31);
                String user_id = rs.getString(32);
                String user_screen_name = rs.getString(33);
                double wtax = rs.getDouble(34);
                double tax_rate = rs.getDouble(35);
                double tax_amount = rs.getDouble(36);
                String branch = rs.getString(37);
                String branch_id = rs.getString(38);
                String location = rs.getString(39);
                String location_id = rs.getString(40);
                String term2 = rs.getString(41);
                String added_by = user_screen_name;
                int days = 0;
                Date d = new Date();
                Date d2 = new Date();
                if (check_date != null) {
                    try {
                        d = DateType.sf.parse(check_date);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_check_payments.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (date_applied != null) {
                    try {
                        d2 = DateType.sf.parse(date_applied);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_check_payments.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                days = DateUtils1.count_days(d, new Date());

                if (date_applied != null) {
                    date_applied = DateType.convert_slash_datetime2(date_applied);
                } else {
                    date_applied = "";
                }
                if (check_date != null) {
                    check_date = DateType.convert_slash_datetime2(check_date);
                } else {
                    check_date = "";
                }
                Srpt_check_payments.field f = new field(customer_id, customer_name, ar_no, date_added, added_by, date_applied, date_paid, check_amount, check_holder, check_bank, check_no, check_date, tax_rate, tax_amount, reference_no, soa_type, branch, branch_id, location, location_id, days, term2);
                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<field> ret_data_payable(String where) {
        List<field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " p.id"
                    + ",p.customer_id"
                    + ",p.customer_name"
                    + ",p.ar_no"
                    + ",p.date_added"
                    + ",p.user_name"
                    + ",p.amount"
                    + ",p.discount_amount"
                    + ",p.discount_rate"
                    + ",p.discount"
                    + ",p.status"
                    + ",p.term"
                    + ",p.date_applied"
                    + ",p.paid"
                    + ",p.date_paid"
                    + ",p.remarks"
                    + ",p.type"
                    + ",p.or_no"
                    + ",p.prev_balance"
                    + ",p.check_amount"
                    + ",p.check_holder"
                    + ",p.check_bank"
                    + ",p.check_no"
                    + ",p.ci_no"
                    + ",p.trust_receipt"
                    + ",p.or_payment_no"
                    + ",p.soa_id"
                    + ",p.soa_type"
                    + ",p.soa_type_id"
                    + ",p.reference_no"
                    + ",p.check_date"
                    + ",p.user_id"
                    + ",p.user_screen_name"
                    + ",p.wtax"
                    + ",p.tax_rate"
                    + ",p.tax_amount"
                    + ",p.branch"
                    + ",p.branch_id"
                    + ",p.location"
                    + ",p.location_id"
                    + ",ap.term"
                    + " from accounts_receivable_payments p "
                    + " join accounts_payable ap "
                    + " on ap.ap_no=p.ap_no "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                double amount = rs.getDouble(7);
                double discount_amount = rs.getDouble(8);
                double discount_rate = rs.getDouble(9);
                String discount = rs.getString(10);
                int status = rs.getInt(11);
                double term = rs.getDouble(12);
                String date_applied = rs.getString(13);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                double prev_balance = rs.getDouble(19);
                double check_amount = rs.getDouble(20);
                String check_holder = rs.getString(21);
                String check_bank = rs.getString(22);
                String check_no = rs.getString(23);
                String ci_no = rs.getString(24);
                String trust_receipt = rs.getString(25);
                String or_payment_no = rs.getString(26);
                String soa_id = rs.getString(27);
                String soa_type = rs.getString(28);
                String soa_type_id = rs.getString(29);
                String reference_no = rs.getString(30);
                String check_date = rs.getString(31);
                String user_id = rs.getString(32);
                String user_screen_name = rs.getString(33);
                double wtax = rs.getDouble(34);
                double tax_rate = rs.getDouble(35);
                double tax_amount = rs.getDouble(36);
                String branch = rs.getString(37);
                String branch_id = rs.getString(38);
                String location = rs.getString(39);
                String location_id = rs.getString(40);
                String term2 = rs.getString(41);
                String added_by = user_screen_name;
                int days = 0;
                Date d = new Date();
                Date d2 = new Date();
                if (check_date != null) {
                    try {
                        d = DateType.sf.parse(check_date);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_check_payments.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (date_applied != null) {
                    try {
                        d2 = DateType.sf.parse(date_applied);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_check_payments.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                days = DateUtils1.count_days(d, new Date());

                if (date_applied != null) {
                    date_applied = DateType.convert_slash_datetime2(date_applied);
                } else {
                    date_applied = "";
                }
                if (check_date != null) {
                    check_date = DateType.convert_slash_datetime2(check_date);
                } else {
                    check_date = "";
                }
                Srpt_check_payments.field f = new field(customer_id, customer_name, ar_no, date_added, added_by, date_applied, date_paid, check_amount, check_holder, check_bank, check_no, check_date, tax_rate, tax_amount, reference_no, soa_type, branch, branch_id, location, location_id, days, term2);
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
