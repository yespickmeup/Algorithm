/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

import POS.my_services.S1_my_services_problems;
import POS.my_services.S1_my_services_problems.to_my_services_problems;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Ronald
 */
public class Dlg_prob extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_prob
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
    private Dlg_prob(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_prob(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_prob() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_prob myRef;

    private void setThisRef(Dlg_prob myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_prob> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_prob create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_prob create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_prob dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_prob((java.awt.Frame) parent, false);
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
            Dlg_prob dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_prob((java.awt.Dialog) parent, false);
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

        Dlg_prob dialog = Dlg_prob.create(new javax.swing.JFrame(), true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_my_services_problems = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_my_services_problems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_my_services_problems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_problemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_my_services_problems);

        jLabel1.setText("Name:");

        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_customer_name)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        // TODO add your handling code here:
        init_problem();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tbl_my_services_problemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_problemsMouseClicked
        delete_prob();
    }//GEN-LAST:event_tbl_my_services_problemsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_my_services_problems;
    private javax.swing.JTextField tf_customer_name;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_my_services_problems();
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

    List<S1_my_services_problems.to_my_services_problems> problem_list = new ArrayList();

    private void init_problem() {
        String search = tf_customer_name.getText();
        problem_list.clear();
        String where = " where problem like '%" + search + "%' order by problem asc ";
        problem_list = S1_my_services_problems.ret_data(where);
        Object[][] obj = new Object[problem_list.size()][1];
        int i = 0;
        for (S1_my_services_problems.to_my_services_problems to : problem_list) {
            obj[i][0] = to.problem;
            i++;
        }
        if (problem_list.isEmpty()) {
            S1_my_services_problems.to_my_services_problems to = new S1_my_services_problems.to_my_services_problems(0, search,0);
            if (!search.isEmpty()) {
                S1_my_services_problems.add_my_services_problems(to);
            }
        } else {
            JLabel[] labels = {};
            int[] tbl_widths_customers = {300};
            int width = 0;
            String[] col_names = {""};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf_customer_name, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_my_services_problems.to_my_services_problems to = problem_list.get(data.selected_row);
                    tf_customer_name.setText("" + to.problem);
                    add_prob();
                }
            });
        }
    }

    private ArrayListModel tbl_my_services_problems_ALM;
    private Tblmy_services_problemsModel tbl_my_services_problems_M;

    private void init_tbl_my_services_problems() {
        tbl_my_services_problems_ALM = new ArrayListModel();
        tbl_my_services_problems_M = new Tblmy_services_problemsModel(tbl_my_services_problems_ALM);
        tbl_my_services_problems.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_my_services_problems.setModel(tbl_my_services_problems_M);
        tbl_my_services_problems.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_problems.setRowHeight(25);
        int[] tbl_widths_my_services_problems = {100, 60};
        for (int i = 0, n = tbl_widths_my_services_problems.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_problems, i, tbl_widths_my_services_problems[i]);
        }
        Dimension d = tbl_my_services_problems.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_my_services_problems.getTableHeader().setPreferredSize(d);
        tbl_my_services_problems.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services_problems.setRowHeight(35);
        tbl_my_services_problems.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_my_services_problems(List<to_my_services_problems> acc) {
        tbl_my_services_problems_ALM.clear();
        tbl_my_services_problems_ALM.addAll(acc);
    }

    public static class Tblmy_services_problemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Problem", "Action"
        };

        public Tblmy_services_problemsModel(ListModel listmodel) {
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
            to_my_services_problems tt = (to_my_services_problems) getRow(row);
            switch (col) {
                case 0:
                    return "  " + tt.problem;
                default:
                    return "  Delete";
            }
        }
    }

    private void add_prob() {
        String prob = tf_customer_name.getText();
        to_my_services_problems to = new to_my_services_problems(-1, prob,0);
        tbl_my_services_problems_ALM.add(to);
        tbl_my_services_problems_M.fireTableDataChanged();
    }

    private void delete_prob() {
        int row = tbl_my_services_problems.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_my_services_problems.getSelectedColumn();
        if (col < 0) {
            return;
        }
        if (col == 1) {
            tbl_my_services_problems_ALM.remove(row);
            tbl_my_services_problems_M.fireTableDataChanged();
        }

    }
}
