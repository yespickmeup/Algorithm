/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.encoding_inventory;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.encoding_inventory.Encoding_inventory.to_encoding_inventory;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.S2_inventory_barcodes;
import POS.sheet.Dlg_sheet;
import POS.sheet.S1_sheet;
import POS.unit_of_measure.S1_unit_of_measure;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
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

/**
 *
 * @author Ronald
 */
public class Dlg_encode_inventory extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_encode_inventory
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
    private Dlg_encode_inventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_encode_inventory(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_encode_inventory() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_encode_inventory myRef;

    private void setThisRef(Dlg_encode_inventory myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_encode_inventory> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_encode_inventory create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_encode_inventory create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_encode_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_encode_inventory((java.awt.Frame) parent, false);
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
            Dlg_encode_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_encode_inventory((java.awt.Dialog) parent, false);
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

        Dlg_encode_inventory dialog = Dlg_encode_inventory.
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_encoding_inventory = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbl_total_items = new javax.swing.JLabel();
        lbl_total_qty = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_description = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_item_code = new Field.Search();
        jLabel3 = new javax.swing.JLabel();
        tf_sheet_no = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jButton1 = new Button.Warning();
        jButton2 = new Button.Info();
        jButton3 = new Button.Primary();
        tf_qty_branch = new Field.Combo();
        tf_search_branch_code = new javax.swing.JTextField();
        tf_location = new javax.swing.JTextField();
        tf_location_id = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_counted_by = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_checked_by = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_cost = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_selling_price = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_description1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton4 = new Button.Default();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton5 = new Button.Default();
        jButton6 = new Button.Success();
        jLabel21 = new javax.swing.JLabel();
        tf_qty1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        tf_qty_branch1 = new Field.Combo();
        jLabel32 = new javax.swing.JLabel();
        tf_location1 = new Field.Combo();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        tf_search1 = new Field.Input();
        jLabel40 = new javax.swing.JLabel();
        jButton7 =  new Button.Default();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        tf_search2 = new Field.Input();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_encoding_inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_encoding_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_encoding_inventoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_encoding_inventory);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tota Items:");

        lbl_total_items.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_total_items.setText("0");

        lbl_total_qty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_total_qty.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tota Qty:");

        jLabel12.setText("Status:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total_items, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(524, 524, 524)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lbl_total_items)
                        .addComponent(jLabel7)
                        .addComponent(lbl_total_qty))
                    .addComponent(jLabel12)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Item Code:");

        tf_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description.setFocusable(false);
        tf_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descriptionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Search:");

        tf_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_item_code.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_item_codeMouseClicked(evt);
            }
        });
        tf_item_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_item_codeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Sheet #:");

        tf_sheet_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_sheet_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sheet_noActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Qty:");

        tf_qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
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

        tf_qty_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_qty_branch.setEnabled(false);
        tf_qty_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_qty_branchMouseClicked(evt);
            }
        });
        tf_qty_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qty_branchActionPerformed(evt);
            }
        });

        tf_search_branch_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search_branch_code.setFocusable(false);

        tf_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location.setEnabled(false);
        tf_location.setFocusable(false);
        tf_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_locationActionPerformed(evt);
            }
        });

        tf_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location_id.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Branch:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Location:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Counted by:");

        tf_counted_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_counted_by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_counted_byActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Checked by:");

        tf_checked_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_checked_by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_checked_byActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cost:");

        tf_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Selling Price:");

        tf_selling_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_selling_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_selling_priceActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Barcode:");

        tf_description1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description1.setFocusable(false);
        tf_description1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_description1ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("(F1)-All");
        jCheckBox1.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Filter by:");

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("(F2)-Code");
        jCheckBox2.setFocusable(false);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("(F3)-Description");
        jCheckBox3.setFocusable(false);

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Date:");

        jDateChooser1.setEnabled(false);
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu2/magnifying-glass.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Finalize");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Remarks:");

        tf_qty1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_qty1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qty1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_qty_branch)
                            .addComponent(tf_location))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_search_branch_code)
                            .addComponent(tf_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(264, 264, 264))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_sheet_no, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_counted_by)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_checked_by))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_description)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_selling_price, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(tf_description1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_item_code)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_qty1))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qty_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tf_search_branch_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_checked_by, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_sheet_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_counted_by, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventory Encoding", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date From:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("To:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Branch:");

        tf_qty_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_qty_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_qty_branch1MouseClicked(evt);
            }
        });
        tf_qty_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qty_branch1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Location:");

        tf_location1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location1.setEnabled(false);
        tf_location1.setFocusable(false);
        tf_location1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_location1ActionPerformed(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("All");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Status:");

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("All");

        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setSelected(true);
        jCheckBox8.setText("Posted");

        buttonGroup2.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("Finalized");

        buttonGroup2.add(jCheckBox28);
        jCheckBox28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox28.setText("Deleted");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Filter by:");

        jCheckBox23.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox23.setSelected(true);
        jCheckBox23.setText("[F1]-All");
        jCheckBox23.setFocusable(false);

        jCheckBox24.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox24.setText("[F2]-Item Code");
        jCheckBox24.setFocusable(false);

        jCheckBox25.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox25.setText("[F3]-Barcode");
        jCheckBox25.setFocusable(false);

        jCheckBox26.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox26.setText("[F4]-Description");
        jCheckBox26.setFocusable(false);

        tf_search1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search1ActionPerformed(evt);
            }
        });
        tf_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search1KeyReleased(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Search:");

        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel19.setText("Total no. of rows:");

        jLabel20.setText("0");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Sheet #:");

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("All");

        tf_search2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search2ActionPerformed(evt);
            }
        });
        tf_search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox6)
                                            .addComponent(jCheckBox5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_qty_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_location1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jCheckBox4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jCheckBox7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBox8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(190, 190, 190)
                                                .addComponent(jCheckBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_search2))))
                            .addComponent(jCheckBox23))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jCheckBox24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(tf_search1)
                                        .addGap(10, 10, 10)))
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_qty_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_search2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_location1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox23)
                                    .addComponent(jCheckBox24)
                                    .addComponent(jCheckBox25)
                                    .addComponent(jCheckBox26))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_search1)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox8)
                        .addComponent(jCheckBox9)
                        .addComponent(jCheckBox28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_sheet_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sheet_noActionPerformed
        init_sheet();
    }//GEN-LAST:event_tf_sheet_noActionPerformed

    private void tf_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descriptionActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_descriptionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_encoding_inventory();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_encoding_inventory();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete_encoding_inventory();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_encoding_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_encoding_inventoryMouseClicked
        select_encoding_inventory();
    }//GEN-LAST:event_tbl_encoding_inventoryMouseClicked

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        add_encoding_inventory();
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void tf_qty_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qty_branchActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_tf_qty_branchActionPerformed

    private void tf_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_locationActionPerformed

    }//GEN-LAST:event_tf_locationActionPerformed

    private void tf_counted_byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_counted_byActionPerformed
        tf_checked_by.grabFocus();
    }//GEN-LAST:event_tf_counted_byActionPerformed

    private void tf_checked_byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_checked_byActionPerformed
        tf_description.grabFocus();
    }//GEN-LAST:event_tf_checked_byActionPerformed

    private void tf_selling_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_selling_priceActionPerformed
        add_encoding_inventory();
    }//GEN-LAST:event_tf_selling_priceActionPerformed

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
        add_encoding_inventory();
    }//GEN-LAST:event_tf_costActionPerformed

    private void tf_description1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_description1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_description1ActionPerformed

    private void tf_item_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_item_codeActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_item_codeActionPerformed

    private void tf_item_codeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_item_codeMouseClicked

    }//GEN-LAST:event_tf_item_codeMouseClicked

    private void tf_qty_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_qty_branchMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_qty_branchMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tf_item_code.setEnabled(true);
        tf_item_code.grabFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        choose_replenishment();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        finalize_encoding();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_qty_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_qty_branch1MouseClicked
        init_branch_locations2(tf_qty_branch1, tf_location1);
    }//GEN-LAST:event_tf_qty_branch1MouseClicked

    private void tf_qty_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qty_branch1ActionPerformed
        init_branch_locations2(tf_qty_branch1, tf_location1);
    }//GEN-LAST:event_tf_qty_branch1ActionPerformed

    private void tf_location1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_location1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_location1ActionPerformed

    private void tf_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search1ActionPerformed

    private void tf_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search1KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ret_replenishments();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tf_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search2ActionPerformed

    private void tf_search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search2KeyReleased

    private void tf_qty1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qty1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_qty1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_total_items;
    private javax.swing.JLabel lbl_total_qty;
    private javax.swing.JTable tbl_encoding_inventory;
    private javax.swing.JTextField tf_checked_by;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_counted_by;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_description1;
    private javax.swing.JTextField tf_item_code;
    private javax.swing.JTextField tf_location;
    private javax.swing.JTextField tf_location1;
    private javax.swing.JTextField tf_location_id;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_qty1;
    private javax.swing.JTextField tf_qty_branch;
    private javax.swing.JTextField tf_qty_branch1;
    private javax.swing.JTextField tf_search1;
    private javax.swing.JTextField tf_search2;
    private javax.swing.JTextField tf_search_branch_code;
    private javax.swing.JTextField tf_selling_price;
    private javax.swing.JTextField tf_sheet_no;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_smis_cebu_chickaloka");
