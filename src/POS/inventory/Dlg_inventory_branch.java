/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.branch_locations.S1_branch_locations;
import POS.selling_type.S1_selling_type;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
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
 * @author Ronescape
 */
public class Dlg_inventory_branch extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_inventory_branch
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
    private Dlg_inventory_branch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_inventory_branch(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_inventory_branch() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_inventory_branch myRef;

    private void setThisRef(Dlg_inventory_branch myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory_branch> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory_branch create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory_branch create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory_branch dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_branch((java.awt.Frame) parent, false);
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
            Dlg_inventory_branch dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_branch((java.awt.Dialog) parent, false);
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

        Dlg_inventory_branch dialog = Dlg_inventory_branch.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_item_code = new Field.Search();
        jLabel2 = new javax.swing.JLabel();
        tf_description = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        tf_selling_type = new Field.Combo();
        jLabel4 = new javax.swing.JLabel();
        tf_category = new Field.Combo();
        jLabel5 = new javax.swing.JLabel();
        tf_sub_classification = new Field.Combo();
        jLabel6 = new javax.swing.JLabel();
        tf_classification = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        tf_model = new Field.Combo();
        tf_brand = new Field.Combo();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new Field.Input();
        jTextField10 = new Field.Input();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_unit = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        tf_reorder_level = new Field.Input();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_status = new Field.Combo();
        btn_delete = new Button.Warning();
        btn_update = new Button.Info();
        jButton3 = new Button.Primary();
        jButton4 = new Button.Default();
        jLabel20 = new javax.swing.JLabel();
        tf_cost = new Field.Input();
        jLabel21 = new javax.swing.JLabel();
        tf_selling_price = new Field.Input();
        tf_uom_conversion = new Field.Input();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tf_barcode = new Field.Input();
        jLabel36 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jButton13 = new Button.Default();
        jLabel37 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel39 = new javax.swing.JLabel();
        tf_description1 = new Field.Input();
        jLabel40 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jLabel35 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory_barcodes = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Item Code:");

        tf_item_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_item_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_item_codeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Description:");

        tf_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descriptionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Selling Type:");

        tf_selling_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_selling_type.setText("Regular");
        tf_selling_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_selling_typeMouseClicked(evt);
            }
        });
        tf_selling_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_selling_typeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Category:");

        tf_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Sub-Classification:");

        tf_sub_classification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_sub_classification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_sub_classificationMouseClicked(evt);
            }
        });
        tf_sub_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sub_classificationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Classification:");

        tf_classification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_classification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_classificationMouseClicked(evt);
            }
        });
        tf_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_classificationActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Model:");

        tf_model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_model.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_modelMouseClicked(evt);
            }
        });
        tf_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_modelActionPerformed(evt);
            }
        });

        tf_brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_brand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_brandMouseClicked(evt);
            }
        });
        tf_brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_brandActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Color:");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Size:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Unit of Measure:");

        tf_unit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_unit.setText("pc");
        tf_unit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_unitMouseClicked(evt);
            }
        });
        tf_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_unitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Brand:");

        tf_reorder_level.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Reorder Lvl:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Status:");

        tf_status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_status.setText("Active");
        tf_status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_statusMouseClicked(evt);
            }
        });
        tf_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_statusActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.setEnabled(false);
        btn_delete.setFocusable(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.setEnabled(false);
        btn_update.setFocusable(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("New");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Cost:");

        tf_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_costKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Selling Price:");

        tf_selling_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_uom_conversion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_uom_conversion.setText("1");
        tf_uom_conversion.setFocusable(false);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/keyboard53 (1).png"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/keyboard53 (1).png"))); // NOI18N
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Barcode:");

        tf_barcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_barcodeKeyReleased(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Search by:");

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("[F2]-Code");
        jCheckBox7.setFocusable(false);

        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Description");
        jCheckBox8.setFocusable(false);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/cloud-storage-uploading-option (3).png"))); // NOI18N
        jButton13.setText("Upload");
        jButton13.setFocusable(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Allow Negative Inventory:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Yes/No");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Auto-Order:");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Yes/No");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Generic Name:");

        tf_description1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_description1ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Show to Sales:");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Yes/No");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Location:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons4/cogwheels4 (3).png"))); // NOI18N
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_description)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBox6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_barcode)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_selling_type, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(tf_reorder_level, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_status))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_model)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(tf_sub_classification))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_category)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_unit)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_uom_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel32))
                                    .addComponent(tf_classification, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_brand)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(jTextField10)))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_description1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_selling_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_category, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_classification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_uom_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_sub_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_reorder_level, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Locations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_inventory_barcodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_inventory_barcodes);

        jLabel28.setText("No. of rows:");

        lbl_total.setBackground(new java.awt.Color(102, 102, 102));
        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tf_item_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_item_codeActionPerformed
        init_inventory();
    }//GEN-LAST:event_tf_item_codeActionPerformed

    private void tf_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_descriptionActionPerformed

    private void tf_selling_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_selling_typeMouseClicked
        init_selling_type();
    }//GEN-LAST:event_tf_selling_typeMouseClicked

    private void tf_selling_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_selling_typeActionPerformed
        // TODO add your handling code here:
        init_selling_type();
    }//GEN-LAST:event_tf_selling_typeActionPerformed

    private void tf_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_categoryMouseClicked
        init_inventory_category();
    }//GEN-LAST:event_tf_categoryMouseClicked

    private void tf_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_categoryActionPerformed
        init_inventory_category();
    }//GEN-LAST:event_tf_categoryActionPerformed

    private void tf_sub_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_sub_classificationMouseClicked
        init_inventory_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationMouseClicked

    private void tf_sub_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sub_classificationActionPerformed
        init_inventory_sub_classification();
    }//GEN-LAST:event_tf_sub_classificationActionPerformed

    private void tf_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_classificationMouseClicked
        init_inventory_classification();
    }//GEN-LAST:event_tf_classificationMouseClicked

    private void tf_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_classificationActionPerformed
        init_inventory_classification();
    }//GEN-LAST:event_tf_classificationActionPerformed

    private void tf_modelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_modelMouseClicked
        init_inventory_model();
    }//GEN-LAST:event_tf_modelMouseClicked

    private void tf_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_modelActionPerformed
        init_inventory_model();
    }//GEN-LAST:event_tf_modelActionPerformed

    private void tf_brandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_brandMouseClicked
        init_inventory_brand();
    }//GEN-LAST:event_tf_brandMouseClicked

    private void tf_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_brandActionPerformed
        init_inventory_brand();
    }//GEN-LAST:event_tf_brandActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void tf_unitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_unitMouseClicked
        init_default_uom();
    }//GEN-LAST:event_tf_unitMouseClicked

    private void tf_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_unitActionPerformed
        init_default_uom();
    }//GEN-LAST:event_tf_unitActionPerformed

    private void tf_statusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_statusMouseClicked
        init_status();
    }//GEN-LAST:event_tf_statusMouseClicked

    private void tf_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_statusActionPerformed
        // TODO add your handling code here:
        init_status();
    }//GEN-LAST:event_tf_statusActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete_inventory();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        edit_inventory();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_inventory();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear_inventory();
        init_item_code();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_costKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_costKeyReleased
