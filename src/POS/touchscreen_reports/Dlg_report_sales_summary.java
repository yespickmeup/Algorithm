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
import POS.cash_drawer.S1_cash_drawer;
import POS.disbursements.S1_disbursements;
import POS.item_replacements.Item_replacements;
import POS.last_remittance.Dlg_last_remittance;
import POS.last_remittance.S1_cash_drawer_last_remittances;
import POS.my_sales.MySales;
import POS.prepaid_payments.Prepaid_payments;
import POS.reports.Dlg_report_items;
import POS.returns.Return_from_customer_items;
import POS.users.MyUser;
import POS.users.S1_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        pnl_report = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new Button.Success();
        jButton3 = new Button.Default();
        jLabel39 = new javax.swing.JLabel();
        jButton9 = new Button.Default();
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
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        tf_cashier3 = new Field.Combo();
        jLabel17 = new javax.swing.JLabel();
        tf_cashier4 = new Field.Combo();
        jCheckBox14 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        tf_cashier5 = new Field.Combo();
        jCheckBox15 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        tf_cashier1 = new Field.Combo();
        jCheckBox5 = new javax.swing.JCheckBox();
        jTextField3 = new Field.Combo();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new Field.Combo();
        jButton4 = new Button.Search();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        pnl_report1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new Button.Success();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        tf_cashier2 = new Field.Combo();
        jCheckBox9 = new javax.swing.JCheckBox();
        jTextField5 = new Field.Combo();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new Field.Combo();
        jButton6 = new Button.Search();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jButton7 = new Button.Success();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnl_report2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_chickaloka_items = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pnl_report.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/print44.png"))); // NOI18N
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

        jLabel39.setBackground(new java.awt.Color(153, 153, 153));
        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("0");
        jLabel39.setOpaque(true);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/cloud-storage3.png"))); // NOI18N
        jButton9.setText("Upload Transactions");
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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
        jTextField1.setFocusable(false);
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

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Time from:");

        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("All");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        tf_cashier3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier3.setText("12:00am");
        tf_cashier3.setEnabled(false);
        tf_cashier3.setFocusable(false);
        tf_cashier3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashier3MouseClicked(evt);
            }
        });
        tf_cashier3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashier3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Time to:");

        tf_cashier4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier4.setText("11:59pm");
        tf_cashier4.setEnabled(false);
        tf_cashier4.setFocusable(false);
        tf_cashier4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashier4MouseClicked(evt);
            }
        });
        tf_cashier4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashier4ActionPerformed(evt);
            }
        });

        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setSelected(true);
        jCheckBox14.setText("Regular/Night");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Shift:");

        tf_cashier5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier5.setFocusable(false);
        tf_cashier5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashier5MouseClicked(evt);
            }
        });
        tf_cashier5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashier5ActionPerformed(evt);
            }
        });

        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox15.setText("Manual/Auto");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_cashier))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jCheckBox13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_cashier3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jCheckBox4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_cashier4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 170, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_cashier5)
                        .addGap(434, 434, 434)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox1))
                            .addComponent(tf_cashier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox13)
                                    .addComponent(tf_cashier3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_cashier4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox4))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_cashier5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Overall", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Date from:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Date to:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cashier:");

        tf_cashier1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashier1MouseClicked(evt);
            }
        });
        tf_cashier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashier1ActionPerformed(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Choose Branch:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Choose Location:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setFocusable(false);
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/search19.png"))); // NOI18N
        jButton4.setToolTipText("Search");
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("All");

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("All");

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("All");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_cashier1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox6))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox7)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox8)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox5))
                            .addComponent(tf_cashier1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        pnl_report1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_report1Layout = new javax.swing.GroupLayout(pnl_report1);
        pnl_report1.setLayout(pnl_report1Layout);
        pnl_report1Layout.setHorizontalGroup(
            pnl_report1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_report1Layout.setVerticalGroup(
            pnl_report1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/printer67.png"))); // NOI18N
        jButton5.setText("Print");
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(709, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_report1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_report1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Per Cashier", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Date from:");

        jDateChooser5.setDate(new Date());
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cashier:");

        tf_cashier2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashier2MouseClicked(evt);
            }
        });
        tf_cashier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashier2ActionPerformed(evt);
            }
        });

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setSelected(true);
        jCheckBox9.setText("All");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Choose Branch:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Choose Location:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setFocusable(false);
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/search19.png"))); // NOI18N
        jButton6.setToolTipText("Search");
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setText("All");
        jCheckBox10.setEnabled(false);

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("All");
        jCheckBox11.setEnabled(false);

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("All");
        jCheckBox12.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cashier2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox10))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox11)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox12)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox9))
                            .addComponent(tf_cashier2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/printer67.png"))); // NOI18N
        jButton7.setText("Print");
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pnl_report2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_report2Layout = new javax.swing.GroupLayout(pnl_report2);
        pnl_report2.setLayout(pnl_report2Layout);
        pnl_report2Layout.setHorizontalGroup(
            pnl_report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        pnl_report2Layout.setVerticalGroup(
            pnl_report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Print Preview", pnl_report2);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tbl_chickaloka_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_chickaloka_items);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tabular", jPanel9);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane2)
                .addGap(1, 1, 1)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Chickaloka", jPanel8);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Sales Summary");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/close.png"))); // NOI18N
        jLabel23.setToolTipText("Close");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(10, 10, 10)
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
        print();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        init_report();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashierActionPerformed
        init_cashier(tf_cashier);
    }//GEN-LAST:event_tf_cashierActionPerformed

    private void tf_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashierMouseClicked
        init_cashier(tf_cashier);
    }//GEN-LAST:event_tf_cashierMouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
