/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

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
 * @author Guinness
 */
public class Parse_stock_transfers {

    String transaction_no;
    String user_name;
    String date_added;
    String remarks;
    String to_branch;
    String to_branch_id;
    String to_location;
    String to_location_id;
    String from_branch;
    String from_branch_id;
    String from_location;
    String from_location_id;
    int status;
    String at_branch;
    String at_branch_id;
    String at_location;
    String at_location_id;
    List<items> items;

    public Parse_stock_transfers(String transaction_no, String user_name, String date_added, String remarks, String to_branch, String to_branch_id, String to_location, String to_location_id, String from_branch, String from_branch_id, String from_location, String from_location_id, int status, String at_branch, String at_branch_id, String at_location, String at_location_id, List<items> items) {
        this.transaction_no = transaction_no;
        this.user_name = user_name;
        this.date_added = date_added;
        this.remarks = remarks;
        this.to_branch = to_branch;
        this.to_branch_id = to_branch_id;
        this.to_location = to_location;
        this.to_location_id = to_location_id;
        this.from_branch = from_branch;
        this.from_branch_id = from_branch_id;
        this.from_location = from_location;
        this.from_location_id = from_location_id;
        this.status = status;
        this.at_branch = at_branch;
        this.at_branch_id = at_branch_id;
        this.at_location = at_location;
        this.at_location_id = at_location_id;
        this.items = items;
    }

    public static class items {

        String item_code;
        String barcode;
        double product_qty;
        String unit;
        double conversion;
        double selling_price;
        double cost;

        public items(String item_code, String barcode, double product_qty, String unit, double conversion, double selling_price, double cost) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        String where = "  order by id desc limit 2 ";
        String stmts = compress(where);

        List<Parse_stock_transfers> transactions = decompress(stmts);

    }

