/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.item_replacements;

import POS.stock_transfer.Srpt_stock_transfer;
import POS.util.DateType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_return_exchange {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String item_replacement_no;
    public final String sales_no;
    public final String customer_name;
    public final String customer_id;
    public final String date_added;
    public final String user_screen_name;
    public final String reason;
    public final double amount_due;
    public final double replacement_amount;
    public final double discount;
    public final String branch;
    public final String location;
    public final double amount;
    public final List<field> fields;

    public Srpt_return_exchange(String business_name,String address,String contact_no,String item_replacement_no, String sales_no, String customer_name, String customer_id, String date_added, String user_screen_name, String reason, double amount_due, double replacement_amount, double discount, String branch, String location,double amount) {
        this.business_name=business_name;
        this.address=address;
        this.contact_no=contact_no;
        this.item_replacement_no = item_replacement_no;
        this.sales_no = sales_no;
        this.customer_name = customer_name;
        this.customer_id = customer_id;
        this.date_added = date_added;
        this.user_screen_name = user_screen_name;
        this.reason = reason;
        this.amount_due = amount_due;
        this.replacement_amount = replacement_amount;
        this.discount = discount;
        this.branch = branch;
        this.location = location;
        this.fields = new ArrayList();
        this.amount=amount;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String serial_no;
        double product_qty;
        String unit;
        double conversion;
        double selling_price;
        double discount_amount;
        double amount;
        String replacement_type;

        public field() {
        }

        public field(String item_code, String barcode, String description, String serial_no, double product_qty, String unit, double conversion, double selling_price, double discount_amount, double amount, String replacement_type) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.serial_no = serial_no;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.discount_amount = discount_amount;
            this.amount = amount;
            this.replacement_type = replacement_type;
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

        public String getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(String serial_no) {
            this.serial_no = serial_no;
        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

       

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getReplacement_type() {
            return replacement_type;
        }

        public void setReplacement_type(String replacement_type) {
            this.replacement_type = replacement_type;
        }
    }

    public static void main(String[] args) {

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Dumaguete");
        String contact_no = System.getProperty("contact_no", "2342342");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String transaction_no = "3598";
        String from_branch = "DGT-Algorithm Computer Services";
        String from_location = "SEL-ALGO Selling Area";
        String to_branch = "DGT-Algorithm Computer Services";
        String to_location = "ZKA-ALGO Selling Area";

    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_return_exchange.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer Srpt_return_exchange(Srpt_stock_transfer to, String jrxml) {
        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
