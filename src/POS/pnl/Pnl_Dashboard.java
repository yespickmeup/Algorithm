/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.pnl;

import POS.accounts_payable.Dlg_accounts_payable;
import POS.accounts_receivable.Dlg_ar_encoding;
import POS.accounts_receivable.Dlg_ar_items;
import POS.accounts_receivable.Dlg_ar_payments;
import POS.adjuster.Dlg_adjuster_inventory;
import POS.adjuster.Dlg_other_adjustments;
import POS.adjustments.Dlg_adjust_receipt_endorsements;
import POS.backup.Dlg_backup;
import POS.banks.Dlg_banks;
import POS.barcodes.Dlg_barcodes;
import POS.bir.Dlg_reading;
import POS.borrower_slip.Dlg_borrower_slip;
import POS.branch_locations.Dlg_branch_locations;
import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.Dlg_branches;
import POS.cash_drawer.*;
import POS.cash_drawer.CashDrawer.to_cash_drawer;
import POS.category.Dlg_categories;
import POS.category.Dlg_category;
import POS.charge_in_advance.Dlg_charge_in_advance;
import POS.conversion.Dlg_conversion;
import POS.credit_cards.Dlg_credit_cards;
import POS.customers.Dlg_customers_ar;
import POS.disbursements.Dlg_disbursement_categories;
import POS.disbursements.Dlg_disbursements;
import POS.disbursements.Dlg_rpt_disbursement;
import POS.discounts.Dlg_discounts;
import POS.encoding_inventory.Dlg_encode_inventory;
import POS.encoding_inventory.Dlg_finalize_encoding;
import POS.encoding_inventory.Dlg_rpt_encoding_inventory;
import POS.expenses.Dlg_expenses;
import POS.inventory.Dlg_inventory;
import POS.inventory.Dlg_inventory_brand;
import POS.inventory.Dlg_inventory_update_barcode;
import POS.inventory.Dlg_price_inquire;
import POS.inventory.Dlg_print_barcode;
import POS.inventory.Dlg_inventory_price_updates;
import POS.inventory_replenishment.Dlg_inventory_replenishment;
import POS.inventory_reports.Dlg_print_inventory_count;
import POS.inventory_reports.Dlg_reorder_level;
import POS.inventory_reports.Dlg_report_inventory_ledger;
import POS.item_replacements.Dlg_item_replacements;
import static POS.main.MyMain.getSerialNumber;
import POS.my_services.Dlg_my_service_type;
import POS.my_services.Dlg_my_services;
import POS.my_services.Dlg_my_services_crews;
import POS.my_services.Dlg_my_services_departments;
import POS.my_services.Dlg_my_services_view;
import POS.prepaid_payments.Dlg_prepaid_payments;
import POS.purchase_order.Dlg_po2;
import POS.receipt_endorsements.Dlg_receipt_endorsements;
import POS.receipts.Dlg_finalize_receipt;
import POS.receipts.Dlg_receipts;
import POS.reports.*;
import POS.reports2.Dlg_report_customers;
import POS.reports2.Dlg_suppliers_report;
import POS.reports3.Dlg_report_item;
import POS.reports3.Dlg_report_services;
import POS.requisition_slips.Dlg_requisition_slip;
import POS.returns.Dlg_return_from_customer;
import POS.returns.Dlg_return_to_supplier;
import POS.rma.Dlg_rma;
import POS.scripts.Dlg_Local_branch_query_updates;
import POS.scripts.Dlg_Main_branch_query_updates;
import POS.services.Dlg_services;
import POS.settings.Dlg_settings;
import POS.stock_transfer.Dlg_new_stock_transfer;
import POS.stock_transfer.Dlg_stock_transfer_privilege;

import POS.suppliers.Dlg_suppliers;
import POS.synch_locations.Dlg_download_from_cloud;
import POS.synch_locations.Dlg_upload_to_cloud;
import POS.terminals.Dlg_terminal;
import POS.touchscreen.Dlg_touchscreen;
import POS.touchscreen.Dlg_touchscreen_cashcount;
import POS.touchscreen.Dlg_touchscreen_cashier_reports;
import POS.uom.Dlg_uom;
import POS.users.Dlg_login;
import POS.users.Dlg_users;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.users.S1_users;
import POS.users.User_logs;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.DeEncrypter;
import POS.util.Dlg_get_hdd_serial;
import POS.util.Focus_Fire;
import POS.util.MyFrame;
import POS.util.Users;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author i1
 */
