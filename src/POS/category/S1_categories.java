/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category;

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
 * @author i1
 */
public class S1_categories {

    public static class to_categories {

        public final int id;
        public final String code;
        public final String name;

        public to_categories(int id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }
    }

    public static void add_categories(to_categories to_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into categories("
                    + "code"
                    + ",name"
                    + ")values("
                    + ":code"
                    + ",:name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_categories.code).
                    setString("name", to_categories.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_categories.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_categories(to_categories to_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update categories set "
                    + "code= :code"
                    + ",name= :name"
                    + " where "
                    + " id ='" + to_categories.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_categories.code).
                    setString("name", to_categories.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_categories.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_categories(to_categories to_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from categories where "
                    + " id ='" + to_categories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_categories.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_categories> ret_data(String search) {
        List<to_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",name"
                    + " from categories where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);

                to_categories to = new to_categories(id, code, name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        to_categories to1 = new to_categories(0, "BK", "Books");
        to_categories to2 = new to_categories(0, "COMP", "Computers");
        to_categories to3 = new to_categories(0, "COMP_SET", "Computer Set");
        to_categories to4 = new to_categories(0, "OTH", "Others");
        to_categories to5 = new to_categories(0, "RPL", "Replacement Parts");
        add_categories(to1);
        add_categories(to2);
        add_categories(to3);
        add_categories(to4);
        add_categories(to5);

    }
}
