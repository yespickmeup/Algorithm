/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.accounts_receivable.S1_account_receivable_types;
import POS.accounts_receivable.S1_sales_on_account;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.customers.Customers;
import POS.util.TableRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_charge extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_credit_card
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
    private Dlg_touchscreen_charge(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_charge(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_charge() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_charge myRef;

    private void setThisRef(Dlg_touchscreen_charge myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_charge> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_charge create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_charge create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_charge dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_charge((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_charge dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_charge((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_charge dialog = Dlg_touchscreen_charge.create(new javax.swing.JFrame(), true);
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
        tf_charge_type = new Field.Combo();
        tf_reference_no = new Field.Input_w_clear();
        jButton2 = new Button.Default();
        jButton1 = new Button.Primary();
        tf_customer_name = new Field.Input_w_clear();
        tf_customer_id = new Field.Input_w_clear();
        tf_amount = new Field.Input_w_clear();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_amount1 = new Field.Input_w_clear();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tf_charge_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_charge_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_charge_typeMouseClicked(evt);
            }
        });
        tf_charge_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_charge_typeActionPerformed(evt);
            }
        });

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        tf_customer_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_id.setFocusable(false);
        tf_customer_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_idActionPerformed(evt);
            }
        });

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });
        tf_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amountKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Charge Type:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Reference No:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Customer Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Customer Id:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Amount:");

        tf_amount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount1.setText("30");
        tf_amount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amount1ActionPerformed(evt);
            }
        });
        tf_amount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amount1KeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Days:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(tf_amount, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_amount1)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tf_charge_type)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                        .addComponent(tf_reference_no, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                        .addComponent(tf_customer_name, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(tf_charge_type, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_amount1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
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

    private void tf_reference_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reference_noActionPerformed
        tf_customer_name.grabFocus();
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_customer_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_idActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        ok();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus

    private void tf_charge_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_charge_typeActionPerformed
        init_types();
    }//GEN-LAST:event_tf_charge_typeActionPerformed

    private void tf_charge_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_charge_typeMouseClicked
        init_types();
    }//GEN-LAST:event_tf_charge_typeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amountKeyReleased
        type_amount();
    }//GEN-LAST:event_tf_amountKeyReleased

    private void tf_amount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_amount1ActionPerformed

    private void tf_amount1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_amount1KeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_amount1;
    private javax.swing.JTextField tf_charge_type;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_reference_no;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
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
        Payments.charge charg = Payments.charge;
        Field.Combo cm = (Field.Combo) tf_charge_type;
        tf_charge_type.setText(charg.charge_type);
        cm.setId(charg.charge_type_id);
        tf_reference_no.setText(charg.reference_no);
        tf_customer_name.setText(charg.customer_name);
        tf_customer_id.setText(charg.customer_name);
        tf_amount.setText(FitIn.fmt_wc_0(charg.amount));
        tf_amount1.setText(FitIn.fmt_woc(charg.days));
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

    List<S1_account_receivable_types.to_accounts_receivable_types> type_list = new ArrayList();

    private void init_types() {
        final Field.Combo cm = (Field.Combo) tf_charge_type;
        String search = tf_charge_type.getText();
        String where = "";
        type_list.clear();
        type_list = S1_account_receivable_types.ret_data2(where);
        Object[][] obj = new Object[type_list.size()][2];
        int i = 0;
        for (S1_account_receivable_types.to_accounts_receivable_types to : type_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.type_name;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 100};
        String[] col_names = {"", "Type"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_charge_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_account_receivable_types.to_accounts_receivable_types to = type_list.get(data.selected_row);
                cm.setId("" + to.id);
                tf_charge_type.setText(to.type_name);
                if (to.id != 0) {
                    String where2 = " where soa_type_id='" + to.id + "' ";
                    String ref_no = S1_sales_on_account.increment_id2(where2);
                    tf_reference_no.setText(ref_no);
                    tf_reference_no.grabFocus();
                } else {
                    tf_reference_no.setText("");
                    tf_customer_name.grabFocus();
                }

            }
        });
    }
    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_customers() {
        String search = tf_customer_name.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' and branch_id='" + my_branch_id + "' order by customer_name asc";
        customer_list = Customers.ret_data3(where);
        Object[][] obj = new Object[customer_list.size()][2];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.customer_name;
            obj[i][1] = " " + FitIn.fmt_wc_0(to.balance);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {250, 90};
        int width = 0;
        String[] col_names = {"", "Balance"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_customer_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_name.setText(to.customer_name);
                tf_customer_id.setText(to.customer_no);
                tf_amount.grabFocus();
            }
        });
    }

    private void type_amount() {
        double to_pay = Payments.countChange();
        double tendered = FitIn.toDouble(tf_amount.getText());

        if (tendered > to_pay) {
            tf_amount.setText(FitIn.fmt_wc_0(to_pay));
        }

    }

    private void ok() {

        Field.Combo cm = (Field.Combo) tf_charge_type;
        String charge_type = tf_charge_type.getText();
        String charge_type_id = cm.getId();
        String reference_no = tf_reference_no.getText();
        String customer_name = tf_customer_name.getText();
        String customer_id = tf_customer_id.getText();
        double amount = FitIn.toDouble(tf_amount.getText());
        int days = FitIn.toInt(tf_amount1.getText());
        Payments.charge charg = new Payments.charge(charge_type, charge_type_id, reference_no, customer_name, customer_id, amount, days);
        Payments.charge = charg;
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
