/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.cash_drawer.CashDrawer_account_receivables;
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
public class Srpt_cc_ar {

    public final List<Srpt_cc_ar.field> fields;

    public Srpt_cc_ar() {
        this.fields = new ArrayList();
    }

    public static class field {

        String transaction_type;
        String charge_type;
        String reference_no;
        String customer_name;
        String cheque_holder;
        String bank;
        String cheque_no;
        String cheque_date;
        double cash_amount;
        double cheque_amount;
        double amount;

        public field() {
        }

        public field(String transaction_type, String charge_type, String reference_no, String customer_name, String cheque_holder, String bank, String cheque_no, String cheque_date, double cash_amount, double cheque_amount, double amount) {
            this.transaction_type = transaction_type;
            this.charge_type = charge_type;
            this.reference_no = reference_no;
            this.customer_name = customer_name;
            this.cheque_holder = cheque_holder;
            this.bank = bank;
            this.cheque_no = cheque_no;
            this.cheque_date = cheque_date;
            this.cash_amount = cash_amount;
            this.cheque_amount = cheque_amount;
            this.amount = amount;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public String getCharge_type() {
            return charge_type;
        }

        public void setCharge_type(String charge_type) {
            this.charge_type = charge_type;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
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

        public double getCash_amount() {
            return cash_amount;
        }

        public void setCash_amount(double cash_amount) {
            this.cash_amount = cash_amount;
        }

        public double getCheque_amount() {
            return cheque_amount;
        }

        public void setCheque_amount(double cheque_amount) {
            this.cheque_amount = cheque_amount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {
        String where = "  ";
        List<Srpt_cc_ar.field> fields = Srpt_cc_ar.ret_data("");
        List<Srpt_cc_ar.field> fields2 = new ArrayList();
        List<Srpt_cc_ar.field> cash = new ArrayList();
        List<Srpt_cc_ar.field> cheque = new ArrayList();

        for (Srpt_cc_ar.field to : fields) {
            if (to.cash_amount > 0) {
                cash.add(to);
            }
        }
        for (Srpt_cc_ar.field to : fields) {
            if (to.cheque_amount > 0) {
                cheque.add(to);
            }
        }

        fields.clear();
        fields2.addAll(cash);
        fields2.addAll(cheque);

        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";

        Srpt_cc_ar rpt = new Srpt_cc_ar();
        rpt.fields.addAll(fields2);
        String jrxml = "rpt_cc_ar.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_cc_ar.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc_ar to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_ar.field> ret_data(String where) {
        List<Srpt_cc_ar.field> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",charge_type_id"
                    + ",charge_type"
                    + ",reference_no"
                    + ",customer_id"
                    + ",customer_name"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",check_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + " from cash_drawer_accounts_receivables"
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String charge_type_id = rs.getString(5);
                String charge_type = rs.getString(6);
                String reference_no = rs.getString(7);
                String customer_id = rs.getString(8);
                String customer_name = rs.getString(9);
                double cash_amount = rs.getDouble(10);
                double cheque_amount = rs.getDouble(11);
                String check_holder = rs.getString(12);
                String cheque_bank = rs.getString(13);
                String cheque_no = rs.getString(14);
                String cheque_date = rs.getString(15);

                String transaction_type = "Cheque";
                String customer_name1 = check_holder;
                String cheque_date1 = DateType.convert_slash_datetime2(cheque_date);
                double amount = cheque_amount;
                if (cash_amount > 0) {
                    transaction_type = "Cash";
                    customer_name1 = customer_name;
                    cheque_date1 = "";
                    amount = cash_amount;
                }
                String charge_type1 = charge_type;
                String reference_no1 = reference_no;
                String cheque_holder = check_holder;
                String bank = cheque_bank;
                String cheque_no1 = cheque_no;

                Srpt_cc_ar.field field = new field(transaction_type, charge_type1, reference_no1, customer_name1, cheque_holder, bank, cheque_no1, cheque_date1, cash_amount, cheque_amount, amount);
                datas.add(field);
            }

            List<Srpt_cc_ar.field> fields2 = new ArrayList();
            List<Srpt_cc_ar.field> cash = new ArrayList();
            List<Srpt_cc_ar.field> cheque = new ArrayList();

            for (Srpt_cc_ar.field to : datas) {
                if (to.cash_amount > 0) {
                    cash.add(to);
                }
            }
            for (Srpt_cc_ar.field to : datas) {
                if (to.cheque_amount > 0) {
                    cheque.add(to);
                }
            }

            datas.clear();
            fields2.addAll(cash);
            fields2.addAll(cheque);
            return fields2;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_cc_ar.field> ret_data(List<CashDrawer_account_receivables.to_cash_drawer_accounts_receivables> fields) {
        List<Srpt_cc_ar.field> datas = new ArrayList();
        for (CashDrawer_account_receivables.to_cash_drawer_accounts_receivables to : fields) {
            String transaction_type = "Cheque";
            String customer_name1 = to.check_holder;
            String cheque_date1 = DateType.convert_slash_datetime3(to.cheque_date);
            double amount = to.cheque_amount;
            if (to.cash_amount > 0) {
                transaction_type = "Cash";
                customer_name1 = to.customer_name;
                cheque_date1 = "";
                amount = to.cash_amount;
            }
            String charge_type1 = to.charge_type;
            String reference_no1 = to.reference_no;
            String cheque_holder = to.check_holder;
            String bank = to.cheque_bank;
            String cheque_no1 = to.cheque_no;

            Srpt_cc_ar.field field = new field(transaction_type, charge_type1, reference_no1, customer_name1, cheque_holder, bank, cheque_no1, cheque_date1, to.cash_amount, to.cheque_amount, amount);
            datas.add(field);
        }
        List<Srpt_cc_ar.field> fields2 = new ArrayList();
        List<Srpt_cc_ar.field> cash = new ArrayList();
        List<Srpt_cc_ar.field> cheque = new ArrayList();

        for (Srpt_cc_ar.field to : datas) {
            if (to.cash_amount > 0) {
                cash.add(to);
            }
        }
        for (Srpt_cc_ar.field to : datas) {
            if (to.cheque_amount > 0) {
                cheque.add(to);
            }
        }
        fields2.addAll(cash);
        fields2.addAll(cheque);
        return fields2;
    }
}