//        add_comma_separator();
    }//GEN-LAST:event_tf_costKeyReleased

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        uom();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
//        assembly();
    }//GEN-LAST:event_jLabel33MouseClicked

    private void tf_barcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_barcodeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_barcodeKeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
//        cloud_upload();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void tf_description1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_description1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_description1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        privileges();
    }//GEN-LAST:event_jLabel35MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_inventory_barcodes;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_brand;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_classification;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_description1;
    private javax.swing.JTextField tf_item_code;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_reorder_level;
    private javax.swing.JTextField tf_selling_price;
    private javax.swing.JTextField tf_selling_type;
    private javax.swing.JTextField tf_status;
    private javax.swing.JTextField tf_sub_classification;
    private javax.swing.JTextField tf_unit;
    private javax.swing.JTextField tf_uom_conversion;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
//
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_password", "password");
//        MyUser.setUser_id("1");

        String environment = System.getProperty("environment", "development");
        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        init_tbl_inventory_barcodes();

        jLabel35.setVisible(false);
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance per Location - (Finalize)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (!privileges.isEmpty()) {
            jLabel35.setVisible(true);
        }
        set_location();
        tf_item_code.grabFocus();
    }

    private void set_location() {
        List<Inventory_location_privileges.to_inventory_location_privileges> datas = Inventory_location_privileges.ret_data(" where user_id='" + MyUser.getUser_id() + "'");

        if (!datas.isEmpty()) {
            Inventory_location_privileges.to_inventory_location_privileges to = (Inventory_location_privileges.to_inventory_location_privileges) datas.get(0);
            Field.Combo loc = (Field.Combo) jTextField2;
            sel_branch = to.branch;
            sel_branch_id = to.branch_id;
            sel_location = to.location;
            sel_location_id = "" + to.location_id;

            loc.setText("" + to.branch + " - " + to.location);
            loc.setId("" + to.location_id);
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

    List<Inventory.to_inventory> inventory_list = new ArrayList();
    Inventory.to_inventory my_item = null;
    int selected_row = -1;

    private void init_inventory() {

        if (sel_location_id.isEmpty()) {
            Alert.set(0, "Select Location");
            jTextField2.grabFocus();
            return;
        }

        String search = tf_item_code.getText();
        String where = " where ";
        Field.Combo loc = (Field.Combo) jTextField2;
        if (jCheckBox6.isSelected()) {
            where = where + " barcode like '" + search + "' and location_id like '" + loc.getId() + "' "
                    + " or barcodes like '" + search + "' and location_id like '" + loc.getId() + "' "
                    + " or description like '%" + search + "%'  and location_id like '" + loc.getId() + "' ";
        }
        if (jCheckBox7.isSelected()) {
            where = where + " barcode like '" + search + "' and location_id like '" + loc.getId() + "' "
                    + " or barcodes like '" + search + "' and location_id like '" + loc.getId() + "' ";
        }
        if (jCheckBox8.isSelected()) {
            where = where + "  description like '%" + search + "%' and location_id like '" + loc.getId() + "' ";
        }

        where = where + " order by description asc ";

//        System.out.println(where);
        inventory_list.clear();
        inventory_list = Inventory.ret_data22(where);

        if (inventory_list.isEmpty()) {
            Alert.set(0, "Item not found!");
            tf_item_code.grabFocus();
            return;
        }
        if (inventory_list.size() == 1) {
            Inventory.to_inventory to = inventory_list.get(0);
            my_item = to;
            selected_row = 0;
            select_item(to);
        } else {
            Object[][] obj = new Object[inventory_list.size()][2];
            int i = 0;
            for (Inventory.to_inventory to : inventory_list) {
                obj[i][0] = " " + to.barcode;
                obj[i][1] = " " + to.description;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {100, 600};
            int width = 0;
            for (int w : tbl_widths_customers) {
                width += w;
            }
            String[] col_names = {"Item Code", "Description"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.
                    setPopup2(tf_item_code, obj, labels, tbl_widths_customers, col_names, width);
            tr.setCallback(new TableRenderer.Callback() {

                @Override
                public void ok(TableRenderer.OutputData data) {
                    Inventory.to_inventory to = inventory_list.get(data.selected_row);
                    my_item = to;
                    selected_row = data.selected_row;
                    select_item(to);

                }
            });
        }

    }

    private void select_item(Inventory.to_inventory to) {

        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brand = (Field.Combo) tf_brand;
        Field.Combo model = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;

        tf_item_code.setText(to.barcode);
        tf_barcode.setText(to.barcodes);
//        my_old_barcode = to.barcodes;
        tf_description.setText(to.description);
        tf_description1.setText(to.generic_name);
        tf_category.setText(to.category);
        cat.setId(to.category_id);
        tf_sub_classification.setText(to.sub_classification);
        tf_classification.setText(to.classification);
        classi.setId(to.classification_id);
        sub_class.setId(to.sub_classification_id);
        tf_brand.setText(to.brand);
        brand.setId(to.brand_id);
        tf_model.setText(to.model);
        model.setId(to.model_id);
        units.setId(to.unit);
        Dlg_inventory_uom.to_uom to_unit = uom.default_uom(to.unit);
        tf_unit.setText(to_unit.uom);
        tf_uom_conversion.setText(FitIn.fmt_wc_0(to_unit.conversion));
        tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
        tf_cost.setText(FitIn.fmt_wc_0(to.cost));
        tf_reorder_level.setText(FitIn.fmt_wc_0(to.reorder_level));
        btn_update.setEnabled(true);
        jLabel33.setEnabled(true);
        String inventory_item_delete = System.getProperty("inventory_item_delete", "false");
        if (inventory_item_delete.equalsIgnoreCase("true")) {
            btn_delete.setEnabled(true);
        }

        if (to.selling_type == 0) {
            tf_selling_type.setText("Regular");
        } else {
            tf_selling_type.setText("Assemble");
        }
        tf_model.setText(to.model);

//        data_cols_inventory_barcodes();
//                data_cols_assembly();
//        data_cols();
        if (to.allow_negative_inventory == 0) {
            jCheckBox1.setSelected(false);
        } else {
            jCheckBox1.setSelected(true);
        }
        if (to.auto_order == 0) {
            jCheckBox2.setSelected(false);
        } else {
            jCheckBox2.setSelected(true);
        }

        if (to.show_to_sales == 0) {
            jCheckBox3.setSelected(false);
        } else {
            jCheckBox3.setSelected(true);
        }

        data_cols_inventory_barcodes();
    }

    List<S1_selling_type.to_selling_type> selling_type_list = new ArrayList();

    private void init_selling_type() {
        String search = tf_selling_type.getText();
        selling_type_list.clear();
        selling_type_list = S1_selling_type.ret_data("");
        Object[][] obj = new Object[selling_type_list.size()][2];
        int i = 0;
        for (S1_selling_type.to_selling_type to : selling_type_list) {
            obj[i][0] = to.id;//TextHighlighter1.highlight2(to.barcode, to.barcode, "");
            obj[i][1] = to.name;//TextHighlighter1.highlight2(to.description, to.description, "");

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, tf_selling_type.getWidth() - 10};
        int width = 0;
        for (int w : tbl_widths_customers) {
            width += w;
        }
        String[] col_names = {"Code", "Type"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_selling_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_selling_type.to_selling_type t = selling_type_list.
                        get(data.selected_row);
                tf_selling_type.setText(t.name);
            }
        });
    }

    List<S1_inventory_categories.to_inventory_category> inventory_category_list = new ArrayList();

    private void init_inventory_category() {
        String search = tf_category.getText();
        inventory_category_list.clear();
        inventory_category_list = S1_inventory_categories.ret_data3(search);
        Object[][] obj = new Object[inventory_category_list.size()][2];
        int i = 0;
        for (S1_inventory_categories.to_inventory_category to : inventory_category_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_category, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_categories.to_inventory_category to = inventory_category_list.
                        get(data.selected_row);
                tf_category.setText(to.name);
                Field.Combo cat = (Field.Combo) tf_category;
                Field.Combo classi = (Field.Combo) tf_classification;
                Field.Combo sub_class = (Field.Combo) tf_sub_classification;
                Field.Combo brands = (Field.Combo) tf_brand;
                Field.Combo models = (Field.Combo) tf_model;
                cat.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_classification.to_inventory_classification> inventory_classification_list = new ArrayList();

    private void init_inventory_classification() {
        Field.Combo cat = (Field.Combo) tf_category;
        final Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        String search = tf_classification.getText();
        String category_code = cat.getId();
        inventory_classification_list.clear();
        String where = " where name like '%" + search + "%'  order by name asc";
        inventory_classification_list = S1_inventory_classification.ret_where(where);
        Object[][] obj = new Object[inventory_classification_list.size()][2];
        int i = 0;
        for (S1_inventory_classification.to_inventory_classification to : inventory_classification_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_classification, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_classification.to_inventory_classification to = inventory_classification_list.
                        get(data.selected_row);
                tf_classification.setText(to.name);
                classi.setId("" + to.id);
            }
        });
    }
    List<S1_inventory_sub_classification.to_inventory_sub_classification> inventory_sub_classification_list = new ArrayList();

    private void init_inventory_sub_classification() {
        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        final Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        String search = tf_sub_classification.getText();
        String classification = classi.getId();
        inventory_sub_classification_list.clear();
        inventory_sub_classification_list = S1_inventory_sub_classification.ret_data4(search, classification);
        Object[][] obj = new Object[inventory_sub_classification_list.size()][2];
        int i = 0;
        for (S1_inventory_sub_classification.to_inventory_sub_classification to : inventory_sub_classification_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 300};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_sub_classification, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_sub_classification.to_inventory_sub_classification to = inventory_sub_classification_list.
                        get(data.selected_row);
                tf_sub_classification.setText(to.name);
                sub_class.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_brand.to_inventory_brand> inventory_brand_list = new ArrayList();

    private void init_inventory_brand() {
        String search = tf_brand.getText();
        inventory_brand_list.clear();
        inventory_brand_list = S1_inventory_brand.ret_data3(search);
        Object[][] obj = new Object[inventory_brand_list.size()][2];
        int i = 0;
        for (S1_inventory_brand.to_inventory_brand to : inventory_brand_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_brand, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_brand.to_inventory_brand to = inventory_brand_list.
                        get(data.selected_row);
                tf_brand.setText(to.name);
                Field.Combo brands = (Field.Combo) tf_brand;
                brands.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_model.to_inventory_model> inventory_model_list = new ArrayList();

    private void init_inventory_model() {
        Field.Combo brands = (Field.Combo) tf_brand;
        final Field.Combo models = (Field.Combo) tf_model;

        String search = tf_model.getText();
        String brand_id = brands.getId();
        inventory_model_list.clear();
        inventory_model_list = S1_inventory_model.ret_data_brand4(search, brand_id);
        Object[][] obj = new Object[inventory_model_list.size()][2];
        int i = 0;
        for (S1_inventory_model.to_inventory_model to : inventory_model_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {20, 200};
        String[] col_names = {"Code", "Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_model, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_model.to_inventory_model to = inventory_model_list.
                        get(data.selected_row);
                tf_model.setText(to.name);
                models.setId("" + to.id);
            }
        });
    }

    List<S1_inventory_uom.to_inventory_uom> uom_list = new ArrayList();

    private void init_default_uom() {
        String search = tf_unit.getText();
        uom_list.clear();
        uom_list = S1_inventory_uom.ret_data(search);
        Object[][] obj = new Object[uom_list.size()][1];
        int i = 0;
        for (S1_inventory_uom.to_inventory_uom to : uom_list) {
            obj[i][0] = to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {350};
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_unit, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_uom.to_inventory_uom to = uom_list.
                        get(data.selected_row);
                tf_unit.setText(to.name);
            }
        });
    }

    private void init_uom() {
        String search = tf_unit.getText();
        uom_list.clear();
        uom_list = S1_inventory_uom.ret_data(search);
        Object[][] obj = new Object[uom_list.size()][1];
        int i = 0;
        for (S1_inventory_uom.to_inventory_uom to : uom_list) {
            obj[i][0] = to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {350};
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_unit, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_uom.to_inventory_uom to = uom_list.
                        get(data.selected_row);
                tf_unit.setText(to.name);
            }
        });
    }

    List<String> status_list = new ArrayList();

    private void init_status() {
        String search = tf_status.getText();
        status_list.clear();
        status_list.add("Active");
        status_list.add("InActive");
        Object[][] obj = new Object[status_list.size()][1];
        int i = 0;
        for (String to : status_list) {
            obj[i][0] = to;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_status.getWidth()};
        String[] col_names = {"Status"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_status, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                String status = status_list.
                        get(data.selected_row);
                tf_status.setText(status);
            }
        });
    }

    private void delete_inventory() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance per Location - (Delete)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        if (selected_row == -1) {
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_delete.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                closeDialog.ok();
                Inventory.to_inventory to1 = inventory_list.get(selected_row);
                List<String> query = Inventory.delete_inventory(to1);
                clear_inventory();
                init_item_code();
                Alert.set(3, "");
//                tbl_inventory_barcodes_ALM.clear();
//                tbl_inventory_barcodes_M.fireTableDataChanged();
                tf_item_code.grabFocus();

//                String cloud_inventory_delete = System.getProperty("cloud_inventory_delete", "true");
//                if (cloud_inventory_delete.equalsIgnoreCase("true")) {
//                    clear_inventory();
//                    init_item_code();
//                    Alert.set(3, "");
//                    tbl_inventory_barcodes_ALM.clear();
//                    tbl_inventory_barcodes_M.fireTableDataChanged();
//                    tf_item_code.grabFocus();
//                    cloud_delete(query, "Delete entry to cloud?");
//                } else {
//
//                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    String my_old_barcode = "";

    private void edit_inventory() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance per Location - (Edit)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        Window p = (Window) this;
        Dlg_inventory_update_confirm nd = Dlg_inventory_update_confirm.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_update_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_update_confirm.OutputData data) {
                closeDialog.ok();
                if (selected_row == -1) {
                    return;
                }
                Field.Combo cat = (Field.Combo) tf_category;
                Field.Combo classi = (Field.Combo) tf_classification;
                Field.Combo sub_class = (Field.Combo) tf_sub_classification;
                Field.Combo brands = (Field.Combo) tf_brand;
                Field.Combo models = (Field.Combo) tf_model;
                Field.Combo units = (Field.Combo) tf_unit;
                Inventory.to_inventory to1 = inventory_list.get(selected_row);
                int id = to1.id;
                String barcode = to1.barcode;
                String description = tf_description.getText();
                String generic_name = tf_description1.getText();
                String category = tf_category.getText();
                String category_id = cat.getId();
                String classification = tf_classification.getText();
                String classification_id = classi.getId();
                String sub_classification = tf_sub_classification.getText();
                String sub_classification_id = sub_class.getId();
                double product_qty = 0;
                double conversion = 1;
                double selling_price = FitIn.toDouble(tf_selling_price.getText());
                String date_added = DateType.now();
                String user_name = "";

                String item_type = tf_selling_type.getText();
                int status = 0;
                if (tf_status.getText().equalsIgnoreCase("Active")) {
                    status = 1;
                }
                String supplier = "";
                int fixed_price = 0;
                double cost = FitIn.toDouble(tf_cost.getText());
                String supplier_id = "";
                int multi_level_pricing = 0;
                int vatable = 0;
                double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
                double markup = 0;
                String barcodes = tf_barcode.getText();

                String brand = tf_brand.getText();
                String brand_id = brands.getId();
                String model = tf_model.getText();
                String model_id = models.getId();
                int selling_type = 0;
                if (!tf_selling_type.getText().equalsIgnoreCase("Regular")) {
                    selling_type = 1;
                }

                String branch = "";
                String branch_code = "";
                String location = "";
                String location_id = "";
                String unit = "";
                if (units.getId() == null || units.getId().isEmpty()) {
                    unit = uom.convert_to_string(tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
                } else {
                    Dlg_inventory_uom.to_uom to2 = new Dlg_inventory_uom.to_uom(0, tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
                    unit = uom.convert_to_string2(units.getId(), to2);
                }
                int is_uploaded = 2;

                int allow_negative_inventory = 0;
                int auto_order = 0;
                if (jCheckBox1.isSelected()) {
                    allow_negative_inventory = 1;
                }
                if (jCheckBox2.isSelected()) {
                    auto_order = 1;
                }
                int show_to_sales = 0;
                if (jCheckBox3.isSelected()) {
                    show_to_sales = 1;
                }
                Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                String where = " where main_barcode='" + barcode + "'  ";
                if (!data.branch_id.equalsIgnoreCase("All")) {
                    where = " where main_barcode='" + barcode + "' and branch_code='" + data.branch_id + "' ";
                }
                Inventory.edit_inventory(to, my_item, where);
                my_item = to;
                Alert.set(2, "");
//                data_cols_inventory_barcodes();
//                data_cols_multi_level_pricing();
//                data_cols();
                tf_item_code.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void add_inventory() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance per Location - (Add)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }

        if (sel_location_id.isEmpty()) {
            Alert.set(0, "Select Location");
            jTextField2.grabFocus();
            return;
        }
        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;
        Field.Combo loc = (Field.Combo) jTextField2;
        int id = -1;
        String barcode = Inventory.increment_id_special(loc.getId());
        String description = tf_description.getText();
        String generic_name = tf_description1.getText();
        String category = tf_category.getText();
        String category_id = cat.getId();
        String classification = tf_classification.getText();
        String classification_id = classi.getId();
        String sub_classification = tf_sub_classification.getText();
        String sub_classification_id = sub_class.getId();

        double product_qty = 0;
        double conversion = 1;
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String date_added = DateType.now();
        String user_name = "";
        String item_type = "";
        int status = 0;
        if (tf_status.getText().equalsIgnoreCase("Active")) {
            status = 1;
        }
        String supplier = "";
        int fixed_price = 0;
        double cost = FitIn.toDouble(tf_cost.getText());
        String supplier_id = "";
        int multi_level_pricing = 0;
        int vatable = 0;
        double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
        double markup = 0;
        String barcodes = tf_barcode.getText();
        String brand = tf_brand.getText();
        String brand_id = brands.getId();
        String model = tf_model.getText();
        String model_id = models.getId();
        int selling_type = 0;
        if (!tf_selling_type.getText().equalsIgnoreCase("Regular")) {
            selling_type = 1;
        }
        String branch = sel_branch;
        String branch_code = sel_branch_id;
        String location = sel_location;
        String location_id = sel_location_id;
        String unit = "";
        if (units.getId() == null || units.getId().isEmpty()) {
            unit = uom.convert_to_string(tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
        } else {
            Dlg_inventory_uom.to_uom to2 = new Dlg_inventory_uom.to_uom(0, tf_unit.getText(), FitIn.toDouble(tf_uom_conversion.getText()), selling_price, 1);
            unit = uom.convert_to_string2(units.getId(), to2);
        }
        int is_uploaded = 0;
        int allow_negative_inventory = 0;
        int auto_order = 0;
        if (jCheckBox1.isSelected()) {
            allow_negative_inventory = 1;
        }
        if (jCheckBox2.isSelected()) {
            auto_order = 1;
        }
        int show_to_sales = 0;
        if (jCheckBox3.isSelected()) {
            show_to_sales = 1;
        }
        final Inventory.to_inventory to = new Inventory.to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                List<String> query = Inventory.add_inventory(to);
                Alert.set(1, "");
                clear_inventory();
                init_item_code();
                tf_item_code.grabFocus();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void clear_inventory() {

        Field.Combo cat = (Field.Combo) tf_category;
        Field.Combo classi = (Field.Combo) tf_classification;
        Field.Combo sub_class = (Field.Combo) tf_sub_classification;
        Field.Combo brands = (Field.Combo) tf_brand;
        Field.Combo models = (Field.Combo) tf_model;
        Field.Combo units = (Field.Combo) tf_unit;
        tf_item_code.setText("");
        tf_description.setText("");
        tf_uom_conversion.setText("1");
        units.setId("");
        tf_selling_price.setText("");
        tf_cost.setText("");
        tf_reorder_level.setText("");
        tf_barcode.setText("");
        tf_item_code.grabFocus();
        disabled();
        selected_row = -1;
    }

    private void disabled() {
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
    }

    private void init_item_code() {
        Field.Combo tf = (Field.Combo) jTextField2;

        tf_item_code.setText(Inventory.increment_id_special(tf.getId()));
    }

    private void uom() {
        final Field.Combo combo = (Field.Combo) tf_unit;
        String uom = tf_unit.getText();
        double conversion = FitIn.toDouble(tf_uom_conversion.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        int is_default = 1;
        Dlg_inventory_uom.to_uom to = new Dlg_inventory_uom.to_uom(0, uom, conversion, selling_price, is_default);
        Window p = (Window) this;
        Dlg_inventory_uom nd = Dlg_inventory_uom.create(p, true);
        nd.do_pass(combo.getId(), to);
        nd.setCallback(new Dlg_inventory_uom.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_uom.OutputData data) {
                closeDialog.ok();
                combo.setId(data.uom);
            }
        });
        Point point = jLabel32.getLocationOnScreen();
        nd.setLocation(point.x - 478, point.y);
        nd.setVisible(true);
    }

    private void settings() {

    }

    String sel_branch = "";
    String sel_branch_id = "";
    String sel_location = "";
    String sel_location_id = "";
    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {

        final Field.Combo lo = (Field.Combo) jTextField2;
        Object[][] obj = new Object[branch_location_list.size()][1];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.branch + " - [ " + to.location + " ]";
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {lo.getWidth()};
        int width = 0;
        String[] col_names = {"Code"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(lo, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {

                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);

                String where = " where user_id='" + MyUser.getUser_id() + "' and location_id='" + to.id + "' ";
//                System.out.println(where);
                List<Inventory_location_privileges.to_inventory_location_privileges> datas = Inventory_location_privileges.ret_data(where);
                if (datas.isEmpty()) {
                    Alert.set(0, "Privilege not found!");
                    jTextField2.grabFocus();
                    return;
                }
                Field.Combo loc = (Field.Combo) jTextField2;
                sel_branch = to.branch;
                sel_branch_id = to.branch_id;
                sel_location = to.location;
                sel_location_id = "" + to.id;

                lo.setText("" + to.branch + " - " + to.location);
                lo.setId("" + to.id);
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Barcodes ">
    private ArrayListModel tbl_inventory_barcodes_ALM;
    private Tblinventory_barcodesModel tbl_inventory_barcodes_M;

    private void init_tbl_inventory_barcodes() {
        tbl_inventory_barcodes_ALM = new ArrayListModel();
        tbl_inventory_barcodes_M = new Tblinventory_barcodesModel(tbl_inventory_barcodes_ALM);
        tbl_inventory_barcodes.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_inventory_barcodes.setModel(tbl_inventory_barcodes_M);
        tbl_inventory_barcodes.
                setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_barcodes.setRowHeight(25);
        int[] tbl_widths_inventory_barcodes = {180, 100, 80, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_barcodes.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.
                    setColumnWidth(tbl_inventory_barcodes, i, tbl_widths_inventory_barcodes[i]);
        }
        Dimension d = tbl_inventory_barcodes.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_inventory_barcodes.getTableHeader().setPreferredSize(d);
        tbl_inventory_barcodes.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_inventory_barcodes.setRowHeight(25);
        tbl_inventory_barcodes.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_inventory_barcodes(List<Inventory_barcodes.to_inventory_barcodes> acc) {
        tbl_inventory_barcodes_ALM.clear();
        tbl_inventory_barcodes_ALM.addAll(acc);
    }

    public static class Tblinventory_barcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Location", "Item Code", "Description", "Qty", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "main_barcode", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code"
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
                    return " " + tt.branch + " : " + tt.location;
                case 1:
                    return " " + tt.main_barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return "   " + FitIn.fmt_woc(tt.product_qty);
                case 4:
                    return tt.category;
                case 5:
                    return tt.category_id;
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
                case 24:
                    return tt.reorder_level;
                case 25:
                    return tt.markup;
                case 26:
                    return tt.main_barcode;
                case 27:
                    return tt.brand;
                case 28:
                    return tt.brand_id;
                case 29:
                    return tt.model;
                case 30:
                    return tt.model_id;
                case 31:
                    return tt.selling_type;
                case 32:
                    return tt.branch;
                default:
                    return tt.branch_code;
            }
        }
    }

    private void data_cols_inventory_barcodes() {

        String search = tf_item_code.getText();

        String where = " where main_barcode like '" + search + "' ";

        List<Inventory_barcodes.to_inventory_barcodes> datas = Inventory_barcodes.ret_where(where);
        loadData_inventory_barcodes(datas);
        double total = 0;
        for (Inventory_barcodes.to_inventory_barcodes to : datas) {
            total += to.product_qty;
        }
        lbl_total.setText(FitIn.fmt_woc(total));

    }

//</editor-fold>
    private void privileges() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Item Maintenance per Location - (Finalize)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        Window p = (Window) this;
        Dlg_inventory_brand_privileges nd = Dlg_inventory_brand_privileges.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_inventory_brand_privileges.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_brand_privileges.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
