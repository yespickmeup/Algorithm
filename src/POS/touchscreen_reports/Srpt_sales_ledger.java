/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
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
public class Srpt_sales_ledger {

    public final List<Srpt_sales_ledger.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;
    public final double return_exchange;
    public final double collections;
    public final double cash_on_hand;
    public final double collections_cheque;
    public final double collections_cheque_on_hand;
    public final double collections_prepaid;
    public final double collections_prepaid_cheque;
    public final double refund;
    public final double refund_cheque;
    public final double ar_collection_prepaid;
    public final double ar_collection_credit_card;
    public final double ar_collection_gc;
    public final double ar_collection_online;
    public final String time;
    public final double retention;
    public final double business_tax;
    public final double re_check;
    public final double re_credit_card;
    public final double re_prepaid;
    public final double re_charge;
    public final double re_gc;
    public final double re_online;
    public final double salary_deduction;
    public final double refund_prepaid;
    public final double refund_charge;
    public final double collections_prepaid_credit_card;
    public final double prepaid_online;
    public Srpt_sales_ledger(String business_name, String address, String contact_no, String date, String branch, String location, double return_exchange, double collections,
            double cash_on_hand, double collections_cheque, double collections_cheque_on_hand, double collections_prepaid, double collections_prepaid_cheque, double refund,
            double refund_cheque, double ar_collection_prepaid, double ar_collection_credit_card, double ar_collection_gc, double ar_collection_online,
            String time, double retention, double business_tax, double re_check, double re_credit_card, double re_prepaid, double re_charge, double re_gc,
             double re_online, double salary_deduction,double refund_prepaid,double refund_charge,double collections_prepaid_credit_card,double prepaid_online) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.return_exchange = return_exchange;
        this.collections = collections;
        this.collections_cheque = collections_cheque;
        this.collections_cheque_on_hand = collections_cheque_on_hand;
        this.cash_on_hand = cash_on_hand;
        this.collections_prepaid = collections_prepaid;
        this.collections_prepaid_cheque = collections_prepaid_cheque;
        this.refund = refund;
        this.refund_cheque = refund_cheque;
        this.ar_collection_prepaid = ar_collection_prepaid;
        this.ar_collection_credit_card = ar_collection_credit_card;
        this.ar_collection_gc = ar_collection_gc;
        this.ar_collection_online = ar_collection_online;
        this.time = time;
        this.retention = retention;
        this.business_tax = business_tax;
        this.re_check = re_check;
        this.re_credit_card = re_credit_card;
        this.re_prepaid = re_prepaid;
        this.re_charge = re_charge;
        this.re_gc = re_gc;
        this.re_online = re_online;
        this.salary_deduction = salary_deduction;
        this.refund_prepaid=refund_prepaid;
        this.refund_charge=refund_charge;
        this.collections_prepaid_credit_card=collections_prepaid_credit_card;
        this.prepaid_online=prepaid_online;
    }

    public static class field {

        String sales_no;
        String customer_id;
        String customer_name;
        double amount_due;
        double line_discount;
        double sales_discount;
        double cash;
        double charge_amount;
        double cheque_amount;
        double credit_card_amount;
        double gc_amount;
        double prepaid_amount;
        double balance_due;
        String user_screen_name;
        String date;
        String location;
        double online_payment;
        String or_no;
        String si_no;
        String cr_no;
        double addtl_amount;
        double wtax;
        String charge_reference_no;
        public field() {
        }

        public field(String sales_no, String customer_id, String customer_name, double amount_due, double line_discount, double sales_discount, double cash, double charge_amount, double cheque_amount, double credit_card_amount, double gc_amount, double prepaid_amount, double balance_due, String user_screen_name, String date, String location, double online_payment, String or_no, String si_no, String cr_no,double addtl_amount,double wtax,String charge_reference_no) {
            this.sales_no = sales_no;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.amount_due = amount_due;
            this.line_discount = line_discount;
            this.sales_discount = sales_discount;
            this.cash = cash;
            this.charge_amount = charge_amount;
            this.cheque_amount = cheque_amount;
            this.credit_card_amount = credit_card_amount;
            this.gc_amount = gc_amount;
            this.prepaid_amount = prepaid_amount;
            this.balance_due = balance_due;
            this.user_screen_name = user_screen_name;
            this.date = date;
            this.location = location;
            this.online_payment = online_payment;
            this.or_no = or_no;
            this.si_no = si_no;
            this.cr_no = cr_no;
            this.addtl_amount=addtl_amount;
            this.wtax=wtax;
            this.charge_reference_no=charge_reference_no;

        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getSi_no() {
            return si_no;
        }

        public void setSi_no(String si_no) {
            this.si_no = si_no;
        }

        public String getCr_no() {
            return cr_no;
        }

        public void setCr_no(String cr_no) {
            this.cr_no = cr_no;
        }

        public double getOnline_payment() {
            return online_payment;
        }

        public void setOnline_payment(double online_payment) {
            this.online_payment = online_payment;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUser_screen_name() {
            return user_screen_name;
        }

        public void setUser_screen_name(String user_screen_name) {
            this.user_screen_name = user_screen_name;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

        public double getSales_discount() {
            return sales_discount;
        }

        public void setSales_discount(double sales_discount) {
            this.sales_discount = sales_discount;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getCharge_amount() {
            return charge_amount;
        }

        public void setCharge_amount(double charge_amount) {
            this.charge_amount = charge_amount;
        }

        public double getCheque_amount() {
            return cheque_amount;
        }

        public void setCheque_amount(double cheque_amount) {
            this.cheque_amount = cheque_amount;
        }

        public double getCredit_card_amount() {
            return credit_card_amount;
        }

        public void setCredit_card_amount(double credit_card_amount) {
            this.credit_card_amount = credit_card_amount;
        }

        public double getGc_amount() {
            return gc_amount;
        }

        public void setGc_amount(double gc_amount) {
            this.gc_amount = gc_amount;
        }

        public double getPrepaid_amount() {
            return prepaid_amount;
        }

        public void setPrepaid_amount(double prepaid_amount) {
            this.prepaid_amount = prepaid_amount;
        }

        public double getBalance_due() {
            return balance_due;
        }

        public void setBalance_due(double balance_due) {
            this.balance_due = balance_due;
        }

    }

    public static void main(String[] args) {

        List<Srpt_sales_ledger.field> fields = Srpt_sales_ledger.ret_data("");
        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "";
        String branch = "";
        String location = "";
        double return_exchange = 0;
        double collections = 0;
        double cash_on_hand = 0;
        double collections_cheque = 0;
        double collections_cheque_on_hand = 0;
        double collections_prepaid = 0;
        double collections_prepaid_cheque = 0;
        double refund = 0;
        double refund_cheque = 0;
        double ar_collection_prepaid = 0;
        double ar_collections_credit_card = 0;
        double ar_collections_gc = 0;
        double ar_collections_online = 0;
        String time = "";
        double retention = 0;
        double business_tax = 0;
        double re_check = 0;
        double re_credit_card = 0;
        double re_prepaid = 0;
        double re_charge = 0;
        double re_gc = 0;
        double re_online = 0;
        double salary_deduction = 0;
        double refund_prepaid=0;
        double refund_charge=0;
        double collections_prepaid_credit_card=0;
        double prepaid_online=0;
        Srpt_sales_ledger rpt = new Srpt_sales_ledger(business_name, address, contact_no, date, branch, location, return_exchange, collections, cash_on_hand, collections_cheque,
                                                      collections_cheque_on_hand, collections_prepaid, collections_prepaid_cheque, refund, refund_cheque,
                 ar_collection_prepaid, ar_collections_credit_card, ar_collections_gc, ar_collections_online, time, retention,
                 business_tax, re_check, re_credit_card, re_prepaid, re_charge, re_gc, re_online, salary_deduction,refund_prepaid,refund_charge,collections_prepaid_credit_card,prepaid_online);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_sales_ledger.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_sales_ledger.field> ret_data(String where) {
        List<Srpt_sales_ledger.field> fields = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select "
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
                    + ",online_bank"
                    + ",online_reference_no"
                    + ",online_amount"
                    + ",online_holder"
                    + ",online_date"
                    + ",ref_or_no"
                    + ",ref_si_no"
                    + ",ref_cr_no"

                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String user_id = rs.getString(5);
                String session_no = rs.getString(6);
                String remarks = rs.getString(7);
                double gross_amount = rs.getDouble(8);
                double amount_due = rs.getDouble(9);
                int status = rs.getInt(10);
                int sales_type = rs.getInt(11);
                double line_discount = rs.getDouble(12);
                String customer_id = rs.getString(13);
                String customer_name = rs.getString(14);
                String discount_name = rs.getString(15);
                double discount_rate = rs.getDouble(16);
                double discount_amount = rs.getDouble(17);
                String discount_customer_name = rs.getString(18);
                String discount_customer_id = rs.getString(19);
                String charge_type = rs.getString(20);
                String charge_type_id = rs.getString(21);
                String charge_reference_no = rs.getString(22);
                String charge_customer_name = rs.getString(23);
                String charge_customer_id = rs.getString(24);
                double charge_amount = rs.getDouble(25);
                String check_bank = rs.getString(26);
                String check_no = rs.getString(27);
                double check_amount = rs.getDouble(28);
                String credit_card_type = rs.getString(29);
                double credit_card_rate = rs.getDouble(30);
                double credit_card_amount = rs.getDouble(31);
                String credit_card_no = rs.getString(32);
                String credit_card_holder = rs.getString(33);
                String credit_card_approval_code = rs.getString(34);
                String gift_certificate_from = rs.getString(35);
                String gift_certificate_description = rs.getString(36);
                String gift_certificate_no = rs.getString(37);
                double gift_certificate_amount = rs.getDouble(38);
                String prepaid_customer_name = rs.getString(39);
                String prepaid_customer_id = rs.getString(40);
                double prepaid_amount = rs.getDouble(41);
                double addtl_amount = rs.getDouble(42);
                double wtax = rs.getDouble(43);
                String branch = rs.getString(44);
                String branch_id = rs.getString(45);
                String location = rs.getString(46);
                String location_id = rs.getString(47);
                String online_bank = rs.getString(48);
                String online_reference_no = rs.getString(49);
                double online_amount = rs.getDouble(50);
                String online_holder = rs.getString(51);
                String online_date = rs.getString(52);

                double sales_discount = discount_amount;
                double cash = amount_due - (charge_amount + check_amount + credit_card_amount + gift_certificate_amount + prepaid_amount + online_amount);
                double cheque_amount = check_amount;
                double gc_amount = gift_certificate_amount;
                double balance_due = amount_due;
                String date = DateType.convert_slash_datetime3(date_added);
                String location1 = branch + " - " + location;
                String or_no=rs.getString(53);
                String si_no=rs.getString(54);
                String cr_no=rs.getString(55);
                Srpt_sales_ledger.field field = new field(sales_no, customer_id, customer_name, gross_amount, line_discount, sales_discount, cash, charge_amount, cheque_amount, credit_card_amount, gc_amount, prepaid_amount, balance_due, user_screen_name, date, location1, online_amount,or_no,si_no,cr_no,addtl_amount,wtax,charge_reference_no);
                fields.add(field);
            }
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<MySales.sales> ret_data_w_items(String where) {
        List<MySales.sales> fields = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
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
                    + ",online_bank"
                    + ",online_reference_no"
                    + ",online_amount"
                    + ",online_holder"
                    + ",online_date"
                    + ",ref_or_no"
                    + ",ref_si_no"
                    + ",ref_cr_no"
                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String user_id = rs.getString(5);
                String session_no = rs.getString(6);
                String remarks = rs.getString(7);
                double gross_amount = rs.getDouble(8);
                double amount_due = rs.getDouble(9);
                int status = rs.getInt(10);
                int sales_type = rs.getInt(11);
                double line_discount = rs.getDouble(12);
                String customer_id = rs.getString(13);
                String customer_name = rs.getString(14);
                String discount_name = rs.getString(15);
                double discount_rate = rs.getDouble(16);
                double discount_amount = rs.getDouble(17);
                String discount_customer_name = rs.getString(18);
                String discount_customer_id = rs.getString(19);
                String charge_type = rs.getString(20);
                String charge_type_id = rs.getString(21);
                String charge_reference_no = rs.getString(22);
                String charge_customer_name = rs.getString(23);
                String charge_customer_id = rs.getString(24);
                double charge_amount = rs.getDouble(25);
                String check_bank = rs.getString(26);
                String check_no = rs.getString(27);
                double check_amount = rs.getDouble(28);
                String credit_card_type = rs.getString(29);
                double credit_card_rate = rs.getDouble(30);
                double credit_card_amount = rs.getDouble(31);
                String credit_card_no = rs.getString(32);
                String credit_card_holder = rs.getString(33);
                String credit_card_approval_code = rs.getString(34);
                String gift_certificate_from = rs.getString(35);
                String gift_certificate_description = rs.getString(36);
                String gift_certificate_no = rs.getString(37);
                double gift_certificate_amount = rs.getDouble(38);
                String prepaid_customer_name = rs.getString(39);
                String prepaid_customer_id = rs.getString(40);
                double prepaid_amount = rs.getDouble(41);
                double addtl_amount1 = rs.getDouble(42);
                double wtax1 = rs.getDouble(43);
                String branch1 = rs.getString(44);
                String branch_id1 = rs.getString(45);
                String location1 = rs.getString(46);
                String location_id1 = rs.getString(47);
                int charge_days = 0;
                String online_bank = rs.getString(48);
                String online_reference_no = rs.getString(49);
                double online_amount = rs.getDouble(50);
                String online_holder = rs.getString(51);
                String online_date = rs.getString(52);
                String ref_or_no = rs.getString(53);
                String ref_si_no = rs.getString(54);
                String ref_cr_no = rs.getString(55);

                double sales_discount = discount_amount;
                double cash = (amount_due - (charge_amount + check_amount + credit_card_amount + gift_certificate_amount + prepaid_amount));
                double cheque_amount = check_amount;
                double gc_amount = gift_certificate_amount;
                double balance_due = amount_due;

                List<MySales_Items.items> items = new ArrayList();
                //<editor-fold defaultstate="collapsed" desc=" items ">
                String s2 = "select "
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
                        + ",cost"
                        + " from sale_items"
                        + " where sales_no='" + sales_no + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    int id1 = rs2.getInt(1);
                    String sales_no1 = rs2.getString(2);
                    String item_code = rs2.getString(3);
                    String barcode = rs2.getString(4);
                    String description = rs2.getString(5);
                    String generic_name = rs2.getString(6);
                    String item_type = rs2.getString(7);
                    String supplier_name = rs2.getString(8);
                    String supplier_id = rs2.getString(9);
                    String serial_no = rs2.getString(10);
                    double product_qty = rs2.getDouble(11);
                    String unit = rs2.getString(12);
                    double conversion = rs2.getDouble(13);
                    double selling_price = rs2.getDouble(14);
                    String date_added1 = rs2.getString(15);
                    String user_id1 = rs2.getString(16);
                    String user_screen_name1 = rs2.getString(17);
                    int status1 = rs2.getInt(18);
                    int is_vatable = rs2.getInt(19);
                    int selling_type = rs2.getInt(20);
                    String discount_name1 = rs2.getString(21);
                    double discount_rate1 = rs2.getDouble(22);
                    double discount_amount1 = rs2.getDouble(23);
                    String discount_customer_name1 = rs2.getString(24);
                    String discount_customer_id1 = rs2.getString(25);
                    String branch = rs2.getString(26);
                    String branch_code = rs2.getString(27);
                    String location = rs2.getString(28);
                    String location_id = rs2.getString(29);
                    String category = rs2.getString(30);
                    String category_id = rs2.getString(31);
                    String classification = rs2.getString(32);
                    String classification_id = rs2.getString(33);
                    String sub_classification = rs2.getString(34);
                    String sub_classification_id = rs2.getString(35);
                    String brand = rs2.getString(36);
                    String brand_id = rs2.getString(37);
                    String model = rs2.getString(38);
                    String model_id = rs2.getString(39);
                    double addtl_amount = rs2.getDouble(40);
                    double wtax = rs2.getDouble(41);
                    double cost=rs2.getDouble(42);
                    MySales_Items.items item = new MySales_Items.items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, false, addtl_amount, wtax,cost);
                    items.add(item);
                }

                //</editor-fold>
                MySales.sales sale = new MySales.sales(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, "", check_bank, check_no, check_amount, check_no, check_bank, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, gc_amount, cash, remarks, user_id, check_no, session_no, items,
                                                       charge_days, online_bank, online_reference_no, online_amount, online_holder, online_date, ref_or_no, ref_si_no, ref_cr_no);

                fields.add(sale);
            }
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
