/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.barcodes.Dlg_barcodes;
import POS.branch_locations.S1_branch_locations;
import POS.category.S1_inventory_brand;
import POS.category.S1_inventory_category;
import POS.category.S1_inventory_classification;
import POS.category.S1_inventory_model;
import POS.category.S1_inventory_sub_classification;
import POS.inventory.Dlg_inventory_branch;
import POS.inventory.Dlg_inventory_brand_privileges;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Dlg_inventory_update_barcode;
import POS.inventory.Dlg_print_barcode;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.Inventory_location_privileges;
import POS.inventory.Srpt_print_barcodes;
import POS.inventory.uom;
import POS.my_sales.MySales_Items;
import POS.purchase_order.Purchase_order;
import POS.purchase_order.Purchase_order_item;
import POS.receipts.S1_receipt_orders.to_receipt_items;
import POS.receipts.Warranties.to_warranties;
import POS.receipts.Warranty_items.to_warranty_items;
import static POS.reports3.Dlg_report_item.tbl_inventory_ALM;
import POS.reports3.Srpt_stock_take;
import POS.stock_transfer.Stock_transfer_items;
import POS.suppliers.Dlg_suppliers;
import POS.suppliers.Suppliers;
import POS.test2.Serial;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.*;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.jfree.ui.Align;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.panels.Loading;

/**
 *
 * @author Maytopacka
 */
public class Dlg_warranty_service extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_location
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
    private Dlg_warranty_service(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_warranty_service(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_warranty_service() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_warranty_service myRef;

    private void setThisRef(Dlg_warranty_service myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_warranty_service> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_warranty_service create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_warranty_service create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_warranty_service dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_warranty_service((java.awt.Frame) parent, false);
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
            Dlg_warranty_service dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_warranty_service((java.awt.Dialog) parent, false);
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

        Dlg_warranty_service dialog = Dlg_warranty_service.
                create(new javax.swing.JFrame(), true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jCheckBox29 = new javax.swing.JCheckBox();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jLabel44 = new javax.swing.JLabel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        jCheckBox30 = new javax.swing.JCheckBox();
        tf_branch4 = new Field.Combo();
        jLabel46 = new javax.swing.JLabel();
        jCheckBox31 = new javax.swing.JCheckBox();
        jTextField4 = new Field.Combo();
        jButton4 = new Button.Primary();
        jLabel49 = new javax.swing.JLabel();
        jCheckBox36 = new javax.swing.JCheckBox();
        jCheckBox37 = new javax.swing.JCheckBox();
        jCheckBox38 = new javax.swing.JCheckBox();
        jButton8 = new Button.Info();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_warranties = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jPanel18 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jCheckBox32 = new javax.swing.JCheckBox();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        jCheckBox33 = new javax.swing.JCheckBox();
        tf_branch5 = new Field.Combo();
        jLabel54 = new javax.swing.JLabel();
        jCheckBox34 = new javax.swing.JCheckBox();
        jTextField5 = new Field.Combo();
        jLabel55 = new javax.swing.JLabel();
        jCheckBox39 = new javax.swing.JCheckBox();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox41 = new javax.swing.JCheckBox();
        jLabel56 = new javax.swing.JLabel();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jCheckBox44 = new javax.swing.JCheckBox();
        jLabel57 = new javax.swing.JLabel();
        jCheckBox35 = new javax.swing.JCheckBox();
        jCheckBox45 = new javax.swing.JCheckBox();
        jCheckBox46 = new javax.swing.JCheckBox();
        jCheckBox47 = new javax.swing.JCheckBox();
        jLabel58 = new javax.swing.JLabel();
        tf_search2 = new Field.Input();
        jButton12 = new Button.Info();
        jPanel1 = new javax.swing.JPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_reference_no = new Field.Input();
        tf_supplier = new Field.Combo();
        tf_branch_location = new Field.Combo();
        tf_remarks = new Field.Input();
        tf_receipt_no = new Field.Input();
        jPanel7 = new javax.swing.JPanel();
        tf_receipt_type = new Field.Combo();
        tf_receipt_type_id = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lbl_batch_no = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tf_disc = new javax.swing.JTextField();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        tf_branch_id = new javax.swing.JTextField();
        tf_supplier_id = new javax.swing.JTextField();
        tf_receipt_no4 = new javax.swing.JTextField();
        tf_receipt_no3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_receipt_no2 = new javax.swing.JTextField();
        tf_receipt_no1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_search = new Field.Input();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_receipt_items = new org.jdesktop.swingx.JXTable();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Default();
        jButton3 = new Button.Info();
        jLabel17 = new javax.swing.JLabel();
        lbl_gross = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_discount = new javax.swing.JTextField();
        lbl_net = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new Button.Success();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton5 =  new Button.Default();
        jLabel25 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        tf_branch1 = new Field.Combo();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox15 = new javax.swing.JCheckBox();
        tf_branch2 = new Field.Combo();
        jLabel36 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        jCheckBox22 = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        jButton7 =  new Button.Default();
        jLabel39 = new javax.swing.JLabel();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        tf_search1 = new Field.Input();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        tf_branch3 = new Field.Combo();
        jCheckBox27 = new javax.swing.JCheckBox();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jCheckBox48 = new javax.swing.JCheckBox();
        jCheckBox49 = new javax.swing.JCheckBox();
        jCheckBox50 = new javax.swing.JCheckBox();
        jCheckBox51 = new javax.swing.JCheckBox();
        tf_search3 = new Field.Input();
        jLabel61 = new javax.swing.JLabel();
        jButton13 = new Button.Info();
        jLabel62 = new javax.swing.JLabel();
        jCheckBox52 = new javax.swing.JCheckBox();
        tf_branch6 = new Field.Combo();
        jPanel21 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jProgressBar5 = new javax.swing.JProgressBar();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/transactions.png"))); // NOI18N
        jMenuItem1.setText("Finalize Receipt");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_new_new.png"))); // NOI18N
        jMenuItem2.setText("Add All to Queue");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Date From:");

        jCheckBox29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox29.setText("All");
        jCheckBox29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox29ActionPerformed(evt);
            }
        });

        jDateChooser7.setDate(new Date());
        jDateChooser7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("To:");

        jDateChooser8.setDate(new Date());
        jDateChooser8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("Location:");

        jCheckBox30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox30.setText("All");

        tf_branch4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch4MouseClicked(evt);
            }
        });
        tf_branch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch4ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Supplier:");

        jCheckBox31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox31.setSelected(true);
        jCheckBox31.setText("All");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton4.setText("Add new Record");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("Status:");

        buttonGroup8.add(jCheckBox36);
        jCheckBox36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox36.setText("All");

        buttonGroup8.add(jCheckBox37);
        jCheckBox37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox37.setSelected(true);
        jCheckBox37.setText("Posted");

        buttonGroup8.add(jCheckBox38);
        jCheckBox38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox38.setText("Finalized");

        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tbl_warranties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_warranties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_warrantiesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_warranties);

        jLabel52.setText("No. of rows:");

        jLabel53.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jCheckBox31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jCheckBox36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_branch4))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_branch4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Warranties", jPanel9);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setText("State:");

        jProgressBar4.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar4.setString("");
        jProgressBar4.setStringPainted(true);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Date From:");

        jCheckBox32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox32.setText("All");
        jCheckBox32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox32ActionPerformed(evt);
            }
        });

        jDateChooser9.setDate(new Date());
        jDateChooser9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("To:");

        jDateChooser10.setDate(new Date());
        jDateChooser10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Location:");

        jCheckBox33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox33.setText("All");

        tf_branch5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch5MouseClicked(evt);
            }
        });
        tf_branch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch5ActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Supplier:");

        jCheckBox34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox34.setSelected(true);
        jCheckBox34.setText("All");

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

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Status:");

        buttonGroup8.add(jCheckBox39);
        jCheckBox39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox39.setText("All");

        buttonGroup8.add(jCheckBox40);
        jCheckBox40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox40.setText("Posted");

        buttonGroup8.add(jCheckBox41);
        jCheckBox41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox41.setText("Finalized");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("Type:");

        buttonGroup9.add(jCheckBox42);
        jCheckBox42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox42.setSelected(true);
        jCheckBox42.setText("All");

        buttonGroup9.add(jCheckBox43);
        jCheckBox43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox43.setText("In");

        buttonGroup9.add(jCheckBox44);
        jCheckBox44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox44.setText("Out");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Filter by:");

        jCheckBox35.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup10.add(jCheckBox35);
        jCheckBox35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox35.setText("[F1]-All");
        jCheckBox35.setFocusable(false);

        jCheckBox45.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup10.add(jCheckBox45);
        jCheckBox45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox45.setText("[F2]-Item Code");
        jCheckBox45.setFocusable(false);

        jCheckBox46.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup10.add(jCheckBox46);
        jCheckBox46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox46.setText("[F3]-Barcode");
        jCheckBox46.setFocusable(false);

        jCheckBox47.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup10.add(jCheckBox47);
        jCheckBox47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox47.setText("[F4]-Description");
        jCheckBox47.setFocusable(false);

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("Search:");

        tf_search2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search2ActionPerformed(evt);
            }
        });
        tf_search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search2KeyReleased(evt);
            }
        });

        jButton12.setText("Search");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jCheckBox33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_branch5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jCheckBox39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox41, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox44)))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jCheckBox35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox47))
                            .addComponent(tf_search2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_branch5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox39, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox41, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox42, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox44, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox35)
                            .addComponent(jCheckBox45)
                            .addComponent(jCheckBox46)
                            .addComponent(jCheckBox47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Items", jPanel12);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Warranty", jPanel8);

        jXPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Date of Delivery:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Received:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Transaction #:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Type:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Supplier:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Receiving Location:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Reference #:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("PO #:");

        tf_reference_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_reference_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reference_noActionPerformed(evt);
            }
        });

        tf_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_supplierMouseClicked(evt);
            }
        });
        tf_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_supplierActionPerformed(evt);
            }
        });

        tf_branch_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch_location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch_locationMouseClicked(evt);
            }
        });
        tf_branch_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch_locationActionPerformed(evt);
            }
        });

        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarksActionPerformed(evt);
            }
        });

        tf_receipt_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_receipt_no.setFocusable(false);
        tf_receipt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_receipt_noActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        tf_receipt_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_receipt_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_receipt_typeActionPerformed(evt);
            }
        });

        tf_receipt_type_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_receipt_type_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Batch No:");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lbl_batch_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_batch_no.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_batch_no.setText("0");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Discount:");

        tf_disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser5.setDate(new Date());
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser6.setDate(new Date());
        jDateChooser6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/maintenance.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/maintenance.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        tf_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch_id.setFocusable(false);

        tf_supplier_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_supplier_id.setFocusable(false);
        tf_supplier_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_supplier_idActionPerformed(evt);
            }
        });

        tf_receipt_no4.setFocusable(false);

        tf_receipt_no3.setFocusable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Location:");

        tf_receipt_no2.setFocusable(false);

        tf_receipt_no1.setFocusable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Branch:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("New");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Status:");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(tf_receipt_no4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_receipt_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_receipt_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(tf_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_receipt_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_receipt_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_receipt_no4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_receipt_no3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_receipt_no2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/items.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_supplier)
                            .addComponent(tf_branch_location))
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_disc, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(tf_remarks))))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(tf_receipt_type, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(tf_receipt_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_receipt_no))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_reference_no))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_batch_no, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_batch_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jXPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)))
                            .addComponent(jButton11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_receipt_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_receipt_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9))
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_branch_location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton10)))
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_disc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Search:");

        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jScrollPane3.setOpaque(false);

        tbl_receipt_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_receipt_items.setOpaque(false);
        tbl_receipt_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receipt_itemsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_receipt_itemsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_receipt_itemsMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_receipt_items);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Post");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update Post");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Gross Total:");

        lbl_gross.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gross.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_gross.setText("0.00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Discount:");

        tf_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_discount.setBorder(null);
        tf_discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_discountKeyReleased(evt);
            }
        });

        lbl_net.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_net.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_net.setText("0.00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Net Total:");

        jButton6.setText("Finalize");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("State:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Filter by:");

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("[F2]-Item Code");
        jCheckBox7.setFocusable(false);

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Barcode");
        jCheckBox8.setFocusable(false);

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("[F4]-Description");
        jCheckBox9.setFocusable(false);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gross, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_net, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addGap(5, 5, 5)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_discount)
                            .addComponent(jLabel20)
                            .addComponent(lbl_net))
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_gross, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Receipts Service", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_receipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_receipts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_receiptsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_receipts);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date From:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("To:");

        jLabel4.setText("Total Trans:");

        jLabel7.setText("0");

        jLabel23.setText("Gross Total:");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("0.00");

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Search:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Status:");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Posted");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Finalized");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Location:");

        tf_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch1MouseClicked(evt);
            }
        });
        tf_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch1ActionPerformed(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("All");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Supplier:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("All");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Type:");

        buttonGroup3.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("DR");

        buttonGroup3.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("SI");

        buttonGroup3.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setSelected(true);
        jCheckBox13.setText("All");

        buttonGroup1.add(jCheckBox28);
        jCheckBox28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox28.setText("Deleted");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 578, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 254, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox1)
                                            .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(574, 574, 574)
                                        .addComponent(jCheckBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox11)
                                    .addComponent(jCheckBox12)
                                    .addComponent(jCheckBox13))))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox3)
                                .addComponent(jCheckBox4)
                                .addComponent(jCheckBox28))))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(jLabel24)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Receipt Reports", jPanel2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("State:");

        jProgressBar2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Date From:");

        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setText("All");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("To:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Branch:");

        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("All");
        jCheckBox15.setEnabled(false);

        tf_branch2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch2MouseClicked(evt);
            }
        });
        tf_branch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch2ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Type:");

        buttonGroup5.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox16.setSelected(true);
        jCheckBox16.setText("All");

        buttonGroup5.add(jCheckBox17);
        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setText("DR");

        buttonGroup5.add(jCheckBox18);
        jCheckBox18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox18.setText("SI");

        buttonGroup6.add(jCheckBox19);
        jCheckBox19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox19.setSelected(true);
        jCheckBox19.setText("Finalized");

        buttonGroup6.add(jCheckBox20);
        jCheckBox20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox20.setText("Posted");

        buttonGroup6.add(jCheckBox21);
        jCheckBox21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox21.setText("All");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Status:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jCheckBox22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox22.setSelected(true);
        jCheckBox22.setText("All");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Supplier:");

        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Filter by:");

        jCheckBox23.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(jCheckBox23);
        jCheckBox23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox23.setSelected(true);
        jCheckBox23.setText("[F1]-All");
        jCheckBox23.setFocusable(false);

        jCheckBox24.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(jCheckBox24);
        jCheckBox24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox24.setText("[F2]-Item Code");
        jCheckBox24.setFocusable(false);

        jCheckBox25.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(jCheckBox25);
        jCheckBox25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox25.setText("[F3]-Barcode");
        jCheckBox25.setFocusable(false);

        jCheckBox26.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(jCheckBox26);
        jCheckBox26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox26.setText("[F4]-Description");
        jCheckBox26.setFocusable(false);

        tf_search1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search1ActionPerformed(evt);
            }
        });
        tf_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search1KeyReleased(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Search:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("Location:");

        tf_branch3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch3.setFocusable(false);
        tf_branch3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch3MouseClicked(evt);
            }
        });
        tf_branch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch3ActionPerformed(evt);
            }
        });

        jCheckBox27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox27.setText("Sum up");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jCheckBox23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox26))
                            .addComponent(tf_search1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox14)
                                    .addComponent(jCheckBox15, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_branch2)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_branch3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(jCheckBox22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3))
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckBox16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckBox17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckBox18)
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox19)))
                            .addComponent(jCheckBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 55, Short.MAX_VALUE))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox17)
                                    .addComponent(jCheckBox18)
                                    .addComponent(jCheckBox16)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox20)
                                    .addComponent(jCheckBox19)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_branch3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_branch2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox23)
                            .addComponent(jCheckBox24)
                            .addComponent(jCheckBox25)
                            .addComponent(jCheckBox26))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_search1)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setText("State:");

        jProgressBar3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Items Received", jPanel13);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("Filter by:");

        jCheckBox48.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup12.add(jCheckBox48);
        jCheckBox48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox48.setSelected(true);
        jCheckBox48.setText("[F1]-All");
        jCheckBox48.setFocusable(false);

        jCheckBox49.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup12.add(jCheckBox49);
        jCheckBox49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox49.setText("[F2]-Item Code");
        jCheckBox49.setFocusable(false);

        jCheckBox50.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup12.add(jCheckBox50);
        jCheckBox50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox50.setText("[F3]-Barcode");
        jCheckBox50.setFocusable(false);

        jCheckBox51.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup12.add(jCheckBox51);
        jCheckBox51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox51.setText("[F4]-Description");
        jCheckBox51.setFocusable(false);

        tf_search3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search3ActionPerformed(evt);
            }
        });
        tf_search3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search3KeyReleased(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel61.setText("Search:");

        jButton13.setText("Search");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("Location:");

        jCheckBox52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox52.setText("All");

        tf_branch6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch6MouseClicked(evt);
            }
        });
        tf_branch6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jCheckBox48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox51))
                    .addComponent(tf_search3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_branch6)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_branch6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox52, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox48)
                        .addComponent(jCheckBox49)
                        .addComponent(jCheckBox50)
                        .addComponent(jCheckBox51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_search3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("Status:");

        jProgressBar5.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar5.setRequestFocusEnabled(false);
        jProgressBar5.setString("");
        jProgressBar5.setStringPainted(true);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jProgressBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel59))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Stock Take", jPanel19);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_receiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseClicked
        select_receipts();
    }//GEN-LAST:event_tbl_receiptsMouseClicked

    private void tbl_receiptsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_receiptsMouseEntered

    private void tbl_receiptsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMousePressed
        show_popup(evt);
    }//GEN-LAST:event_tbl_receiptsMousePressed

    private void tbl_receiptsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseReleased
        show_popup(evt);
    }//GEN-LAST:event_tbl_receiptsMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        finalize_receipt();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tf_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch1MouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_branch1MouseClicked

    private void tf_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_branch1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_suppliers2();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_suppliers2();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void tf_branch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch2MouseClicked
        init_branch_locations3();
    }//GEN-LAST:event_tf_branch2MouseClicked

    private void tf_branch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch2ActionPerformed
        init_branch_locations3();
    }//GEN-LAST:event_tf_branch2ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_suppliers3();
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_suppliers3();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        rpt_items_received();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tf_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search1ActionPerformed

    private void tf_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search1KeyReleased

    private void tf_branch3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_branch3MouseClicked

    private void tf_branch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_branch3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        select_add_all_item();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        finalize_receipt();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discountKeyReleased
        compute_discount();
    }//GEN-LAST:event_tf_discountKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update_receipt();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new_post();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_receipt();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_receipt_itemsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receipt_itemsMouseReleased
        popup_queue(evt);
    }//GEN-LAST:event_tbl_receipt_itemsMouseReleased

    private void tbl_receipt_itemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receipt_itemsMousePressed
        popup_queue(evt);
    }//GEN-LAST:event_tbl_receipt_itemsMousePressed

    private void tbl_receipt_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receipt_itemsMouseClicked
        update_queue();
    }//GEN-LAST:event_tbl_receipt_itemsMouseClicked

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased

    }//GEN-LAST:event_tf_searchKeyReleased

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_supplier_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_supplier_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_supplier_idActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        privileges();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        suppliers();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tf_receipt_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_receipt_typeActionPerformed
        init_receipt_types();
    }//GEN-LAST:event_tf_receipt_typeActionPerformed

    private void tf_receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_receipt_noActionPerformed
        init_receipts();
    }//GEN-LAST:event_tf_receipt_noActionPerformed

    private void tf_remarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarksActionPerformed

    }//GEN-LAST:event_tf_remarksActionPerformed

    private void tf_branch_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch_locationActionPerformed
        //        init_branch();
        init_branch_locations();
    }//GEN-LAST:event_tf_branch_locationActionPerformed

    private void tf_branch_locationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch_locationMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_branch_locationMouseClicked

    private void tf_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_supplierActionPerformed
        init_suppliers();
    }//GEN-LAST:event_tf_supplierActionPerformed

    private void tf_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_supplierMouseClicked
        init_suppliers();
    }//GEN-LAST:event_tf_supplierMouseClicked

    private void tf_reference_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reference_noActionPerformed
        init_po_no();
    }//GEN-LAST:event_tf_reference_noActionPerformed

    private void tf_branch4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch4MouseClicked
        init_branch_locations4();
    }//GEN-LAST:event_tf_branch4MouseClicked

    private void tf_branch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch4ActionPerformed
        init_branch_locations4();
    }//GEN-LAST:event_tf_branch4ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        init_suppliers4();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_suppliers4();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        warranty_add_record();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ret_warranty();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jCheckBox29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox29ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        items();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tbl_warrantiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_warrantiesMouseClicked
        select_warranty();
    }//GEN-LAST:event_tbl_warrantiesMouseClicked

    private void jCheckBox32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox32ActionPerformed

    private void tf_branch5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch5MouseClicked
        init_branch_locations5(tf_branch5);
    }//GEN-LAST:event_tf_branch5MouseClicked

    private void tf_branch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch5ActionPerformed
        init_branch_locations5(tf_branch5);
    }//GEN-LAST:event_tf_branch5ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_suppliers5();
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_suppliers5();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        set_report_warranties();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tf_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search2ActionPerformed
        init_inventory_barcodes2();
    }//GEN-LAST:event_tf_search2ActionPerformed

    private void tf_search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search2KeyReleased

    private void tf_search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search3ActionPerformed
        init_inventory_barcodes3();
    }//GEN-LAST:event_tf_search3ActionPerformed

    private void tf_search3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search3KeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        set_stock_take();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void tf_branch6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch6MouseClicked
        init_branch_locations5(tf_branch6);
    }//GEN-LAST:event_tf_branch6MouseClicked

    private void tf_branch6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch6ActionPerformed
        init_branch_locations5(tf_branch6);
    }//GEN-LAST:event_tf_branch6ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox49;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox50;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox52;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JLabel lbl_batch_no;
    private javax.swing.JLabel lbl_gross;
    private javax.swing.JLabel lbl_net;
    private org.jdesktop.swingx.JXTable tbl_receipt_items;
    private javax.swing.JTable tbl_receipts;
    private javax.swing.JTable tbl_warranties;
    private javax.swing.JTextField tf_branch1;
    private javax.swing.JTextField tf_branch2;
    private javax.swing.JTextField tf_branch3;
    private javax.swing.JTextField tf_branch4;
    private javax.swing.JTextField tf_branch5;
    private javax.swing.JTextField tf_branch6;
    private javax.swing.JTextField tf_branch_id;
    private javax.swing.JTextField tf_branch_location;
    private javax.swing.JTextField tf_disc;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_receipt_no;
    private javax.swing.JTextField tf_receipt_no1;
    private javax.swing.JTextField tf_receipt_no2;
    private javax.swing.JTextField tf_receipt_no3;
    private javax.swing.JTextField tf_receipt_no4;
    private javax.swing.JTextField tf_receipt_type;
    private javax.swing.JTextField tf_receipt_type_id;
    private javax.swing.JTextField tf_reference_no;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_search1;
    private javax.swing.JTextField tf_search2;
    private javax.swing.JTextField tf_search3;
    private javax.swing.JTextField tf_supplier;
    private javax.swing.JTextField tf_supplier_id;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_password", "password");
