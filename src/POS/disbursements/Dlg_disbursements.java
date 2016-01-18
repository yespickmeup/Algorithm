/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.category.S1_inventory_category;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.DateType;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.fields.Label;

/**
 *
 * @author Guinness
 */
public class Dlg_disbursements extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_disbursements
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
    private Dlg_disbursements(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_disbursements(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_disbursements() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_disbursements myRef;

    private void setThisRef(Dlg_disbursements myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_disbursements> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_disbursements create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_disbursements create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_disbursements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursements((java.awt.Frame) parent, false);
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
            Dlg_disbursements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursements((java.awt.Dialog) parent, false);
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

        Dlg_disbursements dialog = Dlg_disbursements.create(new javax.swing.JFrame(), true);
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
        tbl_disbursements = new javax.swing.JTable();
        jLabel62 = new javax.swing.JLabel();
        tf_purpose = new Field.Input();
        jLabel63 = new javax.swing.JLabel();
        tf_category_name = new Field.Combo();
        jLabel64 = new javax.swing.JLabel();
        tf_amount = new Field.Input();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton35 = new Button.Primary();
        jButton36 = new Button.Info();
        jButton34 = new Button.Warning();
        jLabel65 = new javax.swing.JLabel();
        tf_customer_name3 = new Field.Combo();
        jLabel66 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel67 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new Button.Primary();
        jLabel68 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel1 = new Label.Separator2();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_disbursements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_disbursements.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_disbursements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_disbursementsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_disbursements);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("Purpose:");

        tf_purpose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_purpose.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_purpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_purposeActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("Category:");

        tf_category_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_category_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_category_nameMouseClicked(evt);
            }
        });
        tf_category_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_category_nameActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Amount:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Yes/No");
        jCheckBox1.setFocusable(false);

        jButton35.setText("Add");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setText("Update");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton34.setText("Delete");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("Category:");

        tf_customer_name3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_customer_name3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_customer_name3MouseClicked(evt);
            }
        });
        tf_customer_name3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_name3ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("Date From:");

        jDateChooser1.setDate(new Date());

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setText("To:");

        jDateChooser2.setDate(new Date());

        jButton1.setText("Search");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("Date:");

        jDateChooser3.setDate(new Date());

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("Vatable:");

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("Total:");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_customer_name3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_amount))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_category_name)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_purpose)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_purpose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_category_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addGap(33, 33, 33))
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

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        add_disbursements();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        update_disbursements();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        delete_disbursements();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tbl_disbursementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_disbursementsMouseClicked
        select_disbursements();
    }//GEN-LAST:event_tbl_disbursementsMouseClicked

    private void tf_category_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_category_nameActionPerformed
        init_type();
    }//GEN-LAST:event_tf_category_nameActionPerformed

    private void tf_category_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_category_nameMouseClicked
        init_type();
    }//GEN-LAST:event_tf_category_nameMouseClicked

    private void tf_customer_name3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_name3ActionPerformed
        init_type2();
    }//GEN-LAST:event_tf_customer_name3ActionPerformed

    private void tf_customer_name3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_name3MouseClicked
        init_type2();
    }//GEN-LAST:event_tf_customer_name3MouseClicked

    private void tf_purposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_purposeActionPerformed
        tf_category_name.grabFocus();
    }//GEN-LAST:event_tf_purposeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_disbursements;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_category_name;
    private javax.swing.JTextField tf_customer_name3;
    private javax.swing.JTextField tf_purpose;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_branch();
        init_tbl_disbursements(tbl_disbursements);
        data_disbursements();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tf_purpose.grabFocus();
            }
        });
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

    private void data_disbursements() {
        String where2 = " where user_id='" + MyUser.getUser_id() + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas2 = S1_user_previleges.ret_data(where2);
        int view_all = 0;
        for (S1_user_previleges.to_user_previleges to : datas2) {
            if (to.previledge.equalsIgnoreCase("Disbursement (View All)")) {
                view_all = 1;
                break;
            }
        }

        String user_id = MyUser.getUser_id();
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        String where = " where user_id='" + user_id + "' and Date(date_added) between'" + date_from + "' and '" + date_to + "' ";
        if (view_all == 1) {
            where = " where  Date(date_added) between'" + date_from + "' and '" + date_to + "' ";
        }
        List<S1_disbursements.to_disbursements> datas = S1_disbursements.ret_data(where);
        loadData_disbursements(datas);

        double amount = 0;
        for (S1_disbursements.to_disbursements to : datas) {
            amount += to.amount;
        }
        jLabel71.setText(FitIn.fmt_wc_0(amount));
    }

    //<editor-fold defaultstate="collapsed" desc=" disbursements "> 
    public static ArrayListModel tbl_disbursements_ALM;
    public static TbldisbursementsModel tbl_disbursements_M;

    public static void init_tbl_disbursements(JTable tbl_disbursements) {
        tbl_disbursements_ALM = new ArrayListModel();
        tbl_disbursements_M = new TbldisbursementsModel(tbl_disbursements_ALM);
        tbl_disbursements.setModel(tbl_disbursements_M);
        tbl_disbursements.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_disbursements.setRowHeight(25);
        int[] tbl_widths_disbursements = {100, 100, 150, 100, 100, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_disbursements.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_disbursements, i, tbl_widths_disbursements[i]);
        }
        Dimension d = tbl_disbursements.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_disbursements.getTableHeader().setPreferredSize(d);
        tbl_disbursements.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_disbursements.setRowHeight(25);
        tbl_disbursements.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_disbursements, 4);
    }

    public static void loadData_disbursements(List<S1_disbursements.to_disbursements> acc) {
        tbl_disbursements_ALM.clear();
        tbl_disbursements_ALM.addAll(acc);
    }

    public static class TbldisbursementsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Purpose", "Category", "User", "Amount", "category_id", "category_name", "amount", "is_vat"
        };

        public TbldisbursementsModel(ListModel listmodel) {
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
            S1_disbursements.to_disbursements tt = (S1_disbursements.to_disbursements) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime2(tt.disbursement_date);
                case 1:
                    return " " + tt.purpose;
                case 2:
                    return " " + tt.category_name;
                case 3:
                    return " " + tt.user_screen_name;
                case 4:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 5:
                    return tt.category_id;
                case 6:
                    return tt.category_name;
                case 7:
                    return tt.amount;
                default:
                    return tt.is_vat;
            }
        }
    }
