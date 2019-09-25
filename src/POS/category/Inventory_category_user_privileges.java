/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Ronescape
 */
public class Inventory_category_user_privileges {

    public static class to_inventory_category_user_privileges {

        public final int id;
        public final String created_by;
        public final String created_at;
        public final String category;
        public final String category_id;
        public final int category_all;
        public final String classification;
        public final String classification_id;
        public final int classification_all;
        public final String sub_classification;
        public final String sub_classification_id;
        public final int sub_classification_all;
        public final String brand;
        public final String brand_id;
        public final int brand_all;
        public final String model;
        public final String model_id;
        public final int model_all;
        public final String user_id;
        public final String user_name;

        public to_inventory_category_user_privileges(int id, String created_by, String created_at, String category, String category_id, int category_all, String classification, String classification_id, int classification_all, String sub_classification, String sub_classification_id, int sub_classification_all, String brand, String brand_id, int brand_all, String model, String model_id, int model_all, String user_id,
                String user_name) {
            this.id = id;
            this.created_by = created_by;
            this.created_at = created_at;
            this.category = category;
            this.category_id = category_id;
            this.category_all = category_all;
            this.classification = classification;
            this.classification_id = classification_id;
            this.classification_all = classification_all;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.sub_classification_all = sub_classification_all;
            this.brand = brand;
            this.brand_id = brand_id;
            this.brand_all = brand_all;
            this.model = model;
            this.model_id = model_id;
            this.model_all = model_all;
            this.user_id = user_id;
            this.user_name = user_name;
        }
    }

    public static void add_data(to_inventory_category_user_privileges to_inventory_category_user_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_category_user_privileges("
                    + "created_by"
                    + ",created_at"
                    + ",category"
                    + ",category_id"
                    + ",category_all"
                    + ",classification"
                    + ",classification_id"
                    + ",classification_all"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",sub_classification_all"
                    + ",brand"
                    + ",brand_id"
                    + ",brand_all"
                    + ",user_id"
                    + ",user_name"
                    + ",model"
                    + ",model_id"
                    + ",model_all"
                    + ")values("
                    + ":created_by"
                    + ",:created_at"
                    + ",:category"
                    + ",:category_id"
                    + ",:category_all"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:classification_all"
                    + ",:sub_classification"
                    + ",:sub_classification_id"
                    + ",:sub_classification_all"
                    + ",:brand"
                    + ",:brand_id"
                    + ",:brand_all"
                    + ",:user_id"
                    + ",:user_name"
                    + ",:model"
                    + ",:model_id"
                    + ",:model_all"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("created_by", to_inventory_category_user_privileges.created_by)
                    .setString("created_at", to_inventory_category_user_privileges.created_at)
                    .setString("category", to_inventory_category_user_privileges.category)
                    .setString("category_id", to_inventory_category_user_privileges.category_id)
                    .setNumber("category_all", to_inventory_category_user_privileges.category_all)
                    .setString("classification", to_inventory_category_user_privileges.classification)
                    .setString("classification_id", to_inventory_category_user_privileges.classification_id)
                    .setNumber("classification_all", to_inventory_category_user_privileges.classification_all)
                    .setString("sub_classification", to_inventory_category_user_privileges.sub_classification)
                    .setString("sub_classification_id", to_inventory_category_user_privileges.sub_classification_id)
                    .setNumber("sub_classification_all", to_inventory_category_user_privileges.sub_classification_all)
                    .setString("brand", to_inventory_category_user_privileges.brand)
                    .setString("brand_id", to_inventory_category_user_privileges.brand_id)
                    .setNumber("brand_all", to_inventory_category_user_privileges.brand_all)
                    .setString("model", to_inventory_category_user_privileges.model)
                    .setString("model_id", to_inventory_category_user_privileges.model_id)
                    .setNumber("model_all", to_inventory_category_user_privileges.model_all)
                    .setString("user_id", to_inventory_category_user_privileges.user_id)
                    .setString("user_name", to_inventory_category_user_privileges.user_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_category_user_privileges.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_inventory_category_user_privileges to_inventory_category_user_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_category_user_privileges set "
                    + "category= :category "
                    + ",category_id= :category_id "
                    + ",category_all= :category_all "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",classification_all= :classification_all "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",sub_classification_all= :sub_classification_all "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",brand_all= :brand_all "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",model_all= :model_all "
                    + " where id='" + to_inventory_category_user_privileges.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("category", to_inventory_category_user_privileges.category)
                    .setString("category_id", to_inventory_category_user_privileges.category_id)
                    .setNumber("category_all", to_inventory_category_user_privileges.category_all)
                    .setString("classification", to_inventory_category_user_privileges.classification)
                    .setString("classification_id", to_inventory_category_user_privileges.classification_id)
                    .setNumber("classification_all", to_inventory_category_user_privileges.classification_all)
                    .setString("sub_classification", to_inventory_category_user_privileges.sub_classification)
                    .setString("sub_classification_id", to_inventory_category_user_privileges.sub_classification_id)
                    .setNumber("sub_classification_all", to_inventory_category_user_privileges.sub_classification_all)
                    .setString("brand", to_inventory_category_user_privileges.brand)
                    .setString("brand_id", to_inventory_category_user_privileges.brand_id)
                    .setNumber("brand_all", to_inventory_category_user_privileges.brand_all)
                    .setString("model", to_inventory_category_user_privileges.model)
                    .setString("model_id", to_inventory_category_user_privileges.model_id)
                    .setNumber("model_all", to_inventory_category_user_privileges.model_all)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_category_user_privileges.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_inventory_category_user_privileges to_inventory_category_user_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_category_user_privileges  "
                    + " where id='" + to_inventory_category_user_privileges.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_category_user_privileges.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_category_user_privileges> ret_data(String where) {
        List<to_inventory_category_user_privileges> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",created_by"
                    + ",created_at"
                    + ",category"
                    + ",category_id"
                    + ",category_all"
                    + ",classification"
                    + ",classification_id"
                    + ",classification_all"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",sub_classification_all"
                    + ",brand"
                    + ",brand_id"
                    + ",brand_all"
                    + ",model"
                    + ",model_id"
                    + ",model_all"
                    + ",user_id"
                    + ",user_name"
                    + " from inventory_category_user_privileges"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String created_by = rs.getString(2);
                String created_at = rs.getString(3);
                String category = rs.getString(4);
                String category_id = rs.getString(5);
                int category_all = rs.getInt(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                int classification_all = rs.getInt(9);
                String sub_classification = rs.getString(10);
                String sub_classification_id = rs.getString(11);
                int sub_classification_all = rs.getInt(12);
                String brand = rs.getString(13);
                String brand_id = rs.getString(14);
                int brand_all = rs.getInt(15);
                String model = rs.getString(16);
                String model_id = rs.getString(17);
                int model_all = rs.getInt(18);
                String user_id = rs.getString(19);
                String user_name = rs.getString(20);

                to_inventory_category_user_privileges to = new to_inventory_category_user_privileges(id, created_by, created_at, category, category_id, category_all,
                                                                                                     classification, classification_id, classification_all, sub_classification, sub_classification_id, sub_classification_all, brand, brand_id,
                                                                                                     brand_all, model, model_id, model_all, user_id, user_name);
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
