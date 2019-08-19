/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.branch_locations.S1_branch_locations;
import POS.branches.Branches;
import POS.category.Dlg_inventory_categories;
import POS.inventory.Dlg_inventory_uom.to_uom;
import POS.inventory.Inventory.to_inventory;
import POS.inventory.S1_inventory_assembly.to_inventory_assembly;
import POS.inventory.Inventory_barcodes.to_inventory_barcodes;
import POS.inventory.S1_inventory_multi_level_pricing.to_inventory_multi_level_pricing;
import POS.inventory_assembly.Dlg_inventory_assembly;
import POS.receipts.S1_receipt_items;
import POS.selling_type.S1_selling_type;
import POS.users.Dlg_user_price_change;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_cloud;
import POS.util.Dlg_confirm_delete;
import POS.util.MyConnection;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
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
 * @author i1
 */
public class Dlg_inventory extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_inventory
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
    private Dlg_inventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_inventory(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_inventory() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_inventory myRef;

    private void setThisRef(Dlg_inventory myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_inventory dialog = Dlg_inventory.
                create(new javax.swing.JFrame(), true);

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
            getContentPane().
                    removeAll();
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
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tf_qty_branch = new Field.Search();
        tf_search_branch_code = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory_barcodes = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tf_location = new Field.Search();
        tf_location_id = new javax.swing.JTextField();
        cb_branch = new javax.swing.JCheckBox();
        cb_location = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel35 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        tf_inventory_barcode = new Field.Input();
        jLabel27 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        btn_update1 = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_inventory_multi_level_pricing = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        tf_multi_unit = new javax.swing.JTextField();
        tf_conversion = new Field.Input();
        jLabel17 = new javax.swing.JLabel();
        tf_multi_selling_price = new Field.Input();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_markup = new Field.Input();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_inventory_assembly = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        tf_assembly_barcode = new Field.Search();
        tf_assembly_item_code = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tf_assembly_description = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tf_assembly_qty = new Field.Input();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        tf_assembly_unit = new Field.Input();
        jLabel26 = new javax.swing.JLabel();
        tf_assembly_selling_price = new Field.Input();
        jPanel5 = new javax.swing.JPanel();
        dp_from = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        dp_to = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_receipt_items = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_item_code = new Field.Search();
        jLabel2 = new javax.swing.JLabel();
        tf_description = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        tf_selling_type = new Field.Combo();
        jLabel4 = new javax.swing.JLabel();
        tf_category = new Field.Combo();
        jLabel5 = new javax.swing.JLabel();
        tf_sub_classification = new Field.Combo();
        jLabel6 = new javax.swing.JLabel();
        tf_classification = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        tf_model = new Field.Combo();
        tf_brand = new Field.Combo();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new Field.Input();
        jTextField10 = new Field.Input();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_unit = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        tf_reorder_level = new Field.Input();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_status = new Field.Combo();
        btn_delete = new Button.Warning();
        btn_update = new Button.Info();
        jButton3 = new Button.Primary();
        jButton4 = new Button.Default();
        jLabel20 = new javax.swing.JLabel();
        tf_cost = new Field.Input();
        jLabel21 = new javax.swing.JLabel();
        tf_selling_price = new Field.Input();
        tf_uom_conversion = new Field.Input();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tf_barcode = new Field.Input();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jButton13 = new Button.Default();
        jButton16 = new Button.Default();
        jButton17 = new Button.Default();
        jLabel37 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel39 = new javax.swing.JLabel();
        tf_description1 = new Field.Input();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Branch:");

        tf_qty_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qty_branchActionPerformed(evt);
            }
        });

        tf_search_branch_code.setFocusable(false);

        tbl_inventory_barcodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_inventory_barcodes);

        jLabel28.setText("Total:");

        lbl_total.setBackground(new java.awt.Color(102, 102, 102));
        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Location:");

        tf_location.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_locationActionPerformed(evt);
            }
        });

        tf_location_id.setFocusable(false);

        cb_branch.setSelected(true);
        cb_branch.setText("All");
        cb_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_branchActionPerformed(evt);
            }
        });

        cb_location.setSelected(true);
        cb_location.setText("All");
        cb_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_locationActionPerformed(evt);
            }
        });

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel35.setText("Status:");

        tf_inventory_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_inventory_barcodeActionPerformed(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Barcode:");

        jButton14.setText("New");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Add");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        btn_update1.setText("Update");
        btn_update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update1ActionPerformed(evt);
            }
        });

        btn_delete1.setText("Delete");
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(tf_inventory_barcode)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete1)
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_inventory_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete1)
                    .addComponent(btn_update1)
                    .addComponent(jButton15)
                    .addComponent(jButton14)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_branch)
                            .addComponent(cb_location))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_qty_branch, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(tf_location))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_search_branch_code)
                            .addComponent(tf_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(282, 282, 282)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_qty_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_search_branch_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_branch))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(tf_location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_location)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel35)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quantity on Hand", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_inventory_multi_level_pricing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_inventory_multi_level_pricing);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("UOM:");

        tf_multi_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_multi_unitActionPerformed(evt);
            }
        });

        tf_conversion.setText("1");
        tf_conversion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_conversionKeyReleased(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Conversion:");

        tf_multi_selling_price.setFocusable(false);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Selling Price:");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Markup:");

        tf_markup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_markupActionPerformed(evt);
            }
        });
        tf_markup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_markupKeyReleased(evt);
            }
        });

        jButton5.setText("New");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Add");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Update");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Delete");
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_multi_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_markup, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_multi_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton7)
                        .addComponent(jButton6)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_multi_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_markup, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_multi_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Multi Level Pricing", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_inventory_assembly.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_inventory_assembly.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventory_assemblyMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_inventory_assembly);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Barcode:");

        tf_assembly_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_assembly_barcodeActionPerformed(evt);
            }
        });

        tf_assembly_item_code.setFocusable(false);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Item Code:");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Description:");

        tf_assembly_description.setFocusable(false);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Qty:");

        tf_assembly_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_assembly_qtyActionPerformed(evt);
            }
        });

        jButton9.setText("New");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Delete");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("UOM:");

        tf_assembly_unit.setFocusable(false);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Selling Price:");

        tf_assembly_selling_price.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tf_assembly_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_assembly_description))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tf_assembly_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_assembly_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_assembly_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_assembly_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_assembly_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_assembly_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_assembly_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_assembly_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_assembly_description, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12)
                    .addComponent(jButton11)
                    .addComponent(jButton10)
                    .addComponent(jButton9)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_assembly_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Assembly", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setText("Date From:");

        jLabel30.setText("To:");

        tbl_receipt_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_receipt_items);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dp_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dp_from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Receipts", jPanel5);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Item Code:");

        tf_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_item_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_item_codeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Description:");

        tf_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descriptionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Selling Type:");

        tf_selling_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_selling_type.setText("Regular");
        tf_selling_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_selling_typeMouseClicked(evt);
            }
        });
        tf_selling_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_selling_typeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Category:");

        tf_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_categoryMouseClicked(evt);
            }
        });
        tf_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_categoryActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Sub-Classification:");

        tf_sub_classification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_sub_classification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_sub_classificationMouseClicked(evt);
            }
        });
        tf_sub_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sub_classificationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Classification:");

        tf_classification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_classification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_classificationMouseClicked(evt);
            }
        });
        tf_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_classificationActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Model:");

        tf_model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_model.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_modelMouseClicked(evt);
            }
        });
        tf_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_modelActionPerformed(evt);
            }
        });

        tf_brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_brand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_brandMouseClicked(evt);
            }
        });
        tf_brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_brandActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Color:");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Size:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Unit of Measure:");

        tf_unit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_unit.setText("pc");
        tf_unit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_unitMouseClicked(evt);
            }
        });
        tf_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_unitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Brand:");

        tf_reorder_level.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Reorder Lvl:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Status:");

        tf_status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_status.setText("Active");
        tf_status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_statusMouseClicked(evt);
            }
        });
        tf_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_statusActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.setEnabled(false);
        btn_delete.setFocusable(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.setEnabled(false);
        btn_update.setFocusable(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("New");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Cost:");

        tf_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_costKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Selling Price:");

        tf_selling_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_uom_conversion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_uom_conversion.setText("1");
        tf_uom_conversion.setFocusable(false);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/keyboard53 (1).png"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/keyboard53 (1).png"))); // NOI18N
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Barcode:");

        tf_barcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_barcodeKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu2/file.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu2/rotate.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Search by:");

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        buttonGroup1.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("[F2]-Code");
        jCheckBox7.setFocusable(false);

        buttonGroup1.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Description");
        jCheckBox8.setFocusable(false);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/cloud-storage-uploading-option (3).png"))); // NOI18N
        jButton13.setText("Upload");
        jButton13.setFocusable(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/cloud-storage-uploading-option (3).png"))); // NOI18N
        jButton16.setText("Match Items");
        jButton16.setFocusable(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/team2.png"))); // NOI18N
        jButton17.setText("User Price Change");
        jButton17.setFocusable(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Allow Negative Inventory:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Yes/No");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Auto-Order:");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Yes/No");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Generic Name:");

        tf_description1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_description1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_description)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(1, 1, 1)
                                        .addComponent(jCheckBox6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_barcode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_selling_type, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(tf_reorder_level, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_status))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_model)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(tf_sub_classification))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_category)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tf_unit)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_uom_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel32))
                                    .addComponent(tf_classification, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_brand)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField10)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_description1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_selling_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_classification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_uom_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_sub_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_reorder_level, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addGap(5, 5, 5))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_item_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_item_codeActionPerformed
        init_inventory();
    }//GEN-LAST:event_tf_item_codeActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete_inventory();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear_inventory();
        init_item_code();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        edit_inventory();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_inventory();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_qty_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qty_branchActionPerformed
        init_branches();
    }//GEN-LAST:event_tf_qty_branchActionPerformed

    private void tf_selling_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_selling_typeActionPerformed
        // TODO add your handling code here:
        init_selling_type();
    }//GEN-LAST:event_tf_selling_typeActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        tf_inventory_barcode.setText("");
        tf_inventory_barcode.grabFocus();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        add_inventory_barcode();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void btn_update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_update1ActionPerformed

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void tf_inventory_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_inventory_barcodeActionPerformed
        add_inventory_barcode();
    }//GEN-LAST:event_tf_inventory_barcodeActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        delete_inventory_multi_level_pricing();
        tf_multi_unit.grabFocus();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        edit_inventory_multi_level_pricing();
        tf_multi_unit.grabFocus();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        add_inventory_multi_level_pricing();
        tf_multi_unit.grabFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear_inventory_multi_level_pricing();
        tf_multi_unit.grabFocus();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_markupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_markupKeyReleased
        compute_markup();
    }//GEN-LAST:event_tf_markupKeyReleased

    private void tf_markupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_markupActionPerformed
        add_inventory_multi_level_pricing();
        tf_multi_unit.grabFocus();
    }//GEN-LAST:event_tf_markupActionPerformed

    private void tf_conversionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_conversionKeyReleased
        compute_markup();
    }//GEN-LAST:event_tf_conversionKeyReleased

    private void tf_assembly_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_assembly_barcodeActionPerformed
        init_inventory_assembly();
    }//GEN-LAST:event_tf_assembly_barcodeActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        add_assembly();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tf_assembly_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_assembly_qtyActionPerformed
        add_assembly();
    }//GEN-LAST:event_tf_assembly_qtyActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        clear_assembly();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        edit_assembly();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        delete_assembly();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tbl_inventory_assemblyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory_assemblyMouseClicked
        select_assembly();
    }//GEN-LAST:event_tbl_inventory_assemblyMouseClicked

    private void tf_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoryActionPerformed
        init_inventory_category();
    }//GEN-LAST:event_tf_categoryActionPerformed

    private void tf_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_classificationActionPerformed
        init_inventory_classification();
    }//GEN-LAST:event_tf_classificationActionPerformed

    private void tf_sub_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sub_classificationActionPerformed
        init_inventory_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationActionPerformed

    private void tf_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_brandActionPerformed
        init_inventory_brand();
    }//GEN-LAST:event_tf_brandActionPerformed

    private void tf_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_modelActionPerformed
        init_inventory_model();
    }//GEN-LAST:event_tf_modelActionPerformed

    private void tf_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_statusActionPerformed
        // TODO add your handling code here:
        init_status();
    }//GEN-LAST:event_tf_statusActionPerformed

    private void tf_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_unitActionPerformed
        init_default_uom();
    }//GEN-LAST:event_tf_unitActionPerformed

    private void tf_multi_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_multi_unitActionPerformed
        init_uom();
    }//GEN-LAST:event_tf_multi_unitActionPerformed

    private void tf_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_locationActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_tf_locationActionPerformed

    private void cb_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_branchActionPerformed
        enable_branch();
    }//GEN-LAST:event_cb_branchActionPerformed

    private void cb_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_locationActionPerformed
        enable_location();
    }//GEN-LAST:event_cb_locationActionPerformed

    private void tf_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_descriptionActionPerformed

    private void tf_costKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_costKeyReleased
        add_comma_separator();
    }//GEN-LAST:event_tf_costKeyReleased

    private void tf_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_categoryMouseClicked
        init_inventory_category();
    }//GEN-LAST:event_tf_categoryMouseClicked

    private void tf_sub_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_sub_classificationMouseClicked
        init_inventory_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationMouseClicked

    private void tf_modelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_modelMouseClicked
        init_inventory_model();
    }//GEN-LAST:event_tf_modelMouseClicked

    private void tf_unitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_unitMouseClicked
        init_default_uom();
    }//GEN-LAST:event_tf_unitMouseClicked

    private void tf_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_classificationMouseClicked
        init_inventory_classification();
    }//GEN-LAST:event_tf_classificationMouseClicked

    private void tf_brandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_brandMouseClicked
        init_inventory_brand();
    }//GEN-LAST:event_tf_brandMouseClicked

    private void tf_selling_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_selling_typeMouseClicked
        init_selling_type();
    }//GEN-LAST:event_tf_selling_typeMouseClicked

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void tf_statusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_statusMouseClicked
        init_status();
    }//GEN-LAST:event_tf_statusMouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        uom();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        assembly();
    }//GEN-LAST:event_jLabel33MouseClicked

    private void tf_barcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_barcodeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_barcodeKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        get_console_statements();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        set_console_statements();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        cloud_upload();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        check_items();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        user_price_change();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void tf_description1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_description1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_description1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_update1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cb_branch;
    private javax.swing.JCheckBox cb_location;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_inventory_assembly;
    private javax.swing.JTable tbl_inventory_barcodes;
    private javax.swing.JTable tbl_inventory_multi_level_pricing;
    private javax.swing.JTable tbl_receipt_items;
    private javax.swing.JTextField tf_assembly_barcode;
    private javax.swing.JTextField tf_assembly_description;
    private javax.swing.JTextField tf_assembly_item_code;
    private javax.swing.JTextField tf_assembly_qty;
    private javax.swing.JTextField tf_assembly_selling_price;
    private javax.swing.JTextField tf_assembly_unit;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_brand;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_classification;
    private javax.swing.JTextField tf_conversion;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_description1;
    private javax.swing.JTextField tf_inventory_barcode;
    private javax.swing.JTextField tf_item_code;
    private javax.swing.JTextField tf_location;
    private javax.swing.JTextField tf_location_id;
    private javax.swing.JTextField tf_markup;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_multi_selling_price;
    private javax.swing.JTextField tf_multi_unit;
    private javax.swing.JTextField tf_qty_branch;
    private javax.swing.JTextField tf_reorder_level;
    private javax.swing.JTextField tf_search_branch_code;
    private javax.swing.JTextField tf_selling_price;
    private javax.swing.JTextField tf_selling_type;
    private javax.swing.JTextField tf_status;
    private javax.swing.JTextField tf_sub_classification;
    private javax.swing.JTextField tf_unit;
    private javax.swing.JTextField tf_uom_conversion;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//         System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");
        init_key();
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("inventory_item_delete", "true");
//        System.setProperty("cloud_inventory_insert", "true");
//        System.setProperty("cloud_inventory_update", "true");
//        System.setProperty("cloud_inventory_delete", "true");

