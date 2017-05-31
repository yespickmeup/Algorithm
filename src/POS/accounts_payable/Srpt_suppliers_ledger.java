/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_payable;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ronald
 */
public class Srpt_suppliers_ledger {

    public final List<Srpt_suppliers_ledger.field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;
    public final String customer_id;
    public final String customer_name;
    public final double balance;

    public Srpt_suppliers_ledger(String business_name, String date, String printed_by, String customer_id, String customer_name, double balance) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.balance = balance;
    }

    public static class field {

        String date;
        String transaction_no;
        String or_no;
        String amount;
        String payment;
        String balance;
        Date date_added;

        public field() {
        }

        public field(String date, String transaction_no, String or_no, String amount, String payment, String balance, Date date_added) {
            this.date = date;
            this.transaction_no = transaction_no;
            this.or_no = or_no;
            this.amount = amount;
            this.payment = payment;
            this.balance = balance;
            this.date_added = date_added;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public Date getDate_added() {
            return date_added;
        }

        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }

    }

    public static void main(String[] args) {

        List<Srpt_suppliers_ledger.field> datas = Srpt_suppliers_ledger.ret_data("0021");// Srpt_customers.ret_data("");
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String customer_id = "";
        String customer_name = "";
        double balance = 0;

        Srpt_suppliers_ledger rpt = new Srpt_suppliers_ledger(business_name, date, printed_by, customer_id, customer_name, balance);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_customer_ledger.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_suppliers_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_suppliers_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_suppliers_ledger.field> ret_data(String search) {
        List<Srpt_suppliers_ledger.field> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ap_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",reference_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  accounts_payable where "
                    + " customer_id ='" + search + "' and status=0 "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date = DateType.convert_slash_datetime2(rs.getString(13));
                String transaction_no = rs.getString(4);
                double amount = rs.getDouble(7);
                double payment = 0;
                double balance = 0;
                Date d = DateType.slash.parse(date);
                String amount2 = FitIn.fmt_wc_0(amount);
                if (amount == 0) {
                    amount2 = "";
                }
                String payment2 = FitIn.fmt_wc_0(payment);
                if (payment == 0) {
                    payment2 = "";
                }
                String balance2 = FitIn.fmt_wc_0(balance);
                if (balance == 0) {
                    balance2 = "";
                }
                Srpt_suppliers_ledger.field to = new Srpt_suppliers_ledger.field(date, transaction_no, "", amount2, payment2, balance2, d);
                datas.add(to);
            }

            String s2 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ap_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",prev_balance"
                    + ",reference_no"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_date"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",wtax"
                    + ",tax_rate"
                    + ",tax_amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  accounts_payable_payments where "
                    + " customer_id ='" + search + "' and status=0 "
                    + " ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {

                double paid = rs2.getDouble(7);
                double disc = rs2.getDouble(8);
                double check_amount = rs2.getDouble(21);
                String date = rs2.getString(15);
                String transaction_no = rs2.getString(4);
                String or_payment_no = rs2.getString(18);
                double amount = 0;
                double payment = paid + check_amount + disc;
                double balance = 0;
                Date d = DateType.sf.parse(date);
                date = DateType.convert_slash_datetime2(date);
                String amount2 = FitIn.fmt_wc_0(amount);
                if (amount == 0) {
                    amount2 = "";
                }
                String payment2 = FitIn.fmt_wc_0(payment);
                if (payment == 0) {
                    payment2 = "";
                }
                String balance2 = FitIn.fmt_wc_0(balance);
                if (balance == 0) {
                    balance2 = "";
                }
                Srpt_suppliers_ledger.field to1 = new Srpt_suppliers_ledger.field(date, transaction_no, or_payment_no, amount2, payment2, balance2, d);
                datas.add(to1);
            }

            Collections.sort(datas, new Comparator<Srpt_suppliers_ledger.field>() {

                @Override
                public int compare(Srpt_suppliers_ledger.field o1, Srpt_suppliers_ledger.field o2) {
                    return o1.getDate_added().
                            compareTo(o2.getDate_added());
                }
            });

            double amount = 0;
            double total = 0;
            List<Srpt_suppliers_ledger.field> datas2 = new ArrayList();
            for (Srpt_suppliers_ledger.field to : datas) {
                total += FitIn.toDouble(to.amount) - FitIn.toDouble(to.payment);
                Srpt_suppliers_ledger.field to1 = new Srpt_suppliers_ledger.field(to.date, to.transaction_no, to.or_no, to.amount, to.payment, FitIn.fmt_wc_0(total), to.date_added);
                datas2.add(to1);
            }
            return datas2;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
