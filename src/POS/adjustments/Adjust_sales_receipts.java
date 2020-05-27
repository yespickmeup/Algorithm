/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.my_sales.MySales;
import POS.sales.Sales;
import POS.sales.Sales.to_sales;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author User
 */
public class Adjust_sales_receipts {

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("pool_host", "192.168.1.51");
        List<MySales.sales> sales = MySales.ret_data(" where ref_or_no !='' ");
        for (MySales.sales sale : sales) {
            int ref = FitIn.toInt(sale.ref_or_no) - 1;
            System.out.println("Id: " + sale.id + " = " + sale.ref_or_no + "/" + ref);
        }

        System.out.println("size: " + sales.size());
    }

    public static void update_data(int id, String ref, int type) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "";
            if (type == 1) {
                s0 = "update sales set "
                        + " ref_or_no= :ref_or_no "
                        + " where id='" + id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setString("ref_or_no", ref)
                        .ok();
            }
            if (type == 2) {
                s0 = "update sales set "
                        + " ref_si_no= :ref_si_no "
                        + " where id='" + id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setString("ref_si_no", ref)
                        .ok();

            }

            if (type == 3) {
                s0 = "update sales set "
                        + " ref_cr_no= :ref_cr_no "
                        + " where id='" + id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setString("ref_cr_no", ref)
                        .ok();

            }

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
