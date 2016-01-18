/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

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
 * @author Ronald
 */
public class S1_inventory_classification {

    public static class to_inventory_classification {

        public final int id;
        public final String category_code;
        public final String category;
        public final String code;
        public final String name;
        public final double markup_percent;

        public to_inventory_classification(int id, String category_code, String category, String code, String name, double markup_percent) {
            this.id = id;
            this.category_code = category_code;
            this.category = category;
            this.code = code;
            this.name = name;
            this.markup_percent = markup_percent;
        }
    }

    public static void add_inventory_classification(to_inventory_classification to_inventory_classification) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_classification("
                    + "category_code"
                    + ",category"
                    + ",code"
                    + ",name"
                    + ",markup_percent"
                    + ")values("
                    + ":category_code"
                    + ",:category"
                    + ",:code"
                    + ",:name"
                    + ",:markup_percent"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("category_code", to_inventory_classification.category_code).
                    setString("category", to_inventory_classification.category).
                    setString("code", to_inventory_classification.code).
                    setString("name", to_inventory_classification.name).
                    setNumber("markup_percent", to_inventory_classification.markup_percent).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_classification.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_classification(to_inventory_classification to_inventory_classification) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_classification set "
                    + "category_code= :category_code"
                    + ",category= :category"
                    + ",code= :code"
                    + ",name= :name"
                    + ",markup_percent= :markup_percent"
                    + " where "
                    + " id ='" + to_inventory_classification.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("category_code", to_inventory_classification.category_code).
                    setString("category", to_inventory_classification.category).
                    setString("code", to_inventory_classification.code).
                    setString("name", to_inventory_classification.name).
                    setNumber("markup_percent", to_inventory_classification.markup_percent).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_classification.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_classification(to_inventory_classification to_inventory_classification) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_classification where "
                    + " id ='" + to_inventory_classification.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_classification.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_classification> ret_data(String cat, String class_name) {
        List<to_inventory_classification> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_code"
                    + ",category"
                    + ",code"
                    + ",name"
                    + ",markup_percent"
                    + " from inventory_classification where "
                    + " category_code like '%" + cat + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_code = rs.getString(2);
                String category = rs.getString(3);
                String code = rs.getString(4);
                String name = rs.getString(5);
                double markup_percent = rs.getDouble(6);

                to_inventory_classification to = new to_inventory_classification(id, category_code, category, code, name, markup_percent);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_classification> ret_data3(String cat, String class_name) {
        List<to_inventory_classification> datas = new ArrayList();
        to_inventory_classification to2 = new to_inventory_classification(0, "", "", "", "", 0);
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_code"
                    + ",category"
                    + ",code"
                    + ",name"
                    + ",markup_percent"
                    + " from inventory_classification where "
                    + " category_code like '%" + cat + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_code = rs.getString(2);
                String category = rs.getString(3);
                String code = rs.getString(4);
                String name = rs.getString(5);
                double markup_percent = rs.getDouble(6);

                to_inventory_classification to = new to_inventory_classification(id, category_code, category, code, name, markup_percent);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_classification> ret_where(String where) {
        List<to_inventory_classification> datas = new ArrayList();
        to_inventory_classification to2 = new to_inventory_classification(0, "", "", "", "", 0);
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_code"
                    + ",category"
                    + ",code"
                    + ",name"
                    + ",markup_percent"
                    + " from inventory_classification  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_code = rs.getString(2);
                String category = rs.getString(3);
                String code = rs.getString(4);
                String name = rs.getString(5);
                double markup_percent = rs.getDouble(6);

                to_inventory_classification to = new to_inventory_classification(id, category_code, category, code, name, markup_percent);
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
        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "category_code"
                    + ",code"
                    + ",name"
                    + ",markup_percent"
                    + " from pisps_dbo.class where "
                    + " name like'%" + "" + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String category_code = rs.getString(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                double markup_percent = rs.getDouble(4);

                to_inventory_classification to = new to_inventory_classification(1, category_code, category_code, code, name, markup_percent);
                add_inventory_classification(to);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
