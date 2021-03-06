/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports3;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.branches.S1_branches;
import POS.category.Dlg_update_brand;
import POS.category.S1_inventory_brand;
import POS.category.S1_inventory_category;
import POS.category.S1_inventory_classification;
import POS.category.S1_inventory_model;
import POS.category.S1_inventory_sub_classification;
import POS.category.Dlg_update_category;
import POS.category.Dlg_update_classification;
import POS.category.Dlg_update_model;
import POS.category.Dlg_update_sub_classification;
import POS.inventory.S1_inventory;
import POS.inventory.S1_inventory.to_inventory;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
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
import org.jfree.ui.Align;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_report_item extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_report_item
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
    private Dlg_report_item(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_report_item(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_report_item() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_report_item myRef;

    private void setThisRef(Dlg_report_item myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_item> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_item create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_item create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_item dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_item((java.awt.Frame) parent, false);
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
            Dlg_report_item dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_item((java.awt.Dialog) parent, false);
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

        Dlg_report_item dialog = Dlg_report_item.create(new javax.swing.JFrame(), true);
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

        jPanel2 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        pop_category = new javax.swing.JMenuItem();
        pop_classification = new javax.swing.JMenuItem();
        pop_sub_classification = new javax.swing.JMenuItem();
        pop_brand = new javax.swing.JMenuItem();
        pop_model = new javax.swing.JMenuItem();
        pop_receipts = new javax.swing.JMenuItem();
        pop_stock_transfer = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_category = new Field.Combo();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new Field.Combo();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new Field.Combo();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new Field.Combo();
        jTextField11 = new Field.Combo();
        jTextField10 = new Field.Combo();
        jTextField9 = new Field.Combo();
        jTextField8 = new Field.Combo();
        tf_category_code = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_location = new Field.Combo();
        tf_branch = new Field.Combo();
        tf_branch_id = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new Field.Input();
        jButton2 = new Button.Default();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton3 = new Button.Info();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pop_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/category.png"))); // NOI18N
        pop_category.setText("Category");
        pop_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_categoryActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_category);

        pop_classification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/stock_physical_count.png"))); // NOI18N
        pop_classification.setText("Classification");
        pop_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_classificationActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_classification);

        pop_sub_classification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/item.png"))); // NOI18N
        pop_sub_classification.setText("Sub Classification");
        pop_sub_classification.setToolTipText("");
        pop_sub_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_sub_classificationActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_sub_classification);

        pop_brand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/items.png"))); // NOI18N
        pop_brand.setText("Brand");
        pop_brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_brandActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_brand);

        pop_model.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/models.png"))); // NOI18N
        pop_model.setText("Model");
        pop_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_modelActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_model);

        pop_receipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/receipts.png"))); // NOI18N
        pop_receipts.setText("Receipts");
        pop_receipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_receiptsActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_receipts);

        pop_stock_transfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/stock_transfer.png"))); // NOI18N
        pop_stock_transfer.setText("Stock Transfer");
        pop_stock_transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_stock_transferActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_stock_transfer);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Category:");

        tf_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category.setText("All");
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Classification:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setText("All");
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Sub-Classification:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setText("All");
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Brand:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setText("All");
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Model:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setText("All");
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

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setText("0");
        jTextField10.setFocusable(false);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setText("0");
        jTextField9.setFocusable(false);

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setText("0");
        jTextField8.setFocusable(false);

        tf_category_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category_code.setText("0");
        tf_category_code.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Branch:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Location:");

        tf_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_locationMouseClicked(evt);
            }
        });
        tf_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_locationActionPerformed(evt);
            }
        });

        tf_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branchMouseClicked(evt);
            }
        });
        tf_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branchActionPerformed(evt);
            }
        });

        tf_branch_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_branch_id.setText("0");
        tf_branch_id.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("0");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("All/with quantity");

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("All/Search Query");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_category, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_category_code, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_branch, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(tf_location))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_category)
                                .addComponent(tf_category_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_inventory.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tbl_inventory.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventoryMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_inventoryMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_inventoryMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_inventory);

        jLabel7.setText("Total Items:");

        jLabel9.setText("0");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setRequestFocusEnabled(false);
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Status:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/search19.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Show Category");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Show Classification");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Show Sub-Classification");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Show Brand");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Show Model");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_reports/copy23.png"))); // NOI18N
        jButton3.setText("Print Preview");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
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

    private void tf_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoryActionPerformed
        init_categories();
    }//GEN-LAST:event_tf_categoryActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_receipt_types();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_sub_classification();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_brand();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        init_model();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void tf_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_locationActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_tf_locationActionPerformed

    private void tf_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branchActionPerformed
        init_branches();
    }//GEN-LAST:event_tf_branchActionPerformed

    private void tbl_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventoryMouseClicked
        select();
    }//GEN-LAST:event_tbl_inventoryMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_inventoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventoryMousePressed
        show_popup(evt);
    }//GEN-LAST:event_tbl_inventoryMousePressed

    private void tbl_inventoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventoryMouseReleased
        show_popup(evt);
    }//GEN-LAST:event_tbl_inventoryMouseReleased

    private void pop_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_categoryActionPerformed
        update_category();
    }//GEN-LAST:event_pop_categoryActionPerformed

    private void pop_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_classificationActionPerformed
        update_classification();
    }//GEN-LAST:event_pop_classificationActionPerformed

    private void pop_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_modelActionPerformed
        update_model();
    }//GEN-LAST:event_pop_modelActionPerformed

    private void pop_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_brandActionPerformed
        update_brand();
    }//GEN-LAST:event_pop_brandActionPerformed

    private void pop_sub_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_sub_classificationActionPerformed
        update_sub_classification();
    }//GEN-LAST:event_pop_sub_classificationActionPerformed

    private void pop_receiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_receiptsActionPerformed
        item_receipts();
    }//GEN-LAST:event_pop_receiptsActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        init_tbl_inventory_barcodes();
        data_cols();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        init_tbl_inventory_barcodes();
        data_cols();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        init_tbl_inventory_barcodes();
        data_cols();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        init_tbl_inventory_barcodes();
        data_cols();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        init_tbl_inventory_barcodes();
        data_cols();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void pop_stock_transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_stock_transferActionPerformed
        stock_receipts();
    }//GEN-LAST:event_pop_stock_transferActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tf_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_categoryMouseClicked
        init_categories();
    }//GEN-LAST:event_tf_categoryMouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_receipt_types();
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        init_sub_classification();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_brand();
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        init_model();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

    }//GEN-LAST:event_jPanel3MouseClicked

    private void tf_locationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_locationMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_locationMouseClicked

    private void tf_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branchMouseClicked
        init_branches();
    }//GEN-LAST:event_tf_branchMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        generate();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JMenuItem pop_brand;
    private javax.swing.JMenuItem pop_category;
    private javax.swing.JMenuItem pop_classification;
    private javax.swing.JMenuItem pop_model;
    private javax.swing.JMenuItem pop_receipts;
    private javax.swing.JMenuItem pop_stock_transfer;
    private javax.swing.JMenuItem pop_sub_classification;
    private javax.swing.JTable tbl_inventory;
    private javax.swing.JTextField tf_branch;
    private javax.swing.JLabel tf_branch_id;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_category_code;
    private javax.swing.JTextField tf_location;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();

        set_default_branch();
        init_tbl_inventory_barcodes();

        tf_category_code.setVisible(false);
        jTextField8.setVisible(false);
        jTextField9.setVisible(false);
        jTextField10.setVisible(false);
        jTextField11.setVisible(false);
        tf_branch_id.setVisible(false);
        jLabel11.setVisible(false);
        tbl_inventory.updateUI();
        jScrollPane1.updateUI();
    }

    private void focus() {
        JTextField[] tf = {tf_category, jTextField3, jTextField4, jTextField5, jTextField6, tf_branch, tf_location, jTextField1};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    private void set_default_branch() {

        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        tf_branch.setText(to.branch);
        tf_branch_id.setText(to.branch_id);
        tf_location.setText(to.location);
        jLabel11.setText("" + to.id);
        jCheckBox1.setVisible(false);
        jCheckBox2.setVisible(false);
        jCheckBox3.setVisible(false);
        jCheckBox4.setVisible(false);
        jCheckBox5.setVisible(false);

    }

    public void do_pass() {
        view_only = 0;
        init_tbl_inventory_barcodes();
        tbl_inventory.updateUI();
        jScrollPane1.updateUI();
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

    List<S1_inventory_category.to_inventory_category> categories = new ArrayList();

    private void init_categories() {
        String where = " where name like '%" + tf_category.getText() + "%' order by name asc";
        categories.clear();
        categories = S1_inventory_category.ret_data2(where);
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
        if (tf_category_code.getText().equals("0")) {
            where = " where name like '%" + jTextField3.getText() + "%'  order by name asc";
        }
        classification_list.clear();
        classification_list = S1_inventory_classification.ret_data2(where);
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
        if (jTextField8.getText().equals("0")) {
            where = " where name like '%" + jTextField4.getText() + "%'  order by name asc";
        }

        sub_classification_list.clear();
        sub_classification_list = S1_inventory_sub_classification.ret_data2(where);
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
        brand_list.clear();
        brand_list = S1_inventory_brand.ret_data2(where);
        Object[][] obj = new Object[brand_list.size()][1];
        int i = 0;
        for (S1_inventory_brand.to_inventory_brand to : brand_list) {
            obj[i][0] = to.name.toUpperCase();
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
        if (jTextField10.getText().equals("0")) {
            where = " where name like '%" + jTextField6.getText() + "%' order by name asc";
        }

        model_list.clear();
        model_list = S1_inventory_model.ret_data2(where);
        Object[][] obj = new Object[model_list.size()][1];
        int i = 0;
        for (S1_inventory_model.to_inventory_model to : model_list) {
            obj[i][0] = to.name.toUpperCase();
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
    List<S1_branches.to_branches> branches_list = new ArrayList();

    private void init_branches() {
        String search = tf_branch.getText();
        String where = " where branch like '%" + search + "%' order by branch asc";
        branches_list.clear();
        branches_list = S1_branches.ret_where2(where);
        Object[][] obj = new Object[branches_list.size()][2];
        int i = 0;
        for (S1_branches.to_branches to : branches_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.branch;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        int width = 0;
        String[] col_names = {"Code", "Branch"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branches.to_branches to = branches_list.
                        get(data.selected_row);
                tf_branch.setText("" + to.branch);
                tf_branch_id.setText("" + to.id);
            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {
        String search = tf_location.getText();
        String branch_id = tf_branch_id.getText();
        String where = " where  branch_id='" + branch_id + "' and location like '%" + search + "%' order by location asc";
        if (branch_id.equals("0")) {
            where = " where  location like '%" + search + "%' order by location asc";
        }
        branch_location_list.clear();
        branch_location_list = S1_branch_locations.ret_where2(where);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.location;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_location.setText("" + to.location);
                jLabel11.setText("" + to.id);
            }
        });
    }

    public class CustomRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 6703872492730589499L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!table.getValueAt(row, 0).toString().equals(" ")) {
                cellComponent.setBackground(new java.awt.Color(156, 203, 25));
            } else {
                cellComponent.setBackground(new java.awt.Color(255, 255, 255));
            }
            if (!table.getValueAt(row, 1).toString().equals(" ") && table.getValueAt(row, 0).toString().equals(" ")) {
                cellComponent.setBackground(new java.awt.Color(238, 230, 133));
            }
            if (column == 5 || column == 6) {
                JLabel lbl = (JLabel) cellComponent;
                lbl.setHorizontalAlignment(RIGHT);
                if (view_only == 0) {
                    table.getColumnModel().getColumn(5).setPreferredWidth(0);
                    table.getColumnModel().getColumn(5).setMaxWidth(0);
                    table.getColumnModel().getColumn(5).setMinWidth(0);
                }
            }
            if (column == 4) {
                JLabel lbl = (JLabel) cellComponent;
                lbl.setHorizontalAlignment(CENTER);
            }

            if (column == 3) {
                table.getColumnModel().getColumn(3).setPreferredWidth(500);
            }
            return cellComponent;
        }
    }

    private ArrayListModel tbl_inventory_barcodes_ALM;
    private Tblinventory_barcodesModel tbl_inventory_barcodes_M;

    static int category = 0;
    static int group = 0;
    static int view_only = 1;

    private void init_tbl_inventory_barcodes() {
        tbl_inventory_barcodes_ALM = new ArrayListModel();
        tbl_inventory_barcodes_M = new Tblinventory_barcodesModel(tbl_inventory_barcodes_ALM);

        tbl_inventory.setModel(tbl_inventory_barcodes_M);
        tbl_inventory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory.setRowHeight(25);

        if (jCheckBox1.isSelected() || jCheckBox2.isSelected() || jCheckBox3.isSelected() || jCheckBox4.isSelected() || jCheckBox5.isSelected()) {
            category = 100;
        }
        if (jCheckBox1.isSelected()) {
            group = 1;
        }
        if (jCheckBox2.isSelected()) {
            group = 2;
        }
        if (jCheckBox3.isSelected()) {
            group = 3;
        }
        if (jCheckBox4.isSelected()) {
            group = 4;
        }
        if (jCheckBox5.isSelected()) {
            group = 5;
        }

        if (tbl_inventory.getColumnModel().getColumnCount() > 0 && tbl_inventory.getColumnModel().getColumnCount() < 9) {

        }
        tbl_inventory.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbl_inventory.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl_inventory.getColumnModel().getColumn(2).setPreferredWidth(60);
        tbl_inventory.getColumnModel().getColumn(3).setPreferredWidth(200);

        tbl_inventory.getColumnModel().getColumn(12).setPreferredWidth(40);
        Dimension d = tbl_inventory.getTableHeader().getPreferredSize();
        d.height = 30;

        tbl_inventory.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));
        tbl_inventory.setRowHeight(30);
        tbl_inventory.setFont(new java.awt.Font("Arial", 0, 14));
        tbl_inventory.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(3).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(4).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(5).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(6).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(7).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(8).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(9).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(10).setCellRenderer(new CustomRenderer());
        tbl_inventory.getColumnModel().getColumn(11).setCellRenderer(new CustomRenderer());
        tbl_inventory.setAutoResizeMode(0);
        TableColumn tc = tbl_inventory.getColumnModel().getColumn(12);
        tc.setCellEditor(tbl_inventory.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tbl_inventory.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));

    }

    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = tbl_inventory.getRowCount(); x < y; x++) {
                tbl_inventory.setValueAt(checked, x, 0);
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
                    rendererComponent.setBackground(new java.awt.Color(204, 204, 204));
                    rendererComponent.setHorizontalAlignment(Align.CENTER);
                    rendererComponent.setOpaque(true);
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
            List<to_inventory> datas = tbl_inventory_barcodes_ALM;
            boolean selected = false;
            if (this.isSelected()) {
                selected = true;
            }
            for (to_inventory to : datas) {
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

    private void loadData_inventory_barcodes(List<to_inventory> acc) {
        tbl_inventory_barcodes_ALM.clear();
        tbl_inventory_barcodes_ALM.addAll(acc);
    }

    public static class Tblinventory_barcodesModel extends AbstractTableAdapter {

        int w = 0;

        public static String[] COLUMNS = {
            "Branch", "Location", "Code", "Description", "Qty", "Cost", "Price", "Category", "Classification", "Sub-Classification", "Brand", "Model", ""

        };

        public Tblinventory_barcodesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);

        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 12) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_inventory tt = (to_inventory) getRow(row);

            switch (col) {
                case 0:
                    return " " + tt.branch;
                case 1:
                    return " " + tt.location;
                case 2:
                    return " " + tt.barcodes;
                case 3:
                    return " " + tt.description;
                case 4:
                    return FitIn.fmt_woc(tt.product_qty);
                case 5:
                    if (view_only == 0) {
                        return "";
                    } else {
                        return FitIn.fmt_wc_0(tt.cost) + " ";
                    }

                case 6:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 7:
                    return " " + tt.category;
                case 8:
                    return " " + tt.classification;
                case 9:
                    return " " + tt.sub_classification;
                case 10:
                    return " " + tt.brand;
                case 11:
                    return " " + tt.model;

                default:
                    return tt.selected;

            }
        }
    }

    private void data_cols() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where status='" + "1" + "' ";
                if (!tf_branch_id.getText().equals("0")) {
                    where = where + " and branch_code='" + tf_branch_id.getText() + "'";
                }
                if (!jLabel11.getText().equals("0")) {
                    where = where + " and location_id='" + jLabel11.getText() + "'";
                }
                if (!tf_category_code.getText().equals("0")) {
                    where = where + " and category_id='" + tf_category_code.getText() + "'";
                }

                if (!jTextField8.getText().equals("0")) {
                    where = where + " and classification_id='" + jTextField8.getText() + "'";
                }
                if (!jTextField9.getText().equals("0")) {
                    where = where + " and sub_classification_id='" + jTextField9.getText() + "'";
                }
                if (!jTextField10.getText().equals("0")) {
                    where = where + " and brand_id='" + jTextField10.getText() + "'";
                }

                if (!jTextField11.getText().equals("0")) {
                    where = where + " and model_id='" + jTextField11.getText() + "'";
                }

                String where2 = where + " and main_barcode = '" + jTextField1.getText() + "' order by branch,location,description asc "
                        + " ";
                where2 = where2.replaceAll("where", " \nor");
                if (jCheckBox6.isSelected()) {
                    where = where + " and description like '%" + jTextField1.getText() + "%'  ";
                } else {
                    where = where + " and description like '%" + jTextField1.getText() + "%' and product_qty>0";
                }

                where = where + " " + where2;

                System.out.println(where);
                List<to_inventory> datas = S1_inventory.ret_data5(where);
                loadData_inventory_barcodes(datas);
                jLabel9.setText("" + tbl_inventory_barcodes_ALM.size());
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void select() {

        int row = tbl_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_inventory.getSelectedColumn();
        to_inventory to = (to_inventory) tbl_inventory_barcodes_ALM.get(tbl_inventory.convertRowIndexToModel(row));
        if (col == 12) {

            if (to.selected == true) {
                to.setSelected(false);
            } else {
                to.setSelected(true);
            }
            tbl_inventory_barcodes_M.fireTableDataChanged();
        }
        if (col == 4) {
            select_qty(to);
        }
    }

    private void select_qty(to_inventory to) {
        Window p = (Window) this;
        Dlg_report_item_qty nd = Dlg_report_item_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.date_added, to.user_name, to.barcodes, to.barcode, to.description, to.location_id);
        nd.setCallback(new Dlg_report_item_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_qty.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void show_popup(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_inventory, evt.getX(), evt.getY());
        }
    }

    private void update_category() {
        Window p = (Window) this;
        Dlg_update_category nd = Dlg_update_category.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_update_category.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, final Dlg_update_category.OutputData data) {
                closeDialog.ok();
                List<to_inventory> datas = tbl_inventory_barcodes_ALM;
                final List<to_inventory> list = new ArrayList();
                for (to_inventory to : datas) {
                    if (to.selected == true) {
                        list.add(to);
                    }
                }

                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Srpt_report_item.edit_category(list, data.category, data.category_id);
                        data_cols();
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void update_classification() {
        Window p = (Window) this;
        Dlg_update_classification nd = Dlg_update_classification.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_update_classification.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, final Dlg_update_classification.OutputData data) {
                closeDialog.ok();
                List<to_inventory> datas = tbl_inventory_barcodes_ALM;
                final List<to_inventory> list = new ArrayList();
                for (to_inventory to : datas) {
                    if (to.selected == true) {
                        list.add(to);
                    }
                }
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Srpt_report_item.edit_classification(list, data.classification, data.classification);
                        data_cols();
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void update_sub_classification() {
        Window p = (Window) this;
        Dlg_update_sub_classification nd = Dlg_update_sub_classification.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_update_sub_classification.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, final Dlg_update_sub_classification.OutputData data) {
                closeDialog.ok();
                List<to_inventory> datas = tbl_inventory_barcodes_ALM;
                final List<to_inventory> list = new ArrayList();
                for (to_inventory to : datas) {
                    if (to.selected == true) {
                        list.add(to);
                    }
                }
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Srpt_report_item.edit_sub_classification(list, data.sub_classification, data.sub_classification_id);
                        data_cols();
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void update_brand() {
        Window p = (Window) this;
        Dlg_update_brand nd = Dlg_update_brand.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_update_brand.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, final Dlg_update_brand.OutputData data) {
                closeDialog.ok();
                List<to_inventory> datas = tbl_inventory_barcodes_ALM;
                final List<to_inventory> list = new ArrayList();
                for (to_inventory to : datas) {
                    if (to.selected == true) {
                        list.add(to);
                    }
                }
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Srpt_report_item.edit_brand(list, data.brand, data.brand_id);
                        data_cols();
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void update_model() {
        Window p = (Window) this;
        Dlg_update_model nd = Dlg_update_model.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_update_model.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, final Dlg_update_model.OutputData data) {
                closeDialog.ok();
                List<to_inventory> datas = tbl_inventory_barcodes_ALM;
                final List<to_inventory> list = new ArrayList();
                for (to_inventory to : datas) {
                    if (to.selected == true) {
                        list.add(to);
                    }
                }
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Srpt_report_item.edit_model(list, data.model, data.model_id);
                        data_cols();
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void item_receipts() {
        int row = tbl_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory to = (to_inventory) tbl_inventory_barcodes_ALM.get(tbl_inventory.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_report_item_receipts nd = Dlg_report_item_receipts.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.barcodes, to.description);
        nd.setCallback(new Dlg_report_item_receipts.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_receipts.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void stock_receipts() {
        int row = tbl_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory to = (to_inventory) tbl_inventory_barcodes_ALM.get(tbl_inventory.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_report_item_stock_transfer nd = Dlg_report_item_stock_transfer.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.barcodes, to.description);
        nd.setCallback(new Dlg_report_item_stock_transfer.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_stock_transfer.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void generate() {

        String where = " where status='" + "1" + "' ";
        if (!tf_branch_id.getText().equals("0")) {
            where = where + " and branch_code='" + tf_branch_id.getText() + "'";
        }
        if (!jLabel11.getText().equals("0")) {
            where = where + " and location_id='" + jLabel11.getText() + "'";
        }
        if (!tf_category_code.getText().equals("0")) {
            where = where + " and category_id='" + tf_category_code.getText() + "'";
        }

        if (!jTextField8.getText().equals("0")) {
            where = where + " and classification_id='" + jTextField8.getText() + "'";
        }
        if (!jTextField9.getText().equals("0")) {
            where = where + " and sub_classification_id='" + jTextField9.getText() + "'";
        }
        if (!jTextField10.getText().equals("0")) {
            where = where + " and brand_id='" + jTextField10.getText() + "'";
        }

        if (!jTextField11.getText().equals("0")) {
            where = where + " and model_id='" + jTextField11.getText() + "'";
        }
        where = where + " group by main_barcode order by description asc ";

        List<Srpt_stock_take.field> datas = new ArrayList();
        if (jCheckBox7.isSelected()) {
            datas = Srpt_stock_take.ret_data(where);
        } else {
            List<to_inventory> datas2 = tbl_inventory_barcodes_ALM;
            for (to_inventory to : datas2) {
                String item_code = to.barcode;
                String barcode = to.barcode;
                String description = to.description;
                double qty = to.product_qty;
                double selling_price = to.selling_price;
                double cost = to.cost;
                String uom = to.unit;
                String code = to.barcode;
                Srpt_stock_take.field field = new Srpt_stock_take.field(item_code, barcode, description, qty, selling_price, cost, uom, code);
                datas.add(field);
            }
        }

        String category1 = tf_category.getText();
        String classification = jTextField3.getText();
        String sub_classification = jTextField4.getText();
        String brand = jTextField5.getText();
        String model = jTextField6.getText();
        Window p = (Window) this;
        Dlg_report_item_print_preview nd = Dlg_report_item_print_preview.create(p, true);
        nd.setTitle("");
        nd.do_pass(datas, category1, classification, sub_classification, brand, model);
        nd.setCallback(new Dlg_report_item_print_preview.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_print_preview.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
