/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.main;

import POS.pnl.Pnl_Dashboard;
import POS.sales.Sales;
import POS.util.Center;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author u2
 */
public class Main {

    private void start() {

        String license = System.getProperty("license", "full");

        if (!license.equalsIgnoreCase("full")) {
            int laps = 100;
            int count = Sales.count_sales();
            int total = laps - count;
            if (total == 0) {
                Window p = (Window) new JFrame();
                Dlg_license nd = Dlg_license.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_license.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_license.OutputData data) {
                        System.exit(1);
                    }
                });
                nd.setLocationRelativeTo(null);

                nd.setVisible(true);
            } else {
                if (total >= 1 && total <= 20) {
                    Window p = (Window) new JFrame();
                    Dlg_license nd = Dlg_license.create(p, true);
                    nd.setTitle("");
                    nd.do_pass(total);
                    nd.setCallback(new Dlg_license.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_license.OutputData data) {
                            closeDialog.ok();
                            open();
                        }
                    });
                    nd.setLocationRelativeTo(null);

                    nd.setVisible(true);
                } else {
                    open();
                }
            }
        } else {
            open();
        }

    }

    private void open() {
        Application.setSystemLookAndFeel();
        Pnl_Dashboard pnl = new Pnl_Dashboard();
        String url = "/POS/img/5.png";
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        pnl.setSize(xSize, ySize);
        pnl.wallpaper(pnl);
        pnl.setVisible(true);
    }

    public static void main(final String[] args) {

        try {
            String conf = (args.length > 0 ? args[0]
                    : null);
            Properties prop = new Properties();

            String userHome = System.getProperty("user.home");
            System.out.println(userHome);
            conf = (conf == null
                    ? "pos_algorithm.conf"
                    : conf);
            System.out.println(conf);
            File file = new File(userHome + "/" + conf);
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

            Properties info = new Properties();
            info.setProperty("proxool.maximum-connection-count", "5000000");
            System.setProperty("entityName", prop.getProperty("entityName", "Intelink-One"));
            System.setProperty("pdf.reader.loc", prop.getProperty("pdf.reader.loc", "AcroRd32.exe"));
            System.setProperty("instanceSocket", prop.getProperty("instanceSocket", "800"));
            System.setProperty("HOST_CONN_PYOP_SEND", prop.getProperty("server_conn", "localhost"));
            System.setProperty("HOST_PARAM_PYOP_SEND", prop.getProperty("server_param", "?user=root&password=password"));
            System.setProperty("pool_host", prop.getProperty("pool_host", "localhost:3306"));

            System.setProperty("pool_user", prop.getProperty("pool_user", "root"));
            System.setProperty("pool_password", prop.getProperty("pool_password", "password"));
            System.out.println(prop.getProperty("pool_host", "localhost"));
            System.setProperty("img_path", prop.getProperty("img_path", "C:\\Users\\i1\\"));
            System.setProperty("mydb", prop.getProperty("mydb", "db_algorithm"));
            String mydb = System.getProperty("mydb", "db_earthworks");
            MyDB.setNames(mydb);
            System.out.println(mydb);
            System.setProperty("receipt_footer", prop.getProperty("receipt_footer", "This serves as your Official Receipt"));
            System.setProperty("business_name", prop.getProperty("business_name", "Synapse Software Tech"));
            System.setProperty("operated_by", prop.getProperty("operated_by", "Operated by: Ronald Pascua"));
            System.setProperty("address", prop.getProperty("address", "Address: Dumaguete City"));
            System.setProperty("telephone_number", prop.getProperty("telephone_number", "Tel No: 09261625529"));
            System.setProperty("tin_no", prop.getProperty("tin_no", "TIN #: 0343434"));
            System.setProperty("min_no", prop.getProperty("min_no", "MIN NO: 130321854"));
            System.setProperty("status", prop.getProperty("status", "NV"));
            System.setProperty("serial_no", prop.getProperty("serial_no", "Serial No. FTE20130617"));
            System.setProperty("permit_no", prop.getProperty("permit_no", "Permit No: PR-0760032961"));
            System.setProperty("pos_no", prop.getProperty("pos_no", "POS No:000001 "));
            System.setProperty("print_to_receipts", prop.getProperty("print_to_receipts", "false"));

            System.setProperty("branch_id", prop.getProperty("branch_id", "1"));
            System.setProperty("branch", prop.getProperty("branch", "Dumaguete"));
            System.setProperty("license", prop.getProperty("license", "full"));
            System.setProperty("acct_no", prop.getProperty("acct_no", "Accreditation No. 000-0000000000-000000 "));
            System.setProperty("is_main_server", prop.getProperty("is_main_server", "false"));
            System.setProperty("unit_type", prop.getProperty("unit_type", "workstation"));
            
            

        } catch (IOException ex) {

            throw new RuntimeException(ex);
        }

        Window p = (Window) new JFrame();
        loading nd = loading.create(p, true);
        nd.setTitle("");
        nd.setCallback(new loading.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, loading.OutputData data) {
                new Main().start();
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);
        nd.setVisible(true);

    }

    public void aw() {
    }

    public static class MyDB {

        public static String names;

        public MyDB(String username) {
            names = username;
        }

        public static String getNames() {
            return names;
        }

        public static void setNames(String names) {
            MyDB.names = names;
        }
    }

    public static class CountOrders {

        public static int counts;

        public CountOrders(int counts1) {
            counts = counts1;
        }

        public static int getCounts() {
            return counts;
        }

        public static void setCounts(int counts) {
            CountOrders.counts = counts;
        }
    }

    public static class ImgPath {

        public static String path;

        public ImgPath(String username) {
            path = username;
        }

        public static String getPath() {
            return path;
        }

        public static void setPath(String path) {
            ImgPath.path = path;
        }
    }
}
