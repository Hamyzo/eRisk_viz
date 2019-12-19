/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JENNIFER
 */
public class loop {

    public static void main(String[] args) {
        String url = "com.mysql.jdbc.Driver"; 
        String connectSql = "jdbc:mysql://localhost:3306/aggragateddatasetfeatures"; 
        String sqlUser = "root"; 
        String sqlPasswd = ""; 
        String path1 = "";
        String path2 = "";

        Connection con = null;
        PreparedStatement psm,psm1, psm2;
        ResultSet rs,rs1, rs2;

        try {
            Class.forName(url);
            con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);

            psm1 = con.prepareStatement("select uid from chunk1");
            psm2 = con.prepareStatement("select uid from chunk2");
            rs1 = psm1.executeQuery();
            rs2 = psm2.executeQuery();
            while (rs1.next()) {
                path1 = "../eRisk/test/chunk 1/" + rs1.getString(1) + "_1.xml";
                new getData(path1, "chunk1",con);
            }
            while (rs2.next()) {
                path2 = "../eRisk/test/chunk 2/" + rs2.getString(1) + "_2.xml";
                new getData(path2, "chunk2", con);
            }
            rs1.close();
            psm1.close();
            rs2.close();
            psm2.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error：" + e.getMessage());
        }
    }
}
