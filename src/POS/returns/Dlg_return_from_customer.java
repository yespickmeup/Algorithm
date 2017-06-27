/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.uom;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Field;
import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.returns.Return_from_customer_items.to_return_from_customer_items;

import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.FitIn;
import synsoftech.util.DateType;
import java.awt.Window;
import POS.users.MyUser;
import POS.util.Alert;
import synsoftech.fields.Button;
import synsoftech.util.ImageRenderer;
import POS.util.Dlg_confirm_delete;

/**
 *
 * @author Guinness
 */
public class Dlg_return_from_customer extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_return_from_customer
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
    private Dlg_return_from_customer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_return_from_customer(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_return_from_customer() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_return_from_customer myRef;

    private void setThisRef(Dlg_return_from_customer myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_return_from_customer> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_return_from_customer create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_return_from_customer create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_return_from_customer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_return_from_customer((java.awt.Frame) parent, false);
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
            Dlg_return_from_customer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_return_from_customer((java.awt.Dialog) parent, false);
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

        Dlg_return_from_customer dialog = Dlg_return_from_customer.create(new javax.swing.JFrame(), true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField1 = new Field.Search();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sale_items = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new Field.Search();
        jButton1 = new Button.Default();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sales Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search by:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Transaction No");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Customer Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date from:");

        jDateChooser1.setDate(new Date());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("To:");

        jDateChooser2.setDate(new Date());

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("All");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Transactions:");

        jLabel5.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sale Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

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
        tbl_sale_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sale_itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sale_items);

        jLabel6.setText("No. of Items:");

        jLabel7.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Return/s from Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

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
        jScrollPane3.setViewportView(jTable1);

        jLabel9.setText("No. of Items:");

        jLabel10.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return from Customer", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jLabel8.setText("Total no. of items:");

        jLabel11.setText("0");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Status:");

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Posted");

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Finalized");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Date from:");

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("All");

        jDateChooser3.setDate(new Date());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("to:");

        jDateChooser4.setDate(new Date());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addGap(660, 660, 660)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox7)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel3);

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        ret_sales();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        select_sale();
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void tbl_sale_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sale_itemsMouseClicked
        select_sale_item();
    }//GEN-LAST:event_tbl_sale_itemsMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ret_sale_returned_items();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        select_returned_item();
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbl_sale_items;
    private javax.swing.JTable tbl_sales;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db","db_algorithm");
        init_key();
        init_tbl_sales(tbl_sales);
        init_tbl_sale_items(tbl_sale_items);
        init_tbl_return_from_customer_items(jTable1);
        init_tbl_return_from_customer_items2(jTable2);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTextField1.grabFocus();
            }
        });
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

    //<editor-fold defaultstate="collapsed" desc=" sales "> 
    public static ArrayListModel tbl_sales_ALM;
    public static TblsalesModel tbl_sales_M;

    public static void init_tbl_sales(JTable tbl_sales) {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {120, 70, 100, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    }

    public static void loadData_sales(List<MySales.sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);
    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Date", "Customer", "Amount", "user_id", "session_no", "remarks", "gross_amount", "amount_due", "status", "sales_type", "line_discount", "customer_id", "customer_name", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "charge_type", "charge_type_id", "charge_reference_no", "charge_customer_name", "charge_customer_id", "charge_amount", "check_bank", "check_no", "check_amount", "check_holder", "check_date", "credit_card_type", "credit_card_rate", "credit_card_amount", "credit_card_no", "credit_card_holder", "credit_card_approval_code", "gift_certificate_from", "gift_certificate_description", "gift_certificate_no", "gift_certificate_amount", "prepaid_customer_name", "prepaid_customer_id", "prepaid_amount", "addtl_amount", "wtax", "branch", "branch_id", "location", "location_id"
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
                    return " " + tt.customer_name;
                case 3:
                    return "" + FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 4:
                    return tt.user_id;
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

    private void ret_sales() {
        String where = " where remarks like '%" + "" + "%' ";
        if (jCheckBox1.isSelected()) {
            where = where + " and sales_no like '%" + jTextField1.getText() + "%'";
        } else {
            where = where + " and customer_name like '%" + jTextField1.getText() + "%'";
        }
        if (!jCheckBox3.isSelected()) {
            String date_from = DateType.sf.format(jDateChooser1.getDate());
            String date_to = DateType.sf.format(jDateChooser2.getDate());
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        where = where + " and status=0 order by id asc";
        List<MySales.sales> sales = MySales.ret_data(where);
        loadData_sales(sales);
        jLabel5.setText("" + sales.size());
    }

    private void select_sale() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        MySales.sales sale = (MySales.sales) tbl_sales_ALM.get(row);
        String where = " where sales_no='" + sale.sales_no + "' and status=0 ";
        List<MySales_Items.items> items = MySales_Items.ret_data2(where);
        loadData_sale_items(items);
        jLabel7.setText("" + items.size());

        ret_sale_returned_items(sale.sales_no);

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
        int[] tbl_widths_sale_items = {40, 70, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 3);
    }

    public static void loadData_sale_items(List<MySales_Items.items> acc) {
        tbl_sale_items_ALM.clear();
        tbl_sale_items_ALM.addAll(acc);
    }

    public static class Tblsale_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Price", "", "generic_name", "item_type", "supplier_name", "supplier_id", "serial_no", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_id", "user_screen_name", "status", "is_vatable", "selling_type", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "branch", "branch_code", "location", "location_id", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "brand", "brand_id", "model", "model_id", "addtl_amount", "wtax"
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
            if (col == 4) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            MySales_Items.items tt = (MySales_Items.items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.item_code;
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 4:
                    return tt.selected;
                case 5:
                    return tt.generic_name;
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
                case 38:
                    return tt.model_id;
                case 39:
                    return tt.addtl_amount;
                default:
                    return tt.wtax;
            }
        }
    }

    private void select_sale_item() {
        int row = tbl_sale_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final MySales_Items.items item = (MySales_Items.items) tbl_sale_items_ALM.get(row);
        List<MySales_Items.items> orders = tbl_sale_items_ALM;
        String item_code = item.item_code;
        String description = item.description;
        double ordered = 0;
        double total_returned = 0;
        String reason = "";
        double qty = 1;

        for (MySales_Items.items order : orders) {
            if (order.item_code.equals(item_code)) {
                ordered += order.product_qty;
            }
        }

        List<to_return_from_customer_items> returns = tbl_return_from_customer_items_ALM;
        for (to_return_from_customer_items ret : returns) {
            if (ret.main_barcode.equals(item_code)) {
                total_returned += ret.qty;
            }
        }

        Window p = (Window) this;
        Dlg_return_from_customer_qty nd = Dlg_return_from_customer_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(item_code, description, ordered, total_returned, reason, qty);
        nd.setCallback(new Dlg_return_from_customer_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_return_from_customer_qty.OutputData data) {
                closeDialog.ok();
                post_return(item, data.qty, data.remarks);
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);

    }

    private void post_return(MySales_Items.items item, double to_return, String reason) {
        int id = 0;
        String return_to_supplier_no = "";
        String user_name = MyUser.getUser_screen_name();
        String session_no = MyUser.getUser_id();
        String date_added = DateType.now();
        String supplier = "";
        String supplier_id = "";
        String reference_no = item.sales_no;
        String remarks = reason;
        String barcode = item.barcode;
        String description = item.description;
        String category = item.category;
        String category_id = item.category_id;
        String classification = item.classification;
        String classification_id = item.classification_id;
        String sub_class = item.sub_classification;
        String sub_class_id = item.sub_classification_id;
        String brand = item.brand;
        String brand_id = item.brand_id;
        String model = item.model;
        String model_id = item.model_id;
        double conversion = item.conversion;
        String unit = item.unit;
        String barcodes = "";
        String batch_no = "";
        String serial_no = item.serial_no;
        String main_barcode = item.item_code;
        double qty = to_return;
        double cost = item.selling_price;
        int status = 0;
        String branch = item.branch;
        String branch_id = item.branch_code;
        String location = item.location;
        String location_id = item.location_id;
        Return_from_customer_items.to_return_from_customer_items ret = new to_return_from_customer_items(id, return_to_supplier_no, user_name, session_no, date_added, supplier, supplier_id, reference_no, remarks, barcode, description, category, category_id, classification, classification_id, sub_class, sub_class_id, brand, brand_id, model, model_id, conversion, unit, barcodes, batch_no, serial_no, main_barcode, qty, cost, status, branch, branch_id, location, location_id);
        Return_from_customer_items.add_data(ret);

        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }

        String where2 = " where reference_no='" + item.sales_no + "' and status=0 ";
        List<Return_from_customer_items.to_return_from_customer_items> returned = Return_from_customer_items.ret_data(where2);
        loadData_return_from_customer_items(returned);
        jLabel10.setText("" + returned.size());
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" return_from_customer_items "> 
    public static ArrayListModel tbl_return_from_customer_items_ALM;
    public static Tblreturn_from_customer_itemsModel tbl_return_from_customer_items_M;

    public static void init_tbl_return_from_customer_items(JTable tbl_return_from_customer_items) {
        tbl_return_from_customer_items_ALM = new ArrayListModel();
        tbl_return_from_customer_items_M = new Tblreturn_from_customer_itemsModel(tbl_return_from_customer_items_ALM);
        tbl_return_from_customer_items.setModel(tbl_return_from_customer_items_M);
        tbl_return_from_customer_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_return_from_customer_items.setRowHeight(25);
        int[] tbl_widths_return_from_customer_items = {40, 70, 100, 80, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_return_from_customer_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_return_from_customer_items, i, tbl_widths_return_from_customer_items[i]);
        }
        Dimension d = tbl_return_from_customer_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_return_from_customer_items.getTableHeader().setPreferredSize(d);
        tbl_return_from_customer_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_return_from_customer_items.setRowHeight(25);
        tbl_return_from_customer_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_return_from_customer_items, 3);
        tbl_return_from_customer_items.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_return_from_customer_items(List<to_return_from_customer_items> acc) {
        tbl_return_from_customer_items_ALM.clear();
        tbl_return_from_customer_items_ALM.addAll(acc);
    }

    public static class Tblreturn_from_customer_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Price", "", "supplier", "supplier_id", "reference_no", "remarks", "barcode", "description", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "brand", "brand_id", "model", "model_id", "conversion", "unit", "barcodes", "batch_no", "serial_no", "main_barcode", "qty", "cost", "status", "branch", "branch_id", "location", "location_id"
        };

        public Tblreturn_from_customer_itemsModel(ListModel listmodel) {
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
            to_return_from_customer_items tt = (to_return_from_customer_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 4:
                    if (tt.status == 0) {
                        return "/POS/icon_inventory/question.png";
                    }
                    if (tt.status == 1) {
                        return "/POS/icon_inventory/checked.png";
                    }

                case 6:
                    return tt.supplier_id;
                case 7:
                    return tt.reference_no;
                case 8:
                    return tt.remarks;
                case 9:
                    return tt.barcode;
                case 10:
                    return tt.description;
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
                    return tt.brand;
                case 18:
                    return tt.brand_id;
                case 19:
                    return tt.model;
                case 20:
                    return tt.model_id;
                case 21:
                    return tt.conversion;
                case 22:
                    return tt.unit;
                case 23:
                    return tt.barcodes;
                case 24:
                    return tt.batch_no;
                case 25:
                    return tt.serial_no;
                case 26:
                    return tt.main_barcode;
                case 27:
                    return tt.qty;
                case 28:
                    return tt.cost;
                case 29:
                    return tt.status;
                case 30:
                    return tt.branch;
                case 31:
                    return tt.branch_id;
                case 32:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_sale_returned_items(String sales_no) {
        String where2 = " where reference_no='" + sales_no + "'  ";
        List<Return_from_customer_items.to_return_from_customer_items> returned = Return_from_customer_items.ret_data(where2);
        loadData_return_from_customer_items(returned);
        jLabel10.setText("" + returned.size());
    }

//</editor-fold> 
    
    public static ArrayListModel tbl_return_from_customer_items_ALM2;
    public static Tblreturn_from_customer_itemsModel2 tbl_return_from_customer_items_M2;

    public static void init_tbl_return_from_customer_items2(JTable tbl_return_from_customer_items) {
        tbl_return_from_customer_items_ALM2 = new ArrayListModel();
        tbl_return_from_customer_items_M2 = new Tblreturn_from_customer_itemsModel2(tbl_return_from_customer_items_ALM2);
        tbl_return_from_customer_items.setModel(tbl_return_from_customer_items_M2);
        tbl_return_from_customer_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_return_from_customer_items.setRowHeight(25);
        int[] tbl_widths_return_from_customer_items = {40, 70, 100, 100, 50, 80, 80, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_return_from_customer_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_return_from_customer_items, i, tbl_widths_return_from_customer_items[i]);
        }
        Dimension d = tbl_return_from_customer_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_return_from_customer_items.getTableHeader().setPreferredSize(d);
        tbl_return_from_customer_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_return_from_customer_items.setRowHeight(25);
        tbl_return_from_customer_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_return_from_customer_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_return_from_customer_items, 6);
        tbl_return_from_customer_items.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer());
        tbl_return_from_customer_items.getColumnModel().getColumn(8).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_return_from_customer_items2(List<to_return_from_customer_items> acc) {
        tbl_return_from_customer_items_ALM2.clear();
        tbl_return_from_customer_items_ALM2.addAll(acc);
    }

    
    
    public static class Tblreturn_from_customer_itemsModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Reason", "Unit", "Price", "Amount", "", "", "", "description", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "brand", "brand_id", "model", "model_id", "conversion", "unit", "barcodes", "batch_no", "serial_no", "main_barcode", "qty", "cost", "status", "branch", "branch_id", "location", "location_id"
        };
        
        public Tblreturn_from_customer_itemsModel2(ListModel listmodel) {
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
            to_return_from_customer_items tt = (to_return_from_customer_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return " " + tt.remarks;
                case 4:
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 5:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.cost * tt.qty) + " ";
                case 7:
                    return "/POS/icon_inventory/clear-button.png";
                case 8:
                    if (tt.status == 0) {
                        return "/POS/icon_inventory/question.png";
                    }
                    if (tt.status == 1) {
                        return "/POS/icon_inventory/checked.png";
                    }
                case 10:
                    return tt.description;
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
                    return tt.brand;
                case 18:
                    return tt.brand_id;
                case 19:
                    return tt.model;
                case 20:
                    return tt.model_id;
                case 21:
                    return tt.conversion;
                case 22:
                    return tt.unit;
                case 23:
                    return tt.barcodes;
                case 24:
                    return tt.batch_no;
                case 25:
                    return tt.serial_no;
                case 26:
                    return tt.main_barcode;
                case 27:
                    return tt.qty;
                case 28:
                    return tt.cost;
                case 29:
                    return tt.status;
                case 30:
                    return tt.branch;
                case 31:
                    return tt.branch_id;
                case 32:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }
    
    private void ret_sale_returned_items() {
        String where2 = " where supplier like '%" + "" + "%' ";
        if (!jCheckBox7.isSelected()) {
            String date_from = DateType.sf.format(jDateChooser3.getDate());
            String date_to = DateType.sf.format(jDateChooser4.getDate());
            where2 = where2 + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (jCheckBox5.isSelected()) {
            where2 = where2 + " and status=0 ";
        }
        if (jCheckBox6.isSelected()) {
            where2 = where2 + " and status=1 ";
        }
        where2 = where2 + " order by id desc";
        List<Return_from_customer_items.to_return_from_customer_items> returned = Return_from_customer_items.ret_data(where2);
        loadData_return_from_customer_items2(returned);
        jLabel11.setText("" + returned.size());
    }

    private void select_returned_item() {
        int row = jTable2.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_return_from_customer_items item = (to_return_from_customer_items) tbl_return_from_customer_items_ALM2.get(row);
        int col = jTable2.getSelectedColumn();
        if (col == 7) {
            if (item.status == 1) {
                Alert.set(0, "Cannot proceed, item has been finalized!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Return_from_customer_items.delete_data(item);
                    Alert.set(3, "");
                    ret_sale_returned_items();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 8) {
            Window p = (Window) this;
            Dlg_return_from_customer_finalize nd = Dlg_return_from_customer_finalize.create(p, true);
            nd.setTitle("");
            nd.do_pass(item.main_barcode, item.description, item.qty, item.remarks);
            nd.setCallback(new Dlg_return_from_customer_finalize.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_return_from_customer_finalize.OutputData data) {
                    closeDialog.ok();
                    Return_from_customer_items.finalize(item);
                    Alert.set(2, "");
                    ret_sale_returned_items();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
}
