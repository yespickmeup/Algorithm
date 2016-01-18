/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.test2.pisps_items;
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
public class Srpt_inventory_matching {

    public final List<Srpt_inventory_matching.field> fields;

    public Srpt_inventory_matching() {
        this.fields = new ArrayList();
    }

    public static class field {

        String new_item_code;
        String new_barcode;
        String new_description;
        double new_cost;
        double new_price;

        String old_item_code;
        String old_barcode;
        String old_description;
        double old_cost;
        double old_price;
        int no;

        public field() {
        }

        public field(String new_item_code, String new_barcode, String new_description, double new_cost, double new_price, String old_item_code, String old_barcode, String old_description, double old_cost, double old_price, int no) {
            this.new_item_code = new_item_code;
            this.new_barcode = new_barcode;
            this.new_description = new_description;
            this.new_cost = new_cost;
            this.new_price = new_price;
            this.old_item_code = old_item_code;
            this.old_barcode = old_barcode;
            this.old_description = old_description;
            this.old_cost = old_cost;
            this.old_price = old_price;
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getNew_item_code() {
            return new_item_code;
        }

        public void setNew_item_code(String new_item_code) {
            this.new_item_code = new_item_code;
        }

        public String getNew_barcode() {
            return new_barcode;
        }

        public void setNew_barcode(String new_barcode) {
            this.new_barcode = new_barcode;
        }

        public String getNew_description() {
            return new_description;
        }

        public void setNew_description(String new_description) {
            this.new_description = new_description;
        }

        public double getNew_cost() {
            return new_cost;
        }

        public void setNew_cost(double new_cost) {
            this.new_cost = new_cost;
        }

        public double getNew_price() {
            return new_price;
        }

        public void setNew_price(double new_price) {
            this.new_price = new_price;
        }

        public String getOld_item_code() {
            return old_item_code;
        }

        public void setOld_item_code(String old_item_code) {
            this.old_item_code = old_item_code;
        }

        public String getOld_barcode() {
            return old_barcode;
        }

        public void setOld_barcode(String old_barcode) {
            this.old_barcode = old_barcode;
        }

        public String getOld_description() {
            return old_description;
        }

        public void setOld_description(String old_description) {
            this.old_description = old_description;
        }

        public double getOld_cost() {
            return old_cost;
        }

        public void setOld_cost(double old_cost) {
            this.old_cost = old_cost;
        }

        public double getOld_price() {
            return old_price;
        }

        public void setOld_price(double old_price) {
            this.old_price = old_price;
        }

    }

    public static void main(String[] args) {
        List<Srpt_inventory_matching.field> fields = pisps_items.pisps();
        List<Srpt_inventory_matching.field> compare = new ArrayList();

        for (Srpt_inventory_matching.field f : fields) {
            if (!f.new_description.equalsIgnoreCase(f.old_description) || f.new_cost != f.old_cost || f.new_price != f.old_price) {
                compare.add(f);
            }

        }

        Srpt_inventory_matching rpt = new Srpt_inventory_matching();
        rpt.fields.addAll(compare);
        String jrxml = "rpt_inventory_matching.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_inventory_matching.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_inventory_matching to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}
