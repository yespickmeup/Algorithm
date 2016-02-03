/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.S1_branches;
import POS.inventory.Inventory_barcodes;
import POS.inventory_reports.Dlg_report_item_ledger;
import POS.receipts.Stock_transfers_items;
import POS.receipts.Stock_transfers_items.to_stock_transfers_items;
import POS.stock_transfer.Stock_transfers.to_stock_transfers;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_new_stock_transfer extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_stock_transfer
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
    private Dlg_new_stock_transfer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_stock_transfer(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_stock_transfer() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_stock_transfer myRef;

    private void setThisRef(Dlg_new_stock_transfer myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_stock_transfer> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_stock_transfer create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_stock_transfer create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_stock_transfer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer((java.awt.Frame) parent, false);
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
            Dlg_new_stock_transfer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer((java.awt.Dialog) parent, false);
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

        Dlg_new_stock_transfer dialog = Dlg_new_stock_transfer.create(new javax.swing.JFrame(), true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_from_branch = new javax.swing.JTextField();
        tf_from_branch_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_from_location = new javax.swing.JTextField();
        tf_from_location_id = new javax.swing.JTextField();
        tf_to_location = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_to_location_id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_to_branch_id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_to_branch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stock_transfers_items = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new Button.Info();
        jButton5 = new Button.Primary();
        jButton6 = new Button.Default();
        jButton7 = new Button.Success();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_stock_transfers = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new Button.Default();
        jButton4 = new Button.Default();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        tf_from_branch1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_from_branch_id1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/transactions.png"))); // NOI18N
        jMenuItem1.setText("Finalize Stock Transfer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/sales_orders.png"))); // NOI18N
        jMenuItem2.setText("Create Patch File");
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Trans #:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("From:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Branch:");

        tf_from_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branchMouseClicked(evt);
            }
        });
        tf_from_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branchActionPerformed(evt);
            }
        });

        tf_from_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch_id.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Location:");

        tf_from_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location.setFocusable(false);
        tf_from_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_locationActionPerformed(evt);
            }
        });

        tf_from_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location_id.setFocusable(false);

        tf_to_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location.setFocusable(false);
        tf_to_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_locationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Branch:");

        tf_to_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location_id.setFocusable(false);
        tf_to_location_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_location_idActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("To:");

        tf_to_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_branch_id.setFocusable(false);
        tf_to_branch_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_branch_idActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Location:");

        tf_to_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_to_branchMouseClicked(evt);
            }
        });
        tf_to_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_branchActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Remarks:");

        tf_remarks.setColumns(20);
        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.setLineWrap(true);
        tf_remarks.setRows(5);
        jScrollPane2.setViewportView(tf_remarks);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_transfers_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfers_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfers_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_stock_transfers_items);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Search:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Transactions:");

        jLabel15.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 804, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        jButton1.setText("Update Post");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Post");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("New Post");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Finalize");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_from_location, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(tf_from_branch))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_to_location, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(tf_to_branch))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_to_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_to_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_to_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_to_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_to_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_to_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock Transfer", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_transfers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_stock_transfers);

        jLabel12.setText("# of Trans:");

        jLabel13.setText("0");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel17.setText("Status:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Search:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Date From:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("To:");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/patch/download168 (1).png"))); // NOI18N
        jButton3.setToolTipText("Create Patch File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/patch/open131.png"))); // NOI18N
        jButton4.setToolTipText("Open Patch File");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Posted");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Finalized");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Status:");

        tf_from_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch1.setFocusable(false);
        tf_from_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branch1MouseClicked(evt);
            }
        });
        tf_from_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branch1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Branch:");

        tf_from_branch_id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch_id1.setFocusable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tf_from_branch1)
                        .addGap(0, 0, 0)
                        .addComponent(tf_from_branch_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(tf_from_branch_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_from_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox3)
                                .addComponent(jCheckBox4))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reports", jPanel5);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("State:");

        jProgressBar2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel8);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Item Ledger", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
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

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_to_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_branchActionPerformed
        init_branch_locations3();
    }//GEN-LAST:event_tf_to_branchActionPerformed

    private void tf_from_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_locationActionPerformed
        init_branch_locations(tf_from_location, tf_from_location_id, tf_from_branch_id);
    }//GEN-LAST:event_tf_from_locationActionPerformed

    private void tf_to_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_locationActionPerformed
        init_branch_locations(tf_to_location, tf_to_location_id, tf_to_branch_id);
    }//GEN-LAST:event_tf_to_locationActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        add_stock_transfer();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_stock_transfersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseClicked
        select_stock_transfer();
    }//GEN-LAST:event_tbl_stock_transfersMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        init_no();
        tf_remarks.setText("");
        jButton5.setEnabled(true);
        jButton1.setEnabled(false);
        jButton7.setEnabled(false);
        tf_to_branch.setText("");
        tf_to_branch_id.setText("");
        tf_to_location.setText("");
        tf_to_location_id.setText("");
        tbl_stock_transfers_items_ALM.clear();
        tbl_stock_transfers_items_M.fireTableDataChanged();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_stock_transfers_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfers_itemsMouseClicked
        update_queue_items();
    }//GEN-LAST:event_tbl_stock_transfers_itemsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        update_stock_transfer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_stock_transfersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMousePressed
        show_popup(evt);
    }//GEN-LAST:event_tbl_stock_transfersMousePressed

    private void tbl_stock_transfersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseReleased
        show_popup(evt);
    }//GEN-LAST:event_tbl_stock_transfersMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        finalize_transfer();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tf_to_branch_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_branch_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_to_branch_idActionPerformed

    private void tf_to_location_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_location_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_to_location_idActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_receipts();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_to_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_branchMouseClicked
        init_branch_locations3();
    }//GEN-LAST:event_tf_to_branchMouseClicked

    private void tf_from_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branch1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_branch1MouseClicked

    private void tf_from_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_from_branch1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        finalize_transfer();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbl_stock_transfers;
    private javax.swing.JTable tbl_stock_transfers_items;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch1;
    private javax.swing.JTextField tf_from_branch_id;
    private javax.swing.JTextField tf_from_branch_id1;
    private javax.swing.JTextField tf_from_location;
    private javax.swing.JTextField tf_from_location_id;
    private javax.swing.JTextArea tf_remarks;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_to_branch;
    private javax.swing.JTextField tf_to_branch_id;
    private javax.swing.JTextField tf_to_location;
    private javax.swing.JTextField tf_to_location_id;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();
        init_tbl_stock_transfers();
        init_no();
        jTextField2.grabFocus();
        set_default_branch();

        init_tbl_stock_transfers_items();
        tf_to_location.grabFocus();
        item_ledger();

        tf_from_branch_id.setVisible(false);
        tf_from_location_id.setVisible(false);
        tf_to_branch_id.setVisible(false);
        tf_to_location_id.setVisible(false);
        tf_from_branch_id1.setVisible(false);

        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);
        branch_location_list3 = branch_location_list2;

    }

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void item_ledger() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                jPanel11.setLayout(new BorderLayout());
                Dlg_report_item_ledger dlg = new Dlg_report_item_ledger();
                jPanel11.add(dlg.getSurface());
            }
        });

    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        tf_from_branch.setText(to.branch);
        tf_from_branch_id.setText(to.branch_id);
        tf_from_location.setText(to.location);
        tf_from_location_id.setText("" + to.id);

        tf_from_branch1.setText(to.branch);
        tf_from_branch_id1.setText(to.branch_id);

        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;

    }

    List<Stock_transfers.to_stock_transfers> receipt_list = new ArrayList();

    private void init_receipts() {
        String search = jTextField2.getText();
        receipt_list.clear();
        String where = " where transaction_no like '%" + search + "%' order by id asc ";
        receipt_list = Stock_transfers.ret_data(where);
        Object[][] obj = new Object[receipt_list.size()][1];
        int i = 0;
        for (Stock_transfers.to_stock_transfers to : receipt_list) {
            obj[i][0] = " " + to.transaction_no;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {jTextField2.getWidth()};
        int width = 0;
        String[] col_names = {"Transaction #"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField2, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Stock_transfers.to_stock_transfers to = receipt_list.
                        get(data.selected_row);
                Stock_transfers.to_stock_transfers t = receipt_list.get(data.selected_row);
                jTextField2.setText(t.transaction_no);
                jTextField2.setEnabled(false);
                select_transaction();
            }
        });

    }

    private void select_transaction() {
        String where2 = " where transaction_no='" + jTextField2.getText() + "' ";
        to_stock_transfers to = Stock_transfers.to(where2);
        String where = " where stock_transfer_id='" + to.transaction_no + "' order by description asc ";
        loadData_stock_transfers_items(Stock_transfers_items.ret_data(where));

        jLabel15.setText("" + tbl_stock_transfers_items_ALM.size());

        jTextField2.setText(to.transaction_no);
        tf_from_branch.setText(to.from_branch);
        tf_from_branch_id.setText(to.from_branch_id);
        tf_from_location.setText(to.from_location);
        tf_from_location_id.setText(to.from_location_id);

        tf_to_branch.setText(to.to_branch);
        tf_to_branch_id.setText(to.to_branch_id);
        tf_to_location.setText(to.to_location);
        tf_to_location_id.setText(to.to_location_id);
        tf_remarks.setText(to.remarks);

        jTextField2.setEnabled(true);
        jButton5.setEnabled(false);
        jButton1.setEnabled(true);
    }

    private void init_no() {
        jTextField2.setText(Stock_transfers.increment_id(my_branch_id));
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations(final JTextField tf1, final JTextField tf2, final JTextField tf3) {
        String branch_id = tf3.getText();
        branch_location_list.clear();
        String where = " where branch_id='" + tf3.getText() + "' and location like '%" + tf1.getText() + "%' ";
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
        TableRenderer.
                setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf1.setText("" + to.location);
                tf2.setText("" + to.id);
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();

    private void init_branch_locations2() {

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
        TableRenderer.setPopup(tf_from_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list2.get(data.selected_row);
                tf_from_branch.setText("" + to.branch);
                tf_from_branch_id.setText("" + to.branch_id);

                tf_from_location.setText("" + to.location);
                tf_from_location_id.setText("" + to.id);
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list3 = new ArrayList();

    private void init_branch_locations3() {

        Object[][] obj = new Object[branch_location_list3.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list3) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {90, 120};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_to_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list3.get(data.selected_row);
                tf_to_branch.setText("" + to.branch);
                tf_to_branch_id.setText("" + to.branch_id);

                tf_to_location.setText("" + to.location);
                tf_to_location_id.setText("" + to.id);
            }
        });
    }

    List<S1_branches.to_branches> branches_list = new ArrayList();

    private void init_branches(final JTextField tf1, final JTextField tf2) {
        String search = tf1.getText();
        branches_list.clear();
        branches_list = S1_branches.ret_data3(search);
        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (S1_branches.to_branches to : branches_list) {
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
                setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branches.to_branches to = branches_list.
                        get(data.selected_row);
                tf1.setText(to.branch);
                tf2.setText("" + to.id);

            }
        });
    }

    private void focus() {
        JTextField[] tf = {jTextField2, tf_from_branch, tf_from_location, tf_to_branch, tf_to_location, tf_search, jTextField1};
        JTextArea[] area = {tf_remarks};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        Focus_Fire.onFocus_lostFocus(area);
        Focus_Fire.select_all(area);
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
                              KeyEvent.VK_CONTROL, new KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton5.doClick();
            }
        });
        tf_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    add_stock_transfer();
                }
            }
        });
    }
    // </editor-fold>

    private ArrayListModel tbl_stock_transfers_ALM;
    private Tblstock_transfersModel tbl_stock_transfers_M;

    private void init_tbl_stock_transfers() {
        tbl_stock_transfers_ALM = new ArrayListModel();
        tbl_stock_transfers_M = new Tblstock_transfersModel(tbl_stock_transfers_ALM);
        tbl_stock_transfers.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_stock_transfers.setModel(tbl_stock_transfers_M);
        tbl_stock_transfers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers.setRowHeight(25);
        int[] tbl_widths_stock_transfers = {70, 100, 150, 150, 80, 50, 50, 50, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers, i, tbl_widths_stock_transfers[i]);
        }
        Dimension d = tbl_stock_transfers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfers.setRowHeight(25);
        tbl_stock_transfers.setFont(new java.awt.Font("Arial", 0, 12));
    }

    private void loadData_stock_transfers(List<to_stock_transfers> acc) {
        tbl_stock_transfers_ALM.clear();
        tbl_stock_transfers_ALM.addAll(acc);
    }

    public static class Tblstock_transfersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "From", "To", "Status", "", "", "", "", "", "", "from_location", "from_location_id"
        };

        public Tblstock_transfersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 10) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_stock_transfers tt = (to_stock_transfers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.from_branch + " : " + tt.from_location;
                case 3:
                    return " " + tt.to_branch + " : " + tt.to_location;
                case 4:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 5:
                    return " Update";
                case 6:
                    return " Delete";
                case 7:
                    return " Print";
                case 8:
                    return " Delete";
                case 9:
                    return " Print";
                case 10:
                    return tt.selected;
                case 11:
                    return tt.from_location;
                default:
                    return tt.from_location_id;
            }
        }
    }

    private void data_cols() {
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());

        String where = " where Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                + " and"
                + " transaction_no like '%" + jTextField1.getText() + "%'   ";
        String where2 = " or Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                + " and"
                + " transaction_no like '%" + jTextField1.getText() + "%'   ";
        if (!jCheckBox1.isSelected()) {
            where = " where transaction_no like '%" + jTextField1.getText() + "%'  ";
            where2 = " or transaction_no like '%" + jTextField1.getText() + "%'  ";
        }
        if (jCheckBox3.isSelected()) {
            where = where + " and status=0 ";
            where2 = where2 + " and status=0 ";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " and status=1 ";
            where2 = where2 + " and status=1 ";
        }

        where = where + " and at_branch_id='" + tf_from_branch_id1.getText() + "' ";
        where2 = where2 + " and to_branch_id='" + tf_from_branch_id1.getText() + "' ";
        where = where + where2;
        where = where + " order by id desc ";
        System.out.println(where);
        loadData_stock_transfers(Stock_transfers.ret_data(where));
        jLabel13.setText("" + tbl_stock_transfers_ALM.size());
    }

    private void add_stock_transfer() {
        if (tf_to_location_id.getText().isEmpty()) {
            Alert.set(0, "Please select location to transfer!");
            return;
        }
        int id = 0;
        String transaction_no = Stock_transfers.increment_id(my_branch_id);
        String user_name = Users.user_name;
        String date_added = DateType.now();
        String remarks = tf_remarks.getText();
        String to_branch = tf_to_branch.getText();
        String to_branch_id = tf_to_branch_id.getText();
        String to_location = tf_to_location.getText();
        String to_location_id = tf_to_location_id.getText();

        String from_branch = tf_from_branch.getText();
        String from_branch_id = tf_from_branch_id.getText();
        String from_location = tf_from_location.getText();
        String from_location_id = tf_from_location_id.getText();

        String at_branch = my_branch;
        String at_branch_id = my_branch_id;
        String at_location = my_location;
        String at_location_id = my_location_id;
        Stock_transfers.to_stock_transfers rpt = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, 0, false, at_branch, at_branch_id, at_location, at_location_id);

        List<Stock_transfers_items.to_stock_transfers_items> datas = tbl_stock_transfers_items_ALM;
        Stock_transfers.add_stock_transfers(rpt, datas);

        init_no();
        data_cols();
        tf_to_location.setText("");
        tf_to_location_id.setText("");
        tf_to_branch.setText("");
        tf_to_branch_id.setText("");
        tf_remarks.setText("");
        tbl_stock_transfers_items_ALM.clear();
        tbl_stock_transfers_items_M.fireTableDataChanged();
        Alert.set(1, remarks);
    }

    private void update_stock_transfer() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Transaction Already Finalized!");
            return;
        }
        int id = to.id;
        String transaction_no = to.transaction_no;
        String user_name = Users.user_name;
        String date_added = DateType.now();
        String remarks = tf_remarks.getText();
        String to_branch = tf_to_branch.getText();
        String to_branch_id = tf_to_branch_id.getText();
        String to_location = tf_to_location.getText();
        String to_location_id = tf_to_location_id.getText();
        String from_branch = tf_from_branch.getText();
        String from_branch_id = tf_from_branch_id.getText();
        String from_location = tf_from_location.getText();
        String from_location_id = tf_from_location_id.getText();
        String at_branch = to.at_branch;
        String at_branch_id = to.at_branch_id;
        String at_location = to.at_location;
        String at_location_id = to.at_location_id;
        Stock_transfers.to_stock_transfers rpt = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, 0, false, at_branch, at_branch_id, at_location, at_location_id);
        Stock_transfers.edit_stock_transfers(rpt);
        data_cols();
        tbl_stock_transfers.setRowSelectionInterval(row, row);
        Alert.set(2, remarks);
    }

    private void delete_stock_transfer() {
        final int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_transfers.getSelectedColumn();
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot delete finalized transaction!");
            return;
        }

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Stock_transfers.delete_stock_transfers(to);
                data_cols();
                tbl_stock_transfers_items_ALM.clear();
                tbl_stock_transfers_items_M.fireTableDataChanged();
                tf_to_location.setText("");
                tf_to_location_id.setText("");
                tf_remarks.setText("");
                init_no();
                tf_to_location.grabFocus();
                Alert.set(3, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " "
                        + " where main_barcode like '" + search + "' and location_id='" + tf_from_location_id.getText() + "' "
                        + " or barcode='" + search + "' and location_id='" + tf_from_location_id.getText() + "' "
                        + " or description like '%" + search + "%' and location_id='" + tf_from_location_id.getText() + "' "
                        + " ";
                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
                if (inventory_barcoders_list.size() > 0) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][5];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        obj[i][3] = " " + to.unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 70, w - 70, 50, 70};
                    String[] col_names = {"Qty", "Item Code", "Description", "Unit", "Price"};
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

    private void add_item(final Inventory_barcodes.to_inventory_barcodes t) {
        Window p = (Window) this;
        Dlg_new_stock_transfer_qty nd = Dlg_new_stock_transfer_qty.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_new_stock_transfer_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_qty.OutputData data) {
                closeDialog.ok();
                int id = 0;
                String barcode = t.main_barcode;
                String description = t.description;
                String generic_name = t.generic_name;
                String category = t.category;
                String category_id = t.category_id;
                String classification = t.classification;
                String classification_id = t.classification_id;
                String sub_classification = t.sub_classification;
                String sub_classification_id = t.sub_classification_id;
                double product_qty = data.qty;
                String unit = t.unit;
                double conversion = t.conversion;
                double selling_price = t.selling_price;
                String date_added = DateType.now();
                String user_name = Users.user_name;
                String item_type = t.item_type;
                int status = 0;
                String supplier = t.supplier;
                int fixed_price = t.fixed_price;
                double cost = t.cost;
                String supplier_id = t.supplier_id;
                int multi_level_pricing = t.multi_level_pricing;
                int vatable = t.vatable;
                double reorder_level = t.reorder_level;
                double markup = t.markup;
                String main_barcode = t.barcode;
                String brand = t.brand;
                String brand_id = t.brand_id;
                String model = t.model;
                String model_id = t.model_id;
                int selling_type = t.selling_type;
                String branch = t.branch;
                String branch_code = t.branch_code;
                String location = t.location;
                String location_id = t.location_id;
                String serial_no = data.serial_no;
                serial_no = serial_no.replaceAll("\n", ",");
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String at_branch = my_branch;
                String at_branch_id = my_branch_id;
                String at_location = my_location;
                String at_location_id = my_location_id;
                to_stock_transfers_items field = new to_stock_transfers_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, "", serial_no, to_branch, to_branch_id, to_location, to_location_id, at_branch, at_branch_id, at_location, at_location_id
                );
                if (jButton5.isEnabled()) {
                    tbl_stock_transfers_items_ALM.add(field);
                    tbl_stock_transfers_items_M.fireTableDataChanged();
                } else {
                    int row = tbl_stock_transfers.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
                    List<Stock_transfers_items.to_stock_transfers_items> datas = new ArrayList();
                    datas.add(field);
                    Stock_transfers_items.add_stock_transfers_items(datas, to.transaction_no, to);
                    data_cols_items();
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    private ArrayListModel tbl_stock_transfers_items_ALM;
    private Tblstock_transfers_itemsModel tbl_stock_transfers_items_M;

    private void init_tbl_stock_transfers_items() {
        tbl_stock_transfers_items_ALM = new ArrayListModel();
        tbl_stock_transfers_items_M = new Tblstock_transfers_itemsModel(tbl_stock_transfers_items_ALM);
        tbl_stock_transfers_items.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_stock_transfers_items.setModel(tbl_stock_transfers_items_M);
        tbl_stock_transfers_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers_items.setRowHeight(25);
        int[] tbl_widths_stock_transfers_items = {100, 100, 80, 50, 50, 50, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers_items.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers_items, i, tbl_widths_stock_transfers_items[i]);
        }
        Dimension d = tbl_stock_transfers_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers_items.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_stock_transfers_items.setRowHeight(25);
        tbl_stock_transfers_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_stock_transfers_items(List<to_stock_transfers_items> acc) {
        tbl_stock_transfers_items_ALM.clear();
        tbl_stock_transfers_items_ALM.addAll(acc);
    }

    public static class Tblstock_transfers_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Code", "Description", "Qty", "Unit", "Cost", "Price", "", "", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "barcodes", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id"
        };

        public Tblstock_transfers_itemsModel(ListModel listmodel) {
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
            to_stock_transfers_items tt = (to_stock_transfers_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.barcode;
                case 1:
                    return " " + tt.description;
                case 2:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 3:
                    return " " + tt.unit;
                case 4:
                    return " " + FitIn.fmt_woc(tt.cost);
                case 5:
                    return " " + FitIn.fmt_woc(tt.selling_price);
                case 6:
                    return " Update";
                case 7:
                    return " Delete";
                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.supplier;
                case 19:
                    return tt.fixed_price;
                case 20:
                    return tt.cost;
                case 21:
                    return tt.supplier_id;
                case 22:
                    return tt.multi_level_pricing;
                case 23:
                    return tt.vatable;
                case 24:
                    return tt.reorder_level;
                case 25:
                    return tt.markup;
                case 26:
                    return tt.barcodes;
                case 27:
                    return tt.brand;
                case 28:
                    return tt.brand_id;
                case 29:
                    return tt.model;
                case 30:
                    return tt.model_id;
                case 31:
                    return tt.selling_type;
                case 32:
                    return tt.branch;
                case 33:
                    return tt.branch_code;
                case 34:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void data_cols_items() {

        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_transfers.getSelectedColumn();
        to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        String where = " where stock_transfer_id='" + to.transaction_no + "' order by description asc ";
        loadData_stock_transfers_items(Stock_transfers_items.ret_data(where));

        jLabel15.setText("" + tbl_stock_transfers_items_ALM.size());
        if (col == 9) {
            get_customers_aging();
        }
        if (col == 7) {
            select_transfer();
            jTabbedPane1.setSelectedIndex(0);
            jButton5.setEnabled(false);
            jButton1.setEnabled(true);
        }
        if (col == 8) {
            delete_stock_transfer();
        }

        if (col == 10) {

            if (to.isSelected()) {
                to.setSelected(false);
                tbl_stock_transfers_M.fireTableDataChanged();
            } else {
                to.setSelected(true);
                tbl_stock_transfers_M.fireTableDataChanged();
            }

        }

    }

    private void select_transfer() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        jTextField2.setText(to.transaction_no);
        tf_from_branch.setText(to.from_branch);
        tf_from_branch_id.setText(to.from_branch_id);
        tf_from_location.setText(to.from_location);
        tf_from_location_id.setText(to.from_location_id);

        tf_to_branch.setText(to.to_branch);
        tf_to_branch_id.setText(to.to_branch_id);
        tf_to_location.setText(to.to_location);
        tf_to_location_id.setText(to.to_location_id);
        tf_remarks.setText(to.remarks);

    }

    private void get_customers_aging() {

        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));

        jProgressBar2.setString("Loading... Please wait...");
        jProgressBar2.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                List<Srpt_stock_transfer.field> datas = new ArrayList();
                List<to_stock_transfers_items> fields = tbl_stock_transfers_items_ALM;
                for (to_stock_transfers_items f : fields) {
                    String item_code = f.barcode;
                    String barcode = f.barcodes;
                    String description = f.description;
                    double qty = f.product_qty;
                    String unit = f.unit;
                    String serial_no = f.serial_no;
                    double price = f.selling_price;
                    double amount = f.selling_price * f.product_qty;
                    Srpt_stock_transfer.field rpt = new Srpt_stock_transfer.field(item_code, barcode, description, qty, unit, serial_no, price, amount);
                    datas.add(rpt);
                }
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String date = DateType.month_date.format(new Date());
                String printed_by = "Administrator";
                String transaction_no = to.transaction_no;
                String from_branch = to.from_branch;
                String from_location = to.from_location;
                String to_branch = to.to_branch;
                String to_location = to.to_location;

                String address = System.getProperty("address", "");
                String contact_no = System.getProperty("contact_no", "");

                Srpt_stock_transfer rpt = new Srpt_stock_transfer(transaction_no, from_branch, from_location, to_branch, to_location, business_name, address, contact_no, date);
                rpt.fields.addAll(datas);
                String jrxml = "rpt_stock_transfer.jrxml";
                report_customers_aging(rpt, jrxml);
                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
                jTabbedPane1.setSelectedIndex(2);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_stock_transfer to, String jrxml_name) {
        jPanel9.removeAll();
        jPanel9.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_customers_aging(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel9.add(viewer);
            jPanel9.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_customers_aging(Srpt_stock_transfer to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_aging(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_aging(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_stock_transfer.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void update_queue_items() {
        int row = tbl_stock_transfers_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_transfers_items.getSelectedColumn();
        final to_stock_transfers_items to = (to_stock_transfers_items) tbl_stock_transfers_items_ALM.get(row);
        if (to.id == 0) {
            if (col == 6) {
                Window p = (Window) this;
                Dlg_new_stock_transfer_qty nd = Dlg_new_stock_transfer_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.product_qty, to.serial_no);
                nd.setCallback(new Dlg_new_stock_transfer_qty.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_qty.OutputData data) {
                        closeDialog.ok();
                        to.setProduct_qty(data.qty);
                        to.setSerial_no(data.serial_no);
                        tbl_stock_transfers_items_M.fireTableDataChanged();
                        Alert.set(2, "");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
            if (col == 7) {
                tbl_stock_transfers_items_ALM.remove(row);
                tbl_stock_transfers_items_M.fireTableDataChanged();
            }
        } else {
            if (col == 6) {
                Window p = (Window) this;
                Dlg_new_stock_transfer_qty nd = Dlg_new_stock_transfer_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.product_qty, to.serial_no);
                nd.setCallback(new Dlg_new_stock_transfer_qty.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_new_stock_transfer_qty.OutputData data) {
                        closeDialog.ok();
                        Stock_transfers_items.edit_stock_transfers_items2("" + to.id, data.qty, data.serial_no);
                        data_cols_items();
                        Alert.set(2, "");

                    }
                });

                nd.setLocationRelativeTo(this);
                nd.setVisible(true);

            }
            if (col == 7) {

                Stock_transfers_items.delete_stock_transfers_items2("" + to.id);
                data_cols_items();
                Alert.set(3, "");
            }
        }

    }

    private void show_popup(MouseEvent evt) {

        int col = tbl_stock_transfers.getSelectedColumn();
        jMenuItem1.setVisible(false);
        jMenuItem2.setVisible(false);
        if (col == 4) {
            int row = tbl_stock_transfers.getSelectedRow();
            if (row < 0) {
                return;
            }
            String where = " where user_name='" + Users.user_name + "' order by previledge asc";
            List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
            int exists = 0;
            for (S1_user_previleges.to_user_previleges to : datas) {
                if (to.previledge.equalsIgnoreCase("Finalize Stock Transfer")) {
                    exists = 1;
                    break;
                }
            }

            if (exists == 1) {
                data_cols_items();
                if (evt.isPopupTrigger()) {
                    jMenuItem1.setVisible(true);
                    jPopupMenu1.show(tbl_stock_transfers, evt.getX(), evt.getY());
                }
            }
        }
    }

    private void select_stock_transfer() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }

        to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        jTextField2.setText(to.transaction_no);
        tf_from_branch.setText(to.from_branch);
        tf_from_branch_id.setText(to.from_branch_id);
        tf_from_location.setText(to.from_location);
        tf_from_location_id.setText(to.from_location_id);

        tf_to_branch.setText(to.to_branch);
        tf_to_branch_id.setText(to.to_branch_id);
        tf_to_location.setText(to.to_location);
        tf_to_location_id.setText(to.to_location_id);

        data_cols_items();
        int col = tbl_stock_transfers.getSelectedColumn();
        if (col == 5) {
            jTabbedPane1.setSelectedIndex(0);
            jButton5.setEnabled(false);
            jButton1.setEnabled(true);

            if (to.status == 0) {
                jButton7.setEnabled(true);
                jButton1.setEnabled(true);
            } else {
                jButton7.setEnabled(false);
                jButton1.setEnabled(false);
            }

        }
        if (col == 6) {
            delete_transfer();
        }
        if (col == 7) {
            get_customers_aging();
        }
    }

    private void delete_transfer() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot delete finalized transaction!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();

                Stock_transfers.delete_stock_transfers(to);
                data_cols();

                tbl_stock_transfers_items_ALM.clear();
                tbl_stock_transfers_items_M.fireTableDataChanged();
                tf_remarks.setText("");
                jButton5.setEnabled(true);
                jButton1.setEnabled(false);
                jButton7.setEnabled(false);
                tf_to_branch.setText("");
                tf_to_branch_id.setText("");
                tf_to_location.setText("");
                tf_to_location_id.setText("");

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void finalize_transfer() {
        final int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(tbl_stock_transfers.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Stock Transfer-Status [Finalized]");
            return;
        }

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                List<Stock_transfers_items.to_stock_transfers_items> datas = tbl_stock_transfers_items_ALM;
                Stock_transfers.finalize(to, datas);
                data_cols();
                tbl_stock_transfers.setRowSelectionInterval(row, row);
                data_cols_items();

                init_no();
                tf_remarks.setText("");
                jButton5.setEnabled(true);
                jButton1.setEnabled(false);
                jButton7.setEnabled(false);
                tf_to_branch.setText("");
                tf_to_branch_id.setText("");
                tf_to_location.setText("");
                tf_to_location_id.setText("");
                tbl_stock_transfers_items_ALM.clear();
                tbl_stock_transfers_items_M.fireTableDataChanged();
                Alert.set(0, "Stock Transfer Finalized");

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

}
