/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir;

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
public class Reading {

    public final String business_name;
    public final String address;
    public final String operated_by;
    public final String permit_no;
    public final String tin_no;
    public final String accreditation_no;
    public final String serial_no;
    public final String machine_no;
    public final String reading_type;
    public final String terminal_no;
    public final String reading_date;
    public final String user;
    public final double gross_sales;
    public final double total_discounts;
    public final double no_of_total_discounts;
    public final double sc_discounts;
    public final double no_of_sc_discounts;
    public final double reg_discounts;
    public final double no_of_reg_discounts;
    public final double other_discounts;
    public final double no_of_other_discounts;
    public final double cash_payments;
    public final double cheque_payments;
    public final double credit_card_payments;
    public final double gc_payments;
    public final double prepaids;
    public final double charge_payments;
    public final int no_of_transactions;
    public final double qty_sold;
    public final double no_of_sku;
    public final int no_of_no_void_transactions;
    public final double no_void_transactions_amount;
    public final int no_of_void_transactions;
    public final double void_transactions_amount;
    public final double non_vat_sales;
    public final double vat_sales;
    public final double vat_exempt_sales;
    public final double zero_rated_sales;
    public final double vat_amount;
    public final double previous_reading;
    public final double running_total;
    public final String counter_id_starts;
    public final String counter_id_ends;
    public final double line_discount;
    public final double net_sales;

    public Reading(String business_name, String address, String operated_by, String permit_no, String tin_no, String accreditation_no, String serial_no, String machine_no, String reading_type, String terminal_no, String reading_date, String user, double gross_sales, double total_discounts, double no_of_total_discounts, double sc_discounts, double no_of_sc_discounts, double reg_discounts, double no_of_reg_discounts, double other_discounts, double no_of_other_discounts, double cash_payments, double cheque_payments, double credit_card_payments, double gc_payments, double prepaids, double charge_payments, int no_of_transactions, double qty_sold, double no_of_sku, int no_of_no_void_transactions, double no_void_transactions_amount, int no_of_void_transactions, double void_transactions_amount, double non_vat_sales, double vat_sales, double vat_exempt_sales, double zero_rated_sales, double vat_amount, double previous_reading, double running_total, String counter_id_starts, String counter_id_ends, double line_discount, double net_sales) {
        this.business_name = business_name;
        this.address = address;
        this.operated_by = operated_by;
        this.permit_no = permit_no;
        this.tin_no = tin_no;
        this.accreditation_no = accreditation_no;
        this.serial_no = serial_no;
        this.machine_no = machine_no;
        this.reading_type = reading_type;
        this.terminal_no = terminal_no;
        this.reading_date = reading_date;
        this.user = user;
        this.gross_sales = gross_sales;
        this.total_discounts = total_discounts;
        this.no_of_total_discounts = no_of_total_discounts;
        this.sc_discounts = sc_discounts;
        this.no_of_sc_discounts = no_of_sc_discounts;
        this.reg_discounts = reg_discounts;
        this.no_of_reg_discounts = no_of_reg_discounts;
        this.other_discounts = other_discounts;
        this.no_of_other_discounts = no_of_other_discounts;
        this.cash_payments = cash_payments;
        this.cheque_payments = cheque_payments;
        this.credit_card_payments = credit_card_payments;
        this.gc_payments = gc_payments;
        this.prepaids = prepaids;
        this.charge_payments = charge_payments;
        this.no_of_transactions = no_of_transactions;
        this.qty_sold = qty_sold;
        this.no_of_sku = no_of_sku;
        this.no_of_no_void_transactions = no_of_no_void_transactions;
        this.no_void_transactions_amount = no_void_transactions_amount;
        this.no_of_void_transactions = no_of_void_transactions;
        this.void_transactions_amount = void_transactions_amount;
        this.non_vat_sales = non_vat_sales;
        this.vat_sales = vat_sales;
        this.vat_exempt_sales = vat_exempt_sales;
        this.zero_rated_sales = zero_rated_sales;
        this.vat_amount = vat_amount;
        this.previous_reading = previous_reading;
        this.running_total = running_total;
        this.counter_id_starts = counter_id_starts;
        this.counter_id_ends = counter_id_ends;
        this.line_discount = line_discount;
        this.net_sales = net_sales;
    }

    public static void main(String[] args) {
        String business_name = System.getProperty("business_name", "XYZ Marketing");
        String address = System.getProperty("address", "Dumaguete City, Negros Oriental");
        String operated_by = System.getProperty("operated_by", "Operated by: Juan dela Cruz");
        String permit_no = System.getProperty("permit_no", "Permit No.: 0000000000");
        String tin_no = System.getProperty("tin_no", "TIN No.: 0000000000");
        String accreditation_no = System.getProperty("accreditation_no", "Accreditation No.: 0000000000");
        String serial_no = System.getProperty("serial_no", "Serial No.: 0000000000");
        String machine_no = System.getProperty("machine_no", "Machine No.: 0000000000");
        String reading_type = "Z Reading";
        String terminal_no = "All";
        String reading_date = "03/15/2016";
        String user = "All";
        double gross_sales = 1;
        double total_discounts = 2;
        double no_of_total_discounts = 3;
        double sc_discounts = 4;
        double no_of_sc_discounts = 5;
        double reg_discounts = 6;
        double no_of_reg_discounts = 7;
        double other_discounts = 8;
        double no_of_other_discounts = 9;
        double cash_payments = 10;
        double cheque_payments = 11;
        double credit_card_payments = 12;
        double gc_payments = 13;
        double prepaids = 14;
        double charge_payments = 15;
        int no_of_transactions = 16;
        double qty_sold = 17;
        double no_of_sku = 18;
        int no_of_no_void_transactions = 19;
        double no_void_transactions_amount = 20;
        int no_of_void_transactions = 21;
        double void_transactions_amount = 22;
        double non_vat_sales = 23;
        double vat_sales = 24;
        double vat_exempt_sales = 25;
        double zero_rated_sales = 26;
        double vat_amount = 27;
        double previous_reading = 28;
        double running_total = 29;
        String counter_id_starts = "0000000000001";
        String counter_id_ends = "00000000000069345";
        double line_discount = 30;
        double net_sales = 31;
        Reading rpt = new Reading(business_name, address, operated_by, permit_no, tin_no, accreditation_no, serial_no, machine_no, reading_type, terminal_no, reading_date, user, gross_sales, total_discounts, no_of_total_discounts, sc_discounts, no_of_sc_discounts, reg_discounts, no_of_reg_discounts, other_discounts, no_of_other_discounts, cash_payments, cheque_payments, credit_card_payments, gc_payments, prepaids, charge_payments, no_of_transactions, qty_sold, no_of_sku, no_of_no_void_transactions, no_void_transactions_amount, no_of_void_transactions, void_transactions_amount, non_vat_sales, vat_sales, vat_exempt_sales, zero_rated_sales, vat_amount, previous_reading, running_total, counter_id_starts, counter_id_ends, line_discount, net_sales);
        String jrxml = "rpt_z_reading.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Reading.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Reading to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

}
