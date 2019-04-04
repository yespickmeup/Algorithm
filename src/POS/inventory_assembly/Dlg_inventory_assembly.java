/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory_assembly;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.S2_inventory_barcodes;
import POS.inventory.uom;
import POS.inventory_assembly.Inventory_assembly.to_inventory_assembly;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_delete;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
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
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_inventory_assembly extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_inventory_assembly
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

        public final List<Inventory_barcodes.to_inventory_barcodes> assemble;

        public OutputData(List<Inventory_barcodes.to_inventory_barcodes> assemble) {
            this.assemble = assemble;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_inventory_assembly(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_inventory_assembly(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_inventory_assembly() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_inventory_assembly myRef;

    private void setThisRef(Dlg_inventory_assembly myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory_assembly> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory_assembly create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.APPLICATION_MODAL);

    }

    public static Dlg_inventory_assembly create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory_assembly dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_assembly((java.awt.Frame) parent, false);
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
            Dlg_inventory_assembly dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_assembly((java.awt.Dialog) parent, false);
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

        Dlg_inventory_assembly dialog = Dlg_inventory_assembly.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory_assembly = new javax.swing.JTable();
        tf_search = new Field.Search();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jButton3 = new Button.Warning();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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
        jScrollPane1.setViewportView(tbl_inventory_assembly);

        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel1.setText("Status:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Selling Price:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Items:");

        jLabel4.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Item Code:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Barcode:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Description:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setFocusable(false);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField4)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(tf_search)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2))))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_search)
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_inventory_barcodes2();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tbl_inventory_assemblyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory_assemblyMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_inventory_assemblyMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete_all();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tbl_inventory_assembly;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        set_default_branch();

        init_tbl_inventory_assembly(tbl_inventory_assembly);
        focus();
    }

    private void focus() {
        JTextField[] tf = {tf_search, jTextField2, jTextField1};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }
    String locations_ids = "";

    Inventory_barcodes.to_inventory_barcodes main_item = null;

    public void do_pass(Inventory_barcodes.to_inventory_barcodes item) {
        main_item = item;
        main_item.setProduct_qty(1);
        jTextField2.setFocusable(false);
        jTextField2.setText(item.main_barcode);
        jTextField3.setText(item.barcode);
        jTextField4.setText(item.description);
        jTextField1.setText(FitIn.fmt_wc_0(item.selling_price));
        ret_uoms();
        tf_search.grabFocus();

    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        locations_ids = "" + to.id;
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

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " "
                        + " where main_barcode like '%" + search + "%' "
                        + " and location_id='" + locations_ids + "' "
                        + " or barcode='" + search + "' and location_id='" + locations_ids + "'"
                        + " or description like  '%" + search + "%' and location_id='" + locations_ids + "'"
                        + " ";
                inventory_barcoders_list.clear();
                inventory_barcoders_list = S2_inventory_barcodes.ret_data(where);
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
                if (inventory_barcoders_list.size() > 0) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.barcode;
                        obj[i][3] = " " + to.description;
                        obj[i][4] = " " + to.unit;
                        obj[i][5] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 70, 70, w - 70, 70, 70};
                    String[] col_names = {"Qty", "Item Code", "Barcode", "Unit", "Description", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes to = inventory_barcoders_list.get(data.selected_row);
                            enter_qty(to);
                        }
                    });
                }

            }
        });
        t.start();
    }

    private void enter_qty(final Inventory_barcodes.to_inventory_barcodes to) {
        Window p = (Window) this;
        Dlg_inventory_assembly_qty nd = Dlg_inventory_assembly_qty.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_assembly_qty.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_assembly_qty.OutputData data) {
                closeDialog.ok();
                int id = 0;
                String main_item_code = jTextField2.getText();
                String main_barcode = jTextField3.getText();
                String item_code = to.main_barcode;
                String description = to.description;
                String generic_name = to.generic_name;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_classification = to.sub_classification;
                String sub_classification_id = to.sub_classification_id;
                double product_qty = data.qty;
                String unit = to.unit;
                double conversion = to.conversion;
                double selling_price = 0;
                String date_added = DateType.now();
                String user_name = MyUser.getUser_id();
                String item_type = to.item_type;
                int status = 0;
                String supplier = to.supplier;
                int fixed_price = to.fixed_price;
                double cost = to.cost;
                String supplier_id = to.supplier_id;
                int multi_level_pricing = to.multi_level_pricing;
                int vatable = to.vatable;
                double reorder_level = to.reorder_level;
                double markup = to.markup;
                String barcodes = to.barcode;
                String brand = to.brand;
                String brand_id = to.brand_id;
                String model = to.model;
                String model_id = to.model_id;
                int selling_type = to.selling_type;
                String branch = to.branch;
                String branch_code = to.branch_code;
                String location = to.location;
                String location_id = to.location_id;
                to_inventory_assembly field = new to_inventory_assembly(id, main_item_code, main_barcode, item_code, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, true);
                Inventory_assembly.add_data(field);
                ret_uoms();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ret_uoms() {
        String item_code = jTextField2.getText();
        String where = " where main_item_code='" + item_code + "' ";
        List<to_inventory_assembly> datas = Inventory_assembly.ret_data(where);
        loadData_inventory_assembly(datas);
    }
    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list2 = new ArrayList();

    private void init_inventory_barcodes2() {
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String search = jTextField2.getText();
                String where = " "
                        + "where main_barcode like '%" + search + "%' "
                        + "and location_id='" + locations_ids + "' "
                        + " or barcode='" + search + "' and location_id='" + locations_ids + "'"
                        + " or description like  '%" + search + "%' and location_id='" + locations_ids + "'"
                        + " ";
                inventory_barcoders_list2.clear();
                inventory_barcoders_list2 = S2_inventory_barcodes.ret_data(where);
                if (inventory_barcoders_list2.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
                if (inventory_barcoders_list2.size() > 0) {
                    Object[][] obj = new Object[inventory_barcoders_list2.size()][6];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list2) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.barcode;
                        obj[i][3] = " " + to.description;
                        obj[i][4] = " " + to.unit;
                        obj[i][5] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = jTextField2.getWidth();

                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 40, 100, 350, 70, 70};
                    String[] col_names = {"Qty", "Item Code", "Barcode", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup2(jTextField2, obj, labels, tbl_widths_customers, col_names, tf_search.getWidth() - 70);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes to = inventory_barcoders_list2.get(data.selected_row);
                            int id = 0;
                            String main_item_code = jTextField2.getText();
                            String main_barcode = jTextField3.getText();
                            String item_code = to.main_barcode;
                            String description = to.description;
                            String generic_name = to.generic_name;
                            String category = to.category;
                            String category_id = to.category_id;
                            String classification = to.classification;
                            String classification_id = to.classification_id;
                            String sub_classification = to.sub_classification;
                            String sub_classification_id = to.sub_classification_id;
                            double product_qty = 1;
                            String unit = to.unit;

                            String uoms = "";
                            double new_price = to.selling_price;

                            String[] list = unit.split(",");
                            int index = 0;
                            for (String s : list) {
                                int i = s.indexOf(":");
                                int ii = s.indexOf("/");
                                int iii = s.indexOf("^");
                                String uom = s.substring(1, i);
                                double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                                double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
                                int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));

                                if (is_default == 1) {
                                    selling_price = to.selling_price;
                                }
                                if (index == 0) {
                                    uoms = "[" + uom + ":" + new_price + "/" + conversion + "^" + is_default + "]";
                                } else {
                                    uoms = uoms + ",[" + uom + ":" + selling_price + "/" + conversion + "^" + is_default + "]";
                                }
                                index++;
                            }

                            unit = uoms;
                            double conversion = to.conversion;
                            double selling_price = 0;
                            String date_added = DateType.now();
                            String user_name = MyUser.getUser_id();
                            String item_type = to.item_type;
                            int status = 0;
                            String supplier = to.supplier;
                            int fixed_price = to.fixed_price;
                            double cost = to.cost;
                            String supplier_id = to.supplier_id;
                            int multi_level_pricing = to.multi_level_pricing;
                            int vatable = to.vatable;
                            double reorder_level = to.reorder_level;
                            double markup = to.markup;
                            String barcodes = to.barcode;
                            String brand = to.brand;
                            String brand_id = to.brand_id;
                            String model = to.model;
                            String model_id = to.model_id;
                            int selling_type = to.selling_type;
                            String branch = to.branch;
                            String branch_code = to.branch_code;
                            String location = to.location;
                            String location_id = to.location_id;
                            to_inventory_assembly field = new to_inventory_assembly(id, main_item_code, main_barcode, item_code, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false);
                            jTextField2.setText(to.main_barcode);
                            jTextField3.setText(to.barcode);
                            jTextField4.setText(to.description);
                            jTextField1.setText(FitIn.fmt_wc_0(to.selling_price));
                            ret_uoms();
                            tf_search.grabFocus();

                        }
                    });
                }

            }
        });
        t.start();
    }

    //<editor-fold defaultstate="collapsed" desc=" inventory_assembly "> 
    public static ArrayListModel tbl_inventory_assembly_ALM;
    public static Tblinventory_assemblyModel tbl_inventory_assembly_M;

    public static void init_tbl_inventory_assembly(JTable tbl_inventory_assembly) {
        tbl_inventory_assembly_ALM = new ArrayListModel();
        tbl_inventory_assembly_M = new Tblinventory_assemblyModel(tbl_inventory_assembly_ALM);
        tbl_inventory_assembly.setModel(tbl_inventory_assembly_M);
        tbl_inventory_assembly.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_assembly.setRowHeight(25);
        int[] tbl_widths_inventory_assembly = {50, 0, 70, 110, 100, 50, 100, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_assembly.length; i < n; i++) {
            if (i == 4) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inventory_assembly, i, tbl_widths_inventory_assembly[i]);
        }
        Dimension d = tbl_inventory_assembly.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_inventory_assembly.getTableHeader().setPreferredSize(d);
        tbl_inventory_assembly.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_inventory_assembly.setRowHeight(25);
        tbl_inventory_assembly.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_inventory_assembly, 6);
    }

    public static void loadData_inventory_assembly(List<to_inventory_assembly> acc) {
        tbl_inventory_assembly_ALM.clear();
        tbl_inventory_assembly_ALM.addAll(acc);

    }

    public static class Tblinventory_assemblyModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Avail.", "Item Code", "Barcode", "Description", "Unit", "Amount", "", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "barcodes", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id"
        };

        public Tblinventory_assemblyModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 7) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_inventory_assembly tt = (to_inventory_assembly) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty) + " ";
                case 1:
                    return "";
                case 2:
                    return " " + tt.item_code;
                case 3:
                    return " " + tt.barcodes;
                case 4:
                    return " " + tt.description;
                case 5:
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    return " " + uoms.uom;

                case 6:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 7:
                    return tt.selected;
                case 8:
                    return tt.classification_id;
                case 9:
                    return tt.sub_classification;
                case 10:
                    return tt.sub_classification_id;
                case 11:
                    return tt.product_qty;
                case 12:
                    return tt.unit;
                case 13:
                    return tt.conversion;
                case 14:
                    return tt.selling_price;
                case 15:
                    return tt.date_added;
                case 16:
                    return tt.user_name;
                case 17:
                    return tt.item_type;
                case 18:
                    return tt.status;
                case 19:
                    return tt.supplier;
                case 20:
                    return tt.fixed_price;
                case 21:
                    return tt.cost;
                case 22:
                    return tt.supplier_id;
                case 23:
                    return tt.multi_level_pricing;
                case 24:
                    return tt.vatable;
                case 25:
                    return tt.reorder_level;
                case 26:
                    return tt.markup;
                case 27:
                    return tt.barcodes;
                case 28:
                    return tt.brand;
                case 29:
                    return tt.brand_id;
                case 30:
                    return tt.model;
                case 31:
                    return tt.model_id;
                case 32:
                    return tt.selling_type;
                case 33:
                    return tt.branch;
                case 34:
                    return tt.branch_code;
                case 35:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }
