/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.migrate;

import java.awt.FileDialog;
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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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

    public Excel_to_db_inventory_items(String qty, String item_code, String barcode, String description, String cost, String selling_price, String category, String classification, String sub_classification, String brand, String model) {
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
    }

    public static void main(String[] args) {

        String file = "C:\\Users\\Guinness\\Desktop\\Clients\\Zamboanguita\\encode.xls";

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
                String[] record = new String[11];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 11) {
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
                    System.out.print(data + " | ");
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

                Excel_to_db_inventory_items encoded = new Excel_to_db_inventory_items(qty, item_code, barcode, description, cost, selling_price, category, classification, sub_classification, brand, model);
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
