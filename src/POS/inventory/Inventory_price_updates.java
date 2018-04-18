/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Inventory_price_updates {

    public static class to_inventory_price_updates {

        public final int id;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final String old_unit;
        public String unit;
        public double conversion;
        public final double old_selling_price;
        public double selling_price;
        public final int update_all_branch;
        public final int status;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final int is_uploaded;
        public final String ipu_no;
        public final String at_branch;
        public final String at_branch_id;
        public final String at_location;
        public final String at_location_id;

        public to_inventory_price_updates(int id, String item_code, String barcode, String description, String old_unit, String unit, double conversion, double old_selling_price, double selling_price, int update_all_branch, int status, String date_added, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id, int is_uploaded,
                String ipu_no, String at_branch, String at_branch_id, String at_location, String at_location_id) {
            this.id = id;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.old_unit = old_unit;
            this.unit = unit;
            this.conversion = conversion;
            this.old_selling_price = old_selling_price;
            this.selling_price = selling_price;
            this.update_all_branch = update_all_branch;
            this.status = status;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.is_uploaded = is_uploaded;
            this.ipu_no = ipu_no;
            this.at_branch = at_branch;
            this.at_branch_id = at_branch_id;
            this.at_location = at_location;
            this.at_location_id = at_location_id;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

    }

    public static void add_data(to_inventory_price_updates to_inventory_price_updates) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_price_updates("
                    + "item_code"
                    + ",barcode"
                    + ",description"
                    + ",old_unit"
                    + ",unit"
                    + ",conversion"
                    + ",old_selling_price"
                    + ",selling_price"
                    + ",update_all_branch"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",is_uploaded"
                    + ",ipu_no"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + ")values("
                    + ":item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:old_unit"
                    + ",:unit"
                    + ",:conversion"
                    + ",:old_selling_price"
                    + ",:selling_price"
                    + ",:update_all_branch"
                    + ",:status"
                    + ",:date_added"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:is_uploaded"
                    + ",:ipu_no"
                    + ",:at_branch"
                    + ",:at_branch_id"
                    + ",:at_location"
                    + ",:at_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_code", to_inventory_price_updates.item_code)
                    .setString("barcode", to_inventory_price_updates.barcode)
                    .setString("description", to_inventory_price_updates.description)
                    .setString("old_unit", to_inventory_price_updates.old_unit)
                    .setString("unit", to_inventory_price_updates.unit)
                    .setNumber("conversion", to_inventory_price_updates.conversion)
                    .setNumber("old_selling_price", to_inventory_price_updates.old_selling_price)
                    .setNumber("selling_price", to_inventory_price_updates.selling_price)
                    .setNumber("update_all_branch", to_inventory_price_updates.update_all_branch)
                    .setNumber("status", to_inventory_price_updates.status)
                    .setString("date_added", to_inventory_price_updates.date_added)
                    .setString("user_id", to_inventory_price_updates.user_id)
                    .setString("user_screen_name", to_inventory_price_updates.user_screen_name)
                    .setString("branch", to_inventory_price_updates.branch)
                    .setString("branch_id", to_inventory_price_updates.branch_id)
                    .setString("location", to_inventory_price_updates.location)
                    .setString("location_id", to_inventory_price_updates.location_id)
                    .setNumber("is_uploaded", to_inventory_price_updates.is_uploaded)
                    .setString("ipu_no", to_inventory_price_updates.ipu_no)
                    .setString("at_branch", to_inventory_price_updates.at_branch)
                    .setString("at_branch_id", to_inventory_price_updates.at_branch_id)
                    .setString("at_location", to_inventory_price_updates.at_location)
                    .setString("at_location_id", to_inventory_price_updates.at_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_price_updates.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(List<to_inventory_price_updates> to_inventory_price_updates1) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();

            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
            PreparedStatement stmt2 = conn2.prepareStatement("");
            for (to_inventory_price_updates to_inventory_price_updates : to_inventory_price_updates1) {
                String s0 = "insert into inventory_price_updates("
                        + "item_code"
                        + ",barcode"
                        + ",description"
                        + ",old_unit"
                        + ",unit"
                        + ",conversion"
                        + ",old_selling_price"
                        + ",selling_price"
                        + ",update_all_branch"
                        + ",status"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",is_uploaded"
                        + ",ipu_no"
                        + ",at_branch"
                        + ",at_branch_id"
                        + ",at_location"
                        + ",at_location_id"
                        + ")values("
                        + ":item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:old_unit"
                        + ",:unit"
                        + ",:conversion"
                        + ",:old_selling_price"
                        + ",:selling_price"
                        + ",:update_all_branch"
                        + ",:status"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:is_uploaded"
                        + ",:ipu_no"
                        + ",:at_branch"
                        + ",:at_branch_id"
                        + ",:at_location"
                        + ",:at_location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("item_code", to_inventory_price_updates.item_code)
                        .setString("barcode", to_inventory_price_updates.barcode)
                        .setString("description", to_inventory_price_updates.description)
                        .setString("old_unit", to_inventory_price_updates.old_unit)
                        .setString("unit", to_inventory_price_updates.unit)
                        .setNumber("conversion", to_inventory_price_updates.conversion)
                        .setNumber("old_selling_price", to_inventory_price_updates.old_selling_price)
                        .setNumber("selling_price", to_inventory_price_updates.selling_price)
                        .setNumber("update_all_branch", to_inventory_price_updates.update_all_branch)
                        .setNumber("status", to_inventory_price_updates.status)
                        .setString("date_added", to_inventory_price_updates.date_added)
                        .setString("user_id", to_inventory_price_updates.user_id)
                        .setString("user_screen_name", to_inventory_price_updates.user_screen_name)
                        .setString("branch", to_inventory_price_updates.branch)
                        .setString("branch_id", to_inventory_price_updates.branch_id)
                        .setString("location", to_inventory_price_updates.location)
                        .setString("location_id", to_inventory_price_updates.location_id)
                        .setNumber("is_uploaded", to_inventory_price_updates.is_uploaded)
                        .setString("ipu_no", to_inventory_price_updates.ipu_no)
                        .setString("at_branch", to_inventory_price_updates.at_branch)
                        .setString("at_branch_id", to_inventory_price_updates.at_branch_id)
                        .setString("at_location", to_inventory_price_updates.at_location)
                        .setString("at_location_id", to_inventory_price_updates.at_location_id)
                        .ok();

                stmt.addBatch(s0);

                String s2 = " update inventory_price_updates set is_uploaded=1 where id='" + to_inventory_price_updates.id + "' ";
                stmt2.addBatch(s2);
            }

            stmt.executeBatch();
            stmt2.executeBatch();
            conn.commit();
            conn2.commit();
            Lg.s(Inventory_price_updates.class, "Successfully Added");

            conn.close();
            MyConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_item(List<to_inventory_price_updates> datas) {
        try {
            Connection conn = MyConnection.connect();

            for (to_inventory_price_updates to : datas) {
                if (to.status == 0) {
                    String where = " where branch_code='" + to.branch_id + "' and main_barcode='" + to.item_code + "' ";
                    int update_all_branches = to.update_all_branch;
                    if (update_all_branches == 0) {
                        where = " where branch_code='" + to.branch_id + "' and main_barcode='" + to.item_code + "' ";
                    } else {
                        where = " where  main_barcode='" + to.item_code + "' ";
                    }

                    if (update_all_branches == 1) {
                        String s0 = "update inventory set "
                                + " unit= :unit"
                                + ",conversion= :conversion"
                                + ",selling_price= :selling_price"
                                + " where "
                                + " barcode ='" + to.item_code + "' "
                                + " ";

                        s0 = SqlStringUtil.parse(s0).
                                setString("unit", to.unit).
                                setNumber("conversion", to.conversion).
                                setNumber("selling_price", to.selling_price).
                                ok();
                        PreparedStatement stmt = conn.prepareStatement(s0);
                        stmt.execute();
                    }

                    Lg.s(Inventory.class, "Successfully Updated");

                    String s2 = "update inventory_barcodes set "
                            + " unit= :unit"
                            + ",conversion= :conversion"
                            + ",selling_price= :selling_price"
                            + " " + where;
                    s2 = SqlStringUtil.parse(s2).
                            setString("unit", to.unit).
                            setNumber("conversion", to.conversion).
                            setNumber("selling_price", to.selling_price).
                            ok();
                    System.out.println(s2);
                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();

                    String s3 = "update inventory_price_updates set "
                            + " status= :status"
                            + " where id='" + to.id + "' ";
                    s3 = SqlStringUtil.parse(s3).
                            setNumber("status", 1).
                            ok();

                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt3.execute();

                    Lg.s(Inventory_barcodes.class, "Successfully Updated");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_ipu_finalized(List<to_inventory_price_updates> datas) {
        try {
            Connection conn = MyConnection.connect();
            Connection conn2 = MyConnection.cloud_connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);

            PreparedStatement stmt2 = conn.prepareStatement("");
            PreparedStatement stmt3 = conn2.prepareStatement("");
            for (to_inventory_price_updates to : datas) {

                String s2 = "update inventory_barcodes set "
                        + " unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where main_barcode='" + to.item_code + "' and branch_code='" + to.branch_id + "' ";
                s2 = SqlStringUtil.parse(s2).
                        setString("unit", to.unit).
                        setNumber("conversion", to.conversion).
                        setNumber("selling_price", to.selling_price).
                        ok();

                stmt2.addBatch(s2);

                String s3 = "update inventory_price_updates set "
                        + " status= :status"
                        + ",unit= :unit"
                        + ",conversion= :conversion"
                        + ",selling_price= :selling_price"
                        + " where ipu_no='" + to.ipu_no + "' ";
                s3 = SqlStringUtil.parse(s3).
                        setNumber("status", 1).
                        setString("unit", to.unit).
                        setNumber("conversion", to.conversion).
                        setNumber("selling_price", to.selling_price).
                        ok();

                stmt2.addBatch(s3);

                String s4 = "update inventory_price_updates set status=1 where ipu_no='" + to.ipu_no + "' ";
                stmt3.addBatch(s4);
            }

            stmt2.executeBatch();
            stmt3.executeBatch();

            conn.commit();
            conn2.commit();

            conn.close();
            conn2.close();

            Lg.s(Inventory_barcodes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_item2(List<to_inventory_price_updates> datas) {
        try {
            Connection conn = MyConnection.connect();

            for (to_inventory_price_updates to : datas) {
                if (to.status == 0) {
                    String where = " where branch_code='" + to.branch_id + "' and main_barcode='" + to.item_code + "' ";
                    int update_all_branches = to.update_all_branch;
                    if (update_all_branches == 0) {
                        where = " where branch_code='" + to.branch_id + "' and main_barcode='" + to.item_code + "' ";
                    } else {
                        where = " where  main_barcode='" + to.item_code + "' ";
                    }

                    if (update_all_branches == 1) {
                        String s0 = "update inventory set "
                                + " unit= :unit"
                                + ",conversion= :conversion"
                                + ",selling_price= :selling_price"
                                + " where "
                                + " barcode ='" + to.item_code + "' "
                                + " ";

                        s0 = SqlStringUtil.parse(s0).
                                setString("unit", to.unit).
                                setNumber("conversion", to.conversion).
                                setNumber("selling_price", to.selling_price).
                                ok();
                        PreparedStatement stmt = conn.prepareStatement(s0);
                        stmt.execute();
                    }

                    Lg.s(Inventory.class, "Successfully Updated");

                    String s2 = "update inventory_barcodes set "
                            + " unit= :unit"
                            + ",conversion= :conversion"
                            + ",selling_price= :selling_price"
                            + " " + where;
                    s2 = SqlStringUtil.parse(s2).
                            setString("unit", to.unit).
                            setNumber("conversion", to.conversion).
                            setNumber("selling_price", to.selling_price).
                            ok();
                    System.out.println(s2);
                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();

                    String s3 = "update inventory_price_updates set "
                            + " status= :status"
                            + " where id='" + to.id + "' ";
                    s3 = SqlStringUtil.parse(s3).
                            setNumber("status", 1).
                            ok();

                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt3.execute();

                    Lg.s(Inventory_barcodes.class, "Successfully Updated");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_inventory_price_updates to_inventory_price_updates) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_price_updates set "
                    + "item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",old_unit= :old_unit "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",old_selling_price= :old_selling_price "
                    + ",selling_price= :selling_price "
                    + ",update_all_branch= :update_all_branch "
                    + ",status= :status "
                    + ",date_added= :date_added "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_inventory_price_updates.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_code", to_inventory_price_updates.item_code)
                    .setString("barcode", to_inventory_price_updates.barcode)
                    .setString("description", to_inventory_price_updates.description)
                    .setString("old_unit", to_inventory_price_updates.old_unit)
                    .setString("unit", to_inventory_price_updates.unit)
                    .setNumber("conversion", to_inventory_price_updates.conversion)
                    .setNumber("old_selling_price", to_inventory_price_updates.old_selling_price)
                    .setNumber("selling_price", to_inventory_price_updates.selling_price)
                    .setNumber("update_all_branch", to_inventory_price_updates.update_all_branch)
                    .setNumber("status", to_inventory_price_updates.status)
                    .setString("date_added", to_inventory_price_updates.date_added)
                    .setString("user_id", to_inventory_price_updates.user_id)
                    .setString("user_screen_name", to_inventory_price_updates.user_screen_name)
                    .setString("branch", to_inventory_price_updates.branch)
                    .setString("branch_id", to_inventory_price_updates.branch_id)
                    .setString("location", to_inventory_price_updates.location)
                    .setString("location_id", to_inventory_price_updates.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_price_updates.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_price_request(List<to_inventory_price_updates> to_inventory_price_updates1) {
        try {
            Connection conn = MyConnection.connect();
            Connection conn2 = MyConnection.cloud_connect();

            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
            PreparedStatement stmt2 = conn2.prepareStatement("");
            for (to_inventory_price_updates to_inventory_price_updates : to_inventory_price_updates1) {
                String s0 = "insert into inventory_price_updates("
                        + "item_code"
                        + ",barcode"
                        + ",description"
                        + ",old_unit"
                        + ",unit"
                        + ",conversion"
                        + ",old_selling_price"
                        + ",selling_price"
                        + ",update_all_branch"
                        + ",status"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",is_uploaded"
                        + ",ipu_no"
                        + ",at_branch"
                        + ",at_branch_id"
                        + ",at_location"
                        + ",at_location_id"
                        + ")values("
                        + ":item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:old_unit"
                        + ",:unit"
                        + ",:conversion"
                        + ",:old_selling_price"
                        + ",:selling_price"
                        + ",:update_all_branch"
                        + ",:status"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ",:is_uploaded"
                        + ",:ipu_no"
                        + ",:at_branch"
                        + ",:at_branch_id"
                        + ",:at_location"
                        + ",:at_location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("item_code", to_inventory_price_updates.item_code)
                        .setString("barcode", to_inventory_price_updates.barcode)
                        .setString("description", to_inventory_price_updates.description)
                        .setString("old_unit", to_inventory_price_updates.old_unit)
                        .setString("unit", to_inventory_price_updates.unit)
                        .setNumber("conversion", to_inventory_price_updates.conversion)
                        .setNumber("old_selling_price", to_inventory_price_updates.old_selling_price)
                        .setNumber("selling_price", to_inventory_price_updates.selling_price)
                        .setNumber("update_all_branch", to_inventory_price_updates.update_all_branch)
                        .setNumber("status", 1)
                        .setString("date_added", to_inventory_price_updates.date_added)
                        .setString("user_id", to_inventory_price_updates.user_id)
                        .setString("user_screen_name", to_inventory_price_updates.user_screen_name)
                        .setString("branch", to_inventory_price_updates.branch)
                        .setString("branch_id", to_inventory_price_updates.branch_id)
                        .setString("location", to_inventory_price_updates.location)
                        .setString("location_id", to_inventory_price_updates.location_id)
                        .setNumber("is_uploaded", 1)
                        .setString("ipu_no", to_inventory_price_updates.ipu_no)
                        .setString("at_branch", to_inventory_price_updates.at_branch)
                        .setString("at_branch_id", to_inventory_price_updates.at_branch_id)
                        .setString("at_location", to_inventory_price_updates.at_location)
                        .setString("at_location_id", to_inventory_price_updates.at_location_id)
                        .ok();

                stmt.addBatch(s0);

                String s2 = " update inventory_price_updates set is_uploaded=1"
                        + ",unit=:unit"
                        + ",selling_price=:selling_price"
                        + ",conversion=:conversion"
                        + " where ipu_no='" + to_inventory_price_updates.ipu_no + "' ";
                s2 = SqlStringUtil.parse(s2)
                        .setString("unit", to_inventory_price_updates.unit)
                        .setNumber("selling_price", to_inventory_price_updates.selling_price)
                        .setNumber("conversion", to_inventory_price_updates.conversion)
                        .ok();
                stmt2.addBatch(s2);
            }

            stmt.executeBatch();
            stmt2.executeBatch();
            conn.commit();
            conn2.commit();
            Lg.s(Inventory_price_updates.class, "Successfully Added");

            conn.close();
            MyConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void delete_data(to_inventory_price_updates to_inventory_price_updates) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_price_updates  "
                    + " where id='" + to_inventory_price_updates.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_price_updates.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_price_updates> ret_data(String where) {
        List<to_inventory_price_updates> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",old_unit"
                    + ",unit"
                    + ",conversion"
                    + ",old_selling_price"
                    + ",selling_price"
                    + ",update_all_branch"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",is_uploaded"
                    + ",ipu_no"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + " from inventory_price_updates"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String old_unit = rs.getString(5);
                String unit = rs.getString(6);
                double conversion = rs.getDouble(7);
                double old_selling_price = rs.getDouble(8);
                double selling_price = rs.getDouble(9);
                int update_all_branch = rs.getInt(10);
                int status = rs.getInt(11);
                String date_added = rs.getString(12);
                String user_id = rs.getString(13);
                String user_screen_name = rs.getString(14);
                String branch = rs.getString(15);
                String branch_id = rs.getString(16);
                String location = rs.getString(17);
                String location_id = rs.getString(18);
                int is_uploaded = rs.getInt(19);
                String ipu_no = rs.getString(20);
                String at_branch = rs.getString(21);
                String at_branch_id = rs.getString(22);
                String at_location = rs.getString(23);
                String at_location_id = rs.getString(24);
                to_inventory_price_updates to = new to_inventory_price_updates(id, item_code, barcode, description, old_unit, unit, conversion, old_selling_price, selling_price, update_all_branch, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id, is_uploaded, ipu_no, at_branch, at_branch_id, at_location, at_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_price_updates> ret_data_cloud(String where) {
        List<to_inventory_price_updates> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",old_unit"
                    + ",unit"
                    + ",conversion"
                    + ",old_selling_price"
                    + ",selling_price"
                    + ",update_all_branch"
                    + ",status"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",is_uploaded"
                    + ",ipu_no"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + " from inventory_price_updates"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String old_unit = rs.getString(5);
                String unit = rs.getString(6);
                double conversion = rs.getDouble(7);
                double old_selling_price = rs.getDouble(8);
                double selling_price = rs.getDouble(9);
                int update_all_branch = rs.getInt(10);
                int status = rs.getInt(11);
                String date_added = rs.getString(12);
                String user_id = rs.getString(13);
                String user_screen_name = rs.getString(14);
                String branch = rs.getString(15);
                String branch_id = rs.getString(16);
                String location = rs.getString(17);
                String location_id = rs.getString(18);
                int is_uploaded = rs.getInt(19);
                String ipu_no = rs.getString(20);
                String at_branch = rs.getString(21);
                String at_branch_id = rs.getString(22);
                String at_location = rs.getString(23);
                String at_location_id = rs.getString(24);
                to_inventory_price_updates to = new to_inventory_price_updates(id, item_code, barcode, description, old_unit, unit, conversion, old_selling_price, selling_price, update_all_branch, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id, is_uploaded, ipu_no, at_branch, at_branch_id, at_location, at_location_id);
                datas.add(to);
            }

            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static String increment_id(String branch_id) {
        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from inventory_price_updates where at_branch_id='" + branch_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select ipu_no from inventory_price_updates where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = branch_id + "|00000";
            }
            id = ReceiptIncrementor.increment(id);
            MyConnection.close();
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
