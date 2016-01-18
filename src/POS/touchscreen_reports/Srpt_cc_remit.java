/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.cash_drawer.CashDrawer_remittances;
import POS.cash_drawer.CashDrawer_remittances.to_cash_drawer_remittances;
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
public class Srpt_cc_remit {

    public final List<Srpt_cc_remit.field> fields;

    public Srpt_cc_remit() {
        this.fields = new ArrayList();
    }

    public static class field {

        String transaction_type;
        String cheque_holder;
        String cheque_bank;
        String cheque_no;
        String cheque_date;
        double amount;

        public field() {
        }

        public field(String transaction_type, String cheque_holder, String cheque_bank, String cheque_no, String cheque_date, double amount) {
            this.transaction_type = transaction_type;
            this.cheque_holder = cheque_holder;
            this.cheque_bank = cheque_bank;
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

        public String getCheque_holder() {
            return cheque_holder;
        }

        public void setCheque_holder(String cheque_holder) {
            this.cheque_holder = cheque_holder;
        }

        public String getCheque_bank() {
            return cheque_bank;
        }

        public void setCheque_bank(String cheque_bank) {
            this.cheque_bank = cheque_bank;
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
        List<Srpt_cc_remit.field> fields = Srpt_cc_remit.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cc_remit rpt = new Srpt_cc_remit();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cc_remit.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cc_remit.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc_remit to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_remit.field> ret_data(String where) {
        List<Srpt_cc_remit.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cash_amount"
                    + ",cheque_amount"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_date"
                    + ",status"
                    + " from cash_drawer_remittances"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                double cash_amount = rs.getDouble(5);
                double cheque_amount = rs.getDouble(6);
                String cheque_holder = rs.getString(7);
                String cheque_bank = rs.getString(8);
                String cheque_no = rs.getString(9);
                String cheque_date = DateType.convert_slash_datetime2(rs.getString(10));
                int status = rs.getInt(11);

                String transaction_type = "Cheque";
                double amount = cheque_amount;
                if (cash_amount > 0) {
                    amount = cash_amount;
                    cheque_date = "";
                    transaction_type = "Cash";
                }

                Srpt_cc_remit.field field = new field(transaction_type, cheque_holder, cheque_bank, cheque_no, cheque_date, amount);
                datas.add(field);

            }
            List<Srpt_cc_remit.field> datas1 = new ArrayList();
            List<Srpt_cc_remit.field> datas2 = new ArrayList();
            for (Srpt_cc_remit.field to : datas) {
                if (to.transaction_type.equals("Cash")) {
                    datas1.add(to);
                } else {
                    datas2.add(to);
                }
            }
            datas.clear();
            datas.addAll(datas1);
            datas.addAll(datas2);
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_cc_remit.field> ret_data(List<CashDrawer_remittances.to_cash_drawer_remittances> fields) {
        List<Srpt_cc_remit.field> datas = new ArrayList();
        for (CashDrawer_remittances.to_cash_drawer_remittances field : fields) {
            String transaction_type = "Cheque";
            String cheque_holder = field.cheque_holder;
            String cheque_bank = field.cheque_bank;
            String cheque_no = field.cheque_no;
            String cheque_date = DateType.convert_slash_datetime2(field.cheque_date);
            double amount = field.cheque_amount;
            if (field.cash_amount > 0) {
                amount = field.cash_amount;
                cheque_date = "";
                transaction_type = "Cash";
            }

            Srpt_cc_remit.field to = new field(transaction_type, cheque_holder, cheque_bank, cheque_no, cheque_date, amount);
            datas.add(to);
        }
        List<Srpt_cc_remit.field> datas1 = new ArrayList();
        List<Srpt_cc_remit.field> datas2 = new ArrayList();
        for (Srpt_cc_remit.field to : datas) {
            if (to.transaction_type.equals("Cash")) {
                datas1.add(to);
            } else {
                datas2.add(to);
            }
        }
        datas.clear();
        datas.addAll(datas1);
        datas.addAll(datas2);
        return datas;
    }
}
