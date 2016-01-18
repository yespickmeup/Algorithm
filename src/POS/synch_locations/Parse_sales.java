/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.synch_locations;

import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.util.DateType;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        String sales_no;
        String date_added;
        String user_screen_name;
        String user_id;
        String session_no;
        String remarks;
        double gross_amount;
        double amount_due;
        int status;
        int sales_type;
        double line_discount;
        String customer_id;
        String customer_name;
        String discount_name;
        double discount_rate;
        double discount_amount;
        String discount_customer_name;
        String discount_customer_id;
        String charge_type;
        String charge_type_id;
        String charge_reference_no = "";
        String charge_customer_name;
        String charge_customer_id;
        double charge_amount;
        String check_bank;
        String check_no;
        double check_amount;
        String check_holder;
        String check_date;
        String credit_card_type;
        double credit_card_rate;
        double credit_card_amount;
        String credit_card_no;
        String credit_card_holder;
        String credit_card_approval_code;
        String gift_cerftificate_from;
        String gift_certificate_description;
        String gift_certificate_no;
        double gift_certificate_amount;
        String prepaid_customer_name;
        String prepaid_customer_id;
        double prepaid_amount;
        double addtl_amount;
        double wtax;
        String branch;
        String branch_id;
        String location;
        String location_id;
        List<items> items;

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

            String item_code;
            String barcode;
            double qty;
            double selling_price;
            int is_vatable;
            String discount_name;
            double discount_rate;
            double discount_amount;
            String discount_customer_name;
            String discount_customer_id;
            String branch;
            String branch_id;
            String location;
            String location_id;
            double addtl_amount;
            String serial_nos;
            double wtax;

            public items(String item_code, String barcode, double qty, double selling_price, int is_vatable, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String branch, String branch_id, String location, String location_id, double addtl_amount,String serial_nos, double wtax) {
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
                this.serial_nos=serial_nos;
                this.wtax = wtax;
            }

        }

    }

    public static void main2(String[] args) {

    }

    public static void main(String[] args) {
        String where = " where Date(date_added) = '" + "2016-01-04" + "' ";

        List<MySales.sales> my_sales = MySales.ret_data(where);

        String stmt = Parse_sales.comprese(my_sales);

        List<Parse_sales.field> fields = Parse_sales.decomprese(stmt);

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
        Synch_locations.add_data(sl);

    }

    public static List<Parse_sales.field> decomprese(String stmt) {

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
                        String serial_nos="";
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
                            Parse_sales.field.items field = new Parse_sales.field.items(item_code, barcode, qty, selling_price, is_vatable, discount_name
                                    , discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_id, location, location_id
                                    , addtl_amount,serial_nos, wtax);
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

    public static String comprese(List<MySales.sales> my_sales) {

        String stmt = "";
        int i = 0;
        for (MySales.sales sale : my_sales) {
            if (i > 0) {
                stmt = stmt + "Ω,";
            }
            stmt = stmt + "\"[\"sales_no\":\"" + sale.sales_no + "\"";
            stmt = stmt + "~\"date_added\":\"" + sale.date_added + "\"";
            stmt = stmt + "~\"user_screen_name\":\"" + sale.user_screen_name + "\"";
            stmt = stmt + "~\"user_id\":\"" + sale.user_id + "\"";
            stmt = stmt + "~\"session_no\":\"" + sale.session_no + "\"";
            stmt = stmt + "~\"remarks\":\"" + sale.remarks + "\"";
            stmt = stmt + "~\"gross_amount\":\"" + sale.gross_amount + "\"";
            stmt = stmt + "~\"amount_due\":\"" + sale.amount_due + "\"";
            stmt = stmt + "~\"status\":\"" + sale.status + "\"";
            stmt = stmt + "~\"sales_type\":\"" + sale.sales_type + "\"";
            stmt = stmt + "~\"line_discount\":\"" + sale.line_discount + "\"";
            stmt = stmt + "~\"customer_id\":\"" + sale.customer_id + "\"";
            stmt = stmt + "~\"customer_name\":\"" + sale.customer_name + "\"";
            stmt = stmt + "~\"discount_name\":\"" + sale.discount_name + "\"";
            stmt = stmt + "~\"discount_rate\":\"" + sale.discount_rate + "\"";
            stmt = stmt + "~\"discount_amount\":\"" + sale.discount_amount + "\"";
            stmt = stmt + "~\"discount_customer_name\":\"" + sale.discount_customer_name + "\"";
            stmt = stmt + "~\"discount_customer_id\":\"" + sale.discount_customer_id + "\"";
            stmt = stmt + "~\"charge_type\":\"" + sale.charge_type + "\"";
            stmt = stmt + "~\"charge_type_id\":\"" + sale.charge_type_id + "\"";
            stmt = stmt + "~\"charge_reference_no\":\"" + sale.charge_reference_no + "\"";
            stmt = stmt + "~\"charge_customer_name\":\"" + sale.charge_customer_name + "\"";
            stmt = stmt + "~\"charge_customer_id\":\"" + sale.charge_customer_id + "\"";
            stmt = stmt + "~\"charge_amount\":\"" + sale.charge_amount + "\"";
            stmt = stmt + "~\"check_bank\":\"" + sale.check_bank + "\"";
            stmt = stmt + "~\"check_no\":\"" + sale.check_no + "\"";

            stmt = stmt + "~\"check_amount\":\"" + sale.check_amount + "\"";
            stmt = stmt + "~\"check_holder\":\"" + sale.check_holder + "\"";
            stmt = stmt + "~\"check_date\":\"" + sale.check_date + "\"";
            stmt = stmt + "~\"credit_card_type\":\"" + sale.credit_card_type + "\"";
            stmt = stmt + "~\"credit_card_rate\":\"" + sale.credit_card_rate + "\"";
            stmt = stmt + "~\"credit_card_amount\":\"" + sale.credit_card_amount + "\"";
            stmt = stmt + "~\"credit_card_no\":\"" + sale.credit_card_no + "\"";
            stmt = stmt + "~\"credit_card_holder\":\"" + sale.credit_card_holder + "\"";
            stmt = stmt + "~\"credit_card_approval_code\":\"" + sale.credit_card_approval_code + "\"";
            stmt = stmt + "~\"gift_cerftificate_from\":\"" + sale.gift_certificate_from + "\"";

            stmt = stmt + "~\"gift_certificate_description\":\"" + sale.gift_certificate_description + "\"";
            stmt = stmt + "~\"gift_certificate_no\":\"" + sale.gift_certificate_no + "\"";
            stmt = stmt + "~\"gift_certificate_amount\":\"" + sale.gift_certificate_amount + "\"";
            stmt = stmt + "~\"prepaid_customer_name\":\"" + sale.prepaid_customer_name + "\"";
            stmt = stmt + "~\"prepaid_customer_id\":\"" + sale.prepaid_customer_id + "\"";
            stmt = stmt + "~\"prepaid_amount\":\"" + sale.prepaid_amount + "\"";
            stmt = stmt + "~\"addtl_amount\":\"" + sale.addtl_amount + "\"";
            stmt = stmt + "~\"wtax\":\"" + sale.wtax + "\"";
            stmt = stmt + "~\"branch\":\"" + sale.branch + "\"";
            stmt = stmt + "~\"branch_id\":\"" + sale.branch_id + "\"";
            stmt = stmt + "~\"location\":\"" + sale.location + "\"";
            stmt = stmt + "~\"location_id\":\"" + sale.location_id + "\"";
            stmt = stmt + "~\"items\":\"";

            String where2 = " where sales_no='" + sale.sales_no + "' ";
            List<MySales_Items.items> items = MySales_Items.ret_data(where2);
            int t = 0;
            for (MySales_Items.items item : items) {
                stmt = stmt + "℮{\"item_code\":\"" + item.item_code + "\"";
                stmt = stmt + "%\"barcode\":\"" + item.barcode + "\"";
                stmt = stmt + "%\"qty\":\"" + item.product_qty + "\"";
                stmt = stmt + "%\"selling_price\":\"" + item.selling_price + "\"";
                stmt = stmt + "%\"is_vatable\":\"" + item.is_vatable + "\"";
                stmt = stmt + "%\"discount_name\":\"" + item.discount_name + "\"";
                stmt = stmt + "%\"discount_rate\":\"" + item.discount_rate + "\"";
                stmt = stmt + "%\"discount_amount\":\"" + item.discount_amount + "\"";
                stmt = stmt + "%\"discount_customer_name\":\"" + item.discount_customer_name + "\"";
                stmt = stmt + "%\"discount_customer_id\":\"" + item.discount_customer_id + "\"";
                stmt = stmt + "%\"branch\":\"" + item.branch + "\"";
                stmt = stmt + "%\"branch_id\":\"" + item.branch_code + "\"";

                stmt = stmt + "%\"location\":\"" + item.location + "\"";
                stmt = stmt + "%\"location_id\":\"" + item.location_id + "\"";
                stmt = stmt + "%\"addtl_amount\":\"" + item.addtl_amount + "\"";
                stmt = stmt + "%\"serial_nos\":\"" + item.serial_no + "\"";
                stmt = stmt + "%\"wtax\":\"" + item.wtax + "\"}\"Ω\"";
                t++;
            }

            i++;
        }
        return stmt;
    }

  
}
