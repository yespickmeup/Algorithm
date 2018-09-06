/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.delivery.Dlg_delivery_print_preview;
import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.reports.Dlg_report_items;
import POS.sales.Sales;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;
import synsoftech.util.ImageRenderer1;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_transactions_search extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_transactions_search
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

        public final MySales.sales sales;

        public OutputData(MySales.sales sales) {
            this.sales = sales;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_transactions_search(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_transactions_search(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_transactions_search() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_transactions_search myRef;

    private void setThisRef(Dlg_touchscreen_transactions_search myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_transactions_search> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_transactions_search create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_transactions_search create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_transactions_search dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_transactions_search((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_transactions_search dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_transactions_search((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_transactions_search dialog = Dlg_touchscreen_transactions_search.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField1 = new Field.Search();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Default();
        jButton3 = new Button.Success();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_from_branch = new javax.swing.JTextField();
        tf_from_branch_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Date From:");

        jDateChooser1.setDate(new Date());

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("To:");

        jDateChooser2.setDate(new Date());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search by:");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Customer Name");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Transaction No");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Transactions:");

        jLabel5.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Location:");

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

        tf_from_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch_id.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(tf_from_branch)
                                            .addGap(0, 0, 0)
                                            .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jCheckBox1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jCheckBox2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jCheckBox3))))))
                                .addGap(381, 381, 381)))
                        .addGap(0, 0, 0)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        select_sale();
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
          data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch_id;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db", "db_smis_cebu_chickaloka");
        init_key();
        init_tbl_sales(tbl_sales);
        tf_from_branch_id.setVisible(false);
        set_default_branch();
        jTextField1.grabFocus();

        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);
    }

    public void do_pass() {

    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        tf_from_branch.setText(to.branch + " - " + to.location);
        tf_from_branch_id.setText("" + to.id);

    }

    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations2() {
        Object[][] obj = new Object[branch_location_list2.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list2) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {90, 120};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_from_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list2.get(data.selected_row);
                tf_from_branch.setText(to.branch + " - " + to.location);
                tf_from_branch_id.setText("" + to.id);
            }
        });
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

    //<editor-fold defaultstate="collapsed" desc=" sales "> 
    public static ArrayListModel tbl_sales_ALM;
    public static TblsalesModel tbl_sales_M;

    public static void init_tbl_sales(JTable tbl_sales) {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {150, 80, 100, 100, 0, 0, 70, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_sales[i]);
        }
        Dimension d = tbl_sales.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_sales.getTableHeader().setPreferredSize(d);
        tbl_sales.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_sales.setRowHeight(25);
        tbl_sales.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 3);
        tbl_sales.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer1());
        tbl_sales.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer1());
        tbl_sales.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_sales(List<MySales.sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);
    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Date", "Customer", "Amount Due", "DR", "OR", "Status", "", "amount_due", "status", "sales_type", "line_discount", "customer_id", "customer_name", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "charge_type", "charge_type_id", "charge_reference_no", "charge_customer_name", "charge_customer_id", "charge_amount", "check_bank", "check_no", "check_amount", "check_holder", "check_date", "credit_card_type", "credit_card_rate", "credit_card_amount", "credit_card_no", "credit_card_holder", "credit_card_approval_code", "gift_certificate_from", "gift_certificate_description", "gift_certificate_no", "gift_certificate_amount", "prepaid_customer_name", "prepaid_customer_id", "prepaid_amount", "addtl_amount", "wtax"
        };

        public TblsalesModel(ListModel listmodel) {
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
            MySales.sales tt = (MySales.sales) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.sales_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.customer_name;
                case 3:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 4:
                    return "/POS/touchscreen_icons/white29.png";
                case 5:
                    return "/POS/touchscreen_icons/white29.png";
                case 6:
                    if (tt.status == 0) {
                        return " Counted";
                    } else {
                        return " Void";
                    }
                case 7:
                    return "/POS/icon_payment/edit (1).png";
                case 8:
                    return tt.amount_due;
                case 9:
                    return tt.status;
                case 10:
                    return tt.sales_type;
                case 11:
                    return tt.line_discount;
                case 12:
                    return tt.customer_id;
                case 13:
                    return tt.customer_name;
                case 14:
                    return tt.discount_name;
                case 15:
                    return tt.discount_rate;
                case 16:
                    return tt.discount_amount;
                case 17:
                    return tt.discount_customer_name;
                case 18:
                    return tt.discount_customer_id;
                case 19:
                    return tt.charge_type;
                case 20:
                    return tt.charge_type_id;
                case 21:
                    return tt.charge_reference_no;
                case 22:
                    return tt.charge_customer_name;
                case 23:
                    return tt.charge_customer_id;
                case 24:
                    return tt.charge_amount;
                case 25:
                    return tt.check_bank;
                case 26:
                    return tt.check_no;
                case 27:
                    return tt.check_amount;
                case 28:
                    return tt.check_holder;
                case 29:
                    return tt.check_date;
                case 30:
                    return tt.credit_card_type;
                case 31:
                    return tt.credit_card_rate;
                case 32:
                    return tt.credit_card_amount;
                case 33:
                    return tt.credit_card_no;
                case 34:
                    return tt.credit_card_holder;
                case 35:
                    return tt.credit_card_approval_code;
                case 36:
                    return tt.gift_certificate_from;
                case 37:
                    return tt.gift_certificate_description;
                case 38:
                    return tt.gift_certificate_no;
                case 39:
                    return tt.gift_certificate_amount;
                case 40:
                    return tt.prepaid_customer_name;
                case 41:
                    return tt.prepaid_customer_id;
                case 42:
                    return tt.prepaid_amount;
                case 43:
                    return tt.addtl_amount;
                default:
                    return tt.wtax;
            }
        }
    }
