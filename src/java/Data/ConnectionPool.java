/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author shrut
 */
public class ConnectionPool {
    
         public Connection getConnection() throws ClassNotFoundException, SQLException
     {
//        Class.forName("com.mysql.jdbc.Driver");
//        String dbName = "HMS";
//         String userName = "root";
//        String password = "root";
//         String hostname = "localhost";
//         String port = "3306";
//         String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
//         return DriverManager.getConnection(jdbcUrl);
         
         Class.forName("com.mysql.jdbc.Driver");
         String dbName = "HMS";
         String userName = "skashya1";
         String password = "Kashyap082";
         String hostname = "mydb2.cyy9wexp5yah.us-east-1.rds.amazonaws.com";
         String port = "3306";
         String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
         return DriverManager.getConnection(jdbcUrl);
     }
}
