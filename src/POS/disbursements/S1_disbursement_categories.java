/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

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
public class S1_disbursement_categories {

    public static class to_disbursement_categories {

        public final int id;
        public final String category_name;

        public to_disbursement_categories(int id, String category_name) {
            this.id = id;
            this.category_name = category_name;
        }
    }

    public static void add_data(to_disbursement_categories to_disbursement_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into disbursement_categories("
                    + "category_name"
                    + ")values("
                    + ":category_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("category_name", to_disbursement_categories.category_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_disbursement_categories.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_disbursement_categories to_disbursement_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update disbursement_categories set "
                    + "category_name= :category_name "
                    + " where id='" + to_disbursement_categories.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("category_name", to_disbursement_categories.category_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_disbursement_categories.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_disbursement_categories to_disbursement_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from disbursement_categories  "
                    + " where id='" + to_disbursement_categories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_disbursement_categories.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_disbursement_categories> ret_data(String where) {
        List<to_disbursement_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_name"
                    + " from disbursement_categories"
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_name = rs.getString(2);
                to_disbursement_categories to = new to_disbursement_categories(id, category_name);
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
