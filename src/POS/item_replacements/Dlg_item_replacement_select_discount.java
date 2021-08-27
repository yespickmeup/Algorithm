/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.item_replacements;

import POS.accounts_receivable.S1_account_receivable_types;
import POS.accounts_receivable.S1_sales_on_account;
import POS.banks.Banks;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.credit_cards.S1_credit_cards;
import POS.customers.Customers;
import POS.touchscreen.Payments;
import POS.util.Alert;
import POS.util.Center;
import POS.util.TableRenderer;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.Timer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Dlg_item_replacement_select_discount extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_item_replacement_select_discount
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

        public final double discount;
        public final double cash_amount;

        public final String check_holder;
        public final String check_bank;
        public final String check_no;
        public final String check_date;
        public final double check_amount;

        public final String card_type;
        public final double credit_card_rate;
        public final double credit_card_amount;
        public final double credit_card_amount_to_pay;
        public final String credit_card_no;
        public final String credit_card_holder;
        public final String credit_card_approval_code;

        public final String prepaid_customer_name;
        public final String prepaid_customer_id;
        public final double prepaid_amount;

        public final String charge_reference_no;
        public final String charge_ar_no;
        public final String charge_type;
        public final String charge_customer_name;
        public final String charge_customer_id;
        public final double charge_amount;
        public final int charge_dayes;

        public final String gc_from;
        public final String gc_description;
        public final String gc_no;
        public final double gc_amount;

        public final String online_holder;
        public final String online_bank;
        public final String online_reference_no;
        public final String online_date;
        public final double online_amount;

        public OutputData(double discount, double cash_amount, String check_holder, String check_bank, String check_no, String check_date, double check_amount, String card_type, double credit_card_rate, double credit_card_amount, double credit_card_amount_to_pay, String credit_card_no, String credit_card_holder, String credit_card_approval_code, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String charge_reference_no, String charge_ar_no, String charge_type, String charge_customer_name, String charge_customer_id, double charge_amount, int charge_dayes, String gc_from, String gc_description, String gc_no, double gc_amount, String online_holder, String online_bank, String online_reference_no, String online_date, double online_amount) {
            this.discount = discount;
            this.cash_amount = cash_amount;
            this.check_holder = check_holder;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_date = check_date;
            this.check_amount = check_amount;
            this.card_type = card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.credit_card_amount_to_pay = credit_card_amount_to_pay;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_approval_code = credit_card_approval_code;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.charge_reference_no = charge_reference_no;
            this.charge_ar_no = charge_ar_no;
            this.charge_type = charge_type;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.charge_dayes = charge_dayes;
            this.gc_from = gc_from;
            this.gc_description = gc_description;
            this.gc_no = gc_no;
            this.gc_amount = gc_amount;
            this.online_holder = online_holder;
            this.online_bank = online_bank;
            this.online_reference_no = online_reference_no;
            this.online_date = online_date;
            this.online_amount = online_amount;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_item_replacement_select_discount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_item_replacement_select_discount(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_item_replacement_select_discount() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_item_replacement_select_discount myRef;

    private void setThisRef(Dlg_item_replacement_select_discount myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_item_replacement_select_discount> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_item_replacement_select_discount create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_item_replacement_select_discount create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_item_replacement_select_discount dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_item_replacement_select_discount((java.awt.Frame) parent, false);
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
            Dlg_item_replacement_select_discount dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_item_replacement_select_discount((java.awt.Dialog) parent, false);
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

        Dlg_item_replacement_select_discount dialog = Dlg_item_replacement_select_discount.create(new javax.swing.JFrame(), true);
        Center.setCenter(dialog);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jButton1 = new Button.Success();
        jLabel20 = new javax.swing.JLabel();
        jTextField8 = new Field.Input();
        tp_payments = new javax.swing.JTabbedPane();
        pnl_cash = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tf_cash = new Field.Input();
        pnl_check = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        tf_cheque_holder = new Field.Input_w_clear();
        jLabel21 = new javax.swing.JLabel();
        tf_bank = new Field.Combo();
        jLabel22 = new javax.swing.JLabel();
        tf_check_no = new Field.Input_w_clear();
        jLabel23 = new javax.swing.JLabel();
        tf_check_date = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        tf_check_amount = new Field.Input();
        pnl_credit_card = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_credit_card_type = new Field.Combo();
        lbl_credit_card_rate = new Field.Input();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_credit_card_amount = new Field.Input();
        tf_cc_topay = new Field.Input();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_card_no = new Field.Input_w_clear();
        tf_card_holder = new Field.Input_w_clear();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_approval_code = new Field.Input_w_clear();
        pnl_prepayment = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tf_customer_name = new Field.Combo();
        jLabel13 = new javax.swing.JLabel();
        tf_customer_id = new Field.Input();
        jLabel14 = new javax.swing.JLabel();
        tf_balance = new Field.Input();
        jLabel16 = new javax.swing.JLabel();
        tf_amount1 = new Field.Input();
        jLabel17 = new javax.swing.JLabel();
        pnl_charge = new javax.swing.JPanel();
        tf_charge_type = new Field.Combo();
        jLabel25 = new javax.swing.JLabel();
        tf_reference_no = new Field.Input();
        jLabel26 = new javax.swing.JLabel();
        tf_customer_name1 = new Field.Input();
        jLabel27 = new javax.swing.JLabel();
        tf_customer_id1 = new Field.Input();
        jLabel28 = new javax.swing.JLabel();
        tf_amount2 = new Field.Input();
        jLabel29 = new javax.swing.JLabel();
        tf_amount3 = new Field.Input();
        jLabel30 = new javax.swing.JLabel();
        tf_charge_type1 = new Field.Search();
        jLabel36 = new javax.swing.JLabel();
        pnl_gc = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_from = new Field.Input_w_clear();
        jLabel9 = new javax.swing.JLabel();
        tf_description = new Field.Input_w_clear();
        tf_gc_no = new Field.Input_w_clear();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_amount = new Field.Input();
        pnl_online = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        tf_cheque_holder1 = new Field.Input_w_clear();
        jLabel32 = new javax.swing.JLabel();
        tf_bank1 = new Field.Combo();
        jLabel33 = new javax.swing.JLabel();
        tf_check_no1 = new Field.Input_w_clear();
        jLabel34 = new javax.swing.JLabel();
        tf_check_date1 = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        tf_amount4 = new Field.Input();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Proceed Posting Transaction");

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Discount:");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        tp_payments.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tp_payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tp_paymentsMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Amount:");

        tf_cash.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cash.setFocusable(false);
        tf_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_cashLayout = new javax.swing.GroupLayout(pnl_cash);
        pnl_cash.setLayout(pnl_cashLayout);
        pnl_cashLayout.setHorizontalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cashLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_cash, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        pnl_cashLayout.setVerticalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cashLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        tp_payments.addTab("Cash", pnl_cash);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Holder:");

        tf_cheque_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_holder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_holderActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Bank:");

        tf_bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_bank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_bankMouseClicked(evt);
            }
        });
        tf_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bankActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Check No:");

        tf_check_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_noActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Date:");

        tf_check_date.setDate(new Date());
        tf_check_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Amount:");

        tf_check_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_amount.setFocusable(false);
        tf_check_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_amountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_checkLayout = new javax.swing.GroupLayout(pnl_check);
        pnl_check.setLayout(pnl_checkLayout);
        pnl_checkLayout.setHorizontalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_check_amount)
                    .addComponent(tf_cheque_holder)
                    .addComponent(tf_check_no)
                    .addComponent(tf_bank, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_checkLayout.createSequentialGroup()
                        .addComponent(tf_check_date, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_checkLayout.setVerticalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_checkLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cheque_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_check_no)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_checkLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_check_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_checkLayout.createSequentialGroup()
                        .addComponent(tf_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        tp_payments.addTab("Check", pnl_check);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Card Type:");

        tf_credit_card_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_card_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_credit_card_typeMouseClicked(evt);
            }
        });
        tf_credit_card_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_credit_card_typeActionPerformed(evt);
            }
        });

        lbl_credit_card_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credit_card_rate.setFocusable(false);
        lbl_credit_card_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_credit_card_rateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Rate:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Amount:");

        tf_credit_card_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_card_amount.setFocusable(false);
        tf_credit_card_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_credit_card_amountActionPerformed(evt);
            }
        });
        tf_credit_card_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_credit_card_amountKeyReleased(evt);
            }
        });

        tf_cc_topay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_topay.setText("0.00");
        tf_cc_topay.setFocusable(false);
        tf_cc_topay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cc_topayActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("To Pay:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Card No:");

        tf_card_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_card_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_card_noActionPerformed(evt);
            }
        });

        tf_card_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_card_holder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_card_holderActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Card Holder:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Approval Code:");

        tf_approval_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_approval_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_approval_codeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_credit_cardLayout = new javax.swing.GroupLayout(pnl_credit_card);
        pnl_credit_card.setLayout(pnl_credit_cardLayout);
        pnl_credit_cardLayout.setHorizontalGroup(
            pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_credit_cardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                        .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_card_holder, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_card_no)
                            .addComponent(tf_approval_code, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tf_cc_topay))
                        .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                            .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_credit_card_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_credit_card_type, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnl_credit_cardLayout.setVerticalGroup(
            pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_credit_card_type, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_credit_card_rate)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_credit_card_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cc_topay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_card_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_approval_code, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_payments.addTab("Credit Card", pnl_credit_card);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.red);
        jLabel12.setText("Attention: Insufficient Balance");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_customer_nameMouseClicked(evt);
            }
        });
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Customer Name");

        tf_customer_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_id.setFocusable(false);
        tf_customer_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_idActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Customer Id:");

        tf_balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_balance.setFocusable(false);
        tf_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_balanceActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Balance");

        tf_amount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount1.setFocusable(false);
        tf_amount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amount1ActionPerformed(evt);
            }
        });
        tf_amount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amount1KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Amount:");

        javax.swing.GroupLayout pnl_prepaymentLayout = new javax.swing.GroupLayout(pnl_prepayment);
        pnl_prepayment.setLayout(pnl_prepaymentLayout);
        pnl_prepaymentLayout.setHorizontalGroup(
            pnl_prepaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_prepaymentLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnl_prepaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_id)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_name)
                    .addComponent(tf_amount1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_balance)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnl_prepaymentLayout.setVerticalGroup(
            pnl_prepaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_prepaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addGap(5, 5, 5)
                .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14)
                .addGap(5, 5, 5)
                .addComponent(tf_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addGap(25, 25, 25)
                .addComponent(tf_amount1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_payments.addTab("Prepaid", pnl_prepayment);

        tf_charge_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_charge_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_charge_typeMouseClicked(evt);
            }
        });
        tf_charge_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_charge_typeActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Charge Type:");

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Reference No:");

        tf_customer_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_name1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Customer Name:");

        tf_customer_id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_id1.setFocusable(false);
        tf_customer_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_id1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Customer Id:");

        tf_amount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount2.setFocusable(false);
        tf_amount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amount2ActionPerformed(evt);
            }
        });
        tf_amount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amount2KeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Amount:");

        tf_amount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount3.setText("30");
        tf_amount3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amount3ActionPerformed(evt);
            }
        });
        tf_amount3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amount3KeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Days:");

        tf_charge_type1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_charge_type1.setFocusable(false);
        tf_charge_type1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_charge_type1MouseClicked(evt);
            }
        });
        tf_charge_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_charge_type1ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("AR Transaction No.");

        javax.swing.GroupLayout pnl_chargeLayout = new javax.swing.GroupLayout(pnl_charge);
        pnl_charge.setLayout(pnl_chargeLayout);
        pnl_chargeLayout.setHorizontalGroup(
            pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_chargeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_reference_no)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_name1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_id1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_chargeLayout.createSequentialGroup()
                        .addGroup(pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_amount2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_amount3)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_chargeLayout.createSequentialGroup()
                        .addGroup(pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(tf_charge_type))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_charge_type1)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        pnl_chargeLayout.setVerticalGroup(
            pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_chargeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_chargeLayout.createSequentialGroup()
                        .addComponent(tf_charge_type, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel25))
                    .addGroup(pnl_chargeLayout.createSequentialGroup()
                        .addComponent(tf_charge_type1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_customer_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel27)
                .addGap(13, 13, 13)
                .addComponent(tf_customer_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_chargeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_chargeLayout.createSequentialGroup()
                        .addComponent(tf_amount2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel29))
                    .addGroup(pnl_chargeLayout.createSequentialGroup()
                        .addComponent(tf_amount3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_payments.addTab("Charge", pnl_charge);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("From:");

        tf_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fromActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Description:");

        tf_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descriptionActionPerformed(evt);
            }
        });

        tf_gc_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_gc_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_gc_noActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("GC No.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Amount:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.setFocusable(false);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_gcLayout = new javax.swing.GroupLayout(pnl_gc);
        pnl_gc.setLayout(pnl_gcLayout);
        pnl_gcLayout.setHorizontalGroup(
            pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gcLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_gc_no, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_description, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_amount)
                    .addComponent(tf_from))
                .addGap(12, 12, 12))
        );
        pnl_gcLayout.setVerticalGroup(
            pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gcLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_from, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_description)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_gc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        tp_payments.addTab("Gift Certificate", pnl_gc);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Holder:");

        tf_cheque_holder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_holder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_holder1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Bank:");

        tf_bank1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_bank1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_bank1MouseClicked(evt);
            }
        });
        tf_bank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bank1ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Reference #:");

        tf_check_no1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_no1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_no1ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Date:");

        tf_check_date1.setDate(new Date());
        tf_check_date1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Amount:");

        tf_amount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount4.setFocusable(false);
        tf_amount4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amount4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_onlineLayout = new javax.swing.GroupLayout(pnl_online);
        pnl_online.setLayout(pnl_onlineLayout);
        pnl_onlineLayout.setHorizontalGroup(
            pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_amount4)
                    .addComponent(tf_cheque_holder1)
                    .addComponent(tf_check_no1)
                    .addComponent(tf_bank1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_onlineLayout.createSequentialGroup()
                        .addComponent(tf_check_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_onlineLayout.setVerticalGroup(
            pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_onlineLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cheque_holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_bank1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_check_no1)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_onlineLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_check_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_onlineLayout.createSequentialGroup()
                        .addComponent(tf_amount4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        tp_payments.addTab("Online", pnl_online);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tp_payments, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tp_payments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        input_discount();
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void tf_credit_card_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_credit_card_typeMouseClicked
        init_credit_cards();
    }//GEN-LAST:event_tf_credit_card_typeMouseClicked

    private void tf_credit_card_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_credit_card_typeActionPerformed
        init_credit_cards();
    }//GEN-LAST:event_tf_credit_card_typeActionPerformed

    private void lbl_credit_card_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_credit_card_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_credit_card_rateActionPerformed

    private void tf_credit_card_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_credit_card_amountActionPerformed
        tf_card_no.grabFocus();
    }//GEN-LAST:event_tf_credit_card_amountActionPerformed

    private void tf_credit_card_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_credit_card_amountKeyReleased
        compute_rate_credit_card();
    }//GEN-LAST:event_tf_credit_card_amountKeyReleased

    private void tf_cc_topayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cc_topayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cc_topayActionPerformed

    private void tf_card_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_card_noActionPerformed
        tf_card_holder.grabFocus();
    }//GEN-LAST:event_tf_card_noActionPerformed

    private void tf_card_holderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_card_holderActionPerformed
        tf_approval_code.grabFocus();
    }//GEN-LAST:event_tf_card_holderActionPerformed

    private void tf_approval_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_approval_codeActionPerformed
        ok();
    }//GEN-LAST:event_tf_approval_codeActionPerformed

    private void tf_fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fromActionPerformed
        tf_description.grabFocus();
    }//GEN-LAST:event_tf_fromActionPerformed

    private void tf_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descriptionActionPerformed
        tf_gc_no.grabFocus();
    }//GEN-LAST:event_tf_descriptionActionPerformed

    private void tf_gc_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_gc_noActionPerformed
        tf_amount.grabFocus();
    }//GEN-LAST:event_tf_gc_noActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        ok();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tf_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_nameMouseClicked
        init_customers();
    }//GEN-LAST:event_tf_customer_nameMouseClicked

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_customer_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_idActionPerformed

    private void tf_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_balanceActionPerformed

    private void tf_amount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount1ActionPerformed
        ok();
    }//GEN-LAST:event_tf_amount1ActionPerformed

    private void tf_amount1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount1KeyReleased
        type_amount_prepaid();
    }//GEN-LAST:event_tf_amount1KeyReleased

    private void tf_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cashActionPerformed

    private void tp_paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tp_paymentsMouseClicked
        select_payment_type();
    }//GEN-LAST:event_tp_paymentsMouseClicked

    private void tf_cheque_holderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_holderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cheque_holderActionPerformed

    private void tf_bankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_bankMouseClicked
        init_banks();
    }//GEN-LAST:event_tf_bankMouseClicked

    private void tf_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bankActionPerformed
        init_banks();
    }//GEN-LAST:event_tf_bankActionPerformed

    private void tf_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_noActionPerformed
        tf_amount.grabFocus();
    }//GEN-LAST:event_tf_check_noActionPerformed

    private void tf_check_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_amountActionPerformed
        ok();
    }//GEN-LAST:event_tf_check_amountActionPerformed

    private void tf_charge_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_charge_typeMouseClicked
        init_charge_types();
    }//GEN-LAST:event_tf_charge_typeMouseClicked

    private void tf_charge_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_charge_typeActionPerformed
        init_charge_types();
    }//GEN-LAST:event_tf_charge_typeActionPerformed

    private void tf_reference_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reference_noActionPerformed
        tf_customer_name.grabFocus();
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_customer_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_name1ActionPerformed
        init_customers_charge();
    }//GEN-LAST:event_tf_customer_name1ActionPerformed

    private void tf_customer_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_id1ActionPerformed

    private void tf_amount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount2ActionPerformed
        ok();
    }//GEN-LAST:event_tf_amount2ActionPerformed

    private void tf_amount2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount2KeyReleased
