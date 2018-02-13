/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.synch;

import POS.receipts.Stock_transfers_items;
import POS.stock_transfer.Stock_transfers;
import POS.uom.S1_uom;
import POS.users.MyUser;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Synch_stock_transfers {

    public static class synch_stock_transfers {

        public final int id;
        public final String stock_transfer_no;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final String at_branch;
        public final String at_branch_id;
        public final String at_location;
        public final String at_location_id;
        public final String from_branch;
        public final String from_branch_id;
        public final String from_location;
        public final String from_location_id;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public final int status;

        public synch_stock_transfers(int id, String stock_transfer_no, String created_at, String updated_at, String created_by, String updated_by, String at_branch, String at_branch_id, String at_location, String at_location_id, String from_branch, String from_branch_id, String from_location, String from_location_id, String to_branch, String to_branch_id, String to_location, String to_location_id, int status) {
            this.id = id;
            this.stock_transfer_no = stock_transfer_no;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.at_branch = at_branch;
            this.at_branch_id = at_branch_id;
            this.at_location = at_location;
            this.at_location_id = at_location_id;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.status = status;
        }

    }

    public static void main2(String[] args) {

        System.out.println("1.) Retrieving synch stock transfers...");
        List<Synch_stock_transfers.synch_stock_transfers> synch_stock_transfers = ret_synch_stock_transfers(" where status=0 ");
        List<Synch_stock_transfers.synch_stock_transfers> synch_stock_transfers_insert = new ArrayList();

        System.out.println("Total rows synch: " + synch_stock_transfers.size());

        System.out.println("2.) Retrieving Stock transfers...");
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("pool_host", "192.168.1.51");
        List<Stock_transfers.to_stock_transfers> stock_transfers = Stock_transfers.ret_data(" order by id asc ");
        List<Stock_transfers.to_stock_transfers> stock_transfers_insert = new ArrayList();
        List<Stock_transfers_items.to_stock_transfers_items> st_items_insert = new ArrayList();

        for (Stock_transfers.to_stock_transfers to : stock_transfers) {

            List<Stock_transfers_items.to_stock_transfers_items> items = Stock_transfers_items.ret_data("where stock_transfer_id ='" + to.transaction_no + "' ");
            System.out.println("Stock_transfer_no: " + to.transaction_no + " Item/s: " + items.size());
//            System.out.println("    Items: " + items.size());
            int exists = 0;
            for (Synch_stock_transfers.synch_stock_transfers synch : synch_stock_transfers) {
                if (to.transaction_no.equalsIgnoreCase(synch.stock_transfer_no)) {
                    exists = 1;
                    System.out.println("    Transaction " + to.transaction_no + " already exists!");
                    break;
                }
            }

            if (exists == 0) {
                int id = 0;
                String stock_transfer_no = to.transaction_no;
                String created_at = DateType.now();
                String updated_at = DateType.now();
                String created_by = MyUser.getUser_id();
                String updated_by = MyUser.getUser_id();
                String at_branch = to.at_branch;
                String at_branch_id = to.at_branch_id;
                String at_location = to.at_location;
                String at_location_id = to.at_location_id;
                String from_branch = to.from_branch;
                String from_branch_id = to.from_branch_id;
                String from_location = to.from_location;
                String from_location_id = to.from_location_id;
                String to_branch = to.to_branch;
                String to_branch_id = to.to_branch_id;
                String to_location = to.to_location;
                String to_location_id = to.to_location_id;
                int status = 0;
                Synch_stock_transfers.synch_stock_transfers syn = new synch_stock_transfers(id, stock_transfer_no, created_at, updated_at, created_by, updated_by, at_branch, at_branch_id, at_location, at_location_id, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, status);
                synch_stock_transfers_insert.add(syn);
                stock_transfers_insert.add(to);
                st_items_insert.addAll(items);
                insert_synch_stock_transfer(synch_stock_transfers_insert, stock_transfers_insert, st_items_insert);
                synch_stock_transfers_insert.clear();
                stock_transfers_insert.clear();
                st_items_insert.clear();
            }
        }
        System.out.println("****************************************");
        System.out.println("Insert to Droplet...");
        System.out.println("Synch Stock Transfer: " + synch_stock_transfers_insert.size());
        System.out.println("Stock Transfers: " + stock_transfers_insert.size());
        System.out.println("Stock Transfer Items: " + st_items_insert.size());

        System.out.println("****************************************");

    }

    public static void main(String[] args) {

        System.out.println("1.) Retrieving synch stock transfers...");
        List<Synch_stock_transfers.synch_stock_transfers> synch_stock_transfers = ret_synch_stock_transfers(" where status=0 ");
        List<Synch_stock_transfers.synch_stock_transfers> synch_stock_transfers_insert = new ArrayList();

        System.out.println("Total rows synch: " + synch_stock_transfers.size());

        System.out.println("2.) Retrieving Stock transfers...");
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("pool_host", "192.168.1.51");
        List<Stock_transfers.to_stock_transfers> stock_transfers = Stock_transfers.ret_data(" where id>7477 order by id asc ");
        List<Stock_transfers.to_stock_transfers> stock_transfers_insert = new ArrayList();
        List<Stock_transfers_items.to_stock_transfers_items> st_items_insert = new ArrayList();
        for (Stock_transfers.to_stock_transfers to : stock_transfers) {
            List<Stock_transfers_items.to_stock_transfers_items> items = Stock_transfers_items.ret_data("where stock_transfer_id ='" + to.transaction_no + "' ");
            System.out.println("Stock_transfer_no: " + to.transaction_no + " Item/s: " + items.size());
//            System.out.println("    Items: " + items.size());
            int exists = 0;
            for (Synch_stock_transfers.synch_stock_transfers synch : synch_stock_transfers) {
                if (to.transaction_no.equalsIgnoreCase(synch.stock_transfer_no)) {
                    exists = 1;
                    System.out.println("    Transaction " + to.transaction_no + " already exists!");
                    break;
                }
            }
            if (exists == 0) {
                int id = 0;
                String stock_transfer_no = to.transaction_no;
                String created_at = DateType.now();
                String updated_at = DateType.now();
                String created_by = MyUser.getUser_id();
                String updated_by = MyUser.getUser_id();
                String at_branch = to.at_branch;
                String at_branch_id = to.at_branch_id;
                String at_location = to.at_location;
                String at_location_id = to.at_location_id;
                String from_branch = to.from_branch;
                String from_branch_id = to.from_branch_id;
                String from_location = to.from_location;
                String from_location_id = to.from_location_id;
                String to_branch = to.to_branch;
                String to_branch_id = to.to_branch_id;
                String to_location = to.to_location;
                String to_location_id = to.to_location_id;
                int status = 0;
                Synch_stock_transfers.synch_stock_transfers syn = new synch_stock_transfers(id, stock_transfer_no, created_at, updated_at, created_by, updated_by, at_branch, at_branch_id, at_location, at_location_id, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, status);
                synch_stock_transfers_insert.add(syn);
                stock_transfers_insert.add(to);
                st_items_insert.addAll(items);
                insert_synch_stock_transfer(synch_stock_transfers_insert, stock_transfers_insert, st_items_insert);
                synch_stock_transfers_insert.clear();
                stock_transfers_insert.clear();
                st_items_insert.clear();
            }
        }
        System.out.println("****************************************");
        System.out.println("Insert to Droplet...");
        System.out.println("Synch Stock Transfer: " + synch_stock_transfers_insert.size());
        System.out.println("Stock Transfers: " + stock_transfers_insert.size());
        System.out.println("Stock Transfer Items: " + st_items_insert.size());

        System.out.println("****************************************");

    }

    public static void insert_synch_stock_transfer(List<Synch_stock_transfers.synch_stock_transfers> synch_stock_transfers_insert, List<Stock_transfers.to_stock_transfers> stock_transfers_insert, List<Stock_transfers_items.to_stock_transfers_items> st_items_insert) {
        try {
            Connection conn = MyConnection.cloud_connect();

//            conn.setNetworkTimeout(Executors.newFixedThreadPool(100), 200000);
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
//            stmt.setQueryTimeout(30000);
            PreparedStatement stmt2 = conn.prepareStatement("");
//            stmt2.setQueryTimeout(30000);
            PreparedStatement stmt3 = conn.prepareStatement("");
//            stmt3.setQueryTimeout(30000);
            //<editor-fold defaultstate="collapsed" desc=" Sync Stock Transfers ">
            for (Synch_stock_transfers.synch_stock_transfers to : synch_stock_transfers_insert) {
                String s0 = "insert into  synch_stock_transfers("
                        + "stock_transfer_no"
                        + ",created_at"
                        + ",updated_at"
                        + ",created_by"
                        + ",updated_by"
                        + ",at_branch"
                        + ",at_branch_id"
                        + ",at_location"
                        + ",at_location_id"
                        + ",from_branch"
                        + ",from_branch_id"
                        + ",from_location"
                        + ",from_location_id"
                        + ",to_branch"
                        + ",to_branch_id"
                        + ",to_location"
                        + ",to_location_id"
                        + ",status"
                        + ")values("
                        + ":stock_transfer_no"
                        + ",:created_at"
                        + ",:updated_at"
                        + ",:created_by"
                        + ",:updated_by"
                        + ",:at_branch"
                        + ",:at_branch_id"
                        + ",:at_location"
                        + ",:at_location_id"
                        + ",:from_branch"
                        + ",:from_branch_id"
                        + ",:from_location"
                        + ",:from_location_id"
                        + ",:to_branch"
                        + ",:to_branch_id"
                        + ",:to_location"
                        + ",:to_location_id"
                        + ",:status"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("stock_transfer_no", to.stock_transfer_no).
                        setString("created_at", to.created_at).
                        setString("updated_at", to.updated_at).
                        setString("created_by", to.created_by).
                        setString("updated_by", to.updated_by).
                        setString("at_branch", to.at_branch).
                        setString("at_branch_id", to.at_branch_id).
                        setString("at_location", to.at_location).
                        setString("at_location_id", to.at_location_id).
                        setString("from_branch", to.from_branch).
                        setString("from_branch_id", to.from_branch_id).
                        setString("from_location", to.from_location).
                        setString("from_location_id", to.from_location_id).
                        setString("to_branch", to.to_branch).
                        setString("to_branch_id", to.to_branch_id).
                        setString("to_location", to.to_location).
                        setString("to_location_id", to.to_location_id).
                        setNumber("status", to.status).
                        ok();
                stmt.addBatch(s0);
            }
            stmt.executeBatch();
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc=" Stock Transfers ">
            for (Stock_transfers.to_stock_transfers to_stock_transfers : stock_transfers_insert) {
                String s2 = "insert into stock_transfers("
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

                s2 = SqlStringUtil.parse(s2)
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
                        .setNumber("status", to_stock_transfers.status)
                        .setString("at_branch", to_stock_transfers.at_branch)
                        .setString("at_branch_id", to_stock_transfers.at_branch_id)
                        .setString("at_location", to_stock_transfers.at_location)
                        .setString("at_location_id", to_stock_transfers.at_location_id)
                        .ok();
                stmt2.addBatch(s2);
            }
            stmt2.executeBatch();
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc=" Stock Transfer Items ">
            for (Stock_transfers_items.to_stock_transfers_items to_stock_transfers_items : st_items_insert) {
                String s3 = "insert into stock_transfers_items("
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

                s3 = SqlStringUtil.parse(s3)
                        .setString("barcode", to_stock_transfers_items.barcode)
                        .setString("description", to_stock_transfers_items.description)
                        .setString("generic_name", to_stock_transfers_items.generic_name)
                        .setString("category", to_stock_transfers_items.category)
                        .setString("category_id", to_stock_transfers_items.category_id)
                        .setString("classification", to_stock_transfers_items.classification)
                        .setString("classification_id", to_stock_transfers_items.classification_id)
                        .setString("sub_classification", to_stock_transfers_items.sub_classification)
                        .setString("sub_classification_id", to_stock_transfers_items.sub_classification_id)
                        .setNumber("product_qty", to_stock_transfers_items.product_qty)
                        .setString("unit", to_stock_transfers_items.unit)
                        .setNumber("conversion", to_stock_transfers_items.conversion)
                        .setNumber("selling_price", to_stock_transfers_items.selling_price)
                        .setString("date_added", to_stock_transfers_items.date_added)
                        .setString("user_name", to_stock_transfers_items.user_name)
                        .setString("item_type", to_stock_transfers_items.item_type)
                        .setNumber("status", to_stock_transfers_items.status)
                        .setString("supplier", to_stock_transfers_items.supplier)
                        .setNumber("fixed_price", to_stock_transfers_items.fixed_price)
                        .setNumber("cost", to_stock_transfers_items.cost)
                        .setString("supplier_id", to_stock_transfers_items.supplier_id)
                        .setNumber("multi_level_pricing", to_stock_transfers_items.multi_level_pricing)
                        .setNumber("vatable", to_stock_transfers_items.vatable)
                        .setNumber("reorder_level", to_stock_transfers_items.reorder_level)
                        .setNumber("markup", to_stock_transfers_items.markup)
                        .setString("barcodes", to_stock_transfers_items.barcodes)
                        .setString("brand", to_stock_transfers_items.brand)
                        .setString("brand_id", to_stock_transfers_items.brand_id)
                        .setString("model", to_stock_transfers_items.model)
                        .setString("model_id", to_stock_transfers_items.model_id)
                        .setNumber("selling_type", to_stock_transfers_items.selling_type)
                        .setString("branch", to_stock_transfers_items.branch)
                        .setString("branch_code", to_stock_transfers_items.branch_code)
                        .setString("location", to_stock_transfers_items.location)
                        .setString("location_id", to_stock_transfers_items.location_id)
                        .setString("stock_transfer_id", to_stock_transfers_items.stock_transfer_id)
                        .setString("serial_no", to_stock_transfers_items.serial_no)
                        .setString("to_branch", to_stock_transfers_items.to_branch)
                        .setString("to_branch_id", to_stock_transfers_items.to_branch_id)
                        .setString("to_location", to_stock_transfers_items.to_location)
                        .setString("to_location_id", to_stock_transfers_items.to_location_id)
                        .setString("at_branch", to_stock_transfers_items.at_branch)
                        .setString("at_branch_id", to_stock_transfers_items.at_branch_id)
                        .setString("at_location", to_stock_transfers_items.at_location)
                        .setString("at_location_id", to_stock_transfers_items.at_location_id)
                        .ok();
                stmt3.addBatch(s3);
            }
            stmt3.executeBatch();
            //</editor-fold>

            conn.commit();
            conn.close();
            Lg.s(S1_uom.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//           conn.
        }
    }

    public static List<Synch_stock_transfers.synch_stock_transfers> ret_synch_stock_transfers(String where) {
        List<Synch_stock_transfers.synch_stock_transfers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
//             conn.setNetworkTimeout(Executors.newFixedThreadPool(100), 200000);
            String s0 = " select "
                    + " id"
                    + ",stock_transfer_no"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",status"
                    + " from synch_stock_transfers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String stock_transfer_no = rs.getString(2);
                String created_at = rs.getString(3);
                String updated_at = rs.getString(4);
                String created_by = rs.getString(5);
                String updated_by = rs.getString(6);
                String at_branch = rs.getString(7);
                String at_branch_id = rs.getString(8);
                String at_location = rs.getString(9);
                String at_location_id = rs.getString(10);
                String from_branch = rs.getString(11);
                String from_branch_id = rs.getString(12);
                String from_location = rs.getString(13);
                String from_location_id = rs.getString(14);
                String to_branch = rs.getString(15);
                String to_branch_id = rs.getString(16);
                String to_location = rs.getString(17);
                String to_location_id = rs.getString(18);
                int status = rs.getInt(19);
                Synch_stock_transfers.synch_stock_transfers to = new synch_stock_transfers(id, stock_transfer_no, created_at, updated_at, created_by, updated_by, at_branch, at_branch_id, at_location, at_location_id, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, status);
                datas.add(to);
            }
            conn.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }
    }

    public static void post_stock_transfer(List<Stock_transfers.to_stock_transfers> stock_transfers_insert, List<Stock_transfers_items.to_stock_transfers_items> st_items_insert) {
        try {
            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt2 = conn.prepareStatement("");
            PreparedStatement stmt3 = conn.prepareStatement("");
            //<editor-fold defaultstate="collapsed" desc=" Stock Transfers ">
            for (Stock_transfers.to_stock_transfers to_stock_transfers : stock_transfers_insert) {
                String s2 = "insert into stock_transfers("
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

                s2 = SqlStringUtil.parse(s2)
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
                        .setNumber("status", to_stock_transfers.status)
                        .setString("at_branch", to_stock_transfers.at_branch)
                        .setString("at_branch_id", to_stock_transfers.at_branch_id)
                        .setString("at_location", to_stock_transfers.at_location)
                        .setString("at_location_id", to_stock_transfers.at_location_id)
                        .ok();
                stmt2.addBatch(s2);

            }

            stmt2.executeBatch();

            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Stock Transfer Items ">
            for (Stock_transfers_items.to_stock_transfers_items to_stock_transfers_items : st_items_insert) {
                String s3 = "insert into stock_transfers_items("
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

                s3 = SqlStringUtil.parse(s3)
                        .setString("barcode", to_stock_transfers_items.barcode)
                        .setString("description", to_stock_transfers_items.description)
                        .setString("generic_name", to_stock_transfers_items.generic_name)
                        .setString("category", to_stock_transfers_items.category)
                        .setString("category_id", to_stock_transfers_items.category_id)
                        .setString("classification", to_stock_transfers_items.classification)
                        .setString("classification_id", to_stock_transfers_items.classification_id)
                        .setString("sub_classification", to_stock_transfers_items.sub_classification)
                        .setString("sub_classification_id", to_stock_transfers_items.sub_classification_id)
                        .setNumber("product_qty", to_stock_transfers_items.product_qty)
                        .setString("unit", to_stock_transfers_items.unit)
                        .setNumber("conversion", to_stock_transfers_items.conversion)
                        .setNumber("selling_price", to_stock_transfers_items.selling_price)
                        .setString("date_added", to_stock_transfers_items.date_added)
                        .setString("user_name", to_stock_transfers_items.user_name)
                        .setString("item_type", to_stock_transfers_items.item_type)
                        .setNumber("status", to_stock_transfers_items.status)
                        .setString("supplier", to_stock_transfers_items.supplier)
                        .setNumber("fixed_price", to_stock_transfers_items.fixed_price)
                        .setNumber("cost", to_stock_transfers_items.cost)
                        .setString("supplier_id", to_stock_transfers_items.supplier_id)
                        .setNumber("multi_level_pricing", to_stock_transfers_items.multi_level_pricing)
                        .setNumber("vatable", to_stock_transfers_items.vatable)
                        .setNumber("reorder_level", to_stock_transfers_items.reorder_level)
                        .setNumber("markup", to_stock_transfers_items.markup)
                        .setString("barcodes", to_stock_transfers_items.barcodes)
                        .setString("brand", to_stock_transfers_items.brand)
                        .setString("brand_id", to_stock_transfers_items.brand_id)
                        .setString("model", to_stock_transfers_items.model)
                        .setString("model_id", to_stock_transfers_items.model_id)
                        .setNumber("selling_type", to_stock_transfers_items.selling_type)
                        .setString("branch", to_stock_transfers_items.branch)
                        .setString("branch_code", to_stock_transfers_items.branch_code)
                        .setString("location", to_stock_transfers_items.location)
                        .setString("location_id", to_stock_transfers_items.location_id)
                        .setString("stock_transfer_id", to_stock_transfers_items.stock_transfer_id)
                        .setString("serial_no", to_stock_transfers_items.serial_no)
                        .setString("to_branch", to_stock_transfers_items.to_branch)
                        .setString("to_branch_id", to_stock_transfers_items.to_branch_id)
                        .setString("to_location", to_stock_transfers_items.to_location)
                        .setString("to_location_id", to_stock_transfers_items.to_location_id)
                        .setString("at_branch", to_stock_transfers_items.at_branch)
                        .setString("at_branch_id", to_stock_transfers_items.at_branch_id)
                        .setString("at_location", to_stock_transfers_items.at_location)
                        .setString("at_location_id", to_stock_transfers_items.at_location_id)
                        .ok();
                stmt3.addBatch(s3);
            }
            stmt3.executeBatch();
            //</editor-fold>

            conn.commit();
            conn.close();
            Lg.s(S1_uom.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//           conn.
        }
    }

    public static void update_status_stock_transfer(String transaction_no, int status) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            PreparedStatement stmt4 = conn.prepareStatement("");

            String s4 = "update stock_transfers set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " transaction_no ='" + transaction_no + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setNumber("is_uploaded", status)
                    .ok();

            stmt4.addBatch(s4);

            String s5 = "update stock_transfers_items set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " stock_transfer_id ='" + transaction_no + "' "
                    + " ";

            s5 = SqlStringUtil.parse(s5)
                    .setNumber("is_uploaded", status)
                    .ok();

            stmt4.addBatch(s5);
            stmt4.executeBatch();
            //</editor-fold>

            conn.commit();
            conn.close();
            Lg.s(S1_uom.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//           conn.
        }
    }

    public static void update_status_stock_transfer_cloud(String transaction_no, int status, String at_location_id) {
        try {
            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);

            PreparedStatement stmt4 = conn.prepareStatement("");

            String s4 = "update stock_transfers set "
                    + " is_uploaded= :is_uploaded"
                    + " ,status= :status"
                    + " where "
                    + " transaction_no ='" + transaction_no + "' "
                    + " and at_location_id ='" + at_location_id + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setNumber("is_uploaded", status)
                    .setNumber("status", status)
                    .ok();

            stmt4.addBatch(s4);

            String s5 = "update stock_transfers_items set "
                    + " is_uploaded= :is_uploaded"
                    + " ,status= :status"
                    + " where "
                    + " stock_transfer_id ='" + transaction_no + "' "
                    + " and at_location_id ='" + at_location_id + "' "
                    + " ";

            s5 = SqlStringUtil.parse(s5)
                    .setNumber("is_uploaded", status)
                    .setNumber("status", status)
                    .ok();

            stmt4.addBatch(s5);
            stmt4.executeBatch();
            //</editor-fold>

            conn.commit();
            conn.close();
            Lg.s(S1_uom.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//           conn.
        }
    }

    public static void update_stock_transfers(Stock_transfers.to_stock_transfers to_stock_transfers) {
        try {
            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);

            String s0 = "update stock_transfers set "
                    + " transaction_no= :transaction_no "
                    + ",user_name= :user_name "
                    + ",date_added= :date_added "
                    + ",remarks= :remarks "
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + ",from_branch= :from_branch "
                    + ",from_branch_id= :from_branch_id "
                    + ",from_location= :from_location "
                    + ",from_location_id= :from_location_id "
                    + ",status= :status "
                    + " where transaction_no='" + to_stock_transfers.transaction_no + "' "
                    + " and at_location_id='" + to_stock_transfers.at_location_id + "' "
                    + " ";

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
                    .setNumber("status", to_stock_transfers.status)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update stock_transfers_items set "
                    + " branch= :branch"
                    + ",branch_code= :branch_code"
                    + ",location= :location"
                    + ",location_id= :location_id"
                    + ",to_branch= :branch"
                    + ",to_branch_id= :to_branch_id"
                    + ",to_location= :to_location"
                    + ",to_location_id= :to_location_id"
                    + " where "
                    + " stock_transfer_id ='" + to_stock_transfers.transaction_no + "' "
                    + " and at_location_id='" + to_stock_transfers.at_location_id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("branch", to_stock_transfers.from_branch)
                    .setString("branch_code", to_stock_transfers.from_branch_id)
                    .setString("location", to_stock_transfers.from_location)
                    .setString("location_id", to_stock_transfers.from_location_id)
                    .setString("to_branch", to_stock_transfers.to_branch)
                    .setString("to_branch_id", to_stock_transfers.to_branch_id)
                    .setString("to_location", to_stock_transfers.to_location)
                    .setString("to_location_id", to_stock_transfers.to_location_id)
                    .ok();

            stmt.addBatch(s2);
            stmt.executeBatch();
            conn.commit();

            Lg.s(Stock_transfers_items.class, "Successfully Updated");
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_items_stock_transfer(Stock_transfers.to_stock_transfers stock_transfer, List<Stock_transfers_items.to_stock_transfers_items> items_added, List<Stock_transfers_items.to_stock_transfers_items> items_edited, List<Stock_transfers_items.to_stock_transfers_items> items_deleted) {
        try {
            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);

            PreparedStatement stmt1 = conn.prepareStatement("");
            PreparedStatement stmt2 = conn.prepareStatement("");
            PreparedStatement stmt3 = conn.prepareStatement("");

            //<editor-fold defaultstate="collapsed" desc=" Stock Transfer Items ">
            for (Stock_transfers_items.to_stock_transfers_items to_stock_transfers_items : items_added) {
                String s3 = "insert into stock_transfers_items("
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

                s3 = SqlStringUtil.parse(s3)
                        .setString("barcode", to_stock_transfers_items.barcode)
                        .setString("description", to_stock_transfers_items.description)
                        .setString("generic_name", to_stock_transfers_items.generic_name)
                        .setString("category", to_stock_transfers_items.category)
                        .setString("category_id", to_stock_transfers_items.category_id)
                        .setString("classification", to_stock_transfers_items.classification)
                        .setString("classification_id", to_stock_transfers_items.classification_id)
                        .setString("sub_classification", to_stock_transfers_items.sub_classification)
                        .setString("sub_classification_id", to_stock_transfers_items.sub_classification_id)
                        .setNumber("product_qty", to_stock_transfers_items.product_qty)
                        .setString("unit", to_stock_transfers_items.unit)
                        .setNumber("conversion", to_stock_transfers_items.conversion)
                        .setNumber("selling_price", to_stock_transfers_items.selling_price)
                        .setString("date_added", to_stock_transfers_items.date_added)
                        .setString("user_name", to_stock_transfers_items.user_name)
                        .setString("item_type", to_stock_transfers_items.item_type)
                        .setNumber("status", to_stock_transfers_items.status)
                        .setString("supplier", to_stock_transfers_items.supplier)
                        .setNumber("fixed_price", to_stock_transfers_items.fixed_price)
                        .setNumber("cost", to_stock_transfers_items.cost)
                        .setString("supplier_id", to_stock_transfers_items.supplier_id)
                        .setNumber("multi_level_pricing", to_stock_transfers_items.multi_level_pricing)
                        .setNumber("vatable", to_stock_transfers_items.vatable)
                        .setNumber("reorder_level", to_stock_transfers_items.reorder_level)
                        .setNumber("markup", to_stock_transfers_items.markup)
                        .setString("barcodes", to_stock_transfers_items.barcodes)
                        .setString("brand", to_stock_transfers_items.brand)
                        .setString("brand_id", to_stock_transfers_items.brand_id)
                        .setString("model", to_stock_transfers_items.model)
                        .setString("model_id", to_stock_transfers_items.model_id)
                        .setNumber("selling_type", to_stock_transfers_items.selling_type)
                        .setString("branch", to_stock_transfers_items.branch)
                        .setString("branch_code", to_stock_transfers_items.branch_code)
                        .setString("location", to_stock_transfers_items.location)
                        .setString("location_id", to_stock_transfers_items.location_id)
                        .setString("stock_transfer_id", to_stock_transfers_items.stock_transfer_id)
                        .setString("serial_no", to_stock_transfers_items.serial_no)
                        .setString("to_branch", to_stock_transfers_items.to_branch)
                        .setString("to_branch_id", to_stock_transfers_items.to_branch_id)
                        .setString("to_location", to_stock_transfers_items.to_location)
                        .setString("to_location_id", to_stock_transfers_items.to_location_id)
                        .setString("at_branch", to_stock_transfers_items.at_branch)
                        .setString("at_branch_id", to_stock_transfers_items.at_branch_id)
                        .setString("at_location", to_stock_transfers_items.at_location)
                        .setString("at_location_id", to_stock_transfers_items.at_location_id)
                        .ok();
                stmt3.addBatch(s3);
            }
            stmt3.executeBatch();

            for (Stock_transfers_items.to_stock_transfers_items to_stock_transfers_items : items_edited) {
                String s0 = " update stock_transfers_items set "
                        + " product_qty= :product_qty"
                        + ",serial_no= :serial_no"
                        + " where "
                        + " id ='" + to_stock_transfers_items.id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setNumber("product_qty", to_stock_transfers_items.product_qty)
                        .setString("serial_no", to_stock_transfers_items.serial_no)
                        .ok();
                stmt2.addBatch(s0);
            }
            stmt2.executeBatch();
            for (Stock_transfers_items.to_stock_transfers_items to_stock_transfers_items : items_deleted) {
                String s0 = "delete from stock_transfers_items where "
                        + " id ='" + to_stock_transfers_items.id + "' "
                        + " ";

                stmt1.addBatch(s0);
            }
            stmt1.executeBatch();

            //</editor-fold>
            conn.commit();
            conn.close();
            Lg.s(S1_uom.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//           conn.
        }
    }
}
