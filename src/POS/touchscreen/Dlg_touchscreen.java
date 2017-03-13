
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.my_sales.MySales;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.Branches;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Dlg_inventory_update_barcode;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.inventory_assembly.Dlg_inventory_assembly;
import POS.my_sales.MySales_Items;
import POS.my_services.My_services_customers;
import POS.orders.S1_order_items;
import POS.orders.S1_orders;
import POS.reports3.Dlg_report_item;
import POS.unit_of_measure.S1_unit_of_measure;
import POS.unit_of_measure.S1_unit_of_measure.to_uom;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.users.S1_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.KeyCodes;
import POS.util.LostHeaderRenderer;
import POS.util.TableRenderer;
import POS.util.Users;
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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Field;
import synsoftech.fields.Label;
import synsoftech.panels.Authenticate;
import synsoftech.panels.Confirm;
import synsoftech.panels.Loading;
import synsoftech.panels.Warning;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen
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
    private Dlg_touchscreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        getRootPane().setOpaque(false);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        getRootPane().setOpaque(false);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen() {
        super();
        setUndecorated(true);
        getRootPane().setOpaque(false);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen myRef;

    private void setThisRef(Dlg_touchscreen myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen((java.awt.Frame) parent, false);
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
            Dlg_touchscreen dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen dialog = Dlg_touchscreen.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        tf_search = new Field.Search();
        jLabel2 = new Label.Default();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_cash = new javax.swing.JButton();
        lbl_cash = new javax.swing.JButton();
        btn_credit = new javax.swing.JButton();
        lbl_credit = new javax.swing.JButton();
        btn_gift = new javax.swing.JButton();
        lbl_gift = new javax.swing.JButton();
        btn_prepaid = new javax.swing.JButton();
        lbl_prepaid = new javax.swing.JButton();
        lbl_cheque = new javax.swing.JButton();
        btn_cheque = new javax.swing.JButton();
        btn_charge = new javax.swing.JButton();
        lbl_charge = new javax.swing.JButton();
        btn_charge1 = new javax.swing.JButton();
        btn_charge2 = new javax.swing.JButton();
        btn_charge3 = new javax.swing.JButton();
        btn_charge4 = new javax.swing.JButton();
        btn_charge5 = new javax.swing.JButton();
        btn_charge6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn_charge11 = new javax.swing.JButton();
        btn_charge13 = new javax.swing.JButton();
        btn_charge14 = new javax.swing.JButton();
        btn_charge15 = new javax.swing.JButton();
        btn_charge16 = new javax.swing.JButton();
        btn_charge12 = new javax.swing.JButton();
        btn_charge17 = new javax.swing.JButton();
        btn_charge18 = new javax.swing.JButton();
        btn_charge19 = new javax.swing.JButton();
        btn_charge20 = new javax.swing.JButton();
        btn_charge21 = new javax.swing.JButton();
        btn_charge22 = new javax.swing.JButton();
        btn_charge23 = new javax.swing.JButton();
        btn_charge24 = new javax.swing.JButton();
        btn_charge25 = new javax.swing.JButton();
        btn_charge26 = new javax.swing.JButton();
        tf_amount_tendered = new Field.Input();
        btn_cash1 = new javax.swing.JButton();
        lbl_p_amount_due = new javax.swing.JButton();
        btn_cash2 = new javax.swing.JButton();
        lbl_p_all_tendered = new javax.swing.JButton();
        lbl_separator1 = new Label.Separator2();
        btn_cash3 = new javax.swing.JButton();
        lbl_p_change = new javax.swing.JButton();
        btn_cash4 = new javax.swing.JButton();
        lbl_p_balance_due = new javax.swing.JButton();
        btn_charge7 = new javax.swing.JButton();
        btn_charge8 = new javax.swing.JButton();
        btn_charge9 = new javax.swing.JButton();
        btn_charge10 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_separator2 = new Label.Separator();
        jButton34 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
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
        jLabel47 = new Label.Item_discount();
        jPanel3 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lbl_screen_name = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnl_orders = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orders = new javax.swing.JTable();
        lbl_customer_name = new Label.Normal();
        jLabel42 = new javax.swing.JLabel();
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
        jLabel36 = new javax.swing.JLabel();
        lbl_sales_no = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel13.setBackground(new java.awt.Color(4, 176, 217));
        jPanel13.setLayout(new java.awt.CardLayout());

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

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
        tbl_items.setGridColor(new java.awt.Color(237, 237, 237));
        tbl_items.setSelectionBackground(new java.awt.Color(4, 176, 217));
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_items);

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Advance Search - F7");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 150, 199));
        jLabel7.setText("No of Items:");

        jLabel8.setForeground(new java.awt.Color(0, 150, 199));
        jLabel8.setText("0");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel9.setForeground(new java.awt.Color(0, 150, 199));
        jLabel9.setText("State:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Choose Location:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Choose Branch:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Search by:");

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("F8 - Barcode");
        jCheckBox6.setFocusable(false);

        buttonGroup1.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("F9 - Description");
        jCheckBox8.setFocusable(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(tf_search)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(77, 77, 77))
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))))
                .addGap(5, 5, 5))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel13.add(jPanel14, "card2");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btn_cash.setBackground(new java.awt.Color(255, 255, 255));
        btn_cash.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_cash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/money17 (Custom).png"))); // NOI18N
        btn_cash.setText("Cash         ");
        btn_cash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_cash.setContentAreaFilled(false);
        btn_cash.setFocusable(false);
        btn_cash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cash.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_cash.setOpaque(true);
        btn_cash.setSelected(true);
        btn_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cashActionPerformed(evt);
            }
        });

        lbl_cash.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cash.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_cash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_cash.setContentAreaFilled(false);
        lbl_cash.setFocusable(false);
        lbl_cash.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_cash.setOpaque(true);
        lbl_cash.setSelected(true);

        btn_credit.setBackground(new java.awt.Color(255, 255, 255));
        btn_credit.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_credit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/credit.png"))); // NOI18N
        btn_credit.setText("F1 - Credit Card");
        btn_credit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_credit.setContentAreaFilled(false);
        btn_credit.setFocusable(false);
        btn_credit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_credit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_credit.setOpaque(true);
        btn_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditActionPerformed(evt);
            }
        });

        lbl_credit.setBackground(new java.awt.Color(255, 255, 255));
        lbl_credit.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_credit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_credit.setContentAreaFilled(false);
        lbl_credit.setFocusable(false);
        lbl_credit.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_credit.setOpaque(true);
        lbl_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_creditActionPerformed(evt);
            }
        });

        btn_gift.setBackground(new java.awt.Color(255, 255, 255));
        btn_gift.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_gift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/gift50 (Custom).png"))); // NOI18N
        btn_gift.setText("F2 - Gift Certificate");
        btn_gift.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_gift.setContentAreaFilled(false);
        btn_gift.setFocusable(false);
        btn_gift.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_gift.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_gift.setOpaque(true);
        btn_gift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_giftActionPerformed(evt);
            }
        });

        lbl_gift.setBackground(new java.awt.Color(255, 255, 255));
        lbl_gift.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_gift.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_gift.setContentAreaFilled(false);
        lbl_gift.setFocusable(false);
        lbl_gift.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_gift.setOpaque(true);
        lbl_gift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_giftActionPerformed(evt);
            }
        });

        btn_prepaid.setBackground(new java.awt.Color(255, 255, 255));
        btn_prepaid.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_prepaid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/prepaid.png"))); // NOI18N
        btn_prepaid.setText("F3 - Prepaid");
        btn_prepaid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_prepaid.setContentAreaFilled(false);
        btn_prepaid.setFocusable(false);
        btn_prepaid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_prepaid.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_prepaid.setOpaque(true);
        btn_prepaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prepaidActionPerformed(evt);
            }
        });

        lbl_prepaid.setBackground(new java.awt.Color(255, 255, 255));
        lbl_prepaid.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_prepaid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_prepaid.setContentAreaFilled(false);
        lbl_prepaid.setFocusable(false);
        lbl_prepaid.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_prepaid.setOpaque(true);
        lbl_prepaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_prepaidActionPerformed(evt);
            }
        });

        lbl_cheque.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cheque.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_cheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_cheque.setContentAreaFilled(false);
        lbl_cheque.setFocusable(false);
        lbl_cheque.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_cheque.setOpaque(true);
        lbl_cheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_chequeActionPerformed(evt);
            }
        });

        btn_cheque.setBackground(new java.awt.Color(255, 255, 255));
        btn_cheque.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_cheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/cheque.png"))); // NOI18N
        btn_cheque.setText("F4 - Cheque");
        btn_cheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_cheque.setContentAreaFilled(false);
        btn_cheque.setFocusable(false);
        btn_cheque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cheque.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_cheque.setOpaque(true);
        btn_cheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chequeActionPerformed(evt);
            }
        });

        btn_charge.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_charge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/charge.png"))); // NOI18N
        btn_charge.setText("F5 - Charge");
        btn_charge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge.setContentAreaFilled(false);
        btn_charge.setFocusable(false);
        btn_charge.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_charge.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_charge.setOpaque(true);
        btn_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chargeActionPerformed(evt);
            }
        });

        lbl_charge.setBackground(new java.awt.Color(255, 255, 255));
        lbl_charge.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl_charge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_charge.setContentAreaFilled(false);
        lbl_charge.setFocusable(false);
        lbl_charge.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_charge.setOpaque(true);
        lbl_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_chargeActionPerformed(evt);
            }
        });

        btn_charge1.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        btn_charge1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge1.setContentAreaFilled(false);
        btn_charge1.setFocusable(false);
        btn_charge1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge1.setOpaque(true);
        btn_charge1.setSelected(true);
        btn_charge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge1ActionPerformed(evt);
            }
        });

        btn_charge2.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        btn_charge2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge2.setContentAreaFilled(false);
        btn_charge2.setFocusable(false);
        btn_charge2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge2.setOpaque(true);
        btn_charge2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge2ActionPerformed(evt);
            }
        });

        btn_charge3.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        btn_charge3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge3.setContentAreaFilled(false);
        btn_charge3.setFocusable(false);
        btn_charge3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge3.setOpaque(true);
        btn_charge3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge3ActionPerformed(evt);
            }
        });

        btn_charge4.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        btn_charge4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge4.setContentAreaFilled(false);
        btn_charge4.setFocusable(false);
        btn_charge4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge4.setOpaque(true);
        btn_charge4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge4ActionPerformed(evt);
            }
        });

        btn_charge5.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        btn_charge5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge5.setContentAreaFilled(false);
        btn_charge5.setFocusable(false);
        btn_charge5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge5.setOpaque(true);
        btn_charge5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge5ActionPerformed(evt);
            }
        });

        btn_charge6.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/close33 (Custom).png"))); // NOI18N
        btn_charge6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge6.setContentAreaFilled(false);
        btn_charge6.setFocusable(false);
        btn_charge6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge6.setOpaque(true);
        btn_charge6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge6ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_charge11.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge11.setText("C");
        btn_charge11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge11.setContentAreaFilled(false);
        btn_charge11.setFocusable(false);
        btn_charge11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge11.setOpaque(true);
        btn_charge11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge11ActionPerformed(evt);
            }
        });

        btn_charge13.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge13.setText("0");
        btn_charge13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge13.setContentAreaFilled(false);
        btn_charge13.setFocusable(false);
        btn_charge13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge13.setOpaque(true);
        btn_charge13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge13ActionPerformed(evt);
            }
        });

        btn_charge14.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge14.setText(".");
        btn_charge14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge14.setContentAreaFilled(false);
        btn_charge14.setFocusable(false);
        btn_charge14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge14.setOpaque(true);
        btn_charge14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge14ActionPerformed(evt);
            }
        });

        btn_charge15.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge15.setText("2");
        btn_charge15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge15.setContentAreaFilled(false);
        btn_charge15.setFocusable(false);
        btn_charge15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge15.setOpaque(true);
        btn_charge15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge15ActionPerformed(evt);
            }
        });

        btn_charge16.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge16.setText("3");
        btn_charge16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge16.setContentAreaFilled(false);
        btn_charge16.setFocusable(false);
        btn_charge16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge16.setOpaque(true);
        btn_charge16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge16ActionPerformed(evt);
            }
        });

        btn_charge12.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge12.setText("1");
        btn_charge12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge12.setContentAreaFilled(false);
        btn_charge12.setFocusable(false);
        btn_charge12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge12.setOpaque(true);
        btn_charge12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge12ActionPerformed(evt);
            }
        });

        btn_charge17.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge17.setText("4");
        btn_charge17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge17.setContentAreaFilled(false);
        btn_charge17.setFocusable(false);
        btn_charge17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge17.setOpaque(true);
        btn_charge17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge17ActionPerformed(evt);
            }
        });

        btn_charge18.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge18.setText("6");
        btn_charge18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge18.setContentAreaFilled(false);
        btn_charge18.setFocusable(false);
        btn_charge18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge18.setOpaque(true);
        btn_charge18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge18ActionPerformed(evt);
            }
        });

        btn_charge19.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge19.setText("5");
        btn_charge19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge19.setContentAreaFilled(false);
        btn_charge19.setFocusable(false);
        btn_charge19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge19.setOpaque(true);
        btn_charge19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge19ActionPerformed(evt);
            }
        });

        btn_charge20.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge20.setText("7");
        btn_charge20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge20.setContentAreaFilled(false);
        btn_charge20.setFocusable(false);
        btn_charge20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge20.setOpaque(true);
        btn_charge20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge20ActionPerformed(evt);
            }
        });

        btn_charge21.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge21.setText("8");
        btn_charge21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge21.setContentAreaFilled(false);
        btn_charge21.setFocusable(false);
        btn_charge21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge21.setOpaque(true);
        btn_charge21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge21ActionPerformed(evt);
            }
        });

        btn_charge22.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge22.setText("9");
        btn_charge22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge22.setContentAreaFilled(false);
        btn_charge22.setFocusable(false);
        btn_charge22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge22.setOpaque(true);
        btn_charge22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge22ActionPerformed(evt);
            }
        });

        btn_charge23.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge23.setText("50");
        btn_charge23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge23.setContentAreaFilled(false);
        btn_charge23.setFocusable(false);
        btn_charge23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge23.setOpaque(true);
        btn_charge23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge23ActionPerformed(evt);
            }
        });

        btn_charge24.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge24.setText("1000");
        btn_charge24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge24.setContentAreaFilled(false);
        btn_charge24.setFocusable(false);
        btn_charge24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge24.setOpaque(true);
        btn_charge24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge24ActionPerformed(evt);
            }
        });

        btn_charge25.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge25.setText("500");
        btn_charge25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge25.setContentAreaFilled(false);
        btn_charge25.setFocusable(false);
        btn_charge25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge25.setOpaque(true);
        btn_charge25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge25ActionPerformed(evt);
            }
        });

        btn_charge26.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_charge26.setText("100");
        btn_charge26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge26.setContentAreaFilled(false);
        btn_charge26.setFocusable(false);
        btn_charge26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge26.setOpaque(true);
        btn_charge26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge26ActionPerformed(evt);
            }
        });

        tf_amount_tendered.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tf_amount_tendered.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_amount_tendered.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tf_amount_tendered.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amount_tenderedKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_amount_tendered)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn_charge20, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge21, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge22, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn_charge17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn_charge12, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge15, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge16, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn_charge11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_charge14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_charge23, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge26, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge25, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge24, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_amount_tendered, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_charge23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_charge26, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_charge25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_charge24, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_charge20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_charge17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_charge12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_charge11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btn_cash1.setBackground(new java.awt.Color(255, 255, 255));
        btn_cash1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cash1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/money13 (Custom).png"))); // NOI18N
        btn_cash1.setText("Amount Due");
        btn_cash1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_cash1.setContentAreaFilled(false);
        btn_cash1.setFocusable(false);
        btn_cash1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cash1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_cash1.setOpaque(true);
        btn_cash1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cash1ActionPerformed(evt);
            }
        });

        lbl_p_amount_due.setBackground(new java.awt.Color(255, 255, 255));
        lbl_p_amount_due.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_p_amount_due.setText("0.00");
        lbl_p_amount_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_p_amount_due.setContentAreaFilled(false);
        lbl_p_amount_due.setFocusable(false);
        lbl_p_amount_due.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_p_amount_due.setOpaque(true);

        btn_cash2.setBackground(new java.awt.Color(255, 255, 255));
        btn_cash2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cash2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/money28 (Custom).png"))); // NOI18N
        btn_cash2.setText("Tendered");
        btn_cash2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_cash2.setContentAreaFilled(false);
        btn_cash2.setFocusable(false);
        btn_cash2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cash2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_cash2.setOpaque(true);

        lbl_p_all_tendered.setBackground(new java.awt.Color(255, 255, 255));
        lbl_p_all_tendered.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_p_all_tendered.setText("0.00");
        lbl_p_all_tendered.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_p_all_tendered.setContentAreaFilled(false);
        lbl_p_all_tendered.setFocusable(false);
        lbl_p_all_tendered.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_p_all_tendered.setOpaque(true);

        btn_cash3.setBackground(new java.awt.Color(255, 255, 255));
        btn_cash3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cash3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/coins14 (Custom).png"))); // NOI18N
        btn_cash3.setText("Change");
        btn_cash3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_cash3.setContentAreaFilled(false);
        btn_cash3.setFocusable(false);
        btn_cash3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cash3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_cash3.setOpaque(true);

        lbl_p_change.setBackground(new java.awt.Color(255, 255, 255));
        lbl_p_change.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_p_change.setText("0.00");
        lbl_p_change.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_p_change.setContentAreaFilled(false);
        lbl_p_change.setFocusable(false);
        lbl_p_change.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_p_change.setOpaque(true);

        btn_cash4.setBackground(new java.awt.Color(255, 255, 255));
        btn_cash4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cash4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/money25 (Custom).png"))); // NOI18N
        btn_cash4.setText("Balance Due");
        btn_cash4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_cash4.setContentAreaFilled(false);
        btn_cash4.setFocusable(false);
        btn_cash4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cash4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_cash4.setOpaque(true);

        lbl_p_balance_due.setBackground(new java.awt.Color(255, 255, 255));
        lbl_p_balance_due.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_p_balance_due.setText("0.00");
        lbl_p_balance_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_p_balance_due.setContentAreaFilled(false);
        lbl_p_balance_due.setFocusable(false);
        lbl_p_balance_due.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_p_balance_due.setOpaque(true);

        btn_charge7.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge7.setContentAreaFilled(false);
        btn_charge7.setFocusable(false);
        btn_charge7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge7.setOpaque(true);
        btn_charge7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge7ActionPerformed(evt);
            }
        });

        btn_charge8.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge8.setContentAreaFilled(false);
        btn_charge8.setFocusable(false);
        btn_charge8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge8.setOpaque(true);
        btn_charge8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge8ActionPerformed(evt);
            }
        });

        btn_charge9.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge9.setContentAreaFilled(false);
        btn_charge9.setFocusable(false);
        btn_charge9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge9.setOpaque(true);
        btn_charge9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge9ActionPerformed(evt);
            }
        });

        btn_charge10.setBackground(new java.awt.Color(255, 255, 255));
        btn_charge10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_charge10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btn_charge10.setContentAreaFilled(false);
        btn_charge10.setFocusable(false);
        btn_charge10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_charge10.setOpaque(true);
        btn_charge10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charge10ActionPerformed(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jButton32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton32.setForeground(new java.awt.Color(0, 150, 199));
        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/left14 (Custom).png"))); // NOI18N
        jButton32.setBorderPainted(false);
        jButton32.setContentAreaFilled(false);
        jButton32.setFocusable(false);
        jButton32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 150, 199));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Back");

        jButton30.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton30.setForeground(new java.awt.Color(0, 150, 199));
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/print44.png"))); // NOI18N
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.setFocusable(false);
        jButton30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 150, 199));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Re - print");

        jButton31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton31.setForeground(new java.awt.Color(0, 150, 199));
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/shopping86.png"))); // NOI18N
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.setFocusable(false);
        jButton31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 150, 199));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Void Payment");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(lbl_separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jButton32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4))))
        );

        jButton34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton34.setForeground(new java.awt.Color(0, 150, 199));
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/ok1.png"))); // NOI18N
        jButton34.setBorderPainted(false);
        jButton34.setContentAreaFilled(false);
        jButton34.setFocusable(false);
        jButton34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 150, 199));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Done");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_gift, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_prepaid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cheque, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_charge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_gift, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_charge3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_prepaid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_charge4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_cheque, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_charge5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_charge, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_charge6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_charge2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_charge1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lbl_separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_cash1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_p_amount_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_cash4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_p_balance_due, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_cash3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_cash2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_p_all_tendered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_p_change, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_charge7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_charge8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_charge9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_charge10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_charge7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_cash1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_p_amount_due, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_cash4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_p_balance_due, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_charge8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_charge1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_charge2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_gift, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_prepaid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_cheque, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_gift, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_charge3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbl_charge, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_charge, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_prepaid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_charge4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_cheque, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_charge5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addComponent(btn_charge6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(5, 5, 5)
                        .addComponent(lbl_separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_cash2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_p_all_tendered, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_cash3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_p_change, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_charge9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_charge10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6)))
                .addGap(25, 25, 25))
        );

        jPanel7.setOpaque(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setOpaque(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel4, "card3");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/Barcode_Product_16.png"))); // NOI18N
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel47.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        jPanel3.setOpaque(false);

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

        jPanel17.setOpaque(false);

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel12, "card4");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(4, 176, 217));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Welcome,");

        lbl_screen_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_screen_name.setForeground(new java.awt.Color(238, 251, 254));
        lbl_screen_name.setText("Ronald Pascua!");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/down14 (2).png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/seo1.png"))); // NOI18N
        jLabel1.setText(" Algorithm Computer Services");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_screen_name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_screen_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pnl_orders.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setOpaque(false);

        jButton36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton36.setForeground(new java.awt.Color(0, 150, 199));
        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/remove21 (1).png"))); // NOI18N
        jButton36.setToolTipText("Remove Items(F1)");
        jButton36.setBorderPainted(false);
        jButton36.setContentAreaFilled(false);
        jButton36.setFocusable(false);
        jButton36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton36.setOpaque(true);
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton37.setForeground(new java.awt.Color(0, 150, 199));
        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/pie21 (2).png"))); // NOI18N
        jButton37.setToolTipText("Discount Order(F2)");
        jButton37.setBorderPainted(false);
        jButton37.setContentAreaFilled(false);
        jButton37.setFocusable(false);
        jButton37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton37.setOpaque(true);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton40.setForeground(new java.awt.Color(0, 150, 199));
        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/credit20.png"))); // NOI18N
        jButton40.setToolTipText("Pay");
        jButton40.setBorderPainted(false);
        jButton40.setContentAreaFilled(false);
        jButton40.setFocusable(false);
        jButton40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton40.setOpaque(true);
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton38.setForeground(new java.awt.Color(0, 150, 199));
        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/shopping86.png"))); // NOI18N
        jButton38.setToolTipText("Cancel Order(F3)");
        jButton38.setBorderPainted(false);
        jButton38.setContentAreaFilled(false);
        jButton38.setFocusable(false);
        jButton38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton38.setOpaque(true);
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton39.setForeground(new java.awt.Color(0, 150, 199));
        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/add187.png"))); // NOI18N
        jButton39.setToolTipText("Save Order(F4)");
        jButton39.setBorderPainted(false);
        jButton39.setContentAreaFilled(false);
        jButton39.setFocusable(false);
        jButton39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton39.setOpaque(true);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton42.setForeground(new java.awt.Color(0, 150, 199));
        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/document98.png"))); // NOI18N
        jButton42.setToolTipText("View Orders(F5)");
        jButton42.setBorderPainted(false);
        jButton42.setContentAreaFilled(false);
        jButton42.setFocusable(false);
        jButton42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton42.setOpaque(true);
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton44.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton44.setForeground(new java.awt.Color(0, 150, 199));
        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/cogwheels4 (1).png"))); // NOI18N
        jButton44.setToolTipText("Services (F7)");
        jButton44.setBorderPainted(false);
        jButton44.setContentAreaFilled(false);
        jButton44.setFocusable(false);
        jButton44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton44.setOpaque(true);
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

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
        tbl_orders.setGridColor(new java.awt.Color(237, 237, 237));
        tbl_orders.setOpaque(false);
        tbl_orders.setSelectionBackground(new java.awt.Color(4, 176, 217));
        tbl_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ordersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_orders);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        lbl_customer_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_customer_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_customer_name.setText("Customer Name");
        lbl_customer_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_customer_nameMouseClicked(evt);
            }
        });

        jLabel42.setBackground(new java.awt.Color(0, 150, 199));
        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(3, 150, 185));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/add70.png"))); // NOI18N
        jLabel42.setText("- F6");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel42.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
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
                .addGap(50, 50, 50)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_balance_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_sub_total2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_due_discount1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_sub_total2)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel17)
                        .addComponent(lbl_sub_total1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lbl_line_discount1)
                    .addComponent(jLabel21)
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
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_balance_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(2, 2, 2))
        );

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("ID NO");

        lbl_sales_no.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_sales_no.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_sales_no.setText("000000000000");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Sales Order No.");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/Line-Divider.png"))); // NOI18N
        jLabel45.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnl_ordersLayout = new javax.swing.GroupLayout(pnl_orders);
        pnl_orders.setLayout(pnl_ordersLayout);
        pnl_ordersLayout.setHorizontalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_sales_no, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(103, 103, 103))
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))))
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ordersLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(lbl_customer_name)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel36))
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(lbl_sales_no)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10))
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void btn_charge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge1ActionPerformed

    private void btn_charge2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge2ActionPerformed
        Payments.clear_credit_card();
        lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
        lbl_credit.setText("");
    }//GEN-LAST:event_btn_charge2ActionPerformed

    private void btn_charge3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge3ActionPerformed
        Payments.clearGift_certificate();
        lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
        lbl_gift.setText("");
    }//GEN-LAST:event_btn_charge3ActionPerformed

    private void btn_charge4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge4ActionPerformed
        Payments.clearPrepaid();
        lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
        lbl_prepaid.setText("");
    }//GEN-LAST:event_btn_charge4ActionPerformed

    private void btn_charge5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge5ActionPerformed
        Payments.clearCheque();
        lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
        lbl_cheque.setText("");
    }//GEN-LAST:event_btn_charge5ActionPerformed

    private void btn_charge6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge6ActionPerformed
        Payments.clearCharge();
        lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));

        lbl_charge.setText("");
    }//GEN-LAST:event_btn_charge6ActionPerformed

    private void btn_charge11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge11ActionPerformed

    private void btn_charge13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge13ActionPerformed

    private void btn_charge14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge14ActionPerformed

    private void btn_charge15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge15ActionPerformed

    private void btn_charge16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge16ActionPerformed

    private void btn_charge12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge12ActionPerformed

    private void btn_charge17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge17ActionPerformed

    private void btn_charge18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge18ActionPerformed

    private void btn_charge19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge19ActionPerformed

    private void btn_charge20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge20ActionPerformed

    private void btn_charge21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge21ActionPerformed

    private void btn_charge22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge22ActionPerformed

    private void btn_charge23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge23ActionPerformed

    private void btn_charge24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge24ActionPerformed

    private void btn_charge25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge25ActionPerformed

    private void btn_charge26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge26ActionPerformed

    private void btn_charge7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge7ActionPerformed

    private void btn_charge8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge8ActionPerformed

    private void btn_charge9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge9ActionPerformed

    private void btn_charge10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charge10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_charge10ActionPerformed

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        set_qty(false);
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        set_qty(true);
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        cardLayout.show(jPanel13, "2");
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        item_qty();
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        remove_items();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        due_discount();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        payment();


    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        cancel_order();
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        save_order();
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        select_customer();
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        view_orders();
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        pnl_orders.setVisible(true);
        cardLayout.show(jPanel13, "2");
        tf_search.grabFocus();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        item_discount();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        add_order();
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creditActionPerformed
        payment_credit();
    }//GEN-LAST:event_btn_creditActionPerformed

    private void lbl_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_creditActionPerformed
        payment_credit();
    }//GEN-LAST:event_lbl_creditActionPerformed

    private void btn_giftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_giftActionPerformed
        payment_gc();
    }//GEN-LAST:event_btn_giftActionPerformed

    private void lbl_giftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_giftActionPerformed
        payment_gc();
    }//GEN-LAST:event_lbl_giftActionPerformed

    private void btn_prepaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prepaidActionPerformed
        payment_prepaid();
    }//GEN-LAST:event_btn_prepaidActionPerformed

    private void lbl_prepaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_prepaidActionPerformed
        payment_prepaid();
    }//GEN-LAST:event_lbl_prepaidActionPerformed

    private void btn_chequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chequeActionPerformed
        payment_cheque();
    }//GEN-LAST:event_btn_chequeActionPerformed

    private void lbl_chequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_chequeActionPerformed
        payment_cheque();
    }//GEN-LAST:event_lbl_chequeActionPerformed

    private void btn_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chargeActionPerformed
        payment_charge();
    }//GEN-LAST:event_btn_chargeActionPerformed

    private void lbl_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_chargeActionPerformed
        payment_charge();
    }//GEN-LAST:event_lbl_chargeActionPerformed

    private void tf_amount_tenderedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount_tenderedKeyReleased
        type_cash();
    }//GEN-LAST:event_tf_amount_tenderedKeyReleased

    private void tbl_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ordersMouseClicked
        update_item();
    }//GEN-LAST:event_tbl_ordersMouseClicked

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        settle_transaction();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void lbl_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_customer_nameMouseClicked
        Label.Normal cust = (Label.Normal) lbl_customer_name;
        lbl_customer_name.setText("Customer Name");
        jLabel36.setText("ID NO");
        cust.clearAll();
    }//GEN-LAST:event_lbl_customer_nameMouseClicked

    private void btn_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cashActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        advance_search2();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_cash1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cash1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cash1ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        view_services();
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branches();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branches();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        init_branch_locations();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void tf_wtaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_wtaxActionPerformed
        add_order();
    }//GEN-LAST:event_tf_wtaxActionPerformed

    private void tf_addtl_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addtl_cashActionPerformed
        add_order();
    }//GEN-LAST:event_tf_addtl_cashActionPerformed

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        serial_no();
    }//GEN-LAST:event_jLabel47MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cash;
    private javax.swing.JButton btn_cash1;
    private javax.swing.JButton btn_cash2;
    private javax.swing.JButton btn_cash3;
    private javax.swing.JButton btn_cash4;
    private javax.swing.JButton btn_charge;
    private javax.swing.JButton btn_charge1;
    private javax.swing.JButton btn_charge10;
    private javax.swing.JButton btn_charge11;
    private javax.swing.JButton btn_charge12;
    private javax.swing.JButton btn_charge13;
    private javax.swing.JButton btn_charge14;
    private javax.swing.JButton btn_charge15;
    private javax.swing.JButton btn_charge16;
    private javax.swing.JButton btn_charge17;
    private javax.swing.JButton btn_charge18;
    private javax.swing.JButton btn_charge19;
    private javax.swing.JButton btn_charge2;
    private javax.swing.JButton btn_charge20;
    private javax.swing.JButton btn_charge21;
    private javax.swing.JButton btn_charge22;
    private javax.swing.JButton btn_charge23;
    private javax.swing.JButton btn_charge24;
    private javax.swing.JButton btn_charge25;
    private javax.swing.JButton btn_charge26;
    private javax.swing.JButton btn_charge3;
    private javax.swing.JButton btn_charge4;
    private javax.swing.JButton btn_charge5;
    private javax.swing.JButton btn_charge6;
    private javax.swing.JButton btn_charge7;
    private javax.swing.JButton btn_charge8;
    private javax.swing.JButton btn_charge9;
    private javax.swing.JButton btn_cheque;
    private javax.swing.JButton btn_credit;
    private javax.swing.JButton btn_gift;
    private javax.swing.JButton btn_prepaid;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lbl_balance_due;
    private javax.swing.JButton lbl_cash;
    private javax.swing.JButton lbl_charge;
    private javax.swing.JButton lbl_cheque;
    private javax.swing.JButton lbl_credit;
    private javax.swing.JLabel lbl_customer_name;
    private javax.swing.JLabel lbl_due_discount;
    private javax.swing.JLabel lbl_due_discount1;
    private javax.swing.JButton lbl_gift;
    private javax.swing.JLabel lbl_item_discount;
    private javax.swing.JLabel lbl_line_discount;
    private javax.swing.JLabel lbl_line_discount1;
    private javax.swing.JButton lbl_p_all_tendered;
    private javax.swing.JButton lbl_p_amount_due;
    private javax.swing.JButton lbl_p_balance_due;
    private javax.swing.JButton lbl_p_change;
    private javax.swing.JButton lbl_prepaid;
    private javax.swing.JLabel lbl_qty;
    private javax.swing.JLabel lbl_sales_no;
    private javax.swing.JLabel lbl_screen_name;
    private javax.swing.JLabel lbl_separator1;
    private javax.swing.JLabel lbl_separator2;
    private javax.swing.JLabel lbl_sub_total1;
    private javax.swing.JLabel lbl_sub_total2;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTable tbl_orders;
    private javax.swing.JTable tbl_uom;
    private javax.swing.JTextField tf_addtl_cash;
    private javax.swing.JTextField tf_amount_tendered;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_wtax;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
        jPanel2.setVisible(false);
        init_key();
        set_cardlayout();
        init_invisible();
        set_default_branch();
        init_tbl_items();
        init_tbl_uom();
        init_tbl_order();
        init_payment();
        init_drag();
        input_amount();
        init_payment_types();
        hover();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                String businessname = System.getProperty("business_name", "Algorithm Computer Services");
                jLabel1.setText(businessname);
                lbl_screen_name.setText(Users.get_ScreenName());
                tf_search.grabFocus();
            }
        });

    }

    Window parent = (Window) this;

    public void do_pass(int is_salesman, int is_cashier, int can_choose_location) {
        if (is_salesman == 1) {
            jButton40.setVisible(false);
        } else {
            jButton40.setVisible(true);
        }
        if (is_cashier == 1) {
            jButton40.setEnabled(true);
            jButton40.setVisible(true);
        }

        if (can_choose_location == 1) {
            jLabel10.setVisible(true);
            jTextField1.setVisible(true);
            jLabel12.setVisible(true);
            jTextField2.setVisible(true);
        } else {
            jLabel10.setVisible(false);
            jTextField1.setVisible(false);
            jLabel12.setVisible(false);
            jTextField2.setVisible(false);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tf_search.grabFocus();
            }
        });
    }

    private void init_payment_types() {

        Payments.clearAll();
    }

    //<editor-fold defaultstate="collapsed" desc=" focus ">
    private void set_focus() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tf_search.grabFocus();
            }
        });
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" drag dialog ">
    int posX = 0, posY = 0;

    private void init_drag() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
            }
        });
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" init payment form ">

    private void init_payment() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                JButton[] b1 = {btn_cash, btn_credit, btn_gift, btn_prepaid, btn_cheque, btn_cash1, btn_cash2};
                RenderButtons.border1(b1);
                JButton[] b2 = {btn_charge, btn_cash3, btn_cash4};
                RenderButtons.border2(b2);
                JButton[] b3 = {lbl_cash, lbl_credit, lbl_gift, lbl_prepaid, lbl_cheque, btn_charge1, btn_charge2, btn_charge3, btn_charge4, btn_charge5};
                RenderButtons.border3(b3);
                JButton[] b4 = {lbl_p_balance_due, btn_charge6, btn_charge8, btn_charge10};
                RenderButtons.border4(b4);
                JButton[] b5 = {btn_cash1};
                RenderButtons.border5(b5);
                JButton[] b6 = {btn_charge7, btn_charge9};
                RenderButtons.border6(b6);
                JButton[] b7 = {lbl_p_all_tendered, lbl_p_amount_due};
                RenderButtons.border7(b7);
                JButton[] b8 = {lbl_p_change, lbl_p_balance_due};
                RenderButtons.border8(b8);
                JButton[] b9 = {lbl_charge};
                RenderButtons.border9(b9);
                JTextField[] b10 = {tf_amount_tendered};
                RenderButtons.border2(b10);
                JButton[] btns1 = {btn_cash, btn_credit, btn_gift, btn_prepaid, btn_cheque, btn_charge};
                JButton[] btns2 = {lbl_cash, lbl_credit, lbl_gift, lbl_prepaid, lbl_cheque, lbl_charge};
                JButton[] btns3 = {btn_charge1, btn_charge2, btn_charge3, btn_charge4, btn_charge5, btn_charge6};
                RenderButtons.hover_touchscreen(btns1, btns2, btns3);
                JButton[] btns4 = {btn_charge11, btn_charge13, btn_charge14, btn_charge12, btn_charge15, btn_charge16, btn_charge17, btn_charge19, btn_charge18, btn_charge20, btn_charge21, btn_charge22, btn_charge23, btn_charge26, btn_charge25, btn_charge24};
                RenderButtons.hover_numpad(btns4);
            }
        });
        t.start();

    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" table background ">
    private void init_table_background() {
        Color ivory = new Color(255, 255, 255);
        tbl_orders.setOpaque(true);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        tbl_orders.setFillsViewportHeight(true);
        tbl_orders.setBackground(ivory);

        Color ivory2 = new Color(4, 176, 217);
        tbl_items.setOpaque(true);
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        tbl_items.setFillsViewportHeight(true);
        tbl_items.setBackground(ivory);

        tbl_uom.setOpaque(true);
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        tbl_uom.setFillsViewportHeight(true);
        tbl_uom.setBackground(ivory);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" set cardlayout  ">

    private void set_cardlayout() {
        cardLayout = (CardLayout) jPanel13.getLayout();
        cardLayout.addLayoutComponent("1", jPanel12);
        cardLayout.addLayoutComponent("2", jPanel14);
        cardLayout.addLayoutComponent("3", jPanel4);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" invisible components ">

    private void init_invisible() {
        jPanel12.setVisible(false);
    }
//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        tf_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_items_ALM.isEmpty()) {
                        tbl_items.setRowSelectionInterval(0, 0);
                        tbl_items.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    if (jButton40.isVisible()) {
                        payment();
                    }

                }

                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    remove_items();
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    due_discount();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    cancel_order();
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    save_order();
                }
                if (e.getKeyCode() == KeyEvent.VK_F5) {
                    view_orders();
                }
                if (e.getKeyCode() == KeyEvent.VK_F6) {
                    select_customer();
                }
                if (e.getKeyCode() == KeyEvent.VK_F7) {
                    advance_search2();
                }
                if (e.getKeyCode() == KeyEvent.VK_F8) {
                    jCheckBox6.setSelected(true);
                    tf_search.grabFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_F9) {
                    jCheckBox8.setSelected(true);
                    tf_search.grabFocus();
                }
            }
        });

        tbl_items.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    tf_search.grabFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    select_item();
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    remove_items();
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    due_discount();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    cancel_order();
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    save_order();
                }
                if (e.getKeyCode() == KeyEvent.VK_F5) {
                    view_orders();
                }
                if (e.getKeyCode() == KeyEvent.VK_F7) {
                    advance_search2();
                }
                if (e.getKeyCode() == KeyEvent.VK_F8) {
                    jCheckBox6.setSelected(true);
                    tf_search.grabFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_F9) {
                    jCheckBox8.setSelected(true);
                    tf_search.grabFocus();
                }
            }
        });

        tbl_uom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    cardLayout.show(jPanel13, "2");
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

        tf_amount_tendered.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    payment_credit();
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    payment_gc();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    payment_prepaid();
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    payment_cheque();
                }
                if (e.getKeyCode() == KeyEvent.VK_F5) {
                    payment_charge();
                }
                if (e.getKeyCode() == KeyEvent.VK_F7) {
                    advance_search2();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    pnl_orders.setVisible(true);
                    cardLayout.show(jPanel13, "2");
                    tf_search.grabFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (tf_amount_tendered.isEnabled()) {
                        settle_transaction();
                    }

                }
            }
        });
        tbl_orders.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int row = tbl_orders.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    tbl_orders.setColumnSelectionInterval(3, 3);
                    update_item();

                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = tbl_orders.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    tbl_orders.setColumnSelectionInterval(row, 4);
                    update_item();
                    e.consume();

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

    private void data_cols() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        tf_search.setEnabled(false);
        Thread t_items = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " where ";
                if (jCheckBox6.isSelected()) {
                    where = where + " main_barcode='" + search + "' and location_id='" + my_location_id + "' "
                            + " or barcode='" + search + "' and location_id='" + my_location_id + "' ";
                }

                if (jCheckBox8.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + my_location_id + "' ";
                }
                where = where + " order by description asc";
                loadData_items(Inventory_barcodes.ret_where(where));
                jLabel8.setText("" + tbl_items_ALM.size());
                if (tbl_items_ALM.isEmpty()) {
                    Alert.set(0, "Item not found!");
                    tf_search.setEnabled(true);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tf_search.grabFocus();

                    return;
                }
                if (tbl_items_ALM.size() == 1) {
                    tbl_items.setRowSelectionInterval(0, 0);
                    select_item();
                }
                if (tbl_items_ALM.isEmpty()) {
                    Alert.set(0, "Item not Found!");
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                    tf_search.selectAll();
                    return;
                }
                tf_search.setEnabled(true);
                tf_search.grabFocus();
                tf_search.selectAll();
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t_items.start();
    }

    private void data_cols2() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        tf_search.setEnabled(false);
        Thread t_items = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " where ";
                if (jCheckBox6.isSelected()) {
                    where = where + " main_barcode='" + search + "' and location_id='" + my_location_id + "' "
                            + " or barcode='" + search + "' and location_id='" + my_location_id + "' ";
                }
               
                if (jCheckBox8.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + my_location_id + "' ";
                }
                where = where + " order by description asc";
                loadData_items(Inventory_barcodes.ret_where(where));
                jLabel8.setText("" + tbl_items_ALM.size());
               
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

    private void loadData_uom(List<to_uom> acc) {
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
    //<editor-fold defaultstate="collapsed" desc=" hover">
    private void hover() {
        JButton[] btns = {jButton36, jButton37, jButton38, jButton39, jButton42, jButton40, jButton44};

        for (final JButton btn : btns) {

            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point point = btn.getLocationOnScreen();

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(4, 176, 217));

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(244, 244, 244));
                }
            });

        }
    }
