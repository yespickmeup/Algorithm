/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.conversion;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.conversion.Conversion_items.to_conversion_items;
import POS.conversion.Conversions.to_conversions;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.inventory_reports.Dlg_report_inventory_ledger;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_conversion extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_conversion
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
    private Dlg_conversion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_conversion(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_conversion() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_conversion myRef;

    private void setThisRef(Dlg_conversion myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_conversion> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_conversion create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_conversion create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_conversion dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_conversion((java.awt.Frame) parent, false);
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
            Dlg_conversion dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_conversion((java.awt.Dialog) parent, false);
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

        Dlg_conversion dialog = Dlg_conversion.create(new javax.swing.JFrame(), true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jButton1 = new Button.Primary();
        jButton3 = new Button.Info();
        jButton6 = new Button.Success();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        tf_search = new Field.Search();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_conversion_items = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_from_branch = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        tf_from_location = new Field.Combo();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jTextField3 = new Field.Search();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_conversion_items22 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_to_branch = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        tf_to_location = new Field.Combo();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        tf_from_branch1 = new Field.Combo();
        tf_from_location1 = new Field.Combo();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        tf_from_branch2 = new Field.Combo();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tf_from_location2 = new Field.Combo();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jButton9 = new Button.Default();
        jTextField2 = new Field.Search();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setDoubleBuffered(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Transaction No.:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Remarks:");

        jButton2.setText("New Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Post");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Update Post");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Finalize");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Converted From", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search by:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Item Code");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Barcode");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Description");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        tbl_conversion_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_conversion_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_conversion_itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_conversion_items);

        jLabel4.setText("Total Items:");

        jLabel5.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Branch:");

        tf_from_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Location:");

        tf_from_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location.setFocusable(false);
        tf_from_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_locationActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_from_location)
                                    .addComponent(tf_from_branch)))
                            .addComponent(tf_search))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Converted To", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Search by:");

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Item Code");

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Barcode");

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Description");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        tbl_conversion_items22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_conversion_items22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_conversion_items22MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_conversion_items22);

        jLabel9.setText("Total Items:");

        jLabel10.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Branch:");

        tf_to_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_to_branchMouseClicked(evt);
            }
        });
        tf_to_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_branchActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Location:");

        tf_to_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location.setFocusable(false);
        tf_to_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_locationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox6)
                        .addGap(111, 111, 111))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_to_location)
                                    .addComponent(tf_to_branch)))
                            .addComponent(jTextField3))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_to_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_to_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField1))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Conversion", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jLabel13.setText("Total Transactions:");

        jLabel14.setText("0");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Converted from:");

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setSelected(true);
        jCheckBox8.setText("All");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Branch:");

        tf_from_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch1MouseClicked(evt);
            }
        });
        tf_from_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch1ActionPerformed(evt);
            }
        });

        tf_from_location1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location1.setFocusable(false);
        tf_from_location1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_location1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Location:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Converted to:");

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setSelected(true);
        jCheckBox9.setText("All");

        tf_from_branch2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch2MouseClicked(evt);
            }
        });
        tf_from_branch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Branch:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Location:");

        tf_from_location2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location2.setFocusable(false);
        tf_from_location2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_location2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Status:");

        buttonGroup3.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setText("All");

        buttonGroup3.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("Posted");

        buttonGroup3.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("Finalized");

        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Search:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox8))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(30, 30, 30)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jCheckBox10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jCheckBox11)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jCheckBox12))
                                                    .addComponent(tf_from_location1)
                                                    .addComponent(tf_from_branch1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tf_from_location2)
                                                    .addComponent(tf_from_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_from_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_from_location1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_from_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_from_location2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox10)
                                .addComponent(jCheckBox11)
                                .addComponent(jCheckBox12)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 961, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 961, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Item Ledger", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clear_conversion();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        post_conversion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update_conversion();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        finalize_conversion();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_from_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_locationActionPerformed

    }//GEN-LAST:event_tf_from_locationActionPerformed

    private void tf_to_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_branchMouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_to_branchMouseClicked

    private void tf_to_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_branchActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_to_branchActionPerformed

    private void tf_to_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_to_locationActionPerformed

    private void tf_from_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch1MouseClicked
        init_branch_locations3(tf_from_branch1, tf_from_location1);
    }//GEN-LAST:event_tf_from_branch1MouseClicked

    private void tf_from_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch1ActionPerformed
        init_branch_locations3(tf_from_branch1, tf_from_location1);
    }//GEN-LAST:event_tf_from_branch1ActionPerformed

    private void tf_from_location1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_location1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_location1ActionPerformed

    private void tf_from_branch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch2MouseClicked
        init_branch_locations3(tf_from_branch2, tf_from_location2);
    }//GEN-LAST:event_tf_from_branch2MouseClicked

    private void tf_from_branch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch2ActionPerformed
        init_branch_locations3(tf_from_branch2, tf_from_location2);
    }//GEN-LAST:event_tf_from_branch2ActionPerformed

    private void tf_from_location2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_location2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_location2ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_inventory_barcodes2();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void tbl_conversion_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_conversion_itemsMouseClicked
        delete_qty_converted_from();
    }//GEN-LAST:event_tbl_conversion_itemsMouseClicked

    private void tbl_conversion_items22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_conversion_items22MouseClicked
        delete_qty_converted_to();
    }//GEN-LAST:event_tbl_conversion_items22MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ret_conversions();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        select_conversion();
    }//GEN-LAST:event_jTable3MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_conversion_items;
    private javax.swing.JTable tbl_conversion_items22;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch1;
    private javax.swing.JTextField tf_from_branch2;
    private javax.swing.JTextField tf_from_location;
    private javax.swing.JTextField tf_from_location1;
    private javax.swing.JTextField tf_from_location2;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_to_branch;
    private javax.swing.JTextField tf_to_location;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
        init_key();
        set_default_branch();
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        branch_location_list2 = branch_location_list;
        branch_location_list3 = branch_location_list;
        init_tbl_conversions(jTable3);
        init_tbl_conversion_items(tbl_conversion_items);
        init_tbl_conversion_items2(tbl_conversion_items22);

        String conversion_no = Conversions.increment_id();
        jTextField1.setText(conversion_no);

        item_ledger();
    }

    private void item_ledger() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                jPanel7.setLayout(new BorderLayout());
                Dlg_report_inventory_ledger dlg = new Dlg_report_inventory_ledger();
                jPanel7.add(dlg.getSurface());
            }
        });

    }

    private void set_default_branch() {

        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        Field.Combo branch = (Field.Combo) tf_from_branch;
        branch.setText(to.branch);
        branch.setId("" + to.branch_id);

        Field.Combo branch2 = (Field.Combo) tf_to_branch;
        branch2.setText(to.branch);
        branch2.setId("" + to.branch_id);

        Field.Combo location = (Field.Combo) tf_from_location;
        location.setText("" + to.location);
        location.setId("" + to.id);

        Field.Combo location2 = (Field.Combo) tf_to_location;
        location2.setText("" + to.location);
        location2.setId("" + to.id);

        Field.Combo branch3 = (Field.Combo) tf_from_branch1;
        branch3.setText(to.branch);
        branch3.setId("" + to.branch_id);

        Field.Combo branch4 = (Field.Combo) tf_from_branch2;
        branch4.setText(to.branch);
        branch4.setId("" + to.branch_id);

        Field.Combo location3 = (Field.Combo) tf_from_location1;
        location3.setText("" + to.location);
        location3.setId("" + to.id);

        Field.Combo location4 = (Field.Combo) tf_from_location2;
        location4.setText("" + to.location);
        location4.setId("" + to.id);

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

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();
    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations() {
        if (!tf_from_location.isEnabled()) {
            return;
        }
        Field.Combo prev_location = (Field.Combo) tf_from_location;
        final String prev = prev_location.getId();
        if (!tf_from_branch.isEnabled()) {
            return;
        }

        Object[][] obj = new Object[branch_location_list.size()][1];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch + " - [ " + to.location + " ]";//TextHighlighter1.highlight2(to.barcode, to.barcode, "");

            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_from_branch.getWidth()};

        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_from_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {

                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);

                Field.Combo branch = (Field.Combo) tf_from_branch;
                branch.setText(to.branch);
                branch.setId("" + to.branch_id);

                Field.Combo location = (Field.Combo) tf_from_location;
                location.setText("" + to.location);
                location.setId("" + to.id);

                if (!prev.equals(location.getId())) {
                    tbl_conversion_items_ALM.clear();
                    tbl_conversion_items_M.fireTableDataChanged();
                    jLabel5.setText("0");
                }
            }
        });
    }

    private void init_branch_locations2() {
        if (!tf_to_branch.isEnabled()) {
            return;
        }
        Field.Combo prev_location = (Field.Combo) tf_to_location;
        final String prev = prev_location.getId();
        if (!tf_to_branch.isEnabled()) {
            return;
        }

        Object[][] obj = new Object[branch_location_list2.size()][1];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list2) {
            obj[i][0] = " " + to.branch + " - [ " + to.location + " ]";//TextHighlighter1.highlight2(to.barcode, to.barcode, "");

            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_to_branch.getWidth()};

        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_to_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {

                S1_branch_locations.to_branch_locations to = branch_location_list2.
                        get(data.selected_row);

                Field.Combo branch = (Field.Combo) tf_to_branch;
                branch.setText(to.branch);
                branch.setId("" + to.branch_id);

                Field.Combo location = (Field.Combo) tf_to_location;
                location.setText("" + to.location);
                location.setId("" + to.id);

                if (!prev.equals(location.getId())) {
                    tbl_conversion_items_ALM2.clear();
                    tbl_conversion_items_M2.fireTableDataChanged();
                    jLabel10.setText("0");
                }
            }
        });
    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();
    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list2 = new ArrayList();

    private void init_inventory_barcodes() {
        final Field.Combo br = (Field.Combo) tf_from_location;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " where ";

                if (jCheckBox1.isSelected()) {
                    where = where + " main_barcode like '" + search + "' and location_id='" + br.getId() + "' ";
                }
                if (jCheckBox2.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + br.getId() + "' ";
                }
                if (jCheckBox3.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + br.getId() + "' ";;
                }
                where = where + " order by description asc ";

                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);

                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item not found!");
                    tf_search.grabFocus();
                    return;
                }
                if (inventory_barcoders_list.size() == 1) {
                    Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(0);
                    add_qty_converted_from(to);
                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][5];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        String unit = "";
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                        if (uoms != null) {
                            unit = uoms.uom;
                        }
                        obj[i][3] = " " + unit;

                        obj[i][4] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = 700;
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 100, w, 30, 50};
                    String[] col_names = {"Qty", "ItemCode", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup2(tf_search, obj, labels, tbl_widths_customers, col_names, 700);

                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(data.selected_row);
                            add_qty_converted_from(to);
                        }
                    });
                }
            }
        });
        t.start();
    }

    private void add_qty_converted_from(final Inventory_barcodes.to_inventory_barcodes to) {
        Window p = (Window) this;
        Dlg_conversion_qty nd = Dlg_conversion_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.main_barcode, to.barcode, to.description, to.product_qty, 1, to.unit);
        nd.setCallback(new Dlg_conversion_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_conversion_qty.OutputData data) {
                closeDialog.ok();

                Field.Combo f_branch = (Field.Combo) tf_from_branch;
                Field.Combo f_location = (Field.Combo) tf_from_location;
                Field.Combo t_branch = (Field.Combo) tf_to_branch;
                Field.Combo t_location = (Field.Combo) tf_to_location;

                if (jButton1.isEnabled()) {
                    int id = 0;
                    String conversion_no = "";
                    String user_name = MyUser.getUser_id();
                    String session_no = "";
                    String date_added = DateType.now();
                    String reference_no = "";
                    String remarks = "";
                    String barcode = to.barcode;
                    String description = to.description;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_class = to.sub_classification;
                    String sub_class_id = to.sub_classification_id;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    double conversion = data.conversion;
                    String unit = data.unit;
                    String barcodes = "";
                    String batch_no = "";
                    String serial_no = data.serial_nos;
                    String main_barcode = to.main_barcode;
                    double qty = data.amount;
                    double cost = data.cost;
                    int status = 0;
                    String from_branch = f_branch.getText();
                    String from_branch_id = f_branch.getId();
                    String from_location = f_location.getText();
                    String from_location_id = f_location.getId();
                    String to_branch = t_branch.getText();
                    String to_branch_id = t_branch.getId();
                    String to_location = t_location.getText();
                    String to_location_id = t_location.getId();
                    int is_converted_from = 1;
                    to_conversion_items item = new to_conversion_items(id, conversion_no, user_name, session_no, date_added, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, is_converted_from);

                    tbl_conversion_items_ALM.add(item);
                    tf_search.grabFocus();
                } else {
                    int row = jTable3.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    final Conversions.to_conversions conv = (Conversions.to_conversions) tbl_conversions_ALM.get(row);
                    if (conv.status == 1) {
                        Alert.set(0, "Cannot proceed, transaction already finalized!");
                        return;
                    }
                    int id = 0;
                    String conversion_no = conv.conversion_no;
                    String user_name = MyUser.getUser_id();
                    String session_no = "";
                    String date_added = DateType.now();
                    String reference_no = "";
                    String remarks = jTextArea1.getText();
                    String barcode = to.barcode;
                    String description = to.description;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_class = to.sub_classification;
                    String sub_class_id = to.sub_classification_id;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    double conversion = data.conversion;
                    String unit = data.unit;
                    String barcodes = "";
                    String batch_no = "";
                    String serial_no = data.serial_nos;
                    String main_barcode = to.main_barcode;
                    double qty = data.amount;
                    double cost = data.cost;
                    int status = 0;
                    String from_branch = f_branch.getText();
                    String from_branch_id = f_branch.getId();
                    String from_location = f_location.getText();
                    String from_location_id = f_location.getId();
                    String to_branch = t_branch.getText();
                    String to_branch_id = t_branch.getId();
                    String to_location = t_location.getText();
                    String to_location_id = t_location.getId();
                    int is_converted_from = 1;
                    to_conversion_items item = new to_conversion_items(id, conversion_no, user_name, session_no, date_added, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, is_converted_from);
                    Conversion_items.add_data(item);
                    String where = " where conversion_no='" + jTextField1.getText() + "' and is_converted_from=1 ";
                    List<to_conversion_items> from_items = Conversion_items.ret_data(where);
                    loadData_conversion_items(from_items);
                    jLabel5.setText("" + from_items.size());
                    Alert.set(1, "");
                }

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void delete_qty_converted_from() {
        int row = tbl_conversion_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_conversion_items to = (to_conversion_items) tbl_conversion_items_ALM.get(row);
        int col = tbl_conversion_items.getSelectedColumn();
        if (col == 6) {

            if (to.id == 0) {
                tbl_conversion_items_ALM.remove(row);
                tbl_conversion_items_M.fireTableDataChanged();
                tf_search.grabFocus();
                jLabel5.setText("" + tbl_conversion_items_ALM.size());
            } else {
                if (to.status == 1) {
                    Alert.set(0, "Cannot proceed, transaction already finalized!");
                    return;
                }
                Window p = (Window) this;
                Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
                nd.setTitle("");

                nd.setCallback(new Dlg_confirm_action.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                        closeDialog.ok();
                        Conversion_items.delete_data(to);
                        String where = " where conversion_no='" + to.conversion_no + "' and is_converted_from=1 ";
                        List<to_conversion_items> from_items = Conversion_items.ret_data(where);
                        loadData_conversion_items(from_items);
                        jLabel5.setText("" + from_items.size());
                        Alert.set(3, "");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
        if (col == 5) {
            if (to.id == 0) {
                Window p = (Window) this;
                Dlg_conversion_qty nd = Dlg_conversion_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.main_barcode, to.barcode, to.description, 0, to.qty, to.unit);
                nd.setCallback(new Dlg_conversion_qty.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_conversion_qty.OutputData data) {
                        closeDialog.ok();
                        to.setConversion(data.conversion);
                        to.setCost(data.cost);
                        to.setQty(data.amount);
                        to.setUnit(data.unit);
                        tbl_conversion_items_M.fireTableDataChanged();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);

            } else {
                if (to.status == 1) {
                    Alert.set(0, "Cannot proceed, transaction already finalized!");
                    return;
                }
                Window p = (Window) this;
                Dlg_conversion_qty nd = Dlg_conversion_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.main_barcode, to.barcode, to.description, 0, to.qty, to.unit);
                nd.setCallback(new Dlg_conversion_qty.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_conversion_qty.OutputData data) {
                        closeDialog.ok();
                        Conversion_items.update_unit(to, data.conversion, data.unit, data.amount, data.cost);
                        String where = " where conversion_no='" + to.conversion_no + "' and is_converted_from=1 ";
                        List<to_conversion_items> from_items = Conversion_items.ret_data(where);
                        loadData_conversion_items(from_items);
                        jLabel5.setText("" + from_items.size());
                        Alert.set(2, "");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

        }
    }

    private void init_inventory_barcodes2() {
        final Field.Combo br = (Field.Combo) tf_to_location;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = jTextField3.getText();
                String where = " where ";

                if (jCheckBox4.isSelected()) {
                    where = where + " main_barcode like '" + search + "' and location_id='" + br.getId() + "' ";
                }
                if (jCheckBox5.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + br.getId() + "' ";
                }
                if (jCheckBox6.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + br.getId() + "' ";;
                }
                where = where + " order by description asc ";

                inventory_barcoders_list2.clear();
                inventory_barcoders_list2 = Inventory_barcodes.ret_where(where);

                if (inventory_barcoders_list2.isEmpty()) {
                    Alert.set(0, "Item not found!");
                    return;
                }
                if (inventory_barcoders_list2.size() == 1) {
                    Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list2.get(0);
                    add_qty_converted_to(to);
                }
                if (inventory_barcoders_list2.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list2.size()][5];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list2) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        String unit = "";
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                        if (uoms != null) {
                            unit = uoms.uom;
                        }
                        obj[i][3] = " " + unit;

                        obj[i][4] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = 700;
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 100, w, 30, 50};
                    String[] col_names = {"Qty", "ItemCode", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup2(jTextField3, obj, labels, tbl_widths_customers, col_names, 700);

                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list2.get(data.selected_row);
                            add_qty_converted_to(to);
                        }
                    });
                }
            }
        });
        t.start();
    }

    private void add_qty_converted_to(final Inventory_barcodes.to_inventory_barcodes to) {
        Window p = (Window) this;
        Dlg_conversion_qty nd = Dlg_conversion_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.main_barcode, to.barcode, to.description, to.product_qty, 1, to.unit);
        nd.setCallback(new Dlg_conversion_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_conversion_qty.OutputData data) {
                closeDialog.ok();

                Field.Combo f_branch = (Field.Combo) tf_from_branch;
                Field.Combo f_location = (Field.Combo) tf_from_location;
                Field.Combo t_branch = (Field.Combo) tf_to_branch;
                Field.Combo t_location = (Field.Combo) tf_to_location;

                if (jButton1.isEnabled()) {
                    int id = 0;
                    String conversion_no = "";
                    String user_name = MyUser.getUser_id();
                    String session_no = "";
                    String date_added = DateType.now();
                    String reference_no = "";
                    String remarks = "";
                    String barcode = to.barcode;
                    String description = to.description;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_class = to.sub_classification;
                    String sub_class_id = to.sub_classification_id;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    double conversion = data.conversion;
                    String unit = data.unit;
                    String barcodes = "";
                    String batch_no = "";
                    String serial_no = data.serial_nos;
                    String main_barcode = to.main_barcode;
                    double qty = data.amount;
                    double cost = data.cost;
                    int status = 0;
                    String from_branch = f_branch.getText();
                    String from_branch_id = f_branch.getId();
                    String from_location = f_location.getText();
                    String from_location_id = f_location.getId();
                    String to_branch = t_branch.getText();
                    String to_branch_id = t_branch.getId();
                    String to_location = t_location.getText();
                    String to_location_id = t_location.getId();
                    int is_converted_from = 0;
                    to_conversion_items item = new to_conversion_items(id, conversion_no, user_name, session_no, date_added, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, is_converted_from);

                    tbl_conversion_items_ALM2.add(item);
                    jTextField3.grabFocus();
                } else {
                    int row = jTable3.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    final Conversions.to_conversions conv = (Conversions.to_conversions) tbl_conversions_ALM.get(row);
                    if (conv.status == 1) {
                        Alert.set(0, "Cannot proceed, transaction already finalized!");
                        return;
                    }
                    int id = 0;
                    String conversion_no = conv.conversion_no;
                    String user_name = MyUser.getUser_id();
                    String session_no = "";
                    String date_added = DateType.now();
                    String reference_no = "";
                    String remarks = jTextArea1.getText();
                    String barcode = to.barcode;
                    String description = to.description;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_class = to.sub_classification;
                    String sub_class_id = to.sub_classification_id;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    double conversion = data.conversion;
                    String unit = data.unit;
                    String barcodes = "";
                    String batch_no = "";
                    String serial_no = data.serial_nos;
                    String main_barcode = to.main_barcode;
                    double qty = data.amount;
                    double cost = data.cost;
                    int status = 0;
                    String from_branch = f_branch.getText();
                    String from_branch_id = f_branch.getId();
                    String from_location = f_location.getText();
                    String from_location_id = f_location.getId();
                    String to_branch = t_branch.getText();
                    String to_branch_id = t_branch.getId();
                    String to_location = t_location.getText();
                    String to_location_id = t_location.getId();
                    int is_converted_from = 0;
                    to_conversion_items item = new to_conversion_items(id, conversion_no, user_name, session_no, date_added, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, is_converted_from);
                    Conversion_items.add_data(item);
                    String where = " where conversion_no='" + jTextField1.getText() + "' and is_converted_from=0 ";
                    List<to_conversion_items> from_items = Conversion_items.ret_data(where);
                    loadData_conversion_items2(from_items);
                    jLabel10.setText("" + from_items.size());
                    Alert.set(1, "");
                }

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void delete_qty_converted_to() {
        int row = tbl_conversion_items22.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_conversion_items22.getSelectedColumn();
        final to_conversion_items to = (to_conversion_items) tbl_conversion_items_ALM2.get(row);
        if (col == 6) {

            if (to.id == 0) {
                tbl_conversion_items_ALM2.remove(row);
                tbl_conversion_items_M2.fireTableDataChanged();
                jTextField3.grabFocus();
                jLabel10.setText("" + tbl_conversion_items_ALM.size());
            } else {
                if (to.status == 1) {
                    Alert.set(0, "Cannot proceed, transaction already finalized!");
                    return;
                }
                Window p = (Window) this;
                Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
                nd.setTitle("");

                nd.setCallback(new Dlg_confirm_action.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                        closeDialog.ok();
                        Conversion_items.delete_data(to);
                        String where = " where conversion_no='" + to.conversion_no + "' and is_converted_from=0 ";
                        List<to_conversion_items> from_items = Conversion_items.ret_data(where);
                        loadData_conversion_items2(from_items);
                        jLabel10.setText("" + from_items.size());
                        Alert.set(3, "");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

        }
        if (col == 5) {

            if (to.id == 0) {
                Window p = (Window) this;
                Dlg_conversion_qty nd = Dlg_conversion_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.main_barcode, to.barcode, to.description, 0, to.qty, to.unit);
                nd.setCallback(new Dlg_conversion_qty.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_conversion_qty.OutputData data) {
                        closeDialog.ok();
                        to.setConversion(data.conversion);
                        to.setCost(data.cost);
                        to.setQty(data.amount);
                        to.setUnit(data.unit);
                        tbl_conversion_items_M2.fireTableDataChanged();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);

            } else {
                if (to.status == 1) {
                    Alert.set(0, "Cannot proceed, transaction already finalized!");
                    return;
                }
                Window p = (Window) this;
                Dlg_conversion_qty nd = Dlg_conversion_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.main_barcode, to.barcode, to.description, 0, to.qty, to.unit);
                nd.setCallback(new Dlg_conversion_qty.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_conversion_qty.OutputData data) {
                        closeDialog.ok();
                        Conversion_items.update_unit(to, data.conversion, data.unit, data.amount, data.cost);
                        String where = " where conversion_no='" + to.conversion_no + "' and is_converted_from=0 ";
                        List<to_conversion_items> from_items = Conversion_items.ret_data(where);
                        loadData_conversion_items2(from_items);
                        jLabel10.setText("" + from_items.size());
                        Alert.set(2, "");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }

    }

    //<editor-fold defaultstate="collapsed" desc=" conversion_items "> 
    public static ArrayListModel tbl_conversion_items_ALM;
    public static Tblconversion_itemsModel tbl_conversion_items_M;

    public static void init_tbl_conversion_items(JTable tbl_conversion_items) {
        tbl_conversion_items_ALM = new ArrayListModel();
        tbl_conversion_items_M = new Tblconversion_itemsModel(tbl_conversion_items_ALM);
        tbl_conversion_items.setModel(tbl_conversion_items_M);
        tbl_conversion_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_conversion_items.setRowHeight(25);
        int[] tbl_widths_conversion_items = {40, 40, 100, 60, 80, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_conversion_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_conversion_items, i, tbl_widths_conversion_items[i]);
        }
        Dimension d = tbl_conversion_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_conversion_items.getTableHeader().setPreferredSize(d);
        tbl_conversion_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_conversion_items.setRowHeight(25);
        tbl_conversion_items.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_conversion_items.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        tbl_conversion_items.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_conversion_items(List<to_conversion_items> acc) {
        tbl_conversion_items_ALM.clear();
        tbl_conversion_items_ALM.addAll(acc);
    }

    public static class Tblconversion_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Code", "Description", "Unit", "Conversion", "", "", "barcode", "description", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "brand", "brand_id", "model", "model_id", "conversion", "unit", "barcodes", "batch_no", "serial_no", "main_barcode", "qty", "cost", "status", "from_branch", "from_branch_id", "from_location", "from_location_id", "to_branch", "to_branch_id", "to_location", "to_location_id"
        };

        public Tblconversion_itemsModel(ListModel listmodel) {
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
            to_conversion_items tt = (to_conversion_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.conversion);
                case 5:
                    return "/POS/icon_payment/edit (1).png";
                case 6:
                    return "/POS/icon_payment/remove11.png";
                case 7:
                    return tt.barcode;
                case 8:
                    return tt.description;
                case 9:
                    return tt.category;
                case 10:
                    return tt.category_id;
                case 11:
                    return tt.classification;
                case 12:
                    return tt.classification_id;
                case 13:
                    return tt.sub_class;
                case 14:
                    return tt.sub_class_id;
                case 15:
                    return tt.brand;
                case 16:
                    return tt.brand_id;
                case 17:
                    return tt.model;
                case 18:
                    return tt.model_id;
                case 19:
                    return tt.conversion;
                case 20:
                    return tt.unit;
                case 21:
                    return tt.barcodes;
                case 22:
                    return tt.batch_no;
                case 23:
                    return tt.serial_no;
                case 24:
                    return tt.main_barcode;
                case 25:
                    return tt.qty;
                case 26:
                    return tt.cost;
                case 27:
                    return tt.status;
                case 28:
                    return tt.from_branch;
                case 29:
                    return tt.from_branch_id;
                case 30:
                    return tt.from_location;
                case 31:
                    return tt.from_location_id;
                case 32:
                    return tt.to_branch;
                case 33:
                    return tt.to_branch_id;
                case 34:
                    return tt.to_location;
                default:
                    return tt.to_location_id;
            }
        }
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" conversion_items2 "> 
    public static ArrayListModel tbl_conversion_items_ALM2;
    public static Tblconversion_itemsModel2 tbl_conversion_items_M2;

    public static void init_tbl_conversion_items2(JTable tbl_conversion_items2) {
        tbl_conversion_items_ALM2 = new ArrayListModel();
        tbl_conversion_items_M2 = new Tblconversion_itemsModel2(tbl_conversion_items_ALM2);
        tbl_conversion_items2.setModel(tbl_conversion_items_M2);
        tbl_conversion_items2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_conversion_items2.setRowHeight(25);
        int[] tbl_widths_conversion_items = {40, 40, 100, 60, 80, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_conversion_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_conversion_items2, i, tbl_widths_conversion_items[i]);
        }
        Dimension d = tbl_conversion_items2.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_conversion_items2.getTableHeader().setPreferredSize(d);
        tbl_conversion_items2.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_conversion_items2.setRowHeight(25);
        tbl_conversion_items2.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_conversion_items2.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        tbl_conversion_items2.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_conversion_items2(List<to_conversion_items> acc) {
        tbl_conversion_items_ALM2.clear();
        tbl_conversion_items_ALM2.addAll(acc);
    }

    public static class Tblconversion_itemsModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Code", "Description", "Unit", "Conversion", "", "", "barcode", "description", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "brand", "brand_id", "model", "model_id", "conversion", "unit", "barcodes", "batch_no", "serial_no", "main_barcode", "qty", "cost", "status", "from_branch", "from_branch_id", "from_location", "from_location_id", "to_branch", "to_branch_id", "to_location", "to_location_id"
        };

        public Tblconversion_itemsModel2(ListModel listmodel) {
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
            to_conversion_items tt = (to_conversion_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.conversion);
                case 5:
                    return "/POS/icon_payment/edit (1).png";
                case 6:
                    return "/POS/icon_payment/remove11.png";
                case 7:
                    return tt.barcode;
                case 8:
                    return tt.description;
                case 9:
                    return tt.category;
                case 10:
                    return tt.category_id;
                case 11:
                    return tt.classification;
                case 12:
                    return tt.classification_id;
                case 13:
                    return tt.sub_class;
                case 14:
                    return tt.sub_class_id;
                case 15:
                    return tt.brand;
                case 16:
                    return tt.brand_id;
                case 17:
                    return tt.model;
                case 18:
                    return tt.model_id;
                case 19:
                    return tt.conversion;
                case 20:
                    return tt.unit;
                case 21:
                    return tt.barcodes;
                case 22:
                    return tt.batch_no;
                case 23:
                    return tt.serial_no;
                case 24:
                    return tt.main_barcode;
                case 25:
                    return tt.qty;
                case 26:
                    return tt.cost;
                case 27:
                    return tt.status;
                case 28:
                    return tt.from_branch;
                case 29:
                    return tt.from_branch_id;
                case 30:
                    return tt.from_location;
                case 31:
                    return tt.from_location_id;
                case 32:
                    return tt.to_branch;
                case 33:
                    return tt.to_branch_id;
                case 34:
                    return tt.to_location;
                default:
                    return tt.to_location_id;
            }
        }
    }
