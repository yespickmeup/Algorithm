/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.discounts.S1_discounts;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Tables.to_serial_nos;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Guinness
 */
public class Dlg_new_sales_qty extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_sales_qty
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

        public final double qty;
        public final String uom;
        public final double price;
        public final double conversion;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String serial_no;
        public final String selected_serials;

        public OutputData(double qty, String uom, double price, double conversion, String discount_name, double discount_rate, double discount_amount, String serial_no, String selected_serials) {
            this.qty = qty;
            this.uom = uom;
            this.price = price;
            this.conversion = conversion;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.serial_no = serial_no;
            this.selected_serials = selected_serials;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_new_sales_qty(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_sales_qty(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_sales_qty() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_sales_qty myRef;

    private void setThisRef(Dlg_new_sales_qty myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_sales_qty> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_sales_qty create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_sales_qty create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_sales_qty dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_sales_qty((java.awt.Frame) parent, false);
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
            Dlg_new_sales_qty dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_sales_qty((java.awt.Dialog) parent, false);
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

        Dlg_new_sales_qty dialog = Dlg_new_sales_qty.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_item_code = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_uom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_discount_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_discount_rate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_discount_amount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_conversion = new javax.swing.JTextField();
        tf_selling_price = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_desciption = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_serial_nos = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(104, 95, 84));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Item Code:");

        tf_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_item_code.setFocusable(false);

        jLabel2.setText("Barcode:");

        tf_barcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_barcode.setFocusable(false);

        jLabel3.setText("Description:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Unit:");

        tf_uom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_uom.setText("PC");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Qty:");

        tf_qty.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tf_qty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_qty.setText("1");
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Serial #:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Discount:");

        tf_discount_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discount_nameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Rate:");

        tf_discount_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_rate.setText("0.00");
        tf_discount_rate.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Amount:");

        tf_discount_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_discount_amount.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("%");

        jLabel12.setText("Conversion:");

        tf_conversion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_conversion.setText("1");
        tf_conversion.setFocusable(false);

        tf_selling_price.setBackground(new java.awt.Color(104, 95, 84));
        tf_selling_price.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        tf_selling_price.setForeground(new java.awt.Color(255, 255, 255));
        tf_selling_price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tf_selling_price.setText("1,000.00");
        tf_selling_price.setOpaque(true);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tf_desciption.setColumns(20);
        tf_desciption.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_desciption.setLineWrap(true);
        tf_desciption.setRows(5);
        tf_desciption.setFocusable(false);
        jScrollPane2.setViewportView(tf_desciption);

        tbl_serial_nos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_serial_nos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_serial_nosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_serial_nos);

        jTextField1.setNextFocusableComponent(tf_qty);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_selling_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_uom))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_discount_name)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_discount_amount))
                            .addComponent(tf_qty))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_selling_price)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_uom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_discount_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        ok();
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void tf_discount_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_nameActionPerformed
        init_discount();
    }//GEN-LAST:event_tf_discount_nameActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        select_serial();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_serial_nosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_serial_nosMouseClicked
        select();
    }//GEN-LAST:event_tbl_serial_nosMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_serial_nos;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_conversion;
    private javax.swing.JTextArea tf_desciption;
    private javax.swing.JTextField tf_discount_amount;
    private javax.swing.JTextField tf_discount_name;
    private javax.swing.JTextField tf_discount_rate;
    private javax.swing.JTextField tf_item_code;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JLabel tf_selling_price;
    private javax.swing.JTextField tf_uom;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();
        tf_qty.grabFocus();

        init_tbl_serial_nos();
