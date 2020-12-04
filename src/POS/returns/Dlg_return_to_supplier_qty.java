/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

import POS.inventory.S1_items2;
import POS.my_services.S1_my_services_problems;
import POS.receipts.S1_receipt_barcodes.to_receipt_barcodes;
import POS.receipts.S1_serial_nos.to_receipt_serial_nos;
import POS.suppliers.Suppliers;
import POS.unit_of_measure.S1_unit_of_measure;
import POS.util.Alert;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Maytopacka
 */
public class Dlg_return_to_supplier_qty extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cashin
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

        public final double amount;
        public final double cost;
        public final String barcodes;
        public final String serial_nos;
        public final String unit;
        public final double conversion;
        public final String remarks;

        public OutputData(double amount, double cost, String barcodes, String serial_nos, String unit, double conversion, String remarks) {
            this.amount = amount;
            this.cost = cost;
            this.barcodes = barcodes;
            this.serial_nos = serial_nos;
            this.unit = unit;
            this.conversion = conversion;
            this.remarks = remarks;
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_return_to_supplier_qty(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_return_to_supplier_qty(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_return_to_supplier_qty() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_return_to_supplier_qty myRef;

    private void setThisRef(Dlg_return_to_supplier_qty myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_return_to_supplier_qty> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_return_to_supplier_qty create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_return_to_supplier_qty create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_return_to_supplier_qty dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_return_to_supplier_qty((java.awt.Frame) parent, false);
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
            Dlg_return_to_supplier_qty dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_return_to_supplier_qty((java.awt.Dialog) parent, false);
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

        Dlg_return_to_supplier_qty dialog = Dlg_return_to_supplier_qty.create(new javax.swing.JFrame(), true);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbl_item_code = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_cost = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lbl_qty = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipt_barcodes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        tf_serial_no = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_receipt_serial_nos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_uom = new javax.swing.JTable();
        lbl_desc = new org.jdesktop.swingx.JXLabel();
        lbl_item_code1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_item_code2 = new Field.Combo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Item Code:");

        lbl_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_item_code.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Description:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Enter Qty:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cost:");

        tf_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Qty on hand:");

        lbl_qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_qty.setFocusable(false);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Serial #:");

        jButton1.setText("OK (Ctrl)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_receipt_barcodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "BARCODE"
            }
        ));
        jScrollPane1.setViewportView(tbl_receipt_barcodes);

        jLabel3.setText("BARCODE:");

        tf_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_barcodeActionPerformed(evt);
            }
        });

        tf_serial_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_serial_noActionPerformed(evt);
            }
        });

        tbl_receipt_serial_nos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "BARCODE"
            }
        ));
        jScrollPane2.setViewportView(tbl_receipt_serial_nos);

        jLabel4.setText("SERIAL NO.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_barcode))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_serial_no)
                        .addGap(81, 81, 81))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_serial_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel1.setText("Total no.:");

        jLabel2.setText("0");

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
        jScrollPane4.setViewportView(tbl_uom);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lbl_desc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_desc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_desc.setLineWrap(true);

        lbl_item_code1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_item_code1.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Barcode:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Remarks:");

        lbl_item_code2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_item_code2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_item_code2MouseClicked(evt);
            }
        });
        lbl_item_code2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_item_code2ActionPerformed(evt);
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
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_item_code2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_item_code1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_item_code1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lbl_item_code2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
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

    private void tf_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_barcodeActionPerformed
        // TODO add your handling code here:
        update_barcode();
    }//GEN-LAST:event_tf_barcodeActionPerformed

    private void tf_serial_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_serial_noActionPerformed
        // TODO add your handling code here:
        add_serial_no();
    }//GEN-LAST:event_tf_serial_noActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        count_serial(evt);
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        tf_cost.grabFocus();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
        ok1();
    }//GEN-LAST:event_tf_costActionPerformed

    private void lbl_item_code2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_item_code2ActionPerformed
        init_remarks(lbl_item_code2);
    }//GEN-LAST:event_lbl_item_code2ActionPerformed

    private void lbl_item_code2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_item_code2MouseClicked
//        init_remarks(lbl_item_code2);
    }//GEN-LAST:event_lbl_item_code2MouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXLabel lbl_desc;
    private javax.swing.JTextField lbl_item_code;
    private javax.swing.JTextField lbl_item_code1;
    private javax.swing.JTextField lbl_item_code2;
    private javax.swing.JTextField lbl_qty;
    private javax.swing.JTable tbl_receipt_barcodes;
    private javax.swing.JTable tbl_receipt_serial_nos;
    private javax.swing.JTable tbl_uom;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_serial_no;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        focus();