//</editor-fold>

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    CardLayout cardLayout = new CardLayout();

    private void update_barcode() {
        Window p = (Window) this;
        Dlg_inventory_update_barcode nd = Dlg_inventory_update_barcode.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_update_barcode.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_update_barcode.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(jScrollPane3);
        nd.setVisible(true);
    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        my_location_id = "" + to.id;
        System.out.println("Location: " + to.location + " : " + to.id);
        my_branch_id = to.branch_id;
        my_branch = to.branch;
        my_location = to.location;
        Field.Combo lo = (Field.Combo) jTextField1;
        Field.Combo br = (Field.Combo) jTextField2;
        lo.setText(to.location);
        lo.setId("" + to.id);

        br.setText(to.branch);
        br.setId("" + to.branch_id);
    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches() {
        final Field.Combo br = (Field.Combo) jTextField2;

        branches_list.clear();
        branches_list = Branches.ret_where("");
        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (Branches.to_branches to : branches_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.branch;
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
    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {
        final Field.Combo br = (Field.Combo) jTextField2;
        final Field.Combo lo = (Field.Combo) jTextField1;
        branch_location_list.clear();
        String where = " where branch_id='" + br.getId() + "' ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(lo, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText("" + to.location);
                lo.setId("" + to.id);
                my_location_id = "" + to.id;
                data_cols();
            }
        });
    }

    private void select_item() {
        final int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_items_ALM.get(tbl_items.convertRowIndexToModel(row));

//        if (to.product_qty <= 0) {
//            Window p = (Window) this;
//            Warning nd = Warning.create(p, true);
//            nd.setTitle("");
//            nd.do_pass(jPanel1, "Out of Stock!");
//            nd.setCallback(new Warning.Callback() {
//                @Override
//                public void ok(CloseDialog closeDialog, Warning.OutputData data) {
//                    closeDialog.ok();
//                }
//            });
//            Toolkit tk = Toolkit.getDefaultToolkit();
//            int xSize = ((int) tk.getScreenSize().
//                    getWidth());
//            int ySize = ((int) tk.getScreenSize().
//                    getHeight());
//            nd.setSize(xSize, ySize);
//            nd.setVisible(true);
//        } else {
//
//        }
        if (to.selling_type == 0) {
            int col = tbl_items.getSelectedColumn();
            if (col == 4) {
                String where = " where user_name='" + Users.user_name + "' order by previledge asc";
                List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
                int exists = 0;
                for (S1_user_previleges.to_user_previleges to1 : datas) {
                    if (to1.previledge.equalsIgnoreCase("Inventory Update Item Pricing")) {
                        exists = 1;
                        break;
                    }
                }

                if (exists == 1) {
                    Window p = (Window) this;
                    Dlg_touchscreen_update_price nd = Dlg_touchscreen_update_price.create(p, true);
                    nd.setTitle("");
                    nd.do_pass(to.selling_price);
                    nd.setCallback(new Dlg_touchscreen_update_price.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_touchscreen_update_price.OutputData data) {
                            closeDialog.ok();
                            String uoms = "";
                            double new_price = data.selling_price;
                            String unit = to.unit;
                            String[] list = unit.split(",");
                            int index = 0;
                            for (String s : list) {
                                int i = s.indexOf(":");
                                int ii = s.indexOf("/");
                                int iii = s.indexOf("^");
                                String uom = s.substring(1, i);
                                double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                                double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
                                int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));

                                if (is_default == 1) {
                                    selling_price = data.selling_price;
                                }
                                if (index == 0) {
                                    uoms = "[" + uom + ":" + new_price + "/" + conversion + "^" + is_default + "]";
                                } else {
                                    uoms = uoms + ",[" + uom + ":" + selling_price + "/" + conversion + "^" + is_default + "]";
                                }
                                index++;
                            }
                            Inventory.update_price(to.main_barcode, data.selling_price, uoms);
                            data_cols();
                            tbl_items.setRowSelectionInterval(row, row);
                        }
                    });
                    nd.setLocationRelativeTo(jScrollPane3);
                    nd.setVisible(true);
                }

            } else if (col == 5) {
                Window p = (Window) this;
                Dlg_touchscreen_location_stocks nd = Dlg_touchscreen_location_stocks.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.main_barcode);
                nd.setCallback(new Dlg_touchscreen_location_stocks.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_touchscreen_location_stocks.OutputData data) {
                        closeDialog.ok();
                    }
                });
                nd.setLocationRelativeTo(jScrollPane3);
                nd.setVisible(true);
            } else {
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
                    to_uom to1 = new to_uom(uom1, selling_price, conversion, is_default);
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
                cardLayout.show(jPanel13, "1");
                tbl_uom.grabFocus();
                jButton43.setText("Add Order");
            }
        } else {
            int col = tbl_items.getSelectedColumn();
            if (col == 4) {
                String where = " where user_name='" + Users.user_name + "' order by previledge asc";
                List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
                int exists = 0;
                for (S1_user_previleges.to_user_previleges to1 : datas) {
                    if (to1.previledge.equalsIgnoreCase("Inventory Update Item Pricing")) {
                        exists = 1;
                        break;
                    }
                }

                if (exists == 1) {
                    Window p = (Window) this;
                    Dlg_touchscreen_update_price nd = Dlg_touchscreen_update_price.create(p, true);
                    nd.setTitle("");
                    nd.do_pass(to.selling_price);
                    nd.setCallback(new Dlg_touchscreen_update_price.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_touchscreen_update_price.OutputData data) {
                            closeDialog.ok();
                            String uoms = "";
                            double new_price = data.selling_price;
                            String unit = to.unit;
                            String[] list = unit.split(",");
                            int index = 0;
                            for (String s : list) {
                                int i = s.indexOf(":");
                                int ii = s.indexOf("/");
                                int iii = s.indexOf("^");
                                String uom = s.substring(1, i);
                                double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                                double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
                                int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));

                                if (is_default == 1) {
                                    selling_price = data.selling_price;
                                }
                                if (index == 0) {
                                    uoms = "[" + uom + ":" + new_price + "/" + conversion + "^" + is_default + "]";
                                } else {
                                    uoms = uoms + ",[" + uom + ":" + selling_price + "/" + conversion + "^" + is_default + "]";
                                }
                                index++;
                            }

                            Inventory.update_price(to.main_barcode, data.selling_price, uoms);
                            data_cols();
                            tbl_items.setRowSelectionInterval(row, row);

                        }
                    });
                    nd.setLocationRelativeTo(jScrollPane3);
                    nd.setVisible(true);
                }

            } else if (col == 5) {
                Window p = (Window) this;
                Dlg_touchscreen_location_stocks nd = Dlg_touchscreen_location_stocks.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.main_barcode);
                nd.setCallback(new Dlg_touchscreen_location_stocks.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_touchscreen_location_stocks.OutputData data) {
                        closeDialog.ok();
                    }
                });
                nd.setLocationRelativeTo(jScrollPane3);
                nd.setVisible(true);
            } else {
                Window p = (Window) this;
                Dlg_inventory_assembly nd = Dlg_inventory_assembly.create(p, true);
                nd.setTitle("");
                nd.do_pass(to);
                nd.setCallback(new Dlg_inventory_assembly.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_inventory_assembly.OutputData data) {
                        closeDialog.ok();
                        tbl_orders_ALM.addAll(data.assemble);
                        tbl_orders_M.fireTableDataChanged();
                        compute_total();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
    }

    private void add_order() {
        if (jButton43.getText().equalsIgnoreCase("Add Order")) {
            int row = tbl_items.getSelectedRow();
            if (row < 0) {
                return;
            }
            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_items_ALM.get(row);
            Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
            Label.Item_discount serial = (Label.Item_discount) jLabel47;
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
            int row2 = tbl_uom.getSelectedRow();
            if (row2 < 0) {
                return;
            }
            to_uom uom = (to_uom) tbl_uom_ALM.get(row2);
            double conversion = uom.conversion;
            String unit = "[" + uom.unit + ":" + uom.price + "/" + uom.conversion + "^" + "1" + "]";
            if (product_qty <= 0) {
                product_qty = 1;
            }
            double selling_price = uom.price;
            String date_added = DateType.now();
            String user_name = "";
            String item_type = to.item_type;
            int status = 0;
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
            String serial_no = serial.getDiscount_customer_id();
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
            cardLayout.show(jPanel13, "2");
            lbl.clearAll();
            lbl_item_discount.setText("");
            tf_addtl_cash.setText("");
            tf_wtax.setText("");
            serial.setDiscount_customer_id("");
            tf_search.grabFocus();
        } else {
            int row = tbl_orders.getSelectedRow();
            if (row < 0) {
                return;
            }
            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_orders_ALM.get(row);
            Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
            Label.Item_discount serial = (Label.Item_discount) jLabel47;

            double addtl_cash = FitIn.toDouble(tf_addtl_cash.getText());
            double wtax = FitIn.toDouble(tf_wtax.getText());
            double product_qty = FitIn.toDouble(lbl_qty.getText());

            product_qty = FitIn.toDouble(lbl_qty.getText());
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
            to.setSerial_no(serial.getDiscount_customer_id());
            serial.setDiscount_customer_id("");
            tbl_orders_M.fireTableDataChanged();
            compute_total();
            lbl_qty.setText("1");
            cardLayout.show(jPanel13, "2");
            lbl.clearAll();
            lbl_item_discount.setText("");
            tf_addtl_cash.setText("");
            tf_wtax.setText("");
            tf_search.grabFocus();
        }

    }

    private void set_qty(boolean increase) {
        double qty = FitIn.toDouble(lbl_qty.getText());
        if (increase) {
            qty++;
        } else if (qty != 1) {
            qty--;
        }
        lbl_qty.setText(FitIn.fmt_woc(qty));
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
        lbl_p_amount_due.setText(FitIn.fmt_wc_0(total));
        double balance_due = total - or_discount;
        lbl_balance_due.setText(FitIn.fmt_wc_0(balance_due));
        lbl_p_balance_due.setText(FitIn.fmt_wc_0(balance_due));
        Payments.balance_due = balance_due;
        lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
        tf_amount_tendered.setText(FitIn.fmt_wc_0(balance_due));

    }

    private void select_customer() {
        Window p = (Window) this;
        Dlg_touchscreen_customers nd = Dlg_touchscreen_customers.create(p, true);
        nd.setTitle("");
        Label.Normal cust = (Label.Normal) lbl_customer_name;
        String customer_name = cust.getCustomer_name();
        String customer_id = cust.getCustomer_id();
        nd.do_pass(customer_name, customer_id);
        nd.setCallback(new Dlg_touchscreen_customers.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_customers.OutputData data) {
                closeDialog.ok();
                My_services_customers.to_my_services_customers customer = data.customer;
                lbl_customer_name.setText(customer.customer_name);
                jLabel36.setText("" + customer.customer_no);
                Label.Normal cust = (Label.Normal) lbl_customer_name;
                cust.setCustomer_id("" + customer.id);
                cust.setCustomer_name(customer.customer_name);
                cust.setCustomer_no(customer.customer_no);
            }
        });
        Point loc = jLabel42.getLocationOnScreen();
        nd.setLocation(loc.x + 45, loc.y);
        nd.setVisible(true);
    }

    private void view_orders() {
        Window p = (Window) this;
        Dlg_touchscreen_orders nd = Dlg_touchscreen_orders.create(p, true);
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_orders.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_orders.OutputData data) {
                closeDialog.ok();
                Label.Item_discount f_discount = (Label.Item_discount) lbl_due_discount;
                Label.Normal cust = (Label.Normal) lbl_customer_name;
                S1_orders.to_orders order = data.order;
                f_discount.setDiscount_amount(order.discount_amount);
                f_discount.setDiscount_customer_id(order.discount_customer_id);
                f_discount.setDiscount_customer_name(order.discount_customer_name);
                f_discount.setDiscount_name(order.discount_name);
                f_discount.setDiscount_rate(order.discount_rate);
                cust.setCustomer_name(order.customer_name);
                cust.setCustomer_id(order.session_no);
                lbl_sales_no.setText(order.sales_no);
                lbl_customer_name.setText(order.customer_name);
                jLabel36.setText(order.session_no);

                lbl_sub_total1.setText(FitIn.fmt_wc_0(order.gross_amount));
                lbl_sub_total2.setText(FitIn.fmt_wc_0(order.gross_amount));

                lbl_line_discount.setText(FitIn.fmt_wc_0(order.line_discount));
                lbl_due_discount.setText(FitIn.fmt_wc_0(order.discount_amount));
                lbl_total.setText(FitIn.fmt_wc_0(order.gross_amount - order.line_discount));
                lbl_balance_due.setText(FitIn.fmt_wc_0(order.amount_due));

                List<S1_order_items.to_order_items> order_items = data.order_items;
                List<Inventory_barcodes.to_inventory_barcodes> datas = new ArrayList();

                for (S1_order_items.to_order_items to : order_items) {
                    int id = to.id;
                    String barcode = to.barcode;
                    String description = to.description;
                    String generic_name = to.generic_name;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_classification = to.sub_classification;
                    String sub_classification_id = to.sub_classification_id;
                    double product_qty = to.product_qty;
                    String unit = to.unit;
                    double conversion = to.conversion;
                    double selling_price = to.selling_price;
                    String date_added = to.date_added;
                    String user_name = MyUser.getUser_name();
                    String item_type = to.item_type;
                    int status = to.status;
                    String supplier = to.supplier_name;
                    int fixed_price = 0;
                    double cost = 0;
                    String supplier_id = to.supplier_id;
                    int multi_level_pricing = 0;
                    int vatable = to.is_vatable;
                    double reorder_level = 0;
                    double markup = 0;
                    String main_barcode = to.item_code;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    int selling_type = to.selling_type;
                    String branch = to.branch;
                    String branch_code = to.branch_code;
                    String location = to.location;
                    String location_id = to.location_id;
                    String serial_no = to.serial_no;
                    String selected_serials = to.serial_no;
                    double discount = to.discount_rate;
                    double discount_amount = to.discount_amount;
                    String discount_name = to.discount_name;
                    String discount_customer_name = to.discount_customer_name;
                    String discount_customer_id = to.discount_customer_id;
                    double addtl_cash = 0;
                    double wtax = 0;
                    String sales_no = "";
                    String item_code = to.item_code;
                    String supplier_name = to.supplier_name;
                    String user_id = MyUser.getUser_id();
                    String user_screen_name = MyUser.user_screen_name;
                    int is_vatable = to.is_vatable;
                    double discount_rate = to.discount_rate;
                    double addtl_amount = to.addtl_amount;

                    Inventory_barcodes.to_inventory_barcodes t = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, selected_serials, discount, discount_amount, discount_name, discount_customer_name, discount_customer_id, addtl_amount, wtax);
                    datas.add(t);
                }

                loadData_orders(datas);
                tbl_orders_M.fireTableDataChanged();
                compute_total();
            }
        }
        );
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void view_services() {
        Window p = (Window) this;
        Dlg_touchscreen_services nd = Dlg_touchscreen_services.create(p, true);
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_services.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_services.OutputData data) {
                closeDialog.ok();

            }
        }
        );
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void save_order() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Label.Item_discount f_discount = (Label.Item_discount) lbl_due_discount;
                Label.Normal f_customer = (Label.Normal) lbl_customer_name;
                int id = 0;
                String sales_no = S1_orders.increment_id();
                String date_added = DateType.now();
                String user_name = Users.get_UserName();
                String session_no = f_customer.getCustomer_id();
                double gross_amount = FitIn.toDouble(lbl_sub_total2.getText());
                double amount_paid = FitIn.toDouble(lbl_balance_due.getText());
                double amount_due = FitIn.toDouble(lbl_balance_due.getText());

                String discount_name = f_discount.getDiscount_name();
                double discount = f_discount.getDiscount_rate();
                double discount_amount = f_discount.getDiscount_amount();
                String discount_customer_name = f_discount.getDiscount_customer_name();
                String discount_customer_id = f_discount.getDiscount_customer_id();

                String customer_name = f_customer.getCustomer_name();
                String check_bank = "";
                String check_no = "";
                double check_amount = 0;
                String check_date = DateType.sf.format(new Date());
                int status = 0;
                String or_no = sales_no;
                String check_holder = "";
                String services = "";
                double service_amount = 0;
                String charge_account_name = "";
                double charge_amount = 0;
                String charge_account_id = "";
                double credit_card = 0;
                String credit_card_name = "";
                double credit_card_rate = 0;
                double credit_card_amount = 0;
                int sales_type = 0;
                double prepaid_amount = 0;
                String prepaid_customer_id = "";
                String prepaid_customer_name = "";

                double line_discount = FitIn.toDouble(lbl_line_discount.getText());

                String user_screen_name = MyUser.getUser_screen_name();
                String user_id = MyUser.getUser_id();
                String remarks = "";
                String customer_id = f_customer.getCustomer_id();
                double discount_rate1 = f_discount.getDiscount_rate();
                String charge_type = "";
                String charge_type_id = "";
                String charge_reference_no = "";
                String charge_customer_name = "";
                String charge_customer_id = "";
                String credit_card_type = "";
                String credit_card_no = "";
                String credit_card_holder = "";
                String credit_card_approval_code = "";
                String gift_certificate_from = "";
                String gift_certificate_description = "";
                String gift_certificate_no = "";
                double gift_certificate_amount = 0;
                double addtl_amount = 0;
                double wtax = 0;
                String branch1 = my_branch;
                String branch_id1 = my_branch_id;
                String location1 = my_location;
                String location_id1 = my_location_id;

                List<S1_order_items.to_order_items> orders = new ArrayList();
                List<Inventory_barcodes.to_inventory_barcodes> datas = tbl_orders_ALM;
                if (lbl_sales_no.getText().equalsIgnoreCase("000000000000")) {
                    S1_orders.to_orders order = new S1_orders.to_orders(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate1, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount, wtax, branch1, branch_id1, location1, location_id1);
                    for (Inventory_barcodes.to_inventory_barcodes to : datas) {
                        String barcode = to.barcode;
                        String description = to.description;
                        String generic_name = to.generic_name;
                        String category = to.category;
                        String category_id = to.category_id;
                        String classification = to.classification;
                        String classification_id = to.classification_id;
                        String sub_classification = to.sub_classification;
                        String sub_classification_id = to.sub_classification_id;
                        double product_qty = to.product_qty;
                        String unit = to.unit;
                        double conversion = to.conversion;
                        double selling_price = to.selling_price;
                        String item_type = to.item_type;
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
                        String discount_name1 = to.discount_name;
                        double discount_rate = to.discount;
                        double discount_amount1 = to.discount_amount;
                        String added_by = user_name;
                        String serial_no = to.serial_no;
                        String discount_customer_name1 = to.discount_customer_name;
                        String discount_customer_id1 = to.discount_customer_id;
                        String item_code = to.main_barcode;
                        String supplier_name = to.supplier;
                        int is_vatable = to.vatable;
                        S1_order_items.to_order_items ord = new S1_order_items.to_order_items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name1, discount_rate, discount_amount1, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, addtl_amount, wtax);
                        orders.add(ord);
                    }
                    System.out.println("Discount: " + sales_no + " = " + f_discount.getDiscount_amount());
                    S1_orders.add_data(order);
                    S1_order_items.add_data(orders);
                } else {
                    sales_no = lbl_sales_no.getText();
                    or_no = sales_no;
                    System.out.println("Discount: " + sales_no + " = " + f_discount.getDiscount_amount());
                    S1_orders.to_orders order = new S1_orders.to_orders(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate1, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount, wtax, branch1, branch_id1, location1, location_id1);
                    for (Inventory_barcodes.to_inventory_barcodes to : datas) {
                        String barcode = to.barcode;
                        String description = to.description;
                        String generic_name = to.generic_name;
                        String category = to.category;
                        String category_id = to.category_id;
                        String classification = to.classification;
                        String classification_id = to.classification_id;
                        String sub_classification = to.sub_classification;
                        String sub_classification_id = to.sub_classification_id;
                        double product_qty = to.product_qty;
                        String unit = to.unit;
                        double conversion = to.conversion;
                        double selling_price = to.selling_price;
                        String item_type = to.item_type;
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
                        String discount_name1 = to.discount_name;
                        double discount_rate = to.discount;
                        double discount_amount1 = to.discount_amount;
                        String added_by = user_name;
                        String serial_no = to.serial_no;
                        String discount_customer_name1 = to.discount_customer_name;
                        String discount_customer_id1 = to.discount_customer_id;
                        String item_code = to.main_barcode;
                        String supplier_name = to.supplier;
                        int is_vatable = to.vatable;
                        S1_order_items.to_order_items ord = new S1_order_items.to_order_items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, addtl_amount, wtax);
                        orders.add(ord);
                    }
                    S1_orders.update_data(order);
                    String where = " where sales_no='" + or_no + "'";
                    S1_order_items.delete_data(where);
                    S1_order_items.add_data(orders);
                }
                f_discount.clearAll();
                f_customer.clearAll();
                lbl_sub_total1.setText("0.00");
                lbl_line_discount.setText("0.00");
                lbl_due_discount.setText("0.00");
                lbl_sub_total2.setText("0.00");
                lbl_total.setText("0.00");
                lbl_balance_due.setText("0.00");
                lbl_sales_no.setText("000000000000");
                lbl_customer_name.setText("Customer Name");
                jLabel36.setText("ID NO");
                tbl_orders_ALM.clear();
                tbl_orders_M.fireTableDataChanged();
                Alert.set(0, "Order Saved!");
            }
        });
        t.start();
    }

    private void item_discount() {
        int row2 = tbl_uom.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_uom uom = (to_uom) tbl_uom_ALM.get(row2);
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

    private void serial_no() {

        Label.Item_discount lbl1 = (Label.Item_discount) jLabel47;

        Window p = (Window) this;
        Dlg_touchscreen_serial_number nd = Dlg_touchscreen_serial_number.create(p, true);
        nd.setTitle("");
        nd.do_pass(lbl1.getDiscount_customer_id());
        nd.setCallback(new Dlg_touchscreen_serial_number.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_serial_number.OutputData data) {
                closeDialog.ok();
                Label.Item_discount lbl = (Label.Item_discount) jLabel47;
                lbl.setDiscount_customer_id(data.serial_no);
            }
        });
        Point loc = jLabel47.getLocationOnScreen();
        nd.setLocation(loc.x, loc.y - 380);
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
        Point loc = jButton37.getLocationOnScreen();
        nd.setLocation(loc.x + 55, loc.y - 300);
        nd.setVisible(true);
    }

    private void menu() {

        Window p = (Window) this;
        Dlg_touchscreen_logout nd = Dlg_touchscreen_logout.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_logout.Callback() {
            @Override
            public void cashcount(CloseDialog closeDialog, Dlg_touchscreen_logout.OutputData data) {
                closeDialog.ok();
                if (jButton40.isVisible()) {
                    log_out();
                }

            }

            @Override
            public void logout(CloseDialog closeDialog, Dlg_touchscreen_logout.OutputData data) {
                closeDialog.ok();
                exit();

            }

            @Override
            public void maintenance(CloseDialog closeDialog, Dlg_touchscreen_logout.OutputData data) {
                closeDialog.ok();
            }

            @Override
            public void standby(CloseDialog closeDialog, Dlg_touchscreen_logout.OutputData data) {
                closeDialog.ok();
                stand_by();
            }

            @Override
            public void reports(CloseDialog closeDialog, Dlg_touchscreen_logout.OutputData data) {
                closeDialog.ok();
                if (jButton40.isVisible()) {
                    menu_reports();
                }

            }

        });
        Point loc = jButton1.getLocationOnScreen();
        nd.setLocation(loc.x - 130, loc.y + 68);
        nd.setVisible(true);
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

    private void cancel_order() {
        Window p = (Window) this;
        Confirm nd = Confirm.create(p, true);
        nd.setTitle("");
        nd.do_pass(this.getSurface());
        nd.setCallback(new Confirm.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Confirm.OutputData data) {
                closeDialog.ok();
                Label.Item_discount f_discount = (Label.Item_discount) lbl_due_discount;
                Label.Normal f_customer = (Label.Normal) lbl_customer_name;
                Label.Item_discount serial = (Label.Item_discount) jLabel47;
                String where = " where sales_no='" + lbl_sales_no.getText() + "'";
                S1_orders.delete_data(where);
                S1_order_items.delete_data(where);
                f_discount.clearAll();
                f_customer.clearAll();
                lbl_sub_total1.setText("0.00");
                lbl_line_discount.setText("0.00");
                lbl_due_discount.setText("0.00");
                lbl_sub_total2.setText("0.00");
                lbl_total.setText("0.00");
                lbl_balance_due.setText("0.00");
                lbl_sales_no.setText("000000000000");
                lbl_customer_name.setText("Customer Name");
                jLabel36.setText("ID NO");

                tbl_orders_ALM.clear();
                tbl_orders_M.fireTableDataChanged();
                Alert.set(0, "Order Cancelled");

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

    private void input_amount() {
        double tendered = FitIn.toDouble(tf_amount_tendered.getText());
        JButton[] btns = {btn_charge20, btn_charge21, btn_charge22, btn_charge17, btn_charge19, btn_charge18, btn_charge12, btn_charge15, btn_charge16, btn_charge13, btn_charge14};
        for (final JButton b : btns) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String amount = tf_amount_tendered.getText();
                    amount = amount + b.getText();
                    tf_amount_tendered.setText(amount);
                }
            });
        }
    }

    private void payment_credit() {

        Window p = (Window) this;
        Dlg_touchscreen_credit_card nd = Dlg_touchscreen_credit_card.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_credit_card.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_credit_card.OutputData data) {
                closeDialog.ok();
                Payments.credit_card card = Payments.credit_card;
                lbl_credit.setText(FitIn.fmt_wc_0(card.amount));
                lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
            }
        });
        Point loc = btn_charge2.getLocationOnScreen();
        nd.setLocation(loc.x + 46, loc.y - 137);
        nd.setVisible(true);
    }

    private void payment_gc() {

        Window p = (Window) this;
        Dlg_touchscreen_gift_certificate nd = Dlg_touchscreen_gift_certificate.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_gift_certificate.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_gift_certificate.OutputData data) {
                closeDialog.ok();
                Payments.gift_certificate card = Payments.gift_certificate;
                lbl_gift.setText(FitIn.fmt_wc_0(card.amount));
                lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
            }
        });
        Point loc = btn_charge2.getLocationOnScreen();
        nd.setLocation(loc.x + 46, loc.y - 137);
        nd.setVisible(true);
    }

    private void payment_prepaid() {
        String prepaid_payment = System.getProperty("module_prepayments", "0");
        if (prepaid_payment.equalsIgnoreCase("1")) {
            Window p = (Window) this;
            Dlg_touchscreen_prepaid nd = Dlg_touchscreen_prepaid.create(p, true);
            nd.setTitle("");
            nd.do_pass();
            nd.setCallback(new Dlg_touchscreen_prepaid.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_touchscreen_prepaid.OutputData data) {
                    closeDialog.ok();
                    Payments.prepaid card = Payments.prepaid;
                    lbl_prepaid.setText(FitIn.fmt_wc_0(card.amount));
                    lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
                }
            });
            Point loc = btn_charge2.getLocationOnScreen();
            nd.setLocation(loc.x + 46, loc.y - 137);
            nd.setVisible(true);
        }

    }

    private void payment_cheque() {
        Window p = (Window) this;
        Dlg_touchscreen_cheque nd = Dlg_touchscreen_cheque.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_cheque.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_cheque.OutputData data) {
                closeDialog.ok();
                Payments.cheque card = Payments.cheque;
                lbl_cheque.setText(FitIn.fmt_wc_0(card.amount));
                lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
            }
        });
        Point loc = btn_charge2.getLocationOnScreen();
        nd.setLocation(loc.x + 46, loc.y - 137);
        nd.setVisible(true);
    }

    private void payment_charge() {
        String charge_payment = System.getProperty("module_accounts_receivable", "0");
        if (charge_payment.equalsIgnoreCase("1")) {
            Window p = (Window) this;
            Dlg_touchscreen_charge nd = Dlg_touchscreen_charge.create(p, true);
            nd.setTitle("");
            nd.do_pass();
            nd.setCallback(new Dlg_touchscreen_charge.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_touchscreen_charge.OutputData data) {
                    closeDialog.ok();
                    Payments.charge card = Payments.charge;
                    lbl_charge.setText(FitIn.fmt_wc_0(card.amount));
                    lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
                }
            });
            Point loc = btn_charge2.getLocationOnScreen();
            nd.setLocation(loc.x + 46, loc.y - 137);
            nd.setVisible(true);
        }

    }

    private void type_cash() {
        if (btn_cash.isSelected()) {
            double balance_due = FitIn.toDouble(lbl_p_balance_due.getText());
            double tendered = FitIn.toDouble(tf_amount_tendered.getText());
            if (tendered <= 0) {
                lbl_cash.setText("");
                Payments.cash cash = new Payments.cash(0);
                Payments.cash = cash;
            } else {
                lbl_cash.setText(FitIn.fmt_wc_0(tendered));
                Payments.cash cash = new Payments.cash(tendered);
                Payments.cash = cash;
            }
            lbl_p_change.setText(FitIn.fmt_wc_0(Payments.countChange2()));
        }

    }

    private void compute_change() {
        double balance_due = FitIn.toDouble(lbl_p_balance_due.getText());
        double cash = FitIn.toDouble(lbl_cash.getText());
        double change = (cash) - balance_due;

        double all_tendered = cash;
        lbl_p_all_tendered.setText(FitIn.fmt_wc_0(all_tendered));
        lbl_p_change.setText(FitIn.fmt_wc_0(change));
    }

    private void update_item() {
        int row = tbl_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_orders.getSelectedColumn();
        if (col == 3) {
            Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
            Label.Item_discount serial = (Label.Item_discount) jLabel47;
            tbl_orders_ALM.remove(row);
            tbl_orders_M.fireTableDataChanged();
            compute_total();
            lbl_qty.setText("1");
            cardLayout.show(jPanel13, "2");
            lbl.clearAll();
            lbl_item_discount.setText("");
            tf_addtl_cash.setText("");
            tf_wtax.setText("");
            serial.setDiscount_customer_id("");
            tf_search.grabFocus();
        } else {
            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_orders_ALM.get(row);
            Label.Item_discount lbl = (Label.Item_discount) lbl_item_discount;
            Label.Item_discount serial = (Label.Item_discount) jLabel47;

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
            serial.setDiscount_customer_id(to.serial_no);
            lbl_item_discount.setText(FitIn.fmt_wc_0(to.discount_amount));
            tf_addtl_cash.setText(FitIn.fmt_wc_0(to.addtl_amount));
            tf_wtax.setText(FitIn.fmt_wc_0(to.wtax));
            Dlg_inventory_uom.to_uom um1 = uom.default_uom(to.unit);
            S1_unit_of_measure.to_uom um2 = new to_uom(um1.uom, um1.selling_price, um1.conversion, um1.is_default);
            tbl_uom_ALM.clear();
            tbl_uom_ALM.add(um2);
            tbl_uom_M.fireTableDataChanged();
            tbl_uom.setRowSelectionInterval(0, 0);
            cardLayout.show(jPanel13, "1");
            tbl_uom.grabFocus();
        }
    }

    private void warning() {
        Window p = (Window) this;
        Warning nd = Warning.create(p, true);
        nd.setTitle("");
        nd.do_pass(jPanel1, "No Order/s Added!");
        nd.setCallback(new Warning.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Warning.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void payment() {
        if (tbl_orders_ALM.isEmpty()) {
            warning();
        } else {
            type_cash();
            pnl_orders.setVisible(false);
            cardLayout.show(jPanel13, "3");
            tf_amount_tendered.grabFocus();
        }
    }
    int mytime = 0;

    Timer time = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mytime == 5) {
                mytime = 0;
                time.stop();
//                load.disposed();
//                load.setVisible(false);
            }

            mytime++;
        }
    });

    private void show_loader() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
