/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipt_endorsements;

import POS.receipt_endorsements.Receipt_endorsement_items.to_receipt_endorsement_items;
import POS.users.MyUser;
import POS.util.DateType;
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
 * @author User
 */
public class Receipt_endorsements {

    public static class to_receipt_endorsements {

        public final int id;
        public final String endorsement_type;
        public final int endorsed_user_id;
        public final String endorsed_user_screen_name;
        public final String receipt_from;
        public final String receipt_to;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;

        public to_receipt_endorsements(int id, String endorsement_type, int endorsed_user_id, String endorsed_user_screen_name, String receipt_from, String receipt_to, String created_at, String updated_at, String created_by, String updated_by, int status) {
            this.id = id;
            this.endorsement_type = endorsement_type;
            this.endorsed_user_id = endorsed_user_id;
            this.endorsed_user_screen_name = endorsed_user_screen_name;
            this.receipt_from = receipt_from;
            this.receipt_to = receipt_to;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.status = status;
        }

    }

    public static void add_data(to_receipt_endorsements to_receipt_endorsements, List<String> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into receipt_endorsements("
                    + "endorsement_type"
                    + ",endorsed_user_id"
                    + ",endorsed_user_screen_name"
                    + ",receipt_from"
                    + ",receipt_to"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ")values("
                    + ":endorsement_type"
                    + ",:endorsed_user_id"
                    + ",:endorsed_user_screen_name"
                    + ",:receipt_from"
                    + ",:receipt_to"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("endorsement_type", to_receipt_endorsements.endorsement_type)
                    .setNumber("endorsed_user_id", to_receipt_endorsements.endorsed_user_id)
                    .setString("endorsed_user_screen_name", to_receipt_endorsements.endorsed_user_screen_name)
                    .setString("receipt_from", to_receipt_endorsements.receipt_from)
                    .setString("receipt_to", to_receipt_endorsements.receipt_to)
                    .setString("created_at", to_receipt_endorsements.created_at)
                    .setString("updated_at", to_receipt_endorsements.updated_at)
                    .setString("created_by", to_receipt_endorsements.created_by)
                    .setString("updated_by", to_receipt_endorsements.updated_by)
                    .setNumber("status", to_receipt_endorsements.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            int lastInsertId = 0;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lastInsertId = rs.getInt(1);
            }

            PreparedStatement stmt2 = conn.prepareStatement("");
            String last_item = "";
            for (String item : items) {
                last_item = item;
                String s2 = "insert into receipt_endorsement_items("
                        + "receipt_endorsement_id"
                        + ",endorsement_type"
                        + ",receipt_no"
                        + ",created_at"
                        + ",updated_at"
                        + ",created_by"
                        + ",updated_by"
                        + ",status"
                        + ")values("
                        + ":receipt_endorsement_id"
                        + ",:endorsement_type"
                        + ",:receipt_no"
                        + ",:created_at"
                        + ",:updated_at"
                        + ",:created_by"
                        + ",:updated_by"
                        + ",:status"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setNumber("receipt_endorsement_id", lastInsertId)
                        .setString("endorsement_type", to_receipt_endorsements.endorsement_type)
                        .setString("receipt_no", item)
                        .setString("created_at", DateType.now())
                        .setString("updated_at", DateType.now())
                        .setString("created_by", MyUser.getUser_id())
                        .setString("updated_by", MyUser.getUser_id())
                        .setNumber("status", 1)
                        .ok();
                stmt2.addBatch(s2);
            }

            String s3 = "update receipt_endorsements set "
                    + "receipt_to= :receipt_to "
                    + " where id='" + lastInsertId + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3)
                    .setString("receipt_to", last_item)
                    .ok();

            stmt2.addBatch(s3);
            stmt2.executeBatch();
            conn.commit();
            Lg
                    .s(Receipt_endorsements.class,
                       "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_receipt_endorsements to_receipt_endorsements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipt_endorsements set "
                    + "endorsement_type= :endorsement_type "
                    + ",receipt_from= :receipt_from "
                    + ",receipt_to= :receipt_to "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + " where id='" + to_receipt_endorsements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("endorsement_type", to_receipt_endorsements.endorsement_type)
                    .setString("receipt_from", to_receipt_endorsements.receipt_from)
                    .setString("receipt_to", to_receipt_endorsements.receipt_to)
                    .setString("created_at", to_receipt_endorsements.created_at)
                    .setString("updated_at", to_receipt_endorsements.updated_at)
                    .setString("created_by", to_receipt_endorsements.created_by)
                    .setString("updated_by", to_receipt_endorsements.updated_by)
                    .setNumber("status", to_receipt_endorsements.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg
                    .s(Receipt_endorsements.class,
                       "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_receipt_endorsements to_receipt_endorsements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
            String s0 = "delete from receipt_endorsements  "
                    + " where id='" + to_receipt_endorsements.id + "' "
                    + " ";

            stmt.addBatch(s0);

            String s2 = "delete from receipt_endorsement_items  "
                    + " where receipt_endorsement_id='" + to_receipt_endorsements.id + "' "
                    + " ";

            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Receipt_endorsements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_endorsements> ret_data(String where) {
        List<to_receipt_endorsements> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",endorsement_type"
                    + ",endorsed_user_id"
                    + ",endorsed_user_screen_name"
                    + ",receipt_from"
                    + ",receipt_to"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + " from receipt_endorsements"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String endorsement_type = rs.getString(2);
                int endorsed_user_id = rs.getInt(3);
                String endorsed_user_screen_name = rs.getString(4);
                String receipt_from = rs.getString(5);
                String receipt_to = rs.getString(6);
                String created_at = rs.getString(7);
                String updated_at = rs.getString(8);
                String created_by = rs.getString(9);
                String updated_by = rs.getString(10);
                int status = rs.getInt(11);

                to_receipt_endorsements to = new to_receipt_endorsements(id, endorsement_type, endorsed_user_id, endorsed_user_screen_name, receipt_from, receipt_to, created_at, updated_at, created_by, updated_by, status);
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
