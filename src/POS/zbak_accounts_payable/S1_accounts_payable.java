/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.zbak_accounts_payable;

import POS.main.Main;
import POS.main.Main.MyDB;
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
public class S1_accounts_payable {

    public static class to_accounts_payable {
        public boolean selected;
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
        public final int row;
        public final double remaining_balance;
        public final int ap_main;
        

        public to_accounts_payable(boolean selected,int id, String customer_id, String customer_name, String ar_no, String date_added, String user_name, double amount
                , double discount_amount, double discount_rate, String discount, int status, double term, String date_applied, double paid, String date_paid, String remarks
                , String type, String or_no,int row,double remaining_balance,int ap_main) {
            this.selected=selected;
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
            this.row=row;
            this.remaining_balance=remaining_balance;
            this.ap_main=ap_main;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
        
    }

    public static void add_accounts_receivable(to_accounts_payable to_accounts_receivable) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  accounts_payable("
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
                    + ")";

            s0 = SqlStringUtil.parse(s0).
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
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_payable.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_accounts_receivable(to_accounts_payable to_accounts_receivable) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  accounts_payable set "
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
                    + " where "
                    + " id ='" + to_accounts_receivable.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
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
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_payable.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_accounts_receivable(to_accounts_payable to_accounts_receivable) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  accounts_payable where "
                    + " id ='" + to_accounts_receivable.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_accounts_payable.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_accounts_payable> ret_data(String cust_id) {
        List<to_accounts_payable> datas = new ArrayList();

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
                    + " from  accounts_payable where "
                    + " customer_id ='" + cust_id + "' "
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
                
                int row=1;
                String s2 = "select "
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
                        + " from  accounts_payable_payments where "
                        + " ar_no ='" + ar_no + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                double prev_balance = amount;
                List<to_accounts_payable> datas2 = new ArrayList();
                while (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    String customer_id2 = rs2.getString(2);
                    String customer_name2 = rs2.getString(3);
                    String ar_no2 = rs2.getString(4);
                    String date_added2 = rs2.getString(5);
                    String user_name2 = rs2.getString(6);
                    double amount2 = rs2.getDouble(7);
                    double discount_amount2 = rs2.getDouble(8);
                    double discount_rate2 = rs2.getDouble(9);
                    String discount2 = rs2.getString(10);
                    int status2 = rs2.getInt(11);
                    double term2 = rs2.getDouble(12);
                    String date_applied2 = rs2.getString(13);
                    double paid2 = rs2.getDouble(14);
                    String date_paid2 = rs2.getString(15);
                    String remarks2 = rs2.getString(16);
                    String type2 = rs2.getString(17);
                    String or_no2 = rs2.getString(18);
                    prev_balance -= amount2;
                    to_accounts_payable to2 = new to_accounts_payable(false,id2, customer_id2, customer_name2, ar_no2, date_added2, user_name2
                            , amount2, discount_amount2, discount_rate2, discount2, status2, term2, date_applied2, prev_balance, date_paid2
                            , remarks2, type2, or_no2,row,prev_balance,0);
                    datas2.add(to2);
                    row++;
                }
              
               to_accounts_payable to = new to_accounts_payable(false,id, customer_id, customer_name, ar_no, date_added, user_name
                        , amount, discount_amount, discount_rate, discount, status, term, date_applied, prev_balance, date_paid, remarks, type, or_no,-1,prev_balance,1);
               datas.add(to);
               datas.addAll(datas2);
                
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "AR-00000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from  accounts_payable";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "AR-00000001";
            } else {
                String s2 = "select ar_no from  accounts_payable where id='" + ids + "'";
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
