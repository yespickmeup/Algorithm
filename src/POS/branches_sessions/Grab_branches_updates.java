/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;

import POS.accounts_receivable.S1_accounts_receivable;
import static POS.accounts_receivable.S1_accounts_receivable.ret_customer_balance;
import POS.accounts_receivable.S1_sales_on_account;
import POS.customers.Customers;
import POS.inventory.Inventory_barcodes;
import POS.users.MyUser;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.Segregator;
import POS.util.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Grab_branches_updates {

    public static void replenishments(List<Parse_inventory_replenishments> l_replenishments) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            //<editor-fold defaultstate="collapsed" desc=" Replenishments ">
            System.out.println("Item Replacement in progress.......... " + l_replenishments.size());
            for (Parse_inventory_replenishments to_inventory_replenishments : l_replenishments) {
                String s0 = "insert into inventory_replenishments("
                        + "inventory_replenishment_no"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",remarks"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":inventory_replenishment_no"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:remarks"
                        + ",:status"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("inventory_replenishment_no", to_inventory_replenishments.inventory_replenishment_no)
                        .setString("date_added", to_inventory_replenishments.date_added)
                        .setString("user_id", to_inventory_replenishments.user_id)
                        .setString("user_screen_name", to_inventory_replenishments.user_screen_name)
                        .setString("remarks", to_inventory_replenishments.remarks)
                        .setNumber("status", to_inventory_replenishments.status)
                        .setString("branch", to_inventory_replenishments.branch)
                        .setString("branch_id", to_inventory_replenishments.branch_id)
                        .setString("location", to_inventory_replenishments.location)
                        .setString("location_id", to_inventory_replenishments.location_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.addBatch(s0);

                for (Parse_inventory_replenishments.items to_inventory_replenishment_items : to_inventory_replenishments.items) {

                    String s2 = "insert into inventory_replenishment_items("
                            + "inventory_replenishment_no"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
                            + ",user_id"
                            + ",user_screen_name"
                            + ",status"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + ")values("
                            + ":inventory_replenishment_no"
                            + ",:item_code"
                            + ",:barcode"
                            + ",:description"
                            + ",:product_qty"
                            + ",:unit"
                            + ",:conversion"
                            + ",:selling_price"
                            + ",:date_added"
                            + ",:user_id"
                            + ",:user_screen_name"
                            + ",:status"
                            + ",:branch"
                            + ",:branch_id"
                            + ",:location"
                            + ",:location_id"
                            + ")";

                    double qty = to_inventory_replenishment_items.product_qty;
                    if (qty == 0) {
                        qty = 0;
                    } else if (qty > 0) {

                    } else {

                    }
                    s2 = SqlStringUtil.parse(s2)
                            .setString("inventory_replenishment_no", to_inventory_replenishments.inventory_replenishment_no)
                            .setString("item_code", to_inventory_replenishment_items.item_code)
                            .setString("barcode", to_inventory_replenishment_items.barcode)
                            .setString("description", to_inventory_replenishment_items.description)
                            .setNumber("product_qty", qty)
                            .setString("unit", to_inventory_replenishment_items.unit)
                            .setNumber("conversion", to_inventory_replenishment_items.conversion)
                            .setNumber("selling_price", to_inventory_replenishment_items.selling_price)
                            .setString("date_added", to_inventory_replenishments.date_added)
                            .setString("user_id", to_inventory_replenishments.user_id)
                            .setString("user_screen_name", to_inventory_replenishments.user_screen_name)
                            .setNumber("status", 1)
                            .setString("branch", to_inventory_replenishments.branch)
                            .setString("branch_id", to_inventory_replenishments.branch_id)
                            .setString("location", to_inventory_replenishments.location)
                            .setString("location_id", to_inventory_replenishments.location_id)
                            .ok();

                    stmt.addBatch(s2);

                    String s4 = "update inventory_barcodes set "
                            + " product_qty='" + 0 + "'"
                            + " where  main_barcode= '" + to_inventory_replenishment_items.item_code + "' and location_id='" + to_inventory_replenishments.location_id + "' "
                            + "";
                    stmt.addBatch(s4);
                }
                stmt.executeBatch();
                conn.commit();
                System.out.println("Item Replenishments Updated!");
            }
            //</editor-fold>
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void inventory_count(List<Parse_inventory_counts.field> l_inventory_counts) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
            System.out.println("Inventory Count in progress.......... " + l_inventory_counts.size());
            for (Parse_inventory_counts.field to_encoding_inventory : l_inventory_counts) {

                double my_qty = 0;
                String unit = "";
                double conversion = 0;
                String description = "";
                String s3 = "select"
                        + " product_qty"
                        + " ,unit"
                        + " ,conversion"
                        + " ,description"
                        + " from inventory_barcodes where "
                        + "  main_barcode ='" + to_encoding_inventory.item_code + "' "
                        + " and location_id ='" + to_encoding_inventory.location_id + "' "
                        + " ";
                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                if (rs3.next()) {
                    my_qty = rs3.getDouble(1);
                    unit = rs3.getString(2);
                    conversion = rs3.getDouble(3);
                    description = rs3.getString(4);
                }

                String s0 = "insert into encoding_inventory("
                        + "item_code"
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
                        + ",user_id"
                        + ",user_screen_name"
                        + ")values("
                        + ":item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:qty"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:screen_name"
                        + ",:sheet_no"
                        + ",:status"
                        + ",:counted_by"
                        + ",:checked_by"
                        + ",:cost"
                        + ",:selling_price"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("item_code", to_encoding_inventory.item_code).
                        setString("barcode", to_encoding_inventory.barcode).
                        setString("description", description).
                        setString("branch", to_encoding_inventory.branch).
                        setString("branch_id", to_encoding_inventory.branch_id).
                        setString("location", to_encoding_inventory.location).
                        setString("location_id", to_encoding_inventory.location_id).
                        setNumber("qty", to_encoding_inventory.qty).
                        setString("date_added", to_encoding_inventory.date_added).
                        setString("user_name", to_encoding_inventory.user_name).
                        setString("screen_name", to_encoding_inventory.screen_name).
                        setString("sheet_no", to_encoding_inventory.sheet_no).
                        setNumber("status", to_encoding_inventory.status).
                        setString("counted_by", to_encoding_inventory.counted_by).
                        setString("checked_by", to_encoding_inventory.checked_by).
                        setNumber("cost", to_encoding_inventory.cost).
                        setNumber("selling_price", to_encoding_inventory.selling_price).
                        setString("user_id", to_encoding_inventory.user_id).
                        setString("user_screen_name", to_encoding_inventory.user_screen_name).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                double new_qty = my_qty + to_encoding_inventory.qty;

                String s12 = " update inventory_barcodes set "
                        + " product_qty= :product_qty"
                        + " where "
                        + " main_barcode ='" + to_encoding_inventory.item_code + "' "
                        + " and location_id='" + to_encoding_inventory.location_id + "'"
                        + " ";
                s12 = SqlStringUtil.parse(s12)
                        .setNumber("product_qty", new_qty)
                        .ok();
                PreparedStatement stmt12 = conn.prepareStatement(s12);
                stmt12.execute();

                String s2 = " update inventory_barcodes set "
                        + " unit= :unit"
                        + " ,conversion= :conversion"
                        + " ,selling_price= :selling_price"
                        + " ,cost= :cost"
                        + " where "
                        + " main_barcode ='" + to_encoding_inventory.item_code + "' "
                        + " and branch_code='" + to_encoding_inventory.branch_id + "'"
                        + " ";
                String units = "[" + "pc" + ":" + to_encoding_inventory.selling_price + "/" + conversion + "^1" + "]";
                s2 = SqlStringUtil.parse(s2)
                        .setString("unit", units)
                        .setNumber("conversion", conversion)
                        .setNumber("selling_price", to_encoding_inventory.selling_price)
                        .setNumber("cost", to_encoding_inventory.cost)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

            }
            System.out.println("Inventory Encoding Updated!");
            //</editor-fold>
            conn.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void adjustments(List<Parse_inventory_adjustments.field> l_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
            System.out.println("Adjustments in progress.......... " + l_adjustments.size());
            for (Parse_inventory_adjustments.field to_inventory_barcodes : l_adjustments) {

                double my_qty = 0;
                String unit = "";
                double conversion = 0;
                String description = "";
                String s3 = "select"
                        + " product_qty"
                        + " ,unit"
                        + " ,conversion"
                        + " ,description"
                        + " from inventory_barcodes "
                        + " where "
                        + "  main_barcode ='" + to_inventory_barcodes.item_code + "' "
                        + " and location_id ='" + to_inventory_barcodes.location_id + "' "
                        + " ";
                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                if (rs3.next()) {
                    my_qty = rs3.getDouble(1);
                    unit = rs3.getString(2);
                    conversion = rs3.getDouble(3);
                    description = rs3.getString(4);
                }

                String transaction_no = "";
                double my_qty1 = 0;
                if (to_inventory_barcodes.is_add == 1) {
                    my_qty1 = my_qty + to_inventory_barcodes.new_qty;
                } else {
                    my_qty1 = my_qty - to_inventory_barcodes.new_qty;
                }

                String s2 = "insert into adjustments("
                        + "item_code"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",new_qty"
                        + ",is_add"
                        + ",date_added"
                        + ",status"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",remarks"
                        + ",transaction_no"
                        + ")values("
                        + ":item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:new_qty"
                        + ",:is_add"
                        + ",:date_added"
                        + ",:status"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:remarks"
                        + ",transaction_no"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("item_code", to_inventory_barcodes.item_code)
                        .setString("barcode", to_inventory_barcodes.barcode)
                        .setString("description", description)
                        .setNumber("qty", my_qty)
                        .setNumber("new_qty", to_inventory_barcodes.new_qty)
                        .setNumber("is_add", to_inventory_barcodes.is_add)
                        .setString("date_added", DateType.now())
                        .setNumber("status", 1)
                        .setString("user_id", MyUser.getUser_id())
                        .setString("user_screen_name", MyUser.getUser_screen_name())
                        .setString("branch", to_inventory_barcodes.branch)
                        .setString("branch_id", to_inventory_barcodes.branch_id)
                        .setString("location", to_inventory_barcodes.location)
                        .setString("location_id", to_inventory_barcodes.location_id)
                        .setString("remarks", to_inventory_barcodes.remarks)
                        .setString("transaction_no", transaction_no)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.addBatch(s2);

                String s0 = "update inventory_barcodes set "
                        + " product_qty= :product_qty "
                        + " where "
                        + "  main_barcode ='" + to_inventory_barcodes.item_code + "' "
                        + " and location_id ='" + to_inventory_barcodes.location_id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setNumber("product_qty", my_qty1)
                        .ok();

                stmt2.addBatch(s0);

                stmt2.executeBatch();

            }
            //</editor-fold>
            System.out.println("Adjustments Updated!");
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void stock_transfers(List<Parse_stock_transfers> l_stock_transfers) {
        try {

            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            //<editor-fold defaultstate="collapsed" desc=" Stock Transfers ">
            System.out.println("Stock transfer in progress.......... " + l_stock_transfers.size());
            for (Parse_stock_transfers to_stock_transfers : l_stock_transfers) {
                String s0 = "insert into stock_transfers("
                        + "transaction_no"
                        + ",user_name"
                        + ",date_added"
                        + ",remarks"
                        + ",to_branch"
                        + ",to_branch_id"
                        + ",to_location"
                        + ",to_location_id"
                        + ",from_branch"
                        + ",from_branch_id"
                        + ",from_location"
                        + ",from_location_id"
                        + ",status"
                        + ",at_branch"
                        + ",at_branch_id"
                        + ",at_location"
                        + ",at_location_id"
                        + ")values("
                        + ":transaction_no"
                        + ",:user_name"
                        + ",:date_added"
                        + ",:remarks"
                        + ",:to_branch"
                        + ",:to_branch_id"
                        + ",:to_location"
                        + ",:to_location_id"
                        + ",:from_branch"
                        + ",:from_branch_id"
                        + ",:from_location"
                        + ",:from_location_id"
                        + ",:status"
                        + ",:at_branch"
                        + ",:at_branch_id"
                        + ",:at_location"
                        + ",:at_location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("transaction_no", to_stock_transfers.transaction_no)
                        .setString("user_name", to_stock_transfers.user_name)
                        .setString("date_added", to_stock_transfers.date_added)
                        .setString("remarks", to_stock_transfers.remarks)
                        .setString("to_branch", to_stock_transfers.to_branch)
                        .setString("to_branch_id", to_stock_transfers.to_branch_id)
                        .setString("to_location", to_stock_transfers.to_location)
                        .setString("to_location_id", to_stock_transfers.to_location_id)
                        .setString("from_branch", to_stock_transfers.from_branch)
                        .setString("from_branch_id", to_stock_transfers.from_branch_id)
                        .setString("from_location", to_stock_transfers.from_location)
                        .setString("from_location_id", to_stock_transfers.from_location_id)
                        .setNumber("status", 0)
                        .setString("at_branch", to_stock_transfers.at_branch)
                        .setString("at_branch_id", to_stock_transfers.at_branch_id)
                        .setString("at_location", to_stock_transfers.at_location)
                        .setString("at_location_id", to_stock_transfers.at_location_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.addBatch(s0);

                for (Parse_stock_transfers.items to_stock_transfers_items : to_stock_transfers.items1) {

                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_stock_transfers_items.item_code, to_stock_transfers_items.barcode, to_stock_transfers.at_location_id);
                    if (tt == null) {
                        return;
                    }
                    String s2 = "insert into stock_transfers_items("
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
                            + ",stock_transfer_id"
                            + ",serial_no"
                            + ",to_branch"
                            + ",to_branch_id"
                            + ",to_location"
                            + ",to_location_id"
                            + ",at_branch"
                            + ",at_branch_id"
                            + ",at_location"
                            + ",at_location_id"
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
                            + ",:supplier"
                            + ",:fixed_price"
                            + ",:cost"
                            + ",:supplier_id"
                            + ",:multi_level_pricing"
                            + ",:vatable"
                            + ",:reorder_level"
                            + ",:markup"
                            + ",:barcodes"
                            + ",:brand"
                            + ",:brand_id"
                            + ",:model"
                            + ",:model_id"
                            + ",:selling_type"
                            + ",:branch"
                            + ",:branch_code"
                            + ",:location"
                            + ",:location_id"
                            + ",:stock_transfer_id"
                            + ",:serial_no"
                            + ",:to_branch"
                            + ",:to_branch_id"
                            + ",:to_location"
                            + ",:to_location_id"
                            + ",:at_branch"
                            + ",:at_branch_id"
                            + ",:at_location"
                            + ",:at_location_id"
                            + ")";

                    s2 = SqlStringUtil.parse(s2)
                            .setString("barcode", to_stock_transfers_items.item_code)
                            .setString("description", tt.description)
                            .setString("generic_name", tt.generic_name)
                            .setString("category", tt.category)
                            .setString("category_id", tt.category_id)
                            .setString("classification", tt.classification)
                            .setString("classification_id", tt.classification_id)
                            .setString("sub_classification", tt.sub_classification)
                            .setString("sub_classification_id", tt.sub_classification_id)
                            .setNumber("product_qty", to_stock_transfers_items.product_qty)
                            .setString("unit", to_stock_transfers_items.unit)
                            .setNumber("conversion", to_stock_transfers_items.conversion)
                            .setNumber("selling_price", to_stock_transfers_items.selling_price)
                            .setString("date_added", tt.date_added)
                            .setString("user_name", tt.user_name)
                            .setString("item_type", tt.item_type)
                            .setNumber("status", 0)
                            .setString("supplier", tt.supplier)
                            .setNumber("fixed_price", tt.fixed_price)
                            .setNumber("cost", to_stock_transfers_items.cost)
                            .setString("supplier_id", tt.supplier_id)
                            .setNumber("multi_level_pricing", tt.multi_level_pricing)
                            .setNumber("vatable", tt.vatable)
                            .setNumber("reorder_level", tt.reorder_level)
                            .setNumber("markup", tt.markup)
                            .setString("barcodes", tt.barcode)
                            .setString("brand", tt.brand)
                            .setString("brand_id", tt.brand_id)
                            .setString("model", tt.model)
                            .setString("model_id", tt.model_id)
                            .setNumber("selling_type", tt.selling_type)
                            .setString("branch", to_stock_transfers.from_branch)
                            .setString("branch_code", to_stock_transfers.from_branch_id)
                            .setString("location", to_stock_transfers.from_location)
                            .setString("location_id", to_stock_transfers.from_location_id)
                            .setString("stock_transfer_id", to_stock_transfers.transaction_no)
                            .setString("serial_no", to_stock_transfers_items.serial_nos)
                            .setString("to_branch", to_stock_transfers.to_branch)
                            .setString("to_branch_id", to_stock_transfers.to_branch_id)
                            .setString("to_location", to_stock_transfers.to_location)
                            .setString("to_location_id", to_stock_transfers.to_location_id)
                            .setString("at_branch", to_stock_transfers.at_branch)
                            .setString("at_branch_id", to_stock_transfers.at_branch_id)
                            .setString("at_location", to_stock_transfers.at_location)
                            .setString("at_location_id", to_stock_transfers.at_location_id)
                            .ok();
                    stmt.addBatch(s2);
                }

                stmt.executeBatch();

            }

            //</editor-fold>
            System.out.println("Stock Transfer Updated!");
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void sales(List<Parse_sales.field> l_sales) {
        try {

            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            System.out.println("Sales in progress.......... " + l_sales.size());
            //<editor-fold defaultstate="collapsed" desc=" sales ">
            for (Parse_sales.field to_sales : l_sales) {

                String s0 = "insert into sales("
                        + "sales_no"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",session_no"
                        + ",remarks"
                        + ",gross_amount"
                        + ",amount_due"
                        + ",status"
                        + ",sales_type"
                        + ",line_discount"
                        + ",customer_id"
                        + ",customer_name"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",charge_type"
                        + ",charge_type_id"
                        + ",charge_reference_no"
                        + ",charge_customer_name"
                        + ",charge_customer_id"
                        + ",charge_amount"
                        + ",check_bank"
                        + ",check_no"
                        + ",check_amount"
                        + ",check_holder"
                        + ",check_date"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",credit_card_amount"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_approval_code"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",gift_certificate_amount"
                        + ",prepaid_customer_name"
                        + ",prepaid_customer_id"
                        + ",prepaid_amount"
                        + ",addtl_amount"
                        + ",wtax"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":sales_no"
                        + ",:date_added"
                        + ",:user_screen_name"
                        + ",:user_id"
                        + ",:session_no"
                        + ",:remarks"
                        + ",:gross_amount"
                        + ",:amount_due"
                        + ",:status"
                        + ",:sales_type"
                        + ",:line_discount"
                        + ",:customer_id"
                        + ",:customer_name"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:charge_type"
                        + ",:charge_type_id"
                        + ",:charge_reference_no"
                        + ",:charge_customer_name"
                        + ",:charge_customer_id"
                        + ",:charge_amount"
                        + ",:check_bank"
                        + ",:check_no"
                        + ",:check_amount"
                        + ",:check_holder"
                        + ",:check_date"
                        + ",:credit_card_type"
                        + ",:credit_card_rate"
                        + ",:credit_card_amount"
                        + ",:credit_card_no"
                        + ",:credit_card_holder"
                        + ",:credit_card_approval_code"
                        + ",:gift_certificate_from"
                        + ",:gift_certificate_description"
                        + ",:gift_certificate_no"
                        + ",:gift_certificate_amount"
                        + ",:prepaid_customer_name"
                        + ",:prepaid_customer_id"
                        + ",:prepaid_amount"
                        + ",:addtl_amount"
                        + ",:wtax"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("sales_no", to_sales.sales_no)
                        .setString("date_added", to_sales.date_added)
                        .setString("user_screen_name", to_sales.user_screen_name)
                        .setString("user_id", to_sales.user_id)
                        .setString("session_no", to_sales.session_no)
                        .setString("remarks", to_sales.remarks)
                        .setNumber("gross_amount", to_sales.gross_amount)
                        .setNumber("amount_due", to_sales.amount_due)
                        .setNumber("status", to_sales.status)
                        .setNumber("sales_type", to_sales.sales_type)
                        .setNumber("line_discount", to_sales.line_discount)
                        .setString("customer_id", to_sales.customer_id)
                        .setString("customer_name", to_sales.customer_name)
                        .setString("discount_name", to_sales.discount_name)
                        .setNumber("discount_rate", to_sales.discount_rate)
                        .setNumber("discount_amount", to_sales.discount_amount)
                        .setString("discount_customer_name", to_sales.discount_customer_name)
                        .setString("discount_customer_id", to_sales.discount_customer_id)
                        .setString("charge_type", to_sales.charge_type)
                        .setString("charge_type_id", to_sales.charge_type_id)
                        .setString("charge_reference_no", to_sales.charge_reference_no)
                        .setString("charge_customer_name", to_sales.charge_customer_name)
                        .setString("charge_customer_id", to_sales.charge_customer_id)
                        .setNumber("charge_amount", to_sales.charge_amount)
                        .setString("check_bank", to_sales.check_bank)
                        .setString("check_no", to_sales.check_no)
                        .setNumber("check_amount", to_sales.check_amount)
                        .setString("check_holder", to_sales.check_holder)
                        .setString("check_date", to_sales.check_date)
                        .setString("credit_card_type", to_sales.credit_card_type)
                        .setNumber("credit_card_rate", to_sales.credit_card_rate)
                        .setNumber("credit_card_amount", to_sales.credit_card_amount)
                        .setString("credit_card_no", to_sales.credit_card_no)
                        .setString("credit_card_holder", to_sales.credit_card_holder)
                        .setString("credit_card_approval_code", to_sales.credit_card_approval_code)
                        .setString("gift_certificate_from", to_sales.gift_cerftificate_from)
                        .setString("gift_certificate_description", to_sales.gift_certificate_description)
                        .setString("gift_certificate_no", to_sales.gift_certificate_no)
                        .setNumber("gift_certificate_amount", to_sales.gift_certificate_amount)
                        .setString("prepaid_customer_name", to_sales.prepaid_customer_name)
                        .setString("prepaid_customer_id", to_sales.prepaid_customer_id)
                        .setNumber("prepaid_amount", to_sales.prepaid_amount)
                        .setNumber("addtl_amount", to_sales.addtl_amount)
                        .setNumber("wtax", to_sales.wtax)
                        .setString("branch", to_sales.branch)
                        .setString("branch_id", to_sales.branch_id)
                        .setString("location", to_sales.location)
                        .setString("location_id", to_sales.location_id)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.addBatch(s0);

                if (!to_sales.session_no.equalsIgnoreCase("000000000000")) {
                    String s3 = " update orders set status='" + 1 + "' where sales_no='" + to_sales.session_no + "'";
                    stmt.addBatch(s3);
                    String s4 = " update order_items set status='" + 1 + "' where sales_no='" + to_sales.session_no + "'";
                    stmt.addBatch(s4);
                }

                if (to_sales.prepaid_amount > 0) {
                    String prep = "select "
                            + "id"
                            + ",customer_name"
                            + ",customer_no"
                            + ",contact_no"
                            + ",credit_limit"
                            + ",address"
                            + ",term"
                            + ",location"
                            + ",balance"
                            + ",discount"
                            + ",prepaid"
                            + " from customers "
                            + " where id='" + to_sales.prepaid_customer_id + "' ";

                    Statement stmt2 = conn.createStatement();
                    ResultSet rs = stmt2.executeQuery(prep);
                    double prepaid = 0;
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        String customer_name = rs.getString(2);
                        String customer_no = rs.getString(3);
                        String contact_no = rs.getString(4);
                        double credit_limit = rs.getDouble(5);
                        String address = rs.getString(6);
                        double term = rs.getDouble(7);
                        String location = rs.getString(8);
                        double balance = rs.getDouble(9);
                        double discount = rs.getDouble(10);
                        prepaid = rs.getDouble(11);

                    }
                    prepaid = prepaid - to_sales.prepaid_amount;
                    String s3 = "update customers set prepaid='" + prepaid + "' "
                            + " where id='" + to_sales.prepaid_customer_id + "' "
                            + " ";

                    s3 = SqlStringUtil.parse(s3)
                            .ok();
                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt.addBatch(s3);
                }

                if (to_sales.charge_amount > 0) {

                    int id = -1;
                    String soa_type = to_sales.charge_type;
                    String soa_type_id = to_sales.charge_type_id;
                    String soa_date = synsoftech.util.DateType.sf.format(new Date());

                    String date_added = POS.util.DateType.now();
                    String added_by = Users.user_name;
                    String reference_no = to_sales.charge_reference_no;
                    String client_name = to_sales.charge_customer_name;
                    String client_id = to_sales.charge_customer_id;
                    double amount = to_sales.charge_amount;
                    S1_sales_on_account.to_sales_on_account to = new S1_sales_on_account.to_sales_on_account(id, soa_type, soa_type_id, soa_date, date_added, added_by, reference_no, client_name, client_id, amount);

                    String s10 = "insert into sales_on_account("
                            + "soa_type"
                            + ",soa_type_id"
                            + ",soa_date"
                            + ",date_added"
                            + ",added_by"
                            + ",reference_no"
                            + ",client_name"
                            + ",client_id"
                            + ",amount"
                            + ")values("
                            + ":soa_type"
                            + ",:soa_type_id"
                            + ",:soa_date"
                            + ",:date_added"
                            + ",:added_by"
                            + ",:reference_no"
                            + ",:client_name"
                            + ",:client_id"
                            + ",:amount"
                            + ")";

                    s10 = SqlStringUtil.parse(s10)
                            .setString("soa_type", to.soa_type)
                            .setString("soa_type_id", to.soa_type_id)
                            .setString("soa_date", to.soa_date)
                            .setString("date_added", to.date_added)
                            .setString("added_by", to.added_by)
                            .setString("reference_no", to.reference_no)
                            .setString("client_name", to.client_name)
                            .setString("client_id", to.client_id)
                            .setNumber("amount", to.amount)
                            .ok();
                    stmt.addBatch(s10);

                    //soa 
                    String customer_id = to_sales.charge_customer_id;
                    String customer_name = to_sales.charge_customer_name;
                    String ar_no = S1_accounts_receivable.increment_id();
                    String user_name = "";
                    if (Users.user_name == null) {
                        user_name = "";
                    }
                    double discount_amount = 0;
                    double discount_rate = 0;
                    String discount = "";
                    int status = 0;
                    double term = 30;
                    String date_applied = synsoftech.util.DateType.sf.format(new Date());
                    double paid = 0;
                    String date_paid = date_applied;
                    String remarks = "";
                    String type = "AR";
                    String or_no = "";
                    String ci_no = to_sales.charge_reference_no;
                    String trust_receipt = "";
                    String soa_id = S1_sales_on_account.increment_id();
                    String user_id = MyUser.getUser_id();
                    String user_screen_name = MyUser.getUser_screen_name();
                    String branch = to_sales.branch;
                    String branch_id = to_sales.branch_id;
                    String location = to_sales.location;
                    String location_id = to_sales.location_id;
                    S1_accounts_receivable.to_accounts_receivable to2 = new S1_accounts_receivable.to_accounts_receivable(true, -1, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);

                    String s11 = "insert into  accounts_receivable("
                            + "customer_id"
                            + ",customer_name"
                            + ",ar_no"
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
                            + ",or_no"
                            + ",ci_no"
                            + ",trust_receipt"
                            + ",soa_id"
                            + ",soa_type"
                            + ",soa_type_id"
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
                            + ",:ar_no"
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
                            + ",:or_no"
                            + ",:ci_no"
                            + ",:trust_receipt"
                            + ",:soa_id"
                            + ",:soa_type"
                            + ",:soa_type_id"
                            + ",:reference_no"
                            + ",:user_id"
                            + ",:user_screen_name"
                            + ",:branch"
                            + ",:branch_id"
                            + ",:location"
                            + ",:location_id"
                            + ")";

                    s11 = SqlStringUtil.parse(s11).
                            setString("customer_id", to2.customer_id).
                            setString("customer_name", to2.customer_name).
                            setString("ar_no", to2.ar_no).
                            setString("date_added", to2.date_added).
                            setString("user_name", to2.user_name).
                            setNumber("amount", to2.amount).
                            setNumber("discount_amount", to2.discount_amount).
                            setNumber("discount_rate", to2.discount_rate).
                            setString("discount", to2.discount).
                            setNumber("status", to2.status).
                            setNumber("term", to2.term).
                            setString("date_applied", to2.date_applied).
                            setNumber("paid", to2.paid).
                            setString("date_paid", to2.date_paid).
                            setString("remarks", to2.remarks).
                            setString("type", to2.type).
                            setString("or_no", to2.or_no).
                            setString("ci_no", to2.ci_no).
                            setString("trust_receipt", to2.trust_receipt).
                            setString("soa_id", to2.soa_id).
                            setString("soa_type", to2.soa_type).
                            setString("soa_type_id", to2.soa_type_id).
                            setString("reference_no", to2.reference_no).
                            setString("user_id", to2.user_id).
                            setString("user_screen_name", to2.user_screen_name).
                            setString("branch", to2.branch).
                            setString("branch_id", to2.branch_id).
                            setString("location", to2.location).
                            setString("location_id", to2.location_id).
                            ok();

                    stmt.addBatch(s11);

                    Customers.to_customers cus = ret_customer_balance(to2.customer_id);
                    double new_balance = cus.balance + to2.amount;
                    String s12 = "update  customers set "
                            + " balance= :balance"
                            + " where "
                            + " customer_no ='" + to2.customer_id + "' "
                            + " ";
                    s12 = SqlStringUtil.parse(s12).
                            setNumber("balance", new_balance).
                            ok();
                    stmt.addBatch(s12);

                }
                for (Parse_sales.field.items to_sale_items : to_sales.items) {

                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_sale_items.item_code, to_sale_items.barcode, to_sale_items.location_id);

                    String s2 = "insert into sale_items("
                            + "sales_no"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",generic_name"
                            + ",item_type"
                            + ",supplier_name"
                            + ",supplier_id"
                            + ",serial_no"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
                            + ",user_id"
                            + ",user_screen_name"
                            + ",status"
                            + ",is_vatable"
                            + ",selling_type"
                            + ",discount_name"
                            + ",discount_rate"
                            + ",discount_amount"
                            + ",discount_customer_name"
                            + ",discount_customer_id"
                            + ",branch"
                            + ",branch_code"
                            + ",location"
                            + ",location_id"
                            + ",category"
                            + ",category_id"
                            + ",classification"
                            + ",classification_id"
                            + ",sub_classification"
                            + ",sub_classification_id"
                            + ",brand"
                            + ",brand_id"
                            + ",model"
                            + ",model_id"
                            + ",addtl_amount"
                            + ",wtax"
                            + ")values("
                            + ":sales_no"
                            + ",:item_code"
                            + ",:barcode"
                            + ",:description"
                            + ",:generic_name"
                            + ",:item_type"
                            + ",:supplier_name"
                            + ",:supplier_id"
                            + ",:serial_no"
                            + ",:product_qty"
                            + ",:unit"
                            + ",:conversion"
                            + ",:selling_price"
                            + ",:date_added"
                            + ",:user_id"
                            + ",:user_screen_name"
                            + ",:status"
                            + ",:is_vatable"
                            + ",:selling_type"
                            + ",:discount_name"
                            + ",:discount_rate"
                            + ",:discount_amount"
                            + ",:discount_customer_name"
                            + ",:discount_customer_id"
                            + ",:branch"
                            + ",:branch_code"
                            + ",:location"
                            + ",:location_id"
                            + ",:category"
                            + ",:category_id"
                            + ",:classification"
                            + ",:classification_id"
                            + ",:sub_classification"
                            + ",:sub_classification_id"
                            + ",:brand"
                            + ",:brand_id"
                            + ",:model"
                            + ",:model_id"
                            + ",:addtl_amount"
                            + ",:wtax"
                            + ")";

                    s2 = SqlStringUtil.parse(s2)
                            .setString("sales_no", to_sales.sales_no)
                            .setString("item_code", to_sale_items.item_code)
                            .setString("barcode", to_sale_items.barcode)
                            .setString("description", tt.description)
                            .setString("generic_name", tt.generic_name)
                            .setString("item_type", tt.item_type)
                            .setString("supplier_name", tt.supplier)
                            .setString("supplier_id", tt.supplier_id)
                            .setString("serial_no", tt.serial_no)
                            .setNumber("product_qty", to_sale_items.qty)
                            .setString("unit", tt.unit)
                            .setNumber("conversion", tt.conversion)
                            .setNumber("selling_price", to_sale_items.selling_price)
                            .setString("date_added", to_sales.date_added)
                            .setString("user_id", to_sales.user_id)
                            .setString("user_screen_name", to_sales.user_screen_name)
                            .setNumber("status", to_sales.status)
                            .setNumber("is_vatable", to_sale_items.is_vatable)
                            .setNumber("selling_type", tt.selling_type)
                            .setString("discount_name", to_sale_items.discount_name)
                            .setNumber("discount_rate", to_sale_items.discount_rate)
                            .setNumber("discount_amount", to_sale_items.discount_amount)
                            .setString("discount_customer_name", to_sale_items.discount_customer_name)
                            .setString("discount_customer_id", to_sale_items.discount_customer_id)
                            .setString("branch", to_sale_items.branch)
                            .setString("branch_code", to_sale_items.branch_id)
                            .setString("location", to_sale_items.location)
                            .setString("location_id", to_sale_items.location_id)
                            .setString("category", tt.category)
                            .setString("category_id", tt.category_id)
                            .setString("classification", tt.classification)
                            .setString("classification_id", tt.classification_id)
                            .setString("sub_classification", tt.sub_classification)
                            .setString("sub_classification_id", tt.sub_classification_id)
                            .setString("brand", tt.brand)
                            .setString("brand_id", tt.brand_id)
                            .setString("model", tt.model)
                            .setString("model_id", tt.model_id)
                            .setNumber("addtl_amount", to_sale_items.addtl_amount)
                            .setNumber("wtax", to_sale_items.wtax)
                            .ok();

                    stmt.addBatch(s2);

                    double new_qty = tt.product_qty - (tt.conversion * tt.product_qty);

                    String serial_no = Segregator.this_shit(tt.serial_no, to_sale_items.serial_nos);
                    String s4 = " update inventory_barcodes set "
                            + " product_qty='" + new_qty + "'"
                            + " where  main_barcode= '" + to_sale_items.item_code + "' and location_id='" + to_sale_items.location_id + "' "
                            + "";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt.addBatch(s4);

                }

                stmt.executeBatch();

            }
            //</editor-fold>
            System.out.println("Sales, Updated!");
            conn.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void receipts() {
        try {

            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            //<editor-fold defaultstate="collapsed" desc=" Receipts ">
            //</editor-fold>
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void returned_items(List<Parse_sale_item_replacements> l_item_replacements) {
        try {

            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            //<editor-fold defaultstate="collapsed" desc=" returned items ">
            System.out.println("Item Replacements in progress.......... " + l_item_replacements.size());
            for (Parse_sale_item_replacements to_sale_items : l_item_replacements) {
                System.out.println("Code: " + to_sale_items.item_code);

                System.out.println("Qty: " + to_sale_items.product_qty);
                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_sale_items.item_code, to_sale_items.barcode, to_sale_items.location_id);

                String s5 = "insert into sale_item_replacements("
                        + "sales_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",is_replacement"
                        + ")values("
                        + ":sales_no"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:item_type"
                        + ",:supplier_name"
                        + ",:supplier_id"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:status"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:is_replacement"
                        + ")";

                double qty = 0;

                if (to_sale_items.is_replacement == 1) {
                    qty = tt.product_qty - to_sale_items.product_qty;
                } else {
                    qty = tt.product_qty + to_sale_items.product_qty;
                }
                s5 = SqlStringUtil.parse(s5)
                        .setString("sales_no", to_sale_items.sales_no)
                        .setString("item_code", to_sale_items.item_code)
                        .setString("barcode", to_sale_items.barcode)
                        .setString("description", tt.description)
                        .setString("generic_name", tt.generic_name)
                        .setString("item_type", tt.item_type)
                        .setString("supplier_name", tt.supplier)
                        .setString("supplier_id", tt.supplier_id)
                        .setString("serial_no", to_sale_items.serial_no)
                        .setNumber("product_qty", to_sale_items.product_qty)
                        .setString("unit", to_sale_items.unit)
                        .setNumber("conversion", to_sale_items.conversion)
                        .setNumber("selling_price", to_sale_items.selling_price)
                        .setString("date_added", DateType.now())
                        .setString("user_id", to_sale_items.user_id)
                        .setString("user_screen_name", to_sale_items.user_screen_name)
                        .setNumber("status", to_sale_items.status)
                        .setNumber("is_vatable", tt.vatable)
                        .setNumber("selling_type", tt.selling_type)
                        .setString("discount_name", to_sale_items.discount_name)
                        .setNumber("discount_rate", to_sale_items.discount_rate)
                        .setNumber("discount_amount", to_sale_items.discount_amount)
                        .setString("discount_customer_name", to_sale_items.discount_customer_name)
                        .setString("discount_customer_id", to_sale_items.discount_customer_id)
                        .setString("branch", to_sale_items.branch)
                        .setString("branch_code", to_sale_items.branch_code)
                        .setString("location", to_sale_items.location)
                        .setString("location_id", to_sale_items.location_id)
                        .setString("category", tt.category)
                        .setString("category_id", tt.category_id)
                        .setString("classification", tt.classification)
                        .setString("classification_id", tt.classification_id)
                        .setString("sub_classification", tt.sub_classification)
                        .setString("sub_classification_id", tt.sub_classification_id)
                        .setString("brand", tt.brand)
                        .setString("brand_id", tt.brand_id)
                        .setString("model", tt.model)
                        .setString("model_id", tt.model_id)
                        .setNumber("is_replacement", to_sale_items.is_replacement)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s5);
                stmt2.addBatch(s5);

                String s0 = "update inventory_barcodes set "
                        + " product_qty= :product_qty "
                        + " where "
                        + " main_barcode ='" + to_sale_items.item_code + "' "
                        + " and location_id ='" + to_sale_items.location_id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setNumber("product_qty", qty)
                        .ok();

                stmt2.addBatch(s0);

                if (to_sale_items.is_replacement == 0) {
                    String s2 = "delete from sale_items where sales_no='" + to_sale_items.sales_no + "' and item_code='" + to_sale_items.item_code + "' ";
                    stmt2.addBatch(s2);
                }

                stmt2.executeBatch();

            }
            //</editor-fold>
            System.out.println("Adjustments Updated!");
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void charge_in_advance(List<Parse_charged_items> l_charged_items) {
        try {

            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            //<editor-fold defaultstate="collapsed" desc=" charge in advance ">
            System.out.println("Charge in Advance in progress.......... " + l_charged_items.size());
            for (Parse_charged_items to_charge_in_advance_items : l_charged_items) {

                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_charge_in_advance_items.item_code, to_charge_in_advance_items.barcode, to_charge_in_advance_items.location_id);

                double new_qty = tt.product_qty - (to_charge_in_advance_items.conversion * to_charge_in_advance_items.product_qty);
                if (to_charge_in_advance_items.status == 1) {
                    new_qty = tt.product_qty + (to_charge_in_advance_items.conversion * to_charge_in_advance_items.product_qty);
                }

                String serial_no = Segregator.this_shit(tt.serial_no, to_charge_in_advance_items.serial_no);

                String s0 = "insert into charge_in_advance_items("
                        + "customer_id"
                        + ",customer_name"
                        + ",ar_id"
                        + ",ar_no"
                        + ",date_applied"
                        + ",reference_no"
                        + ",soa_type"
                        + ",soa_type_id"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",remarks"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + ")values("
                        + ":customer_id"
                        + ",:customer_name"
                        + ",:ar_id"
                        + ",:ar_no"
                        + ",:date_applied"
                        + ",:reference_no"
                        + ",:soa_type"
                        + ",:soa_type_id"
                        + ",:user_screen_name"
                        + ",:user_id"
                        + ",:remarks"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:item_type"
                        + ",:supplier_name"
                        + ",:supplier_id"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:status"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:addtl_amount"
                        + ",:wtax"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("customer_id", to_charge_in_advance_items.customer_id)
                        .setString("customer_name", to_charge_in_advance_items.customer_name)
                        .setString("ar_id", to_charge_in_advance_items.ar_id)
                        .setString("ar_no", to_charge_in_advance_items.ar_no)
                        .setString("date_applied", to_charge_in_advance_items.date_applied)
                        .setString("reference_no", to_charge_in_advance_items.reference_no)
                        .setString("soa_type", to_charge_in_advance_items.soa_type)
                        .setString("soa_type_id", to_charge_in_advance_items.soa_type_id)
                        .setString("user_screen_name", to_charge_in_advance_items.user_screen_name)
                        .setString("user_id", to_charge_in_advance_items.user_id)
                        .setString("remarks", to_charge_in_advance_items.remarks)
                        .setString("item_code", to_charge_in_advance_items.item_code)
                        .setString("barcode", to_charge_in_advance_items.barcode)
                        .setString("description", tt.description)
                        .setString("generic_name", tt.generic_name)
                        .setString("item_type", to_charge_in_advance_items.item_type)
                        .setString("supplier_name", tt.supplier)
                        .setString("supplier_id", tt.supplier_id)
                        .setString("serial_no", to_charge_in_advance_items.serial_no)
                        .setNumber("product_qty", to_charge_in_advance_items.product_qty)
                        .setString("unit", to_charge_in_advance_items.unit)
                        .setNumber("conversion", to_charge_in_advance_items.conversion)
                        .setNumber("selling_price", to_charge_in_advance_items.selling_price)
                        .setString("date_added", to_charge_in_advance_items.date_added)
                        .setNumber("status", to_charge_in_advance_items.status)
                        .setNumber("is_vatable", tt.vatable)
                        .setNumber("selling_type", tt.selling_type)
                        .setString("discount_name", to_charge_in_advance_items.discount_name)
                        .setNumber("discount_rate", to_charge_in_advance_items.discount_rate)
                        .setNumber("discount_amount", to_charge_in_advance_items.discount_amount)
                        .setString("discount_customer_name", to_charge_in_advance_items.discount_customer_name)
                        .setString("discount_customer_id", to_charge_in_advance_items.discount_customer_id)
                        .setString("branch", to_charge_in_advance_items.branch)
                        .setString("branch_code", to_charge_in_advance_items.branch_code)
                        .setString("location", to_charge_in_advance_items.location)
                        .setString("location_id", to_charge_in_advance_items.location_id)
                        .setString("category", tt.category)
                        .setString("category_id", tt.category_id)
                        .setString("classification", tt.classification)
                        .setString("classification_id", tt.classification_id)
                        .setString("sub_classification", tt.sub_classification)
                        .setString("sub_classification_id", tt.sub_classification_id)
                        .setString("brand", tt.brand)
                        .setString("brand_id", tt.brand_id)
                        .setString("model", tt.model)
                        .setString("model_id", tt.model_id)
                        .setNumber("addtl_amount", to_charge_in_advance_items.addtl_amount)
                        .setNumber("wtax", to_charge_in_advance_items.wtax)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "'"
                        + " where  main_barcode= '" + to_charge_in_advance_items.item_code + "' "
                        + " and location_id='" + to_charge_in_advance_items.location_id + "' "
                        + "";
                PreparedStatement stmt4 = conn.prepareStatement(s4);
                stmt4.execute();

            }
            //</editor-fold>
            System.out.println("Charge in Advance, Updated!");
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void cash_drawers(List<Parse_cash_drawers> l_cash_drawers) {
        try {

            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            //<editor-fold defaultstate="collapsed" desc=" Cash Drawers ">
            System.out.println("Cash Drawer in progress.......... " + l_cash_drawers.size());
            for (Parse_cash_drawers to_cash_drawer : l_cash_drawers) {
                String s0 = "insert into  cash_drawer("
                        + "session_no"
                        + ",user_name"
                        + ",screen_name"
                        + ",time_in"
                        + ",time_out"
                        + ",amount"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",user_id"
                        + ",user_screen_name"
                        + ")values("
                        + ":session_no"
                        + ",:user_name"
                        + ",:screen_name"
                        + ",:time_in"
                        + ",:time_out"
                        + ",:amount"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ")";

                String out = to_cash_drawer.time_out;
                if (to_cash_drawer.time_out == null) {
                    out = to_cash_drawer.time_in;
                }

                s0 = SqlStringUtil.parse(s0).
                        setString("session_no", to_cash_drawer.session_no).
                        setString("user_name", to_cash_drawer.user_name).
                        setString("screen_name", to_cash_drawer.screen_name).
                        setString("time_in", to_cash_drawer.time_in).
                        setString("time_out", to_cash_drawer.time_in).
                        setNumber("amount", to_cash_drawer.amount).
                        setString("branch", to_cash_drawer.branch).
                        setString("branch_id", to_cash_drawer.branch_id).
                        setString("location", to_cash_drawer.location).
                        setString("location_id", to_cash_drawer.location_id).
                        setString("user_id", to_cash_drawer.user_id).
                        setString("user_screen_name", to_cash_drawer.user_screen_name).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

            }

            //</editor-fold>
            System.out.println("Cash Drawer, Added!");
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        Grab_branches_updates gbu = new Grab_branches_updates();
        gbu.countdown();
    }

    int hours = 12;
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Timer: " + hours);
            hours--;
        }
    });

    private void countdown() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    timer.start();
                }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(Grab_branches_updates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Grab_branches_updates.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update_status(List<Branch_local_uploads.to_branch_local_uploads> datas2) {
        try {

            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);

            for (Branch_local_uploads.to_branch_local_uploads to_branch_local_uploads : datas2) {
                String s0 = "update branch_local_uploads set "
                        + "status= :status "
                        + " where id='" + to_branch_local_uploads.id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setNumber("status", 1)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

            }
            Lg.s(Branch_local_uploads.class, "Successfully Updated");
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_status2(List<Branch_server_uploads.to_branch_local_uploads> datas2) {
        try {

            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);

            for (Branch_server_uploads.to_branch_local_uploads to_branch_local_uploads : datas2) {
                String s0 = "update branch_server_uploads set "
                        + "status= :status "
                        + " where id='" + to_branch_local_uploads.id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setNumber("status", 1)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

            }
            Lg.s(Branch_local_uploads.class, "Successfully Updated");
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
