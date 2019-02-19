/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.accounts_receivable.S1_accounts_receivable.to_accounts_receivable;
import POS.accounts_receivable.S1_accounts_receivable_payments.to_accounts_receivable_payments;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import org.jfree.ui.Align;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_ar_payments extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_payments
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
    private Dlg_ar_payments(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_payments(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_payments() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_ar_payments myRef;

    private void setThisRef(Dlg_ar_payments myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_payments> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_payments create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_payments create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_payments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_payments((java.awt.Frame) parent, false);
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
            Dlg_ar_payments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_payments((java.awt.Dialog) parent, false);
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

        Dlg_ar_payments dialog = Dlg_ar_payments.create(new javax.swing.JFrame(), true);
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
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_accounts_receivable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_accounts_receivable_payments = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/customer_item_pricing.png"))); // NOI18N
        jMenuItem1.setText("Payment");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/transactions.png"))); // NOI18N
        jMenuItem4.setText("Finalize");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem4);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/b_edit.png"))); // NOI18N
        jMenuItem2.setText("Update");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/b_drop.png"))); // NOI18N
        jMenuItem3.setText("Delete");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_accounts_receivable);

        jLabel1.setText("Total Transactions:");

        jLabel2.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Search by:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Reference No");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Customer ");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date:");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("All");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("From:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("To:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Type:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("All");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivable_paymentsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivable_paymentsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_accounts_receivable_payments);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("0");

        jLabel10.setText("Total No of Payments");

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Show Posted Charge Payments");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jLabel11.setText("Posted");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("0.00");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("0.00");

        jLabel14.setText("Posted");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_types(jTextField2, jTextField3);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void tbl_accounts_receivableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMousePressed
        popup(evt);
    }//GEN-LAST:event_tbl_accounts_receivableMousePressed

    private void tbl_accounts_receivableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMouseReleased
        popup(evt);
    }//GEN-LAST:event_tbl_accounts_receivableMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        payment();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tbl_accounts_receivable_paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivable_paymentsMouseClicked
        select_payment();
    }//GEN-LAST:event_tbl_accounts_receivable_paymentsMouseClicked

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        data_cols_payments();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void tbl_accounts_receivableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMouseClicked
        data_cols_payments();
    }//GEN-LAST:event_tbl_accounts_receivableMouseClicked

    private void tbl_accounts_receivable_paymentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivable_paymentsMousePressed
        popup2(evt);
    }//GEN-LAST:event_tbl_accounts_receivable_paymentsMousePressed

    private void tbl_accounts_receivable_paymentsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivable_paymentsMouseReleased
        popup2(evt);
    }//GEN-LAST:event_tbl_accounts_receivable_paymentsMouseReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        delete_accounts_receivable_payments();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        update_payment();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        finalize_payment();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_accounts_receivable;
    private javax.swing.JTable tbl_accounts_receivable_payments;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "db_algorithm");
        init_key();
        init_tbl_accounts_receivable();
        focus();
        set_default_branch();
        init_tbl_accounts_receivable_payments();
        data_cols_payments();
        jTextField1.grabFocus();
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
        JTextField[] tf = {jTextField2, jTextField1};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
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

    private ArrayListModel tbl_accounts_receivable_ALM;
    private Tblaccounts_receivableModel tbl_accounts_receivable_M;

    private void init_tbl_accounts_receivable() {
        tbl_accounts_receivable_ALM = new ArrayListModel();
        tbl_accounts_receivable_M = new Tblaccounts_receivableModel(tbl_accounts_receivable_ALM);
        tbl_accounts_receivable.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable.setModel(tbl_accounts_receivable_M);
        tbl_accounts_receivable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable.setRowHeight(25);
        int[] tbl_widths_accounts_receivable = {70, 70, 100, 100, 70, 70, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable, i, tbl_widths_accounts_receivable[i]);
        }
        Dimension d = tbl_accounts_receivable.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_accounts_receivable.getTableHeader().setPreferredSize(d);
        tbl_accounts_receivable.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable.setRowHeight(25);
        tbl_accounts_receivable.setFont(new java.awt.Font("Arial", 0, 11));
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
            "Date", "Reference", "Customer", "TYPE", "Amount", "Balance", "", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type", "or_no", "ci_no", "trust_receipt", "soa_id", "soa_type", "soa_type_id", "reference_no"
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
                    return " " + DateType.convert_slash_datetime2(tt.date_applied);
                case 1:
                    return " " + tt.ci_no + tt.trust_receipt;
                case 2:
                    return " " + tt.customer_name;
                case 3:
                    return " " + tt.soa_type;
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
                case 18:
                    return tt.ci_no;
                case 19:
                    return tt.trust_receipt;
                case 20:
                    return tt.soa_id;
                case 21:
                    return tt.soa_type;
                case 22:
                    return tt.soa_type_id;
                default:
                    return tt.reference_no;
            }
        }
    }

    private void data_cols() {
        String from = DateType.sf.format(jDateChooser1.getDate());
        String to = DateType.sf.format(jDateChooser2.getDate());
        String where = " ";
        if (!jCheckBox3.isSelected()) {
            where = " where Date(date_applied) between '" + from + "' and '" + to + "' ";

            if (jCheckBox1.isSelected()) {
                where = where + " and concat(reference_no,ci_no,trust_receipt) like '%" + jTextField1.getText() + "%' ";
            } else {
                where = where + " and customer_name like '%" + jTextField1.getText() + "%' ";
            }
            if (!jCheckBox4.isSelected()) {
                where = where + " and soa_type_id='" + jTextField3.getText() + "' ";
            }
        } else {
            if (jCheckBox1.isSelected()) {
                where = where + " where concat(reference_no,ci_no,trust_receipt) like '%" + jTextField1.getText() + "%' ";
            } else {
                where = where + " where customer_name like '%" + jTextField1.getText() + "%' ";
            }
            if (!jCheckBox4.isSelected()) {
                where = where + " and soa_type_id='" + jTextField3.getText() + "' ";
            }
        }
        where = where + " order by Date(date_paid) desc";
        loadData_accounts_receivable(S1_accounts_receivable.ret_data5(where));
        jLabel2.setText("" + tbl_accounts_receivable_ALM.size());
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
            obj[i][0] = " " + to.id;
            obj[i][1] = to.type_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 100};
        String[] col_names = {"", "Type"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_account_receivable_types.to_accounts_receivable_types to = type_list.get(data.selected_row);
                tf2.setText("" + to.id);
                tf1.setText(to.type_name);
                data_cols();
            }
        });
    }

    private void popup(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_accounts_receivable, evt.getX(), evt.getY());
        }
    }

    private void payment() {
//        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable Payments - (Add)" + "' limit 1";
//        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
//        if (privileges.isEmpty()) {
//            Alert.set(0, "Privilege not added!");
//            return;
//        }

        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));

        double balance = to.amount - to.paid;
        Window p = (Window) this;
        Dlg_ar_add_payment nd = Dlg_ar_add_payment.create(p, true);
        nd.setTitle("");
        nd.do_pass(balance);
        nd.setCallback(new Dlg_ar_add_payment.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_add_payment.OutputData data) {
                closeDialog.ok();

                int row = tbl_accounts_receivable.getSelectedRow();
                if (row < 0) {
                    return;
                }
                to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                        get(tbl_accounts_receivable.convertRowIndexToModel(row));
                String customer_id = to.customer_id;
                String customer_name = to.customer_name;
                String ar_no = to.ar_no;
                String date_added = DateType.datetime.format(new Date());
                String user_name = Users.user_name;
                double amount = data.cash;
                double discount_amount = data.discount_amount;
                double discount_rate = data.discount_rate;
                String discount = data.discount;
                int status = 0;
                double term = 0;
                String date_applied = data.date_applied;
                double paid = 0;
                String date_paid = DateType.sf.format(new Date());
                String remarks = "";
                String type = "CASH";
                String or_no = to.or_no;
                double prev_balance = 0;
                double check_amount = data.check_amount;
                String check_holder = data.check_holder;
                String check_bank = data.check_bank;
                String check_no = data.check_no;
                String ci_no = to.ci_no;
                String trust_receipt = to.trust_receipt;
                String or_payment_no = data.or_no;
                String soa_id = to.soa_id;
                String soa_type = to.soa_type;
                String soa_type_id = to.soa_type_id;
                String reference_no = to.reference_no;
                String check_date = data.check_date;
                String user_id = MyUser.getUser_id();
                String user_screen_name = MyUser.getUser_screen_name();
                String branch = my_branch;
                String branch_id = my_branch_id;
                String location = my_location;
                String location_id = my_location_id;

                String prepaid_customer_name = data.prepaid_customer_name;
                String prepaid_customer_id = data.prepaid_customer_id;
                double prepaid_amount = data.prepaid_amount;
                String credit_card_type = data.credit_card_type;
                double credit_card_rate = data.credit_card_rate;
                String credit_card_no = data.credit_card_no;
                String credit_card_holder = data.credit_card_holder;
                double credit_card_amount = data.credit_card_amount;
                String gift_certificate_from = data.gift_certificate_from;
                String gift_certificate_description = data.gift_certificate_description;
                String gift_certificate_no = data.gift_certificate_no;
                double gift_certificate_amount = data.gift_certificate_amount;
                String online_bank = data.online_bank;
                String online_reference_no = data.online_reference_no;
                String online_holder = data.online_holder;
                String online_date = data.online_date;
                double online_amount = data.online_amount;
                double actual_amount = data.actual_tendered;
                S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                        status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status,
                        term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no,
                        trust_receipt, or_payment_no, soa_id, soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, data.tax_rate,
                        data.tax_amount, branch, branch_id, location, location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type,
                        credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description,
                        gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount);
                S1_accounts_receivable_payments.add_accounts_receivable_payments2(to1);
                data_cols_payments();
                Alert.set(1, type);
            }
        });
        nd.setLocationRelativeTo(null);
        nd.setVisible(true);
    }

    private ArrayListModel tbl_accounts_receivable_payments_ALM;
    private Tblaccounts_receivable_paymentsModel tbl_accounts_receivable_payments_M;

    private void init_tbl_accounts_receivable_payments() {
        tbl_accounts_receivable_payments_ALM = new ArrayListModel();
        tbl_accounts_receivable_payments_M = new Tblaccounts_receivable_paymentsModel(tbl_accounts_receivable_payments_ALM);
        tbl_accounts_receivable_payments.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable_payments.setModel(tbl_accounts_receivable_payments_M);
        tbl_accounts_receivable_payments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable_payments.setRowHeight(25);
        int[] tbl_widths_accounts_receivable_payments = {70, 100, 70, 70, 70, 70, 70, 70, 70, 70, 60, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable_payments.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable_payments, i, tbl_widths_accounts_receivable_payments[i]);
        }
        Dimension d = tbl_accounts_receivable_payments.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_accounts_receivable_payments.getTableHeader().setPreferredSize(d);
        tbl_accounts_receivable_payments.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable_payments.setRowHeight(25);
        tbl_accounts_receivable_payments.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 7);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 8);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 9);

        TableColumn tc = tbl_accounts_receivable_payments.getColumnModel().getColumn(11);
        tc.setCellEditor(tbl_accounts_receivable_payments.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tbl_accounts_receivable_payments.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));

    }

    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = tbl_accounts_receivable_payments.getRowCount(); x < y; x++) {
                tbl_accounts_receivable_payments.setValueAt(checked, x, 0);
            }
        }
    }

    class CheckBoxHeader extends JCheckBox
            implements TableCellRenderer, MouseListener {

        protected CheckBoxHeader rendererComponent;
        protected int column;
        protected boolean mousePressed = false;

        public CheckBoxHeader(ItemListener itemListener) {
            rendererComponent = this;
            rendererComponent.addItemListener(itemListener);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    rendererComponent.setForeground(header.getForeground());
                    rendererComponent.setBackground(new java.awt.Color(204, 204, 204));
                    rendererComponent.setHorizontalAlignment(Align.CENTER);
                    rendererComponent.setOpaque(true);
                    header.addMouseListener(rendererComponent);
                }
            }
            setColumn(column);
            rendererComponent.setText("");
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return rendererComponent;
        }

        protected void setColumn(int column) {
            this.column = column;
        }

        public int getColumn() {
            return column;
        }

        protected void handleClickEvent(MouseEvent e) {
            if (mousePressed) {
                mousePressed = false;
                JTableHeader header = (JTableHeader) (e.getSource());
                JTable tableView = header.getTable();
                TableColumnModel columnModel = tableView.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int column1 = tableView.convertColumnIndexToModel(viewColumn);
                if (viewColumn == this.column && e.getClickCount() == 1 && column1 != -1) {
                    doClick();
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            handleClickEvent(e);
            ((JTableHeader) e.getSource()).repaint();
            List<to_accounts_receivable_payments> datas = tbl_accounts_receivable_payments_ALM;
            boolean selected = false;
            if (this.isSelected()) {
                selected = true;
            }
            for (to_accounts_receivable_payments to : datas) {
                if (to.status == 1) {
                    to.setSelected(selected);
                }
            }
            e.consume();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private void loadData_accounts_receivable_payments(List<to_accounts_receivable_payments> acc) {
        tbl_accounts_receivable_payments_ALM.clear();
        tbl_accounts_receivable_payments_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivable_paymentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Ref #", "Cash", "Check", "Prepaid", "Credit Card", "GC", "Online", "Discount", "Amount", "", "", "date_applied", "paid", "date_paid", "remarks", "type", "or_no", "prev_balance", "check_amount", "check_holder", "check_bank", "check_no", "ci_no", "trust_receipt", "or_payment_no", "soa_id", "soa_type", "soa_type_id", "reference_no"
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
            if (col == 11) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_accounts_receivable_payments tt = (to_accounts_receivable_payments) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime2(tt.date_applied);
                case 1:
                    return " " + tt.reference_no;
                case 2:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.check_amount) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.prepaid_amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.credit_card_amount) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.gift_certificate_amount) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.online_amount) + " ";
                case 8:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 9:
                    return FitIn.fmt_wc_0((tt.amount + tt.check_amount + tt.prepaid_amount + tt.credit_card_amount + tt.gift_certificate_amount + tt.online_amount)) + " ";
                case 10:
                    if (tt.status == 0) {
                        return " Finalized";
                    } else {
                        return " Posted";
                    }
                case 11:
                    return tt.selected;
                case 12:

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
                case 18:
                    return tt.prev_balance;
                case 19:
                    return tt.check_amount;
                case 20:
                    return tt.check_holder;
                case 21:
                    return tt.check_bank;
                case 22:
                    return tt.check_no;
                case 23:
                    return tt.ci_no;
                case 24:
                    return tt.trust_receipt;
                case 25:
                    return tt.or_payment_no;
                case 26:
                    return tt.soa_id;
                case 27:
                    return tt.soa_type;
                case 28:
                    return tt.soa_type_id;
                default:
                    return tt.reference_no;
            }
        }
    }

    private void data_cols_payments() {

        String where = "";
        if (jCheckBox5.isSelected()) {
            where = " where status=1 order by Date(date_applied) desc";
            loadData_accounts_receivable_payments(S1_accounts_receivable_payments.ret_data2(where));
        } else {
            int row = tbl_accounts_receivable.getSelectedRow();
            if (row < 0) {
                tbl_accounts_receivable_payments_ALM.clear();
                tbl_accounts_receivable_payments_M.fireTableDataChanged();
            } else {
                to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.get(tbl_accounts_receivable.convertRowIndexToModel(row));
                where = " where ar_no='" + to.ar_no + "' order by Date(date_applied) desc ";
                loadData_accounts_receivable_payments(S1_accounts_receivable_payments.ret_data2(where));
            }
        }
        double posted = 0;
        double finalized = 0;
        List<to_accounts_receivable_payments> datas = tbl_accounts_receivable_payments_ALM;
        for (to_accounts_receivable_payments t : datas) {
            if (t.status == 0) {
                finalized += t.amount + t.check_amount;
            } else {
                posted += t.amount + t.check_amount;
            }
        }
        jLabel12.setText(FitIn.fmt_wc_0(posted));
        jLabel13.setText(FitIn.fmt_wc_0(finalized));
        jLabel9.setText("" + tbl_accounts_receivable_payments_ALM.size());
    }

    private void select_payment() {

        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }

        int col = tbl_accounts_receivable_payments.getSelectedColumn();
        if (col == 11) {
            to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));
            if (to.status == 1) {
                if (to.selected == true) {
                    to.setSelected(false);
                } else {
                    to.setSelected(true);
                }
                tbl_accounts_receivable_payments_M.fireTableDataChanged();
            }
        }
    }

    private void popup2(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu2.show(tbl_accounts_receivable_payments, evt.getX(), evt.getY());
        }

