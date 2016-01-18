/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.branch_locations.S1_branch_locations.to_branch_locations;
import static POS.reports.Dlg_report_encoding_inventory.compileJasper_stock_take_status;
import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ronald
 */
public class Srpt_stock_status {

    public final List<field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;

    public Srpt_stock_status(String business_name, String date, String printed_by) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
    }

    public static class field {

        double qty;
        String item_code;
        String barcode;
        String description;
        String unit;
        double cost;
        double price;
        String branch;
        String location;

        public field() {
        }

        public field(double qty, String item_code, String barcode, String description, String unit, double cost, double price, String branch, String location) {
            this.qty = qty;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.cost = cost;
            this.price = price;
            this.branch = branch;
            this.location = location;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
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

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }

    public static void main(String[] args) {

        long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("Heap Size = " + heapSize);

        String where = "";
        List<Srpt_stock_status.field> fields = Srpt_stock_status.ret_data(where);
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        Srpt_stock_status rpt = new Srpt_stock_status(business_name, date, printed_by);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_stock_status.jrxml";
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileJasper_stock_take_status(jrxml),
                                                                   JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

            final JRViewer viewer = new JRViewer(jasperPrint);

            SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    JFrame pnl = new JFrame();
                    pnl.add(viewer);
                    pnl.setSize(500, 500);
                    pnl.setVisible(true);
                    return null;
                }

                @Override
                protected void done() {

                }
            };
            sw.execute();

        } catch (JRException ex) {
            Logger.getLogger(Srpt_stock_status.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_stock_status.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

    }

    public static JRViewer get_viewer(Srpt_stock_status to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_stock_status.field> ret_data(String where) {
        List<Srpt_stock_status.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
//            List<to_branch_locations> locations = ret_locations("");

            String s0 = "select "
                    + "product_qty"
                    + ",main_barcode"
                    + ",barcode"
                    + ",description"
                    + ",unit"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",location"
                    + " from inventory_barcodes "
                    + " " + where
                    //                        + " where location_id='" + loc.id + "'"
                    + " order by location_id,id asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                double product_qty = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String unit = rs.getString(5);
                double cost = rs.getDouble(6);
                double selling_price = rs.getDouble(7);
                String branch = rs.getString(8);
                String location = rs.getString(9);

                field field = new field(product_qty, item_code, barcode, description, unit, cost, selling_price, branch, location);
                datas.add(field);
                System.out.println(item_code);
            }

            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_locations(String search) {
        List<to_branch_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);

                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
