/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory_reports;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class Srpt_reorder_level {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String branch;
    public final String branch_id;
    public final String location;
    public final String location_id;
    public final String date;
    public final String printed_by;
    public final List<Srpt_reorder_level.field> fields;

    public Srpt_reorder_level(String business_name, String address, String contact_no, String branch, String branch_id, String location, String location_id, String date, String printed_by) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.branch = branch;
        this.branch_id = branch_id;
        this.location = location;
        this.location_id = location_id;
        this.date = date;
        this.printed_by = printed_by;
        this.fields = new ArrayList();
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double cost;
        double selling_price;
        String branch;
        String branch_id;
        String location;
        String location_id;

        public field() {
        }

        public field(String item_code, String barcode, String description, String unit, double qty, double cost, double selling_price, String branch, String branch_id, String location, String location_id) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.cost = cost;
            this.selling_price = selling_price;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
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

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(String branch_id) {
            this.branch_id = branch_id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }
    }

    public static void main(String[] args) {

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro Highway, Dumaguete City, Negros Oriental");
        String contact_no = "422-7890/422-9000(144)";
        String branch = "Algorithm - Dgte";
        String branch_id = "9";
        String location = "Selling Area";
        String location_id = "14";
        String date = "January 9, 2016";
        String printed_by = "Administrator";

        String where = " where location_id='" + "14" + "' order by description asc ";
        List<Inventory_barcodes.to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);
        List<Srpt_reorder_level.field> fields = new ArrayList();
        for (Inventory_barcodes.to_inventory_barcodes field : datas) {
            if (field.product_qty < field.reorder_level) {

                String item_code = field.main_barcode;
                String barcode = field.barcode;
                String description = field.description;
                String unit = field.unit;
                double qty = field.product_qty;

                Dlg_inventory_uom.to_uom uoms = uom.default_uom(unit);
                unit = uoms.uom;
                
                
                double cost = field.cost;
                double selling_price = field.selling_price;
                String branch1 = field.branch;
                String branch_id1 = field.branch_code;
                String location1 = field.location;
                String location_id1 = field.location_id;
                Srpt_reorder_level.field f = new field(item_code, barcode, description, unit, qty, cost, selling_price, branch1, branch_id1, location1, location_id1);
                fields.add(f);
            }
        }

        Collections.sort(fields, new Comparator<Srpt_reorder_level.field>() {
            @Override
            public int compare(Srpt_reorder_level.field z1, Srpt_reorder_level.field z2) {
                if (z1.qty < z2.qty) {
                    return 1;
                }
                if (z1.qty > z2.qty) {
                    return -1;
                }
                return 0;
            }
        });

        Srpt_reorder_level rpt = new Srpt_reorder_level(business_name, address, contact_no, branch, branch_id, location, location_id, date, printed_by);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_reorder_level.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_reorder_level.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_reorder_level to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