//</editor-fold> 

    private void post_conversion() {

        String conversion_no = Conversions.increment_id();
        String where = " where conversion_no='" + conversion_no + "' ";
        List<Conversions.to_conversions> conversion_list = Conversions.ret_data(where);
        if (!conversion_list.isEmpty()) {
            Alert.set(0, "Transaction no. already exists");
            jTextArea1.grabFocus();
            return;

        }
        Field.Combo f_branch = (Field.Combo) tf_from_branch;
        Field.Combo f_location = (Field.Combo) tf_from_location;
        Field.Combo t_branch = (Field.Combo) tf_to_branch;
        Field.Combo t_location = (Field.Combo) tf_to_location;

        int id = 0;

        String user_name = MyUser.getUser_id();
        String session_no = "";
        String date_added = DateType.now();
        String reference_no = "";
        String remarks = jTextArea1.getText();
        int status = 0;
        String from_branch = f_branch.getText();
        String from_branch_id = f_branch.getId();
        String from_location = f_location.getText();
        String from_location_id = f_location.getId();
        String to_branch = t_branch.getText();
        String to_branch_id = t_branch.getId();
        String to_location = t_location.getText();
        String to_location_id = t_location.getId();
        final Conversions.to_conversions conversions = new Conversions.to_conversions(id, conversion_no, user_name, session_no, date_added, reference_no, remarks, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id);

        final List<to_conversion_items> all_items = new ArrayList();
        List<to_conversion_items> from_items = tbl_conversion_items_ALM;
        List<to_conversion_items> to_items = tbl_conversion_items_ALM2;

        all_items.addAll(from_items);
        all_items.addAll(to_items);
        if (from_items.isEmpty()) {
            Alert.set(0, "Select item/s to be converted");
            tf_search.grabFocus();
            return;
        }
        if (to_items.isEmpty()) {
            Alert.set(0, "Select item/s to be converted");
            jTextField3.grabFocus();
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Conversions.add_data(conversions, all_items);
                ret_conversions();
                Alert.set(1, "");
                clear_conversion();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void clear_conversion() {
        tbl_conversion_items_ALM.clear();
        tbl_conversion_items_ALM2.clear();
        jLabel5.setText("0");
        jLabel10.setText("0");
        jTextArea1.setText("");
        String conversion_no = Conversions.increment_id();
        jTextField1.setText(conversion_no);
        jTextArea1.grabFocus();
        jButton1.setEnabled(true);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);

        tf_from_branch.setEnabled(true);
        tf_to_branch.setEnabled(true);
        tf_from_location.setEnabled(true);
        tf_to_location.setEnabled(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" conversions "> 
    public static ArrayListModel tbl_conversions_ALM;
    public static TblconversionsModel tbl_conversions_M;

    public static void init_tbl_conversions(JTable tbl_conversions) {
        tbl_conversions_ALM = new ArrayListModel();
        tbl_conversions_M = new TblconversionsModel(tbl_conversions_ALM);
        tbl_conversions.setModel(tbl_conversions_M);
        tbl_conversions.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_conversions.setRowHeight(25);
        int[] tbl_widths_conversions = {120, 80, 150, 150, 60, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_conversions.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_conversions, i, tbl_widths_conversions[i]);
        }
        Dimension d = tbl_conversions.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_conversions.getTableHeader().setPreferredSize(d);
        tbl_conversions.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_conversions.setRowHeight(25);
        tbl_conversions.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_conversions(List<to_conversions> acc) {
        tbl_conversions_ALM.clear();
        tbl_conversions_ALM.addAll(acc);
    }

    public static class TblconversionsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Date", "From", "To", "Status", "", "", "status", "from_branch", "from_branch_id", "from_location", "from_location_id", "to_branch", "to_branch_id", "to_location", "to_location_id"
        };

        public TblconversionsModel(ListModel listmodel) {
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
            to_conversions tt = (to_conversions) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.conversion_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.from_branch + " - " + tt.from_location;
                case 3:
                    return " " + tt.to_branch + " - " + tt.to_location;
                case 4:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }

                case 5:
                    return " Update";
                case 6:
                    return " Delete";
                case 7:
                    return tt.status;
                case 8:
                    return tt.from_branch;
                case 9:
                    return tt.from_branch_id;
                case 10:
                    return tt.from_location;
                case 11:
                    return tt.from_location_id;
                case 12:
                    return tt.to_branch;
                case 13:
                    return tt.to_branch_id;
                case 14:
                    return tt.to_location;
                default:
                    return tt.to_location_id;
            }
        }
    }
