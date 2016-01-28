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
public class Parse_receipts {

    public String receipt_no;
    public String user_name;
    public String session_no;
    public String date_added;
    public String supplier;
    public String supplier_id;
    public String remarks;
    public String date_delivered;
    public String date_received;
    public String receipt_type;
    public String reference_no;
    public String branch;
    public String branch_id;
    public double gross_total;
    public double net_total;
    public String batch_no;
    public double discount;
    public int status;
    public String receipt_type_id;
    public List<items> items;

    public Parse_receipts(String receipt_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String remarks, String date_delivered, String date_received, String receipt_type, String reference_no, String branch, String branch_id, double gross_total, double net_total, String batch_no, double discount, int status, String receipt_type_id, List<items> items) {
        this.receipt_no = receipt_no;
        this.user_name = user_name;
        this.session_no = session_no;
        this.date_added = date_added;
        this.supplier = supplier;
        this.supplier_id = supplier_id;
        this.remarks = remarks;
        this.date_delivered = date_delivered;
        this.date_received = date_received;
        this.receipt_type = receipt_type;
        this.reference_no = reference_no;
        this.branch = branch;
        this.branch_id = branch_id;
        this.gross_total = gross_total;
        this.net_total = net_total;
        this.batch_no = batch_no;
        this.discount = discount;
        this.status = status;
        this.receipt_type_id = receipt_type_id;
        this.items = items;
    }

    public static class items {

        public String item_code;
        public String barcode;
        public double qty;
        public double cost;
        public double conversion;
        public String unit;
        public String serial_no;
        public double previous_cost;

