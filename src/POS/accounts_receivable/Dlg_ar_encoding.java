/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.accounts_receivable.S1_accounts_receivable.to_accounts_receivable;
import POS.accounts_receivable.S1_accounts_receivable_payments.to_accounts_receivable_payments;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.customers.Dlg_customers;
import POS.customers.Dlg_customers_ar;
import POS.customers.Customers;
import POS.discounts.S1_discounts;
import POS.main.Main;
import POS.terms.S1_terms;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import POS.util.testOfFaith;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Field;

/**
 *
 * @author Maytopacka
 *
 */
public class Dlg_ar_encoding extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_encoding
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
    private Dlg_ar_encoding(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_encoding(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_encoding() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_ar_encoding myRef;

    private void setThisRef(Dlg_ar_encoding myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_encoding> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_encoding create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_encoding create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_encoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_encoding((java.awt.Frame) parent, false);
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
            Dlg_ar_encoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_encoding((java.awt.Dialog) parent, false);
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

        Dlg_ar_encoding dialog = Dlg_ar_encoding.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
//        dialog.setSize(xSize, ySize);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_accounts_receivable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        tf_ar_no = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_term = new SearchField();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tf_ar_month = new SearchField();
        tf_ar_day = new SearchField();
        tf_ar_year = new SearchField();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_balance = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_reference_no = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tf_trust_receipt = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tf_paid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tf_search_customer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        tf_customer_id = new javax.swing.JTextField();
        lbl_credit_limit = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_soa_type = new javax.swing.JTextField();
        tf_soa_type_id = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_remarks = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_accounts_receivable_payments = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        tf_ap_cash = new javax.swing.JTextField();
        btn_new1 = new javax.swing.JLabel();
        btn_add1 = new javax.swing.JLabel();
        btn_edit1 = new javax.swing.JLabel();
        btn_delete1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tf_ap_check_bank = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_ap_check_holder = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tf_ap_check_amount = new javax.swing.JTextField();
        tf_ap_check_no = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        tf_ap_month = new SearchField();
        tf_ap_day = new SearchField();
        tf_ap_year = new SearchField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tf_or_payment_no = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_total_payments = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tf_remarks2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        tf_ap_month1 = new SearchField();
        tf_ap_day1 = new SearchField();
        tf_ap_year1 = new SearchField();
        jLabel28 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_discount_name = new Field.Combo();
        jLabel29 = new javax.swing.JLabel();
        tf_discount_rate = new Field.Input();
        jLabel30 = new javax.swing.JLabel();
        tf_discount_amount = new Field.Input();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_accounts_receivable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_accounts_receivable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_accounts_receivable);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("AR No:");

        tf_ar_no.setText("00000001");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Amount:");

        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Term:");

        tf_term.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_termActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Day/s");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tf_ar_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ar_monthActionPerformed(evt);
            }
        });

        tf_ar_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ar_dayActionPerformed(evt);
            }
        });

        tf_ar_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ar_yearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_ar_month)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ar_day, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_ar_year, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tf_ar_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ar_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ar_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Balance:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Date Applied:");

        lbl_balance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_balance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance.setText("0.00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Balance:");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Reference No:");

        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("T - Receipt:");

        tf_trust_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_trust_receiptActionPerformed(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Paid:");

        tf_paid.setFocusable(false);
        tf_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_paidActionPerformed(evt);
            }
        });

        jLabel3.setText("Filter:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("C.I NO:");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("Trust Receipt");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("All");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_edit.setText("Update");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jButton5.setText("New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(104, 95, 84));
        jPanel2.setOpaque(false);

        tf_search_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search_customerActionPerformed(evt);
            }
        });

        jLabel1.setBackground(java.awt.Color.black);
        jLabel1.setText("Search Customer:");

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name:");

        jLabel6.setBackground(java.awt.Color.black);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Credit Limit:");

        jLabel4.setBackground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID No:");

        tf_customer_name.setFocusable(false);
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        tf_customer_id.setFocusable(false);

        lbl_credit_limit.setFocusable(false);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("+");
        jTextField2.setFocusable(false);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_credit_limit))
                    .addComponent(tf_customer_name)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_search_customer)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_search_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Sales on Account ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Charge Type:");

        tf_soa_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_soa_typeActionPerformed(evt);
            }
        });

        jLabel19.setFocusable(false);

        jLabel7.setText("Remarks:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(202, 202, 202)
                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(187, 187, 187)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(tf_paid)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_remarks))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(tf_ar_no, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_trust_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(tf_term, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(tf_reference_no, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(tf_soa_type)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tf_soa_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ar_no, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_trust_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_soa_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_soa_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_term, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_edit)
                    .addComponent(btn_add)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(4, 4, 4))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_accounts_receivable_payments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_accounts_receivable_payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivable_paymentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_accounts_receivable_payments);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Cash:");

        btn_new1.setBackground(new java.awt.Color(255, 255, 255));
        btn_new1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_new1.setForeground(new java.awt.Color(153, 153, 153));
        btn_new1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_new1.setText("O new");
        btn_new1.setOpaque(true);
        btn_new1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_new1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_new1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_new1MouseExited(evt);
            }
        });

        btn_add1.setBackground(new java.awt.Color(255, 255, 255));
        btn_add1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add1.setForeground(new java.awt.Color(153, 153, 153));
        btn_add1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_add1.setText("+ add");
        btn_add1.setOpaque(true);
        btn_add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add1MouseExited(evt);
            }
        });

        btn_edit1.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_edit1.setForeground(new java.awt.Color(153, 153, 153));
        btn_edit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_edit1.setText("[] update");
        btn_edit1.setOpaque(true);
        btn_edit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_edit1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_edit1MouseExited(evt);
            }
        });

        btn_delete1.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_delete1.setForeground(new java.awt.Color(153, 153, 153));
        btn_delete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_delete1.setText("- delete");
        btn_delete1.setOpaque(true);
        btn_delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delete1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_delete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_delete1MouseExited(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Check Bank:");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Check Holder:");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Check Amount:");

        tf_ap_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_check_noActionPerformed(evt);
            }
        });

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Check No:");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tf_ap_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_monthActionPerformed(evt);
            }
        });

        tf_ap_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_dayActionPerformed(evt);
            }
        });

        tf_ap_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_yearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(tf_ap_month, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_ap_day, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_ap_year))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tf_ap_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ap_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ap_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Date Applied:");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Reference No:");

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_total_payments.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_total_payments);

        jLabel9.setText("Remarks:");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tf_ap_month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_month1ActionPerformed(evt);
            }
        });

        tf_ap_day1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_day1ActionPerformed(evt);
            }
        });

        tf_ap_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_year1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(tf_ap_month1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_ap_day1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_ap_year1))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tf_ap_month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ap_day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ap_year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Cheque Date:");

        jLabel11.setText("Discount:");

        tf_discount_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_discount_nameMouseClicked(evt);
            }
        });
        tf_discount_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discount_nameActionPerformed(evt);
            }
        });

        jLabel29.setText("Rate:");

        tf_discount_rate.setFocusable(false);

        jLabel30.setText("Disc Amount:");

        tf_discount_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discount_amountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_new1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_remarks2)
                            .addComponent(tf_ap_check_no)
                            .addComponent(tf_ap_cash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_ap_check_holder)
                            .addComponent(tf_ap_check_bank)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_or_payment_no)
                            .addComponent(tf_discount_name)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tf_ap_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_discount_amount))
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_or_payment_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_ap_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_holder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_remarks2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_discount_name, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_edit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_new1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
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

    private void tf_termActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_termActionPerformed
        // TODO add your handling code here:
        tf_reference_no.grabFocus();
