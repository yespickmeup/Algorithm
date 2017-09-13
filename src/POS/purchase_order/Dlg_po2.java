/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.purchase_order.Purchase_order.to_purchase_orders;
import POS.purchase_order.Purchase_order_item.to_purchase_order_items;
import POS.receipts.Dlg_receipts;

import POS.suppliers.Suppliers;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import POS.util.TableRenderer;
import POS.util.testOfFaith;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.SearchField;
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
public class Dlg_po2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_po2
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
    private Dlg_po2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_po2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_po2() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_po2 myRef;

    private void setThisRef(Dlg_po2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_po2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_po2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_po2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_po2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_po2((java.awt.Frame) parent, false);
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
            Dlg_po2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_po2((java.awt.Dialog) parent, false);
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

        Dlg_po2 dialog = Dlg_po2.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_receipt_no = new Field.Input();
        jLabel11 = new javax.swing.JLabel();
        tf_supplier = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        tf_branch = new Field.Combo();
        jLabel13 = new javax.swing.JLabel();
        tf_remarks = new Field.Input();
        jLabel14 = new javax.swing.JLabel();
        tf_remarks1 = new Field.Input();
        tf_remarks2 = new Field.Input();
        jLabel15 = new javax.swing.JLabel();
        tf_remarks3 = new Field.Input();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_remarks4 = new Field.Input();
        tf_dd_month = new SearchField();
        jLabel5 = new javax.swing.JLabel();
        tf_dd_day = new SearchField();
        tf_dd_year = new SearchField();
        jLabel6 = new javax.swing.JLabel();
        tf_dr_month = new SearchField();
        tf_dr_day = new SearchField();
        tf_dr_year = new SearchField();
        jLabel18 = new javax.swing.JLabel();
        tf_remarks5 = new Field.Input();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton3 = new Button.Info();
        jButton6 = new Button.Success();
        jButton7 = new Button.Success();
        jButton2 = new Button.Default();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_search = new Field.Input();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_receipt_items = new org.jdesktop.swingx.JXTable();
        jLabel19 = new javax.swing.JLabel();
        lbl_gross = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tf_discount = new javax.swing.JTextField();
        lbl_net = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel26 = new javax.swing.JLabel();
        lbl_net1 = new javax.swing.JLabel();
        lbl_net2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new Button.Primary();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_purchase_orders = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton5 =  new Button.Default();
        jLabel25 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        tf_branch1 = new Field.Combo();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Transaction #:");

        tf_receipt_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_receipt_no.setFocusable(false);
        tf_receipt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_receipt_noActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Supplier:");

        tf_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_supplierMouseClicked(evt);
            }
        });
        tf_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_supplierActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Location:");

        tf_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branchMouseClicked(evt);
            }
        });
        tf_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branchActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Reference #:");

        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarksActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Address:");

        tf_remarks1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks1.setFocusable(false);
        tf_remarks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks1ActionPerformed(evt);
            }
        });

        tf_remarks2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks2.setFocusable(false);
        tf_remarks2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Contact No:");

        tf_remarks3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_remarks3.setText("0.00");
        tf_remarks3.setFocusable(false);
        tf_remarks3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Balance:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Term:");

        tf_remarks4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks4.setText("0");
        tf_remarks4.setFocusable(false);
        tf_remarks4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks4ActionPerformed(evt);
            }
        });

        tf_dd_month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_dd_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dd_monthActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Date of Delivery:");

        tf_dd_day.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_dd_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dd_dayActionPerformed(evt);
            }
        });

        tf_dd_year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_dd_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dd_yearActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Received:");

        tf_dr_month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_dr_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dr_monthActionPerformed(evt);
            }
        });

        tf_dr_day.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_dr_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dr_dayActionPerformed(evt);
            }
        });

        tf_dr_year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_dr_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dr_yearActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Discount Amount:");

        tf_remarks5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_remarks5.setText("0.00");
        tf_remarks5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks5ActionPerformed(evt);
            }
        });
        tf_remarks5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_remarks5KeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("day/s");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

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

        jButton7.setText("Return");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setText("New Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_dd_month, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_dd_day, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_dd_year, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_remarks)
                                .addGap(96, 96, 96))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(tf_supplier))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_remarks2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(tf_remarks3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)
                                .addComponent(tf_dr_day, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(tf_dr_year)))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_remarks1)
                            .addComponent(tf_branch)
                            .addComponent(tf_receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_dr_month, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dd_month, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dd_day, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dd_year, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dr_month, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dr_day, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dr_year, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Search:");

        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jScrollPane3.setOpaque(false);

        tbl_receipt_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_receipt_items.setOpaque(false);
        tbl_receipt_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receipt_itemsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_receipt_items);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Gross Total:");

        lbl_gross.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gross.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_gross.setText("0.00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Discount:");

        tf_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_discount.setBorder(null);
        tf_discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_discountKeyReleased(evt);
            }
        });

        lbl_net.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_net.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_net.setText("0.00");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Net Total:");

        jLabel1.setText("State:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("No. of Items:");

        lbl_net1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_net1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_net1.setText("0");

        lbl_net2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_net2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_net2.setText("0");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Total Qty:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Post");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gross, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_discount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_net, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_net1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_net2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_discount)
                            .addComponent(jLabel27)
                            .addComponent(lbl_net2)
                            .addComponent(jLabel26)
                            .addComponent(lbl_net1)
                            .addComponent(jLabel21)
                            .addComponent(lbl_net))
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_gross, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, Short.MAX_VALUE)
            .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Purchase Order", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_purchase_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_purchase_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_purchase_ordersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_purchase_ordersMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_purchase_ordersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_purchase_ordersMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_purchase_orders);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date From:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("To:");

        jLabel4.setText("Total Trans:");

        jLabel7.setText("0");

        jLabel23.setText("Gross Total:");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("0.00");

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Search:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Status:");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Posted");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Finalized");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Location:");

        tf_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch1MouseClicked(evt);
            }
        });
        tf_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch1ActionPerformed(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("All");

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Returned");

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jCheckBox7.setText("/w pending qty");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox4))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jCheckBox6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1))
                        .addGap(0, 220, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox4)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7))))
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(jLabel24)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reports", jPanel3);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setText("State:");

        jProgressBar2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
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

    private void tbl_purchase_ordersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_purchase_ordersMousePressed