//        jButton6.setEnabled(true);
        init_key();
        focus();
        init_tbl_encoding_inventory();
        init_tbl_encoding_inventory2(jTable1);
        set_default_branch();

        tf_search_branch_code.setVisible(false);
        tf_location_id.setVisible(false);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                choose_replenishment();
                tf_sheet_no.grabFocus();
            }
        });

        String where = " order by branch,location asc ";
        branch_location_list = S1_branch_locations.ret_where(where);
        branch_location_list2 = branch_location_list;
    }
    String location_ids = "";

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        location_ids = "" + to.id;

        tf_qty_branch.setText(to.branch);
        tf_search_branch_code.setText(to.branch_id);
        tf_location.setText(to.location);
        tf_location_id.setText("" + to.id);

        Field.Combo b = (Field.Combo) tf_qty_branch1;
        Field.Combo l = (Field.Combo) tf_location1;
        b.setText(to.branch);
        b.setId(to.branch_id);
        l.setText(to.location);
        l.setId("" + to.id);

        String where = " where user_id='" + MyUser.getUser_id() + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        for (S1_user_previleges.to_user_previleges to2 : datas) {
            if (to2.previledge.equalsIgnoreCase("Inventory Count - (Finalize)")) {
                jButton6.setEnabled(true);
            }
        }
    }

    private void focus() {
        JTextField[] tf = {tf_sheet_no, tf_description, tf_qty, tf_item_code, tf_qty_branch, tf_location, tf_counted_by, tf_checked_by, tf_cost, tf_selling_price};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
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
        tf_item_code.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    jCheckBox1.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    jCheckBox2.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    jCheckBox3.setSelected(true);
                }

            }
        });

        tf_search1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    jCheckBox23.setSelected(true);
                }

                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    jCheckBox24.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    jCheckBox25.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    jCheckBox26.setSelected(true);
                }
            }
        });
    }
    // </editor-fold>

    List<S1_sheet.to_sheet> sheet_list = new ArrayList();

    private void init_sheet() {
        String search = tf_sheet_no.getText();
        if (search.isEmpty()) {
            Alert.set(0, "Input Sheet No");
            return;
        }

        S1_sheet.to_sheet sheet = S1_sheet.ret_if_exists(search);
        if (sheet.id == -1) {
            S1_sheet.to_sheet to2 = new S1_sheet.to_sheet(1, FitIn.toInt(search));
            S1_sheet.add_sheet(to2);
        }
        tf_counted_by.grabFocus();
        data_cols();
    }

    List<Inventory.to_inventory> inventory_list = new ArrayList();

    private void init_inventory() {
        String search = tf_description.getText();
        inventory_list.clear();
        inventory_list = Inventory.ret_data3(search);
        if (inventory_list.size() == 1) {
            Inventory.to_inventory to = inventory_list.get(0);
            tf_item_code.setText(to.description);
            tf_description.setText(to.barcode);
            tf_cost.setText(FitIn.fmt_wc_0(to.cost));
            tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
            tf_qty.grabFocus();
        } else {
            Alert.set(0, "Item Not Found");
        }

    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        tf_item_code.setEnabled(false);
        final String location_id = tf_location_id.getText();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_item_code.getText();
                String where = " ";
                if (jCheckBox1.isSelected()) {
                    where = " where main_barcode='" + search + "' and location_id='" + location_id + "' "
                            + " or barcode='" + search + "' and location_id='" + location_id + "' "
                            + " or description like '%" + search + "%' and location_id='" + location_id + "' "
                            + " order by description asc ";
                }
                if (jCheckBox2.isSelected()) {
                    where = " where main_barcode='" + search + "' and location_id='" + location_id + "' "
                            + " or barcode='" + search + "' and location_id='" + location_id + "' "
                            + " order by description asc ";
                }
                if (jCheckBox3.isSelected()) {
                    where = " where description like '%" + search + "%' and location_id='" + location_id + "' "
                            + " order by description asc";
                }

                inventory_barcoders_list.clear();
                inventory_barcoders_list = S2_inventory_barcodes.ret_data(where);

                if (inventory_barcoders_list.size() == 1) {
                    selected_row = 0;
                    Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(0);
                    tf_item_code.setText(to.description);
                    tf_description.setText(to.main_barcode);
                    tf_description1.setText(to.barcode);
                    tf_cost.setText(FitIn.fmt_wc_0(to.cost));
                    tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
                    tf_item_code.setEnabled(true);
                    tf_qty.grabFocus();

                }
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    tf_item_code.setEnabled(true);
                    tf_item_code.grabFocus();
                }
                if (inventory_barcoders_list.size() > 1) {
                    tf_item_code.setEnabled(true);
                    Object[][] obj = new Object[inventory_barcoders_list.size()][7];
                    int it = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[it][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[it][1] = " " + to.main_barcode;
                        obj[it][2] = " " + to.barcode;
                        obj[it][3] = " " + to.description;
                        obj[it][4] = to.unit;
                        List<S1_unit_of_measure.to_uom> uoms = new ArrayList();
                        String[] list = to.unit.split(",");
                        int def = 0;
                        int o = 0;

                        for (String s : list) {
                            int i = s.indexOf(":");
                            int ii = s.indexOf("/");
                            int iii = s.indexOf("^");
                            String uom1 = "";
                            try {
                                uom1 = s.substring(1, i);
                            } catch (Exception e) {
                                uom1="";
                            }

                            double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                            double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
                            int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                            S1_unit_of_measure.to_uom to1 = new S1_unit_of_measure.to_uom(uom1, selling_price, conversion, is_default);
                            uoms.add(to1);
                            if (to1.is_default == 1) {
                                def = o;
                                break;
                            }
                            o++;
                        }
                        S1_unit_of_measure.to_uom t = (S1_unit_of_measure.to_uom) uoms.get(o);
                        obj[it][4] = " " + t.unit;
                        obj[it][5] = " " + FitIn.fmt_wc_0(to.cost);
                        obj[it][6] = " " + FitIn.fmt_wc_0(t.price);
                        it++;
                    }
                    JLabel[] labels = {};
                    double width = tf_item_code.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {40, 60, 100, w, 30, 50};
                    String[] col_names = {"Qty", "ItemCode", "Barcode", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_item_code, obj, labels, tbl_widths_customers, col_names);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            selected_row = data.selected_row;
                            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(data.selected_row);
                            tf_item_code.setText(to.description);
                            tf_description.setText(to.main_barcode);
                            tf_description1.setText(to.barcode);
                            tf_cost.setText(FitIn.fmt_wc_0(to.cost));
                            tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
                            tf_item_code.setEnabled(true);
                            tf_qty.grabFocus();
                        }
                    });
                }

            }
        });
        t.start();
    }
    int selected_row = -1;

    private ArrayListModel tbl_encoding_inventory_ALM;
    private Tblencoding_inventoryModel tbl_encoding_inventory_M;

    private void init_tbl_encoding_inventory() {
        tbl_encoding_inventory_ALM = new ArrayListModel();
        tbl_encoding_inventory_M = new Tblencoding_inventoryModel(tbl_encoding_inventory_ALM);
        tbl_encoding_inventory.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_encoding_inventory.setModel(tbl_encoding_inventory_M);
        tbl_encoding_inventory.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_encoding_inventory.setRowHeight(25);
        int[] tbl_widths_encoding_inventory = {50, 100, 100, 100, 100, 100, 100, 180, 50, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_encoding_inventory.length; i < n; i++) {
            if (i == 4) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_encoding_inventory, i, tbl_widths_encoding_inventory[i]);
        }
        Dimension d = tbl_encoding_inventory.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_encoding_inventory.getTableHeader().
                setPreferredSize(d);
        tbl_encoding_inventory.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_encoding_inventory.setRowHeight(25);
        tbl_encoding_inventory.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_encoding_inventory(List<to_encoding_inventory> acc) {
        tbl_encoding_inventory_ALM.clear();
        tbl_encoding_inventory_ALM.addAll(acc);
    }

    public static class Tblencoding_inventoryModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "#", "Qty", "Item Code", "Barcode", "Description", "Counted By", "Checked By", "Remarks", "Status", "date_added", "user_name", "screen_name", "sheet_no"
        };

        public Tblencoding_inventoryModel(ListModel listmodel) {
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
            to_encoding_inventory tt = (to_encoding_inventory) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.screen_name;
                case 1:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 2:
                    return " " + tt.item_code;
                case 3:
                    return " " + tt.barcode;
                case 4:
                    return " " + tt.description;
                case 5:
                    return " " + tt.counted_by;
                case 6:
                    return " " + tt.checked_by;
                case 7:
                    return " " + tt.remarks;
                case 8:
                    if (tt.status == 0) {
                        return " Posted";
                    }
                    if (tt.status == 1) {
                        return " Finalized";
                    }
                    if (tt.status == 2) {
                        return " Deleted";
                    }

                case 9:
                    return tt.date_added;
                case 10:
                    return tt.user_name;
                case 11:
                    return tt.screen_name;
                default:
                    return tt.sheet_no;
            }
        }
    }

    private void data_cols() {
        String where = "";
        String search = tf_sheet_no.getText();
        String date_added = "";
        try {
            date_added = DateType.sf.format(jDateChooser1.getDate());
        } catch (Exception e) {
            Alert.set(0, "Select Date!");
            choose_replenishment();
            return;
        }

        String location_id = tf_location_id.getText();
        where = where + " where sheet_no='" + search + "' and location_id='" + location_id + "' ";
        where = where + " and Date(date_added) ='" + date_added + "'  ";

        List<to_encoding_inventory> datas = Encoding_inventory.ret_data_encoding(where);
        loadData_encoding_inventory(datas);
        int qty = 0;
        int count = datas.size();
        for (to_encoding_inventory to : datas) {
            qty += to.qty;
        }
        lbl_total_items.setText("" + count);
        lbl_total_qty.setText("" + qty);
    }

    private void add_encoding_inventory() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Encoding - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int id = -1;
        String item_code = tf_description.getText();
        String barcode = tf_description1.getText();
        String description = tf_item_code.getText();
        String branch = tf_qty_branch.getText();
        String branch_id = tf_search_branch_code.getText();
        String location = tf_location.getText();
        String location_id = tf_location_id.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
