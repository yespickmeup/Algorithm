/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.inventory.S1_items2;
import POS.receipts.S1_receipt_barcodes.to_receipt_barcodes;
import POS.receipts.S1_serial_nos.to_receipt_serial_nos;
import POS.util.Alert;
import POS.util.Focus_Fire;
import POS.util.SplitString;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;

/**
 *
 * @author Maytopacka
 */
public class Dlg_qty_cost extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cashin
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

        public final double amount;
        public final double cost;
        public final String barcodes;
        public final String serial_nos;

        public OutputData(double amount, double cost, String barcodes, String serial_nos) {
            this.amount = amount;
            this.cost = cost;
            this.barcodes = barcodes;
            this.serial_nos = serial_nos;
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_qty_cost(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_qty_cost(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_qty_cost() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_qty_cost myRef;

    private void setThisRef(Dlg_qty_cost myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_qty_cost> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_qty_cost create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_qty_cost create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_qty_cost dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_qty_cost((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_qty_cost dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_qty_cost((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_qty_cost dialog = Dlg_qty_cost.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
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

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbl_item_code = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_desc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_cost = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lbl_qty = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipt_barcodes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        tf_serial_no = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_receipt_serial_nos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Item Code:");

        lbl_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_item_code.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Description:");

        lbl_desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_desc.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Qty:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cost:");

        tf_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Qty:");

        lbl_qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_qty.setFocusable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Serial #:");

        jButton1.setText("OK (Ctrl)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_receipt_barcodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "BARCODE"
            }
        ));
        jScrollPane1.setViewportView(tbl_receipt_barcodes);

        jLabel3.setText("BARCODE:");

        tf_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_barcodeActionPerformed(evt);
            }
        });

        tf_serial_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_serial_noActionPerformed(evt);
            }
        });

        tbl_receipt_serial_nos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "BARCODE"
            }
        ));
        jScrollPane2.setViewportView(tbl_receipt_serial_nos);

        jLabel4.setText("SERIAL NO.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_barcode))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_serial_no)
                        .addGap(81, 81, 81))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_serial_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel1.setText("No:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(lbl_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_barcodeActionPerformed
        // TODO add your handling code here:
        update_barcode();
    }//GEN-LAST:event_tf_barcodeActionPerformed

    private void tf_serial_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_serial_noActionPerformed
        // TODO add your handling code here:
        add_serial_no();
    }//GEN-LAST:event_tf_serial_noActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        count_serial(evt);
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        tf_cost.grabFocus();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
        jTextArea1.grabFocus();
    }//GEN-LAST:event_tf_costActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField lbl_desc;
    private javax.swing.JTextField lbl_item_code;
    private javax.swing.JTextField lbl_qty;
    private javax.swing.JTable tbl_receipt_barcodes;
    private javax.swing.JTable tbl_receipt_serial_nos;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_serial_no;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        focus();
        init_tbl_receipt_barcodes();
        init_tbl_receipt_serial_nos();
        jLabel3.setVisible(false);
        tf_barcode.setVisible(false);
        jScrollPane1.setVisible(false);
        jPanel3.setVisible(false);
    }

    private void focus() {
        JTextField[] tf = {tf_amount, tf_cost, tf_serial_no};
        JTextArea[] tf2 = {jTextArea1};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        Focus_Fire.onFocus_lostFocus(tf2);
        Focus_Fire.select_all(tf2);
    }
    String barcode = "";
    String barcodes1 = "";

    public void do_pass(double qty, double cost, String desc, String unit, String barcode1, String barcodes, String selected_barcode, String serials, double product_qty, String my_barcode) {
        lbl_qty.setText(FitIn.fmt_woc(product_qty));
        lbl_item_code.setText(my_barcode);
        tf_amount.setText(FitIn.fmt_woc(qty));
        tf_cost.setText(FitIn.fmt_wc_0(cost));
        lbl_desc.setText(desc);
        jTextArea1.setText(serials);
        tf_amount.grabFocus();
        tf_amount.selectAll();
        barcode = barcode1;
        tf_barcode.setText(selected_barcode);
        List<to_receipt_barcodes> datas = new ArrayList();
        List<String> codes = SplitString.split(barcodes);
        for (String s : codes) {
            to_receipt_barcodes to = new to_receipt_barcodes(0, barcode1, s);
            datas.add(to);
        }
        loadData_receipt_barcodes(datas);

        List<String> ser = SplitString.split(serials);
        List<to_receipt_serial_nos> data = new ArrayList();
        for (String s : ser) {
            to_receipt_serial_nos to = new to_receipt_serial_nos(0, s);
            data.add(to);
        }
        loadData_receipt_serial_nos(data);
    }

    public void do_pass2(double qty, double cost, String desc, String unit, String barcode1, String barcodes, double product_qty, String my_barcode) {
        lbl_qty.setText(FitIn.fmt_woc(product_qty));
        lbl_item_code.setText(my_barcode);
        List<to_receipt_barcodes> datas = new ArrayList();
        List<String> codes = SplitString.split(barcodes);
        for (String s : codes) {
            to_receipt_barcodes to = new to_receipt_barcodes(0, barcode1, s);
            datas.add(to);
        }
        loadData_receipt_barcodes(datas);
        if (qty != 0) {
            tf_amount.setText(FitIn.fmt_wc_0(qty));
        }
        tf_cost.setText(FitIn.fmt_wc_0(cost));
        lbl_desc.setText(desc);
//        lbl_unit.setText(unit);
        tf_amount.grabFocus();
        tf_amount.selectAll();
        barcode = barcode1;
        barcodes1 = barcodes;
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
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_CONTROL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ok1();
            }
        });
        tf_barcode.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_receipt_barcodes_ALM.isEmpty()) {
                        tbl_receipt_barcodes.setRowSelectionInterval(0, 0);
                        tbl_receipt_barcodes.grabFocus();
                    }
                }

            }
        });
        tbl_receipt_barcodes.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = tbl_receipt_barcodes.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    to_receipt_barcodes to = (to_receipt_barcodes) tbl_receipt_barcodes_ALM.
                            get(tbl_receipt_barcodes.convertRowIndexToModel(row));
                    tf_barcode.setText(to.barcode);
                    tf_amount.grabFocus();
                    e.consume();
                }

            }
        });
        tf_serial_no.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_receipt_serial_nos_ALM.isEmpty()) {
                        tbl_receipt_serial_nos.setRowSelectionInterval(0, 0);
                        tbl_receipt_serial_nos.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });
        tbl_receipt_serial_nos.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    delete_serial_no();
                    e.consume();
                }

            }
        });
        tf_cost.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });
        tf_cost.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });

        tf_amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_receipt_barcodes_ALM;
    private Tblreceipt_barcodesModel tbl_receipt_barcodes_M;

    private void init_tbl_receipt_barcodes() {
        tbl_receipt_barcodes_ALM = new ArrayListModel();
        tbl_receipt_barcodes_M = new Tblreceipt_barcodesModel(tbl_receipt_barcodes_ALM);
        tbl_receipt_barcodes.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipt_barcodes.setModel(tbl_receipt_barcodes_M);
        tbl_receipt_barcodes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_barcodes.setRowHeight(25);
        int[] tbl_widths_receipt_barcodes = {0, 100};
        for (int i = 0, n = tbl_widths_receipt_barcodes.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_barcodes, i, tbl_widths_receipt_barcodes[i]);
        }
        Dimension d = tbl_receipt_barcodes.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_receipt_barcodes.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_barcodes.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_receipt_barcodes.setRowHeight(35);
        tbl_receipt_barcodes.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_receipt_barcodes(List<to_receipt_barcodes> acc) {
        tbl_receipt_barcodes_ALM.clear();
        tbl_receipt_barcodes_ALM.addAll(acc);
    }

    public static class Tblreceipt_barcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "BARCODE"
        };

        public Tblreceipt_barcodesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
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
            to_receipt_barcodes tt = (to_receipt_barcodes) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                default:
                    return tt.barcode;
            }
        }
    }

    private void update_barcode() {
        List<to_receipt_barcodes> acc = tbl_receipt_barcodes_ALM;
        String barcodes = "";
        String new_code = tf_barcode.getText();
        int i = 0;
        int exist = 0;
        int ie = 0;
        for (to_receipt_barcodes t : acc) {
            if (i == 0) {
                barcodes = barcodes + t;
            } else {
                barcodes = barcodes + "," + t;
            }
            i++;
            if (t.barcode.equalsIgnoreCase(new_code)) {

                exist = 1;
                ie = i;
            }
        }
        if (exist == 0) {
            to_receipt_barcodes to = new to_receipt_barcodes(0, barcode, new_code);
            String my_code = "";
            if (i == 0) {
                my_code = new_code;

            } else {
                my_code = barcodes1 + "," + new_code;
            }
            S1_items2.update_barcodes(barcode, my_code);
            tbl_receipt_barcodes_ALM.add(to);
            tbl_receipt_barcodes_M.fireTableDataChanged();
            tbl_receipt_barcodes.setRowSelectionInterval(tbl_receipt_barcodes.
                    getRowCount() - 1, tbl_receipt_barcodes.getRowCount() - 1);

        } else {
        }

    }
    private ArrayListModel tbl_receipt_serial_nos_ALM;
    private Tblreceipt_serial_nosModel tbl_receipt_serial_nos_M;

    private void init_tbl_receipt_serial_nos() {
        tbl_receipt_serial_nos_ALM = new ArrayListModel();
        tbl_receipt_serial_nos_M = new Tblreceipt_serial_nosModel(tbl_receipt_serial_nos_ALM);
        tbl_receipt_serial_nos.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipt_serial_nos.setModel(tbl_receipt_serial_nos_M);
        tbl_receipt_serial_nos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_serial_nos.setRowHeight(25);
        int[] tbl_widths_receipt_serial_nos = {0, 100};
        for (int i = 0, n = tbl_widths_receipt_serial_nos.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_serial_nos, i, tbl_widths_receipt_serial_nos[i]);
        }
        Dimension d = tbl_receipt_serial_nos.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_receipt_serial_nos.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_serial_nos.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_receipt_serial_nos.setRowHeight(35);
        tbl_receipt_serial_nos.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_receipt_serial_nos(List<to_receipt_serial_nos> acc) {
        tbl_receipt_serial_nos_ALM.clear();
        tbl_receipt_serial_nos_ALM.addAll(acc);
    }

    public static class Tblreceipt_serial_nosModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "SERIAL NO"
        };

        public Tblreceipt_serial_nosModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
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
            to_receipt_serial_nos tt = (to_receipt_serial_nos) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                default:
                    return tt.serial_no;
            }
        }
    }

    private void add_serial_no() {
        String serial_no = tf_serial_no.getText();
        if (serial_no.isEmpty()) {
            return;
        }
        to_receipt_serial_nos to = new to_receipt_serial_nos(0, serial_no);
        List<to_receipt_serial_nos> datas = tbl_receipt_serial_nos_ALM;
        int exist = 0;
        for (to_receipt_serial_nos t : datas) {
            if (t.serial_no.equalsIgnoreCase(serial_no)) {
                exist = 1;
            }
        }
        if (exist == 0) {
            tbl_receipt_serial_nos_ALM.add(to);
            tbl_receipt_serial_nos_M.fireTableDataChanged();
            tf_serial_no.setText("");
            tf_serial_no.grabFocus();
        }
    }

    private void delete_serial_no() {
        int row = tbl_receipt_serial_nos.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_receipt_serial_nos_ALM.remove(row);
        tbl_receipt_serial_nos_M.fireTableDataChanged();
        tf_serial_no.grabFocus();
    }

    private void ok1() {
        double amount = FitIn.toDouble(tf_amount.getText());
        double cost = FitIn.toDouble(tf_cost.getText());
        String barcodes = tf_barcode.getText();
        String serial_no = "";
        List<to_receipt_serial_nos> datas = tbl_receipt_serial_nos_ALM;
        List<String> se = new ArrayList();
        for (to_receipt_serial_nos to : datas) {
            se.add(to.serial_no);
        }
//        serial_no = SplitString.revert(se);
        serial_no = jTextArea1.getText();
        serial_no = serial_no.replaceAll("\n", ",");
        if (amount < 0) {
            Alert.set(0, "ENTER AMOUNT");
            return;
        }
        serial_no = jTextArea1.getText();
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(amount, cost, barcodes, serial_no));
        }
    }

    private void count_serial(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String serial = jTextArea1.getText();
            String[] datas = serial.split("\n");
            jLabel2.setText("" + datas.length);
        }
    }
}
