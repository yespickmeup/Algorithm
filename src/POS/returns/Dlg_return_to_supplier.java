/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.inventory_reports.Dlg_report_inventory_ledger;
import POS.returns.Return_to_supplier.to_return_to_suppliers;
import POS.returns.Return_to_supplier_items.to_return_to_supplier_items;
import POS.suppliers.Suppliers;
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
import java.awt.event.KeyAdapter;
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

/**
 *
 * @author Guinness
 */
public class Dlg_return_to_supplier extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_return_to_supplier
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
    private Dlg_return_to_supplier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_return_to_supplier(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_return_to_supplier() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_return_to_supplier myRef;

    private void setThisRef(Dlg_return_to_supplier myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_return_to_supplier> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_return_to_supplier create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_return_to_supplier create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_return_to_supplier dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_return_to_supplier((java.awt.Frame) parent, false);
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
            Dlg_return_to_supplier dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_return_to_supplier((java.awt.Dialog) parent, false);
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

        Dlg_return_to_supplier dialog = Dlg_return_to_supplier.create(new javax.swing.JFrame(), true);
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
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_receipt_no = new Field.Input();
        jLabel11 = new javax.swing.JLabel();
        tf_supplier = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        tf_branch = new Field.Combo();
        jLabel13 = new javax.swing.JLabel();
        tf_remarks = new Field.Input();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new Button.Default();
        jButton4 = new Button.Primary();
        jButton7 = new Button.Info();
        jButton8 = new Button.Success();
        jLabel15 = new javax.swing.JLabel();
        tf_branch1 = new Field.Combo();
        jTextArea1 = new Field.Input();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_search1 = new Field.Input();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_return_to_supplier_items = new org.jdesktop.swingx.JXTable();
        jLabel18 = new javax.swing.JLabel();
        lbl_gross1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel19 = new javax.swing.JLabel();
        lbl_gross2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_return_to_suppliers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jTextField2 = new Field.Combo();
        jLabel29 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        tf_branch2 = new Field.Combo();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton6 =  new Button.Default();
        tf_branch3 = new Field.Combo();
        jCheckBox11 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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
        tf_branch.setFocusable(false);
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
        jLabel14.setText("Remarks:");

        jButton5.setText("New Post");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Post");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Update Post");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Finalize");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Branch:");

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

        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextArea1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Date:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_receipt_no)
                    .addComponent(tf_branch, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addComponent(tf_supplier)
                    .addComponent(tf_branch1))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextArea1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tf_remarks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jXPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Search:");

        tf_search1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jScrollPane4.setOpaque(false);

        tbl_return_to_supplier_items.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_return_to_supplier_items.setOpaque(false);
        tbl_return_to_supplier_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_return_to_supplier_itemsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_return_to_supplier_items);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Gross Total:");

        lbl_gross1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gross1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_gross1.setText("0.00");

        jLabel2.setText("State:");

        jProgressBar2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Total Items:");

        lbl_gross2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gross2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_gross2.setText("0");

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(tf_search1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE))
                    .addGroup(jXPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gross2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gross1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel4Layout.createSequentialGroup()
                .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_gross1)))
                    .addGroup(jXPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_gross2)))))
                .addGap(12, 12, 12))
        );

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Filter by:");

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("[F2]-Item Code");
        jCheckBox7.setFocusable(false);

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Barcode");
        jCheckBox8.setFocusable(false);

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("[F4]-Description");
        jCheckBox9.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addGap(1, 1, 1)
                .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return to Supplier", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_return_to_suppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_return_to_suppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_return_to_suppliersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_return_to_suppliers);

        jLabel1.setText("Total no. of transactions:");

        jLabel3.setText("0");

        jPanel5.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Date From:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("To:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Supplier:");

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("All");

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

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Branch:");

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");

        tf_branch2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch2MouseClicked(evt);
            }
        });
        tf_branch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch2ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Status:");

        buttonGroup2.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        buttonGroup2.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Posted");

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Finalized");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Search:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tf_branch3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch3.setFocusable(false);
        tf_branch3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch3MouseClicked(evt);
            }
        });
        tf_branch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch3ActionPerformed(evt);
            }
        });

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("All");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Location:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jCheckBox1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jCheckBox11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_branch3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_branch3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Reports", jPanel3);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("State:");

        jProgressBar3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Item Ledger", jPanel8);

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

    private void tf_receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_receipt_noActionPerformed