//        init_branch_locations();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
//        init_branch_locations();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        last_remittance();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_cashier1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashier1MouseClicked
        // TODO add your handling code here:
        init_cashier(tf_cashier1);
    }//GEN-LAST:event_tf_cashier1MouseClicked

    private void tf_cashier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashier1ActionPerformed
        init_cashier(tf_cashier1);
    }//GEN-LAST:event_tf_cashier1ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_branch_locations(jTextField3, jTextField4);
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_branch_locations(jTextField3, jTextField4);
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        init_report_sales_summary_per_cashier();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_cashier2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashier2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cashier2MouseClicked

    private void tf_cashier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashier2ActionPerformed
        init_cashier(tf_cashier2);
    }//GEN-LAST:event_tf_cashier2ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_branch_locations(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_branch_locations(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked

    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        init_report_sales_summary_chickaloka();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

    }//GEN-LAST:event_jButton9ActionPerformed

    private void tf_cashier3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashier3MouseClicked
        if (tf_cashier3.isEnabled()) {
            init_time(tf_cashier3);
        }

    }//GEN-LAST:event_tf_cashier3MouseClicked

    private void tf_cashier3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashier3ActionPerformed
        if (tf_cashier3.isEnabled()) {
            init_time(tf_cashier3);
        }

    }//GEN-LAST:event_tf_cashier3ActionPerformed

    private void tf_cashier4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashier4MouseClicked
        if (tf_cashier4.isEnabled()) {
            init_time(tf_cashier4);
        }

    }//GEN-LAST:event_tf_cashier4MouseClicked

    private void tf_cashier4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashier4ActionPerformed
        if (tf_cashier4.isEnabled()) {
            init_time(tf_cashier4);
        }

    }//GEN-LAST:event_tf_cashier4ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
//        if (!jCheckBox13.isSelected()) {
//            jCheckBox14.setVisible(true);
//            jLabel18.setVisible(true);
//        } else {
//            jCheckBox14.setVisible(false);
//            jLabel18.setVisible(false);
//        }
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void tf_cashier5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashier5MouseClicked
        if (tf_cashier5.isEnabled()) {
            init_cashdrawer(tf_cashier5);
        }

    }//GEN-LAST:event_tf_cashier5MouseClicked

    private void tf_cashier5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashier5ActionPerformed
        if (tf_cashier5.isEnabled()) {
            init_cashdrawer(tf_cashier5);
        }

    }//GEN-LAST:event_tf_cashier5ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        select_time_type();
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
       disposed();
    }//GEN-LAST:event_jLabel23MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JPanel pnl_report1;
    private javax.swing.JPanel pnl_report2;
    private javax.swing.JTable tbl_chickaloka_items;
    private javax.swing.JTextField tf_cashier;
    private javax.swing.JTextField tf_cashier1;
    private javax.swing.JTextField tf_cashier2;
    private javax.swing.JTextField tf_cashier3;
    private javax.swing.JTextField tf_cashier4;
    private javax.swing.JTextField tf_cashier5;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_store");
//        System.setProperty("pool_host", "localhost");
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("main_branch", "true");
//        System.setProperty("active_branches", "10");
//        System.setProperty("cloud_host", "128.199.80.53");
//        System.setProperty("cloud_user", "smis2");
//        System.setProperty("cloud_password", "nopassword101");
//        System.setProperty("cloud_db", "db_algorithm_development");
        init_key();
        set_default_branch();
        init_tbl_chickaloka_items();
        String where = "  order by screen_name asc";
        user_list = MyUser.ret_data2(where);
        Field.Combo user = (Field.Combo) tf_cashier;
        user.setText(MyUser.getUser_screen_name());
        user.setId(MyUser.getUser_id());
        Field.Combo user2 = (Field.Combo) tf_cashier1;
        user2.setText(MyUser.getUser_screen_name());
        user2.setId(MyUser.getUser_id());
        Field.Combo user3 = (Field.Combo) tf_cashier2;
        user3.setText(MyUser.getUser_screen_name());
        user3.setId(MyUser.getUser_id());
        String pool_db = System.getProperty("pool_db", "db_smis");
        if (!pool_db.equalsIgnoreCase("db_smis_cebu_chickaloka")) {
            jTabbedPane1.removeTabAt(2);
        }
        time_list = DateType.time();
        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
