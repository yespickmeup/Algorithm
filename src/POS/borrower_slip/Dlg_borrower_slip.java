/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.borrower_slip;

import POS.borrower_slip.S1_borrower_slip_items.to_borrower_slip_items;
import POS.borrower_slip.S1_borrower_slips.to_borrower_slips;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.Branches;
import POS.inventory.Inventory_barcodes;
import POS.inventory.S2_inventory_barcodes;
import POS.users.MyUser;
import POS.users.S1_users;
import POS.users.S1_users.to_users;
import POS.users.S2_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_borrower_slip extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_borrower_slip
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
    private Dlg_borrower_slip(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_borrower_slip(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_borrower_slip() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_borrower_slip myRef;

    private void setThisRef(Dlg_borrower_slip myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_borrower_slip> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_borrower_slip create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_borrower_slip create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_borrower_slip dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_borrower_slip((java.awt.Frame) parent, false);
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
            Dlg_borrower_slip dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_borrower_slip((java.awt.Dialog) parent, false);
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

        Dlg_borrower_slip dialog = Dlg_borrower_slip.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_bs_no = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_reference_no = new Field.Input();
        jLabel7 = new javax.swing.JLabel();
        tf_borrower = new Field.Input_w_department();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new Field.Combo();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new Field.Combo();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new Field.Combo();
        jTextField8 = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        tf_search = new Field.Search();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_borrower_slips = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Total Borrowed:");

        jLabel2.setText("0");

        jLabel3.setText("Total Items Left:");

        jLabel4.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Trans #:");

        tf_bs_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Reference No:");

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Borrower:");

        tf_borrower.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_borrower.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_borrowerMouseClicked(evt);
            }
        });
        tf_borrower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_borrowerActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("From Branch:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("       Location:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setFocusable(false);
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("To   Branch:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("     Location:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setFocusable(false);
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Remarks:");

        tf_remarks.setColumns(20);
        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.setLineWrap(true);
        tf_remarks.setRows(5);
        jScrollPane2.setViewportView(tf_remarks);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Search:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_searchMouseClicked(evt);
            }
        });
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jButton6.setText("New");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Post");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Update Post");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Returned:");

        jLabel15.setText("0");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel16.setText("Status:");

        jButton2.setText("Finalize");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_bs_no, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_borrower, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jScrollPane2)))
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_bs_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_reference_no)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField5)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_borrower)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField6)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField7)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField8)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Borrower Slip", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_borrower_slips.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_borrower_slips);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        add_borrower_slips();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_branch_locations2(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        init_branch_locations2(jTextField7, jTextField8);
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        init_branch_locations2(jTextField7, jTextField8);
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_branch_locations2(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
//        init_branch_locations(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
//        init_branch_locations(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
//        init_branch_locations(jTextField7, jTextField8);
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
//        init_branch_locations(jTextField7, jTextField8);
    }//GEN-LAST:event_jTextField8MouseClicked

    private void tf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseClicked

    }//GEN-LAST:event_tf_searchMouseClicked

    private void tf_borrowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_borrowerActionPerformed
        init_users();
    }//GEN-LAST:event_tf_borrowerActionPerformed

    private void tf_borrowerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_borrowerMouseClicked
        init_users();
    }//GEN-LAST:event_tf_borrowerMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tbl_borrower_slips;
    private javax.swing.JTextField tf_borrower;
    private javax.swing.JTextField tf_bs_no;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTextArea tf_remarks;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db","db_algorithm");
        init_key();
        set_default_branch();
        init_bs_no();
        init_tbl_borrower_slip_items(jTable1);
        init_tbl_borrower_slips(tbl_borrower_slips);
        ret_data_slips();

    }

    private void init_bs_no() {
        tf_bs_no.setText(S1_borrower_slips.increment_id());
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

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        Field.Combo from_branch = (Field.Combo) jTextField5;
        Field.Combo from_location = (Field.Combo) jTextField6;
        Field.Combo to_branch = (Field.Combo) jTextField7;
        from_branch.setText(to.branch);
        from_branch.setId("" + to.branch_id);
        to_branch.setText(to.branch);
        to_branch.setId("" + to.branch_id);
        from_location.setText(to.location);
        from_location.setId("" + to.id);

        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);
    }

    List<Branches.to_branches> branches_list = new ArrayList();

    private void init_branches(final JTextField tfs) {
        final Field.Input tf = (Field.Input) tfs;
        String search = tf.getText();
        branches_list.clear();
        branches_list = Branches.ret_data3(search);
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
                setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Branches.to_branches to = branches_list.
                        get(data.selected_row);
                tf.setText(to.branch);
                tf.setId("" + to.id);
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations(final JTextField branch, final JTextField location) {
        final Field.Input branchs = (Field.Input) branch;
        final Field.Input locations = (Field.Input) location;
        String branch_id = branchs.getId();
        branch_location_list.clear();
        String where = " where branch_id='" + branch_id + "' and location like '%" + locations.getText() + "%' ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.location;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(locations, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                locations.setText("" + to.location);
                locations.setId("" + to.id);
            }
        });

    }

    //<editor-fold defaultstate="collapsed" desc=" borrower_slip_items "> 
    public static ArrayListModel tbl_borrower_slip_items_ALM;
    public static Tblborrower_slip_itemsModel tbl_borrower_slip_items_M;

    public static void init_tbl_borrower_slip_items(JTable tbl_borrower_slip_items) {
        tbl_borrower_slip_items_ALM = new ArrayListModel();
        tbl_borrower_slip_items_M = new Tblborrower_slip_itemsModel(tbl_borrower_slip_items_ALM);
        tbl_borrower_slip_items.setModel(tbl_borrower_slip_items_M);
        tbl_borrower_slip_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_borrower_slip_items.setRowHeight(25);
        int[] tbl_widths_borrower_slip_items = {100, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_borrower_slip_items.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_borrower_slip_items, i, tbl_widths_borrower_slip_items[i]);
        }
        Dimension d = tbl_borrower_slip_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_borrower_slip_items.getTableHeader().setPreferredSize(d);
        tbl_borrower_slip_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_borrower_slip_items.setRowHeight(25);
        tbl_borrower_slip_items.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_borrower_slip_items(List<to_borrower_slip_items> acc) {
        tbl_borrower_slip_items_ALM.clear();
        tbl_borrower_slip_items_ALM.addAll(acc);
    }

    public static class Tblborrower_slip_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Item Code", "Description", "Unit", "Borrowed", "Returned", "reference_no", "borrowed_by", "borrowed_by_id", "borrowed_by_department", "borrowed_by_department_id", "status", "from_branch", "from_branch_id", "from_location", "from_location_id", "to_branch", "to_branch_id", "to_location", "to_location_id", "remarks", "barcode", "description", "generic_name", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "item_type", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "main_barcode", "brand", "brand_id", "model", "model_id", "selling_type", "serial_no"
        };

        public Tblborrower_slip_itemsModel(ListModel listmodel) {
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
            to_borrower_slip_items tt = (to_borrower_slip_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.main_barcode;
                case 1:
                    return " " + tt.description;
                case 2:
                    return " " + tt.unit;
                case 3:
                    return " " + FitIn.fmt_woc(tt.qty_borrowed);
                case 4:
                    return " " + FitIn.fmt_woc(tt.qty_returned);
                case 5:
                    return tt.reference_no;
                case 6:
                    return tt.borrowed_by;
                case 7:
                    return tt.borrowed_by_id;
                case 8:
                    return tt.borrowed_by_department;
                case 9:
                    return tt.borrowed_by_department_id;
                case 10:
                    return tt.status;
                case 11:
                    return tt.from_branch;
                case 12:
                    return tt.from_branch_id;
                case 13:
                    return tt.from_location;
                case 14:
                    return tt.from_location_id;
                case 15:
                    return tt.to_branch;
                case 16:
                    return tt.to_branch_id;
                case 17:
                    return tt.to_location;
                case 18:
                    return tt.to_location_id;
                case 19:
                    return tt.remarks;
                case 20:
                    return tt.barcode;
                case 21:
                    return tt.description;
                case 22:
                    return tt.generic_name;
                case 23:
                    return tt.category;
                case 24:
                    return tt.category_id;
                case 25:
                    return tt.classification;
                case 26:
                    return tt.classification_id;
                case 27:
                    return tt.sub_classification;
                case 28:
                    return tt.sub_classification_id;
                case 29:
                    return tt.product_qty;
                case 30:
                    return tt.unit;
                case 31:
                    return tt.conversion;
                case 32:
                    return tt.selling_price;
                case 33:
                    return tt.item_type;
                case 34:
                    return tt.supplier;
                case 35:
                    return tt.fixed_price;
                case 36:
                    return tt.cost;
                case 37:
                    return tt.supplier_id;
                case 38:
                    return tt.multi_level_pricing;
                case 39:
                    return tt.vatable;
                case 40:
                    return tt.reorder_level;
                case 41:
                    return tt.markup;
                case 42:
                    return tt.main_barcode;
                case 43:
                    return tt.brand;
                case 44:
                    return tt.brand_id;
                case 45:
                    return tt.model;
                case 46:
                    return tt.model_id;
                case 47:
                    return tt.selling_type;
                default:
                    return tt.serial_no;
            }
        }
    }
