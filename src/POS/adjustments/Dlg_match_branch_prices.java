/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.adjustments;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.Branches;
import POS.inventory.Inventory_barcodes;
import POS.util.Alert;
import POS.util.Dlg_confirm_action;
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
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Ronescape
 */
public class Dlg_match_branch_prices extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_match_branch_prices
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
    private Dlg_match_branch_prices(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_match_branch_prices(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_match_branch_prices() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_match_branch_prices myRef;

    private void setThisRef(Dlg_match_branch_prices myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_match_branch_prices> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_match_branch_prices create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_match_branch_prices create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_match_branch_prices dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_match_branch_prices((java.awt.Frame) parent, false);
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
            Dlg_match_branch_prices dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_match_branch_prices((java.awt.Dialog) parent, false);
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

        Dlg_match_branch_prices dialog = Dlg_match_branch_prices.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tf_from_branch = new Field.Combo();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_from_branch1 = new Field.Combo();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prices = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new Button.Default();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tf_from_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branchMouseClicked(evt);
            }
        });
        tf_from_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cloud Branch:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Current Branch:");

        tf_from_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch1.setFocusable(false);
        tf_from_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch1MouseClicked(evt);
            }
        });
        tf_from_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch1ActionPerformed(evt);
            }
        });

        tbl_prices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_prices);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel5.setText("Status:");

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("Local");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Cloud");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_from_branch1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 216, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_from_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branch_locations4(tf_from_branch);
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branch_locations4(tf_from_branch);
    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_from_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_branch1MouseClicked

    private void tf_from_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_branch1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ret_items();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_prices;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        System.setProperty("pool_host", "192.168.1.51");
        System.setProperty("pool_db", "db_algorithm");
        System.setProperty("cloud_host", "128.199.80.53");
        System.setProperty("cloud_user", "smis2");
        System.setProperty("cloud_password", "nopassword101");

        set_default_branch();

        init_tbl_prices();
        branches = Branches.ret_where("");
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
    List<Branches.to_branches> branches = new ArrayList();

    private void init_branch_locations4(JTextField b) {
        final Field.Combo br = (Field.Combo) b;

        Object[][] obj = new Object[branches.size()][2];
        int i = 0;
        for (Branches.to_branches to : branches) {
            obj[i][0] = " " + to.branch;

            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {b.getWidth()};
        int width = 0;
        String[] col_names = {"Branch"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(b, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Branches.to_branches to = branches.get(data.selected_row);
                br.setText("" + to.branch);
                br.setId("" + to.id);

            }
        });
    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        tf_from_branch.setText(to.branch);

        Field.Combo c_br = (Field.Combo) tf_from_branch;
        Field.Combo d_br = (Field.Combo) tf_from_branch1;
        c_br.setId(to.branch_id);
        c_br.setText(to.branch);
        d_br.setId(to.branch_id);
        d_br.setText(to.branch);
    }

    public static class field {

        public final String item_code;
        public final String description;
        public final double cloud_price;
        public final String cloud_uom;
        public final double cloud_conversion;
        public final double local_price;
        public final String local_uom;
        public final double local_conversion;
        public final String branch;
        public final String branch_id;
        public final String local_branch;
        public final String local_branch_id;

        public field(String item_code, String description, double cloud_price, String cloud_uom, double cloud_conversion, double local_price, String local_uom, double local_conversion, String branch,
                String branch_id, String local_branch, String local_branch_id) {
            this.item_code = item_code;
            this.description = description;
            this.cloud_price = cloud_price;
            this.cloud_uom = cloud_uom;
            this.cloud_conversion = cloud_conversion;
            this.local_price = local_price;
            this.local_uom = local_uom;
            this.local_conversion = local_conversion;
            this.branch = branch;
            this.branch_id = branch_id;
            this.local_branch = local_branch;
            this.local_branch_id = local_branch_id;
        }

    }

    private ArrayListModel tbl_prices_ALM;
    private TblbranchesModel tbl_prices_M;

    private void init_tbl_prices() {
        tbl_prices_ALM = new ArrayListModel();
        tbl_prices_M = new TblbranchesModel(tbl_prices_ALM);
        tbl_prices.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_prices.setModel(tbl_prices_M);
        tbl_prices.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_prices.setRowHeight(25);
        int[] tbl_widths_branches = {80, 100, 100, 100, 0};
        for (int i = 0, n = tbl_widths_branches.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_prices, i, tbl_widths_branches[i]);
        }
        Dimension d = tbl_prices.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_prices.getTableHeader().
                setPreferredSize(d);
        tbl_prices.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_prices.setRowHeight(25);
        tbl_prices.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_prices, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_prices, 3);
    }

    private void loadData_branches(List<field> acc) {
        tbl_prices_ALM.clear();
        tbl_prices_ALM.addAll(acc);
    }

    public static class TblbranchesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Item Code", "Description", "Cloud Price", "Local Price", "Branch"
        };

        public TblbranchesModel(ListModel listmodel) {
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
            field tt = (field) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.item_code;
                case 1:
                    return " " + tt.description;
                case 2:
                    return FitIn.fmt_wc_0(tt.cloud_price) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.local_price) + " ";
                default:
                    return " " + tt.branch;
            }
        }
    }

    private void ret_items() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Field.Combo c_br = (Field.Combo) tf_from_branch;
                Field.Combo l_br = (Field.Combo) tf_from_branch1;
                String where = " where branch_code='" + c_br.getId() + "' group by main_barcode order by description asc ";
                List<Inventory_barcodes.to_inventory_barcodes> cloud = Inventory_barcodes.ret_where_cloud(where);
                System.out.println("Cloud: " + cloud.size());
                List<Inventory_barcodes.to_inventory_barcodes> local = Inventory_barcodes.ret_where(where);
                System.out.println("Local: " + local.size());

                List<field> diff = new ArrayList();
                for (Inventory_barcodes.to_inventory_barcodes c : cloud) {
                    for (Inventory_barcodes.to_inventory_barcodes l : local) {
                        if (c.main_barcode.equalsIgnoreCase(l.main_barcode)) {
                            if (c.selling_price != l.selling_price) {
                                String item_code = c.main_barcode;
                                String description = c.description;
                                double cloud_price = c.selling_price;
                                String cloud_uom = c.unit;
                                double cloud_conversion = c.conversion;
                                double local_price = l.selling_price;
                                String local_uom = l.unit;
                                double local_conversion = l.conversion;
                                String branch = c.branch;
                                String branch_id = c.branch_code;
                                String local_branch = l_br.getText();
                                String local_branch_id = l_br.getId();
                                field f = new field(item_code, description, cloud_price, cloud_uom, cloud_conversion, local_price, local_uom, local_conversion, branch, branch_id, local_branch, local_branch_id);
                                diff.add(f);
                            }
                            break;
                        }
                    }
                }
                loadData_branches(diff);
                jLabel2.setText("" + diff.size());
                System.out.println("Diff: " + diff.size());
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void update() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                List<field> diff = tbl_prices_ALM;
                if (jCheckBox2.isSelected()) {
                    Adjust_inventory_price.update_item_cloud(diff);
                    Alert.set(2, "");
                    ret_items();
                } else {
                    Adjust_inventory_price.update_item_local(diff);
                    Alert.set(2, "");
                    ret_items();
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
