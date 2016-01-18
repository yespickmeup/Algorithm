/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.payment_terms;

import POS.main.Main.MyDB;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_payment_terms {

    public static class to_payment_terms {

        public final int id;
        public final double days;

        public to_payment_terms(int id, double days) {
            this.id = id;
            this.days = days;
        }
    }

    public static void add_payment_terms(to_payment_terms to_payment_terms) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  payment_terms("
                    + "days"
                    + ")values("
                    + ":days"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("days", to_payment_terms.days).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_payment_terms.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_payment_terms(to_payment_terms to_payment_terms) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  payment_terms set "
                    + "days= :days"
                    + " where "
                    + " id ='" + to_payment_terms.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("days", to_payment_terms.days).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_payment_terms.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_payment_terms(to_payment_terms to_payment_terms) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  payment_terms where "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_payment_terms.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_payment_terms> ret_data(String search) {
        List<to_payment_terms> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",days"
                    + " from  payment_terms where "
                    + " days like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                double days = rs.getDouble(2);

                to_payment_terms to = new to_payment_terms(id, days);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select days from  payment_terms";
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
}