//        add_accounts_receivable();
    }//GEN-LAST:event_tf_termActionPerformed

    private void btn_new1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_new1MouseClicked

    private void btn_new1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new1MouseEntered
        // TODO add your handling code here:
        hover2(btn_new1);
    }//GEN-LAST:event_btn_new1MouseEntered

    private void btn_new1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new1MouseExited
        // TODO add your handling code here:
        exit2(btn_new1);
    }//GEN-LAST:event_btn_new1MouseExited

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
        add_ar_payment();
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseEntered
        // TODO add your handling code here:
        hover2(btn_add1);
    }//GEN-LAST:event_btn_add1MouseEntered

    private void btn_add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseExited
        // TODO add your handling code here:
        exit2(btn_add1);
    }//GEN-LAST:event_btn_add1MouseExited

    private void btn_edit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MouseClicked
        // TODO add your handling code here:
        edit_accounts_receivable_payments();
    }//GEN-LAST:event_btn_edit1MouseClicked

    private void btn_edit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MouseEntered
        // TODO add your handling code here:
        hover2(btn_edit1);
    }//GEN-LAST:event_btn_edit1MouseEntered

    private void btn_edit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MouseExited
        // TODO add your handling code here:
        exit2(btn_edit1);
    }//GEN-LAST:event_btn_edit1MouseExited

    private void btn_delete1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MouseClicked
        // TODO add your handling code here:
        delete_accounts_receivable_payments();
    }//GEN-LAST:event_btn_delete1MouseClicked

    private void btn_delete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MouseEntered
        // TODO add your handling code here:
        hover2(btn_delete1);
    }//GEN-LAST:event_btn_delete1MouseEntered

    private void btn_delete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MouseExited
        // TODO add your handling code here:
        exit2(btn_delete1);
    }//GEN-LAST:event_btn_delete1MouseExited

    private void tf_search_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search_customerActionPerformed
        init_popup();
    }//GEN-LAST:event_tf_search_customerActionPerformed

    private void tf_ar_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ar_monthActionPerformed
        // TODO add your handling code here:
        tf_ar_day.grabFocus();
    }//GEN-LAST:event_tf_ar_monthActionPerformed

    private void tf_ar_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ar_dayActionPerformed
        tf_ar_year.grabFocus();
    }//GEN-LAST:event_tf_ar_dayActionPerformed

    private void tf_ar_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ar_yearActionPerformed
        tf_amount.grabFocus();
    }//GEN-LAST:event_tf_ar_yearActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        tf_term.grabFocus();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tbl_accounts_receivableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMouseClicked
        select_accounts_receivable();
    }//GEN-LAST:event_tbl_accounts_receivableMouseClicked

    private void tf_ap_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_monthActionPerformed

    private void tf_ap_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_dayActionPerformed
    }//GEN-LAST:event_tf_ap_dayActionPerformed

    private void tf_ap_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_yearActionPerformed

    private void tbl_accounts_receivable_paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivable_paymentsMouseClicked
        // TODO add your handling code here:
        select_accounts_receivable_payments();
    }//GEN-LAST:event_tbl_accounts_receivable_paymentsMouseClicked

    private void tf_ap_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_check_noActionPerformed
        add_ar_payment();
    }//GEN-LAST:event_tf_ap_check_noActionPerformed

    private void tf_trust_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_trust_receiptActionPerformed
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            add_accounts_receivable();
        } else {
            edit_accounts_receivable();
        }
    }//GEN-LAST:event_tf_trust_receiptActionPerformed

    private void tf_reference_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reference_noActionPerformed
        tf_trust_receipt.grabFocus();
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_paidActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        edit_accounts_receivable();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        add_accounts_receivable();
    }//GEN-LAST:event_btn_addActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear_accounts_receivable();
        init_ar_no();
        btn_add.setEnabled(true);
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row >= 0) {
            tbl_accounts_receivable.removeRowSelectionInterval(row, row);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete_accounts_receivable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        soa();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_soa_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_soa_typeActionPerformed
        init_types(tf_soa_type, tf_soa_type_id);
    }//GEN-LAST:event_tf_soa_typeActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_ap_month1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_month1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_month1ActionPerformed

    private void tf_ap_day1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_day1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_day1ActionPerformed

    private void tf_ap_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_year1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        my_customers();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void tf_discount_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_nameMouseClicked
        init_discount();
    }//GEN-LAST:event_tf_discount_nameMouseClicked

    private void tf_discount_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_nameActionPerformed
        init_discount();
    }//GEN-LAST:event_tf_discount_nameActionPerformed

    private void tf_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_amountActionPerformed

    }//GEN-LAST:event_tf_discount_amountActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JLabel btn_add1;
    private javax.swing.JButton btn_delete;
    private javax.swing.JLabel btn_delete1;
    private javax.swing.JButton btn_edit;
    private javax.swing.JLabel btn_edit1;
    private javax.swing.JLabel btn_new1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
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
    private javax.swing.JTextField jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_balance;
    private javax.swing.JTextField lbl_credit_limit;
    private javax.swing.JTable tbl_accounts_receivable;
    private javax.swing.JTable tbl_accounts_receivable_payments;
    private javax.swing.JTable tbl_total_payments;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_ap_cash;
    private javax.swing.JTextField tf_ap_check_amount;
    private javax.swing.JTextField tf_ap_check_bank;
    private javax.swing.JTextField tf_ap_check_holder;
    private javax.swing.JTextField tf_ap_check_no;
    private javax.swing.JTextField tf_ap_day;
    private javax.swing.JTextField tf_ap_day1;
    private javax.swing.JTextField tf_ap_month;
    private javax.swing.JTextField tf_ap_month1;
    private javax.swing.JTextField tf_ap_year;
    private javax.swing.JTextField tf_ap_year1;
    private javax.swing.JTextField tf_ar_day;
    private javax.swing.JTextField tf_ar_month;
    private javax.swing.JLabel tf_ar_no;
    private javax.swing.JTextField tf_ar_year;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_discount_amount;
    private javax.swing.JTextField tf_discount_name;
    private javax.swing.JTextField tf_discount_rate;
    private javax.swing.JTextField tf_or_payment_no;
    private javax.swing.JTextField tf_paid;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_remarks2;
    private javax.swing.JTextField tf_search_customer;
    private javax.swing.JTextField tf_soa_type;
    private javax.swing.JTextField tf_soa_type_id;
    private javax.swing.JTextField tf_term;
    private javax.swing.JTextField tf_trust_receipt;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_algorithm");
        init_key();
        set_default_branch();
        init_tbl_accounts_receivable();
        init_search();
        init_ar_no();
        focus();
        enable_ar(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        init_focus();
        init_tbl_accounts_receivable_payments();
        setEmployeeTableModel();
        jLabel25.setVisible(false);
        tf_trust_receipt.setVisible(false);

    }
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;
    }

    private void focus() {
        JTextField[] tf = {tf_search_customer, tf_ar_month, tf_ar_day, tf_ar_year, tf_amount, tf_term, tf_ap_month, tf_ap_day, tf_ap_year, tf_ap_cash, tf_ap_check_bank, tf_ap_check_holder, tf_ap_check_amount, tf_ap_check_no, tf_reference_no, tf_trust_receipt, tf_paid, jTextField1, tf_soa_type, tf_remarks, tf_remarks2};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_focus() {
        Focus_Fire.nextFocus(tf_ap_month, tf_ap_day);
        Focus_Fire.nextFocus(tf_ap_day, tf_ap_year);
        Focus_Fire.nextFocus(tf_ap_year, tf_ap_cash);
        Focus_Fire.nextFocus(tf_ap_cash, tf_ap_check_bank);
        Focus_Fire.nextFocus(tf_ap_check_bank, tf_ap_check_holder);
        Focus_Fire.nextFocus(tf_ap_check_holder, tf_ap_check_amount);
        Focus_Fire.nextFocus(tf_ap_check_amount, tf_ap_check_no);

    }

    private void init_ar_no() {
        tf_ar_no.setText(S1_accounts_receivable.increment_id(my_branch_id));
    }

    private void enable_ar(boolean stmt) {
        tf_ar_month.setEnabled(stmt);
        tf_ar_day.setEnabled(stmt);
        tf_ar_year.setEnabled(stmt);
        tf_amount.setEnabled(stmt);
        tf_term.setEnabled(stmt);
        btn_delete.setEnabled(stmt);
    }

    private void init_search() {
        testOfFaith.set(tf_ar_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_ar_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_ar_year, DateType.listYear(), "Year");
        testOfFaith.set(tf_term, S1_terms.ret_cb_data(), "TERM");

        testOfFaith.set(tf_ap_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_ap_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_ap_year, DateType.listYear(), "Year");

        testOfFaith.set(tf_ap_month1, DateType.listMonths(), "Month");
        testOfFaith.set(tf_ap_day1, DateType.listDays(), "Day");
        testOfFaith.set(tf_ap_year1, DateType.listYear(), "Year");

        Date d = new Date();
        Date d2 = new Date();

        String month = DateType.m.format(d);
        String day = DateType.d.format(d);
        String year = DateType.y.format(d);
        tf_ap_month.setText(month);
        tf_ap_month1.setText(month);

        tf_ap_day.setText(day);
        tf_ap_day1.setText(day);

        tf_ap_year.setText(year);
        tf_ap_year1.setText(year);

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
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tf_search_customer.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                if (!tbl_accounts_receivable_ALM.isEmpty()) {
                    tbl_accounts_receivable.setRowSelectionInterval(0, 0);
                    tbl_accounts_receivable.grabFocus();
                }
            }
        });

        tbl_accounts_receivable.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    data_cols_ar_payments();
                    tf_ap_month.grabFocus();
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    data_cols_ar_payments();
                    e.consume();
                }
            }
        });

    }
    // </editor-fold>

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        if (lbl.isEnabled()) {
            lbl.setBackground(new java.awt.Color(51, 102, 0));
            lbl.setForeground(new java.awt.Color(0, 0, 0));
        }

    }

    private void exit2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }
    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_popup() {

        String search = tf_search_customer.getText();
        customer_list.clear();
        customer_list = Customers.ret_data(search);
        Object[][] obj = new Object[customer_list.size()][4];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            obj[i][2] = " " + FitIn.fmt_wc_0(to.credit_limit);
            obj[i][3] = " " + FitIn.fmt_wc_0(to.balance);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 100, 0, 100};
        String[] col_names = {"ID", "NAME", "CREDIT LIMIT", "BALANCE"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_search_customer, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_id.setText(to.customer_no);
                tf_customer_name.setText(to.customer_name);
                lbl_credit_limit.setText(FitIn.fmt_wc_0(to.credit_limit));
                lbl_balance.setText(FitIn.fmt_wc_0(to.balance));
                tf_term.setText(FitIn.fmt_woc(to.term));
                tbl_accounts_receivable_payments_ALM.clear();
                tbl_accounts_receivable_payments_M.fireTableDataChanged();
                data_cols();
                enable_ar(true);
                tf_ar_month.grabFocus();
            }
        });
    }

    String customer_address = "";
    int selected_row = 0;
    private ArrayListModel tbl_accounts_receivable_ALM;
    private Tblaccounts_receivableModel tbl_accounts_receivable_M;

    private void init_tbl_accounts_receivable() {
        tbl_accounts_receivable_ALM = new ArrayListModel();
        tbl_accounts_receivable_M = new Tblaccounts_receivableModel(tbl_accounts_receivable_ALM);
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable.setModel(tbl_accounts_receivable_M);
        tbl_accounts_receivable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable.setRowHeight(25);
        int[] tbl_widths_accounts_receivable = {100, 0, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 111 || i == 0 || i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable, i, tbl_widths_accounts_receivable[i]);
        }
        Dimension d = tbl_accounts_receivable.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(d);
        tbl_accounts_receivable.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable.setRowHeight(25);
        tbl_accounts_receivable.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 5);
    }

    private void loadData_accounts_receivable(List<to_accounts_receivable> acc) {
        tbl_accounts_receivable_ALM.clear();
        tbl_accounts_receivable_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference #", "Trust Receipt", "Date", "Term", "Amount", "Balance", "user_name", "amount", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type"
        };

        public Tblaccounts_receivableModel(ListModel listmodel) {
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
            to_accounts_receivable tt = (to_accounts_receivable) getRow(row);
            switch (col) {
                case 0:
                    if (tt.ci_no.isEmpty()) {
                        return tt.trust_receipt;
                    }
                    if (tt.trust_receipt.isEmpty()) {
                        return tt.ci_no;
                    }
                case 1:
                    return " " + tt.trust_receipt;
                case 2:
                    return " " + DateType.convert_dash_date2(tt.date_applied);
                case 3:
                    return " " + FitIn.fmt_woc(tt.term) + " Day/s";
                case 4:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.amount - tt.paid) + " ";
                case 6:
                    return tt.user_name;
                case 7:
                    return tt.amount;
                case 8:
                    return tt.discount_amount;
                case 9:
                    return tt.discount_rate;
                case 10:
                    return tt.discount;
                case 11:
                    return tt.status;
                case 12:
                    return tt.term;
                case 13:
                    return tt.date_applied;
                case 14:
                    return tt.paid;
                case 15:
                    return tt.date_paid;
                case 16:
                    return tt.remarks;
                case 17:
                    return tt.type;
                default:
                    return tt.or_no;
            }
        }
    }

    private void data_cols() {
        String search = tf_customer_id.getText();
        String where = " where customer_id='" + search + "' order by Date(date_applied) asc";
        loadData_accounts_receivable(S1_accounts_receivable.ret_data5(where));
        compute_ar_balance();
    }

    private void data_cols2() {
        String where = "";
        if (jCheckBox1.isSelected() || jCheckBox2.isSelected()) {
            where = " where ci_no like '%" + jTextField1.getText() + "%' and customer_id='" + tf_customer_id.getText() + "' or trust_receipt like '%" + jTextField1.getText() + "%' and customer_id='" + tf_customer_id.getText() + "' ";
        } else {
            where = " where ci_no like '%" + jTextField1.getText() + "%'  or trust_receipt like '%" + jTextField1.getText() + "%'  ";
        }
        loadData_accounts_receivable(S1_accounts_receivable.ret_data3(where));
        compute_ar_balance();
    }

    private void add_accounts_receivable() {
        int id = -1;
        String customer_id = tf_customer_id.getText();
        String customer_name = tf_customer_name.getText();
        String ar_no = S1_accounts_receivable.increment_id(my_branch_id);
        String date_added = DateType.now();
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_amount.getText());
        double discount_amount = 0;// FitIn.toDouble(tf_discount_amount.getText();
        double discount_rate = 0;//FitIn.toDouble(tf_discount_rate.getText();
        String discount = "";//tf_discount.getText();
        int status = 0;// FitIn.toInt(tf_status.getText());
        double term = FitIn.toDouble(tf_term.getText());
        String date_applied = tf_ar_month.getText() + " " + tf_ar_day.getText() + ", " + tf_ar_year.getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = 0;
        String date_paid = date_applied;
        String remarks = tf_remarks.getText();
        String type = "AR";//tf_type.getText();
        String or_no = "";//tf_or_no.getText();
        String ci_no = tf_reference_no.getText();//tf_or_no.getText();
        String trust_receipt = tf_trust_receipt.getText();//tf_or_no.getText();
        String soa_id = "1";
        String soa_type = tf_soa_type.getText();
        String soa_type_id = tf_soa_type_id.getText();
        String reference_no = tf_reference_no.getText();
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        to_accounts_receivable to = new to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
        S1_accounts_receivable.add_accounts_receivable(to);
        data_cols();
        clear_accounts_receivable();
        init_ar_no();
        tf_ar_month.grabFocus();
        Alert.set(1, type);
    }

    private void compute_ar_balance() {
        List<to_accounts_receivable> datas = tbl_accounts_receivable_ALM;
        double total = 0;
        for (to_accounts_receivable to : datas) {
            total += to.amount - to.paid;
        }
        lbl_balance.setText(FitIn.fmt_wc_0(total));
    }

    private void select_accounts_receivable() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));
        tf_customer_id.setText(to.customer_id);
        tf_customer_name.setText(to.customer_name);
        tf_ar_no.setText(to.ar_no);
        tf_amount.setText(FitIn.fmt_wc_0(to.amount));
        tf_term.setText(FitIn.fmt_woc(to.term));
        tf_reference_no.setText(to.ci_no);
        tf_trust_receipt.setText(to.trust_receipt);
        tf_paid.setText(FitIn.fmt_wc_0(to.paid));
        tf_remarks.setText(to.remarks);
        tf_soa_type.setText(to.soa_type);
        tf_soa_type_id.setText(to.soa_type_id);
        Date d = new Date();
        try {
            d = DateType.sf.parse(to.date_applied);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_ar_encoding.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        String month = DateType.m.format(d);
        String day = DateType.d.format(d);
        String year = DateType.y.format(d);
        tf_ar_month.setText(month);
        tf_ar_day.setText(day);
        tf_ar_year.setText(year);
        btn_add.setEnabled(false);
        btn_edit.setEnabled(true);
        btn_delete.setEnabled(true);

        data_cols_ar_payments();

    }

    private void edit_accounts_receivable() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        int id = to.id;
        String customer_id = tf_customer_id.getText();
        String customer_name = tf_customer_name.getText();
        String ar_no = tf_ar_no.getText();
        String date_added = DateType.now();
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_amount.getText());
        double discount_amount = 0;// FitIn.toDouble(tf_discount_amount.getText();
        double discount_rate = 0;//FitIn.toDouble(tf_discount_rate.getText();
        String discount = "";//tf_discount.getText();
        int status = 0;// FitIn.toInt(tf_status.getText());
        double term = FitIn.toDouble(tf_term.getText());
        String date_applied = tf_ar_month.getText() + " " + tf_ar_day.getText() + ", " + tf_ar_year.
                getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = FitIn.toDouble(tf_paid.getText());
        String date_paid = date_applied;
        String remarks = tf_remarks.getText();
        String type = "AR";//tf_type.getText();
        String or_no = "";//tf_or_no.getText();
        String ci_no = tf_reference_no.getText();//tf_or_no.getText();
        String trust_receipt = tf_trust_receipt.getText();//tf_or_no.getText();
        String soa_id = "0";
        String soa_type = tf_soa_type.getText();
        String soa_type_id = tf_soa_type_id.getText();
        String reference_no = tf_reference_no.getText();
        String user_id = to.user_id;
        String user_screen_name = to.user_screen_name;
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        to_accounts_receivable to1 = new to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
        S1_accounts_receivable.edit_accounts_receivable(to1, to.amount, to1.paid);
        data_cols();
        tbl_accounts_receivable.setRowSelectionInterval(row, row);
        data_cols_ar_payments();
        clear_accounts_receivable();
        Alert.set(2, "");

    }

    private void clear_accounts_receivable() {
        tf_paid.setText("");
        tf_amount.setText("");
        tf_term.setText("");
        tf_reference_no.setText("");
        tf_trust_receipt.setText("");

        tf_ar_month.setText("");
        tf_ar_day.setText("");
        tf_ar_year.setText("");

    }

    private void delete_accounts_receivable() {
        String where = " where user_name='" + Users.user_name + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        int exists = 0;
        for (S1_user_previleges.to_user_previleges to : datas) {
            if (to.previledge.equalsIgnoreCase("Delete AR Transaction")) {
                exists = 1;
                break;
            }
        }
        if (exists == 1) {

            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    int row = tbl_accounts_receivable.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                            get(tbl_accounts_receivable.convertRowIndexToModel(row));
                    S1_accounts_receivable.delete_accounts_receivable(to);

                    data_cols();
                    tbl_accounts_receivable_payments_ALM.clear();
                    tbl_accounts_receivable_payments_M.fireTableDataChanged();
                    setEmployeeTableModel();
                    clear_accounts_receivable();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            Alert.set(0, "No privilege to delete transaction!");
        }

    }
    private ArrayListModel tbl_accounts_receivable_payments_ALM;
    private Tblaccounts_receivable_paymentsModel tbl_accounts_receivable_payments_M;

    private void init_tbl_accounts_receivable_payments() {
        tbl_accounts_receivable_payments_ALM = new ArrayListModel();
        tbl_accounts_receivable_payments_M = new Tblaccounts_receivable_paymentsModel(tbl_accounts_receivable_payments_ALM);
        tbl_accounts_receivable_payments.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable_payments.setModel(tbl_accounts_receivable_payments_M);
        tbl_accounts_receivable_payments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable_payments.setRowHeight(25);
        int[] tbl_widths_accounts_receivable_payments = {100, 100, 80, 80, 80, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable_payments.length; i < n; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable_payments, i, tbl_widths_accounts_receivable_payments[i]);
        }
        Dimension d = tbl_accounts_receivable_payments.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_accounts_receivable_payments.getTableHeader().
                setPreferredSize(d);
        tbl_accounts_receivable_payments.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable_payments.setRowHeight(25);
        tbl_accounts_receivable_payments.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 4);
    }

    private void loadData_accounts_receivable_payments(List<to_accounts_receivable_payments> acc) {
        tbl_accounts_receivable_payments_ALM.clear();
        tbl_accounts_receivable_payments_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivable_paymentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "OR #", "Check", "Cash", "Discount", "", "amount", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type", "or_no", "prev_balance"
        };

        public Tblaccounts_receivable_paymentsModel(ListModel listmodel) {
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
            to_accounts_receivable_payments tt = (to_accounts_receivable_payments) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_dash_date2(tt.date_applied);
                case 1:
                    return " " + tt.or_payment_no;
                case 2:
                    return FitIn.fmt_wc_0(tt.check_amount) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 5:
                    if (tt.status == 0) {
                        return " Finalized";
                    } else {
                        return " ---";
                    }
                case 6:
                    return tt.amount;
                case 7:
                    return tt.discount_amount;
                case 8:
                    return tt.discount_rate;
                case 9:
                    return tt.discount;
                case 10:
                    return tt.status;
                case 11:
                    return tt.term;
                case 12:
                    return tt.date_applied;
                case 13:
                    return tt.paid;
                case 14:
                    return tt.date_paid;
                case 15:
                    return tt.remarks;
                case 16:
                    return tt.type;
                case 17:
                    return tt.or_no;
                default:
                    return tt.prev_balance;
            }
        }
    }

    private void data_cols_ar_payments() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        loadData_accounts_receivable_payments(S1_accounts_receivable_payments.ret_data(to.ar_no));

        setEmployeeTableModel();
    }

    private void add_ar_payment() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));
        String customer_id = to.customer_id;
        String customer_name = to.customer_name;
        String ar_no = to.ar_no;
        String date_added = DateType.datetime.format(new Date());
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_ap_cash.getText());
        double discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        double discount_rate = FitIn.toDouble(tf_discount_rate.getText());
        String discount = tf_discount_name.getText();
        int status = 0;
        double term = 0;
        String date_applied = tf_ap_month.getText() + " " + tf_ap_day.getText() + ", " + tf_ap_year.
                getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = 0;
        String date_paid = DateType.sf.format(new Date());
        String remarks = tf_remarks2.getText();
        String type = "CASH";
        String or_no = to.or_no;
        double prev_balance = 0;
        double check_amount = FitIn.toDouble(tf_ap_check_amount.getText());
        String check_holder = tf_ap_check_holder.getText();
        String check_bank = tf_ap_check_bank.getText();
        String check_no = tf_ap_check_no.getText();
        String ci_no = to.ci_no;//tf_or_no.getText();
        String trust_receipt = to.trust_receipt;//tf_or_no.getText();
        String or_payment_no = tf_or_payment_no.getText();
        String soa_id = to.soa_id;
        String soa_type = to.soa_type;
        String soa_type_id = to.soa_type_id;
        String reference_no = to.reference_no;
        String check_date = tf_ap_month1.getText() + " " + tf_ap_day1.getText() + ", " + tf_ap_year1.getText();
        check_date = DateType.mDate_to_Date(check_date);
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        double tax_rate = 0;
        double tax_amount = 0;

        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id, soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location, location_id);
        S1_accounts_receivable_payments.add_accounts_receivable_payments(to1);
        int row1 = tbl_accounts_receivable.getSelectedRow();
        int i = tbl_accounts_receivable.getSelectedRow();
        data_cols();

        tbl_accounts_receivable.setRowSelectionInterval(i, i);
        data_cols_ar_payments();

        clear_accounts_receivable_payments();
        tf_ap_month.grabFocus();
        Alert.set(1, type);
    }

    private void select_accounts_receivable_payments() {
        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));

        tf_ap_cash.setText(FitIn.fmt_wc_0(to.amount));
        tf_ap_check_amount.setText(FitIn.fmt_wc_0(to.check_amount));
        tf_ap_check_holder.setText(to.check_holder);
        tf_ap_check_bank.setText(to.check_bank);
        tf_ap_check_no.setText(to.check_no);
        tf_or_payment_no.setText(to.or_payment_no);
        tf_remarks2.setText(to.remarks);
        Date d = new Date();
        Date d2 = new Date();
        try {
            d = DateType.sf.parse(to.date_applied);
            d2 = DateType.sf.parse(to.check_date);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_ar_encoding.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        String month = DateType.m.format(d);
        String day = DateType.d.format(d);
        String year = DateType.y.format(d);

        String month2 = DateType.m.format(d2);
        String day2 = DateType.d.format(d2);
        String year2 = DateType.y.format(d2);

        tf_ap_month.setText(month);
        tf_ap_day.setText(day);
        tf_ap_year.setText(year);

        tf_ap_month1.setText(month);
        tf_ap_day1.setText(day);
        tf_ap_year1.setText(year);

        btn_add1.setEnabled(false);
        btn_edit1.setEnabled(true);
        btn_delete1.setEnabled(true);
    }

    private void edit_accounts_receivable_payments() {
        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));
        int id = to.id;
        String customer_id = to.customer_id;
        String customer_name = to.customer_name;
        String ar_no = to.ar_no;
        String date_added = DateType.datetime.format(new Date());
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_ap_cash.getText());
        double discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        double discount_rate = FitIn.toDouble(tf_discount_rate.getText());
        String discount = tf_discount_name.getText();
        int status = 0;
        double term = 0;
        String date_applied = tf_ap_month.getText() + " " + tf_ap_day.getText() + ", " + tf_ap_year.
                getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = 0;
        String date_paid = DateType.sf.format(new Date());
        String remarks = tf_remarks2.getText();
        String type = "CASH";
        String or_no = to.or_no;
        double prev_balance = 0;
        double check_amount = FitIn.toDouble(tf_ap_check_amount.getText());
        String check_holder = tf_ap_check_holder.getText();
        String check_bank = tf_ap_check_bank.getText();
        String check_no = tf_ap_check_no.getText();
        String ci_no = to.ci_no;//tf_or_no.getText();
        String trust_receipt = to.trust_receipt;//tf_or_no.getText();
        String or_payment_no = tf_or_payment_no.getText();
        String soa_id = to.soa_id;
        String soa_type = to.soa_type;
        String soa_type_id = to.soa_type_id;
        String reference_no = to.reference_no;
        String check_date = tf_ap_month1.getText() + " " + tf_ap_day1.getText() + ", " + tf_ap_year1.getText();
        String user_id = to.user_id;
        String user_screen_name = to.user_screen_name;
        double tax_rate = 0;
        double tax_amount = 0;
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id, soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location, location_id);
        double previous_cash = to.amount;
        double previous_check = to.check_amount;
        S1_accounts_receivable_payments.edit_accounts_receivable_payments(to1, previous_cash, previous_check);
        int i = tbl_accounts_receivable.getSelectedRow();
        data_cols();

        tbl_accounts_receivable.setRowSelectionInterval(i, i);
        data_cols_ar_payments();

        Alert.set(2, type);
        clear_accounts_receivable_payments();
    }

    private void clear_accounts_receivable_payments() {
        tf_ap_cash.setText("");
        tf_ap_month.setText("");
        tf_ap_day.setText("");
        tf_ap_year.setText("");
        tf_ap_check_bank.setText("");
        tf_ap_check_holder.setText("");
        tf_ap_check_amount.setText("");
        tf_ap_check_no.setText("");

    }

    private void delete_accounts_receivable_payments() {
        String where = " where user_name='" + Users.user_name + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        int exists = 0;
        for (S1_user_previleges.to_user_previleges to : datas) {
            if (to.previledge.equalsIgnoreCase("Delete AR Payment")) {
                exists = 1;
                break;
            }
        }
        if (exists == 1) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    int row = tbl_accounts_receivable_payments.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                            get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));
                    S1_accounts_receivable_payments.delete_accounts_receivable_payments(to);
                    int i = tbl_accounts_receivable.getSelectedRow();
                    data_cols();
                    tbl_accounts_receivable.setRowSelectionInterval(i, i);
                    data_cols_ar_payments();
                    clear_accounts_receivable_payments();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            Alert.set(0, "No privelege to delete transaction");
        }

    }

    private void customers() {
        Window p = (Window) this;
        Dlg_customers nd = Dlg_customers.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_customers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void ar_aging() {

    }

    private void customer_balances() {
        Window p = (Window) this;
        Dlg_customer_balances nd = Dlg_customer_balances.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_customer_balances.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customer_balances.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ar_ledger() {
        Window p = (Window) this;
        Dlg_ar_ledger nd = Dlg_ar_ledger.create(p, true);
        nd.setTitle("");
        Customers.to_customers to = customer_list.get(selected_row);
        nd.do_pass(to.customer_no, to.customer_name, to.address);
        nd.setCallback(new Dlg_ar_ledger.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_ledger.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void setEmployeeTableModel() {

        double cash = 0;
        double check = 0;

        List<to_accounts_receivable_payments> datas = tbl_accounts_receivable_payments_ALM;
        for (to_accounts_receivable_payments to : datas) {
            cash += to.amount;
            check += to.check_amount;

        }

        Object[][] obj = new Object[0][12];
        String[] col_names = {"", "", FitIn.fmt_wc_0(check), FitIn.fmt_wc_0(cash)};
        myModel(tbl_total_payments, obj, col_names);
        int[] tbl_widths_accounts_receivable = {100, 100, 80, 80};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 0 | i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_total_payments, i, tbl_widths_accounts_receivable[i]);
        }
        tbl_total_payments.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        tbl_total_payments.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 12));
    }

    private void myModel(JTable tbl, Object[][] obj, String[] col_names) {
        tbl.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                col_names) {

            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tbl.setRowHeight(30);
        tbl.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl, 1);
        TableWidthUtilities.setColumnRightRenderer(tbl, 2);
    }

    private void soa() {
        Window p = (Window) this;
        Dlg_sales_on_account nd = Dlg_sales_on_account.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_sales_on_account.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_sales_on_account.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<S1_account_receivable_types.to_accounts_receivable_types> type_list = new ArrayList();

    private void init_types(final JTextField tf1, final JTextField tf2) {
        String search = tf1.getText();
        String where = "";
        type_list.clear();
        type_list = S1_account_receivable_types.ret_data(where);
        Object[][] obj = new Object[type_list.size()][2];
        int i = 0;
        for (S1_account_receivable_types.to_accounts_receivable_types to : type_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.type_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 100};
        String[] col_names = {"", "Type"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_account_receivable_types.to_accounts_receivable_types to = type_list.get(data.selected_row);
                tf2.setText("" + to.id);
                tf1.setText(to.type_name);
            }
        });
    }

    private void my_customers() {
        Window p = (Window) this;
        Dlg_customers_ar nd = Dlg_customers_ar.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_customers_ar.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers_ar.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<S1_discounts.to_discounts> discount_list = new ArrayList();

    private void init_discount() {
        String search = tf_discount_name.getText();
        discount_list.clear();
        String where = " where discount_name like '%" + search + "%' ";
        discount_list = S1_discounts.ret_data3(search);
        Object[][] obj = new Object[discount_list.size()][2];
        int i = 0;
        for (S1_discounts.to_discounts to : discount_list) {
            obj[i][1] = " " + to.discount_name;
            obj[i][0] = " " + FitIn.fmt_wc_0(to.discount_rate);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 150};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_discount_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        int row = tbl_accounts_receivable.getSelectedRow();
                        if (row < 0) {
                            return;
                        }
                        to_accounts_receivable to1 = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));
                        S1_discounts.to_discounts to = discount_list.get(data.selected_row);
                        tf_discount_amount.setText(FitIn.fmt_wc_0(0));
                        tf_discount_rate.setText(FitIn.fmt_wc_0(to.discount_rate));
                        tf_discount_name.setText(to.discount_name);
                        double rate = to.discount_rate;
                        rate = rate / 100;
                        rate = rate * to1.remaining_balance;
                        tf_discount_amount.setText(FitIn.fmt_wc_0(rate));
                        tf_discount_amount.grabFocus();

                    }
                });

            }
        });
    }
}
