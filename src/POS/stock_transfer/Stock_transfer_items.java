/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import POS.inventory.S1_items2;
import POS.main.Main.MyDB;
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
 * @author Maytopacka
 */
public class Stock_transfer_items {

    public static class to_receipt_items {

        public final int id;
        public final String receipt_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double cost;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        
        public to_receipt_items(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id) {
            this.id = id;
            this.receipt_no = receipt_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
        }
    }

    public static void add_receipt_items(List<Stock_transfer_items.to_receipt_items> to_receipt_items1, String receipt_nos) {
        try {
            Connection conn = MyConnection.connect();
            for (to_receipt_items to_receipt_items : to_receipt_items1) {
                String s0 = "insert into  stock_transfer_items("
                        + "receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supllier_id"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ")values("
                        + ":receipt_no"
                        + ",:user_name"
                        + ",:session_no"
                        + ",:date_added"
                        + ",:supplier"
                        + ",:supllier_id"
                        + ",:remarks"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:cost"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("receipt_no", receipt_nos).
                        setString("user_name", to_receipt_items.user_name).
                        setString("session_no", to_receipt_items.session_no).
                        setString("date_added", to_receipt_items.date_added).
                        setString("supplier", to_receipt_items.supplier).
                        setString("supllier_id", to_receipt_items.supllier_id).
                        setString("remarks", to_receipt_items.remarks).
                        setString("barcode", to_receipt_items.barcode).
                        setString("description", to_receipt_items.description).
                        setNumber("qty", to_receipt_items.qty).
                        setNumber("cost", to_receipt_items.cost).
                        setString("category", to_receipt_items.category).
                        setString("category_id", to_receipt_items.category_id).
                        setString("classification", to_receipt_items.classification).
                        setString("classification_id", to_receipt_items.classification_id).
                        setString("sub_class", to_receipt_items.sub_class).
                        setString("sub_class_id", to_receipt_items.sub_class_id).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Stock_transfer_items.class, "Successfully Added");
                S1_items2.to_items tt = S1_items2.ret_data2(to_receipt_items.barcode);
                double new_qty = tt.product_qty - to_receipt_items.qty;
                String s2 = "update  items set "
                        + "product_qty='" + new_qty + "' "
                        + " where barcode = '" + to_receipt_items.barcode + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  stock_transfer_items set "
                    + "receipt_no= '" + to_receipt_items.receipt_no + "'"
                    + ",user_name= '" + to_receipt_items.user_name + "'"
                    + ",session_no= '" + to_receipt_items.session_no + "'"
                    + ",date_added= '" + to_receipt_items.date_added + "'"
                    + ",supplier= '" + to_receipt_items.supplier + "'"
                    + ",supllier_id= '" + to_receipt_items.supllier_id + "'"
                    + ",remarks= '" + to_receipt_items.remarks + "'"
                    + ",barcode= '" + to_receipt_items.barcode + "'"
                    + ",description= '" + to_receipt_items.description + "'"
                    + ",qty= '" + to_receipt_items.qty + "'"
                    + ",cost= '" + to_receipt_items.cost + "'"
                    + ",category= '" + to_receipt_items.category + "'"
                    + ",category_id= '" + to_receipt_items.category_id + "'"
                    + ",classification= '" + to_receipt_items.classification + "'"
                    + ",classification_id= '" + to_receipt_items.classification_id + "'"
                    + ",sub_class= '" + to_receipt_items.sub_class + "'"
                    + ",sub_class_id= '" + to_receipt_items.sub_class_id + "'"
                    + "where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  stock_transfer_items where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items2(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  stock_transfer_items where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data(String search) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + " from  stock_transfer_items where "
                    + " receipt_no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