//        init_receipts();
    }//GEN-LAST:event_tf_receipt_noActionPerformed

    private void tf_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_supplierMouseClicked
        init_suppliers(tf_supplier);
    }//GEN-LAST:event_tf_supplierMouseClicked

    private void tf_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_supplierActionPerformed
        init_suppliers(tf_supplier);

    }//GEN-LAST:event_tf_supplierActionPerformed

    private void tf_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branchMouseClicked
//        init_branch_locations();
    }//GEN-LAST:event_tf_branchMouseClicked

    private void tf_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branchActionPerformed

    }//GEN-LAST:event_tf_branchActionPerformed

    private void tf_remarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarksActionPerformed
//        tf_dd_month.grabFocus();
    }//GEN-LAST:event_tf_remarksActionPerformed

    private void tf_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search1ActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_search1ActionPerformed

    private void tf_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search1KeyReleased

    }//GEN-LAST:event_tf_search1KeyReleased

    private void tbl_return_to_supplier_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_return_to_supplier_itemsMouseClicked
        edit_return();
    }//GEN-LAST:event_tbl_return_to_supplier_itemsMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        post_return();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear_returns();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        update_return_to_supplier();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        finalize_return_to_supplier();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tf_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch1MouseClicked
        init_branch_locations(tf_branch1, tf_branch);
    }//GEN-LAST:event_tf_branch1MouseClicked

    private void tf_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch1ActionPerformed
        init_branch_locations(tf_branch1, tf_branch);
    }//GEN-LAST:event_tf_branch1ActionPerformed

    private void jTextArea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextArea1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked

    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_suppliers(jTextField2);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tf_branch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch2MouseClicked
        init_branch_locations(tf_branch2, tf_branch3);
    }//GEN-LAST:event_tf_branch2MouseClicked

    private void tf_branch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch2ActionPerformed
        init_branch_locations(tf_branch2, tf_branch3);
    }//GEN-LAST:event_tf_branch2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ret_returns();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_branch3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_branch3MouseClicked

    private void tf_branch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_branch3ActionPerformed

    private void tbl_return_to_suppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_return_to_suppliersMouseClicked
        select_returns();
    }//GEN-LAST:event_tbl_return_to_suppliersMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
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
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private javax.swing.JLabel lbl_gross1;
    private javax.swing.JLabel lbl_gross2;
    private org.jdesktop.swingx.JXTable tbl_return_to_supplier_items;
    private javax.swing.JTable tbl_return_to_suppliers;
    private javax.swing.JTextField tf_branch;
    private javax.swing.JTextField tf_branch1;
    private javax.swing.JTextField tf_branch2;
    private javax.swing.JTextField tf_branch3;
    private javax.swing.JTextField tf_receipt_no;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_search1;
    private javax.swing.JTextField tf_supplier;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
        init_key();

        set_default_branch();
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);

        init_tbl_return_to_suppliers(tbl_return_to_suppliers);
        init_tbl_return_to_supplier_items(tbl_return_to_supplier_items);
        init_trans_no();
        item_ledger();
    }

    private void item_ledger() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jPanel8.setLayout(new BorderLayout());
                Dlg_report_inventory_ledger dlg = new Dlg_report_inventory_ledger();
                jPanel8.add(dlg.getSurface());
            }
        });

    }

    String br_id = "";

    private void set_default_branch() {

        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();

        Field.Combo combo = (Field.Combo) tf_branch;
        Field.Combo br = (Field.Combo) tf_branch1;
        combo.setText(to.location);
        combo.setId("" + to.id);
        br.setText(to.branch);
        br.setId("" + to.branch_id);

        Field.Combo combo2 = (Field.Combo) tf_branch3;
        Field.Combo br2 = (Field.Combo) tf_branch2;
        combo2.setText(to.location);
        combo2.setId("" + to.id);
        br2.setText(to.branch);
        br2.setId("" + to.branch_id);

        br_id = to.branch_id;

    }

    private void init_trans_no() {
        String transaction_no = Return_to_supplier.increment_id(br_id);
        tf_receipt_no.setText(transaction_no);
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
        tf_search1.addKeyListener(new KeyAdapter() {

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

    List<Suppliers.to_suppliers> supplier_list = new ArrayList();

    private void init_suppliers(final JTextField tf) {
        String search = tf.getText();
        supplier_list.clear();
        supplier_list = Suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list.size()][2];
        int i = 0;
        for (Suppliers.to_suppliers to : supplier_list) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 350};
        String[] col_names = {"ID", "NAME"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Suppliers.to_suppliers to = supplier_list.get(data.selected_row);
                Field.Combo supp = (Field.Combo) tf;
                supp.setText(to.customer_name);
                supp.setId(to.customer_no);

            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations(final JTextField br, final JTextField lo) {

        if (!br.isEnabled()) {
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
                setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo combo = (Field.Combo) br;
                Field.Combo loc = (Field.Combo) lo;
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                combo.setText(to.branch);
                combo.setId("" + to.branch_id);
                loc.setText(to.location);
                loc.setId("" + to.id);

            }
        });
    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        final Field.Combo br = (Field.Combo) tf_branch;
        tf_search1.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search1.getText();
                String where = " where "
                        + " main_barcode like '" + search + "' and location_id='" + br.getId() + "' "
                        + " or barcode like '" + search + "' and location_id='" + br.getId() + "' "
                        + " or description like '%" + search + "%' and location_id='" + br.getId() + "' ";

                if (jCheckBox7.isSelected()) {
                    where = " where main_barcode like '" + search + "' and location_id='" + br.getId() + "' ";
                }
                if (jCheckBox8.isSelected()) {
                    where = "  where  barcode like '" + search + "' and location_id='" + br.getId() + "' ";
                }
                if (jCheckBox9.isSelected()) {
                    where = " where  description like '%" + search + "%' and location_id='" + br.getId() + "' ";
                }
                where = where + " order by description asc ";

                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);
                if (inventory_barcoders_list.isEmpty()) {
                    tf_search1.setEnabled(true);
                    tf_search1.grabFocus();
                    Alert.set(0, "Item not found!");
                    return;
                }
                if (inventory_barcoders_list.size() == 1) {
                    Inventory_barcodes.to_inventory_barcodes item = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(0);
                    add_item(item);
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
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.cost);

                        i++;
                    }
                    JLabel[] labels = {};
                    double width = jScrollPane4.getWidth();

                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 100, w, 30, 50};
                    String[] col_names = {"Qty", "ItemCode", "Description", "Unit", "Cost"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search1, obj, labels, tbl_widths_customers, col_names);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes item = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(data.selected_row);
                            add_item(item);

                        }
                    });
                    tf_search1.setEnabled(true);
                    tf_search1.grabFocus();
                }

            }
        });
        t.start();
    }

    private void add_item(final Inventory_barcodes.to_inventory_barcodes item) {

        Window p = (Window) this;
        Dlg_return_to_supplier_qty nd = Dlg_return_to_supplier_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass2(1, item.cost, item.description, item.unit, item.barcode, item.barcode, item.product_qty, item.main_barcode);
        nd.setCallback(new Dlg_return_to_supplier_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_return_to_supplier_qty.OutputData data) {
                closeDialog.ok();
                int id = 0;
                String return_to_supplier_no = "";
                String user_name = "";
                String session_no = "";
                String date_added = "";
                String supplier = "";
                String supplier_id = "";
                String reference_no = "";
                String remarks = "";
                String barcode = item.barcode;
                String description = item.description;
                String category = item.category;
                String category_id = item.category_id;
                String classification = item.classification;
                String classification_id = item.classification_id;
                String sub_class = item.sub_classification;
                String sub_class_id = item.sub_classification_id;
                String brand = item.brand;
                String brand_id = item.brand_id;
                String model = item.model;
                String model_id = item.model_id;
                double conversion = data.conversion;
                String unit = data.unit;
                String barcodes = "";
                String batch_no = "";
                String serial_no = "";
                String main_barcode = item.main_barcode;
                double qty = data.amount;
                double cost = data.cost;
                int status = 0;
                String branch = "";
                String branch_id = "";
                String location = "";
                String location_id = "";

                if (jButton4.isEnabled()) {
                    to_return_to_supplier_items to = new to_return_to_supplier_items(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, branch, branch_id, location, location_id);
                    tbl_return_to_supplier_items_ALM.add(to);
                    compute_total_gross();
                } else {
                    int row = tbl_return_to_suppliers.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    final to_return_to_suppliers rt = (to_return_to_suppliers) tbl_return_to_suppliers_ALM.get(row);
                    if (rt.status == 1) {
                        Alert.set(0, "Transaction already finalized!");
                        return;
                    }
                    return_to_supplier_no = rt.return_to_supplier_no;
                    user_name = rt.user_name;
                    session_no = rt.session_no;
                    date_added = rt.date_added;
                    supplier = rt.supplier;
                    supplier_id = rt.supplier_id;
                    reference_no = rt.reference_no;
                    remarks = rt.remarks;
                    branch = rt.branch;
                    branch_id = rt.branch_id;
                    location = rt.location;
                    location_id = rt.location_id;
                    to_return_to_supplier_items to = new to_return_to_supplier_items(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, branch, branch_id, location, location_id);

                    double gross = 0;
                    List<to_return_to_supplier_items> items = tbl_return_to_supplier_items_ALM;
                    for (to_return_to_supplier_items item : items) {
                        double amount = item.qty * item.cost;
                        gross += amount;
                    }
                    gross = gross + (to.qty * to.cost);
                    Return_to_supplier_items.add_data(to, gross);
                    ret_return_to_supplier_items();
                    int row2 = tbl_return_to_suppliers.getSelectedRow();
                    if (row2 < 0) {
                        return;
                    }
                    ret_returns();
                    tbl_return_to_suppliers.setRowSelectionInterval(row2, row2);
                    compute_total_gross();
                }

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
        tf_search1.setEnabled(true);
        tf_search1.grabFocus();
    }

    private void compute_total_gross() {
        List<to_return_to_supplier_items> items = tbl_return_to_supplier_items_ALM;
        double gross = 0;
        for (to_return_to_supplier_items item : items) {
            double amount = item.qty * item.cost;
            gross += amount;
        }
        lbl_gross2.setText("" + items.size());
        lbl_gross1.setText(FitIn.fmt_wc_0(gross));
    }
    //<editor-fold defaultstate="collapsed" desc=" return_to_supplier_items "> 
    public static ArrayListModel tbl_return_to_supplier_items_ALM;
    public static Tblreturn_to_supplier_itemsModel tbl_return_to_supplier_items_M;

    public static void init_tbl_return_to_supplier_items(JTable tbl_return_to_supplier_items) {
        tbl_return_to_supplier_items_ALM = new ArrayListModel();
        tbl_return_to_supplier_items_M = new Tblreturn_to_supplier_itemsModel(tbl_return_to_supplier_items_ALM);
        tbl_return_to_supplier_items.setModel(tbl_return_to_supplier_items_M);
        tbl_return_to_supplier_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_return_to_supplier_items.setRowHeight(25);
        int[] tbl_widths_return_to_supplier_items = {80, 80, 100, 100, 40, 80, 80, 80, 40, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_return_to_supplier_items.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_return_to_supplier_items, i, tbl_widths_return_to_supplier_items[i]);
        }
        Dimension d = tbl_return_to_supplier_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_return_to_supplier_items.getTableHeader().setPreferredSize(d);
        tbl_return_to_supplier_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_return_to_supplier_items.setRowHeight(25);
        tbl_return_to_supplier_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_return_to_supplier_items, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_return_to_supplier_items, 7);
    }

    public static void loadData_return_to_supplier_items(List<to_return_to_supplier_items> acc) {
        tbl_return_to_supplier_items_ALM.clear();
        tbl_return_to_supplier_items_ALM.addAll(acc);
    }

    public static class Tblreturn_to_supplier_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Barcode", "Description", "Unit", "Conversion", "Cost", "Amount", "", "", "", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "brand", "brand_id", "model", "model_id", "conversion", "unit", "barcodes", "batch_no", "serial_no", "main_barcode", "qty", "cost", "status", "branch", "branch_id", "location", "location_id"
        };

        public Tblreturn_to_supplier_itemsModel(ListModel listmodel) {
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
            to_return_to_supplier_items tt = (to_return_to_supplier_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.barcode;
                case 3:
                    return " " + tt.description;
                case 4:
                    String uom = tt.unit;
                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }

                    unit = unit.replaceAll("#", "/");
                    return " " + unit;
                case 5:
                    return " " + FitIn.fmt_woc(tt.conversion);
                case 6:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.qty * tt.cost) + " ";
                case 8:
                    return " Edit";
                case 9:
                    return " Delete";
                case 10:
                    return "";
                case 11:
                    return tt.category;
                case 12:
                    return tt.category_id;
                case 13:
                    return tt.classification;
                case 14:
                    return tt.classification_id;
                case 15:
                    return tt.sub_class;
                case 16:
                    return tt.sub_class_id;
                case 17:
                    return tt.brand;
                case 18:
                    return tt.brand_id;
                case 19:
                    return tt.model;
                case 20:
                    return tt.model_id;
                case 21:
                    return tt.conversion;
                case 22:
                    return tt.unit;
                case 23:
                    return tt.barcodes;
                case 24:
                    return tt.batch_no;
                case 25:
                    return tt.serial_no;
                case 26:
                    return tt.main_barcode;
                case 27:
                    return tt.qty;
                case 28:
                    return tt.cost;
                case 29:
                    return tt.status;
                case 30:
                    return tt.branch;
                case 31:
                    return tt.branch_id;
                case 32:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_return_to_supplier_items() {
        int row = tbl_return_to_suppliers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_return_to_suppliers to = (to_return_to_suppliers) tbl_return_to_suppliers_ALM.get(row);
        String where = " where return_to_supplier_no='" + to.return_to_supplier_no + "' ";
        List<to_return_to_supplier_items> datas = Return_to_supplier_items.ret_data(where);
        loadData_return_to_supplier_items(datas);

    }

    private void edit_return() {
        final int row = tbl_return_to_supplier_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_return_to_supplier_items.getSelectedColumn();
        final to_return_to_supplier_items to = (to_return_to_supplier_items) tbl_return_to_supplier_items_ALM.get(row);
        if (to.status == 1) {
            Alert.set(0, "Transaction already finalized!");
            return;
        }
        if (col == 8) {

            Window p = (Window) this;
            Dlg_return_to_supplier_qty nd = Dlg_return_to_supplier_qty.create(p, true);
            nd.setTitle("");
            nd.do_pass2(to.qty, to.cost, to.description, to.unit, to.barcode, to.barcode, 0, to.main_barcode);
            nd.setCallback(new Dlg_return_to_supplier_qty.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_return_to_supplier_qty.OutputData data) {
                    closeDialog.ok();

                    if (!jButton4.isEnabled()) {
                        to.setConversion(data.conversion);
                        to.setCost(data.cost);
                        to.setQty(data.amount);
                        to.setUnit(data.unit);
                        tbl_return_to_supplier_items_M.fireTableDataChanged();

                        double gross = 0;
                        final List<to_return_to_supplier_items> items = tbl_return_to_supplier_items_ALM;
                        for (to_return_to_supplier_items item : items) {
                            double amount = item.qty * item.cost;
                            gross += amount;
                        }
                        Return_to_supplier_items.update_item(to, gross);
                        ret_return_to_supplier_items();
                        Alert.set(2, "");
                        int row2 = tbl_return_to_suppliers.getSelectedRow();
                        if (row2 < 0) {
                            return;
                        }
                        ret_returns();
                        tbl_return_to_suppliers.setRowSelectionInterval(row2, row2);
                        compute_total_gross();
                    } else {
                        to.setConversion(data.conversion);
                        to.setCost(data.cost);
                        to.setQty(data.amount);
                        to.setUnit(data.unit);
                        tbl_return_to_supplier_items_M.fireTableDataChanged();
                        compute_total_gross();
                    }

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }
        if (col == 9) {
            if (to.id == 0) {
                tbl_return_to_supplier_items_ALM.remove(row);
            } else {
                Window p = (Window) this;
                Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
                nd.setTitle("");

                nd.setCallback(new Dlg_confirm_action.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                        closeDialog.ok();
                        tbl_return_to_supplier_items_ALM.remove(row);
                        double gross = 0;
                        final List<to_return_to_supplier_items> items = tbl_return_to_supplier_items_ALM;
                        for (to_return_to_supplier_items item : items) {
                            double amount = item.qty * item.cost;
                            gross += amount;
                        }

                        Return_to_supplier_items.delete_data(to, gross);
                        ret_return_to_supplier_items();
                        Alert.set(3, br_id);

                        int row2 = tbl_return_to_suppliers.getSelectedRow();
                        if (row2 < 0) {
                            return;
                        }
                        ret_returns();

                        tbl_return_to_suppliers.setRowSelectionInterval(row2, row2);
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

            compute_total_gross();
        }

    }
//</editor-fold> 

    private void post_return() {

        Field.Combo supp = (Field.Combo) tf_supplier;
        Field.Combo br = (Field.Combo) tf_branch1;
        Field.Combo lo = (Field.Combo) tf_branch;
        int id = 0;
        String return_to_supplier_no = Return_to_supplier.increment_id(br_id);
        String where = " where return_to_supplier_no='" + return_to_supplier_no + "' ";
        List<Return_to_supplier.to_return_to_suppliers> datas = Return_to_supplier.ret_data(where);
        if (!datas.isEmpty()) {
            post_return();
        }
        String user_name = MyUser.getUser_id();
        String session_no = "";
        String date_added = DateType.datetime.format(jDateChooser3.getDate());
        String supplier = supp.getText();
        String supplier_id = supp.getId();
        if (supplier_id == null) {
            Alert.set(0, "Choose Supplier!");
            tf_supplier.grabFocus();
            return;
        }
        String reference_no = tf_remarks.getText();
        String remarks = jTextArea1.getText();
        int status = 0;
        String branch = br.getText();
        String branch_id = br.getId();
        String location = lo.getText();
        String location_id = lo.getId();
        double gross_total = 0;
        String discount = "";
        double discount_amount = 0;
        double discount_rate = 0;

        final List<to_return_to_supplier_items> items = tbl_return_to_supplier_items_ALM;
        for (to_return_to_supplier_items item : items) {
            double amount = item.qty * item.cost;
            gross_total += amount;
        }

        final Return_to_supplier.to_return_to_suppliers rts = new Return_to_supplier.to_return_to_suppliers(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, status, branch, branch_id, location, location_id, gross_total, discount, discount_amount, discount_rate);

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed posting this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Return_to_supplier.add_data(rts, items);
                clear_returns();
                ret_returns();
                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void clear_returns() {
        tf_remarks.setText("");
        jTextArea1.setText("");
        init_trans_no();
        jButton4.setEnabled(true);
        tf_branch1.setEnabled(true);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        tf_supplier.grabFocus();
        tbl_return_to_supplier_items_ALM.clear();
        tbl_return_to_supplier_items_M.fireTableDataChanged();

        tbl_return_to_suppliers.clearSelection();
    }

    //<editor-fold defaultstate="collapsed" desc=" return_to_suppliers "> 
    public static ArrayListModel tbl_return_to_suppliers_ALM;
    public static Tblreturn_to_suppliersModel tbl_return_to_suppliers_M;

    public static void init_tbl_return_to_suppliers(JTable tbl_return_to_suppliers) {
        tbl_return_to_suppliers_ALM = new ArrayListModel();
        tbl_return_to_suppliers_M = new Tblreturn_to_suppliersModel(tbl_return_to_suppliers_ALM);
        tbl_return_to_suppliers.setModel(tbl_return_to_suppliers_M);
        tbl_return_to_suppliers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_return_to_suppliers.setRowHeight(25);
        int[] tbl_widths_return_to_suppliers = {130, 80, 100, 100, 190, 80, 60, 40, 50, 40, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_return_to_suppliers.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_return_to_suppliers, i, tbl_widths_return_to_suppliers[i]);
        }
        Dimension d = tbl_return_to_suppliers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_return_to_suppliers.getTableHeader().setPreferredSize(d);
        tbl_return_to_suppliers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_return_to_suppliers.setRowHeight(25);
        tbl_return_to_suppliers.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_return_to_suppliers, 5);
    }

    public static void loadData_return_to_suppliers(List<to_return_to_suppliers> acc) {
        tbl_return_to_suppliers_ALM.clear();
        tbl_return_to_suppliers_ALM.addAll(acc);
    }

    public static class Tblreturn_to_suppliersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Date", "Supplier", "Reference No", "Location", "Gross", "Status", "", "", "", "branch", "branch_id", "location", "location_id", "gross_total", "discount", "discount_amount", "discount_rate"
        };

        public Tblreturn_to_suppliersModel(ListModel listmodel) {
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
            to_return_to_suppliers tt = (to_return_to_suppliers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.return_to_supplier_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.supplier;
                case 3:
                    return " " + tt.reference_no;
                case 4:
                    return " " + tt.branch + " - " + tt.location;
                case 5:
                    return FitIn.fmt_wc_0(tt.gross_total) + " ";
                case 6:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 7:
                    return " Edit";
                case 8:
                    return " Delete";
                case 9:
                    return " Print";
                case 10:
                    return tt.branch;
                case 11:
                    return tt.branch_id;
                case 12:
                    return tt.location;
                case 13:
                    return tt.location_id;
                case 14:
                    return tt.gross_total;
                case 15:
                    return tt.discount;
                case 16:
                    return tt.discount_amount;
                default:
                    return tt.discount_rate;
            }
        }
    }

    private void ret_returns() {

        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        Field.Combo supplier = (Field.Combo) jTextField2;
        Field.Combo br = (Field.Combo) tf_branch2;

        Field.Combo loc = (Field.Combo) tf_branch3;

        String where = " where session_no like '" + "%" + "' ";
        if (!jCheckBox1.isSelected()) {
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (!jCheckBox10.isSelected()) {
            where = where + " and supplier_id='" + supplier.getId() + "' ";
        }

        if (!jCheckBox11.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and location_id='" + loc.getId() + "' ";
        }
        if (jCheckBox11.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and branch_id='" + br.getId() + "' ";
        }
        if (jCheckBox3.isSelected()) {
            where = where + " and status='" + "0" + "' ";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " and status='" + "1" + "' ";
        }
        where = where + " order by id desc ";
        List<to_return_to_suppliers> datas = Return_to_supplier.ret_data(where);
        loadData_return_to_suppliers(datas);
        jLabel3.setText("" + datas.size());
    }

    private void select_returns() {
        int row = tbl_return_to_suppliers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_return_to_suppliers to = (to_return_to_suppliers) tbl_return_to_suppliers_ALM.get(row);
        int col = tbl_return_to_suppliers.getSelectedColumn();
        if (col == 7) {
            Field.Combo sup = (Field.Combo) tf_supplier;
            Field.Combo br = (Field.Combo) tf_branch1;
            Field.Combo lo = (Field.Combo) tf_branch;

            tf_receipt_no.setText(to.return_to_supplier_no);
            sup.setText(to.supplier);
            sup.setId(to.supplier_id);
            br.setText(to.branch);
            br.setId(to.branch_id);
            lo.setText(to.location);
            lo.setId(to.location_id);
            tf_remarks.setText(to.reference_no);
            jTextArea1.setText(to.remarks);
            try {
                Date d = DateType.datetime.parse(to.date_added);
                jDateChooser3.setDate(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_return_to_supplier.class.getName()).log(Level.SEVERE, null, ex);
            }

            ret_return_to_supplier_items();
            compute_total_gross();
            tf_branch1.setEnabled(false);
            jButton4.setEnabled(false);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jTabbedPane1.setSelectedIndex(0);

        }
        if (col == 8) {
            if (to.status == 1) {
                Alert.set(0, "Transaction already finalized!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();

                    Return_to_supplier.delete_data(to);

                    ret_returns();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 9) {
            print_preview_return_to_supplier(to);
        }
    }

    private void print_preview_return_to_supplier(final to_return_to_suppliers to) {

        jTabbedPane1.setSelectedIndex(2);
        jProgressBar3.setString("Loading... Please wait...");
        jProgressBar3.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override

            public void run() {

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");
                String contact_no = System.getProperty("contact_no", "422-1234");

                String return_to_supplier_no = to.return_to_supplier_no;
                String date_returned = DateType.convert_jan_1_2013_datetime2(to.date_added);
                String date = DateType.month_date.format(new Date());
                String supplier = to.supplier;
                String supplier_id = to.supplier_id;
                String reference_no = to.reference_no;
                String remarks = to.remarks;
                String branch = to.branch;
                String location = to.location;

                String where = " where return_to_supplier_no='" + to.return_to_supplier_no + "' ";
                List<to_return_to_supplier_items> datas = Return_to_supplier_items.ret_data(where);
                List<Srpt_return_to_supplier.field> fields = new ArrayList();
                for (to_return_to_supplier_items item : datas) {
                    String item_code = item.main_barcode;
                    String barcode = item.barcode;
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

                    unit = unit.replaceAll("#", "/");
                    double qty = item.qty;
                    double conversion = item.conversion;
                    double cost = item.cost;
                    double amount = item.qty * item.cost;

                    Srpt_return_to_supplier.field field = new Srpt_return_to_supplier.field(item_code, barcode, description, unit, qty, conversion, cost, amount);
                    fields.add(field);
                }
                Srpt_return_to_supplier rpt = new Srpt_return_to_supplier(business_name, address, return_to_supplier_no, date_returned, date, supplier, supplier_id, reference_no, remarks, branch, location, contact_no);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_return_to_supplier.jrxml";
                report_customers_aging(rpt, jrxml);
                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_return_to_supplier to, String jrxml_name) {
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

    public static JRViewer get_viewer_customers_aging(Srpt_return_to_supplier to, String rpt_name) {
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
            InputStream is = Srpt_return_to_supplier.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void update_return_to_supplier() {
        int row = tbl_return_to_suppliers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_return_to_suppliers to = (to_return_to_suppliers) tbl_return_to_suppliers_ALM.get(row);
        if (to.status == 1) {
            Alert.set(0, "Transaction already finalized!");
            return;
        }
        Field.Combo supp = (Field.Combo) tf_supplier;

        int id = to.id;
        String return_to_supplier_no = to.return_to_supplier_no;
        String user_name = to.user_name;
        String session_no = to.session_no;
        String date_added = DateType.datetime.format(jDateChooser3.getDate());
        String supplier = supp.getText();
        String supplier_id = supp.getId();
        if (supplier_id == null) {
            Alert.set(0, "Choose Supplier!");
            tf_supplier.grabFocus();
            return;
        }
        String reference_no = tf_remarks.getText();
        String remarks = jTextArea1.getText();
        int status = 0;
        String branch = to.branch;
        String branch_id = to.branch_id;
        String location = to.location;
        String location_id = to.location_id;
        double gross_total = 0;
        String discount = "";
        double discount_amount = 0;
        double discount_rate = 0;

        final Return_to_supplier.to_return_to_suppliers rts = new Return_to_supplier.to_return_to_suppliers(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, status, branch, branch_id, location, location_id, gross_total, discount, discount_amount, discount_rate);

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Return_to_supplier.update_data(rts);
                ret_returns();
                clear_returns();
                Alert.set(2, br_id);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void finalize_return_to_supplier() {
        int row = tbl_return_to_suppliers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_return_to_suppliers to = (to_return_to_suppliers) tbl_return_to_suppliers_ALM.get(row);
        if (to.status == 1) {
            Alert.set(0, "Transaction already finalized!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                List<Return_to_supplier_items.to_return_to_supplier_items> items = tbl_return_to_supplier_items_ALM;
                Return_to_supplier.finalize(to, items);
                ret_returns();
                clear_returns();
                Alert.set(0, "Transaction finalized!");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
//</editor-fold> 
}
