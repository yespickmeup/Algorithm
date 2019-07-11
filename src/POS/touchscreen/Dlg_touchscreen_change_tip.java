/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.customers.Customers;
import POS.item_replacements.Dlg_item_replacement_search_ar;
import POS.util.TableRenderer;
import java.awt.Window;
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
 * @author Ronescape
 */
public class Dlg_touchscreen_change_tip extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_change_tip
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

        public final double tip;
        public final String prepaid_customer_name;
        public final String prepaid_customer_id;
        public final double prepaid_amount;
        public final String charge_reference_no;
        public final String charge_ar_no;
        public final String charge_type;
        public final String charge_customer_name;
        public final String charge_customer_id;
        public final double charge_amount;
        public final int charge_days;
        public final double to_deduct;

        public OutputData(double tip, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String charge_reference_no, String charge_ar_no, String charge_type, String charge_customer_name, String charge_customer_id, double charge_amount, int charge_days, double to_deduct) {
            this.tip = tip;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.charge_reference_no = charge_reference_no;
            this.charge_ar_no = charge_ar_no;
            this.charge_type = charge_type;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.charge_days = charge_days;
            this.to_deduct = to_deduct;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_change_tip(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_change_tip(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_change_tip() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_change_tip myRef;

    private void setThisRef(Dlg_touchscreen_change_tip myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_change_tip> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_change_tip create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_change_tip create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_change_tip dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_change_tip((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_change_tip dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_change_tip((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_change_tip dialog = Dlg_touchscreen_change_tip.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_cash = new Field.Input();
        jPanel3 = new javax.swing.JPanel();
        tf_customer_name = new Field.Combo();
        jLabel13 = new javax.swing.JLabel();
        tf_customer_id = new Field.Input();
        jLabel14 = new javax.swing.JLabel();
        tf_balance = new Field.Input();
        jLabel16 = new javax.swing.JLabel();
        tf_amount1 = new Field.Input();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tf_charge_type = new Field.Combo();
        jLabel25 = new javax.swing.JLabel();
        tf_charge_type1 = new Field.Search();
        jLabel36 = new javax.swing.JLabel();
        tf_reference_no = new Field.Input();
        jLabel26 = new javax.swing.JLabel();
        tf_customer_name1 = new Field.Input();
        jLabel27 = new javax.swing.JLabel();
        tf_customer_id1 = new Field.Input();
        jLabel28 = new javax.swing.JLabel();
        tf_amount2 = new Field.Input();
        jLabel29 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_tendered = new javax.swing.JTextField();
        jButton2 = new Button.Default();
        jButton1 = new Button.Success();
        jLabel20 = new javax.swing.JLabel();
        tf_tendered1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_tendered2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Amount:");

        tf_cash.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashActionPerformed(evt);
            }
        });
        tf_cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cashKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tip", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Customer Name");

        tf_customer_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_id.setFocusable(false);
        tf_customer_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_idActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Customer Id:");

        tf_balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_balance.setFocusable(false);
        tf_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_balanceActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Balance");

        tf_amount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Amount:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_id)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_name)
                    .addComponent(tf_amount1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_balance)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addGap(5, 5, 5)
                .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14)
                .addGap(5, 5, 5)
                .addComponent(tf_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addGap(25, 25, 25)
                .addComponent(tf_amount1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel17)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prepaid", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tf_charge_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_charge_type.setFocusable(false);
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

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Charge Type:");

        tf_charge_type1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_charge_type1.setFocusable(false);
        tf_charge_type1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_charge_type1MouseClicked(evt);
            }
        });
        tf_charge_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_charge_type1ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("AR Transaction No.");

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_reference_no.setFocusable(false);
        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Reference No:");

        tf_customer_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name1.setFocusable(false);
        tf_customer_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_name1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Customer Name:");

        tf_customer_id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_id1.setFocusable(false);
        tf_customer_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_id1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Customer Id:");

        tf_amount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amount2ActionPerformed(evt);
            }
        });
        tf_amount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amount2KeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Amount:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(tf_amount2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(91, 91, 91))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_reference_no)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_customer_name1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_customer_id1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(tf_charge_type))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_charge_type1)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(89, 89, 89))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tf_charge_type, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tf_charge_type1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_customer_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel27)
                .addGap(13, 13, 13)
                .addComponent(tf_customer_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_amount2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel29)
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("AR Payment", jPanel4);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Total Tendered:");

        tf_tendered.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_tendered.setText("0.00");
        tf_tendered.setFocusable(false);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Change:");

        tf_tendered1.setBackground(new java.awt.Color(4, 176, 217));
        tf_tendered1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_tendered1.setText("0.00");
        tf_tendered1.setFocusable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("To Deduct:");

        tf_tendered2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_tendered2.setText("0.00");
        tf_tendered2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tendered2ActionPerformed(evt);
            }
        });
        tf_tendered2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_tendered2KeyReleased(evt);
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
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_tendered2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_tendered1))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_tendered)))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_tendered1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tendered2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tendered, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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

    private void tf_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashActionPerformed
        count_tendered();
    }//GEN-LAST:event_tf_cashActionPerformed

    private void tf_cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cashKeyReleased
        count_tendered();
    }//GEN-LAST:event_tf_cashKeyReleased

    private void tf_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_nameMouseClicked
        init_customers();
    }//GEN-LAST:event_tf_customer_nameMouseClicked

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_customer_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_idActionPerformed

    private void tf_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_balanceActionPerformed

    private void tf_amount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount1ActionPerformed
        count_tendered();
    }//GEN-LAST:event_tf_amount1ActionPerformed

    private void tf_amount1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount1KeyReleased
        count_tendered();
    }//GEN-LAST:event_tf_amount1KeyReleased

    private void tf_charge_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_charge_typeMouseClicked
