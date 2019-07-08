/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.banks.Banks;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.credit_cards.S1_credit_cards;
import POS.customers.Customers;
import POS.discounts.S1_discounts;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 *
 */
public class Dlg_ar_add_payment extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_add_payment
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

        public final String date_applied;
        public final double cash;
        public final String or_no;
        public final String check_bank;
        public final String check_holder;
        public final double check_amount;
        public final String check_no;
        public final String check_date;
        public final double tax_rate;
        public final double tax_amount;
        public final String discount;
        public final double discount_rate;
        public final double discount_amount;
        public final String prepaid_customer_name;
        public final String prepaid_customer_id;
        public final double prepaid_amount;
        public final String credit_card_type;
        public final double credit_card_rate;
        public final String credit_card_no;
        public final String credit_card_holder;
        public final double credit_card_amount;
        public final String gift_certificate_from;
        public final String gift_certificate_description;
        public final String gift_certificate_no;
        public final double gift_certificate_amount;
        public final String online_bank;
        public final String online_reference_no;
        public final String online_holder;
        public final String online_date;
        public final double online_amount;
        public final double actual_tendered;
        public final double retention;
        public final double business_tax;
        public final double salary_deduction;

        public OutputData(String date_applied, double cash, String or_no, String check_bank, String check_holder, double check_amount, String check_no, String check_date, double tax_rate, double tax_amount, String discount, double discount_rate, double discount_amount, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String credit_card_type, double credit_card_rate, String credit_card_no, String credit_card_holder, double credit_card_amount, String gift_certificate_from, String gift_certificate_description, String gift_certificate_no, double gift_certificate_amount, String online_bank, String online_reference_no, String online_holder, String online_date, double online_amount, double actual_tendered, double retention, double business_tax, double salary_deduction) {
            this.date_applied = date_applied;
            this.cash = cash;
            this.or_no = or_no;
            this.check_bank = check_bank;
            this.check_holder = check_holder;
            this.check_amount = check_amount;
            this.check_no = check_no;
            this.check_date = check_date;
            this.tax_rate = tax_rate;
            this.tax_amount = tax_amount;
            this.discount = discount;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.credit_card_type = credit_card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_amount = credit_card_amount;
            this.gift_certificate_from = gift_certificate_from;
            this.gift_certificate_description = gift_certificate_description;
            this.gift_certificate_no = gift_certificate_no;
            this.gift_certificate_amount = gift_certificate_amount;
            this.online_bank = online_bank;
            this.online_reference_no = online_reference_no;
            this.online_holder = online_holder;
            this.online_date = online_date;
            this.online_amount = online_amount;
            this.actual_tendered = actual_tendered;
            this.retention = retention;
            this.business_tax = business_tax;
            this.salary_deduction = salary_deduction;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_ar_add_payment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_add_payment(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_add_payment() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_ar_add_payment myRef;

    private void setThisRef(Dlg_ar_add_payment myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_add_payment> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_add_payment create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_add_payment create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_add_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_add_payment((java.awt.Frame) parent, false);
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
            Dlg_ar_add_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_add_payment((java.awt.Dialog) parent, false);
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

        Dlg_ar_add_payment dialog = Dlg_ar_add_payment.create(new javax.swing.JFrame(), true);
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
        jPanel4 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        tf_ap_cash = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tf_ap_cash1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tf_ap_cash2 = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_discount_name = new Field.Combo();
        tf_discount_rate = new Field.Input();
        tf_discount_amount = new Field.Input();
        jLabel46 = new javax.swing.JLabel();
        tf_ap_cash3 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        tf_ap_cash4 = new Field.Input();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        tf_or_payment_no = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_check_bank = new Field.Search();
        jLabel21 = new javax.swing.JLabel();
        tf_ap_check_holder = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tf_ap_check_no = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        tf_ap_cash5 = new Field.Input();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        tf_prepaid_customer_name = new Field.Search();
        jLabel30 = new javax.swing.JLabel();
        tf_prepaid_customer_id = new Field.Input();
        jLabel31 = new javax.swing.JLabel();
        tf_prepaid_balance = new Field.Input();
        jLabel49 = new javax.swing.JLabel();
        tf_ap_cash6 = new Field.Input();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        tf_credit_card_type = new Field.Combo();
        jLabel33 = new javax.swing.JLabel();
        lbl_credit_card_rate = new Field.Input();
        jLabel34 = new javax.swing.JLabel();
        tf_prepaid_customer_id3 = new Field.Input();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tf_prepaid_customer_id4 = new Field.Input();
        jLabel37 = new javax.swing.JLabel();
        tf_prepaid_customer_id5 = new Field.Input();
        tf_credit_card_amount = new Field.Input();
        jLabel39 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        tf_ap_cash7 = new Field.Input();
        jPanel8 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        tf_prepaid_customer_id9 = new Field.Input();
        jLabel44 = new javax.swing.JLabel();
        tf_prepaid_customer_id10 = new Field.Input();
        jLabel45 = new javax.swing.JLabel();
        tf_prepaid_customer_id11 = new Field.Input();
        jLabel51 = new javax.swing.JLabel();
        tf_ap_cash8 = new Field.Input();
        jPanel9 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        tf_prepaid_customer_id6 = new Field.Input();
        jLabel40 = new javax.swing.JLabel();
        tf_prepaid_customer_id7 = new Field.Input();
        jLabel41 = new javax.swing.JLabel();
        tf_prepaid_customer_id8 = new Field.Input();
        jLabel42 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        tf_ap_cash9 = new Field.Input();
        jLabel52 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        tf_ap_cash11 = new Field.Input();
        jPanel13 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        tf_ap_cash12 = new Field.Input();
        jPanel14 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        tf_ap_cash13 = new Field.Input();
        jPanel11 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        tf_ap_cash10 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("OK");
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

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Tender:");

        tf_ap_cash.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cashKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Tax (%):");

        tf_ap_cash1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash1KeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Taxable:");

        tf_ap_cash2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash2.setFocusable(false);
        tf_ap_cash2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash2KeyReleased(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Vat Inclusive");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Discount:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Rate:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Disc Amount:");

        tf_discount_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        tf_discount_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_rate.setFocusable(false);

        tf_discount_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discount_amountActionPerformed(evt);
            }
        });
        tf_discount_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_discount_amountKeyReleased(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Total Amount:");

        tf_ap_cash3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_ap_cash3.setText("1,000.00");
        tf_ap_cash3.setFocusable(false);
        tf_ap_cash3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash3KeyReleased(evt);
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
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_ap_cash1)
                            .addComponent(tf_ap_cash2)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(tf_ap_cash))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_discount_name)
                            .addComponent(tf_discount_rate)
                            .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_ap_cash3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_ap_cash1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_discount_rate)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_ap_cash2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addComponent(jCheckBox3)
                .addContainerGap())
        );

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("Cash Amount:");

        tf_ap_cash4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash4ActionPerformed(evt);
            }
        });
        tf_ap_cash4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash4KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ap_cash4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(167, 167, 167))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cash", jPanel6);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Date Applied:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Reference No:");

        tf_or_payment_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Cheque Bank:");

        tf_check_bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_bank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_check_bankMouseClicked(evt);
            }
        });
        tf_check_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_bankActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Cheque Holder:");

        tf_ap_check_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Cheque No:");

        tf_ap_check_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_check_noActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Cheque Date:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setText("Check Amount:");

        tf_ap_cash5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash5ActionPerformed(evt);
            }
        });
        tf_ap_cash5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash5KeyReleased(evt);
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_or_payment_no)
                            .addComponent(tf_check_bank)
                            .addComponent(tf_ap_check_no)
                            .addComponent(tf_ap_check_holder)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_ap_cash5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 273, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_or_payment_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check", jPanel3);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Customer Name:");

        tf_prepaid_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_prepaid_customer_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_prepaid_customer_nameMouseClicked(evt);
            }
        });
        tf_prepaid_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_prepaid_customer_nameActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Customer ID:");

        tf_prepaid_customer_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_prepaid_customer_id.setFocusable(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Balance:");

        tf_prepaid_balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_prepaid_balance.setText("0.00");
        tf_prepaid_balance.setFocusable(false);
        tf_prepaid_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_prepaid_balanceActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("Prepaid Amount:");

        tf_ap_cash6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_ap_cash6MouseClicked(evt);
            }
        });
        tf_ap_cash6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash6ActionPerformed(evt);
            }
        });
        tf_ap_cash6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash6KeyReleased(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_prepaid_customer_id)
                    .addComponent(tf_prepaid_balance)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tf_ap_cash6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 257, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tf_prepaid_customer_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        jTabbedPane1.addTab("Prepaid", jPanel5);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Card Type:");

        tf_credit_card_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_card_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_credit_card_typeActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Rate:");

        lbl_credit_card_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credit_card_rate.setText("0.00");
        lbl_credit_card_rate.setFocusable(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Card Number:");

        tf_prepaid_customer_id3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("%");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Card Holder:");

        tf_prepaid_customer_id4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Approval Code:");

        tf_prepaid_customer_id5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_credit_card_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_card_amount.setText("0.00");
        tf_credit_card_amount.setFocusable(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Rate Amount:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("CC Amount:");

        tf_ap_cash7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash7ActionPerformed(evt);
            }
        });
        tf_ap_cash7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash7KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_prepaid_customer_id3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_prepaid_customer_id4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_prepaid_customer_id5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_ap_cash7))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_credit_card_type)
                            .addComponent(tf_credit_card_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_credit_card_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_ap_cash7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_credit_card_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Credit Card", jPanel7);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("From:");

        tf_prepaid_customer_id9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Description:");

        tf_prepaid_customer_id10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("GC No.:");

        tf_prepaid_customer_id11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("GC Amount:");

        tf_ap_cash8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash8ActionPerformed(evt);
            }
        });
        tf_ap_cash8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash8KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_prepaid_customer_id10, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_prepaid_customer_id11, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_prepaid_customer_id9, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(tf_ap_cash8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gift Certificate", jPanel8);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Holder:");

        tf_prepaid_customer_id6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Bank:");

        tf_prepaid_customer_id7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_prepaid_customer_id7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_prepaid_customer_id7ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Reference No.:");

        tf_prepaid_customer_id8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("Date:");

        jDateChooser5.setDate(new Date());
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_ap_cash9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash9ActionPerformed(evt);
            }
        });
        tf_ap_cash9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash9KeyReleased(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("Online Amount:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_prepaid_customer_id7, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_prepaid_customer_id8, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(tf_ap_cash9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tf_prepaid_customer_id6))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_prepaid_customer_id8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Online", jPanel9);

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel54.setText("Retention Amount:");

        tf_ap_cash11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash11ActionPerformed(evt);
            }
        });
        tf_ap_cash11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash11KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel54)
                .addGap(4, 4, 4)
                .addComponent(tf_ap_cash11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Retention", jPanel12);

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Amount:");

        tf_ap_cash12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash12ActionPerformed(evt);
            }
        });
        tf_ap_cash12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash12KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel55)
                .addGap(4, 4, 4)
                .addComponent(tf_ap_cash12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Business Tax", jPanel13);

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("Amount:");

        tf_ap_cash13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ap_cash13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_cash13ActionPerformed(evt);
            }
        });
        tf_ap_cash13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash13KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel56)
                .addGap(4, 4, 4)
                .addComponent(tf_ap_cash13, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Salary Deduction", jPanel14);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Total Tendered:");

        tf_ap_cash10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tf_ap_cash10.setText("0.00");
        tf_ap_cash10.setFocusable(false);
        tf_ap_cash10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_ap_cash10KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ap_cash10)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_cash10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tf_ap_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_check_noActionPerformed

    }//GEN-LAST:event_tf_ap_check_noActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_check_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_bankActionPerformed
        init_banks(tf_check_bank);
    }//GEN-LAST:event_tf_check_bankActionPerformed

    private void tf_ap_cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cashKeyReleased
        compute_check();
        compute_tax();
    }//GEN-LAST:event_tf_ap_cashKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_check_bankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_check_bankMouseClicked

    }//GEN-LAST:event_tf_check_bankMouseClicked

    private void tf_ap_cash1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash1KeyReleased
        compute_tax();
    }//GEN-LAST:event_tf_ap_cash1KeyReleased

    private void tf_ap_cash2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash2KeyReleased
        compute_tax();
    }//GEN-LAST:event_tf_ap_cash2KeyReleased

    private void tf_discount_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_nameMouseClicked
        init_discount();
    }//GEN-LAST:event_tf_discount_nameMouseClicked

    private void tf_discount_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_nameActionPerformed
        init_discount();
    }//GEN-LAST:event_tf_discount_nameActionPerformed

    private void tf_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_amountActionPerformed

    }//GEN-LAST:event_tf_discount_amountActionPerformed

    private void tf_prepaid_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_prepaid_customer_nameActionPerformed
        init_customers();
    }//GEN-LAST:event_tf_prepaid_customer_nameActionPerformed

    private void tf_prepaid_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_prepaid_customer_nameMouseClicked

    }//GEN-LAST:event_tf_prepaid_customer_nameMouseClicked

    private void tf_credit_card_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_credit_card_typeActionPerformed
        init_credit_cards();
    }//GEN-LAST:event_tf_credit_card_typeActionPerformed

    private void tf_prepaid_customer_id7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_prepaid_customer_id7ActionPerformed
        init_banks(tf_prepaid_customer_id7);
    }//GEN-LAST:event_tf_prepaid_customer_id7ActionPerformed

    private void tf_ap_cash3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_cash3KeyReleased

    private void tf_ap_cash4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash4KeyReleased
        count_tender();

    }//GEN-LAST:event_tf_ap_cash4KeyReleased

    private void tf_ap_cash4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash4ActionPerformed
    }//GEN-LAST:event_tf_ap_cash4ActionPerformed

    private void tf_ap_cash5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash5ActionPerformed
        count_tender();
    }//GEN-LAST:event_tf_ap_cash5ActionPerformed

    private void tf_ap_cash5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash5KeyReleased
        count_tender();
    }//GEN-LAST:event_tf_ap_cash5KeyReleased

    private void tf_ap_cash6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash6ActionPerformed

    }//GEN-LAST:event_tf_ap_cash6ActionPerformed

    private void tf_ap_cash6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash6KeyReleased
        if (tf_prepaid_customer_id.getText().isEmpty()) {
            tf_prepaid_customer_name.grabFocus();
            tf_ap_cash6.setText("");
            return;
        }
        count_tender();
    }//GEN-LAST:event_tf_ap_cash6KeyReleased

    private void tf_ap_cash7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash7ActionPerformed

    }//GEN-LAST:event_tf_ap_cash7ActionPerformed

    private void tf_ap_cash7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash7KeyReleased
        count_tender();
    }//GEN-LAST:event_tf_ap_cash7KeyReleased

    private void tf_ap_cash8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash8ActionPerformed

    }//GEN-LAST:event_tf_ap_cash8ActionPerformed

    private void tf_ap_cash8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash8KeyReleased
        count_tender();
    }//GEN-LAST:event_tf_ap_cash8KeyReleased

    private void tf_ap_cash9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash9ActionPerformed

    }//GEN-LAST:event_tf_ap_cash9ActionPerformed

    private void tf_ap_cash9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash9KeyReleased
        count_tender();
    }//GEN-LAST:event_tf_ap_cash9KeyReleased

    private void tf_ap_cash10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_cash10KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tf_ap_cash6.setText("0.00");
        tf_prepaid_customer_name.setText("");
        tf_prepaid_customer_id.setText("");
        tf_prepaid_balance.setText("0.00");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_ap_cash6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_ap_cash6MouseClicked
        if (tf_prepaid_customer_id.getText().isEmpty()) {
            Alert.set(0, "Please select account!");

            tf_prepaid_customer_name.grabFocus();

        }
    }//GEN-LAST:event_tf_ap_cash6MouseClicked

    private void tf_prepaid_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_prepaid_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_prepaid_balanceActionPerformed

    private void tf_discount_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discount_amountKeyReleased
        count_tender();
    }//GEN-LAST:event_tf_discount_amountKeyReleased

    private void tf_ap_cash11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash11ActionPerformed
        count_tender();
    }//GEN-LAST:event_tf_ap_cash11ActionPerformed

    private void tf_ap_cash11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash11KeyReleased
        count_tender();
    }//GEN-LAST:event_tf_ap_cash11KeyReleased

    private void tf_ap_cash12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash12ActionPerformed
        count_tender();
    }//GEN-LAST:event_tf_ap_cash12ActionPerformed

    private void tf_ap_cash12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash12KeyReleased
        count_tender();
    }//GEN-LAST:event_tf_ap_cash12KeyReleased

    private void tf_ap_cash13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_cash13ActionPerformed
        count_tender();
    }//GEN-LAST:event_tf_ap_cash13ActionPerformed

    private void tf_ap_cash13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ap_cash13KeyReleased
        count_tender();
    }//GEN-LAST:event_tf_ap_cash13KeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox3;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lbl_credit_card_rate;
    private javax.swing.JTextField tf_ap_cash;
    private javax.swing.JTextField tf_ap_cash1;
    private javax.swing.JTextField tf_ap_cash10;
    private javax.swing.JTextField tf_ap_cash11;
    private javax.swing.JTextField tf_ap_cash12;
    private javax.swing.JTextField tf_ap_cash13;
    private javax.swing.JTextField tf_ap_cash2;
    private javax.swing.JTextField tf_ap_cash3;
    private javax.swing.JTextField tf_ap_cash4;
    private javax.swing.JTextField tf_ap_cash5;
    private javax.swing.JTextField tf_ap_cash6;
    private javax.swing.JTextField tf_ap_cash7;
    private javax.swing.JTextField tf_ap_cash8;
    private javax.swing.JTextField tf_ap_cash9;
    private javax.swing.JTextField tf_ap_check_holder;
    private javax.swing.JTextField tf_ap_check_no;
    private javax.swing.JTextField tf_check_bank;
    private javax.swing.JTextField tf_credit_card_amount;
    private javax.swing.JTextField tf_credit_card_type;
    private javax.swing.JTextField tf_discount_amount;
    private javax.swing.JTextField tf_discount_name;
    private javax.swing.JTextField tf_discount_rate;
    private javax.swing.JTextField tf_or_payment_no;
    private javax.swing.JTextField tf_prepaid_balance;
    private javax.swing.JTextField tf_prepaid_customer_id;
    private javax.swing.JTextField tf_prepaid_customer_id10;
    private javax.swing.JTextField tf_prepaid_customer_id11;
    private javax.swing.JTextField tf_prepaid_customer_id3;
    private javax.swing.JTextField tf_prepaid_customer_id4;
    private javax.swing.JTextField tf_prepaid_customer_id5;
    private javax.swing.JTextField tf_prepaid_customer_id6;
    private javax.swing.JTextField tf_prepaid_customer_id7;
    private javax.swing.JTextField tf_prepaid_customer_id8;
    private javax.swing.JTextField tf_prepaid_customer_id9;
    private javax.swing.JTextField tf_prepaid_customer_name;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
        init_key();
        focus();
        tf_ap_cash.grabFocus();
        set_default_branch();
        tf_ap_cash4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
        JTextField[] tf = {tf_ap_cash, tf_or_payment_no, tf_check_bank, tf_ap_check_holder, tf_ap_cash, tf_ap_check_no};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    double amount = 1000;

    public void do_pass(double balance) {
        tf_ap_cash.setText(FitIn.fmt_wc_0(balance));
        tf_ap_cash3.setText(FitIn.fmt_wc_0(balance));
        amount = balance;
        compute_tax();
    }
    int update = 0;

    public void do_pass2(double balance, String date_applied, double cash, String or_no, String check_bank, String check_holder, double check_amoumt, String check_no, String check_date, double tax_rate, double tax_amount) {
        try {
            jDateChooser3.setDate(DateType.sf.parse(date_applied));
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_ar_add_payment.class.getName()).log(Level.SEVERE, null, ex);
        }

        tf_ap_check_holder.setText(check_holder);
        tf_ap_check_no.setText(check_no);
        tf_check_bank.setText(check_bank);
        tf_or_payment_no.setText(or_no);
        tf_ap_cash1.setText(FitIn.fmt_wc_0(tax_rate));
        tf_ap_cash2.setText(FitIn.fmt_wc_0(tax_amount));
        compute_tax();
        try {
            Date d = DateType.sf.parse(check_date);
            jDateChooser4.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_ar_add_payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check_amoumt > 0) {

            tf_check_bank.setEnabled(true);
            tf_ap_check_holder.setEnabled(true);
            tf_ap_check_no.setEnabled(true);
            jDateChooser4.setEnabled(true);
            tf_ap_cash.setText(FitIn.fmt_wc_0(check_amoumt));
        } else {
            tf_check_bank.setEnabled(false);
            tf_ap_check_holder.setEnabled(false);
            tf_ap_check_no.setEnabled(false);
            jDateChooser4.setEnabled(false);
            tf_ap_cash.setText(FitIn.fmt_wc_0(cash));
        }

        amount = balance;
        update = 1;
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

    List<Banks.to_banks> bank_list = new ArrayList();

    private void init_banks(final JTextField tf) {
        String search = tf_check_bank.getText();
        bank_list.clear();
        String where = " where bank_name like '%" + search + "%' order by bank_name asc";
        bank_list = Banks.ret_data2(where);
        Object[][] obj = new Object[bank_list.size()][1];
        int i = 0;
        for (Banks.to_banks to : bank_list) {

            obj[i][0] = " " + to.bank_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_check_bank.getWidth()};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Banks.to_banks to = bank_list.get(data.selected_row);
                tf.setText(to.bank_name);

            }
        });
    }

    private void compute_cash() {
        if (update == 0) {
            double cash = FitIn.toDouble(tf_ap_cash.getText());
            double check = FitIn.toDouble(tf_ap_cash.getText());

            double total = cash + check;
            if (total > amount) {
                total = amount - check;
                tf_ap_cash.setText(FitIn.fmt_wc_0(total));
            }
        }

    }

    private void compute_check() {
        if (update == 0) {
            double cash = FitIn.toDouble(tf_ap_cash.getText());
            double check = FitIn.toDouble(tf_ap_cash.getText());
            if (cash > amount) {
                tf_ap_cash.setText(FitIn.fmt_wc_0(amount));
            }
        }

    }

    private void select_type() {

    }

    private void compute_tax() {
        double tendered = FitIn.toDouble(tf_ap_cash.getText());
        double tax_rate = FitIn.toDouble(tf_ap_cash1.getText()) / 100;
        double tax_amount = 0;
        tax_amount = tendered - ((tendered / 1.12) * tax_rate);
        if (jCheckBox3.isSelected()) {
            tax_amount = tendered - (tendered * tax_rate);
        }
        tf_ap_cash2.setText(FitIn.fmt_wc_0(tax_amount));
    }

    private void ok() {
        String date_applied = DateType.sf.format(jDateChooser3.getDate());
        double cash = FitIn.toDouble(tf_ap_cash4.getText());
        String or_no = tf_or_payment_no.getText();
        String check_bank = tf_check_bank.getText();
        String check_holder = tf_ap_check_holder.getText();
        double check_amount = FitIn.toDouble(tf_ap_cash5.getText());
        String check_no = tf_ap_check_no.getText();
        String check_date = DateType.sf.format(jDateChooser3.getDate());
        double tax_rate = FitIn.toDouble(tf_ap_cash1.getText());
        double tax_amount = FitIn.toDouble(tf_ap_cash2.getText());

        String discount = tf_discount_name.getText();
        double discount_rate = FitIn.toDouble(tf_discount_rate.getText());
        double discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        String prepaid_customer_name = tf_prepaid_customer_name.getText();
        String prepaid_customer_id = tf_prepaid_customer_id.getText();
        double prepaid_amount = FitIn.toDouble(tf_ap_cash6.getText());
        String credit_card_type = tf_credit_card_type.getText();
        double credit_card_rate = FitIn.toDouble(lbl_credit_card_rate.getText());
        String credit_card_no = tf_prepaid_customer_id5.getText();
        String credit_card_holder = tf_prepaid_customer_id4.getText();
        double credit_card_amount = FitIn.toDouble(tf_ap_cash7.getText());
        String gift_certificate_from = tf_prepaid_customer_id9.getText();
        String gift_certificate_description = tf_prepaid_customer_id10.getText();
        String gift_certificate_no = tf_prepaid_customer_id11.getText();
        double gift_certificate_amount = FitIn.toDouble(tf_ap_cash8.getText());
        String online_bank = tf_prepaid_customer_id7.getText();
        String online_reference_no = tf_prepaid_customer_id8.getText();
        String online_holder = tf_prepaid_customer_id6.getText();
        String online_date = DateType.sf.format(jDateChooser5.getDate());
        double online_amount = FitIn.toDouble(tf_ap_cash9.getText());

        cash = FitIn.toDouble(tf_ap_cash4.getText());
        check_amount = FitIn.toDouble(tf_ap_cash5.getText());
        prepaid_amount = FitIn.toDouble(tf_ap_cash6.getText());
        credit_card_amount = FitIn.toDouble(tf_ap_cash7.getText());
        gift_certificate_amount = FitIn.toDouble(tf_ap_cash8.getText());
        online_amount = FitIn.toDouble(tf_ap_cash9.getText());

        double total_tendered = FitIn.toDouble(tf_ap_cash10.getText());
        double discount1 = FitIn.toDouble(tf_discount_amount.getText());
        double tendered = FitIn.toDouble(tf_ap_cash2.getText());
        double retention = FitIn.toDouble(tf_ap_cash11.getText());
        double business_tax = FitIn.toDouble(tf_ap_cash12.getText());
        double salary_deduction = FitIn.toDouble(tf_ap_cash13.getText());
        if (total_tendered != tendered) {
            Alert.set(0, "Not enough amount entered!");
            return;
        }
        double actual_tendered = FitIn.toDouble(tf_ap_cash.getText());

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(date_applied, cash, or_no, check_bank, check_holder, check_amount, check_no, check_date, tax_rate,
                                                              tax_amount, discount, discount_rate, discount_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type,
                                                              credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description,
                                                              gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder,
                                                              online_date, online_amount, actual_tendered, retention, business_tax, salary_deduction));
        }
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
                        S1_discounts.to_discounts to = discount_list.get(data.selected_row);
                        tf_discount_amount.setText(FitIn.fmt_wc_0(0));
                        tf_discount_rate.setText(FitIn.fmt_wc_0(to.discount_rate));
                        tf_discount_name.setText(to.discount_name);
                        double rate = to.discount_rate;
                        rate = rate / 100;
                        rate = rate * amount;
                        tf_discount_amount.setText(FitIn.fmt_wc_0(rate));
                        tf_discount_amount.grabFocus();

                    }
                });

            }
        });
    }

    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_customers() {
        String search = tf_prepaid_customer_name.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' and branch_id='" + my_branch_id + "' order by customer_name asc";
        customer_list = Customers.ret_data3(where);
        Object[][] obj = new Object[customer_list.size()][2];
        int i = 0;
        for (Customers.to_customers to : customer_list) {

            obj[i][0] = " " + to.customer_name;
            obj[i][1] = " " + FitIn.fmt_wc_0(to.prepaid);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {250, 90};
        int width = 0;
        String[] col_names = {"", "Balance"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_prepaid_customer_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_prepaid_customer_name.setText(to.customer_name);
                tf_prepaid_customer_id.setText("" + to.id);
                tf_prepaid_balance.setText(FitIn.fmt_wc_0(to.prepaid));
                tf_ap_cash6.grabFocus();
            }
        });
    }

    private void ar_payment_prepaid(final Customers.to_customers to) {
        Window p = (Window) this;
        Dlg_ar_payment_prepaid nd = Dlg_ar_payment_prepaid.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.prepaid);
        nd.setCallback(new Dlg_ar_payment_prepaid.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_payment_prepaid.OutputData data) {
                closeDialog.ok();

                double cash = FitIn.toDouble(tf_ap_cash4.getText());
                double check = FitIn.toDouble(tf_ap_cash5.getText());
                double prepaid = FitIn.toDouble(tf_ap_cash6.getText());
                double credit_card = FitIn.toDouble(tf_ap_cash7.getText());
                double gift_certificate = FitIn.toDouble(tf_ap_cash8.getText());
                double online = FitIn.toDouble(tf_ap_cash9.getText());

                double tendered = FitIn.toDouble(tf_ap_cash.getText());
                double total_tendered = FitIn.toDouble(tf_ap_cash10.getText());

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    List<S1_credit_cards.to_credit_cards> credit_card_list = new ArrayList();

    private void init_credit_cards() {
        String search = tf_credit_card_type.getText();
        credit_card_list.clear();
        String where = " where name like '%" + search + "%' order by name asc";
        credit_card_list = S1_credit_cards.ret_data2(where);
        Object[][] obj = new Object[credit_card_list.size()][2];
        int i = 0;
        for (S1_credit_cards.to_credit_cards to : credit_card_list) {
            obj[i][0] = " " + FitIn.fmt_wc_0(to.rate);
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {40, 50};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_credit_card_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_credit_cards.to_credit_cards to = credit_card_list.get(data.selected_row);
                tf_credit_card_type.setText(to.name);
                lbl_credit_card_rate.setText(FitIn.fmt_wc_0(to.rate));
                if (to.id == 0) {
                    lbl_credit_card_rate.setText("");
                    tf_credit_card_amount.setText("");
                    tf_credit_card_type.setText("");

                } else {
                    double rate = FitIn.toDouble(lbl_credit_card_rate.getText());
                    double amount = FitIn.toDouble(tf_ap_cash7.getText());

                    rate = rate / 100;
                    rate = rate * amount;
                    rate = amount + rate;
                    System.out.println("rate: " + rate);
                    tf_credit_card_amount.setText(FitIn.fmt_wc_0(rate));
                }

                tf_credit_card_amount.grabFocus();

            }
        });
    }

    private void count_tender() {
        double cash = FitIn.toDouble(tf_ap_cash4.getText());
        double check = FitIn.toDouble(tf_ap_cash5.getText());
        double prepaid = FitIn.toDouble(tf_ap_cash6.getText());
        double credit_card = FitIn.toDouble(tf_ap_cash7.getText());
        double gift_certificate = FitIn.toDouble(tf_ap_cash8.getText());
        double online = FitIn.toDouble(tf_ap_cash9.getText());
        double retention = FitIn.toDouble(tf_ap_cash11.getText());
        double business_tax = FitIn.toDouble(tf_ap_cash12.getText());
        double salary_deductoin = FitIn.toDouble(tf_ap_cash13.getText());
        double discount = FitIn.toDouble(tf_discount_amount.getText());
        double tendered = FitIn.toDouble(tf_ap_cash2.getText());

        double total_tendered = cash + check + prepaid + credit_card + gift_certificate + online + discount + retention + business_tax + salary_deductoin;

        tf_ap_cash10.setText(FitIn.fmt_wc_0(total_tendered));

        double remaining = tendered - total_tendered;

        double total_for_cash = check + prepaid + credit_card + gift_certificate + online + retention + business_tax + salary_deductoin;
        double total_for_check = cash + prepaid + credit_card + gift_certificate + online + retention + business_tax + salary_deductoin;
        double total_for_prepaid = cash + check + credit_card + gift_certificate + online + retention + business_tax + salary_deductoin;
        double total_for_credit_card = cash + check + prepaid + gift_certificate + online + retention + business_tax + salary_deductoin;
        double total_for_gift_certificate = cash + check + prepaid + credit_card + online + retention + business_tax + salary_deductoin;
        double total_for_online = cash + check + prepaid + credit_card + gift_certificate + retention + business_tax + salary_deductoin;
        double total_for_retention = cash + check + prepaid + credit_card + gift_certificate + online + business_tax + salary_deductoin;
        double total_for_business_tax = cash + check + prepaid + credit_card + gift_certificate + online + retention + salary_deductoin;
        double total_for_salary_deduction = cash + check + prepaid + credit_card + gift_certificate + online + retention + business_tax;
        if (remaining < 0 && tf_ap_cash4.hasFocus()) {
            remaining = (tendered - total_for_cash) - discount;
            tf_ap_cash4.setText(FitIn.fmt_wc_0(remaining));
        }
        if (remaining < 0 && tf_ap_cash5.hasFocus()) {
            remaining = (tendered - total_for_check) - discount;
            tf_ap_cash5.setText(FitIn.fmt_wc_0(remaining));
        }
        if (remaining < 0 && tf_ap_cash6.hasFocus()) {
            double prepaid_balance = FitIn.toDouble(tf_prepaid_balance.getText());
            remaining = (tendered - total_for_prepaid) - discount;
            tf_ap_cash6.setText(FitIn.fmt_wc_0(remaining));
            if (prepaid_balance < remaining) {
                tf_ap_cash6.setText(FitIn.fmt_wc_0(prepaid_balance));
            }

        }
        if (remaining > 0 && tf_ap_cash6.hasFocus()) {
            double prepaid_balance = FitIn.toDouble(tf_prepaid_balance.getText());
            if (prepaid > prepaid_balance) {
                tf_ap_cash6.setText(FitIn.fmt_wc_0(prepaid_balance));
            }
        }
        if (remaining < 0 && tf_ap_cash7.hasFocus()) {
            remaining = (tendered - total_for_credit_card) - discount;
            tf_ap_cash7.setText(FitIn.fmt_wc_0(remaining));
        }
        if (remaining < 0 && tf_ap_cash8.hasFocus()) {
            remaining = (tendered - total_for_gift_certificate) - discount;
            tf_ap_cash8.setText(FitIn.fmt_wc_0(remaining));
        }
        if (remaining < 0 && tf_ap_cash9.hasFocus()) {
            remaining = (tendered - total_for_online) - discount;
            tf_ap_cash9.setText(FitIn.fmt_wc_0(remaining));
        }
        if (remaining < 0 && tf_ap_cash11.hasFocus()) {
            remaining = (tendered - total_for_retention) - discount;
            tf_ap_cash11.setText(FitIn.fmt_wc_0(remaining));
        }
        if (remaining < 0 && tf_ap_cash12.hasFocus()) {
            remaining = (tendered - total_for_business_tax) - discount;
            tf_ap_cash12.setText(FitIn.fmt_wc_0(remaining));
        }
        if (remaining < 0 && tf_ap_cash13.hasFocus()) {
            remaining = (tendered - total_for_salary_deduction) - discount;
            tf_ap_cash13.setText(FitIn.fmt_wc_0(remaining));
        }
        check_total_tendered();
    }

    private void check_total_tendered() {
        double cash = FitIn.toDouble(tf_ap_cash4.getText());
        double check = FitIn.toDouble(tf_ap_cash5.getText());
        double prepaid = FitIn.toDouble(tf_ap_cash6.getText());
        double credit_card = FitIn.toDouble(tf_ap_cash7.getText());
        double gift_certificate = FitIn.toDouble(tf_ap_cash8.getText());
        double online = FitIn.toDouble(tf_ap_cash9.getText());
        double discount = FitIn.toDouble(tf_discount_amount.getText());
        double retention = FitIn.toDouble(tf_ap_cash11.getText());
        double business_tax = FitIn.toDouble(tf_ap_cash12.getText());
        double salary_deduction = FitIn.toDouble(tf_ap_cash13.getText());
        double total_tendered = cash + check + prepaid + credit_card + gift_certificate + online + discount + retention + business_tax+salary_deduction;
        tf_ap_cash10.setText(FitIn.fmt_wc_0(total_tendered));
    }
}
