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
import POS.terms.S1_terms;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.users.User_default_privelege_others;
import POS.users.User_previlege_others;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
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
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

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
        dialog.setSize(xSize, ySize);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tf_search_customer = new Field.Search();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        tf_customer_id = new javax.swing.JTextField();
        lbl_credit_limit = new javax.swing.JTextField();
        jButton11 = new Button.Default();
        jPanel4 = new javax.swing.JPanel();
        jButton7 = new Button.Default();
        jButton8 = new Button.Primary();
        jButton9 = new Button.Info();
        jButton10 = new Button.Warning();
        jPanel5 = new javax.swing.JPanel();
        tf_soa_type = new javax.swing.JTextField();
        tf_soa_type_id = new javax.swing.JTextField();
        tf_reference_no = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_term = new SearchField();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tf_paid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JTextField();
        tf_remarks = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_ar_no = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tf_trust_receipt = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_accounts_receivable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lbl_balance = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jButton12 = new Button.Primary();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        tf_ap_check_amount = new javax.swing.JTextField();
        tf_discount_rate = new Field.Input();
        tf_ap_check_no = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tf_discount_amount = new Field.Input();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tf_or_payment_no = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tf_ap_cash = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_remarks2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_ap_check_bank = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_ap_check_holder = new javax.swing.JTextField();
        tf_discount_name = new Field.Combo();
        jButton6 = new Button.Default();
        jButton4 = new Button.Primary();
        jButton3 = new Button.Info();
        jButton2 = new Button.Warning();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_accounts_receivable_payments = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        lbl_balance1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_balance2 = new javax.swing.JLabel();
        lbl_balance3 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tf_search_customer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_search_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search_customerActionPerformed(evt);
            }
        });

        jLabel1.setBackground(java.awt.Color.black);
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Search:");

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name:");

        jLabel6.setBackground(java.awt.Color.black);
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Balance:");

        jLabel4.setBackground(java.awt.Color.black);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID No:");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_customer_name.setFocusable(false);
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        tf_customer_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_customer_id.setFocusable(false);

        lbl_credit_limit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_limit.setFocusable(false);

        jButton11.setText("+");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_search_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(tf_search_customer, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton7.setText("New");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tf_soa_type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_soa_type.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tf_soa_typeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tf_soa_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_soa_typeActionPerformed(evt);
            }
        });

        tf_soa_type_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Reference No:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Term:");

        tf_term.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_term.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_termActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Day/s");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Paid:");

        tf_paid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_paid.setFocusable(false);
        tf_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_paidActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Amount:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Balance:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setFocusable(false);

        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Remarks:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("AR No:");

        tf_ar_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_ar_no.setText("00000000");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("TR:");

        tf_trust_receipt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_trust_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_trust_receiptActionPerformed(evt);
            }
        });

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Date Applied:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Charge Type:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_reference_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tf_ar_no, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_trust_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                            .addComponent(tf_term))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                            .addComponent(tf_paid)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(tf_soa_type, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_soa_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ar_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_trust_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_soa_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_soa_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_term, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AR Lists", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("C.I NO:");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Trust Receipt");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Balance:");

        lbl_balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_balance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance.setText("0.00");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Reference No");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Filter:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Status:");

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("All");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Paid");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("Unpaid");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jButton12.setText("Batch Payment");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5))
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox7)
                                .addGap(8, 8, 8))
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AR Payment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Check Amount:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Rate:");

        tf_ap_check_amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tf_discount_rate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_discount_rate.setFocusable(false);

        tf_ap_check_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_ap_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_check_noActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Check No:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Disc Amount:");

        tf_discount_amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_discount_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discount_amountActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Date Applied:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Reference No:");

        tf_or_payment_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Cash:");

        tf_ap_cash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Remarks:");

        tf_remarks2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_remarks2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks2ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Check Bank:");

        tf_ap_check_bank.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_ap_check_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_check_bankActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Cheque Date:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Check Holder:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Discount:");

        tf_ap_check_holder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tf_discount_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jButton6.setText("New");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(tf_discount_rate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_discount_amount))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_ap_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tf_ap_cash, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_or_payment_no)
                            .addComponent(tf_ap_check_bank)
                            .addComponent(tf_ap_check_holder)
                            .addComponent(tf_ap_check_no)
                            .addComponent(tf_remarks2)
                            .addComponent(tf_discount_name)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_or_payment_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_ap_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_remarks2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_discount_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Cash:");

        lbl_balance1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_balance1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance1.setText("0.00");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Cheque:");

        lbl_balance2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_balance2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance2.setText("0.00");

        lbl_balance3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_balance3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance3.setText("0.00");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Discount:");

        jToggleButton1.setText("+");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_balance1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33)
                        .addGap(2, 2, 2)
                        .addComponent(lbl_balance3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_balance2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jToggleButton1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_balance3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_balance1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_balance2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
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
        tf_amount.grabFocus();
//        add_accounts_receivable();
    }//GEN-LAST:event_tf_termActionPerformed

    private void tf_search_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search_customerActionPerformed
        init_popup();
    }//GEN-LAST:event_tf_search_customerActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        tf_remarks.grabFocus();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tbl_accounts_receivableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMouseClicked
        select_accounts_receivable();
    }//GEN-LAST:event_tbl_accounts_receivableMouseClicked

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
        tf_term.grabFocus();
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_paidActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void tf_soa_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_soa_typeActionPerformed
        init_types(tf_soa_type, tf_soa_type_id);
    }//GEN-LAST:event_tf_soa_typeActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_discount_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_nameMouseClicked
        init_discount();
    }//GEN-LAST:event_tf_discount_nameMouseClicked

    private void tf_discount_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_nameActionPerformed
        init_discount();
    }//GEN-LAST:event_tf_discount_nameActionPerformed

    private void tf_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_amountActionPerformed

    }//GEN-LAST:event_tf_discount_amountActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        add_ar_payment();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        edit_accounts_receivable_payments();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        delete_accounts_receivable_payments();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        add_accounts_receivable();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        edit_accounts_receivable();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        delete_accounts_receivable();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        clear_accounts_receivable();
        init_ar_no();
        jButton8.setEnabled(true);
        jButton9.setEnabled(false);
        jButton10.setEnabled(false);
        tbl_accounts_receivable.clearSelection();
        tf_search_customer.grabFocus();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        my_customers();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clear_accounts_receivable_payments();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_ap_check_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_check_bankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_check_bankActionPerformed

    private void tf_remarks2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks2ActionPerformed

    private void tf_soa_typeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tf_soa_typeAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_soa_typeAncestorAdded

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        batch_payment();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
      if(jToggleButton1.isSelected()){
          jPanel7.setVisible(false);
      }else{
          jPanel7.setVisible(true);
      }
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbl_balance;
    private javax.swing.JLabel lbl_balance1;
    private javax.swing.JLabel lbl_balance2;
    private javax.swing.JLabel lbl_balance3;
    private javax.swing.JTextField lbl_credit_limit;
    private javax.swing.JTable tbl_accounts_receivable;
    private javax.swing.JTable tbl_accounts_receivable_payments;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_ap_cash;
    private javax.swing.JTextField tf_ap_check_amount;
    private javax.swing.JTextField tf_ap_check_bank;
    private javax.swing.JTextField tf_ap_check_holder;
    private javax.swing.JTextField tf_ap_check_no;
    private javax.swing.JLabel tf_ar_no;
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
//        Main.MyDB.setNames("db_algorithm");
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_password", "password");
//        System.setProperty("pool_host", "192.168.1.51");
        init_key();
        set_default_branch();
        init_tbl_accounts_receivable();
        init_search();
        init_ar_no();
        focus();
        enable_ar(false);
        jButton9.setEnabled(false);
        jButton10.setEnabled(false);
        init_focus();
        init_tbl_accounts_receivable_payments();
        
        jLabel25.setVisible(false);
        tf_trust_receipt.setVisible(false);
