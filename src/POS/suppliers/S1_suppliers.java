/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.suppliers;

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
 * @author Maytopacka
 */
public class S1_suppliers {

    public static class to_suppliers {

        public final int id;
        public final String customer_name;
        public final String customer_no;
        public final String contact_no;
        public final double credit_limit;
        public final String address;
        public final double term;
        public final String location;
        public final double balance;
        public final double discount;

        public to_suppliers(int id, String customer_name, String customer_no, String contact_no, double credit_limit, String address, double term, String location, double balance, double discount) {
            this.id = id;
            this.customer_name = customer_name;
            this.customer_no = customer_no;
            this.contact_no = contact_no;
            this.credit_limit = credit_limit;
            this.address = address;
            this.term = term;
            this.location = location;
            this.balance = balance;
            this.discount = discount;
        }
    }

    public static void add_customers(to_suppliers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  suppliers("
                    + "customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ")values("
                    + ":customer_name"
                    + ",:customer_no"
                    + ",:contact_no"
                    + ",:credit_limit"
                    + ",:address"
                    + ",:term"
                    + ",:location"
                    + ",:balance"
                    + ",:discount"
                    + ")";
            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", to_customers.customer_name).
                    setString("customer_no", to_customers.customer_no).
                    setString("contact_no", to_customers.contact_no).
                    setNumber("credit_limit", to_customers.credit_limit).
                    setString("address", to_customers.address).
                    setNumber("term", to_customers.term).
                    setString("location", to_customers.location).
                    setNumber("balance", to_customers.balance).
                    setNumber("discount", to_customers.balance).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_customers(to_suppliers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  suppliers set "
                    + "customer_name= :customer_name"
                    + ",contact_no= :contact_no"
                    + ",credit_limit= :credit_limit"
                    + ",address= :address"
                    + ",term= :term"
                    + ",location= :location"
                    + ",discount= :discount"
                    + " where "
                    + " id ='" + to_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", to_customers.customer_name).
                    setString("contact_no", to_customers.contact_no).
                    setNumber("credit_limit", to_customers.credit_limit).
                    setString("address", to_customers.address).
                    setNumber("term", to_customers.term).
                    setString("location", to_customers.location).
                    setNumber("discount", to_customers.discount).
                    ok();
            System.out.println("" + to_customers.location);
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_customers(to_suppliers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  suppliers where "
                    + " id ='" + to_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_suppliers> ret_data(String search) {
        List<to_suppliers> datas = new ArrayList();

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
                    + " customer_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
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

                to_suppliers to = new to_suppliers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_suppliers> ret_data2(String where) {
        List<to_suppliers> datas = new ArrayList();

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
                    + " from  suppliers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
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

                to_suppliers to = new to_suppliers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();
        datas.add("");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select customer_name from  suppliers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "0000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from  suppliers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "0000";
            } else {
                String s2 = "select customer_no from  suppliers where id='" + ids + "'";
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
