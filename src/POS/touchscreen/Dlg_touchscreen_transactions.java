/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.item_replacements.Dlg_item_replacements;
import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.sale_item_replacements.Dlg_sale_item_replacements;
import POS.sale_item_replacements.S1_sale_item_replacements;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.users.S1_users;
import POS.users.User_previlege_others;
import POS.util.Alert;
import POS.util.Counter;
import POS.util.DateType;
import POS.util.LostHeaderRenderer;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
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
import synsoftech.fields.Button;
import synsoftech.fields.Label;
import synsoftech.panels.Authenticate;
import synsoftech.panels.Warning;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_transactions extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_transactions
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
    private Dlg_touchscreen_transactions(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_transactions(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_transactions() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_transactions myRef;

    private void setThisRef(Dlg_touchscreen_transactions myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_transactions> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_transactions create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_transactions create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_transactions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_transactions((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_transactions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_transactions((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_transactions dialog = Dlg_touchscreen_transactions.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbl_sales_no = new Label.Status();
        jLabel10 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_customer_name = new javax.swing.JLabel();
        lbl_credit_card_rate = new javax.swing.JLabel();
        lbl_credit_card_holder = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_credit_card_app_code = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_prepaid_amount = new javax.swing.JLabel();
        jLabel24 = new Label.Separator2();
        lbl_gross_amount = new javax.swing.JLabel();
        lbl_gc_amount = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_line_discount = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbl_prepaid_cust_name = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbl_cheque_amount = new javax.swing.JLabel();
        lbl_cash = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_check_bank = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbl_sale_discount = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbl_charge_amount = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl_charge_type = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_credit_card_amount = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_credit_card_type = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_chage_reference = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lbl_charge_customer_name = new javax.swing.JLabel();
        lbl_gc_no = new javax.swing.JLabel();
        jLabel38 = new Label.Separator2();
        jLabel40 = new Label.Separator();
        jLabel43 = new javax.swing.JLabel();
        lbl_balance_due = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lbl_charge_amount3 = new javax.swing.JLabel();
        lbl_charge_amount4 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lbl_charge_amount5 = new javax.swing.JLabel();
        lbl_charge_amount1 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lbl_charge_amount2 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sale_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_items = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new Button.Success();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Sales No:");

        lbl_sales_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sales_no.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Date:");

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Customer:");

        lbl_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_customer_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbl_credit_card_rate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_rate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbl_credit_card_holder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_holder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Rate:");

        lbl_credit_card_app_code.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_app_code.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Gift Certificate:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Card Holder:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("App. Code:");

        lbl_prepaid_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_prepaid_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_prepaid_amount.setText("0.00");

        lbl_gross_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gross_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_gross_amount.setText("0.00");

        lbl_gc_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gc_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_gc_amount.setText("0.00");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Prepaid:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Gross Total:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Line Discount:");

        lbl_line_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_line_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_line_discount.setText("0.00");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Cust. Name:");

        lbl_prepaid_cust_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_prepaid_cust_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Cheque:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Cash:");

        lbl_cheque_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_cheque_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cheque_amount.setText("0.00");

        lbl_cash.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_cash.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cash.setText("0.00");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Bank:");

        lbl_check_bank.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_check_bank.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Charge:");

        lbl_sale_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sale_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_sale_discount.setText("0.00");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Reference:");

        lbl_charge_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount.setText("0.00");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Sale Discount:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Type:");

        lbl_charge_type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_charge_type.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Credit Card:");

        lbl_credit_card_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credit_card_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_credit_card_amount.setText("0.00");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Type:");

        lbl_credit_card_type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_type.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Cust. Name:");

        lbl_chage_reference.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_chage_reference.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("GC No:");

        lbl_charge_customer_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_charge_customer_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbl_gc_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gc_no.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setText("Balance Due:");

        lbl_balance_due.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_balance_due.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance_due.setText("0.00");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Addtl. Amount:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Witholding Tax:");

        lbl_charge_amount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount3.setText("0.00");

        lbl_charge_amount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount4.setText("0.00");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Charge in Advance:");

        lbl_charge_amount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount5.setText("0.00");

        lbl_charge_amount1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_charge_amount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount1.setText("0.00");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("Vatable Sales:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setText("12% VAT Sales");

        lbl_charge_amount2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_charge_amount2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount2.setText("0.00");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Status:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Counted");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_balance_due, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(lbl_customer_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_sales_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_charge_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(lbl_charge_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_credit_card_holder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_credit_card_type, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_credit_card_amount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(lbl_cash, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_credit_card_app_code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_sale_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_gross_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(lbl_line_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbl_prepaid_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_gc_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addComponent(lbl_gc_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(lbl_check_bank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_prepaid_cust_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_cheque_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_charge_amount5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_charge_amount1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(lbl_charge_amount4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_charge_amount3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_charge_amount2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_charge_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addComponent(lbl_chage_reference, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel48)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_sales_no, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbl_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lbl_gross_amount))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lbl_line_discount))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lbl_sale_discount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(1, 1, 1)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lbl_cash))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lbl_credit_card_amount))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbl_credit_card_type, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lbl_credit_card_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbl_credit_card_app_code, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lbl_gc_amount))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lbl_gc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lbl_prepaid_amount))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lbl_prepaid_cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lbl_cheque_amount))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lbl_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lbl_charge_amount))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lbl_charge_type, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lbl_chage_reference, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lbl_charge_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_charge_amount3)
                        .addGap(1, 1, 1)
                        .addComponent(lbl_charge_amount4)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel47))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_charge_amount5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_charge_amount1)
                        .addGap(1, 1, 1)
                        .addComponent(lbl_charge_amount2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_balance_due, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbl_sale_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_sale_items.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_sale_items.setSelectionBackground(new java.awt.Color(4, 176, 217));
        tbl_sale_items.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_sale_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sale_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sale_items);

        jLabel1.setText("No of Items:");

        lbl_items.setText("0");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("0.00");

        jLabel4.setText("Gross Total:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("0.00");

        jLabel6.setText("Line Discount:");

        jLabel7.setText("Search by:");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Sales No");
        jCheckBox2.setFocusable(false);

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setText("Customer Name");
        jCheckBox3.setFocusable(false);

        jButton2.setBackground(new java.awt.Color(244, 244, 244));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/printer67.png"))); // NOI18N
        jButton2.setText("Re - Print");
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(244, 244, 244));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/delete31.png"))); // NOI18N
        jButton3.setText("Void");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(244, 244, 244));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icon_inventory/rotating15 (1).png"))); // NOI18N
        jButton4.setText("Item Replacements");
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("View Transactions");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Void/Item Replacements/Print");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_items, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_items)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        remove_items();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reprint_or();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_sale_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sale_itemsMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_sale_itemsMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        returns_exchange();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        show_trans();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_balance_due;
    private javax.swing.JLabel lbl_cash;
    private javax.swing.JLabel lbl_chage_reference;
    private javax.swing.JLabel lbl_charge_amount;
    private javax.swing.JLabel lbl_charge_amount1;
    private javax.swing.JLabel lbl_charge_amount2;
    private javax.swing.JLabel lbl_charge_amount3;
    private javax.swing.JLabel lbl_charge_amount4;
    private javax.swing.JLabel lbl_charge_amount5;
    private javax.swing.JLabel lbl_charge_customer_name;
    private javax.swing.JLabel lbl_charge_type;
    private javax.swing.JLabel lbl_check_bank;
    private javax.swing.JLabel lbl_cheque_amount;
    private javax.swing.JLabel lbl_credit_card_amount;
    private javax.swing.JLabel lbl_credit_card_app_code;
    private javax.swing.JLabel lbl_credit_card_holder;
    private javax.swing.JLabel lbl_credit_card_rate;
    private javax.swing.JLabel lbl_credit_card_type;
    private javax.swing.JLabel lbl_customer_name;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_gc_amount;
    private javax.swing.JLabel lbl_gc_no;
    private javax.swing.JLabel lbl_gross_amount;
    private javax.swing.JLabel lbl_items;
    private javax.swing.JLabel lbl_line_discount;
    private javax.swing.JLabel lbl_prepaid_amount;
    private javax.swing.JLabel lbl_prepaid_cust_name;
    private javax.swing.JLabel lbl_sale_discount;
    private javax.swing.JLabel lbl_sales_no;
    private javax.swing.JTable tbl_sale_items;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db", "db_smis_cebu_chickaloka");
        init_key();
        hover();
        init_table_bg();
        init_tbl_sale_items();

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
//                jTextField1.grabFocus();
            }
        });
        jLabel7.setVisible(false);
        jCheckBox2.setVisible(false);
        jCheckBox3.setVisible(false);
    }

    private void init_table_bg() {
        Color ivory = new Color(255, 255, 255);
        tbl_sale_items.setOpaque(true);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        tbl_sale_items.setFillsViewportHeight(true);
        tbl_sale_items.setBackground(ivory);
    }

    JDialog parent;

    public void do_pass(JDialog par) {
        parent = par;
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

    private void hover() {
        JButton[] btns = {jButton3, jButton2, jButton4};
        final String[] txts = {"Sales Summary", "Cash Count", "Item Replacements"};
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
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(244, 244, 244));
                }
            });
            if (i < txts.length) {
                i++;
            }
        }
    }

    int selected_or = -1;
    List<MySales.sales> sales = new ArrayList();

    private void init_order() {
        String search = "";//jTextField1.getText();
        String where = " where customer_name like '%" + search + "%'  or sales_no like '%" + search + "%' order by sales_no,customer_name  asc ";
        sales = MySales.ret_data(where);
        Object[][] obj = new Object[sales.size()][4];
        int i = 0;
        for (MySales.sales to : sales) {
            obj[i][0] = " " + to.sales_no;
            obj[i][1] = " " + to.customer_name;
            obj[i][2] = " " + FitIn.fmt_wc_0(to.amount_due) + " ";

            if (to.status == 0) {
                obj[i][3] = " " + " Counted";
            } else {
                obj[i][3] = " " + "Void";
            }
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, lbl_sales_no.getWidth() - 200, 100, 60};
        String[] col_names = {"Sales No", "Customer", "Amount Due", "Status"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(new JTextField(), obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {

            }
        });
    }

    private ArrayListModel tbl_sale_items_ALM;
    private Tblsale_itemsModel tbl_sale_items_M;

    private void init_tbl_sale_items() {
        tbl_sale_items_ALM = new ArrayListModel();
        tbl_sale_items_M = new Tblsale_itemsModel(tbl_sale_items_ALM);
        tbl_sale_items.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_sale_items.setModel(tbl_sale_items_M);
        tbl_sale_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sale_items.setRowHeight(25);
        int[] tbl_widths_sale_items = {40, 40, 40, 80, 80, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sale_items.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sale_items, i, tbl_widths_sale_items[i]);
        }
        Dimension d = tbl_sale_items.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_sale_items.getTableHeader().setPreferredSize(d);
        tbl_sale_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));
        tbl_sale_items.setRowHeight(40);
        tbl_sale_items.setFont(new java.awt.Font("Arial", 0, 14));
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 4);
        tbl_sale_items.getColumnModel().getColumn(0).setHeaderRenderer(new LostHeaderRenderer());
        tbl_sale_items.getColumnModel().getColumn(1).setHeaderRenderer(new LostHeaderRenderer());
        tbl_sale_items.getColumnModel().getColumn(2).setHeaderRenderer(new LostHeaderRenderer());
        tbl_sale_items.getColumnModel().getColumn(3).setHeaderRenderer(new LostHeaderRenderer());
        tbl_sale_items.getColumnModel().getColumn(4).setHeaderRenderer(new LostHeaderRenderer());
        tbl_sale_items.getColumnModel().getColumn(5).setHeaderRenderer(new LostHeaderRenderer());

        tbl_sale_items.getColumnModel().getColumn(1).setCellRenderer(new Html());

        TableColumn tc = tbl_sale_items.getColumnModel().getColumn(5);
        tc.setCellEditor(tbl_sale_items.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tbl_sale_items.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
    }

    class Html extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            JLabel lbl = new JLabel();
            lbl.setText(value.toString());
            lbl.setOpaque(true);
            lbl.setBackground(Color.white);
            if (selected) {
                lbl.setBackground(new java.awt.Color(4, 176, 217));
                lbl.setForeground(new java.awt.Color(255, 255, 255));
            }
            return lbl;
        }
    }

    private void loadData_sale_items(List<MySales_Items.items> acc) {
        tbl_sale_items_ALM.clear();
        tbl_sale_items_ALM.addAll(acc);
    }

    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = tbl_sale_items.getRowCount(); x < y; x++) {
                tbl_sale_items.setValueAt(checked, x, 0);
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
            List<MySales_Items.items> datas = tbl_sale_items_ALM;
            boolean selected = false;
            if (this.isSelected()) {
                selected = true;
            }
            for (MySales_Items.items to : datas) {
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

    public static class Tblsale_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Description", "Qty", "Unit", "Discount", "Amount", "", "generic_name", "item_type", "supplier_name", "supplier_id", "serial_no", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_id", "user_screen_name", "status", "is_vatable", "selling_type", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "branch", "branch_code", "location", "location_id", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "brand", "brand_id", "model", "model_id"
        };

        public Tblsale_itemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 5) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            MySales_Items.items tt = (MySales_Items.items) getRow(row);
            Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
            switch (col) {
                case 0:
                    String html = "<html><body>"
                            + "&nbsp <font size=\"3\"> " + tt.description + "</font><br>"
                            + "&nbsp <font color=\"black\" size=\"2\"> Item Code:" + tt.item_code + "&emsp;" + "Supplier: " + tt.supplier_name + "</font><br>"
                            + "</body>"
                            + "</html>";
                    return html;
                case 1:

                    return "  " + FitIn.fmt_woc((tt.product_qty / tt.conversion));
                case 2:
                    Dlg_inventory_uom.to_uom uomss = uom.default_uom(tt.unit);
                    String uom = uomss.uom;
                    uom = uom.replaceAll("#", "/");

                    return " " + uom;
                case 3:
                    return " " + FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 4:

                    return " " + FitIn.fmt_woc(((tt.product_qty / tt.conversion) * uoms.selling_price) - tt.discount_amount) + " ";
                case 5:
                    return tt.selected;
                case 6:
                    return tt.item_type;
                case 7:
                    return tt.supplier_name;
                case 8:
                    return tt.supplier_id;
                case 9:
                    return tt.serial_no;
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
                    return tt.user_id;
                case 16:
                    return tt.user_screen_name;
                case 17:
                    return tt.status;
                case 18:
                    return tt.is_vatable;
                case 19:
                    return tt.selling_type;
                case 20:
                    return tt.discount_name;
                case 21:
                    return tt.discount_rate;
                case 22:
                    return tt.discount_amount;
                case 23:
                    return tt.discount_customer_name;
                case 24:
                    return tt.discount_customer_id;
                case 25:
                    return tt.branch;
                case 26:
                    return tt.branch_code;
                case 27:
                    return tt.location;
                case 28:
                    return tt.location_id;
                case 29:
                    return tt.category;
                case 30:
                    return tt.category_id;
                case 31:
                    return tt.classification;
                case 32:
                    return tt.classification_id;
                case 33:
                    return tt.sub_classification;
                case 34:
                    return tt.sub_classification_id;
                case 35:
                    return tt.brand;
                case 36:
                    return tt.brand_id;
                case 37:
                    return tt.model;
                default:
                    return tt.model_id;
            }
        }
    }

    private void data_cols() {
        String where = "";
        loadData_sale_items(MySales_Items.ret_data(where));
    }

    private void select_item() {
        int row = tbl_sale_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        MySales_Items.items to = (MySales_Items.items) tbl_sale_items_ALM.get(row);
        int col = tbl_sale_items.getSelectedColumn();
        if (col == 5) {

            if (to.selected == true) {
                to.setSelected(false);
            } else {
                to.setSelected(true);
            }
            tbl_sale_items_M.fireTableDataChanged();
        }
    }

    private void remove_items() {

        if (my_sale == null) {
            return;
        }
        String pool_db = System.getProperty("pool_db", "db_smis");
        if (!pool_db.equalsIgnoreCase("db_smis_cebu_chickaloka")) {
            try {
                Date from = DateType.datetime.parse(my_sale.date_added);
                Date now = new Date();
                int count_days = Counter.getDayCount(from, now);
                Alert.set(0, count_days + " day/s have past!");
                if (count_days > 0) {
                    Alert.set(0, "Unable to void transaction, " + count_days + " day/s have past!");
                    return;
                }
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_touchscreen_transactions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (my_sale.status == 1) {
            Alert.set(0, "Cannot Proceed, Transaction already cancelled!");
            return;
        }
        Window p = (Window) this;
        Authenticate nd = Authenticate.create(p, true);
        nd.setTitle("");
        if (parent == null) {
            nd.do_pass(this.getSurface(), "");
        } else {
            nd.do_pass(parent.getRootPane(), "");
        }
        nd.setCallback(new Authenticate.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Authenticate.OutputData data) {
                closeDialog.ok();
                String username = data.username;
                String password = data.password;
                final S1_users.to_users to = S1_users.ret_data_autho(username, password);
                if (to == null) {
                    warning("Input correct credentials!");
                } else {
                    String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Void Sales - (Add)" + "' limit 1";
                    List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
                    if (datas.isEmpty()) {
                        Alert.set(0, "Privilege not added!");
                        return;
                    }
                    
                    
                    Label.Status or = (Label.Status) lbl_sales_no;
                    int status = or.getStatus();
                    List<MySales_Items.items> orders = tbl_sale_items_ALM;
                    MySales.void_sale(or.getId(), status, orders, my_sale);
                    Alert.set(0, "Transaction cancelled!");
                    clear_data();
                }
            }
        });
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        nd.setSize(xSize, ySize);
        nd.setVisible(true);
    }

    private void clear_data() {

        Label.Status or = (Label.Status) lbl_sales_no;
        or.setId("");
        or.setStatus(0);

        lbl_sales_no.setText("");
        lbl_date.setText("");
        lbl_customer_name.setText("");

        lbl_gross_amount.setText("0.00");
        lbl_line_discount.setText("0.00");
        lbl_sale_discount.setText("0.00");
        lbl_balance_due.setText("0.00");
        lbl_cash.setText("0.00");
        lbl_credit_card_amount.setText("0.00");
        lbl_gc_amount.setText("0.00");
        lbl_prepaid_amount.setText("0.00");
        lbl_cheque_amount.setText("0.00");
        lbl_charge_amount.setText("0.00");
        lbl_balance_due.setText("0.00");
        jLabel5.setText("0.00");
        jLabel3.setText("0.00");
        lbl_items.setText("0");
        lbl_credit_card_type.setText("");
        lbl_credit_card_rate.setText("");
        lbl_credit_card_holder.setText("");
        lbl_credit_card_app_code.setText("");
        lbl_gc_no.setText("");
        lbl_prepaid_cust_name.setText("");
        lbl_check_bank.setText("");
        lbl_charge_type.setText("");
        lbl_chage_reference.setText("");
        lbl_charge_customer_name.setText("");
        tbl_sale_items_ALM.clear();
        tbl_sale_items_M.fireTableDataChanged();

    }

    private void warning(String message) {
        Window p = (Window) this;
        Warning nd = Warning.create(p, true);
        nd.setTitle("");

        if (parent == null) {
            nd.do_pass(this.getSurface(), message);
        } else {
            nd.do_pass(parent.getRootPane(), message);
        }
        nd.setCallback(new Warning.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Warning.OutputData data) {
                closeDialog.ok();
            }
        });
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        nd.setSize(xSize, ySize);
        nd.setVisible(true);

    }

    private void touchscreen_transaction_item_replacements() {
        if (lbl_sales_no.getText().isEmpty()) {
            Alert.set(0, "Please select transaction!");
            return;
        }
        double total_qty = 0;
        double gross = 0;
        List<MySales_Items.items> items = tbl_sale_items_ALM;
        for (MySales_Items.items item : items) {
            if (item.selected == true) {
                Dlg_inventory_uom.to_uom uoms = uom.default_uom(item.unit);
                total_qty += (item.product_qty / uoms.conversion);
                gross += (item.product_qty / uoms.conversion) * item.selling_price;
            }

        }

        if (total_qty <= 0) {
            Alert.set(0, "Please select item/s to be replaced!");
            return;
        }
        Window p = (Window) this;
        Dlg_sale_item_replacements nd = Dlg_sale_item_replacements.create(p, true);
        nd.setTitle("");
        nd.do_pass(total_qty, gross);
        nd.setCallback(new Dlg_sale_item_replacements.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_sale_item_replacements.OutputData data) {
                closeDialog.ok();
                MySales.sales sale = my_sale;
                List<MySales_Items.items> items = tbl_sale_items_ALM;
                List<S1_sale_item_replacements.to_sale_item_replacements> replacements = data.datas;

                double gross_amount = 0;
                double amount_due = 0;
                double line_discount = 0;
                double qty = 0;
                for (S1_sale_item_replacements.to_sale_item_replacements rep : replacements) {
                    gross_amount += rep.product_qty * rep.selling_price;
                    line_discount += rep.discount_amount;
                    qty += rep.product_qty;
                }
                for (MySales_Items.items item : items) {
                    if (item.selected == false) {
                        gross_amount += item.product_qty * item.selling_price;
                        line_discount += item.discount_amount;
                        qty += item.product_qty;
                    }
                }
                amount_due = gross_amount - line_discount;
                double sale_discount = FitIn.toDouble(lbl_sale_discount.getText());
                amount_due = amount_due - sale_discount;
                sale.gross_amount = gross_amount;
                sale.amount_due = amount_due;
                sale.line_discount = line_discount;

                S1_sale_item_replacements.item_replacement(sale, items, replacements);
                lbl_line_discount.setText(FitIn.fmt_wc_0(line_discount));
                lbl_gross_amount.setText(FitIn.fmt_wc_0(gross_amount));
                lbl_balance_due.setText(FitIn.fmt_wc_0(amount_due));

                String where = "where sales_no='" + sale.sales_no + "' ";
                List<MySales_Items.items> datas = MySales_Items.ret_data(where);
                loadData_sale_items(datas);

                lbl_items.setText(FitIn.fmt_woc(qty));
                jLabel5.setText(FitIn.fmt_wc_0(line_discount));
                jLabel3.setText(FitIn.fmt_wc_0(gross_amount));
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void returns_exchange() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Return Exchange - (View)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }

        Window p = (Window) this;
        Dlg_item_replacements nd = Dlg_item_replacements.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_item_replacements.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_item_replacements.OutputData data) {
                closeDialog.ok();
            }
        });

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        nd.setSize(xSize, ySize);
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    MySales.sales my_sale = null;

    private void show_trans() {
        Window p = (Window) this;
        Dlg_touchscreen_transactions_search nd = Dlg_touchscreen_transactions_search.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_touchscreen_transactions_search.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_transactions_search.OutputData data) {
                closeDialog.ok();
                MySales.sales sale = data.sales;
                if (sale.status == 1) {
                    jButton3.setEnabled(false);
                    jButton4.setEnabled(false);
                } else {
                    jButton3.setEnabled(true);
                    jButton4.setEnabled(true);
                }
                my_sale = sale;
                if (sale.status == 0) {
                    jLabel49.setText("Counted");
                    jLabel49.setForeground(Color.gray);
                } else {
                    jLabel49.setText("Void");
                    jLabel49.setForeground(Color.red);
                }
                Label.Status or = (Label.Status) lbl_sales_no;
                or.setId(sale.sales_no);
                or.setStatus(sale.status);
                lbl_sales_no.setText(sale.sales_no);
                lbl_date.setText(DateType.convert_jan_1_2013_datetime(sale.date_added));
                lbl_customer_name.setText(sale.customer_name);
                lbl_gross_amount.setText(FitIn.fmt_wc_0(sale.gross_amount));
                lbl_line_discount.setText(FitIn.fmt_wc_0(sale.line_discount));
                lbl_sale_discount.setText(FitIn.fmt_wc_0(sale.discount_amount));
                lbl_balance_due.setText(FitIn.fmt_wc_0(sale.amount_due));
                lbl_credit_card_amount.setText(FitIn.fmt_wc_0(sale.credit_card_amount));
                lbl_credit_card_type.setText(sale.credit_card_type);
                lbl_credit_card_rate.setText(FitIn.fmt_wc_0(sale.credit_card_rate));
                lbl_credit_card_holder.setText(sale.credit_card_holder);
                lbl_credit_card_app_code.setText(sale.credit_card_approval_code);
                lbl_gc_amount.setText(FitIn.fmt_wc_0(sale.gift_certificate_amount));
                lbl_gc_no.setText(sale.gift_certificate_no);
                lbl_prepaid_amount.setText(FitIn.fmt_wc_0(sale.prepaid_amount));
                lbl_prepaid_cust_name.setText(sale.prepaid_customer_name);
                lbl_cheque_amount.setText(FitIn.fmt_wc_0(sale.check_amount));
                lbl_check_bank.setText(sale.check_bank);
                lbl_charge_amount.setText(FitIn.fmt_wc_0(sale.charge_amount));
                lbl_charge_type.setText(sale.charge_type);
                lbl_chage_reference.setText(sale.charge_reference_no);
                lbl_charge_customer_name.setText(sale.charge_customer_name);
                double cash = sale.amount_due - (sale.credit_card_amount
                        + sale.gift_certificate_amount
                        + sale.prepaid_amount
                        + sale.check_amount
                        + sale.charge_amount);
                lbl_cash.setText(FitIn.fmt_wc_0(cash));
                String where = "where sales_no='" + sale.sales_no + "' and location_id ='" + sale.location_id + "' ";
                List<MySales_Items.items> datas = MySales_Items.ret_data(where);

                loadData_sale_items(datas);

                double line_discount = 0;
                double gross = 0;
                double qty = 0;
                for (MySales_Items.items to : datas) {
                    line_discount += to.discount_amount;
                    gross += to.product_qty * to.selling_price;
                    qty += to.product_qty;
                }
                lbl_items.setText(FitIn.fmt_woc(qty));
                jLabel5.setText(FitIn.fmt_wc_0(line_discount));
                jLabel3.setText(FitIn.fmt_wc_0(gross));
                lbl_charge_amount3.setText(FitIn.fmt_wc_0(sale.addtl_amount));
                lbl_charge_amount4.setText(FitIn.fmt_wc_0(sale.wtax));
                lbl_balance_due.setText(FitIn.fmt_wc_0(sale.amount_due));
                double am = FitIn.toDouble(lbl_balance_due.getText());
                double t_vat_sales = (am / 1.12) * .12;
                am = am - t_vat_sales;
                lbl_charge_amount1.setText(FitIn.fmt_wc_0(am));
                lbl_charge_amount2.setText(FitIn.fmt_wc_0(t_vat_sales));
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void reprint_or() {

        List<Inventory_barcodes.to_inventory_barcodes> orders = MySales_Items.convert_order2(tbl_sale_items_ALM);
        double sale_discount = FitIn.toDouble(lbl_sale_discount.getText());
        double net_total = FitIn.toDouble(lbl_balance_due.getText());
        double cash_amount = FitIn.toDouble(lbl_cash.getText());
        double change_amount = 0;
        String sales_date = lbl_date.getText();
        Window p = (Window) this;
        Dlg_touchscreen_choose_receipt_type nd = Dlg_touchscreen_choose_receipt_type.create(p, true);
        nd.setTitle("");
        nd.do_pass(orders, sale_discount, net_total, my_sale, cash_amount, change_amount, sales_date);
        nd.setCallback(new Dlg_touchscreen_choose_receipt_type.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_choose_receipt_type.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
