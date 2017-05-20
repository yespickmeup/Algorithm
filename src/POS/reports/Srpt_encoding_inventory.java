/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

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
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ronald
 */
public class Srpt_encoding_inventory {

    public final List<field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;
    public final String branch;
    public final String location;
    public final String counted_by;

    public Srpt_encoding_inventory(String business_name, String date, String printed_by, String branch, String location, String counted_by) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.branch = branch;
        this.location = location;
        this.counted_by = counted_by;
    }

    public static class field {

        String date_added;
        double qty;
        String item_code;
        String barcode;
        String description;
        String sheet_no;
        String counted_by;
        String location;
        double cost;
        double amount;

        public field() {
        }

        public field(String date_added, double qty, String item_code, String barcode, String description, String sheet_no, String counted_by, String location, double cost, double amount) {
            this.date_added = date_added;
            this.qty = qty;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.sheet_no = sheet_no;
            this.counted_by = counted_by;
            this.location = location;
            this.cost = cost;
            this.amount = amount;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCounted_by() {
            return counted_by;
        }

        public void setCounted_by(String counted_by) {
            this.counted_by = counted_by;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
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

        public String getSheet_no() {
            return sheet_no;
        }

        public void setSheet_no(String sheet_no) {
            this.sheet_no = sheet_no;
        }

    }

    public static void main(String[] args) {
        String where = "";
        List<Srpt_encoding_inventory.field> datas = ret_data(where);
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String sheet_no = "";
        String branch = "";
        String location = "";
        String counted_by = "";
        Srpt_encoding_inventory rpt = new Srpt_encoding_inventory(business_name, date, printed_by, branch, location, counted_by);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_encoding_inventory.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_encoding_inventory.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_encoding_inventory to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_encoding_inventory.field> ret_data(String where) {
        List<Srpt_encoding_inventory.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",qty"
                    + ",date_added"
                    + ",user_name"
                    + ",screen_name"
                    + ",sheet_no"
                    + ",status"
                    + ",counted_by"
                    + ",checked_by"
                    + ",cost"
                    + " from encoding_inventory "
                    + " " + where
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = rs.getString(7);
                String location_id = rs.getString(8);
                double qty = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_name = rs.getString(11);
                String screen_name = rs.getString(12);
                String sheet_no = rs.getString(13);
                int status = rs.getInt(14);
                String counted_by = rs.getString(15);
                String checked_by = rs.getString(16);
                String loc = branch + " - " + location;
                double cost = rs.getDouble(17);
                double amount = qty * cost;
                Srpt_encoding_inventory.field field = new field(date_added, qty, item_code, barcode, description, sheet_no, counted_by, loc, cost, amount);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_encoding_inventory.field> ret_data2(String where) {
        List<Srpt_encoding_inventory.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",sum(qty)"
                    + ",date_added"
                    + ",user_name"
                    + ",screen_name"
                    + ",sheet_no"
                    + ",status"
                    + ",counted_by"
                    + ",checked_by"
                    + ",cost"
                    + " from encoding_inventory "
                    + " " + where
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = rs.getString(7);
                String location_id = rs.getString(8);
                double qty = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_name = rs.getString(11);
                String screen_name = rs.getString(12);
                String sheet_no = rs.getString(13);
                int status = rs.getInt(14);
                String counted_by = rs.getString(15);
                String checked_by = rs.getString(16);
                String loc = branch + " - " + location;
                double cost = rs.getDouble(17);
                double amount = qty * cost;
                Srpt_encoding_inventory.field field = new field(date_added, qty, item_code, barcode, description, sheet_no, counted_by, loc, cost, amount);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