//</editor-fold> 

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        final Field.Input location = (Field.Input) jTextField6;

        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " "
                        + "where main_barcode like '%" + search + "%' "
                        + "and location_id='" + location.getId() + "' "
                        + " or barcode='" + search + "' and location_id='" + location.getId() + "'"
                        + " or description like  '%" + search + "%' and location_id='" + location.getId() + "'"
                        + " ";
                inventory_barcoders_list.clear();
                inventory_barcoders_list = S2_inventory_barcodes.ret_data(where);
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
                if (inventory_barcoders_list.size() > 0) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        obj[i][3] = " " + to.unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.cost);
                        obj[i][5] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 70, w - 70, 50, 0, 70};
                    String[] col_names = {"Qty", "Item Code", "Description", "Unit", "Cost", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes t = inventory_barcoders_list.get(data.selected_row);
                            add_item(t);
                        }
                    });
                }

            }
        });
        t.start();
    }

    private void add_item(final Inventory_barcodes.to_inventory_barcodes to) {
        Window p = (Window) this;
        Dlg_qty nd = Dlg_qty.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty.OutputData data) {
                closeDialog.ok();
                tbl_borrower_slip_items_ALM.add(S1_borrower_slip_items.convert_inv_to_slip_items(to, data.qty));
                tbl_borrower_slip_items_M.fireTableDataChanged();
                compute_total();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void compute_total() {
        List<to_borrower_slip_items> datas = tbl_borrower_slip_items_ALM;
        double total_borrowed = 0;
        double total_items_left = 0;
        double total_items_returned = 0;
        for (to_borrower_slip_items to : datas) {
            total_borrowed += to.qty_borrowed;
            total_items_returned += to.qty_returned;
            total_items_left += (total_borrowed - total_items_returned);
        }
        jLabel2.setText(FitIn.fmt_woc(total_borrowed));
        jLabel4.setText(FitIn.fmt_woc(total_items_left));
        jLabel15.setText(FitIn.fmt_woc(total_items_returned));
    }

    private void add_borrower_slips() {
        final Field.Input_w_department borrower = (Field.Input_w_department) tf_borrower;
        Field.Input i_from_branch = (Field.Input) jTextField5;
        Field.Input i_from_location = (Field.Input) jTextField6;

        Field.Input i_to_branch = (Field.Input) jTextField7;
        Field.Input i_to_location = (Field.Input) jTextField8;

        int id = 0;
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        String date_added = DateType.now();
        final String bs_no = S1_borrower_slips.increment_id();
        String reference_no = tf_reference_no.getText();
        double items_borrowed = FitIn.toDouble(jLabel2.getText());
        double items_returned = 0;
        String borrowed_by = tf_borrower.getText();
        String borrowed_by_id = borrower.getId();
        String borrowed_by_department = borrower.getDepartment();
        String borrowed_by_department_id = borrower.getDepartment_id();
        int status = 0;
        String from_branch = i_from_branch.getText();
        String from_branch_id = i_from_branch.getId();
        String from_location = i_from_location.getText();
        String from_location_id = i_from_location.getId();
        String to_branch = i_to_branch.getText();
        String to_branch_id = i_to_branch.getId();
        String to_location = i_to_location.getText();
        String to_location_id = i_to_location.getId();
        String remarks = tf_remarks.getText();
        final to_borrower_slips to = new to_borrower_slips(id, user_id, user_screen_name, date_added, bs_no, reference_no, items_borrowed, items_returned, borrowed_by, borrowed_by_id, borrowed_by_department, borrowed_by_department_id, status, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, remarks);
        S1_borrower_slips.add_data(to);
        final List<to_borrower_slip_items> datas = tbl_borrower_slip_items_ALM;

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to post this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_borrower_slip_items.add_data(datas, to);

                tf_bs_no.setText("");
                tf_reference_no.setText("");
                tf_borrower.setText("");
                tf_remarks.setText("");
                borrower.setId("");
                borrower.setDepartment("");
                borrower.setDepartment_id("");

                tbl_borrower_slip_items_ALM.clear();
                tbl_borrower_slip_items_M.fireTableDataChanged();
                Alert.set(1, bs_no);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    //<editor-fold defaultstate="collapsed" desc=" borrower_slips "> 
    public static ArrayListModel tbl_borrower_slips_ALM;
    public static Tblborrower_slipsModel tbl_borrower_slips_M;

    public static void init_tbl_borrower_slips(JTable tbl_borrower_slips) {
        tbl_borrower_slips_ALM = new ArrayListModel();
        tbl_borrower_slips_M = new Tblborrower_slipsModel(tbl_borrower_slips_ALM);
        tbl_borrower_slips.setModel(tbl_borrower_slips_M);
        tbl_borrower_slips.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_borrower_slips.setRowHeight(25);
        int[] tbl_widths_borrower_slips = {100, 150, 100, 100, 80, 80, 50, 50, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_borrower_slips.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_borrower_slips, i, tbl_widths_borrower_slips[i]);
        }
        Dimension d = tbl_borrower_slips.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_borrower_slips.getTableHeader().setPreferredSize(d);
        tbl_borrower_slips.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_borrower_slips.setRowHeight(25);
        tbl_borrower_slips.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_borrower_slips(List<to_borrower_slips> acc) {
        tbl_borrower_slips_ALM.clear();
        tbl_borrower_slips_ALM.addAll(acc);
    }

    public static class Tblborrower_slipsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Slip No", "Borrowed by", "From", "To", "Borrowed", "Returned", "", "", "", "", "borrowed_by_department", "borrowed_by_department_id", "status", "from_branch", "from_branch_id", "from_location", "from_location_id", "to_branch", "to_branch_id", "to_location", "to_location_id", "remarks"
        };

        public Tblborrower_slipsModel(ListModel listmodel) {
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
            to_borrower_slips tt = (to_borrower_slips) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.reference_no;
                case 1:
                    return " " + tt.borrowed_by;
                case 2:
                    return " " + tt.from_branch + " [" + tt.from_location + "]";
                case 3:
                    return " " + tt.to_branch + " [" + tt.to_location + "]";
                case 4:
                    return " " + FitIn.fmt_woc(tt.items_borrowed);
                case 5:
                    return " " + FitIn.fmt_woc(tt.items_returned);
                case 6:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 7:
                    return " Update";
                case 8:
                    return " Delete";
                case 9:
                    return " Print";
                case 10:
                    return tt.borrowed_by_department;
                case 11:
                    return tt.borrowed_by_department_id;
                case 12:
                    return tt.status;
                case 13:
                    return tt.from_branch;
                case 14:
                    return tt.from_branch_id;
                case 15:
                    return tt.from_location;
                case 16:
                    return tt.from_location_id;
                case 17:
                    return tt.to_branch;
                case 18:
                    return tt.to_branch_id;
                case 19:
                    return tt.to_location;
                case 20:
                    return tt.to_location_id;
                default:
                    return tt.remarks;
            }
        }
    }

    private void ret_data_slips() {
        String where = "";
        List<to_borrower_slips> datas = S1_borrower_slips.ret_data(where);
        loadData_borrower_slips(datas);
    }
