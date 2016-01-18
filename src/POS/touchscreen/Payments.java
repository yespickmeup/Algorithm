/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Payments {

    public static cash cash;
    public static credit_card credit_card;
    public static gift_certificate gift_certificate;
    public static prepaid prepaid;
    public static cheque cheque;
    public static charge charge;
    public static double change;
    public static double balance_due;

    public Payments(cash cash, credit_card credit_card, gift_certificate gift_certificate, prepaid prepaid, cheque cheque, charge charge) {
        Payments.cash = cash;
        Payments.credit_card = credit_card;
        Payments.gift_certificate = gift_certificate;
        Payments.prepaid = prepaid;
        Payments.cheque = cheque;
        Payments.charge = charge;
    }

    public static void clearAll() {
        Payments.clearCash();
        Payments.clearCharge();
        Payments.clearCheque();
        Payments.clearGift_certificate();
        Payments.clearPrepaid();
        Payments.clear_credit_card();
    }

    public static double getChange() {
        return change;
    }

    public static void setChange(double change) {
        Payments.change = change;
    }

    public cash getCash() {
        return cash;
    }

    public void setCash(cash cash) {
        Payments.cash = cash;
    }

    public static void clearCash() {
        cash cash1 = new cash(0);
        Payments.cash = cash1;
    }

    public credit_card getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(credit_card credit_card) {
        Payments.credit_card = credit_card;
    }

    public static void clear_credit_card() {
        credit_card card = new credit_card("", 0, 0, 0, "", "", "");
        Payments.credit_card = card;
    }

    public gift_certificate getGift_certificate() {
        return gift_certificate;
    }

    public void setGift_certificate(gift_certificate gift_certificate) {
        Payments.gift_certificate = gift_certificate;
    }

    public static void clearGift_certificate() {
        gift_certificate gift = new gift_certificate("", "", "", 0);
        Payments.gift_certificate = gift;
    }

    public prepaid getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(prepaid prepaid) {
        Payments.prepaid = prepaid;
    }

    public static void clearPrepaid() {
        prepaid pre = new prepaid("", "", 0,0);
        Payments.prepaid = pre;
    }

    public cheque getCheque() {
        return cheque;
    }

    public void setCheque(cheque cheque) {
        Payments.cheque = cheque;
    }

    public static void clearCheque() {
        cheque ch = new cheque("", "", 0,"","");
        Payments.cheque = ch;
    }

    public charge getCharge() {
        return charge;
    }

    public void setCharge(charge charge) {
        Payments.charge = charge;
    }

    public static void clearCharge() {
        charge ch = new charge("", "", "", "", "", 0);
        Payments.charge = ch;
    }

    public static class cash {

        public double cash;

        public cash(double cash) {
            this.cash = cash;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

    }

    public static void main(String[] args) {

    }

    public static class credit_card {

        public final String card_type;
        public final double rate;
        public final double amount;
        public final double to_pay;
        public final String card_no;
        public final String card_holder;
        public final String approval_code;
        public credit_card(String card_type, double rate, double amount, double to_pay, String card_no, String card_holder, String approval_code) {
            this.card_type = card_type;
            this.rate = rate;
            this.amount = amount;
            this.to_pay = to_pay;
            this.card_no = card_no;
            this.card_holder = card_holder;
            this.approval_code = approval_code;
        }

    }

    public static class gift_certificate {

        public final String from;
        public final String description;
        public final String gc_no;
        public final double amount;

        public gift_certificate(String from, String description, String gc_no, double amount) {
            this.from = from;
            this.description = description;
            this.gc_no = gc_no;
            this.amount = amount;
        }

    }

    public static class prepaid {

        public final String customer_name;
        public final String customer_id;
        public final double amount;
        public final double balance;
        public prepaid(String customer_name, String customer_id, double amount,double balance) {
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.amount = amount;
            this.balance=balance;
        }

    }

    public static class cheque {

        public final String bank;
        public final String check_no;
        public final double amount;
        public final String check_holder;
        public final String check_date;
        public cheque(String bank, String check_no, double amount,String check_holder,String check_date) {
            this.bank = bank;
            this.check_no = check_no;
            this.amount = amount;
            this.check_holder=check_holder;
            this.check_date=check_date;
        }
    }

    public static class charge {

        public final String charge_type;
        public final String charge_type_id;
        public final String reference_no;
        public final String customer_name;
        public final String customer_id;
        public final double amount;

        public charge(String charge_type, String charge_type_id, String reference_no, String customer_name, String customer_id, double amount) {
            this.charge_type = charge_type;
            this.charge_type_id = charge_type_id;
            this.reference_no = reference_no;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.amount = amount;
        }
    }

    public static class discount {

        public final String discount_name;
        public final String customer_name;
        public final String customer_id;
        public final double rate;
        public final double amount;

        public discount(String discount_name, String customer_name, String customer_id, double rate, double amount) {
            this.discount_name = discount_name;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.rate = rate;
            this.amount = amount;
        }

    }

    public static double countChange() {
        cash c = cash;
        credit_card cc = credit_card;
        gift_certificate gc = gift_certificate;
        prepaid prep = prepaid;
        cheque cheq = cheque;
        charge charg = charge;
        double change1 = balance_due - (cash.cash + cc.amount + gc.amount + prep.amount + cheq.amount + charg.amount);
        return change1;
    }

    public static double countChange2() {
        cash c = cash;
        credit_card cc = credit_card;
        gift_certificate gc = gift_certificate;
        prepaid prep = prepaid;
        cheque cheq = cheque;
        charge charg = charge;    
        double change1 = (cash.cash + cc.amount + gc.amount + prep.amount + cheq.amount + charg.amount) - balance_due;
        return change1;
    }
}
