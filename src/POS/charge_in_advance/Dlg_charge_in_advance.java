/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.charge_in_advance;

import POS.accounts_receivable.S1_accounts_receivable;
import POS.charge_in_advance.Charge_in_advance_items.to_charge_in_advance_items;
import POS.delivery.Dlg_delivery_print_preview;
import POS.inventory.Inventory_barcodes;
import POS.touchscreen.Payments;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.LostHeaderRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
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
public class Dlg_charge_in_advance extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_charge_in_advance
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
    private Dlg_charge_in_advance(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_charge_in_advance(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_charge_in_advance() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_charge_in_advance myRef;

    private void setThisRef(Dlg_charge_in_advance myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_charge_in_advance> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_charge_in_advance create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_charge_in_advance create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_charge_in_advance dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_charge_in_advance((java.awt.Frame) parent, false);
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
            Dlg_charge_in_advance dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_charge_in_advance((java.awt.Dialog) parent, false);
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

        Dlg_charge_in_advance dialog = Dlg_charge_in_advance.create(new javax.swing.JFrame(), true);
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
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new Field.Input();
        jp = new javax.swing.JScrollPane();
        tbl_charge_in_advance_items = new javax.swing.JTable();
        jButton5 = new Button.Success();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new Field.Input();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new Field.Input();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new Field.Input();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new Field.Input();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new Field.Input();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new Field.Input();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new Field.Input();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new Field.Input();
        jButton1 = new Button.Default();
        jButton2 = new Button.Default();
        jTextField11 = new Field.Input();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lbl_sub_total1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_line_discount1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_line_discount = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_due_discount = new Label.Item_discount();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_balance_due = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        lbl_due_discount1 = new Label.Item_discount();
        lbl_sub_total2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Customer:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setFocusable(false);

        tbl_charge_in_advance_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_charge_in_advance_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_charge_in_advance_itemsMouseClicked(evt);
            }
        });
        jp.setViewportView(tbl_charge_in_advance_items);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/binary5.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("AR No:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Date Applied:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Term:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Amount:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Paid:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Balance:");

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField8.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Type:");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Created by:");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setFocusable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/shopping73.png"))); // NOI18N
        jButton1.setToolTipText("ADD ITEM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/print44.png"))); // NOI18N
        jButton2.setToolTipText("PRINT PREVIEW");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Reference No:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Gross Total");

        lbl_sub_total1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_sub_total1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_sub_total1.setText("0.00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Addtl. Amount    :");

        lbl_line_discount1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_line_discount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_line_discount1.setText("0.00");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Line Discount");

        lbl_line_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_line_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_line_discount.setText("0.00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Due Discount");

        lbl_due_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_due_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_due_discount.setText("0.00");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("No of Items");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Witholding Tax");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Total:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Balance Due:");

        lbl_balance_due.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_balance_due.setForeground(java.awt.Color.red);
        lbl_balance_due.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance_due.setText("0.00");
        lbl_balance_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0.00");
        lbl_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_due_discount1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_due_discount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_due_discount1.setText("0.00");

        lbl_sub_total2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_sub_total2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_sub_total2.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(145, 145, 145))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_total, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_line_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_due_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_line_discount1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_sub_total2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_due_discount1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_sub_total1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lbl_balance_due, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbl_sub_total1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(lbl_sub_total2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbl_line_discount))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_due_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_due_discount1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lbl_line_discount1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_balance_due, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jp, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField8)
                                    .addComponent(jTextField10)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dlg_ar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dlg_item_search();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        preview_dr();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_charge_in_advance_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_charge_in_advance_itemsMouseClicked
        cancel_item();
    }//GEN-LAST:event_tbl_charge_in_advance_itemsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JScrollPane jp;
    private javax.swing.JLabel lbl_balance_due;
    private javax.swing.JLabel lbl_due_discount;
    private javax.swing.JLabel lbl_due_discount1;
    private javax.swing.JLabel lbl_line_discount;
    private javax.swing.JLabel lbl_line_discount1;
    private javax.swing.JLabel lbl_sub_total1;
    private javax.swing.JLabel lbl_sub_total2;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_charge_in_advance_items;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_charge_in_advance_items(tbl_charge_in_advance_items);
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

    S1_accounts_receivable.to_accounts_receivable ar = null;

    private void dlg_ar() {
        Window p = (Window) this;
        Dlg_ar_search nd = Dlg_ar_search.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_ar_search.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_search.OutputData data) {
                closeDialog.ok();
                Field.Input customer = (Field.Input) jTextField2;

                ar = data.ar;
                jTextField3.setText(ar.ar_no);
                customer.setText(ar.customer_name);
                customer.setId(ar.customer_id);
                jTextField4.setText(DateType.convert_slash_datetime2(ar.date_applied));
                jTextField5.setText("" + FitIn.fmt_woc(ar.term) + " day/s");
                jTextField9.setText(ar.soa_type);
                jTextField10.setText(ar.user_screen_name);
                jTextField6.setText(FitIn.fmt_wc_0(ar.amount));
                jTextField7.setText(FitIn.fmt_wc_0(ar.paid));
                jTextField8.setText(FitIn.fmt_wc_0(ar.amount - ar.paid));
                String reference = ar.ci_no + ar.trust_receipt;
                if (!reference.equalsIgnoreCase(ar.reference_no)) {
                    reference = ar.reference_no;
                }
                jTextField11.setText(reference);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void dlg_item_search() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Charge In Advance - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        if (ar == null) {
            Alert.set(0, "Please Select AR Transaction!");
            return;
        }
        Window p = (Window) this;
        Dlg_charge_in_advance_add_item nd = Dlg_charge_in_advance_add_item.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_charge_in_advance_add_item.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_charge_in_advance_add_item.OutputData data) {
                closeDialog.ok();
                List<Inventory_barcodes.to_inventory_barcodes> datas = data.fields;
                List<to_charge_in_advance_items> fields = new ArrayList();
                for (Inventory_barcodes.to_inventory_barcodes to : datas) {
                    int id = 0;
                    String customer_id = ar.customer_id;
                    String customer_name = ar.customer_name;
                    String ar_id = "" + ar.id;
                    String ar_no = ar.ar_no;
                    String date_applied = ar.date_applied;
                    String reference_no = ar.reference_no;
                    String soa_type = ar.soa_type;
                    String soa_type_id = ar.soa_type_id;
                    String user_screen_name = MyUser.getUser_id();
                    String user_id = MyUser.getUser_screen_name();
                    String remarks = "";
                    String item_code = to.main_barcode;
                    String barcode = to.barcode;
                    String description = to.description;
                    String generic_name = to.generic_name;
                    String item_type = to.item_type;
                    String supplier_name = to.supplier;
                    String supplier_id = to.supplier_id;
                    String serial_no = "";
                    double product_qty = to.product_qty;
                    String unit = to.unit;
                    double conversion = to.conversion;
                    double selling_price = to.selling_price;
                    String date_added = DateType.now();
                    int status = 0;
                    int is_vatable = to.vatable;
                    int selling_type = to.selling_type;
                    String discount_name = to.discount_name;
                    double discount_rate = to.discount;
                    double discount_amount = to.discount_amount;
                    String discount_customer_name = to.discount_customer_name;
                    String discount_customer_id = to.discount_customer_id;
                    String branch = to.branch;
                    String branch_code = to.branch_code;
                    String location = to.location;
                    String location_id = to.location_id;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_classification = to.sub_classification;
                    String sub_classification_id = to.sub_classification_id;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    double addtl_amount = to.addtl_amount;
                    double wtax = to.wtax;

                    to_charge_in_advance_items field = new to_charge_in_advance_items(id, customer_id, customer_name, ar_id, ar_no, date_applied, reference_no, soa_type, soa_type_id, user_screen_name, user_id, remarks, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, addtl_amount, wtax);
                    fields.add(field);
                }
                Charge_in_advance_items.add_data(fields);
                data_cols();
                Alert.set(1, "");
            }
        }
        );
        nd.setLocationRelativeTo(
                this);
        nd.setVisible(
                true);
    }

    //<editor-fold defaultstate="collapsed" desc=" charge_in_advance_items "> 
    public static ArrayListModel tbl_charge_in_advance_items_ALM;
    public static Tblcharge_in_advance_itemsModel tbl_charge_in_advance_items_M;

    public static void init_tbl_charge_in_advance_items(JTable tbl_charge_in_advance_items) {
        tbl_charge_in_advance_items_ALM = new ArrayListModel();
        tbl_charge_in_advance_items_M = new Tblcharge_in_advance_itemsModel(tbl_charge_in_advance_items_ALM);
        tbl_charge_in_advance_items.setModel(tbl_charge_in_advance_items_M);
        tbl_charge_in_advance_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_charge_in_advance_items.setRowHeight(25);
        int[] tbl_widths_charge_in_advance_items = {100, 40, 40, 50, 80, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_charge_in_advance_items.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_charge_in_advance_items, i, tbl_widths_charge_in_advance_items[i]);
        }
        Dimension d = tbl_charge_in_advance_items.getTableHeader().getPreferredSize();
        d.height = 35;
        tbl_charge_in_advance_items.getTableHeader().setPreferredSize(d);
        tbl_charge_in_advance_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));
        tbl_charge_in_advance_items.setRowHeight(35);
        tbl_charge_in_advance_items.setFont(new java.awt.Font("Arial", 0, 14));
        TableWidthUtilities.setColumnRightRenderer(tbl_charge_in_advance_items, 4);
        tbl_charge_in_advance_items.getColumnModel().getColumn(0).setHeaderRenderer(new LostHeaderRenderer());
        tbl_charge_in_advance_items.getColumnModel().getColumn(1).setHeaderRenderer(new LostHeaderRenderer());
        tbl_charge_in_advance_items.getColumnModel().getColumn(2).setHeaderRenderer(new LostHeaderRenderer());
        tbl_charge_in_advance_items.getColumnModel().getColumn(3).setHeaderRenderer(new LostHeaderRenderer());
        tbl_charge_in_advance_items.getColumnModel().getColumn(4).setHeaderRenderer(new LostHeaderRenderer());
    }

    public static void loadData_charge_in_advance_items(List<to_charge_in_advance_items> acc) {
        tbl_charge_in_advance_items_ALM.clear();
        tbl_charge_in_advance_items_ALM.addAll(acc);

    }

    public static class Tblcharge_in_advance_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Description", "Qty", "Code", "Amount", "UNIT", "Status", "soa_type", "soa_type_id", "user_screen_name", "user_id", "remarks", "item_code", "barcode", "description", "generic_name", "item_type", "supplier_name", "supplier_id", "serial_no", "product_qty", "unit", "conversion", "selling_price", "date_added", "status", "is_vatable", "selling_type", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "branch", "branch_code", "location", "location_id", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "brand", "brand_id", "model", "model_id", "addtl_amount", "wtax"
        };

        public Tblcharge_in_advance_itemsModel(ListModel listmodel) {
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
            to_charge_in_advance_items tt = (to_charge_in_advance_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return " " + tt.description;
                case 2:
                    return "  " + FitIn.fmt_woc(tt.product_qty);
                case 3:
                    return " " + tt.item_code;
                case 4:
                    double ps = tt.product_qty * tt.selling_price;
                    ps = (ps + tt.addtl_amount) - tt.discount_amount;
                    return FitIn.fmt_wc_0(ps) + " ";
                case 5:
                    if (tt.status == 1) {
                        return " Void";
                    } else {
                        return " Ok";
                    }
                case 6:
                    return tt.reference_no;
                case 7:
                    return tt.soa_type;
                case 8:
                    return tt.soa_type_id;
                case 9:
                    return tt.user_screen_name;
                case 10:
                    return tt.user_id;
                case 11:
                    return tt.remarks;
                case 12:
                    return tt.item_code;
                case 13:
                    return tt.barcode;
                case 14:
                    return tt.description;
                case 15:
                    return tt.generic_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.supplier_name;
                case 18:
                    return tt.supplier_id;
                case 19:
                    return tt.serial_no;
                case 20:
                    return tt.product_qty;
                case 21:
                    return tt.unit;
                case 22:
                    return tt.conversion;
                case 23:
                    return tt.selling_price;
                case 24:
                    return tt.date_added;
                case 25:
                    return tt.status;
                case 26:
                    return tt.is_vatable;
                case 27:
                    return tt.selling_type;
                case 28:
                    return tt.discount_name;
                case 29:
                    return tt.discount_rate;
                case 30:
                    return tt.discount_amount;
                case 31:
                    return tt.discount_customer_name;
                case 32:
                    return tt.discount_customer_id;
                case 33:
                    return tt.branch;
                case 34:
                    return tt.branch_code;
                case 35:
                    return tt.location;
                case 36:
                    return tt.location_id;
                case 37:
                    return tt.category;
                case 38:
                    return tt.category_id;
                case 39:
                    return tt.classification;
                case 40:
                    return tt.classification_id;
                case 41:
                    return tt.sub_classification;
                case 42:
                    return tt.sub_classification_id;
                case 43:
                    return tt.brand;
                case 44:
                    return tt.brand_id;
                case 45:
                    return tt.model;
                case 46:
                    return tt.model_id;
                case 47:
                    return tt.addtl_amount;
                default:
                    return tt.wtax;
            }
        }
    }

    private void data_cols() {
        String where = " where ar_no='" + jTextField3.getText() + "' and status='" + "0" + "' order by id asc ";
        System.out.println("AR No.: " + jTextField3.getText());
        List<Charge_in_advance_items.to_charge_in_advance_items> datas = Charge_in_advance_items.ret_data(where);
        loadData_charge_in_advance_items(datas);
        compute_total();
    }