//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_bodega");
//        System.setProperty("pool_host", "localhost");
//        System.setProperty("main_branch", "true");
//        System.setProperty("active_branches", "10");
//        System.setProperty("cloud_host", "128.199.80.53");
//        System.setProperty("cloud_user", "smis2");
//        System.setProperty("cloud_password", "nopassword101");
//        System.setProperty("cloud_db", "db_smis_dumaguete_refreshments_development");

        String environment = System.getProperty("environment", "development");
        if (environment.equalsIgnoreCase("development")) {
            jButton1.setVisible(true);
            jButton2.setVisible(true);
        } else {
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
//        focus();
        disabled();
        init_item_code();
        init_tbl_inventory_barcodes();
        init_tbl_inventory_multi_level_pricing();
        init_tbl_inventory_assembly();
        init_tbl_receipt_items();
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        tf_qty_branch.enable(false);
        tf_location.enable(false);
        add_comma();
        jTabbedPane1.remove(1);
        jTabbedPane1.remove(2);
        jTabbedPane1.remove(1);
        jPanel7.setVisible(false);

        client_label_request();

        jButton13.setVisible(false);
        jButton16.setVisible(false);
        jLabel33.setEnabled(false);
        String cloud_host = System.getProperty("cloud_host", "");
        String main_branch = System.getProperty("main_branch", "false");
        if (main_branch.equalsIgnoreCase("true")) {
            jButton13.setVisible(true);
            jButton13.setText("Upload");
        } else {
            jButton13.setVisible(true);
            jButton13.setText("Download");
        }
//        cloud_upload();
    }

    private void client_label_request() {
        String pool_db = System.getProperty("pool_db", "db_algorithm");
        if (pool_db.equalsIgnoreCase("db_smis_guihulngan")) {
            jLabel2.setText("Part Number:");
            jLabel4.setText("Department:");
            jLabel6.setText("Sub-Department:");
            jLabel5.setText("Section:");
            jButton4.setText("Clear");
        }
    }

    private void add_comma() {
        final JTextField[] tf = {tf_cost, tf_selling_price};
        for (final JTextField t : tf) {
            t.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {

                    String text = t.getText();
                    if (text.contains(".")) {

                    } else {
                        double cost = FitIn.toDouble(t.getText());
                        t.setText(FitIn.fmt_wc(cost));
                        String str = t.getText();
                        t.setCaretPosition(str.length());
                    }

                }

            });
        }
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
        tf_category.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F5) {
                    inventory_category();
                }
            }
        });
        tf_item_code.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    jCheckBox6.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    jCheckBox7.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    jCheckBox8.setSelected(true);
                }
            }
        });

    }

    // </editor-fold>
    private void inventory_category() {
        Window p = (Window) this;
        Dlg_inventory_categories nd = Dlg_inventory_categories.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_inventory_categories.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_categories.OutputData data) {
                closeDialog.ok();
                Field.Combo cat = (Field.Combo) tf_category;
                cat.setText(data.category.name);
                cat.setId("" + data.category.id);
                tf_classification.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void init_item_code() {
        tf_item_code.setText(Inventory.increment_id());
    }

    private void disabled() {
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
    }

//    private void focus() {
//        JTextField[] tf = {tf_item_code, tf_selling_type, tf_description, tf_cost, tf_selling_price, tf_unit, tf_category, tf_classification, tf_sub_classification, tf_brand, tf_model,
//            jTextField9, jTextField10, tf_reorder_level, tf_status, tf_qty_branch, tf_inventory_barcode, tf_multi_unit, tf_conversion, tf_markup, tf_multi_selling_price, tf_assembly_barcode, tf_assembly_qty, tf_location};
//        Focus_Fire.onFocus_lostFocus(tf);
//
//        JLabel[] lbl = {};
//        Focus_Fire.hover(lbl);
//        JLabel[] lbl2 = {};
//        Focus_Fire.hover2(lbl2);
//        Focus_Fire.select_all(tf);
//
//        JTextField[] tf2 = {tf_description, tf_cost, tf_selling_price, tf_unit, tf_category, tf_classification, tf_sub_classification, tf_brand, tf_model, jTextField9, tf_reorder_level};
//        Focus_Fire.nextFocus2(tf2);
//    }
    List<S1_selling_type.to_selling_type> selling_type_list = new ArrayList();

    private void init_selling_type() {
        String search = tf_selling_type.getText();
        selling_type_list.clear();
        selling_type_list = S1_selling_type.ret_data("");
        Object[][] obj = new Object[selling_type_list.size()][2];
        int i = 0;
        for (S1_selling_type.to_selling_type to : selling_type_list) {
            obj[i][0] = to.id;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = to.name;//TextHighlighter1.highlight2(to.description, to.description, "");

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, tf_selling_type.getWidth() - 10};
        int width = 0;
        for (int w : tbl_widths_customers) {
            width += w;
        }
        String[] col_names = {"Code", "Type"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_selling_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_selling_type.to_selling_type t = selling_type_list.
                        get(data.selected_row);
                tf_selling_type.setText(t.name);
            }
        });
    }

    List<Inventory.to_inventory> inventory_list = new ArrayList();

    Inventory.to_inventory my_item = null;

    private void init_inventory() {
        String search = tf_item_code.getText();
        String where = " where ";

        if (jCheckBox6.isSelected()) {
            where = where + " barcode like '" + search + "' "
                    + " or barcodes like '" + search + "' "
                    + " or description like '%" + search + "%' ";
        }
        if (jCheckBox7.isSelected()) {
            where = where + " barcode like '" + search + "' "
                    + " or barcodes like '" + search + "' ";
        }
        if (jCheckBox8.isSelected()) {
            where = where + "  description like '%" + search + "%' ";
        }
        where = where + " order by description asc ";

        inventory_list.clear();
        inventory_list = Inventory.ret_data22(where);

        if (inventory_list.isEmpty()) {
            Alert.set(0, "Item not found!");
            tf_item_code.grabFocus();
            return;
        }
        if (inventory_list.size() == 1) {
            Inventory.to_inventory to = inventory_list.get(0);
            my_item = to;
            selected_row = 0;
            select_item(to);
        } else {
            Object[][] obj = new Object[inventory_list.size()][2];
            int i = 0;
            for (Inventory.to_inventory to : inventory_list) {
                obj[i][0] = " " + to.barcode;
                obj[i][1] = " " + to.description;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {100, 600};
            int width = 0;
            for (int w : tbl_widths_customers) {
                width += w;
            }
            String[] col_names = {"Item Code", "Description"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup2(tf_item_code, obj, labels, tbl_widths_customers, col_names, width);
            tr.setCallback(new TableRenderer.Callback() {

                @Override
                public void ok(TableRenderer.OutputData data) {
                    Inventory.to_inventory to = inventory_list.get(data.selected_row);
                    my_item = to;
                    selected_row = data.selected_row;
                    select_item(to);

                }
            });
        }

    }

    private void select_item(Inventory.to_inventory to) {

        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brand = (Field.Combo) tf_brand;
        Field.Combo model = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;

        tf_item_code.setText(to.barcode);
        tf_barcode.setText(to.barcodes);
        my_old_barcode = to.barcodes;
        tf_description.setText(to.description);
        tf_description1.setText(to.generic_name);
        tf_category.setText(to.category);
        cat.setId(to.category_id);
        tf_sub_classification.setText(to.sub_classification);
        tf_classification.setText(to.classification);
        classi.setId(to.classification_id);
        sub_class.setId(to.sub_classification_id);
        tf_brand.setText(to.brand);
        brand.setId(to.brand_id);
        tf_model.setText(to.model);
        model.setId(to.model_id);
        units.setId(to.unit);
        Dlg_inventory_uom.to_uom to_unit = uom.default_uom(to.unit);
        tf_unit.setText(to_unit.uom);
        tf_uom_conversion.setText(FitIn.fmt_wc_0(to_unit.conversion));
        tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
        tf_cost.setText(FitIn.fmt_wc_0(to.cost));
        tf_reorder_level.setText(FitIn.fmt_wc_0(to.reorder_level));
        btn_update.setEnabled(true);
        jLabel33.setEnabled(true);
        String inventory_item_delete = System.getProperty("inventory_item_delete", "false");
        if (inventory_item_delete.equalsIgnoreCase("true")) {
            btn_delete.setEnabled(true);
        }

        if (to.selling_type == 0) {
            tf_selling_type.setText("Regular");
        } else {
            tf_selling_type.setText("Assemble");
        }
        tf_model.setText(to.model);

        data_cols_inventory_barcodes();
//                data_cols_assembly();
        data_cols();

        if (to.allow_negative_inventory == 0) {
            jCheckBox1.setSelected(false);
        } else {
            jCheckBox1.setSelected(true);
        }
        if (to.auto_order == 0) {
            jCheckBox2.setSelected(false);
        } else {
            jCheckBox2.setSelected(true);
        }
    }
    int selected_row = -1;

    private void add_inventory() {
//        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance - (Add)" + "' limit 1";
//        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
//        if (privileges.isEmpty()) {
//            Alert.set(0, "Privilege not added!");
//            return;
//        }
        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;
        int id = -1;
        String barcode = Inventory.increment_id();
        String description = tf_description.getText();
        String generic_name = tf_description1.getText();
        String category = tf_category.getText();
        String category_id = cat.getId();
        String classification = tf_classification.getText();
        String classification_id = classi.getId();
        String sub_classification = tf_sub_classification.getText();
        String sub_classification_id = sub_class.getId();

        double product_qty = 0;
        double conversion = 1;
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String date_added = DateType.now();
        String user_name = "";
        String item_type = "";
        int status = 0;
        if (tf_status.getText().equalsIgnoreCase("Active")) {
            status = 1;
        }
        String supplier = "";
        int fixed_price = 0;
        double cost = FitIn.toDouble(tf_cost.getText());
        String supplier_id = "";
        int multi_level_pricing = 0;
        int vatable = 0;
        double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
        double markup = 0;
        String barcodes = tf_barcode.getText();
        String brand = tf_brand.getText();
        String brand_id = brands.getId();
        String model = tf_model.getText();
        String model_id = models.getId();
        int selling_type = 0;
        if (!tf_selling_type.getText().equalsIgnoreCase("Regular")) {
            selling_type = 1;
        }
        String branch = "";
        String branch_code = "";
        String location = "";
        String location_id = "";
        String unit = "";
        if (units.getId() == null || units.getId().isEmpty()) {
            unit = uom.convert_to_string(tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
        } else {
            to_uom to2 = new to_uom(0, tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
            unit = uom.convert_to_string2(units.getId(), to2);
        }
        int is_uploaded = 0;
        int allow_negative_inventory = 0;
        int auto_order = 0;
        if (jCheckBox1.isSelected()) {
            allow_negative_inventory = 1;
        }
        if (jCheckBox2.isSelected()) {
            auto_order = 1;
        }
        final to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order);
       
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                List<String> query = Inventory.add_inventory(to);
                Alert.set(1, "");
                clear_inventory();
                init_item_code();
                tf_item_code.grabFocus();

//                if (cloud_inventory_insert.equalsIgnoreCase("true")) {
//                    cloud_insert(query, "Upload new record to cloud?");
//
//                } else {
//                    Alert.set(1, "");
//                    clear_inventory();
//                    init_item_code();
//                    tf_item_code.grabFocus();
//                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void cloud_insert(final List<String> query, String stmt) {
        Window p = (Window) this;
        Dlg_confirm_cloud nd = Dlg_confirm_cloud.create(p, true);
        nd.setTitle("");
        nd.do_pass(stmt);
        nd.setCallback(new Dlg_confirm_cloud.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_cloud.OutputData data) {
                closeDialog.ok();
                MyConnection.exec_cloud_query(query);
                Alert.set(0, "Successfully saved to clound!");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void cloud_delete(final List<String> query, String stmt) {
        Window p = (Window) this;
        Dlg_confirm_cloud nd = Dlg_confirm_cloud.create(p, true);
        nd.setTitle("");
        nd.do_pass(stmt);
        nd.setCallback(new Dlg_confirm_cloud.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_cloud.OutputData data) {
                closeDialog.ok();
                MyConnection.exec_cloud_query(query);
                Alert.set(0, "Successfully deleted from clound!");

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private List<String> add_inventory_console() {
        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;
        int id = -1;
        String barcode = tf_item_code.getText();
        String description = tf_description.getText();
        String generic_name = "";
        String category = tf_category.getText();
        String category_id = cat.getId();
        String classification = tf_classification.getText();
        String classification_id = classi.getId();
        String sub_classification = tf_sub_classification.getText();
        String sub_classification_id = sub_class.getId();

        double product_qty = 0;
        double conversion = 1;
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String date_added = DateType.now();
        String user_name = "";
        String item_type = "";
        int status = 0;
        if (tf_status.getText().equalsIgnoreCase("Active")) {
            status = 1;
        }
        String supplier = "";
        int fixed_price = 0;
        double cost = FitIn.toDouble(tf_cost.getText());
        String supplier_id = "";
        int multi_level_pricing = 0;
        int vatable = 0;
        double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
        double markup = 0;
        String barcodes = tf_barcode.getText();
        String brand = tf_brand.getText();
        String brand_id = brands.getId();
        String model = tf_model.getText();
        String model_id = models.getId();
        int selling_type = 0;
        if (!tf_selling_type.getText().equalsIgnoreCase("Regular")) {
            selling_type = 1;
        }
        String branch = "";
        String branch_code = "";
        String location = "";
        String location_id = "";
        String unit = "";
        if (units.getId() == null || units.getId().isEmpty()) {
            unit = uom.convert_to_string(tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
        } else {
            to_uom to2 = new to_uom(0, tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
            unit = uom.convert_to_string2(units.getId(), to2);
        }
        int is_uploaded = 0;
        int allow_negative_inventory = 0;
        int auto_order = 0;
        if (jCheckBox1.isSelected()) {
            allow_negative_inventory = 1;
        }
        if (jCheckBox2.isSelected()) {
            auto_order = 1;
        }
        to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order);

        List<String> query = Inventory.add_inventory_to_console(to);
        return query;
    }

    private void select_inventory() {

        if (selected_row == -1) {
            return;
        }
        Inventory.to_inventory to = inventory_list.get(selected_row);

    }
    String my_old_barcode = "";

    private void edit_inventory() {
//        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance - (Edit)" + "' limit 1";
//        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
//        if (privileges.isEmpty()) {
//            Alert.set(0, "Privilege not added!");
//            return;
//        }
        Window p = (Window) this;
        Dlg_inventory_update_confirm nd = Dlg_inventory_update_confirm.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_update_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_update_confirm.OutputData data) {
                closeDialog.ok();
                if (selected_row == -1) {
                    return;
                }
                Field.Combo cat = (Field.Combo) tf_category;
                Field.Combo classi = (Field.Combo) tf_classification;
                Field.Combo sub_class = (Field.Combo) tf_sub_classification;
                Field.Combo brands = (Field.Combo) tf_brand;
                Field.Combo models = (Field.Combo) tf_model;
                Field.Combo units = (Field.Combo) tf_unit;
                Inventory.to_inventory to1 = inventory_list.get(selected_row);
                int id = to1.id;
                String barcode = to1.barcode;
                String description = tf_description.getText();
                String generic_name = tf_description1.getText();
                String category = tf_category.getText();
                String category_id = cat.getId();
                String classification = tf_classification.getText();
                String classification_id = classi.getId();
                String sub_classification = tf_sub_classification.getText();
                String sub_classification_id = sub_class.getId();
                double product_qty = 0;
                double conversion = 1;
                double selling_price = FitIn.toDouble(tf_selling_price.getText());
                String date_added = DateType.now();
                String user_name = "";

                String item_type = tf_selling_type.getText();
                int status = 0;
                if (tf_status.getText().equalsIgnoreCase("Active")) {
                    status = 1;
                }
                String supplier = "";
                int fixed_price = 0;
                double cost = FitIn.toDouble(tf_cost.getText());
                String supplier_id = "";
                int multi_level_pricing = 0;
                int vatable = 0;
                double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
                double markup = 0;
                String barcodes = tf_barcode.getText();

                String brand = tf_brand.getText();
                String brand_id = brands.getId();
                String model = tf_model.getText();
                String model_id = models.getId();
                int selling_type = 0;
                if (!tf_selling_type.getText().equalsIgnoreCase("Regular")) {
                    selling_type = 1;
                }

                String branch = "";
                String branch_code = "";
                String location = "";
                String location_id = "";
                String unit = "";
                if (units.getId() == null || units.getId().isEmpty()) {
                    unit = uom.convert_to_string(tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
                } else {
                    to_uom to2 = new to_uom(0, tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
                    unit = uom.convert_to_string2(units.getId(), to2);
                }
                int is_uploaded = 2;

                int allow_negative_inventory = 0;
                int auto_order = 0;
                if (jCheckBox1.isSelected()) {
                    allow_negative_inventory = 1;
                }
                if (jCheckBox2.isSelected()) {
                    auto_order = 1;
                }
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order);
                String where = " where main_barcode='" + barcode + "'  ";
                if (!data.branch_id.equalsIgnoreCase("All")) {
                    where = " where main_barcode='" + barcode + "' and branch_code='" + data.branch_id + "' ";
                }
                Inventory.edit_inventory(to, my_item, where);
                my_item = to;
                Alert.set(2, "");
                data_cols_inventory_barcodes();
                data_cols_multi_level_pricing();
                data_cols();
                tf_item_code.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private List<String> edit_inventory_to_console() {
        if (selected_row == -1) {
            return new ArrayList();
        }
        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;

        Inventory.to_inventory to1 = inventory_list.get(selected_row);
        int id = to1.id;
        String barcode = to1.barcode;
        String description = tf_description.getText();
        String generic_name = "";
        String category = tf_category.getText();
        String category_id = cat.getId();

        String classification = tf_classification.getText();
        String classification_id = classi.getId();

        String sub_classification = tf_sub_classification.getText();
        String sub_classification_id = sub_class.getId();

        double product_qty = 0;
        double conversion = 1;
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String date_added = DateType.now();
        String user_name = "";

        String item_type = tf_selling_type.getText();
        int status = 0;
        if (tf_status.getText().equalsIgnoreCase("Active")) {
            status = 1;
        }
        String supplier = "";
        int fixed_price = 0;
        double cost = FitIn.toDouble(tf_cost.getText());
        String supplier_id = "";
        int multi_level_pricing = 0;
        int vatable = 0;
        double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
        double markup = 0;
        String barcodes = tf_barcode.getText();

        String brand = tf_brand.getText();
        String brand_id = brands.getId();
        String model = tf_model.getText();
        String model_id = models.getId();
        int selling_type = 0;
        if (!tf_selling_type.getText().equalsIgnoreCase("Regular")) {
            selling_type = 1;
        }

        String branch = "";
        String branch_code = "";
        String location = "";
        String location_id = "";
        String unit = "";
        if (units.getId() == null || units.getId().isEmpty()) {
            unit = uom.convert_to_string(tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
        } else {
            to_uom to2 = new to_uom(0, tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
            unit = uom.convert_to_string2(units.getId(), to2);
        }
        int is_uploaded = 2;

        int allow_negative_inventory = 0;
        int auto_order = 0;
        if (jCheckBox1.isSelected()) {
            allow_negative_inventory = 1;
        }
        if (jCheckBox2.isSelected()) {
            auto_order = 1;
        }
        to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order);
        String where = " where main_barcode='" + barcode + "'  ";

        List<String> query = Inventory.edit_inventory_to_console(to, my_item, where);
        return query;
    }

    private void clear_inventory() {

        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;
        tf_item_code.setText("");
        tf_description.setText("");
        tf_uom_conversion.setText("1");
        units.setId("");
        tf_selling_price.setText("");
        tf_cost.setText("");
        tf_reorder_level.setText("");
        tf_barcode.setText("");
        tf_item_code.grabFocus();
        disabled();
        selected_row = -1;
    }

    private void delete_inventory() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance - (Delete)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        if (selected_row == -1) {
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                Inventory.to_inventory to1 = inventory_list.get(selected_row);
                List<String> query = Inventory.delete_inventory(to1);
                clear_inventory();
                init_item_code();
                Alert.set(3, "");
                tbl_inventory_barcodes_ALM.clear();
                tbl_inventory_barcodes_M.fireTableDataChanged();
                tf_item_code.grabFocus();

//                String cloud_inventory_delete = System.getProperty("cloud_inventory_delete", "true");
//                if (cloud_inventory_delete.equalsIgnoreCase("true")) {
//                    clear_inventory();
//                    init_item_code();
//                    Alert.set(3, "");
//                    tbl_inventory_barcodes_ALM.clear();
//                    tbl_inventory_barcodes_M.fireTableDataChanged();
//                    tf_item_code.grabFocus();
//                    cloud_delete(query, "Delete entry to cloud?");
//                } else {
//
//                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches() {
        String search = tf_qty_branch.getText();
        branches_list.clear();
        branches_list = Branches.ret_data3(search);
        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (Branches.to_branches to : branches_list) {
            obj[i][0] = to.id;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = to.branch;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, 200};
        int width = 0;
        String[] col_names = {"Code", "Branch"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_qty_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Branches.to_branches to = branches_list.
                        get(data.selected_row);
                tf_qty_branch.setText(to.branch);
                tf_search_branch_code.setText("" + to.id);
                data_cols_inventory_barcodes();
            }
        });
    }

    private ArrayListModel tbl_inventory_barcodes_ALM;
    private Tblinventory_barcodesModel tbl_inventory_barcodes_M;

    private void init_tbl_inventory_barcodes() {
        tbl_inventory_barcodes_ALM = new ArrayListModel();
        tbl_inventory_barcodes_M = new Tblinventory_barcodesModel(tbl_inventory_barcodes_ALM);
        tbl_inventory_barcodes.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_inventory_barcodes.setModel(tbl_inventory_barcodes_M);
        tbl_inventory_barcodes.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_barcodes.setRowHeight(25);
        int[] tbl_widths_inventory_barcodes = {180, 100, 80, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_barcodes.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_inventory_barcodes, i, tbl_widths_inventory_barcodes[i]);
        }
        Dimension d = tbl_inventory_barcodes.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_inventory_barcodes.getTableHeader().setPreferredSize(d);
        tbl_inventory_barcodes.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_inventory_barcodes.setRowHeight(25);
        tbl_inventory_barcodes.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_inventory_barcodes(List<to_inventory_barcodes> acc) {
        tbl_inventory_barcodes_ALM.clear();
        tbl_inventory_barcodes_ALM.addAll(acc);
    }

    public static class Tblinventory_barcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Location", "Item Code", "Description", "Qty", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "main_barcode", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code"
        };

        public Tblinventory_barcodesModel(ListModel listmodel) {
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
            to_inventory_barcodes tt = (to_inventory_barcodes) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.branch + " : " + tt.location;
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return "   " + FitIn.fmt_woc(tt.product_qty);
                case 4:
                    return tt.category;
                case 5:
                    return tt.category_id;
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
                case 24:
                    return tt.reorder_level;
                case 25:
                    return tt.markup;
                case 26:
                    return tt.main_barcode;
                case 27:
                    return tt.brand;
                case 28:
                    return tt.brand_id;
                case 29:
                    return tt.model;
                case 30:
                    return tt.model_id;
                case 31:
                    return tt.selling_type;
                case 32:
                    return tt.branch;
                default:
                    return tt.branch_code;
            }
        }
    }

    private void data_cols_inventory_barcodes() {

        String search = tf_item_code.getText();
        String branch_id = tf_search_branch_code.getText();
        String location_id = tf_location_id.getText();
        String where = " where main_barcode like '" + search + "' "
                + " and branch_code like '%" + branch_id + "%' "
                + " and location_id like '%" + location_id + "%' ";

        List<Inventory_barcodes.to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);
        loadData_inventory_barcodes(datas);
        double total = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : datas) {
            total += to.product_qty;
        }
        lbl_total.setText(FitIn.fmt_woc(total));

        jProgressBar1.setString("Finished...");
        jProgressBar1.setIndeterminate(false);

    }

    private void add_inventory_barcode() {
        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        int id = -1;
        String barcode = tf_inventory_barcode.getText();
        String description = tf_description.getText();
        String generic_name = "";
        String category = tf_category.getText();
        String category_id = cat.getId();

        String classification = tf_classification.getText();
        String classification_id = classi.getId();

        String sub_classification = tf_sub_classification.getText();
        String sub_classification_id = sub_class.getId();

        double product_qty = 0;
        String unit = tf_unit.getText();
        double conversion = 1;
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String date_added = DateType.now();
        String user_name = "";
        String item_type = "";
        int status = 0;
        String supplier = "";
        int fixed_price = 0;
        double cost = FitIn.toDouble(tf_cost.getText());
        String supplier_id = "";
        int multi_level_pricing = 0;
        int vatable = 0;
        double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
        double markup = 0;
        String main_barcode = tf_item_code.getText();

        String brand = tf_brand.getText();
        String brand_id = brands.getId();
        String model = tf_model.getText();
        String model_id = models.getId();
        int selling_type = FitIn.toInt(tf_selling_type.getText());
        String branch = "";
        String branch_code = "";
        String location = "";
        String location_id = "";
        String serial_no = "";
        int allow_negative_inventory = 0;
        int auto_order = 0;
        if (jCheckBox1.isSelected()) {
            allow_negative_inventory = 1;
        }
        if (jCheckBox2.isSelected()) {
            auto_order = 1;
        }
        Inventory_barcodes.to_inventory_barcodes to = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order);
        Inventory_barcodes.add_inventory_barcodes(to);
        data_cols_inventory_barcodes();
        tf_inventory_barcode.grabFocus();
        Alert.set(1, "");
    }

    private ArrayListModel tbl_inventory_multi_level_pricing_ALM;
    private Tblinventory_multi_level_pricingModel tbl_inventory_multi_level_pricing_M;

    private void init_tbl_inventory_multi_level_pricing() {
        tbl_inventory_multi_level_pricing_ALM = new ArrayListModel();
        tbl_inventory_multi_level_pricing_M = new Tblinventory_multi_level_pricingModel(tbl_inventory_multi_level_pricing_ALM);
        tbl_inventory_multi_level_pricing.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_inventory_multi_level_pricing.
                setModel(tbl_inventory_multi_level_pricing_M);
        tbl_inventory_multi_level_pricing.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_multi_level_pricing.setRowHeight(25);
        int[] tbl_widths_inventory_multi_level_pricing = {100, 100, 100, 100, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_multi_level_pricing.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_inventory_multi_level_pricing, i, tbl_widths_inventory_multi_level_pricing[i]);
        }
        Dimension d = tbl_inventory_multi_level_pricing.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_inventory_multi_level_pricing.getTableHeader().
                setPreferredSize(d);
        tbl_inventory_multi_level_pricing.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_inventory_multi_level_pricing.setRowHeight(25);
        tbl_inventory_multi_level_pricing.
                setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_inventory_multi_level_pricing(List<to_inventory_multi_level_pricing> acc) {
        tbl_inventory_multi_level_pricing_ALM.clear();
        tbl_inventory_multi_level_pricing_ALM.addAll(acc);
    }

    public static class Tblinventory_multi_level_pricingModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Unit", "Conversion", "Markup", "Selling Price", "unit", "conversion", "markup", "selling_price"
        };

        public Tblinventory_multi_level_pricingModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
                return true;
            }
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
            to_inventory_multi_level_pricing tt = (to_inventory_multi_level_pricing) getRow(row);
            switch (col) {
                case 0:
                    return tt.unit;
                case 1:
                    return tt.conversion;
                case 2:
                    return tt.markup;
                case 3:
                    return FitIn.fmt_wc_0(tt.selling_price);
                case 4:
                    return tt.unit;
                case 5:
                    return tt.conversion;
                case 6:
                    return tt.markup;
                default:
                    return tt.selling_price;
            }
        }
    }

    private void data_cols_multi_level_pricing() {
        String search = tf_item_code.getText();
        loadData_inventory_multi_level_pricing(S1_inventory_multi_level_pricing.
                ret_data(search));
    }

    private void add_inventory_multi_level_pricing() {
        int id = -1;
        String main_barcode = tf_item_code.getText();
        String barcode = tf_item_code.getText();
        String description = tf_description.getText();
        String unit = tf_multi_unit.getText();
        double conversion = FitIn.toDouble(tf_conversion.getText());
        double markup = FitIn.toDouble(tf_markup.getText());
        double selling_price = FitIn.toDouble(tf_multi_selling_price.getText());
        to_inventory_multi_level_pricing to = new to_inventory_multi_level_pricing(id, main_barcode, barcode, description, unit, conversion, markup, selling_price);
        S1_inventory_multi_level_pricing.add_inventory_multi_level_pricing(to);
        data_cols_multi_level_pricing();
        clear_inventory_multi_level_pricing();
    }

    private void select_inventory_multi_level_pricing() {
        int row = tbl_inventory_multi_level_pricing.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory_multi_level_pricing to = (to_inventory_multi_level_pricing) tbl_inventory_multi_level_pricing_ALM.
                get(tbl_inventory_multi_level_pricing.
                        convertRowIndexToModel(row));

        tf_description.setText(to.description);
        tf_multi_unit.setText(to.unit);
        tf_conversion.setText(FitIn.fmt_wc_0(to.conversion));
        tf_markup.setText(FitIn.fmt_wc_0(to.markup));
        tf_multi_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
    }

    private void edit_inventory_multi_level_pricing() {
        int row = tbl_inventory_multi_level_pricing.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory_multi_level_pricing to = (to_inventory_multi_level_pricing) tbl_inventory_multi_level_pricing_ALM.
                get(tbl_inventory_multi_level_pricing.
                        convertRowIndexToModel(row));
        int id = to.id;

        String description = tf_description.getText();
        String unit = tf_multi_unit.getText();
        double conversion = FitIn.toDouble(tf_conversion.getText());
        double markup = FitIn.toDouble(tf_markup.getText());
        double selling_price = FitIn.toDouble(tf_multi_selling_price.getText());
        to_inventory_multi_level_pricing to1 = new to_inventory_multi_level_pricing(id, to.main_barcode, to.barcode, description, unit, conversion, markup, selling_price);
        S1_inventory_multi_level_pricing.edit_inventory_multi_level_pricing(to1);
        data_cols_multi_level_pricing();
        clear_inventory_multi_level_pricing();
    }

    private void clear_inventory_multi_level_pricing() {
        tf_description.setText("");
        tf_multi_unit.setText("");
        tf_conversion.setText("");
        tf_markup.setText("");
        tf_multi_selling_price.setText("");
    }

    private void delete_inventory_multi_level_pricing() {
        int row = tbl_inventory_multi_level_pricing.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory_multi_level_pricing to = (to_inventory_multi_level_pricing) tbl_inventory_multi_level_pricing_ALM.
                get(tbl_inventory_multi_level_pricing.
                        convertRowIndexToModel(row));
        S1_inventory_multi_level_pricing.
                delete_inventory_multi_level_pricing(to);
        data_cols_multi_level_pricing();
        clear_inventory_multi_level_pricing();
    }

    private void compute_markup() {
        double cost = FitIn.toDouble(tf_cost.getText());
        double conversion = FitIn.toDouble(tf_conversion.getText());
        double markup = FitIn.toDouble(tf_markup.getText());
        double m = (markup / 100) * (cost * conversion);
        double total = (cost * conversion) + m;
        tf_multi_selling_price.setText(FitIn.fmt_wc_0(total));
    }
    private ArrayListModel tbl_inventory_assembly_ALM;
    private Tblinventory_assemblyModel tbl_inventory_assembly_M;

    private void init_tbl_inventory_assembly() {
        tbl_inventory_assembly_ALM = new ArrayListModel();
        tbl_inventory_assembly_M = new Tblinventory_assemblyModel(tbl_inventory_assembly_ALM);
        tbl_inventory_assembly.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_inventory_assembly.setModel(tbl_inventory_assembly_M);
        tbl_inventory_assembly.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_assembly.setRowHeight(25);
        int[] tbl_widths_inventory_assembly = {100, 110, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_assembly.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_inventory_assembly, i, tbl_widths_inventory_assembly[i]);
        }
        Dimension d = tbl_inventory_assembly.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_inventory_assembly.getTableHeader().
                setPreferredSize(d);
        tbl_inventory_assembly.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_inventory_assembly.setRowHeight(25);
        tbl_inventory_assembly.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_inventory_assembly(List<to_inventory_assembly> acc) {
        tbl_inventory_assembly_ALM.clear();
        tbl_inventory_assembly_ALM.addAll(acc);
    }

    public static class Tblinventory_assemblyModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "Unit", "Price", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "main_barcode", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code"
        };

        public Tblinventory_assemblyModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
                return true;
            }
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
            to_inventory_assembly tt = (to_inventory_assembly) getRow(row);
            switch (col) {
                case 0:
                    return tt.product_qty;
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
                case 3:
                    return tt.unit;
                case 4:
                    return tt.selling_price;
                case 5:
                    return tt.category_id;
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
                case 24:
                    return tt.reorder_level;
                case 25:
                    return tt.markup;
                case 26:
                    return tt.main_barcode;
                case 27:
                    return tt.brand;
                case 28:
                    return tt.brand_id;
                case 29:
                    return tt.model;
                case 30:
                    return tt.model_id;
                case 31:
                    return tt.selling_type;
                case 32:
                    return tt.branch;
                default:
                    return tt.branch_code;
            }
        }
    }

    private void data_cols_assembly() {
        String search = tf_item_code.getText();
        loadData_inventory_assembly(S1_inventory_assembly.ret_data(search));
    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_assembly_list = new ArrayList();

    private void init_inventory_assembly() {
        String search = tf_assembly_barcode.getText();
        inventory_assembly_list.clear();
        inventory_assembly_list = Inventory_barcodes.ret_data2(search);
        Object[][] obj = new Object[inventory_assembly_list.size()][6];
        int i = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : inventory_assembly_list) {
            obj[i][0] = to.barcode;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = to.description;//TextHighlighter1.highlight2(to.description, to.description, "");
            obj[i][2] = to.main_barcode;
            obj[i][3] = to.unit;
            obj[i][4] = to.conversion;
            obj[i][5] = to.selling_price;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, 300, 100, 50, 50, 100};
        int width = 0;
        for (int w : tbl_widths_customers) {
            width += w;
        }
        String[] col_names = {"Barcode", "Description", "Item Code", "Unit", "Conversion", "Price"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup2(tf_assembly_barcode, obj, labels, tbl_widths_customers, col_names, width);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {

                Inventory_barcodes.to_inventory_barcodes to = inventory_assembly_list.
                        get(data.selected_row);
                tf_assembly_barcode.setText(to.barcode);
                tf_assembly_selling_price.setText(FitIn.
                        fmt_wc_0(to.selling_price));
                tf_assembly_item_code.setText(to.main_barcode);
                tf_assembly_description.setText(to.description);
                tf_assembly_unit.setText(to.unit);
                selected_assembly = data.selected_row;
            }
        });
    }
    int selected_assembly = -1;

    private void add_assembly() {
        if (selected_assembly == -1) {
            return;
        }
        Inventory_barcodes.to_inventory_barcodes to = inventory_assembly_list.
                get(selected_assembly);
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
        double product_qty = FitIn.toDouble(tf_assembly_qty.getText());
        String unit = to.unit;
        double conversion = to.conversion;
        double selling_price = to.selling_price;
        String date_added = DateType.now();
        String user_name = "";
        String item_type = to.item_type;
        int status = 1;
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
        S1_inventory_assembly.to_inventory_assembly assembly = new to_inventory_assembly(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code);
        S1_inventory_assembly.add_inventory_assembly(assembly);
        clear_assembly();
        tf_assembly_barcode.grabFocus();
//        data_cols_assembly();
        Alert.set(1, "");
    }

    private void clear_assembly() {
        tf_assembly_barcode.setText("");
        tf_assembly_description.setText("");
        tf_assembly_item_code.setText("");
        tf_assembly_qty.setText("");
        tf_assembly_selling_price.setText("");
        tf_assembly_unit.setText("");
    }

    private void edit_assembly() {
        int row = tbl_inventory_assembly.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory_assembly to = (to_inventory_assembly) tbl_inventory_assembly_ALM.
                get(tbl_inventory_assembly.convertRowIndexToModel(row));

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
        double product_qty = FitIn.toDouble(tf_assembly_qty.getText());
        String unit = to.unit;
        double conversion = to.conversion;
        double selling_price = to.selling_price;
        String date_added = DateType.now();
        String user_name = "";
        String item_type = to.item_type;
        int status = 1;
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
        S1_inventory_assembly.to_inventory_assembly assembly = new to_inventory_assembly(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code);
        S1_inventory_assembly.edit_inventory_assembly(assembly);
        clear_assembly();
        tf_assembly_barcode.grabFocus();
//        data_cols_assembly();
        Alert.set(2, "");
    }

    private void select_assembly() {
        int row = tbl_inventory_assembly.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory_assembly to = (to_inventory_assembly) tbl_inventory_assembly_ALM.
                get(tbl_inventory_assembly.convertRowIndexToModel(row));

        tf_assembly_barcode.setText(to.barcode);
        tf_assembly_description.setText(to.description);
        tf_assembly_item_code.setText(to.item_type);
        tf_assembly_qty.setText(FitIn.fmt_woc(to.product_qty));
        tf_assembly_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
        tf_assembly_unit.setText(to.unit);
    }

    private void delete_assembly() {
        int row = tbl_inventory_assembly.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory_assembly to = (to_inventory_assembly) tbl_inventory_assembly_ALM.
                get(tbl_inventory_assembly.convertRowIndexToModel(row));
        S1_inventory_assembly.delete_inventory_assembly(to);
        clear_assembly();
        tf_assembly_barcode.grabFocus();
//        data_cols_assembly();
        Alert.set(3, "");
    }

    List<S1_inventory_categories.to_inventory_category> inventory_category_list = new ArrayList();

    private void init_inventory_category() {
        String search = tf_category.getText();
        inventory_category_list.clear();
        inventory_category_list = S1_inventory_categories.ret_data3(search);
        Object[][] obj = new Object[inventory_category_list.size()][2];
        int i = 0;
        for (S1_inventory_categories.to_inventory_category to : inventory_category_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_category, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_categories.to_inventory_category to = inventory_category_list.
                        get(data.selected_row);
                tf_category.setText(to.name);
                Field.Combo cat = (Field.Combo) tf_category;
                Field.Combo classi = (Field.Combo) tf_classification;
                Field.Combo sub_class = (Field.Combo) tf_sub_classification;
                Field.Combo brands = (Field.Combo) tf_brand;
                Field.Combo models = (Field.Combo) tf_model;
                cat.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_classification.to_inventory_classification> inventory_classification_list = new ArrayList();

    private void init_inventory_classification() {
        Field.Combo cat = (Field.Combo) tf_category;
        final Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        String search = tf_classification.getText();
        String category_code = cat.getId();
        inventory_classification_list.clear();
        String where = " where name like '%" + search + "%'  order by name asc";
        inventory_classification_list = S1_inventory_classification.ret_where(where);
        Object[][] obj = new Object[inventory_classification_list.size()][2];
        int i = 0;
        for (S1_inventory_classification.to_inventory_classification to : inventory_classification_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_classification, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_classification.to_inventory_classification to = inventory_classification_list.
                        get(data.selected_row);
                tf_classification.setText(to.name);
                classi.setId("" + to.id);
            }
        });
    }
    List<S1_inventory_sub_classification.to_inventory_sub_classification> inventory_sub_classification_list = new ArrayList();

    private void init_inventory_sub_classification() {
        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        final Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        String search = tf_sub_classification.getText();
        String classification = classi.getId();
        inventory_sub_classification_list.clear();
        inventory_sub_classification_list = S1_inventory_sub_classification.ret_data4(search, classification);
        Object[][] obj = new Object[inventory_sub_classification_list.size()][2];
        int i = 0;
        for (S1_inventory_sub_classification.to_inventory_sub_classification to : inventory_sub_classification_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_sub_classification, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_sub_classification.to_inventory_sub_classification to = inventory_sub_classification_list.
                        get(data.selected_row);
                tf_sub_classification.setText(to.name);
                sub_class.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_brand.to_inventory_brand> inventory_brand_list = new ArrayList();

    private void init_inventory_brand() {
        String search = tf_brand.getText();
        inventory_brand_list.clear();
        inventory_brand_list = S1_inventory_brand.ret_data3(search);
        Object[][] obj = new Object[inventory_brand_list.size()][2];
        int i = 0;
        for (S1_inventory_brand.to_inventory_brand to : inventory_brand_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_brand, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_brand.to_inventory_brand to = inventory_brand_list.
                        get(data.selected_row);
                tf_brand.setText(to.name);
                Field.Combo brands = (Field.Combo) tf_brand;
                brands.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_model.to_inventory_model> inventory_model_list = new ArrayList();

    private void init_inventory_model() {
        Field.Combo brands = (Field.Combo) tf_brand;
        final Field.Combo models = (Field.Combo) tf_model;

        String search = tf_model.getText();
        String brand_id = brands.getId();
        inventory_model_list.clear();
        inventory_model_list = S1_inventory_model.ret_data_brand4(search, brand_id);
        Object[][] obj = new Object[inventory_model_list.size()][2];
        int i = 0;
        for (S1_inventory_model.to_inventory_model to : inventory_model_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_model, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_model.to_inventory_model to = inventory_model_list.
                        get(data.selected_row);
                tf_model.setText(to.name);
                models.setId("" + to.id);
            }
        });
    }
    List<String> status_list = new ArrayList();

    private void init_status() {
        String search = tf_status.getText();
        status_list.clear();
        status_list.add("Active");
        status_list.add("InActive");
        Object[][] obj = new Object[status_list.size()][1];
        int i = 0;
        for (String to : status_list) {
            obj[i][0] = to;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_status.getWidth()};
        String[] col_names = {"Status"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_status, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                String status = status_list.
                        get(data.selected_row);
                tf_status.setText(status);
            }
        });
    }

    List<S1_inventory_uom.to_inventory_uom> uom_list = new ArrayList();

    private void init_default_uom() {
        String search = tf_unit.getText();
        uom_list.clear();
        uom_list = S1_inventory_uom.ret_data(search);
        Object[][] obj = new Object[uom_list.size()][1];
        int i = 0;
        for (S1_inventory_uom.to_inventory_uom to : uom_list) {
            obj[i][0] = to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {350};
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_unit, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_uom.to_inventory_uom to = uom_list.
                        get(data.selected_row);
                tf_unit.setText(to.name);
            }
        });
    }

    private void init_uom() {
        String search = tf_multi_unit.getText();
        uom_list.clear();
        uom_list = S1_inventory_uom.ret_data(search);
        Object[][] obj = new Object[uom_list.size()][1];
        int i = 0;
        for (S1_inventory_uom.to_inventory_uom to : uom_list) {
            obj[i][0] = to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {350};
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_multi_unit, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_uom.to_inventory_uom to = uom_list.
                        get(data.selected_row);
                tf_multi_unit.setText(to.name);
            }
        });
    }

    private ArrayListModel tbl_receipt_items_ALM;
    private Tblreceipt_itemsModel tbl_receipt_items_M;

    private void init_tbl_receipt_items() {
        tbl_receipt_items_ALM = new ArrayListModel();
        tbl_receipt_items_M = new Tblreceipt_itemsModel(tbl_receipt_items_ALM);
        tbl_receipt_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipt_items.setModel(tbl_receipt_items_M);
        tbl_receipt_items.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_items.setRowHeight(25);
        int[] tbl_widths_receipt_items = {50, 80, 100, 50, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipt_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_receipt_items, i, tbl_widths_receipt_items[i]);
        }
        Dimension d = tbl_receipt_items.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_receipt_items.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_receipt_items.setRowHeight(25);
        tbl_receipt_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_receipt_items(List<S1_receipt_items.to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);
    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "Unit", "Cost", "Total", "Date", "remarks", "barcode", "description", "qty", "cost", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "date_delivered", "date_received", "barcodes", "batch_no", "serial_no", "main_barcode", "brand", "brand_id", "model", "model_id", "status"
        };

        public Tblreceipt_itemsModel(ListModel listmodel) {
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
            S1_receipt_items.to_receipt_items tt = (S1_receipt_items.to_receipt_items) getRow(row);
            switch (col) {
                case 0:
                    return FitIn.fmt_woc(tt.qty);
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
                case 3:
                    return tt.unit;
                case 4:
                    return tt.cost;
                case 5:
                    return FitIn.fmt_wc_0(tt.cost * tt.qty);
                case 6:
                    return DateType.convert_dash_date(tt.date_delivered);

                case 7:
                    return tt.remarks;
                case 8:
                    return tt.barcode;
                case 9:
                    return tt.description;
                case 10:
                    return tt.qty;
                case 11:
                    return tt.cost;
                case 12:
                    return tt.category;
                case 13:
                    return tt.category_id;
                case 14:
                    return tt.classification;
                case 15:
                    return tt.classification_id;
                case 16:
                    return tt.sub_class;
                case 17:
                    return tt.sub_class_id;
                case 18:
                    return tt.conversion;
                case 19:
                    return tt.unit;
                case 20:
                    return tt.date_delivered;
                case 21:
                    return tt.date_received;
                case 22:
                    return tt.barcodes;
                case 23:
                    return tt.batch_no;
                case 24:
                    return tt.serial_no;
                case 25:
                    return tt.main_barcode;
                case 26:
                    return tt.brand;
                case 27:
                    return tt.brand_id;
                case 28:
                    return tt.model;
                case 29:
                    return tt.model_id;
                default:
                    return tt.status;
            }
        }
    }

    private void data_cols() {
        String search = tf_item_code.getText();
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        loadData_receipt_items(S1_receipt_items.
                ret_data4(search, date_from, date_to));
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {
        String search = tf_location.getText();
        String branch_id = tf_search_branch_code.getText();
        branch_location_list.clear();
        branch_location_list = S1_branch_locations.
                ret_data_branch(search, branch_id);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = to.id;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_location.setText("" + to.location);
                tf_location_id.setText("" + to.id);
                data_cols_inventory_barcodes();
            }
        });
    }

    private void enable_branch() {
        if (!cb_branch.isSelected()) {
            tf_qty_branch.grabFocus();
            tf_qty_branch.enable(true);
        } else {
            tf_qty_branch.transferFocus();
            tf_qty_branch.enable(false);
            tf_qty_branch.setText("");
            tf_search_branch_code.setText("");
        }
    }

    private void enable_location() {
        if (!cb_location.isSelected()) {
            tf_location.grabFocus();
            tf_location.enable(true);
        } else {
            tf_location.transferFocus();
            tf_location.enable(false);
            tf_location.setText("");
            tf_location_id.setText("");
        }
    }

    private void add_comma_separator() {

    }

    private void uom() {
        final Field.Combo combo = (Field.Combo) tf_unit;
        String uom = tf_unit.getText();
        double conversion = FitIn.toDouble(tf_uom_conversion.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        int is_default = 1;
        to_uom to = new to_uom(0, uom, conversion, selling_price, is_default);
        Window p = (Window) this;
        Dlg_inventory_uom nd = Dlg_inventory_uom.create(p, true);
        nd.do_pass(combo.getId(), to);
        nd.setCallback(new Dlg_inventory_uom.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_uom.OutputData data) {
                closeDialog.ok();
                combo.setId(data.uom);
            }
        });
        Point point = jLabel32.getLocationOnScreen();
        nd.setLocation(point.x - 478, point.y);
        nd.setVisible(true);
    }

    private void get_console_statements() {
        Window p = (Window) this;
        Dlg_inventory_get_console nd = Dlg_inventory_get_console.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_get_console.Callback() {
            @Override
            public void insert(CloseDialog closeDialog, Dlg_inventory_get_console.OutputData data) {
                closeDialog.ok();
                String myString = "";

                List<String> query = add_inventory_console();
                for (String s : query) {
                    myString = myString + "" + s + "\n";

                }
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
            }

            @Override
            public void update(CloseDialog closeDialog, Dlg_inventory_get_console.OutputData data) {
                closeDialog.ok();
                String myString = "";
                List<String> query = edit_inventory_to_console();
                for (String s : query) {
                    myString = myString + "" + s + "\n";

                }
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
            }
        });
        Point point = jButton1.getLocationOnScreen();
        nd.setLocation(point.x + 35, point.y);
        nd.setVisible(true);
    }

    private void set_console_statements() {
        Window p = (Window) this;
        Dlg_inventory_set_console nd = Dlg_inventory_set_console.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_set_console.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_set_console.OutputData data) {

                List<String> query = data.quer;
                Inventory.set_console(query);
                Alert.set(0, "Success!");

            }
        });
        Point point = jButton2.getLocationOnScreen();
        nd.setLocation(point.x + 35, point.y);
        nd.setVisible(true);
    }

    private void cloud_upload() {
        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
            String where = " where is_uploaded=0 or is_uploaded=2 limit 1";
            List<Inventory.to_inventory> inventory_local = Inventory.ret_data22(where);
            if (!inventory_local.isEmpty()) {
                Window p = (Window) this;
                Dlg_inventory_cloud_transactions_main nd = Dlg_inventory_cloud_transactions_main.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_inventory_cloud_transactions_main.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_inventory_cloud_transactions_main.OutputData data) {
                        closeDialog.ok();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

        }
    }

    private void check_items() {
        Window p = (Window) this;
        Dlg_inventory_cloud_transactions_local nd = Dlg_inventory_cloud_transactions_local.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_cloud_transactions_local.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_cloud_transactions_local.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void user_price_change() {
        Window p = (Window) this;
        Dlg_user_price_change nd = Dlg_user_price_change.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_user_price_change.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_user_price_change.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void assembly() {
        String type = tf_selling_type.getText();
        if (type.equalsIgnoreCase("Regular")) {
            Alert.set(0, "Item assembly disabled");
            return;
        }
        List<Inventory_barcodes.to_inventory_barcodes> barcodes = Inventory_barcodes.ret_where(" where main_barcode='" + my_item.barcode + "' limit 1");
        Inventory_barcodes.to_inventory_barcodes item = barcodes.get(0);
        Window p = (Window) this;
        Dlg_inventory_assembly nd = Dlg_inventory_assembly.create(p, true);
        nd.setTitle("");
        nd.do_pass(item);
        nd.setCallback(new Dlg_inventory_assembly.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_assembly.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