//            ret_transactions();
        }
        jCheckBox14.setVisible(false);
        jLabel18.setVisible(false);
        jPanel2.setVisible(false);
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

        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);

        Field.Combo lo2 = (Field.Combo) jTextField4;
        Field.Combo br2 = (Field.Combo) jTextField3;
        lo2.setText(to.location);
        lo2.setId("" + to.id);
        br2.setText(to.branch);
        br2.setId("" + to.branch_id);

        Field.Combo lo3 = (Field.Combo) jTextField6;
        Field.Combo br3 = (Field.Combo) jTextField5;
        lo3.setText(to.location);
        lo3.setId("" + to.id);
        br3.setText(to.branch);
        br3.setId("" + to.branch_id);

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

    private void init_branch_locations(JTextField b, JTextField t) {
        final Field.Combo br = (Field.Combo) b;
        final Field.Combo lo = (Field.Combo) t;

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch + " - [ " + to.location + " ]";

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {lo.getWidth()};
        int width = 0;
        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText("" + to.location);
                lo.setId("" + to.id);

                br.setText(to.branch);
                br.setId("" + to.branch_id);
            }
        });
    }

    public void do_pass() {
        jLabel8.setVisible(false);
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

    private void init_cashier(final JTextField tf) {

        Object[][] obj = new Object[user_list.size()][1];
        int i = 0;
        for (S1_users.to_users to : user_list) {

            obj[i][0] = " " + to.screen_name;

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo f = (Field.Combo) tf_cashier;
                S1_users.to_users to = (S1_users.to_users) user_list.get(data.selected_row);

                f.setId("" + to.id);
                f.setText(to.screen_name);
            }
        });
    }

    List<String> time_list = new ArrayList();

    private void init_time(final JTextField tf) {

        Object[][] obj = new Object[time_list.size()][1];
        int i = 0;
        for (String to : time_list) {
            obj[i][0] = " " + to;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo f = (Field.Combo) tf;
                String to = (String) time_list.get(data.selected_row);
                f.setText(to);
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
                String date_from_sales = DateType.sf.format(jDateChooser1.getDate());
                String date_to = DateType.sf.format(jDateChooser2.getDate());
                String date_to_sales = DateType.sf.format(jDateChooser2.getDate());
                String time = "All";
                int count_days = DateUtils1.count_days(jDateChooser1.getDate(), jDateChooser2.getDate());

                if (jCheckBox15.isSelected()) {

                    if (jCheckBox13.isSelected()) {
                        if (!jCheckBox14.isSelected()) {
                            if (count_days > 0) {
                                String dfs_time = DateType.convert_am_pm_to_stamp(tf_cashier3.getText(), "from");
                                String dts_time = DateType.convert_am_pm_to_stamp(tf_cashier4.getText(), "to");
                                date_from_sales = date_from_sales + " 00:00:00";
                                date_to_sales = date_to_sales + " " + dfs_time;
                            }
                        } else {
                            date_from_sales = date_from_sales + " 00:00:00";
                            date_to_sales = date_to_sales + " 23:59:59";
                        }
                    } else {
                        String dfs_time = DateType.convert_am_pm_to_stamp(tf_cashier3.getText(), "from");
                        String dts_time = DateType.convert_am_pm_to_stamp(tf_cashier4.getText(), "to");
                        date_from_sales = date_from_sales + " " + dfs_time;
                        date_to_sales = date_to_sales + " " + dts_time;
                        time = "" + tf_cashier3.getText() + " - " + tf_cashier4.getText();
                    }
                } else {
                    if (tf_cashier5.getText().isEmpty() && !jCheckBox13.isSelected()) {
                        Alert.set(0, "Please select time!");
                        Button.Search search = (Button.Search) jButton1;
                        search.finish();
                        return;
                    }
                    if (!jCheckBox13.isSelected()) {
                        try {
                            String[] dates = tf_cashier5.getText().split("- ");
//                            System.out.println("dates[0]: " + dates[0]);
//                            System.out.println("dates[1]: " + dates[1]);
                            Date d1 = DateType.slash_w_time.parse(dates[0]);
                            Date d2 = DateType.slash_w_time.parse(dates[1]);

//                            date_from_sales = DateType.datetime.format(d1.getDate());
                            date_from_sales = DateType.convert_slash_datetime_sf2(dates[0]);
                            date_to_sales = DateType.convert_slash_datetime_sf2(dates[1]);
                            time = tf_cashier5.getText();
                        } catch (ParseException ex) {
                            Logger.getLogger(Dlg_report_sales_summary.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        date_from_sales = date_from_sales + " 00:00:00";
                        date_to_sales = date_to_sales + " 23:59:59";
                    }

                }

                String where_drawer = " where id<>0 ";
                String where_sales = " where id<>0 ";
                String where_sales_status = " where id<>0 and status=1 ";
                String where_sales_status2 = " where id<>0 and status=1 ";
                String where_sales2 = " where id<>0 "
                        + "  and status='" + "0" + "' ";
                String where_sales3 = " where id<>0 "
                        + "  and status='" + "0" + "' ";
                String where_disbursements = " where id<>0 ";
                if (!jCheckBox1.isSelected()) {
                    List<S1_users.to_users> users = S1_users.ret_where(" where id='" + f.getId() + "' ");
                    String user_name = "";
                    if (!users.isEmpty()) {
                        S1_users.to_users user = (S1_users.to_users) users.get(0);
                        user_name = user.user_name;
                    }
                    where_drawer = " where id<>0 "
                            + "  and user_id='" + f.getId() + "'";
                    where_sales = " where id<>0 "
                            + "  and user_id='" + f.getId() + "'";
                    where_sales_status = " where id<>0 "
                            + "  and user_name='" + user_name + "' and status=1 ";
                     where_sales_status2 = " where id<>0 "
                            + "  and user_name='" + f.getId() + "' and status=1 ";
                    where_disbursements = " where id<>0 "
                            + "  and user_id='" + f.getId() + "'";
                    where_sales2 = " where id<>0 "
                            + "  and user_id='" + f.getId() + "' and status='" + "0" + "' ";
                    where_sales3 = " where id<>0 "
                            + "  and user_id='" + f.getId() + "' and status='" + "0" + "' ";
                }
                if (!jCheckBox4.isSelected()) {
                    where_drawer = where_drawer + "  and time_in between '" + date_from_sales + "' and '" + date_to_sales + "' ";
                    where_sales = where_sales + " and date_added between '" + date_from + "' and '" + date_to + "' ";
                    where_sales_status = where_sales_status + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                     where_sales_status2 = where_sales_status2 + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                    
                    where_disbursements = where_disbursements + " and date_added between '" + date_from_sales + "' and '" + date_to_sales + "' ";
                    where_sales2 = where_sales2 + " and date_added between '" + date_from_sales + "' and '" + date_to_sales + "' ";
                    where_sales3 = where_sales3 + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox3.isSelected() && !jCheckBox2.isSelected()) {
                    where_drawer = where_drawer + " and location_id='" + lo.getId() + "' ";
                    where_sales = where_sales + " and location_id='" + lo.getId() + "' ";
                    where_sales_status = where_sales_status + " and location_id='" + lo.getId() + "' ";
                    where_sales_status2 = where_sales_status2 + " and location_id='" + lo.getId() + "' ";
                   
                    where_disbursements = where_disbursements + " and location_id='" + lo.getId() + "' ";
                    where_sales2 = where_sales2 + " and location_id='" + lo.getId() + "' ";
                    where_sales3 = where_sales3 + " and location_id='" + lo.getId() + "' ";
                }

                if (jCheckBox3.isSelected() && !jCheckBox2.isSelected()) {
                    where_drawer = where_drawer + " and branch_id='" + br.getId() + "' ";
                    where_sales = where_sales + " and branch_id='" + br.getId() + "' ";
                    where_sales_status = where_sales_status + " and branch_id='" + br.getId() + "' ";
                    where_disbursements = where_disbursements + " and branch_id='" + br.getId() + "' ";
                    where_sales2 = where_sales2 + " and branch_id='" + br.getId() + "' ";
                    where_sales3 = where_sales3 + " and branch_id='" + br.getId() + "' ";
                }
//                System.out.println("where_drawer: " + where_drawer);
                List<CashDrawer.to_cash_drawer> my_drawer = CashDrawer.ret_data(where_drawer);
//                System.out.println("my_drawer: "+my_drawer.size());
//                System.out.println("my_drawer: "+my_drawer.size());
//                System.out.println("where_sales2: " + where_sales2);
//                System.out.println("where_drawer: " + where_drawer);
//                System.out.println("where_disbursements: " + where_disbursements);
                List<MySales.sales> my_sale = MySales.ret_data(where_sales2);
                List<S1_accounts_receivable_payments.to_accounts_receivable_payments> my_collections = S1_accounts_receivable_payments.ret_data2(where_sales3);
                List<Prepaid_payments.to_prepaid_payments> my_prepayment = Prepaid_payments.ret_data(where_sales);
                List<Return_from_customer_items.to_return_from_customer_items> return_from_customer = Return_from_customer_items.ret_data(where_sales_status2);
//                System.out.println(where_sales_status);
                List<Srpt_end_of_day_summary_details.field> my_details = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_checks = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_credit_cards = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_gcs = new ArrayList();
                List<Srpt_end_of_day_summary_details.field> my_remittances = new ArrayList();
                List<CashDrawer_remittances.to_cash_drawer_remittances> remittances = CashDrawer_remittances.ret_data(where_sales);
                List<S1_disbursements.to_disbursements> disbursements = S1_disbursements.ret_data(where_disbursements);
                List<Srpt_end_of_day_summary_details.field> my_disbursements = new ArrayList();
                List<Item_replacements.to_item_replacements> replacements = Item_replacements.ret_data(where_sales);
//                System.out.println("where_sales: "+where_sales);
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
                double prepaid_sales = 0;
                double online_sales = 0;
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
                    if (sale.prepaid_amount > 0) {
                        prepaid_sales += sale.prepaid_amount;
                    }
                    if (sale.online_amount > 0) {
                        online_sales += sale.online_amount;
                    }
                }
                cash_sales = cash_sales - (prepaid_sales + online_sales);
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
                double refund = 0;
                double refund_cheque = 0;
                for (Prepaid_payments.to_prepaid_payments prepayment : my_prepayment) {

                    if (prepayment.refund == 1) {
                        if (prepayment.check_amount > 0) {
                            refund_cheque += prepayment.check_amount;
                        } else {
                            refund += prepayment.cash;
                        }
                    } else {

                        if (prepayment.check_amount > 0) {
                            Srpt_end_of_day_summary_details.field check = new Srpt_end_of_day_summary_details.field("Checks", prepayment.check_bank, "", FitIn.fmt_wc_0(prepayment.check_amount));
                            my_checks.add(check);

                            check_prepayments += prepayment.check_amount;
                        } else {
                            cc_total += prepayment.cash;
                            prepayments += prepayment.cash;
                        }
                    }
                }

                for (Return_from_customer_items.to_return_from_customer_items rfc : return_from_customer) {
                    if (rfc.status == 1) {
                        refund -= (rfc.cash);
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
                String pool_db = System.getProperty("pool_db", "db_smis");
                if (pool_db.contains("db_smis_dumaguete_refreshments")) {
                    receipt_net_total = receipts_sub_total;
                }
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

                String d_from = DateType.sf.format(jDateChooser1.getDate());
                String d_to = DateType.sf.format(jDateChooser2.getDate());

                String where = " where Date(date_added) between '" + d_from + "' and '" + d_to + "' ";
                double cc_last_remittance = 0;
                if (!jCheckBox2.isSelected() && !jCheckBox3.isSelected()) {
                    where = where + " and location_id='" + lo.getId() + "'";
                }
                if (jCheckBox2.isSelected() && !jCheckBox3.isSelected()) {
                    where = where + " and branch_id='" + br.getId() + "'";
                }

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
                String home = System.getProperty("user.home");
                String SUBREPORT_DIR = home + "\\retail_res\\rpt2\\";
                String business_name = System.getProperty("business_name", "");
                String address = System.getProperty("address", "");
                String os_name = System.getProperty("os.name");
                if (os_name.equalsIgnoreCase("Linux")) {

                    SUBREPORT_DIR = home + "/retail_res/rpt2/";
                }

                String date = DateType.slash.format(jDateChooser1.getDate()) + " - " + DateType.slash.format(jDateChooser2.getDate());
                if (jCheckBox4.isSelected()) {
                    date = "All";
                }
                double disburs = 0;
                for (S1_disbursements.to_disbursements disburse : disbursements) {

                    Srpt_end_of_day_summary_details.field disbursement = new Srpt_end_of_day_summary_details.field("Disbursement", disburse.category_name + " : " + disburse.purpose, "", FitIn.fmt_wc_0(disburse.amount));
                    my_disbursements.add(disbursement);
                    disburs += disburse.amount;
                    System.out.println("disburs: " + disburse.amount);
                }
                my_details.addAll(my_disbursements);
                receipt_net_total = receipt_net_total - disburs;
                String cashier = tf_cashier.getText();
                if (jCheckBox1.isSelected()) {
                    cashier = "All";
                }
                String branch = jTextField2.getText();
                String location = jTextField1.getText();
                if (jCheckBox3.isSelected()) {
                    location = "All";
                }
                if (jCheckBox2.isSelected()) {
                    branch = "All";
                    location = "All";
                }
                String status = "[Equal]";
                double status_amount = cc_total - receipt_net_total - refund;
                if (status_amount < 0) {
                    status = "[Short]";
                }
                if (status_amount > 0) {
                    status = "[Over]";
                }

                double return_exchange = 0;
                double na_short = 0;
                double over = 0;
                double re_check = 0;
                double re_credit_card = 0;
                double re_prepaid = 0;
                double re_charge = 0;
                double re_gc = 0;
                double re_online = 0;
                double salary_deduction = 0;
                for (Item_replacements.to_item_replacements rep : replacements) {
                    double amount =(rep.replacement_amount - rep.amount_due) - rep.discount;
                    double due = rep.amount_due;
                     double total = (rep.replacement_amount - rep.amount_due) - rep.discount;
                    if (amount < rep.amount_due) {
                        na_short += amount - rep.amount_due;
                    }
                    if (amount > rep.amount_due) {
                        over += amount - rep.amount_due;
                    }
                    return_exchange += total;
                    re_check += rep.check_amount;
                    re_credit_card += rep.credit_card_amount;
                    re_prepaid += rep.prepaid_amount;
                    re_charge += rep.charge_amount;
                    re_gc += rep.gc_amount;
                    re_online += rep.online_amount;
                }

                return_exchange = return_exchange - (re_check + re_credit_card + re_prepaid + re_charge + re_gc + re_online);

                receipts_total = receipts_total + return_exchange;
                receipts_total = receipts_total + refund;

                receipts_sub_total = receipts_sub_total + return_exchange + refund;
                receipt_net_total = receipt_net_total + return_exchange + refund;

                total_check_payments = total_check_payments - refund_cheque;
                Srpt_end_of_day_summary rpt = new Srpt_end_of_day_summary(cashin_beg, cash_sales, collections, prepayments, receipts_total, receipts_line_discount,
                                                                          receipts_sale_discount, receipts_sub_total, receipt_net_total, bills_thousand, bills_five_hundred, bills_two_hundred,
                                                                          bills_one_hundred, bills_fifty, bills_twenty, coins_ten, coins_five, coins_one, coins_point_fifty, coins_point_twenty_five,
                                                                          coins_point_ten, coins_point_zero_five, count_bills_thousand, count_bills_five_hundred,
                                                                          count_bills_two_hundred, count_bills_one_hundred, count_bills_fifty, count_bills_twenty, count_coins_ten,
                                                                          count_coins_five, count_coins_one, count_coins_point_fifty, count_coins_point_twenty_five,
                                                                          count_coins_point_ten, count_coins_point_zero_five, cc_total, cc_last_remittance, cc_cashin_end, SUBREPORT_DIR,
                                                                          my_details, check_cash_sales, check_collections, check_prepayments, cc_cash_sales, cc_collections, cc_prepayments,
                                                                          total_check_payments, total_cc_payments, date, business_name, address,
                                                                          disburs, cashier, branch, location, status, status_amount, return_exchange, refund, refund_cheque, time);
                String jrxml = "rpt_end_of_day_summary.jrxml";

                if (pool_db.contains("db_smis_dumaguete_refreshments")) {
                    jrxml = "rpt_end_of_day_summary_refreshments.jrxml";
                }
                report_sales_items(rpt, jrxml);
                InputStream is = Srpt_sales_summary.class.getResourceAsStream(jrxml);
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

        Window p = (Window) this;
        Dlg_last_remittance nd = Dlg_last_remittance.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_last_remittance.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_last_remittance.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" sales summary per cashier ">
    private void init_report_sales_summary_per_cashier() {
        Button.Search search = (Button.Search) jButton4;
        search.load();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                Field.Combo br = (Field.Combo) jTextField3;
                Field.Combo lo = (Field.Combo) jTextField4;
                Field.Combo f = (Field.Combo) tf_cashier1;
                String date_from = DateType.sf.format(jDateChooser3.getDate());
                String date_to = DateType.sf.format(jDateChooser4.getDate());
                String where = " where session_no like '%" + "" + "%' ";
                if (!jCheckBox8.isSelected()) {
                    where = where + " and Date(time_in) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox5.isSelected()) {
                    where = where + " and user_id='" + f.getId() + "' ";
                }
                if (!jCheckBox7.isSelected() && !jCheckBox6.isSelected()) {
                    where = where + " and location_id='" + lo.getId() + "' ";
                }
                if (jCheckBox6.isSelected()) {
                    where = where + " and branch_id='" + br.getId() + "' ";
                }
                System.out.println(where);
                List<Srpt_sales_summary_per_cashier.field> fields = Srpt_sales_summary_per_cashier.ret_sales_summary_per_cashier(where);

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");
                String date = DateType.slash.format(jDateChooser3.getDate()) + " - " + DateType.slash.format(jDateChooser4.getDate());
                String branch = jTextField3.getText();
                String location = jTextField4.getText();
                if (jCheckBox7.isSelected() && !jCheckBox6.isSelected()) {
                    location = "All";
                }
                if (jCheckBox6.isSelected()) {
                    branch = "All";
                    location = "All";
                }
                String printed_by = MyUser.getUser_screen_name();
                String cashier = tf_cashier1.getText();
                if (jCheckBox5.isSelected()) {
                    cashier = "All";
                }
                Srpt_sales_summary_per_cashier rpt = new Srpt_sales_summary_per_cashier(business_name, address, date, branch, location, printed_by, cashier);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_sales_summary_per_cashier.jrxml";
                String pool_db = System.getProperty("pool_db", "db_smis");
                if (pool_db.equalsIgnoreCase("db_smis_cebu_chickaloka")) {
                    jrxml = "rpt_sales_summary_per_cashier_chickaloka.jrxml";
                }
                report_sales_ledger_per_cashier(rpt, jrxml);
                InputStream is = Srpt_sales_summary_per_cashier.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint2 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                                                setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                Button.Search search = (Button.Search) jButton4;
                search.finish();
            }
        });
        t.start();

    }

    private void report_sales_ledger_per_cashier(final Srpt_sales_summary_per_cashier to, String jrxml_name) {
        pnl_report1.removeAll();
        pnl_report1.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_expenses(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report1.add(viewer);
            pnl_report1.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_expenses(Srpt_sales_summary_per_cashier to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_cashier(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_cashier(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_summary_per_cashier.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint2 = null;

    private void print2() {
        try {
            if (jasperPrint2 != null) {
                JasperPrintManager.printReport(jasperPrint2, false);
            }

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    //</editor-fold>
    private void init_report_sales_summary_chickaloka() {
        Button.Search search = (Button.Search) jButton6;
        search.load();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                Field.Combo br = (Field.Combo) jTextField5;
                Field.Combo lo = (Field.Combo) jTextField6;
                Field.Combo f = (Field.Combo) tf_cashier2;
                String date_from = DateType.sf.format(jDateChooser5.getDate());

                String where = " where user_screen_name like '%" + "" + "%' ";
                if (!jCheckBox12.isSelected()) {
                    where = where + " and Date(date_added) = '" + date_from + "'  ";
                }
                if (!jCheckBox9.isSelected()) {
                    where = where + " and user_id='" + f.getId() + "' ";
                }
                if (!jCheckBox10.isSelected() && !jCheckBox6.isSelected()) {
                    where = where + " and location_id='" + lo.getId() + "' ";
                }
                if (jCheckBox11.isSelected()) {
                    where = where + " and branch_code='" + br.getId() + "' ";
                }

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");
                String date = DateType.slash.format(jDateChooser5.getDate());
                String branch = jTextField5.getText();
                String location = jTextField6.getText();
                if (jCheckBox11.isSelected() && !jCheckBox10.isSelected()) {
                    location = "All";
                }
                if (jCheckBox10.isSelected()) {
                    branch = "All";
                    location = "All";
                }
                String printed_by = MyUser.getUser_screen_name();
                String cashier = tf_cashier2.getText();
                if (jCheckBox9.isSelected()) {
                    cashier = "All";
                }
                double beggining_cash = 0;
                double cash_sales = 0;
                double operation_expenses = 0;
                double net_sales = 0;
                double cc_1000 = 0;
                double cc_500 = 0;
                double cc_200 = 0;
                double cc_100 = 0;
                double cc_50 = 0;
                double cc_20 = 0;
                double cc_10 = 0;
                double cc_5 = 0;
                double cc_1 = 0;
                double cc_point_50 = 0;
                double cc_point_25 = 0;
                double cc_point_10 = 0;
                double cc_point_05 = 0;
                double cc_total = 0;
                double cash_remitted = 0;
                double overage_shortage = 0;
                double cash_in_next_day = 0;
                double cash_for_deposit = 0;
//                System.out.println(where);

                String year = DateType.y.format(jDateChooser5.getDate());
                int month = (FitIn.toInt(DateType.m1.format(jDateChooser5.getDate())) + 1);

                boolean is_month_selected = true;
                Date d = jDateChooser5.getDate();

                int days = -1;
                Date beggining_date = new Date();

                Date dt = jDateChooser5.getDate();
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                c.add(Calendar.DATE, -1);
                dt = c.getTime();
                beggining_date = dt;

                List<Srpt_end_of_day_summary_chickaloka.field> fields2 = Srpt_end_of_day_summary_chickaloka.ret_data_group_by_code(where, year, month, is_month_selected, d, beggining_date);

                String where_drawer = " where id<>0 ";
                String where_sales2 = " where id<>0 "
                        + "  and status='" + "0" + "' ";
                String where_disbursements = " where id<>0 ";

                if (!jCheckBox9.isSelected()) {
                    where_drawer = " where id<>0 "
                            + "  and user_id='" + f.getId() + "'";
                    where_sales2 = " where id<>0 "
                            + "  and user_id='" + f.getId() + "' and status='" + "0" + "' ";
                    where_disbursements = " where id<>0 "
                            + "  and user_id='" + f.getId() + "'";

                }
                if (!jCheckBox12.isSelected()) {
                    where_drawer = where_drawer + "  and Date(time_in) = '" + date_from + "'  ";
                    where_sales2 = where_sales2 + " and Date(date_added) = '" + date_from + "'  ";
                    where_disbursements = where_disbursements + " and Date(disbursement_date) = '" + date_from + "'  ";
                }
                if (!jCheckBox10.isSelected() && !jCheckBox11.isSelected()) {
                    where_drawer = where_drawer + " and location_id='" + lo.getId() + "' ";
                    where_sales2 = where_sales2 + " and location_id='" + lo.getId() + "' ";
                    where_disbursements = where_disbursements + " and location_id='" + lo.getId() + "' ";
                }
                if (jCheckBox11.isSelected() && !jCheckBox11.isSelected()) {
                    where_drawer = where_drawer + " and branch_id='" + br.getId() + "' ";
                    where_sales2 = where_sales2 + " and branch_id='" + br.getId() + "' ";
                    where_disbursements = where_disbursements + " and branch_id='" + br.getId() + "' ";
                }

                List<CashDrawer.to_cash_drawer> my_drawer = CashDrawer.ret_data(where_drawer);
                List<MySales.sales> my_sale = MySales.ret_data(where_sales2);
                List<S1_disbursements.to_disbursements> disbursements = S1_disbursements.ret_data(where_disbursements);

                for (MySales.sales sale : my_sale) {
                    cash_sales += (sale.amount_due);
                }
                for (CashDrawer.to_cash_drawer drawer : my_drawer) {
                    beggining_cash += drawer.amount;
                    cc_1000 += drawer.thousand;
                    cc_500 += drawer.five_hundred;
                    cc_200 += drawer.two_hundred;
                    cc_100 += drawer.one_hundred;
                    cc_50 += drawer.fifty;
                    cc_20 += drawer.twenty;
                    cc_10 += drawer.ten;
                    cc_5 += drawer.five;
                    cc_1 += drawer.one;
                    cc_point_50 += drawer.point_five;
                    cc_point_25 += drawer.point_two_five;
                    cc_point_10 += drawer.point_ten;
                    cc_point_05 += drawer.point_zero_five;
                }
                for (S1_disbursements.to_disbursements disburse : disbursements) {
                    operation_expenses += disburse.amount;
                }

                cash_remitted = (cc_1000 * 1000) + (cc_500 * 500) + (cc_200 * 200) + (cc_100 * 100) + (cc_50 * 50)
                        + (cc_20 * 20) + (cc_10 * 10) + (cc_5 * 5) + (cc_1 * 1) + (cc_point_50 * .5) + (cc_point_25 * .25)
                        + (cc_point_10 * .10) + (cc_point_05 * .05);

                net_sales = (cash_sales + beggining_cash) - operation_expenses;

                overage_shortage = cash_remitted - net_sales;

                double cc_last_remittance = 0;
                final List<S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances> datas = S1_cash_drawer_last_remittances.ret_data(where);
                for (S1_cash_drawer_last_remittances.to_cash_drawer_last_remittances remit : datas) {
                    cc_last_remittance += remit.amount;
                }
                cash_in_next_day = cash_remitted - cc_last_remittance;
                cash_for_deposit = cc_last_remittance;

                Srpt_end_of_day_summary_chickaloka rpt = new Srpt_end_of_day_summary_chickaloka(business_name, address, date, branch, location, cashier, beggining_cash, cash_sales, operation_expenses, net_sales, cc_1000, cc_500, cc_200, cc_100, cc_50, cc_20, cc_10, cc_5, cc_1, cc_point_50, cc_point_25, cc_point_10, cc_point_05, cc_total, cash_remitted, overage_shortage, cash_in_next_day, cash_for_deposit);
                rpt.fields.addAll(fields2);
                String jrxml = "rpt_end_of_day_summary_chickaloka.jrxml";
                report_sales_ledger_chickaloka(rpt, jrxml);
                loadData_chickaloka(rpt.fields);
                InputStream is = Srpt_sales_summary_per_cashier.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint2 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                                                setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                Button.Search search = (Button.Search) jButton6;
                search.finish();
            }
        });
        t.start();
    }

    private void report_sales_ledger_chickaloka(final Srpt_end_of_day_summary_chickaloka to, String jrxml_name) {
        pnl_report2.removeAll();
        pnl_report2.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_expenses(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report2.add(viewer);
            pnl_report2.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_expenses(Srpt_end_of_day_summary_chickaloka to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_chickaloka(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_chickaloka(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_end_of_day_summary_chickaloka.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint3 = null;

    private void print3() {
        try {
            if (jasperPrint3 != null) {
                JasperPrintManager.printReport(jasperPrint3, false);
            }

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" chickaloka items ">
    private ArrayListModel tbl_chickaloka_items_ALM;
    private TblchickaModel tbl_chickaloka_items_M;

    private void init_tbl_chickaloka_items() {
        tbl_chickaloka_items_ALM = new ArrayListModel();
        tbl_chickaloka_items_M = new TblchickaModel(tbl_chickaloka_items_ALM);
        tbl_chickaloka_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_chickaloka_items.setModel(tbl_chickaloka_items_M);
        tbl_chickaloka_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_chickaloka_items.setRowHeight(25);
        int[] tbl_widths_banks = {60, 100, 0, 60, 50, 60, 50, 60, 60, 60, 50, 50, 60, 50, 50, 60, 70};
        for (int i = 0, n = tbl_widths_banks.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_chickaloka_items, i, tbl_widths_banks[i]);
        }
        Dimension d = tbl_chickaloka_items.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_chickaloka_items.getTableHeader().
                setPreferredSize(d);
        tbl_chickaloka_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_chickaloka_items.setRowHeight(25);
        tbl_chickaloka_items.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_chickaloka_items, 15);
        TableWidthUtilities.setColumnRightRenderer(tbl_chickaloka_items, 16);
    }

    private void loadData_chickaloka(List<Srpt_end_of_day_summary_chickaloka.field> acc) {
        tbl_chickaloka_items_ALM.clear();
        tbl_chickaloka_items_ALM.addAll(acc);
    }

    public static class TblchickaModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Item Code", "Description", "Remarks", "Beg. Inv.", "New In", "Sales Qty", "Dmg", "Left Over", "Other Adj.", "Voucher", "Short", "Over", "Transfer", "PO", "End Inv.", "Price", "Amount"
        };

        public TblchickaModel(ListModel listmodel) {
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
            Srpt_end_of_day_summary_chickaloka.field tt = (Srpt_end_of_day_summary_chickaloka.field) getRow(row);
            DecimalFormat df1 = new DecimalFormat("#,###,##0.0");
            switch (col) {
                case 0:
                    return " " + tt.item_code;
                case 1:
                    return " " + tt.description;
                case 2:
                    return " " + tt.remarks;
                case 3:
                    return " " + df1.format(tt.beg_inv);
                case 4:
                    return " " + df1.format(tt.new_in);
                case 5:
                    return " " + df1.format(tt.sales_qty);
                case 6:
                    return " " + df1.format(tt.damage);
                case 7:
                    return " " + df1.format(tt.left_over);
                case 8:
                    return " " + df1.format(tt.other_adjustment);
                case 9:
                    return " " + df1.format(tt.voucher);
                case 10:
                    return " " + df1.format(tt.shortage);
                case 11:
                    return " " + df1.format(tt.over);
                case 12:
                    return " " + df1.format(tt.transfer);
                case 13:
                    return " " + df1.format(tt.po);
                case 14:
                    return " " + df1.format(tt.end_inv);
                case 15:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                default:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
            }
        }
    }

//</editor-fold>
    private void ret_transactions() {
        String where = " where remarks like '%%' ";

        List<MySales.sales> my_sale = MySales.ret_data(where);

        System.out.println("Sales: " + my_sale.size());
        if (my_sale.size() > 0) {
            jLabel39.setBackground(new Color(255, 153, 0));
        } else {
            jLabel39.setBackground(new Color(153, 153, 153));
        }
        jLabel39.setText(FitIn.fmt_wc(my_sale.size()));

    }

    private void init_cashdrawer(final JTextField tf) {
        String where = " where id<>0 ";
        if (!jCheckBox1.isSelected()) {
            Field.Combo f = (Field.Combo) tf_cashier;
            where = where + " and user_id='" + f.getId() + "' ";
        }
        if (!jCheckBox4.isSelected()) {
            String date_from = DateType.sf.format(jDateChooser1.getDate());
            String date_to = DateType.sf.format(jDateChooser2.getDate());
            where = where + " and Date(time_in) between '" + date_from + "' and '" + date_to + " '";
        }

        final List<S1_cash_drawer.to_cash_drawer> drawers = S1_cash_drawer.ret_where(where);

        Object[][] obj = new Object[drawers.size()][4];
        int i = 0;
        for (S1_cash_drawer.to_cash_drawer to : drawers) {

            obj[i][0] = " " + to.user_screen_name;
            obj[i][1] = " " + DateType.convert_slash_datetime3(to.time_in);
            String time_out = "";
            obj[i][2] = " ";
            if (to.time_out != null) {
                obj[i][2] = " " + DateType.convert_slash_datetime3(to.time_out);
            }

            obj[i][3] = " " + FitIn.fmt_wc_0(to.amount);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {80, 100, 120, 80,};
        int width = 0;
        String[] col_names = {"", "", "", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup2(tf, obj, labels, tbl_widths_customers, col_names, 450);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo f = (Field.Combo) tf_cashier5;
                S1_cash_drawer.to_cash_drawer to = (S1_cash_drawer.to_cash_drawer) drawers.get(data.selected_row);
                String cashin = DateType.convert_slash_datetime3(to.time_in);
                String cashout = "";
                if (to.time_out != null) {
                    cashout = DateType.convert_slash_datetime3(to.time_out);
                } else {
                    Alert.set(0, "Choose another record!");
                    return;
                }
                f.setText(cashin + " - " + cashout);
//
//                f.setId("" + to.id);
//                f.setText(to.screen_name);
            }
        });
    }

    private void select_time_type() {
        if (jCheckBox15.isSelected()) {
            tf_cashier5.setEnabled(false);
//            jCheckBox13.setEnabled(true);
            tf_cashier3.setEnabled(true);
            tf_cashier4.setEnabled(true);
        } else {
            tf_cashier5.setEnabled(true);
//            jCheckBox13.setEnabled(false);
            tf_cashier3.setEnabled(false);
            tf_cashier4.setEnabled(false);

        }
    }
}
