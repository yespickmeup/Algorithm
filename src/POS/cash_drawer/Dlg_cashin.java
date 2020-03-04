/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.cash_drawer.CashDrawer.to_cash_drawer;
import POS.touchscreen.Dlg_logout_cashin;
import POS.users.MyUser;
import POS.users.S1_user_previleges;
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
import synsoftech.util.Center;

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
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cashin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 36))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cashier Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Log-in:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Log-out:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tf_amount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jButton1.setText("Logout");
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(16, 88, 197));
        jLabel8.setText("Press enter to continue");

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
                    .addComponent(tf_amount)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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
        logout_confirm();
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
    private javax.swing.JLabel jLabel8;
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
//        System.out.println("id: " + d.id);
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
        jLabel5.setText(" " + timein);
        jLabel4.setText(" " + timeout);

        tf_amount.setText(FitIn.fmt_wc_0(amount));

    }

    public void do_pass_new_login() {
        jLabel5.setText(DateType.slash_w_time.format(new Date()));
        jLabel6.setText(MyUser.getUser_screen_name());
        jButton2.setText("New Cashin");
        cash_drawer_id = 0;
        jButton1.setVisible(false);
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
                if (jButton2.getText().equalsIgnoreCase("New Cashin")) {

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

    private void closed() {
        if (callback != null) {
            callback.close(new CloseDialog(this), new OutputData(0));
        }

    }

    private void logout_confirm() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                logout();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void logout() {
        String where = " where user_id='" + MyUser.getUser_id() + "' and previledge like '%" + "Sales" + "%' "
                + " or user_id='" + MyUser.getUser_id() + "' and previledge  like '%" + "Sales (Choose Location)" + "%'"
                + " order by previledge asc";
        String where2 = " where user_id='" + MyUser.getUser_id() + "' order by id desc limit 1 ";
        List<S1_cash_drawer.to_cash_drawer> drawers = S1_cash_drawer.ret_where(where2);
        if (drawers.isEmpty()) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    System.exit(1);
                }
            });
            Center.setCenter(nd);
            nd.setVisible(true);
        } else {
            final S1_cash_drawer.to_cash_drawer drawer = drawers.get(0);
            List<S1_user_previleges.to_user_previleges> datas = S1_user_previleges.ret_data(where);
            if (!datas.isEmpty()) {
                Window p = (Window) this;
                Dlg_logout_cashin nd = Dlg_logout_cashin.create(p, true);
                nd.setTitle("");
                nd.do_pass(drawer);
                nd.setCallback(new Dlg_logout_cashin.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_logout_cashin.OutputData data) {
                        closeDialog.ok();

                        double cashin = data.cashin;
                        double thousand = data.thousand;
                        double five_hundred = data.five_hundred;
                        double two_hundred = data.two_hundred;
                        double one_hundred = data.one_hundred;
                        double fifty = data.fifty;
                        double twenty = data.twenty;
                        double ten = data.ten;
                        double five = data.five;
                        double one = data.one;
                        double point_fifty = data.point_fifty;
                        double point_twenty_five = data.point_twenty_five;
                        double point_ten = data.point_ten;
                        double point_five = data.point_five;
                        int id = data.cashdrawer_id;
                        String session_no = drawer.session_no;

                        String user_name = drawer.user_name;
                        String screen_name = drawer.user_screen_name;
                        String time_in = drawer.time_in;
                        String time_out = DateType.now();
                        double amount = data.cashin;
                        double cash_out = 0;
                        double coins = 0;
                        double expenses = 0;
                        double point_two_five = point_twenty_five;
                        double point_zero_five = point_five;

                        String branch = drawer.branch;
                        String branch_id = drawer.branch_id;
                        String location = drawer.location;
                        String location_id = drawer.location_id;
                        String user_id = drawer.user_id;
                        String user_screen_name = drawer.user_screen_name;
                        int lock_session = 0;
                        CashDrawer.to_cash_drawer to = new CashDrawer.to_cash_drawer(id, session_no, user_name, screen_name, time_in,
                                                                                     time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins,
                                                                                     one_hundred, expenses, ten, five, one, point_fifty, point_twenty_five, point_ten, point_zero_five, branch, branch_id, location, location_id, user_id, user_screen_name, lock_session);

                        String date = DateType.sf.format(new Date());
                        CashDrawer.update_data(to, "" + id);
                        Alert.set(2, "");
//                        ok3(stmt);
                    }
                });
                Center.setCenter(nd);
                nd.setVisible(true);
            } else {
//                ok3("");
            }

        }
    }
}
