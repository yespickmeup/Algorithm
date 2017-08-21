
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.touchscreen_reports.Dlg_report_ar_payments;
import POS.touchscreen_reports.Dlg_report_ledger;
import POS.touchscreen_reports.Dlg_report_prepaid_payments;
import POS.touchscreen_reports.Dlg_report_sales_by_item;
import POS.touchscreen_reports.Dlg_report_sales_summary;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_cashier_reports extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_cashier_reports
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
    private Dlg_touchscreen_cashier_reports(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_cashier_reports(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_cashier_reports() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_cashier_reports myRef;

    private void setThisRef(Dlg_touchscreen_cashier_reports myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_cashier_reports> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_cashier_reports create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_cashier_reports create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_cashier_reports dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_cashier_reports((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_cashier_reports dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_cashier_reports((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_cashier_reports dialog = Dlg_touchscreen_cashier_reports.create(new javax.swing.JFrame(), true);
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
        pnl_holder = new javax.swing.JPanel();
        pnl_summary = new javax.swing.JPanel();
        pnl_cashcount = new javax.swing.JPanel();
        pnl_ledger = new javax.swing.JPanel();
        pnl_item = new javax.swing.JPanel();
        pnl_transaction = new javax.swing.JPanel();
        pnl_remittance = new javax.swing.JPanel();
        pnl_ar_payments = new javax.swing.JPanel();
        pnl_prepaid_payments = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pnl_holder.setBackground(new java.awt.Color(255, 255, 255));
        pnl_holder.setLayout(new java.awt.CardLayout());

        pnl_summary.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_summaryLayout = new javax.swing.GroupLayout(pnl_summary);
        pnl_summary.setLayout(pnl_summaryLayout);
        pnl_summaryLayout.setHorizontalGroup(
            pnl_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_summaryLayout.setVerticalGroup(
            pnl_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_summary, "card2");

        pnl_cashcount.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_cashcountLayout = new javax.swing.GroupLayout(pnl_cashcount);
        pnl_cashcount.setLayout(pnl_cashcountLayout);
        pnl_cashcountLayout.setHorizontalGroup(
            pnl_cashcountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_cashcountLayout.setVerticalGroup(
            pnl_cashcountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_cashcount, "card3");

        pnl_ledger.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_ledgerLayout = new javax.swing.GroupLayout(pnl_ledger);
        pnl_ledger.setLayout(pnl_ledgerLayout);
        pnl_ledgerLayout.setHorizontalGroup(
            pnl_ledgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_ledgerLayout.setVerticalGroup(
            pnl_ledgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_ledger, "card3");

        pnl_item.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_itemLayout = new javax.swing.GroupLayout(pnl_item);
        pnl_item.setLayout(pnl_itemLayout);
        pnl_itemLayout.setHorizontalGroup(
            pnl_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_itemLayout.setVerticalGroup(
            pnl_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_item, "card3");

        pnl_transaction.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_transactionLayout = new javax.swing.GroupLayout(pnl_transaction);
        pnl_transaction.setLayout(pnl_transactionLayout);
        pnl_transactionLayout.setHorizontalGroup(
            pnl_transactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_transactionLayout.setVerticalGroup(
            pnl_transactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_transaction, "card6");

        pnl_remittance.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_remittanceLayout = new javax.swing.GroupLayout(pnl_remittance);
        pnl_remittance.setLayout(pnl_remittanceLayout);
        pnl_remittanceLayout.setHorizontalGroup(
            pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_remittanceLayout.setVerticalGroup(
            pnl_remittanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_remittance, "card7");

        pnl_ar_payments.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_ar_paymentsLayout = new javax.swing.GroupLayout(pnl_ar_payments);
        pnl_ar_payments.setLayout(pnl_ar_paymentsLayout);
        pnl_ar_paymentsLayout.setHorizontalGroup(
            pnl_ar_paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_ar_paymentsLayout.setVerticalGroup(
            pnl_ar_paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_ar_payments, "card7");

        pnl_prepaid_payments.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_prepaid_paymentsLayout = new javax.swing.GroupLayout(pnl_prepaid_payments);
        pnl_prepaid_payments.setLayout(pnl_prepaid_paymentsLayout);
        pnl_prepaid_paymentsLayout.setHorizontalGroup(
            pnl_prepaid_paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        pnl_prepaid_paymentsLayout.setVerticalGroup(
            pnl_prepaid_paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnl_holder.add(pnl_prepaid_payments, "card7");

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));

        jButton3.setBackground(new java.awt.Color(4, 100, 217));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/summary.png"))); // NOI18N
        jButton3.setToolTipText("Sales Summary");
        buttonGroup1.add(jButton3);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setOpaque(true);
        jButton3.setSelected(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(244, 244, 244));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/abacus7.png"))); // NOI18N
        jButton4.setToolTipText("Cash Count");
        buttonGroup1.add(jButton4);
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
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/seo2 (1).png"))); // NOI18N
        jButton5.setToolTipText("Sales Transactions");
        buttonGroup1.add(jButton5);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setOpaque(true);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(244, 244, 244));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/item.png"))); // NOI18N
        jButton6.setToolTipText("Sales by Item");
        buttonGroup1.add(jButton6);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.setOpaque(true);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
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
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/strategical.png"))); // NOI18N
        jButton8.setToolTipText("Void/Item Replacements/Print");
        buttonGroup1.add(jButton8);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setOpaque(true);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(244, 244, 244));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/moneybox (1).png"))); // NOI18N
        jButton9.setToolTipText("Remitances");
        buttonGroup1.add(jButton9);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setOpaque(true);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(244, 244, 244));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/Currencies_symbols_on_a_hand_32.png"))); // NOI18N
        jButton10.setToolTipText("AR Payments");
        jButton10.setContentAreaFilled(false);
        jButton10.setFocusable(false);
        jButton10.setOpaque(true);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(244, 244, 244));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/touchscreen_icons/Prepaid_card_in_a_hand_32.png"))); // NOI18N
        jButton11.setToolTipText("Prepaid Payments");
        jButton11.setContentAreaFilled(false);
        jButton11.setFocusable(false);
        jButton11.setOpaque(true);
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(1, 1, 1)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cardLayout.show(pnl_holder, "1");


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cardLayout.show(pnl_holder, "2");


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cardLayout.show(pnl_holder, "3");


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cardLayout.show(pnl_holder, "4");


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        get_selected_button(0);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        get_selected_button(1);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        cardLayout.show(pnl_holder, "5");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        get_selected_button(2);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        cardLayout.show(pnl_holder, "6");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        cardLayout.show(pnl_holder, "7");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        cardLayout.show(pnl_holder, "8");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        get_selected_button(3);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        get_selected_button(4);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        get_selected_button(5);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
//         jButton3.setBackground(new java.awt.Color(4, 144, 217));
    }//GEN-LAST:event_jButton3MouseEntered

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnl_ar_payments;
    private javax.swing.JPanel pnl_cashcount;
    private javax.swing.JPanel pnl_holder;
    private javax.swing.JPanel pnl_item;
    private javax.swing.JPanel pnl_ledger;
    private javax.swing.JPanel pnl_prepaid_payments;
    private javax.swing.JPanel pnl_remittance;
    private javax.swing.JPanel pnl_summary;
    private javax.swing.JPanel pnl_transaction;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        System.setProperty("pool_db", "db_smis_cebu_chickaloka");

        init_key();

        init_panel_layout();
        get_privelege();

        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton9.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton8.setEnabled(true);

        if (jButton3.isEnabled()) {
            init_sales_summary();
        }

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                init_cash_count();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        init_ar_payments();
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                init_ledger();
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        init_prepaid_payments();
                                        SwingUtilities.invokeLater(new Runnable() {
                                            @Override
                                            public void run() {
                                                init_remitance();
                                                SwingUtilities.invokeLater(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        init_sales_by_item();
                                                        SwingUtilities.invokeLater(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                init_transaction();
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

    }

    private void get_privelege() {
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton9.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton8.setEnabled(false);
        jButton10.setEnabled(false);
        jButton11.setEnabled(false);

        String where = " where user_id='" + MyUser.getUser_id() + "' and account like 'Sales' ";
        List<S1_user_previleges.to_user_previleges> list = S1_user_previleges.ret_data(where);
        for (S1_user_previleges.to_user_previleges li : list) {
            if (li.previledge.equalsIgnoreCase("Cashier Report - Sales Summary")) {
                jButton3.setEnabled(true);
            }
            if (li.previledge.equalsIgnoreCase("Cashier Report - Cash Count")) {
                jButton4.setEnabled(true);
            }
            if (li.previledge.equalsIgnoreCase("Cashier Report - Remittance")) {
                jButton9.setEnabled(true);
            }
            if (li.previledge.equalsIgnoreCase("Cashier Report - Sales Ledger")) {
                jButton5.setEnabled(true);
            }
            if (li.previledge.equalsIgnoreCase("Cashier Report - Sales by Item")) {
                jButton6.setEnabled(true);
            }
            if (li.previledge.equalsIgnoreCase("Cashier Report - Void/Replacement")) {
                jButton8.setEnabled(true);
            }
            if (li.previledge.equalsIgnoreCase("Cashier Report - AR Payments")) {
//                jButton10.setEnabled(true);
            }
            if (li.previledge.equalsIgnoreCase("Cashier Report - Prepaid Payments")) {
//                jButton11.setEnabled(true);
            }

        }

    }
    int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0;

    CardLayout cardLayout = new CardLayout();

    private void init_panel_layout() {
        cardLayout = (CardLayout) pnl_holder.getLayout();
        cardLayout.addLayoutComponent("1", pnl_summary);
        cardLayout.addLayoutComponent("2", pnl_cashcount);
        cardLayout.addLayoutComponent("3", pnl_ledger);
        cardLayout.addLayoutComponent("4", pnl_item);
        cardLayout.addLayoutComponent("5", pnl_transaction);
        cardLayout.addLayoutComponent("6", pnl_remittance);
        cardLayout.addLayoutComponent("7", pnl_ar_payments);
        cardLayout.addLayoutComponent("8", pnl_prepaid_payments);
    }

    private void init_sales_summary() {

        Dlg_report_sales_summary summary = new Dlg_report_sales_summary();
        pnl_summary.setLayout(new BorderLayout());
        pnl_summary.add(summary.getSurface());
        pnl_holder.updateUI();

    }

    private void init_cash_count() {

        Dlg_touchscreen_report_cashcount cashcount = new Dlg_touchscreen_report_cashcount();
        pnl_cashcount.setLayout(new BorderLayout());
        pnl_cashcount.add(cashcount.getSurface());
        pnl_holder.updateUI();

    }

    private void init_ledger() {

        Dlg_report_ledger ledger = new Dlg_report_ledger();
        pnl_ledger.setLayout(new BorderLayout());
        pnl_ledger.add(ledger.getSurface());
        pnl_holder.updateUI();

    }

    private void init_sales_by_item() {

        Dlg_report_sales_by_item item = new Dlg_report_sales_by_item();
        pnl_item.setLayout(new BorderLayout());
        pnl_item.add(item.getSurface());
        pnl_holder.updateUI();

    }

    private void init_transaction() {

        Dlg_touchscreen_transactions transaction = new Dlg_touchscreen_transactions();
        transaction.do_pass(Dlg_touchscreen_cashier_reports.this);
        pnl_transaction.setLayout(new BorderLayout());
        pnl_transaction.add(transaction.getSurface());
        pnl_holder.updateUI();

    }

    private void init_remitance() {

        Dlg_touchscreen_report_remittance remittance = new Dlg_touchscreen_report_remittance();
        pnl_remittance.setLayout(new BorderLayout());
        pnl_remittance.add(remittance.getSurface());
        pnl_holder.updateUI();

    }

    private void init_ar_payments() {

        Dlg_report_ar_payments remittance = new Dlg_report_ar_payments();
        pnl_ar_payments.setLayout(new BorderLayout());
        pnl_ar_payments.add(remittance.getSurface());
        pnl_holder.updateUI();

    }

    private void init_prepaid_payments() {

        Dlg_report_prepaid_payments remittance = new Dlg_report_prepaid_payments();
        pnl_prepaid_payments.setLayout(new BorderLayout());
        pnl_prepaid_payments.add(remittance.getSurface());
        pnl_holder.updateUI();

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
    //<editor-fold defaultstate="collapsed" desc=" drag dialog ">
    int posX = 0, posY = 0;

    private void init_drag() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
            }
        });
    }
//</editor-fold>

    private void get_selected_button(int index) {
        JButton[] btns = {jButton3, jButton4, jButton9, jButton5, jButton6, jButton8};
        for (int i = 0; i < btns.length; i++) {
            if (i == index) {
                btns[i].setBackground(new java.awt.Color(4, 100, 217));
            } else {
                btns[i].setBackground(new java.awt.Color(244, 244, 244));
            }
        }
    }
}
