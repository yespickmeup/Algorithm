/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.my_services.My_services;
import POS.my_services.My_services_departments;
import POS.my_services.S1_my_services_item_replacements_customers;
import POS.receipts.Warranties;
import POS.receipts.Warranty_items;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.Dlg_confirm_action;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer1;

/**
 *
 * @author User
 */
public class Dlg_touchscreen_slip_no extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_slip_no
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

        public final List<My_services.to_my_services> to;
        public final List<Warranties.to_warranties> asus;

        public OutputData(List<My_services.to_my_services> to, List<Warranties.to_warranties> asus) {
            this.to = to;
            this.asus = asus;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_slip_no(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_slip_no(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_slip_no() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_slip_no myRef;

    private void setThisRef(Dlg_touchscreen_slip_no myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_slip_no> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_slip_no create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_slip_no create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_slip_no dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_slip_no((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_slip_no dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_slip_no((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_slip_no dialog = Dlg_touchscreen_slip_no.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_warranties = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jLabel7 = new javax.swing.JLabel();
        tf_department1 = new Field.Combo();
        jCheckBox11 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_warranties2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_warranty_items = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new Button.Success();
        jButton6 = new Button.Default();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_asus = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new Field.Search();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_asus2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_asus_items = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new Button.Success();
        jButton9 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(236, 233, 233));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search TSG Records", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
        jScrollPane1.setViewportView(tbl_warranties);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Department:");

        tf_department1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_department1MouseClicked(evt);
            }
        });
        tf_department1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_department1ActionPerformed(evt);
            }
        });

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("All");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_department1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_department1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Added Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_warranties2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_warranties2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_warranties2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_warranties2);

        jLabel3.setText("No. of rows:");

        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_warranty_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_warranty_items);

        jLabel5.setText("No. of rows:");

        jLabel6.setText("0");

        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("TSG", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search ASUS Records", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_asus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_asus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_asusMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_asus);

        jLabel8.setText("No. of rows:");

        jLabel9.setText("0");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Department:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Added Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_asus2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_asus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_asus2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_asus2);

        jLabel11.setText("No. of rows:");

        jLabel12.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_asus_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tbl_asus_items);

        jLabel13.setText("No. of rows:");

        jLabel14.setText("0");

        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Cancel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("ASUS Service Center", jPanel6);

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
        ret_warranties();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_warrantiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_warrantiesMouseClicked
        select_slip_no();
    }//GEN-LAST:event_tbl_warrantiesMouseClicked

    private void tbl_warranties2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_warranties2MouseClicked
        select_slip_no2();
    }//GEN-LAST:event_tbl_warranties2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        confirm_action();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_department1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_department1ActionPerformed
        init_departments();
    }//GEN-LAST:event_tf_department1ActionPerformed

    private void tf_department1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_department1MouseClicked
        init_departments();
    }//GEN-LAST:event_tf_department1MouseClicked

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed

    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void tbl_asusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_asusMouseClicked
        select_asus();
    }//GEN-LAST:event_tbl_asusMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        ret_asus();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tbl_asus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_asus2MouseClicked
        select_slip_no3();
    }//GEN-LAST:event_tbl_asus2MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        confirm_action();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox11;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbl_asus;
    private javax.swing.JTable tbl_asus2;
    private javax.swing.JTable tbl_asus_items;
    private javax.swing.JTable tbl_warranties;
    private javax.swing.JTable tbl_warranties2;
    private javax.swing.JTable tbl_warranty_items;
    private javax.swing.JTextField tf_department1;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_password", "password");

        init_key();

        init_tbl_warranties(tbl_warranties);
        init_tbl_warranties2(tbl_warranties2);
        init_tbl_warranty_items(tbl_warranty_items);

        init_tbl_asus(tbl_asus);
        init_tbl_asus2(tbl_asus2);
        init_tbl_asus_items(tbl_asus_items);

        String where = " order by department asc ";
        department_list = My_services_departments.ret_data(where);
        if (!department_list.isEmpty()) {
            My_services_departments.to_my_services_departments to = (My_services_departments.to_my_services_departments) department_list.get(0);
            Field.Combo dep = (Field.Combo) tf_department1;
            dep.setId("6");
            dep.setText("TSG1");
        }
        jTextField1.grabFocus();
    }

    public void do_pass(List<My_services.to_my_services> slip_nos, List<Warranties.to_warranties> asus) {

        loadData_warranties2(slip_nos);
        jLabel4.setText("" + slip_nos.size());

        loadData_asus2(asus);
        jLabel12.setText("" + asus.size());

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

    //<editor-fold defaultstate="collapsed" desc=" warranties "> 
    public static ArrayListModel tbl_warranties_ALM;
    public static TblwarrantiesModel tbl_warranties_M;

    public static void init_tbl_warranties(JTable tbl_warranties) {
        tbl_warranties_ALM = new ArrayListModel();
        tbl_warranties_M = new TblwarrantiesModel(tbl_warranties_ALM);
        tbl_warranties.setModel(tbl_warranties_M);
        tbl_warranties.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranties.setRowHeight(25);
        int[] tbl_widths_warranties = {100, 140, 80, 40, 40, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranties.length; i < n; i++) {
            if (i == 0) {
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
        tbl_warranties.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_warranties(List<My_services.to_my_services> acc) {
        tbl_warranties_ALM.clear();
        tbl_warranties_ALM.addAll(acc);
    }

    public static class TblwarrantiesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Slip No", "Created", "", "", "Status", "", "created_at", "created_by", "branch", "branch_id", "location", "location_id"

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
            My_services.to_my_services tt = (My_services.to_my_services) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.service_slip_no;
                case 2:
                    return " " + DateType.convert_slash_datetime2(tt.date_assigned);
                case 3:
                    if (tt.status == 0) {
                        try {
                            Date d = DateType.sf.parse(tt.date_assigned);
                            int days = DateUtils1.count_days(d, new Date());
                            if (days > 10) {
                                return "/POS/icons/check-mark (3).png";
                            } else {
                                return "/POS/icons/check-mark (2).png";
                            }
                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }
                    }
                    if (tt.status == 1) {
                        return "/POS/icons/check-mark (1).png";
                    }
                    if (tt.status == 2) {
                        return "/POS/icons/check-mark.png";
                    }
                    if (tt.status == 3) {
                        return "/POS/icons/check-mark (4).png";
                    }
                case 4:
                    return "  Add";
                case 5:
                    return " Edit";
                case 6:
                    return " Delete";
                case 7:
                    return tt.date_assigned;
                case 8:
                    return tt.date_assigned;
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

    private void ret_warranties() {
        Field.Combo dep = (Field.Combo) tf_department1;

        String search = jTextField1.getText();
        String where = " where service_slip_no like '%" + search + "%' and status<2  order by service_slip_no asc";

        if (!jCheckBox11.isSelected()) {
            where = " where service_slip_no like '%" + search + "%' and status<2 and department_id='" + dep.getId() + "' order by service_slip_no asc";

        }
        List<My_services.to_my_services> datas = My_services.ret_data(where);
        loadData_warranties(datas);
        jLabel2.setText("" + datas.size());
    }

    private void select_slip_no() {
        int row = tbl_warranties.getSelectedRow();
        if (row < 0) {
            return;
        }
        My_services.to_my_services to = (My_services.to_my_services) tbl_warranties_ALM.get(row);

        int col = tbl_warranties.getSelectedColumn();
        if (col == 4) {
            List< My_services.to_my_services> added = tbl_warranties_ALM2;
            int exist = 0;
            for (My_services.to_my_services warranty : added) {
                if (warranty.transaction_no.equalsIgnoreCase(to.transaction_no)) {
                    exist = 1;
                    break;
                }
            }
            if (exist == 0) {
                tbl_warranties_ALM2.add(to);
            } else {
                Alert.set(0, "Already added!");
            }
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" warranties "> 
    public static ArrayListModel tbl_warranties_ALM2;
    public static TblwarrantiesModel2 tbl_warranties_M2;

    public static void init_tbl_warranties2(JTable tbl_warranties2) {
        tbl_warranties_ALM2 = new ArrayListModel();
        tbl_warranties_M2 = new TblwarrantiesModel2(tbl_warranties_ALM2);
        tbl_warranties2.setModel(tbl_warranties_M2);
        tbl_warranties2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranties2.setRowHeight(25);
        int[] tbl_widths_warranties = {100, 140, 80, 40, 60, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranties.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_warranties2, i, tbl_widths_warranties[i]);
        }
        Dimension d = tbl_warranties2.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_warranties2.getTableHeader().setPreferredSize(d);
        tbl_warranties2.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_warranties2.setRowHeight(25);
        tbl_warranties2.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_warranties2.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_warranties2(List< My_services.to_my_services> acc) {
        tbl_warranties_ALM2.clear();
        tbl_warranties_ALM2.addAll(acc);
    }

    public static class TblwarrantiesModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Slip No", "Created", "", "", "Status", "", "created_at", "created_by", "branch", "branch_id", "location", "location_id"

        };

        public TblwarrantiesModel2(ListModel listmodel) {
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
            My_services.to_my_services tt = (My_services.to_my_services) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.service_slip_no;
                case 2:
                    return " " + DateType.convert_slash_datetime2(tt.date_assigned);
                case 3:
                    if (tt.status == 0) {
                        try {
                            Date d = DateType.sf.parse(tt.date_assigned);
                            int days = DateUtils1.count_days(d, new Date());
                            if (days > 10) {
                                return "/POS/icons/check-mark (3).png";
                            } else {
                                return "/POS/icons/check-mark (2).png";
                            }
                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }
                    }
                    if (tt.status == 1) {
                        return "/POS/icons/check-mark (1).png";
                    }
                    if (tt.status == 2) {
                        return "/POS/icons/check-mark.png";
                    }
                    if (tt.status == 3) {
                        return "/POS/icons/check-mark (4).png";
                    }

                case 4:
                    return "  Remove";
                case 5:
                    return " Edit";
                case 6:
                    return " Delete";
                case 7:
                    return tt.date_assigned;
                case 8:
                    return tt.date_assigned;
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

    private void select_slip_no2() {
        int row = tbl_warranties2.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_warranties2.getSelectedColumn();
        if (col == 4) {
            tbl_warranties_ALM2.remove(row);
            tbl_warranty_items_ALM.clear();
            jLabel6.setText("0");
        } else {
            ret_items();
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" items ">
    public static ArrayListModel tbl_warranty_items_ALM;
    public static Tblwarranty_itemsModel tbl_warranty_items_M;

    public static void init_tbl_warranty_items(JTable tbl_warranty_items) {
        tbl_warranty_items_ALM = new ArrayListModel();
        tbl_warranty_items_M = new Tblwarranty_itemsModel(tbl_warranty_items_ALM);
        tbl_warranty_items.setModel(tbl_warranty_items_M);
        tbl_warranty_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranty_items.setRowHeight(25);
        int[] tbl_widths_warranty_items = {0, 40, 120, 100, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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

    public static void loadData_warranty_items(List<S1_my_services_item_replacements_customers.to_my_services_item_replacements_customers> acc) {
        tbl_warranty_items_ALM.clear();
        tbl_warranty_items_ALM.addAll(acc);
    }

    public static class Tblwarranty_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Qty", "Item Code", "Description", "Price", "Amount", "Status", "", "", "cost", "selling_price", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "warranty_date", "serial_no", "main_barcode", "brand", "brand_id", "model", "model_id", "status", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
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
            S1_my_services_item_replacements_customers.to_my_services_item_replacements_customers tt = (S1_my_services_item_replacements_customers.to_my_services_item_replacements_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.qty;
                case 2:
                    return " " + tt.item_code;
                case 3:
                    return " " + tt.description;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.selling_price);
                case 5:
                    return "    " + FitIn.fmt_wc_0(tt.selling_price * tt.qty);
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
                    return tt.selling_price;
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
                    return tt.classification_id;
                case 16:
                    return tt.classification_id;
                case 17:
                    return tt.conversion;
                case 18:
                    return tt.unit;
                case 19:
                    return tt.classification_id;
                case 20:
                    return tt.serial_no;
                case 21:
                    return tt.classification_id;
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
                    return tt.classification_id;
                case 28:
                    return tt.classification_id;
                case 29:
                    return tt.branch;
                case 30:
                    return tt.classification_id;
                case 31:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_items() {
        int row = tbl_warranties2.getSelectedRow();
        if (row < 0) {
            return;
        }
        My_services.to_my_services to = (My_services.to_my_services) tbl_warranties_ALM2.get(row);
        String where = " where transaction_no='" + to.transaction_no + "' ";

        List<S1_my_services_item_replacements_customers.to_my_services_item_replacements_customers> items = S1_my_services_item_replacements_customers.ret_data(where);

        loadData_warranty_items(items);
        jLabel2.setText("" + items.size());
    }

    //</editor-fold>
    private void confirm_action() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                ok2();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ok2() {

        List< My_services.to_my_services> datas = tbl_warranties_ALM2;
        List<Warranties.to_warranties> asus = tbl_ASUS_ALM2;
//        if (datas.isEmpty()&& asus.isEmpty()) {
//            Alert.set(0, "No transaction added!");
//            return;
//        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(datas, asus));
        }
    }

    List<My_services_departments.to_my_services_departments> department_list = new ArrayList();

    private void init_departments() {

        Object[][] obj = new Object[department_list.size()][1];
        int i = 0;
        for (My_services_departments.to_my_services_departments to : department_list) {
            obj[i][0] = " " + to.department;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_department1.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_department1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                My_services_departments.to_my_services_departments to = department_list.get(data.selected_row);
                Field.Combo dep = (Field.Combo) tf_department1;
                dep.setId("" + to.id);
                dep.setText(to.department);
            }
        });
    }

//    ASUS
    //<editor-fold defaultstate="collapsed" desc=" warranties "> 
    public static ArrayListModel tbl_ASUS_ALM;
    public static TblAsusModel tbl_ASUS_M;

    public static void init_tbl_asus(JTable tbl_asus) {
        tbl_ASUS_ALM = new ArrayListModel();
        tbl_ASUS_M = new TblAsusModel(tbl_ASUS_ALM);
        tbl_asus.setModel(tbl_ASUS_M);
        tbl_asus.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_asus.setRowHeight(25);
        int[] tbl_widths_warranties = {100, 140, 80, 40, 40, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranties.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_asus, i, tbl_widths_warranties[i]);
        }
        Dimension d = tbl_asus.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_asus.getTableHeader().setPreferredSize(d);
        tbl_asus.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_asus.setRowHeight(25);
        tbl_asus.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_asus.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_asus(List<Warranties.to_warranties> acc) {
        tbl_ASUS_ALM.clear();
        tbl_ASUS_ALM.addAll(acc);
    }

    public static class TblAsusModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Slip No", "Created", "", "", "Status", "", "created_at", "created_by", "branch", "branch_id", "location", "location_id"

        };

        public TblAsusModel(ListModel listmodel) {
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
            Warranties.to_warranties tt = (Warranties.to_warranties) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.slip_no;
                case 2:
                    return " " + DateType.convert_slash_datetime2(tt.created_at);
                case 3:
                    if (tt.status == 0) {
                        try {
                            Date d = DateType.sf.parse(tt.created_at);
                            int days = DateUtils1.count_days(d, new Date());
                            if (days > 10) {
                                return "/POS/icons/check-mark (3).png";
                            } else {
                                return "/POS/icons/check-mark (2).png";
                            }
                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }
                    }
                    if (tt.status == 1) {
                        return "/POS/icons/check-mark (1).png";
                    }
                    if (tt.status == 2) {
                        return "/POS/icons/check-mark.png";
                    }
                    if (tt.status == 3) {
                        return "/POS/icons/check-mark (4).png";
                    }
                case 4:
                    return "  Add";
                case 5:
                    return " Edit";
                case 6:
                    return " Delete";
                case 7:
                    return tt.created_at;
                case 8:
                    return tt.created_at;
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

    private void ret_asus() {
        String search = jTextField2.getText();
        String where = " where slip_no like '%" + search + "%' and status=0  order by slip_no asc";
        List<Warranties.to_warranties> datas = Warranties.ret_data(where);
        loadData_asus(datas);
        jLabel2.setText("" + datas.size());
    }

    //Added Transactions
    public static ArrayListModel tbl_ASUS_ALM2;
    public static TblAsusModel2 tbl_ASUS_M2;

    public static void init_tbl_asus2(JTable tbl_asus) {
        tbl_ASUS_ALM2 = new ArrayListModel();
        tbl_ASUS_M2 = new TblAsusModel2(tbl_ASUS_ALM2);
        tbl_asus.setModel(tbl_ASUS_M2);
        tbl_asus.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_asus.setRowHeight(25);
        int[] tbl_widths_warranties = {100, 140, 80, 40, 60, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranties.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_asus, i, tbl_widths_warranties[i]);
        }
        Dimension d = tbl_asus.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_asus.getTableHeader().setPreferredSize(d);
        tbl_asus.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_asus.setRowHeight(25);
        tbl_asus.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_asus.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer1());
    }

    public static void loadData_asus2(List<Warranties.to_warranties> acc) {
        tbl_ASUS_ALM2.clear();
        tbl_ASUS_ALM2.addAll(acc);
    }

    public static class TblAsusModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Slip No", "Created", "", "", "Status", "", "created_at", "created_by", "branch", "branch_id", "location", "location_id"

        };

        public TblAsusModel2(ListModel listmodel) {
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
            Warranties.to_warranties tt = (Warranties.to_warranties) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + tt.slip_no;
                case 2:
                    return " " + DateType.convert_slash_datetime2(tt.created_at);
                case 3:
                    if (tt.status == 0) {
                        try {
                            Date d = DateType.sf.parse(tt.created_at);
                            int days = DateUtils1.count_days(d, new Date());
                            if (days > 10) {
                                return "/POS/icons/check-mark (3).png";
                            } else {
                                return "/POS/icons/check-mark (2).png";
                            }
                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }
                    }
                    if (tt.status == 1) {
                        return "/POS/icons/check-mark (1).png";
                    }
                    if (tt.status == 2) {
                        return "/POS/icons/check-mark.png";
                    }
                    if (tt.status == 3) {
                        return "/POS/icons/check-mark (4).png";
                    }
                case 4:
                    return "  Remove";
                case 5:
                    return " Edit";
                case 6:
                    return " Delete";
                case 7:
                    return tt.created_at;
                case 8:
                    return tt.created_at;
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

    private void select_asus() {
        int row = tbl_asus.getSelectedRow();
        if (row < 0) {
            return;
        }
        Warranties.to_warranties to = (Warranties.to_warranties) tbl_ASUS_ALM.get(row);

        int col = tbl_asus.getSelectedColumn();
        if (col == 4) {
            List<  Warranties.to_warranties> added = tbl_ASUS_ALM2;
            int exist = 0;
            for (Warranties.to_warranties warranty : added) {
                if (warranty.transaction_no.equalsIgnoreCase(to.transaction_no)) {
                    exist = 1;
                    break;
                }
            }
            if (exist == 0) {
                tbl_ASUS_ALM2.add(to);
            } else {
                Alert.set(0, "Already added!");
            }
        }
    }

    public static ArrayListModel tbl_asus_items_ALM;
    public static Tblasus_itemsModel tbl_asus_items_M;

    public static void init_tbl_asus_items(JTable tbl_asus_items) {
        tbl_asus_items_ALM = new ArrayListModel();
        tbl_asus_items_M = new Tblasus_itemsModel(tbl_asus_items_ALM);
        tbl_asus_items.setModel(tbl_asus_items_M);
        tbl_asus_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_asus_items.setRowHeight(25);
        int[] tbl_widths_warranty_items = {0, 40, 120, 100, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_warranty_items.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_asus_items, i, tbl_widths_warranty_items[i]);
        }
        Dimension d = tbl_asus_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_asus_items.getTableHeader().setPreferredSize(d);
        tbl_asus_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_asus_items.setRowHeight(25);
        tbl_asus_items.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_asus_items(List<Warranty_items.to_warranty_items> acc) {
        tbl_asus_items_ALM.clear();
        tbl_asus_items_ALM.addAll(acc);
    }

    public static class Tblasus_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Qty", "Item Code", "Description", "Price", "Amount", "Status", "", "", "cost", "selling_price", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "warranty_date", "serial_no", "main_barcode", "brand", "brand_id", "model", "model_id", "status", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
        };

        public Tblasus_itemsModel(ListModel listmodel) {
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
            Warranty_items.to_warranty_items tt = (Warranty_items.to_warranty_items) getRow(row);
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
                    return " " + FitIn.fmt_wc_0(tt.selling_price);
                case 5:
                    return "    " + FitIn.fmt_wc_0(tt.selling_price * tt.qty);
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
                    return tt.selling_price;
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
                    return tt.classification_id;
                case 16:
                    return tt.classification_id;
                case 17:
                    return tt.conversion;
                case 18:
                    return tt.unit;
                case 19:
                    return tt.classification_id;
                case 20:
                    return tt.serial_no;
                case 21:
                    return tt.classification_id;
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
                    return tt.classification_id;
                case 28:
                    return tt.classification_id;
                case 29:
                    return tt.branch;
                case 30:
                    return tt.classification_id;
                case 31:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void select_slip_no3() {
        int row = tbl_asus2.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_asus2.getSelectedColumn();
        if (col == 4) {
            tbl_ASUS_ALM2.remove(row);
            tbl_asus_items_ALM.clear();
            jLabel12.setText("0");
        } else {
            ret_asus_items();
        }

    }

    private void ret_asus_items() {
        int row = tbl_asus2.getSelectedRow();
        if (row < 0) {
            return;
        }
        Warranties.to_warranties to = (Warranties.to_warranties) tbl_ASUS_ALM2.get(row);
        String where = " where transaction_no='" + to.transaction_no + "' ";

        List<Warranty_items.to_warranty_items> items = Warranty_items.ret_data(where);

        loadData_asus_items(items);
        jLabel2.setText("" + items.size());
    }

}
