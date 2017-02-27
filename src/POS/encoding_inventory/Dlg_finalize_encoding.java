/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.encoding_inventory;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.encoding_inventory.Encoding_inventory.to_encoding_inventory;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.S2_inventory_barcodes;
import POS.unit_of_measure.S1_unit_of_measure;
import POS.users.S1_users;
import POS.users.S2_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Ronald
 */
public class Dlg_finalize_encoding extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_finalize_encoding
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
    private Dlg_finalize_encoding(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_finalize_encoding(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_finalize_encoding() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_finalize_encoding myRef;

    private void setThisRef(Dlg_finalize_encoding myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_finalize_encoding> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_finalize_encoding create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_finalize_encoding create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_finalize_encoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_finalize_encoding((java.awt.Frame) parent, false);
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
            Dlg_finalize_encoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_finalize_encoding((java.awt.Dialog) parent, false);
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

        Dlg_finalize_encoding dialog = Dlg_finalize_encoding.create(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);C
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_sheet_no = new javax.swing.JTextField();
        cb_sheet = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cb_user = new javax.swing.JCheckBox();
        tf_user = new javax.swing.JTextField();
        tf_user_name = new javax.swing.JTextField();
        tf_description = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_item_code = new Field.Search();
        jButton2 = new Button.Info();
        jButton3 = new Button.Warning();
        jButton4 = new Button.Success();
        tf_cost = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_selling_price = new javax.swing.JTextField();
        tf_description1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel15 = new javax.swing.JLabel();
        tf_qty_branch = new Field.Combo();
        jLabel31 = new javax.swing.JLabel();
        tf_location = new javax.swing.JTextField();
        tf_search_branch_code = new javax.swing.JTextField();
        tf_location_id = new javax.swing.JTextField();
        jButton5 = new Button.Warning();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_encoding_inventory = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbl_total_items = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_total_qty = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Sheet #:");

        tf_sheet_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_sheet_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sheet_noActionPerformed(evt);
            }
        });

        cb_sheet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_sheet.setSelected(true);
        cb_sheet.setText("All");
        cb_sheet.setFocusable(false);
        cb_sheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sheetActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("User:");

        cb_user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_user.setSelected(true);
        cb_user.setText("All");
        cb_user.setFocusable(false);
        cb_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_userActionPerformed(evt);
            }
        });

        tf_user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_userActionPerformed(evt);
            }
        });

        tf_user_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descriptionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Item Code:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Qty:");

        tf_qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Description:");

        tf_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_item_code.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_item_codeMouseClicked(evt);
            }
        });
        tf_item_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_item_codeActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Finalize");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tf_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Cost:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Selling Price:");

        tf_selling_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_selling_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_selling_priceActionPerformed(evt);
            }
        });

        tf_description1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_description1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Barcode:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Date:");

        jMonthChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Branch:");

        tf_qty_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_qty_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_qty_branchMouseClicked(evt);
            }
        });
        tf_qty_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qty_branchActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Location:");

        tf_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location.setFocusable(false);
        tf_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_locationActionPerformed(evt);
            }
        });

        tf_search_branch_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search_branch_code.setFocusable(false);

        tf_location_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location_id.setFocusable(false);

        jButton5.setText("Rollback");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Item Code");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cb_sheet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_sheet_no, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_user)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_user, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                        .addGap(2, 2, 2)
                        .addComponent(tf_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_qty_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_location, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_search_branch_code)
                            .addComponent(tf_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_description)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_selling_price, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(tf_description1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_item_code)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_qty_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_search_branch_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_location_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_sheet_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_sheet, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_encoding_inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_encoding_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_encoding_inventoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_encoding_inventory);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tota Items:");

        lbl_total_items.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_total_items.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tota Qty:");

        lbl_total_qty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_total_qty.setText("0");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel8.setText("Status:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total_items, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(477, 477, 477)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lbl_total_items)
                        .addComponent(jLabel7)
                        .addComponent(lbl_total_qty))
                    .addComponent(jLabel8)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tf_sheet_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sheet_noActionPerformed
//        init_sheet();
        data_cols();
    }//GEN-LAST:event_tf_sheet_noActionPerformed

    private void tf_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_userActionPerformed
        init_branches();
    }//GEN-LAST:event_tf_userActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_sheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sheetActionPerformed
        select_sheet();
    }//GEN-LAST:event_cb_sheetActionPerformed

    private void cb_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_userActionPerformed
        select_user();
    }//GEN-LAST:event_cb_userActionPerformed

    private void tf_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descriptionActionPerformed
        init_inventory();
    }//GEN-LAST:event_tf_descriptionActionPerformed

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        edit_encoding_inventory();
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_encoding_inventory();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete_encoding_inventory();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_encoding_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_encoding_inventoryMouseClicked
        select_encoding_inventory();
    }//GEN-LAST:event_tbl_encoding_inventoryMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        finalize_encoding();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
