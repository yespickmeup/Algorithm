/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

import POS.disbursements.S1_disbursement_categories.to_disbursement_categories;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_disbursement_categories extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_disbursement_categories
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
    private Dlg_disbursement_categories(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_disbursement_categories(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_disbursement_categories() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_disbursement_categories myRef;

    private void setThisRef(Dlg_disbursement_categories myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_disbursement_categories> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_disbursement_categories create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_disbursement_categories create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_disbursement_categories dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursement_categories((java.awt.Frame) parent, false);
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
            Dlg_disbursement_categories dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursement_categories((java.awt.Dialog) parent, false);
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

        Dlg_disbursement_categories dialog = Dlg_disbursement_categories.create(new javax.swing.JFrame(), true);
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
        jLabel71 = new javax.swing.JLabel();
        tf_category_name = new Field.Input();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_disbursement_categories = new javax.swing.JTable();
        jButton35 = new Button.Primary();
        jButton36 = new Button.Info();
        jButton34 = new Button.Warning();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Category:");

        tf_category_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_category_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_category_nameMouseClicked(evt);
            }
        });
        tf_category_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_category_nameActionPerformed(evt);
            }
        });

        tbl_disbursement_categories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_disbursement_categories.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_disbursement_categories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_disbursement_categoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_disbursement_categories);

        jButton35.setText("Add");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setText("Update");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton34.setText("Delete");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_category_name))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_category_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(33, 33, 33))
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

    private void tf_category_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_category_nameMouseClicked

    }//GEN-LAST:event_tf_category_nameMouseClicked

    private void tf_category_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_category_nameActionPerformed

    }//GEN-LAST:event_tf_category_nameActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        add_disbursement_categories();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        update_disbursement_categories();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        delete_disbursement_categories();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void tbl_disbursement_categoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_disbursement_categoriesMouseClicked
        select_disbursement_categories();
    }//GEN-LAST:event_tbl_disbursement_categoriesMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_disbursement_categories;
    private javax.swing.JTextField tf_category_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        init_key();
        init_tbl_disbursement_categories(tbl_disbursement_categories);
        data_disbursement_categories();
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

    private void data_disbursement_categories() {
        String where = "";
        List<to_disbursement_categories> acc = S1_disbursement_categories.ret_data(where);
        loadData_disbursement_categories(acc);
    }

    //<editor-fold defaultstate="collapsed" desc=" disbursement_categories "> 
    public static ArrayListModel tbl_disbursement_categories_ALM;
    public static Tbldisbursement_categoriesModel tbl_disbursement_categories_M;

    public static void init_tbl_disbursement_categories(JTable tbl_disbursement_categories) {
        tbl_disbursement_categories_ALM = new ArrayListModel();
        tbl_disbursement_categories_M = new Tbldisbursement_categoriesModel(tbl_disbursement_categories_ALM);
        tbl_disbursement_categories.setModel(tbl_disbursement_categories_M);
        tbl_disbursement_categories.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_disbursement_categories.setRowHeight(25);
        int[] tbl_widths_disbursement_categories = {100, 0};
        for (int i = 0, n = tbl_widths_disbursement_categories.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_disbursement_categories, i, tbl_widths_disbursement_categories[i]);
        }
        Dimension d = tbl_disbursement_categories.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_disbursement_categories.getTableHeader().setPreferredSize(d);
        tbl_disbursement_categories.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_disbursement_categories.setRowHeight(25);
        tbl_disbursement_categories.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_disbursement_categories(List<to_disbursement_categories> acc) {
        tbl_disbursement_categories_ALM.clear();
        tbl_disbursement_categories_ALM.addAll(acc);
    }

    public static class Tbldisbursement_categoriesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Category", "category_name"
        };

        public Tbldisbursement_categoriesModel(ListModel listmodel) {
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
            to_disbursement_categories tt = (to_disbursement_categories) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.category_name;
                default:
                    return tt.category_name;
            }
        }
    }

//</editor-fold> 
    private void add_disbursement_categories() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Disbursement Categories - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int id = 0;
        String category_name = tf_category_name.getText();
        final to_disbursement_categories to = new to_disbursement_categories(id, category_name);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_disbursement_categories.add_data(to);
                tf_category_name.setText("");
                data_disbursement_categories();
                tf_category_name.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void select_disbursement_categories() {

        int row = tbl_disbursement_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_disbursement_categories to = (to_disbursement_categories) tbl_disbursement_categories_ALM.get(row);
        tf_category_name.setText(to.category_name);

    }

    private void update_disbursement_categories() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Disbursement Categories - (Edit)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_disbursement_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_disbursement_categories to = (to_disbursement_categories) tbl_disbursement_categories_ALM.get(row);
        int id = to.id;
        String category_name = tf_category_name.getText();

        final to_disbursement_categories to1 = new to_disbursement_categories(id, category_name);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to update this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_disbursement_categories.update_data(to1);
                tf_category_name.setText("");
                data_disbursement_categories();
                tf_category_name.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void delete_disbursement_categories() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Disbursement Categories - (Delete)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_disbursement_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_disbursement_categories to = (to_disbursement_categories) tbl_disbursement_categories_ALM.get(row);
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                S1_disbursement_categories.delete_data(to);
                tf_category_name.setText("");
                data_disbursement_categories();
                tf_category_name.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
}
