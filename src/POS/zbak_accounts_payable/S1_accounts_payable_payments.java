/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.zbak_accounts_payable;

import POS.main.Main.MyDB;
import POS.suppliers.S1_suppliers;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_accounts_payable_payments {

    public static class to_accounts_receivable_payments {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String ar_no;
        public final String date_added;
        public final String user_name;
        public final double amount;
        public final double discount_amount;
        public final double discount_rate;
        public final String discount;
        public final int status;
        public final double term;
        public final String date_applied;
        public final double paid;
        public final String date_paid;
        public final String remarks;
        public final String type;
        public final String or_no;
        public final double prev_balance;

        public to_accounts_receivable_payments(int id, String customer_id, String customer_name, String ar_no, String date_added, String user_name, double amount, double discount_amount, double discount_rate, String discount, int status, double term, String date_applied, double paid, String date_paid, String remarks, String type, String or_no, double prev_balance) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.ar_no = ar_no;
            this.date_added = date_added;
            this.user_name = user_name;
            this.amount = amount;
            this.discount_amount = discount_amount;
            this.discount_rate = discount_rate;
            this.discount = discount;
            this.status = status;
            this.term = term;
            this.date_applied = date_applied;
            this.paid = paid;
            this.date_paid = date_paid;
            this.remarks = remarks;
            this.type = type;
            this.or_no = or_no;
            this.prev_balance = prev_balance;
        }
    }

    public static void add_accounts_receivable_payments(to_accounts_receivable_payments to_accounts_receivable_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  accounts_payable_payments("
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
                    + ")";

            s0 = SqlStringUtil.parse(s0).
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
                    setNumber("paid", to_accounts_receivable_payments.prev_balance).
                    setNumber("prev_balance", to_accounts_receivable_payments.prev_balance).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_payable_payments.class, "Successfully Added");
            S1_suppliers.to_suppliers cus = ret_customer_balance(to_accounts_receivable_payments.customer_id);
            double new_balance = cus.balance - to_accounts_receivable_payments.amount;
//            JOptionPane.showMessageDialog(null, cus.balance + " "+to_accounts_receivable_payments.amount);
            
            String s2 = "update  suppliers set "
                    + "balance= :balance"
                    + " where "
                    + " customer_no ='" + to_accounts_receivable_payments.customer_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2).
                    setNumber("balance", new_balance).
                    ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static S1_suppliers.to_suppliers ret_customer_balance(String account_id) {
        S1_suppliers.to_suppliers to1 = null;

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
                    + " from  suppliers where "
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

                to1 = new S1_suppliers.to_suppliers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_accounts_receivable_payments(to_accounts_receivable_payments to_accounts_receivable_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  accounts_payable_payments set "
                    + "customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",ar_no= :ar_no"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",amount= :amount"
                    + ",discount_amount= :discount_amount"
                    + ",discount_rate= :discount_rate"
                    + ",discount= :discount"
                    + ",status= :status"
                    + ",term= :term"
                    + ",date_applied= :date_applied"
                    + ",paid= :paid"
                    + ",date_paid= :date_paid"
                    + ",remarks= :remarks"
                    + ",type= :type"
                    + ",or_no= :or_no"
                    + " where "
                    + " id ='" + to_accounts_receivable_payments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
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
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_payable_payments.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_accounts_receivable_payments(to_accounts_receivable_payments to_accounts_receivable_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  accounts_payable_payments where "
                    + " id ='" + to_accounts_receivable_payments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_payable_payments.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_accounts_receivable_payments> ret_data(String search) {
        List<to_accounts_receivable_payments> datas = new ArrayList();

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
                    + ",prev_balance"
                    + " from  accounts_payable_payments where "
                    + " ar_no ='" + search + "' "
                    + " ";
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
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                double prev_balance = rs.getDouble(19);
                to_accounts_receivable_payments to = new to_accounts_receivable_payments(id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
