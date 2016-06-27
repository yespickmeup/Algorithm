/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.barcodes.Dlg_barcodes;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Dlg_inventory_update_barcode;
import POS.inventory.Inventory_barcodes;
import POS.inventory_reports.Dlg_report_inventory_ledger;
import POS.my_services.Dlg_my_service_confirm;
import POS.purchase_order.S1_purchase_order_items;
import POS.purchase_order.S1_purchase_orders;
import POS.receipts.S1_receipt_orders.to_receipt_items;
import POS.receipts.Receipts.to_receipts;
import POS.suppliers.S1_suppliers;
import POS.users.S1_user_previleges;
import POS.util.*;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.*;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Maytopacka
 */
public class Dlg_receipts extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_location
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
    private Dlg_receipts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_receipts(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_receipts() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_receipts myRef;

    private void setThisRef(Dlg_receipts myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_receipts> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_receipts create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_receipts create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_receipts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_receipts((java.awt.Frame) parent, false);
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
            Dlg_receipts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_receipts((java.awt.Dialog) parent, false);
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

        Dlg_receipts dialog = Dlg_receipts.
                create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
//        dialog.setSize(xSize, ySize);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_reference_no = new Field.Input();
        tf_supplier = new Field.Combo();
        tf_branch = new Field.Combo();
        tf_remarks = new Field.Input();
        tf_receipt_no = new Field.Input();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_supplier_id = new javax.swing.JTextField();
        tf_branch_id = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tf_receipt_no1 = new javax.swing.JTextField();
        tf_receipt_no2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_receipt_no3 = new javax.swing.JTextField();
        tf_receipt_no4 = new javax.swing.JTextField();
        tf_receipt_type = new Field.Combo();
        tf_receipt_type_id = new javax.swing.JTextField();
        tf_dr_month = new SearchField();
        tf_dr_day = new SearchField();
        tf_dr_year = new SearchField();
        tf_dd_month = new SearchField();
        tf_dd_day = new SearchField();
        tf_dd_year = new SearchField();
        jLabel22 = new javax.swing.JLabel();
        lbl_batch_no = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tf_disc = new javax.swing.JTextField();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_search = new Field.Input();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_receipt_items = new org.jdesktop.swingx.JXTable();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Default();
        jButton3 = new Button.Info();
        jLabel17 = new javax.swing.JLabel();
        lbl_gross = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_discount = new javax.swing.JTextField();
        lbl_net = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new Button.Success();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipts = new javax.swing.JTable();
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
        jButton7 = new Button.Default();
        jButton8 = new Button.Default();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        tf_branch1 = new Field.Combo();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/transactions.png"))); // NOI18N
        jMenuItem1.setText("Finalize Receipt");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jXPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Date of Delivery:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Received:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Transaction #:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Type:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Supplier:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Receiving Location:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Reference #:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("PO #:");

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

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

        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarksActionPerformed(evt);
            }
        });

        tf_receipt_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_receipt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_receipt_noActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Status:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("New");

        tf_supplier_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_supplier_id.setFocusable(false);
        tf_supplier_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_supplier_idActionPerformed(evt);
            }
        });

        tf_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch_id.setFocusable(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Branch:");

        tf_receipt_no1.setFocusable(false);

        tf_receipt_no2.setFocusable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Location:");

        tf_receipt_no3.setFocusable(false);

        tf_receipt_no4.setFocusable(false);

        tf_receipt_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_receipt_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_receipt_typeActionPerformed(evt);
            }
        });

        tf_receipt_type_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_receipt_type_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        tf_dd_month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_dd_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dd_monthActionPerformed(evt);
            }
        });

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

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Batch No:");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_batch_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_batch_no.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_batch_no.setText("0");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Discount:");

        tf_disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_supplier)
                            .addComponent(tf_branch))
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_branch_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_supplier_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(tf_dd_month, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_dd_day, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_dd_year, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_dr_month, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_dr_day, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_dr_year))
                            .addComponent(tf_remarks)))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(tf_receipt_no))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_receipt_type, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addComponent(tf_receipt_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_reference_no))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_batch_no, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_receipt_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_receipt_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_receipt_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_receipt_no4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_disc, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_batch_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_receipt_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_receipt_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_receipt_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_receipt_no4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_receipt_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_receipt_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dd_month, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dd_day, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dd_year, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dr_month, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dr_day, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dr_year, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_disc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Post");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update Post");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Gross Total:");

        lbl_gross.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gross.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_gross.setText("0.00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Discount:");

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

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Net Total:");

        jButton6.setText("Finalize");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("State:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gross, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_net, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_discount)
                            .addComponent(jLabel20)
                            .addComponent(lbl_net))
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_gross, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Receipts", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_receipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_receipts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_receiptsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_receipts);

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
        jCheckBox1.setText("All");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/patch/download168 (1).png"))); // NOI18N
        jButton7.setToolTipText("Create Patch File");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/patch/open131.png"))); // NOI18N
        jButton8.setToolTipText("Open Patch File");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

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
        jCheckBox5.setText("All");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox1)
                                            .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField1))
                                .addGap(172, 172, 172)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(jLabel24)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 957, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reports", jPanel2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("State:");

        jProgressBar2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Barcode", jPanel8);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Item Ledger", jPanel11);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_receipt_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receipt_itemsMouseClicked
        update_queue();
    }//GEN-LAST:event_tbl_receipt_itemsMouseClicked

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_receipt();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_reference_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reference_noActionPerformed
        init_po_no();
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_supplierActionPerformed
        init_suppliers();
    }//GEN-LAST:event_tf_supplierActionPerformed

    private void tf_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branchActionPerformed
