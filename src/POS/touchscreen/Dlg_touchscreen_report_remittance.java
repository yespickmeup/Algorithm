/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.banks.Banks;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.cash_drawer.CashDrawer_remittances;
import POS.cash_drawer.CashDrawer_tables;
import POS.users.MyUser;
import POS.users.S1_users;
import POS.util.DateType;
import POS.util.TableRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import POS.util.Alert;
import java.awt.Window;
import POS.util.Dlg_confirm_action;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_report_remittance extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_report_remittance
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
    private Dlg_touchscreen_report_remittance(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_report_remittance(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_report_remittance() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_report_remittance myRef;

    private void setThisRef(Dlg_touchscreen_report_remittance myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_report_remittance> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_report_remittance create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_report_remittance create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_report_remittance dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_report_remittance((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_report_remittance dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_report_remittance((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_report_remittance dialog = Dlg_touchscreen_report_remittance.create(new javax.swing.JFrame(), true);
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
        pnl_remittance = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        tf_cheque_no2 = new Field.Input();
        jLabel91 = new javax.swing.JLabel();
        tf_cheque_bank2 = new Field.Combo();
        jButton59 = new Button.Warning();
        jButton60 = new Button.Info();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel93 = new javax.swing.JLabel();
        tf_remit_amount = new Field.Input();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        tf_check_holder1 = new Field.Input();
        jCheckBox6 = new javax.swing.JCheckBox();
        jButton62 = new Button.Primary();
        jLabel97 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl_cash_drawer_remittances = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        tf_cashier = new Field.Combo();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_remittance.setBackground(new java.awt.Color(255, 255, 255));

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel90.setText("Cheque Date:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setEnabled(false);
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_cheque_no2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_no2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_no2.setEnabled(false);
        tf_cheque_no2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_no2ActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel91.setText("Amount:");

        tf_cheque_bank2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_bank2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_bank2.setEnabled(false);
        tf_cheque_bank2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cheque_bank2MouseClicked(evt);
            }
        });
        tf_cheque_bank2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_bank2ActionPerformed(evt);
            }
        });

        jButton59.setText("Delete");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setText("Update");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Cheque");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel93.setText("Cheque No:");

        tf_remit_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remit_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel94.setText("Cheque Holder:");

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel95.setText("Bank:");

        tf_check_holder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_holder1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_check_holder1.setEnabled(false);

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Cash");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jButton62.setText("Add");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel97.setText("Trans Type:");

        tbl_cash_drawer_remittances.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_remittances.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_remittancesMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tbl_cash_drawer_remittances);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cashier:");

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        jLabel3.setText("0.00");

        jLabel4.setText("Cash:");

        jLabel5.setText("0.00");

        jLabel7.setText("Cheque:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_cashier, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1))
                    .addComponent(tf_cashier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_remittanceLayout = new javax.swing.GroupLayout(pnl_remittance);
        pnl_remittance.setLayout(pnl_remittanceLayout);
        pnl_remittanceLayout.setHorizontalGroup(
            pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_remittanceLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnl_remittanceLayout.createSequentialGroup()
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(tf_remit_amount))
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5)
                                .addGap(164, 164, 164))
                            .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnl_remittanceLayout.createSequentialGroup()
                            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tf_check_holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_remittanceLayout.createSequentialGroup()
                            .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_cheque_bank2)
                                .addComponent(tf_cheque_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnl_remittanceLayout.createSequentialGroup()
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_remittanceLayout.setVerticalGroup(
            pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_remittanceLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_remittanceLayout.createSequentialGroup()
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_check_holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_cheque_bank2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cheque_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_remit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 208, Short.MAX_VALUE))
                    .addGroup(pnl_remittanceLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_remittance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_remittance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_cheque_no2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_no2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cheque_no2ActionPerformed

    private void tf_cheque_bank2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cheque_bank2MouseClicked
        init_banks(tf_cheque_bank2);
    }//GEN-LAST:event_tf_cheque_bank2MouseClicked

    private void tf_cheque_bank2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_bank2ActionPerformed
        init_banks(tf_cheque_bank2);
    }//GEN-LAST:event_tf_cheque_bank2ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        delete_cash_drawer_remittances();
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        update_cash_drawer_remittances();
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        init_remit_type();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        init_remit_type();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        add_cash_drawer_remittances();
    }//GEN-LAST:event_jButton62ActionPerformed

    private void tbl_cash_drawer_remittancesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_remittancesMouseClicked
        select_cash_drawer_remittances();
    }//GEN-LAST:event_tbl_cash_drawer_remittancesMouseClicked

    private void tf_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashierMouseClicked
        init_cashier();
    }//GEN-LAST:event_tf_cashierMouseClicked

    private void tf_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashierActionPerformed
        init_cashier();
    }//GEN-LAST:event_tf_cashierActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        ret_cash_drawer_remit();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton62;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JPanel pnl_remittance;
    private javax.swing.JTable tbl_cash_drawer_remittances;
    private javax.swing.JTextField tf_cashier;
    private javax.swing.JTextField tf_check_holder1;
    private javax.swing.JTextField tf_cheque_bank2;
    private javax.swing.JTextField tf_cheque_no2;
    private javax.swing.JTextField tf_remit_amount;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        String where = "  order by bank_name asc";
        bank_list = Banks.ret_data2(where);
        CashDrawer_tables.init_tbl_cash_drawer_remittances(tbl_cash_drawer_remittances);
        set_default_branch();

        String where2 = "  order by screen_name asc";
        user_list = MyUser.ret_data(where2);
        Field.Combo user = (Field.Combo) tf_cashier;
        user.setText(MyUser.getUser_screen_name());
        user.setId(MyUser.getUser_id());

        ret_cash_drawer_remit();
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
    private void init_remit_type() {
        if (jCheckBox6.isSelected()) {
            tf_check_holder1.setEnabled(false);
            tf_cheque_bank2.setEnabled(false);
            tf_cheque_no2.setEnabled(false);
            jDateChooser4.setEnabled(false);
            tf_check_holder1.setText("");
            tf_cheque_no2.setText("");
        } else {
            tf_check_holder1.setEnabled(true);
            tf_cheque_bank2.setEnabled(true);
            tf_cheque_no2.setEnabled(true);
            jDateChooser4.setEnabled(true);
        }
    }
    List<Banks.to_banks> bank_list = new ArrayList();

    private void init_banks(final JTextField tf) {
        String search = tf.getText();

        Object[][] obj = new Object[bank_list.size()][1];
        int i = 0;
        for (Banks.to_banks to : bank_list) {
            obj[i][0] = " " + to.bank_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Banks.to_banks to = bank_list.get(data.selected_row);
                tf.setText(to.bank_name);
            }
        });
    }

    private void add_cash_drawer_remittances() {

        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        double cash_amount = FitIn.toDouble(tf_remit_amount.getText());
        double cheque_amount = FitIn.toDouble(tf_remit_amount.getText());
        String cheque_holder = tf_check_holder1.getText();
        String cheque_bank = tf_cheque_bank2.getText();
        String cheque_no = tf_cheque_no2.getText();
        String cheque_date = DateType.sf.format(jDateChooser4.getDate());
        int status = 0;
        if (jCheckBox6.isSelected()) {
            cheque_amount = 0;
        } else {
            cash_amount = 0;
        }
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        CashDrawer_remittances.to_cash_drawer_remittances to = new CashDrawer_remittances.to_cash_drawer_remittances(id, user_id, user_screen_name, date_added, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, status, branch, branch_id, location, location_id);
        CashDrawer_remittances.add_data(to);

        tf_check_holder1.setText("");
        tf_cheque_bank2.setText("");
        tf_cheque_no2.setText("");
        tf_remit_amount.setText("");
        ret_cash_drawer_remit();
    }

    private void select_cash_drawer_remittances() {

        int row = tbl_cash_drawer_remittances.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_remittances.to_cash_drawer_remittances to = (CashDrawer_remittances.to_cash_drawer_remittances) CashDrawer_tables.tbl_cash_drawer_remittances_ALM.get(row);
        try {
            Date d = DateType.sf.parse(to.cheque_date);
            jDateChooser4.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_touchscreen_cashcount.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (to.cash_amount > 0) {
            tf_remit_amount.setText(FitIn.fmt_wc_0(to.cash_amount));
        } else {
            tf_remit_amount.setText(FitIn.fmt_wc_0(to.cheque_amount));
        }
        tf_check_holder1.setText(to.cheque_holder);
        tf_cheque_bank2.setText(to.cheque_bank);
        tf_cheque_no2.setText(to.cheque_no);

    }

    private void update_cash_drawer_remittances() {

        int row = tbl_cash_drawer_remittances.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_remittances.to_cash_drawer_remittances to = (CashDrawer_remittances.to_cash_drawer_remittances) CashDrawer_tables.tbl_cash_drawer_remittances_ALM.get(row);

        int id = to.id;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        double cash_amount = FitIn.toDouble(tf_remit_amount.getText());
        double cheque_amount = FitIn.toDouble(tf_remit_amount.getText());
        String cheque_holder = tf_check_holder1.getText();
        String cheque_bank = tf_cheque_bank2.getText();
        String cheque_no = tf_cheque_no2.getText();
        String cheque_date = DateType.sf.format(jDateChooser4.getDate());
        int status = 0;
        if (jCheckBox6.isSelected()) {
            cheque_amount = 0;
        } else {
            cash_amount = 0;
        }
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        CashDrawer_remittances.to_cash_drawer_remittances to1 = new CashDrawer_remittances.to_cash_drawer_remittances(id, user_id, user_screen_name, date_added, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, status, branch, branch_id, location, location_id);

        if (!user_id.equalsIgnoreCase(to.user_id)) {
            Alert.set(0, "You cannot edit this entry!");
            return;
        }
        CashDrawer_remittances.update_data(to1);
        tf_check_holder1.setText("");
        tf_cheque_bank2.setText("");
        tf_cheque_no2.setText("");
        tf_remit_amount.setText("");
        ret_cash_drawer_remit();

    }

    private void delete_cash_drawer_remittances() {

        final int row = tbl_cash_drawer_remittances.getSelectedRow();
        if (row < 0) {
            return;
        }
       
        CashDrawer_remittances.to_cash_drawer_remittances to = (CashDrawer_remittances.to_cash_drawer_remittances) CashDrawer_tables.tbl_cash_drawer_remittances_ALM.get(row);
        String user_id = MyUser.getUser_id();
        if (!user_id.equalsIgnoreCase(to.user_id)) {
            Alert.set(0, "You cannot edit this entry!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                CashDrawer_remittances.to_cash_drawer_remittances to = (CashDrawer_remittances.to_cash_drawer_remittances) CashDrawer_tables.tbl_cash_drawer_remittances_ALM.get(row);
                CashDrawer_remittances.delete_data(to);
                tf_check_holder1.setText("");
                tf_cheque_bank2.setText("");
                tf_cheque_no2.setText("");
                tf_remit_amount.setText("");
                ret_cash_drawer_remit();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void ret_cash_drawer_remit() {
        Field.Combo cashier = (Field.Combo) tf_cashier;

        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where  Date(date_added)='" + date + "' ";

        if (!jCheckBox1.isSelected()) {
            where = where + " and user_id='" + cashier.getId() + "'";
        }

        List<CashDrawer_remittances.to_cash_drawer_remittances> datas = CashDrawer_remittances.ret_data(where);
        CashDrawer_tables.loadData_cash_drawer_remittances(datas);

        double cash = 0;
        double cheque = 0;
        jLabel2.setText("" + datas.size());
        for (CashDrawer_remittances.to_cash_drawer_remittances rem : datas) {
            cash += rem.cash_amount;
            cheque += rem.cheque_amount;
        }
    }

    List<S1_users.to_users> user_list = new ArrayList();

    private void init_cashier() {
        String search = tf_cashier.getText();

        Object[][] obj = new Object[user_list.size()][1];
        int i = 0;
        for (S1_users.to_users to : user_list) {

            obj[i][0] = " " + to.screen_name;

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_cashier.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_cashier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo f = (Field.Combo) tf_cashier;
                S1_users.to_users to = (S1_users.to_users) user_list.get(data.selected_row);
                tf_cashier.setText(to.screen_name);
                f.setId("" + to.id);
                ret_cash_drawer_remit();
            }
        });
    }

}