public class Pnl_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Pnl_Dashboard
     */
    public Pnl_Dashboard() {
        initComponents();
        myInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        transactions = new javax.swing.JMenu();
        cb_t_encode_inventory = new javax.swing.JMenuItem();
        cb_t_finalize_inventory = new javax.swing.JMenuItem();
        cb_t_salesman = new javax.swing.JMenuItem();
        cb_t_sales = new javax.swing.JMenuItem();
        cb_t_receipts = new javax.swing.JMenuItem();
        cb_t_finalize_receipts = new javax.swing.JMenuItem();
        cb_t_stock_tranfer = new javax.swing.JMenuItem();
        cb_t_inventory_adjuster = new javax.swing.JMenuItem();
        cb_t_purchase_order = new javax.swing.JMenuItem();
        cb_t_voider = new javax.swing.JMenuItem();
        cb_t_ar = new javax.swing.JMenuItem();
        cb_t_ar_encoding = new javax.swing.JMenuItem();
        cb_t_ap = new javax.swing.JMenuItem();
        cb_t_services = new javax.swing.JMenuItem();
        maintenance = new javax.swing.JMenu();
        cb_m_items = new javax.swing.JMenuItem();
        cb_m_category = new javax.swing.JMenuItem();
        cb_m_users = new javax.swing.JMenuItem();
        cb_m_uom = new javax.swing.JMenuItem();
        cb_m_supplier = new javax.swing.JMenuItem();
        cb_m_customers = new javax.swing.JMenuItem();
        cb_m_discounts = new javax.swing.JMenuItem();
        cb_m_banks = new javax.swing.JMenuItem();
        cb_m_services = new javax.swing.JMenuItem();
        cb_m_expenses = new javax.swing.JMenuItem();
        reports = new javax.swing.JMenu();
        cb_r_encoding_inventory = new javax.swing.JMenuItem();
        cb_r_sales = new javax.swing.JMenuItem();
        cb_r_sales_items = new javax.swing.JMenuItem();
        cb_r_cash_count = new javax.swing.JMenuItem();
        cb_r_receipts = new javax.swing.JMenuItem();
        cb_r_stock_transferred = new javax.swing.JMenuItem();
        cb_r_stocks_left_category = new javax.swing.JMenuItem();
        cb_r_stocks_left_supplier = new javax.swing.JMenuItem();
        cb_r_items = new javax.swing.JMenuItem();
        cb_r_purchase_order = new javax.swing.JMenuItem();
        cb_r_voider = new javax.swing.JMenuItem();
        cb_r_stock_status = new javax.swing.JMenuItem();
        cb_r_stock_ledger = new javax.swing.JMenuItem();
        cb_r_customers = new javax.swing.JMenuItem();
        bir = new javax.swing.JMenu();
        cb_b_x_reading = new javax.swing.JMenuItem();
        cb_b_z_reading = new javax.swing.JMenuItem();
        cb_b_reading_trails = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        stand_by = new javax.swing.JMenuItem();
        LOGOUT = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnl_main_holder = new javax.swing.JPanel();
        pnl_login = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_username = new Field.Input();
        jLabel12 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new Button.Primary();
        jLabel2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JDesktopPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPopupMenu1.setBackground(new java.awt.Color(51, 153, 255));

        transactions.setBackground(new java.awt.Color(51, 153, 255));
        transactions.setForeground(new java.awt.Color(255, 255, 255));
        transactions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/master_file.png"))); // NOI18N
        transactions.setText("TRANSACTIONS");
        transactions.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        transactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsActionPerformed(evt);
            }
        });

        cb_t_encode_inventory.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_encode_inventory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_encode_inventory.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_encode_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/branch.png"))); // NOI18N
        cb_t_encode_inventory.setText("ENCODING");
        cb_t_encode_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_encode_inventoryActionPerformed(evt);
            }
        });
        transactions.add(cb_t_encode_inventory);

        cb_t_finalize_inventory.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_finalize_inventory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_finalize_inventory.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_finalize_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/item.png"))); // NOI18N
        cb_t_finalize_inventory.setText("FINALIZE ENCODING");
        cb_t_finalize_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_finalize_inventoryActionPerformed(evt);
            }
        });
        transactions.add(cb_t_finalize_inventory);

        cb_t_salesman.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_salesman.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_salesman.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_salesman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/b_supplier.png"))); // NOI18N
        cb_t_salesman.setText("SALESMAN");
        cb_t_salesman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_salesmanActionPerformed(evt);
            }
        });
        transactions.add(cb_t_salesman);

        cb_t_sales.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_sales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_sales.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/sales.png"))); // NOI18N
        cb_t_sales.setText("CASHIER");
        cb_t_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_salesActionPerformed(evt);
            }
        });
        transactions.add(cb_t_sales);

        cb_t_receipts.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_receipts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_receipts.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_receipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/receipts.png"))); // NOI18N
        cb_t_receipts.setText("RECEIPTS");
        cb_t_receipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_receiptsActionPerformed(evt);
            }
        });
        transactions.add(cb_t_receipts);

        cb_t_finalize_receipts.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_finalize_receipts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_finalize_receipts.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_finalize_receipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/receipts.png"))); // NOI18N
        cb_t_finalize_receipts.setText("FINALIZE RECEIPTS");
        cb_t_finalize_receipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_finalize_receiptsActionPerformed(evt);
            }
        });
        transactions.add(cb_t_finalize_receipts);

        cb_t_stock_tranfer.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_stock_tranfer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_stock_tranfer.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_stock_tranfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/stock_transfer.png"))); // NOI18N
        cb_t_stock_tranfer.setText("STOCK TRANSFER");
        cb_t_stock_tranfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_stock_tranferActionPerformed(evt);
            }
        });
        transactions.add(cb_t_stock_tranfer);

        cb_t_inventory_adjuster.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_inventory_adjuster.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_inventory_adjuster.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_inventory_adjuster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/items.png"))); // NOI18N
        cb_t_inventory_adjuster.setText("INVENTORY ADJUSTER");
        cb_t_inventory_adjuster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_inventory_adjusterActionPerformed(evt);
            }
        });
        transactions.add(cb_t_inventory_adjuster);

        cb_t_purchase_order.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_purchase_order.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_purchase_order.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_purchase_order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/item_references.png"))); // NOI18N
        cb_t_purchase_order.setText("PURCHASE ORDER");
        cb_t_purchase_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_purchase_orderActionPerformed(evt);
            }
        });
        transactions.add(cb_t_purchase_order);

        cb_t_voider.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_voider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_voider.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_voider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/b_drop.png"))); // NOI18N
        cb_t_voider.setText("VOIDER");
        cb_t_voider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_voiderActionPerformed(evt);
            }
        });
        transactions.add(cb_t_voider);

        cb_t_ar.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_ar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_ar.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/sales_registry.png"))); // NOI18N
        cb_t_ar.setText("ACCOUNTS RECEIVABLE");
        cb_t_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_arActionPerformed(evt);
            }
        });
        transactions.add(cb_t_ar);

        cb_t_ar_encoding.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_ar_encoding.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_ar_encoding.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_ar_encoding.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/sales_registry.png"))); // NOI18N
        cb_t_ar_encoding.setText("ACCOUNTS RECEIVABLE ENCODING");
        cb_t_ar_encoding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_ar_encodingActionPerformed(evt);
            }
        });
        transactions.add(cb_t_ar_encoding);

        cb_t_ap.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_ap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_ap.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_ap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/branch.png"))); // NOI18N
        cb_t_ap.setText("ACCOUNTS PAYABLE");
        cb_t_ap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_apActionPerformed(evt);
            }
        });
        transactions.add(cb_t_ap);

        cb_t_services.setBackground(new java.awt.Color(51, 153, 255));
        cb_t_services.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_t_services.setForeground(new java.awt.Color(255, 255, 255));
        cb_t_services.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/branch.png"))); // NOI18N
        cb_t_services.setText("Services");
        cb_t_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_t_servicesActionPerformed(evt);
            }
        });
        transactions.add(cb_t_services);

        jPopupMenu1.add(transactions);

        maintenance.setBackground(new java.awt.Color(51, 153, 255));
        maintenance.setForeground(new java.awt.Color(255, 255, 255));
        maintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/security_manager.png"))); // NOI18N
        maintenance.setText("MAINTENANCE");
        maintenance.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cb_m_items.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_items.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_items.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/items.png"))); // NOI18N
        cb_m_items.setText("ITEM");
        cb_m_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_itemsActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_items);

        cb_m_category.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_category.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/category.png"))); // NOI18N
        cb_m_category.setText("CATEGORY");
        cb_m_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_categoryActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_category);

        cb_m_users.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_users.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_users.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/users.png"))); // NOI18N
        cb_m_users.setText("USERS");
        cb_m_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_usersActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_users);

        cb_m_uom.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_uom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_uom.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_uom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/uom.png"))); // NOI18N
        cb_m_uom.setText("UNIT OF MEASURE");
        cb_m_uom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_uomActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_uom);

        cb_m_supplier.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_supplier.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/suppliers.png"))); // NOI18N
        cb_m_supplier.setText("SUPPLIER");
        cb_m_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_supplierActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_supplier);

        cb_m_customers.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_customers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_customers.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/customer.png"))); // NOI18N
        cb_m_customers.setText("CUSTOMERS");
        cb_m_customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_customersActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_customers);

        cb_m_discounts.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_discounts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_discounts.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_discounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/customer_item_pricing.png"))); // NOI18N
        cb_m_discounts.setText("DISCOUNTS");
        cb_m_discounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_discountsActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_discounts);

        cb_m_banks.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_banks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_banks.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_banks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/item_b.png"))); // NOI18N
        cb_m_banks.setText("BANKS");
        cb_m_banks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_banksActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_banks);

        cb_m_services.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_services.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_services.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_services.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/master_file.png"))); // NOI18N
        cb_m_services.setText("SERVICES");
        cb_m_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_servicesActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_services);

        cb_m_expenses.setBackground(new java.awt.Color(51, 153, 255));
        cb_m_expenses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_m_expenses.setForeground(new java.awt.Color(255, 255, 255));
        cb_m_expenses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/sales_registry.png"))); // NOI18N
        cb_m_expenses.setText("EXPENSES");
        cb_m_expenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_m_expensesActionPerformed(evt);
            }
        });
        maintenance.add(cb_m_expenses);

        jPopupMenu1.add(maintenance);

        reports.setBackground(new java.awt.Color(51, 153, 255));
        reports.setForeground(new java.awt.Color(255, 255, 255));
        reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/item_references.png"))); // NOI18N
        reports.setText("REPORTS");
        reports.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cb_r_encoding_inventory.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_encoding_inventory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_encoding_inventory.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_encoding_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/reference_code.png"))); // NOI18N
        cb_r_encoding_inventory.setText("ENCODING INVENTORY");
        cb_r_encoding_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_encoding_inventoryActionPerformed(evt);
            }
        });
        reports.add(cb_r_encoding_inventory);

        cb_r_sales.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_sales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_sales.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/sales.png"))); // NOI18N
        cb_r_sales.setText("SALES REPORT");
        cb_r_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_salesActionPerformed(evt);
            }
        });
        reports.add(cb_r_sales);

        cb_r_sales_items.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_sales_items.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_sales_items.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_sales_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/sales_ledger.png"))); // NOI18N
        cb_r_sales_items.setText("SALES ITEMS");
        cb_r_sales_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_sales_itemsActionPerformed(evt);
            }
        });
        reports.add(cb_r_sales_items);

        cb_r_cash_count.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_cash_count.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_cash_count.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_cash_count.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/item_b.png"))); // NOI18N
        cb_r_cash_count.setText("CASH COUNT");
        cb_r_cash_count.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_cash_countActionPerformed(evt);
            }
        });
        reports.add(cb_r_cash_count);

        cb_r_receipts.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_receipts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_receipts.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_receipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/receipts.png"))); // NOI18N
        cb_r_receipts.setText("RECEIPTS");
        cb_r_receipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_receiptsActionPerformed(evt);
            }
        });
        reports.add(cb_r_receipts);

        cb_r_stock_transferred.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_stock_transferred.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_stock_transferred.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_stock_transferred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/orders_and_deliveries.png"))); // NOI18N
        cb_r_stock_transferred.setText("STOCK TRANSFER");
        cb_r_stock_transferred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stock_transferredActionPerformed(evt);
            }
        });
        reports.add(cb_r_stock_transferred);

        cb_r_stocks_left_category.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_stocks_left_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_stocks_left_category.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_stocks_left_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/reference_code.png"))); // NOI18N
        cb_r_stocks_left_category.setText("STOCKS LEFT by Category");
        cb_r_stocks_left_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stocks_left_categoryActionPerformed(evt);
            }
        });
        reports.add(cb_r_stocks_left_category);

        cb_r_stocks_left_supplier.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_stocks_left_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_stocks_left_supplier.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_stocks_left_supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/reference_code.png"))); // NOI18N
        cb_r_stocks_left_supplier.setText("STOCKS LEFT by Supplier");
        cb_r_stocks_left_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stocks_left_supplierActionPerformed(evt);
            }
        });
        reports.add(cb_r_stocks_left_supplier);

        cb_r_items.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_items.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_items.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/reference_code.png"))); // NOI18N
        cb_r_items.setText("ITEMS by Category");
        cb_r_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_itemsActionPerformed(evt);
            }
        });
        reports.add(cb_r_items);

        cb_r_purchase_order.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_purchase_order.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_purchase_order.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_purchase_order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/item_references.png"))); // NOI18N
        cb_r_purchase_order.setText("PURCHASE ORDER");
        cb_r_purchase_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_purchase_orderActionPerformed(evt);
            }
        });
        reports.add(cb_r_purchase_order);

        cb_r_voider.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_voider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_voider.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_voider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/b_drop.png"))); // NOI18N
        cb_r_voider.setText("VOIDER");
        cb_r_voider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_voiderActionPerformed(evt);
            }
        });
        reports.add(cb_r_voider);

        cb_r_stock_status.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_stock_status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_stock_status.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_stock_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/reference_code.png"))); // NOI18N
        cb_r_stock_status.setText("STOCK STATUS");
        cb_r_stock_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stock_statusActionPerformed(evt);
            }
        });
        reports.add(cb_r_stock_status);

        cb_r_stock_ledger.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_stock_ledger.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_stock_ledger.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_stock_ledger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/reference_code.png"))); // NOI18N
        cb_r_stock_ledger.setText("STOCK LEDGER");
        cb_r_stock_ledger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stock_ledgerActionPerformed(evt);
            }
        });
        reports.add(cb_r_stock_ledger);

        cb_r_customers.setBackground(new java.awt.Color(51, 153, 255));
        cb_r_customers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_r_customers.setForeground(new java.awt.Color(255, 255, 255));
        cb_r_customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/customer2.png"))); // NOI18N
        cb_r_customers.setText("CUSTOMERS");
        cb_r_customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_customersActionPerformed(evt);
            }
        });
        reports.add(cb_r_customers);

        jPopupMenu1.add(reports);

        bir.setBackground(new java.awt.Color(51, 153, 255));
        bir.setForeground(new java.awt.Color(255, 255, 255));
        bir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/reports.PNG"))); // NOI18N
        bir.setText("BIR");
        bir.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cb_b_x_reading.setBackground(new java.awt.Color(51, 153, 255));
        cb_b_x_reading.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_b_x_reading.setForeground(new java.awt.Color(255, 255, 255));
        cb_b_x_reading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/sales_registry.png"))); // NOI18N
        cb_b_x_reading.setText("X Reading");
        cb_b_x_reading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_b_x_readingActionPerformed(evt);
            }
        });
        bir.add(cb_b_x_reading);

        cb_b_z_reading.setBackground(new java.awt.Color(51, 153, 255));
        cb_b_z_reading.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_b_z_reading.setForeground(new java.awt.Color(255, 255, 255));
        cb_b_z_reading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/sales_ledger.png"))); // NOI18N
        cb_b_z_reading.setText("Z Reading");
        cb_b_z_reading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_b_z_readingActionPerformed(evt);
            }
        });
        bir.add(cb_b_z_reading);

        cb_b_reading_trails.setBackground(new java.awt.Color(51, 153, 255));
        cb_b_reading_trails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_b_reading_trails.setForeground(new java.awt.Color(255, 255, 255));
        cb_b_reading_trails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/stock_status.png"))); // NOI18N
        cb_b_reading_trails.setText("X Reading");
        cb_b_reading_trails.setActionCommand("READING TRAILS");
        cb_b_reading_trails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_b_reading_trailsActionPerformed(evt);
            }
        });
        bir.add(cb_b_reading_trails);

        jPopupMenu1.add(bir);

        help.setBackground(new java.awt.Color(51, 153, 255));
        help.setForeground(new java.awt.Color(255, 255, 255));
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/help.png"))); // NOI18N
        help.setText("HELP");
        help.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPopupMenu1.add(help);

        stand_by.setBackground(new java.awt.Color(51, 153, 255));
        stand_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stand_by.setForeground(new java.awt.Color(255, 255, 255));
        stand_by.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/maintenance.png"))); // NOI18N
        stand_by.setText("STAND BY");
        stand_by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stand_byActionPerformed(evt);
            }
        });
        jPopupMenu1.add(stand_by);

        LOGOUT.setBackground(new java.awt.Color(51, 153, 255));
        LOGOUT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        LOGOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/s_reload.png"))); // NOI18N
        LOGOUT.setText("LOGOUT");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });
        jPopupMenu1.add(LOGOUT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(16, 88, 197));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setFocusable(false);

        jLabel51.setBackground(new java.awt.Color(234, 234, 234));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/menu53.png"))); // NOI18N
        jLabel51.setOpaque(true);
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel51MouseEntered(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("V1.20180906 ( Full Version )");

        jLabel7.setBackground(new java.awt.Color(16, 88, 197));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/smis_logo (Custom)_1.png"))); // NOI18N
        jLabel7.setText("Algorithm");
        jLabel7.setFocusable(false);
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pnl_main_holder.setBackground(new java.awt.Color(204, 204, 204));
        pnl_main_holder.setLayout(new java.awt.CardLayout());

        pnl_login.setBackground(new java.awt.Color(255, 255, 255));

        login.setOpaque(false);

        jLabel8.setBackground(new java.awt.Color(16, 88, 197));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(16, 88, 197));
        jLabel8.setText("Username:");

        tf_username.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(16, 88, 197));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(16, 88, 197));
        jLabel12.setText("Password:");

        tf_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(16, 88, 197));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(16, 88, 197));
        jLabel13.setText("Login with your ");

        jLabel14.setBackground(new java.awt.Color(16, 88, 197));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(16, 88, 197));
        jLabel14.setText("credentials!");

        jButton1.setText("Run Script");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_menu/synapse (Custom).png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel30.setBackground(new java.awt.Color(16, 88, 197));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(16, 88, 197));
        jLabel30.setText("Synapse Software ");

        jLabel31.setBackground(new java.awt.Color(16, 88, 197));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(16, 88, 197));
        jLabel31.setText("Technologies");

        jLabel32.setBackground(new java.awt.Color(16, 88, 197));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(16, 88, 197));
        jLabel32.setText(" Integrating business with technology");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_password, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_username, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel31)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jLabel13)
                .addGap(1, 1, 1)
                .addComponent(jLabel14)
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(1, 1, 1)
                .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_loginLayout = new javax.swing.GroupLayout(pnl_login);
        pnl_login.setLayout(pnl_loginLayout);
        pnl_loginLayout.setHorizontalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_loginLayout.setVerticalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_loginLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_main_holder.add(pnl_login, "card5");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main_holder.add(jPanel1, "card2");

        jPanel6.setBackground(new java.awt.Color(140, 175, 227));

        jLabel10.setBackground(new java.awt.Color(140, 175, 227));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/maximize.png"))); // NOI18N
        jLabel10.setToolTipText("Inventory Adjuster");
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(140, 175, 227));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/purchase1.png"))); // NOI18N
        jLabel16.setToolTipText("Receipts");
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(140, 175, 227));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/pen13.png"))); // NOI18N
        jLabel11.setToolTipText("Inventory Encoding");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(140, 175, 227));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/shop32.png"))); // NOI18N
        jLabel17.setToolTipText("Sales");
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(140, 175, 227));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/computer screen14.png"))); // NOI18N
        jLabel18.setToolTipText("Services");
        jLabel18.setOpaque(true);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(140, 175, 227));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/transfer5.png"))); // NOI18N
        jLabel15.setToolTipText("Stock Transfer");
        jLabel15.setOpaque(true);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(140, 175, 227));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/logistics2.png"))); // NOI18N
        jLabel19.setToolTipText("Purchase Order");
        jLabel19.setOpaque(true);
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(140, 175, 227));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/coins30 (1).png"))); // NOI18N
        jLabel9.setToolTipText("Accounts Receivable");
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(140, 175, 227));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_reports/factories1.png"))); // NOI18N
        jLabel20.setToolTipText("Item Ledger");
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(140, 175, 227));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_reports/team2.png"))); // NOI18N
        jLabel21.setToolTipText("Customers Report");
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(140, 175, 227));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_reports/worker55.png"))); // NOI18N
        jLabel22.setToolTipText("Cashier Report");
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(140, 175, 227));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/shopping73.png"))); // NOI18N
        jLabel23.setToolTipText("Item Maintenance");
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(140, 175, 227));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/manager3.png"))); // NOI18N
        jLabel24.setToolTipText("Users");
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(140, 175, 227));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/hand132 (1).png"))); // NOI18N
        jLabel25.setToolTipText("Accounts Payable");
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(140, 175, 227));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/currency2 (1).png"))); // NOI18N
        jLabel26.setToolTipText("Accounts Receivable Payment");
        jLabel26.setOpaque(true);
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(140, 175, 227));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_transactions/clock154.png"))); // NOI18N
        jLabel27.setToolTipText("RMA");
        jLabel27.setOpaque(true);
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(140, 175, 227));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_reports/logistics2.png"))); // NOI18N
        jLabel28.setToolTipText("Services Report");
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(140, 175, 227));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_reports/work11.png"))); // NOI18N
        jLabel29.setToolTipText("Stock Take");
        jLabel29.setOpaque(true);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(140, 175, 227));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 153, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0");
        jLabel3.setOpaque(true);
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 5, 25, 15));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/bell-musical-tool (2).png"))); // NOI18N
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main_holder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_main_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_m_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_categoryActionPerformed
        category();
    }//GEN-LAST:event_cb_m_categoryActionPerformed

    private void cb_m_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_usersActionPerformed
        users();
    }//GEN-LAST:event_cb_m_usersActionPerformed

    private void cb_m_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_itemsActionPerformed
        items();
    }//GEN-LAST:event_cb_m_itemsActionPerformed

    private void cb_t_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_salesActionPerformed

    }//GEN-LAST:event_cb_t_salesActionPerformed

    private void cb_r_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_salesActionPerformed
        sales_report();
    }//GEN-LAST:event_cb_r_salesActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        cashout();
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void cb_t_receiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_receiptsActionPerformed
        // TODO add your handling code here:
        receipts();
    }//GEN-LAST:event_cb_t_receiptsActionPerformed

    private void cb_t_stock_tranferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_stock_tranferActionPerformed
        // TODO add your handling code here:
        stock_transfer();
    }//GEN-LAST:event_cb_t_stock_tranferActionPerformed

    private void cb_m_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_supplierActionPerformed
        supplier();
    }//GEN-LAST:event_cb_m_supplierActionPerformed

    private void cb_r_cash_countActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_cash_countActionPerformed
        rpt_cash_drawer();
    }//GEN-LAST:event_cb_r_cash_countActionPerformed

    private void cb_r_receiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_receiptsActionPerformed
        // TODO add your handling code here:
        rpt_receipts();
    }//GEN-LAST:event_cb_r_receiptsActionPerformed

    private void cb_r_stock_transferredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stock_transferredActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cb_r_stock_transferredActionPerformed

    private void cb_r_stocks_left_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stocks_left_categoryActionPerformed
        rpt_stock_left_category();
    }//GEN-LAST:event_cb_r_stocks_left_categoryActionPerformed

    private void stand_byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stand_byActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_stand_byActionPerformed

    private void cb_r_sales_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_sales_itemsActionPerformed
        // TODO add your handling code here:
        sales_items();
    }//GEN-LAST:event_cb_r_sales_itemsActionPerformed

    private void cb_m_customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_customersActionPerformed
        m_customers();
    }//GEN-LAST:event_cb_m_customersActionPerformed

    private void cb_m_discountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_discountsActionPerformed
        // TODO add your handling code here:
        m_discount();
    }//GEN-LAST:event_cb_m_discountsActionPerformed

    private void cb_m_uomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_uomActionPerformed
        m_uom();
    }//GEN-LAST:event_cb_m_uomActionPerformed

    private void cb_m_banksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_banksActionPerformed
        // TODO add your handling code here:
        m_banks();
    }//GEN-LAST:event_cb_m_banksActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cashout();
    }//GEN-LAST:event_formWindowClosing

    private void cb_r_stocks_left_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stocks_left_supplierActionPerformed
        // TODO add your handling code here:
        rpt_stock_left_supplier();
    }//GEN-LAST:event_cb_r_stocks_left_supplierActionPerformed

    private void cb_r_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_itemsActionPerformed
        // TODO add your handling code here:
        rpt_items_category();
    }//GEN-LAST:event_cb_r_itemsActionPerformed

    private void cb_t_inventory_adjusterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_inventory_adjusterActionPerformed
        // TODO add your handling code here:
        adjust_inventory();
    }//GEN-LAST:event_cb_t_inventory_adjusterActionPerformed

    private void cb_b_x_readingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_b_x_readingActionPerformed
        // TODO add your handling code here:
        z_reading();
    }//GEN-LAST:event_cb_b_x_readingActionPerformed

    private void cb_m_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_servicesActionPerformed
        // TODO add your handling code here:
        m_services();
    }//GEN-LAST:event_cb_m_servicesActionPerformed

    private void cb_m_expensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_m_expensesActionPerformed
        // TODO add your handling code here:
        m_expenses();
    }//GEN-LAST:event_cb_m_expensesActionPerformed

    private void cb_t_purchase_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_purchase_orderActionPerformed
        // TODO add your handling code here:
        t_purchase_order();
    }//GEN-LAST:event_cb_t_purchase_orderActionPerformed

    private void transactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsActionPerformed
        // TODO add your handling code here:
        t_purchase_order();
    }//GEN-LAST:event_transactionsActionPerformed

    private void cb_b_z_readingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_b_z_readingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_b_z_readingActionPerformed

    private void cb_b_reading_trailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_b_reading_trailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_b_reading_trailsActionPerformed

    private void cb_r_purchase_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_purchase_orderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_r_purchase_orderActionPerformed

    private void cb_t_voiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_voiderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_t_voiderActionPerformed

    private void cb_r_voiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_voiderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_r_voiderActionPerformed

    private void cb_t_salesmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_salesmanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_t_salesmanActionPerformed

    private void cb_t_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_arActionPerformed
        t_ar();
    }//GEN-LAST:event_cb_t_arActionPerformed

    private void cb_t_apActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_apActionPerformed
        t_ap();
    }//GEN-LAST:event_cb_t_apActionPerformed

    private void cb_t_ar_encodingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_ar_encodingActionPerformed
        t_ar_encoding();
    }//GEN-LAST:event_cb_t_ar_encodingActionPerformed

    private void cb_t_finalize_receiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_finalize_receiptsActionPerformed
        t_finalize_receipt();
    }//GEN-LAST:event_cb_t_finalize_receiptsActionPerformed

    private void cb_r_stock_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stock_statusActionPerformed
        r_stock_status();
    }//GEN-LAST:event_cb_r_stock_statusActionPerformed

    private void cb_r_stock_ledgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stock_ledgerActionPerformed
        r_stock_ledger();
    }//GEN-LAST:event_cb_r_stock_ledgerActionPerformed

    private void cb_t_encode_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_encode_inventoryActionPerformed
        t_encoding_inventory();
    }//GEN-LAST:event_cb_t_encode_inventoryActionPerformed

    private void cb_r_encoding_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_encoding_inventoryActionPerformed
        r_encoding_inventory();
    }//GEN-LAST:event_cb_r_encoding_inventoryActionPerformed

    private void cb_t_finalize_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_finalize_inventoryActionPerformed
        t_finalize_encoding();
    }//GEN-LAST:event_cb_t_finalize_inventoryActionPerformed

    private void cb_r_customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_customersActionPerformed
        r_customers();
    }//GEN-LAST:event_cb_r_customersActionPerformed

    private void cb_t_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_t_servicesActionPerformed
        t_services();
    }//GEN-LAST:event_cb_t_servicesActionPerformed

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
//        check_credentials();
        tf_password.grabFocus();
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        check_credentials();
    }//GEN-LAST:event_tf_passwordActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if (jPanel6.isVisible()) {
            jPanel6.setVisible(false);
        } else {
            jPanel6.setVisible(true);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel7MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        run_script();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        menu();
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        check_credentials();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        t_adjuster();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered

    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        receipts();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered

    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        t_encoding_inventory();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered


    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        t_tavern(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered

    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        t_services();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered

    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        stock_transfer();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered

    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        t_purchase_order();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered

    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        t_ar_encoding();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered

    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        rpt_stock_ledger();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered

    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        r_customers();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered

    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        rpt_cashier_report();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered

    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        m_items();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered

    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        users();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered

    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        t_ap();
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered

    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        t_ar_payments();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered

    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        t_rma();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered

    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        r_services();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered

    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        rpt_stock_status();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered

    }//GEN-LAST:event_jLabel29MouseEntered

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        jPanel9.setBackground(new java.awt.Color(140, 175, 227));
    }//GEN-LAST:event_jPanel9MouseExited

    private void jLabel51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Application.setSystemLookAndFeel();
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Pnl_Dashboard aw = new Pnl_Dashboard();

                Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/POS/img_menu/synapse.png"));
                aw.setIconImage(image);

                String url = "/POS/img/5.png";
                Toolkit tk = Toolkit.getDefaultToolkit();
                int xSize = ((int) tk.getScreenSize().
                        getWidth());
                int ySize = ((int) tk.getScreenSize().
                        getHeight());
                aw.setSize(xSize, ySize);
                Dimension d = aw.jPanel1.getSize();
                aw.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LOGOUT;
    private javax.swing.JMenu bir;
    private javax.swing.JMenuItem cb_b_reading_trails;
    private javax.swing.JMenuItem cb_b_x_reading;
    private javax.swing.JMenuItem cb_b_z_reading;
    private javax.swing.JMenuItem cb_m_banks;
    private javax.swing.JMenuItem cb_m_category;
    private javax.swing.JMenuItem cb_m_customers;
    private javax.swing.JMenuItem cb_m_discounts;
    private javax.swing.JMenuItem cb_m_expenses;
    private javax.swing.JMenuItem cb_m_items;
    private javax.swing.JMenuItem cb_m_services;
    private javax.swing.JMenuItem cb_m_supplier;
    private javax.swing.JMenuItem cb_m_uom;
    private javax.swing.JMenuItem cb_m_users;
    private javax.swing.JMenuItem cb_r_cash_count;
    private javax.swing.JMenuItem cb_r_customers;
    private javax.swing.JMenuItem cb_r_encoding_inventory;
    private javax.swing.JMenuItem cb_r_items;
    private javax.swing.JMenuItem cb_r_purchase_order;
    private javax.swing.JMenuItem cb_r_receipts;
    private javax.swing.JMenuItem cb_r_sales;
    private javax.swing.JMenuItem cb_r_sales_items;
    private javax.swing.JMenuItem cb_r_stock_ledger;
    private javax.swing.JMenuItem cb_r_stock_status;
    private javax.swing.JMenuItem cb_r_stock_transferred;
    private javax.swing.JMenuItem cb_r_stocks_left_category;
    private javax.swing.JMenuItem cb_r_stocks_left_supplier;
    private javax.swing.JMenuItem cb_r_voider;
    private javax.swing.JMenuItem cb_t_ap;
    private javax.swing.JMenuItem cb_t_ar;
    private javax.swing.JMenuItem cb_t_ar_encoding;
    private javax.swing.JMenuItem cb_t_encode_inventory;
    private javax.swing.JMenuItem cb_t_finalize_inventory;
    private javax.swing.JMenuItem cb_t_finalize_receipts;
    private javax.swing.JMenuItem cb_t_inventory_adjuster;
    private javax.swing.JMenuItem cb_t_purchase_order;
    private javax.swing.JMenuItem cb_t_receipts;
    private javax.swing.JMenuItem cb_t_sales;
    private javax.swing.JMenuItem cb_t_salesman;
    private javax.swing.JMenuItem cb_t_services;
    private javax.swing.JMenuItem cb_t_stock_tranfer;
    private javax.swing.JMenuItem cb_t_voider;
    private javax.swing.JMenu help;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JDesktopPane jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel login;
    private javax.swing.JMenu maintenance;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JPanel pnl_main_holder;
    private javax.swing.JMenu reports;
    private javax.swing.JMenuItem stand_by;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    private javax.swing.JMenu transactions;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_algorithm");
