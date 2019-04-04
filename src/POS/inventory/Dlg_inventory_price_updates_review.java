/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.util.Alert;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_inventory_price_updates_review extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_inventory_price_updates_finalized
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

        public final List<Inventory_price_updates.to_inventory_price_updates> datas;

        public OutputData(List<Inventory_price_updates.to_inventory_price_updates> datas) {
            this.datas = datas;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_inventory_price_updates_review(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_inventory_price_updates_review(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_inventory_price_updates_review() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_inventory_price_updates_review myRef;

    private void setThisRef(Dlg_inventory_price_updates_review myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory_price_updates_review> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory_price_updates_review create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory_price_updates_review create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory_price_updates_review dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_price_updates_review((java.awt.Frame) parent, false);
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
            Dlg_inventory_price_updates_review dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_price_updates_review((java.awt.Dialog) parent, false);
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

        Dlg_inventory_price_updates_review dialog = Dlg_inventory_price_updates_review.create(new javax.swing.JFrame(), true);
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
        tbl_inventory_price_updates = new javax.swing.JTable();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_inventory_price_updates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_inventory_price_updates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventory_price_updatesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_inventory_price_updates);

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total no. of rows:");

        jLabel2.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Review Price Updates Requests");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap())
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_inventory_price_updatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory_price_updatesMouseClicked
        select_items();
    }//GEN-LAST:event_tbl_inventory_price_updatesMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_inventory_price_updates;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_inventory_price_updates(tbl_inventory_price_updates);
    }

    public void do_pass(List<Inventory_price_updates.to_inventory_price_updates> datas) {
        loadData_inventory_price_updates(datas);
        jLabel2.setText("" + size());
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

    //<editor-fold defaultstate="collapsed" desc=" inventory_price_updates "> 
    public static ArrayListModel tbl_inventory_price_updates_ALM;
    public static Tblinventory_price_updatesModel tbl_inventory_price_updates_M;

    public static void init_tbl_inventory_price_updates(JTable tbl_inventory_price_updates) {
        tbl_inventory_price_updates_ALM = new ArrayListModel();
        tbl_inventory_price_updates_M = new Tblinventory_price_updatesModel(tbl_inventory_price_updates_ALM);
        tbl_inventory_price_updates.setModel(tbl_inventory_price_updates_M);
        tbl_inventory_price_updates.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_price_updates.setRowHeight(25);
        int[] tbl_widths_inventory_price_updates = {90, 80, 100, 100, 80, 80, 80, 70, 70, 30, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_price_updates.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inventory_price_updates, i, tbl_widths_inventory_price_updates[i]);
        }
        Dimension d = tbl_inventory_price_updates.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_inventory_price_updates.getTableHeader().setPreferredSize(d);
        tbl_inventory_price_updates.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_inventory_price_updates.setRowHeight(25);
        tbl_inventory_price_updates.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_inventory_price_updates, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_inventory_price_updates, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_inventory_price_updates, 6);
        tbl_inventory_price_updates.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_inventory_price_updates(List<Inventory_price_updates.to_inventory_price_updates> acc) {
        tbl_inventory_price_updates_ALM.clear();
        tbl_inventory_price_updates_ALM.addAll(acc);
    }

    public static class Tblinventory_price_updatesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Item Code", "Barcode", "Description", "Old Price", "Main Price", "New Price", "User", "Status", "", "date_added", "user_id", "user_screen_name", "branch", "branch_id", "location", "location_id"
        };

        public Tblinventory_price_updatesModel(ListModel listmodel) {
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
            Inventory_price_updates.to_inventory_price_updates tt = (Inventory_price_updates.to_inventory_price_updates) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.ipu_no;
                case 1:
                    return " " + tt.item_code;
                case 2:
                    return " " + tt.barcode;
                case 3:
                    return " " + tt.description;
                case 4:
                    return FitIn.fmt_wc_0(tt.old_selling_price) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.main_price) + " ";

                case 6:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 7:
                    return " " + tt.user_screen_name;
                case 8:
                    return " Checked";
                case 9:
                    if (tt.is_uploaded == 0) {
                        return "/POS/icons4/cloud-storage-uploading-option (3).png";
                    } else if (tt.is_uploaded == 2) {
                        return "/POS/icons4/cloud-storage-uploading-option (4).png";
                    } else if (tt.is_uploaded == 3) {
                        return "/POS/icons4/cloud-storage-uploading-option (6)";
                    } else if (tt.is_uploaded == 4) {
                        return "/POS/icons4/cloud-storage-uploading-option (5).png";
                    } else {
                        return "/POS/icons4/cloud-storage-uploading-option (2).png";
                    }
                case 10:
                    return tt.user_screen_name;
                case 11:
                    return tt.branch;
                case 12:
                    return tt.branch_id;
                case 13:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ok() {
        List<Inventory_price_updates.to_inventory_price_updates> datas = tbl_inventory_price_updates_ALM;
        if (datas.isEmpty()) {
            Alert.set(0, "Nothing to update!");
            return;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(datas));
        }
    }

    private void select_items() {
        int row = tbl_inventory_price_updates.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Inventory_price_updates.to_inventory_price_updates to = (Inventory_price_updates.to_inventory_price_updates) tbl_inventory_price_updates_ALM.get(row);
        int col = tbl_inventory_price_updates.getSelectedColumn();
        if (col == 5) {
            Window p = (Window) this;
            Dlg_update_pricing_enter_price nd = Dlg_update_pricing_enter_price.create(p, true);
            nd.setTitle("");
            nd.do_pass2(to);
            nd.setCallback(new Dlg_update_pricing_enter_price.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_update_pricing_enter_price.OutputData data) {
                    closeDialog.ok();

                    to.setConversion(data.conversion);
                    to.setUnit(data.unit);
                    to.setSelling_price(data.price);
                    tbl_inventory_price_updates_M.fireTableDataChanged();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
}
