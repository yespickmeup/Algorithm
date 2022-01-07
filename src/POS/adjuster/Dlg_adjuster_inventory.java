/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.adjuster.S1_adjustments.to_adjustments;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.Branches;
import POS.category.S1_inventory_category;
import POS.category.S1_inventory_classification;
import POS.category.S1_inventory_model;
import POS.category.S1_inventory_sub_classification;
import POS.inventory.Inventory_barcodes;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
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

/**
 *
 * @author Guinness
 */
public class Dlg_adjuster_inventory extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_adjuster_inventory
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
    private Dlg_adjuster_inventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_adjuster_inventory(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_adjuster_inventory() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_adjuster_inventory myRef;

    private void setThisRef(Dlg_adjuster_inventory myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_adjuster_inventory> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_adjuster_inventory create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_adjuster_inventory create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_adjuster_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_adjuster_inventory((java.awt.Frame) parent, false);
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
            Dlg_adjuster_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_adjuster_inventory((java.awt.Dialog) parent, false);
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

        Dlg_adjuster_inventory dialog = Dlg_adjuster_inventory.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new Button.Default();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new Field.Combo();
        jTextField5 = new Field.Combo();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton3 = new Button.Default();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_adjustments = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton4 = new Button.Default();
        jLabel20 = new javax.swing.JLabel();
        jTextField6 = new Field.Combo();
        jTextField7 = new Field.Combo();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jButton5 = new Button.Default();
        jLabel18 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory_barcodes = new javax.swing.JTable();
        jTextField1 = new Field.Search();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new Button.Success();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        tf_category = new Field.Combo();
        tf_classification = new Field.Combo();
        jCheckBox11 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        tf_brand = new Field.Combo();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        tf_sub_classification = new Field.Combo();
        tf_model = new Field.Combo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date From:");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("to:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Branch:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setFocusable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Location:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");
        jCheckBox4.setFocusable(false);

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");
        jCheckBox5.setFocusable(false);

        jButton3.setText("Print Preview");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(jTextField4)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addGap(1, 1, 1)
                                .addComponent(jCheckBox5)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jCheckBox3))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_adjustments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_adjustments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_adjustmentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_adjustments);

        jLabel10.setText("Total no. of rows:");

        jLabel11.setText("0");

        jLabel12.setText("Status:");

        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(13, 13, 13)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12))
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", jPanel3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setText("State:");

        jProgressBar3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(679, Short.MAX_VALUE)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel6);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Branch:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setFocusable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Location:");

        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox16.setText("All");
        jCheckBox16.setEnabled(false);
        jCheckBox16.setFocusable(false);

        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setText("All");
        jCheckBox17.setEnabled(false);
        jCheckBox17.setFocusable(false);

        jButton5.setText("Adjust All Errors");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel18.setText("Status:");

        jProgressBar4.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar4.setString("");
        jProgressBar4.setStringPainted(true);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(jTextField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jCheckBox16)
                            .addGap(1, 1, 1)
                            .addComponent(jCheckBox17))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check for Errors", jPanel9);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Branch:");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Location:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Items:");

        jLabel4.setText("0");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel6.setText("Status:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");
        jCheckBox1.setFocusable(false);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");
        jCheckBox2.setFocusable(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Search by:");

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        buttonGroup1.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("[F2]-Item Code");
        jCheckBox7.setFocusable(false);

        buttonGroup1.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Barcode");
        jCheckBox8.setFocusable(false);

        buttonGroup1.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("[F4]-Description");
        jCheckBox9.setFocusable(false);

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

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("All");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Classification:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Brand:");

        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setSelected(true);
        jCheckBox14.setText("All");

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

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Model:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Sub-Classification:");

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setSelected(true);
        jCheckBox12.setText("All");

        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setSelected(true);
        jCheckBox13.setText("All");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 76, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tf_sub_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox10)
                                    .addGap(3, 3, 3)
                                    .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tf_sub_classification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox9))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Adjuster", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_inventory_barcodesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory_barcodesMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_inventory_barcodesMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations2(jTextField2, jTextField3);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
