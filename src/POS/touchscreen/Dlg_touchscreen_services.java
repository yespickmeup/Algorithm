/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.my_services.My_services;
import POS.my_services.S1_my_services_description;
import POS.my_services.My_services_description_customers;
import POS.my_services.S1_my_services_item_replacements_customers;
import POS.my_services.S1_my_services_others;
import POS.my_services.My_services_others_customers;
import POS.my_services.S1_my_services_problems;
import POS.my_services.S1_my_services_problems_customers;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.LostHeaderRenderer;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
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
public class Dlg_touchscreen_services extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_services
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
    private Dlg_touchscreen_services(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_services(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_services() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_services myRef;

    private void setThisRef(Dlg_touchscreen_services myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_services> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_services create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_services create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_services((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_services((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_services dialog = Dlg_touchscreen_services.create(new javax.swing.JFrame(), true);
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
        tbl_orders = new javax.swing.JTable();
        jButton2 = new Button.Default();
        jButton1 = new Button.Success();
        jLabel11 = new Label.Separator();
        jTextField1 = new Field.Search();
        jLabel1 = new javax.swing.JLabel();
        tf_service_slip_no = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_serviced_by = new javax.swing.JLabel();
        tf_customer_name = new Label.Normal();
        jLabel15 = new javax.swing.JLabel();
        tf_serviced_by1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXLabel1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tf_service_slip_no1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_service_slip_no2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_service_slip_no3 = new javax.swing.JLabel();
        tf_service_slip_no4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_orders.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbl_orders);

        jButton2.setText("Cancel");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Release");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Service Slip No:");

        tf_service_slip_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Customer Name:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Service By:");

        tf_serviced_by.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Status:");

        tf_serviced_by1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("+ Add Item (F1)");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jXLabel1.setColumns(20);
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jXLabel1.setRows(5);
        jXLabel1.setBorder(null);
        jXLabel1.setFocusable(false);
        jScrollPane2.setViewportView(jXLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total [Replacements]:");

        tf_service_slip_no1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_slip_no1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tf_service_slip_no1.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Net Due:");

        tf_service_slip_no2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_service_slip_no2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tf_service_slip_no2.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total [Problems]:");

        tf_service_slip_no3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_slip_no3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tf_service_slip_no3.setText("0.00");

        tf_service_slip_no4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_service_slip_no4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tf_service_slip_no4.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Total [Others]:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addComponent(tf_serviced_by, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_service_slip_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_serviced_by1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField1)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_service_slip_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(tf_service_slip_no4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_service_slip_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_service_slip_no2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_service_slip_no, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_serviced_by, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_serviced_by1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_slip_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_slip_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_service_slip_no4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_service_slip_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_services();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        add_item();
    }//GEN-LAST:event_jLabel39MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea jXLabel1;
    private javax.swing.JTable tbl_orders;
    private javax.swing.JLabel tf_customer_name;
    private javax.swing.JLabel tf_service_slip_no;
    private javax.swing.JLabel tf_service_slip_no1;
    private javax.swing.JLabel tf_service_slip_no2;
    private javax.swing.JLabel tf_service_slip_no3;
    private javax.swing.JLabel tf_service_slip_no4;
    private javax.swing.JLabel tf_serviced_by;
    private javax.swing.JLabel tf_serviced_by1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_table_bg();
        init_tbl_order();

        String detail = "\nDescription:\nProblem:\nOthers:\n";
        jXLabel1.setText(detail);
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

        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    add_item();
                }

            }
        });
        tbl_orders.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    add_item();
                }

            }
        });
    }
    // </editor-fold>

    private void init_table_bg() {
        Color ivory = new Color(255, 255, 255);
        tbl_orders.setOpaque(true);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        tbl_orders.setFillsViewportHeight(true);
        tbl_orders.setBackground(ivory);
    }

    private ArrayListModel tbl_orders_ALM;
    private TblordersModel tbl_orders_M;

    private void init_tbl_order() {
        tbl_orders_ALM = new ArrayListModel();
        tbl_orders_M = new TblordersModel(tbl_orders_ALM);
        tbl_orders.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        tbl_orders.setModel(tbl_orders_M);
        tbl_orders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_orders.setRowHeight(25);
        int[] tbl_widths_items = {40, 40, 50, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_orders, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_orders.getTableHeader().
                getPreferredSize();
        d.height = 35;

        tbl_orders.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 14));
        tbl_orders.setRowHeight(35);
        tbl_orders.setFont(new java.awt.Font("Arial", 0, 14));
        TableWidthUtilities.setColumnRightRenderer(tbl_orders, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_orders, 4);
        tbl_orders.getColumnModel().getColumn(0).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(1).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(2).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(3).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(4).setHeaderRenderer(new LostHeaderRenderer());
    }

    private void loadData_orders(List<Inventory_barcodes.to_inventory_barcodes> acc) {
        tbl_orders_ALM.clear();
        tbl_orders_ALM.addAll(acc);

    }

    public static class TblordersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Description", "Qty", "UOM", "Discount", "Amount", "COST", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level"
        };

        public TblordersModel(ListModel listmodel) {
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
            Inventory_barcodes.to_inventory_barcodes tt = (Inventory_barcodes.to_inventory_barcodes) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.description;
                case 1:
                    return "  " + FitIn.fmt_woc(tt.product_qty);
                case 2:
//                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    return " " + tt.unit;
                case 3:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 4:
                    return FitIn.fmt_wc_0((tt.product_qty * tt.selling_price) - tt.discount_amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.cost);
                case 6:
                    return tt.classification;
                case 7:
                    return tt.classification_id;
                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.supplier;
                case 19:
                    return tt.fixed_price;
                case 20:
                    return tt.cost;
                case 21:
                    return tt.supplier_id;
                case 22:
                    return tt.multi_level_pricing;
                case 23:
                    return tt.vatable;
                default:
                    return tt.reorder_level;
            }
        }
    }

    List<My_services.to_my_services> services_list = new ArrayList();
    int selected_item = -1;

    private void init_services() {

        services_list.clear();
        String search = jTextField1.getText();
        String where = " where customer_name like '%" + search + "%' or service_slip_no like '%" + search + "%' ";

        where = where + " order by transaction_no asc";
        System.out.println(where);
        List<My_services.to_my_services> datas = My_services.ret_data(where);
        services_list = My_services.ret_data(where);
        Object[][] obj = new Object[services_list.size()][4];
        int i = 0;
        for (My_services.to_my_services to1 : services_list) {
            obj[i][0] = " " + to1.service_slip_no;
            obj[i][1] = " " + to1.customer_name;
            obj[i][2] = " " + to1.serviced_by;
            if (to1.status == 0) {
                obj[i][3] = " On Going";
            }
            if (to1.status == 1) {
                obj[i][3] = " Finished";
            }
            if (to1.status == 2) {
                obj[i][3] = " Released";
            }
            if (to1.status == 3) {
                obj[i][3] = " On Hold";
            }
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, 100, 150, 70};
        int width = 0;
        String[] col_names = {"Slip No", "Customer Name", "Service By", "Status"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                My_services.to_my_services to = services_list.get(data.selected_row);
                Label.Normal lbl = (Label.Normal) tf_customer_name;
                tf_service_slip_no.setText(to.service_slip_no);
                tf_serviced_by.setText(to.serviced_by);
                tf_customer_name.setText(to.customer_name);
                selected_item = data.selected_row;

                String status = "";
                if (to.status == 0) {
                    status = "On Going";
                }
                if (to.status == 1) {
                    status = "Finished";
                }
                if (to.status == 2) {
                    status = "Released";
                }
                if (to.status == 3) {
                    status = "On Hold";
                }
                tf_serviced_by1.setText(status);
                String where = "where transaction_no='" + tf_service_slip_no.getText() + "' order by description asc";
                List<S1_my_services_description.to_my_services_description> description = My_services_description_customers.ret_data(where);
                String d = "";
                for (S1_my_services_description.to_my_services_description desc : description) {
                    d = d + "" + FitIn.fmt_woc(desc.amount) + " " + desc.unit + " " + desc.description;
                }

                String detail = "DETAILS:\n";

                String where2 = "where transaction_no='" + to.transaction_no + "' order by description asc";
                List<S1_my_services_description.to_my_services_description> descs = My_services_description_customers.ret_data(where2);
                String d1 = "\nDescription:";
                for (S1_my_services_description.to_my_services_description desc : descs) {
                    d1 = d1 + "\n   " + FitIn.fmt_woc(desc.amount) + " " + desc.unit + " " + desc.description;
                }

                String where3 = " where transaction_no='" + to.transaction_no + "' order by problem asc";
                List<S1_my_services_problems.to_my_services_problems> probs = S1_my_services_problems_customers.ret_data(where3);
                String p = "\nProblem:";
                double total_problem = 0;
                for (S1_my_services_problems.to_my_services_problems prob : probs) {
                    p = p + "\n   " + prob.problem;
                    total_problem += prob.amount;
                }
                tf_service_slip_no3.setText(FitIn.fmt_wc_0(total_problem));
                String where4 = " where transaction_no='" + to.transaction_no + "' ";
                double total_others = 0;
                List<S1_my_services_others.to_my_services_others> others = My_services_others_customers.ret_data(where4);
                String o = "\nOthers:";
                for (S1_my_services_others.to_my_services_others other : others) {
                    total_others += to.amount;
                }
                tf_service_slip_no4.setText(FitIn.fmt_wc_0(total_others));
                String where5 = " where transaction_no='" + to.transaction_no + "' order by description asc";
                List<Inventory_barcodes.to_inventory_barcodes> reps = S1_my_services_item_replacements_customers.convert_to_inv_barcodes(S1_my_services_item_replacements_customers.ret_data(where5));

                loadData_orders(reps);

                detail = d1 + p + o;
                jXLabel1.setText(detail);
            }
        });
    }

    private void add_item() {
        if (tf_service_slip_no.getText().isEmpty()) {
            Alert.set(0, "No Transaction Selected!");
            return;
        }
        Window p = (Window) this;
        Dlg_touchscreen_services_add_item nd = Dlg_touchscreen_services_add_item.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_services_add_item.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_services_add_item.OutputData data) {
                closeDialog.ok();
                Inventory_barcodes.to_inventory_barcodes to = data.item;
                My_services.to_my_services service = (My_services.to_my_services) services_list.get(selected_item);
                int id = 0;
                String customer_id = service.customer_id;
                String customer_name = tf_customer_name.getText();
                String transaction_no = service.transaction_no;
                double selling_price = to.selling_price;
                String date_added = to.date_added;
                String user_name = to.user_name;

                String item_code = to.barcode;
                String barcode = to.barcode;
                String description = to.description;
                double qty = to.product_qty;

                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_classification = to.sub_classification;
                String sub_classification_id = to.sub_classification_id;
                String unit = to.unit;
                double conversion = to.conversion;
                String item_type = to.item_type;
                int status = to.status;
                String supplier = to.supplier;
                int fixed_price = to.fixed_price;
                String supplier_id = to.supplier_id;
                int multi_level_pricing = to.multi_level_pricing;
                int vatable = to.vatable;
                double reorder_level = to.reorder_level;
                double markup = to.markup;
                String brand = to.brand;
                String brand_id = to.brand_id;
                String model = to.model;
                String model_id = to.model_id;
                String selling_type = "" + to.selling_type;
                String branch = to.branch;
                String branch_code = to.branch_code;
                String location = to.location;
                String location_id = to.location_id;
                String serial_no = "";
                String user_id = service.cashier_id;
                String user_screen_name = service.cashier_id;

                S1_my_services_item_replacements_customers.to_my_services_item_replacements_customers t1 = new S1_my_services_item_replacements_customers.to_my_services_item_replacements_customers(id, transaction_no, customer_id, customer_name, item_code, barcode, description, qty, selling_price, date_added, user_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);
                List<S1_my_services_item_replacements_customers.to_my_services_item_replacements_customers> d = new ArrayList();
                d.add(t1);
                S1_my_services_item_replacements_customers.add_data(d);
                compute();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void compute() {
        List<Inventory_barcodes.to_inventory_barcodes> datas = tbl_orders_ALM;
        double total = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : datas) {
            total += (to.product_qty * to.selling_price) - to.discount_amount;
        }
        tf_service_slip_no1.setText(FitIn.fmt_wc_0(total));
    }

}
