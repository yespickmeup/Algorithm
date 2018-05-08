/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_services;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class My_services {

    public static class to_my_services {

        public final int id;
        public final String transaction_no;
        public final String service_slip_no;
        public final String serviced_by;
        public final String service_by_id;
        public final String department_manager;
        public final String department_manager_id;
        public final String department;
        public final String department_id;
        public final String customer_name;
        public final String customer_id;
        public final double qty;
        public final String unit;
        public final String description;
        public final String problem;
        public final String date_received;
        public final String date_assigned;
        public final String date_released;
        public final String added_by;
        public final String remarks;
        public final int status;
        public final String service_type;
        public final String service_type_id;
        public final double amount;
        public final String cashier;
        public final String cashier_id;
        public boolean selected;
        public final String user_id;
        public final String user_screen_name;
        public final String customer_contact_no;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_my_services(int id, String transaction_no, String service_slip_no, String serviced_by, String service_by_id, String department_manager, String department_manager_id, String department, String department_id, String customer_name, String customer_id, double qty, String unit, String description, String problem, String date_received, String date_assigned, String date_released, String added_by, String remarks, int status, String service_type, String service_type_id, double amount, String cashier, String cashier_id, boolean selected, String user_id, String user_screen_name, String customer_contact_no, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.transaction_no = transaction_no;
            this.service_slip_no = service_slip_no;
            this.serviced_by = serviced_by;
            this.service_by_id = service_by_id;
            this.department_manager = department_manager;
            this.department_manager_id = department_manager_id;
            this.department = department;
            this.department_id = department_id;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.qty = qty;
            this.unit = unit;
            this.description = description;
            this.problem = problem;
            this.date_received = date_received;
            this.date_assigned = date_assigned;
            this.date_released = date_released;
            this.added_by = added_by;
            this.remarks = remarks;
            this.status = status;
            this.service_type = service_type;
            this.service_type_id = service_type_id;
            this.amount = amount;
            this.cashier = cashier;
            this.cashier_id = cashier_id;
            this.selected = selected;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.customer_contact_no = customer_contact_no;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_my_services(to_my_services to_my_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services("
                    + "transaction_no"
                    + ",service_slip_no"
                    + ",serviced_by"
                    + ",service_by_id"
                    + ",department_manager"
                    + ",department_manager_id"
                    + ",department"
                    + ",department_id"
                    + ",customer_name"
                    + ",customer_id"
                    + ",qty"
                    + ",unit"
                    + ",description"
                    + ",problem"
                    + ",date_received"
                    + ",date_assigned"
                    + ",date_released"
                    + ",added_by"
                    + ",remarks"
                    + ",status"
                    + ",service_type"
                    + ",service_type_id"
                    + ",amount"
                    + ",cashier"
                    + ",cashier_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",customer_contact_no"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":transaction_no"
                    + ",:service_slip_no"
                    + ",:serviced_by"
                    + ",:service_by_id"
                    + ",:department_manager"
                    + ",:department_manager_id"
                    + ",:department"
                    + ",:department_id"
                    + ",:customer_name"
                    + ",:customer_id"
                    + ",:qty"
                    + ",:unit"
                    + ",:description"
                    + ",:problem"
                    + ",:date_received"
                    + ",:date_assigned"
                    + ",:date_released"
                    + ",:added_by"
                    + ",:remarks"
                    + ",:status"
                    + ",:service_type"
                    + ",:service_type_id"
                    + ",:amount"
                    + ",:cashier"
                    + ",:cashier_id"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:customer_contact_no"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_my_services.transaction_no)
                    .setString("service_slip_no", to_my_services.service_slip_no)
                    .setString("serviced_by", to_my_services.serviced_by)
                    .setString("service_by_id", to_my_services.service_by_id)
                    .setString("department_manager", to_my_services.department_manager)
                    .setString("department_manager_id", to_my_services.department_manager_id)
                    .setString("department", to_my_services.department)
                    .setString("department_id", to_my_services.department_id)
                    .setString("customer_name", to_my_services.customer_name)
                    .setString("customer_id", to_my_services.customer_id)
                    .setNumber("qty", to_my_services.qty)
                    .setString("unit", to_my_services.unit)
                    .setString("description", to_my_services.description)
                    .setString("problem", to_my_services.problem)
                    .setString("date_received", to_my_services.date_received)
                    .setString("date_assigned", to_my_services.date_assigned)
                    .setString("date_released", to_my_services.date_released)
                    .setString("added_by", to_my_services.added_by)
                    .setString("remarks", to_my_services.remarks)
                    .setNumber("status", to_my_services.status)
                    .setString("service_type", to_my_services.service_type)
                    .setString("service_type_id", to_my_services.service_type_id)
                    .setNumber("amount", to_my_services.amount)
                    .setString("cashier", to_my_services.cashier)
                    .setString("cashier_id", to_my_services.cashier_id)
                    .setString("user_id", to_my_services.user_id)
                    .setString("user_screen_name", to_my_services.user_screen_name)
                    .setString("customer_contact_no", to_my_services.customer_contact_no)
                    .setString("branch", to_my_services.branch)
                    .setString("branch_id", to_my_services.branch_id)
                    .setString("location", to_my_services.location)
                    .setString("location_id", to_my_services.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_my_services_cloud(to_my_services to_my_services) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);

            String s0 = "insert into my_services("
                    + "transaction_no"
                    + ",service_slip_no"
                    + ",serviced_by"
                    + ",service_by_id"
                    + ",department_manager"
                    + ",department_manager_id"
                    + ",department"
                    + ",department_id"
                    + ",customer_name"
                    + ",customer_id"
                    + ",qty"
                    + ",unit"
                    + ",description"
                    + ",problem"
                    + ",date_received"
                    + ",date_assigned"
                    + ",date_released"
                    + ",added_by"
                    + ",remarks"
                    + ",status"
                    + ",service_type"
                    + ",service_type_id"
                    + ",amount"
                    + ",cashier"
                    + ",cashier_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",customer_contact_no"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":transaction_no"
                    + ",:service_slip_no"
                    + ",:serviced_by"
                    + ",:service_by_id"
                    + ",:department_manager"
                    + ",:department_manager_id"
                    + ",:department"
                    + ",:department_id"
                    + ",:customer_name"
                    + ",:customer_id"
                    + ",:qty"
                    + ",:unit"
                    + ",:description"
                    + ",:problem"
                    + ",:date_received"
                    + ",:date_assigned"
                    + ",:date_released"
                    + ",:added_by"
                    + ",:remarks"
                    + ",:status"
                    + ",:service_type"
                    + ",:service_type_id"
                    + ",:amount"
                    + ",:cashier"
                    + ",:cashier_id"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:customer_contact_no"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_my_services.transaction_no)
                    .setString("service_slip_no", to_my_services.service_slip_no)
                    .setString("serviced_by", to_my_services.serviced_by)
                    .setString("service_by_id", to_my_services.service_by_id)
                    .setString("department_manager", to_my_services.department_manager)
                    .setString("department_manager_id", to_my_services.department_manager_id)
                    .setString("department", to_my_services.department)
                    .setString("department_id", to_my_services.department_id)
                    .setString("customer_name", to_my_services.customer_name)
                    .setString("customer_id", to_my_services.customer_id)
                    .setNumber("qty", to_my_services.qty)
                    .setString("unit", to_my_services.unit)
                    .setString("description", to_my_services.description)
                    .setString("problem", to_my_services.problem)
                    .setString("date_received", to_my_services.date_received)
                    .setString("date_assigned", to_my_services.date_assigned)
                    .setString("date_released", to_my_services.date_released)
                    .setString("added_by", to_my_services.added_by)
                    .setString("remarks", to_my_services.remarks)
                    .setNumber("status", to_my_services.status)
                    .setString("service_type", to_my_services.service_type)
                    .setString("service_type_id", to_my_services.service_type_id)
                    .setNumber("amount", to_my_services.amount)
                    .setString("cashier", to_my_services.cashier)
                    .setString("cashier_id", to_my_services.cashier_id)
                    .setString("user_id", to_my_services.user_id)
                    .setString("user_screen_name", to_my_services.user_screen_name)
                    .setString("customer_contact_no", to_my_services.customer_contact_no)
                    .setString("branch", to_my_services.branch)
                    .setString("branch_id", to_my_services.branch_id)
                    .setString("location", to_my_services.location)
                    .setString("location_id", to_my_services.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update my_services set is_uploaded=1 where id='" + to_my_services.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(My_services.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services(to_my_services to_my_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services set "
                    + "transaction_no= :transaction_no"
                    + ",service_slip_no= :service_slip_no"
                    + ",serviced_by= :serviced_by"
                    + ",service_by_id= :service_by_id"
                    + ",department_manager= :department_manager"
                    + ",department_manager_id= :department_manager_id"
                    + ",department= :department"
                    + ",department_id= :department_id"
                    + ",customer_name= :customer_name"
                    + ",customer_id= :customer_id"
                    + ",qty= :qty"
                    + ",unit= :unit"
                    + ",description= :description"
                    + ",problem= :problem"
                    + ",date_received= :date_received"
                    + ",date_assigned= :date_assigned"
                    + ",date_released= :date_released"
                    + ",added_by= :added_by"
                    + ",remarks= :remarks"
                    + ",status= :status"
                    + ",service_type= :service_type"
                    + ",service_type_id= :service_type_id"
                    + ",amount= :amount"
                    + ",cashier= :cashier"
                    + ",cashier_id= :cashier_id"
                    + ",user_id= :user_id"
                    + ",user_screen_name= :user_screen_name"
                    + ",customer_contact_no= :customer_contact_no"
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where "
                    + " id ='" + to_my_services.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_my_services.transaction_no)
                    .setString("service_slip_no", to_my_services.service_slip_no)
                    .setString("serviced_by", to_my_services.serviced_by)
                    .setString("service_by_id", to_my_services.service_by_id)
                    .setString("department_manager", to_my_services.department_manager)
                    .setString("department_manager_id", to_my_services.department_manager_id)
                    .setString("department", to_my_services.department)
                    .setString("department_id", to_my_services.department_id)
                    .setString("customer_name", to_my_services.customer_name)
                    .setString("customer_id", to_my_services.customer_id)
                    .setNumber("qty", to_my_services.qty)
                    .setString("unit", to_my_services.unit)
                    .setString("description", to_my_services.description)
                    .setString("problem", to_my_services.problem)
                    .setString("date_received", to_my_services.date_received)
                    .setString("date_assigned", to_my_services.date_assigned)
                    .setString("date_released", to_my_services.date_released)
                    .setString("added_by", to_my_services.added_by)
                    .setString("remarks", to_my_services.remarks)
                    .setNumber("status", to_my_services.status)
                    .setString("service_type", to_my_services.service_type)
                    .setString("service_type_id", to_my_services.service_type_id)
                    .setNumber("amount", to_my_services.amount)
                    .setString("cashier", to_my_services.cashier)
                    .setString("cashier_id", to_my_services.cashier_id)
                    .setString("user_id", to_my_services.user_id)
                    .setString("user_screen_name", to_my_services.user_screen_name)
                    .setString("customer_contact_no", to_my_services.customer_contact_no)
                    .setString("branch", to_my_services.branch)
                    .setString("branch_id", to_my_services.branch_id)
                    .setString("location", to_my_services.location)
                    .setString("location_id", to_my_services.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services(to_my_services to_my_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services where "
                    + " id ='" + to_my_services.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services.class, "Successfully Deleted");

            String s2 = "delete from my_services_description_customers where "
                    + " id ='" + to_my_services.transaction_no + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(My_services_description_customers.class, "Successfully Deleted");

            String s3 = "delete from my_services_problems_customers where "
                    + " id ='" + to_my_services.transaction_no + "' "
                    + " ";

            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();
            Lg.s(S1_my_services_problems_customers.class, "Successfully Deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services> ret_data(String where) {
        List<to_my_services> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",service_slip_no"
                    + ",serviced_by"
                    + ",service_by_id"
                    + ",department_manager"
                    + ",department_manager_id"
                    + ",department"
                    + ",department_id"
                    + ",customer_name"
                    + ",customer_id"
                    + ",qty"
                    + ",unit"
                    + ",description"
                    + ",problem"
                    + ",date_received"
                    + ",date_assigned"
                    + ",date_released"
                    + ",added_by"
                    + ",remarks"
                    + ",status"
                    + ",service_type"
                    + ",service_type_id"
                    + ",amount"
                    + ",cashier"
                    + ",cashier_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",customer_contact_no"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String service_slip_no = rs.getString(3);
                String serviced_by = rs.getString(4);
                String service_by_id = rs.getString(5);
                String department_manager = rs.getString(6);
                String department_manager_id = rs.getString(7);
                String department = rs.getString(8);
                String department_id = rs.getString(9);
                String customer_name = rs.getString(10);
                String customer_id = rs.getString(11);
                double qty = rs.getDouble(12);
                String unit = rs.getString(13);
                String description = rs.getString(14);
                String problem = rs.getString(15);
                String date_received = rs.getString(16);
                String date_assigned = rs.getString(17);
                String date_released = rs.getString(18);
                String added_by = rs.getString(19);
                String remarks = rs.getString(20);
                int status = rs.getInt(21);
                String service_type = rs.getString(22);
                String service_type_id = rs.getString(23);
                double amount = rs.getDouble(24);
                String cashier = rs.getString(25);
                String cashier_id = rs.getString(26);
                String user_id = rs.getString(27);
                String user_screen_name = rs.getString(28);
                String customer_contact_no = rs.getString(29);
                String branch = rs.getString(30);
                String branch_id = rs.getString(31);
                String location = rs.getString(32);
                String location_id = rs.getString(33);
                to_my_services to = new to_my_services(id, transaction_no, service_slip_no, serviced_by, service_by_id, department_manager, department_manager_id, department, department_id, customer_name, customer_id, qty, unit, description, problem, date_received, date_assigned, date_released, added_by, remarks, status, service_type, service_type_id, amount, cashier, cashier_id, false, user_id, user_screen_name, customer_contact_no, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id(String where) {
        String id = "000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from my_services " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select transaction_no from my_services where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void transfer_job(List<to_my_services> to_my_services1, String serviced_by, String service_by_id, String department_manager, String department_manager_id, String department, String department_id) {
        try {
            Connection conn = MyConnection.connect();
            for (to_my_services to_my_services : to_my_services1) {
                String s0 = "update my_services set "
                        + "serviced_by= :serviced_by"
                        + ",service_by_id= :service_by_id"
                        + ",department_manager= :department_manager"
                        + ",department_manager_id= :department_manager_id"
                        + ",department= :department"
                        + ",department_id= :department_id"
                        + " where "
                        + " id ='" + to_my_services.id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setString("serviced_by", serviced_by)
                        .setString("service_by_id", service_by_id)
                        .setString("department_manager", department_manager)
                        .setString("department_manager_id", department_manager_id)
                        .setString("department", department)
                        .setString("department_id", department_id)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(My_services.class, "Successfully Updated");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
