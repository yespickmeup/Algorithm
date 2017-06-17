/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_sales_summary_per_cashier {

    public final List<Srpt_sales_summary_per_cashier.field> fields;
    public final String business_name;
    public final String address;
    public final String date;
    public final String branch;
    public final String location;
    public final String printed_by;
    public final String cashier;

    public Srpt_sales_summary_per_cashier(String business_name, String address, String date, String branch, String location, String printed_by, String cashier) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.branch = branch;
        this.location = location;
        this.printed_by = printed_by;
        this.cashier = cashier;
    }

    public static class field {

        String date;
        String branch;
        String location;
        String user_id;
        String user_screen_name;
        double amount_due;
        double line_discount;
        double sale_discount;
        double cash;
        double charge;
        double cheque;
        double credit_card;
        double gift_certificate;
        double prepaid;
        double balance_due;
        String location_id;
        double cash_count;
        String status;
        double cashin;
        double dibursement;

        public field() {
        }

        public field(String date, String branch, String location, String user_id, String user_screen_name, double amount_due, double line_discount, double sale_discount, double cash, double charge, double cheque, double credit_card, double gift_certificate, double prepaid, double balance_due, String location_id, double cash_count, String status, double cashin, double dibursement) {
            this.date = date;
            this.branch = branch;
            this.location = location;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.amount_due = amount_due;
            this.line_discount = line_discount;
            this.sale_discount = sale_discount;
            this.cash = cash;
            this.charge = charge;
            this.cheque = cheque;
            this.credit_card = credit_card;
            this.gift_certificate = gift_certificate;
            this.prepaid = prepaid;
            this.balance_due = balance_due;
            this.location_id = location_id;
            this.cash_count = cash_count;
            this.status = status;
            this.cashin = cashin;
            this.dibursement = dibursement;
        }

        public double getDibursement() {
            return dibursement;
        }

        public void setDibursement(double dibursement) {
            this.dibursement = dibursement;
        }

        public double getCashin() {
            return cashin;
        }

        public void setCashin(double cashin) {
            this.cashin = cashin;
        }

        public double getCash_count() {
            return cash_count;
        }

        public void setCash_count(double cash_count) {
            this.cash_count = cash_count;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_screen_name() {
            return user_screen_name;
        }

        public void setUser_screen_name(String user_screen_name) {
            this.user_screen_name = user_screen_name;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getLine_discount() {
            return line_discount;
        }

        public void setLine_discount(double line_discount) {
            this.line_discount = line_discount;
        }

        public double getSale_discount() {
            return sale_discount;
        }

        public void setSale_discount(double sale_discount) {
            this.sale_discount = sale_discount;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getCharge() {
            return charge;
        }

        public void setCharge(double charge) {
            this.charge = charge;
        }

        public double getCheque() {
            return cheque;
        }

        public void setCheque(double cheque) {
            this.cheque = cheque;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

        public double getGift_certificate() {
            return gift_certificate;
        }

        public void setGift_certificate(double gift_certificate) {
            this.gift_certificate = gift_certificate;
        }

        public double getPrepaid() {
            return prepaid;
        }

        public void setPrepaid(double prepaid) {
            this.prepaid = prepaid;
        }

        public double getBalance_due() {
            return balance_due;
        }

        public void setBalance_due(double balance_due) {
            this.balance_due = balance_due;
        }
    }

    public static void main(String[] args) {

        List<Srpt_sales_summary_per_cashier.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String date = "04/17/2017";
            String branch = "Dumaguete City";
            String location = "Selling Area";
            String user_id = "1";
            String user_screen_name = "Ronald Pascua";
            double amount_due = 100;
            double line_discount = 20;
            double sale_discount = 20;
            double cash = 100;
            double charge = 100;
            double cheque = 100;
            double credit_card = 100;
            double gift_certificate = 100;
            double prepaid = 100;
            double balance_due = 100;
            String location_id = "1";
            double cash_count = 0;
            String status = "Balance";
            double cashin = 1000;
            Srpt_sales_summary_per_cashier.field field = new Srpt_sales_summary_per_cashier.field(date, branch, location, user_id, user_screen_name, amount_due, line_discount, sale_discount, cash, charge, cheque, credit_card, gift_certificate, prepaid, balance_due, location_id, cash_count, status, cashin, 0);
            fields.add(field);
        }
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City");
        String date = "04/17/2017";
        String branch = "Dumaguete City";
        String location = "Selling Area";
        String printed_by = "Administrator";
        String cashier = "Cashier";
        Srpt_sales_summary_per_cashier rpt = new Srpt_sales_summary_per_cashier(business_name, address, date, branch, location, printed_by, cashier);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_sales_summary_per_cashier.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_summary_per_cashier.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_summary_per_cashier to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_sales_ledger.field> ret_data(String where) {
        List<Srpt_sales_ledger.field> fields = new ArrayList();

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
                    + " from sales  "
                    + " " + where;

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
                String credit_card_type = rs.getString(29);
                double credit_card_rate = rs.getDouble(30);
                double credit_card_amount = rs.getDouble(31);
                String credit_card_no = rs.getString(32);
                String credit_card_holder = rs.getString(33);
                String credit_card_approval_code = rs.getString(34);
                String gift_certificate_from = rs.getString(35);
                String gift_certificate_description = rs.getString(36);
                String gift_certificate_no = rs.getString(37);
                double gift_certificate_amount = rs.getDouble(38);
                String prepaid_customer_name = rs.getString(39);
                String prepaid_customer_id = rs.getString(40);
                double prepaid_amount = rs.getDouble(41);

                double sales_discount = discount_amount;
                double cash = amount_due - (charge_amount + check_amount + credit_card_amount + gift_certificate_amount + prepaid_amount);
                double cheque_amount = check_amount;
                double gc_amount = gift_certificate_amount;
                double balance_due = amount_due;

            }
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_sales_summary_per_cashier.field> ret_sales_summary_per_cashier(String where) {
        List<Srpt_sales_summary_per_cashier.field> datas = new ArrayList();
        String pool_db = System.getProperty("pool_db", "db_smis");

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + ",ten"
                    + ",five"
                    + ",one"
                    + ",point_five"
                    + ",point_two_five"
                    + ",point_ten"
                    + ",point_zero_five"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + " from cash_drawer"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String customer = "";
            while (rs.next()) {
                int id1 = rs.getInt(1);
                String session_no1 = rs.getString(2);
                String user_name1 = rs.getString(3);
                String screen_name1 = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);
                double ten = rs.getDouble(17);
                double five = rs.getDouble(18);
                double one = rs.getDouble(19);
                double point_five = rs.getDouble(20);
                double point_two_five = rs.getDouble(21);
                double point_ten = rs.getDouble(22);
                double point_zero_five = rs.getDouble(23);
                String branch = rs.getString(24);
                String branch_id = rs.getString(25);
                String location = rs.getString(26);
                String location_id = rs.getString(27);
                String user_id1 = rs.getString(28);
                String user_screen_name1 = rs.getString(29);
                String sf = DateType.convert_dash_date4(time_in);

                String where2 = " where Date(date_added)='" + sf + "' and user_id='" + user_id1 + "' and location_id='" + location_id + "' "
                        + " group by Date(date_added),user_id ";

                String date = DateType.convert_slash_datetime(time_in);
                String branch1 = branch;
                String location1 = location;
                String user_id = user_id1;
                String user_screen_name = user_screen_name1;
                double amount_due = 0;
                double one_thousand1 = thousand;
                double five_hundred1 = five_hundred;
                double two_hundred1 = two_hundred;
                double one_hundred1 = one_hundred;
                double fifty1 = fifty;
                double twenty1 = twenty;
                double ten1 = ten;
                double five1 = five;
                double one1 = one;
                double point_fifty1 = point_five;
                double point_twenty_five1 = point_two_five;
                double point_ten1 = point_ten;
                double point_five1 = point_zero_five;
                double amount1 = (one_thousand1 * 1000)
                        + (five_hundred1 * 500)
                        + (two_hundred1 * 200)
                        + (one_hundred1 * 100)
                        + (fifty1 * 50)
                        + (twenty1 * 20)
                        + (ten1 * 10)
                        + (five1 * 5)
                        + (one1 * 1)
                        + (point_fifty1 * .50)
                        + (point_twenty_five1 * .25)
                        + (point_ten1 * .10)
                        + (point_five1 * .05);
                amount_due = amount1;
                double line_discount = 0;
                double sale_discount = 0;
                double cash = 0;
                double charge = 0;
                double cheque = 0;
                double credit_card = 0;
                double gift_certificate = 0;
                double prepaid = 0;
                double balance_due = 0;
                String location_id1 = location_id;
                double cash_count = 0;
                cash_count = amount1;
                String status = "Balance";
                double cashin = amount;

                String s2 = "select "
                        + "id"
                        + ",sales_no"
                        + ",date_added"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",session_no"
                        + ",remarks"
                        + ",sum(gross_amount)"
                        + ",sum(amount_due)"
                        + ",status"
                        + ",sales_type"
                        + ",sum(line_discount)"
                        + ",customer_id"
                        + ",customer_name"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",sum(discount_amount)"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",charge_type"
                        + ",charge_type_id"
                        + ",charge_reference_no"
                        + ",charge_customer_name"
                        + ",charge_customer_id"
                        + ",sum(charge_amount)"
                        + ",check_bank"
                        + ",check_no"
                        + ",sum(check_amount)"
                        + ",credit_card_type"
                        + ",credit_card_rate"
                        + ",sum(credit_card_amount)"
                        + ",credit_card_no"
                        + ",credit_card_holder"
                        + ",credit_card_approval_code"
                        + ",gift_certificate_from"
                        + ",gift_certificate_description"
                        + ",gift_certificate_no"
                        + ",sum(gift_certificate_amount)"
                        + ",prepaid_customer_name"
                        + ",prepaid_customer_id"
                        + ",sum(prepaid_amount)"
                        + " from sales  "
                        + " " + where2;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    int id = rs2.getInt(1);
                    String sales_no = rs2.getString(2);
                    String date_added = rs2.getString(3);
                    String user_screen_name2 = rs2.getString(4);
                    String user_id2 = rs2.getString(5);
                    String session_no = rs2.getString(6);
                    String remarks = rs2.getString(7);
                    double gross_amount = rs2.getDouble(8);
                    double amount_due2 = rs2.getDouble(9);
                    int status2 = rs2.getInt(10);
                    int sales_type = rs2.getInt(11);
                    double line_discount2 = rs2.getDouble(12);
                    line_discount += line_discount2;
                    String customer_id = rs2.getString(13);
                    String customer_name = rs2.getString(14);
                    customer = customer_name;
                    String discount_name = rs2.getString(15);
                    double discount_rate = rs2.getDouble(16);
                    double discount_amount = rs2.getDouble(17);
                    sale_discount += discount_amount;
                    String discount_customer_name = rs2.getString(18);
                    String discount_customer_id = rs2.getString(19);
                    String charge_type = rs2.getString(20);
                    String charge_type_id = rs2.getString(21);
                    String charge_reference_no = rs2.getString(22);
                    String charge_customer_name = rs2.getString(23);
                    String charge_customer_id = rs2.getString(24);
                    double charge_amount = rs2.getDouble(25);
                    charge += charge_amount;
                    String check_bank = rs2.getString(26);
                    String check_no = rs2.getString(27);
                    double check_amount = rs2.getDouble(28);
                    cheque += check_amount;
                    String credit_card_type = rs2.getString(29);
                    double credit_card_rate = rs2.getDouble(30);
                    double credit_card_amount = rs2.getDouble(31);
                    credit_card += credit_card_amount;
                    String credit_card_no = rs2.getString(32);
                    String credit_card_holder = rs2.getString(33);
                    String credit_card_approval_code = rs2.getString(34);
                    String gift_certificate_from = rs2.getString(35);
                    String gift_certificate_description = rs2.getString(36);
                    String gift_certificate_no = rs2.getString(37);
                    double gift_certificate_amount = rs2.getDouble(38);
                    gift_certificate += gift_certificate_amount;
                    String prepaid_customer_name = rs2.getString(39);
                    String prepaid_customer_id = rs2.getString(40);
                    double prepaid_amount = rs2.getDouble(41);
                    prepaid += prepaid_amount;

                    double sales_discount = discount_amount;
                    double cash2 = amount_due2 - (charge_amount + check_amount + credit_card_amount + gift_certificate_amount + prepaid_amount);
                    cash += cash2;
                    double cheque_amount = check_amount;
                    double gc_amount = gift_certificate_amount;
                    double balance_due2 = amount_due;

                }

                String where3 = " where Date(disbursement_date)='" + sf + "' and user_id='" + user_id1 + "' and location_id='" + location_id + "' "
                        + " group by Date(disbursement_date ),user_id ";

                String s3 = "select "
                        + "amount"
                        + " from disbursements"
                        + " " + where3;
                double disburse = 0;
                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                while (rs3.next()) {
                    disburse += rs3.getDouble(1);
                }
                cash = (cash + cashin) - disburse;
                cash_count = amount1;
                double total = cash_count - cash;
//                System.out.println("total: " + total);

                if (total > 0) {
                    status = "Over [" + FitIn.fmt_wc_0(total) + "]";
                }
                if (total < 0) {
                    total = total * -1;
                    status = "Short [" + FitIn.fmt_wc_0(total) + "]";
                }
                if (total == 0) {
                    status = "Ok";
                }
                if (pool_db.equalsIgnoreCase("db_smis_cebu_chickaloka")) {
                    user_screen_name = customer;
                }
                Srpt_sales_summary_per_cashier.field field = new Srpt_sales_summary_per_cashier.field(date, branch, location, user_id, user_screen_name, amount_due, line_discount, sale_discount, cash, charge, cheque, credit_card, gift_certificate, prepaid, balance_due, location_id, cash_count, status, cashin, disburse);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
