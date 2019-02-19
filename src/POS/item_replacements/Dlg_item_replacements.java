/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.item_replacements;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Dlg_inventory_uom;
import POS.inventory.uom;
import POS.inventory_reports.Dlg_report_inventory_ledger;
import POS.item_replacements.Item_replacements.to_item_replacements;
import POS.my_sales.MySales;
import POS.my_sales.MySales_Items;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
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
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_item_replacements extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_item_replacements
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
    private Dlg_item_replacements(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_item_replacements(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_item_replacements() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_item_replacements myRef;

    private void setThisRef(Dlg_item_replacements myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_item_replacements> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_item_replacements create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_item_replacements create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_item_replacements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_item_replacements((java.awt.Frame) parent, false);
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
            Dlg_item_replacements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_item_replacements((java.awt.Dialog) parent, false);
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

        Dlg_item_replacements dialog = Dlg_item_replacements.create(new javax.swing.JFrame(), true);
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new Button.Primary();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_item_replacements = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox3 = new javax.swing.JCheckBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new Field.Input();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new Field.Input();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new Field.Input();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new Field.Input();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new Field.Input();
        jLabel15 = new javax.swing.JLabel();
        tf_branch1 = new Field.Combo();
        jLabel16 = new javax.swing.JLabel();
        tf_branch = new Field.Combo();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_report_item_replacements = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton2 = new Button.Primary();
        jLabel27 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jTextField7 = new Field.Search();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sales Item/s", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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

        jLabel11.setText("Total no. of item/s:");

        jLabel12.setText("0");

        jButton1.setText("Replace");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item/s to Replace", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
        jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel17.setText("Total no. of item/s:");

        jLabel18.setText("0");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("0.00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Amount:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Replacement Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_item_replacements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_item_replacements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_item_replacementsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_item_replacements);

        jLabel13.setText("Total no. of rows:");

        jLabel14.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(4, 4, 4))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Transaction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search Transaction:");

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

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Transaction No");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Customer Name");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Search Filter:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Date:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("All");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("From:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("To:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Sales No.:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Date:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Customer:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setFocusable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Amount Due:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setFocusable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Added by:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setFocusable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Branch:");

        tf_branch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch1.setFocusable(false);
        tf_branch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch1MouseClicked(evt);
            }
        });
        tf_branch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Location:");

        tf_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch.setFocusable(false);
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jCheckBox3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_branch1)
                                    .addComponent(tf_branch))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_branch1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Replacement", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jLabel21.setText("Total no. of item/s:");

        jLabel22.setText("0");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("0.00");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Amount:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Return Exchange", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_report_item_replacements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_report_item_replacements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_report_item_replacementsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_report_item_replacements);

        jLabel25.setText("Total no. of rows:");

        jLabel26.setText("0.00");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Date:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("All");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("From:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("To:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Search Filter:");

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Transaction No");

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Customer Name");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Search Transaction:");

        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("Sales No");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Over:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("0.00");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Short:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jCheckBox4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel29))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jCheckBox5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 187, Short.MAX_VALUE)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox4)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel35))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jLabel33))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel26)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1039, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Item Ledger", jPanel5);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1039, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Print Preview", jPanel10);

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
        init_sales_transactions();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
