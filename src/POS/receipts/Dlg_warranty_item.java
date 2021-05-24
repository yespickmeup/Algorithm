/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.inventory.Dlg_inventory_uom;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.uom;
import POS.suppliers.Suppliers;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
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
 * @author User
 */
public class Dlg_warranty_item extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_warranty_item
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

        public final String slip_no;
        public final List<Warranty_items.to_warranty_items> items;
        public final String remarks;
        public final String supplier;
        public final String supplier_id;

        public OutputData(String slip_no, List<Warranty_items.to_warranty_items> items, String remarks, String supplier, String supplier_id) {
            this.slip_no = slip_no;
            this.items = items;
            this.remarks = remarks;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_warranty_item(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_warranty_item(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_warranty_item() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_warranty_item myRef;

    private void setThisRef(Dlg_warranty_item myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_warranty_item> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_warranty_item create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_warranty_item create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_warranty_item dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_warranty_item((java.awt.Frame) parent, false);
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
            Dlg_warranty_item dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_warranty_item((java.awt.Dialog) parent, false);
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

        Dlg_warranty_item dialog = Dlg_warranty_item.create(new javax.swing.JFrame(), true);
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
        jLabel30 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        tf_search = new Field.Input();
        jLabel13 = new javax.swing.JLabel();
        tf_item_code = new Field.Input();
        tf_barcodes = new Field.Input();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_description = new Field.Input();
        jLabel16 = new javax.swing.JLabel();
        tf_remarks3 = new Field.Input();
        jLabel43 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField4 = new Field.Combo();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jButton5 = new Button.Default();
        jButton4 = new Button.Primary();
        jLabel17 = new javax.swing.JLabel();
        tf_remarks4 = new Field.Input();
        jLabel18 = new javax.swing.JLabel();
        tf_remarks5 = new Field.Input();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_warranty_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new Button.Default();
        jButton7 = new Button.Success();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Filter by:");

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("[F1]-All");
        jCheckBox6.setFocusable(false);

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("[F2]-Item Code");
        jCheckBox7.setFocusable(false);

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("[F3]-Barcode");
        jCheckBox8.setFocusable(false);

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("[F4]-Description");
        jCheckBox9.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Search:");

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Item Code:");

        tf_item_code.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_item_code.setFocusable(false);
        tf_item_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_item_codeActionPerformed(evt);
            }
        });

        tf_barcodes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_barcodes.setFocusable(false);
        tf_barcodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_barcodesActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Barcode:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Description:");

        tf_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_description.setFocusable(false);
        tf_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descriptionActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Quantity:");

        tf_remarks3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_remarks3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks3ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Warranty Date:");

        jDateChooser7.setDate(new Date());
        jDateChooser7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Serial No:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Supplier:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Remarks:");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Type:");

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("In Warranty");
        jCheckBox10.setFocusable(false);

        jCheckBox11.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("Out of Warranty");
        jCheckBox11.setFocusable(false);

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Add Item");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Slip No.:");

        tf_remarks4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_remarks4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks4ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Quantity on Hand:");

        tf_remarks5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_remarks5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarks5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_barcodes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_search)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_remarks3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(4, 4, 4)
                                        .addComponent(tf_remarks5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(242, 242, 242)
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_description)
                                    .addComponent(jTextField4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_remarks4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox10)
                                .addGap(8, 8, 8)
                                .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_remarks4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_item_code, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_barcodes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_remarks3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox10))
                            .addComponent(jCheckBox11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
        tbl_warranty_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_warranty_itemsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_warranty_items);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap())
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased

    }//GEN-LAST:event_tf_searchKeyReleased

    private void tf_item_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_item_codeActionPerformed

    }//GEN-LAST:event_tf_item_codeActionPerformed

    private void tf_barcodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_barcodesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_barcodesActionPerformed

    private void tf_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_descriptionActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        init_suppliers();
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_suppliers();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void tf_remarks3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        add_item();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear_fields();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_remarks4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        confirm_action();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tbl_warranty_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_warranty_itemsMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_warranty_itemsMouseClicked

    private void tf_remarks5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarks5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_remarks5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tbl_warranty_items;
    private javax.swing.JTextField tf_barcodes;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_item_code;
    private javax.swing.JTextField tf_remarks3;
    private javax.swing.JTextField tf_remarks4;
    private javax.swing.JTextField tf_remarks5;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_password", "password");
