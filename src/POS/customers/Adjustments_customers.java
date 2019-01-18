/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.accounts_receivable.S1_accounts_receivable;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Ronescape
 */
public class Adjustments_customers {

    public static void main(String[] args) {
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");
        List<Customers.to_customers> customers = Customers.ret_data2("order by id asc ");
        for (Customers.to_customers to : customers) {

            List<S1_accounts_receivable.to_accounts_receivable> receivables = S1_accounts_receivable.ret_data5("where customer_id='" + to.customer_no + "' order by Date(date_applied) asc");
            double total = 0;
            for (S1_accounts_receivable.to_accounts_receivable to2 : receivables) {
                if (to2.status != 1) {
                    total += to2.amount - to2.paid;
                }
            }
            if (to.balance != total) {
                System.out.println("Customer: " + to.customer_no + " | " + to.customer_name + " = Balance: " + to.balance + "/" + total);

                try {
                    Connection conn = MyConnection.connect();
                    String s0 = " update customers set balance='" + total + "' where customer_no='" + to.customer_no + "' ";
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(Customers.class, "Successfully Updated");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    MyConnection.close();
                }
            }
        }
    }
}
