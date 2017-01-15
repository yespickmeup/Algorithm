/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_reports;

import POS.accounts_receivable.S1_accounts_receivable_payments;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.Branches;
import POS.cash_drawer.CashDrawer;
import POS.cash_drawer.CashDrawer_remittances;
import POS.last_remittance.Dlg_last_remittance;
import POS.last_remittance.S1_cash_drawer_last_remittances;
import POS.my_sales.MySales;
import POS.prepaid_payments.Prepaid_payments;
import POS.reports.Dlg_report_items;
import POS.users.MyUser;
import POS.users.S1_users;
import POS.util.Alert;
import POS.util.TableRenderer;
import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Dlg_report_sales_summary extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_report_sales_summary
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
    private Dlg_report_sales_summary(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_report_sales_summary(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_report_sales_summary() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_report_sales_summary myRef;

    private void setThisRef(Dlg_report_sales_summary myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_sales_summary> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_sales_summary create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_sales_summary create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_sales_summary dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_sales_summary((java.awt.Frame) parent, false);
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
            Dlg_report_sales_summary dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_sales_summary((java.awt.Dialog) parent, false);
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

        Dlg_report_sales_summary dialog = Dlg_report_sales_summary.create(new javax.swing.JFrame(), true);
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
        jButton2 = new Button.Success();
        jButton3 = new Button.Default();
        pnl_report = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        tf_cashier = new Field.Combo();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField2 = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new Field.Combo();
        jButton1 = new Button.Search();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setOpaque(false);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/printer67.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/dollar132.png"))); // NOI18N
        jButton3.setText("Last Remittance");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pnl_report.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Date from:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Date to:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cashier:");

        tf_cashier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashierMouseClicked(evt);
            }
        });
        tf_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashierActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Choose Branch:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Choose Location:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/search19.png"))); // NOI18N
        jButton1.setToolTipText("Search");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox1))
                            .addComponent(tf_cashier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        print();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        init_report();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashierActionPerformed
        init_cashier();
    }//GEN-LAST:event_tf_cashierActionPerformed

    private void tf_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashierMouseClicked
        init_cashier();
    }//GEN-LAST:event_tf_cashierMouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branches();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branches();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        init_branch_locations();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        last_remittance();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JTextField tf_cashier;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_branch();

        String where = "  order by screen_name asc";
        user_list = MyUser.ret_data(where);
        Field.Combo user = (Field.Combo) tf_cashier;
        user.setText(MyUser.getUser_screen_name());
        user.setId(MyUser.getUser_id());
    }

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();

        Field.Combo lo = (Field.Combo) jTextField1;
        Field.Combo br = (Field.Combo) jTextField2;
        lo.setText(to.location);
        lo.setId("" + to.id);

        br.setText(to.branch);
        br.setId("" + to.branch_id);

        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;

    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches() {
        final Field.Combo br = (Field.Combo) jTextField2;

        branches_list.clear();
        branches_list = Branches.ret_where("");
        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (Branches.to_branches to : branches_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.branch;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Branch"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Branches.to_branches to = branches_list.
                        get(data.selected_row);
                br.setText(to.branch);
                br.setId("" + to.id);

            }
        });
    }
    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {
        final Field.Combo br = (Field.Combo) jTextField2;
        final Field.Combo lo = (Field.Combo) jTextField1;
        branch_location_list.clear();
        String where = " where branch_id='" + br.getId() + "' ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(lo, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText("" + to.location);
                lo.setId("" + to.id);

            }
        });
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

    List<S1_users.to_users> user_list = new ArrayList();

    private void init_cashier() {
        String search = tf_cashier.getText();

        Object[][] obj = new Object[user_list.size()][1];
        int i = 0;
        for (S1_users.to_users to : user_list) {

            obj[i][0] = " " + to.screen_name;

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_cashier.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_cashier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo f = (Field.Combo) tf_cashier;
                S1_users.to_users to = (S1_users.to_users) user_list.get(data.selected_row);
                tf_cashier.setText(to.screen_name);
                f.setId("" + to.id);
                f.setText(to.screen_name);
            }
        });
    }

    private void init_report() {
        Button.Search search = (Button.Search) jButton1;
        search.load();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Field.Combo br = (Field.Combo) jTextField2;
                Field.Combo lo = (Field.Combo) jTextField1;

                Field.Combo f = (Field.Combo) tf_cashier;
                String date_from = DateType.sf.format(jDateChooser1.getDate());
                String date_to = DateType.sf.format(jDateChooser2.getDate());
                String where_drawer = " where Date(time_in) between '" + date_from + "' and '" + date_to + "' "
                        + " and location_id='" + lo.getId() + "' ";

                String where_sales = " where Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                        + " and location_id='" + lo.getId() + "' ";

                String where_sales2 = " where Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                        + " and location_id='" + lo.getId() + "' and status='" + "0" + "' ";
                if (!jCheckBox1.isSelected()) {
                    where_drawer = " where Date(time_in) between '" + date_from + "' and '" + date_to + "' "
                            + " and location_id='" + lo.getId() + "' and user_id='" + f.getId() + "'";
                    where_sales = " where Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                            + " and location_id='" + lo.getId() + "' and user_id='" + f.getId() + "'";
                    where_sales2 = " where Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                            + " and location_id='" + lo.getId() + "' and user_id='" + f.getId() + "' and status='" + "0" + "' ";
                }
                List<CashDrawer.to_cash_drawer> my_drawer = CashDrawer.ret_data(where_drawer);
                List<MySales.sales> my_sale = MySales.ret_data(where_sales2);
                List<S1_accounts_receivable_payments.to_accounts_receivable_payments> my_collections = S1_accounts_receivable_payments.ret_data2(where_sales2);
                List<Prepaid_payments.to_prepaid_payments> my_prepayment = Prepaid_payments.ret_data(where_sales);
                List<Srpt_end_of_day_summary_details.field> my_details = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_checks = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_credit_cards = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_gcs = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_remittances = new ArrayList();
                List<CashDrawer_remittances.to_cash_drawer_remittances> remittances = CashDrawer_remittances.ret_data(where_sales);

                double cashin_beg = 0;
                double cash_sales = 0;
                double collections = 0;
                double prepayments = 0;
                double receipts_total = 0;
                double receipts_line_discount = 0;
                double receipts_sale_discount = 0;
                double receipts_sub_total = 0;
                double receipt_net_total = 0;

                double bills_thousand = 0;
                double bills_five_hundred = 0;
                double bills_two_hundred = 0;
                double bills_one_hundred = 0;
                double bills_fifty = 0;
                double bills_twenty = 0;
                double coins_ten = 0;
                double coins_five = 0;
                double coins_one = 0;
                double coins_point_fifty = 0;
                double coins_point_twenty_five = 0;
                double coins_point_ten = 0;
                double coins_point_zero_five = 0;

                double count_bills_thousand = 0;
                double count_bills_five_hundred = 0;
                double count_bills_two_hundred = 0;
                double count_bills_one_hundred = 0;
                double count_bills_fifty = 0;
                double count_bills_twenty = 0;
                double count_coins_ten = 0;
                double count_coins_five = 0;
                double count_coins_one = 0;
                double count_coins_point_fifty = 0;
                double count_coins_point_twenty_five = 0;
                double count_coins_point_ten = 0;
                double count_coins_point_zero_five = 0;

                double cc_total = 0;
                double check_cash_sales = 0;
                double check_collections = 0;
                double check_prepayments = 0;
                double cc_cash_sales = 0;
                double cc_collections = 0;
                double cc_prepayments = 0;
                double total_check_payments = 0;
                double total_cc_payments = 0;
                for (CashDrawer.to_cash_drawer drawer : my_drawer) {
                    cashin_beg += drawer.amount;
                    count_bills_thousand += drawer.thousand;
                    count_bills_five_hundred += drawer.five_hundred;
                    count_bills_two_hundred += drawer.two_hundred;
                    count_bills_one_hundred += drawer.one_hundred;
                    count_bills_fifty += drawer.fifty;
                    count_bills_twenty += drawer.twenty;
                    count_coins_ten += drawer.ten;
                    count_coins_five += drawer.five;
                    count_coins_one += drawer.one;
                    count_coins_point_fifty += drawer.point_five;
                    count_coins_point_twenty_five += drawer.point_two_five;
                    count_coins_point_ten += drawer.point_ten;
                    count_coins_point_zero_five += drawer.point_zero_five;
                }
                for (MySales.sales sale : my_sale) {

                    cash_sales += sale.gross_amount;
                    receipts_line_discount += sale.line_discount;
                   
                    receipts_sale_discount += sale.discount_amount;
                    if (sale.check_amount > 0) {
                        Srpt_end_of_day_summary_details.field check = new Srpt_end_of_day_summary_details.field("Checks", sale.check_bank, "", FitIn.fmt_wc_0(sale.check_amount));
                        my_checks.add(check);

                        check_cash_sales += sale.check_amount;
                    }
                    if (sale.credit_card_amount > 0) {
                        Srpt_end_of_day_summary_details.field credit_card = new Srpt_end_of_day_summary_details.field("Credit Card", sale.credit_card_type, "", FitIn.fmt_wc_0(sale.credit_card_amount));
                        my_credit_cards.add(credit_card);
                        cc_cash_sales += sale.credit_card_amount;
                    }
                    if (sale.gift_certificate_amount > 0) {
                        Srpt_end_of_day_summary_details.field gc = new Srpt_end_of_day_summary_details.field("Gift Certificate", sale.gift_certificate_from, "", FitIn.fmt_wc_0(sale.gift_certificate_amount));
                        my_gcs.add(gc);
                    }
                }
                cash_sales = cash_sales - cc_cash_sales;
                cc_total = cash_sales;
                for (S1_accounts_receivable_payments.to_accounts_receivable_payments collection : my_collections) {
                    collections += collection.amount;
                    if (collection.check_amount > 0) {
                        Srpt_end_of_day_summary_details.field check = new Srpt_end_of_day_summary_details.field("Checks", collection.check_bank, "", FitIn.fmt_wc_0(collection.check_amount));
                        my_checks.add(check);

                        check_collections += collection.check_amount;
                    } else {
                        cc_total += collection.amount;
                    }
                }
                for (Prepaid_payments.to_prepaid_payments prepayment : my_prepayment) {
                    prepayments += prepayment.cash;
                    if (prepayment.check_amount > 0) {
                        Srpt_end_of_day_summary_details.field check = new Srpt_end_of_day_summary_details.field("Checks", prepayment.check_bank, "", FitIn.fmt_wc_0(prepayment.check_amount));
                        my_checks.add(check);

                        check_prepayments += prepayment.check_amount;
                    } else {
                        cc_total += prepayment.cash;
                    }
                }

                double total_remittance = 0;
                for (CashDrawer_remittances.to_cash_drawer_remittances remittance : remittances) {
                    double am = remittance.cash_amount;
                    if (remittance.cheque_amount > 0) {
                        am = remittance.cheque_amount;
                    }
                    total_remittance += am;
                    Srpt_end_of_day_summary_details.field remit1 = new Srpt_end_of_day_summary_details.field("Remitted", "", FitIn.fmt_wc_0(am), "");
                    my_remittances.add(remit1);
                }
                if (remittances.size() == 1) {
                    Srpt_end_of_day_summary_details.field remittance = (Srpt_end_of_day_summary_details.field) my_remittances.get(0);
                    remittance.setDebit(FitIn.fmt_wc_0(total_remittance));
                } else if (remittances.size() > 1) {
                    Srpt_end_of_day_summary_details.field remittance = (Srpt_end_of_day_summary_details.field) my_remittances.get(remittances.size() - 1);
                    remittance.setDebit(FitIn.fmt_wc_0(total_remittance));
                }
                my_details.addAll(my_checks);
                my_details.addAll(my_credit_cards);
                my_details.addAll(my_gcs);
                my_details.addAll(my_remittances);

                receipts_total = cash_sales + collections + prepayments;
                receipts_sub_total = receipts_total - (receipts_line_discount + receipts_sale_discount);
                receipt_net_total = receipts_sub_total + cashin_beg;

                bills_thousand = 1000 * count_bills_thousand;
                bills_five_hundred = 500 * count_bills_five_hundred;
                bills_two_hundred = 200 * count_bills_two_hundred;
                bills_one_hundred = 100 * count_bills_one_hundred;
                bills_fifty = 50 * count_bills_fifty;
                bills_twenty = 20 * count_bills_twenty;
                coins_ten = 10 * count_coins_ten;
                coins_five = 5 * count_coins_five;
                coins_one = 1 * count_coins_one;
                coins_point_fifty = .5 * count_coins_point_fifty;
                coins_point_twenty_five = .25 * count_coins_point_twenty_five;
                coins_point_ten = .10 * count_coins_point_ten;
                coins_point_zero_five = .05 * count_coins_point_zero_five;

                String date = DateType.sf.format(new Date());
                String where = " where Date(date_added)='" + date + "' and location_id='" + my_location_id + "' ";
                double cc_last_remittance = 0;
                final List<S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances> datas = S1_cash_drawer_last_remittances.ret_data(where);
                for (S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances remit : datas) {
                    cc_last_remittance += remit.amount;
                }
                String date2 = "Date as of " + DateType.convert_slash_datetime2(date_from) + " - " + DateType.convert_slash_datetime2(date_to);
                double ccs = bills_thousand + bills_five_hundred + bills_two_hundred + bills_one_hundred + bills_fifty
                        + bills_twenty + coins_ten + coins_five + coins_one + coins_point_fifty + coins_point_twenty_five
                        + coins_point_ten + coins_point_zero_five;

                cc_total = (ccs + total_remittance);

                double cc_cashin_end = cc_total - cc_last_remittance;
                total_check_payments = check_cash_sales + check_collections + check_prepayments;
                total_cc_payments = cc_cash_sales + cc_collections + cc_prepayments;
                String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "retail_res\\rpt2\\";
                String business_name = System.getProperty("business_name", "");
                String address = System.getProperty("address", "");
                String os_name = System.getProperty("os.name");
                if (os_name.equalsIgnoreCase("Linux")) {
                    String home = System.getProperty("user.home");
                    SUBREPORT_DIR = home + "/retail_res/rpt2/";
                }

                date = DateType.slash.format(jDateChooser1.getDate()) + " - " + DateType.slash.format(jDateChooser2.getDate());
                Srpt_end_of_day_summary rpt = new Srpt_end_of_day_summary(cashin_beg, cash_sales, collections, prepayments, receipts_total, receipts_line_discount,
                        receipts_sale_discount, receipts_sub_total, receipt_net_total, bills_thousand, bills_five_hundred, bills_two_hundred,
                        bills_one_hundred, bills_fifty, bills_twenty, coins_ten, coins_five, coins_one, coins_point_fifty, coins_point_twenty_five,
                        coins_point_ten, coins_point_zero_five, count_bills_thousand, count_bills_five_hundred,
                        count_bills_two_hundred, count_bills_one_hundred, count_bills_fifty, count_bills_twenty, count_coins_ten,
                        count_coins_five, count_coins_one, count_coins_point_fifty, count_coins_point_twenty_five,
                        count_coins_point_ten, count_coins_point_zero_five, cc_total, cc_last_remittance, cc_cashin_end, SUBREPORT_DIR,
                        my_details, check_cash_sales, check_collections, check_prepayments, cc_cash_sales, cc_collections, cc_prepayments,
                        total_check_payments, total_cc_payments, date, business_name, address);
                String jrxml = "rpt_end_of_day_summary.jrxml";
                report_sales_items(rpt, jrxml);
                InputStream is = Srpt_sales_summary.class.getResourceAsStream("rpt_sales_summary.jrxml");
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.emptyDatasource());

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).log(Level.SEVERE, null, ex);
                }
                Button.Search search = (Button.Search) jButton1;
                search.finish();
            }
        });
        t.start();

    }

    private void report_sales_items(final Srpt_end_of_day_summary to, String jrxml_name) {
        pnl_report.removeAll();
        pnl_report.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_expenses(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report.add(viewer);
            pnl_report.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_expenses(Srpt_end_of_day_summary to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_summary.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint = null;

    private void print() {
        try {
            if (jasperPrint != null) {
                JasperPrintManager.printReport(jasperPrint, false);
            }

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    private void last_remittance() {

        String date = DateType.sf.format(new Date());
        String where = " where Date(date_added)='" + date + "' and location_id='" + my_location_id + "' ";
        double amount = 0;
        final List<S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances> datas = S1_cash_drawer_last_remittances.ret_data(where);
        for (S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances remit : datas) {
            amount += remit.amount;
        }
        Window p = (Window) this;
        Dlg_last_remittance nd = Dlg_last_remittance.create(p, true);
        nd.setTitle("");
        if (!datas.isEmpty()) {
            nd.do_pass(amount);
        }
        nd.setCallback(new Dlg_last_remittance.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_last_remittance.OutputData data) {
                closeDialog.ok();
                if (datas.isEmpty()) {
                    int id = 0;
                    String user_id = MyUser.getUser_id();
                    String user_screen_name = MyUser.getUser_screen_name();
                    String date_added = DateType.now();
                    int status = 0;
                    double amount = data.amount;
                    String branch = my_branch;
                    String branch_id = my_branch_id;
                    String location = my_location;
                    String location_id = my_location_id;
                    S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances to = new S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances(id, user_id, user_screen_name, date_added, status, amount, branch, branch_id, location, location_id);
                    S1_cash_drawer_last_remittances.add_data(to);
                    Alert.set(1, "");
                } else {
                    S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances to1 = (S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances) datas.get(0);
                    int id = to1.id;
                    String user_id = to1.user_id;
                    String user_screen_name = to1.user_screen_name;
                    String date_added = to1.date_added;
                    int status = 0;
                    double amount = data.amount;
                    String branch = to1.branch;
                    String branch_id = to1.branch_id;
                    String location = to1.location;
                    String location_id = to1.location_id;
                    S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances to = new S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances(id, user_id, user_screen_name, date_added, status, amount, branch, branch_id, location, location_id);
                    S1_cash_drawer_last_remittances.update_data(to);
                    Alert.set(2, "");
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

}