//        init_charge_types();
    }//GEN-LAST:event_tf_charge_typeMouseClicked

    private void tf_charge_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_charge_typeActionPerformed
//        init_charge_types();
    }//GEN-LAST:event_tf_charge_typeActionPerformed

    private void tf_charge_type1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_charge_type1MouseClicked
        search_ar();
    }//GEN-LAST:event_tf_charge_type1MouseClicked

    private void tf_charge_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_charge_type1ActionPerformed
        search_ar();
    }//GEN-LAST:event_tf_charge_type1ActionPerformed

    private void tf_reference_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reference_noActionPerformed
        tf_customer_name.grabFocus();
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_customer_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_name1ActionPerformed
//        init_customers_charge();
    }//GEN-LAST:event_tf_customer_name1ActionPerformed

    private void tf_customer_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_id1ActionPerformed

    private void tf_amount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount2ActionPerformed
        count_tendered();
    }//GEN-LAST:event_tf_amount2ActionPerformed

    private void tf_amount2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount2KeyReleased
        count_tendered();
    }//GEN-LAST:event_tf_amount2KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_tendered2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_tendered2KeyReleased
        type_to_deduct();
    }//GEN-LAST:event_tf_tendered2KeyReleased

    private void tf_tendered2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tendered2ActionPerformed
        type_to_deduct();
    }//GEN-LAST:event_tf_tendered2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField tf_amount1;
    private javax.swing.JTextField tf_amount2;
    private javax.swing.JTextField tf_balance;
    private javax.swing.JTextField tf_cash;
    private javax.swing.JTextField tf_charge_type;
    private javax.swing.JTextField tf_charge_type1;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_id1;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_customer_name1;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTextField tf_tendered;
    private javax.swing.JTextField tf_tendered1;
    private javax.swing.JTextField tf_tendered2;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
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

    double total_change = 0;

    public void do_pass(double change) {
        total_change = change;
        tf_tendered1.setText(FitIn.fmt_wc_0(change));
        tf_tendered2.setText(FitIn.fmt_wc_0(change));
        tf_tendered2.grabFocus();
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
            obj[i][1] = " " + FitIn.fmt_wc_0(to.prepaid);
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
                tf_customer_id.setText("" + to.id);
                tf_balance.setText(FitIn.fmt_wc_0(to.prepaid));
                tf_amount1.grabFocus();

            }
        });
    }

    private void count_tendered() {
        double tip = FitIn.toDouble(tf_cash.getText());
        double prepaid = FitIn.toDouble(tf_amount1.getText());
        double ar_payment = FitIn.toDouble(tf_amount2.getText());
        double to_deduct = FitIn.toDouble(tf_tendered2.getText());
        double tendered = tip + prepaid + ar_payment;
        tf_tendered.setText(FitIn.fmt_wc_0(tendered));
        if (tendered > to_deduct) {
            tf_tendered.setText(FitIn.fmt_wc_0(to_deduct));
            if (tf_cash.hasFocus()) {
                double t_tip = to_deduct - (prepaid + ar_payment);
                tf_cash.setText(FitIn.fmt_wc_0(t_tip));
            }
            if (tf_amount1.hasFocus()) {
                double t_tip = to_deduct - (tip + ar_payment);
                tf_amount1.setText(FitIn.fmt_wc_0(t_tip));
            }
            if (tf_amount2.hasFocus()) {
                double t_tip = to_deduct - (tip + prepaid);
                tf_amount2.setText(FitIn.fmt_wc_0(t_tip));
            }
        }

    }

    private void search_ar() {
        Window p = (Window) this;
        Dlg_item_replacement_search_ar nd = Dlg_item_replacement_search_ar.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_item_replacement_search_ar.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_item_replacement_search_ar.OutputData data) {
                closeDialog.ok();
                tf_charge_type.setText(data.to.soa_type);
                tf_charge_type1.setText(data.to.ar_no);
                tf_reference_no.setText(data.to.reference_no);
                tf_customer_name1.setText(data.to.customer_name);
                tf_customer_id1.setText(data.to.customer_id);
//                tf_amount3.setText("" + data.to.term);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ok() {
        double tip = FitIn.toDouble(tf_cash.getText());
        String prepaid_customer_name = tf_customer_name.getText();
        String prepaid_customer_id = tf_customer_id.getText();
        double prepaid_amount = FitIn.toDouble(tf_amount1.getText());
        String charge_reference_no = tf_reference_no.getText();
        String charge_ar_no = tf_charge_type1.getText();
        String charge_type = tf_charge_type.getText();
        String charge_customer_name = tf_customer_name1.getText();
        String charge_customer_id = tf_customer_id1.getText();
        double charge_amount = FitIn.toDouble(tf_amount2.getText());
        double to_deduct = FitIn.toDouble(tf_tendered2.getText());
        int charge_days = 30;
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(tip, prepaid_customer_name, prepaid_customer_id, prepaid_amount, charge_reference_no, charge_ar_no, charge_type, charge_customer_name, charge_customer_id, charge_amount, charge_days, to_deduct));
        }
    }

    private void type_to_deduct() {
        double to_deduct = FitIn.toDouble(tf_tendered2.getText());
        double change = FitIn.toDouble(tf_tendered1.getText());
        if (to_deduct > change) {
            tf_tendered2.setText(FitIn.fmt_wc_0(change));
        }
    }
}
