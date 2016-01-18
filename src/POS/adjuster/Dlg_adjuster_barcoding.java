/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjuster;

import POS.adjuster.S1_adjuster_barcoding.inv;
import POS.branch_locations.S1_branch_locations;
import POS.inventory.S1_inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.Inventory_barcodes.to_inventory_barcodes;
import POS.util.DateType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_adjuster_barcoding extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_adjuster
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
    private Dlg_adjuster_barcoding(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_adjuster_barcoding(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_adjuster_barcoding() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_adjuster_barcoding myRef;

    private void setThisRef(Dlg_adjuster_barcoding myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_adjuster_barcoding> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_adjuster_barcoding create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_adjuster_barcoding create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_adjuster_barcoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_adjuster_barcoding((java.awt.Frame) parent, false);
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
            Dlg_adjuster_barcoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_adjuster_barcoding((java.awt.Dialog) parent, false);
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

        Dlg_adjuster_barcoding dialog = Dlg_adjuster_barcoding.create(new javax.swing.JFrame(), true);
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
        tbl_inventory_barcodes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new Button.Default();
        jButton2 = new Button.Default();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new Button.Success();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane1.setViewportView(tbl_inventory_barcodes);

        jLabel1.setText("Total Count:");

        jLabel2.setText("0");

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Previous");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Item Code");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Adjust Barcoding");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("Adjust");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(3, 3, 3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        next();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        previous();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        adjust();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        set();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_inventory_barcodes;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_inventory_barcodes(tbl_inventory_barcodes);
        get_items();
        S1_inventory.to_inventory item = (S1_inventory.to_inventory) inventory_list.get(0);
        jTextField1.setText(item.barcode);
//        data_cols();
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

    //<editor-fold defaultstate="collapsed" desc=" inventory_barcodes "> 
    public static ArrayListModel tbl_inventory_barcodes_ALM;
    public static Tblinventory_barcodesModel tbl_inventory_barcodes_M;

    public static void init_tbl_inventory_barcodes(JTable tbl_inventory_barcodes) {
        tbl_inventory_barcodes_ALM = new ArrayListModel();
        tbl_inventory_barcodes_M = new Tblinventory_barcodesModel(tbl_inventory_barcodes_ALM);
        tbl_inventory_barcodes.setModel(tbl_inventory_barcodes_M);
        tbl_inventory_barcodes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_barcodes.setRowHeight(25);
        int[] tbl_widths_inventory_barcodes = {50, 100, 150, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    }

    public static void loadData_inventory_barcodes(List<to_inventory_barcodes> acc) {
        tbl_inventory_barcodes_ALM.clear();
        tbl_inventory_barcodes_ALM.addAll(acc);
    }

    public static class Tblinventory_barcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Branch", "Location", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "main_barcode", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id", "serial_no"
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
            to_inventory_barcodes tt = (to_inventory_barcodes) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.branch;
                case 3:
                    return " " + tt.location;
                case 4:
                    return tt.category;
                case 5:
                    return tt.category_id;
                case 6:
                    return tt.classification;
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
        String where = " where location_id=14 order by id asc";
        System.out.println(where);
        List<to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);
        for (to_inventory_barcodes to : datas) {
            System.out.println("Item Codes: " + to.main_barcode);
        }
        System.out.println("Items: " + datas.size() + " Code: " + jTextField1.getText());
        loadData_inventory_barcodes(datas);
    }
    List<S1_inventory.to_inventory> inventory_list = new ArrayList();
    int index = -1;

    private void get_items() {
        inventory_list = S1_inventory.ret_data22(" ");

        System.out.println("Size: " + inventory_list.size());
    }

    private void next() {
        index++;
        S1_inventory.to_inventory item = (S1_inventory.to_inventory) inventory_list.get(index);
        jTextField1.setText(item.barcode);
        data_cols();
    }

    private void previous() {
        index--;
        if (index < 0) {
            index = 0;
        }
        S1_inventory.to_inventory item = (S1_inventory.to_inventory) inventory_list.get(index);
        jTextField1.setText(item.barcode);
        data_cols();
    }

    private void set() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                List<S1_branch_locations.to_branch_locations> locations = S1_branch_locations.ret_data2("");

                List<inv> inventory = new ArrayList();
                List<to_inventory_barcodes> inventory_barcodes = new ArrayList();
                System.out.println("Starting.....");

                for (int i = 0; i < inventory_list.size(); i++) {
                    S1_inventory.to_inventory my_item = (S1_inventory.to_inventory) inventory_list.get(i);

                    System.out.println("Adding Item Code: " + my_item.barcode);
                    String where = " where main_barcode='" + my_item.barcode + "' order by barcode,branch asc";
                    List<to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);

                    String my_barcode = "";
                    for (to_inventory_barcodes t : datas) {
                        if (!t.barcode.isEmpty()) {
                            my_barcode = t.barcode;
                            break;
                        }
                    }

                    List<to_inventory_barcodes> with_qty = new ArrayList();

                    for (to_inventory_barcodes to : datas) {
                        if (to.product_qty < 0 || to.product_qty > 0 || !to.serial_no.isEmpty()) {
                            with_qty.add(to);
                        }
                    }

                    if (my_barcode.isEmpty()) {
                        inv in = new inv(my_item.barcode, my_barcode);
                        inventory.add(in);
                    }
                    for (S1_branch_locations.to_branch_locations location : locations) {
                        double qty = 0;
                        String serial_nos = "";
                        String barcodes = "";
                        String description = my_item.description;
                        int id = 0;
                        String barcode = my_barcode;
                        String generic_name = my_item.generic_name;
                        String category = my_item.category;
                        String category_id = my_item.category_id;
                        String classification = my_item.classification;
                        String classification_id = my_item.classification_id;
                        String sub_classification = my_item.sub_classification;
                        String sub_classification_id = my_item.sub_classification_id;
                        double product_qty = 0;
                        String unit = my_item.unit;
                        double conversion = my_item.conversion;
                        double selling_price = my_item.selling_price;
                        String date_added = DateType.now();
                        String user_name = my_item.user_name;
                        String item_type = my_item.item_type;
                        int status = my_item.status;
                        String supplier = my_item.supplier;
                        int fixed_price = my_item.fixed_price;
                        double cost = my_item.cost;
                        String supplier_id = my_item.supplier_id;
                        int multi_level_pricing = my_item.multi_level_pricing;
                        int vatable = my_item.vatable;
                        double reorder_level = my_item.reorder_level;
                        double markup = my_item.markup;
                        String main_barcode = my_item.barcode;
                        String brand = my_item.brand;
                        String brand_id = my_item.brand_id;
                        String model = my_item.model;
                        String model_id = my_item.model_id;
                        int selling_type = my_item.selling_type;
                        String branch = location.branch;
                        String branch_code = location.branch_id;
                        String locationss = location.location;
                        String location_id = "" + location.id;
                        String serial_no = "";
                        String selected_serials = "";
                        double discount = 0;
                        double discount_amount = 0;
                        String discount_name = "";
                        String discount_customer_name = "";
                        String discount_customer_id = "";
                        double addtl_amount = 0;
                        double wtax = 0;
                        for (to_inventory_barcodes to : with_qty) {
                            if (to.location_id.equals("" + location.id)) {
                                id = to.id;
                                product_qty = to.product_qty;
                                serial_nos = to.serial_no;
                                break;
                            }

                        }

                        Inventory_barcodes.to_inventory_barcodes codes = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, locationss, location_id, serial_no, selected_serials, discount, discount_amount, discount_name, discount_customer_name, discount_customer_id, addtl_amount, wtax);
                        inventory_barcodes.add(codes);
                    }

                }
                S1_adjuster_barcoding.delete_inventory();
                S1_adjuster_barcoding.edit_inventory(inventory, inventory_barcodes);
            }
        });
        t.start();

    }

    private void adjust() {
        int row = tbl_inventory_barcodes.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory_barcodes item = (to_inventory_barcodes) tbl_inventory_barcodes_ALM.get(row);
        List<to_inventory_barcodes> datas = tbl_inventory_barcodes_ALM;
        List<to_inventory_barcodes> with_qty = new ArrayList();
        for (to_inventory_barcodes to : datas) {
            if (to.product_qty < 0 || to.product_qty > 0) {
                with_qty.add(to);
            }
        }
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("Item Code: " + item.main_barcode);
        System.out.println("Barcode to use: " + item.barcode);

        List<S1_branch_locations.to_branch_locations> locations = S1_branch_locations.ret_data2("");
        for (S1_branch_locations.to_branch_locations location : locations) {
            double qty = 0;
            String serial_nos = "";
            for (to_inventory_barcodes to : with_qty) {
                if (to.location_id.equals("" + location.id)) {
                    qty = to.product_qty;
                    serial_nos = to.serial_no;
                    break;
                }

            }
            System.out.println("1Qty: " + qty + " Branch: " + location.branch + " Location: " + location.location + " Serial Nos: " + serial_nos);
//            System.out.println("Qty: " + qty + " Branch: " + location.branch + " Location: " + location.location + " Serial Nos: " + serial_nos);
        }
    }
}
