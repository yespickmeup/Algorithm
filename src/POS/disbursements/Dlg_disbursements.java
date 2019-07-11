/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.reports.Dlg_report_items;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
import POS.users.S1_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Dlg_confirm_delete;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_disbursements extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_disbursements
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
    private Dlg_disbursements(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_disbursements(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_disbursements() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_disbursements myRef;

    private void setThisRef(Dlg_disbursements myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_disbursements> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_disbursements create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_disbursements create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_disbursements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursements((java.awt.Frame) parent, false);
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
            Dlg_disbursements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursements((java.awt.Dialog) parent, false);
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

        Dlg_disbursements dialog = Dlg_disbursements.create(new javax.swing.JFrame(), true);
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        tf_purpose = new Field.Input();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        tf_category_name = new Field.Combo();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel69 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        tf_amount = new Field.Input();
        jButton35 = new Button.Success();
        jTextField2 = new Field.Combo();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new Field.Combo();
        jButton37 = new Button.Default();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_disbursements = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel67 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel65 = new javax.swing.JLabel();
        tf_customer_name3 = new Field.Combo();
        jButton1 = new Button.Default();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new Field.Combo();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        tf_cashier = new Field.Combo();
        jLabel72 = new javax.swing.JLabel();
        jButton2 = new Button.Info();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("Date:");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_purpose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_purpose.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_purpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_purposeActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("Details:");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("Category:");

        tf_category_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_category_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_category_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_category_nameMouseClicked(evt);
            }
        });
        tf_category_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_category_nameActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Yes/No");
        jCheckBox1.setFocusable(false);

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("Vatable:");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Amount:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jButton35.setText("Save");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Branch:");

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

        jButton37.setText("New");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(tf_category_name)
                                .addComponent(tf_purpose)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tf_amount))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_purpose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_category_name)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Disbursement", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_disbursements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_disbursements.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_disbursements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_disbursementsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_disbursements);

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("Total:");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("0.00");

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("Date ");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setText("To:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("Category:");

        tf_customer_name3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_name3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_customer_name3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_customer_name3MouseClicked(evt);
            }
        });
        tf_customer_name3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_name3ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("All");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Branch:");

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Location:");

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

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cashier:");

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("All");

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

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("From:");

        jButton2.setText("Preview");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_cashier, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                    .addComponent(jTextField4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_customer_name3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox5))
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox4))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox3))))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox6)
                            .addComponent(tf_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_customer_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox2))))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Reports", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Grouped by Category", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Detailed", jPanel8);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane3))
        );

        jTabbedPane1.addTab("Print Preview", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTabbedPane1)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTabbedPane1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        add_disbursements();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tbl_disbursementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_disbursementsMouseClicked
        select_disbursements();
    }//GEN-LAST:event_tbl_disbursementsMouseClicked

    private void tf_category_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_category_nameActionPerformed
        init_type();
    }//GEN-LAST:event_tf_category_nameActionPerformed

    private void tf_category_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_category_nameMouseClicked
        init_type();
    }//GEN-LAST:event_tf_category_nameMouseClicked

    private void tf_customer_name3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_name3ActionPerformed
        init_type2();
    }//GEN-LAST:event_tf_customer_name3ActionPerformed

    private void tf_customer_name3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_customer_name3MouseClicked
        init_type2();
    }//GEN-LAST:event_tf_customer_name3MouseClicked

    private void tf_purposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_purposeActionPerformed
        tf_category_name.grabFocus();
    }//GEN-LAST:event_tf_purposeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data_disbursements();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_branch_locations(jTextField2, jTextField1);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        //        init_branch_locations();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        //        init_branch_locations();
    }//GEN-LAST:event_jTextField1ActionPerformed

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

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void tf_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cashierMouseClicked
        init_cashier();
    }//GEN-LAST:event_tf_cashierMouseClicked

    private void tf_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cashierActionPerformed
        init_cashier();
    }//GEN-LAST:event_tf_cashierActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        init_report();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton37;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tbl_disbursements;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_cashier;
    private javax.swing.JTextField tf_category_name;
    private javax.swing.JTextField tf_customer_name3;
    private javax.swing.JTextField tf_purpose;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_smis_dumaguete_angel_buns");
        init_key();
        set_default_branch();
        init_tbl_disbursements(tbl_disbursements);
        data_disbursements();

        String where = "  order by screen_name asc";
        user_list = MyUser.ret_data2(where);

        Field.Combo user = (Field.Combo) tf_cashier;
        user.setText(MyUser.getUser_screen_name());
        user.setId(MyUser.getUser_id());

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tf_purpose.grabFocus();
            }
        });
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
            }
        });
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

        Field.Combo lo = (Field.Combo) jTextField1;
        Field.Combo br = (Field.Combo) jTextField2;
        lo.setText(to.location);
        lo.setId("" + to.id);
        br.setText(to.branch);
        br.setId("" + to.branch_id);

        Field.Combo lo2 = (Field.Combo) jTextField4;
        Field.Combo br2 = (Field.Combo) jTextField3;
        lo2.setText(to.location);
        lo2.setId("" + to.id);
        br2.setText(to.branch);
        br2.setId("" + to.branch_id);

        String where = " order by branch,location asc  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
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

    private void data_disbursements() {
        String where2 = " where user_id='" + MyUser.getUser_id() + "' order by previledge asc";
        List<S1_user_previleges.to_user_previleges> datas2 = S1_user_previleges.ret_data(where2);
        int view_all = 0;
        for (S1_user_previleges.to_user_previleges to : datas2) {
            if (to.previledge.equalsIgnoreCase("Disbursement (View All)")) {
                view_all = 1;
                break;
            }
        }

        String user_id = MyUser.getUser_id();
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        String where = " where user_screen_name like '%" + "" + "%' ";

        Field.Combo user = (Field.Combo) tf_cashier;
        Field.Combo cat = (Field.Combo) tf_customer_name3;

        Field.Combo br = (Field.Combo) jTextField3;
        Field.Combo lo = (Field.Combo) jTextField4;
        if (!jCheckBox6.isSelected()) {
            where = where + " and user_id='" + user.getId() + "'";
        }
        if (!jCheckBox2.isSelected()) {
            where = where + " and category_id='" + cat.getId() + "'";
        }
        if (!jCheckBox3.isSelected()) {
            where = where + " and Date(disbursement_date) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (!jCheckBox4.isSelected() && !jCheckBox5.isSelected()) {
            where = where + " and location_id='" + lo.getId() + "' ";
        }
        if (!jCheckBox4.isSelected() && jCheckBox5.isSelected()) {
            where = where + " and branch_id='" + br.getId() + "' ";
        }
//        System.out.println(where);
        List<S1_disbursements.to_disbursements> datas = S1_disbursements.ret_data(where);
        loadData_disbursements(datas);

        double amount = 0;
        for (S1_disbursements.to_disbursements to : datas) {
            amount += to.amount;
        }
        jLabel71.setText(FitIn.fmt_wc_0(amount));
    }

    //<editor-fold defaultstate="collapsed" desc=" disbursements "> 
    public static ArrayListModel tbl_disbursements_ALM;
    public static TbldisbursementsModel tbl_disbursements_M;

    public static void init_tbl_disbursements(JTable tbl_disbursements) {
        tbl_disbursements_ALM = new ArrayListModel();
        tbl_disbursements_M = new TbldisbursementsModel(tbl_disbursements_ALM);
        tbl_disbursements.setModel(tbl_disbursements_M);
        tbl_disbursements.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_disbursements.setRowHeight(25);
        int[] tbl_widths_disbursements = {80, 100, 150, 100, 220, 80, 30, 30, 0};
        for (int i = 0, n = tbl_widths_disbursements.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_disbursements, i, tbl_widths_disbursements[i]);
        }
        Dimension d = tbl_disbursements.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_disbursements.getTableHeader().setPreferredSize(d);
        tbl_disbursements.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_disbursements.setRowHeight(25);
        tbl_disbursements.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_disbursements, 5);
        tbl_disbursements.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
        tbl_disbursements.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_disbursements(List<S1_disbursements.to_disbursements> acc) {
        tbl_disbursements_ALM.clear();
        tbl_disbursements_ALM.addAll(acc);
    }

    public static class TbldisbursementsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Purpose", "Category", "User", "Location", "Amount", "", "", ""
        };

        public TbldisbursementsModel(ListModel listmodel) {
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
            S1_disbursements.to_disbursements tt = (S1_disbursements.to_disbursements) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime2(tt.disbursement_date);
                case 1:
                    return " " + tt.purpose;
                case 2:
                    return " " + tt.category_name;
                case 3:
                    return " " + tt.user_screen_name;
                case 4:

                    return " " + tt.branch + " - " + tt.location;
                case 5:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 6:
                    return "/POS/icon_payment/edit (1).png";
                case 7:
                    return "/POS/icon_payment/remove11.png";
                default:
                    return tt.is_vat;
            }
        }
    }
