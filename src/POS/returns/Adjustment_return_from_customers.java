/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.returns;

import java.util.List;

/**
 *
 * @author User
 */
public class Adjustment_return_from_customers {

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_algorithm");
//        System.setProperty("pool_host", "192.168.1.51");
        List<Return_from_customer_items.to_return_from_customer_items> items = Return_from_customer_items.ret_data("");
        for (Return_from_customer_items.to_return_from_customer_items item : items) {
            System.out.println(item.reference_no);
            int id = item.id;
            String return_from_customer_no = Return_from_customers.increment_id(item.location_id);
            String user_name = item.user_name;
            String session_no = item.session_no;
            String date_added = item.date_added;
            String supplier = item.supplier;
            String supplier_id = item.supplier_id;
            String reference_no = item.reference_no;
            String remarks = item.remarks;
            int status = item.status;
            String branch = item.branch;
            String branch_id = item.branch_id;
            String location = item.location;
            String location_id = item.location_id;
            double gross_total = item.cash;
            String discount = "";
            double discount_amount = 0;
            double discount_rate = 0;
            double cash = item.cash;
            String prepaid_customer_name = "";
            String prepaid_customer_id = "";
            double prepaid_amount = 0;
            String charge_reference_no = "";
            String charge_ar_no = "";
            String charge_type = "";
            String charge_customer_name = "";
            String charge_customer_id = "";
            double charge_amount = 0;
            int charge_days = 0;
            Return_from_customers.to_return_from_customers to = new Return_from_customers.to_return_from_customers(id, return_from_customer_no, user_name,
                                                                                                                   session_no, date_added, supplier, supplier_id, reference_no, remarks, status, branch, branch_id, location,
                                                                                                                   location_id, gross_total, discount, discount_amount, discount_rate, prepaid_customer_name, prepaid_customer_id, prepaid_amount, charge_reference_no, charge_ar_no, charge_type, charge_customer_name, charge_customer_id, charge_amount, charge_days, cash);
            Return_from_customers.add_data(to);
            Return_from_customers.update_trans_no(id, return_from_customer_no);

        }
    }
}