//        show_popup(evt);
    }//GEN-LAST:event_tbl_purchase_ordersMousePressed

    private void tbl_purchase_ordersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_purchase_ordersMouseReleased
//        show_popup(evt);
    }//GEN-LAST:event_tbl_purchase_ordersMouseReleased

    private void tbl_purchase_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_purchase_ordersMouseClicked
        select_purchase_order();
    }//GEN-LAST:event_tbl_purchase_ordersMouseClicked

    private void tbl_purchase_ordersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_purchase_ordersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_purchase_ordersMouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ret_purchase_orders();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch1MouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_branch1MouseClicked

    private void tf_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch1ActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_branch1ActionPerformed

    private void tf_receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_receipt_noActionPerformed
//        init_receipts();
    }//GEN-LAST:event_tf_receipt_noActionPerformed

    private void tf_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_supplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_supplierMouseClicked

    private void tf_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_supplierActionPerformed
        init_suppliers();
    }//GEN-LAST:event_tf_supplierActionPerformed

    private void tf_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branchMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_branchMouseClicked

    private void tf_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branchActionPerformed
        //        init_branch();
        init_branch_locations();
    }//GEN-LAST:event_tf_branchActionPerformed

    private void tf_remarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarksActionPerformed

    }//GEN-LAST:event_tf_remarksActionPerformed

    private void tf_remarks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks1ActionPerformed

    private void tf_remarks2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks2ActionPerformed

    private void tf_remarks3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks3ActionPerformed

    private void tf_remarks4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks4ActionPerformed

    private void tf_dd_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dd_monthActionPerformed
        // TODO add your handling code here:
        tf_dd_day.grabFocus();
    }//GEN-LAST:event_tf_dd_monthActionPerformed

    private void tf_dd_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dd_dayActionPerformed
        tf_dd_year.grabFocus();
    }//GEN-LAST:event_tf_dd_dayActionPerformed

    private void tf_dd_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dd_yearActionPerformed
        tf_dr_month.grabFocus();
    }//GEN-LAST:event_tf_dd_yearActionPerformed

    private void tf_dr_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dr_monthActionPerformed
        tf_dr_day.grabFocus();
    }//GEN-LAST:event_tf_dr_monthActionPerformed

    private void tf_dr_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dr_dayActionPerformed
        tf_dr_year.grabFocus();
    }//GEN-LAST:event_tf_dr_dayActionPerformed

    private void tf_dr_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dr_yearActionPerformed

    }//GEN-LAST:event_tf_dr_yearActionPerformed

    private void tf_remarks5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks5ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased

    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_receipt_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receipt_itemsMouseClicked
        select_order();
    }//GEN-LAST:event_tbl_receipt_itemsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        post_ordered();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new_order();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update_purchase_order();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discountKeyReleased

    }//GEN-LAST:event_tf_discountKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        finalize_order();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_remarks5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_remarks5KeyReleased
        compute();
    }//GEN-LAST:event_tf_remarks5KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        return_order();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JLabel lbl_gross;
    private javax.swing.JLabel lbl_net;
    private javax.swing.JLabel lbl_net1;
    private javax.swing.JLabel lbl_net2;
    private javax.swing.JTable tbl_purchase_orders;
    private org.jdesktop.swingx.JXTable tbl_receipt_items;
    private javax.swing.JTextField tf_branch;
    private javax.swing.JTextField tf_branch1;
    private javax.swing.JTextField tf_dd_day;
    private javax.swing.JTextField tf_dd_month;
    private javax.swing.JTextField tf_dd_year;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_dr_day;
    private javax.swing.JTextField tf_dr_month;
    private javax.swing.JTextField tf_dr_year;
    private javax.swing.JTextField tf_receipt_no;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_remarks1;
    private javax.swing.JTextField tf_remarks2;
    private javax.swing.JTextField tf_remarks3;
    private javax.swing.JTextField tf_remarks4;
    private javax.swing.JTextField tf_remarks5;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_supplier;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

        init_key();
        set_date();
        set_d();
        set_default_branch();
        init_purchase_order_no();
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);

        init_tbl_purchase_order_items(tbl_receipt_items);
        init_tbl_purchase_orders(tbl_purchase_orders);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tf_supplier.grabFocus();
            }
        });
    }

    private void init_purchase_order_no() {
        Field.Combo combo = (Field.Combo) tf_branch;
        String aw = Purchase_order.increment_id(combo.getId());
        String receipt_no = aw;
        tf_receipt_no.setText(receipt_no);

    }

    String my_branch = "";
    String my_branch_id = "";

    private void set_default_branch() {
        Field.Combo combo = (Field.Combo) tf_branch;
        Field.Combo combo2 = (Field.Combo) tf_branch1;

        List<S1_branch_locations.to_branch_locations> branch_locations = S1_branch_locations.ret_where("");
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        combo.setText(to.location + " - [" + to.branch + "]");
        combo.setId("" + to.id);
        combo2.setText(to.location + " - [" + to.branch + "]");
        combo2.setId("" + to.id);
        my_branch = to.branch;
        my_branch_id = to.branch_id;
    }

    private void set_date() {
        testOfFaith.set(tf_dd_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_dd_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_dd_year, DateType.listYear(), "Year");

        testOfFaith.set(tf_dr_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_dr_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_dr_year, DateType.listYear(), "Year");
    }

    private void set_d() {
        String month = DateType.m.format(new Date());
        String day = DateType.add_zero(DateType.d.format(new Date()));
        String year = DateType.y.format(new Date());
        tf_dd_day.setText(day);
        tf_dd_month.setText(month);
        tf_dd_year.setText(year);

        tf_dr_day.setText(day);
        tf_dr_month.setText(month);
        tf_dr_year.setText(year);
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

    List<Suppliers.to_suppliers> supplier_list = new ArrayList();

    private void init_suppliers() {
        final Field.Combo supp = (Field.Combo) tf_supplier;
        String search = tf_supplier.getText();
        supplier_list.clear();
        supplier_list = Suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list.size()][3];
        int i = 0;
        for (Suppliers.to_suppliers to : supplier_list) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            obj[i][2] = " " + FitIn.fmt_woc_0(to.balance);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {68, 220, 80};

        String[] col_names = {"ID", "NAME", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_supplier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Suppliers.to_suppliers to = supplier_list.get(data.selected_row);
                supp.setText(to.customer_name);
                supp.setId(to.customer_no);
                tf_remarks3.setText(FitIn.fmt_wc_0(to.balance));
                tf_remarks1.setText(to.address);
                tf_remarks2.setText(to.contact_no);
                tf_remarks4.setText(FitIn.fmt_woc(to.term));
            }
        });
    }
    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    String my_location = "";
    String my_location_id = "";

    private void init_branch_locations() {
        if (!tf_branch.isEnabled()) {
            return;
        }
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 100};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo combo = (Field.Combo) tf_branch;
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                combo.setText(to.location + " - [" + to.branch + "]");
                combo.setId("" + to.id);
                my_branch = to.branch;
                my_branch_id = to.branch_id;
            }
        });
    }

    private void init_branch_locations2() {

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 100};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_branch1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo combo = (Field.Combo) tf_branch1;
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                combo.setText(to.location + " - [" + to.branch + "]");
                combo.setId("" + to.id);

            }
        });
    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        final Field.Combo br = (Field.Combo) tf_branch;
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " where "
                        + " main_barcode like '" + search + "' and location_id='" + br.getId() + "' "
                        + " or barcode like '" + search + "' and location_id='" + br.getId() + "' "
                        + " or description like '%" + search + "%' and location_id='" + br.getId() + "' ";
                where = where + " order by description asc ";

                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);

                if (inventory_barcoders_list.isEmpty()) {

                }
                if (inventory_barcoders_list.size() >= 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
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
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.cost);
                        if (to.reorder_level <= to.product_qty) {
                            obj[i][5] = " Re-order";
                        } else {
                            obj[i][5] = " ";
                        }
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .50;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 80, w, 30, 50, 50};
                    String[] col_names = {"Qty", "ItemCode", "Description", "Unit", "Cost", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {

                            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(data.selected_row);
                            add_order(to);
                        }
                    });
                }
            }
        }
        );
        t.start();
    }

    private void add_order(final Inventory_barcodes.to_inventory_barcodes to) {
        Window p = (Window) this;
        Dlg_po2_qty nd = Dlg_po2_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(1, to.cost, to.main_barcode, to.barcode, to.description);
        nd.setCallback(new Dlg_po2_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_po2_qty.OutputData data) {
                closeDialog.ok();
                int row = tbl_purchase_orders.getSelectedRow();
                if (row < 0) {
                    int id = 0;
                    String po_no = "";
                    String user_name = "";
                    String session_no = "";
                    String date_added = "";
                    String supplier = "";
                    String supplier_id = "";
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
                    double conversion = to.conversion;
                    String unit = to.unit;
                    String barcodes = "";
                    String batch_no = "";
                    String serial_no = "";
                    String main_barcode = to.main_barcode;
                    double qty_ordered = data.qty;
                    double qty_received = 0;
                    double previous_cost = to.cost;
                    double new_cost = data.cost;
                    int status = 0;
                    String date_delivered = "";
                    String date_received = "";
                    String reference_no = "";
                    String receipt_type = "";
                    String receipt_type_id = "";
                    String branch = to.branch;
                    String branch_id = to.branch_code;
                    String location = to.location;
                    String location_id = to.location_id;
                    Purchase_order_item.to_purchase_order_items order = new to_purchase_order_items(id, po_no, user_name, session_no, date_added, supplier, supplier_id, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty_ordered, qty_received, previous_cost, new_cost, status, date_delivered, date_received, reference_no, receipt_type, receipt_type_id, branch, branch_id, location, location_id);

                    tbl_purchase_order_items_ALM.add(order);
                    compute();
                } else {
                    to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row);
                    if (order.status == 0 || order.status == 1) {
                        int id = 0;
                        String po_no = order.puchase_order_no;
                        String user_name = MyUser.getUser_id();
                        String session_no = "";
                        String date_added = DateType.now();
                        String supplier = order.supplier;
                        String supplier_id = order.supplier_id;
                        String remarks = order.remarks;
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
                        String batch_no = "";
                        String serial_no = "";
                        String main_barcode = to.main_barcode;
                        double qty_ordered = data.qty;
                        double qty_received = 0;
                        double previous_cost = to.cost;
                        double new_cost = data.cost;
                        int status = 0;
                        String date_delivered = order.date_delivered;
                        String date_received = order.date_received;
                        String reference_no = "";
                        String receipt_type = "";
                        String receipt_type_id = "";
                        String branch = to.branch;
                        String branch_id = to.branch_code;
                        String location = to.location;
                        String location_id = to.location_id;
                        Purchase_order_item.to_purchase_order_items orders = new to_purchase_order_items(id, po_no, user_name, session_no, date_added, supplier, supplier_id, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty_ordered, qty_received, previous_cost, new_cost, status, date_delivered, date_received, reference_no, receipt_type, receipt_type_id, branch, branch_id, location, location_id);
                        Purchase_order_item.add_data(orders);

                        String where = " where po_no='" + order.puchase_order_no + "'";
                        List<Purchase_order_item.to_purchase_order_items> datas = Purchase_order_item.ret_data(where);
                        loadData_purchase_order_items(datas);
                        compute();

                        double total_qty_ordered = 0;
                        double total_qty_received = 0;
                        List<to_purchase_order_items> items = tbl_purchase_order_items_ALM;
                        for (to_purchase_order_items order1 : items) {
                            total_qty_ordered += order1.qty_ordered;
                            total_qty_received += order1.qty_received;
                        }

                        Purchase_order_item.update_total_qty(order.id, total_qty_ordered, total_qty_received);
                        ret_purchase_orders();
                        tbl_purchase_orders.setRowSelectionInterval(row, row);
                        Alert.set(2, "");
                    }
                }

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    //<editor-fold defaultstate="collapsed" desc=" purchase_order_items ">
    public static ArrayListModel tbl_purchase_order_items_ALM;
    public static Tblpurchase_order_itemsModel tbl_purchase_order_items_M;

    public static void init_tbl_purchase_order_items(JTable tbl_purchase_order_items) {
        tbl_purchase_order_items_ALM = new ArrayListModel();
        tbl_purchase_order_items_M = new Tblpurchase_order_itemsModel(tbl_purchase_order_items_ALM);
        tbl_purchase_order_items.setModel(tbl_purchase_order_items_M);
        tbl_purchase_order_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_purchase_order_items.setRowHeight(25);
        int[] tbl_widths_purchase_order_items = {0, 100, 100, 100, 80, 100, 100,
            80, 80, 40, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_purchase_order_items.length;
                i < n;
                i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_purchase_order_items, i, tbl_widths_purchase_order_items[i]);
        }
        Dimension d = tbl_purchase_order_items.getTableHeader().getPreferredSize();
        d.height = 25;

        tbl_purchase_order_items.getTableHeader()
                .setPreferredSize(d);
        tbl_purchase_order_items.getTableHeader()
                .setFont(new java.awt.Font("Arial", 0, 12));
        tbl_purchase_order_items.setRowHeight(
                25);
        tbl_purchase_order_items.setFont(
                new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_purchase_order_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_purchase_order_items, 6);
    }

    public static void loadData_purchase_order_items(List<to_purchase_order_items> acc) {
        tbl_purchase_order_items_ALM.clear();
        tbl_purchase_order_items_ALM.addAll(acc);

    }

    public static class Tblpurchase_order_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Barcode", "Description", "Unit", "Previous Cost", "New Cost", "Ordered", "Received", "", "", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "brand", "brand_id", "model", "model_id", "conversion", "unit", "barcodes", "batch_no", "serial_no", "main_barcode", "qty_ordered", "qty_received", "previous_cost", "new_cost", "status", "date_delivered", "date_received", "reference_no", "receipt_type", "receipt_type_id", "branch", "branch_id", "location", "location_id"
        };

        public Tblpurchase_order_itemsModel(ListModel listmodel) {
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
            to_purchase_order_items tt = (to_purchase_order_items) getRow(row);
            switch (col) {
                case 0:
                    return tt.qty_ordered;
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.barcode;
                case 3:
                    return " " + tt.description;
                case 4:
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 5:
                    return " " + FitIn.fmt_wc_0(tt.previous_cost) + " ";
                case 6:
                    return " " + FitIn.fmt_wc_0(tt.new_cost) + " ";
                case 7:
                    return " " + FitIn.fmt_woc(tt.qty_ordered);
                case 8:
                    return " " + FitIn.fmt_woc(tt.qty_received);
                case 9:
                    return " Edit";
                case 10:
                    return " Delete";
                case 11:
                    return tt.category_id;
                case 12:
                    return tt.classification;
                case 13:
                    return tt.classification_id;
                case 14:
                    return tt.sub_class;
                case 15:
                    return tt.sub_class_id;
                case 16:
                    return tt.brand;
                case 17:
                    return tt.brand_id;
                case 18:
                    return tt.model;
                case 19:
                    return tt.model_id;
                case 20:
                    return tt.conversion;
                case 21:
                    return tt.unit;
                case 22:
                    return tt.barcodes;
                case 23:
                    return tt.batch_no;
                case 24:
                    return tt.serial_no;
                case 25:
                    return tt.main_barcode;
                case 26:
                    return tt.qty_ordered;
                case 27:
                    return tt.qty_received;
                case 28:
                    return tt.previous_cost;
                case 29:
                    return tt.new_cost;
                case 30:
                    return tt.status;
                case 31:
                    return tt.date_delivered;
                case 32:
                    return tt.date_received;
                case 33:
                    return tt.reference_no;
                case 34:
                    return tt.receipt_type;
                case 35:
                    return tt.receipt_type_id;
                case 36:
                    return tt.branch;
                case 37:
                    return tt.branch_id;
                case 38:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void select_order() {
        final int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_purchase_order_items to = (to_purchase_order_items) tbl_purchase_order_items_ALM.get(row);
        int col = tbl_receipt_items.getSelectedColumn();
        if (col == 9) {
            if (to.status == 0 || to.status == 1 || to.id == 0) {
                Window p = (Window) this;
                Dlg_po2_qty nd = Dlg_po2_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.qty_ordered, to.new_cost, to.main_barcode, to.barcode, to.description);
                nd.setCallback(new Dlg_po2_qty.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_po2_qty.OutputData data) {
                        closeDialog.ok();
                        if (to.id == 0) {
                            to.setQty_ordered(data.qty);
                            to.setNew_cost(data.cost);
                            tbl_purchase_order_items_M.fireTableDataChanged();
                        } else {
                            if (to.status == 0 || to.status == 1) {
                                to.setQty_ordered(data.qty);
                                to.setNew_cost(data.cost);
                                int row2 = tbl_purchase_orders.getSelectedRow();
                                to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row2);

                                Purchase_order_item.update_qty(to);
                                String where = " where po_no='" + order.puchase_order_no + "'";
                                List<Purchase_order_item.to_purchase_order_items> datas = Purchase_order_item.ret_data(where);
                                loadData_purchase_order_items(datas);
                                compute();

                                double total_qty_ordered = 0;
                                double total_qty_received = 0;
                                List<to_purchase_order_items> orders = tbl_purchase_order_items_ALM;
                                for (to_purchase_order_items order1 : orders) {
                                    total_qty_ordered += order1.qty_ordered;
                                    total_qty_received += order1.qty_received;
                                }

                                Purchase_order_item.update_total_qty(order.id, total_qty_ordered, total_qty_received);
                                ret_purchase_orders();
                                tbl_purchase_orders.setRowSelectionInterval(row2, row2);
                                Alert.set(2, "");
                            }
                            if (to.status == 1) {

                            }
                        }

                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
            if (to.status == 2) {
                Window p = (Window) this;
                Dlg_po2_qty_returned nd = Dlg_po2_qty_returned.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.qty_ordered, to.qty_received, to.main_barcode, to.barcode, to.description);
                nd.setCallback(new Dlg_po2_qty_returned.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_po2_qty_returned.OutputData data) {
                        closeDialog.ok();

                        to.setQty_received(data.cost);
                        int row2 = tbl_purchase_orders.getSelectedRow();
                        to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row2);

                        Purchase_order_item.update_received(to);
                        String where = " where po_no='" + order.puchase_order_no + "'";
                        List<Purchase_order_item.to_purchase_order_items> datas = Purchase_order_item.ret_data(where);
                        loadData_purchase_order_items(datas);
                        compute();

                        double total_qty_ordered = 0;
                        double total_qty_received = 0;
                        List<to_purchase_order_items> orders = tbl_purchase_order_items_ALM;
                        for (to_purchase_order_items order1 : orders) {
                            total_qty_ordered += order1.qty_ordered;
                            total_qty_received += order1.qty_received;
                        }

                        Purchase_order_item.update_total_qty_received(order.id, total_qty_ordered, total_qty_received);
                        ret_purchase_orders();
                        tbl_purchase_orders.setRowSelectionInterval(row2, row2);
                        Alert.set(2, "");

                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }

        if (col == 10) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    if (to.id == 0) {
                        tbl_purchase_order_items_ALM.remove(row);
                        tbl_purchase_order_items_M.fireTableDataChanged();
                    } else {
                        if (to.status == 0) {

                            int row2 = tbl_purchase_orders.getSelectedRow();
                            to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row2);

                            Purchase_order_item.delete_data(to);
                            String where = " where po_no='" + order.puchase_order_no + "'";
                            List<Purchase_order_item.to_purchase_order_items> datas = Purchase_order_item.ret_data(where);
                            loadData_purchase_order_items(datas);
                            compute();

                            double total_qty_ordered = 0;
                            double total_qty_received = 0;
                            List<to_purchase_order_items> orders = tbl_purchase_order_items_ALM;
                            for (to_purchase_order_items order1 : orders) {
                                total_qty_ordered += order1.qty_ordered;
                                total_qty_received += order1.qty_received;
                            }

                            Purchase_order_item.update_total_qty(order.id, total_qty_ordered, total_qty_received);
                            ret_purchase_orders();
                            tbl_purchase_orders.setRowSelectionInterval(row2, row2);
                            Alert.set(3, "");
                        }
                        if (to.status == 1) {

                        }
                        if (to.status == 2) {

                        }
                    }

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    private void new_order() {
        init_purchase_order_no();

        Field.Combo supplier = (Field.Combo) tf_supplier;
        supplier.setId(null);
        supplier.setText("");
        tf_remarks3.setText("");
        tf_remarks1.setText("");
        tf_remarks2.setText("");
        tf_remarks4.setText("0");

        tf_remarks.setText("");
        tf_remarks5.setText("0.00");
        tf_supplier.grabFocus();

        tbl_purchase_order_items_ALM.clear();
        tbl_purchase_order_items_M.fireTableDataChanged();
        compute();
        tbl_purchase_orders.clearSelection();

        tf_branch.setEnabled(true);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton1.setEnabled(true);
        tf_supplier.setEnabled(true);
    }

    private void compute() {
        double gross = 0;
        double discount = FitIn.toDouble(tf_remarks5.getText());
        double net_total = 0;
        double no_of_items = tbl_purchase_order_items_ALM.size();
        double total_qty_ordered = 0;
        List<to_purchase_order_items> datas = tbl_purchase_order_items_ALM;

        for (to_purchase_order_items to : datas) {
            gross += (to.new_cost * to.qty_ordered);
            total_qty_ordered += to.qty_ordered;
        }
        net_total = gross - discount;
        lbl_gross.setText(FitIn.fmt_wc_0(gross));
        tf_discount.setText(FitIn.fmt_wc_0(discount));
        lbl_net.setText(FitIn.fmt_wc_0(net_total));
        lbl_net1.setText(FitIn.fmt_woc(no_of_items));
        lbl_net2.setText(FitIn.fmt_woc(total_qty_ordered));
    }

    private void post_ordered() {
        int id = 0;
        Field.Combo combo = (Field.Combo) tf_branch;
        Field.Combo supp = (Field.Combo) tf_supplier;
        Field.Combo lo = (Field.Combo) tf_branch;

        String puchase_order_no = Purchase_order.increment_id(combo.getId());
        String where = " where puchase_order_no='" + puchase_order_no + "'";
        List<Purchase_order.to_purchase_orders> datas = Purchase_order.ret_data(where);
        if (!datas.isEmpty()) {
            Alert.set(0, "Transaction no already exists!");
            post_ordered();
            return;
        }

        String user_name = MyUser.getUser_id();
        String session_no = "";
        String date_added = DateType.now();

        String supplier = supp.getText();
        String supplier_id = supp.getId();

        if (supplier_id == null) {
            Alert.set(0, "Select Supplier");
            tf_supplier.grabFocus();
            return;
        }
        if (supplier_id == null) {
            Alert.set(0, "Select Supplier");
            tf_supplier.grabFocus();
            return;
        }
        String remarks = tf_remarks.getText();
        int status = 0;
        String date_delivered = tf_dd_month.getText() + " " + tf_dd_day.
                getText() + ", " + tf_dd_year.getText();
        date_delivered = DateType.convert_monthDate_sf(date_delivered);
        String date_received = tf_dr_month.getText() + " " + tf_dr_day.getText() + ", " + tf_dr_year.
                getText();
        date_received = DateType.convert_monthDate_sf(date_received);

        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = lo.getText();
        String location_id = lo.getId();
        String reference_no = "";
        double gross_total = FitIn.toDouble(lbl_gross.getText());
        String discount = "";
        double discount_amount = FitIn.toDouble(tf_remarks5.getText());
        double discount_rate = 0;
        String receipt_no = "";
        String receipt_type = "";
        String receipt_type_id = "";

        double total_qty_ordered = FitIn.toDouble(lbl_net2.getText());
        double total_qty_received = 0;
        final Purchase_order.to_purchase_orders order = new Purchase_order.to_purchase_orders(id, puchase_order_no, user_name, session_no, date_added, supplier, supplier_id, remarks, status, date_delivered, date_received, branch, branch_id, location, location_id, reference_no, gross_total, discount, discount_amount, discount_rate, receipt_no, receipt_type, receipt_type_id, total_qty_ordered, total_qty_received);

        final List<to_purchase_order_items> orders = tbl_purchase_order_items_ALM;
        if (orders.isEmpty()) {
            Alert.set(0, "Select Item/s!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Purchase_order.add_data(order, orders);
                ret_purchase_orders();
                Alert.set(1, "");
                new_order();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" purchase_orders ">
    public static ArrayListModel tbl_purchase_orders_ALM;
    public static Tblpurchase_ordersModel tbl_purchase_orders_M;

    public static void init_tbl_purchase_orders(JTable tbl_purchase_orders) {
        tbl_purchase_orders_ALM = new ArrayListModel();
        tbl_purchase_orders_M = new Tblpurchase_ordersModel(tbl_purchase_orders_ALM);
        tbl_purchase_orders.setModel(tbl_purchase_orders_M);
        tbl_purchase_orders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_purchase_orders.setRowHeight(25);
        int[] tbl_widths_purchase_orders = {120, 80, 100, 170, 100, 60, 70, 60, 50, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_purchase_orders.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_purchase_orders, i, tbl_widths_purchase_orders[i]);
        }
        Dimension d = tbl_purchase_orders.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_purchase_orders.getTableHeader().setPreferredSize(d);
        tbl_purchase_orders.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_purchase_orders.setRowHeight(25);
        tbl_purchase_orders.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_purchase_orders, 4);
    }

    public static void loadData_purchase_orders(List<to_purchase_orders> acc) {
        tbl_purchase_orders_ALM.clear();
        tbl_purchase_orders_ALM.addAll(acc);
    }

    public static class Tblpurchase_ordersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "Supplier", "Location", "Gross Total", "Ordered", "Returned", "", "", "", "", "branch", "branch_id", "location", "location_id", "reference_no", "gross_total", "discount", "discount_amount", "discount_rate", "receipt_no", "receipt_type", "receipt_type_id", "total_qty_ordered", "total_qty_received"
        };

        public Tblpurchase_ordersModel(ListModel listmodel) {
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
            to_purchase_orders tt = (to_purchase_orders) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.puchase_order_no;
                case 1:
                    return " " + DateType.convert_slash_datetime2(tt.date_delivered);
                case 2:
                    return " " + tt.supplier;
                case 3:
                    return " " + tt.location;
                case 4:
                    return FitIn.fmt_wc_0(tt.gross_total) + " ";
                case 5:
                    return " " + FitIn.fmt_woc(tt.total_qty_ordered);
                case 6:
                    return " " + FitIn.fmt_woc(tt.total_qty_received);
                case 7:
                    if (tt.status == 0) {
                        return " Posted";
                    } else if (tt.status == 1) {
                        return " Finalized";
                    } else {
                        return " Returned";
                    }
                case 8:
                    return " Update";
                case 9:
                    return " Delete";
                case 10:
                    return " Print";
                case 11:
                    return tt.branch;
                case 12:
                    return tt.branch_id;
                case 13:
                    return tt.location;
                case 14:
                    return tt.location_id;
                case 15:
                    return tt.reference_no;
                case 16:
                    return tt.gross_total;
                case 17:
                    return tt.discount;
                case 18:
                    return tt.discount_amount;
                case 19:
                    return tt.discount_rate;
                case 20:
                    return tt.receipt_no;
                case 21:
                    return tt.receipt_type;
                case 22:
                    return tt.receipt_type_id;
                case 23:
                    return tt.total_qty_ordered;
                default:
                    return tt.total_qty_received;
            }
        }
    }

    private void ret_purchase_orders() {
        Field.Combo lo = (Field.Combo) tf_branch1;
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        String where = " where discount like '%" + "" + "%' ";
        if (jCheckBox3.isSelected()) {
            where = where + " and status=0";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " and status=1";
        }
        if (jCheckBox6.isSelected()) {
            where = where + " and status=2";
            if (jCheckBox7.isSelected()) {
                where = where + " and total_qty_ordered<>total_qty_received ";
            }
        }
        if (!jCheckBox5.isSelected()) {
            where = where + " and location_id='" + lo.getId() + "' ";
        }
        if (!jCheckBox1.isSelected()) {
            where = where + " and Date(date_delivered) between '" + date_from + "' and '" + date_to + "' ";
        }

        where = where + " order by id desc ";
        List<to_purchase_orders> orders = Purchase_order.ret_data(where);
        loadData_purchase_orders(orders);
        double gross = 0;
        for (to_purchase_orders to : orders) {
            gross += to.gross_total;
        }
        jLabel24.setText(FitIn.fmt_wc_0(gross));
        jLabel7.setText("" + orders.size());

    }

    private void select_purchase_order() {
        int row = tbl_purchase_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_purchase_orders.getSelectedColumn();
        Field.Combo loc = (Field.Combo) tf_branch;
        Field.Combo sup = (Field.Combo) tf_supplier;

        if (col == 8) {
            to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row);
            tf_receipt_no.setText(order.puchase_order_no);
            my_branch = order.branch;
            my_branch_id = order.branch_id;
            loc.setText(order.location);
            loc.setId(order.location_id);
            sup.setText(order.supplier);
            sup.setId(order.supplier_id);

            String where2 = " where customer_no='" + order.supplier_id + "' ";
            List<Suppliers.to_suppliers> suppliers = Suppliers.ret_data2(where2);
            if (!suppliers.isEmpty()) {
                Suppliers.to_suppliers su = (Suppliers.to_suppliers) suppliers.get(0);
                tf_remarks3.setText(FitIn.fmt_wc_0(su.balance));
                tf_remarks1.setText(su.address);
                tf_remarks2.setText(su.contact_no);
                tf_remarks4.setText(FitIn.fmt_woc(su.term));

                try {
                    Date delivered = DateType.sf.parse(order.date_delivered);
                    String d_month = DateType.m.format(delivered);
                    String d_day = DateType.d.format(delivered);
                    String d_year = DateType.y.format(delivered);
                    tf_dd_month.setText(d_month);
                    tf_dd_day.setText(d_day);
                    tf_dd_year.setText(d_year);

                    Date received = DateType.sf.parse(order.date_received);
                    String r_month = DateType.m.format(received);
                    String r_day = DateType.d.format(received);
                    String r_year = DateType.y.format(received);
                    tf_dr_month.setText(r_month);
                    tf_dr_day.setText(r_day);
                    tf_dr_year.setText(r_year);
                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_receipts.class.getName()).log(Level.SEVERE, null, ex);
                }

                tf_remarks.setText(order.remarks);
                tf_remarks5.setText(FitIn.fmt_wc_0(order.discount_amount));

                String where = " where po_no='" + order.puchase_order_no + "'";
                List<to_purchase_order_items> orders = Purchase_order_item.ret_data(where);
                loadData_purchase_order_items(orders);
                compute();
                jTabbedPane1.setSelectedIndex(0);
                tf_branch.setEnabled(false);

                if (order.status == 0) {
                    jButton1.setEnabled(false);
                    jButton6.setEnabled(true);
                    jButton3.setEnabled(true);
                }
                if (order.status == 1) {

                    tf_supplier.setEnabled(false);
                    jButton1.setEnabled(false);
                    jButton3.setEnabled(true);
                    jButton7.setEnabled(true);
                }
                if (order.status == 2) {
                    tf_supplier.setEnabled(false);
                    jButton3.setEnabled(false);
                    jButton6.setEnabled(false);
                    jButton7.setEnabled(false);
                }
            }

        }
        if (col == 9) {
            delete_order();
        }
        if (col == 10) {
            set_report();
            jTabbedPane1.setSelectedIndex(2);
        }
    }

    private void delete_order() {
        final int row = tbl_purchase_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row);
        if (order.status == 1) {
            Alert.set(0, "Transaction already finalized!");
            return;
        }
        if (order.status == 2) {
            Alert.set(0, "Transaction status is returned!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                if (order.status == 0) {
                    Purchase_order.delete_order(order);
                    ret_purchase_orders();
                    Alert.set(3, "");
                }

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void update_purchase_order() {
        final int row = tbl_purchase_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row);

        int id = order.id;
        Field.Combo combo = (Field.Combo) tf_branch;
        Field.Combo supp = (Field.Combo) tf_supplier;
        Field.Combo lo = (Field.Combo) tf_branch;

        String puchase_order_no = order.puchase_order_no;

        String user_name = order.user_name;
        String session_no = order.session_no;
        String date_added = order.date_added;

        String supplier = supp.getText();
        String supplier_id = supp.getId();
        if (supplier_id.isEmpty() || supplier_id == null) {
            Alert.set(0, "Select Supplier");
            tf_supplier.grabFocus();
            return;
        }
        String remarks = tf_remarks.getText();
        int status = 0;
        String date_delivered = tf_dd_month.getText() + " " + tf_dd_day.
                getText() + ", " + tf_dd_year.getText();
        date_delivered = DateType.convert_monthDate_sf(date_delivered);
        String date_received = tf_dr_month.getText() + " " + tf_dr_day.getText() + ", " + tf_dr_year.
                getText();
        date_received = DateType.convert_monthDate_sf(date_received);

        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = lo.getText();
        String location_id = lo.getId();
        String reference_no = "";
        double gross_total = FitIn.toDouble(lbl_gross.getText());
        String discount = "";
        double discount_amount = FitIn.toDouble(tf_remarks5.getText());
        double discount_rate = 0;
        String receipt_no = "";
        String receipt_type = "";
        String receipt_type_id = "";

        double total_qty_ordered = FitIn.toDouble(lbl_net2.getText());
        double total_qty_received = 0;
        final Purchase_order.to_purchase_orders order1 = new Purchase_order.to_purchase_orders(id, puchase_order_no, user_name, session_no, date_added, supplier, supplier_id, remarks, status, date_delivered, date_received, branch, branch_id, location, location_id, reference_no, gross_total, discount, discount_amount, discount_rate, receipt_no, receipt_type, receipt_type_id, total_qty_ordered, total_qty_received);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to update this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                if (order.status == 0 || order.status == 1) {
                    Purchase_order.update_po(order1);
                    ret_purchase_orders();
                    tbl_purchase_orders.setRowSelectionInterval(row, row);
                    Alert.set(2, "");
                }
                if (order.status == 2) {
                    Alert.set(0, "Transaction status already returned!");
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void set_report() {

        int row = tbl_purchase_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row);

        jProgressBar2.setString("Loading... Please wait...");
        jProgressBar2.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Srpt_purchase_order.field> fields = new ArrayList();
                String where = " where po_no='" + order.puchase_order_no + "'";
                List<to_purchase_order_items> orders = Purchase_order_item.ret_data(where);
                for (to_purchase_order_items item : orders) {
                    String item_code = item.main_barcode;
                    String barcode = item.barcode;
                    String description = item.description;
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(item.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    double cost = item.new_cost;
                    double qty_ordered = item.qty_ordered;
                    Srpt_purchase_order.field to = new Srpt_purchase_order.field(item_code, barcode, description, unit, cost, qty_ordered);
                    fields.add(to);
                }

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City, Negros Oriental");
                String contact_no = System.getProperty("contact_no", "422-12345/422-5678");
                String printed_by = "Administrator";
                String date = DateType.convert_slash_datetime2(order.date_delivered);
                String purchase_order_no = order.puchase_order_no;
                String supplier = order.supplier;
                String remarks = order.remarks;
                String location = order.location;
                double gross_amount = order.gross_total;
                double discount = order.discount_amount;
                Srpt_purchase_order rpt = new Srpt_purchase_order(business_name, address, contact_no, printed_by, date, purchase_order_no, supplier, remarks, location, gross_amount, discount);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_purchase_order.jrxml";
                report_customers_aging(rpt, jrxml);
                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_purchase_order to, String jrxml_name) {
        jPanel10.removeAll();
        jPanel10.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_customers_aging(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel10.add(viewer);
            jPanel10.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_customers_aging(Srpt_purchase_order to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_aging(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_aging(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_purchase_order.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void finalize_order() {
        int row = tbl_purchase_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.do_pass("Are you sure you want to finalize this transaction?");
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Purchase_order.finalize_order(order);
                ret_purchase_orders();
                new_order();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void return_order() {
        int row = tbl_purchase_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_purchase_orders order = (to_purchase_orders) tbl_purchase_orders_ALM.get(row);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.do_pass("Are you sure you want to return this transaction?");
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Purchase_order.returnorder(order);
                ret_purchase_orders();
                new_order();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
//</editor-fold>
}
