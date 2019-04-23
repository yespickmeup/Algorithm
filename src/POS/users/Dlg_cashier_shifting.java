/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.users.Cashier_shifts.to_cashier_shifts;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
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
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Ronescape
 */
public class Dlg_cashier_shifting extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cashier_shifting
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
    private Dlg_cashier_shifting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_cashier_shifting(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_cashier_shifting() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_cashier_shifting myRef;

    private void setThisRef(Dlg_cashier_shifting myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cashier_shifting> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cashier_shifting create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cashier_shifting create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cashier_shifting dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashier_shifting((java.awt.Frame) parent, false);
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
            Dlg_cashier_shifting dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashier_shifting((java.awt.Dialog) parent, false);
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

        Dlg_cashier_shifting dialog = Dlg_cashier_shifting.create(new javax.swing.JFrame(), true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_cashier3 = new Field.Combo();
        tf_screen_name = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tf_cashier4 = new Field.Combo();
        jButton4 = new Button.Default();
        jButton5 = new Button.Primary();
        jButton3 = new Button.Info();
        jButton2 = new Button.Warning();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cashier_shifts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cashier Shifts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14)))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Description:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Time from:");

        tf_cashier3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier3.setText("12:00am");
        tf_cashier3.setFocusable(false);
        tf_cashier3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashier3MouseClicked(evt);
            }
        });
        tf_cashier3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashier3ActionPerformed(evt);
            }
        });

        tf_screen_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_screen_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Time to:");

        tf_cashier4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier4.setText("11:59pm");
        tf_cashier4.setFocusable(false);
        tf_cashier4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashier4MouseClicked(evt);
            }
        });
        tf_cashier4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashier4ActionPerformed(evt);
            }
        });

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbl_cashier_shifts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cashier_shifts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cashier_shiftsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cashier_shifts);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_cashier3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_cashier4))
                            .addComponent(tf_screen_name))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_screen_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cashier3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cashier4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tf_cashier4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashier4MouseClicked
        init_time(tf_cashier4);
    }//GEN-LAST:event_tf_cashier4MouseClicked

    private void tf_cashier4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashier4ActionPerformed
        init_time(tf_cashier4);
    }//GEN-LAST:event_tf_cashier4ActionPerformed

    private void tf_cashier3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashier3MouseClicked
        init_time(tf_cashier3);
    }//GEN-LAST:event_tf_cashier3MouseClicked

    private void tf_cashier3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashier3ActionPerformed
        init_time(tf_cashier3);
    }//GEN-LAST:event_tf_cashier3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        clear_users();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        add_cashier_shift();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        edit_users();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        delete_users();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_cashier_shiftsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cashier_shiftsMouseClicked
        select_cashier_shift();
    }//GEN-LAST:event_tbl_cashier_shiftsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cashier_shifts;
    private javax.swing.JTextField tf_cashier3;
    private javax.swing.JTextField tf_cashier4;
    private javax.swing.JTextField tf_screen_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_store");

        time_list = DateType.time();
        init_key();
        init_tbl_cashier_shifts(tbl_cashier_shifts);
        ret_cashier_shifts();

    }
    List<String> time_list = new ArrayList();

    private void init_time(final JTextField tf) {

        Object[][] obj = new Object[time_list.size()][1];
        int i = 0;
        for (String to : time_list) {
            obj[i][0] = " " + to;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo f = (Field.Combo) tf;
                String to = (String) time_list.get(data.selected_row);
                f.setText(to);
            }
        });
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

    //<editor-fold defaultstate="collapsed" desc=" cashier_shifts "> 
    public static ArrayListModel tbl_cashier_shifts_ALM;
    public static Tblcashier_shiftsModel tbl_cashier_shifts_M;

    public static void init_tbl_cashier_shifts(JTable tbl_cashier_shifts) {
        tbl_cashier_shifts_ALM = new ArrayListModel();
        tbl_cashier_shifts_M = new Tblcashier_shiftsModel(tbl_cashier_shifts_ALM);
        tbl_cashier_shifts.setModel(tbl_cashier_shifts_M);
        tbl_cashier_shifts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cashier_shifts.setRowHeight(25);
        int[] tbl_widths_cashier_shifts = {100, 150, 50, 50, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cashier_shifts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cashier_shifts, i, tbl_widths_cashier_shifts[i]);
        }
        Dimension d = tbl_cashier_shifts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cashier_shifts.getTableHeader().setPreferredSize(d);
        tbl_cashier_shifts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cashier_shifts.setRowHeight(25);
        tbl_cashier_shifts.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_cashier_shifts(List<to_cashier_shifts> acc) {
        tbl_cashier_shifts_ALM.clear();
        tbl_cashier_shifts_ALM.addAll(acc);
    }

    public static class Tblcashier_shiftsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Description", "Shift", "", "", "updated_by", "description", "shift", "status", "is_uploaded"
        };

        public Tblcashier_shiftsModel(ListModel listmodel) {
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
            to_cashier_shifts tt = (to_cashier_shifts) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.description;
                case 1:
                    return " " + tt.shift;
                case 2:
                    return " Assign";
                case 3:
                    return " Delete";
                case 4:
                    return tt.updated_by;
                case 5:
                    return tt.description;
                case 6:
                    return tt.shift;
                case 7:
                    return tt.status;
                default:
                    return tt.is_uploaded;
            }
        }
    }

    private void ret_cashier_shifts() {
        String where = "";
        List<Cashier_shifts.to_cashier_shifts> shifts = Cashier_shifts.ret_data(where);
        loadData_cashier_shifts(shifts);
        jLabel2.setText("" + shifts.size());
    }
//</editor-fold> 

    private void add_cashier_shift() {
        int id = 0;
        String created_at = DateType.now();
        String created_by = MyUser.getUser_id();
        String updated_at = DateType.now();
        String updated_by = MyUser.getUser_id();
        String description = tf_screen_name.getText();
        String shift = tf_cashier3.getText() + " - " + tf_cashier4.getText();
        int status = 1;
        int is_uploaded = 0;
        if (description.isEmpty()) {
            Alert.set(0, "Input Description");
            return;
        }
        final Cashier_shifts.to_cashier_shifts sf = new Cashier_shifts.to_cashier_shifts(id, created_at, created_by, updated_at, updated_by, description, shift, status, is_uploaded);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Cashier_shifts.add_data(sf);
                ret_cashier_shifts();
                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void select_cashier_shift() {
        int row = tbl_cashier_shifts.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_cashier_shifts.getSelectedColumn();
        if (col == 3) {
            final Cashier_shifts.to_cashier_shifts sf = (Cashier_shifts.to_cashier_shifts) tbl_cashier_shifts_ALM.get(row);
            
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Cashier_shifts.delete_data(sf);
                    ret_cashier_shifts();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 2) {
            final Cashier_shifts.to_cashier_shifts sf = (Cashier_shifts.to_cashier_shifts) tbl_cashier_shifts_ALM.get(row);

            Window p = (Window) this;
            Dlg_cashier_shift_schedules nd = Dlg_cashier_shift_schedules.create(p, true);
            nd.setTitle("");
            nd.do_pass(sf);
            nd.setCallback(new Dlg_cashier_shift_schedules.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_cashier_shift_schedules.OutputData data) {
                    closeDialog.ok();
                    Cashier_shifts.delete_data(sf);
                    ret_cashier_shifts();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
}