//        init_tbl_receipt_barcodes();
//        init_tbl_receipt_serial_nos();

        init_tbl_uom();
        jLabel3.setVisible(false);
        tf_barcode.setVisible(false);
        jScrollPane1.setVisible(false);
        jPanel3.setVisible(false);

        set_border();
    }

    private void set_border() {

        Border border = BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204));
        lbl_desc.setBorder(BorderFactory.createCompoundBorder(border,
                                                              BorderFactory.createEmptyBorder(2, 2, 2, 2)));
    }

    private void focus() {
        JTextField[] tf = {tf_amount, tf_cost, tf_serial_no};
        JTextArea[] tf2 = {jTextArea1};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        Focus_Fire.onFocus_lostFocus(tf2);
        Focus_Fire.select_all(tf2);
    }
    String barcode = "";
    String barcodes1 = "";

    public void do_pass(double qty, double cost, String desc, String unit, String barcode1, String barcodes, String selected_barcode, String serials, double product_qty, String my_barcode) {
        lbl_qty.setText(FitIn.fmt_woc(product_qty));
        lbl_item_code.setText(my_barcode);
        tf_amount.setText(FitIn.fmt_woc(qty));
        tf_cost.setText(FitIn.fmt_wc_0(cost));
        lbl_desc.setText(desc);
        jTextArea1.setText(serials);
        tf_amount.grabFocus();
        tf_amount.selectAll();
        barcode = barcode1;
        tf_barcode.setText(selected_barcode);

        List<S1_unit_of_measure.to_uom> uoms = new ArrayList();
        String uom = unit;
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
//        List<to_receipt_barcodes> datas = new ArrayList();
//        List<String> codes = SplitString.split(barcodes);
//        for (String s : codes) {
//            to_receipt_barcodes to = new to_receipt_barcodes(0, barcode1, s);
//            datas.add(to);
//        }
//        loadData_receipt_barcodes(datas);
//
//        List<String> ser = SplitString.split(serials);
//        List<to_receipt_serial_nos> data = new ArrayList();
//        for (String s : ser) {
//            to_receipt_serial_nos to = new to_receipt_serial_nos(0, s);
//            data.add(to);
//        }
//        loadData_receipt_serial_nos(data);
    }

    int is_admin = 0;

    public void do_pass2(double qty, double cost, String desc, String unit, String barcode1, String barcodes, double product_qty, String my_barcode, String remarks, String serials, int admin) {
        is_admin = admin;
        lbl_qty.setText(FitIn.fmt_woc(product_qty));
        lbl_item_code.setText(my_barcode);
        lbl_item_code1.setText(barcode1);
        if(is_admin==0){
            jLabel11.setVisible(false);
            tf_cost.setVisible(false);
        }
//        List<to_receipt_barcodes> datas = new ArrayList();
//        List<String> codes = SplitString.split(barcodes);
//        for (String s : codes) {
//            to_receipt_barcodes to = new to_receipt_barcodes(0, barcode1, s);
//            datas.add(to);
//        }
//        loadData_receipt_barcodes(datas);
        if (qty != 0) {
            tf_amount.setText(FitIn.fmt_woc(qty));
        }
        tf_cost.setText(FitIn.fmt_wc_0(cost));
        lbl_desc.setText(desc);
        lbl_item_code2.setText(remarks);
        jTextArea1.setText(serials);
//        lbl_unit.setText(unit);
        tf_amount.grabFocus();
        tf_amount.selectAll();
        barcode = barcode1;
        barcodes1 = barcodes;

        List<S1_unit_of_measure.to_uom> uoms = new ArrayList();
        String uom = unit;
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
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_CONTROL, new KeyAction() {

                          @Override
                          public void actionPerformed(ActionEvent e) {
                              ok1();
                          }
                      });
        tf_barcode.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_receipt_barcodes_ALM.isEmpty()) {
                        tbl_receipt_barcodes.setRowSelectionInterval(0, 0);
                        tbl_receipt_barcodes.grabFocus();
                    }
                }

            }
        });
        tbl_receipt_barcodes.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = tbl_receipt_barcodes.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    to_receipt_barcodes to = (to_receipt_barcodes) tbl_receipt_barcodes_ALM.
                            get(tbl_receipt_barcodes.convertRowIndexToModel(row));
                    tf_barcode.setText(to.barcode);
                    tf_amount.grabFocus();
                    e.consume();
                }

            }
        });
        tf_serial_no.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_receipt_serial_nos_ALM.isEmpty()) {
                        tbl_receipt_serial_nos.setRowSelectionInterval(0, 0);
                        tbl_receipt_serial_nos.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });
        tbl_receipt_serial_nos.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    delete_serial_no();
                    e.consume();
                }

            }
        });
        tf_cost.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });
        tf_cost.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });

        tf_amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }

            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_receipt_barcodes_ALM;
    private Tblreceipt_barcodesModel tbl_receipt_barcodes_M;

    private void init_tbl_receipt_barcodes() {
        tbl_receipt_barcodes_ALM = new ArrayListModel();
        tbl_receipt_barcodes_M = new Tblreceipt_barcodesModel(tbl_receipt_barcodes_ALM);
        tbl_receipt_barcodes.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipt_barcodes.setModel(tbl_receipt_barcodes_M);
        tbl_receipt_barcodes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_barcodes.setRowHeight(25);
        int[] tbl_widths_receipt_barcodes = {0, 100};
        for (int i = 0, n = tbl_widths_receipt_barcodes.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_barcodes, i, tbl_widths_receipt_barcodes[i]);
        }
        Dimension d = tbl_receipt_barcodes.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_receipt_barcodes.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_barcodes.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_receipt_barcodes.setRowHeight(35);
        tbl_receipt_barcodes.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_receipt_barcodes(List<to_receipt_barcodes> acc) {
        tbl_receipt_barcodes_ALM.clear();
        tbl_receipt_barcodes_ALM.addAll(acc);
    }

    public static class Tblreceipt_barcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "BARCODE"
        };

        public Tblreceipt_barcodesModel(ListModel listmodel) {
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
            to_receipt_barcodes tt = (to_receipt_barcodes) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                default:
                    return tt.barcode;
            }
        }
    }

    private void update_barcode() {
        List<to_receipt_barcodes> acc = tbl_receipt_barcodes_ALM;
        String barcodes = "";
        String new_code = tf_barcode.getText();
        int i = 0;
        int exist = 0;
        int ie = 0;
        for (to_receipt_barcodes t : acc) {
            if (i == 0) {
                barcodes = barcodes + t;
            } else {
                barcodes = barcodes + "," + t;
            }
            i++;
            if (t.barcode.equalsIgnoreCase(new_code)) {

                exist = 1;
                ie = i;
            }
        }
        if (exist == 0) {
            to_receipt_barcodes to = new to_receipt_barcodes(0, barcode, new_code);
            String my_code = "";
            if (i == 0) {
                my_code = new_code;

            } else {
                my_code = barcodes1 + "," + new_code;
            }
            S1_items2.update_barcodes(barcode, my_code);
            tbl_receipt_barcodes_ALM.add(to);
            tbl_receipt_barcodes_M.fireTableDataChanged();
            tbl_receipt_barcodes.setRowSelectionInterval(tbl_receipt_barcodes.
                    getRowCount() - 1, tbl_receipt_barcodes.getRowCount() - 1);

        } else {
        }

    }
    private ArrayListModel tbl_receipt_serial_nos_ALM;
    private Tblreceipt_serial_nosModel tbl_receipt_serial_nos_M;

    private void init_tbl_receipt_serial_nos() {
        tbl_receipt_serial_nos_ALM = new ArrayListModel();
        tbl_receipt_serial_nos_M = new Tblreceipt_serial_nosModel(tbl_receipt_serial_nos_ALM);
        tbl_receipt_serial_nos.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipt_serial_nos.setModel(tbl_receipt_serial_nos_M);
        tbl_receipt_serial_nos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_serial_nos.setRowHeight(25);
        int[] tbl_widths_receipt_serial_nos = {0, 100};
        for (int i = 0, n = tbl_widths_receipt_serial_nos.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_serial_nos, i, tbl_widths_receipt_serial_nos[i]);
        }
        Dimension d = tbl_receipt_serial_nos.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_receipt_serial_nos.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_serial_nos.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_receipt_serial_nos.setRowHeight(35);
        tbl_receipt_serial_nos.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_receipt_serial_nos(List<to_receipt_serial_nos> acc) {
        tbl_receipt_serial_nos_ALM.clear();
        tbl_receipt_serial_nos_ALM.addAll(acc);
    }

    public static class Tblreceipt_serial_nosModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "SERIAL NO"
        };

        public Tblreceipt_serial_nosModel(ListModel listmodel) {
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
            to_receipt_serial_nos tt = (to_receipt_serial_nos) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                default:
                    return tt.serial_no;
            }
        }
    }

    private void add_serial_no() {
        String serial_no = tf_serial_no.getText();
        if (serial_no.isEmpty()) {
            return;
        }
        to_receipt_serial_nos to = new to_receipt_serial_nos(0, serial_no);
        List<to_receipt_serial_nos> datas = tbl_receipt_serial_nos_ALM;
        int exist = 0;
        for (to_receipt_serial_nos t : datas) {
            if (t.serial_no.equalsIgnoreCase(serial_no)) {
                exist = 1;
            }
        }
        if (exist == 0) {
            tbl_receipt_serial_nos_ALM.add(to);
            tbl_receipt_serial_nos_M.fireTableDataChanged();
            tf_serial_no.setText("");
            tf_serial_no.grabFocus();
        }
    }

    private void delete_serial_no() {
        int row = tbl_receipt_serial_nos.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_receipt_serial_nos_ALM.remove(row);
        tbl_receipt_serial_nos_M.fireTableDataChanged();
        tf_serial_no.grabFocus();
    }

    private void ok1() {

        int row = tbl_uom.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_unit_of_measure.to_uom uom = (S1_unit_of_measure.to_uom) tbl_uom_ALM.get(row);
        double amount = FitIn.toDouble(tf_amount.getText());
        double cost = FitIn.toDouble(tf_cost.getText());

        String barcodes = tf_barcode.getText();
        String serial_no = jTextArea1.getText();
//        List<to_receipt_serial_nos> datas = tbl_receipt_serial_nos_ALM;
//        List<String> se = new ArrayList();
//        for (to_receipt_serial_nos to : datas) {
//            se.add(to.serial_no);
//        }
//        serial_no = SplitString.revert(se);
//        serial_no = jTextArea1.getText();
//        serial_no = serial_no.replaceAll("\n", ",");
        if (amount < 0) {
            Alert.set(0, "ENTER AMOUNT");
            return;
        }
        double conversion = uom.conversion;
        String remarks = lbl_item_code2.getText();
        String unit = "[" + uom.unit + ":" + uom.price + "/" + uom.conversion + "^" + "1" + "]";
        if (is_admin == 0) {
            if (remarks.isEmpty()) {
                Alert.set(0, "Input remarks");
                lbl_item_code2.grabFocus();
                return;
            }
        }

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(amount, cost, barcodes, serial_no, unit, conversion, remarks));
        }
    }

    private void count_serial(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String serial = jTextArea1.getText();
            String[] datas = serial.split("\n");
            jLabel2.setText("" + datas.length);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" init table unit of measure ">
    private ArrayListModel tbl_uom_ALM;
    private TbluomModel tbl_uom_M;

    private void init_tbl_uom() {
        tbl_uom_ALM = new ArrayListModel();
        tbl_uom_M = new TbluomModel(tbl_uom_ALM);
        tbl_uom.getTableHeader().setPreferredSize(new Dimension(80, 30));
        tbl_uom.setModel(tbl_uom_M);
        tbl_uom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_uom.setRowHeight(25);
        int[] tbl_widths_uom = {70, 80, 0};
        for (int i = 0, n = tbl_widths_uom.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_uom, i, tbl_widths_uom[i]);
        }
        tbl_uom.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_uom.setRowHeight(30);
        tbl_uom.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_uom, 2);
    }

    private void loadData_uom(List<S1_unit_of_measure.to_uom> acc) {
        tbl_uom_ALM.clear();
        tbl_uom_ALM.addAll(acc);

    }

    public static class TbluomModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Unit", "Conversion", "Cost"
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
                    String unit = tt.unit;
                    unit = unit.replaceAll("#", "/");
                    return " " + unit;
                case 1:
                    return " " + FitIn.fmt_wc_0(tt.conversion);
                default:
                    return FitIn.fmt_wc_0(tt.price) + " ";
            }
        }
    }
    //</editor-fold>

    List<S1_my_services_problems.to_my_services_problems> service_remarks = new ArrayList();

    private void init_remarks(final JTextField tf) {
        String search = tf.getText();
        if (search.isEmpty()) {
            tf.grabFocus();
            return;
        }
        String where = " where problem like '%" + tf.getText() + "%' order by problem asc  ";
        service_remarks = S1_my_services_problems.ret_data(where);
        if (service_remarks.isEmpty()) {
            S1_my_services_problems.to_my_services_problems to = new S1_my_services_problems.to_my_services_problems(0, search, 0);
            S1_my_services_problems.add_my_services_problems(to);
            return;
        }
        Object[][] obj = new Object[service_remarks.size()][1];
        int i = 0;
        for (S1_my_services_problems.to_my_services_problems to : service_remarks) {
            obj[i][0] = " " + to.problem;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_my_services_problems.to_my_services_problems to = service_remarks.get(data.selected_row);
                tf.setText(to.problem);

            }
        });
    }

}