//        init_branch_locations();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_adjustmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_adjustmentsMouseClicked
        select_transaction();
    }//GEN-LAST:event_tbl_adjustmentsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        data_cols_adjustments();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations2(jTextField2, jTextField3);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        init_branch_locations2(jTextField4, jTextField5);
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_branch_locations2(jTextField4, jTextField5);
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        rpt_adjustments();
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void tf_brandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_brandMouseClicked
        init_brand();
    }//GEN-LAST:event_tf_brandMouseClicked

    private void tf_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_brandActionPerformed
        init_brand();
    }//GEN-LAST:event_tf_brandActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ret_errors();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        init_branch_locations2(jTextField6, jTextField7);
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        init_branch_locations2(jTextField6, jTextField7);
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        init_branch_locations2(jTextField6, jTextField7);
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        adjust_all_errors();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox2;
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable tbl_adjustments;
    private javax.swing.JTable tbl_inventory_barcodes;
    private javax.swing.JTextField tf_brand;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_classification;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_sub_classification;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("pool_db", "db_algorithm");
//                System.setProperty("pool_password", "password");
        init_key();
        set_default_branch();
        init_tbl_inventory_barcodes(tbl_inventory_barcodes);
        init_tbl_adjustments(tbl_adjustments);

        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);
        jTextField1.grabFocus();
    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        Field.Combo br = (Field.Combo) jTextField2;
        Field.Combo lo = (Field.Combo) jTextField3;
        br.setText(to.branch);
        br.setId(to.branch_id);
        lo.setText(to.location);
        lo.setId("" + to.id);

        Field.Combo br2 = (Field.Combo) jTextField4;
        Field.Combo lo2 = (Field.Combo) jTextField5;
        br2.setText(to.branch);
        br2.setId(to.branch_id);
        lo2.setText(to.location);
        lo2.setId("" + to.id);

        Field.Combo br3 = (Field.Combo) jTextField6;
        Field.Combo lo3 = (Field.Combo) jTextField7;
        br3.setText(to.branch);
        br3.setId(to.branch_id);
        lo3.setText(to.location);
        lo3.setId("" + to.id);
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
        final Field.Combo lo = (Field.Combo) jTextField3;
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

            }
        });
    }

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
        jTextField1.addKeyListener(new KeyAdapter() {

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
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    jCheckBox9.setSelected(true);
                }
            }
        });
    }
    // </editor-fold>

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
        jTextField1.setEnabled(false);
        jButton1.setEnabled(false);
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

        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);

    }

    private void select_item() {
        int row = tbl_inventory_barcodes.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_inventory_barcodes.getSelectedColumn();
        final Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_inventory_barcodes_ALM.get(row);
        if (col == 0) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Adjuster - (Add)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            String reference_no = Adjuster.increment_id();
            Window p = (Window) this;
            Dlg_adjuster_qty nd = Dlg_adjuster_qty.create(p, true);
            nd.setTitle("");
            nd.do_pass2(reference_no);
            nd.setCallback(new Dlg_adjuster_qty.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_adjuster_qty.OutputData data) {
                    closeDialog.ok();
                    Adjuster.update_data(to, data.qty, data.is_add, data.remarks, data.date);
                    data_cols();
                    data_cols_adjustments();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

        if (col == 6) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Adjuster - (Delete)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Adjuster.delete_data(to);
                    data_cols();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

        if (col == 2) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Adjuster - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            Window p = (Window) this;
            Dlg_adjuster_input_barcode nd = Dlg_adjuster_input_barcode.create(p, true);
            nd.setTitle("");
            nd.do_pass(to.barcode);
            nd.setCallback(new Dlg_adjuster_input_barcode.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_adjuster_input_barcode.OutputData data) {
                    closeDialog.ok();
                    Adjuster.update_barcode(to.main_barcode, to.barcode, data.barcode);
                    data_cols();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 3) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Inventory Adjuster - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            Window p = (Window) this;
            Dlg_adjuster_description nd = Dlg_adjuster_description.create(p, true);
            nd.setTitle("");
            nd.do_pass(to.description);
            nd.setCallback(new Dlg_adjuster_description.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_adjuster_description.OutputData data) {
                    closeDialog.ok();
                    Adjuster.update_description(to.main_barcode, data.qty);
                    data_cols();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" adjustments "> 
    public static ArrayListModel tbl_adjustments_ALM;
    public static TbladjustmentsModel tbl_adjustments_M;

    public static void init_tbl_adjustments(JTable tbl_adjustments) {
        tbl_adjustments_ALM = new ArrayListModel();
        tbl_adjustments_M = new TbladjustmentsModel(tbl_adjustments_ALM);
        tbl_adjustments.setModel(tbl_adjustments_M);
        tbl_adjustments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_adjustments.setRowHeight(25);
        int[] tbl_widths_adjustments = {40, 80, 80, 70, 0, 100, 170, 100, 100, 50, 70, 80, 90, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_adjustments.length; i < n; i++) {
            if (i == 5) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_adjustments, i, tbl_widths_adjustments[i]);
        }
        Dimension d = tbl_adjustments.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_adjustments.getTableHeader().setPreferredSize(d);
        tbl_adjustments.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_adjustments.setRowHeight(25);
        tbl_adjustments.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_adjustments(List<to_adjustments> acc) {
        tbl_adjustments_ALM.clear();
        tbl_adjustments_ALM.addAll(acc);
    }

    public static class TbladjustmentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "No.", "Date", "User", "Item Code", "Barcode", "Description", "Reason", "Branch", "Location", "Type", "Previous", "Adjustment", "New Qty", "location", "location_id", "remarks", "transaction_no"
        };

        public TbladjustmentsModel(ListModel listmodel) {
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
            to_adjustments tt = (to_adjustments) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.id;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.user_screen_name;
                case 3:
                    return " " + tt.item_code;
                case 4:
                    return " " + tt.barcode;
                case 5:
                    return " " + tt.description;

                case 6:
                    return " " + tt.remarks;
                case 7:
                    return " " + tt.branch;
                case 8:
                    return " " + tt.location;
                case 9:
                    if (tt.is_add == 1) {
                        return " Add";
                    } else {
                        return " Deduct";
                    }
                case 10:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 11:
                    return " " + FitIn.fmt_woc(tt.new_qty);
                case 12:
                    if (tt.is_add == 1) {
                        return " " + FitIn.fmt_woc(tt.new_qty + tt.qty);
                    } else {
                        return " " + FitIn.fmt_woc(tt.qty - tt.new_qty);
                    }
                case 13:
                    return tt.location;
                case 14:
                    return tt.location_id;
                case 15:
                    return tt.remarks;
                default:
                    return tt.transaction_no;
            }
        }
    }

    private void data_cols_adjustments() {

        jButton2.setEnabled(false);
        Field.Combo br = (Field.Combo) jTextField4;
        Field.Combo lo = (Field.Combo) jTextField5;

        String date_from = synsoftech.util.DateType.sf.format(jDateChooser1.getDate());
        String date_to = synsoftech.util.DateType.sf.format(jDateChooser2.getDate());
        String where = " where description like '%" + "" + "%' ";
        if (!jCheckBox3.isSelected()) {
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }

        if (!jCheckBox4.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and location_id='" + lo.getId() + "' ";
        }
        if (!jCheckBox4.isSelected() && jCheckBox5.isSelected()) {
            where = where + " and branch_id='" + br.getId() + "' ";
        }

        where = where + " order by id desc ";
//                System.out.println(where);
        List<to_adjustments> datas = S1_adjustments.ret_data(where);
        loadData_adjustments(datas);
        jLabel11.setText("" + datas.size());
        jButton2.setEnabled(true);

    }
