/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import java.io.InputStream;
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
public class Srpt_official_receipt {

    public final String date;
    public final String business_name;
    public final String address;
    public final String tin;
    public final String business_style;
    public final String amount_in_words;
    public final String amount;
    public final String service;
    public final String total_sales;
    public final String withholding_tax1;
    public final String withholding_tax2;
    public final String amount_due1;
    public final String amount_due2;
    public final String vatable_sales1;
    public final String vatable_sales2;
    public final String vat_amount1;
    public final String vat_amount2;
    public final String net_sales;
    public final String is_cash;
    public final String is_check;

    public Srpt_official_receipt(String date, String business_name, String address, String tin, String business_style, String amount_in_words, String amount, String service, String total_sales, String withholding_tax1, String withholding_tax2, String amount_due1, String amount_due2, String vatable_sales1, String vatable_sales2, String vat_amount1, String vat_amount2, String net_sales, String is_cash, String is_check) {
        this.date = date;
        this.business_name = business_name;
        this.address = address;
        this.tin = tin;
        this.business_style = business_style;
        this.amount_in_words = amount_in_words;
        this.amount = amount;
        this.service = service;
        this.total_sales = total_sales;
        this.withholding_tax1 = withholding_tax1;
        this.withholding_tax2 = withholding_tax2;
        this.amount_due1 = amount_due1;
        this.amount_due2 = amount_due2;
        this.vatable_sales1 = vatable_sales1;
        this.vatable_sales2 = vatable_sales2;
        this.vat_amount1 = vat_amount1;
        this.vat_amount2 = vat_amount2;
        this.net_sales = net_sales;
        this.is_cash = is_cash;
        this.is_check = is_check;
    }

    public static void main(String[] args) {

        String date = "9/29/2014";
        String business_name = "SIBULAN NATIONAL HIGH SCHOOL";
        String address = "";
        String tin = "";
        String business_style = "";
        String amount_in_words = "FOUR HUNDRED FIFTY PESOS & 07/100";
        String amount = "458.07";
        String service = "CPU REPAIR # 12745";
        String total_sales = "484.07";
        String withholding_tax1 = "";
        String withholding_tax2 = "";
        String amount_due1 = "";
        String amount_due2 = "";
        String vatable_sales1 = "";
        String vatable_sales2 = "";
        String vat_amount1 = "";
        String vat_amount2 = "57.00";
        String net_sales = "484.00";
        String is_cash = "x";
        String is_check = "x";

        Srpt_official_receipt rpt = new Srpt_official_receipt(date, business_name, address, tin, business_style, amount_in_words, amount, service, total_sales, withholding_tax1, withholding_tax2, amount_due1, amount_due2, vatable_sales1, vatable_sales2, vat_amount1, vat_amount2, net_sales, is_cash, is_check);

        JRViewer viewer = Srpt_official_receipt.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_official_receipt to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_official_receipt.class),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static JRViewer get_viewer(Srpt_official_receipt to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_official_receipt.jrxml";
            InputStream is = Srpt_official_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
