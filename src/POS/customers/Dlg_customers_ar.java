/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.customers.Customer_departments.to_customer_departments;
import POS.customers.Customers.to_customers;
import POS.users.MyUser;
import POS.users.User_previlege_others;
import POS.util.Alert;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.panels.Warning;

/**
 *
 * @author Guinness
 */
public class Dlg_customers_ar extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_customers_ar
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
    private Dlg_customers_ar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_customers_ar(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_customers_ar() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_customers_ar myRef;

    private void setThisRef(Dlg_customers_ar myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customers_ar> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customers_ar create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customers_ar create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customers_ar dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers_ar((java.awt.Frame) parent, false);
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
            Dlg_customers_ar dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers_ar((java.awt.Dialog) parent, false);
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

        Dlg_customers_ar dialog = Dlg_customers_ar.create(new javax.swing.JFrame(), true);
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
        tf_customer_name = new Field.Input();
        jLabel2 = new javax.swing.JLabel();
        tf_contact_no = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        tf_address = new Field.Input();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customers = new javax.swing.JTable();
        jTextField4 = new Field.Search();
        jButton1 = new Button.Warning();
        jButton2 = new Button.Info();
        jButton3 = new Button.Default();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_from_branch = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tf_from_location = new javax.swing.JTextField();
        tf_from_branch_id = new javax.swing.JTextField();
        tf_from_location_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_customer_name1 = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_customer_name2 = new Field.Combo();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton4 = new Button.Default();
        jButton5 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Customer Name:");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contact No:");

        tf_contact_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Address:");

        tf_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbl_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_customers);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Total No.:");

        jLabel6.setText("0");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Branch:");

        tf_from_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch.setFocusable(false);
        tf_from_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branchMouseClicked(evt);
            }
        });
        tf_from_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branchActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Location:");

        tf_from_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location.setFocusable(false);
        tf_from_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_locationActionPerformed(evt);
            }
        });

        tf_from_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch_id.setFocusable(false);

        tf_from_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location_id.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Department:");

        tf_customer_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_customer_name1MouseClicked(evt);
            }
        });
        tf_customer_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_name1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Search Customer:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Department:");

        tf_customer_name2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_customer_name2MouseClicked(evt);
            }
        });
        tf_customer_name2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_name2ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu2/add (1).png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_from_location)
                            .addComponent(tf_from_branch)
                            .addComponent(tf_customer_name1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_from_location_id, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(tf_from_branch_id, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 505, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_address)
                            .addComponent(tf_contact_no)
                            .addComponent(tf_customer_name)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_customer_name2))
                                    .addComponent(jTextField4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_customer_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_customer_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_customers();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customersMouseClicked
        select_customers();
    }//GEN-LAST:event_tbl_customersMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_customers();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        check_delete();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked

    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed

    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_from_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_locationActionPerformed

    }//GEN-LAST:event_tf_from_locationActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        departments();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_customer_name2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_name2ActionPerformed
        init_departments(tf_customer_name2);
    }//GEN-LAST:event_tf_customer_name2ActionPerformed

    private void tf_customer_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_name1ActionPerformed
        init_departments(tf_customer_name1);
    }//GEN-LAST:event_tf_customer_name1ActionPerformed

    private void tf_customer_name1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_name1MouseClicked
        init_departments(tf_customer_name1);
    }//GEN-LAST:event_tf_customer_name1MouseClicked

    private void tf_customer_name2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_name2MouseClicked
        init_departments(tf_customer_name2);
    }//GEN-LAST:event_tf_customer_name2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tbl_customers;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_contact_no;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_customer_name1;
    private javax.swing.JTextField tf_customer_name2;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch_id;
    private javax.swing.JTextField tf_from_location;
    private javax.swing.JTextField tf_from_location_id;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_algorithm");
        init_key();
        init_tbl_customers(tbl_customers);
        data_cols();

        tf_from_branch_id.setVisible(false);
        tf_from_location_id.setVisible(false);
        set_default_branch();
        ret_customer_departments();
    }

    private void ret_customer_departments() {
        departments = Customer_departments.ret_data(" order by department asc ");
        if (!departments.isEmpty()) {
            to_customer_departments to = (to_customer_departments) departments.get(0);
            Field.Combo dep1 = (Field.Combo) tf_customer_name1;
            Field.Combo dep2 = (Field.Combo) tf_customer_name2;

            dep1.setText(to.department);
            dep1.setId("" + to.id);

            dep2.setText(to.department);
            dep2.setId("" + to.id);

        }
    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        tf_from_branch.setText(to.branch);
        tf_from_branch_id.setText(to.branch_id);
        tf_from_location.setText(to.location);
        tf_from_location_id.setText("" + to.id);

    }
    static int is_ar = 0;

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

    //<editor-fold defaultstate="collapsed" desc=" customers "> 
    public static ArrayListModel tbl_customers_ALM;
    public static TblcustomersModel tbl_customers_M;

    public static void init_tbl_customers(JTable tbl_customers) {
        tbl_customers_ALM = new ArrayListModel();
        tbl_customers_M = new TblcustomersModel(tbl_customers_ALM);
        tbl_customers.setModel(tbl_customers_M);
        tbl_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_customers.setRowHeight(25);
        int[] tbl_widths_customers = {80, 100, 140, 100, 100, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_customers, i, tbl_widths_customers[i]);
        }
        Dimension d = tbl_customers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_customers.getTableHeader().setPreferredSize(d);
        tbl_customers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_customers.setRowHeight(25);
        tbl_customers.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_customers, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_customers, 4);
    }

    public static void loadData_customers(List<to_customers> acc) {
        tbl_customers_ALM.clear();
        tbl_customers_ALM.addAll(acc);
    }

    public static class TblcustomersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "ID No.", "Name", "Department", "Balance", "Prepaid", "address", "term", "location", "balance", "discount", "prepaid"
        };

        public TblcustomersModel(ListModel listmodel) {
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
            to_customers tt = (to_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.customer_no;
                case 1:
                    return " " + tt.customer_name;
                case 2:
                    return " " + tt.department;
                case 3:
                    return FitIn.fmt_wc_0(tt.balance) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.prepaid) + " ";
                case 5:
                    return tt.address;
                case 6:
                    return tt.term;
                case 7:
                    return tt.location;
                case 8:
                    return tt.balance;
                case 9:
                    return tt.discount;
                default:
                    return tt.prepaid;
            }
        }
    }
