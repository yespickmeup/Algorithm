/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test2;

import POS.accounts_payable.Accounts_payable;
import POS.receipts.Receipts;
import POS.suppliers.Suppliers;
import POS.users.MyUser;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Test_ap {

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");
        System.setProperty("module_accounts_payable", "1");
        start();
    }

    public static void start() {

        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            List<Suppliers.to_suppliers> suppliers = Suppliers.ret_data2("");
            Suppliers.to_suppliers s = suppliers.get(0);
            PreparedStatement stmt = conn.prepareStatement("");
            String ap_no = s.branch_id + "|" + "000000000000";

            for (Suppliers.to_suppliers supplier : suppliers) {
                System.out.println("Supplier: " + supplier.customer_no + " : " + supplier.customer_name);
                List<Receipts.to_receipts> receipts = Receipts.ret_data3(" where supllier_id='" + supplier.customer_no + "' and status=1 ");
                double amou = 0;
                double disc = 0;

                for (Receipts.to_receipts receipt : receipts) {

                    System.out.println("      Receipt: " + receipt.receipt_no + " = " + receipt.gross_total + " - " + receipt.discount);

                    String customer_id = supplier.customer_no;
                    String customer_name = supplier.customer_name;
                    ap_no = ReceiptIncrementor.increment(ap_no);
//                    System.out.println("ap_no: " + ap_no);
                    String date_added = DateType.now();
                    String user_name = MyUser.getUser_name();
                    double amount = receipt.gross_total;
                    amou += amount;
                    double discount_amount = receipt.discount;
                    disc += discount_amount;
                    double discount_rate = 0;
                    String discount = "";
                    int status = 0;
                    double term = 0;
                    String date_applied = receipt.date_delivered;
                    double paid = 0;
                    String date_paid = receipt.date_delivered;
                    String remarks = "";
                    String type = "";
                    String reference_no = receipt.receipt_no;
                    String user_id = MyUser.getUser_id();
                    String user_screen_name = MyUser.getUser_screen_name();

                    String location_id = "";
                    String s3 = "select "
                            + "id"
                            + ",branch"
                            + ",branch_id"
                            + ",code"
                            + ",location"
                            + ",type"
                            + ",status"
                            + " from branch_locations  "
                            + " where id='" + supplier.branch_id + "' ";

                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(s3);
                    String branch1 = "";
                    String branch_id1 = "";
                    String location1 = "";
                    if (rs2.next()) {
                        int id = rs2.getInt(1);
                        location_id = "" + id;
                        branch1 = rs2.getString(2);
                        branch_id1 = rs2.getString(3);

                        location1 = rs2.getString(5);

                    }

                    Accounts_payable.to_accounts_payable to_accounts_payable = new Accounts_payable.to_accounts_payable(0, customer_id, customer_name, ap_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, reference_no, user_id, user_screen_name, branch1, branch_id1, location1, location_id);
                    String s4 = "insert into accounts_payable("
                            + " customer_id"
                            + ",customer_name"
                            + ",ap_no"
                            + ",date_added"
                            + ",user_name"
                            + ",amount"
                            + ",discount_amount"
                            + ",discount_rate"
                            + ",discount"
                            + ",status"
                            + ",term"
                            + ",date_applied"
                            + ",paid"
                            + ",date_paid"
                            + ",remarks"
                            + ",type"
                            + ",reference_no"
                            + ",user_id"
                            + ",user_screen_name"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + ")values("
                            + ":customer_id"
                            + ",:customer_name"
                            + ",:ap_no"
                            + ",:date_added"
                            + ",:user_name"
                            + ",:amount"
                            + ",:discount_amount"
                            + ",:discount_rate"
                            + ",:discount"
                            + ",:status"
                            + ",:term"
                            + ",:date_applied"
                            + ",:paid"
                            + ",:date_paid"
                            + ",:remarks"
                            + ",:type"
                            + ",:reference_no"
                            + ",:user_id"
                            + ",:user_screen_name"
                            + ",:branch"
                            + ",:branch_id"
                            + ",:location"
                            + ",:location_id"
                            + ")";

                    s4 = SqlStringUtil.parse(s4)
                            .setString("customer_id", to_accounts_payable.customer_id)
                            .setString("customer_name", to_accounts_payable.customer_name)
                            .setString("ap_no", to_accounts_payable.ap_no)
                            .setString("date_added", to_accounts_payable.date_added)
                            .setString("user_name", to_accounts_payable.user_name)
                            .setNumber("amount", to_accounts_payable.amount)
                            .setNumber("discount_amount", to_accounts_payable.discount_amount)
                            .setNumber("discount_rate", to_accounts_payable.discount_rate)
                            .setString("discount", to_accounts_payable.discount)
                            .setNumber("status", to_accounts_payable.status)
                            .setNumber("term", to_accounts_payable.term)
                            .setString("date_applied", to_accounts_payable.date_applied)
                            .setNumber("paid", to_accounts_payable.paid)
                            .setString("date_paid", to_accounts_payable.date_paid)
                            .setString("remarks", to_accounts_payable.remarks)
                            .setString("type", to_accounts_payable.type)
                            .setString("reference_no", to_accounts_payable.reference_no)
                            .setString("user_id", to_accounts_payable.user_id)
                            .setString("user_screen_name", to_accounts_payable.user_screen_name)
                            .setString("branch", to_accounts_payable.branch)
                            .setString("branch_id", to_accounts_payable.branch_id)
                            .setString("location", to_accounts_payable.location)
                            .setString("location_id", to_accounts_payable.location_id)
                            .ok();

                    stmt.addBatch(s4);

                }

                String s5 = "select "
                        + " balance"
                        + " from  suppliers  "
                        + " where customer_no='" + supplier.customer_no + "' ";

                Statement stmt5 = conn.createStatement();
                ResultSet rs5 = stmt5.executeQuery(s5);
                double balance = 0;
                if (rs5.next()) {
                    balance = rs5.getDouble(1);
                }

                double new_balance = (amou - disc) + balance;

                String s6 = "update  suppliers set "
                        + " balance= :balance"
                        + " where "
                        + " customer_no='" + supplier.customer_no + "' "
                        + " ";

                s6 = SqlStringUtil.parse(s6).
                        setNumber("balance", new_balance).ok();

                stmt.addBatch(s6);
                System.out.println("    new_balance: " + new_balance);
                System.out.println("----------------------------------------------");
            }
            stmt.executeBatch();
            conn.commit();
            Lg.s(Receipts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    private void update_balance() {

    }
}
