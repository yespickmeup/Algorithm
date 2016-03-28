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
public class Srpt_end_of_day_summary {

    public final double cashin_beg;
    public final double cash_sales;
    public final double collections;
    public final double prepayments;
    public final double receipts_total;
    public final double receipts_line_discount;
    public final double receipts_sale_discount;
    public final double receipts_sub_total;
    public final double receipt_net_total;
    public final double bills_thousand;
    public final double bills_five_hundred;
    public final double bills_two_hundred;
    public final double bills_one_hundred;
    public final double bills_fifty;
    public final double bills_twenty;
    public final double coins_ten;
    public final double coins_five;
    public final double coins_one;
    public final double coins_point_fifty;
    public final double coins_point_twenty_five;
    public final double coins_point_ten;
    public final double coins_point_zero_five;
    public final double count_bills_thousand;
    public final double count_bills_five_hundred;
    public final double count_bills_two_hundred;
    public final double count_bills_one_hundred;
    public final double count_bills_fifty;
    public final double count_bills_twenty;
    public final double count_coins_ten;
    public final double count_coins_five;
    public final double count_coins_one;
    public final double count_coins_point_fifty;
    public final double count_coins_point_twenty_five;
    public final double count_coins_point_ten;
    public final double count_coins_point_zero_five;
    public final double cc_total;
    public final double cc_last_remittance;
    public final double cc_cashin_end;
    public final String SUBREPORT_DIR;
    public final List<Srpt_end_of_day_summary_details.field> rpt_details;
    public final double check_cash_sales;
    public final double check_collections;
    public final double check_prepayments;
    public final double cc_cash_sales;
    public final double cc_collections;
    public final double cc_prepayments;
    public final double total_check_payments;
    public final double total_cc_payments;
    public final String date;
    public final String business_name;
    public final String address;
    public Srpt_end_of_day_summary(double cashin_beg, double cash_sales, double collections
            , double prepayments, double receipts_total, double receipts_line_discount
            , double receipts_sale_discount, double receipts_sub_total, double receipt_net_total
            , double bills_thousand, double bills_five_hundred, double bills_two_hundred
            , double bills_one_hundred, double bills_fifty, double bills_twenty, double coins_ten
            , double coins_five, double coins_one, double coins_point_fifty
            , double coins_point_twenty_five, double coins_point_ten, double coins_point_zero_five
            , double count_bills_thousand, double count_bills_five_hundred, double count_bills_two_hundred
            , double count_bills_one_hundred, double count_bills_fifty, double count_bills_twenty
            , double count_coins_ten, double count_coins_five, double count_coins_one
            , double count_coins_point_fifty, double count_coins_point_twenty_five
            , double count_coins_point_ten, double count_coins_point_zero_five, double cc_total
            , double cc_last_remittance, double cc_cashin_end, String SUBREPORT_DIR
            , List<Srpt_end_of_day_summary_details.field> rpt_details
            ,double check_cash_sales,double check_collections,double check_prepayments
            ,double cc_cash_sales,double cc_collections,double cc_prepayments
            ,double total_check_payments,double total_cc_payments
            ,String date,String business_name,String address
    ) {
        this.cashin_beg = cashin_beg;
        this.cash_sales = cash_sales;
        this.collections = collections;
        this.prepayments = prepayments;
        this.receipts_total = receipts_total;
        this.receipts_line_discount = receipts_line_discount;
        this.receipts_sale_discount = receipts_sale_discount;
        this.receipts_sub_total = receipts_sub_total;
        this.receipt_net_total = receipt_net_total;
        this.bills_thousand = bills_thousand;
        this.bills_five_hundred = bills_five_hundred;
        this.bills_two_hundred = bills_two_hundred;
        this.bills_one_hundred = bills_one_hundred;
        this.bills_fifty = bills_fifty;
        this.bills_twenty = bills_twenty;
        this.coins_ten = coins_ten;
        this.coins_five = coins_five;
        this.coins_one = coins_one;
        this.coins_point_fifty = coins_point_fifty;
        this.coins_point_twenty_five = coins_point_twenty_five;
        this.coins_point_ten = coins_point_ten;
        this.coins_point_zero_five = coins_point_zero_five;
        this.count_bills_thousand = count_bills_thousand;
        this.count_bills_five_hundred = count_bills_five_hundred;
        this.count_bills_two_hundred = count_bills_two_hundred;
        this.count_bills_one_hundred = count_bills_one_hundred;
        this.count_bills_fifty = count_bills_fifty;
        this.count_bills_twenty = count_bills_twenty;
        this.count_coins_ten = count_coins_ten;
        this.count_coins_five = count_coins_five;
        this.count_coins_one = count_coins_one;
        this.count_coins_point_fifty = count_coins_point_fifty;
        this.count_coins_point_twenty_five = count_coins_point_twenty_five;
        this.count_coins_point_ten = count_coins_point_ten;
        this.count_coins_point_zero_five = count_coins_point_zero_five;
        this.cc_total = cc_total;
        this.cc_last_remittance = cc_last_remittance;
        this.cc_cashin_end = cc_cashin_end;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_details = rpt_details;
        this.check_cash_sales=check_cash_sales;
        this.check_collections=check_collections;
        this.check_prepayments=check_prepayments;
        this.cc_cash_sales=cc_cash_sales;
        this.cc_collections=cc_collections;
        this.cc_prepayments=cc_prepayments;
        this.total_check_payments=total_check_payments;
        this.total_cc_payments=total_cc_payments;
        this.date=date;
        this.business_name=business_name;
        this.address=address;
    }

