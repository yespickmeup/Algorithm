/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.requisition_slips;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Inventory_barcodes;
import POS.requisition_slips.Requisition_slip_items.to_requisition_slip_items;
import POS.requisition_slips.Requisition_slips.to_requisition_slips;
import POS.util.Alert;
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
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Dlg_requisition_slip extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_requisition_slip
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
    private Dlg_requisition_slip(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_requisition_slip(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_requisition_slip() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_requisition_slip myRef;

    private void setThisRef(Dlg_requisition_slip myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_requisition_slip> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_requisition_slip create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_requisition_slip create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_requisition_slip dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_requisition_slip((java.awt.Frame) parent, false);
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
            Dlg_requisition_slip dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_requisition_slip((java.awt.Dialog) parent, false);
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

        Dlg_requisition_slip dialog = Dlg_requisition_slip.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_requisition_slip_items = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        jTextField4 = new Field.Input();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jButton1 = new Button.Primary();
        jButton3 = new Button.Info();
        jButton6 = new Button.Success();
        tf_search = new Field.Input();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton5 =  new Button.Default();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_requisition_slips = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Transaction No:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbl_requisition_slip_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_requisition_slip_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_requisition_slip_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_requisition_slip_items);

        jLabel2.setText("No. of rows:");

        jLabel3.setText("0");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel4.setText("Status:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Request Type:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setText("Supply");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Department:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Requested by:");

        jButton2.setText("New Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Post");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Update Post");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Finalize");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(jTextField2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(jTextField4))
                        .addGap(68, 68, 68)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(16, 16, 16)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_search)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Requisition Slip", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Date From:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Search:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("To:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Status:");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Posted");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Finalized");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tbl_requisition_slips.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_requisition_slips.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_requisition_slipsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_requisition_slipsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_requisition_slipsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_requisition_slipsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_requisition_slips);

        jLabel11.setText("No. of rows:");

        jLabel12.setText("0");

        jLabel23.setText("Gross Total:");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(317, 317, 317)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(2, 2, 2)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox3)
                                .addComponent(jCheckBox4)))))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)
                        .addComponent(jLabel24)))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Reports", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
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
                .addGap(5, 5, 5))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        init_no();
        tbl_requisition_slip_items_ALM.clear();
        tbl_requisition_slip_items_M.fireTableDataChanged();
        jLabel3.setText("0");
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        post();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update_post();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        finalize_slip();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        data_cols_slips();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_requisition_slipsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_requisition_slipsMouseClicked
        select_requisition_slip();
    }//GEN-LAST:event_tbl_requisition_slipsMouseClicked

    private void tbl_requisition_slipsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_requisition_slipsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_requisition_slipsMouseEntered

    private void tbl_requisition_slipsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_requisition_slipsMousePressed

    }//GEN-LAST:event_tbl_requisition_slipsMousePressed

    private void tbl_requisition_slipsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_requisition_slipsMouseReleased

    }//GEN-LAST:event_tbl_requisition_slipsMouseReleased

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased

    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_requisition_slip_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_requisition_slip_itemsMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_requisition_slip_itemsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tbl_requisition_slip_items;
    private javax.swing.JTable tbl_requisition_slips;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_branch();
        init_no();
        init_tbl_requisition_slips(tbl_requisition_slips);
        init_tbl_requisition_slip_items(tbl_requisition_slip_items);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tf_search.grabFocus();
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

    private void init_no() {
        String slip_no = Requisition_slips.increment_id(location_ids);
        jTextField1.setText(slip_no);
    }
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    String location_ids = "";
    List<S1_branch_locations.to_branch_locations> branch_locations = new ArrayList();

    private void set_default_branch() {
        branch_locations = S1_branch_locations.ret_where("");
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        location_ids = "" + to.id;

        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;
    }

    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        tf_search.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();
                String where = " where "
                        + " main_barcode like '" + search + "' and location_id='" + location_ids + "' "
                        + " or barcode like '" + search + "' and location_id='" + location_ids + "' "
                        + " or description like '%" + search + "%' and location_id='" + location_ids + "' ";
                where = where + " order by description asc ";
                tf_search.setEnabled(true);
                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);

                if (inventory_barcoders_list.size() >= 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        obj[i][3] = " " + to.unit;
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

                        }
                    });
                }
            }
        });
        t.start();
    }

    int selected_row = -1;

    //<editor-fold defaultstate="collapsed" desc=" requisition_slips "> 
    public static ArrayListModel tbl_requisition_slips_ALM;
    public static Tblrequisition_slipsModel tbl_requisition_slips_M;

    public static void init_tbl_requisition_slips(JTable tbl_requisition_slips) {
        tbl_requisition_slips_ALM = new ArrayListModel();
        tbl_requisition_slips_M = new Tblrequisition_slipsModel(tbl_requisition_slips_ALM);
        tbl_requisition_slips.setModel(tbl_requisition_slips_M);
        tbl_requisition_slips.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_requisition_slips.setRowHeight(25);
        int[] tbl_widths_requisition_slips = {100, 100, 100, 100, 70, 50, 50, 50, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_requisition_slips.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_requisition_slips, i, tbl_widths_requisition_slips[i]);
        }
        Dimension d = tbl_requisition_slips.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_requisition_slips.getTableHeader().setPreferredSize(d);
        tbl_requisition_slips.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_requisition_slips.setRowHeight(25);
        tbl_requisition_slips.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_requisition_slips(List<to_requisition_slips> acc) {
        tbl_requisition_slips_ALM.clear();
        tbl_requisition_slips_ALM.addAll(acc);
    }

    public static class Tblrequisition_slipsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "Requested by", "Department", "", "", "", "", "branch_id", "location", "location_id", "date_added", "status"
        };

        public Tblrequisition_slipsModel(ListModel listmodel) {
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
            to_requisition_slips tt = (to_requisition_slips) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.requisition_slip_no;
                case 1:
                    return " " + DateType.convert_slash_datetime2(tt.requisition_date);
                case 2:
                    return " " + tt.requested_by;
                case 3:
                    return " " + tt.requisition_department;
                case 4:
                    if (tt.status == 0) {
                        return " Posted";
                    } else {
                        return " Finalized";
                    }
                case 5:
                    return " Update";
                case 6:
                    return " Delete";
                case 7:
                    return " Print";
                case 8:
                    return tt.branch_id;
                case 9:
                    return tt.location;
                case 10:
                    return tt.location_id;
                case 11:
                    return tt.date_added;
                default:
                    return tt.status;
            }
        }
    }

