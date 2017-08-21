/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bank_recon;

import POS.bank_accounts.Bank_accounts;
import POS.bank_accounts.Dlg_bank_accounts;
import POS.bank_recon.Bank_account_deposits.to_bank_account_deposits;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
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
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;


/**
 *
 * @author Guinness
 */
public class Dlg_bank_recon extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_bank_recon
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
    private Dlg_bank_recon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_bank_recon(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_bank_recon() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_bank_recon myRef;

    private void setThisRef(Dlg_bank_recon myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_bank_recon> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_bank_recon create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_bank_recon create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_bank_recon dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_bank_recon((java.awt.Frame) parent, false);
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
            Dlg_bank_recon dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_bank_recon((java.awt.Dialog) parent, false);
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

        Dlg_bank_recon dialog = Dlg_bank_recon.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bank_accounts = new javax.swing.JTable();
        jButton2 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bank_account_deposits = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new Button.Default();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_bank_accounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_bank_accounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bank_accountsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bank_accounts);

        jButton2.setText("Manage Bank Accounts");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bank Reconciliation", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_bank_account_deposits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_bank_account_deposits);

        jLabel1.setText("Total no. of rows:");

        jLabel2.setText("0");

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Deposits", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Issuances", jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        manage_bank_account();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_bank_accountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bank_accountsMouseClicked
        select_bank_account();
    }//GEN-LAST:event_tbl_bank_accountsMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ret_bank_deposits();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tbl_bank_account_deposits;
    private javax.swing.JTable tbl_bank_accounts;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");
        init_key();
        set_default_location();
        init_tbl_bank_accounts(tbl_bank_accounts);
        init_tbl_bank_account_deposits(tbl_bank_account_deposits);
        ret_bank_accounts();
    }

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void set_default_location() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();

        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;
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

    //<editor-fold defaultstate="collapsed" desc=" bank_accounts "> 
    public static ArrayListModel tbl_bank_accounts_ALM;
    public static Tblbank_accountsModel tbl_bank_accounts_M;

    public static void init_tbl_bank_accounts(JTable tbl_bank_accounts) {
        tbl_bank_accounts_ALM = new ArrayListModel();
        tbl_bank_accounts_M = new Tblbank_accountsModel(tbl_bank_accounts_ALM);
        tbl_bank_accounts.setModel(tbl_bank_accounts_M);
        tbl_bank_accounts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_bank_accounts.setRowHeight(30);
        int[] tbl_widths_bank_accounts = {120, 150, 90, 90, 80, 60, 60, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_bank_accounts.length; i < n; i++) {
            if (i == 1 || i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_bank_accounts, i, tbl_widths_bank_accounts[i]);
        }
        Dimension d = tbl_bank_accounts.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_bank_accounts.getTableHeader().setPreferredSize(d);
        tbl_bank_accounts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_bank_accounts.setRowHeight(25);
        tbl_bank_accounts.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_bank_accounts, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_bank_accounts, 4);
    }

    public static void loadData_bank_accounts(List<Bank_accounts.to_bank_accounts> acc) {
        tbl_bank_accounts_ALM.clear();
        tbl_bank_accounts_ALM.addAll(acc);
    }

    public static class Tblbank_accountsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Account No", "Bank", "Holder", "Withdrawable", "Outstading", "", "", "status", "branch", "branch_id", "location", "location_id"
        };

        public Tblbank_accountsModel(ListModel listmodel) {
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
            Bank_accounts.to_bank_accounts tt = (Bank_accounts.to_bank_accounts) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.bank_account_no;
                case 1:
                    return " " + tt.bank_name;
                case 2:
                    return " " + tt.bank_holder;
                case 3:
                    return FitIn.fmt_wc_0(tt.withdrawable_balance) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.outstanding_balance) + " ";
                case 5:
                    return " Issuance";
                case 6:
                    return " Deposit";
                case 7:
                    return tt.status;
                case 8:
                    return tt.branch;
                case 9:
                    return tt.branch_id;
                case 10:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_bank_accounts() {
        String where = " order by bank_account_no asc ";
        List<Bank_accounts.to_bank_accounts> datas = Bank_accounts.ret_data(where);
        loadData_bank_accounts(datas);

    }