//        sample();
    }

    public void do_pass(String item_code, String barcode, String description, double price, String serial_nos, String selected_serials) {
        tf_item_code.setText(item_code);
        tf_barcode.setText(barcode);
        tf_desciption.setText(description);
        tf_selling_price.setText(FitIn.fmt_wc_0(price));
        List<to_serial_nos> datas = new ArrayList();
        String[] serials = serial_nos.split("\n");
        String[] selected_serial = selected_serials.split("\n");
        for (String serial : serials) {
            if (!serial.isEmpty()) {
                to_serial_nos to = new to_serial_nos(-1, serial, false);
                datas.add(to);
            }

        }
        loadData_serial_nos(datas);
        for (String serial : selected_serial) {
            for (to_serial_nos to : datas) {
                if (serial.equals(to.serial_no)) {
                    to.setSelected(true);
                    tbl_serial_nos_M.fireTableDataChanged();
                    break;
                }
            }
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
    }
    // </editor-fold>

    private void focus() {
        JTextField[] tf = {tf_uom, tf_qty, tf_discount_name, tf_discount_rate, tf_discount_amount, jTextField1};
        JTextArea[] tf2 = {};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        Focus_Fire.onFocus_lostFocus(tf2);
        Focus_Fire.select_all(tf2);
    }

    private void ok() {

        double qty = FitIn.toDouble(tf_qty.getText());
        String uom = tf_uom.getText();
        double price = FitIn.toDouble(tf_selling_price.getText());
        double conversion = FitIn.toDouble(tf_conversion.getText());
        String discount_name = tf_discount_name.getText();
        double discount_rate = FitIn.toDouble(tf_discount_rate.getText());
        double discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        String serial_no = "";
        if (qty < 1) {
            tf_qty.grabFocus();
            return;
        }
        String selected_serials = "";
        List<to_serial_nos> datas = tbl_serial_nos_ALM;
        int i = 0;
        for (to_serial_nos to : datas) {
            if (to.selected == true) {
                if (i == 0) {
                    selected_serials = to.serial_no;
                } else {
                    selected_serials = selected_serials + "\n" + to.serial_no;
                }

                i++;
            }

        }
        System.out.println(selected_serials);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(qty, uom, price, conversion, discount_name, discount_rate, discount_amount, serial_no, selected_serials));
        }
    }

    List<S1_discounts.to_discounts> discount_list = new ArrayList();
    private void init_discount() {
        String search = tf_discount_name.getText();
        discount_list.clear();
        String where = " where discount_name like '%" + search + "%' ";
        discount_list = S1_discounts.ret_data3(search);
        Object[][] obj = new Object[discount_list.size()][2];
        int i = 0;
        for (S1_discounts.to_discounts to : discount_list) {
            obj[i][1] = " " + to.discount_name;
            obj[i][0] = " " + FitIn.fmt_wc_0(to.discount_rate);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, 50};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_discount_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_discounts.to_discounts to = discount_list.get(data.selected_row);
                tf_discount_amount.setText(FitIn.fmt_wc_0(0));
                tf_discount_rate.setText(FitIn.fmt_wc_0(to.discount_rate));
                tf_discount_name.setText(to.discount_name);
                if (to.id == -1) {
                    tf_discount_amount.grabFocus();
                }
                compute_discount();
            }
        });
    }

    private void compute_discount() {
        double amount_due = FitIn.toDouble(tf_selling_price.getText());
        double discount_rate = FitIn.toDouble(tf_discount_rate.getText());
        double discount_amount = discount_rate / 100;
        discount_amount = amount_due * discount_amount;
        tf_discount_amount.setText(FitIn.fmt_wc_0(discount_amount));
        double total = amount_due - discount_amount;

    }

    private ArrayListModel tbl_serial_nos_ALM;
    private Tblserial_nosModel tbl_serial_nos_M;

    private void init_tbl_serial_nos() {
        tbl_serial_nos_ALM = new ArrayListModel();
        tbl_serial_nos_M = new Tblserial_nosModel(tbl_serial_nos_ALM);
        tbl_serial_nos.getTableHeader().setPreferredSize(new Dimension(100, 0));
        tbl_serial_nos.setModel(tbl_serial_nos_M);
        tbl_serial_nos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_serial_nos.setRowHeight(25);
        int[] tbl_widths_serial_nos = {100, 30};
        for (int i = 0, n = tbl_widths_serial_nos.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_serial_nos, i, tbl_widths_serial_nos[i]);
        }
        Dimension d = tbl_serial_nos.getTableHeader().getPreferredSize();
        d.height = 25;

        tbl_serial_nos.setRowHeight(25);
        tbl_serial_nos.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_serial_nos(List<to_serial_nos> acc) {
        tbl_serial_nos_ALM.clear();
        tbl_serial_nos_ALM.addAll(acc);
    }

    public static class Tblserial_nosModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Serial No", "serial_no"
        };

        public Tblserial_nosModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_serial_nos tt = (to_serial_nos) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.serial_no;
                case 1:
                    return tt.selected;
                default:
                    return tt.serial_no;
            }
        }
    }

    private void sample() {

        List<to_serial_nos> datas = new ArrayList();
        for (int i = 1; i < 10; i++) {
            int id = i;
            String serial_no = "0000" + i;
            boolean selected = false;
            to_serial_nos to = new to_serial_nos(id, serial_no, selected);
            datas.add(to);
        }
        loadData_serial_nos(datas);
    }

    private void select() {
        int row = tbl_serial_nos.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_serial_nos to = (to_serial_nos) tbl_serial_nos_ALM.get(tbl_serial_nos.convertRowIndexToModel(row));
        if (to.selected == true) {
            to.setSelected(false);
        } else {
            to.setSelected(true);
        }
        tbl_serial_nos_M.fireTableDataChanged();
    }

    private void select_serial() {
        String serial = jTextField1.getText();
        List<to_serial_nos> datas = tbl_serial_nos_ALM;
        for (to_serial_nos to : datas) {
            if (to.serial_no.equals(serial)) {
                to.setSelected(true);
                tbl_serial_nos_M.fireTableDataChanged();
                break;
            }
        }
        jTextField1.setText("");
    }
}
