/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.main.Main;
import POS.users.S1_user_default_previleges.to_user_default_previleges;
import POS.users.S1_user_previleges.to_user_previleges;
import POS.users.S1_users.to_users;
import POS.util.Alert;
import POS.util.Courier;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;

/**
 *
 * @author Maytopacka
 */
public class Dlg_users extends javax.swing.JDialog {

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
    private Dlg_users(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_users(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_users() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_users myRef;

    private void setThisRef(Dlg_users myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_users> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_users create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_users create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_users dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_users((java.awt.Frame) parent, false);
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
            Dlg_users dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_users((java.awt.Dialog) parent, false);
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

        Dlg_users dialog = Dlg_users.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);
//        dialog.setVisible(true);
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
        pm_cashier1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        pm_cashier = new javax.swing.JMenuItem();
        pm_inventory = new javax.swing.JMenuItem();
        pm_accounting = new javax.swing.JMenuItem();
        pm_services = new javax.swing.JMenuItem();
        pm_administrator = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_users = new org.jdesktop.swingx.JXTable();
        tf_search = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new Button.Default();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_screen_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_user_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_active = new javax.swing.JCheckBox();
        tf_password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_lvl = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cb_t_cashier = new javax.swing.JCheckBox();
        cb_t_receipts = new javax.swing.JCheckBox();
        cb_t_stock_transfer = new javax.swing.JCheckBox();
        cb_t_inventory_adjuster = new javax.swing.JCheckBox();
        cb_t_salesman = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        cb_m_items = new javax.swing.JCheckBox();
        cb_m_category = new javax.swing.JCheckBox();
        cb_m_users = new javax.swing.JCheckBox();
        cb_m_uom = new javax.swing.JCheckBox();
        cb_m_suppliers = new javax.swing.JCheckBox();
        cb_m_customers = new javax.swing.JCheckBox();
        cb_m_discount = new javax.swing.JCheckBox();
        cb_m_banks = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        cb_r_sales = new javax.swing.JCheckBox();
        cb_r_cash_count = new javax.swing.JCheckBox();
        cb_r_receipts = new javax.swing.JCheckBox();
        cb_r_stock_transferred = new javax.swing.JCheckBox();
        cb_r_stock_take = new javax.swing.JCheckBox();
        cb_r_stock_left_supplier = new javax.swing.JCheckBox();
        jButton2 = new Button.Warning();
        jButton3 = new Button.Info();
        jButton4 = new Button.Default();
        jButton5 = new Button.Primary();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        tf_from_branch = new javax.swing.JTextField();
        tf_from_location = new javax.swing.JTextField();
        tf_from_branch_id = new javax.swing.JTextField();
        tf_from_location_id = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user_default_previleges = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_user_previleges = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new Button.Default();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        pm_cashier1.setText("Select Previleges to Copy");
        jPopupMenu1.add(pm_cashier1);
        jPopupMenu1.add(jSeparator1);

        pm_cashier.setText("Sales");
        pm_cashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_cashierMouseClicked(evt);
            }
        });
        pm_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_cashierActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_cashier);

        pm_inventory.setText("Inventory");
        pm_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_inventoryMouseClicked(evt);
            }
        });
        pm_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_inventoryActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_inventory);

        pm_accounting.setText("Accounting");
        pm_accounting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_accountingActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_accounting);

        pm_services.setText("Services");
        pm_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_servicesActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_services);

        pm_administrator.setText("Administrator");
        pm_administrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_administratorActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_administrator);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setOpaque(false);

        tbl_users.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_users.setOpaque(false);
        tbl_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usersMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_usersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_usersMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_users);

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Search:");

        jLabel10.setText("No. of rows:");

        jLabel11.setText("0");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(1, 1, 1))
        );

        jXPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Screen Name:");

        tf_screen_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_screen_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("User Name:");

        tf_user_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_user_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Password:");

        cb_active.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_active.setSelected(true);
        cb_active.setText("Active/Inactive");
        cb_active.setOpaque(false);

        tf_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_password.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Status:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("User Level:");

        cb_lvl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_lvl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accounting", "Administrator", "Inventory", "Services" }));
        cb_lvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_lvlActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(240, 237, 223));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PREVILEGES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRANSACTIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cb_t_cashier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_cashier.setText("CASHIER");
        cb_t_cashier.setOpaque(false);

        cb_t_receipts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_receipts.setText("RECEIPTS");
        cb_t_receipts.setOpaque(false);

        cb_t_stock_transfer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_stock_transfer.setText("STOCK TRANSFER");
        cb_t_stock_transfer.setOpaque(false);

        cb_t_inventory_adjuster.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_inventory_adjuster.setText("INVENTORY ADJUSTER");
        cb_t_inventory_adjuster.setOpaque(false);

        cb_t_salesman.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_salesman.setText("SALESMAN");
        cb_t_salesman.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_t_receipts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_t_cashier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_t_stock_transfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_t_inventory_adjuster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_t_salesman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_t_salesman)
                .addGap(4, 4, 4)
                .addComponent(cb_t_cashier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_t_receipts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_t_stock_transfer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_t_inventory_adjuster)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MAINTENANCE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cb_m_items.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_items.setText("ITEMS");
        cb_m_items.setOpaque(false);

        cb_m_category.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_category.setText("CATEGORY");
        cb_m_category.setOpaque(false);

        cb_m_users.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_users.setText("USERS");
        cb_m_users.setOpaque(false);

        cb_m_uom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_uom.setText("UOM");
        cb_m_uom.setOpaque(false);

        cb_m_suppliers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_suppliers.setText("SUPPLIERS");
        cb_m_suppliers.setOpaque(false);

        cb_m_customers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_customers.setText("CUSTOMERS");
        cb_m_customers.setOpaque(false);

        cb_m_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_discount.setText("DISCOUNTS");
        cb_m_discount.setOpaque(false);

        cb_m_banks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_banks.setText("BANKS");
        cb_m_banks.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_m_category, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_users, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_uom, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cb_m_items, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_m_banks, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_m_items)
                    .addComponent(cb_m_banks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_m_category)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_m_users)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_m_uom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_m_suppliers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_m_customers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb_m_discount))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cb_r_sales.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_sales.setText("SALES");
        cb_r_sales.setOpaque(false);

        cb_r_cash_count.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_cash_count.setText("CASH COUNT");
        cb_r_cash_count.setOpaque(false);

        cb_r_receipts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_receipts.setText("RECEIPTS");
        cb_r_receipts.setOpaque(false);

        cb_r_stock_transferred.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_stock_transferred.setText("STOCK TRANSFERRED");
        cb_r_stock_transferred.setOpaque(false);

        cb_r_stock_take.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_stock_take.setText("STOCK LEFT (Category)");
        cb_r_stock_take.setOpaque(false);
        cb_r_stock_take.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stock_takeActionPerformed(evt);
            }
        });

        cb_r_stock_left_supplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_stock_left_supplier.setText("STOCK LEFT (Supplier)");
        cb_r_stock_left_supplier.setOpaque(false);
        cb_r_stock_left_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stock_left_supplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_r_cash_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_receipts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_stock_transferred, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_stock_take, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_stock_left_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_r_sales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_r_cash_count)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_r_receipts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_r_stock_transferred)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_r_stock_take)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_r_stock_left_supplier)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("Branch:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Location:");

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

        tf_from_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location.setFocusable(false);
        tf_from_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_locationActionPerformed(evt);
            }
        });

        tf_from_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch_id.setFocusable(false);

        tf_from_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_lvl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_active, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_screen_name)
                            .addComponent(tf_user_name)
                            .addComponent(tf_password)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_from_location)
                            .addComponent(tf_from_branch))
                        .addGap(0, 0, 0)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_from_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tf_from_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_screen_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_active)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_lvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(38, 38, 38))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tbl_user_default_previleges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_user_default_previleges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_user_default_previlegesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user_default_previleges);

        tbl_user_previleges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_user_previleges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_user_previlegesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_user_previlegesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_user_previlegesMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_user_previleges);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search Previleges:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Department:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("Administrator");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("All");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Department:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("No. of rows:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jTextField2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        data_cols();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMouseClicked
        select_users();
    }//GEN-LAST:event_tbl_usersMouseClicked

    private void cb_r_stock_takeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stock_takeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_r_stock_takeActionPerformed

    private void cb_r_stock_left_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stock_left_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_r_stock_left_supplierActionPerformed

    private void cb_lvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_lvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_lvlActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        data_cols_default();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_inventory_category(jTextField1);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_user_default_previlegesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_default_previlegesMouseClicked
        add_user_previleges();
    }//GEN-LAST:event_tbl_user_default_previlegesMouseClicked

    private void tbl_user_previlegesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_previlegesMouseClicked
        delete_user_previleges();
    }//GEN-LAST:event_tbl_user_previlegesMouseClicked

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        data_cols_previleges();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_inventory_category2(jTextField3);
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_all_previleges();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear_users();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        add_users();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        edit_users();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        delete_users();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed
        init_branch_locations2();
    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_from_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_locationActionPerformed

    }//GEN-LAST:event_tf_from_locationActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        init_inventory_category(jTextField1);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void tbl_user_previlegesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_previlegesMousePressed

    }//GEN-LAST:event_tbl_user_previlegesMousePressed

    private void tbl_user_previlegesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_previlegesMouseReleased

    }//GEN-LAST:event_tbl_user_previlegesMouseReleased

    private void tbl_usersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMousePressed
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_users, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbl_usersMousePressed

    private void tbl_usersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_users, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbl_usersMouseReleased

    private void pm_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_cashierMouseClicked
        add_cashier_previlege();
    }//GEN-LAST:event_pm_cashierMouseClicked

    private void pm_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_cashierActionPerformed
        add_cashier_previlege();
    }//GEN-LAST:event_pm_cashierActionPerformed

    private void pm_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_inventoryMouseClicked
        add_inventory_previlege();
    }//GEN-LAST:event_pm_inventoryMouseClicked

    private void pm_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_inventoryActionPerformed
        add_inventory_previlege();
    }//GEN-LAST:event_pm_inventoryActionPerformed

    private void pm_accountingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_accountingActionPerformed
        add_accounting_previlege();
    }//GEN-LAST:event_pm_accountingActionPerformed

    private void pm_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_servicesActionPerformed
        add_services_previlege();
    }//GEN-LAST:event_pm_servicesActionPerformed

    private void pm_administratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_administratorActionPerformed
        add_administrator_previlege();
    }//GEN-LAST:event_pm_administratorActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_active;
    private javax.swing.JComboBox cb_lvl;
    private javax.swing.JCheckBox cb_m_banks;
    private javax.swing.JCheckBox cb_m_category;
    private javax.swing.JCheckBox cb_m_customers;
    private javax.swing.JCheckBox cb_m_discount;
    private javax.swing.JCheckBox cb_m_items;
    private javax.swing.JCheckBox cb_m_suppliers;
    private javax.swing.JCheckBox cb_m_uom;
    private javax.swing.JCheckBox cb_m_users;
    private javax.swing.JCheckBox cb_r_cash_count;
    private javax.swing.JCheckBox cb_r_receipts;
    private javax.swing.JCheckBox cb_r_sales;
    private javax.swing.JCheckBox cb_r_stock_left_supplier;
    private javax.swing.JCheckBox cb_r_stock_take;
    private javax.swing.JCheckBox cb_r_stock_transferred;
    private javax.swing.JCheckBox cb_t_cashier;
    private javax.swing.JCheckBox cb_t_inventory_adjuster;
    private javax.swing.JCheckBox cb_t_receipts;
    private javax.swing.JCheckBox cb_t_salesman;
    private javax.swing.JCheckBox cb_t_stock_transfer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JMenuItem pm_accounting;
    private javax.swing.JMenuItem pm_administrator;
    private javax.swing.JMenuItem pm_cashier;
    private javax.swing.JMenuItem pm_cashier1;
    private javax.swing.JMenuItem pm_inventory;
    private javax.swing.JMenuItem pm_services;
    private javax.swing.JTable tbl_user_default_previleges;
    private javax.swing.JTable tbl_user_previleges;
    private org.jdesktop.swingx.JXTable tbl_users;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_branch_id;
    private javax.swing.JTextField tf_from_location;
    private javax.swing.JTextField tf_from_location_id;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_screen_name;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_user_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_algorithm");
        tf_search.grabFocus();
        init_key();
        hover();
        search();
        init();
        init_tbl_users();
        set_default_branch();

        focus();
        jLabel3.setVisible(false);
        cb_lvl.setVisible(false);
        jPanel2.setVisible(false);

        init_tbl_user_default_previleges();
        data_cols_default();

        init_tbl_user_previleges();

        String where = " order by branch,location asc ";
        branch_location_list2 = S1_branch_locations.ret_location_where(where);
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
        int[] tbl_widths_customers = {150, 120};
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

        tf_from_branch.setText(my_branch);
        tf_from_branch_id.setText(my_branch_id);
        tf_from_location.setText(my_location);
        tf_from_location_id.setText(my_location_id);
    }

    private void focus() {
        JTextField[] tf = {tf_screen_name, tf_screen_name, tf_password, tf_search, jTextField1, jTextField2, jTextField3};
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
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
            }
        });
    }

    private void search() {
//        SearchField sf = (SearchField) tf_search;
//        sf.setFont(new java.awt.Font("Tahoma", 0, 10));
//        sf.set_instruction1("Type To Search");
//        sf.set_searcher(new SearchField.ISearcher() {
//
//            @Override
//            public List get_entered(String starts_with) {
//                // your search list here coming from svc for example.
//
//                return new ArrayList();
//
//            }
//        });

//        sf.setCallbackDisplay(new SearchField.CallbackDisplay() {
//
//            @Override
//            public void display(Object o) {
//            }
//        });
//        sf.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//            }
//        });
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
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_users_ALM;
    private TblusersModel tbl_users_M;

    private void init_tbl_users() {
        tbl_users_ALM = new ArrayListModel();
        tbl_users_M = new TblusersModel(tbl_users_ALM);
        tbl_users.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_users.setModel(tbl_users_M);
        tbl_users.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_users.setRowHeight(25);
        int[] tbl_widths_users = {100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_users.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_users, i, tbl_widths_users[i]);
        }
        Dimension d = tbl_users.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_users.getTableHeader().
                setPreferredSize(d);
        tbl_users.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_users.setRowHeight(25);
        tbl_users.setFont(new java.awt.Font("Arial", 0, 12));
    }

    private void loadData_users(List<to_users> acc) {
        tbl_users_ALM.clear();
        tbl_users_ALM.addAll(acc);
    }

    public static class TblusersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Screen Name", "User Name", "Status", "password", "LEVEL", "date_added", "ACTIVE", "t_sales", "t_receipts", "t_stock_transfer", "m_items", "m_category", "m_users", "m_uom", "m_suppliers", "r_sales", "r_cash_count", "r_receipts", "r_stock_transferred", "r_stock_take"
        };

        public TblusersModel(ListModel listmodel) {
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
            to_users tt = (to_users) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.screen_name;
                case 1:
                    return " " + tt.user_name;
                case 2:
                    if (tt.is_active == 0) {
                        return "  Inactive";
                    } else {
                        return "  Active";
                    }
                case 3:
                    return tt.password;
                case 4:
                    if (tt.user_level == 0) {
                        return "Administrator";
                    }
                    if (tt.user_level == 1) {
                        return "Accounting";
                    }
                    if (tt.user_level == 2) {
                        return "Inventory";
                    }
                    if (tt.user_level == 3) {
                        return "Services";
                    }

                case 5:
                    return tt.date_added;
                case 6:
                    if (tt.is_active == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }

                case 7:
                    return tt.t_sales;
                case 8:
                    return tt.t_receipts;
                case 9:
                    return tt.t_stock_transfer;
                case 10:
                    return tt.m_items;
                case 11:
                    return tt.m_category;
                case 12:
                    return tt.m_users;
                case 13:
                    return tt.m_uom;
                case 14:
                    return tt.m_suppliers;
                case 15:
                    return tt.r_sales;
                case 16:
                    return tt.r_cash_count;
                case 17:
                    return tt.r_receipts;
                case 18:
                    return tt.r_stock_transferred;
                default:
                    return tt.r_stock_take;
            }
        }
    }

    private void data_cols() {

        String where = " where screen_name like '%" + tf_search.getText() + "%' and branch_id='" + tf_from_branch_id.getText() + "' order by screen_name asc ";
        loadData_users(S1_users.ret_where(where));
        jLabel11.setText("" + tbl_users_ALM.size());
    }

    private void add_users() {
        int id = -1;
        String screen_name = tf_screen_name.getText();
        String user_name = tf_user_name.getText();
        String password = tf_password.getText();
        int user_level = 0;
        if (cb_lvl.getSelectedIndex() == 0) {
            user_level = 1;
        }
        if (cb_lvl.getSelectedIndex() == 2) {
            user_level = 2;
        }
        if (cb_lvl.getSelectedIndex() == 3) {
            user_level = 3;
        }

        String date_added = DateType.datetime.format(new Date());
        int is_active = 0;
        if (cb_active.isSelected()) {
            is_active = 1;
        }
        String t_sales = "0";
        if (cb_t_cashier.isSelected()) {
            t_sales = "1";
        }
        String t_receipts = "0";
        if (cb_t_receipts.isSelected()) {
            t_receipts = "1";
        }
        String t_stock_transfer = "0";
        if (cb_t_stock_transfer.isSelected()) {
            t_stock_transfer = "1";
        }
        String m_items = "0";
        if (cb_m_items.isSelected()) {
            m_items = "1";
        }
        String m_category = "0";
        if (cb_m_category.isSelected()) {
            m_category = "1";
        }
        String m_users = "0";
        if (cb_m_users.isSelected()) {
            m_users = "1";
        }
        String m_uom = "0";
        if (cb_m_uom.isSelected()) {
            m_uom = "1";
        }
        String m_suppliers = "0";
        if (cb_m_suppliers.isSelected()) {
            m_suppliers = "1";
        }
        String r_sales = "0";
        if (cb_r_sales.isSelected()) {
            r_sales = "1";
        }
        String r_cash_count = "0";
        if (cb_r_cash_count.isSelected()) {
            r_cash_count = "1";
        }
        String r_receipts = "0";
        if (cb_r_receipts.isSelected()) {
            r_receipts = "1";
        }
        String r_stock_transferred = "0";
        if (cb_r_stock_transferred.isSelected()) {
            r_stock_transferred = "1";
        }
        String r_stock_take = "0";
        if (cb_r_stock_take.isSelected()) {
            r_stock_take = "1";
        }
        String m_customers = "0";
        if (cb_m_customers.isSelected()) {
            m_customers = "1";
        }
        String m_discount = "0";
        if (cb_m_discount.isSelected()) {
            m_discount = "1";
        }
        String m_banks = "0";
        if (cb_m_banks.isSelected()) {
            m_banks = "1";
        }
        String r_stock_left_supplier = "0";
        if (cb_r_stock_left_supplier.isSelected()) {
            r_stock_left_supplier = "1";
        }
        String t_inventory_adjuster = "0";
        if (cb_t_inventory_adjuster.isSelected()) {
            t_inventory_adjuster = "1";
        }
        String t_salesman = "0";
        if (cb_t_salesman.isSelected()) {
            t_salesman = "1";
        }

        final to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, tf_from_branch.getText(), tf_from_branch_id.getText(), tf_from_location.getText(), tf_from_location_id.getText());
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_users.add_users(to);
                data_cols();
                clear_users();
                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void select_users() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_users to = (to_users) tbl_users_ALM.get(tbl_users.
                convertRowIndexToModel(row));
        tf_screen_name.setText(to.screen_name);
        tf_user_name.setText(to.user_name);
        tf_password.setText(to.password);
        if (to.user_level == 0) {
            cb_lvl.setSelectedIndex(1);
        }
        if (to.user_level == 1) {
            cb_lvl.setSelectedIndex(0);
        }
        if (to.user_level == 2) {
            cb_lvl.setSelectedIndex(2);
        }
        if (to.user_level == 3) {
            cb_lvl.setSelectedIndex(3);
        }
        if (to.is_active == 0) {
            cb_active.setSelected(false);
        } else {
            cb_active.setSelected(true);
        }

        data_cols_previleges();
    }

    private void edit_users() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_users to = (to_users) tbl_users_ALM.get(tbl_users.
                convertRowIndexToModel(row));
        int id = to.id;
        String screen_name = tf_screen_name.getText();
        String user_name = tf_user_name.getText();
        String password = tf_password.getText();
        int user_level = 0;
        if (cb_lvl.getSelectedIndex() == 0) {
            user_level = 1;
        }
        if (cb_lvl.getSelectedIndex() == 2) {
            user_level = 2;
        }
        if (cb_lvl.getSelectedIndex() == 3) {
            user_level = 3;
        }
        String date_added = DateType.datetime.format(new Date());
        int is_active = 0;
        if (cb_active.isSelected()) {
            is_active = 1;
        }
        String t_sales = "0";
        if (cb_t_cashier.isSelected()) {
            t_sales = "1";
        }
        String t_receipts = "0";
        if (cb_t_receipts.isSelected()) {
            t_receipts = "1";
        }
        String t_stock_transfer = "0";
        if (cb_t_stock_transfer.isSelected()) {
            t_stock_transfer = "1";
        }
        String m_items = "0";
        if (cb_m_items.isSelected()) {
            m_items = "1";
        }
        String m_category = "0";
        if (cb_m_category.isSelected()) {
            m_category = "1";
        }
        String m_users = "0";
        if (cb_m_users.isSelected()) {
            m_users = "1";
        }
        String m_uom = "0";
        if (cb_m_uom.isSelected()) {
            m_uom = "1";
        }
        String m_suppliers = "0";
        if (cb_m_suppliers.isSelected()) {
            m_suppliers = "1";
        }
        String r_sales = "0";
        if (cb_r_sales.isSelected()) {
            r_sales = "1";
        }
        String r_cash_count = "0";
        if (cb_r_cash_count.isSelected()) {
            r_cash_count = "1";
        }
        String r_receipts = "0";
        if (cb_r_receipts.isSelected()) {
            r_receipts = "1";
        }
        String r_stock_transferred = "0";
        if (cb_r_stock_transferred.isSelected()) {
            r_stock_transferred = "1";
        }
        String r_stock_take = "0";
        if (cb_r_stock_take.isSelected()) {
            r_stock_take = "1";
        }
        String m_customers = "0";
        if (cb_m_customers.isSelected()) {
            m_customers = "1";
        }
        String m_discount = "0";
        if (cb_m_discount.isSelected()) {
            m_discount = "1";
        }
        String m_banks = "0";
        if (cb_m_banks.isSelected()) {
            m_banks = "1";
        }
        String r_stock_left_supplier = "0";
        if (cb_r_stock_left_supplier.isSelected()) {
            r_stock_left_supplier = "1";
        }
        String t_inventory_adjuster = "0";
        if (cb_t_inventory_adjuster.isSelected()) {
            t_inventory_adjuster = "1";
        }
        String t_salesman = "0";
        if (cb_t_salesman.isSelected()) {
            t_salesman = "1";
        }
        final to_users to1 = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, to.branch, to.branch_id, to.location, to.location_id);

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Are you sure you want to update this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_users.edit_users(to1);
                data_cols();
                clear_users();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void clear_users() {
        tf_screen_name.setText("");
        tf_user_name.setText("");
        tf_password.setText("");
    }

    private void delete_users() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_users to = (to_users) tbl_users_ALM.get(tbl_users.
                convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                S1_users.delete_users(to);
                data_cols();
                clear_users();
                Alert.set(3, "");
            }

        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private ArrayListModel tbl_user_default_previleges_ALM;
    private Tbluser_default_previlegesModel tbl_user_default_previleges_M;

    private void init_tbl_user_default_previleges() {
        tbl_user_default_previleges_ALM = new ArrayListModel();
        tbl_user_default_previleges_M = new Tbluser_default_previlegesModel(tbl_user_default_previleges_ALM);
        tbl_user_default_previleges.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_user_default_previleges.setModel(tbl_user_default_previleges_M);
        tbl_user_default_previleges.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_user_default_previleges.setRowHeight(25);
        int[] tbl_widths_user_default_previleges = {100, 100, 60};
        for (int i = 0, n = tbl_widths_user_default_previleges.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_user_default_previleges, i, tbl_widths_user_default_previleges[i]);
        }
        Dimension d = tbl_user_default_previleges.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_user_default_previleges.getTableHeader().setPreferredSize(d);
        tbl_user_default_previleges.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_user_default_previleges.setRowHeight(25);
        tbl_user_default_previleges.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_user_default_previleges(List<to_user_default_previleges> acc) {
        tbl_user_default_previleges_ALM.clear();
        tbl_user_default_previleges_ALM.addAll(acc);
    }

    public static class Tbluser_default_previlegesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Name", "Account", "    Action"
        };

        public Tbluser_default_previlegesModel(ListModel listmodel) {
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
            to_user_default_previleges tt = (to_user_default_previleges) getRow(row);
            switch (col) {
                case 0:
                    return "  " + tt.name;
                case 1:
                    return "  " + tt.account;
                default:
                    return "     ADD";
            }
        }
    }

    private void data_cols_default() {
        String where;
        if (jCheckBox1.isSelected()) {
            where = " order by name asc";
        } else {
            where = " where name like '%" + jTextField2.getText() + "%' and account like '" + jTextField1.getText() + "' order by name asc";
        }
        loadData_user_default_previleges(S1_user_default_previleges.ret_data(where));
    }
    List<Courier.status> accounts_list = new ArrayList();

    private void init_inventory_category(final JTextField tf) {
        String search = tf.getText();
        accounts_list.clear();
        accounts_list = Courier.account_types();
        Object[][] obj = new Object[accounts_list.size()][2];
        int i = 0;
        for (Courier.status to : accounts_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.status;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Courier.status to = accounts_list.
                        get(data.selected_row);
                tf.setText(to.status);
                data_cols_default();
            }
        });
    }

    private void init_inventory_category2(final JTextField tf) {
        String search = tf.getText();
        accounts_list.clear();
        accounts_list = Courier.account_types();
        Object[][] obj = new Object[accounts_list.size()][2];
        int i = 0;
        for (Courier.status to : accounts_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.status;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Courier.status to = accounts_list.
                        get(data.selected_row);
                tf.setText(to.status);
                data_cols_previleges();
            }
        });
    }
    private ArrayListModel tbl_user_previleges_ALM;
    private Tbluser_previlegesModel tbl_user_previleges_M;

    private void init_tbl_user_previleges() {
        tbl_user_previleges_ALM = new ArrayListModel();
        tbl_user_previleges_M = new Tbluser_previlegesModel(tbl_user_previleges_ALM);
        tbl_user_previleges.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_user_previleges.setModel(tbl_user_previleges_M);
        tbl_user_previleges.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_user_previleges.setRowHeight(25);
        int[] tbl_widths_user_previleges = {100, 100, 60, 0, 0, 0};
        for (int i = 0, n = tbl_widths_user_previleges.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_user_previleges, i, tbl_widths_user_previleges[i]);
        }
        Dimension d = tbl_user_previleges.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_user_previleges.getTableHeader().setPreferredSize(d);
        tbl_user_previleges.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_user_previleges.setRowHeight(25);
        tbl_user_previleges.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_user_previleges(List<to_user_previleges> acc) {
        tbl_user_previleges_ALM.clear();
        tbl_user_previleges_ALM.addAll(acc);
    }

    public static class Tbluser_previlegesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Name", "Account", "   Action", "status", "user_id", "user_name"
        };

        public Tbluser_previlegesModel(ListModel listmodel) {
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
            to_user_previleges tt = (to_user_previleges) getRow(row);
            switch (col) {
                case 0:
                    return "   " + tt.previledge;
                case 1:
                    return "   " + tt.account;
                case 2:
                    return "   DELETE";
                case 3:
                    return tt.status;
                case 4:
                    return tt.user_id;
                default:
                    return tt.user_name;
            }
        }
    }

    private void data_cols_previleges() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_users to = (to_users) tbl_users_ALM.get(tbl_users.convertRowIndexToModel(row));
        String where;
        if (jCheckBox2.isSelected()) {
            where = " where user_name='" + to.user_name + "' order by previledge asc ";
        } else {
            where = " where user_name='" + to.user_name + "' "
                    + " and account like '" + jTextField3.getText() + "'"
                    + " order by previledge asc ";
        }
        loadData_user_previleges(S1_user_previleges.ret_data(where));
        jLabel13.setText("" + tbl_user_previleges_ALM.size());
    }

    private void add_user_previleges() {
        int row = tbl_user_default_previleges.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_user_default_previleges to = (to_user_default_previleges) tbl_user_default_previleges_ALM.get(tbl_user_default_previleges.convertRowIndexToModel(row));

        int row2 = tbl_users.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_users to2 = (to_users) tbl_users_ALM.get(row2);

        if (row2 < 0) {
            Alert.set(0, "Please Select User!");
            return;
        }
        int id = -1;
        String account = to.account;
        String previledge = to.name;
        int status = 1;
        String user_id = "" + to2.id;
        String user_name = to2.user_name;
        to_user_previleges to3 = new to_user_previleges(id, account, previledge, status, user_id, user_name);
        int exists = 0;
        List<to_user_previleges> datas = tbl_user_previleges_ALM;
        for (to_user_previleges t : datas) {
            if (previledge.equalsIgnoreCase(t.previledge)) {
                exists = 1;
                break;
            }
        }
        if (exists == 1) {
            Alert.set(0, "Already Added!");
            return;
        }
        S1_user_previleges.add_user_previleges(to3);
        data_cols_previleges();

    }

    private void add_all_previleges() {
        int row2 = tbl_users.getSelectedRow();

        if (row2 < 0) {
            Alert.set(0, "Please Select User!");
            return;
        }
        to_users to2 = (to_users) tbl_users_ALM.get(row2);
        int id = -1;

        List<to_user_previleges> prev = tbl_user_previleges_ALM;
        final List<to_user_previleges> list = new ArrayList();
        List<to_user_default_previleges> selected = tbl_user_default_previleges_ALM;
        for (to_user_default_previleges d : selected) {
            String account = d.account;
            String previledge = d.name;
            int status = 1;
            String user_id = "" + to2.id;
            String user_name = to2.user_name;

            int exists = 0;
            for (to_user_previleges t : prev) {
                if (previledge.equalsIgnoreCase(t.previledge)) {
                    exists = 1;
                    break;
                }
            }
            if (exists == 0) {
                to_user_previleges to3 = new to_user_previleges(id, account, previledge, status, user_id, user_name);
                list.add(to3);

            }
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this records?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S1_user_previleges.add_user_previleges(list);
                data_cols_previleges();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void delete_user_previleges() {
        int row = tbl_user_previleges.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_user_previleges to = (to_user_previleges) tbl_user_previleges_ALM.get(tbl_user_previleges.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                S1_user_previleges.delete_user_previleges(to);
                data_cols_previleges();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void add_cashier_previlege() {
        final int row2 = tbl_users.getSelectedRow();

        if (row2 < 0) {
            Alert.set(0, "Please Select User!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this record?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                to_users to = (to_users) tbl_users_ALM.get(row2);
                List<to_user_previleges> list = new ArrayList();
                String[] previleges = {"Banks",
                    "Disbursements",
                    "Disbursements Report",
                    "Accounts Receivable Payment",
                    "Customers",
                    "Disbursement Categories",
                    "Prepaid Payment",
                    "Credit Card",
                    "Sales",
                    "Cashier Report",
                    "Stock Ledger Report"
                };
                for (String prev : previleges) {
                    to_user_previleges to1 = new to_user_previleges(0, "Sales", prev, 1, "" + to.id, to.user_name);
                    list.add(to1);
                }
                S1_user_previleges.add_user_previleges(list);
                Alert.set(1, "");
                data_cols_previleges();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void add_inventory_previlege() {
        final int row2 = tbl_users.getSelectedRow();

        if (row2 < 0) {
            Alert.set(0, "Please Select User!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this records?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                to_users to = (to_users) tbl_users_ALM.get(row2);
                List<to_user_previleges> list = new ArrayList();
                String[] previleges = {
                    "Banks",
                    "Purchase Order",
                    "Purchase Order Report",
                    "Receipts",
                    "Receipts Report",
                    "Stock Ledger Report",
                    "Stock Transfer",
                    "Stock Transfer Report",
                    "Unit of Measure",
                    "Item Maintenance",
                    "Stocks Status Report",
                    "Stock Take Report",
                    "Stock Take",
                    "Item Barcodes",
                    "Category",
                    "Branches",
                    "Branch Locations",
                    "Suppliers",
                    "Update Barcodes",
                    "Price Inquiry",
                    "Inventory Count",
                    "Print Barcodes",
                    "Finalize Stock Transfer",
                    "RMA",
                    "Print Inventory Count",
                    "Finalize Receipt",
                    "Borrower Slip (Finalize)",
                    "Requistion Slip"
                };
                for (String prev : previleges) {
                    to_user_previleges to1 = new to_user_previleges(0, "Sales", prev, 1, "" + to.id, to.user_name);
                    list.add(to1);
                }
                S1_user_previleges.add_user_previleges(list);
                Alert.set(1, "");
                data_cols_previleges();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void add_accounting_previlege() {
        final int row2 = tbl_users.getSelectedRow();
        if (row2 < 0) {
            Alert.set(0, "Please Select User!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this records?");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                to_users to = (to_users) tbl_users_ALM.get(row2);
                List<to_user_previleges> list = new ArrayList();
                String[] previleges = {
                    "Accounts Receivable",
                    "Accounts Receivable Payment",
                    "AR Aging Report",
                    "Customer's Balances Report",
                    "Customer's Ledger Report",
                    "Customers",
                    "Finalize Account Receivable Payments",
                    "Services Report",
                    "Cashier Report",
                    "Prepaid Payment Finalize",
                    "Prepaid Payment",
                    "AR Items"
                };
                for (String prev : previleges) {
                    to_user_previleges to1 = new to_user_previleges(0, "Sales", prev, 1, "" + to.id, to.user_name);
                    list.add(to1);
                }
                S1_user_previleges.add_user_previleges(list);
                Alert.set(1, "");
                data_cols_previleges();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void add_services_previlege() {
        final int row2 = tbl_users.getSelectedRow();
        if (row2 < 0) {
            Alert.set(0, "Please Select User!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this records?");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                to_users to = (to_users) tbl_users_ALM.get(row2);
                List<to_user_previleges> list = new ArrayList();
                String[] previleges = {
                    "Service Department Members",
                    "Service Departments",
                    "Service Transaction Type",
                    "Services Item Replacement Report",
                    "Services Report",
                    "Services-Transaction"
                };
                for (String prev : previleges) {
                    to_user_previleges to1 = new to_user_previleges(0, "Sales", prev, 1, "" + to.id, to.user_name);
                    list.add(to1);
                }
                S1_user_previleges.add_user_previleges(list);
                Alert.set(1, "");
                data_cols_previleges();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void add_administrator_previlege() {
        final int row2 = tbl_users.getSelectedRow();
        if (row2 < 0) {
            Alert.set(0, "Please Select User!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed adding this records?");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                to_users to = (to_users) tbl_users_ALM.get(row2);
                List<to_user_previleges> list = new ArrayList();
                String[] previleges = {
                    "Backup",
                    "Branch Locations",
                    "Branches",
                    "Cash Count Report",
                    "Discounts",
                    "Preferences",
                    "Themes",
                    "Users",
                    "Banks",
                    "Daily Sales Summary Report",
                    "Disbursements",
                    "Disbursements Report",
                    "Service Transaction Releasing",
                    "Void Items Report",
                    "Voider",
                    "Accounts Payable",
                    "Accounts Receivable",
                    "AR Aging Report",
                    "Category",
                    "Customer's Balances Report",
                    "Customer's Ledger Report",
                    "Customers",
                    "Item Barcodes",
                    "Item Maintenance",
                    "Purchase Order",
                    "Purchase Order Report",
                    "Receipts",
                    "Receipts Report",
                    "Service Department Members",
                    "Service Departments",
                    "Service Transaction Type",
                    "Services Item Replacement Report",
                    "Services Report",
                    "Services-Transaction",
                    "Services-View/Encode",
                    "Stock Ledger Report",
                    "Stock Take",
                    "Stock Take Report",
                    "Stock Transfer",
                    "Stock Transfer Report",
                    "Stocks Status Report",
                    "Unit of Measure",
                    "Finalize Stock Transfer",
                    "Finalize Receipt",
                    "Accounts Receivable Payment",
                    "Finalize Account Receivable Payments",
                    "Sales Report",
                    "Update Barcodes",
                    "Inventory Count Report",
                    "Inventory Count",
                    "Inventory Count (Finalize)",
                    "Borrower Slip",
                    "Borrower Slip (Finalize)",
                    "Cashier CashCount",
                    "Cashier Report",
                    "Credit Card",
                    "Disbursement (View All)",
                    "Disbursement Categories",
                    "Inventory Update Item Pricing",
                    "Prepaid Payment",
                    "Prepaid Payment Finalize",
                    "Sales",
                    "Services-View",
                    "Suppliers",
                    "Void Sales",
                    "Adjuster",
                    "Sales (Choose Location)",
                    "Update CashDrawer",
                    "Charge in Advance",
                    "Inventory Replenishment",
                    "Print Inventory Count",
                    "Print Barcodes",
                    "AR Items",
                    "Update Item Pricing any Branches",
                    "Update Item Pricing per Branch",
                    "Finalize Price Updates"

                };
                for (String prev : previleges) {
                    to_user_previleges to1 = new to_user_previleges(0, "Sales", prev, 1, "" + to.id, to.user_name);
                    list.add(to1);
                }
                S1_user_previleges.add_user_previleges(list);
                Alert.set(1, "");
                data_cols_previleges();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
