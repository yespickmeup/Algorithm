/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.migrate;

import POS.inventory.Inventory;
import POS.receipts.Receipts;
import POS.receipts.S1_receipt_items;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Users;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;

/**
 *
 * @author Guinness
 */
public class Excel_to_db_inventory_items {

    public final String qty;
    public final String item_code;
    public final String barcode;
    public final String description;
    public final String cost;
    public final String selling_price;
    public final String category;
    public final String classification;
    public final String sub_classification;
    public final String brand;
    public final String model;
    public final String unit;
    public final String wholesale;
    public final String reorder_level;
    public final String show_to_sales;
    public final String supplier;

    public Excel_to_db_inventory_items(String qty, String item_code, String barcode, String description, String cost, String selling_price, String category, String classification, String sub_classification, String brand, String model, String unit, String wholesale, String reorder_level, String show_to_sales, String supplier) {
        this.qty = qty;
        this.item_code = item_code;
        this.barcode = barcode;
        this.description = description;
        this.cost = cost;
        this.selling_price = selling_price;
        this.category = category;
        this.classification = classification;
        this.sub_classification = sub_classification;
        this.brand = brand;
        this.model = model;
        this.unit = unit;
        this.wholesale = wholesale;
        this.reorder_level = reorder_level;
        this.show_to_sales = show_to_sales;
        this.supplier = supplier;
    }

    public static class asus {

        public final String part_no;
        public final String part_name;
        public final String part_description;
        public final String prod_code;
        public final String warehouse;
        public final String location;
        public final String lot;
        public final String real_loc;
        public final double available;
        public final double on_hand;
        public final double on_hand_qty;
        public final String part_group;
        public final double idel_days;

        public asus(String part_no, String part_name, String part_description, String prod_code, String warehouse, String location, String lot, String real_loc, double available, double on_hand, double on_hand_qty, String part_group, double idel_days) {
            this.part_no = part_no;
            this.part_name = part_name;
            this.part_description = part_description;
            this.prod_code = prod_code;
            this.warehouse = warehouse;
            this.location = location;
            this.lot = lot;
            this.real_loc = real_loc;
            this.available = available;
            this.on_hand = on_hand;
            this.on_hand_qty = on_hand_qty;
            this.part_group = part_group;
            this.idel_days = idel_days;
        }

    }

