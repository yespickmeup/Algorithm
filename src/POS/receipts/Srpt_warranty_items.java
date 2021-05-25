/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import static POS.receipts.Receipts.to;
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
import synsoftech.util.DateType;

/**
 *
 * @author User
 */
public class Srpt_warranty_items {

    public final String business_name;
    public final String address;
    public final String date;
    public final String branch;
    public final String location;
    public final String supplier;
    public final String type;
    public final String status;
    public final List<field> fields;

    public Srpt_warranty_items(String business_name, String address, String date, String branch, String location, String supplier, String type, String status) {
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.supplier = supplier;
        this.type = type;
        this.status = status;
        this.fields = new ArrayList();
    }

    public static class field {

        String slip_no;
        String item_code;
        double qty;
        String description;
        double cost;
        double price;
        String warranty_date;
        String transaction_type;
        String status;

        public field() {
        }

        public field(String slip_no, String item_code, double qty, String description, double cost, double price, String warranty_date, String transaction_type, String status) {
            this.slip_no = slip_no;
            this.item_code = item_code;
            this.qty = qty;
            this.description = description;
            this.cost = cost;
            this.price = price;
            this.warranty_date = warranty_date;
            this.transaction_type = transaction_type;
            this.status = status;
        }

        public String getSlip_no() {
            return slip_no;
        }

        public void setSlip_no(String slip_no) {
            this.slip_no = slip_no;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public String getWarranty_date() {
            return warranty_date;
        }

        public void setWarranty_date(String warranty_date) {
            this.warranty_date = warranty_date;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("pool_password","password");
        String where = "";
        List<Srpt_warranty_items.field> fields = Srpt_warranty_items.ret_data(where);

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City Negros Oriental");
        String date = "04/16/2017";
        String branch = "Dumaguete City";
        String location = "Selling Area";
        String supplier = "";
        String type = "";
        String status = "";
        Srpt_warranty_items rpt = new Srpt_warranty_items(business_name, address, date, branch, location, supplier, type, status);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_warranty_items.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_warranty_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_warranty_items to, String jrxml) {
        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<field> ret_data(String where) {
        List<field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",remarks"
                    + ",trans_type"
                    + ",supplier"
                    + ",supplier_id"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",selling_price"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",warranty_date"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",status"
                    + ",created_at"
                    + ",created_by"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",slip_no"
                    + " from warranty_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String remarks = rs.getString(3);
                String trans_type = rs.getString(4);
                String supplier = rs.getString(5);
                String supplier_id = rs.getString(6);
                String barcode = rs.getString(7);
                String description = rs.getString(8);
                double qty = rs.getDouble(9);
                double cost = rs.getDouble(10);
                double selling_price = rs.getDouble(11);
                String category = rs.getString(12);
                String category_id = rs.getString(13);
                String classification = rs.getString(14);
                String classification_id = rs.getString(15);
                String sub_class = rs.getString(16);
                String sub_class_id = rs.getString(17);
                double conversion = rs.getDouble(18);
                String unit = rs.getString(19);
                String warranty_date = rs.getString(20);
                String serial_no = rs.getString(21);
                String main_barcode = rs.getString(22);
                String brand = rs.getString(23);
                String brand_id = rs.getString(24);
                String model = rs.getString(25);
                String model_id = rs.getString(26);
                int status = rs.getInt(27);
                String created_at = rs.getString(28);
                String created_by = rs.getString(29);
                String branch = rs.getString(30);
                String branch_id = rs.getString(31);
                String location = rs.getString(32);
                String location_id = rs.getString(33);
                String slip_no = rs.getString(34);

                String item_code = main_barcode;

                double price = selling_price;
                warranty_date = DateType.convert_slash_datetime2(warranty_date);
                String transaction_type=trans_type;
                String status1 = "Posted";
                if (status == 1) {
                    status1 = "Finalized";
                }
               
                field f = new field(slip_no, item_code, qty, description, cost, price, warranty_date, transaction_type, status1);

                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
