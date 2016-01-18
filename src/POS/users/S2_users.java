/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.users.S1_users.to_users;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class S2_users {

    public static List<to_users> ret_data(String search) {
        List<to_users> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from users "
                    + " where screen_name like '%" + search + "%'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
            
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_users> ret_where(String where) {
        List<to_users> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from users  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
              
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_users> ret_where2(String where) {
        List<to_users> datas = new ArrayList();

        to_users to2 = new to_users(0, "All", "", "", 0, "", 0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from users  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
               
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