    public static void main3(String[] args) {
        //retail
        System.setProperty("pool_db", "db_smis_sibulan_abiera");
        String file = "C:\\Users\\User\\Documents\\Excel Files\\abiera.xls";

        if (file == null || file.isEmpty()) {
            return;
        }
        FileInputStream fis = null;
        final List sheetData = new ArrayList();
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        List<Excel_to_db_inventory_items> datas = Excel_to_db_inventory_items.showExcelData(sheetData, file);
        List<Inventory.to_inventory> tos = new ArrayList();
        int with_qty = 0;
        for (Excel_to_db_inventory_items encoded : datas) {
            if (FitIn.toDouble(encoded.qty) > 0) {
                with_qty++;
            }
            int id = -1;
            String barcode = "" + FitIn.toInt(encoded.item_code);
            if (barcode.equalsIgnoreCase("n/a")) {
                barcode = "";
            }
            String description = encoded.description;
            String generic_name = "";
            String category = encoded.category;
            if (category.equalsIgnoreCase("n/a")) {
                category = "";
            }
            String category_id = "";
            String classification = encoded.classification;
            if (classification.equalsIgnoreCase("n/a")) {
                classification = "";
            }
            String classification_id = "";
            String sub_classification = encoded.sub_classification;
            if (sub_classification.equalsIgnoreCase("n/a")) {
                sub_classification = "";
            }
            String sub_classification_id = "";
            double product_qty = 0;
            double conversion = 1;
            double selling_price = FitIn.toDouble(encoded.selling_price);
            String date_added = DateType.now();
            String user_name = "";
            String item_type = "Regular";
            int status = 1;

            String supplier = "";
            int fixed_price = 0;
            double cost = FitIn.toDouble(encoded.cost);
            String supplier_id = "";
            int multi_level_pricing = 0;
            int vatable = 0;
            double reorder_level = 0;
            double markup = 0;
            String barcodes = encoded.barcode;
            if (barcodes.equalsIgnoreCase("n/a")) {
                barcodes = "";
            }
            String brand = encoded.brand;
            if (brand.equalsIgnoreCase("n/a")) {
                brand = "";
            }
            String brand_id = "";
            String model = encoded.model;
            if (brand.equalsIgnoreCase("n/a")) {
                model = "";
            }
            String model_id = "";
            int selling_type = 1;

            String branch = "Sibulan City";
            String branch_code = "1";
            String location = "Selling Area";
            String location_id = "1";
            String unit = "[" + encoded.unit + ":" + encoded.selling_price + "/1.0^1]";
//            System.out.println("Unit: "+unit);
            int is_uploaded = 0;

            int allow_negative_inventory = 0;
            int auto_order = 1;
            int show_to_sales = FitIn.toInt(encoded.show_to_sales);
            Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
            tos.add(to);

//            //encoding
//            String item_code = "" + FitIn.toInt(encoded.item_code);
//
//            String branch_id = "1";
//
//            double qty = FitIn.toDouble(encoded.qty);
//
//            String screen_name = "administrator";
//            String sheet_no = "1";
//            String counted_by = "admin";
//            String checked_by = "admin";
//
//            String user_id = MyUser.getUser_id();
//            String user_screen_name = MyUser.getUser_screen_name();
//            String remarks = "";
//            Encoding_inventory.to_encoding_inventory en = new Encoding_inventory.to_encoding_inventory(id, item_code, barcodes, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, 0, counted_by, checked_by, cost, selling_price, user_id, user_screen_name, remarks);
//            Encoding_inventory.add_encoding_inventory(en);
        }
        List<String> query = Inventory.add_inventory_list(tos);
        System.out.println("Count: " + tos.size());
        Alert.set(1, "");
    }

