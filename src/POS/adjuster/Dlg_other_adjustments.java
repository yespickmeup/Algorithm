/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.adjuster.Other_adjustments.to_other_adjustments;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.category.S1_inventory_category;
import POS.category.S1_inventory_classification;
import POS.category.S1_inventory_model;
import POS.category.S1_inventory_sub_classification;
import POS.inventory.Inventory_barcodes;
import POS.inventory_reports.Dlg_report_inventory_ledger;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_other_adjustments extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_other_adjustments
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
    private Dlg_other_adjustments(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_other_adjustments(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_other_adjustments() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_other_adjustments myRef;

    private void setThisRef(Dlg_other_adjustments myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_other_adjustments> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_other_adjustments create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_other_adjustments create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_other_adjustments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_other_adjustments((java.awt.Frame) parent, false);
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
            Dlg_other_adjustments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_other_adjustments((java.awt.Dialog) parent, false);
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

        Dlg_other_adjustments dialog = Dlg_other_adjustments.create(new javax.swing.JFrame(), true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jTextField3 = new Field.Combo();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        tf_category = new Field.Combo();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        tf_classification = new Field.Combo();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        tf_sub_classification = new Field.Combo();
        tf_model = new Field.Combo();
        tf_brand = new Field.Combo();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jTextField1 = new Field.Search();
        jButton1 = new Button.Success();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory_barcodes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new Field.Combo();
        jTextField5 = new Field.Combo();
        jLabel36 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_other_adjustments = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new Button.Success();
        jCheckBox24 = new javax.swing.JCheckBox();
        jButton3 = new Button.Info();
        jCheckBox25 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Branch:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");
        jCheckBox1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Location:");

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

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");
        jCheckBox2.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Category:");

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("All");

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

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Classification:");

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("All");

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

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Sub-Classification:");

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setSelected(true);
        jCheckBox12.setText("All");

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

        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setSelected(true);
        jCheckBox13.setText("All");

        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setSelected(true);
        jCheckBox14.setText("All");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Brand:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Search by:");

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        buttonGroup1.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("[F2]-Item Code");
        jCheckBox7.setFocusable(false);

        buttonGroup1.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Barcode");
        jCheckBox8.setFocusable(false);

        buttonGroup1.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setSelected(true);
        jCheckBox9.setText("[F4]-Description");
        jCheckBox9.setFocusable(false);

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

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbl_inventory_barcodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_inventory_barcodes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventory_barcodesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_inventory_barcodes);

        jLabel3.setText("Total Items:");

        jLabel4.setText("0");

        jLabel6.setText("Status:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGap(109, 109, 109)
                                            .addComponent(jCheckBox13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_sub_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox10)
                                    .addGap(3, 3, 3)
                                    .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 268, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox9))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2))))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tf_sub_classification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox9))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Other Adjustments", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Branch:");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");
        jCheckBox3.setFocusable(false);

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");
        jCheckBox4.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Location:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setFocusable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Date from:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");
        jCheckBox5.setFocusable(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("to:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Type:");

        buttonGroup4.add(jCheckBox15);
        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("Damage");
        jCheckBox15.setFocusable(false);

        buttonGroup4.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox16.setText("Leftover");
        jCheckBox16.setFocusable(false);

        buttonGroup4.add(jCheckBox17);
        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setText("Voucher");
        jCheckBox17.setFocusable(false);

        buttonGroup4.add(jCheckBox18);
        jCheckBox18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox18.setText("Short");
        jCheckBox18.setFocusable(false);

        buttonGroup4.add(jCheckBox19);
        jCheckBox19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox19.setText("Over");
        jCheckBox19.setFocusable(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Status:");

        buttonGroup3.add(jCheckBox20);
        jCheckBox20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox20.setText("All");
        jCheckBox20.setFocusable(false);

        buttonGroup3.add(jCheckBox21);
        jCheckBox21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox21.setSelected(true);
        jCheckBox21.setText("Posted");
        jCheckBox21.setFocusable(false);

        buttonGroup3.add(jCheckBox22);
        jCheckBox22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox22.setText("Finalized");
        jCheckBox22.setFocusable(false);

        buttonGroup3.add(jCheckBox23);
        jCheckBox23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox23.setText("Deleted");
        jCheckBox23.setFocusable(false);

        tbl_other_adjustments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_other_adjustments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_other_adjustmentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_other_adjustments);

        jLabel8.setText("Total no. of rows:");

        jLabel9.setText("0");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup4.add(jCheckBox24);
        jCheckBox24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox24.setSelected(true);
        jCheckBox24.setText("All");
        jCheckBox24.setFocusable(false);

        jButton3.setText("Print Preview");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup4.add(jCheckBox25);
        jCheckBox25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox25.setText("Pull Out");
        jCheckBox25.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox4)
                                            .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jCheckBox5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel37)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 180, Short.MAX_VALUE))
                                            .addComponent(jTextField4)
                                            .addComponent(jTextField5)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jCheckBox24)
                                        .addGap(6, 6, 6)
                                        .addComponent(jCheckBox15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox25, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jCheckBox20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox23)))))
                        .addGap(0, 357, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox5))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox15)
                                .addComponent(jCheckBox16)
                                .addComponent(jCheckBox17)
                                .addComponent(jCheckBox18)
                                .addComponent(jCheckBox19)
                                .addComponent(jCheckBox24)
                                .addComponent(jCheckBox25)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox20)
                            .addComponent(jCheckBox21)
                            .addComponent(jCheckBox22)
                            .addComponent(jCheckBox23)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Report", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Status:");

        jProgressBar2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(775, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ledger", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations2(jTextField2, jTextField3);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations2(jTextField2, jTextField3);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        //        init_branch_locations();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void tf_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_categoryMouseClicked
        init_categories();
    }//GEN-LAST:event_tf_categoryMouseClicked

    private void tf_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoryActionPerformed
        init_categories();
    }//GEN-LAST:event_tf_categoryActionPerformed

    private void tf_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_classificationMouseClicked
        init_classification();
    }//GEN-LAST:event_tf_classificationMouseClicked

    private void tf_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_classificationActionPerformed
        init_classification();
    }//GEN-LAST:event_tf_classificationActionPerformed

    private void tf_sub_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_sub_classificationMouseClicked
        init_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationMouseClicked

    private void tf_sub_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sub_classificationActionPerformed
        init_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationActionPerformed

    private void tf_modelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_modelMouseClicked
        init_model();
    }//GEN-LAST:event_tf_modelMouseClicked

    private void tf_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_modelActionPerformed
        init_model();
    }//GEN-LAST:event_tf_modelActionPerformed

    private void tf_brandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_brandMouseClicked
        init_brand();
    }//GEN-LAST:event_tf_brandMouseClicked

    private void tf_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_brandActionPerformed
        init_brand();
    }//GEN-LAST:event_tf_brandActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_inventory_barcodesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory_barcodesMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_inventory_barcodesMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_branch_locations2(jTextField5, jTextField4);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_branch_locations2(jTextField5, jTextField4);
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ret_other_adjustments();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_other_adjustmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_other_adjustmentsMouseClicked
        select_other_adjustment();
    }//GEN-LAST:event_tbl_other_adjustmentsMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        rpt_adjustments();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tbl_inventory_barcodes;
    private javax.swing.JTable tbl_other_adjustments;
    private javax.swing.JTextField tf_brand;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_classification;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_sub_classification;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

