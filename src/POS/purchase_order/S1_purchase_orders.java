/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

import POS.zbak_accounts_payable.Accounts_payable;
import POS.accounts_receivable.S1_accounts_receivable;
import POS.main.Main;
import POS.main.Main.MyDB;
import POS.sales.Sales;
import POS.suppliers.S1_suppliers;
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
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_purchase_orders {

    public static class to_purchase_orders {

        public final int id;
        public final String po_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String remarks;
        public final String account_id;
        public final String account_name;
        public final double amount;

        public to_purchase_orders(int id, String po_no, String user_name, String session_no, String date_added, String remarks, String account_id, String account_name, double amount) {
            this.id = id;
            this.po_no = po_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.remarks = remarks;
            this.account_id = account_id;
            this.account_name = account_name;
            this.amount = amount;
        }
    }

    public static void add_purchase_orders(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  purchase_orders("
                    + "po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",remarks"
                    + ",account_id"
                    + ",account_name"
                    + ",amount"
                    + ")values("
                    + ":po_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:remarks"
                    + ",:account_id"
                    + ",:account_name"
                    + ",:amount"
                    + ")";
            s0 = SqlStringUtil.parse(s0).
                    setString("po_no", to_purchase_orders.po_no).
                    setString("user_name", to_purchase_orders.user_name).
                    setString("session_no", to_purchase_orders.session_no).
                    setString("date_added", to_purchase_orders.date_added).
                    setString("remarks", to_purchase_orders.remarks).
                    setString("account_id", to_purchase_orders.account_id).
                    setString("account_name", to_purchase_orders.account_name).
                    setNumber("amount", to_purchase_orders.amount).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_orders.class, "Successfully Added");

            System.out.println("Account Id: " + to_purchase_orders.account_id);
            S1_suppliers.to_suppliers cus = ret_customer_balance(to_purchase_orders.account_id);
            double new_balance = cus.balance + to_purchase_orders.amount;
            String s2 = "update  suppliers set "
                    + " balance= :balance"
                    + " where "
                    + " customer_no ='" + to_purchase_orders.account_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2).
                    setNumber("balance", new_balance).
                    ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(Sales.class, "Successfully Updated");

            String customer_id = to_purchase_orders.account_id;
            String customer_name = to_purchase_orders.account_name;
            String ar_no = S1_accounts_receivable.increment_id("");
            String date_added = DateType.datetime.format(new Date());
            String user_name = Users.user_name;
            double amount = to_purchase_orders.amount;
            double discount_amount = 0;
            double discount_rate = 0;
            String discount = "";
            int status = 0;
            double term = 0;
            String date_applied = DateType.sf.format(new Date());
            double paid = 0;
            String date_paid = DateType.sf.format(new Date());
            String remarks = "";
            String type = "RECEIPTS";
            String or_no = to_purchase_orders.po_no;
//            S1_accounts_payable.to_accounts_payable to = new S1_accounts_payable.to_accounts_payable(false,status, customer_id, customer_name, ar_no, date_added, user_name
//                    , amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no,0,0,0);
//            S1_accounts_payable.add_accounts_receivable(to);
        } catch (SQLException e) {
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
            System.out.println("S0: " + s0);
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_purchase_orders(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  purchase_orders set "
                    + "po_no= '" + to_purchase_orders.po_no + "'"
                    + ",user_name= '" + to_purchase_orders.user_name + "'"
                    + ",session_no= '" + to_purchase_orders.session_no + "'"
                    + ",date_added= '" + to_purchase_orders.date_added + "'"
                    + ",remarks= '" + to_purchase_orders.remarks + "'"
                    + ",account_id= '" + to_purchase_orders.account_id + "'"
                    + ",account_name= '" + to_purchase_orders.account_name + "'"
                    + ",amount= '" + to_purchase_orders.amount + "'"
                    + "where "
                    + " id ='" + to_purchase_orders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_orders.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_purchase_orders(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  purchase_orders where "
                    + " id ='" + to_purchase_orders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_orders.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_purchase_orders> ret_data(String date_from, String date_to) {
        List<to_purchase_orders> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",remarks"
                    + ",account_id"
                    + ",account_name"
                    + ",amount"
                    + " from  purchase_orders where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String po_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String remarks = rs.getString(6);
                String account_id = rs.getString(7);
                String account_name = rs.getString(8);
                double amount = rs.getDouble(9);
                to_purchase_orders to = new to_purchase_orders(id, po_no, user_name, session_no, date_added, remarks, account_id, account_name, amount);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_purchase_orders> ret_po_no(String search) {
        List<to_purchase_orders> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",remarks"
                    + ",account_id"
                    + ",account_name"
                    + ",amount"
                    + " from  purchase_orders where "
                    + " po_no like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String po_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String remarks = rs.getString(6);
                String account_id = rs.getString(7);
                String account_name = rs.getString(8);
                double amount = rs.getDouble(9);

                to_purchase_orders to = new to_purchase_orders(id, po_no, user_name, session_no, date_added, remarks, account_id, account_name, amount);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "PO-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from  purchase_orders";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "PO-00000000001";
            } else {
                String s2 = "select po_no from  purchase_orders where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }
            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