//        add_encoding_inventory();
        edit_encoding_inventory();
    }//GEN-LAST:event_tf_costActionPerformed

    private void tf_selling_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_selling_priceActionPerformed
//        add_encoding_inventory();
        edit_encoding_inventory();
    }//GEN-LAST:event_tf_selling_priceActionPerformed

    private void tf_description1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_description1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_description1ActionPerformed

    private void tf_item_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_item_codeActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_item_codeActionPerformed

    private void tf_item_codeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_item_codeMouseClicked

    }//GEN-LAST:event_tf_item_codeMouseClicked

    private void tf_qty_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qty_branchActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_tf_qty_branchActionPerformed

    private void tf_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_locationActionPerformed

    }//GEN-LAST:event_tf_locationActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        rollback_encoding();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_qty_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_qty_branchMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_qty_branchMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_sheet;
    private javax.swing.JCheckBox cb_user;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lbl_total_items;
    private javax.swing.JLabel lbl_total_qty;
    private javax.swing.JTable tbl_encoding_inventory;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_description1;
    private javax.swing.JTextField tf_item_code;
    private javax.swing.JTextField tf_location;
    private javax.swing.JTextField tf_location_id;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_qty_branch;
    private javax.swing.JTextField tf_search_branch_code;
    private javax.swing.JTextField tf_selling_price;
    private javax.swing.JTextField tf_sheet_no;
    private javax.swing.JTextField tf_user;
    private javax.swing.JTextField tf_user_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        tf_user_name.setVisible(false);
        init_tbl_encoding_inventory();
        set_default_branch();
        focus();
        tf_sheet_no.enable(false);
        tf_user.enable(false);
        tf_description.enable(false);

        String where = " order by branch,location asc ";
        branch_location_list = S1_branch_locations.ret_where(where);
    }
    String location_ids = "";

    private void set_default_branch() {

        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        location_ids = "" + to.id;

        tf_qty_branch.setText(to.branch);
        tf_search_branch_code.setText(to.branch_id);
        tf_location.setText(to.location);
        tf_location_id.setText("" + to.id);
    }

    private void focus() {
        JTextField[] tf = {tf_sheet_no, tf_user_name, tf_user, tf_description, tf_item_code, tf_qty, tf_cost, tf_selling_price, tf_qty_branch, tf_location};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    private void select_sheet() {
        if (tf_sheet_no.isEnabled()) {
            tf_sheet_no.enable(false);
        } else {
            tf_sheet_no.enable(true);
            tf_sheet_no.grabFocus();
        }
    }

    private void select_user() {
        if (tf_user.isEnabled()) {
            tf_user.enable(false);
        } else {
            tf_user.enable(true);
            tf_user.grabFocus();
        }
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
    private ArrayListModel tbl_encoding_inventory_ALM;
    private Tblencoding_inventoryModel tbl_encoding_inventory_M;

    private void init_tbl_encoding_inventory() {
        tbl_encoding_inventory_ALM = new ArrayListModel();
        tbl_encoding_inventory_M = new Tblencoding_inventoryModel(tbl_encoding_inventory_ALM);
        tbl_encoding_inventory.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_encoding_inventory.setModel(tbl_encoding_inventory_M);
        tbl_encoding_inventory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_encoding_inventory.setRowHeight(25);
        int[] tbl_widths_encoding_inventory = {100, 100, 100, 100, 50, 70, 100, 50, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_encoding_inventory.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_encoding_inventory, i, tbl_widths_encoding_inventory[i]);
        }
        Dimension d = tbl_encoding_inventory.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_encoding_inventory.getTableHeader().setPreferredSize(d);
        tbl_encoding_inventory.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_encoding_inventory.setRowHeight(25);
        tbl_encoding_inventory.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_encoding_inventory(List<to_encoding_inventory> acc) {
        tbl_encoding_inventory_ALM.clear();
        tbl_encoding_inventory_ALM.addAll(acc);
    }

    public static class Tblencoding_inventoryModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Barcode", "Description", "Sheet #", "User", "Location", "Status", "qty", "date_added", "user_name", "screen_name", "sheet_no"
        };

        public Tblencoding_inventoryModel(ListModel listmodel) {
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
            to_encoding_inventory tt = (to_encoding_inventory) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.item_code;
                case 2:
                    return " " + tt.barcode;
                case 3:
                    return " " + tt.description;
                case 4:
                    return " " + tt.sheet_no;
                case 5:

                    return " " + tt.user_name;
                case 6:
                    return " " + tt.location;
                case 7:
                    if (tt.status == 0) {
                        return "  --  ";
                    } else {
                        return "  OK";
                    }
                case 8:
                    return tt.qty;
                case 9:
                    return tt.date_added;
                case 10:
                    return tt.user_name;
                case 11:
                    return tt.screen_name;
                default:
                    return tt.sheet_no;
            }
        }
    }

    private void data_cols() {
        String where = " ";
        String sheet_no = tf_sheet_no.getText();
        String year = "" + jYearChooser1.getYear();
        String month = "" + (jMonthChooser1.getMonth() + 1);
        if (month.length() == 1) {
            month = "0" + month;
        }
        String user_name = tf_user_name.getText();
        String location_id = tf_location_id.getText();
        if (!cb_sheet.isSelected()) {
            where = where + " where sheet_no='" + sheet_no + "' and location_id='" + location_id + "' ";

            if (!cb_user.isSelected()) {
                where = where + " and user_name='" + user_name + "' ";
                where = where + " and YEAR(date_added) ='" + year + "' and MONTH(date_added) ='" + month + "'";
            } else {
                where = where + " and YEAR(date_added) ='" + year + "' and MONTH(date_added) ='" + month + "'";
            }

        } else {
            if (!cb_user.isSelected()) {
                where = " where user_name='" + user_name + "' ";
                where = where + " and YEAR(date_added) ='" + year + "' and MONTH(date_added) ='" + month + "'";
            } else {
                where = " where YEAR(date_added) ='" + year + "' and MONTH(date_added) ='" + month + "'";
            }
        }
        where = where + " and location_id='" + tf_location_id.getText() + "' ";
        System.out.println(where);
        List<to_encoding_inventory> datas = S1_finalize_encoding.ret_data(where);

        loadData_encoding_inventory(datas);

        int qty = 0;
        int count = datas.size();
        for (to_encoding_inventory to : datas) {
            qty += to.qty;
        }
        lbl_total_items.setText("" + count);
        lbl_total_qty.setText("" + qty);
    }

    List<S1_users.to_users> users_list = new ArrayList();

    private void init_branches() {
        String search = tf_user.getText();
        users_list.clear();
        users_list = S2_users.ret_data(search);
        Object[][] obj = new Object[users_list.size()][2];
        int i = 0;
        for (S1_users.to_users to : users_list) {
            obj[i][0] = to.id;
            obj[i][1] = to.screen_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        int width = 0;
        String[] col_names = {"Id", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_user, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_users.to_users to = users_list.get(data.selected_row);
                tf_user.setText(to.screen_name);
                tf_user_name.setText(to.user_name);
                data_cols();
            }
        });
    }

    List<Inventory.to_inventory> inventory_list = new ArrayList();

    private void init_inventory() {
        String search = tf_description.getText();
        inventory_list.clear();
        inventory_list = Inventory.ret_data3(search);
        if (inventory_list.size() == 1) {
            Inventory.to_inventory to = inventory_list.get(0);
            tf_item_code.setText(to.description);
            tf_description.setText(to.barcode);
            tf_qty.grabFocus();
        } else {
            Alert.set(0, "Item Not Found");
        }
//        Object[][] obj = new Object[inventory_list.size()][2];
//        int i = 0;
//        for (S1_inventory.to_inventory to : inventory_list) {
//            obj[i][0] = to.barcode;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
//            obj[i][1] = to.description;//TextHighlighter1.highlight2(to.description, to.description, "");
//            i++;
//        }
//        JLabel[] labels = {};
//        int w1 = tf_description.getWidth();
//        int[] tbl_widths_customers = {100, w1};
//        int width = 0;
//        for (int w : tbl_widths_customers) {
//            width += w;
//        }
//        String[] col_names = {"Item Code", "Description"};
//        TableRenderer tr = new TableRenderer();
//        TableRenderer.
//                setPopup2(tf_description, obj, labels, tbl_widths_customers, col_names, width);
//        tr.setCallback(new TableRenderer.Callback() {
//
//            @Override
//            public void ok(TableRenderer.OutputData data) {
//                S1_inventory.to_inventory to = inventory_list.get(data.selected_row);
//                tf_item_code.setText(to.barcode);
//                tf_description.setText(to.description);
//                tf_qty.grabFocus();
//            }
//        });
    }
    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_item_code.getText();
                String where = " where main_barcode='" + search + "' and location_id='" + location_ids + "' "
                        + " or barcode='" + search + "' and location_id='" + location_ids + "'";
                inventory_barcoders_list.clear();
                inventory_barcoders_list = S2_inventory_barcodes.ret_data(where);
                if (inventory_barcoders_list.size() == 1) {
                    selected_row = 0;
                    Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(0);
                    tf_item_code.setText(to.description);
                    tf_description.setText(to.main_barcode);
                    tf_description1.setText(to.barcode);
                    tf_cost.setText(FitIn.fmt_wc_0(to.cost));
                    tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
                    tf_qty.grabFocus();
                }
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][7];
                    int it = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[it][0] = " " + FitIn.fmt_woc(to.product_qty);
                        obj[it][1] = " " + to.main_barcode;
                        obj[it][2] = " " + to.barcode;
                        obj[it][3] = " " + to.description;
                        obj[it][4] = to.unit;
                        List<S1_unit_of_measure.to_uom> uoms = new ArrayList();
                        String[] list = to.unit.split(",");
                        int def = 0;
                        int o = 0;
                        for (String s : list) {
                            int i = s.indexOf(":");
                            int ii = s.indexOf("/");
                            int iii = s.indexOf("^");
                            String uom1 = s.substring(1, i);
                            double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                            double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
                            int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                            S1_unit_of_measure.to_uom to1 = new S1_unit_of_measure.to_uom(uom1, selling_price, conversion, is_default);
                            uoms.add(to1);
                            if (to1.is_default == 1) {
                                def = o;
                                break;
                            }
                            o++;
                        }
                        S1_unit_of_measure.to_uom t = (S1_unit_of_measure.to_uom) uoms.get(o);
                        obj[it][4] = " " + t.unit;
                        obj[it][5] = " " + FitIn.fmt_wc_0(to.cost);
                        obj[it][6] = " " + FitIn.fmt_wc_0(t.price);
                        it++;
                    }
                    JLabel[] labels = {};
                    double width = tf_item_code.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {40, 60, 100, w, 30, 50};
                    String[] col_names = {"Qty", "ItemCode", "Barcode", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_item_code, obj, labels, tbl_widths_customers, col_names);
                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            selected_row = data.selected_row;
                            Inventory_barcodes.to_inventory_barcodes to = (Inventory_barcodes.to_inventory_barcodes) inventory_barcoders_list.get(data.selected_row);

                            tf_item_code.setText(to.description);
                            tf_description.setText(to.main_barcode);
                            tf_description1.setText(to.barcode);
                            tf_cost.setText(FitIn.fmt_wc_0(to.cost));
                            tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
                            tf_qty.grabFocus();
                        }
                    });
                }

            }
        });
        t.start();
    }
    int selected_row = -1;

    private void edit_encoding_inventory() {
        int row = tbl_encoding_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_encoding_inventory to = (to_encoding_inventory) tbl_encoding_inventory_ALM.
                get(tbl_encoding_inventory.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot update finalized Transaction!");
            return;
        }
        int id = to.id;
        String item_code = tf_description.getText();
        String barcode = "";
        String description = tf_item_code.getText();
        String branch = to.branch;
        String branch_id = to.branch_id;
        String location = to.location;
        String location_id = to.location_id;
        double qty = FitIn.toDouble(tf_qty.getText());
        String date_added = DateType.now();
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String sheet_no = tf_sheet_no.getText();
        double cost = FitIn.toDouble(tf_cost.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String user_id = to.user_id;
        String user_screen_name = to.user_screen_name;
        to_encoding_inventory to1 = new to_encoding_inventory(id, item_code, barcode, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, to.status, to.counted_by, to.checked_by, cost, selling_price, user_id, user_screen_name);
        Encoding_inventory.edit_encoding_inventory(to1);
        data_cols();
        clear_encoding_inventory();
        Alert.set(2, "");
        tf_item_code.grabFocus();
    }

    private void clear_encoding_inventory() {
        tf_item_code.setText("");
        tf_description.setText("");
        tf_qty.setText("");
    }

    private void delete_encoding_inventory() {
        int row = tbl_encoding_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_encoding_inventory to = (to_encoding_inventory) tbl_encoding_inventory_ALM.
                get(tbl_encoding_inventory.convertRowIndexToModel(row));
        if (to.status == 1) {
            Alert.set(0, "Cannot delete finalized Transaction!");
            return;
        }
        Encoding_inventory.delete_encoding_inventory(to);
        data_cols();
        clear_encoding_inventory();
        Alert.set(3, "");
        tf_item_code.grabFocus();
    }

    private void select_encoding_inventory() {
        int row = tbl_encoding_inventory.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_encoding_inventory to = (to_encoding_inventory) tbl_encoding_inventory_ALM.get(tbl_encoding_inventory.convertRowIndexToModel(row));
        tf_item_code.setText(to.description);
        tf_description.setText(to.item_code);
        tf_qty.setText(FitIn.fmt_woc(to.qty));
        tf_sheet_no.setText(to.sheet_no);
        tf_cost.setText(FitIn.fmt_wc_0(to.cost));
        tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));

        tf_qty_branch.setText(to.branch);
        tf_search_branch_code.setText(to.branch_id);
        tf_location.setText(to.location);
        tf_location_id.setText(to.location_id);
    }

    private void finalize_encoding() {

        Window p = (Window) this;
        Dlg_confirm_finalize_encoding nd = Dlg_confirm_finalize_encoding.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_finalize_encoding.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, final Dlg_confirm_finalize_encoding.OutputData data) {
                closeDialog.ok();
                jProgressBar1.setString("Loading... Please wait...");
                jProgressBar1.setIndeterminate(true);
                jProgressBar1.setStringPainted(true);
                jButton5.setEnabled(false);
                jButton4.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                final Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        List<to_encoding_inventory> datas = tbl_encoding_inventory_ALM;

                        if (datas.isEmpty()) {
                            Alert.set(0, "");
                            return;
                        }

                        S1_finalize_encoding.edit_encoding_inventory(datas,data.include_pricing);
                        jProgressBar1.setString("Finished");
                        jProgressBar1.setIndeterminate(false);
                        Alert.set(2, "");
                        data_cols();
                        jButton5.setEnabled(true);
                        jButton4.setEnabled(true);
                        jButton2.setEnabled(true);
                        jButton3.setEnabled(true);
                    }
                });
                t2.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

