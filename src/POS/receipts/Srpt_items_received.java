/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.uom;
import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Srpt_items_received {

    public final List<field> fields;
    public final String business_name;
    public final String address;
    public final String date;
    public final String branch;
    public final String location;
    public final String supplier;
    public final String type;
    public final String status;
    public Srpt_items_received(String business_name, String address, String date, String branch, String location,String supplier,String type,String status) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.supplier=supplier;
        this.type=type;
        this.status=status;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String unit;
        double cost;
        double selling_price;
        double discount;
        double amount;
        String branch;
        String branch_id;
        String location;
        String location_id;
        String supplier;
        String supplier_id;
        String date_added;
        String date_received;
        String date_delivered;
        double qty;

        public field() {
        }

        public field(String item_code, String barcode, String description, String unit, double cost, double selling_price, double discount, double amount, String branch, String branch_id, String location, String location_id, String supplier, String supplier_id, String date_added, String date_received, String date_delivered, double qty) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.cost = cost;
            this.selling_price = selling_price;
            this.discount = discount;
            this.amount = amount;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.date_added = date_added;
            this.date_received = date_received;
            this.date_delivered = date_delivered;
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

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
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

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public String getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(String supplier_id) {
            this.supplier_id = supplier_id;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getDate_received() {
            return date_received;
        }

        public void setDate_received(String date_received) {
            this.date_received = date_received;
        }

        public String getDate_delivered() {
            return date_delivered;
        }

        public void setDate_delivered(String date_delivered) {
            this.date_delivered = date_delivered;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

    }

    public static void main(String[] args) {
//        System.setProperty("pool_db", "db_algorithm");
        String where = " where Date(date_received) between '2017-04-01' and '2017-04-11' ";
        where = where + " "
                + " group by Date(date_received),location_id,main_barcode,cost "
                + " order by Date(date_received),location_id,description asc ";
        List<Srpt_items_received.field> fields = Srpt_items_received.ret_data(where);

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City Negros Oriental");
        String date = "04/16/2017";
        String branch = "Dumaguete City";
        String location = "Selling Area";
        String supplier="";
        String type="";
        String status="";
        Srpt_items_received rpt = new Srpt_items_received(business_name, address, date, branch, location,supplier,type,status);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_items_received.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_items_received.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_items_received to, String jrxml) {
        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_items_received.field> ret_data(String where) {
        List<Srpt_items_received.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",sum(qty)"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",barcodes"
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",status"
                    + ",previous_cost"
                    + ",receipt_type_id"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from receipt_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String batch_no = rs.getString(24);
                String serial_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);
                Dlg_inventory_uom.to_uom uoms = uom.default_uom(unit);
                if (uoms != null) {
                    unit = uoms.uom;
                }
                double amount = qty * cost;
                date_received=DateType.convert_jan_1_2013_sf(date_received);
                Srpt_items_received.field field = new field(main_barcode, barcode, description, unit, cost, conversion, cost, amount, branch, branch_id, location, location_id, supplier, supllier_id, date_added, date_received, date_delivered, qty);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
    public static List<Srpt_items_received.field> ret_data2(String where) {
        List<Srpt_items_received.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",sum(qty)"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",barcodes"
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",status"
                    + ",previous_cost"
                    + ",receipt_type_id"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from Receipts_service_center_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String batch_no = rs.getString(24);
                String serial_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);
                Dlg_inventory_uom.to_uom uoms = uom.default_uom(unit);
                if (uoms != null) {
                    unit = uoms.uom;
                }
                double amount = qty * cost;
                date_received=DateType.convert_jan_1_2013_sf(date_received);
                Srpt_items_received.field field = new field(main_barcode, barcode, description, unit, cost, conversion, cost, amount, branch, branch_id, location, location_id, supplier, supllier_id, date_added, date_received, date_delivered, qty);
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
