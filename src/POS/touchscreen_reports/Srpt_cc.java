/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import java.io.InputStream;
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
public class Srpt_cc {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String SUBREPORT_DIR;
    public final List<Srpt_cc_cash.field> rpt_cash;
    public final List<Srpt_cc_gc.field> rpt_gc;
    public final List<Srpt_cc_prepaid.field> rpt_prepaid;
    public final List<Srpt_cc_cheque.field> rpt_cheque;
    public final List<Srpt_cc_ar.field> rpt_ar;
    public final List<Srpt_cc_disbursement.field> rpt_disbursement;
    public final List<Srpt_cc_credit_card.field> rpt_credit_card;
    public final List<Srpt_cc_remit.field> rpt_remit;
    public final double total_cash_sales;
    public final double total_cash_prepaid;
    public final double total_cash_ar;
    public final double total_disbursement;
    public final double total_cash_sub;
    public final double total_cash_net;
    public final double total_cheque_sales;
    public final double total_cheque_prepaid;
    public final double total_cheque_ar;
    public final double total_cheque_net;
    public final double total_gc;
    public final double total_cc;
    public final String prepared_by;
    public final String checked_by;
    public final String deposited_by;
    public final double total_remit;
    public final double total_remit_cheque;
    public Srpt_cc(
            String business_name, String address, String contact_no, String date, String SUBREPORT_DIR, List<Srpt_cc_cash.field> rpt_cash, List<Srpt_cc_gc.field> rpt_gc, List<Srpt_cc_prepaid.field> rpt_prepaid, List<Srpt_cc_cheque.field> rpt_cheque, List<Srpt_cc_ar.field> rpt_ar, List<Srpt_cc_disbursement.field> rpt_disbursement, List<Srpt_cc_credit_card.field> rpt_credit_card, List<Srpt_cc_remit.field> rpt_remit, double total_cash_sales, double total_cash_prepaid, double total_cash_ar, double total_disbursement, double total_cash_sub, double total_cash_net, double total_cheque_sales, double total_cheque_prepaid, double total_cheque_ar, double total_cheque_net, double total_gc, double total_cc, String prepared_by, String checked_by, String deposited_by
            ,double total_remit,double total_remit_cheque
    ) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_cash = rpt_cash;
        this.rpt_gc = rpt_gc;
        this.rpt_prepaid = rpt_prepaid;
        this.rpt_cheque = rpt_cheque;
        this.rpt_ar = rpt_ar;
        this.rpt_credit_card = rpt_credit_card;
        this.rpt_disbursement = rpt_disbursement;
        this.rpt_remit = rpt_remit;
        this.total_cash_sales = total_cash_sales;
        this.total_cash_prepaid = total_cash_prepaid;
        this.total_cash_ar = total_cash_ar;
        this.total_disbursement = total_disbursement;
        this.total_cash_sub = total_cash_sub;
        this.total_cash_net = total_cash_net;
        this.total_cheque_sales = total_cheque_sales;
        this.total_cheque_prepaid = total_cheque_prepaid;
        this.total_cheque_ar = total_cheque_ar;
        this.total_cheque_net = total_cheque_net;
        this.total_gc = total_gc;
        this.total_cc = total_cc;
        this.prepared_by = prepared_by;
        this.checked_by = checked_by;
        this.deposited_by = deposited_by;
        this.total_remit=total_remit;
        this.total_remit_cheque=total_remit_cheque;
    }

    public static void main(String[] args) {
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String contact_no = System.getProperty("telephone_number", "");
        String address = System.getProperty("address", "Canlas Subdivision, Lower Bagacay, Dumaguete City, Negros Oriental "
                + "");
        address = address + "\n" + contact_no;
        String date = "Date as of 11/24/14 - 11/24/14";

        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "retail_res\\rpt2\\";
        List<Srpt_cc_cash.field> rpt_cash = Srpt_cc_cash.ret_data("");
        List<Srpt_cc_gc.field> rpt_gc = Srpt_cc_gc.ret_data("");
        List<Srpt_cc_prepaid.field> rpt_prepaid = Srpt_cc_prepaid.ret_data("");
        List<Srpt_cc_cheque.field> rpt_cheque = Srpt_cc_cheque.ret_data("");
        List<Srpt_cc_ar.field> rpt_ar = Srpt_cc_ar.ret_data("");
        List<Srpt_cc_disbursement.field> rpt_disbursement = Srpt_cc_disbursement.ret_data("");
        List<Srpt_cc_credit_card.field> rpt_credit_card = Srpt_cc_credit_card.ret_data("");
        List<Srpt_cc_remit.field> rpt_remit = Srpt_cc_remit.ret_data("");
        double total_cash_sales = 0;
        double total_cash_prepaid = 0;
        double total_cash_ar = 0;
        double total_disbursement = 0;
        double total_cash_sub = 0;
        double total_cash_net = 0;
        double total_cheque_sales = 0;
        double total_cheque_prepaid = 0;
        double total_cheque_ar = 0;
        double total_cheque_net = 0;
        double total_gc = 0;
        double total_cc = 0;
        String prepared_by = "";
        String checked_by = "";
        String deposited_by = "";
        double total_remit=0;
        double total_remit_cheque=0;
        Srpt_cc rpt = new Srpt_cc(
                business_name.toUpperCase(), address, contact_no, date, SUBREPORT_DIR, rpt_cash, rpt_gc, rpt_prepaid, rpt_cheque, rpt_ar, rpt_disbursement, rpt_credit_card, rpt_remit, total_cash_sales, total_cash_prepaid, total_cash_ar, total_disbursement, total_cash_sub, total_cash_net, total_cheque_sales, total_cheque_prepaid, total_cheque_ar, total_cheque_net, total_gc, total_cc, prepared_by, checked_by, deposited_by
                ,total_remit,total_remit_cheque
        );

        String jrxml = "rpt_cc.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_cc.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cc to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }
}
