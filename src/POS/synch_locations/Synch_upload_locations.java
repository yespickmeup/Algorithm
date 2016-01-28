/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.synch_locations;

import POS.branch_local_uploads.Parse_sales;
import POS.util.MyConnection;
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
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Guinness
 */
public class Synch_upload_locations {

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

    public static void add_data(Synch_locations.to_synch_locations to_synch_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into synch_upload_locations("
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
                Lg.s(Synch_upload_locations.class, "Successfully Added");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Synch_upload_locations.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_list(List<Synch_locations.to_synch_locations> to_synch_locations1) {
        try {
            Connection conn = MyConnection.connect();
            Connection conn2 = MyConnection.cloud_connect();

            for (Synch_locations.to_synch_locations to_synch_locations : to_synch_locations1) {
                String s0 = "insert into synch_locations("
                        + " inventory_counts"
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
                    Lg.s(Synch_upload_locations.class, "Successfully Added");

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Synch_upload_locations.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String s2 = "update synch_locations set "
                        + " status= 1 "
                        + " where id='" + to_synch_locations.id + "' "
                        + " ";
                
                PreparedStatement stmt2 = conn2.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Synch_locations.class, "Successfully Updated");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(Synch_upload_locations.to_synch_locations to_synch_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update synch_upload_locations set "
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
            Lg.s(Synch_upload_locations.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(Synch_upload_locations.to_synch_locations to_synch_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from synch_upload_locations  "
                    + " where id='" + to_synch_locations.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Synch_upload_locations.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main2(String[] args) {
        List<Synch_upload_locations.to_synch_locations> datas = ret_data_cloud("");
        for (Synch_upload_locations.to_synch_locations to : datas) {
            File sales = to.sales;
            try {
                String contents = new Scanner(sales).useDelimiter("\\Z").next();
                System.out.println(contents);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Synch_upload_locations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<Synch_upload_locations.to_synch_locations> ret_data_cloud(String where) {
        List<Synch_upload_locations.to_synch_locations> datas = new ArrayList();
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
                    + " from synch_upload_locations"
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
                        Logger.getLogger(Synch_upload_locations.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Synch_upload_locations.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                int status = rs.getInt(12);
                String date_added = rs.getString(13);
                String user_id = rs.getString(14);
                String user_screen_name = rs.getString(15);
                String branch = rs.getString(16);
                String branch_id = rs.getString(17);
                String location = rs.getString(18);
                String location_id = rs.getString(19);

                Synch_upload_locations.to_synch_locations to = new Synch_upload_locations.to_synch_locations(id, inventory_counts, receipts, sales, transfers, adjustments, returned_items, charges, rmas, item_maintenances, cash_drawers, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Synch_locations.to_synch_locations> ret_data(String where) {
        List<Synch_locations.to_synch_locations> datas = new ArrayList();
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
                    + " from synch_upload_locations"
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
                        Logger.getLogger(Synch_upload_locations.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Synch_upload_locations.class.getName()).log(Level.SEVERE, null, ex);
                }

                int status = rs.getInt(12);
                String date_added = rs.getString(13);
                String user_id = rs.getString(14);
                String user_screen_name = rs.getString(15);
                String branch = rs.getString(16);
                String branch_id = rs.getString(17);
                String location = rs.getString(18);
                String location_id = rs.getString(19);

                Synch_locations.to_synch_locations to = new Synch_locations.to_synch_locations(id, inventory_counts, receipts, sales, transfers, adjustments, returned_items, charges, rmas, item_maintenances, cash_drawers, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
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
