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
public class S1_inventory_categories {

    public static class to_inventory_category {

        public final int id;
        public final String name;
        public final String code;

        public to_inventory_category(int id, String name, String code) {
            this.id = id;
            this.name = name;
            this.code = code;
        }
    }

    public static void add_inventory_category(to_inventory_category to_inventory_category) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_category("
                    + "name"
                    + ",code"
                    + ")values("
                    + ":name"
                    + ",:code"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("name", to_inventory_category.name).
                    setString("code", to_inventory_category.code).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_categories.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_inventory_category2(List<to_inventory_category> to_inventory_category1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory_category to_inventory_category : to_inventory_category1) {
                String s0 = "insert into inventory_category("
                        + "name"
                        + ",code"
                        + ")values("
                        + ":name"
                        + ",:code"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("name", to_inventory_category.name).
                        setString("code", to_inventory_category.code).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_inventory_categories.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_category(to_inventory_category to_inventory_category) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_category set "
                    + "name= :name"
                    + ",code= :code"
                    + " where "
                    + " id ='" + to_inventory_category.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("name", to_inventory_category.name).
                    setString("code", to_inventory_category.code).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_categories.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_category2(to_inventory_category to_inventory_category) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory set "
                    + " category_id= :category_id"
                    + " where "
                    + " id ='" + to_inventory_category.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("name", to_inventory_category.name).
                    setString("code", to_inventory_category.code).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_categories.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_category(to_inventory_category to_inventory_category) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_category where "
                    + " id ='" + to_inventory_category.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_categories.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_category> ret_data(String search) {
        List<to_inventory_category> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",code"
                    + " from inventory_category where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String code = rs.getString(3);

                to_inventory_category to = new to_inventory_category(id, name, code);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_category> ret_data3(String search) {
        List<to_inventory_category> datas = new ArrayList();
        to_inventory_category to2 = new to_inventory_category(0, "", "");
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",code"
                    + " from inventory_category where "
                    + " name like'%" + search + "%' "
                    + " order by name asc ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String code = rs.getString(3);

                to_inventory_category to = new to_inventory_category(id, name, code);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_category {

        public final String code;
        public final String name;

        public to_category(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    public static List<to_category> ret_data2(String search) {
        List<to_category> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "code"
                    + ",name"
                    + " from pisps_dbo.category where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);

                to_category to = new to_category(code, name);
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
        List<to_category> datas = ret_data2("");
        for (to_category to : datas) {
            to_inventory_category t = new to_inventory_category(1, to.name, to.code);
            add_inventory_category(t);
        }
    }

}
