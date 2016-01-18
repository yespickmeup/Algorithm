/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.sql.*;

/**
 *
 * @author i1
 */
public class Add_table_id {

    public static void main(String[] args) {
        System.out.println("Listing all table name in Database!");
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/";
        String db = "pisps_dbo";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "password";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, pass);

            DatabaseMetaData dbm = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbm.getTables(null, null, "%", types);
            System.out.println("Table name:");
            while (rs.next()) {
                String table = rs.getString("TABLE_NAME");
                System.out.println("TABLE: " + table );
                System.out.println("=================================");
                Statement st = con.createStatement();
                ResultSet rs2 = st.executeQuery("SELECT * FROM " + table);
                ResultSetMetaData md = rs2.getMetaData();
                int col = md.getColumnCount();
                String f_column = "";
                int exists = 0;
                for (int i = 1; i <= col; i++) {
                    String col_name = md.getColumnName(i);
                    String pkey = ""+md.isDefinitelyWritable(i);
                    if (i == 1) {
                        f_column = col_name;
                    }
                    System.out.println(" " + col_name + " : "+pkey);
                    if (col_name.equalsIgnoreCase("code2")) {
                        exists = 1;
                    }
                }
                if (exists ==1) {
//                    String s0 = "alter table " + table + " add branch_code2 varchar(100)";
                     String s0 = "alter table " + table + " drop code2";
                    PreparedStatement stmt = con.prepareStatement(s0);
                    stmt.execute();
//                    
//                    String s2= "update " + table + " set branch_code2=branch_code;";
//                      String s2= "alter table " + table + " change code2 code varchar(100);";
//                    PreparedStatement stmt2 = con.prepareStatement(s2);
//                    stmt2.execute();
                    
                }else{
//                    String s0 = "alter table " + table + " add id int auto_increment primary key;";
//                    PreparedStatement stmt = con.prepareStatement(s0);
//                    stmt.execute();
                }


                System.out.println("=================================");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