//        System.setProperty("pool_db", "db_smis_cebu_chickaloka");
//        System.setProperty("delete_other_adjustments_finalized", "true");
        init_key();
        set_default_branch();
        init_tbl_inventory_barcodes(tbl_inventory_barcodes);
        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);
        init_tbl_other_adjustments(tbl_other_adjustments);
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
        Field.Combo br = (Field.Combo) jTextField2;
        Field.Combo lo = (Field.Combo) jTextField3;
        br.setText(to.branch);
        br.setId(to.branch_id);
        lo.setText(to.location);
        lo.setId("" + to.id);

        Field.Combo br2 = (Field.Combo) jTextField5;
        Field.Combo lo2 = (Field.Combo) jTextField4;
        br2.setText(to.branch);
        br2.setId(to.branch_id);
        lo2.setText(to.location);
        lo2.setId("" + to.id);

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

    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations2(JTextField b, JTextField l) {

        final Field.Combo br = (Field.Combo) b;
        final Field.Combo lo = (Field.Combo) l;
        Object[][] obj = new Object[branch_location_list2.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list2) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {90, 120};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list2.get(data.selected_row);

                br.setText("" + to.branch);
                br.setId("" + to.branch_id);

                lo.setText("" + to.location);
                lo.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_category.to_inventory_category> categories = new ArrayList();

    private void init_categories() {
        if (!jCheckBox10.isSelected()) {
            String where = " where name like '%" + tf_category.getText() + "%' order by name asc";
            categories.clear();
            categories = S1_inventory_category.ret_data2(where);
            Object[][] obj = new Object[categories.size()][1];
            int i = 0;
            for (S1_inventory_category.to_inventory_category to : categories) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_category.getWidth()};
            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_category, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo category = (Field.Combo) tf_category;
                    S1_inventory_category.to_inventory_category to = (S1_inventory_category.to_inventory_category) categories.get(data.selected_row);
                    category.setId("" + to.id);
                    category.setText("" + to.name.toUpperCase());

                }
            });
        }

    }
    List<S1_inventory_classification.to_inventory_classification> classification_list = new ArrayList();

    private void init_classification() {
        if (!jCheckBox11.isSelected()) {
            Field.Combo category = (Field.Combo) tf_category;
            String where = " where name like '%" + tf_classification.getText() + "%' and category_code='" + category.getId() + "' order by name asc";
            if (jCheckBox10.isSelected()) {
                where = " where name like '%" + tf_classification.getText() + "%'  order by name asc";
            }
            classification_list.clear();
            classification_list = S1_inventory_classification.ret_data2(where);
            Object[][] obj = new Object[classification_list.size()][1];
            int i = 0;
            for (S1_inventory_classification.to_inventory_classification to : classification_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_classification.getWidth()};

            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_classification, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo classification = (Field.Combo) tf_classification;
                    S1_inventory_classification.to_inventory_classification to = classification_list.get(data.selected_row);
                    classification.setText(to.name.toUpperCase());
                    classification.setId("" + to.id);

                }
            });
        }
    }

    List<S1_inventory_sub_classification.to_inventory_sub_classification> sub_classification_list = new ArrayList();

    private void init_sub_classification() {
        if (!jCheckBox12.isSelected()) {
            Field.Combo classification = (Field.Combo) tf_classification;
            String where = " where name like '%" + tf_sub_classification.getText() + "%' and classification_code='" + classification.getId() + "' order by name asc";
            if (jCheckBox11.isSelected()) {
                where = " where name like '%" + tf_sub_classification.getText() + "%'  order by name asc";
            }

            sub_classification_list.clear();
            sub_classification_list = S1_inventory_sub_classification.ret_data2(where);
            Object[][] obj = new Object[sub_classification_list.size()][1];
            int i = 0;
            for (S1_inventory_sub_classification.to_inventory_sub_classification to : sub_classification_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_sub_classification.getWidth()};
            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_sub_classification, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo sub_classification = (Field.Combo) tf_sub_classification;
                    S1_inventory_sub_classification.to_inventory_sub_classification to = sub_classification_list.get(data.selected_row);
                    sub_classification.setText(to.name.toUpperCase());
                    sub_classification.setId("" + to.id);

                }
            });
        }

    }
    List<POS.category.S1_inventory_brand.to_inventory_brand> brand_list = new ArrayList();

    private void init_brand() {
        if (!jCheckBox14.isSelected()) {
            String where = " where name like '%" + tf_brand.getText() + "%' order by name asc";
            brand_list.clear();
            brand_list = POS.category.S1_inventory_brand.ret_data2(where);
            Object[][] obj = new Object[brand_list.size()][1];
            int i = 0;
            for (POS.category.S1_inventory_brand.to_inventory_brand to : brand_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_category.getWidth()};

            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_brand, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo brand = (Field.Combo) tf_brand;
                    POS.category.S1_inventory_brand.to_inventory_brand to = brand_list.get(data.selected_row);
                    brand.setText(to.name.toUpperCase());
                    brand.setId("" + to.id);

                }
            });
        }

    }

    List<S1_inventory_model.to_inventory_model> model_list = new ArrayList();

    private void init_model() {
        if (!jCheckBox13.isSelected()) {
            Field.Combo brand = (Field.Combo) tf_brand;

            String where = " where name like '%" + tf_model.getText() + "%' and brand_code= '" + brand.getId() + "'order by name asc";
            if (jCheckBox14.isSelected()) {
                where = " where name like '%" + tf_model.getText() + "%' order by name asc";
            }

            model_list.clear();
            model_list = S1_inventory_model.ret_data2(where);
            Object[][] obj = new Object[model_list.size()][1];
            int i = 0;
            for (S1_inventory_model.to_inventory_model to : model_list) {
                obj[i][0] = " " + to.name.toUpperCase();
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {tf_model.getWidth()};
            int width = 0;
            String[] col_names = {"Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_model, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo model = (Field.Combo) tf_model;
                    S1_inventory_model.to_inventory_model to = model_list.get(data.selected_row);
                    model.setText(to.name.toUpperCase());
                    model.setId("" + to.id);

                }
            });
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" inventory_barcodes "> 
    public static ArrayListModel tbl_inventory_barcodes_ALM;
    public static Tblinventory_barcodesModel tbl_inventory_barcodes_M;

    public static void init_tbl_inventory_barcodes(JTable tbl_inventory_barcodes) {
        tbl_inventory_barcodes_ALM = new ArrayListModel();
        tbl_inventory_barcodes_M = new Tblinventory_barcodesModel(tbl_inventory_barcodes_ALM);
        tbl_inventory_barcodes.setModel(tbl_inventory_barcodes_M);
        tbl_inventory_barcodes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_barcodes.setRowHeight(25);
        int[] tbl_widths_inventory_barcodes = {40, 60, 150, 100, 120, 140, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_barcodes.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inventory_barcodes, i, tbl_widths_inventory_barcodes[i]);
        }
        Dimension d = tbl_inventory_barcodes.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_inventory_barcodes.getTableHeader().setPreferredSize(d);
        tbl_inventory_barcodes.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_inventory_barcodes.setRowHeight(25);
        tbl_inventory_barcodes.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_inventory_barcodes, 6);
    }

    public static void loadData_inventory_barcodes(List<Inventory_barcodes.to_inventory_barcodes> acc) {
        tbl_inventory_barcodes_ALM.clear();
        tbl_inventory_barcodes_ALM.addAll(acc);
    }

    public static class Tblinventory_barcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Code", "Barcode", "Description", "Branch", "Location", "Price", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "main_barcode", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id", "serial_no"
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
            Inventory_barcodes.to_inventory_barcodes tt = (Inventory_barcodes.to_inventory_barcodes) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.barcode;
                case 3:
                    return " " + tt.description;
                case 4:
                    return " " + tt.branch;
                case 5:
                    return " " + tt.location;
                case 6:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
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
                case 33:
                    return tt.branch_code;
                case 34:
                    return tt.location;
                case 35:
                    return tt.location_id;
                default:
                    return tt.serial_no;
            }
        }
    }
