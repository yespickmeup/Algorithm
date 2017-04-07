/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_payments;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.Branches;
import POS.customers.Customers;
import POS.customers.Customers.to_customers;
import POS.prepaid_payments.Prepaid_payments.to_prepaid_payments;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
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

/**
 *
 * @author Guinness
 */
public class Dlg_prepaid_payments extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_prepaid_payments
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
    private Dlg_prepaid_payments(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_prepaid_payments(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_prepaid_payments() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_prepaid_payments myRef;

    private void setThisRef(Dlg_prepaid_payments myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_prepaid_payments> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_prepaid_payments create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_prepaid_payments create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_prepaid_payments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_prepaid_payments((java.awt.Frame) parent, false);
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
            Dlg_prepaid_payments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_prepaid_payments((java.awt.Dialog) parent, false);
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

        Dlg_prepaid_payments dialog = Dlg_prepaid_payments.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_prepaid_payments = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tf_check_bank = new javax.swing.JTextField();
        tf_check_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_cash = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_customer_name = new Field.Search();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        tf_cheque_holder = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new Button.Default();
        jButton2 = new Button.Info();
        jButton3 = new Button.Warning();
        jLabel15 = new javax.swing.JLabel();
        tf_from_branch = new Field.Combo();
        tf_from_branch_id = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/global_values.png"))); // NOI18N
        jMenuItem1.setText("Finalize");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        tbl_prepaid_payments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_prepaid_payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prepaid_paymentsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_prepaid_paymentsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_prepaid_paymentsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_prepaid_payments);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Bank:");

        tf_check_bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_bank.setEnabled(false);
        tf_check_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_bankActionPerformed(evt);
            }
        });

        tf_check_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_no.setEnabled(false);
        tf_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_noActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Check No:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Amount:");

        tf_cash.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setText("Total Transaction/s:");

        jLabel8.setText("0");

        jLabel9.setText("Total Payments:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Customer Name:");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_customer_nameMouseClicked(evt);
            }
        });
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Trans Type:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cash");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Cheque");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Cheque Holder:");

        tf_cheque_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_holder.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Cheque Date:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setEnabled(false);
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Check all Posted");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
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

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Branch:");

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

        tf_from_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch_id.setFocusable(false);

        jLabel16.setText("Total Customers:");

        jLabel17.setText("0");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");
        jCheckBox4.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_from_branch)
                                .addGap(0, 0, 0)
                                .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_check_no, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_check_bank, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_cheque_holder)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_customer_name))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tf_cheque_holder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)
                                    .addComponent(tf_cash)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox4))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customersMouseClicked
        select_customers();
    }//GEN-LAST:event_tbl_customersMouseClicked

    private void tbl_prepaid_paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prepaid_paymentsMouseClicked
        select_prepaid_payments();
    }//GEN-LAST:event_tbl_prepaid_paymentsMouseClicked

    private void tbl_prepaid_paymentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prepaid_paymentsMousePressed
        popup(evt);
    }//GEN-LAST:event_tbl_prepaid_paymentsMousePressed

    private void tbl_prepaid_paymentsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prepaid_paymentsMouseReleased
        popup(evt);
    }//GEN-LAST:event_tbl_prepaid_paymentsMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        finalize_payment();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tf_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_check_noActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        select_type();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        select_type();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers(tf_customer_name);
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_nameMouseClicked
        init_customers(tf_customer_name);
    }//GEN-LAST:event_tf_customer_nameMouseClicked

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_payments_posted();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void tf_check_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_bankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_check_bankActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_prepaid_payments();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update_prepaid_payments();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete_prepaid_payments();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branches();
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branches();
    }//GEN-LAST:event_tf_from_branchActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_customers;
    private javax.swing.JTable tbl_prepaid_payments;
    private javax.swing.JTextField tf_cash;
    private javax.swing.JTextField tf_check_bank;
    private javax.swing.JTextField tf_check_no;
    private javax.swing.JTextField tf_cheque_holder;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch_id;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
        init_key();

        set_default_branch();
        focus();
        init_tbl_customers();

        init_tbl_prepaid_payments();
        data_payments();
        cursor();
        jCheckBox3.setVisible(false);
        tf_from_branch_id.setVisible(false);

        jTextField1.grabFocus();
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

        tf_from_branch.setText(to.branch);
        tf_from_branch_id.setText(to.branch_id);

        branches_list = Branches.ret_where("");
    }

    private void focus() {
        JTextField[] tf = {jTextField1, tf_cash, tf_check_bank, tf_check_no, tf_cash, tf_customer_name, tf_cheque_holder};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    private void cursor() {

    }

    public void do_pass() {
        int exists = 0;
        String where = " where user_id='" + MyUser.getUser_id() + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        for (S1_user_previleges.to_user_previleges to : datas) {
            if (to.previledge.equalsIgnoreCase("Prepaid Payment Finalize")) {
                exists = 1;
                break;
            }
        }
        if (exists == 1) {
            jCheckBox3.setVisible(true);
        }
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

    private void select_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.convertRowIndexToModel(row));
        int col = tbl_customers.getSelectedColumn();
        if (col == 4) {
            view_orders(to);
        } else {
            tf_customer_name.setText(to.customer_name);

            data_payments();
            tf_cash.grabFocus();
        }

    }

    private void view_orders(to_customers to) {
        Window p = (Window) this;
        Dlg_prepaid_payment_orders nd = Dlg_prepaid_payment_orders.create(p, true);
        nd.setTitle("");
        nd.do_pass("" + to.id, to.customer_name, to.customer_no);

        nd.setCallback(new Dlg_prepaid_payment_orders.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_prepaid_payment_orders.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private ArrayListModel tbl_customers_ALM;
    private TblcustomersModel tbl_customers_M;

    private void init_tbl_customers() {
        tbl_customers_ALM = new ArrayListModel();
        tbl_customers_M = new TblcustomersModel(tbl_customers_ALM);
        tbl_customers.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_customers.setModel(tbl_customers_M);
        tbl_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_customers.setRowHeight(25);
        int[] tbl_widths_customers = {70, 100, 100, 100, 40, 0, 0, 0, 0, 0, 0};
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
    }

    private void loadData_customers(List<to_customers> acc) {
        tbl_customers_ALM.clear();
        tbl_customers_ALM.addAll(acc);
    }

    public static class TblcustomersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "ID No.", "Name", "Branch", "Prepaid", "", "address", "term", "location", "balance", "discount", "prepaid"
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
                   return " " + tt.branch;
                case 3:
                    return FitIn.fmt_wc_0(tt.prepaid) + " ";
                case 4:
                     return " View";
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

    private void data_cols() {
        String where = " where customer_name like '%" + jTextField1.getText() + "%' and branch_id='" + tf_from_branch_id.getText() + "' order by customer_name asc ";
        if (jCheckBox4.isSelected()) {
            where = " where customer_name like '%" + jTextField1.getText() + "%' order by customer_name asc  ";
        }
        loadData_customers(Customers.ret_data2(where));
        jLabel17.setText("" + tbl_customers_ALM.size());
    }
    private ArrayListModel tbl_prepaid_payments_ALM;
    private Tblprepaid_paymentsModel tbl_prepaid_payments_M;

    private void init_tbl_prepaid_payments() {
        tbl_prepaid_payments_ALM = new ArrayListModel();
        tbl_prepaid_payments_M = new Tblprepaid_paymentsModel(tbl_prepaid_payments_ALM);
        tbl_prepaid_payments.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_prepaid_payments.setModel(tbl_prepaid_payments_M);
        tbl_prepaid_payments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_prepaid_payments.setRowHeight(25);
        int[] tbl_widths_prepaid_payments = {70, 80, 0, 0, 80, 50, 30, 0, 0};
        for (int i = 0, n = tbl_widths_prepaid_payments.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_prepaid_payments, i, tbl_widths_prepaid_payments[i]);
        }
        Dimension d = tbl_prepaid_payments.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_prepaid_payments.getTableHeader().setPreferredSize(d);
        tbl_prepaid_payments.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_prepaid_payments.setRowHeight(25);
        tbl_prepaid_payments.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_prepaid_payments, 4);
    }

    private void loadData_prepaid_payments(List<to_prepaid_payments> acc) {
        tbl_prepaid_payments_ALM.clear();
        tbl_prepaid_payments_ALM.addAll(acc);
    }

    public static class Tblprepaid_paymentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Customer", "Cash", "Check", "Total", "Status", "", "customer_name", "customer_id"
        };

        public Tblprepaid_paymentsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 6) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_prepaid_payments tt = (to_prepaid_payments) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return " " + tt.customer_name;
                case 2:
                    return FitIn.fmt_wc_0(tt.cash) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.check_amount) + " ";
                case 4:
                    if (tt.cash > 0) {
                        return FitIn.fmt_wc_0(tt.cash) + " ";
                    } else {
                        return FitIn.fmt_wc_0(tt.check_amount) + " ";
                    }

                case 5:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 6:
                    return tt.selected;
                case 7:
                    return tt.customer_name;
                default:
                    return tt.customer_id;
            }
        }
    }

    private void data_payments() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.convertRowIndexToModel(row));
        String where = " where customer_id='" + to.id + "' order by id desc ";
        loadData_prepaid_payments(Prepaid_payments.ret_data(where));
        double balance = 0;
        List<to_prepaid_payments> datas = tbl_prepaid_payments_ALM;
        for (to_prepaid_payments tp : datas) {
            balance += tp.cash + tp.check_amount;
        }
        jLabel10.setText(FitIn.fmt_wc_0(balance));
        jLabel8.setText("" + tbl_prepaid_payments_ALM.size());
    }

    private void data_payments_posted() {
        if (jCheckBox3.isSelected()) {
            String where = " where status='" + "0" + "' order by id desc ";
            loadData_prepaid_payments(Prepaid_payments.ret_data(where));
            double balance = 0;
            List<to_prepaid_payments> datas = tbl_prepaid_payments_ALM;
            for (to_prepaid_payments tp : datas) {
                balance += tp.cash + tp.check_amount;
            }
            jLabel10.setText(FitIn.fmt_wc_0(balance));
            jLabel8.setText("" + tbl_prepaid_payments_ALM.size());
        } else {
            tbl_prepaid_payments_ALM.clear();
            tbl_prepaid_payments_M.fireTableDataChanged();
            jLabel10.setText("0.00");
            jLabel8.setText("0");
        }

    }

    private void add_prepaid_payments() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.convertRowIndexToModel(row));
        int id = -1;
        double cash = FitIn.toDouble(tf_cash.getText());
        double check_amount = FitIn.toDouble(tf_cash.getText());
        if (jCheckBox1.isSelected()) {
            check_amount = 0;
        } else {
            cash = 0;
        }
        System.out.println("Cash: " + cash);
        System.out.println("Cheque: " + check_amount);

        String check_bank = tf_check_bank.getText();
        String check_no = tf_check_no.getText();
        String added_by = Users.get_UserName();
        String date_added = DateType.now();
        String customer_name = to.customer_name;
        String customer_id = "" + to.id;
        String cheque_holder = tf_cheque_holder.getText();
        String cheque_date = DateType.sf.format(jDateChooser1.getDate());
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;

        to_prepaid_payments to2 = new to_prepaid_payments(id, cash, check_bank, check_no, check_amount, added_by, date_added, customer_name, customer_id, 0, false, cheque_holder, cheque_date, user_id, user_screen_name, branch, branch_id, location, location_id);
        Prepaid_payments.add_prepaid_payments(to2);
        data_cols();
        tbl_customers.setRowSelectionInterval(row, row);
        data_payments();
        tf_cash.setText("");
        tf_check_bank.setText("");
        tf_cash.setText("");
        tf_check_no.setText("");
        tf_cash.grabFocus();
        Alert.set(1, "Payment Added");
    }

    private void update_prepaid_payments() {
        int row = tbl_prepaid_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_prepaid_payments to = (to_prepaid_payments) tbl_prepaid_payments_ALM.get(tbl_prepaid_payments.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Payment Already Finalized!");
            return;
        }
        int id = to.id;
        double cash = FitIn.toDouble(tf_cash.getText());
        String check_bank = tf_check_bank.getText();
        String check_no = tf_check_no.getText();
        double check_amount = FitIn.toDouble(tf_cash.getText());
        if (jCheckBox1.isSelected()) {
            check_amount = 0;
        } else {
            cash = 0;
        }
        String added_by = Users.get_UserName();
        String date_added = DateType.now();
        String customer_name = to.customer_name;
        String customer_id = "" + to.id;
        String cheque_holder = tf_cheque_holder.getText();
        String cheque_date = DateType.sf.format(jDateChooser1.getDate());
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        to_prepaid_payments to2 = new to_prepaid_payments(id, cash, check_bank, check_no, check_amount, added_by, date_added, customer_name, customer_id, 0, false, cheque_holder, cheque_date, to.user_id, to.user_screen_name, branch, branch_id, location, location_id);
        Prepaid_payments.edit_prepaid_payments(to2);
        data_cols();
        tbl_customers.setRowSelectionInterval(row, row);
        data_payments();
        tf_cash.setText("");
        tf_check_bank.setText("");
        tf_cash.setText("");
        tf_check_no.setText("");
        tf_cash.grabFocus();
        Alert.set(2, "Payment Added");
    }

    private void select_prepaid_payments() {
        int row = tbl_prepaid_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_prepaid_payments.getSelectedColumn();
        to_prepaid_payments to = (to_prepaid_payments) tbl_prepaid_payments_ALM.get(tbl_prepaid_payments.convertRowIndexToModel(row));
        if (col == 6) {
            if (to.selected == true) {
                to.setSelected(false);
            } else {
                if (to.status == 1) {
                    Alert.set(0, "Already Finalized!");
                    return;
                }
                to.setSelected(true);
            }
            tbl_prepaid_payments_M.fireTableDataChanged();
        } else {

            if (to.cash > 0) {
                tf_cash.setText(FitIn.fmt_wc_0(to.cash));
                tf_customer_name.setEnabled(true);
                tf_cheque_holder.setEnabled(false);
                tf_check_bank.setEnabled(false);
                tf_check_no.setEnabled(false);
                jDateChooser1.setEnabled(false);
            } else {
                tf_cash.setText(FitIn.fmt_wc_0(to.check_amount));
                tf_cheque_holder.setEnabled(true);
                tf_check_bank.setEnabled(true);
                tf_check_no.setEnabled(true);
                jDateChooser1.setEnabled(true);
                tf_customer_name.setEnabled(false);
                tf_customer_name.setText("");
            }
            tf_check_bank.setText(to.check_bank);
            tf_check_no.setText(to.check_no);
            tf_cash.setText(FitIn.fmt_wc_0(to.check_amount));
            tf_customer_name.setText(to.customer_name);
            try {
                Date d = DateType.sf.parse(to.cheque_date);
                jDateChooser1.setDate(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_prepaid_payments.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void delete_prepaid_payments() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                int row = tbl_prepaid_payments.getSelectedRow();
                if (row < 0) {
                    return;
                }

                to_prepaid_payments to = (to_prepaid_payments) tbl_prepaid_payments_ALM.get(tbl_prepaid_payments.convertRowIndexToModel(row));
                if (to.status == 1) {
                    Alert.set(0, "Payment Already Finalized!");
                    return;
                }
                Prepaid_payments.delete_prepaid_payments(to);
                data_payments();
                Alert.set(3, "Payment Added");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void finalize_payment() {

        List<to_prepaid_payments> datas = tbl_prepaid_payments_ALM;
        final List<to_prepaid_payments> selected = new ArrayList();
        for (to_prepaid_payments to : datas) {
            if (to.selected == true && to.status == 0) {
                selected.add(to);
            }
        }
        final int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.OutputData data) {
                closeDialog.ok();

                Prepaid_payments.finalize(selected);
                data_cols();
                tbl_customers.setRowSelectionInterval(row, row);
                data_payments();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);
    }

    private void popup(MouseEvent evt) {

        if (evt.isPopupTrigger()) {
            int exists = 0;
            String where = " where user_id='" + MyUser.getUser_id() + "' order by previledge asc";
            List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
            for (S1_user_previleges.to_user_previleges to : datas) {
                if (to.previledge.equalsIgnoreCase("Prepaid Payment Finalize")) {
                    exists = 1;
                    break;
                }
            }
            if (exists == 1) {
                jPopupMenu1.show(tbl_prepaid_payments, evt.getX(), evt.getY());
            }

        }
    }

    private void select_type() {
        if (jCheckBox1.isSelected()) {
            tf_customer_name.setEnabled(true);
            tf_cheque_holder.setEnabled(false);
            tf_check_bank.setEnabled(false);
            tf_check_no.setEnabled(false);
            jDateChooser1.setEnabled(false);

            tf_cheque_holder.setText("");
            tf_check_bank.setText("");
            tf_check_no.setText("");
        } else {

            tf_cheque_holder.setEnabled(true);
            tf_check_bank.setEnabled(true);
            tf_check_no.setEnabled(true);
            jDateChooser1.setEnabled(true);
            tf_customer_name.setEnabled(false);
            tf_customer_name.setText("");
        }
    }

    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_customers(final JTextField tf) {
        String search = tf.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' order by customer_name asc";
        customer_list = Customers.ret_data3(where);
        Object[][] obj = new Object[customer_list.size()][1];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Search f = (Field.Search) tf;
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf.setText(to.customer_name);
                f.setId("" + to.id);
            }
        });
    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches() {
        final Field.Combo br = (Field.Combo) tf_from_branch;
        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (Branches.to_branches to : branches_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.branch;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Branch"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Branches.to_branches to = branches_list.
                        get(data.selected_row);
                br.setText(to.branch);
                br.setId("" + to.id);

            }
        });
    }
}
