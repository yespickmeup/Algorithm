/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.charge_in_advance;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.touchscreen.Dlg_touchscreen_item_discount;
import POS.touchscreen.Dlg_touchscreen_item_qty;
import POS.touchscreen.Payments;
import POS.unit_of_measure.S1_unit_of_measure;
import POS.util.DateType;
import POS.util.KeyCodes;
import POS.util.LostHeaderRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.fields.Label;
import synsoftech.panels.Confirm;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_charge_in_advance_add_item extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_charge_in_advance_add_item
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

        public final List<Inventory_barcodes.to_inventory_barcodes> fields;

        public OutputData(List<Inventory_barcodes.to_inventory_barcodes> fields) {
            this.fields = fields;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_charge_in_advance_add_item(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_charge_in_advance_add_item(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_charge_in_advance_add_item() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_charge_in_advance_add_item myRef;

    private void setThisRef(Dlg_charge_in_advance_add_item myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_charge_in_advance_add_item> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_charge_in_advance_add_item create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_charge_in_advance_add_item create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_charge_in_advance_add_item dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_charge_in_advance_add_item((java.awt.Frame) parent, false);
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
            Dlg_charge_in_advance_add_item dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_charge_in_advance_add_item((java.awt.Dialog) parent, false);
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

        Dlg_charge_in_advance_add_item dialog = Dlg_charge_in_advance_add_item.create(new javax.swing.JFrame(), true);
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
        pnl_search = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        tf_search = new Field.Search();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new Button.Default();
        jButton7 = new Button.Info();
        pnl_add_order = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        lbl_qty = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_uom = new javax.swing.JTable();
        jButton41 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        lbl_item_discount = new Label.Item_discount();
        jLabel40 = new javax.swing.JLabel();
        jButton43 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        tf_addtl_cash = new Field.Input();
        tf_wtax = new Field.Combo();
        jLabel41 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        pnl_orders = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_orders = new javax.swing.JTable();
        jButton8 = new Button.Default();
        jButton9 = new Button.Success();
        jButton10 = new Button.Info();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lbl_sub_total1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_sub_total2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_balance_due = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_line_discount = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_due_discount = new Label.Item_discount();
        jLabel20 = new javax.swing.JLabel();
        lbl_line_discount1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_due_discount1 = new Label.Item_discount();
        jButton11 = new Button.Default();
        jButton12 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        pnl_search.setBackground(new java.awt.Color(255, 255, 255));
        pnl_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_items);

        jLabel1.setText("No of Transactions:");

        jLabel2.setText("0");

        jLabel4.setText("Status:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search:");

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/shopping73_1.png"))); // NOI18N
        jButton7.setText("View Orders");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_searchLayout = new javax.swing.GroupLayout(pnl_search);
        pnl_search.setLayout(pnl_searchLayout);
        pnl_searchLayout.setHorizontalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnl_searchLayout.setVerticalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(11, 11, 11))
        );

        jPanel1.add(pnl_search, "card2");

        pnl_add_order.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel1.setText("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");
        jXLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jXLabel1.setLineWrap(true);
        jXLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_qty.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qty.setText("1");
        lbl_qty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/Line-Divider.png"))); // NOI18N
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("-");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("+");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/pie21.png"))); // NOI18N
        jButton27.setText("F2 - Discount Item ");
        jButton27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton27.setContentAreaFilled(false);
        jButton27.setFocusable(false);
        jButton27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton27MouseClicked(evt);
            }
        });
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        tbl_uom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_uom.setGridColor(new java.awt.Color(237, 237, 237));
        tbl_uom.setSelectionBackground(new java.awt.Color(4, 176, 217));
        jScrollPane2.setViewportView(tbl_uom);

        jButton41.setBackground(new java.awt.Color(255, 255, 255));
        jButton41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton41.setText("Back");
        jButton41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton41.setContentAreaFilled(false);
        jButton41.setFocusable(false);
        jButton41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/crop13 (1).png"))); // NOI18N
        jLabel43.setText("F1 - Set Quantity ");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel43.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });

        lbl_item_discount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_item_discount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_item_discount.setText("0.00");
        lbl_item_discount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_item_discount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_item_discountMouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });

        jButton43.setBackground(new java.awt.Color(255, 255, 255));
        jButton43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton43.setText("Add Order");
        jButton43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton43.setContentAreaFilled(false);
        jButton43.setFocusable(false);
        jButton43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/dollar49.png"))); // NOI18N
        jButton28.setText("F3 - Addtl. Cash");
        jButton28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton28.setContentAreaFilled(false);
        jButton28.setFocusable(false);
        jButton28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton28.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/man249.png"))); // NOI18N
        jButton29.setText("  F4 - WTax");
        jButton29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton29.setContentAreaFilled(false);
        jButton29.setFocusable(false);
        jButton29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        tf_addtl_cash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_addtl_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_addtl_cashActionPerformed(evt);
            }
        });

        tf_wtax.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_wtax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_wtaxActionPerformed(evt);
            }
        });

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel41.setOpaque(true);
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel46.setOpaque(true);
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_addtl_cash)
                    .addComponent(tf_wtax))
                .addGap(0, 0, 0)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_addtl_cash)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_wtax)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_item_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_item_discount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_add_orderLayout = new javax.swing.GroupLayout(pnl_add_order);
        pnl_add_order.setLayout(pnl_add_orderLayout);
        pnl_add_orderLayout.setHorizontalGroup(
            pnl_add_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_add_orderLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_add_orderLayout.setVerticalGroup(
            pnl_add_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(pnl_add_order, "card3");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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
        tbl_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ordersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_orders);

        jButton8.setText("Cancel");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Ok");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/binary5.png"))); // NOI18N
        jButton10.setText("ADD ITEM");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel15.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Gross Total              :");

        lbl_sub_total1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_sub_total1.setText("0.00");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("No of Items:");

        lbl_sub_total2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_sub_total2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_sub_total2.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("TOTAL:");

        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0.00");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Balance Due:");

        lbl_balance_due.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_balance_due.setForeground(java.awt.Color.red);
        lbl_balance_due.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance_due.setText("0.00");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Line Discount           :");

        lbl_line_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_line_discount.setText("0.00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Due Discount           :");

        lbl_due_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_due_discount.setText("0.00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Additional Amount    :");

        lbl_line_discount1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_line_discount1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_line_discount1.setText("0.00");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Witholding Tax:");

        lbl_due_discount1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_due_discount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_due_discount1.setText("0.00");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_line_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sub_total1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_due_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_line_discount1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_balance_due, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(lbl_due_discount1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_sub_total2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_sub_total2)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(lbl_sub_total1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lbl_line_discount1)
                    .addComponent(lbl_due_discount1))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(lbl_line_discount))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_due_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_balance_due))))
        );

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/pie21 (2).png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/shopping86.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_ordersLayout = new javax.swing.GroupLayout(pnl_orders);
        pnl_orders.setLayout(pnl_ordersLayout);
        pnl_ordersLayout.setHorizontalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(pnl_orders, "card4");

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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cardLayout.show(jPanel1, "3");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        set_qty(false);
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        set_qty(true);
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        item_discount();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        cardLayout.show(jPanel1, "1");
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        item_qty();
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        add_order();
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void tf_addtl_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addtl_cashActionPerformed

    }//GEN-LAST:event_tf_addtl_cashActionPerformed

    private void tf_wtaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_wtaxActionPerformed

    }//GEN-LAST:event_tf_wtaxActionPerformed

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ok();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        cardLayout.show(jPanel1, "1");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        due_discount();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        remove_items();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void lbl_item_discountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_item_discountMouseClicked
        item_discount();
    }//GEN-LAST:event_lbl_item_discountMouseClicked

    private void jButton27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton27MouseClicked

    }//GEN-LAST:event_jButton27MouseClicked

    private void tbl_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ordersMouseClicked
        update_item();
    }//GEN-LAST:event_tbl_ordersMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lbl_balance_due;
    private javax.swing.JLabel lbl_due_discount;
    private javax.swing.JLabel lbl_due_discount1;
    private javax.swing.JLabel lbl_item_discount;
    private javax.swing.JLabel lbl_line_discount;
    private javax.swing.JLabel lbl_line_discount1;
    private javax.swing.JLabel lbl_qty;
    private javax.swing.JLabel lbl_sub_total1;
    private javax.swing.JLabel lbl_sub_total2;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel pnl_add_order;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTable tbl_orders;
    private javax.swing.JTable tbl_uom;
    private javax.swing.JTextField tf_addtl_cash;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_wtax;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        set_default_branch();
        set_cardlayout();
        init_tbl_items();
        init_tbl_uom();
        init_tbl_order();
    }
    CardLayout cardLayout = new CardLayout();

    private void set_cardlayout() {
        cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.addLayoutComponent("1", pnl_search);
        cardLayout.addLayoutComponent("2", pnl_add_order);
        cardLayout.addLayoutComponent("3", pnl_orders);
    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        my_location_id = "" + to.id;

        my_branch_id = to.branch_id;
        my_branch = to.branch;
        my_location = to.location;

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
                disposed();
            }
        });
        tbl_uom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    cardLayout.show(jPanel1, "1");
                    tf_search.grabFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add_order();
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    item_qty();
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    item_discount();
                }
            }
        });
        KeyCodes.numpad(tbl_uom, lbl_qty);
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" init table items ">
    private ArrayListModel tbl_items_ALM;
    private TblitemsModel tbl_items_M;

    private void init_tbl_items() {
        tbl_items_ALM = new ArrayListModel();
        tbl_items_M = new TblitemsModel(tbl_items_ALM);
        tbl_items.getTableHeader().
                setPreferredSize(new Dimension(100, 0));
        tbl_items.setModel(tbl_items_M);
        tbl_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);
        int[] tbl_widths_items = {40, 0, 100, 80, 25, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 35;

        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 14));
        tbl_items.setRowHeight(40);
        tbl_items.setFont(new java.awt.Font("Arial", 0, 14));
        TableWidthUtilities.setColumnRightRenderer(tbl_items, 3);
        tbl_items.getColumnModel().getColumn(1).setCellRenderer(new Html());

        TableColumnModel tcm = tbl_items.getColumnModel();
        TableColumn tm = tcm.getColumn(2);
        tm.setCellRenderer(new Html());

        tbl_items.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
        tbl_items.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
    }

    class Html extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            JLabel lbl = new JLabel();
            lbl.setText(value.toString());
            lbl.setOpaque(true);
            lbl.setBackground(Color.white);
            if (selected) {
                lbl.setBackground(new java.awt.Color(4, 176, 217));
                lbl.setForeground(new java.awt.Color(0, 0, 0));
            }
            return lbl;
        }
    }

    private void loadData_items(List<Inventory_barcodes.to_inventory_barcodes> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "Price", "UNIT", "COST", "", "", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level"
        };

        public TblitemsModel(ListModel listmodel) {
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
                    return "  " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.barcode;
                case 2:
                    String html = "<html><body>"
                            + "&nbsp <font size=\"4\"> " + tt.description + "</font><br>"
                            + "&nbsp <font color=\"black\"> Item Code:" + tt.main_barcode + "&emsp;" + "Barcode: " + tt.barcode + "</font><br>"
                            + "</body>"
                            + "</html>";
                    return html;
                case 3:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 4:
                    return "/POS/icon_inventory/tag6 (2).png";
                case 5:
                    return "/POS/icon_inventory/world90.png";
                case 6:

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
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void data_cols() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t_items = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " where main_barcode='" + search + "' and location_id='" + my_location_id + "' "
                        + " or barcode='" + search + "' and location_id='" + my_location_id + "' "
                         + " or description like '%" + search + "%' and location_id='" + my_location_id + "' ";
                where = where + " order by description asc ";
                loadData_items(Inventory_barcodes.ret_where(where));
                jLabel2.setText("" + tbl_items_ALM.size());
                if (tbl_items_ALM.size() == 0) {

                }
                if (tbl_items_ALM.size() == 1) {
                    tbl_items.setRowSelectionInterval(0, 0);
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t_items.start();

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" init table unit of measure ">
    private ArrayListModel tbl_uom_ALM;
    private TbluomModel tbl_uom_M;

    private void init_tbl_uom() {
        tbl_uom_ALM = new ArrayListModel();
        tbl_uom_M = new TbluomModel(tbl_uom_ALM);
        tbl_uom.getTableHeader().setPreferredSize(new Dimension(100, 0));
        tbl_uom.setModel(tbl_uom_M);
        tbl_uom.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_uom.setRowHeight(25);
        int[] tbl_widths_uom = {100, 60, 100};
        for (int i = 0, n = tbl_widths_uom.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_uom, i, tbl_widths_uom[i]);
        }
        tbl_uom.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));
        tbl_uom.setRowHeight(35);
        tbl_uom.setFont(new java.awt.Font("Arial", 0, 14));
        TableWidthUtilities.setColumnRightRenderer(tbl_uom, 2);
    }

    private void loadData_uom(List<S1_unit_of_measure.to_uom> acc) {
        tbl_uom_ALM.clear();
        tbl_uom_ALM.addAll(acc);

    }

    public static class TbluomModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Unit", "Conversion", "Price"
        };

        public TbluomModel(ListModel listmodel) {
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
            S1_unit_of_measure.to_uom tt = (S1_unit_of_measure.to_uom) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.unit;
                case 1:
                    return " " + FitIn.fmt_wc_0(tt.conversion);
                default:
                    return FitIn.fmt_wc_0(tt.price) + " ";
            }
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" init table orders ">
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
        int[] tbl_widths_items = {40, 40, 50, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
        tbl_orders.getColumnModel().getColumn(0).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(1).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(2).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(3).setHeaderRenderer(new LostHeaderRenderer());
    }

    private void loadData_orders(List<Inventory_barcodes.to_inventory_barcodes> acc) {
        tbl_orders_ALM.clear();
        tbl_orders_ALM.addAll(acc);

    }

    public static class TblordersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Description", "Qty", "Code", "Amount", "UNIT", "COST", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level"
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
//                    return " " + uoms.uom;
                    return " " + tt.main_barcode;
                case 3:
                    double ps = tt.product_qty * tt.selling_price;
                    ps = (ps + tt.addtl_amount) - tt.discount_amount;
                    return FitIn.fmt_wc_0(ps) + " ";
                case 4:
                    return tt.unit;
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

