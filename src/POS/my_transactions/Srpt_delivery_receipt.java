/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_transactions;

import POS.sales.Sales_item.to_sales_item;
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
public class Srpt_delivery_receipt {

    public final List<Srpt_delivery_receipt.field> fields;
    public final String remarks;
    public final String transaction_no;
    public final String date;
    public final double gross_total;
    public final double line_discount;
    public final double sales_discount;
    public final double net_due;

    public Srpt_delivery_receipt(String remarks, String transaction_no, String date, double gross_total, double line_discount, double sales_discount, double net_due) {
        this.fields = new ArrayList();
        this.remarks = remarks;
        this.transaction_no = transaction_no;
        this.date = date;
        this.gross_total = gross_total;
        this.line_discount = line_discount;
        this.sales_discount = sales_discount;
        this.net_due = net_due;
    }

    public static class field {

        double qty;
        String item_code;
        String barcode;
        String description;
        double selling_price;
        String unit;
        double discount;
        double net_due;

        public field() {
        }

        public field(double qty, String item_code, String barcode, String description, double selling_price, String unit, double discount, double net_due) {
            this.qty = qty;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.selling_price = selling_price;
            this.unit = unit;
            this.discount = discount;
            this.net_due = net_due;
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

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getNet_due() {
            return net_due;
        }

        public void setNet_due(double net_due) {
            this.net_due = net_due;
        }
    }

    public static void main(String[] args) {

        List<Srpt_delivery_receipt.field> datas = Srpt_delivery_receipt.ret_data("");
        String remarks = "";
        String transaction_no = "";
        String date = "";
        double gross_total = 0;
        double line_discount = 0;
        double sales_discount = 0;
        double net_due = 0;
        Srpt_delivery_receipt rpt = new Srpt_delivery_receipt(remarks, transaction_no, date, gross_total, line_discount, sales_discount, net_due);

        rpt.fields.addAll(datas);
        String jrxml = "rpt_delivery_receipt.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport
            compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_delivery_receipt.class
                    .getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_delivery_receipt to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_delivery_receipt.field> ret_data(String where) {
        List<Srpt_delivery_receipt.field> datas = new ArrayList();

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
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",added_by"
                    + ",or_no"
                    + ",serial_no"
                    + " from sales_item  "
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
                String main_barcode = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String discount_name = rs.getString(37);
                double discount_rate = rs.getDouble(38);
                double discount_amount = rs.getDouble(39);
                String added_by = rs.getString(40);
                String or_no = rs.getString(41);
                String serial_no = rs.getString(42);

                Srpt_delivery_receipt.field to = new field(product_qty, main_barcode, barcode, description, selling_price, unit, discount_amount, selling_price - discount_amount);
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
