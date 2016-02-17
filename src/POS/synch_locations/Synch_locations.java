/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.synch_locations;

import POS.branches_sessions.Parse_sales;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.my_sales.MySales;
import POS.util.MyConnection;
import POS.util.Segregator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Synch_locations {

    public static class to_synch_locations {

        public final int id;
        public final File inventory_counts;
        public final File receipts;
        public final File sales;
        public final File transfers;
        public final File adjustments;
        public final File returned_items;
        public final File charges;
        public final File rmas;
        public final File item_maintenances;
        public final File cash_drawers;
        public final int status;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_synch_locations(int id, File inventory_counts, File receipts, File sales, File transfers, File adjustments, File returned_items, File charges, File rmas, File item_maintenances, File cash_drawers, int status, String date_added, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.inventory_counts = inventory_counts;
            this.receipts = receipts;
            this.sales = sales;
            this.transfers = transfers;
            this.adjustments = adjustments;
            this.returned_items = returned_items;
            this.charges = charges;
            this.rmas = rmas;
            this.item_maintenances = item_maintenances;
            this.cash_drawers = cash_drawers;
            this.status = status;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }

    }

    public static void add_data(to_synch_locations to_synch_locations) {
        try {
            Connection conn = MyConnection.cloud_connect();
            System.out.println("Connected to Cloud!");
            String s0 = "insert into synch_locations("
                    + "inventory_counts"
                    + ",receipts"
                    + ",sales"
                    + ",transfers"
                    + ",adjustments"
                    + ",returned_items"
                    + ",charges"
                    + ",rmas"
                    + ",item_maintenances"
                    + ",cash_drawers"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(s0);
            try {
                InputStream inventory_counts = new FileInputStream(to_synch_locations.inventory_counts);
                InputStream receipts = new FileInputStream(to_synch_locations.receipts);
                InputStream sales = new FileInputStream(to_synch_locations.sales);
                InputStream transfers = new FileInputStream(to_synch_locations.transfers);
                InputStream adjustments = new FileInputStream(to_synch_locations.adjustments);
                InputStream returned_items = new FileInputStream(to_synch_locations.returned_items);
                InputStream charges = new FileInputStream(to_synch_locations.charges);
                InputStream rmas = new FileInputStream(to_synch_locations.rmas);
                InputStream item_maintenances = new FileInputStream(to_synch_locations.item_maintenances);
                InputStream cash_drawers = new FileInputStream(to_synch_locations.cash_drawers);

                stmt.setBinaryStream(1, inventory_counts, (int) to_synch_locations.inventory_counts.length());
                stmt.setBinaryStream(2, receipts, (int) to_synch_locations.receipts.length());
                stmt.setBinaryStream(3, sales, (int) to_synch_locations.sales.length());
                stmt.setBinaryStream(4, transfers, (int) to_synch_locations.transfers.length());
                stmt.setBinaryStream(5, adjustments, (int) to_synch_locations.adjustments.length());
                stmt.setBinaryStream(6, returned_items, (int) to_synch_locations.returned_items.length());
                stmt.setBinaryStream(7, charges, (int) to_synch_locations.charges.length());
                stmt.setBinaryStream(8, rmas, (int) to_synch_locations.rmas.length());
                stmt.setBinaryStream(9, item_maintenances, (int) to_synch_locations.item_maintenances.length());
                stmt.setBinaryStream(10, cash_drawers, (int) to_synch_locations.cash_drawers.length());

                stmt.setInt(11, to_synch_locations.status);
                stmt.setString(12, to_synch_locations.date_added);
                stmt.setString(13, to_synch_locations.user_id);
                stmt.setString(14, to_synch_locations.user_screen_name);
                stmt.setString(15, to_synch_locations.branch);
                stmt.setString(16, to_synch_locations.branch_id);
                stmt.setString(17, to_synch_locations.location);
                stmt.setString(18, to_synch_locations.location_id);
                stmt.execute();
                Lg.s(Synch_locations.class, "Successfully Added");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Synch_locations.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_synch_locations to_synch_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update synch_locations set "
                    + "inventory_counts= :inventory_counts "
                    + ",receipts= :receipts "
                    + ",sales= :sales "
                    + ",transfers= :transfers "
                    + ",adjustments= :adjustments "
                    + ",returned_items= :returned_items "
                    + ",charges= :charges "
                    + ",rmas= :rmas "
                    + ",item_maintenances= :item_maintenances "
                    + ",cash_drawers= :cash_drawers "
                    + ",status= :status "
                    + ",date_added= :date_added "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_synch_locations.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Synch_locations.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data_cloud(String id) {
        try {
            Connection conn = MyConnection.cloud_connect();
            String s0 = "update synch_locations set "
                    + "status= 0 "
                    + " where id='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Synch_locations.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_synch_locations to_synch_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from synch_locations  "
                    + " where id='" + to_synch_locations.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Synch_locations.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<to_synch_locations> datas = ret_data_cloud("");
        for (to_synch_locations to : datas) {
            File sales = to.sales;
            try {
                String contents = new Scanner(sales).useDelimiter("\\Z").next();
                System.out.println(contents);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Synch_locations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<to_synch_locations> ret_data_cloud(String where) {
        List<to_synch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.cloud_connect();
            String s0 = "select "
                    + "id"
                    + ",inventory_counts"
                    + ",receipts"
                    + ",sales"
                    + ",transfers"
                    + ",adjustments"
                    + ",returned_items"
                    + ",charges"
                    + ",rmas"
                    + ",item_maintenances"
                    + ",cash_drawers"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from synch_locations"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {

                int id = rs.getInt(1);
                File inventory_counts = new File("inventory_counts.txt");
                File receipts = new File("receipts.txt");
                File sales = new File("sales.txt");
                File transfers = new File("transfers.txt");
                File adjustments = new File("adjustments.txt");
                File returned_items = new File("returned_items.txt");
                File charges = new File("charges.txt");
                File rmas = new File("rmas.txt");
                File item_maintenances = new File("item_maintenances.txt");
                File cash_drawers = new File("cash_drawers.txt");

                Blob blob1 = rs.getBlob("inventory_counts");
                Blob blob2 = rs.getBlob("receipts");
                Blob blob3 = rs.getBlob("sales");
                Blob blob4 = rs.getBlob("transfers");
                Blob blob5 = rs.getBlob("adjustments");
                Blob blob6 = rs.getBlob("returned_items");
                Blob blob7 = rs.getBlob("charges");
                Blob blob8 = rs.getBlob("rmas");
                Blob blob9 = rs.getBlob("item_maintenances");
                Blob blob10 = rs.getBlob("cash_drawers");

                BlobToFile(blob1, inventory_counts);
                BlobToFile(blob2, receipts);
                BlobToFile(blob3, sales);
                BlobToFile(blob4, transfers);
                BlobToFile(blob5, adjustments);
                BlobToFile(blob6, returned_items);
                BlobToFile(blob7, charges);
                BlobToFile(blob8, rmas);
                BlobToFile(blob9, item_maintenances);
                BlobToFile(blob10, cash_drawers);

                
                
                int status = rs.getInt(12);
                String date_added = rs.getString(13);
                String user_id = rs.getString(14);
                String user_screen_name = rs.getString(15);
                String branch = rs.getString(16);
                String branch_id = rs.getString(17);
                String location = rs.getString(18);
                String location_id = rs.getString(19);

                to_synch_locations to = new to_synch_locations(id, inventory_counts, receipts, sales, transfers, adjustments, returned_items, charges, rmas, item_maintenances, cash_drawers, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void BlobToFile(Blob blob, File file) {

        String charsetName = "UTF-8";
        char[] buffer = new char[0x1000];
        StringBuilder s = new StringBuilder();

        String str = null;
        InputStream in;

        try {
            Reader r = null;
            try {
                in = blob.getBinaryStream();
                r = new InputStreamReader(in, charsetName);
            } catch (SQLException ex) {
                Logger.getLogger(Parse_sales.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int len; (len = r.read(buffer, 0, buffer.length)) != -1;) {
                s.append(buffer, 0, len);
            }
        } catch (IOException ex) {
            Logger.getLogger(Synch_locations.class.getName()).log(Level.SEVERE, null, ex);
        }
        str = s.toString();

        FileWriter fw;
        FileWriter fw2;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Parse_sales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<to_synch_locations> ret_data(String where) {
        List<to_synch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",inventory_counts"
                    + ",receipts"
                    + ",sales"
                    + ",transfers"
                    + ",adjustments"
                    + ",returned_items"
                    + ",charges"
                    + ",rmas"
                    + ",item_maintenances"
                    + ",cash_drawers"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from synch_locations"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {

                int id = rs.getInt(1);
                File inventory_counts = new File("");
                File receipts = new File("");
                File sales = new File("sales.txt");
                File transfers = new File("");
                File adjustments = new File("");
                File returned_items = new File("");
                File charges = new File("");
                File rmas = new File("");
                File item_maintenances = new File("");
                File cash_drawers = new File("");

                String charsetName = "UTF-8";
                char[] buffer = new char[0x1000];
                StringBuilder s = new StringBuilder();
                Blob blob = rs.getBlob("sales");
                String str = null;
                InputStream in = blob.getBinaryStream();
                Reader r;
                try {
                    r = new InputStreamReader(in, charsetName);
                    try {
                        for (int len; (len = r.read(buffer, 0, buffer.length)) != -1;) {
                            s.append(buffer, 0, len);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Synch_locations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    str = s.toString();

                    FileWriter fw;
                    FileWriter fw2;
                    try {
                        fw = new FileWriter(sales.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(str);
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Parse_sales.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Synch_locations.class.getName()).log(Level.SEVERE, null, ex);
                }

                int status = rs.getInt(12);
                String date_added = rs.getString(13);
                String user_id = rs.getString(14);
                String user_screen_name = rs.getString(15);
                String branch = rs.getString(16);
                String branch_id = rs.getString(17);
                String location = rs.getString(18);
                String location_id = rs.getString(19);

                to_synch_locations to = new to_synch_locations(id, inventory_counts, receipts, sales, transfers, adjustments, returned_items, charges, rmas, item_maintenances, cash_drawers, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String add_sales(List<Parse_sales.field> sales) throws SQLException {
        try {
            Connection conn = MyConnection.connect();
            String c_date = DateType.sf.format(new Date());

            conn.setAutoCommit(false);

            for (Parse_sales.field to_sales : sales) {
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

                for (Parse_sales.field.items to_sale_items : to_sales.items) {
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

                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_sale_items.item_code, to_sale_items.barcode, to_sale_items.location_id);
                    double conversion = tt.conversion;
                    double new_qty = tt.product_qty - (1 * to_sale_items.qty);

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
                            .setString("branch_code", to_sales.branch_id)
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

                    String serial_no = Segregator.this_shit(tt.serial_no, to_sale_items.serial_nos);
                    String s4 = " update inventory_barcodes set "
                            + " product_qty='" + new_qty + "'"
                            + " where  main_barcode= '" + to_sale_items.item_code + "' and location_id='" + to_sale_items.location_id + "' "
                            + "";
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt.addBatch(s4);
                    Lg.s(Inventory.class, "Successfully Updated");

                }
                stmt.executeBatch();
            }

            conn.commit();
            Lg.s(MySales.class, "Item Committed");
            Lg.s(MySales.class, "Successfully Added");

            return "";
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            MyConnection.close();
        }
    }
}
