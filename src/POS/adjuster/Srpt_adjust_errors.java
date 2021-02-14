/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.inventory_replenishment.Inventory_replenishment_items;
import POS.inventory_reports.MyLedger;
import POS.inventory_reports.Srpt_item_ledger;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_adjust_errors {

    public final String business_name;
    public final String address;
    public final String date;
    public final List<field> fields;

    public Srpt_adjust_errors(String business_name, String address, String date) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
    }

    public static class field {

        String item_code;
        String description;
        double cost;
        double price;
        String branch_id;
        String location_id;
        double qty_stock_take;
        double qty_ledger;

        public field() {
        }

        public field(String item_code, String description, double cost, double price, String branch_id, String location_id, double qty_stock_take, double qty_ledger) {
            this.item_code = item_code;
            this.description = description;
            this.cost = cost;
            this.price = price;
            this.branch_id = branch_id;
            this.location_id = location_id;
            this.qty_stock_take = qty_stock_take;
            this.qty_ledger = qty_ledger;
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

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(String branch_id) {
            this.branch_id = branch_id;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public double getQty_stock_take() {
            return qty_stock_take;
        }

        public void setQty_stock_take(double qty_stock_take) {
            this.qty_stock_take = qty_stock_take;
        }

        public double getQty_ledger() {
            return qty_ledger;
        }

        public void setQty_ledger(double qty_ledger) {
            this.qty_ledger = qty_ledger;
        }

    }

    public static void main2(String[] args) {
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("pool_db", "db_algorithm");

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City");
        String date = DateType.month_date.format(new Date());

        String where = " where location_id=14 order by description asc  ";
        List<Srpt_adjust_errors.field> fields = Srpt_adjust_errors.ret_data(where);
        System.out.println("size: " + fields.size());
        Srpt_adjust_errors rpt = new Srpt_adjust_errors(business_name, address, date);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_adjust_errors.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_adjust_errors.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_adjust_errors to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<field> ret_data(String where) {
        List<field> datas = new ArrayList();
        String year = "" + DateType.y.format(new Date());
        int month = FitIn.toInt(DateType.m1.format(new Date()));

        String date_from = "";
        String date_to = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",serial_no"
                    + " from inventory_barcodes "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                int main_barcode = rs.getInt(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String serial_no = rs.getString(37);

                String item_code = "" + main_barcode;

                double price = selling_price;
                String branch_id = branch_code;

                double qty_stock_take = product_qty;
                double qty_ledger = 0;

                String loc_id = location_id;

                boolean is_month_selected = true;

                if (date_from.isEmpty()) {

                    List<Inventory_replenishment_items.to_inventory_replenishment_items> replenishments = Inventory_replenishment_items.ret_data(" where location_id='" + loc_id + "' and item_code='" + item_code + "' order by id desc limit 1 ");
                    Inventory_replenishment_items.to_inventory_replenishment_items to = null;

                    if (!replenishments.isEmpty()) {
                        to = replenishments.get(0);
                        date_from = DateType.convert_dash_date4(to.date_added);

                        Date t = new Date();
                        t = DateUtils1.add_day(new Date(), 2);
                        date_to = DateType.sf.format(t);
                    }
                }

//                System.out.println("date_from: " + date_from);
//                System.out.println("date_to: " + date_to);
                Srpt_item_ledger rpt = MyLedger.get(item_code, barcode, description, loc_id, year, month, branch, location, is_month_selected, 1, 0, 1, date_from, date_to);
                System.out.println("Item Code: " + item_code);
                System.out.println("Description: " + description);
                System.out.println("Searching Ledger......");

                qty_ledger = rpt.running_balance;
                if (qty_ledger != qty_stock_take) {
                    field f = new field(item_code, description, cost, price, branch_id, location_id, qty_stock_take, qty_ledger);
                    datas.add(f);
                    System.out.println("    Item qty does not match the ledger... adding record: Stock take: " + qty_stock_take + " : Ledger: " + qty_ledger);
                }
                System.out.println("-----------------------------");
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        int month = FitIn.toInt(DateType.m1.format(new Date()));
        System.out.println("month: " + month);
    }

    public static void adjust_erros(List<Srpt_adjust_errors.field> fields) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement("");
            for (Srpt_adjust_errors.field field : fields) {
                String s0 = "update inventory_barcodes set "
                        + " product_qty= :product_qty "
                        + " where main_barcode='" + field.item_code + "' "
                        + " and location_id = '" + field.location_id + "'"
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setNumber("product_qty", field.qty_ledger)
                        .ok();
                stmt.addBatch(s0);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Adjuster.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
