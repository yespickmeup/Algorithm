/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branch_locations;

import POS.branch_locations.S1_branch_locations.to_branch_locations;
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
public class S2_branch_locations {

    public static List<to_branch_locations> ret_all_locations() {
        List<to_branch_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);

                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<to_branch_locations> datas = ret_all_locations();
        for (to_branch_locations to : datas) {
            System.out.println(to.location);
        }
    }
}
