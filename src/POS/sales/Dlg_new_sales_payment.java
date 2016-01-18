/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.accounts_receivable.S1_account_receivable_types;
import POS.accounts_receivable.S1_sales_on_account;
import POS.banks.S1_banks;
import POS.credit_cards.S1_credit_cards;
import POS.customers.Customers;
import POS.discounts.S1_discounts;
import POS.util.Alert;
import POS.util.Courier;
import POS.util.Focus_Fire;
import POS.util.Placeholder;
import POS.util.TableRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Guinness
 */
public class Dlg_new_sales_payment extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_sales_payment
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

        public final String change;
        public final double amount_paid;
        public final String discount_name;
        public final double discount;
        public final double discount_amount;
        public final String customer_name;
        public final String check_bank;
        public final String check_no;
        public final double check_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final String check_holder;
        public final String services;
        public final double service_amount;
        public final String charge_account_name;
        public final double charge_amount;
        public final String charge_account_id;
        public final double credit_card;
        public final String credit_card_name;
        public final double credit_card_rate;
        public final double credit_card_amount;
        public final int sales_type;
        public final String soa_type;
        public final String soa_type_id;
        public final String reference_no;
        public final double prepaid_amount;
        public final String prepaid_customer_id;
        public final String prepaid_customer_name;

        public OutputData(String change, double amount_paid, String discount_name, double discount, double discount_amount, String customer_name, String check_bank, String check_no, double check_amount, String discount_customer_name, String discount_customer_id, String check_holder, String services, double service_amount, String charge_account_name, double charge_amount, String charge_account_id, double credit_card, String credit_card_name, double credit_card_rate, double credit_card_amount, int sales_type, String soa_type, String soa_type_id, String reference_no, double prepaid_amount, String prepaid_customer_id, String prepaid_customer_name) {
            this.change = change;
            this.amount_paid = amount_paid;
            this.discount_name = discount_name;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.customer_name = customer_name;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.check_holder = check_holder;
            this.services = services;
            this.service_amount = service_amount;
            this.charge_account_name = charge_account_name;
            this.charge_amount = charge_amount;
            this.charge_account_id = charge_account_id;
            this.credit_card = credit_card;
            this.credit_card_name = credit_card_name;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_amount = credit_card_amount;
            this.sales_type = sales_type;
            this.soa_type = soa_type;
            this.soa_type_id = soa_type_id;
            this.reference_no = reference_no;
            this.prepaid_amount = prepaid_amount;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_customer_name = prepaid_customer_name;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_new_sales_payment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_sales_payment(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_sales_payment() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_sales_payment myRef;

    private void setThisRef(Dlg_new_sales_payment myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_sales_payment> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_sales_payment create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_sales_payment create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_sales_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_sales_payment((java.awt.Frame) parent, false);
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
            Dlg_new_sales_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_sales_payment((java.awt.Dialog) parent, false);
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

        Dlg_new_sales_payment dialog = Dlg_new_sales_payment.create(new javax.swing.JFrame(), true);
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lbl_change = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_amount_due = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_net_due = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_cash = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_credit_card_amount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_check_amount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lbl_credit_card_rate = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_credit_card_amount = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_discount_name = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tf_discount_rate = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_line_discount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_soa_type = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        tf_customer_id = new javax.swing.JTextField();
        tf_discount_amount = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tf_check_bank = new javax.swing.JTextField();
        tf_check_no = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_credit_card_type = new javax.swing.JTextField();
        tf_reference_no = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_soa_type_id = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tf_prepaid_amount = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tf_prepaid_customer_name = new javax.swing.JTextField();
        tf_prepaid_customer_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(211, 192, 169));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Change: ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel2.setOpaque(true);

        lbl_change.setBackground(new java.awt.Color(245, 242, 242));
        lbl_change.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        lbl_change.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_change.setText("0.00 ");
        lbl_change.setFocusable(false);

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText(" Amount Due");
        jLabel3.setOpaque(true);

        tf_amount_due.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        tf_amount_due.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_amount_due.setText("1,500.00");
        tf_amount_due.setFocusable(false);

        jLabel4.setBackground(new java.awt.Color(131, 129, 129));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText(" Net Due:");
        jLabel4.setOpaque(true);

        lbl_net_due.setBackground(new java.awt.Color(245, 242, 242));
        lbl_net_due.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_net_due.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_net_due.setText("1,500.00");
        lbl_net_due.setFocusable(false);

        jLabel7.setBackground(new java.awt.Color(211, 192, 169));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText(" Cash:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel7.setOpaque(true);

        tf_cash.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_cash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashActionPerformed(evt);
            }
        });
        tf_cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cashKeyReleased(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(211, 192, 169));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText(" Credit Card");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel9.setOpaque(true);

        tf_credit_card_amount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_credit_card_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
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

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText(" Cheque");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_check_amount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_check_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_check_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_amountActionPerformed(evt);
            }
        });
        tf_check_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_check_amountKeyReleased(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(211, 192, 169));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Card: ");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel11.setOpaque(true);

        lbl_credit_card_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credit_card_rate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_credit_card_rate.setText("0.00 ");
        lbl_credit_card_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Amount:");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lbl_credit_card_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credit_card_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_credit_card_amount.setText("0.00 ");
        lbl_credit_card_amount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel16.setBackground(new java.awt.Color(211, 192, 169));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText(" Discount");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel16.setOpaque(true);

        tf_discount_name.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tf_discount_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_discount_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discount_nameActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(211, 192, 169));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Rate: ");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel17.setOpaque(true);

        tf_discount_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_rate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tf_discount_rate.setText("0.00 ");
        tf_discount_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Amount:");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Line Discount: ");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lbl_line_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_line_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_line_discount.setText("0.00 ");
        lbl_line_discount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText(" Payment Type");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_soa_type.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_soa_type.setText("CASH");
        tf_soa_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_soa_typeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText(" Customer Name ");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        tf_customer_id.setFocusable(false);

        tf_discount_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_discount_amount.setText("0.00");
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

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Bank: ");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Chk #:");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_check_bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_bank.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_check_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_bankActionPerformed(evt);
            }
        });

        tf_check_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_no.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_noActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Press ( Ctrl ) to Settle Transaction");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Rate: ");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_credit_card_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_card_type.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_credit_card_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_credit_card_typeActionPerformed(evt);
            }
        });

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Ref No:");

        tf_soa_type_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_soa_type_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_soa_type_id.setText("0");
        tf_soa_type_id.setFocusable(false);
        tf_soa_type_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_soa_type_idActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText(" Prepaid:");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_prepaid_amount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_prepaid_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_prepaid_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_prepaid_amountActionPerformed(evt);
            }
        });
        tf_prepaid_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_prepaid_amountKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText(" Customer Name ");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tf_prepaid_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_prepaid_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_prepaid_customer_nameActionPerformed(evt);
            }
        });

        tf_prepaid_customer_id.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_change))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_prepaid_customer_name)
                                .addGap(0, 0, 0)
                                .addComponent(tf_prepaid_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_customer_name)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_soa_type)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_soa_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_cash))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(tf_prepaid_amount))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_check_bank)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_check_amount)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_credit_card_type)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel13)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbl_credit_card_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_credit_card_amount)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lbl_net_due)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_discount_rate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel19)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_discount_name)
                                    .addComponent(lbl_line_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tf_amount_due))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_amount_due, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lbl_line_discount)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_net_due, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_discount_name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_soa_type, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_soa_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(tf_customer_id))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_prepaid_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_prepaid_customer_name)
                    .addComponent(tf_prepaid_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_credit_card_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_credit_card_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_credit_card_type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_change, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tf_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashActionPerformed
        ok();
    }//GEN-LAST:event_tf_cashActionPerformed

    private void tf_discount_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_nameActionPerformed
        init_discount();
    }//GEN-LAST:event_tf_discount_nameActionPerformed

    private void tf_check_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_bankActionPerformed
        init_banks();

    }//GEN-LAST:event_tf_check_bankActionPerformed

    private void tf_check_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_amountActionPerformed
        compute_check();

    }//GEN-LAST:event_tf_check_amountActionPerformed

    private void tf_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_noActionPerformed
        tf_cash.grabFocus();
    }//GEN-LAST:event_tf_check_noActionPerformed

    private void tf_credit_card_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_credit_card_amountActionPerformed
        compute_credit_card();

    }//GEN-LAST:event_tf_credit_card_amountActionPerformed

    private void tf_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_amountActionPerformed
        tf_cash.grabFocus();
    }//GEN-LAST:event_tf_discount_amountActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed

        init_customers();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_soa_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_soa_typeActionPerformed
