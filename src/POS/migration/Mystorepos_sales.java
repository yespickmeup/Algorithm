/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.migration;

import POS.accounts_receivable.S1_accounts_receivable;
import POS.accounts_receivable.S1_sales_on_account;
import POS.customers.Customers;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.sales.Sales;
import POS.users.MyUser;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author User
 */
public class Mystorepos_sales {

    public static void main(String[] args) {
        System.setProperty("pool_db", "mystorepos");
        List<to_sales> sales = Mystorepos_sales.ret_sales("");
        for (to_sales sale : sales) {
            System.setProperty("pool_db", "mystorepos");
            String date = DateType.convert_slash_datetime_sf3(sale.date);
            System.out.println("Sale: " + sale.invoice_number + " Date: " + date);

            int id = 0;
            String sales_no = "";
            String date_added = date + " 13:00:00 ";
            String user_screen_name = sale.cashier;
            String user_id = "1";
            String session_no = "";
            String remarks = "";
            double gross_amount = 0;
            double amount_due = 0;
            int status = 0;
            int sales_type = 0;
            double line_discount = 0;
            String customer_id = "";
            String customer_name = "";
            String discount_name = "";
            double discount_rate = 0;
            double discount_amount = 0;
            String discount_customer_name = "";
            String discount_customer_id = "";
            String charge_type = "";
            String charge_type_id = "";
            String charge_reference_no = "";
            String charge_customer_name = "";
            String charge_customer_id = "";
            double charge_amount = 0;
            String charge_date_applied = null;
            String check_bank = "";
            String check_no = "";
            double check_amount = 0;
            String check_holder = "";
            String check_date = null;
            String credit_card_type = "";
            double credit_card_rate = 0;
            double credit_card_amount = 0;
            String credit_card_no = "";
            String credit_card_holder = "";
            String credit_card_approval_code = "";
            String gift_certificate_from = "";
            String gift_certificate_description = "";
            String gift_certificate_no = "";
            double gift_certificate_amount = 0;
            String prepaid_customer_name = "";
            String prepaid_customer_id = "";
            double prepaid_amount = 0;
            double addtl_amount = 0;
            double wtax = 0;
            String branch = "Dumaguete";
            String branch_id = "1";
            String location = "Selling Area";
            String location_id = "1";
            List<MySales_Items.items> items = new ArrayList();
            int charge_days = 0;
            String online_bank = "";
            String online_reference_no = "";
            double online_amount = 0;
            String online_holder = "";
            String online_date = null;
            String ref_or_no = "";
            String ref_si_no = sale.invoice_number;
            String ref_cr_no = "";

            List<sales_order> orders = Mystorepos_sales.ret_orders(" where invoice='" + sale.invoice_number + "' ");
            for (sales_order order : orders) {
                gross_amount += order.price * order.qty;
                amount_due += order.amount;
                line_discount += (order.price * order.qty) - order.amount;

                int id2 = 0;
                String sales_no2 = "";
                String item_code = order.product;
                String barcode = order.product_code;
                String description = order.gen_name;
                String generic_name = "";
                String item_type = "";
                String supplier_name = "";
                String supplier_id = "";
                String serial_no = "";
                double product_qty = order.qty;
                String unit = "pc";
                double conversion = 1;
                double selling_price = order.price;

                int is_vatable = 1;
                int selling_type = 0;
                String discount_name1 = "";
                double discount_rate1 = 0;
                double discount_amount1 = (order.price * order.qty) - order.amount;
                String discount_customer_name1 = "";
                String discount_customer_id1 = "";
                String branch1 = "Dumaguete";
                String branch_code = "1";
                String location1 = "Selling Area";
                String location_id1 = "1";
                String category = order.name;
                String category_id = "";
                String classification = "";
                String classification_id = "";
                String sub_classification = "";
                String sub_classification_id = "";
                String brand = "";
                String brand_id = "";
                String model = "";
                String model_id = "";
                boolean selected = false;
                double addtl_amount2 = 0;
                double wtax2 = 0;
                double cost = 0;

                List<Mystorepos.to_mystorepos_products> products = Mystorepos.ret_products(" where product_id='" + order.product + "' ");
                if (!products.isEmpty()) {
                    Mystorepos.to_mystorepos_products prod = (Mystorepos.to_mystorepos_products) products.get(0);
                    cost = prod.o_price;
                }
                MySales_Items.items it = new MySales_Items.items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, selected, addtl_amount, wtax, cost,0);
                items.add(it);
            }

            System.setProperty("pool_db", "db_smis_santillan");
            MySales.sales mysale = new MySales.sales(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, charge_date_applied, check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount, wtax, branch, branch_id, location, location_id, items, charge_days, online_bank, online_reference_no, online_amount, online_holder, online_date, ref_or_no, ref_si_no, ref_cr_no);
            try {
                Mystorepos_sales.add_sales(mysale, items);
            } catch (SQLException ex) {
                Logger.getLogger(Mystorepos_sales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static class to_sales {

        public final int transaction_id;
        public final String invoice_number;
        public final String cashier;
        public final String date;
        public final double amount;
        public final double profit;
        public final double due_date;

        public to_sales(int transaction_id, String invoice_number, String cashier, String date, double amount, double profit, double due_date) {
            this.transaction_id = transaction_id;
            this.invoice_number = invoice_number;
            this.cashier = cashier;
            this.date = date;
            this.amount = amount;
            this.profit = profit;
            this.due_date = due_date;
        }
    }

    public static class sales_order {

        public final int transaction_id;
        public final String invoice_number;
        public final String product;
        public final double qty;
        public final double amount;
        public final double profit;
        public final String product_code;
        public final String gen_name;
        public final String name;
        public final double price;
        public final double discount;
        public final String date;

        public sales_order(int transaction_id, String invoice_number, String product, double qty, double amount, double profit, String product_code, String gen_name, String name, double price, double discount, String date) {
            this.transaction_id = transaction_id;
            this.invoice_number = invoice_number;
            this.product = product;
            this.qty = qty;
            this.amount = amount;
            this.profit = profit;
            this.product_code = product_code;
            this.gen_name = gen_name;
            this.name = name;
            this.price = price;
            this.discount = discount;
            this.date = date;
        }

    }

    public static List<to_sales> ret_sales(String where) {
        List<to_sales> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " transaction_id"
                    + ",invoice_number"
                    + ",cashier"
                    + ",date"
                    + ",amount"
                    + ",profit"
                    + ",due_date"
                    + " from  sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int transaction_id = rs.getInt(1);
                String invoice_number = rs.getString(2);
                String cashier = rs.getString(3);
                String date = rs.getString(4);
                double amount = rs.getDouble(5);
                double profit = rs.getDouble(6);
                double due_date = rs.getDouble(7);

                to_sales to = new to_sales(transaction_id, invoice_number, cashier, date, amount, profit, due_date);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<sales_order> ret_orders(String where) {
        List<sales_order> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " transaction_id"
                    + ",invoice"
                    + ",product"
                    + ",qty"
                    + ",amount"
                    + ",profit"
                    + ",product_code"
                    + ",gen_name"
                    + ",name"
                    + ",price"
                    + ",discount"
                    + ",date"
                    + " from  sales_order  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int transaction_id = rs.getInt(1);
                String invoice_number = rs.getString(2);
                String product = rs.getString(3);
                double qty = rs.getDouble(4);
                double amount = rs.getDouble(5);
                double profit = rs.getDouble(6);
                String product_code = rs.getString(7);
                String gen_name = rs.getString(8);
                String name = rs.getString(9);
                double price = rs.getDouble(10);
                double discount = rs.getDouble(11);
                String date = rs.getString(12);

                sales_order to = new sales_order(transaction_id, invoice_number, product, qty, amount, profit, product_code, gen_name, name, price, discount, date);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String add_sales(MySales.sales to_sales, List<MySales_Items.items> items) throws SQLException {
        try {
            Connection conn = MyConnection.connect();
            String c_date = synsoftech.util.DateType.sf.format(new Date());

            conn.setAutoCommit(false);

            String sales_no = "000000000000";
            String s100 = "select max(id) from sales where location_id ='" + "1" + "' ";
            Statement stmt100 = conn.createStatement();
            ResultSet rs100 = stmt100.executeQuery(s100);
            if (rs100.next()) {
                sales_no = rs100.getString(1);
                String s200 = "select sales_no from sales where id='" + sales_no + "' ";
                Statement stmt200 = conn.createStatement();
                ResultSet rs200 = stmt200.executeQuery(s200);
                if (rs200.next()) {
                    sales_no = rs200.getString(1);
                }
            }

            if (sales_no == null) {
                sales_no = "1" + "|" + "000000000001";

            } else {
                sales_no = ReceiptIncrementor.increment(sales_no);
            }

            String s0 = "insert into sales("
                    + " sales_no"
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
                    + ",online_bank"
                    + ",online_reference_no"
                    + ",online_amount"
                    + ",online_holder"
                    + ",online_date"
                    + ",ref_or_no"
                    + ",ref_si_no"
                    + ",ref_cr_no"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_screen_name"
                    + ",:user_id"
                    + ",:session_no"
                    + ",:remarks"
                    + ",:gross_amount"
                    + ",:amount_due"
                    + ",:status"
                    + ",:sales_type"
                    + ",:line_discount"
                    + ",:customer_id"
                    + ",:customer_name"
                    + ",:discount_name"
                    + ",:discount_rate"
                    + ",:discount_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:charge_type"
                    + ",:charge_type_id"
                    + ",:charge_reference_no"
                    + ",:charge_customer_name"
                    + ",:charge_customer_id"
                    + ",:charge_amount"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_amount"
                    + ",:check_holder"
                    + ",:check_date"
                    + ",:credit_card_type"
                    + ",:credit_card_rate"
                    + ",:credit_card_amount"
                    + ",:credit_card_no"
                    + ",:credit_card_holder"
                    + ",:credit_card_approval_code"
                    + ",:gift_certificate_from"
                    + ",:gift_certificate_description"
                    + ",:gift_certificate_no"
                    + ",:gift_certificate_amount"
                    + ",:prepaid_customer_name"
                    + ",:prepaid_customer_id"
                    + ",:prepaid_amount"
                    + ",:addtl_amount"
                    + ",:wtax"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:online_bank"
                    + ",:online_reference_no"
                    + ",:online_amount"
                    + ",:online_holder"
                    + ",:online_date"
                    + ",:ref_or_no"
                    + ",:ref_si_no"
                    + ",:ref_cr_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", sales_no)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_screen_name", to_sales.user_screen_name)
                    .setString("user_id", to_sales.user_id)
                    .setString("session_no", to_sales.session_no)
                    .setString("remarks", to_sales.remarks)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setNumber("status", to_sales.status)
                    .setNumber("sales_type", to_sales.sales_type)
                    .setNumber("line_discount", to_sales.line_discount)
                    .setString("customer_id", to_sales.customer_id)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount_rate", to_sales.discount_rate)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setString("charge_type", to_sales.charge_type)
                    .setString("charge_type_id", to_sales.charge_type_id)
                    .setString("charge_reference_no", to_sales.charge_reference_no)
                    .setString("charge_customer_name", to_sales.charge_customer_name)
                    .setString("charge_customer_id", to_sales.charge_customer_id)
                    .setNumber("charge_amount", to_sales.charge_amount)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
                    .setString("check_holder", to_sales.check_holder)
                    .setString("check_date", c_date)
                    .setString("credit_card_type", to_sales.credit_card_type)
                    .setNumber("credit_card_rate", to_sales.credit_card_rate)
                    .setNumber("credit_card_amount", to_sales.credit_card_amount)
                    .setString("credit_card_no", to_sales.credit_card_no)
                    .setString("credit_card_holder", to_sales.credit_card_holder)
                    .setString("credit_card_approval_code", to_sales.credit_card_approval_code)
                    .setString("gift_certificate_from", to_sales.gift_certificate_from)
                    .setString("gift_certificate_description", to_sales.gift_certificate_description)
                    .setString("gift_certificate_no", to_sales.gift_certificate_no)
                    .setNumber("gift_certificate_amount", to_sales.gift_certificate_amount)
                    .setString("prepaid_customer_name", to_sales.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_sales.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_sales.prepaid_amount)
                    .setNumber("addtl_amount", to_sales.addtl_amount)
                    .setNumber("wtax", to_sales.wtax)
                    .setString("branch", to_sales.branch)
                    .setString("branch_id", to_sales.branch_id)
                    .setString("location", to_sales.location)
                    .setString("location_id", to_sales.location_id)
                    .setString("online_bank", to_sales.online_bank)
                    .setString("online_reference_no", to_sales.online_reference_no)
                    .setNumber("online_amount", to_sales.online_amount)
                    .setString("online_holder", to_sales.online_holder)
                    .setString("online_date", to_sales.online_date)
                    .setString("ref_or_no", to_sales.ref_or_no)
                    .setString("ref_si_no", to_sales.ref_si_no)
                    .setString("ref_cr_no", to_sales.ref_cr_no)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (MySales_Items.items to_sale_items : items) {
                String s2 = "insert into sale_items("
                        + "sales_no"
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
                        + ")values("
                        + ":sales_no"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:item_type"
                        + ",:supplier_name"
                        + ",:supplier_id"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:status"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:addtl_amount"
                        + ",:wtax"
                        + ",:cost"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("sales_no", sales_no)
                        .setString("item_code", to_sale_items.item_code)
                        .setString("barcode", to_sale_items.barcode)
                        .setString("description", to_sale_items.description)
                        .setString("generic_name", to_sale_items.generic_name)
                        .setString("item_type", to_sale_items.item_type)
                        .setString("supplier_name", to_sale_items.supplier_name)
                        .setString("supplier_id", to_sale_items.supplier_id)
                        .setString("serial_no", to_sale_items.serial_no)
                        .setNumber("product_qty", to_sale_items.product_qty * to_sale_items.conversion)
                        .setString("unit", to_sale_items.unit)
                        .setNumber("conversion", to_sale_items.conversion)
                        .setNumber("selling_price", to_sale_items.selling_price)
                        .setString("date_added", to_sales.date_added)
                        .setString("user_id", to_sales.user_id)
                        .setString("user_screen_name", to_sales.user_screen_name)
                        .setNumber("status", 0)
                        .setNumber("is_vatable", to_sale_items.is_vatable)
                        .setNumber("selling_type", to_sale_items.selling_type)
                        .setString("discount_name", to_sale_items.discount_name)
                        .setNumber("discount_rate", to_sale_items.discount_rate)
                        .setNumber("discount_amount", to_sale_items.discount_amount)
                        .setString("discount_customer_name", to_sale_items.discount_customer_name)
                        .setString("discount_customer_id", to_sale_items.discount_customer_id)
                        .setString("branch", to_sale_items.branch)
                        .setString("branch_code", to_sale_items.branch_code)
                        .setString("location", to_sale_items.location)
                        .setString("location_id", to_sale_items.location_id)
                        .setString("category", to_sale_items.category)
                        .setString("category_id", to_sale_items.category_id)
                        .setString("classification", to_sale_items.classification)
                        .setString("classification_id", to_sale_items.classification_id)
                        .setString("sub_classification", to_sale_items.sub_classification)
                        .setString("sub_classification_id", to_sale_items.sub_classification_id)
                        .setString("brand", to_sale_items.brand)
                        .setString("brand_id", to_sale_items.brand_id)
                        .setString("model", to_sale_items.model)
                        .setString("model_id", to_sale_items.model_id)
                        .setNumber("addtl_amount", to_sale_items.addtl_amount)
                        .setNumber("wtax", to_sale_items.wtax)
                        .setNumber("cost", to_sale_items.cost)
                        .ok();

                stmt.addBatch(s2);

            }

            stmt.executeBatch();
            conn.commit();
//            Lg.s(MySales.class, "Item Committed");
            Lg.s(MySales.class, "Successfully Added");

            return sales_no;
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            MyConnection.close();
        }
    }

}