//</editor-fold> 
    private void compute_total() {
        List<to_charge_in_advance_items> orders = tbl_charge_in_advance_items_ALM;
        double sub_total = 0;
        double line_discount = 0;
        double or_discount = FitIn.toDouble(lbl_due_discount.getText());
        double amount = 0;
        double addtl_amount = 0;
        double wtax = 0;
        double qty = 0;
        for (to_charge_in_advance_items order : orders) {
            qty += order.product_qty;
            line_discount += order.discount_amount;
            amount += order.product_qty * order.selling_price;
            addtl_amount += order.addtl_amount;
            double tots = (amount + addtl_amount) - order.discount_amount;
            double rate = order.wtax;
            rate = rate / 100;
            double a = 1;
            a = a - rate;
            double my_wtax = tots / a;
            my_wtax = my_wtax - tots;
            wtax = my_wtax;
        }
        lbl_line_discount1.setText(FitIn.fmt_wc_0(addtl_amount));
        lbl_due_discount1.setText(FitIn.fmt_wc_0(wtax));
        lbl_line_discount.setText(FitIn.fmt_wc_0(line_discount));
        lbl_sub_total2.setText(FitIn.fmt_woc(qty));
        lbl_sub_total1.setText(FitIn.fmt_wc_0(amount));
        double total = (amount + addtl_amount + wtax) - line_discount;
        lbl_total.setText(FitIn.fmt_wc_0(total));
        double balance_due = total - or_discount;
        lbl_balance_due.setText(FitIn.fmt_wc_0(balance_due));
        Payments.balance_due = balance_due;

    }

    private void preview_dr() {
        if (ar == null) {
            return;
        }
        List<Charge_in_advance_items.to_charge_in_advance_items> datas = tbl_charge_in_advance_items_ALM;
        double sale_discount = 0;
        double net_total = 0;
        String sales_no = ar.ar_no;
        String date_added = ar.date_added;
        String remarkss = "";
        String customer_names = ar.customer_name;
        Window p = (Window) this;
        Dlg_delivery_print_preview nd = Dlg_delivery_print_preview.create(p, true);
        nd.setTitle("");
        nd.do_pass3(datas, sale_discount, net_total, sales_no, date_added, remarkss, customer_names);
        nd.setCallback(new Dlg_delivery_print_preview.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_delivery_print_preview.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void cancel_item() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Charge In Advance - (Delete)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        
        int row = tbl_charge_in_advance_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_charge_in_advance_items to = (to_charge_in_advance_items) tbl_charge_in_advance_items_ALM.get(row);
        int col = tbl_charge_in_advance_items.getSelectedColumn();
        if (col == 4) {
            int id = to.id;
            String customer_id = to.customer_id;
            String customer_name = to.customer_name;
            String ar_id = to.ar_id;
            String ar_no = to.ar_no;
            String date_applied = to.date_applied;
            String reference_no = to.reference_no;
            String soa_type = to.soa_type;
            String soa_type_id = to.soa_type_id;
            String user_screen_name = MyUser.getUser_id();
            String user_id = MyUser.getUser_screen_name();
            String remarks = to.remarks;
            String item_code = to.item_code;
            String barcode = to.barcode;
            String description = to.description;
            String generic_name = to.generic_name;
            String item_type = to.item_type;
            String supplier_name = to.supplier_name;
            String supplier_id = to.supplier_id;
            String serial_no = to.serial_no;
            double product_qty = to.product_qty;
            String unit = to.unit;
            double conversion = to.conversion;
            double selling_price = to.selling_price;
            String date_added = DateType.now();
            int status = 1;
            int is_vatable = to.is_vatable;
            int selling_type = to.selling_type;
            String discount_name = to.discount_name;
            double discount_rate = to.discount_rate;
            double discount_amount = to.discount_amount;
            String discount_customer_name = to.discount_customer_name;
            String discount_customer_id = to.discount_customer_id;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            double addtl_amount = to.addtl_amount;
            double wtax = to.wtax;
            final Charge_in_advance_cancelled_items.to_charge_in_advance_items_cancelled_items field = new Charge_in_advance_cancelled_items.to_charge_in_advance_items_cancelled_items(id, customer_id, customer_name, ar_id, ar_no, date_applied, reference_no, soa_type, soa_type_id, user_screen_name, user_id, remarks, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, addtl_amount, wtax);

            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Charge_in_advance_cancelled_items.add_data(field);
                    Alert.set(3, "");
                    data_cols();
                }
            });
            nd.setLocationRelativeTo(jp);
            nd.setVisible(true);
        }

    }
}
