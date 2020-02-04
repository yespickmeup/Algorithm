/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.cash_drawer.CashDrawer.to_cash_drawer;
import POS.users.MyUser;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.Focus_Fire;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_amount = new Field.Input();
        jButton1 = new Button.Warning();
        jButton2 = new Button.Success();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cashin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cashier Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Log-in:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("January 29, 2020 5:02 PM");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Log-out:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("January 29, 2020 8:02 PM");

        tf_amount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Amount:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tf_amount;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.setProperty("pool_db", "db_algorithm");
//        MyUser.setUser_id("1");
        init_key();
//        do_pass();

//        jLabel2.setText("Date: " + DateType.slash_w_time.format(new Date()));
    }

    int cash_drawer_id = 0;

    private void focus() {
        JTextField[] tf = {tf_amount};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    to_cash_drawer cd = null;

    public void do_pass(to_cash_drawer d) {

        jLabel6.setText(MyUser.getUser_screen_name());
        jButton2.setText("Continue");
        jButton1.setText("Logout");
        double amount = 0;
        String timein = "";
        String timeout = "";
        cd = d;
        amount = d.amount;
        cash_drawer_id = d.id;
        timein = DateType.convert_slash_datetime3(d.time_in);
        if (d.time_out != null) {
            timeout = DateType.convert_slash_datetime3(d.time_out);
        } else {
            jLabel4.setText("Not yet logged out");
            jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        }
        jLabel5.setText(timein);
        jLabel4.setText(timeout);
        tf_amount.setText(FitIn.fmt_wc_0(amount));

    }

    public void do_pass_new_login() {

        jLabel6.setText(MyUser.getUser_screen_name());
        jButton2.setText("Cancel");
        cash_drawer_id = 0;

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
                    int lock_session = 0;
                    CashDrawer.to_cash_drawer cd = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name, lock_session);
                    CashDrawer.insert_data(cd);

                }
                if (jButton2.getText().equalsIgnoreCase("Continue")) {
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
                    int lock_session = 0;
                    CashDrawer.to_cash_drawer cd = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name, lock_session);
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

        if (jButton1.getText().equalsIgnoreCase("Logout")) {
            
        } else {
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
            int lock_session = 0;
            CashDrawer.to_cash_drawer cd = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, expenses, ten, five, one, point_five, point_two_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name, lock_session);
            CashDrawer.insert_data(cd);
            if (callback != null) {
                callback.ok(new CloseDialog(this), new OutputData(amount));
            }
        }
    }

    private void closed() {
        if (callback != null) {
            callback.close(new CloseDialog(this), new OutputData(0));
        }

    }
}
