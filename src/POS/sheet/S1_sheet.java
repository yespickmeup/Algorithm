/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sheet;

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
public class S1_sheet {

    public static class to_sheet {

        public final int id;
        public final int no;

        public to_sheet(int id, int no) {
            this.id = id;
            this.no = no;
        }
    }

    public static void add_sheet(to_sheet to_sheet) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sheet("
                    + "no"
                    + ")values("
                    + ":no"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("no", to_sheet.no).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sheet.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sheet(to_sheet to_sheet) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sheet set "
                    + "no= :no"
                    + " where "
                    + " id ='" + to_sheet.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("no", to_sheet.no).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sheet.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sheet(to_sheet to_sheet) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sheet where "
                    + " id ='" + to_sheet.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sheet.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sheet> ret_data(String search) {
        List<to_sheet> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",no"
                    + " from sheet where "
                    + " no like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int no = rs.getInt(2);

                to_sheet to = new to_sheet(id, no);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main2(String[] args) {
        for (int i = 20; i < 100; i++) {
            to_sheet t = new to_sheet(0, i);
            add_sheet(t);
        }
    }

    public static to_sheet ret_if_exists(String search) {
        to_sheet to1 = new to_sheet(-1,0);

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",no"
                    + " from sheet where "
                    + " no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int no = rs.getInt(2);

                to1 = new to_sheet(id, no);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