//</editor-fold> 
    private void data_cols_slips() {
        String where = " where requisition_type like '%" + "" + "%' ";
        String from = DateType.sf.format(jDateChooser2.getDate());
        String to = DateType.sf.format(jDateChooser3.getDate());
        if (!jCheckBox1.isSelected()) {
            where = where + " and requisition_date between '" + from + "' and '" + to + "' ";
        }
        if (jCheckBox3.isSelected()) {
            where = where + " and status='" + "0" + "' ";
        }
        if (jCheckBox4.isSelected()) {
            where = where + " and status='" + "1" + "' ";
        }

        where = where + " and requisition_department like '%" + jTextField5.getText() + "%' order by id desc ";
        System.out.println(where);
        List<Requisition_slips.to_requisition_slips> datas = Requisition_slips.ret_data(where);
        loadData_requisition_slips(datas);
        jLabel3.setText("" + datas.size());
    }

    //<editor-fold defaultstate="collapsed" desc=" requisition_slip_items "> 
    public static ArrayListModel tbl_requisition_slip_items_ALM;
    public static Tblrequisition_slip_itemsModel tbl_requisition_slip_items_M;

    public static void init_tbl_requisition_slip_items(JTable tbl_requisition_slip_items) {
        tbl_requisition_slip_items_ALM = new ArrayListModel();
        tbl_requisition_slip_items_M = new Tblrequisition_slip_itemsModel(tbl_requisition_slip_items_ALM);
        tbl_requisition_slip_items.setModel(tbl_requisition_slip_items_M);
        tbl_requisition_slip_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_requisition_slip_items.setRowHeight(25);
        int[] tbl_widths_requisition_slip_items = {70, 70, 100, 100, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_requisition_slip_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_requisition_slip_items, i, tbl_widths_requisition_slip_items[i]);
        }
        Dimension d = tbl_requisition_slip_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_requisition_slip_items.getTableHeader().setPreferredSize(d);
        tbl_requisition_slip_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_requisition_slip_items.setRowHeight(25);
        tbl_requisition_slip_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_requisition_slip_items, 3);
    }

    public static void loadData_requisition_slip_items(List<to_requisition_slip_items> acc) {
        tbl_requisition_slip_items_ALM.clear();
        tbl_requisition_slip_items_ALM.addAll(acc);
    }

    public static class Tblrequisition_slip_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Cost", "", "", "requested_by", "item_code", "barcode", "description", "unit", "cost", "selling_price", "branch", "branch_id", "location", "location_id", "date_added", "status"
        };

        public Tblrequisition_slip_itemsModel(ListModel listmodel) {
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
            to_requisition_slip_items tt = (to_requisition_slip_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.item_code;
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 4:
                    return " Update";
                case 5:
                    return " Delete";
                case 6:
                    return tt.requested_by;
                case 7:
                    return tt.item_code;
                case 8:
                    return tt.barcode;
                case 9:
                    return tt.description;
                case 10:
                    return tt.unit;
                case 11:
                    return tt.cost;
                case 12:
                    return tt.selling_price;
                case 13:
                    return tt.branch;
                case 14:
                    return tt.branch_id;
                case 15:
                    return tt.location;
                case 16:
                    return tt.location_id;
                case 17:
                    return tt.date_added;
                default:
                    return tt.status;
            }
        }
    }
