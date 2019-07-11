/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.item_replacements;

import POS.accounts_receivable.S1_accounts_receivable;
import POS.accounts_receivable.S1_accounts_receivable_payments;
import static POS.accounts_receivable.S1_accounts_receivable_payments.ret_customer_balance;
import POS.customers.Customers;
import POS.my_sales.MySales_Items;
import POS.prepaid_payments.Prepaid_payments;
import POS.prepaid_payments.Prepaid_payments.to_prepaid_payments;
import POS.users.MyUser;
import POS.util.Alert;
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
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Item_replacements {

    public static class to_item_replacements {

        public final int id;
        public final String item_replacement_no;
        public final String sales_no;
        public final String customer_name;
        public final String customer_id;
        public final String date_added;
        public final String user_screen_name;
        public final String user_id;
        public final String reason;
        public final double amount_due;
        public final double replacement_amount;
        public final double discount;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final double cash_amount;
        public final String check_holder;
        public final String check_bank;
        public final String check_no;
        public final String check_date;
        public final double check_amount;
        public final String card_type;
        public final double credit_card_rate;
        public final double credit_card_amount;
        public final double credit_card_amount_to_pay;
        public final String credit_card_no;
        public final String credit_card_holder;
        public final String credit_card_approval_code;
        public final String prepaid_customer_name;
        public final String prepaid_customer_id;
        public final double prepaid_amount;
        public final String charge_reference_no;
        public final String charge_ar_no;
        public final String charge_type;
        public final String charge_customer_name;
        public final String charge_customer_id;
        public final double charge_amount;
        public final int charge_days;
        public final String gc_from;
        public final String gc_description;
        public final String gc_no;
        public final double gc_amount;
        public final String online_holder;
        public final String online_bank;
        public final String online_reference_no;
        public final String online_date;
        public final double online_amount;

        public to_item_replacements(int id, String item_replacement_no, String sales_no, String customer_name, String customer_id, String date_added, String user_screen_name, String user_id, String reason, double amount_due, double replacement_amount, double discount, int status, String branch, String branch_id, String location, String location_id, double cash_amount, String check_holder, String check_bank, String check_no, String check_date, double check_amount, String card_type, double credit_card_rate, double credit_card_amount, double credit_card_amount_to_pay, String credit_card_no, String credit_card_holder, String credit_card_approval_code, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String charge_reference_no, String charge_ar_no, String charge_type, String charge_customer_name, String charge_customer_id, double charge_amount, int charge_days, String gc_from, String gc_description, String gc_no, double gc_amount, String online_holder, String online_bank, String online_reference_no, String online_date, double online_amount) {
            this.id = id;
            this.item_replacement_no = item_replacement_no;
            this.sales_no = sales_no;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.date_added = date_added;
            this.user_screen_name = user_screen_name;
            this.user_id = user_id;
            this.reason = reason;
            this.amount_due = amount_due;
            this.replacement_amount = replacement_amount;
            this.discount = discount;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.cash_amount = cash_amount;
            this.check_holder = check_holder;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_date = check_date;
            this.check_amount = check_amount;
            this.card_type = card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.credit_card_amount_to_pay = credit_card_amount_to_pay;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_approval_code = credit_card_approval_code;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.charge_reference_no = charge_reference_no;
            this.charge_ar_no = charge_ar_no;
            this.charge_type = charge_type;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.charge_days = charge_days;
            this.gc_from = gc_from;
            this.gc_description = gc_description;
            this.gc_no = gc_no;
            this.gc_amount = gc_amount;
            this.online_holder = online_holder;
            this.online_bank = online_bank;
            this.online_reference_no = online_reference_no;
            this.online_date = online_date;
            this.online_amount = online_amount;
        }
    }

    public static void add_data(to_item_replacements to_item_replacements, List<MySales_Items.items> selected, List<MySales_Items.items> replacements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into item_replacements("
                    + "item_replacement_no"
                    + ",sales_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",reason"
                    + ",amount_due"
                    + ",replacement_amount"
                    + ",discount"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",cash_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_date"
                    + ",check_amount"
                    + ",card_type"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",credit_card_amount_to_pay"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
                    + ",gc_from"
                    + ",gc_description"
                    + ",gc_no"
                    + ",gc_amount"
                    + ",online_holder"
                    + ",online_bank"
                    + ",online_reference_no"
                    + ",online_date"
                    + ",online_amount"
                    + ")values("
                    + ":item_replacement_no"
                    + ",:sales_no"
                    + ",:customer_name"
                    + ",:customer_id"
                    + ",:date_added"
                    + ",:user_screen_name"
                    + ",:user_id"
                    + ",:reason"
                    + ",:amount_due"
                    + ",:replacement_amount"
                    + ",:discount"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:cash_amount"
                    + ",:check_holder"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_date"
                    + ",:check_amount"
                    + ",:card_type"
                    + ",:credit_card_rate"
                    + ",:credit_card_amount"
                    + ",:credit_card_amount_to_pay"
                    + ",:credit_card_no"
                    + ",:credit_card_holder"
                    + ",:credit_card_approval_code"
                    + ",:prepaid_customer_name"
                    + ",:prepaid_customer_id"
                    + ",:prepaid_amount"
                    + ",:charge_reference_no"
                    + ",:charge_ar_no"
                    + ",:charge_type"
                    + ",:charge_customer_name"
                    + ",:charge_customer_id"
                    + ",:charge_amount"
                    + ",:charge_days"
                    + ",:gc_from"
                    + ",:gc_description"
                    + ",:gc_no"
                    + ",:gc_amount"
                    + ",:online_holder"
                    + ",:online_bank"
                    + ",:online_reference_no"
                    + ",:online_date"
                    + ",:online_amount"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                    .setString("sales_no", to_item_replacements.sales_no)
                    .setString("customer_name", to_item_replacements.customer_name)
                    .setString("customer_id", to_item_replacements.customer_id)
                    .setString("date_added", to_item_replacements.date_added)
                    .setString("user_screen_name", to_item_replacements.user_screen_name)
                    .setString("user_id", to_item_replacements.user_id)
                    .setString("reason", to_item_replacements.reason)
                    .setNumber("amount_due", to_item_replacements.amount_due)
                    .setNumber("replacement_amount", to_item_replacements.replacement_amount)
                    .setNumber("discount", to_item_replacements.discount)
                    .setNumber("status", to_item_replacements.status)
                    .setString("branch", to_item_replacements.branch)
                    .setString("branch_id", to_item_replacements.branch_id)
                    .setString("location", to_item_replacements.location)
                    .setString("location_id", to_item_replacements.location_id)
                    .setNumber("cash_amount", to_item_replacements.cash_amount)
                    .setString("check_holder", to_item_replacements.check_holder)
                    .setString("check_bank", to_item_replacements.check_bank)
                    .setString("check_no", to_item_replacements.check_no)
                    .setString("check_date", to_item_replacements.check_date)
                    .setNumber("check_amount", to_item_replacements.check_amount)
                    .setString("card_type", to_item_replacements.card_type)
                    .setNumber("credit_card_rate", to_item_replacements.credit_card_rate)
                    .setNumber("credit_card_amount", to_item_replacements.credit_card_amount)
                    .setNumber("credit_card_amount_to_pay", to_item_replacements.credit_card_amount_to_pay)
                    .setString("credit_card_no", to_item_replacements.credit_card_no)
                    .setString("credit_card_holder", to_item_replacements.credit_card_holder)
                    .setString("credit_card_approval_code", to_item_replacements.credit_card_approval_code)
                    .setString("prepaid_customer_name", to_item_replacements.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_item_replacements.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_item_replacements.prepaid_amount)
                    .setString("charge_reference_no", to_item_replacements.charge_reference_no)
                    .setString("charge_ar_no", to_item_replacements.charge_ar_no)
                    .setString("charge_type", to_item_replacements.charge_type)
                    .setString("charge_customer_name", to_item_replacements.charge_customer_name)
                    .setString("charge_customer_id", to_item_replacements.charge_customer_id)
                    .setNumber("charge_amount", to_item_replacements.charge_amount)
                    .setNumber("charge_days", to_item_replacements.charge_days)
                    .setString("gc_from", to_item_replacements.gc_from)
                    .setString("gc_description", to_item_replacements.gc_description)
                    .setString("gc_no", to_item_replacements.gc_no)
                    .setNumber("gc_amount", to_item_replacements.gc_amount)
                    .setString("online_holder", to_item_replacements.online_holder)
                    .setString("online_bank", to_item_replacements.online_bank)
                    .setString("online_reference_no", to_item_replacements.online_reference_no)
                    .setString("online_date", to_item_replacements.online_date)
                    .setNumber("online_amount", to_item_replacements.online_amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (MySales_Items.items to_item_replacement_details : selected) {
                String s2 = "insert into item_replacement_details("
                        + "item_replacement_no"
                        + ",sales_no"
                        + ",customer_name"
                        + ",customer_id"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",item_code"
                        + ",barcode"
                        + ",generic_name"
                        + ",description"
                        + ",item_type"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",is_replacement"
                        + ",reason"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + ")values("
                        + ":item_replacement_no"
                        + ",:sales_no"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:date_added"
                        + ",:user_screen_name"
                        + ",:user_id"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:generic_name"
                        + ",:description"
                        + ",:item_type"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:is_replacement"
                        + ",:reason"
                        + ",:status"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:addtl_amount"
                        + ",:wtax"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                        .setString("sales_no", to_item_replacements.sales_no)
                        .setString("customer_name", to_item_replacements.customer_name)
                        .setString("customer_id", to_item_replacements.customer_id)
                        .setString("date_added", to_item_replacements.date_added)
                        .setString("user_screen_name", to_item_replacements.user_screen_name)
                        .setString("user_id", to_item_replacements.user_id)
                        .setString("item_code", to_item_replacement_details.item_code)
                        .setString("barcode", to_item_replacement_details.barcode)
                        .setString("generic_name", to_item_replacement_details.generic_name)
                        .setString("description", to_item_replacement_details.description)
                        .setString("item_type", to_item_replacement_details.item_type)
                        .setString("serial_no", to_item_replacement_details.serial_no)
                        .setNumber("product_qty", to_item_replacement_details.product_qty)
                        .setString("unit", to_item_replacement_details.unit)
                        .setNumber("conversion", to_item_replacement_details.conversion)
                        .setNumber("selling_price", to_item_replacement_details.selling_price)
                        .setNumber("is_vatable", to_item_replacement_details.is_vatable)
                        .setNumber("selling_type", to_item_replacement_details.selling_type)
                        .setString("discount_name", to_item_replacement_details.discount_name)
                        .setNumber("discount_amount", to_item_replacement_details.discount_amount)
                        .setString("discount_customer_name", to_item_replacement_details.discount_customer_name)
                        .setString("discount_customer_id", to_item_replacement_details.discount_customer_id)
                        .setString("category", to_item_replacement_details.category)
                        .setString("category_id", to_item_replacement_details.category_id)
                        .setString("classification", to_item_replacement_details.classification)
                        .setString("sub_classification", to_item_replacement_details.sub_classification)
                        .setString("sub_classification_id", to_item_replacement_details.sub_classification_id)
                        .setString("brand", to_item_replacement_details.brand)
                        .setString("brand_id", to_item_replacement_details.brand_id)
                        .setString("model", to_item_replacement_details.model)
                        .setString("model_id", to_item_replacement_details.model_id)
                        .setNumber("is_replacement", 0)
                        .setString("reason", to_item_replacements.reason)
                        .setNumber("status", to_item_replacements.status)
                        .setString("branch", to_item_replacements.branch)
                        .setString("branch_id", to_item_replacements.branch_id)
                        .setString("location", to_item_replacements.location)
                        .setString("location_id", to_item_replacements.location_id)
                        .setNumber("addtl_amount", to_item_replacement_details.addtl_amount)
                        .setNumber("wtax", to_item_replacement_details.wtax)
                        .ok();
                stmt.addBatch(s2);
            }
            for (MySales_Items.items to_item_replacement_details : replacements) {
                String s2 = "insert into item_replacement_details("
                        + "item_replacement_no"
                        + ",sales_no"
                        + ",customer_name"
                        + ",customer_id"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",item_code"
                        + ",barcode"
                        + ",generic_name"
                        + ",description"
                        + ",item_type"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",is_replacement"
                        + ",reason"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + ")values("
                        + ":item_replacement_no"
                        + ",:sales_no"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:date_added"
                        + ",:user_screen_name"
                        + ",:user_id"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:generic_name"
                        + ",:description"
                        + ",:item_type"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:is_replacement"
                        + ",:reason"
                        + ",:status"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:addtl_amount"
                        + ",:wtax"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                        .setString("sales_no", to_item_replacements.sales_no)
                        .setString("customer_name", to_item_replacements.customer_name)
                        .setString("customer_id", to_item_replacements.customer_id)
                        .setString("date_added", to_item_replacements.date_added)
                        .setString("user_screen_name", to_item_replacements.user_screen_name)
                        .setString("user_id", to_item_replacements.user_id)
                        .setString("item_code", to_item_replacement_details.item_code)
                        .setString("barcode", to_item_replacement_details.barcode)
                        .setString("generic_name", to_item_replacement_details.generic_name)
                        .setString("description", to_item_replacement_details.description)
                        .setString("item_type", to_item_replacement_details.item_type)
                        .setString("serial_no", to_item_replacement_details.serial_no)
                        .setNumber("product_qty", to_item_replacement_details.product_qty)
                        .setString("unit", to_item_replacement_details.unit)
                        .setNumber("conversion", to_item_replacement_details.conversion)
                        .setNumber("selling_price", to_item_replacement_details.selling_price)
                        .setNumber("is_vatable", to_item_replacement_details.is_vatable)
                        .setNumber("selling_type", to_item_replacement_details.selling_type)
                        .setString("discount_name", to_item_replacement_details.discount_name)
                        .setNumber("discount_amount", to_item_replacement_details.discount_amount)
                        .setString("discount_customer_name", to_item_replacement_details.discount_customer_name)
                        .setString("discount_customer_id", to_item_replacement_details.discount_customer_id)
                        .setString("category", to_item_replacement_details.category)
                        .setString("category_id", to_item_replacement_details.category_id)
                        .setString("classification", to_item_replacement_details.classification)
                        .setString("sub_classification", to_item_replacement_details.sub_classification)
                        .setString("sub_classification_id", to_item_replacement_details.sub_classification_id)
                        .setString("brand", to_item_replacement_details.brand)
                        .setString("brand_id", to_item_replacement_details.brand_id)
                        .setString("model", to_item_replacement_details.model)
                        .setString("model_id", to_item_replacement_details.model_id)
                        .setNumber("is_replacement", 1)
                        .setString("reason", to_item_replacements.reason)
                        .setNumber("status", to_item_replacements.status)
                        .setString("branch", to_item_replacements.branch)
                        .setString("branch_id", to_item_replacements.branch_id)
                        .setString("location", to_item_replacements.location)
                        .setString("location_id", to_item_replacements.location_id)
                        .setNumber("addtl_amount", to_item_replacement_details.addtl_amount)
                        .setNumber("wtax", to_item_replacement_details.wtax)
                        .ok();
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Item_replacements.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_item_replacements to_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update item_replacements set "
                    + "item_replacement_no= :item_replacement_no "
                    + ",sales_no= :sales_no "
                    + ",customer_name= :customer_name "
                    + ",customer_id= :customer_id "
                    + ",date_added= :date_added "
                    + ",user_screen_name= :user_screen_name "
                    + ",user_id= :user_id "
                    + ",reason= :reason "
                    + ",amount_due= :amount_due "
                    + ",replacement_amount= :replacement_amount "
                    + ",discount= :discount "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",cash_amount= :cash_amount "
                    + ",check_holder= :check_holder "
                    + ",check_bank= :check_bank "
                    + ",check_no= :check_no "
                    + ",check_date= :check_date "
                    + ",check_amount= :check_amount "
                    + ",card_type= :card_type "
                    + ",credit_card_rate= :credit_card_rate "
                    + ",credit_card_amount= :credit_card_amount "
                    + ",credit_card_amount_to_pay= :credit_card_amount_to_pay "
                    + ",credit_card_no= :credit_card_no "
                    + ",credit_card_holder= :credit_card_holder "
                    + ",credit_card_approval_code= :credit_card_approval_code "
                    + ",prepaid_customer_name= :prepaid_customer_name "
                    + ",prepaid_customer_id= :prepaid_customer_id "
                    + ",prepaid_amount= :prepaid_amount "
                    + ",charge_reference_no= :charge_reference_no "
                    + ",charge_ar_no= :charge_ar_no "
                    + ",charge_type= :charge_type "
                    + ",charge_customer_name= :charge_customer_name "
                    + ",charge_customer_id= :charge_customer_id "
                    + ",charge_amount= :charge_amount "
                    + ",charge_days= :charge_days "
                    + ",gc_from= :gc_from "
                    + ",gc_description= :gc_description "
                    + ",gc_no= :gc_no "
                    + ",gc_amount= :gc_amount "
                    + ",online_holder= :online_holder "
                    + ",online_bank= :online_bank "
                    + ",online_reference_no= :online_reference_no "
                    + ",online_date= :online_date "
                    + ",online_amount= :online_amount "
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_replacement_no", to_item_replacements.item_replacement_no)
                    .setString("sales_no", to_item_replacements.sales_no)
                    .setString("customer_name", to_item_replacements.customer_name)
                    .setString("customer_id", to_item_replacements.customer_id)
                    .setString("date_added", to_item_replacements.date_added)
                    .setString("user_screen_name", to_item_replacements.user_screen_name)
                    .setString("user_id", to_item_replacements.user_id)
                    .setString("reason", to_item_replacements.reason)
                    .setNumber("amount_due", to_item_replacements.amount_due)
                    .setNumber("replacement_amount", to_item_replacements.replacement_amount)
                    .setNumber("discount", to_item_replacements.discount)
                    .setNumber("status", to_item_replacements.status)
                    .setString("branch", to_item_replacements.branch)
                    .setString("branch_id", to_item_replacements.branch_id)
                    .setString("location", to_item_replacements.location)
                    .setString("location_id", to_item_replacements.location_id)
                    .setNumber("cash_amount", to_item_replacements.cash_amount)
                    .setString("check_holder", to_item_replacements.check_holder)
                    .setString("check_bank", to_item_replacements.check_bank)
                    .setString("check_no", to_item_replacements.check_no)
                    .setString("check_date", to_item_replacements.check_date)
                    .setNumber("check_amount", to_item_replacements.check_amount)
                    .setString("card_type", to_item_replacements.card_type)
                    .setNumber("credit_card_rate", to_item_replacements.credit_card_rate)
                    .setNumber("credit_card_amount", to_item_replacements.credit_card_amount)
                    .setNumber("credit_card_amount_to_pay", to_item_replacements.credit_card_amount_to_pay)
                    .setString("credit_card_no", to_item_replacements.credit_card_no)
                    .setString("credit_card_holder", to_item_replacements.credit_card_holder)
                    .setString("credit_card_approval_code", to_item_replacements.credit_card_approval_code)
                    .setString("prepaid_customer_name", to_item_replacements.prepaid_customer_name)
                    .setString("prepaid_customer_id", to_item_replacements.prepaid_customer_id)
                    .setNumber("prepaid_amount", to_item_replacements.prepaid_amount)
                    .setString("charge_reference_no", to_item_replacements.charge_reference_no)
                    .setString("charge_ar_no", to_item_replacements.charge_ar_no)
                    .setString("charge_type", to_item_replacements.charge_type)
                    .setString("charge_customer_name", to_item_replacements.charge_customer_name)
                    .setString("charge_customer_id", to_item_replacements.charge_customer_id)
                    .setNumber("charge_amount", to_item_replacements.charge_amount)
                    .setNumber("charge_days", to_item_replacements.charge_days)
                    .setString("gc_from", to_item_replacements.gc_from)
                    .setString("gc_description", to_item_replacements.gc_description)
                    .setString("gc_no", to_item_replacements.gc_no)
                    .setNumber("gc_amount", to_item_replacements.gc_amount)
                    .setString("online_holder", to_item_replacements.online_holder)
                    .setString("online_bank", to_item_replacements.online_bank)
                    .setString("online_reference_no", to_item_replacements.online_reference_no)
                    .setString("online_date", to_item_replacements.online_date)
                    .setNumber("online_amount", to_item_replacements.online_amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_discount(to_item_replacements to_item_replacements, double new_discount) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update item_replacements set "
                    + " discount= :discount "
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("discount", new_discount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Item_replacements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_item_replacements to_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from item_replacements  "
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "delete from item_replacement_details  "
                    + " where item_replacement_no='" + to_item_replacements.item_replacement_no + "' "
                    + " ";
            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            Lg.s(Item_replacements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_transaction(to_item_replacements to_item_replacements, List<Item_replacement_details.to_item_replacement_details> selected, List<Item_replacement_details.to_item_replacement_details> replacements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "update item_replacements  "
                    + " set status = 1"
                    + " where id='" + to_item_replacements.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update item_replacement_details  "
                    + " set status = 1"
                    + " where item_replacement_no='" + to_item_replacements.item_replacement_no + "' "
                    + " ";
            stmt.addBatch(s2);

            for (Item_replacement_details.to_item_replacement_details item : selected) {
                String s11 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + item.item_code + "' and location_id='" + item.location_id + "'"
                        + " ";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                double product_qty2 = 0;
                while (rs11.next()) {
                    product_qty2 = rs11.getDouble(1);
                }

                double new_qty = product_qty2 + (item.conversion * item.product_qty);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + item.item_code + "' and location_id='" + item.location_id + "' "
                        + "";
                stmt.addBatch(s4);

            }

            for (Item_replacement_details.to_item_replacement_details item : replacements) {
                String s11 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + item.item_code + "' and location_id='" + item.location_id + "'"
                        + " ";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                double product_qty2 = 0;
                while (rs11.next()) {
                    product_qty2 = rs11.getDouble(1);
                }

                double new_qty = product_qty2 - (item.conversion * item.product_qty);
                String s5 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + item.item_code + "' and location_id='" + item.location_id + "' "
                        + "";
                stmt.addBatch(s5);

            }

            if (to_item_replacements.prepaid_amount > 0) {
                String prep = "select "
                        + "id"
                        + ",customer_name"
                        + ",customer_no"
                        + ",contact_no"
                        + ",credit_limit"
                        + ",address"
                        + ",term"
                        + ",location"
                        + ",balance"
                        + ",discount"
                        + ",prepaid"
                        + " from customers "
                        + " where id='" + to_item_replacements.prepaid_customer_id + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs = stmt2.executeQuery(prep);
                double prepaid = 0;
                if (rs.next()) {
                    prepaid = rs.getDouble(11);
                }
                prepaid = prepaid - to_item_replacements.prepaid_amount;
                String s3 = " update customers set prepaid='" + prepaid + "' "
                        + " where id='" + to_item_replacements.prepaid_customer_id + "' "
                        + " ";

                s3 = SqlStringUtil.parse(s3)
                        .ok();
                stmt.addBatch(s3);
            }
            if (to_item_replacements.prepaid_amount < 0) {
                int id = -1;
                double cash = to_item_replacements.prepaid_amount * -1;
                double check_amount = 0;

                String check_bank = "";
                String check_no = "";
                String added_by = MyUser.getUser_id();
                String date_added = DateType.now();
                String customer_name = to_item_replacements.prepaid_customer_name;
                String customer_id = "" + to_item_replacements.prepaid_customer_id;
                String cheque_holder = "";
                String cheque_date = DateType.sf.format(new Date());
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                String branch = to_item_replacements.branch;
                String branch_id = to_item_replacements.branch_id;
                String location = to_item_replacements.location;
                String location_id = to_item_replacements.location_id;
                String remarks = "Replacement: ";

                String credit_card_type = "";
                double credit_card_rate = 0;
                String credit_card_no = "";
                String credit_card_holder = "";
                double credit_card_amount = 0;
                String gift_certificate_from = "";
                String gift_certificate_description = "";
                String gift_certificate_no = "";
                double gift_certificate_amount = 0;
                String online_bank = "";
                String online_reference_no = "";
                String online_holder = "";
                String online_date = DateType.sf.format(new Date());
                double online_amount = 0;

                to_prepaid_payments to_prepaid_payments = new Prepaid_payments.to_prepaid_payments(id, cash, check_bank, check_no, check_amount, added_by, date_added, customer_name, customer_id, 1, true, cheque_holder, cheque_date, user_id, user_screen_name, branch, branch_id, location, location_id, remarks, id, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder, online_date, online_amount);
                //<editor-fold defaultstate="collapsed" desc=" prepaid ">
                String s8 = "insert into prepaid_payments("
                        + " cash"
                        + ",check_bank"
                        + ",check_no"
                        + ",check_amount"
                        + ",added_by"
                        + ",date_added"
                        + ",customer_name"
                        + ",customer_id"
                        + ",status"
                        + ",cheque_holder"
                        + ",cheque_date"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",remarks"
                        + ",refund"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_amount"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",gift_certificate_amount"
                        + ",online_bank"
                        + ",online_reference_no"
                        + ",online_holder"
                        + ",online_date"
                        + ",online_amount"
                        + ")values("
                        + ":cash"
                        + ",:check_bank"
                        + ",:check_no"
                        + ",:check_amount"
                        + ",:added_by"
                        + ",:date_added"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:status"
                        + ",:cheque_holder"
                        + ",:cheque_date"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:remarks"
                        + ",:refund"
                        + ",:credit_card_type"
                        + ",:credit_card_rate"
                        + ",:credit_card_no"
                        + ",:credit_card_holder"
                        + ",:credit_card_amount"
                        + ",:gift_certificate_from"
                        + ",:gift_certificate_description"
                        + ",:gift_certificate_no"
                        + ",:gift_certificate_amount"
                        + ",:online_bank"
                        + ",:online_reference_no"
                        + ",:online_holder"
                        + ",:online_date"
                        + ",:online_amount"
                        + ")";

                s8 = SqlStringUtil.parse(s8)
                        .setNumber("cash", to_prepaid_payments.cash)
                        .setString("check_bank", to_prepaid_payments.check_bank)
                        .setString("check_no", to_prepaid_payments.check_no)
                        .setNumber("check_amount", to_prepaid_payments.check_amount)
                        .setString("added_by", to_prepaid_payments.added_by)
                        .setString("date_added", to_prepaid_payments.date_added)
                        .setString("customer_name", to_prepaid_payments.customer_name)
                        .setString("customer_id", to_prepaid_payments.customer_id)
                        .setNumber("status", to_prepaid_payments.status)
                        .setString("cheque_holder", to_prepaid_payments.cheque_holder)
                        .setString("cheque_date", to_prepaid_payments.cheque_date)
                        .setString("user_id", to_prepaid_payments.user_id)
                        .setString("user_screen_name", to_prepaid_payments.user_screen_name)
                        .setString("branch", to_prepaid_payments.branch)
                        .setString("branch_id", to_prepaid_payments.branch_id)
                        .setString("location", to_prepaid_payments.location)
                        .setString("location_id", to_prepaid_payments.location_id)
                        .setString("remarks", to_prepaid_payments.remarks)
                        .setNumber("refund", to_prepaid_payments.refund)
                        .setString("credit_card_type", to_prepaid_payments.credit_card_type)
                        .setNumber("credit_card_rate", to_prepaid_payments.credit_card_rate)
                        .setString("credit_card_no", to_prepaid_payments.credit_card_no)
                        .setString("credit_card_holder", to_prepaid_payments.credit_card_holder)
                        .setNumber("credit_card_amount", to_prepaid_payments.credit_card_amount)
                        .setString("gift_certificate_from", to_prepaid_payments.gift_certificate_from)
                        .setString("gift_certificate_description", to_prepaid_payments.gift_certificate_description)
                        .setString("gift_certificate_no", to_prepaid_payments.gift_certificate_no)
                        .setNumber("gift_certificate_amount", to_prepaid_payments.gift_certificate_amount)
                        .setString("online_bank", to_prepaid_payments.online_bank)
                        .setString("online_reference_no", to_prepaid_payments.online_reference_no)
                        .setString("online_holder", to_prepaid_payments.online_holder)
                        .setString("online_date", to_prepaid_payments.online_date)
                        .setNumber("online_amount", to_prepaid_payments.online_amount)
                        .ok();
                stmt.addBatch(s8);

                Customers.to_customers cus = S1_accounts_receivable_payments.ret_customer_balance2(to_item_replacements.prepaid_customer_id);
                double new_balance = cus.prepaid + (to_prepaid_payments.cash + to_prepaid_payments.check_amount + to_prepaid_payments.credit_card_amount + to_prepaid_payments.gift_certificate_amount + to_prepaid_payments.online_amount);
                String s9 = "update  customers set "
                        + " prepaid= :prepaid"
                        + " where "
                        + " id ='" + to_prepaid_payments.customer_id + "' "
                        + " ";
                s9 = SqlStringUtil.parse(s9).
                        setNumber("prepaid", new_balance).
                        ok();
                stmt.addBatch(s9);

                //</editor-fold>
            }

            if (to_item_replacements.charge_amount > 0) {
                int id = -1;
                String customer_id = to_item_replacements.charge_customer_id;
                String customer_name = to_item_replacements.customer_name;
                String ar_no = S1_accounts_receivable.increment_id(to_item_replacements.branch_id);
                String date_added = DateType.now();
                String user_name = Users.user_name;
                double amount = to_item_replacements.charge_amount;
                double discount_amount = 0;// FitIn.toDouble(tf_discount_amount.getText();
                double discount_rate = 0;//FitIn.toDouble(tf_discount_rate.getText();
                String discount = "";//tf_discount.getText();
                int status = 0;// FitIn.toInt(tf_status.getText());
                double term = to_item_replacements.charge_days;
                String date_applied = DateType.sf.format(new Date());

                double paid = 0;
                String date_paid = date_applied;
                String remarks = "";
                String type = "AR";//tf_type.getText();
                String or_no = "";//tf_or_no.getText();
                String ci_no = to_item_replacements.charge_reference_no;//tf_or_no.getText();
                String trust_receipt = to_item_replacements.charge_reference_no;//tf_or_no.getText();
                String soa_id = "1";
                String soa_type = to_item_replacements.charge_type;
                String soa_type_id = "";
                String reference_no = to_item_replacements.charge_reference_no;
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                String branch = to_item_replacements.branch;
                String branch_id = to_item_replacements.branch_id;
                String location = to_item_replacements.location;
                String location_id = to_item_replacements.location_id;

                final S1_accounts_receivable.to_accounts_receivable to_accounts_receivable = new S1_accounts_receivable.to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
                String s10 = "insert into  accounts_receivable("
                        + "customer_id"
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
                        + ")values("
                        + ":customer_id"
                        + ",:customer_name"
                        + ",:ar_no"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:amount"
                        + ",:discount_amount"
                        + ",:discount_rate"
                        + ",:discount"
                        + ",:status"
                        + ",:term"
                        + ",:date_applied"
                        + ",:paid"
                        + ",:date_paid"
                        + ",:remarks"
                        + ",:type"
                        + ",:or_no"
                        + ",:ci_no"
                        + ",:trust_receipt"
                        + ",:soa_id"
                        + ",:soa_type"
                        + ",:soa_type_id"
                        + ",:reference_no"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s10 = SqlStringUtil.parse(s10).
                        setString("customer_id", to_accounts_receivable.customer_id).
                        setString("customer_name", to_accounts_receivable.customer_name).
                        setString("ar_no", to_accounts_receivable.ar_no).
                        setString("date_added", to_accounts_receivable.date_added).
                        setString("user_name", to_accounts_receivable.user_name).
                        setNumber("amount", to_accounts_receivable.amount).
                        setNumber("discount_amount", to_accounts_receivable.discount_amount).
                        setNumber("discount_rate", to_accounts_receivable.discount_rate).
                        setString("discount", to_accounts_receivable.discount).
                        setNumber("status", to_accounts_receivable.status).
                        setNumber("term", to_accounts_receivable.term).
                        setString("date_applied", to_accounts_receivable.date_applied).
                        setNumber("paid", to_accounts_receivable.paid).
                        setString("date_paid", to_accounts_receivable.date_paid).
                        setString("remarks", to_accounts_receivable.remarks).
                        setString("type", to_accounts_receivable.type).
                        setString("or_no", to_accounts_receivable.or_no).
                        setString("ci_no", to_accounts_receivable.ci_no).
                        setString("trust_receipt", to_accounts_receivable.trust_receipt).
                        setString("soa_id", to_accounts_receivable.soa_id).
                        setString("soa_type", to_accounts_receivable.soa_type).
                        setString("soa_type_id", to_accounts_receivable.soa_type_id).
                        setString("reference_no", to_accounts_receivable.reference_no).
                        setString("user_id", to_accounts_receivable.user_id).
                        setString("user_screen_name", to_accounts_receivable.user_screen_name).
                        setString("branch", to_accounts_receivable.branch).
                        setString("branch_id", to_accounts_receivable.branch_id).
                        setString("location", to_accounts_receivable.location).
                        setString("location_id", to_accounts_receivable.location_id).
                        ok();
                stmt.addBatch(s10);

                String s11 = "select "
                        + "balance"
                        + " from  customers where "
                        + " customer_no ='" + to_accounts_receivable.customer_id + "' "
                        + " ";
                double customer_balance = 0;
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                if (rs11.next()) {
                    customer_balance = rs11.getDouble(1);
                }

                double new_balance = customer_balance + to_accounts_receivable.amount;
                String s12 = "update  customers set "
                        + "balance= :balance"
                        + " where "
                        + " customer_no ='" + to_accounts_receivable.customer_id + "' "
                        + " ";
                s12 = SqlStringUtil.parse(s12).
                        setNumber("balance", new_balance).
                        ok();

                stmt.addBatch(s12);
            }
            if (to_item_replacements.charge_amount < 0) {
                String customer_id = to_item_replacements.charge_customer_id;
                String customer_name = to_item_replacements.charge_customer_name;
                String ar_no = to_item_replacements.charge_ar_no;
                String date_added = DateType.datetime.format(new Date());
                String user_name = Users.user_name;
                double amount = to_item_replacements.charge_amount * -1;
                double discount_amount = 0;
                double discount_rate = 0;
                String discount = "";
                int status = 0;
                double term = 0;
                String date_applied = DateType.sf.format(new Date());
                double paid = 0;
                String date_paid = DateType.sf.format(new Date());
                String remarks = "";
                String type = "CASH";
                String or_no = "";
                double prev_balance = 0;
                double check_amount = 0;
                String check_holder = "";
                String check_bank = "";
                String check_no = "";
                String ci_no = "";//tf_or_no.getText();
                String trust_receipt = to_item_replacements.charge_reference_no;//tf_or_no.getText();
                String or_payment_no = "";
                String soa_id = "1";
                String soa_type = to_item_replacements.charge_type;
                String soa_type_id = "1";
                String reference_no = to_item_replacements.charge_reference_no;
                String check_date = DateType.sf.format(new Date());
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                double tax_rate = 0;
                double tax_amount = 0;

                String branch = to_item_replacements.branch;
                String branch_id = to_item_replacements.branch_id;
                String location = to_item_replacements.location;
                String location_id = to_item_replacements.location_id;

                String prepaid_customer_name = "";
                String prepaid_customer_id = "";
                double prepaid_amount = 0;
                String credit_card_type = "";
                double credit_card_rate = 0;
                String credit_card_no = "";
                String credit_card_holder = "";
                double credit_card_amount = 0;
                String gift_certificate_from = "";
                String gift_certificate_description = "";
                String gift_certificate_no = "";
                double gift_certificate_amount = 0;
                String online_bank = "";
                String online_reference_no = "";
                String online_holder = "";
                String online_date = DateType.now();
                double online_amount = 0;
                double actual_amount = (amount + check_amount) - discount_amount;
                double retention = 0;
                double business_tax = 0;
                double salary_deduction=0;
                final S1_accounts_receivable_payments.to_accounts_receivable_payments to_accounts_receivable_payments = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                        status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid,
                        date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id,
                        soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location,
                        location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no,
                        credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount,
                        online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount, retention, business_tax,salary_deduction);

                //<editor-fold defaultstate="collapsed" desc=" Add AR Payment ">
                String s13 = "insert into  accounts_receivable_payments("
                        + "customer_id"
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
                        + ",prev_balance"
                        + ",check_amount"
                        + ",check_holder"
                        + ",check_bank"
                        + ",check_no"
                        + ",ci_no"
                        + ",trust_receipt"
                        + ",or_payment_no"
                        + ",soa_id"
                        + ",soa_type"
                        + ",soa_type_id"
                        + ",reference_no"
                        + ",check_date"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",tax_rate"
                        + ",tax_amount"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",prepaid_customer_name"
                        + ",prepaid_customer_id"
                        + ",prepaid_amount"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_amount"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",gift_certificate_amount"
                        + ",online_bank"
                        + ",online_reference_no"
                        + ",online_holder"
                        + ",online_date"
                        + ",online_amount"
                        + ",actual_amount"
                        + ")values("
                        + ":customer_id"
                        + ",:customer_name"
                        + ",:ar_no"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:amount"
                        + ",:discount_amount"
                        + ",:discount_rate"
                        + ",:discount"
                        + ",:status"
                        + ",:term"
                        + ",:date_applied"
                        + ",:paid"
                        + ",:date_paid"
                        + ",:remarks"
                        + ",:type"
                        + ",:or_no"
                        + ",:prev_balance"
                        + ",:check_amount"
                        + ",:check_holder"
                        + ",:check_bank"
                        + ",:check_no"
                        + ",:ci_no"
                        + ",:trust_receipt"
                        + ",:or_payment_no"
                        + ",:soa_id"
                        + ",:soa_type"
                        + ",:soa_type_id"
                        + ",:reference_no"
                        + ",:check_date"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:tax_rate"
                        + ",:tax_amount"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:prepaid_customer_name"
                        + ",:prepaid_customer_id"
                        + ",:prepaid_amount"
                        + ",:credit_card_type"
                        + ",:credit_card_rate"
                        + ",:credit_card_no"
                        + ",:credit_card_holder"
                        + ",:credit_card_amount"
                        + ",:gift_certificate_from"
                        + ",:gift_certificate_description"
                        + ",:gift_certificate_no"
                        + ",:gift_certificate_amount"
                        + ",:online_bank"
                        + ",:online_reference_no"
                        + ",:online_holder"
                        + ",:online_date"
                        + ",:online_amount"
                        + ",:actual_amount"
                        + ")";

                s13 = SqlStringUtil.parse(s13).
                        setString("customer_id", to_accounts_receivable_payments.customer_id).
                        setString("customer_name", to_accounts_receivable_payments.customer_name).
                        setString("ar_no", to_accounts_receivable_payments.ar_no).
                        setString("date_added", to_accounts_receivable_payments.date_added).
                        setString("user_name", to_accounts_receivable_payments.user_name).
                        setNumber("amount", to_accounts_receivable_payments.amount).
                        setNumber("discount_amount", to_accounts_receivable_payments.discount_amount).
                        setNumber("discount_rate", to_accounts_receivable_payments.discount_rate).
                        setString("discount", to_accounts_receivable_payments.discount).
                        setNumber("status", to_accounts_receivable_payments.status).
                        setNumber("term", to_accounts_receivable_payments.term).
                        setString("date_applied", to_accounts_receivable_payments.date_applied).
                        setNumber("paid", to_accounts_receivable_payments.paid).
                        setString("date_paid", to_accounts_receivable_payments.date_paid).
                        setString("remarks", to_accounts_receivable_payments.remarks).
                        setString("type", to_accounts_receivable_payments.type).
                        setString("or_no", to_accounts_receivable_payments.or_no).
                        setNumber("prev_balance", to_accounts_receivable_payments.prev_balance).
                        setNumber("check_amount", to_accounts_receivable_payments.check_amount).
                        setString("check_holder", to_accounts_receivable_payments.check_holder).
                        setString("check_bank", to_accounts_receivable_payments.check_bank).
                        setString("check_no", to_accounts_receivable_payments.check_no).
                        setString("ci_no", to_accounts_receivable_payments.ci_no).
                        setString("trust_receipt", to_accounts_receivable_payments.trust_receipt).
                        setString("or_payment_no", to_accounts_receivable_payments.or_payment_no).
                        setString("soa_id", to_accounts_receivable_payments.soa_id).
                        setString("soa_type", to_accounts_receivable_payments.soa_type).
                        setString("soa_type_id", to_accounts_receivable_payments.soa_type_id).
                        setString("reference_no", to_accounts_receivable_payments.reference_no).
                        setString("check_date", to_accounts_receivable_payments.check_date).
                        setString("user_id", to_accounts_receivable_payments.user_id).
                        setString("user_screen_name", to_accounts_receivable_payments.user_screen_name).
                        setNumber("tax_rate", to_accounts_receivable_payments.tax_rate).
                        setNumber("tax_amount", to_accounts_receivable_payments.tax_amount).
                        setString("branch", to_accounts_receivable_payments.branch).
                        setString("branch_id", to_accounts_receivable_payments.branch_id).
                        setString("location", to_accounts_receivable_payments.location).
                        setString("location_id", to_accounts_receivable_payments.location_id)
                        .setString("prepaid_customer_name", to_accounts_receivable_payments.prepaid_customer_name)
                        .setString("prepaid_customer_id", to_accounts_receivable_payments.prepaid_customer_id)
                        .setNumber("prepaid_amount", to_accounts_receivable_payments.prepaid_amount)
                        .setString("credit_card_type", to_accounts_receivable_payments.credit_card_type)
                        .setNumber("credit_card_rate", to_accounts_receivable_payments.credit_card_rate)
                        .setString("credit_card_no", to_accounts_receivable_payments.credit_card_no)
                        .setString("credit_card_holder", to_accounts_receivable_payments.credit_card_holder)
                        .setNumber("credit_card_amount", to_accounts_receivable_payments.credit_card_amount)
                        .setString("gift_certificate_from", to_accounts_receivable_payments.gift_certificate_from)
                        .setString("gift_certificate_description", to_accounts_receivable_payments.gift_certificate_description)
                        .setString("gift_certificate_no", to_accounts_receivable_payments.gift_certificate_no)
                        .setNumber("gift_certificate_amount", to_accounts_receivable_payments.gift_certificate_amount)
                        .setString("online_bank", to_accounts_receivable_payments.online_bank)
                        .setString("online_reference_no", to_accounts_receivable_payments.online_reference_no)
                        .setString("online_holder", to_accounts_receivable_payments.online_holder)
                        .setString("online_date", to_accounts_receivable_payments.online_date)
                        .setNumber("online_amount", to_accounts_receivable_payments.online_amount)
                        .setNumber("actual_amount", to_accounts_receivable_payments.actual_amount)
                        .ok();

                stmt.addBatch(s13);

                Customers.to_customers cus = ret_customer_balance(to_accounts_receivable_payments.customer_id);
                double tendered = to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount + to_accounts_receivable_payments.prepaid_amount + to_accounts_receivable_payments.credit_card_amount + to_accounts_receivable_payments.gift_certificate_amount + to_accounts_receivable_payments.online_amount;
                double new_balance = cus.balance - (tendered + to_accounts_receivable_payments.discount_amount);
                double actual_amount2 = to_accounts_receivable_payments.actual_amount;

                String s14 = "update  customers set "
                        + " balance= :balance"
                        + " where "
                        + " customer_no ='" + to_accounts_receivable_payments.customer_id + "' "
                        + " ";
                s14 = SqlStringUtil.parse(s14).
                        setNumber("balance", new_balance).
                        ok();
                stmt.addBatch(s14);

                String s15 = "select "
                        + " paid"
                        + " from  accounts_receivable where "
                        + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                        + " ";
                double paid2 = 0;
                Statement stmt15 = conn.createStatement();
                ResultSet rs15 = stmt15.executeQuery(s15);
                while (rs15.next()) {
                    paid2 = rs15.getDouble(1);
                }

                double new_paid = paid2 + (to_accounts_receivable_payments.amount + to_accounts_receivable_payments.check_amount + to_accounts_receivable_payments.discount_amount);
                String s16 = "update  accounts_receivable set "
                        + "paid= :paid"
                        + " where "
                        + " ar_no ='" + to_accounts_receivable_payments.ar_no + "' "
                        + " ";

                s16 = SqlStringUtil.parse(s16).
                        setNumber("paid", new_paid).
                        ok();

                stmt.addBatch(s16);

                //</editor-fold>
            }
            stmt.executeBatch();
            conn.commit();

            Lg.s(Item_replacements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_item_replacements> ret_data(String where) {
        List<to_item_replacements> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_replacement_no"
                    + ",sales_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",reason"
                    + ",amount_due"
                    + ",replacement_amount"
                    + ",discount"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",cash_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_date"
                    + ",check_amount"
                    + ",card_type"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",credit_card_amount_to_pay"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + ",prepaid_customer_name"
                    + ",prepaid_customer_id"
                    + ",prepaid_amount"
                    + ",charge_reference_no"
                    + ",charge_ar_no"
                    + ",charge_type"
                    + ",charge_customer_name"
                    + ",charge_customer_id"
                    + ",charge_amount"
                    + ",charge_days"
                    + ",gc_from"
                    + ",gc_description"
                    + ",gc_no"
                    + ",gc_amount"
                    + ",online_holder"
                    + ",online_bank"
                    + ",online_reference_no"
                    + ",online_date"
                    + ",online_amount"
                    + " from item_replacements"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_replacement_no = rs.getString(2);
                String sales_no = rs.getString(3);
                String customer_name = rs.getString(4);
                String customer_id = rs.getString(5);
                String date_added = rs.getString(6);
                String user_screen_name = rs.getString(7);
                String user_id = rs.getString(8);
                String reason = rs.getString(9);
                double amount_due = rs.getDouble(10);
                double replacement_amount = rs.getDouble(11);
                double discount = rs.getDouble(12);
                int status = rs.getInt(13);
                String branch = rs.getString(14);
                String branch_id = rs.getString(15);
                String location = rs.getString(16);
                String location_id = rs.getString(17);
                double cash_amount = rs.getDouble(18);
                String check_holder = rs.getString(19);
                String check_bank = rs.getString(20);
                String check_no = rs.getString(21);
                String check_date = rs.getString(22);
                double check_amount = rs.getDouble(23);
                String card_type = rs.getString(24);
                double credit_card_rate = rs.getDouble(25);
                double credit_card_amount = rs.getDouble(26);
                double credit_card_amount_to_pay = rs.getDouble(27);
                String credit_card_no = rs.getString(28);
                String credit_card_holder = rs.getString(29);
                String credit_card_approval_code = rs.getString(30);
                String prepaid_customer_name = rs.getString(31);
                String prepaid_customer_id = rs.getString(32);
                double prepaid_amount = rs.getDouble(33);
                String charge_reference_no = rs.getString(34);
                String charge_ar_no = rs.getString(35);
                String charge_type = rs.getString(36);
                String charge_customer_name = rs.getString(37);
                String charge_customer_id = rs.getString(38);
                double charge_amount = rs.getDouble(39);
                int charge_days = rs.getInt(40);
                String gc_from = rs.getString(41);
                String gc_description = rs.getString(42);
                String gc_no = rs.getString(43);
                double gc_amount = rs.getDouble(44);
                String online_holder = rs.getString(45);
                String online_bank = rs.getString(46);
                String online_reference_no = rs.getString(47);
                String online_date = rs.getString(48);
                double online_amount = rs.getDouble(49);

                to_item_replacements to = new to_item_replacements(id, item_replacement_no, sales_no, customer_name, customer_id, date_added, user_screen_name, user_id, reason, amount_due, replacement_amount, discount, status, branch, branch_id, location, location_id, cash_amount, check_holder, check_bank, check_no, check_date, check_amount, card_type, credit_card_rate, credit_card_amount, credit_card_amount_to_pay, credit_card_no, credit_card_holder, credit_card_approval_code, prepaid_customer_name, prepaid_customer_id, prepaid_amount, charge_reference_no, charge_ar_no, charge_type, charge_customer_name, charge_customer_id, charge_amount, charge_days, gc_from, gc_description, gc_no, gc_amount, online_holder, online_bank, online_reference_no, online_date, online_amount);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id(String location_id) {

        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from item_replacements where location_id='" + location_id + "'  ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
//            System.out.println(s0);
            if (rs.next()) {
                id = rs.getString(1);

                String s2 = "select item_replacement_no,id from item_replacements where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }

            if (id == null) {
                id = location_id + "|" + "0000000000";
            }

            id = ReceiptIncrementor.increment(id);

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
