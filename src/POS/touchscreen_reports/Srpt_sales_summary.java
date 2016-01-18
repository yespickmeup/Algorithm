/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import java.io.InputStream;
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
public class Srpt_sales_summary {

    public final List<field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;
    
    public Srpt_sales_summary(String business_name, String address, String contact_no, String date,String branch,String location) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch=branch;
        this.location=location;
       
    }

    public static class field {

        String user_id;
        String user_screen_name;
        double gross_total;
        double line_discount;
        double sale_discount;
        double balance_due;
        double cash;
        double cash_no;
        double credit_card;
        double credit_card_no;
        double gift_certificate;
        double gift_certificate_no;
        double prepaid;
        double prepaid_no;
        double cheque;
        double cheque_no;
        double charge;
        double charge_no;
        double disbursement;
        double net_cash;
        double prepaid_cash;
        double prepaid_cheque;
        double ar_cash;
        double ar_cheque;
        double cashin;
        double remit_cash;
        double remit_cheque;
        public field(String user_id, String user_screen_name, double gross_total, double line_discount, double sale_discount
                , double balance_due, double cash, double cash_no, double credit_card, double credit_card_no, double gift_certificate
                , double gift_certificate_no, double prepaid, double prepaid_no, double cheque, double cheque_no, double charge
                , double charge_no, double disbursement, double net_cash, double prepaid_cash, double prepaid_cheque
                ,double ar_cash,double ar_cheque,double cashin,double remit_cash,double remit_cheque) {
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.gross_total = gross_total;
            this.line_discount = line_discount;
            this.sale_discount = sale_discount;
            this.balance_due = balance_due;
            this.cash = cash;
            this.cash_no = cash_no;
            this.credit_card = credit_card;
            this.credit_card_no = credit_card_no;
            this.gift_certificate = gift_certificate;
            this.gift_certificate_no = gift_certificate_no;
            this.prepaid = prepaid;
            this.prepaid_no = prepaid_no;
            this.cheque = cheque;
            this.cheque_no = cheque_no;
            this.charge = charge;
            this.charge_no = charge_no;
            this.disbursement = disbursement;
            this.net_cash = net_cash;
            this.prepaid_cash = prepaid_cash;
            this.prepaid_cheque = prepaid_cheque;
            this.ar_cash=ar_cash;
            this.ar_cheque=ar_cheque;
            this.cashin=cashin;
            this.remit_cash=remit_cash;
            this.remit_cheque=remit_cheque;
        }

        public double getRemit_cash() {
            return remit_cash;
        }

        public void setRemit_cash(double remit_cash) {
            this.remit_cash = remit_cash;
        }

        public double getRemit_cheque() {
            return remit_cheque;
        }

        public void setRemit_cheque(double remit_cheque) {
            this.remit_cheque = remit_cheque;
        }

        
        public double getCashin() {
            return cashin;
        }

        public void setCashin(double cashin) {
            this.cashin = cashin;
        }

        
        public double getAr_cash() {
            return ar_cash;
        }

        public void setAr_cash(double ar_cash) {
            this.ar_cash = ar_cash;
        }

        public double getAr_cheque() {
            return ar_cheque;
        }

        public void setAr_cheque(double ar_cheque) {
            this.ar_cheque = ar_cheque;
        }

        
        public double getPrepaid_cash() {
            return prepaid_cash;
        }

        public void setPrepaid_cash(double prepaid_cash) {
            this.prepaid_cash = prepaid_cash;
        }

        public double getPrepaid_cheque() {
            return prepaid_cheque;
        }

        public void setPrepaid_cheque(double prepaid_cheque) {
            this.prepaid_cheque = prepaid_cheque;
        }

        public double getDisbursement() {
            return disbursement;
        }

        public void setDisbursement(double disbursement) {
            this.disbursement = disbursement;
        }

        public double getNet_cash() {
            return net_cash;
        }

        public void setNet_cash(double net_cash) {
            this.net_cash = net_cash;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_screen_name() {
            return user_screen_name;
        }

        public void setUser_screen_name(String user_screen_name) {
            this.user_screen_name = user_screen_name;
        }

        public double getGross_total() {
            return gross_total;
        }

        public void setGross_total(double gross_total) {
            this.gross_total = gross_total;
        }

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

        public double getSale_discount() {
            return sale_discount;
        }

        public void setSale_discount(double sale_discount) {
            this.sale_discount = sale_discount;
        }

        public double getBalance_due() {
            return balance_due;
        }

        public void setBalance_due(double balance_due) {
            this.balance_due = balance_due;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getCash_no() {
            return cash_no;
        }

        public void setCash_no(double cash_no) {
            this.cash_no = cash_no;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

        public double getCredit_card_no() {
            return credit_card_no;
        }

        public void setCredit_card_no(double credit_card_no) {
            this.credit_card_no = credit_card_no;
        }

        public double getGift_certificate() {
            return gift_certificate;
        }

        public void setGift_certificate(double gift_certificate) {
            this.gift_certificate = gift_certificate;
        }

        public double getGift_certificate_no() {
            return gift_certificate_no;
        }

        public void setGift_certificate_no(double gift_certificate_no) {
            this.gift_certificate_no = gift_certificate_no;
        }

        public double getPrepaid() {
            return prepaid;
        }

        public void setPrepaid(double prepaid) {
            this.prepaid = prepaid;
        }

        public double getPrepaid_no() {
            return prepaid_no;
        }

        public void setPrepaid_no(double prepaid_no) {
            this.prepaid_no = prepaid_no;
        }

        public double getCheque() {
            return cheque;
        }

        public void setCheque(double cheque) {
            this.cheque = cheque;
        }

        public double getCheque_no() {
            return cheque_no;
        }

        public void setCheque_no(double cheque_no) {
            this.cheque_no = cheque_no;
        }

        public double getCharge() {
            return charge;
        }

        public void setCharge(double charge) {
            this.charge = charge;
        }

        public double getCharge_no() {
            return charge_no;
        }

        public void setCharge_no(double charge_no) {
            this.charge_no = charge_no;
        }

    }

    public static void main(String[] args) {

        List<field> fields = new ArrayList();
        for (int i = 1; i < 10; i++) {
            String user_id = "";
            if (i < 6) {
                user_id = "1";
            } else {
                user_id = "2";
            }
            String user_screen_name = "Ronald Pascua" + i;
            double gross_total = 1000;
            double line_discount = 10;
            double sale_discount = 50;
            double balance_due = 940;
            double cash = 100;
            double cash_no = 0;
            double credit_card = 100;
            double credit_card_no = 1;
            double gift_certificate = 100;
            double gift_certificate_no = 1;
            double prepaid = 100;
            double prepaid_no = 1;
            double cheque = 100;
            double cheque_no = 1;
            double charge = 100;
            double charge_no = 1;
            double disbursement = 0;
            double net_cash = 0;
            double prepaid_cash=0;
            double prepaid_cheque=0;
            double ar_cash=0;
            double ar_cheque=0;
            double cashin=0;
            double remit_cash=0;
            double remit_cheque=0;
            Srpt_sales_summary.field field = new field(user_id, user_screen_name, gross_total, line_discount, sale_discount
                    , balance_due, cash, cash_no, credit_card, credit_card_no, gift_certificate, gift_certificate_no
                    , prepaid, prepaid_no, cheque, cheque_no, charge, charge_no, disbursement, net_cash,prepaid_cash
                    ,prepaid_cheque,ar_cash,ar_cheque,cashin,remit_cash,remit_cheque);
            fields.add(field);
        }
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        String branch="";
        String location="";
        Srpt_sales_summary rpt = new Srpt_sales_summary(business_name, address, contact_no, date,branch,location);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_sales_summary.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_summary.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_summary to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
