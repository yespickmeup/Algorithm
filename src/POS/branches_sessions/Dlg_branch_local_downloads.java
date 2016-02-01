/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches_sessions;

import static POS.branches_sessions.Check_cloud_local_uploads.FileToString;
import POS.util.Alert;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Guinness
 */
public class Dlg_branch_local_downloads extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_branch_local_downloads
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
    private Dlg_branch_local_downloads(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_branch_local_downloads(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_branch_local_downloads() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_branch_local_downloads myRef;

    private void setThisRef(Dlg_branch_local_downloads myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_branch_local_downloads> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_branch_local_downloads create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_branch_local_downloads create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_branch_local_downloads dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_local_downloads((java.awt.Frame) parent, false);
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
            Dlg_branch_local_downloads dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_local_downloads((java.awt.Dialog) parent, false);
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

        Dlg_branch_local_downloads dialog = Dlg_branch_local_downloads.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_local_uploads = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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

        jButton1.setText("Search for Branch Uploads");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Status:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jButton2.setText("Install Updates ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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
        ret_data();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        install_updates();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_local_uploads;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_local_uploads(tbl_local_uploads);

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

    public static void loadData_local_uploads(List<to_local_uploads> acc) {
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
            if (column == 100) {
                return true;
            }
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
            to_local_uploads tt = (to_local_uploads) getRow(row);
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

    private void ret_data() {

        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String where = " where status=0 and Date(date_added)='" + "2017-01-04" + "' ";
                List<Branch_local_uploads.to_branch_local_uploads> datas2 = Branch_local_uploads.ret_data(where);
                System.out.println(datas2.size());

                for (Branch_local_uploads.to_branch_local_uploads to : datas2) {
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

                List<to_local_uploads> datas = new ArrayList();
                to_local_uploads to1 = new to_local_uploads(1, "Replenishments", l_replenishments.size(), 0);
                to_local_uploads to2 = new to_local_uploads(2, "Inventory Counts", l_inventory_counts.size(), 0);
                to_local_uploads to3 = new to_local_uploads(3, "Adjustments", l_adjustments.size(), 0);
                to_local_uploads to4 = new to_local_uploads(4, "Stock Transfers", l_stock_transfers.size(), 0);
                to_local_uploads to5 = new to_local_uploads(5, "Receipts", l_receipts.size(), 0);
                to_local_uploads to6 = new to_local_uploads(6, "Sales", l_sales.size(), 0);
                to_local_uploads to7 = new to_local_uploads(7, "Returned Items", l_returned_items.size(), 0);
                to_local_uploads to8 = new to_local_uploads(8, "Charged Items", l_charged_items.size(), 0);
                to_local_uploads to9 = new to_local_uploads(9, "Rmas", l_rmas.size(), 0);
                to_local_uploads to10 = new to_local_uploads(10, "Item Maintenances", l_item_maintenances.size(), 0);
                to_local_uploads to11 = new to_local_uploads(11, "Cash Drawers", l_cash_drawers.size(), 0);
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

                jButton1.setEnabled(true);
                jButton2.setEnabled(true);
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }

    private void install_updates() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Grab_branches_updates.install_updates(l_replenishments, l_inventory_counts, l_adjustments, l_stock_transfers);
                l_replenishments.clear();
                l_inventory_counts.clear();
                l_adjustments.clear();

                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
                jButton1.setEnabled(true);
                jButton2.setEnabled(true);
                Alert.set(2, "");
            }
        });
        t.start();

    }
}
