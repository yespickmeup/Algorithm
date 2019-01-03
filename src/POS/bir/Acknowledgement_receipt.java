/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir;

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
public class Acknowledgement_receipt {

    public final String business_name;
    public final String operated_by;
    public final String address;
    public final String tin_no;
    public final String machine_no;
    public final String min_no;
    public final String serial_no;
    public final String permit_no;
    public final String pos_no;
    public final String accreditation_no;
    public final String business_type;
    public final String vat_percent;
    public final String sales_date;
    public final String terminal_no;
    public final String cashier;
    public final String customer_name;
    public final String customer_address;
    public final String customer_id_no;
    public final double sub_total;
    public final double line_discount;
    public final double sale_discount;
    public final double amount_due;
    public final double cash;
    public final String credit_card_type;
    public final double credit_card_rate;
    public final double credit_card_amount;
    public final String credit_card_no;
    public final String credit_card_holder;
    public final String credit_card_approval_code;
    public final String gift_certificate_from;
    public final String gift_certificate_description;
    public final String gift_certificate_no;
    public final double gift_certificate_amount;
    public final String prepaid_customer_name;
    public final String prepaid_customer_id;
    public final double prepaid_amount;
    public final String cheque_holder;
    public final String cheque_bank;
    public final String cheque_no;
    public final String cheque_date;
    public final double cheque_amount;
    public final String charge_type;
    public final String charge_reference_no;
    public final String charge_customer_name;
    public final String charge_customer_no;
    public final double charge_amount;
    public final double vatable_sales;
    public final double vatable_exempt_sales;
    public final double zero_rated_sales;
    public final double vat;
    public final double change;
    public final String or_no;
    public final String receipt_footer;
    public final String supplier_name;
    public final String supplier_address;
    public final String supplier_tin_no;
    public final String supplier_accreditation_no;
    public final String supplier_accreditation_date;
    public final String bir_permit_to_use_no;
    public final List<Acknowledgement_receipt.field> fields;
    public final double total_items;
    public final double online_payment;
    public Acknowledgement_receipt(String business_name, String operated_by, String address, String tin_no, String machine_no, String min_no, String serial_no, String permit_no, String pos_no, String accreditation_no, String business_type, String vat_percent, String sales_date, String terminal_no, String cashier, String customer_name, String customer_address, String customer_id_no, double sub_total, double line_discount, double sale_discount, double amount_due, double cash, String credit_card_type, double credit_card_rate, double credit_card_amount, String credit_card_no, String credit_card_holder, String credit_card_approval_code, String gift_certificate_from, String gift_certificate_description, String gift_certificate_no, double gift_certificate_amount, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String cheque_holder, String cheque_bank, String cheque_no, String cheque_date, double cheque_amount, String charge_type, String charge_reference_no, String charge_customer_name, String charge_customer_no, double charge_amount, double vatable_sales, double vatable_exempt_sales, double zero_rated_sales, double vat, double change, String or_no, String receipt_footer, String supplier_name, String supplier_address, String supplier_tin_no, String supplier_accreditation_no, String supplier_accreditation_date, String bir_permit_to_use_no,double total_items,double online_payment) {
        this.business_name = business_name;
        this.operated_by = operated_by;
        this.address = address;
        this.tin_no = tin_no;
        this.machine_no = machine_no;
        this.min_no = min_no;
        this.serial_no = serial_no;
        this.permit_no = permit_no;
        this.pos_no = pos_no;
        this.accreditation_no = accreditation_no;
        this.business_type = business_type;
        this.vat_percent = vat_percent;
        this.sales_date = sales_date;
        this.terminal_no = terminal_no;
        this.cashier = cashier;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_id_no = customer_id_no;
        this.sub_total = sub_total;
        this.line_discount = line_discount;
        this.sale_discount = sale_discount;
        this.amount_due = amount_due;
        this.cash = cash;
        this.credit_card_type = credit_card_type;
        this.credit_card_rate = credit_card_rate;
        this.credit_card_amount = credit_card_amount;
        this.credit_card_no = credit_card_no;
        this.credit_card_holder = credit_card_holder;
        this.credit_card_approval_code = credit_card_approval_code;
        this.gift_certificate_from = gift_certificate_from;
        this.gift_certificate_description = gift_certificate_description;
        this.gift_certificate_no = gift_certificate_no;
        this.gift_certificate_amount = gift_certificate_amount;
        this.prepaid_customer_name = prepaid_customer_name;
        this.prepaid_customer_id = prepaid_customer_id;
        this.prepaid_amount = prepaid_amount;
        this.cheque_holder = cheque_holder;
        this.cheque_bank = cheque_bank;
        this.cheque_no = cheque_no;
        this.cheque_date = cheque_date;
        this.cheque_amount = cheque_amount;
        this.charge_type = charge_type;
        this.charge_reference_no = charge_reference_no;
        this.charge_customer_name = charge_customer_name;
        this.charge_customer_no = charge_customer_no;
        this.charge_amount = charge_amount;
        this.vatable_sales = vatable_sales;
        this.vatable_exempt_sales = vatable_exempt_sales;
        this.zero_rated_sales = zero_rated_sales;
        this.vat = vat;
        this.change = change;
        this.or_no = or_no;
        this.receipt_footer = receipt_footer;
        this.supplier_name = supplier_name;
        this.supplier_address = supplier_address;
        this.supplier_tin_no = supplier_tin_no;
        this.supplier_accreditation_no = supplier_accreditation_no;
        this.supplier_accreditation_date = supplier_accreditation_date;
        this.bir_permit_to_use_no = bir_permit_to_use_no;
        this.fields = new ArrayList();
        this.total_items=total_items;
        this.online_payment=online_payment;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double selling_price;
        double line_discount;
        double amount;
        String vatable;

        public field() {
        }

        public field(String item_code, String barcode, String description, String unit, double qty, double selling_price, double line_discount, double amount, String vatable) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.selling_price = selling_price;
            this.line_discount = line_discount;
            this.amount = amount;
            this.vatable = vatable;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getVatable() {
            return vatable;
        }

        public void setVatable(String vatable) {
            this.vatable = vatable;
        }

    }

