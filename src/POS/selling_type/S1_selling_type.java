/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.selling_type;

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
 * @author Ronald
 */
public class S1_selling_type {

    public static class to_selling_type {

        public final int id;
        public final String name;

        public to_selling_type(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void add_selling_type(to_selling_type to_selling_type) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into selling_type("
                    + "name"
                    + ")values("
                    + ":name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("name", to_selling_type.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_selling_type.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_selling_type(to_selling_type to_selling_type) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update selling_type set "
                    + "name= :name"
                    + " where "
                    + " id ='" + to_selling_type.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("name", to_selling_type.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_selling_type.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_selling_type(to_selling_type to_selling_type) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from selling_type where "
                    + " id ='" + to_selling_type.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_selling_type.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_selling_type> ret_data(String search) {
        List<to_selling_type> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + " from selling_type where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                to_selling_type to = new to_selling_type(id, name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_data2(String search) {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + " from selling_type where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                datas.add(name);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        to_selling_type to1 = new to_selling_type(1, "Regular");
        to_selling_type to2 = new to_selling_type(2, "Assemble");
        add_selling_type(to1);
        add_selling_type(to2);

    }
}