//</editor-fold> 

    private void add_disbursements() {

        int row = tbl_disbursements.getSelectedRow();
        final Field.Combo cat = (Field.Combo) tf_category_name;
        Field.Combo br = (Field.Combo) jTextField2;
        Field.Combo lo = (Field.Combo) jTextField1;
        if (row < 0) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Disbursements - (Add)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            int id = 0;
            String user_id = MyUser.getUser_id();
            String user_screen_name = MyUser.getUser_screen_name();
            String date_added = DateType.now();
            String purpose = tf_purpose.getText();

            String category_id = cat.getId();
            String category_name = tf_category_name.getText();
            double amount = FitIn.toDouble(tf_amount.getText());
            int is_vat = 0;
            if (jCheckBox1.isSelected()) {
                is_vat = 1;
            }
            String disbursement_date = DateType.sf.format(jDateChooser3.getDate());

            String branch = br.getText();
            String branch_id = br.getId();
            String location = lo.getText();
            String location_id = lo.getId();

            final S1_disbursements.to_disbursements to = new S1_disbursements.to_disbursements(id, user_id, user_screen_name, date_added, purpose, category_id, category_name, amount, is_vat, disbursement_date, branch, branch_id, location, location_id);
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Proceed adding this record?");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    S1_disbursements.add_data(to);
                    tf_purpose.setText("");
                    cat.setId("");
                    tf_category_name.setText("");
                    tf_amount.setText("");
                    data_disbursements();
                    new_disbursement();
                    Alert.set(1, "Successfully Added!");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Disbursements - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            S1_disbursements.to_disbursements to = (S1_disbursements.to_disbursements) tbl_disbursements_ALM.get(row);
            int id = to.id;
            String user_id = to.user_id;
            String user_screen_name = to.user_screen_name;
            String date_added = DateType.now();
            String purpose = tf_purpose.getText();
            String category_id = cat.getId();
            String category_name = tf_category_name.getText();
            double amount = FitIn.toDouble(tf_amount.getText());
            int is_vat = 0;
            if (jCheckBox1.isSelected()) {
                is_vat = 1;
            }
            String disbursement_date = DateType.sf.format(jDateChooser3.getDate());
            String branch = br.getText();
            String branch_id = br.getId();
            String location = lo.getText();
            String location_id = lo.getId();
            final S1_disbursements.to_disbursements to1 = new S1_disbursements.to_disbursements(id, user_id, user_screen_name, date_added, purpose, category_id, category_name, amount, is_vat, disbursement_date, branch, branch_id, location, location_id);
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Are you sure you want to update this record?");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    S1_disbursements.update_data(to1);
                    data_disbursements();
                    new_disbursement();
                    Alert.set(2, "Successfully Added!");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }

    }

    private void new_disbursement() {
        Field.Combo cat = (Field.Combo) tf_category_name;
        tf_purpose.setText("");
        cat.setId("");
        tf_category_name.setText("");
        tf_amount.setText("");
        tbl_disbursements.clearSelection();
        tf_purpose.grabFocus();
    }

    private void select_disbursements() {

        int row = tbl_disbursements.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Combo cat = (Field.Combo) tf_category_name;
        S1_disbursements.to_disbursements to = (S1_disbursements.to_disbursements) tbl_disbursements_ALM.get(row);

        int col = tbl_disbursements.getSelectedColumn();
        if (col == 6) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Disbursements - (Edit)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            tf_purpose.setText(to.purpose);
            cat.setId(to.category_id);
            tf_category_name.setText(to.category_name);
            tf_amount.setText(FitIn.fmt_wc_0(to.amount));
            if (to.is_vat == 1) {
                jCheckBox1.setSelected(true);
            } else {
                jCheckBox1.setSelected(false);
            }
            try {
                Date d = DateType.sf.parse(to.disbursement_date);
                jDateChooser3.setDate(d);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_disbursements.class.getName()).log(Level.SEVERE, null, ex);
            }
            Field.Combo br = (Field.Combo) jTextField2;
            Field.Combo lo = (Field.Combo) jTextField1;
            br.setText(to.branch);
            br.setId(to.branch_id);
            lo.setText(to.location);
            lo.setId(to.location_id);
            jTabbedPane1.setSelectedIndex(0);
        }
        if (col == 7) {

            String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Disbursements - (Delete)" + "' limit 1";
            List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(where);
            if (privileges.isEmpty()) {
                Alert.set(0, "Privilege not added!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    delete_disbursements();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }

    private void update_disbursements() {

        int row = tbl_disbursements.getSelectedRow();
        if (row < 0) {
            return;
        }

    }

    private void delete_disbursements() {

        int row = tbl_disbursements.getSelectedRow();
        if (row < 0) {
            return;
        }
        Field.Combo cat = (Field.Combo) tf_category_name;
        S1_disbursements.to_disbursements to = (S1_disbursements.to_disbursements) tbl_disbursements_ALM.get(row);
        S1_disbursements.delete_data(to);
        tf_purpose.setText("");
        cat.setId("");
        tf_category_name.setText("");
        tf_amount.setText("");
        data_disbursements();

    }

    List<S1_disbursement_categories.to_disbursement_categories> disbursement_types = new ArrayList();

    private void init_type() {
        final Field.Combo f = (Field.Combo) tf_category_name;
        String where = " where category_name like '%" + tf_category_name.getText() + "%' order by category_name asc";
        disbursement_types.clear();
        disbursement_types = S1_disbursement_categories.ret_data(where);
        Object[][] obj = new Object[disbursement_types.size()][1];
        int i = 0;
        for (S1_disbursement_categories.to_disbursement_categories to : disbursement_types) {
            obj[i][0] = " " + to.category_name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_category_name.getWidth()};
        String[] col_names = {"Category"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_category_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_disbursement_categories.to_disbursement_categories to = (S1_disbursement_categories.to_disbursement_categories) disbursement_types.get(data.selected_row);
                f.setId("" + to.id);
                tf_category_name.setText(to.category_name.toUpperCase());
                tf_amount.grabFocus();
            }
        });
    }
    List<S1_disbursement_categories.to_disbursement_categories> disbursement_types2 = new ArrayList();

    private void init_type2() {
        final Field.Combo f = (Field.Combo) tf_customer_name3;
        String where = " where category_name like '%" + tf_customer_name3.getText() + "%' order by category_name asc";
        disbursement_types2.clear();
        disbursement_types2 = S1_disbursement_categories.ret_data(where);
        Object[][] obj = new Object[disbursement_types2.size()][1];
        int i = 0;
        for (S1_disbursement_categories.to_disbursement_categories to : disbursement_types2) {
            obj[i][0] = " " + to.category_name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf_customer_name3.getWidth()};
        String[] col_names = {"Category"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_customer_name3, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_disbursement_categories.to_disbursement_categories to = (S1_disbursement_categories.to_disbursement_categories) disbursement_types2.get(data.selected_row);
                f.setId("" + to.id);
                tf_customer_name3.setText(to.category_name.toUpperCase());

            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations(JTextField br1, JTextField lo1) {
        final Field.Combo br = (Field.Combo) br1;
        final Field.Combo lo = (Field.Combo) lo1;

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
        TableRenderer.setPopup(lo, obj, labels, tbl_widths_customers, col_names);
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

    private void init_report() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        jTabbedPane1.setSelectedIndex(2);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                Field.Combo br = (Field.Combo) jTextField2;
                Field.Combo lo = (Field.Combo) jTextField1;
                Field.Combo f = (Field.Combo) tf_cashier;
                String date_from = synsoftech.util.DateType.sf.format(jDateChooser1.getDate());
                String date_to = synsoftech.util.DateType.sf.format(jDateChooser2.getDate());

                String where = " where user_screen_name like '%" + "" + "%' ";

                Field.Combo user = (Field.Combo) tf_cashier;
                Field.Combo cat = (Field.Combo) tf_customer_name3;
                String cashier = "All";

                if (!jCheckBox6.isSelected()) {
                    where = where + " and user_id='" + user.getId() + "'";
                    cashier = tf_cashier.getText();
                }
                if (!jCheckBox2.isSelected()) {
                    where = where + " and category_id='" + cat.getId() + "'";
                }
                if (!jCheckBox3.isSelected()) {
                    where = where + " and Date(disbursement_date) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox4.isSelected() && !jCheckBox5.isSelected()) {
                    where = where + " and location_id='" + lo.getId() + "' ";
                }
                if (!jCheckBox4.isSelected() && jCheckBox5.isSelected()) {
                    where = where + " and branch_id='" + br.getId() + "' ";
                }

                where = where + " order by category_name asc";
//                System.out.println(where);
                List<Srpt_disbursements_category.field> datas = Srpt_disbursements_category.ret_data(where);
                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                String address = System.getProperty("address", "Daro Highway, Dumaguete City");
                String contact_no = System.getProperty("contact_no", "225-1235");
                String date = DateType.slash.format(jDateChooser1.getDate()) + " - " + DateType.slash.format(jDateChooser2.getDate());
                String printed_by = MyUser.getUser_screen_name();
                String branch = jTextField3.getText();
                String location = jTextField4.getText();

                Srpt_disbursements_category rpt = new Srpt_disbursements_category(business_name, address, contact_no, date, printed_by, branch, location, cashier);
                rpt.fields.addAll(datas);
                String jrxml = "rpt_disbursement_category.jrxml";
                report_sales_items(rpt, jrxml);
                InputStream is = Srpt_disbursements_category.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException ex) {
                    Logger.getLogger(Dlg_report_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }

    private void report_sales_items(final Srpt_disbursements_category to, String jrxml_name) {
        jPanel7.removeAll();
        jPanel7.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_expenses(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel7.add(viewer);
            jPanel7.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_expenses(Srpt_disbursements_category to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_disbursements_category.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint = null;

    private void print() {
        try {
            if (jasperPrint != null) {
                JasperPrintManager.printReport(jasperPrint, false);
            }

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
}