//</editor-fold> 

    private void data_cols() {
        String where = " where customer_name like '%" + jTextField4.getText() + "%' and branch_id='" + tf_from_branch_id.getText() + "' ";

        if (!jCheckBox1.isSelected()) {
            Field.Combo dep = (Field.Combo) tf_customer_name2;
            where = where + " and department_id='" + dep.getId() + "' ";
        }
        where = where + " order by customer_name asc";
        System.out.println(where);
        List<to_customers> datas = Customers.ret_data2(where);
        loadData_customers(datas);
        jLabel6.setText("" + datas.size());
    }

    private void add_customers() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Customers AR - (Add)" + "' limit 1";
        List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
        if (datas.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        Field.Combo dep = (Field.Combo) tf_customer_name1;
        int id = -1;
        String customer_name = tf_customer_name.getText();
        String customer_no = Customers.increment_id(tf_from_branch_id.getText());
        String contact_no = tf_contact_no.getText();
        double credit_limit = 0;
        String address = tf_address.getText();
        double term = 0;
        String location = tf_from_location.getText();
        double balance = 0;
        double discount = 0;
        String branch = tf_from_branch.getText();
        String branch_id = tf_from_branch_id.getText();
        String location_id = tf_from_location_id.getText();
        String department = dep.getText();
        String department_id = dep.getId();
        final to_customers to = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, 0, branch, branch_id, location_id, department, department_id);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Customers.add_customers(to);
                data_cols();
                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void select_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));
        tf_customer_name.setText(to.customer_name);
        tf_contact_no.setText(to.contact_no);
        tf_address.setText(to.address);
        Field.Combo dep = (Field.Combo) tf_customer_name1;
        dep.setText(to.department);
        dep.setId(to.department_id);
    }

    private void edit_customers() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Customers AR - (Edit)" + "' limit 1";
        List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
        if (datas.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Combo dep = (Field.Combo) tf_customer_name1;
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));

        int id = to.id;
        String customer_name = tf_customer_name.getText();
        String customer_no = to.customer_no;
        String contact_no = tf_contact_no.getText();
        double credit_limit = to.credit_limit;
        String address = tf_address.getText();
        double term = to.credit_limit;
        String location = to.location;
        double balance = 0;
        double discount = to.discount;
        String branch = to.branch;
        String branch_id = to.branch_id;
        String location_id = to.location_id;
        String department = dep.getText();
        String department_id = dep.getId();
        final to_customers to1 = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, 0, branch, branch_id, location_id, department, department_id);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to update this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Customers.edit_customers(to1);
                data_cols();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void check_delete() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Customers AR - (Delete)" + "' limit 1";
        List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
        if (datas.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        delete_customers();
//        Window p = (Window) this;
//        Authenticate nd = Authenticate.create(p, true);
//        nd.setTitle("");
//        nd.do_pass(this.getSurface(), "");
//
//        nd.setCallback(new Authenticate.Callback() {
//            @Override
//            public void ok(CloseDialog closeDialog, Authenticate.OutputData data) {
//                closeDialog.ok();
//                String username = data.username;
//                String password = data.password;
//                final S1_users.to_users to = S1_users.ret_data_autho(username, password);
//                if (to == null) {
//                    warning("Input correct credentials!");
//                } else {
//                    String where = " where user_name='" + username + "' order by previledge asc";
//                    List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
//                    int exist = 0;
//                    for (S1_user_previleges.to_user_previleges to2 : datas) {
//                        if (to2.previledge.equalsIgnoreCase("Customers (Update/Delete)")) {
//                            exist = 1;
//                            break;
//                        }
//                    }
//                    if (exist == 1) {
//                      
//                    } else {
//                        warning("User priviledge not added!");
//                    }
//                }
//
//            }
//        });
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = ((int) tk.getScreenSize().
//                getWidth());
//        int ySize = ((int) tk.getScreenSize().
//                getHeight());
//        nd.setSize(xSize, ySize);
//        nd.setVisible(true);
    }

    private void warning(String message) {
        Window p = (Window) this;
        Warning nd = Warning.create(p, true);
        nd.setTitle("");
        nd.do_pass(this.getSurface(), message);

        nd.setCallback(new Warning.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Warning.OutputData data) {
                closeDialog.ok();

            }
        });
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        nd.setSize(xSize, ySize);
        nd.setVisible(true);

    }

    private void delete_customers() {

        final int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                        convertRowIndexToModel(row));
                Customers.delete_customers(to);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void departments() {
        Window p = (Window) this;
        Dlg_customer_department nd = Dlg_customer_department.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_customer_department.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_customer_department.OutputData data) {
                ret_customer_departments();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<Customer_departments.to_customer_departments> departments = new ArrayList();

    private void init_departments(final JTextField tf1) {

        departments.clear();
        departments = Customer_departments.ret_data("");
        Object[][] obj = new Object[departments.size()][1];
        int i = 0;
        for (Customer_departments.to_customer_departments to : departments) {
            obj[i][0] = " " + to.department;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf1.getWidth()};
        String[] col_names = {"Id"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customer_departments.to_customer_departments to = departments.get(data.selected_row);
                Field.Combo dep = (Field.Combo) tf1;
                dep.setText("" + to.department);
                dep.setId("" + to.id);
            }
        });
    }

}
