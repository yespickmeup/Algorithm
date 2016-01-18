/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
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
 * @author Guinness
 */
public class Srpt_inventory_available_stocks {

    public final List<Srpt_inventory_available_stocks.field> fields;
    public final String business_name;
    public final String address;
    public final String date;
    public final String branch;
    public final String location1;
    public final String location2;
    public final String location3;
    public final String location4;
    public final String location5;
    public final String location6;
    public final String location7;

    public Srpt_inventory_available_stocks(String business_name, String address, String date, String branch, String location1, String location2, String location3, String location4, String location5, String location6, String location7) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location1 = location1;
        this.location2 = location2;
        this.location3 = location3;
        this.location4 = location4;
        this.location5 = location5;
        this.location6 = location6;
        this.location7 = location7;
    }

    public static class field {

        double qty;
        String item_code;
        String barcode;
        String description;
        String unit;
        String branch;
        String location;
        String location_id;
        double cost;
        double price;
        double location1;
        double location2;
        double location3;
        double location4;
        double location5;
        double location6;
        double location7;

        public field() {
        }

        public field(double qty, String item_code, String barcode, String description, String unit, String branch, String location, String location_id, double cost, double price, double location1, double location2, double location3, double location4, double location5, double location6, double location7) {
            this.qty = qty;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.branch = branch;
            this.location = location;
            this.location_id = location_id;
            this.cost = cost;
            this.price = price;
            this.location1 = location1;
            this.location2 = location2;
            this.location3 = location3;
            this.location4 = location4;
            this.location5 = location5;
            this.location6 = location6;
            this.location7 = location7;
        }

        public double getLocation7() {
            return location7;
        }

        public void setLocation7(double location7) {
            this.location7 = location7;
        }

        public double getLocation1() {
            return location1;
        }

        public void setLocation1(double location1) {
            this.location1 = location1;
        }

        public double getLocation2() {
            return location2;
        }

        public void setLocation2(double location2) {
            this.location2 = location2;
        }

        public double getLocation3() {
            return location3;
        }

        public void setLocation3(double location3) {
            this.location3 = location3;
        }

        public double getLocation4() {
            return location4;
        }

        public void setLocation4(double location4) {
            this.location4 = location4;
        }

        public double getLocation5() {
            return location5;
        }

        public void setLocation5(double location5) {
            this.location5 = location5;
        }

        public double getLocation6() {
            return location6;
        }

        public void setLocation6(double location6) {
            this.location6 = location6;
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

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
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
    }

    public static void main(String[] args) {

        S1_branch_locations.to_branch_locations def = S4_branch_locations.ret_data();
        String where2 = " where branch_id='" + def.branch_id + "' order by location asc ";
        List<S1_branch_locations.to_branch_locations> locations = S1_branch_locations.ret_where(where2);

        System.out.println("Retrieving items...");
        String where = " where location_id='" + def.id + "' group by main_barcode,barcode,branch_code,location_id order by main_barcode,barcode,description asc";
        List<Srpt_inventory_available_stocks.field> fields = ret_data(where, locations);
        System.out.println("Done...");

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Dumaguete City");
        String date = DateType.slash.format(new Date());
        String branch = "Dumaguete";
        String branch_code = "9";

        String[] setting = new String[7];
        setting[0] = "";
        setting[1] = "";
        setting[2] = "";
        setting[3] = "";
        setting[4] = "";
        setting[5] = "";
        setting[6] = "";
        int i = 0;
        for (S1_branch_locations.to_branch_locations loc : locations) {
            setting[i] = loc.location;
            i++;
        }
        Srpt_inventory_available_stocks rpt = new Srpt_inventory_available_stocks(business_name, address, date, branch, setting[0], setting[1], setting[2], setting[3], setting[4], setting[5], setting[6]);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_inventory_available_stocks.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_inventory_available_stocks.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_inventory_available_stocks to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_inventory_available_stocks.field> ret_data(String where, List<S1_branch_locations.to_branch_locations> locations) {
        List<Srpt_inventory_available_stocks.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",serial_no"
                    + " from inventory_barcodes"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                int main_barcode = rs.getInt(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String serial_no = rs.getString(37);

                double qty = product_qty;
                String item_code = "" + main_barcode;
                double price = selling_price;

                double[] aw = new double[7];
                aw[0] = 0;
                aw[1] = 0;
                aw[2] = 0;
                aw[3] = 0;
                aw[4] = 0;
                aw[5] = 0;
                aw[6] = 0;
                int i = 0;

                for (S1_branch_locations.to_branch_locations l : locations) {
                    String s5 = " select product_qty from inventory_barcodes where main_barcode='" + item_code + "' and barcode='" + barcode + "' and location_id='" + l.id + "' ";
                    Statement stmt5 = conn.createStatement();
                    ResultSet rs5 = stmt5.executeQuery(s5);
                    while (rs5.next()) {
                        aw[i] = rs5.getDouble(1);

                    }
                    i++;
                }
                System.out.println("Item Code: " + item_code + " | " + aw[0] + " | " + aw[1] + " | " + aw[2] + " | " + aw[3] + " | " + aw[4] + " | " + aw[5] + " | " + aw[6]);
                Srpt_inventory_available_stocks.field field = new field(qty, item_code, barcode, description, unit, branch, location, location_id, cost, price, aw[0], aw[1], aw[2], aw[3], aw[4], aw[5], aw[6]);
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