//</editor-fold>

    private void manage_bank_account() {
        Window p = (Window) this;
        Dlg_bank_accounts nd = Dlg_bank_accounts.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_bank_accounts.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_bank_accounts.OutputData data) {
                ret_bank_accounts();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void select_bank_account() {
        int row = tbl_bank_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Bank_accounts.to_bank_accounts account = (Bank_accounts.to_bank_accounts) tbl_bank_accounts_ALM.get(row);
        int col = tbl_bank_accounts.getSelectedColumn();
        if (col == 5) {

        }
        if (col == 6) {
            Window p = (Window) this;
            Dlg_bank_recon_deposit nd = Dlg_bank_recon_deposit.create(p, true);
            nd.setTitle("");
            nd.do_pass(account);
            nd.setCallback(new Dlg_bank_recon_deposit.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_bank_recon_deposit.OutputData data) {
                    closeDialog.ok();
                    int id = 0;
                    String reference_no = data.reference_no;
                    String bank_account_no = account.bank_account_no;
                    String bank_holder = account.bank_holder;
                    String bank_name = account.bank_name;
                    String remarks = data.remarks;
                    double cash = data.cash;
                    double check_amount = data.check_amount;
                    String check_holder = data.check_holder;
                    String check_no = data.check_no;
                    String check_date = data.check_date;
                    int check_is_cleared = data.is_check_cleared;
                    String created_at = DateType.now();
                    String updated_at = DateType.now();
                    String created_by = MyUser.getUser_name();
                    String updated_by = MyUser.getUser_name();
                    int status = 0;
                    String branch = my_branch;
                    String branch_id = my_branch_id;
                    String location = my_location;
                    String location_id = my_location_id;
                    Bank_account_deposits.to_bank_account_deposits deposit = new Bank_account_deposits.to_bank_account_deposits(id, reference_no, bank_account_no, bank_holder, bank_name, remarks, cash, check_amount, check_holder, check_no, check_date, check_is_cleared, created_at, updated_at, created_by, updated_by, status, branch, branch_id, location, location_id);
                    Bank_account_deposits.add_data(deposit);
                    Alert.set(0, "Deposit successfully posted!");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" bank_account_deposits "> 
    public static ArrayListModel tbl_bank_account_deposits_ALM;
    public static Tblbank_account_depositsModel tbl_bank_account_deposits_M;

    public static void init_tbl_bank_account_deposits(JTable tbl_bank_account_deposits) {
        tbl_bank_account_deposits_ALM = new ArrayListModel();
        tbl_bank_account_deposits_M = new Tblbank_account_depositsModel(tbl_bank_account_deposits_ALM);
        tbl_bank_account_deposits.setModel(tbl_bank_account_deposits_M);
        tbl_bank_account_deposits.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_bank_account_deposits.setRowHeight(25);
        int[] tbl_widths_bank_account_deposits = {100, 100, 100, 80, 90, 80, 70, 70, 40, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_bank_account_deposits.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_bank_account_deposits, i, tbl_widths_bank_account_deposits[i]);
        }
        Dimension d = tbl_bank_account_deposits.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_bank_account_deposits.getTableHeader().setPreferredSize(d);
        tbl_bank_account_deposits.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_bank_account_deposits.setRowHeight(25);
        tbl_bank_account_deposits.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_bank_account_deposits, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_bank_account_deposits, 4);
    }

    public static void loadData_bank_account_deposits(List<to_bank_account_deposits> acc) {
        tbl_bank_account_deposits_ALM.clear();
        tbl_bank_account_deposits_ALM.addAll(acc);
    }

    public static class Tblbank_account_depositsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference No", "Account No", "Holder", "Cash", "Check Amount", "Check Date", "Cleared?", "Status", "", "", "created_at", "updated_at", "created_by", "updated_by", "status", "branch", "branch_id", "location", "location_id"
        };

        public Tblbank_account_depositsModel(ListModel listmodel) {
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
            to_bank_account_deposits tt = (to_bank_account_deposits) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.reference_no;
                case 1:
                    return " " + tt.bank_account_no;
                case 2:
                    return " " + tt.check_holder;
                case 3:
                    return FitIn.fmt_wc_0(tt.cash) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.check_amount) + " ";
                case 5:
                    return " " + DateType.convert_slash_datetime2(tt.check_date);
                case 6:
                    if (tt.check_is_cleared == 0) {
                        return " No";
                    } else {
                        return " Yes";
                    }
                case 7:
                    switch (tt.status) {
                        case 0:
                            return " Posted";
                        case 1:
                            return " Finalized";
                        default:
                            return " Deleted";
                    }
                case 8:

                    return " Edit";
                case 9:
                    return " Delete";
                case 10:
                    return tt.created_at;
                case 11:
                    return tt.updated_at;
                case 12:
                    return tt.created_by;
                case 13:
                    return tt.updated_by;
                case 14:
                    return tt.status;
                case 15:
                    return tt.branch;
                case 16:
                    return tt.branch_id;
                case 17:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_bank_deposits() {
        String where = "";
        List<to_bank_account_deposits> datas = Bank_account_deposits.ret_data(where);
        loadData_bank_account_deposits(datas);
        jLabel2.setText("" + datas.size());
    }
//</editor-fold> 

}