    public static List<Parse_stock_transfers> decompress(String stmts) {
        if (stmts.isEmpty()) {
            return new ArrayList();
        }
        List<Parse_stock_transfers> datas = new ArrayList();

        String[] trans = stmts.split("Ω,");

        for (String transactions : trans) {

//            System.out.println(transactions);
            String[] columns = transactions.split("~");
            int i = 0;
            String transaction_no = "";
            String user_name = "";
            String date_added = "";
            String remarks = "";
            String to_branch = "";

            String to_branch_id = "";
            String to_location = "";
            String to_location_id = "";
            String from_branch = "";
            String from_branch_id = "";

            String from_location = "";
            String from_location_id = "";
            int status = 0;
            String at_branch = "";
            String at_branch_id = "";

            String at_location = "";
            String at_location_id = "";
            String item = "";
            List<Parse_stock_transfers.items> items = new ArrayList();
            for (String column : columns) {

                if (i == 0) {
                    transaction_no = column.substring(19, column.length() - 1);

                }
                if (i == 1) {
                    user_name = column.substring(13, column.length() - 1);

                }
                if (i == 2) {
                    date_added = column.substring(14, column.length() - 1);

                }
                if (i == 3) {
                    remarks = column.substring(11, column.length() - 1);

                }
                if (i == 4) {
                    to_branch = column.substring(13, column.length() - 1);
                }

                if (i == 5) {
                    to_branch_id = column.substring(17, column.length() - 1);
                }
                if (i == 6) {
                    to_location = column.substring(15, column.length() - 1);
                }
                if (i == 7) {
                    to_location_id = column.substring(18, column.length() - 1);
                }
                if (i == 8) {
                    from_branch = column.substring(15, column.length() - 1);

                }
                if (i == 9) {
                    from_branch_id = column.substring(18, column.length() - 1);
                }

                if (i == 10) {
                    from_location = column.substring(17, column.length() - 1);
                }
                if (i == 11) {
                    from_location_id = column.substring(20, column.length() - 1);
                }
                if (i == 12) {
                    status = FitIn.toInt(column.substring(10, column.length() - 1));
                }
                if (i == 13) {
                    at_branch = column.substring(13, column.length() - 1);

                }
                if (i == 14) {
                    at_branch_id = column.substring(16, column.length() - 1);
                }

                if (i == 15) {
                    at_location = column.substring(15, column.length() - 1);

                }
                if (i == 16) {
                    at_location_id = column.substring(18, column.length() - 1);
                }

                if (i == 17) {
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
                        double cost = 0;
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
                                if (ii == 6) {
                                    cost = FitIn.toDouble(itee.substring(9, itee.length() - 1));
                                }
                                ii++;
                            }

                        }
                        if (ii != 0) {
                            Parse_stock_transfers.items its = new items(item_code, barcode, product_qty, unit, conversion, selling_price, cost);
                            items.add(its);
                        }

                        iii++;
                    }

                }
                i++;
            }

            Parse_stock_transfers par = new Parse_stock_transfers(transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, status, at_branch, at_branch_id, at_location, at_location_id, items);
            datas.add(par);

        }

        return datas;
    }

    public static String compress(String where) {

        String stmts = "";

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
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
                    + " from stock_transfers"
                    + " " + where;

            int t = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String user_name = rs.getString(3);
                String date_added = rs.getString(4);
                String remarks = rs.getString(5);
                String to_branch = rs.getString(6);
                String to_branch_id = rs.getString(7);
                String to_location = rs.getString(8);
                String to_location_id = rs.getString(9);
                String from_branch = rs.getString(10);
                String from_branch_id = rs.getString(11);
                String from_location = rs.getString(12);
                String from_location_id = rs.getString(13);
                int status = rs.getInt(14);
                String at_branch = rs.getString(15);
                String at_branch_id = rs.getString(16);
                String at_location = rs.getString(17);
                String at_location_id = rs.getString(18);

                if (t > 0) {
                    stmts = stmts + "Ω,";
                }
                stmts = stmts + "Ω\"" + "transaction_no\":\"" + transaction_no + "\"";
                stmts = stmts + "~\"user_name\":\"" + user_name + "\"";
                stmts = stmts + "~\"date_added\":\"" + date_added + "\"";
                stmts = stmts + "~\"remarks\":\"" + remarks + "\"";
                stmts = stmts + "~\"to_branch\":\"" + to_branch + "\"";
                stmts = stmts + "~\"to_branch_id\":\"" + to_branch_id + "\"";
                stmts = stmts + "~\"to_location\":\"" + to_location + "\"";
                stmts = stmts + "~\"to_location_id\":\"" + to_location_id + "\"";
                stmts = stmts + "~\"from_branch\":\"" + from_branch + "\"";
                stmts = stmts + "~\"from_branch_id\":\"" + from_branch_id + "\"";
                stmts = stmts + "~\"from_location\":\"" + from_location + "\"";
                stmts = stmts + "~\"from_location_id\":\"" + from_location_id + "\"";
                stmts = stmts + "~\"status\":\"" + status + "\"";
                stmts = stmts + "~\"at_branch\":\"" + at_branch + "\"";
                stmts = stmts + "~\"at_branch_id\":\"" + at_branch_id + "\"";
                stmts = stmts + "~\"at_location\":\"" + at_location + "\"";
                stmts = stmts + "~\"at_location_id\":\"" + at_location_id + "\"";
                stmts = stmts + "~\"items\":\"";

                String s2 = "select "
                        + "barcode"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",cost"
                        + ",barcodes"
                        + " from stock_transfers_items"
                        + " where stock_transfer_id='" + transaction_no + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {

                    String barcode = rs2.getString(1);
                    double product_qty = rs2.getDouble(2);
                    String unit = rs2.getString(3);
                    double conversion = rs2.getDouble(4);
                    double selling_price = rs2.getDouble(5);
                    double cost = rs2.getDouble(6);
                    String barcodes = rs2.getString(7);

                    stmts = stmts + "℮{";
                    stmts = stmts + "\"item_code\":\"" + barcode + "\"";
                    stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                    stmts = stmts + "%\"product_qty\":\"" + product_qty + "\"";
                    stmts = stmts + "%\"unit\":\"" + unit + "\"";
                    stmts = stmts + "%\"conversion\":\"" + conversion + "\"";
                    stmts = stmts + "%\"selling_price\":\"" + selling_price + "\"";
                    stmts = stmts + "%\"cost\":\"" + cost + "\"";
                    stmts = stmts + "%\"barcodes\":\"" + barcodes + "\"";
                    stmts = stmts + "}";
                }

                t++;
                stmts = stmts + "\"Ω";

            }

            return stmts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }
}