//</editor-fold> 

    private void ret_conversions() {
        String where = " where reference_no like '%" + "" + "%' ";

        Field.Combo location1 = (Field.Combo) tf_from_location1;
        Field.Combo location2 = (Field.Combo) tf_from_location2;
        if (!jCheckBox8.isSelected()) {
            where = where + " and from_location_id='" + location1.getId() + "' ";
        }
        if (!jCheckBox9.isSelected()) {
            where = where + " and to_location_id='" + location2.getId() + "' ";
        }
        if (jCheckBox11.isSelected()) {
            where = where + " and status=0 ";
        }
        if (jCheckBox12.isSelected()) {
            where = where + " and status=1 ";
        }
        where = where + " and conversion_no like '%" + jTextField2.getText() + "%' ";
        where = where + " order by id desc ";

        List<to_conversions> conversions = Conversions.ret_data(where);
        loadData_conversions(conversions);
        jLabel14.setText("" + conversions.size());
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list3 = new ArrayList();

    private void init_branch_locations3(final JTextField branch, final JTextField location) {

        Object[][] obj = new Object[branch_location_list3.size()][1];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list3) {
            obj[i][0] = " " + to.branch + " - [ " + to.location + " ]";//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {branch.getWidth()};

        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list3.get(data.selected_row);
                Field.Combo branch1 = (Field.Combo) branch;
                branch1.setText(to.branch);
                branch1.setId("" + to.branch_id);
                Field.Combo location1 = (Field.Combo) location;
                location1.setText("" + to.location);
                location1.setId("" + to.id);
            }
        });
    }

    private void select_conversion() {
        int row = jTable3.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_conversions conversion = (to_conversions) tbl_conversions_ALM.get(row);

        int col = jTable3.getSelectedColumn();
        if (col == 5) {
            //edit

            Field.Combo f_branch = (Field.Combo) tf_from_branch;
            Field.Combo f_location = (Field.Combo) tf_from_location;
            Field.Combo t_branch = (Field.Combo) tf_to_branch;
            Field.Combo t_location = (Field.Combo) tf_to_location;

            jTextField1.setText(conversion.conversion_no);
            jTextArea1.setText(conversion.remarks);

            f_branch.setText(conversion.from_branch);
            f_branch.setId(conversion.from_branch_id);
            f_location.setText(conversion.from_location);
            f_location.setId(conversion.from_location_id);

            t_branch.setText(conversion.to_branch);
            t_branch.setId(conversion.to_branch_id);
            t_location.setText(conversion.to_location);
            t_location.setId(conversion.to_location_id);

            String where = " where conversion_no='" + conversion.conversion_no + "' and is_converted_from=1 ";
            String where2 = " where conversion_no='" + conversion.conversion_no + "' and is_converted_from=0 ";
            List<to_conversion_items> from_items = Conversion_items.ret_data(where);
            List<to_conversion_items> to_items = Conversion_items.ret_data(where2);

            loadData_conversion_items(from_items);
            jLabel5.setText("" + from_items.size());
            loadData_conversion_items2(to_items);
            jLabel10.setText("" + to_items.size());

            jTabbedPane1.setSelectedIndex(0);
            jButton1.setEnabled(false);
            jButton3.setEnabled(true);
            jButton6.setEnabled(true);

            tf_from_branch.setEnabled(false);
            tf_to_branch.setEnabled(false);
            tf_from_location.setEnabled(false);
            tf_to_location.setEnabled(false);
        }
        if (col == 6) {
            if (conversion.status == 1) {
                Alert.set(0, "Cannot proceed, transaction already finalized!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Conversions.delete_data(conversion);
                    ret_conversions();
                    clear_conversion();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    private void update_conversion() {
        int row = jTable3.getSelectedRow();
        if (row < 0) {
            return;
        }

        final to_conversions conversion = (to_conversions) tbl_conversions_ALM.get(row);
        if (conversion.status == 1) {
            Alert.set(0, "Cannot proceed, transaction already finalized!");
            return;
        }

        Conversions.update_conversion(conversion, jTextArea1.getText());
        ret_conversions();
        Alert.set(2, "");
        jTable3.setRowSelectionInterval(row, row);
    }

    private void finalize_conversion() {
        final int row = jTable3.getSelectedRow();
        if (row < 0) {
            return;
        }

        final to_conversions conversion = (to_conversions) tbl_conversions_ALM.get(row);
        if (conversion.status == 1) {
            Alert.set(0, "Cannot proceed, transaction already finalized!");
            return;
        }

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();

                List<to_conversion_items> from_items = tbl_conversion_items_ALM;
                List<to_conversion_items> to_items = tbl_conversion_items_ALM2;
                Conversions.finalize(conversion, from_items, to_items);
                ret_conversions();
                Alert.set(0, "Transaction successfully finalized!");
                clear_conversion();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
