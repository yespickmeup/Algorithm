/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.suppliers;

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
public class Supplier_departments {

    public static class to_supplier_departments {

        public final int id;
        public final String department;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;

        public to_supplier_departments(int id, String department, String created_at, String updated_at, String created_by, String updated_by) {
            this.id = id;
            this.department = department;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
        }
    }

    public static void add_data(to_supplier_departments to_supplier_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into supplier_departments("
                    + "department"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ")values("
                    + ":department"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("department", to_supplier_departments.department)
                    .setString("created_at", to_supplier_departments.created_at)
                    .setString("updated_at", to_supplier_departments.updated_at)
                    .setString("created_by", to_supplier_departments.created_by)
                    .setString("updated_by", to_supplier_departments.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Supplier_departments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_supplier_departments to_supplier_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update supplier_departments set "
                    + "department= :department "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + " where id='" + to_supplier_departments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("department", to_supplier_departments.department)
                    .setString("created_at", to_supplier_departments.created_at)
                    .setString("updated_at", to_supplier_departments.updated_at)
                    .setString("created_by", to_supplier_departments.created_by)
                    .setString("updated_by", to_supplier_departments.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Supplier_departments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_supplier_departments to_supplier_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from supplier_departments  "
                    + " where id='" + to_supplier_departments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Supplier_departments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_supplier_departments> ret_data(String where) {
        List<to_supplier_departments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",department"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + " from supplier_departments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String department = rs.getString(2);
                String created_at = rs.getString(3);
                String updated_at = rs.getString(4);
                String created_by = rs.getString(5);
                String updated_by = rs.getString(6);

                to_supplier_departments to = new to_supplier_departments(id, department, created_at, updated_at, created_by, updated_by);
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