//</editor-fold> 

    private void select_item() {
        int row = tbl_inventory_assembly.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_inventory_assembly field = (to_inventory_assembly) tbl_inventory_assembly_ALM.get(row);
        int col = tbl_inventory_assembly.getSelectedColumn();
        if (col == 7) {
            if (field.selected == true) {
                field.setSelected(false);
            } else {
                field.setSelected(true);
            }
            tbl_inventory_assembly_M.fireTableDataChanged();
        }
        if (col == 6) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Inventory_assembly.delete_data(field);
                    ret_uoms();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }
    }

    private void ok() {
        List<to_inventory_assembly> datas = tbl_inventory_assembly_ALM;
        List<to_inventory_assembly> datas2 = new ArrayList();
        for (to_inventory_assembly to : datas) {
            if (to.selected == true) {
                datas2.add(to);
            }
        }
        List<Inventory_barcodes.to_inventory_barcodes> order = new ArrayList();
        order.add(main_item);
        order.addAll(Inventory_assembly.convert_to_inventory_barcodes2(datas2));

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(order));
        }
    }

    private void delete_all() {
        List<to_inventory_assembly> datas = tbl_inventory_assembly_ALM;
        final List<to_inventory_assembly> datas2 = new ArrayList();
        for (to_inventory_assembly to : datas) {
            if (to.selected == true) {
                datas2.add(to);
            }
        }

        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                Inventory_assembly.delete_assembly(datas2);
                Alert.set(3, "");
                ret_uoms();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

}
