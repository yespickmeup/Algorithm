/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.bir.Acknowledgement_receipt;
import POS.bir.Delivery_receipt;
import POS.bir.Official_receipt;
import POS.inventory.Inventory_barcodes;
import POS.my_sales.MySales;
import POS.reports.Dlg_report_items;
import POS.users.MyUser;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_touchscreen_choose_receipt_type extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_choose_receipt_type
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
    private Dlg_touchscreen_choose_receipt_type(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_choose_receipt_type(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_choose_receipt_type() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_choose_receipt_type myRef;

    private void setThisRef(Dlg_touchscreen_choose_receipt_type myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_choose_receipt_type> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_choose_receipt_type create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_choose_receipt_type create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_choose_receipt_type dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_choose_receipt_type((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_choose_receipt_type dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_choose_receipt_type((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_choose_receipt_type dialog = Dlg_touchscreen_choose_receipt_type.create(new javax.swing.JFrame(), true);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnl_report_or = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        pnl_report_ar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new Button.Success();
        jButton4 = new Button.Default();
        jPanel4 = new javax.swing.JPanel();
        pnl_report_dr = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton5 = new Button.Success();
        jButton6 = new Button.Default();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_report_orLayout = new javax.swing.GroupLayout(pnl_report_or);
        pnl_report_or.setLayout(pnl_report_orLayout);
        pnl_report_orLayout.setHorizontalGroup(
            pnl_report_orLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_report_orLayout.setVerticalGroup(
            pnl_report_orLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(622, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_report_or, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_report_or, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Official Receipt", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_report_arLayout = new javax.swing.GroupLayout(pnl_report_ar);
        pnl_report_ar.setLayout(pnl_report_arLayout);
        pnl_report_arLayout.setHorizontalGroup(
            pnl_report_arLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_report_arLayout.setVerticalGroup(
            pnl_report_arLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jButton3.setText("Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(622, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_report_ar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_report_ar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Acknowledgement Receipt", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_report_drLayout = new javax.swing.GroupLayout(pnl_report_dr);
        pnl_report_dr.setLayout(pnl_report_drLayout);
        pnl_report_drLayout.setHorizontalGroup(
            pnl_report_drLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_report_drLayout.setVerticalGroup(
            pnl_report_drLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(622, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_report_dr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_report_dr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Delivery Receipt", jPanel4);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        print_ar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        print_dr();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        print_or();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnl_report_ar;
    private javax.swing.JPanel pnl_report_dr;
    private javax.swing.JPanel pnl_report_or;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
    }

    public void do_pass(List<Inventory_barcodes.to_inventory_barcodes> orders, double sale_discount1, double net_totals, MySales.sales sale, double cash_amount, double change_amount,String sales_date) {
        String business_name = System.getProperty("business_name", "XYZ Marketing");
        String operated_by = "Operated by: " + System.getProperty("operated_by", "Juan dela Cruz");
        String address = System.getProperty("address", "Canlas Subdivision, Lower Bagacay, Dumaguete City, Negros Oriental");
        String tin_no = "TIN NO: " + System.getProperty("tin_no", "0000000000");
        String machine_no = System.getProperty("machine_no", "0000000000");
        String min_no = "MIN NO: " + System.getProperty("min_no", "0000000000");
        String serial_no = "Serial No.: " + System.getProperty("serial_no", "0000000000");
        String permit_no = "Permit No.: " + System.getProperty("permit_no", "0000000000");

        String pos_no = System.getProperty("pos_no", "0000000000");
        String accreditation_no = System.getProperty("accreditation_no", "0000000000");
        String business_type = System.getProperty("business_type", "VAT REG");
        String vat_percent = System.getProperty("vat_percent", "12");
        
        String terminal_no = "Terminal No.: " + System.getProperty("terminal_no", "0001");
        String cashier = "Cashier: " + MyUser.getUser_screen_name();
        String customer_name = "" + sale.customer_name;
        String customer_address = "Address: ";
        String customer_id_no = "ID/TIN No.: ";

        double sub_total = net_totals;
        double line_discount = sale.line_discount;
        double sale_discount = sale_discount1;
        double amount_due = sale.amount_due;
        double cash = cash_amount;
        String credit_card_type = sale.credit_card_type;
        double credit_card_rate = sale.credit_card_rate;
        double credit_card_amount = sale.credit_card_amount;
        String credit_card_no = sale.credit_card_no;
        String credit_card_holder = sale.credit_card_holder;
        String credit_card_approval_code = sale.credit_card_approval_code;
        String gift_certificate_from = sale.gift_certificate_from;
        String gift_certificate_description = sale.gift_certificate_description;
        String gift_certificate_no = sale.gift_certificate_no;
        double gift_certificate_amount = sale.gift_certificate_amount;
        String prepaid_customer_name = sale.prepaid_customer_name;
        String prepaid_customer_id = sale.prepaid_customer_id;
        double prepaid_amount = sale.prepaid_amount;
        String cheque_holder = sale.check_holder;
        String cheque_bank = sale.check_bank;
        String cheque_no = sale.check_no;
        String cheque_date = sale.check_date;
        double cheque_amount = sale.check_amount;
        String charge_type = sale.charge_type;
        String charge_reference_no = sale.charge_reference_no;
        String charge_customer_name = sale.charge_customer_name;
        String charge_customer_no = sale.charge_customer_id;
        double charge_amount = sale.charge_amount;

        double total_items = 0;
        double vatable_sales = 0;
        double vatable_exempt_sales = 0;
        double zero_rated_sales = 0;
        double vat = 0;
        double vat_percent1 = 0;
        double change = change_amount;
        System.out.println("change: " + change);
        String or_no = sale.sales_no;//"OR No.: " + sale.sales_no;
        int index = or_no.indexOf("|");
        or_no = or_no.substring(index + 1, or_no.length());
        or_no = "OR No.: " + or_no;
        String receipt_footer = System.getProperty("receipt_footer", "THIS INVOICE/RECEIPT SHALL BE VALID FOR FIVE(5) YEARS FROM THE DATE OF THE PERMIT TO USE\nTHIS DOCUMENT IS NOT VALID FOR CLAIM OF INPUT TAX");
        String supplier_name = "Supplier: " + System.getProperty("developer", "Synapse Software Technologies");
        String supplier_address = System.getProperty("developer_address", "Daro, Dumaguete City, Negros Oriental");
        String supplier_tin_no = "TIN No.: " + System.getProperty("developer_tin_no", "0000000000");
        String supplier_accreditation_no = "Accreditation No.: " + System.getProperty("developer_accreditation_no", "0000000000");
        String supplier_accreditation_date = "Accreditation Date: " + System.getProperty("developer_accreditation_date", "mm/dd/yyyy");
        String bir_permit_to_use_no = "PTU No.: " + System.getProperty("bir_permit_to_use_no", "0000000000");
        List<Official_receipt.field> fields = new ArrayList();

        for (Inventory_barcodes.to_inventory_barcodes field : orders) {
            String item_code = field.main_barcode;
            String barcode = field.barcode;
            String description = field.description;
            String unit = field.unit;
            double qty = field.product_qty;
            double selling_price = field.selling_price;
            double line_discount1 = field.discount_amount;
            double amount = ((qty * selling_price));
            String vatable = "V";
            double addt_amount = field.addtl_amount;
            double wtax = field.wtax;
            String serial_nos = field.serial_no;
            double net_total = amount - line_discount1;
            Official_receipt.field f = new Official_receipt.field(item_code, barcode, description, unit, qty, selling_price, line_discount, amount, vatable, addt_amount, wtax, serial_nos, net_total);
            fields.add(f);

            total_items += field.product_qty;
        }
        vatable_sales = sale.amount_due / 1.12;
        vat_percent1 = vatable_sales * .12;
        vat = vat_percent1;
        final Official_receipt rpt = new Official_receipt(business_name, operated_by, address, tin_no, machine_no, min_no, serial_no, permit_no, pos_no, accreditation_no, business_type, vat_percent, sales_date, terminal_no, cashier, customer_name, customer_address, customer_id_no, sub_total, line_discount, sale_discount, amount_due, cash, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, cheque_amount, charge_type, charge_reference_no, charge_customer_name, charge_customer_no, charge_amount, vatable_sales, vatable_exempt_sales, zero_rated_sales, vat, change, or_no, receipt_footer, supplier_name, supplier_address, supplier_tin_no, supplier_accreditation_no, supplier_accreditation_date, bir_permit_to_use_no, total_items);

        rpt.fields.addAll(fields);

        init_report_or(rpt);

        init_report_ar(rpt);

        init_report_dr(rpt);

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

    //<editor-fold defaultstate="collapsed" desc=" Official Receipt ">
    private void init_report_or(final Official_receipt rpt) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String jrxml = "rpt_official_receipt.jrxml";
                report_or(rpt, jrxml);
                InputStream is = Official_receipt.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t.start();
    }

    private void report_or(final Official_receipt to, String jrxml_name) {
        pnl_report_or.removeAll();
        pnl_report_or.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_or(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report_or.add(viewer);
            pnl_report_or.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_or(Official_receipt to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_or(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_or(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Official_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint = null;
    JasperPrint jasperPrint2 = null;
    JasperPrint jasperPrint3 = null;

    private void print_or() {
        try {
            if (jasperPrint != null) {
                JasperPrintManager.printReport(jasperPrint, false);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Acknowlegement Receipt ">
    private void init_report_ar(final Official_receipt or) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                String business_name = or.business_name;
                String operated_by = or.operated_by;
                String address = or.address;
                String tin_no = or.tin_no;
                String machine_no = or.machine_no;
                String min_no = or.min_no;
                String serial_no = or.serial_no;
                String permit_no = or.permit_no;
                String pos_no = or.pos_no;
                String accreditation_no = or.accreditation_no;
                String business_type = or.business_type;
                String vat_percent = or.vat_percent;
                String sales_date = or.sales_date;
                String terminal_no = or.terminal_no;
                String cashier = or.cashier;
                String customer_name = "" + or.customer_name;
                String customer_address = or.customer_address;
                String customer_id_no = or.customer_id_no;
                double sub_total = or.sub_total;
                double line_discount = or.line_discount;
                double sale_discount = or.sale_discount;
                double amount_due = or.amount_due;
                double cash = or.cash;
                String credit_card_type = or.credit_card_type;
                double credit_card_rate = or.credit_card_rate;
                double credit_card_amount = or.credit_card_amount;
                String credit_card_no = or.credit_card_no;
                String credit_card_holder = or.credit_card_holder;
                String credit_card_approval_code = or.credit_card_approval_code;
                String gift_certificate_from = or.gift_certificate_from;
                String gift_certificate_description = or.gift_certificate_description;
                String gift_certificate_no = or.gift_certificate_no;
                double gift_certificate_amount = or.gift_certificate_amount;
                String prepaid_customer_name = or.prepaid_customer_name;
                String prepaid_customer_id = or.prepaid_customer_id;
                double prepaid_amount = or.prepaid_amount;
                String cheque_holder = or.cheque_holder;
                String cheque_bank = or.cheque_bank;
                String cheque_no = or.cheque_no;
                String cheque_date = or.cheque_date;
                double cheque_amount = or.cheque_amount;
                String charge_type = or.charge_type;
                String charge_reference_no = or.charge_reference_no;
                String charge_customer_name = or.charge_customer_name;
                String charge_customer_no = or.charge_customer_no;
                double charge_amount = or.charge_amount;
                double vatable_sales = or.vatable_sales;
                double vatable_exempt_sales = or.vatable_exempt_sales;
                double zero_rated_sales = or.zero_rated_sales;
                double vat = or.vat;
                double change = or.change;
                double total_items = 0;
                String or_no = or.or_no;
                String receipt_footer = or.receipt_footer;
                String supplier_name = or.supplier_name;
                String supplier_address = or.supplier_address;
                String supplier_tin_no = or.supplier_tin_no;
                String supplier_accreditation_no = or.supplier_accreditation_no;
                String supplier_accreditation_date = or.supplier_accreditation_date;
                String bir_permit_to_use_no = or.bir_permit_to_use_no;
                List<Acknowledgement_receipt.field> fields = new ArrayList();
                for (Official_receipt.field field : or.fields) {
                    String item_code = field.getItem_code();
                    String barcode = field.getBarcode();
                    String description = field.getDescription();
                    String unit = field.getUnit();
                    double qty = field.getQty();
                    double selling_price = field.getSelling_price();
                    double line_discount1 = field.getLine_discount();
                    double amount = field.getAmount();
                    String vatable = field.getVatable();
                    total_items += field.getQty();
                    Acknowledgement_receipt.field f = new Acknowledgement_receipt.field(item_code, barcode, description, unit, qty, selling_price, line_discount, amount, vatable);
                    fields.add(f);
                }

                Acknowledgement_receipt rpt = new Acknowledgement_receipt(business_name, operated_by, address, tin_no, machine_no, min_no, serial_no, permit_no, pos_no, accreditation_no, business_type, vat_percent, sales_date, terminal_no, cashier, customer_name, customer_address, customer_id_no, sub_total, line_discount, sale_discount, amount_due, cash, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, cheque_holder, cheque_bank, cheque_no, cheque_date, cheque_amount, charge_type, charge_reference_no, charge_customer_name, charge_customer_no, charge_amount, vatable_sales, vatable_exempt_sales, zero_rated_sales, vat, change, or_no, receipt_footer, supplier_name, supplier_address, supplier_tin_no, supplier_accreditation_no, supplier_accreditation_date, bir_permit_to_use_no, total_items);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_acknowledgement_receipt.jrxml";
                report_ar(rpt, jrxml);
                InputStream is = Acknowledgement_receipt.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint2 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t.start();
    }

    private void report_ar(final Acknowledgement_receipt to, String jrxml_name) {
        pnl_report_ar.removeAll();
        pnl_report_ar.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_ar(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report_ar.add(viewer);
            pnl_report_ar.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_ar(Acknowledgement_receipt to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_ar(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_ar(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Acknowledgement_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void print_ar() {
        try {
            if (jasperPrint2 != null) {
                JasperPrintManager.printReport(jasperPrint2, false);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Delivery Receipt ">
    private void init_report_dr(final Official_receipt or) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro, national Highway, Dumaguete City");
                String contact_no = "035 22556926 / 422-9026"
                        + "\n035 4221953"
                        + "\n903-215-145V\n";
                String transaction_no = or.or_no;
                transaction_no = transaction_no.replace("OR No.: ", "");
                String date = or.sales_date;
                String remarks = "";
                String prepared_by = "";
                String approved_by = "";
                String customer_name = "" + or.customer_name;

                String customer_address = "";
                double sale_discount = or.sale_discount;
                double net_total = or.sub_total;
                List<Delivery_receipt.field> fields = new ArrayList();
                for (Official_receipt.field field : or.fields) {
                    double qty = field.getQty();
                    String item_code = field.getItem_code();
                    String barcode = field.getBarcode();
                    String description = field.getDescription();
                    String unit = field.getUnit();
                    double price = field.getSelling_price();
                    double line_discount = field.getLine_discount();
                    double addtl_amount = field.getAddt_amount();
                    double wtax = field.getWtax();
                    double gross_total = field.getAmount();
                    double net_total1 = field.getNet_total();
                    String serial_nos = field.getSerial_nos();

                    Delivery_receipt.field f = new Delivery_receipt.field(qty, item_code, barcode, description, unit, price, line_discount, addtl_amount, wtax, gross_total, net_total1, serial_nos);
                    fields.add(f);
                }
                String pool_db = System.getProperty("pool_db", "db_smis");
                String title = "Delivery Receipt";
                if (pool_db.equalsIgnoreCase("db_smis_siaton")) {
                    title = "Authority to Withdraw";
                }
                Delivery_receipt rpt = new Delivery_receipt(business_name, address, contact_no, transaction_no, date, remarks, prepared_by, approved_by, sale_discount, net_total, customer_name, customer_address, title);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_delivery_receipt.jrxml";

                report_dr(rpt, jrxml);
                InputStream is = Delivery_receipt.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint2 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t.start();
    }

    private void report_dr(final Delivery_receipt to, String jrxml_name) {
        pnl_report_dr.removeAll();
        pnl_report_dr.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_dr(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report_dr.add(viewer);
            pnl_report_dr.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_dr(Delivery_receipt to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_dr(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_dr(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Delivery_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void print_dr() {
        try {
            if (jasperPrint3 != null) {
                JasperPrintManager.printReport(jasperPrint3, false);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
    //</editor-fold>
}
