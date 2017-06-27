/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_locations;

import POS.branch_locations.S1_branch_locations.to_branch_locations;
import POS.branches.Branches;
import POS.util.Alert;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;

/**
 *
 * @author Maytopacka
 */
public class Dlg_branch_locations extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_location
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
    private Dlg_branch_locations(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_branch_locations(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_branch_locations() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_branch_locations myRef;

    private void setThisRef(Dlg_branch_locations myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_branch_locations> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_branch_locations create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_branch_locations create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_branch_locations dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_locations((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_branch_locations dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_branch_locations((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_branch_locations dialog = Dlg_branch_locations.
                create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_branch_locations = new org.jdesktop.swingx.JXTable();
        btn_new = new Button.Default();
        btn_add = new Button.Primary();
        btn_edit = new Button.Info();
        btn_delete = new Button.Warning();
        tf_search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_branch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_location = new javax.swing.JTextField();
        tf_branch_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setOpaque(false);

        jScrollPane2.setOpaque(false);

        tbl_branch_locations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_branch_locations.setOpaque(false);
        tbl_branch_locations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_branch_locationsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_branch_locations);

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setText("Update");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Search:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Branch:");

        tf_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Location:");

        tf_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tf_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("No. of rows:");

        jLabel6.setText("0");

        jLabel7.setText("Status:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_branch)
                                .addGap(0, 0, 0)
                                .addComponent(tf_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_location)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_branch)
                        .addComponent(tf_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_location)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_branch_locationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_branch_locationsMouseClicked
        // TODO add your handling code here:
        select_branch_locations();
    }//GEN-LAST:event_tbl_branch_locationsMouseClicked

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branchActionPerformed
        init_branches();
    }//GEN-LAST:event_tf_branchActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clear_branch_locations();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        add_branch_locations();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        edit_branch_locations();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete_branch_locations();
    }//GEN-LAST:event_btn_deleteActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tbl_branch_locations;
    private javax.swing.JTextField tf_branch;
    private javax.swing.JTextField tf_branch_id;
    private javax.swing.JTextField tf_location;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        tf_branch.grabFocus();
        init_key();
        hover();
        search();
        init();
        tf_branch_id.enable(false);
        tf_branch_id.setVisible(false);
        focus();
        String where = "";
        branches_list.clear();
        branches_list = Branches.ret_where(where);

        init_tbl_branch_locations();

    }

    private void focus() {
        JTextField[] tf = {tf_branch, tf_branch_id, tf_search, tf_location};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    // <editor-fold defaultstate="collapsed" desc="settings">
    private void hover() {

    }
    int posX = 0, posY = 0;

    private void init() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
            }
        });
    }

    private void search() {

    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 20));
    }

    private void exit2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(153, 153, 153));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    // </editor-fold>

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

    private ArrayListModel tbl_branch_locations_ALM;
    private Tblbranch_locationsModel tbl_branch_locations_M;

    private void init_tbl_branch_locations() {
        tbl_branch_locations_ALM = new ArrayListModel();
        tbl_branch_locations_M = new Tblbranch_locationsModel(tbl_branch_locations_ALM);
        tbl_branch_locations.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_branch_locations.setModel(tbl_branch_locations_M);
        tbl_branch_locations.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_branch_locations.setRowHeight(25);
        int[] tbl_widths_branch_locations = {200, 200, 70, 0, 0, 0};
        for (int i = 0, n = tbl_widths_branch_locations.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_branch_locations, i, tbl_widths_branch_locations[i]);
        }
        Dimension d = tbl_branch_locations.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_branch_locations.getTableHeader().
                setPreferredSize(d);
        tbl_branch_locations.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_branch_locations.setRowHeight(25);
        tbl_branch_locations.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_branch_locations(List<to_branch_locations> acc) {
        tbl_branch_locations_ALM.clear();
        tbl_branch_locations_ALM.addAll(acc);
    }

    public static class Tblbranch_locationsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Location", "Branch", "", "code", "location", "type"
        };

        public Tblbranch_locationsModel(ListModel listmodel) {
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
            to_branch_locations tt = (to_branch_locations) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.location;
                case 1:
                    return " " + tt.branch;
                case 2:
                    if (tt.status == 1) {
                        return "     Default";
                    } else {
                        return " ";
                    }
                case 3:
                    return tt.code;
                case 4:
                    return tt.location;
                default:
                    return tt.type;
            }
        }

    }

    private void data_cols() {
        String search = tf_branch_id.getText();
        String location = tf_search.getText();
        loadData_branch_locations(S1_branch_locations.ret_data_by_branch_id(search, location));
        jLabel6.setText("" + tbl_branch_locations_ALM.size());
    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches() {

        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (Branches.to_branches to : branches_list) {
            obj[i][0] = " " + to.id;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.branch;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, 200};
        int width = 0;
        String[] col_names = {"Code", "Branch"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Branches.to_branches to = branches_list.
                        get(data.selected_row);
                tf_branch.setText(to.branch);
                tf_branch_id.setText("" + to.id);
                tf_location.grabFocus();
                data_cols();
            }
        });
    }

    private void add_branch_locations() {
        if (tf_branch.getText().isEmpty()) {
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();

                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                btn_new.setEnabled(false);
                btn_add.setEnabled(false);
                btn_edit.setEnabled(false);
                btn_delete.setEnabled(false);

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        int id = -1;
                        String branch = tf_branch.getText();
                        String branch_id = tf_branch_id.getText();
                        String code = "";
                        String location = tf_location.getText();
                        String type = "USER";
                        int status = 0;
                        to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                        S1_branch_locations.add_branch_locations(to);
                        data_cols();
                        clear_branch_locations();
                        Alert.set(1, "");
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                        btn_new.setEnabled(true);
                        btn_add.setEnabled(true);
                        btn_edit.setEnabled(true);
                        btn_delete.setEnabled(true);
                    }
                });
                t.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void select_branch_locations() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                int row = tbl_branch_locations.getSelectedRow();
                if (row < 0) {
                    return;
                }
                to_branch_locations to = (to_branch_locations) tbl_branch_locations_ALM.
                        get(tbl_branch_locations.convertRowIndexToModel(row));
                int col = tbl_branch_locations.getSelectedColumn();
                if (col == 2) {
                    S1_branch_locations.change_default_location(to);
                    data_cols();
                } else {

                    tf_branch.setText(to.branch);
                    tf_branch_id.setText(to.branch_id);
                    tf_location.setText(to.location);
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void edit_branch_locations() {
        if (tf_branch.getText().isEmpty()) {
            return;
        }
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        btn_new.setEnabled(false);
        btn_add.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to update this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int row = tbl_branch_locations.getSelectedRow();
                        if (row < 0) {
                            return;
                        }
                        to_branch_locations to = (to_branch_locations) tbl_branch_locations_ALM.
                                get(tbl_branch_locations.convertRowIndexToModel(row));
                        int id = to.id;
                        String branch = tf_branch.getText();
                        String branch_id = tf_branch_id.getText();
                        String code = "";
                        String location = tf_location.getText();
                        String type = "USER";
                        int status = 0;
                        to_branch_locations to1 = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                        S1_branch_locations.edit_branch_locations(to1);
                        data_cols();
                        clear_branch_locations();
                        Alert.set(2, "");
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                        btn_new.setEnabled(true);
                        btn_add.setEnabled(true);
                        btn_edit.setEnabled(true);
                        btn_delete.setEnabled(true);
                    }
                });
                t.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void clear_branch_locations() {
        tf_location.setText("");
    }

    private void delete_branch_locations() {
        int row = tbl_branch_locations.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_branch_locations to = (to_branch_locations) tbl_branch_locations_ALM.get(tbl_branch_locations.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot Delete Default Location");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to delete this transaction?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                btn_new.setEnabled(false);
                btn_add.setEnabled(false);
                btn_edit.setEnabled(false);
                btn_delete.setEnabled(false);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        S1_branch_locations.delete_branch_locations(to);
                        data_cols();
                        clear_branch_locations();
                        Alert.set(3, "");
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                        btn_new.setEnabled(true);
                        btn_add.setEnabled(true);
                        btn_edit.setEnabled(true);
                        btn_delete.setEnabled(true);
                    }
                });
                t.start();
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);
    }

}
