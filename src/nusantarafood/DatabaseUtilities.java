/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nusantarafood;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DatabaseUtilities {

    /**
     * @param args the command line arguments
     */
    private static Connection conn;
    
    public static Connection getConnection() {
        // TODO code application logic here
        if(conn==null){
            String url = "jdbc:mysql://localhost:3306/foodnesia";
            
            String user = "root";
            String password = "";
            
            try{
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);
                conn = DriverManager.getConnection(url,user,password);
                System.out.println("Connection success");
            }catch(SQLException ex){
                System.out.println("Connection failed\n" + ex.getMessage());
//                ex.printStackTrace();
            }
        }
        return conn;
    }
    
}
