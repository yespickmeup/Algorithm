/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports3;

import POS.inventory.Inventory;
import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_stock_take_captured {

    public final List<field> fields;
    public final String category;
    public final String classification;
    public final String sub_classification;
    public final String brand;
    public final String model;
    public final String business_name;
    public final String date;
    public final String branch;
    public final String location;

    public Srpt_stock_take_captured(String category, String classification, String sub_classification, String brand, String model, String business_name, String date, String branch, String location) {
        this.fields = new ArrayList();
        this.category = category;
        this.classification = classification;
        this.sub_classification = sub_classification;
        this.brand = brand;
        this.model = model;
        this.business_name = business_name;
        this.date = date;
        this.branch = branch;
        this.location = location;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        double qty;
        double selling_price;
        double cost;
        String uom;
        String code;
        String location;

        public field() {
        }

        public field(String item_code, String barcode, String description, double qty, double selling_price, double cost, String uom, String code, String location) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.selling_price = selling_price;
            this.cost = cost;
            this.uom = uom;
            this.code = code;
            this.location = location;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

    }

    public static void main(String[] args) {

        List<Srpt_stock_take_captured.field> datas = set(new ArrayList());
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";

        String category = "";
        String classification = "";
        String sub_classification = "";
        String brand = "";
        String model = "";

        Srpt_stock_take_captured rpt = new Srpt_stock_take_captured(category, classification, sub_classification, brand, model, business_name, date, "", "");
        rpt.fields.addAll(datas);
        String jrxml = "rpt_stock_take.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void generate(List<Srpt_stock_take_captured.field> datas1) {

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String category = "";
        String classification = "";
        String sub_classification = "";
        String brand = "";
        String model = "";

        Srpt_stock_take_captured rpt = new Srpt_stock_take_captured(category, classification, sub_classification, brand, model, business_name, date, "", "");
        rpt.fields.addAll(datas1);
        String jrxml = "rpt_stock_take.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_stock_take_captured.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_stock_take_captured to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_stock_take_captured.field> set(List<Inventory.to_inventory> datas) {

        List<Srpt_stock_take_captured.field> fields = new ArrayList();

//        for (S1_inventory.to_inventory f : datas) {
//            String item_code = f.barcodes;
//            String barcode = f.barcode;
//            String description = f.description;
//            double qty = f.product_qty;
//            double selling_price = f.selling_price;
//            double cost = f.cost;
//            String uom = f.unit;
//            Srpt_stock_take.field field = new field(item_code, item_code, description, qty, selling_price, cost, uom, f.barcodes);
//            fields.add(field);
//        }
        return fields;
    }

    public static List<Srpt_stock_take_captured.field> ret_data(String where) {
        List<Srpt_stock_take_captured.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",stock_take_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",conversion"
                    + ",unit"
                    + ",barcodes"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from stock_take_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String stock_take_no = rs.getString(2);
                String user_id = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String date_added = rs.getString(5);
                String remarks = rs.getString(6);
                String barcode = rs.getString(7);
                String description = rs.getString(8);
                String category = rs.getString(9);
                String category_id = rs.getString(10);
                String classification = rs.getString(11);
                String classification_id = rs.getString(12);
                String sub_class = rs.getString(13);
                String sub_class_id = rs.getString(14);
                String brand = rs.getString(15);
                String brand_id = rs.getString(16);
                String model = rs.getString(17);
                String model_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String barcodes = rs.getString(21);
                String main_barcode = rs.getString(22);
                double qty = rs.getDouble(23);
                double cost = rs.getDouble(24);
                double selling_price = rs.getDouble(25);
                String branch = rs.getString(26);
                String branch_id = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);

                String loc = branch + " - " + location;

//                String uom = unit;
//                String[] list = uom.split(",");
//                double conv = 1;
//                for (String s : list) {
//                    int i = s.indexOf(":");
//                    int ii = s.indexOf("/");
//                    double conv1 = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
//                    double sell = FitIn.toDouble(s.substring(i + 1, ii));
//                    if (conv1 >conv ) {
//                        conv = conv1;
//                        break;
//                    }
//                }
//                qty = qty / conv;
//                String s2 = "select "
//                        + " conversion"
//                        + " from receipt_items where main_barcode='" + main_barcode + "' and location_id='" + location_id + "' order by id desc limit 1"
//                        + " ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs2.next()) {
//                    conversion = rs2.getDouble(1);
//                }
//                cost = cost / conversion;
                Srpt_stock_take_captured.field field = new field("" + main_barcode, barcode, description, qty, selling_price, cost, unit, "" + main_barcode, loc);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_stock_take_captured.field> ret_data_adjust(String where) {
        List<Srpt_stock_take_captured.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",stock_take_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",conversion"
                    + ",unit"
                    + ",barcodes"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from stock_take_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String stock_take_no = rs.getString(2);
                String user_id = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String date_added = rs.getString(5);
                String remarks = rs.getString(6);
                String barcode = rs.getString(7);
                String description = rs.getString(8);
                String category = rs.getString(9);
                String category_id = rs.getString(10);
                String classification = rs.getString(11);
                String classification_id = rs.getString(12);
                String sub_class = rs.getString(13);
                String sub_class_id = rs.getString(14);
                String brand = rs.getString(15);
                String brand_id = rs.getString(16);
                String model = rs.getString(17);
                String model_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String barcodes = rs.getString(21);
                String main_barcode = rs.getString(22);
                double qty = rs.getDouble(23);
                double cost = rs.getDouble(24);
                double selling_price = rs.getDouble(25);
                String branch = rs.getString(26);
                String branch_id = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);

                String loc = branch + " - " + location;

//                String uom = unit;
//                String[] list = uom.split(",");
//                double conv = 1;
//                for (String s : list) {
//                    int i = s.indexOf(":");
//                    int ii = s.indexOf("/");
//                    double conv1 = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
//                    double sell = FitIn.toDouble(s.substring(i + 1, ii));
//                    if (conv1 >conv ) {
//                        conv = conv1;
//                        break;
//                    }
//                }
//                qty = qty / conv;
                String s2 = "select "
                        + " conversion"
                        + " from receipt_items where main_barcode='" + main_barcode + "' and location_id='" + location_id + "' "
                        + " and cost='" + cost + "' order by id desc limit 1"
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    conversion = rs2.getDouble(1);
                }

                cost = cost / conversion;
                String s3 = "update stock_take_items set "
                        + " conversion= :conversion "
                        + ",cost= :cost "
                        + " where id='" + id + "' "
                        + " ";
                s3 = SqlStringUtil.parse(s3)
                        .setNumber("conversion", conversion)
                        .setNumber("cost", cost)
                        .ok();

                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();
                System.out.println(s3);
                Srpt_stock_take_captured.field field = new field("" + main_barcode, barcode, description, qty, selling_price, cost, unit, "" + main_barcode, loc);
                datas.add(field);
            }
            Lg.i(Srpt_stock_take_captured.class, "Updated!");
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