//</editor-fold>
    private void item_qty() {
        double qty = FitIn.toDouble(lbl_qty.getText());
        Window p = (Window) this;
        Dlg_touchscreen_item_qty nd = Dlg_touchscreen_item_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(qty);
        nd.setCallback(new Dlg_touchscreen_item_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_item_qty.OutputData data) {
                closeDialog.ok();
                lbl_qty.setText(FitIn.fmt_woc(data.qty));
            }
        });
        Point loc = jLabel43.getLocationOnScreen();
        nd.setLocation(loc.x + 130, loc.y);

        nd.setVisible(true);
    }

    private void item_discount() {
        int row2 = tbl_uom.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        S1_unit_of_measure.to_uom uom = (S1_unit_of_measure.to_uom) tbl_uom_ALM.get(row2);
        double price = uom.price;
        double qty = FitIn.toDouble(lbl_qty.getText());
        price = price * qty;
        Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
        Window p = (Window) this;
        Dlg_touchscreen_item_discount nd = Dlg_touchscreen_item_discount.create(p, true);
        nd.setTitle("");
        nd.do_pass(lbl, price);
        nd.setCallback(new Dlg_touchscreen_item_discount.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_item_discount.OutputData data) {
                closeDialog.ok();
                Payments.discount discount = data.discount;
                Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
                lbl.setDiscount_amount(discount.amount);
                lbl.setDiscount_customer_id(discount.customer_id);
                lbl.setDiscount_customer_name(discount.customer_name);
                lbl.setDiscount_name(discount.discount_name);
                lbl.setDiscount_rate(discount.rate);
                lbl_item_discount.setText(FitIn.fmt_wc_0(discount.amount));
            }
        });
        Point loc = jButton27.getLocationOnScreen();
        nd.setLocation(loc.x + 130, loc.y);
        nd.setVisible(true);
    }

    private void select_item() {
        final int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_items_ALM.get(tbl_items.convertRowIndexToModel(row));

        String detail = "Description: " + to.description + "\n";
        detail = detail + "Category: " + to.category + "\n";
        detail = detail + "Classification: " + to.classification + "\n";
        detail = detail + "Sub-Classification: " + to.sub_classification + "\n";
        detail = detail + "Brand: " + to.brand + "\n";
        detail = detail + "Model: " + to.model + "\n";
        detail = detail + "Supplier: " + to.supplier + "\n";
        jXLabel1.setText(detail);

        List<S1_unit_of_measure.to_uom> uoms = new ArrayList();
        String uom = to.unit;
        String[] list = uom.split(",");
        int def = 0;
        int o = 0;
        for (String s : list) {
            int i = s.indexOf(":");
            int ii = s.indexOf("/");
            int iii = s.indexOf("^");
            String uom1 = s.substring(1, i);
            double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
            double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
            int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
            S1_unit_of_measure.to_uom to1 = new S1_unit_of_measure.to_uom(uom1, selling_price, conversion, is_default);
            uoms.add(to1);
            if (to1.is_default == 1) {
                def = o;
            }
            o++;
        }

        loadData_uom(uoms);
        if (!uoms.isEmpty()) {
            tbl_uom.setRowSelectionInterval(def, def);
        }
        cardLayout.show(jPanel1, "2");
        tbl_uom.grabFocus();
        jButton43.setText("Add Order");
    }

    private void set_qty(boolean increase) {
        double qty = FitIn.toDouble(lbl_qty.getText());
        if (increase) {
            qty++;
        } else {
            if (qty != 1) {
                qty--;
            }
        }
        lbl_qty.setText(FitIn.fmt_woc(qty));
    }

    private void add_order() {
        if (jButton43.getText().equalsIgnoreCase("Add Order")) {
            int row = tbl_items.getSelectedRow();
            if (row < 0) {
                return;
            }
            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_items_ALM.get(row);
            Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
            int id = 0;
            String barcode = to.barcode;
            String description = to.description;
            String generic_name = to.generic_name;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            double product_qty = FitIn.toDouble(lbl_qty.getText());
            if (product_qty <= 0) {
                product_qty = 1;
            }
            int row2 = tbl_uom.getSelectedRow();
            if (row2 < 0) {
                return;
            }

            S1_unit_of_measure.to_uom uom = (S1_unit_of_measure.to_uom) tbl_uom_ALM.get(row2);

            String unit = "[" + uom.unit + ":" + uom.price + "/" + uom.conversion + "^" + "1" + "]";

            double conversion = to.conversion;
            double selling_price = uom.price;
            String date_added = DateType.now();
            String user_name = "";
            String item_type = to.item_type;
            int status = to.status;
            String supplier = to.supplier;
            int fixed_price = to.fixed_price;
            double cost = to.cost;
            String supplier_id = to.supplier_id;
            int multi_level_pricing = to.multi_level_pricing;
            int vatable = to.vatable;
            double reorder_level = to.reorder_level;
            double markup = to.markup;
            String main_barcode = to.main_barcode;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            int selling_type = to.selling_type;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String serial_no = "";
            String selected_serials = to.selected_serials;
            double discount = lbl.getDiscount_rate();
            double discount_amount = lbl.getDiscount_amount();
            String discount_name = lbl.getDiscount_name();
            String discount_customer_name = lbl.getDiscount_customer_name();
            String discount_customer_id = lbl.getDiscount_customer_id();
            double addtl_cash = FitIn.toDouble(tf_addtl_cash.getText());
            double wtax = FitIn.toDouble(tf_wtax.getText());
            Inventory_barcodes.to_inventory_barcodes order = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, selected_serials, discount, discount_amount, discount_name, discount_customer_name, discount_customer_id, addtl_cash, wtax);
            tbl_orders_ALM.add(order);
            tbl_orders_M.fireTableDataChanged();
            compute_total();
            lbl_qty.setText("1");
            cardLayout.show(jPanel1, "3");
            lbl.clearAll();
            lbl_item_discount.setText("");
            tf_addtl_cash.setText("");
            tf_wtax.setText("");
            tf_search.grabFocus();
        } else {
            int row = tbl_orders.getSelectedRow();
            if (row < 0) {
                return;
            }
            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_orders_ALM.get(row);
            Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
            double addtl_cash = FitIn.toDouble(tf_addtl_cash.getText());
            double wtax = FitIn.toDouble(tf_wtax.getText());
            double product_qty = FitIn.toDouble(lbl_qty.getText());
            if (product_qty <= 0) {
                product_qty = 1;
            }
            to.setProduct_qty(product_qty);
            double discount = lbl.getDiscount_rate();
            to.setDiscount(discount);
            double discount_amount = lbl.getDiscount_amount();
            to.setDiscount_amount(discount_amount);
            String discount_name = lbl.getDiscount_name();
            to.setDiscount_name(discount_name);
            to.setDiscount_customer_name(lbl.getDiscount_customer_name());
            to.setDiscount_customer_id(lbl.getDiscount_customer_id());
            to.setAddtl_amount(addtl_cash);
            to.setWtax(wtax);
            tbl_orders_M.fireTableDataChanged();
            compute_total();
            lbl_qty.setText("1");
            cardLayout.show(jPanel1, "3");
            lbl.clearAll();
            lbl_item_discount.setText("");
            tf_addtl_cash.setText("");
            tf_wtax.setText("");
            tf_search.grabFocus();
        }

    }

    private void compute_total() {
        List<Inventory_barcodes.to_inventory_barcodes> orders = tbl_orders_ALM;
        double sub_total = 0;
        double line_discount = 0;
        double or_discount = FitIn.toDouble(lbl_due_discount.getText());
        double amount = 0;
        double addtl_amount = 0;
        double wtax = 0;
        double qty = 0;
        for (Inventory_barcodes.to_inventory_barcodes order : orders) {
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
//        lbl_p_amount_due.setText(FitIn.fmt_wc_0(total));
        double balance_due = total - or_discount;
        lbl_balance_due.setText(FitIn.fmt_wc_0(balance_due));
//        lbl_p_balance_due.setText(FitIn.fmt_wc_0(balance_due));
        Payments.balance_due = balance_due;
//        lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
//        tf_amount_tendered.setText(FitIn.fmt_wc_0(balance_due));

    }

    private void update_item() {
        int row = tbl_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_orders.getSelectedColumn();
        if (col == 3) {
            tbl_orders_ALM.remove(row);
            tbl_orders_M.fireTableDataChanged();
            compute_total();
        } else {
            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_orders_ALM.get(row);
            Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
            String detail = "Description: " + to.description + "\n";
            detail = detail + "Category: " + to.category + "\n";
            detail = detail + "Classification: " + to.classification + "\n";
            detail = detail + "Sub-Classification: " + to.sub_classification + "\n";
            detail = detail + "Brand: " + to.brand + "\n";
            detail = detail + "Model: " + to.model + "\n";
            detail = detail + "Supplier: " + to.supplier + "\n";
            jXLabel1.setText(detail);
            jButton43.setText("Update Order");
            lbl_qty.setText(FitIn.fmt_woc(to.product_qty));
            lbl.setDiscount_amount(to.discount_amount);
            lbl.setDiscount_name(to.discount_name);
            lbl.setDiscount_rate(to.discount);
            lbl.setDiscount_customer_name(to.discount_customer_name);
            lbl.setDiscount_customer_id(to.discount_customer_id);
            lbl_item_discount.setText(FitIn.fmt_wc_0(to.discount_amount));
            tf_addtl_cash.setText(FitIn.fmt_wc_0(to.addtl_amount));
            tf_wtax.setText(FitIn.fmt_wc_0(to.wtax));
            Dlg_inventory_uom.to_uom um1 = uom.default_uom(to.unit);
            S1_unit_of_measure.to_uom um2 = new S1_unit_of_measure.to_uom(um1.uom, um1.selling_price, um1.conversion, um1.is_default);
            tbl_uom_ALM.clear();
            tbl_uom_ALM.add(um2);
            tbl_uom_M.fireTableDataChanged();
            tbl_uom.setRowSelectionInterval(0, 0);
            cardLayout.show(jPanel1, "2");
            tbl_uom.grabFocus();
        }
    }

    private void remove_items() {
        Window p = (Window) this;
        Confirm nd = Confirm.create(p, true);
        nd.setTitle("");
        nd.do_pass(this.getSurface());
        nd.setCallback(new Confirm.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Confirm.OutputData data) {
                closeDialog.ok();
                tbl_orders_ALM.clear();
                tbl_orders_M.fireTableDataChanged();
                tf_search.grabFocus();
                compute_total();
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

    private void due_discount() {
        Label.Item_discount lbl = (Label.Item_discount) lbl_due_discount;

        double total = FitIn.toDouble(lbl_total.getText());
        Window p = (Window) this;
        Dlg_touchscreen_item_discount nd = Dlg_touchscreen_item_discount.create(p, true);
        nd.setTitle("");
        nd.do_pass(lbl, total);
        nd.setCallback(new Dlg_touchscreen_item_discount.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_item_discount.OutputData data) {
                closeDialog.ok();
                Payments.discount discount = data.discount;
                Label.Item_discount lbl = (Label.Item_discount) lbl_due_discount;
                lbl.setDiscount_amount(discount.amount);
                lbl.setDiscount_customer_id(discount.customer_id);
                lbl.setDiscount_customer_name(discount.customer_name);
                lbl.setDiscount_name(discount.discount_name);
                lbl.setDiscount_rate(discount.rate);
                lbl_due_discount.setText(FitIn.fmt_wc_0(discount.amount));
                compute_total();

            }
        });
        Point loc = jButton11.getLocationOnScreen();
        nd.setLocation(loc.x + 55, loc.y - 300);
        nd.setVisible(true);
    }

    private void ok() {
        List<Inventory_barcodes.to_inventory_barcodes> datas = tbl_orders_ALM;
        if (datas.isEmpty()) {
            return;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(datas));
        }
    }
}