//        type_amount();
    }//GEN-LAST:event_tf_amount2KeyReleased

    private void tf_amount3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_amount3ActionPerformed

    private void tf_amount3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_amount3KeyReleased

    private void tf_cheque_holder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_holder1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cheque_holder1ActionPerformed

    private void tf_bank1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_bank1MouseClicked
        init_banks();
    }//GEN-LAST:event_tf_bank1MouseClicked

    private void tf_bank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bank1ActionPerformed
        init_banks();
    }//GEN-LAST:event_tf_bank1ActionPerformed

    private void tf_check_no1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_no1ActionPerformed
        tf_amount.grabFocus();
    }//GEN-LAST:event_tf_check_no1ActionPerformed

    private void tf_amount4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount4ActionPerformed
        ok();
    }//GEN-LAST:event_tf_amount4ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped

    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        input_discount();
    }//GEN-LAST:event_jTextField8KeyReleased

    private void tf_charge_type1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_charge_type1MouseClicked
        search_ar();
    }//GEN-LAST:event_tf_charge_type1MouseClicked

    private void tf_charge_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_charge_type1ActionPerformed
        search_ar();
    }//GEN-LAST:event_tf_charge_type1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField lbl_credit_card_rate;
    private javax.swing.JPanel pnl_cash;
    private javax.swing.JPanel pnl_charge;
    private javax.swing.JPanel pnl_check;
    private javax.swing.JPanel pnl_credit_card;
    private javax.swing.JPanel pnl_gc;
    private javax.swing.JPanel pnl_online;
    private javax.swing.JPanel pnl_prepayment;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_amount1;
    private javax.swing.JTextField tf_amount2;
    private javax.swing.JTextField tf_amount3;
    private javax.swing.JTextField tf_amount4;
    private javax.swing.JTextField tf_approval_code;
    private javax.swing.JTextField tf_balance;
    private javax.swing.JTextField tf_bank;
    private javax.swing.JTextField tf_bank1;
    private javax.swing.JTextField tf_card_holder;
    private javax.swing.JTextField tf_card_no;
    private javax.swing.JTextField tf_cash;
    private javax.swing.JTextField tf_cc_topay;
    private javax.swing.JTextField tf_charge_type;
    private javax.swing.JTextField tf_charge_type1;
    private javax.swing.JTextField tf_check_amount;
    private com.toedter.calendar.JDateChooser tf_check_date;
    private com.toedter.calendar.JDateChooser tf_check_date1;
    private javax.swing.JTextField tf_check_no;
    private javax.swing.JTextField tf_check_no1;
    private javax.swing.JTextField tf_cheque_holder;
    private javax.swing.JTextField tf_cheque_holder1;
    private javax.swing.JTextField tf_credit_card_amount;
    private javax.swing.JTextField tf_credit_card_type;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_id1;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_customer_name1;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_from;
    private javax.swing.JTextField tf_gc_no;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTabbedPane tp_payments;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
        init_key();
        jLabel12.setVisible(false);
        set_default_branch();
        tf_charge_type1.setVisible(false);
        jLabel36.setVisible(false);
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

    List<Banks.to_banks> bank_list = new ArrayList();

    private void init_banks() {
        String search = tf_bank.getText();
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
        int[] tbl_widths_customers = {tf_bank.getWidth()};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_bank, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Banks.to_banks to = bank_list.get(data.selected_row);
                tf_bank.setText(to.bank_name);
                tf_check_no.grabFocus();
            }
        });
    }

    double replacement_amount = 0;

    public void do_pass(double amount) {
        replacement_amount = amount;
        tf_cash.setText(FitIn.fmt_wc_0(replacement_amount));

        if (replacement_amount < 0) {
            tf_charge_type1.setVisible(true);
            jLabel36.setVisible(true);

            tf_reference_no.setFocusable(false);
            tf_customer_name1.setFocusable(false);
            tf_amount3.setFocusable(false);
            tf_charge_type.setFocusable(false);
        } else {
            tf_charge_type1.setVisible(false);
            jLabel36.setVisible(false);

            tf_reference_no.setFocusable(true);
            tf_customer_name1.setFocusable(true);
            tf_amount3.setFocusable(true);
            tf_charge_type.setFocusable(true);
        }
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

    private void ok() {
        double discount = FitIn.toDouble(jTextField8.getText());

        double cash_amount = replacement_amount - discount;

        String check_holder = tf_cheque_holder.getText();
        String check_bank = tf_bank.getText();
        String check_no = tf_check_no.getText();
        String check_date = DateType.sf.format(tf_check_date.getDate());
        double check_amount = replacement_amount - discount;

        String card_type = tf_credit_card_type.getText();
        double credit_card_rate = FitIn.toDouble(lbl_credit_card_rate.getText());
        double credit_card_amount = replacement_amount - discount;
        double credit_card_amount_to_pay = FitIn.toDouble(tf_cc_topay.getText());
        String credit_card_no = tf_card_no.getText();
        String credit_card_holder = tf_card_holder.getText();
        String credit_card_approval_code = tf_approval_code.getText();

        String prepaid_customer_name = tf_customer_name.getText();
        String prepaid_customer_id = tf_customer_id.getText();
        double prepaid_amount = replacement_amount - discount;

        Field.Input crn = (Field.Input) tf_reference_no;
        String charge_reference_no = crn.getText();
        String charge_ar_no = tf_charge_type1.getText();
        String charge_type = tf_charge_type.getText();
        String charge_customer_name = tf_customer_name1.getText();
        String charge_customer_id = tf_customer_id1.getText();
        double charge_amount = replacement_amount - discount;
        int charge_dayes = FitIn.toInt(tf_amount3.getText());

        String gc_from = tf_from.getText();
        String gc_description = tf_description.getText();
        String gc_no = tf_gc_no.getText();
        double gc_amount = replacement_amount - discount;

        String online_holder = tf_cheque_holder1.getText();
        String online_bank = tf_bank1.getText();
        String online_reference_no = tf_check_no1.getText();
        String online_date = DateType.sf.format(tf_check_date1.getDate());
        double online_amount = replacement_amount - discount;

        int index = tp_payments.getSelectedIndex();
        if (index == 0) { //cash
            cash_amount = replacement_amount - discount;

            check_amount = 0;
            credit_card_amount = 0;
            prepaid_amount = 0;
            charge_amount = 0;
            gc_amount = 0;
            online_amount = 0;
//            double amount = cash_amount + discount;
//            System.out.println("amount: " + amount);
//            System.out.println("replacement_amount: " + replacement_amount);
//            if (amount < replacement_amount) {
//                Alert.set(0, "Enter Amount!");
//                tf_cash.grabFocus();
//                return;
//            }
        }

        if (index == 1) { //check
            double amount = check_amount - discount;
            if (amount < replacement_amount) {
                Alert.set(0, "Enter Amount!");
                tf_check_amount.grabFocus();
                return;
            }
            cash_amount = 0;
            check_amount = replacement_amount - discount;
            credit_card_amount = 0;
            prepaid_amount = 0;
            charge_amount = 0;
            gc_amount = 0;
            online_amount = 0;
        }

        if (index == 2) { //credit card
            double amount = credit_card_amount - discount;
            if (amount < replacement_amount) {
                Alert.set(0, "Enter Amount!");
                tf_credit_card_amount.grabFocus();
                return;
            }
            cash_amount = 0;
            check_amount = 0;
            credit_card_amount = replacement_amount - discount;
            prepaid_amount = 0;
            charge_amount = 0;
            gc_amount = 0;
            online_amount = 0;
        }

        if (index == 3) { //prepaid
            double amount = prepaid_amount - discount;
            if (amount < replacement_amount) {
                Alert.set(0, "Enter Amount!");
                tf_amount1.grabFocus();
                return;
            }
            cash_amount = 0;
            check_amount = 0;
            credit_card_amount = 0;
            prepaid_amount = replacement_amount - discount;
            charge_amount = 0;
            gc_amount = 0;
            online_amount = 0;
        }

        if (index == 4) { //charge
            double amount = charge_amount +- discount;
            if (amount < replacement_amount) {
                Alert.set(0, "Enter Amount!");
                tf_amount2.grabFocus();
                return;
            }
            
//            if (tf_charge_type1.getText().isEmpty()) {
//                Alert.set(0, "Search AR Transaction");
//                search_ar();
//                return;
//            }
            
            cash_amount = 0;
            check_amount = 0;
            credit_card_amount = 0;
            prepaid_amount = 0;
            charge_amount = replacement_amount - discount;
            gc_amount = 0;
            online_amount = 0;

        }

        if (index == 5) { //gc
            double amount = gc_amount - discount;
            if (amount < replacement_amount) {
                Alert.set(0, "Enter Amount!");
                tf_amount2.grabFocus();
                return;
            }
            cash_amount = 0;
            check_amount = 0;
            credit_card_amount = 0;
            prepaid_amount = 0;
            charge_amount = 0;
            gc_amount = replacement_amount - discount;
            online_amount = 0;
        }

        if (index == 6) { //online
            double amount = online_amount - discount;
            if (amount < replacement_amount) {
                Alert.set(0, "Enter Amount!");
                tf_amount4.grabFocus();
                return;
            }
            cash_amount = 0;
            check_amount = 0;
            credit_card_amount = 0;
            prepaid_amount = 0;
            charge_amount = 0;
            gc_amount = 0;
            online_amount = replacement_amount - discount;
        }

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(discount, cash_amount, check_holder, check_bank, check_no, check_date, check_amount, card_type, credit_card_rate, credit_card_amount, credit_card_amount_to_pay, credit_card_no, credit_card_holder, credit_card_approval_code, prepaid_customer_name, prepaid_customer_id, prepaid_amount, charge_reference_no, charge_ar_no, charge_type, charge_customer_name, charge_customer_id, charge_amount, charge_dayes, gc_from, gc_description, gc_no, gc_amount, online_holder, online_bank, online_reference_no, online_date, online_amount));
        }
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
                    tf_credit_card_amount.setText("");
                } else {
                    double rate = FitIn.toDouble(lbl_credit_card_rate.getText());
                    double amount = FitIn.toDouble(tf_credit_card_amount.getText());

                    rate = rate / 100;
                    rate = rate * amount;
                    rate = amount + rate;
                    tf_cc_topay.setText(FitIn.fmt_wc_0(rate));
                }

                tf_credit_card_amount.grabFocus();

            }
        });
    }

    private void compute_rate_credit_card() {
        double rate = FitIn.toDouble(lbl_credit_card_rate.getText());
        double amount = FitIn.toDouble(tf_credit_card_amount.getText());
        rate = rate / 100;
        rate = rate * amount;
        rate = amount + rate;
        tf_cc_topay.setText(FitIn.fmt_wc_0(rate));
    }

    int start = 1;
    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jLabel2.setVisible(true);
                            if (start == 4) {
                                jLabel2.setVisible(false);
                                tf_customer_name.setText("");
                                tf_customer_id.setText("");
                                timer.stop();
                                start = 0;
                            }
                            start++;
                        }
                    });
    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_customers() {
        String search = tf_customer_name.getText();
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
        TableRenderer.setPopup(tf_customer_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_name.setText(to.customer_name);
                tf_customer_id.setText("" + to.id);
                tf_balance.setText(FitIn.fmt_wc_0(to.prepaid));
                tf_amount.grabFocus();

//                double to_pay = Payments.countChange();
//                double balance = FitIn.toDouble(tf_balance.getText());
//                if (balance > to_pay) {
//                    tf_amount.setText(FitIn.fmt_wc_0(to_pay));
//                } else {
//                    tf_amount.setText(FitIn.fmt_wc_0(balance));
//                }
//                if (to.prepaid <= 0) {
//                    timer.start();
//                }
            }
        });
    }

    private void type_amount_prepaid() {
        double to_pay = Payments.countChange();
        double tendered = FitIn.toDouble(tf_amount.getText());
        double balance = FitIn.toDouble(tf_balance.getText());

        if (tendered > to_pay) {
            if (balance < to_pay) {
                tf_amount.setText(FitIn.fmt_wc_0(balance));
            } else {
                tf_amount.setText(FitIn.fmt_wc_0(to_pay));
            }
        }
    }

    private void select_payment_type() {
        int index = tp_payments.getSelectedIndex();
//        System.out.println("index: " + index);

        if (index == 0) {
            //<editor-fold defaultstate="collapsed" desc=" cash ">

            tf_cheque_holder.setText("");
            tf_bank.setText("");
            tf_check_no.setText("");
            tf_check_amount.setText("");

            tf_credit_card_type.setText("");
            lbl_credit_card_rate.setText("");
            tf_credit_card_amount.setText("");
            tf_cc_topay.setText("");
            tf_card_no.setText("");
            tf_card_holder.setText("");
            tf_approval_code.setText("");

            tf_customer_name.setText("");
            tf_customer_id.setText("");
            tf_amount1.setText("");
            tf_balance.setText("");

            Field.Input_w_clear crn = (Field.Input_w_clear) tf_reference_no;
            crn.setText("");
            crn.setId("");
            tf_charge_type.setText("");
            tf_customer_name1.setText("");
            tf_customer_id1.setText("");
            tf_amount2.setText("");
            tf_amount3.setText("");
            tf_charge_type1.setText("");

            tf_from.setText("");
            tf_description.setText("");
            tf_gc_no.setText("");
            tf_amount.setText("");

            tf_cheque_holder1.setText("");
            tf_bank1.setText("");
            tf_check_no1.setText("");
            tf_amount4.setText("");
            //</editor-fold>
        }

        if (index == 1) {
            //<editor-fold defaultstate="collapsed" desc=" check ">
            tf_cash.setText("");

            tf_credit_card_type.setText("");
            lbl_credit_card_rate.setText("");
            tf_credit_card_amount.setText("");
            tf_cc_topay.setText("");
            tf_card_no.setText("");
            tf_card_holder.setText("");
            tf_approval_code.setText("");

            tf_customer_name.setText("");
            tf_customer_id.setText("");
            tf_amount1.setText("");
            tf_balance.setText("");

            Field.Input crn = (Field.Input) tf_reference_no;
            crn.setText("");
            crn.setId("");
            tf_charge_type.setText("");
            tf_customer_name1.setText("");
            tf_customer_id1.setText("");
            tf_amount2.setText("");
            tf_amount3.setText("");
            tf_charge_type1.setText("");

            tf_from.setText("");
            tf_description.setText("");
            tf_gc_no.setText("");
            tf_amount.setText("");

            tf_cheque_holder1.setText("");
            tf_bank1.setText("");
            tf_check_no1.setText("");
            tf_amount4.setText("");
            //</editor-fold>
        }

        if (index == 2) {

            //<editor-fold defaultstate="collapsed" desc=" credit card  ">
            tf_cash.setText("");

            tf_cheque_holder.setText("");
            tf_bank.setText("");
            tf_check_no.setText("");
            tf_check_amount.setText("");

            tf_customer_name.setText("");
            tf_customer_id.setText("");
            tf_amount1.setText("");
            tf_balance.setText("");

            Field.Input crn = (Field.Input) tf_reference_no;
            crn.setText("");
            crn.setId("");
            tf_charge_type.setText("");
            tf_customer_name1.setText("");
            tf_customer_id1.setText("");
            tf_amount2.setText("");
            tf_amount3.setText("");
            tf_charge_type1.setText("");

            tf_from.setText("");
            tf_description.setText("");
            tf_gc_no.setText("");
            tf_amount.setText("");

            tf_cheque_holder1.setText("");
            tf_bank1.setText("");
            tf_check_no1.setText("");
            tf_amount4.setText("");
            //</editor-fold>
        }

        if (index == 3) { //prepaid
            //<editor-fold defaultstate="collapsed" desc=" prepaid ">
            tf_cash.setText("");

            tf_cheque_holder.setText("");
            tf_bank.setText("");
            tf_check_no.setText("");
            tf_check_amount.setText("");

            tf_credit_card_type.setText("");
            lbl_credit_card_rate.setText("");
            tf_credit_card_amount.setText("");
            tf_cc_topay.setText("");
            tf_card_no.setText("");
            tf_card_holder.setText("");
            tf_approval_code.setText("");

            Field.Input crn = (Field.Input) tf_reference_no;
            crn.setText("");
            crn.setId("");
            tf_charge_type.setText("");
            tf_customer_name1.setText("");
            tf_customer_id1.setText("");
            tf_amount2.setText("");
            tf_amount3.setText("");
            tf_charge_type1.setText("");

            tf_from.setText("");
            tf_description.setText("");
            tf_gc_no.setText("");
            tf_amount.setText("");

            tf_cheque_holder1.setText("");
            tf_bank1.setText("");
            tf_check_no1.setText("");
            tf_amount4.setText("");
            //</editor-fold>
        }

        if (index == 4) { //charge
            //<editor-fold defaultstate="collapsed" desc=" charge ">
            tf_cash.setText("");

            tf_cheque_holder.setText("");
            tf_bank.setText("");
            tf_check_no.setText("");
            tf_check_amount.setText("");

            tf_credit_card_type.setText("");
            lbl_credit_card_rate.setText("");
            tf_credit_card_amount.setText("");
            tf_cc_topay.setText("");
            tf_card_no.setText("");
            tf_card_holder.setText("");
            tf_approval_code.setText("");

            tf_customer_name.setText("");
            tf_customer_id.setText("");
            tf_amount1.setText("");
            tf_balance.setText("");

            tf_from.setText("");
            tf_description.setText("");
            tf_gc_no.setText("");
            tf_amount.setText("");

            tf_cheque_holder1.setText("");
            tf_bank1.setText("");
            tf_check_no1.setText("");
            tf_amount4.setText("");
            //</editor-fold>
        }
        if (index == 5) { //gc
            //<editor-fold defaultstate="collapsed" desc=" gc ">
            tf_cash.setText("");

            tf_cheque_holder.setText("");
            tf_bank.setText("");
            tf_check_no.setText("");
            tf_check_amount.setText("");

            tf_credit_card_type.setText("");
            lbl_credit_card_rate.setText("");
            tf_credit_card_amount.setText("");
            tf_cc_topay.setText("");
            tf_card_no.setText("");
            tf_card_holder.setText("");
            tf_approval_code.setText("");

            tf_customer_name.setText("");
            tf_customer_id.setText("");
            tf_amount1.setText("");
            tf_balance.setText("");

            Field.Input crn = (Field.Input) tf_reference_no;
            crn.setText("");
            crn.setId("");
            tf_charge_type.setText("");
            tf_customer_name1.setText("");
            tf_customer_id1.setText("");
            tf_amount2.setText("");
            tf_amount3.setText("");
            tf_charge_type1.setText("");

            tf_cheque_holder1.setText("");
            tf_bank1.setText("");
            tf_check_no1.setText("");
            tf_amount4.setText("");
            //</editor-fold>
        }
        if (index == 6) { //online
            //<editor-fold defaultstate="collapsed" desc=" online ">
            tf_cash.setText("");

            tf_cheque_holder.setText("");
            tf_bank.setText("");
            tf_check_no.setText("");
            tf_check_amount.setText("");

            tf_credit_card_type.setText("");
            lbl_credit_card_rate.setText("");
            tf_credit_card_amount.setText("");
            tf_cc_topay.setText("");
            tf_card_no.setText("");
            tf_card_holder.setText("");
            tf_approval_code.setText("");

            tf_customer_name.setText("");
            tf_customer_id.setText("");
            tf_amount1.setText("");
            tf_balance.setText("");

            Field.Input crn = (Field.Input) tf_reference_no;
            crn.setText("");
            crn.setId("");
            tf_charge_type.setText("");
            tf_customer_name1.setText("");
            tf_customer_id1.setText("");
            tf_amount2.setText("");
            tf_amount3.setText("");
            tf_charge_type1.setText("");

            tf_from.setText("");
            tf_description.setText("");
            tf_gc_no.setText("");
            tf_amount.setText("");

            //</editor-fold>
        }
        input_discount();
    }

    private void input_discount() {
        int index = tp_payments.getSelectedIndex();
        double discount = FitIn.toDouble(jTextField8.getText());
        if(discount<0){
            return;
        }
        if (index == 0) {

            double amount = replacement_amount - discount;
            if(replacement_amount<0){
                amount = replacement_amount + discount;
            }else{
                amount = replacement_amount - discount;
            }
            tf_cash.setText(FitIn.fmt_wc_0(amount));
        }
        if (index == 1) { //check

            double amount = replacement_amount - discount;
              if(replacement_amount<0){
                amount = replacement_amount + discount;
            }else{
                amount = replacement_amount - discount;
            }
            tf_check_amount.setText(FitIn.fmt_wc_0(amount));
        }
        if (index == 2) { // credit card
            
            double amount = replacement_amount - discount;
              if(replacement_amount<0){
                amount = replacement_amount + discount;
            }else{
                amount = replacement_amount - discount;
            }
            tf_credit_card_amount.setText(FitIn.fmt_wc_0(amount));
        }
        if (index == 3) { // prepaid
            double amount = replacement_amount - discount;
              if(replacement_amount<0){
                amount = replacement_amount + discount;
            }else{
                amount = replacement_amount - discount;
            }
            tf_amount1.setText(FitIn.fmt_wc_0(amount));
        }
        if (index == 4) {// charge
            double amount = replacement_amount - discount;
              if(replacement_amount<0){
                amount = replacement_amount + discount;
            }else{
                amount = replacement_amount - discount;
            }
            tf_amount2.setText(FitIn.fmt_wc_0(amount));
        }
        if (index == 5) { // gc
            double amount = replacement_amount - discount;
              if(replacement_amount<0){
                amount = replacement_amount + discount;
            }else{
                amount = replacement_amount - discount;
            }
            tf_amount.setText(FitIn.fmt_wc_0(amount));
        }
        if (index == 6) { // online
            double amount = replacement_amount - discount;
              if(replacement_amount<0){
                amount = replacement_amount + discount;
            }else{
                amount = replacement_amount - discount;
            }
            tf_amount4.setText(FitIn.fmt_wc_0(amount));
        }
    }

    List<S1_account_receivable_types.to_accounts_receivable_types> type_list = new ArrayList();

    private void init_charge_types() {
        final Field.Combo cm = (Field.Combo) tf_charge_type;
        String search = tf_charge_type.getText();
        String where = "";
        type_list.clear();
        type_list = S1_account_receivable_types.ret_data2(where);
        Object[][] obj = new Object[type_list.size()][2];
        int i = 0;
        for (S1_account_receivable_types.to_accounts_receivable_types to : type_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.type_name;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 100};
        String[] col_names = {"", "Type"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_charge_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_account_receivable_types.to_accounts_receivable_types to = type_list.get(data.selected_row);
                cm.setId("" + to.id);
                tf_charge_type.setText(to.type_name);
                if (to.id != 0) {
                    String where2 = " where soa_type_id='" + to.id + "' ";
                    String ref_no = S1_sales_on_account.increment_id2(where2);
                    tf_reference_no.setText(ref_no);
                    tf_reference_no.grabFocus();
                } else {
                    tf_reference_no.setText("");
                    tf_customer_name.grabFocus();
                }

            }
        });
    }

    List<Customers.to_customers> customer_list2 = new ArrayList();

    private void init_customers_charge() {
        String search = tf_customer_name1.getText();
        customer_list2.clear();
        String where = " where customer_name like '%" + search + "%' and branch_id='" + my_branch_id + "' order by customer_name asc";
        customer_list2 = Customers.ret_data3(where);
        Object[][] obj = new Object[customer_list2.size()][2];
        int i = 0;
        for (Customers.to_customers to : customer_list2) {
            obj[i][0] = " " + to.customer_name;
            obj[i][1] = " " + FitIn.fmt_wc_0(to.balance);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {250, 90};
        int width = 0;
        String[] col_names = {"", "Balance"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_customer_name1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list2.get(data.selected_row);
                tf_customer_name1.setText(to.customer_name);
                tf_customer_id1.setText(to.customer_no);
//                tf_amount.grabFocus();
            }
        });
    }

    private void search_ar() {
        Window p = (Window) this;
        Dlg_item_replacement_search_ar nd = Dlg_item_replacement_search_ar.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_item_replacement_search_ar.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_item_replacement_search_ar.OutputData data) {
                closeDialog.ok();
                tf_charge_type.setText(data.to.soa_type);
                tf_charge_type1.setText(data.to.ar_no);
                tf_reference_no.setText(data.to.reference_no);
                tf_customer_name1.setText(data.to.customer_name);
                tf_customer_id1.setText(data.to.customer_id);
                tf_amount3.setText("" + data.to.term);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
