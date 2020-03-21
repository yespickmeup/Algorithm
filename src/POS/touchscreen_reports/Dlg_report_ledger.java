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
import POS.cash_drawer.S1_cash_drawer;
import POS.item_replacements.Item_replacements;
import POS.prepaid_payments.Prepaid_payments;
import POS.reports.Dlg_report_items;
import POS.returns.Return_from_customer_items;
import POS.users.MyUser;
import POS.users.S1_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
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
public class Dlg_report_ledger extends javax.swing.JDialog {

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
    private Dlg_report_ledger(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_report_ledger(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_report_ledger() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_report_ledger myRef;

    private void setThisRef(Dlg_report_ledger myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_ledger> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_ledger create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_ledger create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_ledger dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_ledger((java.awt.Frame) parent, false);
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
            Dlg_report_ledger dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_ledger((java.awt.Dialog) parent, false);
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

        Dlg_report_ledger dialog = Dlg_report_ledger.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = ((int) tk.getScreenSize().
//                getWidth());
//        int ySize = ((int) tk.getScreenSize().
//                getHeight());
//        dialog.setSize(xSize, ySize);
//        dialog.setVisible(true);

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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        tf_cashier = new Field.Combo();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jTextField1 = new Field.Combo();
        jButton3 = new Button.Search();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        tf_cashier3 = new Field.Combo();
        jLabel17 = new javax.swing.JLabel();
        tf_cashier4 = new Field.Combo();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        tf_cashier5 = new Field.Combo();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jButton1 = new Button.Warning();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ledger = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnl_report = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnl_cashins = new javax.swing.JPanel();
        pnl_remittances = new javax.swing.JPanel();
        pnl_ar_collections = new javax.swing.JPanel();
        pnl_return_exchange = new javax.swing.JPanel();
        pnl_prepaid_collections = new javax.swing.JPanel();
        pnl_refund = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel5.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Date from:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Date to:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cashier:");

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
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Choose Branch:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Choose Location:");

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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/search19.png"))); // NOI18N
        jButton3.setToolTipText("Search");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setSelected(true);
        jCheckBox9.setText("Counted");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Status:");

        buttonGroup1.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setText("Void");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Time from:");

        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setSelected(true);
        jCheckBox13.setText("All");

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
        jLabel17.setText("Time from:");

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

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("With Items");

        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox15.setText("Manual/Auto");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

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

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Reference no.:");

        buttonGroup2.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("Show/Hide");

        jButton1.setText("Lock Sessions");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jCheckBox15)
                        .addGap(1, 1, 1)
                        .addComponent(tf_cashier5, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCheckBox1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tf_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_cashier3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_cashier4))))))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox9)
                        .addComponent(jCheckBox10)
                        .addComponent(jCheckBox11))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox3))
                            .addGap(1, 1, 1)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox4)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox13)
                                .addComponent(tf_cashier3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_cashier4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox2)))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cashier5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox12)))
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Sales by Transaction");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_ledger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_ledger);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Net Due:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        jTabbedPane1.addTab("Tabular", jPanel3);

        pnl_report.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Print Preview", pnl_report);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("WTax", jPanel2);

        pnl_cashins.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_cashinsLayout = new javax.swing.GroupLayout(pnl_cashins);
        pnl_cashins.setLayout(pnl_cashinsLayout);
        pnl_cashinsLayout.setHorizontalGroup(
            pnl_cashinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        pnl_cashinsLayout.setVerticalGroup(
            pnl_cashinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Cashins", pnl_cashins);

        pnl_remittances.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_remittancesLayout = new javax.swing.GroupLayout(pnl_remittances);
        pnl_remittances.setLayout(pnl_remittancesLayout);
        pnl_remittancesLayout.setHorizontalGroup(
            pnl_remittancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        pnl_remittancesLayout.setVerticalGroup(
            pnl_remittancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Remittances", pnl_remittances);

        pnl_ar_collections.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_ar_collectionsLayout = new javax.swing.GroupLayout(pnl_ar_collections);
        pnl_ar_collections.setLayout(pnl_ar_collectionsLayout);
        pnl_ar_collectionsLayout.setHorizontalGroup(
            pnl_ar_collectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        pnl_ar_collectionsLayout.setVerticalGroup(
            pnl_ar_collectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("AR Collections", pnl_ar_collections);

        pnl_return_exchange.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_return_exchangeLayout = new javax.swing.GroupLayout(pnl_return_exchange);
        pnl_return_exchange.setLayout(pnl_return_exchangeLayout);
        pnl_return_exchangeLayout.setHorizontalGroup(
            pnl_return_exchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        pnl_return_exchangeLayout.setVerticalGroup(
            pnl_return_exchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Return Exchange", pnl_return_exchange);

        pnl_prepaid_collections.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_prepaid_collectionsLayout = new javax.swing.GroupLayout(pnl_prepaid_collections);
        pnl_prepaid_collections.setLayout(pnl_prepaid_collectionsLayout);
        pnl_prepaid_collectionsLayout.setHorizontalGroup(
            pnl_prepaid_collectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        pnl_prepaid_collectionsLayout.setVerticalGroup(
            pnl_prepaid_collectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Prepaid Collections", pnl_prepaid_collections);

        pnl_refund.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_refundLayout = new javax.swing.GroupLayout(pnl_refund);
        pnl_refund.setLayout(pnl_refundLayout);
        pnl_refundLayout.setHorizontalGroup(
            pnl_refundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        pnl_refundLayout.setVerticalGroup(
            pnl_refundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Refund", pnl_refund);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Details", jPanel4);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/close.png"))); // NOI18N
        jLabel1.setToolTipText("Close");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        init_report();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashierActionPerformed
        init_cashier();
    }//GEN-LAST:event_tf_cashierActionPerformed

    private void tf_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashierMouseClicked
        init_cashier();
    }//GEN-LAST:event_tf_cashierMouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked

    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

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

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        select_time_type();
    }//GEN-LAST:event_jCheckBox15ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lock_session();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        disposed();
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel pnl_ar_collections;
    private javax.swing.JPanel pnl_cashins;
    private javax.swing.JPanel pnl_prepaid_collections;
    private javax.swing.JPanel pnl_refund;
    private javax.swing.JPanel pnl_remittances;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JPanel pnl_return_exchange;
    private javax.swing.JTable tbl_ledger;
    private javax.swing.JTextField tf_cashier;
    private javax.swing.JTextField tf_cashier3;
    private javax.swing.JTextField tf_cashier4;
    private javax.swing.JTextField tf_cashier5;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_host", "localhost");
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_store");
        init_key();
        set_default_branch();
        init_tbl_ledger();
        String where = "  order by screen_name asc";
        user_list = MyUser.ret_data2(where);
        branches_list = Branches.ret_where("");

        Field.Combo user = (Field.Combo) tf_cashier;
        user.setText(MyUser.getUser_screen_name());
        user.setId(MyUser.getUser_id());
        time_list = DateType.time();
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

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        Field.Combo lo = (Field.Combo) jTextField1;
        Field.Combo br = (Field.Combo) jTextField2;
        lo.setText(to.location);
        lo.setId("" + to.id);
        br.setText(to.branch);
        br.setId("" + to.branch_id);
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches() {
        final Field.Combo br = (Field.Combo) jTextField2;

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
        Object[][] obj = new Object[branch_location_list.size()][1];
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
        TableRenderer.setPopup(lo, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText("" + to.location);
                lo.setId("" + to.id);
                Field.Combo branch = (Field.Combo) jTextField2;
                branch.setText(to.branch);
                branch.setId("" + to.branch_id);
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

    private void init_report() {
        Button.Search search = (Button.Search) jButton3;
        search.load();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Field.Combo br = (Field.Combo) jTextField2;
                Field.Combo lo = (Field.Combo) jTextField1;
                Field.Combo f = (Field.Combo) tf_cashier;
                String date_from = DateType.sf.format(jDateChooser3.getDate());
                String date_from_sales = DateType.sf.format(jDateChooser3.getDate());
                String date_to = DateType.sf.format(jDateChooser2.getDate());
                String date_to_sales = DateType.sf.format(jDateChooser2.getDate());
                String time = "All";
                if (jCheckBox15.isSelected()) {
                    if (jCheckBox13.isSelected()) {
                        date_from_sales = date_from_sales + " 00:00:00";
                        date_to_sales = date_to_sales + " 23:59:59";
                    } else {
                        String dfs_time = DateType.convert_am_pm_to_stamp(tf_cashier3.getText(), "from");
                        String dts_time = DateType.convert_am_pm_to_stamp(tf_cashier4.getText(), "to");
                        date_from_sales = date_from_sales + " " + dfs_time;
                        date_to_sales = date_to_sales + " " + dts_time;
                        time = tf_cashier3.getText() + " - " + tf_cashier4.getText();
                    }
                } else {

                    if (tf_cashier5.getText().isEmpty() && !jCheckBox13.isSelected()) {
                        Alert.set(0, "Please select time!");
                        return;
                    }

                    if (!jCheckBox13.isSelected()) {
                        try {
                            String[] dates = tf_cashier5.getText().split("- ");
                            Date d1 = DateType.slash_w_time.parse(dates[0]);
                            Date d2 = DateType.slash_w_time.parse(dates[1]);
                            date_from_sales = DateType.convert_slash_datetime_sf2(dates[0]);
                            date_to_sales = DateType.convert_slash_datetime_sf2(dates[1]);

                        } catch (ParseException ex) {
                            Logger.getLogger(Dlg_report_sales_summary.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        date_from_sales = date_from_sales + " 00:00:00";
                        date_to_sales = date_to_sales + " 23:59:59";
                    }

                }

                int status = 0;
                String where_sales2 = " where id<>0 "
                        + "  and status='" + "0" + "' ";
                String where_sales = " where id<>0 ";
                String where_sales_status = " where id<>0 and status=1 ";

                String where_return_from_customer = " where id<>0 and status=1 ";
                String where_sales3 = " where id<>0 and status=1 ";
                if (jCheckBox10.isSelected()) {
                    status = 1;
                }
                String where = " where remarks like '%" + "" + "%' ";
                if (!jCheckBox1.isSelected()) {
                    List<S1_users.to_users> users = S1_users.ret_where(" where id='" + f.getId() + "' ");
                    String user_name = "";
                    String user_id = "";
                    if (!users.isEmpty()) {
                        S1_users.to_users user = (S1_users.to_users) users.get(0);
                        user_name = user.user_name;
                        user_id = "" + user.id;
                    }
                    where = where + " and user_id='" + f.getId() + "' and status='" + status + "' ";
                    where_sales2 = " where id<>0 "
                            + "  and user_id='" + f.getId() + "' and status='" + "0" + "' ";
                    where_sales = " where id<>0 "
                            + "  and user_id='" + f.getId() + "'";
                    where_sales_status = " where id<>0 "
                            + "  and user_name='" + user_name + "' and status=1 ";
                    where_return_from_customer = " where id<>0 "
                            + "  and session_no='" + user_id + "' and status=1 ";
                    where_sales3 = " where id<>0 "
                            + "  and user_id='" + f.getId() + "' and status=1 ";
                }

                if (!jCheckBox2.isSelected()) {
                    where = where + " and date_added between '" + date_from_sales + "' and '" + date_to_sales + "' ";
                    where_sales2 = where_sales2 + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                    where_sales = where_sales + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                    where_sales_status = where_sales_status + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                    where_return_from_customer = where_return_from_customer + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                    where_sales3 = where_sales3 + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }

                if (jCheckBox1.isSelected()) {
                    where = where + "  "
                            + " and status='" + status + "' ";
                }
                if (!jCheckBox4.isSelected() && !jCheckBox3.isSelected()) {
                    where = where + " and location_id='" + lo.getId() + "' ";
                    where_sales2 = where_sales2 + " and location_id='" + lo.getId() + "' ";
                    where_sales = where_sales + " and location_id='" + lo.getId() + "' ";
                    where_sales_status = where_sales_status + " and location_id='" + lo.getId() + "' ";
                    where_return_from_customer = where_return_from_customer + " and location_id='" + lo.getId() + "' ";
                    where_sales3 = where_sales3 + " and location_id='" + lo.getId() + "' ";
                }
                if (jCheckBox4.isSelected() && !jCheckBox3.isSelected()) {
                    where = where + " and branch_id='" + br.getId() + "' ";
                    where_sales2 = where_sales2 + " and branch_id='" + br.getId() + "' ";
                    where_sales = where_sales + " and branch_id='" + br.getId() + "' ";
                    where_return_from_customer = where_return_from_customer + " and branch_id='" + br.getId() + "' ";
                    where_sales_status = where_sales_status + " and branch_id='" + br.getId() + "' ";
                    where_sales3 = where_sales3 + " and branch_id='" + br.getId() + "' ";
                }
                where = where + " order by id asc ";
//                System.out.println(where);
                List<Srpt_sales_ledger.field> fields = Srpt_sales_ledger.ret_data(where);
                List<Srpt_sales_ledger_with_items.field> fields_items = new ArrayList();

                if (jCheckBox11.isSelected()) {
                    fields_items = Srpt_sales_ledger_with_items.ret_data(where);
                }
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String contact_no = System.getProperty("telephone_number", "");
                String address = System.getProperty("address", "Dumaguete");
                address = address + "\n" + contact_no;
                String date = "Date as of " + DateType.convert_slash_datetime2(date_from) + " - " + DateType.convert_slash_datetime2(date_to);
                String branch = br.getText();
                String location = lo.getText();
                double return_exchange = 0;
                double collections = 0;
                double cash_on_hand = 0;
//                System.out.println("where_sales2: " + where_sales2);
                List<S1_accounts_receivable_payments.to_accounts_receivable_payments> my_collections = S1_accounts_receivable_payments.ret_data2(where_sales2);
                double collections_cheque = 0;
                double collections_cheque_on_hand = 0;
                double ar_collection_prepaid = 0;
                double ar_collections_credit_card = 0;
                double ar_collections_gc = 0;
                double ar_collections_online = 0;
                double retention = 0;
                double business_tax = 0;
                double re_check = 0;
                double re_credit_card = 0;
                double re_prepaid = 0;
                double re_charge = 0;
                double re_gc = 0;
                double re_online = 0;
                double salary_deduction = 0;
                for (S1_accounts_receivable_payments.to_accounts_receivable_payments collection : my_collections) {
                    collections_cheque += collection.check_amount;
                    collections += collection.amount;
                    ar_collection_prepaid += collection.prepaid_amount;
                    ar_collections_credit_card += collection.credit_card_amount;
                    ar_collections_gc += collection.gift_certificate_amount;
                    ar_collections_online += collection.online_amount;
                    retention += collection.retention;
                    business_tax = collection.business_tax;
                    salary_deduction += collection.salary_deduction;
                }
                double na_short = 0;
                double over = 0;
                List<Item_replacements.to_item_replacements> replacements = Item_replacements.ret_data(where_sales3);
                for (Item_replacements.to_item_replacements rep : replacements) {
                    double amount = rep.replacement_amount - rep.discount;
                    double due = rep.amount_due;
                    double total = amount - due;
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

                for (Srpt_sales_ledger.field field : fields) {
                    cash_on_hand += field.cash;
                    collections_cheque_on_hand += field.cheque_amount;
                }

                collections_cheque_on_hand = collections_cheque_on_hand + collections_cheque;
                cash_on_hand = cash_on_hand + collections + return_exchange;
                List<Prepaid_payments.to_prepaid_payments> my_prepayment = Prepaid_payments.ret_data(where_sales);
                List<Return_from_customer_items.to_return_from_customer_items> return_from_customer = Return_from_customer_items.ret_data(where_return_from_customer);

                double collections_prepaid = 0;
                double collections_prepaid_cheque = 0;
                double refund = 0;
                double refund_cheque = 0;
                double collections_prepaid_credit_card = 0;
                for (Prepaid_payments.to_prepaid_payments prepayment : my_prepayment) {
                    if (prepayment.status == 1) {
                        if (prepayment.refund == 1) {
                            if (prepayment.check_amount > 0) {
                                refund_cheque += prepayment.check_amount;
                            } else if (prepayment.credit_card_amount >= 0) {
                                collections_prepaid_credit_card += prepayment.credit_card_amount;
                            } else {
                                refund += prepayment.cash;
                            }
                        } else {

                            if (prepayment.check_amount > 0) {
                                Srpt_end_of_day_summary_details.field check = new Srpt_end_of_day_summary_details.field("Checks", prepayment.check_bank, "", FitIn.fmt_wc_0(prepayment.check_amount));
//                                collections_prepaid_cheque += prepayment.check_amount;
                                if (prepayment.remarks.contains("Prepaid Payment")) {
                                    collections_prepaid_cheque += (prepayment.check_amount * -1);
                                } else {
                                    collections_prepaid_cheque += prepayment.check_amount;
                                }
                            } else if (prepayment.credit_card_amount > 0) {
                                collections_prepaid_credit_card += prepayment.credit_card_amount;
                            } else {

                                if (prepayment.remarks.contains("Prepaid Payment")) {
//                                    collections_prepaid += (prepayment.cash * -1);
                                } else {
                                    collections_prepaid += prepayment.cash;
                                }
                            }
                        }
                    }
                }
                double refund_prepaid = 0;
                double refund_charge = 0;
                for (Return_from_customer_items.to_return_from_customer_items rfc : return_from_customer) {
                    if (rfc.status == 1) {
                        refund -= (rfc.cash);
                        refund_prepaid -= rfc.prepaid_amount;
                        refund_charge -= rfc.charge_amount;
                    }
                }

                cash_on_hand = cash_on_hand + collections_prepaid + refund;
                collections_cheque_on_hand = collections_cheque_on_hand + collections_prepaid_cheque - refund_cheque;

                //<editor-fold defaultstate="collapsed" desc=" wtax ">
                List<Srpt_sales_ledger_wtax.field> field_wtax = new ArrayList();
                for (Srpt_sales_ledger.field wt : fields) {
                    if (wt.wtax > 0) {
                        String sales_no = wt.sales_no;
                        String or_no = wt.or_no;
                        String si_no = wt.si_no;
                        String cr_no = wt.or_no;
                        String date2 = wt.date;
                        String user = wt.user_screen_name;
                        String customer_name = wt.customer_name;
                        String charge_reference_no = wt.charge_reference_no;
                        double gross_amount = wt.balance_due;
                        double amount_due = wt.amount_due;
                        double wtax = wt.wtax;
                        double charge_amount = wt.charge_amount;
                        double check_amount = wt.cheque_amount;
                        Srpt_sales_ledger_wtax.field f_wtax = new Srpt_sales_ledger_wtax.field(sales_no, or_no, si_no, cr_no, date, user, customer_name, charge_reference_no, gross_amount, amount_due, wtax, charge_amount, check_amount);
                        field_wtax.add(f_wtax);
                    }
                }

                Srpt_sales_ledger_wtax tax = new Srpt_sales_ledger_wtax(business_name, address, contact_no, date, branch, location);
                tax.fields.addAll(field_wtax);
                //</editor-fold>
                if (!jCheckBox11.isSelected()) {
                    Srpt_sales_ledger rpt = new Srpt_sales_ledger(business_name, address, contact_no, date, branch, location, return_exchange, collections, cash_on_hand,
                                                                  collections_cheque, collections_cheque_on_hand, collections_prepaid, collections_prepaid_cheque, refund,
                                                                  refund_cheque, ar_collection_prepaid, ar_collections_credit_card, ar_collections_gc, ar_collections_online,
                                                                  time, retention, business_tax, re_check, re_credit_card, re_prepaid, re_charge, re_gc, re_online, salary_deduction, refund_prepaid, refund_charge,collections_prepaid_credit_card);
                    rpt.fields.addAll(fields);
                    String jrxml = "rpt_sales_ledger.jrxml";
                    String pool_db = System.getProperty("pool_db", "db_smis");
                    if (pool_db.equalsIgnoreCase("db_smis_cebu_chickaloka")) {
                        jrxml = "rpt_sales_ledger_chickaloka.jrxml";
                    }
                    if (jCheckBox12.isSelected()) {
                        jrxml = "rpt_sales_ledger_ref_no.jrxml";
                    }
                    report_sales_items(rpt, jrxml);
                    report_wtax(tax, "rpt_sales_ledger_wtax.jrxml");
                    loadData_banks(rpt.fields);
                    double net = 0;
                    for (Srpt_sales_ledger.field field : rpt.fields) {
                        net += field.balance_due;
                    }
                    jLabel9.setText(FitIn.fmt_wc_0(net));
                    InputStream is = Srpt_sales_summary.class.getResourceAsStream(jrxml);
                    try {
                        JasperReport jasperReport = JasperCompileManager.compileReport(is);
                        jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                                                   setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                    } catch (JRException ex) {
                        Logger.getLogger(Dlg_report_items.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                    Button.Search search = (Button.Search) jButton3;
                    search.finish();
                } else {
                    Srpt_sales_ledger_with_items rpt = new Srpt_sales_ledger_with_items(business_name, address, contact_no, date, branch, location, time);
                    rpt.fields.addAll(fields_items);
                    String jrxml = "rpt_sales_ledger_with_items.jrxml";

                    report_sales_with_items(rpt, jrxml);
                    jTabbedPane1.setSelectedIndex(1);
//                    loadData_banks(rpt.fields);
                    double net = 0;
                    for (Srpt_sales_ledger_with_items.field field : rpt.fields) {
                        net += field.balance_due;
                    }
                    jLabel9.setText(FitIn.fmt_wc_0(net));
                    InputStream is = Srpt_sales_ledger_with_items.class.getResourceAsStream(jrxml);
                    try {
                        JasperReport jasperReport = JasperCompileManager.compileReport(is);
                        jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                                                   setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                    } catch (JRException ex) {
                        Logger.getLogger(Dlg_report_items.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                    Button.Search search = (Button.Search) jButton3;
                    search.finish();

                }
            }
        });
        t.start();

    }

    private void report_sales_items(final Srpt_sales_ledger to, String jrxml_name) {
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

    private void report_sales_with_items(final Srpt_sales_ledger_with_items to, String jrxml_name) {
        pnl_report.removeAll();
        pnl_report.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_with_items(to, jrxml_name);
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

    public static JRViewer get_viewer_expenses(Srpt_sales_ledger to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JRViewer get_viewer_with_items(Srpt_sales_ledger_with_items to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_with_items(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JasperReport compileJasper_with_items(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_ledger_with_items.class.getResourceAsStream(jrxml);
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
            }
        });
    }

    private ArrayListModel tbl_ledger_ALM;
    private TblledgerModel tbl_ledger_M;

    private void init_tbl_ledger() {
        tbl_ledger_ALM = new ArrayListModel();
        tbl_ledger_M = new TblledgerModel(tbl_ledger_ALM);
        tbl_ledger.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_ledger.setModel(tbl_ledger_M);
        tbl_ledger.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_ledger.setRowHeight(25);
        int due = 70;
        int user = 80;
        int charge = 60;
        int credit_card = 60;
        int gc = 60;
        int prepaid = 60;
        int online = 60;
        int amount = 60;
        int cash = 60;
        String pool_db = System.getProperty("pool_db", "db_smis");
        if (pool_db.equalsIgnoreCase("db_smis_cebu_chickaloka")) {

            user = 0;
            charge = 0;
            credit_card = 0;
            gc = 0;
            prepaid = 0;
            cash = 0;
        }
        int[] tbl_widths_banks = {100, 70, 100, 180, user, due, 60, 60, cash, charge, credit_card, gc, prepaid, online, amount};
        for (int i = 0, n = tbl_widths_banks.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_ledger, i, tbl_widths_banks[i]);
        }
        Dimension d = tbl_ledger.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_ledger.getTableHeader().
                setPreferredSize(d);
        tbl_ledger.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_ledger.setRowHeight(25);
        tbl_ledger.setFont(new java.awt.Font("Arial", 0, 11));
//        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 3);
//        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 7);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 8);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 9);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 10);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 11);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 12);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 13);
        TableWidthUtilities.setColumnRightRenderer(tbl_ledger, 14);
    }

    private void loadData_banks(List<Srpt_sales_ledger.field> acc) {
        tbl_ledger_ALM.clear();
        tbl_ledger_ALM.addAll(acc);
    }

    public static class TblledgerModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Date", "Customer", "Location", "User", "Amount Due", "Line Disc.", "Sale Disc.", "Cash", "Charge", "Credit Card", "Gift Cert", "Prepaid", "Online", "Net Due"
        };

        public TblledgerModel(ListModel listmodel) {
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
            Srpt_sales_ledger.field tt = (Srpt_sales_ledger.field) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.sales_no;
                case 1:
                    return " " + tt.date;
                case 2:
                    return " " + tt.customer_name;
                case 3:
                    return " " + tt.location;
                case 4:
                    return " " + tt.user_screen_name;
                case 5:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.line_discount) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.sales_discount) + " ";
                case 8:
                    return FitIn.fmt_wc_0(tt.cash) + " ";
                case 9:
                    return FitIn.fmt_wc_0(tt.charge_amount) + " ";
                case 10:
                    return FitIn.fmt_wc_0(tt.credit_card_amount) + " ";
                case 11:
                    return FitIn.fmt_wc_0(tt.gc_amount) + " ";
                case 12:
                    return FitIn.fmt_wc_0(tt.prepaid_amount) + " ";
                case 13:
                    return FitIn.fmt_wc_0(tt.online_payment) + " ";
                default:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
            }
        }
    }

    private void init_cashdrawer(final JTextField tf) {
        String where = " where id<>0 ";
        if (!jCheckBox1.isSelected()) {
            Field.Combo f = (Field.Combo) tf_cashier;
            where = where + " and user_id='" + f.getId() + "' ";
        }
        if (!jCheckBox4.isSelected()) {
            String date_from = DateType.sf.format(jDateChooser3.getDate());
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
            tf_cashier3.setEnabled(true);
            tf_cashier4.setEnabled(true);
        } else {
            tf_cashier5.setEnabled(true);
            tf_cashier3.setEnabled(false);
            tf_cashier4.setEnabled(false);

        }
    }

    //<editor-fold defaultstate="collapsed" desc=" cashins ">
    //</editor-fold>
    private void lock_session() {
        Window p = (Window) this;
        Dlg_report_ledger_lock_sessions nd = Dlg_report_ledger_lock_sessions.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_report_ledger_lock_sessions.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_ledger_lock_sessions.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" wtax ">
    private void report_wtax(final Srpt_sales_ledger_wtax to, String jrxml_name) {
        jPanel2.removeAll();
        jPanel2.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_wtax(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel2.add(viewer);
            jPanel2.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_wtax(Srpt_sales_ledger_wtax to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_wtax(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_wtax(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_ledger_wtax.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    //</editor-fold>
    
    
}

