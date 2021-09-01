/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.customers.Customers.to_customers;
import POS.my_sales.MySales;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class Sales {

    public static class to_sales {

        public final int id;
        public final String sales_no;
        public final String date_added;
        public final String user_name;
        public final String session_no;
        public final double gross_amount;
        public final double amount_paid;
        public final double amount_due;
        public final String discount_name;
        public final double discount;
        public final double discount_amount;
        public final String customer_name;
        public final String check_bank;
        public final String check_no;
        public final double check_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final int status;
        public final String or_no;
        public final String check_holder;
        public final String services;
        public final double service_amount;
        public final String charge_account_name;
        public final double charge_amount;
        public final String charge_account_id;
        public final double credit_card;
        public final String credit_card_name;
        public final double credit_card_rate;
        public final double credit_card_amount;
        public final int sales_type;
        public final double prepaid_amount;
        public final String prepaid_customer_id;
        public final String prepaid_customer_name;
        public boolean selected;
        public final double line_discount;
        public final double addtl_amount;
        public final double wtax;

        public to_sales(int id, String sales_no, String date_added, String user_name, String session_no, double gross_amount, double amount_paid, double amount_due, String discount_name, double discount, double discount_amount, String customer_name, String check_bank, String check_no, double check_amount, String discount_customer_name, String discount_customer_id, int status, String or_no, String check_holder, String services, double service_amount, String charge_account_name, double charge_amount, String charge_account_id, double credit_card, String credit_card_name, double credit_card_rate, double credit_card_amount, int sales_type, double prepaid_amount, String prepaid_customer_id, String prepaid_customer_name, boolean selected, double line_discount, double addtl_amount, double wtax) {
            this.id = id;
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_name = user_name;
            this.session_no = session_no;
            this.gross_amount = gross_amount;
            this.amount_paid = amount_paid;
            this.amount_due = amount_due;
            this.discount_name = discount_name;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.customer_name = customer_name;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.status = status;
            this.or_no = or_no;
            this.check_holder = check_holder;
            this.services = services;
            this.service_amount = service_amount;
            this.charge_account_name = charge_account_name;
            this.charge_amount = charge_amount;
            this.charge_account_id = charge_account_id;
            this.credit_card = credit_card;
            this.credit_card_name = credit_card_name;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.sales_type = sales_type;
            this.prepaid_amount = prepaid_amount;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_customer_name = prepaid_customer_name;
            this.selected = selected;
            this.line_discount = line_discount;
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_sales(to_sales to_sales) {
        try {

            Connection conn = MyConnection.connect();
            String s0 = "insert into sales("
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",charge_account_name"
                    + ",charge_amount"
                    + ",charge_account_id"
                    + ",credit_card"
                    + ",credit_card_name"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",sales_type"
                    + ",prepaid_amount"
                    + ",prepaid_customer_id"
                    + ",prepaid_customer_name"
                    + ",line_discount"
                    + ",addtl_amount"
                    + ",wtax"
                    + ")values("
                    + ":id"
                    + ",:sales_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:gross_amount"
                    + ",:amount_paid"
                    + ",:amount_due"
                    + ",:discount_name"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:customer_name"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:status"
                    + ",:or_no"
                    + ",:check_holder"
                    + ",:services"
                    + ",:service_amount"
                    + ",:charge_account_name"
                    + ",:charge_amount"
                    + ",:charge_account_id"
                    + ",:credit_card"
                    + ",:credit_card_name"
                    + ",:credit_card_rate"
                    + ",:credit_card_amount"
                    + ",:sales_type"
                    + ",:prepaid_amount"
                    + ",:prepaid_customer_id"
                    + ",:prepaid_customer_name"
                    + ",:line_discount"
                    + ",:addtl_amount"
                    + ",:wtax"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("id", to_sales.id)
                    .setString("sales_no", to_sales.sales_no)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.session_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", to_sales.or_no)
                    .setString("check_holder", to_sales.check_holder)
                    .setString("services", to_sales.services)
                    .setNumber("service_amount", to_sales.service_amount)
                    .setString("charge_account_name", to_sales.charge_account_name)
                    .setNumber("charge_amount", to_sales.charge_amount)
                    .setString("charge_account_id", to_sales.charge_account_id)
                    .setNumber("credit_card", to_sales.credit_card)
                    .setString("credit_card_name", to_sales.credit_card_name)
                    .setNumber("credit_card_rate", to_sales.credit_card_rate)
                    .setNumber("credit_card_amount", to_sales.credit_card_amount)
                    .setNumber("sales_type", to_sales.sales_type)
                    .setNumber("prepaid_amount", to_sales.prepaid_amount)
                    .setString("prepaid_customer_id", to_sales.prepaid_customer_id)
                    .setString("prepaid_customer_name", to_sales.prepaid_customer_name)
                    .setNumber("line_discount", to_sales.line_discount)
                    .setNumber("addtl_amount", to_sales.addtl_amount)
                    .setNumber("wtax", to_sales.wtax)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sales.class, "Successfully Added");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_customers ret_customer_balance(String account_id) {
        to_customers to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
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
                    + ",branch"
                    + ",branch_id"
                    + ",location_id"
                    + ",department"
                    + ",department_id"
                    + " from  customers where "
                    + " customer_no ='" + account_id + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                double prepaid = rs.getDouble(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location_id = rs.getString(14);
                String department = rs.getString(15);
                String department_id = rs.getString(16);
                to1 = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, prepaid, branch, branch_id, location_id, department, department_id);

            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void edit_sales(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales set "
                    + "sales_no= :sales_no"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",session_no= :session_no"
                    + ",gross_amount= :gross_amount"
                    + ",amount_paid= :amount_paid"
                    + ",amount_due= :amount_due"
                    + ",discount_name= :discount_name"
                    + ",discount= :discount"
                    + ",discount_amount= :discount_amount"
                    + ",customer_name= :customer_name"
                    + ",check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",check_amount= :check_amount"
                    + ",discount_customer_name= :discount_customer_name"
                    + ",discount_customer_id= :discount_customer_id"
                    + ",status= :status"
                    + ",or_no= :or_no"
                    + ",check_holder= :check_holder"
                    + ",services= :services"
                    + ",service_amount= :service_amount"
                    + ",charge_account_name= :charge_account_name"
                    + ",charge_amount= :charge_amount"
                    + ",charge_account_id= :charge_account_id"
                    + ",credit_card= :credit_card"
                    + ",credit_card_name= :credit_card_name"
                    + ",credit_card_rate= :credit_card_rate"
                    + ",credit_card_amount= :credit_card_amount"
                    + ",sales_type= :sales_type"
                    + ",prepaid_amount= :prepaid_amount"
                    + ",prepaid_customer_id= :prepaid_customer_id"
                    + ",prepaid_customer_name= :prepaid_customer_name"
                    + ",line_discount= :line_discount"
                    + ",addtl_amount= :addtl_amount"
                    + ",wtax= :wtax"
                    + " where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sales.sales_no)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.session_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", to_sales.or_no)
                    .setString("check_holder", to_sales.check_holder)
                    .setString("services", to_sales.services)
                    .setNumber("service_amount", to_sales.service_amount)
                    .setString("charge_account_name", to_sales.charge_account_name)
                    .setNumber("charge_amount", to_sales.charge_amount)
                    .setString("charge_account_id", to_sales.charge_account_id)
                    .setNumber("credit_card", to_sales.credit_card)
                    .setString("credit_card_name", to_sales.credit_card_name)
                    .setNumber("credit_card_rate", to_sales.credit_card_rate)
                    .setNumber("credit_card_amount", to_sales.credit_card_amount)
                    .setNumber("sales_type", to_sales.sales_type)
                    .setNumber("prepaid_amount", to_sales.prepaid_amount)
                    .setString("prepaid_customer_id", to_sales.prepaid_customer_id)
                    .setString("prepaid_customer_name", to_sales.prepaid_customer_name)
                    .setNumber("line_discount", to_sales.line_discount)
                    .setNumber("addtl_amount", to_sales.addtl_amount)
                    .setNumber("wtax", to_sales.wtax)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  sales where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sales.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_customer_name(MySales.sales sale, String new_customer_name) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales set customer_name= :customer_name where "
                    + " id ='" + sale.id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_name", new_customer_name)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_serial(String sales_item_id, String serial_no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sale_items set serial_no= :serial_no where "
                    + " id ='" + sales_item_id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("serial_no", serial_no)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data(String date_from, String date_to, String user_names) {
        List<to_sales> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",charge_account_name"
                    + ",charge_amount"
                    + ",charge_account_id"
                    + ",credit_card"
                    + ",credit_card_name"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",sales_type"
                    + ",prepaid_amount"
                    + ",prepaid_customer_id"
                    + ",prepaid_customer_name"
                    + ",line_discount"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from  sales "
                    + " where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like'%" + user_names + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String charge_account_name = rs.getString(23);
                double charge_amount = rs.getDouble(24);
                String charge_account_id = rs.getString(25);
                double credit_card = rs.getDouble(26);
                String credit_card_name = rs.getString(27);
                double credit_card_rate = rs.getDouble(28);
                double credit_card_amount = rs.getDouble(29);
                int sales_type = rs.getInt(30);
                double prepaid_amount = rs.getDouble(31);
                String prepaid_customer_id = rs.getString(32);
                String prepaid_customer_name = rs.getString(33);
                double line_discount = rs.getDouble(34);
                double addtl_amount = rs.getDouble(35);
                double wtax = rs.getDouble(36);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, charge_account_name, charge_amount, charge_account_id, credit_card, credit_card_name, credit_card_rate, credit_card_amount, sales_type, prepaid_amount, prepaid_customer_id, prepaid_customer_name, false, line_discount, addtl_amount, wtax);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data_or(String date_from, String date_to, String or_nos) {
        List<to_sales> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",charge_account_name"
                    + ",charge_amount"
                    + ",charge_account_id"
                    + ",credit_card"
                    + ",credit_card_name"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",sales_type"
                    + ",prepaid_amount"
                    + ",prepaid_customer_id"
                    + ",prepaid_customer_name"
                    + ",line_discount"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from  sales "
                    + " where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and or_no like '%" + or_nos + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String charge_account_name = rs.getString(23);
                double charge_amount = rs.getDouble(24);
                String charge_account_id = rs.getString(25);
                double credit_card = rs.getDouble(26);
                String credit_card_name = rs.getString(27);
                double credit_card_rate = rs.getDouble(28);
                double credit_card_amount = rs.getDouble(29);
                int sales_type = rs.getInt(30);
                double prepaid_amount = rs.getDouble(31);
                String prepaid_customer_id = rs.getString(32);
                String prepaid_customer_name = rs.getString(33);
                double line_discount = rs.getDouble(34);
                double addtl_amount = rs.getDouble(35);
                double wtax = rs.getDouble(36);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, charge_account_name, charge_amount, charge_account_id, credit_card, credit_card_name, credit_card_rate, credit_card_amount, sales_type, prepaid_amount, prepaid_customer_id, prepaid_customer_name, false, line_discount, addtl_amount, wtax);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data_where(String where) {
        List<to_sales> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",charge_account_name"
                    + ",charge_amount"
                    + ",charge_account_id"
                    + ",credit_card"
                    + ",credit_card_name"
                    + ",credit_card_rate"
                    + ",credit_card_amount"
                    + ",sales_type"
                    + ",prepaid_amount"
                    + ",prepaid_customer_id"
                    + ",prepaid_customer_name"
                    + ",line_discount"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from  sales "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String charge_account_name = rs.getString(23);
                double charge_amount = rs.getDouble(24);
                String charge_account_id = rs.getString(25);
                double credit_card = rs.getDouble(26);
                String credit_card_name = rs.getString(27);
                double credit_card_rate = rs.getDouble(28);
                double credit_card_amount = rs.getDouble(29);
                int sales_type = rs.getInt(30);
                double prepaid_amount = rs.getDouble(31);
                String prepaid_customer_id = rs.getString(32);
                String prepaid_customer_name = rs.getString(33);
                double line_discount = rs.getDouble(34);
                double addtl_amount = rs.getDouble(35);
                double wtax = rs.getDouble(36);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, charge_account_name, charge_amount, charge_account_id, credit_card, credit_card_name, credit_card_rate, credit_card_amount, sales_type, prepaid_amount, prepaid_customer_id, prepaid_customer_name, false, line_discount, addtl_amount, wtax);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "0000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from  sales";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "0000000000";
            } else {
                String s2 = "select sales_no from  sales where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }

            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int count_sales() {
        int count = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select count(id) from  sales";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
