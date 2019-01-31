/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.inventory_reports.MyLedger;
import POS.inventory_reports.Srpt_item_ledger;
import POS.receipts.Receipts;
import POS.receipts.S1_receipt_items;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Guinness
 */
public class Receipts_date_delivered {

    public static void main2(String[] args) {
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");

        String[] trans = {"14|0000001342", "14|0000001365", "14|0000001425", "14|0000001443", "14|0000001773", "14|0000001775", "14|0000001786", "14|0000001787",
            "14|0000001788", "14|0000001789", "14|0000001790", "14|0000001791", "14|0000001792", "14|0000001797", "14|0000001798", "14|0000001799", "14|0000001803",
            "14|0000001804", "14|0000001805", "14|0000001806", "14|0000001443"};

        String loc_id = "14";
        String year = "2017";
        int month = 10;
        String branch = "";
        String location = "";
        boolean is_month_selected = true;

        try {
            Connection conn = MyConnection.connect();

            for (String tran : trans) {
                String where = " where receipt_no='" + tran + "' ";
                List<Receipts.to_receipts> receipts = Receipts.ret_data3(where);
                Receipts.to_receipts receipt = (Receipts.to_receipts) receipts.get(0);

                String s2 = " update  receipt_items set "
                        + " date_delivered='" + receipt.date_delivered + "' "
                        + " where receipt_no = '" + receipt.receipt_no + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Receipts_date_delivered.class, "Receipt Successfully Updated");

                System.out.println("Transaction: " + receipt.receipt_no + " date_delivered: " + receipt.date_delivered);
                String where2 = " where receipt_no='" + tran + "' ";
                List<S1_receipt_items.to_receipt_items> items = S1_receipt_items.ret_data5(where2);
                System.out.println("    Size: " + items.size());
                for (S1_receipt_items.to_receipt_items item : items) {
                    Srpt_item_ledger rpt = MyLedger.get(item.main_barcode, item.barcode, item.description, loc_id, year, month, branch, location, is_month_selected,1,0,0);
                    String s4 = " update inventory_barcodes set "
                            + " product_qty='" + rpt.running_balance + "'"
                            + " where  main_barcode= '" + item.main_barcode + "' and location_id='" + loc_id + "' "
                            + "";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();
                    Lg.s(Receipts_date_delivered.class, "Inventory Barcodes Successfully Updated");
                    System.out.println("    item: " + item.main_barcode + " ,ledger= " + rpt.running_balance);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main3(String[] args) {
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");

        String[] trans = {"16|0000001425", "16|0000001428"};

        String loc_id = "16";
        String year = "2017";
        int month = 10;
        String branch = "";
        String location = "";
        boolean is_month_selected = true;

        try {
            Connection conn = MyConnection.connect();

            for (String tran : trans) {
                String where = " where receipt_no='" + tran + "' ";
                List<Receipts.to_receipts> receipts = Receipts.ret_data3(where);
                Receipts.to_receipts receipt = (Receipts.to_receipts) receipts.get(0);

                String s2 = " update  receipt_items set "
                        + " date_delivered='" + receipt.date_delivered + "' "
                        + " where receipt_no = '" + receipt.receipt_no + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Receipts_date_delivered.class, "Receipt Successfully Updated");

                System.out.println("Transaction: " + receipt.receipt_no + " date_delivered: " + receipt.date_delivered);
                String where2 = " where receipt_no='" + tran + "' ";
                List<S1_receipt_items.to_receipt_items> items = S1_receipt_items.ret_data5(where2);
                System.out.println("    Size: " + items.size());
                for (S1_receipt_items.to_receipt_items item : items) {
                    Srpt_item_ledger rpt = MyLedger.get(item.main_barcode, item.barcode, item.description, loc_id, year, month, branch, location, is_month_selected,1,0,0);
                    String s4 = " update inventory_barcodes set "
                            + " product_qty='" + rpt.running_balance + "'"
                            + " where  main_barcode= '" + item.main_barcode + "' and location_id='" + loc_id + "' "
                            + "";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();
                    Lg.s(Receipts_date_delivered.class, "Inventory Barcodes Successfully Updated");
                    System.out.println("    item: " + item.main_barcode + " ,ledger= " + rpt.running_balance);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main4(String[] args) {
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");

        String[] trans = {"20|0000001454"};

        String loc_id = "20";
        String year = "2017";
        int month = 10;
        String branch = "";
        String location = "";
        boolean is_month_selected = true;

        try {
            Connection conn = MyConnection.connect();

            for (String tran : trans) {
                String where = " where receipt_no='" + tran + "' ";
                List<Receipts.to_receipts> receipts = Receipts.ret_data3(where);
                Receipts.to_receipts receipt = (Receipts.to_receipts) receipts.get(0);

                String s2 = " update  receipt_items set "
                        + " date_delivered='" + receipt.date_delivered + "' "
                        + " where receipt_no = '" + receipt.receipt_no + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Receipts_date_delivered.class, "Receipt Successfully Updated");

                System.out.println("Transaction: " + receipt.receipt_no + " date_delivered: " + receipt.date_delivered);
                String where2 = " where receipt_no='" + tran + "' ";
                List<S1_receipt_items.to_receipt_items> items = S1_receipt_items.ret_data5(where2);
                System.out.println("    Size: " + items.size());
                for (S1_receipt_items.to_receipt_items item : items) {
                    Srpt_item_ledger rpt = MyLedger.get(item.main_barcode, item.barcode, item.description, loc_id, year, month, branch, location, is_month_selected,1,0,0);
                    String s4 = " update inventory_barcodes set "
                            + " product_qty='" + rpt.running_balance + "'"
                            + " where  main_barcode= '" + item.main_barcode + "' and location_id='" + loc_id + "' "
                            + "";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();
                    Lg.s(Receipts_date_delivered.class, "Inventory Barcodes Successfully Updated");
                    System.out.println("    item: " + item.main_barcode + " ,ledger= " + rpt.running_balance);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");

        String[] trans = {"23|0000001494","23|0000001505","23|0000001506","23|0000001507","23|0000001508","23|0000001509","23|0000001510"};

        String loc_id = "23";
        String year = "2017";
        int month = 10;
        String branch = "";
        String location = "";
        boolean is_month_selected = true;

        try {
            Connection conn = MyConnection.connect();

            for (String tran : trans) {
                String where = " where receipt_no='" + tran + "' ";
                List<Receipts.to_receipts> receipts = Receipts.ret_data3(where);
                Receipts.to_receipts receipt = (Receipts.to_receipts) receipts.get(0);

                String s2 = " update  receipt_items set "
                        + " date_delivered='" + receipt.date_delivered + "' "
                        + " where receipt_no = '" + receipt.receipt_no + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Receipts_date_delivered.class, "Receipt Successfully Updated");

                System.out.println("Transaction: " + receipt.receipt_no + " date_delivered: " + receipt.date_delivered);
                String where2 = " where receipt_no='" + tran + "' ";
                List<S1_receipt_items.to_receipt_items> items = S1_receipt_items.ret_data5(where2);
                System.out.println("    Size: " + items.size());
                for (S1_receipt_items.to_receipt_items item : items) {
                    Srpt_item_ledger rpt = MyLedger.get(item.main_barcode, item.barcode, item.description, loc_id, year, month, branch, location, is_month_selected,1,0,0);
                    String s4 = " update inventory_barcodes set "
                            + " product_qty='" + rpt.running_balance + "'"
                            + " where  main_barcode= '" + item.main_barcode + "' and location_id='" + loc_id + "' "
                            + "";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();
                    Lg.s(Receipts_date_delivered.class, "Inventory Barcodes Successfully Updated");
                    System.out.println("    item: " + item.main_barcode + " ,ledger= " + rpt.running_balance);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
