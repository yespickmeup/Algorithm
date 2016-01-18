/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales_order_items;

import POS.main.Main.MyDB;
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
 * @author Maytopacka
 */
public class S1_sales_order_items {

    public static class to_sales_order_items {

        public final int id;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String session_no;
        public final String item_discount;
        public final double discount;
        public final double discount_amount;
        public final String sales_no;
        public final int fixed_price;
        public final String supplier;
        public final String supplier_id;
        public final int vatable;
        public final String sales_order_no;
        public final String customer_name;
        public final String customer_no;

        public to_sales_order_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String session_no, String item_discount, double discount, double discount_amount, String sales_no, int fixed_price, String supplier, String supplier_id, int vatable, String sales_order_no, String customer_name, String customer_no) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.session_no = session_no;
            this.item_discount = item_discount;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.sales_no = sales_no;
            this.fixed_price = fixed_price;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.vatable = vatable;
            this.sales_order_no = sales_order_no;
            this.customer_name = customer_name;
            this.customer_no = customer_no;
        }
    }

    public static void add_sales_order_items(List<to_sales_order_items> to_sales_order_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_sales_order_items to_sales_order_items : to_sales_order_items1) {


                String s0 = "insert into  sales_order_items("
                        + "barcode"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",item_type"
                        + ",status"
                        + ",session_no"
                        + ",item_discount"
                        + ",discount"
                        + ",discount_amount"
                        + ",sales_no"
                        + ",fixed_price"
                        + ",supplier"
                        + ",supplier_id"
                        + ",vatable"
                        + ",sales_order_no"
                        + ",customer_name"
                        + ",customer_no"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:session_no"
                        + ",:item_discount"
                        + ",:discount"
                        + ",:discount_amount"
                        + ",:sales_no"
                        + ",:fixed_price"
                        + ",:supplier"
                        + ",:supplier_id"
                        + ",:vatable"
                        + ",:sales_order_no"
                        + ",:customer_name"
                        + ",:customer_no"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("barcode", to_sales_order_items.barcode).
                        setString("description", to_sales_order_items.description).
                        setString("generic_name", to_sales_order_items.generic_name).
                        setString("category", to_sales_order_items.category).
                        setString("category_id", to_sales_order_items.category_id).
                        setString("classification", to_sales_order_items.classification).
                        setString("classification_id", to_sales_order_items.classification_id).
                        setString("sub_classification", to_sales_order_items.sub_classification).
                        setString("sub_classification_id", to_sales_order_items.sub_classification_id).
                        setNumber("product_qty", to_sales_order_items.product_qty).
                        setString("unit", to_sales_order_items.unit).
                        setNumber("conversion", to_sales_order_items.conversion).
                        setNumber("selling_price", to_sales_order_items.selling_price).
                        setString("date_added", to_sales_order_items.date_added).
                        setString("user_name", to_sales_order_items.user_name).
                        setString("item_type", to_sales_order_items.item_type).
                        setNumber("status", to_sales_order_items.status).
                        setString("session_no", to_sales_order_items.session_no).
                        setString("item_discount", to_sales_order_items.item_discount).
                        setNumber("discount", to_sales_order_items.discount).
                        setNumber("discount_amount", to_sales_order_items.discount_amount).
                        setString("sales_no", to_sales_order_items.sales_no).
                        setNumber("fixed_price", to_sales_order_items.fixed_price).
                        setString("supplier", to_sales_order_items.supplier).
                        setString("supplier_id", to_sales_order_items.supplier_id).
                        setNumber("vatable", to_sales_order_items.vatable).
                        setString("sales_order_no", to_sales_order_items.sales_order_no).
                        setString("customer_name", to_sales_order_items.customer_name).
                        setString("customer_no", to_sales_order_items.customer_no).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_sales_order_items.class, "Successfully Added");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sales_order_items(List<to_sales_order_items> to_sales_order_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_sales_order_items to_sales_order_items : to_sales_order_items1) {


                String s0 = "update  sales_order_items set "                      
                        + "product_qty= :product_qty"                     
                        + ",item_discount= :item_discount"
                        + ",discount= :discount"
                        + ",discount_amount= :discount_amount"                       
                        + " where "
                        + " id ='" + to_sales_order_items.id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0).                
                        setNumber("product_qty", to_sales_order_items.product_qty).             
                        setString("item_discount", to_sales_order_items.item_discount).
                        setNumber("discount", to_sales_order_items.discount).
                        setNumber("discount_amount", to_sales_order_items.discount_amount).                      
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_sales_order_items.class, "Successfully Updated");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales_order_items(to_sales_order_items to_sales_order_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  sales_order_items where "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_order_items.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_order_items> ret_data(String search) {
        List<to_sales_order_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",sales_order_no"
                     + ",customer_name"
                     + ",customer_no"
                    + " from  sales_order_items where "
                    + " sales_order_no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String sales_order_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_no = rs.getString(30);

                to_sales_order_items to = new to_sales_order_items(id, barcode, description, generic_name, category, category_id
                        , classification, classification_id, sub_classification, sub_classification_id, product_qty, unit
                        , conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount
                        , discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable
                        , sales_order_no,customer_name,customer_no);
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
