/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.util.Alert;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
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
 * @author Ronescape
 */
public class Dlg_touchscreen_serial_numbers extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_serial_numbers
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

        public final String serial;

        public OutputData(String serial) {
            this.serial = serial;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_serial_numbers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_serial_numbers(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_serial_numbers() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_serial_numbers myRef;

    private void setThisRef(Dlg_touchscreen_serial_numbers myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_serial_numbers> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_serial_numbers create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_serial_numbers create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_serial_numbers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_serial_numbers((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_serial_numbers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_serial_numbers((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_serial_numbers dialog = Dlg_touchscreen_serial_numbers.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_posts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_posts2 = new javax.swing.JTable();
        tf_amount = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available Serials", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_posts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_posts.setFocusable(false);
        tbl_posts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_postsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_posts);

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Scan Serial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_posts2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_posts2.setFocusable(false);
        tbl_posts2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_posts2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_posts2);

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel3.setText("Serials Added:");

        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_amount)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        enter_serial();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tbl_postsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_postsMouseClicked
        select_serial();
    }//GEN-LAST:event_tbl_postsMouseClicked

    private void tbl_posts2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_posts2MouseClicked
        select_item();
    }//GEN-LAST:event_tbl_posts2MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_posts;
    private javax.swing.JTable tbl_posts2;
    private javax.swing.JTextField tf_amount;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_posts(tbl_posts);
        init_tbl_posts2(tbl_posts2);
//        dummy_serial();
        tf_amount.grabFocus();
    }

    private void dummy_serial() {
        String serials = "9QG9CA69\n"
                + "0QGA1AXJ\n"
                + "9QGA26LX\n"
                + "9QGADGJC\n"
                + "9QGAAEGT\n"
                + "9QG8NT6T\n"
                + "9QG8NT75\n"
                + "9QG83W35\n"
                + "9QG8RWXL\n"
                + "5QG15K82\n"
                + "9QGA4T89\n"
                + "9QG942Y3\n"
                + "5QG2S9KY\n"
                + "9QGA80F2\n"
                + "9QG9QSVY\n"
                + "9QGA91J5\n"
                + "9QGA5W7Y\n"
                + "9QGA7M5A\n"
                + "9QG9KA0A\n"
                + "9QGA60KV\n"
                + "9QGA03XM\n"
                + "9QGA1FY6\n"
                + "5QG2KQ75\n"
                + "5QG2M6KC\n"
                + "5QG2P65S\n"
                + "5QG2CJF3\n"
                + "5QG2E8E6\n"
                + "9QGABER4\n"
                + "5QG2P5MQ\n"
                + "9QG9PXK7\n"
                + "5QG2YB0Q\n"
                + "9QGA1W3N\n"
                + "9QGA3BV0\n"
                + "9QGA2PGM\n"
                + "9QGA2N7S\n"
                + "9QG95RKN\n"
                + "5QG2ZAAR\n"
                + "9QG9QZ47\n"
                + "5QG2P3J0\n"
                + "9QGA6DAT\n"
                + "\n"
                + "9QG9A9NF\n"
                + "9QGA5WKR\n"
                + "9QGA1W9E\n"
                + "5QG2T1NF\n"
                + "9QGA33LA\n"
                + "9QGA3E7Y\n"
                + "9QG9F2V9\n"
                + "9QGA4TWA\n"
                + "9QG8Y8KA\n"
                + "5QG2NW16\n"
                + "5QG2CPWC\n"
                + "9QG99W8Z\n"
                + "9QG8Y15Q\n"
                + "9QGA0691\n"
                + "9QGA7NHG\n"
                + "9QGADG0E\n"
                + "9QG9ZLHE\n"
                + "9QG9VK96\n"
                + "9QGA3ENW\n"
                + "9QG9PXEQ\n"
                + "9QGA7509\n"
                + "9QG93GBH\n"
                + "9QGA2QWM\n"
                + "9QG8DHPC\n"
                + "9QGA34EV\n"
                + "9QG91L1A\n"
                + "9QGAAEZK\n"
                + "9QG8PH01\n"
                + "9QG8Z2YF\n"
                + "5QG2PJG1\n"
                + "9QG9TYAH\n"
                + "9QGA4V4W\n"
                + "9QG9XY5H\n"
                + "5QG2G7E6\n"
                + "9QGA5BX3\n"
                + "9QG9TBQL\n"
                + "5QG2NB7J\n"
                + "5QG2KANH\n"
                + "9QG966BD\n"
                + "9QGA35KJ\n"
                + "9QGA4WA1\n"
                + "5QG2LAAJ\n"
                + "9QGA2NXN\n"
                + "5QG2VYHK\n"
                + "9QG9411Q\n"
                + "9QGA5VHS\n"
                + "9QG8VM5Q\n"
                + "9QG9THW1\n"
                + "9QGA8ZGH\n"
                + "9QGA8KXL\n"
                + "5QG2KQD9\n"
                + "5QG2VXEE\n"
                + "9QGADWV2\n"
                + "9QGADB47\n"
                + "9QG9X18B\n"
                + "9QG9K47C\n"
                + "9QGAE8ND\n"
                + "9QGACP03\n"
                + "9QG8Z34D\n"
                + "9QGA99LZ";

    }

    public void do_pass2_edit(String added_serials, String list_of_serials2) {

        String[] ser = added_serials.split(", ");
        String[] ser2 = list_of_serials2.split("\n");
        List<serial> acc = new ArrayList();
        for (String s : ser) {
            serial seri = new serial(s, false);
            acc.add(seri);
        }

        //list_of_serials2
        List<serial> acc2 = new ArrayList();
        for (String s : ser2) {
            serial seri = new serial(s, false);
            acc2.add(seri);
        }
        //recheck added serials

        for (serial add : acc) {
            int exists = 0;
            for (serial list : acc2) {
                if (list.serial.equalsIgnoreCase(add.serial)) {
                    exists = 1;
                    list.setSelected(true);
                    tbl_posts_M.fireTableDataChanged();
                    break;
                }
            }
        }

        if (!added_serials.isEmpty()) {
            loadData_posts2(acc);
            jLabel2.setText("" + acc.size());
        }
        if (!list_of_serials2.isEmpty()) {
            loadData_posts(acc2);
            jLabel4.setText("" + acc2.size());
        }

        tf_amount.grabFocus();
    }

    public void do_pass(String serials) {
        String[] ser = serials.split("\n");

        List<serial> acc = new ArrayList();
        for (String s : ser) {
            serial seri = new serial(s, false);
            acc.add(seri);
        }
        loadData_posts(acc);
        jLabel2.setText("" + acc.size());
        tf_amount.grabFocus();
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
        tf_amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_posts_ALM2.isEmpty()) {
                        tbl_posts2.setRowSelectionInterval(0, 0);
                        tbl_posts2.setFocusable(true);
                        tbl_posts2.grabFocus();
                    }
                }

            }
        });

        tbl_posts2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    tf_amount.grabFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    select_item();
                    tf_amount.grabFocus();
                    tbl_posts2.setFocusable(false);
                }
            }
        });
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" table "> 
    public static ArrayListModel tbl_posts_ALM;
    public static TblpostsModel tbl_posts_M;

    public static void init_tbl_posts(JTable tbl_posts) {
        tbl_posts_ALM = new ArrayListModel();
        tbl_posts_M = new TblpostsModel(tbl_posts_ALM);
        tbl_posts.setModel(tbl_posts_M);
        tbl_posts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_posts.setRowHeight(25);
        int[] tbl_widths_posts = {100, 30};
        for (int i = 0, n = tbl_widths_posts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_posts, i, tbl_widths_posts[i]);
        }
        Dimension d = tbl_posts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_posts.getTableHeader().setPreferredSize(d);
        tbl_posts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_posts.setRowHeight(25);
        tbl_posts.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_posts.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
    }

    public static class serial {

        public final String serial;
        public boolean selected;

        public serial(String serial, boolean selected) {
            this.serial = serial;
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void loadData_posts(List<serial> acc) {
        tbl_posts_ALM.clear();
        tbl_posts_ALM.addAll(acc);
    }

    public static class TblpostsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Serial", ""
        };

        public TblpostsModel(ListModel listmodel) {
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
            if (col == 100) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            serial tt = (serial) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.serial;
                case 1:

                    if (tt.selected) {
                        return "/POS/icon_inventory/checked.png";
                    } else {
                        return "/POS/icon_inventory/remove11.png";
                    }

                default:
                    return " ";
            }
        }
    }

    private void select_serial() {
        int row = tbl_posts.getSelectedRow();
        if (row < 0) {
            return;
        }
        serial to = (serial) tbl_posts_ALM.get(row);

        List<serial> added = tbl_posts_ALM2;
        int exists = 0;
        String serial_no = to.serial;
        for (serial s : added) {
            if (s.serial.equalsIgnoreCase(serial_no)) {
                exists = 1;
                break;
            }
        }
        if (exists == 1) {
            Alert.set(0, "Serial already selected!");

        } else {
            to.setSelected(true);
            tbl_posts_ALM2.add(to);
            tbl_posts_M.fireTableDataChanged();
        }
        count_serials_added();

    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" table "> 
    public static ArrayListModel tbl_posts_ALM2;
    public static TblpostsModel2 tbl_posts_M2;

    public static void init_tbl_posts2(JTable tbl_posts) {
        tbl_posts_ALM2 = new ArrayListModel();
        tbl_posts_M2 = new TblpostsModel2(tbl_posts_ALM2);
        tbl_posts.setModel(tbl_posts_M2);
        tbl_posts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_posts.setRowHeight(25);
        int[] tbl_widths_posts = {100, 0};
        for (int i = 0, n = tbl_widths_posts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_posts, i, tbl_widths_posts[i]);
        }
        Dimension d = tbl_posts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_posts.getTableHeader().setPreferredSize(d);
        tbl_posts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_posts.setRowHeight(25);
        tbl_posts.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_posts.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_posts2(List<serial> acc) {
        tbl_posts_ALM2.clear();
        tbl_posts_ALM2.addAll(acc);
    }

    public static class TblpostsModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Serial", ""
        };

        public TblpostsModel2(ListModel listmodel) {
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
            if (col == 100) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            serial tt = (serial) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.serial;
                case 1:

                    if (tt.selected) {
                        return "/POS/icon_inventory/checked.png";
                    } else {
                        return "/POS/icon_inventory/remove11.png";
                    }

                default:
                    return " ";
            }
        }
    }

