/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import POS.inventory_replenishment.Inventory_replenishment_items;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Adjust_replenishment {

    public static class field {

        public final String item_code;
        public final double qty;

        public field(String item_code, double qty) {
            this.item_code = item_code;
            this.qty = qty;
        }

    }

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("pool_host", "192.168.1.51");
        double qty = 0;
        String replenishment_no = "14|000000000006";

        List<field> fields = new ArrayList();
        field f1 = new field("7210", -1);
        field f2 = new field("4768", 10);
        field f3 = new field("7255", 1);
        field f4 = new field("932", 1);
        field f5 = new field("7650", 2);
        field f6 = new field("336", 2);
        field f7 = new field("2182",4);
        field f8 = new field("7073", 4);
        field f9 = new field("7775", 3);
        field f10 = new field("4011", 1);
        field f11 = new field("5047", 8);
        field f12 = new field("6295", -5);
        field f13 = new field("824", 56);
        field f14 = new field("1929", 1);
        field f15 = new field("8410", 1);
        field f16 = new field("4803", 9);
        field f17 = new field("4802", 5);
        field f18 = new field("2259", 1);
        field f19 = new field("2292", 1);
        field f20 = new field("2196", 4);
        field f21 = new field("1329", 427);
        field f22 = new field("6953", 4);
        field f23 = new field("5941", 1);
        field f24 = new field("4232", 14);
        field f25 = new field("3744", 24);
        field f26 = new field("1036", 3);
        field f27 = new field("1169", 7);
        field f28 = new field("5590", 2);
        field f29 = new field("5128",1);
        field f30 = new field("7072", 2);
        field f31 = new field("314", 1);
        field f32 = new field("1923", 1);
        field f33 = new field("4308", 30);
        field f34 = new field("2089", 5);
        field f35 = new field("1753", 1);
        field f36 = new field("6482", 3);
        field f37 = new field("6481",2);
        field f38 = new field("6220", 2);
        field f39 = new field("6094", 1);
        field f40 = new field("3861", 6);
        field f41 = new field("1409", 1);
        field f42 = new field("6359", 170);
        field f43 = new field("7030", 32);
        field f44 = new field("5599", 2);
        field f45 = new field("4512", 1);
        field f46 = new field("5373", 1);
        field f47 = new field("1448", 1);
        field f48 = new field("1458", 1);
        field f49 = new field("2365", 1);
        field f50 = new field("2430", 2);
        field f51 = new field("", 0);
        field f52 = new field("", 0);
        field f53 = new field("", 0);
        field f54 = new field("", 0);
        field f55 = new field("", 0);
        field f56 = new field("", 0);
        field f57 = new field("", 0);
        field f58 = new field("", 0);
        field f59 = new field("", 0);
        field f60 = new field("", 0);
        fields.add(f1);
        fields.add(f2);
        fields.add(f3);
        fields.add(f4);
        fields.add(f5);
        fields.add(f6);
        fields.add(f7);
        fields.add(f8);
        fields.add(f9);
        fields.add(f10);
        fields.add(f11);
        fields.add(f12);
        fields.add(f13);
        fields.add(f14);
        fields.add(f15);
        fields.add(f16);
        fields.add(f17);
        fields.add(f18);
        fields.add(f19);
        fields.add(f20);
        fields.add(f21);
        fields.add(f22);
        fields.add(f23);
        fields.add(f24);
        fields.add(f25);
        fields.add(f26);
        fields.add(f27);
        fields.add(f28);
        fields.add(f29);
        fields.add(f30);
        fields.add(f31);
        fields.add(f32);
        fields.add(f33);
        fields.add(f34);
        fields.add(f35);
        fields.add(f36);
        fields.add(f37);
        fields.add(f38);
        fields.add(f39);
        fields.add(f40);
        fields.add(f41);
        fields.add(f42);
        fields.add(f43);
        fields.add(f44);
        fields.add(f45);
        fields.add(f46);
        fields.add(f47);
        fields.add(f48);
        fields.add(f49);
        fields.add(f50);
        fields.add(f51);
        fields.add(f52);
        fields.add(f53);
        fields.add(f54);
        fields.add(f55);
        fields.add(f56);
        fields.add(f57);
        fields.add(f58);
        fields.add(f59);
        fields.add(f60);
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
            for (field f : fields) {
                String s0 = "update inventory_replenishment_items set "
                        + " product_qty= :product_qty "
                        + " where item_code='" + f.item_code + "' and inventory_replenishment_no='" + replenishment_no + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setNumber("product_qty", f.qty)
                        .ok();

                stmt.addBatch(s0);
            }
            stmt.executeBatch();
            conn.commit();
            Lg.s(Inventory_replenishment_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

}
