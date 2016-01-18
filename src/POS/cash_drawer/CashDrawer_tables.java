/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.util.DateType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Guinness
 */
public class CashDrawer_tables {

    //<editor-fold defaultstate="collapsed" desc=" credit card ">
    public static ArrayListModel tbl_cash_drawer_credit_cards_ALM;
    public static Tblcash_drawer_credit_cardsModel tbl_cash_drawer_credit_cards_M;

    public static void init_tbl_cash_drawer_credit_cards(JTable tbl_cash_drawer_credit_cards) {
        tbl_cash_drawer_credit_cards_ALM = new ArrayListModel();
        tbl_cash_drawer_credit_cards_M = new Tblcash_drawer_credit_cardsModel(tbl_cash_drawer_credit_cards_ALM);
        tbl_cash_drawer_credit_cards.setModel(tbl_cash_drawer_credit_cards_M);
        tbl_cash_drawer_credit_cards.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_credit_cards.setRowHeight(25);
        int[] tbl_widths_cash_drawer_credit_cards = {100, 100, 120, 80, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_credit_cards.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_credit_cards, i, tbl_widths_cash_drawer_credit_cards[i]);
        }
        Dimension d = tbl_cash_drawer_credit_cards.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer_credit_cards.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer_credit_cards.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer_credit_cards.setRowHeight(25);
        tbl_cash_drawer_credit_cards.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_credit_cards, 3);
    }

    public static void loadData_cash_drawer_credit_cards(List<CashDrawer_credit_cards.to_cash_drawer_credit_cards> acc) {
        tbl_cash_drawer_credit_cards_ALM.clear();
        tbl_cash_drawer_credit_cards_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_credit_cardsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Holder", "Card", "Approval Code", "Amount", "credit_card_type", "credit_card_rate", "credit_card_amount", "credit_card_no", "credit_card_holder", "credit_card_approval_code"
        };

        public Tblcash_drawer_credit_cardsModel(ListModel listmodel) {
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
            CashDrawer_credit_cards.to_cash_drawer_credit_cards tt = (CashDrawer_credit_cards.to_cash_drawer_credit_cards) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.credit_card_holder;
                case 1:
                    return " " + tt.credit_card_type;
                case 2:
                    return " " + tt.credit_card_approval_code;
                case 3:
                    return FitIn.fmt_wc_0(tt.credit_card_amount) + " ";
                case 4:
                    return tt.credit_card_type;
                case 5:
                    return tt.credit_card_rate;
                case 6:
                    return tt.credit_card_amount;
                case 7:
                    return tt.credit_card_no;
                case 8:
                    return tt.credit_card_holder;
                default:
                    return tt.credit_card_approval_code;
            }
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" cash_drawer_gift_certificates "> 
    public static ArrayListModel tbl_cash_drawer_gift_certificates_ALM;
    public static Tblcash_drawer_gift_certificatesModel tbl_cash_drawer_gift_certificates_M;

    public static void init_tbl_cash_drawer_gift_certificates(JTable tbl_cash_drawer_gift_certificates) {
        tbl_cash_drawer_gift_certificates_ALM = new ArrayListModel();
        tbl_cash_drawer_gift_certificates_M = new Tblcash_drawer_gift_certificatesModel(tbl_cash_drawer_gift_certificates_ALM);
        tbl_cash_drawer_gift_certificates.setModel(tbl_cash_drawer_gift_certificates_M);
        tbl_cash_drawer_gift_certificates.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_gift_certificates.setRowHeight(25);
        int[] tbl_widths_cash_drawer_gift_certificates = {100, 120, 100, 100, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_gift_certificates.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_gift_certificates, i, tbl_widths_cash_drawer_gift_certificates[i]);
        }
        Dimension d = tbl_cash_drawer_gift_certificates.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer_gift_certificates.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer_gift_certificates.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer_gift_certificates.setRowHeight(25);
        tbl_cash_drawer_gift_certificates.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_gift_certificates, 3);
    }

    public static void loadData_cash_drawer_gift_certificates(List<CashDrawer_gift_certificates.to_cash_drawer_gift_certificates> acc) {
        tbl_cash_drawer_gift_certificates_ALM.clear();
        tbl_cash_drawer_gift_certificates_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_gift_certificatesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "From", "Description", "No", "Amount", "gc_from", "gc_description", "gc_no", "amount"
        };

        public Tblcash_drawer_gift_certificatesModel(ListModel listmodel) {
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
            CashDrawer_gift_certificates.to_cash_drawer_gift_certificates tt = (CashDrawer_gift_certificates.to_cash_drawer_gift_certificates) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.gc_from;
                case 1:
                    return " " + tt.gc_description;
                case 2:
                    return " " + tt.gc_no;
                case 3:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 4:
                    return tt.gc_from;
                case 5:
                    return tt.gc_description;
                case 6:
                    return tt.gc_no;
                default:
                    return tt.amount;
            }
        }
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" cash_drawer_prepaids "> 
    public static ArrayListModel tbl_cash_drawer_prepaids_ALM;
    public static Tblcash_drawer_prepaidsModel tbl_cash_drawer_prepaids_M;

    public static void init_tbl_cash_drawer_prepaids(JTable tbl_cash_drawer_prepaids) {
        tbl_cash_drawer_prepaids_ALM = new ArrayListModel();
        tbl_cash_drawer_prepaids_M = new Tblcash_drawer_prepaidsModel(tbl_cash_drawer_prepaids_ALM);
        tbl_cash_drawer_prepaids.setModel(tbl_cash_drawer_prepaids_M);
        tbl_cash_drawer_prepaids.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_prepaids.setRowHeight(25);
        int[] tbl_widths_cash_drawer_prepaids = {80, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_prepaids.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_prepaids, i, tbl_widths_cash_drawer_prepaids[i]);
        }
        Dimension d = tbl_cash_drawer_prepaids.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer_prepaids.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer_prepaids.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer_prepaids.setRowHeight(25);
        tbl_cash_drawer_prepaids.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_prepaids, 3);
    }

    public static void loadData_cash_drawer_prepaids(List<CashDrawer_prepaids.to_cash_drawer_prepaids> acc) {
        tbl_cash_drawer_prepaids_ALM.clear();
        tbl_cash_drawer_prepaids_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_prepaidsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Customer", "Type", "Amount", "customer_name", "customer_id", "cash_amount", "cheque_amount", "cheque_holder", "cheque_bank", "cheque_no"
        };

        public Tblcash_drawer_prepaidsModel(ListModel listmodel) {
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
            CashDrawer_prepaids.to_cash_drawer_prepaids tt = (CashDrawer_prepaids.to_cash_drawer_prepaids) getRow(row);
            switch (col) {
                case 0:
                    if (tt.cash_amount == 0) {
                        return DateType.convert_slash_datetime2(tt.cheque_date);
                    } else {
                        return "";
                    }

                case 1:
                    return " " + tt.customer_name;

                case 2:
                    if (tt.cash_amount == 0) {
                        return " Cheque";
                    } else {
                        return " Cash";
                    }
                case 3:
                    if (tt.cash_amount == 0) {
                        return FitIn.fmt_wc_0(tt.cheque_amount) + " ";
                    } else {
                        return FitIn.fmt_wc_0(tt.cash_amount) + " ";
                    }
                case 4:
                    return tt.customer_name;
                case 5:
                    return tt.customer_id;
                case 6:
                    return tt.cash_amount;
                case 7:
                    return tt.cheque_amount;
                case 8:
                    return tt.cheque_holder;
                case 9:
                    return tt.cheque_bank;
                default:
                    return tt.cheque_no;
            }
        }
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" cash_drawer_cheques "> 
    public static ArrayListModel tbl_cash_drawer_cheques_ALM;
    public static Tblcash_drawer_chequesModel tbl_cash_drawer_cheques_M;

    public static void init_tbl_cash_drawer_cheques(JTable tbl_cash_drawer_cheques) {
        tbl_cash_drawer_cheques_ALM = new ArrayListModel();
        tbl_cash_drawer_cheques_M = new Tblcash_drawer_chequesModel(tbl_cash_drawer_cheques_ALM);
        tbl_cash_drawer_cheques.setModel(tbl_cash_drawer_cheques_M);
        tbl_cash_drawer_cheques.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_cheques.setRowHeight(25);
        int[] tbl_widths_cash_drawer_cheques = {100, 100, 100, 100, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_cheques.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_cheques, i, tbl_widths_cash_drawer_cheques[i]);
        }
        Dimension d = tbl_cash_drawer_cheques.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer_cheques.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer_cheques.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer_cheques.setRowHeight(25);
        tbl_cash_drawer_cheques.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_cheques, 3);
    }

    public static void loadData_cash_drawer_cheques(List<CashDrawer_cheques.to_cash_drawer_cheques> acc) {
        tbl_cash_drawer_cheques_ALM.clear();
        tbl_cash_drawer_cheques_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_chequesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Bank", "Cheque No", "Amount", "cheque_bank", "cheque_no", "cheque_amount"
        };

        public Tblcash_drawer_chequesModel(ListModel listmodel) {
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
            CashDrawer_cheques.to_cash_drawer_cheques tt = (CashDrawer_cheques.to_cash_drawer_cheques) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime2(tt.cheque_date);
                case 1:
                    return " " + tt.cheque_bank;
                case 2:
                    return " " + tt.cheque_no;
                case 3:
                    return FitIn.fmt_wc_0(tt.cheque_amount) + " ";
                case 4:
                    return tt.cheque_bank;
                case 5:
                    return tt.cheque_no;
                default:
                    return tt.cheque_amount;
            }
        }
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" cash_drawer_accounts_receivables "> 
    public static ArrayListModel tbl_cash_drawer_accounts_receivables_ALM;
    public static Tblcash_drawer_accounts_receivablesModel tbl_cash_drawer_accounts_receivables_M;

    public static void init_tbl_cash_drawer_accounts_receivables(JTable tbl_cash_drawer_accounts_receivables) {
        tbl_cash_drawer_accounts_receivables_ALM = new ArrayListModel();
        tbl_cash_drawer_accounts_receivables_M = new Tblcash_drawer_accounts_receivablesModel(tbl_cash_drawer_accounts_receivables_ALM);
        tbl_cash_drawer_accounts_receivables.setModel(tbl_cash_drawer_accounts_receivables_M);
        tbl_cash_drawer_accounts_receivables.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_accounts_receivables.setRowHeight(25);
        int[] tbl_widths_cash_drawer_accounts_receivables = {100, 100, 100, 70, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_accounts_receivables.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_accounts_receivables, i, tbl_widths_cash_drawer_accounts_receivables[i]);
        }
        Dimension d = tbl_cash_drawer_accounts_receivables.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer_accounts_receivables.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer_accounts_receivables.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer_accounts_receivables.setRowHeight(25);
        tbl_cash_drawer_accounts_receivables.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_accounts_receivables, 4);
    }

    public static void loadData_cash_drawer_accounts_receivables(List<CashDrawer_account_receivables.to_cash_drawer_accounts_receivables> acc) {
        tbl_cash_drawer_accounts_receivables_ALM.clear();
        tbl_cash_drawer_accounts_receivables_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_accounts_receivablesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Type", "Reference No", "Customer", "Payment", "Amount", "charge_type", "reference_no", "customer_id", "customer_name", "cash_amount", "cheque_amount", "check_holder", "cheque_bank", "cheque_no"
        };

        public Tblcash_drawer_accounts_receivablesModel(ListModel listmodel) {
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
            CashDrawer_account_receivables.to_cash_drawer_accounts_receivables tt = (CashDrawer_account_receivables.to_cash_drawer_accounts_receivables) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.charge_type;
                case 1:
                    return " " + tt.reference_no;
                case 2:
                    return " " + tt.customer_name;
                case 3:
                    if (tt.cash_amount == 0) {
                        return " Cheque";
                    } else {
                        return " Cash";
                    }

                case 4:
                    if (tt.cash_amount == 0) {
                        return FitIn.fmt_wc_0(tt.cheque_amount) + " ";
                    } else {
                        return FitIn.fmt_wc_0(tt.cash_amount) + " ";
                    }

                case 5:
                    return tt.charge_type;
                case 6:
                    return tt.reference_no;
                case 7:
                    return tt.customer_id;
                case 8:
                    return tt.customer_name;
                case 9:
                    return tt.cash_amount;
                case 10:
                    return tt.cheque_amount;
                case 11:
                    return tt.check_holder;
                case 12:
                    return tt.cheque_bank;
                default:
                    return tt.cheque_no;
            }
        }
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" cash_drawer_remittances "> 
    public static ArrayListModel tbl_cash_drawer_remittances_ALM;
    public static Tblcash_drawer_remittancesModel tbl_cash_drawer_remittances_M;

    public static void init_tbl_cash_drawer_remittances(JTable tbl_cash_drawer_remittances) {
        tbl_cash_drawer_remittances_ALM = new ArrayListModel();
        tbl_cash_drawer_remittances_M = new Tblcash_drawer_remittancesModel(tbl_cash_drawer_remittances_ALM);
        tbl_cash_drawer_remittances.setModel(tbl_cash_drawer_remittances_M);
        tbl_cash_drawer_remittances.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_remittances.setRowHeight(25);
        int[] tbl_widths_cash_drawer_remittances = {100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_remittances.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_remittances, i, tbl_widths_cash_drawer_remittances[i]);
        }
        Dimension d = tbl_cash_drawer_remittances.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer_remittances.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer_remittances.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer_remittances.setRowHeight(25);
        tbl_cash_drawer_remittances.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_remittances, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_remittances, 3);
    }

    public static void loadData_cash_drawer_remittances(List<CashDrawer_remittances.to_cash_drawer_remittances> acc) {
        tbl_cash_drawer_remittances_ALM.clear();
        tbl_cash_drawer_remittances_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_remittancesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Name", "Cash", "Cheque", "cash_amount", "cheque_amount", "cheque_holder", "cheque_bank", "cheque_no", "cheque_date", "status"
        };

        public Tblcash_drawer_remittancesModel(ListModel listmodel) {
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
            CashDrawer_remittances.to_cash_drawer_remittances tt = (CashDrawer_remittances.to_cash_drawer_remittances) getRow(row);
            switch (col) {
                case 0:
                    if (tt.cash_amount > 0) {
                        return "";
                    } else {
                        return " " + DateType.convert_slash_datetime2(tt.cheque_date);
                    }

                case 1:
                    if (tt.cash_amount > 0) {
                        return "";
                    } else {
                        return " " + tt.cheque_holder;
                    }

                case 2:
                    return FitIn.fmt_wc_0(tt.cash_amount) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.cheque_amount) + " ";
                case 4:
                    return tt.cash_amount;
                case 5:
                    return tt.cheque_amount;
                case 6:
                    return tt.cheque_holder;
                case 7:
                    return tt.cheque_bank;
                case 8:
                    return tt.cheque_no;
                case 9:
                    return tt.cheque_date;
                default:
                    return tt.status;
            }
        }
    }
//</editor-fold> 

}