//</editor-fold> 

    private void data_cols_items() {
        int row = tbl_requisition_slips.getSelectedRow();
        if (row < 0) {
            return;
        }

        to_requisition_slips to = (to_requisition_slips) tbl_requisition_slips_ALM.get(row);
        String where = " where requisition_slip_no='" + to.requisition_slip_no + "' ";
        List<to_requisition_slip_items> datas = Requisition_slip_items.ret_data(where);
        loadData_requisition_slip_items(datas);

    }

    private void add_items() {

        final Inventory_barcodes.to_inventory_barcodes to = inventory_barcoders_list.get(selected_row);
        Window p = (Window) this;
        Dlg_rs_qty nd = Dlg_rs_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(to);
        nd.setCallback(new Dlg_rs_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_rs_qty.OutputData data) {
                closeDialog.ok();
                Field.Combo dep = (Field.Combo) jTextField3;
                int id = 0;
                String requisition_slip_no = jTextField1.getText();
                String requisition_date = DateType.sf.format(jDateChooser1.getDate());
                String requisition_type = jTextField2.getText();
                String requisition_department = dep.getText();
                String requisition_department_id = dep.getId();
                String requested_by = jTextField4.getText();
                String item_code = to.main_barcode;
                String barcode = to.barcode;
                String description = to.description;
                double product_qty = data.qty;
                String unit = to.unit;
                double cost = data.cost;
                double selling_price = to.selling_price;
                String branch = to.branch;
                String branch_id = to.branch_code;
                String location = to.location;
                String location_id = to.location_id;
                String date_added = DateType.now();
                int status = 0;

                to_requisition_slip_items slip = new to_requisition_slip_items(id, requisition_slip_no, requisition_date, requisition_type, requisition_department, requisition_department_id, requested_by, item_code, barcode, description, product_qty, unit, cost, selling_price, branch, branch_id, location, location_id, date_added, status);
                tbl_requisition_slip_items_ALM.add(slip);
                tbl_requisition_slip_items_M.fireTableDataChanged();

                jLabel3.setText("" + tbl_requisition_slip_items_ALM.size());
                tf_search.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void select_item() {
        final int row = tbl_requisition_slip_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_requisition_slip_items slip = (to_requisition_slip_items) tbl_requisition_slip_items_ALM.get(row);
        int col = tbl_requisition_slip_items.getSelectedColumn();
        if (col == 4) {
            if (slip.status == 1) {
                Alert.set(0, "Transaction finalized, cannot proceed!");
                return;
            }
            Window p = (Window) this;
            Dlg_rs_qty nd = Dlg_rs_qty.create(p, true);
            nd.setTitle("");
            nd.do_pass2(slip);
            nd.setCallback(new Dlg_rs_qty.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_rs_qty.OutputData data) {
                    closeDialog.ok();
                    if (slip.id == 0) {
                        slip.setProduct_qty(data.qty);
                    } else {

                    }
                    tbl_requisition_slip_items_M.fireTableDataChanged();
                    jLabel3.setText("" + tbl_requisition_slip_items_ALM.size());
                    tf_search.grabFocus();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 5) {
            if (slip.status == 1) {
                Alert.set(0, "Transaction finalized, cannot proceed!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    if (slip.id == 0) {
                        tbl_requisition_slip_items_ALM.remove(row);
                        tbl_requisition_slip_items_M.fireTableDataChanged();
                    } else {
                        Requisition_slip_items.delete_data(slip);
                        Alert.set(3, "");
                        data_cols_items();
                    }
                    jLabel3.setText("" + tbl_requisition_slip_items_ALM.size());
                    tf_search.grabFocus();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }

    private void post() {
        Field.Combo dep = (Field.Combo) jTextField3;
        int id = 0;
        String requisition_slip_no = Requisition_slips.increment_id(location_ids);
        String requisition_date = DateType.sf.format(jDateChooser1.getDate());
        String requisition_type = jTextField2.getText();
        String requisition_department = dep.getText();
        String requisition_department_id = dep.getId();
        String requested_by = jTextField4.getText();
        String branch = my_branch;
        String branch_id = my_branch_id;
        String location = my_location;
        String location_id = my_location_id;
        String date_added = DateType.now();
        int status = 0;

        Requisition_slips.to_requisition_slips slip = new Requisition_slips.to_requisition_slips(id, requisition_slip_no, requisition_date, requisition_type, requisition_department, requisition_department_id, requested_by, branch, branch_id, location, location_id, date_added, status);
        if (tbl_requisition_slip_items_ALM.size() <= 0) {
            Alert.set(0, "No Item/s Added!");
            return;
        }
        List<to_requisition_slip_items> datas = tbl_requisition_slip_items_ALM;
        Requisition_slips.add_data(slip, datas);
        Alert.set(1, branch);

        init_no();
        tbl_requisition_slip_items_ALM.clear();
        tbl_requisition_slip_items_M.fireTableDataChanged();
        jLabel3.setText("" + tbl_requisition_slip_items_ALM.size());
        tf_search.grabFocus();
        data_cols_slips();
    }

    private void finalize_slip() {
        int row = tbl_requisition_slips.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_requisition_slips.getSelectedColumn();
        final to_requisition_slips to = (to_requisition_slips) tbl_requisition_slips_ALM.get(row);
        
        if (to.status == 1) {
            Alert.set(0, "Transaction finalized, cannot proceed!");
            return;
        }
        String where = " where requisition_slip_no='" + to.requisition_slip_no + "' ";
        final List<to_requisition_slip_items> datas = Requisition_slip_items.ret_data(where);
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                
                Requisition_slips.finalize_data(to, datas);
                Alert.set(0, "Transaction Finalized!");
                data_cols_slips();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void update_post() {
        int row = tbl_requisition_slips.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_requisition_slips.getSelectedColumn();
        final to_requisition_slips to = (to_requisition_slips) tbl_requisition_slips_ALM.get(row);

        Field.Combo dep = (Field.Combo) jTextField3;
        int id = to.id;
        String requisition_slip_no = to.requisition_slip_no;
        String requisition_date = DateType.sf.format(jDateChooser1.getDate());
        String requisition_type = jTextField2.getText();
        String requisition_department = dep.getText();
        String requisition_department_id = dep.getId();
        String requested_by = jTextField4.getText();
        String branch = to.branch;
        String branch_id = to.branch_id;
        String location = to.location;
        String location_id = to.location_id;
        String date_added = DateType.now();
        int status = to.status;

        Requisition_slips.to_requisition_slips slip = new Requisition_slips.to_requisition_slips(id, requisition_slip_no, requisition_date, requisition_type, requisition_department, requisition_department_id, requested_by, branch, branch_id, location, location_id, date_added, status);
        if (tbl_requisition_slip_items_ALM.size() <= 0) {
            Alert.set(0, "No Item/s Added!");
            return;
        }
        List<to_requisition_slip_items> datas = tbl_requisition_slip_items_ALM;
        Requisition_slips.update_data(slip);
        Alert.set(1, branch);

        init_no();
        tbl_requisition_slip_items_ALM.clear();
        tbl_requisition_slip_items_M.fireTableDataChanged();
        jLabel3.setText("" + tbl_requisition_slip_items_ALM.size());
        tf_search.grabFocus();
        data_cols_slips();
    }

    private void select_requisition_slip() {

        int row = tbl_requisition_slips.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_requisition_slips.getSelectedColumn();
        final to_requisition_slips to = (to_requisition_slips) tbl_requisition_slips_ALM.get(row);
        String where = " where requisition_slip_no='" + to.requisition_slip_no + "' ";
        final List<to_requisition_slip_items> datas = Requisition_slip_items.ret_data(where);
        if (col == 4) {
            if (to.status == 1) {
                Alert.set(0, "Transaction finalized, cannot proceed!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Requisition_slips.finalize_data(to, datas);
                    Alert.set(0, "Transaction Finalized!");
                    data_cols_slips();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 5) {
            Field.Combo dep = (Field.Combo) jTextField3;
            jTextField1.setText(to.requisition_slip_no);
            jTextField2.setText(to.requisition_type);
            jTextField4.setText(to.requested_by);
            dep.setText(to.requisition_department);
            dep.setId(to.requisition_department_id);
            if (to.status == 1) {
                jButton6.setEnabled(false);
                jButton3.setEnabled(false);
            } else {
                jButton1.setEnabled(false);
                jButton6.setEnabled(true);
                jButton3.setEnabled(true);
            }

            try {
                jDateChooser1.setDate(DateType.sf.parse(to.requisition_date));
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_requisition_slip.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadData_requisition_slip_items(datas);
            jTabbedPane1.setSelectedIndex(0);

        }
        if (col == 6) {
            if (to.status == 1) {
                Alert.set(0, "Transaction finalized, cannot proceed!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Requisition_slips.delete_data(to);
                    Alert.set(3, "");
                    data_cols_slips();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 7) {
            //print
        }
    }
}