//</editor-fold> 

    private void data_cols() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        jTextField1.setEnabled(false);
        jButton1.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                Field.Combo br = (Field.Combo) jTextField2;
                Field.Combo lo = (Field.Combo) jTextField3;

                String where = " where category like '%" + "" + "%' ";
                if (jCheckBox6.isSelected()) {
                    where = where + "   ";
                }
                if (jCheckBox7.isSelected()) {
                    where = where + "  "
                            + " and main_barcode='" + jTextField1.getText() + "'  "
                            + "  ";
                }
                if (jCheckBox8.isSelected()) {
                    where = where + " and  barcode like '" + jTextField1.getText() + "'   ";
                }
                if (jCheckBox9.isSelected()) {
                    where = where + " and description like '%" + jTextField1.getText() + "%'  ";
                }

                if (!jCheckBox1.isSelected() && !jCheckBox2.isSelected()) {
                    where = where + " and location_id='" + lo.getId() + "' ";
                }
                if (!jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
                    where = where + " and branch_code='" + br.getId() + "' ";
                }

                String category = "All";
                String classification = "All";
                String sub_classification = "All";
                String brand = "All";
                String model = "All";
                if (!jCheckBox10.isSelected()) {
                    Field.Combo cat = (Field.Combo) tf_category;
                    where = where + " and category_id ='" + cat.getId() + "' ";
                    category = cat.getText();
                }
                if (!jCheckBox11.isSelected()) {
                    Field.Combo clas = (Field.Combo) tf_classification;
                    where = where + " and classification_id ='" + clas.getId() + "' ";
                    classification = clas.getText();
                }
                if (!jCheckBox12.isSelected()) {
                    Field.Combo sub_clas = (Field.Combo) tf_sub_classification;
                    where = where + " and sub_class_id ='" + sub_clas.getId() + "' ";
                    sub_classification = sub_clas.getText();
                }

                if (!jCheckBox14.isSelected()) {
                    Field.Combo bra = (Field.Combo) tf_brand;
                    where = where + " and brand_id ='" + bra.getId() + "' ";
                    brand = bra.getText();
                }
                if (!jCheckBox13.isSelected()) {
                    Field.Combo mod = (Field.Combo) tf_model;
                    where = where + " and model_id ='" + mod.getId() + "' ";
                    model = mod.getText();
                }

                where = where + " order by description asc ";