//        MyUser.setUser_id("1");

        tf_search.grabFocus();
        set_default_branch();
        focus();
        init_key();
        hover();
        search();
        init();
        init_receipt_no();
        init_tbl_receipt_items();
        init_tbl_receipts();
//        init_tbl_warranty_items(jTable1);
        init_tbl_warranties(tbl_warranties);
        select_type();

        set_date();
        set_d();
        add_my_barcode();
        item_ledger();
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        branch_location_list2 = branch_location_list;

        jLabel18.setVisible(false);
        tf_receipt_no1.setVisible(false);
        tf_receipt_no2.setVisible(false);
        jLabel21.setVisible(false);
        tf_receipt_no3.setVisible(false);
        tf_receipt_no4.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);

        tf_receipt_type_id.setVisible(false);
        tf_supplier_id.setVisible(false);
        tf_branch_id.setVisible(false);

        jLabel22.setVisible(false);
        lbl_batch_no.setVisible(false);
        jLabel10.setVisible(false);
        tf_receipt_type.setVisible(false);
        jLabel10.setVisible(false);

        jLabel14.setVisible(false);
        tf_reference_no.setVisible(false);
        jPanel22.setVisible(false);
//        jButton7.setVisible(false);
//        jButton8.setVisible(false);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                data_cols();
                tf_receipt_no.grabFocus();

            }
        });

    }

    private void item_ledger() {

    }
    String location_ids = "";
    List<S1_branch_locations.to_branch_locations> branch_locations = new ArrayList();

    private void set_default_branch() {

        List<Inventory_location_privileges.to_inventory_location_privileges> datas = Inventory_location_privileges.ret_data(" where user_id='" + MyUser.getUser_id() + "'");

        if (!datas.isEmpty()) {
            Inventory_location_privileges.to_inventory_location_privileges to = (Inventory_location_privileges.to_inventory_location_privileges) datas.get(0);

            Field.Combo combo = (Field.Combo) tf_branch_location;
            Field.Combo tf_rp_location = (Field.Combo) tf_branch1;

            location_ids = "" + to.location_id;
            my_location_id = "" + to.id;
            tf_receipt_no1.setText(to.branch);
            tf_receipt_no2.setText(to.branch_id);
            tf_receipt_no3.setText(to.location);
            tf_receipt_no4.setText("" + to.location_id);
            combo.setText(to.location + " - [" + to.branch + "]");
            combo.setId("" + to.location_id);
            tf_branch_id.setText("" + to.location_id);
            tf_rp_location.setText(to.location + " - [" + to.branch + "]");
            tf_rp_location.setId("" + to.location_id);

            Field.Combo tf_ir_branch = (Field.Combo) tf_branch2;
            Field.Combo tf_ir_location = (Field.Combo) tf_branch3;
            Field.Combo tf_location_warranty = (Field.Combo) tf_branch4;
            Field.Combo tf_location_warranty2 = (Field.Combo) tf_branch5;
            Field.Combo tf_location_warranty3 = (Field.Combo) tf_branch6;
            tf_ir_branch.setText(to.branch);
            tf_ir_branch.setId("" + to.branch_id);
            tf_ir_location.setText(to.location);
            tf_ir_location.setId("" + to.location_id);

            tf_location_warranty.setText(to.location);
            tf_location_warranty.setId("" + to.location_id);

            tf_location_warranty2.setText(to.location);
            tf_location_warranty2.setId("" + to.location_id);

            tf_location_warranty3.setText(to.location);
            tf_location_warranty3.setId("" + to.location_id);
        }

    }

    private void add_my_barcode() {
//        Dlg_barcodes dlg = new Dlg_barcodes();
//        jPanel9.setLayout(new BorderLayout());
//        jPanel9.add(dlg.getSurface());
    }

    private void add_my_report() {
//        Dlg_report_receip_items_by_supplier dlg = new Dlg_report_receip_items_by_supplier();
//        jPanel5.setLayout(new BorderLayout());
//        jPanel5.add(dlg.getSurface());
    }

    private void set_d() {

    }

    private void set_date() {

    }

    private void init_po_number() {
        String aw = Receipts.increment_id(my_location_id);
        tf_receipt_no.setText(aw);

    }

    private void select_type() {
        String receipt_type_id = tf_receipt_type_id.getText();
        if (receipt_type_id.equals("2")) {
            tf_reference_no.enable(true);
            tf_reference_no.grabFocus();
        } else {
            tf_reference_no.enable(false);
            tf_reference_no.setText("");
            tf_supplier.grabFocus();
            tbl_receipt_items_ALM.clear();
            tbl_receipt_items_M.fireTableDataChanged();
            compute();
        }
    }

    private void init_po_no() {
        String search = tf_reference_no.getText();
        String where = " where puchase_order_no like '%" + search + "%' and status=1";
        List<Purchase_order.to_purchase_orders> datas = Purchase_order.ret_data(where);
        Object[][] obj = new Object[datas.size()][6];
        int i = 0;
        for (Purchase_order.to_purchase_orders to : datas) {
            obj[i][0] = to.puchase_order_no;
            i++;
        }
        JLabel[] labels = {};
        int wid = tf_reference_no.getWidth();
        int[] tbl_widths_customers = {wid};
        String[] colNames = {"PO No."};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_reference_no, obj, labels, tbl_widths_customers, colNames);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                String[] output = data.output;
                tf_reference_no.setText(output[0]);
                select_po(output[0]);
            }
        });
    }

    private void select_po(String po_no) {
        List<to_receipt_items> acc = new ArrayList();
        String where = " where po_no='" + po_no + "'";
        List<Purchase_order_item.to_purchase_order_items> datas = Purchase_order_item.ret_data(where);
        for (Purchase_order_item.to_purchase_order_items to : datas) {
            int id = to.id;
            String receipt_no = tf_receipt_no.getText();
            String user_name = Users.user_name;
            String session_no = Users.session_no;
            String date_added = DateType.datetime.format(new Date());
            String supplier = tf_supplier.getText();
            String supllier_id = "0";
            String remarks = tf_remarks.getText();
            String barcode = to.barcode;
            String description = to.description;
            double qty = to.qty_received;
            double cost = to.new_cost;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_class = to.sub_class;
            String sub_class_id = to.sub_class_id;
            double total = qty * cost;
            double conversion = to.conversion;
            String unit = to.unit;
            String barcodes = "";
            String serial_no = "";
            String batch_no = lbl_batch_no.getText();
            String main_barcode = to.main_barcode;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            double previous_cost = to.previous_cost;
            String branch = to.branch;
            String branch_id = to.branch_id;
            String location = to.location;
            String location_id = to.location_id;
            int status = 0;
            to_receipt_items t = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, conversion, unit, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id, status, false);
            acc.add(t);
        }

        loadData_receipt_items(acc);
        compute();
    }

    private void compute() {
        double discount = FitIn.toDouble(tf_disc.getText());
        double total = 0;
        List<to_receipt_items> acc = tbl_receipt_items_ALM;
        for (to_receipt_items to : acc) {
            total += to.total;
        }

        DecimalFormat df1 = new DecimalFormat("#,###,##0.00000000");
        String pool_db = System.getProperty("pool_db", "db_algorithm");
        if (pool_db.equalsIgnoreCase("db_smis_dumaguete_angel_buns")) {
            lbl_gross.setText(df1.format(total));
            lbl_net.setText(df1.format(total - discount));
        } else {
            lbl_gross.setText(FitIn.fmt_wc_0(total));
            lbl_net.setText(FitIn.fmt_wc_0(total - discount));
        }
    }

    private void focus() {
        tf_receipt_type_id.enable(false);
        JTextField[] tf = {tf_search, tf_reference_no, tf_supplier, tf_branch_location, tf_remarks, tf_receipt_no, tf_receipt_type, jTextField1, tf_disc};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    // <editor-fold defaultstate="collapsed" desc="settings">
    private void hover() {
    }
    int posX = 0, posY = 0;

    private void init() {
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

    private void search() {

    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 20));
    }

    private void exit2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(153, 153, 153));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    // </editor-fold>

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
                              disposed();
                          }
                      });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_CONTROL, new KeyAction() {

                          @Override
                          public void actionPerformed(ActionEvent e) {
                              jButton1.doClick();
                          }
                      });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F5, new KeyAction() {

                          @Override
                          public void actionPerformed(ActionEvent e) {
                              jButton2.doClick();
                          }
                      });

        tbl_receipt_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    edit_items();
                }
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    delete_items();
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    add_receipt();
                }
            }
        });
        tf_search.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    jCheckBox6.setSelected(true);
                }

                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    jCheckBox7.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    jCheckBox8.setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    jCheckBox9.setSelected(true);
                }
            }
        });
    }
    // </editor-fold>

    private ArrayListModel tbl_receipt_items_ALM;
    private Tblreceipt_itemsModel tbl_receipt_items_M;

    private void init_tbl_receipt_items() {
        tbl_receipt_items_ALM = new ArrayListModel();
        tbl_receipt_items_M = new Tblreceipt_itemsModel(tbl_receipt_items_ALM);
        tbl_receipt_items.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        tbl_receipt_items.setModel(tbl_receipt_items_M);
        tbl_receipt_items.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_items.setRowHeight(25);
        int[] tbl_widths_receipt_items = {70, 120, 100, 70, 80, 100, 100, 50, 50, 50, 30, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipt_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_receipt_items, i, tbl_widths_receipt_items[i]);
        }
        Dimension d = tbl_receipt_items.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_receipt_items.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_receipt_items.setRowHeight(25);
        tbl_receipt_items.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 6);

    }

    private void loadData_receipt_items(List<to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);
    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Unit", "Conversion", "Cost", "Total", "", "", "", "", "Cost", "category", "category_id", "classification", "classification_id", "sub_class", "Total"
        };

        public Tblreceipt_itemsModel(ListModel listmodel) {
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
            to_receipt_items tt = (to_receipt_items) getRow(row);
            DecimalFormat df1 = new DecimalFormat("#,###,##0.000000000");
            final String pool_db = System.getProperty("pool_db", "db_algorithm");
            switch (col) {
                case 0:

                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    String uom = tt.unit;
                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }

                    unit = unit.replaceAll("#", "/");
                    return " " + unit;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.conversion);
                case 5:

                    if (pool_db.equalsIgnoreCase("db_smis_dumaguete_angel_buns")) {
                        return " " + df1.format(tt.cost) + " ";
                    } else {
                        return FitIn.fmt_wc_0(tt.cost) + " ";
                    }

                case 6:

                    if (pool_db.equalsIgnoreCase("db_smis_dumaguete_angel_buns")) {
                        return " " + df1.format(tt.cost * tt.qty) + " ";
                    } else {
                        return FitIn.fmt_wc_0(tt.cost * tt.qty) + " ";
                    }

                case 7:
                    return " Update";
                case 8:
                    return " Delete";
                case 9:
                    if (tt.status == 0 && tt.id == -1) {
                        return " ";
                    } else if (tt.status == 1) {
                        return " Finalized";
                    } else if (tt.status == 0 && tt.id != -1) {
                        return " Posted";
                    } else {
                        return " Deleted";
                    }
                case 10:
                    return tt.selected;
                case 11:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
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
                default:
                    return FitIn.fmt_wc_0(tt.qty * tt.cost);
            }
        }
    }

    private void data_cols_items() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        Receipt_service_centers.to_receipts to = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        String where = " where receipt_no='" + to.receipt_no + "'";
        List<Receipts_service_center_items.to_receipt_items> datas = Receipts_service_center_items.ret_data5(where);

        List<to_receipt_items> datas2 = new ArrayList();
        for (Receipts_service_center_items.to_receipt_items rec : datas) {
            int id = rec.id;
            String receipt_no = rec.receipt_no;
            String user_name = rec.user_name;
            String session_no = rec.session_no;
            String date_added = rec.date_added;
            String supplier = rec.supplier;
            String supllier_id = rec.supllier_id;
            String remarks = rec.remarks;
            String barcode = rec.barcode;
            String description = rec.description;
            double qty = rec.qty;
            double cost = rec.cost;
            String category = rec.category;
            String category_id = rec.category_id;
            String classification = rec.classification;
            String classification_id = rec.classification_id;
            String sub_class = rec.sub_class;
            String sub_class_id = rec.sub_class_id;
            double total = qty * cost;
            double conversion = rec.conversion;
            String unit = rec.unit;
            String barcodes = rec.barcodes;
            String serial_nos = rec.serial_no;
            String batch_no = rec.batch_no;
            String main_barcode = rec.main_barcode;
            String brand = rec.brand;
            String brand_id = rec.brand_id;
            String model = rec.model;
            String model_id = rec.model_id;
            double previous_cost = rec.previous_cost;
            String branch = rec.branch;
            String branch_id = rec.branch_id;
            String location = rec.location;
            String location_id = rec.location_id;
            int status = rec.status;
            to_receipt_items d = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, conversion, unit, barcodes, serial_nos, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id, status, false);
            datas2.add(d);
        }
        loadData_receipt_items(datas2);
    }

    private void add_items() {
        final List<to_receipt_items> datas = tbl_receipt_items_ALM;
        final List<to_receipt_items> acc = new ArrayList();
        acc.addAll(datas);
        Field.Combo location = (Field.Combo) tf_branch_location;
        final Inventory.to_inventory to = inventory_barcoders_list.get(selected_row);
        Window p = (Window) this;
        Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
        nd.setTitle("");
        nd.do_pass3(0, to.cost, to.description, to.unit, to.barcode, to.barcode, to.product_qty, to.barcode, location.getId());
        nd.setCallback(new Dlg_qty_cost.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                closeDialog.ok();
                int id = -1;
                String receipt_no = "0";//S1_re.increment_id();
                String user_name = Users.user_name;
                String session_no = Users.session_no;
                String date_added = DateType.datetime.format(new Date());
                String supplier = to.supplier;
                String supllier_id = "0";
                String remarks = tf_remarks.getText();
                String barcode = to.barcode;
                String description = to.description;
                double qty = data.amount;
                double cost = data.cost;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_class = to.sub_classification;
                String sub_class_id = to.sub_classification_id;
                double total = qty * cost;
                String barcodes = data.barcodes;
                String serial_no = data.serial_nos;
                String batch_no = lbl_batch_no.getText();
                String main_barcode = to.barcode;
                String brand = to.brand;
                String brand_id = to.brand_id;
                String model = to.model;
                String model_id = to.model_id;
                double previous_cost = to.cost;
                String receipt_type_id = "";
                String branch = to.branch;
                String branch_id = to.branch_code;
                String location = to.location;
                String location_id = to.location_id;
                String date_delivered = DateType.sf.format(jDateChooser5.getDate());
                String date_received = DateType.sf.format(jDateChooser6.getDate());
//                date_received = DateType.convert_monthDate_sf(date_received);

                double conversion = data.conversion;
                String unit = data.unit;
//                System.out.println("unit: " + unit);
                int status = 0;
                to_receipt_items to2 = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, conversion, unit, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id, status, false);
                int naa = 0;
                for (to_receipt_items to3 : datas) {
                    if (to3.barcode.equals(to2.barcode) && to3.unit.
                            equals(to2.unit) && to3.main_barcode.
                            equals(to2.main_barcode)) {
                        naa = 1;
                        double n_qty = data.amount + to3.qty;
                        to3.setQty(n_qty);
                        to3.setCost(cost);
                        String serials = to3.serial_nos;
                        if (!to2.serial_nos.isEmpty()) {
                            serials = to3.serial_nos + "\n" + to2.serial_nos;
                        }
                        to3.setSerial_nos(serials);
                        tbl_receipt_items_M.fireTableDataChanged();
                        break;
                    } else {
                        naa = 0;
                    }
                }
                if (naa == 0) {
                    if (jButton1.isEnabled()) {
                        acc.add(to2);
                        loadData_receipt_items(acc);
                    } else {
                        int row = tbl_receipts.getSelectedRow();
                        if (row < 0) {
                            return;
                        }
                        Receipt_service_centers.to_receipts too = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
                        List<Receipts_service_center_items.to_receipt_items> d = new ArrayList();
                        String sup = supplier;
                        String sup_id = supllier_id;

                        Receipts_service_center_items.to_receipt_items to4 = new Receipts_service_center_items.to_receipt_items(id, receipt_no, user_name, session_no, date_added, sup, sup_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, to.conversion, to.unit, date_delivered, date_received, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, location, location_id, location, location_id);
                        d.add(to4);
                        Receipts_service_center_items.add_receipt_items(d, too.receipt_no);
                        data_cols_items();
                        compute();
                    }
                }

                tf_search.grabFocus();
                tf_search.selectAll();
                compute();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void delete_items() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_receipt_items_ALM.remove(row);
        tbl_receipt_items_M.fireTableDataChanged();
        tf_search.grabFocus();
        tf_search.selectAll();
    }

    private void edit_items() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_receipt_items to = (to_receipt_items) tbl_receipt_items_ALM.
                get(tbl_receipt_items.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.qty, to.cost, to.description, to.unit, to.barcode, to.barcodes, to.barcodes, to.serial_nos, 0, to.main_barcode);
        nd.setCallback(new Dlg_qty_cost.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                closeDialog.ok();
                double n_qty = data.amount;
                to.setQty(n_qty);
                to.setSerial_nos(data.serial_nos);
                tbl_receipt_items_M.fireTableDataChanged();
                tf_search.grabFocus();
                tf_search.selectAll();
                compute();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void add_receipt() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Receipts Service - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        if (tbl_receipt_items_ALM.isEmpty()) {
            Alert.set(0, "NO RECORD");
            return;
        }
        Field.Combo combo = (Field.Combo) tf_branch_location;
        int id = -1;
        String aw = Receipt_service_centers.increment_id(combo.getId());
        String receipt_no = aw;
        String where = " where receipt_no='" + receipt_no + "' ";
        List<Receipt_service_centers.to_receipts> datas2 = Receipt_service_centers.ret_data3(where);
        if (!datas2.isEmpty()) {
            Alert.set(0, "Transaction No. Already Exist,");
            return;
        }
        String user_name = Users.user_name;
        String session_no = Users.session_no;
        String date_added = DateType.datetime.format(new Date());
        String supplier = tf_supplier.getText();
        String supllier_id = tf_supplier_id.getText();
        if (supplier.isEmpty() || supllier_id.isEmpty()) {
            Alert.set(0, "Choose Supplier!");
            tf_supplier.grabFocus();
            return;
        }
        final String remarks = tf_remarks.getText();
        String date_delivered = DateType.sf.format(jDateChooser5.getDate());
        String date_received = DateType.sf.format(jDateChooser6.getDate());
//        date_received = DateType.convert_monthDate_sf(date_received);
        String receipt_type = tf_receipt_type.getText();
        String reference_no = tf_reference_no.getText();
        String branch = combo.getText();
        String branch_id = combo.getId();
        double gross_total = FitIn.toDouble(lbl_gross.getText());
        double net_total = FitIn.toDouble(lbl_net.getText());
        String batch_no = "0";
        double discount = FitIn.toDouble(tf_disc.getText());
        String receipt_type_id = tf_receipt_type_id.getText();
        final Receipt_service_centers.to_receipts to1 = new Receipt_service_centers.to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, 0);

        List<S1_receipt_orders.to_receipt_items> datas = tbl_receipt_items_ALM;
        final List<Receipts_service_center_items.to_receipt_items> acc = new ArrayList();
        for (S1_receipt_orders.to_receipt_items to3 : datas) {
            String barcode = to3.barcode;
            String description = to3.description;
            double qty = to3.qty;
            double cost = to3.cost;
            String category = to3.category;
            String category_id = to3.category_id;
            String classification = to3.classification;
            String classification_id = to3.classification_id;
            String sub_class = to3.sub_class;
            String sub_class_id = to3.sub_class_id;
            String sup = supplier;
            String sup_id = supllier_id;
            String barcodes = to3.barcodes;
            String serial_no = to3.serial_nos;
            String main_barcode = to3.main_barcode;
            String brand = to3.brand;
            String brand_id = to3.brand_id;
            String model = to3.model;
            String model_id = to3.model_id;
            int status = 0;
            double previous_cost = to3.previous_cost;
            String location = combo.getText();
            String location_id = combo.getId();
            Receipts_service_center_items.to_receipt_items to4 = new Receipts_service_center_items.to_receipt_items(id, receipt_no, user_name, session_no, date_added, sup, sup_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, to3.conversion, to3.unit, date_delivered, date_received, barcodes, serial_no, batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id, location, location_id);
            acc.add(to4);
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Continue posting transaction?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Receipt_service_centers.add_receipts(to1, acc);
                tbl_receipt_items_ALM.clear();
                tbl_receipt_items_M.fireTableDataChanged();
                Alert.set(1, remarks);
                tf_search.grabFocus();
                tf_search.selectAll();
                init_receipt_no();
                compute();
                data_cols();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void init_receipt_no() {
        Field.Combo combo = (Field.Combo) tf_branch_location;
        String aw = Receipts.increment_id(combo.getId());
        String receipt_no = aw;
        tf_receipt_no.setText(receipt_no);
//        System.out.println("Location Id: " + combo.getId());
//        System.out.println("Transaction No.: " + receipt_no);

    }

    List<Suppliers.to_suppliers> supplier_list = new ArrayList();

    private void init_suppliers() {
        String search = tf_supplier.getText();
        supplier_list.clear();
        supplier_list = Suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list.size()][2];
        int i = 0;
        for (Suppliers.to_suppliers to : supplier_list) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 350};
        String[] col_names = {"ID", "NAME"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_supplier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Suppliers.to_suppliers to = supplier_list.
                        get(data.selected_row);
                tf_supplier.setText(to.customer_name);
                tf_supplier_id.setText(to.customer_no);
                tf_branch_location.grabFocus();
            }
        });
    }

    List<Suppliers.to_suppliers> supplier_list2 = new ArrayList();

    private void init_suppliers2() {
        String search = jTextField2.getText();
        supplier_list2.clear();
        supplier_list2 = Suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list2.size()][2];
        int i = 0;
        for (Suppliers.to_suppliers to : supplier_list2) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 350};
        String[] col_names = {"ID", "NAME"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField2, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo supp = (Field.Combo) jTextField2;
                Suppliers.to_suppliers to = supplier_list2.
                        get(data.selected_row);
                supp.setText(to.customer_name);
                supp.setId(to.customer_no);

            }
        });
    }
    List<Suppliers.to_suppliers> supplier_list3 = new ArrayList();

    private void init_suppliers3() {
        if (!jCheckBox22.isSelected()) {
            String search = jTextField3.getText();
            supplier_list3.clear();
            supplier_list3 = Suppliers.ret_data(search);
            Object[][] obj = new Object[supplier_list3.size()][2];
            int i = 0;
            for (Suppliers.to_suppliers to : supplier_list3) {
                obj[i][0] = " " + to.customer_no;
                obj[i][1] = " " + to.customer_name;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {50, 350};
            String[] col_names = {"ID", "NAME"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(jTextField3, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Field.Combo supp = (Field.Combo) jTextField3;
                    Suppliers.to_suppliers to = supplier_list3.
                            get(data.selected_row);
                    supp.setText(to.customer_name);
                    supp.setId(to.customer_no);

                }
            });
        }

    }

    List<Suppliers.to_suppliers> supplier_list4 = new ArrayList();

    private void init_suppliers4() {
        String search = jTextField4.getText();
        supplier_list4.clear();
        supplier_list4 = Suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list4.size()][2];
        int i = 0;
        for (Suppliers.to_suppliers to : supplier_list4) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 350};
        String[] col_names = {"ID", "NAME"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField4, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Suppliers.to_suppliers to = supplier_list4.
                        get(data.selected_row);
                Field.Combo supp = (Field.Combo) jTextField4;
                supp.setText(to.customer_name);
                supp.setId(to.customer_no);

            }
        });
    }

    List<Suppliers.to_suppliers> supplier_list5 = new ArrayList();

    private void init_suppliers5() {
        String search = jTextField5.getText();
        supplier_list5.clear();
        supplier_list5 = Suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list5.size()][2];
        int i = 0;
        for (Suppliers.to_suppliers to : supplier_list5) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 350};
        String[] col_names = {"ID", "NAME"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField5, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Suppliers.to_suppliers to = supplier_list5.
                        get(data.selected_row);
                Field.Combo supp = (Field.Combo) jTextField5;
                supp.setText(to.customer_name);
                supp.setId(to.customer_no);

            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();
    List<S1_branch_locations.to_branch_locations> branch_location_list2 = new ArrayList();
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void init_branch_locations() {
//        if(!jButton1.isEnabled()){
//            return;
//        }
        if (!tf_branch_location.isEnabled()) {
            return;
        }
        String search = tf_branch_location.getText();
        String branch_id = tf_receipt_no2.getText();

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 100};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_branch_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {

                S1_branch_locations.to_branch_locations to1 = branch_location_list.get(data.selected_row);

                String where = " where user_id='" + MyUser.getUser_id() + "' and location_id='" + to1.id + "' ";

                List<Inventory_location_privileges.to_inventory_location_privileges> datas = Inventory_location_privileges.ret_data(where);
                if (datas.isEmpty()) {
                    Alert.set(0, "Privilege not found!");
                    jTextField2.grabFocus();
                    return;
                }

                Field.Combo combo = (Field.Combo) tf_branch_location;

                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);

                combo.setText(to.location + " - [" + to.branch + "]");
                combo.setId("" + to.id);
//                System.out.println("Location Id: " + combo.getId());
                tf_branch_id.setText("" + to.id);
                my_branch = to.branch;
                my_branch_id = to.branch_id;
                my_location = to.location;
                my_location_id = "" + to.id;
                tf_remarks.grabFocus();
                location_ids = "" + to.id;
                init_receipt_no();
            }
        });
    }

    private void init_branch_locations2() {
        final Field.Combo tf_rp_location = (Field.Combo) tf_branch1;

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 100};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_rp_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_rp_location.setText(to.location + " - [" + to.branch + "]");
                tf_rp_location.setId("" + to.id);
            }
        });
    }

    private void init_branch_locations3() {
        final Field.Combo tf_rp_branch = (Field.Combo) tf_branch2;
        final Field.Combo tf_rp_location = (Field.Combo) tf_branch3;

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 100};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_branch2, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_rp_branch.setText(to.branch);
                tf_rp_branch.setId("" + to.branch_id);

                tf_rp_location.setText(to.location);
                tf_rp_location.setId("" + to.id);
            }
        });
    }

    private void init_branch_locations4() {
        final Field.Combo tf_rp_location = (Field.Combo) tf_branch4;

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 100};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_rp_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_rp_location.setText(to.location + " - [" + to.branch + "]");
                tf_rp_location.setId("" + to.id);
            }
        });
    }

    private void init_branch_locations5(JTextField tf) {
        final Field.Combo tf_rp_location = (Field.Combo) tf;

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = " " + to.location;//TextHighlighter1.highlight2(to.description, to.description, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 100};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_rp_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_rp_location.setText(to.location + " - [" + to.branch + "]");
                tf_rp_location.setId("" + to.id);
            }
        });
    }

    List<Inventory.to_inventory> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {

        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        tf_search.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                final Field.Combo location = (Field.Combo) tf_branch_location;
                String where = " where ";
                if (jCheckBox6.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location.getId() + "'  and location not like '' "
                            + " or barcode like '" + search + "' and location_id='" + location.getId() + "' and location not like ''  "
                            + " or description like '%" + search + "%' and location_id='" + location.getId() + "' and location not like '' ";
                }
                if (jCheckBox7.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location.getId() + "' and location not like ''  "
                            + "  ";
                }
                if (jCheckBox8.isSelected()) {
                    where = where + " "
                            + "  barcode like '" + search + "' and location_id='" + location.getId() + "' and location not like '' ";
                }
                if (jCheckBox9.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + location.getId() + "' and location not like '' ";
                }
                where = where + " order by description asc ";
//                System.out.println(where);
                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory.ret_data6(where);

                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item not found!");
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                    return;
                }
                if (inventory_barcoders_list.size() == 1) {
                    selected_row = 0;
                    add_items();
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
                    int i = 0;
                    for (Inventory.to_inventory to : inventory_barcoders_list) {
                        obj[i][0] = " ";
                        obj[i][1] = " " + to.barcode;
                        obj[i][2] = " " + to.description;
                        String unit = "";
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                        if (uoms != null) {
                            unit = uoms.uom;
                        }

                        unit = unit.replaceAll("#", "/");
                        obj[i][3] = " " + unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.cost);
                        obj[i][5] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 100, w, 30, 50, 50};
                    String[] col_names = {"Qty", "ItemCode", "Description", "Unit", "Cost", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            selected_row = data.selected_row;
                            add_items();
                            tf_search.setEnabled(true);
                            tf_search.grabFocus();
                        }
                    });
                }
                tf_search.setEnabled(true);
            }
        });
        t.start();
    }

    private void update_barcode() {
        Window p = (Window) this;
        Dlg_inventory_update_barcode nd = Dlg_inventory_update_barcode.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_update_barcode.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_update_barcode.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(jScrollPane3);
        nd.setVisible(true);
    }

    int selected_row = -1;

    private void compute_discount() {
        double total_gross = FitIn.toDouble(lbl_gross.getText());
        double discount = FitIn.toDouble(tf_discount.getText());
        double net = total_gross - discount;
        lbl_net.setText(FitIn.fmt_wc_0(net));
    }

    private void add_barcode() {
        Window p = (Window) this;
        Dlg_barcodes nd = Dlg_barcodes.create(p, true);
        nd.setTitle("");
        nd.do_pass(tf_search.getText());
        nd.setCallback(new Dlg_barcodes.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_barcodes.OutputData data) {
                closeDialog.ok();
                tf_search.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<Receipt_service_centers.to_receipts> receipt_list = new ArrayList();

    private void init_receipts() {
        String search = tf_receipt_no.getText();
        receipt_list.clear();
        receipt_list = Receipt_service_centers.ret_data(search);
        if (receipt_list.isEmpty()) {
            tf_receipt_type.grabFocus();
        } else {
            Object[][] obj = new Object[receipt_list.size()][1];
            int i = 0;
            for (Receipt_service_centers.to_receipts to : receipt_list) {
                obj[i][0] = " " + to.receipt_no;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {200};
            int width = 0;
            String[] col_names = {"Transaction #"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup(tf_receipt_no, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    Receipt_service_centers.to_receipts to = receipt_list.
                            get(data.selected_row);
                    Receipt_service_centers.to_receipts t = receipt_list.get(data.selected_row);
                    tf_receipt_no.setText(t.receipt_no);
                    tf_receipt_no.setEnabled(false);
                    select_transaction();
                }
            });
        }

    }

    private void select_transaction() {

        String where2 = " where receipt_no = '" + tf_receipt_no.getText() + "' ";
        Receipt_service_centers.to_receipts to = Receipt_service_centers.to(where2);
        tf_receipt_no.setText(to.receipt_no);
        tf_receipt_type.setText(to.receipt_type);
        tf_receipt_type_id.setText(to.receipt_type_id);

        tf_supplier.setText(to.supplier);
        tf_supplier_id.setText(to.supllier_id);
        tf_branch_location.setText(to.branch);
        tf_branch_id.setText(to.branch_id);
        tf_remarks.setText(to.remarks);
        tf_disc.setText(FitIn.fmt_wc_0(to.discount));
        tf_discount.setText(FitIn.fmt_wc_0(to.discount));

        try {
            Date delivered = DateType.sf.parse(to.date_delivered);
            jDateChooser5.setDate(delivered);

            Date received = DateType.sf.parse(to.date_received);
            jDateChooser6.setDate(received);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_warranty_service.class.getName()).log(Level.SEVERE, null, ex);
        }
        tf_reference_no.setText(to.reference_no);

        String where = " where receipt_no='" + to.receipt_no + "'";
        List<Receipts_service_center_items.to_receipt_items> datas = Receipts_service_center_items.ret_data5(where);

        double total1 = 0;
        for (Receipts_service_center_items.to_receipt_items t : datas) {
            total1 += t.qty * t.cost;
        }
        lbl_gross.setText(FitIn.fmt_wc_0(total1));
        lbl_net.setText(FitIn.fmt_wc_0(total1 - to.discount));

        jTabbedPane1.setSelectedIndex(0);
        jButton1.setEnabled(false);
        jButton3.setEnabled(true);

        if (to.status == 0) {
            jButton6.setEnabled(true);
        } else {
            jButton6.setEnabled(false);
        }

        List<to_receipt_items> datas2 = new ArrayList();
        for (Receipts_service_center_items.to_receipt_items rec : datas) {
            int id = rec.id;
            String receipt_no = rec.receipt_no;
            String user_name = rec.user_name;
            String session_no = rec.session_no;
            String date_added = rec.date_added;
            String supplier = rec.supplier;
            String supllier_id = rec.supllier_id;
            String remarks = rec.remarks;
            String barcode = rec.barcode;
            String description = rec.description;
            double qty = rec.qty;
            double cost = rec.cost;
            String category = rec.category;
            String category_id = rec.category_id;
            String classification = rec.classification;
            String classification_id = rec.classification_id;
            String sub_class = rec.sub_class;
            String sub_class_id = rec.sub_class_id;
            double total = qty * cost;
            double conversion = rec.conversion;
            String unit = rec.unit;
            String barcodes = rec.barcodes;
            String serial_nos = rec.serial_no;
            String batch_no = rec.batch_no;
            String main_barcode = rec.main_barcode;
            String brand = rec.brand;
            String brand_id = rec.brand_id;
            String model = rec.model;
            String model_id = rec.model_id;
            double previous_cost = rec.previous_cost;
            String branch = rec.branch;
            String branch_id = rec.branch_id;
            String location = rec.location;
            String location_id = rec.location_id;
            int status = rec.status;
            to_receipt_items d = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, conversion, unit, barcodes, serial_nos, batch_no, main_barcode, brand, brand_id, model, model_id, previous_cost, branch, branch_id, location, location_id, status, false);
            datas2.add(d);
        }

        loadData_receipt_items(datas2);
        tf_receipt_no.setEnabled(true);
    }
    List<Courier.status> receipt_type_list = new ArrayList();

    private void init_receipt_types() {
        String search = tf_receipt_type.getText();
        receipt_type_list.clear();
        receipt_type_list = Courier.receipt_types();
        Object[][] obj = new Object[receipt_type_list.size()][1];
        int i = 0;
        for (Courier.status to : receipt_type_list) {
            obj[i][0] = to.status;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {"Tramsaction #"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_receipt_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Courier.status to = receipt_type_list.get(data.selected_row);
                tf_receipt_type_id.setText("" + to.id);
                tf_receipt_type.setText("" + to.status);
                select_type();
            }
        });
    }

    private ArrayListModel tbl_receipts_ALM;
    private TblreceiptsModel tbl_receipts_M;

    private void init_tbl_receipts() {
        tbl_receipts_ALM = new ArrayListModel();
        tbl_receipts_M = new TblreceiptsModel(tbl_receipts_ALM);
        tbl_receipts.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_receipts.setModel(tbl_receipts_M);
        tbl_receipts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipts.setRowHeight(25);
        int[] tbl_widths_receipts = {120, 80, 100, 170, 70, 50, 50, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipts, i, tbl_widths_receipts[i]);
        }
        Dimension d = tbl_receipts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_receipts.getTableHeader().setPreferredSize(d);
        tbl_receipts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_receipts.setRowHeight(25);
        tbl_receipts.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 4);

    }

    private void loadData_receipts(List<Receipt_service_centers.to_receipts> acc) {
        tbl_receipts_ALM.clear();
        tbl_receipts_ALM.addAll(acc);
    }

    public static class TblreceiptsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "Supplier", "Location", "Gross Total", "", "", "", "", "date_received", "receipt_type", "reference_no", "branch", "branch_id", "gross_total", "net_total", "batch_no", "discount", "receipt_type_id"
        };

        public TblreceiptsModel(ListModel listmodel) {
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
            Receipt_service_centers.to_receipts tt = (Receipt_service_centers.to_receipts) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.receipt_no;
                case 1:
                    return " " + DateType.convert_slash_datetime2(tt.date_received);
                case 2:
                    return " " + tt.supplier;
                case 3:
                    return " " + tt.branch;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.gross_total) + " ";
                case 5:
                    if (tt.status == 0) {
                        return " Posted";
                    } else if (tt.status == 2) {
                        return " Deleted";
                    } else {
                        return " Finalized";
                    }
                case 6:
                    return " Update";
                case 7:
                    return " Delete";
                case 8:
                    return " Print";
                case 9:
                    return tt.date_received;
                case 10:
                    return tt.receipt_type;
                case 11:
                    return tt.reference_no;
                case 12:
                    return tt.branch;
                case 13:
                    return tt.branch_id;
                case 14:
                    return tt.gross_total;
                case 15:
                    return tt.net_total;
                case 16:
                    return tt.batch_no;
                case 17:
                    return tt.discount;
                default:
                    return tt.receipt_type_id;
            }
        }
    }

    private void data_cols() {
        final Field.Combo tf_rp_location = (Field.Combo) tf_branch1;
        Field.Combo supp = (Field.Combo) jTextField2;

        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        String where = " where date(date_added) between '" + date_from + "' and '" + date_to + "' "
                + " and receipt_no like '%" + jTextField1.getText() + "%'  ";

        if (jCheckBox1.isSelected()) {
            where = " where receipt_no like '%" + jTextField1.getText() + "%'  ";
        }
        if (jCheckBox3.isSelected()) {
            where = where + " and status='" + "0" + "' ";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " and status='" + "1" + "' ";
        }
        if (jCheckBox28.isSelected()) {
            where = where + " and status='" + "2" + "' ";
        }

        if (!jCheckBox5.isSelected()) {
            where = where + " and branch_id ='" + tf_rp_location.getId() + "'";
        }
        if (!jCheckBox10.isSelected()) {
            where = where + " and supllier_id='" + supp.getId() + "' ";
        }
        String type = "0";
        if (jCheckBox11.isSelected()) {
            where = where + " and batch_no ='" + "1" + "' ";
        }
        if (jCheckBox12.isSelected()) {
            where = where + " and batch_no<>'" + "1" + "' ";
        }
        where = where + " order by id desc ";
        loadData_receipts(Receipt_service_centers.ret_data4(where));
        jLabel7.setText("" + tbl_receipts_ALM.size());
    }

    private void update_receipt() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Receipts - (Edit)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        Receipt_service_centers.to_receipts to = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Receipt-Status [Finalized]!");
            return;
        }
        if (to.status == 2) {
            Alert.set(0, "Receipt-Status [Deleted]!");
            return;
        }
        int id = to.id;
        String receipt_no = to.receipt_no;
        String user_name = Users.user_name;
        String session_no = Users.session_no;
        String date_added = DateType.datetime.format(new Date());
        String supplier = tf_supplier.getText();
        String supllier_id = tf_supplier_id.getText();
        if (supplier.isEmpty() || supllier_id.isEmpty()) {
            Alert.set(0, "Choose Supplier!");
            tf_supplier.grabFocus();
            return;
        }
        String remarks = tf_remarks.getText();
        String date_delivered = DateType.sf.format(jDateChooser5.getDate());
        String date_received = DateType.sf.format(jDateChooser6.getDate());