//        MyUser.setUser_id("" + 1);
        String environment = System.getProperty("environment", "production");
        if (environment.equalsIgnoreCase("development")) {
            jButton1.setVisible(true);
        } else {
            jButton1.setVisible(false);
        }
        jPanel9.setVisible(false);
        key();
        String business_name = System.getProperty("business_name", "Synapse Software Technologies");
        jLabel7.setText(business_name);
        String version = System.getProperty("version", "");
        String license_code = System.getProperty("license_code", "");
        license_code = DeEncrypter.decrypt(license_code);
        if (license_code.equalsIgnoreCase("trial version")) {
            jLabel1.setText("Trial Version");
            String where1 = "order by id asc limit 1";
            String where2 = "order by id desc limit 1";
            List<User_logs.to_user_logs> first = User_logs.ret_data(where1);
            List<User_logs.to_user_logs> last = User_logs.ret_data(where2);
            if (!first.isEmpty()) {
                User_logs.to_user_logs f = (User_logs.to_user_logs) first.get(0);
                User_logs.to_user_logs l = (User_logs.to_user_logs) last.get(0);

                Date date_from = new Date();
                Date date_to = new Date();
                try {
                    date_from = DateType.datetime.parse(f.created_at);
                    date_to = DateType.datetime.parse(l.created_at);

                } catch (ParseException ex) {
                    Logger.getLogger(Pnl_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }

                int count = DateUtils1.count_days(date_from, date_to);
                int expiry = 30 - count;
                if (expiry <= 0) {
                    Window p = (Window) this;
                    Dlg_expiry nd = Dlg_expiry.create(p, true);
                    nd.setTitle("");
                    nd.setCallback(new Dlg_expiry.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_expiry.OutputData data) {
                            closeDialog.ok();

                        }
                    });
                    nd.setLocationRelativeTo(this);
                    nd.setVisible(true);
                }
                is_trial_version = 1;
                jLabel1.setText("" + version + " ( Trial Version ) - Expires in " + expiry + " day/s");
            } else {
                System.out.println("User Log is empty!");
            }

        }

        Border empty = new EmptyBorder(0, 5, 0, 0);
        CompoundBorder border = javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(16, 88, 197), 1, false), empty);
        jLabel7.setBorder(border);

        time();
        focus();
        set_card_items();
        set_default_branch();
        hover();
        tf_username.grabFocus();

        client_label_request();
    }
    int is_trial_version = 0;

    private void client_label_request() {
        String pool_db = System.getProperty("pool_db", "db_algorithm");
        if (pool_db.equalsIgnoreCase("db_smis_guihulngan")) {
            jLabel16.setToolTipText("Receiving");
        }
    }
    int count = 0;

    private void key() {
        final String is_main_server = System.getProperty("is_main_server", "false");

        tf_username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F5) {
                    if (is_main_server.equals("true")) {
                        asynch();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_F10) {
                    if (count == 2) {
                        license_code();
                        count = 0;
                    }
                    count++;
                }
            }
        });
    }

    private void license_code() {
        Window p = (Window) this;
        Dlg_get_hdd_serial nd = Dlg_get_hdd_serial.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_get_hdd_serial.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_get_hdd_serial.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void asynch() {
        String is_main_server = System.getProperty("is_main_server", "false");
        String unit_type = System.getProperty("unit_type", "local_branch_server");
        if (is_main_server.equalsIgnoreCase("true")) {
            if (unit_type.equalsIgnoreCase("main_branch_server")) {
                Window p = (Window) this;
                Dlg_Main_branch_query_updates nd = Dlg_Main_branch_query_updates.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_Main_branch_query_updates.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_Main_branch_query_updates.OutputData data) {
                        closeDialog.ok();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
            if (unit_type.equalsIgnoreCase("local_branch_server")) {
                Window p = (Window) this;
                Dlg_Local_branch_query_updates nd = Dlg_Local_branch_query_updates.create(p, true);
                nd.setTitle("");
                nd.setCallback(new Dlg_Local_branch_query_updates.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_Local_branch_query_updates.OutputData data) {
                        closeDialog.ok();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
    }

    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void hover() {
        JLabel[] lbl = {jLabel10, jLabel16, jLabel11, jLabel17, jLabel18, jLabel15, jLabel19, jLabel9, jLabel20, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29};
        for (final JLabel l : lbl) {
            l.setVisible(false);
            l.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (l.isEnabled()) {
                        l.setBackground(new java.awt.Color(255, 255, 255));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (l.isEnabled()) {
                        l.setBackground(new java.awt.Color(140, 175, 227));
                    }
                }
            });
        }

    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;
        MyUser.setBranch(my_branch);
        MyUser.setBranch_id(my_branch_id);
        MyUser.setLocation(my_location);
        MyUser.setLocation_id(my_location_id);

    }

    private void focus() {
        JTextField[] tf = {};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }
    CardLayout cardLayout = new CardLayout();

    private void set_card_items() {
        cardLayout = (CardLayout) pnl_main_holder.getLayout();

        cardLayout.addLayoutComponent("1", pnl_login);
        cardLayout.addLayoutComponent("2", jPanel1);

    }

    private void time() {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Timer ti = new Timer(1000, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        Calendar currentCalendar = Calendar.getInstance();
//                        Date currentTime = currentCalendar.getTime();
//
//
//                    }
//                });
//                ti.start();
//            }
//        });
//        t.start();
    }

    public void wallpaper(Pnl_Dashboard f) {

//        String url = "/POS/img_wallpaper/1238-hexagons-1680x1050-digital-art-wallpaper.jpg";
//        Wallpaper.do_set(url, f.jPanel1);
    }

    public JDesktopPane pane() {
        return jPanel1;
    }

//    public JXPanel pane2() {
//        return jXPanel2;
//    }
    public void login() {
        Window p = (Window) this;
        Dlg_login nd = Dlg_login.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_login.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_login.OutputData data) {
                closeDialog.ok();
                jPanel1.removeAll();
                jPanel1.updateUI();
                set_account();
            }
        });
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - nd.getWidth()) / 2;
        final int y = (screenSize.height - nd.getHeight()) / 2;
        nd.setLocation(0, y);
        nd.setSize(xSize, 50);
        nd.setVisible(true);

    }

    private void set_account() {

    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));
    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(139, 125, 107));
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void hover2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(29, 141, 253));
//        lbl.setForeground(new java.awt.Color(0, 0, 0));
    }

    private void exit2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(51, 153, 255));
