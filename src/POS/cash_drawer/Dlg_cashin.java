/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Maytopacka
 */
public class Dlg_cashin extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cashin
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void close(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final double amount;

        public OutputData(double amount) {
            this.amount = amount;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_cashin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_cashin(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_cashin() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_cashin myRef;

    private void setThisRef(Dlg_cashin myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cashin> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cashin create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cashin create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cashin dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashin((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_cashin dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashin((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_cashin dialog = Dlg_cashin.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
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

        jPanel3 = new javax.swing.JPanel();
        tf_amount = new Field.Input();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(104, 95, 84));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/cash_drawer/piggy12.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CASH IN");

        jButton1.setText("New Cashin");
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Date:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_amount, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        ok1();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jButton2.getText().equals("Cancel")) {
            disposed();
        } else {
            ok1();
        }


    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tf_amount;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_algorithm");
//        MyUser.setUser_id("1");
        init_key();
//        do_pass();

        jLabel2.setText("Date: " + DateType.slash_w_time.format(new Date()));
    }

    int cash_drawer_id = 0;

    private void focus() {
        JTextField[] tf = {tf_amount};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    public void do_pass() {
        String where = " where Date(time_in) = '" + DateType.sf.format(new Date()) + "' ";
        List<CashDrawer.to_cash_drawer> drawer = CashDrawer.ret_where(where);
        if (drawer.isEmpty()) {
            jButton2.setText("Cancel");
            cash_drawer_id = 0;
        } else {
            jButton2.setText("Update");
            double amount = 0;
            for (CashDrawer.to_cash_drawer d : drawer) {
                amount = d.amount;
                cash_drawer_id = d.id;
            }
            tf_amount.setText(FitIn.fmt_wc_0(amount));
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        closed();
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

    private void ok1() {
        final double amount = FitIn.toDouble(tf_amount.getText());
        if (amount < 0) {
            Alert.set(0, "ENTER AMOUNT");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                if (jButton2.getText().equalsIgnoreCase("Cancel")) {

                    int id = 0;
                    String session_no = "";
                    String user_name = MyUser.getUser_name();
                    String screen_name = MyUser.getUser_screen_name();
                    String time_in = DateType.now();
                    String time_out = null;

                    double cash_out = 0;
                    double thousand = 0;
                    double five_hundred = 0;
                    double two_hundred = 0;
                    double fifty = 0;
                    double twenty = 0;
                    double coins = 0;
                    double one_hundred = 0;
                    double expenses = 0;
                    double ten = 0;
                    double five = 0;
                    double one = 0;
                    double point_five = 0;
                    double point_two_five = 0;
                    double point_ten = 0;
                    double point_zero_five = 0;
                    String branch = MyUser.getBranch();
                    String branch_id = MyUser.getBranch_id();
                    String location = MyUser.getLocation();
                    String location_id = MyUser.getLocation_id();
                    String user_id = MyUser.getUser_id();
                    String user_screen_name = MyUser.getUser_screen_name();
                    CashDrawer.to_cash_drawer cd = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name);
                    CashDrawer.insert_data(cd);
                }
                if (jButton2.getText().equalsIgnoreCase("Update")) {
                    int id = 0;
                    String session_no = "";
                    String user_name = MyUser.getUser_name();
                    String screen_name = MyUser.getUser_screen_name();
                    String time_in = DateType.now();
                    String time_out = null;

                    double cash_out = 0;
                    double thousand = 0;
                    double five_hundred = 0;
                    double two_hundred = 0;
                    double fifty = 0;
                    double twenty = 0;
                    double coins = 0;
                    double one_hundred = 0;
                    double expenses = 0;
                    double ten = 0;
                    double five = 0;
                    double one = 0;
                    double point_five = 0;
                    double point_two_five = 0;
                    double point_ten = 0;
                    double point_zero_five = 0;
                    String branch = MyUser.getBranch();
                    String branch_id = MyUser.getBranch_id();
                    String location = MyUser.getLocation();
                    String location_id = MyUser.getLocation_id();
                    String user_id = MyUser.getUser_id();
                    String user_screen_name = MyUser.getUser_screen_name();
                    CashDrawer.to_cash_drawer cd = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name);
                    CashDrawer.update_drawer2(cd, "" + cash_drawer_id);
                }
                okay(amount);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void okay(double amount) {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(amount));
        }
    }

    private void ok2() {
        double amount = FitIn.toDouble(tf_amount.getText());
        if (amount < 0) {
            Alert.set(0, "ENTER AMOUNT");
            return;
        }

        int id = 0;
        String session_no = "";
        String user_name = MyUser.getUser_name();
        String screen_name = MyUser.getUser_screen_name();
        String time_in = DateType.now();
        String time_out = null;

        double cash_out = 0;
        double thousand = 0;
        double five_hundred = 0;
        double two_hundred = 0;
        double fifty = 0;
        double twenty = 0;
        double coins = 0;
        double one_hundred = 0;
        double expenses = 0;
        double ten = 0;
        double five = 0;
        double one = 0;
        double point_five = 0;
        double point_two_five = 0;
        double point_ten = 0;
        double point_zero_five = 0;
        String branch = MyUser.getBranch();
        String branch_id = MyUser.getBranch_id();
        String location = MyUser.getLocation();
        String location_id = MyUser.getLocation_id();
        String user_id = MyUser.getUser_id();
        String user_screen_name = MyUser.getUser_screen_name();
        CashDrawer.to_cash_drawer cd = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name);
        CashDrawer.insert_data(cd);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(amount));
        }
    }

    private void closed() {
        if (callback != null) {
            callback.close(new CloseDialog(this), new OutputData(0));
        }
    }
}
