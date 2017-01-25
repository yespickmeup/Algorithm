/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory_reports;

import POS.branch_locations.S1_branch_locations;
import POS.branch_locations.S4_branch_locations;
import POS.inventory.Inventory;
import POS.inventory.Inventory_barcodes;
import POS.inventory.S2_inventory_barcodes;
import POS.reports.Dlg_report_items;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.TableRenderer;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_report_inventory_ledger extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_report_inventory_ledger
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
    private Dlg_report_inventory_ledger(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_report_inventory_ledger(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_report_inventory_ledger() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_report_inventory_ledger myRef;

    private void setThisRef(Dlg_report_inventory_ledger myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_inventory_ledger> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_inventory_ledger create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_inventory_ledger create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_inventory_ledger dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_inventory_ledger((java.awt.Frame) parent, false);
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
            Dlg_report_inventory_ledger dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_inventory_ledger((java.awt.Dialog) parent, false);
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

        Dlg_report_inventory_ledger dialog = Dlg_report_inventory_ledger.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_branch_location = new Field.Combo();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        tf_search = new Field.Search();
        jButton1 = new Button.Search();
        pnl_report = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new Button.Default();
        jButton3 = new Button.Default();
        jButton4 = new Button.Default();
        jButton5 = new Button.Default();
        jButton6 = new Button.Default();
        jButton7 = new Button.Default();
        jButton8 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Year:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Choose Location:");

        tf_branch_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_branch_location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_branch_locationMouseClicked(evt);
            }
        });
        tf_branch_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_branch_locationActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");
        jCheckBox1.setEnabled(false);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");
        jCheckBox2.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Month:");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("All");

        jMonthChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Search Filter:");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Item Code:");

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Description");

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Barcode");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Search:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_searchMouseClicked(evt);
            }
        });
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons3/search19.png"))); // NOI18N
        jButton1.setToolTipText("Search");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tf_branch_location)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox6)
                                .addGap(0, 482, Short.MAX_VALUE))
                            .addComponent(tf_search))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox1))
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox3))
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_branch_location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox6))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_report.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Status:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setText("Inv.Count");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setText("Receipts");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton4.setText("Sales");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton5.setText("Transfers");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton6.setText("Adjustm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton7.setText("Returns");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton8.setText("Charge");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tf_branch_locationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_branch_locationMouseClicked
        init_branch_locations();
    }//GEN-LAST:event_tf_branch_locationMouseClicked

    private void tf_branch_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_branch_locationActionPerformed
        init_branch_locations();
    }//GEN-LAST:event_tf_branch_locationActionPerformed

    private void tf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_searchMouseClicked

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_inventory_barcodes();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        init_report();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        inventory_count();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        receipts();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        sales();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        transfers();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        adjustments();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        replacements();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        charge_in_advance();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JTextField tf_branch_location;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
//        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
        set_default_branch();
        String where = "  ";
        branch_location_list = S1_branch_locations.ret_location_where(where);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tf_search.grabFocus();
            }
        });
    }

    private void set_default_branch() {
        S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();

        Field.Combo lo = (Field.Combo) tf_branch_location;

        lo.setText(to.branch + " - ( " + to.location + " )");
        lo.setId("" + to.id);
        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;
        selected_branch = my_branch;
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
    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations() {

        final Field.Combo lo = (Field.Combo) tf_branch_location;

        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.branch + " - ( " + to.location + " )";
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, 200};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(lo, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.get(data.selected_row);
                lo.setText(to.branch + " - ( " + to.location + " )");
                lo.setId("" + to.id);
                selected_branch = to.branch;
            }
        });
    }
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";
    String my_item_code = "";
    String my_barcode = "";
    String my_description = "";
    String selected_branch = "";
    List<Inventory_barcodes.to_inventory_barcodes> inventory_barcoders_list = new ArrayList();

    private void init_inventory_barcodes() {

        jProgressBar1.setString("Searching...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String search = tf_search.getText();

                String where = " "
                        + " where main_barcode like '" + search + "' and location_id='" + my_location_id + "' "
                        + " ";
                if (jCheckBox5.isSelected()) {
                    where = " where description like  '%" + search + "%' and location_id='" + my_location_id + "' order by description asc ";
                }
                if (jCheckBox6.isSelected()) {
                    where = " where barcode='" + search + "' and location_id='" + my_location_id + "' ";
                }

                inventory_barcoders_list.clear();
                inventory_barcoders_list = S2_inventory_barcodes.ret_data(where);
                if (inventory_barcoders_list.isEmpty()) {
                    Alert.set(0, "Item Not Found");
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
                if (inventory_barcoders_list.size() == 1) {
                    Inventory_barcodes.to_inventory_barcodes t = inventory_barcoders_list.get(0);
                    my_item_code = t.main_barcode;
                    my_description = t.description;
                    tf_search.setText(my_description);
                    if (jCheckBox4.isSelected()) {
                        tf_search.setText(t.main_barcode);
                    }
                    if (jCheckBox5.isSelected()) {
                        tf_search.setText(t.description);
                    }
                    if (jCheckBox6.isSelected()) {
                        tf_search.setText(t.barcode);
                    }
                    tf_search.selectAll();
                    init_report();
                }
                if (inventory_barcoders_list.size() > 1) {
                    Object[][] obj = new Object[inventory_barcoders_list.size()][6];
                    int i = 0;
                    for (Inventory_barcodes.to_inventory_barcodes to : inventory_barcoders_list) {
                        obj[i][0] = " " + to.main_barcode;
                        obj[i][1] = " " + to.barcode;
                        obj[i][2] = " " + to.description;
                        i++;
                    }
                    JLabel[] labels = {};
                    double width = tf_search.getWidth();
                    width = width * .60;
                    int w = FitIn.toInt("" + width);
                    int[] tbl_widths_customers = {60, 100, tf_search.getWidth() - 200};
                    String[] col_names = {"Item Code", "Barcode", "Description"};
                    TableRenderer tr = new TableRenderer();
                    TableRenderer.setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);

                    tr.setCallback(new TableRenderer.Callback() {
                        @Override
                        public void ok(TableRenderer.OutputData data) {
                            Inventory_barcodes.to_inventory_barcodes t = inventory_barcoders_list.get(data.selected_row);
                            my_item_code = t.main_barcode;
                            my_description = t.description;

                            if (jCheckBox4.isSelected()) {
                                tf_search.setText(t.main_barcode);
                            }
                            if (jCheckBox5.isSelected()) {
                                tf_search.setText(t.description);
                            }
                            if (jCheckBox6.isSelected()) {
                                tf_search.setText(t.barcode);
                            }
                            tf_search.selectAll();
                            init_report();
                            jProgressBar1.setString("Finished...");
                            jProgressBar1.setIndeterminate(false);
                        }
                    });
                }

            }
        });
        t.start();
    }

    private void init_report() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);

        Button.Search search = (Button.Search) jButton1;
        search.load();
        tf_search.setEnabled(false);
        Thread t;
        t = new Thread(new Runnable() {

            @Override
            public void run() {
                String month = "" + (jMonthChooser1.getMonth() + 1);
                if (month.length() == 1) {
                    month = "0" + month;
                }

                String year = "" + jYearChooser1.getYear();
                List<Srpt_item_ledger.field> field3 = new ArrayList();
                List<Srpt_item_ledger.field> fields = new ArrayList();
                Field.Combo lo = (Field.Combo) tf_branch_location;

                String where = " where item_code ='" + my_item_code + "'  and location_id = '" + lo.getId() + "' "
                        + "   ";
                String where2 = " where main_barcode ='" + my_item_code + "'  and location_id = '" + lo.getId() + "' "
                        + "  ";
                String where4 = " where main_barcode ='" + my_item_code + "'  and branch_id = '" + lo.getId() + "' "
                        + "  ";
                String where3 = " where barcode ='" + my_item_code + "'    "
                        + "  ";
                String wheree = " where item_code ='" + my_item_code + "'  and location_id = '" + lo.getId() + "' and status=1 "
                        + "   ";

                List<Srpt_item_ledger.field> sales = new ArrayList();//Srpt_item_ledger.sales(where);
                List<Srpt_item_ledger.field> inventory_count = new ArrayList();// Srpt_item_ledger.inventory_encoding(where);
                List<Srpt_item_ledger.field> receipts = new ArrayList(); //Srpt_item_ledger.receipts(where2);
                List<Srpt_item_ledger.field> transfers = new ArrayList(); //Srpt_item_ledger.transfer(where3);
                List<Srpt_item_ledger.field> adjustments = new ArrayList(); //Srpt_item_ledger.adjustments(where);
                List<Srpt_item_ledger.field> return_exchange = new ArrayList(); //Srpt_item_ledger.item_replacements(where);
                List<Srpt_item_ledger.field> charge_in_advance = new ArrayList(); //Srpt_item_ledger.charge_items(where);
                List<Srpt_item_ledger.field> charge_in_advance_cancelled = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
                List<Srpt_item_ledger.field> replenishments = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
                List<Srpt_item_ledger.field> requistion_slips = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
//                    System.out.println(where);
                try {
                    Connection conn = MyConnection.connect();

                    //<editor-fold defaultstate="collapsed" desc=" sales ">
                    String s0 = "select "
                            + "id"
                            + ",sales_no"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",generic_name"
                            + ",item_type"
                            + ",supplier_name"
                            + ",supplier_id"
                            + ",serial_no"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
                            + ",user_id"
                            + ",user_screen_name"
                            + ",status"
                            + ",is_vatable"
                            + ",selling_type"
                            + ",discount_name"
                            + ",discount_rate"
                            + ",discount_amount"
                            + ",discount_customer_name"
                            + ",discount_customer_id"
                            + ",branch"
                            + ",branch_code"
                            + ",location"
                            + ",location_id"
                            + ",category"
                            + ",category_id"
                            + ",classification"
                            + ",classification_id"
                            + ",sub_classification"
                            + ",sub_classification_id"
                            + ",brand"
                            + ",brand_id"
                            + ",model"
                            + ",model_id"
                            + ",addtl_amount"
                            + ",wtax"
                            + " from sale_items"
                            + " " + where;

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(s0);
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String sales_no = rs.getString(2);
                        String item_code = rs.getString(3);
                        String barcode = rs.getString(4);
                        String description = rs.getString(5);
                        String generic_name = rs.getString(6);
                        String item_type = rs.getString(7);
                        String supplier_name = rs.getString(8);
                        String supplier_id = rs.getString(9);
                        String serial_no = rs.getString(10);
                        double product_qty = rs.getDouble(11);
                        String unit = rs.getString(12);
                        double conversion = rs.getDouble(13);
                        double selling_price = rs.getDouble(14);
                        String date_added = rs.getString(15);
                        String user_id = rs.getString(16);
                        String user_screen_name = rs.getString(17);
                        int status = rs.getInt(18);
                        int is_vatable = rs.getInt(19);
                        int selling_type = rs.getInt(20);
                        String discount_name = rs.getString(21);
                        double discount_rate = rs.getDouble(22);
                        double discount_amount = rs.getDouble(23);
                        String discount_customer_name = rs.getString(24);
                        String discount_customer_id = rs.getString(25);
                        String branch = rs.getString(26);
                        String branch_code = rs.getString(27);
                        String location = rs.getString(28);
                        String location_id = rs.getString(29);
                        String category = rs.getString(30);
                        String category_id = rs.getString(31);
                        String classification = rs.getString(32);
                        String classification_id = rs.getString(33);
                        String sub_classification = rs.getString(34);
                        String sub_classification_id = rs.getString(35);
                        String brand = rs.getString(36);
                        String brand_id = rs.getString(37);
                        String model = rs.getString(38);
                        String model_id = rs.getString(39);
                        double addtl_amount = rs.getDouble(40);
                        double wtax = rs.getDouble(41);

                        String transaction_type = "Sales";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = "";
                        String out = FitIn.fmt_woc(product_qty);
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_code;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = user_screen_name;
                        String customer_name = "";
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + sales_no;
                        String cost1 = "";
                        String price1 = FitIn.fmt_wc_0(selling_price);
                        String months = DateType.convert_datetime_to_month(date_added);

                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                        sales.add(field);

                        if (status == 1) {
                            Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Sales - X", date, FitIn.fmt_woc(product_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            sales.add(field2);
                        }

                    }

                    //</editor-fold>                    
                    //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
                    String s2 = "select "
                            + "id"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + ",qty"
                            + ",date_added"
                            + ",user_name"
                            + ",screen_name"
                            + ",sheet_no"
                            + ",status"
                            + ",counted_by"
                            + ",checked_by"
                            + ",cost"
                            + ",selling_price"
                            + ",user_id"
                            + ",user_screen_name"
                            + " from encoding_inventory"
                            + " " + where;

                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(s2);
                    while (rs2.next()) {
                        int id = rs2.getInt(1);
                        String item_code = rs2.getString(2);
                        String barcode = rs2.getString(3);
                        String description = rs2.getString(4);
                        String branch = rs2.getString(5);
                        String branch_id = rs2.getString(6);
                        String location = rs2.getString(7);
                        String location_id = rs2.getString(8);
                        double qty = rs2.getDouble(9);
                        String date_added = rs2.getString(10);
                        String user_name = rs2.getString(11);
                        String screen_name = rs2.getString(12);
                        String sheet_no = rs2.getString(13);
                        int status = rs2.getInt(14);
                        String counted_by = rs2.getString(15);
                        String checked_by = rs2.getString(16);
                        double cost = rs2.getDouble(17);
                        double selling_price = rs2.getDouble(18);
                        String user_id = rs2.getString(19);
                        String user_screen_name = rs2.getString(20);

                        String transaction_type = "Inventory Count";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = FitIn.fmt_woc(qty);
                        String out = "";
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_id;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = screen_name;
                        String customer_name = "";
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + sheet_no;
                        String cost1 = FitIn.fmt_wc_0(cost);
                        String price1 = FitIn.fmt_wc_0(selling_price);
                        String months = DateType.convert_datetime_to_month(date_added);
                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);

                        inventory_count.add(field);
                    }
                    //</editor-fold>                   
                    //<editor-fold defaultstate="collapsed" desc=" Receipts ">
                    String s3 = "select "
                            + " id"
                            + ",receipt_no"
                            + ",user_name"
                            + ",session_no"
                            + ",date_added"
                            + ",supplier"
                            + ",supllier_id"
                            + ",remarks"
                            + ",barcode"
                            + ",description"
                            + ",qty"
                            + ",cost"
                            + ",category"
                            + ",category_id"
                            + ",classification"
                            + ",classification_id"
                            + ",sub_class"
                            + ",sub_class_id"
                            + ",conversion"
                            + ",unit"
                            + ",date_delivered"
                            + ",date_received"
                            + ",barcodes"
                            + ",batch_no"
                            + ",serial_no"
                            + ",main_barcode"
                            + ",brand"
                            + ",brand_id"
                            + ",model"
                            + ",model_id"
                            + ",status"
                            + ",previous_cost"
                            + ",receipt_type_id"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + " from receipt_items"
                            + " " + where4;
//                        System.out.println(where4);
                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery(s3);
                    while (rs3.next()) {
                        int id = rs3.getInt(1);
                        String receipt_no = rs3.getString(2);
                        String user_name = rs3.getString(3);
                        String session_no = rs3.getString(4);
                        String date_added = rs3.getString(5);
                        String supplier = rs3.getString(6);
                        String supllier_id = rs3.getString(7);
                        String remarks = rs3.getString(8);
                        String barcode = rs3.getString(9);
                        String description = rs3.getString(10);
                        double qty = rs3.getDouble(11);
                        double cost = rs3.getDouble(12);
                        String category = rs3.getString(13);
                        String category_id = rs3.getString(14);
                        String classification = rs3.getString(15);
                        String classification_id = rs3.getString(16);
                        String sub_class = rs3.getString(17);
                        String sub_class_id = rs3.getString(18);
                        double conversion = rs3.getDouble(19);
                        String unit = rs3.getString(20);
                        String date_delivered = rs3.getString(21);
                        String date_received = rs3.getString(22);
                        String barcodes = rs3.getString(23);
                        String batch_no = rs3.getString(24);
                        String serial_no = rs3.getString(25);
                        String main_barcode = rs3.getString(26);
                        String brand = rs3.getString(27);
                        String brand_id = rs3.getString(28);
                        String model = rs3.getString(29);
                        String model_id = rs3.getString(30);
                        int status = rs3.getInt(31);
                        double previous_cost = rs3.getDouble(32);
                        String receipt_type_id = rs3.getString(33);
                        String branch = rs3.getString(34);
                        String branch_id = rs3.getString(35);
                        String location = rs3.getString(36);
                        String location_id = rs3.getString(37);

                        String transaction_type = "Receipts";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = FitIn.fmt_woc(qty);
                        String out = "";
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_id;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = user_name;
                        String customer_name = "";
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + receipt_no;
                        String cost1 = FitIn.fmt_wc_0(cost);
                        String price1 = "";
                        String months = DateType.convert_datetime_to_month(date_added);

                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_branch, from_branch_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                        if (status == 1) {
                            receipts.add(field);
                        }

                    }

                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" Transfers ">
                    List<Srpt_item_ledger.field> transfer_in = new ArrayList();
                    List<Srpt_item_ledger.field> transfer_out = new ArrayList();
                    String s4 = "select "
                            + "id"
                            + ",barcode"
                            + ",description"
                            + ",generic_name"
                            + ",category"
                            + ",category_id"
                            + ",classification"
                            + ",classification_id"
                            + ",sub_classification"
                            + ",sub_classification_id"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
                            + ",user_name"
                            + ",item_type"
                            + ",status"
                            + ",supplier"
                            + ",fixed_price"
                            + ",cost"
                            + ",supplier_id"
                            + ",multi_level_pricing"
                            + ",vatable"
                            + ",reorder_level"
                            + ",markup"
                            + ",barcodes"
                            + ",brand"
                            + ",brand_id"
                            + ",model"
                            + ",model_id"
                            + ",selling_type"
                            + ",branch"
                            + ",branch_code"
                            + ",location"
                            + ",location_id"
                            + ",stock_transfer_id"
                            + ",serial_no"
                            + ",to_branch"
                            + ",to_branch_id"
                            + ",to_location"
                            + ",to_location_id"
                            + " from stock_transfers_items"
                            + " " + where3;

                    Statement stmt4 = conn.createStatement();
                    ResultSet rs4 = stmt4.executeQuery(s4);
                    while (rs4.next()) {
                        int id = rs4.getInt(1);
                        String barcode = rs4.getString(2);
                        String description = rs4.getString(3);
                        String generic_name = rs4.getString(4);
                        String category = rs4.getString(5);
                        String category_id = rs4.getString(6);
                        String classification = rs4.getString(7);
                        String classification_id = rs4.getString(8);
                        String sub_classification = rs4.getString(9);
                        String sub_classification_id = rs4.getString(10);
                        double product_qty = rs4.getDouble(11);
                        String unit = rs4.getString(12);
                        double conversion = rs4.getDouble(13);
                        double selling_price = rs4.getDouble(14);
                        String date_added = rs4.getString(15);
                        String user_name = rs4.getString(16);
                        String item_type = rs4.getString(17);
                        int status = rs4.getInt(18);
                        String supplier = rs4.getString(19);
                        int fixed_price = rs4.getInt(20);
                        double cost = rs4.getDouble(21);
                        String supplier_id = rs4.getString(22);
                        int multi_level_pricing = rs4.getInt(23);
                        int vatable = rs4.getInt(24);
                        double reorder_level = rs4.getDouble(25);
                        double markup = rs4.getDouble(26);
                        String barcodes = rs4.getString(27);
                        String brand = rs4.getString(28);
                        String brand_id = rs4.getString(29);
                        String model = rs4.getString(30);
                        String model_id = rs4.getString(31);
                        int selling_type = rs4.getInt(32);
                        String branch = rs4.getString(33);
                        String branch_code = rs4.getString(34);
                        String location = rs4.getString(35);
                        String location_id = rs4.getString(36);
                        String stock_transfer_id = rs4.getString(37);
                        String serial_no = rs4.getString(38);
                        String to_branch = rs4.getString(39);
                        String to_branch_id = rs4.getString(40);
                        String to_location = rs4.getString(41);
                        String to_location_id = rs4.getString(42);

                        String transaction_type = "Transfer";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = FitIn.fmt_woc(product_qty);
                        String out = "";
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_code;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch1 = "";
                        String to_branch_id1 = "";
                        String to_location1 = "";
                        String to_location_id1 = "";
                        String created_by = user_name;
                        String customer_name = "";
                        Date created = new Date();

                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        String transaction_no = "" + stock_transfer_id;
                        String cost1 = FitIn.fmt_wc_0(cost);
                        String price1 = "";
                        String months = DateType.convert_datetime_to_month(date_added);
                        Srpt_item_ledger.field field_out = new Srpt_item_ledger.field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);

                        Srpt_item_ledger.field field_in = new Srpt_item_ledger.field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);

                        if (status == 1) {

                            if (lo.getId().equalsIgnoreCase(to_location_id)) {
                                transfer_in.add(field_in);
                            }

                            if (lo.getId().equalsIgnoreCase(location_id)) {
                                transfer_out.add(field_out);
                            }

                        }
                    }

                    transfers.addAll(transfer_in);
                    transfers.addAll(transfer_out);

                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
                    List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
                    List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();
                    String s5 = "select "
                            + "id"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",qty"
                            + ",new_qty"
                            + ",is_add"
                            + ",date_added"
                            + ",status"
                            + ",user_id"
                            + ",user_screen_name"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + " from adjustments"
                            + " " + where;

                    Statement stmt5 = conn.createStatement();
                    ResultSet rs5 = stmt5.executeQuery(s5);
                    while (rs5.next()) {
                        int id = rs5.getInt(1);
                        String item_code = rs5.getString(2);
                        String barcode = rs5.getString(3);
                        String description = rs5.getString(4);
                        double qty = rs5.getDouble(5);
                        double new_qty = rs5.getDouble(6);
                        int is_add = rs5.getInt(7);
                        String date_added = rs5.getString(8);
                        int status = rs5.getInt(9);
                        String user_id = rs5.getString(10);
                        String user_screen_name = rs5.getString(11);
                        String branch = rs5.getString(12);
                        String branch_id = rs5.getString(13);
                        String location = rs5.getString(14);
                        String location_id = rs5.getString(15);

                        String transaction_type = "Adjustment";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = FitIn.fmt_woc(new_qty);
                        String out = "";
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_id;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = user_screen_name;
                        String customer_name = "";
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + id;
                        String cost1 = "";
                        String price1 = "";
                        String months = DateType.convert_datetime_to_month(date_added);
                        if (is_add == 1) {
                            Srpt_item_ledger.field add = new Srpt_item_ledger.field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            adjustment_add.add(add);
                        } else {
                            Srpt_item_ledger.field deduct = new Srpt_item_ledger.field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            adjustment_deduct.add(deduct);
                        }

                    }
                    adjustments.addAll(adjustment_add);
                    adjustments.addAll(adjustment_deduct);

                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" Return Exchange ">
                    String s6 = "select "
                            + "id"
                            + ",sales_no"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",generic_name"
                            + ",item_type"
                            + ",supplier_name"
                            + ",supplier_id"
                            + ",serial_no"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
                            + ",user_id"
                            + ",user_screen_name"
                            + ",status"
                            + ",is_vatable"
                            + ",selling_type"
                            + ",discount_name"
                            + ",discount_rate"
                            + ",discount_amount"
                            + ",discount_customer_name"
                            + ",discount_customer_id"
                            + ",branch"
                            + ",branch_code"
                            + ",location"
                            + ",location_id"
                            + ",category"
                            + ",category_id"
                            + ",classification"
                            + ",classification_id"
                            + ",sub_classification"
                            + ",sub_classification_id"
                            + ",brand"
                            + ",brand_id"
                            + ",model"
                            + ",model_id"
                            + ",is_replacement"
                            + " from sale_item_replacements"
                            + " " + where;
                    Statement stmt6 = conn.createStatement();
                    ResultSet rs6 = stmt6.executeQuery(s6);
                    while (rs6.next()) {
                        int id = rs6.getInt(1);
                        String sales_no = rs6.getString(2);
                        String item_code = rs6.getString(3);
                        String barcode = rs6.getString(4);
                        String description = rs6.getString(5);
                        String generic_name = rs6.getString(6);
                        String item_type = rs6.getString(7);
                        String supplier_name = rs6.getString(8);
                        String supplier_id = rs6.getString(9);
                        String serial_no = rs6.getString(10);
                        double product_qty = rs6.getDouble(11);
                        String unit = rs6.getString(12);
                        double conversion = rs6.getDouble(13);
                        double selling_price = rs6.getDouble(14);
                        String date_added = rs6.getString(15);
                        String user_id = rs6.getString(16);
                        String user_screen_name = rs6.getString(17);
                        int status = rs6.getInt(18);
                        int is_vatable = rs6.getInt(19);
                        int selling_type = rs6.getInt(20);
                        String discount_name = rs6.getString(21);
                        double discount_rate = rs6.getDouble(22);
                        double discount_amount = rs6.getDouble(23);
                        String discount_customer_name = rs6.getString(24);
                        String discount_customer_id = rs6.getString(25);
                        String branch = rs6.getString(26);
                        String branch_code = rs6.getString(27);
                        String location = rs6.getString(28);
                        String location_id = rs6.getString(29);
                        String category = rs6.getString(30);
                        String category_id = rs6.getString(31);
                        String classification = rs6.getString(32);
                        String classification_id = rs6.getString(33);
                        String sub_classification = rs6.getString(34);
                        String sub_classification_id = rs6.getString(35);
                        String brand = rs6.getString(36);
                        String brand_id = rs6.getString(37);
                        String model = rs6.getString(38);
                        String model_id = rs6.getString(39);
                        int is_replacement = rs6.getInt(40);

                        String transaction_type = "Exc-Replacement";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = "";
                        String out = FitIn.fmt_woc(product_qty);
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_code;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = user_screen_name;
                        String customer_name = "";
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + sales_no;
                        String cost1 = "";
                        String price1 = FitIn.fmt_wc_0(selling_price);
                        if (is_replacement == 0) {
                            transaction_type = "Exc-Returned";
                            in = FitIn.fmt_woc(product_qty);
                            out = "";

                            String s100 = "select "
                                    + " date_added "
                                    + " from sales "
                                    + " where sales_no='" + sales_no + "' ";

                            Statement stmt100 = conn.createStatement();
                            ResultSet rs100 = stmt100.executeQuery(s100);
                            String date_added1 = "";
                            if (rs100.next()) {
                                date_added1 = rs100.getString(1);
                            }
                            String months1 = POS.util.DateType.convert_slash_datetime3(date_added1);

                            String months = DateType.convert_datetime_to_month(date_added);
                            Srpt_item_ledger.field field1 = new Srpt_item_ledger.field("Sales", months1, "", in, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            return_exchange.add(field1);

                            Srpt_item_ledger.field field11 = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, "" + id, cost1, price1, months);
                            return_exchange.add(field11);
                        }

                    }
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" Charge in Advance ">
                    String s7 = "select "
                            + "id"
                            + ",customer_id"
                            + ",customer_name"
                            + ",ar_id"
                            + ",ar_no"
                            + ",date_applied"
                            + ",reference_no"
                            + ",soa_type"
                            + ",soa_type_id"
                            + ",user_screen_name"
                            + ",user_id"
                            + ",remarks"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",generic_name"
                            + ",item_type"
                            + ",supplier_name"
                            + ",supplier_id"
                            + ",serial_no"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
                            + ",status"
                            + ",is_vatable"
                            + ",selling_type"
                            + ",discount_name"
                            + ",discount_rate"
                            + ",discount_amount"
                            + ",discount_customer_name"
                            + ",discount_customer_id"
                            + ",branch"
                            + ",branch_code"
                            + ",location"
                            + ",location_id"
                            + ",category"
                            + ",category_id"
                            + ",classification"
                            + ",classification_id"
                            + ",sub_classification"
                            + ",sub_classification_id"
                            + ",brand"
                            + ",brand_id"
                            + ",model"
                            + ",model_id"
                            + ",addtl_amount"
                            + ",wtax"
                            + " from charge_in_advance_items"
                            + " " + where;

                    Statement stmt7 = conn.createStatement();
                    ResultSet rs7 = stmt7.executeQuery(s7);
                    while (rs7.next()) {
                        int id = rs7.getInt(1);
                        String customer_id = rs7.getString(2);
                        String customer_name = rs7.getString(3);
                        String ar_id = rs7.getString(4);
                        String ar_no = rs7.getString(5);
                        String date_applied = rs7.getString(6);
                        String reference_no = rs7.getString(7);
                        String soa_type = rs7.getString(8);
                        String soa_type_id = rs7.getString(9);
                        String user_screen_name = rs7.getString(10);
                        String user_id = rs7.getString(11);
                        String remarks = rs7.getString(12);
                        String item_code = rs7.getString(13);
                        String barcode = rs7.getString(14);
                        String description = rs7.getString(15);
                        String generic_name = rs7.getString(16);
                        String item_type = rs7.getString(17);
                        String supplier_name = rs7.getString(18);
                        String supplier_id = rs7.getString(19);
                        String serial_no = rs7.getString(20);
                        double product_qty = rs7.getDouble(21);
                        String unit = rs7.getString(22);
                        double conversion = rs7.getDouble(23);
                        double selling_price = rs7.getDouble(24);
                        String date_added = rs7.getString(25);
                        int status = rs7.getInt(26);
                        int is_vatable = rs7.getInt(27);
                        int selling_type = rs7.getInt(28);
                        String discount_name = rs7.getString(29);
                        double discount_rate = rs7.getDouble(30);
                        double discount_amount = rs7.getDouble(31);
                        String discount_customer_name = rs7.getString(32);
                        String discount_customer_id = rs7.getString(33);
                        String branch = rs7.getString(34);
                        String branch_code = rs7.getString(35);
                        String location = rs7.getString(36);
                        String location_id = rs7.getString(37);
                        String category = rs7.getString(38);
                        String category_id = rs7.getString(39);
                        String classification = rs7.getString(40);
                        String classification_id = rs7.getString(41);
                        String sub_classification = rs7.getString(42);
                        String sub_classification_id = rs7.getString(43);
                        String brand = rs7.getString(44);
                        String brand_id = rs7.getString(45);
                        String model = rs7.getString(46);
                        String model_id = rs7.getString(47);
                        double addtl_amount = rs7.getDouble(48);
                        double wtax = rs7.getDouble(49);

                        String transaction_type = "Charge in Advance[-]";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = "";
                        String out = FitIn.fmt_woc(product_qty);
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_code;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = user_screen_name;
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + ar_no;
                        String cost1 = "";
                        String price1 = FitIn.fmt_wc_0(selling_price);
                        String months = DateType.convert_datetime_to_month(date_added);

                        if (status == 0) {
                            Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            charge_in_advance.add(field);
                        } else {
                            Srpt_item_ledger.field field = new Srpt_item_ledger.field("Charge in Advance[+]", date, out, "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            charge_in_advance.add(field);
                        }

                    }
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" Replenishment ">
                    String s9 = "select "
                            + "id"
                            + ",inventory_replenishment_no"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",product_qty"
                            + ",unit"
                            + ",conversion"
                            + ",selling_price"
                            + ",date_added"
                            + ",user_id"
                            + ",user_screen_name"
                            + ",status"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + " from inventory_replenishment_items"
                            + " " + wheree;

                    Statement stmt9 = conn.createStatement();
                    ResultSet rs9 = stmt9.executeQuery(s9);
                    while (rs9.next()) {
                        int id = rs9.getInt(1);
                        String inventory_replenishment_no = rs9.getString(2);
                        String item_code = rs9.getString(3);
                        String barcode = rs9.getString(4);
                        String description = rs9.getString(5);
                        double product_qty = rs9.getDouble(6);
                        String unit = rs9.getString(7);
                        double conversion = rs9.getDouble(8);
                        double selling_price = rs9.getDouble(9);
                        String date_added = rs9.getString(10);
                        String user_id = rs9.getString(11);
                        String user_screen_name = rs9.getString(12);
                        int status = rs9.getInt(13);
                        String branch = rs9.getString(14);
                        String branch_id = rs9.getString(15);
                        String location = rs9.getString(16);
                        String location_id = rs9.getString(17);

                        String transaction_type = "Replenishment";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = "";
                        String out = FitIn.fmt_woc(product_qty);

                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_id;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = user_screen_name;
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + inventory_replenishment_no;
                        String cost1 = "";
                        String price1 = FitIn.fmt_wc_0(selling_price);
                        String months = DateType.convert_datetime_to_month(date_added);
                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, user_screen_name, created, transaction_no, cost1, price1, months);
                        replenishments.add(field);
                    }
                    //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" Requisition Slip ">
                    String s10 = "select "
                            + "id"
                            + ",requisition_slip_no"
                            + ",requisition_date"
                            + ",requisition_type"
                            + ",requisition_department"
                            + ",requisition_department_id"
                            + ",requested_by"
                            + ",item_code"
                            + ",barcode"
                            + ",description"
                            + ",product_qty"
                            + ",unit"
                            + ",cost"
                            + ",selling_price"
                            + ",branch"
                            + ",branch_id"
                            + ",location"
                            + ",location_id"
                            + ",date_added"
                            + ",status"
                            + " from requisition_slip_items"
                            + " " + wheree;

                    Statement stmt10 = conn.createStatement();
                    ResultSet rs10 = stmt10.executeQuery(s10);
                    while (rs10.next()) {
                        int id = rs10.getInt(1);
                        String requisition_slip_no = rs10.getString(2);
                        String requisition_date = rs10.getString(3);
                        String requisition_type = rs10.getString(4);
                        String requisition_department = rs10.getString(5);
                        String requisition_department_id = rs10.getString(6);
                        String requested_by = rs10.getString(7);
                        String item_code = rs10.getString(8);
                        String barcode = rs10.getString(9);
                        String description = rs10.getString(10);
                        double product_qty = rs10.getDouble(11);
                        String unit = rs10.getString(12);
                        double cost = rs10.getDouble(13);
                        double selling_price = rs10.getDouble(14);
                        String branch = rs10.getString(15);
                        String branch_id = rs10.getString(16);
                        String location = rs10.getString(17);
                        String location_id = rs10.getString(18);
                        String date_added = rs10.getString(19);
                        int status = rs10.getInt(20);

                        String transaction_type = "Sales";
                        String date = POS.util.DateType.convert_slash_datetime3(date_added);
                        String in = "";
                        String out = FitIn.fmt_woc(product_qty);
                        String balance = "";
                        String from_branch = branch;
                        String from_branch_id = branch_id;
                        String from_location = location;
                        String from_location_id = location_id;
                        String to_branch = "";
                        String to_branch_id = "";
                        String to_location = "";
                        String to_location_id = "";
                        String created_by = requested_by;
                        String customer_name = "";
                        Date created = new Date();
                        try {
                            created = POS.util.DateType.datetime.parse(date_added);
                        } catch (ParseException ex) {
                            Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String transaction_no = "" + requisition_slip_no;
                        String cost1 = "";
                        String price1 = FitIn.fmt_wc_0(selling_price);
                        String months = DateType.convert_datetime_to_month(date_added);
                        if (status == 1) {
                            Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Requisition Slip", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            requistion_slips.add(field2);
                        }
                    }
                    //</editor-fold>

                    fields.addAll(inventory_count);
                    fields.addAll(sales);
                    fields.addAll(receipts);
                    fields.addAll(transfers);
                    fields.addAll(adjustments);
                    fields.addAll(return_exchange);
                    fields.addAll(charge_in_advance);
                    fields.addAll(charge_in_advance_cancelled);
                    fields.addAll(replenishments);
                    fields.addAll(requistion_slips);

                    List<Srpt_item_ledger.field> f_field = new ArrayList();

                    Collections.sort(fields, new Comparator<Srpt_item_ledger.field>() {
                        @Override
                        public int compare(Srpt_item_ledger.field o1, Srpt_item_ledger.field o2) {
                            return o1.getDate_added().compareTo(o2.getDate_added());
                        }
                    });

                    double running_balance = 0;
                    double qty = 0;
                    for (Srpt_item_ledger.field f : fields) {
                        if (FitIn.toDouble(f.getIn()) > 0) {
                            qty += FitIn.toDouble(f.getIn());
                        } else {
                            qty -= FitIn.toDouble(f.getOut());
                        }
                        if (f.transaction_type.equalsIgnoreCase("Replenishment")) {
                            qty = 0;
                        }
                        f.setFrom_branch(my_branch);
                        f.setFrom_location(my_location);
                        f.setBalance(FitIn.fmt_woc(qty));
                        field3.add(f);
                    }

                    List<Srpt_item_ledger.field> fields2 = new ArrayList();
                    String jrxml = "rpt_inventory_ledger.jrxml";
                    for (Srpt_item_ledger.field to2 : field3) {
                        String m = DateType.m1.format(to2.date_added);
                        String y = DateType.y.format(to2.date_added);
                        if (year.equals(y) && jCheckBox3.isSelected()) {
                            fields2.add(to2);
                            running_balance = FitIn.toDouble(to2.getBalance());
                        }
                        if (year.equals(y) && !jCheckBox3.isSelected()) {
                            if (month.equalsIgnoreCase(m)) {
                                fields2.add(to2);
                                running_balance = FitIn.toDouble(to2.getBalance());
                            }
                        }
                    }

                    String business_name = System.getProperty("business_name", "Algorithm Computer Services");
                    String contact_no = System.getProperty("telephone_number", "");
                    String address = System.getProperty("address", "Dumaguete City");
                    String date = "" + jYearChooser1.getYear();
                    String item_code = my_item_code;
                    String barcode = my_barcode;
                    String description = my_description;
                    String branch = "All";
                    String location = tf_branch_location.getText();
                    List<Srpt_item_ledger.field> field4 = new ArrayList();
                    int m = jMonthChooser1.getMonth();
                    String[] mm = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

                    Srpt_item_ledger rpt = new Srpt_item_ledger(business_name, address, contact_no, date, item_code, barcode, description, branch, location, mm[m], running_balance);
                    rpt.fields.addAll(fields2);
                    report_sales_items(rpt, jrxml);
                    InputStream is = Srpt_item_ledger.class.getResourceAsStream(jrxml);
                    try {
                        JasperReport jasperReport = JasperCompileManager.compileReport(is);

                        jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                    } catch (JRException ex) {
                        Logger.getLogger(Dlg_report_items.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    MyConnection.close();
                }

//                
                Button.Search search = (Button.Search) jButton1;
                search.finish();
                tf_search.setEnabled(true);
                tf_search.grabFocus();
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void init_report2() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);

        Button.Search search = (Button.Search) jButton1;
        search.load();
        tf_search.setEnabled(false);
        Thread t;
        t = new Thread(new Runnable() {

            @Override
            public void run() {
                String month = "" + (jMonthChooser1.getMonth() + 1);
                if (month.length() == 1) {
                    month = "0" + month;
                }

                String locatio_id = "20";
                List<Inventory_barcodes.to_inventory_barcodes> inventory = Inventory_barcodes.ret_where(" where location_id='" + locatio_id + "' "
                        + "  and main_barcode='"+tf_search.getText()+"'");

                System.out.println("location_id: " + locatio_id + " | Size:  " + inventory.size());

                for (Inventory_barcodes.to_inventory_barcodes inv : inventory) {

                    String year = "" + jYearChooser1.getYear();
                    List<Srpt_item_ledger.field> field3 = new ArrayList();
                    List<Srpt_item_ledger.field> fields = new ArrayList();
                    Field.Combo lo = (Field.Combo) tf_branch_location;
                    
                    my_item_code = inv.main_barcode;
                    lo.setId(inv.location_id);

                    String where = " where item_code ='" + my_item_code + "'  and location_id = '" + locatio_id + "' "
                            + "   ";
                    String where2 = " where main_barcode ='" + my_item_code + "'  and location_id = '" + locatio_id + "' "
                            + "  ";
                    String where4 = " where main_barcode ='" + my_item_code + "'  and branch_id = '" + locatio_id + "' "
                            + "  ";
                    String where3 = " where barcode ='" + my_item_code + "'    "
                            + "  ";
                    String wheree = " where item_code ='" + my_item_code + "'  and location_id = '" + locatio_id + "' and status=1 "
                            + "   ";

                    List<Srpt_item_ledger.field> sales = new ArrayList();//Srpt_item_ledger.sales(where);
                    List<Srpt_item_ledger.field> inventory_count = new ArrayList();// Srpt_item_ledger.inventory_encoding(where);
                    List<Srpt_item_ledger.field> receipts = new ArrayList(); //Srpt_item_ledger.receipts(where2);
                    List<Srpt_item_ledger.field> transfers = new ArrayList(); //Srpt_item_ledger.transfer(where3);
                    List<Srpt_item_ledger.field> adjustments = new ArrayList(); //Srpt_item_ledger.adjustments(where);
                    List<Srpt_item_ledger.field> return_exchange = new ArrayList(); //Srpt_item_ledger.item_replacements(where);
                    List<Srpt_item_ledger.field> charge_in_advance = new ArrayList(); //Srpt_item_ledger.charge_items(where);
                    List<Srpt_item_ledger.field> charge_in_advance_cancelled = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
                    List<Srpt_item_ledger.field> replenishments = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
                    List<Srpt_item_ledger.field> requistion_slips = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
//                    System.out.println(where);
                    try {
                        Connection conn = MyConnection.connect();

                        //<editor-fold defaultstate="collapsed" desc=" sales ">
                        String s0 = "select "
                                + "id"
                                + ",sales_no"
                                + ",item_code"
                                + ",barcode"
                                + ",description"
                                + ",generic_name"
                                + ",item_type"
                                + ",supplier_name"
                                + ",supplier_id"
                                + ",serial_no"
                                + ",product_qty"
                                + ",unit"
                                + ",conversion"
                                + ",selling_price"
                                + ",date_added"
                                + ",user_id"
                                + ",user_screen_name"
                                + ",status"
                                + ",is_vatable"
                                + ",selling_type"
                                + ",discount_name"
                                + ",discount_rate"
                                + ",discount_amount"
                                + ",discount_customer_name"
                                + ",discount_customer_id"
                                + ",branch"
                                + ",branch_code"
                                + ",location"
                                + ",location_id"
                                + ",category"
                                + ",category_id"
                                + ",classification"
                                + ",classification_id"
                                + ",sub_classification"
                                + ",sub_classification_id"
                                + ",brand"
                                + ",brand_id"
                                + ",model"
                                + ",model_id"
                                + ",addtl_amount"
                                + ",wtax"
                                + " from sale_items"
                                + " " + where;

                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(s0);
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            String sales_no = rs.getString(2);
                            String item_code = rs.getString(3);
                            String barcode = rs.getString(4);
                            String description = rs.getString(5);
                            String generic_name = rs.getString(6);
                            String item_type = rs.getString(7);
                            String supplier_name = rs.getString(8);
                            String supplier_id = rs.getString(9);
                            String serial_no = rs.getString(10);
                            double product_qty = rs.getDouble(11);
                            String unit = rs.getString(12);
                            double conversion = rs.getDouble(13);
                            double selling_price = rs.getDouble(14);
                            String date_added = rs.getString(15);
                            String user_id = rs.getString(16);
                            String user_screen_name = rs.getString(17);
                            int status = rs.getInt(18);
                            int is_vatable = rs.getInt(19);
                            int selling_type = rs.getInt(20);
                            String discount_name = rs.getString(21);
                            double discount_rate = rs.getDouble(22);
                            double discount_amount = rs.getDouble(23);
                            String discount_customer_name = rs.getString(24);
                            String discount_customer_id = rs.getString(25);
                            String branch = rs.getString(26);
                            String branch_code = rs.getString(27);
                            String location = rs.getString(28);
                            String location_id = rs.getString(29);
                            String category = rs.getString(30);
                            String category_id = rs.getString(31);
                            String classification = rs.getString(32);
                            String classification_id = rs.getString(33);
                            String sub_classification = rs.getString(34);
                            String sub_classification_id = rs.getString(35);
                            String brand = rs.getString(36);
                            String brand_id = rs.getString(37);
                            String model = rs.getString(38);
                            String model_id = rs.getString(39);
                            double addtl_amount = rs.getDouble(40);
                            double wtax = rs.getDouble(41);

                            String transaction_type = "Sales";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = "";
                            String out = FitIn.fmt_woc(product_qty);
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_code;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = user_screen_name;
                            String customer_name = "";
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + sales_no;
                            String cost1 = "";
                            String price1 = FitIn.fmt_wc_0(selling_price);
                            String months = DateType.convert_datetime_to_month(date_added);

                            Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            sales.add(field);

                            if (status == 1) {
                                Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Sales - X", date, FitIn.fmt_woc(product_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                                sales.add(field2);
                            }

                        }

                        //</editor-fold>                    
                        //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
                        String s2 = "select "
                                + "id"
                                + ",item_code"
                                + ",barcode"
                                + ",description"
                                + ",branch"
                                + ",branch_id"
                                + ",location"
                                + ",location_id"
                                + ",qty"
                                + ",date_added"
                                + ",user_name"
                                + ",screen_name"
                                + ",sheet_no"
                                + ",status"
                                + ",counted_by"
                                + ",checked_by"
                                + ",cost"
                                + ",selling_price"
                                + ",user_id"
                                + ",user_screen_name"
                                + " from encoding_inventory"
                                + " " + where;

                        Statement stmt2 = conn.createStatement();
                        ResultSet rs2 = stmt2.executeQuery(s2);
                        while (rs2.next()) {
                            int id = rs2.getInt(1);
                            String item_code = rs2.getString(2);
                            String barcode = rs2.getString(3);
                            String description = rs2.getString(4);
                            String branch = rs2.getString(5);
                            String branch_id = rs2.getString(6);
                            String location = rs2.getString(7);
                            String location_id = rs2.getString(8);
                            double qty = rs2.getDouble(9);
                            String date_added = rs2.getString(10);
                            String user_name = rs2.getString(11);
                            String screen_name = rs2.getString(12);
                            String sheet_no = rs2.getString(13);
                            int status = rs2.getInt(14);
                            String counted_by = rs2.getString(15);
                            String checked_by = rs2.getString(16);
                            double cost = rs2.getDouble(17);
                            double selling_price = rs2.getDouble(18);
                            String user_id = rs2.getString(19);
                            String user_screen_name = rs2.getString(20);

                            String transaction_type = "Inventory Count";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = FitIn.fmt_woc(qty);
                            String out = "";
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_id;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = screen_name;
                            String customer_name = "";
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + sheet_no;
                            String cost1 = FitIn.fmt_wc_0(cost);
                            String price1 = FitIn.fmt_wc_0(selling_price);
                            String months = DateType.convert_datetime_to_month(date_added);
                            Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);

                            inventory_count.add(field);
                        }
                        //</editor-fold>                   
                        //<editor-fold defaultstate="collapsed" desc=" Receipts ">
                        String s3 = "select "
                                + " id"
                                + ",receipt_no"
                                + ",user_name"
                                + ",session_no"
                                + ",date_added"
                                + ",supplier"
                                + ",supllier_id"
                                + ",remarks"
                                + ",barcode"
                                + ",description"
                                + ",qty"
                                + ",cost"
                                + ",category"
                                + ",category_id"
                                + ",classification"
                                + ",classification_id"
                                + ",sub_class"
                                + ",sub_class_id"
                                + ",conversion"
                                + ",unit"
                                + ",date_delivered"
                                + ",date_received"
                                + ",barcodes"
                                + ",batch_no"
                                + ",serial_no"
                                + ",main_barcode"
                                + ",brand"
                                + ",brand_id"
                                + ",model"
                                + ",model_id"
                                + ",status"
                                + ",previous_cost"
                                + ",receipt_type_id"
                                + ",branch"
                                + ",branch_id"
                                + ",location"
                                + ",location_id"
                                + " from receipt_items"
                                + " " + where4;
//                        System.out.println(where4);
                        Statement stmt3 = conn.createStatement();
                        ResultSet rs3 = stmt3.executeQuery(s3);
                        while (rs3.next()) {
                            int id = rs3.getInt(1);
                            String receipt_no = rs3.getString(2);
                            String user_name = rs3.getString(3);
                            String session_no = rs3.getString(4);
                            String date_added = rs3.getString(5);
                            String supplier = rs3.getString(6);
                            String supllier_id = rs3.getString(7);
                            String remarks = rs3.getString(8);
                            String barcode = rs3.getString(9);
                            String description = rs3.getString(10);
                            double qty = rs3.getDouble(11);
                            double cost = rs3.getDouble(12);
                            String category = rs3.getString(13);
                            String category_id = rs3.getString(14);
                            String classification = rs3.getString(15);
                            String classification_id = rs3.getString(16);
                            String sub_class = rs3.getString(17);
                            String sub_class_id = rs3.getString(18);
                            double conversion = rs3.getDouble(19);
                            String unit = rs3.getString(20);
                            String date_delivered = rs3.getString(21);
                            String date_received = rs3.getString(22);
                            String barcodes = rs3.getString(23);
                            String batch_no = rs3.getString(24);
                            String serial_no = rs3.getString(25);
                            String main_barcode = rs3.getString(26);
                            String brand = rs3.getString(27);
                            String brand_id = rs3.getString(28);
                            String model = rs3.getString(29);
                            String model_id = rs3.getString(30);
                            int status = rs3.getInt(31);
                            double previous_cost = rs3.getDouble(32);
                            String receipt_type_id = rs3.getString(33);
                            String branch = rs3.getString(34);
                            String branch_id = rs3.getString(35);
                            String location = rs3.getString(36);
                            String location_id = rs3.getString(37);

                            String transaction_type = "Receipts";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = FitIn.fmt_woc(qty);
                            String out = "";
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_id;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = user_name;
                            String customer_name = "";
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + receipt_no;
                            String cost1 = FitIn.fmt_wc_0(cost);
                            String price1 = "";
                            String months = DateType.convert_datetime_to_month(date_added);

                            Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_branch, from_branch_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                            if (status == 1) {
                                receipts.add(field);
                            }

                        }

                        //</editor-fold>
                        //<editor-fold defaultstate="collapsed" desc=" Transfers ">
                        List<Srpt_item_ledger.field> transfer_in = new ArrayList();
                        List<Srpt_item_ledger.field> transfer_out = new ArrayList();
                        String s4 = "select "
                                + "id"
                                + ",barcode"
                                + ",description"
                                + ",generic_name"
                                + ",category"
                                + ",category_id"
                                + ",classification"
                                + ",classification_id"
                                + ",sub_classification"
                                + ",sub_classification_id"
                                + ",product_qty"
                                + ",unit"
                                + ",conversion"
                                + ",selling_price"
                                + ",date_added"
                                + ",user_name"
                                + ",item_type"
                                + ",status"
                                + ",supplier"
                                + ",fixed_price"
                                + ",cost"
                                + ",supplier_id"
                                + ",multi_level_pricing"
                                + ",vatable"
                                + ",reorder_level"
                                + ",markup"
                                + ",barcodes"
                                + ",brand"
                                + ",brand_id"
                                + ",model"
                                + ",model_id"
                                + ",selling_type"
                                + ",branch"
                                + ",branch_code"
                                + ",location"
                                + ",location_id"
                                + ",stock_transfer_id"
                                + ",serial_no"
                                + ",to_branch"
                                + ",to_branch_id"
                                + ",to_location"
                                + ",to_location_id"
                                + " from stock_transfers_items"
                                + " " + where3;

                        Statement stmt4 = conn.createStatement();
                        ResultSet rs4 = stmt4.executeQuery(s4);
                        while (rs4.next()) {
                            int id = rs4.getInt(1);
                            String barcode = rs4.getString(2);
                            String description = rs4.getString(3);
                            String generic_name = rs4.getString(4);
                            String category = rs4.getString(5);
                            String category_id = rs4.getString(6);
                            String classification = rs4.getString(7);
                            String classification_id = rs4.getString(8);
                            String sub_classification = rs4.getString(9);
                            String sub_classification_id = rs4.getString(10);
                            double product_qty = rs4.getDouble(11);
                            String unit = rs4.getString(12);
                            double conversion = rs4.getDouble(13);
                            double selling_price = rs4.getDouble(14);
                            String date_added = rs4.getString(15);
                            String user_name = rs4.getString(16);
                            String item_type = rs4.getString(17);
                            int status = rs4.getInt(18);
                            String supplier = rs4.getString(19);
                            int fixed_price = rs4.getInt(20);
                            double cost = rs4.getDouble(21);
                            String supplier_id = rs4.getString(22);
                            int multi_level_pricing = rs4.getInt(23);
                            int vatable = rs4.getInt(24);
                            double reorder_level = rs4.getDouble(25);
                            double markup = rs4.getDouble(26);
                            String barcodes = rs4.getString(27);
                            String brand = rs4.getString(28);
                            String brand_id = rs4.getString(29);
                            String model = rs4.getString(30);
                            String model_id = rs4.getString(31);
                            int selling_type = rs4.getInt(32);
                            String branch = rs4.getString(33);
                            String branch_code = rs4.getString(34);
                            String location = rs4.getString(35);
                            String location_id = rs4.getString(36);
                            String stock_transfer_id = rs4.getString(37);
                            String serial_no = rs4.getString(38);
                            String to_branch = rs4.getString(39);
                            String to_branch_id = rs4.getString(40);
                            String to_location = rs4.getString(41);
                            String to_location_id = rs4.getString(42);

                            String transaction_type = "Transfer";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = FitIn.fmt_woc(product_qty);
                            String out = "";
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_code;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch1 = "";
                            String to_branch_id1 = "";
                            String to_location1 = "";
                            String to_location_id1 = "";
                            String created_by = user_name;
                            String customer_name = "";
                            Date created = new Date();

                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            String transaction_no = "" + stock_transfer_id;
                            String cost1 = FitIn.fmt_wc_0(cost);
                            String price1 = "";
                            String months = DateType.convert_datetime_to_month(date_added);
                            Srpt_item_ledger.field field_out = new Srpt_item_ledger.field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);

                            Srpt_item_ledger.field field_in = new Srpt_item_ledger.field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);

                            if (status == 1) {

                                if (lo.getId().equalsIgnoreCase(to_location_id)) {
                                    transfer_in.add(field_in);
                                }

                                if (lo.getId().equalsIgnoreCase(location_id)) {
                                    transfer_out.add(field_out);
                                }

                            }
                        }

                        transfers.addAll(transfer_in);
                        transfers.addAll(transfer_out);

                        //</editor-fold>
                        //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
                        List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
                        List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();
                        String s5 = "select "
                                + "id"
                                + ",item_code"
                                + ",barcode"
                                + ",description"
                                + ",qty"
                                + ",new_qty"
                                + ",is_add"
                                + ",date_added"
                                + ",status"
                                + ",user_id"
                                + ",user_screen_name"
                                + ",branch"
                                + ",branch_id"
                                + ",location"
                                + ",location_id"
                                + " from adjustments"
                                + " " + where;

                        Statement stmt5 = conn.createStatement();
                        ResultSet rs5 = stmt5.executeQuery(s5);
                        while (rs5.next()) {
                            int id = rs5.getInt(1);
                            String item_code = rs5.getString(2);
                            String barcode = rs5.getString(3);
                            String description = rs5.getString(4);
                            double qty = rs5.getDouble(5);
                            double new_qty = rs5.getDouble(6);
                            int is_add = rs5.getInt(7);
                            String date_added = rs5.getString(8);
                            int status = rs5.getInt(9);
                            String user_id = rs5.getString(10);
                            String user_screen_name = rs5.getString(11);
                            String branch = rs5.getString(12);
                            String branch_id = rs5.getString(13);
                            String location = rs5.getString(14);
                            String location_id = rs5.getString(15);

                            String transaction_type = "Adjustment";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = FitIn.fmt_woc(new_qty);
                            String out = "";
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_id;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = user_screen_name;
                            String customer_name = "";
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + id;
                            String cost1 = "";
                            String price1 = "";
                            String months = DateType.convert_datetime_to_month(date_added);
                            if (is_add == 1) {
                                Srpt_item_ledger.field add = new Srpt_item_ledger.field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                                adjustment_add.add(add);
                            } else {
                                Srpt_item_ledger.field deduct = new Srpt_item_ledger.field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                                adjustment_deduct.add(deduct);
                            }

                        }
                        adjustments.addAll(adjustment_add);
                        adjustments.addAll(adjustment_deduct);

                        //</editor-fold>
                        //<editor-fold defaultstate="collapsed" desc=" Return Exchange ">
                        String s6 = "select "
                                + "id"
                                + ",sales_no"
                                + ",item_code"
                                + ",barcode"
                                + ",description"
                                + ",generic_name"
                                + ",item_type"
                                + ",supplier_name"
                                + ",supplier_id"
                                + ",serial_no"
                                + ",product_qty"
                                + ",unit"
                                + ",conversion"
                                + ",selling_price"
                                + ",date_added"
                                + ",user_id"
                                + ",user_screen_name"
                                + ",status"
                                + ",is_vatable"
                                + ",selling_type"
                                + ",discount_name"
                                + ",discount_rate"
                                + ",discount_amount"
                                + ",discount_customer_name"
                                + ",discount_customer_id"
                                + ",branch"
                                + ",branch_code"
                                + ",location"
                                + ",location_id"
                                + ",category"
                                + ",category_id"
                                + ",classification"
                                + ",classification_id"
                                + ",sub_classification"
                                + ",sub_classification_id"
                                + ",brand"
                                + ",brand_id"
                                + ",model"
                                + ",model_id"
                                + ",is_replacement"
                                + " from sale_item_replacements"
                                + " " + where;
                        Statement stmt6 = conn.createStatement();
                        ResultSet rs6 = stmt6.executeQuery(s6);
                        while (rs6.next()) {
                            int id = rs6.getInt(1);
                            String sales_no = rs6.getString(2);
                            String item_code = rs6.getString(3);
                            String barcode = rs6.getString(4);
                            String description = rs6.getString(5);
                            String generic_name = rs6.getString(6);
                            String item_type = rs6.getString(7);
                            String supplier_name = rs6.getString(8);
                            String supplier_id = rs6.getString(9);
                            String serial_no = rs6.getString(10);
                            double product_qty = rs6.getDouble(11);
                            String unit = rs6.getString(12);
                            double conversion = rs6.getDouble(13);
                            double selling_price = rs6.getDouble(14);
                            String date_added = rs6.getString(15);
                            String user_id = rs6.getString(16);
                            String user_screen_name = rs6.getString(17);
                            int status = rs6.getInt(18);
                            int is_vatable = rs6.getInt(19);
                            int selling_type = rs6.getInt(20);
                            String discount_name = rs6.getString(21);
                            double discount_rate = rs6.getDouble(22);
                            double discount_amount = rs6.getDouble(23);
                            String discount_customer_name = rs6.getString(24);
                            String discount_customer_id = rs6.getString(25);
                            String branch = rs6.getString(26);
                            String branch_code = rs6.getString(27);
                            String location = rs6.getString(28);
                            String location_id = rs6.getString(29);
                            String category = rs6.getString(30);
                            String category_id = rs6.getString(31);
                            String classification = rs6.getString(32);
                            String classification_id = rs6.getString(33);
                            String sub_classification = rs6.getString(34);
                            String sub_classification_id = rs6.getString(35);
                            String brand = rs6.getString(36);
                            String brand_id = rs6.getString(37);
                            String model = rs6.getString(38);
                            String model_id = rs6.getString(39);
                            int is_replacement = rs6.getInt(40);

                            String transaction_type = "Exc-Replacement";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = "";
                            String out = FitIn.fmt_woc(product_qty);
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_code;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = user_screen_name;
                            String customer_name = "";
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + sales_no;
                            String cost1 = "";
                            String price1 = FitIn.fmt_wc_0(selling_price);
                            if (is_replacement == 0) {
                                transaction_type = "Exc-Returned";
                                in = FitIn.fmt_woc(product_qty);
                                out = "";

                                String s100 = "select "
                                        + " date_added "
                                        + " from sales "
                                        + " where sales_no='" + sales_no + "' ";

                                Statement stmt100 = conn.createStatement();
                                ResultSet rs100 = stmt100.executeQuery(s100);
                                String date_added1 = "";
                                if (rs100.next()) {
                                    date_added1 = rs100.getString(1);
                                }
                                String months1 = POS.util.DateType.convert_slash_datetime3(date_added1);

                                String months = DateType.convert_datetime_to_month(date_added);
                                Srpt_item_ledger.field field1 = new Srpt_item_ledger.field("Sales", months1, "", in, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                                return_exchange.add(field1);

                                Srpt_item_ledger.field field11 = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, "" + id, cost1, price1, months);
                                return_exchange.add(field11);
                            }

                        }
                        //</editor-fold>
                        //<editor-fold defaultstate="collapsed" desc=" Charge in Advance ">
                        String s7 = "select "
                                + "id"
                                + ",customer_id"
                                + ",customer_name"
                                + ",ar_id"
                                + ",ar_no"
                                + ",date_applied"
                                + ",reference_no"
                                + ",soa_type"
                                + ",soa_type_id"
                                + ",user_screen_name"
                                + ",user_id"
                                + ",remarks"
                                + ",item_code"
                                + ",barcode"
                                + ",description"
                                + ",generic_name"
                                + ",item_type"
                                + ",supplier_name"
                                + ",supplier_id"
                                + ",serial_no"
                                + ",product_qty"
                                + ",unit"
                                + ",conversion"
                                + ",selling_price"
                                + ",date_added"
                                + ",status"
                                + ",is_vatable"
                                + ",selling_type"
                                + ",discount_name"
                                + ",discount_rate"
                                + ",discount_amount"
                                + ",discount_customer_name"
                                + ",discount_customer_id"
                                + ",branch"
                                + ",branch_code"
                                + ",location"
                                + ",location_id"
                                + ",category"
                                + ",category_id"
                                + ",classification"
                                + ",classification_id"
                                + ",sub_classification"
                                + ",sub_classification_id"
                                + ",brand"
                                + ",brand_id"
                                + ",model"
                                + ",model_id"
                                + ",addtl_amount"
                                + ",wtax"
                                + " from charge_in_advance_items"
                                + " " + where;

                        Statement stmt7 = conn.createStatement();
                        ResultSet rs7 = stmt7.executeQuery(s7);
                        while (rs7.next()) {
                            int id = rs7.getInt(1);
                            String customer_id = rs7.getString(2);
                            String customer_name = rs7.getString(3);
                            String ar_id = rs7.getString(4);
                            String ar_no = rs7.getString(5);
                            String date_applied = rs7.getString(6);
                            String reference_no = rs7.getString(7);
                            String soa_type = rs7.getString(8);
                            String soa_type_id = rs7.getString(9);
                            String user_screen_name = rs7.getString(10);
                            String user_id = rs7.getString(11);
                            String remarks = rs7.getString(12);
                            String item_code = rs7.getString(13);
                            String barcode = rs7.getString(14);
                            String description = rs7.getString(15);
                            String generic_name = rs7.getString(16);
                            String item_type = rs7.getString(17);
                            String supplier_name = rs7.getString(18);
                            String supplier_id = rs7.getString(19);
                            String serial_no = rs7.getString(20);
                            double product_qty = rs7.getDouble(21);
                            String unit = rs7.getString(22);
                            double conversion = rs7.getDouble(23);
                            double selling_price = rs7.getDouble(24);
                            String date_added = rs7.getString(25);
                            int status = rs7.getInt(26);
                            int is_vatable = rs7.getInt(27);
                            int selling_type = rs7.getInt(28);
                            String discount_name = rs7.getString(29);
                            double discount_rate = rs7.getDouble(30);
                            double discount_amount = rs7.getDouble(31);
                            String discount_customer_name = rs7.getString(32);
                            String discount_customer_id = rs7.getString(33);
                            String branch = rs7.getString(34);
                            String branch_code = rs7.getString(35);
                            String location = rs7.getString(36);
                            String location_id = rs7.getString(37);
                            String category = rs7.getString(38);
                            String category_id = rs7.getString(39);
                            String classification = rs7.getString(40);
                            String classification_id = rs7.getString(41);
                            String sub_classification = rs7.getString(42);
                            String sub_classification_id = rs7.getString(43);
                            String brand = rs7.getString(44);
                            String brand_id = rs7.getString(45);
                            String model = rs7.getString(46);
                            String model_id = rs7.getString(47);
                            double addtl_amount = rs7.getDouble(48);
                            double wtax = rs7.getDouble(49);

                            String transaction_type = "Charge in Advance[-]";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = "";
                            String out = FitIn.fmt_woc(product_qty);
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_code;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = user_screen_name;
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + ar_no;
                            String cost1 = "";
                            String price1 = FitIn.fmt_wc_0(selling_price);
                            String months = DateType.convert_datetime_to_month(date_added);

                            if (status == 0) {
                                Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                                charge_in_advance.add(field);
                            } else {
                                Srpt_item_ledger.field field = new Srpt_item_ledger.field("Charge in Advance[+]", date, out, "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                                charge_in_advance.add(field);
                            }

                        }
                        //</editor-fold>
                        //<editor-fold defaultstate="collapsed" desc=" Replenishment ">
                        String s9 = "select "
                                + "id"
                                + ",inventory_replenishment_no"
                                + ",item_code"
                                + ",barcode"
                                + ",description"
                                + ",product_qty"
                                + ",unit"
                                + ",conversion"
                                + ",selling_price"
                                + ",date_added"
                                + ",user_id"
                                + ",user_screen_name"
                                + ",status"
                                + ",branch"
                                + ",branch_id"
                                + ",location"
                                + ",location_id"
                                + " from inventory_replenishment_items"
                                + " " + wheree;

                        Statement stmt9 = conn.createStatement();
                        ResultSet rs9 = stmt9.executeQuery(s9);
                        while (rs9.next()) {
                            int id = rs9.getInt(1);
                            String inventory_replenishment_no = rs9.getString(2);
                            String item_code = rs9.getString(3);
                            String barcode = rs9.getString(4);
                            String description = rs9.getString(5);
                            double product_qty = rs9.getDouble(6);
                            String unit = rs9.getString(7);
                            double conversion = rs9.getDouble(8);
                            double selling_price = rs9.getDouble(9);
                            String date_added = rs9.getString(10);
                            String user_id = rs9.getString(11);
                            String user_screen_name = rs9.getString(12);
                            int status = rs9.getInt(13);
                            String branch = rs9.getString(14);
                            String branch_id = rs9.getString(15);
                            String location = rs9.getString(16);
                            String location_id = rs9.getString(17);

                            String transaction_type = "Replenishment";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = "";
                            String out = FitIn.fmt_woc(product_qty);

                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_id;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = user_screen_name;
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + inventory_replenishment_no;
                            String cost1 = "";
                            String price1 = FitIn.fmt_wc_0(selling_price);
                            String months = DateType.convert_datetime_to_month(date_added);
                            Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, user_screen_name, created, transaction_no, cost1, price1, months);
                            replenishments.add(field);
                        }
                        //</editor-fold>
                        //<editor-fold defaultstate="collapsed" desc=" Requisition Slip ">
                        String s10 = "select "
                                + "id"
                                + ",requisition_slip_no"
                                + ",requisition_date"
                                + ",requisition_type"
                                + ",requisition_department"
                                + ",requisition_department_id"
                                + ",requested_by"
                                + ",item_code"
                                + ",barcode"
                                + ",description"
                                + ",product_qty"
                                + ",unit"
                                + ",cost"
                                + ",selling_price"
                                + ",branch"
                                + ",branch_id"
                                + ",location"
                                + ",location_id"
                                + ",date_added"
                                + ",status"
                                + " from requisition_slip_items"
                                + " " + wheree;

                        Statement stmt10 = conn.createStatement();
                        ResultSet rs10 = stmt10.executeQuery(s10);
                        while (rs10.next()) {
                            int id = rs10.getInt(1);
                            String requisition_slip_no = rs10.getString(2);
                            String requisition_date = rs10.getString(3);
                            String requisition_type = rs10.getString(4);
                            String requisition_department = rs10.getString(5);
                            String requisition_department_id = rs10.getString(6);
                            String requested_by = rs10.getString(7);
                            String item_code = rs10.getString(8);
                            String barcode = rs10.getString(9);
                            String description = rs10.getString(10);
                            double product_qty = rs10.getDouble(11);
                            String unit = rs10.getString(12);
                            double cost = rs10.getDouble(13);
                            double selling_price = rs10.getDouble(14);
                            String branch = rs10.getString(15);
                            String branch_id = rs10.getString(16);
                            String location = rs10.getString(17);
                            String location_id = rs10.getString(18);
                            String date_added = rs10.getString(19);
                            int status = rs10.getInt(20);

                            String transaction_type = "Sales";
                            String date = POS.util.DateType.convert_slash_datetime3(date_added);
                            String in = "";
                            String out = FitIn.fmt_woc(product_qty);
                            String balance = "";
                            String from_branch = branch;
                            String from_branch_id = branch_id;
                            String from_location = location;
                            String from_location_id = location_id;
                            String to_branch = "";
                            String to_branch_id = "";
                            String to_location = "";
                            String to_location_id = "";
                            String created_by = requested_by;
                            String customer_name = "";
                            Date created = new Date();
                            try {
                                created = POS.util.DateType.datetime.parse(date_added);
                            } catch (ParseException ex) {
                                Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String transaction_no = "" + requisition_slip_no;
                            String cost1 = "";
                            String price1 = FitIn.fmt_wc_0(selling_price);
                            String months = DateType.convert_datetime_to_month(date_added);
                            if (status == 1) {
                                Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Requisition Slip", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months);
                                requistion_slips.add(field2);
                            }
                        }
                        //</editor-fold>

                        fields.addAll(inventory_count);
                        fields.addAll(sales);
                        fields.addAll(receipts);
                        fields.addAll(transfers);
                        fields.addAll(adjustments);
                        fields.addAll(return_exchange);
                        fields.addAll(charge_in_advance);
                        fields.addAll(charge_in_advance_cancelled);
                        fields.addAll(replenishments);
                        fields.addAll(requistion_slips);

                        List<Srpt_item_ledger.field> f_field = new ArrayList();

                        Collections.sort(fields, new Comparator<Srpt_item_ledger.field>() {
                            @Override
                            public int compare(Srpt_item_ledger.field o1, Srpt_item_ledger.field o2) {
                                return o1.getDate_added().compareTo(o2.getDate_added());
                            }
                        });

                        double running_balance = 0;
                        double qty = 0;
                        for (Srpt_item_ledger.field f : fields) {
                            if (FitIn.toDouble(f.getIn()) > 0) {
                                qty += FitIn.toDouble(f.getIn());
                            } else {
                                qty -= FitIn.toDouble(f.getOut());
                            }
                            if (f.transaction_type.equalsIgnoreCase("Replenishment")) {
                                qty = 0;
                            }
                            f.setFrom_branch(my_branch);
                            f.setFrom_location(my_location);
                            f.setBalance(FitIn.fmt_woc(qty));
                            field3.add(f);
                        }

                        List<Srpt_item_ledger.field> fields2 = new ArrayList();
                        String jrxml = "rpt_inventory_ledger.jrxml";
//                for (Srpt_item_ledger.field to2 : field3) {
//                    String m = DateType.m1.format(to2.date_added);
//                    String y = DateType.y.format(to2.date_added);
//                    if (year.equals(y) && jCheckBox3.isSelected()) {
//                        fields2.add(to2);
//                        running_balance = FitIn.toDouble(to2.getBalance());
//                    }
//                    if (year.equals(y) && !jCheckBox3.isSelected()) {
//                        if (month.equalsIgnoreCase(m)) {
//                            fields2.add(to2);
//                            running_balance = FitIn.toDouble(to2.getBalance());
//                        }
//                    }
//                }
                        for (Srpt_item_ledger.field to2 : field3) {
                            fields2.add(to2);
                            running_balance = FitIn.toDouble(to2.getBalance());
                        }

                        if (running_balance != inv.product_qty) {
                            System.out.println("Item Code: " + inv.main_barcode + ", Inv: " + inv.product_qty + " | Ledger: " + running_balance);
                            String s44 = "update inventory_barcodes set "
                                    + " product_qty='" + running_balance + "'"
                                    + " where  main_barcode= '" + inv.main_barcode + "' and location_id='" + locatio_id + "' "
                                    + "";
                            PreparedStatement stmt44 = conn.prepareStatement(s44);
                            stmt44.execute();
                        }

//                String business_name = System.getProperty("business_name", "Algorithm Computer Services");
//                String contact_no = System.getProperty("telephone_number", "");
//                String address = System.getProperty("address", "Dumaguete City");
//                String date = "" + jYearChooser1.getYear();
//                String item_code = my_item_code;
//                String barcode = my_barcode;
//                String description = my_description;
//                String branch = "All";
//                String location = tf_branch_location.getText();
//                List<Srpt_item_ledger.field> field4 = new ArrayList();
//                int m = jMonthChooser1.getMonth();
//                String[] mm = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//
//                Srpt_item_ledger rpt = new Srpt_item_ledger(business_name, address, contact_no, date, item_code, barcode, description, branch, location, mm[m], running_balance);
//                rpt.fields.addAll(fields2);
//                report_sales_items(rpt, jrxml);
//                InputStream is = Srpt_item_ledger.class.getResourceAsStream(jrxml);
//                try {
//                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
//
//                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
//
//                } catch (JRException ex) {
//                    Logger.getLogger(Dlg_report_items.class.getName()).log(Level.SEVERE, null, ex);
//                }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } finally {
                        MyConnection.close();
                    }

//                
                }

                Button.Search search = (Button.Search) jButton1;
                search.finish();
                tf_search.setEnabled(true);
                tf_search.grabFocus();
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
                System.out.println("Done...");
            }
        });
        t.start();
    }

    private void report_sales_items(final Srpt_item_ledger to, String jrxml_name) {
        pnl_report.removeAll();
        pnl_report.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_expenses(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report.add(viewer);
            pnl_report.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_expenses(Srpt_item_ledger to, String rpt_name) {
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
            InputStream is = Srpt_item_ledger.class.getResourceAsStream(jrxml);
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

    private void inventory_count() {
        Window p = (Window) this;
        Dlg_report_item_ledger_inv_count nd = Dlg_report_item_ledger_inv_count.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_report_item_ledger_inv_count.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_ledger_inv_count.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void receipts() {
        Window p = (Window) this;
        Dlg_report_item_ledger_receipts nd = Dlg_report_item_ledger_receipts.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_report_item_ledger_receipts.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_ledger_receipts.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void sales() {
        Window p = (Window) this;
        Dlg_report_item_ledger_sales nd = Dlg_report_item_ledger_sales.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_report_item_ledger_sales.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_ledger_sales.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void charge_in_advance() {
        Window p = (Window) this;
        Dlg_report_item_ledger_charge_in_advance nd = Dlg_report_item_ledger_charge_in_advance.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_report_item_ledger_charge_in_advance.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_ledger_charge_in_advance.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void transfers() {
        Window p = (Window) this;
        Dlg_report_item_ledger_transfers nd = Dlg_report_item_ledger_transfers.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_report_item_ledger_transfers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_ledger_transfers.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void adjustments() {
        Window p = (Window) this;
        Dlg_report_item_ledger_adjustments nd = Dlg_report_item_ledger_adjustments.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_report_item_ledger_adjustments.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_ledger_adjustments.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void replacements() {
        Window p = (Window) this;
        Dlg_report_item_ledger_replacements nd = Dlg_report_item_ledger_replacements.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_report_item_ledger_replacements.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_report_item_ledger_replacements.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