//</editor-fold> 
    private void enter_serial() {
        String serial_no = tf_amount.getText();
        List<serial> added = tbl_posts_ALM2;
        int exists = 0;
        for (serial s : added) {
            if (s.serial.equalsIgnoreCase(serial_no)) {
                exists = 1;
                break;
            }
        }
        if (exists == 1) {
            Alert.set(0, "Serial Already Added!");
            return;
        }
        List<serial> list = tbl_posts_ALM;
        int serial_exists = 0;
        for (serial s : list) {
            if (s.serial.equalsIgnoreCase(serial_no)) {
                s.setSelected(false);
                tbl_posts_M.fireTableDataChanged();
                tbl_posts_ALM2.add(s);
                serial_exists = 1;
                count_serials_added();
                break;
            }
        }
        if (serial_exists == 0) {
            Alert.set(0, "Serial does not exists!");
        }
    }

    private void select_item() {
        int row = tbl_posts2.getSelectedRow();
        if (row < 0) {
            return;
        }
        serial se = (serial) tbl_posts_ALM2.get(row);
        tbl_posts_ALM2.remove(row);
        List<serial> list = tbl_posts_ALM;
        for (serial s : list) {
            if (s.serial.equalsIgnoreCase(se.serial)) {
                s.setSelected(false);
                tbl_posts_M.fireTableDataChanged();
                count_serials_added();
                break;
            }
        }
    }

    private void count_serials_added() {
        List<serial> serials = tbl_posts_ALM2;
        jLabel4.setText("" + serials.size());
    }

    private void ok() {
        List<serial> serials = tbl_posts_ALM2;
        if (serials.isEmpty()) {
            Alert.set(0, "No serial/s selected!");
            return;
        }
        String added = "";
        int i = 0;
        for (serial s : serials) {

            if (i == 0) {
                added = s.serial;
            } else {
                added = added + ", " + s.serial;
            }
            i++;
        }
//        System.out.println("serial: " + added);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(added));
        }
    }
}