//        String where = " where user_name='" + Users.user_name + "' order by previledge asc";
//        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
//        int exists = 0;
//        for (S1_user_previleges.to_user_previleges to : datas) {
//            if (to.previledge.equalsIgnoreCase("Finalize Account Receivable Payments")) {
//                exists = 1;
//                break;
//            }
//        }
//
//        if (exists == 1) {
//            jMenuItem4.setVisible(true);
//        } else {
//            jMenuItem4.setVisible(false);
//        }
    }

    private void delete_accounts_receivable_payments() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable Payments - (Delete)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        final List<to_accounts_receivable_payments> list = new ArrayList();
        List<to_accounts_receivable_payments> datas = tbl_accounts_receivable_payments_ALM;
        for (to_accounts_receivable_payments to : datas) {
            if (to.isSelected()) {
                list.add(to);
            }
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                if (!list.isEmpty()) {

                    S1_accounts_receivable_payments.delete_accounts_receivable_payments2(list);
                    Alert.set(3, null);
                    data_cols_payments();

                } else {
                    Alert.set(0, "No record selected!");
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void update_payment() {
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
        final to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));

        double balance = to.amount - to.paid;

        Window p = (Window) this;
        Dlg_ar_add_payment nd = Dlg_ar_add_payment.create(p, true);
        nd.setTitle("");
        nd.do_pass2(balance, to.date_applied, to.amount, to.or_no, to.check_bank, to.check_holder, to.check_amount, to.check_no, to.check_date, to.tax_rate, to.tax_amount);
        nd.setCallback(new Dlg_ar_add_payment.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_add_payment.OutputData data) {
                closeDialog.ok();

                String customer_id = to.customer_id;
                String customer_name = to.customer_name;
                String ar_no = to.ar_no;
                String date_added = DateType.datetime.format(new Date());
                String user_name = Users.user_name;
                double amount = data.cash;
                double discount_amount = 0;
                double discount_rate = 0;
                String discount = "";
                int status = 0;
                double term = 0;
                String date_applied = data.date_applied;
                double paid = 0;
                String date_paid = DateType.sf.format(new Date());
                String remarks = "";
                String type = "CASH";
                String or_no = to.or_no;
                double prev_balance = 0;
                double check_amount = data.check_amount;
                String check_holder = data.check_holder;
                String check_bank = data.check_bank;
                String check_no = data.check_no;
                String ci_no = to.ci_no;
                String trust_receipt = to.trust_receipt;
                String or_payment_no = data.or_no;
                String soa_id = to.soa_id;
                String soa_type = to.soa_type;
                String soa_type_id = to.soa_type_id;
                String reference_no = to.reference_no;
                String check_date = data.check_date;
                String user_id = to.user_id;
                String user_screen_name = to.user_screen_name;
                String branch = my_branch;
                String branch_id = my_branch_id;
                String location = my_location;
                String location_id = my_location_id;
                String prepaid_customer_name = data.prepaid_customer_name;
                String prepaid_customer_id = data.prepaid_customer_id;
                double prepaid_amount = data.prepaid_amount;
                String credit_card_type = data.credit_card_type;
                double credit_card_rate = data.credit_card_rate;
                String credit_card_no = data.credit_card_no;
                String credit_card_holder = data.credit_card_holder;
                double credit_card_amount = data.credit_card_amount;
                String gift_certificate_from = data.gift_certificate_from;
                String gift_certificate_description = data.gift_certificate_description;
                String gift_certificate_no = data.gift_certificate_no;
                double gift_certificate_amount = data.gift_certificate_amount;
                String online_bank = data.online_bank;
                String online_reference_no = data.online_reference_no;
                String online_holder = data.online_holder;
                String online_date = data.online_date;
                double online_amount = data.online_amount;
                double actual_amount = data.actual_tendered;
                S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                        to.id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied,
                         paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no,
                         soa_id, soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, data.tax_rate, data.tax_amount, branch, branch_id,
                         location, location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no,
                         credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount,
                         online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount);
                S1_accounts_receivable_payments.update_accounts_receivable_payments3(to1);
                data_cols_payments();
                Alert.set(2, type);
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);
    }

    private void finalize_payment() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Receivable Payments - (Finalize)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }

        List<to_accounts_receivable_payments> datas = tbl_accounts_receivable_payments_ALM;
        final List<to_accounts_receivable_payments> datas2 = new ArrayList();
        for (to_accounts_receivable_payments t : datas) {
            if (t.selected == true && t.status == 1) {
                datas2.add(t);
            }
        }
        
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Finalize Payment");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_accounts_receivable_payments.finalize_accounts_receivable_payments(datas2);

                data_cols();
                int row = tbl_accounts_receivable.getSelectedRow();
                if (row > -1) {
                    tbl_accounts_receivable.setRowSelectionInterval(row, row);
                }
                data_cols_payments();
                Alert.set(0, "Payment Finalized!");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//               
//            }
//        });
//        t.start();
    }
}
