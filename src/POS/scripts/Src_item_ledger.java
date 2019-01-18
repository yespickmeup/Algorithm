/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.scripts;

import POS.inventory.Inventory.to_inventory;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class Src_item_ledger {

    public static void run() {
//        List<S1_branch_locations.to_branch_locations> branch_location_list = S1_branch_locations.ret_location_where(" where branch_id = '"+"9"+"' ");
//
//        String[] aw = {"1033", "1050", "1090", "1108", "1111", "1119", "1184", "1192", "1200", "1204", "1285", "1296", "1405", "1521", "1592", "1607", "1697", "1741", "1857", "1865", "1883", "1916", "1975", "1976", "2194", "2206", "2233", "227", "236", "237", "2394", "2447", "2523", "2529", "2530", "2648", "2714", "2728", "280", "2827", "2832", "3027", "303", "304", "3073", "3080", "3084", "3106", "319", "3197", "3199", "3200", "3201", "3321", "3349", "337", "338", "3401", "3402", "3450", "3577", "3631", "3651", "3712", "3757", "3789", "3832", "384", "3895", "3926", "3938", "3965", "3982", "4008", "4035", "4038", "4050", "4053", "4063", "4168", "4287", "4289", "4330", "4332", "4422", "4485", "4486", "4499", "4574", "4621", "4635", "4638", "4652", "4665", "4696", "4718", "4733", "4840", "4854", "489", "4907", "491", "4912", "4963", "4964", "5018", "5040", "5041", "5059", "5060", "5073", "5079", "5204", "5205", "5228", "5283", "5398", "5447", "549", "5502", "5515", "5547", "5558", "5625", "5715", "5742", "5775", "5840", "5865", "5915", "5971", "6048", "6081", "6096", "6170", "6217", "6293", "635", "636", "6389", "6440", "6475", "6477", "6555", "6571", "6580", "6637", "6679", "6779", "6807", "6808", "6841", "6982", "7003", "7041", "7045", "7057", "7076", "7190", "7302", "7309", "7317", "7385", "7418", "7487", "7510", "7559", "7586", "7590", "7626", "7627", "7637", "7686", "7687", "7741", "7787", "7801", "7809", "7880", "7881", "790", "791", "7977", "8009", "802", "8080", "8085", "8104", "8139", "814", "815", "817", "8205", "8211", "8228", "8233", "8239", "824", "8242", "8244", "8264", "846", "847", "917", "994"};
//
////        for (String w : aw) {
//        List<to_inventory> datas = Src_item_ledger.ret_data(" ");
//        for (to_inventory to : datas) {
//            System.out.println("*******************************************************************************************************************************************************************");
//            System.out.println(to.barcode + " | " + to.description);
//            for (S1_branch_locations.to_branch_locations loc : branch_location_list) {
//                              
//                String where = " where item_code ='" + to.barcode + "'  and YEAR(date_added)='" + "2015" + "'  "
//                        + "   ";
//                String where2 = " where main_barcode ='" + to.barcode + "'  and YEAR(date_added)='" + "2015" + "' "
//                        + "  ";
//                String where3 = " where barcode ='" + to.barcode + "'   and YEAR(date_added)='" + "2015" + "' "
//                        + "  ";
//                String wheree = " where item_code ='" + to.barcode + "'  and YEAR(date_added)='" + "2015" + "'  and status=1 "
//                        + "   ";                
//                List<Srpt_item_ledger.field> fields = new ArrayList();
//                List<Srpt_item_ledger.field> sales = new ArrayList();//Srpt_item_ledger.sales(where);
//                List<Srpt_item_ledger.field> inventory_count = new ArrayList();// Srpt_item_ledger.inventory_encoding(where);
//                List<Srpt_item_ledger.field> receipts = new ArrayList(); //Srpt_item_ledger.receipts(where2);
//                List<Srpt_item_ledger.field> transfers = new ArrayList(); //Srpt_item_ledger.transfer(where3);
//                List<Srpt_item_ledger.field> adjustments = new ArrayList(); //Srpt_item_ledger.adjustments(where);
//                List<Srpt_item_ledger.field> return_exchange = new ArrayList(); //Srpt_item_ledger.item_replacements(where);
//                List<Srpt_item_ledger.field> charge_in_advance = new ArrayList(); //Srpt_item_ledger.charge_items(where);
//                List<Srpt_item_ledger.field> charge_in_advance_cancelled = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
//                try {
//                    Connection conn = MyConnection.connect();      
//                  
//                    //<editor-fold defaultstate="collapsed" desc=" sales ">
//                    String s0 = "select "
//                            + "id"
//                            + ",sales_no"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",addtl_amount"
//                            + ",wtax"
//                            + " from sale_items"
//                            + " " + where;
//
//                    Statement stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery(s0);
//                    while (rs.next()) {
//                        int id = rs.getInt(1);
//                        String sales_no = rs.getString(2);
//                        String item_code = rs.getString(3);
//                        String barcode = rs.getString(4);
//                        String description = rs.getString(5);
//                        String generic_name = rs.getString(6);
//                        String item_type = rs.getString(7);
//                        String supplier_name = rs.getString(8);
//                        String supplier_id = rs.getString(9);
//                        String serial_no = rs.getString(10);
//                        double product_qty = rs.getDouble(11);
//                        String unit = rs.getString(12);
//                        double conversion = rs.getDouble(13);
//                        double selling_price = rs.getDouble(14);
//                        String date_added = rs.getString(15);
//                        String user_id = rs.getString(16);
//                        String user_screen_name = rs.getString(17);
//                        int status = rs.getInt(18);
//                        int is_vatable = rs.getInt(19);
//                        int selling_type = rs.getInt(20);
//                        String discount_name = rs.getString(21);
//                        double discount_rate = rs.getDouble(22);
//                        double discount_amount = rs.getDouble(23);
//                        String discount_customer_name = rs.getString(24);
//                        String discount_customer_id = rs.getString(25);
//                        String branch = rs.getString(26);
//                        String branch_code = rs.getString(27);
//                        String location = rs.getString(28);
//                        String location_id = rs.getString(29);
//                        String category = rs.getString(30);
//                        String category_id = rs.getString(31);
//                        String classification = rs.getString(32);
//                        String classification_id = rs.getString(33);
//                        String sub_classification = rs.getString(34);
//                        String sub_classification_id = rs.getString(35);
//                        String brand = rs.getString(36);
//                        String brand_id = rs.getString(37);
//                        String model = rs.getString(38);
//                        String model_id = rs.getString(39);
//                        double addtl_amount = rs.getDouble(40);
//                        double wtax = rs.getDouble(41);
//
//                        String transaction_type = "Sales";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = "";
//                        String out = FitIn.fmt_woc(product_qty);
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + sales_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        sales.add(field);
//                        if (status == 1) {
//                            Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Sales - X", date, FitIn.fmt_woc(product_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                            sales.add(field2);
//                        }
//                    }
//
//                    //</editor-fold>                    
//                    //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
//                    String s2 = "select "
//                            + "id"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + ",qty"
//                            + ",date_added"
//                            + ",user_name"
//                            + ",screen_name"
//                            + ",sheet_no"
//                            + ",status"
//                            + ",counted_by"
//                            + ",checked_by"
//                            + ",cost"
//                            + ",selling_price"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + " from encoding_inventory"
//                            + " " + where;
//
//                    Statement stmt2 = conn.createStatement();
//                    ResultSet rs2 = stmt2.executeQuery(s2);
//                    while (rs2.next()) {
//                        int id = rs2.getInt(1);
//                        String item_code = rs2.getString(2);
//                        String barcode = rs2.getString(3);
//                        String description = rs2.getString(4);
//                        String branch = rs2.getString(5);
//                        String branch_id = rs2.getString(6);
//                        String location = rs2.getString(7);
//                        String location_id = rs2.getString(8);
//                        double qty = rs2.getDouble(9);
//                        String date_added = rs2.getString(10);
//                        String user_name = rs2.getString(11);
//                        String screen_name = rs2.getString(12);
//                        String sheet_no = rs2.getString(13);
//                        int status = rs2.getInt(14);
//                        String counted_by = rs2.getString(15);
//                        String checked_by = rs2.getString(16);
//                        double cost = rs2.getDouble(17);
//                        double selling_price = rs2.getDouble(18);
//                        String user_id = rs2.getString(19);
//                        String user_screen_name = rs2.getString(20);
//
//                        String transaction_type = "Inventory Count";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_id;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + sheet_no;
//                        String cost1 = FitIn.fmt_wc_0(cost);
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//
//                        inventory_count.add(field);
//                    }
//                    //</editor-fold>                   
//                    //<editor-fold defaultstate="collapsed" desc=" Receipts ">
//                    String s3 = "select "
//                            + " id"
//                            + ",receipt_no"
//                            + ",user_name"
//                            + ",session_no"
//                            + ",date_added"
//                            + ",supplier"
//                            + ",supllier_id"
//                            + ",remarks"
//                            + ",barcode"
//                            + ",description"
//                            + ",qty"
//                            + ",cost"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_class"
//                            + ",sub_class_id"
//                            + ",conversion"
//                            + ",unit"
//                            + ",date_delivered"
//                            + ",date_received"
//                            + ",barcodes"
//                            + ",batch_no"
//                            + ",serial_no"
//                            + ",main_barcode"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",status"
//                            + ",previous_cost"
//                            + ",receipt_type_id"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + " from receipt_items"
//                            + " " + where2;
//
//                    Statement stmt3 = conn.createStatement();
//                    ResultSet rs3 = stmt3.executeQuery(s3);
//                    while (rs3.next()) {
//                        int id = rs3.getInt(1);
//                        String receipt_no = rs3.getString(2);
//                        String user_name = rs3.getString(3);
//                        String session_no = rs3.getString(4);
//                        String date_added = rs3.getString(5);
//                        String supplier = rs3.getString(6);
//                        String supllier_id = rs3.getString(7);
//                        String remarks = rs3.getString(8);
//                        String barcode = rs3.getString(9);
//                        String description = rs3.getString(10);
//                        double qty = rs3.getDouble(11);
//                        double cost = rs3.getDouble(12);
//                        String category = rs3.getString(13);
//                        String category_id = rs3.getString(14);
//                        String classification = rs3.getString(15);
//                        String classification_id = rs3.getString(16);
//                        String sub_class = rs3.getString(17);
//                        String sub_class_id = rs3.getString(18);
//                        double conversion = rs3.getDouble(19);
//                        String unit = rs3.getString(20);
//                        String date_delivered = rs3.getString(21);
//                        String date_received = rs3.getString(22);
//                        String barcodes = rs3.getString(23);
//                        String batch_no = rs3.getString(24);
//                        String serial_no = rs3.getString(25);
//                        String main_barcode = rs3.getString(26);
//                        String brand = rs3.getString(27);
//                        String brand_id = rs3.getString(28);
//                        String model = rs3.getString(29);
//                        String model_id = rs3.getString(30);
//                        int status = rs3.getInt(31);
//                        double previous_cost = rs3.getDouble(32);
//                        String receipt_type_id = rs3.getString(33);
//                        String branch = rs3.getString(34);
//                        String branch_id = rs3.getString(35);
//                        String location = rs3.getString(36);
//                        String location_id = rs3.getString(37);
//
//                        String transaction_type = "Receipts";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_id;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + receipt_no;
//                        String cost1 = FitIn.fmt_wc_0(cost);
//                        String price1 = "";
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//
//                        receipts.add(field);
//                    }
//
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Transfers ">
//                    List<Srpt_item_ledger.field> transfer_in = new ArrayList();
//                    List<Srpt_item_ledger.field> transfer_out = new ArrayList();
//                    String s4 = "select "
//                            + "id"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",user_name"
//                            + ",item_type"
//                            + ",status"
//                            + ",supplier"
//                            + ",fixed_price"
//                            + ",cost"
//                            + ",supplier_id"
//                            + ",multi_level_pricing"
//                            + ",vatable"
//                            + ",reorder_level"
//                            + ",markup"
//                            + ",barcodes"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",selling_type"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",stock_transfer_id"
//                            + ",serial_no"
//                            + ",to_branch"
//                            + ",to_branch_id"
//                            + ",to_location"
//                            + ",to_location_id"
//                            + " from stock_transfers_items"
//                            + " " + where3;
//
//                    Statement stmt4 = conn.createStatement();
//                    ResultSet rs4 = stmt4.executeQuery(s4);
//                    while (rs4.next()) {
//                        int id = rs4.getInt(1);
//                        String barcode = rs4.getString(2);
//                        String description = rs4.getString(3);
//                        String generic_name = rs4.getString(4);
//                        String category = rs4.getString(5);
//                        String category_id = rs4.getString(6);
//                        String classification = rs4.getString(7);
//                        String classification_id = rs4.getString(8);
//                        String sub_classification = rs4.getString(9);
//                        String sub_classification_id = rs4.getString(10);
//                        double product_qty = rs4.getDouble(11);
//                        String unit = rs4.getString(12);
//                        double conversion = rs4.getDouble(13);
//                        double selling_price = rs4.getDouble(14);
//                        String date_added = rs4.getString(15);
//                        String user_name = rs4.getString(16);
//                        String item_type = rs4.getString(17);
//                        int status = rs4.getInt(18);
//                        String supplier = rs4.getString(19);
//                        int fixed_price = rs4.getInt(20);
//                        double cost = rs4.getDouble(21);
//                        String supplier_id = rs4.getString(22);
//                        int multi_level_pricing = rs4.getInt(23);
//                        int vatable = rs4.getInt(24);
//                        double reorder_level = rs4.getDouble(25);
//                        double markup = rs4.getDouble(26);
//                        String barcodes = rs4.getString(27);
//                        String brand = rs4.getString(28);
//                        String brand_id = rs4.getString(29);
//                        String model = rs4.getString(30);
//                        String model_id = rs4.getString(31);
//                        int selling_type = rs4.getInt(32);
//                        String branch = rs4.getString(33);
//                        String branch_code = rs4.getString(34);
//                        String location = rs4.getString(35);
//                        String location_id = rs4.getString(36);
//                        String stock_transfer_id = rs4.getString(37);
//                        String serial_no = rs4.getString(38);
//                        String to_branch = rs4.getString(39);
//                        String to_branch_id = rs4.getString(40);
//                        String to_location = rs4.getString(41);
//                        String to_location_id = rs4.getString(42);
//
//                        String transaction_type = "Transfer";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(product_qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch1 = "";
//                        String to_branch_id1 = "";
//                        String to_location1 = "";
//                        String to_location_id1 = "";
//                        String created_by = user_name;
//                        String customer_name = "";
//                        Date created = new Date();
//
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        String transaction_no = "" + stock_transfer_id;
//                        String cost1 = FitIn.fmt_wc_0(cost);
//                        String price1 = "";
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field_out = new Srpt_item_ledger.field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance
//                                , from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id
//                                , created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        transfer_in.add(field_out);
//
//                        Srpt_item_ledger.field field_in = new Srpt_item_ledger.field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch
//                                , to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name
//                                , created, transaction_no, cost1, price1,months);
//                        transfer_out.add(field_in);
//
//                    }
//                    transfers.addAll(transfer_in);
//                    transfers.addAll(transfer_out);
//
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
//                    List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
//                    List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();
//                    String s5 = "select "
//                            + "id"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",qty"
//                            + ",new_qty"
//                            + ",is_add"
//                            + ",date_added"
//                            + ",status"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + " from adjustments"
//                            + " " + where;
//
//                    Statement stmt5 = conn.createStatement();
//                    ResultSet rs5 = stmt5.executeQuery(s5);
//                    while (rs5.next()) {
//                        int id = rs5.getInt(1);
//                        String item_code = rs5.getString(2);
//                        String barcode = rs5.getString(3);
//                        String description = rs5.getString(4);
//                        double qty = rs5.getDouble(5);
//                        double new_qty = rs5.getDouble(6);
//                        int is_add = rs5.getInt(7);
//                        String date_added = rs5.getString(8);
//                        int status = rs5.getInt(9);
//                        String user_id = rs5.getString(10);
//                        String user_screen_name = rs5.getString(11);
//                        String branch = rs5.getString(12);
//                        String branch_id = rs5.getString(13);
//                        String location = rs5.getString(14);
//                        String location_id = rs5.getString(15);
//
//                        String transaction_type = "Adjustment";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(new_qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_id;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + id;
//                        String cost1 = "";
//                        String price1 = "";
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        if (is_add == 1) {
//                            Srpt_item_ledger.field add = new Srpt_item_ledger.field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                            adjustment_add.add(add);
//                        } else {
//                            Srpt_item_ledger.field deduct = new Srpt_item_ledger.field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                            adjustment_deduct.add(deduct);
//                        }
//
//                    }
//                    adjustments.addAll(adjustment_add);
//                    adjustments.addAll(adjustment_deduct);
//
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Return Exchange ">
//                    String s6 = "select "
//                            + "id"
//                            + ",sales_no"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",is_replacement"
//                            + " from sale_item_replacements"
//                            + " " + where;
//                    Statement stmt6 = conn.createStatement();
//                    ResultSet rs6 = stmt6.executeQuery(s6);
//                    while (rs6.next()) {
//                        int id = rs6.getInt(1);
//                        String sales_no = rs6.getString(2);
//                        String item_code = rs6.getString(3);
//                        String barcode = rs6.getString(4);
//                        String description = rs6.getString(5);
//                        String generic_name = rs6.getString(6);
//                        String item_type = rs6.getString(7);
//                        String supplier_name = rs6.getString(8);
//                        String supplier_id = rs6.getString(9);
//                        String serial_no = rs6.getString(10);
//                        double product_qty = rs6.getDouble(11);
//                        String unit = rs6.getString(12);
//                        double conversion = rs6.getDouble(13);
//                        double selling_price = rs6.getDouble(14);
//                        String date_added = rs6.getString(15);
//                        String user_id = rs6.getString(16);
//                        String user_screen_name = rs6.getString(17);
//                        int status = rs6.getInt(18);
//                        int is_vatable = rs6.getInt(19);
//                        int selling_type = rs6.getInt(20);
//                        String discount_name = rs6.getString(21);
//                        double discount_rate = rs6.getDouble(22);
//                        double discount_amount = rs6.getDouble(23);
//                        String discount_customer_name = rs6.getString(24);
//                        String discount_customer_id = rs6.getString(25);
//                        String branch = rs6.getString(26);
//                        String branch_code = rs6.getString(27);
//                        String location = rs6.getString(28);
//                        String location_id = rs6.getString(29);
//                        String category = rs6.getString(30);
//                        String category_id = rs6.getString(31);
//                        String classification = rs6.getString(32);
//                        String classification_id = rs6.getString(33);
//                        String sub_classification = rs6.getString(34);
//                        String sub_classification_id = rs6.getString(35);
//                        String brand = rs6.getString(36);
//                        String brand_id = rs6.getString(37);
//                        String model = rs6.getString(38);
//                        String model_id = rs6.getString(39);
//                        int is_replacement = rs6.getInt(40);
//
//                        String transaction_type = "Exc-Replacement";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = "";
//                        String out = FitIn.fmt_woc(product_qty);
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + sales_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                        if (is_replacement == 0) {
//                            transaction_type = "Exc-Returned";
//                            in = FitIn.fmt_woc(product_qty);
//                            out = "";
//                        }
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        return_exchange.add(field);
//
//                    }
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Charge in Advance ">
//                    String s7 = "select "
//                            + "id"
//                            + ",customer_id"
//                            + ",customer_name"
//                            + ",ar_id"
//                            + ",ar_no"
//                            + ",date_applied"
//                            + ",reference_no"
//                            + ",soa_type"
//                            + ",soa_type_id"
//                            + ",user_screen_name"
//                            + ",user_id"
//                            + ",remarks"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",addtl_amount"
//                            + ",wtax"
//                            + " from charge_in_advance_items"
//                            + " " + where;
//
//                    Statement stmt7 = conn.createStatement();
//                    ResultSet rs7 = stmt7.executeQuery(s7);
//                    while (rs7.next()) {
//                        int id = rs7.getInt(1);
//                        String customer_id = rs7.getString(2);
//                        String customer_name = rs7.getString(3);
//                        String ar_id = rs7.getString(4);
//                        String ar_no = rs7.getString(5);
//                        String date_applied = rs7.getString(6);
//                        String reference_no = rs7.getString(7);
//                        String soa_type = rs7.getString(8);
//                        String soa_type_id = rs7.getString(9);
//                        String user_screen_name = rs7.getString(10);
//                        String user_id = rs7.getString(11);
//                        String remarks = rs7.getString(12);
//                        String item_code = rs7.getString(13);
//                        String barcode = rs7.getString(14);
//                        String description = rs7.getString(15);
//                        String generic_name = rs7.getString(16);
//                        String item_type = rs7.getString(17);
//                        String supplier_name = rs7.getString(18);
//                        String supplier_id = rs7.getString(19);
//                        String serial_no = rs7.getString(20);
//                        double product_qty = rs7.getDouble(21);
//                        String unit = rs7.getString(22);
//                        double conversion = rs7.getDouble(23);
//                        double selling_price = rs7.getDouble(24);
//                        String date_added = rs7.getString(25);
//                        int status = rs7.getInt(26);
//                        int is_vatable = rs7.getInt(27);
//                        int selling_type = rs7.getInt(28);
//                        String discount_name = rs7.getString(29);
//                        double discount_rate = rs7.getDouble(30);
//                        double discount_amount = rs7.getDouble(31);
//                        String discount_customer_name = rs7.getString(32);
//                        String discount_customer_id = rs7.getString(33);
//                        String branch = rs7.getString(34);
//                        String branch_code = rs7.getString(35);
//                        String location = rs7.getString(36);
//                        String location_id = rs7.getString(37);
//                        String category = rs7.getString(38);
//                        String category_id = rs7.getString(39);
//                        String classification = rs7.getString(40);
//                        String classification_id = rs7.getString(41);
//                        String sub_classification = rs7.getString(42);
//                        String sub_classification_id = rs7.getString(43);
//                        String brand = rs7.getString(44);
//                        String brand_id = rs7.getString(45);
//                        String model = rs7.getString(46);
//                        String model_id = rs7.getString(47);
//                        double addtl_amount = rs7.getDouble(48);
//                        double wtax = rs7.getDouble(49);
//
//                        String transaction_type = "Charge in Advance";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = "";
//                        String out = FitIn.fmt_woc(product_qty);
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        Date created = new Date();
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + ar_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        charge_in_advance.add(field);
//                    }
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Charge in advance[-] ">
//                    String s8 = "select "
//                            + "id"
//                            + ",customer_id"
//                            + ",customer_name"
//                            + ",ar_id"
//                            + ",ar_no"
//                            + ",date_applied"
//                            + ",reference_no"
//                            + ",soa_type"
//                            + ",soa_type_id"
//                            + ",user_screen_name"
//                            + ",user_id"
//                            + ",remarks"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",addtl_amount"
//                            + ",wtax"
//                            + " from charge_in_advance_cancelled_items"
//                            + " " + where;
//
//                    Statement stmt8 = conn.createStatement();
//                    ResultSet rs8 = stmt8.executeQuery(s8);
//                    while (rs8.next()) {
//                        int id = rs8.getInt(1);
//                        String customer_id = rs8.getString(2);
//                        String customer_name = rs8.getString(3);
//                        String ar_id = rs8.getString(4);
//                        String ar_no = rs8.getString(5);
//                        String date_applied = rs8.getString(6);
//                        String reference_no = rs8.getString(7);
//                        String soa_type = rs8.getString(8);
//                        String soa_type_id = rs8.getString(9);
//                        String user_screen_name = rs8.getString(10);
//                        String user_id = rs8.getString(11);
//                        String remarks = rs8.getString(12);
//                        String item_code = rs8.getString(13);
//                        String barcode = rs8.getString(14);
//                        String description = rs8.getString(15);
//                        String generic_name = rs8.getString(16);
//                        String item_type = rs8.getString(17);
//                        String supplier_name = rs8.getString(18);
//                        String supplier_id = rs8.getString(19);
//                        String serial_no = rs8.getString(20);
//                        double product_qty = rs8.getDouble(21);
//                        String unit = rs8.getString(22);
//                        double conversion = rs8.getDouble(23);
//                        double selling_price = rs8.getDouble(24);
//                        String date_added = rs8.getString(25);
//                        int status = rs8.getInt(26);
//                        int is_vatable = rs8.getInt(27);
//                        int selling_type = rs8.getInt(28);
//                        String discount_name = rs8.getString(29);
//                        double discount_rate = rs8.getDouble(30);
//                        double discount_amount = rs8.getDouble(31);
//                        String discount_customer_name = rs8.getString(32);
//                        String discount_customer_id = rs8.getString(33);
//                        String branch = rs8.getString(34);
//                        String branch_code = rs8.getString(35);
//                        String location = rs8.getString(36);
//                        String location_id = rs8.getString(37);
//                        String category = rs8.getString(38);
//                        String category_id = rs8.getString(39);
//                        String classification = rs8.getString(40);
//                        String classification_id = rs8.getString(41);
//                        String sub_classification = rs8.getString(42);
//                        String sub_classification_id = rs8.getString(43);
//                        String brand = rs8.getString(44);
//                        String brand_id = rs8.getString(45);
//                        String model = rs8.getString(46);
//                        String model_id = rs8.getString(47);
//                        double addtl_amount = rs8.getDouble(48);
//                        double wtax = rs8.getDouble(49);
//
//                        String transaction_type = "Charge in Adv. [X]";
//                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(product_qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        Date created = new Date();
//                        try {
//                            created = POS.util.DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + ar_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        charge_in_advance_cancelled.add(field);
//                    }
//
//                    //</editor-fold>
//                    
//                    
//                    fields.addAll(inventory_count);
//                    fields.addAll(sales);
//                    fields.addAll(receipts);
//                    fields.addAll(transfers);
//                    fields.addAll(adjustments);
//                    fields.addAll(return_exchange);
//                    fields.addAll(charge_in_advance);
//                    fields.addAll(charge_in_advance_cancelled);
//                    Collections.sort(fields, new Comparator<Srpt_item_ledger.field>() {
//                        @Override
//                        public int compare(Srpt_item_ledger.field o1, Srpt_item_ledger.field o2) {
//                            return o1.getDate_added().compareTo(o2.getDate_added());
//                        }
//                    });
//
//                    double qty = 0;
//
//                    for (Srpt_item_ledger.field f : fields) {
//                        if (f.getFrom_location_id().equalsIgnoreCase("" + loc.id)) {
//                            if (FitIn.toDouble(f.getIn()) > 0) {
//                                qty += FitIn.toDouble(f.getIn());
//                            } else {
//                                qty -= FitIn.toDouble(f.getOut());
//                            }
//
//                        }
//                    }
//
////                    String where4 = " where main_barcode ='" + to.barcode + "'   and location_id='" + loc.id + "' "
////                            + " order by location_id asc ";
////                    List<S1_inventory_barcodes.to_inventory_barcodes> my_qty = new ArrayList();
////                    //<editor-fold defaultstate="collapsed" desc=" Qty ">
////                    String s9 = "select "
////                            + "product_qty"
////                            + " from inventory_barcodes"
////                            + " " + where4;
////
////                    Statement stmt9 = conn.createStatement();
////                    ResultSet rs9 = stmt9.executeQuery(s9);
////                    double product_qty = 0;
////                    while (rs9.next()) {
////                        product_qty += rs9.getDouble(1);
////                    }
//
//                    String s10 = "update inventory_barcodes set "
//                            + " product_qty='" + qty + "'"
//                            + " where  main_barcode= '" + to.barcode + "' and location_id='" + loc.id + "' "
//                            + "";
//                    PreparedStatement stmt10 = conn.prepareStatement(s10);
//                    stmt10.execute();
//                    Lg.s(MySales.class, "Successfully Updated!");
//                    
//                    System.out.println(
//                            "   "
//                            + "[" + FitIn.fmt_woc(qty) + "] "
//                            + " | " + loc.branch + " | " + loc.location + ""
//                            + " | Count: " + inventory_count.size()
//                            + " | Sales: " + sales.size()
//                            + " | Receipts: " + receipts.size()
//                            + " | Transfer: " + transfers.size()
//                            + " | Adjustments: " + adjustments.size()
//                            + " | Return: " + return_exchange.size()
//                            + " | Charge : " + charge_in_advance.size()
//                            + " | Charge[C]: " + charge_in_advance_cancelled.size()
//                    );
//
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                } finally {
//                    MyConnection.close();
//                }
//
//            }
//
//        }
//        }
    }

    public static void main(String[] args) {
        run();
    }

    public static void main2(String[] args) {
//        List<S1_branch_locations.to_branch_locations> branch_location_list = S1_branch_locations.ret_location_where(" ");
//
//        List<to_inventory> datas = Src_item_ledger.ret_data(" ");
//        for (to_inventory to : datas) {
//            System.out.println("*******************************************************************************************************************************************************************");
//            System.out.println(to.barcode + " | " + to.description);
//            for (S1_branch_locations.to_branch_locations loc : branch_location_list) {
//
//             
//
//                  String where = " where item_code ='" + to.barcode + "'  and YEAR(date_added)='" + "2015" + "'  "
//                        + "   ";
//                String where2 = " where main_barcode ='" + to.barcode + "'  and YEAR(date_added)='" + "2015" + "' "
//                        + "  ";
//                String where3 = " where barcode ='" + to.barcode + "'   and YEAR(date_added)='" + "2015" + "' "
//                        + "  ";
//                String wheree = " where item_code ='" + to.barcode + "'  and YEAR(date_added)='" + "2015" + "'  and status=1 "
//                        + "   ";
//                
//                List<Srpt_item_ledger.field> fields = new ArrayList();
//                List<Srpt_item_ledger.field> sales = new ArrayList();//Srpt_item_ledger.sales(where);
//                List<Srpt_item_ledger.field> inventory_count = new ArrayList();// Srpt_item_ledger.inventory_encoding(where);
//                List<Srpt_item_ledger.field> receipts = new ArrayList(); //Srpt_item_ledger.receipts(where2);
//                List<Srpt_item_ledger.field> transfers = new ArrayList(); //Srpt_item_ledger.transfer(where3);
//                List<Srpt_item_ledger.field> adjustments = new ArrayList(); //Srpt_item_ledger.adjustments(where);
//                List<Srpt_item_ledger.field> return_exchange = new ArrayList(); //Srpt_item_ledger.item_replacements(where);
//                List<Srpt_item_ledger.field> charge_in_advance = new ArrayList(); //Srpt_item_ledger.charge_items(where);
//                List<Srpt_item_ledger.field> charge_in_advance_cancelled = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
//                try {
//                    Connection conn = MyConnection.connect();
//
//                    //<editor-fold defaultstate="collapsed" desc=" sales ">
//                    String s0 = "select "
//                            + "id"
//                            + ",sales_no"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",addtl_amount"
//                            + ",wtax"
//                            + " from sale_items"
//                            + " " + where;
//
//                    Statement stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery(s0);
//                    while (rs.next()) {
//                        int id = rs.getInt(1);
//                        String sales_no = rs.getString(2);
//                        String item_code = rs.getString(3);
//                        String barcode = rs.getString(4);
//                        String description = rs.getString(5);
//                        String generic_name = rs.getString(6);
//                        String item_type = rs.getString(7);
//                        String supplier_name = rs.getString(8);
//                        String supplier_id = rs.getString(9);
//                        String serial_no = rs.getString(10);
//                        double product_qty = rs.getDouble(11);
//                        String unit = rs.getString(12);
//                        double conversion = rs.getDouble(13);
//                        double selling_price = rs.getDouble(14);
//                        String date_added = rs.getString(15);
//                        String user_id = rs.getString(16);
//                        String user_screen_name = rs.getString(17);
//                        int status = rs.getInt(18);
//                        int is_vatable = rs.getInt(19);
//                        int selling_type = rs.getInt(20);
//                        String discount_name = rs.getString(21);
//                        double discount_rate = rs.getDouble(22);
//                        double discount_amount = rs.getDouble(23);
//                        String discount_customer_name = rs.getString(24);
//                        String discount_customer_id = rs.getString(25);
//                        String branch = rs.getString(26);
//                        String branch_code = rs.getString(27);
//                        String location = rs.getString(28);
//                        String location_id = rs.getString(29);
//                        String category = rs.getString(30);
//                        String category_id = rs.getString(31);
//                        String classification = rs.getString(32);
//                        String classification_id = rs.getString(33);
//                        String sub_classification = rs.getString(34);
//                        String sub_classification_id = rs.getString(35);
//                        String brand = rs.getString(36);
//                        String brand_id = rs.getString(37);
//                        String model = rs.getString(38);
//                        String model_id = rs.getString(39);
//                        double addtl_amount = rs.getDouble(40);
//                        double wtax = rs.getDouble(41);
//
//                        String transaction_type = "Sales";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = "";
//                        String out = FitIn.fmt_woc(product_qty);
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + sales_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        sales.add(field);
//
//                    }
//
//                    //</editor-fold>                    
//                    //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
//                    String s2 = "select "
//                            + "id"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + ",qty"
//                            + ",date_added"
//                            + ",user_name"
//                            + ",screen_name"
//                            + ",sheet_no"
//                            + ",status"
//                            + ",counted_by"
//                            + ",checked_by"
//                            + ",cost"
//                            + ",selling_price"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + " from encoding_inventory"
//                            + " " + where;
//
//                    Statement stmt2 = conn.createStatement();
//                    ResultSet rs2 = stmt2.executeQuery(s2);
//                    while (rs2.next()) {
//                        int id = rs2.getInt(1);
//                        String item_code = rs2.getString(2);
//                        String barcode = rs2.getString(3);
//                        String description = rs2.getString(4);
//                        String branch = rs2.getString(5);
//                        String branch_id = rs2.getString(6);
//                        String location = rs2.getString(7);
//                        String location_id = rs2.getString(8);
//                        double qty = rs2.getDouble(9);
//                        String date_added = rs2.getString(10);
//                        String user_name = rs2.getString(11);
//                        String screen_name = rs2.getString(12);
//                        String sheet_no = rs2.getString(13);
//                        int status = rs2.getInt(14);
//                        String counted_by = rs2.getString(15);
//                        String checked_by = rs2.getString(16);
//                        double cost = rs2.getDouble(17);
//                        double selling_price = rs2.getDouble(18);
//                        String user_id = rs2.getString(19);
//                        String user_screen_name = rs2.getString(20);
//
//                        String transaction_type = "Inventory Count";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_id;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + sheet_no;
//                        String cost1 = FitIn.fmt_wc_0(cost);
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//
//                        inventory_count.add(field);
//                    }
//                    //</editor-fold>                   
//                    //<editor-fold defaultstate="collapsed" desc=" Receipts ">
//                    String s3 = "select "
//                            + " id"
//                            + ",receipt_no"
//                            + ",user_name"
//                            + ",session_no"
//                            + ",date_added"
//                            + ",supplier"
//                            + ",supllier_id"
//                            + ",remarks"
//                            + ",barcode"
//                            + ",description"
//                            + ",qty"
//                            + ",cost"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_class"
//                            + ",sub_class_id"
//                            + ",conversion"
//                            + ",unit"
//                            + ",date_delivered"
//                            + ",date_received"
//                            + ",barcodes"
//                            + ",batch_no"
//                            + ",serial_no"
//                            + ",main_barcode"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",status"
//                            + ",previous_cost"
//                            + ",receipt_type_id"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + " from receipt_items"
//                            + " " + where2;
//
//                    Statement stmt3 = conn.createStatement();
//                    ResultSet rs3 = stmt3.executeQuery(s3);
//                    while (rs3.next()) {
//                        int id = rs3.getInt(1);
//                        String receipt_no = rs3.getString(2);
//                        String user_name = rs3.getString(3);
//                        String session_no = rs3.getString(4);
//                        String date_added = rs3.getString(5);
//                        String supplier = rs3.getString(6);
//                        String supllier_id = rs3.getString(7);
//                        String remarks = rs3.getString(8);
//                        String barcode = rs3.getString(9);
//                        String description = rs3.getString(10);
//                        double qty = rs3.getDouble(11);
//                        double cost = rs3.getDouble(12);
//                        String category = rs3.getString(13);
//                        String category_id = rs3.getString(14);
//                        String classification = rs3.getString(15);
//                        String classification_id = rs3.getString(16);
//                        String sub_class = rs3.getString(17);
//                        String sub_class_id = rs3.getString(18);
//                        double conversion = rs3.getDouble(19);
//                        String unit = rs3.getString(20);
//                        String date_delivered = rs3.getString(21);
//                        String date_received = rs3.getString(22);
//                        String barcodes = rs3.getString(23);
//                        String batch_no = rs3.getString(24);
//                        String serial_no = rs3.getString(25);
//                        String main_barcode = rs3.getString(26);
//                        String brand = rs3.getString(27);
//                        String brand_id = rs3.getString(28);
//                        String model = rs3.getString(29);
//                        String model_id = rs3.getString(30);
//                        int status = rs3.getInt(31);
//                        double previous_cost = rs3.getDouble(32);
//                        String receipt_type_id = rs3.getString(33);
//                        String branch = rs3.getString(34);
//                        String branch_id = rs3.getString(35);
//                        String location = rs3.getString(36);
//                        String location_id = rs3.getString(37);
//
//                        String transaction_type = "Receipts";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_id;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + receipt_no;
//                        String cost1 = FitIn.fmt_wc_0(cost);
//                        String price1 = "";
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//
//                        receipts.add(field);
//                    }
//
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Transfers ">
//                    List<Srpt_item_ledger.field> transfer_in = new ArrayList();
//                    List<Srpt_item_ledger.field> transfer_out = new ArrayList();
//                    String s4 = "select "
//                            + "id"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",user_name"
//                            + ",item_type"
//                            + ",status"
//                            + ",supplier"
//                            + ",fixed_price"
//                            + ",cost"
//                            + ",supplier_id"
//                            + ",multi_level_pricing"
//                            + ",vatable"
//                            + ",reorder_level"
//                            + ",markup"
//                            + ",barcodes"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",selling_type"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",stock_transfer_id"
//                            + ",serial_no"
//                            + ",to_branch"
//                            + ",to_branch_id"
//                            + ",to_location"
//                            + ",to_location_id"
//                            + " from stock_transfers_items"
//                            + " " + where3;
//
//                    Statement stmt4 = conn.createStatement();
//                    ResultSet rs4 = stmt4.executeQuery(s4);
//                    while (rs4.next()) {
//                        int id = rs4.getInt(1);
//                        String barcode = rs4.getString(2);
//                        String description = rs4.getString(3);
//                        String generic_name = rs4.getString(4);
//                        String category = rs4.getString(5);
//                        String category_id = rs4.getString(6);
//                        String classification = rs4.getString(7);
//                        String classification_id = rs4.getString(8);
//                        String sub_classification = rs4.getString(9);
//                        String sub_classification_id = rs4.getString(10);
//                        double product_qty = rs4.getDouble(11);
//                        String unit = rs4.getString(12);
//                        double conversion = rs4.getDouble(13);
//                        double selling_price = rs4.getDouble(14);
//                        String date_added = rs4.getString(15);
//                        String user_name = rs4.getString(16);
//                        String item_type = rs4.getString(17);
//                        int status = rs4.getInt(18);
//                        String supplier = rs4.getString(19);
//                        int fixed_price = rs4.getInt(20);
//                        double cost = rs4.getDouble(21);
//                        String supplier_id = rs4.getString(22);
//                        int multi_level_pricing = rs4.getInt(23);
//                        int vatable = rs4.getInt(24);
//                        double reorder_level = rs4.getDouble(25);
//                        double markup = rs4.getDouble(26);
//                        String barcodes = rs4.getString(27);
//                        String brand = rs4.getString(28);
//                        String brand_id = rs4.getString(29);
//                        String model = rs4.getString(30);
//                        String model_id = rs4.getString(31);
//                        int selling_type = rs4.getInt(32);
//                        String branch = rs4.getString(33);
//                        String branch_code = rs4.getString(34);
//                        String location = rs4.getString(35);
//                        String location_id = rs4.getString(36);
//                        String stock_transfer_id = rs4.getString(37);
//                        String serial_no = rs4.getString(38);
//                        String to_branch = rs4.getString(39);
//                        String to_branch_id = rs4.getString(40);
//                        String to_location = rs4.getString(41);
//                        String to_location_id = rs4.getString(42);
//
//                        String transaction_type = "Transfer";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(product_qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch1 = "";
//                        String to_branch_id1 = "";
//                        String to_location1 = "";
//                        String to_location_id1 = "";
//                        String created_by = user_name;
//                        String customer_name = "";
//                        Date created = new Date();
//
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                        String transaction_no = "" + stock_transfer_id;
//                        String cost1 = FitIn.fmt_wc_0(cost);
//                        String price1 = "";
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field_out = new Srpt_item_ledger.field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        transfer_in.add(field_out);
//
//                        Srpt_item_ledger.field field_in = new Srpt_item_ledger.field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        transfer_out.add(field_in);
//
//                    }
//                    transfers.addAll(transfer_in);
//                    transfers.addAll(transfer_out);
//
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
//                    List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
//                    List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();
//                    String s5 = "select "
//                            + "id"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",qty"
//                            + ",new_qty"
//                            + ",is_add"
//                            + ",date_added"
//                            + ",status"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + " from adjustments"
//                            + " " + where;
//
//                    Statement stmt5 = conn.createStatement();
//                    ResultSet rs5 = stmt5.executeQuery(s5);
//                    while (rs5.next()) {
//                        int id = rs5.getInt(1);
//                        String item_code = rs5.getString(2);
//                        String barcode = rs5.getString(3);
//                        String description = rs5.getString(4);
//                        double qty = rs5.getDouble(5);
//                        double new_qty = rs5.getDouble(6);
//                        int is_add = rs5.getInt(7);
//                        String date_added = rs5.getString(8);
//                        int status = rs5.getInt(9);
//                        String user_id = rs5.getString(10);
//                        String user_screen_name = rs5.getString(11);
//                        String branch = rs5.getString(12);
//                        String branch_id = rs5.getString(13);
//                        String location = rs5.getString(14);
//                        String location_id = rs5.getString(15);
//
//                        String transaction_type = "Adjustment";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(new_qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_id;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + id;
//                        String cost1 = "";
//                        String price1 = "";
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        if (is_add == 1) {
//                            Srpt_item_ledger.field add = new Srpt_item_ledger.field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                            adjustment_add.add(add);
//                        } else {
//                            Srpt_item_ledger.field deduct = new Srpt_item_ledger.field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                            adjustment_deduct.add(deduct);
//                        }
//
//                    }
//                    adjustments.addAll(adjustment_add);
//                    adjustments.addAll(adjustment_deduct);
//
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Return Exchange ">
//                    String s6 = "select "
//                            + "id"
//                            + ",sales_no"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",user_id"
//                            + ",user_screen_name"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",is_replacement"
//                            + " from sale_item_replacements"
//                            + " " + where;
//                    Statement stmt6 = conn.createStatement();
//                    ResultSet rs6 = stmt6.executeQuery(s6);
//                    while (rs6.next()) {
//                        int id = rs6.getInt(1);
//                        String sales_no = rs6.getString(2);
//                        String item_code = rs6.getString(3);
//                        String barcode = rs6.getString(4);
//                        String description = rs6.getString(5);
//                        String generic_name = rs6.getString(6);
//                        String item_type = rs6.getString(7);
//                        String supplier_name = rs6.getString(8);
//                        String supplier_id = rs6.getString(9);
//                        String serial_no = rs6.getString(10);
//                        double product_qty = rs6.getDouble(11);
//                        String unit = rs6.getString(12);
//                        double conversion = rs6.getDouble(13);
//                        double selling_price = rs6.getDouble(14);
//                        String date_added = rs6.getString(15);
//                        String user_id = rs6.getString(16);
//                        String user_screen_name = rs6.getString(17);
//                        int status = rs6.getInt(18);
//                        int is_vatable = rs6.getInt(19);
//                        int selling_type = rs6.getInt(20);
//                        String discount_name = rs6.getString(21);
//                        double discount_rate = rs6.getDouble(22);
//                        double discount_amount = rs6.getDouble(23);
//                        String discount_customer_name = rs6.getString(24);
//                        String discount_customer_id = rs6.getString(25);
//                        String branch = rs6.getString(26);
//                        String branch_code = rs6.getString(27);
//                        String location = rs6.getString(28);
//                        String location_id = rs6.getString(29);
//                        String category = rs6.getString(30);
//                        String category_id = rs6.getString(31);
//                        String classification = rs6.getString(32);
//                        String classification_id = rs6.getString(33);
//                        String sub_classification = rs6.getString(34);
//                        String sub_classification_id = rs6.getString(35);
//                        String brand = rs6.getString(36);
//                        String brand_id = rs6.getString(37);
//                        String model = rs6.getString(38);
//                        String model_id = rs6.getString(39);
//                        int is_replacement = rs6.getInt(40);
//
//                        String transaction_type = "Exc-Replacement";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = "";
//                        String out = FitIn.fmt_woc(product_qty);
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        String customer_name = "";
//                        Date created = new Date();
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + sales_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                        if (is_replacement == 0) {
//                            transaction_type = "Exc-Returned";
//                            in = FitIn.fmt_woc(product_qty);
//                            out = "";
//                        }
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        return_exchange.add(field);
//
//                    }
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Charge in Advance ">
//                    String s7 = "select "
//                            + "id"
//                            + ",customer_id"
//                            + ",customer_name"
//                            + ",ar_id"
//                            + ",ar_no"
//                            + ",date_applied"
//                            + ",reference_no"
//                            + ",soa_type"
//                            + ",soa_type_id"
//                            + ",user_screen_name"
//                            + ",user_id"
//                            + ",remarks"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",addtl_amount"
//                            + ",wtax"
//                            + " from charge_in_advance_items"
//                            + " " + where;
//
//                    Statement stmt7 = conn.createStatement();
//                    ResultSet rs7 = stmt7.executeQuery(s7);
//                    while (rs7.next()) {
//                        int id = rs7.getInt(1);
//                        String customer_id = rs7.getString(2);
//                        String customer_name = rs7.getString(3);
//                        String ar_id = rs7.getString(4);
//                        String ar_no = rs7.getString(5);
//                        String date_applied = rs7.getString(6);
//                        String reference_no = rs7.getString(7);
//                        String soa_type = rs7.getString(8);
//                        String soa_type_id = rs7.getString(9);
//                        String user_screen_name = rs7.getString(10);
//                        String user_id = rs7.getString(11);
//                        String remarks = rs7.getString(12);
//                        String item_code = rs7.getString(13);
//                        String barcode = rs7.getString(14);
//                        String description = rs7.getString(15);
//                        String generic_name = rs7.getString(16);
//                        String item_type = rs7.getString(17);
//                        String supplier_name = rs7.getString(18);
//                        String supplier_id = rs7.getString(19);
//                        String serial_no = rs7.getString(20);
//                        double product_qty = rs7.getDouble(21);
//                        String unit = rs7.getString(22);
//                        double conversion = rs7.getDouble(23);
//                        double selling_price = rs7.getDouble(24);
//                        String date_added = rs7.getString(25);
//                        int status = rs7.getInt(26);
//                        int is_vatable = rs7.getInt(27);
//                        int selling_type = rs7.getInt(28);
//                        String discount_name = rs7.getString(29);
//                        double discount_rate = rs7.getDouble(30);
//                        double discount_amount = rs7.getDouble(31);
//                        String discount_customer_name = rs7.getString(32);
//                        String discount_customer_id = rs7.getString(33);
//                        String branch = rs7.getString(34);
//                        String branch_code = rs7.getString(35);
//                        String location = rs7.getString(36);
//                        String location_id = rs7.getString(37);
//                        String category = rs7.getString(38);
//                        String category_id = rs7.getString(39);
//                        String classification = rs7.getString(40);
//                        String classification_id = rs7.getString(41);
//                        String sub_classification = rs7.getString(42);
//                        String sub_classification_id = rs7.getString(43);
//                        String brand = rs7.getString(44);
//                        String brand_id = rs7.getString(45);
//                        String model = rs7.getString(46);
//                        String model_id = rs7.getString(47);
//                        double addtl_amount = rs7.getDouble(48);
//                        double wtax = rs7.getDouble(49);
//
//                        String transaction_type = "Charge in Advance";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = "";
//                        String out = FitIn.fmt_woc(product_qty);
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        Date created = new Date();
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + ar_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        charge_in_advance.add(field);
//                    }
//                    //</editor-fold>
//                    //<editor-fold defaultstate="collapsed" desc=" Charge in advance[-] ">
//                    String s8 = "select "
//                            + "id"
//                            + ",customer_id"
//                            + ",customer_name"
//                            + ",ar_id"
//                            + ",ar_no"
//                            + ",date_applied"
//                            + ",reference_no"
//                            + ",soa_type"
//                            + ",soa_type_id"
//                            + ",user_screen_name"
//                            + ",user_id"
//                            + ",remarks"
//                            + ",item_code"
//                            + ",barcode"
//                            + ",description"
//                            + ",generic_name"
//                            + ",item_type"
//                            + ",supplier_name"
//                            + ",supplier_id"
//                            + ",serial_no"
//                            + ",product_qty"
//                            + ",unit"
//                            + ",conversion"
//                            + ",selling_price"
//                            + ",date_added"
//                            + ",status"
//                            + ",is_vatable"
//                            + ",selling_type"
//                            + ",discount_name"
//                            + ",discount_rate"
//                            + ",discount_amount"
//                            + ",discount_customer_name"
//                            + ",discount_customer_id"
//                            + ",branch"
//                            + ",branch_code"
//                            + ",location"
//                            + ",location_id"
//                            + ",category"
//                            + ",category_id"
//                            + ",classification"
//                            + ",classification_id"
//                            + ",sub_classification"
//                            + ",sub_classification_id"
//                            + ",brand"
//                            + ",brand_id"
//                            + ",model"
//                            + ",model_id"
//                            + ",addtl_amount"
//                            + ",wtax"
//                            + " from charge_in_advance_cancelled_items"
//                            + " " + where;
//
//                    Statement stmt8 = conn.createStatement();
//                    ResultSet rs8 = stmt8.executeQuery(s8);
//                    while (rs8.next()) {
//                        int id = rs8.getInt(1);
//                        String customer_id = rs8.getString(2);
//                        String customer_name = rs8.getString(3);
//                        String ar_id = rs8.getString(4);
//                        String ar_no = rs8.getString(5);
//                        String date_applied = rs8.getString(6);
//                        String reference_no = rs8.getString(7);
//                        String soa_type = rs8.getString(8);
//                        String soa_type_id = rs8.getString(9);
//                        String user_screen_name = rs8.getString(10);
//                        String user_id = rs8.getString(11);
//                        String remarks = rs8.getString(12);
//                        String item_code = rs8.getString(13);
//                        String barcode = rs8.getString(14);
//                        String description = rs8.getString(15);
//                        String generic_name = rs8.getString(16);
//                        String item_type = rs8.getString(17);
//                        String supplier_name = rs8.getString(18);
//                        String supplier_id = rs8.getString(19);
//                        String serial_no = rs8.getString(20);
//                        double product_qty = rs8.getDouble(21);
//                        String unit = rs8.getString(22);
//                        double conversion = rs8.getDouble(23);
//                        double selling_price = rs8.getDouble(24);
//                        String date_added = rs8.getString(25);
//                        int status = rs8.getInt(26);
//                        int is_vatable = rs8.getInt(27);
//                        int selling_type = rs8.getInt(28);
//                        String discount_name = rs8.getString(29);
//                        double discount_rate = rs8.getDouble(30);
//                        double discount_amount = rs8.getDouble(31);
//                        String discount_customer_name = rs8.getString(32);
//                        String discount_customer_id = rs8.getString(33);
//                        String branch = rs8.getString(34);
//                        String branch_code = rs8.getString(35);
//                        String location = rs8.getString(36);
//                        String location_id = rs8.getString(37);
//                        String category = rs8.getString(38);
//                        String category_id = rs8.getString(39);
//                        String classification = rs8.getString(40);
//                        String classification_id = rs8.getString(41);
//                        String sub_classification = rs8.getString(42);
//                        String sub_classification_id = rs8.getString(43);
//                        String brand = rs8.getString(44);
//                        String brand_id = rs8.getString(45);
//                        String model = rs8.getString(46);
//                        String model_id = rs8.getString(47);
//                        double addtl_amount = rs8.getDouble(48);
//                        double wtax = rs8.getDouble(49);
//
//                        String transaction_type = "Charge in Adv. [X]";
//                        String date = DateType.convert_slash_datetime3(date_added);
//                        String in = FitIn.fmt_woc(product_qty);
//                        String out = "";
//                        String balance = "";
//                        String from_branch = branch;
//                        String from_branch_id = branch_code;
//                        String from_location = location;
//                        String from_location_id = location_id;
//                        String to_branch = "";
//                        String to_branch_id = "";
//                        String to_location = "";
//                        String to_location_id = "";
//                        String created_by = user_screen_name;
//                        Date created = new Date();
//                        try {
//                            created = DateType.datetime.parse(date_added);
//                        } catch (ParseException ex) {
//                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        String transaction_no = "" + ar_no;
//                        String cost1 = "";
//                        String price1 = FitIn.fmt_wc_0(selling_price);
//                          String months=DateType.convert_datetime_to_month(date_added);
//                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1,months);
//                        charge_in_advance_cancelled.add(field);
//                    }
//
//                    //</editor-fold>
//                    
//                    fields.addAll(inventory_count);
//                    fields.addAll(sales);
//                    fields.addAll(receipts);
//                    fields.addAll(transfers);
//                    fields.addAll(adjustments);
//                    fields.addAll(return_exchange);
//                    fields.addAll(charge_in_advance);
//                    fields.addAll(charge_in_advance_cancelled);
//
//                    Collections.sort(fields, new Comparator<Srpt_item_ledger.field>() {
//                        @Override
//                        public int compare(Srpt_item_ledger.field o1, Srpt_item_ledger.field o2) {
//                            return o1.getDate_added().compareTo(o2.getDate_added());
//                        }
//                    });
//
//                    double qty = 0;
//                    for (Srpt_item_ledger.field f : fields) {
//                        if (FitIn.toDouble(f.getIn()) > 0) {
//                            qty += FitIn.toDouble(f.getIn());
//                        } else {
//                            qty -= FitIn.toDouble(f.getOut());
//                        }
//                    }
//
//                    String where4 = " where main_barcode ='" + to.barcode + "'   and location_id='" + loc.id + "' "
//                            + " order by location_id asc ";
//                    List<Inventory_barcodes.to_inventory_barcodes> my_qty = new ArrayList();
//                    //<editor-fold defaultstate="collapsed" desc=" Qty ">
//                    String s9 = "select "
//                            + " product_qty"
//                            + " from inventory_barcodes"
//                            + " " + where4;
//
//                    Statement stmt9 = conn.createStatement();
//                    ResultSet rs9 = stmt9.executeQuery(s9);
//                    double product_qty = 0;
//                    while (rs9.next()) {
//                        product_qty += rs9.getDouble(1);
//                    }
//                    
//                    String s10 = "update inventory_barcodes set "
//                            + "product_qty='" + product_qty + "'"
//                            + " where  main_barcode= '" + to.barcode + "' and location_id='" + loc.id + "' "
//                            + "";
//                    PreparedStatement stmt10 = conn.prepareStatement(s10);
//                    stmt10.execute();
//                    Lg.s(MySales.class, "Successfully Updated!");
//                    System.out.println(
//                            "   "
//                            + "[" + FitIn.fmt_woc(qty) + " - " + FitIn.fmt_woc(product_qty) + "] "
//                            + " | " + loc.branch + " | " + loc.location + ""
//                            + " | Count: " + inventory_count.size()
//                            + " | Sales: " + sales.size()
//                            + " | Receipts: " + receipts.size()
//                            + " | Transfer: " + transfers.size()
//                            + " | Adjustments: " + adjustments.size()
//                            + " | Return: " + return_exchange.size()
//                            + " | Charge : " + charge_in_advance.size()
//                            + " | Charge[C]: " + charge_in_advance_cancelled.size()
//                    );
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                } finally {
//                    MyConnection.close();
//                }
//
//            }
//
//        }
    }

    public static List<to_inventory> ret_data(String where) {
        List<to_inventory> datas = new ArrayList();

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
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",barcodes"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + " from inventory "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int barcode = rs.getInt(2);
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
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                String barcodes = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                int is_uploaded = rs.getInt(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                to_inventory to = new to_inventory(id, "" + barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded,allow_negative_inventory,auto_order);
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