    public static void main(String[] args) {

        double cashin_beg = 1000;
        double cash_sales = 10295;
        double collections = 4000;
        double prepayments = 2000;
        double receipts_total = 16295;
        double receipts_line_discount = 15;
        double receipts_sale_discount = 65;
        double receipts_sub_total = 16215;
        double receipt_net_total = 17215;
        double bills_thousand = 1000;
        double bills_five_hundred = 500;
        double bills_two_hundred = 200;
        double bills_one_hundred = 300;
        double bills_fifty = 0;
        double bills_twenty = 0;
        double coins_ten = 0;
        double coins_five = 0;
        double coins_one = 0;
        double coins_point_fifty = 0;
        double coins_point_twenty_five = 0;
        double coins_point_ten = 0;
        double coins_point_zero_five = 0;
        double count_bills_thousand = 1;
        double count_bills_five_hundred = 1;
        double count_bills_two_hundred = 1;
        double count_bills_one_hundred = 3;
        double count_bills_fifty = 0;
        double count_bills_twenty = 0;
        double count_coins_ten = 0;
        double count_coins_five = 0;
        double count_coins_one = 0;
        double count_coins_point_fifty = 0;
        double count_coins_point_twenty_five = 0;
        double count_coins_point_ten = 0;
        double count_coins_point_zero_five = 0;
        double cc_total = 17215;
        double cc_last_remittance = 15000;
        double cc_cashin_end = 2215;
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "retail_res\\rpt2\\";

        List<Srpt_end_of_day_summary_details.field> fields = new ArrayList();
        double check_cash_sales=0;
        double check_collections=0;
        double check_prepayments=0;
        double cc_cash_sales=0;
        double cc_collections=0;
        double cc_prepayments=0;
         double total_check_payments=0;
     double total_cc_payments=0;                
        Srpt_end_of_day_summary_details.field check = new Srpt_end_of_day_summary_details.field("Checks", "BPI 000234", "", "1,000.00");
        Srpt_end_of_day_summary_details.field credit_card = new Srpt_end_of_day_summary_details.field("Credit Card", "", "", "1,000.00");
        Srpt_end_of_day_summary_details.field gc = new Srpt_end_of_day_summary_details.field("Gift Certificate", "", "", "0.00");
        Srpt_end_of_day_summary_details.field remit1 = new Srpt_end_of_day_summary_details.field("Remitted", "", "5,000.00", "");
        Srpt_end_of_day_summary_details.field remit2 = new Srpt_end_of_day_summary_details.field("Remitted", "", "4,000.00", "");
        Srpt_end_of_day_summary_details.field remit3 = new Srpt_end_of_day_summary_details.field("Remitted", "", "4,200.00", "13,200.00");

        fields.add(check);
        fields.add(credit_card);
        fields.add(gc);
        fields.add(remit1);
        fields.add(remit2);
        fields.add(remit3);

        Srpt_end_of_day_summary rpt = new Srpt_end_of_day_summary(cashin_beg, cash_sales, collections
                , prepayments, receipts_total, receipts_line_discount, receipts_sale_discount
                , receipts_sub_total, receipt_net_total, bills_thousand, bills_five_hundred
                , bills_two_hundred, bills_one_hundred, bills_fifty, bills_twenty, coins_ten
                , coins_five, coins_one, coins_point_fifty, coins_point_twenty_five, coins_point_ten
                , coins_point_zero_five, count_bills_thousand, count_bills_five_hundred
                , count_bills_two_hundred, count_bills_one_hundred, count_bills_fifty, count_bills_twenty
                , count_coins_ten, count_coins_five, count_coins_one, count_coins_point_fifty
                , count_coins_point_twenty_five, count_coins_point_ten, count_coins_point_zero_five
                , cc_total, cc_last_remittance, cc_cashin_end, SUBREPORT_DIR, fields
                ,check_cash_sales,check_collections,check_prepayments,cc_cash_sales,cc_collections,cc_prepayments
                ,total_check_payments,total_cc_payments,"","","");
        
        
        
        String jrxml = "rpt_end_of_day_summary.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            
            InputStream is = Srpt_end_of_day_summary.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
            
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static JRViewer get_viewer(Srpt_end_of_day_summary to, String jrxml) {
        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }
    
    
}