//        date_received = DateType.convert_monthDate_sf(date_received);
        String receipt_type = tf_receipt_type.getText();
        String reference_no = tf_reference_no.getText();
        String branch = tf_branch_location.getText();
        String branch_id = tf_branch_id.getText();

        double gross_total = FitIn.toDouble(lbl_gross.getText());
        double net_total = FitIn.toDouble(lbl_net.getText());
        String batch_no = lbl_batch_no.getText();
        double discount = FitIn.toDouble(tf_disc.getText());
        String receipt_type_id = tf_receipt_type_id.getText();
        Receipt_service_centers.to_receipts to1 = new Receipt_service_centers.to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, receipt_type, reference_no, branch, branch_id, gross_total, net_total, batch_no, discount, receipt_type_id, to.status);
        Receipt_service_centers.edit_receipts2(to1);
        Alert.set(2, remarks);
        data_cols();
        tbl_receipts.setRowSelectionInterval(row, row);
    }

    private void select_receipts() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_receipts.getSelectedColumn();
        Receipt_service_centers.to_receipts to = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        tf_receipt_no.setText(to.receipt_no);
        tf_receipt_type.setText(to.receipt_type);
        tf_receipt_type_id.setText(to.receipt_type_id);
        tf_supplier.setText(to.supplier);
        tf_supplier_id.setText(to.supllier_id);
        Field.Combo br = (Field.Combo) tf_branch_location;
        br.setText(to.branch);
        br.setId("" + to.branch_id);

        tf_branch_id.setText(to.branch_id);
        tf_remarks.setText(to.remarks);
        tf_disc.setText(FitIn.fmt_wc_0(to.discount));
        tf_discount.setText(FitIn.fmt_wc_0(to.discount));

        data_cols_items();

        try {
            Date delivered = DateType.sf.parse(to.date_delivered);
            jDateChooser5.setDate(delivered);

            Date received = DateType.sf.parse(to.date_received);
            jDateChooser6.setDate(received);

        } catch (ParseException ex) {
            Logger.getLogger(Dlg_warranty_service.class.getName()).log(Level.SEVERE, null, ex);
        }
        tf_reference_no.setText(to.reference_no);
        List<to_receipt_items> datas = tbl_receipt_items_ALM;
        double total = 0;
        for (to_receipt_items t : datas) {
            total += t.qty * t.cost;
        }
        DecimalFormat df1 = new DecimalFormat("#,###,##0.000000000");
        String pool_db = System.getProperty("pool_db", "db_algorithm");
        if (pool_db.equalsIgnoreCase("db_smis_dumaguete_angel_buns")) {
            lbl_gross.setText(df1.format(total));
            lbl_net.setText(df1.format(total - to.discount));
        } else {
            lbl_gross.setText(FitIn.fmt_wc_0(total));
            lbl_net.setText(FitIn.fmt_wc_0(total - to.discount));
        }
        if (col == 6) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Receipts Service - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            jTabbedPane1.setSelectedIndex(1);
            jButton1.setEnabled(false);
            jButton3.setEnabled(true);
            tf_branch_location.setEnabled(false);

            if (to.status == 0) {
                jButton6.setEnabled(true);
            } else if (to.status == 2) {
                jButton3.setEnabled(false);
                jButton6.setEnabled(false);
            } else {
                jButton6.setEnabled(false);
            }

        }
        if (col == 7) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Receipts - (Delete)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            delete_receipts();
        }
        if (col == 8) {
            set_report();
            jTabbedPane1.setSelectedIndex(2);
        }
    }

    private void delete_receipts() {
        final int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Receipt_service_centers.to_receipts to = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        final String delete_receipts_finalized = System.getProperty("delete_receipts_finalized", "false");
        if (to.status == 2) {
            Alert.set(0, "Receipt status [Deleted]!");
            return;
        }
        if (delete_receipts_finalized.equalsIgnoreCase("false")) {
            if (to.status == 1) {
                Alert.set(0, "Cannot delete finalized transaction!");
                return;
            }
        }

        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                List<S1_receipt_orders.to_receipt_items> items = tbl_receipt_items_ALM;
                if (delete_receipts_finalized.equalsIgnoreCase("true") && to.status == 1) {
                    Receipt_service_centers.delete_receipts2(to, items);
                }

                if (to.status == 1 && delete_receipts_finalized.equalsIgnoreCase("false")) {
                    Alert.set(0, "Receipt-Status [Finalized]!");
                    return;
                }
                if (to.status == 0) {
                    Receipt_service_centers.delete_receipts(to);
                }
                data_cols();
                new_post();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void update_queue() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_receipt_items.getSelectedColumn();
        final to_receipt_items to = (to_receipt_items) tbl_receipt_items_ALM.get(tbl_receipt_items.convertRowIndexToModel(row));

        if (col == 7) {
            if (jButton1.isEnabled()) {
                Window p = (Window) this;
                Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.qty, to.cost, to.description, to.unit, to.barcode, to.barcodes, to.barcodes, to.serial_nos, 0, to.main_barcode);
                nd.setCallback(new Dlg_qty_cost.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                        closeDialog.ok();
                        double n_qty = data.amount;
                        to.setQty(n_qty);
                        to.setCost(data.cost);
                        to.setSerial_nos(data.serial_nos);
                        tbl_receipt_items_M.fireTableDataChanged();
                        tf_search.grabFocus();
                        tf_search.selectAll();
                        compute();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            } else {
                int row2 = tbl_receipts.getSelectedRow();
                if (row2 < 0) {
                    return;
                }
                Receipt_service_centers.to_receipts to2 = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row2));
                if (to2.status == 1) {
                    Alert.set(0, "Receipt-Status [Finalized]!");
                    return;
                }
                if (to2.status == 2) {
                    Alert.set(0, "Receipt-Status [Deleted]!");
                    return;
                }
                Window p = (Window) this;
                Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.qty, to.cost, to.description, to.unit, to.barcode, to.barcodes, to.barcodes, to.serial_nos, 0, to.main_barcode);
                nd.setCallback(new Dlg_qty_cost.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                        closeDialog.ok();
                        S1_receipt_items.edit_receipt_items2("" + to.id, data.amount, data.cost, data.serial_nos);
                        data_cols_items();
                        compute();
                        double gross_amount = FitIn.toDouble(lbl_gross.getText());
                        Receipt_service_centers.update_gross(to.receipt_no, gross_amount);
                        int row = tbl_receipts.getSelectedRow();
                        if (row < 0) {
                            return;
                        }
                        data_cols();
                        compute();
                        tbl_receipts.setRowSelectionInterval(row, row);

                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
        if (col == 8) {
            if (jButton1.isEnabled()) {
                tbl_receipt_items_ALM.remove(row);
                tbl_receipt_items_M.fireTableDataChanged();
                compute();
            } else {
                int row2 = tbl_receipts.getSelectedRow();
                if (row2 < 0) {
                    return;
                }
                Receipt_service_centers.to_receipts to2 = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row2));
                if (to2.status == 1) {
                    Alert.set(0, "Receipt-Status [Finalized]!");
                    return;
                }
                if (to2.status == 2) {
                    Alert.set(0, "Receipt-Status [Deleted]!");
                    return;
                }
                Window p = (Window) this;
                Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_confirm_delete.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                        closeDialog.ok();
                        Receipts_service_center_items.delete_receipt_items4("" + to.id);
                        data_cols_items();
                        compute();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
        if (col == 10) {
            if (to.selected == false) {
                to.setSelected(true);
            } else {
                to.setSelected(false);
            }
            tbl_receipt_items_M.fireTableDataChanged();
        }

    }

    private void popup_queue(MouseEvent evt) {

        if (evt.isPopupTrigger()) {
            jPopupMenu2.show(tbl_receipt_items, evt.getX(), evt.getY());
        }
    }

    private void set_report() {

        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Receipt_service_centers.to_receipts to1 = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));

        jProgressBar2.setString("Loading... Please wait...");
        jProgressBar2.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override

            public void run() {
                List<Srpt_receipts.field> fields = new ArrayList();
                List<to_receipt_items> datas = tbl_receipt_items_ALM;
                for (to_receipt_items to : datas) {
                    String serial = to.serial_nos.replaceAll("\n", "        ");
                    serial = serial.replaceAll("o", "Φ");
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }

                    unit = unit.replaceAll("#", "/");
                    Srpt_receipts.field f = new Srpt_receipts.field(to.qty, to.main_barcode, to.barcode, to.description, serial, to.cost, to.qty * to.cost, unit);
                    fields.add(f);
                }
                String transaction_no = to1.receipt_no;
                String transaction_type = to1.receipt_type;
                String supplier = to1.supplier;
                String receiving_location = to1.branch;
                String reference_no = to1.remarks;
                String date_of_delivery = DateType.convert_dash_date2(to1.date_added);
                String date_received = DateType.convert_dash_date2(to1.date_received);
                double gross = to1.gross_total;
                double discount = to1.discount;
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City");
                String contact_no = System.getProperty("contact_no", "422-1234");
                String status = "Posted";
                if (to1.status == 1) {
                    status = "Finalized";
                }
                if (to1.status == 2) {
                    status = "Deleted";
                }
                Srpt_receipts rpt = new Srpt_receipts(transaction_no, transaction_type, supplier, receiving_location, reference_no, date_of_delivery, date_received, gross, discount, business_name, address, contact_no, status);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_receipts.jrxml";
                String pool_db = System.getProperty("pool_db", "db_algorithm");
                if (pool_db.equalsIgnoreCase("db_smis_dumaguete_angel_buns")) {
                    jrxml = "rpt_receipts_cost_8_decimal.jrxml";
                }
                report_customers_aging(rpt, jrxml);
                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_receipts to, String jrxml_name) {
        jPanel10.removeAll();
        jPanel10.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_customers_aging(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel10.add(viewer);
            jPanel10.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_customers_aging(Srpt_receipts to, String rpt_name) {
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
            InputStream is = Srpt_receipts.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void show_popup(MouseEvent evt) {
        String where = " where user_name='" + Users.user_name + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        int exists = 0;
        for (S1_user_previleges.to_user_previleges to : datas) {
            if (to.previledge.equalsIgnoreCase("Finalize Receipt")) {
                exists = 1;
                break;
            }
        }

        if (exists == 1) {
            if (evt.isPopupTrigger()) {
                jPopupMenu1.show(tbl_receipts, evt.getX(), evt.getY());
            }
        }
    }

    private void finalize_receipt() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Receipts Service - (Finalize)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        final int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Receipt_service_centers.to_receipts to = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Receipt-Status [Finalized]!");
            return;
        }
        if (to.status == 2) {
            Alert.set(0, "Receipt-Status [Deleted]!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_finalize nd = Dlg_confirm_finalize.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_finalize.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_finalize.OutputData data) {
                closeDialog.ok();

                proceed_finalize_receipt(data);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    //<editor-fold defaultstate="collapsed" desc=" items received ">
    private void rpt_items_received() {

        jProgressBar3.setString("Loading... Please wait...");
        jProgressBar3.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override

            public void run() {
                String date_from = DateType.sf.format(jDateChooser3.getDate());
                String date_to = DateType.sf.format(jDateChooser4.getDate());
                Field.Combo supplier = (Field.Combo) jTextField3;
                Field.Combo loc = (Field.Combo) tf_branch3;
                String where = " where category like '%" + "" + "%' ";
                if (!jCheckBox14.isSelected()) {
                    where = where + " and Date(date_received) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (jCheckBox18.isSelected()) {
                    where = where + " and batch_no='0' ";
                }
                if (jCheckBox17.isSelected()) {
                    where = where + " and batch_no='1' ";
                }

                if (jCheckBox20.isSelected()) {
                    where = where + " and status='0' ";
                }
                if (jCheckBox19.isSelected()) {
                    where = where + " and status='1' ";
                }

                if (jCheckBox24.isSelected()) {
                    where = where + " and main_barcode='" + tf_search1.getText() + "' ";
                }
                if (jCheckBox25.isSelected()) {
                    where = where + " and barcodes='" + tf_search1.getText() + "' ";
                }
                if (jCheckBox26.isSelected()) {
                    where = where + " and description like '%" + tf_search1.getText() + "%' ";
                }
                if (!jCheckBox22.isSelected()) {
                    where = where + " and supllier_id = '" + supplier.getId() + "' ";
                }

                where = where + " and location_id='" + loc.getId() + "' ";
                where = where + " "
                        + " group by Date(date_received),location_id,main_barcode,cost "
                        + " order by Date(date_received),location_id,supplier_id,description asc ";
//                System.out.println(where);
                List<Srpt_items_received.field> fields = Srpt_items_received.ret_data2(where);
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City Negros Oriental");

                String date = DateType.slash.format(jDateChooser3.getDate()) + " - " + DateType.slash.format(jDateChooser4.getDate());
                String branch = tf_branch2.getText();
                String location = tf_branch3.getText();
                String supplier1 = jTextField3.getText();
                if (jCheckBox22.isSelected()) {
                    supplier1 = "All";
                }
                String type = "All";
                if (jCheckBox17.isSelected()) {
                    type = "DR";
                }
                if (jCheckBox18.isSelected()) {
                    type = "SI";
                }

                String status = "All";
                if (jCheckBox20.isSelected()) {
                    status = "Posted";
                }
                if (jCheckBox19.isSelected()) {
                    status = "Finalized";
                }
                Srpt_items_received rpt = new Srpt_items_received(business_name, address, date, branch, location, supplier1, type, status);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_items_received.jrxml";
                if (jCheckBox27.isSelected()) {
                    jrxml = "rpt_items_received_sum.jrxml";
                }
                report_items_received(rpt, jrxml);
                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_items_received(final Srpt_items_received to, String jrxml_name) {
        jPanel15.removeAll();
        jPanel15.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_items_received(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel15.add(viewer);
            jPanel15.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_items_received(Srpt_items_received to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_items_received(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_items_received(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_items_received.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

//</editor-fold>
    private void new_post() {
        init_receipt_no();
        tf_receipt_type.setText("");
        tf_receipt_type_id.setText("");
        tf_supplier.setText("");
        tf_supplier_id.setText("");
        tf_remarks.setText("");
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_M.fireTableDataChanged();
        tf_reference_no.setText("");
        tf_receipt_type.grabFocus();
        jButton1.setEnabled(true);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        tf_branch_location.setEnabled(true);
        tf_search.setEnabled(true);
        tbl_receipts.clearSelection();
        tbl_receipt_items.clearSelection();
        compute();
    }

    private void proceed_finalize_receipt(Dlg_confirm_finalize.OutputData data) {
        Loader loader = new Loader(this, data);
        loader.execute();
    }

    private void loader_finalize_receipt(Dlg_confirm_finalize.OutputData data) {
        final int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Receipt_service_centers.to_receipts to = (Receipt_service_centers.to_receipts) tbl_receipts_ALM.get(tbl_receipts.convertRowIndexToModel(row));
        List<to_receipt_items> datas = tbl_receipt_items_ALM;
        List<Receipts_service_center_items.to_receipt_items> acc = new ArrayList();
        for (to_receipt_items to3 : datas) {
            String barcode = to3.barcode;
            String description = to3.description;
            double qty = to3.qty;
            double cost = to3.cost;
            String category = to3.category;
            String category_id = to3.category_id;
            String classification = to3.classification;
            String classification_id = to3.classification_id;
            String sub_class = to3.sub_class;
            String sub_class_id = to3.sub_class_id;
            String sup = to3.supplier;
            String sup_id = to3.supllier_id;
            String barcodes = to3.barcodes;
            String serial_no = to3.serial_nos;
            String main_barcode = to3.main_barcode;
            String brand = to3.brand;
            String brand_id = to3.brand_id;
            String model = to3.model;
            String model_id = to3.model_id;
            int status = 0;
            double previous_cost = to3.previous_cost;
            String receipt_type_id = "";
            String location = tf_branch_location.getText();
            String location_id = tf_branch_id.getText();
            Receipts_service_center_items.to_receipt_items to4 = new Receipts_service_center_items.to_receipt_items(to3.id, to3.receipt_no, to3.user_name, to3.session_no, to3.date_added, sup, sup_id, to3.remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, to3.conversion, to3.unit, "", "", barcodes, serial_no, to3.batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, to3.branch, to3.branch_id, to3.location, to3.location_id);
            acc.add(to4);
        }
        String branch = "";
        String branch_id = "";
        for (S1_branch_locations.to_branch_locations t : branch_locations) {
            if (to.branch_id.equalsIgnoreCase("" + t.id)) {
                branch = t.branch;
                branch_id = t.branch_id;
                break;
            }
        }
//                String ap_no = Accounts_payable.increment_id(branch_id);
//                List<Accounts_payable.to_accounts_payable> payables = Accounts_payable.ret_data(" where ap_no='" + ap_no + "' ");
//                if (!payables.isEmpty()) {
//                    payables = Accounts_payable.ret_data(" where ap_no='" + ap_no + "' ");
//                    Alert.set(0, "AP No. already added!");
//                    return;
//                }

        Receipt_service_centers.finalize(to, acc, branch, branch_id, data.is_invoice, data.is_payable, data.ap_date);
        data_cols();
        new_post();
        Alert.set(2, "");
        jButton6.setEnabled(false);
    }

    //<editor-fold defaultstate="collapsed" desc=" Loader Finalize ">
    public class Loader extends SwingWorker {

        private Loading dialog;
        private Dlg_confirm_finalize.OutputData data2;

        public Loader(JDialog dlg, Dlg_confirm_finalize.OutputData data) {

            dialog = new Loading();
            data2 = data;
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            dialog.setSize(xSize, ySize);
            dialog.setPreferredSize(new Dimension(xSize, ySize));
            dialog.setAlwaysOnTop(true);
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        if (getState() == SwingWorker.StateValue.STARTED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (getState() == SwingWorker.StateValue.STARTED) {
                                        dialog.setVisible(true);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        @Override
        protected Object doInBackground() throws Exception {
            loader_finalize_receipt(data2);
            return null;
        }

        @Override
        protected void done() {
            dialog.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" inventory_barcodes "> 
    public static ArrayListModel tbl_inventory_barcodes_ALM2;
    public static Tblinventory_barcodesModel2 tbl_inventory_barcodes_M2;

    public static void init_tbl_inventory_barcodes2(JTable jTable1) {
        tbl_inventory_barcodes_ALM2 = new ArrayListModel();
        tbl_inventory_barcodes_M2 = new Tblinventory_barcodesModel2(tbl_inventory_barcodes_ALM2);
        jTable1.setModel(tbl_inventory_barcodes_M2);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.setRowHeight(25);
        int[] tbl_widths_inventory_barcodes = {100, 100, 100, 100, 40};
        for (int i = 0, n = tbl_widths_inventory_barcodes.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(jTable1, i, tbl_widths_inventory_barcodes[i]);
        }
        Dimension d = jTable1.getTableHeader().getPreferredSize();
        d.height = 25;
        jTable1.getTableHeader().setPreferredSize(d);
        jTable1.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        jTable1.setRowHeight(25);
        jTable1.setFont(new java.awt.Font("Arial", 0, 12));
        TableColumn tc = jTable1.getColumnModel().getColumn(4);
        tc.setCellEditor(jTable1.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(jTable1.getDefaultRenderer(Boolean.class));

//        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
        tc.setHeaderRenderer(new Dlg_print_barcode.CheckBoxHeader(new Dlg_print_barcode.MyItemListener()));
    }

    public static class MyItemListener2 implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
//            if (source instanceof AbstractButton == false) {
//                return;
//            }
//            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
//            for (int x = 0, y = new Dlg_print_barcode().tbl_inventory_barcodes.getRowCount(); x < y; x++) {
//                new Dlg_print_barcode().tbl_inventory_barcodes.setValueAt(checked, x, 0);
//            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Print Barcode ">
    public static class CheckBoxHeader2 extends JCheckBox
            implements TableCellRenderer, MouseListener {

        protected CheckBoxHeader2 rendererComponent;
        protected int column;
        protected boolean mousePressed = false;

        public CheckBoxHeader2(ItemListener itemListener) {
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
                    rendererComponent.setOpaque(true);
                    rendererComponent.setBackground(new java.awt.Color(255, 255, 255));
                    rendererComponent.setHorizontalAlignment(Align.CENTER);
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
            List<Srpt_print_barcodes.field> datas = tbl_inventory_barcodes_ALM2;
            boolean selected = false;
            if (this.isSelected()) {
                selected = true;
            }
            for (Srpt_print_barcodes.field to : datas) {
                to.setSelected(selected);
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

    public static void loadData_inventory_barcodes2(List<Srpt_print_barcodes.field> acc) {
        tbl_inventory_barcodes_ALM2.clear();
        tbl_inventory_barcodes_ALM2.addAll(acc);
    }

    public static class Tblinventory_barcodesModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Code", "Description", "Price", "Count", ""
        };

        public Tblinventory_barcodesModel2(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 4) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Srpt_print_barcodes.field tt = (Srpt_print_barcodes.field) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.getBarcode();
                case 1:
                    return " " + tt.getDescription();
                case 2:
                    return " " + FitIn.fmt_wc_0(tt.getPrice());
                case 3:
                    return " " + FitIn.fmt_woc(tt.getCount());
                default:
                    return tt.isSelected();
            }
        }
    }

    public static JRViewer get_viewer_customers_aging(Srpt_print_barcodes to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_aging2(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_aging2(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_print_barcodes.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    //</editor-fold>
    private void suppliers() {
        Window p = (Window) this;
        Dlg_suppliers nd = Dlg_suppliers.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_suppliers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_suppliers.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void privileges() {
        Window p = (Window) this;
        Dlg_inventory_brand_privileges nd = Dlg_inventory_brand_privileges.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_brand_privileges.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_brand_privileges.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void warranty_add_record() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Warranty Service - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        Window p = (Window) this;
        Dlg_warranty_item nd = Dlg_warranty_item.create(p, true);
        nd.setTitle("");
        nd.do_pass(FitIn.toInt(location_ids));
        nd.setCallback(new Dlg_warranty_item.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_warranty_item.OutputData data) {
                closeDialog.ok();
                final Field.Combo loc = (Field.Combo) tf_branch4;
                int id = 0;
                String transaction_no = Warranties.increment_id();
                String slip_no = data.slip_no;
                String remarks = data.remarks;
                String supplier = data.supplier;
                String supplier_id = data.supplier_id;
                int status = 0;
                String created_at = DateType.now();
                String created_by = MyUser.getUser_id();
                String branch = my_branch;
                String branch_id = my_branch_id;
                String location = loc.getText();
                String location_id = loc.getId();
                Warranties.to_warranties warranty = new Warranties.to_warranties(id, transaction_no, slip_no, remarks, supplier, supplier_id, status, created_at, created_by, branch, branch_id, location, location_id);
                Warranties.add_data(warranty, data.items);
                ret_warranty();
                Alert.set(1, "");

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void select_item() {
        int row = tbl_warranties.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Warranty_items.to_warranty_items to = (Warranty_items.to_warranty_items) tbl_warranty_items_ALM.get(row);
        int col = tbl_warranties.getSelectedColumn();
        if (col == 6) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Warranty Service - (Finalize)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 1) {
                Alert.set(0, "Transaction already closed!");
                return;
            }
            Window p = (Window) this;
            Dlg_warranty_close nd = Dlg_warranty_close.create(p, true);
            nd.setTitle("");
//            nd.do_pass(services);
            nd.setCallback(new Dlg_warranty_close.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_warranty_close.OutputData data) {
                    closeDialog.ok();
                    Warranty_items.update_status(to);
                    ret_warranty();
                    Alert.set(2, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 7) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Warranty Service - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            Window p = (Window) this;
            Dlg_warranty_item nd = Dlg_warranty_item.create(p, true);
            nd.setTitle("");
//            nd.do_pass2(to);
            nd.setCallback(new Dlg_warranty_item.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_warranty_item.OutputData data) {
                    closeDialog.ok();

//                    Warranty_items.to_warranty_items warranty = new Warranty_items.to_warranty_items(id, transaction_no, remarks, trans_type, supplier, supplier_id, barcode, description, qty, cost, selling_price, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, warranty_date, serial_no, main_barcode, brand, brand_id, model, model_id, status, created_at, created_by, branch, branch_id, location, location_id);
//                    Warranty_items.update_data(warranty);
//                    ret_warranty();
//                    Alert.set(2, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 8) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Warranty Service - (Delete)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 1) {
                Alert.set(0, "Cannot delete record, already closed!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Warranty_items.delete_data(to);
                    ret_warranty();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }
    //<editor-fold defaultstate="collapsed" desc=" warranty_items "> 
    public static ArrayListModel tbl_warranty_items_ALM;
    public static Tblwarranty_itemsModel tbl_warranty_items_M;

    public static void init_tbl_warranty_items(JTable tbl_warranty_items) {
        tbl_warranty_items_ALM = new ArrayListModel();
        tbl_warranty_items_M = new Tblwarranty_itemsModel(tbl_warranty_items_ALM);
        tbl_warranty_items.setModel(tbl_warranty_items_M);
        tbl_warranty_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranty_items.setRowHeight(25);
        int[] tbl_widths_warranty_items = {80, 60, 120, 100, 80, 80, 60, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranty_items.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_warranty_items, i, tbl_widths_warranty_items[i]);
        }
        Dimension d = tbl_warranty_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_warranty_items.getTableHeader().setPreferredSize(d);
        tbl_warranty_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_warranty_items.setRowHeight(25);
        tbl_warranty_items.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_warranty_items(List<to_warranty_items> acc) {
        tbl_warranty_items_ALM.clear();
        tbl_warranty_items_ALM.addAll(acc);
    }

    public static class Tblwarranty_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Qty", "Item Code", "Description", "Warranty", "Type", "Status", "", "", "cost", "selling_price", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "warranty_date", "serial_no", "main_barcode", "brand", "brand_id", "model", "model_id", "status", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
        };

        public Tblwarranty_itemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
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
            to_warranty_items tt = (to_warranty_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.qty;
                case 2:
                    return " " + tt.main_barcode;
                case 3:
                    return " " + tt.description;
                case 4:
                    return " " + DateType.convert_slash_datetime2(tt.warranty_date);
                case 5:
                    return " " + tt.trans_type;
                case 6:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 7:
                    return " Edit";
                case 8:
                    return " Delete";
                case 9:
                    return tt.cost;
                case 10:
                    return tt.selling_price;
                case 11:
                    return tt.category;
                case 12:
                    return tt.category_id;
                case 13:
                    return tt.classification;
                case 14:
                    return tt.classification_id;
                case 15:
                    return tt.sub_class;
                case 16:
                    return tt.sub_class_id;
                case 17:
                    return tt.conversion;
                case 18:
                    return tt.unit;
                case 19:
                    return tt.warranty_date;
                case 20:
                    return tt.serial_no;
                case 21:
                    return tt.main_barcode;
                case 22:
                    return tt.brand;
                case 23:
                    return tt.brand_id;
                case 24:
                    return tt.model;
                case 25:
                    return tt.model_id;
                case 26:
                    return tt.status;
                case 27:
                    return tt.created_at;
                case 28:
                    return tt.created_by;
                case 29:
                    return tt.branch;
                case 30:
                    return tt.branch_id;
                case 31:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

//</editor-fold> 
    private void items() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance per Location - (View)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        Window p = (Window) this;
        Dlg_inventory_branch nd = Dlg_inventory_branch.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_inventory_branch.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_branch.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" warranties "> 
    public static ArrayListModel tbl_warranties_ALM;
    public static TblwarrantiesModel tbl_warranties_M;

    public static void init_tbl_warranties(JTable tbl_warranties) {
        tbl_warranties_ALM = new ArrayListModel();
        tbl_warranties_M = new TblwarrantiesModel(tbl_warranties_ALM);
        tbl_warranties.setModel(tbl_warranties_M);
        tbl_warranties.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranties.setRowHeight(25);
        int[] tbl_widths_warranties = {100, 80, 80, 100, 70, 40, 50, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranties.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_warranties, i, tbl_widths_warranties[i]);
        }
        Dimension d = tbl_warranties.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_warranties.getTableHeader().setPreferredSize(d);
        tbl_warranties.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_warranties.setRowHeight(25);
        tbl_warranties.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_warranties(List<to_warranties> acc) {
        tbl_warranties_ALM.clear();
        tbl_warranties_ALM.addAll(acc);
    }

    public static class TblwarrantiesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Slip No", "Date", "Supplier", "Status", "", "", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
        };

        public TblwarrantiesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
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
            to_warranties tt = (to_warranties) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.slip_no;
                case 2:
                    return " " + DateType.convert_slash_datetime2(tt.created_at);
                case 3:
                    return " " + tt.supplier;
                case 4:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 5:
                    return " Edit";
                case 6:
                    return " Delete";
                case 7:
                    return tt.created_at;
                case 8:
                    return tt.created_by;
                case 9:
                    return tt.branch;
                case 10:
                    return tt.branch_id;
                case 11:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_warranty() {
        String where = " where id<>0 ";

        if (!jCheckBox29.isSelected()) {
            String date_from = DateType.sf.format(jDateChooser7.getDate());
            String date_to = DateType.sf.format(jDateChooser8.getDate());
            where = where + " and Date(created_at) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (!jCheckBox31.isSelected()) {
            Field.Combo supp = (Field.Combo) jTextField4;
            where = where + " and supplier_id='" + supp.getId() + "' ";
        }

        if (!jCheckBox30.isSelected()) {
            Field.Combo supp = (Field.Combo) tf_branch4;
            where = where + " and location_id='" + supp.getId() + "' ";
        }
        if (!jCheckBox36.isSelected()) {
            if (jCheckBox37.isSelected()) {
                where = where + " and status = 0  ";
            } else {
                where = where + " and status = 1 ";
            }
        }
        where = where + " order by id desc ";
        List<Warranties.to_warranties> datas = Warranties.ret_data(where);
        loadData_warranties(datas);
        jLabel53.setText("" + datas.size());
    }

    private void select_warranty() {
        int row = tbl_warranties.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_warranties.getSelectedColumn();
        final Warranties.to_warranties to = (Warranties.to_warranties) tbl_warranties_ALM.get(row);
        if (col == 5) {
            Window p = (Window) this;
            Dlg_warranty_item nd = Dlg_warranty_item.create(p, true);
            nd.setTitle("");
            nd.do_pass2(to, FitIn.toInt(location_ids));
            nd.setCallback(new Dlg_warranty_item.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_warranty_item.OutputData data) {
                    closeDialog.ok();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 6) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
//            nd.do_pass(services);
            nd.setCallback(new Dlg_confirm_delete.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Warranties.delete_data(to);
                    Alert.set(3, "");
                    ret_warranty();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" report items ">
    private void set_report_warranties() {

        jProgressBar4.setString("Loading... Please wait...");
        jProgressBar4.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override

            public void run() {

                String where = " where id<>0 ";

                if (!jCheckBox32.isSelected()) {
                    String date_from = DateType.sf.format(jDateChooser9.getDate());
                    String date_to = DateType.sf.format(jDateChooser10.getDate());

                    where = where + " and Date(warranty_date) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox33.isSelected()) {
                    Field.Combo tf = (Field.Combo) tf_branch5;
                    where = where + " and location_id='" + tf.getId() + "'";
                }

                if (!jCheckBox34.isSelected()) {
                    Field.Combo tf = (Field.Combo) jTextField5;
                    where = where + " and supplier_id='" + tf.getId() + "' ";
                }
                if (!jCheckBox39.isSelected()) {
                    if (jCheckBox40.isSelected()) {
                        where = where + " and status=0 ";
                    } else {
                        where = where + " and status=1 ";
                    }
                }
                if (!jCheckBox42.isSelected()) {
                    if (jCheckBox43.isSelected()) {
                        where = where + " and trans_type like 'In' ";
                    } else {
                        where = where + " and trans_type like 'Out' ";
                    }
                }
                if (!jCheckBox35.isSelected()) {
                    if (jCheckBox47.isSelected()) {
                        where = where + " and description like '%" + tf_search2.getText() + "%' ";
                    } else {
                        where = where + " and main_barcode like '" + tf_search2.getText() + "' ";
                    }
                }
                where = where + " order by description asc ";

                List<Srpt_warranty_items.field> fields = Srpt_warranty_items.ret_data(where);

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, Dumaguete City Negros Oriental");
                String date = "04/16/2017";
                String branch = "Dumaguete City";
                String location = "Selling Area";
                String supplier = "";
                String type = "";
                String status = "";
                Srpt_warranty_items rpt = new Srpt_warranty_items(business_name, address, date, branch, location, supplier, type, status);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_warranty_items.jrxml";
                report_warranty_items(rpt, jrxml);
                jProgressBar4.setString("Finished...");
                jProgressBar4.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_warranty_items(final Srpt_warranty_items to, String jrxml_name) {
        jPanel11.removeAll();
        jPanel11.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_warranty_items(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel11.add(viewer);
            jPanel11.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_warranty_items(Srpt_warranty_items to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_warranty_items(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_warranty_items(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_warranty_items.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    //</editor-fold>
    List<Inventory.to_inventory> inventory_barcoders_list2 = new ArrayList();
    int selected_row2 = 0;

    private void init_inventory_barcodes2() {

        tf_search2.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search2.getText();
                final Field.Combo location = (Field.Combo) tf_branch5;
                String where = " where ";
                if (jCheckBox35.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location.getId() + "'  and location not like '' "
                            + " or barcode like '" + search + "' and location_id='" + location.getId() + "' and location not like ''  "
                            + " or description like '%" + search + "%' and location_id='" + location.getId() + "' and location not like '' ";
                }
                if (jCheckBox45.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location.getId() + "' and location not like ''  "
                            + "  ";
                }
                if (jCheckBox46.isSelected()) {
                    where = where + " "
                            + "  barcodes like '" + search + "' and location_id='" + location.getId() + "' and location not like '' ";
                }
                if (jCheckBox47.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + location.getId() + "' and location not like '' ";
                }
                where = where + " order by description asc ";

                inventory_barcoders_list2.clear();
                inventory_barcoders_list2 = Inventory.ret_data6(where);

                if (inventory_barcoders_list2.isEmpty()) {
                    Alert.set(0, "Item not found!");
                    tf_search2.setEnabled(true);
                    tf_search2.grabFocus();
                    return;
                }
                if (inventory_barcoders_list2.size() == 1) {
                    selected_row2 = 0;
                    Inventory.to_inventory to = (Inventory.to_inventory) inventory_barcoders_list2.get(0);
                    Field.Input tf = (Field.Input) tf_search2;
                    tf.setText(to.barcode);
                    tf.setId(to.description);
                    tf_search2.setEnabled(true);
                    tf_search2.grabFocus();
                }
                if (inventory_barcoders_list2.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list2.size()][6];
                    int i = 0;
                    for (Inventory.to_inventory to : inventory_barcoders_list2) {

                        obj[i][0] = " " + to.barcode;
                        obj[i][1] = " " + to.description;

                        obj[i][2] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search2.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {120, w, 50};
                    String[] col_names = {"ItemCode", "Description", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search2, obj, labels, tbl_widths_customers, col_names);

                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            selected_row2 = data.selected_row;
                            Inventory.to_inventory to = (Inventory.to_inventory) inventory_barcoders_list2.get(selected_row2);
                            Field.Input tf = (Field.Input) tf_search2;
                            tf.setText(to.barcode);
                            tf.setId(to.description);
                            tf_search2.setEnabled(true);
                            tf_search2.grabFocus();
                        }
                    });
                }
                tf_search2.setEnabled(true);
            }
        });
        t.start();
    }

    //<editor-fold defaultstate="collapsed" desc=" Stock Take ">
    private void set_stock_take() {

        String where = " where id<>0 ";

        if (!jCheckBox52.isSelected()) {
            Field.Combo tf = (Field.Combo) tf_branch6;
            where = where + " and location_id='" + tf.getId() + "'";
        }

        if (!jCheckBox48.isSelected()) {
            if (jCheckBox51.isSelected()) {
                where = where + " and description like '%" + tf_search3.getText() + "%' ";
            } else {
                where = where + " and barcode like '" + tf_search3.getText() + "' ";
            }
        }
        where = where + " order by description asc ";

        List<Inventory.to_inventory> datas2 = Inventory.ret_data4(where);
        final List<Srpt_stock_take.field> datas = new ArrayList();
        for (Inventory.to_inventory to : datas2) {
            String item_code = to.barcodes;
            String barcode = to.barcode;
            String description = to.description;
            double qty = to.product_qty;
            double selling_price = to.selling_price;
            double cost = to.cost;
            String uom = to.unit;
            String code = to.barcode;
            String loc = to.branch + " - " + to.location;
            String serial = "";
            String serial_ib = "";
            String serial_s = "";
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            Srpt_stock_take.field field = new Srpt_stock_take.field(item_code, barcode, description, qty, selling_price, cost, uom, code, loc, serial_ib);
            datas.add(field);
        }

        String category1 = category1 = "All";
        if (category1.isEmpty()) {

        }
        String classification = classification = "All";

        String sub_classification = sub_classification = "All";

        String brand = brand = "All";

        String model = model = "All";
        if (model.isEmpty()) {

        }
        String branch = "All";
        String location = "All";

        final String category = category1;
        final String classification1 = classification;
        final String sub_classification1 = sub_classification;
        final String brand1 = brand;
        final String model1 = model;
        final String branch1 = branch;
        final String location1 = location;
        jProgressBar5.setString("Loading...Please wait...");
        jProgressBar5.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String date = DateType.month_date.format(new Date());

                Srpt_stock_take rpt = new Srpt_stock_take(category, classification1, sub_classification1, brand1, model1, business_name, date, branch1, location1);
                rpt.fields.addAll(datas);

                String jrxml = "rpt_stock_take_warranty.jrxml";

                report_preview(rpt, jrxml);

                jProgressBar5.setString("Finished...");
                jProgressBar5.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void report_preview(final Srpt_stock_take to, String jrxml_name) {
        jPanel21.removeAll();
        jPanel21.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_items(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel21.add(viewer);
            jPanel21.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_items(Srpt_stock_take to, String rpt_name) {
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

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_stock_take.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    List<Inventory.to_inventory> inventory_barcoders_list3 = new ArrayList();
    int selected_row3 = 0;

    private void init_inventory_barcodes3() {

        tf_search3.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search3.getText();
                final Field.Combo location = (Field.Combo) tf_branch6;
                String where = " where ";
                if (jCheckBox48.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location.getId() + "'  and location not like '' "
                            + " or barcode like '" + search + "' and location_id='" + location.getId() + "' and location not like ''  "
                            + " or description like '%" + search + "%' and location_id='" + location.getId() + "' and location not like '' ";
                }
                if (jCheckBox49.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location.getId() + "' and location not like ''  "
                            + "  ";
                }
                if (jCheckBox50.isSelected()) {
                    where = where + " "
                            + "  barcodes like '" + search + "' and location_id='" + location.getId() + "' and location not like '' ";
                }
                if (jCheckBox51.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + location.getId() + "' and location not like '' ";
                }
                where = where + " order by description asc ";

                inventory_barcoders_list3.clear();
                inventory_barcoders_list3 = Inventory.ret_data6(where);

                if (inventory_barcoders_list3.isEmpty()) {
                    Alert.set(0, "Item not found!");
                    tf_search3.setEnabled(true);
                    tf_search3.grabFocus();
                    return;
                }
                if (inventory_barcoders_list3.size() == 1) {
                    selected_row3 = 0;
                    Inventory.to_inventory to = (Inventory.to_inventory) inventory_barcoders_list3.get(0);
                    Field.Input tf = (Field.Input) tf_search3;
                    tf.setText(to.barcode);
                    tf.setId(to.description);
                    tf_search3.setEnabled(true);
                    tf_search3.grabFocus();
                }
                if (inventory_barcoders_list3.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list3.size()][6];
                    int i = 0;
                    for (Inventory.to_inventory to : inventory_barcoders_list3) {

                        obj[i][0] = " " + to.barcode;
                        obj[i][1] = " " + to.description;

                        obj[i][2] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search3.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {120, w, 50};
                    String[] col_names = {"ItemCode", "Description", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search3, obj, labels, tbl_widths_customers, col_names);

                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            selected_row3 = data.selected_row;
                            Inventory.to_inventory to = (Inventory.to_inventory) inventory_barcoders_list3.get(selected_row3);
                            Field.Input tf = (Field.Input) tf_search3;
                            tf.setText(to.barcode);
                            tf.setId(to.description);
                            tf_search3.setEnabled(true);
                            tf_search3.grabFocus();
                        }
                    });
                }
                tf_search3.setEnabled(true);
            }
        });
        t.start();
    }

    //</editor-fold>
}