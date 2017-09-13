/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.inventory_reports.MyLedger;
import POS.inventory_reports.Srpt_item_ledger;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Srpt_end_of_day_summary_chickaloka {

    public final String business_name;
    public final String address;
    public final String date;
    public final String branch;
    public final String location;
    public final String cashier;
    public final double beggining_cash;
    public final double cash_sales;
    public final double operation_expenses;
    public final double net_sales;
    public final double cc_1000;
    public final double cc_500;
    public final double cc_200;
    public final double cc_100;
    public final double cc_50;
    public final double cc_20;
    public final double cc_10;
    public final double cc_5;
    public final double cc_1;
    public final double cc_point_50;
    public final double cc_point_25;
    public final double cc_point_10;
    public final double cc_point_05;
    public final double cc_total;
    public final double cash_remitted;
    public final double overage_shortage;
    public final double cash_in_next_day;
    public final double cash_for_deposit;
    public final List<field> fields;

    public Srpt_end_of_day_summary_chickaloka(String business_name, String address, String date, String branch, String location, String cashier, double beggining_cash, double cash_sales, double operation_expenses, double net_sales, double cc_1000, double cc_500, double cc_200, double cc_100, double cc_50, double cc_20, double cc_10, double cc_5, double cc_1, double cc_point_50, double cc_point_25, double cc_point_10, double cc_point_05, double cc_total, double cash_remitted, double overage_shortage, double cash_in_next_day, double cash_for_deposit) {
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.cashier = cashier;
        this.beggining_cash = beggining_cash;
        this.cash_sales = cash_sales;
        this.operation_expenses = operation_expenses;
        this.net_sales = net_sales;
        this.cc_1000 = cc_1000;
        this.cc_500 = cc_500;
        this.cc_200 = cc_200;
        this.cc_100 = cc_100;
        this.cc_50 = cc_50;
        this.cc_20 = cc_20;
        this.cc_10 = cc_10;
        this.cc_5 = cc_5;
        this.cc_1 = cc_1;
        this.cc_point_50 = cc_point_50;
        this.cc_point_25 = cc_point_25;
        this.cc_point_10 = cc_point_10;
        this.cc_point_05 = cc_point_05;
        this.cc_total = cc_total;
        this.cash_remitted = cash_remitted;
        this.overage_shortage = overage_shortage;
        this.cash_in_next_day = cash_in_next_day;
        this.cash_for_deposit = cash_for_deposit;
        this.fields = new ArrayList();
    }

    public static class field {

        String item_code;
        String description;
        double beg_inv;
        double new_in;
        double damage;
        double sales_qty;
        double end_inv;
        double amount;
        double po;
        double transfer;
        double left_over;
        double voucher;
        double shortage;
        double selling_price;
        double other_adjustment;
        double over;
        String remarks;

        public field() {
        }

        public field(String item_code, String description, double beg_inv, double new_in, double damage, double sales_qty, double end_inv, double amount, double po, double transfer, double left_over, double voucher, double shortage, double selling_price, double other_adjustment, double over, String remarks) {
            this.item_code = item_code;
            this.description = description;
            this.beg_inv = beg_inv;
            this.new_in = new_in;
            this.damage = damage;
            this.sales_qty = sales_qty;
            this.end_inv = end_inv;
            this.amount = amount;
            this.po = po;
            this.transfer = transfer;
            this.left_over = left_over;
            this.voucher = voucher;
            this.shortage = shortage;
            this.selling_price = selling_price;
            this.other_adjustment = other_adjustment;
            this.over = over;
            this.remarks = remarks;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public double getOver() {
            return over;
        }

        public void setOver(double over) {
            this.over = over;
        }

        public double getOther_adjustment() {
            return other_adjustment;
        }

        public void setOther_adjustment(double other_adjustment) {
            this.other_adjustment = other_adjustment;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getBeg_inv() {
            return beg_inv;
        }

        public void setBeg_inv(double beg_inv) {
            this.beg_inv = beg_inv;
        }

        public double getNew_in() {
            return new_in;
        }

        public void setNew_in(double new_in) {
            this.new_in = new_in;
        }

        public double getDamage() {
            return damage;
        }

        public void setDamage(double damage) {
            this.damage = damage;
        }

        public double getSales_qty() {
            return sales_qty;
        }

        public void setSales_qty(double sales_qty) {
            this.sales_qty = sales_qty;
        }

        public double getEnd_inv() {
            return end_inv;
        }

        public void setEnd_inv(double end_inv) {
            this.end_inv = end_inv;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getPo() {
            return po;
        }

        public void setPo(double po) {
            this.po = po;
        }

        public double getTransfer() {
            return transfer;
        }

        public void setTransfer(double transfer) {
            this.transfer = transfer;
        }

        public double getLeft_over() {
            return left_over;
        }

        public void setLeft_over(double left_over) {
            this.left_over = left_over;
        }

        public double getVoucher() {
            return voucher;
        }

        public void setVoucher(double voucher) {
            this.voucher = voucher;
        }

        public double getShortage() {
            return shortage;
        }

        public void setShortage(double shortage) {
            this.shortage = shortage;
        }

    }

    public static List<Srpt_end_of_day_summary_chickaloka.field> ret_data_group_by_code(String where, String year, int month, boolean is_month_selected, Date date, Date beggining_date) {
        List<Srpt_end_of_day_summary_chickaloka.field> fields = new ArrayList();

//        System.out.println("Yesterday: " + beggining_date);
//        System.out.println("Todays Date: " + date);
//        System.out.println("--------------------------");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",sum(product_qty)"
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
                    + " from sale_items  "
                    + " " + where
                    + " group by item_code,unit,selling_price,discount_amount order by id asc ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                String supplier = supplier_name;
                double price = selling_price;
                double discount = discount_amount;

                String uom = unit;
                String[] list = uom.split(",");

                int o = 0;
                for (String s : list) {
                    int i = s.indexOf(":");
                    int ii = s.indexOf("/");
                    int iii = s.indexOf("^");
                    String uom1 = s.substring(1, i);
                    double conversion1 = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                    product_qty = product_qty / conversion1;
                    double selling_price1 = FitIn.toDouble(s.substring(i + 1, ii));
                    int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                    uom1 = uom1.replaceAll("#", "/");
                    unit = uom1;
                    o++;
                }

                double amount = 0;
                double beg_inv = 0;
                double new_in = 0;
                double damage = 0;
                double sales_qty = product_qty;
                double sales_qty_x = 0;
                double end_inv = 0;
                double po = 0;
                double transfer = 0;
                double left_over = 0;
                double voucher = 0;
                double shortage = 0;
                double other_adjustment = 0;
                double over = 0;
//                System.out.println("item_code: " + item_code);
//                System.out.println("Description: " + description);
                Srpt_item_ledger rpt = MyLedger.get(item_code, barcode, description, location_id, year, month, branch, location, is_month_selected);
                List<Srpt_item_ledger.field> ledger = rpt.fields;
                String remarks = "";
                for (Srpt_item_ledger.field field : ledger) {

                    try {
                        Date f_date = DateType.slash_w_time.parse(field.getDate());
                        int count = DateUtils1.count_days(f_date, date);
                        if (count >= 1) {  //yesterday

                            if (FitIn.toDouble(field.getIn()) > 0) {
                                beg_inv += FitIn.toDouble(field.getIn());
                            } else {
                                beg_inv -= FitIn.toDouble(field.getOut());
                            }
                        }
                        if (count == 0) {
//                            today
                            if (field.getTransaction_type().equalsIgnoreCase("Inventory Count")) {
                                beg_inv += FitIn.toDouble(field.getIn());

                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Sales - X")) {
                                sales_qty_x += FitIn.toDouble(field.getIn());

                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Transfer-In") || field.getTransaction_type().equalsIgnoreCase("Receipts")) {
                                new_in += FitIn.toDouble(field.getIn());
//                                System.out.println("        Item: "+description+ " = "+field.);
                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Transfer-Out")) {
                                transfer += FitIn.toDouble(field.getOut());
//                                System.out.println("        Item: "+description+ " = "+field.);
                            }

                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Add")) {
                                other_adjustment += FitIn.toDouble(field.getIn());
                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Deduct")) {
                                other_adjustment -= FitIn.toDouble(field.getOut());
                            }

                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Damage")) {
                                damage -= FitIn.toDouble(field.getOut());
                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Leftover")) {
                                left_over -= FitIn.toDouble(field.getOut());
                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Voucher")) {
                                voucher -= FitIn.toDouble(field.getOut());
                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Short")) {
                                shortage -= FitIn.toDouble(field.getOut());
                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Over")) {
                                over -= FitIn.toDouble(field.getIn());
                            }
                            if (field.getTransaction_type().equalsIgnoreCase("Adjustment-Pull Out")) {
                                po -= FitIn.toDouble(field.getOut());
                            }

                            remarks = field.getRemarks();
//                            System.out.println("remarks: " + remarks);
                        } else {

                        }
//                        System.out.println("    " + field.getTransaction_type() + " : " + f_date + " / " + date + " | count: " + count);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_end_of_day_summary_chickaloka.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                sales_qty = sales_qty - sales_qty_x;
                amount = (price * sales_qty) - discount;
                end_inv = (beg_inv + ((new_in) + other_adjustment)) - (sales_qty + transfer);
                end_inv = end_inv + (damage + left_over + voucher + shortage + po) + over;

//                System.out.println("Item: " + description + " : beg_inv: " + beg_inv + " ,new_in: " + new_in + " ,other_adjustment: " + other_adjustment + " ,sales_qty: " + sales_qty+ ", transfer: "+transfer);
                if (damage < 0) {
                    damage = damage * -1;
                }
                if (left_over < 0) {
                    left_over = left_over * -1;
                }
                if (voucher < 0) {
                    voucher = voucher * -1;
                }
                if (shortage < 0) {
                    shortage = shortage * -1;
                }
//                System.out.println("************************");
                po = po * -1;
                Srpt_end_of_day_summary_chickaloka.field field = new field(item_code, description, beg_inv, new_in, damage, sales_qty, end_inv, amount, po, transfer, left_over, voucher, shortage, selling_price, other_adjustment, over, remarks);
                fields.add(field);
            }

            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
