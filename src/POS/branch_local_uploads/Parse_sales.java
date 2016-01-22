/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_local_uploads;

import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.synch_locations.Synch_locations;
import POS.util.DateType;
import POS.util.MyConnection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Parse_sales {

    public static class field {

        public String sales_no;
        public String date_added;
        public String user_screen_name;
        public String user_id;
        public String session_no;
        public String remarks;
        public double gross_amount;
        public double amount_due;
        public int status;
        public int sales_type;
        public double line_discount;
        public String customer_id;
        public String customer_name;
        public String discount_name;
        public double discount_rate;
        public double discount_amount;
        public String discount_customer_name;
        public String discount_customer_id;
        public String charge_type;
        public String charge_type_id;
        public String charge_reference_no = "";
        public String charge_customer_name;
        public String charge_customer_id;
        public double charge_amount;
        public String check_bank;
        public String check_no;
        public double check_amount;
        public String check_holder;
        public String check_date;
        public String credit_card_type;
        public double credit_card_rate;
        public double credit_card_amount;
        public String credit_card_no;
        public String credit_card_holder;
        public String credit_card_approval_code;
        public String gift_cerftificate_from;
        public String gift_certificate_description;
        public String gift_certificate_no;
        public double gift_certificate_amount;
        public String prepaid_customer_name;
        public String prepaid_customer_id;
        public double prepaid_amount;
        public double addtl_amount;
        public double wtax;
        public String branch;
        public String branch_id;
        public String location;
        public String location_id;
        public List<items> items;

        public field(String sales_no, String date_added, String user_screen_name, String user_id, String session_no, String remarks, double gross_amount, double amount_due, int status, int sales_type, double line_discount, String customer_id, String customer_name, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String charge_type, String charge_type_id, String charge_customer_name, String charge_customer_id, double charge_amount, String check_bank, String check_no, double check_amount, String check_holder, String check_date, String credit_card_type, double credit_card_rate, double credit_card_amount, String credit_card_no, String credit_card_holder, String credit_card_approval_code, String gift_cerftificate_from, String gift_certificate_description, String gift_certificate_no, double gift_certificate_amount, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, double addtl_amount, double wtax, String branch, String branch_id, String location, String location_id, List<items> items) {
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_screen_name = user_screen_name;
            this.user_id = user_id;
            this.session_no = session_no;
            this.remarks = remarks;
            this.gross_amount = gross_amount;
            this.amount_due = amount_due;
            this.status = status;
            this.sales_type = sales_type;
            this.line_discount = line_discount;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.charge_type = charge_type;
            this.charge_type_id = charge_type_id;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.check_holder = check_holder;
            this.check_date = check_date;
            this.credit_card_type = credit_card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_approval_code = credit_card_approval_code;
            this.gift_cerftificate_from = gift_cerftificate_from;
            this.gift_certificate_description = gift_certificate_description;
            this.gift_certificate_no = gift_certificate_no;
            this.gift_certificate_amount = gift_certificate_amount;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.items = items;
        }

        public static class items {

            public String item_code;
            public String barcode;
            public double qty;
            public double selling_price;
            public int is_vatable;
            public String discount_name;
            public double discount_rate;
            public double discount_amount;
            public String discount_customer_name;
            public String discount_customer_id;
            public String branch;
            public String branch_id;
            public String location;
            public String location_id;
            public double addtl_amount;
            public String serial_nos;
            public double wtax;

            public items(String item_code, String barcode, double qty, double selling_price, int is_vatable, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String branch, String branch_id, String location, String location_id, double addtl_amount, String serial_nos, double wtax) {
                this.item_code = item_code;
                this.barcode = barcode;
                this.qty = qty;
                this.selling_price = selling_price;
                this.is_vatable = is_vatable;
                this.discount_name = discount_name;
                this.discount_rate = discount_rate;
                this.discount_amount = discount_amount;
                this.discount_customer_name = discount_customer_name;
                this.discount_customer_id = discount_customer_id;
                this.branch = branch;
                this.branch_id = branch_id;
                this.location = location;
                this.location_id = location_id;
                this.addtl_amount = addtl_amount;
                this.serial_nos = serial_nos;
                this.wtax = wtax;
            }

        }

    }

    public static void main2(String[] args) {

    }

    public static void main(String[] args) {
        String where = " where Date(date_added) = '" + "2016-01-04" + "' limit 5";

        String stmt = Parse_sales.compress(where);

        List<Parse_sales.field> fields = Parse_sales.decompress(stmt);

        System.out.println("Total Transactions: " + fields.size());

        String name = DateType.y.format(new Date()) + "" + DateType.d.format(new Date()) + "" + DateType.m1.format(new Date());

        String path = System.getProperty("user.home");
        File file = new File(path + "\\" + name + ".txt");
        File file2 = new File(path + "\\" + "null.txt");
        FileWriter fw;
        FileWriter fw2;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stmt);
            bw.close();

            fw2 = new FileWriter(file2.getAbsoluteFile());
            BufferedWriter bw2 = new BufferedWriter(fw2);

            bw2.close();
        } catch (IOException ex) {
            Logger.getLogger(Parse_sales.class.getName()).log(Level.SEVERE, null, ex);
        }

        int id = 0;
        File inventory_counts = file2;
        File receipts = file2;
        File sales = file;
        File transfers = file2;
        File adjustments = file2;
        File returned_items = file2;
        File charges = file2;
        File rmas = file2;
        File item_maintenances = file2;
        File cash_drawers = file2;
        int status = 0;
        String date_added = DateType.datetime.format(new Date());
        String user_id = "";
        String user_screen_name = "";
        String branch = "";
        String branch_id = "";
        String location = "";
        String location_id = "";

        Synch_locations.to_synch_locations sl = new Synch_locations.to_synch_locations(id, inventory_counts, receipts, sales, transfers, adjustments, returned_items, charges, rmas, item_maintenances, cash_drawers, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
//        Synch_locations.add_data(sl);

    }

    public static List<Parse_sales.field> decompress(String stmt) {

        List<Parse_sales.field> fields = new ArrayList();
        String[] transaction = stmt.split("Ω,");

        for (String trans : transaction) {
//            System.out.println(trans);

            String[] columns = trans.split("~");
            List<String> transactions = new ArrayList();
            transactions.addAll(Arrays.asList(columns));
            int t = 0;
            String sales_no = "";
            String date_added = "";
            String user_screen_name = "";
            String user_id = "";
            String session_no = "";
            String remarks = "";
            double gross_amount = 0;
            double amount_due = 0;
            int status = 0;
            int sales_type = 0;
            double line_discount = 0;
            String customer_id = "";
            String customer_name = "";
            String discount_name1 = "";
            double discount_rate1 = 0;
            double discount_amount1 = 0;
            String discount_customer_name1 = "";
            String discount_customer_id1 = "";
            String charge_type = "";
            String charge_type_id = "";
            String charge_reference_no = "";
            String charge_customer_name = "";
            String charge_customer_id = "";
            double charge_amount = 0;
            String check_bank = "";
            String check_no = "";
            double check_amount = 0;
            String check_holder = "";
            String check_date = "";
            String credit_card_type = "";
            double credit_card_rate = 0;
            double credit_card_amount = 0;
            String credit_card_no = "";
            String credit_card_holder = "";
            String credit_card_approval_code = "";
            String gift_cerftificate_from = "";
            String gift_certificate_description = "";
            String gift_certificate_no = "";
            double gift_certificate_amount = 0;
            String prepaid_customer_name = "";
            String prepaid_customer_id = "";
            double prepaid_amount = 0;
            double addtl_amount1 = 0;
            double wtax1 = 0;
            String branch1 = "";
            String branch_id1 = "";
            String location1 = "";
            String location_id1 = "";
            for (String tr : transactions) {
//                System.out.println(tr);
                //<editor-fold defaultstate="collapsed" desc=" Transactions ">
                if (t == 0) {
                    sales_no = tr.substring(14, tr.length() - 1);
//                    System.out.println("Sales No = " + sales_no);
                }
                if (t == 1) {
                    date_added = tr.substring(14, tr.length() - 1);
//                    System.out.println("Date Added = " + date_added);
                }
                if (t == 2) {
                    user_screen_name = tr.substring(20, tr.length() - 1);
//                    System.out.println("User Screen Name = " + user_screen_name);
                }
                if (t == 3) {
                    user_id = tr.substring(11, tr.length() - 1);
//                    System.out.println("User Id = " + user_id);
                }
                if (t == 4) {
                    session_no = tr.substring(14, tr.length() - 1);
//                    System.out.println("Session No = " + session_no);
                }
                if (t == 5) {
                    remarks = tr.substring(11, tr.length() - 1);
//                    System.out.println("Remarks = " + remarks);
                }
                if (t == 6) {
                    gross_amount = FitIn.toDouble(tr.substring(16, tr.length() - 1));
//                    System.out.println("Gross Amount = " + gross_amount);
                }
                if (t == 7) {
                    amount_due = FitIn.toDouble(tr.substring(14, tr.length() - 1));
//                    System.out.println("Amount Due = " + gross_amount);
                }
                if (t == 8) {
                    status = FitIn.toInt(tr.substring(10, tr.length() - 1));
//                    System.out.println("Status = " + status);
                }
                if (t == 9) {
                    sales_type = FitIn.toInt(tr.substring(14, tr.length() - 1));
//                    System.out.println("Sales Type = " + sales_type);
                }
                if (t == 10) {
                    line_discount = FitIn.toDouble(tr.substring(17, tr.length() - 1));
//                    System.out.println("Line Discount = " + line_discount);
                }
                if (t == 11) {
                    customer_id = tr.substring(15, tr.length() - 1);
//                    System.out.println("Customer Id = " + customer_id);
                }
                if (t == 12) {
                    customer_name = tr.substring(17, tr.length() - 1);
//                    System.out.println("Customer Name = " + customer_name);
                }
                if (t == 13) {
                    discount_name1 = tr.substring(17, tr.length() - 1);
//                    System.out.println("discount_name = " + tr.substring(17, tr.length() - 1));
                }
                if (t == 14) {
                    discount_rate1 = FitIn.toDouble(tr.substring(17, tr.length() - 1));
//                    System.out.println("discount_rate = " + tr.substring(17, tr.length() - 1));
                }
                if (t == 15) {
                    discount_amount1 = FitIn.toDouble(tr.substring(19, tr.length() - 1));
//                    System.out.println("discount_amount = " + tr.substring(19, tr.length() - 1));
                }
                if (t == 16) {
                    discount_customer_name1 = tr.substring(26, tr.length() - 1);
//                    System.out.println("discount_customer_name = " + discount_customer_name1);
                }
                if (t == 17) {
                    discount_customer_id1 = tr.substring(24, tr.length() - 1);
//                    System.out.println("discount_customer_id = " + discount_customer_id1);
                }
                if (t == 18) {
                    charge_type = tr.substring(15, tr.length() - 1);
//                    System.out.println("charge_type = " + charge_type);
                }
                if (t == 19) {
                    charge_type_id = tr.substring(18, tr.length() - 1);
//                    System.out.println("charge_type_id = " + charge_type_id);
                }
                if (t == 20) {
                    charge_reference_no = tr.substring(23, tr.length() - 1);
//                    System.out.println("charge_reference_no = " + charge_reference_no);
                }
                if (t == 21) {
                    charge_customer_name = tr.substring(24, tr.length() - 1);
//                    System.out.println("charge_customer_name = " + charge_customer_name);
                }
                if (t == 22) {
                    charge_customer_id = tr.substring(22, tr.length() - 1);
//                    System.out.println("charge_customer_id = " + charge_customer_id);
                }
                if (t == 23) {
                    charge_amount = FitIn.toDouble(tr.substring(17, tr.length() - 1));
//                    System.out.println("charge_amount = " + charge_amount);
                }
                if (t == 24) {
                    check_bank = tr.substring(14, tr.length() - 1);
//                    System.out.println("check_bank = " + check_bank);
                }
                if (t == 25) {
                    check_no = tr.substring(12, tr.length() - 1);
//                    System.out.println("check_no = " + check_no);
                }
                if (t == 26) {
                    check_amount = FitIn.toDouble(tr.substring(15, tr.length() - 1));
//                    System.out.println("check_amount = " + check_amount);
                }
                if (t == 27) {
                    check_holder = tr.substring(16, tr.length() - 1);
//                    System.out.println("check_holder = " + check_holder);
                }
                if (t == 28) {
                    check_date = tr.substring(14, tr.length() - 1);
//                    System.out.println("check_date = " + check_date);
                }
                if (t == 29) {
                    credit_card_type = tr.substring(20, tr.length() - 1);
//                    System.out.println("credit_card_type = " + credit_card_type);
                }
                if (t == 30) {
                    credit_card_rate = FitIn.toDouble(tr.substring(20, tr.length() - 1));
//                    System.out.println("credit_card_rate = " + credit_card_rate);
                }
                if (t == 31) {
                    credit_card_amount = FitIn.toDouble(tr.substring(22, tr.length() - 1));
//                    System.out.println("credit_card_amount = " + credit_card_amount);
                }
                if (t == 32) {
                    credit_card_no = tr.substring(18, tr.length() - 1);
//                    System.out.println("credit_card_no = " + credit_card_no);
                }
                if (t == 33) {
                    credit_card_holder = tr.substring(22, tr.length() - 1);
//                    System.out.println("credit_card_holder = " + credit_card_holder);
                }
                if (t == 34) {
                    credit_card_approval_code = tr.substring(29, tr.length() - 1);
//                    System.out.println("credit_card_approval_code = " + credit_card_approval_code);
                }
                if (t == 35) {
                    gift_cerftificate_from = tr.substring(26, tr.length() - 1);
//                    System.out.println("gift_cerftificate_from = " + gift_cerftificate_from);
                }
                if (t == 36) {
                    gift_certificate_description = tr.substring(32, tr.length() - 1);
//                    System.out.println("gift_certificate_description = " + gift_certificate_description);
                }
                if (t == 37) {
                    gift_certificate_no = tr.substring(23, tr.length() - 1);
//                    System.out.println("gift_certificate_no = " + gift_certificate_no);
                }
                if (t == 38) {
                    gift_certificate_amount = FitIn.toDouble(tr.substring(27, tr.length() - 1));
//                    System.out.println("gift_certificate_amount = " + gift_certificate_amount);
                }
                if (t == 39) {
                    prepaid_customer_name = tr.substring(25, tr.length() - 1);
//                    System.out.println("prepaid_customer_name = " + prepaid_customer_name);
                }
                if (t == 40) {
                    prepaid_customer_id = (tr.substring(23, tr.length() - 1));
//                    System.out.println("prepaid_customer_id = " + prepaid_customer_id);
                }
                if (t == 41) {
                    prepaid_amount = FitIn.toDouble(tr.substring(18, tr.length() - 1));
//                    System.out.println("prepaid_amount = " + prepaid_amount);
                }
                if (t == 42) {
                    addtl_amount1 = FitIn.toDouble(tr.substring(16, tr.length() - 1));
//                    System.out.println("addtl_amount = " + addtl_amount1);
                }
                if (t == 43) {
                    wtax1 = FitIn.toDouble(tr.substring(8, tr.length() - 1));
//                    System.out.println("wtax = " + wtax1);
                }
                if (t == 44) {
                    branch1 = (tr.substring(10, tr.length() - 1));
//                    System.out.println("branch = " + branch1);
                }
                if (t == 45) {
                    branch_id1 = (tr.substring(13, tr.length() - 1));
//                    System.out.println("branch_id = " + branch_id1);
                }
                if (t == 46) {
                    location1 = tr.substring(12, tr.length() - 1);
//                    System.out.println("location = " + location1);
                }
                if (t == 47) {
                    location_id1 = (tr.substring(15, tr.length() - 1));
//                    System.out.println("location_id = " + location_id1);
                }
                //</editor-fold>
                t++;
            }
            List<Parse_sales.field.items> my_items_list = new ArrayList();
            for (String col : columns) {
//                System.out.println(col);
                if (col.startsWith("\"items")) {
//                    System.out.println(col);

                    //<editor-fold defaultstate="collapsed" desc=" Items ">
                    String[] list_items = col.split("℮");
                    int x = 0;
                    for (String li : list_items) {
//                        System.out.println(li);
                        String[] items = li.split("%");
                        List<String> item_list = new ArrayList();
                        item_list.addAll(Arrays.asList(items));
                        int i = 0;
                        String item_code = "";
                        String barcode = "";
                        double qty = 0;
                        double selling_price = 0;
                        int is_vatable = 0;
                        String discount_name = "";
                        double discount_rate = 0;
                        double discount_amount = 0;
                        String discount_customer_name = "";
                        String discount_customer_id = "";
                        String branch = "";
                        String branch_id = "";
                        String location = "";
                        String location_id = "";
                        double addtl_amount = 0;
                        String serial_nos = "";
                        double wtax = 0;
                        if (x > 0) {
                            for (String item : item_list) {
//                            System.out.println(item);

                                if (i == 0) {
                                    item_code = item.substring(14, item.length() - 1);
//                                    System.out.println("Item Code = " + item_code);
                                }
                                if (i == 1) {
                                    barcode = item.substring(11, item.length() - 1);
//                                    System.out.println("Barcode = " + barcode);
                                }
                                if (i == 2) {
                                    qty = FitIn.toDouble(item.substring(7, item.length() - 1));
//                                    System.out.println("Qty = " + qty);
                                }
                                if (i == 3) {
                                    selling_price = FitIn.toDouble(item.substring(17, item.length() - 1));
//                                    System.out.println("Selling Price = " + selling_price);
                                }
                                if (i == 4) {
                                    is_vatable = FitIn.toInt(item.substring(14, item.length() - 1));
//                                    System.out.println("Is Vatable = " + is_vatable);
                                }
                                if (i == 5) {
                                    discount_name = item.substring(17, item.length() - 1);
//                                    System.out.println("Discount Name = " + discount_name);
                                }
                                if (i == 6) {
                                    discount_rate = FitIn.toDouble(item.substring(17, item.length() - 1));
//                                    System.out.println("Discount Rate = " + discount_rate);
                                }
                                if (i == 7) {
                                    discount_amount = FitIn.toDouble(item.substring(19, item.length() - 1));
//                                    System.out.println("Discount Amount = " + discount_amount);
                                }
                                if (i == 8) {
                                    discount_customer_name = item.substring(26, item.length() - 1);
//                                    System.out.println("Discount Customer Name = " + discount_customer_name);
                                }
                                if (i == 9) {
                                    discount_customer_id = item.substring(24, item.length() - 1);
//                                    System.out.println("Discount Customer Id = " + discount_customer_id);
                                }
                                if (i == 10) {
                                    branch = item.substring(10, item.length() - 1);
//                                    System.out.println("Branch = " + branch);
                                }
                                if (i == 11) {
                                    branch_id = item.substring(13, item.length() - 1);
//                                    System.out.println("Branch Id = " + branch_id);
                                }
                                if (i == 12) {
                                    location = item.substring(12, item.length() - 1);
//                                    System.out.println("Location = " + location);
                                }
                                if (i == 13) {
                                    location_id = item.substring(15, item.length() - 1);
//                                    System.out.println("Location Id = " + location_id);
                                }
                                if (i == 14) {
                                    addtl_amount = FitIn.toDouble(item.substring(16, item.length() - 1));
//                                    System.out.println("Addtl Amount = " + addtl_amount);
                                }
                                if (i == 15) {
                                    serial_nos = (item.substring(11, item.length() - 1));
//                                    System.out.println("WTax = " + wtax);
                                }
                                if (i == 16) {
                                    wtax = FitIn.toDouble(item.substring(11, item.length() - 1));
//                                    System.out.println("WTax = " + wtax);
                                }
                                i++;
                            }
                            Parse_sales.field.items field = new Parse_sales.field.items(item_code, barcode, qty, selling_price, is_vatable, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_id, location, location_id, addtl_amount, serial_nos, wtax);
                            my_items_list.add(field);
                        }

                        //</editor-fold>
//                        System.out.println("**********************************************");
                        x++;
                    }
                }
            }

            Parse_sales.field f = new Parse_sales.field(sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name1, discount_rate1, discount_amount1, discount_customer_name1, discount_customer_id1, charge_type, charge_type_id, charge_customer_name, charge_customer_id, charge_amount, check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_cerftificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount1, wtax1, branch1, branch_id1, location1, location_id1, my_items_list);
            fields.add(f);
//            System.out.println("-------------------------------------------------------------------------");
        }

        return fields;
    }

    public static String compress(String where) {

        String stmts = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
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
                    + " from sales"
                    + " " + where;

            int i = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String user_id = rs.getString(5);
                String session_no = rs.getString(6);
                String remarks = rs.getString(7);
                double gross_amount = rs.getDouble(8);
                double amount_due = rs.getDouble(9);
                int status = rs.getInt(10);
                int sales_type = rs.getInt(11);
                double line_discount = rs.getDouble(12);
                String customer_id = rs.getString(13);
                String customer_name = rs.getString(14);
                String discount_name = rs.getString(15);
                double discount_rate = rs.getDouble(16);
                double discount_amount = rs.getDouble(17);
                String discount_customer_name = rs.getString(18);
                String discount_customer_id = rs.getString(19);
                String charge_type = rs.getString(20);
                String charge_type_id = rs.getString(21);
                String charge_reference_no = rs.getString(22);
                String charge_customer_name = rs.getString(23);
                String charge_customer_id = rs.getString(24);
                double charge_amount = rs.getDouble(25);
                String check_bank = rs.getString(26);
                String check_no = rs.getString(27);
                double check_amount = rs.getDouble(28);
                String check_holder = rs.getString(29);
                String check_date = rs.getString(30);
                String credit_card_type = rs.getString(31);
                double credit_card_rate = rs.getDouble(32);
                double credit_card_amount = rs.getDouble(33);
                String credit_card_no = rs.getString(34);
                String credit_card_holder = rs.getString(35);
                String credit_card_approval_code = rs.getString(36);
                String gift_certificate_from = rs.getString(37);
                String gift_certificate_description = rs.getString(38);
                String gift_certificate_no = rs.getString(39);
                double gift_certificate_amount = rs.getDouble(40);
                String prepaid_customer_name = rs.getString(41);
                String prepaid_customer_id = rs.getString(42);
                double prepaid_amount = rs.getDouble(43);
                double addtl_amount = rs.getDouble(44);
                double wtax = rs.getDouble(45);
                String branch = rs.getString(46);
                String branch_id = rs.getString(47);
                String location = rs.getString(48);
                String location_id = rs.getString(49);

                if (i > 0) {
                    stmts = stmts + "Ω,";
                }
                stmts = stmts + "\"[\"sales_no\":\"" + sales_no + "\"";
                stmts = stmts + "~\"date_added\":\"" + date_added + "\"";
                stmts = stmts + "~\"user_screen_name\":\"" + user_screen_name + "\"";
                stmts = stmts + "~\"user_id\":\"" + user_id + "\"";
                stmts = stmts + "~\"session_no\":\"" + session_no + "\"";
                stmts = stmts + "~\"remarks\":\"" + remarks + "\"";
                stmts = stmts + "~\"gross_amount\":\"" + gross_amount + "\"";
                stmts = stmts + "~\"amount_due\":\"" + amount_due + "\"";
                stmts = stmts + "~\"status\":\"" + status + "\"";
                stmts = stmts + "~\"sales_type\":\"" + sales_type + "\"";
                stmts = stmts + "~\"line_discount\":\"" + line_discount + "\"";
                stmts = stmts + "~\"customer_id\":\"" + customer_id + "\"";
                stmts = stmts + "~\"customer_name\":\"" + customer_name + "\"";
                stmts = stmts + "~\"discount_name\":\"" + discount_name + "\"";
                stmts = stmts + "~\"discount_rate\":\"" + discount_rate + "\"";
                stmts = stmts + "~\"discount_amount\":\"" + discount_amount + "\"";
                stmts = stmts + "~\"discount_customer_name\":\"" + discount_customer_name + "\"";
                stmts = stmts + "~\"discount_customer_id\":\"" + discount_customer_id + "\"";
                stmts = stmts + "~\"charge_type\":\"" + charge_type + "\"";
                stmts = stmts + "~\"charge_type_id\":\"" + charge_type_id + "\"";
                stmts = stmts + "~\"charge_reference_no\":\"" + charge_reference_no + "\"";
                stmts = stmts + "~\"charge_customer_name\":\"" + charge_customer_name + "\"";
                stmts = stmts + "~\"charge_customer_id\":\"" + charge_customer_id + "\"";
                stmts = stmts + "~\"charge_amount\":\"" + charge_amount + "\"";
                stmts = stmts + "~\"check_bank\":\"" + check_bank + "\"";
                stmts = stmts + "~\"check_no\":\"" + check_no + "\"";

                stmts = stmts + "~\"check_amount\":\"" + check_amount + "\"";
                stmts = stmts + "~\"check_holder\":\"" + check_holder + "\"";
                stmts = stmts + "~\"check_date\":\"" + check_date + "\"";
                stmts = stmts + "~\"credit_card_type\":\"" + credit_card_type + "\"";
                stmts = stmts + "~\"credit_card_rate\":\"" + credit_card_rate + "\"";
                stmts = stmts + "~\"credit_card_amount\":\"" + credit_card_amount + "\"";
                stmts = stmts + "~\"credit_card_no\":\"" + credit_card_no + "\"";
                stmts = stmts + "~\"credit_card_holder\":\"" + credit_card_holder + "\"";
                stmts = stmts + "~\"credit_card_approval_code\":\"" + credit_card_approval_code + "\"";
                stmts = stmts + "~\"gift_cerftificate_from\":\"" + gift_certificate_from + "\"";

                stmts = stmts + "~\"gift_certificate_description\":\"" + gift_certificate_description + "\"";
                stmts = stmts + "~\"gift_certificate_no\":\"" + gift_certificate_no + "\"";
                stmts = stmts + "~\"gift_certificate_amount\":\"" + gift_certificate_amount + "\"";
                stmts = stmts + "~\"prepaid_customer_name\":\"" + prepaid_customer_name + "\"";
                stmts = stmts + "~\"prepaid_customer_id\":\"" + prepaid_customer_id + "\"";
                stmts = stmts + "~\"prepaid_amount\":\"" + prepaid_amount + "\"";
                stmts = stmts + "~\"addtl_amount\":\"" + addtl_amount + "\"";
                stmts = stmts + "~\"wtax\":\"" + wtax + "\"";
                stmts = stmts + "~\"branch\":\"" + branch + "\"";
                stmts = stmts + "~\"branch_id\":\"" + branch_id + "\"";
                stmts = stmts + "~\"location\":\"" + location + "\"";
                stmts = stmts + "~\"location_id\":\"" + location_id + "\"";
                stmts = stmts + "~\"items\":\"";

                String where2 = " where sales_no='" + sales_no + "' ";
                List<MySales_Items.items> items = MySales_Items.ret_data(where2);
                String s2 = "select "
                        + "item_code"
                        + ",barcode"
                        + ",item_type"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",branch_code"
                        + ",branch"
                        + " from sale_items  "
                        + " " + where2;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {

                    String item_code = rs2.getString(1);
                    String barcode = rs2.getString(2);
                    String item_type = rs2.getString(3);
                    String serial_no = rs2.getString(4);
                    double product_qty = rs2.getDouble(5);
                    String unit = rs2.getString(6);
                    double conversion = rs2.getDouble(7);
                    double selling_price = rs2.getDouble(8);
                    int is_vatable = rs2.getInt(9);
                    int selling_type = rs2.getInt(10);

                    String branch_code = rs2.getString(11);
                    String branch1 = rs2.getString(11);

                    stmts = stmts + "℮{\"item_code\":\"" + item_code + "\"";
                    stmts = stmts + "%\"barcode\":\"" + barcode + "\"";
                    stmts = stmts + "%\"qty\":\"" + product_qty + "\"";
                    stmts = stmts + "%\"selling_price\":\"" + selling_price + "\"";
                    stmts = stmts + "%\"is_vatable\":\"" + is_vatable + "\"";
                    stmts = stmts + "%\"discount_name\":\"" + discount_name + "\"";
                    stmts = stmts + "%\"discount_rate\":\"" + discount_rate + "\"";
                    stmts = stmts + "%\"discount_amount\":\"" + discount_amount + "\"";
                    stmts = stmts + "%\"discount_customer_name\":\"" + discount_customer_name + "\"";
                    stmts = stmts + "%\"discount_customer_id\":\"" + discount_customer_id + "\"";
                    stmts = stmts + "%\"branch\":\"" + branch1 + "\"";
                    stmts = stmts + "%\"branch_id\":\"" + branch_code + "\"";
                    stmts = stmts + "%\"location\":\"" + location + "\"";
                    stmts = stmts + "%\"location_id\":\"" + location_id + "\"";
                    stmts = stmts + "%\"addtl_amount\":\"" + addtl_amount + "\"";
                    stmts = stmts + "%\"serial_nos\":\"" + serial_no + "\"";
                    stmts = stmts + "%\"wtax\":\"" + wtax + "\"}\"Ω\"";
                }

                i++;

            }
            return stmts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

}
