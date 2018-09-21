/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.stock_transfer.Stock_transfer_privileges.to_stock_transfer_privileges;
import POS.users.MyUser;
import POS.users.S1_users;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_stock_transfer_privilege extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_stock_transfer_privilege
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
    private Dlg_stock_transfer_privilege(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_stock_transfer_privilege(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_stock_transfer_privilege() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_stock_transfer_privilege myRef;

    private void setThisRef(Dlg_stock_transfer_privilege myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_stock_transfer_privilege> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_stock_transfer_privilege create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_stock_transfer_privilege create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_stock_transfer_privilege dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_stock_transfer_privilege((java.awt.Frame) parent, false);
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
            Dlg_stock_transfer_privilege dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_stock_transfer_privilege((java.awt.Dialog) parent, false);
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

        Dlg_stock_transfer_privilege dialog = Dlg_stock_transfer_privilege.create(new javax.swing.JFrame(), true);
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
        jLabel6 = new javax.swing.JLabel();
        tf_cashier = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton1 = new Button.Success();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new Field.Combo();
        jTextField2 = new Field.Combo();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        jTextField4 = new Field.Combo();
        jButton2 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stock_transfer_privileges = new javax.swing.JTable();
        jButton3 = new Button.Primary();
        jTextField5 = new Field.Combo();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new Field.Combo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("User:");

        tf_cashier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cashierMouseClicked(evt);
            }
        });
        tf_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cashierActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Privilege:");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Add");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Edit");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Delete");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Finalize");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("From Branch:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Location:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setFocusable(false);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("To Branch:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Location:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setFocusable(false);
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

        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(tf_cashier))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(jTextField4))
                        .addGap(5, 5, 5)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox2)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox4)
                        .addComponent(jCheckBox5)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privileges", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_stock_transfer_privileges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfer_privileges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfer_privilegesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_stock_transfer_privileges);

        jButton3.setText("Add all privileges");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Branch:");

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("All");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Location:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setFocusable(false);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(27, 27, 27)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox6)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
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

    private void tf_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashierMouseClicked
        init_cashier();
    }//GEN-LAST:event_tf_cashierMouseClicked

    private void tf_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashierActionPerformed
        init_cashier();
    }//GEN-LAST:event_tf_cashierActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        //        init_branch_locations();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        //        init_branch_locations();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_branch_locations(jTextField3, jTextField4);
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_branch_locations(jTextField3, jTextField4);
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save_stock_transfer_privilege();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new_stp();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_stock_transfer_privilegesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfer_privilegesMouseClicked
        select_stp();
    }//GEN-LAST:event_tbl_stock_transfer_privilegesMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_all_privileges();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_branch_locations2(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_branch_locations2(jTextField5, jTextField6);
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        ret_privileges();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked

    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tbl_stock_transfer_privileges;
    private javax.swing.JTextField tf_cashier;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

        System.setProperty("pool_db", "db_algorithm");
        init_key();
        set_default_location();
        String where2 = "  order by screen_name asc";
        user_list = MyUser.ret_data2(where2);

        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        init_tbl_stock_transfer_privileges(tbl_stock_transfer_privileges);
        set_user();
    }

    private void set_default_location() {

        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        Field.Combo lo2 = (Field.Combo) jTextField4;
        Field.Combo br2 = (Field.Combo) jTextField3;
        lo2.setText(to.location);
        lo2.setId("" + to.id);
        br2.setText(to.branch);
        br2.setId("" + to.branch_id);

        Field.Combo lo3 = (Field.Combo) jTextField1;
        Field.Combo br3 = (Field.Combo) jTextField2;
        lo3.setText(to.location);
        lo3.setId("" + to.id);
        br3.setText(to.branch);
        br3.setId("" + to.branch_id);

        Field.Combo lo4 = (Field.Combo) jTextField6;
        Field.Combo br4 = (Field.Combo) jTextField5;
        lo4.setText(to.location);
        lo4.setId("" + to.id);
        br4.setText(to.branch);
        br4.setId("" + to.branch_id);

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

    private void set_user() {
        Field.Combo f = (Field.Combo) tf_cashier;
        if (!user_list.isEmpty()) {
            S1_users.to_users to = (S1_users.to_users) user_list.get(0);
            f.setId("" + to.id);
            f.setText(to.screen_name);
            ret_privileges();
        }
    }

    List<S1_users.to_users> user_list = new ArrayList();

    private void init_cashier() {
        Object[][] obj = new Object[user_list.size()][1];
        int i = 0;
        for (S1_users.to_users to : user_list) {

            obj[i][0] = " " + to.screen_name;

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_cashier.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_cashier, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo f = (Field.Combo) tf_cashier;
                S1_users.to_users to = (S1_users.to_users) user_list.get(data.selected_row);
                tf_cashier.setText(to.screen_name);
                f.setId("" + to.id);
                ret_privileges();
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" stock_transfer_privileges "> 
    public static ArrayListModel tbl_stock_transfer_privileges_ALM;
    public static Tblstock_transfer_privilegesModel tbl_stock_transfer_privileges_M;

    public static void init_tbl_stock_transfer_privileges(JTable tbl_stock_transfer_privileges) {
        tbl_stock_transfer_privileges_ALM = new ArrayListModel();
        tbl_stock_transfer_privileges_M = new Tblstock_transfer_privilegesModel(tbl_stock_transfer_privileges_ALM);
        tbl_stock_transfer_privileges.setModel(tbl_stock_transfer_privileges_M);
        tbl_stock_transfer_privileges.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfer_privileges.setRowHeight(25);
        int[] tbl_widths_stock_transfer_privileges = {100, 100, 50, 50, 50, 55, 50, 50, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfer_privileges.length; i < n; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfer_privileges, i, tbl_widths_stock_transfer_privileges[i]);
        }
        Dimension d = tbl_stock_transfer_privileges.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfer_privileges.getTableHeader().setPreferredSize(d);
        tbl_stock_transfer_privileges.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfer_privileges.setRowHeight(25);
        tbl_stock_transfer_privileges.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfer_privileges.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        tbl_stock_transfer_privileges.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
        tbl_stock_transfer_privileges.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
        tbl_stock_transfer_privileges.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_stock_transfer_privileges(List<to_stock_transfer_privileges> acc) {
        tbl_stock_transfer_privileges_ALM.clear();
        tbl_stock_transfer_privileges_ALM.addAll(acc);
    }

    public static class Tblstock_transfer_privilegesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "From", "To", "Add", "Edit", "Delete", "Finalize", "", "", "", "edit_transfer", "delete_transfer", "finalize_transfer"
        };

        public Tblstock_transfer_privilegesModel(ListModel listmodel) {
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
            to_stock_transfer_privileges tt = (to_stock_transfer_privileges) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.from_branch + " : " + tt.from_location;
                case 1:
                    return " " + tt.to_branch + " : " + tt.to_location;
                case 2:
                    if (tt.add_transfer == 1) {
                        return "/POS/icon_inventory/checked.png";
                    } else {
                        return "/POS/icon_payment/remove11.png";
                    }
                case 3:
                    if (tt.edit_transfer == 1) {
                        return "/POS/icon_inventory/checked.png";
                    } else {
                        return "/POS/icon_payment/remove11.png";
                    }
                case 4:
                    if (tt.delete_transfer == 1) {
                        return "/POS/icon_inventory/checked.png";
                    } else {
                        return "/POS/icon_payment/remove11.png";
                    }
                case 5:
                    if (tt.finalize_transfer == 1) {
                        return "/POS/icon_inventory/checked.png";
                    } else {
                        return "/POS/icon_payment/remove11.png";
                    }
                case 6:
                    return "   Edit";
                case 7:
                    return " Delete";
                case 8:
                    return tt.edit_transfer;
                case 9:
                    return tt.delete_transfer;
                default:
                    return tt.finalize_transfer;
            }
        }
    }