    public static void main(String[] args) {

        String business_name = System.getProperty("business_name", "XYZ Marketing");
        String operated_by = "Operated by: " + System.getProperty("operated_by", "Juan dela Cruz");
        String address = System.getProperty("address", "Canlas Subdivision, Lower Bagacay, Dumaguete City, Negros Oriental");
        String tin_no = "TIN NO: " + System.getProperty("tin_no", "0000000000");
        String machine_no = System.getProperty("machine_no", "0000000000");
        String min_no = "MIN NO: " + System.getProperty("min_no", "0000000000");
        String serial_no = "Serial No.: " + System.getProperty("serial_no", "0000000000");
        String permit_no = "Permit No.: " + System.getProperty("permit_no", "0000000000");
        String pos_no = System.getProperty("pos_no", "0000000000");
        String accreditation_no = System.getProperty("accreditation_no", "0000000000");
        String business_type = System.getProperty("business_type", "VAT REG");
        String vat_percent = System.getProperty("vat_percent", "12");
        String sales_date = "Date: " + System.getProperty("sales_date", "mm/dd/yy HH:MM:ss aa");
        String terminal_no = "Terminal No.: " + System.getProperty("terminal_no", "0001");
        String cashier = "Cashier: " + "Ronald Pascua";
        String customer_name = "Customer: " + "Juan Dela Cruz";
        String customer_address = "Address: " + "Dumaguete City";
        String customer_id_no = "ID/TIN No.: " + "000000000";
        double sub_total = 200;
        double line_discount = 20;
        double sale_discount = 50;
        double amount_due = 130;
        double cash = 500;
        String credit_card_type = "";
        double credit_card_rate = 0;
        double credit_card_amount = 0;
        String credit_card_no = "";
        String credit_card_holder = "";
        String credit_card_approval_code = "";
        String gift_certificate_from = "";
        String gift_certificate_description = "";
        String gift_certificate_no = "";
        double gift_certificate_amount = 0;
        String prepaid_customer_name = "";
        String prepaid_customer_id = "";
        double prepaid_amount = 0;
        String cheque_holder = "";
        String cheque_bank = "";
        String cheque_no = "";
        String cheque_date = "";
        double cheque_amount = 0;
        String charge_type = "";
        String charge_reference_no = "";
        String charge_customer_name = "";
        String charge_customer_no = "";
        double charge_amount = 0;
        double vatable_sales = 116.07;
        double vatable_exempt_sales = 0;
        double zero_rated_sales = 0;
        double vat = 13.92;
        double change = 370;
        String or_no = "OR No.: " + "14|000000000001";
        String receipt_footer = System.getProperty("receipt_footer", "THIS INVOICE/RECEIPT SHALL BE VALID FOR FIVE(5) YEARS FROM THE DATE OF THE PERMIT TO USE\nTHIS DOCUMENT IS NOT VALID FOR CLAIM OF INPUT TAX");
        String supplier_name = "Supplier: " + System.getProperty("developer", "Synapse Software Technologies");
        String supplier_address = System.getProperty("developer_address", "Daro, Dumaguete City, Negros Oriental");
        String supplier_tin_no = "TIN No.: " + System.getProperty("developer_tin_no", "0000000000");
        String supplier_accreditation_no = "Accreditation No.: " + System.getProperty("developer_accreditation_no", "0000000000");
        String supplier_accreditation_date = "Accreditation Date: " + System.getProperty("developer_accreditation_date", "mm/dd/yyyy");
        String bir_permit_to_use_no = "PTU No.: " + System.getProperty("bir_permit_to_use_no", "0000000000");
        List<Acknowledgement_receipt.field> fields = new ArrayList();
        for (int i = 0; i < 5; i++) {
            String item_code = "1000";
            String barcode = "";
            String description = "LAPTOP-ACER ASPIRE V15 V3-575G-74ZZ I7 6500U 4GB 1TB 15.6\" NVDGF940M+2GB W10";
            String unit = "pc";
            double qty = 1;
            double selling_price = 50;
            double line_discount1 = 5;
            double amount = 45;
            String vatable = "V";
            Acknowledgement_receipt.field field = new field(item_code, barcode, description, unit, qty, selling_price, line_discount, amount, vatable);
            fields.add(field);
        }
        double total_items=0;
        double online_payment=0;
        Acknowledgement_receipt rpt = new Acknowledgement_receipt(business_name, operated_by, address, tin_no, machine_no, min_no, serial_no, permit_no, pos_no, accreditation_no, business_type, vat_percent, sales_date, terminal_no, cashier, customer_name, customer_address, customer_id_no, sub_total, line_discount, sale_discount, amount_due, cash, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, cheque_amount, charge_type, charge_reference_no, charge_customer_name, charge_customer_no, charge_amount, vatable_sales, vatable_exempt_sales, zero_rated_sales, vat, change, or_no, receipt_footer, supplier_name, supplier_address, supplier_tin_no, supplier_accreditation_no, supplier_accreditation_date, bir_permit_to_use_no,total_items,online_payment);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_official_receipt.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Acknowledgement_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Acknowledgement_receipt to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
