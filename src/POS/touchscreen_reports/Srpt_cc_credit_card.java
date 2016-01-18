/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.cash_drawer.CashDrawer_credit_cards;
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
public class Srpt_cc_credit_card {

    public final List<Srpt_cc_credit_card.field> fields;

    public Srpt_cc_credit_card() {
        this.fields = new ArrayList();
    }

    public static class field {

        String card_type;
        double rate;
        double amount;
        String card_no;
        String card_holder;
        String approval_code;

        public field() {
        }

        public field(String card_type, double rate, double amount, String card_no, String card_holder, String approval_code) {
            this.card_type = card_type;
            this.rate = rate;
            this.amount = amount;
            this.card_no = card_no;
            this.card_holder = card_holder;
            this.approval_code = approval_code;
        }

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCard_no() {
            return card_no;
        }

        public void setCard_no(String card_no) {
            this.card_no = card_no;
        }

        public String getCard_holder() {
            return card_holder;
        }

        public void setCard_holder(String card_holder) {
            this.card_holder = card_holder;
        }

        public String getApproval_code() {
            return approval_code;
        }

        public void setApproval_code(String approval_code) {
            this.approval_code = approval_code;
        }
    }

    public static void main(String[] args) {
        List<Srpt_cc_credit_card.field> fields = Srpt_cc_credit_card.ret_data("");

        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        Srpt_cc_credit_card rpt = new Srpt_cc_credit_card();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cc_credit_card.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_cc_cash.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc_credit_card to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cc_credit_card.field> ret_data(String where) {
        List<Srpt_cc_credit_card.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",credit_card_type"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + " from cash_drawer_credit_cards"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String date_added = rs.getString(4);
                String credit_card_type = rs.getString(5);
                double credit_card_rate = rs.getDouble(6);
                double credit_card_amount = rs.getDouble(7);
                String credit_card_no = rs.getString(8);
                String credit_card_holder = rs.getString(9);
                String credit_card_approval_code = rs.getString(10);

                String card_type = credit_card_type;
                double rate = credit_card_rate;
                double amount = credit_card_amount;
                String card_no = credit_card_no;
                String card_holder = credit_card_holder;
                String approval_code = credit_card_approval_code;

                Srpt_cc_credit_card.field field = new field(card_type, rate, amount, card_no, card_holder, approval_code);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_cc_credit_card.field> ret_data(List<CashDrawer_credit_cards.to_cash_drawer_credit_cards> fields) {
        List<Srpt_cc_credit_card.field> datas = new ArrayList();
        for (CashDrawer_credit_cards.to_cash_drawer_credit_cards to : fields) {
            String card_type = to.credit_card_type;
            double rate = to.credit_card_rate;
            double amount = to.credit_card_amount;
            String card_no = to.credit_card_no;
            String card_holder = to.credit_card_holder;
            String approval_code = to.credit_card_approval_code;

            Srpt_cc_credit_card.field field = new field(card_type, rate, amount, card_no, card_holder, approval_code);
            datas.add(field);
        }
        return datas;
    }
}
