/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.delivery.Dlg_delivery_print_preview;
import POS.inventory.Inventory_barcodes;
import POS.my_sales.MySales;
import POS.reports.Dlg_report_items;
import POS.users.MyUser;
import POS.util.DateType;
import POS.util.LostHeaderRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import synsoftech.fields.Label;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_change extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_change
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
    private Dlg_touchscreen_change(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_change(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_change() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_change myRef;

    private void setThisRef(Dlg_touchscreen_change myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_change> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_change create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_change create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_change dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_change((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_change dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_change((java.awt.Dialog) parent, false);
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
        Dlg_touchscreen_change dialog = Dlg_touchscreen_change.create(new javax.swing.JFrame(), true);
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
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new Label.Separator2();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_gross_amount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_line_discount = new javax.swing.JLabel();
        lbl_sale_discount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_balance_due = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_cash = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_credit_card_amount = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_credit_card_type = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_credit_card_rate = new javax.swing.JLabel();
        lbl_credit_card_holder = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_credit_card_app_code = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_gc_amount = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_prepaid_amount = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_prepaid_cust_name = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_cheque_amount = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbl_check_bank = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbl_charge_amount = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl_charge_type = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbl_chage_reference = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_charge_customer_name = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lbl_gc_no = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lbl_tendered = new javax.swing.JLabel();
        jLabel45 = new Label.Separator2();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_charge_amount1 = new javax.swing.JLabel();
        lbl_charge_amount2 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_charge_amount3 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lbl_charge_amount4 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lbl_charge_amount5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_gross_amount1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orders = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(6, 156, 191)));

        jButton1.setBackground(new java.awt.Color(4, 176, 217));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/check52.png"))); // NOI18N
        jButton1.setText("Ok");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/printer67.png"))); // NOI18N
        jButton2.setText("OR");
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/donation (1).png"))); // NOI18N
        jButton3.setText("Tip  ");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setOpaque(true);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/delivery23 (1).png"))); // NOI18N
        jButton4.setText("DR");
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(246, 246, 246));

        jLabel3.setBackground(new java.awt.Color(4, 176, 217));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("P 1,000.00 ");
        jLabel3.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Gross Total:");

        lbl_gross_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gross_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_gross_amount.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Line Discount:");

        lbl_line_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_line_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_line_discount.setText("0.00");

        lbl_sale_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sale_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_sale_discount.setText("0.00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Sale Discount:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Balance Due:");

        lbl_balance_due.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_balance_due.setForeground(java.awt.Color.red);
        lbl_balance_due.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance_due.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cash:");

        lbl_cash.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_cash.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cash.setText("0.00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Credit Card:");

        lbl_credit_card_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credit_card_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_credit_card_amount.setText("0.00");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Type:");

        lbl_credit_card_type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_type.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Rate:");

        lbl_credit_card_rate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_rate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbl_credit_card_holder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_holder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Card Holder:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("App. Code:");

        lbl_credit_card_app_code.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_credit_card_app_code.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Gift Certificate:");

        lbl_gc_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gc_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_gc_amount.setText("0.00");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Prepaid:");

        lbl_prepaid_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_prepaid_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_prepaid_amount.setText("0.00");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Cust. Name:");

        lbl_prepaid_cust_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_prepaid_cust_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Cheque:");

        lbl_cheque_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_cheque_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cheque_amount.setText("0.00");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Bank:");

        lbl_check_bank.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_check_bank.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Charge:");

        lbl_charge_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount.setText("0.00");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Type:");

        lbl_charge_type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_charge_type.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Reference:");

        lbl_chage_reference.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_chage_reference.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Cust. Name:");

        lbl_charge_customer_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_charge_customer_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("GC No:");

        lbl_gc_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_gc_no.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setText("Tendered:");

        lbl_tendered.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_tendered.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_tendered.setText("0.00");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel34.setText("Vatable Sales:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel36.setText("12% VAT Sales");

        lbl_charge_amount1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_charge_amount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount1.setText("0.00");

        lbl_charge_amount2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_charge_amount2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount2.setText("0.00");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Addtl. Amount:");

        lbl_charge_amount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount3.setText("0.00");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Witholding Tax:");

        lbl_charge_amount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount4.setText("0.00");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Charge in Advance:");

        lbl_charge_amount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_charge_amount5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_charge_amount5.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Transaction No:");

        lbl_gross_amount1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gross_amount1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_gross_amount1.setText("0000000000000000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_gross_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_line_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_sale_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lbl_balance_due, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_gc_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_prepaid_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cheque_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_prepaid_cust_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lbl_check_bank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lbl_charge_amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lbl_charge_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lbl_chage_reference, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lbl_charge_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lbl_gc_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_tendered, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_charge_amount1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_charge_amount2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_charge_amount4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(59, 59, 59)
                        .addComponent(lbl_charge_amount3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_credit_card_app_code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_credit_card_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(lbl_credit_card_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_credit_card_rate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_credit_card_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_charge_amount5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gross_amount1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_gross_amount1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_gross_amount))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_line_discount))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_sale_discount))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_balance_due)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbl_cash))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
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
                    .addComponent(jLabel27)
                    .addComponent(lbl_prepaid_cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lbl_cheque_amount))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
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
                .addGap(1, 1, 1)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lbl_charge_amount3))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lbl_charge_amount4))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(lbl_charge_amount5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lbl_charge_amount1))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lbl_charge_amount2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(lbl_tendered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_orders.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbl_orders);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        preview_dr();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String print = System.getProperty("print_to_receipts", "false");
        System.out.println("Print to Receipts: " + print);
        if (print.equalsIgnoreCase("true")) {
            try {
                if (jasperPrint != null) {
                    JasperPrintManager.printReport(jasperPrint, false);
                }

            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
                throw new RuntimeException(e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JLabel lbl_gc_amount;
    private javax.swing.JLabel lbl_gc_no;
    private javax.swing.JLabel lbl_gross_amount;
    private javax.swing.JLabel lbl_gross_amount1;
    private javax.swing.JLabel lbl_line_discount;
    private javax.swing.JLabel lbl_prepaid_amount;
    private javax.swing.JLabel lbl_prepaid_cust_name;
    private javax.swing.JLabel lbl_sale_discount;
    private javax.swing.JLabel lbl_tendered;
    private javax.swing.JTable tbl_orders;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        hover();
        init_table_bg();
        init_tbl_order();
    }

    private void init_table_bg() {
        Color ivory = new Color(255, 255, 255);
        tbl_orders.setOpaque(true);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        tbl_orders.setFillsViewportHeight(true);
        tbl_orders.setBackground(ivory);
    }

    MySales.sales my_sales = null;

    public void do_pass(final List<Inventory_barcodes.to_inventory_barcodes> orders, final Label.Normal cust, final Label.Item_discount discount, final double gross_amount, final double line_discount, final MySales.sales sales) {
        my_sales = sales;
        tbl_orders.grabFocus();
        loadData_orders(orders);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                
                lbl_gross_amount1.setText(sales.sales_no);
                lbl_gross_amount.setText(FitIn.fmt_wc_0(gross_amount));
                lbl_line_discount.setText(FitIn.fmt_wc_0(line_discount));
                lbl_sale_discount.setText(FitIn.fmt_wc_0(discount.getDiscount_amount()));
                lbl_balance_due.setText(FitIn.fmt_wc_0(Payments.balance_due));

                lbl_cash.setText(FitIn.fmt_wc_0(Payments.cash.cash));

                lbl_credit_card_amount.setText(FitIn.fmt_wc_0(Payments.credit_card.amount));
                lbl_credit_card_type.setText(Payments.credit_card.card_type);
                lbl_credit_card_rate.setText(FitIn.fmt_wc_0(Payments.credit_card.rate));
                lbl_credit_card_holder.setText(Payments.credit_card.card_holder);
                lbl_credit_card_app_code.setText(Payments.credit_card.approval_code);

                lbl_gc_amount.setText(FitIn.fmt_wc_0(Payments.gift_certificate.amount));
                lbl_gc_no.setText(Payments.gift_certificate.gc_no);

                lbl_prepaid_amount.setText(FitIn.fmt_wc_0(Payments.prepaid.amount));
                lbl_prepaid_cust_name.setText(Payments.prepaid.customer_name);

                lbl_cheque_amount.setText(FitIn.fmt_wc_0(Payments.cheque.amount));
                lbl_check_bank.setText(Payments.cheque.bank);

                lbl_charge_amount.setText(FitIn.fmt_wc_0(Payments.charge.amount));
                lbl_charge_type.setText(Payments.charge.charge_type);
                lbl_chage_reference.setText(Payments.charge.reference_no);
                lbl_charge_customer_name.setText(Payments.charge.customer_name);

                double tendered = Payments.cash.cash + Payments.credit_card.amount + Payments.gift_certificate.amount + Payments.prepaid.amount + Payments.cheque.amount + Payments.charge.amount;
                lbl_tendered.setText(FitIn.fmt_wc_0(tendered));
                jLabel3.setText("P " + FitIn.fmt_wc_0(Payments.countChange2()) + " ");

                double am = FitIn.toDouble(lbl_balance_due.getText());
                double t_vat_sales = (am / 1.12) * .12;
                am = am - t_vat_sales;
                lbl_charge_amount1.setText(FitIn.fmt_wc_0(am));
                lbl_charge_amount2.setText(FitIn.fmt_wc_0(t_vat_sales));

                lbl_charge_amount3.setText(FitIn.fmt_wc_0(sales.addtl_amount));
                lbl_charge_amount4.setText(FitIn.fmt_wc_0(sales.wtax));

                List<Srpt_receipt.field> fields = new ArrayList();
                int total_qty = 0;
                double vatable_sale = 0;
                double zero_rate_sale = 0;
                double vat_exempt_sale = 0;
                double vat_percent = 0;
                for (Inventory_barcodes.to_inventory_barcodes to : orders) {
                    String desc = to.description;
                    Date date_added = new Date();
                    double total = (to.product_qty * to.selling_price) - to.discount_amount;
                    double qty = to.product_qty;
                    double selling_price = to.selling_price;
                    double discount = to.discount_amount;
                    Srpt_receipt.field tbar = new Srpt_receipt.field(desc, date_added, total, qty, selling_price, discount);
                    fields.add(tbar);

                    total_qty += to.product_qty;
                }
                vatable_sale = sales.amount_due / 1.12;
                vat_percent = vatable_sale * .12;

                String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
                String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
                String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
                String tin_no = System.getProperty("tin_no", "TIN No.: 000000");
                String serial_no = System.getProperty("serial_no", "Serial No.: 000000");
                String permit_no = System.getProperty("permit_no", "Permit No.: 000000");
                String datetime = DateType.slash_w_time.format(new Date());
                String or_no = lbl_gross_amount1.getText();
                String items = System.getProperty("items", "");

                double total_due = sales.amount_due;
                double cash = FitIn.toDouble(lbl_cash.getText());
                double change_due = Payments.countChange2();
                String receipt_infos = System.getProperty("receipt_infos", "");
                String receipt_footer = System.getProperty("receipt_footer", "This is an Official receipt");
                double discount = FitIn.toDouble(lbl_sale_discount.getText());
                String customer_name = sales.customer_name;
                String cashier_name = MyUser.getUser_screen_name();
                String discount_name = sales.discount_customer_name;
                String pos_no = "";

                String accreditation_no = System.getProperty("acct_no", "Accreditation No.: 000000");
                String trans_no = lbl_gross_amount1.getText();
                String check_bank = sales.check_bank;
                double check_amount = sales.check_amount;
                String telephone_number = "please call:" + System.getProperty("telephone_number", "0000-000-0000");
                String discount_customer_name = sales.discount_customer_name;
                String discount_customer_id = sales.discount_customer_id;
                String min_no = System.getProperty("min_no", "MIN No.: 000000");
                double addtl_service = 0;
                String customer_address = "";
                double amount_due = sales.gross_amount;
                double line_discount = sales.line_discount;
                double credit_card = sales.credit_card_amount;
                double gift_certificate = sales.gift_certificate_amount;
                double prepaid = sales.prepaid_amount;
                double charge_amount = sales.charge_amount;
                Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash
                        , change_due, receipt_infos, receipt_footer, discount, customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale
                        , zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name
                        , discount_customer_id, min_no, addtl_service, customer_address, "", amount_due, "", line_discount, credit_card, gift_certificate, prepaid, charge_amount);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_receipt.jrxml";
                InputStream is = Srpt_receipt.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                    String print = System.getProperty("print_to_receipts", "false");
                    System.out.println("Print to Receipts: " + print);
                    if (print.equalsIgnoreCase("true")) {
                        try {
                            if (jasperPrint != null) {
                                JasperPrintManager.printReport(jasperPrint, false);
                            }

                        } catch (JRException e) {
                            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
                            throw new RuntimeException(e);
                        }
                    }

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    private void print_or() {

    }
    JasperPrint jasperPrint = null;

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ok();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_ENTER, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ok();
            }
        });
        tbl_orders.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    ok();
                }

            }
        });
    }
    // </editor-fold>

    private void hover() {
        JButton[] btns = {jButton1, jButton2, jButton3, jButton4};
        final String[] txts = {"Next Customer!", "Print Receipt", "Keep the Change", "Print DR"};
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
    //<editor-fold defaultstate="collapsed" desc=" init table orders ">
    private ArrayListModel tbl_orders_ALM;
    private TblordersModel tbl_orders_M;

    private void init_tbl_order() {
        tbl_orders_ALM = new ArrayListModel();
        tbl_orders_M = new TblordersModel(tbl_orders_ALM);
        tbl_orders.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        tbl_orders.setModel(tbl_orders_M);
        tbl_orders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_orders.setRowHeight(25);
        int[] tbl_widths_items = {40, 40, 50, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_orders, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_orders.getTableHeader().
                getPreferredSize();
        d.height = 35;

        tbl_orders.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 14));
        tbl_orders.setRowHeight(35);
        tbl_orders.setFont(new java.awt.Font("Arial", 0, 14));
        TableWidthUtilities.setColumnRightRenderer(tbl_orders, 3);
        tbl_orders.getColumnModel().getColumn(0).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(1).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(2).setHeaderRenderer(new LostHeaderRenderer());
        tbl_orders.getColumnModel().getColumn(3).setHeaderRenderer(new LostHeaderRenderer());
    }

    private void loadData_orders(List<Inventory_barcodes.to_inventory_barcodes> acc) {
        tbl_orders_ALM.clear();
        tbl_orders_ALM.addAll(acc);

    }

    public static class TblordersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Description", "Qty", "Code", "Amount", "UNIT", "COST", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level"
        };

        public TblordersModel(ListModel listmodel) {
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
                    return " " + tt.description;
                case 1:
                    return "  " + FitIn.fmt_woc(tt.product_qty);
                case 2:
//                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
//                    return " " + uoms.uom;
                    return " " + tt.main_barcode;
                case 3:
                    return FitIn.fmt_wc_0((tt.product_qty * tt.selling_price) - tt.discount_amount) + " ";
                case 4:
                    return tt.unit;
                case 5:
                    return FitIn.fmt_wc_0(tt.cost);
                case 6:
                    return tt.classification;
                case 7:
                    return tt.classification_id;
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
                default:
                    return tt.reorder_level;
            }
        }
    }

    private void ok() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void preview_dr() {
        List<Inventory_barcodes.to_inventory_barcodes> datas = tbl_orders_ALM;
        double sale_discount = FitIn.toDouble(lbl_sale_discount.getText());
        double net_total = FitIn.toDouble(lbl_balance_due.getText());
        Window p = (Window) this;
        Dlg_delivery_print_preview nd = Dlg_delivery_print_preview.create(p, true);
        nd.setTitle("");
        nd.do_pass(datas, sale_discount, net_total, my_sales);
        nd.setCallback(new Dlg_delivery_print_preview.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_delivery_print_preview.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
