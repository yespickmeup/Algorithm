/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import static POS.branches_sessions.Check_cloud_local_uploads.FileToString;
import static POS.branches_sessions.Dlg_branch_local_downloads.loadData_local_uploads;
import static POS.branches_sessions.Dlg_branch_local_uploads.loadData_local_uploads;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.MyConnection;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_branch_sessions extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_branch_sessions
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_branch_sessions(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_branch_sessions(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_branch_sessions() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_branch_sessions myRef;

    private void setThisRef(Dlg_branch_sessions myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_branch_sessions> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_branch_sessions create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_branch_sessions create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_branch_sessions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_sessions((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_branch_sessions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_sessions((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_branch_sessions dialog = Dlg_branch_sessions.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Default();
        jCheckBox2 = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Auto-Synch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Manual Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jCheckBox2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Select action to start!");

        jXLabel1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ac est enim. Phasellus sit amet mattis enim. Suspendisse eu hendrerit sem. Praesent molestie quam id eros feugiat facilisis. Nam tempus lacinia lorem. Pellentesque vitae nunc ac lacus volutpat bibendum et ac ligula. Phasellus sit amet sodales lorem, a lacinia nunc");
        jXLabel1.setLineWrap(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jCheckBox1.isSelected()) {
            jCheckBox1.setSelected(false);
        } else {
            jCheckBox1.setSelected(true);
        }
        start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jCheckBox2.isSelected()) {
            jCheckBox2.setSelected(false);
        } else {
            jCheckBox2.setSelected(true);
        }
        String unit_type = System.getProperty("unit_type", "main_branch_server");
        if (unit_type.equalsIgnoreCase("main_branch_server")) {
            start_synching_main_branch_server();
        }
        if (unit_type.equalsIgnoreCase("local_branch_server")) {
            start_synching_local_branch_server();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_branch();

        String unit_type = System.getProperty("unit_type", "main_branch_server");
        if (unit_type.equalsIgnoreCase("main_branch_server")) {
            jLabel2.setText("Main Branch Server: " + my_branch);
        }
        if (unit_type.equalsIgnoreCase("local_branch_server")) {
            jLabel2.setText("Local Branch Server: " + my_branch);
        }

    }

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;
    }

    public void do_pass() {

    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    int count = 1;
    Timer timer = new Timer();

    private void start() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
            }
        });

        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int hour = FitIn.toInt(DateType.hour.format(new Date()));
                int minutes = FitIn.toInt(DateType.minute.format(new Date()));
                int seconds = FitIn.toInt(DateType.seconds.format(new Date()));
                if (hour >= 19 && hour <= 20) {
                    System.out.println("Time for synching.....");
                    String unit_type = System.getProperty("unit_type", "main_branch_server");
                    if (unit_type.equalsIgnoreCase("main_branch_server")) {
                        start_synching_main_branch_server();
                    }
                    if (unit_type.equalsIgnoreCase("local_branch_server")) {
                        start_synching_local_branch_server();
                    }
                }
                if (count == 11) {
                    try {
                        timer.cancel();
                        if (timer != null) {
                            timer = null;
                            System.gc();

                        }
                        count = 1;

                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                jProgressBar1.setString("Finished...");
                                jProgressBar1.setIndeterminate(false);
                            }
                        });

                        jButton1.setEnabled(true);
                        jButton2.setEnabled(true);
                        Thread.sleep(5000);

                        start();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asynch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                String message = "Time: " + hour + ":" + minutes + ":" + seconds + " Count: " + count;
                jXLabel1.setText(message);
                System.out.println(message);

                count++;
            }
        }, 1000, 1000);
    }

    List<Branch_local_uploads.to_branch_local_uploads> to_upload = new ArrayList();

    private void start_synching_local_branch_server() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
            }
        });
        jButton2.setEnabled(false);
        jButton1.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int connected = MyConnection.check_cloud_connection();
                if (connected == 0) {
                    jXLabel1.setText("Not Connected to cloud!");
                    return;
                }
                start_synching_local_branch_server_upload();
                start_synching_local_branch_server_download();
            }
        });
        t.start();
    }

    private void start_synching_local_branch_server_upload() {
        //<editor-fold defaultstate="collapsed" desc=" Upload ">
        String where3 = " where branch_id='" + my_branch_id + "' order by id desc limit 1";
        List<Branch_local_uploads.to_branch_local_uploads> last_upload = Branch_local_uploads.ret_data(where3);
        String date_from = "";

        for (Branch_local_uploads.to_branch_local_uploads to : last_upload) {
            try {
                Date d = synsoftech.util.DateType.datetime.parse(to.date_added);
                date_from = synsoftech.util.DateType.sf.format(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_branch_local_uploads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String now = synsoftech.util.DateType.sf.format(new Date());
        System.out.println("Last Cloud upload date: " + date_from);
        System.out.println("Todays date: " + now);

        if (date_from.equals(now)) {
            System.out.println("Nothing to Upload!");
            jXLabel1.setText("Nothing to Upload!");
            return;
        }
        jXLabel1.setText("Connected to Cloud!");
        System.out.println("Connected to Cloud!");
        if (!date_from.isEmpty()) {
            String path = System.getProperty("user.home");
            List<String> days = Branch_local_uploads.getDates(date_from);
            int i = 1;
            for (String s : days) {
                String where = " where Date(date_added)='" + s + "'  ";
                String where2 = " where Date(time_in)='" + s + "'  ";
                Branch_local_uploads.to_upload_count replenishments = Parse_inventory_replenishments.compress(where);
                Branch_local_uploads.to_upload_count inventory_counts = Parse_inventory_counts.compress(where);
                Branch_local_uploads.to_upload_count adjustments = Parse_inventory_adjustments.compress(where);
                Branch_local_uploads.to_upload_count stock_transfers = Parse_stock_transfers.compress(where);
                String receipts = Parse_receipts.compress(where);
                Branch_local_uploads.to_upload_count sales = Parse_sales.compress(where);
                Branch_local_uploads.to_upload_count returned_items = Parse_sale_item_replacements.compress(where);
                Branch_local_uploads.to_upload_count charged_items = Parse_charged_items.compress(where);
                String rmas = "";
                String item_maintenances = "";
                Branch_local_uploads.to_upload_count cash_drawers = Parse_cash_drawers.compress(where2);

                String name = POS.util.DateType.y.format(new Date()) + "" + POS.util.DateType.d.format(new Date()) + "" + POS.util.DateType.m1.format(new Date());

                File file_replenishments = new File(path + "\\cloud_uploads\\" + "file_replenishments" + s + ".txt");
                File file_inventory_counts = new File(path + "\\cloud_uploads\\" + "inventory_counts" + s + ".txt");
                File file_adjustments = new File(path + "\\cloud_uploads\\" + "file_adjustments" + s + ".txt");
                File file_stock_transfers = new File(path + "\\cloud_uploads\\" + "file_stock_transfers" + s + ".txt");
                File file_receipts = new File(path + "\\cloud_uploads\\" + "file_receipts" + s + ".txt");
                File file_sales = new File(path + "\\cloud_uploads\\" + "file_sales" + s + ".txt");
                File file_returned_items = new File(path + "\\cloud_uploads\\" + "file_returned_items" + s + ".txt");
                File file_charged_items = new File(path + "\\cloud_uploads\\" + "charged_items" + s + ".txt");
                File file_rmas = new File(path + "\\cloud_uploads\\" + "file_rmas" + s + ".txt");
                File file_item_maintenances = new File(path + "\\cloud_uploads\\" + "file_item_maintenances" + s + ".txt");
                File file_cash_drawers = new File(path + "\\cloud_uploads\\" + "file_cash_drawers" + s + ".txt");

                FileWriter fw_replenishments;
                FileWriter fw_inventory_counts;
                FileWriter fw_adjustments;
                FileWriter fw_stock_transfers;
                FileWriter fw_receipts;
                FileWriter fw_sales;
                FileWriter fw_returned_items;
                FileWriter fw_charged_items;
                FileWriter fw_rmas;
                FileWriter fw_item_maintenances;
                FileWriter fw_cash_drawers;
                try {
                    fw_replenishments = new FileWriter(file_replenishments.getAbsoluteFile());
                    BufferedWriter bw_replenishments = new BufferedWriter(fw_replenishments);
                    bw_replenishments.write(replenishments.stmt);

                    bw_replenishments.close();
                    fw_replenishments.close();

                    fw_inventory_counts = new FileWriter(file_inventory_counts.getAbsoluteFile());
                    BufferedWriter bw_inventory_counts = new BufferedWriter(fw_inventory_counts);
                    bw_inventory_counts.write(inventory_counts.stmt);

                    bw_inventory_counts.close();
                    fw_inventory_counts.close();

                    fw_adjustments = new FileWriter(file_adjustments.getAbsoluteFile());
                    BufferedWriter bw_adjustments = new BufferedWriter(fw_adjustments);
                    bw_adjustments.write(adjustments.stmt);

                    bw_adjustments.close();
                    fw_adjustments.close();

                    fw_stock_transfers = new FileWriter(file_stock_transfers.getAbsoluteFile());
                    BufferedWriter bw_stock_transfers = new BufferedWriter(fw_stock_transfers);
                    bw_stock_transfers.write(stock_transfers.stmt);

                    bw_stock_transfers.close();
                    fw_stock_transfers.close();

                    fw_receipts = new FileWriter(file_receipts.getAbsoluteFile());
                    BufferedWriter bw_receipts = new BufferedWriter(fw_receipts);
                    bw_receipts.write(receipts);

                    bw_receipts.close();
                    fw_receipts.close();

                    fw_sales = new FileWriter(file_sales.getAbsoluteFile());
                    BufferedWriter bw_sales = new BufferedWriter(fw_sales);
                    bw_sales.write(sales.stmt);

                    bw_sales.close();
                    fw_sales.close();

                    fw_returned_items = new FileWriter(file_returned_items.getAbsoluteFile());
                    BufferedWriter bw_returned_items = new BufferedWriter(fw_returned_items);
                    bw_returned_items.write(returned_items.stmt);

                    bw_returned_items.close();
                    fw_returned_items.close();

                    fw_charged_items = new FileWriter(file_charged_items.getAbsoluteFile());
                    BufferedWriter bw_charged_items = new BufferedWriter(fw_charged_items);
                    bw_charged_items.write(charged_items.stmt);

                    bw_charged_items.close();
                    fw_charged_items.close();

                    fw_rmas = new FileWriter(file_rmas.getAbsoluteFile());
                    BufferedWriter bw_rmas = new BufferedWriter(fw_rmas);
                    bw_rmas.write(rmas);

                    bw_rmas.close();
                    fw_rmas.close();

                    fw_item_maintenances = new FileWriter(file_item_maintenances.getAbsoluteFile());
                    BufferedWriter bw_item_maintenances = new BufferedWriter(fw_item_maintenances);
                    bw_item_maintenances.write(item_maintenances);

                    bw_item_maintenances.close();
                    fw_item_maintenances.close();

                    fw_cash_drawers = new FileWriter(file_cash_drawers.getAbsoluteFile());
                    BufferedWriter bw_cash_drawers = new BufferedWriter(fw_cash_drawers);
                    bw_cash_drawers.write(cash_drawers.stmt);

                    bw_cash_drawers.close();
                    fw_cash_drawers.close();

                } catch (IOException ex) {
                    Logger.getLogger(Parse_sales.class.getName()).log(Level.SEVERE, null, ex);
                }

                int id = 0;
                int status = 0;
                String date_added = s + " 00:00:00";
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_id();
                String branch = my_branch;
                String branch_id = my_branch_id;
                String location = my_location;
                String location_id = my_location_id;
                Branch_local_uploads.to_branch_local_uploads upload = new Branch_local_uploads.to_branch_local_uploads(id, file_replenishments, file_inventory_counts, file_adjustments, file_stock_transfers, file_receipts, file_sales, file_returned_items, file_charged_items, file_rmas, file_item_maintenances, file_cash_drawers, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
                to_upload.add(upload);
                System.out.println("************************************************");
                i++;
            }

        }

        Branch_local_uploads.add_data(to_upload);
        File file = new File(System.getProperty("user.home") + "\\uploads\\");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (String myFile1 : myFiles) {
                File myFile = new File(file, myFile1);
                myFile.delete();
            }
        }
        to_upload.clear();
        System.out.println("Upload Successfull!");
        jXLabel1.setText("Upload Successfull!");

        jButton2.setEnabled(true);
        jButton1.setEnabled(false);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        //</editor-fold>
    }

    private void start_synching_local_branch_server_download() {
        //<editor-fold defaultstate="collapsed" desc=" Download ">
        String where = " where status=0  and branch_id='" + my_branch_id + "' ";
        List<Branch_server_uploads.to_branch_local_uploads> datas2 = Branch_server_uploads.ret_data(where);
        System.out.println(datas2.size());

        for (Branch_server_uploads.to_branch_local_uploads to : datas2) {
            System.out.println("Date of Update: " + to.date_added);
            System.out.println("***************************************************");
            String replenishments = FileToString(to.replenishments);
            String inventory_counts = FileToString(to.inventory_counts);
            String adjustments = FileToString(to.adjustments);
            String stock_transfers = FileToString(to.stock_transfers);
            String receipts = FileToString(to.receipts);
            String sales = FileToString(to.sales);
            String returned_items = FileToString(to.returned_items);
            String charged_items = FileToString(to.charged_items);
            String rmas = FileToString(to.rmas);
            String item_maintenances = FileToString(to.item_maintenances);
            String cash_drawers = FileToString(to.cash_drawers);
            l_replenishments.addAll(Parse_inventory_replenishments.decompress(replenishments));
            l_inventory_counts.addAll(Parse_inventory_counts.decompress(inventory_counts));
            l_adjustments.addAll(Parse_inventory_adjustments.decompress(adjustments));
            l_stock_transfers.addAll(Parse_stock_transfers.decompress(stock_transfers));
            l_receipts.addAll(Parse_receipts.decompress(receipts));
            l_sales.addAll(Parse_sales.decompress(sales));
            l_returned_items.addAll(Parse_sale_item_replacements.decompress(returned_items));
            l_charged_items.addAll(Parse_charged_items.decompress(charged_items));
            l_rmas.addAll(new ArrayList());
            l_item_maintenances.addAll(new ArrayList());
            l_cash_drawers.addAll(Parse_cash_drawers.decompress(cash_drawers));
            System.out.println("***************************************************");
        }

        List<Dlg_branch_local_downloads.to_local_uploads> datas = new ArrayList();
        Dlg_branch_local_downloads.to_local_uploads to1 = new Dlg_branch_local_downloads.to_local_uploads(1, "Replenishments", l_replenishments.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to2 = new Dlg_branch_local_downloads.to_local_uploads(2, "Inventory Counts", l_inventory_counts.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to3 = new Dlg_branch_local_downloads.to_local_uploads(3, "Adjustments", l_adjustments.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to4 = new Dlg_branch_local_downloads.to_local_uploads(4, "Stock Transfers", l_stock_transfers.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to5 = new Dlg_branch_local_downloads.to_local_uploads(5, "Receipts", l_receipts.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to6 = new Dlg_branch_local_downloads.to_local_uploads(6, "Sales", l_sales.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to7 = new Dlg_branch_local_downloads.to_local_uploads(7, "Returned Items", l_returned_items.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to8 = new Dlg_branch_local_downloads.to_local_uploads(8, "Charged Items", l_charged_items.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to9 = new Dlg_branch_local_downloads.to_local_uploads(9, "Rmas", l_rmas.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to10 = new Dlg_branch_local_downloads.to_local_uploads(10, "Item Maintenances", l_item_maintenances.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to11 = new Dlg_branch_local_downloads.to_local_uploads(11, "Cash Drawers", l_cash_drawers.size(), 0);

        Grab_branches_updates.replenishments(l_replenishments);
        Grab_branches_updates.inventory_count(l_inventory_counts);
        Grab_branches_updates.adjustments(l_adjustments);
        Grab_branches_updates.stock_transfers(l_stock_transfers);
        Grab_branches_updates.receipts();
        Grab_branches_updates.sales(l_sales);
        Grab_branches_updates.returned_items(l_returned_items);
        Grab_branches_updates.charge_in_advance(l_charged_items);
        Grab_branches_updates.cash_drawers(l_cash_drawers);

        Grab_branches_updates.update_status2(datas2);

        l_replenishments.clear();
        l_inventory_counts.clear();
        l_adjustments.clear();
        l_stock_transfers.clear();
        l_sales.clear();
        l_returned_items.clear();
        l_charged_items.clear();
        l_cash_drawers.clear();

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        //</editor-fold>
    }

    List<Parse_inventory_replenishments> l_replenishments = new ArrayList();
    List<Parse_inventory_counts.field> l_inventory_counts = new ArrayList();
    List<Parse_inventory_adjustments.field> l_adjustments = new ArrayList();
    List<Parse_stock_transfers> l_stock_transfers = new ArrayList();
    List<Parse_receipts> l_receipts = new ArrayList();
    List<Parse_sales.field> l_sales = new ArrayList();
    List<Parse_sale_item_replacements> l_returned_items = new ArrayList();
    List<Parse_charged_items> l_charged_items = new ArrayList();
    List<String> l_rmas = new ArrayList();
    List<String> l_item_maintenances = new ArrayList();
    List<Parse_cash_drawers> l_cash_drawers = new ArrayList();

    private void start_synching_main_branch_server() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
            }
        });

        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                start_synching_main_branch_server_download();

                start_synching_main_branch_server_upload();
            }
        });
        t.start();
    }

    List<Branch_server_uploads.to_branch_local_uploads> to_server_upload = new ArrayList();

    private void start_synching_main_branch_server_download() {
        //<editor-fold defaultstate="collapsed" desc=" Download ">
        String where = " where status=0  ";
        List<Branch_local_uploads.to_branch_local_uploads> datas2 = Branch_local_uploads.ret_data(where);
        System.out.println(datas2.size());

        for (Branch_local_uploads.to_branch_local_uploads to : datas2) {
            System.out.println("Date of Update: " + to.date_added);
            System.out.println("***************************************************");
            String replenishments = FileToString(to.replenishments);
            String inventory_counts = FileToString(to.inventory_counts);
            String adjustments = FileToString(to.adjustments);
            String stock_transfers = FileToString(to.stock_transfers);
            String receipts = FileToString(to.receipts);
            String sales = FileToString(to.sales);
            String returned_items = FileToString(to.returned_items);
            String charged_items = FileToString(to.charged_items);
            String rmas = FileToString(to.rmas);
            String item_maintenances = FileToString(to.item_maintenances);
            String cash_drawers = FileToString(to.cash_drawers);
            l_replenishments.addAll(Parse_inventory_replenishments.decompress(replenishments));
            l_inventory_counts.addAll(Parse_inventory_counts.decompress(inventory_counts));
            l_adjustments.addAll(Parse_inventory_adjustments.decompress(adjustments));
            l_stock_transfers.addAll(Parse_stock_transfers.decompress(stock_transfers));
            l_receipts.addAll(Parse_receipts.decompress(receipts));
            l_sales.addAll(Parse_sales.decompress(sales));
            l_returned_items.addAll(Parse_sale_item_replacements.decompress(returned_items));
            l_charged_items.addAll(Parse_charged_items.decompress(charged_items));
            l_rmas.addAll(new ArrayList());
            l_item_maintenances.addAll(new ArrayList());
            l_cash_drawers.addAll(Parse_cash_drawers.decompress(cash_drawers));
            System.out.println("***************************************************");
        }

        List<Dlg_branch_local_downloads.to_local_uploads> datas = new ArrayList();
        Dlg_branch_local_downloads.to_local_uploads to1 = new Dlg_branch_local_downloads.to_local_uploads(1, "Replenishments", l_replenishments.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to2 = new Dlg_branch_local_downloads.to_local_uploads(2, "Inventory Counts", l_inventory_counts.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to3 = new Dlg_branch_local_downloads.to_local_uploads(3, "Adjustments", l_adjustments.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to4 = new Dlg_branch_local_downloads.to_local_uploads(4, "Stock Transfers", l_stock_transfers.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to5 = new Dlg_branch_local_downloads.to_local_uploads(5, "Receipts", l_receipts.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to6 = new Dlg_branch_local_downloads.to_local_uploads(6, "Sales", l_sales.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to7 = new Dlg_branch_local_downloads.to_local_uploads(7, "Returned Items", l_returned_items.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to8 = new Dlg_branch_local_downloads.to_local_uploads(8, "Charged Items", l_charged_items.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to9 = new Dlg_branch_local_downloads.to_local_uploads(9, "Rmas", l_rmas.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to10 = new Dlg_branch_local_downloads.to_local_uploads(10, "Item Maintenances", l_item_maintenances.size(), 0);
        Dlg_branch_local_downloads.to_local_uploads to11 = new Dlg_branch_local_downloads.to_local_uploads(11, "Cash Drawers", l_cash_drawers.size(), 0);

        Grab_branches_updates.replenishments(l_replenishments);
        Grab_branches_updates.inventory_count(l_inventory_counts);
        Grab_branches_updates.adjustments(l_adjustments);
        Grab_branches_updates.stock_transfers(l_stock_transfers);
        Grab_branches_updates.receipts();
        Grab_branches_updates.sales(l_sales);
        Grab_branches_updates.returned_items(l_returned_items);
        Grab_branches_updates.charge_in_advance(l_charged_items);
        Grab_branches_updates.cash_drawers(l_cash_drawers);

        Grab_branches_updates.update_status(datas2);

        l_replenishments.clear();
        l_inventory_counts.clear();
        l_adjustments.clear();
        l_stock_transfers.clear();
        l_sales.clear();
        l_returned_items.clear();
        l_charged_items.clear();
        l_cash_drawers.clear();

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        //</editor-fold>
    }

    private void start_synching_main_branch_server_upload() {
        //<editor-fold defaultstate="collapsed" desc=" Upload ">
        String where3 = " where branch_id='" + my_branch_id + "' order by id desc limit 1";
        List<Branch_server_uploads.to_branch_local_uploads> last_upload = Branch_server_uploads.ret_data(where3);
        String date_from = "";

        for (Branch_server_uploads.to_branch_local_uploads to : last_upload) {
            try {
                Date d = synsoftech.util.DateType.datetime.parse(to.date_added);
                date_from = synsoftech.util.DateType.sf.format(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_branch_local_uploads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String now = synsoftech.util.DateType.sf.format(new Date());
        System.out.println("Last Cloud upload date: " + date_from);
        System.out.println("Todays date: " + now);

        if (date_from.equals(now)) {
            System.out.println("Nothing to Upload!");
            jXLabel1.setText("Nothing to Upload!");
            return;
        }
        jXLabel1.setText("Connected to Cloud!");
        System.out.println("Connected to Cloud!");
        if (!date_from.isEmpty()) {
            String path = System.getProperty("user.home");
            List<String> days = Branch_local_uploads.getDates(date_from);
            int i = 1;
            for (String s : days) {

                String where = " where Date(date_added)='" + s + "' and to_branch_id<> '" + my_branch_id + "' ";
                Branch_local_uploads.to_upload_count zero = new Branch_local_uploads.to_upload_count("", 0, 0);
                Branch_local_uploads.to_upload_count replenishments = zero;
                Branch_local_uploads.to_upload_count inventory_counts = zero;
                Branch_local_uploads.to_upload_count adjustments = zero;
                Branch_local_uploads.to_upload_count stock_transfers = Parse_stock_transfers.compress(where);
                String receipts = "";
                Branch_local_uploads.to_upload_count sales = zero;
                Branch_local_uploads.to_upload_count returned_items = zero;
                Branch_local_uploads.to_upload_count charged_items = zero;
                String rmas = "";
                String item_maintenances = "";
                Branch_local_uploads.to_upload_count cash_drawers = zero;

                String name = POS.util.DateType.y.format(new Date()) + "" + POS.util.DateType.d.format(new Date()) + "" + POS.util.DateType.m1.format(new Date());

                File file_replenishments = new File(path + "\\cloud_uploads\\" + "file_replenishments" + s + ".txt");
                File file_inventory_counts = new File(path + "\\cloud_uploads\\" + "inventory_counts" + s + ".txt");
                File file_adjustments = new File(path + "\\cloud_uploads\\" + "file_adjustments" + s + ".txt");
                File file_stock_transfers = new File(path + "\\cloud_uploads\\" + "file_stock_transfers" + s + ".txt");
                File file_receipts = new File(path + "\\cloud_uploads\\" + "file_receipts" + s + ".txt");
                File file_sales = new File(path + "\\cloud_uploads\\" + "file_sales" + s + ".txt");
                File file_returned_items = new File(path + "\\cloud_uploads\\" + "file_returned_items" + s + ".txt");
                File file_charged_items = new File(path + "\\cloud_uploads\\" + "charged_items" + s + ".txt");
                File file_rmas = new File(path + "\\cloud_uploads\\" + "file_rmas" + s + ".txt");
                File file_item_maintenances = new File(path + "\\cloud_uploads\\" + "file_item_maintenances" + s + ".txt");
                File file_cash_drawers = new File(path + "\\cloud_uploads\\" + "file_cash_drawers" + s + ".txt");

                FileWriter fw_replenishments;
                FileWriter fw_inventory_counts;
                FileWriter fw_adjustments;
                FileWriter fw_stock_transfers;
                FileWriter fw_receipts;
                FileWriter fw_sales;
                FileWriter fw_returned_items;
                FileWriter fw_charged_items;
                FileWriter fw_rmas;
                FileWriter fw_item_maintenances;
                FileWriter fw_cash_drawers;
                try {
                    fw_replenishments = new FileWriter(file_replenishments.getAbsoluteFile());
                    BufferedWriter bw_replenishments = new BufferedWriter(fw_replenishments);
                    bw_replenishments.write(replenishments.stmt);

                    bw_replenishments.close();
                    fw_replenishments.close();

                    fw_inventory_counts = new FileWriter(file_inventory_counts.getAbsoluteFile());
                    BufferedWriter bw_inventory_counts = new BufferedWriter(fw_inventory_counts);
                    bw_inventory_counts.write(inventory_counts.stmt);

                    bw_inventory_counts.close();
                    fw_inventory_counts.close();

                    fw_adjustments = new FileWriter(file_adjustments.getAbsoluteFile());
                    BufferedWriter bw_adjustments = new BufferedWriter(fw_adjustments);
                    bw_adjustments.write(adjustments.stmt);

                    bw_adjustments.close();
                    fw_adjustments.close();

                    fw_stock_transfers = new FileWriter(file_stock_transfers.getAbsoluteFile());
                    BufferedWriter bw_stock_transfers = new BufferedWriter(fw_stock_transfers);
                    bw_stock_transfers.write(stock_transfers.stmt);

                    bw_stock_transfers.close();
                    fw_stock_transfers.close();

                    fw_receipts = new FileWriter(file_receipts.getAbsoluteFile());
                    BufferedWriter bw_receipts = new BufferedWriter(fw_receipts);
                    bw_receipts.write(receipts);

                    bw_receipts.close();
                    fw_receipts.close();

                    fw_sales = new FileWriter(file_sales.getAbsoluteFile());
                    BufferedWriter bw_sales = new BufferedWriter(fw_sales);
                    bw_sales.write(sales.stmt);

                    bw_sales.close();
                    fw_sales.close();

                    fw_returned_items = new FileWriter(file_returned_items.getAbsoluteFile());
                    BufferedWriter bw_returned_items = new BufferedWriter(fw_returned_items);
                    bw_returned_items.write(returned_items.stmt);

                    bw_returned_items.close();
                    fw_returned_items.close();

                    fw_charged_items = new FileWriter(file_charged_items.getAbsoluteFile());
                    BufferedWriter bw_charged_items = new BufferedWriter(fw_charged_items);
                    bw_charged_items.write(charged_items.stmt);

                    bw_charged_items.close();
                    fw_charged_items.close();

                    fw_rmas = new FileWriter(file_rmas.getAbsoluteFile());
                    BufferedWriter bw_rmas = new BufferedWriter(fw_rmas);
                    bw_rmas.write(rmas);

                    bw_rmas.close();
                    fw_rmas.close();

                    fw_item_maintenances = new FileWriter(file_item_maintenances.getAbsoluteFile());
                    BufferedWriter bw_item_maintenances = new BufferedWriter(fw_item_maintenances);
                    bw_item_maintenances.write(item_maintenances);

                    bw_item_maintenances.close();
                    fw_item_maintenances.close();

                    fw_cash_drawers = new FileWriter(file_cash_drawers.getAbsoluteFile());
                    BufferedWriter bw_cash_drawers = new BufferedWriter(fw_cash_drawers);
                    bw_cash_drawers.write(cash_drawers.stmt);

                    bw_cash_drawers.close();
                    fw_cash_drawers.close();

                } catch (IOException ex) {
                    Logger.getLogger(Parse_sales.class.getName()).log(Level.SEVERE, null, ex);
                }

                int id = 0;
                int status = 0;
                String date_added = s + " 00:00:00";
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_id();
                String branch = my_branch;
                String branch_id = my_branch_id;
                String location = my_location;
                String location_id = my_location_id;
                Branch_server_uploads.to_branch_local_uploads upload = new Branch_server_uploads.to_branch_local_uploads(id, file_replenishments, file_inventory_counts, file_adjustments, file_stock_transfers, file_receipts, file_sales, file_returned_items, file_charged_items, file_rmas, file_item_maintenances, file_cash_drawers, status, date_added, user_id, user_screen_name, branch, branch_id, location, location_id);
                to_server_upload.add(upload);
                System.out.println("************************************************");
                i++;
            }

        }

        Branch_server_uploads.add_data(to_server_upload);
        File file = new File(System.getProperty("user.home") + "\\uploads\\");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (String myFile1 : myFiles) {
                File myFile = new File(file, myFile1);
                myFile.delete();
            }
        }
        to_server_upload.clear();
        System.out.println("Upload Successfull!");
        jXLabel1.setText("Upload Successfull!");

        jButton2.setEnabled(true);
        jButton1.setEnabled(false);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        //</editor-fold>
    }

}
