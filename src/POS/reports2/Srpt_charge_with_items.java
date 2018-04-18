/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

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
public class Srpt_charge_with_items {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String customer_name;
    public final String customer_address;
    public final String customer_id;
    public final List<field> fields;
    public final String img_path;
    public final double total_balance;
    public final String ar_footer;
    public final String telephone_number;
    public final String prepared_by;
    public Srpt_charge_with_items(String business_name, String address, String contact_no, String date, String customer_name, String customer_address, String customer_id, String img_path, double total_balance, String ar_footer, String telephone_number,String prepared_by) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_id = customer_id;
        this.fields = new ArrayList();
        this.img_path = img_path;
        this.total_balance = total_balance;
        this.ar_footer = ar_footer;
        this.telephone_number = telephone_number;
        this.prepared_by=prepared_by;
    }

    public static class field {

        String ar_no;
        String sales_no;
        String reference_no;
        double ar_amount_due;
        double ar_discount;
        double ar_paid;
        int ar_term;
        String date_applied;
        double balance;
        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double selling_price;
        double discount;
        double amount;

        public field() {
        }

        public field(String ar_no, String sales_no, String reference_no, double ar_amount_due, double ar_discount, double ar_paid, int ar_term, String date_applied, double balance, String item_code, String barcode, String description, String unit, double qty, double selling_price, double discount, double amount) {
            this.ar_no = ar_no;
            this.sales_no = sales_no;
            this.reference_no = reference_no;
            this.ar_amount_due = ar_amount_due;
            this.ar_discount = ar_discount;
            this.ar_paid = ar_paid;
            this.ar_term = ar_term;
            this.date_applied = date_applied;
            this.balance = balance;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.selling_price = selling_price;
            this.discount = discount;
            this.amount = amount;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getAr_no() {
            return ar_no;
        }

        public void setAr_no(String ar_no) {
            this.ar_no = ar_no;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public String getReference_no() {
            return reference_no;
        }

        public void setReference_no(String reference_no) {
            this.reference_no = reference_no;
        }

        public double getAr_amount_due() {
            return ar_amount_due;
        }

        public void setAr_amount_due(double ar_amount_due) {
            this.ar_amount_due = ar_amount_due;
        }

        public double getAr_discount() {
            return ar_discount;
        }

        public void setAr_discount(double ar_discount) {
            this.ar_discount = ar_discount;
        }

        public double getAr_paid() {
            return ar_paid;
        }

        public void setAr_paid(double ar_paid) {
            this.ar_paid = ar_paid;
        }

        public int getAr_term() {
            return ar_term;
        }

        public void setAr_term(int ar_term) {
            this.ar_term = ar_term;
        }

        public String getDate_applied() {
            return date_applied;
        }

        public void setDate_applied(String date_applied) {
            this.date_applied = date_applied;
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

    public static void main1(String[] args) {

    }

    public static void main(String[] args) {

        System.setProperty("pool_db", "db_algorithm");
        String where = " where customer_id='9|0391' and paid<amount and status=0 ";
        double total_balance = 0;
        List<Srpt_charge_with_items.field> fields = ret_data(where);
        for (Srpt_charge_with_items.field f : fields) {
            total_balance = f.balance;
        }
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City, Negros Oriental");
        String contact_n = System.getProperty("contact_no", "1234-567-8910");
        String date = "02/13/2017";
        String customer_name = "Angel Buns";
        String customer_address = "Pinili Street, Dumaguete City";
        String customer_id = "9|0391";

        String img_path = System.getProperty("img_path", "C:\\Users\\Guinness\\smis\\logo.png");
        String telephone_number = System.getProperty("contact_no", "Tel. no. 225-6928 / 422-9026 / fax:422-1953");
        String ar_footer = System.getProperty("ar_footer", "Should you have any enquiries concerning this statement, please contact Napoleon Dy Jr. on 0917-314-3854");
        String prepared_by="";
        Srpt_charge_with_items rpt = new Srpt_charge_with_items(business_name, address, contact_n, date, customer_name, customer_address, customer_id, img_path, total_balance, ar_footer, telephone_number,prepared_by);

        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_charge_with_items to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_ar_aging.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_charge_with_items to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_balance_per_transaction_items.jrxml";
            InputStream is = Srpt_charge_with_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List< Srpt_charge_with_items.field> ret_data(String where) {
        List< Srpt_charge_with_items.field> fields = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",soa_id"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",reference_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from accounts_receivable"
                    + " " + where;

            double balance = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);

                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                double amount = rs.getDouble(7);
                double discount_amount = rs.getDouble(8);
                double discount_rate = rs.getDouble(9);
                String discount = rs.getString(10);
                int status = rs.getInt(11);
                double term = rs.getDouble(12);
                String date_applied = rs.getString(13);
                date_applied = DateType.convert_slash_datetime2(date_applied);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                String ci_no = rs.getString(19);
                String trust_receipt = rs.getString(20);
                String soa_id = rs.getString(21);
                String soa_type = rs.getString(22);
                String soa_type_id = rs.getString(23);
                String reference_no = rs.getString(24);
                String user_id = rs.getString(25);
                String user_screen_name = rs.getString(26);
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);

                balance += (amount - discount_amount) - (paid);
                String where2 = " where charge_customer_id='" + customer_id + "' and charge_reference_no='" + reference_no + "' ";
                String s2 = "select "
                        + "id"
                        + ",sales_no"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",session_no"
                        + ",remarks"
                        + ",gross_amount"
                        + ",amount_due"
                        + ",status"
                        + ",sales_type"
                        + ",line_discount"
                        + ",customer_id"
                        + ",customer_name"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",charge_type"
                        + ",charge_type_id"
                        + ",charge_reference_no"
                        + ",charge_customer_name"
                        + ",charge_customer_id"
                        + ",charge_amount"
                        + ",check_bank"
                        + ",check_no"
                        + ",check_amount"
                        + ",check_holder"
                        + ",check_date"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",credit_card_amount"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_approval_code"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",gift_certificate_amount"
                        + ",prepaid_customer_name"
                        + ",prepaid_customer_id"
                        + ",prepaid_amount"
                        + ",addtl_amount"
                        + ",wtax"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + " from sales"
                        + " " + where2;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    String sales_no = rs2.getString(2);
                    String date_added2 = rs2.getString(3);
                    String user_screen_name2 = rs2.getString(4);
                    String user_id2 = rs2.getString(5);
                    String session_no = rs2.getString(6);
                    String remarks2 = rs2.getString(7);
                    double gross_amount = rs2.getDouble(8);
                    double amount_due = rs2.getDouble(9);
                    int status2 = rs2.getInt(10);
                    int sales_type = rs2.getInt(11);
                    double line_discount = rs2.getDouble(12);
                    String customer_id2 = rs2.getString(13);
                    String customer_name2 = rs2.getString(14);
                    String discount_name = rs2.getString(15);
                    double discount_rate2 = rs2.getDouble(16);
                    double discount_amount2 = rs2.getDouble(17);
                    String discount_customer_name = rs2.getString(18);
                    String discount_customer_id = rs2.getString(19);
                    String charge_type = rs2.getString(20);
                    String charge_type_id = rs2.getString(21);
                    String charge_reference_no = rs2.getString(22);
                    String charge_customer_name = rs2.getString(23);
                    String charge_customer_id = rs2.getString(24);
                    double charge_amount = rs2.getDouble(25);
                    String check_bank = rs2.getString(26);
                    String check_no = rs2.getString(27);
                    double check_amount = rs2.getDouble(28);
                    String check_holder = rs2.getString(29);
                    String check_date = rs2.getString(30);
                    String credit_card_type = rs2.getString(31);
                    double credit_card_rate = rs2.getDouble(32);
                    double credit_card_amount = rs2.getDouble(33);
                    String credit_card_no = rs2.getString(34);
                    String credit_card_holder = rs2.getString(35);
                    String credit_card_approval_code = rs2.getString(36);
                    String gift_certificate_from = rs2.getString(37);
                    String gift_certificate_description = rs2.getString(38);
                    String gift_certificate_no = rs2.getString(39);
                    double gift_certificate_amount = rs2.getDouble(40);
                    String prepaid_customer_name = rs2.getString(41);
                    String prepaid_customer_id = rs2.getString(42);
                    double prepaid_amount = rs2.getDouble(43);
                    double addtl_amount = rs2.getDouble(44);
                    double wtax = rs2.getDouble(45);
//                    System.out.println("charge_reference_no: " + charge_reference_no + " charge_amount=" + charge_amount);

                    String where3 = " where sales_no='" + sales_no + "' ";
                    String s3 = "select "
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
                            + ",product_qty"
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
                            + ",wtax"
                            + " from sale_items"
                            + " " + where3;

                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery(s3);
                    while (rs3.next()) {
                        int id3 = rs3.getInt(1);
                        String sales_no3 = rs3.getString(2);
                        String item_code = rs3.getString(3);
                        String barcode = rs3.getString(4);
                        String description = rs3.getString(5);
                        String generic_name = rs3.getString(6);
                        String item_type = rs3.getString(7);
                        String supplier_name = rs3.getString(8);
                        String supplier_id = rs3.getString(9);
                        String serial_no = rs3.getString(10);
                        double product_qty = rs3.getDouble(11);
                        String unit = rs3.getString(12);
                        double conversion = rs3.getDouble(13);
                        double selling_price = rs3.getDouble(14);
                        String date_added3 = rs3.getString(15);
                        String user_id3 = rs3.getString(16);
                        String user_screen_name3 = rs3.getString(17);
                        int status3 = rs3.getInt(18);
                        int is_vatable = rs3.getInt(19);
                        int selling_type = rs3.getInt(20);
                        String discount_name3 = rs3.getString(21);
                        double discount_rate3 = rs3.getDouble(22);
                        double discount_amount3 = rs3.getDouble(23);
                        String discount_customer_name3 = rs3.getString(24);
                        String discount_customer_id3 = rs3.getString(25);
                        String branch3 = rs3.getString(26);
                        String branch_code = rs3.getString(27);
                        String location3 = rs3.getString(28);
                        String location_id3 = rs3.getString(29);
                        String category = rs3.getString(30);
                        String category_id = rs3.getString(31);
                        String classification = rs3.getString(32);
                        String classification_id = rs3.getString(33);
                        String sub_classification = rs3.getString(34);
                        String sub_classification_id = rs3.getString(35);
                        String brand = rs3.getString(36);
                        String brand_id = rs3.getString(37);
                        String model = rs3.getString(38);
                        String model_id = rs3.getString(39);
                        double addtl_amount3 = rs3.getDouble(40);
                        double wtax3 = rs3.getDouble(41);
//                        System.out.println("    Item Code: " + item_code + " = " + description + " am: " + (product_qty * selling_price));

                        double ar_amount_due = amount;
                        double ar_discount = discount_amount;
                        double ar_paid = paid;
                        int ar_term = FitIn.toInt("" + term);

                        double qty = product_qty;
                        double item_selling_price = selling_price;
                        double item_discount = discount_amount3;
                        double item_amount = (qty * item_selling_price) - item_discount + (addtl_amount3 + wtax3);
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(unit);
                        unit = uoms.uom;
                        Srpt_charge_with_items.field field = new field(ar_no, sales_no, reference_no, ar_amount_due, ar_discount, ar_paid, ar_term, date_applied, balance, item_code, barcode, description, unit, qty, item_selling_price, item_discount, item_amount);
                        fields.add(field);
                    }
                } else {
                    String where3 = " where ar_no = '" + ar_no + "' ";
                    String s3 = "select "
                            + "id"
                            + ",customer_id"
                            + ",customer_name"
                            + ",ar_id"
                            + ",ar_no"
                            + ",date_applied"
                            + ",reference_no"
                            + ",soa_type"
                            + ",soa_type_id"
                            + ",user_screen_name"
                            + ",user_id"
                            + ",remarks"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",generic_name"
                            + ",item_type"
                            + ",supplier_name"
                            + ",supplier_id"
                            + ",serial_no"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
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
                            + ",wtax"
                            + " from charge_in_advance_items"
                            + " " + where3;

                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery(s3);
                    while (rs3.next()) {
                        int id3 = rs3.getInt(1);
                        String customer_id3 = rs3.getString(2);
                        String customer_name3 = rs3.getString(3);
                        String ar_id = rs3.getString(4);
                        String ar_no3 = rs3.getString(5);
                        String date_applied3 = rs3.getString(6);
                        String reference_no3 = rs3.getString(7);
                        String soa_type3 = rs3.getString(8);
                        String soa_type_id3 = rs3.getString(9);
                        String user_screen_name3 = rs3.getString(10);
                        String user_id3 = rs3.getString(11);
                        String remarks3 = rs3.getString(12);
                        String item_code = rs3.getString(13);
                        String barcode = rs3.getString(14);
                        String description = rs3.getString(15);
                        String generic_name = rs3.getString(16);
                        String item_type = rs3.getString(17);
                        String supplier_name = rs3.getString(18);
                        String supplier_id = rs3.getString(19);
                        String serial_no = rs3.getString(20);
                        double product_qty = rs3.getDouble(21);
                        String unit = rs3.getString(22);
                        double conversion = rs3.getDouble(23);
                        double selling_price = rs3.getDouble(24);
                        String date_added3 = rs3.getString(25);
                        int status3 = rs3.getInt(26);
                        int is_vatable = rs3.getInt(27);
                        int selling_type = rs3.getInt(28);
                        String discount_name = rs3.getString(29);
                        double discount_rate3 = rs3.getDouble(30);
                        double discount_amount3 = rs3.getDouble(31);
                        String discount_customer_name = rs3.getString(32);
                        String discount_customer_id = rs3.getString(33);
                        String branch3 = rs3.getString(34);
                        String branch_code = rs3.getString(35);
                        String location3 = rs3.getString(36);
                        String location_id3 = rs3.getString(37);
                        String category = rs3.getString(38);
                        String category_id = rs3.getString(39);
                        String classification = rs3.getString(40);
                        String classification_id = rs3.getString(41);
                        String sub_classification = rs3.getString(42);
                        String sub_classification_id = rs3.getString(43);
                        String brand = rs3.getString(44);
                        String brand_id = rs3.getString(45);
                        String model = rs3.getString(46);
                        String model_id = rs3.getString(47);
                        double addtl_amount = rs3.getDouble(48);
                        double wtax = rs3.getDouble(49);

                        double ar_amount_due = amount;
                        double ar_discount = discount_amount;
                        double ar_paid = paid;
                        int ar_term = FitIn.toInt("" + term);

                        double qty = product_qty;
                        double item_selling_price = selling_price;
                        double item_discount = discount_amount3;
                        double item_amount = (qty * item_selling_price) - item_discount + (addtl_amount + wtax);
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(unit);
                        unit = uoms.uom;
                        Srpt_charge_with_items.field field = new field(ar_no, "", reference_no, ar_amount_due, ar_discount, ar_paid, ar_term, date_applied, balance, item_code, barcode, description, unit, qty, item_selling_price, item_discount, item_amount);
                        fields.add(field);
                    }
                }

                if (fields.isEmpty()) {
                    double ar_amount_due = amount;
                    double ar_discount = discount_amount;
                    double ar_paid = paid;
                    int ar_term = FitIn.toInt("" + term);

                    double qty = 0;
                    double item_selling_price = 0;
                    double item_discount = 0;
                    double item_amount = (qty * item_selling_price) - item_discount + (0 + 0);
                    Srpt_charge_with_items.field field = new field(ar_no, "", reference_no, ar_amount_due, ar_discount, ar_paid, ar_term, date_applied, balance, "", "", "", "", qty, item_selling_price, item_discount, item_amount);
                    fields.add(field);
                }
            }
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