//        init_branch();
        init_branch_locations();
    }//GEN-LAST:event_tf_branchActionPerformed

    private void tf_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_supplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_supplierMouseClicked

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
        tf_search.grabFocus();
    }//GEN-LAST:event_tf_dr_yearActionPerformed

    private void tf_remarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarksActionPerformed
        tf_dd_month.grabFocus();
    }//GEN-LAST:event_tf_remarksActionPerformed

    private void tf_discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discountKeyReleased
        compute_discount();
    }//GEN-LAST:event_tf_discountKeyReleased

    private void tf_receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_receipt_noActionPerformed
        init_receipts();
    }//GEN-LAST:event_tf_receipt_noActionPerformed

    private void tf_receipt_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_receipt_typeActionPerformed
        init_receipt_types();
    }//GEN-LAST:event_tf_receipt_typeActionPerformed

    private void tf_supplier_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_supplier_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_supplier_idActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update_receipt();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_receiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseClicked
        select_receipts();
    }//GEN-LAST:event_tbl_receiptsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        init_receipt_no();
        tf_receipt_type.setText("");
        tf_receipt_type_id.setText("");
        tf_supplier.setText("");
        tf_supplier_id.setText("");
        tf_remarks.setText("");
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_M.fireTableDataChanged();
        tf_reference_no.setText("");
        tf_receipt_type.grabFocus();
        jButton1.setEnabled(true);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        compute();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_receiptsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_receiptsMouseEntered

    private void tbl_receiptsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMousePressed
        show_popup(evt);
    }//GEN-LAST:event_tbl_receiptsMousePressed

    private void tbl_receiptsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseReleased
        show_popup(evt);
    }//GEN-LAST:event_tbl_receiptsMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        finalize_receipt();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        finalize_receipt();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tf_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branchMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_branchMouseClicked

    private void tf_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch1MouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_branch1MouseClicked

    private void tf_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_branch1ActionPerformed
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
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JLabel lbl_batch_no;
    private javax.swing.JLabel lbl_gross;
    private javax.swing.JLabel lbl_net;
    private org.jdesktop.swingx.JXTable tbl_receipt_items;
    private javax.swing.JTable tbl_receipts;
    private javax.swing.JTextField tf_branch;
    private javax.swing.JTextField tf_branch1;
    private javax.swing.JTextField tf_branch_id;
    private javax.swing.JTextField tf_dd_day;
    private javax.swing.JTextField tf_dd_month;
    private javax.swing.JTextField tf_dd_year;
    private javax.swing.JTextField tf_disc;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_dr_day;
    private javax.swing.JTextField tf_dr_month;
    private javax.swing.JTextField tf_dr_year;
    private javax.swing.JTextField tf_receipt_no;
    private javax.swing.JTextField tf_receipt_no1;
    private javax.swing.JTextField tf_receipt_no2;
    private javax.swing.JTextField tf_receipt_no3;
    private javax.swing.JTextField tf_receipt_no4;
    private javax.swing.JTextField tf_receipt_type;
    private javax.swing.JTextField tf_receipt_type_id;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_supplier;
    private javax.swing.JTextField tf_supplier_id;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        tf_search.grabFocus();
        set_default_branch();
        focus();
        init_key();
        hover();
        search();
        init();
        init_receipt_no();
        init_tbl_receipt_items();
        init_tbl_receipts();
        select_type();

        set_date();
        set_d();
        add_my_barcode();
        item_ledger();
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        branch_location_list2 = branch_location_list;

        jLabel18.setVisible(false);
        tf_receipt_no1.setVisible(false);
        tf_receipt_no2.setVisible(false);
        jLabel21.setVisible(false);
        tf_receipt_no3.setVisible(false);
        tf_receipt_no4.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);

        tf_receipt_type_id.setVisible(false);
        tf_supplier_id.setVisible(false);
        tf_branch_id.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tf_receipt_no.grabFocus();
            }
        });
    }

    private void item_ledger() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                jPanel12.setLayout(new BorderLayout());
                Dlg_report_inventory_ledger dlg = new Dlg_report_inventory_ledger();
                jPanel12.add(dlg.getSurface());
            }
        });

    }
    String location_ids = "";
    List<S1_branch_locations.to_branch_locations> branch_locations = new ArrayList();

    private void set_default_branch() {
        Field.Combo combo = (Field.Combo) tf_branch;
        Field.Combo tf_rp_location = (Field.Combo) tf_branch1;
        branch_locations = S1_branch_locations.ret_where("");
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        location_ids = "" + to.id;
        my_location_id = "" + to.id;
        tf_receipt_no1.setText(to.branch);
        tf_receipt_no2.setText(to.branch_id);
        tf_receipt_no3.setText(to.location);
        tf_receipt_no4.setText("" + to.id);
        combo.setText(to.location + " - [" + to.branch + "]");
        combo.setId("" + to.id);
        tf_branch_id.setText("" + to.id);
        tf_rp_location.setText(to.location + " - [" + to.branch + "]");
        tf_rp_location.setId("" + to.id);
    }

    private void add_my_barcode() {
        Dlg_barcodes dlg = new Dlg_barcodes();
        jPanel9.setLayout(new BorderLayout());
        jPanel9.add(dlg.getSurface());
    }

    private void add_my_report() {
//        Dlg_report_receip_items_by_supplier dlg = new Dlg_report_receip_items_by_supplier();
//        jPanel5.setLayout(new BorderLayout());
//        jPanel5.add(dlg.getSurface());
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

    private void set_date() {
        testOfFaith.set(tf_dd_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_dd_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_dd_year, DateType.listYear(), "Year");

        testOfFaith.set(tf_dr_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_dr_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_dr_year, DateType.listYear(), "Year");
    }

    private void init_po_number() {
        String aw = Receipts.increment_id(my_location_id);
        tf_receipt_no.setText(aw);

    }

    private void select_type() {
        String receipt_type_id = tf_receipt_type_id.getText();
        if (receipt_type_id.equals("2")) {
            tf_reference_no.enable(true);
            tf_reference_no.grabFocus();
        } else {
            tf_reference_no.enable(false);
            tf_reference_no.setText("");
            tf_supplier.grabFocus();
            tbl_receipt_items_ALM.clear();
            tbl_receipt_items_M.fireTableDataChanged();
            compute();
        }
    }

    private void init_po_no() {
        String search = tf_reference_no.getText();
        List<S1_purchase_orders.to_purchase_orders> datas = S1_purchase_orders.ret_po_no(search);
        Object[][] obj = new Object[datas.size()][6];
        int i = 0;
        for (S1_purchase_orders.to_purchase_orders to : datas) {
            obj[i][0] = to.po_no;
            i++;
        }
        JLabel[] labels = {};
        int wid = tf_reference_no.getWidth();
        int[] tbl_widths_customers = {wid};
        String[] colNames = {"PO No."};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_reference_no, obj, labels, tbl_widths_customers, colNames);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                String[] output = data.output;
                tf_reference_no.setText(output[0]);
                select_po(output[0]);
            }
        });
    }

    private void select_po(String po_no) {
        List<to_receipt_items> acc = new ArrayList();
        List<S1_purchase_order_items.to_purchase_order_items> datas = S1_purchase_order_items.
                ret_data(po_no);
        for (S1_purchase_order_items.to_purchase_order_items to : datas) {
            int id = to.id;
            String receipt_no = tf_receipt_no.getText();
            String user_name = Users.user_name;
            String session_no = Users.session_no;
            String date_added = DateType.datetime.format(new Date());
            String supplier = tf_supplier.getText();
            String supllier_id = "0";
            String remarks = tf_remarks.getText();
            String barcode = to.barcode;
            String description = to.description;
            double qty = to.qty;
            double cost = to.cost;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_class = to.sub_class;
            String sub_class_id = to.sub_class_id;
            double total = qty * cost;
            double conversion = to.conversion;
            String unit = to.unit;
            String barcodes = "";
            String serial_no = "";
            String batch_no = lbl_batch_no.getText();
            String main_barcode = to.main_barcode;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            double previous_cost = to.cost;
            String branch = to.branch;
            String branch_id = to.branch_id;
            String location = to.location;
            String location_id = to.location_id;
            to_receipt_items t = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, conversion, unit, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id);

            acc.add(t);
        }

        loadData_receipt_items(acc);
        compute();
    }

    private void compute() {
        double discount = FitIn.toDouble(tf_disc.getText());
        double total = 0;
        List<to_receipt_items> acc = tbl_receipt_items_ALM;
        for (to_receipt_items to : acc) {
            total += to.total;
        }
        lbl_gross.setText(FitIn.fmt_wc_0(total));
        lbl_net.setText(FitIn.fmt_wc_0(total - discount));
    }

    private void focus() {
        tf_receipt_type_id.enable(false);
        JTextField[] tf = {tf_search, tf_reference_no, tf_supplier, tf_branch, tf_remarks, tf_dd_day, tf_dd_month, tf_dd_year, tf_dr_day, tf_dr_month, tf_dr_year, tf_receipt_no, tf_receipt_type, jTextField1, tf_disc};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    // <editor-fold defaultstate="collapsed" desc="settings">
    private void hover() {
    }
    int posX = 0, posY = 0;

    private void init() {
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

    private void search() {

    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 20));
    }

    private void exit2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(153, 153, 153));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    // </editor-fold>

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
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_CONTROL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_search.grabFocus();
                tf_search.selectAll();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbl_receipt_items_ALM.isEmpty()) {
                    tbl_receipt_items.setRowSelectionInterval(0, 0);
                    tbl_receipt_items.grabFocus();
                }
            }
        });

        tbl_receipt_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    edit_items();
                }
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    delete_items();
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    add_receipt();
                }
            }
        });
        tf_search.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    add_receipt();
                }

            }
        });
    }
    // </editor-fold>

    private ArrayListModel tbl_receipt_items_ALM;
    private Tblreceipt_itemsModel tbl_receipt_items_M;

    private void init_tbl_receipt_items() {
        tbl_receipt_items_ALM = new ArrayListModel();
        tbl_receipt_items_M = new Tblreceipt_itemsModel(tbl_receipt_items_ALM);
        tbl_receipt_items.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        tbl_receipt_items.setModel(tbl_receipt_items_M);
        tbl_receipt_items.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_items.setRowHeight(25);
        int[] tbl_widths_receipt_items = {70, 70, 100, 100, 100, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 4);
    }

    private void loadData_receipt_items(List<to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);
    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Cost", "Total", "", "", "remarks", "Item Code", "Description", "id", "Cost", "category", "category_id", "classification", "classification_id", "sub_class", "Total"
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
            to_receipt_items tt = (to_receipt_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.cost * tt.qty) + " ";
                case 5:
                    return " Update";
                case 6:
                    return " Delete";
                case 7:
                    return tt.remarks;
                case 8:
                    return tt.main_barcode;
                case 9:
                    return tt.description;
                case 10:
                    return tt.qty;
                case 11:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
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
                default:
                    return FitIn.fmt_wc_0(tt.qty * tt.cost);
            }
        }
    }

    private void data_cols_items() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        String where = " where receipt_no='" + to.receipt_no + "'";
        List<S1_receipt_items.to_receipt_items> datas = S1_receipt_items.ret_data5(where);

        List<to_receipt_items> datas2 = new ArrayList();
        for (S1_receipt_items.to_receipt_items rec : datas) {
            int id = rec.id;
            String receipt_no = rec.receipt_no;
            String user_name = rec.user_name;
            String session_no = rec.session_no;
            String date_added = rec.date_added;
            String supplier = rec.supplier;
            String supllier_id = rec.supllier_id;
            String remarks = rec.remarks;
            String barcode = rec.barcode;
            String description = rec.description;
            double qty = rec.qty;
            double cost = rec.cost;
            String category = rec.category;
            String category_id = rec.category_id;
            String classification = rec.classification;
            String classification_id = rec.classification_id;
            String sub_class = rec.sub_class;
            String sub_class_id = rec.sub_class_id;
            double total = qty * cost;
            double conversion = rec.conversion;
            String unit = rec.unit;
            String barcodes = rec.barcodes;
            String serial_nos = rec.serial_no;
            String batch_no = rec.batch_no;
            String main_barcode = rec.main_barcode;
            String brand = rec.brand;
            String brand_id = rec.brand_id;
            String model = rec.model;
            String model_id = rec.model_id;
            double previous_cost = rec.previous_cost;
            String branch = rec.branch;
            String branch_id = rec.branch_id;
            String location = rec.location;
            String location_id = rec.location_id;

            to_receipt_items d = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, conversion, unit, barcodes, serial_nos, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id);
            datas2.add(d);
        }
        loadData_receipt_items(datas2);
    }

    private void add_items() {
        final List<to_receipt_items> datas = tbl_receipt_items_ALM;
        final List<to_receipt_items> acc = new ArrayList();
        acc.addAll(datas);
        final Inventory_barcodes.to_inventory_barcodes to = inventory_barcoders_list.get(selected_row);
        Window p = (Window) this;
        Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
        nd.setTitle("");
        nd.do_pass2(0, to.cost, to.description, to.unit, to.barcode, to.barcode, to.product_qty, to.main_barcode);
        nd.setCallback(new Dlg_qty_cost.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                closeDialog.ok();
                int id = -1;
                String receipt_no = "0";//S1_re.increment_id();
                String user_name = Users.user_name;
                String session_no = Users.session_no;
                String date_added = DateType.datetime.format(new Date());
                String supplier = to.supplier;
                String supllier_id = "0";
                String remarks = tf_remarks.getText();
                String barcode = to.barcode;
                String description = to.description;
                double qty = data.amount;
                double cost = data.cost;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_class = to.sub_classification;
                String sub_class_id = to.sub_classification_id;
                double total = qty * cost;
                String barcodes = data.barcodes;
                String serial_no = data.serial_nos;
                String batch_no = lbl_batch_no.getText();
                String main_barcode = to.main_barcode;
                String brand = to.brand;
                String brand_id = to.brand_id;
                String model = to.model;
                String model_id = to.model_id;
                double previous_cost = to.cost;
                String receipt_type_id = "";
                String branch = to.branch;
                String branch_id = to.branch_code;
                String location = to.location;
                String location_id = to.location_id;
                String date_delivered = tf_dd_month.getText() + " " + tf_dd_day.
                        getText() + ", " + tf_dd_year.getText();
                date_delivered = DateType.convert_monthDate_sf(date_delivered);
                String date_received = tf_dr_month.getText() + " " + tf_dr_day.getText() + ", " + tf_dr_year.
                        getText();
                date_received = DateType.convert_monthDate_sf(date_received);
                to_receipt_items to2 = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, to.conversion, to.unit, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id);
                int naa = 0;
                for (to_receipt_items to3 : datas) {
                    if (to3.barcode.equals(to2.barcode) && to3.unit.
                            equals(to2.unit) && to3.main_barcode.
                            equals(to2.main_barcode)) {
                        naa = 1;
                        double n_qty = data.amount + to3.qty;
                        to3.setQty(n_qty);
                        to3.setCost(cost);
                        tbl_receipt_items_M.fireTableDataChanged();
                        break;
                    } else {
                        naa = 0;
                    }
                }
                if (naa == 0) {
                    if (jButton1.isEnabled()) {
                        acc.add(to2);
                        loadData_receipt_items(acc);
                    } else {
                        int row = tbl_receipts.getSelectedRow();
                        if (row < 0) {
                            return;
                        }
                        to_receipts too = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
                        List<S1_receipt_items.to_receipt_items> d = new ArrayList();
                        String sup = supplier;
                        String sup_id = supllier_id;
                        int status = 0;
                        S1_receipt_items.to_receipt_items to4 = new S1_receipt_items.to_receipt_items(id, receipt_no, user_name, session_no, date_added, sup, sup_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, to.conversion, to.unit, date_delivered, date_received, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, location, location_id, location, location_id);
                        d.add(to4);
                        S1_receipt_items.add_receipt_items(d, too.receipt_no);
                        data_cols_items();
                        compute();
                    }
                }

                tf_search.grabFocus();
                tf_search.selectAll();
                compute();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void delete_items() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_receipt_items_ALM.remove(row);
        tbl_receipt_items_M.fireTableDataChanged();
        tf_search.grabFocus();
        tf_search.selectAll();
    }

    private void edit_items() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_receipt_items to = (to_receipt_items) tbl_receipt_items_ALM.
                get(tbl_receipt_items.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.qty, to.cost, to.description, to.unit, to.barcode, to.barcodes, to.barcodes, to.serial_nos, 0, to.main_barcode);
        nd.setCallback(new Dlg_qty_cost.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                closeDialog.ok();
                double n_qty = data.amount;
                to.setQty(n_qty);
                to.setSerial_nos(data.serial_nos);
                tbl_receipt_items_M.fireTableDataChanged();
                tf_search.grabFocus();
                tf_search.selectAll();
                compute();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void add_receipt() {
        if (tbl_receipt_items_ALM.isEmpty()) {
            Alert.set(0, "NO RECORD");
            return;
        }
        Field.Combo combo = (Field.Combo) tf_branch;
        int id = -1;
        String aw = Receipts.increment_id(combo.getId());
        String receipt_no = aw;
        String where = " where receipt_no='" + receipt_no + "' ";
        List<Receipts.to_receipts> datas2 = Receipts.ret_data3(where);
        if (!datas2.isEmpty()) {
            Alert.set(0, "Transaction No. Already Exist,");
            return;
        }
        String user_name = Users.user_name;
        String session_no = Users.session_no;
        String date_added = DateType.datetime.format(new Date());
        String supplier = tf_supplier.getText();
        String supllier_id = tf_supplier_id.getText();
        String remarks = tf_remarks.getText();
        String date_delivered = tf_dd_month.getText() + " " + tf_dd_day.
                getText() + ", " + tf_dd_year.getText();
        date_delivered = DateType.convert_monthDate_sf(date_delivered);
        String date_received = tf_dr_month.getText() + " " + tf_dr_day.getText() + ", " + tf_dr_year.
                getText();
        date_received = DateType.convert_monthDate_sf(date_received);
        String receipt_type = tf_receipt_type.getText();
        String reference_no = tf_reference_no.getText();
        String branch = combo.getText();
        String branch_id = combo.getId();
        double gross_total = FitIn.toDouble(lbl_gross.getText());
        double net_total = FitIn.toDouble(lbl_net.getText());
        String batch_no = lbl_batch_no.getText();
        double discount = FitIn.toDouble(tf_disc.getText());
        String receipt_type_id = tf_receipt_type_id.getText();
        Receipts.to_receipts to1 = new Receipts.to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, 0);

        List<S1_receipt_orders.to_receipt_items> datas = tbl_receipt_items_ALM;
        List<S1_receipt_items.to_receipt_items> acc = new ArrayList();
        for (S1_receipt_orders.to_receipt_items to3 : datas) {
            String barcode = to3.barcode;
            String description = to3.description;
            double qty = to3.qty;
            double cost = to3.cost;
            String category = to3.category;
            String category_id = to3.category_id;
            String classification = to3.classification;
            String classification_id = to3.classification_id;
            String sub_class = to3.sub_class;
            String sub_class_id = to3.sub_class_id;
            String sup = supplier;
            String sup_id = supllier_id;
            String barcodes = to3.barcodes;
            String serial_no = to3.serial_nos;
            String main_barcode = to3.main_barcode;
            String brand = to3.brand;
            String brand_id = to3.brand_id;
            String model = to3.model;
            String model_id = to3.model_id;
            int status = 0;
            double previous_cost = to3.previous_cost;
            String location = combo.getText();
            String location_id = combo.getId();
            S1_receipt_items.to_receipt_items to4 = new S1_receipt_items.to_receipt_items(id, receipt_no, user_name, session_no, date_added, sup, sup_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, to3.conversion, to3.unit, date_delivered, date_received, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id, location, location_id);
            acc.add(to4);
        }
        Receipts.add_receipts(to1, acc);
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_M.fireTableDataChanged();
        Alert.set(1, remarks);
        tf_search.grabFocus();
        tf_search.selectAll();
        init_receipt_no();
        compute();
        data_cols();

    }

    private void init_receipt_no() {
        Field.Combo combo = (Field.Combo) tf_branch;
        String aw = Receipts.increment_id(combo.getId());
        String receipt_no = aw;
        tf_receipt_no.setText(receipt_no);
        System.out.println("Location Id: " + combo.getId());
        System.out.println("Transaction No.: " + receipt_no);

    }
    List<S1_suppliers.to_suppliers> supplier_list = new ArrayList();

    private void init_suppliers() {
        String search = tf_supplier.getText();
        supplier_list.clear();
        supplier_list = S1_suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list.size()][2];
        int i = 0;
        for (S1_suppliers.to_suppliers to : supplier_list) {
            obj[i][0] = to.customer_no;
            obj[i][1] = to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 350};
        String[] col_names = {"ID", "NAME"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_supplier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_suppliers.to_suppliers to = supplier_list.
                        get(data.selected_row);
                tf_supplier.setText(to.customer_name);
                tf_supplier_id.setText(to.customer_no);
                tf_branch.grabFocus();
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();
    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void init_branch_locations() {
        if(!jButton1.isEnabled()){
            return;
        }
        String search = tf_branch.getText();
        String branch_id = tf_receipt_no2.getText();

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

                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);

                combo.setText(to.location + " - [" + to.branch + "]");
                combo.setId("" + to.id);
                System.out.println("Location Id: " + combo.getId());
                tf_branch_id.setText("" + to.id);
                my_branch = to.branch;
                my_branch_id = to.branch_id;
                my_location = to.location;
                my_location_id = "" + to.id;
                tf_remarks.grabFocus();
                location_ids = "" + to.id;
                init_receipt_no();
            }
        });
    }

    private void init_branch_locations2() {
        final Field.Combo tf_rp_location = (Field.Combo) tf_branch1;

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
                setPopup(tf_rp_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_rp_location.setText(to.location + " - [" + to.branch + "]");
                tf_rp_location.setId("" + to.id);
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
                System.out.println(where);
                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);

                if (inventory_barcoders_list.isEmpty()) {
                    update_barcode();
                }
                if (inventory_barcoders_list.size() >= 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        obj[i][3] = " " + to.unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.cost);
                        obj[i][5] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 100, w, 30, 50, 50};
                    String[] col_names = {"Qty", "ItemCode", "Description", "Unit", "Cost", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            selected_row = data.selected_row;
                            add_items();
                        }
                    });
                }
            }
        });
        t.start();
    }

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

    int selected_row = -1;

    private void compute_discount() {
        double total_gross = FitIn.toDouble(lbl_gross.getText());
        double discount = FitIn.toDouble(tf_discount.getText());
        double net = total_gross - discount;
        lbl_net.setText(FitIn.fmt_wc_0(net));
    }

    private void add_barcode() {
        Window p = (Window) this;
        Dlg_barcodes nd = Dlg_barcodes.create(p, true);
        nd.setTitle("");
        nd.do_pass(tf_search.getText());
        nd.setCallback(new Dlg_barcodes.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_barcodes.OutputData data) {
                closeDialog.ok();
                tf_search.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<Receipts.to_receipts> receipt_list = new ArrayList();

    private void init_receipts() {
        String search = tf_receipt_no.getText();
        receipt_list.clear();
        receipt_list = Receipts.ret_data(search);
        if (receipt_list.isEmpty()) {
            tf_receipt_type.grabFocus();
        } else {
            Object[][] obj = new Object[receipt_list.size()][1];
            int i = 0;
            for (Receipts.to_receipts to : receipt_list) {
                obj[i][0] = " " + to.receipt_no;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {200};
            int width = 0;
            String[] col_names = {"Transaction #"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_receipt_no, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Receipts.to_receipts to = receipt_list.
                            get(data.selected_row);
                    Receipts.to_receipts t = receipt_list.get(data.selected_row);
                    tf_receipt_no.setText(t.receipt_no);
                    tf_receipt_no.setEnabled(false);
                    select_transaction();
                }
            });
        }

    }

    private void select_transaction() {

        String where2 = " where receipt_no = '" + tf_receipt_no.getText() + "' ";
        to_receipts to = Receipts.to(where2);
        tf_receipt_no.setText(to.receipt_no);
        tf_receipt_type.setText(to.receipt_type);
        tf_receipt_type_id.setText(to.receipt_type_id);

        tf_supplier.setText(to.supplier);
        tf_supplier_id.setText(to.supllier_id);
        tf_branch.setText(to.branch);
        tf_branch_id.setText(to.branch_id);
        tf_remarks.setText(to.remarks);
        tf_disc.setText(FitIn.fmt_wc_0(to.discount));
        tf_discount.setText(FitIn.fmt_wc_0(to.discount));

        try {
            Date delivered = DateType.sf.parse(to.date_delivered);
            String d_month = DateType.m.format(delivered);
            String d_day = DateType.d.format(delivered);
            String d_year = DateType.y.format(delivered);
            tf_dd_month.setText(d_month);
            tf_dd_day.setText(d_day);
            tf_dd_year.setText(d_year);

            Date received = DateType.sf.parse(to.date_received);
            String r_month = DateType.m.format(received);
            String r_day = DateType.d.format(received);
            String r_year = DateType.y.format(received);
            tf_dr_month.setText(r_month);
            tf_dr_day.setText(r_day);
            tf_dr_year.setText(r_year);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_receipts.class.getName()).log(Level.SEVERE, null, ex);
        }
        tf_reference_no.setText(to.reference_no);

        String where = " where receipt_no='" + to.receipt_no + "'";
        List<S1_receipt_items.to_receipt_items> datas = S1_receipt_items.ret_data5(where);

        double total1 = 0;
        for (S1_receipt_items.to_receipt_items t : datas) {
            total1 += t.qty * t.cost;
        }
        lbl_gross.setText(FitIn.fmt_wc_0(total1));
        lbl_net.setText(FitIn.fmt_wc_0(total1 - to.discount));

        jTabbedPane1.setSelectedIndex(0);
        jButton1.setEnabled(false);
        jButton3.setEnabled(true);

        if (to.status == 0) {
            jButton6.setEnabled(true);
        } else {
            jButton6.setEnabled(false);
        }

        List<to_receipt_items> datas2 = new ArrayList();
        for (S1_receipt_items.to_receipt_items rec : datas) {
            int id = rec.id;
            String receipt_no = rec.receipt_no;
            String user_name = rec.user_name;
            String session_no = rec.session_no;
            String date_added = rec.date_added;
            String supplier = rec.supplier;
            String supllier_id = rec.supllier_id;
            String remarks = rec.remarks;
            String barcode = rec.barcode;
            String description = rec.description;
            double qty = rec.qty;
            double cost = rec.cost;
            String category = rec.category;
            String category_id = rec.category_id;
            String classification = rec.classification;
            String classification_id = rec.classification_id;
            String sub_class = rec.sub_class;
            String sub_class_id = rec.sub_class_id;
            double total = qty * cost;
            double conversion = rec.conversion;
            String unit = rec.unit;
            String barcodes = rec.barcodes;
            String serial_nos = rec.serial_no;
            String batch_no = rec.batch_no;
            String main_barcode = rec.main_barcode;
            String brand = rec.brand;
            String brand_id = rec.brand_id;
            String model = rec.model;
            String model_id = rec.model_id;
            double previous_cost = rec.previous_cost;
            String branch = rec.branch;
            String branch_id = rec.branch_id;
            String location = rec.location;
            String location_id = rec.location_id;

            to_receipt_items d = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, conversion, unit, barcodes, serial_nos, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id);
            datas2.add(d);
        }
        loadData_receipt_items(datas2);
        tf_receipt_no.setEnabled(true);
    }
    List<Courier.status> receipt_type_list = new ArrayList();

    private void init_receipt_types() {
        String search = tf_receipt_type.getText();
        receipt_type_list.clear();
        receipt_type_list = Courier.receipt_types();
        Object[][] obj = new Object[receipt_type_list.size()][1];
        int i = 0;
        for (Courier.status to : receipt_type_list) {
            obj[i][0] = to.status;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {"Tramsaction #"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_receipt_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Courier.status to = receipt_type_list.get(data.selected_row);
                tf_receipt_type_id.setText("" + to.id);
                tf_receipt_type.setText("" + to.status);
                select_type();
            }
        });
    }

    private ArrayListModel tbl_receipts_ALM;
    private TblreceiptsModel tbl_receipts_M;

    private void init_tbl_receipts() {
        tbl_receipts_ALM = new ArrayListModel();
        tbl_receipts_M = new TblreceiptsModel(tbl_receipts_ALM);
        tbl_receipts.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_receipts.setModel(tbl_receipts_M);
        tbl_receipts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipts.setRowHeight(25);
        int[] tbl_widths_receipts = {100, 80, 100, 170, 70, 50, 50, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipts, i, tbl_widths_receipts[i]);
        }
        Dimension d = tbl_receipts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_receipts.getTableHeader().setPreferredSize(d);
        tbl_receipts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_receipts.setRowHeight(25);
        tbl_receipts.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 4);

    }

    private void loadData_receipts(List<to_receipts> acc) {
        tbl_receipts_ALM.clear();
        tbl_receipts_ALM.addAll(acc);
    }

    public static class TblreceiptsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "Supplier", "Location", "Gross Total", "", "", "", "", "date_received", "receipt_type", "reference_no", "branch", "branch_id", "gross_total", "net_total", "batch_no", "discount", "receipt_type_id"
        };

        public TblreceiptsModel(ListModel listmodel) {
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
            to_receipts tt = (to_receipts) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.receipt_no;
                case 1:
                    return " " + DateType.convert_slash_datetime2(tt.date_received);
                case 2:
                    return " " + tt.supplier;
                case 3:
                    return " " + tt.branch;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.gross_total) + " ";
                case 5:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 6:
                    return " Update";
                case 7:
                    return " Delete";
                case 8:
                    return " Print";
                case 9:
                    return tt.date_received;
                case 10:
                    return tt.receipt_type;
                case 11:
                    return tt.reference_no;
                case 12:
                    return tt.branch;
                case 13:
                    return tt.branch_id;
                case 14:
                    return tt.gross_total;
                case 15:
                    return tt.net_total;
                case 16:
                    return tt.batch_no;
                case 17:
                    return tt.discount;
                default:
                    return tt.receipt_type_id;
            }
        }
    }

    private void data_cols() {
        final Field.Combo tf_rp_location = (Field.Combo) tf_branch1;
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        String where = " where date(date_added) between '" + date_from + "' and '" + date_to + "' "
                + " and receipt_no like '%" + jTextField1.getText() + "%'  ";

        if (!jCheckBox1.isSelected()) {
            where = " where receipt_no like '%" + jTextField1.getText() + "%'  ";
        }
        if (jCheckBox3.isSelected()) {
            where = where + " and status='" + "0" + "' ";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " and status='" + "1" + "' ";
        }
        if (!jCheckBox5.isSelected()) {
            where = where + " and branch_id ='" + tf_rp_location.getId() + "'";
        }
        where = where + " order by id desc ";
        loadData_receipts(Receipts.ret_data4(where));
        jLabel7.setText("" + tbl_receipts_ALM.size());
    }

    private void update_receipt() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Receipt-Status [Finalized]!");
            return;
        }
        int id = to.id;
        String receipt_no = to.receipt_no;
        String user_name = Users.user_name;
        String session_no = Users.session_no;
        String date_added = DateType.datetime.format(new Date());
        String supplier = tf_supplier.getText();
        String supllier_id = tf_supplier_id.getText();
        String remarks = tf_remarks.getText();
        String date_delivered = tf_dd_month.getText() + " " + tf_dd_day.
                getText() + ", " + tf_dd_year.getText();
        date_delivered = DateType.convert_monthDate_sf(date_delivered);
        String date_received = tf_dr_month.getText() + " " + tf_dr_day.getText() + ", " + tf_dr_year.getText();
        date_received = DateType.convert_monthDate_sf(date_received);
        String receipt_type = tf_receipt_type.getText();
        String reference_no = tf_reference_no.getText();
        String branch = tf_branch.getText();
        String branch_id = tf_branch_id.getText();
        double gross_total = FitIn.toDouble(lbl_gross.getText());
        double net_total = FitIn.toDouble(lbl_net.getText());
        String batch_no = lbl_batch_no.getText();
        double discount = FitIn.toDouble(tf_disc.getText());
        String receipt_type_id = tf_receipt_type_id.getText();
        Receipts.to_receipts to1 = new Receipts.to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, to.status);
        Receipts.edit_receipts2(to1);
        Alert.set(2, remarks);
        data_cols();
        tbl_receipts.setRowSelectionInterval(row, row);
    }

    private void select_receipts() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_receipts.getSelectedColumn();
        to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        tf_receipt_no.setText(to.receipt_no);
        tf_receipt_type.setText(to.receipt_type);
        tf_receipt_type_id.setText(to.receipt_type_id);
        tf_supplier.setText(to.supplier);
        tf_supplier_id.setText(to.supllier_id);
        Field.Combo br = (Field.Combo) tf_branch;
        br.setText(to.branch);
        br.setId("" + to.branch_id);

        tf_branch_id.setText(to.branch_id);
        tf_remarks.setText(to.remarks);
        tf_disc.setText(FitIn.fmt_wc_0(to.discount));
        tf_discount.setText(FitIn.fmt_wc_0(to.discount));

        data_cols_items();

        try {
            Date delivered = DateType.sf.parse(to.date_delivered);
            String d_month = DateType.m.format(delivered);
            String d_day = DateType.d.format(delivered);
            String d_year = DateType.y.format(delivered);
            tf_dd_month.setText(d_month);
            tf_dd_day.setText(d_day);
            tf_dd_year.setText(d_year);

            Date received = DateType.sf.parse(to.date_received);
            String r_month = DateType.m.format(received);
            String r_day = DateType.d.format(received);
            String r_year = DateType.y.format(received);
            tf_dr_month.setText(r_month);
            tf_dr_day.setText(r_day);
            tf_dr_year.setText(r_year);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_receipts.class.getName()).log(Level.SEVERE, null, ex);
        }
        tf_reference_no.setText(to.reference_no);
        List<to_receipt_items> datas = tbl_receipt_items_ALM;
        double total = 0;
        for (to_receipt_items t : datas) {
            total += t.qty * t.cost;
        }
        lbl_gross.setText(FitIn.fmt_wc_0(total));
        lbl_net.setText(FitIn.fmt_wc_0(total - to.discount));
        if (col == 6) {
            jTabbedPane1.setSelectedIndex(0);
            jButton1.setEnabled(false);
            jButton3.setEnabled(true);
            
            if (to.status == 0) {
                jButton6.setEnabled(true);
            } else {
                jButton6.setEnabled(false);
            }

        }
        if (col == 7) {
            delete_receipts();
        }
        if (col == 8) {
            set_report();
            jTabbedPane1.setSelectedIndex(2);
        }
    }

    private void delete_receipts() {
        final int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot delete finalized transaction!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();

                if (to.status == 1) {
                    Alert.set(0, "Receipt-Status [Finalized]!");
                    return;
                }
                Receipts.delete_receipts(to);
                data_cols();
                tbl_receipt_items_ALM.clear();
                tbl_receipt_items_M.fireTableDataChanged();

                tf_receipt_type.setText("");
                tf_receipt_type_id.setText("");
                tf_supplier.setText("");
                tf_supplier_id.setText("");
                tf_branch.setText("");
                tf_branch_id.setText("");
                tf_remarks.setText("");
                tf_reference_no.setText("");
                tf_receipt_type.grabFocus();
                compute();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void update_queue() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_receipt_items.getSelectedColumn();
        final to_receipt_items to = (to_receipt_items) tbl_receipt_items_ALM.get(tbl_receipt_items.convertRowIndexToModel(row));

        if (col == 5) {
            if (jButton1.isEnabled()) {
                Window p = (Window) this;
                Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.qty, to.cost, to.description, to.unit, to.barcode, to.barcodes, to.barcodes, to.serial_nos, 0, to.main_barcode);
                nd.setCallback(new Dlg_qty_cost.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                        closeDialog.ok();
                        double n_qty = data.amount;
                        to.setQty(n_qty);
                        to.setSerial_nos(data.serial_nos);
                        tbl_receipt_items_M.fireTableDataChanged();
                        tf_search.grabFocus();
                        tf_search.selectAll();
                        compute();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            } else {
                int row2 = tbl_receipts.getSelectedRow();
                if (row2 < 0) {
                    return;
                }
                to_receipts to2 = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row2));
                if (to2.status == 1) {
                    Alert.set(0, "Receipt-Status [Finalized]!");
                    return;
                }
                Window p = (Window) this;
                Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.qty, to.cost, to.description, to.unit, to.barcode, to.barcodes, to.barcodes, to.serial_nos, 0, to.main_barcode);
                nd.setCallback(new Dlg_qty_cost.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                        closeDialog.ok();
                        S1_receipt_items.edit_receipt_items2("" + to.id, data.amount, data.cost, data.serial_nos);
                        data_cols_items();
                        compute();
                        double gross_amount = FitIn.toDouble(lbl_gross.getText());
                        Receipts.update_gross(to.receipt_no, gross_amount);
                        int row = tbl_receipts.getSelectedRow();
                        if (row < 0) {
                            return;
                        }
                        data_cols();
                        compute();
                        tbl_receipts.setRowSelectionInterval(row, row);

                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
        if (col == 6) {
            if (jButton1.isEnabled()) {
                tbl_receipt_items_ALM.remove(row);
                tbl_receipt_items_M.fireTableDataChanged();
                compute();
            } else {
                int row2 = tbl_receipts.getSelectedRow();
                if (row2 < 0) {
                    return;
                }
                to_receipts to2 = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row2));
                if (to2.status == 1) {
                    Alert.set(0, "Receipt-Status [Finalized]!");
                    return;
                }
                Window p = (Window) this;
                Dlg_my_service_confirm nd = Dlg_my_service_confirm.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_my_service_confirm.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_my_service_confirm.OutputData data) {
                        closeDialog.ok();
                        S1_receipt_items.delete_receipt_items4("" + to.id);
                        data_cols_items();
                        compute();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);

            }
        }
    }

    private void set_report() {

        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_receipts to1 = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));

        jProgressBar2.setString("Loading... Please wait...");
        jProgressBar2.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Srpt_receipts.field> fields = new ArrayList();
                List<to_receipt_items> datas = tbl_receipt_items_ALM;
                for (to_receipt_items to : datas) {
                    String serial = to.serial_nos.replaceAll("\n", "        ");
                    Srpt_receipts.field f = new Srpt_receipts.field(to.qty, to.main_barcode, to.barcode, to.description, serial, to.cost, to.qty * to.cost);
                    fields.add(f);
                }
                String transaction_no = to1.receipt_no;
                String transaction_type = to1.receipt_type;
                String supplier = to1.supplier;
                String receiving_location = to1.branch;
                String reference_no = to1.remarks;
                String date_of_delivery = DateType.convert_dash_date2(to1.date_added);
                String date_received = DateType.convert_dash_date2(to1.date_received);
                double gross = to1.gross_total;
                double discount = to1.discount;
                Srpt_receipts rpt = new Srpt_receipts(transaction_no, transaction_type, supplier, receiving_location, reference_no, date_of_delivery, date_received, gross, discount);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_receipts.jrxml";
                report_customers_aging(rpt, jrxml);
                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_receipts to, String jrxml_name) {
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

    public static JRViewer get_viewer_customers_aging(Srpt_receipts to, String rpt_name) {
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
            InputStream is = Srpt_receipts.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void show_popup(MouseEvent evt) {
        String where = " where user_name='" + Users.user_name + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        int exists = 0;
        for (S1_user_previleges.to_user_previleges to : datas) {
            if (to.previledge.equalsIgnoreCase("Finalize Receipt")) {
                exists = 1;
                break;
            }
        }

        if (exists == 1) {
            if (evt.isPopupTrigger()) {
                jPopupMenu1.show(tbl_receipts, evt.getX(), evt.getY());
            }
        }
    }

    private void finalize_receipt() {
        final int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }

        final to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Receipt-Status [Finalized]!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                List<to_receipt_items> datas = tbl_receipt_items_ALM;
                List<S1_receipt_items.to_receipt_items> acc = new ArrayList();
                for (to_receipt_items to3 : datas) {
                    String barcode = to3.barcode;
                    String description = to3.description;
                    double qty = to3.qty;
                    double cost = to3.cost;
                    String category = to3.category;
                    String category_id = to3.category_id;
                    String classification = to3.classification;
                    String classification_id = to3.classification_id;
                    String sub_class = to3.sub_class;
                    String sub_class_id = to3.sub_class_id;
                    String sup = to3.supplier;
                    String sup_id = to3.supllier_id;
                    String barcodes = to3.barcodes;
                    String serial_no = to3.serial_nos;
                    String main_barcode = to3.main_barcode;
                    String brand = to3.brand;
                    String brand_id = to3.brand_id;
                    String model = to3.model;
                    String model_id = to3.model_id;
                    int status = 0;
                    double previous_cost = to3.previous_cost;
                    String receipt_type_id = "";
                    String location = tf_branch.getText();
                    String location_id = tf_branch_id.getText();
                    S1_receipt_items.to_receipt_items to4 = new S1_receipt_items.to_receipt_items(to3.id, to3.receipt_no, to3.user_name, to3.session_no, to3.date_added, sup, sup_id, to3.remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, to3.conversion, to3.unit, "", "", barcodes, serial_no, to3.batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, to3.branch, to3.branch_id, to3.location, to3.location_id);
                    acc.add(to4);
                }
                String branch = "";
                String branch_id = "";
                for (S1_branch_locations.to_branch_locations t : branch_locations) {
                    if (to.branch_id.equalsIgnoreCase("" + t.id)) {
                        branch = t.branch;
                        branch_id = t.branch_id;
                        break;
                    }
                }
                Receipts.finalize(to, acc, branch, branch_id);
                data_cols();
                Alert.set(2, "");
                jButton6.setEnabled(false);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
}
