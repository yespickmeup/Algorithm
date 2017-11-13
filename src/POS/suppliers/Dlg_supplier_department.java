/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.suppliers;

import POS.suppliers.Supplier_departments.to_supplier_departments;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
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
import synsoftech.util.ImageRenderer1;

/**
 *
 * @author Guinness
 */
public class Dlg_supplier_department extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_template
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
    private Dlg_supplier_department(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_supplier_department(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_supplier_department() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_supplier_department myRef;

    private void setThisRef(Dlg_supplier_department myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_supplier_department> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_supplier_department create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_supplier_department create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_supplier_department dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_supplier_department((java.awt.Frame) parent, false);
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
            Dlg_supplier_department dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_supplier_department((java.awt.Dialog) parent, false);
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

        Dlg_supplier_department dialog = Dlg_supplier_department.create(new javax.swing.JFrame(), true);
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
        tbl_customer_departments = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new Field.Input();
        jLabel4 = new javax.swing.JLabel();
        tf_search = new Field.Search();
        jButton4 = new Button.Default();
        jButton3 = new Button.Success();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_customer_departments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_customer_departments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customer_departmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_customer_departments);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel3.setText("Status:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Department:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addComponent(tf_search))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25))
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
        ret_departments();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear_department();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        save_department();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_customer_departmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customer_departmentsMouseClicked
        select_department();
    }//GEN-LAST:event_tbl_customer_departmentsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_customer_departments;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        System.setProperty("pool_db", "db_algorithm");
        init_key();
        Field.Search search = (Field.Search) tf_search;
        search.setPrompt("Search");

        init_tbl_customer_departments(tbl_customer_departments);
        ret_departments();
    }
    int is_callback = 0;
    
    public void do_pass() {
        is_callback = 1;
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
    
    //<editor-fold defaultstate="collapsed" desc=" supplier_departments "> 
    public static ArrayListModel tbl_customer_departments_ALM;
    public static Tblcustomer_departmentsModel tbl_customer_departments_M;

    public static void init_tbl_customer_departments(JTable tbl_customer_departments) {
        tbl_customer_departments_ALM = new ArrayListModel();
        tbl_customer_departments_M = new Tblcustomer_departmentsModel(tbl_customer_departments_ALM);
        tbl_customer_departments.setModel(tbl_customer_departments_M);
        tbl_customer_departments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_customer_departments.setRowHeight(25);
        int[] tbl_widths_customer_departments = {100, 30, 30, 0, 0, 0};
        for (int i = 0, n = tbl_widths_customer_departments.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_customer_departments, i, tbl_widths_customer_departments[i]);
        }
        Dimension d = tbl_customer_departments.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_customer_departments.getTableHeader().setPreferredSize(d);
        tbl_customer_departments.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_customer_departments.setRowHeight(25);
        tbl_customer_departments.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_customer_departments.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer1());
        tbl_customer_departments.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_customer_departments(List<to_supplier_departments> acc) {
        tbl_customer_departments_ALM.clear();
        tbl_customer_departments_ALM.addAll(acc);
    }

    public static class Tblcustomer_departmentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Department", "", "", "updated_at", "created_by", "updated_by"
        };

        public Tblcustomer_departmentsModel(ListModel listmodel) {
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
            to_supplier_departments tt = (to_supplier_departments) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.department;
                case 1:
                    return "/POS/icon_payment/edit (1).png";
                case 2:
                    return "/POS/icon_payment/remove11.png";
                case 3:
                    return tt.updated_at;
                case 4:
                    return tt.created_by;
                default:
                    return tt.updated_by;
            }
        }
    }

    private void ret_departments() {
        List<to_supplier_departments> datas = Supplier_departments.ret_data(" order by department asc ");
        loadData_customer_departments(datas);
        jLabel2.setText("" + datas.size());
    }

    private void clear_department() {
        jTextField1.setText("");
        tbl_customer_departments.clearSelection();
        jTextField1.grabFocus();
    }

    private void save_department() {
        int row = tbl_customer_departments.getSelectedRow();
        if (row < 0) {
            int id = 0;
            String department = jTextField1.getText();
            String created_at = DateType.now();
            String updated_at = DateType.now();
            String created_by = MyUser.getUser_id();
            String updated_by = MyUser.getUser_id();
            final to_supplier_departments dep = new to_supplier_departments(id, department, created_at, updated_at, created_by, updated_by);
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Supplier_departments.add_data(dep);
                    ret_departments();
                    clear_department();
                    Alert.set(1, "");
                    if (is_callback == 1) {
                        ok1();
                    }

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            to_supplier_departments to = (to_supplier_departments) tbl_customer_departments_ALM.get(row);
            int id = to.id;
            String department = jTextField1.getText();
            String created_at = to.created_at;
            String updated_at = DateType.now();
            String created_by = to.created_by;
            String updated_by = MyUser.getUser_id();
            final to_supplier_departments dep = new to_supplier_departments(id, department, created_at, updated_at, created_by, updated_by);
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Supplier_departments.update_data(dep);
                    ret_departments();
                    clear_department();
                    Alert.set(2, "");
                    if (is_callback == 1) {
                        ok1();
                    }
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }
    }

    private void select_department() {
        int row = tbl_customer_departments.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_supplier_departments to = (to_supplier_departments) tbl_customer_departments_ALM.get(row);
        int col = tbl_customer_departments.getSelectedColumn();
        if (col == 1) {
            jTextField1.setText(to.department);
            jTextField1.grabFocus();
        }
        if (col == 2) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Supplier_departments.delete_data(to);
                    ret_departments();
                    clear_department();
                    Alert.set(3, "");
                    if (is_callback == 1) {
                        ok1();
                    }
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
//</editor-fold> 

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