//        init_sales_transactions();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        select_sales_item();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        replace_items();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_branch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch1MouseClicked

    }//GEN-LAST:event_tf_branch1MouseClicked

    private void tf_branch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch1ActionPerformed

    }//GEN-LAST:event_tf_branch1ActionPerformed

    private void tf_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branchMouseClicked
        //        init_branch_locations();
    }//GEN-LAST:event_tf_branchMouseClicked

    private void tf_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branchActionPerformed

    }//GEN-LAST:event_tf_branchActionPerformed

    private void tbl_item_replacementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_item_replacementsMouseClicked
        select_item_replacement();

    }//GEN-LAST:event_tbl_item_replacementsMouseClicked

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        ret_report_item_replacements();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ret_report_item_replacements();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_report_item_replacementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_report_item_replacementsMouseClicked
        select_report_item_replacement();
    }//GEN-LAST:event_tbl_report_item_replacementsMouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        select_replacements();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2AncestorAdded

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable tbl_item_replacements;
    private javax.swing.JTable tbl_report_item_replacements;
    private javax.swing.JTextField tf_branch;
    private javax.swing.JTextField tf_branch1;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("return_exchange_days", "2000");
        init_key();
        init_tbl_sale_items(jTable1);
        init_tbl_item_replacements(tbl_item_replacements);
        init_tbl_for_replacement(jTable2);
        init_tbl_replacement(jTable3);
        init_tbl_report_item_replacements(tbl_report_item_replacements);
        ret_report_item_replacements();
        set_default_branch();
        item_ledger();

    }

    private void item_ledger() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                jPanel5.setLayout(new BorderLayout());
                Dlg_report_inventory_ledger dlg = new Dlg_report_inventory_ledger();
                jPanel5.add(dlg.getSurface());
            }
        });
    }

    private void set_default_branch() {

        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();

        Field.Combo combo = (Field.Combo) tf_branch;
        Field.Combo br = (Field.Combo) tf_branch1;
        combo.setText(to.location);
        combo.setId("" + to.id);
        br.setText(to.branch);
        br.setId("" + to.branch_id);

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

    List<MySales.sales> my_sales = new ArrayList();

    private void init_sales_transactions() {

        my_sales.clear();

        String where = " where session_no like '%" + "" + "%' ";
        if (jCheckBox1.isSelected()) {
            where = where + " and sales_no like '%" + jTextField1.getText() + "%' ";
        }
        if (jCheckBox2.isSelected()) {
            where = where + " and customer_name like '%" + jTextField1.getText() + "%' ";
        }
        if (!jCheckBox3.isSelected()) {
            String date_from = DateType.sf.format(jDateChooser1.getDate());
            String date_to = DateType.sf.format(jDateChooser2.getDate());

            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        where = where + " order by id asc ";
        System.out.println(where);
        my_sales = MySales.ret_data(where);
        Object[][] obj = new Object[my_sales.size()][4];
        int i = 0;
        for (MySales.sales to : my_sales) {
            obj[i][0] = " " + to.sales_no;
            obj[i][1] = " " + to.customer_name;
            obj[i][2] = " " + DateType.convert_slash_datetime3(to.date_added);
            obj[i][3] = " " + FitIn.fmt_wc_0(to.amount_due);
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {130, 80, 120, 80};
        int width = 0;
        String[] col_names = {"Sales No", "Date", "Customer Name", "Amount"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {

                MySales.sales to = my_sales.get(data.selected_row);
                try {

                    Date d = DateType.datetime.parse(to.date_added);
                    int return_exchange_days = FitIn.toInt(System.getProperty("return_exchange_days", ""));
                    int count = DateUtils1.count_days(d, new Date());
                    if (count > return_exchange_days) {
                        Alert.set(0, "Cannot proceed, " + count + " day/s already passed!");
                        return;
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_item_replacements.class.getName()).log(Level.SEVERE, null, ex);
                }

                jTextField2.setText(to.sales_no);
                jTextField3.setText(DateType.convert_slash_datetime3(to.date_added));
                jTextField6.setText(to.user_screen_name);
                jTextField4.setText(to.customer_name);
                jTextField5.setText(FitIn.fmt_wc_0(to.amount_due));

                ret_sales_items();
                ret_item_replacements();

                tbl_for_replacement_ALM.clear();
                tbl_replacement_ALM.clear();
                jLabel18.setText("0");
                jLabel22.setText("0");
                jLabel19.setText("0.00");
                jLabel23.setText("0.00");
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" sale_items "> 
    public static ArrayListModel tbl_sale_items_ALM;
    public static Tblsale_itemsModel tbl_sale_items_M;

    public static void init_tbl_sale_items(JTable tbl_sale_items) {
        tbl_sale_items_ALM = new ArrayListModel();
        tbl_sale_items_M = new Tblsale_itemsModel(tbl_sale_items_ALM);
        tbl_sale_items.setModel(tbl_sale_items_M);
        tbl_sale_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sale_items.setRowHeight(25);
        int[] tbl_widths_sale_items = {40, 70, 100, 50, 80, 60, 60, 60, 80, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 7);
        TableWidthUtilities.setColumnRightRenderer(tbl_sale_items, 8);
    }

    public static void loadData_sale_items(List<MySales_Items.items> acc) {
        tbl_sale_items_ALM.clear();
        tbl_sale_items_ALM.addAll(acc);
    }

    public static class Tblsale_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Unit", "Price", "Discount", "Addtl", "Wtax", "Amount", "", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_id", "user_screen_name", "status", "is_vatable", "selling_type", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "branch", "branch_code", "location", "location_id", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "brand", "brand_id", "model", "model_id", "addtl_amount", "wtax"
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
            if (col == 9) {
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
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 4:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.addtl_amount) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.wtax) + " ";
                case 8:
                    double amount = (tt.product_qty * tt.selling_price) - (tt.discount_amount) + (tt.addtl_amount + tt.wtax);
                    return FitIn.fmt_wc_0(amount) + " ";
                case 9:
                    return tt.selected;
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

    private void ret_sales_items() {
        String where = " where sales_no like '" + jTextField2.getText() + "' ";
        List<MySales_Items.items> items = MySales_Items.ret_data2(where);
        loadData_sale_items(items);
        jLabel12.setText("" + items.size());
    }

    private void select_sales_item() {
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = jTable1.getSelectedColumn();
        if (col == 9) {
            MySales_Items.items item = (MySales_Items.items) tbl_sale_items_ALM.get(row);
            if (item.selected) {
                item.setSelected(false);
            } else {
                item.setSelected(true);
            }
            tbl_sale_items_M.fireTableDataChanged();
        }

    }

    private void replace_items() {
//        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Return Exchange - (Add)" + "' limit 1";
//        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
//        if (privileges.isEmpty()) {
//            Alert.set(0, "Privilege not added!");
//            return;
//        }
        final List<MySales_Items.items> selected = new ArrayList();
        final List<MySales_Items.items> others = new ArrayList();
        List<MySales_Items.items> items = tbl_sale_items_ALM;
        for (MySales_Items.items item : items) {
            if (item.selected) {
                selected.add(item);
            }
        }
        if (selected.isEmpty()) {
            Alert.set(0, "Please select item/s");
            return;
        }

        List<to_item_replacements> replacements = tbl_item_replacements_ALM;
        int size = replacements.size() - 1;
        int is_others = 0;
        if (size > -1) {

            to_item_replacements rep = (to_item_replacements) tbl_item_replacements_ALM.get(size);
            double total = (rep.replacement_amount - rep.discount) - rep.amount_due;
            String where = " where item_replacement_no='" + rep.item_replacement_no + "' and is_replacement=1 ";
//        System.out.println(where);
            List<Item_replacement_details.to_item_replacement_details> datas = Item_replacement_details.ret_data(where);
            for (Item_replacement_details.to_item_replacement_details data : datas) {
                if (data.description.equalsIgnoreCase("Others")) {
                    is_others = 1;
                    //<editor-fold defaultstate="collapsed" desc=" Others ">
                    int id = data.id;
                    String sales_no = data.sales_no;
                    String item_code = data.item_code;
                    String barcode = data.barcode;
                    String description = data.description;
                    String generic_name = data.generic_name;
                    String item_type = data.item_type;
                    String supplier_name = "";
                    String supplier_id = "";
                    String serial_no = data.serial_no;
                    double product_qty = total;
                    String unit = data.unit;
                    double conversion = data.conversion;
                    double selling_price = 1;
                    String date_added = data.date_added;
                    String user_id = data.user_id;
                    String user_screen_name = data.user_screen_name;
                    int status = data.status;
                    int is_vatable = data.is_vatable;
                    int selling_type = data.selling_type;
                    String discount_name = data.discount_name;
                    double discount_rate = 0;
                    double discount_amount = data.discount_amount;
                    String discount_customer_name = data.customer_name;
                    String discount_customer_id = data.customer_id;
                    String branch = data.branch;
                    String branch_code = data.branch_id;
                    String location = data.location;
                    String location_id = data.location_id;
                    String category = data.category;
                    String category_id = data.category_id;
                    String classification = data.classification;
                    String classification_id = data.classification_id;
                    String sub_classification = data.sub_classification;
                    String sub_classification_id = data.sub_classification_id;
                    String brand = data.brand;
                    String brand_id = data.brand_id;
                    String model = data.model;
                    String model_id = data.model_id;
                    boolean selected1 = true;
                    double addtl_amount = 0;
                    double wtax = 0;
                    MySales_Items.items other = new MySales_Items.items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, selected1, addtl_amount, wtax);
                    others.add(other);
                    //</editor-fold>
                    break;
                }
            }
        }
//        System.out.println("is_others:" + is_others);
        Window p = (Window) this;
        Dlg_item_replacements_select nd = Dlg_item_replacements_select.create(p, true);
        nd.setTitle("");
//        if (is_others == 1) {
//            nd.do_pass(others);
//        } else {
//           
//        }
        nd.do_pass(selected);
        nd.setCallback(new Dlg_item_replacements_select.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_item_replacements_select.OutputData data) {
                closeDialog.ok();
                Field.Combo br = (Field.Combo) tf_branch1;
                Field.Combo lo = (Field.Combo) tf_branch;
                int id = 0;
                String item_replacement_no = Item_replacements.increment_id(lo.getId());
                String sales_no = jTextField2.getText();
                String customer_name = jTextField4.getText();
                String customer_id = "";
                String date_added = DateType.now();
                String user_screen_name = MyUser.getUser_screen_name();
                String user_id = MyUser.getUser_id();
                String reason = data.reason;
                double amount_due = data.amount_due;
                double replacement_amount = data.replacement_amount;
                double discount = data.discount;
                int status = 0;
                String branch = br.getText();
                String branch_id = br.getId();
                String location = lo.getText();
                String location_id = lo.getId();

                to_item_replacements replacement = new to_item_replacements(id, item_replacement_no, sales_no, customer_name, customer_id, date_added, user_screen_name, user_id, reason, amount_due, replacement_amount, discount, status, branch, branch_id, location, location_id);
                Item_replacements.add_data(replacement, selected, data.replacements);
                Alert.set(1, "");
                ret_item_replacements();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" item_replacements "> 
    public static ArrayListModel tbl_item_replacements_ALM;
    public static Tblitem_replacementsModel tbl_item_replacements_M;

    public static void init_tbl_item_replacements(JTable tbl_item_replacements) {
        tbl_item_replacements_ALM = new ArrayListModel();
        tbl_item_replacements_M = new Tblitem_replacementsModel(tbl_item_replacements_ALM);
        tbl_item_replacements.setModel(tbl_item_replacements_M);
        tbl_item_replacements.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_item_replacements.setRowHeight(25);
        int[] tbl_widths_item_replacements = {100, 120, 150, 80, 70, 70, 50, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_item_replacements.length; i < n; i++) {
            if (i == 2 || i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_item_replacements, i, tbl_widths_item_replacements[i]);
        }
        Dimension d = tbl_item_replacements.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_item_replacements.getTableHeader().setPreferredSize(d);
        tbl_item_replacements.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_item_replacements.setRowHeight(25);
        tbl_item_replacements.setFont(new java.awt.Font("Arial", 0, 12));

        TableWidthUtilities.setColumnRightRenderer(tbl_item_replacements, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_item_replacements, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_item_replacements, 5);
        tbl_item_replacements.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer());
        tbl_item_replacements.getColumnModel().getColumn(8).setCellRenderer(new ImageRenderer());

    }

    public static void loadData_item_replacements(List<to_item_replacements> acc) {
        tbl_item_replacements_ALM.clear();
        tbl_item_replacements_ALM.addAll(acc);
    }

    public static class Tblitem_replacementsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Date", "Sales No", "Amount", "Replacement", "Disc", "Status", "", "", "amount_due", "replacement_amount", "discount", "status", "branch", "branch_id", "location", "location_id"
        };

        public Tblitem_replacementsModel(ListModel listmodel) {
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
            to_item_replacements tt = (to_item_replacements) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.item_replacement_no;
                case 1:
                    return " " + DateType.convert_slash_datetime3(tt.date_added);
                case 2:
                    return " " + tt.sales_no;
                case 3:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.replacement_amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.discount) + " ";
                case 6:
                    double total = (tt.amount_due - tt.discount) - (tt.replacement_amount);
                    if (total < 0) {
                        return " Over";
                    } else if (total == 0) {
                        return " Equal";
                    } else {
                        return " Short";
                    }
                case 7:
                    if (tt.status == 0) {
                        return "/POS/icon_inventory/question.png";
                    }
                    if (tt.status == 1) {
                        return "/POS/icon_inventory/checked.png";
                    }
                case 8:
                    return "/POS/icon_payment/remove11.png";
                case 9:
                    return tt.amount_due;
                case 10:
                    return tt.replacement_amount;
                case 11:
                    return tt.discount;
                case 12:
                    return tt.status;
                case 13:
                    return tt.branch;
                case 14:
                    return tt.branch_id;
                case 15:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_item_replacements() {
        String sales_no = jTextField2.getText();
        String where = " where sales_no='" + sales_no + "' ";
        List<to_item_replacements> datas = Item_replacements.ret_data(where);
        loadData_item_replacements(datas);
        jLabel14.setText("" + datas.size());
    }

    private void select_item_replacement() {
        final int row = tbl_item_replacements.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_item_replacements.getSelectedColumn();
        final to_item_replacements to = (to_item_replacements) tbl_item_replacements_ALM.get(row);
        if (col == 8) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Return Exchange - (Delete)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 1) {
                Alert.set(0, "Transaction already finalized!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {

                    closeDialog.ok();
                    Item_replacements.delete_data(to);
                    Alert.set(0, "");
                    ret_item_replacements();
                    tbl_for_replacement_ALM.clear();
                    tbl_replacement_ALM.clear();
                    jLabel18.setText("0");
                    jLabel22.setText("0");
                    jLabel19.setText("0.00");
                    jLabel23.setText("0.00");

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else if (col == 7) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Return Exchange - (Finalize)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 1) {
                Alert.set(0, "Transaction already finalized!");
                return;
            }

//            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like 'Return/Exchange - (Finalize)' ";
//            List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
//            if (datas.isEmpty()) {
//                Alert.set(0, "Previlege not added!");
//                return;
//            }
            ret_item_replacement_details_for_replacement();
            ret_item_replacement_details_replacement();

            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Finalize Transaction?");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    List<Item_replacement_details.to_item_replacement_details> selected = tbl_for_replacement_ALM;
                    List<Item_replacement_details.to_item_replacement_details> replacements = tbl_replacement_ALM;

                    Item_replacements.finalize_transaction(to, selected, replacements);
                    Alert.set(0, "Transaction Finalized!");
                    ret_item_replacements();
                    tbl_for_replacement_ALM.clear();
                    tbl_replacement_ALM.clear();
                    jLabel18.setText("0");
                    jLabel22.setText("0");
                    jLabel19.setText("0.00");
                    jLabel23.setText("0.00");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else if (col == 5) {
            String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Return Exchange - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            if (to.status == 1) {
                Alert.set(0, "Transaction already finalized!");
                return;
            }
            Window p = (Window) this;
            Dlg_item_replacement_edit_discount nd = Dlg_item_replacement_edit_discount.create(p, true);
            nd.setTitle("");
            nd.do_pass(to.discount);
            nd.setCallback(new Dlg_item_replacement_edit_discount.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_item_replacement_edit_discount.OutputData data) {
                    closeDialog.ok();
                    Item_replacements.update_discount(to, data.discount);
                    ret_item_replacements();
                    Alert.set(2, "");
                    tbl_item_replacements.setRowSelectionInterval(row, row);
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else {
            ret_item_replacement_details_for_replacement();
            ret_item_replacement_details_replacement();
        }

    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" for replacements ">
    public static ArrayListModel tbl_for_replacement_ALM;
    public static Tblfor_replacementModel tbl_for_replacement_M;

    public static void init_tbl_for_replacement(JTable tbl_for_replacement) {
        tbl_for_replacement_ALM = new ArrayListModel();
        tbl_for_replacement_M = new Tblfor_replacementModel(tbl_for_replacement_ALM);
        tbl_for_replacement.setModel(tbl_for_replacement_M);
        tbl_for_replacement.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_for_replacement.setRowHeight(25);
        int[] tbl_widths_for_replacement = {40, 70, 100, 50, 80, 0, 0, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_for_replacement.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_for_replacement, i, tbl_widths_for_replacement[i]);
        }
        Dimension d = tbl_for_replacement.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_for_replacement.getTableHeader().setPreferredSize(d);
        tbl_for_replacement.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_for_replacement.setRowHeight(25);
        tbl_for_replacement.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_for_replacement, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_for_replacement, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_for_replacement, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_for_replacement, 7);
        TableWidthUtilities.setColumnRightRenderer(tbl_for_replacement, 8);
    }

    public static void loadData_for_replacement(List<Item_replacement_details.to_item_replacement_details> acc) {
        tbl_for_replacement_ALM.clear();
        tbl_for_replacement_ALM.addAll(acc);
    }

    public static class Tblfor_replacementModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Unit", "Price", "Discount", "Addtl", "Wtax", "Amount", "", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_id", "user_screen_name", "status", "is_vatable", "selling_type", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "branch", "branch_code", "location", "location_id", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "brand", "brand_id", "model", "model_id", "addtl_amount", "wtax"
        };

        public Tblfor_replacementModel(ListModel listmodel) {
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
            if (col == 119) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Item_replacement_details.to_item_replacement_details tt = (Item_replacement_details.to_item_replacement_details) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.item_code;
                case 2:
                    return " " + tt.description;
                case 3:
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 4:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 8:
                    double amount = (tt.product_qty * tt.selling_price) - (tt.discount_amount) + tt.addtl_amount;
                    return FitIn.fmt_wc_0(amount) + " ";
                case 9:
                    return tt.product_qty;
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
                    return tt.discount_name;
                case 22:
                    return tt.discount_amount;
                case 23:
                    return tt.discount_customer_name;
                case 24:
                    return tt.discount_customer_id;
                case 25:
                    return tt.branch;
                case 26:
                    return tt.discount_name;
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
                    return tt.model_id;
                default:
                    return tt.model_id;
            }
        }
    }

    private void ret_item_replacement_details_for_replacement() {
        int row = tbl_item_replacements.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_item_replacements to = (to_item_replacements) tbl_item_replacements_ALM.get(row);
        String where = " where item_replacement_no='" + to.item_replacement_no + "' and is_replacement=0 ";
//        System.out.println(where);
        List<Item_replacement_details.to_item_replacement_details> datas = Item_replacement_details.ret_data(where);
        loadData_for_replacement(datas);
        double amount = 0;
        for (Item_replacement_details.to_item_replacement_details item : datas) {
            amount += (item.product_qty * item.selling_price) + item.addtl_amount - item.discount_amount;
        }
        jLabel19.setText(FitIn.fmt_wc_0(amount));
        jLabel18.setText("" + datas.size());
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="  replacements ">
    public static ArrayListModel tbl_replacement_ALM;
    public static TblreplacementModel tbl_replacement_M;

    public static void init_tbl_replacement(JTable tbl_replacement) {
        tbl_replacement_ALM = new ArrayListModel();
        tbl_replacement_M = new TblreplacementModel(tbl_replacement_ALM);
        tbl_replacement.setModel(tbl_replacement_M);
        tbl_replacement.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_replacement.setRowHeight(25);
        int[] tbl_widths_replacement = {40, 70, 100, 50, 80, 0, 0, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_replacement.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_replacement, i, tbl_widths_replacement[i]);
        }
        Dimension d = tbl_replacement.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_replacement.getTableHeader().setPreferredSize(d);
        tbl_replacement.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_replacement.setRowHeight(25);
        tbl_replacement.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_replacement, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_replacement, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_replacement, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_replacement, 7);
        TableWidthUtilities.setColumnRightRenderer(tbl_replacement, 8);
    }

    public static void loadData_replacement(List<Item_replacement_details.to_item_replacement_details> acc) {
        tbl_replacement_ALM.clear();
        tbl_replacement_ALM.addAll(acc);
    }

    public static class TblreplacementModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Unit", "Price", "Discount", "Addtl", "Wtax", "Amount", "", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_id", "user_screen_name", "status", "is_vatable", "selling_type", "discount_name", "discount_rate", "discount_amount", "discount_customer_name", "discount_customer_id", "branch", "branch_code", "location", "location_id", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "brand", "brand_id", "model", "model_id", "addtl_amount", "wtax"
        };

        public TblreplacementModel(ListModel listmodel) {
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
            if (col == 119) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Item_replacement_details.to_item_replacement_details tt = (Item_replacement_details.to_item_replacement_details) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.item_code;
                case 2:
                    return " " + tt.description;
                case 3:
                    String unit = "";
                    Dlg_inventory_uom.to_uom uoms = uom.default_uom(tt.unit);
                    if (uoms != null) {
                        unit = uoms.uom;
                    }
                    return " " + unit;
                case 4:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 8:
                    double amount = (tt.product_qty * tt.selling_price) - (tt.discount_amount) + tt.addtl_amount;
                    return FitIn.fmt_wc_0(amount) + " ";
                case 9:
                    return tt.product_qty;
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
                    return tt.discount_name;
                case 22:
                    return tt.discount_amount;
                case 23:
                    return tt.discount_customer_name;
                case 24:
                    return tt.discount_customer_id;
                case 25:
                    return tt.branch;
                case 26:
                    return tt.discount_name;
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
                    return tt.model_id;
                default:
                    return tt.model_id;
            }
        }
    }

    private void ret_item_replacement_details_replacement() {
        int row = tbl_item_replacements.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_item_replacements to = (to_item_replacements) tbl_item_replacements_ALM.get(row);
        String where = " where item_replacement_no='" + to.item_replacement_no + "' and is_replacement=1 ";
        List<Item_replacement_details.to_item_replacement_details> datas = Item_replacement_details.ret_data(where);
        loadData_replacement(datas);
        double amount = 0;
        for (Item_replacement_details.to_item_replacement_details item : datas) {
            amount += (item.product_qty * item.selling_price) + item.addtl_amount - item.discount_amount;
        }
        jLabel23.setText(FitIn.fmt_wc_0(amount));
        jLabel22.setText("" + datas.size());
    }

    private void select_replacements() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Return Exchange - (Edit)" + "' limit 1";
        List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = jTable3.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Item_replacement_details.to_item_replacement_details to = (Item_replacement_details.to_item_replacement_details) tbl_replacement_ALM.get(row);
        if (to.status == 1) {
            Alert.set(0, "Transaction already finalized!");
            return;
        }
        Window p = (Window) this;
        Dlg_item_replacement_edit_serial nd = Dlg_item_replacement_edit_serial.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.serial_no);
        nd.setCallback(new Dlg_item_replacement_edit_serial.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_item_replacement_edit_serial.OutputData data) {
                closeDialog.ok();
                Item_replacement_details.update_serial(to, data.serial);
                ret_item_replacement_details_replacement();
                Alert.set(2, "");

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" item_replacements "> 
    public static ArrayListModel tbl_report_item_replacements_ALM;
    public static Tblreport_item_replacementsModel tbl_report_item_replacements_M;

    public static void init_tbl_report_item_replacements(JTable tbl_report_item_replacements) {
        tbl_report_item_replacements_ALM = new ArrayListModel();
        tbl_report_item_replacements_M = new Tblreport_item_replacementsModel(tbl_report_item_replacements_ALM);
        tbl_report_item_replacements.setModel(tbl_report_item_replacements_M);
        tbl_report_item_replacements.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_report_item_replacements.setRowHeight(25);
        int[] tbl_widths_report_item_replacements = {100, 150, 150, 150, 100, 100, 100, 70, 80, 30, 30, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_report_item_replacements.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_report_item_replacements, i, tbl_widths_report_item_replacements[i]);
        }
        Dimension d = tbl_report_item_replacements.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_report_item_replacements.getTableHeader().setPreferredSize(d);
        tbl_report_item_replacements.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_report_item_replacements.setRowHeight(25);
        tbl_report_item_replacements.setFont(new java.awt.Font("Arial", 0, 12));

        TableWidthUtilities.setColumnRightRenderer(tbl_report_item_replacements, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_report_item_replacements, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_report_item_replacements, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_report_item_replacements, 8);
        tbl_report_item_replacements.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer());
        tbl_report_item_replacements.getColumnModel().getColumn(10).setCellRenderer(new ImageRenderer());

    }

    public static void loadData_report_item_replacements(List<to_item_replacements> acc) {
        tbl_report_item_replacements_ALM.clear();
        tbl_report_item_replacements_ALM.addAll(acc);
    }

    public static class Tblreport_item_replacementsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Customer Name", "Date", "Sales No", "Amount Due", "Replacement", "Discount", "Status", "Amount", "", "", "discount", "status", "branch", "branch_id", "location", "location_id"
        };

        public Tblreport_item_replacementsModel(ListModel listmodel) {
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
            to_item_replacements tt = (to_item_replacements) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.item_replacement_no;
                case 1:
                    return " " + tt.customer_name;
                case 2:
                    return " " + DateType.convert_slash_datetime3(tt.date_added);
                case 3:
                    return " " + tt.sales_no;
                case 4:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.replacement_amount) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.discount) + " ";
                case 7:

                    double total = (tt.replacement_amount - tt.discount) - tt.amount_due;
                    if (total < 0) {
                        return " Over";
                    } else if (total == 0) {
                        return " Equal";
                    } else {
                        return " Short";
                    }
                case 8:
                    double total2 = (tt.replacement_amount - tt.discount) - tt.amount_due;
                    return FitIn.fmt_wc_0(total2) + " ";
                case 9:
                    if (tt.status == 0) {
                        return "/POS/icon_inventory/question.png";
                    }
                    if (tt.status == 1) {
                        return "/POS/icon_inventory/checked.png";
                    }
                case 10:
                    return "/POS/img_menu2/magnifying-glass.png";
                case 11:
                    return tt.discount;
                case 12:
                    return tt.status;
                case 13:
                    return tt.branch;
                case 14:
                    return tt.branch_id;
                case 15:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }

    private void ret_report_item_replacements() {
        String date_from = DateType.sf.format(jDateChooser3.getDate());
        String date_to = DateType.sf.format(jDateChooser4.getDate());

        String where = " where reason like '%%' ";
        if (!jCheckBox4.isSelected()) {
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (jCheckBox5.isSelected()) {
            where = where + " and item_replacement_no like '%" + jTextField7.getText() + "%' ";
        }
        if (jCheckBox6.isSelected()) {
            where = where + " and customer_name like '%" + jTextField7.getText() + "%' ";
        }
        if (jCheckBox5.isSelected()) {
            where = where + " and sales_no like '%" + jTextField7.getText() + "%' ";
        }
        where = where + " order by id desc ";
        List<to_item_replacements> datas = Item_replacements.ret_data(where);
        loadData_report_item_replacements(datas);

        double amount_due = 0;
        double replacement = 0;
        double discount = 0;
        double na_short = 0;
        double over = 0;
        for (to_item_replacements to : datas) {
            double total = to.replacement_amount + to.discount;
            if (total < to.amount_due) {
                na_short += total - to.amount_due;
            }
            if (total > to.amount_due) {
                over += total - to.amount_due;
            }
        }

        jLabel35.setText(FitIn.fmt_wc_0(na_short));
        jLabel33.setText(FitIn.fmt_wc_0(over));

        jLabel26.setText("" + datas.size());
    }

    private void select_report_item_replacement() {
        int row = tbl_report_item_replacements.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_report_item_replacements.getSelectedColumn();
        if (col == 9) {
            to_item_replacements to2 = (to_item_replacements) tbl_report_item_replacements_ALM.get(row);

            List< MySales.sales> my_sales2 = MySales.ret_data(" where sales_no ='" + to2.sales_no + "' ");

            MySales.sales to = my_sales2.get(0);
            jTextField2.setText(to.sales_no);
            jTextField3.setText(DateType.convert_slash_datetime3(to.date_added));
            jTextField6.setText(to.user_screen_name);
            jTextField4.setText(to.customer_name);
            jTextField5.setText(FitIn.fmt_wc_0(to.amount_due));
            ret_sales_items();
            ret_item_replacements();
            List<to_item_replacements> replacements = tbl_item_replacements_ALM;
            int i = 0;
            for (to_item_replacements r : replacements) {
                if (r.item_replacement_no.equalsIgnoreCase(to2.item_replacement_no)) {
                    break;
                }
                i++;
            }
            tbl_item_replacements.setRowSelectionInterval(i, i);
            ret_item_replacement_details_for_replacement();
            ret_item_replacement_details_replacement();

            jTabbedPane1.setSelectedIndex(0);
        }
        if (col == 10) {
            to_item_replacements to = (to_item_replacements) tbl_report_item_replacements_ALM.get(row);
            String business_name = System.getProperty("business_name", "Algorithm Computer Services");
            String address = System.getProperty("address", "Dumaguete");
            String contact_no = System.getProperty("contact_no", "2342342");
            int irn = to.item_replacement_no.indexOf("|");
            String item_replacement_no = to.item_replacement_no.substring(irn + 1, to.item_replacement_no.length());
            int sn = to.sales_no.indexOf("|");
            String sales_no = to.sales_no.substring(sn + 1, to.sales_no.length());
            String customer_name = to.customer_name;
            String customer_id = to.customer_id;
            String date_added = DateType.convert_slash_datetime(to.date_added);
            String user_screen_name = to.user_screen_name;
            String reason = to.reason;
            double amount_due = to.amount_due;
            double replacement_amount = to.replacement_amount;
            double discount = to.discount;
            String branch = to.branch;
            String location = to.location;
            double total = (to.replacement_amount - to.discount) - to.amount_due;
            List<Item_replacement_details.to_item_replacement_details> datas = Item_replacement_details.ret_data(" where item_replacement_no='" + to.item_replacement_no + "' ");
            List<Srpt_return_exchange.field> fields = new ArrayList();
            for (Item_replacement_details.to_item_replacement_details item : datas) {
                String item_code = item.item_code;
                String barcode = item.barcode;
                String description = item.description;
                String serial_no = item.serial_no;
                serial_no = serial_no.replaceAll("\n", ", ");
                double product_qty = item.product_qty;

                String unit = "";
                Dlg_inventory_uom.to_uom uoms = uom.default_uom(item.unit);
                if (uoms != null) {
                    unit = uoms.uom;
                }

                unit = unit.replaceAll("#", "/");
                double conversion = item.conversion;
                double selling_price = item.selling_price;
                double discount_amount = item.discount_amount;
                double amount = (product_qty * selling_price) - discount_amount;
                String replacement_type = " For Replacement";
                if (item.is_replacement == 1) {
                    replacement_type = "Replacement";
                }
                Srpt_return_exchange.field field = new Srpt_return_exchange.field(item_code, barcode, description, serial_no, product_qty, unit, conversion, selling_price, discount_amount, amount, replacement_type);
                fields.add(field);
            }

            Srpt_return_exchange rpt = new Srpt_return_exchange(business_name, address, contact_no, item_replacement_no, sales_no, customer_name, customer_id, date_added, user_screen_name, reason, amount_due, replacement_amount, discount, branch, location, total);
            rpt.fields.addAll(fields);
            String jrxml = "rpt_return_exchange.jrxml";
            report_return_exchange(rpt, jrxml);

            jTabbedPane1.setSelectedIndex(3);
        }
    }

    private void report_return_exchange(final Srpt_return_exchange to, String jrxml_name) {
        jPanel10.removeAll();
        jPanel10.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_return_exchange(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel10.add(viewer);
            jPanel10.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_return_exchange(Srpt_return_exchange to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_return_exchange(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_return_exchange(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_return_exchange.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

}
