/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipt_endorsements;

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
public class Receipt_endorsement_items {

    public static class to_receipt_endorsement_items {

        public final int id;
        public final int receipt_endorsement_id;
        public final String endorsement_type;
        public final String receipt_no;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;

        public to_receipt_endorsement_items(int id, int receipt_endorsement_id, String endorsement_type, String receipt_no, String created_at, String updated_at, String created_by, String updated_by, int status) {
            this.id = id;
            this.receipt_endorsement_id = receipt_endorsement_id;
            this.endorsement_type = endorsement_type;
            this.receipt_no = receipt_no;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.status = status;
        }
    }

    public static void add_data(to_receipt_endorsement_items to_receipt_endorsement_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into receipt_endorsement_items("
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

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("receipt_endorsement_id", to_receipt_endorsement_items.receipt_endorsement_id)
                    .setString("endorsement_type", to_receipt_endorsement_items.endorsement_type)
                    .setString("receipt_no", to_receipt_endorsement_items.receipt_no)
                    .setString("created_at", to_receipt_endorsement_items.created_at)
                    .setString("updated_at", to_receipt_endorsement_items.updated_at)
                    .setString("created_by", to_receipt_endorsement_items.created_by)
                    .setString("updated_by", to_receipt_endorsement_items.updated_by)
                    .setNumber("status", to_receipt_endorsement_items.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipt_endorsement_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_receipt_endorsement_items to_receipt_endorsement_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipt_endorsement_items set "
                    + "receipt_endorsement_id= :receipt_endorsement_id "
                    + ",endorsement_type= :endorsement_type "
                    + ",receipt_no= :receipt_no "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + " where id='" + to_receipt_endorsement_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("receipt_endorsement_id", to_receipt_endorsement_items.receipt_endorsement_id)
                    .setString("endorsement_type", to_receipt_endorsement_items.endorsement_type)
                    .setString("receipt_no", to_receipt_endorsement_items.receipt_no)
                    .setString("created_at", to_receipt_endorsement_items.created_at)
                    .setString("updated_at", to_receipt_endorsement_items.updated_at)
                    .setString("created_by", to_receipt_endorsement_items.created_by)
                    .setString("updated_by", to_receipt_endorsement_items.updated_by)
                    .setNumber("status", to_receipt_endorsement_items.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipt_endorsement_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_receipt_endorsement_items to_receipt_endorsement_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from receipt_endorsement_items  "
                    + " where id='" + to_receipt_endorsement_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipt_endorsement_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_endorsement_items> ret_data(String where) {
        List<to_receipt_endorsement_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_endorsement_id"
                    + ",endorsement_type"
                    + ",receipt_no"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + " from receipt_endorsement_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int receipt_endorsement_id = rs.getInt(2);
                String endorsement_type = rs.getString(3);
                String receipt_no = rs.getString(4);
                String created_at = rs.getString(5);
                String updated_at = rs.getString(6);
                String created_by = rs.getString(7);
                String updated_by = rs.getString(8);
                int status = rs.getInt(9);

                to_receipt_endorsement_items to = new to_receipt_endorsement_items(id, receipt_endorsement_id, endorsement_type, receipt_no, created_at, updated_at, created_by, updated_by, status);
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