    public static void main4(String[] args) {
        //wholesale
        System.setProperty("pool_db", "db_smis_bayawan_store");
        System.setProperty("pool_password", "password");
        String file = "C:\\Users\\User\\Documents\\Sqls\\Glass\\encoding.xls";

        if (file == null || file.isEmpty()) {
            return;
        }
        FileInputStream fis = null;
        final List sheetData = new ArrayList();
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        List<Excel_to_db_inventory_items> datas = Excel_to_db_inventory_items.showExcelData(sheetData, file);
//         System.out.println("Count: " + datas.size());
//        if (!datas.isEmpty()) {
//            return;
//        }
        List<Inventory.to_inventory> tos = new ArrayList();
        List<S1_receipt_items.to_receipt_items> acc = new ArrayList();

        int with_qty = 0;

        int id2 = 0;
        String aw = Receipts.increment_id("1");
        String receipt_no = aw;
        String where = " where receipt_no='" + receipt_no + "' ";

        String user_name = "admin";
        String session_no = "";
        String date_added = DateType.now();
        String supplier = "";
        String supllier_id = "";

        String remarks = "";
        String date_delivered = DateType.sf.format(new Date());
        String date_received = DateType.sf.format(new Date());

        String receipt_type = "";
        String reference_no = "000001";
        String branch = "Tinago";
        String branch_id = "1";
        double gross_total = 0;
        double net_total = 0;
        String batch_no = "0";
        double discount = 0;
        String receipt_type_id = "0";
        final Receipts.to_receipts to1 = new Receipts.to_receipts(id2, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, 0);

        for (Excel_to_db_inventory_items encoded : datas) {
            if (FitIn.toDouble(encoded.qty) > 0) {
                with_qty++;
            }
            int id = -1;
            String barcode = "" + FitIn.toInt(encoded.item_code);
            if (barcode.equalsIgnoreCase("n/a")) {
                barcode = "";
            }
            String description = encoded.description;
            String generic_name = "";
            String category = encoded.category;
            if (category.equalsIgnoreCase("n/a")) {
                category = "";
            }
            String category_id = "";
            String classification = encoded.classification;
            if (classification.equalsIgnoreCase("n/a")) {
                classification = "";
            }
            String classification_id = "";
            String sub_classification = encoded.sub_classification;
            if (sub_classification.equalsIgnoreCase("n/a")) {
                sub_classification = "";
            }
            String sub_classification_id = "";
            double product_qty = FitIn.toDouble(encoded.qty);

            double conversion = 1;
            double selling_price = FitIn.toDouble(encoded.selling_price);

            String item_type = "Regular";
            int status = 1;

            int fixed_price = 0;
            double cost = FitIn.toDouble(encoded.cost);
            String supplier_id = "";
            int multi_level_pricing = 0;
            int vatable = 0;
            double reorder_level = 0;
            double markup = 0;
            String barcodes = encoded.barcode;
            if (barcodes.equalsIgnoreCase("n/a")) {
                barcodes = "";
            }
            String brand = encoded.brand;
            if (brand.equalsIgnoreCase("n/a")) {
                brand = "";
            }
            String brand_id = "";
            String model = encoded.model;
            if (brand.equalsIgnoreCase("n/a")) {
                model = "";
            }
            String model_id = "";
            int selling_type = 0;

            String branch_code = "1";
            String location = "Main";
            String location_id = "1";
            String unit = "[Re-" + encoded.unit + ":" + encoded.selling_price + "/1.0^1],[Ws-" + encoded.unit + ":" + encoded.wholesale + "/1.0^0]";
            double sp = FitIn.toDouble(encoded.selling_price);
            double ws = FitIn.toDouble(encoded.wholesale);
            if (sp > 0 && ws == 0) {
                unit = "[Re-" + encoded.unit + ":" + encoded.selling_price + "/1.0^1]";
            }
            if (sp == 0 && ws > 0) {
                unit = "[Ws-" + encoded.unit + ":" + encoded.wholesale + "/1.0^1]";
            }

            int is_uploaded = 0;

            int allow_negative_inventory = 0;
            int auto_order = 1;
            int show_to_sales = FitIn.toInt(encoded.show_to_sales);

            Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, encoded.supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
            tos.add(to);

            //<editor-fold defaultstate="collapsed" desc=" insert to db ">
            if (product_qty > 0) {

                double qty = product_qty;

                String sub_class = encoded.sub_classification;
                String sub_class_id = "";
                String sup = "";
                String sup_id = "";

                String serial_no = "";
                String main_barcode = encoded.item_code;

                double previous_cost = 0;

                S1_receipt_items.to_receipt_items to4 = new S1_receipt_items.to_receipt_items(id, receipt_no, user_name, session_no, date_added, sup, sup_id,
                                                                                              remarks, barcode, description, qty, cost, category, category_id,
                                                                                              classification, classification_id, sub_class, sub_class_id, 1, unit, date_delivered, date_received, barcodes,
                                                                                              serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, 1, previous_cost, receipt_type_id, branch,
                                                                                              branch_id, location, location_id);
                acc.add(to4);
            }
            //</editor-fold>

        }

        List<String> query = Inventory.add_inventory_list(tos);
        Receipts.add_receipts(to1, acc);
        System.out.println("Count: " + tos.size());
        Alert.set(1, "");
    }

