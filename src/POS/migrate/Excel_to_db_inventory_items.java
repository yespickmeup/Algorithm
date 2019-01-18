/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.migrate;

import POS.encoding_inventory.Encoding_inventory;
import POS.inventory.Inventory;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
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

    public Excel_to_db_inventory_items(String qty, String item_code, String barcode, String description, String cost, String selling_price, String category, String classification, String sub_classification, String brand, String model, String unit) {
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
    }

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_smis_dumaguete_refreshments");
        String file = "C:\\Users\\Ronescape\\Documents\\Excel Files\\Ray Buenavista\\encode.xls";

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

            String branch = "Dumaguete-Main Branch";
            String branch_code = "1";
            String location = "Warehouse";
            String location_id = "1";
            String unit = "[" + encoded.unit + ":" + encoded.selling_price + "/1.0^1]";
//            System.out.println("Unit: "+unit);
            int is_uploaded = 0;
            
                int allow_negative_inventory=0;
                int auto_order=1;
            Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded,allow_negative_inventory,auto_order);
            Inventory.add_inventory(to);

            //encoding
            String item_code = "" + FitIn.toInt(encoded.item_code);

            String branch_id = "1";

            double qty = FitIn.toDouble(encoded.qty);

            String screen_name = "administrator";
            String sheet_no = "1";
            String counted_by = "admin";
            String checked_by = "admin";

            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();
            String remarks = "";
            Encoding_inventory.to_encoding_inventory en = new Encoding_inventory.to_encoding_inventory(id, item_code, barcodes, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, 0, counted_by, checked_by, cost, selling_price, user_id, user_screen_name, remarks);
            Encoding_inventory.add_encoding_inventory(en);

        }
        System.out.println("Count: " + with_qty);
        Alert.set(1, "");
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
                String[] record = new String[12];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 12) {
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
                String cost = record[4];
                String selling_price = record[5];
                String category = record[6];
                String classification = record[7];
                String sub_classification = record[8];
                String brand = record[9];
                String model = record[10];

                String unit = record[11];
                System.out.println("model:" + model);
                System.out.println("unit:" + unit);
                Excel_to_db_inventory_items encoded = new Excel_to_db_inventory_items(qty, item_code, barcode, description, cost, selling_price, category, classification, sub_classification, brand, model, unit);
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
        org.apache.poi.ss.usermodel.DateUtil.setCalendar(calendar, wholeDays, millisecondsInDay, false);

        return calendar.getTime();
    }
}
