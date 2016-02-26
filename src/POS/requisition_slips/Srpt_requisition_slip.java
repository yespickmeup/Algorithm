/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.requisition_slips;

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
public class Srpt_requisition_slip {

    public final String requisition_slip_no;
    public final String requisition_date;
    public final String requisition_type;
    public final String requisition_department;
    public final String requisition_department_id;
    public final String requested_by;
    public final String branch;
    public final String branch_id;
    public final String location;
    public final String location_id;
    public final String date_added;
    public final List<field> fields;

    public Srpt_requisition_slip(String requisition_slip_no, String requisition_date, String requisition_type, String requisition_department, String requisition_department_id, String requested_by, String branch, String branch_id, String location, String location_id, String date_added) {
        this.requisition_slip_no = requisition_slip_no;
        this.requisition_date = requisition_date;
        this.requisition_type = requisition_type;
        this.requisition_department = requisition_department;
        this.requisition_department_id = requisition_department_id;
        this.requested_by = requested_by;
        this.branch = branch;
        this.branch_id = branch_id;
        this.location = location;
        this.location_id = location_id;
        this.date_added = date_added;
        this.fields = new ArrayList();
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        double product_qty;
        String unit;
        double cost;
        double selling_price;

        public field() {
        }

        public field(String item_code, String barcode, String description, double product_qty, String unit, double cost, double selling_price) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.product_qty = product_qty;
            this.unit = unit;
            this.cost = cost;
            this.selling_price = selling_price;
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

    }

    public static void main(String[] args) {

        List<Srpt_requisition_slip.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String item_code = "0000";
            String barcode = "";
            String description = "description";
            double product_qty = 100;
            String unit = "unit";
            double cost = 100.00;
            double selling_price = 200;
            Srpt_requisition_slip.field field = new field(item_code, barcode, description, product_qty, unit, cost, selling_price);
            fields.add(field);

        }
        String requisition_slip_no = "000001";
        String requisition_date = "2016/01/01";
        String requisition_type = "Supply";
        String requisition_department = "department";
        String requisition_department_id = "1";
        String requested_by = "Ronald";
        String branch = "Branch";
        String branch_id = "Branch id";
        String location = "location";
        String location_id = "location id";
        String date_added = "asdad";

        Srpt_requisition_slip rpt = new Srpt_requisition_slip(requisition_slip_no, requisition_date, requisition_type, requisition_department, requisition_department_id, requested_by, branch, branch_id, location, location_id, date_added);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_requisition_slip.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_requisition_slip.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_requisition_slip to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}
