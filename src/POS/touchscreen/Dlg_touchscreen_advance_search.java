/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Inventory_barcodes;
import POS.util.TableRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Field;
import synsoftech.fields.Label;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_advance_search extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_advance_search
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

        public final String category_name;
        public final String category_id;
        public final String classification_name;
        public final String classification_id;
        public final String sub_classification_name;
        public final String sub_classification_id;
        public final String brand_name;
        public final String brand_id;
        public final String model_name;
        public final String model_id;
        public final String supplier_name;
        public final String supplier_id;

        public OutputData(String category_name, String category_id, String classification_name, String classification_id, String sub_classification_name, String sub_classification_id, String brand_name, String brand_id, String model_name, String model_id, String supplier_name, String supplier_id) {
            this.category_name = category_name;
            this.category_id = category_id;
            this.classification_name = classification_name;
            this.classification_id = classification_id;
            this.sub_classification_name = sub_classification_name;
            this.sub_classification_id = sub_classification_id;
            this.brand_name = brand_name;
            this.brand_id = brand_id;
            this.model_name = model_name;
            this.model_id = model_id;
            this.supplier_name = supplier_name;
            this.supplier_id = supplier_id;
        }
      

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_advance_search(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_advance_search(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_advance_search() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_advance_search myRef;

    private void setThisRef(Dlg_touchscreen_advance_search myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_advance_search> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_advance_search create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_advance_search create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_advance_search dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_advance_search((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_advance_search dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_advance_search((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_advance_search dialog = Dlg_touchscreen_advance_search.create(new javax.swing.JFrame(), true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new Label.Separator2();
        tf_category = new Field.Combo();
        jLabel3 = new Label.Success();
        tf_classificaition = new Field.Combo();
        tf_sub_classification = new Field.Combo();
        tf_brand = new Field.Combo();
        tf_model = new Field.Combo();
        tf_supplier = new Field.Combo();
        jLabel4 = new Label.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/binary5 (1).png"))); // NOI18N
        jLabel1.setText("Advance Search");

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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        tf_classificaition.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_classificaition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_classificaitionMouseClicked(evt);
            }
        });
        tf_classificaition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_classificaitionActionPerformed(evt);
            }
        });

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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Close");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_category, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addComponent(tf_classificaition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addComponent(tf_sub_classification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addComponent(tf_brand, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addComponent(tf_model, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addComponent(tf_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_classificaition, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_sub_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        ok();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tf_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoryActionPerformed
        init_category();
    }//GEN-LAST:event_tf_categoryActionPerformed

    private void tf_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_categoryMouseClicked
        init_category();
    }//GEN-LAST:event_tf_categoryMouseClicked

    private void tf_classificaitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_classificaitionActionPerformed
        init_classification();
    }//GEN-LAST:event_tf_classificaitionActionPerformed

    private void tf_classificaitionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_classificaitionMouseClicked
        init_classification();
    }//GEN-LAST:event_tf_classificaitionMouseClicked

    private void tf_sub_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sub_classificationActionPerformed
        init_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationActionPerformed

    private void tf_sub_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_sub_classificationMouseClicked
        init_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationMouseClicked

    private void tf_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_brandActionPerformed
        init_brand();
    }//GEN-LAST:event_tf_brandActionPerformed

    private void tf_brandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_brandMouseClicked
        init_brand();
    }//GEN-LAST:event_tf_brandMouseClicked

    private void tf_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_modelActionPerformed
        init_model();
    }//GEN-LAST:event_tf_modelActionPerformed

    private void tf_modelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_modelMouseClicked
        init_model();
    }//GEN-LAST:event_tf_modelMouseClicked

    private void tf_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_supplierActionPerformed
        init_supplier();
    }//GEN-LAST:event_tf_supplierActionPerformed

    private void tf_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_supplierMouseClicked
        init_supplier();
    }//GEN-LAST:event_tf_supplierMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        disposed();
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tf_brand;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_classificaition;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_sub_classification;
    private javax.swing.JTextField tf_supplier;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();

        Field.Combo category = (Field.Combo) tf_category;
        category.setPrompt("Category");
        Field.Combo classification = (Field.Combo) tf_classificaition;
        classification.setPrompt("Classification");
        Field.Combo sub_classification = (Field.Combo) tf_sub_classification;
        sub_classification.setPrompt("Sub-Classification");
        Field.Combo brand = (Field.Combo) tf_brand;
        brand.setPrompt("Brand");
        Field.Combo model = (Field.Combo) tf_model;
        model.setPrompt("Model");
        Field.Combo supplier = (Field.Combo) tf_supplier;
        supplier.setPrompt("Supplier");

        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        location_id = "" + to.id;
    }
    String location_id = "";

    private void init_category() {
        String search = (tf_category.getText());

        String where = " where category like '%" + search + "%' and location_id='" + location_id + "' group by category order by category asc";
        final List<Inventory_barcodes.to_inventory_barcodes> items = Advance_search.ret_data(where);
        Object[][] obj = new Object[items.size()][1];
        int i = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : items) {
            obj[i][0] = " " + to.category;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_category, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {

                Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) items.get(data.selected_row);
                tf_category.setText(to.category);
            }
        });
    }

    private void init_classification() {
        String search = (tf_classificaition.getText());

        String where = " where classification like '%" + search + "%' and location_id='" + location_id + "' group by classification order by classification asc";
        final List<Inventory_barcodes.to_inventory_barcodes> items = Advance_search.ret_data(where);
        Object[][] obj = new Object[items.size()][1];
        int i = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : items) {
            obj[i][0] = " " + to.classification;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_classificaition.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_classificaition, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {

                Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) items.get(data.selected_row);
                tf_classificaition.setText(to.classification);
            }
        });
    }

    private void init_sub_classification() {
        String search = (tf_sub_classification.getText());

        String where = " where sub_classification like '%" + search + "%' and location_id='" + location_id + "' group by sub_classification order by sub_classification asc";
        final List<Inventory_barcodes.to_inventory_barcodes> items = Advance_search.ret_data(where);
        Object[][] obj = new Object[items.size()][1];
        int i = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : items) {
            obj[i][0] = " " + to.sub_classification;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_sub_classification.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_sub_classification, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {

                Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) items.get(data.selected_row);
                tf_sub_classification.setText(to.sub_classification);
            }
        });
    }

    private void init_brand() {
        String search = (tf_brand.getText());

        String where = " where brand like '%" + search + "%' and location_id='" + location_id + "' group by brand order by brand asc";
        final List<Inventory_barcodes.to_inventory_barcodes> items = Advance_search.ret_data(where);
        Object[][] obj = new Object[items.size()][1];
        int i = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : items) {
            obj[i][0] = " " + to.brand;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_brand.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_brand, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {

                Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) items.get(data.selected_row);
                tf_brand.setText(to.brand);
            }
        });
    }

    private void init_model() {
        String search = (tf_model.getText());

        String where = " where model like '%" + search + "%' and location_id='" + location_id + "' group by model order by model asc";
        final List<Inventory_barcodes.to_inventory_barcodes> items = Advance_search.ret_data(where);
        Object[][] obj = new Object[items.size()][1];
        int i = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : items) {
            obj[i][0] = " " + to.model;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_model.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_model, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {

                Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) items.get(data.selected_row);
                tf_model.setText(to.model);
            }
        });
    }

    private void init_supplier() {
        String search = (tf_supplier.getText());

        String where = " where supplier like '%" + search + "%' and location_id='" + location_id + "' group by supplier order by supplier asc";
        final List<Inventory_barcodes.to_inventory_barcodes> items = Advance_search.ret_data(where);
        Object[][] obj = new Object[items.size()][1];
        int i = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : items) {
            obj[i][0] = " " + to.supplier;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_supplier.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_supplier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {
                Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) items.get(data.selected_row);
                tf_supplier.setText(to.supplier);
            }
        });
    }

    public void do_pass() {

    }

    private void ok() {
        String category_name=tf_category.getText();
        String category_id="";
        String classification_name=tf_classificaition.getText();
        String classification_id="";
        String sub_classification_name=tf_sub_classification.getText();
        String sub_classification_id="";
        String brand_name=tf_brand.getText();
        String brand_id="";
        String model_name=tf_model.getText();
        String model_id="";
        String supplier_name=tf_supplier.getText();
        String supplier_id="";
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(category_name, category_id, classification_name, classification_id
                    , sub_classification_name, sub_classification_id, brand_name, brand_id, model_name, model_id,supplier_name,supplier_id));
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

}
