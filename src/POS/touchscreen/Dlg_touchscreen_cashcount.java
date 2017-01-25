/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.accounts_receivable.S1_account_receivable_types;
import POS.banks.Banks;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.cash_drawer.CashDrawer;
import POS.cash_drawer.CashDrawer_account_receivables;
import POS.cash_drawer.CashDrawer_cheques;
import POS.cash_drawer.CashDrawer_credit_cards;
import POS.cash_drawer.CashDrawer_gift_certificates;
import POS.cash_drawer.CashDrawer_prepaids;
import POS.cash_drawer.CashDrawer_remittances;
import POS.cash_drawer.CashDrawer_tables;
import POS.credit_cards.S1_credit_cards;
import POS.customers.Customers;
import POS.touchscreen_reports.Srpt_cc;
import POS.touchscreen_reports.Srpt_cc_ar;
import POS.touchscreen_reports.Srpt_cc_cash;
import POS.touchscreen_reports.Srpt_cc_cheque;
import POS.touchscreen_reports.Srpt_cc_credit_card;
import POS.touchscreen_reports.Srpt_cc_disbursement;
import POS.touchscreen_reports.Srpt_cc_gc;
import POS.touchscreen_reports.Srpt_cc_prepaid;
import POS.touchscreen_reports.Srpt_cc_remit;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.TableRenderer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.fields.Label;
import synsoftech.tooltip.Tip;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_cashcount extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_cashcount
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
    private Dlg_touchscreen_cashcount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_cashcount(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_cashcount() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_cashcount myRef;

    private void setThisRef(Dlg_touchscreen_cashcount myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_cashcount> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_cashcount create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_cashcount create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_cashcount dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_cashcount((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_cashcount dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_cashcount((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_cashcount dialog = Dlg_touchscreen_cashcount.create(new javax.swing.JFrame(), true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new Button.Print();
        jButton18 = new javax.swing.JButton();
        pnl_holder = new javax.swing.JPanel();
        pnl_cash = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new Field.Input_w_clear();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField3 = new Field.Input_w_clear();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField4 = new Field.Input_w_clear();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField5 = new Field.Input_w_clear();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextField6 = new Field.Input_w_clear();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextField7 = new Field.Input_w_clear();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTextField8 = new Field.Input_w_clear();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField9 = new Field.Input_w_clear();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTextField10 = new Field.Input_w_clear();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jTextField11 = new Field.Input_w_clear();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jTextField12 = new Field.Input_w_clear();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jTextField13 = new Field.Input_w_clear();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jTextField14 = new Field.Input();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jButton13 = new Button.Primary();
        jLabel9 = new Label.Separator2();
        jPanel24 = new javax.swing.JPanel();
        jTextField16 = new Field.Input_w_clear();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new Button.Success();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField15 = new Field.Input();
        jLabel53 = new javax.swing.JLabel();
        jTextField17 = new Field.Input();
        jLabel3 = new Label.Separator();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTextField18 = new Field.Input();
        jLabel60 = new javax.swing.JLabel();
        jTextField19 = new Field.Input();
        pnl_creditcard = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jButton14 = new Button.Primary();
        jLabel10 = new Label.Separator2();
        jButton15 = new Button.Default();
        jLabel70 = new javax.swing.JLabel();
        jButton34 = new Button.Warning();
        tf_cc_rate = new Field.Input();
        jLabel71 = new javax.swing.JLabel();
        tf_cc_type = new Field.Combo();
        tf_cc_amount = new Field.Input();
        jButton35 = new Button.Primary();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_cash_drawer_credit_cards = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        jButton36 = new Button.Info();
        jLabel73 = new javax.swing.JLabel();
        tf_cc_topay = new Field.Input();
        jLabel74 = new javax.swing.JLabel();
        tf_cc_card_no = new Field.Input();
        jLabel75 = new javax.swing.JLabel();
        tf_cc_card_holder = new Field.Input();
        jLabel76 = new javax.swing.JLabel();
        tf_cc_approval_code = new Field.Input();
        jLabel6 = new javax.swing.JLabel();
        pnl_gc = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jButton16 = new Button.Primary();
        jLabel11 = new Label.Separator2();
        jButton17 = new Button.Default();
        tf_gc_description = new Field.Input();
        jLabel54 = new javax.swing.JLabel();
        jButton11 = new Button.Info();
        tf_amount = new Field.Input();
        jButton12 = new Button.Warning();
        jLabel55 = new javax.swing.JLabel();
        tf_gc_no = new Field.Input();
        jButton24 = new Button.Primary();
        jLabel56 = new javax.swing.JLabel();
        tf_gc_from = new Field.Input();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_cash_drawer_gift_certificates = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        pnl_prepaid = new javax.swing.JPanel();
        pnl_prepaid_cash = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jButton37 = new Button.Primary();
        jLabel13 = new Label.Separator2();
        jButton38 = new Button.Default();
        tf_customer_name = new Field.Search();
        jButton39 = new Button.Primary();
        jButton40 = new Button.Warning();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_cash_drawer_prepaids = new javax.swing.JTable();
        jButton41 = new Button.Info();
        jLabel2 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        tf_cheque_holder = new Field.Input();
        jLabel69 = new javax.swing.JLabel();
        tf_cheque_bank = new Field.Combo();
        jLabel79 = new javax.swing.JLabel();
        tf_cheque_no = new Field.Input();
        jLabel80 = new javax.swing.JLabel();
        jTextField40 = new Field.Input();
        jLabel66 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel87 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        pnl_cheque = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jButton20 = new Button.Primary();
        jLabel14 = new Label.Separator2();
        jButton21 = new Button.Default();
        jLabel63 = new javax.swing.JLabel();
        jTextField32 = new Field.Input();
        jButton28 = new Button.Warning();
        jLabel64 = new javax.swing.JLabel();
        jTextField33 = new Field.Combo();
        tf_cheque_amount = new Field.Input();
        jButton29 = new Button.Primary();
        jLabel65 = new javax.swing.JLabel();
        jButton30 = new Button.Info();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_cash_drawer_cheques = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField35 = new Field.Input();
        jLabel88 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        pnl_accounts_receivables = new javax.swing.JPanel();
        pnl_ar_cash = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel49 = new Label.Separator2();
        jButton55 = new Button.Default();
        jLabel83 = new javax.swing.JLabel();
        jButton56 = new Button.Warning();
        tf_reference_no = new Field.Input();
        jLabel84 = new javax.swing.JLabel();
        tf_charge_type = new Field.Combo();
        jTextField55 = new Field.Search();
        jButton57 = new Button.Primary();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbl_cash_drawer_accounts_receivables = new javax.swing.JTable();
        jLabel85 = new javax.swing.JLabel();
        jButton58 = new Button.Info();
        jLabel86 = new javax.swing.JLabel();
        jTextField56 = new Field.Input();
        jLabel50 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        tf_check_holder = new Field.Input();
        jLabel77 = new javax.swing.JLabel();
        tf_cheque_bank1 = new Field.Combo();
        tf_cheque_no1 = new Field.Input();
        jLabel82 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel68 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        pnl_remittance = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        tf_cheque_no2 = new Field.Input();
        jLabel91 = new javax.swing.JLabel();
        tf_cheque_bank2 = new Field.Combo();
        jButton59 = new Button.Warning();
        jButton60 = new Button.Info();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel93 = new javax.swing.JLabel();
        tf_remit_amount = new Field.Input();
        jLabel94 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        tf_check_holder1 = new Field.Input();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel30 = new javax.swing.JPanel();
        jLabel52 = new Label.Separator2();
        jButton61 = new Button.Default();
        jButton62 = new Button.Primary();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbl_cash_drawer_remittances = new javax.swing.JTable();
        pnl_report = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));

        jButton3.setBackground(new java.awt.Color(244, 244, 244));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/cash.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(244, 244, 244));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/credit_card.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(244, 244, 244));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/gift_certificate.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(244, 244, 244));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/prepaid.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(244, 244, 244));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_payment/remove11.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(244, 244, 244));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/cheque.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(244, 244, 244));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/charge.png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(244, 244, 244));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/printer67.png"))); // NOI18N
        jButton10.setContentAreaFilled(false);
        jButton10.setFocusable(false);
        jButton10.setOpaque(true);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(244, 244, 244));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/moneybox.png"))); // NOI18N
        jButton18.setContentAreaFilled(false);
        jButton18.setFocusable(false);
        jButton18.setOpaque(true);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_holder.setBackground(new java.awt.Color(255, 255, 255));
        pnl_holder.setLayout(new java.awt.CardLayout());

        pnl_cash.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setOpaque(false);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setNextFocusableComponent(jTextField5);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("X");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("500.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setOpaque(false);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setNextFocusableComponent(jTextField1);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("X");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("1,000.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setOpaque(false);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setNextFocusableComponent(jTextField9);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("X");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("100.00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField4)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setOpaque(false);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setNextFocusableComponent(jTextField4);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("X");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("200.00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField5)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setOpaque(false);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setNextFocusableComponent(jTextField13);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("X");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("1.00");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField6)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setOpaque(false);

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setNextFocusableComponent(jTextField6);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("X");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("5.00");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField7)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setOpaque(false);

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setNextFocusableComponent(jTextField7);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("X");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("10.00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField8)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.setOpaque(false);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setNextFocusableComponent(jTextField16);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("X");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("50.00");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField9)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.setOpaque(false);

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("X");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("0.05");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField10)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setOpaque(false);

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setNextFocusableComponent(jTextField10);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("X");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("0.10");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField11)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setOpaque(false);

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setNextFocusableComponent(jTextField11);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("X");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("0.25");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField12)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.setOpaque(false);

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setNextFocusableComponent(jTextField12);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("X");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("0.50");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField13)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel16.setOpaque(false);

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("X");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Cash - in");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField14)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jButton13.setText("Next");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel24.setOpaque(false);

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setNextFocusableComponent(jTextField8);

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("X");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setText("20.00");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField16)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Cash Payments");

        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setFocusable(false);
        jTextField21.setNextFocusableComponent(jTextField1);
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField21KeyReleased(evt);
            }
        });

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setFocusable(false);
        jTextField22.setNextFocusableComponent(jTextField1);
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
        });

        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setFocusable(false);
        jTextField23.setNextFocusableComponent(jTextField1);
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField23KeyReleased(evt);
            }
        });

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setFocusable(false);
        jTextField24.setNextFocusableComponent(jTextField1);
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField24KeyReleased(evt);
            }
        });

        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setFocusable(false);
        jTextField25.setNextFocusableComponent(jTextField1);
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField25KeyReleased(evt);
            }
        });

        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setFocusable(false);
        jTextField26.setNextFocusableComponent(jTextField1);
        jTextField26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField26KeyReleased(evt);
            }
        });

        jTextField27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setFocusable(false);
        jTextField27.setNextFocusableComponent(jTextField1);
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField27KeyReleased(evt);
            }
        });

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setFocusable(false);
        jTextField28.setNextFocusableComponent(jTextField1);
        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField28KeyReleased(evt);
            }
        });

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField29.setFocusable(false);
        jTextField29.setNextFocusableComponent(jTextField1);
        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField29KeyReleased(evt);
            }
        });

        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setFocusable(false);
        jTextField30.setNextFocusableComponent(jTextField1);
        jTextField30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField30KeyReleased(evt);
            }
        });

        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setFocusable(false);
        jTextField31.setNextFocusableComponent(jTextField1);
        jTextField31.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField31KeyReleased(evt);
            }
        });

        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setFocusable(false);
        jTextField34.setNextFocusableComponent(jTextField1);
        jTextField34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField34KeyReleased(evt);
            }
        });

        jTextField36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setFocusable(false);
        jTextField36.setNextFocusableComponent(jTextField1);
        jTextField36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField36KeyReleased(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Tendered:");

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("0.00");
        jTextField15.setFocusable(false);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Cashin");

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("0.00");
        jTextField17.setFocusable(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Calculation");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("Less Cashin");

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("0.00");
        jTextField18.setFocusable(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("Total:");

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setText("0.00");
        jTextField19.setFocusable(false);

        javax.swing.GroupLayout pnl_cashLayout = new javax.swing.GroupLayout(pnl_cash);
        pnl_cash.setLayout(pnl_cashLayout);
        pnl_cashLayout.setHorizontalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_cashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnl_cashLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnl_cashLayout.createSequentialGroup()
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
        );
        pnl_cashLayout.setVerticalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_cashLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField36)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField34)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField31)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField30)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField29)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField28)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField27)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                                .addComponent(jTextField25)
                                .addGap(1, 1, 1)
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField23)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField22)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_cashLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jTextField18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_holder.add(pnl_cash, "card2");

        pnl_creditcard.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jButton14.setText("Next");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Previous");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("Amount:");

        jButton34.setText("Delete");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        tf_cc_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_rate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cc_rate.setFocusable(false);
        tf_cc_rate.setNextFocusableComponent(tf_cc_amount);
        tf_cc_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cc_rateActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Card Type:");

        tf_cc_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_type.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cc_type.setNextFocusableComponent(tf_cc_rate);
        tf_cc_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cc_typeMouseClicked(evt);
            }
        });
        tf_cc_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cc_typeActionPerformed(evt);
            }
        });

        tf_cc_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cc_amount.setNextFocusableComponent(tf_cc_topay);
        tf_cc_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cc_amountActionPerformed(evt);
            }
        });
        tf_cc_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cc_amountKeyReleased(evt);
            }
        });

        jButton35.setText("Add");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        tbl_cash_drawer_credit_cards.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_credit_cards.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_credit_cardsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_cash_drawer_credit_cards);

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("Rate:");

        jButton36.setText("Update");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel73.setText("To Pay:");

        tf_cc_topay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_topay.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cc_topay.setFocusable(false);
        tf_cc_topay.setNextFocusableComponent(tf_cc_card_no);

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel74.setText("Card No:");

        tf_cc_card_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_card_no.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cc_card_no.setNextFocusableComponent(tf_cc_card_holder);
        tf_cc_card_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cc_card_noActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel75.setText("Card Holder:");

        tf_cc_card_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_card_holder.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cc_card_holder.setNextFocusableComponent(tf_cc_approval_code);
        tf_cc_card_holder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cc_card_holderActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("Approval Code:");

        tf_cc_approval_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_approval_code.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Credit Card Payments");

        javax.swing.GroupLayout pnl_creditcardLayout = new javax.swing.GroupLayout(pnl_creditcard);
        pnl_creditcard.setLayout(pnl_creditcardLayout);
        pnl_creditcardLayout.setHorizontalGroup(
            pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_creditcardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_creditcardLayout.createSequentialGroup()
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_creditcardLayout.createSequentialGroup()
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_cc_topay))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_creditcardLayout.createSequentialGroup()
                                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_cc_amount))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_creditcardLayout.createSequentialGroup()
                                    .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_cc_type)
                                        .addComponent(tf_cc_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnl_creditcardLayout.createSequentialGroup()
                                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_creditcardLayout.createSequentialGroup()
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_cc_approval_code))
                                    .addGroup(pnl_creditcardLayout.createSequentialGroup()
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_cc_card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_creditcardLayout.createSequentialGroup()
                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_cc_card_holder)))))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_creditcardLayout.setVerticalGroup(
            pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_creditcardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_creditcardLayout.createSequentialGroup()
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_cc_type, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cc_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cc_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cc_topay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cc_card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cc_card_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cc_approval_code, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_creditcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addGap(5, 5, 5)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_holder.add(pnl_creditcard, "card2");

        pnl_gc.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jButton16.setText("Next");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Previous");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        tf_gc_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_gc_description.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_gc_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_gc_descriptionActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel54.setText("Description:");

        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton12.setText("Delete");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Amount:");

        tf_gc_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_gc_no.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton24.setText("Add");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("GC No:");

        tf_gc_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_gc_from.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("From:");

        tbl_cash_drawer_gift_certificates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_gift_certificates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_gift_certificatesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_cash_drawer_gift_certificates);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Gift Certificate Payments");

        javax.swing.GroupLayout pnl_gcLayout = new javax.swing.GroupLayout(pnl_gc);
        pnl_gc.setLayout(pnl_gcLayout);
        pnl_gcLayout.setHorizontalGroup(
            pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_gcLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_gcLayout.createSequentialGroup()
                        .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_gcLayout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_gc_no, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                            .addGroup(pnl_gcLayout.createSequentialGroup()
                                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_gc_from)
                                    .addComponent(tf_gc_description, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))
                            .addGroup(pnl_gcLayout.createSequentialGroup()
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_gcLayout.createSequentialGroup()
                                        .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_amount, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_gcLayout.setVerticalGroup(
            pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_gcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_gcLayout.createSequentialGroup()
                        .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_gc_from, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_gc_description, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_gc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(pnl_gcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129))
                    .addComponent(jScrollPane2))
                .addGap(5, 5, 5)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_holder.add(pnl_gc, "card2");

        pnl_prepaid.setBackground(new java.awt.Color(255, 255, 255));
        pnl_prepaid.setLayout(new java.awt.CardLayout());

        pnl_prepaid_cash.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jButton37.setText("Next");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setText("Previous");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jButton39.setText("Add");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setText("Delete");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("Customer Name:");

        tbl_cash_drawer_prepaids.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_prepaids.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_prepaidsMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_cash_drawer_prepaids);

        jButton41.setText("Update");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Prepaid Deposit");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Cheque Holder:");

        tf_cheque_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_holder.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_holder.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("Bank:");

        tf_cheque_bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_bank.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_bank.setEnabled(false);
        tf_cheque_bank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cheque_bankMouseClicked(evt);
            }
        });
        tf_cheque_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_bankActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Cheque No:");

        tf_cheque_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_no.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_no.setEnabled(false);
        tf_cheque_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_noActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Amount:");

        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("Trans Type:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Cash");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Cheque");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel87.setText("Cheque Date:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setEnabled(false);
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl_prepaid_cashLayout = new javax.swing.GroupLayout(pnl_prepaid_cash);
        pnl_prepaid_cash.setLayout(pnl_prepaid_cashLayout);
        pnl_prepaid_cashLayout.setHorizontalGroup(
            pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_prepaid_cashLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_prepaid_cashLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnl_prepaid_cashLayout.createSequentialGroup()
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_prepaid_cashLayout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(2, 2, 2)
                                .addComponent(jCheckBox2))
                            .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_cheque_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_cheque_bank)
                                    .addComponent(tf_cheque_no, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_prepaid_cashLayout.createSequentialGroup()
                                        .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );
        pnl_prepaid_cashLayout.setVerticalGroup(
            pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_prepaid_cashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_prepaid_cashLayout.createSequentialGroup()
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_cheque_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_cheque_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cheque_no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(pnl_prepaid_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7))
                .addGap(5, 5, 5)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_prepaid.add(pnl_prepaid_cash, "card8");

        pnl_holder.add(pnl_prepaid, "card2");

        pnl_cheque.setBackground(new java.awt.Color(255, 255, 255));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jButton20.setText("Next");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Previous");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("Amount:");

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });

        jButton28.setText("Delete");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Bank:");

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField33MouseClicked(evt);
            }
        });
        jTextField33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField33ActionPerformed(evt);
            }
        });

        tf_cheque_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton29.setText("Add");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("Cheque No:");

        jButton30.setText("Update");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        tbl_cash_drawer_cheques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_cheques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_chequesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_cash_drawer_cheques);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Cheque Payments");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setText("Cheque Holder:");

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("Cheque Date:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl_chequeLayout = new javax.swing.GroupLayout(pnl_cheque);
        pnl_cheque.setLayout(pnl_chequeLayout);
        pnl_chequeLayout.setHorizontalGroup(
            pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_chequeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_chequeLayout.createSequentialGroup()
                        .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_chequeLayout.createSequentialGroup()
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_chequeLayout.createSequentialGroup()
                                .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField33)
                                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnl_chequeLayout.createSequentialGroup()
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_cheque_amount))
                                .addGroup(pnl_chequeLayout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_chequeLayout.createSequentialGroup()
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_chequeLayout.setVerticalGroup(
            pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_chequeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(pnl_chequeLayout.createSequentialGroup()
                        .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cheque_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(pnl_chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_holder.add(pnl_cheque, "card2");

        pnl_accounts_receivables.setBackground(new java.awt.Color(255, 255, 255));
        pnl_accounts_receivables.setLayout(new java.awt.CardLayout());

        pnl_ar_cash.setBackground(new java.awt.Color(255, 255, 255));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jButton55.setText("Previous");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Customer Name:");

        jButton56.setText("Delete");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_reference_no.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Charge Type:");

        tf_charge_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_charge_type.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jTextField55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField55.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField55MouseClicked(evt);
            }
        });
        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField55ActionPerformed(evt);
            }
        });

        jButton57.setText("Add");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        tbl_cash_drawer_accounts_receivables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_accounts_receivables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_accounts_receivablesMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbl_cash_drawer_accounts_receivables);

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("Reference No:");

        jButton58.setText("Update");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("Amount:");

        jTextField56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField56.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel50.setText("Account Receivables");

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Cheque Holder:");

        tf_check_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_holder.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_check_holder.setEnabled(false);

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("Bank:");

        tf_cheque_bank1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_bank1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_bank1.setEnabled(false);
        tf_cheque_bank1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cheque_bank1MouseClicked(evt);
            }
        });
        tf_cheque_bank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_bank1ActionPerformed(evt);
            }
        });

        tf_cheque_no1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_no1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_no1.setEnabled(false);
        tf_cheque_no1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_no1ActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Cheque No:");

        buttonGroup2.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Cheque");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Cash");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("Trans Type:");

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Cheque Date:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setEnabled(false);
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl_ar_cashLayout = new javax.swing.GroupLayout(pnl_ar_cash);
        pnl_ar_cash.setLayout(pnl_ar_cashLayout);
        pnl_ar_cashLayout.setHorizontalGroup(
            pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField56))
                                .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField55))
                                        .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                            .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                                    .addComponent(jCheckBox4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jCheckBox3))
                                                .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tf_charge_type)
                                                    .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_check_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                    .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_cheque_bank1)
                                        .addComponent(tf_cheque_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11))
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_ar_cashLayout.setVerticalGroup(
            pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ar_cashLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(pnl_ar_cashLayout.createSequentialGroup()
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_charge_type, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_check_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_cheque_bank1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cheque_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_ar_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_accounts_receivables.add(pnl_ar_cash, "card2");

        pnl_holder.add(pnl_accounts_receivables, "card2");

        pnl_remittance.setBackground(new java.awt.Color(255, 255, 255));

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel90.setText("Cheque Date:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setEnabled(false);
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_cheque_no2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_no2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_no2.setEnabled(false);
        tf_cheque_no2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_no2ActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel91.setText("Amount:");

        tf_cheque_bank2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cheque_bank2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cheque_bank2.setEnabled(false);
        tf_cheque_bank2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cheque_bank2MouseClicked(evt);
            }
        });
        tf_cheque_bank2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cheque_bank2ActionPerformed(evt);
            }
        });

        jButton59.setText("Delete");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setText("Update");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Cheque");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel93.setText("Cheque No:");

        tf_remit_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remit_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel94.setText("Cheque Holder:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel51.setText("Remit ");

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel95.setText("Bank:");

        tf_check_holder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_check_holder1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_check_holder1.setEnabled(false);

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Cash");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jButton61.setText("Previous");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jButton62.setText("Add");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel97.setText("Trans Type:");

        tbl_cash_drawer_remittances.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_remittances.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_remittancesMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tbl_cash_drawer_remittances);

        javax.swing.GroupLayout pnl_remittanceLayout = new javax.swing.GroupLayout(pnl_remittance);
        pnl_remittance.setLayout(pnl_remittanceLayout);
        pnl_remittanceLayout.setHorizontalGroup(
            pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_remittanceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_remittanceLayout.createSequentialGroup()
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(tf_remit_amount))
                                .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox5)
                                        .addGap(164, 164, 164))
                                    .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                        .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                    .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_check_holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                    .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_cheque_bank2)
                                        .addComponent(tf_cheque_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnl_remittanceLayout.createSequentialGroup()
                                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_remittanceLayout.setVerticalGroup(
            pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_remittanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(pnl_remittanceLayout.createSequentialGroup()
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_check_holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_cheque_bank2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cheque_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_remit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_holder.add(pnl_remittance, "card9");

        pnl_report.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_report, "card8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cardLayout.show(pnl_holder, "1");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cardLayout.show(pnl_holder, "2");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cardLayout.show(pnl_holder, "3");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cardLayout.show(pnl_holder, "4");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cardLayout.show(pnl_holder, "5");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cardLayout.show(pnl_holder, "6");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        cardLayout.next(pnl_holder);
        tf_cc_type.grabFocus();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        cardLayout.next(pnl_holder);
        tf_gc_from.grabFocus();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        cardLayout.previous(pnl_holder);
        jTextField3.grabFocus();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        cardLayout.next(pnl_holder);

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        cardLayout.previous(pnl_holder);
        tf_cc_type.grabFocus();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        cardLayout.next(pnl_holder);

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        cardLayout.previous(pnl_holder);

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased

    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
//        cardLayout.next(pnl_holder);
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void tf_gc_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_gc_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_gc_descriptionActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void tf_cc_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cc_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cc_rateActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        init_report();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        cardLayout.next(pnl_holder);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        cardLayout.previous(pnl_holder);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        cardLayout.previous(pnl_holder);
    }//GEN-LAST:event_jButton55ActionPerformed

    private void tf_reference_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reference_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_cc_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cc_typeActionPerformed
        init_credit_cards();
    }//GEN-LAST:event_tf_cc_typeActionPerformed

    private void tf_cc_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cc_typeMouseClicked
        init_credit_cards();
    }//GEN-LAST:event_tf_cc_typeMouseClicked

    private void tf_cc_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cc_amountActionPerformed
        compute_rate();
        tf_cc_card_no.grabFocus();
    }//GEN-LAST:event_tf_cc_amountActionPerformed

    private void tf_cc_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cc_amountKeyReleased
        compute_rate();
    }//GEN-LAST:event_tf_cc_amountKeyReleased

    private void tf_cc_card_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cc_card_noActionPerformed
        tf_cc_card_holder.grabFocus();
    }//GEN-LAST:event_tf_cc_card_noActionPerformed

    private void tf_cc_card_holderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cc_card_holderActionPerformed
        tf_cc_approval_code.grabFocus();
    }//GEN-LAST:event_tf_cc_card_holderActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        add_cc();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void tbl_cash_drawer_credit_cardsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_credit_cardsMouseClicked
        select_cc();
    }//GEN-LAST:event_tbl_cash_drawer_credit_cardsMouseClicked

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        update_cc();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        delete_cc();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        add_cash_drawer_gift_certificates();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void tbl_cash_drawer_gift_certificatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_gift_certificatesMouseClicked
        select_cash_drawer_gift_certificates();
    }//GEN-LAST:event_tbl_cash_drawer_gift_certificatesMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        update_cash_drawer_gift_certificates();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        delete_cash_drawer_gift_certificates();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        update_cash_drawer_accounts_receivables();
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        add_cash_drawer_accounts_receivables();
    }//GEN-LAST:event_jButton57ActionPerformed

    private void tf_cheque_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cheque_noActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        prepaid_trans_type();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        prepaid_trans_type();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        add_cash_drawer_prepaids();
    }//GEN-LAST:event_jButton39ActionPerformed

    private void tbl_cash_drawer_prepaidsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_prepaidsMouseClicked
        select_cash_drawer_prepaids();
    }//GEN-LAST:event_tbl_cash_drawer_prepaidsMouseClicked

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        delete_cash_drawer_prepaids();
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        update_cash_drawer_prepaids();
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        delete_cash_drawer_cheques();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        update_cash_drawer_cheques();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void tbl_cash_drawer_chequesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_chequesMouseClicked
        select_cash_drawer_cheques();
    }//GEN-LAST:event_tbl_cash_drawer_chequesMouseClicked

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        add_cash_drawer_cheques();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void tf_cheque_no1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_no1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cheque_no1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        init_ar_type();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        init_ar_type();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        delete_cash_drawer_accounts_receivables();
    }//GEN-LAST:event_jButton56ActionPerformed

    private void tbl_cash_drawer_accounts_receivablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_accounts_receivablesMouseClicked
        select_cash_drawer_accounts_receivables();
    }//GEN-LAST:event_tbl_cash_drawer_accounts_receivablesMouseClicked

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers(tf_customer_name);
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_nameMouseClicked
        init_customers(tf_customer_name);
    }//GEN-LAST:event_tf_customer_nameMouseClicked

    private void tf_cheque_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_bankActionPerformed
        init_banks(tf_cheque_bank);
    }//GEN-LAST:event_tf_cheque_bankActionPerformed

    private void tf_cheque_bankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cheque_bankMouseClicked
        init_banks(tf_cheque_bank);
    }//GEN-LAST:event_tf_cheque_bankMouseClicked

    private void jTextField33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField33ActionPerformed
        init_banks(jTextField33);
    }//GEN-LAST:event_jTextField33ActionPerformed

    private void jTextField33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField33MouseClicked
        init_banks(jTextField33);
    }//GEN-LAST:event_jTextField33MouseClicked

    private void tf_cheque_bank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_bank1ActionPerformed
        init_banks(tf_cheque_bank1);
    }//GEN-LAST:event_tf_cheque_bank1ActionPerformed

    private void tf_cheque_bank1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cheque_bank1MouseClicked
        init_banks(tf_cheque_bank1);
    }//GEN-LAST:event_tf_cheque_bank1MouseClicked

    private void jTextField55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField55ActionPerformed
        init_customers(jTextField55);
    }//GEN-LAST:event_jTextField55ActionPerformed

    private void jTextField55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField55MouseClicked
        init_customers(jTextField55);
    }//GEN-LAST:event_jTextField55MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        cardLayout.show(pnl_holder, "7");
    }//GEN-LAST:event_jButton10MouseClicked

    private void tf_charge_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_charge_typeActionPerformed
        init_types();
    }//GEN-LAST:event_tf_charge_typeActionPerformed

    private void tf_charge_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_charge_typeMouseClicked
        init_types();
    }//GEN-LAST:event_tf_charge_typeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save_cc();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        cardLayout.show(pnl_holder, "8");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void tf_cheque_no2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_no2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cheque_no2ActionPerformed

    private void tf_cheque_bank2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cheque_bank2MouseClicked
        init_banks(tf_cheque_bank2);
    }//GEN-LAST:event_tf_cheque_bank2MouseClicked

    private void tf_cheque_bank2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cheque_bank2ActionPerformed
        init_banks(tf_cheque_bank2);
    }//GEN-LAST:event_tf_cheque_bank2ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        delete_cash_drawer_remittances();
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        update_cash_drawer_remittances();
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        init_remit_type();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        init_remit_type();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        add_cash_drawer_remittances();
    }//GEN-LAST:event_jButton62ActionPerformed

    private void tbl_cash_drawer_remittancesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_remittancesMouseClicked
        select_cash_drawer_remittances();
    }//GEN-LAST:event_tbl_cash_drawer_remittancesMouseClicked

    private void jTextField21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21KeyReleased

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22KeyReleased

    private void jTextField23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23KeyReleased

    private void jTextField24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24KeyReleased

    private void jTextField25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25KeyReleased

    private void jTextField26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField26KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26KeyReleased

    private void jTextField27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27KeyReleased

    private void jTextField28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField28KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28KeyReleased

    private void jTextField29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField29KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29KeyReleased

    private void jTextField30KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField30KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30KeyReleased

    private void jTextField31KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField31KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31KeyReleased

    private void jTextField34KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField34KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34KeyReleased

    private void jTextField36KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField36KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField36KeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel pnl_accounts_receivables;
    private javax.swing.JPanel pnl_ar_cash;
    private javax.swing.JPanel pnl_cash;
    private javax.swing.JPanel pnl_cheque;
    private javax.swing.JPanel pnl_creditcard;
    private javax.swing.JPanel pnl_gc;
    private javax.swing.JPanel pnl_holder;
    private javax.swing.JPanel pnl_prepaid;
    private javax.swing.JPanel pnl_prepaid_cash;
    private javax.swing.JPanel pnl_remittance;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JTable tbl_cash_drawer_accounts_receivables;
    private javax.swing.JTable tbl_cash_drawer_cheques;
    private javax.swing.JTable tbl_cash_drawer_credit_cards;
    private javax.swing.JTable tbl_cash_drawer_gift_certificates;
    private javax.swing.JTable tbl_cash_drawer_prepaids;
    private javax.swing.JTable tbl_cash_drawer_remittances;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_cc_amount;
    private javax.swing.JTextField tf_cc_approval_code;
    private javax.swing.JTextField tf_cc_card_holder;
    private javax.swing.JTextField tf_cc_card_no;
    private javax.swing.JTextField tf_cc_rate;
    private javax.swing.JTextField tf_cc_topay;
    private javax.swing.JTextField tf_cc_type;
    private javax.swing.JTextField tf_charge_type;
    private javax.swing.JTextField tf_check_holder;
    private javax.swing.JTextField tf_check_holder1;
    private javax.swing.JTextField tf_cheque_amount;
    private javax.swing.JTextField tf_cheque_bank;
    private javax.swing.JTextField tf_cheque_bank1;
    private javax.swing.JTextField tf_cheque_bank2;
    private javax.swing.JTextField tf_cheque_holder;
    private javax.swing.JTextField tf_cheque_no;
    private javax.swing.JTextField tf_cheque_no1;
    private javax.swing.JTextField tf_cheque_no2;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_gc_description;
    private javax.swing.JTextField tf_gc_from;
    private javax.swing.JTextField tf_gc_no;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTextField tf_remit_amount;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_branch();
        init_panel_layout();
        hover();
        key_count();
        init_tables();

        ret_cc();
        ret_cc_data();
        ret_cash_drawer_gift_certificates();
        ret_cash_drawer_prepaids();
        ret_cash_drawer_cheque();
        ret_cash_drawer_ar();
        ret_cash_drawer_remit();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTextField3.grabFocus();
                jTextField19.setVisible(false);
                jLabel60.setVisible(false);
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

    CardLayout cardLayout = new CardLayout();
    CardLayout cardLayout_prepaid = new CardLayout();
    CardLayout cardLayout_ar = new CardLayout();

    private void init_panel_layout() {
        cardLayout = (CardLayout) pnl_holder.getLayout();
        cardLayout.addLayoutComponent("1", pnl_cash);
        cardLayout.addLayoutComponent("2", pnl_creditcard);
        cardLayout.addLayoutComponent("3", pnl_gc);
        cardLayout.addLayoutComponent("4", pnl_prepaid);
        cardLayout.addLayoutComponent("5", pnl_cheque);
        cardLayout.addLayoutComponent("6", pnl_accounts_receivables);
        cardLayout.addLayoutComponent("7", pnl_report);
        cardLayout.addLayoutComponent("8", pnl_remittance);

        cardLayout_prepaid = (CardLayout) pnl_prepaid.getLayout();
        cardLayout_prepaid.addLayoutComponent("1", pnl_prepaid_cash);

        cardLayout_ar = (CardLayout) pnl_accounts_receivables.getLayout();
        cardLayout_ar.addLayoutComponent("1", pnl_ar_cash);

    }

    private void hover() {
        JButton[] btns = {jButton3, jButton4, jButton5, jButton6, jButton8, jButton9, jButton7, jButton10, jButton18};
        final String[] txts = {"Cash Payments", "Credit Card Payments", "Gift Certificate Payments", "Prepaid", "Cheque", "Accounts Receivable", "Close", "Print Preview", "Remit"};
        int i = 0;
        for (final JButton btn : btns) {
            final int ii = i;
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(4, 176, 217));
                    Point point = btn.getLocationOnScreen();
                    point = new Point(point.x + 100, point.y + 15);
                    Tip.set(Dlg_touchscreen_cashcount.this, point, txts[ii]);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(244, 244, 244));
                    Point point = btn.getLocationOnScreen();
                    point = new Point(point.x + 100, point.y + 15);
                    Tip.set(Dlg_touchscreen_cashcount.this, point, txts[ii]);
                }
            });
            if (i < txts.length) {
                i++;
            }
        }
    }

    private void key_count() {
        JTextField[] tfs = {jTextField3, jTextField1, jTextField5, jTextField4, jTextField4, jTextField9, jTextField16, jTextField8, jTextField8, jTextField7, jTextField7, jTextField6, jTextField6, jTextField12, jTextField13, jTextField11, jTextField10};

        for (final JTextField tf : tfs) {
            tf.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    count_total();
                }
            });
            tf.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    tf.transferFocus();
                }
            });
        }

    }

    private void count_total() {
        double cashin = FitIn.toDouble(jTextField14.getText());
        double thousand = FitIn.toDouble(jTextField3.getText()) * 1000;
        jTextField36.setText(FitIn.fmt_wc_0(thousand));
        double five_hundred = FitIn.toDouble(jTextField1.getText()) * 500;
        jTextField34.setText(FitIn.fmt_wc_0(five_hundred));

        double two_hundred = FitIn.toDouble(jTextField5.getText()) * 200;
        jTextField31.setText(FitIn.fmt_wc_0(two_hundred));
        double one_hundred = FitIn.toDouble(jTextField4.getText()) * 100;
        jTextField30.setText(FitIn.fmt_wc_0(one_hundred));
        double fifty = FitIn.toDouble(jTextField9.getText()) * 50;
        jTextField29.setText(FitIn.fmt_wc_0(fifty));
        double twenty = FitIn.toDouble(jTextField16.getText()) * 20;
        jTextField28.setText(FitIn.fmt_wc_0(twenty));
        double ten = FitIn.toDouble(jTextField8.getText()) * 10;
        jTextField27.setText(FitIn.fmt_wc_0(ten));
        double five = FitIn.toDouble(jTextField7.getText()) * 5;
        jTextField25.setText(FitIn.fmt_wc_0(five));
        double one = FitIn.toDouble(jTextField6.getText()) * 1;
        jTextField26.setText(FitIn.fmt_wc_0(one));
        double point_fifty = FitIn.toDouble(jTextField13.getText()) * .5;
        jTextField23.setText(FitIn.fmt_wc_0(point_fifty));
        double point_twenty_five = FitIn.toDouble(jTextField12.getText()) * .25;
        jTextField24.setText(FitIn.fmt_wc_0(point_twenty_five));
        double point_ten = FitIn.toDouble(jTextField11.getText()) * .10;
        jTextField22.setText(FitIn.fmt_wc_0(point_ten));
        double point_five = FitIn.toDouble(jTextField10.getText()) * .05;
        jTextField21.setText(FitIn.fmt_wc_0(point_five));
        double total
                = thousand
                + five_hundred
                + two_hundred
                + one_hundred
                + fifty
                + twenty
                + ten
                + five
                + one
                + point_fifty
                + point_twenty_five
                + point_ten
                + point_five;
        jTextField15.setText(FitIn.fmt_wc_0(total));

        double totals = (total - cashin);
        jTextField18.setText(FitIn.fmt_wc_0(totals));
        jTextField19.setText(FitIn.fmt_wc_0(total + cashin));
    }
    List<S1_credit_cards.to_credit_cards> credit_card_list = new ArrayList();

    private void init_credit_cards() {
        String search = tf_cc_type.getText();
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
                setPopup(tf_cc_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_credit_cards.to_credit_cards to = credit_card_list.get(data.selected_row);
                tf_cc_type.setText(to.name);
                tf_cc_rate.setText(FitIn.fmt_wc_0(to.rate));
                if (to.id == 0) {
                    tf_cc_rate.setText("");
                    tf_cc_amount.setText("");
                    tf_cc_type.setText("");
                    tf_cc_amount.setText("");
                } else {
                    double rate = FitIn.toDouble(tf_cc_rate.getText());
                    double amount = FitIn.toDouble(tf_cc_amount.getText());

                    rate = rate / 100;
                    rate = rate * amount;
                    rate = amount + rate;
                    tf_cc_topay.setText(FitIn.fmt_wc_0(rate));
                }
                tf_cc_amount.grabFocus();
            }
        });
    }

    private void compute_rate() {
        double rate = FitIn.toDouble(tf_cc_rate.getText());
        double amount = FitIn.toDouble(tf_cc_amount.getText());
        rate = rate / 100;
        rate = rate * amount;
        rate = amount + rate;
        tf_cc_topay.setText(FitIn.fmt_wc_0(rate));
    }

    private void init_tables() {
        CashDrawer_tables.init_tbl_cash_drawer_credit_cards(tbl_cash_drawer_credit_cards);
        CashDrawer_tables.init_tbl_cash_drawer_gift_certificates(tbl_cash_drawer_gift_certificates);
        CashDrawer_tables.init_tbl_cash_drawer_prepaids(tbl_cash_drawer_prepaids);
        CashDrawer_tables.init_tbl_cash_drawer_cheques(tbl_cash_drawer_cheques);
        CashDrawer_tables.init_tbl_cash_drawer_accounts_receivables(tbl_cash_drawer_accounts_receivables);
        CashDrawer_tables.init_tbl_cash_drawer_remittances(tbl_cash_drawer_remittances);
    }

    private void ret_cc() {
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where user_id='" + user_id + "' and Date(time_in)='" + date + "' ";
        CashDrawer.to_cash_drawer to = CashDrawer.ret_to(where);
        if (to != null) {
            jTextField14.setText(FitIn.fmt_wc_0(to.amount));
            jTextField17.setText(FitIn.fmt_wc_0(to.amount));

            jTextField3.setText(FitIn.fmt_woc(to.thousand));
            jTextField1.setText(FitIn.fmt_woc(to.five_hundred));
            jTextField5.setText(FitIn.fmt_woc(to.two_hundred));
            jTextField4.setText(FitIn.fmt_woc(to.one_hundred));
            jTextField9.setText(FitIn.fmt_woc(to.fifty));
            jTextField16.setText(FitIn.fmt_woc(to.twenty));

            jTextField8.setText(FitIn.fmt_woc(to.ten));
            jTextField7.setText(FitIn.fmt_woc(to.five));
            jTextField6.setText(FitIn.fmt_woc(to.one));
            jTextField13.setText(FitIn.fmt_woc(to.point_five));
            jTextField12.setText(FitIn.fmt_woc(to.point_two_five));
            jTextField11.setText(FitIn.fmt_woc(to.point_ten));
            jTextField10.setText(FitIn.fmt_woc(to.point_zero_five));
            count_total();
        }
    }

    private void save_cc() {

        double cashin = FitIn.toDouble(jTextField14.getText());
        double thousand = FitIn.toDouble(jTextField3.getText());
        double five_hundred = FitIn.toDouble(jTextField1.getText());
        double two_hundred = FitIn.toDouble(jTextField5.getText());
        double one_hundred = FitIn.toDouble(jTextField4.getText());
        double fifty = FitIn.toDouble(jTextField9.getText());
        double twenty = FitIn.toDouble(jTextField16.getText());
        double ten = FitIn.toDouble(jTextField8.getText());
        double five = FitIn.toDouble(jTextField7.getText());
        double one = FitIn.toDouble(jTextField6.getText());
        double point_fifty = FitIn.toDouble(jTextField13.getText());
        double point_twenty_five = FitIn.toDouble(jTextField12.getText());
        double point_ten = FitIn.toDouble(jTextField11.getText());
        double point_five = FitIn.toDouble(jTextField10.getText());

        int id = 0;
        String session_no = "";
        String user_name = "";
        String screen_name = "";
        String time_in = "";
        String time_out = DateType.now();
        double amount = 0;
        double cash_out = 0;
        double coins = 0;
        double expenses = 0;
        double point_two_five = 0;
        double point_zero_five = point_five;
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        String user_id=MyUser.getUser_id();
        String user_screen_name=MyUser.getUser_screen_name();
        CashDrawer.to_cash_drawer to = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount
                , cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five
                , one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id,user_id,user_screen_name);

        
        String date = DateType.sf.format(new Date());
        CashDrawer.update_data(to, user_id, date,cashin);
        Alert.set(2, "");
    }

    private void ret_cc_data() {
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where user_id='" + user_id + "' and Date(date_added)='" + date + "' ";
        List<CashDrawer_credit_cards.to_cash_drawer_credit_cards> datas = CashDrawer_credit_cards.ret_data(where);
        CashDrawer_tables.loadData_cash_drawer_credit_cards(datas);
    }

    private void ret_cash_drawer_gift_certificates() {
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where user_id='" + user_id + "' and Date(date_added)='" + date + "' ";
        List<CashDrawer_gift_certificates.to_cash_drawer_gift_certificates> datas = CashDrawer_gift_certificates.ret_data(where);
        CashDrawer_tables.loadData_cash_drawer_gift_certificates(datas);
    }

    private void ret_cash_drawer_prepaids() {
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where user_id='" + user_id + "' and Date(date_added)='" + date + "' ";
        List<CashDrawer_prepaids.to_cash_drawer_prepaids> datas = CashDrawer_prepaids.ret_data(where);
        CashDrawer_tables.loadData_cash_drawer_prepaids(datas);
    }

    private void ret_cash_drawer_cheque() {
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where user_id='" + user_id + "' and Date(date_added)='" + date + "' ";
        List<CashDrawer_cheques.to_cash_drawer_cheques> datas = CashDrawer_cheques.ret_data(where);
        CashDrawer_tables.loadData_cash_drawer_cheques(datas);
    }

    private void ret_cash_drawer_ar() {
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where user_id='" + user_id + "' and Date(date_added)='" + date + "' ";
        List<CashDrawer_account_receivables.to_cash_drawer_accounts_receivables> datas = CashDrawer_account_receivables.ret_data(where);
        CashDrawer_tables.loadData_cash_drawer_accounts_receivables(datas);
    }

    private void ret_cash_drawer_remit() {
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where user_id='" + user_id + "' and Date(date_added)='" + date + "' ";
        List<CashDrawer_remittances.to_cash_drawer_remittances> datas = CashDrawer_remittances.ret_data(where);
        CashDrawer_tables.loadData_cash_drawer_remittances(datas);
    }

    //<editor-fold defaultstate="collapsed" desc=" credit card ">
    private void add_cc() {
        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String credit_card_type = tf_cc_type.getText();
        double credit_card_rate = FitIn.toDouble(tf_cc_rate.getText());
        double credit_card_amount = FitIn.toDouble(tf_cc_amount.getText());
        String credit_card_no = tf_cc_card_no.getText();
        String credit_card_holder = tf_cc_card_holder.getText();
        String credit_card_approval_code = tf_cc_approval_code.getText();

        CashDrawer_credit_cards.to_cash_drawer_credit_cards to = new CashDrawer_credit_cards.to_cash_drawer_credit_cards(id, user_id, user_screen_name, date_added, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code);

        CashDrawer_credit_cards.add_data(to);
        tf_cc_type.setText("");
        tf_cc_rate.setText("");
        tf_cc_amount.setText("");
        tf_cc_card_no.setText("");
        tf_cc_card_holder.setText("");
        tf_cc_approval_code.setText("");
        tf_cc_topay.setText("");
        tf_cc_type.grabFocus();
        ret_cc_data();
    }

    private void select_cc() {
        int row = tbl_cash_drawer_credit_cards.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_credit_cards.to_cash_drawer_credit_cards to = (CashDrawer_credit_cards.to_cash_drawer_credit_cards) CashDrawer_tables.tbl_cash_drawer_credit_cards_ALM.get(row);
        tf_cc_type.setText(to.credit_card_type);
        tf_cc_rate.setText(FitIn.fmt_wc_0(to.credit_card_rate));
        tf_cc_amount.setText(FitIn.fmt_wc_0(to.credit_card_amount));
        tf_cc_card_no.setText(to.credit_card_no);
        tf_cc_card_holder.setText(to.credit_card_holder);
        tf_cc_approval_code.setText(to.credit_card_approval_code);
        compute_rate();
    }

    private void update_cc() {

        int row = tbl_cash_drawer_credit_cards.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_credit_cards.to_cash_drawer_credit_cards to = (CashDrawer_credit_cards.to_cash_drawer_credit_cards) CashDrawer_tables.tbl_cash_drawer_credit_cards_ALM.get(row);
        int id = to.id;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String credit_card_type = tf_cc_type.getText();
        double credit_card_rate = FitIn.toDouble(tf_cc_rate.getText());
        double credit_card_amount = FitIn.toDouble(tf_cc_amount.getText());
        String credit_card_no = tf_cc_card_no.getText();
        String credit_card_holder = tf_cc_card_holder.getText();
        String credit_card_approval_code = tf_cc_approval_code.getText();
        CashDrawer_credit_cards.to_cash_drawer_credit_cards to2 = new CashDrawer_credit_cards.to_cash_drawer_credit_cards(id, user_id, user_screen_name, date_added, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code);
        CashDrawer_credit_cards.update_data(to2);
        tf_cc_type.setText("");
        tf_cc_rate.setText("");
        tf_cc_amount.setText("");
        tf_cc_card_no.setText("");
        tf_cc_card_holder.setText("");
        tf_cc_approval_code.setText("");
        tf_cc_topay.setText("");
        tf_cc_type.grabFocus();
        ret_cc_data();

    }

    private void delete_cc() {
        int row = tbl_cash_drawer_credit_cards.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_credit_cards.to_cash_drawer_credit_cards to = (CashDrawer_credit_cards.to_cash_drawer_credit_cards) CashDrawer_tables.tbl_cash_drawer_credit_cards_ALM.get(row);
        CashDrawer_credit_cards.delete_data(to);
        tf_cc_type.setText("");
        tf_cc_rate.setText("");
        tf_cc_amount.setText("");
        tf_cc_card_no.setText("");
        tf_cc_card_holder.setText("");
        tf_cc_approval_code.setText("");
        tf_cc_topay.setText("");
        tf_cc_type.grabFocus();
        ret_cc_data();
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" gift certificate ">

    private void add_cash_drawer_gift_certificates() {
        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String gc_from = tf_gc_from.getText();
        String gc_description = tf_gc_description.getText();
        String gc_no = tf_gc_no.getText();
        double amount = FitIn.toDouble(tf_amount.getText());
        CashDrawer_gift_certificates.to_cash_drawer_gift_certificates to = new CashDrawer_gift_certificates.to_cash_drawer_gift_certificates(id, user_id, user_screen_name, date_added, gc_from, gc_description, gc_no, amount);
        CashDrawer_gift_certificates.add_data(to);
        tf_gc_from.setText("");
        tf_gc_description.setText("");
        tf_gc_no.setText("");
        tf_amount.setText("");
        tf_gc_from.grabFocus();
        ret_cash_drawer_gift_certificates();
    }

    private void select_cash_drawer_gift_certificates() {

        int row = tbl_cash_drawer_gift_certificates.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_gift_certificates.to_cash_drawer_gift_certificates to = (CashDrawer_gift_certificates.to_cash_drawer_gift_certificates) CashDrawer_tables.tbl_cash_drawer_gift_certificates_ALM.get(row);
        tf_gc_from.setText(to.gc_from);
        tf_gc_description.setText(to.gc_description);
        tf_gc_no.setText(to.gc_no);
        tf_amount.setText(FitIn.fmt_wc_0(to.amount));

    }

    private void update_cash_drawer_gift_certificates() {
        int row = tbl_cash_drawer_gift_certificates.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_gift_certificates.to_cash_drawer_gift_certificates to = (CashDrawer_gift_certificates.to_cash_drawer_gift_certificates) CashDrawer_tables.tbl_cash_drawer_gift_certificates_ALM.get(row);
        int id = to.id;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String gc_from = tf_gc_from.getText();
        String gc_description = tf_gc_description.getText();
        String gc_no = tf_gc_no.getText();
        double amount = FitIn.toDouble(tf_amount.getText());

        CashDrawer_gift_certificates.to_cash_drawer_gift_certificates to1 = new CashDrawer_gift_certificates.to_cash_drawer_gift_certificates(id, user_id, user_screen_name, date_added, gc_from, gc_description, gc_no, amount);
        CashDrawer_gift_certificates.update_data(to1);
        tf_gc_from.setText("");
        tf_gc_description.setText("");
        tf_gc_no.setText("");
        tf_amount.setText("");
        ret_cash_drawer_gift_certificates();
    }

    private void delete_cash_drawer_gift_certificates() {

        int row = tbl_cash_drawer_gift_certificates.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_gift_certificates.to_cash_drawer_gift_certificates to = (CashDrawer_gift_certificates.to_cash_drawer_gift_certificates) CashDrawer_tables.tbl_cash_drawer_gift_certificates_ALM.get(row);
        CashDrawer_gift_certificates.delete_data(to);
        tf_gc_from.setText("");
        tf_gc_description.setText("");
        tf_gc_no.setText("");
        tf_amount.setText("");
        ret_cash_drawer_gift_certificates();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" prepaid ">
    private void prepaid_trans_type() {
        if (jCheckBox1.isSelected()) {
            tf_customer_name.setEnabled(true);
            tf_cheque_holder.setEnabled(false);
            tf_cheque_bank.setEnabled(false);
            tf_cheque_no.setEnabled(false);
            jDateChooser1.setEnabled(false);

            tf_cheque_holder.setText("");
            tf_cheque_bank.setText("");
            tf_cheque_no.setText("");
            tf_customer_name.grabFocus();
        } else {
            tf_cheque_holder.setEnabled(true);
            tf_cheque_bank.setEnabled(true);
            tf_cheque_no.setEnabled(true);
            jDateChooser1.setEnabled(true);
            tf_customer_name.grabFocus();
        }
    }

    private void add_cash_drawer_prepaids() {

        Field.Search f = (Field.Search) tf_customer_name;
        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String customer_name = tf_customer_name.getText();
        String customer_id = f.getId();
        double cash_amount = 0;
        double cheque_amount = 0;
        if (jCheckBox1.isSelected()) {
            cash_amount = FitIn.toDouble(jTextField40.getText());
        } else {
            cheque_amount = FitIn.toDouble(jTextField40.getText());
        }
        String cheque_holder = tf_cheque_holder.getText();
        String cheque_bank = tf_cheque_bank.getText();
        String cheque_no = tf_cheque_no.getText();
        String cheque_date = DateType.sf.format(jDateChooser1.getDate());
        CashDrawer_prepaids.to_cash_drawer_prepaids to = new CashDrawer_prepaids.to_cash_drawer_prepaids(id, user_id, user_screen_name, date_added, customer_name, customer_id, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date);
        CashDrawer_prepaids.add_data(to);

        tf_customer_name.setText("");
        f.setId("");
        tf_cheque_holder.setText("");
        tf_cheque_bank.setText("");
        tf_cheque_no.setText("");
        jTextField40.setText("");
        tf_customer_name.grabFocus();
        ret_cash_drawer_prepaids();
    }

    private void select_cash_drawer_prepaids() {

        int row = tbl_cash_drawer_prepaids.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Search f = (Field.Search) tf_customer_name;
        CashDrawer_prepaids.to_cash_drawer_prepaids to = (CashDrawer_prepaids.to_cash_drawer_prepaids) CashDrawer_tables.tbl_cash_drawer_prepaids_ALM.get(row);
        f.setId(to.customer_id);
        tf_customer_name.setText(to.customer_name);
        if (to.cash_amount == 0) {
            jCheckBox2.setSelected(true);
            jTextField40.setText(FitIn.fmt_wc_0(to.cheque_amount));

            tf_cheque_holder.setEnabled(true);
            tf_cheque_bank.setEnabled(true);
            tf_cheque_no.setEnabled(true);
            jDateChooser1.setEnabled(true);
        } else {
            jCheckBox1.setSelected(true);
            jTextField40.setText(FitIn.fmt_wc_0(to.cash_amount));
            tf_cheque_holder.setEnabled(false);
            tf_cheque_bank.setEnabled(false);
            tf_cheque_no.setEnabled(false);
            jDateChooser1.setEnabled(false);
        }
        tf_cheque_holder.setText(to.cheque_holder);
        tf_cheque_bank.setText(to.cheque_bank);
        tf_cheque_no.setText(to.cheque_no);
        try {
            Date d = DateType.sf.parse(to.cheque_date);
            jDateChooser1.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_touchscreen_cashcount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update_cash_drawer_prepaids() {

        int row = tbl_cash_drawer_prepaids.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Search f = (Field.Search) tf_customer_name;
        CashDrawer_prepaids.to_cash_drawer_prepaids to = (CashDrawer_prepaids.to_cash_drawer_prepaids) CashDrawer_tables.tbl_cash_drawer_prepaids_ALM.get(row);
        int id = to.id;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String customer_name = tf_customer_name.getText();
        String customer_id = f.getId();
        double cash_amount = 0;
        double cheque_amount = 0;
        if (jCheckBox1.isSelected()) {
            cash_amount = FitIn.toDouble(jTextField40.getText());
        } else {
            cheque_amount = FitIn.toDouble(jTextField40.getText());
        }
        String cheque_holder = tf_cheque_holder.getText();
        String cheque_bank = tf_cheque_bank.getText();
        String cheque_no = tf_cheque_no.getText();
        String cheque_date = DateType.sf.format(jDateChooser1.getDate());
        CashDrawer_prepaids.to_cash_drawer_prepaids to1 = new CashDrawer_prepaids.to_cash_drawer_prepaids(id, user_id, user_screen_name, date_added, customer_name, customer_id, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date);
        CashDrawer_prepaids.update_data(to1);
        tf_customer_name.setText("");
        f.setId("");
        tf_cheque_holder.setText("");
        tf_cheque_bank.setText("");
        tf_cheque_no.setText("");
        jTextField40.setText("");
        tf_customer_name.grabFocus();
        ret_cash_drawer_prepaids();
    }

    private void delete_cash_drawer_prepaids() {

        int row = tbl_cash_drawer_prepaids.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Input f = (Field.Input) tf_customer_name;
        CashDrawer_prepaids.to_cash_drawer_prepaids to = (CashDrawer_prepaids.to_cash_drawer_prepaids) CashDrawer_tables.tbl_cash_drawer_prepaids_ALM.get(row);
        CashDrawer_prepaids.delete_data(to);
        tf_customer_name.setText("");
        f.setId("");
        tf_cheque_holder.setText("");
        tf_cheque_bank.setText("");
        tf_cheque_no.setText("");
        jTextField40.setText("");
        tf_customer_name.grabFocus();
        ret_cash_drawer_prepaids();

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" cheque ">
    private void add_cash_drawer_cheques() {
        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String cheque_holder = jTextField35.getText();
        String cheque_bank = jTextField33.getText();
        String cheque_no = jTextField32.getText();
        double cheque_amount = FitIn.toDouble(tf_cheque_amount.getText());
        String cheque_date = DateType.sf.format(jDateChooser2.getDate());
        CashDrawer_cheques.to_cash_drawer_cheques to = new CashDrawer_cheques.to_cash_drawer_cheques(id, user_id, user_screen_name, date_added, cheque_holder, cheque_bank, cheque_no, cheque_amount, cheque_date);
        CashDrawer_cheques.add_data(to);

        jTextField35.setText("");
        jTextField33.setText("");
        jTextField32.setText("");
        tf_cheque_amount.setText("");
        jTextField35.grabFocus();

        ret_cash_drawer_cheque();
    }

    private void select_cash_drawer_cheques() {

        int row = tbl_cash_drawer_cheques.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_cheques.to_cash_drawer_cheques to = (CashDrawer_cheques.to_cash_drawer_cheques) CashDrawer_tables.tbl_cash_drawer_cheques_ALM.get(row);
        jTextField35.setText(to.cheque_holder);
        jTextField33.setText(to.cheque_bank);
        jTextField32.setText(to.cheque_no);
        tf_cheque_amount.setText(FitIn.fmt_wc_0(to.cheque_amount));
        try {
            Date d = DateType.sf.parse(to.cheque_date);
            jDateChooser2.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_touchscreen_cashcount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update_cash_drawer_cheques() {

        int row = tbl_cash_drawer_cheques.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_cheques.to_cash_drawer_cheques to = (CashDrawer_cheques.to_cash_drawer_cheques) CashDrawer_tables.tbl_cash_drawer_cheques_ALM.get(row);
        int id = to.id;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String cheque_holder = jTextField35.getText();
        String cheque_bank = jTextField33.getText();
        String cheque_no = jTextField32.getText();
        double cheque_amount = FitIn.toDouble(tf_cheque_amount.getText());
        String cheque_date = DateType.sf.format(jDateChooser2.getDate());
        CashDrawer_cheques.to_cash_drawer_cheques to1 = new CashDrawer_cheques.to_cash_drawer_cheques(id, user_id, user_screen_name, date_added, cheque_holder, cheque_bank, cheque_no, cheque_amount, cheque_date);
        CashDrawer_cheques.update_data(to1);

        jTextField35.setText("");
        jTextField33.setText("");
        jTextField32.setText("");
        tf_cheque_amount.setText("");
        jTextField35.grabFocus();
        ret_cash_drawer_cheque();

    }

    private void delete_cash_drawer_cheques() {

        int row = tbl_cash_drawer_cheques.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_cheques.to_cash_drawer_cheques to = (CashDrawer_cheques.to_cash_drawer_cheques) CashDrawer_tables.tbl_cash_drawer_cheques_ALM.get(row);
        CashDrawer_cheques.delete_data(to);

        jTextField35.setText("");
        jTextField33.setText("");
        jTextField32.setText("");
        tf_cheque_amount.setText("");
        jTextField35.grabFocus();
        ret_cash_drawer_cheque();

    }
//</editor-fold>

    List<S1_account_receivable_types.to_accounts_receivable_types> type_list = new ArrayList();

    private void init_types() {
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

            }
        });
    }
    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_customers(final JTextField tf) {
        String search = tf.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' order by customer_name asc";
        customer_list = Customers.ret_data3(where);
        Object[][] obj = new Object[customer_list.size()][1];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.customer_name;
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
                Field.Search f = (Field.Search) tf;
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf.setText(to.customer_name);
                f.setId("" + to.customer_no);
            }
        });
    }

    List<Banks.to_banks> bank_list = new ArrayList();

    private void init_banks(final JTextField tf) {
        String search = tf.getText();
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
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Banks.to_banks to = bank_list.get(data.selected_row);
                tf.setText(to.bank_name);
            }
        });
    }

    private void init_ar_type() {
        if (jCheckBox4.isSelected()) {
            tf_check_holder.setEnabled(false);
            tf_cheque_bank1.setEnabled(false);
            tf_cheque_no1.setEnabled(false);
            jDateChooser3.setEnabled(false);
            tf_check_holder.setText("");
            tf_cheque_bank1.setText("");
            tf_cheque_no1.setText("");
        } else {
            tf_check_holder.setEnabled(true);
            tf_cheque_bank1.setEnabled(true);
            tf_cheque_no1.setEnabled(true);
            jDateChooser3.setEnabled(true);
        }
    }

    private void add_cash_drawer_accounts_receivables() {

        Field.Combo c_type = (Field.Combo) tf_charge_type;
        Field.Search c_customer = (Field.Search) jTextField55;
        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        String charge_type_id = c_type.getId();
        String charge_type = tf_charge_type.getText();
        String reference_no = tf_reference_no.getText();
        String customer_id = c_customer.getId();
        String customer_name = jTextField55.getText();
        double cash_amount = 0;
        double cheque_amount = 0;
        if (jCheckBox4.isSelected()) {
            cash_amount = FitIn.toDouble(jTextField56.getText());
        } else {
            cheque_amount = FitIn.toDouble(jTextField56.getText());
        }
        String check_holder = tf_check_holder.getText();
        String cheque_bank = tf_cheque_bank1.getText();
        String cheque_no = tf_cheque_no1.getText();
        String cheque_date = DateType.sf.format(jDateChooser3.getDate());
        CashDrawer_account_receivables.to_cash_drawer_accounts_receivables to = new CashDrawer_account_receivables.to_cash_drawer_accounts_receivables(id, user_id, user_screen_name, date_added, charge_type_id, charge_type, reference_no, customer_id, customer_name, cash_amount, cheque_amount, check_holder, cheque_bank, cheque_no, cheque_date);
        CashDrawer_account_receivables.add_data(to);

        c_type.setId("");
        tf_charge_type.setText("");
        tf_reference_no.setText("");
        c_customer.setId("");
        jTextField55.setText("");

        tf_check_holder.setText("");
        tf_cheque_bank1.setText("");
        tf_cheque_no1.setText("");
        jTextField56.setText("");
        tf_charge_type.grabFocus();

        ret_cash_drawer_ar();
    }

    private void select_cash_drawer_accounts_receivables() {

        Field.Combo c_type = (Field.Combo) tf_charge_type;
        Field.Search c_customer = (Field.Search) jTextField55;
        int row = tbl_cash_drawer_accounts_receivables.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_account_receivables.to_cash_drawer_accounts_receivables to = (CashDrawer_account_receivables.to_cash_drawer_accounts_receivables) CashDrawer_tables.tbl_cash_drawer_accounts_receivables_ALM.get(row);

        c_type.setId(to.charge_type_id);
        tf_charge_type.setText(to.charge_type);
        tf_reference_no.setText(to.reference_no);
        c_customer.setId(to.customer_id);
        jTextField55.setText(to.customer_name);

        if (to.cash_amount == 0) {
            jTextField56.setText(FitIn.fmt_wc_0(to.cheque_amount));
            tf_check_holder.setEnabled(true);
            tf_cheque_bank1.setEnabled(true);
            tf_cheque_no1.setEnabled(true);

        } else {
            jTextField56.setText(FitIn.fmt_wc_0(to.cash_amount));

            tf_check_holder.setEnabled(false);
            tf_cheque_bank1.setEnabled(false);
            tf_cheque_no1.setEnabled(false);
        }

        tf_check_holder.setText(to.check_holder);
        tf_cheque_bank1.setText(to.cheque_bank);
        tf_cheque_no1.setText(to.cheque_no);
        try {
            Date d = DateType.sf.parse(to.cheque_date);
            jDateChooser3.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_touchscreen_cashcount.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void update_cash_drawer_accounts_receivables() {

        Field.Combo c_type = (Field.Combo) tf_charge_type;
        Field.Search c_customer = (Field.Search) jTextField55;
        int row = tbl_cash_drawer_accounts_receivables.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_account_receivables.to_cash_drawer_accounts_receivables to = (CashDrawer_account_receivables.to_cash_drawer_accounts_receivables) CashDrawer_tables.tbl_cash_drawer_accounts_receivables_ALM.get(row);
        int id = to.id;
        String user_id = to.user_id;
        String user_screen_name = to.user_screen_name;
        String date_added = DateType.now();
        String charge_type_id = c_type.getId();
        String charge_type = tf_charge_type.getText();
        String reference_no = tf_reference_no.getText();
        String customer_id = c_customer.getId();
        String customer_name = jTextField55.getText();
        double cash_amount = 0;
        double cheque_amount = 0;
        if (jCheckBox4.isSelected()) {
            cash_amount = FitIn.toDouble(jTextField56.getText());
        } else {
            cheque_amount = FitIn.toDouble(jTextField56.getText());
        }
        String check_holder = tf_check_holder.getText();
        String cheque_bank = tf_cheque_bank1.getText();
        String cheque_no = tf_cheque_no1.getText();
        String cheque_date = DateType.sf.format(jDateChooser3.getDate());
        CashDrawer_account_receivables.to_cash_drawer_accounts_receivables to1 = new CashDrawer_account_receivables.to_cash_drawer_accounts_receivables(id, user_id, user_screen_name, date_added, charge_type_id, charge_type, reference_no, customer_id, customer_name, cash_amount, cheque_amount, check_holder, cheque_bank, cheque_no, cheque_date);
        CashDrawer_account_receivables.update_data(to1);
        c_type.setId("");
        tf_charge_type.setText("");
        tf_reference_no.setText("");
        c_customer.setId("");
        jTextField55.setText("");
        tf_check_holder.setText("");
        tf_cheque_bank1.setText("");
        tf_cheque_no1.setText("");
        jTextField56.setText("");
        tf_charge_type.grabFocus();
        ret_cash_drawer_ar();
    }

    private void delete_cash_drawer_accounts_receivables() {
        Field.Combo c_type = (Field.Combo) tf_charge_type;
        Field.Combo c_customer = (Field.Combo) jTextField55;
        int row = tbl_cash_drawer_accounts_receivables.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_account_receivables.to_cash_drawer_accounts_receivables to = (CashDrawer_account_receivables.to_cash_drawer_accounts_receivables) CashDrawer_tables.tbl_cash_drawer_accounts_receivables_ALM.get(row);
        CashDrawer_account_receivables.delete_data(to);
        c_type.setId("");
        tf_charge_type.setText("");
        tf_reference_no.setText("");
        c_customer.setId("");
        jTextField55.setText("");
        tf_check_holder.setText("");
        tf_cheque_bank1.setText("");
        tf_cheque_no1.setText("");
        jTextField56.setText("");
        tf_charge_type.grabFocus();
        ret_cash_drawer_ar();
    }

    private void init_remit_type() {
        if (jCheckBox6.isSelected()) {
            tf_check_holder1.setEnabled(false);
            tf_cheque_bank2.setEnabled(false);
            tf_cheque_no2.setEnabled(false);
            jDateChooser4.setEnabled(false);
            tf_check_holder1.setText("");
            tf_cheque_no2.setText("");
        } else {
            tf_check_holder1.setEnabled(true);
            tf_cheque_bank2.setEnabled(true);
            tf_cheque_no2.setEnabled(true);
            jDateChooser4.setEnabled(true);
        }
    }

    private void add_cash_drawer_remittances() {

        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        double cash_amount = FitIn.toDouble(tf_remit_amount.getText());
        double cheque_amount = FitIn.toDouble(tf_remit_amount.getText());
        String cheque_holder = tf_check_holder1.getText();
        String cheque_bank = tf_cheque_bank2.getText();
        String cheque_no = tf_cheque_no2.getText();
        String cheque_date = DateType.sf.format(jDateChooser4.getDate());
        int status = 0;
        if (jCheckBox6.isSelected()) {
            cheque_amount = 0;
        } else {
            cash_amount = 0;
        }
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        CashDrawer_remittances.to_cash_drawer_remittances to = new CashDrawer_remittances.to_cash_drawer_remittances(id, user_id, user_screen_name, date_added, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, status, branch, branch_id, location, location_id);
        CashDrawer_remittances.add_data(to);

        tf_check_holder1.setText("");
        tf_cheque_bank2.setText("");
        tf_cheque_no2.setText("");
        tf_remit_amount.setText("");
        ret_cash_drawer_remit();
    }

    private void select_cash_drawer_remittances() {

        int row = tbl_cash_drawer_remittances.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_remittances.to_cash_drawer_remittances to = (CashDrawer_remittances.to_cash_drawer_remittances) CashDrawer_tables.tbl_cash_drawer_remittances_ALM.get(row);
        try {
            Date d = DateType.sf.parse(to.cheque_date);
            jDateChooser4.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_touchscreen_cashcount.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (to.cash_amount > 0) {
            tf_remit_amount.setText(FitIn.fmt_wc_0(to.cash_amount));
        } else {
            tf_remit_amount.setText(FitIn.fmt_wc_0(to.cheque_amount));
        }
        tf_check_holder1.setText(to.cheque_holder);
        tf_cheque_bank2.setText(to.cheque_bank);
        tf_cheque_no2.setText(to.cheque_no);

    }

    private void update_cash_drawer_remittances() {

        int row = tbl_cash_drawer_remittances.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_remittances.to_cash_drawer_remittances to = (CashDrawer_remittances.to_cash_drawer_remittances) CashDrawer_tables.tbl_cash_drawer_remittances_ALM.get(row);

        int id = to.id;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        double cash_amount = FitIn.toDouble(tf_remit_amount.getText());
        double cheque_amount = FitIn.toDouble(tf_remit_amount.getText());
        String cheque_holder = tf_check_holder1.getText();
        String cheque_bank = tf_cheque_bank2.getText();
        String cheque_no = tf_cheque_no2.getText();
        String cheque_date = DateType.sf.format(jDateChooser4.getDate());
        int status = 0;
        if (jCheckBox6.isSelected()) {
            cheque_amount = 0;
        } else {
            cash_amount = 0;
        }
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        CashDrawer_remittances.to_cash_drawer_remittances to1 = new CashDrawer_remittances.to_cash_drawer_remittances(id, user_id, user_screen_name, date_added, cash_amount, cheque_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, status, branch, branch_id, location, location_id);
        CashDrawer_remittances.update_data(to1);
        tf_check_holder1.setText("");
        tf_cheque_bank2.setText("");
        tf_cheque_no2.setText("");
        tf_remit_amount.setText("");
        ret_cash_drawer_remit();

    }

    private void delete_cash_drawer_remittances() {

        int row = tbl_cash_drawer_remittances.getSelectedRow();
        if (row < 0) {
            return;
        }
        CashDrawer_remittances.to_cash_drawer_remittances to = (CashDrawer_remittances.to_cash_drawer_remittances) CashDrawer_tables.tbl_cash_drawer_remittances_ALM.get(row);
        CashDrawer_remittances.delete_data(to);
        tf_check_holder1.setText("");
        tf_cheque_bank2.setText("");
        tf_cheque_no2.setText("");
        tf_remit_amount.setText("");
        ret_cash_drawer_remit();

    }

    private List<Srpt_cc_cash.field> get_cash() {
        List<Srpt_cc_cash.field> datas = new ArrayList();
        String user_id = MyUser.getUser_id();
        String date = DateType.sf.format(new Date());
        String where = " where session_no='" + user_id + "' and Date(time_in)='" + date + "' ";
        CashDrawer.to_cash_drawer to = CashDrawer.ret_to(where);
        if (to != null) {
            double amount = to.amount;
            double thousand = to.thousand;
            double five_hundred = to.five_hundred;
            double two_hundred = to.two_hundred;
            double fifty = to.fifty;
            double twenty = to.twenty;
            double one_hundred = to.one_hundred;
            double ten = to.ten;
            double five = to.five;
            double one = to.one;
            double point_five = to.point_five;
            double point_two_five = to.point_two_five;
            double point_ten = to.point_ten;
            double point_zero_five = to.point_zero_five;
            double total
                    = (amount)
                    + (thousand * 1000)
                    + (five_hundred * 500)
                    + (two_hundred * 200)
                    + (one_hundred * 100)
                    + (fifty * 50)
                    + (twenty * 50)
                    + (ten * 10)
                    + (five * 5)
                    + (one * 1)
                    + (point_five * .50)
                    + (point_two_five * .25)
                    + (point_ten * .10)
                    + (point_zero_five * .05);
            Srpt_cc_cash.field field = new Srpt_cc_cash.field(amount, thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, ten, five, one, point_five, point_two_five, point_ten, point_five, total);

            datas.add(field);
        }

        return datas;
    }

    private void init_report() {
        Button.Print search = (Button.Print) jButton10;
        search.load();
        Thread t;
        t = new Thread(new Runnable() {

            @Override
            public void run() {

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String contact_no = System.getProperty("telephone_number", "");
                String address = System.getProperty("address", "Canlas Subdivision, Lower Bagacay, Dumaguete City, Negros Oriental "
                        + "");
                address = address + "\n" + contact_no;
                String date = "Date as of 11/24/14 - 11/24/14";

                String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "retail_res\\rpt2\\";
                double total_cash_sales = 0;
                double total_cash_prepaid = 0;
                double total_cash_ar = 0;
                double total_disbursement = 0;
                double total_cash_sub = 0;
                double total_cash_net = 0;
                double total_cheque_sales = 0;
                double total_cheque_prepaid = 0;
                double total_cheque_ar = 0;
                double total_cheque_net = 0;
                double total_gc = 0;
                double total_cc = 0;
                List<Srpt_cc_cash.field> rpt_cash = get_cash();
                for (Srpt_cc_cash.field to : rpt_cash) {
                    total_cash_sales = to.getAmount();
                }
                List<Srpt_cc_gc.field> rpt_gc = Srpt_cc_gc.ret_data(CashDrawer_tables.tbl_cash_drawer_gift_certificates_ALM);
                for (Srpt_cc_gc.field to : rpt_gc) {
                    total_gc += to.getAmount();

                }
                List<Srpt_cc_prepaid.field> rpt_prepaid = Srpt_cc_prepaid.ret_data(CashDrawer_tables.tbl_cash_drawer_prepaids_ALM);
                for (Srpt_cc_prepaid.field to : rpt_prepaid) {
                    if (to.getTransaction_type().equalsIgnoreCase("Cash")) {
                        total_cash_prepaid += to.getAmount();
                    } else {
                        total_cheque_prepaid += to.getAmount();
                    }
                }

                List<Srpt_cc_cheque.field> rpt_cheque = Srpt_cc_cheque.ret_data(CashDrawer_tables.tbl_cash_drawer_cheques_ALM);
                for (Srpt_cc_cheque.field to : rpt_cheque) {
                    total_cheque_sales += to.getAmount();
                }
                List<Srpt_cc_ar.field> rpt_ar = Srpt_cc_ar.ret_data(CashDrawer_tables.tbl_cash_drawer_accounts_receivables_ALM);
                for (Srpt_cc_ar.field to : rpt_ar) {
                    if (to.getTransaction_type().equalsIgnoreCase("Cash")) {
                        total_cash_ar += to.getAmount();
                    } else {
                        total_cheque_ar += to.getAmount();
                    }
                }
                total_cash_sub = total_cash_sales + total_cash_prepaid + total_cash_ar;
                String user_id = MyUser.getUser_id();
                String date1 = DateType.sf.format(new Date());
                String where = " where user_id='" + user_id + "' and Date(date_added)='" + date1 + "' ";
                List<Srpt_cc_disbursement.field> rpt_disbursement = Srpt_cc_disbursement.ret_data(where);
                for (Srpt_cc_disbursement.field to : rpt_disbursement) {
                    total_disbursement += to.getAmount();
                }
                List<Srpt_cc_credit_card.field> rpt_credit_card = Srpt_cc_credit_card.ret_data(CashDrawer_tables.tbl_cash_drawer_credit_cards_ALM);
                for (Srpt_cc_credit_card.field to : rpt_credit_card) {
                    total_cc += to.getAmount();
                }

                total_cash_net = total_cash_sub - total_disbursement;

                String prepared_by = "";
                String checked_by = "";
                String deposited_by = "";
                List<Srpt_cc_remit.field> rpt_remit = Srpt_cc_remit.ret_data(CashDrawer_tables.tbl_cash_drawer_remittances_ALM);
                double total_remit_cash = 0;
                double total_remit_cheque = 0;
                for (Srpt_cc_remit.field to : rpt_remit) {
                    if (to.getTransaction_type().equalsIgnoreCase("Cash")) {
                        total_remit_cash += to.getAmount();
                    } else {
                        total_remit_cheque += to.getAmount();
                    }
                }
                total_cheque_net = (total_cheque_sales + total_cheque_prepaid + total_cheque_ar) - total_remit_cheque;
                total_cash_net = total_cash_sub - (total_disbursement + total_remit_cash);
                Srpt_cc rpt = new Srpt_cc(
                        business_name.toUpperCase(), address, contact_no, date, SUBREPORT_DIR, rpt_cash, rpt_gc, rpt_prepaid, rpt_cheque, rpt_ar, rpt_disbursement, rpt_credit_card, rpt_remit, total_cash_sales, total_cash_prepaid, total_cash_ar, total_disbursement, total_cash_sub, total_cash_net, total_cheque_sales, total_cheque_prepaid, total_cheque_ar, total_cheque_net, total_gc, total_cc, prepared_by, checked_by, deposited_by, total_remit_cash, total_remit_cheque
                );
                String jrxml = "rpt_cc.jrxml";
                report_sales_items(rpt, jrxml);

                Button.Print search = (Button.Print) jButton10;
                search.finish();
                jPanel1.updateUI();
                pnl_report.updateUI();
            }
        });
        t.start();

    }

    private void report_sales_items(final Srpt_cc to, String jrxml_name) {
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

    public static JRViewer get_viewer_expenses(Srpt_cc to, String rpt_name) {
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
            InputStream is = Srpt_cc.class.getResourceAsStream(jrxml);
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

}
