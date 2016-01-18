/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.cash_drawer.CashDrawer_cheques;
import POS.cash_drawer.CashDrawer_cheques.to_cash_drawer_cheques;
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
public class Srpt_cc_cheque {

    public final List<Srpt_cc_cheque.field> fields;

    public Srpt_cc_cheque() {
        this.fields = new ArrayList();
    }

    public static class field {

        String cheque_holder;
        String bank;
        String cheque_no;
        String cheque_date;
        double amount;

        public field() {
        }

        public field(String cheque_holder, String bank, String cheque_no, String cheque_date, double amount) {
            this.cheque_holder = cheque_holder;
            this.bank = bank;
            this.cheque_no = cheque_no;
            this.cheque_date = cheque_date;
            this.amount = amount;
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
        List<Srpt_cc_cheque.field> fields = Srpt_cc_cheque.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cc_cheque rpt = new Srpt_cc_cheque();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cc_cheque.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cc_cheque.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static JRViewer get_viewer(Srpt_cc_cheque to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_cheque.field> ret_data(String where) {
        List<Srpt_cc_cheque.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",cheque_holder"
                    + ",cheque_bank"
                    + ",cheque_no"
                    + ",cheque_amount"
                    + ",cheque_date"
                    + " from cash_drawer_cheques"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String cheque_holder = rs.getString(5);
                String cheque_bank = rs.getString(6);
                String cheque_no = rs.getString(7);
                double cheque_amount = rs.getDouble(8);
                String cheque_date = rs.getString(9);

                String cheque_holder1 = cheque_holder;
                String bank = cheque_bank;
                String cheque_no1 = cheque_no;
                String cheque_date1 = DateType.convert_slash_datetime2(cheque_date);
                double amount = cheque_amount;

                Srpt_cc_cheque.field field = new field(cheque_holder1, bank, cheque_no1, cheque_date1, amount);
                datas.add(field);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static List<Srpt_cc_cheque.field> ret_data(List<CashDrawer_cheques.to_cash_drawer_cheques> fields) {
        List<Srpt_cc_cheque.field> datas = new ArrayList();
        for (CashDrawer_cheques.to_cash_drawer_cheques to : fields) {
            Srpt_cc_cheque.field field = new field(to.cheque_holder, to.cheque_bank, to.cheque_no, DateType.convert_slash_datetime3(to.cheque_date), to.cheque_amount);
            datas.add(field);
        }
        return datas;
    }
}