//        lbl.setForeground(new java.awt.Color(51, 153, 255));
    }

    private void pm_tbl_users() {

//        Point l = jLabel7.getLocation();
//        jPopupMenu1.show(this, l.x, l.y + 34);
    }

    private void users() {
        Dlg_users dtc = new Dlg_users();
        MyFrame.set(dtc.getSurface(), jPanel1, "Users");
    }

    private void items() {
        Dlg_inventory dtc = new Dlg_inventory();
        MyFrame.set(dtc.getSurface(), jPanel1, "Inventory");
    }

    private void category() {
        Dlg_category dtc = new Dlg_category();
        MyFrame.set(dtc.getSurface(), jPanel1, "Category");
    }

    private void sales_report() {
        Dlg_report_all_sales dtc = new Dlg_report_all_sales();
        MyFrame.set(dtc.getSurface(), jPanel1, "Sales by Transaction Report");
    }

    private void cashout() {

        final String user_name = Users.get_UserName();
        String date = DateType.sf.format(new Date());
        S1_cash_drawer.to_cash_drawer to1 = S1_cash_drawer.ret_data2(user_name, date);

        if (Users.user_level == 0) {
            System.exit(1);
        } else {

            if (Users.is_active == 0) {
                Window p = (Window) this;
                Dlg_cash_out nd = Dlg_cash_out.create(p, true);
                nd.setTitle("");
                nd.do_pass();
                nd.setCallback(new Dlg_cash_out.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_cash_out.OutputData data) {
                        closeDialog.ok();
                        S1_cash_drawer.edit_cash_drawer(data.drawer);
                        S1_cash_drawer_checks.
                                add_cash_drawer_checks(data.drawer.checks);
                        S1_cash_drawer_expenses.
                                add_cash_drawer_checks(data.drawer.exp);

                        Alert.set(0, "THANK YOU, HAVE A NICE DAY");
                        System.exit(1);
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

            if (Users.is_active == 1) {
                Window p = (Window) this;
                Dlg_cash_out nd = Dlg_cash_out.create(p, true);
                nd.setTitle("");
                nd.do_pass();
                nd.setCallback(new Dlg_cash_out.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_cash_out.OutputData data) {
                        closeDialog.ok();
                        S1_cash_drawer.edit_cash_drawer(data.drawer);
                        Alert.set(0, "THANK YOU, HAVE A NICE DAY");
                        System.exit(1);
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

        }
    }

    private void receipts() {
        Dlg_receipts dtc = new Dlg_receipts();
        MyFrame.set(dtc.getSurface(), jPanel1, "Receipts");
    }

    private void sales_items() {
        Dlg_sales_by_item dtc = new Dlg_sales_by_item();
        MyFrame.set(dtc.getSurface(), jPanel1, "Sales by Item Report");
    }

    private void stock_transfer() {
        Dlg_new_stock_transfer dtc = new Dlg_new_stock_transfer();
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Transfer");
    }

    private void supplier() {
        Dlg_suppliers dtc = new Dlg_suppliers();
        MyFrame.set(dtc.getSurface(), jPanel1, "Suppliers");
    }

    private void rpt_cash_drawer() {
        Dlg_rpt_cashdrawer dtc = new Dlg_rpt_cashdrawer();
        MyFrame.set(dtc.getSurface(), jPanel1, "Cashdrawer");
    }

    private void rpt_receipts() {
        Dlg_report_receipts dtc = new Dlg_report_receipts();
        MyFrame.set(dtc.getSurface(), jPanel1, "Receipts");
    }

    private void rpt_stock_left_category() {
        Dlg_report_stock_left_category dtc = new Dlg_report_stock_left_category();
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Status by Category");
    }

    private void rpt_stock_left_supplier() {
        Dlg_report_stock_left_supplier dtc = new Dlg_report_stock_left_supplier();
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Status by Supplier");
    }

    private void rpt_items_category() {
        Dlg_report_items_by_category dtc = new Dlg_report_items_by_category();
        MyFrame.set(dtc.getSurface(), jPanel1, "Items by Category Report");
    }

    private void rpt_stock_ledger() {
        Dlg_report_inventory_ledger dtc = new Dlg_report_inventory_ledger();
        MyFrame.set(dtc.getSurface(), jPanel1, "Item Ledger");
    }

    private void rpt_stock_status() {
        Dlg_report_item dtc = new Dlg_report_item();
        dtc.do_pass(stock_take_view_only);
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Take Report");
    }

    private void rpt_stock_status2() {
        Dlg_report_item dtc = new Dlg_report_item();
        dtc.do_pass2();
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Take (No Cost)");
    }

    private void rpt_inventory_count() {
        Dlg_rpt_encoding_inventory dtc = new Dlg_rpt_encoding_inventory();
        MyFrame.set(dtc.getSurface(), jPanel1, "Inventory Count Report");
    }

    private void rpt_cashier_report() {
        Dlg_touchscreen_cashier_reports dtc = new Dlg_touchscreen_cashier_reports();
        MyFrame.set(dtc.getSurface(), jPanel1, "Cashier Report");
    }

    private void m_discount() {
        Dlg_discounts dtc = new Dlg_discounts();
        MyFrame.set(dtc.getSurface(), jPanel1, "Discounts");
    }

    private void m_uom() {
        Dlg_uom dtc = new Dlg_uom();
        MyFrame.set(dtc.getSurface(), jPanel1, "Unit of Measure");
    }

    private void m_banks() {
        Dlg_banks dtc = new Dlg_banks();
        MyFrame.set(dtc.getSurface(), jPanel1, "Bank");
    }

    private void adjust_inventory() {
        Dlg_adjuster_inventory dtc = new Dlg_adjuster_inventory();
        MyFrame.set(dtc.getSurface(), jPanel1, "Inventory Adjuster");
    }

    private void z_reading() {
        Window p = (Window) this;
        Dlg_touchscreen_cashier_reports nd = Dlg_touchscreen_cashier_reports.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_cashier_reports.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_cashier_reports.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void t_purchase_order() {
        Dlg_po2 dtc = new Dlg_po2();
        MyFrame.set(dtc.getSurface(), jPanel1, "Purchase Order");
    }

    private void t_tavern(int lock_session) {
        String where = " where user_id='" + MyUser.getUser_id() + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        if (lock_session == 1) {
            Alert.set(0, "Session locked! Contact administrator");
        } else {
            int is_salesman = 0;
            int is_cashier = 0;
            int can_choose_location = 0;
            for (S1_user_previleges.to_user_previleges to : datas) {
                if (to.previledge.equalsIgnoreCase("Sales")) {
                    is_cashier = 1;
                }
                if (to.previledge.equalsIgnoreCase("Salesman")) {
                    is_salesman = 1;
                }
                if (to.previledge.equalsIgnoreCase("Sales (Choose Location)")) {
                    can_choose_location = 1;
                }
            }
            Window p = (Window) this;
            Dlg_touchscreen nd = Dlg_touchscreen.create(p, true);
            nd.setTitle("");
            nd.do_pass(is_salesman, is_cashier, can_choose_location);
            MyFrame.set(nd.getSurface(), jPanel1, "");
        }

    }

    private void m_services() {
        Dlg_services dtc = new Dlg_services();
        MyFrame.set(dtc.getSurface(), jPanel1, "Services");
    }

    private void m_expenses() {
        Dlg_expenses dtc = new Dlg_expenses();
        MyFrame.set(dtc.getSurface(), jPanel1, "Expenses");
    }

    private void t_ar() {
//        Dlg_accounts_receivable dtc = new Dlg_accounts_receivable();
//        MyFrame.set(dtc.getSurface(), jPanel1, "AR");
    }

    private void t_ar_encoding() {
        Dlg_ar_encoding dtc = new Dlg_ar_encoding();
        MyFrame.set(dtc.getSurface(), jPanel1, "Accounts Receivable");
    }

    private void t_ar_payments() {
        Dlg_ar_payments dtc = new Dlg_ar_payments();
        MyFrame.set(dtc.getSurface(), jPanel1, "Accounts Receivable Payments");
    }

    private void t_ap() {
        Dlg_accounts_payable dtc = new Dlg_accounts_payable();

        MyFrame.set(dtc.getSurface(), jPanel1, "Accounts Payable");
    }

    private void t_returns_from_customer() {
        Dlg_return_from_customer dtc = new Dlg_return_from_customer();
        MyFrame.set(dtc.getSurface(), jPanel1, "Return/s from Customer");
    }

    private void t_return_exchange() {
        Dlg_item_replacements dtc = new Dlg_item_replacements();
        MyFrame.set(dtc.getSurface(), jPanel1, "Return Exchange");
    }

    private void t_returns_to_supplier() {
        Dlg_return_to_supplier dtc = new Dlg_return_to_supplier();
        MyFrame.set(dtc.getSurface(), jPanel1, "Return to supplier");
    }

    private void t_conversions() {
        Dlg_conversion dtc = new Dlg_conversion();

        MyFrame.set(dtc.getSurface(), jPanel1, "Conversions");
    }

    private void t_rma() {
        Dlg_rma dtc = new Dlg_rma();
        MyFrame.set(dtc.getSurface(), jPanel1, "RMA");
    }

    private void t_finalize_receipt() {
        Dlg_finalize_receipt dtc = new Dlg_finalize_receipt();
        MyFrame.set(dtc.getSurface(), jPanel1, "Finalize Receipt");
    }

    private void t_requisition_slip() {
        Dlg_requisition_slip dtc = new Dlg_requisition_slip();
        MyFrame.set(dtc.getSurface(), jPanel1, "Requisition Slip");
    }

    private void t_other_adjustments() {
        Dlg_other_adjustments dtc = new Dlg_other_adjustments();
        MyFrame.set(dtc.getSurface(), jPanel1, "Other Adjustments");
    }

    private void t_receipt_endorsement() {
        Dlg_receipt_endorsements dtc = new Dlg_receipt_endorsements();
        MyFrame.set(dtc.getSurface(), jPanel1, "Receipt Endorsement");
    }

    private void r_stock_status() {
        Dlg_stock_status dtc = new Dlg_stock_status();
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Status");
    }

    private void r_stock_ledger() {
        Dlg_stock_ledger dtc = new Dlg_stock_ledger();
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Ledger");
    }

    private void t_encoding_inventory() {
        Dlg_encode_inventory dtc = new Dlg_encode_inventory();
        MyFrame.set(dtc.getSurface(), jPanel1, "Inventory Count");
    }

    private void r_encoding_inventory() {
        Dlg_report_encoding_inventory dtc = new Dlg_report_encoding_inventory();
        MyFrame.set(dtc.getSurface(), jPanel1, "Stock Take Report");
    }

    private void t_finalize_encoding() {
        Dlg_finalize_encoding dtc = new Dlg_finalize_encoding();
        MyFrame.set(dtc.getSurface(), jPanel1, "Finalize Inventory Encoding");
    }

    private void r_customers() {
        Dlg_report_customers rpt = new Dlg_report_customers();
        MyFrame.set(rpt.getSurface(), jPanel1, "Customers");

    }

    private void r_suppliers() {
        Dlg_suppliers_report rpt = new Dlg_suppliers_report();
        MyFrame.set(rpt.getSurface(), jPanel1, "Suppliers - Report");

    }

    private void r_disbursement() {
        Dlg_rpt_disbursement rpt = new Dlg_rpt_disbursement();
        MyFrame.set(rpt.getSurface(), jPanel1, "Disbursements Report");

    }

    private void r_reorder_level() {
        Dlg_reorder_level rpt = new Dlg_reorder_level();
        MyFrame.set(rpt.getSurface(), jPanel1, "Re-Order Level");

    }

    private void t_services() {

        Dlg_my_services rpt = new Dlg_my_services();
        MyFrame.set(rpt.getSurface(), jPanel1, "Services");
    }

    private void t_services_view() {
        Dlg_my_services rpt = new Dlg_my_services();
        rpt.do_view_only();
        MyFrame.set(rpt.getSurface(), jPanel1, "Services (Add)");
    }

    private void t_services_view2() {
        Dlg_my_services_view rpt = new Dlg_my_services_view();

        MyFrame.set(rpt.getSurface(), jPanel1, "Services (View)");
    }

    private void r_services() {
        Dlg_report_services rpt = new Dlg_report_services();
        MyFrame.set(rpt.getSurface(), jPanel1, "Services");
    }

    private void m_items() {
        Dlg_inventory rpt = new Dlg_inventory();
        MyFrame.set(rpt.getSurface(), jPanel1, "Item Maintenance");
    }

    private void m_items_location() {
        Dlg_inventory_brand rpt = new Dlg_inventory_brand();
        MyFrame.set(rpt.getSurface(), jPanel1, "Item Maintenance per Location");
    }

    private void check_credentials() {
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (!os.equalsIgnoreCase("Linux")) {
            String license_code = System.getProperty("license_code", "");
            String hdd_license = DeEncrypter.encrypt(getSerialNumber());
            String environment = System.getProperty("environment", "production");
            if (environment.equalsIgnoreCase("development")) {
                System.out.println("hdd_license: " + hdd_license);
            }

            if (!license_code.equals(hdd_license) && is_trial_version == 0) {
                Alert.set(0, "Invalid license key, please register!");
                return;
            }
        }

        String user_name = tf_username.getText();
        String date = DateType.sf.format(new Date());
        String password = tf_password.getText();
        final S1_users.to_users to = S1_users.ret_data_autho(user_name, password);

        if (to == null) {
            tf_username.setText("");
            tf_password.setText("");
            tf_username.grabFocus();
            Alert.set(0, "Wrong Username/Password!!");
        } else {
            if (!to.branch_id.equalsIgnoreCase(my_branch_id)) {
                Alert.set(0, "Account Cannot Log-in to this branch!");
                return;
            }
            tf_username.setText("");
            tf_password.setText("");
            Users.setUser_name(user_name);
            Users.setScreen_name(to.screen_name);
            Users.setPassword("" + to.id);
            MyUser.user_id = "" + to.id;
            MyUser.user_name = to.user_name;
            MyUser.user_screen_name = to.screen_name;
            int id = 0;
            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();
            String ip_address = System.getProperty("local_ip");
            String created_at = DateType.now();
            String updated_at = DateType.now();
            String created_by = "";
            String updated_by = "";
            User_logs.to_user_logs logs = new User_logs.to_user_logs(id, user_id, user_screen_name, ip_address, created_at, updated_at, created_by, updated_by);
            User_logs.add_data(logs);
            jPanel1.removeAll();
            jPanel1.updateUI();
            set_previleges();
            cardLayout.show(pnl_main_holder, "2");
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" privileges ">
    private void set_previleges() {
        String where = " where user_id='" + MyUser.getUser_id() + "' group by previledge order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
        for (S1_user_previleges.to_user_previleges to : datas) {

            if (to.previledge.equalsIgnoreCase("Sales - (View)")) {
                cashin();
                jPanel6.setVisible(false);
            }
            if (to.previledge.equalsIgnoreCase("Salesman")) {
//                t_tavern();
            }
            //<editor-fold defaultstate="collapsed" desc=" menu icons ">

            if (to.previledge.equalsIgnoreCase("Accounts Payable - (View)")) {
                jLabel25.setVisible(true);
            }
            if (to.previledge.equalsIgnoreCase("Accounts Receivable - (View)")) {
                jLabel9.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Purchase Order - (View)")) {
                jLabel19.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Receipts - (View)")) {
                jLabel16.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Services - (View)")) {
                jLabel18.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Stock Transfer - (View)")) {
                jLabel15.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Sales - (View)")) {
                jLabel17.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Inventory Encoding - (View)")) {
                jLabel11.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Inventory Adjuster - (View)")) {
                jLabel10.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("RMA - (View)")) {

                jLabel27.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Item Maintenance - (View)")) {
                jLabel23.setVisible(true);
            }
            if (to.previledge.equalsIgnoreCase("Users - (View)")) {
                jLabel24.setVisible(true);
            }

            if (to.previledge.equalsIgnoreCase("Customer - (View)")) {
                jLabel21.setVisible(true);
            }
            if (to.previledge.equalsIgnoreCase("Item Ledger - (View)")) {
                jLabel20.setVisible(true);
            }
            if (to.previledge.equalsIgnoreCase("Cashier Report - (View)")) {
                jLabel22.setVisible(true);
            }
            if (to.previledge.equalsIgnoreCase("Services - (View)")) {
                jLabel28.setVisible(true);
            }
            if (to.previledge.equalsIgnoreCase("Stock Take - (View)")) {
                jLabel29.setVisible(true);
            }
            //</editor-fold>
        }
    }

    //</editor-fold>
    private void cashin() {

        final String user_name = Users.get_UserName();
        String date = DateType.sf.format(new Date());
        S1_cash_drawer.to_cash_drawer to1 = S1_cash_drawer.ret_data2(user_name, date);
        String where = " where user_id='" + MyUser.getUser_id() + "' and time_out IS NULL order by id desc limit 1";
        List<to_cash_drawer> drawers = CashDrawer.ret_where(where);

        if (!drawers.isEmpty()) {
//            System.out.println("asdad");
            final to_cash_drawer to = (to_cash_drawer) drawers.get(0);
            Window p = (Window) this;
            Dlg_cashin nd = Dlg_cashin.create(p, true);
            nd.setTitle("");
            nd.do_pass(to);
            nd.setCallback(new Dlg_cashin.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
                    closeDialog.ok();

                    t_tavern(to.lock_session);
                }

                @Override
                public void close(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
                    closeDialog.ok();
                    t_tavern(to.lock_session);
                }

            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else {

            Window p = (Window) this;
            Dlg_cashin nd = Dlg_cashin.create(p, true);
            nd.setTitle("");
            nd.do_pass_new_login();
            nd.setCallback(new Dlg_cashin.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
                    closeDialog.ok();

                    t_tavern(0);
                }

                @Override
                public void close(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
                    closeDialog.ok();
                    t_tavern(0);
                }

            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
//        if (to1 == null) {
//
//        } else {
//            t_tavern(to.lock_session);
////            String multi_cashin = System.getProperty("multi_cashin", "false");
////            if (multi_cashin.equalsIgnoreCase("true")) {
////                Window p = (Window) this;
////                Dlg_cashin nd = Dlg_cashin.create(p, true);
////                nd.setTitle("");
////                nd.do_pass();
////                nd.setCallback(new Dlg_cashin.Callback() {
////                    @Override
////                    public void ok(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
////                        closeDialog.ok();
//////                        int id = 1;
//////                        String session_no = MyUser.getUser_id();
//////                        String user_name1 = MyUser.getUser_name();
//////                        String screen_name1 = MyUser.getUser_screen_name();
//////                        String time_in = DateType.datetime.format(new Date());
//////                        String time_out = null;
//////                        double amount = data.amount;
//////                        String branch = my_branch;
//////                        String branch_id = my_branch_id;
//////                        String location = my_location;
//////                        String location_id = my_location_id;
//////                        String user_id = MyUser.getUser_id();
//////                        String user_screen_name = MyUser.getUser_screen_name();
//////                        S1_cash_drawer.to_cash_drawer to2 = new S1_cash_drawer.to_cash_drawer(id, session_no, user_name1, screen_name1, time_in, time_out, amount, 0, 0, 0, 0, 0, 0, 0, 0, new ArrayList(), new ArrayList(), 0, 0, 0, 0, 0, 0, 0, 0, branch, branch_id, location, location_id, user_id, user_screen_name);
//////                        S1_cash_drawer.add_cash_drawer(to2);
////                        t_tavern();
////                    }
////
////                    @Override
////                    public void close(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
////                        closeDialog.ok();
////                        t_tavern();
////                    }
////                });
////                nd.setLocationRelativeTo(this);
////                nd.setVisible(true);
////            } else {
////             
////            }
//
//        }

    }

    private void m_branches() {
        Dlg_branches rpt = new Dlg_branches();
        MyFrame.set2(rpt.getSurface(), jPanel1, "Branches ", rpt.getWidth(), rpt.getHeight());
    }

    private void m_branch_locations() {
        Dlg_branch_locations rpt = new Dlg_branch_locations();
        MyFrame.set2(rpt.getSurface(), jPanel1, "Branch Locations ", rpt.getWidth(), rpt.getHeight());
    }

    private void m_discounts() {
        Dlg_discounts rpt = new Dlg_discounts();
        MyFrame.set2(rpt.getSurface(), jPanel1, "Discounts ", rpt.getWidth(), rpt.getHeight());
    }

    private void m_preferences() {
        Dlg_settings rpt = new Dlg_settings();
        MyFrame.set2(rpt.getSurface(), jPanel1, "Prefences", rpt.getWidth(), rpt.getHeight());
    }

    private void m_customers() {
        Dlg_customers_ar dtc = new Dlg_customers_ar();
        MyFrame.set(dtc.getSurface(), jPanel1, "Customer");
    }

    private void m_barcode() {
        Dlg_inventory_update_barcode dtc = new Dlg_inventory_update_barcode();
        MyFrame.set(dtc.getSurface(), jPanel1, "Update Barcodes");
    }

    private void r_print_barcodes() {
        Dlg_print_barcode dtc = new Dlg_print_barcode();
        MyFrame.set(dtc.getSurface(), jPanel1, "Print Barcode");
    }

    private void r_print_inventory_count() {
        Dlg_print_inventory_count dtc = new Dlg_print_inventory_count();
        MyFrame.set(dtc.getSurface(), jPanel1, "Inventory Count Sheet");
    }

    private void m_categories() {
        Dlg_categories rpt = new Dlg_categories();
        MyFrame.set2(rpt.getSurface(), jPanel1, "Categories", rpt.getWidth(), rpt.getHeight());
    }

    private void m_item_barcode() {
        Dlg_barcodes dtc = new Dlg_barcodes();
        MyFrame.set(dtc.getSurface(), jPanel1, "Item Barcodes");
    }

    private void m_unit_of_measure() {
        Dlg_uom dtc = new Dlg_uom();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Unit of Measure", dtc.getWidth(), dtc.getHeight());
    }

    private void m_service_departments() {
        Dlg_my_services_departments dtc = new Dlg_my_services_departments();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Service Departments", dtc.getWidth(), dtc.getHeight());
    }

    private void m_service_department_members() {
        Dlg_my_services_crews dtc = new Dlg_my_services_crews();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Service Departments Members", dtc.getWidth(), dtc.getHeight());
    }

    private void m_service_department_types() {
        Dlg_my_service_type dtc = new Dlg_my_service_type();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Service Departments Types", dtc.getWidth(), dtc.getHeight());
    }

    private void m_bank() {
        Dlg_banks dtc = new Dlg_banks();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Banks", dtc.getWidth(), dtc.getHeight());
    }

    private void m_suppliers() {
        Dlg_suppliers dtc = new Dlg_suppliers();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Banks", dtc.getWidth(), dtc.getHeight());
    }

    private void m_disbursement_categories() {
        Dlg_disbursement_categories dtc = new Dlg_disbursement_categories();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Disbursement Categories", dtc.getWidth(), dtc.getHeight());
    }

    private void m_update_pricing_per_branch() {
        Dlg_inventory_price_updates dtc = new Dlg_inventory_price_updates();
        MyFrame.set(dtc.getSurface(), jPanel1, "Update Item Pricing per Branch");
    }

    private void m_update_pricing_any_branches() {
        Dlg_inventory_price_updates dtc = new Dlg_inventory_price_updates();
        dtc.do_pass();
        MyFrame.set(dtc.getSurface(), jPanel1, "Update Item Pricing any Branches");
    }

    private void m_terminals() {
        Dlg_terminal dtc = new Dlg_terminal();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "terminals", dtc.getWidth(), dtc.getHeight());
    }

    private void m_backup() {
        Window p = (Window) this;
        Dlg_backup nd = Dlg_backup.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_backup.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_backup.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void m_credit_card() {
        Dlg_credit_cards dtc = new Dlg_credit_cards();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Credit Cards", dtc.getWidth(), dtc.getHeight());
    }

    private void m_stock_transfer_privileges() {
        Dlg_stock_transfer_privilege dtc = new Dlg_stock_transfer_privilege();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Stock Transfer Privileges", dtc.getWidth(), dtc.getHeight());
    }

    private void m_upload_to_cloud() {
        Window p = (Window) this;
        Dlg_upload_to_cloud nd = Dlg_upload_to_cloud.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_upload_to_cloud.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_upload_to_cloud.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void m_download_from_cloud() {
        Window p = (Window) this;
        Dlg_download_from_cloud nd = Dlg_download_from_cloud.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_download_from_cloud.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_download_from_cloud.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void t_price_inquiry() {
        Dlg_price_inquire dtc = new Dlg_price_inquire();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Price Inquiry", dtc.getWidth(), dtc.getHeight());
    }

    private void t_disbursement() {
        Dlg_disbursements dtc = new Dlg_disbursements();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Disbursement", dtc.getWidth(), dtc.getHeight());
    }

    private void t_adjuster() {
        Dlg_adjuster_inventory dtc = new Dlg_adjuster_inventory();
        MyFrame.set(dtc.getSurface(), jPanel1, "Adjuster");
    }

    private void t_inventory_replenishment() {
        Dlg_inventory_replenishment dtc = new Dlg_inventory_replenishment();
        MyFrame.set(dtc.getSurface(), jPanel1, "Inventory Replenishment");
    }

    private void t_charge_in_advance() {
        Dlg_charge_in_advance dtc = new Dlg_charge_in_advance();
        MyFrame.set(dtc.getSurface(), jPanel1, "Charge in Advance");
    }

    private void t_prepaid() {
        Dlg_prepaid_payments dtc = new Dlg_prepaid_payments();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Prepaid Payment", dtc.getWidth(), dtc.getHeight());
    }

    private void t_borrower_slip() {
        Dlg_borrower_slip dtc = new Dlg_borrower_slip();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Borrower Slip", dtc.getWidth(), dtc.getHeight());
    }

    private void t_cashier_cashcount() {
        Dlg_touchscreen_cashcount dtc = new Dlg_touchscreen_cashcount();

        MyFrame.set2(dtc.getSurface(), jPanel1, "Cashier Cash Count", dtc.getWidth(), dtc.getHeight());
    }

    private void t_update_cashdrawer() {
        Dlg_update_cashcount dtc = new Dlg_update_cashcount();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Update Cash Drawer", dtc.getWidth(), dtc.getHeight());

    }

    private void r_ar_items() {
        Dlg_ar_items dtc = new Dlg_ar_items();
        MyFrame.set2(dtc.getSurface(), jPanel1, "AR Items", dtc.getWidth(), dtc.getHeight());

    }

    private void r_bir() {
        Dlg_reading dtc = new Dlg_reading();
        MyFrame.set(dtc.getSurface(), jPanel1, "BIR X&Z Reading");
    }

    private void exit() {
    }

    private void run_script() {

//        Window p = (Window) this;
//        Dlg_match_branch_prices nd = Dlg_match_branch_prices.create(p, true);
//        nd.setTitle("");
//
//        nd.setCallback(new Dlg_match_branch_prices.Callback() {
//
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_match_branch_prices.OutputData data) {
//                closeDialog.ok();
//
//            }
//        });
//        nd.setLocationRelativeTo(this);
//        nd.setVisible(true);
//        Window p = (Window) this;
//        Dlg_adjust_price nd = Dlg_adjust_price.create(p, true);
//        nd.setTitle("");
//        nd.setCallback(new Dlg_adjust_price.Callback() {
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_adjust_price.OutputData data) {
//                closeDialog.ok();
//            }
//        });
//        nd.setLocationRelativeTo(this);
//        nd.setVisible(true);
//        
//        
//        jButton1.setEnabled(false);
//        jButton1.setText("Script is running....");
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Adjust_null_logout.adjust();
//                jButton1.setEnabled(true);
//                jButton1.setText("Finished....");
//            }
//        });
//        t.start();
        Window p = (Window) this;
        Dlg_adjust_receipt_endorsements nd = Dlg_adjust_receipt_endorsements.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_adjust_receipt_endorsements.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_adjust_receipt_endorsements.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void menu() {

        Window p = (Window) this;
        Dlg_menu nd = Dlg_menu.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_menu.Callback() {

            @Override
            public void minimize(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                closeDialog.ok();
                Pnl_Dashboard.this.setState(Frame.ICONIFIED);
            }

            @Override
            public void ok1(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                closeDialog.ok();
                if (data.stmt.equals("standby")) {
                    JLabel[] lbl = {jLabel10, jLabel16, jLabel11, jLabel17, jLabel18, jLabel15, jLabel19, jLabel9, jLabel20, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29};
                    for (final JLabel l : lbl) {
                        l.setVisible(false);
                    }
                    jPanel6.setVisible(false);
                    cardLayout.show(pnl_main_holder, "1");
                    MyUser.setUser_id("");
                }
                if (data.stmt.equals("logout")) {
                    logout1();
                }
                if (data.stmt.equals("minimize")) {
                    Pnl_Dashboard.this.setState(Frame.ICONIFIED);
                }
                //<editor-fold defaultstate="collapsed" desc=" transactions ">
                if (data.stmt.equals("Conversion")) {
                    t_conversions();
                }
                if (data.stmt.equals("Return/s from Customer")) {
                    t_returns_from_customer();

                }
                if (data.stmt.equals("Return Exchange")) {
                    t_return_exchange();

                }
                if (data.stmt.equals("Return/s to Supplier")) {
                    t_returns_to_supplier();

                }
                if (data.stmt.equals("Accounts Payable")) {
                    t_ap();
                }
                if (data.stmt.equals("Accounts Receivable")) {
                    t_ar_encoding();

                }
                if (data.stmt.equals("Accounts Receivable Payment")) {
                    t_ar_payments();
                }

                if (data.stmt.equals("Inventory Adjuster")) {
                    t_adjuster();
                }
                if (data.stmt.equals("Inventory Encoding")) {
                    t_encoding_inventory();
                }
                if (data.stmt.equals("Purchase Order")) {
                    t_purchase_order();
                }
                if (data.stmt.equals("Receipts")) {
                    receipts();
                }

                if (data.stmt.equals("Sales")) {
                    t_tavern(0);
                }
                if (data.stmt.equals("Services")) {
                    t_services();
                }
                if (data.stmt.equals("Stock Transfer")) {
                    stock_transfer();
                }
                if (data.stmt.equals("Disbursements")) {
                    t_disbursement();
                }
                if (data.stmt.equals("Price Inquiry")) {
                    t_price_inquiry();
                }
                if (data.stmt.equals("Prepaid Payments")) {
                    t_prepaid();
                }
                if (data.stmt.equals("Borrower's Slip")) {
                    t_borrower_slip();
                }

                if (data.stmt.equals("Charge in Advance")) {
                    t_charge_in_advance();
                }
                if (data.stmt.equals("RMA")) {
                    t_rma();
                }
                if (data.stmt.equals("Inventory Replenishment")) {
                    t_inventory_replenishment();
                }
                if (data.stmt.equals("Inventory Encoding - Finalize")) {
                    t_finalize_encoding();
                }

                if (data.stmt.equals("Receipts -  Finalize")) {
                    t_finalize_receipt();
                }
                if (data.stmt.equals("Services -  Add") || data.stmt.equalsIgnoreCase("Services-View/Encode")) {
                    t_services_view();
                }
                if (data.stmt.equals("Services -  View")) {
                    t_services_view2();
                }

                if (data.stmt.equals("Requistion Slip")) {

                    t_requisition_slip();

                }
                if (data.stmt.equals("Other Adjustments")) {

                    t_other_adjustments();

                }
                if (data.stmt.equals("Receipt Endorsement")) {

                    t_receipt_endorsement();

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" maintenance ">
                if (data.stmt.equals("Branches")) {
                    m_branches();
                }
                if (data.stmt.equals("Branch Locations")) {
                    m_branch_locations();
                }
                if (data.stmt.equals("Discounts")) {
                    m_discounts();
                }
                if (data.stmt.equals("Preferences")) {
                    m_preferences();
                }
                if (data.stmt.equals("Users")) {
                    users();
                }
                if (data.stmt.equals("Customers")) {
                    m_customers();
                }
                if (data.stmt.equals("Categories")) {
                    m_categories();
                }
                if (data.stmt.equals("Item Maintenance")) {
                    m_items();
                }
                if (data.stmt.equals("Item Maintenance per Location")) {
                    m_items_location();
                }

                if (data.stmt.equals("Item Barcodes") || data.stmt.equals("Update Barcode")) {
                    m_barcode();
                }
                if (data.stmt.equals("Unit of Measure")) {
                    m_unit_of_measure();
                }
                if (data.stmt.equals("Service - Departments")) {
                    m_service_departments();
                }
                if (data.stmt.equals("Service - Department Members")) {
                    m_service_department_members();
                }
                if (data.stmt.equals("Service - Transaction Types")) {
                    m_service_department_types();
                }
                if (data.stmt.equals("Suppliers")) {
                    m_suppliers();
                }
                if (data.stmt.equals("Banks")) {
                    m_bank();
                }
                if (data.stmt.equals("Backup")) {
                    m_backup();
                }

                if (data.stmt.equals("Disbursement Categories")) {
                    m_disbursement_categories();
                }

                if (data.stmt.equals("Credit Cards")) {
                    m_credit_card();
                }
                if (data.stmt.equals("Stock Transfer Privileges")) {
                    m_stock_transfer_privileges();
                }
                if (data.stmt.equals("Upload to Cloud")) {
                    m_upload_to_cloud();
                }
                if (data.stmt.equals("Download from Cloud")) {
                    m_download_from_cloud();
                }
                if (data.stmt.equals("Update Item Pricing per Branch")) {
                    m_update_pricing_per_branch();
                }
                if (data.stmt.equals("Update Item Pricing any Branches")) {
                    m_update_pricing_any_branches();
                }
                if (data.stmt.equals("Terminals")) {
                    m_terminals();
                }

                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Reports ">
                if (data.stmt.equals("Disbursements Report")) {
                    r_disbursement();
                }
                if (data.stmt.equals("Suppliers - Report")) {
                    r_suppliers();
                }
                if (data.stmt.equals("Customers Report")) {
                    r_customers();
                }
                if (data.stmt.equals("Re-Order Level")) {
                    r_reorder_level();
                }
                if (data.stmt.equals("Services Report")) {
                    r_services();
                }
                if (data.stmt.equals("Print Barcodes")) {
                    r_print_barcodes();
                }
                if (data.stmt.equals("Item Ledger")) {
                    rpt_stock_ledger();
                }

                if (data.stmt.equals("Stock Take (No Cost)")) {

                    rpt_stock_status2();
                }
                if (data.stmt.equals("Stock Take")) {
                    stock_take_view_only = 0;
                    rpt_stock_status();
                }
                if (data.stmt.equals("Inventory Count")) {
                    rpt_inventory_count();
                }
                if (data.stmt.equals("Cashier Report")) {
                    rpt_cashier_report();
                }
                if (data.stmt.equals("Inventory Count Sheet")) {
                    r_print_inventory_count();
                }

                if (data.stmt.equals("AR Items")) {
                    r_ar_items();
                }
                if (data.stmt.equals("BIR")) {
                    r_bir();
                }

                if (data.stmt.equals("")) {

                }
                //</editor-fold>
            }

            @Override
            public void standby(CloseDialog closeDialog, Dlg_menu.OutputData data) {

                closeDialog.ok();
            }

            @Override
            public void logout(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                closeDialog.ok();

            }
        });
        Point point = jLabel51.getLocationOnScreen();
        nd.setLocation(point.x - 125, point.y + 37);
        nd.setVisible(true);
    }

    int stock_take_view_only = 1;

    private void logout1() {
        System.exit(0);
//        Window p = (Window) this;
//        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
//        nd.setTitle("");
//
//        nd.setCallback(new Dlg_confirm_action.Callback() {
//
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
//                System.exit(0);
//            }
//        });
//        nd.setLocationRelativeTo(this);
//        nd.setVisible(true);
    }

}
