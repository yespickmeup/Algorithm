/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.main;

import POS.pnl.Pnl_Dashboard;
import POS.settings.Settings;
import POS.users.User_logs;
import POS.util.Alert;
import POS.util.Center;
import POS.util.DateType;
import POS.util.DateUtils1;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author Guinness
 */
public class MyMain {

    public static void main(String[] args) {
        ret_config();
    }

    private static void ret_config() {
        String home = System.getProperty("user.home") + "\\my_config.conf";
        String os = System.getProperty("os.name", "");

        if (os.equalsIgnoreCase("Linux")) {
            home = System.getProperty("user.home") + "/my_config.conf";
        }
        try {

            Properties prop = new Properties();
            String conf = "my_config.conf";
            String userHome = System.getProperty("user.home");

            File file = new File(home);
            if (file.exists()) {
                InputStream is = new FileInputStream(file);
                prop.load(is);
            } else {
                file = new File(conf);
                if (file.exists()) {
                    InputStream is = new FileInputStream(file);
                    prop.load(is);
                }
            }

            System.setProperty("pool_host", prop.getProperty("pool_host", "localhost"));
            System.setProperty("pool_port", prop.getProperty("pool_port", "3306"));
            System.setProperty("pool_user", prop.getProperty("pool_user", "root"));
            System.setProperty("pool_password", prop.getProperty("pool_password", "password"));
            System.setProperty("pool_db", prop.getProperty("pool_db", "db_smis"));
            System.setProperty("environment", prop.getProperty("environment", "development"));
            System.setProperty("auto_order", prop.getProperty("auto_order", "false"));
            System.setProperty("inventory_item_delete", prop.getProperty("inventory_item_delete", "false"));
            System.setProperty("delete_receipts_finalized", prop.getProperty("delete_receipts_finalized", "false"));
            System.setProperty("delete_stock_transfers_finalized", prop.getProperty("delete_stock_transfers_finalized", "false"));
            System.setProperty("delete_other_adjustments_finalized", prop.getProperty("delete_other_adjustments_finalized", "false"));
            System.setProperty("delete_prepaid_payment_finalized", prop.getProperty("delete_prepaid_payment_finalized", "false"));
            System.setProperty("sales_date", prop.getProperty("sales_date", "os"));
            System.setProperty("multi_cashin", prop.getProperty("multi_cashin", "false"));
//            System.out.println("OS: " + os);
            System.setProperty("direct_pay", prop.getProperty("direct_pay", "false"));
//            System.out.println("pool_db: " + pool_db);
//            System.out.println("pool_db: " + System.getProperty("pool_db"));
//            System.out.println("Host: " + System.getProperty("pool_host"));
//            System.out.println("Environment: " + System.getProperty("environment"));
//            System.out.println("inventory_item_delete: " + System.getProperty("inventory_item_delete"));

            String where = "";
            List<Settings.to_settings> datas = Settings.ret_data(where);
            Settings.to_settings setting = datas.get(0);

            String where2 = "order by id desc limit 1";
            List<User_logs.to_user_logs> last = User_logs.ret_data(where2);
            
            if (!last.isEmpty()) {
                User_logs.to_user_logs l = (User_logs.to_user_logs) last.get(0);
                Date d = new Date();
                Date date_to = new Date();
                try {
                    date_to = DateType.datetime.parse(l.created_at);
                } catch (ParseException ex) {
                    Logger.getLogger(Pnl_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                int count2 = DateUtils1.count_days(d, date_to);

                if (count2 > 0) {
                    Alert.set(0, "Check system Date!");
                    try {
                        Thread.sleep(5);

                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MyMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(1);
                }

            }
            if (setting.receipt_printing_enabled == 1) {
                System.setProperty("receipt_printing_enabled", "true");
                System.setProperty("print_to_receipts", "true");

            } else {
                System.setProperty("print_to_receipts", "false");
                System.setProperty("receipt_printing_enabled", "false");
            }
            if (setting.receipt_printing_enabled2 == 1) {
                System.setProperty("receipt_printing_enabled2", "true");
                System.setProperty("print_to_receipts2", "true");
            } else {
                System.setProperty("receipt_printing_enabled2", "false");
                System.setProperty("print_to_receipts2", prop.getProperty("print_to_receipts2", "false"));
            }
            if (setting.kitchen_printing_enable == 1) {
                System.setProperty("kitchen_order_printing_enabled", "true");
            } else {
                System.setProperty("kitchen_order_printing_enabled", "false");
            }
            if (setting.allow_negative_inventory == 1) {
                System.setProperty("allow_negative_inventory", "true");
            } else {
                System.setProperty("allow_negative_inventory", "false");
            }

            if (setting.receipt_printer_show_dialog == 1) {
                System.setProperty("receipt_printer_show_dialog", "true");
            } else {
                System.setProperty("receipt_printer_show_dialog", "false");
            }

            //
            System.setProperty("business_name", setting.company_name);
            System.setProperty("address", setting.company_address);
            System.setProperty("operated_by", setting.company_operated_by);
            System.setProperty("slogan", setting.company_slogan);
            System.setProperty("contact_number", setting.company_contact_no);
            System.setProperty("fax_number", setting.company_fax_no);
            System.setProperty("email_address", setting.company_email_address);
            System.setProperty("receipt_footer", setting.bir_receipt_footer);
            System.setProperty("invoice_footer", setting.bir_invoice_footer);
            System.setProperty("serial_no", setting.bir_serial_no);

            System.setProperty("accreditation_no", setting.bir_accreditation_no);
            System.setProperty("tin_no", setting.bir_tin);
            System.setProperty("machine_no", setting.bir_machine_no);
            System.setProperty("min_no", setting.bir_min_no);
            System.setProperty("business_type", setting.bir_business_type);
            System.setProperty("vat_percent", setting.bir_vat_percent);
            System.setProperty("permit_no", setting.bir_permit_no);

            //
            //
            System.setProperty("developer", setting.developer);
            System.setProperty("developer_address", setting.developer_address);
            System.setProperty("developer_tin_no", setting.developer_tin_no);
            System.setProperty("developer_accreditation_no", setting.developer_accreditation_no);
            System.setProperty("developer_accreditation_date", setting.developer_accreditation_date);
            System.setProperty("support", setting.developer_contact_no);
            System.setProperty("drawer", setting.drawer);

            //
            //
            System.setProperty("license_code", prop.getProperty("license_code", ""));
            System.setProperty("version", prop.getProperty("version", ""));

            System.setProperty("terminal_number", prop.getProperty("terminal_number", "0"));
            System.setProperty("hdd_drive", prop.getProperty("hdd_drive", ""));
            System.setProperty("img_path", prop.getProperty("img_path", System.getProperty("user.home", "C:\\Users\\User") + "\\"));

            //
            System.setProperty("module_software_type", prop.getProperty("module_software_type", ""));
            System.setProperty("module_accounts_payable", prop.getProperty("module_accounts_payable", "0"));
            System.setProperty("module_accounts_receivable", prop.getProperty("module_accounts_receivable", "0"));
            System.setProperty("module_services", prop.getProperty("module_services", "0"));
            System.setProperty("module_prepayments", prop.getProperty("module_prepayments", "0"));
            System.setProperty("module_requisition_slip", prop.getProperty("module_requisition_slip", "0"));
            System.setProperty("module_charge_in_advance", prop.getProperty("module_charge_in_advance", "0"));

            System.setProperty("is_server", prop.getProperty("is_server", "false"));
            System.setProperty("location", prop.getProperty("location", "main_branch"));

            System.setProperty("return_exchange_days", prop.getProperty("return_exchange_days", "0"));

            if (setting.is_main_branch == 0) {
                System.setProperty("main_branch", prop.getProperty("main_branch", "false"));
            } else {
                System.setProperty("main_branch", prop.getProperty("main_branch", "true"));
            }
            if (setting.module_prepayments == 1) {
                System.setProperty("module_prepayments", prop.getProperty("module_prepayments", "1"));
            }
            if (setting.module_accounts_receivable == 1) {
                System.setProperty("module_accounts_receivable", prop.getProperty("module_accounts_receivable", "1"));
            }
            if (setting.module_accounts_payable == 1) {
                System.setProperty("module_accounts_payable", prop.getProperty("module_accounts_payable", "1"));
            }
            if (setting.module_charge_in_advance == 1) {
                System.setProperty("module_charge_in_advance", prop.getProperty("module_charge_in_advance", "1"));
            }
            if (setting.module_services == 1) {
                System.setProperty("module_services", prop.getProperty("module_services", "1"));
            }

            System.setProperty("cloud_host", setting.cloud_host);
            System.setProperty("cloud_port", setting.cloud_port);
            System.setProperty("cloud_user", setting.cloud_user);
            System.setProperty("cloud_password", setting.cloud_password);
            System.setProperty("cloud_db", setting.cloud_db);
            System.setProperty("active_branches", prop.getProperty("active_branches", ""));
            System.setProperty("ar_footer", setting.ar_footer);
            System.setProperty("img_logo", prop.getProperty("img_logo", System.getProperty("user.home") + "\\smis\\logo.png"));

            System.setProperty("version", setting.version);
            //
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Window p = (Window) new JFrame();
            loading nd = loading.create(p, true);
            nd.setTitle("");
            nd.setCallback(new loading.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, loading.OutputData data) {
                    new MyMain().start();
                    closeDialog.ok();
                }
            });
            Center.setCenter(nd);
            nd.setVisible(true);
        }
    }

    private void start() {
        Application.setSystemLookAndFeel();
        Pnl_Dashboard pnl = new Pnl_Dashboard();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/POS/main/icon.png"));
        pnl.setIconImage(image);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        pnl.setSize(xSize, ySize);
        pnl.wallpaper(pnl);
        pnl.setVisible(true);
    }

    public static String getSerialNumber() {
        String drive = System.getProperty("hdd_drive", "");

        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    + "Set colDrives = objFSO.Drives\n"
                    + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                    + "Wscript.Echo objDrive.SerialNumber";  // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.trim();
    }

}