    public static void main(String[] args) {
        //wholesale
        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_password", "password");
//        System.setProperty("pool_host", "192.168.0.51");
        String file = "C:\\Users\\User\\Documents\\Excel Files\\asus.xls";

        if (file == null || file.isEmpty()) {
            return;
        }
        FileInputStream fis = null;
        final List sheetData = new ArrayList();
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        List<asus> datas = Excel_to_db_inventory_items.showExcelData_asus(sheetData, file);
        System.out.println("datas: " + datas.size());

        List<Inventory.to_inventory> tos = new ArrayList();
        //<editor-fold defaultstate="collapsed" desc=" Receipts ">
        //        List<S1_receipt_items.to_receipt_items> acc = new ArrayList();
//
//        int with_qty = 0;
//        int id2 = 0;
//        String aw = Receipts.increment_id("1");
//        String receipt_no = aw;
//        String where = " where receipt_no='" + receipt_no + "' ";
//        String user_name = "admin";
//        String session_no = "";
//        String date_added = DateType.now();
//        String supplier = "";
//        String supllier_id = "";
//
//        String remarks = "";
//        String date_delivered = DateType.sf.format(new Date());
//        String date_received = DateType.sf.format(new Date());
//
//        String receipt_type = "";
//        String reference_no = "000001";
//        String branch = "Tinago";
//        String branch_id = "1";
//        double gross_total = 0;
//        double net_total = 0;
//        String batch_no = "0";
//        double discount = 0;
//        String receipt_type_id = "0";
//        final Receipts.to_receipts to1 = new Receipts.to_receipts(id2, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, 0);
//
        //</editor-fold>

        for (asus encoded : datas) {

            int id = -1;
            String barcode = encoded.part_no;
            if (barcode.equalsIgnoreCase("n/a")) {
                barcode = "";
            }
            String description = encoded.part_description + " - " + encoded.part_name;
            String generic_name = "";
            String category = encoded.location;
            if (category.equalsIgnoreCase("n/a")) {
                category = "";
            }
            String category_id = "";
            String classification = encoded.lot;
            if (classification.equalsIgnoreCase("n/a")) {
                classification = "";
            }
            String classification_id = "";
            String sub_classification = encoded.part_group;
            if (sub_classification == null || sub_classification.equalsIgnoreCase("n/a")) {
                sub_classification = "";
            }
            String sub_classification_id = "";
            double product_qty = 0;

            double conversion = 1;
            double selling_price = 0;

            String item_type = "Regular";
            int status = 1;

            int fixed_price = 0;
            double cost = 0;
            String supplier_id = "";
            int multi_level_pricing = 0;
            int vatable = 0;
            double reorder_level = 0;
            double markup = 0;
            String barcodes = "";
            if (barcodes.equalsIgnoreCase("n/a")) {
                barcodes = "";
            }
            String brand = encoded.prod_code;
            if (brand.equalsIgnoreCase("n/a")) {
                brand = "";
            }
            String brand_id = "";
            String model = encoded.warehouse;
            if (brand.equalsIgnoreCase("n/a")) {
                model = "";
            }
            String model_id = "";
            int selling_type = 0;
            String branch = "Algorithm - Dgte";
            String branch_code = "1";
            String location = "ASUS";
            String location_id = "32";
            String unit = "[pc" + ":" + "0" + "/1.0^1]";
            double sp = 0;
            double ws = 0;

            int is_uploaded = 0;

            int allow_negative_inventory = 0;
            int auto_order = 1;
            int show_to_sales = 1;

            Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, DateType.now(), "admin", item_type, status, "asus", fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
            tos.add(to);
        }
//
        List<String> query = Inventory.add_inventory_list(tos);
//        Receipts.add_receipts(to1, acc);
        System.out.println("Count: " + tos.size());
        Alert.set(1, "");
    }

    public static List<asus> showExcelData_asus(List sheetData, String path) {

        FileInputStream fis;
        List<asus> datas = new ArrayList();
        try {
            fis = new FileInputStream(path);
            int r = 0;
            int r_set = 1;
            int id = 0;
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                int size = list.size();
                String[] record = new String[13];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 11) {
                        break;
                    }
                    if (j == 8 || j == 9 || j == 10) {
                        try {
                            data = "" + cell.getNumericCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getStringCellValue();
                        }
                    } else {

                        try {
                            data = "" + cell.getStringCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getNumericCellValue();
                        }
                    }

                    record[record_size] = data;
                    record_size++;
                }

                String part_no = record[0];

                String part_name = record[1];
                String part_description = record[2];
                String prod_code = record[3];

                String warehouse = record[4];

                String location = record[5];

                String lot = record[6];
//                 System.out.println("lot: "+lot);
                String real_loc = record[7];
                double available = FitIn.toDouble(record[8]);
                double on_hand = FitIn.toDouble(record[9]);
                double on_hand_qty = FitIn.toDouble(record[10]);
                String part_group = record[11];
                double idel_days = FitIn.toDouble(record[12]);

