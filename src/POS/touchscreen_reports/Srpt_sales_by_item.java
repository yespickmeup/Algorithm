/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

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
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_sales_by_item {

    public final List<Srpt_sales_by_item.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;
    public final String category;
    public final String classification;
    public final String sub_classification;
    public final String brand;
    public final String model;
    public final String time;

    public Srpt_sales_by_item(String business_name, String address, String contact_no, String date, String branch, String location, String category, String classification, String sub_classification, String brand, String model, String time) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.category = category;
        this.classification = classification;
        this.sub_classification = sub_classification;
        this.brand = brand;
        this.model = model;
        this.time = time;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        String unit;
        String category;
        String classification;
        String sub_classification;
        String brand;
        String model;
        String supplier;
        double product_qty;
        double price;
        double discount;
        double amount;
        String sales_no;
        String status;
        double cost;
        double margin;
        double total_margin;
        double addtl_amount;
        String date;
        String with_cost;
        String serial_nos;
        String added_by;

        public field() {
        }

        public field(String item_code, String barcode, String description, String unit, String category, String classification, String sub_classification, String brand, String model, String supplier, double product_qty, double price, double discount, double amount, String sales_no, String status, double cost, double margin, double total_margin, double addtl_amount, String date, String with_cost, String serial_nos, String added_by) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.category = category;
            this.classification = classification;
            this.sub_classification = sub_classification;
            this.brand = brand;
            this.model = model;
            this.supplier = supplier;
            this.product_qty = product_qty;
            this.price = price;
            this.discount = discount;
            this.amount = amount;
            this.sales_no = sales_no;
            this.status = status;
            this.cost = cost;
            this.margin = margin;
            this.total_margin = total_margin;
            this.addtl_amount = addtl_amount;
            this.date = date;
            this.with_cost = with_cost;
            this.serial_nos = serial_nos;
            this.added_by = added_by;
        }

        public String getAdded_by() {
            return added_by;
        }

        public void setAdded_by(String added_by) {
            this.added_by = added_by;
        }

        public String getSerial_nos() {
            return serial_nos;
        }

        public void setSerial_nos(String serial_nos) {
            this.serial_nos = serial_nos;
        }

        public String getWith_cost() {
            return with_cost;
        }

        public void setWith_cost(String with_cost) {
            this.with_cost = with_cost;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getAddtl_amount() {
            return addtl_amount;
        }

        public void setAddtl_amount(double addtl_amount) {
            this.addtl_amount = addtl_amount;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getMargin() {
            return margin;
        }

        public void setMargin(double margin) {
            this.margin = margin;
        }

        public double getTotal_margin() {
            return total_margin;
        }

        public void setTotal_margin(double total_margin) {
            this.total_margin = total_margin;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
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

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getClassification() {
            return classification;
        }

        public void setClassification(String classification) {
            this.classification = classification;
        }

        public String getSub_classification() {
            return sub_classification;
        }

        public void setSub_classification(String sub_classification) {
            this.sub_classification = sub_classification;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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
    }

    public static void main(String[] args) {

        List<Srpt_sales_by_item.field> fields = Srpt_sales_by_item.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        String branch = "";
        String location = "";
        String category = "";
        String classification = "";
        String sub_classification = "";
        String brand = "";
        String model = "";
        String time = "";
        Srpt_sales_by_item rpt = new Srpt_sales_by_item(business_name, address, contact_no, date, branch, location, category, classification, sub_classification, brand, model, time);

        rpt.fields.addAll(fields);
        String jrxml = "rpt_sales_by_item.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_by_item.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_by_item to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_sales_by_item.field> ret_data(String where) {
        List<Srpt_sales_by_item.field> fields = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",GROUP_CONCAT(serial_no SEPARATOR ',')"
                    + ",sum(product_qty)"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",cost"
                    + " from sale_items  "
                    + " " + where
                    + " group by sales_no,item_code,unit,selling_price,discount_amount order by sales_no,id asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                String supplier = supplier_name;
                double price = selling_price;
                double discount = discount_amount;

                String uom = unit;
                String[] list = uom.split(",");
                double cost = rs.getDouble(36);
                int o = 0;
                for (String s : list) {
                    int i = s.indexOf(":");
                    int ii = s.indexOf("/");
                    int iii = s.indexOf("^");
                    String uom1 = s.substring(1, i);
                    double conversion1 = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                    product_qty = product_qty / conversion1;
                    double selling_price1 = FitIn.toDouble(s.substring(i + 1, ii));
                    int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                    uom1 = uom1.replaceAll("#", "/");
                    unit = uom1;
                    o++;
                }

                double amount = (price * product_qty) - discount;
                String status1 = "Counted";
                if (status == 1) {
                    status1 = "Void";
                }

                double margin = 0;
                double total_margin = 0;
                double addtl_amount = 0;
                String date = "";
                String with_cost = "With Cost";
                if (cost <= 0) {
                    with_cost = "No Cost";
                }

//                System.out.println("serial_no: "+serial_no);
                Srpt_sales_by_item.field field = new field(item_code, barcode, description, unit, category, classification, sub_classification, brand, model, supplier, product_qty, price, discount, amount, sales_no, status1, cost, margin, total_margin, addtl_amount, date, with_cost, serial_no, user_screen_name);
                fields.add(field);
            }

            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_sales_by_item.field> ret_data_group_by_code(String where) {
        List<Srpt_sales_by_item.field> fields = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",GROUP_CONCAT(IF(serial_no = '', null, serial_no) SEPARATOR ',')"
                    + ",sum(product_qty)"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",cost"
                    + " from sale_items  "
                    + " " + where
                    + " group by item_code,unit,selling_price,discount_amount order by description asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                double cost = rs.getDouble(40);
                String supplier = supplier_name;
                double price = selling_price;
                double discount = discount_amount;

                String uom = unit;
                String[] list = uom.split(",");

                try {
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        int ii = s.indexOf("/");
                        int iii = s.indexOf("^");
                        String uom1 = s.substring(1, i);
                        double conversion1 = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                        product_qty = product_qty / conversion1;
                        double selling_price1 = FitIn.toDouble(s.substring(i + 1, ii));
                        int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                        uom1 = uom1.replaceAll("#", "/");
                        unit = uom1;
                        o++;
                    }
                } catch (Exception e) {
                }

                double amount = (price * product_qty) - discount;
                String status1 = "Counted";
                if (status == 1) {
                    status1 = "Void";
                }

                double margin = 0;
                double total_margin = 0;
                double addtl_amount = 0;
                String date = "";
                String with_cost = "With Cost";
                if (cost <= 0) {
                    with_cost = "No Cost";
                }
                if (serial_no != null) {
                    serial_no = serial_no.replaceAll("\n", ",");
                    serial_no = "Serial Nos." + serial_no;
                } else {
                    serial_no = null;
                }

//                System.out.println("serial_no: "+serial_no);
                Srpt_sales_by_item.field field = new field(item_code, barcode, description, unit, category, classification, sub_classification, brand, model, supplier, product_qty, price, discount, amount, sales_no, status1, cost, margin, total_margin, addtl_amount, date, with_cost, serial_no, user_screen_name);
                fields.add(field);
            }

            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_sales_by_item.field> ret_data_margin(String where) {
        List<Srpt_sales_by_item.field> fields = new ArrayList();

        List<Srpt_sales_by_item.field> with_cost_list = new ArrayList();
        List<Srpt_sales_by_item.field> no_cost_list = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    //                    + ",GROUP_CONCAT(serial_no SEPARATOR ',')"
                    + ",sum(product_qty)"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",addtl_amount"
                    + ",cost"
                    + " from sale_items  "
                    + " " + where
                    + " group by sales_no,item_code,unit,selling_price,discount_amount,addtl_amount order by  description asc";
//            System.out.println(s0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                double addtl_amount = rs.getDouble(40);
                double cost = rs.getDouble(41);
                String supplier = supplier_name;
                double price = selling_price;
                double discount = discount_amount;

                String uom = unit;
                String[] list = uom.split(",");

                try {
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        int ii = s.indexOf("/");
                        int iii = s.indexOf("^");
                        String uom1 = s.substring(1, i);
                        double conversion1 = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                        product_qty = product_qty / conversion1;
                        double selling_price1 = FitIn.toDouble(s.substring(i + 1, ii));
                        int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                        uom1 = uom1.replaceAll("#", "/");
                        unit = uom1;
                        o++;
                    }
                } catch (Exception e) {
                }

                double amount = ((price * product_qty) - discount) + addtl_amount;
                String status1 = "Counted";
                if (status == 1) {
                    status1 = "Void";
                }

                String sf = DateType.convert_dash_date4(date_added);

                double margin = 0;
                double total_margin = 0;
                if (cost <= 0) {
                    String s2 = "select "
                            + " supplier"
                            + ",supllier_id"
                            + ",cost"
                            + ",unit"
                            + " from  receipt_items  "
                            + " where Date(date_delivered) < '" + sf + "' and main_barcode = '" + item_code + "' order by id desc limit 1";

                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(s2);
                    if (rs2.next()) {
                        supplier = rs2.getString(1);
                        String supllier_id = rs2.getString(2);
                        cost = rs2.getDouble(3);
                        String unit1 = rs2.getString(4);
                    } else {
                        String s3 = "select "
                                + " cost"
                                + " from  inventory_barcodes  "
                                + " where  main_barcode = '" + item_code + "' and location_id='" + location_id + "' limit 1";

                        Statement stmt3 = conn.createStatement();
                        ResultSet rs3 = stmt3.executeQuery(s3);
                        if (rs3.next()) {
                            cost = rs3.getDouble(1);
                        }

                    }
                }

                double amount2 = ((selling_price * product_qty) + addtl_amount) - discount_amount;
                double total_cost = (cost * product_qty);
                double total_amount = (amount2 * product_qty);
                margin = ((amount2 - total_cost) / (amount2 * 100));

                total_margin = amount2 - total_cost;
//                System.out.println("amount: " + total_amount + " , cost: " + total_cost+ " = "+total_margin);
                String date = DateType.convert_slash_datetime(date_added);
                String with_cost = "With Cost";
                if (cost <= 0) {
                    with_cost = "No Cost";
                }
                Srpt_sales_by_item.field field = new field(item_code, barcode, description, unit, category, classification, sub_classification, brand, model, supplier, product_qty, price, discount, amount2, sales_no, status1, cost, margin, total_margin, addtl_amount, date, with_cost, serial_no, user_screen_name);
                if (cost <= 0) {
                    no_cost_list.add(field);
                } else {
                    with_cost_list.add(field);
                }

            }

            fields.addAll(with_cost_list);
            fields.addAll(no_cost_list);
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
