/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;


import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.MyConnection;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.util.DateType;


/**
 *
 * @author Guinness
 */
public class Dlg_branch_local_uploads extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_local_uploads
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
    private Dlg_branch_local_uploads(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_branch_local_uploads(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_branch_local_uploads() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_branch_local_uploads myRef;

    private void setThisRef(Dlg_branch_local_uploads myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_branch_local_uploads> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_branch_local_uploads create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_branch_local_uploads create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_branch_local_uploads dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_local_uploads((java.awt.Frame) parent, false);
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
            Dlg_branch_local_uploads dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_local_uploads((java.awt.Dialog) parent, false);
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

        Dlg_branch_local_uploads dialog = Dlg_branch_local_uploads.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_local_uploads = new javax.swing.JTable();
        jButton3 = new Button.Default();
        jButton1 = new Button.Success();
        jLabel22 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton2 = new Button.Primary();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/synch_locations/servers1.png"))); // NOI18N
        jLabel23.setText("Upload Data to Cloud");

        tbl_local_uploads.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_local_uploads);

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Upload");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel22.setText("Status:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(51, 153, 0));
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jButton2.setText("Check Cloud Server Connection");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        upload();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        check_connection();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_local_uploads;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();

        init_tbl_local_uploads(tbl_local_uploads);
        set_default_branch();
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

    public static class to_local_uploads {

        public final int id;
        public final String module;
        public final int no;
        public final int status;

        public to_local_uploads(int id, String module, int no, int status) {
            this.id = id;
            this.module = module;
            this.no = no;
            this.status = status;
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" local_uploads "> 
    public static ArrayListModel tbl_local_uploads_ALM;
    public static Tbllocal_uploadsModel tbl_local_uploads_M;

    public static void init_tbl_local_uploads(JTable tbl_local_uploads) {
        tbl_local_uploads_ALM = new ArrayListModel();
        tbl_local_uploads_M = new Tbllocal_uploadsModel(tbl_local_uploads_ALM);
        tbl_local_uploads.setModel(tbl_local_uploads_M);
        tbl_local_uploads.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_local_uploads.setRowHeight(25);
        int[] tbl_widths_local_uploads = {30, 100, 100, 60};
        for (int i = 0, n = tbl_widths_local_uploads.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_local_uploads, i, tbl_widths_local_uploads[i]);
        }
        Dimension d = tbl_local_uploads.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_local_uploads.getTableHeader().setPreferredSize(d);
        tbl_local_uploads.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_local_uploads.setRowHeight(25);
        tbl_local_uploads.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_local_uploads(List<Dlg_branch_local_uploads.to_local_uploads> acc) {
        tbl_local_uploads_ALM.clear();
        tbl_local_uploads_ALM.addAll(acc);
    }

    public static class Tbllocal_uploadsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "No", "Module", "Transactions", "Status"
        };

        public Tbllocal_uploadsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Dlg_branch_local_uploads.to_local_uploads tt = (Dlg_branch_local_uploads.to_local_uploads) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.id;
                case 1:
                    return " " + tt.module;
                case 2:
                    return " " + tt.no;
                default:
                    if (tt.status == 0) {
                        return " Ready";
                    } else if (tt.status == 1) {
                        return " Installing...";
                    } else {
                        return " Installed...";
                    }

            }
        }
    }

//</editor-fold> 
    private void data_cols() {

    }

    private void check_connection() {

        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        jButton2.setEnabled(false);
        jButton1.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int connected = MyConnection.check_cloud_connection();
                if (connected == 0) {
                    jLabel2.setText("Connection Failed!");
                    jLabel2.setForeground(new java.awt.Color(204, 0, 51));
                    return;
                }

                String where3 = " where branch_id='" + my_branch_id + "' order by id desc limit 1";
                List<Branch_local_uploads.to_branch_local_uploads> last_upload = Branch_local_uploads.ret_data(where3);
                String date_from = "";

                for (Branch_local_uploads.to_branch_local_uploads to : last_upload) {
                    try {
                        Date d = DateType.datetime.parse(to.date_added);
                        date_from = DateType.sf.format(d);
                    } catch (ParseException ex) {
                        Logger.getLogger(Dlg_branch_local_uploads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                date_from = "2017-01-03";
                String now = DateType.sf.format(new Date());
                System.out.println("Last Cloud upload date: " + date_from);
                System.out.println("Todays date: " + now);
                if (date_from.equals(now)) {
                    Alert.set(0, "Nothing to Upload at the moment!");
                    return;
                }
                jLabel2.setText("Connected to Cloud!");
                jLabel2.setForeground(new java.awt.Color(0, 102, 255));
                if (!date_from.isEmpty()) {
                    String path = System.getProperty("user.home");

                    List<String> days = Branch_local_uploads.getDates(date_from,1);
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

                List<Dlg_branch_local_uploads.to_local_uploads> datas = new ArrayList();
                Dlg_branch_local_uploads.to_local_uploads to1 = new Dlg_branch_local_uploads.to_local_uploads(1, "Replenishments", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to2 = new Dlg_branch_local_uploads.to_local_uploads(2, "Inventory Counts", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to3 = new Dlg_branch_local_uploads.to_local_uploads(3, "Adjustments", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to4 = new Dlg_branch_local_uploads.to_local_uploads(4, "Stock Transfers", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to5 = new Dlg_branch_local_uploads.to_local_uploads(5, "Receipts", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to6 = new Dlg_branch_local_uploads.to_local_uploads(6, "Sales", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to7 = new Dlg_branch_local_uploads.to_local_uploads(7, "Returned Items", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to8 = new Dlg_branch_local_uploads.to_local_uploads(8, "Charged Items", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to9 = new Dlg_branch_local_uploads.to_local_uploads(9, "Rmas", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to10 = new Dlg_branch_local_uploads.to_local_uploads(10, "Item Maintenances", 0, 0);
                Dlg_branch_local_uploads.to_local_uploads to11 = new Dlg_branch_local_uploads.to_local_uploads(11, "Cash Drawers", 0, 0);
                datas.add(to1);
                datas.add(to2);
                datas.add(to3);
                datas.add(to4);
                datas.add(to5);
                datas.add(to6);
                datas.add(to7);
                datas.add(to8);
                datas.add(to9);
                datas.add(to10);
                datas.add(to11);

                loadData_local_uploads(datas);

                jLabel2.setText("Connected to Cloud!");
                jLabel2.setForeground(new java.awt.Color(0, 102, 255));

                jButton2.setEnabled(true);
                jButton1.setEnabled(true);
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }

    List<Branch_local_uploads.to_branch_local_uploads> to_upload = new ArrayList();

    private void upload() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        jButton2.setEnabled(false);
        jButton1.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                int connected = MyConnection.check_cloud_connection();
                if (connected == 0) {
                    jLabel2.setText("Connection Failed!");
                    jLabel2.setForeground(new java.awt.Color(204, 0, 51));
                    return;
                }
                jLabel2.setText("Connected to Cloud!");
                jLabel2.setForeground(new java.awt.Color(0, 102, 255));

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
                Alert.set(0, "Upload Successful!");

                jButton2.setEnabled(true);
                jButton1.setEnabled(false);
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    private static void fw(File file, String stmts) {
        FileWriter fw_replenishments;
        try {
            fw_replenishments = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw_replenishments);
            bw.write(stmts);
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Parse_sales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