//</editor-fold> 

    private void add_disbursements() {
        Field.Combo cat = (Field.Combo) tf_category_name;
        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String purpose = tf_purpose.getText();
        String category_id = cat.getId();
        String category_name = tf_category_name.getText();
        double amount = FitIn.toDouble(tf_amount.getText());
        int is_vat = 0;
        if (jCheckBox1.isSelected()) {
            is_vat = 1;
        }
        String disbursement_date = DateType.sf.format(jDateChooser3.getDate());

        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;

        S1_disbursements.to_disbursements to = new S1_disbursements.to_disbursements(id, user_id, user_screen_name, date_added, purpose, category_id, category_name, amount, is_vat, disbursement_date, branch, branch_id, location, location_id);
        S1_disbursements.add_data(to);
        tf_purpose.setText("");
        cat.setId("");
        tf_category_name.setText("");
        tf_amount.setText("");
        data_disbursements();
    }

    private void select_disbursements() {

        int row = tbl_disbursements.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Combo cat = (Field.Combo) tf_category_name;
        S1_disbursements.to_disbursements to = (S1_disbursements.to_disbursements) tbl_disbursements_ALM.get(row);
        tf_purpose.setText(to.purpose);
        cat.setId(to.category_id);
        tf_category_name.setText(to.category_name);
        tf_amount.setText(FitIn.fmt_wc_0(to.amount));
        if (to.is_vat == 1) {
            jCheckBox1.setSelected(true);
        } else {
            jCheckBox1.setSelected(false);
        }
        try {
            Date d = DateType.sf.parse(to.disbursement_date);
            jDateChooser3.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_disbursements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update_disbursements() {

        int row = tbl_disbursements.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Combo cat = (Field.Combo) tf_category_name;
        S1_disbursements.to_disbursements to = (S1_disbursements.to_disbursements) tbl_disbursements_ALM.get(row);
        int id = to.id;
        String user_id = to.user_id;
        String user_screen_name = to.user_screen_name;
        String date_added = DateType.now();
        String purpose = tf_purpose.getText();
        String category_id = cat.getId();
        String category_name = tf_category_name.getText();
        double amount = FitIn.toDouble(tf_amount.getText());
        int is_vat = 0;
        if (jCheckBox1.isSelected()) {
            is_vat = 1;
        }
        String disbursement_date = DateType.sf.format(jDateChooser3.getDate());
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        S1_disbursements.to_disbursements to1 = new S1_disbursements.to_disbursements(id, user_id, user_screen_name, date_added, purpose, category_id, category_name, amount, is_vat, disbursement_date,branch,branch_id,location,location_id);
        S1_disbursements.update_data(to1);
        tf_purpose.setText("");
        cat.setId("");
        tf_category_name.setText("");
        tf_amount.setText("");
        data_disbursements();

    }

    private void delete_disbursements() {

        int row = tbl_disbursements.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Combo cat = (Field.Combo) tf_category_name;
        S1_disbursements.to_disbursements to = (S1_disbursements.to_disbursements) tbl_disbursements_ALM.get(row);
        S1_disbursements.delete_data(to);
        tf_purpose.setText("");
        cat.setId("");
        tf_category_name.setText("");
        tf_amount.setText("");
        data_disbursements();

    }

    List<S1_disbursement_categories.to_disbursement_categories> disbursement_types = new ArrayList();

    private void init_type() {
        final Field.Combo f = (Field.Combo) tf_category_name;
        String where = " where category_name like '%" + tf_category_name.getText() + "%' order by category_name asc";
        disbursement_types.clear();
        disbursement_types = S1_disbursement_categories.ret_data(where);
        Object[][] obj = new Object[disbursement_types.size()][1];
        int i = 0;
        for (S1_disbursement_categories.to_disbursement_categories to : disbursement_types) {
            obj[i][0] = " " + to.category_name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category_name.getWidth()};
        String[] col_names = {"Category"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_category_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_disbursement_categories.to_disbursement_categories to = (S1_disbursement_categories.to_disbursement_categories) disbursement_types.get(data.selected_row);
                f.setId("" + to.id);
                tf_category_name.setText(to.category_name.toUpperCase());
                tf_amount.grabFocus();
            }
        });
    }
    List<S1_disbursement_categories.to_disbursement_categories> disbursement_types2 = new ArrayList();

    private void init_type2() {
        final Field.Combo f = (Field.Combo) tf_customer_name3;
        String where = " where category_name like '%" + tf_customer_name3.getText() + "%' order by category_name asc";
        disbursement_types2.clear();
        disbursement_types2 = S1_disbursement_categories.ret_data(where);
        Object[][] obj = new Object[disbursement_types2.size()][1];
        int i = 0;
        for (S1_disbursement_categories.to_disbursement_categories to : disbursement_types2) {
            obj[i][0] = " " + to.category_name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_customer_name3.getWidth()};
        String[] col_names = {"Category"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_customer_name3, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_disbursement_categories.to_disbursement_categories to = (S1_disbursement_categories.to_disbursement_categories) disbursement_types2.get(data.selected_row);
                f.setId("" + to.id);
                tf_customer_name3.setText(to.category_name.toUpperCase());

            }
        });
    }
}
