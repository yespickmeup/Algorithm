/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.cash_drawer.CashDrawer_prepaids;
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
public class Srpt_cc_prepaid {

    public final List<Srpt_cc_prepaid.field> fields;

    public Srpt_cc_prepaid() {
        this.fields = new ArrayList();
    }

    public static class field {

        String transaction_type;
        String customer_name;
        String cheque_holder;
        String bank;
        String cheque_no;
        String cheque_date;
        double amount;

        public field() {
        }

        public field(String transaction_type, String customer_name, String cheque_holder, String bank, String cheque_no, String cheque_date, double amount) {
            this.transaction_type = transaction_type;
            this.customer_name = customer_name;
            this.cheque_holder = cheque_holder;
            this.bank = bank;
            this.cheque_no = cheque_no;
            this.cheque_date = cheque_date;
            this.amount = amount;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getCheque_holder() {
            return cheque_holder;
        }

        public void setCheque_holder(String cheque_holder) {
            this.cheque_holder = cheque_holder;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCheque_no() {
            return cheque_no;
        }

        public void setCheque_no(String cheque_no) {
            this.cheque_no = cheque_no;
        }

        public String getCheque_date() {
            return cheque_date;
        }

        public void setCheque_date(String cheque_date) {
            this.cheque_date = cheque_date;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Srpt_cc_prepaid.field> fields = Srpt_cc_prepaid.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cc_prepaid rpt = new Srpt_cc_prepaid();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cc_prepaid.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cc_prepaid.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc_prepaid to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_prepaid.field> ret_data(String where) {
        List<Srpt_cc_prepaid.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",customer_name"
                    + ",customer_id"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + " from cash_drawer_prepaids"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String customer_name = rs.getString(5);
                String customer_id = rs.getString(6);
                double cash_amount = rs.getDouble(7);
                double cheque_amount = rs.getDouble(8);
                String cheque_holder = rs.getString(9);
                String cheque_bank = rs.getString(10);
                String cheque_no = rs.getString(11);
                String cheque_date = rs.getString(12);

                String transaction_type = "Cheque";
                String customer_name1 = cheque_holder;
                String cheque_date1 = DateType.convert_slash_datetime2(cheque_date);
                double amount = cheque_amount;
                if (cash_amount > 0) {
                    transaction_type = "Cash";
                    amount = cash_amount;
                    customer_name1 = customer_name;
                    cheque_date1 = "";
                }

                String cheque_holder1 = cheque_holder;
                String bank = cheque_bank;
                String cheque_no1 = cheque_no;

                Srpt_cc_prepaid.field field = new field(transaction_type, customer_name1, cheque_holder1, bank, cheque_no1, cheque_date1, amount);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_cc_prepaid.field> ret_data(List<CashDrawer_prepaids.to_cash_drawer_prepaids> fields) {
        List<Srpt_cc_prepaid.field> datas = new ArrayList();
        for (CashDrawer_prepaids.to_cash_drawer_prepaids to : fields) {
            String transaction_type = "Cheque";
            String customer_name1 = to.cheque_holder;
            String cheque_date1 = DateType.convert_slash_datetime2(to.cheque_date);
            double amount = to.cheque_amount;
            if (to.cash_amount > 0) {
                transaction_type = "Cash";
                amount = to.cash_amount;
                customer_name1 = to.customer_name;
                cheque_date1 = "";
            }

            String cheque_holder1 = to.cheque_holder;
            String bank = to.cheque_bank;
            String cheque_no1 = to.cheque_no;

            Srpt_cc_prepaid.field field = new field(transaction_type, customer_name1, cheque_holder1, bank, cheque_no1, cheque_date1, amount);
            datas.add(field);
        }
        return datas;
    }
}
