/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.withholding_tax;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_witholding_taxes {

    public static class to_witholding_taxes {

        public final int id;
        public final String sector;
        public final double rate;

        public to_witholding_taxes(int id, String sector, double rate) {
            this.id = id;
            this.sector = sector;
            this.rate = rate;
        }
    }

    public static void add_witholding_tax(to_witholding_taxes to_witholding_tax) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into witholding_taxes("
                    + "sector"
                    + ",rate"
                    + ")values("
                    + ":sector"
                    + ",:rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sector", to_witholding_tax.sector)
                    .setNumber("rate", to_witholding_tax.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_witholding_taxes.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_witholding_tax(to_witholding_taxes to_witholding_tax) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update witholding_taxes set "
                    + "sector= :sector"
                    + ",rate= :rate"
                    + " where "
                    + " id ='" + to_witholding_tax.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sector", to_witholding_tax.sector)
                    .setNumber("rate", to_witholding_tax.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_witholding_taxes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_witholding_tax(to_witholding_taxes to_witholding_tax) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from witholding_taxes where "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_witholding_taxes.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_witholding_taxes> ret_data(String where) {
        List<to_witholding_taxes> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sector"
                    + ",rate"
                    + " from witholding_taxes  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sector = rs.getString(2);
                double rate = rs.getDouble(3);

                to_witholding_taxes to = new to_witholding_taxes(id, sector, rate);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