        public items(String item_code, String barcode, double qty, double cost, double conversion, String unit, String serial_no, double previous_cost) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.qty = qty;
            this.cost = cost;
            this.conversion = conversion;
            this.unit = unit;
            this.serial_no = serial_no;
            this.previous_cost = previous_cost;
        }

    }

    public static void main(String[] args) {
        String where = "order by id desc limit 10";
        String stmts = compress(where);
        List<Parse_receipts> datas = decompress(stmts);
        for (Parse_receipts to : datas) {
            System.out.println("Receipt: " + to.receipt_no);
            System.out.println("Size: " + to.items.size());
            List<Parse_receipts.items> items = to.items;
            for (Parse_receipts.items t : items) {
                System.out.println("----- Item Code: " + t.item_code);
                System.out.println("***** Serial #: " + t.serial_no);
            }
        }
    }

    public static List<Parse_receipts> decompress(String stmts) {
        if (stmts.isEmpty()) {
            return new ArrayList();
        }
        List<Parse_receipts> datas = new ArrayList();

        String[] trans = stmts.split("Ω,");
        for (String transactions : trans) {
            String[] columns = transactions.split("~");
            int i = 0;
            String receipt_no = "";
            String user_name = "";
            String session_no = "";
            String date_added = "";
            String supplier = "";
            String supplier_id = "";
            String remarks = "";
            String date_delivered = "";
            String date_received = "";
            String receipt_type = "";
            String reference_no = "";
            String branch = "";
            String branch_id = "";
            double gross_total = 0;
            double net_total = 0;
            String batch_no = "";
            double discount = 0;
            int status = 0;
            String receipt_type_id = "";
            String item = "";
            List<items> items = new ArrayList();
            for (String column : columns) {
                if (i == 0) {
                    receipt_no = column.substring(15, column.length() - 1);

                }
                if (i == 1) {
                    user_name = column.substring(13, column.length() - 1);
                }
                if (i == 2) {
                    session_no = column.substring(14, column.length() - 1);
                }
                if (i == 3) {
                    date_added = column.substring(14, column.length() - 1);
                }
                if (i == 4) {
                    supplier = column.substring(12, column.length() - 1);
                }
                if (i == 5) {
                    supplier_id = column.substring(15, column.length() - 1);
                }
                if (i == 6) {
                    remarks = column.substring(11, column.length() - 1);
                }
                if (i == 7) {
                    date_delivered = column.substring(18, column.length() - 1);
                }
                if (i == 8) {
                    date_received = column.substring(17, column.length() - 1);
                }
                if (i == 9) {
                    receipt_type = column.substring(16, column.length() - 1);

                }
                if (i == 10) {

                    reference_no = column.substring(16, column.length() - 1);
                }
                if (i == 11) {
                    branch = column.substring(10, column.length() - 1);
                }
                if (i == 12) {
                    branch_id = column.substring(13, column.length() - 1);

                }
                if (i == 13) {
                    gross_total = FitIn.toDouble(column.substring(15, column.length() - 1));
                }
                if (i == 14) {
                    net_total = FitIn.toDouble(column.substring(13, column.length() - 1));
                }
                if (i == 15) {
                    batch_no = column.substring(12, column.length() - 1);
                }
                if (i == 16) {
                    discount = FitIn.toDouble(column.substring(11, column.length() - 1));
                }
                if (i == 17) {
                    status = FitIn.toInt(column.substring(10, column.length() - 1));
                }
                if (i == 18) {
                    receipt_type_id = column.substring(19, column.length() - 1);

                }
                if (i == 19) {
                    item = column.substring(8, column.length() - 1);
                    String[] itemss = item.split("℮");
                    int iii = 0;
                    for (String it : itemss) {
                        String[] ite = it.split("%");
                        String item_code = "";
                        String barcode = "";
                        double qty = 0;
                        double cost = 0;
                        double conversion = 0;
                        String unit = "";
                        String serial_no = "";
                        double previous_cost = 0;
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
                                    qty = FitIn.toDouble(itee.substring(8, itee.length() - 1));
                                }
                                if (ii == 3) {
                                    cost = FitIn.toDouble(itee.substring(9, itee.length() - 1));
                                }
                                if (ii == 4) {
                                    conversion = FitIn.toDouble(itee.substring(14, itee.length() - 1));
                                }
                                if (ii == 5) {
                                    unit = itee.substring(9, itee.length() - 1);
                                }
                                if (ii == 6) {
                                    serial_no = itee.substring(13, itee.length() - 1);
                                }
                                if (ii == 7) {
                                    previous_cost = FitIn.toDouble(itee.substring(18, itee.length() - 1));
                                }
                                ii++;
                            }

                        }
                        if (ii != 0) {
                            Parse_receipts.items its = new items(item_code, barcode, qty, cost, conversion, unit, serial_no, previous_cost);
                            items.add(its);
                        }

                        iii++;
                    }
                }
                i++;
            }

            Parse_receipts pr = new Parse_receipts(receipt_no, user_name, session_no, date_added, supplier, supplier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, status, receipt_type_id, items);
            datas.add(pr);
        }

        return datas;
    }

    public static String compress(String where) {

        String stmts = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",receipt_type"
                    + ",reference_no"
                    + ",branch"
                    + ",branch_id"
                    + ",gross_total"
                    + ",net_total"
                    + ",batch_no"
                    + ",discount"
                    + ",status"
                    + ",receipt_type_id"
                    + " from receipts"
                    + " " + where;

            int t = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                String receipt_type = rs.getString(11);
                String reference_no = rs.getString(12);
                String branch = rs.getString(13);
                String branch_id = rs.getString(14);
                double gross_total = rs.getDouble(15);
                double net_total = rs.getDouble(16);
                String batch_no = rs.getString(17);
                double discount = rs.getDouble(18);
                int status = rs.getInt(19);
                String receipt_type_id = rs.getString(20);
                if (t > 0) {
                    stmts = stmts + "Ω,";
                }
                stmts = stmts + "Ω\"" + "receipt_no\":\"" + receipt_no + "\"";
                stmts = stmts + "~\"user_name\":\"" + user_name + "\"";
                stmts = stmts + "~\"session_no\":\"" + session_no + "\"";
                stmts = stmts + "~\"date_added\":\"" + date_added + "\"";
                stmts = stmts + "~\"supplier\":\"" + supplier + "\"";
                stmts = stmts + "~\"supllier_id\":\"" + supllier_id + "\"";
                stmts = stmts + "~\"remarks\":\"" + remarks + "\"";
                stmts = stmts + "~\"date_delivered\":\"" + date_delivered + "\"";
                stmts = stmts + "~\"date_received\":\"" + date_received + "\"";
                stmts = stmts + "~\"receipt_type\":\"" + receipt_type + "\"";
                stmts = stmts + "~\"reference_no\":\"" + reference_no + "\"";
                stmts = stmts + "~\"branch\":\"" + branch + "\"";
                stmts = stmts + "~\"branch_id\":\"" + branch_id + "\"";
                stmts = stmts + "~\"gross_total\":\"" + gross_total + "\"";
                stmts = stmts + "~\"net_total\":\"" + net_total + "\"";
                stmts = stmts + "~\"batch_no\":\"" + batch_no + "\"";
                stmts = stmts + "~\"discount\":\"" + discount + "\"";
                stmts = stmts + "~\"status\":\"" + status + "\"";
                stmts = stmts + "~\"receipt_type_id\":\"" + receipt_type_id + "\"";
                stmts = stmts + "~\"items\":\"";
                String s2 = "select "
                        + " barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",conversion"
                        + ",unit"
                        + ",barcodes"
                        + ",serial_no"
                        + ",main_barcode"
                        + ",previous_cost"
                        + " from receipt_items"
                        + " " + where;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {

                    String barcode = rs2.getString(1);
                    String description = rs2.getString(2);
                    double qty = rs2.getDouble(3);
                    double cost = rs2.getDouble(4);
                    double conversion = rs2.getDouble(5);
                    String unit = rs2.getString(6);
                    String barcodes = rs2.getString(7);
                    String serial_no = rs2.getString(8);
                    String main_barcode = rs2.getString(9);
                    double previous_cost = rs2.getDouble(10);

                    stmts = stmts + "℮{";
                    stmts = stmts + "\"item_code\":\"" + main_barcode + "\"";
                    stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                    stmts = stmts + "%\"qty\":\"" + qty + "\"";
                    stmts = stmts + "%\"cost\":\"" + cost + "\"";
                    stmts = stmts + "%\"conversion\":\"" + conversion + "\"";
                    stmts = stmts + "%\"unit\":\"" + unit + "\"";
                    stmts = stmts + "%\"serial_no\":\"" + serial_no + "\"";
                    stmts = stmts + "%\"previous_cost\":\"" + previous_cost + "\"";
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