//</editor-fold> 
    private void ret_privileges() {
        Field.Combo f = (Field.Combo) tf_cashier;
        Field.Combo lo = (Field.Combo) jTextField6;

        String where = " where user_id='" + f.getId() + "' order by from_branch,from_location asc ";
        if (!jCheckBox6.isSelected()) {
            where = " where user_id='" + f.getId() + "' and from_location_id ='" + lo.getId() + "' order by from_branch,from_location asc ";
        }
//        System.out.println(where);
        List<to_stock_transfer_privileges> datas = Stock_transfer_privileges.ret_data(where);
        loadData_stock_transfer_privileges(datas);
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations(JTextField b, JTextField t) {
        final Field.Combo br = (Field.Combo) b;
        final Field.Combo lo = (Field.Combo) t;
        Object[][] obj = new Object[branch_location_list.size()][2];
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
        TableRenderer.setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText("" + to.location);
                lo.setId("" + to.id);
                br.setText(to.branch);
                br.setId("" + to.branch_id);
            }
        });
    }

    private void init_branch_locations2(JTextField b, JTextField t) {
        final Field.Combo br = (Field.Combo) b;
        final Field.Combo lo = (Field.Combo) t;
        Object[][] obj = new Object[branch_location_list.size()][2];
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
        TableRenderer.setPopup(br, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText("" + to.location);
                lo.setId("" + to.id);
                br.setText(to.branch);
                br.setId("" + to.branch_id);
                ret_privileges();
            }
        });
    }

    private void save_stock_transfer_privilege() {

        int row = tbl_stock_transfer_privileges.getSelectedRow();
        Field.Combo user = (Field.Combo) tf_cashier;
        Field.Combo fbr = (Field.Combo) jTextField2;
        Field.Combo flo = (Field.Combo) jTextField1;

        Field.Combo tbr = (Field.Combo) jTextField3;
        Field.Combo tlo = (Field.Combo) jTextField4;
        if (row < 0) {

            int id = 0;
            String user_id = user.getId();
            String user_screen_name = user.getText();
            String from_branch = fbr.getText();
            String from_branch_id = fbr.getId();
            String from_location = flo.getText();
            String from_location_id = flo.getId();
            String to_branch = tbr.getText();
            String to_branch_id = tbr.getId();
            String to_location = tlo.getText();
            String to_location_id = tlo.getId();

            if (from_location_id.equalsIgnoreCase(to_location_id)) {
                Alert.set(0, "Please choose location!");
                return;
            }
            int add_transfer = 0;
            if (jCheckBox2.isSelected()) {
                add_transfer = 1;
            }
            int edit_transfer = 0;
            if (jCheckBox3.isSelected()) {
                edit_transfer = 1;
            }
            int delete_transfer = 0;
            if (jCheckBox4.isSelected()) {
                delete_transfer = 1;
            }
            int finalize_transfer = 0;
            if (jCheckBox5.isSelected()) { 
                finalize_transfer = 1;
            }
            Stock_transfer_privileges.to_stock_transfer_privileges stp = new to_stock_transfer_privileges(id, user_id, user_screen_name, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, add_transfer, edit_transfer, delete_transfer, finalize_transfer);

            int exists = 0;
            List<Stock_transfer_privileges.to_stock_transfer_privileges> datas = tbl_stock_transfer_privileges_ALM;
            for (Stock_transfer_privileges.to_stock_transfer_privileges data : datas) {
                if (data.from_location_id.equalsIgnoreCase(from_location_id) && data.to_location_id.equalsIgnoreCase(to_location_id)) {
                    System.out.println("from_location_id: " + data.from_location_id + " - from_location_id: " + from_location_id);
                    System.out.println("from_location_id: " + data.to_location_id + " - from_location_id: " + to_location_id);
                    exists = 1;
                }
            }
            if (exists == 0) {
                Stock_transfer_privileges.add_data(stp);
                ret_privileges();
                Alert.set(1, "");
            } else {
                Alert.set(0, "Location already Added!");
            }

        } else {
            Stock_transfer_privileges.to_stock_transfer_privileges to = (Stock_transfer_privileges.to_stock_transfer_privileges) tbl_stock_transfer_privileges_ALM.get(row);

            int id = to.id;
            String user_id = user.getId();
            String user_screen_name = user.getText();
            String from_branch = fbr.getText();
            String from_branch_id = fbr.getId();
            String from_location = flo.getText();
            String from_location_id = flo.getId();
            String to_branch = tbr.getText();
            String to_branch_id = tbr.getId();
            String to_location = tlo.getText();
            String to_location_id = tlo.getId();
            int add_transfer = 0;
            if (jCheckBox2.isSelected()) {
                add_transfer = 1;
            }
            
            int edit_transfer = 0;
            if (jCheckBox3.isSelected()) {
                edit_transfer = 1;
            }
            
            int delete_transfer = 0;
            if (jCheckBox4.isSelected()) {
                delete_transfer = 1;
            }
            int finalize_transfer = 0;
            if (jCheckBox5.isSelected()) {
                finalize_transfer = 1;
            }
            Stock_transfer_privileges.to_stock_transfer_privileges stp = new to_stock_transfer_privileges(id, user_id, user_screen_name, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, add_transfer, edit_transfer, delete_transfer, finalize_transfer);
            Stock_transfer_privileges.update_data(stp);
            ret_privileges();
            Alert.set(2, "");
        }
    }

    private void new_stp() {
        jCheckBox2.setSelected(true);
        jCheckBox3.setSelected(true);
        jCheckBox4.setSelected(true);
        jCheckBox5.setSelected(true);
        tbl_stock_transfer_privileges.clearSelection();
    }

    private void select_stp() {
        int row = tbl_stock_transfer_privileges.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Stock_transfer_privileges.to_stock_transfer_privileges to = (Stock_transfer_privileges.to_stock_transfer_privileges) tbl_stock_transfer_privileges_ALM.get(row);
        Field.Combo user = (Field.Combo) tf_cashier;
        Field.Combo fbr = (Field.Combo) jTextField2;
        Field.Combo flo = (Field.Combo) jTextField1;

        Field.Combo tbr = (Field.Combo) jTextField3;
        Field.Combo tlo = (Field.Combo) jTextField4;

        int col = tbl_stock_transfer_privileges.getSelectedColumn();
        if (col == 6) {
            user.setId(to.user_id);
            user.setText(to.user_screen_name);

            fbr.setId(to.from_branch_id);
            fbr.setText(to.from_branch);
            flo.setId(to.from_location_id);
            flo.setText(to.from_location);

            tbr.setId(to.to_branch_id);
            tbr.setText(to.to_branch);
            tlo.setId(to.to_location_id);
            tlo.setText(to.to_location);
            if (to.add_transfer == 0) {
                jCheckBox2.setSelected(false);
            } else {
                jCheckBox2.setSelected(true);
            }
            if (to.edit_transfer == 0) {
                jCheckBox3.setSelected(false);
            } else {
                jCheckBox3.setSelected(true);
            }
            if (to.delete_transfer == 0) {
                jCheckBox4.setSelected(false);
            } else {
                jCheckBox4.setSelected(true);
            }
            if (to.finalize_transfer == 0) {
                jCheckBox5.setSelected(false);
            } else {
                jCheckBox5.setSelected(true);
            }
        }
        if (col == 7) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Stock_transfer_privileges.delete_data(to);
                    ret_privileges();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    private void add_all_privileges() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Field.Combo user = (Field.Combo) tf_cashier;
                List<Stock_transfer_privileges.to_stock_transfer_privileges> datas = Stock_transfer_privileges.ret_data(" where user_id='" + user.getId() + "' ");

                for (S1_branch_locations.to_branch_locations to : branch_location_list) {
                    
                    for (S1_branch_locations.to_branch_locations to2 : branch_location_list) {

                        int exists = 0;
                        for (Stock_transfer_privileges.to_stock_transfer_privileges data2 : datas) {
                            if (data2.from_location_id.equalsIgnoreCase("" + to.id) && data2.to_location_id.equalsIgnoreCase("" + to2.id)) {
                                exists = 1;
                            }
                        }
                        if (to.id == to2.id) {
                            exists = 1;
                        }
                        if (exists == 0) {
                            int id = 0;
                            String user_id = user.getId();
                            String user_screen_name = user.getText();
                            String from_branch = to.branch;
                            String from_branch_id = to.branch_id;
                            String from_location = to.location;
                            String from_location_id = "" + to.id;
                            String to_branch = to2.branch;
                            String to_branch_id = to2.branch_id;
                            String to_location = to2.location;
                            String to_location_id = "" + to2.id;
                            int add_transfer = 0;
                            int edit_transfer = 0;
                            int delete_transfer = 0;
                            int finalize_transfer = 0;
                            Stock_transfer_privileges.to_stock_transfer_privileges stp = new to_stock_transfer_privileges(id, user_id, user_screen_name, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, add_transfer, edit_transfer, delete_transfer, finalize_transfer);
                            Stock_transfer_privileges.add_data(stp);

                        }

                    }

                }
                ret_privileges();
                Alert.set(1, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
}
