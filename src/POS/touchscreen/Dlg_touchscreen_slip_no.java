/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.receipts.Warranties;
import POS.receipts.Warranty_items;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
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
 * @author User
 */
public class Dlg_touchscreen_slip_no extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_slip_no
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

        public final List<Warranties.to_warranties> to;

        public OutputData(List<Warranties.to_warranties> to) {
            this.to = to;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_slip_no(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_slip_no(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_slip_no() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_slip_no myRef;

    private void setThisRef(Dlg_touchscreen_slip_no myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_slip_no> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_slip_no create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_slip_no create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_slip_no dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_slip_no((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_slip_no dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_slip_no((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_slip_no dialog = Dlg_touchscreen_slip_no.create(new javax.swing.JFrame(), true);
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
        tbl_warranties = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_warranties2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_warranty_items = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new Button.Success();
        jButton6 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Records", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_warranties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_warranties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_warrantiesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_warranties);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Added Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_warranties2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_warranties2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_warranties2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_warranties2);

        jLabel3.setText("No. of rows:");

        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_warranty_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_warranty_items);

        jLabel5.setText("No. of rows:");

        jLabel6.setText("0");

        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        ret_warranties();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_warrantiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_warrantiesMouseClicked
        select_slip_no();
    }//GEN-LAST:event_tbl_warrantiesMouseClicked

    private void tbl_warranties2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_warranties2MouseClicked
        select_slip_no2();
    }//GEN-LAST:event_tbl_warranties2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        confirm_action();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_warranties;
    private javax.swing.JTable tbl_warranties2;
    private javax.swing.JTable tbl_warranty_items;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_password", "password");
        init_key();

        init_tbl_warranties(tbl_warranties);
        init_tbl_warranties2(tbl_warranties2);
        init_tbl_warranty_items(tbl_warranty_items);
    }

    public void do_pass(List<Warranties.to_warranties> slip_nos) {

        loadData_warranties2(slip_nos);
        jLabel4.setText("" + slip_nos.size());
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

    //<editor-fold defaultstate="collapsed" desc=" warranties "> 
    public static ArrayListModel tbl_warranties_ALM;
    public static TblwarrantiesModel tbl_warranties_M;

    public static void init_tbl_warranties(JTable tbl_warranties) {
        tbl_warranties_ALM = new ArrayListModel();
        tbl_warranties_M = new TblwarrantiesModel(tbl_warranties_ALM);
        tbl_warranties.setModel(tbl_warranties_M);
        tbl_warranties.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranties.setRowHeight(25);
        int[] tbl_widths_warranties = {100, 80, 50, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranties.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_warranties, i, tbl_widths_warranties[i]);
        }
        Dimension d = tbl_warranties.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_warranties.getTableHeader().setPreferredSize(d);
        tbl_warranties.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_warranties.setRowHeight(25);
        tbl_warranties.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_warranties(List<Warranties.to_warranties> acc) {
        tbl_warranties_ALM.clear();
        tbl_warranties_ALM.addAll(acc);
    }

    public static class TblwarrantiesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Slip No", "Created", "Item/s", "", "Status", "", "", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
        };

        public TblwarrantiesModel(ListModel listmodel) {
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
            Warranties.to_warranties tt = (Warranties.to_warranties) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.slip_no;
                case 1:
                    return " " + DateType.convert_slash_datetime2(tt.created_at);
                case 2:
                    return "      " + tt.created_by;
                case 3:
                    return "  Add";
                case 4:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 5:
                    return " Edit";
                case 6:
                    return " Delete";
                case 7:
                    return tt.created_at;
                case 8:
                    return tt.created_by;
                case 9:
                    return tt.branch;
                case 10:
                    return tt.branch_id;
                case 11:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_warranties() {
        String search = jTextField1.getText();
        List<Warranties.to_warranties> datas = Warranties.ret_data_with_items(" where slip_no like '%" + search + "%' and status=0 ");
        loadData_warranties(datas);
        jLabel2.setText("" + datas.size());
    }

    private void select_slip_no() {
        int row = tbl_warranties.getSelectedRow();
        if (row < 0) {
            return;
        }
        Warranties.to_warranties to = (Warranties.to_warranties) tbl_warranties_ALM.get(row);

        int col = tbl_warranties.getSelectedColumn();
        if (col == 3) {
            List<Warranties.to_warranties> added = tbl_warranties_ALM2;
            int exist = 0;
            for (Warranties.to_warranties warranty : added) {
                if (warranty.transaction_no.equalsIgnoreCase(to.transaction_no)) {
                    exist = 1;
                    return;
                }
            }
            if (exist == 0) {
                tbl_warranties_ALM2.add(to);
            } else {
                Alert.set(0, "Already added!");
            }
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" warranties "> 
    public static ArrayListModel tbl_warranties_ALM2;
    public static TblwarrantiesModel2 tbl_warranties_M2;

    public static void init_tbl_warranties2(JTable tbl_warranties2) {
        tbl_warranties_ALM2 = new ArrayListModel();
        tbl_warranties_M2 = new TblwarrantiesModel2(tbl_warranties_ALM2);
        tbl_warranties2.setModel(tbl_warranties_M2);
        tbl_warranties2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranties2.setRowHeight(25);
        int[] tbl_widths_warranties = {100, 80, 50, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranties.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_warranties2, i, tbl_widths_warranties[i]);
        }
        Dimension d = tbl_warranties2.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_warranties2.getTableHeader().setPreferredSize(d);
        tbl_warranties2.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_warranties2.setRowHeight(25);
        tbl_warranties2.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_warranties2(List<Warranties.to_warranties> acc) {
        tbl_warranties_ALM2.clear();
        tbl_warranties_ALM2.addAll(acc);
    }

    public static class TblwarrantiesModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Slip No", "Created", "Item/s", "", "Status", "", "", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
        };

        public TblwarrantiesModel2(ListModel listmodel) {
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
            Warranties.to_warranties tt = (Warranties.to_warranties) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.slip_no;
                case 1:
                    return " " + DateType.convert_slash_datetime2(tt.created_at);
                case 2:
                    return "      " + tt.created_by;
                case 3:
                    return "  Remove";
                case 4:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 5:
                    return " Edit";
                case 6:
                    return " Delete";
                case 7:
                    return tt.created_at;
                case 8:
                    return tt.created_by;
                case 9:
                    return tt.branch;
                case 10:
                    return tt.branch_id;
                case 11:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void select_slip_no2() {
        int row = tbl_warranties2.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_warranties2.getSelectedColumn();
        if (col == 3) {
            tbl_warranties_ALM2.remove(row);
            tbl_warranty_items_ALM.clear();
            jLabel6.setText("0");
        } else {
            ret_items();
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" items ">
    public static ArrayListModel tbl_warranty_items_ALM;
    public static Tblwarranty_itemsModel tbl_warranty_items_M;

    public static void init_tbl_warranty_items(JTable tbl_warranty_items) {
        tbl_warranty_items_ALM = new ArrayListModel();
        tbl_warranty_items_M = new Tblwarranty_itemsModel(tbl_warranty_items_ALM);
        tbl_warranty_items.setModel(tbl_warranty_items_M);
        tbl_warranty_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranty_items.setRowHeight(25);
        int[] tbl_widths_warranty_items = {0, 40, 120, 100, 80, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranty_items.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_warranty_items, i, tbl_widths_warranty_items[i]);
        }
        Dimension d = tbl_warranty_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_warranty_items.getTableHeader().setPreferredSize(d);
        tbl_warranty_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_warranty_items.setRowHeight(25);
        tbl_warranty_items.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_warranty_items(List<Warranty_items.to_warranty_items> acc) {
        tbl_warranty_items_ALM.clear();
        tbl_warranty_items_ALM.addAll(acc);
    }

    public static class Tblwarranty_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Qty", "Item Code", "Description", "Warranty", "Type", "Status", "", "", "cost", "selling_price", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "warranty_date", "serial_no", "main_barcode", "brand", "brand_id", "model", "model_id", "status", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
        };

        public Tblwarranty_itemsModel(ListModel listmodel) {
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
            Warranty_items.to_warranty_items tt = (Warranty_items.to_warranty_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.qty;
                case 2:
                    return " " + tt.main_barcode;
                case 3:
                    return " " + tt.description;
                case 4:
                    return " " + POS.util.DateType.convert_slash_datetime2(tt.warranty_date);
                case 5:
                    return "    " + tt.trans_type;
                case 6:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 7:
                    return " Edit";
                case 8:
                    return " Delete";
                case 9:
                    return tt.cost;
                case 10:
                    return tt.selling_price;
                case 11:
                    return tt.category;
                case 12:
                    return tt.category_id;
                case 13:
                    return tt.classification;
                case 14:
                    return tt.classification_id;
                case 15:
                    return tt.sub_class;
                case 16:
                    return tt.sub_class_id;
                case 17:
                    return tt.conversion;
                case 18:
                    return tt.unit;
                case 19:
                    return tt.warranty_date;
                case 20:
                    return tt.serial_no;
                case 21:
                    return tt.main_barcode;
                case 22:
                    return tt.brand;
                case 23:
                    return tt.brand_id;
                case 24:
                    return tt.model;
                case 25:
                    return tt.model_id;
                case 26:
                    return tt.status;
                case 27:
                    return tt.created_at;
                case 28:
                    return tt.created_by;
                case 29:
                    return tt.branch;
                case 30:
                    return tt.branch_id;
                case 31:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_items() {
        int row = tbl_warranties2.getSelectedRow();
        if (row < 0) {
            return;
        }
        Warranties.to_warranties to = (Warranties.to_warranties) tbl_warranties_ALM2.get(row);
        String where = " where transaction_no='" + to.transaction_no + "' ";

        List<Warranty_items.to_warranty_items> items = Warranty_items.ret_data(where);
        loadData_warranty_items(items);
        jLabel2.setText("" + items.size());
    }

    //</editor-fold>
    private void confirm_action() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                ok2();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ok2() {

        List<Warranties.to_warranties> datas = tbl_warranties_ALM2;
        if (datas.isEmpty()) {
            Alert.set(0, "No transaction added!");
            return;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(datas));
        }
    }
}