                asus asus = new asus(part_no, part_name, part_description, prod_code, warehouse, location, lot, real_loc, available, on_hand, on_hand_qty, part_group, idel_days);
                if (record[0] != null) {
                    datas.add(asus);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    public static List<Excel_to_db_inventory_items> showExcelData(List sheetData, String path) {

        FileInputStream fis;
        List<Excel_to_db_inventory_items> datas = new ArrayList();
        try {
            fis = new FileInputStream(path);
            int r = 0;
            int r_set = 1;
            int id = 0;
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                int size = list.size();
                String[] record = new String[13];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 13) {
                        break;
                    }
                    if (j == 1 || j == 4 || j == 5) {
                        try {
                            data = "" + cell.getNumericCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getStringCellValue();
                        }
                    } else {

                        try {
                            data = "" + cell.getStringCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getNumericCellValue();
                        }
                    }

                    record[record_size] = data;
//                    System.out.print(data + " | ");
                    record_size++;
                }
                String qty = record[0];
                String item_code = record[1];
                String barcode = record[2];
                String description = record[3];
                System.out.println("description: " + description);
                String cost = record[4];
                String selling_price = record[5];
                String category = record[6];
                String classification = record[7];
                String sub_classification = record[8];
                String brand = record[9];
                String model = record[10];

                String unit = record[11];
                String wholesale = "";
                String reorder_level = "";
                String show_to_sales = record[12];
                String supplier = "";
//                System.out.println("model:" + model);
//                System.out.println("unit:" + unit);
                Excel_to_db_inventory_items encoded = new Excel_to_db_inventory_items(qty, item_code, barcode, description, cost, selling_price, category, classification, sub_classification, brand, model, unit, wholesale, reorder_level, show_to_sales, supplier);
                if (record[0] != null) {
                    datas.add(encoded);
//                    System.out.println("code: " + item_code);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    public static List<Excel_to_db_inventory_items> showExcelData2(List sheetData, String path) {

        FileInputStream fis;
        List<Excel_to_db_inventory_items> datas = new ArrayList();
        try {
            fis = new FileInputStream(path);
            int r = 0;
            int r_set = 1;
            int id = 0;
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                int size = list.size();
                String[] record = new String[16];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 16) {
                        break;
                    }
                    if (j == 1 || j == 4 || j == 5) {
                        try {
                            data = "" + cell.getNumericCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getStringCellValue();
                        }
                    } else {

                        try {
                            data = "" + cell.getStringCellValue();
                        } catch (Exception e) {
                            data = "" + cell.getNumericCellValue();
                        }
                    }

                    record[record_size] = data;
//                    System.out.print(data + " | ");
                    record_size++;
                }
                String qty = record[0];
                String item_code = record[1];

                String barcode = record[2];
                String description = record[3];
                System.out.println("description: " + description);
                String cost = record[4];
                String selling_price = record[5];
                String category = record[6];
                String classification = record[7];
                String sub_classification = record[8];
                String brand = record[9];
                String model = record[10];

                String unit = record[11];
                String wholesale = record[12];
                String reorder_level = record[13];
                String show_to_sales = record[14];
                String supplier = record[15];
//                System.out.println("supplier: "+supplier);
//                System.out.println("wholesale:" + wholesale);
//                System.out.println("Reorder:" + reorder_level);
                Excel_to_db_inventory_items encoded = new Excel_to_db_inventory_items(qty, item_code, barcode, description, cost, selling_price, category, classification, sub_classification, brand, model, unit, wholesale, reorder_level, show_to_sales, supplier);
                if (record[0] != null) {
                    datas.add(encoded);
                    System.out.println("");
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel_to_db_inventory_items.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    public static Date getRoundedDate(double date) {
        int SECONDS_PER_DAY = 24 * 3600;

        int wholeDays = (int) Math.floor(date);
        double ms = date - wholeDays;

        /**
         * round the time part to seconds
         */
        int millisecondsInDay = (int) Math.round(SECONDS_PER_DAY * ms) * 1000;

        Calendar calendar = new GregorianCalendar(); // using default time-zone
//        org.apache.poi.ss.usermodel.DateUtil.setCalendar(calendar, wholeDays, millisecondsInDay, false);

        return calendar.getTime();
    }
}
