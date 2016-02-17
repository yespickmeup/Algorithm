/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.scripts;

import POS.gson.GSON_sample;
import POS.util.MyConnection;
import com.google.gson.Gson;
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
public class Main_branch_query_uploads {

    public static class to_main_branch_query_uploads {

        public final int id;
        public final String branch_query;
        public final String query_module;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String date_added;
        public final int status;

        public to_main_branch_query_uploads(int id, String branch_query, String query_module, String branch, String branch_id, String location, String location_id, String date_added, int status) {
            this.id = id;
            this.branch_query = branch_query;
            this.query_module = query_module;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.date_added = date_added;
            this.status = status;
        }
    }

    public static void add_data(to_main_branch_query_uploads to_main_branch_query_uploads) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into main_branch_query_uploads("
                    + "branch_query"
                    + ",query_module"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",date_added"
                    + ",status"
                    + ")values("
                    + ":branch_query"
                    + ",:query_module"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:date_added"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("branch_query", to_main_branch_query_uploads.branch_query)
                    .setString("query_module", to_main_branch_query_uploads.query_module)
                    .setString("branch", to_main_branch_query_uploads.branch)
                    .setString("branch_id", to_main_branch_query_uploads.branch_id)
                    .setString("location", to_main_branch_query_uploads.location)
                    .setString("location_id", to_main_branch_query_uploads.location_id)
                    .setString("date_added", to_main_branch_query_uploads.date_added)
                    .setNumber("status", to_main_branch_query_uploads.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Main_branch_query_uploads.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_main_branch_query_uploads to_main_branch_query_uploads) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update main_branch_query_uploads set "
                    + "branch_query= :branch_query "
                    + ",query_module= :query_module "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",date_added= :date_added "
                    + ",status= :status "
                    + " where id='" + to_main_branch_query_uploads.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("branch_query", to_main_branch_query_uploads.branch_query)
                    .setString("query_module", to_main_branch_query_uploads.query_module)
                    .setString("branch", to_main_branch_query_uploads.branch)
                    .setString("branch_id", to_main_branch_query_uploads.branch_id)
                    .setString("location", to_main_branch_query_uploads.location)
                    .setString("location_id", to_main_branch_query_uploads.location_id)
                    .setString("date_added", to_main_branch_query_uploads.date_added)
                    .setNumber("status", to_main_branch_query_uploads.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Main_branch_query_uploads.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_main_branch_query_uploads to_main_branch_query_uploads) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from main_branch_query_uploads  "
                    + " where id='" + to_main_branch_query_uploads.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Main_branch_query_uploads.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<to_main_branch_query_uploads> datas = ret_data("");
        List<String> query = new ArrayList();
        Gson gson = new Gson();
        for (to_main_branch_query_uploads to : datas) {
            List<String> qu = gson.fromJson(to.branch_query, List.class);
            for (String q : qu) {
                System.out.println(q);
            }
        }
    }

    public static List<to_main_branch_query_uploads> ret_data(String where) {
        List<to_main_branch_query_uploads> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch_query"
                    + ",query_module"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",date_added"
                    + ",status"
                    + " from main_branch_query_uploads"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch_query = rs.getString(2);

                String query_module = rs.getString(3);
                String branch = rs.getString(4);
                String branch_id = rs.getString(5);
                String location = rs.getString(6);
                String location_id = rs.getString(7);
                String date_added = rs.getString(8);
                int status = rs.getInt(9);

                to_main_branch_query_uploads to = new to_main_branch_query_uploads(id, branch_query, query_module, branch, branch_id, location, location_id, date_added, status);
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
