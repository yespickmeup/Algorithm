/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.encoding_inventory;

import POS.branch_locations.Branch_locations;
import POS.branch_locations.S1_branch_locations.to_branch_locations;
import POS.inventory_replenishment.Inventory_replenishments;
import POS.util.DateType;
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

import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_rpt_encoding_dates extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_encoding_replenishment
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

        public final Inventory_replenishments.to_inventory_replenishments rep;

        public OutputData(Inventory_replenishments.to_inventory_replenishments rep) {
            this.rep = rep;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_rpt_encoding_dates(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_rpt_encoding_dates(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_rpt_encoding_dates() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_rpt_encoding_dates myRef;

    private void setThisRef(Dlg_rpt_encoding_dates myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_rpt_encoding_dates> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_rpt_encoding_dates create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_rpt_encoding_dates create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_rpt_encoding_dates dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rpt_encoding_dates((java.awt.Frame) parent, false);
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
            Dlg_rpt_encoding_dates dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rpt_encoding_dates((java.awt.Dialog) parent, false);
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

        Dlg_rpt_encoding_dates dialog = Dlg_rpt_encoding_dates.create(new javax.swing.JFrame(), true);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_branch_locations = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Choose Location:");

        tbl_branch_locations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_branch_locations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_branch_locationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_branch_locations);

        jLabel3.setText("Total no. of rows:");

        jLabel4.setText("0");

        jLabel6.setText("Status:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 349, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(46, Short.MAX_VALUE))
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

    private void tbl_branch_locationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_branch_locationsMouseClicked
        select_location();
    }//GEN-LAST:event_tbl_branch_locationsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_branch_locations;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
        init_key();
        init_tbl_branch_locations(tbl_branch_locations);
        ret_locations();
        set_date();
    }

    private void set_date() {

    }

    public void do_pass() {

    }

    int ready = 1;

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        if (ready == 1) {
            this.dispose();
        }

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

    //<editor-fold defaultstate="collapsed" desc=" branch_locations "> 
    public static ArrayListModel tbl_branch_locations_ALM;
    public static Tblbranch_locationsModel tbl_branch_locations_M;

    public static void init_tbl_branch_locations(JTable tbl_branch_locations) {
        tbl_branch_locations_ALM = new ArrayListModel();
        tbl_branch_locations_M = new Tblbranch_locationsModel(tbl_branch_locations_ALM);
        tbl_branch_locations.setModel(tbl_branch_locations_M);
        tbl_branch_locations.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_branch_locations.setRowHeight(25);
        int[] tbl_widths_branch_locations = {100, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_branch_locations.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_branch_locations, i, tbl_widths_branch_locations[i]);
        }
        Dimension d = tbl_branch_locations.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_branch_locations.getTableHeader().setPreferredSize(d);
        tbl_branch_locations.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_branch_locations.setRowHeight(25);
        tbl_branch_locations.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_branch_locations.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_branch_locations(List<to_branch_locations> acc) {
        tbl_branch_locations_ALM.clear();
        tbl_branch_locations_ALM.addAll(acc);
    }

    public static class Tblbranch_locationsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Location", "Last Date Zero-out", "", "code", "location", "type", "status"
        };

        public Tblbranch_locationsModel(ListModel listmodel) {
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
            to_branch_locations tt = (to_branch_locations) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.branch + " : " + tt.location;
                case 1:
                    String date = "";

                    return " " + date;
                case 2:
                    if (tt.status == 0) {
                        return "/POS/icon_payment/remove11.png";
                    } else {
                        return "/POS/icon_inventory/checked.png";
                    }
                case 3:
                    return tt.code;
                case 4:
                    return tt.location;
                case 5:
                    return tt.type;
                default:
                    return tt.status;
            }
        }
    }

    private void ret_locations() {
        String date = DateType.sf.format(new Date());

        List<to_branch_locations> datas = Branch_locations.ret_all_locations();
        loadData_branch_locations(datas);
        jLabel4.setText("" + datas.size());
    }
//</editor-fold> 

    private void select_location() {
        int row = tbl_branch_locations.getSelectedRow();
        if (row < 0) {
            return;
        }

        final to_branch_locations to = (to_branch_locations) tbl_branch_locations_ALM.get(row);

        Window p = (Window) this;
        Dlg_rpt_encoding_dates_list nd = Dlg_rpt_encoding_dates_list.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.branch, to.branch_id, to.location, "" + to.id);
        nd.setCallback(new Dlg_rpt_encoding_dates_list.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_rpt_encoding_dates_list.OutputData data) {
                closeDialog.ok();
                ok1(data.rep);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void ok1(Inventory_replenishments.to_inventory_replenishments rep) {

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(rep));
        }
    }

}
