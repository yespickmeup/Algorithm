/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;

import POS.adjuster.Adjuster;
import POS.adjuster.S1_adjustments;
import POS.inventory.Inventory_barcodes;
import POS.receipts.Stock_transfers_items;
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
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Grab_branches_updates {

    public static void install_updates(
            List<Parse_inventory_replenishments> l_replenishments, List<Parse_inventory_counts.field> l_inventory_counts, List<Parse_inventory_adjustments.field> l_adjustments, List<Parse_stock_transfers> l_stock_transfers) {

        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            //<editor-fold defaultstate="collapsed" desc=" Replenishments ">
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
                System.out.println("Item Replenishments Updated!");
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
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
                System.out.println("Inventory Encoding Updated!");
            }

            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
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
                stmt2.execute();
                Lg.s(S1_adjustments.class, "Successfully Added");

                String s0 = "update inventory_barcodes set "
                        + " product_qty= :product_qty "
                        + " where "
                        + "  main_barcode ='" + to_inventory_barcodes.item_code + "' "
                        + " and location_id ='" + to_inventory_barcodes.location_id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setNumber("product_qty", my_qty1)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                System.out.println("Adjustments Updated!");
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc=" Stock Transfers ">
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
                System.out.println("Stock Transfer");
            }

            //</editor-fold>
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
