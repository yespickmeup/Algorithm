/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.cash_drawer.CashDrawer;
import POS.util.Alert;
import POS.util.Dlg_confirm_action;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
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
import synsoftech.util.DateType;

/**
 *
 * @author Ronescape
 */
public class Dlg_report_ledger_lock_sessions extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_report_ledger_lock_sessions
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
    private Dlg_report_ledger_lock_sessions(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_report_ledger_lock_sessions(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_report_ledger_lock_sessions() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_report_ledger_lock_sessions myRef;

    private void setThisRef(Dlg_report_ledger_lock_sessions myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_ledger_lock_sessions> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_ledger_lock_sessions create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_ledger_lock_sessions create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_ledger_lock_sessions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_ledger_lock_sessions((java.awt.Frame) parent, false);
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
            Dlg_report_ledger_lock_sessions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_ledger_lock_sessions((java.awt.Dialog) parent, false);
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

        Dlg_report_ledger_lock_sessions dialog = Dlg_report_ledger_lock_sessions.create(new javax.swing.JFrame(), true);
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
        tbl_cash_drawer = new javax.swing.JTable();
        jButton1 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_cash_drawer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cash_drawer);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        disposed();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_cash_drawerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawerMouseClicked
        select_drawer();
    }//GEN-LAST:event_tbl_cash_drawerMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cash_drawer;
    // End of variables declaration//GEN-END:variables
    
    private void myInit() {
        init_key();
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");

        init_tbl_cash_drawer(tbl_cash_drawer);
        ret_sessions();
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

    //<editor-fold defaultstate="collapsed" desc=" cash_drawer "> 
    public static ArrayListModel tbl_cash_drawer_ALM;
    public static Tblcash_drawerModel tbl_cash_drawer_M;

    public static void init_tbl_cash_drawer(JTable tbl_cash_drawer) {
        tbl_cash_drawer_ALM = new ArrayListModel();
        tbl_cash_drawer_M = new Tblcash_drawerModel(tbl_cash_drawer_ALM);
        tbl_cash_drawer.setModel(tbl_cash_drawer_M);
        tbl_cash_drawer.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer.setRowHeight(25);
        int[] tbl_widths_cash_drawer = {100, 120, 120, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer, i, tbl_widths_cash_drawer[i]);
        }
        Dimension d = tbl_cash_drawer.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer.setRowHeight(25);
        tbl_cash_drawer.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_cash_drawer(List<CashDrawer.to_cash_drawer> acc) {
        tbl_cash_drawer_ALM.clear();
        tbl_cash_drawer_ALM.addAll(acc);
    }

    public static class Tblcash_drawerModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "User", "Timein", "Timeout", "", "time_in", "time_out", "amount", "cash_out", "thousand", "five_hundred", "two_hundred", "fifty", "twenty", "coins", "one_hundred", "expenses", "ten", "five", "one", "point_five", "point_two_five", "point_ten", "point_zero_five", "branch", "branch_id", "location", "location_id", "user_id", "user_screen_name", "is_uploaded", "lock_session"
        };

        public Tblcash_drawerModel(ListModel listmodel) {
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
            CashDrawer.to_cash_drawer tt = (CashDrawer.to_cash_drawer) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.user_screen_name;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.time_in);
                case 2:
                    if (tt.time_out == null) {
                        return " ";
                    } else {
                        return " " + DateType.convert_slash_datetime(tt.time_out);
                    }

                case 3:
                    if (tt.lock_session == 0) {
                        return " Lock";
                    } else {
                        return " Unlock";
                    }

                case 4:
                    return tt.time_in;
                case 5:
                    return tt.time_out;
                case 6:
                    return tt.amount;
                case 7:
                    return tt.cash_out;
                case 8:
                    return tt.thousand;
                case 9:
                    return tt.five_hundred;
                case 10:
                    return tt.two_hundred;
                case 11:
                    return tt.fifty;
                case 12:
                    return tt.twenty;
                case 13:
                    return tt.coins;
                case 14:
                    return tt.one_hundred;
                case 15:
                    return tt.expenses;
                case 16:
                    return tt.ten;
                case 17:
                    return tt.five;
                case 18:
                    return tt.one;
                case 19:
                    return tt.point_five;
                case 20:
                    return tt.point_two_five;
                case 21:
                    return tt.point_ten;
                case 22:
                    return tt.point_zero_five;
                case 23:
                    return tt.branch;
                case 24:
                    return tt.branch_id;
                case 25:
                    return tt.location;
                case 26:
                    return tt.location_id;
                case 27:
                    return tt.user_id;
                case 28:
                    return tt.user_screen_name;
                case 29:
                    return tt.lock_session;
                default:
                    return tt.lock_session;
            }
        }
    }

    private void ret_sessions() {
        String date = DateType.sf.format(new Date());
        String where = " where Date(time_in)='" + date + "' ";
        List<CashDrawer.to_cash_drawer> drawers = CashDrawer.ret_where(where);
        loadData_cash_drawer(drawers);
    }
//</editor-fold> 

    private void select_drawer() {
        int row = tbl_cash_drawer.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_cash_drawer.getSelectedColumn();
        if (col == 3) {
            final CashDrawer.to_cash_drawer to = (CashDrawer.to_cash_drawer) tbl_cash_drawer_ALM.get(row);

            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("Lock user session?");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    int lock_status = 0;
                    if (to.lock_session == 0) {
                        lock_status = 1;
                    }
                    CashDrawer.lock_session(to.id, lock_status);
                    Alert.set(2, "");
                    ret_sessions();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
}
