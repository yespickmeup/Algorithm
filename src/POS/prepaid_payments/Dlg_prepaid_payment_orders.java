/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_payments;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.uom;
import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.util.DateType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Guinness
 */
public class Dlg_prepaid_payment_orders extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_prepaid_payment_ordered_items
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
    private Dlg_prepaid_payment_orders(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_prepaid_payment_orders(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_prepaid_payment_orders() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_prepaid_payment_orders myRef;

    private void setThisRef(Dlg_prepaid_payment_orders myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_prepaid_payment_orders> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_prepaid_payment_orders create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_prepaid_payment_orders create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_prepaid_payment_orders dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_prepaid_payment_orders((java.awt.Frame) parent, false);
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
            Dlg_prepaid_payment_orders dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_prepaid_payment_orders((java.awt.Dialog) parent, false);
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

        Dlg_prepaid_payment_orders dialog = Dlg_prepaid_payment_orders.create(new javax.swing.JFrame(), true);
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
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Total no. of rows:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Amount:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total no. of items");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Orders", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 872, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Print Preview", jPanel5);

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
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      select_sale_items();
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_sales(jTable1);
        init_tbl_sale_items(jTable2);

    }

    public void do_pass(String customer_id) {
        String where = " where prepaid_customer_id='" + customer_id + "' ";
        List<MySales.sales> sales = MySales.ret_data(where);
        loadData_sales(sales);
        double prepaid = 0;

        for (MySales.sales sale : sales) {
            prepaid += sale.prepaid_amount;
        }
        jLabel2.setText("" + sales.size());
        jLabel6.setText(FitIn.fmt_wc_0(prepaid));
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

    //<editor-fold defaultstate="collapsed" desc=" sales "> 
    public static ArrayListModel tbl_sales_ALM;
    public static TblsalesModel tbl_sales_M;

    public static void init_tbl_sales(JTable tbl_sales) {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {120, 80, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_sales[i]);
        }
        Dimension d = tbl_sales.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_sales.getTableHeader().setPreferredSize(d);
        tbl_sales.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_sales.setRowHeight(25);
        tbl_sales.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 4);
    }

    public static void loadData_sales(List<MySales.sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);
    }

    
    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Date", "Added By", "Amount Due", "Prepayment", "session_no", "remarks", "gross_amount", "amount_due", "status", "sales_type", "line_discount", "customer_id", "customer_name", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "charge_type", "charge_type_id", "charge_reference_no", "charge_customer_name", "charge_customer_id", "charge_amount", "check_bank", "check_no", "check_amount", "check_holder", "check_date", "credit_card_type", "credit_card_rate", "credit_card_amount", "credit_card_no", "credit_card_holder", "credit_card_approval_code", "gift_certificate_from", "gift_certificate_description", "gift_certificate_no", "gift_certificate_amount", "prepaid_customer_name", "prepaid_customer_id", "prepaid_amount", "addtl_amount", "wtax", "branch", "branch_id", "location", "location_id"
        };

        public TblsalesModel(ListModel listmodel) {
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
            MySales.sales tt = (MySales.sales) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.sales_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.user_screen_name;
                case 3:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.prepaid_amount) + " ";
                case 5:
                    return tt.session_no;
                case 6:
                    return tt.remarks;
                case 7:
                    return tt.gross_amount;
                case 8:
                    return tt.amount_due;
                case 9:
                    return tt.status;
                case 10:
                    return tt.sales_type;
                case 11:
                    return tt.line_discount;
                case 12:
                    return tt.customer_id;
                case 13:
                    return tt.customer_name;
                case 14:
                    return tt.discount_name;
                case 15:
                    return tt.discount_rate;
                case 16:
                    return tt.discount_amount;
                case 17:
                    return tt.discount_customer_name;
                case 18:
                    return tt.discount_customer_id;
                case 19:
                    return tt.charge_type;
                case 20:
                    return tt.charge_type_id;
                case 21:
                    return tt.charge_reference_no;
                case 22:
                    return tt.charge_customer_name;
                case 23:
                    return tt.charge_customer_id;
                case 24:
                    return tt.charge_amount;
                case 25:
                    return tt.check_bank;
                case 26:
                    return tt.check_no;
                case 27:
                    return tt.check_amount;
                case 28:
                    return tt.check_holder;
                case 29:
                    return tt.check_date;
                case 30:
                    return tt.credit_card_type;
                case 31:
                    return tt.credit_card_rate;
                case 32:
                    return tt.credit_card_amount;
                case 33:
                    return tt.credit_card_no;
                case 34:
                    return tt.credit_card_holder;
                case 35:
                    return tt.credit_card_approval_code;
                case 36:
                    return tt.gift_certificate_from;
                case 37:
                    return tt.gift_certificate_description;
                case 38:
                    return tt.gift_certificate_no;
                case 39:
                    return tt.gift_certificate_amount;
                case 40:
                    return tt.prepaid_customer_name;
                case 41:
                    return tt.prepaid_customer_id;
                case 42:
                    return tt.prepaid_amount;
                case 43:
                    return tt.addtl_amount;
                case 44:
                    return tt.wtax;
                case 45:
                    return tt.branch;
                case 46:
                    return tt.branch_id;
                case 47:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" sale_items "> 
    public static ArrayListModel tbl_sale_items_ALM;
    public static Tblsale_itemsModel tbl_sale_items_M;

    public static void init_tbl_sale_items(JTable tbl_sale_items) {
        tbl_sale_items_ALM = new ArrayListModel();
        tbl_sale_items_M = new Tblsale_itemsModel(tbl_sale_items_ALM);
        tbl_sale_items.setModel(tbl_sale_items_M);
        tbl_sale_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sale_items.setRowHeight(25);
        int[] tbl_widths_sale_items = {80, 80, 10, 60, 60, 80, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sale_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sale_items, i, tbl_widths_sale_items[i]);
        }
        Dimension d = tbl_sale_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_sale_items.getTableHeader().setPreferredSize(d);
        tbl_sale_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_sale_items.setRowHeight(25);
        tbl_sale_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 7);
    }

    public static void loadData_sale_items(List<MySales_Items.items> acc) {
        tbl_sale_items_ALM.clear();
        tbl_sale_items_ALM.addAll(acc);
    }

    public static class Tblsale_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Item Code", "Barcode", "Description", "Qty", "Unit", "Discount", "Price", "Amount", "supplier_id", "serial_no", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_id", "user_screen_name", "status", "is_vatable", "selling_type", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "branch", "branch_code", "location", "location_id", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "brand", "brand_id", "model", "model_id", "addtl_amount", "wtax"
        };

        public Tblsale_itemsModel(ListModel listmodel) {
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
            MySales_Items.items tt = (MySales_Items.items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.item_code;
                case 1:
                    return " " + tt.barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 4:
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 5:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 7:
                    double amount = (tt.product_qty * tt.selling_price) - tt.discount_amount;
                    return FitIn.fmt_wc_0(amount) + " ";
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
                case 38:
                    return tt.model_id;
                case 39:
                    return tt.addtl_amount;
                default:
                    return tt.wtax;
            }
        }
    }
//</editor-fold> 

    private void select_sale_items() {
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            return;
        }
        MySales.sales sale = (MySales.sales) tbl_sales_ALM.get(row);
        String where = " where sales_no='" + sale.sales_no + "' ";
        List< MySales_Items.items> items = MySales_Items.ret_data2(where);
        loadData_sale_items(items);
        jLabel4.setText("" + items.size());
    }
}