//        System.setProperty("pool_host", "192.168.0.51");

        init_key();
        init_tbl_warranty_items(tbl_warranty_items);
    }
    int location_id = 0;

    public void do_pass(int branch_location) {
        location_id = branch_location;
    }

    Warranties.to_warranties warranty = null;

    public void do_pass2(Warranties.to_warranties warr, int branch_location) {
        if(warr.status==1){
            tf_search.setEnabled(false);
            jButton4.setEnabled(false);
        }
        location_id = branch_location;
        tf_remarks4.setEnabled(false);
        warranty = warr;
        tf_remarks4.setText(warr.slip_no);
        Field.Combo sup = (Field.Combo) jTextField4;
        sup.setText(warr.supplier);
        sup.setId(warr.supplier_id);

        jButton7.setVisible(false);
        jButton6.setText("Close");
        ret_items();

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

    List<Inventory.to_inventory> inventory_barcoders_list = new ArrayList();
    int selected_row = 0;

    private void init_inventory_barcodes() {

        tf_search.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = tf_search.getText();

                String where = " where ";
                if (jCheckBox6.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location_id + "'  and location not like '' "
                            + " or barcode like '" + search + "' and location_id='" + location_id + "' and location not like ''  "
                            + " or description like '%" + search + "%' and location_id='" + location_id + "' and location not like '' ";
                }
                if (jCheckBox7.isSelected()) {
                    where = where + "  barcode like '" + search + "' and location_id='" + location_id + "' and location not like ''  "
                            + "  ";
                }
                if (jCheckBox8.isSelected()) {
                    where = where + " "
                            + "  barcode like '" + search + "' and location_id='" + location_id + "' and location not like '' ";
                }
                if (jCheckBox9.isSelected()) {
                    where = where + "  description like '%" + search + "%' and location_id='" + location_id + "' and location not like '' ";
                }
                where = where + " order by description asc ";
//                System.out.println(where);
                inventory_barcoders_list.clear();
                inventory_barcoders_list = Inventory.ret_data6(where);

                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item not found!");
                    tf_search.setEnabled(true);
                    tf_search.grabFocus();
                    return;
                }
                if (inventory_barcoders_list.size() == 1) {
                    selected_row = 0;
                    Inventory.to_inventory to = (Inventory.to_inventory) inventory_barcoders_list.get(0);
                    List<Inventory_barcodes.to_inventory_barcodes> barcodes = Inventory_barcodes.ret_where(" where main_barcode='" + to.barcode + "' and location_id='" + location_id + "' limit 1 ");

                    if (!barcodes.isEmpty()) {
                        Inventory_barcodes.to_inventory_barcodes barcode = (Inventory_barcodes.to_inventory_barcodes) barcodes.get(0);
                        tf_remarks5.setText("" + barcode.product_qty);
                    }
                    tf_item_code.setText(to.barcode);
                    tf_barcodes.setText(to.barcodes);
                    tf_description.setText(to.description);

                    tf_search.setEnabled(true);
                    tf_remarks3.grabFocus();
                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][5];
                    int i = 0;
                    for (Inventory.to_inventory to : inventory_barcoders_list) {

                        obj[i][0] = " " + to.barcode;
                        obj[i][1] = " " + to.description;
                        String unit = "";
                        Dlg_inventory_uom.to_uom uoms = uom.default_uom(to.unit);
                        if (uoms != null) {
                            unit = uoms.uom;
                        }

                        unit = unit.replaceAll("#", "/");
                        obj[i][2] = " " + unit;
                        obj[i][3] = " " + FitIn.fmt_wc_0(to.selling_price);
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {120, w, 30, 50};
                    String[] col_names = {"ItemCode", "Description", "Unit", "Price"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);

                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            selected_row = data.selected_row;
                            Inventory.to_inventory to = (Inventory.to_inventory) inventory_barcoders_list.get(selected_row);
                            List<Inventory_barcodes.to_inventory_barcodes> barcodes = Inventory_barcodes.ret_where(" where main_barcode='" + to.barcode + "' and location_id='" + location_id + "' limit 1 ");

                            if (!barcodes.isEmpty()) {
                                Inventory_barcodes.to_inventory_barcodes barcode = (Inventory_barcodes.to_inventory_barcodes) barcodes.get(0);
                                tf_remarks5.setText("" + barcode.product_qty);
                            }
                            tf_item_code.setText(to.barcode);
                            tf_barcodes.setText(to.barcodes);
                            tf_description.setText(to.description);
                            tf_search.setEnabled(true);
                            tf_remarks3.grabFocus();
                        }
                    });
                }
                tf_search.setEnabled(true);
            }
        });
        t.start();

    }

    List<Suppliers.to_suppliers> supplier_list = new ArrayList();

    private void init_suppliers() {
        String search = jTextField4.getText();
        supplier_list.clear();
        supplier_list = Suppliers.ret_data(search);
        Object[][] obj = new Object[supplier_list.size()][2];
        int i = 0;
        for (Suppliers.to_suppliers to : supplier_list) {
            obj[i][0] = " " + to.customer_no;
            obj[i][1] = " " + to.customer_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 350};
        String[] col_names = {"ID", "NAME"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField4, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Suppliers.to_suppliers to = supplier_list.
                        get(data.selected_row);
                Field.Combo supp = (Field.Combo) jTextField4;

                supp.setText(to.customer_name);
                supp.setId(to.customer_no);

            }
        });
    }

    private void confirm() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                ok1();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" warranty_items "> 
    public static ArrayListModel tbl_warranty_items_ALM;
    public static Tblwarranty_itemsModel tbl_warranty_items_M;

    public static void init_tbl_warranty_items(JTable tbl_warranty_items) {
        tbl_warranty_items_ALM = new ArrayListModel();
        tbl_warranty_items_M = new Tblwarranty_itemsModel(tbl_warranty_items_ALM);
        tbl_warranty_items.setModel(tbl_warranty_items_M);
        tbl_warranty_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_warranty_items.setRowHeight(25);
        int[] tbl_widths_warranty_items = {0, 60, 120, 100, 80, 50, 0, 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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

    public static void loadData_warranty_items(List<Warranty_items.to_warranty_items> acc) {
        tbl_warranty_items_ALM.clear();
        tbl_warranty_items_ALM.addAll(acc);
    }

    public static class Tblwarranty_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Qty", "Item Code", "Description", "Warranty", "Type", "Status", "", "", "cost", "selling_price", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "warranty_date", "serial_no", "main_barcode", "brand", "brand_id", "model", "model_id", "status", "created_at", "created_by", "branch", "branch_id", "location", "location_id"
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
                    return " " + POS.util.DateType.convert_slash_datetime2(tt.warranty_date);
                case 5:
                    return " " + tt.trans_type;
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
                    return tt.cost;
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
                    return tt.sub_class;
                case 16:
                    return tt.sub_class_id;
                case 17:
                    return tt.conversion;
                case 18:
                    return tt.unit;
                case 19:
                    return tt.warranty_date;
                case 20:
                    return tt.serial_no;
                case 21:
                    return tt.main_barcode;
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
                    return tt.created_at;
                case 28:
                    return tt.created_by;
                case 29:
                    return tt.branch;
                case 30:
                    return tt.branch_id;
                case 31:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_items() {
        String where = " where transaction_no='" + warranty.transaction_no + "' ";

        List<Warranty_items.to_warranty_items> items = Warranty_items.ret_data(where);
        loadData_warranty_items(items);
        jLabel2.setText("" + items.size());
    }

    private void add_item() {
        String item_code = tf_item_code.getText();
        if (item_code == null || item_code.isEmpty()) {
            Alert.set(0, "Please select an item!");
            tf_search.grabFocus();
            return;
        }

        Warranty_items.to_warranty_items item = null;
        if (!jButton4.getText().equalsIgnoreCase("Add Item")) {
            int row2 = tbl_warranty_items.getSelectedRow();
            if (row2 < 0) {
                return;
            }

            Warranty_items.to_warranty_items to2 = (Warranty_items.to_warranty_items) tbl_warranty_items_ALM.get(row2);

            int id = to2.id;
            String transaction_no = to2.transaction_no;

            String remarks = jTextArea2.getText();
            String trans_type = "In";
            if (jCheckBox11.isSelected()) {
                trans_type = "Out";
            }
            Field.Combo supp = (Field.Combo) jTextField4;

            String supplier_id = supp.getId();
            String supplier = supp.getText();
            if (supplier_id == null || supplier_id.isEmpty()) {
                Alert.set(0, "Please select a supplier!");
                jTextField4.grabFocus();
                return;
            }
            String barcode = to2.barcode;
            String description = to2.description;
            double qty = FitIn.toDouble(tf_remarks3.getText());
            if (qty <= 0) {
                Alert.set(0, "Input quantity");
                tf_remarks3.grabFocus();
                return;
            }
            double cost = to2.cost;
            double selling_price = to2.selling_price;
            String category = to2.category;
            String category_id = to2.category_id;
            String classification = to2.classification;
            String classification_id = to2.classification_id;
            String sub_class = to2.sub_class;
            String sub_class_id = to2.sub_class_id;
            double conversion = to2.conversion;
            String unit = to2.unit;
            String warranty_date = DateType.sf.format(jDateChooser7.getDate());
            String serial_no = jTextArea1.getText();

            String main_barcode = to2.main_barcode;
            String brand = to2.brand;
            String brand_id = to2.brand_id;
            String model = to2.model;
            String model_id = to2.model_id;
            int status = to2.status;
            String created_at = to2.created_at;
            String created_by = to2.created_by;
            String branch = to2.branch;
            String branch_id = to2.branch_id;
            String location = to2.location;
            String location_ids = to2.location_id;
            String slip_no = to2.slip_no;

            item = new Warranty_items.to_warranty_items(id, transaction_no, remarks, trans_type, supplier, supplier_id, barcode, description, qty, cost, selling_price, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, warranty_date, serial_no, main_barcode, brand, brand_id, model, model_id, status, created_at, created_by, branch, branch_id, location, location_ids, slip_no);

        } else {
            Inventory.to_inventory to = (Inventory.to_inventory) inventory_barcoders_list.get(selected_row);
            int id = 0;
            String transaction_no = "";
            if (warranty != null) {
                transaction_no = warranty.transaction_no;
            }
            String remarks = jTextArea2.getText();
            String trans_type = "In";
            if (jCheckBox11.isSelected()) {
                trans_type = "Out";
            }
            Field.Combo supp = (Field.Combo) jTextField4;

            String supplier_id = supp.getId();
            String supplier = supp.getText();
            if (supplier_id == null || supplier_id.isEmpty()) {
                Alert.set(0, "Please select a supplier!");
                jTextField4.grabFocus();
                return;
            }
            String barcode = to.barcodes;
            String description = to.description;
            double qty = FitIn.toDouble(tf_remarks3.getText());
            if (qty <= 0) {
                Alert.set(0, "Input quantity");
                tf_remarks3.grabFocus();
                return;
            }
            double cost = to.cost;
            double selling_price = to.selling_price;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_class = to.sub_classification;
            String sub_class_id = to.sub_classification_id;
            double conversion = to.conversion;
            String unit = to.unit;
            String warranty_date = DateType.sf.format(jDateChooser7.getDate());
            String serial_no = jTextArea1.getText();

            String main_barcode = item_code;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            int status = 0;
            String created_at = DateType.now();
            String created_by = MyUser.getUser_id();
            String branch = to.branch;
            String branch_id = to.branch_code;
            String location = to.location;
            String location_ids = to.location_id;
            String slip_no = tf_remarks4.getText();

            item = new Warranty_items.to_warranty_items(id, transaction_no, remarks, trans_type, supplier, supplier_id, barcode, description, qty, cost, selling_price, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, warranty_date, serial_no, main_barcode, brand, brand_id, model, model_id, status, created_at, created_by, branch, branch_id, location, location_ids, slip_no);

        }

        if (jButton4.getText().equalsIgnoreCase("Add Item")) {
            if (warranty == null) {
                tbl_warranty_items_ALM.add(item);
                jLabel2.setText("" + tbl_warranty_items_ALM.size());
            } else {
                Warranty_items.add_data(item);
                ret_items();
            }
            clear_fields();
            Alert.set(1, "");
        } else {
            int row = tbl_warranty_items.getSelectedRow();
            if (row < 0) {
                return;
            }
            int col = tbl_warranty_items.getSelectedColumn();
            Warranty_items.to_warranty_items old_item = (Warranty_items.to_warranty_items) tbl_warranty_items_ALM.get(row);

            if (warranty == null) {
                old_item.setQty(item.qty);
                old_item.setRemarks(item.remarks);
                old_item.setSupplier(item.supplier);
                old_item.setSupplier_id(item.supplier_id);
                old_item.setTrans_type(item.trans_type);
                old_item.setWarranty_date(item.warranty_date);
                tbl_warranty_items_M.fireTableDataChanged();
            } else {

                Warranty_items.to_warranty_items item2 = new Warranty_items.to_warranty_items(old_item.id, item.transaction_no, item.remarks, item.trans_type, item.supplier, item.supplier_id, item.barcode, item.description, item.qty, item.cost, item.selling_price, item.category, item.category_id, item.classification, item.classification_id, item.sub_class, item.sub_class_id, item.conversion, item.unit, item.warranty_date, item.serial_no, item.main_barcode, item.brand, item.brand_id, item.model, item.model_id, item.status, item.created_at, item.created_by, item.branch, item.branch_id, item.location, item.location_id, item.slip_no);
                Warranty_items.update_data2(item2);
                ret_items();
            }
            clear_fields();
            Alert.set(1, "");
        }

    }

    private void clear_fields() {

        Field.Input code = (Field.Input) tf_item_code;

        code.setText("");
        code.setId("");

        tf_description.setText("");
        tf_remarks3.setText("");
        jButton4.setText("Add Item");
        jTextArea1.setText("");
        jTextArea2.setText("");
        tf_remarks5.setText("0");
        tf_search.setFocusable(true);
        if (!tbl_warranty_items_ALM.isEmpty()) {
            tbl_warranty_items.clearSelection();
        }
        tf_search.grabFocus();

    }

    private void confirm_action() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                ok1();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ok1() {
        String slip_no = tf_remarks4.getText();
        if (slip_no.isEmpty()) {
            Alert.set(0, "Input slip no!");
            tf_remarks4.grabFocus();
            return;
        }
        List<Warranties.to_warranties> wa = Warranties.ret_data(" where slip_no like '" + slip_no + "' limit 1");
        if (!wa.isEmpty()) {
            Alert.set(0, "Input slip number already exists!");
            tf_remarks4.grabFocus();
            return;
        }
        List<Warranty_items.to_warranty_items> items = tbl_warranty_items_ALM;
        if (items.isEmpty()) {
            Alert.set(0, "No items added!");
            tf_search.grabFocus();
            return;
        }

        String remarks = "";
        Field.Combo supp = (Field.Combo) jTextField4;

        String supplier = supp.getText();
        String supplier_id = supp.getId();
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(slip_no, items, remarks, supplier, supplier_id));
        }
    }

    private void select_item() {
        int row = tbl_warranty_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_warranty_items.getSelectedColumn();
        final Warranty_items.to_warranty_items item = (Warranty_items.to_warranty_items) tbl_warranty_items_ALM.get(row);

        if (col == 7) {
            tf_item_code.setText(item.main_barcode);
            tf_barcodes.setText(item.barcode);
            tf_description.setText(item.description);
            tf_remarks3.setText("" + item.qty);
            try {
                Date d = DateType.sf.parse(item.warranty_date);
                jDateChooser7.setDate(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_warranty_item.class.getName()).log(Level.SEVERE, null, ex);
            }
            Field.Combo sup = (Field.Combo) jTextField4;
            sup.setText(item.supplier);
            sup.setId(item.supplier_id);
            jTextArea1.setText(item.serial_no);
            jTextArea2.setText(item.remarks);
            if (item.trans_type.equalsIgnoreCase("In")) {
                jCheckBox10.setSelected(true);
            } else {
                jCheckBox11.setSelected(true);
            }
            tf_search.setFocusable(false);
            jButton4.setText("Update");
        }
        if (col == 8) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
//            nd.do_pass(services);
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    if (warranty == null) {
                        tbl_warranty_items_ALM.remove(selected_row);

                        Alert.set(3, "");
                        jLabel2.setText("" + tbl_warranty_items_ALM.size());
                    } else {
                        Warranty_items.delete_data(item);
                        ret_items();
                        clear_fields();
                        Alert.set(3, "");
                    }
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
}