//        if (qty <= 0) {
//            Alert.set(0, "Input Quantity");
//            return;
//        }
        String date_added = "";
        try {
            date_added = DateType.sf.format(jDateChooser1.getDate()) + " 23:00:01";
        } catch (Exception e) {
            Alert.set(0, "Select Date!");
            choose_replenishment();
            return;
        }

        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String sheet_no = tf_sheet_no.getText();
        String counted_by = tf_counted_by.getText();
        String checked_by = tf_checked_by.getText();
        double cost = FitIn.toDouble(tf_cost.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String remarks = tf_qty1.getText();
        to_encoding_inventory to = new to_encoding_inventory(id, item_code, barcode, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, 0, counted_by, checked_by, cost, selling_price, user_id, user_screen_name, remarks);
        Encoding_inventory.add_encoding_inventory(to);
        data_cols();
        clear_encoding_inventory();
        Alert.set(1, "");
        tf_item_code.grabFocus();
    }

    private void select_encoding_inventory() {
        int row = tbl_encoding_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_encoding_inventory to = (to_encoding_inventory) tbl_encoding_inventory_ALM.
                get(tbl_encoding_inventory.convertRowIndexToModel(row));
        if (to.status == 2) {
            Alert.set(0, "Cannot proceed, already deleted!");
            return;
        }
        if (to.status == 1) {
            Alert.set(0, "Cannot proceed, already finalized!");
            return;
        }
        int col = tbl_encoding_inventory.getSelectedColumn();
        if (col == 8) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Are you sure you want to finalize this transaction?");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    S1_finalize_encoding.edit_encoding_inventory2(to, 0);
                    Alert.set(2, "");
                    data_cols();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else {
            tf_item_code.setText(to.description);
            tf_description.setText(to.item_code);
            tf_qty.setText(FitIn.fmt_woc(to.qty));
            tf_sheet_no.setText(to.sheet_no);
            tf_counted_by.setText(to.counted_by);
            tf_checked_by.setText(to.checked_by);
            tf_cost.setText(FitIn.fmt_wc_0(to.cost));
            tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));

            tf_qty_branch.setText(to.branch);
            tf_search_branch_code.setText(to.branch_id);
            tf_location.setText(to.location);
            tf_location_id.setText(to.location_id);
            tf_qty1.setText(to.remarks);
            try {
                Date d = DateType.datetime.parse(to.date_added);
                jDateChooser1.setDate(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_encode_inventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void edit_encoding_inventory() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Encoding - (Edit)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_encoding_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_encoding_inventory to = (to_encoding_inventory) tbl_encoding_inventory_ALM.
                get(tbl_encoding_inventory.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot Update finalized Transaction!");
            return;
        }
        if (to.status == 2) {
            Alert.set(0, "Cannot Update deleted Transaction!");
            return;
        }
        int id = to.id;
        String item_code = tf_description.getText();
        String barcode = tf_description1.getText();
        String description = tf_item_code.getText();
        String branch = tf_qty_branch.getText();
        String branch_id = tf_search_branch_code.getText();
        String location = tf_location.getText();
        String location_id = tf_location_id.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        String date_added = "";
        try {
            date_added = DateType.sf.format(jDateChooser1.getDate()) + " 00:00:01";
        } catch (Exception e) {
            Alert.set(0, "Select Date!");
            choose_replenishment();
            return;
        }

        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String sheet_no = tf_sheet_no.getText();
        String counted_by = tf_counted_by.getText();
        String checked_by = tf_checked_by.getText();
        double cost = FitIn.toDouble(tf_cost.getText());
        double selling_price = FitIn.toDouble(tf_cost.getText());
        String user_id = to.user_id;
        String user_screen_name = to.user_screen_name;
        String remarks = tf_qty1.getText();
        final to_encoding_inventory to1 = new to_encoding_inventory(id, item_code, barcode, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, to.status, counted_by, checked_by, cost, selling_price, user_id, user_screen_name, remarks);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to update this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Encoding_inventory.edit_encoding_inventory(to1);
                data_cols();
                clear_encoding_inventory();
                Alert.set(2, "");
                tf_item_code.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void clear_encoding_inventory() {
        tf_item_code.setText("");
        tf_description.setText("");
        tf_qty.setText("");
        tf_qty1.setText("");
    }

    private void delete_encoding_inventory() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Encoding - (Delete)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_encoding_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_encoding_inventory to = (to_encoding_inventory) tbl_encoding_inventory_ALM.
                get(tbl_encoding_inventory.convertRowIndexToModel(row));
        if (to.status == 2) {
            Alert.set(0, "Cannot proceed, already deleted!");
            return;
        }
        if (to.status == 1 && !jButton6.isEnabled()) {
            Alert.set(0, "Cannot proceed, already finalized!");
            return;
        }
        if (to.status == 1 && jButton6.isEnabled()) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_delete.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Encoding_inventory.delete_encoding_inventory2(to);
                    data_cols();
                    clear_encoding_inventory();
                    Alert.set(3, "");
                    tf_item_code.grabFocus();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else {
            Encoding_inventory.delete_encoding_inventory(to);
            data_cols();
            clear_encoding_inventory();
            Alert.set(3, "");
            tf_item_code.grabFocus();
        }

    }

    private void prompt_sheet() {
        Window p = (Window) this;
        Dlg_sheet nd = Dlg_sheet.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_sheet.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_sheet.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {
        String search = tf_location.getText();
        String branch_id = tf_search_branch_code.getText();

        Object[][] obj = new Object[branch_location_list.size()][1];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch + " : " + to.location;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_qty_branch.getWidth()};
        int width = 0;
        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_qty_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_qty_branch.setText(to.branch);
                tf_search_branch_code.setText(to.branch_id);
                tf_location.setText("" + to.location);
                tf_location_id.setText("" + to.id);

                location_ids = "" + to.id;
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations2(final JTextField br, final JTextField lo) {

        Object[][] obj = new Object[branch_location_list2.size()][1];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list2) {
            obj[i][0] = " " + to.branch + " : " + to.location;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {br.getWidth()};
        int width = 0;
        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                Field.Combo b = (Field.Combo) br;
                Field.Combo l = (Field.Combo) lo;
                b.setText(to.branch);
                b.setId(to.branch_id);
                l.setText(to.location);
                l.setId("" + to.id);
            }
        });
    }

    private void choose_replenishment() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Replenishment - (View)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        Window p = (Window) this;
        Dlg_encoding_replenishment nd = Dlg_encoding_replenishment.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_encoding_replenishment.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_encoding_replenishment.OutputData data) {
                try {
                    closeDialog.ok();

                    tf_qty_branch.setText(data.branch);
                    tf_search_branch_code.setText(data.branch_id);
                    tf_location.setText(data.location);
                    tf_location_id.setText(data.location_id);

                    Field.Combo b = (Field.Combo) tf_qty_branch1;
                    Field.Combo l = (Field.Combo) tf_location1;
                    b.setText(data.branch);
                    b.setId(data.branch_id);
                    l.setText(data.location);
                    l.setId(data.location_id);

                    Date d = DateType.datetime.parse(data.date);
                    jDateChooser1.setDate(d);
                    jDateChooser2.setDate(d);
                    jDateChooser3.setDate(d);

                    data_cols();
                    tf_sheet_no.grabFocus();
                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_encode_inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void finalize_encoding() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Encoding - (Finalize)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to finalize this transaction?");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, final Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                jProgressBar1.setString("Loading... Please wait...");
                jProgressBar1.setIndeterminate(true);
                jProgressBar1.setStringPainted(true);
                final Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        List<to_encoding_inventory> datas = tbl_encoding_inventory_ALM;

                        if (datas.isEmpty()) {
                            Alert.set(0, "");
                            return;
                        }

                        S1_finalize_encoding.edit_encoding_inventory(datas, 0);
                        jProgressBar1.setString("Finished");
                        jProgressBar1.setIndeterminate(false);
                        Alert.set(2, "");
                        data_cols();

                    }
                });
                t2.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    //<editor-fold defaultstate="collapsed" desc=" encoding_inventory "> 
    public static ArrayListModel tbl_encoding_inventory_ALM2;
    public static Tblencoding_inventoryModel2 tbl_encoding_inventory_M2;

    public static void init_tbl_encoding_inventory2(JTable tbl_encoding_inventory) {
        tbl_encoding_inventory_ALM2 = new ArrayListModel();
        tbl_encoding_inventory_M2 = new Tblencoding_inventoryModel2(tbl_encoding_inventory_ALM2);
        tbl_encoding_inventory.setModel(tbl_encoding_inventory_M2);
        tbl_encoding_inventory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_encoding_inventory.setRowHeight(25);
        int[] tbl_widths_encoding_inventory = {80, 60, 50, 80, 100, 180, 80, 80, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_encoding_inventory.length; i < n; i++) {
            if (i == 4) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_encoding_inventory, i, tbl_widths_encoding_inventory[i]);
        }
        Dimension d = tbl_encoding_inventory.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_encoding_inventory.getTableHeader().setPreferredSize(d);
        tbl_encoding_inventory.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_encoding_inventory.setRowHeight(25);
        tbl_encoding_inventory.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_encoding_inventory, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_encoding_inventory, 7);
    }

    public static void loadData_encoding_inventory2(List<to_encoding_inventory> acc) {
        tbl_encoding_inventory_ALM2.clear();
        tbl_encoding_inventory_ALM2.addAll(acc);
    }

    public static class Tblencoding_inventoryModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Sheet #", "Qty", "Item Code", "Description", "Location", "Price", "Amount", "Status", "date_added", "user_name", "screen_name", "sheet_no", "status", "counted_by", "checked_by", "cost", "selling_price", "user_id", "user_screen_name"
        };

        public Tblencoding_inventoryModel2(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
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
            to_encoding_inventory tt = (to_encoding_inventory) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime2(tt.date_added);
                case 1:
                    return " " + tt.sheet_no;
                case 2:
                    return " " + FitIn.fmt_wc_0(tt.qty);
                case 3:
                    return " " + tt.item_code;
                case 4:
                    return " " + tt.description;
                case 5:
                    return " " + tt.location + " - " + tt.branch;
                case 6:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.qty * tt.selling_price) + " ";
                case 8:
                    if (tt.status == 0) {
                        return " Posted";
                    }
                    if (tt.status == 1) {
                        return " Finalized";
                    }
                    if (tt.status == 2) {
                        return " Deleted";
                    }
                case 9:
                    return tt.date_added;
                case 10:
                    return tt.user_name;
                case 11:
                    return tt.screen_name;
                case 12:
                    return tt.sheet_no;
                case 13:
                    return tt.status;
                case 14:
                    return tt.counted_by;
                case 15:
                    return tt.checked_by;
                case 16:
                    return tt.cost;
                case 17:
                    return tt.selling_price;
                case 18:
                    return tt.user_id;
                default:
                    return tt.user_screen_name;
            }
        }
    }

    private void ret_replenishments() {
        String where = " where user_name like '%" + "" + "%' ";
        Field.Combo br = (Field.Combo) tf_qty_branch1;
        Field.Combo lo = (Field.Combo) tf_location1;
        String date_from = DateType.sf.format(jDateChooser2.getDate());
        String date_to = DateType.sf.format(jDateChooser3.getDate());

        if (jCheckBox4.isSelected()) {
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (!jCheckBox6.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and location_id='" + lo.getId() + "' ";
        }
        if (jCheckBox6.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and branch_id='" + br.getId() + "' ";
        }
        if (!jCheckBox10.isSelected()) {
            where = where + " and sheet_no='" + tf_search2.getText() + "' ";
        }
        int status = 0;
        if (jCheckBox8.isSelected()) {
            status = 0;
        }
        if (jCheckBox9.isSelected()) {
            status = 1;
        }
        if (jCheckBox28.isSelected()) {
            status = 2;
        }
        if (!jCheckBox7.isSelected()) {
            where = where + " and status='" + status + "' ";
        }
        if (jCheckBox24.isSelected()) {
            where = where + " and item_code='" + tf_search1.getText() + "' ";
        }
        if (jCheckBox25.isSelected()) {
            where = where + " and barcode='" + tf_search1.getText() + "' ";
        }
        if (jCheckBox26.isSelected()) {
            where = where + " and description like '%" + tf_search1.getText() + "%' ";
        }
        where = where + " order by description asc ";
        System.out.println(where);
        List<Encoding_inventory.to_encoding_inventory> datas = Encoding_inventory.ret_data_encoding2(where);
        loadData_encoding_inventory2(datas);
        jLabel20.setText("" + datas.size());
    }
//</editor-fold> 

}