//</editor-fold> 

    private void select_transaction() {
        int row = tbl_adjustments.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_adjustments to = (to_adjustments) tbl_adjustments_ALM.get(row);

        Window p = (Window) this;
        Dlg_adjustment_details nd = Dlg_adjustment_details.create(p, true);
        nd.setTitle("");
        nd.do_pass(to);
        nd.setCallback(new Dlg_adjustment_details.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_adjustment_details.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" adjustments report ">
    private void rpt_adjustments() {

        jTabbedPane1.setSelectedIndex(2);
        jProgressBar3.setString("Loading... Please wait...");
        jProgressBar3.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override

            public void run() {

                Field.Combo br = (Field.Combo) jTextField4;
                Field.Combo lo = (Field.Combo) jTextField5;

                String date_from = synsoftech.util.DateType.sf.format(jDateChooser1.getDate());
                String date_to = synsoftech.util.DateType.sf.format(jDateChooser2.getDate());
                String where = " where description like '%" + "" + "%' ";
                if (!jCheckBox3.isSelected()) {
                    where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }

                if (!jCheckBox4.isSelected() && !jCheckBox5.isSelected()) {
                    where = where + " and location_id='" + lo.getId() + "' ";
                }
                if (!jCheckBox4.isSelected() && jCheckBox5.isSelected()) {
                    where = where + " and branch_id='" + br.getId() + "' ";
                }

                where = where + " order by Date(date_added),location_id,description asc  ";

                List<Srpt_adjustments.field> fields = Srpt_adjustments.ret_data(where);

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");

                String date = DateType.slash.format(jDateChooser1.getDate()) + " - " + DateType.slash.format(jDateChooser2.getDate());
                if (jCheckBox3.isSelected()) {
                    date = "All";
                }
                String branch = jTextField4.getText();
                if (jCheckBox4.isSelected()) {
                    branch = "All";
                }
                String location = jTextField5.getText();
                if (jCheckBox5.isSelected()) {
                    location = "All";
                }
                Srpt_adjustments rpt = new Srpt_adjustments(business_name, address, date, branch, location);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_adjustments.jrxml";
                report_adjustments(rpt, jrxml);
                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_adjustments(final Srpt_adjustments to, String jrxml_name) {
        jPanel7.removeAll();
        jPanel7.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_adjustments(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel7.add(viewer);
            jPanel7.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_adjustments(Srpt_adjustments to, String rpt_name) {
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
            InputStream is = Srpt_adjustments.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

//</editor-fold>
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

    //<editor-fold defaultstate="collapsed" desc=" Errors ">
    List<Srpt_adjust_errors.field> errors = new ArrayList();

    private void ret_errors() {
        jProgressBar4.setString("Loading...Please wait...");
        jProgressBar4.setIndeterminate(true);

        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                errors.clear();
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");
                String date = DateType.month_date.format(new Date());
                Field.Combo lo = (Field.Combo) jTextField7;

                String where = " where location_id='" + lo.getId() + "'  order by description asc  ";
                List<Srpt_adjust_errors.field> fields = Srpt_adjust_errors.ret_data(where);
                errors = fields;
                System.out.println("size: " + fields.size());
                Srpt_adjust_errors rpt = new Srpt_adjust_errors(business_name, address, date);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_adjust_errors.jrxml";

                report_errors(rpt, jrxml);
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
                jProgressBar4.setString("Finished...");
                jProgressBar4.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void report_errors(final Srpt_adjust_errors to, String jrxml_name) {
        jPanel11.removeAll();
        jPanel11.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_expenses(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel11.add(viewer);
            jPanel11.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_expenses(Srpt_adjust_errors to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_adjust_errors.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void adjust_all_errors() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                jProgressBar4.setString("Loading...Please wait...");
                jProgressBar4.setIndeterminate(true);
                jButton5.setEnabled(false);
                jButton4.setEnabled(false);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Srpt_adjust_errors.adjust_erros(errors);
                        Alert.set(2, "");
                        jButton5.setEnabled(true);
                        jButton4.setEnabled(true);
                        jProgressBar4.setString("Finished...");
                        jProgressBar4.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    //</editor-fold>

}
