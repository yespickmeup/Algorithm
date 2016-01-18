/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.banks.S1_banks;
import POS.bir_session.Srpt_checks;
import POS.cash_drawer.S1_cash_drawer.to_cash_drawer;
import POS.cash_drawer.S1_cash_drawer_checks.to_cash_drawer_checks;
import POS.cash_drawer.S1_cash_drawer_expenses.to_cash_drawer_expenses;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.Placeholder;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author Maytopacka
 */
public class Dlg_cash_out extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cash_out
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

        public final S1_cash_drawer.to_cash_drawer drawer;

        public OutputData(to_cash_drawer drawer) {
            this.drawer = drawer;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_cash_out(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_cash_out(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_cash_out() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_cash_out myRef;

    private void setThisRef(Dlg_cash_out myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cash_out> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cash_out create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cash_out create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cash_out dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cash_out((java.awt.Frame) parent, false);
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
            Dlg_cash_out dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cash_out((java.awt.Dialog) parent, false);
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

        Dlg_cash_out dialog = Dlg_cash_out.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnl_cash = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_1000 = new javax.swing.JTextField();
        tf_500 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_200 = new javax.swing.JTextField();
        tf_100 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_50 = new javax.swing.JTextField();
        tf_20 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_coins = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_cash_in = new javax.swing.JTextField();
        lbl_cash_total = new javax.swing.JTextField();
        pnl_expenses = new javax.swing.JPanel();
        tf_expense_name = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_cash_drawer_expenses = new javax.swing.JTable();
        tf_expense_amount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_expenses_total = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tf_21 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tf_22 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tf_23 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tf_24 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tf_25 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tf_26 = new javax.swing.JTextField();
        pnl_check = new javax.swing.JPanel();
        tf_bank = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cash_drawer_checks = new javax.swing.JTable();
        tf_check_paid = new javax.swing.JTextField();
        tf_check_no = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lbl_check_total = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_total = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(104, 95, 84));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnl_cash.setBackground(new java.awt.Color(237, 235, 233));
        pnl_cash.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CASH (F1)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 25))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("1,000.00");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("X");

        tf_1000.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_1000.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_1000.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_1000KeyReleased(evt);
            }
        });

        tf_500.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_500.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_500.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_500KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("X");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("500.00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("200.00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("X");

        tf_200.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_200.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_200.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_200KeyReleased(evt);
            }
        });

        tf_100.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_100.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_100.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_100KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("X");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("100.00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("50.00");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("X");

        tf_50.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_50.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_50KeyReleased(evt);
            }
        });

        tf_20.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_20.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_20KeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("X");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("20.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("0.05");

        tf_coins.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_coins.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_coins.setNextFocusableComponent(tf_1000);
        tf_coins.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_coinsKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Sub-total");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("CASH IN");

        tf_cash_in.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_cash_in.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_cash_in.setFocusable(false);
        tf_cash_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cash_inKeyReleased(evt);
            }
        });

        lbl_cash_total.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_cash_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_cash_total.setText("0.00");

        pnl_expenses.setBackground(new java.awt.Color(255, 255, 255));
        pnl_expenses.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EXPENSES (F3)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tf_expense_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tbl_cash_drawer_expenses.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_cash_drawer_expenses);

        tf_expense_amount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_expense_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_expense_amount.setNextFocusableComponent(tf_bank);
        tf_expense_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_expense_amountActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Sub-total");

        lbl_expenses_total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_expenses_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_expenses_total.setText("0.00");
        lbl_expenses_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnl_expensesLayout = new javax.swing.GroupLayout(pnl_expenses);
        pnl_expenses.setLayout(pnl_expensesLayout);
        pnl_expensesLayout.setHorizontalGroup(
            pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_expensesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_expensesLayout.createSequentialGroup()
                            .addComponent(tf_expense_name, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(tf_expense_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnl_expensesLayout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_expenses_total, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_expensesLayout.setVerticalGroup(
            pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_expensesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_expense_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_expense_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_expenses_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("10.00");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel22.setText("X");

        tf_21.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_21.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_21KeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("5.00");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel24.setText("X");

        tf_22.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_22.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_22KeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("1.00");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel26.setText("X");

        tf_23.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_23.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_23KeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("0.50");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel28.setText("X");

        tf_24.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_24.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_24KeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("0.25");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel30.setText("X");

        tf_25.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_25.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_25KeyReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel31.setText("X");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("0.10");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel33.setText("X");

        tf_26.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_26.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_26KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnl_cashLayout = new javax.swing.GroupLayout(pnl_cash);
        pnl_cash.setLayout(pnl_cashLayout);
        pnl_cashLayout.setHorizontalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cashLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(pnl_cashLayout.createSequentialGroup()
                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(pnl_expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_cash_total, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(28, 28, 28))
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)))
                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_22, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_21)
                                        .addComponent(tf_20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                        .addComponent(tf_50, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tf_100, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tf_200, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tf_500, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tf_1000, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tf_cash_in, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)))
                                .addComponent(tf_23, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)))
                                .addComponent(tf_24, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnl_cashLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(28, 28, 28))
                                    .addGroup(pnl_cashLayout.createSequentialGroup()
                                        .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_coins, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_25, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        pnl_cashLayout.setVerticalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createSequentialGroup()
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_cash_in, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_1000, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_500, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_200, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_100, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_50, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_25, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_coins, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_cash_total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnl_check.setBackground(new java.awt.Color(255, 255, 255));
        pnl_check.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHECK (F2)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tf_bank.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bankActionPerformed(evt);
            }
        });

        tbl_cash_drawer_checks.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_cash_drawer_checks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_checksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cash_drawer_checks);

        tf_check_paid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_check_paid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_check_paid.setNextFocusableComponent(tf_bank);
        tf_check_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_paidActionPerformed(evt);
            }
        });

        tf_check_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_noActionPerformed(evt);
            }
        });

        jLabel15.setText("CHECK NO:");

        lbl_check_total.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_check_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_check_total.setText("0.00");
        lbl_check_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_check_totalActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Sub-total");

        javax.swing.GroupLayout pnl_checkLayout = new javax.swing.GroupLayout(pnl_check);
        pnl_check.setLayout(pnl_checkLayout);
        pnl_checkLayout.setHorizontalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_checkLayout.createSequentialGroup()
                        .addComponent(tf_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(tf_check_paid))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_checkLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_checkLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(152, 152, 152)
                        .addComponent(lbl_check_total, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_checkLayout.setVerticalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_check_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_check_no, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addGroup(pnl_checkLayout.createSequentialGroup()
                        .addComponent(lbl_check_total, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_cash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_total.setBackground(new java.awt.Color(104, 95, 84));
        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0.00 ");
        lbl_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_total.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("TOTAL:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 2, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Please double check Cash Count before leaving.  ( PRESS CONTROL to SAVE )");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_1000KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_1000KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_1000KeyReleased

    private void tf_500KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_500KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_500KeyReleased

    private void tf_200KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_200KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_200KeyReleased

    private void tf_100KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_100KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_100KeyReleased

    private void tf_50KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_50KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_50KeyReleased

    private void tf_20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_20KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_20KeyReleased

    private void tf_coinsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_coinsKeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_coinsKeyReleased

    private void tf_check_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_paidActionPerformed
        // TODO add your handling code here:
        tf_check_no.grabFocus();

    }//GEN-LAST:event_tf_check_paidActionPerformed

    private void tf_cash_inKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cash_inKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cash_inKeyReleased

    private void tf_expense_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_expense_amountActionPerformed
        // TODO add your handling code here:
        add_expenses();
    }//GEN-LAST:event_tf_expense_amountActionPerformed

    private void tf_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_noActionPerformed
        // TODO add your handling code here:
        add_bank();
    }//GEN-LAST:event_tf_check_noActionPerformed

    private void tf_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bankActionPerformed
        init_bank();
    }//GEN-LAST:event_tf_bankActionPerformed

    private void tbl_cash_drawer_checksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_checksMouseClicked
        delete_check();
    }//GEN-LAST:event_tbl_cash_drawer_checksMouseClicked

    private void lbl_check_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_check_totalActionPerformed

    }//GEN-LAST:event_lbl_check_totalActionPerformed

    private void tf_21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_21KeyReleased
        compute_cash();
    }//GEN-LAST:event_tf_21KeyReleased

    private void tf_22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_22KeyReleased
        compute_cash();
    }//GEN-LAST:event_tf_22KeyReleased

    private void tf_23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_23KeyReleased
        compute_cash();
    }//GEN-LAST:event_tf_23KeyReleased

    private void tf_24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_24KeyReleased
        compute_cash();
    }//GEN-LAST:event_tf_24KeyReleased

    private void tf_25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_25KeyReleased
        compute_cash();
    }//GEN-LAST:event_tf_25KeyReleased

    private void tf_26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_26KeyReleased
        compute_cash();
    }//GEN-LAST:event_tf_26KeyReleased
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField lbl_cash_total;
    private javax.swing.JTextField lbl_check_total;
    private javax.swing.JLabel lbl_expenses_total;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel pnl_cash;
    private javax.swing.JPanel pnl_check;
    private javax.swing.JPanel pnl_expenses;
    private javax.swing.JTable tbl_cash_drawer_checks;
    private javax.swing.JTable tbl_cash_drawer_expenses;
    private javax.swing.JTextField tf_100;
    private javax.swing.JTextField tf_1000;
    private javax.swing.JTextField tf_20;
    private javax.swing.JTextField tf_200;
    private javax.swing.JTextField tf_21;
    private javax.swing.JTextField tf_22;
    private javax.swing.JTextField tf_23;
    private javax.swing.JTextField tf_24;
    private javax.swing.JTextField tf_25;
    private javax.swing.JTextField tf_26;
    private javax.swing.JTextField tf_50;
    private javax.swing.JTextField tf_500;
    private javax.swing.JTextField tf_bank;
    private javax.swing.JTextField tf_cash_in;
    private javax.swing.JTextField tf_check_no;
    private javax.swing.JTextField tf_check_paid;
    private javax.swing.JTextField tf_coins;
    private javax.swing.JTextField tf_expense_amount;
    private javax.swing.JTextField tf_expense_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        init_key();
        choose_out(0);
        init_tbl_cash_drawer_checks();
        init_tbl_cash_drawer_expenses();
        placeholder();
        init_expenses();
        focus();
        pnl_expenses.setVisible(false);
    }

    private void placeholder() {
        Placeholder.set(tf_bank, "Select Bank");
        Placeholder.set(tf_check_paid, "Amount");
    }

    private void focus() {
        JTextField[] tf = {tf_1000, tf_500, tf_200, tf_100, tf_50, tf_20, tf_coins, tf_bank, tf_check_paid, tf_expense_name, tf_expense_amount, tf_check_no,tf_21,tf_22,tf_22,tf_23,tf_24,tf_25,tf_26};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    List<S1_banks.to_banks> discount_list = new ArrayList();

    private void init_bank() {
        String search = tf_bank.getText();
        discount_list.clear();
        String where = " where bank_name like '%" + search + "%' ";
        discount_list = S1_banks.ret_data2(where);
        Object[][] obj = new Object[discount_list.size()][1];
        int i = 0;
        for (S1_banks.to_banks to : discount_list) {
            obj[i][0] = " " + to.bank_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_bank.getWidth()};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_bank, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_banks.to_banks to = discount_list.get(data.selected_row);
                tf_bank.setText(to.bank_name);
                tf_check_paid.grabFocus();
            }
        });
    }

    private void init_expenses() {

    }

    public void do_pass_in(S1_cash_drawer.to_cash_drawer to) {
        tf_cash_in.setText(FitIn.fmt_woc(to_cash_drawer.amount));
        tf_cash_in.enable(false);
    }

    String ids = "";

    public void do_pass() {
        String user_name = Users.user_name;
        String date = DateType.sf.format(new Date());
        String where = " where user_name='" + user_name + "' and Date(time_in)='" + date + "' ";
        S1_cash_drawer.to_cash_drawer to = S1_cash_drawer.cash_drawer(where);
        ids = "" + to.id;
        tf_cash_in.setText(FitIn.fmt_woc(to_cash_drawer.amount));
        loadData_cash_drawer_checks(to.checks);
        loadData_cash_drawer_expenses(to.exp);
        compute_check();
        tf_1000.setText(FitIn.fmt_woc(to.thousand));
        tf_500.setText(FitIn.fmt_woc(to.five_hundred));
        tf_200.setText(FitIn.fmt_woc(to.two_hundred));
        tf_100.setText(FitIn.fmt_woc(to.one_hundred));
        tf_50.setText(FitIn.fmt_woc(to.fifty));
        tf_20.setText(FitIn.fmt_woc(to.twenty));

        tf_21.setText(FitIn.fmt_woc(to.ten));
        tf_22.setText(FitIn.fmt_woc(to.five));
        tf_23.setText(FitIn.fmt_woc(to.one));
        tf_24.setText(FitIn.fmt_woc(to.point_five));
        tf_25.setText(FitIn.fmt_woc(to.point_two_five));
        tf_26.setText(FitIn.fmt_woc(to.point_ten));
        tf_coins.setText(FitIn.fmt_woc(to.point_zero_five));

        compute_expenses();
        compute_cash();
        compute_all();
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
                              KeyEvent.VK_CONTROL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();

                choose_out(0);
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                choose_out(1);
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                choose_out(3);
            }
        });

        tf_check_paid.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_cash_drawer_checks_ALM.isEmpty()) {
                        tbl_cash_drawer_checks.setRowSelectionInterval(0, 0);
                        tbl_cash_drawer_checks.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tf_expense_amount.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_cash_drawer_expenses_ALM.isEmpty()) {
                        tbl_cash_drawer_expenses.setRowSelectionInterval(0, 0);
                        tbl_cash_drawer_expenses.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
            }
        });

        tbl_cash_drawer_checks.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    choose_out(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    delete_bank();
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tbl_cash_drawer_expenses.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    choose_out(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    delete_expenses();
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tf_1000.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
            }
        });
        tf_bank.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_expense_name.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tf_500.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_200.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_100.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_50.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_20.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_coins.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
    }
    // </editor-fold>

    private void choose_out(int stmt) {
        if (stmt == 0) {
            tf_1000.grabFocus();
            pnl_cash.setBackground(new java.awt.Color(237, 235, 233));
            pnl_check.setBackground(new java.awt.Color(255, 255, 255));
            pnl_expenses.setBackground(new java.awt.Color(255, 255, 255));
        }
        if (stmt == 1) {
            tf_bank.grabFocus();
            pnl_cash.setBackground(new java.awt.Color(255, 255, 255));
            pnl_expenses.setBackground(new java.awt.Color(255, 255, 255));
            pnl_check.setBackground(new java.awt.Color(237, 235, 233));
        }
        if (stmt == 3) {
            tf_expense_name.grabFocus();
            pnl_cash.setBackground(new java.awt.Color(255, 255, 255));
            pnl_check.setBackground(new java.awt.Color(255, 255, 255));
            pnl_expenses.setBackground(new java.awt.Color(237, 235, 233));

        }
    }

    private void compute_cash() {
        double thousand = FitIn.toDouble(tf_1000.getText()) * 1000;
        double f_hundred = FitIn.toDouble(tf_500.getText()) * 500;
        double two_hundred = FitIn.toDouble(tf_200.getText()) * 200;
        double hundred = FitIn.toDouble(tf_100.getText()) * 100;
        double fifty = FitIn.toDouble(tf_50.getText()) * 50;
        double twenty = FitIn.toDouble(tf_20.getText()) * 20;
        double coins = FitIn.toDouble(tf_coins.getText()) * 1;

        double ten = FitIn.toDouble(tf_21.getText()) * 10;
        double five = FitIn.toDouble(tf_22.getText()) * 5;
        double one = FitIn.toDouble(tf_23.getText()) * 1;
        double point_five = FitIn.toDouble(tf_24.getText()) * .5;
        double point_two_five = FitIn.toDouble(tf_25.getText()) * .25;
        double point_ten = FitIn.toDouble(tf_26.getText()) * .10;
        double point_zero_five = FitIn.toDouble(tf_coins.getText()) * .05;

        double total = thousand + f_hundred + two_hundred + hundred + fifty + twenty + ten + five + one + point_five + point_two_five + point_ten + point_zero_five;
        lbl_cash_total.setText(FitIn.fmt_wc_0(total));
        compute_all();

    }
    private ArrayListModel tbl_cash_drawer_checks_ALM;
    private Tblcash_drawer_checksModel tbl_cash_drawer_checks_M;

    private void init_tbl_cash_drawer_checks() {
        tbl_cash_drawer_checks_ALM = new ArrayListModel();
        tbl_cash_drawer_checks_M = new Tblcash_drawer_checksModel(tbl_cash_drawer_checks_ALM);
        tbl_cash_drawer_checks.getTableHeader().setPreferredSize(new Dimension(100, 0));
        tbl_cash_drawer_checks.setModel(tbl_cash_drawer_checks_M);
        tbl_cash_drawer_checks.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        int[] tbl_widths_cash_drawer_checks = {100, 100, 50, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_checks.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_checks, i, tbl_widths_cash_drawer_checks[i]);
        }

        tbl_cash_drawer_checks.setRowHeight(35);
        tbl_cash_drawer_checks.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_checks, 1);
    }

    private void loadData_cash_drawer_checks(List<to_cash_drawer_checks> acc) {
        tbl_cash_drawer_checks_ALM.clear();
        tbl_cash_drawer_checks_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_checksModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "", "", "", "", "time_in", "time_out", "BANK", "check_no", "check_holder", "AMOUNT"
        };

        public Tblcash_drawer_checksModel(ListModel listmodel) {
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
            to_cash_drawer_checks tt = (to_cash_drawer_checks) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.bank;
                case 1:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 2:
                    return " Delete";
                case 3:
                    return tt.id;
                case 4:
                    return tt.time_in;
                case 5:
                    return tt.time_out;
                case 6:
                    return tt.bank;
                case 7:
                    return tt.check_no;
                case 8:
                    return tt.check_holder;
                default:
                    return tt.amount;
            }
        }
    }

    private void data_checks() {
        String user_name = Users.user_name;
        String date = DateType.sf.format(new Date());
        String where = " where user_name='" + user_name + "' and Date(time_in)='" + date + "' ";
        List<to_cash_drawer_checks> datas = S1_cash_drawer_checks.ret_data2(where);
        loadData_cash_drawer_checks(datas);
        compute_check();
        compute_all();
    }

    private void delete_check() {
        int row = tbl_cash_drawer_checks.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_cash_drawer_checks to = (to_cash_drawer_checks) tbl_cash_drawer_checks_ALM.get(tbl_cash_drawer_checks.convertRowIndexToModel(row));
        int col = tbl_cash_drawer_checks.getSelectedColumn();
        if (col == 2) {
            S1_cash_drawer_checks.delete_cash_drawer_checks2("" + to.id);
            tf_bank.grabFocus();
            data_checks();
        }
    }

    private void add_bank() {
        int id = -1;
        String session_no = Users.session_no;
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = DateType.datetime.format(new Date());
        String time_out = DateType.datetime.format(new Date());
        String bank = tf_bank.getText();
        String check_no = tf_check_no.getText();
        String check_holder = "";
        double amount = FitIn.toDouble(tf_check_paid.getText());
        to_cash_drawer_checks to = new to_cash_drawer_checks(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount);
        List<to_cash_drawer_checks> data = new ArrayList();
        data.add(to);
        S1_cash_drawer_checks.add_cash_drawer_checks(data);
        data_checks();
        tf_bank.grabFocus();
        tf_check_paid.setText("");
        tf_check_no.setText("");
        tf_bank.setText("");
        compute_check();
        compute_all();
    }

    private void delete_bank() {
        int row = tbl_cash_drawer_checks.getSelectedRow();
        if (row < 0) {
            return;
        }

        if (Users.drawer.time_out == null) {
            tbl_cash_drawer_checks_ALM.remove(row);
            tbl_cash_drawer_checks_M.fireTableDataChanged();
            tf_bank.grabFocus();
            compute_check();
            compute_all();
        } else {

            to_cash_drawer_checks to = (to_cash_drawer_checks) tbl_cash_drawer_checks_ALM.
                    get(tbl_cash_drawer_checks.convertRowIndexToModel(row));
            S1_cash_drawer_checks.delete_cash_drawer_checks(to);
            loadData_cash_drawer_checks(S1_cash_drawer_checks.ret_data(Users.session_no));
            tf_bank.grabFocus();
            tf_check_paid.setText("");
            compute_check();
            compute_all();
        }

    }
    private ArrayListModel tbl_cash_drawer_expenses_ALM;
    private Tblcash_drawer_expensesModel tbl_cash_drawer_expenses_M;

    private void init_tbl_cash_drawer_expenses() {
        tbl_cash_drawer_expenses_ALM = new ArrayListModel();
        tbl_cash_drawer_expenses_M = new Tblcash_drawer_expensesModel(tbl_cash_drawer_expenses_ALM);
        tbl_cash_drawer_expenses.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_cash_drawer_expenses.setModel(tbl_cash_drawer_expenses_M);
        tbl_cash_drawer_expenses.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_expenses.setRowHeight(25);
        int[] tbl_widths_cash_drawer_expenses = {0, 0, 0, 0, 0, 0, 100, 0, 0, 100};
        for (int i = 0, n = tbl_widths_cash_drawer_expenses.length; i < n; i++) {
            if (i == 6) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_expenses, i, tbl_widths_cash_drawer_expenses[i]);
        }
        Dimension d = tbl_cash_drawer_expenses.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_cash_drawer_expenses.getTableHeader().
                setPreferredSize(d);
        tbl_cash_drawer_expenses.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_cash_drawer_expenses.setRowHeight(35);
        tbl_cash_drawer_expenses.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_cash_drawer_expenses(List<to_cash_drawer_expenses> acc) {
        tbl_cash_drawer_expenses_ALM.clear();
        tbl_cash_drawer_expenses_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_expensesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "session_no", "user_name", "screen_name", "time_in", "time_out", "EXPENSE", "check_no", "check_holder", "AMOUNT"
        };

        public Tblcash_drawer_expensesModel(ListModel listmodel) {
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
            to_cash_drawer_expenses tt = (to_cash_drawer_expenses) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.session_no;
                case 2:
                    return tt.user_name;
                case 3:
                    return tt.screen_name;
                case 4:
                    return tt.time_in;
                case 5:
                    return tt.time_out;
                case 6:
                    return tt.bank;
                case 7:
                    return tt.check_no;
                case 8:
                    return tt.check_holder;
                default:
                    return tt.amount;
            }
        }
    }

    private void add_expenses() {
        int id = -1;
        String session_no = Users.session_no;
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = Users.time_in;
        String time_out = DateType.datetime.format(new Date());
        String bank = tf_expense_name.getText();
        String check_no = "";
        String check_holder = "";
        double amount = FitIn.toDouble(tf_expense_amount.getText());
        to_cash_drawer_expenses to = new to_cash_drawer_expenses(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount);
        if (Users.is_active == 0) {
            tbl_cash_drawer_expenses_ALM.add(to);
            tbl_cash_drawer_expenses_M.fireTableDataChanged();
            tf_expense_name.grabFocus();
            tf_expense_name.setText("");
            tf_expense_amount.setText("");
            compute_expenses();
        } else {
            List<to_cash_drawer_expenses> data = new ArrayList();
            data.add(to);
            S1_cash_drawer_expenses.add_cash_drawer_checks(data);
            loadData_cash_drawer_expenses(S1_cash_drawer_expenses.ret_data(Users.session_no));
            tf_expense_name.grabFocus();
            tf_expense_amount.setText("");
            tf_expense_name.setText("");
            compute_expenses();
        }
    }

    private void delete_expenses() {
        int row = tbl_cash_drawer_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }

        if (Users.drawer.time_out == null) {
            tbl_cash_drawer_expenses_ALM.remove(row);
            tbl_cash_drawer_expenses_M.fireTableDataChanged();
            tf_expense_name.grabFocus();
            tf_expense_amount.setText("");
            compute_expenses();
        } else {

            to_cash_drawer_expenses to = (to_cash_drawer_expenses) tbl_cash_drawer_expenses_ALM.
                    get(tbl_cash_drawer_expenses.convertRowIndexToModel(row));
            S1_cash_drawer_expenses.delete_cash_drawer_checks(to);
            loadData_cash_drawer_expenses(S1_cash_drawer_expenses.ret_data(Users.session_no));
            tf_expense_name.grabFocus();
            tf_expense_amount.setText("");
            compute_expenses();
        }

    }

    private void compute_check() {
        List<to_cash_drawer_checks> datas = tbl_cash_drawer_checks_ALM;
        double total = 0;
        for (to_cash_drawer_checks to : datas) {
            total += to.amount;
        }
        lbl_check_total.setText(FitIn.fmt_wc_0(total));
        compute_all();
    }

    private void compute_expenses() {
        List<to_cash_drawer_expenses> datas = tbl_cash_drawer_expenses_ALM;
        double total = 0;
        for (to_cash_drawer_expenses to : datas) {
            total += to.amount;
        }
        lbl_expenses_total.setText(FitIn.fmt_wc_0(total));

    }

    private void compute_all() {
        double cash = FitIn.toDouble(lbl_cash_total.getText());
        double check = FitIn.toDouble(lbl_check_total.getText());
        double total = cash + check;
        lbl_total.setText(" " + FitIn.fmt_wc_0(total));
    }

    private void ok1() {
        int id1 = 0;
        String session_no = Users.session_no;
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = Users.time_in;
        String time_out1 = Users.time_out;
        double amount = to_cash_drawer.amount;
        double cash_out = 0;
        double thousand = FitIn.toDouble(tf_1000.getText());
        double five_hundred = FitIn.toDouble(tf_500.getText());
        double two_hundred = FitIn.toDouble(tf_200.getText());
        double fifty = FitIn.toDouble(tf_50.getText());
        double twenty = FitIn.toDouble(tf_20.getText());
        double coins = FitIn.toDouble(tf_coins.getText());
        double one_hundred = FitIn.toDouble(tf_100.getText());
        List<S1_cash_drawer_checks.to_cash_drawer_checks> checks = tbl_cash_drawer_checks_ALM;
        List<S1_cash_drawer_expenses.to_cash_drawer_expenses> expen = tbl_cash_drawer_expenses_ALM;
        double expenses = FitIn.toDouble(lbl_expenses_total.getText());
        double ten = FitIn.toDouble(tf_21.getText());
        double five = FitIn.toDouble(tf_22.getText());
        double one = FitIn.toDouble(tf_23.getText());
        double point_five = FitIn.toDouble(tf_24.getText());
        double point_two_five = FitIn.toDouble(tf_25.getText());
        double point_ten = FitIn.toDouble(tf_26.getText());
        double point_zero_five = FitIn.toDouble(tf_coins.getText());
        S1_cash_drawer.to_cash_drawer to = new to_cash_drawer(id1, session_no, user_name, screen_name, time_in, time_out1, amount, cash_out
                , thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, checks, expen, expenses, ten, five, one, point_five
                , point_two_five, point_ten, point_zero_five,"","","","","","");
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        double cash_in = FitIn.toDouble(tf_cash_in.getText());
        double cash_total = FitIn.toDouble(lbl_cash_total.getText());
        String cashier_name = Users.screen_name;
        double net_total = FitIn.toDouble(lbl_total.getText());
        String date = DateType.month_date.format(new Date());
        List<Srpt_checks.field> fields = new ArrayList();
        List<Srpt_checks.field> fields2 = new ArrayList();
        List<to_cash_drawer_checks> f = tbl_cash_drawer_checks_ALM;
        List<to_cash_drawer_expenses> ex1 = tbl_cash_drawer_expenses_ALM;
        double grand_checks = 0;
        double grand_expenses = 0;
//        for (to_cash_drawer_checks t : f) {
//            String check_bank = t.bank;
//            String check_holder = t.check_holder;
//            String check_no = t.check_no;
//            double check_amount = t.amount;
//            String date1 = DateType.convert_jan_1_2013_datetime2(DateType.datetime.
//                    format(new Date()));
//            Srpt_checks.field t1 = new Srpt_checks.field(check_bank + " - " + check_no, check_holder, check_no, check_amount, date1);
//            fields.add(t1);
//            grand_checks += check_amount;
//        }
//        for (to_cash_drawer_expenses t : ex1) {
//            String check_bank = t.bank;
//            String check_holder = t.check_holder;
//            String check_no = t.check_no;
//            double check_amount = t.amount;
//            String date1 = DateType.convert_jan_1_2013_datetime2(DateType.datetime.
//                    format(new Date()));
//            Srpt_checks.field t1 = new Srpt_checks.field(check_bank, check_holder, check_no, check_amount, date1);
//            fields2.add(t1);
//            grand_expenses += check_amount;
//        }     
//        net_total += grand_expenses;
//        double grand_sales = FitIn.toDouble(lbl_cash_total.getText());
//        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "retail_res\\rpt\\";
//        Srpt_cash_count rpt = new Srpt_cash_count(business_name, address, operated_by, cash_in, thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, coins, cash_total, cashier_name, net_total, date, fields, SUBREPORT_DIR, fields2, grand_sales, grand_checks, grand_expenses);
//        String jrxml = "rpt_cash_count.jrxml";
//
//        String print = System.getProperty("print_to_receipts", "false");
//        if (print.equals("true")) {
//            InputStream is = S1_cash_drawer.class.getResourceAsStream(jrxml);
//            try {
//                JasperReport jasperReport = JasperCompileManager.compileReport(is);
//                jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
//                        setParameter(rpt), JasperUtil.emptyDatasource());
//            } catch (JRException ex) {
//                Logger.getLogger(Srpt_receipts.class.getName()).
//                        log(Level.SEVERE, null, ex);
//            }
//            try {
//                JasperPrintManager.printReport(jasperPrint, false);
//            } catch (JRException e) {
//                JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
//                throw new RuntimeException(e);
//            }
//        }
        String id = ids;
        String time_out = DateType.datetime.format(new Date());
        S1_cash_drawer.update_cash_drawer(id, time_out, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred,ten,five,one,point_five,point_two_five,point_ten,point_zero_five);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(to));
        }
    }
    JasperPrint jasperPrint = null;

}
