/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriskgui;
import java.sql.*;
/**
 *
 * @author hamza
 */
public class ERiskGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "com.mysql.jdbc.Driver"; 
        String connectSql = "jdbc:mysql://localhost:3306/aggragateddatasetfeatures";
        String sqlUser = "root";
        String sqlPasswd = "";

        Connection con = null;
        PreparedStatement psm = null;
        ResultSet rs = null;

        try {
            Class.forName(url);
            con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
            psm = con.prepareStatement("select * from aggregatedchunk1");
            rs = psm.executeQuery();
            System.out.println("Uid" + "\t\t" + "Im Frequency" + "\t\t\t" + "Like Frequency" + "\t\t\t" + "People Frequency");
            while (rs.next()) {
                System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t\t"+rs.getDouble(3)+"\t\t\t"+rs.getDouble(4));
            }

            rs.close();
            psm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error：" + e.getMessage());
        }
    }
    
}
