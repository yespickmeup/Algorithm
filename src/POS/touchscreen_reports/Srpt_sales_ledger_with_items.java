/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Ronescape
 */
public class Srpt_sales_ledger_with_items {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String branch;
    public final String location;
    public final String time;
    public final List<field> fields;

    public Srpt_sales_ledger_with_items(String business_name, String address, String contact_no, String date, String branch, String location, String time) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.time = time;
        this.fields = new ArrayList();
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
        String item_code;
        String description;
        String unit;
        double qty;
        double price;
        double discount;
        double addtl_amount;
        double wtax;
        double amount;
        double online_amount;
        public field() {
        }

        public field(String sales_no, String customer_id, String customer_name, double amount_due, double line_discount, double sales_discount, double cash, double charge_amount, double cheque_amount, double credit_card_amount, double gc_amount, double prepaid_amount, double balance_due, String user_screen_name, String date, String location, double online_payment, String item_code, String description, String unit, double qty, double price, double discount, double addtl_amount, double wtax, double amount,double online_amount) {
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
            this.item_code = item_code;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.price = price;
            this.discount = discount;
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
            this.amount = amount;
            this.online_amount=online_amount;
        }

        public double getOnline_amount() {
            return online_amount;
        }

        public void setOnline_amount(double online_amount) {
            this.online_amount = online_amount;
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

        public String getUser_screen_name() {
            return user_screen_name;
        }

        public void setUser_screen_name(String user_screen_name) {
            this.user_screen_name = user_screen_name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getOnline_payment() {
            return online_payment;
        }

        public void setOnline_payment(double online_payment) {
            this.online_payment = online_payment;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
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

        public double getAddtl_amount() {
            return addtl_amount;
        }

        public void setAddtl_amount(double addtl_amount) {
            this.addtl_amount = addtl_amount;
        }

        public double getWtax() {
            return wtax;
        }

        public void setWtax(double wtax) {
            this.wtax = wtax;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static List<Srpt_sales_ledger_with_items.field> ret_data(String where) {
        List<Srpt_sales_ledger_with_items.field> fields = new ArrayList();

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
                String online_date = rs.getString(51);

                double sales_discount = discount_amount;
                double cash = amount_due - (charge_amount + check_amount + credit_card_amount + gift_certificate_amount + prepaid_amount + online_amount);
                double cheque_amount = check_amount;
                double gc_amount = gift_certificate_amount;
                double balance_due = amount_due;
                String date = DateType.convert_slash_datetime3(date_added);
                String location1 = branch + " - " + location;

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
                        + ",GROUP_CONCAT(serial_no SEPARATOR ',')"
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
                        + " from sale_items  "
                        + " where sales_no='" + sales_no + "' "
                        + " order by description asc";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    int i2d = rs2.getInt(1);
                    String sales_no2 = rs2.getString(2);
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
                    String date_added2 = rs2.getString(15);
                    String user_id2 = rs2.getString(16);
                    String user_screen_name2 = rs2.getString(17);
                    int status2 = rs2.getInt(18);
                    int is_vatable = rs2.getInt(19);
                    int selling_type = rs2.getInt(20);
                    String discount_name2 = rs2.getString(21);
                    double discount_rate2 = rs2.getDouble(22);
                    double discount_amount2 = rs2.getDouble(23);
                    String discount_customer_name2 = rs2.getString(24);
                    String discount_customer_id2 = rs2.getString(25);
                    String branch2 = rs2.getString(26);
                    String branch_code = rs2.getString(27);
                    String location2 = rs2.getString(28);
                    String location_id2 = rs2.getString(29);
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
                    String supplier = supplier_name;
                    double price = selling_price;
                    double discount = discount_amount;
                    double addtl_amount2 = rs2.getDouble(40);
                    double wtax2 = rs2.getDouble(41);
                    String uom = unit;
                    String[] list = uom.split(",");

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
                    double cost = 0;
                    double margin = 0;
                    double total_margin = 0;
                    String date2 = "";
                    String with_cost = "With Cost";
                    if (cost <= 0) {
                        with_cost = "No Cost";
                    }
                    double online_payment = online_amount;
                    double qty = product_qty;
                    Srpt_sales_ledger_with_items.field f = new field(sales_no, customer_id, customer_name, amount_due, line_discount, sales_discount, cash, charge_amount, cheque_amount, credit_card_amount, gc_amount, prepaid_amount, balance_due, user_screen_name, date, location, online_payment, item_code, description, unit, qty, price, discount_amount2, addtl_amount2, wtax2, amount,online_payment);
                    fields.add(f);
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
