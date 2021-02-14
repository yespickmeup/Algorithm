/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rma;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.category.S1_inventory_brand;
import POS.category.S1_inventory_category;
import POS.category.S1_inventory_classification;
import POS.category.S1_inventory_model;
import POS.category.S1_inventory_sub_classification;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.my_sales.MySales_Items;
import POS.receipts.S1_receipt_items;
import POS.receipts.Receipts;
import POS.receipts.Receipts.to_receipts;
import static POS.requisition_slips.Dlg_requisition_slip.tbl_requisition_slips_ALM;
import POS.requisition_slips.Requisition_slip_items;
import POS.requisition_slips.Requisition_slips;
import POS.requisition_slips.Srpt_requisition_slip;
import POS.users.MyUser;
import POS.users.User_previlege_others;
import POS.util.Alert;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Dlg_rma extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_rma
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
    private Dlg_rma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_rma(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_rma() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_rma myRef;

    private void setThisRef(Dlg_rma myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_rma> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_rma create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_rma create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_rma dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rma((java.awt.Frame) parent, false);
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
            Dlg_rma dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rma((java.awt.Dialog) parent, false);
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

        Dlg_rma dialog = Dlg_rma.create(new javax.swing.JFrame(), true);
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
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        tf_category = new Field.Combo();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        tf_category_code = new javax.swing.JTextField();
        jTextField8 = new Field.Combo();
        jTextField4 = new Field.Combo();
        jTextField9 = new Field.Combo();
        jTextField10 = new Field.Combo();
        jTextField5 = new Field.Combo();
        jTextField6 = new Field.Combo();
        jTextField11 = new Field.Combo();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_search = new Field.Search();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        jButton1 = new Button.Primary();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jTextField2 = new Field.Search();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Date Received:");

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("All");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("To:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Category:");

        tf_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category.setText("ALL");
        tf_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_categoryMouseClicked(evt);
            }
        });
        tf_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_categoryActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Classification:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setText("ALL");
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

        tf_category_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category_code.setText("0");
        tf_category_code.setFocusable(false);

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setText("0");
        jTextField8.setFocusable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setText("ALL");
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

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setText("0");
        jTextField9.setFocusable(false);

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setText("0");
        jTextField10.setFocusable(false);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setText("ALL");
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

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setText("ALL");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setText("0");
        jTextField11.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Brand:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Sub-Classification:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Model:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Transactions:");

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("Sales");

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("Transfers");

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("Receipts");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Search Item:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        buttonGroup2.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("[F4]-Description");
        jCheckBox13.setFocusable(false);

        buttonGroup2.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("[F3]-Barcode");
        jCheckBox12.setFocusable(false);

        buttonGroup2.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("[F2]-Item Code");
        jCheckBox11.setFocusable(false);

        buttonGroup2.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("[F1]-All");
        jCheckBox10.setFocusable(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Filter:");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel16.setText("Status:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_category)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_category_code, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3))
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField5)
                                        .addGap(0, 0, 0)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField11)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                    .addComponent(jTextField8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox6))
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_category)
                        .addComponent(tf_category_code, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox12)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Get Serials", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Date Received:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("All");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("To:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search by:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Transaction No");
        jCheckBox1.setFocusable(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Serial No");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Item Code");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Item Code:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

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
        });
        jScrollPane1.setViewportView(tbl_receipts);

        jLabel1.setText("Total No. of Transactions:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox4))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Retrieve Details", jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_receiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseClicked
        details();
    }//GEN-LAST:event_tbl_receiptsMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jTextField2.setVisible(false);
        jLabel6.setVisible(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        jTextField2.setVisible(false);
        jLabel6.setVisible(false);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        jTextField2.setVisible(true);
        jLabel6.setVisible(true);
        jTextField2.grabFocus();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void tf_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_categoryMouseClicked
        init_categories();
    }//GEN-LAST:event_tf_categoryMouseClicked

    private void tf_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoryActionPerformed
        init_categories();
    }//GEN-LAST:event_tf_categoryActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_receipt_types();
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_receipt_types();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        init_sub_classification();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_sub_classification();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_brand();
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_brand();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        init_model();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        init_model();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        set_report();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable tbl_receipts;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_category_code;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("pool_password", "password");
        init_key();
        init_tbl_receipts(tbl_receipts);

        jLabel6.setVisible(false);
        jTextField2.setVisible(false);

        tf_category_code.setVisible(false);
        jTextField8.setVisible(false);
        jTextField9.setVisible(false);
        jTextField10.setVisible(false);
        jTextField11.setVisible(false);
        set_default_branch();

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

    //<editor-fold defaultstate="collapsed" desc=" receipts "> 
    public static ArrayListModel tbl_receipts_ALM;
    public static TblreceiptsModel tbl_receipts_M;

    public static void init_tbl_receipts(JTable tbl_receipts) {
        tbl_receipts_ALM = new ArrayListModel();
        tbl_receipts_M = new TblreceiptsModel(tbl_receipts_ALM);
        tbl_receipts.setModel(tbl_receipts_M);
        tbl_receipts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipts.setRowHeight(25);
        int[] tbl_widths_receipts = {100, 80, 100, 80, 80, 80, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipts, i, tbl_widths_receipts[i]);
        }
        Dimension d = tbl_receipts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_receipts.getTableHeader().setPreferredSize(d);
        tbl_receipts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_receipts.setRowHeight(25);
        tbl_receipts.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 5);
    }

    public static void loadData_receipts(List<to_receipts> acc) {
        tbl_receipts_ALM.clear();
        tbl_receipts_ALM.addAll(acc);
    }

    public static class TblreceiptsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction No", "Created", "Supplier", "Received", "Received", "Amount", "", "remarks", "date_delivered", "date_received", "receipt_type", "reference_no", "branch", "branch_id", "gross_total", "net_total", "batch_no", "discount", "status", "receipt_type_id"
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
            to_receipts tt = (to_receipts) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.receipt_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.supplier;
                case 3:
                    return " " + DateType.convert_slash_datetime2(tt.date_received);
                case 4:
                    return " " + DateType.convert_slash_datetime2(tt.date_delivered);
                case 5:
                    return " " + FitIn.fmt_wc_0(tt.gross_total) + " ";
                case 6:
                    return " View";
                case 7:
                    return tt.remarks;
                case 8:
                    return tt.date_delivered;
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
                case 18:
                    return tt.status;
                default:
                    return tt.receipt_type_id;
            }
        }
    }

    private void data_cols() {
        String where = " where supplier like '%" + "" + "%' ";
        String from = DateType.sf.format(jDateChooser1.getDate());
        String to = DateType.sf.format(jDateChooser2.getDate());

        if (!jCheckBox4.isSelected()) {
            where = where + " and Date(date_delivered) between '" + from + "' and '" + to + "' ";
        }
        if (jCheckBox1.isSelected()) {
            where = where + " and receipt_no like '%" + jTextField1.getText() + "%' ";
        }
        String receipt_no = "n/a";
        String item_code = "n/a";
        String serial_no = "n/a";
        if (jCheckBox3.isSelected()) {
            String where2 = " where serial_no like '%" + jTextField1.getText() + "%' ";
            serial_no = jTextField1.getText();
            List<S1_receipt_items.to_receipt_items> datas = S1_receipt_items.ret_data5(where2);
            for (S1_receipt_items.to_receipt_items to1 : datas) {
                receipt_no = to1.receipt_no;
                item_code = to1.main_barcode;
                break;
            }

            if (receipt_no.equalsIgnoreCase("n/a")) {
                where = where + " and receipt_no like '%" + "n/a" + "%' ";

            } else {
                where = where + " and receipt_no = '" + receipt_no + "' ";
            }
        }
        List<Receipts.to_receipts> datas = new ArrayList();
        if (jCheckBox5.isSelected()) {
            where = " where main_barcode like '" + jTextField2.getText() + "'";
            datas = Receipts.ret_data5(where);
            System.out.println("size: " + datas.size());
        } else {
            datas = Receipts.ret_data3(where);
        }

        loadData_receipts(datas);
        jLabel2.setText("" + datas.size());
        if (datas.size() == 1 && !item_code.equals("n/a")) {
            to_receipts to2 = (to_receipts) tbl_receipts_ALM.get(0);
            int col = tbl_receipts.getSelectedColumn();
            Window p = (Window) this;
            Dlg_rma_details nd = Dlg_rma_details.create(p, true);
            nd.setTitle("");
            nd.do_pass2(to2, item_code, serial_no);
            nd.setCallback(new Dlg_rma_details.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_rma_details.OutputData data) {
                    closeDialog.ok();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
//</editor-fold> 

    private void details() {

        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }

        to_receipts to = (to_receipts) tbl_receipts_ALM.get(row);
        int col = tbl_receipts.getSelectedColumn();
        if (col == 6) {
            Window p = (Window) this;
            Dlg_rma_details nd = Dlg_rma_details.create(p, true);
            nd.setTitle("");
            nd.do_pass(to);
            nd.setCallback(new Dlg_rma_details.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_rma_details.OutputData data) {
                    closeDialog.ok();

                    System.out.println("" + data.stmt);

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }
    }

    List<S1_inventory_category.to_inventory_category> categories = new ArrayList();

    private void init_categories() {

        String where = " where name like '%" + tf_category.getText() + "%' order by name asc";
        if (tf_category.getText().equalsIgnoreCase("All")) {
            where = " order by name asc";
        }
        categories.clear();
        S1_inventory_category.to_inventory_category c1 = new S1_inventory_category.to_inventory_category(0, "All", "");
        List<S1_inventory_category.to_inventory_category> c2 = S1_inventory_category.ret_data2(where);
        categories.add(c1);
        categories.addAll(c2);
        Object[][] obj = new Object[categories.size()][1];
        int i = 0;
        for (S1_inventory_category.to_inventory_category to : categories) {
            obj[i][0] = " " + to.name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category.getWidth()};
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_category, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_category.to_inventory_category to = (S1_inventory_category.to_inventory_category) categories.get(data.selected_row);
                tf_category_code.setText("" + to.id);
                tf_category.setText("" + to.name.toUpperCase());
                jTextField3.grabFocus();
                data_cols();
            }
        });

    }

    List<S1_inventory_classification.to_inventory_classification> classification_list = new ArrayList();

    private void init_receipt_types() {

        String where = " where name like '%" + jTextField3.getText() + "%' and category_code='" + tf_category_code.getText() + "' order by name asc";
        if (tf_category.getText().equalsIgnoreCase("All")) {
            where = " where name like '%" + jTextField3.getText() + "%'  order by name asc";
            if (jTextField3.getText().equalsIgnoreCase("All")) {
                where = "   order by name asc";
            }
        } else {
            if (jTextField3.getText().equalsIgnoreCase("All")) {
                where = " where category_code='" + tf_category_code.getText() + "' order by name asc ";
            }
        }
        classification_list.clear();
        S1_inventory_classification.to_inventory_classification c1 = new S1_inventory_classification.to_inventory_classification(0, "", "", "", "All", 0);
        List<S1_inventory_classification.to_inventory_classification> c2 = S1_inventory_classification.ret_data2(where);
        classification_list.add(c1);
        classification_list.addAll(c2);
        Object[][] obj = new Object[classification_list.size()][1];
        int i = 0;
        for (S1_inventory_classification.to_inventory_classification to : classification_list) {
            obj[i][0] = " " + to.name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category.getWidth()};
        int width = 0;
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField3, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_classification.to_inventory_classification to = classification_list.get(data.selected_row);
                jTextField3.setText(to.name.toUpperCase());
                jTextField8.setText("" + to.id);
                jTextField4.grabFocus();
                data_cols();
            }
        });

    }
    List<S1_inventory_sub_classification.to_inventory_sub_classification> sub_classification_list = new ArrayList();

    private void init_sub_classification() {

        String where = " where name like '%" + jTextField4.getText() + "%' and classification_code='" + jTextField8.getText() + "' order by name asc";
        if (jTextField3.getText().equalsIgnoreCase("All")) {
            where = " where name like '%" + jTextField4.getText() + "%'  order by name asc";
            if (jTextField4.getText().equalsIgnoreCase("All")) {
                where = " order by name asc";
            }
        } else {
            if (jTextField4.getText().equalsIgnoreCase("All")) {
                where = " where  classification_code='" + jTextField8.getText() + "' order by name asc";
            }

        }

        sub_classification_list.clear();
        S1_inventory_sub_classification.to_inventory_sub_classification c1 = new S1_inventory_sub_classification.to_inventory_sub_classification(0, "", "", "", "", "", "All", 0);
        List<S1_inventory_sub_classification.to_inventory_sub_classification> c2 = S1_inventory_sub_classification.ret_data2(where);
        sub_classification_list.add(c1);
        sub_classification_list.addAll(c2);

        Object[][] obj = new Object[sub_classification_list.size()][1];
        int i = 0;
        for (S1_inventory_sub_classification.to_inventory_sub_classification to : sub_classification_list) {
            obj[i][0] = " " + to.name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category.getWidth()};
        int width = 0;
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField4, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_sub_classification.to_inventory_sub_classification to = sub_classification_list.get(data.selected_row);
                jTextField4.setText(to.name.toUpperCase());
                jTextField9.setText("" + to.id);
                jTextField5.grabFocus();
                data_cols();
            }
        });

    }
    List<S1_inventory_brand.to_inventory_brand> brand_list = new ArrayList();

    private void init_brand() {

        String where = " where name like '%" + jTextField5.getText() + "%' order by name asc";
        if (jTextField5.getText().equalsIgnoreCase("All")) {
            where = " order by name asc";
        }
        brand_list.clear();
        S1_inventory_brand.to_inventory_brand c1 = new S1_inventory_brand.to_inventory_brand(0, "", "All");
        List<S1_inventory_brand.to_inventory_brand> c2 = S1_inventory_brand.ret_data2(where);
        brand_list.add(c1);
        brand_list.addAll(c2);
        Object[][] obj = new Object[brand_list.size()][1];
        int i = 0;
        for (S1_inventory_brand.to_inventory_brand to : brand_list) {
            obj[i][0] = " " + to.name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category.getWidth()};
        int width = 0;
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField5, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_brand.to_inventory_brand to = brand_list.get(data.selected_row);
                jTextField5.setText(to.name.toUpperCase());
                jTextField10.setText("" + to.id);
                jTextField6.grabFocus();
                data_cols();
            }
        });

    }

    List<S1_inventory_model.to_inventory_model> model_list = new ArrayList();

    private void init_model() {

        String where = " where name like '%" + jTextField6.getText() + "%' and brand_code= '" + jTextField10.getText() + "'order by name asc";
        if (jTextField5.getText().equalsIgnoreCase("All")) {
            where = " where name like '%" + jTextField6.getText() + "%' order by name asc";
            if (jTextField6.getText().equalsIgnoreCase("All")) {
                where = "  order by name asc";
            }
        } else {
            if (jTextField6.getText().equalsIgnoreCase("All")) {
                where = " where  brand_code= '" + jTextField10.getText() + "'order by name asc";
            }
        }

        model_list.clear();
        S1_inventory_model.to_inventory_model c1 = new S1_inventory_model.to_inventory_model(0, "", "", "", "All");
        List<S1_inventory_model.to_inventory_model> c2 = S1_inventory_model.ret_data2(where);
        model_list.add(c1);
        model_list.addAll(c2);
        Object[][] obj = new Object[model_list.size()][1];
        int i = 0;
        for (S1_inventory_model.to_inventory_model to : model_list) {
            obj[i][0] = " " + to.name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category.getWidth()};
        int width = 0;
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField6, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_model.to_inventory_model to = model_list.get(data.selected_row);
                jTextField6.setText(to.name.toUpperCase());
                jTextField11.setText("" + to.id);
                data_cols();
            }
        });

    }

    private void set_report() {

        jProgressBar1.setString("Loading... Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                String where = " where si.id<>0 ";

                if (!tf_category.getText().equalsIgnoreCase("All")) {
                    where = where + " and si.category_id='" + tf_category_code.getText() + "'";
                }

                if (!jTextField3.getText().equalsIgnoreCase("All")) {
                    where = where + " and si.classification_id='" + jTextField8.getText() + "'";
                }
                if (!jTextField4.getText().equalsIgnoreCase("All")) {
                    where = where + " and si.sub_classification_id='" + jTextField9.getText() + "'";
                }
                if (!jTextField5.getText().equalsIgnoreCase("All")) {
                    where = where + " and si.brand_id='" + jTextField10.getText() + "'";
                }

                if (!jTextField6.getText().equalsIgnoreCase("All")) {
                    where = where + " and si.model_id='" + jTextField11.getText() + "'";
                }

                if (!jCheckBox10.isSelected()) {
                    Field.Search tf = (Field.Search) tf_search;
                    where = " where si.id<>0 and si.item_code='" + tf.getId() + "' ";
                }
                if (!jCheckBox6.isSelected()) {
                    String date_from = DateType.sf.format(jDateChooser3.getDate());
                    String date_to = DateType.sf.format(jDateChooser4.getDate());
                    where = where + " and Date(si.date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                where = where + " and si.serial_no !='' ";

                List<MySales_Items.items> items = MySales_Items.ret_data3(where);
                List<Srpt_rma_serials.field> fields = new ArrayList();
                for (MySales_Items.items item : items) {
                    String trans = item.sales_no;
                    String type = "Sales";
                    String item_code = item.item_code;
                    String description = item.description;
                    double qty = item.product_qty;
                    String serials = item.serial_no;
                    serials = serials.replaceAll("\n", ", ");
                    String customer_name=item.discount_customer_name;
                    Srpt_rma_serials.field field = new Srpt_rma_serials.field(trans, type, item_code, description, qty, serials,customer_name);
                    fields.add(field);
                }

                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Dumaguete City");
                String category = "All";
                String classification = "All";
                String sub_classification = "All";
                String brand = "All";
                String model = "All";
                String date = "All";
                if (!jCheckBox6.isSelected()) {
                    String from = DateType.slash.format(jDateChooser3.getDate());
                    String to = DateType.slash.format(jDateChooser4.getDate());
                    date = "" + from + " - " + to;
                }
                Srpt_rma_serials rpt = new Srpt_rma_serials(business_name, address, category, classification, sub_classification, brand, model, date);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_rma_serials.jrxml";
                report_customers_aging(rpt, jrxml);
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_customers_aging(final Srpt_rma_serials to, String jrxml_name) {
        jPanel5.removeAll();
        jPanel5.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_customers_aging(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel5.add(viewer);
            jPanel5.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_customers_aging(Srpt_rma_serials to, String rpt_name) {
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
            InputStream is = Srpt_rma_serials.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
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
                String where = " where ";
                if (jCheckBox10.isSelected()) {
                    where = where + "  main_barcode like '" + search + "' and location_id='" + my_location_id + "' "
                            + " or barcode='" + search + "' and location_id='" + my_location_id + "' "
                            + " or description like '%" + search + "%' and location_id='" + my_location_id + "' ";
                }
                if (jCheckBox11.isSelected()) {
                    where = where + " main_barcode like '" + search + "' and location_id='" + my_location_id + "' "
                            + "  ";
                }
                if (jCheckBox12.isSelected()) {
                    where = where + "  "
                            + "  barcode='" + search + "' and location_id='" + my_location_id + "' ";
                }
                if (jCheckBox13.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + my_location_id + "' ";
                }
                where = where + " order by description asc ";
                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory_barcodes.ret_where(where);
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                }
                if (inventory_barcoders_list.size() == 1) {
                    Inventory_barcodes.to_inventory_barcodes t = inventory_barcoders_list.get(0);
                    Field.Search tf = (Field.Search) tf_search;
                    tf.setText(t.description);
                    tf.setId(t.main_barcode);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][5];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[i][1] = " " + to.main_barcode;
                        obj[i][2] = " " + to.description;
                        String unit = "";
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                        if (uoms != null) {
                            unit = uoms.uom;
                        }
                        obj[i][3] = " " + unit;
                        obj[i][4] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {50, 70, w - 70, 50, 70};
                    String[] col_names = {"Qty", "Item Code", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes t = inventory_barcoders_list.get(data.selected_row);
                            Field.Search tf = (Field.Search) tf_search;
                            tf.setText(t.description);
                            tf.setId(t.main_barcode);
                        }
                    });
                }

            }
        });
        t.start();
    }
}