//        init_payment_charge();
        init_types(tf_soa_type, tf_soa_type_id);
    }//GEN-LAST:event_tf_soa_typeActionPerformed

    private void tf_credit_card_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_credit_card_typeActionPerformed
        init_credit_cards();
    }//GEN-LAST:event_tf_credit_card_typeActionPerformed

    private void tf_discount_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discount_amountKeyReleased
        compute_discount2();
    }//GEN-LAST:event_tf_discount_amountKeyReleased

    private void tf_cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cashKeyReleased
        compute_total();
    }//GEN-LAST:event_tf_cashKeyReleased

    private void tf_credit_card_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_credit_card_amountKeyReleased
        check_credit_card();
    }//GEN-LAST:event_tf_credit_card_amountKeyReleased

    private void tf_check_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_check_amountKeyReleased
        check_check();
    }//GEN-LAST:event_tf_check_amountKeyReleased

    private void tf_soa_type_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_soa_type_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_soa_type_idActionPerformed

    private void tf_prepaid_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_prepaid_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_prepaid_amountActionPerformed

    private void tf_prepaid_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_prepaid_amountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_prepaid_amountKeyReleased

    private void tf_prepaid_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_prepaid_customer_nameActionPerformed
        
        
    }//GEN-LAST:event_tf_prepaid_customer_nameActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lbl_change;
    private javax.swing.JLabel lbl_credit_card_amount;
    private javax.swing.JLabel lbl_credit_card_rate;
    private javax.swing.JLabel lbl_line_discount;
    private javax.swing.JTextField lbl_net_due;
    private javax.swing.JTextField tf_amount_due;
    private javax.swing.JTextField tf_cash;
    private javax.swing.JTextField tf_check_amount;
    private javax.swing.JTextField tf_check_bank;
    private javax.swing.JTextField tf_check_no;
    private javax.swing.JTextField tf_credit_card_amount;
    private javax.swing.JTextField tf_credit_card_type;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_discount_amount;
    private javax.swing.JTextField tf_discount_name;
    private javax.swing.JLabel tf_discount_rate;
    private javax.swing.JTextField tf_prepaid_amount;
    private javax.swing.JTextField tf_prepaid_customer_id;
    private javax.swing.JTextField tf_prepaid_customer_name;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTextField tf_soa_type;
    private javax.swing.JTextField tf_soa_type_id;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();
        tf_cash.grabFocus();
        placeholder();
    }

    private void placeholder() {
        Placeholder.set(tf_discount_name, "Select Discount");
        Placeholder.set(tf_customer_name, "Search Customer");
        Placeholder.set(tf_prepaid_customer_name, "Search Customer");
//        Placeholder.set(tf_prepaid_amount, "Enter Amount");
//        Placeholder.set(tf_cash, "Enter Amount");
//        Placeholder.set(tf_credit_card_amount, "Enter Amount");
        Placeholder.set(tf_check_bank, "Search Bank");
        Placeholder.set(tf_credit_card_type, "Select Card");

    }

    private void focus() {
        JTextField[] tf = {tf_soa_type, tf_cash, tf_credit_card_amount, tf_check_amount, tf_discount_name, tf_customer_name, tf_discount_amount, tf_check_bank, tf_check_no, tf_credit_card_type, tf_reference_no, tf_prepaid_amount, tf_prepaid_customer_name};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    public void do_pass(String amount_due, String line_discount, String net_due) {
        tf_amount_due.setText(amount_due);
        lbl_line_discount.setText(line_discount);
        lbl_net_due.setText(net_due);
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
        double change = FitIn.toDouble(lbl_change.getText());
        if (change < 0) {
            Alert.set(0, "Amount not enough!");
            return;
        }

        double amount_paid = FitIn.toDouble(lbl_net_due.getText());
        String discount_name = tf_discount_name.getText();
        double discount = FitIn.toDouble(tf_discount_rate.getText());
        double discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        String customer_name = "";
        String check_bank = tf_check_bank.getText();
        String check_no = tf_check_no.getText();
        double check_amount = FitIn.toDouble(tf_check_amount.getText());
        String discount_customer_name = tf_customer_name.getText();
        String discount_customer_id = tf_customer_id.getText();
        String check_holder = "";
        String services = "";
        double service_amount = 0;
        String charge_account_name = "";
        double charge_amount = 0;
        String charge_account_id = "";
        double credit_card = FitIn.toDouble(tf_credit_card_amount.getText());
        String credit_card_name = tf_credit_card_type.getText();
        double credit_card_rate = FitIn.toDouble(lbl_credit_card_rate.getText());
        double credit_card_amount = FitIn.toDouble(lbl_credit_card_amount.getText());
        if (!tf_soa_type_id.getText().equals("0")) {
            charge_account_name = tf_customer_name.getText();
            charge_account_id = tf_customer_id.getText();
            charge_amount = FitIn.toDouble(lbl_net_due.getText());
        }
        int sales_type = FitIn.toInt(tf_soa_type_id.getText());
        String soa_type = tf_soa_type.getText();
        String soa_type_id = tf_soa_type_id.getText();
        String reference_no = tf_reference_no.getText();
        double prepaid_amount = FitIn.toDouble(tf_prepaid_amount.getText());
        String prepaid_customer_id = tf_prepaid_customer_name.getText();
        String prepaid_customer_name = tf_prepaid_customer_id.getText();
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(FitIn.fmt_wc_0(change), amount_paid, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, check_holder, services, service_amount, charge_account_name, charge_amount, charge_account_id, credit_card, credit_card_name, credit_card_rate, credit_card_amount, sales_type, soa_type, soa_type_id, reference_no, prepaid_amount, prepaid_customer_id, prepaid_customer_name));
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
        int[] tbl_widths_customers = {100, 50};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_discount_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_discounts.to_discounts to = discount_list.get(data.selected_row);
                tf_discount_amount.setText(FitIn.fmt_wc_0(0));
                tf_discount_rate.setText(FitIn.fmt_wc_0(to.discount_rate));
                tf_discount_name.setText(to.discount_name);
                if (to.id == -1) {
                    tf_discount_amount.grabFocus();
                } else {
                    compute_discount();
                    tf_cash.grabFocus();
                }

            }
        });
    }

    List<Courier.status> payment_type_list = new ArrayList();

    private void init_payment_charge() {
        String search = tf_soa_type.getText();
        payment_type_list.clear();
        String where = "";
        payment_type_list = Courier.payment_types();
        Object[][] obj = new Object[payment_type_list.size()][2];
        int i = 0;
        for (Courier.status to : payment_type_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.status;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {40, 50};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_soa_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Courier.status to = payment_type_list.get(data.selected_row);
                tf_soa_type.setText(to.status);
                tf_customer_name.grabFocus();
            }
        });
    }
    
    List<Customers.to_customers> customer_list = new ArrayList();
    private void init_customers() {
        String search = tf_customer_name.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' order by customer_name asc";
        customer_list = Customers.ret_data3(where);
        Object[][] obj = new Object[customer_list.size()][3];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            obj[i][2] = " " + FitIn.fmt_wc_0(to.balance);
            if (tf_soa_type_id.getText().equals("-1")) {
                obj[i][2] = " " + FitIn.fmt_wc_0(to.prepaid);
            }
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {40, 50, 90};
        int width = 0;
        String[] col_names = {"", "", "Balance"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_customer_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_name.setText(to.customer_name);
                tf_customer_id.setText(to.customer_no);
                if (to.id == 0) {
                    tf_customer_name.setText("");
                    tf_customer_id.setText("");
                }
                tf_cash.grabFocus();
            }
        });
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
                    lbl_credit_card_amount.setText("");
                    tf_credit_card_type.setText("");
                    tf_credit_card_amount.setText("");
                }
                compute_credit_card();
                tf_cash.grabFocus();
            }
        });
    }

    List<S1_banks.to_banks> bank_list = new ArrayList();

    private void init_banks() {
        String search = tf_check_bank.getText();
        bank_list.clear();
        String where = " where bank_name like '%" + search + "%' order by bank_name asc";
        bank_list = S1_banks.ret_data2(where);
        Object[][] obj = new Object[bank_list.size()][1];
        int i = 0;
        for (S1_banks.to_banks to : bank_list) {

            obj[i][0] = " " + to.bank_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_check_bank.getWidth()};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_check_bank, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_banks.to_banks to = bank_list.get(data.selected_row);
                tf_check_bank.setText(to.bank_name);
                tf_check_no.grabFocus();
            }
        });
    }

    private void compute_discount() {
        double amount_due = FitIn.toDouble(tf_amount_due.getText());
        double discount_rate = FitIn.toDouble(tf_discount_rate.getText());
        double discount_amount = discount_rate / 100;
        discount_amount = amount_due * discount_amount;
        tf_discount_amount.setText(FitIn.fmt_wc_0(discount_amount));
        double total = amount_due - discount_amount;
        lbl_net_due.setText(FitIn.fmt_wc_0(total));
        compute_total();
    }

    private void compute_discount2() {
        double amount_due = FitIn.toDouble(tf_amount_due.getText());
        double discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        double total = amount_due - discount_amount;
        lbl_net_due.setText(FitIn.fmt_wc_0(total));
        compute_total();
    }

    private void compute_check() {
        double check_amount = FitIn.toDouble(tf_check_amount.getText());
        if (check_amount < 1) {
            tf_check_bank.setText("");
            tf_check_no.setText("");
            tf_check_amount.setText("");
            tf_cash.grabFocus();
        } else {
            tf_check_bank.grabFocus();
        }
        compute_total();
    }

    private void compute_credit_card() {
        double amount_due = FitIn.toDouble(tf_credit_card_amount.getText());
        if (amount_due < 1) {
            tf_credit_card_type.setText("");
            lbl_credit_card_rate.setText("0.00");
            lbl_credit_card_amount.setText("0.00");
            tf_cash.grabFocus();
        } else {
            double credit_card_rate = FitIn.toDouble(lbl_credit_card_rate.getText());
            double credit_card_amount = credit_card_rate / 100;
            credit_card_amount = amount_due * credit_card_amount;
            credit_card_amount += amount_due;
            lbl_credit_card_amount.setText(FitIn.fmt_wc_0(credit_card_amount));
            tf_credit_card_type.grabFocus();
        }
        compute_total();
    }

    private void compute_total() {
        double net_due = FitIn.toDouble(lbl_net_due.getText());

        double cash = FitIn.toDouble(tf_cash.getText());
        double credit_card = FitIn.toDouble(tf_credit_card_amount.getText());
        double check = FitIn.toDouble(tf_check_amount.getText());

        double change = cash + credit_card + check;

        change = change - net_due;

        lbl_change.setText(FitIn.fmt_wc_0(change));
        if (!tf_soa_type_id.getText().equals("0")) {
            lbl_change.setText("0.00");
        }
    }

    private void check_credit_card() {
        double net_due = FitIn.toDouble(lbl_net_due.getText());

        double cash = FitIn.toDouble(tf_cash.getText());
        double credit_card = FitIn.toDouble(tf_credit_card_amount.getText());
        double check = FitIn.toDouble(tf_check_amount.getText());

        double total = cash + credit_card + check;
        if (total > net_due) {
            double count = net_due - (cash + check);
            tf_credit_card_amount.setText(FitIn.fmt_woc(count));
        }
        compute_total();
    }

    private void check_check() {
        double net_due = FitIn.toDouble(lbl_net_due.getText());

        double cash = FitIn.toDouble(tf_cash.getText());
        double credit_card = FitIn.toDouble(tf_credit_card_amount.getText());
        double check = FitIn.toDouble(tf_check_amount.getText());
        double total = cash + credit_card + check;
        if (total > net_due) {
            double count = net_due - (cash + credit_card);
            tf_check_amount.setText(FitIn.fmt_woc(count));
        }
        compute_total();
    }

    List<S1_account_receivable_types.to_accounts_receivable_types> type_list = new ArrayList();

    private void init_types(final JTextField tf1, final JTextField tf2) {
        String search = tf1.getText();
        String where = "";
        type_list.clear();
        type_list = S1_account_receivable_types.ret_data2(where);
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
                if (to.id != 0) {
                    String where2 = " where soa_type_id='" + to.id + "' ";
                    String ref_no = S1_sales_on_account.increment_id2(where2);
                    tf_reference_no.setText(ref_no);
                    tf_reference_no.grabFocus();

                    tf_cash.setText("");
                    tf_credit_card_amount.setText("");
                    tf_credit_card_type.setText("");
                    lbl_credit_card_rate.setText("0.00");
                    lbl_credit_card_amount.setText("0.00");

                    tf_check_amount.setText("");
                    tf_check_bank.setText("");
                    tf_check_no.setText("");

                    lbl_change.setText("0.00");
                } else {
                    tf_reference_no.setText("");
                    tf_customer_name.grabFocus();
                }

            }
        });
    }

}