//        jButton1.setVisible(false);

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
        JTextField[] tf = {tf_search_customer, tf_amount, tf_term, tf_ap_cash, tf_ap_check_bank, tf_ap_check_holder, tf_ap_check_amount, tf_ap_check_no, tf_reference_no, tf_trust_receipt, tf_paid, jTextField1, tf_soa_type, tf_remarks, tf_remarks2};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_focus() {

        Focus_Fire.nextFocus(tf_ap_cash, tf_ap_check_bank);
        Focus_Fire.nextFocus(tf_ap_check_bank, tf_ap_check_holder);
        Focus_Fire.nextFocus(tf_ap_check_holder, tf_ap_check_amount);
        Focus_Fire.nextFocus(tf_ap_check_amount, tf_ap_check_no);

    }

    private void init_ar_no() {
        tf_ar_no.setText(S1_accounts_receivable.increment_id(my_branch_id));
    }

    private void enable_ar(boolean stmt) {
        jDateChooser1.setEnabled(stmt);

        tf_amount.setEnabled(stmt);
        tf_term.setEnabled(stmt);

    }

    private void init_search() {

        testOfFaith.set(tf_term, S1_terms.ret_cb_data(), "TERM");

        Date d = new Date();
        Date d2 = new Date();

        String month = DateType.m.format(d);
        String day = DateType.d.format(d);
        String year = DateType.y.format(d);

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
        Object[][] obj = new Object[customer_list.size()][3];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            obj[i][2] = " " + FitIn.fmt_wc_0(to.balance);
//            obj[i][3] = " " + FitIn.fmt_wc_0(to.balance);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 100, 50};
        String[] col_names = {"ID", "NAME", "Balance"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_search_customer, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_id.setText(to.customer_no);
                tf_customer_name.setText(to.customer_name);
                lbl_credit_limit.setText(FitIn.fmt_wc_0(to.balance));
                lbl_balance.setText(FitIn.fmt_wc_0(to.balance));
                tf_term.setText(FitIn.fmt_woc(to.term));
                tbl_accounts_receivable_payments_ALM.clear();
                tbl_accounts_receivable_payments_M.fireTableDataChanged();
                data_cols();
                enable_ar(true);
                tf_soa_type.grabFocus();
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
        int[] tbl_widths_accounts_receivable = {100, 0, 100, 100, 100, 100, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
                setFont(new java.awt.Font("Arial", 0, 12));
        tbl_accounts_receivable.setRowHeight(25);
        tbl_accounts_receivable.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 5);
        tbl_accounts_receivable.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    private void loadData_accounts_receivable(List<to_accounts_receivable> acc) {
        tbl_accounts_receivable_ALM.clear();
        tbl_accounts_receivable_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference #", "Trust Receipt", "Date", "Term", "Amount", "Balance", "", "", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type"
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
            if (col == 7) {
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
                        return " " + tt.trust_receipt;
                    }
                    if (tt.trust_receipt.isEmpty()) {
                        return " " + tt.ci_no;
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
                    if (tt.status == 1) {
                        return "/POS/icon_payment/remove11.png";
                    } else {
                        return "/POS/icon_inventory/checked.png";
                    }
                case 7:
                    return tt.selected;
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

        String where = " where remarks like '%" + "" + "%' ";
        where = where + " and customer_id='" + search + "'";
        if (jCheckBox6.isSelected()) {
            where = where + " and (amount-paid)<=0 ";
        }
        if (jCheckBox7.isSelected()) {
            where = where + " and (amount-paid)>0 ";
        }
        where = where + "  order by  id desc";
        loadData_accounts_receivable(S1_accounts_receivable.ret_data5(where));
        compute_ar_balance();
    }

    private void data_cols2() {
        String where = "  ";

        if (jCheckBox1.isSelected()) {
            where = where + " where ci_no like '%" + jTextField1.getText() + "%' and customer_id='" + tf_customer_id.getText() + "' ";
        }
        if (jCheckBox2.isSelected()) {
            where = where + " where trust_receipt like '%" + jTextField1.getText() + "%' and customer_id='" + tf_customer_id.getText() + "' ";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " where reference_no like '%" + jTextField1.getText() + "%' and customer_id='" + tf_customer_id.getText() + "' ";
        }
        loadData_accounts_receivable(S1_accounts_receivable.ret_data3(where));
        compute_ar_balance();
    }

    private void add_accounts_receivable() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
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
        String date_applied = DateType.sf.format(jDateChooser1.getDate());

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
        if (amount <= 0) {
            Alert.set(0, "Enter Amount");
            tf_amount.grabFocus();
            return;
        }
        final to_accounts_receivable to = new to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to add this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_accounts_receivable.add_accounts_receivable(to);
                data_cols();
                clear_accounts_receivable();
                init_ar_no();
                Alert.set(1, "");
                tf_soa_type.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void compute_ar_balance() {
        List<to_accounts_receivable> datas = tbl_accounts_receivable_ALM;
        double total = 0;
        for (to_accounts_receivable to : datas) {
            if (to.status != 1) {
                total += to.amount - to.paid;
            }

        }
        lbl_balance.setText(FitIn.fmt_wc_0(total));
    }

    private void select_accounts_receivable() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }

        int col = tbl_accounts_receivable.getSelectedColumn();
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));

        if (col == 7) {

            if (to.isSelected()) {
                to.setSelected(false);
            } else {

                if (to.status == 1) {
                    Alert.set(0, "Transaction already cancelled!");
                    return;
                }
                double balance = to.amount - to.paid;
                if (balance <= 0) {
                    Alert.set(0, "Transaction already paid!");
                    return;
                }
                to.setSelected(true);
            }
            tbl_accounts_receivable_M.fireTableDataChanged();
        } else {
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
                jDateChooser1.setDate(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_ar_encoding.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

            jButton8.setEnabled(false);
            jButton9.setEnabled(true);
            jButton10.setEnabled(true);

            data_cols_ar_payments();

        }

    }

    private void edit_accounts_receivable() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable - (Edit)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        final int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot proceed, Transaction has been cancelled!");
            return;
        }
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
        String date_applied = DateType.sf.format(jDateChooser1.getDate());
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
        final to_accounts_receivable to1 = new to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to update this transaction?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_accounts_receivable.edit_accounts_receivable3(to1, to.amount, to1.paid);
                data_cols();
                tbl_accounts_receivable.setRowSelectionInterval(row, row);
                data_cols_ar_payments();
                clear_accounts_receivable();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void clear_accounts_receivable() {
        tf_paid.setText("");
        tf_amount.setText("");
        tf_term.setText("");
        tf_reference_no.setText("");
        tf_trust_receipt.setText("");

        tf_remarks.setText("");
    }

    private void delete_accounts_receivable() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable - (Delete)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }

        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        if (to.status == 0) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Delete Finalized AR - (Add)" + "' limit 1";
            List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
            if (datas.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
        }
        if (to.status == 1) {
            Alert.set(0, "Cannot proceed, Transaction has been cancelled!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_delete.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();

                S1_accounts_receivable.delete_accounts_receivable(to);

                data_cols();
                tbl_accounts_receivable_payments_ALM.clear();
                tbl_accounts_receivable_payments_M.fireTableDataChanged();
                compute_payments();
                clear_accounts_receivable();

                init_ar_no();
                jButton8.setEnabled(true);
                jButton9.setEnabled(false);
                jButton10.setEnabled(false);
                tbl_accounts_receivable.clearSelection();
                tf_search_customer.grabFocus();
                Alert.set(3, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

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
        int[] tbl_widths_accounts_receivable_payments = {70, 100, 70, 70, 60, 60, 60, 80, 0, 80,80, 80, 60, 30, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable_payments.length; i < n; i++) {
            if (i == 1) {
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
                setFont(new java.awt.Font("Arial", 0, 12));
        tbl_accounts_receivable_payments.setRowHeight(25);
        tbl_accounts_receivable_payments.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 7);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 8);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 9);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 10);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 11);
        tbl_accounts_receivable_payments.getColumnModel().getColumn(13).setCellRenderer(new ImageRenderer());
    }

    private void loadData_accounts_receivable_payments(List<to_accounts_receivable_payments> acc) {
        tbl_accounts_receivable_payments_ALM.clear();
        tbl_accounts_receivable_payments_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivable_paymentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "OR #", "Check", "Cash", "Discount", "Prepaid", "Credit", "GC/Online", "Online", "Retention", "Business Tax", "Salary Deduction", "", "", "date_paid", "remarks", "type", "or_no", "prev_balance"
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
                    return FitIn.fmt_wc_0(tt.prepaid_amount) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.credit_card_amount) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.gift_certificate_amount+tt.online_amount) + " ";
                case 8:
                    return FitIn.fmt_wc_0(tt.online_amount) + " ";
                case 9:
                    return FitIn.fmt_wc_0(tt.retention) + " ";
                case 10:
                    return FitIn.fmt_wc_0(tt.business_tax) + " ";
                case 11:
                    return FitIn.fmt_wc_0(tt.salary_deduction) + " ";
                case 12:
                    if (tt.status == 0) {
                        return " Finalized";
                    } else if (tt.status == 1) {
                        return " Posted";
                    } else {
                        return " Deleted";
                    }
                case 13:
                    if (tt.status == 2) {
                        return "/POS/icon_payment/remove11.png";
                    } else {
                        return "/POS/icon_inventory/checked.png";
                    }
                case 14:

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
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));
        loadData_accounts_receivable_payments(S1_accounts_receivable_payments.ret_data(to.ar_no, to.customer_id));

        compute_payments();
    }

    private void add_ar_payment() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable Payments - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot proceed, Transaction has been cancelled!");
            return;
        }
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
        String date_applied = DateType.sf.format(jDateChooser2.getDate());
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
        String check_date = DateType.sf.format(jDateChooser3.getDate());
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        double tax_rate = 0;
        double tax_amount = 0;

        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;

        double total_amount = check_amount + amount;
        if (total_amount <= 0 && discount_amount <= 0) {
            Alert.set(0, "Please input amount!");
            tf_ap_cash.grabFocus();
            return;
        }
        String prepaid_customer_name = "";
        String prepaid_customer_id = "";
        double prepaid_amount = 0;
        String credit_card_type = "";
        double credit_card_rate = 0;
        String credit_card_no = "";
        String credit_card_holder = "";
        double credit_card_amount = 0;
        String gift_certificate_from = "";
        String gift_certificate_description = "";
        String gift_certificate_no = "";
        double gift_certificate_amount = 0;
        String online_bank = "";
        String online_reference_no = "";
        String online_holder = "";
        String online_date = DateType.now();
        double online_amount = 0;
        double actual_amount = (amount + check_amount) - discount_amount;
        double retention = 0;
        double business_tax = 0;
        double salary_deduction = 0;
        final S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid,
                date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id,
                soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location,
                location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no,
                credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount,
                online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount, retention, business_tax, salary_deduction);

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this payment?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_accounts_receivable_payments.add_accounts_receivable_payments(to1);
                int row1 = tbl_accounts_receivable.getSelectedRow();
                int i = tbl_accounts_receivable.getSelectedRow();
                data_cols();

                tbl_accounts_receivable.setRowSelectionInterval(i, i);
                data_cols_ar_payments();

                clear_accounts_receivable_payments();

                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

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
        tf_discount_amount.setText(FitIn.fmt_wc_0(to.discount_amount));
        tf_discount_name.setText(to.discount);
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
            jDateChooser2.setDate(d);
            jDateChooser3.setDate(d2);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_ar_encoding.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        jButton4.setEnabled(false);
        jButton3.setEnabled(true);
        jButton2.setEnabled(true);
    }

    private void edit_accounts_receivable_payments() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable Payments - (Edit)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));
        if (to.status == 2) {
            Alert.set(0, "Cannot proceed, Transaction has been cancelled!");
            return;
        }
        int row2 = tbl_accounts_receivable.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        final to_accounts_receivable to_ar = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row2));
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
        String date_applied = DateType.sf.format(jDateChooser2.getDate());
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
        String check_date = DateType.sf.format(jDateChooser3.getDate());
        String user_id = to.user_id;
        String user_screen_name = to.user_screen_name;
        double tax_rate = 0;
        double tax_amount = 0;
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        String prepaid_customer_name = "";
        String prepaid_customer_id = "";
        double prepaid_amount = 0;
        String credit_card_type = "";
        double credit_card_rate = 0;
        String credit_card_no = "";
        String credit_card_holder = "";
        double credit_card_amount = 0;
        String gift_certificate_from = "";
        String gift_certificate_description = "";
        String gift_certificate_no = "";
        double gift_certificate_amount = 0;
        String online_bank = "";
        String online_reference_no = "";
        String online_holder = "";
        String online_date = "";
        double online_amount = 0;
        double actual_amount = (amount + check_amount) - discount_amount;
        double retention = 0;
        double business_tax = 0;
        double salary_deduction = 0;
        final S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid,
                date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id,
                soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location, location_id,
                prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount,
                gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder,
                online_date, online_amount, actual_amount, retention, business_tax, salary_deduction);
        final double previous_cash = to.amount;
        final double previous_check = to.check_amount;
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed updating this payment?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_accounts_receivable_payments.edit_accounts_receivable_payments2(to1, to, to_ar);
                int i = tbl_accounts_receivable.getSelectedRow();
                data_cols();

                tbl_accounts_receivable.setRowSelectionInterval(i, i);
                data_cols_ar_payments();

                Alert.set(2, "");
                clear_accounts_receivable_payments();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void clear_accounts_receivable_payments() {
        tf_ap_cash.setText("");
        tf_ap_check_bank.setText("");
        tf_ap_check_holder.setText("");
        tf_ap_check_amount.setText("");
        tf_ap_check_no.setText("");
        tf_or_payment_no.setText("");
        tf_remarks2.setText("");
        tf_ap_cash.grabFocus();
        jButton4.setEnabled(true);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }

    private void delete_accounts_receivable_payments() {
//        String where2 = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable Payments - (Delete)" + "' limit 1";
//        List<User_default_privelege_others.to_user_default_priveleges> privileges = User_default_privelege_others.ret_data(where2);
//        if (privileges.isEmpty()) {
//            Alert.set(0, "Privilege not added!");
//            return;
//        }

//        String where = " where user_name='" + Users.user_name + "' order by previledge asc";
//        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
//        int exists = 0;
//        for (S1_user_previleges.to_user_previleges to : datas) {
//            if (to.previledge.equalsIgnoreCase("Delete AR Payment")) {
//                exists = 1;
//                break;
//            }
//        }
//        exists=1;
//        if (exists == 1) {
        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }

        final to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));
        if (to.status == 2) {
            Alert.set(0, "Cannot proceed, Transaction has been cancelled!");
            return;
        }
        if (to.status == 0) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Delete Finalized AR Payment - (Add)" + "' limit 1";
            List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
            if (datas.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
        }
        int row2 = tbl_accounts_receivable.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        final to_accounts_receivable to_ar = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row2));
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();

                S1_accounts_receivable_payments.delete_accounts_receivable_payments(to, to_ar);
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

