/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

import POS.branch_local_uploads.Branch_local_uploads.to_upload_count;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Maytopacka
 */
public class Parse_inventory_replenishments {

    String inventory_replenishment_no;
    String date_added;
    String user_id;
    String user_screen_name;
    String remarks;
    int status;
    String branch;
    String branch_id;
    String location;
    String location_id;
    List<items> items;

    public Parse_inventory_replenishments(String inventory_replenishment_no, String date_added, String user_id, String user_screen_name, String remarks, int status, String branch, String branch_id, String location, String location_id, List<items> items) {
        this.inventory_replenishment_no = inventory_replenishment_no;
        this.date_added = date_added;
        this.user_id = user_id;
        this.user_screen_name = user_screen_name;
        this.remarks = remarks;
        this.status = status;
        this.branch = branch;
        this.branch_id = branch_id;
        this.location = location;
        this.location_id = location_id;
        this.items = items;
    }

    public static class items {

        String item_code;
        String barcode;
        String description;
        double product_qty;
        String unit;
        double conversion;
        double selling_price;

        public items(String item_code, String barcode, String description, double product_qty, String unit, double conversion, double selling_price) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
        }

    }

    public static void main(String[] args) {
//        String where = " where inventory_replenishment_no=000000000006";
        String where = " limit 2";
        to_upload_count stmts = Parse_inventory_replenishments.compress(where);
//        System.out.println(stmts);

        List<Parse_inventory_replenishments> datas = Parse_inventory_replenishments.decompress(stmts.stmt);
        for (Parse_inventory_replenishments to : datas) {
            System.out.println("Ref #: " + to.inventory_replenishment_no);
            List<Parse_inventory_replenishments.items> items = to.items;
            for (Parse_inventory_replenishments.items item : items) {
                System.out.println("------item_code: " + item.item_code);
            }
        }
    }

    public static List<Parse_inventory_replenishments> decompress(String stmts) {
        if (stmts.isEmpty()) {
            return new ArrayList();
        }
        List<Parse_inventory_replenishments> datas = new ArrayList();
        String[] trans = stmts.split("Ω,");
        int ix = 0;
        for (String transactions : trans) {

//            System.out.println(transactions);
            String[] columns = transactions.split("~");
            int i = 0;
            String inventory_replenishment_no = "";
            String date_added = "";
            String user_id = "";
            String user_screen_name = "";
            String remarks = "";
            int status = 0;
            String branch = "";
            String branch_id = "";
            String location = "";
            String location_id = "";
            String item = "";
            List<Parse_inventory_replenishments.items> items = new ArrayList();
            for (String column : columns) {

                if (i == 0) {
                    System.out.println(column.substring(0, column.length() - 1));
                    inventory_replenishment_no = column.substring(14, column.length() - 1);
                }
                if (i == 1) {
                    date_added = column.substring(14, column.length() - 1);
                }
                if (i == 2) {
                    user_id = column.substring(11, column.length() - 1);
                }
                if (i == 3) {
                    user_screen_name = column.substring(20, column.length() - 1);
                }
                if (i == 4) {
                    remarks = column.substring(11, column.length() - 1);
                }
                if (i == 5) {
                    status = FitIn.toInt(column.substring(10, column.length() - 1));
                }
                if (i == 6) {
                    branch = column.substring(10, column.length() - 1);
                }
                if (i == 7) {
                    branch_id = column.substring(13, column.length() - 1);
                }
                if (i == 8) {
                    location = column.substring(12, column.length() - 1);

                }
                if (i == 9) {
                    location_id = column.substring(15, column.length() - 1);
                }
                if (i == 10) {
                    item = column.substring(9, column.length() - 1);
                    String[] itemss = item.split("℮");
                    int iii = 0;
                    for (String it : itemss) {
                        String[] ite = it.split("%");
                        String item_code = "";
                        String barcode = "";
                        double product_qty = 0;
                        String unit = "";
                        double conversion = 0;
                        double selling_price = 0;
                        int ii = 0;

                        for (String itee : ite) {
                            if (iii > 0) {
                                if (ii == 0) {

                                    item_code = itee.substring(14, itee.length() - 1);

                                }
                                if (ii == 1) {
                                    barcode = itee.substring(11, itee.length() - 1);
                                }
                                if (ii == 2) {
                                    product_qty = FitIn.toDouble(itee.substring(15, itee.length() - 1));
                                }
                                if (ii == 3) {
                                    unit = itee.substring(8, itee.length() - 1);
                                }
                                if (ii == 4) {
                                    conversion = FitIn.toDouble(itee.substring(14, itee.length() - 1));
                                }
                                if (ii == 5) {
                                    selling_price = FitIn.toDouble(itee.substring(17, itee.length() - 1));
                                }
                                ii++;
                            }

                        }
                        if (ii != 0) {
                            Parse_inventory_replenishments.items item1 = new items(item_code, barcode, location, product_qty, unit, conversion, selling_price);
                            items.add(item1);
                        }

                        iii++;
                    }

                }
                i++;
            }

            Parse_inventory_replenishments pir = new Parse_inventory_replenishments(inventory_replenishment_no, date_added, user_id, user_screen_name, remarks, status, branch, branch_id, location, location_id, items);
            datas.add(pir);

        }

        return datas;
    }

    public static to_upload_count compress(String where) {
        String stmts = "";
        int total_transactions = 0;
        int total_items = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",inventory_replenishment_no"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from inventory_replenishments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            int t = 0;
            while (rs.next()) {
                total_transactions++;
                int id = rs.getInt(1);
                String inventory_replenishment_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_id = rs.getString(4);
                String user_screen_name = rs.getString(5);
                String remarks = rs.getString(6);
                int status = rs.getInt(7);
                String branch = rs.getString(8);
                String branch_id = rs.getString(9);
                String location = rs.getString(10);
                String location_id = rs.getString(11);

                if (t > 0) {
                    stmts = stmts + "Ω,";
                }
                stmts = stmts + "Ω\"" + "inventory_replenishment_no\":\"" + inventory_replenishment_no + "\"";
                stmts = stmts + "~\"date_added\":\"" + date_added + "\"";
                stmts = stmts + "~\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "~\"user_screen_name\":\"" + user_screen_name + "\"";
                stmts = stmts + "~\"remarks\":\"" + remarks + "\"";
                stmts = stmts + "~\"status\":\"" + status + "\"";
                stmts = stmts + "~\"branch\":\"" + branch + "\"";
                stmts = stmts + "~\"branch_id\":\"" + branch_id + "\"";
                stmts = stmts + "~\"location\":\"" + location + "\"";
                stmts = stmts + "~\"location_id\":\"" + location_id + "\"";
                stmts = stmts + "~\"items\":\"";

                String item = "";
                String s2 = "select "
                        + "id"
                        + ",inventory_replenishment_no"
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
                        + " from inventory_replenishment_items"
                        + " where inventory_replenishment_no='" + inventory_replenishment_no + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    total_items++;
                    String item_code = rs2.getString(3);
                    String barcode = rs2.getString(4);
                    String description = rs2.getString(5);
                    double product_qty = rs2.getDouble(6);
                    String unit = rs2.getString(7);
                    double conversion = rs2.getDouble(8);
                    double selling_price = rs2.getDouble(9);

                    stmts = stmts + "℮{";
                    stmts = stmts + "\"item_code\":\"" + item_code + "\"";
                    stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                    stmts = stmts + "%\"product_qty\":\"" + product_qty + "\"";
                    stmts = stmts + "%\"unit\":\"" + unit + "\"";
                    stmts = stmts + "%\"conversion\":\"" + conversion + "\"";
                    stmts = stmts + "%\"selling_price\":\"" + selling_price + "\"";
                    stmts = stmts + "}";
                }

                t++;
                stmts = stmts + "\"Ω";

            }
            System.out.println("Replenishments: " + "Transactions: " + total_transactions + " , Items: " + total_items);
            to_upload_count count = new to_upload_count(stmts, total_transactions, total_items);
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
