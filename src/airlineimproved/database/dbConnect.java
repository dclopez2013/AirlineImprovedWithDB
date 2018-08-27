/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlineimproved.database;
import java.sql.*;
import java.sql.*;
import java.sql.Connection;
import org.apache.derby.jdbc.ClientDataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dclop
 */
public class dbConnect {
    
    private ClientDataSource ds;
    private Connection conn;
    public dbConnect(){
        ds = new ClientDataSource();
        ds.setDatabaseName("airline");
        ds.setServerName("localhost");
        ds.setPortNumber(1527);
        ds.setUser("airline");
        ds.setPassword("password");
        ds.setDataSourceName("jdbc:derby");
    }
    
    
    private void Connect(){
        try {
            conn = ds.getConnection();
        } catch (SQLException ex) {
            System.out.println("Unable To connect");
        }
    }
    
    
    private void createUser(String entry){
       String query = entry;
       this.Connect();
       try{
           Statement s = this.getConn().createStatement();
           s.execute(query);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    
    private void deleteUser(String query){
    
    }
    
    private void getFlights(String query){
    
    }
    
    private void createFlight(String query){
    
    }
    private Connection getConn(){
        return this.conn;
    }
}