//</editor-fold> 

    private void data_cols() {
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        String where = "where remarks like '%" + "" + "%' ";
        if (!jCheckBox1.isSelected()) {
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (jCheckBox2.isSelected()) {
            where = where + " and customer_name like '%" + jTextField1.getText() + "%' ";
        } else {
            where = where + " and sales_no like '%" + jTextField1.getText() + "%' ";
        }
        where = where + " and location_id = '" + tf_from_branch_id.getText() + "' ";
        List<MySales.sales> datas = MySales.ret_data(where);
        loadData_sales(datas);
        jLabel5.setText("" + datas.size());
    }

    private void ok() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        MySales.sales to = (MySales.sales) tbl_sales_ALM.get(row);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(to));
        }
    }

    private void select_sale() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_sales.getSelectedColumn();
        MySales.sales sale = (MySales.sales) tbl_sales_ALM.get(row);
        if (col == 4) {

            String where = "where sales_no='" + sale.sales_no + "' ";
            List<MySales_Items.items> datas = MySales_Items.ret_data(where);

            Window p = (Window) this;
            Dlg_delivery_print_preview nd = Dlg_delivery_print_preview.create(p, true);
            nd.setTitle("");
            nd.do_pass2(datas, sale.discount_amount, sale.amount_due, sale);

            nd.setCallback(new Dlg_delivery_print_preview.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_delivery_print_preview.OutputData data) {
                    closeDialog.ok();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 5) {
            reprint_or();
        }
        if (col == 7) {
            edit_transaction(sale);
        }
    }

    private void edit_transaction(final MySales.sales sale) {

        Window p = (Window) this;
        Dlg_touchscreen_transactions_search_edit nd = Dlg_touchscreen_transactions_search_edit.create(p, true);
        nd.setTitle("");
        nd.do_pass(sale.customer_name);
        nd.setCallback(new Dlg_touchscreen_transactions_search_edit.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_transactions_search_edit.OutputData data) {
                closeDialog.ok();
                Sales.update_customer_name(sale, data.customer_name);
                data_cols();
                Alert.set(2, "");
                
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void reprint_or() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }

        MySales.sales sales = (MySales.sales) tbl_sales_ALM.get(row);

        List<Srpt_receipt.field> fields = new ArrayList();
        String where = "where sales_no='" + sales.sales_no + "' ";
        List<MySales_Items.items> orders = MySales_Items.ret_data(where);

        int total_qty = 0;
        double vatable_sale = 0;
        double zero_rate_sale = 0;
        double vat_exempt_sale = 0;
        double vat_percent = 0;
        for (MySales_Items.items to : orders) {
            String desc = to.description;
            Date date_added = new Date();
            double total = (to.product_qty * to.selling_price) - to.discount_amount;
            double qty = to.product_qty;
            double selling_price = to.selling_price;
            double discount = to.discount_amount;
            Srpt_receipt.field tbar = new Srpt_receipt.field(desc, date_added, total, qty, selling_price, discount);
            fields.add(tbar);

            total_qty += to.product_qty;
        }
        vatable_sale = sales.amount_due / 1.12;
        vat_percent = vatable_sale * .12;

        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        String tin_no = System.getProperty("tin_no", "TIN No.: 000000");
        String serial_no = System.getProperty("serial_no", "Serial No.: 000000");
        String permit_no = System.getProperty("permit_no", "Permit No.: 000000");
        String datetime = POS.util.DateType.slash_w_time.format(new Date());
        String or_no = sales.sales_no;
        String items = System.getProperty("items", "");

        double total_due = sales.amount_due;
        double cash = sales.amount_due - (sales.credit_card_amount + sales.gift_certificate_amount + sales.prepaid_amount + sales.check_amount + sales.charge_amount);

        double change_due = 0;
        String receipt_infos = System.getProperty("receipt_infos", "");
        String receipt_footer = System.getProperty("receipt_footer", "This is an Official receipt");
        double discount = sales.discount_amount;
        String customer_name = sales.customer_name;
        String cashier_name = MyUser.getUser_screen_name();
        String discount_name = sales.discount_customer_name;
        String pos_no = "";

        String accreditation_no = System.getProperty("acct_no", "Accreditation No.: 000000");
        String trans_no = sales.sales_no;
        String check_bank = sales.check_bank;
        double check_amount = sales.check_amount;
        String telephone_number = "please call:" + System.getProperty("telephone_number", "0000-000-0000");
        String discount_customer_name = sales.discount_customer_name;
        String discount_customer_id = sales.discount_customer_id;
        String min_no = System.getProperty("min_no", "MIN No.: 000000");
        double addtl_service = 0;
        String customer_address = "";
        double amount_due = sales.gross_amount;
        double line_discount = sales.line_discount;
        double credit_card = sales.credit_card_amount;
        double gift_certificate = sales.gift_certificate_amount;
        double prepaid = sales.prepaid_amount;
        double charge_amount = sales.charge_amount;
        Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash, change_due, receipt_infos, receipt_footer, discount, customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale, zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name, discount_customer_id, min_no, addtl_service, customer_address, "", amount_due, "", line_discount, credit_card, gift_certificate, prepaid, charge_amount);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_receipt.jrxml";
        InputStream is = Srpt_receipt.class.getResourceAsStream(jrxml);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

            String print = System.getProperty("print_to_receipts", "false");
            System.out.println("Print to Receipts: " + print);
            if (print.equalsIgnoreCase("true")) {
                try {
                    if (jasperPrint != null) {
                        JasperPrintManager.printReport(jasperPrint, false);
                    }

                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
                    throw new RuntimeException(e);
                }
            }

        } catch (JRException ex) {
            Logger.getLogger(Dlg_report_items.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
    JasperPrint jasperPrint = null;
}