//        } else {
//            Alert.set(0, "No privelege to delete transaction");
//        }
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

    private void compute_payments() {

        double cash = 0;
        double check = 0;
        double discount = 0;
        List<to_accounts_receivable_payments> datas = tbl_accounts_receivable_payments_ALM;
        for (to_accounts_receivable_payments to : datas) {
            if (to.status == 0) {
                cash += to.amount;
                check += to.check_amount;
                discount += to.discount_amount;
            }

        }
        lbl_balance3.setText(FitIn.fmt_wc_0(discount));
        lbl_balance1.setText(FitIn.fmt_wc_0(cash));
        lbl_balance2.setText(FitIn.fmt_wc_0(check));
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
            obj[i][1] = " " + to.type_name;
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
                tf_reference_no.grabFocus();
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

    private void batch_payment() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable Payments - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        String name = tf_customer_name.getText();
        String id = tf_customer_id.getText();
        String balance = lbl_credit_limit.getText();
        List<to_accounts_receivable> datas = tbl_accounts_receivable_ALM;
        List<to_accounts_receivable> selected = new ArrayList();
        for (to_accounts_receivable to : datas) {
            if (to.isSelected()) {
                selected.add(to);
            }
        }
        if (selected.isEmpty()) {
            Alert.set(0, "No transaction selected!");
            return;
        }
        Window p = (Window) this;
        Dlg_ar_payment_batch nd = Dlg_ar_payment_batch.create(p, true);
        nd.setTitle("");
        nd.do_pass(selected, name, id, balance);
        nd.setCallback(new Dlg_ar_payment_batch.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_payment_batch.OutputData data) {
                closeDialog.ok();

                List<S1_accounts_receivable_payments.to_accounts_receivable_payments> added = data.data;
                for (S1_accounts_receivable_payments.to_accounts_receivable_payments to1 : added) {
                    S1_accounts_receivable_payments.add_accounts_receivable_payments(to1);
                }
                data_cols();
                tbl_accounts_receivable_payments_ALM.clear();
                clear_accounts_receivable_payments();
                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
