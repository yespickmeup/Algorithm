/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author User
 */
public class Dlg_ar_payment_batch extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_payment_batch
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

        public final List<S1_accounts_receivable_payments.to_accounts_receivable_payments> data;

        public OutputData(List<S1_accounts_receivable_payments.to_accounts_receivable_payments> data) {
            this.data = data;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_ar_payment_batch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_payment_batch(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_payment_batch() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_ar_payment_batch myRef;

    private void setThisRef(Dlg_ar_payment_batch myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_payment_batch> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_payment_batch create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_payment_batch create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_payment_batch dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_payment_batch((java.awt.Frame) parent, false);
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
            Dlg_ar_payment_batch dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_payment_batch((java.awt.Dialog) parent, false);
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

        Dlg_ar_payment_batch dialog = Dlg_ar_payment_batch.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        tf_customer_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_credit_limit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_accounts_receivable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lbl_balance = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        tf_field20 = new Field.Input();
        jButton4 = new Button.Default();
        jButton3 = new Button.Success();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name:");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_customer_name.setFocusable(false);
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        tf_customer_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_customer_id.setFocusable(false);

        jLabel4.setBackground(java.awt.Color.black);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID No:");

        lbl_credit_limit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_limit.setFocusable(false);

        jLabel6.setBackground(java.awt.Color.black);
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Balance:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_customer_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_customer_name))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Accounts Receivables", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_accounts_receivable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_accounts_receivable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_accounts_receivable);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Balance:");

        lbl_balance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_balance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel84.setText("Enter amount:");

        tf_field20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_field20.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_field20.setText("0.00");
        tf_field20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_field20MouseClicked(evt);
            }
        });
        tf_field20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_field20ActionPerformed(evt);
            }
        });
        tf_field20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_field20KeyReleased(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_field20))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_field20)
                    .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_field20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_field20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_field20MouseClicked

    private void tf_field20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_field20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_field20ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        confirm_action();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_accounts_receivableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMouseClicked
        select_ar();
    }//GEN-LAST:event_tbl_accounts_receivableMouseClicked

    private void tf_field20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_field20KeyReleased
        set_paid();
    }//GEN-LAST:event_tf_field20KeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_balance;
    private javax.swing.JTextField lbl_credit_limit;
    private javax.swing.JTable tbl_accounts_receivable;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_field20;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_accounts_receivable();
    }

    public void do_pass(List<S1_accounts_receivable.to_accounts_receivable> datas, String name, String id, String balance) {

        List<S1_accounts_receivable.to_accounts_receivable> datas2 = new ArrayList();
        datas2 = datas;
        loadData_accounts_receivable(datas2);
        tf_customer_name.setText(name);
        tf_customer_id.setText(id);
        lbl_credit_limit.setText(balance);
        tf_field20.grabFocus();
        double bal = 0;
        for (S1_accounts_receivable.to_accounts_receivable to : datas2) {
            bal += (to.amount - to.paid);
            to.setRemarks("");
            to.setUser_screen_name("");
        }
        lbl_balance.setText(FitIn.fmt_wc_0(bal));
        tbl_accounts_receivable_M.fireTableDataChanged();

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

    private ArrayListModel tbl_accounts_receivable_ALM;
    private Tblaccounts_receivableModel tbl_accounts_receivable_M;

    private void init_tbl_accounts_receivable() {
        tbl_accounts_receivable_ALM = new ArrayListModel();
        tbl_accounts_receivable_M = new Tblaccounts_receivableModel(tbl_accounts_receivable_ALM);
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable.setModel(tbl_accounts_receivable_M);
        tbl_accounts_receivable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable.setRowHeight(25);
        int[] tbl_widths_accounts_receivable = {100, 100, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 111 || i == 0 || i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable, i, tbl_widths_accounts_receivable[i]);
        }
        Dimension d = tbl_accounts_receivable.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(d);
        tbl_accounts_receivable.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 12));
        tbl_accounts_receivable.setRowHeight(25);
        tbl_accounts_receivable.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 5);
        tbl_accounts_receivable.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    private void loadData_accounts_receivable(List<S1_accounts_receivable.to_accounts_receivable> acc) {
        tbl_accounts_receivable_ALM.clear();
        tbl_accounts_receivable_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference #", "OR/SI/DR #", "Date", "Term", "Amount", "Balance", "", "", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type"
        };

        public Tblaccounts_receivableModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 7) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_accounts_receivable.to_accounts_receivable tt = (S1_accounts_receivable.to_accounts_receivable) getRow(row);
            switch (col) {
                case 0:
                    if (tt.ci_no.isEmpty()) {
                        return " " + tt.trust_receipt;
                    }
                    if (tt.trust_receipt.isEmpty()) {
                        return " " + tt.ci_no;
                    }
                case 1:
                    return " " + tt.remarks;
                case 2:
                    return " " + DateType.convert_dash_date2(tt.date_applied);
                case 3:
                    return " " + FitIn.fmt_woc(tt.term) + " Day/s";
                case 4:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0((tt.amount - tt.paid) - FitIn.toDouble(tt.user_screen_name)) + " ";
                case 6:
                    if (tt.status == 1) {
                        return "/POS/icon_payment/remove11.png";
                    } else {
                        return "/POS/icon_inventory/checked.png";
                    }
                case 7:
                    return tt.selected;
                case 8:
                    return tt.discount_amount;
                case 9:
                    return tt.discount_rate;
                case 10:
                    return tt.discount;
                case 11:
                    return tt.status;
                case 12:
                    return tt.term;
                case 13:
                    return tt.date_applied;
                case 14:
                    return tt.paid;
                case 15:
                    return tt.date_paid;
                case 16:
                    return tt.remarks;
                case 17:
                    return tt.type;
                default:
                    return tt.or_no;
            }
        }
    }

    private void set_paid() {
        double tendered = FitIn.toDouble(tf_field20.getText());
        double balance = FitIn.toDouble(lbl_balance.getText());
        if (tendered > balance) {
            tendered = balance;
            tf_field20.setText(FitIn.fmt_wc_0(tendered));
        }
        double total = tendered;
        List<S1_accounts_receivable.to_accounts_receivable> modes = tbl_accounts_receivable_ALM;
        for (S1_accounts_receivable.to_accounts_receivable mode : modes) {
            double amount = (mode.amount - mode.paid);
            double prev_total = total;
            total = total - amount;
            if (total >= 0) {
                mode.setUser_screen_name("" + amount);
            } else {
                if (prev_total >= 0) {
                    mode.setUser_screen_name("" + prev_total);
                } else {
                    mode.setUser_screen_name("0");
                }
            }
        }
        tbl_accounts_receivable_M.fireTableDataChanged();
    }

    private void set_or() {

    }

    private void select_ar() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        final S1_accounts_receivable.to_accounts_receivable ar = (S1_accounts_receivable.to_accounts_receivable) tbl_accounts_receivable_ALM.get(row);
        Window p = (Window) this;
        Dlg_ar_payment_batch_or nd = Dlg_ar_payment_batch_or.create(p, true);
        nd.setTitle("");
        nd.do_pass(ar.remarks);
        nd.setCallback(new Dlg_ar_payment_batch_or.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_payment_batch_or.OutputData data) {
                closeDialog.ok();
                ar.setRemarks(data.or_no);
                tbl_accounts_receivable_M.fireTableDataChanged();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void confirm_action() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                ok2();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ok2() {
        double am = FitIn.toDouble(tf_field20.getText());
        if (am < 1) {
            Alert.set(0, "Enter Amount!");
            tf_field20.grabFocus();
            return;
        }
        int rem = 0;
        List<S1_accounts_receivable.to_accounts_receivable> ars = tbl_accounts_receivable_ALM;
        List<S1_accounts_receivable_payments.to_accounts_receivable_payments> added = new ArrayList();
        for (S1_accounts_receivable.to_accounts_receivable to : ars) {
            String customer_id = to.customer_id;
            String customer_name = to.customer_name;
            String ar_no = to.ar_no;
            String date_added = DateType.datetime.format(new Date());
            String user_name = Users.user_name;
            double amount = FitIn.toDouble(to.user_screen_name);
            double discount_amount = 0;
            double discount_rate = 0;
            String discount = "";
            int status = 0;
            double term = 0;
            String date_applied = DateType.sf.format(new Date());
            double paid = 0;
            String date_paid = DateType.sf.format(new Date());
            String remarks = "";
            String type = "CASH";
            String or_no = to.or_no;
            double prev_balance = 0;
            double check_amount = 0;
            String check_holder = "";
            String check_bank = "";
            String check_no = "";
            String ci_no = to.remarks;//tf_or_no.getText();
            String trust_receipt = to.remarks;//tf_or_no.getText();
            String or_payment_no = to.remarks;
            String soa_id = to.soa_id;
            String soa_type = to.soa_type;
            String soa_type_id = to.soa_type_id;
            String reference_no = to.remarks;
            String check_date = DateType.sf.format(new Date());
            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();
            double tax_rate = 0;
            double tax_amount = 0;

            String branch = to.branch;
            String branch_id = to.branch_id;
            String location = to.location;
            String location_id = to.location_id;

            double total_amount = check_amount + amount;
            String prepaid_customer_name = "";
            String prepaid_customer_id = "";
            double prepaid_amount = 0;
            String credit_card_type = "";
            double credit_card_rate = 0;
            String credit_card_no = "";
            String credit_card_holder = "";
            double credit_card_amount = 0;
            String gift_certificate_from = "";
            String gift_certificate_description = "";
            String gift_certificate_no = "";
            double gift_certificate_amount = 0;
            String online_bank = "";
            String online_reference_no = "";
            String online_holder = "";
            String online_date = DateType.now();
            double online_amount = 0;
            double actual_amount = (amount + check_amount) - discount_amount;
            double retention = 0;
            double business_tax = 0;
            double salary_deduction = 0;
            S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                    status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid,
                    date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id,
                    soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location,
                    location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no,
                    credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount,
                    online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount, retention, business_tax, salary_deduction);
            added.add(to1);
            if (to.remarks.isEmpty()) {
                rem++;
            }
        }

        if (rem > 0) {
            Alert.set(0, "Please input, Reference No!");
            return;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(added));
        }
    }
}
