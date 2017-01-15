/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

import POS.zbak_accounts_payable.S1_accounts_payable;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Inventory_barcodes;
import POS.main.Main;
import POS.purchase_order.S1_purchase_order_items.to_purchase_order_items;
import POS.purchase_order.S1_purchase_order_orders.to_purchase_order_orders;
import POS.suppliers.S1_suppliers;
import POS.util.*;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import synsoftech.fields.Field;

/**
 *
 * @author Maytopacka
 */
public class Dlg_purchase_order extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_all_sales_report
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
    private Dlg_purchase_order(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_purchase_order(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_purchase_order() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_purchase_order myRef;

    private void setThisRef(Dlg_purchase_order myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_purchase_order> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_purchase_order create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_purchase_order create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_purchase_order dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_purchase_order((java.awt.Frame) parent, false);
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
            Dlg_purchase_order dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_purchase_order((java.awt.Dialog) parent, false);
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
        Dlg_purchase_order dialog = Dlg_purchase_order.create(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_purchase_order_items = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_search = new Field.Input();
        jLabel6 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_po_no = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new Field.Combo();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new Field.Combo();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pnl_sales_items = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tf_search_customer = new Field.Input();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_customer_name = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_customer_balance = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_customer_credit_limit = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_customer_discount = new javax.swing.JLabel();
        cb_supplier = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_items);

        tbl_purchase_order_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_purchase_order_items);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("SEARCH (F1) :");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TOTAL:");

        lbl_total.setBackground(new java.awt.Color(51, 153, 255));
        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.00");
        lbl_total.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SELECT LIST (F2), DELETE LIST (DEL), ADD PO (Ctrl)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("PURCHASE ORDER");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("|");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("PO NUMBER:");

        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Branch:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Location:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setFocusable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setFocusable(false);

        jTextField1.setText("Supplier Code-YearMonth-01");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Reference No.:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_po_no, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_po_no, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(7, 7, 7))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnl_sales_items.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_sales_itemsLayout = new javax.swing.GroupLayout(pnl_sales_items);
        pnl_sales_items.setLayout(pnl_sales_itemsLayout);
        pnl_sales_itemsLayout.setHorizontalGroup(
            pnl_sales_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        pnl_sales_itemsLayout.setVerticalGroup(
            pnl_sales_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tf_search_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search_customerActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("SEARCH (F3):");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("ID:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("NAME:");

        lbl_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_customer_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbl_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("BALANCE:");

        lbl_customer_balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_customer_balance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("CREDIT LIMIT:");

        lbl_customer_credit_limit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_customer_credit_limit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("DISCOUNT:");

        lbl_customer_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_customer_discount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        cb_supplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_supplierActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("SUPPLIER:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tf_search_customer))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_customer_balance, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(lbl_customer_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_customer_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(156, 156, 156)
                                        .addComponent(cb_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(137, 137, 137)))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search_customer)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addComponent(lbl_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_customer_discount, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(lbl_customer_credit_limit, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(lbl_customer_balance, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addComponent(pnl_sales_items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_sales_items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void cb_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_supplierActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_cb_supplierActionPerformed

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        // TODO add your handling code here:
        add_po_qty();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        print();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pnl_sales_items.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jPanel2.setVisible(true);
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_search_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search_customerActionPerformed
        init_popup();
    }//GEN-LAST:event_tf_search_customerActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

    }//GEN-LAST:event_jTextField5ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_supplier;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lbl_customer_balance;
    private javax.swing.JLabel lbl_customer_credit_limit;
    private javax.swing.JLabel lbl_customer_discount;
    private javax.swing.JLabel lbl_customer_name;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_po_no;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel pnl_sales_items;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTable tbl_purchase_order_items;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_search_customer;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_algorithm");
        init_key();
        init_tbl_items();
        init_supplier();
        init_tbl_purchase_order_items();
        init_po_no();
        pnl_sales_items.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        focus();
        cb_supplier.setVisible(false);
        jLabel3.setVisible(false);
        set_default_branch();

        jTextField4.setVisible(false);
        jTextField6.setVisible(false);

    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        jTextField3.setText(to.branch);
        jTextField4.setText(to.branch_id);
        jTextField5.setText(to.location);
        jTextField6.setText("" + to.id);

    }

    private void focus() {
        JTextField[] tf = {tf_search, tf_search_customer};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_po_no() {
        lbl_po_no.setText(S1_purchase_orders.increment_id());
    }

    private void init_supplier() {
        cb_supplier.setModel(new ListComboBoxModel(S1_suppliers.ret_cb_data()));
//        cb_supplier2.setModel(new ListComboBoxModel(S1_suppliers.ret_cb_data()));
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
                add_po();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                if (!tbl_purchase_order_items_ALM.isEmpty()) {
                    tbl_purchase_order_items.setRowSelectionInterval(0, 0);
                    tbl_purchase_order_items.grabFocus();
                }
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_search.grabFocus();
                tf_search.selectAll();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_search_customer.grabFocus();

            }
        });
        tf_search.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_items_ALM.isEmpty()) {
                        tbl_items.setRowSelectionInterval(0, 0);
                        tbl_items.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    add_po();
                }
            }
        });
        tbl_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    tf_search.grabFocus();
                    tf_search.selectAll();
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add_po_qty();
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    if (!tbl_purchase_order_items_ALM.isEmpty()) {
                        tbl_purchase_order_items.setRowSelectionInterval(0, 0);
                        tbl_purchase_order_items.grabFocus();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    add_po();
                }

            }
        });
        tbl_purchase_order_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    add_po();
                }
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int row = tbl_purchase_order_items.getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    tbl_purchase_order_items_ALM.remove(row);
                    tbl_purchase_order_items_M.fireTableDataChanged();
                    compute();
                    tf_search.grabFocus();
                }
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_items_ALM;
    private TblitemsModel tbl_items_M;

    private void init_tbl_items() {
        tbl_items_ALM = new ArrayListModel();
        tbl_items_M = new TblitemsModel(tbl_items_ALM);
        tbl_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_items.setModel(tbl_items_M);
        tbl_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);
        int[] tbl_widths_items = {60, 100, 100, 100, 100, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_items.getTableHeader().
                setPreferredSize(d);
        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_items.setRowHeight(25);
        tbl_items.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_items, 5);
    }

    private void loadData_items(List<Inventory_barcodes.to_inventory_barcodes> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "QTY", "BARCODE", "DESCRIPTION", "ITEM CODE", "UNIT", "COST", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level"
        };

        public TblitemsModel(ListModel listmodel) {
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
            Inventory_barcodes.to_inventory_barcodes tt = (Inventory_barcodes.to_inventory_barcodes) getRow(row);
            switch (col) {
                case 0:
                    if (tt.product_qty <= tt.reorder_level) {
                        return TextHighlighter1.highlight2(FitIn.fmt_woc(tt.product_qty), FitIn.
                                fmt_woc(tt.product_qty), "pink");
                    } else {
                        return " " + FitIn.fmt_wc_0(tt.product_qty);
                    }
                case 1:
                    return " " + tt.barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return " " + tt.main_barcode;
                case 4:
                    return " " + tt.unit;
                case 5:
                    return " " + FitIn.fmt_wc_0(tt.cost) + " ";
                case 6:
                    return " " + tt.classification;
                case 7:
                    return " " + tt.classification_id;
                case 8:
                    return " " + tt.sub_classification;
                case 9:
                    return " " + tt.sub_classification_id;
                case 10:
                    return " " + tt.product_qty;
                case 11:
                    return " " + tt.unit;
                case 12:
                    return " " + tt.conversion;
                case 13:
                    return " " + tt.selling_price;
                case 14:
                    return " " + tt.date_added;
                case 15:
                    return " " + tt.user_name;
                case 16:
                    return " " + tt.item_type;
                case 17:
                    return " " + tt.status;
                case 18:
                    return " " + tt.supplier;
                case 19:
                    return " " + tt.fixed_price;
                case 20:
                    return " " + tt.cost;
                case 21:
                    return " " + tt.supplier_id;
                case 22:
                    return " " + tt.multi_level_pricing;
                case 23:
                    return " " + tt.vatable;
                default:
                    return " " + tt.reorder_level;
            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        String supplier = cb_supplier.getSelectedItem().
                toString();
        String location_id = jTextField6.getText();
        String where = " where main_barcode='" + search + "' and location_id='" + location_id + "' "
                + " or barcode='" + search + "' and location_id='" + location_id + "' "
                + " or description like '%" + search + "%' and location_id='" + location_id + "' ";
        where = where + " order by description asc ";
        loadData_items(Inventory_barcodes.ret_where(where));
    }

    private void add_po_qty() {
        int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) tbl_items_ALM.get(tbl_items.
                convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_po_qty nd = Dlg_po_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(0, to.cost, to.description);
        nd.setCallback(new Dlg_po_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_po_qty.OutputData data) {
                closeDialog.ok();
                int naa = 0;
                List<to_purchase_order_orders> datas = tbl_purchase_order_items_ALM;
                for (to_purchase_order_orders t : datas) {
                    if (to.barcode.equals(t.barcode) && to.unit.equals(t.unit)) {
                        naa = 1;
                        t.setQty(data.qty + t.qty);
                        t.setCost(data.cost);
                        t.setTotal(data.cost * (t.qty));
                        tbl_purchase_order_items_M.fireTableDataChanged();
                        compute();
                        System.out.println("");
                        break;
                    } else {
                        naa = 0;
                    }
                }

                if (naa == 0) {
                    int id = 0;
                    String po_no = lbl_po_no.getText();
                    String user_name = Users.user_name;
                    String session_no = Users.session_no;
                    String date_added = DateType.datetime.format(new Date());
                    String supplier = to.supplier;
                    String supllier_id = to.supplier_id;
                    String remarks = "";
                    String barcode = to.barcode;
                    String description = to.description;
                    double qty = data.qty;
                    double cost = data.cost;
                    String category = to.category;
                    String category_id = to.category_id;
                    String classification = to.classification;
                    String classification_id = to.classification_id;
                    String sub_class = to.sub_classification;
                    String sub_class_id = to.sub_classification_id;
                    double conversion = to.conversion;
                    String unit = to.unit;
                    double total = qty * cost;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    String main_barcode = to.main_barcode;
                    to_purchase_order_orders to1 = new to_purchase_order_orders(id, po_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, total, brand, brand_id, model, model_id, main_barcode);
                    tbl_purchase_order_items_ALM.add(to1);
                    tbl_purchase_order_items_M.fireTableDataChanged();
                    tf_search.grabFocus();
                    tf_search.selectAll();
                    compute();
                }

            }

            @Override
            public void delete(CloseDialog closeDialog, Dlg_po_qty.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
    private ArrayListModel tbl_purchase_order_items_ALM;
    private Tblpurchase_order_itemsModel tbl_purchase_order_items_M;

    private void init_tbl_purchase_order_items() {
        tbl_purchase_order_items_ALM = new ArrayListModel();
        tbl_purchase_order_items_M = new Tblpurchase_order_itemsModel(tbl_purchase_order_items_ALM);
        tbl_purchase_order_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_purchase_order_items.setModel(tbl_purchase_order_items_M);
        tbl_purchase_order_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_purchase_order_items.setRowHeight(25);
        int[] tbl_widths_purchase_order_items = {60, 100, 100, 50, 70, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_purchase_order_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_purchase_order_items, i, tbl_widths_purchase_order_items[i]);
        }
        Dimension d = tbl_purchase_order_items.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_purchase_order_items.getTableHeader().
                setPreferredSize(d);
        tbl_purchase_order_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_purchase_order_items.setRowHeight(25);
        tbl_purchase_order_items.setFont(new java.awt.Font("Arial", 1, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_purchase_order_items, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_purchase_order_items, 5);
    }

    private void loadData_purchase_order_items(List<to_purchase_order_orders> acc) {
        tbl_purchase_order_items_ALM.clear();
        tbl_purchase_order_items_ALM.addAll(acc);
    }

    public static class Tblpurchase_order_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "QTY", "BARCODE", "DESCRIPTION", "UNIT", "COST", "TOTAL", "supllier_id", "remarks", "barcode", "description", "qty", "cost", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit"
        };

        public Tblpurchase_order_itemsModel(ListModel listmodel) {
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
            to_purchase_order_orders tt = (to_purchase_order_orders) getRow(row);
            switch (col) {
                case 0:
                    return FitIn.fmt_wc_0(tt.qty);
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
                case 3:
                    return tt.unit;
                case 4:
                    return FitIn.fmt_wc_0(tt.cost);
                case 5:
                    return FitIn.fmt_wc_0(tt.total);
                case 6:
                    return tt.supllier_id;
                case 7:
                    return tt.remarks;
                case 8:
                    return tt.barcode;
                case 9:
                    return tt.description;
                case 10:
                    return tt.qty;
                case 11:
                    return tt.cost;
                case 12:
                    return tt.category;
                case 13:
                    return tt.category_id;
                case 14:
                    return tt.classification;
                case 15:
                    return tt.classification_id;
                case 16:
                    return tt.sub_class;
                case 17:
                    return tt.sub_class_id;
                case 18:
                    return tt.conversion;
                default:
                    return tt.unit;
            }
        }
    }

    private void compute() {
        List<to_purchase_order_orders> datas = tbl_purchase_order_items_ALM;
        double total = 0;
        for (to_purchase_order_orders to : datas) {
            total += to.total;
        }
        lbl_total.setText(FitIn.fmt_wc_0(total));
    }

    private void data_cols_items() {
//        String search = tf_search.getText();
//        loadData_purchase_order_items(S1_purchase_order_items.ret_data(search));
    }

    private void add_po() {
        int id = 0;
        String po_no = lbl_po_no.getText();
        String user_name = Users.user_name;
        String session_no = Users.session_no;
        String date_added = DateType.datetime.format(new Date());
        String remarks = "";
        String account_id = lbl_id.getText();
        String account_name = lbl_customer_name.getText();
        double amount = FitIn.toDouble(lbl_total.getText());
        S1_purchase_orders.to_purchase_orders to = new S1_purchase_orders.to_purchase_orders(id, po_no, user_name, session_no, date_added, remarks, account_id, account_name, amount);
        S1_purchase_orders.add_purchase_orders(to);

        boolean selected = false;
        String customer_id = lbl_id.getText();
        String customer_name = lbl_id.getText();
        String ar_no = lbl_po_no.getText();
        double discount_amount = 0;
        double discount_rate = 0;
        String discount = "";
        int status = 0;
        double term = 0;
        String date_applied = DateType.datetime.format(new Date());
        double paid = 0;
        String date_paid = DateType.datetime.format(new Date());
        String type = "PURCHASE ORDER";
        String or_no = lbl_customer_name.getText();
        int row = 0;
        double remaining_balance = 0;
        int ap_main = 0;
        S1_accounts_payable.to_accounts_payable payable = new S1_accounts_payable.to_accounts_payable(selected, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, row, remaining_balance, ap_main);
        S1_accounts_payable.add_accounts_receivable(payable);
        List<to_purchase_order_orders> datas = tbl_purchase_order_items_ALM;
        List<to_purchase_order_items> items = new ArrayList();
        for (to_purchase_order_orders t : datas) {
            String supplier = t.supplier;
            String supllier_id = t.supllier_id;
            String barcode = t.barcode;
            String description = t.description;
            double qty = t.qty;
            double cost = t.cost;
            String category = t.category;
            String category_id = t.category_id;
            String classification = t.classification;
            String classification_id = t.classification_id;
            String sub_class = t.sub_class;
            String sub_class_id = t.sub_class_id;
            double conversion = t.conversion;
            String unit = t.unit;
            String brand = t.brand;
            String brand_id = t.brand_id;
            String model = t.model;
            String model_id = t.model_id;
            String main_barcode = t.main_barcode;
            String branch = jTextField3.getText();
            String branch_id = jTextField4.getText();
            String location = jTextField5.getText();
            String location_id = jTextField6.getText();

            to_purchase_order_items to1 = new to_purchase_order_items(id, po_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, brand, brand_id, model, model_id, main_barcode, branch, branch_id, location, location_id);
            items.add(to1);
        }
        S1_purchase_order_items.add_purchase_order_items(items);
        Alert.set(1, "");
        get_data(po_no);
        tbl_purchase_order_items_ALM.clear();
        tbl_purchase_order_items_M.fireTableDataChanged();
        compute();
        init_po_no();
        tf_search.grabFocus();
        tf_search.selectAll();
        pnl_sales_items.setVisible(true);
        jPanel2.setVisible(false);
        jPanel4.setVisible(false);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jPanel2.setVisible(false);
    }

    private void get_data(String po_no) {
        List<Srpt_purchase_order1.field> fields = new ArrayList();
        List<to_purchase_order_orders> datas = tbl_purchase_order_items_ALM;
        for (to_purchase_order_orders t : datas) {
            String date_added = DateType.month_date.format(new Date());
            String supplier = t.supplier;

            String barcode = t.barcode;
            String description = t.description;
            double qty = t.qty;
            double cost = t.cost;
            String category = t.category;
            double conversion = t.conversion;
            String unit = t.unit;
            double total = t.total;
            Srpt_purchase_order1.field to = new Srpt_purchase_order1.field(date_added, supplier, barcode, description, qty, cost, category, conversion, unit, total);
            fields.add(to);
        }
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String business_owner = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String business_address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        String date_printed = DateType.day_and_time.format(new Date());
        String sales_date = lbl_po_no.getText();
        String printed_by = lbl_customer_name.getText();
        String supplier=lbl_customer_name.getText();
       
        Srpt_purchase_order1 rpt = new Srpt_purchase_order1(business_name, business_owner, business_address, date_printed, sales_date, printed_by, po_no,supplier);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_purchase_order.jrxml";

        report_sales_items(rpt, jrxml);
        JasperReport jasperReport = null;
        InputStream is = Srpt_purchase_order1.class.getResourceAsStream(jrxml);
        try {
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
        } catch (JRException ex) {
            Logger.getLogger(Srpt_purchase_order1.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_purchase_order1.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_purchase_order1 to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    private void report_sales_items(final Srpt_purchase_order1 to, String jrxml_name) {
        pnl_sales_items.removeAll();
        pnl_sales_items.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_all_sales(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_sales_items.add(viewer);
            pnl_sales_items.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_all_sales(Srpt_purchase_order1 to, String rpt_name) {
//        Connection con11 = null;
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
    JasperPrint jasperPrint = null;

    private void print() {
        try {
            JasperPrintManager.printReport(jasperPrint, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    private void init_popup() {
        String search = tf_search_customer.getText();
        List<S1_suppliers.to_suppliers> datas = S1_suppliers.ret_data(search);
        Object[][] obj = new Object[datas.size()][6];
        int i = 0;
        for (S1_suppliers.to_suppliers to : datas) {
            obj[i][0] = "" + to.customer_no;
            obj[i][1] = "" + to.customer_name;
            obj[i][2] = " " + to.discount;
            obj[i][3] = " " + to.credit_limit;
            obj[i][4] = " " + to.term;
            obj[i][5] = " " + FitIn.fmt_wc_0(to.balance);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 100, 0, 0, 0, 150};
        String[] col_names = {"ID", "NAME", "DISCOUNT", "CREDIT LIMIT", "TERM", "BALANCE"};
        TableRenderer tr = new TableRenderer();

        TableRenderer.setPopup(tf_search_customer, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {

            @Override
            public void ok(TableRenderer.OutputData data) {
                lbl_id.setText(data.output[0]);
                System.out.println("ID: "+lbl_id.getText());
                lbl_customer_name.setText(data.output[1]);
                lbl_customer_balance.setText(data.output[5]);
                lbl_customer_credit_limit.setText(data.output[3]);
                lbl_customer_discount.setText(data.output[4]);
                tf_search.grabFocus();
            }
        });
    }
}
