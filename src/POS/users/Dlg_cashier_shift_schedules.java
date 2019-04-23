/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.util.Alert;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Ronescape
 */
public class Dlg_cashier_shift_schedules extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cashier_shift_schedules
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
    private Dlg_cashier_shift_schedules(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_cashier_shift_schedules(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_cashier_shift_schedules() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_cashier_shift_schedules myRef;

    private void setThisRef(Dlg_cashier_shift_schedules myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cashier_shift_schedules> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cashier_shift_schedules create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cashier_shift_schedules create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cashier_shift_schedules dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashier_shift_schedules((java.awt.Frame) parent, false);
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
            Dlg_cashier_shift_schedules dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashier_shift_schedules((java.awt.Dialog) parent, false);
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

        Dlg_cashier_shift_schedules dialog = Dlg_cashier_shift_schedules.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cashier_shift_schedules = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_screen_name = new Field.Input();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Cashier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_cashier_shift_schedules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cashier_shift_schedules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cashier_shift_schedulesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cashier_shift_schedules);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Shift:");

        tf_screen_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_screen_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_screen_name.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_screen_name)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_screen_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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

    private void tbl_cashier_shift_schedulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cashier_shift_schedulesMouseClicked
        select_shift();
    }//GEN-LAST:event_tbl_cashier_shift_schedulesMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cashier_shift_schedules;
    private javax.swing.JTextField tf_screen_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_store");

        init_key();
        init_tbl_cashier_shift_schedules(tbl_cashier_shift_schedules);
        ret_shifts();
    }

    public void do_pass(Cashier_shifts.to_cashier_shifts sf) {
        Field.Input s = (Field.Input) tf_screen_name;
        s.setText(sf.shift);
        s.setId("" + sf.id);
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

    //<editor-fold defaultstate="collapsed" desc=" cashier_shift_schedules "> 
    public static ArrayListModel tbl_cashier_shift_schedules_ALM;
    public static Tblcashier_shift_schedulesModel tbl_cashier_shift_schedules_M;

    public static void init_tbl_cashier_shift_schedules(JTable tbl_cashier_shift_schedules) {
        tbl_cashier_shift_schedules_ALM = new ArrayListModel();
        tbl_cashier_shift_schedules_M = new Tblcashier_shift_schedulesModel(tbl_cashier_shift_schedules_ALM);
        tbl_cashier_shift_schedules.setModel(tbl_cashier_shift_schedules_M);
        tbl_cashier_shift_schedules.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cashier_shift_schedules.setRowHeight(25);
        int[] tbl_widths_cashier_shift_schedules = {100, 150, 30, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cashier_shift_schedules.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cashier_shift_schedules, i, tbl_widths_cashier_shift_schedules[i]);
        }
        Dimension d = tbl_cashier_shift_schedules.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cashier_shift_schedules.getTableHeader().setPreferredSize(d);
        tbl_cashier_shift_schedules.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cashier_shift_schedules.setRowHeight(25);
        tbl_cashier_shift_schedules.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_cashier_shift_schedules(List<Cashier_shift_schedules.shift_cashiers> acc) {
        tbl_cashier_shift_schedules_ALM.clear();
        tbl_cashier_shift_schedules_ALM.addAll(acc);
    }

    public static class Tblcashier_shift_schedulesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Screen Name", "Shift", "", "updated_at", "updated_by", "cashier_id", "cashier_name", "cashier_shift_id", "cashier_shift", "status", "is_uploaded"
        };

        public Tblcashier_shift_schedulesModel(ListModel listmodel) {
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
            if (col == 2) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Cashier_shift_schedules.shift_cashiers tt = (Cashier_shift_schedules.shift_cashiers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.cashier_screen_name;
                case 1:
                    return " " + tt.shift;
                case 2:
                    return tt.selected;
                case 3:
                    return tt.cashier_id;
                case 4:
                    return tt.cashier_id;
                case 5:
                    return tt.cashier_id;
                case 6:
                    return tt.cashier_id;
                case 7:
                    return tt.cashier_id;
                case 8:
                    return tt.cashier_id;
                case 9:
                    return tt.cashier_id;
                default:
                    return tt.cashier_id;
            }
        }
    }

    private void ret_shifts() {
        String where = " order by u.screen_name";
        List<Cashier_shift_schedules.shift_cashiers> shifts = Cashier_shift_schedules.ret_shift_schedules(where);
        loadData_cashier_shift_schedules(shifts);
    }
//</editor-fold> 

    private void select_shift() {
        int row = tbl_cashier_shift_schedules.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_cashier_shift_schedules.getSelectedColumn();
        Cashier_shift_schedules.shift_cashiers tf = (Cashier_shift_schedules.shift_cashiers) tbl_cashier_shift_schedules_ALM.get(row);
        Field.Input cs = (Field.Input) tf_screen_name;
        if (col == 2) {
            if (tf.id == 0) {
                int id = 0;
                String created_at = DateType.now();
                String created_by = MyUser.getUser_id();
                String updated_at = DateType.now();
                String updated_by = MyUser.getUser_id();
                String cashier_id = tf.cashier_id;
                String cashier_name = tf.cashier_screen_name;
                int cashier_shift_id = FitIn.toInt(cs.getId());
                String cashier_shift = cs.getText();
                int status = 1;
                int is_uploaded = 0;
                Cashier_shift_schedules.to_cashier_shift_schedules new_ss = new Cashier_shift_schedules.to_cashier_shift_schedules(id, created_at, created_by, updated_at, updated_by, cashier_id, cashier_name, cashier_shift_id, cashier_shift, status, is_uploaded);
                Cashier_shift_schedules.add_data(new_ss);
                ret_shifts();
                Alert.set(1, "");
            } else {
                Cashier_shift_schedules.update_status(tf);
                ret_shifts();
                Alert.set(2, "");
            }
        }
    }
}
