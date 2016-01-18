/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.encoding_inventory.Encoding_inventory;
import POS.encoding_inventory.Encoding_inventory.to_encoding_inventory;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S3_inventory_update_cost {

    public static class to_item_uom {

        public final int item_code;
        public final String uom;
        public final String factor;
        public final String barcode;
        public final String last_purchase_price;
        public final String ave_purchase_price;
        public final String selling_price;

        public to_item_uom(int item_code, String uom, String factor, String barcode, String last_purchase_price, String ave_purchase_price, String selling_price) {
            this.item_code = item_code;
            this.uom = uom;
            this.factor = factor;
            this.barcode = barcode;
            this.last_purchase_price = last_purchase_price;
            this.ave_purchase_price = ave_purchase_price;
            this.selling_price = selling_price;
        }
    }

    public static List<to_item_uom> ret_data(String search) {
        List<to_item_uom> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            Connection conn3 = MyConnection.connect3();
            String s0 = "select "
                    + "item_code"                  
                    + ",ifnull(last_purchase_price,0)"
                    + ",ifnull(selling_price,0)"
                    + " from pisps_dbo.item_uom "                 
                    + " where last_purchase_price<>0 group by item_code order by item_code asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int item_code = rs.getInt(1);
              
                String cost = rs.getString(2);
                String price = rs.getString(3);
                System.out.println("Item Code: " + item_code + " Cost: " + cost +" Price: "+price);
                String s2 = "update inventory set "
                        + "selling_price= :selling_price"
                        + ",cost= :cost"
                        + " where "
                        + " barcode ='" + item_code + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setNumber("selling_price", FitIn.toDouble(price))
                        .setNumber("cost", FitIn.toDouble(cost))
                        .ok();

                PreparedStatement stmt2 = conn3.prepareStatement(s2);
                stmt2.execute();
                Lg.s(S1_inventory.class, "Successfully Updated");
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
//        List<to_item_uom> datas = ret_data("");

        update_cost_encoding("");
    }

    public static List<to_encoding_inventory> update_cost_encoding(String search) {
        List<to_encoding_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect3();
            Connection conn2 = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",qty"
                    + ",date_added"
                    + ",user_name"
                    + ",screen_name"
                    + ",sheet_no"
                    + ",status"
                    + ",counted_by"
                    + ",checked_by"
                    + ",cost"
                    + ",selling_price"
                    + " from encoding_inventory order by item_code asc"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String s2 = "select "
                        + "selling_price"
                        + ",cost"
                        + " from inventory where "
                        + " barcode ='" + item_code + "' "
                        + " ";

                double cost = 0;
                double selling_price = 0;
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    cost = rs2.getDouble(2);
                    selling_price = rs2.getDouble(1);
                }
                String s3 = "update encoding_inventory set "
                        + "cost= :cost"
                        + ",selling_price= :selling_price"
                        + " where "
                        + " item_code ='" + item_code + "' "
                        + " ";
                s3 = SqlStringUtil.parse(s3)
                        .setNumber("cost", cost)
                        .setNumber("selling_price", selling_price)
                        .ok();

                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();
                System.out.println("Item Code: "+item_code+" Qty:"+cost+ " Price:"+selling_price);
                Lg.s(Encoding_inventory.class, "Successfully Updated");
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
