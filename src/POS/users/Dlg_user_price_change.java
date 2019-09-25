/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory;
import POS.inventory.uom;
import POS.users.User_price_change_request_logs.to_user_price_change_request_logs;
import POS.users.User_price_change_requests.to_user_price_change_requests;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Field;

/**
 *
 * @author Ronescape
 */
public class Dlg_user_price_change extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_user_price_change
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
    private Dlg_user_price_change(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_user_price_change(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_user_price_change() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_user_price_change myRef;

    private void setThisRef(Dlg_user_price_change myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_user_price_change> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_user_price_change create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_user_price_change create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_user_price_change dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_user_price_change((java.awt.Frame) parent, false);
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
            Dlg_user_price_change dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_user_price_change((java.awt.Dialog) parent, false);
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

        Dlg_user_price_change dialog = Dlg_user_price_change.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_cashier = new Field.Search();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new Field.Input();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user_price_change_requests = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new Field.Search();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_user_price_change_request_logs = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("User:");

        tf_cashier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashierMouseClicked(evt);
            }
        });
        tf_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashierActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("User Name:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Screen Name:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addComponent(tf_cashier))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_cashier, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item/s", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_user_price_change_requests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_user_price_change_requests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_user_price_change_requestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user_price_change_requests);

        jLabel4.setText("Total no. of rows:");

        jLabel5.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Search Item:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Filter by:");

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("[F2]-Item Code");
        jCheckBox7.setFocusable(false);

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Barcode");
        jCheckBox8.setFocusable(false);

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("[F4]-Description");
        jCheckBox9.setFocusable(false);

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel9.setText("Status:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox9)
                        .addGap(249, 249, 249)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel9))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_user_price_change_request_logs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_user_price_change_request_logs);

        jLabel7.setText("Total no. of rows:");

        jLabel8.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void tf_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashierActionPerformed
        init_cashier();
    }//GEN-LAST:event_tf_cashierActionPerformed

    private void tf_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashierMouseClicked
        init_cashier();
    }//GEN-LAST:event_tf_cashierMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void tbl_user_price_change_requestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_price_change_requestsMouseClicked
        select_user_price_change_request();
    }//GEN-LAST:event_tbl_user_price_change_requestsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tbl_user_price_change_request_logs;
    private javax.swing.JTable tbl_user_price_change_requests;
    private javax.swing.JTextField tf_cashier;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
        init_key();

        init_tbl_user_price_change_requests(tbl_user_price_change_requests);
        init_tbl_user_price_change_request_logs(tbl_user_price_change_request_logs);
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

        jTextField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    jCheckBox6.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    jCheckBox7.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    jCheckBox8.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    jCheckBox9.setSelected(true);
                }
            }
        });
    }
    // </editor-fold>

    private void init_cashier() {
        String search = tf_cashier.getText();
        String where = "  where screen_name like '%" + search + "%' or user_name like '%" + search + "%' order by screen_name asc";
        final List<S1_users.to_users> user_list = MyUser.ret_data2(where);

        Object[][] obj = new Object[user_list.size()][2];
        int i = 0;
        for (S1_users.to_users to : user_list) {
            obj[i][0] = " " + to.user_name;
            obj[i][1] = " " + to.screen_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, tf_cashier.getWidth() - 100};
        int width = 0;
        String[] col_names = {"", ""};

        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_cashier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Search f = (Field.Search) tf_cashier;
                S1_users.to_users to = (S1_users.to_users) user_list.get(data.selected_row);
                tf_cashier.setText(to.screen_name);
                f.setId("" + to.id);

                jTextField2.setText(to.user_name);
                jTextField3.setText(to.screen_name);
                jTextField4.grabFocus();
                ret_price_change_request();
                ret_logs();
            }
        });
    }
    //<editor-fold defaultstate="collapsed" desc=" user_price_change_requests "> 
    public static ArrayListModel tbl_user_price_change_requests_ALM;
    public static Tbluser_price_change_requestsModel tbl_user_price_change_requests_M;

    public static void init_tbl_user_price_change_requests(JTable tbl_user_price_change_requests) {
        tbl_user_price_change_requests_ALM = new ArrayListModel();
        tbl_user_price_change_requests_M = new Tbluser_price_change_requestsModel(tbl_user_price_change_requests_ALM);
        tbl_user_price_change_requests.setModel(tbl_user_price_change_requests_M);
        tbl_user_price_change_requests.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_user_price_change_requests.setRowHeight(25);
        int[] tbl_widths_user_price_change_requests = {100, 100, 100, 100, 50, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_user_price_change_requests.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_user_price_change_requests, i, tbl_widths_user_price_change_requests[i]);
        }
        Dimension d = tbl_user_price_change_requests.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_user_price_change_requests.getTableHeader().setPreferredSize(d);
        tbl_user_price_change_requests.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_user_price_change_requests.setRowHeight(25);
        tbl_user_price_change_requests.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_user_price_change_requests, 3);
    }

    public static void loadData_user_price_change_requests(List<to_user_price_change_requests> acc) {
        tbl_user_price_change_requests_ALM.clear();
        tbl_user_price_change_requests_ALM.addAll(acc);
    }

    public static class Tbluser_price_change_requestsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Item Code", "Description", "Unit", "Price", "", "item_code", "description", "unit", "selling_price", "status"
        };

        public Tbluser_price_change_requestsModel(ListModel listmodel) {
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
            to_user_price_change_requests tt = (to_user_price_change_requests) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.item_code;
                case 1:
                    return " " + tt.description;
                case 2:
                    String uom = tt.unit;
                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }
                    return " " + unit;
                case 3:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 4:
                    return " Delete";
                case 5:
                    return tt.item_code;
                case 6:
                    return tt.description;
                case 7:
                    return tt.unit;
                case 8:
                    return tt.selling_price;
                default:
                    return tt.status;
            }
        }
    }

    private void ret_price_change_request() {
        Field.Search tf = (Field.Search) tf_cashier;

        String where = " where user_id='" + tf.getId() + "' order by id desc ";
        List<User_price_change_requests.to_user_price_change_requests> request = User_price_change_requests.ret_data(where);
        loadData_user_price_change_requests(request);
        jLabel5.setText("" + request.size());
    }
    List<Inventory.to_inventory> inventory = new ArrayList();

    private void init_inventory_barcodes() {
        if (jTextField2.getText().isEmpty()) {
            Alert.set(0, "Please select user");
            tf_cashier.grabFocus();
            return;
        }
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        jTextField4.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String search = jTextField4.getText();
                String where = " where ";
                if (jCheckBox6.isSelected()) {
                    where = where + "  barcode like '" + search + "'  "
                            + " or barcodes='" + search + "'  "
                            + " or description like '%" + search + "%' ";
                }
                if (jCheckBox7.isSelected()) {
                    where = where + " barcode like '" + search + "'  "
                            + "  ";
                }
                if (jCheckBox8.isSelected()) {
                    where = where + "  "
                            + "  barcodes='" + search + "'  ";
                }
                if (jCheckBox9.isSelected()) {
                    where = where + "  description like '%" + search + "%'  ";
                }
                where = where + " order by description asc ";
                inventory.clear();
                inventory = Inventory.ret_data6(where);
                if (inventory.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    jTextField4.setEnabled(true);
                    jTextField4.grabFocus();
                }
                if (inventory.size() == 1) {
                    Inventory.to_inventory t = (Inventory.to_inventory) inventory.get(0);
                    List<User_price_change_requests.to_user_price_change_requests> items = tbl_user_price_change_requests_ALM;
                    int exists = 0;
                    for (User_price_change_requests.to_user_price_change_requests item : items) {
                        if (t.barcode.equalsIgnoreCase("" + item.item_code)) {
                            exists = 1;
                            break;
                        }
                    }
                    if (exists == 1) {
                        Alert.set(0, "Item already added!");
                        return;
                    }
                    confirm_add_item(t);
                    jTextField4.setEnabled(true);
                    jTextField4.grabFocus();
                }
                if (inventory.size() > 1) {
                    Object[][] obj = new Object[inventory.size()][5];
                    int i = 0;
                    for (Inventory.to_inventory to : inventory) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.barcode;
                        obj[i][2] = " " + to.description;
                        String unit = "";
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                        if (uoms != null) {
                            unit = uoms.uom;
                        }
                        obj[i][3] = " " + unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = jTextField4.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {0, 50, w - 20, 50, 70};
                    String[] col_names = {"Qty", "Item Code", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(jTextField4, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    jTextField4.setEnabled(true);
                    jTextField4.grabFocus();
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory.to_inventory t = (Inventory.to_inventory) inventory.get(data.selected_row);
                            List<User_price_change_requests.to_user_price_change_requests> items = tbl_user_price_change_requests_ALM;

                            int exists = 0;
                            for (User_price_change_requests.to_user_price_change_requests item : items) {
                                System.out.println("" + t.barcode + " " + item.item_code);
                                if (t.barcode.equalsIgnoreCase("" + item.item_code)) {
                                    exists = 1;
                                    break;
                                }

                            }
                            if (exists == 1) {
                                Alert.set(0, "Item already added!");
                                return;
                            }
                            confirm_add_item(t);

                        }
                    });
                }

            }
        });
        t.start();
    }

    private void confirm_add_item(final Inventory.to_inventory t) {

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Field.Search tf = (Field.Search) tf_cashier;
                int id = 0;
                String user_id = tf.getId();
                String user_name = jTextField2.getText();
                String created_at = DateType.now();
                String updated_at = DateType.now();
                String item_code = t.barcode;
                String description = t.description;
                String unit = t.unit;
                double selling_price = t.selling_price;
                int status = 1;
                User_price_change_requests.to_user_price_change_requests to = new to_user_price_change_requests(id, user_id, user_name, created_at, updated_at, item_code, description, unit, selling_price, status);

                User_price_change_requests.add_data(to);
                ret_price_change_request();
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
                jTextField4.setEnabled(true);
                jTextField4.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void select_user_price_change_request() {
        int row = tbl_user_price_change_requests.getSelectedRow();
        if (row < 0) {
            return;
        }
        final User_price_change_requests.to_user_price_change_requests to = (User_price_change_requests.to_user_price_change_requests) tbl_user_price_change_requests_ALM.get(row);
        int col = tbl_user_price_change_requests.getSelectedColumn();
        if (col == 4) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    User_price_change_requests.delete_data(to);
                    ret_price_change_request();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" user_price_change_request_logs "> 
    public static ArrayListModel tbl_user_price_change_request_logs_ALM;
    public static Tbluser_price_change_request_logsModel tbl_user_price_change_request_logs_M;

    public static void init_tbl_user_price_change_request_logs(JTable tbl_user_price_change_request_logs) {
        tbl_user_price_change_request_logs_ALM = new ArrayListModel();
        tbl_user_price_change_request_logs_M = new Tbluser_price_change_request_logsModel(tbl_user_price_change_request_logs_ALM);
        tbl_user_price_change_request_logs.setModel(tbl_user_price_change_request_logs_M);
        tbl_user_price_change_request_logs.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_user_price_change_request_logs.setRowHeight(25);
        int[] tbl_widths_user_price_change_request_logs = {80, 80, 100, 60, 80, 80, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_user_price_change_request_logs.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_user_price_change_request_logs, i, tbl_widths_user_price_change_request_logs[i]);
        }
        Dimension d = tbl_user_price_change_request_logs.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_user_price_change_request_logs.getTableHeader().setPreferredSize(d);
        tbl_user_price_change_request_logs.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_user_price_change_request_logs.setRowHeight(25);
        tbl_user_price_change_request_logs.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_user_price_change_request_logs, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_user_price_change_request_logs, 5);
    }

    public static void loadData_user_price_change_request_logs(List<to_user_price_change_request_logs> acc) {
        tbl_user_price_change_request_logs_ALM.clear();
        tbl_user_price_change_request_logs_ALM.addAll(acc);
    }

    public static class Tbluser_price_change_request_logsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Item Code", "Description", "Unit", "Previous", "New", "description", "old_unit", "new_unit", "old_price", "new_price", "status"
        };

        public Tbluser_price_change_request_logsModel(ListModel listmodel) {
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
            to_user_price_change_request_logs tt = (to_user_price_change_request_logs) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.created_at);
                case 1:
                    return " " + tt.item_code;
                case 2:
                    return " " + tt.description;
                case 3:
                    String uom = tt.new_unit;
                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }
                    return " " + unit;
                case 4:
                    return FitIn.fmt_wc_0(tt.old_price) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.new_price) + " ";
                case 6:
                    return tt.description;
                case 7:
                    return tt.old_unit;
                case 8:
                    return tt.new_unit;
                case 9:
                    return tt.old_price;
                case 10:
                    return tt.new_price;
                default:
                    return tt.status;
            }
        }
    }

    private void ret_logs() {
        Field.Search tf = (Field.Search) tf_cashier;
        String where = " where user_id='" + tf.getId() + "' order by id desc ";
        List<User_price_change_request_logs.to_user_price_change_request_logs> logs = User_price_change_request_logs.ret_data(where);
        loadData_user_price_change_request_logs(logs);
        jLabel8.setText("" + logs.size());
    }
//</editor-fold> 

}
