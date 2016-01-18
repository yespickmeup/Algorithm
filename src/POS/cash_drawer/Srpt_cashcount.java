/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

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
public class Srpt_cashcount {

    public final double cash_in;
    public final double one_thousand;
    public final double five_hundred;
    public final double two_hundred;
    public final double one_hundred;
    public final double fifty;
    public final double twenty;
    public final double ten;
    public final double five;
    public final double peso;
    public final double point_fifty;
    public final double point_twenty_five;
    public final double point_ten;
    public final double point_zero_five;
    public final double total_cash;
    public final String cashier;
    public final String date;
    public final String timein;
    public final String timeout;

    public Srpt_cashcount(double cash_in, double one_thousand, double five_hundred, double two_hundred, double one_hundred, double fifty, double twenty, double ten, double five, double peso, double point_fifty, double point_twenty_five, double point_ten, double point_zero_five, double total_cash, String cashier, String date, String timein, String timeout) {
        this.cash_in = cash_in;
        this.one_thousand = one_thousand;
        this.five_hundred = five_hundred;
        this.two_hundred = two_hundred;
        this.one_hundred = one_hundred;
        this.fifty = fifty;
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
        this.peso = peso;
        this.point_fifty = point_fifty;
        this.point_twenty_five = point_twenty_five;
        this.point_ten = point_ten;
        this.point_zero_five = point_zero_five;
        this.total_cash = total_cash;
        this.cashier = cashier;
        this.date = date;
        this.timein = timein;
        this.timeout = timeout;
    }

    public static void main(String[] args) {

        double cash_in = 0;
        double one_thousand = 0;
        double five_hundred = 0;
        double two_hundred = 0;
        double one_hundred = 0;
        double fifty = 0;
        double twenty = 0;
        double ten = 0;
        double five = 0;
        double peso = 0;
        double point_fifty = 0;
        double point_twenty_five = 0;
        double point_ten = 0;
        double point_zero_five = 0;
        double total_cash = 0;
        String cashier = "Juan Dela Cruz";
        String date = "09/25/2014";
        String timein = "09:00 AM";
        String timeout = "05:30 PM";
        Srpt_cashcount rpt = new Srpt_cashcount(cash_in, one_thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, ten, five, peso, point_fifty, point_twenty_five, point_ten, point_zero_five, total_cash, cashier, date, timein, timeout);
        String jrxml = "rpt_cashcount.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_cashcount to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_cash_count.class),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static JRViewer get_viewer(Srpt_cashcount to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cashcount.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