//        Window p = (Window) this;
//        Loader nd = Loader.create(p, true);
//        nd.setTitle("");
//        nd.do_pass();
//
//        nd.setCallback(new Loader.Callback() {
//
//            @Override
//            public void ok(CloseDialog closeDialog, Loader.OutputData data) {
//
//                 t2.start();
//
//                closeDialog.ok();
//            }
//        });
//        nd.setLocationRelativeTo(this);
//        nd.setVisible(true);
    }

    private void rollback_encoding() {

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                jProgressBar1.setString("Loading... Please wait...");
                jProgressBar1.setIndeterminate(true);
                jProgressBar1.setStringPainted(true);
                jButton5.setEnabled(false);
                jButton4.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                final Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<to_encoding_inventory> datas = tbl_encoding_inventory_ALM;
                        if (datas.isEmpty()) {
                            Alert.set(0, "");
                        }

                        S1_finalize_encoding.rollback_encoding(datas);
                        jProgressBar1.setString("Finished");
                        jProgressBar1.setIndeterminate(false);
                        Alert.set(2, "");
                        data_cols();
                        jButton5.setEnabled(true);
                        jButton4.setEnabled(true);
                        jButton2.setEnabled(true);
                        jButton3.setEnabled(true);
                    }
                });
                t2.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

//        Window p = (Window) this;
//        Loader nd = Loader.create(p, true);
//        nd.setTitle("");
//        nd.do_pass();
//
//        nd.setCallback(new Loader.Callback() {
//
//            @Override
//            public void ok(CloseDialog closeDialog, Loader.OutputData data) {
//
//                 t2.start();
//
//                closeDialog.ok();
//            }
//        });
//        nd.setLocationRelativeTo(this);
//        nd.setVisible(true);
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {
        String search = tf_location.getText();
        String branch_id = tf_search_branch_code.getText();

        Object[][] obj = new Object[branch_location_list.size()][1];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch + " : " + to.location;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_qty_branch.getWidth()};
        int width = 0;
        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_qty_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                tf_qty_branch.setText(to.branch);
                tf_search_branch_code.setText(to.branch_id);
                tf_location.setText("" + to.location);
                tf_location_id.setText("" + to.id);

                location_ids = "" + to.id;
            }
        });
    }

}
