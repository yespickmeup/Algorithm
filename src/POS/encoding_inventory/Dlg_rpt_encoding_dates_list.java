/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.encoding_inventory;

import POS.inventory_replenishment.Inventory_replenishments;
import POS.inventory_replenishment.Inventory_replenishments.to_inventory_replenishments;
import POS.util.DateType;
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
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_rpt_encoding_dates_list extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_rpt_encoding_dates_list
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
        public final to_inventory_replenishments rep;

        public OutputData(to_inventory_replenishments rep) {
            this.rep = rep;
        }
        
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_rpt_encoding_dates_list(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_rpt_encoding_dates_list(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_rpt_encoding_dates_list() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_rpt_encoding_dates_list myRef;

    private void setThisRef(Dlg_rpt_encoding_dates_list myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_rpt_encoding_dates_list> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_rpt_encoding_dates_list create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_rpt_encoding_dates_list create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_rpt_encoding_dates_list dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rpt_encoding_dates_list((java.awt.Frame) parent, false);
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
            Dlg_rpt_encoding_dates_list dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rpt_encoding_dates_list((java.awt.Dialog) parent, false);
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

        Dlg_rpt_encoding_dates_list dialog = Dlg_rpt_encoding_dates_list.create(new javax.swing.JFrame(), true);
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
        tbl_inventory_replenishments = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new Field.Input();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_inventory_replenishments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_inventory_replenishments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventory_replenishmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_inventory_replenishments);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Branch:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Location:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setFocusable(false);

        jLabel1.setText("No. of rows:");

        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(1, 1, 1)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14))
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

    private void tbl_inventory_replenishmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory_replenishmentsMouseClicked
        ok();
    }//GEN-LAST:event_tbl_inventory_replenishmentsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbl_inventory_replenishments;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_inventory_replenishments(tbl_inventory_replenishments);
    }

    public void do_pass(String branch, String branch_id, String location, String location_id) {
        Field.Input br = (Field.Input) jTextField1;
        Field.Input lo = (Field.Input) jTextField2;
        br.setText(branch);
        br.setId(branch_id);

        lo.setText(location);
        lo.setId(location_id);

        ret_data();
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

    //<editor-fold defaultstate="collapsed" desc=" inventory_replenishments "> 
    public static ArrayListModel tbl_inventory_replenishments_ALM;
    public static Tblinventory_replenishmentsModel tbl_inventory_replenishments_M;

    public static void init_tbl_inventory_replenishments(JTable tbl_inventory_replenishments) {
        tbl_inventory_replenishments_ALM = new ArrayListModel();
        tbl_inventory_replenishments_M = new Tblinventory_replenishmentsModel(tbl_inventory_replenishments_ALM);
        tbl_inventory_replenishments.setModel(tbl_inventory_replenishments_M);
        tbl_inventory_replenishments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_replenishments.setRowHeight(25);
        int[] tbl_widths_inventory_replenishments = {100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_replenishments.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inventory_replenishments, i, tbl_widths_inventory_replenishments[i]);
        }
        Dimension d = tbl_inventory_replenishments.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_inventory_replenishments.getTableHeader().setPreferredSize(d);
        tbl_inventory_replenishments.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_inventory_replenishments.setRowHeight(25);
        tbl_inventory_replenishments.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_inventory_replenishments(List<to_inventory_replenishments> acc) {
        tbl_inventory_replenishments_ALM.clear();
        tbl_inventory_replenishments_ALM.addAll(acc);
    }

    public static class Tblinventory_replenishmentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "inventory_replenishment_no", "date_added", "user_id", "user_screen_name", "remarks", "status", "branch", "branch_id", "location", "location_id"
        };

        public Tblinventory_replenishmentsModel(ListModel listmodel) {
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
            to_inventory_replenishments tt = (to_inventory_replenishments) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_jan_1_2013_datetime2(tt.date_added);
                case 1:
                    return tt.inventory_replenishment_no;
                case 2:
                    return tt.date_added;
                case 3:
                    return tt.user_id;
                case 4:
                    return tt.user_screen_name;
                case 5:
                    return tt.remarks;
                case 6:
                    return tt.status;
                case 7:
                    return tt.branch;
                case 8:
                    return tt.branch_id;
                case 9:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_data() {
        Field.Input lo = (Field.Input) jTextField2;
        String where = " where location_id = '" + lo.getId() + "'";

        List<to_inventory_replenishments> datas = Inventory_replenishments.ret_data(where);
        loadData_inventory_replenishments(datas);
        jLabel4.setText("" + datas.size());
    }
//</editor-fold> 

    private void ok() {
        int row=tbl_inventory_replenishments.getSelectedRow();
        if(row<0){
            return;
        }
        to_inventory_replenishments rep=(to_inventory_replenishments)tbl_inventory_replenishments_ALM.get(row);
        
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(rep));
        }
    }
}