//                System.out.println(where);
                List<Inventory_barcodes.to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);
                loadData_inventory_barcodes(datas);

                jLabel4.setText("" + datas.size());
                jTextField1.setEnabled(true);
                jButton1.setEnabled(true);
                jTextField1.grabFocus();

                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void select_item() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Other Adjustments - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_inventory_barcodes.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_inventory_barcodes.getSelectedColumn();
        final Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_inventory_barcodes_ALM.get(row);

        Window p = (Window) this;
        Dlg_other_adjustment_qty nd = Dlg_other_adjustment_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.branch, to.location, to.main_barcode, to.description, 0, 1, new Date(), to.product_qty);
        nd.setCallback(new Dlg_other_adjustment_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_other_adjustment_qty.OutputData data) {
                closeDialog.ok();

                int id = 0;
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                String date_added = DateType.now();
                String adjustment_date = data.date;
                int adjustment_type = data.type;
                String remarks = data.remarks;
                int status = 0;
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
                double conversion = to.conversion;
                String unit = to.unit;
                String barcodes = "";
                String main_barcode = to.main_barcode;
                double previous_qty = to.product_qty;
                double qty = data.qty;
                double cost = to.cost;
                double selling_price = to.selling_price;
                String branch = to.branch;
                String branch_id = to.branch_code;
                String location = to.location;
                String location_id = to.location_id;

                Other_adjustments.to_other_adjustments adjustment = new Other_adjustments.to_other_adjustments(id, user_id, user_screen_name, date_added, adjustment_date, adjustment_type, remarks, status, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, main_barcode, previous_qty, qty, cost, selling_price, branch, branch_id, location, location_id);

                Other_adjustments.add_data(adjustment);
                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" other_adjustments "> 
    public static ArrayListModel tbl_other_adjustments_ALM;
    public static Tblother_adjustmentsModel tbl_other_adjustments_M;

    public static void init_tbl_other_adjustments(JTable tbl_other_adjustments) {
        tbl_other_adjustments_ALM = new ArrayListModel();
        tbl_other_adjustments_M = new Tblother_adjustmentsModel(tbl_other_adjustments_ALM);
        tbl_other_adjustments.setModel(tbl_other_adjustments_M);
        tbl_other_adjustments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_other_adjustments.setRowHeight(25);
        int[] tbl_widths_other_adjustments = {70, 70, 100, 40, 180, 120, 100, 50, 70, 70, 70, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_other_adjustments.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_other_adjustments, i, tbl_widths_other_adjustments[i]);
        }
        Dimension d = tbl_other_adjustments.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_other_adjustments.getTableHeader().setPreferredSize(d);
        tbl_other_adjustments.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_other_adjustments.setRowHeight(25);
        tbl_other_adjustments.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_other_adjustments, 8);
        TableWidthUtilities.setColumnRightRenderer(tbl_other_adjustments, 9);
        tbl_other_adjustments.getColumnModel().getColumn(11).setCellRenderer(new ImageRenderer());
        tbl_other_adjustments.getColumnModel().getColumn(12).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_other_adjustments(List<to_other_adjustments> acc) {
        tbl_other_adjustments_ALM.clear();
        tbl_other_adjustments_ALM.addAll(acc);
    }

    public static class Tblother_adjustmentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Item Code", "Description", "Unit", "Location", "User", "Type", "Qty", "Price", "Amount", "Status", "", "", "sub_class", "sub_class_id", "brand", "brand_id", "model", "model_id", "conversion", "unit", "barcodes", "main_barcode", "previous_qty", "qty", "cost", "selling_price", "branch", "branch_id", "location", "location_id"
        };

        public Tblother_adjustmentsModel(ListModel listmodel) {
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
            to_other_adjustments tt = (to_other_adjustments) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.adjustment_date);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    String uom = tt.unit;
                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }
                    return " " + unit;
                case 4:
                    return " " + tt.location + " - " + tt.branch;
                case 5:
                    return " " + tt.user_screen_name;
                case 6:
                    switch (tt.adjustment_type) {
                        case 0:
                            return " Damage";
                        case 1:
                            return " Leftover";
                        case 2:
                            return " Voucher";
                        case 3:
                            return " Short";
                        case 4:
                            return " Over";
                        default:
                            return " Pull Out";
                    }
                case 7:
                    return " " + FitIn.fmt_woc_0(tt.qty);
                case 8:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 9:
                    return FitIn.fmt_wc_0(tt.qty * tt.selling_price) + " ";
                case 10:
                    switch (tt.status) {
                        case 0:
                            return " Posted";
                        case 1:
                            return " Finalized";
                        default:
                            return " Deleted";
                    }
                case 11:
                    return "/POS/icon_payment/edit (1).png";
                case 12:
                    return "/POS/icon_payment/remove11.png";
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
                    return tt.main_barcode;
                case 23:
                    return tt.previous_qty;
                case 24:
                    return tt.qty;
                case 25:
                    return tt.cost;
                case 26:
                    return tt.selling_price;
                case 27:
                    return tt.branch;
                case 28:
                    return tt.branch_id;
                case 29:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_other_adjustments() {
        String where = " where user_screen_name like '%" + "" + "%' ";
        Field.Combo br = (Field.Combo) jTextField5;
        Field.Combo lo = (Field.Combo) jTextField4;
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        int type = 0;
        if (jCheckBox15.isSelected()) {
            type = 0;
        }
        if (jCheckBox16.isSelected()) {
            type = 1;
        }
        if (jCheckBox17.isSelected()) {
            type = 2;
        }
        if (jCheckBox18.isSelected()) {
            type = 3;
        }
        if (jCheckBox19.isSelected()) {
            type = 4;
        }

        if (jCheckBox25.isSelected()) {
            type = 5;
        }

        int status = 0;
        if (jCheckBox21.isSelected()) {
            status = 0;
        }
        if (jCheckBox22.isSelected()) {
            status = 1;
        }
        if (jCheckBox23.isSelected()) {
            status = 2;
        }

        if (!jCheckBox3.isSelected() && !jCheckBox4.isSelected()) {
            where = where + " and location_id='" + lo.getId() + "' ";
        }
        if (!jCheckBox3.isSelected() && jCheckBox4.isSelected()) {
            where = where + " and branch_id='" + br.getId() + "' ";
        }
        if (!jCheckBox5.isSelected()) {
            where = where + " and Date(adjustment_date) between '" + date_from + "' and '" + date_to + "' ";
        }

        if (!jCheckBox24.isSelected()) {
            where = where + " and adjustment_type='" + type + "' ";
        }
        if (!jCheckBox20.isSelected()) {
            where = where + " and status='" + status + "' ";
        }
        where = where + " order by id desc ";
        System.out.println(where);
        List<to_other_adjustments> datas = Other_adjustments.ret_data(where);
        loadData_other_adjustments(datas);
        jLabel9.setText("" + datas.size());
    }

    private void select_other_adjustment() {
        int row = tbl_other_adjustments.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_other_adjustments to = (to_other_adjustments) tbl_other_adjustments_ALM.get(row);
        int col = tbl_other_adjustments.getSelectedColumn();
        if (col == 10) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Other Adjustments - (Finalize)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 1) {
                Alert.set(0, "Cannot proceed, Transaction already finalized!");
                return;
            }
            if (to.status == 2) {
                Alert.set(0, "Cannot proceed, Transaction deleted!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Are you sure you want to finalize this adjustment?");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Other_adjustments.finalize_data(to);
                    Alert.set(2, "");
                    ret_other_adjustments();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 11) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Other Adjustments - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 1) {
                Alert.set(0, "Cannot proceed, Transaction already finalized!");
                return;
            }
            if (to.status == 2) {
                Alert.set(0, "Cannot proceed, Transaction deleted!");
                return;
            }
            Window p = (Window) this;
            Dlg_other_adjustment_qty nd = Dlg_other_adjustment_qty.create(p, true);
            nd.setTitle("");
            try {
                Date d = DateType.datetime.parse(to.adjustment_date);
                nd.do_pass(to.branch, to.location, to.main_barcode, to.description, to.adjustment_type, to.qty, d, to.previous_qty);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_other_adjustments.class.getName()).log(Level.SEVERE, null, ex);
            }

            nd.setCallback(new Dlg_other_adjustment_qty.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_other_adjustment_qty.OutputData data) {
                    closeDialog.ok();

                    int id = to.id;
                    String user_id = MyUser.getUser_id();
                    String user_screen_name = MyUser.getUser_screen_name();
                    String date_added = DateType.now();
                    String adjustment_date = data.date;
                    int adjustment_type = data.type;
                    String remarks = data.remarks;
                    int status = 0;
                    String barcode = to.barcode;
                    String description = to.description;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_class = to.sub_class;
                    String sub_class_id = to.sub_class_id;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    double conversion = to.conversion;
                    String unit = to.unit;
                    String barcodes = "";
                    String main_barcode = to.main_barcode;
                    double previous_qty = to.previous_qty;
                    double qty = data.qty;
                    double cost = to.cost;
                    double selling_price = to.selling_price;
                    String branch = to.branch;
                    String branch_id = to.brand_id;
                    String location = to.location;
                    String location_id = to.location_id;

                    Other_adjustments.to_other_adjustments adjustment = new Other_adjustments.to_other_adjustments(id, user_id, user_screen_name, date_added, adjustment_date, adjustment_type, remarks, status, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, main_barcode, previous_qty, qty, cost, selling_price, branch, branch_id, location, location_id);

                    Other_adjustments.update_data(adjustment);
                    Alert.set(2, "");
                    ret_other_adjustments();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 12) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Other Adjustments - (Delete)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 2) {
                Alert.set(0, "Cannot proceed, Transaction deleted!");
                return;
            }
            if (to.status == 1) {
                String delete_other_adjustments_finalized = System.getProperty("delete_other_adjustments_finalized", "false");
                if (delete_other_adjustments_finalized.equalsIgnoreCase("false")) {
                    Alert.set(0, "Cannot proceed, Transaction already finalized!");
                    return;
                }
            }
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Other_adjustments.delete_data(to);
                    Alert.set(3, "");
                    ret_other_adjustments();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" adjustments report ">
    private void rpt_adjustments() {

        jTabbedPane1.setSelectedIndex(2);
        jProgressBar2.setString("Loading... Please wait...");
        jProgressBar2.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override

            public void run() {

                Field.Combo br = (Field.Combo) jTextField4;
                Field.Combo lo = (Field.Combo) jTextField5;

                List<Srpt_other_adjustments.field> fields = new ArrayList();
                List<to_other_adjustments> items = tbl_other_adjustments_ALM;
                for (to_other_adjustments item : items) {
                    String item_code = item.main_barcode;
                    String description = item.description;
                    String uom = item.unit;

                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }

                    double qty = item.qty;
                    double previous_qty = item.previous_qty;
                    double price = item.selling_price;
                    double amount = item.qty * item.selling_price;
                    String adjustment_type = "Damage";
                    if (item.adjustment_type == 1) {
                        adjustment_type = "Leftover";
                    }
                    if (item.adjustment_type == 2) {
                        adjustment_type = "Voucher";
                    }

                    if (item.adjustment_type == 3) {
                        adjustment_type = "Short";
                    }
                    if (item.adjustment_type == 4) {
                        adjustment_type = "Over";
                    }
                    String status = "Posted";
                    if (item.status == 1) {
                        status = "Finalized";
                    }
                    if (item.status == 2) {
                        status = "Deleted";
                    }

                    String adjustment_date = DateType.convert_slash_datetime(item.adjustment_date);
                    String branch = item.branch;
                    String location = item.location;
                    String location_id = item.location_id;
                    Srpt_other_adjustments.field field = new Srpt_other_adjustments.field(item_code, description, unit, qty, previous_qty, price, amount, adjustment_type, status, adjustment_date, branch, location, location_id);
                    fields.add(field);
                }

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");

                String date = POS.util.DateType.slash.format(jDateChooser1.getDate()) + " - " + POS.util.DateType.slash.format(jDateChooser2.getDate());
                if (jCheckBox5.isSelected()) {
                    date = "All";
                }
                String branch = jTextField4.getText();
                if (jCheckBox3.isSelected()) {
                    branch = "All";
                }
                String location = jTextField5.getText();
                if (jCheckBox4.isSelected()) {
                    location = "All";
                }

                Srpt_other_adjustments rpt = new Srpt_other_adjustments(business_name, address, date, branch, location);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_other_adjustments.jrxml";
                report_adjustments(rpt, jrxml);
                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_adjustments(final Srpt_other_adjustments to, String jrxml_name) {
        jPanel5.removeAll();
        jPanel5.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_adjustments(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel5.add(viewer);
            jPanel5.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_adjustments(Srpt_other_adjustments to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_adjustments(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_adjustments(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_other_adjustments.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

}
