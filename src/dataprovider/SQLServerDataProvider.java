/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class SQLServerDataProvider {
    private Connection connection;
    public void open(){
        String strServer="DESKTOP-QFQ8VVD\\SQLEXPRESS";
        String strDatabase="QL_KD_DTDD";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://"+strServer
                    +":49210;databaseName="+strDatabase
                    +";user=sa; password=sa2012";
            connection=DriverManager.getConnection(connectionURL);
            
        } catch (Exception e) {
        }
    }
    public void close(){
        try {
            this.connection.close();
        } catch (Exception e) {
        }
    }
    public ResultSet executeQuery(String sql){
        ResultSet rs=null;
        try {
            Statement sm=connection.createStatement();
            rs=sm.executeQuery(sql);
        } catch (Exception e) {
        }
        return rs;
    }
    public int executeUpdate(String sql){
        int n=-1;
        try {
            Statement sm=connection.createStatement();
            n=sm.executeUpdate(sql);
        } catch (Exception e) {
        }
        return n;
    }
    public static void main(String[] args) {
        SQLServerDataProvider sdp=new SQLServerDataProvider();
        sdp.open();
    }
}