//        load.setSize(xSize, ySize);
//        load.setVisible(true);
        System.out.println("Showing Loader...");
    }

    public void settle_now() {
        List<MySales_Items.items> items1 = new ArrayList();
        double change = FitIn.toDouble(lbl_p_change.getText());
        final Label.Normal f_customer = (Label.Normal) lbl_customer_name;
        final Label.Item_discount f_discount = (Label.Item_discount) lbl_due_discount;
        Payments.charge f_charge = Payments.charge;
        Payments.cheque f_cheque = Payments.cheque;
        Payments.credit_card f_credit_card = Payments.credit_card;
        Payments.gift_certificate f_gift_certificate = Payments.gift_certificate;
        Payments.prepaid f_prepaid = Payments.prepaid;
        int id = 0;
        String sales_no = "";
        String date_added = DateType.now();
        String user_screen_name = Users.get_ScreenName();
        String user_id = Users.getPassword();
        String session_no = lbl_sales_no.getText();
        String remarks = "";
        final double gross_amount = FitIn.toDouble(lbl_sub_total1.getText());
        double amount_due = FitIn.toDouble(lbl_balance_due.getText());
        int status = 0;
        int sales_type = 0;
        final double line_discount = FitIn.toDouble(lbl_line_discount.getText());
        String customer_id = f_customer.getCustomer_id();
        String customer_name = f_customer.getCustomer_name();

        String discount_name = f_discount.getDiscount_name();
        double discount_rate = f_discount.getDiscount_rate();
        double discount_amount = f_discount.getDiscount_amount();
        String discount_customer_name = f_discount.getDiscount_customer_name();
        String discount_customer_id = f_discount.getDiscount_customer_id();

        String charge_type = f_charge.charge_type;
        String charge_type_id = f_charge.charge_type_id;
        String charge_reference_no = f_charge.reference_no;
        String charge_customer_name = f_charge.customer_name;
        String charge_customer_id = f_charge.customer_id;
        double charge_amount = f_charge.amount;

        String check_bank = f_cheque.bank;
        String check_no = f_cheque.check_no;
        double check_amount = f_cheque.amount;
        String check_holder = f_cheque.check_holder;
        String check_date = f_cheque.check_date;

        String credit_card_type = f_credit_card.card_type;
        double credit_card_rate = f_credit_card.rate;
        double credit_card_amount = f_credit_card.amount;
        String credit_card_no = f_credit_card.card_no;
        String credit_card_holder = f_credit_card.card_holder;
        String credit_card_approval_code = f_credit_card.approval_code;
        String gift_certificate_from = f_gift_certificate.from;
        String gift_certificate_description = f_gift_certificate.description;
        String gift_certificate_no = f_gift_certificate.gc_no;
        double gift_certificate_amount = f_gift_certificate.amount;
        String prepaid_customer_name = f_prepaid.customer_name;
        String prepaid_customer_id = f_prepaid.customer_id;
        double prepaid_amount = f_prepaid.amount;
        double addtl_amount = FitIn.toDouble(lbl_line_discount1.getText());
        double wtax = FitIn.toDouble(lbl_due_discount1.getText());
        final List<Inventory_barcodes.to_inventory_barcodes> orders = tbl_orders_ALM;
        final List<MySales_Items.items> items = MySales_Items.convert_order(orders);

        Field.Combo br = (Field.Combo) jTextField2;
        Field.Combo lo = (Field.Combo) jTextField1;
        String branch = br.getText();
        String branch_id = br.getId();
        String location = lo.getText();
        String location_id = my_location_id;

        final MySales.sales sales = new MySales.sales(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount, wtax, branch, branch_id, location, location_id, items1);
        try {
            sales_no = MySales.add_sales(sales, items, location_id);
            sales.setSales_no(sales_no);

            my_sales = sales;
            if (my_sales == null) {
                System.out.println("NULL");
            } else {
                System.out.println("NOT NULL");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dlg_touchscreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    MySales.sales my_sales = null;

    private void set_change() {
        final List<Inventory_barcodes.to_inventory_barcodes> orders = tbl_orders_ALM;
        final Label.Normal f_customer = (Label.Normal) lbl_customer_name;
        final Label.Item_discount f_discount = (Label.Item_discount) lbl_due_discount;
        Window p = (Window) Dlg_touchscreen.this;
        Dlg_touchscreen_change nd = Dlg_touchscreen_change.create(p, true);
        nd.setTitle("");
        System.out.println("Orders: " + orders);
        System.out.println("Customer: " + f_customer.getCustomer_id());
        System.out.println("Discount:" + f_discount.getDiscount_customer_id());
        System.out.println("Gross: " + my_sales.gross_amount);
        System.out.println("Line Discount: " + my_sales.line_discount);
        System.out.println("Sales: " + my_sales);

        nd.do_pass(orders, f_customer, f_discount, my_sales.gross_amount, my_sales.line_discount, my_sales);
        nd.setCallback(new Dlg_touchscreen_change.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_change.OutputData data) {
                closeDialog.ok();
                System.out.println("Transaction Settled");
                System.out.println("Clearing Fields.......");
                Label.Normal cust = (Label.Normal) lbl_customer_name;
                tbl_orders_ALM.clear();
                tbl_orders_M.fireTableDataChanged();
                tf_search.grabFocus();
                Payments.clearAll();
                f_discount.clearAll();
                lbl_customer_name.setText("Customer Name");
                jLabel36.setText("ID NO");
                cust.clearAll();
                System.out.println("Fields Cleared......");
                pnl_orders.setVisible(true);
                cardLayout.show(jPanel13, "2");
                tf_search.grabFocus();
                tf_amount_tendered.setText("0.00");
                lbl_sub_total1.setText("0.00");
                lbl_line_discount.setText("0.00");
                lbl_due_discount.setText("0.00");
                lbl_sub_total2.setText("0.00");
                lbl_total.setText("0.00");
                lbl_balance_due.setText("0.00");
                lbl_due_discount1.setText("0.00");
                lbl_line_discount1.setText("0.00");
                lbl_sales_no.setText("000000000000");
                lbl_customer_name.setText("Customer Name");
                jLabel36.setText("ID NO");
                lbl_cash.setText("");
                lbl_credit.setText("");
                lbl_gift.setText("");
                lbl_prepaid.setText("");
                lbl_cheque.setText("");
                lbl_charge.setText("");
                my_sales = null;
                tf_amount_tendered.setEnabled(true);

                compute_total();
                data_cols2();
                cardLayout.show(jPanel13, "2");
                tf_search.selectAll();
                tf_search.grabFocus();
                tf_search.setEnabled(true);
            }
        });
        nd.setLocationRelativeTo(null);
        nd.setVisible(true);
    }

    private void settle_transaction() {
        double change = FitIn.toDouble(lbl_p_change.getText());
        if (change < 0) {
            Window p = (Window) this;
            Warning nd = Warning.create(p, true);
            nd.setTitle("");
            nd.do_pass(jPanel1, "Not Enough Amount Tendered!");
            nd.setCallback(new Warning.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Warning.OutputData data) {
                    closeDialog.ok();
                }
            });
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().getHeight());
            nd.setSize(xSize, ySize);
            nd.setVisible(true);
        } else {
            tf_amount_tendered.setEnabled(false);
            Loader loader = new Loader(this);
            loader.execute();
        }

    }

    private void change() {

    }

    private void menu_reports() {
        Window p = (Window) this;
        Dlg_touchscreen_cashier_reports nd = Dlg_touchscreen_cashier_reports.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_cashier_reports.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_cashier_reports.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void log_out() {
        Window p = (Window) this;
        Dlg_touchscreen_cashcount nd = Dlg_touchscreen_cashcount.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_cashcount.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_cashcount.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void stand_by() {
        Window p = (Window) this;
        Authenticate nd = Authenticate.create(p, true);
        nd.setTitle("");

        nd.do_pass(this.getSurface(), "");
        nd.setCallback(new Authenticate.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Authenticate.OutputData data) {

                String username = data.username;
                String password = data.password;
                final S1_users.to_users to = S1_users.ret_data_autho(username, password);
                if (to == null) {
                    warning("Input correct credentials!");
                } else {
                    String where = " where user_name='" + username + "' order by previledge asc";
                    List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
                    int exist = 0;
                    for (S1_user_previleges.to_user_previleges to2 : datas) {
                        if (to2.previledge.equalsIgnoreCase("Sales")) {
                            exist = 1;
                            break;
                        }
                        if (to2.previledge.equalsIgnoreCase("Salesman")) {
                            exist = 1;
                            break;
                        }
                    }
                    if (exist == 1) {
                        closeDialog.ok();
                    } else {
                        warning("User priviledge not added!");
                    }
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
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
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void exit() {
        Window p = (Window) this;
        Confirm nd = Confirm.create(p, true);
        nd.setTitle("");

        nd.do_pass(this.getSurface());

        nd.setCallback(new Confirm.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Confirm.OutputData data) {
                closeDialog.ok();
                System.exit(1);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void advance_search2() {
        Window p = (Window) this;
        Dlg_report_item nd = Dlg_report_item.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_report_item.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void advance_search() {
        Window p = (Window) this;
        Dlg_touchscreen_advance_search nd = Dlg_touchscreen_advance_search.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_touchscreen_advance_search.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, final Dlg_touchscreen_advance_search.OutputData data) {
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String search = tf_search.getText();
                        String category_name = data.category_name;
                        String category_id = data.category_id;
                        String classification_name = data.classification_name;
                        String classification_id = data.classification_id;
                        String sub_classification_name = data.sub_classification_name;
                        String sub_classification_id = data.sub_classification_id;
                        String brand_name = data.brand_name;
                        String brand_id = data.brand_id;
                        String model_name = data.model_name;
                        String model_id = data.model_id;
                        String supplier_name = data.supplier_name;
                        String supplier_id = data.supplier_id;

                        String where = " where "
                                + " category like '%" + category_name + "%'  "
                                + " and classification like '%" + classification_name + "%'  "
                                + " and sub_classification like '%" + sub_classification_name + "%'  "
                                + " and brand like '%" + brand_name + "%'  "
                                + " and model like '%" + model_name + "%'  "
                                + " and supplier like '%" + supplier_name + "%' and description like '%" + search + "%' and location_id='" + my_location_id + "' "
                                + ""
                                + "";
                        loadData_items(Inventory_barcodes.ret_where(where));
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();
            }
        });
        Point loc = tf_search.getLocationOnScreen();
        nd.setLocation(loc.x - 485, loc.y);
        nd.setVisible(true);
//        Window p = (Window) this;
//        Dlg_search_inventory nd = Dlg_search_inventory.create(p, true);
//        nd.setTitle("");
//
//        nd.setCallback(new Dlg_search_inventory.Callback() {
//
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_search_inventory.OutputData data) {
//                closeDialog.ok();
//                
//                tf_search.setText(data.item_code);
//                data_cols();
//            }
//        });
//        nd.setLocationRelativeTo(this);
//        nd.setVisible(true);
    }

    public class Loader extends SwingWorker {

        private Loading dialog;

        public Loader(JDialog dlg) {

            dialog = new Loading();
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            dialog.setSize(xSize, ySize);
            dialog.setPreferredSize(new Dimension(xSize, ySize));
            dialog.setAlwaysOnTop(true);
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        if (getState() == SwingWorker.StateValue.STARTED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (getState() == SwingWorker.StateValue.STARTED) {
                                        dialog.setVisible(true);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        @Override
        protected Object doInBackground() throws Exception {
            settle_now();
            return null;
        }

        @Override
        protected void done() {
            dialog.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    set_change();
                }
            });

        }

    }
}
