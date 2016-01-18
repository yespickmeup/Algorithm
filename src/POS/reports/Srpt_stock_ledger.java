/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.inventory.Inventory_barcodes;
import POS.receipts.S1_receipt_items;
import POS.util.DateType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ronald
 */
public class Srpt_stock_ledger {

    public final List<field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;

    public Srpt_stock_ledger(String business_name, String date, String printed_by) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
    }

    public static class field {

        String date;
        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double amount;
        double total;
        String type;

        public field() {
        }

        public field(String date, String item_code, String barcode, String description, String unit, double qty, double amount, double total, String type) {
            this.date = date;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.amount = amount;
            this.total = total;
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static void main(String[] args) {
        List<field> fields = new ArrayList();
        List<S1_receipt_items.to_receipt_items> datas = S1_receipt_items.
                ret_data_ledger("5197", "", "");

        for (S1_receipt_items.to_receipt_items to : datas) {
            String date = to.date_added;
            String item_code = to.main_barcode;
            String barcode = to.barcode;
            String description = to.description;
            String unit = to.unit;
            double qty = to.qty;
            double amount = to.cost;
            double total = qty * amount;
            String type = "Receipt";
            field f = new field(date, item_code, barcode, description, unit, qty, amount, total, type);
            fields.add(f);
        }
        String business_name = System.
                getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        Srpt_stock_ledger rpt = new Srpt_stock_ledger(business_name, date, printed_by);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_stock_ledger.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_stock_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_stock_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