//</editor-fold> 

    List<S1_users.to_users> user_list = new ArrayList();

    private void init_users() {
        String search = tf_borrower.getText();
        user_list.clear();
        String where = " where screen_name like '%" + search + "%' order by screen_name asc";
        user_list = S2_users.ret_where(where);
        Object[][] obj = new Object[user_list.size()][1];
        int i = 0;
        for (to_users to : user_list) {

            obj[i][0] = " " + to.screen_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_borrower.getWidth()};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_borrower, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                to_users to = user_list.get(data.selected_row);
                tf_borrower.setText(to.screen_name);

            }
        });
    }

    private void select_slip() {
        int row = tbl_borrower_slips.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_borrower_slips.getSelectedColumn();
        to_borrower_slips to = (to_borrower_slips) tbl_borrower_slips_ALM.get(row);

        Field.Input_w_department borrower = (Field.Input_w_department) tf_borrower;
        Field.Input i_from_branch = (Field.Input) jTextField5;
        Field.Input i_from_location = (Field.Input) jTextField6;

        Field.Input i_to_branch = (Field.Input) jTextField7;
        Field.Input i_to_location = (Field.Input) jTextField8;

        if (col == 7) {
            //update
            tf_bs_no.setText(to.bs_no);
            tf_reference_no.setText(to.reference_no);
            tf_borrower.setText(to.borrowed_by);

        } else if (col == 8) {
            //delete
        } else if (col == 9) {
            //print
        } else {
            //select
        }
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations2(JTextField b, JTextField l) {

        final Field.Combo br = (Field.Combo) b;
        final Field.Combo lo = (Field.Combo) l;
        Object[][] obj = new Object[branch_location_list2.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list2) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {90, 120};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list2.get(data.selected_row);

                br.setText("" + to.branch);
                br.setId("" + to.branch_id);

                lo.setText("" + to.location);
                lo.setId("" + to.id);
            }
        });
    }

}
