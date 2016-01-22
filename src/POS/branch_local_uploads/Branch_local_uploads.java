/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

import POS.synch_locations.Synch_locations;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Branch_local_uploads {

    public static class to_branch_local_uploads {

        public final int id;
        public final File replenishments;
        public final File inventory_counts;
        public final File adjustments;
        public final File stock_transfers;
        public final File receipts;
        public final File sales;
        public final File returned_items;
        public final File charged_items;
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

        public to_branch_local_uploads(int id, File replenishments, File inventory_counts, File adjustments, File stock_transfers, File receipts, File sales, File returned_items, File charged_items, File rmas, File item_maintenances, File cash_drawers, int status, String date_added, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.replenishments = replenishments;
            this.inventory_counts = inventory_counts;
            this.adjustments = adjustments;
            this.stock_transfers = stock_transfers;
            this.receipts = receipts;
            this.sales = sales;
            this.returned_items = returned_items;
            this.charged_items = charged_items;
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

    public static void add_data(List<Branch_local_uploads.to_branch_local_uploads> to_branch_local_uploads1) {
        try {
            Connection conn = MyConnection.cloud_connect();

            for (Branch_local_uploads.to_branch_local_uploads to_branch_local_uploads : to_branch_local_uploads1) {
                String s0 = "insert into branch_local_uploads("
                        + "replenishments"
                        + ",inventory_counts"
                        + ",adjustments"
                        + ",stock_transfers"
                        + ",receipts"
                        + ",sales"
                        + ",returned_items"
                        + ",charged_items"
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
                        + ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                        + "";

                PreparedStatement stmt = conn.prepareStatement(s0);
                try {
                    InputStream replenishments = new FileInputStream(to_branch_local_uploads.replenishments);
                    InputStream inventory_counts = new FileInputStream(to_branch_local_uploads.inventory_counts);
                    InputStream adjustments = new FileInputStream(to_branch_local_uploads.adjustments);
                    InputStream stock_transfers = new FileInputStream(to_branch_local_uploads.stock_transfers);
                    InputStream receipts = new FileInputStream(to_branch_local_uploads.receipts);
                    InputStream sales = new FileInputStream(to_branch_local_uploads.sales);
                    InputStream returned_items = new FileInputStream(to_branch_local_uploads.returned_items);
                    InputStream charged_items = new FileInputStream(to_branch_local_uploads.charged_items);
                    InputStream rmas = new FileInputStream(to_branch_local_uploads.rmas);
                    InputStream item_maintenances = new FileInputStream(to_branch_local_uploads.item_maintenances);
                    InputStream cash_drawers = new FileInputStream(to_branch_local_uploads.cash_drawers);
                    stmt.setBinaryStream(1, replenishments, (int) to_branch_local_uploads.replenishments.length());
                    stmt.setBinaryStream(2, inventory_counts, (int) to_branch_local_uploads.inventory_counts.length());
                    stmt.setBinaryStream(3, adjustments, (int) to_branch_local_uploads.adjustments.length());
                    stmt.setBinaryStream(4, stock_transfers, (int) to_branch_local_uploads.stock_transfers.length());
                    stmt.setBinaryStream(5, receipts, (int) to_branch_local_uploads.receipts.length());
                    stmt.setBinaryStream(6, sales, (int) to_branch_local_uploads.sales.length());
                    stmt.setBinaryStream(7, returned_items, (int) to_branch_local_uploads.returned_items.length());
                    stmt.setBinaryStream(8, charged_items, (int) to_branch_local_uploads.charged_items.length());
                    stmt.setBinaryStream(9, rmas, (int) to_branch_local_uploads.rmas.length());
                    stmt.setBinaryStream(10, item_maintenances, (int) to_branch_local_uploads.item_maintenances.length());
                    stmt.setBinaryStream(11, cash_drawers, (int) to_branch_local_uploads.cash_drawers.length());
                    stmt.setInt(12, to_branch_local_uploads.status);
                    stmt.setString(13, to_branch_local_uploads.date_added);
                    stmt.setString(14, to_branch_local_uploads.user_id);
                    stmt.setString(15, to_branch_local_uploads.user_screen_name);
                    stmt.setString(16, to_branch_local_uploads.branch);
                    stmt.setString(17, to_branch_local_uploads.branch_id);
                    stmt.setString(18, to_branch_local_uploads.location);
                    stmt.setString(19, to_branch_local_uploads.location_id);
                    stmt.execute();
                    Lg.s(Synch_locations.class, "Successfully Added");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Branch_local_uploads.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_branch_local_uploads to_branch_local_uploads) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update branch_local_uploads set "
                    + "replenishments= :replenishments "
                    + ",inventory_counts= :inventory_counts "
                    + ",adjustments= :adjustments "
                    + ",stock_transfers= :stock_transfers "
                    + ",receipts= :receipts "
                    + ",sales= :sales "
                    + ",returned_items= :returned_items "
                    + ",charged_items= :charged_items "
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
                    + " where id='" + to_branch_local_uploads.id + "' "
                    + " ";

//            s0 = SqlStringUtil.parse(s0)
//                    .setString("replenishments", to_branch_local_uploads.replenishments)
//                    .setString("inventory_counts", to_branch_local_uploads.inventory_counts)
//                    .setString("adjustments", to_branch_local_uploads.adjustments)
//                    .setString("stock_transfers", to_branch_local_uploads.stock_transfers)
//                    .setString("receipts", to_branch_local_uploads.receipts)
//                    .setString("sales", to_branch_local_uploads.sales)
//                    .setString("returned_items", to_branch_local_uploads.returned_items)
//                    .setString("charged_items", to_branch_local_uploads.charged_items)
//                    .setString("rmas", to_branch_local_uploads.rmas)
//                    .setString("item_maintenances", to_branch_local_uploads.item_maintenances)
//                    .setString("cash_drawers", to_branch_local_uploads.cash_drawers)
//                    .setNumber("status", to_branch_local_uploads.status)
//                    .setString("date_added", to_branch_local_uploads.date_added)
//                    .setString("user_id", to_branch_local_uploads.user_id)
//                    .setString("user_screen_name", to_branch_local_uploads.user_screen_name)
//                    .setString("branch", to_branch_local_uploads.branch)
//                    .setString("branch_id", to_branch_local_uploads.branch_id)
//                    .setString("location", to_branch_local_uploads.location)
//                    .setString("location_id", to_branch_local_uploads.location_id)
//                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Branch_local_uploads.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_branch_local_uploads to_branch_local_uploads) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from branch_local_uploads  "
                    + " where id='" + to_branch_local_uploads.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Branch_local_uploads.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_local_uploads> ret_data(String where) {
        List<to_branch_local_uploads> datas = new ArrayList();
        try {
            Connection conn = MyConnection.cloud_connect();
            String s0 = "select "
                    + "id"
                    + ",replenishments"
                    + ",inventory_counts"
                    + ",adjustments"
                    + ",stock_transfers"
                    + ",receipts"
                    + ",sales"
                    + ",returned_items"
                    + ",charged_items"
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
                    + " from branch_local_uploads"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String replenishments = rs.getString(2);
                String inventory_counts = rs.getString(3);
                String adjustments = rs.getString(4);
                String stock_transfers = rs.getString(5);
                String receipts = rs.getString(6);
                String sales = rs.getString(7);
                String returned_items = rs.getString(8);
                String charged_items = rs.getString(9);
                String rmas = rs.getString(10);
                String item_maintenances = rs.getString(11);
                String cash_drawers = rs.getString(12);
                int status = rs.getInt(13);
                String date_added = rs.getString(14);
                String user_id = rs.getString(15);
                String user_screen_name = rs.getString(16);
                String branch = rs.getString(17);
                String branch_id = rs.getString(18);
                String location = rs.getString(19);
                String location_id = rs.getString(20);

                to_branch_local_uploads to = new to_branch_local_uploads(id, null, null, null, null, null, null, null, null, null, null, null, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> getDates(String from) {
        List<String> days = new ArrayList();
        try {
            Date from2 = DateType.sf.parse(from);
            Date to = new Date();
            int count = DateUtils1.count_days(from2, to);
            for (int i = 1; i < count + 1; i++) {
                Date from1 = DateType.sf.parse(from);
                Date inc = DateUtils1.add_day(from1, i);
                String date = DateType.sf.format(inc);
                days.add(date);
            }

        } catch (ParseException ex) {
            Logger.getLogger(Branch_local_uploads.class.getName()).log(Level.SEVERE, null, ex);
        }
        return days;

    }

}
