/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

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
public class S1_inventory_multi_level_pricing {

    public static class to_inventory_multi_level_pricing {

        public final int id;
        public final String main_barcode;
        public final String barcode;
        public final String description;
        public final String unit;
        public final double conversion;
        public final double markup;
        public final double selling_price;

        public to_inventory_multi_level_pricing(int id, String main_barcode, String barcode, String description, String unit, double conversion, double markup, double selling_price) {
            this.id = id;
            this.main_barcode = main_barcode;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.conversion = conversion;
            this.markup = markup;
            this.selling_price = selling_price;
        }
    }

    public static void add_inventory_multi_level_pricing(to_inventory_multi_level_pricing to_inventory_multi_level_pricing) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_multi_level_pricing("
                    + "main_barcode"
                    + ",barcode"
                    + ",description"
                    + ",unit"
                    + ",conversion"
                    + ",markup"
                    + ",selling_price"
                    + ")values("
                    + ":main_barcode"
                    + ",:barcode"
                    + ",:description"
                    + ",:unit"
                    + ",:conversion"
                    + ",:markup"
                    + ",:selling_price"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("main_barcode", to_inventory_multi_level_pricing.main_barcode).
                    setString("barcode", to_inventory_multi_level_pricing.barcode).
                    setString("description", to_inventory_multi_level_pricing.description).
                    setString("unit", to_inventory_multi_level_pricing.unit).
                    setNumber("conversion", to_inventory_multi_level_pricing.conversion).
                    setNumber("markup", to_inventory_multi_level_pricing.markup).
                    setNumber("selling_price", to_inventory_multi_level_pricing.selling_price).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_multi_level_pricing.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_multi_level_pricing(to_inventory_multi_level_pricing to_inventory_multi_level_pricing) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_multi_level_pricing set "
                    + "main_barcode= :main_barcode"
                    + ",barcode= :barcode"
                    + ",description= :description"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",markup= :markup"
                    + ",selling_price= :selling_price"
                    + " where "
                    + " id ='" + to_inventory_multi_level_pricing.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("main_barcode", to_inventory_multi_level_pricing.main_barcode).
                    setString("barcode", to_inventory_multi_level_pricing.barcode).
                    setString("description", to_inventory_multi_level_pricing.description).
                    setString("unit", to_inventory_multi_level_pricing.unit).
                    setNumber("conversion", to_inventory_multi_level_pricing.conversion).
                    setNumber("markup", to_inventory_multi_level_pricing.markup).
                    setNumber("selling_price", to_inventory_multi_level_pricing.selling_price).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_multi_level_pricing.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_multi_level_pricing(to_inventory_multi_level_pricing to_inventory_multi_level_pricing) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_multi_level_pricing where "
                    + " id ='" + to_inventory_multi_level_pricing.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_multi_level_pricing.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_multi_level_pricing> ret_data(String search) {
        List<to_inventory_multi_level_pricing> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",main_barcode"
                    + ",barcode"
                    + ",description"
                    + ",unit"
                    + ",conversion"
                    + ",markup"
                    + ",selling_price"
                    + " from inventory_multi_level_pricing where "
                    + " main_barcode ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String main_barcode = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String unit = rs.getString(5);
                double conversion = rs.getDouble(6);
                double markup = rs.getDouble(7);
                double selling_price = rs.getDouble(8);

                to_inventory_multi_level_pricing to = new to_inventory_multi_level_pricing(id, main_barcode, barcode, description, unit, conversion, markup, selling_price);
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
